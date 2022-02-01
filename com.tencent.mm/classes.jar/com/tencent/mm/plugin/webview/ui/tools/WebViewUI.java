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
import com.tencent.mm.g.a.sp;
import com.tencent.mm.m.d.a;
import com.tencent.mm.m.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.c.f.24;
import com.tencent.mm.plugin.webview.c.f.59;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.c;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.f;
import com.tencent.mm.plugin.webview.model.aq;
import com.tencent.mm.plugin.webview.model.av;
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
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.model.w.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bg.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
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
  implements View.OnCreateContextMenuListener, com.tencent.mm.plugin.webview.core.b, com.tencent.mm.plugin.webview.g.a.b, com.tencent.mm.plugin.webview.ui.tools.c.a.e, bg.a, MMWebView.e
{
  private static Boolean CAA;
  private static final Pattern ClN;
  private static final Pattern ClO;
  private static final ArrayList<e> CzA;
  private static WebSettings.RenderPriority CzF;
  protected static int CzZ;
  protected View CAB;
  private View CAC;
  private com.tencent.mm.bo.a.b CAD;
  private boolean CAE;
  public final j CAF;
  public final com.tencent.mm.plugin.webview.ui.tools.media.d CAG;
  private boolean CAH;
  private View.OnLongClickListener CAI;
  protected boolean CAJ;
  private View.OnLongClickListener CAK;
  protected View.OnLongClickListener CAL;
  private String CAM;
  protected volatile String CAN;
  private WebChromeClient.CustomViewCallback CAO;
  public int CAP;
  public boolean CAa;
  private boolean CAb;
  private boolean CAc;
  protected boolean CAd;
  protected volatile boolean CAe;
  private com.tencent.mm.plugin.webview.j.h CAf;
  private com.tencent.mm.plugin.webview.model.b CAg;
  protected com.tencent.mm.plugin.webview.modeltools.n CAh;
  protected h CAi;
  public i CAj;
  protected IUtils CAk;
  private WebViewClipBoardHelper CAl;
  protected com.tencent.mm.plugin.webview.c CAm;
  protected volatile String CAn;
  protected volatile long CAo;
  protected HandOffURL CAp;
  public n CAq;
  com.tencent.mm.plugin.webview.ui.tools.b.a CAr;
  private boolean CAs;
  protected com.tencent.xweb.ab CAt;
  private com.tencent.mm.sdk.b.c<sp> CAu;
  private com.tencent.mm.plugin.webview.ui.tools.widget.n CAv;
  private boolean CAw;
  private MPVideoPlayFullScreenView CAx;
  int CAy;
  private boolean CAz;
  public com.tencent.mm.plugin.webview.model.ax Cfc;
  protected com.tencent.mm.plugin.webview.core.h Cfr;
  public com.tencent.mm.plugin.webview.c.f Cjc;
  protected com.tencent.mm.plugin.webview.stub.f CkJ;
  private View CwN;
  final com.tencent.mm.plugin.webview.modeltools.a Cxh;
  protected boolean CyP;
  private boolean CyQ;
  protected MMFalseProgressBar CyR;
  public ProgressBar CyS;
  public com.tencent.mm.ui.base.p CyT;
  private g CyU;
  private ImageButton CyV;
  private ImageButton CyW;
  protected View CyX;
  protected WebViewKeyboardLinearLayout CyY;
  protected FrameLayout CyZ;
  private boolean CzB;
  private WebChromeClient.CustomViewCallback CzC;
  protected com.tencent.xweb.x CzD;
  private ProgressBar CzE;
  private com.tencent.mm.plugin.webview.ui.tools.c.a.h CzG;
  private final com.tencent.mm.sdk.b.c<SendDataToH5FromMiniProgramEvent> CzH;
  private boolean CzI;
  protected HashMap<String, Boolean> CzJ;
  protected HashMap<String, String> CzK;
  protected HashMap<String, ArrayList<d.b>> CzL;
  protected HashMap<String, Boolean> CzM;
  protected a CzN;
  protected com.tencent.mm.ui.widget.a.d CzO;
  protected View CzP;
  protected String CzQ;
  private boolean CzR;
  private final boolean CzS;
  private boolean CzT;
  protected volatile boolean CzU;
  protected boolean CzV;
  private Map CzW;
  private int CzX;
  public int CzY;
  public FrameLayout Cza;
  protected MovingImageButton Czb;
  protected boolean Czc;
  private boolean Czd;
  protected com.tencent.mm.bo.a Cze;
  private WebViewInputFooter Czf;
  protected WebViewSearchContentInputFooter Czg;
  private boolean Czh;
  private boolean Czi;
  public String Czj;
  protected boolean Czk;
  protected boolean Czl;
  protected long Czm;
  private boolean Czn;
  private int Czo;
  int Czp;
  private boolean Czr;
  protected boolean Czs;
  private boolean Czt;
  protected boolean Czu;
  protected int Czv;
  protected byte[] Czw;
  private boolean Czx;
  private View Czy;
  private au Czz;
  public String dvr;
  private com.tencent.mm.ui.base.p fua;
  public ao handler;
  private final com.tencent.mm.plugin.webview.modeltools.d kYD;
  public com.tencent.mm.plugin.webview.stub.e kYt;
  protected com.tencent.mm.plugin.webview.e.g kYu;
  private int mfe;
  private int nEl;
  public String nJQ;
  public MMWebView nKq;
  protected int nwY;
  protected int nwZ;
  protected com.tencent.mm.ui.widget.snackbar.a.b sXH;
  protected int screenOrientation;
  protected String sessionId;
  private View tk;
  public int tnu;
  public String tnv;
  private long uup;
  protected boolean xkQ;
  
  static
  {
    AppMethodBeat.i(80400);
    CzA = new ArrayList();
    CzF = WebSettings.RenderPriority.NORMAL;
    CzZ = 0;
    CAA = null;
    ClN = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    ClO = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    AppMethodBeat.o(80400);
  }
  
  public WebViewUI()
  {
    AppMethodBeat.i(80217);
    this.CyP = false;
    this.CyQ = false;
    this.screenOrientation = -1;
    this.Czc = false;
    this.Czd = false;
    this.Czj = null;
    this.Czk = true;
    this.Czl = false;
    this.Czm = 0L;
    this.Czn = false;
    this.sessionId = "";
    this.Czp = -1;
    this.xkQ = true;
    this.Czr = false;
    this.Czs = true;
    this.Czt = false;
    this.Czu = false;
    this.Czw = new byte[0];
    this.Cjc = null;
    this.Czx = false;
    this.CzB = false;
    this.kYu = null;
    this.CzG = new com.tencent.mm.plugin.webview.ui.tools.c.a.h(this);
    this.CzH = new com.tencent.mm.sdk.b.c() {};
    this.CzI = false;
    this.kYt = null;
    this.Cfr = null;
    this.CzJ = new HashMap();
    this.CzK = new HashMap();
    this.CzL = new HashMap();
    this.CzM = new HashMap();
    this.CzO = null;
    this.CzP = null;
    this.CzQ = null;
    this.CzR = false;
    this.CzS = true;
    this.CzT = false;
    this.tnu = 0;
    this.tnv = null;
    this.CzU = false;
    this.CzV = false;
    this.CzX = 0;
    this.CzY = ((int)(System.currentTimeMillis() / 1000L));
    this.CAa = false;
    this.CAb = false;
    this.CAc = false;
    this.CAd = false;
    this.CAe = false;
    this.Cfc = new com.tencent.mm.plugin.webview.model.ax();
    this.CAf = new com.tencent.mm.plugin.webview.j.h();
    this.CAh = new com.tencent.mm.plugin.webview.modeltools.n();
    this.CAk = null;
    this.CAs = false;
    this.CAt = new com.tencent.xweb.ab()
    {
      public final boolean A(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80057);
        if (WebViewUI.this.nKq == null)
        {
          AppMethodBeat.o(80057);
          return false;
        }
        boolean bool = WebViewUI.this.nKq.ag(paramAnonymousMotionEvent);
        AppMethodBeat.o(80057);
        return bool;
      }
      
      public final boolean B(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80058);
        if (WebViewUI.this.nKq == null)
        {
          AppMethodBeat.o(80058);
          return false;
        }
        boolean bool = WebViewUI.this.nKq.ah(paramAnonymousMotionEvent);
        AppMethodBeat.o(80058);
        return bool;
      }
      
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(80053);
        if (WebViewUI.this.nKq == null)
        {
          AppMethodBeat.o(80053);
          return false;
        }
        com.tencent.mm.plugin.webview.model.aj localaj = WebViewUI.this.Cfc.eBI();
        if (paramAnonymousInt4 > localaj.CqA) {
          localaj.CqA = paramAnonymousInt4;
        }
        localaj.yWt = paramAnonymousInt6;
        paramAnonymousBoolean = WebViewUI.this.nKq.c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
        AppMethodBeat.o(80053);
        return paramAnonymousBoolean;
      }
      
      public final void blu()
      {
        AppMethodBeat.i(80054);
        if (WebViewUI.this.nKq == null)
        {
          AppMethodBeat.o(80054);
          return;
        }
        WebViewUI.this.nKq.fuO();
        AppMethodBeat.o(80054);
      }
      
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(80055);
        if (WebViewUI.this.nKq == null)
        {
          AppMethodBeat.o(80055);
          return;
        }
        WebViewUI.this.nKq.g(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
        if ((paramAnonymousBoolean2) && (WebViewUI.this.Cfc != null)) {
          WebViewUI.this.Cfc.y("mm_scroll_bottom", Boolean.TRUE);
        }
        AppMethodBeat.o(80055);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(80056);
        if (WebViewUI.this.nKq == null)
        {
          AppMethodBeat.o(80056);
          return;
        }
        WebViewUI.this.nKq.S(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        WebViewUI.this.onWebViewScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(80056);
      }
      
      public final boolean z(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80052);
        if (WebViewUI.this.nKq == null)
        {
          AppMethodBeat.o(80052);
          return false;
        }
        boolean bool = WebViewUI.this.nKq.af(paramAnonymousMotionEvent);
        AppMethodBeat.o(80052);
        return bool;
      }
    };
    this.CAu = new com.tencent.mm.sdk.b.c()
    {
      private boolean eEx()
      {
        AppMethodBeat.i(80075);
        if (WebViewUI.this.kYt == null)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "Cli Event, invoker is null");
          AppMethodBeat.o(80075);
          return false;
        }
        if ((WebViewUI.this.CAn == null) || (WebViewUI.this.CAn.length() == 0))
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "Cli Event, tid is null");
          AppMethodBeat.o(80075);
          return false;
        }
        try
        {
          long l = System.currentTimeMillis();
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "Cli Event, tid = %s, stime = %d, etime = %d", new Object[] { WebViewUI.this.CAn, Long.valueOf(WebViewUI.this.CAo), Long.valueOf(l) });
          Bundle localBundle = new Bundle();
          localBundle.putString("service_click_tid", new String(WebViewUI.this.CAn));
          localBundle.putLong("service_click_stime", WebViewUI.this.CAo);
          localBundle.putLong("service_click_etime", l);
          WebViewUI.this.kYt.x(2836, localBundle);
          WebViewUI.this.CAn = null;
          AppMethodBeat.o(80075);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "Cli Event Exception, msg = %s", new Object[] { localException.getMessage() });
          }
        }
      }
    };
    this.CAw = false;
    this.CAy = 0;
    this.CAz = true;
    this.uup = 0L;
    this.nEl = 0;
    this.CAD = new com.tencent.mm.bo.a.b()
    {
      public final void a(com.tencent.mm.bo.a.a paramAnonymousa1, com.tencent.mm.bo.a.a paramAnonymousa2)
      {
        AppMethodBeat.i(188435);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "OrientationListener lastOrientation:" + paramAnonymousa1.name() + "; newOrientation:" + paramAnonymousa2.name());
        WebViewUI.this.screenOrientation = 4;
        WebViewUI.this.setMMOrientation();
        if (WebViewUI.this.Cze != null) {
          WebViewUI.this.Cze.disable();
        }
        AppMethodBeat.o(188435);
      }
    };
    this.CAE = false;
    this.CAF = new j();
    this.kYD = new com.tencent.mm.plugin.webview.modeltools.d();
    this.Cxh = new com.tencent.mm.plugin.webview.modeltools.a();
    this.CAG = new com.tencent.mm.plugin.webview.ui.tools.media.d();
    this.CAI = new View.OnLongClickListener()
    {
      private boolean fdc()
      {
        boolean bool2 = true;
        AppMethodBeat.i(210058);
        Object localObject = null;
        try
        {
          WebView.b localb = WebViewUI.this.nKq.getHitTestResult();
          localObject = localb;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "getHitTestResult exp %s", new Object[] { localException1.getMessage() });
          }
        }
        if ((localObject == null) || (bs.isNullOrNil(localObject.mExtra)))
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "hittestresult getExtra is null");
          AppMethodBeat.o(210058);
          return false;
        }
        try
        {
          bool1 = WebViewUI.this.kYt.eJ(localObject.mExtra);
          if (!bool1) {}
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            label137:
            boolean bool1 = true;
            com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + localException2.getMessage());
          }
        }
        try
        {
          WebViewUI.this.kYt.fo(localObject.mExtra, WebViewUI.this.eyt());
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
        AppMethodBeat.o(210058);
        return bool1;
      }
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210057);
        if (WebViewUI.this.getIntent().getBooleanExtra("show_long_click_popup_menu", true))
        {
          boolean bool = fdc();
          AppMethodBeat.o(210057);
          return bool;
        }
        AppMethodBeat.o(210057);
        return true;
      }
    };
    this.CAJ = false;
    this.CAL = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210062);
        if ((WebViewUI.e(WebViewUI.this) != null) && ((com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bt.eWo())))
        {
          boolean bool = WebViewUI.e(WebViewUI.this).onLongClick(paramAnonymousView);
          AppMethodBeat.o(210062);
          return bool;
        }
        AppMethodBeat.o(210062);
        return false;
      }
    };
    this.CAN = "";
    this.sXH = new WebViewUI.46(this);
    this.CAP = -1;
    AppMethodBeat.o(80217);
  }
  
  private void WL(String paramString)
  {
    AppMethodBeat.i(80241);
    if (this.Cjc != null)
    {
      this.Cjc.aBm(paramString);
      try
      {
        if (paramString.equals("onPause"))
        {
          this.kYt.Vy(this.Cfr.eyt());
          AppMethodBeat.o(80241);
          return;
        }
        if (paramString.equals("onResume")) {
          this.kYt.Vx(this.Cfr.eyt());
        }
        AppMethodBeat.o(80241);
        return;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WebViewUI", "onResume, ex = " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(80241);
  }
  
  private void a(JsapiPermissionWrapper paramJsapiPermissionWrapper)
  {
    AppMethodBeat.i(188480);
    if (paramJsapiPermissionWrapper != null)
    {
      if (paramJsapiPermissionWrapper.ma(34))
      {
        setMMSubTitle(2131766182);
        AppMethodBeat.o(188480);
        return;
      }
      if (paramJsapiPermissionWrapper.ma(75))
      {
        setMMSubTitle(2131766195);
        AppMethodBeat.o(188480);
        return;
      }
      setMMSubTitle(null);
    }
    AppMethodBeat.o(188480);
  }
  
  private void aDn(String paramString)
  {
    AppMethodBeat.i(80239);
    if ((this.CAr != null) && (!bs.isNullOrNil(paramString)) && (!com.tencent.mm.plugin.webview.ui.tools.b.a.isMpUrl(bLL()))) {
      this.CAr.SO(paramString);
    }
    AppMethodBeat.o(80239);
  }
  
  private void aDo(String paramString)
  {
    AppMethodBeat.i(80240);
    if ((this.CAp != null) && (!bs.isNullOrNil(paramString)) && (!com.tencent.mm.plugin.webview.ui.tools.b.a.isMpUrl(bLL())) && (!this.CAp.title.equals(paramString)))
    {
      this.CAp.setTitle(paramString);
      if (eAu()) {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.CAp);
      }
    }
    AppMethodBeat.o(80240);
  }
  
  private static String aDp(String paramString)
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
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "getFileNameFromContentDisposition error " + paramString.getMessage());
      AppMethodBeat.o(80299);
    }
    return null;
  }
  
  private static void aw(View paramView, int paramInt)
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
  
  private boolean eCR()
  {
    boolean bool1 = false;
    AppMethodBeat.i(80298);
    try
    {
      if (this.kYt == null)
      {
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WebViewUI", "invoker is null");
        AppMethodBeat.o(80298);
        return false;
      }
      boolean bool2 = this.kYt.eCR();
      bool1 = bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "unable get config for WebViewDownLoadFile" + localRemoteException.getMessage());
      }
    }
    AppMethodBeat.o(80298);
    return bool1;
  }
  
  private com.tencent.mm.plugin.webview.model.b eDD()
  {
    AppMethodBeat.i(188460);
    if (this.CAg == null) {
      this.CAg = new com.tencent.mm.plugin.webview.model.b(this.Cfc);
    }
    com.tencent.mm.plugin.webview.model.b localb = this.CAg;
    AppMethodBeat.o(188460);
    return localb;
  }
  
  private static boolean eDL()
  {
    AppMethodBeat.i(80248);
    if (CAA == null) {}
    try
    {
      if (bs.getInt(com.tencent.mm.plugin.expt.e.b.cmk().b("clicfg_webview_force_dark_disable", "0", false, true), 1) > 0) {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "disableForceDark on!!");
      }
      for (CAA = Boolean.TRUE;; CAA = Boolean.FALSE)
      {
        boolean bool = CAA.booleanValue();
        AppMethodBeat.o(80248);
        return bool;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "disableForceDark close!!");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebViewUI", localException, "disableForceDark", new Object[0]);
        CAA = Boolean.FALSE;
      }
    }
  }
  
  private boolean eDN()
  {
    return (this.Czc) || (this.Czd);
  }
  
  private int eDO()
  {
    AppMethodBeat.i(80252);
    if (this.CzS) {}
    for (int i = 0; (getSupportActionBar() == null) || (!getSupportActionBar().isShowing()); i = this.mfe)
    {
      AppMethodBeat.o(80252);
      return i;
    }
    int j = getActionBarHeight();
    AppMethodBeat.o(80252);
    return i + j;
  }
  
  private View eDU()
  {
    AppMethodBeat.i(80264);
    View localView = null;
    try
    {
      i = Resources.getSystem().getIdentifier("action_bar_container", "id", "android");
      if (i > 0) {
        localView = findViewById(i);
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", new Object[] { Integer.valueOf(i), localView });
      AppMethodBeat.o(80264);
      return localView;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "get resId action_bar_container, exp = %s", new Object[] { localException });
        int i = -1;
      }
    }
  }
  
  private void eEj()
  {
    AppMethodBeat.i(80316);
    if (this.Czy != null) {
      this.Czy.setVisibility(8);
    }
    if (this.Czz != null) {
      this.Czz.stopTimer();
    }
    AppMethodBeat.o(80316);
  }
  
  private boolean eEn()
  {
    AppMethodBeat.i(80355);
    int i = getIntent().getIntExtra("key_close_action", 0);
    Object localObject = getIntent().getBundleExtra("key_close_data");
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "close action %s", new Object[] { Integer.valueOf(i) });
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
        } while (bs.T(new String[] { str2, str3, str4 }));
        if (bool) {
          com.tencent.mm.ui.base.h.a(this, str1, str2, str3, str4, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(188430);
              WebViewUI.this.CAa = true;
              k.Cya.close();
              WebViewUI.this.finish();
              AppMethodBeat.o(188430);
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
              AppMethodBeat.i(210068);
              WebViewUI.this.CAa = true;
              k.Cya.close();
              WebViewUI.this.finish();
              AppMethodBeat.o(210068);
            }
          });
        }
      } while (localObject == null);
      str1 = ((Bundle)localObject).getString("close_jump_url");
      i = ((Bundle)localObject).getInt("close_jump_url_request_code", 0);
    } while (bs.isNullOrNil(str1));
    localObject = new Intent(this, WebViewUI.class);
    ((Intent)localObject).putExtra("rawUrl", str1);
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("show_bottom", false);
    ((Intent)localObject).putExtra("needRedirect", false);
    ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
    ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
    startActivityForResult((Intent)localObject, i);
    com.tencent.mm.ui.base.b.jU(this);
    AppMethodBeat.o(80355);
    return true;
  }
  
  private void eEp()
  {
    AppMethodBeat.i(80357);
    if (this.CAc)
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", "SwipeBackFinish, do not LaunchOuterApp");
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
  
  private static void fx(View paramView)
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
  
  private void uk(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.CzB = true;
    }
  }
  
  protected void O(Bundle paramBundle)
  {
    AppMethodBeat.i(188482);
    this.CAj.eDu();
    AppMethodBeat.o(188482);
  }
  
  public final void Q(String paramString, long paramLong)
  {
    AppMethodBeat.i(188461);
    if ((this.Cjc != null) && (this.nKq != null))
    {
      Object localObject2 = this.Cjc;
      this.nKq.getUrl();
      Object localObject1 = getIntent();
      boolean bool;
      Object localObject3;
      if ((this.kYu.eCn().DIu & 0x100000) > 0)
      {
        bool = true;
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.GeneralControlWrapper", "allowOnScreenShot, ret = ".concat(String.valueOf(bool)));
        if (!((com.tencent.mm.plugin.webview.c.f)localObject2).Apr) {
          break label417;
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.JsApiHandler", "onScreenShot hasPermission: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramString = l.a.b("onScreenShot", new HashMap(), ((com.tencent.mm.plugin.webview.c.f)localObject2).Cjz, ((com.tencent.mm.plugin.webview.c.f)localObject2).CjA);
          ((com.tencent.mm.plugin.webview.c.f)localObject2).Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
        }
        paramString = ((com.tencent.mm.plugin.webview.c.f)localObject2).getCurrentUrl();
        localObject3 = ((com.tencent.mm.plugin.webview.c.f)localObject2).getContext();
        if (!(localObject3 instanceof com.tencent.mm.plugin.webview.core.b)) {
          break label395;
        }
      }
      label395:
      for (paramString = ((com.tencent.mm.plugin.webview.core.b)localObject3).aAP(paramString);; paramString = "")
      {
        if (localObject1 == null) {
          break label417;
        }
        try
        {
          localObject2 = ((com.tencent.mm.plugin.webview.c.f)localObject2).getCurrentUrl();
          localObject1 = ((Intent)localObject1).getBundleExtra("ad_report_bundle");
          if ((!bs.isNullOrNil((String)localObject2)) && (localObject1 != null))
          {
            localObject1 = ((Bundle)localObject1).getString("ad_report_ux_info");
            if (!bs.isNullOrNil((String)localObject1))
            {
              int i = (int)(System.currentTimeMillis() / 1000L);
              Object localObject4 = Uri.parse((String)localObject2);
              localObject3 = ((Uri)localObject4).getQueryParameter("mid");
              localObject4 = ((Uri)localObject4).getQueryParameter("idx");
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.JsApiHandler", "alvinluo reportAdOnScreenShot appId: %s, mid: %s, idx: %s, adUxInfo: %s, url: %s", new Object[] { paramString, localObject3, localObject4, localObject1, localObject2 });
              com.tencent.mm.plugin.report.service.h.wUl.f(19213, new Object[] { Integer.valueOf(i), Integer.valueOf(6), localObject1, paramString, localObject3, localObject4, localObject2 });
            }
          }
          AppMethodBeat.o(188461);
          return;
        }
        catch (Exception paramString)
        {
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "alvinluo reportAdOnScreenShot exception", new Object[0]);
        }
        bool = false;
        break;
      }
    }
    label417:
    AppMethodBeat.o(188461);
  }
  
  protected void US(int paramInt)
  {
    AppMethodBeat.i(80351);
    if ((this.nKq == null) || (this.nKq.getSettings() == null))
    {
      AppMethodBeat.o(80351);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "localSetFontSize, fontSize = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      this.nKq.getSettings().setTextZoom(100);
      AppMethodBeat.o(80351);
      return;
    case 1: 
      this.nKq.getSettings().setTextZoom(80);
      AppMethodBeat.o(80351);
      return;
    case 2: 
      this.nKq.getSettings().setTextZoom(100);
      AppMethodBeat.o(80351);
      return;
    case 3: 
      this.nKq.getSettings().setTextZoom(110);
      AppMethodBeat.o(80351);
      return;
    case 4: 
      this.nKq.getSettings().setTextZoom(112);
      AppMethodBeat.o(80351);
      return;
    case 5: 
      this.nKq.getSettings().setTextZoom(112);
      AppMethodBeat.o(80351);
      return;
    case 6: 
      this.nKq.getSettings().setTextZoom(140);
      AppMethodBeat.o(80351);
      return;
    case 7: 
      this.nKq.getSettings().setTextZoom(155);
      AppMethodBeat.o(80351);
      return;
    }
    this.nKq.getSettings().setTextZoom(165);
    AppMethodBeat.o(80351);
  }
  
  protected final void VJ(int paramInt)
  {
    AppMethodBeat.i(80288);
    Drawable localDrawable = getResources().getDrawable(eEa()).mutate();
    localDrawable.setColorFilter(paramInt, PorterDuff.Mode.SRC_IN);
    updateBackBtn(localDrawable);
    AppMethodBeat.o(80288);
  }
  
  protected final void VK(int paramInt)
  {
    AppMethodBeat.i(80315);
    if (paramInt != -3)
    {
      AppMethodBeat.o(80315);
      return;
    }
    if (this.Czy == null)
    {
      AppMethodBeat.o(80315);
      return;
    }
    if ((this.kYu.eCn().DIu & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = ".concat(String.valueOf(bool)));
      if (!bool) {
        break label236;
      }
      if ((this.Czy.getVisibility() != 0) && (!this.Czg.isShown())) {
        break;
      }
      AppMethodBeat.o(80315);
      return;
    }
    if (this.Czz == null) {
      this.Czz = new au(Looper.getMainLooper(), new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(210065);
          WebViewUI.i(WebViewUI.this);
          AppMethodBeat.o(210065);
          return false;
        }
      }, false);
    }
    this.Czz.au(4000L, 4000L);
    View localView = this.Czy;
    ((ImageView)localView.findViewById(2131301454)).setImageResource(2131690929);
    TextView localTextView = (TextView)localView.findViewById(2131301455);
    localTextView.setTextSize(14.0F);
    localTextView.setText(2131766250);
    ((ImageButton)localView.findViewById(2131301453)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(188424);
        WebViewUI.i(WebViewUI.this);
        AppMethodBeat.o(188424);
      }
    });
    this.Czy.setVisibility(0);
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(13125, bLL());
    label236:
    AppMethodBeat.o(80315);
  }
  
  protected void WT()
  {
    AppMethodBeat.i(80342);
    this.CAj.WT();
    AppMethodBeat.o(80342);
  }
  
  @TargetApi(21)
  protected final void a(ViewGroup paramViewGroup, WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(80253);
    if (this.mfe == paramWindowInsets.getSystemWindowInsetTop())
    {
      AppMethodBeat.o(80253);
      return;
    }
    this.mfe = paramWindowInsets.getSystemWindowInsetTop();
    eDM();
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
    if (eDP()) {
      eDR();
    }
    AppMethodBeat.o(80253);
  }
  
  public final void a(com.tencent.mm.plugin.webview.ui.tools.c.b paramb)
  {
    AppMethodBeat.i(188464);
    this.CzG.a(paramb);
    AppMethodBeat.o(188464);
  }
  
  public final void a(com.tencent.mm.ui.base.p paramp)
  {
    this.fua = paramp;
  }
  
  public final void aA(Bundle paramBundle)
  {
    AppMethodBeat.i(80229);
    if (paramBundle != null)
    {
      this.CAw = "black".equals(paramBundle.getString("style"));
      eDG().uG(true);
    }
    AppMethodBeat.o(80229);
  }
  
  public final String aAP(String paramString)
  {
    AppMethodBeat.i(188478);
    paramString = this.Cfr.aAP(paramString);
    AppMethodBeat.o(188478);
    return paramString;
  }
  
  protected final int aAT(String paramString)
  {
    AppMethodBeat.i(80336);
    int i = this.Cfr.aAT(paramString);
    AppMethodBeat.o(80336);
    return i;
  }
  
  public final void aB(Bundle paramBundle)
  {
    AppMethodBeat.i(80230);
    this.fua = com.tencent.mm.plugin.webview.ui.tools.widget.p.a(paramBundle, getContext(), this.fua);
    AppMethodBeat.o(80230);
  }
  
  public final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(175797);
    if (paramBundle != null) {
      eDG().setCommentTopicId(paramBundle.getLong("commentTopicId"));
    }
    eDG().aDZ(this.Cfr.getCurrentUrl());
    com.tencent.mm.plugin.webview.ui.tools.widget.n localn = eDG();
    String str = paramBundle.getString("reply_content");
    int i = paramBundle.getInt("personal_comment_id");
    d.g.b.k.h(str, "replyContent");
    localn.tn(2);
    localn.uI(false);
    if ((!bs.isNullOrNil(str)) && (i != 0) && (localn.eGJ()))
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n.a(localn, str, i);
      localn.uH(false);
      AppMethodBeat.o(175797);
      return;
    }
    localn.uG(false);
    AppMethodBeat.o(175797);
  }
  
  protected final void aC(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(80280);
    this.Czc = paramBoolean1;
    Object localObject;
    if (paramBoolean1)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      if (this.CAB != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.CAB.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
        this.CAB.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.CzS) {
        com.tencent.mm.ui.statusbar.a.H(this.CAB, true);
      }
      for (;;)
      {
        getWindow().addFlags(1024);
        localObject = getWindow().getDecorView();
        ((View)localObject).setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
        {
          public final void onSystemUiVisibilityChange(int paramAnonymousInt)
          {
            AppMethodBeat.i(210037);
            if (((paramAnonymousInt & 0x4) == 0) && (WebViewUI.this.Czc)) {
              WebViewUI.fy(this.lPT);
            }
            AppMethodBeat.o(210037);
          }
        });
        aw((View)localObject, 5894);
        if (!paramBoolean2) {
          break;
        }
        this.Czb.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(210038);
            WebViewUI.this.bMr();
            AppMethodBeat.o(210038);
          }
        });
        this.Czb.setVisibility(0);
        AppMethodBeat.o(80280);
        return;
        if (this.CAC != null) {
          this.CAC.setVisibility(8);
        }
      }
      this.Czb.setVisibility(8);
      AppMethodBeat.o(80280);
      return;
    }
    this.Czb.setVisibility(8);
    getWindow().clearFlags(1024);
    fx(getWindow().getDecorView());
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().show();
      if (this.CAB != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.CAB.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = eDO();
        this.CAB.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    if (this.CzS)
    {
      com.tencent.mm.ui.statusbar.a.H(this.CAB, false);
      AppMethodBeat.o(80280);
      return;
    }
    if (this.CAC != null) {
      this.CAC.setVisibility(0);
    }
    AppMethodBeat.o(80280);
  }
  
  public final void aDm(String paramString)
  {
    AppMethodBeat.i(80306);
    this.CAj.aDm(paramString);
    AppMethodBeat.o(80306);
  }
  
  public final void aDq(String paramString)
  {
    AppMethodBeat.i(80317);
    this.Cjc.cf("profile", true);
    this.Cjc.aBn(paramString);
    AppMethodBeat.o(80317);
  }
  
  protected void aI(Bundle paramBundle) {}
  
  protected void aJ(Bundle paramBundle)
  {
    AppMethodBeat.i(80220);
    int i;
    if (paramBundle.getBoolean("set_navigation_bar_color_reset", false)) {
      if (this.CAq == null) {
        i = getResources().getColor(2131101161);
      }
    }
    for (int j = 255;; j = paramBundle.getInt("set_navigation_bar_color_alpha"))
    {
      setActionbarColor(i & 0xFFFFFF | j << 24);
      AppMethodBeat.o(80220);
      return;
      i = this.CAq.eEF();
      break;
      i = paramBundle.getInt("set_navigation_bar_color_color");
    }
  }
  
  public final void aM(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(80257);
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.sdk.h.b.YJ()))
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
        i = e.VA(paramInt);
      }
      setStatusBarColor(i);
    }
    AppMethodBeat.o(80257);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(80313);
    if (!com.tencent.mm.compatible.util.d.kZ(21))
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
    if (eDQ()) {
      localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
    for (;;)
    {
      addIconOptionMenu(paramInt1, getString(2131755815), localDrawable, paramOnMenuItemClickListener);
      AppMethodBeat.o(80313);
      return;
      if ((this.CAq != null) && (!this.CAq.CBa)) {
        localDrawable.setColorFilter(getResources().getColor(2131099732), PorterDuff.Mode.SRC_ATOP);
      } else {
        localDrawable.clearColorFilter();
      }
    }
  }
  
  public final void av(View paramView, int paramInt)
  {
    AppMethodBeat.i(188463);
    com.tencent.mm.plugin.webview.ui.tools.c.a.h localh = this.CzG;
    Object localObject = paramView;
    if (paramView == null) {
      localObject = this.nKq;
    }
    localh.av((View)localObject, paramInt);
    AppMethodBeat.o(188463);
  }
  
  public final void ay(Bundle paramBundle)
  {
    AppMethodBeat.i(80231);
    this.CAy = paramBundle.getInt("state", 0);
    AppMethodBeat.o(80231);
  }
  
  public final void az(Bundle paramBundle)
  {
    AppMethodBeat.i(80227);
    if (paramBundle != null)
    {
      this.CAw = "black".equals(paramBundle.getString("style"));
      eDG().setCommentTopicId(paramBundle.getLong("commentTopicId"));
    }
    eDG().aDZ(this.Cfr.getCurrentUrl());
    eDG().uG(false);
    AppMethodBeat.o(80227);
  }
  
  public final void b(com.tencent.mm.plugin.webview.ui.tools.c.b paramb)
  {
    AppMethodBeat.i(188465);
    this.CzG.b(paramb);
    AppMethodBeat.o(188465);
  }
  
  protected void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(80367);
    paramWebView = this.Cfc;
    Intent localIntent = getIntent();
    String str2 = bLL();
    int i = localIntent.getIntExtra("geta8key_scene", 0);
    int j = localIntent.getIntExtra("bizEnterId", paramWebView.Crw);
    int k = localIntent.getIntExtra("webview_scene_type", 1);
    String str3 = localIntent.getStringExtra("webview_scene_note");
    String str1 = localIntent.getStringExtra("srcUsername");
    paramWebView = str1;
    if (bs.isNullOrNil(str1)) {
      paramWebView = localIntent.getStringExtra("geta8key_username");
    }
    str1 = localIntent.getStringExtra("KAppId");
    com.tencent.mm.plugin.report.service.h.wUl.f(18452, new Object[] { Integer.valueOf(j), Integer.valueOf(i), com.tencent.mm.pluginsdk.ui.tools.x.aId(str2), com.tencent.mm.pluginsdk.ui.tools.x.aId(paramString), Integer.valueOf(k), str3, str1, paramWebView });
    AppMethodBeat.o(80367);
  }
  
  protected final void b(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(80309);
    addIconOptionMenu(0, paramString, paramDrawable, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(210061);
        if (!this.Hab) {
          WebViewUI.this.bMr();
        }
        for (;;)
        {
          AppMethodBeat.o(210061);
          return true;
          WebViewUI.this.aDq(this.hyc);
        }
      }
    });
    AppMethodBeat.o(80309);
  }
  
  public final void bHN()
  {
    AppMethodBeat.i(80302);
    this.CAj.bHN();
    AppMethodBeat.o(80302);
  }
  
  public final String bLL()
  {
    AppMethodBeat.i(80300);
    try
    {
      String str = BaseWebViewController.aS(getIntent());
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
  
  protected com.tencent.mm.plugin.webview.core.h bMD()
  {
    AppMethodBeat.i(188470);
    Object localObject = this.nKq;
    com.tencent.mm.plugin.webview.model.ax localax = this.Cfc;
    BaseWebViewController.f localf = new BaseWebViewController.f(getIntent());
    boolean bool2 = getIntent().getBooleanExtra("key_trust_url", false);
    boolean bool3 = eEq();
    if ((!eEl()) && (!eEm())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject = new com.tencent.mm.plugin.webview.core.h((MMWebView)localObject, localax, new BaseWebViewController.c(localf, bool2, bool3, bool1, getIntent().getBooleanExtra("neverGetA8Key", false)));
      ((com.tencent.mm.plugin.webview.core.h)localObject).a(new c());
      ((com.tencent.mm.plugin.webview.core.h)localObject).init();
      AppMethodBeat.o(188470);
      return localObject;
    }
  }
  
  public boolean bME()
  {
    return false;
  }
  
  protected void bMW()
  {
    AppMethodBeat.i(80246);
    if (this.CzS) {
      fixStatusbar(false);
    }
    AppMethodBeat.o(80246);
  }
  
  public void bMZ()
  {
    AppMethodBeat.i(80226);
    this.CAv.eGF();
    int i = getIntent().getIntExtra(e.m.HhB, -1);
    getIntent().getIntExtra(e.m.Hhw, 0);
    int j = getIntent().getIntExtra(e.m.Hhx, -1);
    int k = getIntent().getIntExtra(e.m.Hhy, -1);
    this.CAv.a(j, k, i, 0, bLL(), getTitle().toString());
    AppMethodBeat.o(80226);
  }
  
  protected MMWebView bMm()
  {
    AppMethodBeat.i(80260);
    MMWebView localMMWebView = MMWebView.a.kv(this);
    AppMethodBeat.o(80260);
    return localMMWebView;
  }
  
  protected boolean bMn()
  {
    AppMethodBeat.i(80365);
    if ((getClass().equals(WebViewUI.class)) && (!getIntent().getBooleanExtra("disable_minimize", false))) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "enableMinimize class:%s enable:%b", new Object[] { getClass(), Boolean.valueOf(bool) });
      AppMethodBeat.o(80365);
      return bool;
    }
  }
  
  protected void bMo()
  {
    AppMethodBeat.i(80247);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onCreate" + hashCode());
    this.CkJ = new l(this);
    this.CAi = new h(this);
    this.CAj = new i(this);
    this.CAq = new n(this);
    Object localObject1 = this.CAq;
    if (((n)localObject1).CBb != null)
    {
      if (!((n)localObject1).eEz()) {
        break label1469;
      }
      ((n)localObject1).CBa = true;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleParams, webViewUI#%s, disableLightActionbarStyle:%b", new Object[] { ((n)localObject1).CBb, Boolean.valueOf(((n)localObject1).CBa) });
      this.CAJ = true;
      this.Czv = getIntent().getIntExtra("geta8key_session_id", (int)System.currentTimeMillis());
      this.Czw = getIntent().getByteArrayExtra("geta8key_cookie");
      com.tencent.mm.plugin.webview.j.i.h(bLL(), this);
      this.Czj = bLL();
      this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
      this.Czu = getIntent().getBooleanExtra("from_shortcut", false);
      this.Czp = getIntent().getIntExtra(e.m.HhB, -1);
      this.tnv = getIntent().getStringExtra("status_bar_style");
      this.tnu = getIntent().getIntExtra("customize_status_bar_color", 0);
      this.CzV = getIntent().getBooleanExtra("show_native_web_view", false);
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
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "initCustomActionBarColorIfNeed isNativeStyle is %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label1523;
        }
        if (!com.tencent.mm.ui.aj.DT()) {
          break label1508;
        }
        localObject1 = "black";
        VJ(2131099650);
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
          aJ((Bundle)localObject3);
          if (!getIntent().hasExtra("customize_status_bar_color")) {
            this.tnu = ((Integer)localObject1).intValue();
          }
        }
        label424:
        this.CzV = getIntent().getBooleanExtra("show_native_web_view", false);
        this.Czi = getIntent().getBooleanExtra("key_trust_url", false);
        CzZ += 1;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "initView trust:%b, rawUrl = %s ", new Object[] { Boolean.valueOf(this.Czi), bLL() });
        this.dvr = bs.nullAsNil(getIntent().getStringExtra("KPublisherId"));
        this.handler = new ao();
        if ((this.Cfc != null) && (this.Cfc.au(getIntent().getBundleExtra("mm_report_bundle"))))
        {
          bool = true;
          label549:
          this.Czn = bool;
          localObject1 = getIntent().getBundleExtra("close_window_confirm_info");
          if (localObject1 != null) {
            this.CzN = a.aK((Bundle)localObject1);
          }
          getWindow().setFlags(16777216, 16777216);
          getWindow().setFormat(-3);
          this.CAj.eDm();
          w.a.hl(this);
          this.CAf.bI("onWebViewCreateStart", System.currentTimeMillis());
          if (!com.tencent.mm.plugin.webview.j.i.aEb(bLL())) {
            break label1547;
          }
          this.nKq = MMWebView.a.ku(this);
          com.tencent.xweb.util.g.Cf(173L);
          if (this.nKq == null) {
            this.nKq = bMm();
          }
          label665:
          h.e(this.nKq);
          this.CAf.bI("onWebViewCreateEnd", System.currentTimeMillis());
          this.nKq.Jbj = this;
          localObject1 = this.CAj;
          if (!(((i)localObject1).eCT() instanceof GameWebViewUI)) {
            break label1558;
          }
          ((i)localObject1).CxA.add(Integer.valueOf(11));
          ((i)localObject1).CxA.add(Integer.valueOf(28));
          label742:
          this.CAm = new com.tencent.mm.plugin.webview.c();
          initView();
          this.Cfr = bMD();
          this.Cfr.ao(getIntent());
          if (this.Cfc != this.Cfr.Cfc)
          {
            this.Cfc = this.Cfr.Cfc;
            this.Cfc.au(getIntent().getBundleExtra("mm_report_bundle"));
          }
          localObject1 = this.Cfc.eBD();
          i = this.Cfr.blB();
          localObject3 = this.dvr;
          ((ax.l)localObject1).dCr = i;
          ((ax.l)localObject1).CrE = ((String)localObject3);
          this.Cjc = this.Cfr.getJsapi();
          this.kYu = this.Cfr.kYu;
          CzA.add(new e(this));
          if (CzA.size() > 1)
          {
            localObject1 = CzA;
            localObject1 = (e)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 2);
            if ((((e)localObject1).lvU != null) && (((e)localObject1).lvU.get() != null)) {
              ((WebViewUI)((e)localObject1).lvU.get()).uk(false);
            }
          }
          WL("onCreate");
          j = getIntent().getIntExtra("from_scence", 0);
          this.Czo = getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
          localObject1 = this.CAf;
          i = this.Czo;
          if (i == -1) {
            break label1609;
          }
          ((com.tencent.mm.plugin.webview.j.h)localObject1).Czo = i;
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", " onCreate fromScene %d", new Object[] { Integer.valueOf(j) });
          this.sessionId = com.tencent.mm.model.y.xJ(String.valueOf(this.Cfr.eyt()));
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", " onCreate sessionId %s", new Object[] { this.sessionId });
          localObject1 = this.Cfc.eBJ();
          i = this.Cfr.blB();
          localObject3 = this.dvr;
          ((ax.f)localObject1).dCr = i;
          ((ax.f)localObject1).CrE = ((String)localObject3);
          ((ax.f)localObject1).url = bLL();
          localObject3 = this.Cfc.eBP();
          localObject1 = bLL();
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebviewReporter.DomainReporter", "setRawUrl, value = %s", new Object[] { localObject1 });
        }
      }
      catch (Exception localException2)
      {
        try
        {
          localObject4 = Uri.parse((String)localObject1);
          if ((((Uri)localObject4).getScheme() != null) && (!((Uri)localObject4).getScheme().toLowerCase().startsWith("http"))) {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl scheme is not http/https, skip, scheme = %s", new Object[] { ((Uri)localObject4).getScheme() });
          }
        }
        catch (Exception localException2)
        {
          try
          {
            label1202:
            this.CAB = getContentView();
            if (this.CAB != null)
            {
              eDM();
              ((ViewGroup)((ViewGroup)getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
              {
                public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
                {
                  AppMethodBeat.i(188433);
                  WebViewUI.this.eDM();
                  AppMethodBeat.o(188433);
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
              if (this.CzS) {
                if (eDP()) {
                  eDR();
                }
              }
              for (;;)
              {
                this.Cze = new com.tencent.mm.bo.a(getContext(), this.CAD);
                com.tencent.mm.plugin.webview.a.a.ag(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(188432);
                    com.tencent.mm.cf.f.eXr();
                    com.tencent.mm.cf.b.eXh();
                    AppMethodBeat.o(188432);
                  }
                });
                this.CAl = new WebViewClipBoardHelper(this);
                this.CAu.alive();
                this.CzH.alive();
                if (this.CAq != null)
                {
                  localObject1 = this.CAq;
                  if (((n)localObject1).CBb != null)
                  {
                    ((n)localObject1).lUn = ((n)localObject1).CBb.eyJ();
                    ((n)localObject1).gGd = ((n)localObject1).CBb.nKq;
                    if (!((n)localObject1).CBa) {
                      break label1848;
                    }
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle true");
                  }
                }
                aw(getWindow().getDecorView(), 256);
                com.tencent.mm.plugin.webview.model.ax.zC(getIntent().getLongExtra("start_activity_time", 0L));
                this.CAs = getIntent().getBooleanExtra(e.m.HhK, false);
                if (((this.CAs) || (eDL())) && (this.nKq != null)) {
                  this.nKq.getSettings().setForceDarkBehavior(1);
                }
                AppMethodBeat.o(80247);
                return;
                label1469:
                ((n)localObject1).CBa = false;
                break;
                localObject1 = getIntent().getStringExtra("custom_action_bar_color");
                break label294;
                label1493:
                bool = getIntent().getBooleanExtra("open_custom_style_url", false);
                break label303;
                label1508:
                localObject1 = "white";
                VJ(-16777216);
                break label345;
                label1523:
                if (bs.isNullOrNil((String)localObject1)) {
                  break label424;
                }
                break label345;
                localException1 = localException1;
                Object localObject2 = null;
                break label357;
                bool = false;
                break label549;
                label1547:
                this.nKq = bMm();
                break label665;
                label1558:
                localObject2.CxA.add(Integer.valueOf(7));
                localObject2.CxA.add(Integer.valueOf(11));
                localObject2.CxA.add(Integer.valueOf(28));
                break label742;
                switch (j)
                {
                default: 
                  label1609:
                  i = 999;
                }
                for (;;)
                {
                  localObject2.Czo = i;
                  break;
                  i = 1;
                  continue;
                  i = 2;
                }
                localObject4 = ((Uri)localObject4).getHost();
                if ((localObject4 == null) || (((String)localObject4).toLowerCase().endsWith(".qq.com")))
                {
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl, host is .qq.com, skip, host = %s", new Object[] { localObject4 });
                  break label1202;
                  localException4 = localException4;
                  com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebviewReporter.DomainReporter", "parse rawUrl fail, rawUrl = %s", new Object[] { localObject2 });
                  break label1202;
                }
                localException4.qPN = true;
                break label1202;
                localException2 = localException2;
                com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "fixContentMargin error : %s", new Object[] { localException2.getMessage() });
                break label1249;
                if (!com.tencent.mm.compatible.util.d.kZ(21)) {
                  break label1831;
                }
                final ViewGroup localViewGroup = (ViewGroup)((ViewGroup)getWindow().getDecorView()).getChildAt(0);
                localViewGroup.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
                {
                  public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
                  {
                    AppMethodBeat.i(188434);
                    WebViewUI.this.a(localViewGroup, paramAnonymousWindowInsets);
                    WebViewUI.a(WebViewUI.this);
                    paramAnonymousView = paramAnonymousWindowInsets.consumeSystemWindowInsets();
                    AppMethodBeat.o(188434);
                    return paramAnonymousView;
                  }
                });
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "tryToExpandToStatusBar error : %s", new Object[] { localException3.getMessage() });
                continue;
                label1831:
                ((ViewGroup)getWindow().getDecorView()).setFitsSystemWindows(true);
                continue;
                label1848:
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle false");
                localException3.eEA();
              }
            }
          }
        }
      }
    }
  }
  
  protected boolean bMq()
  {
    AppMethodBeat.i(80320);
    if (this.Czl)
    {
      AppMethodBeat.o(80320);
      return true;
    }
    if ((this.nKq != null) && ((this.nKq.canGoBack()) || (this.nKq.canGoForward())) && (this.CyU != null))
    {
      Object localObject1 = this.CyU;
      boolean bool;
      if (((g)localObject1).CwK != null)
      {
        localObject1 = ((g)localObject1).CwK;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        bool = ((Boolean)localObject1).booleanValue();
      }
      while (bool)
      {
        this.Czk = false;
        this.Czl = true;
        AppMethodBeat.o(80320);
        return true;
        Object localObject2 = aw.aKT("WebViewUIShowBottom");
        if (localObject2 == null) {
          d.g.b.k.fOy();
        }
        if (((aw)localObject2).decodeInt("WebViewUIShowBottomNav", 0) == 1)
        {
          ((g)localObject1).CwK = Boolean.TRUE;
          localObject1 = ((g)localObject1).CwK;
          if (localObject1 == null) {
            d.g.b.k.fOy();
          }
          bool = ((Boolean)localObject1).booleanValue();
        }
        else
        {
          if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pPD, 0) == 1) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label231;
            }
            com.tencent.mm.sdk.platformtools.ac.i(g.TAG, "needShowBottomNavigator not open");
            ((g)localObject1).CwK = Boolean.FALSE;
            localObject1 = ((g)localObject1).CwK;
            if (localObject1 == null) {
              d.g.b.k.fOy();
            }
            bool = ((Boolean)localObject1).booleanValue();
            break;
          }
          label231:
          localObject2 = ai.getContext();
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
              localObject2 = ai.getContext();
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
                localObject2 = ai.getContext();
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
                  localObject2 = ai.getContext();
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
            ((g)localObject1).CwK = Boolean.valueOf(bool);
            com.tencent.mm.sdk.platformtools.ac.i(g.TAG, "needShowBottomNavigator deviceShowBottomNav %b", new Object[] { ((g)localObject1).CwK });
            localObject2 = ((g)localObject1).CwK;
            if (localObject2 == null) {
              d.g.b.k.fOy();
            }
            if (!((Boolean)localObject2).booleanValue()) {
              break label796;
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(18210, new Object[] { Integer.valueOf(1) });
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1160L, 0L, 1L, false);
          }
          for (;;)
          {
            localObject1 = ((g)localObject1).CwK;
            if (localObject1 == null) {
              d.g.b.k.fOy();
            }
            bool = ((Boolean)localObject1).booleanValue();
            break;
            i = 0;
            break label261;
            label501:
            localObject2 = ai.getContext();
            d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
            bool = g.a.ee((Context)localObject2);
            com.tencent.mm.sdk.platformtools.ac.i(g.TAG, "miui hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
            break label267;
            label543:
            i = 0;
            break label301;
            label548:
            localObject2 = ai.getContext();
            d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
            bool = g.a.gQ((Context)localObject2);
            com.tencent.mm.sdk.platformtools.ac.i(g.TAG, "huawei hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
            break label307;
            label590:
            i = 0;
            break label342;
            label595:
            localObject2 = ai.getContext();
            d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
            bool = g.a.gQ((Context)localObject2);
            com.tencent.mm.sdk.platformtools.ac.i(g.TAG, "oppo hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
            break label348;
            label637:
            i = 0;
            break label382;
            label642:
            localObject2 = ai.getContext();
            d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
            if (Settings.Secure.getInt(((Context)localObject2).getContentResolver(), "navigation_gesture_mode", 0) == 1) {}
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label719;
              }
              com.tencent.mm.plugin.report.service.h.wUl.f(18210, new Object[] { Integer.valueOf(0) });
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1160L, 1L, 1L, false);
              bool = false;
              break;
            }
            label719:
            localObject2 = ai.getContext();
            d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
            if (!g.a.ee((Context)localObject2))
            {
              localObject2 = ai.getContext();
              d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
              if (!g.a.gQ((Context)localObject2)) {
                break label786;
              }
            }
            label786:
            for (bool = true;; bool = false)
            {
              com.tencent.mm.sdk.platformtools.ac.i(g.TAG, "vivo hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
              break;
            }
            label791:
            bool = false;
            break label394;
            label796:
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1160L, 2L, 1L, false);
          }
        }
      }
    }
    AppMethodBeat.o(80320);
    return false;
  }
  
  protected void bMr()
  {
    AppMethodBeat.i(80303);
    this.CAj.bMr();
    AppMethodBeat.o(80303);
  }
  
  protected void bMt()
  {
    AppMethodBeat.i(80341);
    this.CAj.bMt();
    AppMethodBeat.o(80341);
  }
  
  public boolean bMx()
  {
    return false;
  }
  
  public final int blB()
  {
    AppMethodBeat.i(80335);
    int i = this.Cfr.blB();
    AppMethodBeat.o(80335);
    return i;
  }
  
  public void bvh()
  {
    int k = 2;
    int m = 1;
    AppMethodBeat.i(80295);
    if ((this.CAb) || (this.CAa) || (isFinishing()))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "edw postBinded finished");
      AppMethodBeat.o(80295);
      return;
    }
    Object localObject1 = eEd();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.webview.c.g)localObject1).Cke = this.Cfr.getJsapi();
    }
    this.kYt = this.Cfr.eyr();
    try
    {
      this.kYt.a(this.CkJ, this.Cfr.eyt());
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "edw postBinded");
      this.CAr = new com.tencent.mm.plugin.webview.ui.tools.b.a(new com.tencent.mm.plugin.ball.a.e(this), this);
      localObject1 = getIntent().getStringExtra("float_ball_key");
      if (!bs.isNullOrNil((String)localObject1))
      {
        this.CAr.aa(2, (String)localObject1);
        this.CAr.SO(bLL());
        this.CAr.er("rawUrl", bLL());
        this.CAr.aBz(bLL());
        if (this.CAr != null) {
          this.CAr.bcX();
        }
        if (this.CAp == null) {
          break label1001;
        }
        i = 1;
        if (this.CAp == null) {
          this.CAp = new HandOffURL(bLL(), bLL(), "");
        }
        localObject1 = this.CAr.getName();
        if (!bs.isNullOrNil((String)localObject1)) {
          this.CAp.setTitle((String)localObject1);
        }
        if (eAu())
        {
          if (i == 0) {
            break label1006;
          }
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.CAp);
        }
        localObject1 = eDD();
        localObject2 = this.kYt;
      }
    }
    catch (RemoteException localException3)
    {
      try
      {
        str = ((com.tencent.mm.plugin.webview.stub.e)localObject2).aCU("DNSAdvanceOpen");
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.DNSPreGetOptimize", "switch open value : %s", new Object[] { str });
        if (bs.isNullOrNil(str))
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.DNSPreGetOptimize", "get switch value is null or nil");
          bool = false;
          if (bool) {
            break label1083;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.DNSPreGetOptimize", "server closed the switch");
          if (eEe()) {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(210059);
                if (WebViewUI.this.nKq != null) {
                  WebViewUI.this.nKq.getCurWebviewClient().b(WebViewUI.this.nKq, WebViewUI.this.nKq.getUrl());
                }
                AppMethodBeat.o(210059);
              }
            });
          }
          localObject1 = this.Cfr.getTitle();
          aDn((String)localObject1);
          aDo((String)localObject1);
        }
      }
      catch (Exception localException3)
      {
        try
        {
          i = bs.getInt(this.kYt.aCU("WebviewDisableX5Logo"), 0);
          bool = getIntent().getBooleanExtra("disable_bounce_scroll", false);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "getting flag of x5 logo state, disableX5Logo = %d, disableBounceScroll = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
          if ((i == 1) || (bool)) {
            this.CAF.ut(true);
          }
          if (getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_disable_over_scroll", false)) {
            this.CAF.ut(true);
          }
          this.CAf.bI("onJSAPIEnd", System.currentTimeMillis());
          if ((this.nKq != null) && (this.nKq.getIsX5Kernel()))
          {
            bool = true;
            com.tencent.mm.plugin.webview.model.ax.aB(bool, bs.nullAsNil(bLL()).startsWith("https://"));
          }
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              j = bs.getInt(this.kYt.aCU("XwebBatchTranslateMaxByteLength"), 0);
              i = bs.getInt(this.kYt.aCU("XwebBatchTranslateMaxCnt"), 0);
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "getting flag of XwebBatchTranslate para BatchTranslateMaxByteLength  = " + j + " BatchTranslateCnt = " + i);
              localObject1 = this.CAm;
              ((com.tencent.mm.plugin.webview.c)localObject1).CcM = j;
              ((com.tencent.mm.plugin.webview.c)localObject1).CcN = i;
              if (getIntent().getBooleanExtra("translate_webview", false))
              {
                localObject1 = this.CAm;
                localObject2 = this.nKq;
                str = bLL();
                if ((localObject2 != null) && (!((WebView)localObject2).isSysKernel())) {
                  break;
                }
              }
              if (!getIntent().getBooleanExtra("forceHideShare", false)) {
                break label1379;
              }
              uv(false);
              com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", "[hakon] postBinded :%d: force hide", new Object[] { Long.valueOf(System.currentTimeMillis()) });
              this.CyX = LayoutInflater.from(this).inflate(2131496073, null);
              localObject1 = (FontChooserView)this.CyX.findViewById(2131300194);
              localObject2 = this.CyX.findViewById(2131300193);
              if ((this.nKq == null) || (!this.nKq.getIsX5Kernel())) {
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
                    paramAnonymousView = AnimationUtils.loadAnimation(WebViewUI.this, 2130772060);
                    paramAnonymousView.setAnimationListener(new WebViewUI.37.1(this));
                    WebViewUI.this.CyX.startAnimation(paramAnonymousView);
                    WebViewUI.this.CyX.setVisibility(8);
                    AppMethodBeat.o(80091);
                  }
                });
              }
              ((FontChooserView)localObject1).setOnChangeListener(new d((byte)0));
              localObject2 = new FrameLayout.LayoutParams(-1, -2, 80);
              this.CyX.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              this.CyZ.addView(this.CyX);
              this.CyX.setVisibility(8);
              try
              {
                if (!this.kYt.eCC()) {
                  break label1484;
                }
                if ((!eEl()) && (!eEm())) {
                  break label1436;
                }
                i = com.tencent.mm.plugin.webview.j.e.gY(getContext());
              }
              catch (Exception localException6)
              {
                for (;;)
                {
                  Bundle localBundle;
                  com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WebViewUI", "initFontChooserView, ex = " + localException6.getMessage());
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
              this.Cfr.UC(j);
              US(j);
              AppMethodBeat.o(80295);
              return;
              localRemoteException = localRemoteException;
              com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebViewUI", localRemoteException, "addCallbacker", new Object[0]);
              continue;
              this.CAr.aa(2, com.tencent.mm.plugin.ball.f.b.SS(bLL()));
              continue;
              label1001:
              i = 0;
              continue;
              label1006:
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "[Handoff] call onWebViewCreate " + this.CAp.toString());
              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).a(this.CAp);
              continue;
              bool = str.equalsIgnoreCase("1");
              continue;
              localException1 = localException1;
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.DNSPreGetOptimize", "get dns pre get switch failed");
              continue;
              try
              {
                label1083:
                localObject2 = ((com.tencent.mm.plugin.webview.stub.e)localObject2).aCU("DNSAdvanceRelateDomain");
                if (!bs.isNullOrNil((String)localObject2)) {
                  break label1135;
                }
                com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.DNSPreGetOptimize", "domain list is null, just return");
              }
              catch (Exception localException2)
              {
                com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.DNSPreGetOptimize", localException2, "", new Object[0]);
              }
              continue;
              label1135:
              com.tencent.mm.plugin.webview.a.a.ag(new b.1(localException2, (String)localObject2));
              continue;
              localException3 = localException3;
              com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WebViewUI", "getting flag of x5 logo state failed, ex = " + localException3.getMessage());
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
              com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WebViewUI", "getting flag of XwebBatchTranslate para failid, ex = " + localException4.getMessage());
              i = 0;
              j = 0;
              continue;
              localBundle = new Bundle();
              localBundle.putString("destLanguage", com.tencent.mm.sdk.platformtools.ab.eUO());
              localBundle.putString("url", str);
              localBundle.putString("translateTips", getString(2131766130));
              localBundle.putString("translateFinish", getString(2131766127));
              localBundle.putString("errorWording", getString(2131766126));
              localException4.CcK = getString(2131766130);
              localException4.CcL = getString(2131766131);
              com.tencent.mm.sdk.b.a.GpY.c(localException4.CcP);
              try
              {
                ((WebView)localObject2).invokeMiscMethod("translateWebSite", localBundle);
              }
              catch (Exception localException5)
              {
                com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", new Object[] { localException5.getMessage() });
              }
              continue;
              label1379:
              boolean bool = getIntent().getBooleanExtra("showShare", true);
              uv(bool);
              com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", "[cpan] postBinded :%d: show:%b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(bool) });
              continue;
              label1431:
              i = 0;
              continue;
              label1436:
              i = com.tencent.mm.plugin.webview.j.e.a(getContext(), this.kYt, bLL());
            }
          }
        }
      }
    }
  }
  
  protected int bvi()
  {
    AppMethodBeat.i(80254);
    int i = getActionbarColor();
    AppMethodBeat.o(80254);
    return i;
  }
  
  protected boolean bvj()
  {
    return false;
  }
  
  public final void c(com.tencent.luggage.k.a.a.a parama)
  {
    AppMethodBeat.i(188466);
    this.CzG.c(parama);
    AppMethodBeat.o(188466);
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
    AppMethodBeat.i(188467);
    this.CzG.d(parama);
    AppMethodBeat.o(188467);
  }
  
  public final void dFh()
  {
    AppMethodBeat.i(80318);
    this.Cjc.cf("sendAppMessage", true);
    com.tencent.mm.plugin.webview.c.f localf = this.Cjc;
    HashMap localHashMap = this.CAj.eDr();
    getIntent();
    localf.m(localHashMap);
    this.Cfc.aCe("mm_send_friend_count");
    AppMethodBeat.o(80318);
  }
  
  public final String dKq()
  {
    return this.Cfr.Cdb;
  }
  
  public final boolean eAn()
  {
    AppMethodBeat.i(80354);
    if ((this.CzN != null) && (this.CzN.eAS()) && (!bs.isNullOrNil(this.CzN.eEy())) && (!bs.isNullOrNil(this.CzN.eAU())) && (!bs.isNullOrNil(this.CzN.eAV())))
    {
      Object localObject = this.CzN.eEy();
      String str1 = this.CzN.eAU();
      String str2 = this.CzN.eAV();
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "use js api close window confirm info : %s, %s, %s", new Object[] { localObject, str1, str2 });
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
      this.CzO = com.tencent.mm.ui.base.h.a(getContext(), true, "", localView, str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(210067);
          if ((localCheckBox != null) && (localCheckBox.isChecked())) {}
          try
          {
            if (WebViewUI.this.kYt.eCC()) {
              WebViewUI.this.kYt.iO(327792, 1);
            }
            WebViewUI.this.CAa = true;
            WebViewUI.this.CzO = null;
            k.Cya.close();
            if ((WebViewUI.v(WebViewUI.this) != null) && (WebViewUI.v(WebViewUI.this).rT(1)))
            {
              AppMethodBeat.o(210067);
              return;
            }
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "tryShowCloseWindowConfirmInfo, ex = " + paramAnonymousDialogInterface.getMessage());
            }
            WebViewUI.this.finish();
            AppMethodBeat.o(210067);
          }
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(188429);
          WebViewUI.this.CzO = null;
          AppMethodBeat.o(188429);
        }
      });
      AppMethodBeat.o(80354);
      return true;
    }
    AppMethodBeat.o(80354);
    return false;
  }
  
  public final boolean eAu()
  {
    AppMethodBeat.i(80364);
    boolean bool1 = getIntent().getBooleanExtra("forceHideShare", false);
    boolean bool2 = getIntent().getBooleanExtra("showShare", true);
    boolean bool3 = getIntent().getBooleanExtra("KRightBtn", false);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "forceHideShare:%b showShareBtn:%b enableMinimize:%b, banRightBtn %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bMn()), Boolean.valueOf(bool3) });
    if ((!bool3) && (!bool1) && (bool2) && (bMn()))
    {
      AppMethodBeat.o(80364);
      return true;
    }
    AppMethodBeat.o(80364);
    return false;
  }
  
  public final void eCr()
  {
    AppMethodBeat.i(80228);
    if (this.CAv != null)
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n localn = this.CAv;
      localn.hide();
      localn.CNe.setText((CharSequence)"");
    }
    AppMethodBeat.o(80228);
  }
  
  protected final boolean eDB()
  {
    return this.Cfr.CdK;
  }
  
  protected final Map<String, String> eDC()
  {
    return this.Cfr.Cdi;
  }
  
  public final com.tencent.mm.plugin.webview.ui.tools.b.a eDE()
  {
    return this.CAr;
  }
  
  protected final aq eDF()
  {
    return this.Cfr.Cev;
  }
  
  protected final com.tencent.mm.plugin.webview.ui.tools.widget.n eDG()
  {
    AppMethodBeat.i(80223);
    if (this.CAv == null)
    {
      this.CAv = new com.tencent.mm.plugin.webview.ui.tools.widget.n(this, new t(getContext(), 2131820847));
      this.CAv.setVisibility(8);
      localObject = (ViewParent)getWindow().getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        ((ViewGroup)localObject).addView(this.CAv, new FrameLayout.LayoutParams(-1, -1));
        bMZ();
      }
    }
    Object localObject = this.CAv;
    AppMethodBeat.o(80223);
    return localObject;
  }
  
  public final MPVideoPlayFullScreenView eDH()
  {
    AppMethodBeat.i(80224);
    if (this.CAx == null)
    {
      this.CAx = new MPVideoPlayFullScreenView(this, null);
      this.CAx.setVisibility(8);
      localObject = (ViewParent)getWindow().getDecorView();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).addView(this.CAx, new FrameLayout.LayoutParams(-1, -1));
      }
    }
    Object localObject = this.CAx;
    AppMethodBeat.o(80224);
    return localObject;
  }
  
  protected final void eDI()
  {
    AppMethodBeat.i(80225);
    if (this.CAv != null)
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n localn = this.CAv;
      if (localn.getSayFooter() != null)
      {
        localObject = localn.getSayFooter();
        if (((MPSmileyFooter)localObject).fWT != null)
        {
          ((MPSmileyFooter)localObject).fWT.eMG();
          ((MPSmileyFooter)localObject).fWT.destroy();
        }
      }
      Object localObject = com.tencent.mm.plugin.webview.ui.tools.widget.p.COp;
      com.tencent.mm.plugin.webview.ui.tools.widget.p.b(localn.CNv.fua);
    }
    AppMethodBeat.o(80225);
  }
  
  public final com.tencent.mm.ui.base.p eDJ()
  {
    return this.fua;
  }
  
  public final boolean eDK()
  {
    AppMethodBeat.i(188462);
    boolean bool = this.CzG.eDK();
    AppMethodBeat.o(188462);
    return bool;
  }
  
  protected final void eDM()
  {
    AppMethodBeat.i(80251);
    if ((this.CAB == null) || (eDN()))
    {
      AppMethodBeat.o(80251);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.CAB.getLayoutParams();
    int i = eDO();
    if (i != localMarginLayoutParams.topMargin)
    {
      localMarginLayoutParams.topMargin = i;
      this.CAB.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(80251);
  }
  
  protected boolean eDP()
  {
    return true;
  }
  
  final boolean eDQ()
  {
    AppMethodBeat.i(80255);
    if ((!bs.isNullOrNil(this.tnv)) && (this.tnv.equals("black")))
    {
      AppMethodBeat.o(80255);
      return true;
    }
    AppMethodBeat.o(80255);
    return false;
  }
  
  protected final void eDR()
  {
    AppMethodBeat.i(80256);
    if ((com.tencent.mm.compatible.util.d.kZ(21)) && (this.tnu != 0))
    {
      setActionbarColor(this.tnu);
      AppMethodBeat.o(80256);
      return;
    }
    setStatusBarColor(bvi());
    AppMethodBeat.o(80256);
  }
  
  public final String eDS()
  {
    return this.Cfr.CcY;
  }
  
  public final String eDT()
  {
    return this.Cfr.Cey;
  }
  
  public final void eDV()
  {
    AppMethodBeat.i(80272);
    try
    {
      this.CAF.release();
      this.nKq.stopLoading();
      this.nKq.removeAllViews();
      this.nKq.clearView();
      if (this.Cjc != null) {
        this.Cjc.detach();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        this.nKq.destroy();
        this.nKq = null;
        finish();
        com.tencent.mm.sdk.platformtools.ac.eUQ();
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(80272);
        return;
        localException1 = localException1;
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "forceQuit, ex = " + localException1.getMessage());
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WebViewUI", "forceQuit, viewWV destroy, ex = %s", new Object[] { localException2.getMessage() });
        }
      }
    }
  }
  
  protected void eDW()
  {
    AppMethodBeat.i(80275);
    this.Czm = System.currentTimeMillis();
    this.nKq.goBack();
    k localk = k.Cya;
    com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.WebViewReportUtil", "goBack traceid %s", new Object[] { localk.yeN });
    if (!bs.isNullOrNil(localk.yeN)) {
      localk.lA(5);
    }
    AppMethodBeat.o(80275);
  }
  
  protected int eDX()
  {
    AppMethodBeat.i(80277);
    if (this.Czf == null)
    {
      AppMethodBeat.o(80277);
      return 0;
    }
    int i = this.Czf.eGM();
    AppMethodBeat.o(80277);
    return i;
  }
  
  protected void eDY()
  {
    AppMethodBeat.i(80279);
    if (getIntent() == null)
    {
      AppMethodBeat.o(80279);
      return;
    }
    if (getIntent().hasExtra("show_full_screen")) {
      aC(getIntent().getBooleanExtra("show_full_screen", false), true);
    }
    AppMethodBeat.o(80279);
  }
  
  protected com.tencent.xweb.x eDZ()
  {
    try
    {
      AppMethodBeat.i(80286);
      if (this.CzD == null) {
        this.CzD = new MMWebView.b(new b());
      }
      com.tencent.xweb.x localx = this.CzD;
      AppMethodBeat.o(80286);
      return localx;
    }
    finally {}
  }
  
  protected void eDd()
  {
    AppMethodBeat.i(80278);
    int i = getIntent().getIntExtra("webview_bg_color_rsID", -1);
    if ((i != -1) && (getContentView() != null))
    {
      setBackGroundColorResource(i);
      getContentView().setBackgroundResource(i);
      this.nKq.setBackgroundResource(17170445);
      this.CyY.setBackgroundResource(17170445);
      this.CyZ.setBackgroundResource(17170445);
      AppMethodBeat.o(80278);
      return;
    }
    if (getIntent().getBooleanExtra(e.m.HhK, false))
    {
      this.nKq.setBackgroundColor(getResources().getColor(2131099828));
      AppMethodBeat.o(80278);
      return;
    }
    this.nKq.setBackgroundColor(getResources().getColor(2131101179));
    AppMethodBeat.o(80278);
  }
  
  public final void eDq()
  {
    AppMethodBeat.i(80305);
    this.CAj.eDq();
    AppMethodBeat.o(80305);
  }
  
  protected int eEa()
  {
    AppMethodBeat.i(80287);
    if (this.CzV)
    {
      AppMethodBeat.o(80287);
      return 2131689490;
    }
    AppMethodBeat.o(80287);
    return 2131689492;
  }
  
  protected boolean eEb()
  {
    return true;
  }
  
  public final void eEc()
  {
    AppMethodBeat.i(175800);
    View localView = this.nKq.getView();
    localView.scrollTo(localView.getScrollX(), 0);
    this.Cfc.eBL().C(new Object[] { bLL(), Integer.valueOf(7) }).report();
    AppMethodBeat.o(175800);
  }
  
  protected com.tencent.mm.plugin.webview.c.g eEd()
  {
    return null;
  }
  
  protected boolean eEe()
  {
    return false;
  }
  
  protected final void eEf()
  {
    AppMethodBeat.i(80304);
    if (this.Cfr != null) {
      this.Cfr.reload();
    }
    AppMethodBeat.o(80304);
  }
  
  protected final void eEg()
  {
    AppMethodBeat.i(188475);
    if (this.Cfr != null) {
      if (com.tencent.mm.plugin.webview.c.j.eAd()) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.webview.c.j.um(bool);
      this.Cfr.reload();
      AppMethodBeat.o(188475);
      return;
    }
  }
  
  protected final LinkedList<d.a> eEh()
  {
    AppMethodBeat.i(80307);
    if (this.nKq == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
      AppMethodBeat.o(80307);
      return null;
    }
    Object localObject = bLL();
    if (this.nKq != null)
    {
      String str = this.nKq.getUrl();
      if (!bs.isNullOrNil(str))
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
            boolean bool = bs.isNullOrNil(str);
            if (bool)
            {
              AppMethodBeat.o(80307);
              return null;
            }
            localObject = str;
            if (!str.startsWith(".")) {
              localObject = ".".concat(String.valueOf(str));
            }
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", "host = %s", new Object[] { localObject });
            if (localPattern.matcher((CharSequence)localObject).matches())
            {
              long l;
              if (this.CzW == null)
              {
                l = System.currentTimeMillis();
                this.CzW = this.kYt.eCH();
                if (this.CzW == null) {
                  break label281;
                }
              }
              label281:
              for (bool = true;; bool = false)
              {
                com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", "[hakon] getConfigListMap %b, cost %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
                if ((this.CzW == null) || (this.CzW.size() <= 0)) {
                  break;
                }
                localObject = com.tencent.mm.m.d.j(this.CzW);
                AppMethodBeat.o(80307);
                return localObject;
              }
            }
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", "[hakon] getJDMenuItems, ex = ", new Object[] { localException.getMessage() });
            AppMethodBeat.o(80307);
            return null;
          }
        }
      }
    }
  }
  
  protected final int eEi()
  {
    AppMethodBeat.i(80314);
    int i = 2131690603;
    if (eEh() != null) {
      i = 2131690809;
    }
    AppMethodBeat.o(80314);
    return i;
  }
  
  protected final void eEk()
  {
    AppMethodBeat.i(80344);
    this.CzP.setVisibility(0);
    AppMethodBeat.o(80344);
  }
  
  protected boolean eEl()
  {
    return false;
  }
  
  protected boolean eEm()
  {
    return false;
  }
  
  public void eEo()
  {
    AppMethodBeat.i(80356);
    if (eEn())
    {
      AppMethodBeat.o(80356);
      return;
    }
    eEp();
    if (!eAn())
    {
      this.CAa = true;
      k.Cya.close();
      if ((this.CAr != null) && (this.CAr.rT(1)))
      {
        AppMethodBeat.o(80356);
        return;
      }
      finish();
    }
    AppMethodBeat.o(80356);
  }
  
  protected boolean eEq()
  {
    return true;
  }
  
  protected final boolean eEr()
  {
    AppMethodBeat.i(80360);
    if (this.CAP != -3)
    {
      showVKB();
      AppMethodBeat.o(80360);
      return true;
    }
    AppMethodBeat.o(80360);
    return false;
  }
  
  protected final void eEs()
  {
    AppMethodBeat.i(188481);
    if ((this.CAa) || (this.CAb) || (isFinishing()))
    {
      AppMethodBeat.o(188481);
      return;
    }
    if (this.Cfr != null)
    {
      com.tencent.mm.plugin.webview.core.h localh = this.Cfr;
      localh.k(localh.bLL(), true, 8);
    }
    if (this.CzP != null) {
      this.CzP.setVisibility(8);
    }
    this.Cfc.eBL().C(new Object[] { bLL(), Integer.valueOf(4) }).report();
    AppMethodBeat.o(188481);
  }
  
  public final MMWebView eEt()
  {
    return this.nKq;
  }
  
  public final void etZ()
  {
    AppMethodBeat.i(188476);
    if (this.CyY != null)
    {
      hideVKB();
      this.CyY.FG(-2);
    }
    AppMethodBeat.o(188476);
  }
  
  public final String eyJ()
  {
    AppMethodBeat.i(210071);
    String str = this.Cfr.getCurrentUrl();
    AppMethodBeat.o(210071);
    return str;
  }
  
  protected final boolean eyQ()
  {
    AppMethodBeat.i(80308);
    boolean bool = this.Cfr.eyQ();
    AppMethodBeat.o(80308);
    return bool;
  }
  
  public final int eyt()
  {
    AppMethodBeat.i(210070);
    int i = this.Cfr.eyt();
    AppMethodBeat.o(210070);
    return i;
  }
  
  public final com.tencent.mm.plugin.webview.c.b.a ezK()
  {
    AppMethodBeat.i(188479);
    if (this.Cjc != null)
    {
      locala = this.Cjc.ezK();
      AppMethodBeat.o(188479);
      return locala;
    }
    com.tencent.mm.plugin.webview.c.b.a locala = new com.tencent.mm.plugin.webview.c.b.a();
    AppMethodBeat.o(188479);
    return locala;
  }
  
  public void finish()
  {
    AppMethodBeat.i(80235);
    if (this.Czr) {
      setResult(-1);
    }
    if (this.handler != null) {
      this.handler.removeCallbacksAndMessages(null);
    }
    this.CAb = true;
    if (this.Cfr != null)
    {
      com.tencent.mm.plugin.webview.core.h localh = this.Cfr;
      localh.eyB();
      localh.Cde = true;
    }
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.e.c.class) != null) {
      ((com.tencent.mm.plugin.appbrand.e.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.e.c.class)).bag();
    }
    super.finish();
    AppMethodBeat.o(80235);
  }
  
  protected void ft(String paramString, int paramInt)
  {
    AppMethodBeat.i(80276);
    if (this.Czf == null)
    {
      AppMethodBeat.o(80276);
      return;
    }
    WebViewInputFooter localWebViewInputFooter = this.Czf;
    localWebViewInputFooter.setVisibility(0);
    if (localWebViewInputFooter.COK != null) {
      localWebViewInputFooter.COK.setVisibility(0);
    }
    if (localWebViewInputFooter.COJ != null)
    {
      localWebViewInputFooter.COJ.setEnabled(true);
      localWebViewInputFooter.COJ.setBackgroundResource(2131232723);
    }
    if (localWebViewInputFooter.COG != null) {
      localWebViewInputFooter.COG.setVisibility(0);
    }
    localWebViewInputFooter.COL = false;
    if (localWebViewInputFooter.COJ != null)
    {
      localWebViewInputFooter.COJ.setFocusable(true);
      localWebViewInputFooter.COJ.setFocusableInTouchMode(true);
      localWebViewInputFooter.COJ.requestFocus();
    }
    if (localWebViewInputFooter.iMV != null) {
      localWebViewInputFooter.iMV.showVKB();
    }
    localWebViewInputFooter.state = 0;
    if (!bs.isNullOrNil(paramString)) {
      this.Czf.setText(paramString);
    }
    if (paramInt >= 0) {
      this.Czf.setMaxCount(paramInt);
    }
    AppMethodBeat.o(80276);
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
    if (com.tencent.mm.compatible.util.i.iA(this))
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
    AppMethodBeat.i(188473);
    com.tencent.mm.plugin.webview.ui.tools.c.a locala = this.CzG.CLS;
    if (locala != null) {}
    for (boolean bool = locala.bjb(); bool; bool = false)
    {
      i = getRequestedOrientation();
      AppMethodBeat.o(188473);
      return i;
    }
    int i = this.screenOrientation;
    AppMethodBeat.o(188473);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131496078;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(188472);
    String str = this.Cfr.nKq.getSettings().getUserAgentString();
    AppMethodBeat.o(188472);
    return str;
  }
  
  public final com.tencent.luggage.k.a.c.c getWebViewPluginClientProxy()
  {
    if (this.Cfr != null) {
      return this.Cfr.Cfb;
    }
    return null;
  }
  
  protected void goBack()
  {
    AppMethodBeat.i(188468);
    if (this.nKq == null)
    {
      AppMethodBeat.o(188468);
      return;
    }
    if (this.CzR)
    {
      AppMethodBeat.o(188468);
      return;
    }
    if (this.nKq.canGoBack())
    {
      eDW();
      AppMethodBeat.o(188468);
      return;
    }
    k.Cya.close();
    finish();
    AppMethodBeat.o(188468);
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(80361);
    super.hideVKB();
    this.CAP = -2;
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
    if (!this.CzS)
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
      this.CzT = true;
      AppMethodBeat.o(80222);
      return;
      localb.addView(localView1);
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(80284);
    this.CyY = ((WebViewKeyboardLinearLayout)findViewById(2131306921));
    this.CyZ = ((FrameLayout)findViewById(2131304241));
    this.Czt = getIntent().getBooleanExtra("finishviewifloadfailed", false);
    this.Czs = getIntent().getBooleanExtra("is_favorite_item", false);
    this.xkQ = getIntent().getBooleanExtra("isWebwx", true);
    boolean bool = getIntent().getBooleanExtra("show_feedback", false);
    this.CzQ = bs.nullAsNil(getIntent().getStringExtra("sentUsername"));
    if (bool) {
      addTextOptionMenu(1, getString(2131763230), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(210039);
          try
          {
            paramAnonymousMenuItem = WebViewUI.this.kYt.aCZ(null);
            WebViewUI.this.loadUrl(paramAnonymousMenuItem);
            AppMethodBeat.o(210039);
            return false;
          }
          catch (RemoteException paramAnonymousMenuItem)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebViewUI", paramAnonymousMenuItem, "[oneliang]feedback exception:%s", new Object[] { paramAnonymousMenuItem.getMessage() });
            }
          }
        }
      });
    }
    this.CyS = ((ProgressBar)findViewById(2131298857));
    this.CzP = findViewById(2131303929);
    this.CzP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80048);
        WebViewUI.this.eEs();
        AppMethodBeat.o(80048);
      }
    });
    if (this.xkQ)
    {
      localObject1 = bs.nullAsNil(getIntent().getStringExtra("title"));
      if (((CharSequence)localObject1).length() > 0) {
        this.CyP = true;
      }
      this.CyQ = getIntent().getBooleanExtra("key_show_web_page_title", false);
      setMMTitle((CharSequence)localObject1);
    }
    for (;;)
    {
      this.CwN = findViewById(2131306901);
      if (this.CwN != null)
      {
        this.CyU = new g(this.CwN, this.CyY, this.nKq);
        this.CwN.setVisibility(8);
        this.CyV = ((ImageButton)findViewById(2131306897));
        this.CyV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(188425);
            if ((WebViewUI.this.nKq != null) && (WebViewUI.this.nKq.canGoBack())) {
              WebViewUI.this.eDW();
            }
            AppMethodBeat.o(188425);
          }
        });
        this.CyW = ((ImageButton)findViewById(2131306900));
        this.CyW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(188427);
            if ((WebViewUI.this.nKq != null) && (WebViewUI.this.nKq.canGoForward())) {
              WebViewUI.this.nKq.goForward();
            }
            AppMethodBeat.o(188427);
          }
        });
      }
      if (this.nKq != null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "initView viewWV is null");
      finish();
      AppMethodBeat.o(80284);
      return;
      setMMTitle("");
    }
    if (CzF == WebSettings.RenderPriority.NORMAL)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
      this.nKq.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
      CzF = WebSettings.RenderPriority.HIGH;
    }
    Object localObject3 = this.CAF;
    Object localObject1 = getContentView();
    ((j)localObject3).CxL = ((LogoWebViewWrapper)((View)localObject1).findViewById(2131301589));
    ((j)localObject3).CxK = ((ImageView)((View)localObject1).findViewById(2131306923));
    ((j)localObject3).CxT = ((View)localObject1).findViewById(2131306922);
    if (((j)localObject3).CxT != null)
    {
      ((j)localObject3).CxU = ((j)localObject3).CxT.findViewById(2131307117);
      ((j)localObject3).CxV = ((TextView)((j)localObject3).CxU.findViewById(2131307119));
    }
    ((j)localObject3).CxM = BackwardSupportUtil.b.g(((j)localObject3).CxL.getContext(), 72.0F);
    Object localObject2;
    if (((j)localObject3).CxK == null)
    {
      localObject1 = "null";
      if (((j)localObject3).CxL != null) {
        break label1212;
      }
      localObject2 = "null";
      label548:
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage.id = %s, logoWrapper.id = %s", new Object[] { localObject1, localObject2 });
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", new Object[] { Integer.valueOf(((j)localObject3).CxM) });
      localObject1 = this.CAF;
      localObject2 = this.nKq;
      ((MMWebView)localObject2).setCompetitorView(((j)localObject1).CxL);
      ((MMWebView)localObject2).fuN();
      if (Build.VERSION.SDK_INT <= 10) {
        ((j)localObject1).CxL.getWebViewContainer().setBackgroundColor(((j)localObject1).CxL.getResources().getColor(2131101165));
      }
      localObject3 = ((j)localObject1).CxL;
      ((LogoWebViewWrapper)localObject3).getWebViewContainer();
      if (((LogoWebViewWrapper)localObject3).Cvi != null)
      {
        ((LogoWebViewWrapper)localObject3).fxk = ((WebView)localObject2);
        ((LogoWebViewWrapper)localObject3).Cvi.addView(((LogoWebViewWrapper)localObject3).fxk);
      }
      if ((!((MMWebView)localObject2).isXWalkKernel()) && (!((MMWebView)localObject2).getIsX5Kernel())) {
        break label1227;
      }
      ((j)localObject1).CxW = true;
      label704:
      if ((((j)localObject1).CxU != null) && (!((MMWebView)localObject2).getIsX5Kernel()))
      {
        ((ImageView)((j)localObject1).CxU.findViewById(2131307118)).setVisibility(8);
        ((TextView)((j)localObject1).CxU.findViewById(2131301014)).setText("");
      }
      if ((!((j)localObject1).CxW) || (((j)localObject1).CxX)) {
        break label1235;
      }
      ((j)localObject1).ut(false);
      ((j)localObject1).eDz();
    }
    for (;;)
    {
      eDd();
      this.Cza = ((FrameLayout)findViewById(2131298736));
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.nKq.getIsX5Kernel());
      this.nKq.setWebViewClientExtension(new b(this));
      if (this.nKq.getIsX5Kernel())
      {
        this.nKq.setWebViewCallbackClient(this.CAt);
        localObject1 = this.CAF;
        localObject2 = new LogoWebViewWrapper.a()
        {
          public final void eCV()
          {
            AppMethodBeat.i(210040);
            if (WebViewUI.this.nKq.getIsX5Kernel()) {
              WebViewUI.this.Cfc.eBL().C(new Object[] { WebViewUI.this.bLL(), Integer.valueOf(10) }).report();
            }
            AppMethodBeat.o(210040);
          }
        };
        if (((j)localObject1).CxL != null) {
          ((j)localObject1).CxL.setMMOverScrollListener((LogoWebViewWrapper.a)localObject2);
        }
      }
      this.Czf = ((WebViewInputFooter)findViewById(2131306916));
      if (this.Czf != null)
      {
        this.Czf.hide();
        this.Czf.setOnTextSendListener(new WebViewInputFooter.c()
        {
          public final void aBy(String paramAnonymousString)
          {
            AppMethodBeat.i(210041);
            WebViewUI.a(WebViewUI.this, paramAnonymousString);
            AppMethodBeat.o(210041);
          }
        });
        this.Czf.setOnSmileyChosenListener(new WebViewInputFooter.a()
        {
          public final boolean RU(String paramAnonymousString)
          {
            AppMethodBeat.i(210042);
            com.tencent.mm.plugin.webview.c.f localf;
            if (WebViewUI.this.Cjc != null)
            {
              localf = WebViewUI.this.Cjc;
              if (localf.Apr) {
                break label44;
              }
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.JsApiHandler", "not ready");
            }
            for (;;)
            {
              AppMethodBeat.o(210042);
              return true;
              label44:
              HashMap localHashMap = new HashMap();
              localHashMap.put("smiley", paramAnonymousString);
              ap.f(new f.24(localf, l.a.b("onGetSmiley", localHashMap, localf.Cjz, localf.CjA)));
            }
          }
        });
        this.Czf.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b()
        {
          public final void eAB()
          {
            AppMethodBeat.i(210043);
            WebViewUI.a(WebViewUI.this, 0);
            AppMethodBeat.o(210043);
          }
          
          public final void eAC()
          {
            AppMethodBeat.i(210044);
            WebViewKeyboardLinearLayout localWebViewKeyboardLinearLayout = WebViewUI.this.CyY;
            if ((localWebViewKeyboardLinearLayout != null) && (localWebViewKeyboardLinearLayout.getKeyBoardHeight() > 0)) {
              WebViewUI.a(WebViewUI.this, localWebViewKeyboardLinearLayout.getKeyBoardHeight());
            }
            AppMethodBeat.o(210044);
          }
        });
      }
      this.Czg = ((WebViewSearchContentInputFooter)findViewById(2131304407));
      if (this.Czg != null)
      {
        this.Czg.setActionDelegate(new WebViewSearchContentInputFooter.a()
        {
          public final void a(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
          {
            AppMethodBeat.i(210046);
            if (paramAnonymousWebViewSearchContentInputFooter.getVisibility() == 0) {
              b(paramAnonymousWebViewSearchContentInputFooter);
            }
            AppMethodBeat.o(210046);
          }
          
          public final void b(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
          {
            AppMethodBeat.i(210049);
            WebViewUI.this.nKq.clearMatches();
            paramAnonymousWebViewSearchContentInputFooter.reset();
            WebViewUI.this.Czg.C(0, 0, true);
            WebViewUI.a(WebViewUI.this, false);
            WebViewUI.this.nKq.findAllAsync(paramAnonymousWebViewSearchContentInputFooter.getSearchContent());
            AppMethodBeat.o(210049);
          }
          
          public final boolean c(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(210050);
            if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0)) {
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(480L, 6L, 1L, false);
            }
            AppMethodBeat.o(210050);
            return false;
          }
          
          public final void eAD()
          {
            AppMethodBeat.i(210045);
            WebViewUI.b(WebViewUI.this, 0);
            WebViewUI.this.nKq.clearMatches();
            WebViewUI.this.Czg.eGK();
            AppMethodBeat.o(210045);
          }
          
          public final void eAE()
          {
            AppMethodBeat.i(210047);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(480L, 5L, 1L, false);
            WebViewUI.this.nKq.findNext(false);
            AppMethodBeat.o(210047);
          }
          
          public final void eAF()
          {
            AppMethodBeat.i(210048);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(480L, 4L, 1L, false);
            WebViewUI.this.nKq.findNext(true);
            AppMethodBeat.o(210048);
          }
        });
        this.nKq.setFindListener(new WebView.FindListener()
        {
          public final void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(210051);
            if ((paramAnonymousBoolean) && (!WebViewUI.b(WebViewUI.this)) && (!bs.isNullOrNil(WebViewUI.this.Czg.getSearchContent())))
            {
              if (paramAnonymousInt2 != 0) {
                break label81;
              }
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(480L, 3L, 1L, false);
            }
            for (;;)
            {
              WebViewUI.a(WebViewUI.this, true);
              WebViewUI.this.Czg.C(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
              AppMethodBeat.o(210051);
              return;
              label81:
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(480L, 2L, 1L, false);
            }
          }
        });
      }
      this.Czb = ((MovingImageButton)findViewById(2131300327));
      this.Czy = findViewById(2131306913);
      if (this.Czy != null) {
        this.Czy.setVisibility(8);
      }
      this.nKq.setWebChromeClient(eDZ());
      this.nKq.setDownloadListener(new DownloadListener()
      {
        public final void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
        {
          AppMethodBeat.i(210052);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + paramAnonymousString1 + ", mimetype = " + paramAnonymousString4 + ", userAgent = " + paramAnonymousString2 + ", contentDisposition = " + paramAnonymousString3);
          int i = WebViewUI.this.getIntent().getIntExtra("key_download_restrict", 0);
          String str = WebViewUI.this.getIntent().getStringExtra("key_function_id");
          if (!bs.isNullOrNil(str)) {
            com.tencent.mm.plugin.report.service.h.wUl.f(14596, new Object[] { str, Integer.valueOf(i), Integer.valueOf(0) });
          }
          if (i == 1)
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "not allow download file : %s", new Object[] { paramAnonymousString1 });
            AppMethodBeat.o(210052);
            return;
          }
          if ((paramAnonymousString4 != null) && (paramAnonymousString4.equalsIgnoreCase("application/vnd.android.package-archive")))
          {
            com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.WebViewUI", "edw onDownloadStart, report download url: %s", new Object[] { paramAnonymousString1 });
            e.a(WebViewUI.this.kYt, 11154, new Object[] { paramAnonymousString1 });
          }
          if (WebViewUI.this.kYu == null)
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
            AppMethodBeat.o(210052);
            return;
          }
          int j = 0;
          if (paramAnonymousString4 != null)
          {
            boolean bool1 = WebViewUI.c(WebViewUI.this);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", new Object[] { Boolean.valueOf(bool1) });
            str = WebViewUI.aDr(paramAnonymousString3);
            if ((str == null) || (!Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", str))) {
              break label459;
            }
            i = 1;
            boolean bool2 = com.tencent.mm.plugin.webview.core.a.Ceo.contains(paramAnonymousString4.toLowerCase());
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
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onDownloadStart is apk");
                }
              }
              e.a(WebViewUI.this.kYt, 18111, new Object[] { WebViewUI.this.eyJ(), paramAnonymousString1, paramAnonymousString4, paramAnonymousString3, paramAnonymousString2, Long.valueOf(paramAnonymousLong) });
            }
            if ((j != 0) || (WebViewUI.this.kYu.eCm().ma(24)) || (WebViewUI.d(WebViewUI.this))) {
              break label471;
            }
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
            AppMethodBeat.o(210052);
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
            paramAnonymousString2 = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousString2);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString1, paramAnonymousString2.aeD(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$23", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString1.startActivity((Intent)paramAnonymousString2.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString1, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$23", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(210052);
            return;
          }
          catch (Exception paramAnonymousString1)
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "startActivity fail, e = " + paramAnonymousString1.getMessage());
            AppMethodBeat.o(210052);
          }
        }
      });
      this.nKq.requestFocus(130);
      this.nKq.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(210054);
          if ((WebViewUI.this.CyX != null) && (WebViewUI.this.CyX.getVisibility() == 0))
          {
            Animation localAnimation = AnimationUtils.loadAnimation(WebViewUI.this, 2130772060);
            localAnimation.setAnimationListener(new WebViewUI.17.1(this));
            WebViewUI.this.CyX.startAnimation(localAnimation);
            WebViewUI.this.CyX.setVisibility(8);
          }
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          while (WebViewUI.this.nKq == null)
          {
            AppMethodBeat.o(210054);
            return false;
            if (!paramAnonymousView.hasFocus()) {
              paramAnonymousView.requestFocus();
            }
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              WebViewUI.this.nwY = ((int)paramAnonymousMotionEvent.getRawX());
              WebViewUI.this.nwZ = ((int)paramAnonymousMotionEvent.getRawY());
            }
          }
          if ((paramAnonymousMotionEvent.getAction() == 0) || (paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 261) || (paramAnonymousMotionEvent.getAction() == 517))
          {
            if (paramAnonymousMotionEvent.getPointerCount() <= 1) {
              break label249;
            }
            WebViewUI.this.nKq.getSettings().setBuiltInZoomControls(true);
            WebViewUI.this.nKq.getSettings().setSupportZoom(true);
          }
          for (;;)
          {
            AppMethodBeat.o(210054);
            return false;
            label249:
            WebViewUI.this.nKq.getSettings().setBuiltInZoomControls(false);
            WebViewUI.this.nKq.getSettings().setSupportZoom(false);
          }
        }
      });
      this.nKq.fuM();
      this.CAi = new h(this);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(210055);
          WebViewUI.this.hideVKB();
          WebViewUI.this.eEo();
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "on back btn press");
          AppMethodBeat.o(210055);
          return true;
        }
      }, eEa());
      if (eEb()) {
        this.CyY.setOnkbdStateListener(new KeyboardLinearLayout.a()
        {
          public final void FG(int paramAnonymousInt)
          {
            AppMethodBeat.i(210063);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = ".concat(String.valueOf(paramAnonymousInt)));
            WebViewUI.a(WebViewUI.this, WebViewUI.this.CyY, paramAnonymousInt);
            if (paramAnonymousInt == -3)
            {
              WebViewUI.this.Cfc.eBH().Crc = 1;
              int i = WebViewUI.this.CyY.getKeyBoardHeight();
              if (i > 0)
              {
                WebViewUI.b(WebViewUI.this, i);
                WebViewUI.a(WebViewUI.this, i);
              }
              if (WebViewUI.f(WebViewUI.this)) {
                WebViewUI.g(WebViewUI.this).eGN();
              }
            }
            for (;;)
            {
              WebViewUI.this.VK(paramAnonymousInt);
              WebViewUI.this.CAP = paramAnonymousInt;
              AppMethodBeat.o(210063);
              return;
              WebViewUI.b(WebViewUI.this, 0);
              WebViewUI.a(WebViewUI.this, 0);
            }
          }
        });
      }
      this.CyR = ((MMFalseProgressBar)findViewById(2131306899));
      super.setTitleBarDoubleClickListener(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(210056);
          WebViewUI.this.eEc();
          AppMethodBeat.o(210056);
        }
      });
      AppMethodBeat.o(80284);
      return;
      localObject1 = String.valueOf(((j)localObject3).CxK.getId());
      break;
      label1212:
      localObject2 = String.valueOf(((j)localObject3).CxL.getId());
      break label548;
      label1227:
      ((j)localObject1).CxW = false;
      break label704;
      label1235:
      ((j)localObject1).ut(true);
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
    if (this.Cfr != null) {
      this.Cfr.loadUrl(paramString, paramMap, paramBoolean);
    }
    AppMethodBeat.o(80297);
  }
  
  protected void n(int paramInt, Bundle paramBundle) {}
  
  public boolean needShowIdcError()
  {
    return false;
  }
  
  protected void oI(boolean paramBoolean) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(80289);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.kYD.c(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(80289);
      return;
    }
    if (com.tencent.mm.plugin.webview.modeltools.a.c(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(80289);
      return;
    }
    if (this.CAG.c(this, paramInt1, paramInt2, paramIntent))
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
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "gdpr continue:true");
        AppMethodBeat.o(80289);
        return;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "gdpr continue:false");
      paramIntent = new Intent();
      localBundle = new Bundle();
      localBundle.putString("go_next", "gdpr_confirm_logout");
      paramIntent.putExtra("result_data", localBundle);
      this.CAa = true;
      k.Cya.close();
      setResult(-1, paramIntent);
      finish();
    }
    AppMethodBeat.o(80289);
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(80291);
    if (this.nKq != null)
    {
      if (!this.CAH) {
        break label42;
      }
      this.nKq.setOnLongClickListener(this.CAI);
    }
    for (;;)
    {
      super.onCancel();
      AppMethodBeat.o(80291);
      return;
      label42:
      this.nKq.setOnLongClickListener(null);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(80265);
    super.onConfigurationChanged(paramConfiguration);
    if (this.nEl != paramConfiguration.orientation)
    {
      View localView = eDU();
      if (localView == null) {}
      for (localView = null; localView == null; localView = (View)localView.getParent())
      {
        AppMethodBeat.o(80265);
        return;
      }
      localView.dispatchConfigurationChanged(paramConfiguration);
      localView.requestLayout();
      this.nEl = paramConfiguration.orientation;
    }
    AppMethodBeat.o(80265);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80244);
    com.tencent.mm.plugin.webview.j.h localh = this.CAf;
    localh.createTime = System.currentTimeMillis();
    localh.bI("onCreate", localh.createTime);
    this.CAf.CPA = getIntent().getLongExtra("startTime", 0L);
    bMW();
    super.onCreate(paramBundle);
    this.CAf.bI("onUIInitStart", System.currentTimeMillis());
    bMo();
    this.CAf.bI("onUIInitEnd", System.currentTimeMillis());
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "WebViewUI onDestroy now: %s", new Object[] { Integer.valueOf(this.Cfr.eyt()) });
    super.onDestroy();
    com.tencent.mm.plugin.webview.modeltools.c.eBR();
    Object localObject1 = this.Cfr.getCurrentUrl();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.webview.j.i.gZ(this);
      if ((localObject2 != null) && (((String)localObject1).equals(localObject2))) {
        com.tencent.mm.plugin.webview.j.i.ha(this);
      }
    }
    for (;;)
    {
      this.CzG.onDestroy();
      if (this.CAr != null)
      {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).J(this.CAr.nfN);
        this.CAr.onDestroy();
      }
      if ((eAu()) && (this.CAp != null))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "[Handoff] call onWebViewDestroy " + this.CAp.toString());
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).b(this.CAp);
      }
      if (this.Cze != null) {
        this.Cze.disable();
      }
      this.CAa = true;
      CzZ -= 1;
      int j = this.Cfr.eyt();
      int i = CzA.size() - 1;
      label225:
      if (i >= 0)
      {
        if (((e)CzA.get(i)).id == j) {
          CzA.remove(i);
        }
      }
      else
      {
        this.Cfc.eBL().C(new Object[] { bLL(), Integer.valueOf(2) }).report();
        this.Cfc.report();
        localObject1 = this.Cfc;
        ((com.tencent.mm.plugin.webview.model.ax)localObject1).Cri = null;
        ((com.tencent.mm.plugin.webview.model.ax)localObject1).Crg = null;
        ((com.tencent.mm.plugin.webview.model.ax)localObject1).Crh = null;
        ((com.tencent.mm.plugin.webview.model.ax)localObject1).Crf = null;
        ((com.tencent.mm.plugin.webview.model.ax)localObject1).Crk = null;
        ((com.tencent.mm.plugin.webview.model.ax)localObject1).Crl = null;
        ((com.tencent.mm.plugin.webview.model.ax)localObject1).Crm = null;
        ((com.tencent.mm.plugin.webview.model.ax)localObject1).Crn = null;
        if (((com.tencent.mm.plugin.webview.model.ax)localObject1).Crs != null)
        {
          ((com.tencent.mm.plugin.webview.model.ax)localObject1).Crs.dmf = null;
          ((com.tencent.mm.plugin.webview.model.ax)localObject1).Crs = null;
        }
        WL("onDestroy");
        this.CzJ.clear();
        eDD();
        c(this.CzO);
        if ((this.CzD != null) && ((this.CzD instanceof b))) {
          c(((b)this.CzD).jaW);
        }
        if (this.Czf != null) {
          this.Czf.setOnTextSendListener(null);
        }
        if (this.CyU != null)
        {
          localObject1 = this.CyU.CwN;
          if (localObject1 != null)
          {
            localObject2 = ((View)localObject1).getAnimation();
            if (localObject2 != null) {
              ((Animation)localObject2).setAnimationListener(null);
            }
            ((View)localObject1).clearAnimation();
          }
        }
        this.CzK.clear();
        this.CAj.onDestroy();
        this.CAu.dead();
        this.CzH.dead();
        if (com.tencent.xweb.d.li(ai.getContext()) != null)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "now force sync the cookie between ram and db");
          com.tencent.xweb.d.sync();
        }
        com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.WebViewUI", "on destroy isNeedCallbackMMRpt[%b]", new Object[] { Boolean.valueOf(this.Czn) });
        if (!this.Czn) {}
      }
      try
      {
        localObject1 = getIntent().getBundleExtra("mm_report_bundle");
        if (!bs.isNullOrNil(((Bundle)localObject1).getString("mm_event_class"))) {
          if (this.kYt != null)
          {
            ((Bundle)localObject1).putLong("key_activity_browse_time", getActivityBrowseTimeMs());
            this.kYt.k(250, (Bundle)localObject1);
          }
        }
      }
      catch (Exception localThrowable)
      {
        try
        {
          if (this.kYt != null)
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putLong("key_activity_browse_time", getActivityBrowseTimeMs());
            this.kYt.k(251, (Bundle)localObject1);
          }
        }
        catch (Exception localThrowable)
        {
          try
          {
            if (this.kYt != null)
            {
              localObject1 = this.kYt.k(19, null);
              if (localObject1 != null)
              {
                bool = ((Bundle)localObject1).getBoolean("webview_video_proxy_init");
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onDestroy, has init = %b, webviewHoldingCounter = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(CzZ) });
                if ((bool) && (CzZ <= 0))
                {
                  FactoryProxyManager.getPlayManager().deinit();
                  this.kYt.k(75, null);
                }
              }
            }
            bool = com.tencent.mm.plugin.webview.modeltools.k.a(this.Cjc, this.nKq);
            this.Cfr.onDestroy();
            this.nKq.removeJavascriptInterface("MicroMsg");
            this.nKq.removeJavascriptInterface("JsApi");
            this.nKq.removeJavascriptInterface("__wx");
            this.nKq.removeJavascriptInterface("CustomFullscreenApi");
            this.nKq.removeJavascriptInterface("__wxtag");
          }
          catch (Exception localThrowable)
          {
            try
            {
              this.nKq.setWebChromeClient(null);
              this.nKq.setWebViewClient(null);
              this.nKq.setOnTouchListener(null);
              this.nKq.setOnLongClickListener(null);
              this.nKq.setVisibility(8);
              this.nKq.removeAllViews();
              this.nKq.clearView();
              this.CAh.eCl();
              if (this.kYu != null)
              {
                localObject1 = this.kYu;
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewPermission", "detach");
                ((com.tencent.mm.plugin.webview.e.g)localObject1).Ctq.clear();
                ((com.tencent.mm.plugin.webview.e.g)localObject1).Ctq = null;
                this.kYu = null;
              }
            }
            catch (Exception localThrowable)
            {
              try
              {
                boolean bool;
                this.CAF.release();
                if (bool) {}
              }
              catch (Exception localThrowable)
              {
                try
                {
                  this.nKq.destroy();
                }
                catch (Exception localThrowable)
                {
                  try
                  {
                    if ((getContentView() instanceof ViewGroup)) {
                      ((ViewGroup)getContentView()).removeAllViews();
                    }
                    localObject1 = this.CAl;
                  }
                  catch (Throwable localThrowable)
                  {
                    try
                    {
                      for (;;)
                      {
                        ((ClipboardManager)ai.getContext().getSystemService("clipboard")).removePrimaryClipChangedListener((ClipboardManager.OnPrimaryClipChangedListener)localObject1);
                        label996:
                        localObject1 = this.CAm;
                        if ((((com.tencent.mm.plugin.webview.c)localObject1).tipDialog != null) && (((com.tencent.mm.plugin.webview.c)localObject1).tipDialog.isShowing()))
                        {
                          ((com.tencent.mm.plugin.webview.c)localObject1).tipDialog.dismiss();
                          ((com.tencent.mm.plugin.webview.c)localObject1).tipDialog = null;
                        }
                        com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.plugin.webview.c)localObject1).CcP);
                        this.nKq = null;
                        if (this.CAk != null)
                        {
                          this.CAk = null;
                          FactoryProxyManager.getPlayManager().setUtilsObject(null);
                        }
                        System.gc();
                        AppMethodBeat.o(80271);
                        return;
                        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WebViewUI", "currentURL == null, qbrowser.url may be not accurate");
                        break;
                        i -= 1;
                        break label225;
                        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WebViewUI", "webview on destroy callback mm but eventclass is null");
                        continue;
                        localException1 = localException1;
                        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", new Object[] { localException1.toString() });
                        continue;
                        localException2 = localException2;
                        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", new Object[] { localException2.toString() });
                        continue;
                        localException3 = localException3;
                        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "deinit video player failed : %s", new Object[] { localException3.getMessage() });
                        continue;
                        localException4 = localException4;
                        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "onDestroy, set web infos to null,  ex = %s", new Object[] { localException4.getMessage() });
                        continue;
                        localException5 = localException5;
                        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "onDestroy, remove view,  ex = " + localException5.getMessage());
                        continue;
                        localException6 = localException6;
                        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WebViewUI", "onDestroy, viewWV destroy, ex = %s", new Object[] { localException6.getMessage() });
                      }
                      localThrowable = localThrowable;
                      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WebViewUI", "onDestroy contentView removeAllViews %s", new Object[] { localThrowable });
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
    if (this.nKq != null) {
      this.nKq.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(188411);
          AppMethodBeat.o(188411);
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 4)
    {
      if ((this.nKq != null) && (this.nKq.hasEnteredFullscreen()))
      {
        this.nKq.leaveFullscreen();
        AppMethodBeat.o(80274);
        return true;
      }
      com.tencent.mm.plugin.webview.ui.tools.c.a.h localh = this.CzG;
      if (localh.CLS != null)
      {
        com.tencent.mm.plugin.webview.ui.tools.c.a locala = localh.CLS;
        if (locala == null) {
          d.g.b.k.fOy();
        }
        if (!locala.bjb()) {}
      }
      for (bool = localh.gR(localh.context).aUJ(); bool; bool = false)
      {
        AppMethodBeat.o(80274);
        return true;
      }
    }
    if ((paramInt == 4) && (this.tk != null) && (this.CzC != null) && (this.CzD != null)) {
      try
      {
        this.CzD.onHideCustomView();
        this.Cfc.eBL().C(new Object[] { bLL(), Integer.valueOf(1) }).report();
        AppMethodBeat.o(80274);
        return true;
      }
      catch (Exception paramKeyEvent)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebViewUI", paramKeyEvent, "onkeydown", new Object[0]);
        }
      }
    }
    if (paramInt == 4)
    {
      if ((this.Czf != null) && (this.Czf.isShown()))
      {
        this.Czf.hide();
        eEj();
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(80274);
        return true;
      }
    }
    if (paramInt == 4)
    {
      if ((this.nKq != null) && (this.nKq.canGoBack()) && (this.Czk))
      {
        eDW();
        this.Cfc.eBL().C(new Object[] { bLL(), Integer.valueOf(1) }).report();
        AppMethodBeat.o(80274);
        return true;
      }
      k.Cya.close();
    }
    if ((paramInt == 4) && (eEn()) && (eAn()))
    {
      AppMethodBeat.o(80274);
      return true;
    }
    if ((paramInt == 4) && (this.CAr != null) && (this.CAr.rT(2)))
    {
      AppMethodBeat.o(80274);
      return true;
    }
    if ((paramInt == 4) && (this.CAv != null) && (this.CAv.bjw()))
    {
      this.CAv.hide();
      AppMethodBeat.o(80274);
      return true;
    }
    if (paramInt == 4) {
      eEp();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(80274);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(80273);
    if ((paramInt == 82) && (!this.CAE))
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
    if (this.CAr != null) {
      this.CAr.bcY();
    }
    com.tencent.mm.modelstat.d.d(4, "WebViewUI_" + aAT(bs.nullAsNil(this.CzQ)), this.Cfr.eyt());
    com.tencent.mm.modelstat.d.m("WebViewUI_" + aAT(bs.nullAsNil(this.CzQ)), this.uup, bs.aNx());
    Object localObject = this.Cfc.eBH();
    if (((av)localObject).lastResumeTime != -1L) {
      ((av)localObject).dpQ += bs.aO(((av)localObject).lastResumeTime) / 1000L;
    }
    localObject = this.Cfc.eBI();
    if (((com.tencent.mm.plugin.webview.model.aj)localObject).lastResumeTime != -1L) {
      ((com.tencent.mm.plugin.webview.model.aj)localObject).dpQ += bs.aO(((com.tencent.mm.plugin.webview.model.aj)localObject).lastResumeTime);
    }
    localObject = k.Cya;
    com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.WebViewReportUtil", "onPause traceid %s", new Object[] { ((k)localObject).yeN });
    if (((k)localObject).hqq) {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewReportUtil", "isFinish is true");
    }
    try
    {
      if (this.kYt != null)
      {
        localObject = this.kYt.k(19, null);
        if (localObject != null)
        {
          boolean bool = ((Bundle)localObject).getBoolean("webview_video_proxy_init");
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onPause, has init = %b", new Object[] { Boolean.valueOf(bool) });
          if (bool) {
            FactoryProxyManager.getPlayManager().appToBack();
          }
        }
      }
      eEj();
      bg.a(this, null);
      WL("onPause");
      if (this.CzD != null) {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.CzD.onHideCustomView();
          this.CzG.onPause();
          AppMethodBeat.o(80234);
          return;
          if (!bs.isNullOrNil(((k)localObject).yeN)) {
            ((k)localObject).lA(6);
          }
        }
        localException1 = localException1;
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "notify app toback failed : %s", new Object[] { localException1.getMessage() });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebViewUI", localException2, "onPause", new Object[0]);
        }
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(80242);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    paramArrayOfString = this.kYD;
    if (paramArrayOfString.CrQ == null)
    {
      paramArrayOfString.eBS();
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
        paramArrayOfInt = (Intent)paramArrayOfString.CrQ.first;
        paramInt = ((Integer)paramArrayOfString.CrQ.second).intValue();
        paramArrayOfString.CrQ = null;
        startActivityForResult(paramArrayOfInt, paramInt);
      }
      for (;;)
      {
        paramInt = 1;
        break;
        label99:
        paramArrayOfString.CrQ = null;
        paramArrayOfString.b(this, 0, null);
      }
    }
    AppMethodBeat.o(80242);
  }
  
  protected void onReset()
  {
    AppMethodBeat.i(80245);
    this.Cjc.detach();
    this.Cjc = null;
    ((ViewGroup)this.nKq.getParent()).removeView(this.nKq);
    this.nKq.stopLoading();
    this.nKq.removeAllViews();
    this.nKq.clearView();
    this.nKq.destroy();
    this.nKq = null;
    this.CzD = null;
    ((ViewGroup)this.CyX.getParent()).removeView(this.CyX);
    if (this.CAq != null)
    {
      n localn = this.CAq;
      if (localn.CBc != null)
      {
        LinearLayout localLinearLayout = (LinearLayout)localn.CBb.getController().mActionBar.getCustomView();
        if (localLinearLayout != null) {
          localLinearLayout.removeView(localn.CBc);
        }
      }
    }
    if (this.Cfr != null) {
      this.Cfr.onDestroy();
    }
    this.CzG.onDestroy();
    this.CAd = false;
    bMW();
    bMo();
    AppMethodBeat.o(80245);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80233);
    super.onResume();
    if (this.CAr != null) {
      this.CAr.bcX();
    }
    if (this.Cfr.getCurrentUrl() != null) {
      com.tencent.mm.plugin.webview.j.i.h(this.Cfr.getCurrentUrl(), this);
    }
    for (;;)
    {
      this.Cfc.eBH().lastResumeTime = bs.Gn();
      this.Cfc.eBI().lastResumeTime = bs.Gn();
      Object localObject = k.Cya;
      com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.WebViewReportUtil", "onResume traceid %s", new Object[] { ((k)localObject).yeN });
      if (!bs.isNullOrNil(((k)localObject).yeN)) {
        ((k)localObject).lA(7);
      }
      int i;
      if (!this.CAz)
      {
        int j = this.Cfr.eyt();
        i = CzA.size() - 1;
        label139:
        if (i >= 0)
        {
          if (((e)CzA.get(i)).id == j) {
            CzA.remove(i);
          }
        }
        else {
          CzA.add(new e(this));
        }
      }
      else
      {
        this.CAz = false;
        if (this.CzB)
        {
          uk(true);
          this.CzB = false;
        }
        eDY();
        if (this.kYt == null) {}
      }
      try
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("screen_orientation", this.screenOrientation);
        this.kYt.k(83, (Bundle)localObject);
        if ((getIntent().getBooleanExtra("disable_swipe_back", false)) && (getSwipeBackLayout() != null)) {
          getSwipeBackLayout().setEnableGesture(false);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          bg.a(this, this);
          WL("onResume");
          try
          {
            if (this.kYt != null)
            {
              localObject = this.kYt.k(19, null);
              if (localObject != null)
              {
                boolean bool = ((Bundle)localObject).getBoolean("webview_video_proxy_init");
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onResume, has init = %b", new Object[] { Boolean.valueOf(bool) });
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
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "notify app tofront failed : %s", new Object[] { localException3.getMessage() });
            }
          }
          this.uup = bs.aNx();
          com.tencent.mm.plugin.webview.a.a.ag(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(80087);
              com.tencent.mm.modelstat.d.d(3, "WebViewUI_" + WebViewUI.this.aAT(bs.nullAsNil(WebViewUI.this.CzQ)), WebViewUI.this.eyt());
              AppMethodBeat.o(80087);
            }
          });
          if (this.CAe) {
            finish();
          }
          if ((this.CyY != null) && (this.CyY.Cxl))
          {
            hideVKB();
            this.CyY.FG(-2);
          }
          this.CzG.onResume();
          AppMethodBeat.o(80233);
          return;
          com.tencent.mm.plugin.webview.j.i.h(bLL(), this);
          continue;
          i -= 1;
          break label139;
          localException1 = localException1;
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "ac_set_screen_orientation : " + localException1.getMessage());
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WebViewUI", "setScreenShotCallback fail e:%s", new Object[] { localException2.getMessage() });
          }
        }
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(80266);
    super.onStart();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "edw onStart");
    AppMethodBeat.o(80266);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(80267);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "edw onStop");
    uw(true);
    super.onStop();
    AppMethodBeat.o(80267);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(80290);
    if (this.nKq != null)
    {
      if (!this.CAH) {
        break label46;
      }
      this.nKq.setOnLongClickListener(this.CAI);
    }
    for (;;)
    {
      hideVKB();
      super.onSwipeBack();
      AppMethodBeat.o(80290);
      return;
      label46:
      this.nKq.setOnLongClickListener(null);
    }
  }
  
  public boolean onSwipeBackFinish()
  {
    AppMethodBeat.i(80293);
    this.CAc = true;
    ax.g localg = this.Cfc.eBL();
    if (this.nKq != null) {}
    for (String str = this.nKq.getUrl();; str = bLL())
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
    if ((this.CAq != null) && (!this.CAq.CBa))
    {
      localObject = this.CAq;
      if (bs.isNullOrNil(((n)localObject).lUn)) {
        ((n)localObject).lUn = bs.nullAsNil(((n)localObject).CBb.Cfr.getCurrentUrl());
      }
      ((n)localObject).eED();
    }
    long l;
    if (this.CyU != null)
    {
      localObject = this.CyU;
      if (((g)localObject).CwJ)
      {
        l = System.currentTimeMillis();
        if (((g)localObject).CwG == 0L)
        {
          ((g)localObject).CwG = l;
          ((g)localObject).CwH = paramInt2;
        }
        if ((Math.abs(l - ((g)localObject).CwG) > 200L) && (Math.abs(paramInt2 - ((g)localObject).CwH) > ((g)localObject).CwI))
        {
          if ((paramInt2 - ((g)localObject).CwH <= 0) || (((g)localObject).CwN.getVisibility() != 0)) {
            break label195;
          }
          ((g)localObject).eDf();
        }
      }
    }
    for (;;)
    {
      ((g)localObject).CwG = l;
      ((g)localObject).CwH = paramInt2;
      AppMethodBeat.o(80261);
      return;
      label195:
      if ((paramInt2 - ((g)localObject).CwH < 0) && (((g)localObject).CwN.getVisibility() != 0)) {
        ((g)localObject).eDe();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(80283);
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.Czc)) {
      aw(getWindow().getDecorView(), 5894);
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(80283);
  }
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(80221);
    super.setActionbarColor(paramInt);
    if (this.CzS) {
      setStatusBarColor(paramInt);
    }
    AppMethodBeat.o(80221);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    AppMethodBeat.i(80363);
    super.setBackBtn(paramOnMenuItemClickListener, paramInt);
    if ((com.tencent.mm.compatible.util.d.kZ(21)) && (eDQ())) {
      setBackBtnColorFilter(-16777216);
    }
    AppMethodBeat.o(80363);
  }
  
  public void setMMOrientation()
  {
    AppMethodBeat.i(80263);
    if (getForceOrientation() == -1)
    {
      this.landscapeMode = getSharedPreferences(ai.eUX(), 4).getBoolean("settings_landscape_mode", false);
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
    aDn(paramCharSequence.toString());
    aDo(paramCharSequence.toString());
    AppMethodBeat.o(80238);
  }
  
  public void setMMTitle(String paramString)
  {
    AppMethodBeat.i(80237);
    super.setMMTitle(paramString);
    aDn(paramString);
    aDo(paramString);
    AppMethodBeat.o(80237);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(188474);
    this.screenOrientation = paramInt;
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(188474);
  }
  
  @TargetApi(21)
  public final void setStatusBarColor(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(80258);
    Object localObject;
    if (this.CzS)
    {
      localObject = getContentView();
      if (!am.ZN(paramInt)) {
        bool = true;
      }
      com.tencent.mm.ui.statusbar.a.e((View)localObject, paramInt, bool);
      AppMethodBeat.o(80258);
      return;
    }
    if ((this.mfe <= 0) || (com.tencent.mm.compatible.util.d.la(21)))
    {
      AppMethodBeat.o(80258);
      return;
    }
    getWindow().setStatusBarColor(0);
    if (this.CAC == null)
    {
      this.CAC = new View(this);
      localObject = new ViewGroup.LayoutParams(-1, this.mfe);
      ((ViewGroup)findViewById(16908290)).addView(this.CAC, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.CAC.setBackgroundColor(paramInt);
      AppMethodBeat.o(80258);
      return;
      localObject = this.CAC.getLayoutParams();
      if (((ViewGroup.LayoutParams)localObject).height != this.mfe)
      {
        ((ViewGroup.LayoutParams)localObject).height = this.mfe;
        this.CAC.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
    if (this.CAP == -3)
    {
      this.CAP = -2;
      AppMethodBeat.o(80362);
      return;
    }
    this.CAP = -3;
    AppMethodBeat.o(80362);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(80369);
    if (bs.lr(paramIntent.getType(), "application/vnd.android.package-archive"))
    {
      r.i(ai.getContext(), paramIntent.getData());
      AppMethodBeat.o(80369);
      return;
    }
    super.startActivity(paramIntent);
    AppMethodBeat.o(80369);
  }
  
  public final void uu(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(80319);
    if (this.CyU != null) {
      this.CyU.uu(paramBoolean);
    }
    ImageButton localImageButton;
    if ((this.nKq != null) && (this.CwN != null))
    {
      localImageButton = this.CyV;
      if ((this.nKq == null) || (!this.nKq.canGoBack())) {
        break label102;
      }
      paramBoolean = true;
      localImageButton.setEnabled(paramBoolean);
      localImageButton = this.CyW;
      if ((this.nKq == null) || (!this.nKq.canGoForward())) {
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
  
  protected void uv(boolean paramBoolean)
  {
    AppMethodBeat.i(80310);
    this.CAE = paramBoolean;
    if (this.nKq == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
      AppMethodBeat.o(80310);
      return;
    }
    enableOptionMenu(paramBoolean);
    showOptionMenu(paramBoolean);
    boolean bool1 = getIntent().getBooleanExtra("show_feedback", false);
    if (bool1) {
      showOptionMenu(bool1);
    }
    int i = eEi();
    if (eEh() != null) {
      i = 2131690809;
    }
    bool1 = getIntent().getBooleanExtra("KRightBtn", false);
    boolean bool2 = getIntent().getBooleanExtra("KShowFixToolsBtn", false);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "banRightBtn:%b, showFixToolsBtn:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (!bool1)
    {
      if (bool2) {
        addIconOptionMenu(1, 2131690202, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(188418);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(WebViewUI.this, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
            ((Intent)localObject).putExtra("entry_fix_tools", 1);
            paramAnonymousMenuItem = WebViewUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$34", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$34", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(188418);
            return true;
          }
        });
      }
      addIconOptionMenu(0, i, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(80082);
          if (WebViewUI.this.kYu.aCI(WebViewUI.this.eyJ())) {
            WebViewUI.this.Cfc.eBL().C(new Object[] { WebViewUI.this.bLL(), Integer.valueOf(6) }).report();
          }
          for (;;)
          {
            WebViewUI.this.bMr();
            AppMethodBeat.o(80082);
            return true;
            WebViewUI.this.Cfc.eBL().C(new Object[] { WebViewUI.this.bLL(), Integer.valueOf(5) }).report();
          }
        }
      }, this.CAL);
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ux(paramBoolean);
      AppMethodBeat.o(80310);
      return;
    }
  }
  
  protected final void uw(boolean paramBoolean)
  {
    AppMethodBeat.i(188477);
    enableOptionMenu(true);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", new Object[] { Boolean.TRUE });
    setProgressBarIndeterminateVisibility(false);
    if (paramBoolean)
    {
      this.CyR.finish();
      this.CAj.eDn();
      AppMethodBeat.o(188477);
      return;
    }
    if ((!this.CzU) && (!this.CzV) && (!this.Cfr.bLV())) {
      this.CyR.start();
    }
    AppMethodBeat.o(188477);
  }
  
  public final void ux(boolean paramBoolean)
  {
    AppMethodBeat.i(80359);
    String str = this.nKq.getUrl();
    if (paramBoolean)
    {
      showOptionMenu(0, false);
      this.CzM.put(str, Boolean.TRUE);
      AppMethodBeat.o(80359);
      return;
    }
    showOptionMenu(0, true);
    if (this.CzM.containsKey(str)) {
      this.CzM.remove(str);
    }
    AppMethodBeat.o(80359);
  }
  
  protected void y(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80358);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
    AppMethodBeat.o(80358);
  }
  
  protected static final class a
  {
    private String CAV;
    private String CmX;
    private String CmY;
    private String CmZ;
    private String Cna;
    private String Cnb;
    private String Cnc;
    private String lang;
    
    private a(Bundle paramBundle)
    {
      AppMethodBeat.i(80123);
      this.CAV = paramBundle.getString("close_window_confirm_dialog_switch");
      this.CmX = paramBundle.getString("close_window_confirm_dialog_title_cn");
      this.CmY = paramBundle.getString("close_window_confirm_dialog_title_eng");
      this.CmZ = paramBundle.getString("close_window_confirm_dialog_ok_cn");
      this.Cna = paramBundle.getString("close_window_confirm_dialog_ok_eng");
      this.Cnb = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
      this.Cnc = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
      this.lang = paramBundle.getString("application_language");
      AppMethodBeat.o(80123);
    }
    
    public static a aK(Bundle paramBundle)
    {
      AppMethodBeat.i(80124);
      paramBundle = new a(paramBundle);
      AppMethodBeat.o(80124);
      return paramBundle;
    }
    
    public final boolean eAS()
    {
      AppMethodBeat.i(80125);
      if (bs.isNullOrNil(this.CAV))
      {
        AppMethodBeat.o(80125);
        return false;
      }
      boolean bool = this.CAV.equals("true");
      AppMethodBeat.o(80125);
      return bool;
    }
    
    public final String eAU()
    {
      AppMethodBeat.i(80127);
      if ("zh_CN".equals(this.lang))
      {
        str = this.CmZ;
        AppMethodBeat.o(80127);
        return str;
      }
      String str = this.Cna;
      AppMethodBeat.o(80127);
      return str;
    }
    
    public final String eAV()
    {
      AppMethodBeat.i(80128);
      if ("zh_CN".equals(this.lang))
      {
        str = this.Cnb;
        AppMethodBeat.o(80128);
        return str;
      }
      String str = this.Cnc;
      AppMethodBeat.o(80128);
      return str;
    }
    
    public final String eEy()
    {
      AppMethodBeat.i(80126);
      if ("zh_CN".equals(this.lang))
      {
        str = this.CmX;
        AppMethodBeat.o(80126);
        return str;
      }
      String str = this.CmY;
      AppMethodBeat.o(80126);
      return str;
    }
  }
  
  public class b
    extends com.tencent.xweb.x
  {
    public volatile boolean fYC;
    com.tencent.mm.ui.widget.a.d jaW;
    
    protected b()
    {
      AppMethodBeat.i(80144);
      this.fYC = false;
      this.jaW = null;
      AppMethodBeat.o(80144);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(80148);
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", "onProgressChanged %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(80148);
    }
    
    public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(80145);
      com.tencent.mm.plugin.ball.f.f.e(true, true, false);
      if (WebViewUI.this.ezK().CkP)
      {
        MPVideoPlayFullScreenView localMPVideoPlayFullScreenView = WebViewUI.this.eDH();
        Context localContext = localMPVideoPlayFullScreenView.getContext();
        if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).nKq != null)) {
          localMPVideoPlayFullScreenView.CKx = ((WebViewUI)localContext).nKq.setVideoJsCallback((com.tencent.xweb.v)new MPVideoPlayFullScreenView.h(localMPVideoPlayFullScreenView));
        }
        if (localMPVideoPlayFullScreenView.CKx != null) {}
        for (int i = 1; i != 0; i = 0)
        {
          WebViewUI.a(WebViewUI.this, paramCustomViewCallback);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onEnterFullscreen view");
          if (paramView.getParent() == null) {
            WebViewUI.this.eDH().fz(paramView);
          }
          AppMethodBeat.o(80145);
          return true;
        }
      }
      if (WebViewUI.this.ezK().CkP) {
        WebViewUI.this.ezK().un(false);
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
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
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
          WebViewUI.p(WebViewUI.this).a(WebViewUI.this, WebViewUI.this.kYu, null, paramValueCallback, str2, paramWebView);
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
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", "onJsAlert");
      final PBool localPBool = new PBool();
      localPBool.value = false;
      if ((WebViewUI.this.isFinishing()) || (WebViewUI.this.activityHasDestroyed()))
      {
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", "onJsAlert finish");
        paramJsResult.cancel();
        AppMethodBeat.o(80158);
        return true;
      }
      WebViewUI.q(WebViewUI.this);
      if (WebViewUI.r(WebViewUI.this) > 2) {}
      for (this.jaW = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131766261), WebViewUI.this.getString(2131755835), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80142);
              com.tencent.mm.plugin.report.service.h.wUl.f(11683, new Object[] { paramString1, Integer.valueOf(1), Integer.valueOf(WebViewUI.r(WebViewUI.this)) });
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
          }, 2131100547); this.jaW != null; this.jaW = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131755835), new DialogInterface.OnClickListener()
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
        this.jaW.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(80135);
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", "onJsAlert, onDismiss");
            if (!localPBool.value) {
              paramJsResult.cancel();
            }
            AppMethodBeat.o(80135);
          }
        });
        this.jaW.setCanceledOnTouchOutside(false);
        this.jaW.yc(false);
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
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", "onJsConfirm");
      final PBool localPBool = new PBool();
      localPBool.value = false;
      if ((WebViewUI.this.isFinishing()) || (WebViewUI.this.activityHasDestroyed()))
      {
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", "onJsConfirm finish");
        paramJsResult.cancel();
        AppMethodBeat.o(80156);
        return true;
      }
      WebViewUI.q(WebViewUI.this);
      if (WebViewUI.r(WebViewUI.this) > 2) {}
      for (this.jaW = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131766261), WebViewUI.this.getString(2131755835), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80137);
              com.tencent.mm.plugin.report.service.h.wUl.f(11683, new Object[] { paramString1, Integer.valueOf(1), Integer.valueOf(WebViewUI.r(WebViewUI.this)) });
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
          }, 2131100053); this.jaW != null; this.jaW = com.tencent.mm.ui.base.h.a(WebViewUI.this.getContext(), false, paramString2, "", WebViewUI.this.getString(2131755835), WebViewUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
        this.jaW.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(80141);
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", "onJsConfirm, onDismiss");
            if (!localPBool.value) {
              paramJsResult.cancel();
            }
            AppMethodBeat.o(80141);
          }
        });
        this.jaW.setCancelable(false);
        this.jaW.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(80156);
        return true;
      }
      boolean bool = super.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(80156);
      return bool;
    }
    
    public final boolean blz()
    {
      AppMethodBeat.i(80146);
      com.tencent.mm.plugin.ball.f.f.e(false, true, false);
      boolean bool = super.blz();
      AppMethodBeat.o(80146);
      return bool;
    }
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80149);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", new Object[] { paramString, WebViewUI.this.eDS() });
      super.d(paramWebView, paramString);
      if ((WebViewUI.this.CyP) && (!WebViewUI.k(WebViewUI.this)))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "fixed title, ignore received title: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(80149);
        return;
      }
      if (paramString == null)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "null title");
        AppMethodBeat.o(80149);
        return;
      }
      if (!WebViewUI.this.xkQ)
      {
        AppMethodBeat.o(80149);
        return;
      }
      if ((!bs.nullAsNil(WebViewUI.this.eDS()).equals(paramString)) && (!com.tencent.mm.plugin.webview.luggage.c.b.Rp(paramString)) && (!paramString.startsWith("about:blank"))) {
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
      if ((WebViewUI.this.Cjc != null) && (WebViewUI.this.ezK().CkP) && (WebViewUI.this.eDH().getVisibility() == 0))
      {
        WebViewUI.j(WebViewUI.this).onCustomViewHidden();
        WebViewUI.this.ezK().un(false);
        MPVideoPlayFullScreenView localMPVideoPlayFullScreenView = WebViewUI.this.eDH();
        if (localMPVideoPlayFullScreenView.zRU)
        {
          com.tencent.mm.sdk.platformtools.ac.i(localMPVideoPlayFullScreenView.TAG, "isRunningExitAnimation");
          AppMethodBeat.o(80147);
          return;
        }
        localMPVideoPlayFullScreenView.eFX();
        if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
        {
          localObject = new ImageView(localMPVideoPlayFullScreenView.getContext());
          ViewGroup localViewGroup = localMPVideoPlayFullScreenView.CKq;
          if (localViewGroup != null) {
            localViewGroup.addView((View)localObject, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
          }
          ((ImageView)localObject).setImageBitmap(paramBitmap);
        }
        com.tencent.mm.sdk.platformtools.ac.i(localMPVideoPlayFullScreenView.TAG, "runExitAnimation");
        localMPVideoPlayFullScreenView.eFY();
        int j = localMPVideoPlayFullScreenView.CKn.getWidth();
        int i = localMPVideoPlayFullScreenView.CKn.getHeight();
        paramBitmap = localMPVideoPlayFullScreenView.ocV;
        if (paramBitmap != null) {
          paramBitmap.jN(j, i);
        }
        paramBitmap = localMPVideoPlayFullScreenView.ocV;
        int k;
        if (paramBitmap != null)
        {
          localObject = localMPVideoPlayFullScreenView.hhf;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          j = ((com.tencent.mm.ah.y)localObject).hlA;
          localObject = localMPVideoPlayFullScreenView.hhf;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          k = ((com.tencent.mm.ah.y)localObject).hlB;
          localObject = localMPVideoPlayFullScreenView.hhf;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          int m = ((com.tencent.mm.ah.y)localObject).hlC;
          localObject = localMPVideoPlayFullScreenView.hhf;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          paramBitmap.R(j, k, m, ((com.tencent.mm.ah.y)localObject).hlD);
        }
        if (localMPVideoPlayFullScreenView.yIR != 1.0D)
        {
          paramBitmap = localMPVideoPlayFullScreenView.ocV;
          if (paramBitmap != null) {
            paramBitmap.IRh = (1.0F / localMPVideoPlayFullScreenView.yIR);
          }
          if ((localMPVideoPlayFullScreenView.yIS != 0) || (localMPVideoPlayFullScreenView.yIT != 0))
          {
            j = (int)(localMPVideoPlayFullScreenView.CKn.getWidth() / 2 * (1.0F - localMPVideoPlayFullScreenView.yIR));
            k = localMPVideoPlayFullScreenView.yIS;
            i = (int)(localMPVideoPlayFullScreenView.CKn.getHeight() / 2 + localMPVideoPlayFullScreenView.yIT - i / 2 * localMPVideoPlayFullScreenView.yIR);
            paramBitmap = localMPVideoPlayFullScreenView.ocV;
            if (paramBitmap != null) {
              paramBitmap.jP(j + k, i);
            }
          }
        }
        paramBitmap = localMPVideoPlayFullScreenView.CKn.getLayoutParams();
        Object localObject = localMPVideoPlayFullScreenView.ocV;
        if (localObject != null)
        {
          ((com.tencent.mm.ui.tools.e)localObject).a((View)localMPVideoPlayFullScreenView.CKq, localMPVideoPlayFullScreenView.CKn, (e.c)new MPVideoPlayFullScreenView.p(localMPVideoPlayFullScreenView, paramBitmap), null);
          AppMethodBeat.o(80147);
          return;
        }
      }
      AppMethodBeat.o(80147);
    }
    
    public final void onGeolocationPermissionsShowPrompt(final String paramString, final GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(80153);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[] { paramString });
      if (!com.tencent.mm.pluginsdk.permission.b.o(WebViewUI.this, "android.permission.ACCESS_COARSE_LOCATION")) {
        com.tencent.mm.pluginsdk.permission.b.b(WebViewUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64);
      }
      com.tencent.mm.ui.base.h.a(WebViewUI.this, false, WebViewUI.this.getString(2131766268, new Object[] { paramString }), WebViewUI.this.getString(2131766269), WebViewUI.this.getString(2131755835), WebViewUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(80133);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt ok");
          paramCallback.invoke(paramString, true, true);
          e.a(WebViewUI.this.kYt, 14340, new Object[] { WebViewUI.this.bLL(), WebViewUI.this.eyJ(), Integer.valueOf(WebViewUI.this.blB()), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(com.tencent.mm.plugin.webview.model.ax.bhK()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(80133);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(80136);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt cancel");
          paramCallback.invoke(paramString, false, false);
          e.a(WebViewUI.this.kYt, 14340, new Object[] { WebViewUI.this.bLL(), WebViewUI.this.eyJ(), Integer.valueOf(WebViewUI.this.blB()), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(com.tencent.mm.plugin.webview.model.ax.bhK()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(80136);
        }
      });
      AppMethodBeat.o(80153);
    }
    
    public final void onHideCustomView()
    {
      AppMethodBeat.i(80151);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
      WebViewUI.this.getContext().getWindow().clearFlags(128);
      if (WebViewUI.l(WebViewUI.this) == null)
      {
        AppMethodBeat.o(80151);
        return;
      }
      try
      {
        WebViewUI.this.uu(WebViewUI.this.bMq());
        if (!WebViewUI.this.nKq.isXWalkKernel())
        {
          WebViewUI.this.nKq.setVisibility(0);
          WebViewUI.this.setTitleVisibility(0);
        }
        for (;;)
        {
          if (WebViewUI.this.Cza != null) {
            WebViewUI.this.Cza.removeView(WebViewUI.l(WebViewUI.this));
          }
          WebViewUI.a(WebViewUI.this, null);
          if (WebViewUI.n(WebViewUI.this) != null) {
            WebViewUI.n(WebViewUI.this).onCustomViewHidden();
          }
          AppMethodBeat.o(80151);
          return;
          WebViewUI.this.fullScreenNoTitleBar(false);
          WebViewUI.this.setStatusBarColor(WebViewUI.this.getResources().getColor(2131100952));
          if (WebViewUI.this.CAB != null)
          {
            ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)WebViewUI.this.CAB.getLayoutParams();
            int i = WebViewUI.m(WebViewUI.this);
            if (i != localMarginLayoutParams.topMargin)
            {
              localMarginLayoutParams.topMargin = i;
              WebViewUI.this.CAB.setLayoutParams(localMarginLayoutParams);
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "onHideCustomView error " + localException.getMessage());
        AppMethodBeat.o(80151);
      }
    }
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(80150);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
      try
      {
        WebViewUI.this.getContext().getWindow().addFlags(128);
        if (WebViewUI.l(WebViewUI.this) != null)
        {
          paramCustomViewCallback.onCustomViewHidden();
          AppMethodBeat.o(80150);
          return;
        }
        WebViewUI.this.uu(false);
        WebViewUI.a(WebViewUI.this, paramView);
        WebViewUI.b(WebViewUI.this, paramCustomViewCallback);
        if (!WebViewUI.this.nKq.isXWalkKernel())
        {
          WebViewUI.this.nKq.setVisibility(8);
          WebViewUI.this.Cza.addView(paramView);
          WebViewUI.this.setTitleVisibility(4);
          AppMethodBeat.o(80150);
          return;
        }
      }
      catch (Exception paramView)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "onShowCustomView error " + paramView.getMessage());
        AppMethodBeat.o(80150);
        return;
      }
      WebViewUI.this.Cza.addView(paramView, 0);
      WebViewUI.this.fullScreenNoTitleBar(true);
      WebViewUI.this.setStatusBarColor(0);
      if (WebViewUI.this.CAB != null)
      {
        paramView = (ViewGroup.MarginLayoutParams)WebViewUI.this.CAB.getLayoutParams();
        paramView.topMargin = 0;
        WebViewUI.this.CAB.setLayoutParams(paramView);
      }
      AppMethodBeat.o(80150);
    }
    
    public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      AppMethodBeat.i(80154);
      WebViewUI.p(WebViewUI.this).a(WebViewUI.this, WebViewUI.this.kYu, paramValueCallback, null, paramString1, paramString2);
      AppMethodBeat.o(80154);
    }
  }
  
  public final class c
    extends com.tencent.mm.plugin.webview.core.j
  {
    public c() {}
    
    public final boolean c(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(188456);
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "edw interceptLoadError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1, Boolean.valueOf(com.tencent.mm.sdk.platformtools.ax.isConnected(WebViewUI.this)) });
      AppMethodBeat.o(188456);
      return false;
    }
    
    public final boolean eyZ()
    {
      AppMethodBeat.i(188457);
      if ((WebViewUI.this.CAa) || (WebViewUI.s(WebViewUI.this)) || (WebViewUI.this.isFinishing()))
      {
        AppMethodBeat.o(188457);
        return true;
      }
      AppMethodBeat.o(188457);
      return false;
    }
    
    public final com.tencent.mm.plugin.webview.core.e eza()
    {
      AppMethodBeat.i(188458);
      a locala = new a((byte)0);
      AppMethodBeat.o(188458);
      return locala;
    }
    
    public final com.tencent.mm.plugin.webview.core.i ezb()
    {
      AppMethodBeat.i(188459);
      b localb = new b((byte)0);
      AppMethodBeat.o(188459);
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
        WebViewUI.this.CAj.Cxz = false;
      }
      
      public final void aAQ(String paramString)
      {
        AppMethodBeat.i(188438);
        WebViewUI.this.CAF.eDw();
        if ((WebViewUI.v(WebViewUI.this) != null) && (com.tencent.mm.sdk.platformtools.ax.isNetworkConnected(WebViewUI.this.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8")))
        {
          WebViewUI.v(WebViewUI.this).er("rawUrl", paramString);
          WebViewUI.v(WebViewUI.this).aBz(paramString);
        }
        WebViewUI.d(WebViewUI.this, paramString);
        WebViewUI.this.uu(WebViewUI.this.bMq());
        AppMethodBeat.o(188438);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(188437);
        WebViewUI.u(WebViewUI.this);
        if ((WebViewUI.v(WebViewUI.this) != null) && (com.tencent.mm.sdk.platformtools.ax.isNetworkConnected(WebViewUI.this.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8")))
        {
          WebViewUI.v(WebViewUI.this).er("rawUrl", paramString);
          WebViewUI.v(WebViewUI.this).aBz(paramString);
        }
        WebViewUI.d(WebViewUI.this, paramString);
        if (!WebViewUI.w(WebViewUI.this))
        {
          WebViewUI.x(WebViewUI.this);
          WebViewUI.this.Cfc.eBK().loadFinished = true;
        }
        Object localObject = WebViewUI.this.nKq.getTitle();
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", new Object[] { WebViewUI.this.getMMTitle(), localObject, Boolean.valueOf(WebViewUI.this.CyP), Boolean.valueOf(WebViewUI.this.xkQ), WebViewUI.this.eDS() });
        if ((WebViewUI.c.this.controller.nKq.getIsX5Kernel()) && (!bs.isNullOrNil((String)localObject)) && (((String)localObject).length() > 0) && (!((String)localObject).equals(WebViewUI.this.getMMTitle())) && (!((String)localObject).startsWith("http")) && ((WebViewUI.this.eDS() == null) || (!WebViewUI.this.eDS().equals(localObject))) && (!WebViewUI.this.CyP) && (WebViewUI.this.xkQ))
        {
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
          WebViewUI.this.setMMTitle((String)localObject);
        }
        WebViewUI.this.CAF.setCurrentURL(WebViewUI.this.eyJ());
        WebViewUI.this.setProgressBarIndeterminateVisibility(false);
        WebViewUI.this.CyR.finish();
        if ((WebViewUI.this.CAq != null) && (!WebViewUI.this.CAq.CBa))
        {
          localObject = WebViewUI.this.CAq;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", new Object[] { paramString });
          ((n)localObject).lUn = paramString;
        }
        WebViewUI.e(WebViewUI.this, paramString);
        WebViewUI.this.b(paramWebView, paramString);
        AppMethodBeat.o(188437);
      }
      
      public final void e(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(188439);
        super.e(paramWebView, paramString);
        paramWebView = WebViewUI.this.CAq;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", new Object[] { paramString });
        paramWebView.lUn = paramString;
        AppMethodBeat.o(188439);
      }
      
      public final void m(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(188436);
        if (!WebViewUI.this.CAJ) {
          WebViewUI.this.CAj.eDo();
        }
        WebViewUI.this.CAF.eDw();
        WebViewUI.this.CAF.setCurrentURL(paramString);
        WebViewUI.this.setProgressBarIndeterminateVisibility(false);
        WebViewUI.this.CAj.f(paramString, WebViewUI.this.getIntent());
        WebViewUI.this.uw(false);
        if ((WebViewUI.this.CAq != null) && (!WebViewUI.this.CAq.CBa))
        {
          paramWebView = WebViewUI.this.CAq;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageStart, url:%s", new Object[] { paramString });
          paramWebView.lUn = paramString;
          paramWebView.eEA();
          paramString = (Bundle)n.Cxp.get(n.Tk(paramWebView.lUn));
          if ((paramString != null) && (paramWebView.CBb != null)) {
            break label220;
          }
          paramWebView.eEH();
        }
        for (;;)
        {
          WebViewUI.t(WebViewUI.this);
          AppMethodBeat.o(188436);
          return;
          label220:
          if (paramString.getBoolean("key_current_info_show")) {
            paramWebView.eEG();
          } else {
            paramWebView.eEH();
          }
        }
      }
    }
    
    final class b
      extends com.tencent.mm.plugin.webview.core.i
    {
      private b() {}
      
      public final void UD(int paramInt)
      {
        AppMethodBeat.i(188452);
        if (WebViewUI.this.CyX != null)
        {
          FontChooserView localFontChooserView = (FontChooserView)WebViewUI.this.CyX.findViewById(2131300194);
          if (localFontChooserView != null) {
            localFontChooserView.setSliderIndex(paramInt - 1);
          }
        }
        AppMethodBeat.o(188452);
      }
      
      public final void a(String paramString, arn paramarn)
      {
        AppMethodBeat.i(188443);
        if (!bs.isNullOrNil(paramarn.Title)) {
          WebViewUI.this.setMMTitle(paramarn.Title);
        }
        if (paramarn.DLI == 6) {
          WebViewUI.this.uv(false);
        }
        AppMethodBeat.o(188443);
      }
      
      public final void aAY(String paramString)
      {
        AppMethodBeat.i(188442);
        WebViewUI.this.bMt();
        AppMethodBeat.o(188442);
      }
      
      public final void aAZ(String paramString)
      {
        AppMethodBeat.i(188450);
        WebViewUI.this.aDm(paramString);
        AppMethodBeat.o(188450);
      }
      
      public final void b(String paramString, arn paramarn)
      {
        WebViewUI.this.CAj.Cxw = paramarn.EKF;
      }
      
      public final void bMF()
      {
        AppMethodBeat.i(188445);
        WebViewUI.this.uw(true);
        AppMethodBeat.o(188445);
      }
      
      public final void bk(int paramInt, String paramString)
      {
        AppMethodBeat.i(188440);
        super.bk(paramInt, paramString);
        if (paramInt != 5) {
          WebViewUI.this.uw(false);
        }
        AppMethodBeat.o(188440);
      }
      
      public final void c(String paramString, arn paramarn)
      {
        AppMethodBeat.i(188444);
        WebViewUI.this.nJQ = paramarn.EKZ;
        WebViewUI.b(WebViewUI.this, WebViewUI.this.kYu.eCm().ma(24));
        WebViewUI.this.Cfc.eBK().Cry = true;
        WebViewUI.this.Czw = com.tencent.mm.platformtools.z.a(paramarn.EKY);
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebViewUI", "onPermissionUpdate, getA8Key = %s", new Object[] { bs.cx(WebViewUI.this.Czw) });
        AppMethodBeat.o(188444);
      }
      
      public final void d(int paramInt1, String paramString1, int paramInt2, String paramString2)
      {
        AppMethodBeat.i(188453);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(154L, 12L, 1L, false);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(154L, com.tencent.mm.plugin.webview.h.a.Vi(paramInt1), 1L, false);
        WebViewUI.this.uw(true);
        WebViewUI.this.CAj.Cxz = false;
        switch (paramInt1)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(188453);
          return;
          k.Cya.VI(paramInt2);
          if ((WebViewUI.this.CzP != null) && (this.controller.eyF())) {
            WebViewUI.this.eEk();
          }
          WebViewUI.this.Cfc.eBK().Cry = false;
          WebViewUI.this.Cfc.eBE().ch(paramString1, false);
          if (WebViewUI.A(WebViewUI.this)) {
            WebViewUI.this.finish();
          }
        }
      }
      
      public final void dKr()
      {
        AppMethodBeat.i(188446);
        if (WebViewUI.this.CAd)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewUI", "edw postBinded hasDoPostBind");
          AppMethodBeat.o(188446);
          return;
        }
        WebViewUI.this.CAd = true;
        WebViewUI.this.bvh();
        AppMethodBeat.o(188446);
      }
      
      public final void eyU()
      {
        AppMethodBeat.i(188441);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebViewUI", "WebView-Trace onAuthSucc: url %s", new Object[] { WebViewUI.this.nJQ });
        WebViewUI.a(WebViewUI.this, this.controller.kYu.eCm());
        if (!WebViewUI.this.CAJ) {
          WebViewUI.this.CAj.Cxz = true;
        }
        i locali = WebViewUI.this.CAj;
        locali.CxA.add(Integer.valueOf(6));
        locali.CxA.add(Integer.valueOf(1));
        locali.CxA.add(Integer.valueOf(3));
        locali.CxA.add(Integer.valueOf(2));
        WebViewUI.this.CAj.Cxz = true;
        if (WebViewUI.this.CAj.nPt) {
          WebViewUI.this.bMr();
        }
        AppMethodBeat.o(188441);
      }
      
      public final void eyV()
      {
        AppMethodBeat.i(188447);
        WebViewUI.this.goBack();
        AppMethodBeat.o(188447);
      }
      
      public final void eyW()
      {
        AppMethodBeat.i(188449);
        WebViewUI.this.eDV();
        AppMethodBeat.o(188449);
      }
      
      public final void eyX()
      {
        AppMethodBeat.i(188454);
        super.eyX();
        WebViewUI.this.CyR.start();
        AppMethodBeat.o(188454);
      }
      
      public final void eyY()
      {
        AppMethodBeat.i(188455);
        super.eyY();
        WebViewUI.this.CyR.finish();
        AppMethodBeat.o(188455);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(188448);
        WebViewUI.this.finish();
        AppMethodBeat.o(188448);
      }
      
      public final void uf(boolean paramBoolean)
      {
        AppMethodBeat.i(188451);
        if ((paramBoolean) && (WebViewUI.this.nKq != null))
        {
          WebViewUI.this.nKq.setOnLongClickListener(WebViewUI.y(WebViewUI.this));
          WebViewUI.z(WebViewUI.this);
        }
        AppMethodBeat.o(188451);
      }
    }
  }
  
  final class d
    implements FontChooserView.a
  {
    private d() {}
    
    public final void NB(int paramInt)
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
        WebViewUI.this.Cfr.UC(i);
        try
        {
          if (WebViewUI.this.kYt.eCC())
          {
            aw localaw = aw.fK("WebViewFontUtil", 2);
            localaw.putBoolean("webview_key_font_has_set", true);
            localaw.putBoolean("webview_key_has_transfer_mp", true);
            localaw.apply();
            com.tencent.mm.plugin.webview.j.e.uJ(false);
            WebViewUI.this.kYt.iO(16384, i);
            WebViewUI.this.kYt.iO(16388, i);
          }
          AppMethodBeat.o(80184);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WebViewUI", "onCheckedChanged, ex = " + localException.getMessage());
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
    final WeakReference<WebViewUI> lvU;
    
    public e(WebViewUI paramWebViewUI)
    {
      AppMethodBeat.i(80216);
      this.lvU = new WeakReference(paramWebViewUI);
      this.id = paramWebViewUI.eyt();
      AppMethodBeat.o(80216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI
 * JD-Core Version:    0.7.0.1
 */