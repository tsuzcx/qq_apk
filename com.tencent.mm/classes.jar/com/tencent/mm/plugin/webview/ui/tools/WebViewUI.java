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
import com.tencent.mm.g.a.tc;
import com.tencent.mm.n.d.a;
import com.tencent.mm.n.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.c.f.25;
import com.tencent.mm.plugin.webview.c.f.61;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.c;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.f;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.model.aw;
import com.tencent.mm.plugin.webview.model.ay.f;
import com.tencent.mm.plugin.webview.model.ay.g;
import com.tencent.mm.plugin.webview.model.ay.j;
import com.tencent.mm.plugin.webview.model.ay.l;
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
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.model.w.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bz;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.t;
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
import com.tencent.xweb.ab;
import com.tencent.xweb.o;
import com.tencent.xweb.x.a;
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
  implements View.OnCreateContextMenuListener, com.tencent.mm.plugin.webview.core.b, com.tencent.mm.plugin.webview.g.a.b, com.tencent.mm.plugin.webview.ui.tools.video.samelayer.e, bh.a, MMWebView.e
{
  private static final Pattern DOZ;
  private static final Pattern DPa;
  protected static int EdH;
  private static final ArrayList<e> Edi;
  private static WebSettings.RenderPriority Edn;
  private static Boolean Eei;
  public com.tencent.mm.plugin.webview.model.ay DIg;
  protected com.tencent.mm.plugin.webview.core.h DIv;
  protected com.tencent.mm.plugin.webview.stub.f DNO;
  public com.tencent.mm.plugin.webview.c.f DzP;
  final com.tencent.mm.plugin.webview.modeltools.a EaP;
  private View Eav;
  protected MMFalseProgressBar EcA;
  public ProgressBar EcB;
  public com.tencent.mm.ui.base.p EcC;
  private g EcD;
  private ImageButton EcE;
  private ImageButton EcF;
  protected View EcG;
  protected WebViewKeyboardLinearLayout EcH;
  protected FrameLayout EcI;
  public FrameLayout EcJ;
  protected MovingImageButton EcK;
  protected boolean EcL;
  private boolean EcM;
  protected com.tencent.mm.bp.a EcN;
  private WebViewInputFooter EcO;
  protected WebViewSearchContentInputFooter EcP;
  private boolean EcQ;
  private boolean EcR;
  public String EcS;
  protected boolean EcT;
  protected boolean EcU;
  protected long EcV;
  private boolean EcW;
  private int EcX;
  int EcY;
  private boolean EcZ;
  protected boolean Ecy;
  private boolean Ecz;
  private final boolean EdA;
  private boolean EdB;
  protected volatile boolean EdC;
  protected boolean EdD;
  private Map EdE;
  private int EdF;
  public int EdG;
  public boolean EdI;
  private boolean EdJ;
  private boolean EdK;
  protected boolean EdL;
  protected volatile boolean EdM;
  private com.tencent.mm.plugin.webview.j.i EdN;
  private com.tencent.mm.plugin.webview.model.b EdO;
  protected com.tencent.mm.plugin.webview.modeltools.n EdP;
  protected h EdQ;
  public i EdR;
  protected IUtils EdS;
  private WebViewClipBoardHelper EdT;
  protected com.tencent.mm.plugin.webview.c EdU;
  protected volatile String EdV;
  protected volatile long EdW;
  protected HandOffURL EdX;
  public n EdY;
  com.tencent.mm.plugin.webview.ui.tools.floatball.a EdZ;
  protected boolean Eda;
  private boolean Edb;
  protected boolean Edc;
  protected int Edd;
  protected byte[] Ede;
  private boolean Edf;
  private View Edg;
  private av Edh;
  private boolean Edj;
  private WebChromeClient.CustomViewCallback Edk;
  protected com.tencent.xweb.x Edl;
  private ProgressBar Edm;
  public com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h Edo;
  private final com.tencent.mm.sdk.b.c<SendDataToH5FromMiniProgramEvent> Edp;
  private boolean Edq;
  protected HashMap<String, Boolean> Edr;
  protected HashMap<String, String> Eds;
  protected HashMap<String, ArrayList<d.b>> Edt;
  protected HashMap<String, Boolean> Edu;
  protected a Edv;
  protected com.tencent.mm.ui.widget.a.d Edw;
  protected View Edx;
  protected String Edy;
  private boolean Edz;
  private boolean Eea;
  protected ab Eeb;
  private com.tencent.mm.sdk.b.c<tc> Eec;
  private com.tencent.mm.plugin.webview.ui.tools.widget.n Eed;
  private boolean Eee;
  private MPVideoPlayFullScreenView Eef;
  int Eeg;
  private boolean Eeh;
  protected View Eej;
  private View Eek;
  private com.tencent.mm.bp.a.b Eel;
  private boolean Eem;
  public final j Een;
  public final com.tencent.mm.plugin.webview.ui.tools.media.e Eeo;
  private boolean Eep;
  private View.OnLongClickListener Eeq;
  protected boolean Eer;
  private View.OnLongClickListener Ees;
  protected View.OnLongClickListener Eet;
  private String Eeu;
  protected volatile String Eev;
  private WebChromeClient.CustomViewCallback Eew;
  public int Eex;
  public String dHu;
  private com.tencent.mm.ui.base.p fNb;
  public ap handler;
  private final com.tencent.mm.plugin.webview.modeltools.d lvF;
  public com.tencent.mm.plugin.webview.stub.e lvv;
  protected com.tencent.mm.plugin.webview.e.g lvw;
  private int mFF;
  protected int nYw;
  protected int nYx;
  private int ogL;
  public MMWebView omW;
  public String omw;
  protected int screenOrientation;
  protected String sessionId;
  protected com.tencent.mm.ui.widget.snackbar.a.b tUH;
  public int ulS;
  public String ulT;
  private View vd;
  private long vwS;
  protected boolean yyS;
  
  static
  {
    AppMethodBeat.i(80400);
    Edi = new ArrayList();
    Edn = WebSettings.RenderPriority.NORMAL;
    EdH = 0;
    Eei = null;
    DOZ = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    DPa = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    AppMethodBeat.o(80400);
  }
  
  public WebViewUI()
  {
    AppMethodBeat.i(80217);
    this.Ecy = false;
    this.Ecz = false;
    this.screenOrientation = -1;
    this.EcL = false;
    this.EcM = false;
    this.EcS = null;
    this.EcT = true;
    this.EcU = false;
    this.EcV = 0L;
    this.EcW = false;
    this.sessionId = "";
    this.EcY = -1;
    this.yyS = true;
    this.EcZ = false;
    this.Eda = true;
    this.Edb = false;
    this.Edc = false;
    this.Ede = new byte[0];
    this.DzP = null;
    this.Edf = false;
    this.Edj = false;
    this.lvw = null;
    this.Edo = new com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h(this);
    this.Edp = new com.tencent.mm.sdk.b.c() {};
    this.Edq = false;
    this.lvv = null;
    this.DIv = null;
    this.Edr = new HashMap();
    this.Eds = new HashMap();
    this.Edt = new HashMap();
    this.Edu = new HashMap();
    this.Edw = null;
    this.Edx = null;
    this.Edy = null;
    this.Edz = false;
    this.EdA = true;
    this.EdB = false;
    this.ulS = 0;
    this.ulT = null;
    this.EdC = false;
    this.EdD = false;
    this.EdF = 0;
    this.EdG = ((int)(System.currentTimeMillis() / 1000L));
    this.EdI = false;
    this.EdJ = false;
    this.EdK = false;
    this.EdL = false;
    this.EdM = false;
    this.DIg = new com.tencent.mm.plugin.webview.model.ay();
    this.EdN = new com.tencent.mm.plugin.webview.j.i();
    this.EdP = new com.tencent.mm.plugin.webview.modeltools.n();
    this.EdS = null;
    this.Eea = false;
    this.Eeb = new ab()
    {
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(80053);
        if (WebViewUI.this.omW == null)
        {
          AppMethodBeat.o(80053);
          return false;
        }
        ak localak = WebViewUI.this.DIg.eQC();
        if (paramAnonymousInt4 > localak.DUd) {
          localak.DUd = paramAnonymousInt4;
        }
        localak.Aod = paramAnonymousInt6;
        paramAnonymousBoolean = WebViewUI.this.omW.c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
        AppMethodBeat.o(80053);
        return paramAnonymousBoolean;
      }
      
      public final void bpf()
      {
        AppMethodBeat.i(80054);
        if (WebViewUI.this.omW == null)
        {
          AppMethodBeat.o(80054);
          return;
        }
        WebViewUI.this.omW.fLB();
        AppMethodBeat.o(80054);
      }
      
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(80055);
        if (WebViewUI.this.omW == null)
        {
          AppMethodBeat.o(80055);
          return;
        }
        WebViewUI.this.omW.i(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
        if ((paramAnonymousBoolean2) && (WebViewUI.this.DIg != null)) {
          WebViewUI.this.DIg.w("mm_scroll_bottom", Boolean.TRUE);
        }
        AppMethodBeat.o(80055);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(80056);
        if (WebViewUI.this.omW == null)
        {
          AppMethodBeat.o(80056);
          return;
        }
        WebViewUI.this.omW.S(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        WebViewUI.this.onWebViewScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(80056);
      }
      
      public final boolean x(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80052);
        if (WebViewUI.this.omW == null)
        {
          AppMethodBeat.o(80052);
          return false;
        }
        boolean bool = WebViewUI.this.omW.ah(paramAnonymousMotionEvent);
        AppMethodBeat.o(80052);
        return bool;
      }
      
      public final boolean y(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80057);
        if (WebViewUI.this.omW == null)
        {
          AppMethodBeat.o(80057);
          return false;
        }
        boolean bool = WebViewUI.this.omW.ai(paramAnonymousMotionEvent);
        AppMethodBeat.o(80057);
        return bool;
      }
      
      public final boolean z(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80058);
        if (WebViewUI.this.omW == null)
        {
          AppMethodBeat.o(80058);
          return false;
        }
        boolean bool = WebViewUI.this.omW.aj(paramAnonymousMotionEvent);
        AppMethodBeat.o(80058);
        return bool;
      }
    };
    this.Eec = new com.tencent.mm.sdk.b.c()
    {
      private boolean eTp()
      {
        AppMethodBeat.i(80075);
        if (WebViewUI.this.lvv == null)
        {
          ad.e("MicroMsg.WebViewUI", "Cli Event, invoker is null");
          AppMethodBeat.o(80075);
          return false;
        }
        if ((WebViewUI.this.EdV == null) || (WebViewUI.this.EdV.length() == 0))
        {
          ad.e("MicroMsg.WebViewUI", "Cli Event, tid is null");
          AppMethodBeat.o(80075);
          return false;
        }
        try
        {
          long l = System.currentTimeMillis();
          ad.i("MicroMsg.WebViewUI", "Cli Event, tid = %s, stime = %d, etime = %d", new Object[] { WebViewUI.this.EdV, Long.valueOf(WebViewUI.this.EdW), Long.valueOf(l) });
          Bundle localBundle = new Bundle();
          localBundle.putString("service_click_tid", new String(WebViewUI.this.EdV));
          localBundle.putLong("service_click_stime", WebViewUI.this.EdW);
          localBundle.putLong("service_click_etime", l);
          WebViewUI.this.lvv.y(2836, localBundle);
          WebViewUI.this.EdV = null;
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
    this.Eee = false;
    this.Eeg = 0;
    this.Eeh = true;
    this.vwS = 0L;
    this.ogL = 0;
    this.Eel = new com.tencent.mm.bp.a.b()
    {
      public final void a(com.tencent.mm.bp.a.a paramAnonymousa1, com.tencent.mm.bp.a.a paramAnonymousa2)
      {
        AppMethodBeat.i(208077);
        ad.i("MicroMsg.WebViewUI", "OrientationListener lastOrientation:" + paramAnonymousa1.name() + "; newOrientation:" + paramAnonymousa2.name());
        WebViewUI.this.screenOrientation = 4;
        WebViewUI.this.setMMOrientation();
        if (WebViewUI.this.EcN != null) {
          WebViewUI.this.EcN.disable();
        }
        AppMethodBeat.o(208077);
      }
    };
    this.Eem = false;
    this.Een = new j();
    this.lvF = new com.tencent.mm.plugin.webview.modeltools.d();
    this.EaP = new com.tencent.mm.plugin.webview.modeltools.a();
    this.Eeo = new com.tencent.mm.plugin.webview.ui.tools.media.e();
    this.Eeq = new View.OnLongClickListener()
    {
      private boolean eTo()
      {
        boolean bool2 = true;
        AppMethodBeat.i(208057);
        Object localObject = null;
        try
        {
          WebView.b localb = WebViewUI.this.omW.getHitTestResult();
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
          AppMethodBeat.o(208057);
          return false;
        }
        try
        {
          bool1 = WebViewUI.this.lvv.fE(localObject.mExtra);
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
          WebViewUI.this.lvv.fL(localObject.mExtra, WebViewUI.this.eNj());
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
        AppMethodBeat.o(208057);
        return bool1;
      }
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208056);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$29", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        if (WebViewUI.this.getIntent().getBooleanExtra("show_long_click_popup_menu", true))
        {
          boolean bool = eTo();
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$29", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(208056);
          return bool;
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$29", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(208056);
        return true;
      }
    };
    this.Eer = false;
    this.Eet = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208061);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$33", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        if ((WebViewUI.e(WebViewUI.this) != null) && ((com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (bu.flY())))
        {
          boolean bool = WebViewUI.e(WebViewUI.this).onLongClick(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$33", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(208061);
          return bool;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$33", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(208061);
        return false;
      }
    };
    this.Eev = "";
    this.tUH = new com.tencent.mm.ui.widget.snackbar.a.b()
    {
      public final void bip()
      {
        AppMethodBeat.i(208073);
        try
        {
          WebViewUI.this.lvv.favEditTag();
          AppMethodBeat.o(208073);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + localException.getMessage());
          AppMethodBeat.o(208073);
        }
      }
    };
    this.Eex = -1;
    AppMethodBeat.o(80217);
  }
  
  private void a(JsapiPermissionWrapper paramJsapiPermissionWrapper)
  {
    AppMethodBeat.i(208125);
    if (paramJsapiPermissionWrapper != null)
    {
      if (paramJsapiPermissionWrapper.mz(34))
      {
        setMMSubTitle(2131766182);
        AppMethodBeat.o(208125);
        return;
      }
      if (paramJsapiPermissionWrapper.mz(75))
      {
        setMMSubTitle(2131766195);
        AppMethodBeat.o(208125);
        return;
      }
      setMMSubTitle(null);
    }
    AppMethodBeat.o(208125);
  }
  
  private void aIO(String paramString)
  {
    AppMethodBeat.i(80239);
    if ((this.EdZ != null) && (!bt.isNullOrNil(paramString)) && (!com.tencent.mm.plugin.webview.ui.tools.floatball.a.isMpUrl(bQm()))) {
      this.EdZ.Wm(paramString);
    }
    AppMethodBeat.o(80239);
  }
  
  private void aIP(String paramString)
  {
    AppMethodBeat.i(80240);
    if ((this.EdX != null) && (!bt.isNullOrNil(paramString)) && (!com.tencent.mm.plugin.webview.ui.tools.floatball.a.isMpUrl(bQm())) && (!this.EdX.title.equals(paramString)))
    {
      this.EdX.setTitle(paramString);
      if (ePk()) {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.EdX);
      }
    }
    AppMethodBeat.o(80240);
  }
  
  private static String aIQ(String paramString)
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
  
  private void aas(String paramString)
  {
    AppMethodBeat.i(80241);
    if (this.DzP != null)
    {
      this.DzP.aGI(paramString);
      try
      {
        if (paramString.equals("onPause"))
        {
          this.lvv.Xn(this.DIv.eNj());
          AppMethodBeat.o(80241);
          return;
        }
        if (paramString.equals("onResume")) {
          this.lvv.Xm(this.DIv.eNj());
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
  
  private static void ax(View paramView, int paramInt)
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
  
  private boolean eRI()
  {
    boolean bool1 = false;
    AppMethodBeat.i(80298);
    try
    {
      if (this.lvv == null)
      {
        ad.w("MicroMsg.WebViewUI", "invoker is null");
        AppMethodBeat.o(80298);
        return false;
      }
      boolean bool2 = this.lvv.eRI();
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
  
  private static boolean eSD()
  {
    AppMethodBeat.i(80248);
    if (Eei == null) {}
    try
    {
      if (bt.getInt(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_webview_force_dark_disable", "0", false, true), 1) > 0) {
        ad.i("MicroMsg.WebViewUI", "disableForceDark on!!");
      }
      for (Eei = Boolean.TRUE;; Eei = Boolean.FALSE)
      {
        boolean bool = Eei.booleanValue();
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
        Eei = Boolean.FALSE;
      }
    }
  }
  
  private boolean eSF()
  {
    return (this.EcL) || (this.EcM);
  }
  
  private int eSG()
  {
    AppMethodBeat.i(80252);
    if (this.EdA) {}
    for (int i = 0; (getSupportActionBar() == null) || (!getSupportActionBar().isShowing()); i = this.mFF)
    {
      AppMethodBeat.o(80252);
      return i;
    }
    int j = getActionBarHeight();
    AppMethodBeat.o(80252);
    return i + j;
  }
  
  private View eSM()
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
  
  private com.tencent.mm.plugin.webview.model.b eSv()
  {
    AppMethodBeat.i(208102);
    if (this.EdO == null) {
      this.EdO = new com.tencent.mm.plugin.webview.model.b(this.DIg);
    }
    com.tencent.mm.plugin.webview.model.b localb = this.EdO;
    AppMethodBeat.o(208102);
    return localb;
  }
  
  private void eTb()
  {
    AppMethodBeat.i(80316);
    if (this.Edg != null) {
      this.Edg.setVisibility(8);
    }
    if (this.Edh != null) {
      this.Edh.stopTimer();
    }
    AppMethodBeat.o(80316);
  }
  
  private boolean eTf()
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
        } while (bt.V(new String[] { str2, str3, str4 }));
        if (bool) {
          com.tencent.mm.ui.base.h.a(this, str1, str2, str3, str4, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(208071);
              WebViewUI.this.EdI = true;
              k.EbJ.close();
              WebViewUI.this.finish();
              AppMethodBeat.o(208071);
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
              AppMethodBeat.i(208072);
              WebViewUI.this.EdI = true;
              k.EbJ.close();
              WebViewUI.this.finish();
              AppMethodBeat.o(208072);
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
    ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
    ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
    startActivityForResult((Intent)localObject, i);
    com.tencent.mm.ui.base.b.kf(this);
    AppMethodBeat.o(80355);
    return true;
  }
  
  private void eTh()
  {
    AppMethodBeat.i(80357);
    if (this.EdK)
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
      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localBundle, com.tencent.mm.pluginsdk.model.app.v.class, null);
    }
    AppMethodBeat.o(80357);
  }
  
  private static void fM(View paramView)
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
  
  private void uY(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.Edj = true;
    }
  }
  
  private void updateOrientation()
  {
    AppMethodBeat.i(208117);
    if (this.lvv != null) {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("screen_orientation", this.screenOrientation);
        this.lvv.k(83, localBundle);
        AppMethodBeat.o(208117);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.WebViewUI", "ac_set_screen_orientation : " + localException.getMessage());
      }
    }
    AppMethodBeat.o(208117);
  }
  
  public final void Cs(long paramLong)
  {
    AppMethodBeat.i(208118);
    this.EdR.Cs(paramLong);
    AppMethodBeat.o(208118);
  }
  
  protected void Q(Bundle paramBundle)
  {
    AppMethodBeat.i(208128);
    this.EdR.eSl();
    AppMethodBeat.o(208128);
  }
  
  protected void WI(int paramInt)
  {
    AppMethodBeat.i(80351);
    if ((this.omW == null) || (this.omW.getSettings() == null))
    {
      AppMethodBeat.o(80351);
      return;
    }
    ad.i("MicroMsg.WebViewUI", "localSetFontSize, fontSize = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      this.omW.getSettings().setTextZoom(100);
      AppMethodBeat.o(80351);
      return;
    case 1: 
      this.omW.getSettings().setTextZoom(80);
      AppMethodBeat.o(80351);
      return;
    case 2: 
      this.omW.getSettings().setTextZoom(100);
      AppMethodBeat.o(80351);
      return;
    case 3: 
      this.omW.getSettings().setTextZoom(110);
      AppMethodBeat.o(80351);
      return;
    case 4: 
      this.omW.getSettings().setTextZoom(112);
      AppMethodBeat.o(80351);
      return;
    case 5: 
      this.omW.getSettings().setTextZoom(112);
      AppMethodBeat.o(80351);
      return;
    case 6: 
      this.omW.getSettings().setTextZoom(140);
      AppMethodBeat.o(80351);
      return;
    case 7: 
      this.omW.getSettings().setTextZoom(155);
      AppMethodBeat.o(80351);
      return;
    }
    this.omW.getSettings().setTextZoom(165);
    AppMethodBeat.o(80351);
  }
  
  public final void X(String paramString, long paramLong)
  {
    AppMethodBeat.i(208103);
    if ((this.DzP != null) && (this.omW != null))
    {
      Object localObject1 = this.DzP;
      this.omW.getUrl();
      Object localObject2 = getIntent();
      if ((this.lvw.eRh().FnB & 0x100000) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ad.d("MicroMsg.GeneralControlWrapper", "allowOnScreenShot, ret = ".concat(String.valueOf(bool)));
        if (!((com.tencent.mm.plugin.webview.c.f)localObject1).BHY) {
          break label388;
        }
        ad.i("MicroMsg.JsApiHandler", "onScreenShot hasPermission: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramString = l.a.b("onScreenShot", new HashMap(), ((com.tencent.mm.plugin.webview.c.f)localObject1).DMD, ((com.tencent.mm.plugin.webview.c.f)localObject1).vJP);
          ((com.tencent.mm.plugin.webview.c.f)localObject1).DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
        }
        paramString = ((com.tencent.mm.plugin.webview.c.f)localObject1).aGD(((com.tencent.mm.plugin.webview.c.f)localObject1).getCurrentUrl());
        if (localObject2 == null) {
          break label388;
        }
        try
        {
          localObject1 = ((com.tencent.mm.plugin.webview.c.f)localObject1).getCurrentUrl();
          localObject2 = ((Intent)localObject2).getBundleExtra("ad_report_bundle");
          if ((!bt.isNullOrNil((String)localObject1)) && (localObject2 != null))
          {
            localObject2 = ((Bundle)localObject2).getString("ad_report_ux_info");
            if (!bt.isNullOrNil((String)localObject2))
            {
              int i = (int)(System.currentTimeMillis() / 1000L);
              Object localObject3 = Uri.parse((String)localObject1);
              String str = ((Uri)localObject3).getQueryParameter("mid");
              localObject3 = ((Uri)localObject3).getQueryParameter("idx");
              ad.i("MicroMsg.JsApiHandler", "alvinluo reportAdOnScreenShot appId: %s, mid: %s, idx: %s, adUxInfo: %s, url: %s", new Object[] { paramString, str, localObject3, localObject2, localObject1 });
              com.tencent.mm.plugin.report.service.g.yhR.f(19213, new Object[] { Integer.valueOf(i), Integer.valueOf(6), localObject2, paramString, str, localObject3, localObject1 });
            }
          }
          AppMethodBeat.o(208103);
          return;
        }
        catch (Exception paramString)
        {
          ad.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "alvinluo reportAdOnScreenShot exception", new Object[0]);
        }
      }
    }
    label388:
    AppMethodBeat.o(208103);
  }
  
  public final void XA(int paramInt)
  {
    AppMethodBeat.i(208121);
    this.DzP.cn("sendAppMessage", true);
    this.DzP.b(this.EdR.eSj(), paramInt);
    this.DIg.aHE("mm_send_friend_count");
    AppMethodBeat.o(208121);
  }
  
  protected final void Xy(int paramInt)
  {
    AppMethodBeat.i(80288);
    Drawable localDrawable = getResources().getDrawable(eSS()).mutate();
    localDrawable.setColorFilter(paramInt, PorterDuff.Mode.SRC_IN);
    updateBackBtn(localDrawable);
    AppMethodBeat.o(80288);
  }
  
  protected final void Xz(int paramInt)
  {
    AppMethodBeat.i(80315);
    if (paramInt != -3)
    {
      AppMethodBeat.o(80315);
      return;
    }
    if (this.Edg == null)
    {
      AppMethodBeat.o(80315);
      return;
    }
    if ((this.lvw.eRh().FnB & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = ".concat(String.valueOf(bool)));
      if (!bool) {
        break label236;
      }
      if ((this.Edg.getVisibility() != 0) && (!this.EcP.isShown())) {
        break;
      }
      AppMethodBeat.o(80315);
      return;
    }
    if (this.Edh == null) {
      this.Edh = new av(Looper.getMainLooper(), new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(208065);
          WebViewUI.i(WebViewUI.this);
          AppMethodBeat.o(208065);
          return false;
        }
      }, false);
    }
    this.Edh.az(4000L, 4000L);
    View localView = this.Edg;
    ((ImageView)localView.findViewById(2131301454)).setImageResource(2131690929);
    TextView localTextView = (TextView)localView.findViewById(2131301455);
    localTextView.setTextSize(14.0F);
    localTextView.setText(2131766250);
    ((ImageButton)localView.findViewById(2131301453)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208066);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WebViewUI.i(WebViewUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208066);
      }
    });
    this.Edg.setVisibility(0);
    com.tencent.mm.plugin.report.service.g.yhR.kvStat(13125, bQm());
    label236:
    AppMethodBeat.o(80315);
  }
  
  protected void Zm()
  {
    AppMethodBeat.i(80342);
    this.EdR.Zm();
    AppMethodBeat.o(80342);
  }
  
  @TargetApi(21)
  protected final void a(ViewGroup paramViewGroup, WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(80253);
    if (this.mFF == paramWindowInsets.getSystemWindowInsetTop())
    {
      AppMethodBeat.o(80253);
      return;
    }
    this.mFF = paramWindowInsets.getSystemWindowInsetTop();
    eSE();
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
    if (eSH()) {
      eSJ();
    }
    AppMethodBeat.o(80253);
  }
  
  public final void a(com.tencent.mm.plugin.webview.ui.tools.video.b paramb)
  {
    AppMethodBeat.i(208106);
    this.Edo.a(paramb);
    AppMethodBeat.o(208106);
  }
  
  public final void a(com.tencent.mm.ui.base.p paramp)
  {
    this.fNb = paramp;
  }
  
  public final void aF(Bundle paramBundle)
  {
    AppMethodBeat.i(80231);
    this.Eeg = paramBundle.getInt("state", 0);
    AppMethodBeat.o(80231);
  }
  
  public final void aG(Bundle paramBundle)
  {
    AppMethodBeat.i(80227);
    if (paramBundle != null)
    {
      this.Eee = "black".equals(paramBundle.getString("style"));
      eSy().setCommentTopicId(paramBundle.getLong("commentTopicId"));
    }
    eSy().aJB(this.DIv.getCurrentUrl());
    eSy().vr(false);
    AppMethodBeat.o(80227);
  }
  
  public final String aGj(String paramString)
  {
    AppMethodBeat.i(208123);
    paramString = this.DIv.aGj(paramString);
    AppMethodBeat.o(208123);
    return paramString;
  }
  
  protected final int aGo(String paramString)
  {
    AppMethodBeat.i(80336);
    int i = this.DIv.aGo(paramString);
    AppMethodBeat.o(80336);
    return i;
  }
  
  public final void aH(Bundle paramBundle)
  {
    AppMethodBeat.i(80229);
    if (paramBundle != null)
    {
      this.Eee = "black".equals(paramBundle.getString("style"));
      eSy().vr(true);
    }
    AppMethodBeat.o(80229);
  }
  
  public final void aI(Bundle paramBundle)
  {
    AppMethodBeat.i(80230);
    this.fNb = com.tencent.mm.plugin.webview.ui.tools.widget.p.a(paramBundle, getContext(), this.fNb);
    AppMethodBeat.o(80230);
  }
  
  public final void aIN(String paramString)
  {
    AppMethodBeat.i(80306);
    this.EdR.aIN(paramString);
    AppMethodBeat.o(80306);
  }
  
  public final void aIR(String paramString)
  {
    AppMethodBeat.i(80317);
    this.DzP.cn("profile", true);
    this.DzP.aGJ(paramString);
    AppMethodBeat.o(80317);
  }
  
  public final void aJ(Bundle paramBundle)
  {
    AppMethodBeat.i(175797);
    if (paramBundle != null) {
      eSy().setCommentTopicId(paramBundle.getLong("commentTopicId"));
    }
    eSy().aJB(this.DIv.getCurrentUrl());
    com.tencent.mm.plugin.webview.ui.tools.widget.n localn = eSy();
    String str = paramBundle.getString("reply_content");
    int i = paramBundle.getInt("personal_comment_id");
    d.g.b.p.h(str, "replyContent");
    localn.tQ(2);
    localn.vt(false);
    if ((!bt.isNullOrNil(str)) && (i != 0) && (localn.eVJ()))
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n.a(localn, str, i);
      localn.vs(false);
      AppMethodBeat.o(175797);
      return;
    }
    localn.vr(false);
    AppMethodBeat.o(175797);
  }
  
  protected final void aJ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(80280);
    this.EcL = paramBoolean1;
    Object localObject;
    if (paramBoolean1)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      if (this.Eej != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.Eej.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
        this.Eej.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.EdA) {
        com.tencent.mm.ui.statusbar.a.I(this.Eej, true);
      }
      for (;;)
      {
        getWindow().addFlags(1024);
        localObject = getWindow().getDecorView();
        ((View)localObject).setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
        {
          public final void onSystemUiVisibilityChange(int paramAnonymousInt)
          {
            AppMethodBeat.i(208035);
            if (((paramAnonymousInt & 0x4) == 0) && (WebViewUI.this.EcL)) {
              WebViewUI.fN(this.mpI);
            }
            AppMethodBeat.o(208035);
          }
        });
        ax((View)localObject, 5894);
        if (!paramBoolean2) {
          break;
        }
        this.EcK.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(208036);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            WebViewUI.this.bQS();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208036);
          }
        });
        this.EcK.setVisibility(0);
        AppMethodBeat.o(80280);
        return;
        if (this.Eek != null) {
          this.Eek.setVisibility(8);
        }
      }
      this.EcK.setVisibility(8);
      AppMethodBeat.o(80280);
      return;
    }
    this.EcK.setVisibility(8);
    getWindow().clearFlags(1024);
    fM(getWindow().getDecorView());
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().show();
      if (this.Eej != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.Eej.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = eSG();
        this.Eej.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    if (this.EdA)
    {
      com.tencent.mm.ui.statusbar.a.I(this.Eej, false);
      AppMethodBeat.o(80280);
      return;
    }
    if (this.Eek != null) {
      this.Eek.setVisibility(0);
    }
    AppMethodBeat.o(80280);
  }
  
  protected void aN(Bundle paramBundle) {}
  
  protected void aO(Bundle paramBundle)
  {
    AppMethodBeat.i(80220);
    int i;
    if (paramBundle.getBoolean("set_navigation_bar_color_reset", false)) {
      if (this.EdY == null) {
        i = getResources().getColor(2131101161);
      }
    }
    for (int j = 255;; j = paramBundle.getInt("set_navigation_bar_color_alpha"))
    {
      setActionbarColor(i & 0xFFFFFF | j << 24);
      AppMethodBeat.o(80220);
      return;
      i = this.EdY.eTx();
      break;
      i = paramBundle.getInt("set_navigation_bar_color_color");
    }
  }
  
  public final void aT(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(80257);
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.sdk.h.b.abl()))
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
        i = e.Xp(paramInt);
      }
      setStatusBarColor(i);
    }
    AppMethodBeat.o(80257);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(80313);
    if (!com.tencent.mm.compatible.util.d.ly(21))
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
    if (eSI()) {
      localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
    for (;;)
    {
      addIconOptionMenu(paramInt1, getString(2131755815), localDrawable, paramOnMenuItemClickListener);
      AppMethodBeat.o(80313);
      return;
      if ((this.EdY != null) && (!this.EdY.EeI)) {
        localDrawable.setColorFilter(getResources().getColor(2131099732), PorterDuff.Mode.SRC_ATOP);
      } else {
        localDrawable.clearColorFilter();
      }
    }
  }
  
  public final void aw(View paramView, int paramInt)
  {
    AppMethodBeat.i(208105);
    com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h localh = this.Edo;
    Object localObject = paramView;
    if (paramView == null) {
      localObject = this.omW;
    }
    localh.aw((View)localObject, paramInt);
    AppMethodBeat.o(208105);
  }
  
  public final void b(com.tencent.mm.plugin.webview.ui.tools.video.b paramb)
  {
    AppMethodBeat.i(208107);
    this.Edo.b(paramb);
    AppMethodBeat.o(208107);
  }
  
  protected void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(80367);
    paramWebView = this.DIg;
    Intent localIntent = getIntent();
    String str2 = bQm();
    int i = localIntent.getIntExtra("geta8key_scene", 0);
    int j = localIntent.getIntExtra("bizEnterId", paramWebView.DVa);
    int k = localIntent.getIntExtra("webview_scene_type", 1);
    String str3 = localIntent.getStringExtra("webview_scene_note");
    String str1 = localIntent.getStringExtra("srcUsername");
    paramWebView = str1;
    if (bt.isNullOrNil(str1)) {
      paramWebView = localIntent.getStringExtra("geta8key_username");
    }
    str1 = localIntent.getStringExtra("KAppId");
    com.tencent.mm.plugin.report.service.g.yhR.f(18452, new Object[] { Integer.valueOf(j), Integer.valueOf(i), com.tencent.mm.pluginsdk.ui.tools.x.aNF(str2), com.tencent.mm.pluginsdk.ui.tools.x.aNF(paramString), Integer.valueOf(k), str3, str1, paramWebView });
    AppMethodBeat.o(80367);
  }
  
  protected final void b(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(80309);
    addIconOptionMenu(0, paramString, paramDrawable, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(208060);
        if (!this.EeA) {
          WebViewUI.this.bQS();
        }
        for (;;)
        {
          AppMethodBeat.o(208060);
          return true;
          WebViewUI.this.aIR(this.fNT);
        }
      }
    });
    AppMethodBeat.o(80309);
  }
  
  public final void bLY()
  {
    AppMethodBeat.i(80302);
    this.EdR.bLY();
    AppMethodBeat.o(80302);
  }
  
  protected MMWebView bQN()
  {
    AppMethodBeat.i(80260);
    MMWebView localMMWebView = MMWebView.a.kH(this);
    AppMethodBeat.o(80260);
    return localMMWebView;
  }
  
  protected boolean bQO()
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
  
  protected void bQP()
  {
    AppMethodBeat.i(80247);
    ad.i("MicroMsg.WebViewUI", "onCreate" + hashCode());
    this.DNO = new l(this);
    this.EdQ = new h(this);
    this.EdR = new i(this);
    this.EdY = new n(this);
    Object localObject1 = this.EdY;
    if (((n)localObject1).EeJ != null)
    {
      if (!((n)localObject1).eTr()) {
        break label1469;
      }
      ((n)localObject1).EeI = true;
    }
    for (;;)
    {
      ad.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleParams, webViewUI#%s, disableLightActionbarStyle:%b", new Object[] { ((n)localObject1).EeJ, Boolean.valueOf(((n)localObject1).EeI) });
      this.Eer = true;
      this.Edd = getIntent().getIntExtra("geta8key_session_id", (int)System.currentTimeMillis());
      this.Ede = getIntent().getByteArrayExtra("geta8key_cookie");
      com.tencent.mm.plugin.webview.j.j.h(bQm(), this);
      this.EcS = bQm();
      this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
      this.Edc = getIntent().getBooleanExtra("from_shortcut", false);
      this.EcY = getIntent().getIntExtra(e.m.IUR, -1);
      this.ulT = getIntent().getStringExtra("status_bar_style");
      this.ulS = getIntent().getIntExtra("customize_status_bar_color", 0);
      this.EdD = getIntent().getBooleanExtra("show_native_web_view", false);
      label294:
      boolean bool;
      if (getIntent() == null)
      {
        localObject1 = "";
        if (getIntent() != null) {
          break label1493;
        }
        bool = false;
        label303:
        ad.i("MicroMsg.WebViewUI", "initCustomActionBarColorIfNeed isNativeStyle is %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label1523;
        }
        if (!al.isDarkMode()) {
          break label1508;
        }
        localObject1 = "black";
        Xy(2131099650);
      }
      try
      {
        label345:
        i = Color.parseColor((String)localObject1);
        localObject1 = Integer.valueOf(i);
        label357:
        Object localObject3;
        if (localObject1 != null)
        {
          localObject3 = new Bundle(1);
          ((Bundle)localObject3).putInt("set_navigation_bar_color_color", ((Integer)localObject1).intValue());
          ((Bundle)localObject3).putInt("set_navigation_bar_color_alpha", 255);
          aO((Bundle)localObject3);
          if (!getIntent().hasExtra("customize_status_bar_color")) {
            this.ulS = ((Integer)localObject1).intValue();
          }
        }
        label424:
        this.EdD = getIntent().getBooleanExtra("show_native_web_view", false);
        this.EcR = getIntent().getBooleanExtra("key_trust_url", false);
        EdH += 1;
        ad.i("MicroMsg.WebViewUI", "initView trust:%b, rawUrl = %s ", new Object[] { Boolean.valueOf(this.EcR), bQm() });
        this.dHu = bt.nullAsNil(getIntent().getStringExtra("KPublisherId"));
        this.handler = new ap();
        if ((this.DIg != null) && (this.DIg.aB(getIntent().getBundleExtra("mm_report_bundle"))))
        {
          bool = true;
          label549:
          this.EcW = bool;
          localObject1 = getIntent().getBundleExtra("close_window_confirm_info");
          if (localObject1 != null) {
            this.Edv = a.aP((Bundle)localObject1);
          }
          getWindow().setFlags(16777216, 16777216);
          getWindow().setFormat(-3);
          this.EdR.eSe();
          w.a.hq(this);
          this.EdN.bL("onWebViewCreateStart", System.currentTimeMillis());
          if (!com.tencent.mm.plugin.webview.j.j.aJD(bQm())) {
            break label1547;
          }
          this.omW = MMWebView.a.kG(this);
          com.tencent.xweb.util.g.Fh(173L);
          if (this.omW == null) {
            this.omW = bQN();
          }
          label665:
          h.f(this.omW);
          this.EdN.bL("onWebViewCreateEnd", System.currentTimeMillis());
          this.omW.KSq = this;
          localObject1 = this.EdR;
          if (!(((i)localObject1).eRK() instanceof GameWebViewUI)) {
            break label1558;
          }
          ((i)localObject1).Ebi.add(Integer.valueOf(11));
          ((i)localObject1).Ebi.add(Integer.valueOf(28));
          label742:
          this.EdU = new com.tencent.mm.plugin.webview.c();
          initView();
          this.DIv = bRd();
          this.DIv.at(getIntent());
          if (this.DIg != this.DIv.DIg)
          {
            this.DIg = this.DIv.DIg;
            this.DIg.aB(getIntent().getBundleExtra("mm_report_bundle"));
          }
          localObject1 = this.DIg.eQx();
          i = this.DIv.bpm();
          localObject3 = this.dHu;
          ((ay.l)localObject1).dOE = i;
          ((ay.l)localObject1).DVi = ((String)localObject3);
          this.DzP = this.DIv.getJsapi();
          this.lvw = this.DIv.lvw;
          Edi.add(new e(this));
          if (Edi.size() > 1)
          {
            localObject1 = Edi;
            localObject1 = (e)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 2);
            if ((((e)localObject1).lVh != null) && (((e)localObject1).lVh.get() != null)) {
              ((WebViewUI)((e)localObject1).lVh.get()).uY(false);
            }
          }
          aas("onCreate");
          j = getIntent().getIntExtra("from_scence", 0);
          this.EcX = getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
          localObject1 = this.EdN;
          i = this.EcX;
          if (i == -1) {
            break label1609;
          }
          ((com.tencent.mm.plugin.webview.j.i)localObject1).EcX = i;
          ad.d("MicroMsg.WebViewUI", " onCreate fromScene %d", new Object[] { Integer.valueOf(j) });
          this.sessionId = com.tencent.mm.model.y.AH(String.valueOf(this.DIv.eNj()));
          ad.i("MicroMsg.WebViewUI", " onCreate sessionId %s", new Object[] { this.sessionId });
          localObject1 = this.DIg.eQD();
          i = this.DIv.bpm();
          localObject3 = this.dHu;
          ((ay.f)localObject1).dOE = i;
          ((ay.f)localObject1).DVi = ((String)localObject3);
          ((ay.f)localObject1).url = bQm();
          localObject3 = this.DIg.eQJ();
          localObject1 = bQm();
          ad.i("MicroMsg.WebviewReporter.DomainReporter", "setRawUrl, value = %s", new Object[] { localObject1 });
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
            label1202:
            this.Eej = getContentView();
            if (this.Eej != null)
            {
              eSE();
              ((ViewGroup)((ViewGroup)getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
              {
                public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
                {
                  AppMethodBeat.i(208075);
                  WebViewUI.this.eSE();
                  AppMethodBeat.o(208075);
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
              label1249:
              if (this.EdA) {
                if (eSH()) {
                  eSJ();
                }
              }
              for (;;)
              {
                this.EcN = new com.tencent.mm.bp.a(getContext(), this.Eel);
                com.tencent.mm.plugin.webview.a.a.af(new WebViewUI.43(this));
                this.EdT = new WebViewClipBoardHelper(this);
                this.Eec.alive();
                this.Edp.alive();
                if (this.EdY != null)
                {
                  localObject1 = this.EdY;
                  if (((n)localObject1).EeJ != null)
                  {
                    ((n)localObject1).mue = ((n)localObject1).EeJ.eNy();
                    ((n)localObject1).gZN = ((n)localObject1).EeJ.omW;
                    if (!((n)localObject1).EeI) {
                      break label1848;
                    }
                    ad.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle true");
                  }
                }
                ax(getWindow().getDecorView(), 256);
                com.tencent.mm.plugin.webview.model.ay.Cq(getIntent().getLongExtra("start_activity_time", 0L));
                this.Eea = getIntent().getBooleanExtra(e.m.IVa, false);
                if (((this.Eea) || (eSD())) && (this.omW != null)) {
                  this.omW.getSettings().setForceDarkBehavior(1);
                }
                AppMethodBeat.o(80247);
                return;
                label1469:
                ((n)localObject1).EeI = false;
                break;
                localObject1 = getIntent().getStringExtra("custom_action_bar_color");
                break label294;
                label1493:
                bool = getIntent().getBooleanExtra("open_custom_style_url", false);
                break label303;
                label1508:
                localObject1 = "white";
                Xy(-16777216);
                break label345;
                label1523:
                if (bt.isNullOrNil((String)localObject1)) {
                  break label424;
                }
                break label345;
                localException1 = localException1;
                Object localObject2 = null;
                break label357;
                bool = false;
                break label549;
                label1547:
                this.omW = bQN();
                break label665;
                label1558:
                localObject2.Ebi.add(Integer.valueOf(7));
                localObject2.Ebi.add(Integer.valueOf(11));
                localObject2.Ebi.add(Integer.valueOf(28));
                break label742;
                switch (j)
                {
                default: 
                  label1609:
                  i = 999;
                }
                for (;;)
                {
                  localObject2.EcX = i;
                  break;
                  i = 1;
                  continue;
                  i = 2;
                }
                localObject4 = ((Uri)localObject4).getHost();
                if ((localObject4 == null) || (((String)localObject4).toLowerCase().endsWith(".qq.com")))
                {
                  ad.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl, host is .qq.com, skip, host = %s", new Object[] { localObject4 });
                  break label1202;
                  localException4 = localException4;
                  ad.e("MicroMsg.WebviewReporter.DomainReporter", "parse rawUrl fail, rawUrl = %s", new Object[] { localObject2 });
                  break label1202;
                }
                localException4.rzM = true;
                break label1202;
                localException2 = localException2;
                ad.e("MicroMsg.WebViewUI", "fixContentMargin error : %s", new Object[] { localException2.getMessage() });
                break label1249;
                if (!com.tencent.mm.compatible.util.d.ly(21)) {
                  break label1831;
                }
                final ViewGroup localViewGroup = (ViewGroup)((ViewGroup)getWindow().getDecorView()).getChildAt(0);
                localViewGroup.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
                {
                  public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
                  {
                    AppMethodBeat.i(208076);
                    WebViewUI.this.a(localViewGroup, paramAnonymousWindowInsets);
                    WebViewUI.a(WebViewUI.this);
                    paramAnonymousView = paramAnonymousWindowInsets.consumeSystemWindowInsets();
                    AppMethodBeat.o(208076);
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
                label1831:
                ((ViewGroup)getWindow().getDecorView()).setFitsSystemWindows(true);
                continue;
                label1848:
                ad.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle false");
                localException3.eTs();
              }
            }
          }
        }
      }
    }
  }
  
  protected boolean bQR()
  {
    AppMethodBeat.i(80320);
    if (this.EcU)
    {
      AppMethodBeat.o(80320);
      return true;
    }
    if ((this.omW != null) && ((this.omW.canGoBack()) || (this.omW.canGoForward())) && (this.EcD != null))
    {
      Object localObject1 = this.EcD;
      boolean bool;
      if (((g)localObject1).Eas != null)
      {
        localObject1 = ((g)localObject1).Eas;
        if (localObject1 == null) {
          d.g.b.p.gfZ();
        }
        bool = ((Boolean)localObject1).booleanValue();
      }
      while (bool)
      {
        this.EcT = false;
        this.EcU = true;
        AppMethodBeat.o(80320);
        return true;
        Object localObject2 = ax.aQz("WebViewUIShowBottom");
        if (localObject2 == null) {
          d.g.b.p.gfZ();
        }
        if (((ax)localObject2).decodeInt("WebViewUIShowBottomNav", 0) == 1)
        {
          ((g)localObject1).Eas = Boolean.TRUE;
          localObject1 = ((g)localObject1).Eas;
          if (localObject1 == null) {
            d.g.b.p.gfZ();
          }
          bool = ((Boolean)localObject1).booleanValue();
        }
        else
        {
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qtE, 0) == 1) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label231;
            }
            ad.i(g.TAG, "needShowBottomNavigator not open");
            ((g)localObject1).Eas = Boolean.FALSE;
            localObject1 = ((g)localObject1).Eas;
            if (localObject1 == null) {
              d.g.b.p.gfZ();
            }
            bool = ((Boolean)localObject1).booleanValue();
            break;
          }
          label231:
          localObject2 = aj.getContext();
          d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
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
              localObject2 = aj.getContext();
              d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
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
                localObject2 = aj.getContext();
                d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
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
                  localObject2 = aj.getContext();
                  d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
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
            ((g)localObject1).Eas = Boolean.valueOf(bool);
            ad.i(g.TAG, "needShowBottomNavigator deviceShowBottomNav %b", new Object[] { ((g)localObject1).Eas });
            localObject2 = ((g)localObject1).Eas;
            if (localObject2 == null) {
              d.g.b.p.gfZ();
            }
            if (!((Boolean)localObject2).booleanValue()) {
              break label796;
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(18210, new Object[] { Integer.valueOf(1) });
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1160L, 0L, 1L, false);
          }
          for (;;)
          {
            localObject1 = ((g)localObject1).Eas;
            if (localObject1 == null) {
              d.g.b.p.gfZ();
            }
            bool = ((Boolean)localObject1).booleanValue();
            break;
            i = 0;
            break label261;
            label501:
            localObject2 = aj.getContext();
            d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
            bool = g.a.ee((Context)localObject2);
            ad.i(g.TAG, "miui hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
            break label267;
            label543:
            i = 0;
            break label301;
            label548:
            localObject2 = aj.getContext();
            d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
            bool = g.a.gV((Context)localObject2);
            ad.i(g.TAG, "huawei hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
            break label307;
            label590:
            i = 0;
            break label342;
            label595:
            localObject2 = aj.getContext();
            d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
            bool = g.a.gV((Context)localObject2);
            ad.i(g.TAG, "oppo hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
            break label348;
            label637:
            i = 0;
            break label382;
            label642:
            localObject2 = aj.getContext();
            d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
            if (Settings.Secure.getInt(((Context)localObject2).getContentResolver(), "navigation_gesture_mode", 0) == 1) {}
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label719;
              }
              com.tencent.mm.plugin.report.service.g.yhR.f(18210, new Object[] { Integer.valueOf(0) });
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1160L, 1L, 1L, false);
              bool = false;
              break;
            }
            label719:
            localObject2 = aj.getContext();
            d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
            if (!g.a.ee((Context)localObject2))
            {
              localObject2 = aj.getContext();
              d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
              if (!g.a.gV((Context)localObject2)) {
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
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1160L, 2L, 1L, false);
          }
        }
      }
    }
    AppMethodBeat.o(80320);
    return false;
  }
  
  public void bQS()
  {
    AppMethodBeat.i(80303);
    this.EdR.bQS();
    AppMethodBeat.o(80303);
  }
  
  protected void bQT()
  {
    AppMethodBeat.i(80341);
    this.EdR.bQT();
    AppMethodBeat.o(80341);
  }
  
  public boolean bQX()
  {
    return false;
  }
  
  public final String bQm()
  {
    AppMethodBeat.i(80300);
    try
    {
      String str = BaseWebViewController.aX(getIntent());
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
  
  protected com.tencent.mm.plugin.webview.core.h bRd()
  {
    AppMethodBeat.i(208112);
    Object localObject = this.omW;
    com.tencent.mm.plugin.webview.model.ay localay = this.DIg;
    BaseWebViewController.f localf = new BaseWebViewController.f(getIntent());
    boolean bool2 = getIntent().getBooleanExtra("key_trust_url", false);
    boolean bool3 = eTi();
    if ((!eTd()) && (!eTe())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject = new com.tencent.mm.plugin.webview.core.h((MMWebView)localObject, localay, new BaseWebViewController.c(localf, bool2, bool3, bool1, getIntent().getBooleanExtra("neverGetA8Key", false)));
      ((com.tencent.mm.plugin.webview.core.h)localObject).a(new c());
      ((com.tencent.mm.plugin.webview.core.h)localObject).init();
      AppMethodBeat.o(208112);
      return localObject;
    }
  }
  
  public boolean bRe()
  {
    return false;
  }
  
  protected void bRw()
  {
    AppMethodBeat.i(80246);
    if (this.EdA) {
      fixStatusbar(false);
    }
    AppMethodBeat.o(80246);
  }
  
  public void bRz()
  {
    AppMethodBeat.i(80226);
    this.Eed.eVF();
    int i = getIntent().getIntExtra(e.m.IUR, -1);
    getIntent().getIntExtra(e.m.IUM, 0);
    int j = getIntent().getIntExtra(e.m.IUN, -1);
    int k = getIntent().getIntExtra(e.m.IUO, -1);
    this.Eed.a(j, k, i, 0, bQm(), getTitle().toString());
    AppMethodBeat.o(80226);
  }
  
  public final int bpm()
  {
    AppMethodBeat.i(80335);
    int i = this.DIv.bpm();
    AppMethodBeat.o(80335);
    return i;
  }
  
  public void bzn()
  {
    int k = 2;
    int m = 1;
    AppMethodBeat.i(80295);
    if ((this.EdJ) || (this.EdI) || (isFinishing()))
    {
      ad.e("MicroMsg.WebViewUI", "edw postBinded finished");
      AppMethodBeat.o(80295);
      return;
    }
    Object localObject1 = eSV();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.webview.c.g)localObject1).DNk = this.DIv.getJsapi();
    }
    this.lvv = this.DIv.eNh();
    try
    {
      this.lvv.a(this.DNO, this.DIv.eNj());
      ad.i("MicroMsg.WebViewUI", "edw postBinded");
      this.EdZ = new com.tencent.mm.plugin.webview.ui.tools.floatball.a(new com.tencent.mm.plugin.ball.a.e(this), this);
      localObject1 = getIntent().getStringExtra("float_ball_key");
      if (!bt.isNullOrNil((String)localObject1))
      {
        this.EdZ.ac(2, (String)localObject1);
        this.EdZ.Wm(bQm());
        this.EdZ.eA("rawUrl", bQm());
        this.EdZ.aGX(bQm());
        if (this.EdZ != null) {
          this.EdZ.bgB();
        }
        if (this.EdX == null) {
          break label1001;
        }
        i = 1;
        if (this.EdX == null) {
          this.EdX = new HandOffURL(bQm(), bQm(), "");
        }
        localObject1 = this.EdZ.getName();
        if (!bt.isNullOrNil((String)localObject1)) {
          this.EdX.setTitle((String)localObject1);
        }
        if (ePk())
        {
          if (i == 0) {
            break label1006;
          }
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.EdX);
        }
        localObject1 = eSv();
        localObject2 = this.lvv;
      }
    }
    catch (RemoteException localException3)
    {
      try
      {
        str = ((com.tencent.mm.plugin.webview.stub.e)localObject2).aIv("DNSAdvanceOpen");
        ad.i("MicroMsg.DNSPreGetOptimize", "switch open value : %s", new Object[] { str });
        if (bt.isNullOrNil(str))
        {
          ad.e("MicroMsg.DNSPreGetOptimize", "get switch value is null or nil");
          bool = false;
          if (bool) {
            break label1083;
          }
          ad.i("MicroMsg.DNSPreGetOptimize", "server closed the switch");
          if (eSW()) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(208058);
                if (WebViewUI.this.omW != null) {
                  WebViewUI.this.omW.getCurWebviewClient().b(WebViewUI.this.omW, WebViewUI.this.omW.getUrl());
                }
                AppMethodBeat.o(208058);
              }
            });
          }
          localObject1 = this.DIv.getTitle();
          aIO((String)localObject1);
          aIP((String)localObject1);
        }
      }
      catch (Exception localException3)
      {
        try
        {
          i = bt.getInt(this.lvv.aIv("WebviewDisableX5Logo"), 0);
          bool = getIntent().getBooleanExtra("disable_bounce_scroll", false);
          ad.i("MicroMsg.WebViewUI", "getting flag of x5 logo state, disableX5Logo = %d, disableBounceScroll = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
          if ((i == 1) || (bool)) {
            this.Een.ve(true);
          }
          if (getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_disable_over_scroll", false)) {
            this.Een.ve(true);
          }
          this.EdN.bL("onJSAPIEnd", System.currentTimeMillis());
          if ((this.omW != null) && (this.omW.getIsX5Kernel()))
          {
            bool = true;
            com.tencent.mm.plugin.webview.model.ay.aI(bool, bt.nullAsNil(bQm()).startsWith("https://"));
          }
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              j = bt.getInt(this.lvv.aIv("XwebBatchTranslateMaxByteLength"), 0);
              i = bt.getInt(this.lvv.aIv("XwebBatchTranslateMaxCnt"), 0);
              ad.i("MicroMsg.WebViewUI", "getting flag of XwebBatchTranslate para BatchTranslateMaxByteLength  = " + j + " BatchTranslateCnt = " + i);
              localObject1 = this.EdU;
              ((com.tencent.mm.plugin.webview.c)localObject1).DFM = j;
              ((com.tencent.mm.plugin.webview.c)localObject1).DFN = i;
              if (getIntent().getBooleanExtra("translate_webview", false))
              {
                localObject1 = this.EdU;
                localObject2 = this.omW;
                str = bQm();
                if ((localObject2 != null) && (!((WebView)localObject2).isSysKernel())) {
                  break;
                }
              }
              if (!getIntent().getBooleanExtra("forceHideShare", false)) {
                break label1379;
              }
              vg(false);
              ad.d("MicroMsg.WebViewUI", "[hakon] postBinded :%d: force hide", new Object[] { Long.valueOf(System.currentTimeMillis()) });
              this.EcG = LayoutInflater.from(this).inflate(2131496073, null);
              localObject1 = (FontChooserView)this.EcG.findViewById(2131300194);
              localObject2 = this.EcG.findViewById(2131300193);
              if ((this.omW == null) || (!this.omW.getIsX5Kernel())) {
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
                    AppMethodBeat.i(80091);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                    paramAnonymousView = AnimationUtils.loadAnimation(WebViewUI.this, 2130772060);
                    paramAnonymousView.setAnimationListener(new Animation.AnimationListener()
                    {
                      public final void onAnimationEnd(Animation paramAnonymous2Animation)
                      {
                        AppMethodBeat.i(208069);
                        WebViewUI.this.EcG.setVisibility(8);
                        AppMethodBeat.o(208069);
                      }
                      
                      public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                      
                      public final void onAnimationStart(Animation paramAnonymous2Animation) {}
                    });
                    WebViewUI.this.EcG.startAnimation(paramAnonymousView);
                    WebViewUI.this.EcG.setVisibility(8);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(80091);
                  }
                });
              }
              ((FontChooserView)localObject1).setOnChangeListener(new d((byte)0));
              localObject2 = new FrameLayout.LayoutParams(-1, -2, 80);
              this.EcG.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              this.EcI.addView(this.EcG);
              this.EcG.setVisibility(8);
              try
              {
                if (!this.lvv.eRt()) {
                  break label1484;
                }
                if ((!eTd()) && (!eTe())) {
                  break label1436;
                }
                i = com.tencent.mm.plugin.webview.j.f.hd(getContext());
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
              this.DIv.Wu(j);
              WI(j);
              AppMethodBeat.o(80295);
              return;
              localRemoteException = localRemoteException;
              ad.printErrStackTrace("MicroMsg.WebViewUI", localRemoteException, "addCallbacker", new Object[0]);
              continue;
              this.EdZ.ac(2, com.tencent.mm.plugin.ball.f.b.Wp(bQm()));
              continue;
              label1001:
              i = 0;
              continue;
              label1006:
              ad.i("MicroMsg.WebViewUI", "[Handoff] call onWebViewCreate " + this.EdX.toString());
              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).a(this.EdX);
              continue;
              bool = str.equalsIgnoreCase("1");
              continue;
              localException1 = localException1;
              ad.e("MicroMsg.DNSPreGetOptimize", "get dns pre get switch failed");
              continue;
              try
              {
                label1083:
                localObject2 = ((com.tencent.mm.plugin.webview.stub.e)localObject2).aIv("DNSAdvanceRelateDomain");
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
              com.tencent.mm.plugin.webview.a.a.af(new b.1(localException2, (String)localObject2));
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
              localBundle.putString("destLanguage", com.tencent.mm.sdk.platformtools.ac.fks());
              localBundle.putString("url", str);
              localBundle.putString("translateTips", getString(2131766130));
              localBundle.putString("translateFinish", getString(2131766127));
              localBundle.putString("errorWording", getString(2131766126));
              localException4.DFK = getString(2131766130);
              localException4.DFL = getString(2131766131);
              com.tencent.mm.sdk.b.a.IbL.c(localException4.DFP);
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
              vg(bool);
              ad.d("MicroMsg.WebViewUI", "[cpan] postBinded :%d: show:%b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(bool) });
              continue;
              label1431:
              i = 0;
              continue;
              label1436:
              i = com.tencent.mm.plugin.webview.j.f.a(getContext(), this.lvv, bQm());
            }
          }
        }
      }
    }
  }
  
  protected int bzo()
  {
    AppMethodBeat.i(80254);
    int i = getActionbarColor();
    AppMethodBeat.o(80254);
    return i;
  }
  
  protected boolean bzp()
  {
    return false;
  }
  
  public final void c(com.tencent.luggage.xweb_ext.extendplugin.a.a parama)
  {
    AppMethodBeat.i(208108);
    this.Edo.c(parama);
    AppMethodBeat.o(208108);
  }
  
  public boolean convertActivityFromTranslucent()
  {
    AppMethodBeat.i(80236);
    boolean bool = getIntent().getBooleanExtra("convertActivityFromTranslucent", true);
    AppMethodBeat.o(80236);
    return bool;
  }
  
  public final void d(com.tencent.luggage.xweb_ext.extendplugin.a.a parama)
  {
    AppMethodBeat.i(208109);
    this.Edo.d(parama);
    AppMethodBeat.o(208109);
  }
  
  public final String dWD()
  {
    return this.DIv.DGb;
  }
  
  public final void eIf()
  {
    AppMethodBeat.i(208120);
    if (this.EcH != null)
    {
      hideVKB();
      this.EcH.GV(-2);
    }
    AppMethodBeat.o(208120);
  }
  
  protected final boolean eNF()
  {
    AppMethodBeat.i(80308);
    boolean bool = this.DIv.eNF();
    AppMethodBeat.o(80308);
    return bool;
  }
  
  public final int eNj()
  {
    AppMethodBeat.i(221645);
    int i = this.DIv.eNj();
    AppMethodBeat.o(221645);
    return i;
  }
  
  public final String eNy()
  {
    AppMethodBeat.i(221646);
    String str = this.DIv.getCurrentUrl();
    AppMethodBeat.o(221646);
    return str;
  }
  
  public final com.tencent.mm.plugin.webview.c.b.a eOz()
  {
    AppMethodBeat.i(208124);
    if (this.DzP != null)
    {
      locala = this.DzP.eOz();
      AppMethodBeat.o(208124);
      return locala;
    }
    com.tencent.mm.plugin.webview.c.b.a locala = new com.tencent.mm.plugin.webview.c.b.a();
    AppMethodBeat.o(208124);
    return locala;
  }
  
  public final boolean ePd()
  {
    AppMethodBeat.i(80354);
    if ((this.Edv != null) && (this.Edv.ePK()) && (!bt.isNullOrNil(this.Edv.eTq())) && (!bt.isNullOrNil(this.Edv.ePM())) && (!bt.isNullOrNil(this.Edv.ePN())))
    {
      Object localObject = this.Edv.eTq();
      String str1 = this.Edv.ePM();
      String str2 = this.Edv.ePN();
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
      this.Edw = com.tencent.mm.ui.base.h.a(getContext(), true, "", localView, str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(208070);
          if ((localCheckBox != null) && (localCheckBox.isChecked())) {}
          try
          {
            if (WebViewUI.this.lvv.eRt()) {
              WebViewUI.this.lvv.jb(327792, 1);
            }
            WebViewUI.this.EdI = true;
            WebViewUI.this.Edw = null;
            k.EbJ.close();
            if ((WebViewUI.v(WebViewUI.this) != null) && (WebViewUI.v(WebViewUI.this).sv(1)))
            {
              AppMethodBeat.o(208070);
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
            AppMethodBeat.o(208070);
          }
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          WebViewUI.this.Edw = null;
        }
      });
      AppMethodBeat.o(80354);
      return true;
    }
    AppMethodBeat.o(80354);
    return false;
  }
  
  public final boolean ePk()
  {
    AppMethodBeat.i(80364);
    boolean bool1 = getIntent().getBooleanExtra("forceHideShare", false);
    boolean bool2 = getIntent().getBooleanExtra("showShare", true);
    boolean bool3 = getIntent().getBooleanExtra("KRightBtn", false);
    ad.i("MicroMsg.WebViewUI", "forceHideShare:%b showShareBtn:%b enableMinimize:%b, banRightBtn %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bQO()), Boolean.valueOf(bool3) });
    if ((!bool3) && (!bool1) && (bool2) && (bQO()))
    {
      AppMethodBeat.o(80364);
      return true;
    }
    AppMethodBeat.o(80364);
    return false;
  }
  
  protected void eRV()
  {
    AppMethodBeat.i(80278);
    int i = getIntent().getIntExtra("webview_bg_color_rsID", -1);
    if ((i != -1) && (getContentView() != null))
    {
      setBackGroundColorResource(i);
      getContentView().setBackgroundResource(i);
      this.omW.setBackgroundResource(17170445);
      this.EcH.setBackgroundResource(17170445);
      this.EcI.setBackgroundResource(17170445);
      AppMethodBeat.o(80278);
      return;
    }
    if (getIntent().getBooleanExtra(e.m.IVa, false))
    {
      this.omW.setBackgroundColor(getResources().getColor(2131099828));
      AppMethodBeat.o(80278);
      return;
    }
    this.omW.setBackgroundColor(getResources().getColor(2131101179));
    AppMethodBeat.o(80278);
  }
  
  public final void eRl()
  {
    AppMethodBeat.i(80228);
    if (this.Eed != null)
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n localn = this.Eed;
      localn.hide();
      localn.Ere.setText((CharSequence)"");
    }
    AppMethodBeat.o(80228);
  }
  
  protected final void eSA()
  {
    AppMethodBeat.i(80225);
    if (this.Eed != null)
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n localn = this.Eed;
      if (localn.getSayFooter() != null)
      {
        localObject = localn.getSayFooter();
        if (((MPSmileyFooter)localObject).pWJ != null)
        {
          ((MPSmileyFooter)localObject).pWJ.fbE();
          ((MPSmileyFooter)localObject).pWJ.destroy();
        }
      }
      Object localObject = com.tencent.mm.plugin.webview.ui.tools.widget.p.Esp;
      com.tencent.mm.plugin.webview.ui.tools.widget.p.b(localn.Erv.fNb);
    }
    AppMethodBeat.o(80225);
  }
  
  public final com.tencent.mm.ui.base.p eSB()
  {
    return this.fNb;
  }
  
  public final boolean eSC()
  {
    AppMethodBeat.i(208104);
    boolean bool = this.Edo.eSC();
    AppMethodBeat.o(208104);
    return bool;
  }
  
  protected final void eSE()
  {
    AppMethodBeat.i(80251);
    if ((this.Eej == null) || (eSF()))
    {
      AppMethodBeat.o(80251);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.Eej.getLayoutParams();
    int i = eSG();
    if (i != localMarginLayoutParams.topMargin)
    {
      localMarginLayoutParams.topMargin = i;
      this.Eej.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(80251);
  }
  
  protected boolean eSH()
  {
    return true;
  }
  
  final boolean eSI()
  {
    AppMethodBeat.i(80255);
    if ((!bt.isNullOrNil(this.ulT)) && (this.ulT.equals("black")))
    {
      AppMethodBeat.o(80255);
      return true;
    }
    AppMethodBeat.o(80255);
    return false;
  }
  
  protected final void eSJ()
  {
    AppMethodBeat.i(80256);
    if ((com.tencent.mm.compatible.util.d.ly(21)) && (this.ulS != 0))
    {
      setActionbarColor(this.ulS);
      AppMethodBeat.o(80256);
      return;
    }
    setStatusBarColor(bzo());
    AppMethodBeat.o(80256);
  }
  
  public final String eSK()
  {
    return this.DIv.DFY;
  }
  
  public final String eSL()
  {
    return this.DIv.DHC;
  }
  
  public final void eSN()
  {
    AppMethodBeat.i(80272);
    try
    {
      this.Een.release();
      this.omW.stopLoading();
      this.omW.removeAllViews();
      this.omW.clearView();
      if (this.DzP != null) {
        this.DzP.detach();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        this.omW.destroy();
        this.omW = null;
        finish();
        ad.fku();
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI", "forceQuit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)locala.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI", "forceQuit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
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
  
  protected void eSO()
  {
    AppMethodBeat.i(80275);
    this.EcV = System.currentTimeMillis();
    this.omW.goBack();
    k localk = k.EbJ;
    ad.v("MicroMsg.WebViewReportUtil", "goBack traceid %s", new Object[] { localk.zuO });
    if (!bt.isNullOrNil(localk.zuO)) {
      localk.ma(5);
    }
    AppMethodBeat.o(80275);
  }
  
  protected int eSP()
  {
    AppMethodBeat.i(80277);
    if (this.EcO == null)
    {
      AppMethodBeat.o(80277);
      return 0;
    }
    int i = this.EcO.eVM();
    AppMethodBeat.o(80277);
    return i;
  }
  
  protected void eSQ()
  {
    AppMethodBeat.i(80279);
    if (getIntent() == null)
    {
      AppMethodBeat.o(80279);
      return;
    }
    if (getIntent().hasExtra("show_full_screen")) {
      aJ(getIntent().getBooleanExtra("show_full_screen", false), true);
    }
    AppMethodBeat.o(80279);
  }
  
  protected com.tencent.xweb.x eSR()
  {
    try
    {
      AppMethodBeat.i(80286);
      if (this.Edl == null) {
        this.Edl = new MMWebView.b(new b());
      }
      com.tencent.xweb.x localx = this.Edl;
      AppMethodBeat.o(80286);
      return localx;
    }
    finally {}
  }
  
  protected int eSS()
  {
    AppMethodBeat.i(80287);
    if (this.EdD)
    {
      AppMethodBeat.o(80287);
      return 2131689490;
    }
    AppMethodBeat.o(80287);
    return 2131689492;
  }
  
  protected boolean eST()
  {
    return true;
  }
  
  public final void eSU()
  {
    AppMethodBeat.i(175800);
    View localView = this.omW.getView();
    localView.scrollTo(localView.getScrollX(), 0);
    this.DIg.eQF().D(new Object[] { bQm(), Integer.valueOf(7) }).report();
    AppMethodBeat.o(175800);
  }
  
  protected com.tencent.mm.plugin.webview.c.g eSV()
  {
    return null;
  }
  
  protected boolean eSW()
  {
    return false;
  }
  
  protected final void eSX()
  {
    AppMethodBeat.i(80304);
    if (this.Edo.bmN()) {
      this.Edo.eVk();
    }
    if (this.DIv != null) {
      this.DIv.reload();
    }
    AppMethodBeat.o(80304);
  }
  
  protected final void eSY()
  {
    AppMethodBeat.i(208119);
    if (this.DIv != null) {
      if (com.tencent.mm.plugin.webview.c.j.eOR()) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.webview.c.j.va(bool);
      this.DIv.reload();
      AppMethodBeat.o(208119);
      return;
    }
  }
  
  protected final LinkedList<d.a> eSZ()
  {
    AppMethodBeat.i(80307);
    if (this.omW == null)
    {
      ad.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
      AppMethodBeat.o(80307);
      return null;
    }
    Object localObject = bQm();
    if (this.omW != null)
    {
      String str = this.omW.getUrl();
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
              if (this.EdE == null)
              {
                l = System.currentTimeMillis();
                this.EdE = this.lvv.eRy();
                if (this.EdE == null) {
                  break label281;
                }
              }
              label281:
              for (bool = true;; bool = false)
              {
                ad.d("MicroMsg.WebViewUI", "[hakon] getConfigListMap %b, cost %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
                if ((this.EdE == null) || (this.EdE.size() <= 0)) {
                  break;
                }
                localObject = com.tencent.mm.n.d.j(this.EdE);
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
  
  public final void eSi()
  {
    AppMethodBeat.i(80305);
    this.EdR.eSi();
    AppMethodBeat.o(80305);
  }
  
  public final int eSm()
  {
    AppMethodBeat.i(208127);
    int i = this.EdR.eSm();
    AppMethodBeat.o(208127);
    return i;
  }
  
  protected final boolean eSs()
  {
    return this.DIv.DGP;
  }
  
  protected final Map<String, String> eSt()
  {
    return this.DIv.DGi;
  }
  
  public final com.tencent.mm.plugin.webview.j.i eSu()
  {
    return this.EdN;
  }
  
  public final com.tencent.mm.plugin.webview.ui.tools.floatball.a eSw()
  {
    return this.EdZ;
  }
  
  protected final ar eSx()
  {
    return this.DIv.DHz;
  }
  
  protected final com.tencent.mm.plugin.webview.ui.tools.widget.n eSy()
  {
    AppMethodBeat.i(80223);
    if (this.Eed == null)
    {
      this.Eed = new com.tencent.mm.plugin.webview.ui.tools.widget.n(this, new t(getContext(), 2131820847));
      this.Eed.setVisibility(8);
      localObject = (ViewParent)getWindow().getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        ((ViewGroup)localObject).addView(this.Eed, new FrameLayout.LayoutParams(-1, -1));
        bRz();
      }
    }
    Object localObject = this.Eed;
    AppMethodBeat.o(80223);
    return localObject;
  }
  
  public final MPVideoPlayFullScreenView eSz()
  {
    AppMethodBeat.i(80224);
    if (this.Eef == null)
    {
      this.Eef = new MPVideoPlayFullScreenView(this, null);
      this.Eef.setVisibility(8);
      localObject = (ViewParent)getWindow().getDecorView();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).addView(this.Eef, new FrameLayout.LayoutParams(-1, -1));
      }
    }
    Object localObject = this.Eef;
    AppMethodBeat.o(80224);
    return localObject;
  }
  
  protected final int eTa()
  {
    AppMethodBeat.i(80314);
    int i = 2131690603;
    if (eSZ() != null) {
      i = 2131690809;
    }
    AppMethodBeat.o(80314);
    return i;
  }
  
  protected final void eTc()
  {
    AppMethodBeat.i(80344);
    this.Edx.setVisibility(0);
    AppMethodBeat.o(80344);
  }
  
  protected boolean eTd()
  {
    return false;
  }
  
  protected boolean eTe()
  {
    return false;
  }
  
  public void eTg()
  {
    AppMethodBeat.i(80356);
    if (eTf())
    {
      AppMethodBeat.o(80356);
      return;
    }
    eTh();
    if (!ePd())
    {
      this.EdI = true;
      k.EbJ.close();
      if ((this.EdZ != null) && (this.EdZ.sv(1)))
      {
        AppMethodBeat.o(80356);
        return;
      }
      finish();
    }
    AppMethodBeat.o(80356);
  }
  
  protected boolean eTi()
  {
    return true;
  }
  
  protected final boolean eTj()
  {
    AppMethodBeat.i(80360);
    if (this.Eex != -3)
    {
      showVKB();
      AppMethodBeat.o(80360);
      return true;
    }
    AppMethodBeat.o(80360);
    return false;
  }
  
  protected final void eTk()
  {
    AppMethodBeat.i(208126);
    if ((this.EdI) || (this.EdJ) || (isFinishing()))
    {
      AppMethodBeat.o(208126);
      return;
    }
    if (this.DIv != null)
    {
      com.tencent.mm.plugin.webview.core.h localh = this.DIv;
      localh.k(localh.bQm(), true, 8);
    }
    if (this.Edx != null) {
      this.Edx.setVisibility(8);
    }
    this.DIg.eQF().D(new Object[] { bQm(), Integer.valueOf(4) }).report();
    AppMethodBeat.o(208126);
  }
  
  public final MMWebView eTl()
  {
    return this.omW;
  }
  
  protected void fQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(80276);
    if (this.EcO == null)
    {
      AppMethodBeat.o(80276);
      return;
    }
    WebViewInputFooter localWebViewInputFooter = this.EcO;
    localWebViewInputFooter.setVisibility(0);
    if (localWebViewInputFooter.EsK != null) {
      localWebViewInputFooter.EsK.setVisibility(0);
    }
    if (localWebViewInputFooter.EsJ != null)
    {
      localWebViewInputFooter.EsJ.setEnabled(true);
      localWebViewInputFooter.EsJ.setBackgroundResource(2131232723);
    }
    if (localWebViewInputFooter.EsG != null) {
      localWebViewInputFooter.EsG.setVisibility(0);
    }
    localWebViewInputFooter.EsL = false;
    if (localWebViewInputFooter.EsJ != null)
    {
      localWebViewInputFooter.EsJ.setFocusable(true);
      localWebViewInputFooter.EsJ.setFocusableInTouchMode(true);
      localWebViewInputFooter.EsJ.requestFocus();
    }
    if (localWebViewInputFooter.fLP != null) {
      localWebViewInputFooter.fLP.showVKB();
    }
    localWebViewInputFooter.state = 0;
    if (!bt.isNullOrNil(paramString)) {
      this.EcO.setText(paramString);
    }
    if (paramInt >= 0) {
      this.EcO.setMaxCount(paramInt);
    }
    AppMethodBeat.o(80276);
  }
  
  public void finish()
  {
    AppMethodBeat.i(80235);
    if (this.EcZ) {
      setResult(-1);
    }
    if (this.handler != null) {
      this.handler.removeCallbacksAndMessages(null);
    }
    this.EdJ = true;
    if (this.DIv != null)
    {
      com.tencent.mm.plugin.webview.core.h localh = this.DIv;
      localh.eNr();
      localh.DGe = true;
    }
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.d.c.class) != null) {
      ((com.tencent.mm.plugin.appbrand.d.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.d.c.class)).bdF();
    }
    super.finish();
    AppMethodBeat.o(80235);
  }
  
  protected final int getActionBarHeight()
  {
    AppMethodBeat.i(80250);
    if (getResources().getDimensionPixelSize(2131167019) > com.tencent.mm.cc.a.fromDPToPix(this, 48))
    {
      i = getResources().getDimensionPixelSize(2131167019);
      AppMethodBeat.o(80250);
      return i;
    }
    if (com.tencent.mm.compatible.util.i.iK(this))
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
    AppMethodBeat.i(208115);
    if (this.Edo.bmN())
    {
      i = getRequestedOrientation();
      AppMethodBeat.o(208115);
      return i;
    }
    int i = this.screenOrientation;
    AppMethodBeat.o(208115);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131496078;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(208114);
    String str = this.DIv.omW.getSettings().getUserAgentString();
    AppMethodBeat.o(208114);
    return str;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    if (this.DIv != null) {
      return this.DIv.DIf;
    }
    return null;
  }
  
  protected void goBack()
  {
    AppMethodBeat.i(208110);
    if (this.omW == null)
    {
      AppMethodBeat.o(208110);
      return;
    }
    if (this.Edz)
    {
      AppMethodBeat.o(208110);
      return;
    }
    if (this.omW.canGoBack())
    {
      eSO();
      AppMethodBeat.o(208110);
      return;
    }
    k.EbJ.close();
    finish();
    AppMethodBeat.o(208110);
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(80361);
    super.hideVKB();
    this.Eex = -2;
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
    if (!this.EdA)
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
      this.EdB = true;
      AppMethodBeat.o(80222);
      return;
      localb.addView(localView1);
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(80284);
    this.EcH = ((WebViewKeyboardLinearLayout)findViewById(2131306921));
    this.EcI = ((FrameLayout)findViewById(2131304241));
    this.Edb = getIntent().getBooleanExtra("finishviewifloadfailed", false);
    this.Eda = getIntent().getBooleanExtra("is_favorite_item", false);
    this.yyS = getIntent().getBooleanExtra("isWebwx", true);
    boolean bool = getIntent().getBooleanExtra("show_feedback", false);
    this.Edy = bt.nullAsNil(getIntent().getStringExtra("sentUsername"));
    if (bool) {
      addTextOptionMenu(1, getString(2131763230), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(208037);
          try
          {
            paramAnonymousMenuItem = WebViewUI.this.lvv.aIA(null);
            WebViewUI.this.loadUrl(paramAnonymousMenuItem);
            AppMethodBeat.o(208037);
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
    this.EcB = ((ProgressBar)findViewById(2131298857));
    this.Edx = findViewById(2131303929);
    this.Edx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80048);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WebViewUI.this.eTk();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(80048);
      }
    });
    if (this.yyS)
    {
      localObject1 = bt.nullAsNil(getIntent().getStringExtra("title"));
      if (((CharSequence)localObject1).length() > 0) {
        this.Ecy = true;
      }
      this.Ecz = getIntent().getBooleanExtra("key_show_web_page_title", false);
      setMMTitle((CharSequence)localObject1);
    }
    for (;;)
    {
      this.Eav = findViewById(2131306901);
      if (this.Eav != null)
      {
        this.EcD = new g(this.Eav, this.EcH, this.omW);
        this.Eav.setVisibility(8);
        this.EcE = ((ImageButton)findViewById(2131306897));
        this.EcE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(208067);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if ((WebViewUI.this.omW != null) && (WebViewUI.this.omW.canGoBack())) {
              WebViewUI.this.eSO();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208067);
          }
        });
        this.EcF = ((ImageButton)findViewById(2131306900));
        this.EcF.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(208068);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if ((WebViewUI.this.omW != null) && (WebViewUI.this.omW.canGoForward())) {
              WebViewUI.this.omW.goForward();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208068);
          }
        });
      }
      if (this.omW != null) {
        break;
      }
      ad.i("MicroMsg.WebViewUI", "initView viewWV is null");
      finish();
      AppMethodBeat.o(80284);
      return;
      setMMTitle("");
    }
    if (Edn == WebSettings.RenderPriority.NORMAL)
    {
      ad.i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
      this.omW.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
      Edn = WebSettings.RenderPriority.HIGH;
    }
    Object localObject3 = this.Een;
    Object localObject1 = getContentView();
    ((j)localObject3).Ebu = ((LogoWebViewWrapper)((View)localObject1).findViewById(2131301589));
    ((j)localObject3).Ebt = ((ImageView)((View)localObject1).findViewById(2131306923));
    ((j)localObject3).EbC = ((View)localObject1).findViewById(2131306922);
    if (((j)localObject3).EbC != null)
    {
      ((j)localObject3).EbD = ((j)localObject3).EbC.findViewById(2131307117);
      ((j)localObject3).EbE = ((TextView)((j)localObject3).EbD.findViewById(2131307119));
    }
    ((j)localObject3).Ebv = BackwardSupportUtil.b.g(((j)localObject3).Ebu.getContext(), 72.0F);
    Object localObject2;
    if (((j)localObject3).Ebt == null)
    {
      localObject1 = "null";
      if (((j)localObject3).Ebu != null) {
        break label1212;
      }
      localObject2 = "null";
      label548:
      ad.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage.id = %s, logoWrapper.id = %s", new Object[] { localObject1, localObject2 });
      ad.d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", new Object[] { Integer.valueOf(((j)localObject3).Ebv) });
      localObject1 = this.Een;
      localObject2 = this.omW;
      ((MMWebView)localObject2).setCompetitorView(((j)localObject1).Ebu);
      ((MMWebView)localObject2).fLA();
      if (Build.VERSION.SDK_INT <= 10) {
        ((j)localObject1).Ebu.getWebViewContainer().setBackgroundColor(((j)localObject1).Ebu.getResources().getColor(2131101165));
      }
      localObject3 = ((j)localObject1).Ebu;
      ((LogoWebViewWrapper)localObject3).getWebViewContainer();
      if (((LogoWebViewWrapper)localObject3).DYP != null)
      {
        ((LogoWebViewWrapper)localObject3).fQx = ((WebView)localObject2);
        ((LogoWebViewWrapper)localObject3).DYP.addView(((LogoWebViewWrapper)localObject3).fQx);
      }
      if ((!((MMWebView)localObject2).isXWalkKernel()) && (!((MMWebView)localObject2).getIsX5Kernel())) {
        break label1227;
      }
      ((j)localObject1).EbF = true;
      label704:
      if ((((j)localObject1).EbD != null) && (!((MMWebView)localObject2).getIsX5Kernel()))
      {
        ((ImageView)((j)localObject1).EbD.findViewById(2131307118)).setVisibility(8);
        ((TextView)((j)localObject1).EbD.findViewById(2131301014)).setText("");
      }
      if ((!((j)localObject1).EbF) || (((j)localObject1).EbG)) {
        break label1235;
      }
      ((j)localObject1).ve(false);
      ((j)localObject1).eSq();
    }
    for (;;)
    {
      eRV();
      this.EcJ = ((FrameLayout)findViewById(2131298736));
      ad.i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.omW.getIsX5Kernel());
      this.omW.setWebViewClientExtension(new b(this));
      if (this.omW.getIsX5Kernel())
      {
        this.omW.setWebViewCallbackClient(this.Eeb);
        localObject1 = this.Een;
        localObject2 = new LogoWebViewWrapper.a()
        {
          public final void eRM()
          {
            AppMethodBeat.i(208038);
            if (WebViewUI.this.omW.getIsX5Kernel()) {
              WebViewUI.this.DIg.eQF().D(new Object[] { WebViewUI.this.bQm(), Integer.valueOf(10) }).report();
            }
            AppMethodBeat.o(208038);
          }
        };
        if (((j)localObject1).Ebu != null) {
          ((j)localObject1).Ebu.setMMOverScrollListener((LogoWebViewWrapper.a)localObject2);
        }
      }
      this.EcO = ((WebViewInputFooter)findViewById(2131306916));
      if (this.EcO != null)
      {
        this.EcO.hide();
        this.EcO.setOnTextSendListener(new WebViewInputFooter.c()
        {
          public final void aGV(String paramAnonymousString)
          {
            AppMethodBeat.i(208039);
            WebViewUI.a(WebViewUI.this, paramAnonymousString);
            AppMethodBeat.o(208039);
          }
        });
        this.EcO.setOnSmileyChosenListener(new WebViewInputFooter.a()
        {
          public final boolean Vr(String paramAnonymousString)
          {
            AppMethodBeat.i(208040);
            com.tencent.mm.plugin.webview.c.f localf;
            if (WebViewUI.this.DzP != null)
            {
              localf = WebViewUI.this.DzP;
              if (localf.BHY) {
                break label44;
              }
              ad.e("MicroMsg.JsApiHandler", "not ready");
            }
            for (;;)
            {
              AppMethodBeat.o(208040);
              return true;
              label44:
              HashMap localHashMap = new HashMap();
              localHashMap.put("smiley", paramAnonymousString);
              aq.f(new f.25(localf, l.a.b("onGetSmiley", localHashMap, localf.DMD, localf.vJP)));
            }
          }
        });
        this.EcO.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b()
        {
          public final void ePr()
          {
            AppMethodBeat.i(208041);
            WebViewUI.a(WebViewUI.this, 0);
            AppMethodBeat.o(208041);
          }
          
          public final void ePs()
          {
            AppMethodBeat.i(208042);
            WebViewKeyboardLinearLayout localWebViewKeyboardLinearLayout = WebViewUI.this.EcH;
            if ((localWebViewKeyboardLinearLayout != null) && (localWebViewKeyboardLinearLayout.getKeyBoardHeight() > 0)) {
              WebViewUI.a(WebViewUI.this, localWebViewKeyboardLinearLayout.getKeyBoardHeight());
            }
            AppMethodBeat.o(208042);
          }
        });
      }
      this.EcP = ((WebViewSearchContentInputFooter)findViewById(2131304407));
      if (this.EcP != null)
      {
        this.EcP.setActionDelegate(new WebViewSearchContentInputFooter.a()
        {
          public final void a(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
          {
            AppMethodBeat.i(208044);
            if (paramAnonymousWebViewSearchContentInputFooter.getVisibility() == 0) {
              b(paramAnonymousWebViewSearchContentInputFooter);
            }
            AppMethodBeat.o(208044);
          }
          
          public final void b(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
          {
            AppMethodBeat.i(208047);
            WebViewUI.this.omW.clearMatches();
            paramAnonymousWebViewSearchContentInputFooter.reset();
            WebViewUI.this.EcP.C(0, 0, true);
            WebViewUI.a(WebViewUI.this, false);
            WebViewUI.this.omW.findAllAsync(paramAnonymousWebViewSearchContentInputFooter.getSearchContent());
            AppMethodBeat.o(208047);
          }
          
          public final boolean c(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(208048);
            if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0)) {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(480L, 6L, 1L, false);
            }
            AppMethodBeat.o(208048);
            return false;
          }
          
          public final void ePt()
          {
            AppMethodBeat.i(208043);
            WebViewUI.b(WebViewUI.this, 0);
            WebViewUI.this.omW.clearMatches();
            WebViewUI.this.EcP.eVK();
            AppMethodBeat.o(208043);
          }
          
          public final void ePu()
          {
            AppMethodBeat.i(208045);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(480L, 5L, 1L, false);
            WebViewUI.this.omW.findNext(false);
            AppMethodBeat.o(208045);
          }
          
          public final void ePv()
          {
            AppMethodBeat.i(208046);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(480L, 4L, 1L, false);
            WebViewUI.this.omW.findNext(true);
            AppMethodBeat.o(208046);
          }
        });
        this.omW.setFindListener(new WebView.FindListener()
        {
          public final void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(208049);
            if ((paramAnonymousBoolean) && (!WebViewUI.b(WebViewUI.this)) && (!bt.isNullOrNil(WebViewUI.this.EcP.getSearchContent())))
            {
              if (paramAnonymousInt2 != 0) {
                break label81;
              }
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(480L, 3L, 1L, false);
            }
            for (;;)
            {
              WebViewUI.a(WebViewUI.this, true);
              WebViewUI.this.EcP.C(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
              AppMethodBeat.o(208049);
              return;
              label81:
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(480L, 2L, 1L, false);
            }
          }
        });
      }
      this.EcK = ((MovingImageButton)findViewById(2131300327));
      this.Edg = findViewById(2131306913);
      if (this.Edg != null) {
        this.Edg.setVisibility(8);
      }
      this.omW.setWebChromeClient(eSR());
      this.omW.setDownloadListener(new DownloadListener()
      {
        public final void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
        {
          AppMethodBeat.i(208050);
          ad.i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + paramAnonymousString1 + ", mimetype = " + paramAnonymousString4 + ", userAgent = " + paramAnonymousString2 + ", contentDisposition = " + paramAnonymousString3);
          int i = WebViewUI.this.getIntent().getIntExtra("key_download_restrict", 0);
          String str = WebViewUI.this.getIntent().getStringExtra("key_function_id");
          if (!bt.isNullOrNil(str)) {
            com.tencent.mm.plugin.report.service.g.yhR.f(14596, new Object[] { str, Integer.valueOf(i), Integer.valueOf(0) });
          }
          if (i == 1)
          {
            ad.e("MicroMsg.WebViewUI", "not allow download file : %s", new Object[] { paramAnonymousString1 });
            AppMethodBeat.o(208050);
            return;
          }
          if ((paramAnonymousString4 != null) && (paramAnonymousString4.equalsIgnoreCase("application/vnd.android.package-archive")))
          {
            ad.v("MicroMsg.WebViewUI", "edw onDownloadStart, report download url: %s", new Object[] { paramAnonymousString1 });
            e.a(WebViewUI.this.lvv, 11154, new Object[] { paramAnonymousString1 });
          }
          if (WebViewUI.this.lvw == null)
          {
            ad.e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
            AppMethodBeat.o(208050);
            return;
          }
          int j = 0;
          if (paramAnonymousString4 != null)
          {
            boolean bool1 = WebViewUI.c(WebViewUI.this);
            ad.i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", new Object[] { Boolean.valueOf(bool1) });
            str = WebViewUI.aIS(paramAnonymousString3);
            if ((str == null) || (!Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", str))) {
              break label459;
            }
            i = 1;
            boolean bool2 = com.tencent.mm.plugin.webview.core.a.DHs.contains(paramAnonymousString4.toLowerCase());
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
              e.a(WebViewUI.this.lvv, 18111, new Object[] { WebViewUI.this.eNy(), paramAnonymousString1, paramAnonymousString4, paramAnonymousString3, paramAnonymousString2, Long.valueOf(paramAnonymousLong) });
            }
            if ((j != 0) || (WebViewUI.this.lvw.eRg().mz(24)) || (WebViewUI.d(WebViewUI.this))) {
              break label471;
            }
            ad.e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
            AppMethodBeat.o(208050);
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
            paramAnonymousString2 = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousString2);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString1, paramAnonymousString2.ahp(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$23", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString1.startActivity((Intent)paramAnonymousString2.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString1, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$23", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(208050);
            return;
          }
          catch (Exception paramAnonymousString1)
          {
            ad.e("MicroMsg.WebViewUI", "startActivity fail, e = " + paramAnonymousString1.getMessage());
            AppMethodBeat.o(208050);
          }
        }
      });
      this.omW.requestFocus(130);
      this.omW.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(208052);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$24", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if ((WebViewUI.this.EcG != null) && (WebViewUI.this.EcG.getVisibility() == 0))
          {
            localObject = AnimationUtils.loadAnimation(WebViewUI.this, 2130772060);
            ((Animation)localObject).setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(208051);
                WebViewUI.this.EcG.setVisibility(8);
                AppMethodBeat.o(208051);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationStart(Animation paramAnonymous2Animation) {}
            });
            WebViewUI.this.EcG.startAnimation((Animation)localObject);
            WebViewUI.this.EcG.setVisibility(8);
          }
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          while (WebViewUI.this.omW == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$24", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(208052);
            return false;
            if (!paramAnonymousView.hasFocus()) {
              paramAnonymousView.requestFocus();
            }
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              WebViewUI.this.nYw = ((int)paramAnonymousMotionEvent.getRawX());
              WebViewUI.this.nYx = ((int)paramAnonymousMotionEvent.getRawY());
            }
          }
          if ((paramAnonymousMotionEvent.getAction() == 0) || (paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 261) || (paramAnonymousMotionEvent.getAction() == 517))
          {
            if (paramAnonymousMotionEvent.getPointerCount() <= 1) {
              break label307;
            }
            WebViewUI.this.omW.getSettings().setBuiltInZoomControls(true);
            WebViewUI.this.omW.getSettings().setSupportZoom(true);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$24", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(208052);
            return false;
            label307:
            WebViewUI.this.omW.getSettings().setBuiltInZoomControls(false);
            WebViewUI.this.omW.getSettings().setSupportZoom(false);
          }
        }
      });
      this.omW.fLz();
      this.EdQ = new h(this);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(208053);
          WebViewUI.this.hideVKB();
          WebViewUI.this.eTg();
          ad.i("MicroMsg.WebViewUI", "on back btn press");
          AppMethodBeat.o(208053);
          return true;
        }
      }, eSS());
      if (eST()) {
        this.EcH.setOnkbdStateListener(new KeyboardLinearLayout.a()
        {
          public final void GV(int paramAnonymousInt)
          {
            AppMethodBeat.i(208062);
            ad.i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = ".concat(String.valueOf(paramAnonymousInt)));
            WebViewUI.a(WebViewUI.this, WebViewUI.this.EcH, paramAnonymousInt);
            if (paramAnonymousInt == -3)
            {
              WebViewUI.this.DIg.eQB().DUG = 1;
              int i = WebViewUI.this.EcH.getKeyBoardHeight();
              if (i > 0)
              {
                WebViewUI.b(WebViewUI.this, i);
                WebViewUI.a(WebViewUI.this, i);
              }
              if (WebViewUI.f(WebViewUI.this)) {
                WebViewUI.g(WebViewUI.this).eVN();
              }
            }
            for (;;)
            {
              WebViewUI.this.Xz(paramAnonymousInt);
              WebViewUI.this.Eex = paramAnonymousInt;
              AppMethodBeat.o(208062);
              return;
              WebViewUI.b(WebViewUI.this, 0);
              WebViewUI.a(WebViewUI.this, 0);
            }
          }
        });
      }
      this.EcA = ((MMFalseProgressBar)findViewById(2131306899));
      super.setTitleBarDoubleClickListener(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(208054);
          WebViewUI.this.eSU();
          AppMethodBeat.o(208054);
        }
      });
      AppMethodBeat.o(80284);
      return;
      localObject1 = String.valueOf(((j)localObject3).Ebt.getId());
      break;
      label1212:
      localObject2 = String.valueOf(((j)localObject3).Ebu.getId());
      break label548;
      label1227:
      ((j)localObject1).EbF = false;
      break label704;
      label1235:
      ((j)localObject1).ve(true);
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
    if (this.DIv != null) {
      this.DIv.loadUrl(paramString, paramMap, paramBoolean);
    }
    AppMethodBeat.o(80297);
  }
  
  protected void n(int paramInt, Bundle paramBundle) {}
  
  public boolean needShowIdcError()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(80289);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.lvF.c(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(80289);
      return;
    }
    if (this.EaP.c(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(80289);
      return;
    }
    if (this.Eeo.c(this, paramInt1, paramInt2, paramIntent))
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
      this.EdI = true;
      k.EbJ.close();
      setResult(-1, paramIntent);
      finish();
    }
    AppMethodBeat.o(80289);
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(80291);
    if (this.omW != null)
    {
      if (!this.Eep) {
        break label42;
      }
      this.omW.setOnLongClickListener(this.Eeq);
    }
    for (;;)
    {
      super.onCancel();
      AppMethodBeat.o(80291);
      return;
      label42:
      this.omW.setOnLongClickListener(null);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(80265);
    super.onConfigurationChanged(paramConfiguration);
    if (this.ogL != paramConfiguration.orientation)
    {
      View localView = eSM();
      if (localView == null) {}
      for (localView = null; localView == null; localView = (View)localView.getParent())
      {
        AppMethodBeat.o(80265);
        return;
      }
      localView.dispatchConfigurationChanged(paramConfiguration);
      localView.requestLayout();
      this.ogL = paramConfiguration.orientation;
    }
    AppMethodBeat.o(80265);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80244);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.CZm, true)) {
      bz.ftx();
    }
    com.tencent.mm.plugin.webview.j.i locali = this.EdN;
    locali.createTime = System.currentTimeMillis();
    locali.bL("onCreate", locali.createTime);
    this.EdN.EtC = getIntent().getLongExtra("startTime", 0L);
    bRw();
    super.onCreate(paramBundle);
    this.EdN.bL("onUIInitStart", System.currentTimeMillis());
    bQP();
    this.EdN.bL("onUIInitEnd", System.currentTimeMillis());
    paramBundle = getIntent();
    if ((paramBundle.hasExtra("nextAnimIn")) || (paramBundle.hasExtra("currentAnimOut"))) {
      overridePendingTransition(paramBundle.getIntExtra("nextAnimIn", 2130772144), paramBundle.getIntExtra("currentAnimOut", 2130772141));
    }
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
    ad.i("MicroMsg.WebViewUI", "WebViewUI onDestroy now: %s", new Object[] { Integer.valueOf(this.DIv.eNj()) });
    super.onDestroy();
    com.tencent.mm.plugin.webview.modeltools.c.eQL();
    Object localObject1 = this.DIv.getCurrentUrl();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.webview.j.j.he(this);
      if ((localObject2 != null) && (((String)localObject1).equals(localObject2))) {
        com.tencent.mm.plugin.webview.j.j.hf(this);
      }
    }
    for (;;)
    {
      this.Edo.onDestroy();
      if (this.EdZ != null)
      {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).K(this.EdZ.nGj);
        this.EdZ.onDestroy();
      }
      if ((ePk()) && (this.EdX != null))
      {
        ad.i("MicroMsg.WebViewUI", "[Handoff] call onWebViewDestroy " + this.EdX.toString());
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).b(this.EdX);
      }
      if (this.EcN != null) {
        this.EcN.disable();
      }
      this.EdI = true;
      EdH -= 1;
      int j = this.DIv.eNj();
      int i = Edi.size() - 1;
      label225:
      if (i >= 0)
      {
        if (((e)Edi.get(i)).id == j) {
          Edi.remove(i);
        }
      }
      else
      {
        this.DIg.eQF().D(new Object[] { bQm(), Integer.valueOf(2) }).report();
        this.DIg.report();
        localObject1 = this.DIg;
        ((com.tencent.mm.plugin.webview.model.ay)localObject1).DUM = null;
        ((com.tencent.mm.plugin.webview.model.ay)localObject1).DUK = null;
        ((com.tencent.mm.plugin.webview.model.ay)localObject1).DUL = null;
        ((com.tencent.mm.plugin.webview.model.ay)localObject1).DUJ = null;
        ((com.tencent.mm.plugin.webview.model.ay)localObject1).DUO = null;
        ((com.tencent.mm.plugin.webview.model.ay)localObject1).DUP = null;
        ((com.tencent.mm.plugin.webview.model.ay)localObject1).DUQ = null;
        ((com.tencent.mm.plugin.webview.model.ay)localObject1).DUR = null;
        if (((com.tencent.mm.plugin.webview.model.ay)localObject1).DUW != null)
        {
          ((com.tencent.mm.plugin.webview.model.ay)localObject1).DUW.dxT = null;
          ((com.tencent.mm.plugin.webview.model.ay)localObject1).DUW = null;
        }
        aas("onDestroy");
        this.Edr.clear();
        eSv();
        c(this.Edw);
        if ((this.Edl != null) && ((this.Edl instanceof b))) {
          c(((b)this.Edl).juf);
        }
        if (this.EcO != null) {
          this.EcO.setOnTextSendListener(null);
        }
        if (this.EcD != null)
        {
          localObject1 = this.EcD.Eav;
          if (localObject1 != null)
          {
            localObject2 = ((View)localObject1).getAnimation();
            if (localObject2 != null) {
              ((Animation)localObject2).setAnimationListener(null);
            }
            ((View)localObject1).clearAnimation();
          }
        }
        this.Eds.clear();
        this.EdR.onDestroy();
        this.Eec.dead();
        this.Edp.dead();
        if (com.tencent.xweb.d.lv(aj.getContext()) != null)
        {
          ad.i("MicroMsg.WebViewUI", "now force sync the cookie between ram and db");
          com.tencent.xweb.d.sync();
        }
        ad.v("MicroMsg.WebViewUI", "on destroy isNeedCallbackMMRpt[%b]", new Object[] { Boolean.valueOf(this.EcW) });
        if (!this.EcW) {}
      }
      try
      {
        localObject1 = getIntent().getBundleExtra("mm_report_bundle");
        if (!bt.isNullOrNil(((Bundle)localObject1).getString("mm_event_class"))) {
          if (this.lvv != null)
          {
            ((Bundle)localObject1).putLong("key_activity_browse_time", getActivityBrowseTimeMs());
            this.lvv.k(250, (Bundle)localObject1);
          }
        }
      }
      catch (Exception localThrowable)
      {
        try
        {
          if (this.lvv != null)
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putLong("key_activity_browse_time", getActivityBrowseTimeMs());
            this.lvv.k(251, (Bundle)localObject1);
          }
        }
        catch (Exception localThrowable)
        {
          try
          {
            if (this.lvv != null)
            {
              localObject1 = this.lvv.k(19, null);
              if (localObject1 != null)
              {
                bool = ((Bundle)localObject1).getBoolean("webview_video_proxy_init");
                ad.i("MicroMsg.WebViewUI", "onDestroy, has init = %b, webviewHoldingCounter = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(EdH) });
                if ((bool) && (EdH <= 0))
                {
                  FactoryProxyManager.getPlayManager().deinit();
                  this.lvv.k(75, null);
                }
              }
            }
            bool = com.tencent.mm.plugin.webview.modeltools.k.a(this.DzP, this.omW);
            this.DIv.onDestroy();
            this.omW.removeJavascriptInterface("MicroMsg");
            this.omW.removeJavascriptInterface("JsApi");
            this.omW.removeJavascriptInterface("__wx");
            this.omW.removeJavascriptInterface("CustomFullscreenApi");
            this.omW.removeJavascriptInterface("__wxtag");
          }
          catch (Exception localThrowable)
          {
            try
            {
              this.omW.setWebChromeClient(null);
              this.omW.setWebViewClient(null);
              this.omW.setOnTouchListener(null);
              this.omW.setOnLongClickListener(null);
              this.omW.setVisibility(8);
              this.omW.removeAllViews();
              this.omW.clearView();
              this.EdP.eRf();
              if (this.lvw != null)
              {
                localObject1 = this.lvw;
                ad.i("MicroMsg.WebViewPermission", "detach");
                ((com.tencent.mm.plugin.webview.e.g)localObject1).DWW.clear();
                ((com.tencent.mm.plugin.webview.e.g)localObject1).DWW = null;
                this.lvw = null;
              }
            }
            catch (Exception localThrowable)
            {
              try
              {
                boolean bool;
                this.Een.release();
                if (bool) {}
              }
              catch (Exception localThrowable)
              {
                try
                {
                  this.omW.destroy();
                }
                catch (Exception localThrowable)
                {
                  try
                  {
                    if ((getContentView() instanceof ViewGroup)) {
                      ((ViewGroup)getContentView()).removeAllViews();
                    }
                    localObject1 = this.EdT;
                  }
                  catch (Throwable localThrowable)
                  {
                    try
                    {
                      for (;;)
                      {
                        ((ClipboardManager)aj.getContext().getSystemService("clipboard")).removePrimaryClipChangedListener((ClipboardManager.OnPrimaryClipChangedListener)localObject1);
                        label996:
                        localObject1 = this.EdU;
                        if ((((com.tencent.mm.plugin.webview.c)localObject1).tipDialog != null) && (((com.tencent.mm.plugin.webview.c)localObject1).tipDialog.isShowing()))
                        {
                          ((com.tencent.mm.plugin.webview.c)localObject1).tipDialog.dismiss();
                          ((com.tencent.mm.plugin.webview.c)localObject1).tipDialog = null;
                        }
                        com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.plugin.webview.c)localObject1).DFP);
                        this.omW = null;
                        if (this.EdS != null)
                        {
                          this.EdS = null;
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
                      break label996;
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
    if (this.omW != null) {
      this.omW.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(208055);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$28", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$28", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(208055);
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
      if ((this.omW != null) && (this.omW.hasEnteredFullscreen()))
      {
        this.omW.leaveFullscreen();
        AppMethodBeat.o(80274);
        return true;
      }
      if (this.Edo.eVk())
      {
        AppMethodBeat.o(80274);
        return true;
      }
    }
    if ((paramInt == 4) && (this.vd != null) && (this.Edk != null) && (this.Edl != null)) {
      try
      {
        this.Edl.onHideCustomView();
        this.DIg.eQF().D(new Object[] { bQm(), Integer.valueOf(1) }).report();
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
      if ((this.EcO != null) && (this.EcO.isShown()))
      {
        this.EcO.hide();
        eTb();
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(80274);
        return true;
      }
    }
    if (paramInt == 4)
    {
      if ((this.omW != null) && (this.omW.canGoBack()) && (this.EcT))
      {
        eSO();
        this.DIg.eQF().D(new Object[] { bQm(), Integer.valueOf(1) }).report();
        AppMethodBeat.o(80274);
        return true;
      }
      k.EbJ.close();
    }
    if ((paramInt == 4) && (eTf()) && (ePd()))
    {
      AppMethodBeat.o(80274);
      return true;
    }
    if ((paramInt == 4) && (this.EdZ != null) && (this.EdZ.sv(2)))
    {
      AppMethodBeat.o(80274);
      return true;
    }
    if ((paramInt == 4) && (this.Eed != null) && (this.Eed.bni()))
    {
      this.Eed.hide();
      AppMethodBeat.o(80274);
      return true;
    }
    if (paramInt == 4) {
      eTh();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(80274);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(80273);
    if ((paramInt == 82) && (!this.Eem))
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
    if (this.EdZ != null) {
      this.EdZ.bgC();
    }
    com.tencent.mm.modelstat.d.d(4, "WebViewUI_" + aGo(bt.nullAsNil(this.Edy)), this.DIv.eNj());
    com.tencent.mm.modelstat.d.m("WebViewUI_" + aGo(bt.nullAsNil(this.Edy)), this.vwS, bt.aQJ());
    Object localObject = this.DIg.eQB();
    if (((aw)localObject).lastResumeTime != -1L) {
      ((aw)localObject).dBD += bt.aO(((aw)localObject).lastResumeTime) / 1000L;
    }
    localObject = this.DIg.eQC();
    if (((ak)localObject).lastResumeTime != -1L) {
      ((ak)localObject).dBD += bt.aO(((ak)localObject).lastResumeTime);
    }
    localObject = k.EbJ;
    ad.v("MicroMsg.WebViewReportUtil", "onPause traceid %s", new Object[] { ((k)localObject).zuO });
    if (((k)localObject).hII) {
      ad.i("MicroMsg.WebViewReportUtil", "isFinish is true");
    }
    try
    {
      if (this.lvv != null)
      {
        localObject = this.lvv.k(19, null);
        if (localObject != null)
        {
          boolean bool = ((Bundle)localObject).getBoolean("webview_video_proxy_init");
          ad.i("MicroMsg.WebViewUI", "onPause, has init = %b", new Object[] { Boolean.valueOf(bool) });
          if (bool) {
            FactoryProxyManager.getPlayManager().appToBack();
          }
        }
      }
      eTb();
      bh.a(this, null);
      aas("onPause");
      if (this.Edl != null) {
        ad.i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.Edl.onHideCustomView();
          this.Edo.onPause();
          if (this.omW != null) {
            this.omW.onPause();
          }
          AppMethodBeat.o(80234);
          return;
          if (!bt.isNullOrNil(((k)localObject).zuO)) {
            ((k)localObject).ma(6);
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
    paramArrayOfString = this.lvF;
    if (paramArrayOfString.DVv == null)
    {
      paramArrayOfString.eQM();
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
        paramArrayOfInt = (Intent)paramArrayOfString.DVv.first;
        paramInt = ((Integer)paramArrayOfString.DVv.second).intValue();
        paramArrayOfString.DVv = null;
        startActivityForResult(paramArrayOfInt, paramInt);
      }
      for (;;)
      {
        paramInt = 1;
        break;
        label99:
        paramArrayOfString.DVv = null;
        paramArrayOfString.b(this, 0, null);
      }
    }
    AppMethodBeat.o(80242);
  }
  
  protected void onReset()
  {
    AppMethodBeat.i(80245);
    this.DzP.detach();
    this.DzP = null;
    ((ViewGroup)this.omW.getParent()).removeView(this.omW);
    this.omW.stopLoading();
    this.omW.removeAllViews();
    this.omW.clearView();
    this.omW.destroy();
    this.omW = null;
    this.Edl = null;
    ((ViewGroup)this.EcG.getParent()).removeView(this.EcG);
    if (this.EdY != null)
    {
      n localn = this.EdY;
      if (localn.EeK != null)
      {
        LinearLayout localLinearLayout = (LinearLayout)localn.EeJ.getController().mActionBar.getCustomView();
        if (localLinearLayout != null) {
          localLinearLayout.removeView(localn.EeK);
        }
      }
    }
    if (this.DIv != null) {
      this.DIv.onDestroy();
    }
    this.Edo.onDestroy();
    this.EdL = false;
    bRw();
    bQP();
    AppMethodBeat.o(80245);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80233);
    super.onResume();
    if (this.EdZ != null) {
      this.EdZ.bgB();
    }
    if (this.DIv.getCurrentUrl() != null) {
      com.tencent.mm.plugin.webview.j.j.h(this.DIv.getCurrentUrl(), this);
    }
    for (;;)
    {
      this.DIg.eQB().lastResumeTime = bt.HI();
      this.DIg.eQC().lastResumeTime = bt.HI();
      Object localObject = k.EbJ;
      ad.v("MicroMsg.WebViewReportUtil", "onResume traceid %s", new Object[] { ((k)localObject).zuO });
      if (!bt.isNullOrNil(((k)localObject).zuO)) {
        ((k)localObject).ma(7);
      }
      int i;
      if (!this.Eeh)
      {
        int j = this.DIv.eNj();
        i = Edi.size() - 1;
        if (i >= 0)
        {
          if (((e)Edi.get(i)).id == j) {
            Edi.remove(i);
          }
        }
        else {
          Edi.add(new e(this));
        }
      }
      else
      {
        this.Eeh = false;
        if (this.Edj)
        {
          uY(true);
          this.Edj = false;
        }
        eSQ();
        updateOrientation();
        if ((getIntent().getBooleanExtra("disable_swipe_back", false)) && (getSwipeBackLayout() != null)) {
          getSwipeBackLayout().setEnableGesture(false);
        }
      }
      try
      {
        bh.a(this, this);
        aas("onResume");
        try
        {
          if (this.lvv != null)
          {
            localObject = this.lvv.k(19, null);
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
        catch (Exception localException2)
        {
          for (;;)
          {
            ad.e("MicroMsg.WebViewUI", "notify app tofront failed : %s", new Object[] { localException2.getMessage() });
          }
        }
        this.vwS = bt.aQJ();
        com.tencent.mm.plugin.webview.a.a.af(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80087);
            com.tencent.mm.modelstat.d.d(3, "WebViewUI_" + WebViewUI.this.aGo(bt.nullAsNil(WebViewUI.this.Edy)), WebViewUI.this.eNj());
            AppMethodBeat.o(80087);
          }
        });
        if (this.EdM) {
          finish();
        }
        if ((this.EcH != null) && (this.EcH.EaT))
        {
          hideVKB();
          this.EcH.GV(-2);
        }
        this.Edo.onResume();
        if (this.omW != null) {
          this.omW.onResume();
        }
        AppMethodBeat.o(80233);
        return;
        com.tencent.mm.plugin.webview.j.j.h(bQm(), this);
        continue;
        i -= 1;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          ad.w("MicroMsg.WebViewUI", "setScreenShotCallback fail e:%s", new Object[] { localException1.getMessage() });
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
    this.EcA.finish();
    vh(true);
    super.onStop();
    AppMethodBeat.o(80267);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(80290);
    if (this.omW != null)
    {
      if (!this.Eep) {
        break label46;
      }
      this.omW.setOnLongClickListener(this.Eeq);
    }
    for (;;)
    {
      hideVKB();
      super.onSwipeBack();
      AppMethodBeat.o(80290);
      return;
      label46:
      this.omW.setOnLongClickListener(null);
    }
  }
  
  public boolean onSwipeBackFinish()
  {
    AppMethodBeat.i(80293);
    this.EdK = true;
    ay.g localg = this.DIg.eQF();
    if (this.omW != null) {}
    for (String str = this.omW.getUrl();; str = bQm())
    {
      localg.D(new Object[] { str, Integer.valueOf(15) }).report();
      boolean bool = super.onSwipeBackFinish();
      AppMethodBeat.o(80293);
      return bool;
    }
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(80261);
    Object localObject;
    if ((this.EdY != null) && (!this.EdY.EeI))
    {
      localObject = this.EdY;
      if (bt.isNullOrNil(((n)localObject).mue)) {
        ((n)localObject).mue = bt.nullAsNil(((n)localObject).EeJ.DIv.getCurrentUrl());
      }
      ((n)localObject).eTv();
    }
    long l;
    if (this.EcD != null)
    {
      localObject = this.EcD;
      if (((g)localObject).Ear)
      {
        l = System.currentTimeMillis();
        if (((g)localObject).Eao == 0L)
        {
          ((g)localObject).Eao = l;
          ((g)localObject).Eap = paramInt2;
        }
        if ((Math.abs(l - ((g)localObject).Eao) > 200L) && (Math.abs(paramInt2 - ((g)localObject).Eap) > ((g)localObject).Eaq))
        {
          if ((paramInt2 - ((g)localObject).Eap <= 0) || (((g)localObject).Eav.getVisibility() != 0)) {
            break label195;
          }
          ((g)localObject).eRX();
        }
      }
    }
    for (;;)
    {
      ((g)localObject).Eao = l;
      ((g)localObject).Eap = paramInt2;
      AppMethodBeat.o(80261);
      return;
      label195:
      if ((paramInt2 - ((g)localObject).Eap < 0) && (((g)localObject).Eav.getVisibility() != 0)) {
        ((g)localObject).eRW();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(80283);
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.EcL)) {
      ax(getWindow().getDecorView(), 5894);
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(80283);
  }
  
  protected void ph(boolean paramBoolean) {}
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(80221);
    super.setActionbarColor(paramInt);
    if (this.EdA) {
      setStatusBarColor(paramInt);
    }
    AppMethodBeat.o(80221);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    AppMethodBeat.i(80363);
    super.setBackBtn(paramOnMenuItemClickListener, paramInt);
    if ((com.tencent.mm.compatible.util.d.ly(21)) && (eSI())) {
      setBackBtnColorFilter(-16777216);
    }
    AppMethodBeat.o(80363);
  }
  
  public void setMMOrientation()
  {
    AppMethodBeat.i(80263);
    if (getForceOrientation() == -1)
    {
      this.landscapeMode = getSharedPreferences(aj.fkC(), 4).getBoolean("settings_landscape_mode", false);
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
    aIO(paramCharSequence.toString());
    aIP(paramCharSequence.toString());
    AppMethodBeat.o(80238);
  }
  
  public void setMMTitle(String paramString)
  {
    AppMethodBeat.i(80237);
    super.setMMTitle(paramString);
    aIO(paramString);
    aIP(paramString);
    AppMethodBeat.o(80237);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(208116);
    this.screenOrientation = paramInt;
    updateOrientation();
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(208116);
  }
  
  @TargetApi(21)
  public final void setStatusBarColor(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(80258);
    Object localObject;
    if (this.EdA)
    {
      localObject = getContentView();
      if (!ao.abX(paramInt)) {
        bool = true;
      }
      com.tencent.mm.ui.statusbar.a.e((View)localObject, paramInt, bool);
      AppMethodBeat.o(80258);
      return;
    }
    if ((this.mFF <= 0) || (com.tencent.mm.compatible.util.d.lz(21)))
    {
      AppMethodBeat.o(80258);
      return;
    }
    getWindow().setStatusBarColor(0);
    if (this.Eek == null)
    {
      this.Eek = new View(this);
      localObject = new ViewGroup.LayoutParams(-1, this.mFF);
      ((ViewGroup)findViewById(16908290)).addView(this.Eek, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.Eek.setBackgroundColor(paramInt);
      AppMethodBeat.o(80258);
      return;
      localObject = this.Eek.getLayoutParams();
      if (((ViewGroup.LayoutParams)localObject).height != this.mFF)
      {
        ((ViewGroup.LayoutParams)localObject).height = this.mFF;
        this.Eek.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
    if (this.Eex == -3)
    {
      this.Eex = -2;
      AppMethodBeat.o(80362);
      return;
    }
    this.Eex = -3;
    AppMethodBeat.o(80362);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(80369);
    if (bt.lQ(paramIntent.getType(), "application/vnd.android.package-archive"))
    {
      r.j(aj.getContext(), paramIntent.getData());
      AppMethodBeat.o(80369);
      return;
    }
    super.startActivity(paramIntent);
    AppMethodBeat.o(80369);
  }
  
  public final void vf(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(80319);
    if (this.EcD != null) {
      this.EcD.vf(paramBoolean);
    }
    ImageButton localImageButton;
    if ((this.omW != null) && (this.Eav != null))
    {
      localImageButton = this.EcE;
      if ((this.omW == null) || (!this.omW.canGoBack())) {
        break label102;
      }
      paramBoolean = true;
      localImageButton.setEnabled(paramBoolean);
      localImageButton = this.EcF;
      if ((this.omW == null) || (!this.omW.canGoForward())) {
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
  
  protected void vg(boolean paramBoolean)
  {
    AppMethodBeat.i(80310);
    this.Eem = paramBoolean;
    if (this.omW == null)
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
    int i = eTa();
    if (eSZ() != null) {
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
            AppMethodBeat.i(80073);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(WebViewUI.this, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
            ((Intent)localObject).putExtra("entry_fix_tools", 1);
            paramAnonymousMenuItem = WebViewUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$34", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$34", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(80073);
            return true;
          }
        });
      }
      addIconOptionMenu(0, i, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(80082);
          if (WebViewUI.this.lvw.aIk(WebViewUI.this.eNy())) {
            WebViewUI.this.DIg.eQF().D(new Object[] { WebViewUI.this.bQm(), Integer.valueOf(6) }).report();
          }
          for (;;)
          {
            WebViewUI.this.bQS();
            AppMethodBeat.o(80082);
            return true;
            WebViewUI.this.DIg.eQF().D(new Object[] { WebViewUI.this.bQm(), Integer.valueOf(5) }).report();
          }
        }
      }, this.Eet);
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      vi(paramBoolean);
      AppMethodBeat.o(80310);
      return;
    }
  }
  
  protected final void vh(boolean paramBoolean)
  {
    AppMethodBeat.i(208122);
    enableOptionMenu(true);
    ad.d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", new Object[] { Boolean.TRUE });
    setProgressBarIndeterminateVisibility(false);
    if (paramBoolean)
    {
      this.EdR.eSf();
      AppMethodBeat.o(208122);
      return;
    }
    if ((!this.EdC) && (!this.EdD)) {
      this.DIv.bQw();
    }
    AppMethodBeat.o(208122);
  }
  
  public final void vi(boolean paramBoolean)
  {
    AppMethodBeat.i(80359);
    String str = this.omW.getUrl();
    if (paramBoolean)
    {
      showOptionMenu(0, false);
      this.Edu.put(str, Boolean.TRUE);
      AppMethodBeat.o(80359);
      return;
    }
    showOptionMenu(0, true);
    if (this.Edu.containsKey(str)) {
      this.Edu.remove(str);
    }
    AppMethodBeat.o(80359);
  }
  
  protected void z(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80358);
    ad.i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
    AppMethodBeat.o(80358);
  }
  
  protected static final class a
  {
    private String DQs;
    private String DQt;
    private String DQu;
    private String DQv;
    private String DQw;
    private String DQx;
    private String EeD;
    private String lang;
    
    private a(Bundle paramBundle)
    {
      AppMethodBeat.i(80123);
      this.EeD = paramBundle.getString("close_window_confirm_dialog_switch");
      this.DQs = paramBundle.getString("close_window_confirm_dialog_title_cn");
      this.DQt = paramBundle.getString("close_window_confirm_dialog_title_eng");
      this.DQu = paramBundle.getString("close_window_confirm_dialog_ok_cn");
      this.DQv = paramBundle.getString("close_window_confirm_dialog_ok_eng");
      this.DQw = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
      this.DQx = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
      this.lang = paramBundle.getString("application_language");
      AppMethodBeat.o(80123);
    }
    
    public static a aP(Bundle paramBundle)
    {
      AppMethodBeat.i(80124);
      paramBundle = new a(paramBundle);
      AppMethodBeat.o(80124);
      return paramBundle;
    }
    
    public final boolean ePK()
    {
      AppMethodBeat.i(80125);
      if (bt.isNullOrNil(this.EeD))
      {
        AppMethodBeat.o(80125);
        return false;
      }
      boolean bool = this.EeD.equals("true");
      AppMethodBeat.o(80125);
      return bool;
    }
    
    public final String ePM()
    {
      AppMethodBeat.i(80127);
      if ("zh_CN".equals(this.lang))
      {
        str = this.DQu;
        AppMethodBeat.o(80127);
        return str;
      }
      String str = this.DQv;
      AppMethodBeat.o(80127);
      return str;
    }
    
    public final String ePN()
    {
      AppMethodBeat.i(80128);
      if ("zh_CN".equals(this.lang))
      {
        str = this.DQw;
        AppMethodBeat.o(80128);
        return str;
      }
      String str = this.DQx;
      AppMethodBeat.o(80128);
      return str;
    }
    
    public final String eTq()
    {
      AppMethodBeat.i(80126);
      if ("zh_CN".equals(this.lang))
      {
        str = this.DQs;
        AppMethodBeat.o(80126);
        return str;
      }
      String str = this.DQt;
      AppMethodBeat.o(80126);
      return str;
    }
  }
  
  public class b
    extends com.tencent.xweb.x
  {
    public volatile boolean grY;
    com.tencent.mm.ui.widget.a.d juf;
    
    protected b()
    {
      AppMethodBeat.i(80144);
      this.grY = false;
      this.juf = null;
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
      com.tencent.mm.plugin.ball.f.f.e(true, true, false);
      if (WebViewUI.this.eOz().DNU)
      {
        MPVideoPlayFullScreenView localMPVideoPlayFullScreenView = WebViewUI.this.eSz();
        Context localContext = localMPVideoPlayFullScreenView.getContext();
        if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).omW != null)) {
          localMPVideoPlayFullScreenView.Eok = ((WebViewUI)localContext).omW.setVideoJsCallback((com.tencent.xweb.v)new MPVideoPlayFullScreenView.h(localMPVideoPlayFullScreenView));
        }
        if (localMPVideoPlayFullScreenView.Eok != null) {}
        for (int i = 1; i != 0; i = 0)
        {
          WebViewUI.a(WebViewUI.this, paramCustomViewCallback);
          ad.i("MicroMsg.WebViewUI", "onEnterFullscreen view");
          if (paramView.getParent() == null) {
            WebViewUI.this.eSz().fO(paramView);
          }
          AppMethodBeat.o(80145);
          return true;
        }
      }
      if (WebViewUI.this.eOz().DNU) {
        WebViewUI.this.eOz().vb(false);
      }
      boolean bool = super.a(paramView, paramCustomViewCallback);
      AppMethodBeat.o(80145);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, x.a parama)
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
          WebViewUI.p(WebViewUI.this).a(WebViewUI.this, WebViewUI.this.lvw, null, paramValueCallback, str2, paramWebView);
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
      WebViewUI.q(WebViewUI.this);
      if (WebViewUI.r(WebViewUI.this) > 2) {}
      for (this.juf = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131766261), WebViewUI.this.getString(2131755835), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80142);
              com.tencent.mm.plugin.report.service.g.yhR.f(11683, new Object[] { paramString1, Integer.valueOf(1), Integer.valueOf(WebViewUI.r(WebViewUI.this)) });
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
          }, 2131100547); this.juf != null; this.juf = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131755835), new DialogInterface.OnClickListener()
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
        this.juf.setOnDismissListener(new DialogInterface.OnDismissListener()
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
        this.juf.setCanceledOnTouchOutside(false);
        this.juf.yO(false);
        AppMethodBeat.o(80158);
        return true;
      }
      boolean bool = super.a(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(80158);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, o paramo)
    {
      AppMethodBeat.i(80157);
      boolean bool = super.a(paramWebView, paramString1, paramString2, paramString3, paramo);
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
      WebViewUI.q(WebViewUI.this);
      if (WebViewUI.r(WebViewUI.this) > 2) {}
      for (this.juf = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131766261), WebViewUI.this.getString(2131755835), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80137);
              com.tencent.mm.plugin.report.service.g.yhR.f(11683, new Object[] { paramString1, Integer.valueOf(1), Integer.valueOf(WebViewUI.r(WebViewUI.this)) });
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
          }, 2131100053); this.juf != null; this.juf = com.tencent.mm.ui.base.h.a(WebViewUI.this.getContext(), false, paramString2, "", WebViewUI.this.getString(2131755835), WebViewUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
        this.juf.setOnDismissListener(new DialogInterface.OnDismissListener()
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
        this.juf.setCancelable(false);
        this.juf.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(80156);
        return true;
      }
      boolean bool = super.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(80156);
      return bool;
    }
    
    public final boolean bpk()
    {
      AppMethodBeat.i(80146);
      com.tencent.mm.plugin.ball.f.f.e(false, true, false);
      boolean bool = super.bpk();
      AppMethodBeat.o(80146);
      return bool;
    }
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80149);
      ad.i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", new Object[] { paramString, WebViewUI.this.eSK() });
      super.d(paramWebView, paramString);
      if ((WebViewUI.this.Ecy) && (!WebViewUI.k(WebViewUI.this)))
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
      if (!WebViewUI.this.yyS)
      {
        AppMethodBeat.o(80149);
        return;
      }
      if ((!bt.nullAsNil(WebViewUI.this.eSK()).equals(paramString)) && (!com.tencent.mm.plugin.webview.luggage.c.b.UV(paramString)) && (!paramString.startsWith("about:blank"))) {
        WebViewUI.this.setMMTitle(paramString);
      }
      AppMethodBeat.o(80149);
    }
    
    public final View getVideoLoadingProgressView()
    {
      AppMethodBeat.i(80152);
      if (WebViewUI.o(WebViewUI.this) == null)
      {
        WebViewUI.a(WebViewUI.this, new ProgressBar(WebViewUI.this));
        WebViewUI.o(WebViewUI.this).setIndeterminate(true);
      }
      ProgressBar localProgressBar = WebViewUI.o(WebViewUI.this);
      AppMethodBeat.o(80152);
      return localProgressBar;
    }
    
    public final void onExitFullscreenVideo(Bitmap paramBitmap)
    {
      AppMethodBeat.i(80147);
      if ((WebViewUI.this.DzP != null) && (WebViewUI.this.eOz().DNU) && (WebViewUI.this.eSz().getVisibility() == 0))
      {
        if (WebViewUI.j(WebViewUI.this) != null) {
          WebViewUI.j(WebViewUI.this).onCustomViewHidden();
        }
        WebViewUI.this.eOz().vb(false);
        MPVideoPlayFullScreenView localMPVideoPlayFullScreenView = WebViewUI.this.eSz();
        if (localMPVideoPlayFullScreenView.Bjz)
        {
          ad.i(localMPVideoPlayFullScreenView.TAG, "isRunningExitAnimation");
          AppMethodBeat.o(80147);
          return;
        }
        localMPVideoPlayFullScreenView.eUT();
        if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
        {
          localObject = new ImageView(localMPVideoPlayFullScreenView.getContext());
          ViewGroup localViewGroup = localMPVideoPlayFullScreenView.Eod;
          if (localViewGroup != null) {
            localViewGroup.addView((View)localObject, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
          }
          ((ImageView)localObject).setImageBitmap(paramBitmap);
        }
        ad.i(localMPVideoPlayFullScreenView.TAG, "runExitAnimation");
        localMPVideoPlayFullScreenView.eUU();
        int j = localMPVideoPlayFullScreenView.Eoa.getWidth();
        int i = localMPVideoPlayFullScreenView.Eoa.getHeight();
        paramBitmap = localMPVideoPlayFullScreenView.oGo;
        if (paramBitmap != null) {
          paramBitmap.jZ(j, i);
        }
        paramBitmap = localMPVideoPlayFullScreenView.oGo;
        int k;
        if (paramBitmap != null)
        {
          localObject = localMPVideoPlayFullScreenView.hzo;
          if (localObject == null) {
            d.g.b.p.gfZ();
          }
          j = ((com.tencent.mm.ai.y)localObject).hDK;
          localObject = localMPVideoPlayFullScreenView.hzo;
          if (localObject == null) {
            d.g.b.p.gfZ();
          }
          k = ((com.tencent.mm.ai.y)localObject).hDL;
          localObject = localMPVideoPlayFullScreenView.hzo;
          if (localObject == null) {
            d.g.b.p.gfZ();
          }
          int m = ((com.tencent.mm.ai.y)localObject).hDM;
          localObject = localMPVideoPlayFullScreenView.hzo;
          if (localObject == null) {
            d.g.b.p.gfZ();
          }
          paramBitmap.R(j, k, m, ((com.tencent.mm.ai.y)localObject).hDN);
        }
        if (localMPVideoPlayFullScreenView.Aal != 1.0D)
        {
          paramBitmap = localMPVideoPlayFullScreenView.oGo;
          if (paramBitmap != null) {
            paramBitmap.KIl = (1.0F / localMPVideoPlayFullScreenView.Aal);
          }
          if ((localMPVideoPlayFullScreenView.Aam != 0) || (localMPVideoPlayFullScreenView.Aan != 0))
          {
            j = (int)(localMPVideoPlayFullScreenView.Eoa.getWidth() / 2 * (1.0F - localMPVideoPlayFullScreenView.Aal));
            k = localMPVideoPlayFullScreenView.Aam;
            i = (int)(localMPVideoPlayFullScreenView.Eoa.getHeight() / 2 + localMPVideoPlayFullScreenView.Aan - i / 2 * localMPVideoPlayFullScreenView.Aal);
            paramBitmap = localMPVideoPlayFullScreenView.oGo;
            if (paramBitmap != null) {
              paramBitmap.kb(j + k, i);
            }
          }
        }
        paramBitmap = localMPVideoPlayFullScreenView.Eoa.getLayoutParams();
        Object localObject = localMPVideoPlayFullScreenView.oGo;
        if (localObject != null)
        {
          ((com.tencent.mm.ui.tools.e)localObject).a((View)localMPVideoPlayFullScreenView.Eod, localMPVideoPlayFullScreenView.Eoa, (e.c)new MPVideoPlayFullScreenView.p(localMPVideoPlayFullScreenView, paramBitmap), null);
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
      if (!com.tencent.mm.pluginsdk.permission.b.n(WebViewUI.this, "android.permission.ACCESS_COARSE_LOCATION")) {
        com.tencent.mm.pluginsdk.permission.b.b(WebViewUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64);
      }
      com.tencent.mm.ui.base.h.a(WebViewUI.this, false, WebViewUI.this.getString(2131766268, new Object[] { paramString }), WebViewUI.this.getString(2131766269), WebViewUI.this.getString(2131755835), WebViewUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(80133);
          ad.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt ok");
          paramCallback.invoke(paramString, true, true);
          e.a(WebViewUI.this.lvv, 14340, new Object[] { WebViewUI.this.bQm(), WebViewUI.this.eNy(), Integer.valueOf(WebViewUI.this.bpm()), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(com.tencent.mm.plugin.webview.model.ay.blr()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(80133);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(80136);
          ad.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt cancel");
          paramCallback.invoke(paramString, false, false);
          e.a(WebViewUI.this.lvv, 14340, new Object[] { WebViewUI.this.bQm(), WebViewUI.this.eNy(), Integer.valueOf(WebViewUI.this.bpm()), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(com.tencent.mm.plugin.webview.model.ay.blr()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
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
      if (WebViewUI.l(WebViewUI.this) == null)
      {
        AppMethodBeat.o(80151);
        return;
      }
      try
      {
        WebViewUI.this.vf(WebViewUI.this.bQR());
        if (!WebViewUI.this.omW.isXWalkKernel())
        {
          WebViewUI.this.omW.setVisibility(0);
          WebViewUI.this.setTitleVisibility(0);
        }
        for (;;)
        {
          if (WebViewUI.this.EcJ != null) {
            WebViewUI.this.EcJ.removeView(WebViewUI.l(WebViewUI.this));
          }
          WebViewUI.a(WebViewUI.this, null);
          if (WebViewUI.n(WebViewUI.this) != null) {
            WebViewUI.n(WebViewUI.this).onCustomViewHidden();
          }
          AppMethodBeat.o(80151);
          return;
          WebViewUI.this.fullScreenNoTitleBar(false);
          WebViewUI.this.setStatusBarColor(WebViewUI.this.getResources().getColor(2131100952));
          if (WebViewUI.this.Eej != null)
          {
            ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)WebViewUI.this.Eej.getLayoutParams();
            int i = WebViewUI.m(WebViewUI.this);
            if (i != localMarginLayoutParams.topMargin)
            {
              localMarginLayoutParams.topMargin = i;
              WebViewUI.this.Eej.setLayoutParams(localMarginLayoutParams);
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
        if (WebViewUI.l(WebViewUI.this) != null)
        {
          paramCustomViewCallback.onCustomViewHidden();
          AppMethodBeat.o(80150);
          return;
        }
        WebViewUI.this.vf(false);
        WebViewUI.a(WebViewUI.this, paramView);
        WebViewUI.b(WebViewUI.this, paramCustomViewCallback);
        if (!WebViewUI.this.omW.isXWalkKernel())
        {
          WebViewUI.this.omW.setVisibility(8);
          WebViewUI.this.EcJ.addView(paramView);
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
      WebViewUI.this.EcJ.addView(paramView, 0);
      WebViewUI.this.fullScreenNoTitleBar(true);
      WebViewUI.this.setStatusBarColor(0);
      if (WebViewUI.this.Eej != null)
      {
        paramView = (ViewGroup.MarginLayoutParams)WebViewUI.this.Eej.getLayoutParams();
        paramView.topMargin = 0;
        WebViewUI.this.Eej.setLayoutParams(paramView);
      }
      AppMethodBeat.o(80150);
    }
    
    public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      AppMethodBeat.i(80154);
      WebViewUI.p(WebViewUI.this).a(WebViewUI.this, WebViewUI.this.lvw, paramValueCallback, null, paramString1, paramString2);
      AppMethodBeat.o(80154);
    }
  }
  
  public final class c
    extends com.tencent.mm.plugin.webview.core.j
  {
    public c() {}
    
    public final boolean c(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(208098);
      ad.e("MicroMsg.WebViewUI", "edw interceptLoadError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1, Boolean.valueOf(com.tencent.mm.sdk.platformtools.ay.isConnected(WebViewUI.this)) });
      AppMethodBeat.o(208098);
      return false;
    }
    
    public final boolean eNO()
    {
      AppMethodBeat.i(208099);
      if ((WebViewUI.this.EdI) || (WebViewUI.s(WebViewUI.this)) || (WebViewUI.this.isFinishing()))
      {
        AppMethodBeat.o(208099);
        return true;
      }
      AppMethodBeat.o(208099);
      return false;
    }
    
    public final com.tencent.mm.plugin.webview.core.e eNP()
    {
      AppMethodBeat.i(208100);
      a locala = new a((byte)0);
      AppMethodBeat.o(208100);
      return locala;
    }
    
    public final com.tencent.mm.plugin.webview.core.i eNQ()
    {
      AppMethodBeat.i(208101);
      b localb = new b((byte)0);
      AppMethodBeat.o(208101);
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
        WebViewUI.this.EdR.Ebh = false;
      }
      
      public final void aGk(String paramString)
      {
        AppMethodBeat.i(208078);
        if (!WebViewUI.this.Eer) {
          WebViewUI.this.EdR.eSg();
        }
        WebViewUI.this.Een.eSn();
        WebViewUI.this.Een.setCurrentURL(paramString);
        WebViewUI.this.setProgressBarIndeterminateVisibility(false);
        WebViewUI.this.EdR.f(paramString, WebViewUI.this.getIntent());
        WebViewUI.this.vh(false);
        n localn;
        if ((WebViewUI.this.EdY != null) && (!WebViewUI.this.EdY.EeI))
        {
          localn = WebViewUI.this.EdY;
          ad.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageStart, url:%s", new Object[] { paramString });
          localn.mue = paramString;
          localn.eTs();
          paramString = (Bundle)n.EaX.get(n.WQ(localn.mue));
          if ((paramString != null) && (localn.EeJ != null)) {
            break label219;
          }
          localn.eTz();
        }
        for (;;)
        {
          WebViewUI.t(WebViewUI.this);
          AppMethodBeat.o(208078);
          return;
          label219:
          if (paramString.getBoolean("key_current_info_show")) {
            localn.eTy();
          } else {
            localn.eTz();
          }
        }
      }
      
      public final void aGl(String paramString)
      {
        AppMethodBeat.i(208080);
        WebViewUI.this.Een.eSn();
        if ((WebViewUI.v(WebViewUI.this) != null) && (com.tencent.mm.sdk.platformtools.ay.isNetworkConnected(WebViewUI.this.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8")))
        {
          WebViewUI.v(WebViewUI.this).eA("rawUrl", paramString);
          WebViewUI.v(WebViewUI.this).aGX(paramString);
        }
        WebViewUI.d(WebViewUI.this, paramString);
        WebViewUI.this.vf(WebViewUI.this.bQR());
        AppMethodBeat.o(208080);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(208079);
        WebViewUI.u(WebViewUI.this);
        if ((WebViewUI.v(WebViewUI.this) != null) && (com.tencent.mm.sdk.platformtools.ay.isNetworkConnected(WebViewUI.this.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8")))
        {
          WebViewUI.v(WebViewUI.this).eA("rawUrl", paramString);
          WebViewUI.v(WebViewUI.this).aGX(paramString);
        }
        WebViewUI.d(WebViewUI.this, paramString);
        if (!WebViewUI.w(WebViewUI.this))
        {
          WebViewUI.x(WebViewUI.this);
          WebViewUI.this.DIg.eQE().loadFinished = true;
        }
        Object localObject = WebViewUI.this.omW.getTitle();
        ad.i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", new Object[] { WebViewUI.this.getMMTitle(), localObject, Boolean.valueOf(WebViewUI.this.Ecy), Boolean.valueOf(WebViewUI.this.yyS), WebViewUI.this.eSK() });
        if ((WebViewUI.c.this.controller.omW.getIsX5Kernel()) && (!bt.isNullOrNil((String)localObject)) && (((String)localObject).length() > 0) && (!((String)localObject).equals(WebViewUI.this.getMMTitle())) && (!((String)localObject).startsWith("http")) && ((WebViewUI.this.eSK() == null) || (!WebViewUI.this.eSK().equals(localObject))) && (!WebViewUI.this.Ecy) && (WebViewUI.this.yyS))
        {
          ad.d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
          WebViewUI.this.setMMTitle((String)localObject);
        }
        WebViewUI.this.Een.setCurrentURL(WebViewUI.this.eNy());
        WebViewUI.this.setProgressBarIndeterminateVisibility(false);
        WebViewUI.this.EcA.finish();
        if ((WebViewUI.this.EdY != null) && (!WebViewUI.this.EdY.EeI))
        {
          localObject = WebViewUI.this.EdY;
          ad.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", new Object[] { paramString });
          ((n)localObject).mue = paramString;
        }
        WebViewUI.e(WebViewUI.this, paramString);
        WebViewUI.this.b(paramWebView, paramString);
        AppMethodBeat.o(208079);
      }
      
      public final void e(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(208081);
        super.e(paramWebView, paramString);
        paramWebView = WebViewUI.this.EdY;
        ad.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", new Object[] { paramString });
        paramWebView.mue = paramString;
        AppMethodBeat.o(208081);
      }
    }
    
    final class b
      extends com.tencent.mm.plugin.webview.core.i
    {
      private b() {}
      
      public final void Wv(int paramInt)
      {
        AppMethodBeat.i(208094);
        if (WebViewUI.this.EcG != null)
        {
          FontChooserView localFontChooserView = (FontChooserView)WebViewUI.this.EcG.findViewById(2131300194);
          if (localFontChooserView != null) {
            localFontChooserView.setSliderIndex(paramInt - 1);
          }
        }
        AppMethodBeat.o(208094);
      }
      
      public final void a(String paramString, avj paramavj)
      {
        AppMethodBeat.i(208085);
        if (!bt.isNullOrNil(paramavj.Title)) {
          WebViewUI.this.setMMTitle(paramavj.Title);
        }
        if (paramavj.FqN == 6) {
          WebViewUI.this.vg(false);
        }
        AppMethodBeat.o(208085);
      }
      
      public final void aGt(String paramString)
      {
        AppMethodBeat.i(208084);
        WebViewUI.this.bQT();
        AppMethodBeat.o(208084);
      }
      
      public final void aGu(String paramString)
      {
        AppMethodBeat.i(208092);
        WebViewUI.this.aIN(paramString);
        AppMethodBeat.o(208092);
      }
      
      public final void b(String paramString, avj paramavj)
      {
        WebViewUI.this.EdR.Ebe = paramavj.GtH;
      }
      
      public final void bRf()
      {
        AppMethodBeat.i(208087);
        WebViewUI.this.vh(true);
        AppMethodBeat.o(208087);
      }
      
      public final void bn(int paramInt, String paramString)
      {
        AppMethodBeat.i(208082);
        super.bn(paramInt, paramString);
        if (paramInt != 5) {
          WebViewUI.this.vh(false);
        }
        AppMethodBeat.o(208082);
      }
      
      public final void c(String paramString, avj paramavj)
      {
        AppMethodBeat.i(208086);
        WebViewUI.this.omw = paramavj.Guc;
        WebViewUI.b(WebViewUI.this, WebViewUI.this.lvw.eRg().mz(24));
        WebViewUI.this.DIg.eQE().DVc = true;
        WebViewUI.this.Ede = com.tencent.mm.platformtools.z.a(paramavj.Gub);
        ad.d("MicroMsg.WebViewUI", "onPermissionUpdate, getA8Key = %s", new Object[] { bt.cE(WebViewUI.this.Ede) });
        AppMethodBeat.o(208086);
      }
      
      public final void d(int paramInt1, String paramString1, int paramInt2, String paramString2)
      {
        AppMethodBeat.i(208095);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(154L, 12L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(154L, com.tencent.mm.plugin.webview.h.a.WY(paramInt1), 1L, false);
        WebViewUI.this.vh(true);
        WebViewUI.this.EdR.Ebh = false;
        switch (paramInt1)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(208095);
          return;
          k.EbJ.Xx(paramInt2);
          if ((WebViewUI.this.Edx != null) && (this.controller.eNv())) {
            WebViewUI.this.eTc();
          }
          WebViewUI.this.DIg.eQE().DVc = false;
          WebViewUI.this.DIg.eQy().co(paramString1, false);
          if (WebViewUI.A(WebViewUI.this)) {
            WebViewUI.this.finish();
          }
        }
      }
      
      public final void dWE()
      {
        AppMethodBeat.i(208088);
        if (WebViewUI.this.EdL)
        {
          ad.e("MicroMsg.WebViewUI", "edw postBinded hasDoPostBind");
          AppMethodBeat.o(208088);
          return;
        }
        WebViewUI.this.EdL = true;
        WebViewUI.this.bzn();
        AppMethodBeat.o(208088);
      }
      
      public final void eNJ()
      {
        AppMethodBeat.i(208083);
        ad.i("MicroMsg.WebViewUI", "WebView-Trace onAuthSucc: url %s", new Object[] { WebViewUI.this.omw });
        WebViewUI.a(WebViewUI.this, this.controller.lvw.eRg());
        if (!WebViewUI.this.Eer) {
          WebViewUI.this.EdR.Ebh = true;
        }
        i locali = WebViewUI.this.EdR;
        locali.Ebi.add(Integer.valueOf(6));
        locali.Ebi.add(Integer.valueOf(1));
        locali.Ebi.add(Integer.valueOf(3));
        locali.Ebi.add(Integer.valueOf(2));
        WebViewUI.this.EdR.Ebh = true;
        if (WebViewUI.this.EdR.orZ) {
          WebViewUI.this.bQS();
        }
        AppMethodBeat.o(208083);
      }
      
      public final void eNK()
      {
        AppMethodBeat.i(208089);
        WebViewUI.this.goBack();
        AppMethodBeat.o(208089);
      }
      
      public final void eNL()
      {
        AppMethodBeat.i(208091);
        WebViewUI.this.eSN();
        AppMethodBeat.o(208091);
      }
      
      public final void eNM()
      {
        AppMethodBeat.i(208096);
        super.eNM();
        if ((!WebViewUI.this.EdC) && (!WebViewUI.this.EdD)) {
          WebViewUI.this.EcA.start();
        }
        AppMethodBeat.o(208096);
      }
      
      public final void eNN()
      {
        AppMethodBeat.i(208097);
        super.eNN();
        WebViewUI.this.EcA.finish();
        AppMethodBeat.o(208097);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(208090);
        WebViewUI.this.finish();
        AppMethodBeat.o(208090);
      }
      
      public final void uT(boolean paramBoolean)
      {
        AppMethodBeat.i(208093);
        if ((paramBoolean) && (WebViewUI.this.omW != null))
        {
          WebViewUI.this.omW.setOnLongClickListener(WebViewUI.y(WebViewUI.this));
          WebViewUI.z(WebViewUI.this);
        }
        AppMethodBeat.o(208093);
      }
    }
  }
  
  final class d
    implements FontChooserView.a
  {
    private d() {}
    
    public final void Pe(int paramInt)
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
        WebViewUI.this.DIv.Wu(i);
        try
        {
          if (WebViewUI.this.lvv.eRt())
          {
            ax localax = ax.gh("WebViewFontUtil", 2);
            localax.putBoolean("webview_key_font_has_set", true);
            localax.putBoolean("webview_key_has_transfer_mp", true);
            localax.apply();
            com.tencent.mm.plugin.webview.j.f.vu(false);
            WebViewUI.this.lvv.jb(16384, i);
            WebViewUI.this.lvv.jb(16388, i);
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
    final WeakReference<WebViewUI> lVh;
    
    public e(WebViewUI paramWebViewUI)
    {
      AppMethodBeat.i(80216);
      this.lVh = new WeakReference(paramWebViewUI);
      this.id = paramWebViewUI.eNj();
      AppMethodBeat.o(80216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI
 * JD-Core Version:    0.7.0.1
 */