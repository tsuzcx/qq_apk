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
import com.tencent.mm.ah.y;
import com.tencent.mm.g.a.td;
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
import com.tencent.mm.plugin.webview.model.ay.f;
import com.tencent.mm.plugin.webview.model.ay.g;
import com.tencent.mm.plugin.webview.model.ay.j;
import com.tencent.mm.plugin.webview.model.ay.l;
import com.tencent.mm.plugin.webview.model.b.1;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.i;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.q;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.MPSmileyFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.model.w.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bi.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
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
import com.tencent.xweb.ac;
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
  implements View.OnCreateContextMenuListener, com.tencent.mm.plugin.webview.core.b, com.tencent.mm.plugin.webview.g.a.b, com.tencent.mm.plugin.webview.ui.tools.video.samelayer.e, bi.a, MMWebView.e
{
  private static final Pattern EgZ;
  private static final Pattern Eha;
  protected static int EvJ;
  private static final ArrayList<e> Evk;
  private static WebSettings.RenderPriority Evp;
  private static Boolean Ewk;
  public com.tencent.mm.plugin.webview.c.f DRx;
  public com.tencent.mm.plugin.webview.model.ay Eae;
  protected com.tencent.mm.plugin.webview.core.h Eat;
  protected com.tencent.mm.plugin.webview.stub.f EfN;
  final com.tencent.mm.plugin.webview.modeltools.a EsR;
  private View Esx;
  protected boolean EuA;
  private boolean EuB;
  protected MMFalseProgressBar EuC;
  public ProgressBar EuD;
  public com.tencent.mm.ui.base.p EuE;
  private g EuF;
  private ImageButton EuG;
  private ImageButton EuH;
  protected View EuI;
  protected WebViewKeyboardLinearLayout EuJ;
  protected FrameLayout EuK;
  public FrameLayout EuL;
  protected MovingImageButton EuM;
  protected boolean EuN;
  private boolean EuO;
  protected com.tencent.mm.bo.a EuP;
  private WebViewRedesignInputFooter EuQ;
  protected WebViewSearchContentInputFooter EuR;
  private boolean EuS;
  private boolean EuT;
  public String EuU;
  protected boolean EuV;
  protected boolean EuW;
  protected long EuX;
  private boolean EuY;
  private int EuZ;
  protected String EvA;
  private boolean EvB;
  private final boolean EvC;
  private boolean EvD;
  protected volatile boolean EvE;
  protected boolean EvF;
  private Map EvG;
  private int EvH;
  public int EvI;
  public boolean EvK;
  private boolean EvL;
  private boolean EvM;
  protected boolean EvN;
  protected volatile boolean EvO;
  private com.tencent.mm.plugin.webview.j.i EvP;
  private com.tencent.mm.plugin.webview.model.b EvQ;
  protected com.tencent.mm.plugin.webview.modeltools.n EvR;
  protected h EvS;
  public i EvT;
  protected IUtils EvU;
  private WebViewClipBoardHelper EvV;
  protected com.tencent.mm.plugin.webview.c EvW;
  protected volatile String EvX;
  protected volatile long EvY;
  protected HandOffURL EvZ;
  int Eva;
  private boolean Evb;
  protected boolean Evc;
  private boolean Evd;
  protected boolean Eve;
  protected int Evf;
  protected byte[] Evg;
  private boolean Evh;
  private View Evi;
  private com.tencent.mm.sdk.platformtools.aw Evj;
  private boolean Evl;
  private WebChromeClient.CustomViewCallback Evm;
  protected com.tencent.xweb.x Evn;
  private ProgressBar Evo;
  public com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h Evq;
  private final com.tencent.mm.sdk.b.c<SendDataToH5FromMiniProgramEvent> Evr;
  private boolean Evs;
  protected HashMap<String, Boolean> Evt;
  protected HashMap<String, String> Evu;
  protected HashMap<String, ArrayList<d.b>> Evv;
  protected HashMap<String, Boolean> Evw;
  protected a Evx;
  protected com.tencent.mm.ui.widget.a.d Evy;
  protected View Evz;
  public n Ewa;
  com.tencent.mm.plugin.webview.ui.tools.floatball.a Ewb;
  private boolean Ewc;
  protected ab Ewd;
  private com.tencent.mm.sdk.b.c<td> Ewe;
  private com.tencent.mm.plugin.webview.ui.tools.widget.n Ewf;
  private boolean Ewg;
  private MPVideoPlayFullScreenView Ewh;
  int Ewi;
  private boolean Ewj;
  protected View Ewl;
  private View Ewm;
  private com.tencent.mm.bo.a.b Ewn;
  private boolean Ewo;
  public final j Ewp;
  public final com.tencent.mm.plugin.webview.ui.tools.media.e Ewq;
  private boolean Ewr;
  private View.OnLongClickListener Ews;
  protected boolean Ewt;
  private View.OnLongClickListener Ewu;
  protected View.OnLongClickListener Ewv;
  private String Eww;
  protected volatile String Ewx;
  private WebChromeClient.CustomViewCallback Ewy;
  public int Ewz;
  public String dIz;
  private com.tencent.mm.ui.base.p fPj;
  public aq handler;
  private final com.tencent.mm.plugin.webview.modeltools.d lAd;
  public com.tencent.mm.plugin.webview.stub.e lzT;
  protected com.tencent.mm.plugin.webview.e.g lzU;
  private int mKJ;
  protected int oef;
  protected int oeg;
  private int omK;
  public MMWebView osM;
  public String osm;
  protected int screenOrientation;
  protected String sessionId;
  protected com.tencent.mm.ui.widget.snackbar.a.b ufz;
  public int uxp;
  public String uxq;
  private long vIW;
  private View vd;
  protected boolean yOS;
  
  static
  {
    AppMethodBeat.i(80400);
    Evk = new ArrayList();
    Evp = WebSettings.RenderPriority.NORMAL;
    EvJ = 0;
    Ewk = null;
    EgZ = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    Eha = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    AppMethodBeat.o(80400);
  }
  
  public WebViewUI()
  {
    AppMethodBeat.i(80217);
    this.EuA = false;
    this.EuB = false;
    this.screenOrientation = -1;
    this.EuN = false;
    this.EuO = false;
    this.EuU = null;
    this.EuV = true;
    this.EuW = false;
    this.EuX = 0L;
    this.EuY = false;
    this.sessionId = "";
    this.Eva = -1;
    this.yOS = true;
    this.Evb = false;
    this.Evc = true;
    this.Evd = false;
    this.Eve = false;
    this.Evg = new byte[0];
    this.DRx = null;
    this.Evh = false;
    this.Evl = false;
    this.lzU = null;
    this.Evq = new com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h(this);
    this.Evr = new com.tencent.mm.sdk.b.c() {};
    this.Evs = false;
    this.lzT = null;
    this.Eat = null;
    this.Evt = new HashMap();
    this.Evu = new HashMap();
    this.Evv = new HashMap();
    this.Evw = new HashMap();
    this.Evy = null;
    this.Evz = null;
    this.EvA = null;
    this.EvB = false;
    this.EvC = true;
    this.EvD = false;
    this.uxp = 0;
    this.uxq = null;
    this.EvE = false;
    this.EvF = false;
    this.EvH = 0;
    this.EvI = ((int)(System.currentTimeMillis() / 1000L));
    this.EvK = false;
    this.EvL = false;
    this.EvM = false;
    this.EvN = false;
    this.EvO = false;
    this.Eae = new com.tencent.mm.plugin.webview.model.ay();
    this.EvP = new com.tencent.mm.plugin.webview.j.i();
    this.EvR = new com.tencent.mm.plugin.webview.modeltools.n();
    this.EvU = null;
    this.Ewc = false;
    this.Ewd = new ab()
    {
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(80053);
        if (WebViewUI.this.osM == null)
        {
          AppMethodBeat.o(80053);
          return false;
        }
        com.tencent.mm.plugin.webview.model.ak localak = WebViewUI.this.Eae.eUo();
        if (paramAnonymousInt4 > localak.Emc) {
          localak.Emc = paramAnonymousInt4;
        }
        localak.AFq = paramAnonymousInt6;
        paramAnonymousBoolean = WebViewUI.this.osM.c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
        AppMethodBeat.o(80053);
        return paramAnonymousBoolean;
      }
      
      public final void bpP()
      {
        AppMethodBeat.i(80054);
        if (WebViewUI.this.osM == null)
        {
          AppMethodBeat.o(80054);
          return;
        }
        WebViewUI.this.osM.fPV();
        AppMethodBeat.o(80054);
      }
      
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(80055);
        if (WebViewUI.this.osM == null)
        {
          AppMethodBeat.o(80055);
          return;
        }
        WebViewUI.this.osM.i(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
        if ((paramAnonymousBoolean2) && (WebViewUI.this.Eae != null)) {
          WebViewUI.this.Eae.w("mm_scroll_bottom", Boolean.TRUE);
        }
        AppMethodBeat.o(80055);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(80056);
        if (WebViewUI.this.osM == null)
        {
          AppMethodBeat.o(80056);
          return;
        }
        WebViewUI.this.osM.S(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        WebViewUI.this.onWebViewScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(80056);
      }
      
      public final boolean x(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80052);
        if (WebViewUI.this.osM == null)
        {
          AppMethodBeat.o(80052);
          return false;
        }
        boolean bool = WebViewUI.this.osM.af(paramAnonymousMotionEvent);
        AppMethodBeat.o(80052);
        return bool;
      }
      
      public final boolean y(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80057);
        if (WebViewUI.this.osM == null)
        {
          AppMethodBeat.o(80057);
          return false;
        }
        boolean bool = WebViewUI.this.osM.ag(paramAnonymousMotionEvent);
        AppMethodBeat.o(80057);
        return bool;
      }
      
      public final boolean z(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80058);
        if (WebViewUI.this.osM == null)
        {
          AppMethodBeat.o(80058);
          return false;
        }
        boolean bool = WebViewUI.this.osM.ah(paramAnonymousMotionEvent);
        AppMethodBeat.o(80058);
        return bool;
      }
    };
    this.Ewe = new com.tencent.mm.sdk.b.c()
    {
      private boolean eXc()
      {
        AppMethodBeat.i(80075);
        if (WebViewUI.this.lzT == null)
        {
          ae.e("MicroMsg.WebViewUI", "Cli Event, invoker is null");
          AppMethodBeat.o(80075);
          return false;
        }
        if ((WebViewUI.this.EvX == null) || (WebViewUI.this.EvX.length() == 0))
        {
          ae.e("MicroMsg.WebViewUI", "Cli Event, tid is null");
          AppMethodBeat.o(80075);
          return false;
        }
        try
        {
          long l = System.currentTimeMillis();
          ae.i("MicroMsg.WebViewUI", "Cli Event, tid = %s, stime = %d, etime = %d", new Object[] { WebViewUI.this.EvX, Long.valueOf(WebViewUI.this.EvY), Long.valueOf(l) });
          Bundle localBundle = new Bundle();
          localBundle.putString("service_click_tid", new String(WebViewUI.this.EvX));
          localBundle.putLong("service_click_stime", WebViewUI.this.EvY);
          localBundle.putLong("service_click_etime", l);
          WebViewUI.this.lzT.y(2836, localBundle);
          WebViewUI.this.EvX = null;
          AppMethodBeat.o(80075);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("MicroMsg.WebViewUI", "Cli Event Exception, msg = %s", new Object[] { localException.getMessage() });
          }
        }
      }
    };
    this.Ewg = false;
    this.Ewi = 0;
    this.Ewj = true;
    this.vIW = 0L;
    this.omK = 0;
    this.Ewn = new com.tencent.mm.bo.a.b()
    {
      public final void a(com.tencent.mm.bo.a.a paramAnonymousa1, com.tencent.mm.bo.a.a paramAnonymousa2)
      {
        AppMethodBeat.i(198254);
        ae.i("MicroMsg.WebViewUI", "OrientationListener lastOrientation:" + paramAnonymousa1.name() + "; newOrientation:" + paramAnonymousa2.name());
        WebViewUI.this.screenOrientation = 4;
        WebViewUI.this.setMMOrientation();
        if (WebViewUI.this.EuP != null) {
          WebViewUI.this.EuP.disable();
        }
        AppMethodBeat.o(198254);
      }
    };
    this.Ewo = false;
    this.Ewp = new j();
    this.lAd = new com.tencent.mm.plugin.webview.modeltools.d();
    this.EsR = new com.tencent.mm.plugin.webview.modeltools.a();
    this.Ewq = new com.tencent.mm.plugin.webview.ui.tools.media.e();
    this.Ews = new View.OnLongClickListener()
    {
      private boolean eXb()
      {
        boolean bool2 = true;
        AppMethodBeat.i(198234);
        Object localObject = null;
        try
        {
          WebView.b localb = WebViewUI.this.osM.getHitTestResult();
          localObject = localb;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ae.e("MicroMsg.WebViewUI", "getHitTestResult exp %s", new Object[] { localException1.getMessage() });
          }
        }
        if ((localObject == null) || (bu.isNullOrNil(localObject.mExtra)))
        {
          ae.e("MicroMsg.WebViewUI", "hittestresult getExtra is null");
          AppMethodBeat.o(198234);
          return false;
        }
        try
        {
          bool1 = WebViewUI.this.lzT.fK(localObject.mExtra);
          if (!bool1) {}
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            label137:
            boolean bool1 = true;
            ae.w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + localException2.getMessage());
          }
        }
        try
        {
          WebViewUI.this.lzT.fW(localObject.mExtra, WebViewUI.this.eQU());
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
        AppMethodBeat.o(198234);
        return bool1;
      }
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198233);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$29", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        if (WebViewUI.this.getIntent().getBooleanExtra("show_long_click_popup_menu", true))
        {
          boolean bool = eXb();
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$29", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(198233);
          return bool;
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$29", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(198233);
        return true;
      }
    };
    this.Ewt = false;
    this.Ewv = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198238);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$33", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        if ((WebViewUI.e(WebViewUI.this) != null) && ((com.tencent.mm.sdk.platformtools.j.DEBUG) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (bv.fpT())))
        {
          boolean bool = WebViewUI.e(WebViewUI.this).onLongClick(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$33", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(198238);
          return bool;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$33", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(198238);
        return false;
      }
    };
    this.Ewx = "";
    this.ufz = new com.tencent.mm.ui.widget.snackbar.a.b()
    {
      public final void biY()
      {
        AppMethodBeat.i(198250);
        try
        {
          WebViewUI.this.lzT.favEditTag();
          AppMethodBeat.o(198250);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + localException.getMessage());
          AppMethodBeat.o(198250);
        }
      }
    };
    this.Ewz = -1;
    AppMethodBeat.o(80217);
  }
  
  private void a(JsapiPermissionWrapper paramJsapiPermissionWrapper)
  {
    AppMethodBeat.i(198305);
    if (paramJsapiPermissionWrapper != null)
    {
      if (paramJsapiPermissionWrapper.mC(34))
      {
        setMMSubTitle(2131766182);
        AppMethodBeat.o(198305);
        return;
      }
      if (paramJsapiPermissionWrapper.mC(75))
      {
        setMMSubTitle(2131766195);
        AppMethodBeat.o(198305);
        return;
      }
      setMMSubTitle(null);
    }
    AppMethodBeat.o(198305);
  }
  
  private void aKh(String paramString)
  {
    AppMethodBeat.i(80239);
    if ((this.Ewb != null) && (!bu.isNullOrNil(paramString)) && (!com.tencent.mm.plugin.webview.ui.tools.floatball.a.isMpUrl(bRn()))) {
      this.Ewb.WY(paramString);
    }
    AppMethodBeat.o(80239);
  }
  
  private void aKi(String paramString)
  {
    AppMethodBeat.i(80240);
    if ((this.EvZ != null) && (!bu.isNullOrNil(paramString)) && (!com.tencent.mm.plugin.webview.ui.tools.floatball.a.isMpUrl(bRn())) && (!this.EvZ.title.equals(paramString)))
    {
      this.EvZ.setTitle(paramString);
      if (eSW()) {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.EvZ);
      }
    }
    AppMethodBeat.o(80240);
  }
  
  private static String aKj(String paramString)
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
      ae.e("MicroMsg.WebViewUI", "getFileNameFromContentDisposition error " + paramString.getMessage());
      AppMethodBeat.o(80299);
    }
    return null;
  }
  
  private void abj(String paramString)
  {
    AppMethodBeat.i(80241);
    if (this.DRx != null)
    {
      this.DRx.aIc(paramString);
      try
      {
        if (paramString.equals("onPause"))
        {
          this.lzT.XT(this.Eat.eQU());
          AppMethodBeat.o(80241);
          return;
        }
        if (paramString.equals("onResume")) {
          this.lzT.XS(this.Eat.eQU());
        }
        AppMethodBeat.o(80241);
        return;
      }
      catch (Exception paramString)
      {
        ae.w("MicroMsg.WebViewUI", "onResume, ex = " + paramString.getMessage());
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
  
  private boolean eVu()
  {
    boolean bool1 = false;
    AppMethodBeat.i(80298);
    try
    {
      if (this.lzT == null)
      {
        ae.w("MicroMsg.WebViewUI", "invoker is null");
        AppMethodBeat.o(80298);
        return false;
      }
      boolean bool2 = this.lzT.eVu();
      bool1 = bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ae.e("MicroMsg.WebViewUI", "unable get config for WebViewDownLoadFile" + localRemoteException.getMessage());
      }
    }
    AppMethodBeat.o(80298);
    return bool1;
  }
  
  private void eWO()
  {
    AppMethodBeat.i(80316);
    if (this.Evi != null) {
      this.Evi.setVisibility(8);
    }
    if (this.Evj != null) {
      this.Evj.stopTimer();
    }
    AppMethodBeat.o(80316);
  }
  
  private boolean eWS()
  {
    AppMethodBeat.i(80355);
    int i = getIntent().getIntExtra("key_close_action", 0);
    Object localObject = getIntent().getBundleExtra("key_close_data");
    ae.i("MicroMsg.WebViewUI", "close action %s", new Object[] { Integer.valueOf(i) });
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
        } while (bu.V(new String[] { str2, str3, str4 }));
        if (bool) {
          com.tencent.mm.ui.base.h.a(this, str1, str2, str3, str4, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(198248);
              WebViewUI.this.EvK = true;
              k.EtK.close();
              WebViewUI.this.finish();
              AppMethodBeat.o(198248);
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
              AppMethodBeat.i(198249);
              WebViewUI.this.EvK = true;
              k.EtK.close();
              WebViewUI.this.finish();
              AppMethodBeat.o(198249);
            }
          });
        }
      } while (localObject == null);
      str1 = ((Bundle)localObject).getString("close_jump_url");
      i = ((Bundle)localObject).getInt("close_jump_url_request_code", 0);
    } while (bu.isNullOrNil(str1));
    localObject = new Intent(this, WebViewUI.class);
    ((Intent)localObject).putExtra("rawUrl", str1);
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("show_bottom", false);
    ((Intent)localObject).putExtra("needRedirect", false);
    ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
    ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
    startActivityForResult((Intent)localObject, i);
    com.tencent.mm.ui.base.b.km(this);
    AppMethodBeat.o(80355);
    return true;
  }
  
  private void eWU()
  {
    AppMethodBeat.i(80357);
    if (this.EvM)
    {
      ae.d("MicroMsg.WebViewUI", "SwipeBackFinish, do not LaunchOuterApp");
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
  
  private com.tencent.mm.plugin.webview.model.b eWh()
  {
    AppMethodBeat.i(198279);
    if (this.EvQ == null) {
      this.EvQ = new com.tencent.mm.plugin.webview.model.b(this.Eae);
    }
    com.tencent.mm.plugin.webview.model.b localb = this.EvQ;
    AppMethodBeat.o(198279);
    return localb;
  }
  
  private static boolean eWp()
  {
    AppMethodBeat.i(80248);
    if (Ewk == null) {}
    try
    {
      if (bu.getInt(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_webview_force_dark_disable", "0", false, true), 1) > 0) {
        ae.i("MicroMsg.WebViewUI", "disableForceDark on!!");
      }
      for (Ewk = Boolean.TRUE;; Ewk = Boolean.FALSE)
      {
        boolean bool = Ewk.booleanValue();
        AppMethodBeat.o(80248);
        return bool;
        ae.i("MicroMsg.WebViewUI", "disableForceDark close!!");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.WebViewUI", localException, "disableForceDark", new Object[0]);
        Ewk = Boolean.FALSE;
      }
    }
  }
  
  private boolean eWr()
  {
    return (this.EuN) || (this.EuO);
  }
  
  private int eWs()
  {
    AppMethodBeat.i(80252);
    if (this.EvC) {}
    for (int i = 0; (getSupportActionBar() == null) || (!getSupportActionBar().isShowing()); i = this.mKJ)
    {
      AppMethodBeat.o(80252);
      return i;
    }
    int j = getActionBarHeight();
    AppMethodBeat.o(80252);
    return i + j;
  }
  
  private View eWy()
  {
    AppMethodBeat.i(80264);
    View localView = null;
    try
    {
      i = Resources.getSystem().getIdentifier("action_bar_container", "id", "android");
      if (i > 0) {
        localView = findViewById(i);
      }
      ae.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", new Object[] { Integer.valueOf(i), localView });
      AppMethodBeat.o(80264);
      return localView;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.WebViewUI", "get resId action_bar_container, exp = %s", new Object[] { localException });
        int i = -1;
      }
    }
  }
  
  private static void fL(View paramView)
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
  
  private void updateOrientation()
  {
    AppMethodBeat.i(198295);
    if (this.lzT != null) {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("screen_orientation", this.screenOrientation);
        this.lzT.k(83, localBundle);
        AppMethodBeat.o(198295);
        return;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.WebViewUI", "ac_set_screen_orientation : " + localException.getMessage());
      }
    }
    AppMethodBeat.o(198295);
  }
  
  private void vg(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.Evl = true;
    }
  }
  
  public final void CQ(long paramLong)
  {
    AppMethodBeat.i(198298);
    this.EvT.CQ(paramLong);
    AppMethodBeat.o(198298);
  }
  
  protected void R(Bundle paramBundle)
  {
    AppMethodBeat.i(198308);
    this.EvT.eVX();
    AppMethodBeat.o(198308);
  }
  
  public final void X(String paramString, long paramLong)
  {
    AppMethodBeat.i(198280);
    if ((this.DRx != null) && (this.osM != null))
    {
      Object localObject1 = this.DRx;
      this.osM.getUrl();
      Object localObject2 = getIntent();
      if ((this.lzU.eUT().FFZ & 0x100000) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ae.d("MicroMsg.GeneralControlWrapper", "allowOnScreenShot, ret = ".concat(String.valueOf(bool)));
        if (!((com.tencent.mm.plugin.webview.c.f)localObject1).BZx) {
          break label388;
        }
        ae.i("MicroMsg.JsApiHandler", "onScreenShot hasPermission: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramString = l.a.b("onScreenShot", new HashMap(), ((com.tencent.mm.plugin.webview.c.f)localObject1).EeC, ((com.tencent.mm.plugin.webview.c.f)localObject1).vVT);
          ((com.tencent.mm.plugin.webview.c.f)localObject1).Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
        }
        paramString = ((com.tencent.mm.plugin.webview.c.f)localObject1).aHX(((com.tencent.mm.plugin.webview.c.f)localObject1).getCurrentUrl());
        if (localObject2 == null) {
          break label388;
        }
        try
        {
          localObject1 = ((com.tencent.mm.plugin.webview.c.f)localObject1).getCurrentUrl();
          localObject2 = ((Intent)localObject2).getBundleExtra("ad_report_bundle");
          if ((!bu.isNullOrNil((String)localObject1)) && (localObject2 != null))
          {
            localObject2 = ((Bundle)localObject2).getString("ad_report_ux_info");
            if (!bu.isNullOrNil((String)localObject2))
            {
              int i = (int)(System.currentTimeMillis() / 1000L);
              Object localObject3 = Uri.parse((String)localObject1);
              String str = ((Uri)localObject3).getQueryParameter("mid");
              localObject3 = ((Uri)localObject3).getQueryParameter("idx");
              ae.i("MicroMsg.JsApiHandler", "alvinluo reportAdOnScreenShot appId: %s, mid: %s, idx: %s, adUxInfo: %s, url: %s", new Object[] { paramString, str, localObject3, localObject2, localObject1 });
              com.tencent.mm.plugin.report.service.g.yxI.f(19213, new Object[] { Integer.valueOf(i), Integer.valueOf(6), localObject2, paramString, str, localObject3, localObject1 });
            }
          }
          AppMethodBeat.o(198280);
          return;
        }
        catch (Exception paramString)
        {
          ae.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "alvinluo reportAdOnScreenShot exception", new Object[0]);
        }
      }
    }
    label388:
    AppMethodBeat.o(198280);
  }
  
  protected void Xp(int paramInt)
  {
    AppMethodBeat.i(80351);
    if ((this.osM == null) || (this.osM.getSettings() == null))
    {
      AppMethodBeat.o(80351);
      return;
    }
    ae.i("MicroMsg.WebViewUI", "localSetFontSize, fontSize = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      this.osM.getSettings().setTextZoom(100);
      AppMethodBeat.o(80351);
      return;
    case 1: 
      this.osM.getSettings().setTextZoom(80);
      AppMethodBeat.o(80351);
      return;
    case 2: 
      this.osM.getSettings().setTextZoom(100);
      AppMethodBeat.o(80351);
      return;
    case 3: 
      this.osM.getSettings().setTextZoom(110);
      AppMethodBeat.o(80351);
      return;
    case 4: 
      this.osM.getSettings().setTextZoom(112);
      AppMethodBeat.o(80351);
      return;
    case 5: 
      this.osM.getSettings().setTextZoom(112);
      AppMethodBeat.o(80351);
      return;
    case 6: 
      this.osM.getSettings().setTextZoom(140);
      AppMethodBeat.o(80351);
      return;
    case 7: 
      this.osM.getSettings().setTextZoom(155);
      AppMethodBeat.o(80351);
      return;
    }
    this.osM.getSettings().setTextZoom(165);
    AppMethodBeat.o(80351);
  }
  
  protected final void Ye(int paramInt)
  {
    AppMethodBeat.i(80288);
    Drawable localDrawable = getResources().getDrawable(eWF()).mutate();
    localDrawable.setColorFilter(paramInt, PorterDuff.Mode.SRC_IN);
    updateBackBtn(localDrawable);
    AppMethodBeat.o(80288);
  }
  
  protected final void Yf(int paramInt)
  {
    AppMethodBeat.i(80315);
    if (paramInt != -3)
    {
      AppMethodBeat.o(80315);
      return;
    }
    if (this.Evi == null)
    {
      AppMethodBeat.o(80315);
      return;
    }
    if ((this.lzU.eUT().FFZ & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = ".concat(String.valueOf(bool)));
      if (!bool) {
        break label236;
      }
      if ((this.Evi.getVisibility() != 0) && (!this.EuR.isShown())) {
        break;
      }
      AppMethodBeat.o(80315);
      return;
    }
    if (this.Evj == null) {
      this.Evj = new com.tencent.mm.sdk.platformtools.aw(Looper.getMainLooper(), new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(198242);
          WebViewUI.i(WebViewUI.this);
          AppMethodBeat.o(198242);
          return false;
        }
      }, false);
    }
    this.Evj.ay(4000L, 4000L);
    View localView = this.Evi;
    ((ImageView)localView.findViewById(2131301454)).setImageResource(2131690929);
    TextView localTextView = (TextView)localView.findViewById(2131301455);
    localTextView.setTextSize(14.0F);
    localTextView.setText(2131766250);
    ((ImageButton)localView.findViewById(2131301453)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198243);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WebViewUI.i(WebViewUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198243);
      }
    });
    this.Evi.setVisibility(0);
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(13125, bRn());
    label236:
    AppMethodBeat.o(80315);
  }
  
  public final void Yg(int paramInt)
  {
    AppMethodBeat.i(198301);
    this.DRx.cr("sendAppMessage", true);
    this.DRx.b(this.EvT.eVV(), paramInt);
    this.Eae.aIX("mm_send_friend_count");
    AppMethodBeat.o(198301);
  }
  
  protected void Zv()
  {
    AppMethodBeat.i(80342);
    this.EvT.Zv();
    AppMethodBeat.o(80342);
  }
  
  @TargetApi(21)
  protected final void a(ViewGroup paramViewGroup, WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(80253);
    if (this.mKJ == paramWindowInsets.getSystemWindowInsetTop())
    {
      AppMethodBeat.o(80253);
      return;
    }
    this.mKJ = paramWindowInsets.getSystemWindowInsetTop();
    eWq();
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
    if (eWt()) {
      eWv();
    }
    AppMethodBeat.o(80253);
  }
  
  public final void a(com.tencent.mm.plugin.webview.ui.tools.video.c paramc)
  {
    AppMethodBeat.i(198284);
    this.Evq.a(paramc);
    AppMethodBeat.o(198284);
  }
  
  public final void a(com.tencent.mm.ui.base.p paramp)
  {
    this.fPj = paramp;
  }
  
  protected void aE(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198296);
    if (this.EuQ == null)
    {
      AppMethodBeat.o(198296);
      return;
    }
    WebViewRedesignInputFooter localWebViewRedesignInputFooter = this.EuQ;
    localWebViewRedesignInputFooter.setVisibility(0);
    if (localWebViewRedesignInputFooter.ELa != null) {
      localWebViewRedesignInputFooter.ELa.setVisibility(0);
    }
    if (localWebViewRedesignInputFooter.EKZ != null)
    {
      localWebViewRedesignInputFooter.EKZ.setEnabled(true);
      localWebViewRedesignInputFooter.EKZ.setBackgroundResource(2131235110);
    }
    if (localWebViewRedesignInputFooter.EKW != null) {
      localWebViewRedesignInputFooter.EKW.setVisibility(0);
    }
    localWebViewRedesignInputFooter.ELb = false;
    if (localWebViewRedesignInputFooter.EKZ != null)
    {
      localWebViewRedesignInputFooter.EKZ.setFocusable(true);
      localWebViewRedesignInputFooter.EKZ.setFocusableInTouchMode(true);
      localWebViewRedesignInputFooter.EKZ.requestFocus();
    }
    if (localWebViewRedesignInputFooter.fNT != null) {
      localWebViewRedesignInputFooter.fNT.showVKB();
    }
    localWebViewRedesignInputFooter.state = 0;
    if (!bu.isNullOrNil(paramString)) {
      this.EuQ.setText(paramString);
    }
    if (paramInt1 >= 0)
    {
      this.EuQ.setMaxCount(paramInt1);
      this.EuQ.setShowRemindWordCount(paramInt2);
    }
    AppMethodBeat.o(198296);
  }
  
  public final void aG(Bundle paramBundle)
  {
    AppMethodBeat.i(80231);
    this.Ewi = paramBundle.getInt("state", 0);
    AppMethodBeat.o(80231);
  }
  
  public final void aH(Bundle paramBundle)
  {
    AppMethodBeat.i(80227);
    if (paramBundle != null)
    {
      this.Ewg = "black".equals(paramBundle.getString("style"));
      eWk().setCommentTopicId(paramBundle.getLong("commentTopicId"));
    }
    eWk().aKX(this.Eat.getCurrentUrl());
    eWk().vA(false);
    AppMethodBeat.o(80227);
  }
  
  public final String aHD(String paramString)
  {
    AppMethodBeat.i(198303);
    paramString = this.Eat.aHD(paramString);
    AppMethodBeat.o(198303);
    return paramString;
  }
  
  protected final int aHI(String paramString)
  {
    AppMethodBeat.i(80336);
    int i = this.Eat.aHI(paramString);
    AppMethodBeat.o(80336);
    return i;
  }
  
  public final void aI(Bundle paramBundle)
  {
    AppMethodBeat.i(80229);
    if (paramBundle != null)
    {
      this.Ewg = "black".equals(paramBundle.getString("style"));
      eWk().vA(true);
    }
    AppMethodBeat.o(80229);
  }
  
  protected final void aI(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(80280);
    this.EuN = paramBoolean1;
    Object localObject;
    if (paramBoolean1)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      if (this.Ewl != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.Ewl.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
        this.Ewl.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.EvC) {
        com.tencent.mm.ui.statusbar.a.N(this.Ewl, true);
      }
      for (;;)
      {
        getWindow().addFlags(1024);
        localObject = getWindow().getDecorView();
        ((View)localObject).setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
        {
          public final void onSystemUiVisibilityChange(int paramAnonymousInt)
          {
            AppMethodBeat.i(198212);
            if (((paramAnonymousInt & 0x4) == 0) && (WebViewUI.this.EuN)) {
              WebViewUI.fM(this.muJ);
            }
            AppMethodBeat.o(198212);
          }
        });
        ax((View)localObject, 5894);
        if (!paramBoolean2) {
          break;
        }
        this.EuM.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(198213);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            WebViewUI.this.bRT();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198213);
          }
        });
        this.EuM.setVisibility(0);
        AppMethodBeat.o(80280);
        return;
        if (this.Ewm != null) {
          this.Ewm.setVisibility(8);
        }
      }
      this.EuM.setVisibility(8);
      AppMethodBeat.o(80280);
      return;
    }
    this.EuM.setVisibility(8);
    getWindow().clearFlags(1024);
    fL(getWindow().getDecorView());
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().show();
      if (this.Ewl != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.Ewl.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = eWs();
        this.Ewl.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    if (this.EvC)
    {
      com.tencent.mm.ui.statusbar.a.N(this.Ewl, false);
      AppMethodBeat.o(80280);
      return;
    }
    if (this.Ewm != null) {
      this.Ewm.setVisibility(0);
    }
    AppMethodBeat.o(80280);
  }
  
  public final void aJ(Bundle paramBundle)
  {
    AppMethodBeat.i(80230);
    this.fPj = com.tencent.mm.plugin.webview.ui.tools.widget.p.a(paramBundle, getContext(), this.fPj);
    AppMethodBeat.o(80230);
  }
  
  public final void aK(Bundle paramBundle)
  {
    AppMethodBeat.i(175797);
    if (paramBundle != null) {
      eWk().setCommentTopicId(paramBundle.getLong("commentTopicId"));
    }
    eWk().aKX(this.Eat.getCurrentUrl());
    com.tencent.mm.plugin.webview.ui.tools.widget.n localn = eWk();
    String str = paramBundle.getString("reply_content");
    int i = paramBundle.getInt("personal_comment_id");
    d.g.b.p.h(str, "replyContent");
    localn.tW(2);
    localn.vC(false);
    if ((!bu.isNullOrNil(str)) && (i != 0) && (localn.eZw()))
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n.a(localn, str, i);
      localn.vB(false);
      AppMethodBeat.o(175797);
      return;
    }
    localn.vA(false);
    AppMethodBeat.o(175797);
  }
  
  public final void aKg(String paramString)
  {
    AppMethodBeat.i(80306);
    this.EvT.aKg(paramString);
    AppMethodBeat.o(80306);
  }
  
  public final void aKk(String paramString)
  {
    AppMethodBeat.i(80317);
    this.DRx.cr("profile", true);
    this.DRx.aId(paramString);
    AppMethodBeat.o(80317);
  }
  
  protected void aO(Bundle paramBundle) {}
  
  protected void aP(Bundle paramBundle)
  {
    AppMethodBeat.i(80220);
    int i;
    if (paramBundle.getBoolean("set_navigation_bar_color_reset", false)) {
      if (this.Ewa == null) {
        i = getResources().getColor(2131101161);
      }
    }
    for (int j = 255;; j = paramBundle.getInt("set_navigation_bar_color_alpha"))
    {
      setActionbarColor(i & 0xFFFFFF | j << 24);
      AppMethodBeat.o(80220);
      return;
      i = this.Ewa.eXk();
      break;
      i = paramBundle.getInt("set_navigation_bar_color_color");
    }
  }
  
  public final void aZ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(80257);
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.sdk.h.b.abu()))
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
        i = e.XV(paramInt);
      }
      setStatusBarColor(i);
    }
    AppMethodBeat.o(80257);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(80313);
    if (!com.tencent.mm.compatible.util.d.lA(21))
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
    if (eWu()) {
      localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
    for (;;)
    {
      addIconOptionMenu(paramInt1, getString(2131755815), localDrawable, paramOnMenuItemClickListener);
      AppMethodBeat.o(80313);
      return;
      if ((this.Ewa != null) && (!this.Ewa.EwK)) {
        localDrawable.setColorFilter(getResources().getColor(2131099732), PorterDuff.Mode.SRC_ATOP);
      } else {
        localDrawable.clearColorFilter();
      }
    }
  }
  
  public final void aw(View paramView, int paramInt)
  {
    AppMethodBeat.i(198283);
    com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h localh = this.Evq;
    Object localObject = paramView;
    if (paramView == null) {
      localObject = this.osM;
    }
    localh.aw((View)localObject, paramInt);
    AppMethodBeat.o(198283);
  }
  
  public final void b(com.tencent.mm.plugin.webview.ui.tools.video.c paramc)
  {
    AppMethodBeat.i(198285);
    this.Evq.b(paramc);
    AppMethodBeat.o(198285);
  }
  
  protected void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(80367);
    paramWebView = this.Eae;
    Intent localIntent = getIntent();
    String str2 = bRn();
    int i = localIntent.getIntExtra("geta8key_scene", 0);
    int j = localIntent.getIntExtra("bizEnterId", paramWebView.EmZ);
    int k = localIntent.getIntExtra("webview_scene_type", 1);
    String str3 = localIntent.getStringExtra("webview_scene_note");
    String str1 = localIntent.getStringExtra("srcUsername");
    paramWebView = str1;
    if (bu.isNullOrNil(str1)) {
      paramWebView = localIntent.getStringExtra("geta8key_username");
    }
    str1 = localIntent.getStringExtra("KAppId");
    com.tencent.mm.plugin.report.service.g.yxI.f(18452, new Object[] { Integer.valueOf(j), Integer.valueOf(i), com.tencent.mm.pluginsdk.ui.tools.x.aPc(str2), com.tencent.mm.pluginsdk.ui.tools.x.aPc(paramString), Integer.valueOf(k), str3, str1, paramWebView });
    AppMethodBeat.o(80367);
  }
  
  protected final void b(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(80309);
    addIconOptionMenu(0, paramString, paramDrawable, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(198237);
        if (!this.EwC) {
          WebViewUI.this.bRT();
        }
        for (;;)
        {
          AppMethodBeat.o(198237);
          return true;
          WebViewUI.this.aKk(this.fOp);
        }
      }
    });
    AppMethodBeat.o(80309);
  }
  
  public void bAi()
  {
    int k = 2;
    int m = 1;
    AppMethodBeat.i(80295);
    if ((this.EvL) || (this.EvK) || (isFinishing()))
    {
      ae.e("MicroMsg.WebViewUI", "edw postBinded finished");
      AppMethodBeat.o(80295);
      return;
    }
    Object localObject1 = eWI();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.webview.c.g)localObject1).Efj = this.Eat.getJsapi();
    }
    this.lzT = this.Eat.eQS();
    try
    {
      this.lzT.a(this.EfN, this.Eat.eQU());
      ae.i("MicroMsg.WebViewUI", "edw postBinded");
      this.Ewb = new com.tencent.mm.plugin.webview.ui.tools.floatball.a(new com.tencent.mm.plugin.ball.a.e(this), this);
      localObject1 = getIntent().getStringExtra("float_ball_key");
      if (!bu.isNullOrNil((String)localObject1))
      {
        this.Ewb.ac(2, (String)localObject1);
        this.Ewb.WY(bRn());
        this.Ewb.eD("rawUrl", bRn());
        this.Ewb.aIr(bRn());
        if (this.Ewb != null) {
          this.Ewb.bhj();
        }
        if (this.EvZ == null) {
          break label1001;
        }
        i = 1;
        if (this.EvZ == null) {
          this.EvZ = new HandOffURL(bRn(), bRn(), "");
        }
        localObject1 = this.Ewb.getName();
        if (!bu.isNullOrNil((String)localObject1)) {
          this.EvZ.setTitle((String)localObject1);
        }
        if (eSW())
        {
          if (i == 0) {
            break label1006;
          }
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.EvZ);
        }
        localObject1 = eWh();
        localObject2 = this.lzT;
      }
    }
    catch (RemoteException localException3)
    {
      try
      {
        str = ((com.tencent.mm.plugin.webview.stub.e)localObject2).aJO("DNSAdvanceOpen");
        ae.i("MicroMsg.DNSPreGetOptimize", "switch open value : %s", new Object[] { str });
        if (bu.isNullOrNil(str))
        {
          ae.e("MicroMsg.DNSPreGetOptimize", "get switch value is null or nil");
          bool = false;
          if (bool) {
            break label1083;
          }
          ae.i("MicroMsg.DNSPreGetOptimize", "server closed the switch");
          if (eWJ()) {
            com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(198235);
                if (WebViewUI.this.osM != null) {
                  WebViewUI.this.osM.getCurWebviewClient().b(WebViewUI.this.osM, WebViewUI.this.osM.getUrl());
                }
                AppMethodBeat.o(198235);
              }
            });
          }
          localObject1 = this.Eat.getTitle();
          aKh((String)localObject1);
          aKi((String)localObject1);
        }
      }
      catch (Exception localException3)
      {
        try
        {
          i = bu.getInt(this.lzT.aJO("WebviewDisableX5Logo"), 0);
          bool = getIntent().getBooleanExtra("disable_bounce_scroll", false);
          ae.i("MicroMsg.WebViewUI", "getting flag of x5 logo state, disableX5Logo = %d, disableBounceScroll = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
          if ((i == 1) || (bool)) {
            this.Ewp.vm(true);
          }
          if (getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_disable_over_scroll", false)) {
            this.Ewp.vm(true);
          }
          this.EvP.bM("onJSAPIEnd", System.currentTimeMillis());
          if ((this.osM != null) && (this.osM.getIsX5Kernel()))
          {
            bool = true;
            com.tencent.mm.plugin.webview.model.ay.aH(bool, bu.nullAsNil(bRn()).startsWith("https://"));
          }
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              j = bu.getInt(this.lzT.aJO("XwebBatchTranslateMaxByteLength"), 0);
              i = bu.getInt(this.lzT.aJO("XwebBatchTranslateMaxCnt"), 0);
              ae.i("MicroMsg.WebViewUI", "getting flag of XwebBatchTranslate para BatchTranslateMaxByteLength  = " + j + " BatchTranslateCnt = " + i);
              localObject1 = this.EvW;
              ((com.tencent.mm.plugin.webview.c)localObject1).DXJ = j;
              ((com.tencent.mm.plugin.webview.c)localObject1).DXK = i;
              if (getIntent().getBooleanExtra("translate_webview", false))
              {
                localObject1 = this.EvW;
                localObject2 = this.osM;
                str = bRn();
                if ((localObject2 != null) && (!((WebView)localObject2).isSysKernel())) {
                  break;
                }
              }
              if (!getIntent().getBooleanExtra("forceHideShare", false)) {
                break label1379;
              }
              vo(false);
              ae.d("MicroMsg.WebViewUI", "[hakon] postBinded :%d: force hide", new Object[] { Long.valueOf(System.currentTimeMillis()) });
              this.EuI = LayoutInflater.from(this).inflate(2131496073, null);
              localObject1 = (FontChooserView)this.EuI.findViewById(2131300194);
              localObject2 = this.EuI.findViewById(2131300193);
              if ((this.osM == null) || (!this.osM.getIsX5Kernel())) {
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
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                    paramAnonymousView = AnimationUtils.loadAnimation(WebViewUI.this, 2130772060);
                    paramAnonymousView.setAnimationListener(new Animation.AnimationListener()
                    {
                      public final void onAnimationEnd(Animation paramAnonymous2Animation)
                      {
                        AppMethodBeat.i(198246);
                        WebViewUI.this.EuI.setVisibility(8);
                        AppMethodBeat.o(198246);
                      }
                      
                      public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                      
                      public final void onAnimationStart(Animation paramAnonymous2Animation) {}
                    });
                    WebViewUI.this.EuI.startAnimation(paramAnonymousView);
                    WebViewUI.this.EuI.setVisibility(8);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(80091);
                  }
                });
              }
              ((FontChooserView)localObject1).setOnChangeListener(new d((byte)0));
              localObject2 = new FrameLayout.LayoutParams(-1, -2, 80);
              this.EuI.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              this.EuK.addView(this.EuI);
              this.EuI.setVisibility(8);
              try
              {
                if (!this.lzT.eVf()) {
                  break label1484;
                }
                if ((!eWQ()) && (!eWR())) {
                  break label1436;
                }
                i = com.tencent.mm.plugin.webview.j.f.hj(getContext());
              }
              catch (Exception localException6)
              {
                for (;;)
                {
                  Bundle localBundle;
                  ae.w("MicroMsg.WebViewUI", "initFontChooserView, ex = " + localException6.getMessage());
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
              this.Eat.Xb(j);
              Xp(j);
              AppMethodBeat.o(80295);
              return;
              localRemoteException = localRemoteException;
              ae.printErrStackTrace("MicroMsg.WebViewUI", localRemoteException, "addCallbacker", new Object[0]);
              continue;
              this.Ewb.ac(2, com.tencent.mm.plugin.ball.f.b.Xb(bRn()));
              continue;
              label1001:
              i = 0;
              continue;
              label1006:
              ae.i("MicroMsg.WebViewUI", "[Handoff] call onWebViewCreate " + this.EvZ.toString());
              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).a(this.EvZ);
              continue;
              bool = str.equalsIgnoreCase("1");
              continue;
              localException1 = localException1;
              ae.e("MicroMsg.DNSPreGetOptimize", "get dns pre get switch failed");
              continue;
              try
              {
                label1083:
                localObject2 = ((com.tencent.mm.plugin.webview.stub.e)localObject2).aJO("DNSAdvanceRelateDomain");
                if (!bu.isNullOrNil((String)localObject2)) {
                  break label1135;
                }
                ae.e("MicroMsg.DNSPreGetOptimize", "domain list is null, just return");
              }
              catch (Exception localException2)
              {
                ae.printErrStackTrace("MicroMsg.DNSPreGetOptimize", localException2, "", new Object[0]);
              }
              continue;
              label1135:
              com.tencent.mm.plugin.webview.a.a.ad(new b.1(localException2, (String)localObject2));
              continue;
              localException3 = localException3;
              ae.w("MicroMsg.WebViewUI", "getting flag of x5 logo state failed, ex = " + localException3.getMessage());
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
              ae.w("MicroMsg.WebViewUI", "getting flag of XwebBatchTranslate para failid, ex = " + localException4.getMessage());
              i = 0;
              j = 0;
              continue;
              localBundle = new Bundle();
              localBundle.putString("destLanguage", ad.fom());
              localBundle.putString("url", str);
              localBundle.putString("translateTips", getString(2131766130));
              localBundle.putString("translateFinish", getString(2131766127));
              localBundle.putString("errorWording", getString(2131766126));
              localException4.DXH = getString(2131766130);
              localException4.DXI = getString(2131766131);
              com.tencent.mm.sdk.b.a.IvT.c(localException4.DXM);
              try
              {
                ((WebView)localObject2).invokeMiscMethod("translateWebSite", localBundle);
              }
              catch (Exception localException5)
              {
                ae.e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", new Object[] { localException5.getMessage() });
              }
              continue;
              label1379:
              boolean bool = getIntent().getBooleanExtra("showShare", true);
              vo(bool);
              ae.d("MicroMsg.WebViewUI", "[cpan] postBinded :%d: show:%b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(bool) });
              continue;
              label1431:
              i = 0;
              continue;
              label1436:
              i = com.tencent.mm.plugin.webview.j.f.a(getContext(), this.lzT, bRn());
            }
          }
        }
      }
    }
  }
  
  protected int bAj()
  {
    AppMethodBeat.i(80254);
    int i = getActionbarColor();
    AppMethodBeat.o(80254);
    return i;
  }
  
  protected boolean bAk()
  {
    return false;
  }
  
  public final void bMW()
  {
    AppMethodBeat.i(80302);
    this.EvT.bMW();
    AppMethodBeat.o(80302);
  }
  
  protected MMWebView bRO()
  {
    AppMethodBeat.i(80260);
    MMWebView localMMWebView = MMWebView.a.kO(this);
    AppMethodBeat.o(80260);
    return localMMWebView;
  }
  
  protected boolean bRP()
  {
    AppMethodBeat.i(80365);
    if ((getClass().equals(WebViewUI.class)) && (!getIntent().getBooleanExtra("disable_minimize", false))) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WebViewUI", "enableMinimize class:%s enable:%b", new Object[] { getClass(), Boolean.valueOf(bool) });
      AppMethodBeat.o(80365);
      return bool;
    }
  }
  
  protected void bRQ()
  {
    AppMethodBeat.i(80247);
    ae.i("MicroMsg.WebViewUI", "onCreate" + hashCode());
    this.EfN = new l(this);
    this.EvS = new h(this);
    this.EvT = new i(this);
    this.Ewa = new n(this);
    Object localObject1 = this.Ewa;
    if (((n)localObject1).EwL != null)
    {
      if (!((n)localObject1).eXe()) {
        break label1469;
      }
      ((n)localObject1).EwK = true;
    }
    for (;;)
    {
      ae.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleParams, webViewUI#%s, disableLightActionbarStyle:%b", new Object[] { ((n)localObject1).EwL, Boolean.valueOf(((n)localObject1).EwK) });
      this.Ewt = true;
      this.Evf = getIntent().getIntExtra("geta8key_session_id", (int)System.currentTimeMillis());
      this.Evg = getIntent().getByteArrayExtra("geta8key_cookie");
      com.tencent.mm.plugin.webview.j.j.h(bRn(), this);
      this.EuU = bRn();
      this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
      this.Eve = getIntent().getBooleanExtra("from_shortcut", false);
      this.Eva = getIntent().getIntExtra(e.m.Jpz, -1);
      this.uxq = getIntent().getStringExtra("status_bar_style");
      this.uxp = getIntent().getIntExtra("customize_status_bar_color", 0);
      this.EvF = getIntent().getBooleanExtra("show_native_web_view", false);
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
        ae.i("MicroMsg.WebViewUI", "initCustomActionBarColorIfNeed isNativeStyle is %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label1523;
        }
        if (!al.isDarkMode()) {
          break label1508;
        }
        localObject1 = "black";
        Ye(2131099650);
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
          aP((Bundle)localObject3);
          if (!getIntent().hasExtra("customize_status_bar_color")) {
            this.uxp = ((Integer)localObject1).intValue();
          }
        }
        label424:
        this.EvF = getIntent().getBooleanExtra("show_native_web_view", false);
        this.EuT = getIntent().getBooleanExtra("key_trust_url", false);
        EvJ += 1;
        ae.i("MicroMsg.WebViewUI", "initView trust:%b, rawUrl = %s ", new Object[] { Boolean.valueOf(this.EuT), bRn() });
        this.dIz = bu.nullAsNil(getIntent().getStringExtra("KPublisherId"));
        this.handler = new aq();
        if ((this.Eae != null) && (this.Eae.aC(getIntent().getBundleExtra("mm_report_bundle"))))
        {
          bool = true;
          label549:
          this.EuY = bool;
          localObject1 = getIntent().getBundleExtra("close_window_confirm_info");
          if (localObject1 != null) {
            this.Evx = a.aQ((Bundle)localObject1);
          }
          getWindow().setFlags(16777216, 16777216);
          getWindow().setFormat(-3);
          this.EvT.eVQ();
          w.a.hw(this);
          this.EvP.bM("onWebViewCreateStart", System.currentTimeMillis());
          if (!com.tencent.mm.plugin.webview.j.j.aKZ(bRn())) {
            break label1547;
          }
          this.osM = MMWebView.a.kN(this);
          com.tencent.xweb.util.g.FJ(173L);
          if (this.osM == null) {
            this.osM = bRO();
          }
          label665:
          h.f(this.osM);
          this.EvP.bM("onWebViewCreateEnd", System.currentTimeMillis());
          this.osM.LoO = this;
          localObject1 = this.EvT;
          if (!(((i)localObject1).eVw() instanceof GameWebViewUI)) {
            break label1558;
          }
          ((i)localObject1).Etj.add(Integer.valueOf(11));
          ((i)localObject1).Etj.add(Integer.valueOf(28));
          label742:
          this.EvW = new com.tencent.mm.plugin.webview.c();
          initView();
          this.Eat = bSe();
          this.Eat.au(getIntent());
          if (this.Eae != this.Eat.Eae)
          {
            this.Eae = this.Eat.Eae;
            this.Eae.aC(getIntent().getBundleExtra("mm_report_bundle"));
          }
          localObject1 = this.Eae.eUj();
          i = this.Eat.bpW();
          localObject3 = this.dIz;
          ((ay.l)localObject1).dPU = i;
          ((ay.l)localObject1).Enh = ((String)localObject3);
          this.DRx = this.Eat.getJsapi();
          this.lzU = this.Eat.lzU;
          Evk.add(new e(this));
          if (Evk.size() > 1)
          {
            localObject1 = Evk;
            localObject1 = (e)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 2);
            if ((((e)localObject1).lZK != null) && (((e)localObject1).lZK.get() != null)) {
              ((WebViewUI)((e)localObject1).lZK.get()).vg(false);
            }
          }
          abj("onCreate");
          j = getIntent().getIntExtra("from_scence", 0);
          this.EuZ = getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
          localObject1 = this.EvP;
          i = this.EuZ;
          if (i == -1) {
            break label1609;
          }
          ((com.tencent.mm.plugin.webview.j.i)localObject1).EuZ = i;
          ae.d("MicroMsg.WebViewUI", " onCreate fromScene %d", new Object[] { Integer.valueOf(j) });
          this.sessionId = com.tencent.mm.model.z.Br(String.valueOf(this.Eat.eQU()));
          ae.i("MicroMsg.WebViewUI", " onCreate sessionId %s", new Object[] { this.sessionId });
          localObject1 = this.Eae.eUp();
          i = this.Eat.bpW();
          localObject3 = this.dIz;
          ((ay.f)localObject1).dPU = i;
          ((ay.f)localObject1).Enh = ((String)localObject3);
          ((ay.f)localObject1).url = bRn();
          localObject3 = this.Eae.eUv();
          localObject1 = bRn();
          ae.i("MicroMsg.WebviewReporter.DomainReporter", "setRawUrl, value = %s", new Object[] { localObject1 });
        }
      }
      catch (Exception localException2)
      {
        try
        {
          localObject4 = Uri.parse((String)localObject1);
          if ((((Uri)localObject4).getScheme() != null) && (!((Uri)localObject4).getScheme().toLowerCase().startsWith("http"))) {
            ae.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl scheme is not http/https, skip, scheme = %s", new Object[] { ((Uri)localObject4).getScheme() });
          }
        }
        catch (Exception localException2)
        {
          try
          {
            label1202:
            this.Ewl = getContentView();
            if (this.Ewl != null)
            {
              eWq();
              ((ViewGroup)((ViewGroup)getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
              {
                public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
                {
                  AppMethodBeat.i(198252);
                  WebViewUI.this.eWq();
                  AppMethodBeat.o(198252);
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
              if (this.EvC) {
                if (eWt()) {
                  eWv();
                }
              }
              for (;;)
              {
                this.EuP = new com.tencent.mm.bo.a(getContext(), this.Ewn);
                com.tencent.mm.plugin.webview.a.a.ad(new WebViewUI.43(this));
                this.EvV = new WebViewClipBoardHelper(this);
                this.Ewe.alive();
                this.Evr.alive();
                if (this.Ewa != null)
                {
                  localObject1 = this.Ewa;
                  if (((n)localObject1).EwL != null)
                  {
                    ((n)localObject1).mzb = ((n)localObject1).EwL.eRj();
                    ((n)localObject1).hcA = ((n)localObject1).EwL.osM;
                    if (!((n)localObject1).EwK) {
                      break label1848;
                    }
                    ae.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle true");
                  }
                }
                ax(getWindow().getDecorView(), 256);
                com.tencent.mm.plugin.webview.model.ay.CO(getIntent().getLongExtra("start_activity_time", 0L));
                this.Ewc = getIntent().getBooleanExtra(e.m.JpI, false);
                if (((this.Ewc) || (eWp())) && (this.osM != null)) {
                  this.osM.getSettings().setForceDarkBehavior(1);
                }
                AppMethodBeat.o(80247);
                return;
                label1469:
                ((n)localObject1).EwK = false;
                break;
                localObject1 = getIntent().getStringExtra("custom_action_bar_color");
                break label294;
                label1493:
                bool = getIntent().getBooleanExtra("open_custom_style_url", false);
                break label303;
                label1508:
                localObject1 = "white";
                Ye(-16777216);
                break label345;
                label1523:
                if (bu.isNullOrNil((String)localObject1)) {
                  break label424;
                }
                break label345;
                localException1 = localException1;
                Object localObject2 = null;
                break label357;
                bool = false;
                break label549;
                label1547:
                this.osM = bRO();
                break label665;
                label1558:
                localObject2.Etj.add(Integer.valueOf(7));
                localObject2.Etj.add(Integer.valueOf(11));
                localObject2.Etj.add(Integer.valueOf(28));
                break label742;
                switch (j)
                {
                default: 
                  label1609:
                  i = 999;
                }
                for (;;)
                {
                  localObject2.EuZ = i;
                  break;
                  i = 1;
                  continue;
                  i = 2;
                }
                localObject4 = ((Uri)localObject4).getHost();
                if ((localObject4 == null) || (((String)localObject4).toLowerCase().endsWith(".qq.com")))
                {
                  ae.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl, host is .qq.com, skip, host = %s", new Object[] { localObject4 });
                  break label1202;
                  localException4 = localException4;
                  ae.e("MicroMsg.WebviewReporter.DomainReporter", "parse rawUrl fail, rawUrl = %s", new Object[] { localObject2 });
                  break label1202;
                }
                localException4.rHX = true;
                break label1202;
                localException2 = localException2;
                ae.e("MicroMsg.WebViewUI", "fixContentMargin error : %s", new Object[] { localException2.getMessage() });
                break label1249;
                if (!com.tencent.mm.compatible.util.d.lA(21)) {
                  break label1831;
                }
                final ViewGroup localViewGroup = (ViewGroup)((ViewGroup)getWindow().getDecorView()).getChildAt(0);
                localViewGroup.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
                {
                  public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
                  {
                    AppMethodBeat.i(198253);
                    WebViewUI.this.a(localViewGroup, paramAnonymousWindowInsets);
                    WebViewUI.a(WebViewUI.this);
                    paramAnonymousView = paramAnonymousWindowInsets.consumeSystemWindowInsets();
                    AppMethodBeat.o(198253);
                    return paramAnonymousView;
                  }
                });
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                ae.e("MicroMsg.WebViewUI", "tryToExpandToStatusBar error : %s", new Object[] { localException3.getMessage() });
                continue;
                label1831:
                ((ViewGroup)getWindow().getDecorView()).setFitsSystemWindows(true);
                continue;
                label1848:
                ae.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle false");
                localException3.eXf();
              }
            }
          }
        }
      }
    }
  }
  
  protected boolean bRS()
  {
    AppMethodBeat.i(80320);
    if (this.EuW)
    {
      AppMethodBeat.o(80320);
      return true;
    }
    if ((this.osM != null) && ((this.osM.canGoBack()) || (this.osM.canGoForward())) && (this.EuF != null))
    {
      Object localObject1 = this.EuF;
      boolean bool;
      if (((g)localObject1).Esu != null)
      {
        localObject1 = ((g)localObject1).Esu;
        if (localObject1 == null) {
          d.g.b.p.gkB();
        }
        bool = ((Boolean)localObject1).booleanValue();
      }
      while (bool)
      {
        this.EuV = false;
        this.EuW = true;
        AppMethodBeat.o(80320);
        return true;
        Object localObject2 = com.tencent.mm.sdk.platformtools.ay.aRW("WebViewUIShowBottom");
        if (localObject2 == null) {
          d.g.b.p.gkB();
        }
        if (((com.tencent.mm.sdk.platformtools.ay)localObject2).decodeInt("WebViewUIShowBottomNav", 0) == 1)
        {
          ((g)localObject1).Esu = Boolean.TRUE;
          localObject1 = ((g)localObject1).Esu;
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          bool = ((Boolean)localObject1).booleanValue();
        }
        else
        {
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAs, 0) == 1) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label231;
            }
            ae.i(g.TAG, "needShowBottomNavigator not open");
            ((g)localObject1).Esu = Boolean.FALSE;
            localObject1 = ((g)localObject1).Esu;
            if (localObject1 == null) {
              d.g.b.p.gkB();
            }
            bool = ((Boolean)localObject1).booleanValue();
            break;
          }
          label231:
          localObject2 = com.tencent.mm.sdk.platformtools.ak.getContext();
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
              localObject2 = com.tencent.mm.sdk.platformtools.ak.getContext();
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
                localObject2 = com.tencent.mm.sdk.platformtools.ak.getContext();
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
                  localObject2 = com.tencent.mm.sdk.platformtools.ak.getContext();
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
            ((g)localObject1).Esu = Boolean.valueOf(bool);
            ae.i(g.TAG, "needShowBottomNavigator deviceShowBottomNav %b", new Object[] { ((g)localObject1).Esu });
            localObject2 = ((g)localObject1).Esu;
            if (localObject2 == null) {
              d.g.b.p.gkB();
            }
            if (!((Boolean)localObject2).booleanValue()) {
              break label796;
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(18210, new Object[] { Integer.valueOf(1) });
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1160L, 0L, 1L, false);
          }
          for (;;)
          {
            localObject1 = ((g)localObject1).Esu;
            if (localObject1 == null) {
              d.g.b.p.gkB();
            }
            bool = ((Boolean)localObject1).booleanValue();
            break;
            i = 0;
            break label261;
            label501:
            localObject2 = com.tencent.mm.sdk.platformtools.ak.getContext();
            d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
            bool = g.a.ei((Context)localObject2);
            ae.i(g.TAG, "miui hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
            break label267;
            label543:
            i = 0;
            break label301;
            label548:
            localObject2 = com.tencent.mm.sdk.platformtools.ak.getContext();
            d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
            bool = g.a.hb((Context)localObject2);
            ae.i(g.TAG, "huawei hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
            break label307;
            label590:
            i = 0;
            break label342;
            label595:
            localObject2 = com.tencent.mm.sdk.platformtools.ak.getContext();
            d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
            bool = g.a.hb((Context)localObject2);
            ae.i(g.TAG, "oppo hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
            break label348;
            label637:
            i = 0;
            break label382;
            label642:
            localObject2 = com.tencent.mm.sdk.platformtools.ak.getContext();
            d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
            if (Settings.Secure.getInt(((Context)localObject2).getContentResolver(), "navigation_gesture_mode", 0) == 1) {}
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label719;
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(18210, new Object[] { Integer.valueOf(0) });
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1160L, 1L, 1L, false);
              bool = false;
              break;
            }
            label719:
            localObject2 = com.tencent.mm.sdk.platformtools.ak.getContext();
            d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
            if (!g.a.ei((Context)localObject2))
            {
              localObject2 = com.tencent.mm.sdk.platformtools.ak.getContext();
              d.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
              if (!g.a.hb((Context)localObject2)) {
                break label786;
              }
            }
            label786:
            for (bool = true;; bool = false)
            {
              ae.i(g.TAG, "vivo hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
              break;
            }
            label791:
            bool = false;
            break label394;
            label796:
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1160L, 2L, 1L, false);
          }
        }
      }
    }
    AppMethodBeat.o(80320);
    return false;
  }
  
  public void bRT()
  {
    AppMethodBeat.i(80303);
    this.EvT.bRT();
    AppMethodBeat.o(80303);
  }
  
  protected void bRU()
  {
    AppMethodBeat.i(80341);
    this.EvT.bRU();
    AppMethodBeat.o(80341);
  }
  
  public boolean bRY()
  {
    return false;
  }
  
  public final String bRn()
  {
    AppMethodBeat.i(80300);
    try
    {
      String str = BaseWebViewController.aY(getIntent());
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
  
  public void bSA()
  {
    AppMethodBeat.i(80226);
    this.Ewf.eZs();
    int i = getIntent().getIntExtra(e.m.Jpz, -1);
    getIntent().getIntExtra(e.m.Jpu, 0);
    int j = getIntent().getIntExtra(e.m.Jpv, -1);
    int k = getIntent().getIntExtra(e.m.Jpw, -1);
    this.Ewf.a(j, k, i, 0, bRn(), getTitle().toString());
    AppMethodBeat.o(80226);
  }
  
  protected com.tencent.mm.plugin.webview.core.h bSe()
  {
    AppMethodBeat.i(198290);
    Object localObject = this.osM;
    com.tencent.mm.plugin.webview.model.ay localay = this.Eae;
    BaseWebViewController.f localf = new BaseWebViewController.f(getIntent());
    boolean bool2 = getIntent().getBooleanExtra("key_trust_url", false);
    boolean bool3 = eWV();
    if ((!eWQ()) && (!eWR())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject = new com.tencent.mm.plugin.webview.core.h((MMWebView)localObject, localay, new BaseWebViewController.c(localf, bool2, bool3, bool1, getIntent().getBooleanExtra("neverGetA8Key", false)));
      ((com.tencent.mm.plugin.webview.core.h)localObject).a(new c());
      ((com.tencent.mm.plugin.webview.core.h)localObject).init();
      AppMethodBeat.o(198290);
      return localObject;
    }
  }
  
  public boolean bSf()
  {
    return false;
  }
  
  protected void bSx()
  {
    AppMethodBeat.i(80246);
    if (this.EvC) {
      fixStatusbar(false);
    }
    AppMethodBeat.o(80246);
  }
  
  public final int bpW()
  {
    AppMethodBeat.i(80335);
    int i = this.Eat.bpW();
    AppMethodBeat.o(80335);
    return i;
  }
  
  public final void c(com.tencent.luggage.xweb_ext.extendplugin.a.a parama)
  {
    AppMethodBeat.i(198286);
    this.Evq.c(parama);
    AppMethodBeat.o(198286);
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
    AppMethodBeat.i(198287);
    this.Evq.d(parama);
    AppMethodBeat.o(198287);
  }
  
  public final void eLN()
  {
    AppMethodBeat.i(198300);
    if (this.EuJ != null)
    {
      hideVKB();
      this.EuJ.Hs(-2);
    }
    AppMethodBeat.o(198300);
  }
  
  public final int eQU()
  {
    AppMethodBeat.i(224328);
    int i = this.Eat.eQU();
    AppMethodBeat.o(224328);
    return i;
  }
  
  public final String eRj()
  {
    AppMethodBeat.i(224329);
    String str = this.Eat.getCurrentUrl();
    AppMethodBeat.o(224329);
    return str;
  }
  
  protected final boolean eRq()
  {
    AppMethodBeat.i(80308);
    boolean bool = this.Eat.eRq();
    AppMethodBeat.o(80308);
    return bool;
  }
  
  public final boolean eSP()
  {
    AppMethodBeat.i(80354);
    if ((this.Evx != null) && (this.Evx.eTw()) && (!bu.isNullOrNil(this.Evx.eXd())) && (!bu.isNullOrNil(this.Evx.eTy())) && (!bu.isNullOrNil(this.Evx.eTz())))
    {
      Object localObject = this.Evx.eXd();
      String str1 = this.Evx.eTy();
      String str2 = this.Evx.eTz();
      ae.i("MicroMsg.WebViewUI", "use js api close window confirm info : %s, %s, %s", new Object[] { localObject, str1, str2 });
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
      this.Evy = com.tencent.mm.ui.base.h.a(getContext(), true, "", localView, str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(198247);
          if ((localCheckBox != null) && (localCheckBox.isChecked())) {}
          try
          {
            if (WebViewUI.this.lzT.eVf()) {
              WebViewUI.this.lzT.jf(327792, 1);
            }
            WebViewUI.this.EvK = true;
            WebViewUI.this.Evy = null;
            k.EtK.close();
            if ((WebViewUI.v(WebViewUI.this) != null) && (WebViewUI.v(WebViewUI.this).sy(1)))
            {
              AppMethodBeat.o(198247);
              return;
            }
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            for (;;)
            {
              ae.e("MicroMsg.WebViewUI", "tryShowCloseWindowConfirmInfo, ex = " + paramAnonymousDialogInterface.getMessage());
            }
            WebViewUI.this.finish();
            AppMethodBeat.o(198247);
          }
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          WebViewUI.this.Evy = null;
        }
      });
      AppMethodBeat.o(80354);
      return true;
    }
    AppMethodBeat.o(80354);
    return false;
  }
  
  public final boolean eSW()
  {
    AppMethodBeat.i(80364);
    boolean bool1 = getIntent().getBooleanExtra("forceHideShare", false);
    boolean bool2 = getIntent().getBooleanExtra("showShare", true);
    boolean bool3 = getIntent().getBooleanExtra("KRightBtn", false);
    ae.i("MicroMsg.WebViewUI", "forceHideShare:%b showShareBtn:%b enableMinimize:%b, banRightBtn %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bRP()), Boolean.valueOf(bool3) });
    if ((!bool3) && (!bool1) && (bool2) && (bRP()))
    {
      AppMethodBeat.o(80364);
      return true;
    }
    AppMethodBeat.o(80364);
    return false;
  }
  
  public final com.tencent.mm.plugin.webview.c.b.a eSk()
  {
    AppMethodBeat.i(198304);
    if (this.DRx != null)
    {
      locala = this.DRx.eSk();
      AppMethodBeat.o(198304);
      return locala;
    }
    com.tencent.mm.plugin.webview.c.b.a locala = new com.tencent.mm.plugin.webview.c.b.a();
    AppMethodBeat.o(198304);
    return locala;
  }
  
  public final void eUX()
  {
    AppMethodBeat.i(80228);
    if (this.Ewf != null)
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n localn = this.Ewf;
      localn.hide();
      localn.EJu.setText((CharSequence)"");
    }
    AppMethodBeat.o(80228);
  }
  
  protected void eVH()
  {
    AppMethodBeat.i(80278);
    int i = getIntent().getIntExtra("webview_bg_color_rsID", -1);
    if ((i != -1) && (getContentView() != null))
    {
      setBackGroundColorResource(i);
      getContentView().setBackgroundResource(i);
      this.osM.setBackgroundResource(17170445);
      this.EuJ.setBackgroundResource(17170445);
      this.EuK.setBackgroundResource(17170445);
      AppMethodBeat.o(80278);
      return;
    }
    if (getIntent().getBooleanExtra(e.m.JpI, false))
    {
      this.osM.setBackgroundColor(getResources().getColor(2131099828));
      AppMethodBeat.o(80278);
      return;
    }
    this.osM.setBackgroundColor(getResources().getColor(2131101179));
    AppMethodBeat.o(80278);
  }
  
  public final void eVU()
  {
    AppMethodBeat.i(80305);
    this.EvT.eVU();
    AppMethodBeat.o(80305);
  }
  
  public final int eVY()
  {
    AppMethodBeat.i(198307);
    int i = this.EvT.eVY();
    AppMethodBeat.o(198307);
    return i;
  }
  
  protected void eWA()
  {
    AppMethodBeat.i(80275);
    this.EuX = System.currentTimeMillis();
    this.osM.goBack();
    k localk = k.EtK;
    ae.v("MicroMsg.WebViewReportUtil", "goBack traceid %s", new Object[] { localk.zMj });
    if (!bu.isNullOrNil(localk.zMj)) {
      localk.md(5);
    }
    AppMethodBeat.o(80275);
  }
  
  protected int eWB()
  {
    AppMethodBeat.i(80277);
    if (this.EuQ == null)
    {
      AppMethodBeat.o(80277);
      return 0;
    }
    WebViewRedesignInputFooter localWebViewRedesignInputFooter = this.EuQ;
    localWebViewRedesignInputFooter.setVisibility(0);
    if (localWebViewRedesignInputFooter.ELa != null) {
      localWebViewRedesignInputFooter.ELa.setVisibility(8);
    }
    localWebViewRedesignInputFooter.ELb = true;
    localWebViewRedesignInputFooter.state = 1;
    int i = localWebViewRedesignInputFooter.eWB();
    AppMethodBeat.o(80277);
    return i;
  }
  
  protected void eWC()
  {
    AppMethodBeat.i(80279);
    if (getIntent() == null)
    {
      AppMethodBeat.o(80279);
      return;
    }
    if (getIntent().hasExtra("show_full_screen")) {
      aI(getIntent().getBooleanExtra("show_full_screen", false), true);
    }
    AppMethodBeat.o(80279);
  }
  
  public final boolean eWD()
  {
    AppMethodBeat.i(198297);
    if ((this.EuN) || (this.Evq.bnx()) || ((this.Ewh != null) && (this.Ewh.bnx())))
    {
      AppMethodBeat.o(198297);
      return true;
    }
    AppMethodBeat.o(198297);
    return false;
  }
  
  protected com.tencent.xweb.x eWE()
  {
    try
    {
      AppMethodBeat.i(80286);
      if (this.Evn == null) {
        this.Evn = new MMWebView.b(new b());
      }
      com.tencent.xweb.x localx = this.Evn;
      AppMethodBeat.o(80286);
      return localx;
    }
    finally {}
  }
  
  protected int eWF()
  {
    AppMethodBeat.i(80287);
    if (this.EvF)
    {
      AppMethodBeat.o(80287);
      return 2131689490;
    }
    AppMethodBeat.o(80287);
    return 2131689492;
  }
  
  protected boolean eWG()
  {
    return true;
  }
  
  public final void eWH()
  {
    AppMethodBeat.i(175800);
    View localView = this.osM.getView();
    localView.scrollTo(localView.getScrollX(), 0);
    this.Eae.eUr().C(new Object[] { bRn(), Integer.valueOf(7) }).report();
    AppMethodBeat.o(175800);
  }
  
  protected com.tencent.mm.plugin.webview.c.g eWI()
  {
    return null;
  }
  
  protected boolean eWJ()
  {
    return false;
  }
  
  protected final void eWK()
  {
    AppMethodBeat.i(80304);
    if (this.Evq.bnx()) {
      this.Evq.eYX();
    }
    if (this.Eat != null) {
      this.Eat.reload();
    }
    AppMethodBeat.o(80304);
  }
  
  protected final void eWL()
  {
    AppMethodBeat.i(198299);
    if (this.Eat != null) {
      if (com.tencent.mm.plugin.webview.c.j.eSC()) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.webview.c.j.vi(bool);
      this.Eat.reload();
      AppMethodBeat.o(198299);
      return;
    }
  }
  
  protected final LinkedList<d.a> eWM()
  {
    AppMethodBeat.i(80307);
    if (this.osM == null)
    {
      ae.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
      AppMethodBeat.o(80307);
      return null;
    }
    Object localObject = bRn();
    if (this.osM != null)
    {
      String str = this.osM.getUrl();
      if (!bu.isNullOrNil(str))
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
            boolean bool = bu.isNullOrNil(str);
            if (bool)
            {
              AppMethodBeat.o(80307);
              return null;
            }
            localObject = str;
            if (!str.startsWith(".")) {
              localObject = ".".concat(String.valueOf(str));
            }
            ae.d("MicroMsg.WebViewUI", "host = %s", new Object[] { localObject });
            if (localPattern.matcher((CharSequence)localObject).matches())
            {
              long l;
              if (this.EvG == null)
              {
                l = System.currentTimeMillis();
                this.EvG = this.lzT.eVk();
                if (this.EvG == null) {
                  break label281;
                }
              }
              label281:
              for (bool = true;; bool = false)
              {
                ae.d("MicroMsg.WebViewUI", "[hakon] getConfigListMap %b, cost %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
                if ((this.EvG == null) || (this.EvG.size() <= 0)) {
                  break;
                }
                localObject = com.tencent.mm.n.d.q(this.EvG);
                AppMethodBeat.o(80307);
                return localObject;
              }
            }
          }
          catch (Exception localException)
          {
            ae.d("MicroMsg.WebViewUI", "[hakon] getJDMenuItems, ex = ", new Object[] { localException.getMessage() });
            AppMethodBeat.o(80307);
            return null;
          }
        }
      }
    }
  }
  
  protected final int eWN()
  {
    AppMethodBeat.i(80314);
    int i = 2131690603;
    if (eWM() != null) {
      i = 2131690809;
    }
    AppMethodBeat.o(80314);
    return i;
  }
  
  protected final void eWP()
  {
    AppMethodBeat.i(80344);
    this.Evz.setVisibility(0);
    AppMethodBeat.o(80344);
  }
  
  protected boolean eWQ()
  {
    return false;
  }
  
  protected boolean eWR()
  {
    return false;
  }
  
  public void eWT()
  {
    AppMethodBeat.i(80356);
    if (eWS())
    {
      AppMethodBeat.o(80356);
      return;
    }
    eWU();
    if (!eSP())
    {
      this.EvK = true;
      k.EtK.close();
      if ((this.Ewb != null) && (this.Ewb.sy(1)))
      {
        AppMethodBeat.o(80356);
        return;
      }
      finish();
    }
    AppMethodBeat.o(80356);
  }
  
  protected boolean eWV()
  {
    return true;
  }
  
  protected final boolean eWW()
  {
    AppMethodBeat.i(80360);
    if (this.Ewz != -3)
    {
      showVKB();
      AppMethodBeat.o(80360);
      return true;
    }
    AppMethodBeat.o(80360);
    return false;
  }
  
  protected final void eWX()
  {
    AppMethodBeat.i(198306);
    if ((this.EvK) || (this.EvL) || (isFinishing()))
    {
      AppMethodBeat.o(198306);
      return;
    }
    if (this.Eat != null)
    {
      com.tencent.mm.plugin.webview.core.h localh = this.Eat;
      localh.k(localh.bRn(), true, 8);
    }
    if (this.Evz != null) {
      this.Evz.setVisibility(8);
    }
    this.Eae.eUr().C(new Object[] { bRn(), Integer.valueOf(4) }).report();
    AppMethodBeat.o(198306);
  }
  
  public final MMWebView eWY()
  {
    return this.osM;
  }
  
  protected final boolean eWe()
  {
    return this.Eat.DYN;
  }
  
  protected final Map<String, String> eWf()
  {
    return this.Eat.DYg;
  }
  
  public final com.tencent.mm.plugin.webview.j.i eWg()
  {
    return this.EvP;
  }
  
  public final com.tencent.mm.plugin.webview.ui.tools.floatball.a eWi()
  {
    return this.Ewb;
  }
  
  protected final com.tencent.mm.plugin.webview.model.ar eWj()
  {
    return this.Eat.DZx;
  }
  
  protected final com.tencent.mm.plugin.webview.ui.tools.widget.n eWk()
  {
    AppMethodBeat.i(80223);
    if (this.Ewf == null)
    {
      this.Ewf = new com.tencent.mm.plugin.webview.ui.tools.widget.n(this, new t(getContext(), 2131820847));
      this.Ewf.setVisibility(8);
      localObject = (ViewParent)getWindow().getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        ((ViewGroup)localObject).addView(this.Ewf, new FrameLayout.LayoutParams(-1, -1));
        bSA();
      }
    }
    Object localObject = this.Ewf;
    AppMethodBeat.o(80223);
    return localObject;
  }
  
  public final MPVideoPlayFullScreenView eWl()
  {
    AppMethodBeat.i(80224);
    if (this.Ewh == null)
    {
      this.Ewh = new MPVideoPlayFullScreenView(this, null);
      this.Ewh.setVisibility(8);
      localObject = (ViewParent)getWindow().getDecorView();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).addView(this.Ewh, new FrameLayout.LayoutParams(-1, -1));
      }
    }
    Object localObject = this.Ewh;
    AppMethodBeat.o(80224);
    return localObject;
  }
  
  protected final void eWm()
  {
    AppMethodBeat.i(80225);
    if (this.Ewf != null)
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n localn = this.Ewf;
      if (localn.getSayFooter() != null)
      {
        localObject = localn.getSayFooter();
        if (((MPSmileyFooter)localObject).qdo != null)
        {
          ((MPSmileyFooter)localObject).qdo.ffs();
          ((MPSmileyFooter)localObject).qdo.destroy();
        }
      }
      Object localObject = com.tencent.mm.plugin.webview.ui.tools.widget.p.EKF;
      com.tencent.mm.plugin.webview.ui.tools.widget.p.b(localn.EJL.fPj);
    }
    AppMethodBeat.o(80225);
  }
  
  public final com.tencent.mm.ui.base.p eWn()
  {
    return this.fPj;
  }
  
  public final boolean eWo()
  {
    AppMethodBeat.i(198282);
    boolean bool = this.Evq.eWo();
    AppMethodBeat.o(198282);
    return bool;
  }
  
  protected final void eWq()
  {
    AppMethodBeat.i(80251);
    if ((this.Ewl == null) || (eWr()))
    {
      AppMethodBeat.o(80251);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.Ewl.getLayoutParams();
    int i = eWs();
    if (i != localMarginLayoutParams.topMargin)
    {
      localMarginLayoutParams.topMargin = i;
      this.Ewl.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(80251);
  }
  
  protected boolean eWt()
  {
    return true;
  }
  
  final boolean eWu()
  {
    AppMethodBeat.i(80255);
    if ((!bu.isNullOrNil(this.uxq)) && (this.uxq.equals("black")))
    {
      AppMethodBeat.o(80255);
      return true;
    }
    AppMethodBeat.o(80255);
    return false;
  }
  
  protected final void eWv()
  {
    AppMethodBeat.i(80256);
    if ((com.tencent.mm.compatible.util.d.lA(21)) && (this.uxp != 0))
    {
      setActionbarColor(this.uxp);
      AppMethodBeat.o(80256);
      return;
    }
    setStatusBarColor(bAj());
    AppMethodBeat.o(80256);
  }
  
  public final String eWw()
  {
    return this.Eat.DXV;
  }
  
  public final String eWx()
  {
    return this.Eat.DZA;
  }
  
  public final void eWz()
  {
    AppMethodBeat.i(80272);
    try
    {
      this.Ewp.release();
      this.osM.stopLoading();
      this.osM.removeAllViews();
      this.osM.clearView();
      if (this.DRx != null) {
        this.DRx.detach();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        this.osM.destroy();
        this.osM = null;
        finish();
        ae.foo();
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI", "forceQuit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)locala.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI", "forceQuit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(80272);
        return;
        localException1 = localException1;
        ae.e("MicroMsg.WebViewUI", "forceQuit, ex = " + localException1.getMessage());
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ae.w("MicroMsg.WebViewUI", "forceQuit, viewWV destroy, ex = %s", new Object[] { localException2.getMessage() });
        }
      }
    }
  }
  
  public final String eaf()
  {
    return this.Eat.DXY;
  }
  
  public void finish()
  {
    AppMethodBeat.i(80235);
    if (this.Evb) {
      setResult(-1);
    }
    if (this.handler != null) {
      this.handler.removeCallbacksAndMessages(null);
    }
    this.EvL = true;
    if (this.Eat != null)
    {
      com.tencent.mm.plugin.webview.core.h localh = this.Eat;
      localh.eRc();
      localh.DYc = true;
    }
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.d.c.class) != null) {
      ((com.tencent.mm.plugin.appbrand.d.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.d.c.class)).bek();
    }
    super.finish();
    AppMethodBeat.o(80235);
  }
  
  protected final int getActionBarHeight()
  {
    AppMethodBeat.i(80250);
    if (getResources().getDimensionPixelSize(2131167019) > com.tencent.mm.cb.a.fromDPToPix(this, 48))
    {
      i = getResources().getDimensionPixelSize(2131167019);
      AppMethodBeat.o(80250);
      return i;
    }
    if (com.tencent.mm.compatible.util.i.iP(this))
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
    AppMethodBeat.i(198293);
    if (this.Evq.bnx())
    {
      i = getRequestedOrientation();
      AppMethodBeat.o(198293);
      return i;
    }
    int i = this.screenOrientation;
    AppMethodBeat.o(198293);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131496078;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(198292);
    String str = this.Eat.osM.getSettings().getUserAgentString();
    AppMethodBeat.o(198292);
    return str;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    AppMethodBeat.i(198281);
    if (this.Eat != null)
    {
      com.tencent.luggage.xweb_ext.extendplugin.b.c localc = this.Eat.getWebViewPluginClientProxy();
      AppMethodBeat.o(198281);
      return localc;
    }
    AppMethodBeat.o(198281);
    return null;
  }
  
  protected void goBack()
  {
    AppMethodBeat.i(198288);
    if (this.osM == null)
    {
      AppMethodBeat.o(198288);
      return;
    }
    if (this.EvB)
    {
      AppMethodBeat.o(198288);
      return;
    }
    if (this.osM.canGoBack())
    {
      eWA();
      AppMethodBeat.o(198288);
      return;
    }
    k.EtK.close();
    finish();
    AppMethodBeat.o(198288);
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(80361);
    super.hideVKB();
    this.Ewz = -2;
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
    if (!this.EvC)
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
      this.EvD = true;
      AppMethodBeat.o(80222);
      return;
      localb.addView(localView1);
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(80284);
    this.EuJ = ((WebViewKeyboardLinearLayout)findViewById(2131306921));
    this.EuK = ((FrameLayout)findViewById(2131304241));
    this.Evd = getIntent().getBooleanExtra("finishviewifloadfailed", false);
    this.Evc = getIntent().getBooleanExtra("is_favorite_item", false);
    this.yOS = getIntent().getBooleanExtra("isWebwx", true);
    boolean bool = getIntent().getBooleanExtra("show_feedback", false);
    this.EvA = bu.nullAsNil(getIntent().getStringExtra("sentUsername"));
    if (bool) {
      addTextOptionMenu(1, getString(2131763230), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(198214);
          try
          {
            paramAnonymousMenuItem = WebViewUI.this.lzT.aJT(null);
            WebViewUI.this.loadUrl(paramAnonymousMenuItem);
            AppMethodBeat.o(198214);
            return false;
          }
          catch (RemoteException paramAnonymousMenuItem)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.WebViewUI", paramAnonymousMenuItem, "[oneliang]feedback exception:%s", new Object[] { paramAnonymousMenuItem.getMessage() });
            }
          }
        }
      });
    }
    this.EuD = ((ProgressBar)findViewById(2131298857));
    this.Evz = findViewById(2131303929);
    this.Evz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80048);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WebViewUI.this.eWX();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(80048);
      }
    });
    if (this.yOS)
    {
      localObject1 = bu.nullAsNil(getIntent().getStringExtra("title"));
      if (((CharSequence)localObject1).length() > 0) {
        this.EuA = true;
      }
      this.EuB = getIntent().getBooleanExtra("key_show_web_page_title", false);
      setMMTitle((CharSequence)localObject1);
    }
    for (;;)
    {
      this.Esx = findViewById(2131306901);
      if (this.Esx != null)
      {
        this.EuF = new g(this.Esx, this.EuJ, this.osM);
        this.Esx.setVisibility(8);
        this.EuG = ((ImageButton)findViewById(2131306897));
        this.EuG.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(198244);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if ((WebViewUI.this.osM != null) && (WebViewUI.this.osM.canGoBack())) {
              WebViewUI.this.eWA();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198244);
          }
        });
        this.EuH = ((ImageButton)findViewById(2131306900));
        this.EuH.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(198245);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if ((WebViewUI.this.osM != null) && (WebViewUI.this.osM.canGoForward())) {
              WebViewUI.this.osM.goForward();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198245);
          }
        });
      }
      if (this.osM != null) {
        break;
      }
      ae.i("MicroMsg.WebViewUI", "initView viewWV is null");
      finish();
      AppMethodBeat.o(80284);
      return;
      setMMTitle("");
    }
    if (Evp == WebSettings.RenderPriority.NORMAL)
    {
      ae.i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
      this.osM.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
      Evp = WebSettings.RenderPriority.HIGH;
    }
    Object localObject3 = this.Ewp;
    Object localObject1 = getContentView();
    ((j)localObject3).Etv = ((LogoWebViewWrapper)((View)localObject1).findViewById(2131301589));
    ((j)localObject3).Etu = ((ImageView)((View)localObject1).findViewById(2131306923));
    ((j)localObject3).EtD = ((View)localObject1).findViewById(2131306922);
    if (((j)localObject3).EtD != null)
    {
      ((j)localObject3).EtE = ((j)localObject3).EtD.findViewById(2131307117);
      ((j)localObject3).EtF = ((TextView)((j)localObject3).EtE.findViewById(2131307119));
    }
    ((j)localObject3).Etw = BackwardSupportUtil.b.h(((j)localObject3).Etv.getContext(), 72.0F);
    Object localObject2;
    if (((j)localObject3).Etu == null)
    {
      localObject1 = "null";
      if (((j)localObject3).Etv != null) {
        break label1212;
      }
      localObject2 = "null";
      label548:
      ae.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage.id = %s, logoWrapper.id = %s", new Object[] { localObject1, localObject2 });
      ae.d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", new Object[] { Integer.valueOf(((j)localObject3).Etw) });
      localObject1 = this.Ewp;
      localObject2 = this.osM;
      ((MMWebView)localObject2).setCompetitorView(((j)localObject1).Etv);
      ((MMWebView)localObject2).fPU();
      if (Build.VERSION.SDK_INT <= 10) {
        ((j)localObject1).Etv.getWebViewContainer().setBackgroundColor(((j)localObject1).Etv.getResources().getColor(2131101165));
      }
      localObject3 = ((j)localObject1).Etv;
      ((LogoWebViewWrapper)localObject3).getWebViewContainer();
      if (((LogoWebViewWrapper)localObject3).EqR != null)
      {
        ((LogoWebViewWrapper)localObject3).fSD = ((WebView)localObject2);
        ((LogoWebViewWrapper)localObject3).EqR.addView(((LogoWebViewWrapper)localObject3).fSD);
      }
      if ((!((MMWebView)localObject2).isXWalkKernel()) && (!((MMWebView)localObject2).getIsX5Kernel())) {
        break label1227;
      }
      ((j)localObject1).EtG = true;
      label704:
      if ((((j)localObject1).EtE != null) && (!((MMWebView)localObject2).getIsX5Kernel()))
      {
        ((ImageView)((j)localObject1).EtE.findViewById(2131307118)).setVisibility(8);
        ((TextView)((j)localObject1).EtE.findViewById(2131301014)).setText("");
      }
      if ((!((j)localObject1).EtG) || (((j)localObject1).EtH)) {
        break label1235;
      }
      ((j)localObject1).vm(false);
      ((j)localObject1).eWc();
    }
    for (;;)
    {
      eVH();
      this.EuL = ((FrameLayout)findViewById(2131298736));
      ae.i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.osM.getIsX5Kernel());
      this.osM.setWebViewClientExtension(new b(this));
      if (this.osM.getIsX5Kernel())
      {
        this.osM.setWebViewCallbackClient(this.Ewd);
        localObject1 = this.Ewp;
        localObject2 = new LogoWebViewWrapper.a()
        {
          public final void eVy()
          {
            AppMethodBeat.i(198215);
            if (WebViewUI.this.osM.getIsX5Kernel()) {
              WebViewUI.this.Eae.eUr().C(new Object[] { WebViewUI.this.bRn(), Integer.valueOf(10) }).report();
            }
            AppMethodBeat.o(198215);
          }
        };
        if (((j)localObject1).Etv != null) {
          ((j)localObject1).Etv.setMMOverScrollListener((LogoWebViewWrapper.a)localObject2);
        }
      }
      this.EuQ = ((WebViewRedesignInputFooter)findViewById(2131306916));
      if (this.EuQ != null)
      {
        this.EuQ.hide();
        this.EuQ.setOnTextSendListener(new WebViewInputFooter.c()
        {
          public final void aIp(String paramAnonymousString)
          {
            AppMethodBeat.i(198216);
            WebViewUI.a(WebViewUI.this, paramAnonymousString);
            AppMethodBeat.o(198216);
          }
        });
        this.EuQ.setOnSmileyChosenListener(new WebViewInputFooter.a()
        {
          public final boolean Wd(String paramAnonymousString)
          {
            AppMethodBeat.i(198217);
            com.tencent.mm.plugin.webview.c.f localf;
            if (WebViewUI.this.DRx != null)
            {
              localf = WebViewUI.this.DRx;
              if (localf.BZx) {
                break label44;
              }
              ae.e("MicroMsg.JsApiHandler", "not ready");
            }
            for (;;)
            {
              AppMethodBeat.o(198217);
              return true;
              label44:
              HashMap localHashMap = new HashMap();
              localHashMap.put("smiley", paramAnonymousString);
              com.tencent.mm.sdk.platformtools.ar.f(new f.25(localf, l.a.b("onGetSmiley", localHashMap, localf.EeC, localf.vVT)));
            }
          }
        });
        this.EuQ.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b()
        {
          public final void eTd()
          {
            AppMethodBeat.i(198218);
            WebViewUI.a(WebViewUI.this, 0);
            AppMethodBeat.o(198218);
          }
          
          public final void eTe()
          {
            AppMethodBeat.i(198219);
            WebViewKeyboardLinearLayout localWebViewKeyboardLinearLayout = WebViewUI.this.EuJ;
            if ((localWebViewKeyboardLinearLayout != null) && (localWebViewKeyboardLinearLayout.getKeyBoardHeight() > 0)) {
              WebViewUI.a(WebViewUI.this, localWebViewKeyboardLinearLayout.getKeyBoardHeight());
            }
            AppMethodBeat.o(198219);
          }
        });
      }
      this.EuR = ((WebViewSearchContentInputFooter)findViewById(2131304407));
      if (this.EuR != null)
      {
        this.EuR.setActionDelegate(new WebViewSearchContentInputFooter.a()
        {
          public final void a(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
          {
            AppMethodBeat.i(198221);
            if (paramAnonymousWebViewSearchContentInputFooter.getVisibility() == 0) {
              b(paramAnonymousWebViewSearchContentInputFooter);
            }
            AppMethodBeat.o(198221);
          }
          
          public final void b(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
          {
            AppMethodBeat.i(198224);
            WebViewUI.this.osM.clearMatches();
            paramAnonymousWebViewSearchContentInputFooter.reset();
            WebViewUI.this.EuR.C(0, 0, true);
            WebViewUI.a(WebViewUI.this, false);
            WebViewUI.this.osM.findAllAsync(paramAnonymousWebViewSearchContentInputFooter.getSearchContent());
            AppMethodBeat.o(198224);
          }
          
          public final boolean c(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(198225);
            if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0)) {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(480L, 6L, 1L, false);
            }
            AppMethodBeat.o(198225);
            return false;
          }
          
          public final void eTf()
          {
            AppMethodBeat.i(198220);
            WebViewUI.b(WebViewUI.this, 0);
            WebViewUI.this.osM.clearMatches();
            WebViewUI.this.EuR.eZx();
            AppMethodBeat.o(198220);
          }
          
          public final void eTg()
          {
            AppMethodBeat.i(198222);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(480L, 5L, 1L, false);
            WebViewUI.this.osM.findNext(false);
            AppMethodBeat.o(198222);
          }
          
          public final void eTh()
          {
            AppMethodBeat.i(198223);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(480L, 4L, 1L, false);
            WebViewUI.this.osM.findNext(true);
            AppMethodBeat.o(198223);
          }
        });
        this.osM.setFindListener(new WebView.FindListener()
        {
          public final void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(198226);
            if ((paramAnonymousBoolean) && (!WebViewUI.b(WebViewUI.this)) && (!bu.isNullOrNil(WebViewUI.this.EuR.getSearchContent())))
            {
              if (paramAnonymousInt2 != 0) {
                break label81;
              }
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(480L, 3L, 1L, false);
            }
            for (;;)
            {
              WebViewUI.a(WebViewUI.this, true);
              WebViewUI.this.EuR.C(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
              AppMethodBeat.o(198226);
              return;
              label81:
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(480L, 2L, 1L, false);
            }
          }
        });
      }
      this.EuM = ((MovingImageButton)findViewById(2131300327));
      this.Evi = findViewById(2131306913);
      if (this.Evi != null) {
        this.Evi.setVisibility(8);
      }
      this.osM.setWebChromeClient(eWE());
      this.osM.setDownloadListener(new DownloadListener()
      {
        public final void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
        {
          AppMethodBeat.i(198227);
          ae.i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + paramAnonymousString1 + ", mimetype = " + paramAnonymousString4 + ", userAgent = " + paramAnonymousString2 + ", contentDisposition = " + paramAnonymousString3);
          int i = WebViewUI.this.getIntent().getIntExtra("key_download_restrict", 0);
          String str = WebViewUI.this.getIntent().getStringExtra("key_function_id");
          if (!bu.isNullOrNil(str)) {
            com.tencent.mm.plugin.report.service.g.yxI.f(14596, new Object[] { str, Integer.valueOf(i), Integer.valueOf(0) });
          }
          if (i == 1)
          {
            ae.e("MicroMsg.WebViewUI", "not allow download file : %s", new Object[] { paramAnonymousString1 });
            AppMethodBeat.o(198227);
            return;
          }
          if ((paramAnonymousString4 != null) && (paramAnonymousString4.equalsIgnoreCase("application/vnd.android.package-archive")))
          {
            ae.v("MicroMsg.WebViewUI", "edw onDownloadStart, report download url: %s", new Object[] { paramAnonymousString1 });
            e.a(WebViewUI.this.lzT, 11154, new Object[] { paramAnonymousString1 });
          }
          if (WebViewUI.this.lzU == null)
          {
            ae.e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
            AppMethodBeat.o(198227);
            return;
          }
          int j = 0;
          if (paramAnonymousString4 != null)
          {
            boolean bool1 = WebViewUI.c(WebViewUI.this);
            ae.i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", new Object[] { Boolean.valueOf(bool1) });
            str = WebViewUI.aKl(paramAnonymousString3);
            if ((str == null) || (!Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", str))) {
              break label459;
            }
            i = 1;
            boolean bool2 = com.tencent.mm.plugin.webview.core.a.DZq.contains(paramAnonymousString4.toLowerCase());
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
                  ae.i("MicroMsg.WebViewUI", "onDownloadStart is apk");
                }
              }
              e.a(WebViewUI.this.lzT, 18111, new Object[] { WebViewUI.this.eRj(), paramAnonymousString1, paramAnonymousString4, paramAnonymousString3, paramAnonymousString2, Long.valueOf(paramAnonymousLong) });
            }
            if ((j != 0) || (WebViewUI.this.lzU.eUS().mC(24)) || (WebViewUI.d(WebViewUI.this))) {
              break label471;
            }
            ae.e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
            AppMethodBeat.o(198227);
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
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString1, paramAnonymousString2.ahE(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$23", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString1.startActivity((Intent)paramAnonymousString2.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString1, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$23", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(198227);
            return;
          }
          catch (Exception paramAnonymousString1)
          {
            ae.e("MicroMsg.WebViewUI", "startActivity fail, e = " + paramAnonymousString1.getMessage());
            AppMethodBeat.o(198227);
          }
        }
      });
      this.osM.requestFocus(130);
      this.osM.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(198229);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$24", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          if ((WebViewUI.this.EuI != null) && (WebViewUI.this.EuI.getVisibility() == 0))
          {
            localObject = AnimationUtils.loadAnimation(WebViewUI.this, 2130772060);
            ((Animation)localObject).setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(198228);
                WebViewUI.this.EuI.setVisibility(8);
                AppMethodBeat.o(198228);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationStart(Animation paramAnonymous2Animation) {}
            });
            WebViewUI.this.EuI.startAnimation((Animation)localObject);
            WebViewUI.this.EuI.setVisibility(8);
          }
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          while (WebViewUI.this.osM == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$24", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(198229);
            return false;
            if (!paramAnonymousView.hasFocus()) {
              paramAnonymousView.requestFocus();
            }
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              WebViewUI.this.oef = ((int)paramAnonymousMotionEvent.getRawX());
              WebViewUI.this.oeg = ((int)paramAnonymousMotionEvent.getRawY());
            }
          }
          if ((paramAnonymousMotionEvent.getAction() == 0) || (paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 261) || (paramAnonymousMotionEvent.getAction() == 517))
          {
            if (paramAnonymousMotionEvent.getPointerCount() <= 1) {
              break label307;
            }
            WebViewUI.this.osM.getSettings().setBuiltInZoomControls(true);
            WebViewUI.this.osM.getSettings().setSupportZoom(true);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$24", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(198229);
            return false;
            label307:
            WebViewUI.this.osM.getSettings().setBuiltInZoomControls(false);
            WebViewUI.this.osM.getSettings().setSupportZoom(false);
          }
        }
      });
      this.osM.fPT();
      this.EvS = new h(this);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(198230);
          WebViewUI.this.hideVKB();
          WebViewUI.this.eWT();
          ae.i("MicroMsg.WebViewUI", "on back btn press");
          AppMethodBeat.o(198230);
          return true;
        }
      }, eWF());
      if (eWG()) {
        this.EuJ.setOnkbdStateListener(new KeyboardLinearLayout.a()
        {
          public final void Hs(int paramAnonymousInt)
          {
            AppMethodBeat.i(198239);
            ae.i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = ".concat(String.valueOf(paramAnonymousInt)));
            WebViewUI.a(WebViewUI.this, WebViewUI.this.EuJ, paramAnonymousInt);
            if (paramAnonymousInt == -3)
            {
              WebViewUI.this.Eae.eUn().EmF = 1;
              int i = WebViewUI.this.EuJ.getKeyBoardHeight();
              if (i > 0)
              {
                WebViewUI.b(WebViewUI.this, i);
                WebViewUI.a(WebViewUI.this, i);
              }
              if (WebViewUI.f(WebViewUI.this))
              {
                WebViewRedesignInputFooter localWebViewRedesignInputFooter = WebViewUI.g(WebViewUI.this);
                if (localWebViewRedesignInputFooter.ELb) {
                  localWebViewRedesignInputFooter.setVisibility(8);
                }
                localWebViewRedesignInputFooter.state = 0;
                localWebViewRedesignInputFooter.bFx();
              }
            }
            for (;;)
            {
              WebViewUI.this.Yf(paramAnonymousInt);
              WebViewUI.this.Ewz = paramAnonymousInt;
              AppMethodBeat.o(198239);
              return;
              WebViewUI.b(WebViewUI.this, 0);
              WebViewUI.a(WebViewUI.this, 0);
            }
          }
        });
      }
      this.EuC = ((MMFalseProgressBar)findViewById(2131306899));
      super.setTitleBarDoubleClickListener(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198231);
          WebViewUI.this.eWH();
          AppMethodBeat.o(198231);
        }
      });
      AppMethodBeat.o(80284);
      return;
      localObject1 = String.valueOf(((j)localObject3).Etu.getId());
      break;
      label1212:
      localObject2 = String.valueOf(((j)localObject3).Etv.getId());
      break label548;
      label1227:
      ((j)localObject1).EtG = false;
      break label704;
      label1235:
      ((j)localObject1).vm(true);
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
    if (this.Eat != null) {
      this.Eat.loadUrl(paramString, paramMap, paramBoolean);
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
    if (this.lAd.d(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(80289);
      return;
    }
    if (this.EsR.d(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(80289);
      return;
    }
    if (this.Ewq.d(this, paramInt1, paramInt2, paramIntent))
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
        ae.i("MicroMsg.WebViewUI", "gdpr continue:true");
        AppMethodBeat.o(80289);
        return;
      }
      ae.i("MicroMsg.WebViewUI", "gdpr continue:false");
      paramIntent = new Intent();
      localBundle = new Bundle();
      localBundle.putString("go_next", "gdpr_confirm_logout");
      paramIntent.putExtra("result_data", localBundle);
      this.EvK = true;
      k.EtK.close();
      setResult(-1, paramIntent);
      finish();
    }
    AppMethodBeat.o(80289);
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(80291);
    if (this.osM != null)
    {
      if (!this.Ewr) {
        break label42;
      }
      this.osM.setOnLongClickListener(this.Ews);
    }
    for (;;)
    {
      super.onCancel();
      AppMethodBeat.o(80291);
      return;
      label42:
      this.osM.setOnLongClickListener(null);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(80265);
    super.onConfigurationChanged(paramConfiguration);
    if (this.omK != paramConfiguration.orientation)
    {
      View localView = eWy();
      if (localView == null) {}
      for (localView = null; localView == null; localView = (View)localView.getParent())
      {
        AppMethodBeat.o(80265);
        return;
      }
      localView.dispatchConfigurationChanged(paramConfiguration);
      localView.requestLayout();
      this.omK = paramConfiguration.orientation;
    }
    AppMethodBeat.o(80265);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80244);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPU, true)) {
      com.tencent.mm.sdk.platformtools.a.fnK();
    }
    com.tencent.mm.plugin.webview.j.i locali = this.EvP;
    locali.createTime = System.currentTimeMillis();
    locali.bM("onCreate", locali.createTime);
    this.EvP.ELW = getIntent().getLongExtra("startTime", 0L);
    bSx();
    super.onCreate(paramBundle);
    this.EvP.bM("onUIInitStart", System.currentTimeMillis());
    bRQ();
    this.EvP.bM("onUIInitEnd", System.currentTimeMillis());
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
    ae.i("MicroMsg.WebViewUI", "WebViewUI onDestroy now: %s", new Object[] { Integer.valueOf(this.Eat.eQU()) });
    super.onDestroy();
    com.tencent.mm.plugin.webview.modeltools.c.eUx();
    Object localObject1 = this.Eat.getCurrentUrl();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.webview.j.j.hk(this);
      if ((localObject2 != null) && (((String)localObject1).equals(localObject2))) {
        com.tencent.mm.plugin.webview.j.j.hl(this);
      }
    }
    for (;;)
    {
      this.Evq.onDestroy();
      if (this.Ewb != null)
      {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).M(this.Ewb.nLK);
        this.Ewb.onDestroy();
      }
      if ((eSW()) && (this.EvZ != null))
      {
        ae.i("MicroMsg.WebViewUI", "[Handoff] call onWebViewDestroy " + this.EvZ.toString());
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).b(this.EvZ);
      }
      if (this.EuP != null) {
        this.EuP.disable();
      }
      this.EvK = true;
      EvJ -= 1;
      int j = this.Eat.eQU();
      int i = Evk.size() - 1;
      label225:
      if (i >= 0)
      {
        if (((e)Evk.get(i)).id == j) {
          Evk.remove(i);
        }
      }
      else
      {
        this.Eae.eUr().C(new Object[] { bRn(), Integer.valueOf(2) }).report();
        this.Eae.report();
        localObject1 = this.Eae;
        ((com.tencent.mm.plugin.webview.model.ay)localObject1).EmL = null;
        ((com.tencent.mm.plugin.webview.model.ay)localObject1).EmJ = null;
        ((com.tencent.mm.plugin.webview.model.ay)localObject1).EmK = null;
        ((com.tencent.mm.plugin.webview.model.ay)localObject1).EmI = null;
        ((com.tencent.mm.plugin.webview.model.ay)localObject1).EmN = null;
        ((com.tencent.mm.plugin.webview.model.ay)localObject1).EmO = null;
        ((com.tencent.mm.plugin.webview.model.ay)localObject1).EmP = null;
        ((com.tencent.mm.plugin.webview.model.ay)localObject1).EmQ = null;
        if (((com.tencent.mm.plugin.webview.model.ay)localObject1).EmV != null)
        {
          ((com.tencent.mm.plugin.webview.model.ay)localObject1).EmV.dyY = null;
          ((com.tencent.mm.plugin.webview.model.ay)localObject1).EmV = null;
        }
        abj("onDestroy");
        this.Evt.clear();
        eWh();
        c(this.Evy);
        if ((this.Evn != null) && ((this.Evn instanceof b))) {
          c(((b)this.Evn).jxa);
        }
        if (this.EuQ != null) {
          this.EuQ.setOnTextSendListener(null);
        }
        if (this.EuF != null)
        {
          localObject1 = this.EuF.Esx;
          if (localObject1 != null)
          {
            localObject2 = ((View)localObject1).getAnimation();
            if (localObject2 != null) {
              ((Animation)localObject2).setAnimationListener(null);
            }
            ((View)localObject1).clearAnimation();
          }
        }
        this.Evu.clear();
        this.EvT.onDestroy();
        this.Ewe.dead();
        this.Evr.dead();
        if (com.tencent.xweb.d.lB(com.tencent.mm.sdk.platformtools.ak.getContext()) != null)
        {
          ae.i("MicroMsg.WebViewUI", "now force sync the cookie between ram and db");
          com.tencent.xweb.d.sync();
        }
        ae.v("MicroMsg.WebViewUI", "on destroy isNeedCallbackMMRpt[%b]", new Object[] { Boolean.valueOf(this.EuY) });
        if (!this.EuY) {}
      }
      try
      {
        localObject1 = getIntent().getBundleExtra("mm_report_bundle");
        if (!bu.isNullOrNil(((Bundle)localObject1).getString("mm_event_class"))) {
          if (this.lzT != null)
          {
            ((Bundle)localObject1).putLong("key_activity_browse_time", getActivityBrowseTimeMs());
            this.lzT.k(250, (Bundle)localObject1);
          }
        }
      }
      catch (Exception localThrowable)
      {
        try
        {
          if (this.lzT != null)
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putLong("key_activity_browse_time", getActivityBrowseTimeMs());
            this.lzT.k(251, (Bundle)localObject1);
          }
        }
        catch (Exception localThrowable)
        {
          try
          {
            if (this.lzT != null)
            {
              localObject1 = this.lzT.k(19, null);
              if (localObject1 != null)
              {
                bool = ((Bundle)localObject1).getBoolean("webview_video_proxy_init");
                ae.i("MicroMsg.WebViewUI", "onDestroy, has init = %b, webviewHoldingCounter = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(EvJ) });
                if ((bool) && (EvJ <= 0))
                {
                  FactoryProxyManager.getPlayManager().deinit();
                  this.lzT.k(75, null);
                }
              }
            }
            bool = com.tencent.mm.plugin.webview.modeltools.k.a(this.DRx, this.osM);
            this.Eat.onDestroy();
            this.osM.removeJavascriptInterface("MicroMsg");
            this.osM.removeJavascriptInterface("JsApi");
            this.osM.removeJavascriptInterface("__wx");
            this.osM.removeJavascriptInterface("CustomFullscreenApi");
            this.osM.removeJavascriptInterface("__wxtag");
          }
          catch (Exception localThrowable)
          {
            try
            {
              this.osM.setWebChromeClient(null);
              this.osM.setWebViewClient(null);
              this.osM.setOnTouchListener(null);
              this.osM.setOnLongClickListener(null);
              this.osM.setVisibility(8);
              this.osM.removeAllViews();
              this.osM.clearView();
              this.EvR.eUR();
              if (this.lzU != null)
              {
                localObject1 = this.lzU;
                ae.i("MicroMsg.WebViewPermission", "detach");
                ((com.tencent.mm.plugin.webview.e.g)localObject1).EoY.clear();
                ((com.tencent.mm.plugin.webview.e.g)localObject1).EoY = null;
                this.lzU = null;
              }
            }
            catch (Exception localThrowable)
            {
              try
              {
                boolean bool;
                this.Ewp.release();
                if (bool) {}
              }
              catch (Exception localThrowable)
              {
                try
                {
                  this.osM.destroy();
                }
                catch (Exception localThrowable)
                {
                  try
                  {
                    if ((getContentView() instanceof ViewGroup)) {
                      ((ViewGroup)getContentView()).removeAllViews();
                    }
                    localObject1 = this.EvV;
                  }
                  catch (Throwable localThrowable)
                  {
                    try
                    {
                      for (;;)
                      {
                        ((ClipboardManager)com.tencent.mm.sdk.platformtools.ak.getContext().getSystemService("clipboard")).removePrimaryClipChangedListener((ClipboardManager.OnPrimaryClipChangedListener)localObject1);
                        label996:
                        localObject1 = this.EvW;
                        if ((((com.tencent.mm.plugin.webview.c)localObject1).tipDialog != null) && (((com.tencent.mm.plugin.webview.c)localObject1).tipDialog.isShowing()))
                        {
                          ((com.tencent.mm.plugin.webview.c)localObject1).tipDialog.dismiss();
                          ((com.tencent.mm.plugin.webview.c)localObject1).tipDialog = null;
                        }
                        com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.plugin.webview.c)localObject1).DXM);
                        this.osM = null;
                        if (this.EvU != null)
                        {
                          this.EvU = null;
                          FactoryProxyManager.getPlayManager().setUtilsObject(null);
                        }
                        System.gc();
                        AppMethodBeat.o(80271);
                        return;
                        ae.w("MicroMsg.WebViewUI", "currentURL == null, qbrowser.url may be not accurate");
                        break;
                        i -= 1;
                        break label225;
                        ae.w("MicroMsg.WebViewUI", "webview on destroy callback mm but eventclass is null");
                        continue;
                        localException1 = localException1;
                        ae.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", new Object[] { localException1.toString() });
                        continue;
                        localException2 = localException2;
                        ae.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", new Object[] { localException2.toString() });
                        continue;
                        localException3 = localException3;
                        ae.e("MicroMsg.WebViewUI", "deinit video player failed : %s", new Object[] { localException3.getMessage() });
                        continue;
                        localException4 = localException4;
                        ae.e("MicroMsg.WebViewUI", "onDestroy, set web infos to null,  ex = %s", new Object[] { localException4.getMessage() });
                        continue;
                        localException5 = localException5;
                        ae.e("MicroMsg.WebViewUI", "onDestroy, remove view,  ex = " + localException5.getMessage());
                        continue;
                        localException6 = localException6;
                        ae.w("MicroMsg.WebViewUI", "onDestroy, viewWV destroy, ex = %s", new Object[] { localException6.getMessage() });
                      }
                      localThrowable = localThrowable;
                      ae.w("MicroMsg.WebViewUI", "onDestroy contentView removeAllViews %s", new Object[] { localThrowable });
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
    if (this.osM != null) {
      this.osM.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198232);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$28", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$28", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(198232);
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
    ae.i("MicroMsg.WebViewUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 4)
    {
      if ((this.osM != null) && (this.osM.hasEnteredFullscreen()))
      {
        this.osM.leaveFullscreen();
        AppMethodBeat.o(80274);
        return true;
      }
      if (this.Evq.eYX())
      {
        AppMethodBeat.o(80274);
        return true;
      }
    }
    if ((paramInt == 4) && (this.vd != null) && (this.Evm != null) && (this.Evn != null)) {
      try
      {
        this.Evn.onHideCustomView();
        this.Eae.eUr().C(new Object[] { bRn(), Integer.valueOf(1) }).report();
        AppMethodBeat.o(80274);
        return true;
      }
      catch (Exception paramKeyEvent)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.WebViewUI", paramKeyEvent, "onkeydown", new Object[0]);
        }
      }
    }
    if (paramInt == 4)
    {
      if ((this.EuQ != null) && (this.EuQ.isShown()))
      {
        this.EuQ.hide();
        eWO();
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(80274);
        return true;
      }
    }
    if (paramInt == 4)
    {
      if ((this.osM != null) && (this.osM.canGoBack()) && (this.EuV))
      {
        eWA();
        this.Eae.eUr().C(new Object[] { bRn(), Integer.valueOf(1) }).report();
        AppMethodBeat.o(80274);
        return true;
      }
      k.EtK.close();
    }
    if ((paramInt == 4) && (eWS()) && (eSP()))
    {
      AppMethodBeat.o(80274);
      return true;
    }
    if ((paramInt == 4) && (this.Ewb != null) && (this.Ewb.sy(2)))
    {
      AppMethodBeat.o(80274);
      return true;
    }
    if ((paramInt == 4) && (this.Ewf != null) && (this.Ewf.bnS()))
    {
      this.Ewf.hide();
      AppMethodBeat.o(80274);
      return true;
    }
    if (paramInt == 4) {
      eWU();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(80274);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(80273);
    if ((paramInt == 82) && (!this.Ewo))
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
    if (this.Ewb != null) {
      this.Ewb.bhk();
    }
    com.tencent.mm.modelstat.d.d(4, "WebViewUI_" + aHI(bu.nullAsNil(this.EvA)), this.Eat.eQU());
    com.tencent.mm.modelstat.d.m("WebViewUI_" + aHI(bu.nullAsNil(this.EvA)), this.vIW, bu.aRi());
    Object localObject = this.Eae.eUn();
    if (((com.tencent.mm.plugin.webview.model.aw)localObject).lastResumeTime != -1L) {
      ((com.tencent.mm.plugin.webview.model.aw)localObject).dCI += bu.aO(((com.tencent.mm.plugin.webview.model.aw)localObject).lastResumeTime) / 1000L;
    }
    localObject = this.Eae.eUo();
    if (((com.tencent.mm.plugin.webview.model.ak)localObject).lastResumeTime != -1L) {
      ((com.tencent.mm.plugin.webview.model.ak)localObject).dCI += bu.aO(((com.tencent.mm.plugin.webview.model.ak)localObject).lastResumeTime);
    }
    localObject = k.EtK;
    ae.v("MicroMsg.WebViewReportUtil", "onPause traceid %s", new Object[] { ((k)localObject).zMj });
    if (((k)localObject).hLB) {
      ae.i("MicroMsg.WebViewReportUtil", "isFinish is true");
    }
    try
    {
      if (this.lzT != null)
      {
        localObject = this.lzT.k(19, null);
        if (localObject != null)
        {
          boolean bool = ((Bundle)localObject).getBoolean("webview_video_proxy_init");
          ae.i("MicroMsg.WebViewUI", "onPause, has init = %b", new Object[] { Boolean.valueOf(bool) });
          if (bool) {
            FactoryProxyManager.getPlayManager().appToBack();
          }
        }
      }
      eWO();
      bi.a(this, null);
      abj("onPause");
      if (this.Evn != null) {
        ae.i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.Evn.onHideCustomView();
          this.Evq.onPause();
          if (this.osM != null) {
            this.osM.onPause();
          }
          AppMethodBeat.o(80234);
          return;
          if (!bu.isNullOrNil(((k)localObject).zMj)) {
            ((k)localObject).md(6);
          }
        }
        localException1 = localException1;
        ae.e("MicroMsg.WebViewUI", "notify app toback failed : %s", new Object[] { localException1.getMessage() });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.WebViewUI", localException2, "onPause", new Object[0]);
        }
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(80242);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    paramArrayOfString = this.lAd;
    if (paramArrayOfString.Enu == null)
    {
      paramArrayOfString.eUy();
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
        paramArrayOfInt = (Intent)paramArrayOfString.Enu.first;
        paramInt = ((Integer)paramArrayOfString.Enu.second).intValue();
        paramArrayOfString.Enu = null;
        startActivityForResult(paramArrayOfInt, paramInt);
      }
      for (;;)
      {
        paramInt = 1;
        break;
        label99:
        paramArrayOfString.Enu = null;
        paramArrayOfString.b(this, 0, null);
      }
    }
    AppMethodBeat.o(80242);
  }
  
  protected void onReset()
  {
    AppMethodBeat.i(80245);
    this.DRx.detach();
    this.DRx = null;
    ((ViewGroup)this.osM.getParent()).removeView(this.osM);
    this.osM.stopLoading();
    this.osM.removeAllViews();
    this.osM.clearView();
    this.osM.destroy();
    this.osM = null;
    this.Evn = null;
    ((ViewGroup)this.EuI.getParent()).removeView(this.EuI);
    if (this.Ewa != null)
    {
      n localn = this.Ewa;
      if (localn.EwN != null)
      {
        LinearLayout localLinearLayout = (LinearLayout)localn.EwL.getController().mActionBar.getCustomView();
        if (localLinearLayout != null) {
          localLinearLayout.removeView(localn.EwN);
        }
      }
    }
    if (this.Eat != null) {
      this.Eat.onDestroy();
    }
    this.Evq.onDestroy();
    this.EvN = false;
    bSx();
    bRQ();
    AppMethodBeat.o(80245);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80233);
    super.onResume();
    if (this.Ewb != null) {
      this.Ewb.bhj();
    }
    if (this.Eat.getCurrentUrl() != null) {
      com.tencent.mm.plugin.webview.j.j.h(this.Eat.getCurrentUrl(), this);
    }
    for (;;)
    {
      this.Eae.eUn().lastResumeTime = bu.HQ();
      this.Eae.eUo().lastResumeTime = bu.HQ();
      Object localObject = k.EtK;
      ae.v("MicroMsg.WebViewReportUtil", "onResume traceid %s", new Object[] { ((k)localObject).zMj });
      if (!bu.isNullOrNil(((k)localObject).zMj)) {
        ((k)localObject).md(7);
      }
      int i;
      if (!this.Ewj)
      {
        int j = this.Eat.eQU();
        i = Evk.size() - 1;
        if (i >= 0)
        {
          if (((e)Evk.get(i)).id == j) {
            Evk.remove(i);
          }
        }
        else {
          Evk.add(new e(this));
        }
      }
      else
      {
        this.Ewj = false;
        if (this.Evl)
        {
          vg(true);
          this.Evl = false;
        }
        eWC();
        updateOrientation();
        if ((getIntent().getBooleanExtra("disable_swipe_back", false)) && (getSwipeBackLayout() != null)) {
          getSwipeBackLayout().setEnableGesture(false);
        }
      }
      try
      {
        bi.a(this, this);
        abj("onResume");
        try
        {
          if (this.lzT != null)
          {
            localObject = this.lzT.k(19, null);
            if (localObject != null)
            {
              boolean bool = ((Bundle)localObject).getBoolean("webview_video_proxy_init");
              ae.i("MicroMsg.WebViewUI", "onResume, has init = %b", new Object[] { Boolean.valueOf(bool) });
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
            ae.e("MicroMsg.WebViewUI", "notify app tofront failed : %s", new Object[] { localException2.getMessage() });
          }
        }
        this.vIW = bu.aRi();
        com.tencent.mm.plugin.webview.a.a.ad(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80087);
            com.tencent.mm.modelstat.d.d(3, "WebViewUI_" + WebViewUI.this.aHI(bu.nullAsNil(WebViewUI.this.EvA)), WebViewUI.this.eQU());
            AppMethodBeat.o(80087);
          }
        });
        if (this.EvO) {
          finish();
        }
        if ((this.EuJ != null) && (this.EuJ.EsV))
        {
          hideVKB();
          this.EuJ.Hs(-2);
        }
        this.Evq.onResume();
        if (this.osM != null) {
          this.osM.onResume();
        }
        AppMethodBeat.o(80233);
        return;
        com.tencent.mm.plugin.webview.j.j.h(bRn(), this);
        continue;
        i -= 1;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          ae.w("MicroMsg.WebViewUI", "setScreenShotCallback fail e:%s", new Object[] { localException1.getMessage() });
        }
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(80266);
    super.onStart();
    ae.i("MicroMsg.WebViewUI", "edw onStart");
    AppMethodBeat.o(80266);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(80267);
    ae.i("MicroMsg.WebViewUI", "edw onStop");
    this.EuC.finish();
    vp(true);
    super.onStop();
    AppMethodBeat.o(80267);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(80290);
    if (this.osM != null)
    {
      if (!this.Ewr) {
        break label46;
      }
      this.osM.setOnLongClickListener(this.Ews);
    }
    for (;;)
    {
      hideVKB();
      super.onSwipeBack();
      AppMethodBeat.o(80290);
      return;
      label46:
      this.osM.setOnLongClickListener(null);
    }
  }
  
  public boolean onSwipeBackFinish()
  {
    AppMethodBeat.i(80293);
    this.EvM = true;
    ay.g localg = this.Eae.eUr();
    if (this.osM != null) {}
    for (String str = this.osM.getUrl();; str = bRn())
    {
      localg.C(new Object[] { str, Integer.valueOf(15) }).report();
      boolean bool = super.onSwipeBackFinish();
      AppMethodBeat.o(80293);
      return bool;
    }
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(80261);
    Object localObject;
    if ((this.Ewa != null) && (!this.Ewa.EwK))
    {
      localObject = this.Ewa;
      if (bu.isNullOrNil(((n)localObject).mzb)) {
        ((n)localObject).mzb = bu.nullAsNil(((n)localObject).EwL.Eat.getCurrentUrl());
      }
      ((n)localObject).eXi();
    }
    long l;
    if (this.EuF != null)
    {
      localObject = this.EuF;
      if (((g)localObject).Est)
      {
        l = System.currentTimeMillis();
        if (((g)localObject).Esq == 0L)
        {
          ((g)localObject).Esq = l;
          ((g)localObject).Esr = paramInt2;
        }
        if ((Math.abs(l - ((g)localObject).Esq) > 200L) && (Math.abs(paramInt2 - ((g)localObject).Esr) > ((g)localObject).Ess))
        {
          if ((paramInt2 - ((g)localObject).Esr <= 0) || (((g)localObject).Esx.getVisibility() != 0)) {
            break label195;
          }
          ((g)localObject).eVJ();
        }
      }
    }
    for (;;)
    {
      ((g)localObject).Esq = l;
      ((g)localObject).Esr = paramInt2;
      AppMethodBeat.o(80261);
      return;
      label195:
      if ((paramInt2 - ((g)localObject).Esr < 0) && (((g)localObject).Esx.getVisibility() != 0)) {
        ((g)localObject).eVI();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(80283);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (eWD())) {
      ax(getWindow().getDecorView(), 5894);
    }
    AppMethodBeat.o(80283);
  }
  
  protected void pp(boolean paramBoolean) {}
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(80221);
    super.setActionbarColor(paramInt);
    if (this.EvC) {
      setStatusBarColor(paramInt);
    }
    AppMethodBeat.o(80221);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    AppMethodBeat.i(80363);
    super.setBackBtn(paramOnMenuItemClickListener, paramInt);
    if ((com.tencent.mm.compatible.util.d.lA(21)) && (eWu())) {
      setBackBtnColorFilter(-16777216);
    }
    AppMethodBeat.o(80363);
  }
  
  public void setMMOrientation()
  {
    AppMethodBeat.i(80263);
    if (getForceOrientation() == -1)
    {
      this.landscapeMode = getSharedPreferences(com.tencent.mm.sdk.platformtools.ak.fow(), 4).getBoolean("settings_landscape_mode", false);
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
    aKh(paramCharSequence.toString());
    aKi(paramCharSequence.toString());
    AppMethodBeat.o(80238);
  }
  
  public void setMMTitle(String paramString)
  {
    AppMethodBeat.i(80237);
    super.setMMTitle(paramString);
    aKh(paramString);
    aKi(paramString);
    AppMethodBeat.o(80237);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(198294);
    this.screenOrientation = paramInt;
    updateOrientation();
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(198294);
  }
  
  @TargetApi(21)
  public final void setStatusBarColor(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(80258);
    Object localObject;
    if (this.EvC)
    {
      localObject = getContentView();
      if (!ao.acF(paramInt)) {
        bool = true;
      }
      com.tencent.mm.ui.statusbar.a.e((View)localObject, paramInt, bool);
      AppMethodBeat.o(80258);
      return;
    }
    if ((this.mKJ <= 0) || (com.tencent.mm.compatible.util.d.lB(21)))
    {
      AppMethodBeat.o(80258);
      return;
    }
    getWindow().setStatusBarColor(0);
    if (this.Ewm == null)
    {
      this.Ewm = new View(this);
      localObject = new ViewGroup.LayoutParams(-1, this.mKJ);
      ((ViewGroup)findViewById(16908290)).addView(this.Ewm, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.Ewm.setBackgroundColor(paramInt);
      AppMethodBeat.o(80258);
      return;
      localObject = this.Ewm.getLayoutParams();
      if (((ViewGroup.LayoutParams)localObject).height != this.mKJ)
      {
        ((ViewGroup.LayoutParams)localObject).height = this.mKJ;
        this.Ewm.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
    if (this.Ewz == -3)
    {
      this.Ewz = -2;
      AppMethodBeat.o(80362);
      return;
    }
    this.Ewz = -3;
    AppMethodBeat.o(80362);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(80369);
    if (bu.lX(paramIntent.getType(), "application/vnd.android.package-archive"))
    {
      r.j(com.tencent.mm.sdk.platformtools.ak.getContext(), paramIntent.getData());
      AppMethodBeat.o(80369);
      return;
    }
    super.startActivity(paramIntent);
    AppMethodBeat.o(80369);
  }
  
  public final void vn(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(80319);
    if (this.EuF != null) {
      this.EuF.vn(paramBoolean);
    }
    ImageButton localImageButton;
    if ((this.osM != null) && (this.Esx != null))
    {
      localImageButton = this.EuG;
      if ((this.osM == null) || (!this.osM.canGoBack())) {
        break label102;
      }
      paramBoolean = true;
      localImageButton.setEnabled(paramBoolean);
      localImageButton = this.EuH;
      if ((this.osM == null) || (!this.osM.canGoForward())) {
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
  
  protected void vo(boolean paramBoolean)
  {
    AppMethodBeat.i(80310);
    this.Ewo = paramBoolean;
    if (this.osM == null)
    {
      ae.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
      AppMethodBeat.o(80310);
      return;
    }
    enableOptionMenu(paramBoolean);
    showOptionMenu(paramBoolean);
    boolean bool1 = getIntent().getBooleanExtra("show_feedback", false);
    if (bool1) {
      showOptionMenu(bool1);
    }
    int i = eWN();
    if (eWM() != null) {
      i = 2131690809;
    }
    bool1 = getIntent().getBooleanExtra("KRightBtn", false);
    boolean bool2 = getIntent().getBooleanExtra("KShowFixToolsBtn", false);
    ae.i("MicroMsg.WebViewUI", "banRightBtn:%b, showFixToolsBtn:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$34", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
          if (WebViewUI.this.lzU.aJD(WebViewUI.this.eRj())) {
            WebViewUI.this.Eae.eUr().C(new Object[] { WebViewUI.this.bRn(), Integer.valueOf(6) }).report();
          }
          for (;;)
          {
            WebViewUI.this.bRT();
            AppMethodBeat.o(80082);
            return true;
            WebViewUI.this.Eae.eUr().C(new Object[] { WebViewUI.this.bRn(), Integer.valueOf(5) }).report();
          }
        }
      }, this.Ewv);
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      vq(paramBoolean);
      AppMethodBeat.o(80310);
      return;
    }
  }
  
  protected final void vp(boolean paramBoolean)
  {
    AppMethodBeat.i(198302);
    enableOptionMenu(true);
    ae.d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", new Object[] { Boolean.TRUE });
    setProgressBarIndeterminateVisibility(false);
    if (paramBoolean)
    {
      this.EvT.eVR();
      AppMethodBeat.o(198302);
      return;
    }
    if ((!this.EvE) && (!this.EvF)) {
      this.Eat.bRx();
    }
    AppMethodBeat.o(198302);
  }
  
  public final void vq(boolean paramBoolean)
  {
    AppMethodBeat.i(80359);
    String str = this.osM.getUrl();
    if (paramBoolean)
    {
      showOptionMenu(0, false);
      this.Evw.put(str, Boolean.TRUE);
      AppMethodBeat.o(80359);
      return;
    }
    showOptionMenu(0, true);
    if (this.Evw.containsKey(str)) {
      this.Evw.remove(str);
    }
    AppMethodBeat.o(80359);
  }
  
  protected void z(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80358);
    ae.i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
    AppMethodBeat.o(80358);
  }
  
  protected static final class a
  {
    private String Eis;
    private String Eit;
    private String Eiu;
    private String Eiv;
    private String Eiw;
    private String Eix;
    private String EwF;
    private String lang;
    
    private a(Bundle paramBundle)
    {
      AppMethodBeat.i(80123);
      this.EwF = paramBundle.getString("close_window_confirm_dialog_switch");
      this.Eis = paramBundle.getString("close_window_confirm_dialog_title_cn");
      this.Eit = paramBundle.getString("close_window_confirm_dialog_title_eng");
      this.Eiu = paramBundle.getString("close_window_confirm_dialog_ok_cn");
      this.Eiv = paramBundle.getString("close_window_confirm_dialog_ok_eng");
      this.Eiw = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
      this.Eix = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
      this.lang = paramBundle.getString("application_language");
      AppMethodBeat.o(80123);
    }
    
    public static a aQ(Bundle paramBundle)
    {
      AppMethodBeat.i(80124);
      paramBundle = new a(paramBundle);
      AppMethodBeat.o(80124);
      return paramBundle;
    }
    
    public final boolean eTw()
    {
      AppMethodBeat.i(80125);
      if (bu.isNullOrNil(this.EwF))
      {
        AppMethodBeat.o(80125);
        return false;
      }
      boolean bool = this.EwF.equals("true");
      AppMethodBeat.o(80125);
      return bool;
    }
    
    public final String eTy()
    {
      AppMethodBeat.i(80127);
      if ("zh_CN".equals(this.lang))
      {
        str = this.Eiu;
        AppMethodBeat.o(80127);
        return str;
      }
      String str = this.Eiv;
      AppMethodBeat.o(80127);
      return str;
    }
    
    public final String eTz()
    {
      AppMethodBeat.i(80128);
      if ("zh_CN".equals(this.lang))
      {
        str = this.Eiw;
        AppMethodBeat.o(80128);
        return str;
      }
      String str = this.Eix;
      AppMethodBeat.o(80128);
      return str;
    }
    
    public final String eXd()
    {
      AppMethodBeat.i(80126);
      if ("zh_CN".equals(this.lang))
      {
        str = this.Eis;
        AppMethodBeat.o(80126);
        return str;
      }
      String str = this.Eit;
      AppMethodBeat.o(80126);
      return str;
    }
  }
  
  public class b
    extends com.tencent.xweb.x
  {
    public volatile boolean guz;
    com.tencent.mm.ui.widget.a.d jxa;
    
    protected b()
    {
      AppMethodBeat.i(80144);
      this.guz = false;
      this.jxa = null;
      AppMethodBeat.o(80144);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(80148);
      ae.d("MicroMsg.WebViewUI", "onProgressChanged %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(80148);
    }
    
    public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(80145);
      com.tencent.mm.plugin.ball.f.f.e(true, true, false);
      if (WebViewUI.this.eSk().EfT)
      {
        MPVideoPlayFullScreenView localMPVideoPlayFullScreenView = WebViewUI.this.eWl();
        Context localContext = localMPVideoPlayFullScreenView.getContext();
        if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).osM != null)) {
          localMPVideoPlayFullScreenView.EGo = ((WebViewUI)localContext).osM.setVideoJsCallback((com.tencent.xweb.v)new MPVideoPlayFullScreenView.i(localMPVideoPlayFullScreenView));
        }
        if (localMPVideoPlayFullScreenView.EGo != null) {}
        for (int i = 1; i != 0; i = 0)
        {
          WebViewUI.a(WebViewUI.this, paramCustomViewCallback);
          ae.i("MicroMsg.WebViewUI", "onEnterFullscreen view");
          if (paramView.getParent() == null) {
            WebViewUI.this.eWl().fN(paramView);
          }
          AppMethodBeat.o(80145);
          return true;
        }
      }
      if (WebViewUI.this.eSk().EfT) {
        WebViewUI.this.eSk().vj(false);
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
          ae.i("MicroMsg.WebViewUI", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
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
          WebViewUI.p(WebViewUI.this).a(WebViewUI.this, WebViewUI.this.lzU, null, paramValueCallback, str2, paramWebView);
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
      ae.d("MicroMsg.WebViewUI", "onJsAlert");
      final PBool localPBool = new PBool();
      localPBool.value = false;
      if ((WebViewUI.this.isFinishing()) || (WebViewUI.this.activityHasDestroyed()))
      {
        ae.d("MicroMsg.WebViewUI", "onJsAlert finish");
        paramJsResult.cancel();
        AppMethodBeat.o(80158);
        return true;
      }
      WebViewUI.q(WebViewUI.this);
      if (WebViewUI.r(WebViewUI.this) > 2) {}
      for (this.jxa = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131766261), WebViewUI.this.getString(2131755835), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80142);
              com.tencent.mm.plugin.report.service.g.yxI.f(11683, new Object[] { paramString1, Integer.valueOf(1), Integer.valueOf(WebViewUI.r(WebViewUI.this)) });
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
          }, 2131100547); this.jxa != null; this.jxa = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131755835), new DialogInterface.OnClickListener()
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
        this.jxa.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(80135);
            ae.d("MicroMsg.WebViewUI", "onJsAlert, onDismiss");
            if (!localPBool.value) {
              paramJsResult.cancel();
            }
            AppMethodBeat.o(80135);
          }
        });
        this.jxa.setCanceledOnTouchOutside(false);
        this.jxa.zc(false);
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
      ae.d("MicroMsg.WebViewUI", "onJsConfirm");
      final PBool localPBool = new PBool();
      localPBool.value = false;
      if ((WebViewUI.this.isFinishing()) || (WebViewUI.this.activityHasDestroyed()))
      {
        ae.d("MicroMsg.WebViewUI", "onJsConfirm finish");
        paramJsResult.cancel();
        AppMethodBeat.o(80156);
        return true;
      }
      WebViewUI.q(WebViewUI.this);
      if (WebViewUI.r(WebViewUI.this) > 2) {}
      for (this.jxa = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131766261), WebViewUI.this.getString(2131755835), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80137);
              com.tencent.mm.plugin.report.service.g.yxI.f(11683, new Object[] { paramString1, Integer.valueOf(1), Integer.valueOf(WebViewUI.r(WebViewUI.this)) });
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
          }, 2131100053); this.jxa != null; this.jxa = com.tencent.mm.ui.base.h.a(WebViewUI.this.getContext(), false, paramString2, "", WebViewUI.this.getString(2131755835), WebViewUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
        this.jxa.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(80141);
            ae.d("MicroMsg.WebViewUI", "onJsConfirm, onDismiss");
            if (!localPBool.value) {
              paramJsResult.cancel();
            }
            AppMethodBeat.o(80141);
          }
        });
        this.jxa.setCancelable(false);
        this.jxa.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(80156);
        return true;
      }
      boolean bool = super.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(80156);
      return bool;
    }
    
    public final boolean bpU()
    {
      AppMethodBeat.i(80146);
      com.tencent.mm.plugin.ball.f.f.e(false, true, false);
      boolean bool = super.bpU();
      AppMethodBeat.o(80146);
      return bool;
    }
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80149);
      ae.i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", new Object[] { paramString, WebViewUI.this.eWw() });
      super.d(paramWebView, paramString);
      if ((WebViewUI.this.EuA) && (!WebViewUI.k(WebViewUI.this)))
      {
        ae.i("MicroMsg.WebViewUI", "fixed title, ignore received title: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(80149);
        return;
      }
      if (paramString == null)
      {
        ae.e("MicroMsg.WebViewUI", "null title");
        AppMethodBeat.o(80149);
        return;
      }
      if (!WebViewUI.this.yOS)
      {
        AppMethodBeat.o(80149);
        return;
      }
      if ((!bu.nullAsNil(WebViewUI.this.eWw()).equals(paramString)) && (!com.tencent.mm.plugin.webview.luggage.c.b.VG(paramString)) && (!paramString.startsWith("about:blank"))) {
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
      if ((WebViewUI.this.DRx != null) && (WebViewUI.this.eSk().EfT) && (WebViewUI.this.eWl().getVisibility() == 0))
      {
        if (WebViewUI.j(WebViewUI.this) != null) {
          WebViewUI.j(WebViewUI.this).onCustomViewHidden();
        }
        WebViewUI.this.eSk().vj(false);
        MPVideoPlayFullScreenView localMPVideoPlayFullScreenView = WebViewUI.this.eWl();
        if (localMPVideoPlayFullScreenView.BAY)
        {
          ae.i(localMPVideoPlayFullScreenView.TAG, "isRunningExitAnimation");
          AppMethodBeat.o(80147);
          return;
        }
        localMPVideoPlayFullScreenView.eYG();
        if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
        {
          localObject = new ImageView(localMPVideoPlayFullScreenView.getContext());
          ViewGroup localViewGroup = localMPVideoPlayFullScreenView.EGh;
          if (localViewGroup != null) {
            localViewGroup.addView((View)localObject, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
          }
          ((ImageView)localObject).setImageBitmap(paramBitmap);
        }
        ae.i(localMPVideoPlayFullScreenView.TAG, "runExitAnimation");
        localMPVideoPlayFullScreenView.eYH();
        int j = localMPVideoPlayFullScreenView.EGe.getWidth();
        int i = localMPVideoPlayFullScreenView.EGe.getHeight();
        paramBitmap = localMPVideoPlayFullScreenView.oMQ;
        if (paramBitmap != null) {
          paramBitmap.kg(j, i);
        }
        paramBitmap = localMPVideoPlayFullScreenView.oMQ;
        int k;
        if (paramBitmap != null)
        {
          localObject = localMPVideoPlayFullScreenView.hCc;
          if (localObject == null) {
            d.g.b.p.gkB();
          }
          j = ((y)localObject).hGC;
          localObject = localMPVideoPlayFullScreenView.hCc;
          if (localObject == null) {
            d.g.b.p.gkB();
          }
          k = ((y)localObject).hGD;
          localObject = localMPVideoPlayFullScreenView.hCc;
          if (localObject == null) {
            d.g.b.p.gkB();
          }
          int m = ((y)localObject).hGE;
          localObject = localMPVideoPlayFullScreenView.hCc;
          if (localObject == null) {
            d.g.b.p.gkB();
          }
          paramBitmap.R(j, k, m, ((y)localObject).hGF);
        }
        if (localMPVideoPlayFullScreenView.Ary != 1.0D)
        {
          paramBitmap = localMPVideoPlayFullScreenView.oMQ;
          if (paramBitmap != null) {
            paramBitmap.LeF = (1.0F / localMPVideoPlayFullScreenView.Ary);
          }
          if ((localMPVideoPlayFullScreenView.Arz != 0) || (localMPVideoPlayFullScreenView.ArA != 0))
          {
            j = (int)(localMPVideoPlayFullScreenView.EGe.getWidth() / 2 * (1.0F - localMPVideoPlayFullScreenView.Ary));
            k = localMPVideoPlayFullScreenView.Arz;
            i = (int)(localMPVideoPlayFullScreenView.EGe.getHeight() / 2 + localMPVideoPlayFullScreenView.ArA - i / 2 * localMPVideoPlayFullScreenView.Ary);
            paramBitmap = localMPVideoPlayFullScreenView.oMQ;
            if (paramBitmap != null) {
              paramBitmap.ki(j + k, i);
            }
          }
        }
        paramBitmap = localMPVideoPlayFullScreenView.EGe.getLayoutParams();
        Object localObject = localMPVideoPlayFullScreenView.oMQ;
        if (localObject != null)
        {
          ((com.tencent.mm.ui.tools.e)localObject).a((View)localMPVideoPlayFullScreenView.EGh, localMPVideoPlayFullScreenView.EGe, (e.c)new MPVideoPlayFullScreenView.q(localMPVideoPlayFullScreenView, paramBitmap), null);
          AppMethodBeat.o(80147);
          return;
        }
      }
      AppMethodBeat.o(80147);
    }
    
    public final void onGeolocationPermissionsShowPrompt(final String paramString, final GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(80153);
      ae.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[] { paramString });
      if (!com.tencent.mm.pluginsdk.permission.b.n(WebViewUI.this, "android.permission.ACCESS_COARSE_LOCATION")) {
        com.tencent.mm.pluginsdk.permission.b.b(WebViewUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64);
      }
      com.tencent.mm.ui.base.h.a(WebViewUI.this, false, WebViewUI.this.getString(2131766268, new Object[] { paramString }), WebViewUI.this.getString(2131766269), WebViewUI.this.getString(2131755835), WebViewUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(80133);
          ae.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt ok");
          paramCallback.invoke(paramString, true, true);
          e.a(WebViewUI.this.lzT, 14340, new Object[] { WebViewUI.this.bRn(), WebViewUI.this.eRj(), Integer.valueOf(WebViewUI.this.bpW()), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(com.tencent.mm.plugin.webview.model.ay.bma()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(80133);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(80136);
          ae.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt cancel");
          paramCallback.invoke(paramString, false, false);
          e.a(WebViewUI.this.lzT, 14340, new Object[] { WebViewUI.this.bRn(), WebViewUI.this.eRj(), Integer.valueOf(WebViewUI.this.bpW()), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(com.tencent.mm.plugin.webview.model.ay.bma()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(80136);
        }
      });
      AppMethodBeat.o(80153);
    }
    
    public final void onHideCustomView()
    {
      AppMethodBeat.i(80151);
      ae.i("MicroMsg.WebViewUI", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
      WebViewUI.this.getContext().getWindow().clearFlags(128);
      if (WebViewUI.l(WebViewUI.this) == null)
      {
        AppMethodBeat.o(80151);
        return;
      }
      try
      {
        WebViewUI.this.vn(WebViewUI.this.bRS());
        if (!WebViewUI.this.osM.isXWalkKernel())
        {
          WebViewUI.this.osM.setVisibility(0);
          WebViewUI.this.setTitleVisibility(0);
        }
        for (;;)
        {
          if (WebViewUI.this.EuL != null) {
            WebViewUI.this.EuL.removeView(WebViewUI.l(WebViewUI.this));
          }
          WebViewUI.a(WebViewUI.this, null);
          if (WebViewUI.n(WebViewUI.this) != null) {
            WebViewUI.n(WebViewUI.this).onCustomViewHidden();
          }
          AppMethodBeat.o(80151);
          return;
          WebViewUI.this.fullScreenNoTitleBar(false);
          WebViewUI.this.setStatusBarColor(WebViewUI.this.getResources().getColor(2131100952));
          if (WebViewUI.this.Ewl != null)
          {
            ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)WebViewUI.this.Ewl.getLayoutParams();
            int i = WebViewUI.m(WebViewUI.this);
            if (i != localMarginLayoutParams.topMargin)
            {
              localMarginLayoutParams.topMargin = i;
              WebViewUI.this.Ewl.setLayoutParams(localMarginLayoutParams);
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.WebViewUI", "onHideCustomView error " + localException.getMessage());
        AppMethodBeat.o(80151);
      }
    }
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(80150);
      ae.i("MicroMsg.WebViewUI", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
      try
      {
        WebViewUI.this.getContext().getWindow().addFlags(128);
        if (WebViewUI.l(WebViewUI.this) != null)
        {
          paramCustomViewCallback.onCustomViewHidden();
          AppMethodBeat.o(80150);
          return;
        }
        WebViewUI.this.vn(false);
        WebViewUI.a(WebViewUI.this, paramView);
        WebViewUI.b(WebViewUI.this, paramCustomViewCallback);
        if (!WebViewUI.this.osM.isXWalkKernel())
        {
          WebViewUI.this.osM.setVisibility(8);
          WebViewUI.this.EuL.addView(paramView);
          WebViewUI.this.setTitleVisibility(4);
          AppMethodBeat.o(80150);
          return;
        }
      }
      catch (Exception paramView)
      {
        ae.e("MicroMsg.WebViewUI", "onShowCustomView error " + paramView.getMessage());
        AppMethodBeat.o(80150);
        return;
      }
      WebViewUI.this.EuL.addView(paramView, 0);
      WebViewUI.this.fullScreenNoTitleBar(true);
      WebViewUI.this.setStatusBarColor(0);
      if (WebViewUI.this.Ewl != null)
      {
        paramView = (ViewGroup.MarginLayoutParams)WebViewUI.this.Ewl.getLayoutParams();
        paramView.topMargin = 0;
        WebViewUI.this.Ewl.setLayoutParams(paramView);
      }
      AppMethodBeat.o(80150);
    }
    
    public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      AppMethodBeat.i(80154);
      WebViewUI.p(WebViewUI.this).a(WebViewUI.this, WebViewUI.this.lzU, paramValueCallback, null, paramString1, paramString2);
      AppMethodBeat.o(80154);
    }
  }
  
  public final class c
    extends com.tencent.mm.plugin.webview.core.j
  {
    public c() {}
    
    public final boolean c(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(198275);
      ae.e("MicroMsg.WebViewUI", "edw interceptLoadError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1, Boolean.valueOf(az.isConnected(WebViewUI.this)) });
      AppMethodBeat.o(198275);
      return false;
    }
    
    public final com.tencent.mm.plugin.webview.core.e eRA()
    {
      AppMethodBeat.i(198277);
      a locala = new a((byte)0);
      AppMethodBeat.o(198277);
      return locala;
    }
    
    public final com.tencent.mm.plugin.webview.core.i eRB()
    {
      AppMethodBeat.i(198278);
      b localb = new b((byte)0);
      AppMethodBeat.o(198278);
      return localb;
    }
    
    public final boolean eRz()
    {
      AppMethodBeat.i(198276);
      if ((WebViewUI.this.EvK) || (WebViewUI.s(WebViewUI.this)) || (WebViewUI.this.isFinishing()))
      {
        AppMethodBeat.o(198276);
        return true;
      }
      AppMethodBeat.o(198276);
      return false;
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
        WebViewUI.this.EvT.Eti = false;
      }
      
      public final void aHE(String paramString)
      {
        AppMethodBeat.i(198255);
        if (!WebViewUI.this.Ewt) {
          WebViewUI.this.EvT.eVS();
        }
        WebViewUI.this.Ewp.eVZ();
        WebViewUI.this.Ewp.setCurrentURL(paramString);
        WebViewUI.this.setProgressBarIndeterminateVisibility(false);
        WebViewUI.this.EvT.f(paramString, WebViewUI.this.getIntent());
        WebViewUI.this.vp(false);
        n localn;
        if ((WebViewUI.this.Ewa != null) && (!WebViewUI.this.Ewa.EwK))
        {
          localn = WebViewUI.this.Ewa;
          ae.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageStart, url:%s", new Object[] { paramString });
          localn.mzb = paramString;
          localn.eXf();
          paramString = (Bundle)n.EsY.get(n.XC(localn.mzb));
          if ((paramString != null) && (localn.EwL != null)) {
            break label219;
          }
          localn.eXm();
        }
        for (;;)
        {
          WebViewUI.t(WebViewUI.this);
          AppMethodBeat.o(198255);
          return;
          label219:
          if (paramString.getBoolean("key_current_info_show")) {
            localn.eXl();
          } else {
            localn.eXm();
          }
        }
      }
      
      public final void aHF(String paramString)
      {
        AppMethodBeat.i(198257);
        WebViewUI.this.Ewp.eVZ();
        if ((WebViewUI.v(WebViewUI.this) != null) && (az.isNetworkConnected(WebViewUI.this.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8")))
        {
          WebViewUI.v(WebViewUI.this).eD("rawUrl", paramString);
          WebViewUI.v(WebViewUI.this).aIr(paramString);
        }
        WebViewUI.d(WebViewUI.this, paramString);
        WebViewUI.this.vn(WebViewUI.this.bRS());
        AppMethodBeat.o(198257);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(198256);
        WebViewUI.u(WebViewUI.this);
        if ((WebViewUI.v(WebViewUI.this) != null) && (az.isNetworkConnected(WebViewUI.this.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8")))
        {
          WebViewUI.v(WebViewUI.this).eD("rawUrl", paramString);
          WebViewUI.v(WebViewUI.this).aIr(paramString);
        }
        WebViewUI.d(WebViewUI.this, paramString);
        if (!WebViewUI.w(WebViewUI.this))
        {
          WebViewUI.x(WebViewUI.this);
          WebViewUI.this.Eae.eUq().loadFinished = true;
        }
        Object localObject = WebViewUI.this.osM.getTitle();
        ae.i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", new Object[] { WebViewUI.this.getMMTitle(), localObject, Boolean.valueOf(WebViewUI.this.EuA), Boolean.valueOf(WebViewUI.this.yOS), WebViewUI.this.eWw() });
        if ((WebViewUI.c.this.controller.osM.getIsX5Kernel()) && (!bu.isNullOrNil((String)localObject)) && (((String)localObject).length() > 0) && (!((String)localObject).equals(WebViewUI.this.getMMTitle())) && (!((String)localObject).startsWith("http")) && ((WebViewUI.this.eWw() == null) || (!WebViewUI.this.eWw().equals(localObject))) && (!WebViewUI.this.EuA) && (WebViewUI.this.yOS))
        {
          ae.d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
          WebViewUI.this.setMMTitle((String)localObject);
        }
        WebViewUI.this.Ewp.setCurrentURL(WebViewUI.this.eRj());
        WebViewUI.this.setProgressBarIndeterminateVisibility(false);
        WebViewUI.this.EuC.finish();
        if ((WebViewUI.this.Ewa != null) && (!WebViewUI.this.Ewa.EwK))
        {
          localObject = WebViewUI.this.Ewa;
          ae.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", new Object[] { paramString });
          ((n)localObject).mzb = paramString;
        }
        WebViewUI.e(WebViewUI.this, paramString);
        WebViewUI.this.b(paramWebView, paramString);
        AppMethodBeat.o(198256);
      }
      
      public final void e(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(198258);
        super.e(paramWebView, paramString);
        paramWebView = WebViewUI.this.Ewa;
        ae.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", new Object[] { paramString });
        paramWebView.mzb = paramString;
        AppMethodBeat.o(198258);
      }
    }
    
    final class b
      extends com.tencent.mm.plugin.webview.core.i
    {
      private b() {}
      
      public final void Xc(int paramInt)
      {
        AppMethodBeat.i(198271);
        if (WebViewUI.this.EuI != null)
        {
          FontChooserView localFontChooserView = (FontChooserView)WebViewUI.this.EuI.findViewById(2131300194);
          if (localFontChooserView != null) {
            localFontChooserView.setSliderIndex(paramInt - 1);
          }
        }
        AppMethodBeat.o(198271);
      }
      
      public final void a(String paramString, avz paramavz)
      {
        AppMethodBeat.i(198262);
        if (!bu.isNullOrNil(paramavz.Title)) {
          WebViewUI.this.setMMTitle(paramavz.Title);
        }
        if (paramavz.FJl == 6) {
          WebViewUI.this.vo(false);
        }
        AppMethodBeat.o(198262);
      }
      
      public final void aHN(String paramString)
      {
        AppMethodBeat.i(198261);
        WebViewUI.this.bRU();
        AppMethodBeat.o(198261);
      }
      
      public final void aHO(String paramString)
      {
        AppMethodBeat.i(198269);
        WebViewUI.this.aKg(paramString);
        AppMethodBeat.o(198269);
      }
      
      public final void b(String paramString, avz paramavz)
      {
        WebViewUI.this.EvT.Etf = paramavz.GNg;
      }
      
      public final void bSg()
      {
        AppMethodBeat.i(198264);
        WebViewUI.this.vp(true);
        AppMethodBeat.o(198264);
      }
      
      public final void bm(int paramInt, String paramString)
      {
        AppMethodBeat.i(198259);
        super.bm(paramInt, paramString);
        if (paramInt != 5) {
          WebViewUI.this.vp(false);
        }
        AppMethodBeat.o(198259);
      }
      
      public final void c(String paramString, avz paramavz)
      {
        AppMethodBeat.i(198263);
        WebViewUI.this.osm = paramavz.GNB;
        WebViewUI.b(WebViewUI.this, WebViewUI.this.lzU.eUS().mC(24));
        WebViewUI.this.Eae.eUq().Enb = true;
        WebViewUI.this.Evg = com.tencent.mm.platformtools.z.a(paramavz.GNA);
        ae.d("MicroMsg.WebViewUI", "onPermissionUpdate, getA8Key = %s", new Object[] { bu.cH(WebViewUI.this.Evg) });
        AppMethodBeat.o(198263);
      }
      
      public final void d(int paramInt1, String paramString1, int paramInt2, String paramString2)
      {
        AppMethodBeat.i(198272);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(154L, 12L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(154L, com.tencent.mm.plugin.webview.h.a.XE(paramInt1), 1L, false);
        WebViewUI.this.vp(true);
        WebViewUI.this.EvT.Eti = false;
        switch (paramInt1)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(198272);
          return;
          k.EtK.Yd(paramInt2);
          if ((WebViewUI.this.Evz != null) && (this.controller.eRg())) {
            WebViewUI.this.eWP();
          }
          WebViewUI.this.Eae.eUq().Enb = false;
          WebViewUI.this.Eae.eUk().cs(paramString1, false);
          if (WebViewUI.A(WebViewUI.this)) {
            WebViewUI.this.finish();
          }
        }
      }
      
      public final void eRu()
      {
        AppMethodBeat.i(198260);
        ae.i("MicroMsg.WebViewUI", "WebView-Trace onAuthSucc: url %s", new Object[] { WebViewUI.this.osm });
        WebViewUI.a(WebViewUI.this, this.controller.lzU.eUS());
        if (!WebViewUI.this.Ewt) {
          WebViewUI.this.EvT.Eti = true;
        }
        i locali = WebViewUI.this.EvT;
        locali.Etj.add(Integer.valueOf(6));
        locali.Etj.add(Integer.valueOf(1));
        locali.Etj.add(Integer.valueOf(3));
        locali.Etj.add(Integer.valueOf(2));
        WebViewUI.this.EvT.Eti = true;
        if (WebViewUI.this.EvT.oyA) {
          WebViewUI.this.bRT();
        }
        AppMethodBeat.o(198260);
      }
      
      public final void eRv()
      {
        AppMethodBeat.i(198266);
        WebViewUI.this.goBack();
        AppMethodBeat.o(198266);
      }
      
      public final void eRw()
      {
        AppMethodBeat.i(198268);
        WebViewUI.this.eWz();
        AppMethodBeat.o(198268);
      }
      
      public final void eRx()
      {
        AppMethodBeat.i(198273);
        super.eRx();
        if ((!WebViewUI.this.EvE) && (!WebViewUI.this.EvF)) {
          WebViewUI.this.EuC.start();
        }
        AppMethodBeat.o(198273);
      }
      
      public final void eRy()
      {
        AppMethodBeat.i(198274);
        super.eRy();
        WebViewUI.this.EuC.finish();
        AppMethodBeat.o(198274);
      }
      
      public final void eag()
      {
        AppMethodBeat.i(198265);
        if (WebViewUI.this.EvN)
        {
          ae.e("MicroMsg.WebViewUI", "edw postBinded hasDoPostBind");
          AppMethodBeat.o(198265);
          return;
        }
        WebViewUI.this.EvN = true;
        WebViewUI.this.bAi();
        AppMethodBeat.o(198265);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(198267);
        WebViewUI.this.finish();
        AppMethodBeat.o(198267);
      }
      
      public final void vb(boolean paramBoolean)
      {
        AppMethodBeat.i(198270);
        if ((paramBoolean) && (WebViewUI.this.osM != null))
        {
          WebViewUI.this.osM.setOnLongClickListener(WebViewUI.y(WebViewUI.this));
          WebViewUI.z(WebViewUI.this);
        }
        AppMethodBeat.o(198270);
      }
    }
  }
  
  final class d
    implements FontChooserView.a
  {
    private d() {}
    
    public final void PL(int paramInt)
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
        WebViewUI.this.Eat.Xb(i);
        try
        {
          if (WebViewUI.this.lzT.eVf())
          {
            com.tencent.mm.sdk.platformtools.ay localay = com.tencent.mm.sdk.platformtools.ay.gq("WebViewFontUtil", 2);
            localay.putBoolean("webview_key_font_has_set", true);
            localay.putBoolean("webview_key_has_transfer_mp", true);
            localay.apply();
            com.tencent.mm.plugin.webview.j.f.vD(false);
            WebViewUI.this.lzT.jf(16384, i);
            WebViewUI.this.lzT.jf(16388, i);
          }
          AppMethodBeat.o(80184);
          return;
        }
        catch (Exception localException)
        {
          ae.w("MicroMsg.WebViewUI", "onCheckedChanged, ex = " + localException.getMessage());
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
    final WeakReference<WebViewUI> lZK;
    
    public e(WebViewUI paramWebViewUI)
    {
      AppMethodBeat.i(80216);
      this.lZK = new WeakReference(paramWebViewUI);
      this.id = paramWebViewUI.eQU();
      AppMethodBeat.o(80216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI
 * JD-Core Version:    0.7.0.1
 */