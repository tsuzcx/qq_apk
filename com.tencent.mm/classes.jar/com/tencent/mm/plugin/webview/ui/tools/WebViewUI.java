package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView.FindListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.m.d.a;
import com.tencent.mm.m.d.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.c.f.24;
import com.tencent.mm.plugin.webview.c.f.59;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.c;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.f;
import com.tencent.mm.plugin.webview.model.ax.a;
import com.tencent.mm.plugin.webview.model.ax.f;
import com.tencent.mm.plugin.webview.model.ax.g;
import com.tencent.mm.plugin.webview.model.ax.j;
import com.tencent.mm.plugin.webview.model.ax.l;
import com.tencent.mm.plugin.webview.model.b.1;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.h;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.p;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.MPSmileyFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.c;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.MMWebView.b;
import com.tencent.mm.ui.widget.MMWebView.e;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.aa;
import com.tencent.xweb.ab;
import com.tencent.xweb.u;
import com.tencent.xweb.w;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebViewUI
  extends MMActivity
  implements View.OnCreateContextMenuListener, com.tencent.mm.plugin.webview.core.b, com.tencent.mm.plugin.webview.g.a.b, com.tencent.mm.plugin.webview.ui.tools.d.a.e, bh.a, MMWebView.e
{
  private static final Pattern ATA;
  private static final Pattern ATB;
  protected static int BhM;
  private static final ArrayList<e> Bhn;
  private static WebSettings.RenderPriority Bhs;
  private static Boolean Bin;
  public com.tencent.mm.plugin.webview.model.ax AMJ;
  protected com.tencent.mm.plugin.webview.core.h AMZ;
  public com.tencent.mm.plugin.webview.c.f AQP;
  protected com.tencent.mm.plugin.webview.stub.f ASw;
  private View BeB;
  final com.tencent.mm.plugin.webview.modeltools.a BeV;
  protected boolean BgD;
  protected MMFalseProgressBar BgE;
  public ProgressBar BgF;
  public com.tencent.mm.ui.base.p BgG;
  private g BgH;
  private ImageButton BgI;
  private ImageButton BgJ;
  protected View BgK;
  protected WebViewKeyboardLinearLayout BgL;
  protected FrameLayout BgM;
  public FrameLayout BgN;
  protected MovingImageButton BgO;
  protected boolean BgP;
  private boolean BgQ;
  protected com.tencent.mm.bp.a BgR;
  private WebViewInputFooter BgS;
  protected WebViewSearchContentInputFooter BgT;
  private boolean BgU;
  private boolean BgV;
  public String BgW;
  protected boolean BgX;
  protected boolean BgY;
  protected long BgZ;
  protected a BhA;
  protected com.tencent.mm.ui.widget.a.d BhB;
  protected View BhC;
  protected String BhD;
  private boolean BhE;
  private final boolean BhF;
  private boolean BhG;
  protected volatile boolean BhH;
  protected boolean BhI;
  private Map BhJ;
  private int BhK;
  public int BhL;
  public boolean BhN;
  private boolean BhO;
  private boolean BhP;
  protected boolean BhQ;
  protected volatile boolean BhR;
  private com.tencent.mm.plugin.webview.j.h BhS;
  private com.tencent.mm.plugin.webview.model.b BhT;
  protected com.tencent.mm.plugin.webview.modeltools.n BhU;
  protected h BhV;
  public i BhW;
  protected IUtils BhX;
  private WebViewClipBoardHelper BhY;
  protected com.tencent.mm.plugin.webview.c BhZ;
  private boolean Bha;
  private int Bhb;
  int Bhc;
  public boolean Bhd;
  private boolean Bhe;
  protected boolean Bhf;
  private boolean Bhg;
  protected boolean Bhh;
  protected int Bhi;
  protected byte[] Bhj;
  private boolean Bhk;
  private View Bhl;
  private com.tencent.mm.sdk.platformtools.av Bhm;
  private boolean Bho;
  private WebChromeClient.CustomViewCallback Bhp;
  protected w Bhq;
  private ProgressBar Bhr;
  private com.tencent.mm.plugin.webview.ui.tools.d.a.h Bht;
  private final com.tencent.mm.sdk.b.c<SendDataToH5FromMiniProgramEvent> Bhu;
  private boolean Bhv;
  protected HashMap<String, Boolean> Bhw;
  protected HashMap<String, String> Bhx;
  protected HashMap<String, ArrayList<d.b>> Bhy;
  protected HashMap<String, Boolean> Bhz;
  protected volatile String BiA;
  private WebChromeClient.CustomViewCallback BiB;
  public int BiC;
  protected volatile String Bia;
  protected volatile long Bib;
  protected HandOffURL Bic;
  public n Bid;
  com.tencent.mm.plugin.webview.ui.tools.b.a Bie;
  private boolean Bif;
  protected aa Big;
  private com.tencent.mm.sdk.b.c<sg> Bih;
  private com.tencent.mm.plugin.webview.ui.tools.widget.n Bii;
  private boolean Bij;
  private MPVideoPlayFullScreenView Bik;
  int Bil;
  private boolean Bim;
  protected View Bio;
  private View Bip;
  private com.tencent.mm.bp.a.b Biq;
  private boolean Bir;
  public final j Bis;
  public final com.tencent.mm.plugin.webview.ui.tools.media.d Bit;
  private boolean Biu;
  private View.OnLongClickListener Biv;
  protected boolean Biw;
  private View.OnLongClickListener Bix;
  protected View.OnLongClickListener Biy;
  private String Biz;
  public String dxF;
  private com.tencent.mm.ui.base.p fqw;
  public ap handler;
  public com.tencent.mm.plugin.webview.stub.e kxf;
  public com.tencent.mm.plugin.webview.e.g kxg;
  private final com.tencent.mm.plugin.webview.modeltools.d kxp;
  private int lDk;
  protected int mUE;
  protected int mUF;
  private int nbF;
  public String nha;
  public MMWebView nhy;
  protected com.tencent.mm.ui.widget.snackbar.a.b rPQ;
  protected int screenOrientation;
  protected String sessionId;
  public int sfB;
  public String sfC;
  private View sk;
  private long tlW;
  protected boolean vZK;
  
  static
  {
    AppMethodBeat.i(80400);
    Bhn = new ArrayList();
    Bhs = WebSettings.RenderPriority.NORMAL;
    BhM = 0;
    Bin = null;
    ATA = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    ATB = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    AppMethodBeat.o(80400);
  }
  
  public WebViewUI()
  {
    AppMethodBeat.i(80217);
    this.BgD = false;
    this.screenOrientation = -1;
    this.BgP = false;
    this.BgQ = false;
    this.BgW = null;
    this.BgX = true;
    this.BgY = false;
    this.BgZ = 0L;
    this.Bha = false;
    this.sessionId = "";
    this.Bhc = -1;
    this.Bhd = false;
    this.vZK = true;
    this.Bhe = false;
    this.Bhf = true;
    this.Bhg = false;
    this.Bhh = false;
    this.Bhj = new byte[0];
    this.AQP = null;
    this.Bhk = false;
    this.Bho = false;
    this.kxg = null;
    this.Bht = new com.tencent.mm.plugin.webview.ui.tools.d.a.h(this);
    this.Bhu = new com.tencent.mm.sdk.b.c() {};
    this.Bhv = false;
    this.kxf = null;
    this.AMZ = null;
    this.Bhw = new HashMap();
    this.Bhx = new HashMap();
    this.Bhy = new HashMap();
    this.Bhz = new HashMap();
    this.BhB = null;
    this.BhC = null;
    this.BhD = null;
    this.BhE = false;
    this.BhF = true;
    this.BhG = false;
    this.sfB = 0;
    this.sfC = null;
    this.BhH = false;
    this.BhI = false;
    this.BhK = 0;
    this.BhL = ((int)(System.currentTimeMillis() / 1000L));
    this.BhN = false;
    this.BhO = false;
    this.BhP = false;
    this.BhQ = false;
    this.BhR = false;
    this.AMJ = new com.tencent.mm.plugin.webview.model.ax();
    this.BhS = new com.tencent.mm.plugin.webview.j.h();
    this.BhT = new com.tencent.mm.plugin.webview.model.b(this.AMJ);
    this.BhU = new com.tencent.mm.plugin.webview.modeltools.n();
    this.BhX = null;
    this.Bif = false;
    this.Big = new aa()
    {
      public final boolean B(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80052);
        if (WebViewUI.this.nhy == null)
        {
          AppMethodBeat.o(80052);
          return false;
        }
        boolean bool = WebViewUI.this.nhy.af(paramAnonymousMotionEvent);
        AppMethodBeat.o(80052);
        return bool;
      }
      
      public final boolean C(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80057);
        if (WebViewUI.this.nhy == null)
        {
          AppMethodBeat.o(80057);
          return false;
        }
        boolean bool = WebViewUI.this.nhy.ag(paramAnonymousMotionEvent);
        AppMethodBeat.o(80057);
        return bool;
      }
      
      public final boolean D(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80058);
        if (WebViewUI.this.nhy == null)
        {
          AppMethodBeat.o(80058);
          return false;
        }
        boolean bool = WebViewUI.this.nhy.ah(paramAnonymousMotionEvent);
        AppMethodBeat.o(80058);
        return bool;
      }
      
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(80053);
        if (WebViewUI.this.nhy == null)
        {
          AppMethodBeat.o(80053);
          return false;
        }
        com.tencent.mm.plugin.webview.model.aj localaj = WebViewUI.this.AMJ.emn();
        if (paramAnonymousInt4 > localaj.AYn) {
          localaj.AYn = paramAnonymousInt4;
        }
        localaj.xJD = paramAnonymousInt6;
        paramAnonymousBoolean = WebViewUI.this.nhy.c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
        AppMethodBeat.o(80053);
        return paramAnonymousBoolean;
      }
      
      public final void beA()
      {
        AppMethodBeat.i(80054);
        if (WebViewUI.this.nhy == null)
        {
          AppMethodBeat.o(80054);
          return;
        }
        WebViewUI.this.nhy.feT();
        AppMethodBeat.o(80054);
      }
      
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(80055);
        if (WebViewUI.this.nhy == null)
        {
          AppMethodBeat.o(80055);
          return;
        }
        WebViewUI.this.nhy.g(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
        if ((paramAnonymousBoolean2) && (WebViewUI.this.AMJ != null)) {
          WebViewUI.this.AMJ.x("mm_scroll_bottom", Boolean.TRUE);
        }
        AppMethodBeat.o(80055);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(80056);
        if (WebViewUI.this.nhy == null)
        {
          AppMethodBeat.o(80056);
          return;
        }
        WebViewUI.this.nhy.Q(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        WebViewUI.this.onWebViewScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(80056);
      }
    };
    this.Bih = new com.tencent.mm.sdk.b.c()
    {
      private boolean epc()
      {
        AppMethodBeat.i(80075);
        if (WebViewUI.this.kxf == null)
        {
          ad.e("MicroMsg.WebViewUI", "Cli Event, invoker is null");
          AppMethodBeat.o(80075);
          return false;
        }
        if ((WebViewUI.this.Bia == null) || (WebViewUI.this.Bia.length() == 0))
        {
          ad.e("MicroMsg.WebViewUI", "Cli Event, tid is null");
          AppMethodBeat.o(80075);
          return false;
        }
        try
        {
          long l = System.currentTimeMillis();
          ad.i("MicroMsg.WebViewUI", "Cli Event, tid = %s, stime = %d, etime = %d", new Object[] { WebViewUI.this.Bia, Long.valueOf(WebViewUI.this.Bib), Long.valueOf(l) });
          Bundle localBundle = new Bundle();
          localBundle.putString("service_click_tid", new String(WebViewUI.this.Bia));
          localBundle.putLong("service_click_stime", WebViewUI.this.Bib);
          localBundle.putLong("service_click_etime", l);
          WebViewUI.this.kxf.w(2836, localBundle);
          WebViewUI.this.Bia = null;
          AppMethodBeat.o(80075);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.WebViewUI", "Cli Event Exception, msg = %s", new Object[] { localException.getMessage() });
          }
        }
      }
    };
    this.Bij = false;
    this.Bil = 0;
    this.Bim = true;
    this.tlW = 0L;
    this.nbF = 0;
    this.Biq = new com.tencent.mm.bp.a.b()
    {
      public final void a(com.tencent.mm.bp.a.a paramAnonymousa1, com.tencent.mm.bp.a.a paramAnonymousa2)
      {
        AppMethodBeat.i(188004);
        ad.i("MicroMsg.WebViewUI", "OrientationListener lastOrientation:" + paramAnonymousa1.name() + "; newOrientation:" + paramAnonymousa2.name());
        WebViewUI.this.screenOrientation = 4;
        WebViewUI.this.setMMOrientation();
        if (WebViewUI.this.BgR != null) {
          WebViewUI.this.BgR.disable();
        }
        AppMethodBeat.o(188004);
      }
    };
    this.Bir = false;
    this.Bis = new j();
    this.kxp = new com.tencent.mm.plugin.webview.modeltools.d();
    this.BeV = new com.tencent.mm.plugin.webview.modeltools.a();
    this.Bit = new com.tencent.mm.plugin.webview.ui.tools.media.d();
    this.Biv = new View.OnLongClickListener()
    {
      private boolean epb()
      {
        boolean bool2 = true;
        AppMethodBeat.i(187981);
        Object localObject = null;
        try
        {
          WebView.b localb = WebViewUI.this.nhy.getHitTestResult();
          localObject = localb;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ad.e("MicroMsg.WebViewUI", "getHitTestResult exp %s", new Object[] { localException1.getMessage() });
          }
        }
        if ((localObject == null) || (bt.isNullOrNil(localObject.mExtra)))
        {
          ad.e("MicroMsg.WebViewUI", "hittestresult getExtra is null");
          AppMethodBeat.o(187981);
          return false;
        }
        try
        {
          bool1 = WebViewUI.this.kxf.eT(localObject.mExtra);
          if (!bool1) {}
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            label137:
            boolean bool1 = true;
            ad.w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + localException2.getMessage());
          }
        }
        try
        {
          WebViewUI.this.kxf.fg(localObject.mExtra, WebViewUI.this.eiZ());
          if (bool1) {
            break label181;
          }
          WebViewUI.b(WebViewUI.this, localObject.mExtra);
          bool1 = bool2;
        }
        catch (Exception localException3)
        {
          break label148;
          break label137;
        }
        AppMethodBeat.o(187981);
        return bool1;
      }
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187980);
        if (WebViewUI.this.getIntent().getBooleanExtra("show_long_click_popup_menu", true))
        {
          boolean bool = epb();
          AppMethodBeat.o(187980);
          return bool;
        }
        AppMethodBeat.o(187980);
        return true;
      }
    };
    this.Biw = false;
    this.Biy = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187985);
        if ((WebViewUI.e(WebViewUI.this) != null) && ((com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bu.eGT())))
        {
          boolean bool = WebViewUI.e(WebViewUI.this).onLongClick(paramAnonymousView);
          AppMethodBeat.o(187985);
          return bool;
        }
        AppMethodBeat.o(187985);
        return false;
      }
    };
    this.BiA = "";
    this.rPQ = new com.tencent.mm.ui.widget.snackbar.a.b()
    {
      public final void aXO()
      {
        AppMethodBeat.i(188000);
        try
        {
          WebViewUI.this.kxf.favEditTag();
          AppMethodBeat.o(188000);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + localException.getMessage());
          AppMethodBeat.o(188000);
        }
      }
    };
    this.BiC = -1;
    AppMethodBeat.o(80217);
  }
  
  private void Sz(String paramString)
  {
    AppMethodBeat.i(80241);
    if (this.AQP != null)
    {
      this.AQP.avU(paramString);
      try
      {
        if (paramString.equals("onPause"))
        {
          this.kxf.Tq(this.AMZ.eiZ());
          AppMethodBeat.o(80241);
          return;
        }
        if (paramString.equals("onResume")) {
          this.kxf.Tp(this.AMZ.eiZ());
        }
        AppMethodBeat.o(80241);
        return;
      }
      catch (Exception paramString)
      {
        ad.w("MicroMsg.WebViewUI", "onResume, ex = " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(80241);
  }
  
  private void a(JsapiPermissionWrapper paramJsapiPermissionWrapper)
  {
    AppMethodBeat.i(188047);
    if (paramJsapiPermissionWrapper != null)
    {
      if (paramJsapiPermissionWrapper.mb(34))
      {
        setMMSubTitle(2131766182);
        AppMethodBeat.o(188047);
        return;
      }
      if (paramJsapiPermissionWrapper.mb(75))
      {
        setMMSubTitle(2131766195);
        AppMethodBeat.o(188047);
        return;
      }
      setMMSubTitle(null);
    }
    AppMethodBeat.o(188047);
  }
  
  private static void au(View paramView, int paramInt)
  {
    AppMethodBeat.i(80281);
    if (paramView == null)
    {
      AppMethodBeat.o(80281);
      return;
    }
    paramView.setSystemUiVisibility(paramView.getSystemUiVisibility() | paramInt);
    AppMethodBeat.o(80281);
  }
  
  private void axW(String paramString)
  {
    AppMethodBeat.i(80239);
    if ((this.Bie != null) && (!bt.isNullOrNil(paramString)) && (!com.tencent.mm.plugin.webview.ui.tools.b.a.isMpUrl(bEx()))) {
      this.Bie.OE(paramString);
    }
    AppMethodBeat.o(80239);
  }
  
  private void axX(String paramString)
  {
    AppMethodBeat.i(80240);
    if ((this.Bic != null) && (!bt.isNullOrNil(paramString)) && (!com.tencent.mm.plugin.webview.ui.tools.b.a.isMpUrl(bEx())) && (!this.Bic.title.equals(paramString)))
    {
      this.Bic.setTitle(paramString);
      if (ekY()) {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Bic);
      }
    }
    AppMethodBeat.o(80240);
  }
  
  private static String axY(String paramString)
  {
    AppMethodBeat.i(80299);
    try
    {
      paramString = Pattern.compile("(?i)^.*filename=\"?([^\"]+)\"?.*$").matcher(paramString);
      if ((paramString.find()) && (paramString.groupCount() == 1))
      {
        paramString = paramString.group(1);
        AppMethodBeat.o(80299);
        return paramString;
      }
      AppMethodBeat.o(80299);
      return null;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.WebViewUI", "getFileNameFromContentDisposition error " + paramString.getMessage());
      AppMethodBeat.o(80299);
    }
    return null;
  }
  
  private static void c(Dialog paramDialog)
  {
    AppMethodBeat.i(80270);
    if ((paramDialog != null) && (paramDialog.isShowing()))
    {
      paramDialog.dismiss();
      paramDialog.setCancelMessage(null);
      paramDialog.setDismissMessage(null);
    }
    AppMethodBeat.o(80270);
  }
  
  private boolean eny()
  {
    boolean bool1 = false;
    AppMethodBeat.i(80298);
    try
    {
      if (this.kxf == null)
      {
        ad.w("MicroMsg.WebViewUI", "invoker is null");
        AppMethodBeat.o(80298);
        return false;
      }
      boolean bool2 = this.kxf.eny();
      bool1 = bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ad.e("MicroMsg.WebViewUI", "unable get config for WebViewDownLoadFile" + localRemoteException.getMessage());
      }
    }
    AppMethodBeat.o(80298);
    return bool1;
  }
  
  private void eoO()
  {
    AppMethodBeat.i(80316);
    if (this.Bhl != null) {
      this.Bhl.setVisibility(8);
    }
    if (this.Bhm != null) {
      this.Bhm.stopTimer();
    }
    AppMethodBeat.o(80316);
  }
  
  private boolean eoS()
  {
    AppMethodBeat.i(80355);
    int i = getIntent().getIntExtra("key_close_action", 0);
    Object localObject = getIntent().getBundleExtra("key_close_data");
    ad.i("MicroMsg.WebViewUI", "close action %s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    String str1;
    do
    {
      do
      {
        String str2;
        String str3;
        String str4;
        boolean bool;
        do
        {
          do
          {
            AppMethodBeat.o(80355);
            return false;
          } while (localObject == null);
          str1 = ((Bundle)localObject).getString("close_dialog_title");
          str2 = ((Bundle)localObject).getString("close_dialog_msg");
          str3 = ((Bundle)localObject).getString("close_dialog_ok");
          str4 = ((Bundle)localObject).getString("close_dialog_cancel");
          bool = ((Bundle)localObject).getBoolean("close_dialog_ok_close", true);
        } while (bt.T(new String[] { str2, str3, str4 }));
        if (bool) {
          com.tencent.mm.ui.base.h.a(this, str1, str2, str3, str4, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(187998);
              WebViewUI.this.BhN = true;
              k.BfO.close();
              WebViewUI.this.finish();
              AppMethodBeat.o(187998);
            }
          }, null);
        }
        for (;;)
        {
          AppMethodBeat.o(80355);
          return true;
          com.tencent.mm.ui.base.h.a(this, str1, str2, str3, str4, false, null, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(187999);
              WebViewUI.this.BhN = true;
              k.BfO.close();
              WebViewUI.this.finish();
              AppMethodBeat.o(187999);
            }
          });
        }
      } while (localObject == null);
      str1 = ((Bundle)localObject).getString("close_jump_url");
      i = ((Bundle)localObject).getInt("close_jump_url_request_code", 0);
    } while (bt.isNullOrNil(str1));
    localObject = new Intent(this, WebViewUI.class);
    ((Intent)localObject).putExtra("rawUrl", str1);
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("show_bottom", false);
    ((Intent)localObject).putExtra("needRedirect", false);
    ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
    ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
    startActivityForResult((Intent)localObject, i);
    com.tencent.mm.ui.base.b.jJ(this);
    AppMethodBeat.o(80355);
    return true;
  }
  
  private void eoU()
  {
    AppMethodBeat.i(80357);
    if (this.BhP)
    {
      ad.d("MicroMsg.WebViewUI", "SwipeBackFinish, do not LaunchOuterApp");
      AppMethodBeat.o(80357);
      return;
    }
    Object localObject = getIntent();
    boolean bool = ((Intent)localObject).getBooleanExtra("webview_invoke_launch_app_when_back", false);
    String str = ((Intent)localObject).getStringExtra("KAppId");
    localObject = ((Intent)localObject).getStringExtra("webview_invoke_launch_app_ext_info_when_back");
    if ((bool) && (str != null) && (str.length() > 0) && (localObject != null) && (((String)localObject).length() > 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("appId", str);
      localBundle.putString("extInfo", (String)localObject);
      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localBundle, v.class, null);
    }
    AppMethodBeat.o(80357);
  }
  
  private static boolean eoq()
  {
    AppMethodBeat.i(80248);
    if (Bin == null) {}
    try
    {
      if (bt.getInt(com.tencent.mm.plugin.expt.e.b.ceD().b("clicfg_webview_force_dark_disable", "0", false, true), 1) > 0) {
        ad.i("MicroMsg.WebViewUI", "disableForceDark on!!");
      }
      for (Bin = Boolean.TRUE;; Bin = Boolean.FALSE)
      {
        boolean bool = Bin.booleanValue();
        AppMethodBeat.o(80248);
        return bool;
        ad.i("MicroMsg.WebViewUI", "disableForceDark close!!");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.WebViewUI", localException, "disableForceDark", new Object[0]);
        Bin = Boolean.FALSE;
      }
    }
  }
  
  private boolean eos()
  {
    return (this.BgP) || (this.BgQ);
  }
  
  private int eot()
  {
    AppMethodBeat.i(80252);
    if (this.BhF) {}
    for (int i = 0; (getSupportActionBar() == null) || (!getSupportActionBar().isShowing()); i = this.lDk)
    {
      AppMethodBeat.o(80252);
      return i;
    }
    int j = getActionBarHeight();
    AppMethodBeat.o(80252);
    return i + j;
  }
  
  private View eoz()
  {
    AppMethodBeat.i(80264);
    View localView = null;
    try
    {
      i = Resources.getSystem().getIdentifier("action_bar_container", "id", "android");
      if (i > 0) {
        localView = findViewById(i);
      }
      ad.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", new Object[] { Integer.valueOf(i), localView });
      AppMethodBeat.o(80264);
      return localView;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.WebViewUI", "get resId action_bar_container, exp = %s", new Object[] { localException });
        int i = -1;
      }
    }
  }
  
  private static void fk(View paramView)
  {
    AppMethodBeat.i(80282);
    if (paramView == null)
    {
      AppMethodBeat.o(80282);
      return;
    }
    paramView.setSystemUiVisibility(paramView.getSystemUiVisibility() & 0xFFFFE8F9);
    AppMethodBeat.o(80282);
  }
  
  private void ti(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.Bho = true;
    }
  }
  
  public final void P(String paramString, long paramLong)
  {
    AppMethodBeat.i(188029);
    if ((this.AQP != null) && (this.nhy != null))
    {
      Object localObject2 = this.AQP;
      this.nhy.getUrl();
      Object localObject1 = getIntent();
      boolean bool;
      Object localObject3;
      if ((this.kxg.emS().Cqc & 0x100000) > 0)
      {
        bool = true;
        ad.d("MicroMsg.GeneralControlWrapper", "allowOnScreenShot, ret = ".concat(String.valueOf(bool)));
        if (!((com.tencent.mm.plugin.webview.c.f)localObject2).yZR) {
          break label423;
        }
        ad.i("MicroMsg.JsApiHandler", "onScreenShot hasPermission: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramString = l.a.b("onScreenShot", new HashMap(), ((com.tencent.mm.plugin.webview.c.f)localObject2).ARm, ((com.tencent.mm.plugin.webview.c.f)localObject2).ARn);
          ((com.tencent.mm.plugin.webview.c.f)localObject2).ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
        }
        paramString = ((com.tencent.mm.plugin.webview.c.f)localObject2).ARe.getUrl();
        localObject3 = ((com.tencent.mm.plugin.webview.c.f)localObject2).getContext();
        if (!(localObject3 instanceof com.tencent.mm.plugin.webview.core.b)) {
          break label401;
        }
      }
      label401:
      for (paramString = ((com.tencent.mm.plugin.webview.core.b)localObject3).avx(paramString);; paramString = "")
      {
        if (localObject1 == null) {
          break label423;
        }
        try
        {
          localObject2 = ((com.tencent.mm.plugin.webview.c.f)localObject2).ARe.getUrl();
          localObject1 = ((Intent)localObject1).getBundleExtra("ad_report_bundle");
          if ((!bt.isNullOrNil((String)localObject2)) && (localObject1 != null))
          {
            localObject1 = ((Bundle)localObject1).getString("ad_report_ux_info");
            if (!bt.isNullOrNil((String)localObject1))
            {
              int i = (int)(System.currentTimeMillis() / 1000L);
              Object localObject4 = Uri.parse((String)localObject2);
              localObject3 = ((Uri)localObject4).getQueryParameter("mid");
              localObject4 = ((Uri)localObject4).getQueryParameter("idx");
              ad.i("MicroMsg.JsApiHandler", "alvinluo reportAdOnScreenShot appId: %s, mid: %s, idx: %s, adUxInfo: %s, url: %s", new Object[] { paramString, localObject3, localObject4, localObject1, localObject2 });
              com.tencent.mm.plugin.report.service.h.vKh.f(19213, new Object[] { Integer.valueOf(i), Integer.valueOf(6), localObject1, paramString, localObject3, localObject4, localObject2 });
            }
          }
          AppMethodBeat.o(188029);
          return;
        }
        catch (Exception paramString)
        {
          ad.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "alvinluo reportAdOnScreenShot exception", new Object[0]);
        }
        bool = false;
        break;
      }
    }
    label423:
    AppMethodBeat.o(188029);
  }
  
  protected void SK(int paramInt)
  {
    AppMethodBeat.i(80351);
    if ((this.nhy == null) || (this.nhy.getSettings() == null))
    {
      AppMethodBeat.o(80351);
      return;
    }
    ad.i("MicroMsg.WebViewUI", "localSetFontSize, fontSize = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      this.nhy.getSettings().setTextZoom(100);
      AppMethodBeat.o(80351);
      return;
    case 1: 
      this.nhy.getSettings().setTextZoom(80);
      AppMethodBeat.o(80351);
      return;
    case 2: 
      this.nhy.getSettings().setTextZoom(100);
      AppMethodBeat.o(80351);
      return;
    case 3: 
      this.nhy.getSettings().setTextZoom(110);
      AppMethodBeat.o(80351);
      return;
    case 4: 
      this.nhy.getSettings().setTextZoom(112);
      AppMethodBeat.o(80351);
      return;
    case 5: 
      this.nhy.getSettings().setTextZoom(112);
      AppMethodBeat.o(80351);
      return;
    case 6: 
      this.nhy.getSettings().setTextZoom(140);
      AppMethodBeat.o(80351);
      return;
    case 7: 
      this.nhy.getSettings().setTextZoom(155);
      AppMethodBeat.o(80351);
      return;
    }
    this.nhy.getSettings().setTextZoom(165);
    AppMethodBeat.o(80351);
  }
  
  protected final void TB(int paramInt)
  {
    AppMethodBeat.i(80288);
    Drawable localDrawable = getResources().getDrawable(eoF()).mutate();
    localDrawable.setColorFilter(paramInt, PorterDuff.Mode.SRC_IN);
    updateBackBtn(localDrawable);
    AppMethodBeat.o(80288);
  }
  
  protected final void TC(int paramInt)
  {
    AppMethodBeat.i(80315);
    if (paramInt != -3)
    {
      AppMethodBeat.o(80315);
      return;
    }
    if (this.Bhl == null)
    {
      AppMethodBeat.o(80315);
      return;
    }
    if ((this.kxg.emS().Cqc & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = ".concat(String.valueOf(bool)));
      if (!bool) {
        break label236;
      }
      if ((this.Bhl.getVisibility() != 0) && (!this.BgT.isShown())) {
        break;
      }
      AppMethodBeat.o(80315);
      return;
    }
    if (this.Bhm == null) {
      this.Bhm = new com.tencent.mm.sdk.platformtools.av(Looper.getMainLooper(), new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(187991);
          WebViewUI.i(WebViewUI.this);
          AppMethodBeat.o(187991);
          return false;
        }
      }, false);
    }
    this.Bhm.av(4000L, 4000L);
    View localView = this.Bhl;
    ((ImageView)localView.findViewById(2131301454)).setImageResource(2131690929);
    TextView localTextView = (TextView)localView.findViewById(2131301455);
    localTextView.setTextSize(14.0F);
    localTextView.setText(2131766250);
    ((ImageButton)localView.findViewById(2131301453)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187992);
        WebViewUI.i(WebViewUI.this);
        AppMethodBeat.o(187992);
      }
    });
    this.Bhl.setVisibility(0);
    com.tencent.mm.plugin.report.service.h.vKh.kvStat(13125, bEx());
    label236:
    AppMethodBeat.o(80315);
  }
  
  protected void VV()
  {
    AppMethodBeat.i(80342);
    this.BhW.VV();
    AppMethodBeat.o(80342);
  }
  
  @TargetApi(21)
  protected final void a(ViewGroup paramViewGroup, WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(80253);
    if (this.lDk == paramWindowInsets.getSystemWindowInsetTop())
    {
      AppMethodBeat.o(80253);
      return;
    }
    this.lDk = paramWindowInsets.getSystemWindowInsetTop();
    eor();
    Object localObject = paramViewGroup;
    if ((paramViewGroup instanceof SwipeBackLayout)) {
      localObject = paramViewGroup.getChildAt(0);
    }
    paramViewGroup = ((View)localObject).findViewById(2131296345);
    if (paramViewGroup != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = paramWindowInsets.getSystemWindowInsetTop();
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramViewGroup.requestLayout();
    }
    if (eou()) {
      eow();
    }
    AppMethodBeat.o(80253);
  }
  
  public final void a(com.tencent.mm.plugin.webview.ui.tools.d.b paramb)
  {
    AppMethodBeat.i(188032);
    this.Bht.a(paramb);
    AppMethodBeat.o(188032);
  }
  
  public final void a(com.tencent.mm.ui.base.p paramp)
  {
    this.fqw = paramp;
  }
  
  protected void aD(Bundle paramBundle) {}
  
  protected void aE(Bundle paramBundle)
  {
    AppMethodBeat.i(80220);
    int i;
    if (paramBundle.getBoolean("set_navigation_bar_color_reset", false)) {
      if (this.Bid == null) {
        i = getResources().getColor(2131101161);
      }
    }
    for (int j = 255;; j = paramBundle.getInt("set_navigation_bar_color_alpha"))
    {
      setActionbarColor(i & 0xFFFFFF | j << 24);
      AppMethodBeat.o(80220);
      return;
      i = this.Bid.epk();
      break;
      i = paramBundle.getInt("set_navigation_bar_color_color");
    }
  }
  
  public final void aI(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(80257);
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.sdk.h.b.XM()))
    {
      setStatusBarColor(paramInt);
      Window localWindow = getWindow();
      paramInt = localWindow.getDecorView().getSystemUiVisibility();
      if (paramBoolean) {
        paramInt |= 0x2000;
      }
      for (;;)
      {
        localWindow.getDecorView().setSystemUiVisibility(paramInt);
        AppMethodBeat.o(80257);
        return;
        paramInt &= 0xFFFFDFFF;
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      int i = paramInt;
      if (paramBoolean) {
        i = e.Ts(paramInt);
      }
      setStatusBarColor(i);
    }
    AppMethodBeat.o(80257);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(80313);
    if (!com.tencent.mm.compatible.util.d.lf(21))
    {
      super.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
      AppMethodBeat.o(80313);
      return;
    }
    Drawable localDrawable = android.support.v4.content.b.l(this, paramInt2);
    if (localDrawable == null)
    {
      AppMethodBeat.o(80313);
      return;
    }
    if (eov()) {
      localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
    for (;;)
    {
      addIconOptionMenu(paramInt1, getString(2131755815), localDrawable, paramOnMenuItemClickListener);
      AppMethodBeat.o(80313);
      return;
      if ((this.Bid != null) && (!this.Bid.BiN)) {
        localDrawable.setColorFilter(getResources().getColor(2131099732), PorterDuff.Mode.SRC_ATOP);
      } else {
        localDrawable.clearColorFilter();
      }
    }
  }
  
  public final void at(Bundle paramBundle)
  {
    AppMethodBeat.i(80231);
    this.Bil = paramBundle.getInt("state", 0);
    AppMethodBeat.o(80231);
  }
  
  public final void at(View paramView, int paramInt)
  {
    AppMethodBeat.i(188031);
    com.tencent.mm.plugin.webview.ui.tools.d.a.h localh = this.Bht;
    Object localObject = paramView;
    if (paramView == null) {
      localObject = this.nhy;
    }
    localh.at((View)localObject, paramInt);
    AppMethodBeat.o(188031);
  }
  
  public final void au(Bundle paramBundle)
  {
    AppMethodBeat.i(80227);
    if (paramBundle != null)
    {
      this.Bij = "black".equals(paramBundle.getString("style"));
      eol().setCommentTopicId(paramBundle.getLong("commentTopicId"));
    }
    eol().ayI(this.AMZ.getCurrentUrl());
    eol().tE(false);
    AppMethodBeat.o(80227);
  }
  
  public final void av(Bundle paramBundle)
  {
    AppMethodBeat.i(80229);
    if (paramBundle != null)
    {
      this.Bij = "black".equals(paramBundle.getString("style"));
      eol().tE(true);
    }
    AppMethodBeat.o(80229);
  }
  
  protected final int avB(String paramString)
  {
    AppMethodBeat.i(80336);
    int i = this.AMZ.avB(paramString);
    AppMethodBeat.o(80336);
    return i;
  }
  
  public final String avx(String paramString)
  {
    AppMethodBeat.i(188045);
    paramString = this.AMZ.avx(paramString);
    AppMethodBeat.o(188045);
    return paramString;
  }
  
  public final void aw(Bundle paramBundle)
  {
    AppMethodBeat.i(80230);
    this.fqw = com.tencent.mm.plugin.webview.ui.tools.widget.p.a(paramBundle, getContext(), this.fqw);
    AppMethodBeat.o(80230);
  }
  
  public final void ax(Bundle paramBundle)
  {
    AppMethodBeat.i(175797);
    if (paramBundle != null) {
      eol().setCommentTopicId(paramBundle.getLong("commentTopicId"));
    }
    eol().ayI(this.AMZ.getCurrentUrl());
    com.tencent.mm.plugin.webview.ui.tools.widget.n localn = eol();
    String str = paramBundle.getString("reply_content");
    int i = paramBundle.getInt("personal_comment_id");
    d.g.b.k.h(str, "replyContent");
    localn.sw(2);
    localn.tG(false);
    if ((!bt.isNullOrNil(str)) && (i != 0) && (localn.erp()))
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n.a(localn, str, i);
      localn.tF(false);
      AppMethodBeat.o(175797);
      return;
    }
    localn.tE(false);
    AppMethodBeat.o(175797);
  }
  
  public final void axV(String paramString)
  {
    AppMethodBeat.i(80306);
    this.BhW.axV(paramString);
    AppMethodBeat.o(80306);
  }
  
  public final void axZ(String paramString)
  {
    AppMethodBeat.i(80317);
    this.AQP.bZ("profile", true);
    this.AQP.avV(paramString);
    AppMethodBeat.o(80317);
  }
  
  protected final void ay(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(80280);
    this.BgP = paramBoolean1;
    Object localObject;
    if (paramBoolean1)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      if (this.Bio != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.Bio.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
        this.Bio.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.BhF) {
        com.tencent.mm.ui.statusbar.a.H(this.Bio, true);
      }
      for (;;)
      {
        getWindow().addFlags(1024);
        localObject = getWindow().getDecorView();
        ((View)localObject).setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
        {
          public final void onSystemUiVisibilityChange(int paramAnonymousInt)
          {
            AppMethodBeat.i(187959);
            if (((paramAnonymousInt & 0x4) == 0) && (WebViewUI.this.BgP)) {
              WebViewUI.fl(this.lnS);
            }
            AppMethodBeat.o(187959);
          }
        });
        au((View)localObject, 5894);
        if (!paramBoolean2) {
          break;
        }
        this.BgO.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(187960);
            WebViewUI.this.bFd();
            AppMethodBeat.o(187960);
          }
        });
        this.BgO.setVisibility(0);
        AppMethodBeat.o(80280);
        return;
        if (this.Bip != null) {
          this.Bip.setVisibility(8);
        }
      }
      this.BgO.setVisibility(8);
      AppMethodBeat.o(80280);
      return;
    }
    this.BgO.setVisibility(8);
    getWindow().clearFlags(1024);
    fk(getWindow().getDecorView());
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().show();
      if (this.Bio != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.Bio.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = eot();
        this.Bio.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    if (this.BhF)
    {
      com.tencent.mm.ui.statusbar.a.H(this.Bio, false);
      AppMethodBeat.o(80280);
      return;
    }
    if (this.Bip != null) {
      this.Bip.setVisibility(0);
    }
    AppMethodBeat.o(80280);
  }
  
  public final void b(com.tencent.mm.plugin.webview.ui.tools.d.b paramb)
  {
    AppMethodBeat.i(188033);
    this.Bht.b(paramb);
    AppMethodBeat.o(188033);
  }
  
  protected void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(80367);
    paramWebView = this.AMJ;
    Intent localIntent = getIntent();
    String str2 = bEx();
    int i = localIntent.getIntExtra("geta8key_scene", 0);
    int j = localIntent.getIntExtra("bizEnterId", paramWebView.AZj);
    int k = localIntent.getIntExtra("webview_scene_type", 1);
    String str3 = localIntent.getStringExtra("webview_scene_note");
    String str1 = localIntent.getStringExtra("srcUsername");
    paramWebView = str1;
    if (bt.isNullOrNil(str1)) {
      paramWebView = localIntent.getStringExtra("geta8key_username");
    }
    str1 = localIntent.getStringExtra("KAppId");
    com.tencent.mm.plugin.report.service.h.vKh.f(18452, new Object[] { Integer.valueOf(j), Integer.valueOf(i), x.aCL(str2), x.aCL(paramString), Integer.valueOf(k), str3, str1, paramWebView });
    AppMethodBeat.o(80367);
  }
  
  public final void bAR()
  {
    AppMethodBeat.i(80302);
    this.BhW.bAR();
    AppMethodBeat.o(80302);
  }
  
  protected MMWebView bEY()
  {
    AppMethodBeat.i(80260);
    MMWebView localMMWebView = MMWebView.a.kk(this);
    AppMethodBeat.o(80260);
    return localMMWebView;
  }
  
  protected boolean bEZ()
  {
    AppMethodBeat.i(80365);
    if ((getClass().equals(WebViewUI.class)) && (!getIntent().getBooleanExtra("disable_minimize", false))) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WebViewUI", "enableMinimize class:%s enable:%b", new Object[] { getClass(), Boolean.valueOf(bool) });
      AppMethodBeat.o(80365);
      return bool;
    }
  }
  
  public final String bEx()
  {
    AppMethodBeat.i(80300);
    try
    {
      String str = BaseWebViewController.aQ(getIntent());
      AppMethodBeat.o(80300);
      return str;
    }
    catch (Exception localException)
    {
      finish();
      AppMethodBeat.o(80300);
    }
    return null;
  }
  
  protected void bFJ()
  {
    AppMethodBeat.i(80246);
    if (this.BhF) {
      fixStatusbar(false);
    }
    AppMethodBeat.o(80246);
  }
  
  public void bFM()
  {
    AppMethodBeat.i(80226);
    this.Bii.erl();
    int i = getIntent().getIntExtra(e.m.FIt, -1);
    getIntent().getIntExtra(e.m.FIo, 0);
    int j = getIntent().getIntExtra(e.m.FIp, -1);
    int k = getIntent().getIntExtra(e.m.FIq, -1);
    this.Bii.a(j, k, i, 0, bEx(), getTitle().toString());
    AppMethodBeat.o(80226);
  }
  
  protected void bFa()
  {
    AppMethodBeat.i(80247);
    ad.i("MicroMsg.WebViewUI", "onCreate" + hashCode());
    this.ASw = new l(this);
    this.BhV = new h(this);
    this.BhW = new i(this);
    this.Bid = new n(this);
    Object localObject1 = this.Bid;
    if (((n)localObject1).BiO != null)
    {
      if (!((n)localObject1).epe()) {
        break label1436;
      }
      ((n)localObject1).BiN = true;
    }
    for (;;)
    {
      ad.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleParams, webViewUI#%s, disableLightActionbarStyle:%b", new Object[] { ((n)localObject1).BiO, Boolean.valueOf(((n)localObject1).BiN) });
      this.Biw = true;
      this.Bhi = getIntent().getIntExtra("geta8key_session_id", (int)System.currentTimeMillis());
      this.Bhj = getIntent().getByteArrayExtra("geta8key_cookie");
      com.tencent.mm.plugin.webview.j.i.h(bEx(), this);
      this.BgW = bEx();
      this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
      this.Bhh = getIntent().getBooleanExtra("from_shortcut", false);
      this.Bhc = getIntent().getIntExtra(e.m.FIt, -1);
      this.sfC = getIntent().getStringExtra("status_bar_style");
      this.sfB = getIntent().getIntExtra("customize_status_bar_color", 0);
      this.BhI = getIntent().getBooleanExtra("show_native_web_view", false);
      label294:
      boolean bool;
      if (getIntent() == null)
      {
        localObject1 = "";
        if (getIntent() != null) {
          break label1460;
        }
        bool = false;
        label303:
        ad.i("MicroMsg.WebViewUI", "initCustomActionBarColorIfNeed isNativeStyle is %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label1475;
        }
        localObject1 = "white";
        TB(-16777216);
      }
      try
      {
        label339:
        i = Color.parseColor((String)localObject1);
        localObject1 = Integer.valueOf(i);
        label351:
        Object localObject3;
        if (localObject1 != null)
        {
          localObject3 = new Bundle(1);
          ((Bundle)localObject3).putInt("set_navigation_bar_color_color", ((Integer)localObject1).intValue());
          ((Bundle)localObject3).putInt("set_navigation_bar_color_alpha", 255);
          aE((Bundle)localObject3);
          if (!getIntent().hasExtra("customize_status_bar_color")) {
            this.sfB = ((Integer)localObject1).intValue();
          }
        }
        label418:
        this.BhI = getIntent().getBooleanExtra("show_native_web_view", false);
        this.BgV = getIntent().getBooleanExtra("key_trust_url", false);
        BhM += 1;
        ad.i("MicroMsg.WebViewUI", "initView trust:%b, rawUrl = %s ", new Object[] { Boolean.valueOf(this.BgV), bEx() });
        this.dxF = bt.nullAsNil(getIntent().getStringExtra("KPublisherId"));
        this.handler = new ap();
        if (this.AMJ != null)
        {
          localObject1 = this.AMJ;
          localObject3 = getIntent().getBundleExtra("mm_report_bundle");
          if (localObject3 != null)
          {
            if (((com.tencent.mm.plugin.webview.model.ax)localObject1).AZf != null) {
              ((com.tencent.mm.plugin.webview.model.ax)localObject1).AZf.dow = null;
            }
            ((com.tencent.mm.plugin.webview.model.ax)localObject1).AZf = new ax.a((com.tencent.mm.plugin.webview.model.ax)localObject1, (Bundle)localObject3);
            bool = true;
            label579:
            this.Bha = bool;
            localObject1 = getIntent().getBundleExtra("close_window_confirm_info");
            if (localObject1 != null) {
              this.BhA = a.aF((Bundle)localObject1);
            }
            getWindow().setFlags(16777216, 16777216);
            getWindow().setFormat(-3);
            this.BhW.enT();
            com.tencent.mm.pluginsdk.model.w.a.ha(this);
            this.BhS.bG("onWebViewCreateStart", System.currentTimeMillis());
            if (!com.tencent.mm.plugin.webview.j.i.ayK(bEx())) {
              break label1504;
            }
            this.nhy = MMWebView.a.kj(this);
            com.tencent.xweb.util.g.xs(173L);
            if (this.nhy == null) {
              this.nhy = bEY();
            }
            label695:
            this.BhS.bG("onWebViewCreateEnd", System.currentTimeMillis());
            this.nhy.HAM = this;
            localObject1 = this.BhW;
            if (!(((i)localObject1).enA() instanceof GameWebViewUI)) {
              break label1515;
            }
            ((i)localObject1).Bfo.add(Integer.valueOf(11));
            ((i)localObject1).Bfo.add(Integer.valueOf(28));
            label765:
            this.BhZ = new com.tencent.mm.plugin.webview.c();
            initView();
            this.AMZ = bFq();
            this.AMZ.an(getIntent());
            localObject1 = this.AMJ.emi();
            i = this.AMZ.beH();
            localObject3 = this.dxF;
            ((ax.l)localObject1).dEF = i;
            ((ax.l)localObject1).AZr = ((String)localObject3);
            this.AQP = this.AMZ.getJsapi();
            this.kxg = this.AMZ.kxg;
            Bhn.add(new e(this));
            if (Bhn.size() > 1)
            {
              localObject1 = Bhn;
              localObject1 = (e)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 2);
              if ((((e)localObject1).kUk != null) && (((e)localObject1).kUk.get() != null)) {
                ((WebViewUI)((e)localObject1).kUk.get()).ti(false);
              }
            }
            Sz("onCreate");
            j = getIntent().getIntExtra("from_scence", 0);
            this.Bhb = getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
            localObject1 = this.BhS;
            i = this.Bhb;
            if (i == -1) {
              break label1566;
            }
            ((com.tencent.mm.plugin.webview.j.h)localObject1).Bhb = i;
            ad.d("MicroMsg.WebViewUI", " onCreate fromScene %d", new Object[] { Integer.valueOf(j) });
            this.sessionId = com.tencent.mm.model.y.tD(String.valueOf(this.AMZ.eiZ()));
            ad.i("MicroMsg.WebViewUI", " onCreate sessionId %s", new Object[] { this.sessionId });
            localObject1 = this.AMJ.emo();
            i = this.AMZ.beH();
            localObject3 = this.dxF;
            ((ax.f)localObject1).dEF = i;
            ((ax.f)localObject1).AZr = ((String)localObject3);
            ((ax.f)localObject1).url = bEx();
            localObject3 = this.AMJ.emu();
            localObject1 = bEx();
            ad.i("MicroMsg.WebviewReporter.DomainReporter", "setRawUrl, value = %s", new Object[] { localObject1 });
          }
        }
      }
      catch (Exception localException2)
      {
        try
        {
          localObject4 = Uri.parse((String)localObject1);
          if ((((Uri)localObject4).getScheme() != null) && (!((Uri)localObject4).getScheme().toLowerCase().startsWith("http"))) {
            ad.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl scheme is not http/https, skip, scheme = %s", new Object[] { ((Uri)localObject4).getScheme() });
          }
        }
        catch (Exception localException2)
        {
          try
          {
            label1182:
            this.Bio = getContentView();
            if (this.Bio != null)
            {
              eor();
              ((ViewGroup)((ViewGroup)getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
              {
                public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
                {
                  AppMethodBeat.i(188002);
                  WebViewUI.this.eor();
                  AppMethodBeat.o(188002);
                }
              });
            }
          }
          catch (Exception localException2)
          {
            try
            {
              int i;
              int j;
              Object localObject4;
              label1229:
              if (this.BhF) {
                if (eou()) {
                  eow();
                }
              }
              for (;;)
              {
                this.BgR = new com.tencent.mm.bp.a(getContext(), this.Biq);
                com.tencent.mm.plugin.webview.a.a.ae(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(188001);
                    com.tencent.mm.cg.f.eHV();
                    com.tencent.mm.cg.b.eHL();
                    AppMethodBeat.o(188001);
                  }
                });
                this.BhY = new WebViewClipBoardHelper(this);
                this.Bih.alive();
                this.Bhu.alive();
                if (this.Bid != null)
                {
                  localObject1 = this.Bid;
                  if (((n)localObject1).BiO != null)
                  {
                    ((n)localObject1).uQx = ((n)localObject1).BiO.nhy;
                    if (!((n)localObject1).BiN) {
                      break label1804;
                    }
                    ad.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle true");
                  }
                }
                au(getWindow().getDecorView(), 256);
                com.tencent.mm.plugin.webview.model.ax.uZ(getIntent().getLongExtra("start_activity_time", 0L));
                this.Bif = getIntent().getBooleanExtra(e.m.FIC, false);
                if (((this.Bif) || (eoq())) && (this.nhy != null)) {
                  this.nhy.getSettings().setForceDarkBehavior(1);
                }
                AppMethodBeat.o(80247);
                return;
                label1436:
                ((n)localObject1).BiN = false;
                break;
                localObject1 = getIntent().getStringExtra("custom_action_bar_color");
                break label294;
                label1460:
                bool = getIntent().getBooleanExtra("open_custom_style_url", false);
                break label303;
                label1475:
                if (bt.isNullOrNil((String)localObject1)) {
                  break label418;
                }
                break label339;
                localException1 = localException1;
                Object localObject2 = null;
                break label351;
                bool = false;
                break label579;
                bool = false;
                break label579;
                label1504:
                this.nhy = bEY();
                break label695;
                label1515:
                localObject2.Bfo.add(Integer.valueOf(7));
                localObject2.Bfo.add(Integer.valueOf(11));
                localObject2.Bfo.add(Integer.valueOf(28));
                break label765;
                switch (j)
                {
                default: 
                  label1566:
                  i = 999;
                }
                for (;;)
                {
                  localObject2.Bhb = i;
                  break;
                  i = 1;
                  continue;
                  i = 2;
                }
                localObject4 = ((Uri)localObject4).getHost();
                if ((localObject4 == null) || (((String)localObject4).toLowerCase().endsWith(".qq.com")))
                {
                  ad.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl, host is .qq.com, skip, host = %s", new Object[] { localObject4 });
                  break label1182;
                  localException4 = localException4;
                  ad.e("MicroMsg.WebviewReporter.DomainReporter", "parse rawUrl fail, rawUrl = %s", new Object[] { localObject2 });
                  break label1182;
                }
                localException4.qhl = true;
                break label1182;
                localException2 = localException2;
                ad.e("MicroMsg.WebViewUI", "fixContentMargin error : %s", new Object[] { localException2.getMessage() });
                break label1229;
                if (!com.tencent.mm.compatible.util.d.lf(21)) {
                  break label1787;
                }
                final ViewGroup localViewGroup = (ViewGroup)((ViewGroup)getWindow().getDecorView()).getChildAt(0);
                localViewGroup.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
                {
                  public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
                  {
                    AppMethodBeat.i(188003);
                    WebViewUI.this.a(localViewGroup, paramAnonymousWindowInsets);
                    WebViewUI.a(WebViewUI.this);
                    paramAnonymousView = paramAnonymousWindowInsets.consumeSystemWindowInsets();
                    AppMethodBeat.o(188003);
                    return paramAnonymousView;
                  }
                });
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                ad.e("MicroMsg.WebViewUI", "tryToExpandToStatusBar error : %s", new Object[] { localException3.getMessage() });
                continue;
                label1787:
                ((ViewGroup)getWindow().getDecorView()).setFitsSystemWindows(true);
                continue;
                label1804:
                ad.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle false");
                localException3.epf();
              }
            }
          }
        }
      }
    }
  }
  
  protected boolean bFc()
  {
    AppMethodBeat.i(80320);
    if (this.BgY)
    {
      AppMethodBeat.o(80320);
      return true;
    }
    if ((this.nhy != null) && ((this.nhy.canGoBack()) || (this.nhy.canGoForward())) && (this.BgH != null))
    {
      Object localObject1 = this.BgH;
      boolean bool;
      if (((g)localObject1).Bey != null)
      {
        localObject1 = ((g)localObject1).Bey;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        bool = ((Boolean)localObject1).booleanValue();
      }
      while (bool)
      {
        this.BgX = false;
        this.BgY = true;
        AppMethodBeat.o(80320);
        return true;
        Object localObject2 = com.tencent.mm.sdk.platformtools.ax.aFC("WebViewUIShowBottom");
        if (localObject2 == null) {
          d.g.b.k.fvU();
        }
        if (((com.tencent.mm.sdk.platformtools.ax)localObject2).decodeInt("WebViewUIShowBottomNav", 0) == 1)
        {
          ((g)localObject1).Bey = Boolean.TRUE;
          localObject1 = ((g)localObject1).Bey;
          if (localObject1 == null) {
            d.g.b.k.fvU();
          }
          bool = ((Boolean)localObject1).booleanValue();
        }
        else
        {
          if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmh, 0) == 1) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label231;
            }
            ad.i(g.TAG, "needShowBottomNavigator not open");
            ((g)localObject1).Bey = Boolean.FALSE;
            localObject1 = ((g)localObject1).Bey;
            if (localObject1 == null) {
              d.g.b.k.fvU();
            }
            bool = ((Boolean)localObject1).booleanValue();
            break;
          }
          label231:
          localObject2 = com.tencent.mm.sdk.platformtools.aj.getContext();
          d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
          if (Settings.Global.getInt(((Context)localObject2).getContentResolver(), "force_fsg_nav_bar", 0) != 0)
          {
            i = 1;
            label261:
            if (i != 0) {
              break label501;
            }
            bool = false;
            label267:
            if (!bool)
            {
              localObject2 = com.tencent.mm.sdk.platformtools.aj.getContext();
              d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
              if (Settings.Secure.getInt(((Context)localObject2).getContentResolver(), "secure_gesture_navigation", 0) == 0) {
                break label543;
              }
              i = 1;
              label301:
              if (i != 0) {
                break label548;
              }
              bool = false;
              label307:
              if (!bool)
              {
                localObject2 = com.tencent.mm.sdk.platformtools.aj.getContext();
                d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
                if (Settings.Secure.getInt(((Context)localObject2).getContentResolver(), "hide_navigationbar_enable", 0) != 3) {
                  break label590;
                }
                i = 1;
                label342:
                if (i != 0) {
                  break label595;
                }
                bool = false;
                label348:
                if (!bool)
                {
                  localObject2 = com.tencent.mm.sdk.platformtools.aj.getContext();
                  d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
                  if (Settings.Secure.getInt(((Context)localObject2).getContentResolver(), "navigation_gesture_on", 0) == 0) {
                    break label637;
                  }
                  i = 1;
                  label382:
                  if (i != 0) {
                    break label642;
                  }
                  bool = false;
                  if (!bool) {
                    break label791;
                  }
                }
              }
            }
            bool = true;
            label394:
            ((g)localObject1).Bey = Boolean.valueOf(bool);
            ad.i(g.TAG, "needShowBottomNavigator deviceShowBottomNav %b", new Object[] { ((g)localObject1).Bey });
            localObject2 = ((g)localObject1).Bey;
            if (localObject2 == null) {
              d.g.b.k.fvU();
            }
            if (!((Boolean)localObject2).booleanValue()) {
              break label796;
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(18210, new Object[] { Integer.valueOf(1) });
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1160L, 0L, 1L, false);
          }
          for (;;)
          {
            localObject1 = ((g)localObject1).Bey;
            if (localObject1 == null) {
              d.g.b.k.fvU();
            }
            bool = ((Boolean)localObject1).booleanValue();
            break;
            i = 0;
            break label261;
            label501:
            localObject2 = com.tencent.mm.sdk.platformtools.aj.getContext();
            d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
            bool = g.a.dW((Context)localObject2);
            ad.i(g.TAG, "miui hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
            break label267;
            label543:
            i = 0;
            break label301;
            label548:
            localObject2 = com.tencent.mm.sdk.platformtools.aj.getContext();
            d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
            bool = g.a.gF((Context)localObject2);
            ad.i(g.TAG, "huawei hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
            break label307;
            label590:
            i = 0;
            break label342;
            label595:
            localObject2 = com.tencent.mm.sdk.platformtools.aj.getContext();
            d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
            bool = g.a.gF((Context)localObject2);
            ad.i(g.TAG, "oppo hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
            break label348;
            label637:
            i = 0;
            break label382;
            label642:
            localObject2 = com.tencent.mm.sdk.platformtools.aj.getContext();
            d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
            if (Settings.Secure.getInt(((Context)localObject2).getContentResolver(), "navigation_gesture_mode", 0) == 1) {}
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label719;
              }
              com.tencent.mm.plugin.report.service.h.vKh.f(18210, new Object[] { Integer.valueOf(0) });
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1160L, 1L, 1L, false);
              bool = false;
              break;
            }
            label719:
            localObject2 = com.tencent.mm.sdk.platformtools.aj.getContext();
            d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
            if (!g.a.dW((Context)localObject2))
            {
              localObject2 = com.tencent.mm.sdk.platformtools.aj.getContext();
              d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
              if (!g.a.gF((Context)localObject2)) {
                break label786;
              }
            }
            label786:
            for (bool = true;; bool = false)
            {
              ad.i(g.TAG, "vivo hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
              break;
            }
            label791:
            bool = false;
            break label394;
            label796:
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1160L, 2L, 1L, false);
          }
        }
      }
    }
    AppMethodBeat.o(80320);
    return false;
  }
  
  protected void bFd()
  {
    AppMethodBeat.i(80303);
    this.BhW.bFd();
    AppMethodBeat.o(80303);
  }
  
  protected void bFe()
  {
    AppMethodBeat.i(80368);
    this.BhW.bFe();
    AppMethodBeat.o(80368);
  }
  
  protected void bFg()
  {
    AppMethodBeat.i(80341);
    this.BhW.bFg();
    AppMethodBeat.o(80341);
  }
  
  public boolean bFk()
  {
    return false;
  }
  
  protected com.tencent.mm.plugin.webview.core.h bFq()
  {
    AppMethodBeat.i(188038);
    Object localObject = this.nhy;
    com.tencent.mm.plugin.webview.model.ax localax = this.AMJ;
    BaseWebViewController.f localf = new BaseWebViewController.f(getIntent());
    boolean bool2 = getIntent().getBooleanExtra("key_trust_url", false);
    boolean bool3 = eoV();
    if ((!eoQ()) && (!eoR())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject = new com.tencent.mm.plugin.webview.core.h((MMWebView)localObject, localax, new BaseWebViewController.c(localf, bool2, bool3, bool1, getIntent().getBooleanExtra("neverGetA8Key", false)));
      ((com.tencent.mm.plugin.webview.core.h)localObject).a(new c());
      ((com.tencent.mm.plugin.webview.core.h)localObject).init();
      AppMethodBeat.o(188038);
      return localObject;
    }
  }
  
  public boolean bFr()
  {
    return false;
  }
  
  public final int beH()
  {
    AppMethodBeat.i(80335);
    int i = this.AMZ.beH();
    AppMethodBeat.o(80335);
    return i;
  }
  
  public void bol()
  {
    int k = 2;
    int m = 1;
    AppMethodBeat.i(80295);
    if ((this.BhO) || (this.BhN) || (isFinishing()))
    {
      ad.e("MicroMsg.WebViewUI", "edw postBinded finished");
      AppMethodBeat.o(80295);
      return;
    }
    Object localObject1 = eoI();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.webview.c.g)localObject1).ARR = this.AMZ.getJsapi();
    }
    this.kxf = this.AMZ.eiX();
    try
    {
      this.kxf.a(this.ASw, this.AMZ.eiZ());
      ad.i("MicroMsg.WebViewUI", "edw postBinded");
      this.Bie = new com.tencent.mm.plugin.webview.ui.tools.b.a(new com.tencent.mm.plugin.ball.a.e(this), this);
      localObject1 = getIntent().getStringExtra("float_ball_key");
      if (!bt.isNullOrNil((String)localObject1))
      {
        this.Bie.Z(2, (String)localObject1);
        this.Bie.OE(bEx());
        this.Bie.ef("rawUrl", bEx());
        this.Bie.awh(bEx());
        if (this.Bie != null) {
          this.Bie.aVZ();
        }
        if (this.Bic == null) {
          break label1001;
        }
        i = 1;
        if (this.Bic == null) {
          this.Bic = new HandOffURL(bEx(), bEx(), "");
        }
        localObject1 = this.Bie.getName();
        if (!bt.isNullOrNil((String)localObject1)) {
          this.Bic.setTitle((String)localObject1);
        }
        if (ekY())
        {
          if (i == 0) {
            break label1006;
          }
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Bic);
        }
        localObject1 = this.BhT;
        localObject2 = this.kxf;
      }
    }
    catch (RemoteException localException3)
    {
      try
      {
        str = ((com.tencent.mm.plugin.webview.stub.e)localObject2).axC("DNSAdvanceOpen");
        ad.i("MicroMsg.DNSPreGetOptimize", "switch open value : %s", new Object[] { str });
        if (bt.isNullOrNil(str))
        {
          ad.e("MicroMsg.DNSPreGetOptimize", "get switch value is null or nil");
          bool = false;
          if (bool) {
            break label1083;
          }
          ad.i("MicroMsg.DNSPreGetOptimize", "server closed the switch");
          if (eoJ()) {
            com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(187982);
                if (WebViewUI.this.nhy != null) {
                  WebViewUI.this.nhy.getCurWebviewClient().b(WebViewUI.this.nhy, WebViewUI.this.nhy.getUrl());
                }
                AppMethodBeat.o(187982);
              }
            });
          }
          localObject1 = this.AMZ.getTitle();
          axW((String)localObject1);
          axX((String)localObject1);
        }
      }
      catch (Exception localException3)
      {
        try
        {
          i = bt.getInt(this.kxf.axC("WebviewDisableX5Logo"), 0);
          bool = getIntent().getBooleanExtra("disable_bounce_scroll", false);
          ad.i("MicroMsg.WebViewUI", "getting flag of x5 logo state, disableX5Logo = %d, disableBounceScroll = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
          if ((i == 1) || (bool)) {
            this.Bis.tr(true);
          }
          if (getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_disable_over_scroll", false)) {
            this.Bis.tr(true);
          }
          this.BhS.bG("onJSAPIEnd", System.currentTimeMillis());
          if ((this.nhy != null) && (this.nhy.getIsX5Kernel()))
          {
            bool = true;
            com.tencent.mm.plugin.webview.model.ax.ax(bool, bt.nullAsNil(bEx()).startsWith("https://"));
          }
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              j = bt.getInt(this.kxf.axC("XwebBatchTranslateMaxByteLength"), 0);
              i = bt.getInt(this.kxf.axC("XwebBatchTranslateMaxCnt"), 0);
              ad.i("MicroMsg.WebViewUI", "getting flag of XwebBatchTranslate para BatchTranslateMaxByteLength  = " + j + " BatchTranslateCnt = " + i);
              localObject1 = this.BhZ;
              ((com.tencent.mm.plugin.webview.c)localObject1).AKv = j;
              ((com.tencent.mm.plugin.webview.c)localObject1).AKw = i;
              if (getIntent().getBooleanExtra("translate_webview", false))
              {
                localObject1 = this.BhZ;
                localObject2 = this.nhy;
                str = bEx();
                if ((localObject2 != null) && (!((WebView)localObject2).isSysKernel())) {
                  break;
                }
              }
              if (!getIntent().getBooleanExtra("forceHideShare", false)) {
                break label1379;
              }
              tt(false);
              ad.d("MicroMsg.WebViewUI", "[hakon] postBinded :%d: force hide", new Object[] { Long.valueOf(System.currentTimeMillis()) });
              this.BgK = LayoutInflater.from(this).inflate(2131496073, null);
              localObject1 = (FontChooserView)this.BgK.findViewById(2131300194);
              localObject2 = this.BgK.findViewById(2131300193);
              if ((this.nhy == null) || (!this.nhy.getIsX5Kernel())) {
                break label1431;
              }
              i = m;
              if (i == 0)
              {
                ((View)localObject2).setVisibility(0);
                ((View)localObject2).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(187996);
                    paramAnonymousView = AnimationUtils.loadAnimation(WebViewUI.this, 2130772060);
                    paramAnonymousView.setAnimationListener(new Animation.AnimationListener()
                    {
                      public final void onAnimationEnd(Animation paramAnonymous2Animation)
                      {
                        AppMethodBeat.i(187995);
                        WebViewUI.this.BgK.setVisibility(8);
                        AppMethodBeat.o(187995);
                      }
                      
                      public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                      
                      public final void onAnimationStart(Animation paramAnonymous2Animation) {}
                    });
                    WebViewUI.this.BgK.startAnimation(paramAnonymousView);
                    WebViewUI.this.BgK.setVisibility(8);
                    AppMethodBeat.o(187996);
                  }
                });
              }
              ((FontChooserView)localObject1).setOnChangeListener(new d((byte)0));
              localObject2 = new FrameLayout.LayoutParams(-1, -2, 80);
              this.BgK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              this.BgM.addView(this.BgK);
              this.BgK.setVisibility(8);
              try
              {
                if (!this.kxf.enj()) {
                  break label1484;
                }
                if ((!eoQ()) && (!eoR())) {
                  break label1436;
                }
                i = com.tencent.mm.plugin.webview.j.e.gN(getContext());
              }
              catch (Exception localException6)
              {
                for (;;)
                {
                  Bundle localBundle;
                  ad.w("MicroMsg.WebViewUI", "initFontChooserView, ex = " + localException6.getMessage());
                  i = 2;
                  continue;
                  j = i;
                }
              }
              j = k;
              if (i > 0)
              {
                if (i <= 8) {
                  break label1489;
                }
                j = k;
              }
              ((FontChooserView)localObject1).setSliderIndex(j - 1);
              this.AMZ.Su(j);
              SK(j);
              AppMethodBeat.o(80295);
              return;
              localRemoteException = localRemoteException;
              ad.printErrStackTrace("MicroMsg.WebViewUI", localRemoteException, "addCallbacker", new Object[0]);
              continue;
              this.Bie.Z(2, com.tencent.mm.plugin.ball.f.b.OI(bEx()));
              continue;
              label1001:
              i = 0;
              continue;
              label1006:
              ad.i("MicroMsg.WebViewUI", "[Handoff] call onWebViewCreate " + this.Bic.toString());
              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).a(this.Bic);
              continue;
              bool = str.equalsIgnoreCase("1");
              continue;
              localException1 = localException1;
              ad.e("MicroMsg.DNSPreGetOptimize", "get dns pre get switch failed");
              continue;
              try
              {
                label1083:
                localObject2 = ((com.tencent.mm.plugin.webview.stub.e)localObject2).axC("DNSAdvanceRelateDomain");
                if (!bt.isNullOrNil((String)localObject2)) {
                  break label1135;
                }
                ad.e("MicroMsg.DNSPreGetOptimize", "domain list is null, just return");
              }
              catch (Exception localException2)
              {
                ad.printErrStackTrace("MicroMsg.DNSPreGetOptimize", localException2, "", new Object[0]);
              }
              continue;
              label1135:
              com.tencent.mm.plugin.webview.a.a.ae(new b.1(localException2, (String)localObject2));
              continue;
              localException3 = localException3;
              ad.w("MicroMsg.WebViewUI", "getting flag of x5 logo state failed, ex = " + localException3.getMessage());
              i = 0;
            }
            bool = false;
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              Object localObject2;
              String str;
              ad.w("MicroMsg.WebViewUI", "getting flag of XwebBatchTranslate para failid, ex = " + localException4.getMessage());
              i = 0;
              j = 0;
              continue;
              localBundle = new Bundle();
              localBundle.putString("destLanguage", ac.eFu());
              localBundle.putString("url", str);
              localBundle.putString("translateTips", getString(2131766130));
              localBundle.putString("translateFinish", getString(2131766127));
              localBundle.putString("errorWording", getString(2131766126));
              localException4.AKt = getString(2131766130);
              localException4.AKu = getString(2131766131);
              com.tencent.mm.sdk.b.a.ESL.c(localException4.AKy);
              try
              {
                ((WebView)localObject2).invokeMiscMethod("translateWebSite", localBundle);
              }
              catch (Exception localException5)
              {
                ad.e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", new Object[] { localException5.getMessage() });
              }
              continue;
              label1379:
              boolean bool = getIntent().getBooleanExtra("showShare", true);
              tt(bool);
              ad.d("MicroMsg.WebViewUI", "[cpan] postBinded :%d: show:%b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(bool) });
              continue;
              label1431:
              i = 0;
              continue;
              label1436:
              i = com.tencent.mm.plugin.webview.j.e.a(getContext(), this.kxf, bEx());
            }
          }
        }
      }
    }
  }
  
  protected int bom()
  {
    AppMethodBeat.i(80254);
    int i = getActionbarColor();
    AppMethodBeat.o(80254);
    return i;
  }
  
  protected boolean bon()
  {
    return false;
  }
  
  public final void c(com.tencent.luggage.k.a.a.a parama)
  {
    AppMethodBeat.i(188034);
    this.Bht.c(parama);
    AppMethodBeat.o(188034);
  }
  
  protected final void c(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(80309);
    addIconOptionMenu(0, paramString, paramDrawable, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(187984);
        if (!this.BiF) {
          WebViewUI.this.bFd();
        }
        for (;;)
        {
          AppMethodBeat.o(187984);
          return true;
          WebViewUI.this.axZ(this.gXD);
        }
      }
    });
    AppMethodBeat.o(80309);
  }
  
  public boolean convertActivityFromTranslucent()
  {
    AppMethodBeat.i(80236);
    boolean bool = getIntent().getBooleanExtra("convertActivityFromTranslucent", true);
    AppMethodBeat.o(80236);
    return bool;
  }
  
  public final void d(com.tencent.luggage.k.a.a.a parama)
  {
    AppMethodBeat.i(188035);
    this.Bht.d(parama);
    AppMethodBeat.o(188035);
  }
  
  public final void dqY()
  {
    AppMethodBeat.i(80318);
    this.AQP.bZ("sendAppMessage", true);
    com.tencent.mm.plugin.webview.c.f localf = this.AQP;
    HashMap localHashMap = this.BhW.enY();
    getIntent();
    localf.l(localHashMap);
    this.AMJ.awM("mm_send_friend_count");
    AppMethodBeat.o(80318);
  }
  
  public final String dvR()
  {
    return this.AMZ.AKK;
  }
  
  public final int eiZ()
  {
    AppMethodBeat.i(197144);
    int i = this.AMZ.eiZ();
    AppMethodBeat.o(197144);
    return i;
  }
  
  public final String ejo()
  {
    AppMethodBeat.i(197145);
    String str = this.AMZ.getCurrentUrl();
    AppMethodBeat.o(197145);
    return str;
  }
  
  protected final boolean ejv()
  {
    AppMethodBeat.i(80308);
    boolean bool = this.AMZ.ejv();
    AppMethodBeat.o(80308);
    return bool;
  }
  
  public final boolean ekR()
  {
    AppMethodBeat.i(80354);
    if ((this.BhA != null) && (this.BhA.elw()) && (!bt.isNullOrNil(this.BhA.epd())) && (!bt.isNullOrNil(this.BhA.ely())) && (!bt.isNullOrNil(this.BhA.elz())))
    {
      Object localObject = this.BhA.epd();
      String str1 = this.BhA.ely();
      String str2 = this.BhA.elz();
      ad.i("MicroMsg.WebViewUI", "use js api close window confirm info : %s, %s, %s", new Object[] { localObject, str1, str2 });
      View localView = View.inflate(getContext(), 2131494763, null);
      final CheckBox localCheckBox = (CheckBox)localView.findViewById(2131302304);
      localCheckBox.setChecked(false);
      localCheckBox.setVisibility(8);
      TextView localTextView = (TextView)localView.findViewById(2131302306);
      localTextView.setText((CharSequence)localObject);
      localTextView.setTextColor(getResources().getColor(2131100711));
      localObject = (TextView)localView.findViewById(2131302305);
      ((TextView)localObject).setTextColor(getResources().getColor(2131100711));
      ((TextView)localObject).setVisibility(8);
      this.BhB = com.tencent.mm.ui.base.h.a(getContext(), true, "", localView, str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187997);
          if ((localCheckBox != null) && (localCheckBox.isChecked())) {}
          try
          {
            if (WebViewUI.this.kxf.enj()) {
              WebViewUI.this.kxf.iA(327792, 1);
            }
            WebViewUI.this.BhN = true;
            WebViewUI.this.BhB = null;
            k.BfO.close();
            if ((WebViewUI.u(WebViewUI.this) != null) && (WebViewUI.u(WebViewUI.this).rg(1)))
            {
              AppMethodBeat.o(187997);
              return;
            }
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            for (;;)
            {
              ad.e("MicroMsg.WebViewUI", "tryShowCloseWindowConfirmInfo, ex = " + paramAnonymousDialogInterface.getMessage());
            }
            WebViewUI.this.finish();
            AppMethodBeat.o(187997);
          }
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          WebViewUI.this.BhB = null;
        }
      });
      AppMethodBeat.o(80354);
      return true;
    }
    AppMethodBeat.o(80354);
    return false;
  }
  
  public final boolean ekY()
  {
    AppMethodBeat.i(80364);
    boolean bool1 = getIntent().getBooleanExtra("forceHideShare", false);
    boolean bool2 = getIntent().getBooleanExtra("showShare", true);
    boolean bool3 = getIntent().getBooleanExtra("KRightBtn", false);
    ad.i("MicroMsg.WebViewUI", "forceHideShare:%b showShareBtn:%b enableMinimize:%b, banRightBtn %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bEZ()), Boolean.valueOf(bool3) });
    if ((!bool3) && (!bool1) && (bool2) && (bEZ()))
    {
      AppMethodBeat.o(80364);
      return true;
    }
    AppMethodBeat.o(80364);
    return false;
  }
  
  public final com.tencent.mm.plugin.webview.c.b.a eko()
  {
    AppMethodBeat.i(188046);
    if (this.AQP != null)
    {
      locala = this.AQP.eko();
      AppMethodBeat.o(188046);
      return locala;
    }
    com.tencent.mm.plugin.webview.c.b.a locala = new com.tencent.mm.plugin.webview.c.b.a();
    AppMethodBeat.o(188046);
    return locala;
  }
  
  public final void emW()
  {
    AppMethodBeat.i(80228);
    if (this.Bii != null)
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n localn = this.Bii;
      localn.hide();
      localn.BuV.setText((CharSequence)"");
    }
    AppMethodBeat.o(80228);
  }
  
  protected void enK()
  {
    AppMethodBeat.i(80278);
    int i = getIntent().getIntExtra("webview_bg_color_rsID", -1);
    if ((i != -1) && (getContentView() != null))
    {
      setBackGroundColorResource(i);
      getContentView().setBackgroundResource(i);
      this.nhy.setBackgroundResource(17170445);
      this.BgL.setBackgroundResource(17170445);
      this.BgM.setBackgroundResource(17170445);
      AppMethodBeat.o(80278);
      return;
    }
    if (getIntent().getBooleanExtra(e.m.FIC, false))
    {
      this.nhy.setBackgroundColor(getResources().getColor(2131099828));
      AppMethodBeat.o(80278);
      return;
    }
    this.nhy.setBackgroundColor(getResources().getColor(2131101179));
    AppMethodBeat.o(80278);
  }
  
  public final void enX()
  {
    AppMethodBeat.i(80305);
    this.BhW.enX();
    AppMethodBeat.o(80305);
  }
  
  public final void eoA()
  {
    AppMethodBeat.i(80272);
    try
    {
      this.Bis.release();
      this.nhy.stopLoading();
      this.nhy.removeAllViews();
      this.nhy.clearView();
      if (this.AQP != null) {
        this.AQP.detach();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        this.nhy.destroy();
        this.nhy = null;
        finish();
        ad.eFw();
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(80272);
        return;
        localException1 = localException1;
        ad.e("MicroMsg.WebViewUI", "forceQuit, ex = " + localException1.getMessage());
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.w("MicroMsg.WebViewUI", "forceQuit, viewWV destroy, ex = %s", new Object[] { localException2.getMessage() });
        }
      }
    }
  }
  
  protected void eoB()
  {
    AppMethodBeat.i(80275);
    this.BgZ = System.currentTimeMillis();
    this.nhy.goBack();
    k localk = k.BfO;
    ad.v("MicroMsg.WebViewReportUtil", "goBack traceid %s", new Object[] { localk.wSh });
    if (!bt.isNullOrNil(localk.wSh)) {
      localk.lI(5);
    }
    AppMethodBeat.o(80275);
  }
  
  protected int eoC()
  {
    AppMethodBeat.i(80277);
    if (this.BgS == null)
    {
      AppMethodBeat.o(80277);
      return 0;
    }
    int i = this.BgS.ers();
    AppMethodBeat.o(80277);
    return i;
  }
  
  protected void eoD()
  {
    AppMethodBeat.i(80279);
    if (getIntent() == null)
    {
      AppMethodBeat.o(80279);
      return;
    }
    if (getIntent().hasExtra("show_full_screen")) {
      ay(getIntent().getBooleanExtra("show_full_screen", false), true);
    }
    AppMethodBeat.o(80279);
  }
  
  protected w eoE()
  {
    try
    {
      AppMethodBeat.i(80286);
      if (this.Bhq == null) {
        this.Bhq = new MMWebView.b(new b());
      }
      w localw = this.Bhq;
      AppMethodBeat.o(80286);
      return localw;
    }
    finally {}
  }
  
  protected int eoF()
  {
    AppMethodBeat.i(80287);
    if (this.BhI)
    {
      AppMethodBeat.o(80287);
      return 2131689490;
    }
    AppMethodBeat.o(80287);
    return 2131689492;
  }
  
  protected boolean eoG()
  {
    return true;
  }
  
  public final void eoH()
  {
    AppMethodBeat.i(175800);
    View localView = this.nhy.getView();
    localView.scrollTo(localView.getScrollX(), 0);
    this.AMJ.emq().A(new Object[] { bEx(), Integer.valueOf(7) }).report();
    AppMethodBeat.o(175800);
  }
  
  protected com.tencent.mm.plugin.webview.c.g eoI()
  {
    return null;
  }
  
  protected boolean eoJ()
  {
    return false;
  }
  
  protected final void eoK()
  {
    AppMethodBeat.i(80304);
    if (this.AMZ != null) {
      this.AMZ.reload();
    }
    AppMethodBeat.o(80304);
  }
  
  protected final void eoL()
  {
    AppMethodBeat.i(188043);
    if (this.AMZ != null) {
      if (com.tencent.mm.plugin.webview.c.j.ekH()) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.webview.c.j.tk(bool);
      this.AMZ.reload();
      AppMethodBeat.o(188043);
      return;
    }
  }
  
  protected final LinkedList<d.a> eoM()
  {
    AppMethodBeat.i(80307);
    if (this.nhy == null)
    {
      ad.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
      AppMethodBeat.o(80307);
      return null;
    }
    Object localObject = bEx();
    if (this.nhy != null)
    {
      String str = this.nhy.getUrl();
      if (!bt.isNullOrNil(str))
      {
        localObject = str;
        for (;;)
        {
          if (localObject == null)
          {
            AppMethodBeat.o(80307);
            return null;
          }
          try
          {
            localObject = new URL((String)localObject);
            Pattern localPattern = Pattern.compile(".*(\\.wanggou\\.com|\\.jd\\.com)");
            str = ((URL)localObject).getHost();
            boolean bool = bt.isNullOrNil(str);
            if (bool)
            {
              AppMethodBeat.o(80307);
              return null;
            }
            localObject = str;
            if (!str.startsWith(".")) {
              localObject = ".".concat(String.valueOf(str));
            }
            ad.d("MicroMsg.WebViewUI", "host = %s", new Object[] { localObject });
            if (localPattern.matcher((CharSequence)localObject).matches())
            {
              long l;
              if (this.BhJ == null)
              {
                l = System.currentTimeMillis();
                this.BhJ = this.kxf.eno();
                if (this.BhJ == null) {
                  break label281;
                }
              }
              label281:
              for (bool = true;; bool = false)
              {
                ad.d("MicroMsg.WebViewUI", "[hakon] getConfigListMap %b, cost %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
                if ((this.BhJ == null) || (this.BhJ.size() <= 0)) {
                  break;
                }
                localObject = com.tencent.mm.m.d.k(this.BhJ);
                AppMethodBeat.o(80307);
                return localObject;
              }
            }
          }
          catch (Exception localException)
          {
            ad.d("MicroMsg.WebViewUI", "[hakon] getJDMenuItems, ex = ", new Object[] { localException.getMessage() });
            AppMethodBeat.o(80307);
            return null;
          }
        }
      }
    }
  }
  
  protected final int eoN()
  {
    AppMethodBeat.i(80314);
    int i = 2131690603;
    if (eoM() != null) {
      i = 2131690809;
    }
    AppMethodBeat.o(80314);
    return i;
  }
  
  protected final void eoP()
  {
    AppMethodBeat.i(80344);
    this.BhC.setVisibility(0);
    AppMethodBeat.o(80344);
  }
  
  protected boolean eoQ()
  {
    return false;
  }
  
  protected boolean eoR()
  {
    return false;
  }
  
  public void eoT()
  {
    AppMethodBeat.i(80356);
    if (eoS())
    {
      AppMethodBeat.o(80356);
      return;
    }
    eoU();
    if (!ekR())
    {
      this.BhN = true;
      k.BfO.close();
      if ((this.Bie != null) && (this.Bie.rg(1)))
      {
        AppMethodBeat.o(80356);
        return;
      }
      finish();
    }
    AppMethodBeat.o(80356);
  }
  
  protected boolean eoV()
  {
    return true;
  }
  
  protected final boolean eoW()
  {
    AppMethodBeat.i(80360);
    if (this.BiC != -3)
    {
      showVKB();
      AppMethodBeat.o(80360);
      return true;
    }
    AppMethodBeat.o(80360);
    return false;
  }
  
  protected final void eoX()
  {
    AppMethodBeat.i(188048);
    if ((this.BhN) || (this.BhO) || (isFinishing()))
    {
      AppMethodBeat.o(188048);
      return;
    }
    if (this.AMZ != null)
    {
      com.tencent.mm.plugin.webview.core.h localh = this.AMZ;
      localh.k(localh.bEx(), true, 8);
    }
    if (this.BhC != null) {
      this.BhC.setVisibility(8);
    }
    this.AMJ.emq().A(new Object[] { bEx(), Integer.valueOf(4) }).report();
    AppMethodBeat.o(188048);
  }
  
  public final MMWebView eoY()
  {
    return this.nhy;
  }
  
  protected final boolean eoh()
  {
    return this.AMZ.ALt;
  }
  
  protected final Map<String, String> eoi()
  {
    return this.AMZ.AKR;
  }
  
  public final com.tencent.mm.plugin.webview.ui.tools.b.a eoj()
  {
    return this.Bie;
  }
  
  protected final com.tencent.mm.plugin.webview.model.aq eok()
  {
    return this.AMZ.AMc;
  }
  
  protected final com.tencent.mm.plugin.webview.ui.tools.widget.n eol()
  {
    AppMethodBeat.i(80223);
    if (this.Bii == null)
    {
      this.Bii = new com.tencent.mm.plugin.webview.ui.tools.widget.n(this, new s(getContext(), 2131820847));
      this.Bii.setVisibility(8);
      localObject = (ViewParent)getWindow().getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        ((ViewGroup)localObject).addView(this.Bii, new FrameLayout.LayoutParams(-1, -1));
        bFM();
      }
    }
    Object localObject = this.Bii;
    AppMethodBeat.o(80223);
    return localObject;
  }
  
  public final MPVideoPlayFullScreenView eom()
  {
    AppMethodBeat.i(80224);
    if (this.Bik == null)
    {
      this.Bik = new MPVideoPlayFullScreenView(this, null);
      this.Bik.setVisibility(8);
      localObject = (ViewParent)getWindow().getDecorView();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).addView(this.Bik, new FrameLayout.LayoutParams(-1, -1));
      }
    }
    Object localObject = this.Bik;
    AppMethodBeat.o(80224);
    return localObject;
  }
  
  protected final void eon()
  {
    AppMethodBeat.i(80225);
    if (this.Bii != null)
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n localn = this.Bii;
      if (localn.getSayFooter() != null)
      {
        localObject = localn.getSayFooter();
        if (((MPSmileyFooter)localObject).fSY != null)
        {
          ((MPSmileyFooter)localObject).fSY.exm();
          ((MPSmileyFooter)localObject).fSY.destroy();
        }
      }
      Object localObject = com.tencent.mm.plugin.webview.ui.tools.widget.p.Bwh;
      com.tencent.mm.plugin.webview.ui.tools.widget.p.b(localn.Bvm.fqw);
    }
    AppMethodBeat.o(80225);
  }
  
  public final com.tencent.mm.ui.base.p eoo()
  {
    return this.fqw;
  }
  
  public final boolean eop()
  {
    AppMethodBeat.i(188030);
    boolean bool = this.Bht.eop();
    AppMethodBeat.o(188030);
    return bool;
  }
  
  protected final void eor()
  {
    AppMethodBeat.i(80251);
    if ((this.Bio == null) || (eos()))
    {
      AppMethodBeat.o(80251);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.Bio.getLayoutParams();
    int i = eot();
    if (i != localMarginLayoutParams.topMargin)
    {
      localMarginLayoutParams.topMargin = i;
      this.Bio.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(80251);
  }
  
  protected boolean eou()
  {
    return true;
  }
  
  final boolean eov()
  {
    AppMethodBeat.i(80255);
    if ((!bt.isNullOrNil(this.sfC)) && (this.sfC.equals("black")))
    {
      AppMethodBeat.o(80255);
      return true;
    }
    AppMethodBeat.o(80255);
    return false;
  }
  
  protected final void eow()
  {
    AppMethodBeat.i(80256);
    if ((com.tencent.mm.compatible.util.d.lf(21)) && (this.sfB != 0))
    {
      setActionbarColor(this.sfB);
      AppMethodBeat.o(80256);
      return;
    }
    setStatusBarColor(bom());
    AppMethodBeat.o(80256);
  }
  
  public final String eox()
  {
    return this.AMZ.AKH;
  }
  
  public final String eoy()
  {
    return this.AMZ.AMf;
  }
  
  public void finish()
  {
    AppMethodBeat.i(80235);
    if (this.Bhe) {
      setResult(-1);
    }
    if (this.handler != null) {
      this.handler.removeCallbacksAndMessages(null);
    }
    this.BhO = true;
    if (this.AMZ != null)
    {
      com.tencent.mm.plugin.webview.core.h localh = this.AMZ;
      localh.ejg();
      localh.AKN = true;
    }
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.e.c.class) != null) {
      ((com.tencent.mm.plugin.appbrand.e.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.e.c.class)).aTi();
    }
    super.finish();
    AppMethodBeat.o(80235);
  }
  
  protected void fl(String paramString, int paramInt)
  {
    AppMethodBeat.i(80276);
    if (this.BgS == null)
    {
      AppMethodBeat.o(80276);
      return;
    }
    WebViewInputFooter localWebViewInputFooter = this.BgS;
    localWebViewInputFooter.setVisibility(0);
    if (localWebViewInputFooter.BwC != null) {
      localWebViewInputFooter.BwC.setVisibility(0);
    }
    if (localWebViewInputFooter.BwB != null)
    {
      localWebViewInputFooter.BwB.setEnabled(true);
      localWebViewInputFooter.BwB.setBackgroundResource(2131232723);
    }
    if (localWebViewInputFooter.Bwy != null) {
      localWebViewInputFooter.Bwy.setVisibility(0);
    }
    localWebViewInputFooter.BwD = false;
    if (localWebViewInputFooter.BwB != null)
    {
      localWebViewInputFooter.BwB.setFocusable(true);
      localWebViewInputFooter.BwB.setFocusableInTouchMode(true);
      localWebViewInputFooter.BwB.requestFocus();
    }
    if (localWebViewInputFooter.imP != null) {
      localWebViewInputFooter.imP.showVKB();
    }
    localWebViewInputFooter.state = 0;
    if (!bt.isNullOrNil(paramString)) {
      this.BgS.setText(paramString);
    }
    if (paramInt >= 0) {
      this.BgS.setMaxCount(paramInt);
    }
    AppMethodBeat.o(80276);
  }
  
  protected final int getActionBarHeight()
  {
    AppMethodBeat.i(80250);
    if (getResources().getDimensionPixelSize(2131167019) > com.tencent.mm.cd.a.fromDPToPix(this, 48))
    {
      i = getResources().getDimensionPixelSize(2131167019);
      AppMethodBeat.o(80250);
      return i;
    }
    if (com.tencent.mm.compatible.util.i.ip(this))
    {
      i = getResources().getDimensionPixelSize(2131165252);
      AppMethodBeat.o(80250);
      return i;
    }
    int i = getResources().getDimensionPixelSize(2131165251);
    AppMethodBeat.o(80250);
    return i;
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(188041);
    com.tencent.mm.plugin.webview.ui.tools.d.a locala = this.Bht.BtI;
    if (locala != null) {}
    for (boolean bool = locala.bcg(); bool; bool = false)
    {
      i = getRequestedOrientation();
      AppMethodBeat.o(188041);
      return i;
    }
    int i = this.screenOrientation;
    AppMethodBeat.o(188041);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131496078;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(188040);
    String str = this.AMZ.nhy.getSettings().getUserAgentString();
    AppMethodBeat.o(188040);
    return str;
  }
  
  public final com.tencent.luggage.k.a.c.c getWebViewPluginClientProxy()
  {
    if (this.AMZ != null) {
      return this.AMZ.AMI;
    }
    return null;
  }
  
  protected void goBack()
  {
    AppMethodBeat.i(188036);
    if (this.nhy == null)
    {
      AppMethodBeat.o(188036);
      return;
    }
    if (this.BhE)
    {
      AppMethodBeat.o(188036);
      return;
    }
    if (this.nhy.canGoBack())
    {
      eoB();
      AppMethodBeat.o(188036);
      return;
    }
    k.BfO.close();
    finish();
    AppMethodBeat.o(188036);
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(80361);
    super.hideVKB();
    this.BiC = -2;
    AppMethodBeat.o(80361);
  }
  
  public void initSwipeBack()
  {
    AppMethodBeat.i(80222);
    super.initSwipeBack();
    if (getSwipeBackLayout() == null)
    {
      AppMethodBeat.o(80222);
      return;
    }
    if (!this.BhF)
    {
      AppMethodBeat.o(80222);
      return;
    }
    View localView1 = getSwipeBackLayout().getChildAt(0);
    getSwipeBackLayout().removeView(localView1);
    com.tencent.mm.ui.statusbar.b localb = new com.tencent.mm.ui.statusbar.b(this);
    if ((localView1 instanceof FrameLayout))
    {
      View localView2 = ((FrameLayout)localView1).getChildAt(0);
      ViewGroup.LayoutParams localLayoutParams = localView2.getLayoutParams();
      ((FrameLayout)localView1).removeView(localView2);
      localb.addView(localView2, localLayoutParams);
    }
    for (;;)
    {
      getSwipeBackLayout().addView(localb);
      getSwipeBackLayout().setContentView(localb);
      this.BhG = true;
      AppMethodBeat.o(80222);
      return;
      localb.addView(localView1);
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(80284);
    this.BgL = ((WebViewKeyboardLinearLayout)findViewById(2131306921));
    this.BgM = ((FrameLayout)findViewById(2131304241));
    this.Bhg = getIntent().getBooleanExtra("finishviewifloadfailed", false);
    this.Bhf = getIntent().getBooleanExtra("is_favorite_item", false);
    this.vZK = getIntent().getBooleanExtra("isWebwx", true);
    boolean bool = getIntent().getBooleanExtra("show_feedback", false);
    this.BhD = bt.nullAsNil(getIntent().getStringExtra("sentUsername"));
    if (bool) {
      addTextOptionMenu(1, getString(2131763230), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(187961);
          try
          {
            paramAnonymousMenuItem = WebViewUI.this.kxf.axH(null);
            WebViewUI.this.loadUrl(paramAnonymousMenuItem);
            AppMethodBeat.o(187961);
            return false;
          }
          catch (RemoteException paramAnonymousMenuItem)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.WebViewUI", paramAnonymousMenuItem, "[oneliang]feedback exception:%s", new Object[] { paramAnonymousMenuItem.getMessage() });
            }
          }
        }
      });
    }
    this.BgF = ((ProgressBar)findViewById(2131298857));
    this.BhC = findViewById(2131303929);
    this.BhC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187962);
        WebViewUI.this.eoX();
        AppMethodBeat.o(187962);
      }
    });
    if (this.vZK)
    {
      localObject1 = bt.nullAsNil(getIntent().getStringExtra("title"));
      if (((CharSequence)localObject1).length() > 0) {
        this.BgD = true;
      }
      setMMTitle((CharSequence)localObject1);
    }
    for (;;)
    {
      this.BeB = findViewById(2131306901);
      if (this.BeB != null)
      {
        this.BgH = new g(this.BeB, this.BgL, this.nhy);
        this.BeB.setVisibility(8);
        this.BgI = ((ImageButton)findViewById(2131306897));
        this.BgI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(187993);
            if ((WebViewUI.this.nhy != null) && (WebViewUI.this.nhy.canGoBack())) {
              WebViewUI.this.eoB();
            }
            AppMethodBeat.o(187993);
          }
        });
        this.BgJ = ((ImageButton)findViewById(2131306900));
        this.BgJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(187994);
            if ((WebViewUI.this.nhy != null) && (WebViewUI.this.nhy.canGoForward())) {
              WebViewUI.this.nhy.goForward();
            }
            AppMethodBeat.o(187994);
          }
        });
      }
      if (this.nhy != null) {
        break;
      }
      ad.i("MicroMsg.WebViewUI", "initView viewWV is null");
      finish();
      AppMethodBeat.o(80284);
      return;
      setMMTitle("");
    }
    if (Bhs == WebSettings.RenderPriority.NORMAL)
    {
      ad.i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
      this.nhy.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
      Bhs = WebSettings.RenderPriority.HIGH;
    }
    Object localObject3 = this.Bis;
    Object localObject1 = getContentView();
    ((j)localObject3).Bfz = ((LogoWebViewWrapper)((View)localObject1).findViewById(2131301589));
    ((j)localObject3).Bfy = ((ImageView)((View)localObject1).findViewById(2131306923));
    ((j)localObject3).BfH = ((View)localObject1).findViewById(2131306922);
    if (((j)localObject3).BfH != null)
    {
      ((j)localObject3).BfI = ((j)localObject3).BfH.findViewById(2131307117);
      ((j)localObject3).BfJ = ((TextView)((j)localObject3).BfI.findViewById(2131307119));
    }
    ((j)localObject3).BfA = BackwardSupportUtil.b.g(((j)localObject3).Bfz.getContext(), 72.0F);
    Object localObject2;
    if (((j)localObject3).Bfy == null)
    {
      localObject1 = "null";
      if (((j)localObject3).Bfz != null) {
        break label1197;
      }
      localObject2 = "null";
      label533:
      ad.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage.id = %s, logoWrapper.id = %s", new Object[] { localObject1, localObject2 });
      ad.d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", new Object[] { Integer.valueOf(((j)localObject3).BfA) });
      localObject1 = this.Bis;
      localObject2 = this.nhy;
      ((MMWebView)localObject2).setCompetitorView(((j)localObject1).Bfz);
      ((MMWebView)localObject2).feS();
      if (Build.VERSION.SDK_INT <= 10) {
        ((j)localObject1).Bfz.getWebViewContainer().setBackgroundColor(((j)localObject1).Bfz.getResources().getColor(2131101165));
      }
      localObject3 = ((j)localObject1).Bfz;
      ((LogoWebViewWrapper)localObject3).getWebViewContainer();
      if (((LogoWebViewWrapper)localObject3).BcW != null)
      {
        ((LogoWebViewWrapper)localObject3).ftD = ((WebView)localObject2);
        ((LogoWebViewWrapper)localObject3).BcW.addView(((LogoWebViewWrapper)localObject3).ftD);
      }
      if ((!((MMWebView)localObject2).isXWalkKernel()) && (!((MMWebView)localObject2).getIsX5Kernel())) {
        break label1212;
      }
      ((j)localObject1).BfK = true;
      label689:
      if ((((j)localObject1).BfI != null) && (!((MMWebView)localObject2).getIsX5Kernel()))
      {
        ((ImageView)((j)localObject1).BfI.findViewById(2131307118)).setVisibility(8);
        ((TextView)((j)localObject1).BfI.findViewById(2131301014)).setText("");
      }
      if ((!((j)localObject1).BfK) || (((j)localObject1).BfL)) {
        break label1220;
      }
      ((j)localObject1).tr(false);
      ((j)localObject1).eof();
    }
    for (;;)
    {
      enK();
      this.BgN = ((FrameLayout)findViewById(2131298736));
      ad.i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.nhy.getIsX5Kernel());
      this.nhy.setWebViewClientExtension(new b(this));
      if (this.nhy.getIsX5Kernel())
      {
        this.nhy.setWebViewCallbackClient(this.Big);
        localObject1 = this.Bis;
        localObject2 = new LogoWebViewWrapper.a()
        {
          public final void enC()
          {
            AppMethodBeat.i(187963);
            if (WebViewUI.this.nhy.getIsX5Kernel()) {
              WebViewUI.this.AMJ.emq().A(new Object[] { WebViewUI.this.bEx(), Integer.valueOf(10) }).report();
            }
            AppMethodBeat.o(187963);
          }
        };
        if (((j)localObject1).Bfz != null) {
          ((j)localObject1).Bfz.setMMOverScrollListener((LogoWebViewWrapper.a)localObject2);
        }
      }
      this.BgS = ((WebViewInputFooter)findViewById(2131306916));
      if (this.BgS != null)
      {
        this.BgS.hide();
        this.BgS.setOnTextSendListener(new WebViewInputFooter.c()
        {
          public final void awg(String paramAnonymousString)
          {
            AppMethodBeat.i(187964);
            WebViewUI.a(WebViewUI.this, paramAnonymousString);
            AppMethodBeat.o(187964);
          }
        });
        this.BgS.setOnSmileyChosenListener(new WebViewInputFooter.a()
        {
          public final boolean NL(String paramAnonymousString)
          {
            AppMethodBeat.i(187965);
            com.tencent.mm.plugin.webview.c.f localf;
            if (WebViewUI.this.AQP != null)
            {
              localf = WebViewUI.this.AQP;
              if (localf.yZR) {
                break label44;
              }
              ad.e("MicroMsg.JsApiHandler", "not ready");
            }
            for (;;)
            {
              AppMethodBeat.o(187965);
              return true;
              label44:
              HashMap localHashMap = new HashMap();
              localHashMap.put("smiley", paramAnonymousString);
              com.tencent.mm.sdk.platformtools.aq.f(new f.24(localf, l.a.b("onGetSmiley", localHashMap, localf.ARm, localf.ARn)));
            }
          }
        });
        this.BgS.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b()
        {
          public final void elf()
          {
            AppMethodBeat.i(187966);
            WebViewUI.a(WebViewUI.this, 0);
            AppMethodBeat.o(187966);
          }
          
          public final void elg()
          {
            AppMethodBeat.i(187967);
            WebViewKeyboardLinearLayout localWebViewKeyboardLinearLayout = WebViewUI.this.BgL;
            if ((localWebViewKeyboardLinearLayout != null) && (localWebViewKeyboardLinearLayout.getKeyBoardHeight() > 0)) {
              WebViewUI.a(WebViewUI.this, localWebViewKeyboardLinearLayout.getKeyBoardHeight());
            }
            AppMethodBeat.o(187967);
          }
        });
      }
      this.BgT = ((WebViewSearchContentInputFooter)findViewById(2131304407));
      if (this.BgT != null)
      {
        this.BgT.setActionDelegate(new WebViewSearchContentInputFooter.a()
        {
          public final void a(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
          {
            AppMethodBeat.i(187969);
            if (paramAnonymousWebViewSearchContentInputFooter.getVisibility() == 0) {
              b(paramAnonymousWebViewSearchContentInputFooter);
            }
            AppMethodBeat.o(187969);
          }
          
          public final void b(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
          {
            AppMethodBeat.i(187972);
            WebViewUI.this.nhy.clearMatches();
            paramAnonymousWebViewSearchContentInputFooter.reset();
            WebViewUI.this.BgT.D(0, 0, true);
            WebViewUI.a(WebViewUI.this, false);
            WebViewUI.this.nhy.findAllAsync(paramAnonymousWebViewSearchContentInputFooter.getSearchContent());
            AppMethodBeat.o(187972);
          }
          
          public final boolean c(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(187973);
            if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0)) {
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(480L, 6L, 1L, false);
            }
            AppMethodBeat.o(187973);
            return false;
          }
          
          public final void elh()
          {
            AppMethodBeat.i(187968);
            WebViewUI.b(WebViewUI.this, 0);
            WebViewUI.this.nhy.clearMatches();
            WebViewUI.this.BgT.erq();
            AppMethodBeat.o(187968);
          }
          
          public final void eli()
          {
            AppMethodBeat.i(187970);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(480L, 5L, 1L, false);
            WebViewUI.this.nhy.findNext(false);
            AppMethodBeat.o(187970);
          }
          
          public final void elj()
          {
            AppMethodBeat.i(187971);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(480L, 4L, 1L, false);
            WebViewUI.this.nhy.findNext(true);
            AppMethodBeat.o(187971);
          }
        });
        this.nhy.setFindListener(new WebView.FindListener()
        {
          public final void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(187974);
            if ((paramAnonymousBoolean) && (!WebViewUI.b(WebViewUI.this)) && (!bt.isNullOrNil(WebViewUI.this.BgT.getSearchContent())))
            {
              if (paramAnonymousInt2 != 0) {
                break label81;
              }
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(480L, 3L, 1L, false);
            }
            for (;;)
            {
              WebViewUI.a(WebViewUI.this, true);
              WebViewUI.this.BgT.D(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
              AppMethodBeat.o(187974);
              return;
              label81:
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(480L, 2L, 1L, false);
            }
          }
        });
      }
      this.BgO = ((MovingImageButton)findViewById(2131300327));
      this.Bhl = findViewById(2131306913);
      if (this.Bhl != null) {
        this.Bhl.setVisibility(8);
      }
      this.nhy.setWebChromeClient(eoE());
      this.nhy.setDownloadListener(new DownloadListener()
      {
        public final void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
        {
          AppMethodBeat.i(187975);
          ad.i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + paramAnonymousString1 + ", mimetype = " + paramAnonymousString4 + ", userAgent = " + paramAnonymousString2 + ", contentDisposition = " + paramAnonymousString3);
          int i = WebViewUI.this.getIntent().getIntExtra("key_download_restrict", 0);
          String str = WebViewUI.this.getIntent().getStringExtra("key_function_id");
          if (!bt.isNullOrNil(str)) {
            com.tencent.mm.plugin.report.service.h.vKh.f(14596, new Object[] { str, Integer.valueOf(i), Integer.valueOf(0) });
          }
          if (i == 1)
          {
            ad.e("MicroMsg.WebViewUI", "not allow download file : %s", new Object[] { paramAnonymousString1 });
            AppMethodBeat.o(187975);
            return;
          }
          if ((paramAnonymousString4 != null) && (paramAnonymousString4.equalsIgnoreCase("application/vnd.android.package-archive")))
          {
            ad.v("MicroMsg.WebViewUI", "edw onDownloadStart, report download url: %s", new Object[] { paramAnonymousString1 });
            e.a(WebViewUI.this.kxf, 11154, new Object[] { paramAnonymousString1 });
          }
          if (WebViewUI.this.kxg == null)
          {
            ad.e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
            AppMethodBeat.o(187975);
            return;
          }
          int j = 0;
          if (paramAnonymousString4 != null)
          {
            boolean bool1 = WebViewUI.c(WebViewUI.this);
            ad.i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", new Object[] { Boolean.valueOf(bool1) });
            str = WebViewUI.aya(paramAnonymousString3);
            if ((str == null) || (!Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", str))) {
              break label459;
            }
            i = 1;
            boolean bool2 = com.tencent.mm.plugin.webview.core.a.ALV.contains(paramAnonymousString4.toLowerCase());
            if ((!bool1) || ((i == 0) && (!bool2))) {
              break label465;
            }
          }
          label459:
          label465:
          for (i = 1;; i = 0)
          {
            j = i;
            if (i != 0)
            {
              j = i;
              if (str != null)
              {
                j = i;
                if (str.endsWith(".apk"))
                {
                  j = 0;
                  ad.i("MicroMsg.WebViewUI", "onDownloadStart is apk");
                }
              }
              e.a(WebViewUI.this.kxf, 18111, new Object[] { WebViewUI.this.ejo(), paramAnonymousString1, paramAnonymousString4, paramAnonymousString3, paramAnonymousString2, Long.valueOf(paramAnonymousLong) });
            }
            if ((j != 0) || (WebViewUI.this.kxg.emR().mb(24)) || (WebViewUI.d(WebViewUI.this))) {
              break label471;
            }
            ad.e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
            AppMethodBeat.o(187975);
            return;
            i = 0;
            break;
          }
          label471:
          paramAnonymousString2 = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString1));
          paramAnonymousString2.addFlags(268435456);
          try
          {
            paramAnonymousString1 = WebViewUI.this;
            paramAnonymousString2 = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousString2);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString1, paramAnonymousString2.adn(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$22", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString1.startActivity((Intent)paramAnonymousString2.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString1, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$22", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(187975);
            return;
          }
          catch (Exception paramAnonymousString1)
          {
            ad.e("MicroMsg.WebViewUI", "startActivity fail, e = " + paramAnonymousString1.getMessage());
            AppMethodBeat.o(187975);
          }
        }
      });
      this.nhy.requestFocus(130);
      this.nhy.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(187977);
          if ((WebViewUI.this.BgK != null) && (WebViewUI.this.BgK.getVisibility() == 0))
          {
            Animation localAnimation = AnimationUtils.loadAnimation(WebViewUI.this, 2130772060);
            localAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(187976);
                WebViewUI.this.BgK.setVisibility(8);
                AppMethodBeat.o(187976);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationStart(Animation paramAnonymous2Animation) {}
            });
            WebViewUI.this.BgK.startAnimation(localAnimation);
            WebViewUI.this.BgK.setVisibility(8);
          }
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          while (WebViewUI.this.nhy == null)
          {
            AppMethodBeat.o(187977);
            return false;
            if (!paramAnonymousView.hasFocus()) {
              paramAnonymousView.requestFocus();
            }
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              WebViewUI.this.mUE = ((int)paramAnonymousMotionEvent.getRawX());
              WebViewUI.this.mUF = ((int)paramAnonymousMotionEvent.getRawY());
            }
          }
          if ((paramAnonymousMotionEvent.getAction() == 0) || (paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 261) || (paramAnonymousMotionEvent.getAction() == 517))
          {
            if (paramAnonymousMotionEvent.getPointerCount() <= 1) {
              break label249;
            }
            WebViewUI.this.nhy.getSettings().setBuiltInZoomControls(true);
            WebViewUI.this.nhy.getSettings().setSupportZoom(true);
          }
          for (;;)
          {
            AppMethodBeat.o(187977);
            return false;
            label249:
            WebViewUI.this.nhy.getSettings().setBuiltInZoomControls(false);
            WebViewUI.this.nhy.getSettings().setSupportZoom(false);
          }
        }
      });
      this.nhy.feR();
      this.BhV = new h(this);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(187978);
          WebViewUI.this.hideVKB();
          WebViewUI.this.eoT();
          ad.i("MicroMsg.WebViewUI", "on back btn press");
          AppMethodBeat.o(187978);
          return true;
        }
      }, eoF());
      if (eoG()) {
        this.BgL.setOnkbdStateListener(new KeyboardLinearLayout.a()
        {
          public final void DK(int paramAnonymousInt)
          {
            AppMethodBeat.i(187988);
            ad.i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = ".concat(String.valueOf(paramAnonymousInt)));
            WebViewUI.a(WebViewUI.this, WebViewUI.this.BgL, paramAnonymousInt);
            if (paramAnonymousInt == -3)
            {
              WebViewUI.this.AMJ.emm().AYP = 1;
              int i = WebViewUI.this.BgL.getKeyBoardHeight();
              if (i > 0)
              {
                WebViewUI.b(WebViewUI.this, i);
                WebViewUI.a(WebViewUI.this, i);
              }
              if (WebViewUI.f(WebViewUI.this)) {
                WebViewUI.g(WebViewUI.this).ert();
              }
            }
            for (;;)
            {
              WebViewUI.this.TC(paramAnonymousInt);
              WebViewUI.this.BiC = paramAnonymousInt;
              AppMethodBeat.o(187988);
              return;
              WebViewUI.b(WebViewUI.this, 0);
              WebViewUI.a(WebViewUI.this, 0);
            }
          }
        });
      }
      this.BgE = ((MMFalseProgressBar)findViewById(2131306899));
      super.setTitleBarDoubleClickListener(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187979);
          WebViewUI.this.eoH();
          AppMethodBeat.o(187979);
        }
      });
      AppMethodBeat.o(80284);
      return;
      localObject1 = String.valueOf(((j)localObject3).Bfy.getId());
      break;
      label1197:
      localObject2 = String.valueOf(((j)localObject3).Bfz.getId());
      break label533;
      label1212:
      ((j)localObject1).BfK = false;
      break label689;
      label1220:
      ((j)localObject1).tr(true);
    }
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(185934);
    loadUrl(paramString, null, false);
    AppMethodBeat.o(185934);
  }
  
  protected void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(80297);
    if (this.AMZ != null) {
      this.AMZ.loadUrl(paramString, paramMap, paramBoolean);
    }
    AppMethodBeat.o(80297);
  }
  
  protected void m(int paramInt, Bundle paramBundle) {}
  
  protected void nO(boolean paramBoolean) {}
  
  public boolean needShowIdcError()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(80289);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.kxp.c(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(80289);
      return;
    }
    if (com.tencent.mm.plugin.webview.modeltools.a.c(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(80289);
      return;
    }
    if (this.Bit.c(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(80289);
      return;
    }
    if (paramInt1 == 777)
    {
      Bundle localBundle = null;
      if (paramIntent != null) {
        localBundle = paramIntent.getBundleExtra("result_data");
      }
      if ((localBundle != null) && (localBundle.getString("go_next", "").equals("gdpr_confirm_continue")))
      {
        ad.i("MicroMsg.WebViewUI", "gdpr continue:true");
        AppMethodBeat.o(80289);
        return;
      }
      ad.i("MicroMsg.WebViewUI", "gdpr continue:false");
      paramIntent = new Intent();
      localBundle = new Bundle();
      localBundle.putString("go_next", "gdpr_confirm_logout");
      paramIntent.putExtra("result_data", localBundle);
      this.BhN = true;
      k.BfO.close();
      setResult(-1, paramIntent);
      finish();
    }
    AppMethodBeat.o(80289);
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(80291);
    if (this.nhy != null)
    {
      if (!this.Biu) {
        break label42;
      }
      this.nhy.setOnLongClickListener(this.Biv);
    }
    for (;;)
    {
      super.onCancel();
      AppMethodBeat.o(80291);
      return;
      label42:
      this.nhy.setOnLongClickListener(null);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(80265);
    super.onConfigurationChanged(paramConfiguration);
    if (this.nbF != paramConfiguration.orientation)
    {
      View localView = eoz();
      if (localView == null) {}
      for (localView = null; localView == null; localView = (View)localView.getParent())
      {
        AppMethodBeat.o(80265);
        return;
      }
      localView.dispatchConfigurationChanged(paramConfiguration);
      localView.requestLayout();
      this.nbF = paramConfiguration.orientation;
    }
    AppMethodBeat.o(80265);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80244);
    com.tencent.mm.plugin.webview.j.h localh = this.BhS;
    localh.createTime = System.currentTimeMillis();
    localh.bG("onCreate", localh.createTime);
    this.BhS.Bxs = getIntent().getLongExtra("startTime", 0L);
    bFJ();
    super.onCreate(paramBundle);
    this.BhS.bG("onUIInitStart", System.currentTimeMillis());
    bFa();
    this.BhS.bG("onUIInitEnd", System.currentTimeMillis());
    AppMethodBeat.o(80244);
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(80243);
    supportRequestWindowFeature(5);
    supportRequestWindowFeature(9);
    setProgressBarIndeterminateVisibility(false);
    AppMethodBeat.o(80243);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80271);
    ad.i("MicroMsg.WebViewUI", "WebViewUI onDestroy now: %s", new Object[] { Integer.valueOf(this.AMZ.eiZ()) });
    super.onDestroy();
    com.tencent.mm.plugin.webview.modeltools.c.emw();
    Object localObject1 = this.AMZ.getCurrentUrl();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.webview.j.i.gO(this);
      if ((localObject2 != null) && (((String)localObject1).equals(localObject2))) {
        com.tencent.mm.plugin.webview.j.i.gP(this);
      }
    }
    for (;;)
    {
      this.Bht.onDestroy();
      if (this.Bie != null)
      {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).J(this.Bie.mDH);
        this.Bie.onDestroy();
      }
      if ((ekY()) && (this.Bic != null))
      {
        ad.i("MicroMsg.WebViewUI", "[Handoff] call onWebViewDestroy " + this.Bic.toString());
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).b(this.Bic);
      }
      if (this.BgR != null) {
        this.BgR.disable();
      }
      this.BhN = true;
      BhM -= 1;
      int j = this.AMZ.eiZ();
      int i = Bhn.size() - 1;
      label225:
      if (i >= 0)
      {
        if (((e)Bhn.get(i)).id == j) {
          Bhn.remove(i);
        }
      }
      else
      {
        this.AMJ.emq().A(new Object[] { bEx(), Integer.valueOf(2) }).report();
        this.AMJ.report();
        localObject1 = this.AMJ;
        ((com.tencent.mm.plugin.webview.model.ax)localObject1).AYV = null;
        ((com.tencent.mm.plugin.webview.model.ax)localObject1).AYT = null;
        ((com.tencent.mm.plugin.webview.model.ax)localObject1).AYU = null;
        ((com.tencent.mm.plugin.webview.model.ax)localObject1).AYS = null;
        ((com.tencent.mm.plugin.webview.model.ax)localObject1).AYX = null;
        ((com.tencent.mm.plugin.webview.model.ax)localObject1).AYY = null;
        ((com.tencent.mm.plugin.webview.model.ax)localObject1).AYZ = null;
        ((com.tencent.mm.plugin.webview.model.ax)localObject1).AZa = null;
        if (((com.tencent.mm.plugin.webview.model.ax)localObject1).AZf != null)
        {
          ((com.tencent.mm.plugin.webview.model.ax)localObject1).AZf.dow = null;
          ((com.tencent.mm.plugin.webview.model.ax)localObject1).AZf = null;
        }
        Sz("onDestroy");
        this.Bhw.clear();
        c(this.BhB);
        if ((this.Bhq != null) && ((this.Bhq instanceof b))) {
          c(((b)this.Bhq).iAV);
        }
        if (this.BgS != null) {
          this.BgS.setOnTextSendListener(null);
        }
        if (this.BgH != null)
        {
          localObject1 = this.BgH.BeB;
          if (localObject1 != null)
          {
            localObject2 = ((View)localObject1).getAnimation();
            if (localObject2 != null) {
              ((Animation)localObject2).setAnimationListener(null);
            }
            ((View)localObject1).clearAnimation();
          }
        }
        this.Bhx.clear();
        this.BhW.onDestroy();
        this.Bih.dead();
        this.Bhu.dead();
        if (com.tencent.xweb.d.kU(com.tencent.mm.sdk.platformtools.aj.getContext()) != null)
        {
          ad.i("MicroMsg.WebViewUI", "now force sync the cookie between ram and db");
          com.tencent.xweb.d.sync();
        }
        ad.v("MicroMsg.WebViewUI", "on destroy isNeedCallbackMMRpt[%b]", new Object[] { Boolean.valueOf(this.Bha) });
        if (!this.Bha) {}
      }
      try
      {
        localObject1 = getIntent().getBundleExtra("mm_report_bundle");
        if (!bt.isNullOrNil(((Bundle)localObject1).getString("mm_event_class"))) {
          if (this.kxf != null)
          {
            ((Bundle)localObject1).putLong("key_activity_browse_time", getActivityBrowseTimeMs());
            this.kxf.j(250, (Bundle)localObject1);
          }
        }
      }
      catch (Exception localThrowable)
      {
        try
        {
          if (this.kxf != null)
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putLong("key_activity_browse_time", getActivityBrowseTimeMs());
            this.kxf.j(251, (Bundle)localObject1);
          }
        }
        catch (Exception localThrowable)
        {
          try
          {
            if (this.kxf != null)
            {
              localObject1 = this.kxf.j(19, null);
              if (localObject1 != null)
              {
                bool = ((Bundle)localObject1).getBoolean("webview_video_proxy_init");
                ad.i("MicroMsg.WebViewUI", "onDestroy, has init = %b, webviewHoldingCounter = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(BhM) });
                if ((bool) && (BhM <= 0))
                {
                  FactoryProxyManager.getPlayManager().deinit();
                  this.kxf.j(75, null);
                }
              }
            }
            bool = com.tencent.mm.plugin.webview.modeltools.k.a(this.AQP, this.nhy);
            this.AMZ.onDestroy();
            this.nhy.removeJavascriptInterface("MicroMsg");
            this.nhy.removeJavascriptInterface("JsApi");
            this.nhy.removeJavascriptInterface("__wx");
            this.nhy.removeJavascriptInterface("CustomFullscreenApi");
            this.nhy.removeJavascriptInterface("__wxtag");
          }
          catch (Exception localThrowable)
          {
            try
            {
              this.nhy.setWebChromeClient(null);
              this.nhy.setWebViewClient(null);
              this.nhy.setOnTouchListener(null);
              this.nhy.setOnLongClickListener(null);
              this.nhy.setVisibility(8);
              this.nhy.removeAllViews();
              this.nhy.clearView();
              this.BhU.emQ();
              if (this.kxg != null)
              {
                localObject1 = this.kxg;
                ad.i("MicroMsg.WebViewPermission", "detach");
                ((com.tencent.mm.plugin.webview.e.g)localObject1).Bbe.clear();
                ((com.tencent.mm.plugin.webview.e.g)localObject1).Bbe = null;
                this.kxg = null;
              }
            }
            catch (Exception localThrowable)
            {
              try
              {
                boolean bool;
                this.Bis.release();
                if (bool) {}
              }
              catch (Exception localThrowable)
              {
                try
                {
                  this.nhy.destroy();
                }
                catch (Exception localThrowable)
                {
                  try
                  {
                    if ((getContentView() instanceof ViewGroup)) {
                      ((ViewGroup)getContentView()).removeAllViews();
                    }
                    localObject1 = this.BhY;
                  }
                  catch (Throwable localThrowable)
                  {
                    try
                    {
                      for (;;)
                      {
                        ((ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard")).removePrimaryClipChangedListener((ClipboardManager.OnPrimaryClipChangedListener)localObject1);
                        label991:
                        localObject1 = this.BhZ;
                        if ((((com.tencent.mm.plugin.webview.c)localObject1).tipDialog != null) && (((com.tencent.mm.plugin.webview.c)localObject1).tipDialog.isShowing()))
                        {
                          ((com.tencent.mm.plugin.webview.c)localObject1).tipDialog.dismiss();
                          ((com.tencent.mm.plugin.webview.c)localObject1).tipDialog = null;
                        }
                        com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.plugin.webview.c)localObject1).AKy);
                        this.nhy = null;
                        if (this.BhX != null)
                        {
                          this.BhX = null;
                          FactoryProxyManager.getPlayManager().setUtilsObject(null);
                        }
                        System.gc();
                        AppMethodBeat.o(80271);
                        return;
                        ad.w("MicroMsg.WebViewUI", "currentURL == null, qbrowser.url may be not accurate");
                        break;
                        i -= 1;
                        break label225;
                        ad.w("MicroMsg.WebViewUI", "webview on destroy callback mm but eventclass is null");
                        continue;
                        localException1 = localException1;
                        ad.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", new Object[] { localException1.toString() });
                        continue;
                        localException2 = localException2;
                        ad.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", new Object[] { localException2.toString() });
                        continue;
                        localException3 = localException3;
                        ad.e("MicroMsg.WebViewUI", "deinit video player failed : %s", new Object[] { localException3.getMessage() });
                        continue;
                        localException4 = localException4;
                        ad.e("MicroMsg.WebViewUI", "onDestroy, set web infos to null,  ex = %s", new Object[] { localException4.getMessage() });
                        continue;
                        localException5 = localException5;
                        ad.e("MicroMsg.WebViewUI", "onDestroy, remove view,  ex = " + localException5.getMessage());
                        continue;
                        localException6 = localException6;
                        ad.w("MicroMsg.WebViewUI", "onDestroy, viewWV destroy, ex = %s", new Object[] { localException6.getMessage() });
                      }
                      localThrowable = localThrowable;
                      ad.w("MicroMsg.WebViewUI", "onDestroy contentView removeAllViews %s", new Object[] { localThrowable });
                    }
                    catch (Exception localException7)
                    {
                      break label991;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(80292);
    if (this.nhy != null) {
      this.nhy.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          return true;
        }
      });
    }
    super.onDrag();
    AppMethodBeat.o(80292);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(80274);
    ad.i("MicroMsg.WebViewUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 4)
    {
      if ((this.nhy != null) && (this.nhy.hasEnteredFullscreen()))
      {
        this.nhy.leaveFullscreen();
        AppMethodBeat.o(80274);
        return true;
      }
      com.tencent.mm.plugin.webview.ui.tools.d.a.h localh = this.Bht;
      if (localh.BtI != null)
      {
        com.tencent.mm.plugin.webview.ui.tools.d.a locala = localh.BtI;
        if (locala == null) {
          d.g.b.k.fvU();
        }
        if (!locala.bcg()) {}
      }
      for (bool = localh.gG(localh.context).aNT(); bool; bool = false)
      {
        AppMethodBeat.o(80274);
        return true;
      }
    }
    if ((paramInt == 4) && (this.sk != null) && (this.Bhp != null) && (this.Bhq != null)) {
      try
      {
        this.Bhq.onHideCustomView();
        this.AMJ.emq().A(new Object[] { bEx(), Integer.valueOf(1) }).report();
        AppMethodBeat.o(80274);
        return true;
      }
      catch (Exception paramKeyEvent)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.WebViewUI", paramKeyEvent, "onkeydown", new Object[0]);
        }
      }
    }
    if (paramInt == 4)
    {
      if ((this.BgS != null) && (this.BgS.isShown()))
      {
        this.BgS.hide();
        eoO();
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(80274);
        return true;
      }
    }
    if (paramInt == 4)
    {
      if ((this.nhy != null) && (this.nhy.canGoBack()) && (this.BgX))
      {
        eoB();
        this.AMJ.emq().A(new Object[] { bEx(), Integer.valueOf(1) }).report();
        AppMethodBeat.o(80274);
        return true;
      }
      k.BfO.close();
    }
    if ((paramInt == 4) && (eoS()) && (ekR()))
    {
      AppMethodBeat.o(80274);
      return true;
    }
    if ((paramInt == 4) && (this.Bie != null) && (this.Bie.rg(2)))
    {
      AppMethodBeat.o(80274);
      return true;
    }
    if ((paramInt == 4) && (this.Bii != null) && (this.Bii.bcB()))
    {
      this.Bii.hide();
      AppMethodBeat.o(80274);
      return true;
    }
    if (paramInt == 4) {
      eoU();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(80274);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(80273);
    if ((paramInt == 82) && (!this.Bir))
    {
      AppMethodBeat.o(80273);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(80273);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80234);
    super.onPause();
    if (this.Bie != null) {
      this.Bie.aWa();
    }
    com.tencent.mm.modelstat.d.c(4, "WebViewUI_" + avB(bt.nullAsNil(this.BhD)), this.AMZ.eiZ());
    com.tencent.mm.modelstat.d.p("WebViewUI_" + avB(bt.nullAsNil(this.BhD)), this.tlW, bt.aGK());
    Object localObject = this.AMJ.emm();
    if (((com.tencent.mm.plugin.webview.model.av)localObject).lastResumeTime != -1L) {
      ((com.tencent.mm.plugin.webview.model.av)localObject).dsf += bt.aS(((com.tencent.mm.plugin.webview.model.av)localObject).lastResumeTime) / 1000L;
    }
    localObject = this.AMJ.emn();
    if (((com.tencent.mm.plugin.webview.model.aj)localObject).lastResumeTime != -1L) {
      ((com.tencent.mm.plugin.webview.model.aj)localObject).dsf += bt.aS(((com.tencent.mm.plugin.webview.model.aj)localObject).lastResumeTime);
    }
    localObject = k.BfO;
    ad.v("MicroMsg.WebViewReportUtil", "onPause traceid %s", new Object[] { ((k)localObject).wSh });
    if (((k)localObject).gPQ) {
      ad.i("MicroMsg.WebViewReportUtil", "isFinish is true");
    }
    try
    {
      if (this.kxf != null)
      {
        localObject = this.kxf.j(19, null);
        if (localObject != null)
        {
          boolean bool = ((Bundle)localObject).getBoolean("webview_video_proxy_init");
          ad.i("MicroMsg.WebViewUI", "onPause, has init = %b", new Object[] { Boolean.valueOf(bool) });
          if (bool) {
            FactoryProxyManager.getPlayManager().appToBack();
          }
        }
      }
      eoO();
      bh.a(this, null);
      Sz("onPause");
      if (this.Bhq != null) {
        ad.i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.Bhq.onHideCustomView();
          this.Bht.onPause();
          AppMethodBeat.o(80234);
          return;
          if (!bt.isNullOrNil(((k)localObject).wSh)) {
            ((k)localObject).lI(6);
          }
        }
        localException1 = localException1;
        ad.e("MicroMsg.WebViewUI", "notify app toback failed : %s", new Object[] { localException1.getMessage() });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.WebViewUI", localException2, "onPause", new Object[0]);
        }
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(80242);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    paramArrayOfString = this.kxp;
    if (paramArrayOfString.AZD == null)
    {
      paramArrayOfString.emx();
      paramInt = i;
      if (paramInt != 0) {
        AppMethodBeat.o(80242);
      }
    }
    else
    {
      if (119 == paramInt)
      {
        if (paramArrayOfInt[0] != 0) {
          break label99;
        }
        paramArrayOfInt = (Intent)paramArrayOfString.AZD.first;
        paramInt = ((Integer)paramArrayOfString.AZD.second).intValue();
        paramArrayOfString.AZD = null;
        startActivityForResult(paramArrayOfInt, paramInt);
      }
      for (;;)
      {
        paramInt = 1;
        break;
        label99:
        paramArrayOfString.AZD = null;
        paramArrayOfString.b(this, 0, null);
      }
    }
    AppMethodBeat.o(80242);
  }
  
  protected void onReset()
  {
    AppMethodBeat.i(80245);
    this.AQP.detach();
    this.AQP = null;
    ((ViewGroup)this.nhy.getParent()).removeView(this.nhy);
    this.nhy.stopLoading();
    this.nhy.removeAllViews();
    this.nhy.clearView();
    this.nhy.destroy();
    this.nhy = null;
    this.Bhq = null;
    ((ViewGroup)this.BgK.getParent()).removeView(this.BgK);
    if (this.Bid != null)
    {
      n localn = this.Bid;
      if (localn.BiP != null)
      {
        LinearLayout localLinearLayout = (LinearLayout)localn.BiO.getController().mActionBar.getCustomView();
        if (localLinearLayout != null) {
          localLinearLayout.removeView(localn.BiP);
        }
      }
    }
    if (this.AMZ != null) {
      this.AMZ.onDestroy();
    }
    this.Bht.onDestroy();
    this.BhQ = false;
    bFJ();
    bFa();
    AppMethodBeat.o(80245);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80233);
    super.onResume();
    if (this.Bie != null) {
      this.Bie.aVZ();
    }
    if (this.AMZ.getCurrentUrl() != null) {
      com.tencent.mm.plugin.webview.j.i.h(this.AMZ.getCurrentUrl(), this);
    }
    for (;;)
    {
      this.AMJ.emm().lastResumeTime = bt.GC();
      this.AMJ.emn().lastResumeTime = bt.GC();
      Object localObject = k.BfO;
      ad.v("MicroMsg.WebViewReportUtil", "onResume traceid %s", new Object[] { ((k)localObject).wSh });
      if (!bt.isNullOrNil(((k)localObject).wSh)) {
        ((k)localObject).lI(7);
      }
      int i;
      if (!this.Bim)
      {
        int j = this.AMZ.eiZ();
        i = Bhn.size() - 1;
        label139:
        if (i >= 0)
        {
          if (((e)Bhn.get(i)).id == j) {
            Bhn.remove(i);
          }
        }
        else {
          Bhn.add(new e(this));
        }
      }
      else
      {
        this.Bim = false;
        if (this.Bho)
        {
          ti(true);
          this.Bho = false;
        }
        eoD();
        if (this.kxf == null) {}
      }
      try
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("screen_orientation", this.screenOrientation);
        this.kxf.j(83, (Bundle)localObject);
        if ((getIntent().getBooleanExtra("disable_swipe_back", false)) && (getSwipeBackLayout() != null)) {
          getSwipeBackLayout().setEnableGesture(false);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          bh.a(this, this);
          Sz("onResume");
          try
          {
            if (this.kxf != null)
            {
              localObject = this.kxf.j(19, null);
              if (localObject != null)
              {
                boolean bool = ((Bundle)localObject).getBoolean("webview_video_proxy_init");
                ad.i("MicroMsg.WebViewUI", "onResume, has init = %b", new Object[] { Boolean.valueOf(bool) });
                if (bool) {
                  FactoryProxyManager.getPlayManager().appToFront();
                }
              }
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              ad.e("MicroMsg.WebViewUI", "notify app tofront failed : %s", new Object[] { localException3.getMessage() });
            }
          }
          this.tlW = bt.aGK();
          com.tencent.mm.plugin.webview.a.a.ae(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(80087);
              com.tencent.mm.modelstat.d.c(3, "WebViewUI_" + WebViewUI.this.avB(bt.nullAsNil(WebViewUI.this.BhD)), WebViewUI.this.eiZ());
              AppMethodBeat.o(80087);
            }
          });
          if (this.BhR) {
            finish();
          }
          if ((this.BgL != null) && (this.BgL.BeZ))
          {
            hideVKB();
            this.BgL.DK(-2);
          }
          this.Bht.onResume();
          AppMethodBeat.o(80233);
          return;
          com.tencent.mm.plugin.webview.j.i.h(bEx(), this);
          continue;
          i -= 1;
          break label139;
          localException1 = localException1;
          ad.e("MicroMsg.WebViewUI", "ac_set_screen_orientation : " + localException1.getMessage());
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ad.w("MicroMsg.WebViewUI", "setScreenShotCallback fail e:%s", new Object[] { localException2.getMessage() });
          }
        }
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(80266);
    super.onStart();
    ad.i("MicroMsg.WebViewUI", "edw onStart");
    AppMethodBeat.o(80266);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(80267);
    ad.i("MicroMsg.WebViewUI", "edw onStop");
    tu(true);
    super.onStop();
    AppMethodBeat.o(80267);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(80290);
    if (this.nhy != null)
    {
      if (!this.Biu) {
        break label46;
      }
      this.nhy.setOnLongClickListener(this.Biv);
    }
    for (;;)
    {
      hideVKB();
      super.onSwipeBack();
      AppMethodBeat.o(80290);
      return;
      label46:
      this.nhy.setOnLongClickListener(null);
    }
  }
  
  public boolean onSwipeBackFinish()
  {
    AppMethodBeat.i(80293);
    this.BhP = true;
    ax.g localg = this.AMJ.emq();
    if (this.nhy != null) {}
    for (String str = this.nhy.getUrl();; str = bEx())
    {
      localg.A(new Object[] { str, Integer.valueOf(15) }).report();
      boolean bool = super.onSwipeBackFinish();
      AppMethodBeat.o(80293);
      return bool;
    }
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(80261);
    Object localObject;
    if ((this.Bid != null) && (!this.Bid.BiN))
    {
      localObject = this.Bid;
      if (bt.isNullOrNil(((n)localObject).lst)) {
        ((n)localObject).lst = bt.nullAsNil(((n)localObject).BiO.AMZ.getCurrentUrl());
      }
      ((n)localObject).epi();
    }
    long l;
    if (this.BgH != null)
    {
      localObject = this.BgH;
      if (((g)localObject).Bex)
      {
        l = System.currentTimeMillis();
        if (((g)localObject).Beu == 0L)
        {
          ((g)localObject).Beu = l;
          ((g)localObject).Bev = paramInt2;
        }
        if ((Math.abs(l - ((g)localObject).Beu) > 200L) && (Math.abs(paramInt2 - ((g)localObject).Bev) > ((g)localObject).Bew))
        {
          if ((paramInt2 - ((g)localObject).Bev <= 0) || (((g)localObject).BeB.getVisibility() != 0)) {
            break label195;
          }
          ((g)localObject).enM();
        }
      }
    }
    for (;;)
    {
      ((g)localObject).Beu = l;
      ((g)localObject).Bev = paramInt2;
      AppMethodBeat.o(80261);
      return;
      label195:
      if ((paramInt2 - ((g)localObject).Bev < 0) && (((g)localObject).BeB.getVisibility() != 0)) {
        ((g)localObject).enL();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(80283);
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.BgP)) {
      au(getWindow().getDecorView(), 5894);
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(80283);
  }
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(80221);
    super.setActionbarColor(paramInt);
    if (this.BhF) {
      setStatusBarColor(paramInt);
    }
    AppMethodBeat.o(80221);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    AppMethodBeat.i(80363);
    super.setBackBtn(paramOnMenuItemClickListener, paramInt);
    if ((com.tencent.mm.compatible.util.d.lf(21)) && (eov())) {
      setBackBtnColorFilter(-16777216);
    }
    AppMethodBeat.o(80363);
  }
  
  public void setMMOrientation()
  {
    AppMethodBeat.i(80263);
    if (getForceOrientation() == -1)
    {
      this.landscapeMode = getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.eFD(), 4).getBoolean("settings_landscape_mode", false);
      if (this.landscapeMode)
      {
        setRequestedOrientation(-1);
        AppMethodBeat.o(80263);
        return;
      }
      setRequestedOrientation(1);
      AppMethodBeat.o(80263);
      return;
    }
    setRequestedOrientation(getForceOrientation());
    AppMethodBeat.o(80263);
  }
  
  public void setMMTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(80238);
    super.setMMTitle(paramCharSequence);
    axW(paramCharSequence.toString());
    axX(paramCharSequence.toString());
    AppMethodBeat.o(80238);
  }
  
  public void setMMTitle(String paramString)
  {
    AppMethodBeat.i(80237);
    super.setMMTitle(paramString);
    axW(paramString);
    axX(paramString);
    AppMethodBeat.o(80237);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(188042);
    this.screenOrientation = paramInt;
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(188042);
  }
  
  @TargetApi(21)
  public final void setStatusBarColor(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(80258);
    Object localObject;
    if (this.BhF)
    {
      localObject = getContentView();
      if (!am.XC(paramInt)) {
        bool = true;
      }
      com.tencent.mm.ui.statusbar.a.e((View)localObject, paramInt, bool);
      AppMethodBeat.o(80258);
      return;
    }
    if ((this.lDk <= 0) || (com.tencent.mm.compatible.util.d.lg(21)))
    {
      AppMethodBeat.o(80258);
      return;
    }
    getWindow().setStatusBarColor(0);
    if (this.Bip == null)
    {
      this.Bip = new View(this);
      localObject = new ViewGroup.LayoutParams(-1, this.lDk);
      ((ViewGroup)findViewById(16908290)).addView(this.Bip, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.Bip.setBackgroundColor(paramInt);
      AppMethodBeat.o(80258);
      return;
      localObject = this.Bip.getLayoutParams();
      if (((ViewGroup.LayoutParams)localObject).height != this.lDk)
      {
        ((ViewGroup.LayoutParams)localObject).height = this.lDk;
        this.Bip.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void showOptionMenu(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(80312);
    if (getIntent().getBooleanExtra("hide_option_menu", false))
    {
      super.showOptionMenu(paramInt, false);
      AppMethodBeat.o(80312);
      return;
    }
    super.showOptionMenu(paramInt, paramBoolean);
    AppMethodBeat.o(80312);
  }
  
  public void showOptionMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(80311);
    if (getIntent().getBooleanExtra("hide_option_menu", false))
    {
      super.showOptionMenu(false);
      AppMethodBeat.o(80311);
      return;
    }
    super.showOptionMenu(paramBoolean);
    AppMethodBeat.o(80311);
  }
  
  public void showVKB()
  {
    AppMethodBeat.i(80362);
    super.showVKB();
    if (this.BiC == -3)
    {
      this.BiC = -2;
      AppMethodBeat.o(80362);
      return;
    }
    this.BiC = -3;
    AppMethodBeat.o(80362);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(80369);
    if (bt.kU(paramIntent.getType(), "application/vnd.android.package-archive"))
    {
      com.tencent.mm.pluginsdk.model.app.r.i(com.tencent.mm.sdk.platformtools.aj.getContext(), paramIntent.getData());
      AppMethodBeat.o(80369);
      return;
    }
    super.startActivity(paramIntent);
    AppMethodBeat.o(80369);
  }
  
  public final void ts(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(80319);
    if (this.BgH != null) {
      this.BgH.ts(paramBoolean);
    }
    ImageButton localImageButton;
    if ((this.nhy != null) && (this.BeB != null))
    {
      localImageButton = this.BgI;
      if ((this.nhy == null) || (!this.nhy.canGoBack())) {
        break label102;
      }
      paramBoolean = true;
      localImageButton.setEnabled(paramBoolean);
      localImageButton = this.BgJ;
      if ((this.nhy == null) || (!this.nhy.canGoForward())) {
        break label107;
      }
    }
    label102:
    label107:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localImageButton.setEnabled(paramBoolean);
      AppMethodBeat.o(80319);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  protected void tt(boolean paramBoolean)
  {
    AppMethodBeat.i(80310);
    this.Bir = paramBoolean;
    if (this.nhy == null)
    {
      ad.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
      AppMethodBeat.o(80310);
      return;
    }
    enableOptionMenu(paramBoolean);
    showOptionMenu(paramBoolean);
    boolean bool1 = getIntent().getBooleanExtra("show_feedback", false);
    if (bool1) {
      showOptionMenu(bool1);
    }
    int i = eoN();
    if (eoM() != null) {
      i = 2131690809;
    }
    bool1 = getIntent().getBooleanExtra("KRightBtn", false);
    boolean bool2 = getIntent().getBooleanExtra("KShowFixToolsBtn", false);
    ad.i("MicroMsg.WebViewUI", "banRightBtn:%b, showFixToolsBtn:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (!bool1)
    {
      if (bool2) {
        addIconOptionMenu(1, 2131690202, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(187986);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(WebViewUI.this, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
            ((Intent)localObject).putExtra("entry_fix_tools", 1);
            paramAnonymousMenuItem = WebViewUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$33", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$33", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(187986);
            return true;
          }
        });
      }
      addIconOptionMenu(0, i, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(187987);
          if (WebViewUI.this.kxg.axq(WebViewUI.this.ejo())) {
            WebViewUI.this.AMJ.emq().A(new Object[] { WebViewUI.this.bEx(), Integer.valueOf(6) }).report();
          }
          for (;;)
          {
            WebViewUI.this.bFd();
            AppMethodBeat.o(187987);
            return true;
            WebViewUI.this.AMJ.emq().A(new Object[] { WebViewUI.this.bEx(), Integer.valueOf(5) }).report();
          }
        }
      }, this.Biy);
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      tv(paramBoolean);
      AppMethodBeat.o(80310);
      return;
    }
  }
  
  protected final void tu(boolean paramBoolean)
  {
    AppMethodBeat.i(188044);
    enableOptionMenu(true);
    ad.d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", new Object[] { Boolean.TRUE });
    setProgressBarIndeterminateVisibility(false);
    if (paramBoolean)
    {
      this.BgE.finish();
      this.BhW.enU();
      AppMethodBeat.o(188044);
      return;
    }
    if ((!this.BhH) && (!this.BhI) && (!this.AMZ.bEH())) {
      this.BgE.start();
    }
    AppMethodBeat.o(188044);
  }
  
  public final void tv(boolean paramBoolean)
  {
    AppMethodBeat.i(80359);
    String str = this.nhy.getUrl();
    if (paramBoolean)
    {
      showOptionMenu(0, false);
      this.Bhz.put(str, Boolean.TRUE);
      AppMethodBeat.o(80359);
      return;
    }
    showOptionMenu(0, true);
    if (this.Bhz.containsKey(str)) {
      this.Bhz.remove(str);
    }
    AppMethodBeat.o(80359);
  }
  
  protected void x(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80358);
    ad.i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
    AppMethodBeat.o(80358);
  }
  
  protected static final class a
  {
    private String AUK;
    private String AUL;
    private String AUM;
    private String AUN;
    private String AUO;
    private String AUP;
    private String BiI;
    private String lang;
    
    private a(Bundle paramBundle)
    {
      AppMethodBeat.i(80123);
      this.BiI = paramBundle.getString("close_window_confirm_dialog_switch");
      this.AUK = paramBundle.getString("close_window_confirm_dialog_title_cn");
      this.AUL = paramBundle.getString("close_window_confirm_dialog_title_eng");
      this.AUM = paramBundle.getString("close_window_confirm_dialog_ok_cn");
      this.AUN = paramBundle.getString("close_window_confirm_dialog_ok_eng");
      this.AUO = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
      this.AUP = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
      this.lang = paramBundle.getString("application_language");
      AppMethodBeat.o(80123);
    }
    
    public static a aF(Bundle paramBundle)
    {
      AppMethodBeat.i(80124);
      paramBundle = new a(paramBundle);
      AppMethodBeat.o(80124);
      return paramBundle;
    }
    
    public final boolean elw()
    {
      AppMethodBeat.i(80125);
      if (bt.isNullOrNil(this.BiI))
      {
        AppMethodBeat.o(80125);
        return false;
      }
      boolean bool = this.BiI.equals("true");
      AppMethodBeat.o(80125);
      return bool;
    }
    
    public final String ely()
    {
      AppMethodBeat.i(80127);
      if ("zh_CN".equals(this.lang))
      {
        str = this.AUM;
        AppMethodBeat.o(80127);
        return str;
      }
      String str = this.AUN;
      AppMethodBeat.o(80127);
      return str;
    }
    
    public final String elz()
    {
      AppMethodBeat.i(80128);
      if ("zh_CN".equals(this.lang))
      {
        str = this.AUO;
        AppMethodBeat.o(80128);
        return str;
      }
      String str = this.AUP;
      AppMethodBeat.o(80128);
      return str;
    }
    
    public final String epd()
    {
      AppMethodBeat.i(80126);
      if ("zh_CN".equals(this.lang))
      {
        str = this.AUK;
        AppMethodBeat.o(80126);
        return str;
      }
      String str = this.AUL;
      AppMethodBeat.o(80126);
      return str;
    }
  }
  
  public class b
    extends w
  {
    public volatile boolean fUH;
    com.tencent.mm.ui.widget.a.d iAV;
    
    protected b()
    {
      AppMethodBeat.i(80144);
      this.fUH = false;
      this.iAV = null;
      AppMethodBeat.o(80144);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(80148);
      ad.d("MicroMsg.WebViewUI", "onProgressChanged %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(80148);
    }
    
    public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(80145);
      com.tencent.mm.plugin.ball.f.f.d(true, true, false);
      if (WebViewUI.this.eko().ASC)
      {
        MPVideoPlayFullScreenView localMPVideoPlayFullScreenView = WebViewUI.this.eom();
        Context localContext = localMPVideoPlayFullScreenView.getContext();
        if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).nhy != null)) {
          localMPVideoPlayFullScreenView.Bsr = ((WebViewUI)localContext).nhy.setVideoJsCallback((u)new MPVideoPlayFullScreenView.h(localMPVideoPlayFullScreenView));
        }
        if (localMPVideoPlayFullScreenView.Bsr != null) {}
        for (int i = 1; i != 0; i = 0)
        {
          WebViewUI.a(WebViewUI.this, paramCustomViewCallback);
          ad.i("MicroMsg.WebViewUI", "onEnterFullscreen view");
          if (paramView.getParent() == null) {
            WebViewUI.this.eom().fm(paramView);
          }
          AppMethodBeat.o(80145);
          return true;
        }
      }
      if (WebViewUI.this.eko().ASC) {
        WebViewUI.this.eko().tl(false);
      }
      boolean bool = super.a(paramView, paramCustomViewCallback);
      AppMethodBeat.o(80145);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, com.tencent.xweb.w.a parama)
    {
      AppMethodBeat.i(80155);
      if ((parama.getMode() == 0) || (parama.getMode() == 1))
      {
        if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
        {
          ad.i("MicroMsg.WebViewUI", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
          AppMethodBeat.o(80155);
          return true;
        }
        String str2 = parama.getAcceptTypes()[0];
        String str1 = "*";
        paramWebView = str1;
        if (parama.isCaptureEnabled())
        {
          if (!"image/*".equalsIgnoreCase(str2)) {
            break label117;
          }
          paramWebView = "camera";
        }
        for (;;)
        {
          WebViewUI.o(WebViewUI.this).a(WebViewUI.this, WebViewUI.this.kxg, null, paramValueCallback, str2, paramWebView);
          AppMethodBeat.o(80155);
          return true;
          label117:
          paramWebView = str1;
          if ("video/*".equalsIgnoreCase(str2)) {
            paramWebView = "camcorder";
          }
        }
      }
      AppMethodBeat.o(80155);
      return false;
    }
    
    public final boolean a(WebView paramWebView, final String paramString1, String paramString2, final JsResult paramJsResult)
    {
      AppMethodBeat.i(80158);
      ad.d("MicroMsg.WebViewUI", "onJsAlert");
      final PBool localPBool = new PBool();
      localPBool.value = false;
      if ((WebViewUI.this.isFinishing()) || (WebViewUI.this.activityHasDestroyed()))
      {
        ad.d("MicroMsg.WebViewUI", "onJsAlert finish");
        paramJsResult.cancel();
        AppMethodBeat.o(80158);
        return true;
      }
      WebViewUI.p(WebViewUI.this);
      if (WebViewUI.q(WebViewUI.this) > 2) {}
      for (this.iAV = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131766261), WebViewUI.this.getString(2131755835), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80142);
              com.tencent.mm.plugin.report.service.h.vKh.f(11683, new Object[] { paramString1, Integer.valueOf(1), Integer.valueOf(WebViewUI.q(WebViewUI.this)) });
              paramJsResult.cancel();
              if (paramAnonymousDialogInterface != null) {
                paramAnonymousDialogInterface.dismiss();
              }
              WebViewUI.this.finish();
              AppMethodBeat.o(80142);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80143);
              localPBool.value = true;
              paramJsResult.confirm();
              AppMethodBeat.o(80143);
            }
          }, 2131100547); this.iAV != null; this.iAV = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131755835), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80134);
              localPBool.value = true;
              paramJsResult.confirm();
              AppMethodBeat.o(80134);
            }
          }))
      {
        this.iAV.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(80135);
            ad.d("MicroMsg.WebViewUI", "onJsAlert, onDismiss");
            if (!localPBool.value) {
              paramJsResult.cancel();
            }
            AppMethodBeat.o(80135);
          }
        });
        this.iAV.setCanceledOnTouchOutside(false);
        this.iAV.wU(false);
        AppMethodBeat.o(80158);
        return true;
      }
      boolean bool = super.a(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(80158);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, com.tencent.xweb.n paramn)
    {
      AppMethodBeat.i(80157);
      boolean bool = super.a(paramWebView, paramString1, paramString2, paramString3, paramn);
      AppMethodBeat.o(80157);
      return bool;
    }
    
    public final boolean b(WebView paramWebView, final String paramString1, String paramString2, final JsResult paramJsResult)
    {
      AppMethodBeat.i(80156);
      ad.d("MicroMsg.WebViewUI", "onJsConfirm");
      final PBool localPBool = new PBool();
      localPBool.value = false;
      if ((WebViewUI.this.isFinishing()) || (WebViewUI.this.activityHasDestroyed()))
      {
        ad.d("MicroMsg.WebViewUI", "onJsConfirm finish");
        paramJsResult.cancel();
        AppMethodBeat.o(80156);
        return true;
      }
      WebViewUI.p(WebViewUI.this);
      if (WebViewUI.q(WebViewUI.this) > 2) {}
      for (this.iAV = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131766261), WebViewUI.this.getString(2131755835), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80137);
              com.tencent.mm.plugin.report.service.h.vKh.f(11683, new Object[] { paramString1, Integer.valueOf(1), Integer.valueOf(WebViewUI.q(WebViewUI.this)) });
              paramJsResult.cancel();
              if (paramAnonymousDialogInterface != null) {
                paramAnonymousDialogInterface.dismiss();
              }
              WebViewUI.this.finish();
              AppMethodBeat.o(80137);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80138);
              localPBool.value = true;
              paramJsResult.confirm();
              AppMethodBeat.o(80138);
            }
          }, 2131100053); this.iAV != null; this.iAV = com.tencent.mm.ui.base.h.a(WebViewUI.this.getContext(), false, paramString2, "", WebViewUI.this.getString(2131755835), WebViewUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80139);
              localPBool.value = true;
              paramJsResult.confirm();
              AppMethodBeat.o(80139);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80140);
              paramJsResult.cancel();
              AppMethodBeat.o(80140);
            }
          }))
      {
        this.iAV.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(80141);
            ad.d("MicroMsg.WebViewUI", "onJsConfirm, onDismiss");
            if (!localPBool.value) {
              paramJsResult.cancel();
            }
            AppMethodBeat.o(80141);
          }
        });
        this.iAV.setCancelable(false);
        this.iAV.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(80156);
        return true;
      }
      boolean bool = super.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(80156);
      return bool;
    }
    
    public final boolean beF()
    {
      AppMethodBeat.i(80146);
      com.tencent.mm.plugin.ball.f.f.d(false, true, false);
      boolean bool = super.beF();
      AppMethodBeat.o(80146);
      return bool;
    }
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80149);
      ad.i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", new Object[] { paramString, WebViewUI.this.eox() });
      super.d(paramWebView, paramString);
      if (WebViewUI.this.BgD)
      {
        ad.i("MicroMsg.WebViewUI", "fixed title, ignore received title: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(80149);
        return;
      }
      if (paramString == null)
      {
        ad.e("MicroMsg.WebViewUI", "null title");
        AppMethodBeat.o(80149);
        return;
      }
      if (!WebViewUI.this.vZK)
      {
        AppMethodBeat.o(80149);
        return;
      }
      if ((!bt.nullAsNil(WebViewUI.this.eox()).equals(paramString)) && (!com.tencent.mm.plugin.webview.luggage.c.b.Ng(paramString)) && (!paramString.startsWith("about:blank"))) {
        WebViewUI.this.setMMTitle(paramString);
      }
      AppMethodBeat.o(80149);
    }
    
    public final View getVideoLoadingProgressView()
    {
      AppMethodBeat.i(80152);
      if (WebViewUI.n(WebViewUI.this) == null)
      {
        WebViewUI.a(WebViewUI.this, new ProgressBar(WebViewUI.this));
        WebViewUI.n(WebViewUI.this).setIndeterminate(true);
      }
      ProgressBar localProgressBar = WebViewUI.n(WebViewUI.this);
      AppMethodBeat.o(80152);
      return localProgressBar;
    }
    
    public final void onExitFullscreenVideo(Bitmap paramBitmap)
    {
      AppMethodBeat.i(80147);
      if ((WebViewUI.this.AQP != null) && (WebViewUI.this.eko().ASC) && (WebViewUI.this.eom().getVisibility() == 0))
      {
        WebViewUI.j(WebViewUI.this).onCustomViewHidden();
        WebViewUI.this.eko().tl(false);
        MPVideoPlayFullScreenView localMPVideoPlayFullScreenView = WebViewUI.this.eom();
        if (localMPVideoPlayFullScreenView.yEG)
        {
          ad.i(localMPVideoPlayFullScreenView.TAG, "isRunningExitAnimation");
          AppMethodBeat.o(80147);
          return;
        }
        localMPVideoPlayFullScreenView.eqD();
        if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
        {
          localObject = new ImageView(localMPVideoPlayFullScreenView.getContext());
          ViewGroup localViewGroup = localMPVideoPlayFullScreenView.Bsk;
          if (localViewGroup != null) {
            localViewGroup.addView((View)localObject, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
          }
          ((ImageView)localObject).setImageBitmap(paramBitmap);
        }
        ad.i(localMPVideoPlayFullScreenView.TAG, "runExitAnimation");
        localMPVideoPlayFullScreenView.eqE();
        int j = localMPVideoPlayFullScreenView.Bsh.getWidth();
        int i = localMPVideoPlayFullScreenView.Bsh.getHeight();
        paramBitmap = localMPVideoPlayFullScreenView.nzV;
        if (paramBitmap != null) {
          paramBitmap.jB(j, i);
        }
        paramBitmap = localMPVideoPlayFullScreenView.nzV;
        int k;
        if (paramBitmap != null)
        {
          localObject = localMPVideoPlayFullScreenView.gGE;
          if (localObject == null) {
            d.g.b.k.fvU();
          }
          j = ((com.tencent.mm.ai.y)localObject).gLa;
          localObject = localMPVideoPlayFullScreenView.gGE;
          if (localObject == null) {
            d.g.b.k.fvU();
          }
          k = ((com.tencent.mm.ai.y)localObject).gLb;
          localObject = localMPVideoPlayFullScreenView.gGE;
          if (localObject == null) {
            d.g.b.k.fvU();
          }
          int m = ((com.tencent.mm.ai.y)localObject).gLc;
          localObject = localMPVideoPlayFullScreenView.gGE;
          if (localObject == null) {
            d.g.b.k.fvU();
          }
          paramBitmap.P(j, k, m, ((com.tencent.mm.ai.y)localObject).gLd);
        }
        if (localMPVideoPlayFullScreenView.xwb != 1.0D)
        {
          paramBitmap = localMPVideoPlayFullScreenView.nzV;
          if (paramBitmap != null) {
            paramBitmap.HqK = (1.0F / localMPVideoPlayFullScreenView.xwb);
          }
          if ((localMPVideoPlayFullScreenView.xwc != 0) || (localMPVideoPlayFullScreenView.xwd != 0))
          {
            j = (int)(localMPVideoPlayFullScreenView.Bsh.getWidth() / 2 * (1.0F - localMPVideoPlayFullScreenView.xwb));
            k = localMPVideoPlayFullScreenView.xwc;
            i = (int)(localMPVideoPlayFullScreenView.Bsh.getHeight() / 2 + localMPVideoPlayFullScreenView.xwd - i / 2 * localMPVideoPlayFullScreenView.xwb);
            paramBitmap = localMPVideoPlayFullScreenView.nzV;
            if (paramBitmap != null) {
              paramBitmap.jD(j + k, i);
            }
          }
        }
        paramBitmap = localMPVideoPlayFullScreenView.Bsh.getLayoutParams();
        Object localObject = localMPVideoPlayFullScreenView.nzV;
        if (localObject != null)
        {
          ((com.tencent.mm.ui.tools.e)localObject).a((View)localMPVideoPlayFullScreenView.Bsk, localMPVideoPlayFullScreenView.Bsh, (e.c)new MPVideoPlayFullScreenView.p(localMPVideoPlayFullScreenView, paramBitmap), null);
          AppMethodBeat.o(80147);
          return;
        }
      }
      AppMethodBeat.o(80147);
    }
    
    public final void onGeolocationPermissionsShowPrompt(final String paramString, final GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(80153);
      ad.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[] { paramString });
      if (!com.tencent.mm.pluginsdk.permission.b.o(WebViewUI.this, "android.permission.ACCESS_COARSE_LOCATION")) {
        com.tencent.mm.pluginsdk.permission.b.b(WebViewUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64);
      }
      com.tencent.mm.ui.base.h.a(WebViewUI.this, false, WebViewUI.this.getString(2131766268, new Object[] { paramString }), WebViewUI.this.getString(2131766269), WebViewUI.this.getString(2131755835), WebViewUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(80133);
          ad.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt ok");
          paramCallback.invoke(paramString, true, true);
          e.a(WebViewUI.this.kxf, 14340, new Object[] { WebViewUI.this.bEx(), WebViewUI.this.ejo(), Integer.valueOf(WebViewUI.this.beH()), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(com.tencent.mm.plugin.webview.model.ax.baS()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(80133);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(80136);
          ad.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt cancel");
          paramCallback.invoke(paramString, false, false);
          e.a(WebViewUI.this.kxf, 14340, new Object[] { WebViewUI.this.bEx(), WebViewUI.this.ejo(), Integer.valueOf(WebViewUI.this.beH()), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(com.tencent.mm.plugin.webview.model.ax.baS()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(80136);
        }
      });
      AppMethodBeat.o(80153);
    }
    
    public final void onHideCustomView()
    {
      AppMethodBeat.i(80151);
      ad.i("MicroMsg.WebViewUI", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
      WebViewUI.this.getContext().getWindow().clearFlags(128);
      if (WebViewUI.k(WebViewUI.this) == null)
      {
        AppMethodBeat.o(80151);
        return;
      }
      try
      {
        WebViewUI.this.ts(WebViewUI.this.bFc());
        if (!WebViewUI.this.nhy.isXWalkKernel())
        {
          WebViewUI.this.nhy.setVisibility(0);
          WebViewUI.this.setTitleVisibility(0);
        }
        for (;;)
        {
          if (WebViewUI.this.BgN != null) {
            WebViewUI.this.BgN.removeView(WebViewUI.k(WebViewUI.this));
          }
          WebViewUI.a(WebViewUI.this, null);
          if (WebViewUI.m(WebViewUI.this) != null) {
            WebViewUI.m(WebViewUI.this).onCustomViewHidden();
          }
          AppMethodBeat.o(80151);
          return;
          WebViewUI.this.fullScreenNoTitleBar(false);
          WebViewUI.this.setStatusBarColor(WebViewUI.this.getResources().getColor(2131100952));
          if (WebViewUI.this.Bio != null)
          {
            ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)WebViewUI.this.Bio.getLayoutParams();
            int i = WebViewUI.l(WebViewUI.this);
            if (i != localMarginLayoutParams.topMargin)
            {
              localMarginLayoutParams.topMargin = i;
              WebViewUI.this.Bio.setLayoutParams(localMarginLayoutParams);
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.WebViewUI", "onHideCustomView error " + localException.getMessage());
        AppMethodBeat.o(80151);
      }
    }
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(80150);
      ad.i("MicroMsg.WebViewUI", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
      try
      {
        WebViewUI.this.getContext().getWindow().addFlags(128);
        if (WebViewUI.k(WebViewUI.this) != null)
        {
          paramCustomViewCallback.onCustomViewHidden();
          AppMethodBeat.o(80150);
          return;
        }
        WebViewUI.this.ts(false);
        WebViewUI.a(WebViewUI.this, paramView);
        WebViewUI.b(WebViewUI.this, paramCustomViewCallback);
        if (!WebViewUI.this.nhy.isXWalkKernel())
        {
          WebViewUI.this.nhy.setVisibility(8);
          WebViewUI.this.BgN.addView(paramView);
          WebViewUI.this.setTitleVisibility(4);
          AppMethodBeat.o(80150);
          return;
        }
      }
      catch (Exception paramView)
      {
        ad.e("MicroMsg.WebViewUI", "onShowCustomView error " + paramView.getMessage());
        AppMethodBeat.o(80150);
        return;
      }
      WebViewUI.this.BgN.addView(paramView, 0);
      WebViewUI.this.fullScreenNoTitleBar(true);
      WebViewUI.this.setStatusBarColor(0);
      if (WebViewUI.this.Bio != null)
      {
        paramView = (ViewGroup.MarginLayoutParams)WebViewUI.this.Bio.getLayoutParams();
        paramView.topMargin = 0;
        WebViewUI.this.Bio.setLayoutParams(paramView);
      }
      AppMethodBeat.o(80150);
    }
    
    public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      AppMethodBeat.i(80154);
      WebViewUI.o(WebViewUI.this).a(WebViewUI.this, WebViewUI.this.kxg, paramValueCallback, null, paramString1, paramString2);
      AppMethodBeat.o(80154);
    }
  }
  
  public final class c
    extends com.tencent.mm.plugin.webview.core.j
  {
    public c() {}
    
    public final boolean c(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(188025);
      ad.e("MicroMsg.WebViewUI", "edw interceptLoadError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1, Boolean.valueOf(ay.isConnected(WebViewUI.this)) });
      AppMethodBeat.o(188025);
      return false;
    }
    
    public final boolean ejE()
    {
      AppMethodBeat.i(188026);
      if ((WebViewUI.this.BhN) || (WebViewUI.r(WebViewUI.this)) || (WebViewUI.this.isFinishing()))
      {
        AppMethodBeat.o(188026);
        return true;
      }
      AppMethodBeat.o(188026);
      return false;
    }
    
    public final com.tencent.mm.plugin.webview.core.e ejF()
    {
      AppMethodBeat.i(188027);
      a locala = new a((byte)0);
      AppMethodBeat.o(188027);
      return locala;
    }
    
    public final com.tencent.mm.plugin.webview.core.i ejG()
    {
      AppMethodBeat.i(188028);
      b localb = new b((byte)0);
      AppMethodBeat.o(188028);
      return localb;
    }
    
    public final int getScreenOrientation()
    {
      return WebViewUI.this.screenOrientation;
    }
    
    final class a
      extends com.tencent.mm.plugin.webview.core.e
    {
      private a() {}
      
      public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
      {
        WebViewUI.this.BhW.Bfn = false;
      }
      
      public final void avy(String paramString)
      {
        AppMethodBeat.i(188007);
        WebViewUI.this.Bis.eoc();
        if ((WebViewUI.u(WebViewUI.this) != null) && (ay.isNetworkConnected(WebViewUI.this.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8")))
        {
          WebViewUI.u(WebViewUI.this).ef("rawUrl", paramString);
          WebViewUI.u(WebViewUI.this).awh(paramString);
        }
        WebViewUI.d(WebViewUI.this, paramString);
        WebViewUI.this.ts(WebViewUI.this.bFc());
        AppMethodBeat.o(188007);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(188006);
        WebViewUI.t(WebViewUI.this);
        if ((WebViewUI.u(WebViewUI.this) != null) && (ay.isNetworkConnected(WebViewUI.this.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8")))
        {
          WebViewUI.u(WebViewUI.this).ef("rawUrl", paramString);
          WebViewUI.u(WebViewUI.this).awh(paramString);
        }
        WebViewUI.d(WebViewUI.this, paramString);
        if (!WebViewUI.v(WebViewUI.this))
        {
          WebViewUI.w(WebViewUI.this);
          WebViewUI.this.AMJ.emp().loadFinished = true;
        }
        Object localObject = WebViewUI.this.nhy.getTitle();
        ad.i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", new Object[] { WebViewUI.this.getMMTitle(), localObject, Boolean.valueOf(WebViewUI.this.BgD), Boolean.valueOf(WebViewUI.this.vZK), WebViewUI.this.eox() });
        if ((WebViewUI.c.this.controller.nhy.getIsX5Kernel()) && (!bt.isNullOrNil((String)localObject)) && (((String)localObject).length() > 0) && (!((String)localObject).equals(WebViewUI.this.getMMTitle())) && (!((String)localObject).startsWith("http")) && ((WebViewUI.this.eox() == null) || (!WebViewUI.this.eox().equals(localObject))) && (!WebViewUI.this.BgD) && (WebViewUI.this.vZK))
        {
          ad.d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
          WebViewUI.this.setMMTitle((String)localObject);
        }
        WebViewUI.this.Bis.setCurrentURL(WebViewUI.this.ejo());
        WebViewUI.this.setProgressBarIndeterminateVisibility(false);
        WebViewUI.this.BgE.finish();
        if ((WebViewUI.this.Bid != null) && (!WebViewUI.this.Bid.BiN))
        {
          localObject = WebViewUI.this.Bid;
          ad.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", new Object[] { paramString });
          ((n)localObject).lst = paramString;
        }
        WebViewUI.e(WebViewUI.this, paramString);
        WebViewUI.this.b(paramWebView, paramString);
        AppMethodBeat.o(188006);
      }
      
      public final void e(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(188008);
        super.e(paramWebView, paramString);
        paramWebView = WebViewUI.this.Bid;
        ad.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", new Object[] { paramString });
        paramWebView.lst = paramString;
        AppMethodBeat.o(188008);
      }
      
      public final void m(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(188005);
        if (!WebViewUI.this.Biw) {
          WebViewUI.this.BhW.enV();
        }
        WebViewUI.this.Bis.eoc();
        WebViewUI.this.Bis.setCurrentURL(paramString);
        WebViewUI.this.setProgressBarIndeterminateVisibility(false);
        WebViewUI.this.BhW.axT(paramString);
        WebViewUI.this.tu(false);
        if ((WebViewUI.this.Bid != null) && (!WebViewUI.this.Bid.BiN))
        {
          paramWebView = WebViewUI.this.Bid;
          ad.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageStart, url:%s", new Object[] { paramString });
          paramWebView.lst = paramString;
          paramWebView.epf();
          paramString = (Bundle)n.Bfd.get(n.Pa(paramWebView.lst));
          if ((paramString != null) && (paramWebView.BiO != null)) {
            break label210;
          }
          paramWebView.epm();
        }
        for (;;)
        {
          WebViewUI.s(WebViewUI.this);
          AppMethodBeat.o(188005);
          return;
          label210:
          if (paramString.getBoolean("key_current_info_show")) {
            paramWebView.epl();
          } else {
            paramWebView.epm();
          }
        }
      }
    }
    
    final class b
      extends com.tencent.mm.plugin.webview.core.i
    {
      private b() {}
      
      public final void Sv(int paramInt)
      {
        AppMethodBeat.i(188021);
        if (WebViewUI.this.BgK != null)
        {
          FontChooserView localFontChooserView = (FontChooserView)WebViewUI.this.BgK.findViewById(2131300194);
          if (localFontChooserView != null) {
            localFontChooserView.setSliderIndex(paramInt - 1);
          }
        }
        AppMethodBeat.o(188021);
      }
      
      public final void a(String paramString, aoj paramaoj)
      {
        AppMethodBeat.i(188012);
        if (!bt.isNullOrNil(paramaoj.Title)) {
          WebViewUI.this.setMMTitle(paramaoj.Title);
        }
        if (paramaoj.Ctr == 6) {
          WebViewUI.this.tt(false);
        }
        AppMethodBeat.o(188012);
      }
      
      public final void avG(String paramString)
      {
        AppMethodBeat.i(188011);
        WebViewUI.this.bFg();
        AppMethodBeat.o(188011);
      }
      
      public final void avH(String paramString)
      {
        AppMethodBeat.i(188019);
        WebViewUI.this.axV(paramString);
        AppMethodBeat.o(188019);
      }
      
      public final void b(String paramString, aoj paramaoj)
      {
        WebViewUI.this.BhW.Bfk = paramaoj.DpE;
      }
      
      public final void bFs()
      {
        AppMethodBeat.i(188014);
        WebViewUI.this.tu(true);
        AppMethodBeat.o(188014);
      }
      
      public final void bf(int paramInt, String paramString)
      {
        AppMethodBeat.i(188009);
        super.bf(paramInt, paramString);
        if (paramInt != 5) {
          WebViewUI.this.tu(false);
        }
        AppMethodBeat.o(188009);
      }
      
      public final void c(String paramString, aoj paramaoj)
      {
        AppMethodBeat.i(188013);
        WebViewUI.this.nha = paramaoj.DpW;
        WebViewUI.b(WebViewUI.this, WebViewUI.this.kxg.emR().mb(24));
        WebViewUI.this.AMJ.emp().AZl = true;
        WebViewUI.this.Bhj = z.a(paramaoj.DpV);
        ad.d("MicroMsg.WebViewUI", "onPermissionUpdate, getA8Key = %s", new Object[] { bt.cy(WebViewUI.this.Bhj) });
        AppMethodBeat.o(188013);
      }
      
      public final void d(int paramInt1, String paramString1, int paramInt2, String paramString2)
      {
        AppMethodBeat.i(188022);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(154L, 12L, 1L, false);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(154L, com.tencent.mm.plugin.webview.h.a.Ta(paramInt1), 1L, false);
        WebViewUI.this.tu(true);
        WebViewUI.this.BhW.Bfn = false;
        switch (paramInt1)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(188022);
          return;
          k.BfO.TA(paramInt2);
          if ((WebViewUI.this.BhC != null) && (this.controller.ejk())) {
            WebViewUI.this.eoP();
          }
          WebViewUI.this.AMJ.emp().AZl = false;
          WebViewUI.this.AMJ.emj().cb(paramString1, false);
          if (WebViewUI.z(WebViewUI.this)) {
            WebViewUI.this.finish();
          }
        }
      }
      
      public final void dvS()
      {
        AppMethodBeat.i(188015);
        if (WebViewUI.this.BhQ)
        {
          ad.e("MicroMsg.WebViewUI", "edw postBinded hasDoPostBind");
          AppMethodBeat.o(188015);
          return;
        }
        WebViewUI.this.BhQ = true;
        WebViewUI.this.bol();
        AppMethodBeat.o(188015);
      }
      
      public final void ejA()
      {
        AppMethodBeat.i(188016);
        WebViewUI.this.goBack();
        AppMethodBeat.o(188016);
      }
      
      public final void ejB()
      {
        AppMethodBeat.i(188018);
        WebViewUI.this.eoA();
        AppMethodBeat.o(188018);
      }
      
      public final void ejC()
      {
        AppMethodBeat.i(188023);
        super.ejC();
        WebViewUI.this.BgE.start();
        AppMethodBeat.o(188023);
      }
      
      public final void ejD()
      {
        AppMethodBeat.i(188024);
        super.ejD();
        WebViewUI.this.BgE.finish();
        AppMethodBeat.o(188024);
      }
      
      public final void ejz()
      {
        AppMethodBeat.i(188010);
        ad.i("MicroMsg.WebViewUI", "WebView-Trace onAuthSucc: url %s", new Object[] { WebViewUI.this.nha });
        WebViewUI.a(WebViewUI.this, this.controller.kxg.emR());
        if (!WebViewUI.this.Biw) {
          WebViewUI.this.BhW.Bfn = true;
        }
        i locali = WebViewUI.this.BhW;
        locali.Bfo.add(Integer.valueOf(6));
        locali.Bfo.add(Integer.valueOf(1));
        locali.Bfo.add(Integer.valueOf(3));
        locali.Bfo.add(Integer.valueOf(2));
        WebViewUI.this.BhW.Bfn = true;
        if (WebViewUI.this.BhW.nmt) {
          WebViewUI.this.bFd();
        }
        AppMethodBeat.o(188010);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(188017);
        WebViewUI.this.finish();
        AppMethodBeat.o(188017);
      }
      
      public final void te(boolean paramBoolean)
      {
        AppMethodBeat.i(188020);
        if ((paramBoolean) && (WebViewUI.this.nhy != null))
        {
          WebViewUI.this.nhy.setOnLongClickListener(WebViewUI.x(WebViewUI.this));
          WebViewUI.y(WebViewUI.this);
        }
        AppMethodBeat.o(188020);
      }
    }
  }
  
  final class d
    implements FontChooserView.a
  {
    private d() {}
    
    public final void LB(int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(80184);
      switch (paramInt)
      {
      default: 
        i = 2;
      }
      for (;;)
      {
        WebViewUI.this.AMZ.Su(i);
        try
        {
          if (WebViewUI.this.kxf.enj())
          {
            com.tencent.mm.sdk.platformtools.ax localax = com.tencent.mm.sdk.platformtools.ax.fF("WebViewFontUtil", 2);
            localax.putBoolean("webview_key_font_has_set", true);
            localax.putBoolean("webview_key_has_transfer_mp", true);
            localax.apply();
            com.tencent.mm.plugin.webview.j.e.tH(false);
            WebViewUI.this.kxf.iA(16384, i);
            WebViewUI.this.kxf.iA(16388, i);
          }
          AppMethodBeat.o(80184);
          return;
        }
        catch (Exception localException)
        {
          ad.w("MicroMsg.WebViewUI", "onCheckedChanged, ex = " + localException.getMessage());
          AppMethodBeat.o(80184);
        }
        i = 2;
        continue;
        i = 3;
        continue;
        i = 4;
        continue;
        i = 5;
        continue;
        i = 6;
        continue;
        i = 7;
        continue;
        i = 8;
      }
    }
  }
  
  static final class e
  {
    final int id;
    final WeakReference<WebViewUI> kUk;
    
    public e(WebViewUI paramWebViewUI)
    {
      AppMethodBeat.i(80216);
      this.kUk = new WeakReference(paramWebViewUI);
      this.id = paramWebViewUI.eiZ();
      AppMethodBeat.o(80216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI
 * JD-Core Version:    0.7.0.1
 */