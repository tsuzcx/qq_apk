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
import android.content.MutableContextWrapper;
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
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
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
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.PermissionRequest;
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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.luggage.k.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.y;
import com.tencent.mm.api.q;
import com.tencent.mm.f.a.ve;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.n.e.a;
import com.tencent.mm.n.e.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView;
import com.tencent.mm.plugin.webview.WebViewTransHelper;
import com.tencent.mm.plugin.webview.WebViewTransHelper.b;
import com.tencent.mm.plugin.webview.WebViewTransHelper.c;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.c.j;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.d;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.g;
import com.tencent.mm.plugin.webview.d.h.27;
import com.tencent.mm.plugin.webview.d.h.68;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.model.ag.c;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.ak.a;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.plugin.webview.model.as.a;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.model.ay.a;
import com.tencent.mm.plugin.webview.model.ay.b;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.model.ba.b;
import com.tencent.mm.plugin.webview.model.ba.e;
import com.tencent.mm.plugin.webview.model.ba.f;
import com.tencent.mm.plugin.webview.model.ba.g;
import com.tencent.mm.plugin.webview.model.ba.h;
import com.tencent.mm.plugin.webview.model.ba.k;
import com.tencent.mm.plugin.webview.model.ba.l;
import com.tencent.mm.plugin.webview.model.ba.m;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.i;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.q;
import com.tencent.mm.plugin.webview.ui.tools.video.b.2;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel;
import com.tencent.mm.plugin.webview.ui.tools.widget.n.h;
import com.tencent.mm.pluginsdk.model.ab.a;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.fkz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.AccessibilityUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.MMWebView.b;
import com.tencent.mm.ui.widget.MMWebView.c;
import com.tencent.mm.ui.widget.MMWebView.f;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.aa;
import com.tencent.xweb.ac;
import com.tencent.xweb.o;
import com.tencent.xweb.x.a;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@com.tencent.mm.ui.widget.pulldown.c(0)
public class WebViewUI
  extends MMSecDataActivity
  implements View.OnCreateContextMenuListener, f.e, com.tencent.mm.plugin.webview.core.b, com.tencent.mm.plugin.webview.h.a.b, com.tencent.mm.plugin.webview.ui.tools.video.samelayer.e, ScreenShotUtil.ScreenShotCallback, MMWebView.f
{
  private static final Pattern PQb;
  private static final Pattern PQc;
  private static final ArrayList<e> QfC;
  private static WebSettings.RenderPriority QfH;
  private static Boolean QgC;
  protected static int Qgb;
  protected com.tencent.mm.ui.widget.snackbar.a.b CBU;
  public int CTy;
  public String CTz;
  private View Cwk;
  private com.tencent.mm.ui.statusbar.c.a Cwl;
  private long EIx;
  protected boolean IYi;
  protected MultiCodeMaskView KNZ;
  public p PHI;
  public com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h PHJ;
  public com.tencent.mm.plugin.webview.core.i PIQ;
  public ba PIx;
  protected int PJe;
  public com.tencent.mm.plugin.webview.stub.f POP;
  public com.tencent.mm.plugin.webview.d.h PvJ;
  private View QcS;
  protected boolean QeR;
  private boolean QeS;
  protected MMFalseProgressBar QeT;
  public ProgressBar QeU;
  public s QeV;
  private j QeW;
  private ImageButton QeX;
  private ImageButton QeY;
  protected View QeZ;
  private View QfA;
  private MTimerHandler QfB;
  private boolean QfD;
  private WebChromeClient.CustomViewCallback QfE;
  protected com.tencent.xweb.x QfF;
  private ProgressBar QfG;
  protected boolean QfI;
  private final IListener<SendDataToH5FromMiniProgramEvent> QfJ;
  private boolean QfK;
  protected boolean QfL;
  protected HashMap<String, Boolean> QfM;
  protected HashMap<String, String> QfN;
  protected HashMap<String, ArrayList<e.b>> QfO;
  protected HashMap<String, Boolean> QfP;
  protected a QfQ;
  protected com.tencent.mm.ui.widget.a.d QfR;
  protected View QfS;
  protected String QfT;
  private boolean QfU;
  private boolean QfV;
  protected volatile boolean QfW;
  protected boolean QfX;
  private Map QfY;
  private int QfZ;
  protected WebViewKeyboardLinearLayout Qfa;
  protected FrameLayout Qfb;
  public FrameLayout Qfc;
  protected MovingImageButton Qfd;
  protected boolean Qfe;
  private boolean Qff;
  protected com.tencent.mm.br.a Qfg;
  private WebViewRedesignInputFooter Qfh;
  private View Qfi;
  protected WebViewSearchContentInputFooter Qfj;
  private boolean Qfk;
  private boolean Qfl;
  public String Qfm;
  protected boolean Qfn;
  protected boolean Qfo;
  protected long Qfp;
  private boolean Qfq;
  private int Qfr;
  private int Qfs;
  private boolean Qft;
  protected boolean Qfu;
  public AccessibilityManager.AccessibilityStateChangeListener Qfv;
  private boolean Qfw;
  protected boolean Qfx;
  protected int Qfy;
  protected byte[] Qfz;
  int QgA;
  private boolean QgB;
  protected View QgD;
  private com.tencent.mm.br.a.b QgE;
  private boolean QgF;
  public final l QgG;
  final com.tencent.mm.plugin.webview.modeltools.a QgH;
  public final com.tencent.mm.plugin.webview.ui.tools.media.e QgI;
  private boolean QgJ;
  private View.OnLongClickListener QgK;
  protected boolean QgL;
  private View.OnLongClickListener QgM;
  protected View.OnLongClickListener QgN;
  protected volatile String QgO;
  private WebChromeClient.CustomViewCallback QgP;
  boolean QgQ;
  int QgR;
  protected c QgS;
  public int QgT;
  private MMWebView.b QgU;
  public int Qga;
  public boolean Qgc;
  private boolean Qgd;
  private boolean Qge;
  protected boolean Qgf;
  protected volatile boolean Qgg;
  private com.tencent.mm.plugin.webview.k.n Qgh;
  private com.tencent.mm.plugin.webview.model.b Qgi;
  protected WebViewLongClickHelper Qgj;
  public k Qgk;
  protected IUtils Qgl;
  private WebViewClipBoardHelper Qgm;
  protected com.tencent.mm.plugin.webview.r Qgn;
  protected volatile String Qgo;
  protected volatile long Qgp;
  protected HandOffURL Qgq;
  public i Qgr;
  com.tencent.mm.plugin.webview.ui.tools.floatball.b Qgs;
  com.tencent.mm.plugin.webview.ui.tools.multitask.a Qgt;
  private boolean Qgu;
  protected ac Qgv;
  private IListener<ve> Qgw;
  private com.tencent.mm.plugin.webview.ui.tools.widget.n Qgx;
  private boolean Qgy;
  private MPVideoPlayFullScreenView Qgz;
  public AccessibilityManager akm;
  private View bFK;
  public String fUj;
  private MMHandler handler;
  private s iYE;
  private ActionBar mActionBar;
  public com.tencent.mm.plugin.webview.stub.e pGC;
  protected com.tencent.mm.plugin.webview.f.g pGD;
  private final com.tencent.mm.plugin.webview.modeltools.c pGM;
  public MMWebView pHS;
  public String pHq;
  private int sJy;
  protected String sessionId;
  protected int syc;
  protected int syd;
  
  static
  {
    AppMethodBeat.i(80400);
    QfC = new ArrayList();
    QfH = WebSettings.RenderPriority.NORMAL;
    Qgb = 0;
    QgC = null;
    PQb = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    PQc = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    AppMethodBeat.o(80400);
  }
  
  public WebViewUI()
  {
    AppMethodBeat.i(80217);
    this.QeR = false;
    this.QeS = false;
    this.PJe = -1;
    this.Qfe = false;
    this.Qff = false;
    this.Qfm = null;
    this.Qfn = true;
    this.Qfo = false;
    this.Qfp = 0L;
    this.Qfq = false;
    this.sessionId = "";
    this.Qfs = -1;
    this.IYi = true;
    this.Qft = false;
    this.Qfu = true;
    this.Qfw = false;
    this.Qfx = false;
    this.Qfz = new byte[0];
    this.PvJ = null;
    this.QfD = false;
    this.pGD = null;
    this.QfI = false;
    this.PHJ = new com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h(this);
    this.QfJ = new IListener() {};
    this.QfK = false;
    this.pGC = null;
    this.PIQ = null;
    this.QfL = false;
    this.QfM = new HashMap();
    this.QfN = new HashMap();
    this.QfO = new HashMap();
    this.QfP = new HashMap();
    this.QfR = null;
    this.QfS = null;
    this.QfT = null;
    this.QfU = false;
    this.QfV = false;
    this.CTy = 0;
    this.CTz = null;
    this.QfW = false;
    this.QfX = false;
    this.QfZ = 0;
    this.Qga = ((int)(System.currentTimeMillis() / 1000L));
    this.Qgc = false;
    this.Qgd = false;
    this.Qge = false;
    this.Qgf = false;
    this.Qgg = false;
    this.PIx = new ba();
    this.Qgh = new com.tencent.mm.plugin.webview.k.n();
    this.Qgl = null;
    this.Qgu = false;
    this.Qgv = new ac()
    {
      public final void computeScroll(View paramAnonymousView)
      {
        AppMethodBeat.i(231555);
        if (WebViewUI.this.pHS == null)
        {
          AppMethodBeat.o(231555);
          return;
        }
        if (MMWebView.isX5()) {
          WebViewUI.this.pHS.hZQ();
        }
        AppMethodBeat.o(231555);
      }
      
      public final boolean dispatchTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(231562);
        if (WebViewUI.this.pHS == null)
        {
          AppMethodBeat.o(231562);
          return false;
        }
        if (MMWebView.isX5())
        {
          boolean bool = WebViewUI.this.pHS.av(paramAnonymousMotionEvent);
          AppMethodBeat.o(231562);
          return bool;
        }
        AppMethodBeat.o(231562);
        return false;
      }
      
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(231565);
        if (WebViewUI.this.pHS == null)
        {
          AppMethodBeat.o(231565);
          return false;
        }
        if (MMWebView.isX5())
        {
          boolean bool = WebViewUI.this.pHS.aw(paramAnonymousMotionEvent);
          AppMethodBeat.o(231565);
          return bool;
        }
        AppMethodBeat.o(231565);
        return false;
      }
      
      public final void onOverScrolled(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, View paramAnonymousView)
      {
        AppMethodBeat.i(231557);
        if (WebViewUI.this.pHS == null)
        {
          AppMethodBeat.o(231557);
          return;
        }
        if (MMWebView.isX5())
        {
          WebViewUI.this.pHS.g(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
          if ((paramAnonymousBoolean2) && (WebViewUI.this.PIx != null)) {
            WebViewUI.this.PIx.C("mm_scroll_bottom", Boolean.TRUE);
          }
        }
        AppMethodBeat.o(231557);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(80056);
        if (WebViewUI.this.pHS == null)
        {
          AppMethodBeat.o(80056);
          return;
        }
        if (MMWebView.isX5())
        {
          WebViewUI.this.pHS.W(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
          WebViewUI.this.onWebViewScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        }
        AppMethodBeat.o(80056);
      }
      
      public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(231545);
        if (WebViewUI.this.pHS == null)
        {
          AppMethodBeat.o(231545);
          return false;
        }
        if (MMWebView.isX5())
        {
          boolean bool = WebViewUI.this.pHS.au(paramAnonymousMotionEvent);
          AppMethodBeat.o(231545);
          return bool;
        }
        AppMethodBeat.o(231545);
        return false;
      }
      
      public final boolean overScrollBy(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean, View paramAnonymousView)
      {
        AppMethodBeat.i(231549);
        if (WebViewUI.this.pHS == null)
        {
          AppMethodBeat.o(231549);
          return false;
        }
        if ((WebViewUI.b(WebViewUI.this) != null) && (WebViewUI.b(WebViewUI.this).I(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt5))) {}
        for (boolean bool = true;; bool = false)
        {
          WebViewUI.this.pHS.setHorizontalScrollPage(bool);
          if (!MMWebView.isX5()) {
            break;
          }
          paramAnonymousView = WebViewUI.this.PIx.gWa();
          if (paramAnonymousInt4 > paramAnonymousView.PVv) {
            paramAnonymousView.PVv = paramAnonymousInt4;
          }
          paramAnonymousView.LcP = paramAnonymousInt6;
          paramAnonymousBoolean = WebViewUI.this.pHS.b(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
          AppMethodBeat.o(231549);
          return paramAnonymousBoolean;
        }
        AppMethodBeat.o(231549);
        return true;
      }
    };
    this.Qgw = new IListener()
    {
      private boolean gZl()
      {
        AppMethodBeat.i(80075);
        if (WebViewUI.this.pGC == null)
        {
          Log.e("MicroMsg.WebViewUI", "Cli Event, invoker is null");
          AppMethodBeat.o(80075);
          return false;
        }
        if ((WebViewUI.this.Qgo == null) || (WebViewUI.this.Qgo.length() == 0))
        {
          Log.e("MicroMsg.WebViewUI", "Cli Event, tid is null");
          AppMethodBeat.o(80075);
          return false;
        }
        try
        {
          long l = System.currentTimeMillis();
          Log.i("MicroMsg.WebViewUI", "Cli Event, tid = %s, stime = %d, etime = %d", new Object[] { WebViewUI.this.Qgo, Long.valueOf(WebViewUI.this.Qgp), Long.valueOf(l) });
          Bundle localBundle = new Bundle();
          localBundle.putString("service_click_tid", new String(WebViewUI.this.Qgo));
          localBundle.putLong("service_click_stime", WebViewUI.this.Qgp);
          localBundle.putLong("service_click_etime", l);
          WebViewUI.this.pGC.z(2836, localBundle);
          WebViewUI.this.Qgo = null;
          AppMethodBeat.o(80075);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.WebViewUI", "Cli Event Exception, msg = %s", new Object[] { localException.getMessage() });
          }
        }
      }
    };
    this.Qgy = false;
    this.QgA = 0;
    this.QgB = true;
    this.EIx = 0L;
    this.sJy = 0;
    this.QgE = new com.tencent.mm.br.a.b()
    {
      public final void a(com.tencent.mm.br.a.a paramAnonymousa1, com.tencent.mm.br.a.a paramAnonymousa2)
      {
        AppMethodBeat.i(264953);
        Log.i("MicroMsg.WebViewUI", "OrientationListener lastOrientation:" + paramAnonymousa1.name() + "; newOrientation:" + paramAnonymousa2.name());
        WebViewUI.this.PJe = 4;
        WebViewUI.this.setMMOrientation();
        if (WebViewUI.this.Qfg != null) {
          WebViewUI.this.Qfg.disable();
        }
        AppMethodBeat.o(264953);
      }
    };
    this.QgF = false;
    this.QgG = new l();
    this.pGM = new com.tencent.mm.plugin.webview.modeltools.c();
    this.QgH = new com.tencent.mm.plugin.webview.modeltools.a();
    this.QgI = new com.tencent.mm.plugin.webview.ui.tools.media.e();
    this.QgK = new View.OnLongClickListener()
    {
      private boolean gZm()
      {
        boolean bool2 = true;
        AppMethodBeat.i(80078);
        Object localObject = null;
        try
        {
          WebView.b localb = WebViewUI.this.pHS.getHitTestResult();
          localObject = localb;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Log.e("MicroMsg.WebViewUI", "getHitTestResult exp %s", new Object[] { localException1.getMessage() });
          }
        }
        if ((localObject == null) || (Util.isNullOrNil(localObject.mExtra)))
        {
          Log.e("MicroMsg.WebViewUI", "hittestresult getExtra is null");
          AppMethodBeat.o(80078);
          return false;
        }
        try
        {
          bool1 = WebViewUI.this.pGC.hh(localObject.mExtra);
          if (!bool1) {}
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            label140:
            boolean bool1 = true;
            Log.w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + localException2.getMessage());
          }
        }
        try
        {
          WebViewUI.this.pGC.hb(localObject.mExtra, WebViewUI.this.PIQ.gSo());
          if (bool1) {
            break label184;
          }
          WebViewUI.c(WebViewUI.this, localObject.mExtra);
          bool1 = bool2;
        }
        catch (Exception localException3)
        {
          break label151;
          break label140;
        }
        AppMethodBeat.o(80078);
        return bool1;
      }
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80077);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$31", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        if (WebViewUI.this.getIntent().getBooleanExtra("show_long_click_popup_menu", true))
        {
          boolean bool = gZm();
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$31", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(80077);
          return bool;
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$31", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(80077);
        return true;
      }
    };
    this.QgL = false;
    this.QgN = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(239656);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$35", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        if ((WebViewUI.h(WebViewUI.this) != null) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())))
        {
          boolean bool = WebViewUI.h(WebViewUI.this).onLongClick(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$35", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(239656);
          return bool;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$35", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(239656);
        return false;
      }
    };
    this.QgO = "";
    this.QgQ = true;
    this.QgR = 0;
    this.QgS = new c();
    this.CBU = new com.tencent.mm.ui.widget.snackbar.a.b()
    {
      public final void bPM()
      {
        AppMethodBeat.i(267302);
        try
        {
          WebViewUI.this.pGC.favEditTag();
          AppMethodBeat.o(267302);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + localException.getMessage());
          AppMethodBeat.o(267302);
        }
      }
    };
    this.QgT = -1;
    this.QgU = null;
    AppMethodBeat.o(80217);
  }
  
  private void CT(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.QfD = true;
    }
  }
  
  private void Dg(boolean paramBoolean)
  {
    AppMethodBeat.i(220221);
    this.PIQ.gSk();
    ba.TC(5L);
    if ((this.QeW != null) && (this.QeW.gXE())) {
      if (!paramBoolean) {
        break label64;
      }
    }
    label64:
    for (int i = 6;; i = 3)
    {
      ba.e.cI(elY(), i);
      ba.TC(6L);
      AppMethodBeat.o(220221);
      return;
    }
  }
  
  private void a(JsapiPermissionWrapper paramJsapiPermissionWrapper)
  {
    AppMethodBeat.i(220241);
    if (paramJsapiPermissionWrapper != null)
    {
      if (paramJsapiPermissionWrapper.so(34))
      {
        setMMSubTitle(c.i.wechat_authenticate_safely);
        AppMethodBeat.o(220241);
        return;
      }
      if (paramJsapiPermissionWrapper.so(75))
      {
        setMMSubTitle(c.i.wechat_wx_safe_login);
        AppMethodBeat.o(220241);
        return;
      }
      setMMSubTitle(null);
    }
    AppMethodBeat.o(220241);
  }
  
  private static void aH(View paramView, int paramInt)
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
  
  private void bkl(String paramString)
  {
    AppMethodBeat.i(80241);
    if (this.PvJ != null)
    {
      this.PvJ.bjZ(paramString);
      try
      {
        if (paramString.equals("onPause"))
        {
          if (this.pGC != null) {
            this.pGC.aop(this.PIQ.gSo());
          }
          this.PvJ.setActive(false);
          AppMethodBeat.o(80241);
          return;
        }
        if (paramString.equals("onResume"))
        {
          if (this.pGC != null) {
            this.pGC.aoo(this.PIQ.gSo());
          }
          this.PvJ.setActive(true);
        }
        AppMethodBeat.o(80241);
        return;
      }
      catch (Exception paramString)
      {
        Log.w("MicroMsg.WebViewUI", "onResume, ex = " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(80241);
  }
  
  private void bmk(String paramString)
  {
    AppMethodBeat.i(80239);
    if ((this.Qgs != null) && (!Util.isNullOrNil(paramString)) && (!com.tencent.mm.plugin.webview.ui.tools.floatball.b.isMpUrl(cDu()))) {
      this.Qgs.aoy(paramString);
    }
    if ((this.Qgt != null) && (!Util.isNullOrNil(paramString)) && (!com.tencent.mm.plugin.webview.ui.tools.multitask.a.isMpUrl(cDu()))) {
      this.Qgt.aMT(paramString);
    }
    AppMethodBeat.o(80239);
  }
  
  private void bml(String paramString)
  {
    AppMethodBeat.i(80240);
    if ((this.Qgq != null) && (!Util.isNullOrNil(paramString)) && ((this.Qgs != null) || (this.Qgt != null)) && (!((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).isMpUrl(cDu())) && (!this.Qgq.getTitle().equals(paramString)))
    {
      this.Qgq.setTitle(paramString);
      if (gUC()) {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Qgq);
      }
    }
    AppMethodBeat.o(80240);
  }
  
  private void bmm(String paramString)
  {
    AppMethodBeat.i(219901);
    if ((Util.isNullOrNil(paramString)) || (paramString.startsWith("data:text/html;charset=utf-8")))
    {
      AppMethodBeat.o(219901);
      return;
    }
    if (this.PIQ != null) {}
    for (String str = this.PIQ.boj();; str = "")
    {
      str = Util.nullAsNil(str);
      if (this.Qgs != null) {
        this.Qgs.fi("handoff#shareUrl", str);
      }
      if (this.Qgt != null) {
        this.Qgt.PRr.UJs = str;
      }
      if (!str.isEmpty()) {
        paramString = str;
      }
      if ((this.Qgq != null) && (!Util.isNullOrNil(paramString)) && (!this.Qgq.getUrl().equals(paramString)))
      {
        this.Qgq.setUrl(paramString);
        if (gUC()) {
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Qgq);
        }
      }
      AppMethodBeat.o(219901);
      return;
    }
  }
  
  private static String bmn(String paramString)
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
      Log.e("MicroMsg.WebViewUI", "getFileNameFromContentDisposition error " + paramString.getMessage());
      AppMethodBeat.o(80299);
    }
    return null;
  }
  
  private static void d(Dialog paramDialog)
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
  
  private boolean gXm()
  {
    boolean bool1 = false;
    AppMethodBeat.i(80298);
    try
    {
      if (this.pGC == null)
      {
        Log.w("MicroMsg.WebViewUI", "invoker is null");
        AppMethodBeat.o(80298);
        return false;
      }
      boolean bool2 = this.pGC.gXm();
      bool1 = bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewUI", "unable get config for WebViewDownLoadFile" + localRemoteException.getMessage());
      }
    }
    AppMethodBeat.o(80298);
    return bool1;
  }
  
  private boolean gYC()
  {
    AppMethodBeat.i(80255);
    if ((!Util.isNullOrNil(this.CTz)) && (this.CTz.equals("black")))
    {
      AppMethodBeat.o(80255);
      return true;
    }
    AppMethodBeat.o(80255);
    return false;
  }
  
  private View gYG()
  {
    AppMethodBeat.i(80264);
    View localView = null;
    try
    {
      i = Resources.getSystem().getIdentifier("action_bar_container", "id", "android");
      if (i > 0) {
        localView = findViewById(i);
      }
      Log.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", new Object[] { Integer.valueOf(i), localView });
      AppMethodBeat.o(80264);
      return localView;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewUI", "get resId action_bar_container, exp = %s", new Object[] { localException });
        int i = -1;
      }
    }
  }
  
  private boolean gYR()
  {
    AppMethodBeat.i(220160);
    boolean bool1 = getIntent().getBooleanExtra("forceHideShare", false);
    boolean bool2 = getIntent().getBooleanExtra("showShare", true);
    Log.i("MicroMsg.WebViewUI", "forceHideShare:%b: showShareBtn:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((!bool1) && (bool2))
    {
      AppMethodBeat.o(220160);
      return true;
    }
    AppMethodBeat.o(220160);
    return false;
  }
  
  private void gYW()
  {
    AppMethodBeat.i(80316);
    if (this.QfA != null) {
      this.QfA.setVisibility(8);
    }
    if (this.QfB != null) {
      this.QfB.stopTimer();
    }
    AppMethodBeat.o(80316);
  }
  
  private com.tencent.mm.plugin.webview.model.b gYm()
  {
    AppMethodBeat.i(219785);
    if (this.Qgi == null) {
      this.Qgi = new com.tencent.mm.plugin.webview.model.b(this.PIx);
    }
    com.tencent.mm.plugin.webview.model.b localb = this.Qgi;
    AppMethodBeat.o(219785);
    return localb;
  }
  
  public static boolean gYq()
  {
    AppMethodBeat.i(219786);
    if (com.tencent.mm.kernel.h.aHB()) {
      com.tencent.mm.kernel.h.aHE();
    }
    for (String str = com.tencent.mm.kernel.b.aGq(); Util.isNullOrNil(str); str = "MMWebViewTransShouldPullHalfScreenNotice")
    {
      Log.e("MicroMsg.WebViewUI", "kvName is null");
      AppMethodBeat.o(219786);
      return true;
    }
    boolean bool = MultiProcessMMKV.getSingleMMKV(str).decodeBool("MMWebViewTransHasPullBefore", false);
    Log.i("MicroMsg.WebViewUI", "show trans notice before: %s", new Object[] { Boolean.toString(bool) });
    AppMethodBeat.o(219786);
    return bool;
  }
  
  private com.tencent.mm.plugin.webview.ui.tools.widget.n gYs()
  {
    AppMethodBeat.i(80223);
    if (this.Qgx == null)
    {
      this.Qgx = new com.tencent.mm.plugin.webview.ui.tools.widget.n(this, new com.tencent.mm.ui.x(getContext(), c.j.CommentPanel));
      this.Qgx.setVisibility(8);
      localObject = (ViewParent)getWindow().getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        ((ViewGroup)localObject).addView(this.Qgx, new FrameLayout.LayoutParams(-1, -1));
        localObject = this.Qgx;
        ((com.tencent.mm.plugin.webview.ui.tools.widget.n)localObject).Qfa.setOnkbdStateListener((KeyboardLinearLayout.a)new n.h((com.tencent.mm.plugin.webview.ui.tools.widget.n)localObject));
        int i = getIntent().getIntExtra(f.r.VSO, -1);
        getIntent().getIntExtra(f.r.VSJ, 0);
        int j = getIntent().getIntExtra(f.r.VSK, -1);
        int k = getIntent().getIntExtra(f.r.VSL, -1);
        localObject = this.Qgx;
        String str1 = cDu();
        String str2 = getTitle().toString();
        ((com.tencent.mm.plugin.webview.ui.tools.widget.n)localObject).scene = j;
        ((com.tencent.mm.plugin.webview.ui.tools.widget.n)localObject).wGA = k;
        ((com.tencent.mm.plugin.webview.ui.tools.widget.n)localObject).llp = i;
        ((com.tencent.mm.plugin.webview.ui.tools.widget.n)localObject).QtB = 0;
        ((com.tencent.mm.plugin.webview.ui.tools.widget.n)localObject).url = str1;
        ((com.tencent.mm.plugin.webview.ui.tools.widget.n)localObject).title = str2;
      }
    }
    Object localObject = this.Qgx;
    AppMethodBeat.o(80223);
    return localObject;
  }
  
  private static boolean gYw()
  {
    AppMethodBeat.i(80248);
    if (QgC == null) {}
    try
    {
      if (Util.getInt(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_webview_force_dark_disable", "0", false, true), 1) > 0) {
        Log.i("MicroMsg.WebViewUI", "disableForceDark on!!");
      }
      for (QgC = Boolean.TRUE;; QgC = Boolean.FALSE)
      {
        boolean bool = QgC.booleanValue();
        AppMethodBeat.o(80248);
        return bool;
        Log.i("MicroMsg.WebViewUI", "disableForceDark close!!");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WebViewUI", localException, "disableForceDark", new Object[0]);
        QgC = Boolean.FALSE;
      }
    }
  }
  
  private boolean gYy()
  {
    return (this.Qfe) || (this.Qff);
  }
  
  private int gYz()
  {
    AppMethodBeat.i(80252);
    int i = com.tencent.mm.ui.statusbar.a.bz(this);
    if ((this.mActionBar == null) || (!this.mActionBar.isShowing()))
    {
      AppMethodBeat.o(80252);
      return i;
    }
    if (this.Qgr.QcC.PQp)
    {
      AppMethodBeat.o(80252);
      return 0;
    }
    int j = getActionBarHeight();
    AppMethodBeat.o(80252);
    return i + j;
  }
  
  private boolean gZb()
  {
    AppMethodBeat.i(80355);
    int i = getIntent().getIntExtra("key_close_action", 0);
    Object localObject = getIntent().getBundleExtra("key_close_data");
    Log.i("MicroMsg.WebViewUI", "close action %s", new Object[] { Integer.valueOf(i) });
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
        } while (Util.isNullOrNil(new String[] { str2, str3, str4 }));
        if (bool) {
          com.tencent.mm.ui.base.h.a(this, str1, str2, str3, str4, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(246252);
              WebViewUI.this.Qgc = true;
              m.Qer.close();
              ba.e.cI(WebViewUI.this.elY(), 1);
              WebViewUI.this.finish();
              AppMethodBeat.o(246252);
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
              AppMethodBeat.i(217214);
              WebViewUI.this.Qgc = true;
              m.Qer.close();
              ba.e.cI(WebViewUI.this.elY(), 1);
              WebViewUI.this.finish();
              AppMethodBeat.o(217214);
            }
          });
        }
      } while (localObject == null);
      str1 = ((Bundle)localObject).getString("close_jump_url");
      i = ((Bundle)localObject).getInt("close_jump_url_request_code", 0);
    } while (Util.isNullOrNil(str1));
    localObject = new Intent(this, WebViewUI.class);
    ((Intent)localObject).putExtra("rawUrl", str1);
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("show_bottom", false);
    ((Intent)localObject).putExtra("needRedirect", false);
    ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
    ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
    startActivityForResult((Intent)localObject, i);
    com.tencent.mm.ui.base.b.lc(this);
    AppMethodBeat.o(80355);
    return true;
  }
  
  private void gZd()
  {
    AppMethodBeat.i(80357);
    if (this.Qge)
    {
      Log.d("MicroMsg.WebViewUI", "SwipeBackFinish, do not LaunchOuterApp");
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
      com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, localBundle, com.tencent.mm.pluginsdk.model.app.v.class, null);
    }
    AppMethodBeat.o(80357);
  }
  
  private static void hm(View paramView)
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
    AppMethodBeat.i(219947);
    if (this.pGC != null) {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("screen_orientation", this.PJe);
        this.pGC.l(83, localBundle);
        AppMethodBeat.o(219947);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.WebViewUI", "ac_set_screen_orientation : " + localException.getMessage());
      }
    }
    AppMethodBeat.o(219947);
  }
  
  protected void B(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80358);
    Log.i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
    AppMethodBeat.o(80358);
  }
  
  public final void Dd(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(80319);
    if (this.QeW != null) {
      this.QeW.Dd(paramBoolean);
    }
    ImageButton localImageButton;
    if ((this.pHS != null) && (this.QcS != null))
    {
      localImageButton = this.QeX;
      if ((this.pHS == null) || (!this.pHS.canGoBack())) {
        break label102;
      }
      paramBoolean = true;
      localImageButton.setEnabled(paramBoolean);
      localImageButton = this.QeY;
      if ((this.pHS == null) || (!this.pHS.canGoForward())) {
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
  
  protected void Df(boolean paramBoolean)
  {
    AppMethodBeat.i(80310);
    this.QgF = paramBoolean;
    if (this.pHS == null)
    {
      Log.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
      AppMethodBeat.o(80310);
      return;
    }
    enableOptionMenu(paramBoolean);
    showOptionMenu(paramBoolean);
    paramBoolean = getIntent().getBooleanExtra("show_feedback", false);
    if (paramBoolean) {
      showOptionMenu(paramBoolean);
    }
    int i = gYV();
    if (gYU() != null) {
      i = c.h.mm_title_btn_jd;
    }
    paramBoolean = getIntent().getBooleanExtra("KRightBtn", false);
    boolean bool = getIntent().getBooleanExtra("KShowFixToolsBtn", false);
    Log.i("MicroMsg.WebViewUI", "banRightBtn:%b, showFixToolsBtn:%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    if (!paramBoolean)
    {
      if (bool) {
        addIconOptionMenu(1, c.h.fix_tools_entry, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(228668);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(WebViewUI.this, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
            ((Intent)localObject).putExtra("entry_fix_tools", 1);
            paramAnonymousMenuItem = WebViewUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$36", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$36", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(228668);
            return true;
          }
        });
      }
      addIconOptionMenu(0, i, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(80084);
          if (WebViewUI.this.pGD.blz(WebViewUI.this.elY())) {
            WebViewUI.this.PIx.gWd().D(new Object[] { WebViewUI.this.cDu(), Integer.valueOf(6) }).report();
          }
          for (;;)
          {
            WebViewUI.this.gXW();
            AppMethodBeat.o(80084);
            return true;
            WebViewUI.this.PIx.gWd().D(new Object[] { WebViewUI.this.cDu(), Integer.valueOf(5) }).report();
          }
        }
      }, this.QgN);
    }
    AppMethodBeat.o(80310);
  }
  
  protected final void Dh(boolean paramBoolean)
  {
    AppMethodBeat.i(220224);
    enableOptionMenu(true);
    Log.d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", new Object[] { Boolean.TRUE });
    setProgressBarIndeterminateVisibility(false);
    if (paramBoolean)
    {
      this.Qgk.gXU();
      AppMethodBeat.o(220224);
      return;
    }
    if ((!this.QfW) && (!this.QfX)) {
      this.PIQ.cDD();
    }
    AppMethodBeat.o(220224);
  }
  
  public final void Di(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(220236);
    Log.d("MicroMsg.WebViewUI", "setAccessibilityFocusable %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!com.tencent.mm.ui.a.a.a.hJg().hJd())
    {
      AppMethodBeat.o(220236);
      return;
    }
    Object localObject1;
    int i;
    label79:
    label101:
    boolean bool1;
    if (this.mActionBar == null)
    {
      localObject1 = null;
      if (!paramBoolean) {
        break label217;
      }
      this.QgQ = isOptionMenuShow(0);
      if (localObject1 == null) {
        break label212;
      }
      i = ((View)localObject1).getVisibility();
      this.QgR = i;
      showOptionMenu(0, false);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(4);
      }
      if (this.QgG != null)
      {
        localObject1 = this.QgG;
        Object localObject2;
        if (((l)localObject1).Qel != null)
        {
          localObject2 = com.tencent.mm.plugin.bizui.a.a.shG;
          localObject2 = ((l)localObject1).Qel;
          if (paramBoolean) {
            break label243;
          }
          bool1 = true;
          label140:
          com.tencent.mm.plugin.bizui.a.a.n((View)localObject2, bool1);
        }
        if ((((l)localObject1).Qem != null) && (!Util.isNullOrNil(((l)localObject1).Qem.getText())))
        {
          localObject2 = com.tencent.mm.plugin.bizui.a.a.shG;
          localObject1 = ((l)localObject1).Qel;
          if (paramBoolean) {
            break label248;
          }
        }
      }
    }
    label212:
    label217:
    label243:
    label248:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      com.tencent.mm.plugin.bizui.a.a.n((View)localObject1, paramBoolean);
      AppMethodBeat.o(220236);
      return;
      localObject1 = this.mActionBar.getCustomView();
      break;
      i = 0;
      break label79;
      showOptionMenu(0, this.QgQ);
      if (localObject1 == null) {
        break label101;
      }
      ((View)localObject1).setVisibility(this.QgR);
      break label101;
      bool1 = false;
      break label140;
    }
  }
  
  public final void Dj(boolean paramBoolean)
  {
    AppMethodBeat.i(80359);
    if (this.pHS == null)
    {
      AppMethodBeat.o(80359);
      return;
    }
    String str = this.pHS.getUrl();
    if (paramBoolean)
    {
      showOptionMenu(0, false);
      this.QfP.put(str, Boolean.TRUE);
      AppMethodBeat.o(80359);
      return;
    }
    showOptionMenu(0, true);
    if (this.QfP.containsKey(str)) {
      this.QfP.remove(str);
    }
    AppMethodBeat.o(80359);
  }
  
  public final void TF(long paramLong)
  {
    AppMethodBeat.i(220178);
    this.Qgk.TF(paramLong);
    AppMethodBeat.o(220178);
  }
  
  public final void a(com.tencent.mm.plugin.webview.ui.tools.video.c paramc)
  {
    AppMethodBeat.i(219841);
    this.PHJ.a(paramc);
    AppMethodBeat.o(219841);
  }
  
  public final void aG(View paramView, int paramInt)
  {
    AppMethodBeat.i(219839);
    com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h localh = this.PHJ;
    Object localObject = paramView;
    if (paramView == null) {
      localObject = this.pHS;
    }
    localh.aG((View)localObject, paramInt);
    AppMethodBeat.o(219839);
  }
  
  protected void aI(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220034);
    t(null, paramString, paramInt1, paramInt2);
    AppMethodBeat.o(220034);
  }
  
  public final void aO(Bundle paramBundle)
  {
    AppMethodBeat.i(80231);
    this.QgA = paramBundle.getInt("state", 0);
    AppMethodBeat.o(80231);
  }
  
  public final void aP(Bundle paramBundle)
  {
    AppMethodBeat.i(80227);
    if (paramBundle != null)
    {
      this.Qgy = "black".equals(paramBundle.getString("style"));
      gYs().setCommentTopicId(paramBundle.getLong("commentTopicId"));
    }
    gYs().bnl(elY());
    gYs().Du(false);
    AppMethodBeat.o(80227);
  }
  
  public final void aQ(Bundle paramBundle)
  {
    AppMethodBeat.i(80229);
    if (paramBundle != null)
    {
      this.Qgy = "black".equals(paramBundle.getString("style"));
      gYs().Du(true);
    }
    AppMethodBeat.o(80229);
  }
  
  public final void aR(Bundle paramBundle)
  {
    AppMethodBeat.i(80230);
    this.iYE = com.tencent.mm.plugin.webview.k.d.a(paramBundle, getContext(), this.iYE);
    AppMethodBeat.o(80230);
  }
  
  public final void aS(Bundle paramBundle)
  {
    AppMethodBeat.i(175797);
    if (paramBundle != null) {
      gYs().setCommentTopicId(paramBundle.getLong("commentTopicId"));
    }
    gYs().bnl(elY());
    com.tencent.mm.plugin.webview.ui.tools.widget.n localn = gYs();
    String str = paramBundle.getString("reply_content");
    int i = paramBundle.getInt("personal_comment_id");
    kotlin.g.b.p.k(str, "replyContent");
    localn.Bv(2);
    localn.Dw(false);
    if ((!Util.isNullOrNil(str)) && (i != 0) && (localn.hcc()))
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n.a(localn, str, i);
      localn.Dv(false);
      AppMethodBeat.o(175797);
      return;
    }
    localn.Du(false);
    AppMethodBeat.o(175797);
  }
  
  protected void aW(Bundle paramBundle) {}
  
  public void aX(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(80220);
    int i;
    int j;
    if (paramBundle.getBoolean("set_navigation_bar_color_reset", false)) {
      if (this.PHI == null)
      {
        i = getResources().getColor(c.c.webview_actionbar_color);
        int k = 255;
        j = i;
        i = k;
      }
    }
    for (;;)
    {
      setActionbarColor(0xFFFFFF & j | i << 24);
      if (bool) {
        setTitleAlpha(i / 255.0F);
      }
      AppMethodBeat.o(80220);
      return;
      i = this.PHI.gZw();
      break;
      j = paramBundle.getInt("set_navigation_bar_color_color");
      i = paramBundle.getInt("set_navigation_bar_color_alpha");
      bool = paramBundle.getBoolean("set_navigation_bar_color_titleAlphaAdjustment");
    }
  }
  
  protected final void aY(Bundle paramBundle)
  {
    AppMethodBeat.i(219798);
    if (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).isMpUrl(cDu())) {
      paramBundle.putInt("_DATA_CENTER_ITEM_SHOW_TYPE", this.Qfs);
    }
    AppMethodBeat.o(219798);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(80313);
    if (!com.tencent.mm.compatible.util.d.qV(21))
    {
      super.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
      AppMethodBeat.o(80313);
      return;
    }
    Drawable localDrawable = androidx.core.content.a.m(this, paramInt2);
    if (localDrawable == null)
    {
      AppMethodBeat.o(80313);
      return;
    }
    if (gYC()) {
      localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
    for (;;)
    {
      addIconOptionMenu(paramInt1, getString(c.i.app_more), localDrawable, paramOnMenuItemClickListener);
      AppMethodBeat.o(80313);
      return;
      if ((this.PHI != null) && (!this.PHI.Qhl)) {
        localDrawable.setColorFilter(getResources().getColor(c.c.FG_0), PorterDuff.Mode.SRC_ATOP);
      } else {
        localDrawable.clearColorFilter();
      }
    }
  }
  
  protected final void aoC(int paramInt)
  {
    AppMethodBeat.i(80288);
    Drawable localDrawable = getResources().getDrawable(gYO()).mutate();
    localDrawable.setColorFilter(paramInt, PorterDuff.Mode.SRC_IN);
    updateBackBtn(localDrawable);
    AppMethodBeat.o(80288);
  }
  
  protected final void aoD(int paramInt)
  {
    AppMethodBeat.i(80315);
    if (paramInt != -3)
    {
      AppMethodBeat.o(80315);
      return;
    }
    if (this.QfA == null)
    {
      AppMethodBeat.o(80315);
      return;
    }
    if ((this.pGD.gWJ().RAZ & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = ".concat(String.valueOf(bool)));
      if (!bool) {
        break label233;
      }
      if ((this.QfA.getVisibility() != 0) && (!this.Qfj.isShown())) {
        break;
      }
      AppMethodBeat.o(80315);
      return;
    }
    if (this.QfB == null) {
      this.QfB = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(264277);
          WebViewUI.l(WebViewUI.this);
          AppMethodBeat.o(264277);
          return false;
        }
      }, false);
    }
    this.QfB.startTimer(4000L);
    View localView = this.QfA;
    ((ImageView)localView.findViewById(c.f.listen_model_notify_imageview)).setImageResource(c.h.net_warn_icon);
    TextView localTextView = (TextView)localView.findViewById(c.f.listen_model_notify_text);
    localTextView.setTextSize(14.0F);
    localTextView.setText(c.i.wv_alert_input_tips);
    ((ImageButton)localView.findViewById(c.f.listen_model_notify_btn)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(221753);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WebViewUI.l(WebViewUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(221753);
      }
    });
    this.QfA.setVisibility(0);
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(13125, cDu());
    label233:
    AppMethodBeat.o(80315);
  }
  
  public final void aoE(int paramInt)
  {
    AppMethodBeat.i(220215);
    this.PvJ.cZ("sendAppMessage", true);
    this.PvJ.c(this.Qgk.gXZ(), paramInt);
    this.PIx.bkW("mm_send_friend_count");
    AppMethodBeat.o(220215);
  }
  
  protected void aoF(int paramInt)
  {
    AppMethodBeat.i(80351);
    if ((this.pHS == null) || (this.pHS.getSettings() == null))
    {
      AppMethodBeat.o(80351);
      return;
    }
    Log.i("MicroMsg.WebViewUI", "localSetFontSize, fontSize = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      this.pHS.getSettings().setTextZoom(100);
      AppMethodBeat.o(80351);
      return;
    case 1: 
      this.pHS.getSettings().setTextZoom(80);
      AppMethodBeat.o(80351);
      return;
    case 2: 
      this.pHS.getSettings().setTextZoom(100);
      AppMethodBeat.o(80351);
      return;
    case 3: 
      this.pHS.getSettings().setTextZoom(110);
      AppMethodBeat.o(80351);
      return;
    case 4: 
      this.pHS.getSettings().setTextZoom(112);
      AppMethodBeat.o(80351);
      return;
    case 5: 
      this.pHS.getSettings().setTextZoom(112);
      AppMethodBeat.o(80351);
      return;
    case 6: 
      this.pHS.getSettings().setTextZoom(140);
      AppMethodBeat.o(80351);
      return;
    case 7: 
      this.pHS.getSettings().setTextZoom(155);
      AppMethodBeat.o(80351);
      return;
    }
    this.pHS.getSettings().setTextZoom(165);
    AppMethodBeat.o(80351);
  }
  
  protected final void atk()
  {
    AppMethodBeat.i(80342);
    this.Qgk.atk();
    AppMethodBeat.o(80342);
  }
  
  public final void b(com.tencent.mm.plugin.webview.ui.tools.video.c paramc)
  {
    AppMethodBeat.i(219843);
    this.PHJ.b(paramc);
    AppMethodBeat.o(219843);
  }
  
  public final void b(s params)
  {
    this.iYE = params;
  }
  
  protected void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(80367);
    paramWebView = this.PIx;
    Intent localIntent = getIntent();
    String str2 = cDu();
    int i = localIntent.getIntExtra("geta8key_scene", 0);
    int j = localIntent.getIntExtra("bizEnterId", paramWebView.PWu);
    int k = localIntent.getIntExtra("webview_scene_type", 1);
    String str3 = localIntent.getStringExtra("webview_scene_note");
    String str1 = localIntent.getStringExtra("srcUsername");
    paramWebView = str1;
    if (Util.isNullOrNil(str1)) {
      paramWebView = localIntent.getStringExtra("geta8key_username");
    }
    str1 = localIntent.getStringExtra("KAppId");
    com.tencent.mm.plugin.report.service.h.IzE.a(18452, new Object[] { Integer.valueOf(j), Integer.valueOf(i), ab.aXb(str2), ab.aXb(paramString), Integer.valueOf(k), str3, str1, paramWebView });
    if ((this.QeU != null) && (this.QeU.getVisibility() == 0))
    {
      this.QeU.setVisibility(8);
      this.QfW = false;
    }
    AppMethodBeat.o(80367);
  }
  
  protected final void b(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(80309);
    addIconOptionMenu(0, paramString, paramDrawable, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(236490);
        if (!this.QgX) {
          WebViewUI.this.gXW();
        }
        for (;;)
        {
          AppMethodBeat.o(236490);
          return true;
          WebViewUI.this.bmo(this.iXL);
        }
      }
    });
    AppMethodBeat.o(80309);
  }
  
  public final void bF(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(80257);
    if ((Build.VERSION.SDK_INT >= 23) && (!MIUI.isMIUIV8()))
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
        i = e.aor(paramInt);
      }
      setStatusBarColor(i);
    }
    AppMethodBeat.o(80257);
  }
  
  protected final void bh(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(80280);
    this.Qfe = paramBoolean1;
    Object localObject;
    if (paramBoolean1)
    {
      if (this.mActionBar != null) {
        this.mActionBar.hide();
      }
      if (this.QgD != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.QgD.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
        this.QgD.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      com.tencent.mm.ui.statusbar.a.X(this.QgD, true);
      getWindow().addFlags(1024);
      localObject = getWindow().getDecorView();
      ((View)localObject).setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
      {
        public final void onSystemUiVisibilityChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(264735);
          if (((paramAnonymousInt & 0x4) == 0) && (WebViewUI.this.Qfe)) {
            WebViewUI.hn(this.qHD);
          }
          AppMethodBeat.o(264735);
        }
      });
      aH((View)localObject, 5894);
      if (paramBoolean2)
      {
        this.Qfd.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(267283);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            WebViewUI.this.gXW();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(267283);
          }
        });
        this.Qfd.setVisibility(0);
        AppMethodBeat.o(80280);
        return;
      }
      this.Qfd.setVisibility(8);
      AppMethodBeat.o(80280);
      return;
    }
    this.Qfd.setVisibility(8);
    getWindow().clearFlags(1024);
    hm(getWindow().getDecorView());
    if (this.mActionBar != null)
    {
      this.mActionBar.show();
      if (this.QgD != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.QgD.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = gYz();
        this.QgD.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    com.tencent.mm.ui.statusbar.a.X(this.QgD, false);
    AppMethodBeat.o(80280);
  }
  
  protected final int bjD(String paramString)
  {
    AppMethodBeat.i(80336);
    int i = this.PIQ.bjD(paramString);
    AppMethodBeat.o(80336);
    return i;
  }
  
  public final String bju(String paramString)
  {
    AppMethodBeat.i(220225);
    paramString = this.PIQ.bju(paramString);
    AppMethodBeat.o(220225);
    return paramString;
  }
  
  public final void bjx(String paramString)
  {
    AppMethodBeat.i(220227);
    Log.i("MicroMsg.WebViewUI", "getTransText");
    WebViewTransHelper localWebViewTransHelper = this.PHI.Qhm;
    kotlin.g.b.p.k(paramString, "content");
    if (!localWebViewTransHelper.gSf())
    {
      com.tencent.d.f.h.ioq();
      AppMethodBeat.o(220227);
      return;
    }
    "get web page content: ".concat(String.valueOf(paramString));
    com.tencent.d.f.h.ioq();
    new Handler(Looper.getMainLooper()).post((Runnable)new WebViewTransHelper.c(localWebViewTransHelper, paramString));
    AppMethodBeat.o(220227);
  }
  
  public final void bmi(String paramString)
  {
    AppMethodBeat.i(80306);
    this.Qgk.bmi(paramString);
    AppMethodBeat.o(80306);
  }
  
  public final void bmo(String paramString)
  {
    AppMethodBeat.i(80317);
    this.PvJ.cZ("profile", true);
    this.PvJ.bka(paramString);
    AppMethodBeat.o(80317);
  }
  
  public final MMHandler btS()
  {
    return this.handler;
  }
  
  public final void c(com.tencent.luggage.xweb_ext.extendplugin.a.a parama)
  {
    AppMethodBeat.i(219846);
    this.PHJ.c(parama);
    AppMethodBeat.o(219846);
  }
  
  protected void cDT()
  {
    AppMethodBeat.i(80247);
    Log.i("MicroMsg.WebViewUI", "onCreate" + hashCode());
    this.POP = new n(this);
    this.Qgj = new WebViewLongClickHelper(this);
    this.QgL = true;
    this.Qfy = getIntent().getIntExtra("geta8key_session_id", com.tencent.mm.modelsimple.l.boo());
    this.Qfz = getIntent().getByteArrayExtra("geta8key_cookie");
    this.PJe = getIntent().getIntExtra("screen_orientation", -1);
    this.Qfx = getIntent().getBooleanExtra("from_shortcut", false);
    this.Qfs = getIntent().getIntExtra(f.r.VSO, -1);
    this.CTz = getIntent().getStringExtra("status_bar_style");
    this.CTy = getIntent().getIntExtra("customize_status_bar_color", 0);
    this.QfX = getIntent().getBooleanExtra("show_native_web_view", false);
    this.mActionBar = getSupportActionBar();
    this.Cwk = findViewById(c.f.action_bar_container);
    if ((this.Cwk == null) || (!com.tencent.mm.ui.statusbar.c.XMC)) {}
    for (;;)
    {
      this.Qgr = new i(this);
      Object localObject1;
      label277:
      boolean bool;
      label418:
      label616:
      label748:
      int i;
      label527:
      label709:
      Object localObject3;
      label779:
      int j;
      if (this.Qgr.QcC.PQp)
      {
        localObject1 = this.Qgr;
        if (((i)localObject1).QcC.PQq)
        {
          ((i)localObject1).QcD.setActionbarColor(com.tencent.mm.ci.a.w((Context)((i)localObject1).QcD, c.c.transparent));
          com.tencent.mm.plugin.webview.k.p.l(cDu(), this);
          this.Qfm = cDu();
          this.QfX = getIntent().getBooleanExtra("show_native_web_view", false);
          this.Qfl = getIntent().getBooleanExtra("key_trust_url", false);
          Qgb += 1;
          Log.i("MicroMsg.WebViewUI", "initView trust:%b, rawUrl = %s ", new Object[] { Boolean.valueOf(this.Qfl), cDu() });
          this.fUj = Util.nullAsNil(getIntent().getStringExtra("KPublisherId"));
          this.handler = new MMHandler();
          if ((this.PIx == null) || (!this.PIx.aK(getIntent().getBundleExtra("mm_report_bundle")))) {
            break label2124;
          }
          bool = true;
          this.Qfq = bool;
          localObject1 = getIntent().getBundleExtra("close_window_confirm_info");
          if (localObject1 != null) {
            this.QfQ = a.aZ((Bundle)localObject1);
          }
          getWindow().setFlags(16777216, 16777216);
          getWindow().setFormat(-3);
          ab.a.jt(this);
          this.Qgh.bU("onWebViewCreateStart", System.currentTimeMillis());
          if (!com.tencent.mm.plugin.webview.k.p.bno(cDu())) {
            break label2129;
          }
          this.pHS = MMWebView.a.lG(this);
          com.tencent.xweb.util.h.Xg(173L);
          if (this.pHS == null) {
            this.pHS = cDU();
          }
          WebViewLongClickHelper.d(this.pHS);
          this.Qgh.bU("onWebViewCreateEnd", System.currentTimeMillis());
          this.pHS.YcA = this;
          this.Qgn = new com.tencent.mm.plugin.webview.r();
          initView();
          this.PIQ = cDV();
          if (this.PIQ.PHI == null) {
            break label2140;
          }
          this.PHI = this.PIQ.PHI;
          localObject1 = this.PHI;
          ((p)localObject1).QcD = this;
          ((p)localObject1).onCreate();
          this.PvJ = this.PIQ.getJsapi();
          this.pGD = this.PIQ.pGD;
          if (com.tencent.mm.plugin.webview.ui.tools.floatball.d.gZN()) {
            getIntent().putExtra("webviewCurrentProcess", MMApplicationContext.getProcessName());
          }
          if (this.PvJ != null) {
            this.PvJ.CR(false);
          }
          if (this.PIQ.PHH == null) {
            break label2224;
          }
          this.Qgk = this.PIQ.PHH;
          this.Qgk.PXH = new WeakReference(this);
          if (this.PIQ.PHJ == null) {
            break label2357;
          }
          this.PHJ.aD(MMApplicationContext.getContext());
          this.PHJ = this.PIQ.PHJ;
          this.PHJ.aD(this);
          if (!this.QfL) {
            break label2371;
          }
          this.PIQ.gSw();
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(80114);
              WebViewUI.this.PIQ.a(WebViewUI.this.QgS);
              WebViewUI.d(WebViewUI.this);
              AppMethodBeat.o(80114);
            }
          });
          this.akm = ((AccessibilityManager)MMApplicationContext.getContext().getSystemService("accessibility"));
          this.Qfv = new AccessibilityManager.AccessibilityStateChangeListener()
          {
            public final void onAccessibilityStateChanged(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(266470);
              if ((WebViewUI.this.pGD != null) && (WebViewUI.this.pGD.gWI() != null) && (WebViewUI.this.pGD.gWI().so(413)))
              {
                HashMap localHashMap = new HashMap();
                localHashMap.put("isAccessibilityMode", Boolean.valueOf(paramAnonymousBoolean));
                WebViewUI.this.PIQ.getJsapi().P("onAccessibilityStateChange", localHashMap);
              }
              AppMethodBeat.o(266470);
            }
          };
          this.akm.addAccessibilityStateChangeListener(this.Qfv);
          if (this.PIx != this.PIQ.PIx)
          {
            this.PIx = this.PIQ.PIx;
            this.PIx.aK(getIntent().getBundleExtra("mm_report_bundle"));
          }
          localObject1 = this.PIx.gVV();
          i = this.PIQ.bXC();
          localObject3 = this.fUj;
          ((ba.m)localObject1).gco = i;
          ((ba.m)localObject1).PWC = ((String)localObject3);
          QfC.add(new e(this));
          if (QfC.size() > 1)
          {
            localObject1 = QfC;
            localObject1 = (e)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 2);
            if ((((e)localObject1).qHe != null) && (((e)localObject1).qHe.get() != null)) {
              ((WebViewUI)((e)localObject1).qHe.get()).CT(false);
            }
          }
          bkl("onCreate");
          j = getIntent().getIntExtra("from_scence", 0);
          this.Qfr = getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
          localObject1 = this.Qgh;
          i = this.Qfr;
          if (i == -1) {
            break label2385;
          }
          ((com.tencent.mm.plugin.webview.k.n)localObject1).Qfr = i;
          Log.d("MicroMsg.WebViewUI", " onCreate fromScene %d", new Object[] { Integer.valueOf(j) });
          this.sessionId = com.tencent.mm.model.ad.Rp(String.valueOf(this.PIQ.gSo()));
          Log.i("MicroMsg.WebViewUI", " onCreate sessionId %s", new Object[] { this.sessionId });
          localObject1 = this.PIx.gWb();
          i = this.PIQ.bXC();
          localObject3 = this.fUj;
          ((ba.g)localObject1).gco = i;
          ((ba.g)localObject1).PWC = ((String)localObject3);
          ((ba.g)localObject1).url = cDu();
          localObject3 = this.PIx.gWh();
          localObject1 = cDu();
          Log.i("MicroMsg.WebviewReporter.DomainReporter", "setRawUrl, value = %s", new Object[] { localObject1 });
        }
      }
      try
      {
        localObject4 = Uri.parse((String)localObject1);
        if ((((Uri)localObject4).getScheme() != null) && (!((Uri)localObject4).getScheme().toLowerCase().startsWith("http")))
        {
          Log.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl scheme is not http/https, skip, scheme = %s", new Object[] { ((Uri)localObject4).getScheme() });
          localObject1 = this.PIx.gWj();
          localObject3 = getIntent();
          kotlin.g.b.p.k(localObject3, "intent");
        }
      }
      catch (Exception localException3)
      {
        try
        {
          localObject3 = ((Intent)localObject3).getBundleExtra("jsapiargs");
          if (localObject3 != null)
          {
            localObject3 = ((Bundle)localObject3).getByteArray("key_webview_secret_msg_info");
            if (localObject3 != null)
            {
              localObject4 = new fkz();
              ((fkz)localObject4).parseFrom((byte[])localObject3);
              ((as)localObject1).PVI = ((fkz)localObject4);
            }
          }
          localObject1 = this.PIx.gWj();
          localObject3 = ((as)localObject1).PVI;
          if (localObject3 != null) {
            ((fkz)localObject3).opType = 2;
          }
          as.a.a(((as)localObject1).PVI);
        }
        catch (Exception localException3)
        {
          try
          {
            this.QgD = getContentView();
            if (this.QgD != null)
            {
              gYx();
              ((ViewGroup)((ViewGroup)getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
              {
                public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
                {
                  AppMethodBeat.i(257191);
                  WebViewUI.this.gYx();
                  AppMethodBeat.o(257191);
                }
              });
            }
          }
          catch (Exception localException3)
          {
            try
            {
              for (;;)
              {
                if ((this.Qgr != null) && (!this.Qgr.QcC.PQp) && (gYA())) {
                  gYD();
                }
                this.Qfg = new com.tencent.mm.br.a(getContext(), this.QgE);
                com.tencent.mm.plugin.webview.a.a.am(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(237776);
                    com.tencent.mm.cl.g.htS();
                    com.tencent.mm.cl.b.htF();
                    AppMethodBeat.o(237776);
                  }
                });
                this.Qgm = new WebViewClipBoardHelper(this);
                this.Qgw.alive();
                this.QfJ.alive();
                if (this.PHI != null)
                {
                  localObject1 = this.PHI;
                  if (((p)localObject1).QcD != null)
                  {
                    ((p)localObject1).pHO = ((p)localObject1).QcD.elY();
                    ((p)localObject1).webView = ((p)localObject1).QcD.pHS;
                    ((p)localObject1).Qhm = new WebViewTransHelper((p)localObject1);
                    Log.i("MicroMsg.WebViewUIStyleHelper", "init transHelper");
                    if (((p)localObject1).Qhm.gSf())
                    {
                      ((p)localObject1).QcD.getLifecycle().a(((p)localObject1).Qhm);
                      localObject3 = new WebViewTransHelper.b(new WeakReference(((p)localObject1).Qhm));
                      ((p)localObject1).QcD.PIQ.a((com.tencent.mm.plugin.webview.core.f)localObject3);
                      localObject3 = ((p)localObject1).QcD.PIQ.PHL;
                      if ((localObject3 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.webview.j)localObject3).PEl))) {
                        break label2585;
                      }
                      ((p)localObject1).Qhm.bjk(Util.getRandomString(32));
                      if ((localObject3 != null) && (((com.tencent.mm.plugin.webview.j)localObject3).PEm != com.tencent.mm.plugin.webview.n.PEQ))
                      {
                        ((p)localObject1).Qhm.PFc.setValue(((com.tencent.mm.plugin.webview.j)localObject3).PEm);
                        ((p)localObject1).webView.reload();
                      }
                    }
                    if (!((p)localObject1).Qhl) {
                      break label2601;
                    }
                    Log.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle true");
                  }
                }
                aH(getWindow().getDecorView(), 256);
                ba.TB(getIntent().getLongExtra("start_activity_time", 0L));
                this.Qgu = getIntent().getBooleanExtra(f.r.VSX, false);
                if (((this.Qgu) || (gYw())) && (this.pHS != null)) {
                  this.pHS.getSettings().setForceDarkBehavior(1);
                }
                localObject1 = getIntent().getStringExtra("key_first_tips");
                localObject3 = getIntent().getStringExtra("key_first_tips_title");
                if (!Util.isNullOrNil((String)localObject1)) {
                  com.tencent.mm.ui.base.h.a(getContext(), (String)localObject1, (String)localObject3, getString(c.i.app_i_known), false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
                  });
                }
                AppMethodBeat.o(80247);
                return;
                localObject1 = com.tencent.mm.ui.statusbar.c.bA(this);
                localObject3 = new com.tencent.mm.ui.statusbar.c.a()
                {
                  public final void BF(int paramAnonymousInt)
                  {
                    AppMethodBeat.i(232943);
                    WebViewUI.c(WebViewUI.this).setPadding(0, paramAnonymousInt, 0, 0);
                    AppMethodBeat.o(232943);
                  }
                };
                this.Cwl = ((com.tencent.mm.ui.statusbar.c.a)localObject3);
                ((com.tencent.mm.ui.statusbar.c)localObject1).a((com.tencent.mm.ui.statusbar.c.a)localObject3);
                getWindow().getDecorView().requestApplyInsets();
                com.tencent.mm.ui.statusbar.d.e(getWindow());
                break;
                ((i)localObject1).QcD.setActionbarColor(com.tencent.mm.ci.a.w((Context)((i)localObject1).QcD, c.c.white_transparent_color));
                break label277;
                if (getIntent() == null)
                {
                  localObject1 = "";
                  label1927:
                  if (getIntent() != null) {
                    break label2075;
                  }
                  bool = false;
                  label1936:
                  Log.i("MicroMsg.WebViewUI", "initCustomActionBarColorIfNeed isNativeStyle is %b", new Object[] { Boolean.valueOf(bool) });
                  if (!bool) {
                    break label2105;
                  }
                  if (!com.tencent.mm.ui.ar.isDarkMode()) {
                    break label2090;
                  }
                  localObject1 = "black";
                  aoC(c.c.BG_2);
                }
                for (;;)
                {
                  try
                  {
                    i = Color.parseColor((String)localObject1);
                    localObject1 = Integer.valueOf(i);
                  }
                  catch (Exception localException1)
                  {
                    label2075:
                    label2090:
                    label2105:
                    localObject2 = null;
                    continue;
                  }
                  if (localObject1 == null) {
                    break;
                  }
                  localObject3 = new Bundle(1);
                  ((Bundle)localObject3).putInt("set_navigation_bar_color_color", ((Integer)localObject1).intValue());
                  ((Bundle)localObject3).putInt("set_navigation_bar_color_alpha", 255);
                  aX((Bundle)localObject3);
                  if (getIntent().hasExtra("customize_status_bar_color")) {
                    break;
                  }
                  this.CTy = ((Integer)localObject1).intValue();
                  break;
                  localObject1 = getIntent().getStringExtra("custom_action_bar_color");
                  break label1927;
                  bool = getIntent().getBooleanExtra("open_custom_style_url", false);
                  break label1936;
                  localObject1 = "white";
                  aoC(-16777216);
                  continue;
                  if (Util.isNullOrNil((String)localObject1)) {
                    break;
                  }
                }
                label2124:
                bool = false;
                break label418;
                label2129:
                this.pHS = cDU();
                break label527;
                label2140:
                this.PHI = new p(this);
                Object localObject2 = this.PHI;
                if (((p)localObject2).QcD == null) {
                  break label616;
                }
                if (((p)localObject2).gZo()) {}
                for (((p)localObject2).Qhl = true;; ((p)localObject2).Qhl = false)
                {
                  Log.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleParams, webViewUI#%s, disableLightActionbarStyle:%b", new Object[] { ((p)localObject2).QcD, Boolean.valueOf(((p)localObject2).Qhl) });
                  break;
                }
                label2224:
                this.Qgk = new k(this);
                this.PIQ.PHH = this.Qgk;
                this.Qgk.gXS();
                localObject2 = this.Qgk;
                if ((((k)localObject2).gXq() instanceof GameWebViewUI))
                {
                  ((k)localObject2).QdD.add(Integer.valueOf(11));
                  ((k)localObject2).QdD.add(Integer.valueOf(28));
                  break label709;
                }
                ((k)localObject2).QdD.add(Integer.valueOf(7));
                ((k)localObject2).QdD.add(Integer.valueOf(11));
                ((k)localObject2).QdD.add(Integer.valueOf(28));
                break label709;
                label2357:
                this.PIQ.PHJ = this.PHJ;
                break label748;
                label2371:
                this.PIQ.bj(getIntent());
                break label779;
                switch (j)
                {
                default: 
                  label2385:
                  i = 999;
                }
                for (;;)
                {
                  ((com.tencent.mm.plugin.webview.k.n)localObject2).Qfr = i;
                  break;
                  i = 1;
                  continue;
                  i = 2;
                }
                Object localObject4 = ((Uri)localObject4).getHost();
                if ((localObject4 == null) || (((String)localObject4).toLowerCase().endsWith(".qq.com")))
                {
                  Log.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl, host is .qq.com, skip, host = %s", new Object[] { localObject4 });
                  continue;
                  localException5 = localException5;
                  Log.e("MicroMsg.WebviewReporter.DomainReporter", "parse rawUrl fail, rawUrl = %s", new Object[] { localObject2 });
                }
                else
                {
                  localException5.wNV = true;
                  continue;
                  localException2 = localException2;
                  Log.printErrStackTrace("MicroMsg.WebViewSecretMsgReporter", (Throwable)localException2, "alvinluo initWebViewSecretMsgReporter exception", new Object[0]);
                  continue;
                  localException3 = localException3;
                  Log.e("MicroMsg.WebViewUI", "fixContentMargin error : %s", new Object[] { localException3.getMessage() });
                }
              }
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                Log.e("MicroMsg.WebViewUI", "tryToExpandToStatusBar error : %s", new Object[] { localException4.getMessage() });
                continue;
                label2585:
                localException4.Qhm.bjk(localException5.PEl);
                continue;
                label2601:
                Log.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle false");
                localException4.gZp();
              }
            }
          }
        }
      }
    }
  }
  
  protected MMWebView cDU()
  {
    AppMethodBeat.i(80260);
    if (com.tencent.mm.plugin.webview.ui.tools.floatball.d.gZN())
    {
      localObject1 = getIntent().getStringExtra("float_ball_key");
      if (!Util.isNullOrNil((String)localObject1))
      {
        Object localObject2 = com.tencent.mm.plugin.webview.ui.tools.floatball.d.Qkh;
        localObject2 = com.tencent.mm.plugin.webview.ui.tools.floatball.d.bmB((String)localObject1);
        if (localObject2 != null)
        {
          localObject2 = ((BaseWebViewController)localObject2).pHS;
          if ((localObject2 != null) && (!((MMWebView)localObject2).mDestroyed))
          {
            Log.i("MicroMsg.WebViewUI", "createWebView from cache floatBallKey=%s", new Object[] { localObject1 });
            if (((MMWebView)localObject2).getParent() != null)
            {
              ((ViewGroup)((MMWebView)localObject2).getParent()).removeView((View)localObject2);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1553L, 21L, 1L, false);
              Log.w("MicroMsg.WebViewUI", "createWebView wv has parent");
            }
            ((MMWebView)localObject2).aD(this);
            ((MMWebView)localObject2).onShow();
            AppMethodBeat.o(80260);
            return localObject2;
          }
        }
      }
      localObject1 = MMWebView.a.lH(new MutableContextWrapper(this));
      AppMethodBeat.o(80260);
      return localObject1;
    }
    Object localObject1 = MMWebView.a.lH(this);
    AppMethodBeat.o(80260);
    return localObject1;
  }
  
  protected com.tencent.mm.plugin.webview.core.i cDV()
  {
    AppMethodBeat.i(219908);
    if (com.tencent.mm.plugin.webview.ui.tools.floatball.d.gZN())
    {
      localObject1 = getIntent().getStringExtra("float_ball_key");
      if (!Util.isNullOrNil((String)localObject1))
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1553L, 1L, 1L, false);
        localObject2 = com.tencent.mm.plugin.webview.ui.tools.floatball.d.Qkh;
        localObject2 = com.tencent.mm.plugin.webview.ui.tools.floatball.d.bmB((String)localObject1);
        if ((localObject2 != null) && (((BaseWebViewController)localObject2).pHS != null) && (!((BaseWebViewController)localObject2).pHS.mDestroyed))
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1553L, 2L, 1L, false);
          this.QfL = true;
          Log.i("MicroMsg.WebViewUI", "createWebViewController from cache floatBallKey=%s", new Object[] { localObject1 });
          AppMethodBeat.o(219908);
          return localObject2;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1553L, 3L, 1L, false);
      }
    }
    Object localObject1 = this.pHS;
    Object localObject2 = this.PIx;
    BaseWebViewController.g localg = new BaseWebViewController.g(getIntent());
    boolean bool2 = getIntent().getBooleanExtra("key_trust_url", false);
    boolean bool3 = gZe();
    if ((!gYZ()) && (!gZa())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = new com.tencent.mm.plugin.webview.core.i((MMWebView)localObject1, (ba)localObject2, new BaseWebViewController.d(localg, bool2, bool3, bool1, getIntent().getBooleanExtra("neverGetA8Key", false)));
      if (!this.QfL) {
        ((com.tencent.mm.plugin.webview.core.i)localObject1).a(this.QgS);
      }
      ((com.tencent.mm.plugin.webview.core.i)localObject1).init();
      AppMethodBeat.o(219908);
      return localObject1;
    }
  }
  
  public boolean cDW()
  {
    return false;
  }
  
  protected boolean cDX()
  {
    AppMethodBeat.i(80365);
    if ((getClass().equals(WebViewUI.class)) && (!getIntent().getBooleanExtra("disable_minimize", false))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WebViewUI", "enableMinimize class:%s enable:%b", new Object[] { getClass(), Boolean.valueOf(bool) });
      AppMethodBeat.o(80365);
      return bool;
    }
  }
  
  public final String cDu()
  {
    AppMethodBeat.i(80300);
    try
    {
      String str = BaseWebViewController.bk(getIntent());
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
  
  protected final boolean cgP()
  {
    return this.Qfe;
  }
  
  public void cjK()
  {
    int k = 2;
    int m = 1;
    AppMethodBeat.i(80295);
    if ((this.Qgd) || (this.Qgc) || (isFinishing()))
    {
      Log.e("MicroMsg.WebViewUI", "edw postBinded finished");
      AppMethodBeat.o(80295);
      return;
    }
    Object localObject1 = gYS();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.webview.d.i)localObject1).POg = this.PIQ.getJsapi();
    }
    this.pGC = this.PIQ.gSm();
    try
    {
      this.pGC.a(this.POP, this.PIQ.gSo());
      Log.i("MicroMsg.WebViewUI", "edw postBinded");
      this.Qgs = new com.tencent.mm.plugin.webview.ui.tools.floatball.b(new com.tencent.mm.plugin.ball.a.e(this), this);
      localObject1 = getIntent().getStringExtra("float_ball_key");
      if (!Util.isNullOrNil((String)localObject1))
      {
        this.Qgs.I(2, (String)localObject1);
        this.Qgs.aoy(cDu());
        this.Qgs.fi("rawUrl", cDu());
        this.Qgs.bko(cDu());
        localObject1 = new com.tencent.mm.plugin.multitask.a.b(this);
        this.Qgt = new com.tencent.mm.plugin.webview.ui.tools.multitask.a((com.tencent.mm.plugin.multitask.a.a)localObject1, this);
        localObject2 = getIntent().getStringExtra("float_ball_key");
        if (Util.isNullOrNil((String)localObject2)) {
          break label1249;
        }
        this.Qgt.I(2, (String)localObject2);
        this.Qgt.setRawUrl(cDu());
        if (com.tencent.mm.plugin.webview.ui.tools.multitask.a.hbx())
        {
          localObject1 = ((com.tencent.mm.plugin.multitask.a.b)localObject1).FFt;
          if (localObject1 == null) {
            break label1281;
          }
          localObject1 = ((com.tencent.mm.plugin.multitask.ui.base.d)localObject1).FJV;
          this.QgU = ((MMWebView.b)localObject1);
        }
        if (this.Qgs != null) {
          this.Qgs.bNV();
        }
        if (this.Qgt != null) {
          this.Qgt.bNV();
        }
        if (this.Qgq == null) {
          break label1287;
        }
        i = 1;
        if (this.Qgq == null) {
          this.Qgq = new HandOffURL(cDu(), cDu(), "");
        }
        if ((!com.tencent.mm.ui.ar.isMultiTaskMode()) || (this.Qgt == null)) {
          break label1292;
        }
        localObject1 = this.Qgt.FHd;
        if (localObject1 != null)
        {
          localObject2 = ((MultiTaskInfo)localObject1).fbc().title;
          if (!Util.isNullOrNil((String)localObject2)) {
            this.Qgq.setTitle((String)localObject2);
          }
          this.Qgq.setIcon(Util.nullAsNil(((MultiTaskInfo)localObject1).fbc().TIg));
        }
        if (gUC())
        {
          if (i == 0) {
            break label1355;
          }
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Qgq);
          Log.i("MicroMsg.WebViewUI", "[Handoff] onPostBinded, exist:true, call upsert " + this.Qgq.toString());
        }
        bmm(cDu());
        localObject1 = gYm();
        localObject2 = this.pGC;
      }
    }
    catch (RemoteException localException4)
    {
      try
      {
        str = ((com.tencent.mm.plugin.webview.stub.e)localObject2).blQ("DNSAdvanceOpen");
        Log.i("MicroMsg.DNSPreGetOptimize", "switch open value : %s", new Object[] { str });
        if (Util.isNullOrNil(str))
        {
          Log.e("MicroMsg.DNSPreGetOptimize", "get switch value is null or nil");
          bool = false;
          if (bool) {
            break label1432;
          }
          Log.i("MicroMsg.DNSPreGetOptimize", "server closed the switch");
          if (gYT()) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80079);
                if (WebViewUI.this.pHS != null) {
                  WebViewUI.this.pHS.getCurWebviewClient().b(WebViewUI.this.pHS, WebViewUI.this.pHS.getUrl());
                }
                AppMethodBeat.o(80079);
              }
            });
          }
          localObject1 = this.PIQ.getTitle();
          bmk((String)localObject1);
          bml((String)localObject1);
        }
      }
      catch (Exception localException4)
      {
        try
        {
          localObject1 = gYE();
          if ((localObject1 != null) && (this.Qgq != null))
          {
            this.Qgq.setTitle(Util.nullAsNil(((p.b)localObject1).title));
            this.Qgq.setIcon(Util.nullAsNil(((p.b)localObject1).QhG));
            this.Qgq.setNickname(Util.nullAsNil(((p.b)localObject1).QhF));
            if (gUC()) {
              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Qgq);
            }
          }
        }
        catch (Exception localException4)
        {
          try
          {
            i = Util.getInt(this.pGC.blQ("WebviewDisableX5Logo"), 0);
            bool = getIntent().getBooleanExtra("disable_bounce_scroll", false);
            Log.i("MicroMsg.WebViewUI", "getting flag of x5 logo state, disableX5Logo = %d, disableBounceScroll = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
            if ((i == 1) || (bool)) {
              this.QgG.Dc(true);
            }
            if (getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_disable_over_scroll", false)) {
              this.QgG.Dc(true);
            }
            this.Qgh.bU("onJSAPIEnd", System.currentTimeMillis());
            if ((this.pHS != null) && (this.pHS.getIsX5Kernel()))
            {
              bool = true;
              ba.bg(bool, Util.nullAsNil(cDu()).startsWith("https://"));
            }
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                j = Util.getInt(this.pGC.blQ("XwebBatchTranslateMaxByteLength"), 0);
                i = Util.getInt(this.pGC.blQ("XwebBatchTranslateMaxCnt"), 0);
                Log.i("MicroMsg.WebViewUI", "getting flag of XwebBatchTranslate para BatchTranslateMaxByteLength  = " + j + " BatchTranslateCnt = " + i);
                localObject1 = this.Qgn;
                ((com.tencent.mm.plugin.webview.r)localObject1).PFu = j;
                ((com.tencent.mm.plugin.webview.r)localObject1).PFv = i;
                if (getIntent().getBooleanExtra("translate_webview", false))
                {
                  localObject1 = this.Qgn;
                  localObject2 = this.pHS;
                  str = cDu();
                  if ((localObject2 != null) && (!((WebView)localObject2).isSysKernel())) {
                    break;
                  }
                }
                Df(gYR());
                this.QeZ = LayoutInflater.from(this).inflate(c.g.web_view_font_chooser, null);
                localObject1 = (FontChooserView)this.QeZ.findViewById(c.f.font_chooser_view);
                localObject2 = this.QeZ.findViewById(c.f.font_chooser_close);
                if ((this.pHS == null) || (!this.pHS.getIsX5Kernel())) {
                  break label1748;
                }
                i = m;
                if (i == 0)
                {
                  ((View)localObject2).setVisibility(0);
                  ((View)localObject2).setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(80093);
                      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                      localb.bn(paramAnonymousView);
                      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                      paramAnonymousView = AnimationUtils.loadAnimation(WebViewUI.this, com.tencent.mm.plugin.webview.c.a.font_fade_out);
                      paramAnonymousView.setAnimationListener(new Animation.AnimationListener()
                      {
                        public final void onAnimationEnd(Animation paramAnonymous2Animation)
                        {
                          AppMethodBeat.i(268383);
                          WebViewUI.this.QeZ.setVisibility(8);
                          AppMethodBeat.o(268383);
                        }
                        
                        public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                        
                        public final void onAnimationStart(Animation paramAnonymous2Animation) {}
                      });
                      WebViewUI.this.QeZ.startAnimation(paramAnonymousView);
                      WebViewUI.this.QeZ.setVisibility(8);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(80093);
                    }
                  });
                }
                ((FontChooserView)localObject1).setOnChangeListener(new d((byte)0));
                localObject2 = new FrameLayout.LayoutParams(-1, -2, 80);
                this.QeZ.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                this.Qfb.addView(this.QeZ);
                this.QeZ.setVisibility(8);
                try
                {
                  if (!this.pGC.gWY()) {
                    break label1801;
                  }
                  if ((!gYZ()) && (!gZa())) {
                    break label1753;
                  }
                  i = com.tencent.mm.plugin.webview.k.i.jg(getContext());
                }
                catch (Exception localException7)
                {
                  for (;;)
                  {
                    label1249:
                    BallInfo localBallInfo;
                    label1281:
                    label1287:
                    label1292:
                    label1355:
                    label1484:
                    Bundle localBundle;
                    label1432:
                    Log.w("MicroMsg.WebViewUI", "initFontChooserView, ex = " + localException7.getMessage());
                    i = 2;
                    continue;
                    j = i;
                  }
                }
                j = k;
                if (i > 0)
                {
                  if (i <= 8) {
                    break label1806;
                  }
                  j = k;
                }
                ((FontChooserView)localObject1).setSliderIndex(j - 1);
                this.PIQ.any(j);
                aoF(j);
                AppMethodBeat.o(80295);
                return;
                localRemoteException = localRemoteException;
                Log.printErrStackTrace("MicroMsg.WebViewUI", localRemoteException, "addCallbacker", new Object[0]);
                continue;
                this.Qgs.I(2, com.tencent.mm.plugin.ball.f.b.aoB(cDu()));
                continue;
                this.Qgt.I(2, com.tencent.mm.plugin.multitask.g.aQU(((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apf(cDu())));
                continue;
                localBallInfo = null;
                continue;
                i = 0;
                continue;
                if (this.Qgs != null)
                {
                  localBallInfo = this.Qgs.cvy();
                  if (localBallInfo != null)
                  {
                    localObject2 = localBallInfo.name;
                    if (!Util.isNullOrNil((String)localObject2)) {
                      this.Qgq.setTitle((String)localObject2);
                    }
                    this.Qgq.setIcon(Util.nullAsNil(localBallInfo.icon));
                    continue;
                    ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).a(this.Qgq);
                    Log.i("MicroMsg.WebViewUI", "[Handoff] onPostBinded, exist:false, call onWebViewCreate " + this.Qgq.toString());
                    continue;
                    bool = str.equalsIgnoreCase("1");
                    continue;
                    localException1 = localException1;
                    Log.e("MicroMsg.DNSPreGetOptimize", "get dns pre get switch failed");
                    continue;
                    try
                    {
                      localObject2 = ((com.tencent.mm.plugin.webview.stub.e)localObject2).blQ("DNSAdvanceRelateDomain");
                      if (!Util.isNullOrNil((String)localObject2)) {
                        break label1484;
                      }
                      Log.e("MicroMsg.DNSPreGetOptimize", "domain list is null, just return");
                    }
                    catch (Exception localException2)
                    {
                      Log.printErrStackTrace("MicroMsg.DNSPreGetOptimize", localException2, "", new Object[0]);
                    }
                    continue;
                    com.tencent.mm.plugin.webview.a.a.am(new com.tencent.mm.plugin.webview.model.b.1(localException2, (String)localObject2));
                    continue;
                    localException3 = localException3;
                    Log.printErrStackTrace("MicroMsg.WebViewUI", localException3, "fillMpInfoToHandOff fail", new Object[0]);
                    continue;
                    localException4 = localException4;
                    Log.w("MicroMsg.WebViewUI", "getting flag of x5 logo state failed, ex = " + localException4.getMessage());
                    i = 0;
                  }
                }
              }
              boolean bool = false;
            }
            catch (Exception localException5)
            {
              for (;;)
              {
                Object localObject2;
                String str;
                Log.w("MicroMsg.WebViewUI", "getting flag of XwebBatchTranslate para failid, ex = " + localException5.getMessage());
                i = 0;
                j = 0;
                continue;
                localBundle = new Bundle();
                localBundle.putString("destLanguage", LocaleUtil.getApplicationLanguage());
                localBundle.putString("url", str);
                localBundle.putString("translateTips", getString(c.i.webview_menu_tranlate_tips));
                localBundle.putString("translateFinish", getString(c.i.webview_menu_tranlate_finish));
                localBundle.putString("errorWording", getString(c.i.webview_menu_tranlate_fail));
                localException5.PFs = getString(c.i.webview_menu_tranlate_tips);
                localException5.PFt = getString(c.i.webview_menu_tranlate_tips_brand);
                EventCenter.instance.addListener(localException5.PFx);
                try
                {
                  ((WebView)localObject2).invokeMiscMethod("translateWebSite", localBundle);
                }
                catch (Exception localException6)
                {
                  Log.e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", new Object[] { localException6.getMessage() });
                }
                continue;
                label1748:
                i = 0;
                continue;
                label1753:
                i = com.tencent.mm.plugin.webview.k.i.a(getContext(), this.pGC, cDu());
              }
            }
          }
        }
      }
    }
  }
  
  protected int cjL()
  {
    AppMethodBeat.i(80254);
    int i = getActionbarColor();
    AppMethodBeat.o(80254);
    return i;
  }
  
  protected boolean cjM()
  {
    return false;
  }
  
  public boolean convertActivityFromTranslucent()
  {
    AppMethodBeat.i(80236);
    Intent localIntent = getIntent();
    Object localObject = com.tencent.mm.plugin.webview.core.g.PHD;
    localObject = com.tencent.mm.plugin.webview.core.g.gSH();
    com.tencent.mm.plugin.webview.core.g.a locala = com.tencent.mm.plugin.webview.core.g.PHD;
    if (!((Boolean)((kotlin.f)localObject).getValue()).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      bool = localIntent.getBooleanExtra("convertActivityFromTranslucent", bool);
      AppMethodBeat.o(80236);
      return bool;
    }
  }
  
  public final void cxg()
  {
    AppMethodBeat.i(80302);
    this.Qgk.cxg();
    AppMethodBeat.o(80302);
  }
  
  public final void d(com.tencent.luggage.xweb_ext.extendplugin.a.a parama)
  {
    AppMethodBeat.i(219849);
    this.PHJ.d(parama);
    AppMethodBeat.o(219849);
  }
  
  public final void d(final Callable<Void> paramCallable)
  {
    AppMethodBeat.i(219791);
    if (com.tencent.mm.kernel.h.aHB()) {
      com.tencent.mm.kernel.h.aHE();
    }
    for (Object localObject = com.tencent.mm.kernel.b.aGq(); Util.isNullOrNil((String)localObject); localObject = "MMWebViewTransShouldPullHalfScreenNotice")
    {
      Log.e("MicroMsg.WebViewUI", "kvName is null");
      AppMethodBeat.o(219791);
      return;
    }
    MultiProcessMMKV.getSingleMMKV((String)localObject).encode("MMWebViewTransHasPullBefore", true);
    localObject = new com.tencent.mm.ui.widget.a.g(getContext(), 2, 2);
    ((com.tencent.mm.ui.widget.a.g)localObject).aT(getResources().getString(c.i.webview_menu_tranlate_security_title));
    ((com.tencent.mm.ui.widget.a.g)localObject).ah(getResources().getString(c.i.app_i_known));
    ((com.tencent.mm.ui.widget.a.g)localObject).ayu(1);
    TextView localTextView = new TextView(getContext());
    localTextView.setTextColor(getResources().getColor(c.c.FG_0));
    localTextView.setText(getResources().getString(c.i.webview_menu_tranlate_security_tips));
    ((com.tencent.mm.ui.widget.a.g)localObject).YnF = new com.tencent.mm.ui.widget.a.g.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(224051);
        try
        {
          Log.i("MicroMsg.WebViewUI", "notice button clicked!");
          paramCallable.call();
          this.ujg.bYF();
          AppMethodBeat.o(224051);
          return;
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(224051);
        }
      }
    };
    Log.i("MicroMsg.WebViewUI", "show trans notice");
    ((com.tencent.mm.ui.widget.a.g)localObject).setCustomView(localTextView);
    ((com.tencent.mm.ui.widget.a.g)localObject).eik();
    AppMethodBeat.o(219791);
  }
  
  public final String elY()
  {
    AppMethodBeat.i(80259);
    if ((this.PIQ == null) || (Util.isNullOrNil(this.PIQ.getCurrentUrl())))
    {
      str = cDu();
      AppMethodBeat.o(80259);
      return str;
    }
    String str = this.PIQ.getCurrentUrl();
    AppMethodBeat.o(80259);
    return str;
  }
  
  public void finish()
  {
    int i = 1;
    AppMethodBeat.i(80235);
    Log.i("MicroMsg.WebViewUI", "Call finish");
    hideVKB();
    if (this.Qft) {
      setResult(-1);
    }
    if (this.handler != null) {
      this.handler.removeCallbacksAndMessages(null);
    }
    this.Qgd = true;
    if ((com.tencent.mm.plugin.webview.ui.tools.floatball.d.gZN()) && (this.pGC != null) && (this.Qgt != null) && (this.Qgt.faQ())) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.PIQ != null)
      {
        com.tencent.mm.plugin.webview.core.i locali = this.PIQ;
        locali.CM(bool);
        locali.PFR = true;
      }
      if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.d.c.class) != null) {
        ((com.tencent.mm.plugin.appbrand.d.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.d.c.class)).bKQ();
      }
      super.finish();
      if ((this.Qgt != null) && (this.Qgt.faT())) {}
      for (;;)
      {
        if ((com.tencent.mm.ui.ar.hIO()) && (i == 0)) {
          overridePendingTransition(0, MMFragmentActivity.a.WaZ);
        }
        AppMethodBeat.o(80235);
        return;
        i = 0;
      }
    }
  }
  
  public final void gMa()
  {
    AppMethodBeat.i(220204);
    if (this.Qfa != null)
    {
      hideVKB();
      this.Qfa.SG(-2);
    }
    AppMethodBeat.o(220204);
  }
  
  public final int gSo()
  {
    AppMethodBeat.i(292992);
    int i = this.PIQ.gSo();
    AppMethodBeat.o(292992);
    return i;
  }
  
  public final com.tencent.mm.plugin.webview.d.b.a gTP()
  {
    AppMethodBeat.i(220229);
    if (this.PvJ != null)
    {
      locala = this.PvJ.gTP();
      AppMethodBeat.o(220229);
      return locala;
    }
    com.tencent.mm.plugin.webview.d.b.a locala = new com.tencent.mm.plugin.webview.d.b.a();
    AppMethodBeat.o(220229);
    return locala;
  }
  
  public final boolean gUC()
  {
    AppMethodBeat.i(80364);
    boolean bool = getIntent().getBooleanExtra("KRightBtn", false);
    Log.i("MicroMsg.WebViewUI", "enableMinimize:%b, banRightBtn %b", new Object[] { Boolean.valueOf(cDX()), Boolean.valueOf(bool) });
    if ((!bool) && (gYR()) && (cDX()))
    {
      AppMethodBeat.o(80364);
      return true;
    }
    AppMethodBeat.o(80364);
    return false;
  }
  
  public final boolean gUw()
  {
    AppMethodBeat.i(80354);
    if ((this.QfQ != null) && (this.QfQ.gVc()) && (!Util.isNullOrNil(this.QfQ.gZn())) && (!Util.isNullOrNil(this.QfQ.gVe())) && (!Util.isNullOrNil(this.QfQ.gVf())))
    {
      Object localObject = this.QfQ.gZn();
      String str1 = this.QfQ.gVe();
      String str2 = this.QfQ.gVf();
      Log.i("MicroMsg.WebViewUI", "use js api close window confirm info : %s, %s, %s", new Object[] { localObject, str1, str2 });
      View localView = View.inflate(getContext(), c.g.mm_alert_checkbox, null);
      final CheckBox localCheckBox = (CheckBox)localView.findViewById(c.f.mm_alert_dialog_cb);
      localCheckBox.setChecked(false);
      localCheckBox.setVisibility(8);
      TextView localTextView = (TextView)localView.findViewById(c.f.mm_alert_dialog_info);
      localTextView.setText((CharSequence)localObject);
      localTextView.setTextColor(getResources().getColor(c.c.normal_text_color));
      localObject = (TextView)localView.findViewById(c.f.mm_alert_dialog_cb_txt);
      ((TextView)localObject).setTextColor(getResources().getColor(c.c.normal_text_color));
      ((TextView)localObject).setVisibility(8);
      this.QfR = com.tencent.mm.ui.base.h.a(getContext(), true, "", localView, str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(259999);
          if ((localCheckBox != null) && (localCheckBox.isChecked())) {}
          try
          {
            if (WebViewUI.this.pGC.gWY()) {
              WebViewUI.this.pGC.lE(327792, 1);
            }
            WebViewUI.this.Qgc = true;
            WebViewUI.this.QfR = null;
            m.Qer.close();
            ba.e.cI(WebViewUI.this.elY(), 1);
            if ((WebViewUI.y(WebViewUI.this) != null) && (WebViewUI.y(WebViewUI.this).zH(1)))
            {
              AppMethodBeat.o(259999);
              return;
            }
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            for (;;)
            {
              Log.e("MicroMsg.WebViewUI", "tryShowCloseWindowConfirmInfo, ex = " + paramAnonymousDialogInterface.getMessage());
            }
            WebViewUI.this.finish();
            AppMethodBeat.o(259999);
          }
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          WebViewUI.this.QfR = null;
        }
      });
      AppMethodBeat.o(80354);
      return true;
    }
    AppMethodBeat.o(80354);
    return false;
  }
  
  public final void gWN()
  {
    AppMethodBeat.i(80228);
    if (this.Qgx != null)
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n localn = this.Qgx;
      localn.hide();
      localn.Qxv.setText((CharSequence)"");
    }
    AppMethodBeat.o(80228);
  }
  
  protected void gXB()
  {
    AppMethodBeat.i(80278);
    int i = getIntent().getIntExtra("webview_bg_color_rsID", -1);
    if ((i != -1) && (getContentView() != null))
    {
      setBackGroundColorResource(i);
      getContentView().setBackgroundResource(i);
      this.pHS.setBackgroundResource(17170445);
      this.Qfa.setBackgroundResource(17170445);
      this.Qfb.setBackgroundResource(17170445);
      AppMethodBeat.o(80278);
      return;
    }
    if (getIntent().getBooleanExtra(f.r.VSX, false))
    {
      this.pHS.setBackgroundColor(getResources().getColor(c.c.White));
      AppMethodBeat.o(80278);
      return;
    }
    this.pHS.setBackgroundColor(getResources().getColor(c.c.white));
    AppMethodBeat.o(80278);
  }
  
  public void gXW()
  {
    AppMethodBeat.i(80303);
    this.Qgk.gXW();
    AppMethodBeat.o(80303);
  }
  
  public final void gXY()
  {
    AppMethodBeat.i(80305);
    this.Qgk.gXY();
    AppMethodBeat.o(80305);
  }
  
  protected boolean gYA()
  {
    return true;
  }
  
  protected final int gYB()
  {
    AppMethodBeat.i(219936);
    if ((com.tencent.mm.compatible.util.d.qV(21)) && (gYC()))
    {
      AppMethodBeat.o(219936);
      return -16777216;
    }
    if (com.tencent.mm.ui.ar.isDarkMode())
    {
      AppMethodBeat.o(219936);
      return -1;
    }
    AppMethodBeat.o(219936);
    return -16777216;
  }
  
  protected final void gYD()
  {
    AppMethodBeat.i(80256);
    if ((com.tencent.mm.compatible.util.d.qV(21)) && (this.CTy != 0))
    {
      setActionbarColor(this.CTy);
      AppMethodBeat.o(80256);
      return;
    }
    setStatusBarColor(cjL());
    AppMethodBeat.o(80256);
  }
  
  public final p.b gYE()
  {
    AppMethodBeat.i(219939);
    if (this.PHI == null)
    {
      AppMethodBeat.o(219939);
      return null;
    }
    p.b localb = p.bmu(elY());
    AppMethodBeat.o(219939);
    return localb;
  }
  
  public final String gYF()
  {
    return this.PIQ.PHT;
  }
  
  public final void gYH()
  {
    AppMethodBeat.i(80272);
    Log.i("MicroMsg.WebViewUI", "forceQuit");
    try
    {
      this.QgG.release();
      this.pHS.stopLoading();
      this.pHS.removeAllViews();
      this.pHS.clearView();
      if (this.PvJ != null) {
        this.PvJ.detach();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        this.pHS.destroy();
        finish();
        Log.appenderFlush();
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI", "forceQuit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI", "forceQuit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(80272);
        return;
        localException1 = localException1;
        Log.e("MicroMsg.WebViewUI", "forceQuit, ex = " + localException1.getMessage());
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.w("MicroMsg.WebViewUI", "forceQuit, viewWV destroy, ex = %s", new Object[] { localException2.getMessage() });
        }
      }
    }
  }
  
  protected void gYI()
  {
    AppMethodBeat.i(80275);
    this.Qfp = System.currentTimeMillis();
    this.pHS.goBack();
    m localm = m.Qer;
    Log.v("MicroMsg.WebViewReportUtil", "goBack traceid %s", new Object[] { localm.traceid });
    if (!Util.isNullOrNil(localm.traceid)) {
      localm.rE(5);
    }
    AppMethodBeat.o(80275);
  }
  
  protected final void gYJ()
  {
    AppMethodBeat.i(220039);
    if (this.Qfh == null)
    {
      AppMethodBeat.o(220039);
      return;
    }
    this.Qfh.hide();
    AppMethodBeat.o(220039);
  }
  
  protected int gYK()
  {
    AppMethodBeat.i(80277);
    if (this.Qfh == null)
    {
      AppMethodBeat.o(80277);
      return 0;
    }
    WebViewRedesignInputFooter localWebViewRedesignInputFooter = this.Qfh;
    localWebViewRedesignInputFooter.setVisibility(0);
    if (localWebViewRedesignInputFooter.QyZ != null) {
      localWebViewRedesignInputFooter.QyZ.setVisibility(8);
    }
    localWebViewRedesignInputFooter.Qza = true;
    localWebViewRedesignInputFooter.state = 1;
    int i = localWebViewRedesignInputFooter.gYK();
    AppMethodBeat.o(80277);
    return i;
  }
  
  protected void gYL()
  {
    AppMethodBeat.i(80279);
    if (getIntent() == null)
    {
      AppMethodBeat.o(80279);
      return;
    }
    if (getIntent().hasExtra("show_full_screen")) {
      bh(getIntent().getBooleanExtra("show_full_screen", false), true);
    }
    AppMethodBeat.o(80279);
  }
  
  public final boolean gYM()
  {
    AppMethodBeat.i(220058);
    if ((this.Qfe) || (this.PHJ.bUK()) || ((this.Qgz != null) && (this.Qgz.bUK())))
    {
      AppMethodBeat.o(220058);
      return true;
    }
    AppMethodBeat.o(220058);
    return false;
  }
  
  protected com.tencent.xweb.x gYN()
  {
    try
    {
      AppMethodBeat.i(80286);
      if (this.QfF == null) {
        this.QfF = new MMWebView.c(new b());
      }
      com.tencent.xweb.x localx = this.QfF;
      AppMethodBeat.o(80286);
      return localx;
    }
    finally {}
  }
  
  protected int gYO()
  {
    AppMethodBeat.i(80287);
    if (this.QfX)
    {
      i = c.h.actionbar_icon_dark_back;
      AppMethodBeat.o(80287);
      return i;
    }
    int i = c.h.actionbar_icon_dark_close;
    AppMethodBeat.o(80287);
    return i;
  }
  
  protected boolean gYP()
  {
    return true;
  }
  
  public final void gYQ()
  {
    AppMethodBeat.i(175800);
    View localView = this.pHS.getView();
    localView.scrollTo(localView.getScrollX(), 0);
    this.PIx.gWd().D(new Object[] { cDu(), Integer.valueOf(7) }).report();
    AppMethodBeat.o(175800);
  }
  
  protected com.tencent.mm.plugin.webview.d.i gYS()
  {
    return null;
  }
  
  protected boolean gYT()
  {
    return false;
  }
  
  protected final LinkedList<e.a> gYU()
  {
    AppMethodBeat.i(80307);
    if (this.pHS == null)
    {
      Log.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
      AppMethodBeat.o(80307);
      return null;
    }
    Object localObject = cDu();
    if (this.pHS != null)
    {
      String str = this.pHS.getUrl();
      if (!Util.isNullOrNil(str))
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
            boolean bool = Util.isNullOrNil(str);
            if (bool)
            {
              AppMethodBeat.o(80307);
              return null;
            }
            localObject = str;
            if (!str.startsWith(".")) {
              localObject = ".".concat(String.valueOf(str));
            }
            Log.d("MicroMsg.WebViewUI", "host = %s", new Object[] { localObject });
            if (localPattern.matcher((CharSequence)localObject).matches())
            {
              long l;
              if (this.QfY == null)
              {
                l = System.currentTimeMillis();
                this.QfY = this.pGC.gXd();
                if (this.QfY == null) {
                  break label281;
                }
              }
              label281:
              for (bool = true;; bool = false)
              {
                Log.d("MicroMsg.WebViewUI", "[hakon] getConfigListMap %b, cost %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
                if ((this.QfY == null) || (this.QfY.size() <= 0)) {
                  break;
                }
                localObject = com.tencent.mm.n.e.k(this.QfY);
                AppMethodBeat.o(80307);
                return localObject;
              }
            }
          }
          catch (Exception localException)
          {
            Log.d("MicroMsg.WebViewUI", "[hakon] getJDMenuItems, ex = ", new Object[] { localException.getMessage() });
            AppMethodBeat.o(80307);
            return null;
          }
        }
      }
    }
  }
  
  protected final int gYV()
  {
    AppMethodBeat.i(80314);
    int i = c.h.icons_outlined_more;
    if (gYU() != null) {
      i = c.h.mm_title_btn_jd;
    }
    AppMethodBeat.o(80314);
    return i;
  }
  
  protected boolean gYX()
  {
    AppMethodBeat.i(80320);
    if (this.Qfo)
    {
      AppMethodBeat.o(80320);
      return true;
    }
    if ((this.pHS != null) && ((this.pHS.canGoBack()) || (this.pHS.canGoForward())) && (this.QeW != null))
    {
      Object localObject1 = this.QeW;
      boolean bool;
      if (((j)localObject1).QcO != null)
      {
        localObject1 = ((j)localObject1).QcO;
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        bool = ((Boolean)localObject1).booleanValue();
      }
      while (bool)
      {
        this.Qfn = false;
        this.Qfo = true;
        AppMethodBeat.o(80320);
        return true;
        Object localObject2 = MultiProcessMMKV.getMMKV("WebViewUIShowBottom");
        if (localObject2 == null) {
          kotlin.g.b.p.iCn();
        }
        if (((MultiProcessMMKV)localObject2).decodeInt("WebViewUIShowBottomNav", 0) == 1)
        {
          ((j)localObject1).QcO = Boolean.TRUE;
          localObject1 = ((j)localObject1).QcO;
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          bool = ((Boolean)localObject1).booleanValue();
        }
        else
        {
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vze, 0) == 1) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label231;
            }
            Log.i(j.TAG, "needShowBottomNavigator not open");
            ((j)localObject1).QcO = Boolean.FALSE;
            localObject1 = ((j)localObject1).QcO;
            if (localObject1 == null) {
              kotlin.g.b.p.iCn();
            }
            bool = ((Boolean)localObject1).booleanValue();
            break;
          }
          label231:
          ((j)localObject1).QcO = Boolean.valueOf(((j)localObject1).gXE());
          Log.i(j.TAG, "needShowBottomNavigator deviceShowBottomNav %b", new Object[] { ((j)localObject1).QcO });
          localObject2 = ((j)localObject1).QcO;
          if (localObject2 == null) {
            kotlin.g.b.p.iCn();
          }
          if (((Boolean)localObject2).booleanValue())
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(18210, new Object[] { Integer.valueOf(1) });
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1160L, 0L, 1L, false);
          }
          for (;;)
          {
            localObject1 = ((j)localObject1).QcO;
            if (localObject1 == null) {
              kotlin.g.b.p.iCn();
            }
            bool = ((Boolean)localObject1).booleanValue();
            break;
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1160L, 2L, 1L, false);
          }
        }
      }
    }
    AppMethodBeat.o(80320);
    return false;
  }
  
  protected final void gYY()
  {
    AppMethodBeat.i(80344);
    this.QfS.setVisibility(0);
    if ((this.QeU != null) && (this.QeU.getVisibility() == 0)) {
      this.QeU.setVisibility(8);
    }
    AppMethodBeat.o(80344);
  }
  
  protected boolean gYZ()
  {
    return false;
  }
  
  final void gYb()
  {
    AppMethodBeat.i(80368);
    this.Qgk.gYb();
    AppMethodBeat.o(80368);
  }
  
  public final int gYd()
  {
    AppMethodBeat.i(220292);
    int i = this.Qgk.gYd();
    AppMethodBeat.o(220292);
    return i;
  }
  
  protected final boolean gYj()
  {
    return this.PIQ.PGD;
  }
  
  protected final Map<String, String> gYk()
  {
    return this.PIQ.PFV;
  }
  
  public final com.tencent.mm.plugin.webview.k.n gYl()
  {
    return this.Qgh;
  }
  
  public final HandOffURL gYn()
  {
    return this.Qgq;
  }
  
  public final com.tencent.mm.plugin.webview.ui.tools.multitask.a gYo()
  {
    return this.Qgt;
  }
  
  protected final com.tencent.mm.plugin.webview.model.ar gYp()
  {
    return this.PIQ.PHQ;
  }
  
  protected final h gYr()
  {
    AppMethodBeat.i(219800);
    h localh = new h(this);
    AppMethodBeat.o(219800);
    return localh;
  }
  
  public final MPVideoPlayFullScreenView gYt()
  {
    AppMethodBeat.i(80224);
    if (this.Qgz == null)
    {
      this.Qgz = new MPVideoPlayFullScreenView(this, null);
      this.Qgz.setVisibility(8);
      localObject = (ViewParent)getWindow().getDecorView();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).addView(this.Qgz, new FrameLayout.LayoutParams(-1, -1));
      }
    }
    Object localObject = this.Qgz;
    AppMethodBeat.o(80224);
    return localObject;
  }
  
  public final s gYu()
  {
    return this.iYE;
  }
  
  public final boolean gYv()
  {
    AppMethodBeat.i(219836);
    boolean bool = this.PHJ.gYv();
    AppMethodBeat.o(219836);
    return bool;
  }
  
  protected final void gYx()
  {
    AppMethodBeat.i(80251);
    if ((this.QgD == null) || (gYy()))
    {
      AppMethodBeat.o(80251);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.QgD.getLayoutParams();
    int i = gYz();
    if (i != localMarginLayoutParams.topMargin)
    {
      localMarginLayoutParams.topMargin = i;
      this.QgD.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(80251);
  }
  
  protected boolean gZa()
  {
    return false;
  }
  
  protected void gZc()
  {
    AppMethodBeat.i(80356);
    if (gZb())
    {
      AppMethodBeat.o(80356);
      return;
    }
    gZd();
    if (!gUw())
    {
      this.Qgc = true;
      m.Qer.close();
      if (!this.Qge) {
        ba.e.cI(elY(), 1);
      }
      if ((this.Qgt != null) && (this.Qgt.zH(1)))
      {
        AppMethodBeat.o(80356);
        return;
      }
      finish();
    }
    AppMethodBeat.o(80356);
  }
  
  protected boolean gZe()
  {
    return true;
  }
  
  protected final boolean gZf()
  {
    AppMethodBeat.i(80360);
    if (this.QgT != -3)
    {
      showVKB();
      AppMethodBeat.o(80360);
      return true;
    }
    AppMethodBeat.o(80360);
    return false;
  }
  
  protected final void gZg()
  {
    AppMethodBeat.i(220282);
    if ((this.Qgc) || (this.Qgd) || (isFinishing()))
    {
      AppMethodBeat.o(220282);
      return;
    }
    if (this.PIQ != null)
    {
      com.tencent.mm.plugin.webview.core.i locali = this.PIQ;
      locali.n(locali.cDu(), true, 8);
    }
    if (this.QfS != null) {
      this.QfS.setVisibility(8);
    }
    this.PIx.gWd().D(new Object[] { cDu(), Integer.valueOf(4) }).report();
    AppMethodBeat.o(220282);
  }
  
  public final MMWebView gZh()
  {
    return this.pHS;
  }
  
  public final void gZi()
  {
    AppMethodBeat.i(220296);
    if (this.PIQ != null)
    {
      Iterator localIterator = ((Iterable)this.PIQ.PwK).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.webview.core.k)localIterator.next()).gSZ();
      }
    }
    AppMethodBeat.o(220296);
  }
  
  protected final int getActionBarHeight()
  {
    AppMethodBeat.i(80250);
    if (getResources().getDimensionPixelSize(c.d.wechat_abc_action_bar_default_height) > com.tencent.mm.ci.a.fromDPToPix(this, 48))
    {
      i = getResources().getDimensionPixelSize(c.d.wechat_abc_action_bar_default_height);
      AppMethodBeat.o(80250);
      return i;
    }
    if (com.tencent.mm.compatible.util.i.isPortOrientation(this))
    {
      i = getResources().getDimensionPixelSize(c.d.DefaultActionbarHeightPort);
      AppMethodBeat.o(80250);
      return i;
    }
    int i = getResources().getDimensionPixelSize(c.d.DefaultActionbarHeightLand);
    AppMethodBeat.o(80250);
    return i;
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(219944);
    if (this.PHJ.bUK())
    {
      i = getRequestedOrientation();
      AppMethodBeat.o(219944);
      return i;
    }
    int i = this.PJe;
    AppMethodBeat.o(219944);
    return i;
  }
  
  public int getLayoutId()
  {
    return c.g.webview;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(219941);
    String str = this.PIQ.pHS.getSettings().getUserAgentString();
    AppMethodBeat.o(219941);
    return str;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    AppMethodBeat.i(219834);
    if (this.PIQ != null)
    {
      com.tencent.luggage.xweb_ext.extendplugin.b.c localc = this.PIQ.getWebViewPluginClientProxy();
      AppMethodBeat.o(219834);
      return localc;
    }
    AppMethodBeat.o(219834);
    return null;
  }
  
  protected void goBack()
  {
    AppMethodBeat.i(219890);
    if (this.pHS == null)
    {
      AppMethodBeat.o(219890);
      return;
    }
    if (Util.isNullOrNil(elY()))
    {
      com.tencent.mm.plugin.webview.core.n localn = com.tencent.mm.plugin.webview.core.n.PJr;
      if (!((Boolean)com.tencent.mm.plugin.webview.core.n.PJp.getValue()).booleanValue()) {}
    }
    for (int i = 1; (this.QfU) && (i == 0); i = 0)
    {
      AppMethodBeat.o(219890);
      return;
    }
    if (this.pHS.canGoBack())
    {
      gYI();
      AppMethodBeat.o(219890);
      return;
    }
    m.Qer.close();
    finish();
    AppMethodBeat.o(219890);
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(80361);
    super.hideVKB();
    this.QfI = true;
    this.QgT = -2;
    AppMethodBeat.o(80361);
  }
  
  public void initActivityCloseAnimation()
  {
    AppMethodBeat.i(219888);
    if ((this.Qgt != null) && (this.Qgt.faT())) {}
    for (int i = 1; (com.tencent.mm.ui.ar.hIO()) && (i == 0); i = 0)
    {
      overridePendingTransition(0, MMFragmentActivity.a.WaZ);
      AppMethodBeat.o(219888);
      return;
    }
    super.initActivityCloseAnimation();
    AppMethodBeat.o(219888);
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
    this.QfV = true;
    AppMethodBeat.o(80222);
  }
  
  public void initView()
  {
    AppMethodBeat.i(80284);
    this.Qfa = ((WebViewKeyboardLinearLayout)findViewById(c.f.webview_keyboard_ll));
    this.Qfb = ((FrameLayout)findViewById(c.f.root_container));
    this.Qfw = getIntent().getBooleanExtra("finishviewifloadfailed", false);
    this.Qfu = getIntent().getBooleanExtra("is_favorite_item", false);
    this.IYi = getIntent().getBooleanExtra("isWebwx", true);
    boolean bool = getIntent().getBooleanExtra("show_feedback", false);
    this.QfT = Util.nullAsNil(getIntent().getStringExtra("sentUsername"));
    if (bool) {
      addTextOptionMenu(1, getString(c.i.settings_feedbackui_title), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(249324);
          try
          {
            paramAnonymousMenuItem = WebViewUI.this.pGC.blV(null);
            WebViewUI.this.loadUrl(paramAnonymousMenuItem);
            AppMethodBeat.o(249324);
            return false;
          }
          catch (RemoteException paramAnonymousMenuItem)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.WebViewUI", paramAnonymousMenuItem, "[oneliang]feedback exception:%s", new Object[] { paramAnonymousMenuItem.getMessage() });
            }
          }
        }
      });
    }
    this.QeU = ((ProgressBar)findViewById(c.f.create_progress_bar));
    if ((this.Qgr != null) && (this.QeU != null) && (this.Qgr.QcC.PQp))
    {
      this.QeU.setVisibility(0);
      this.QfW = true;
    }
    this.QfS = findViewById(c.f.refresh_mask);
    this.QfS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(215863);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WebViewUI.this.gZg();
        if ((WebViewUI.this.Qgr != null) && (WebViewUI.this.QeU != null) && (WebViewUI.this.Qgr.QcC.PQp)) {
          WebViewUI.this.QeU.setVisibility(0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(215863);
      }
    });
    if (this.IYi)
    {
      localObject1 = Util.nullAsNil(getIntent().getStringExtra("title"));
      if (((CharSequence)localObject1).length() > 0) {
        this.QeR = true;
      }
      this.QeS = getIntent().getBooleanExtra("key_show_web_page_title", false);
      setMMTitle((CharSequence)localObject1);
    }
    for (;;)
    {
      this.QcS = findViewById(c.f.web_navigator);
      if (this.QcS != null)
      {
        this.QeW = new j(this.QcS, this.Qfa, this.pHS);
        this.QcS.setVisibility(8);
        this.QeX = ((ImageButton)findViewById(c.f.web_back));
        this.QeX.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80091);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if ((WebViewUI.this.pHS != null) && (WebViewUI.this.pHS.canGoBack())) {
              WebViewUI.this.gYI();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80091);
          }
        });
        this.QeY = ((ImageButton)findViewById(c.f.web_forward));
        this.QeY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80092);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if ((WebViewUI.this.pHS != null) && (WebViewUI.this.pHS.canGoForward())) {
              WebViewUI.this.pHS.goForward();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80092);
          }
        });
      }
      if (this.pHS != null) {
        break;
      }
      Log.i("MicroMsg.WebViewUI", "initView viewWV is null");
      finish();
      AppMethodBeat.o(80284);
      return;
      setMMTitle("");
    }
    if (QfH == WebSettings.RenderPriority.NORMAL)
    {
      Log.i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
      this.pHS.getSettings().a(WebSettings.RenderPriority.HIGH);
      QfH = WebSettings.RenderPriority.HIGH;
    }
    Object localObject3 = this.QgG;
    Object localObject1 = getContentView();
    ((l)localObject3).Qeb = ((LogoWebViewWrapper)((View)localObject1).findViewById(c.f.logo_web_view_wrapper));
    ((l)localObject3).Qea = ((ImageView)((View)localObject1).findViewById(c.f.webview_logo_refresh_iv));
    ((l)localObject3).Qej = ((View)localObject1).findViewById(c.f.webview_logo_container);
    if (((l)localObject3).Qej != null)
    {
      ((l)localObject3).Qek = ((l)localObject3).Qej.findViewById(c.f.x5_logo);
      ((l)localObject3).Qel = ((TextView)((l)localObject3).Qek.findViewById(c.f.x5_logo_url));
      ((l)localObject3).Qem = ((TextView)((l)localObject3).Qek.findViewById(c.f.info_txt));
    }
    ((l)localObject3).Qec = BackwardSupportUtil.BitmapFactory.fromDPToPix(((l)localObject3).Qeb.getContext(), 72.0F);
    Object localObject2;
    if (((l)localObject3).Qea == null)
    {
      localObject1 = "null";
      if (((l)localObject3).Qeb != null) {
        break label1335;
      }
      localObject2 = "null";
      label607:
      Log.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage.id = %s, logoWrapper.id = %s", new Object[] { localObject1, localObject2 });
      Log.d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", new Object[] { Integer.valueOf(((l)localObject3).Qec) });
      localObject1 = this.QgG;
      localObject2 = this.pHS;
      ((MMWebView)localObject2).setCompetitorView(((l)localObject1).Qeb);
      ((MMWebView)localObject2).hZP();
      if (Build.VERSION.SDK_INT <= 10) {
        ((l)localObject1).Qeb.getWebViewContainer().setBackgroundColor(((l)localObject1).Qeb.getResources().getColor(c.c.webview_logo_bg_color));
      }
      localObject3 = ((l)localObject1).Qeb;
      ((LogoWebViewWrapper)localObject3).getWebViewContainer();
      if (((LogoWebViewWrapper)localObject3).Qba != null)
      {
        ((LogoWebViewWrapper)localObject3).jhN = ((WebView)localObject2);
        ((LogoWebViewWrapper)localObject3).Qba.addView(((LogoWebViewWrapper)localObject3).jhN);
      }
      if ((!((MMWebView)localObject2).isXWalkKernel()) && (!((MMWebView)localObject2).getIsX5Kernel())) {
        break label1350;
      }
      ((l)localObject1).Qen = true;
      label763:
      if ((((l)localObject1).Qek != null) && (!((MMWebView)localObject2).getIsX5Kernel()))
      {
        ((ImageView)((l)localObject1).Qek.findViewById(c.f.x5_logo_img)).setVisibility(8);
        ((l)localObject1).Qem.setText("");
      }
      if ((!((l)localObject1).Qen) || (((l)localObject1).Qeo)) {
        break label1358;
      }
      ((l)localObject1).Dc(false);
      ((l)localObject1).gYg();
    }
    for (;;)
    {
      gXB();
      this.Qfc = ((FrameLayout)findViewById(c.f.container));
      Log.i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.pHS.getIsX5Kernel());
      this.pHS.setWebViewClientExtension(new b(this));
      this.pHS.setWebViewCallbackClient(this.Qgv);
      if (this.pHS.getIsX5Kernel())
      {
        localObject1 = this.QgG;
        localObject2 = new LogoWebViewWrapper.a()
        {
          public final void gXs()
          {
            AppMethodBeat.i(266029);
            if (WebViewUI.this.pHS.getIsX5Kernel()) {
              WebViewUI.this.PIx.gWd().D(new Object[] { WebViewUI.this.cDu(), Integer.valueOf(10) }).report();
            }
            AppMethodBeat.o(266029);
          }
        };
        if (((l)localObject1).Qeb != null) {
          ((l)localObject1).Qeb.setMMOverScrollListener((LogoWebViewWrapper.a)localObject2);
        }
      }
      this.Qfi = findViewById(c.f.webview_input_shadow);
      this.Qfh = ((WebViewRedesignInputFooter)findViewById(c.f.webview_input_footer));
      if (this.Qfh != null)
      {
        this.Qfh.setInputShadowView(this.Qfi);
        this.Qfh.hide();
        this.Qfh.setOnTextSendListener(new WebViewRedesignInputFooter.b()
        {
          public final void bmq(String paramAnonymousString)
          {
            AppMethodBeat.i(216149);
            WebViewUI.a(WebViewUI.this, paramAnonymousString);
            AppMethodBeat.o(216149);
          }
          
          public final void bmr(String paramAnonymousString)
          {
            AppMethodBeat.i(216150);
            WebViewUI.b(WebViewUI.this, paramAnonymousString);
            AppMethodBeat.o(216150);
          }
        });
        this.Qfh.setOnSmileyChosenListener(new WebViewRedesignInputFooter.a()
        {
          public final boolean dO(String paramAnonymousString)
          {
            AppMethodBeat.i(243564);
            com.tencent.mm.plugin.webview.d.h localh;
            if (WebViewUI.this.PvJ != null)
            {
              localh = WebViewUI.this.PvJ;
              if (localh.NoX) {
                break label44;
              }
              Log.e("MicroMsg.JsApiHandler", "not ready");
            }
            for (;;)
            {
              AppMethodBeat.o(243564);
              return true;
              label44:
              HashMap localHashMap = new HashMap();
              localHashMap.put("smiley", paramAnonymousString);
              MMHandlerThread.postToMainThread(new h.27(localh, n.a.b("onGetSmiley", localHashMap, localh.PNx, localh.EVx)));
            }
          }
        });
        this.Qfh.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b()
        {
          public final void gUK()
          {
            AppMethodBeat.i(217127);
            WebViewUI.a(WebViewUI.this, 0);
            AppMethodBeat.o(217127);
          }
          
          public final void gUL()
          {
            AppMethodBeat.i(217129);
            WebViewKeyboardLinearLayout localWebViewKeyboardLinearLayout = WebViewUI.this.Qfa;
            if ((localWebViewKeyboardLinearLayout != null) && (localWebViewKeyboardLinearLayout.getKeyBoardHeight() > 0)) {
              WebViewUI.a(WebViewUI.this, localWebViewKeyboardLinearLayout.getKeyBoardHeight());
            }
            AppMethodBeat.o(217129);
          }
        });
      }
      this.Qfj = ((WebViewSearchContentInputFooter)findViewById(c.f.search_content_input_footer));
      if (this.Qfj != null)
      {
        this.Qfj.setActionDelegate(new WebViewSearchContentInputFooter.a()
        {
          public final void a(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
          {
            AppMethodBeat.i(265545);
            if (paramAnonymousWebViewSearchContentInputFooter.getVisibility() == 0) {
              b(paramAnonymousWebViewSearchContentInputFooter);
            }
            AppMethodBeat.o(265545);
          }
          
          public final void b(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
          {
            AppMethodBeat.i(265550);
            WebViewUI.this.pHS.clearMatches();
            paramAnonymousWebViewSearchContentInputFooter.reset();
            WebViewUI.this.Qfj.O(0, 0, true);
            WebViewUI.a(WebViewUI.this, false);
            WebViewUI.this.pHS.findAllAsync(paramAnonymousWebViewSearchContentInputFooter.getSearchContent());
            AppMethodBeat.o(265550);
          }
          
          public final boolean c(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(265551);
            if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0)) {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(480L, 6L, 1L, false);
            }
            AppMethodBeat.o(265551);
            return false;
          }
          
          public final void gUM()
          {
            AppMethodBeat.i(265544);
            WebViewUI.b(WebViewUI.this, 0);
            WebViewUI.this.pHS.clearMatches();
            WebViewUI.this.Qfj.hcd();
            AppMethodBeat.o(265544);
          }
          
          public final void gUN()
          {
            AppMethodBeat.i(265547);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(480L, 5L, 1L, false);
            WebViewUI.this.pHS.findNext(false);
            AppMethodBeat.o(265547);
          }
          
          public final void gUO()
          {
            AppMethodBeat.i(265549);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(480L, 4L, 1L, false);
            WebViewUI.this.pHS.findNext(true);
            AppMethodBeat.o(265549);
          }
        });
        this.pHS.setFindListener(new WebView.FindListener()
        {
          public final void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(259838);
            if ((paramAnonymousBoolean) && (!WebViewUI.e(WebViewUI.this)) && (!Util.isNullOrNil(WebViewUI.this.Qfj.getSearchContent())))
            {
              if (paramAnonymousInt2 != 0) {
                break label81;
              }
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(480L, 3L, 1L, false);
            }
            for (;;)
            {
              WebViewUI.a(WebViewUI.this, true);
              WebViewUI.this.Qfj.O(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
              AppMethodBeat.o(259838);
              return;
              label81:
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(480L, 2L, 1L, false);
            }
          }
        });
      }
      this.Qfd = ((MovingImageButton)findViewById(c.f.full_screen_menu));
      this.QfA = findViewById(c.f.webview_input_alert_toast);
      if (this.QfA != null) {
        this.QfA.setVisibility(8);
      }
      this.pHS.setWebChromeClient(gYN());
      this.pHS.setDownloadListener(new DownloadListener()
      {
        public final void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
        {
          AppMethodBeat.i(219249);
          Log.i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + paramAnonymousString1 + ", mimetype = " + paramAnonymousString4 + ", userAgent = " + paramAnonymousString2 + ", contentDisposition = " + paramAnonymousString3);
          int i = WebViewUI.this.getIntent().getIntExtra("key_download_restrict", 0);
          String str = WebViewUI.this.getIntent().getStringExtra("key_function_id");
          if (!Util.isNullOrNil(str)) {
            com.tencent.mm.plugin.report.service.h.IzE.a(14596, new Object[] { str, Integer.valueOf(i), Integer.valueOf(0) });
          }
          if (i == 1)
          {
            Log.e("MicroMsg.WebViewUI", "not allow download file : %s", new Object[] { paramAnonymousString1 });
            AppMethodBeat.o(219249);
            return;
          }
          i = 0;
          int k = i;
          if (paramAnonymousString4 != null)
          {
            k = i;
            if (paramAnonymousString4.equalsIgnoreCase("application/vnd.android.package-archive"))
            {
              Log.v("MicroMsg.WebViewUI", "edw onDownloadStart, report download url: %s", new Object[] { paramAnonymousString1 });
              k = 1;
              e.a(WebViewUI.this.pGC, 11154, new Object[] { paramAnonymousString1 });
            }
          }
          if (WebViewUI.this.pGD == null)
          {
            Log.e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
            AppMethodBeat.o(219249);
            return;
          }
          int j = 0;
          if (paramAnonymousString4 != null)
          {
            boolean bool1 = WebViewUI.f(WebViewUI.this);
            Log.i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", new Object[] { Boolean.valueOf(bool1) });
            str = WebViewUI.bmp(paramAnonymousString3);
            if ((str == null) || (!Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", str))) {
              break label473;
            }
            i = 1;
            boolean bool2 = com.tencent.mm.plugin.webview.core.a.PHo.contains(paramAnonymousString4.toLowerCase());
            if ((!bool1) || ((i == 0) && (!bool2))) {
              break label479;
            }
          }
          label473:
          label479:
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
                  Log.i("MicroMsg.WebViewUI", "onDownloadStart is apk");
                }
              }
              e.a(WebViewUI.this.pGC, 18111, new Object[] { WebViewUI.this.elY(), paramAnonymousString1, paramAnonymousString4, paramAnonymousString3, paramAnonymousString2, Long.valueOf(paramAnonymousLong) });
            }
            if ((j != 0) || (WebViewUI.this.pGD.gWI().so(24)) || (WebViewUI.g(WebViewUI.this))) {
              break label485;
            }
            Log.e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
            AppMethodBeat.o(219249);
            return;
            i = 0;
            break;
          }
          label485:
          if ((k != 0) && (((q)com.tencent.mm.kernel.h.ae(q.class)).ZM()))
          {
            Log.w("MicroMsg.WebViewUI", "onDownloadStart isTeenMode and can not download apk");
            AppMethodBeat.o(219249);
            return;
          }
          paramAnonymousString2 = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString1));
          paramAnonymousString2.addFlags(268435456);
          try
          {
            paramAnonymousString1 = WebViewUI.this;
            paramAnonymousString2 = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousString2);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString1, paramAnonymousString2.aFh(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$26", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString1.startActivity((Intent)paramAnonymousString2.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString1, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$26", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(219249);
            return;
          }
          catch (Exception paramAnonymousString1)
          {
            Log.e("MicroMsg.WebViewUI", "startActivity fail, e = " + paramAnonymousString1.getMessage());
            AppMethodBeat.o(219249);
          }
        }
      });
      this.pHS.requestFocus(130);
      this.pHS.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(245705);
          if ((WebViewUI.this.QeZ != null) && (WebViewUI.this.QeZ.getVisibility() == 0))
          {
            Animation localAnimation = AnimationUtils.loadAnimation(WebViewUI.this, com.tencent.mm.plugin.webview.c.a.font_fade_out);
            localAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(263872);
                WebViewUI.this.QeZ.setVisibility(8);
                AppMethodBeat.o(263872);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationStart(Animation paramAnonymous2Animation) {}
            });
            WebViewUI.this.QeZ.startAnimation(localAnimation);
            WebViewUI.this.QeZ.setVisibility(8);
          }
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          while (WebViewUI.this.pHS == null)
          {
            AppMethodBeat.o(245705);
            return false;
            if (!paramAnonymousView.hasFocus()) {
              paramAnonymousView.requestFocus();
            }
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              WebViewUI.this.syc = ((int)paramAnonymousMotionEvent.getX());
              WebViewUI.this.syd = ((int)paramAnonymousMotionEvent.getY());
            }
          }
          if ((paramAnonymousMotionEvent.getAction() == 0) || (paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 261) || (paramAnonymousMotionEvent.getAction() == 517))
          {
            if (paramAnonymousMotionEvent.getPointerCount() <= 1) {
              break label249;
            }
            WebViewUI.this.pHS.getSettings().setBuiltInZoomControls(true);
            WebViewUI.this.pHS.getSettings().setSupportZoom(true);
          }
          for (;;)
          {
            AppMethodBeat.o(245705);
            return false;
            label249:
            WebViewUI.this.pHS.getSettings().setBuiltInZoomControls(false);
            WebViewUI.this.pHS.getSettings().setSupportZoom(false);
          }
        }
      });
      this.pHS.hZN();
      this.Qgj.emd();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(217676);
          WebViewUI.this.hideVKB();
          WebViewUI.this.gZc();
          Log.i("MicroMsg.WebViewUI", "on back btn press");
          AppMethodBeat.o(217676);
          return true;
        }
      }, gYO());
      if (gYP()) {
        this.Qfa.setOnkbdStateListener(new KeyboardLinearLayout.a()
        {
          public final void SG(int paramAnonymousInt)
          {
            AppMethodBeat.i(239761);
            Log.i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = ".concat(String.valueOf(paramAnonymousInt)));
            WebViewUI.a(WebViewUI.this, WebViewUI.this.Qfa, paramAnonymousInt);
            Object localObject1;
            Object localObject2;
            if (paramAnonymousInt == -3)
            {
              WebViewUI.this.PIx.gVZ().PVZ = 1;
              int i = WebViewUI.this.Qfa.getKeyBoardHeight();
              if (i > 0)
              {
                WebViewUI.b(WebViewUI.this, i);
                WebViewUI.a(WebViewUI.this, i);
              }
              if (WebViewUI.i(WebViewUI.this))
              {
                localObject1 = WebViewUI.j(WebViewUI.this);
                if (((WebViewRedesignInputFooter)localObject1).Qza) {
                  ((WebViewRedesignInputFooter)localObject1).setVisibility(8);
                }
                ((WebViewRedesignInputFooter)localObject1).state = 0;
                ((WebViewRedesignInputFooter)localObject1).aDL();
              }
              localObject2 = WebViewUI.this.PHJ;
              localObject1 = WebViewUI.this;
              kotlin.g.b.p.k(localObject1, "activity");
              localObject2 = ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h)localObject2).Qwa;
              if (localObject2 != null)
              {
                if (((com.tencent.mm.plugin.webview.ui.tools.video.b)localObject2).bUK()) {
                  com.tencent.e.h.ZvG.bc(new com.tencent.mm.plugin.webview.ui.tools.video.b.1((com.tencent.mm.plugin.webview.ui.tools.video.b)localObject2, (Activity)localObject1));
                }
                localObject1 = kotlin.x.aazN;
              }
            }
            do
            {
              WebViewUI.this.aoD(paramAnonymousInt);
              WebViewUI.this.QgT = paramAnonymousInt;
              AppMethodBeat.o(239761);
              return;
              WebViewUI.b(WebViewUI.this, 0);
              WebViewUI.a(WebViewUI.this, 0);
              localObject2 = WebViewUI.this.PHJ;
              localObject1 = WebViewUI.this;
              localObject2 = ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h)localObject2).Qwa;
            } while (localObject2 == null);
            if ((!((com.tencent.mm.plugin.webview.ui.tools.video.b)localObject2).bUK()) || (!((com.tencent.mm.plugin.webview.ui.tools.video.b)localObject2).QvV)) {}
            for (;;)
            {
              localObject1 = kotlin.x.aazN;
              break;
              com.tencent.e.h.ZvG.bc(new b.2((com.tencent.mm.plugin.webview.ui.tools.video.b)localObject2, (Activity)localObject1));
            }
          }
        });
      }
      this.QeT = ((MMFalseProgressBar)findViewById(c.f.web_falseprogress));
      this.KNZ = new MultiCodeMaskView(this);
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      this.KNZ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.KNZ.setVisibility(8);
      ((ViewGroup)getWindow().getDecorView()).addView(this.KNZ);
      super.setTitleBarDoubleClickListener(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264751);
          WebViewUI.this.gYQ();
          AppMethodBeat.o(264751);
        }
      });
      AppMethodBeat.o(80284);
      return;
      localObject1 = String.valueOf(((l)localObject3).Qea.getId());
      break;
      label1335:
      localObject2 = String.valueOf(((l)localObject3).Qeb.getId());
      break label607;
      label1350:
      ((l)localObject1).Qen = false;
      break label763;
      label1358:
      ((l)localObject1).Dc(true);
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
    if (this.PIQ != null) {
      this.PIQ.loadUrl(paramString, paramMap, paramBoolean);
    }
    AppMethodBeat.o(80297);
  }
  
  public boolean moveTaskToBack(boolean paramBoolean)
  {
    AppMethodBeat.i(219892);
    paramBoolean = super.moveTaskToBack(paramBoolean);
    initActivityCloseAnimation();
    AppMethodBeat.o(219892);
    return paramBoolean;
  }
  
  public boolean needShowIdcError()
  {
    return false;
  }
  
  protected void o(int paramInt, Bundle paramBundle) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(80289);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.luggage.k.f.aI(this).onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.pGM.c(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(80289);
      return;
    }
    if (this.QgH.c(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(80289);
      return;
    }
    if (this.QgI.c(this, paramInt1, paramInt2, paramIntent))
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
        Log.i("MicroMsg.WebViewUI", "gdpr continue:true");
        AppMethodBeat.o(80289);
        return;
      }
      Log.i("MicroMsg.WebViewUI", "gdpr continue:false");
      paramIntent = new Intent();
      localBundle = new Bundle();
      localBundle.putString("go_next", "gdpr_confirm_logout");
      paramIntent.putExtra("result_data", localBundle);
      this.Qgc = true;
      m.Qer.close();
      ba.e.cI(elY(), 1);
      setResult(-1, paramIntent);
      finish();
    }
    AppMethodBeat.o(80289);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(220298);
    if ((this.KNZ != null) && (this.KNZ.getVisibility() == 0))
    {
      long l = 0L;
      if (this.Qgj != null) {
        l = this.Qgj.BrO.longValue();
      }
      this.KNZ.F(l, false);
      AppMethodBeat.o(220298);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(220298);
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(80291);
    if (this.pHS != null)
    {
      if (!this.QgJ) {
        break label42;
      }
      this.pHS.setOnLongClickListener(this.QgK);
    }
    for (;;)
    {
      super.onCancel();
      AppMethodBeat.o(80291);
      return;
      label42:
      this.Qgj.emd();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(80265);
    super.onConfigurationChanged(paramConfiguration);
    if (this.sJy != paramConfiguration.orientation)
    {
      View localView = gYG();
      if (localView == null) {}
      for (localView = null; localView == null; localView = (View)localView.getParent())
      {
        AppMethodBeat.o(80265);
        return;
      }
      localView.dispatchConfigurationChanged(paramConfiguration);
      localView.requestLayout();
      this.sJy = paramConfiguration.orientation;
    }
    AppMethodBeat.o(80265);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80244);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYh, true)) {
      AccessibilityUtil.smartDisableAccessibility();
    }
    com.tencent.mm.plugin.webview.k.n localn = this.Qgh;
    localn.createTime = System.currentTimeMillis();
    localn.bU("onCreate", localn.createTime);
    this.Qgh.QAx = getIntent().getLongExtra("startTime", 0L);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.Qgh.bU("onUIInitStart", System.currentTimeMillis());
    cDT();
    this.Qgh.bU("onUIInitEnd", System.currentTimeMillis());
    paramBundle = getIntent();
    if (com.tencent.mm.ui.ar.hIO()) {
      overridePendingTransition(MMFragmentActivity.a.WaW, 0);
    }
    if ((paramBundle.hasExtra("nextAnimIn")) || (paramBundle.hasExtra("currentAnimOut"))) {
      overridePendingTransition(paramBundle.getIntExtra("nextAnimIn", com.tencent.mm.plugin.webview.c.a.slide_right_in), paramBundle.getIntExtra("currentAnimOut", com.tencent.mm.plugin.webview.c.a.slide_left_out));
    }
    ba.TC(0L);
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
    Log.i("MicroMsg.WebViewUI", "WebViewUI onDestroy now: %s", new Object[] { Integer.valueOf(this.PIQ.gSo()) });
    Object localObject1;
    Object localObject2;
    if ((com.tencent.mm.plugin.webview.ui.tools.floatball.d.gZN()) && (this.Qgt != null) && (this.Qgt.faQ()) && (this.pHS != null))
    {
      localObject1 = this.Qgt.FHd;
      if ((localObject1 == null) || (Util.isNullOrNil(((MultiTaskInfo)localObject1).field_id)))
      {
        Log.w("MicroMsg.WebViewUI", "saveMultiTaskInfo taskInfo invalid");
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1553L, 26L, 1L, false);
        this.Qgk.hpH();
        if ((this.PHI.Qhm != null) && (!Util.isNullOrNil(this.PHI.Qhm.PFg)))
        {
          localObject1 = new com.tencent.mm.plugin.webview.j();
          ((com.tencent.mm.plugin.webview.j)localObject1).PEl = this.PHI.Qhm.PFg;
          localObject2 = (com.tencent.mm.plugin.webview.n)this.PHI.Qhm.PFc.getValue();
          if (localObject2 != null)
          {
            kotlin.g.b.p.k(localObject2, "<set-?>");
            ((com.tencent.mm.plugin.webview.j)localObject1).PEm = ((com.tencent.mm.plugin.webview.n)localObject2);
          }
          this.PIQ.PHL = ((com.tencent.mm.plugin.webview.j)localObject1);
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      super.onDestroy();
      com.tencent.mm.plugin.webview.modeltools.b.gWk();
      localObject1 = elY();
      label259:
      int j;
      label471:
      Object localObject3;
      ba.l locall;
      label551:
      long l;
      String str;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.webview.k.p.jh(this);
        if ((localObject2 != null) && (((String)localObject1).equals(localObject2))) {
          com.tencent.mm.plugin.webview.k.p.ji(this);
        }
        if (this.Qgs != null) {
          this.Qgs.onDestroy();
        }
        if (this.Qfh != null)
        {
          localObject1 = this.Qfh;
          ((WebViewRedesignInputFooter)localObject1).hce();
          if ((((WebViewRedesignInputFooter)localObject1).QyY != null) && (((WebViewRedesignInputFooter)localObject1).iXq != null)) {
            ((WebViewRedesignInputFooter)localObject1).iXq.hideVKB(((WebViewRedesignInputFooter)localObject1).QyY);
          }
          ((WebViewRedesignInputFooter)localObject1).QyY = null;
          ((WebViewRedesignInputFooter)localObject1).QyU.onDestroy();
          ((WebViewRedesignInputFooter)localObject1).removeAllViews();
          ((WebViewRedesignInputFooter)localObject1).iXq = null;
          ((WebViewRedesignInputFooter)localObject1).Qze = null;
        }
        if (this.Qgq != null)
        {
          Log.i("MicroMsg.WebViewUI", "onDestroy, invalidate mHandOffURL");
          this.Qgq = null;
        }
        if (this.Qgj != null)
        {
          localObject1 = this.Qgj;
          if (((WebViewLongClickHelper)localObject1).oxq != null) {
            ((WebViewLongClickHelper)localObject1).oxq.mContext = MMApplicationContext.getContext();
          }
          if (((WebViewLongClickHelper)localObject1).oxl != null)
          {
            ((WebViewLongClickHelper)localObject1).oxl.mContext = null;
            ((WebViewLongClickHelper)localObject1).oxl = null;
          }
        }
        if (this.Qfg != null) {
          this.Qfg.disable();
        }
        this.Qgc = true;
        Qgb -= 1;
        int k = this.PIQ.gSo();
        j = QfC.size() - 1;
        if (j >= 0)
        {
          if (((e)QfC.get(j)).id != k) {
            break label1200;
          }
          QfC.remove(j);
        }
        if (this.Qfv != null) {
          this.akm.removeAccessibilityStateChangeListener(this.Qfv);
        }
        localObject3 = this.PIx;
        locall = ((ba)localObject3).gVX();
        j = ba.bTg();
        Iterator localIterator = locall.PWF.entrySet().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (Map.Entry)localIterator.next();
          localObject2 = (String)((Map.Entry)localObject1).getKey();
          l = ((Long)((Map.Entry)localObject1).getValue()).longValue();
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(32L, 0L, 1L, true);
        } while ((l < 0L) || (l > 180000L));
        str = locall.PWC;
        if (localObject2 != null) {
          break label1207;
        }
      }
      boolean bool;
      label1183:
      label1200:
      label1207:
      for (localObject1 = localObject2;; localObject1 = ((String)localObject2).replace(",", "!"))
      {
        ba.q(str, new Object[] { Integer.valueOf(3), Long.valueOf(l), Integer.valueOf(j), localObject1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ba.access$000()), Integer.valueOf(ba.access$100()), Integer.valueOf(locall.gco), locall.PWC });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(160L, 0L, 1L, false);
        if (-1 != com.tencent.mm.plugin.webview.i.a.TD(l)) {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(160L, com.tencent.mm.plugin.webview.i.a.TD(l), 1L, false);
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(32L, 3L, 1L, true);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(32L, 7L, l, true);
        if (ba.access$100() == 1)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(32L, 16L, 1L, true);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(32L, 17L, l, true);
        }
        Log.i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { localObject2, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(ba.access$000()), Integer.valueOf(ba.access$100()), Integer.valueOf(locall.gco), locall.PWC });
        break label551;
        localObject1 = ((MultiTaskInfo)localObject1).field_id;
        Log.i("MicroMsg.WebViewUI", "saveMultiTaskInfo to cache multiTaskId=%s", new Object[] { localObject1 });
        if ((this.pHS != null) && (this.pHS.getParent() != null) && (this.pHS.getActivityContextIfHas() == this))
        {
          if (this.PHJ.bUK()) {
            this.PHJ.Dq(true);
          }
          this.pHS.onHide();
          ((ViewGroup)this.pHS.getParent()).removeView(this.pHS);
          this.pHS.aD(MMApplicationContext.getContext());
          if (this.PvJ != null) {
            this.PvJ.CR(true);
          }
          localObject2 = this.PIQ.PHK;
          if (getMMTitle() != null)
          {
            localObject3 = getController();
            if (((w)localObject3).VZF == null) {
              break label1183;
            }
          }
        }
        for (i = ((w)localObject3).VZF.getVisibility();; i = 0)
        {
          if (i == 0) {
            ((com.tencent.mm.plugin.webview.ui.tools.floatball.c)localObject2).title = getMMTitle().toString();
          }
          localObject2 = com.tencent.mm.plugin.webview.ui.tools.floatball.d.Qkh;
          com.tencent.mm.plugin.webview.ui.tools.floatball.d.a((String)localObject1, this.PIQ);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1553L, 0L, 1L, false);
          break;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1553L, 20L, 1L, false);
          if (this.pHS == null) {}
          for (bool = true;; bool = false)
          {
            Log.w("MicroMsg.WebViewUI", "saveMultiTaskInfo wv has no parent, %b", new Object[] { Boolean.valueOf(bool) });
            break;
          }
        }
        Log.w("MicroMsg.WebViewUI", "currentURL == null, qbrowser.url may be not accurate");
        break label259;
        j -= 1;
        break label471;
      }
      localObject1 = ((ba)localObject3).gVZ();
      if (!Util.isNullOrNil(((ay)localObject1).PVS)) {
        Log.d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", new Object[] { ((ay)localObject1).PVS });
      }
      try
      {
        com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)IPCVoid.jZu, ay.a.PWa.getClass(), (com.tencent.mm.ipcinvoker.f)new ay.b((ay)localObject1));
        localObject1 = ((ba)localObject3).gWa();
        if (!Util.isNullOrNil(((ak)localObject1).lpD))
        {
          localObject2 = ((ak)localObject1).lpD;
          if (localObject2 == null) {
            kotlin.g.b.p.iCn();
          }
          if (kotlin.n.n.M((String)localObject2, "wrd", false)) {}
        }
        else
        {
          ((ba)localObject3).gVW().report();
          ((ba)localObject3).gVY().report();
          localObject1 = ((ba)localObject3).gWc();
          j = ba.bTg();
          if (!((ba.b)localObject1).PWw) {
            break label2664;
          }
          if (!((ba.b)localObject1).loadFinished) {
            break label2619;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(11575, new Object[] { ((ba.b)localObject1).fXu, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(j) });
          localObject1 = this.PIx;
          ((ba)localObject1).PWf = null;
          ((ba)localObject1).PWd = null;
          ((ba)localObject1).PWe = null;
          ((ba)localObject1).PWc = null;
          ((ba)localObject1).PWh = null;
          ((ba)localObject1).PWi = null;
          ((ba)localObject1).PWj = null;
          ((ba)localObject1).PWk = null;
          if (((ba)localObject1).PWp != null)
          {
            ((ba)localObject1).PWp.fKb = null;
            ((ba)localObject1).PWp = null;
          }
          bkl("onDestroy");
          if (this.QfM != null) {
            this.QfM.clear();
          }
          gYm();
          d(this.QfR);
          if ((this.QfF != null) && ((this.QfF instanceof b))) {
            d(((b)this.QfF).nnz);
          }
          if (this.Qfh != null) {
            this.Qfh.setOnTextSendListener(null);
          }
          if (this.QeW != null)
          {
            localObject1 = this.QeW.QcS;
            if (localObject1 != null)
            {
              localObject2 = ((View)localObject1).getAnimation();
              if (localObject2 != null) {
                ((Animation)localObject2).setAnimationListener(null);
              }
              ((View)localObject1).clearAnimation();
            }
          }
          if (this.KNZ != null) {
            this.KNZ.fBH();
          }
          if (this.QfN != null) {
            this.QfN.clear();
          }
          this.Qgw.dead();
          this.QfJ.dead();
          if (com.tencent.xweb.d.my(MMApplicationContext.getContext()) != null) {
            Log.i("MicroMsg.WebViewUI", "now force sync the cookie between ram and db");
          }
        }
      }
      catch (RemoteException localThrowable)
      {
        try
        {
          com.tencent.xweb.d.sync();
          Log.v("MicroMsg.WebViewUI", "on destroy isNeedCallbackMMRpt[%b]", new Object[] { Boolean.valueOf(this.Qfq) });
          if (!this.Qfq) {}
        }
        catch (Exception localThrowable)
        {
          try
          {
            localObject1 = getIntent().getBundleExtra("mm_report_bundle");
            if (!Util.isNullOrNil(((Bundle)localObject1).getString("mm_event_class"))) {
              if (this.pGC != null)
              {
                ((Bundle)localObject1).putLong("key_activity_browse_time", getActivityBrowseTimeMs());
                this.pGC.l(250, (Bundle)localObject1);
              }
            }
          }
          catch (Exception localThrowable)
          {
            try
            {
              if (this.pGC != null)
              {
                localObject1 = new Bundle();
                ((Bundle)localObject1).putLong("key_activity_browse_time", getActivityBrowseTimeMs());
                this.pGC.l(251, (Bundle)localObject1);
              }
            }
            catch (Exception localThrowable)
            {
              try
              {
                if (this.pGC != null)
                {
                  localObject1 = this.pGC.l(19, null);
                  if (localObject1 != null)
                  {
                    bool = ((Bundle)localObject1).getBoolean("webview_video_proxy_init");
                    Log.i("MicroMsg.WebViewUI", "onDestroy, has init = %b, webviewHoldingCounter = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(Qgb) });
                    if ((bool) && (Qgb <= 0))
                    {
                      FactoryProxyManager.getPlayManager().deinit();
                      this.pGC.l(75, null);
                    }
                  }
                }
                if (this.pHS != null)
                {
                  this.pHS.YcA = null;
                  this.pHS.setCompetitorView(null);
                  this.pHS.setOnTouchListener(null);
                  this.pHS.setWebViewCallbackClient(null);
                  this.pHS.aD(MMApplicationContext.getContext());
                  this.pHS.setDownloadListener(null);
                  this.pHS.setFindListener(null);
                  this.pHS.setWebChromeClient(null);
                  this.pHS.setOnLongClickListener(null);
                }
                if (i == 0)
                {
                  this.PIQ.gST();
                  if (this.pGD != null)
                  {
                    localObject1 = this.pGD;
                    Log.i("MicroMsg.WebViewPermission", "detach");
                    if (((com.tencent.mm.plugin.webview.f.g)localObject1).PYM != null)
                    {
                      ((com.tencent.mm.plugin.webview.f.g)localObject1).PYM.clear();
                      ((com.tencent.mm.plugin.webview.f.g)localObject1).PYM = null;
                    }
                    this.pGD = null;
                  }
                  this.pHS = null;
                  localObject1 = this.PIQ;
                  localObject2 = ((com.tencent.mm.plugin.webview.core.i)localObject1).PHJ;
                  if (localObject2 != null)
                  {
                    localObject3 = MMApplicationContext.getContext();
                    kotlin.g.b.p.j(localObject3, "MMApplicationContext.getContext()");
                    ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h)localObject2).aD((Context)localObject3);
                  }
                  ((com.tencent.mm.plugin.webview.core.i)localObject1).gSN().context = MMApplicationContext.getContext();
                  ((com.tencent.mm.plugin.webview.core.i)localObject1).PHZ.cVG();
                  if (!((com.tencent.mm.plugin.webview.core.i)localObject1).PHV)
                  {
                    Log.w(((com.tencent.mm.plugin.webview.core.i)localObject1).gSK(), "onWebViewUIDestroy without pageStarted");
                    ba.TC(11L);
                  }
                  ah.destroy();
                  this.PIQ.gSO().gWF();
                }
              }
              catch (Exception localThrowable)
              {
                try
                {
                  this.QgG.release();
                  if ((getContentView() instanceof ViewGroup)) {
                    ((ViewGroup)getContentView()).removeAllViews();
                  }
                  localObject1 = this.Qgm;
                }
                catch (Throwable localThrowable)
                {
                  try
                  {
                    for (;;)
                    {
                      ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).removePrimaryClipChangedListener((ClipboardManager.OnPrimaryClipChangedListener)localObject1);
                      label2211:
                      localObject1 = this.Qgn;
                      if ((((com.tencent.mm.plugin.webview.r)localObject1).tipDialog != null) && (((com.tencent.mm.plugin.webview.r)localObject1).tipDialog.isShowing()))
                      {
                        ((com.tencent.mm.plugin.webview.r)localObject1).tipDialog.dismiss();
                        ((com.tencent.mm.plugin.webview.r)localObject1).tipDialog = null;
                      }
                      EventCenter.instance.removeListener(((com.tencent.mm.plugin.webview.r)localObject1).PFx);
                      localObject1 = this.PHI;
                      if (((p)localObject1).Hgr != null)
                      {
                        ((p)localObject1).Hgr.dead();
                        ((p)localObject1).Hgr = null;
                      }
                      this.PIQ.b(this.QgS);
                      this.PIQ.b(this.QgS.Qhi);
                      if (this.Qgl != null)
                      {
                        this.Qgl = null;
                        FactoryProxyManager.getPlayManager().setUtilsObject(null);
                      }
                      System.gc();
                      AppMethodBeat.o(80271);
                      return;
                      localRemoteException = localRemoteException;
                      Log.w("MicroMsg.WebviewReporter", "invokeAsResult error, %s", new Object[] { localRemoteException });
                      continue;
                      localObject2 = new StringBuffer();
                      ((StringBuffer)localObject2).append("iswebviewreadtime=1");
                      ((StringBuffer)localObject2).append("&publishid=");
                      ((StringBuffer)localObject2).append(localRemoteException.lpD);
                      ((StringBuffer)localObject2).append("&staytime=");
                      ((StringBuffer)localObject2).append(localRemoteException.fOa);
                      ((StringBuffer)localObject2).append("&allstaytime=");
                      ((StringBuffer)localObject2).append(System.currentTimeMillis() - localRemoteException.enterTime);
                      ((StringBuffer)localObject2).append("&maxscrolly=");
                      ((StringBuffer)localObject2).append(localRemoteException.PVv);
                      ((StringBuffer)localObject2).append("&totalscrolly=");
                      ((StringBuffer)localObject2).append(localRemoteException.LcP);
                      ((StringBuffer)localObject2).append("&scene=");
                      ((StringBuffer)localObject2).append(localRemoteException.scene);
                      ((StringBuffer)localObject2).append("&entertime=");
                      ((StringBuffer)localObject2).append(localRemoteException.enterTime);
                      ((StringBuffer)localObject2).append("&screenheight=");
                      ((StringBuffer)localObject2).append(com.tencent.mm.ci.a.ks(MMApplicationContext.getContext()));
                      Bundle localBundle = new Bundle();
                      localBundle.putString("reportString", ((StringBuffer)localObject2).toString());
                      try
                      {
                        com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localBundle, ak.a.PVw.getClass(), null);
                      }
                      catch (Exception localException1)
                      {
                        Log.printErrStackTrace("MicroMsg.WebviewReporter", (Throwable)localException1, "TopStory report", new Object[0]);
                      }
                      continue;
                      label2619:
                      com.tencent.mm.plugin.report.service.h.IzE.a(11575, new Object[] { localException1.fXu, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(j) });
                      continue;
                      label2664:
                      com.tencent.mm.plugin.report.service.h.IzE.a(11575, new Object[] { localException1.fXu, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(j) });
                      continue;
                      localException2 = localException2;
                      Log.e("MicroMsg.WebViewUI", "sync cookies failed : %s", new Object[] { localException2.getMessage() });
                      continue;
                      Log.w("MicroMsg.WebViewUI", "webview on destroy callback mm but eventclass is null");
                      continue;
                      localException3 = localException3;
                      Log.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", new Object[] { localException3.toString() });
                      continue;
                      localException4 = localException4;
                      Log.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", new Object[] { localException4.toString() });
                      continue;
                      localException5 = localException5;
                      Log.e("MicroMsg.WebViewUI", "deinit video player failed : %s", new Object[] { localException5.getMessage() });
                      continue;
                      this.PHJ.hbE();
                    }
                    localThrowable = localThrowable;
                    Log.w("MicroMsg.WebViewUI", "onDestroy contentView removeAllViews %s", new Object[] { localThrowable });
                  }
                  catch (Exception localException6)
                  {
                    break label2211;
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
    if (this.pHS != null) {
      this.pHS.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(215562);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$30", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$30", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(215562);
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
    Log.i("MicroMsg.WebViewUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 4)
    {
      if ((this.pHS != null) && (this.pHS.hasEnteredFullscreen()))
      {
        this.pHS.leaveFullscreen();
        AppMethodBeat.o(80274);
        return true;
      }
      if (this.PHJ.Dq(false))
      {
        AppMethodBeat.o(80274);
        return true;
      }
    }
    if ((paramInt == 4) && (this.bFK != null) && (this.QfE != null) && (this.QfF != null)) {
      try
      {
        this.QfF.onHideCustomView();
        ba.e.cI(elY(), 7);
        Dg(false);
        AppMethodBeat.o(80274);
        return true;
      }
      catch (Exception paramKeyEvent)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WebViewUI", paramKeyEvent, "onkeydown", new Object[0]);
        }
      }
    }
    if (paramInt == 4)
    {
      if ((this.Qfh != null) && (this.Qfh.isShown()))
      {
        this.Qfh.hide();
        gYW();
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(80274);
        return true;
      }
    }
    if (paramInt == 4)
    {
      if ((this.pHS != null) && (this.pHS.canGoBack()) && (this.Qfn))
      {
        gYI();
        ba.e.cI(elY(), 7);
        Dg(false);
        AppMethodBeat.o(80274);
        return true;
      }
      m.Qer.close();
      ba.e.cI(elY(), 8);
      Dg(true);
    }
    if ((paramInt == 4) && (gZb()) && (gUw()))
    {
      AppMethodBeat.o(80274);
      return true;
    }
    if ((paramInt == 4) && (this.Qgt != null) && (this.Qgt.zH(2)))
    {
      AppMethodBeat.o(80274);
      return true;
    }
    if ((paramInt == 4) && (this.Qgx != null) && (this.Qgx.bVd()))
    {
      this.Qgx.hide();
      AppMethodBeat.o(80274);
      return true;
    }
    if (paramInt == 4) {
      gZd();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(80274);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(80273);
    if ((paramInt == 82) && (!this.QgF))
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
    if (this.Qgs != null) {
      this.Qgs.aOj();
    }
    if (this.Qgt != null) {
      this.Qgt.aOj();
    }
    com.tencent.mm.modelstat.d.d(4, "WebViewUI_" + bjD(Util.nullAsNil(this.QfT)), this.PIQ.gSo());
    com.tencent.mm.modelstat.d.l("WebViewUI_" + bjD(Util.nullAsNil(this.QfT)), this.EIx, Util.nowSecond());
    Object localObject = this.PIx.gVZ();
    if (((ay)localObject).lastResumeTime != -1L) {
      ((ay)localObject).fOa += Util.ticksToNow(((ay)localObject).lastResumeTime) / 1000L;
    }
    localObject = this.PIx.gWa();
    if (((ak)localObject).lastResumeTime != -1L) {
      ((ak)localObject).fOa += Util.ticksToNow(((ak)localObject).lastResumeTime);
    }
    localObject = m.Qer;
    Log.v("MicroMsg.WebViewReportUtil", "onPause traceid %s", new Object[] { ((m)localObject).traceid });
    if (((m)localObject).lwF) {
      Log.i("MicroMsg.WebViewReportUtil", "isFinish is true");
    }
    try
    {
      if (this.pGC != null)
      {
        localObject = this.pGC.l(19, null);
        if (localObject != null)
        {
          boolean bool = ((Bundle)localObject).getBoolean("webview_video_proxy_init");
          Log.i("MicroMsg.WebViewUI", "onPause, has init = %b", new Object[] { Boolean.valueOf(bool) });
          if (bool) {
            FactoryProxyManager.getPlayManager().appToBack();
          }
        }
      }
      gYW();
      ScreenShotUtil.setScreenShotCallback(MMApplicationContext.getContext(), null);
      bkl("onPause");
      if (this.QfF != null) {
        Log.i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.QfF.onHideCustomView();
          this.PHJ.onPause();
          this.PHI.gZt();
          if (this.pHS != null) {
            this.pHS.onPause();
          }
          AppMethodBeat.o(80234);
          return;
          if (!Util.isNullOrNil(((m)localObject).traceid)) {
            ((m)localObject).rE(6);
          }
        }
        localException1 = localException1;
        Log.e("MicroMsg.WebViewUI", "notify app toback failed : %s", new Object[] { localException1.getMessage() });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WebViewUI", localException2, "onPause", new Object[0]);
        }
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(80242);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.WebViewUI", "onRequestPermissionsResult grantResults length 0. requestCode=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(80242);
      return;
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    com.tencent.luggage.k.f.aI(this).b(paramInt, paramArrayOfInt);
    paramArrayOfString = this.pGM;
    if (paramArrayOfString.PWQ == null)
    {
      paramArrayOfString.gWl();
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
          break label144;
        }
        paramArrayOfInt = (Intent)paramArrayOfString.PWQ.first;
        paramInt = ((Integer)paramArrayOfString.PWQ.second).intValue();
        paramArrayOfString.PWQ = null;
        startActivityForResult(paramArrayOfInt, paramInt);
      }
      for (;;)
      {
        paramInt = 1;
        break;
        label144:
        paramArrayOfString.PWQ = null;
        paramArrayOfString.c(this, 0, null);
      }
    }
    AppMethodBeat.o(80242);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80233);
    super.onResume();
    if (this.Qgs != null) {
      this.Qgs.bNV();
    }
    if (this.Qgt != null) {
      this.Qgt.bNV();
    }
    if (elY() != null) {
      com.tencent.mm.plugin.webview.k.p.l(elY(), this);
    }
    for (;;)
    {
      this.PIx.gVZ().lastResumeTime = Util.currentTicks();
      this.PIx.gWa().lastResumeTime = Util.currentTicks();
      Object localObject1 = m.Qer;
      Log.v("MicroMsg.WebViewReportUtil", "onResume traceid %s", new Object[] { ((m)localObject1).traceid });
      if (!Util.isNullOrNil(((m)localObject1).traceid)) {
        ((m)localObject1).rE(7);
      }
      int i;
      if (!this.QgB)
      {
        int j = this.PIQ.gSo();
        i = QfC.size() - 1;
        if (i >= 0)
        {
          if (((e)QfC.get(i)).id == j) {
            QfC.remove(i);
          }
        }
        else {
          QfC.add(new e(this));
        }
      }
      else
      {
        this.QgB = false;
        if (this.QfD)
        {
          CT(true);
          this.QfD = false;
        }
        gYL();
        updateOrientation();
        if ((getIntent().getBooleanExtra("disable_swipe_back", false)) && (getSwipeBackLayout() != null)) {
          getSwipeBackLayout().setEnableGesture(false);
        }
      }
      try
      {
        ScreenShotUtil.setScreenShotCallback(MMApplicationContext.getContext(), this);
        bkl("onResume");
        try
        {
          if (this.pGC != null)
          {
            localObject1 = this.pGC.l(19, null);
            if (localObject1 != null)
            {
              boolean bool = ((Bundle)localObject1).getBoolean("webview_video_proxy_init");
              Log.i("MicroMsg.WebViewUI", "onResume, has init = %b", new Object[] { Boolean.valueOf(bool) });
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
            Object localObject2;
            Log.e("MicroMsg.WebViewUI", "notify app tofront failed : %s", new Object[] { localException2.getMessage() });
            continue;
            if (p.bz((Bundle)localObject2))
            {
              localObject2 = ((Bundle)localObject2).getString("key_brand_user_name");
              ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).cyH();
              localException2.apt((String)localObject2);
            }
          }
        }
        this.EIx = Util.nowSecond();
        com.tencent.mm.plugin.webview.a.a.am(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(241881);
            com.tencent.mm.modelstat.d.d(3, "WebViewUI_" + WebViewUI.this.bjD(Util.nullAsNil(WebViewUI.this.QfT)), WebViewUI.this.PIQ.gSo());
            AppMethodBeat.o(241881);
          }
        });
        if (this.Qgg) {
          finish();
        }
        if ((this.Qfa != null) && (this.Qfa.Qdk))
        {
          hideVKB();
          this.Qfa.SG(-2);
        }
        this.PHJ.onResume();
        localObject1 = this.PHI;
        if (p.gZs())
        {
          localObject2 = (Bundle)p.BrL.get(p.apf(((p)localObject1).pHO));
          if ((localObject2 != null) && (((p)localObject1).QcD != null)) {}
        }
        else
        {
          if (this.pHS != null) {
            this.pHS.onResume();
          }
          AppMethodBeat.o(80233);
          return;
          com.tencent.mm.plugin.webview.k.p.l(cDu(), this);
          continue;
          i -= 1;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Log.w("MicroMsg.WebViewUI", "setScreenShotCallback fail e:%s", new Object[] { localException1.getMessage() });
        }
      }
    }
  }
  
  public void onScreenShot(String paramString, long paramLong)
  {
    AppMethodBeat.i(219830);
    if ((this.PvJ != null) && (this.pHS != null))
    {
      Object localObject1 = this.PvJ;
      this.pHS.getUrl();
      Object localObject2 = getIntent();
      if ((this.pGD.gWJ().RAZ & 0x100000) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.GeneralControlWrapper", "allowOnScreenShot, ret = ".concat(String.valueOf(bool)));
        if (!((com.tencent.mm.plugin.webview.d.h)localObject1).NoX) {
          break label388;
        }
        Log.i("MicroMsg.JsApiHandler", "onScreenShot hasPermission: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramString = n.a.b("onScreenShot", new HashMap(), ((com.tencent.mm.plugin.webview.d.h)localObject1).PNx, ((com.tencent.mm.plugin.webview.d.h)localObject1).EVx);
          ((com.tencent.mm.plugin.webview.d.h)localObject1).PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
        }
        paramString = ((com.tencent.mm.plugin.webview.d.h)localObject1).bjW(((com.tencent.mm.plugin.webview.d.h)localObject1).getCurrentUrl());
        if (localObject2 == null) {
          break label388;
        }
        try
        {
          localObject1 = ((com.tencent.mm.plugin.webview.d.h)localObject1).getCurrentUrl();
          localObject2 = ((Intent)localObject2).getBundleExtra("ad_report_bundle");
          if ((!Util.isNullOrNil((String)localObject1)) && (localObject2 != null))
          {
            localObject2 = ((Bundle)localObject2).getString("ad_report_ux_info");
            if (!Util.isNullOrNil((String)localObject2))
            {
              int i = (int)(System.currentTimeMillis() / 1000L);
              Object localObject3 = Uri.parse((String)localObject1);
              String str = ((Uri)localObject3).getQueryParameter("mid");
              localObject3 = ((Uri)localObject3).getQueryParameter("idx");
              Log.i("MicroMsg.JsApiHandler", "alvinluo reportAdOnScreenShot appId: %s, mid: %s, idx: %s, adUxInfo: %s, url: %s", new Object[] { paramString, str, localObject3, localObject2, localObject1 });
              com.tencent.mm.plugin.report.service.h.IzE.a(19213, new Object[] { Integer.valueOf(i), Integer.valueOf(6), localObject2, paramString, str, localObject3, localObject1 });
            }
          }
          AppMethodBeat.o(219830);
          return;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "alvinluo reportAdOnScreenShot exception", new Object[0]);
        }
      }
    }
    label388:
    AppMethodBeat.o(219830);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(80266);
    super.onStart();
    if ((this.Qgq != null) && (gUC()))
    {
      Log.i("MicroMsg.WebViewUI", "[Handoff] onStart, call onWebViewCreate " + this.Qgq.toString());
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).a(this.Qgq);
    }
    Log.i("MicroMsg.WebViewUI", "edw onStart");
    AppMethodBeat.o(80266);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(80267);
    Log.i("MicroMsg.WebViewUI", "edw onStop");
    if ((this.Qgq != null) && (gUC()))
    {
      Log.i("MicroMsg.WebViewUI", "[Handoff] onStop, call onWebViewDestroy " + this.Qgq.toString());
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).b(this.Qgq);
    }
    this.QeT.finish();
    Dh(true);
    super.onStop();
    AppMethodBeat.o(80267);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(80290);
    hideVKB();
    super.onSwipeBack();
    AppMethodBeat.o(80290);
  }
  
  public boolean onSwipeBackFinish()
  {
    AppMethodBeat.i(80293);
    this.Qge = true;
    ba.e.cI(elY(), 2);
    boolean bool = super.onSwipeBackFinish();
    AppMethodBeat.o(80293);
    return bool;
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(80261);
    Object localObject;
    if ((this.PHI != null) && (!this.PHI.Qhl))
    {
      localObject = this.PHI;
      if (Util.isNullOrNil(((p)localObject).pHO)) {
        ((p)localObject).pHO = Util.nullAsNil(((p)localObject).QcD.elY());
      }
      ((p)localObject).Qhm.PFd.setValue(Integer.valueOf(paramInt2));
      ((p)localObject).gZu();
    }
    long l;
    if (this.QeW != null)
    {
      localObject = this.QeW;
      if (((j)localObject).QcN)
      {
        l = System.currentTimeMillis();
        if (((j)localObject).QcK == 0L)
        {
          ((j)localObject).QcK = l;
          ((j)localObject).QcL = paramInt2;
        }
        if ((Math.abs(l - ((j)localObject).QcK) > 200L) && (Math.abs(paramInt2 - ((j)localObject).QcL) > ((j)localObject).QcM))
        {
          if ((paramInt2 - ((j)localObject).QcL <= 0) || (((j)localObject).QcS.getVisibility() != 0)) {
            break label207;
          }
          ((j)localObject).gXD();
        }
      }
    }
    for (;;)
    {
      ((j)localObject).QcK = l;
      ((j)localObject).QcL = paramInt2;
      AppMethodBeat.o(80261);
      return;
      label207:
      if ((paramInt2 - ((j)localObject).QcL < 0) && (((j)localObject).QcS.getVisibility() != 0)) {
        ((j)localObject).gXC();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(80283);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.PvJ != null) {
      this.PvJ.onWindowFocusChanged(paramBoolean);
    }
    if ((paramBoolean) && (gYM())) {
      aH(getWindow().getDecorView(), 5894);
    }
    AppMethodBeat.o(80283);
  }
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(80221);
    super.setActionbarColor(paramInt);
    if ((Build.VERSION.SDK_INT >= 21) && (this.Cwk != null))
    {
      this.Cwk.setBackgroundColor(getWindow().getStatusBarColor());
      com.tencent.mm.ui.statusbar.d.e(getWindow());
    }
    AppMethodBeat.o(80221);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    AppMethodBeat.i(80363);
    super.setBackBtn(paramOnMenuItemClickListener, paramInt);
    if ((com.tencent.mm.compatible.util.d.qV(21)) && (gYC())) {
      setBackBtnColorFilter(-16777216);
    }
    AppMethodBeat.o(80363);
  }
  
  public void setMMOrientation()
  {
    AppMethodBeat.i(80263);
    if (getForceOrientation() == -1)
    {
      this.landscapeMode = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 4).getBoolean("settings_landscape_mode", false);
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
    bmk(paramCharSequence.toString());
    bml(paramCharSequence.toString());
    AppMethodBeat.o(80238);
  }
  
  public void setMMTitle(String paramString)
  {
    AppMethodBeat.i(80237);
    super.setMMTitle(paramString);
    bmk(paramString);
    bml(paramString);
    AppMethodBeat.o(80237);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(219946);
    this.PJe = paramInt;
    updateOrientation();
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(219946);
  }
  
  @TargetApi(21)
  public final void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(80258);
    View localView = getContentView();
    if (!au.auk(paramInt)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.ui.statusbar.a.f(localView, paramInt, bool);
      AppMethodBeat.o(80258);
      return;
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
    if (this.QgT == -3)
    {
      this.QgT = -2;
      AppMethodBeat.o(80362);
      return;
    }
    this.QgT = -3;
    AppMethodBeat.o(80362);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(80369);
    if (Util.isEqual(paramIntent.getType(), "application/vnd.android.package-archive"))
    {
      com.tencent.mm.pluginsdk.model.app.r.i(MMApplicationContext.getContext(), paramIntent.getData());
      AppMethodBeat.o(80369);
      return;
    }
    super.startActivity(paramIntent);
    AppMethodBeat.o(80369);
  }
  
  protected final void t(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220037);
    if (this.Qfh == null)
    {
      AppMethodBeat.o(220037);
      return;
    }
    this.Qfh.show();
    if (paramString1 != null) {
      this.Qfh.setText(paramString1);
    }
    for (;;)
    {
      if (paramInt1 >= 0)
      {
        this.Qfh.setMaxCount(paramInt1);
        this.Qfh.setShowRemindWordCount(paramInt2);
      }
      AppMethodBeat.o(220037);
      return;
      if (!Util.isNullOrNil(paramString2)) {
        this.Qfh.setPlaceholder(paramString2);
      }
    }
  }
  
  protected void vI(boolean paramBoolean) {}
  
  protected static final class a
  {
    private String PRD;
    private String PRE;
    private String PRF;
    private String PRG;
    private String PRH;
    private String PRI;
    private String Qhd;
    private String lang;
    
    private a(Bundle paramBundle)
    {
      AppMethodBeat.i(80123);
      this.Qhd = paramBundle.getString("close_window_confirm_dialog_switch");
      this.PRD = paramBundle.getString("close_window_confirm_dialog_title_cn");
      this.PRE = paramBundle.getString("close_window_confirm_dialog_title_eng");
      this.PRF = paramBundle.getString("close_window_confirm_dialog_ok_cn");
      this.PRG = paramBundle.getString("close_window_confirm_dialog_ok_eng");
      this.PRH = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
      this.PRI = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
      this.lang = paramBundle.getString("application_language");
      AppMethodBeat.o(80123);
    }
    
    public static a aZ(Bundle paramBundle)
    {
      AppMethodBeat.i(80124);
      paramBundle = new a(paramBundle);
      AppMethodBeat.o(80124);
      return paramBundle;
    }
    
    public final boolean gVc()
    {
      AppMethodBeat.i(80125);
      if (Util.isNullOrNil(this.Qhd))
      {
        AppMethodBeat.o(80125);
        return false;
      }
      boolean bool = this.Qhd.equals("true");
      AppMethodBeat.o(80125);
      return bool;
    }
    
    public final String gVe()
    {
      AppMethodBeat.i(80127);
      if ("zh_CN".equals(this.lang))
      {
        str = this.PRF;
        AppMethodBeat.o(80127);
        return str;
      }
      String str = this.PRG;
      AppMethodBeat.o(80127);
      return str;
    }
    
    public final String gVf()
    {
      AppMethodBeat.i(80128);
      if ("zh_CN".equals(this.lang))
      {
        str = this.PRH;
        AppMethodBeat.o(80128);
        return str;
      }
      String str = this.PRI;
      AppMethodBeat.o(80128);
      return str;
    }
    
    public final String gZn()
    {
      AppMethodBeat.i(80126);
      if ("zh_CN".equals(this.lang))
      {
        str = this.PRD;
        AppMethodBeat.o(80126);
        return str;
      }
      String str = this.PRE;
      AppMethodBeat.o(80126);
      return str;
    }
  }
  
  public class b
    extends com.tencent.xweb.x
  {
    private com.tencent.mm.plugin.webview.modeltools.i Qhe;
    public volatile boolean jTm;
    com.tencent.mm.ui.widget.a.d nnz;
    
    protected b()
    {
      AppMethodBeat.i(80144);
      this.jTm = false;
      this.Qhe = new com.tencent.mm.plugin.webview.modeltools.i();
      this.nnz = null;
      AppMethodBeat.o(80144);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(80148);
      Log.d("MicroMsg.WebViewUI", "onProgressChanged %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(80148);
    }
    
    public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(80145);
      WebViewUI.this.Di(true);
      com.tencent.mm.plugin.ball.f.f.d(true, true, false);
      if (WebViewUI.this.gTP().POV)
      {
        MPVideoPlayFullScreenView localMPVideoPlayFullScreenView = WebViewUI.this.gYt();
        Context localContext = localMPVideoPlayFullScreenView.getContext();
        if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).pHS != null)) {
          localMPVideoPlayFullScreenView.Qty = ((WebViewUI)localContext).pHS.setVideoJsCallback((com.tencent.xweb.v)new MPVideoPlayFullScreenView.i(localMPVideoPlayFullScreenView));
        }
        if (localMPVideoPlayFullScreenView.Qty != null) {}
        for (int i = 1; i != 0; i = 0)
        {
          WebViewUI.a(WebViewUI.this, paramCustomViewCallback);
          Log.i("MicroMsg.WebViewUI", "onEnterFullscreen view");
          if (paramView.getParent() == null) {
            WebViewUI.this.gYt().hp(paramView);
          }
          AppMethodBeat.o(80145);
          return true;
        }
      }
      if (WebViewUI.this.gTP().POV) {
        WebViewUI.this.gTP().CW(false);
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
          Log.i("MicroMsg.WebViewUI", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
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
          WebViewUI.s(WebViewUI.this).a(WebViewUI.this, WebViewUI.this.pGD, null, paramValueCallback, str2, paramWebView);
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
      Log.d("MicroMsg.WebViewUI", "onJsAlert");
      final PBool localPBool = new PBool();
      localPBool.value = false;
      if ((WebViewUI.this.isFinishing()) || (WebViewUI.this.activityHasDestroyed()))
      {
        Log.d("MicroMsg.WebViewUI", "onJsAlert finish");
        paramJsResult.cancel();
        AppMethodBeat.o(80158);
        return true;
      }
      WebViewUI.t(WebViewUI.this);
      if (WebViewUI.u(WebViewUI.this) > 2) {}
      for (this.nnz = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(c.i.wv_close_webview), WebViewUI.this.getString(c.i.app_ok), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80140);
              com.tencent.mm.plugin.report.service.h.IzE.a(11683, new Object[] { paramString1, Integer.valueOf(1), Integer.valueOf(WebViewUI.u(WebViewUI.this)) });
              paramJsResult.cancel();
              if (paramAnonymousDialogInterface != null) {
                paramAnonymousDialogInterface.dismiss();
              }
              WebViewUI.this.finish();
              AppMethodBeat.o(80140);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(216392);
              localPBool.value = true;
              paramJsResult.confirm();
              AppMethodBeat.o(216392);
            }
          }, c.c.link_color); this.nnz != null; this.nnz = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(c.i.app_ok), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80142);
              localPBool.value = true;
              paramJsResult.confirm();
              AppMethodBeat.o(80142);
            }
          }))
      {
        this.nnz.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(222658);
            Log.d("MicroMsg.WebViewUI", "onJsAlert, onDismiss");
            if (!localPBool.value) {
              paramJsResult.cancel();
            }
            AppMethodBeat.o(222658);
          }
        });
        this.nnz.setCanceledOnTouchOutside(false);
        this.nnz.HD(false);
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
      Log.i("MicroMsg.WebViewUI", "onJsConfirm");
      final PBool localPBool = new PBool();
      localPBool.value = false;
      if ((WebViewUI.this.isFinishing()) || (WebViewUI.this.activityHasDestroyed()))
      {
        Log.i("MicroMsg.WebViewUI", "onJsConfirm finish");
        paramJsResult.cancel();
        AppMethodBeat.o(80156);
        return true;
      }
      WebViewUI.t(WebViewUI.this);
      if (WebViewUI.u(WebViewUI.this) > 2) {}
      for (this.nnz = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(c.i.wv_close_webview), WebViewUI.this.getString(c.i.app_ok), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80133);
              com.tencent.mm.plugin.report.service.h.IzE.a(11683, new Object[] { paramString1, Integer.valueOf(1), Integer.valueOf(WebViewUI.u(WebViewUI.this)) });
              paramJsResult.cancel();
              if (paramAnonymousDialogInterface != null) {
                paramAnonymousDialogInterface.dismiss();
              }
              Log.i("MicroMsg.WebViewUI", "onJsConfirm cancel and finish %d", new Object[] { Integer.valueOf(WebViewUI.u(WebViewUI.this)) });
              WebViewUI.this.finish();
              AppMethodBeat.o(80133);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80136);
              localPBool.value = true;
              paramJsResult.confirm();
              Log.i("MicroMsg.WebViewUI", "onJsConfirm confirm %d", new Object[] { Integer.valueOf(WebViewUI.u(WebViewUI.this)) });
              AppMethodBeat.o(80136);
            }
          }, c.c.btn_green_color_normal); this.nnz != null; this.nnz = com.tencent.mm.ui.base.h.a(WebViewUI.this.getContext(), false, paramString2, "", WebViewUI.this.getString(c.i.app_ok), WebViewUI.this.getString(c.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80137);
              localPBool.value = true;
              paramJsResult.confirm();
              Log.i("MicroMsg.WebViewUI", "onJsConfirm confirm %d", new Object[] { Integer.valueOf(WebViewUI.u(WebViewUI.this)) });
              AppMethodBeat.o(80137);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80138);
              paramJsResult.cancel();
              Log.i("MicroMsg.WebViewUI", "onJsConfirm cancel %d", new Object[] { Integer.valueOf(WebViewUI.u(WebViewUI.this)) });
              AppMethodBeat.o(80138);
            }
          }))
      {
        this.nnz.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(228062);
            Log.i("MicroMsg.WebViewUI", "onJsConfirm, onDismiss %d, %b", new Object[] { Integer.valueOf(WebViewUI.u(WebViewUI.this)), Boolean.valueOf(localPBool.value) });
            if (!localPBool.value) {
              paramJsResult.cancel();
            }
            AppMethodBeat.o(228062);
          }
        });
        this.nnz.setCancelable(false);
        this.nnz.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(80156);
        return true;
      }
      boolean bool = super.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(80156);
      return bool;
    }
    
    public final boolean bXA()
    {
      AppMethodBeat.i(80146);
      WebViewUI.this.Di(false);
      com.tencent.mm.plugin.ball.f.f.d(false, true, false);
      boolean bool = super.bXA();
      AppMethodBeat.o(80146);
      return bool;
    }
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80149);
      Log.i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", new Object[] { paramString, WebViewUI.this.PIQ.PFK });
      super.d(paramWebView, paramString);
      if ((WebViewUI.this.QeR) && (!WebViewUI.n(WebViewUI.this)))
      {
        Log.i("MicroMsg.WebViewUI", "fixed title, ignore received title: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(80149);
        return;
      }
      if (paramString == null)
      {
        Log.e("MicroMsg.WebViewUI", "null title");
        AppMethodBeat.o(80149);
        return;
      }
      if (!WebViewUI.this.IYi)
      {
        AppMethodBeat.o(80149);
        return;
      }
      if ((!Util.nullAsNil(WebViewUI.this.PIQ.PFK).equals(paramString)) && (!com.tencent.mm.plugin.webview.luggage.c.c.ane(paramString)) && (!paramString.startsWith("about:blank"))) {
        WebViewUI.this.setMMTitle(paramString);
      }
      AppMethodBeat.o(80149);
    }
    
    public final View getVideoLoadingProgressView()
    {
      AppMethodBeat.i(80152);
      if (WebViewUI.r(WebViewUI.this) == null)
      {
        WebViewUI.a(WebViewUI.this, new ProgressBar(WebViewUI.this));
        WebViewUI.r(WebViewUI.this).setIndeterminate(true);
      }
      ProgressBar localProgressBar = WebViewUI.r(WebViewUI.this);
      AppMethodBeat.o(80152);
      return localProgressBar;
    }
    
    public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(267828);
      com.tencent.luggage.sdk.h.f.a(paramConsoleMessage, "MicroMsg.WebViewUI");
      boolean bool = super.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(267828);
      return bool;
    }
    
    public final void onExitFullscreenVideo(Bitmap paramBitmap)
    {
      AppMethodBeat.i(80147);
      MPVideoPlayFullScreenView localMPVideoPlayFullScreenView;
      if ((WebViewUI.this.PvJ != null) && (WebViewUI.this.gTP().POV) && (WebViewUI.this.gYt().getVisibility() == 0))
      {
        if (WebViewUI.m(WebViewUI.this) != null) {
          WebViewUI.m(WebViewUI.this).onCustomViewHidden();
        }
        WebViewUI.this.gTP().CW(false);
        localMPVideoPlayFullScreenView = WebViewUI.this.gYt();
        if (!localMPVideoPlayFullScreenView.MfK) {
          break label131;
        }
        Log.i(localMPVideoPlayFullScreenView.TAG, "isRunningExitAnimation");
      }
      for (;;)
      {
        if (WebViewUI.this.PHI != null) {
          WebViewUI.this.PHI.gZx();
        }
        AppMethodBeat.o(80147);
        return;
        label131:
        localMPVideoPlayFullScreenView.hbi();
        if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
        {
          localObject = new ImageView(localMPVideoPlayFullScreenView.getContext());
          ViewGroup localViewGroup = localMPVideoPlayFullScreenView.Qtr;
          if (localViewGroup != null) {
            localViewGroup.addView((View)localObject, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
          }
          ((ImageView)localObject).setImageBitmap(paramBitmap);
        }
        Log.i(localMPVideoPlayFullScreenView.TAG, "runExitAnimation");
        localMPVideoPlayFullScreenView.hbk();
        int j = localMPVideoPlayFullScreenView.Qto.getWidth();
        int i = localMPVideoPlayFullScreenView.Qto.getHeight();
        paramBitmap = localMPVideoPlayFullScreenView.twB;
        if (paramBitmap != null) {
          paramBitmap.mJ(j, i);
        }
        paramBitmap = localMPVideoPlayFullScreenView.twB;
        int k;
        if (paramBitmap != null)
        {
          localObject = localMPVideoPlayFullScreenView.llv;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          j = ((y)localObject).lqj;
          localObject = localMPVideoPlayFullScreenView.llv;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          k = ((y)localObject).lqk;
          localObject = localMPVideoPlayFullScreenView.llv;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          int m = ((y)localObject).lql;
          localObject = localMPVideoPlayFullScreenView.llv;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          paramBitmap.V(j, k, m, ((y)localObject).lqm);
        }
        if (localMPVideoPlayFullScreenView.KOu != 1.0D)
        {
          paramBitmap = localMPVideoPlayFullScreenView.twB;
          if (paramBitmap != null) {
            paramBitmap.XRS = (1.0F / localMPVideoPlayFullScreenView.KOu);
          }
          if ((localMPVideoPlayFullScreenView.KOv != 0) || (localMPVideoPlayFullScreenView.KOw != 0))
          {
            j = (int)(localMPVideoPlayFullScreenView.Qto.getWidth() / 2 * (1.0F - localMPVideoPlayFullScreenView.KOu));
            k = localMPVideoPlayFullScreenView.KOv;
            i = (int)(localMPVideoPlayFullScreenView.Qto.getHeight() / 2 + localMPVideoPlayFullScreenView.KOw - i / 2 * localMPVideoPlayFullScreenView.KOu);
            paramBitmap = localMPVideoPlayFullScreenView.twB;
            if (paramBitmap != null) {
              paramBitmap.mL(j + k, i);
            }
          }
        }
        paramBitmap = localMPVideoPlayFullScreenView.Qto.getLayoutParams();
        Object localObject = localMPVideoPlayFullScreenView.twB;
        if (localObject != null) {
          ((com.tencent.mm.ui.tools.f)localObject).a((View)localMPVideoPlayFullScreenView.Qtr, localMPVideoPlayFullScreenView.Qto, (f.c)new MPVideoPlayFullScreenView.q(localMPVideoPlayFullScreenView, paramBitmap), null);
        }
      }
    }
    
    public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(80153);
      this.Qhe.a(WebViewUI.this, WebViewUI.this.elY(), WebViewUI.this.cDu(), WebViewUI.this.PIQ.bXC(), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), paramString, paramCallback);
      AppMethodBeat.o(80153);
    }
    
    public final void onHideCustomView()
    {
      AppMethodBeat.i(80151);
      Log.i("MicroMsg.WebViewUI", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
      WebViewUI.this.getContext().getWindow().clearFlags(128);
      if (WebViewUI.o(WebViewUI.this) == null)
      {
        AppMethodBeat.o(80151);
        return;
      }
      try
      {
        WebViewUI.this.Dd(WebViewUI.this.gYX());
        if (!WebViewUI.this.pHS.isXWalkKernel())
        {
          WebViewUI.this.pHS.setVisibility(0);
          WebViewUI.this.setTitleVisibility(0);
        }
        for (;;)
        {
          if (WebViewUI.this.Qfc != null) {
            WebViewUI.this.Qfc.removeView(WebViewUI.o(WebViewUI.this));
          }
          WebViewUI.a(WebViewUI.this, null);
          if (WebViewUI.q(WebViewUI.this) != null) {
            WebViewUI.q(WebViewUI.this).onCustomViewHidden();
          }
          WebViewUI.this.Di(false);
          AppMethodBeat.o(80151);
          return;
          WebViewUI.this.fullScreenNoTitleBar(false);
          WebViewUI.this.setStatusBarColor(WebViewUI.this.getResources().getColor(c.c.status_bar_color));
          if (WebViewUI.this.QgD != null)
          {
            ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)WebViewUI.this.QgD.getLayoutParams();
            int i = WebViewUI.p(WebViewUI.this);
            if (i != localMarginLayoutParams.topMargin)
            {
              localMarginLayoutParams.topMargin = i;
              WebViewUI.this.QgD.setLayoutParams(localMarginLayoutParams);
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.WebViewUI", "onHideCustomView error " + localException.getMessage());
        AppMethodBeat.o(80151);
      }
    }
    
    public final void onPermissionRequest(PermissionRequest paramPermissionRequest)
    {
      AppMethodBeat.i(267827);
      this.Qhe.a(paramPermissionRequest, WebViewUI.this, WebViewUI.this.elY());
      AppMethodBeat.o(267827);
    }
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(80150);
      Log.i("MicroMsg.WebViewUI", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
      try
      {
        WebViewUI.this.getContext().getWindow().addFlags(128);
        if (WebViewUI.o(WebViewUI.this) != null)
        {
          paramCustomViewCallback.onCustomViewHidden();
          AppMethodBeat.o(80150);
          return;
        }
        WebViewUI.this.Dd(false);
        WebViewUI.a(WebViewUI.this, paramView);
        WebViewUI.b(WebViewUI.this, paramCustomViewCallback);
        if (!WebViewUI.this.pHS.isXWalkKernel())
        {
          WebViewUI.this.pHS.setVisibility(8);
          WebViewUI.this.Qfc.addView(paramView);
          WebViewUI.this.setTitleVisibility(4);
        }
        for (;;)
        {
          WebViewUI.this.Di(true);
          AppMethodBeat.o(80150);
          return;
          WebViewUI.this.Qfc.addView(paramView, 0);
          WebViewUI.this.fullScreenNoTitleBar(true);
          WebViewUI.this.setStatusBarColor(0);
          if (WebViewUI.this.QgD != null)
          {
            paramView = (ViewGroup.MarginLayoutParams)WebViewUI.this.QgD.getLayoutParams();
            paramView.topMargin = 0;
            WebViewUI.this.QgD.setLayoutParams(paramView);
          }
        }
        return;
      }
      catch (Exception paramView)
      {
        Log.e("MicroMsg.WebViewUI", "onShowCustomView error " + paramView.getMessage());
        AppMethodBeat.o(80150);
      }
    }
    
    public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      AppMethodBeat.i(80154);
      WebViewUI.s(WebViewUI.this).a(WebViewUI.this, WebViewUI.this.pGD, paramValueCallback, null, paramString1, paramString2);
      AppMethodBeat.o(80154);
    }
  }
  
  protected final class c
    extends com.tencent.mm.plugin.webview.core.k
  {
    a Qhi;
    private b Qhj;
    
    public c()
    {
      AppMethodBeat.i(218467);
      this.Qhi = new a((byte)0);
      this.Qhj = new b((byte)0);
      AppMethodBeat.o(218467);
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2)
    {
      return false;
    }
    
    public final com.tencent.mm.plugin.webview.core.j bXJ()
    {
      return this.Qhj;
    }
    
    public final boolean gTa()
    {
      AppMethodBeat.i(218469);
      if ((WebViewUI.this.Qgc) || (WebViewUI.v(WebViewUI.this)) || (WebViewUI.this.isFinishing()))
      {
        AppMethodBeat.o(218469);
        return true;
      }
      AppMethodBeat.o(218469);
      return false;
    }
    
    public final com.tencent.mm.plugin.webview.core.f gTb()
    {
      return this.Qhi;
    }
    
    public final int getScreenOrientation()
    {
      return WebViewUI.this.PJe;
    }
    
    final class a
      extends com.tencent.mm.plugin.webview.core.f
    {
      private a() {}
      
      public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
      {
        WebViewUI.this.Qgk.QdC = false;
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(214429);
        if ((WebViewUI.x(WebViewUI.this) != null) && (NetStatusUtil.isConnected(MMApplicationContext.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8")))
        {
          WebViewUI.x(WebViewUI.this).fi("rawUrl", paramString);
          WebViewUI.x(WebViewUI.this).bko(paramString);
        }
        if ((WebViewUI.y(WebViewUI.this) != null) && (NetStatusUtil.isConnected(MMApplicationContext.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8"))) {
          WebViewUI.y(WebViewUI.this).setRawUrl(paramString);
        }
        WebViewUI.e(WebViewUI.this, paramString);
        if (!WebViewUI.z(WebViewUI.this))
        {
          WebViewUI.A(WebViewUI.this);
          WebViewUI.this.PIx.gWc().loadFinished = true;
        }
        Object localObject = WebViewUI.this.pHS.getTitle();
        Log.i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", new Object[] { WebViewUI.this.getMMTitle(), localObject, Boolean.valueOf(WebViewUI.this.QeR), Boolean.valueOf(WebViewUI.this.IYi), WebViewUI.this.PIQ.PFK });
        if ((WebViewUI.c.this.controller.pHS.getIsX5Kernel()) && (!Util.isNullOrNil((String)localObject)) && (((String)localObject).length() > 0) && (!((String)localObject).equals(WebViewUI.this.getMMTitle())) && (!((String)localObject).startsWith("http")) && ((WebViewUI.this.PIQ.PFK == null) || (!WebViewUI.this.PIQ.PFK.equals(localObject))) && (!WebViewUI.this.QeR) && (WebViewUI.this.IYi))
        {
          Log.d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
          WebViewUI.this.setMMTitle((String)localObject);
        }
        WebViewUI.this.QgG.bmj(WebViewUI.this.elY());
        WebViewUI.this.setProgressBarIndeterminateVisibility(false);
        WebViewUI.this.QeT.finish();
        if ((WebViewUI.this.PHI != null) && (!WebViewUI.this.PHI.Qhl))
        {
          localObject = WebViewUI.this.PHI;
          Log.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", new Object[] { paramString });
          ((p)localObject).pHO = paramString;
        }
        WebViewUI.f(WebViewUI.this, paramString);
        WebViewUI.this.b(paramWebView, paramString);
        AppMethodBeat.o(214429);
      }
      
      public final void bjz(String paramString)
      {
        AppMethodBeat.i(214431);
        WebViewUI.this.QgG.gYe();
        if ((WebViewUI.x(WebViewUI.this) != null) && (NetStatusUtil.isConnected(MMApplicationContext.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8")))
        {
          WebViewUI.x(WebViewUI.this).fi("rawUrl", paramString);
          WebViewUI.x(WebViewUI.this).bko(paramString);
        }
        if ((WebViewUI.y(WebViewUI.this) != null) && (NetStatusUtil.isConnected(MMApplicationContext.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8"))) {
          WebViewUI.y(WebViewUI.this).setRawUrl(paramString);
        }
        WebViewUI.e(WebViewUI.this, paramString);
        WebViewUI.this.Dd(WebViewUI.this.gYX());
        AppMethodBeat.o(214431);
      }
      
      public final void e(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(214432);
        super.e(paramWebView, paramString);
        paramWebView = WebViewUI.this.PHI;
        Log.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", new Object[] { paramString });
        paramWebView.pHO = paramString;
        AppMethodBeat.o(214432);
      }
      
      public final void h(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(214425);
        if (!WebViewUI.this.QgL) {
          WebViewUI.this.Qgk.gXV();
        }
        WebViewUI.this.QgG.gYe();
        WebViewUI.this.QgG.bmj(paramString);
        WebViewUI.this.setProgressBarIndeterminateVisibility(false);
        WebViewUI.this.Qgk.g(paramString, WebViewUI.this.getIntent());
        WebViewUI.this.Dh(false);
        if ((WebViewUI.this.PHI != null) && (!WebViewUI.this.PHI.Qhl))
        {
          paramWebView = WebViewUI.this.PHI;
          Log.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageStart, url:%s", new Object[] { paramString });
          paramWebView.pHO = paramString;
          paramWebView.gZp();
          paramWebView.gZx();
        }
        WebViewUI.w(WebViewUI.this);
        AppMethodBeat.o(214425);
      }
    }
    
    final class b
      extends com.tencent.mm.plugin.webview.core.j
    {
      private b() {}
      
      public final void CN(boolean paramBoolean)
      {
        AppMethodBeat.i(215061);
        if ((paramBoolean) && (WebViewUI.this.pHS != null))
        {
          WebViewUI.this.pHS.setOnLongClickListener(WebViewUI.B(WebViewUI.this));
          WebViewUI.C(WebViewUI.this);
        }
        AppMethodBeat.o(215061);
      }
      
      public final void a(String paramString, bot parambot)
      {
        AppMethodBeat.i(215043);
        WebViewUI.this.pHq = parambot.Tao;
        WebViewUI.b(WebViewUI.this, WebViewUI.this.pGD.gWI().so(24));
        WebViewUI.this.PIx.gWc().PWw = true;
        WebViewUI.this.Qfz = z.a(parambot.Taj);
        Log.d("MicroMsg.WebViewUI", "onPermissionUpdate, getA8Key = %s", new Object[] { Util.encodeHexString(WebViewUI.this.Qfz) });
        AppMethodBeat.o(215043);
      }
      
      public final void anz(int paramInt)
      {
        AppMethodBeat.i(215062);
        if (WebViewUI.this.QeZ != null)
        {
          FontChooserView localFontChooserView = (FontChooserView)WebViewUI.this.QeZ.findViewById(c.f.font_chooser_view);
          if (localFontChooserView != null) {
            localFontChooserView.setSliderIndex(paramInt - 1);
          }
        }
        AppMethodBeat.o(215062);
      }
      
      public final void b(String paramString, bot parambot)
      {
        AppMethodBeat.i(215036);
        if (!Util.isNullOrNil(parambot.fwr)) {
          WebViewUI.this.setMMTitle(parambot.fwr);
        }
        if (parambot.SZN == 6) {
          WebViewUI.this.Df(false);
        }
        AppMethodBeat.o(215036);
      }
      
      public final void bXI()
      {
        AppMethodBeat.i(215045);
        WebViewUI.this.Dh(true);
        AppMethodBeat.o(215045);
      }
      
      public final void bXK()
      {
        AppMethodBeat.i(215065);
        super.bXK();
        if ((!WebViewUI.this.QfW) && (!WebViewUI.this.QfX)) {
          WebViewUI.this.QeT.start();
        }
        AppMethodBeat.o(215065);
      }
      
      public final void bXL()
      {
        AppMethodBeat.i(215067);
        super.bXL();
        WebViewUI.this.QeT.finish();
        AppMethodBeat.o(215067);
      }
      
      public final void bXM()
      {
        AppMethodBeat.i(215048);
        if (WebViewUI.this.Qgf)
        {
          Log.e("MicroMsg.WebViewUI", "edw postBinded hasDoPostBind");
          AppMethodBeat.o(215048);
          return;
        }
        WebViewUI.this.Qgf = true;
        WebViewUI.this.cjK();
        AppMethodBeat.o(215048);
      }
      
      public final void bjH(String paramString)
      {
        AppMethodBeat.i(215033);
        WebViewUI.this.Qgk.gYc();
        AppMethodBeat.o(215033);
      }
      
      public final void bjI(String paramString)
      {
        AppMethodBeat.i(215060);
        WebViewUI.this.bmi(paramString);
        AppMethodBeat.o(215060);
      }
      
      public final void bv(int paramInt, String paramString)
      {
        AppMethodBeat.i(215025);
        super.bv(paramInt, paramString);
        if (paramInt != 5) {
          WebViewUI.this.Dh(false);
        }
        AppMethodBeat.o(215025);
      }
      
      public final void c(String paramString, bot parambot)
      {
        WebViewUI.this.Qgk.Qdz = parambot.SZQ;
      }
      
      public final void d(int paramInt1, String paramString1, int paramInt2, String paramString2)
      {
        int i = 1;
        AppMethodBeat.i(215063);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(154L, 12L, 1L, false);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(154L, com.tencent.mm.plugin.webview.i.a.aob(paramInt1), 1L, false);
        WebViewUI.this.Dh(true);
        WebViewUI.this.Qgk.QdC = false;
        switch (paramInt1)
        {
        case 1: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        default: 
          AppMethodBeat.o(215063);
          return;
        }
        m.Qer.aoB(paramInt2);
        if (WebViewUI.this.QfS != null)
        {
          paramString2 = this.controller;
          if (paramString2.anw(paramString2.PGj)) {
            break label247;
          }
        }
        label247:
        for (paramInt1 = i;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            WebViewUI.this.gYY();
          }
          WebViewUI.this.PIx.gWc().PWw = false;
          WebViewUI.this.PIx.gVW().da(paramString1, false);
          if (!WebViewUI.D(WebViewUI.this)) {
            break;
          }
          WebViewUI.this.finish();
          break;
        }
      }
      
      public final void gSW()
      {
        AppMethodBeat.i(215030);
        Log.i("MicroMsg.WebViewUI", "WebView-Trace onAuthSucc: url %s", new Object[] { WebViewUI.this.pHq });
        WebViewUI.a(WebViewUI.this, this.controller.pGD.gWI());
        if (!WebViewUI.this.QgL) {
          WebViewUI.this.Qgk.QdC = true;
        }
        k localk = WebViewUI.this.Qgk;
        localk.QdD.add(Integer.valueOf(6));
        localk.QdD.add(Integer.valueOf(1));
        localk.QdD.add(Integer.valueOf(3));
        localk.QdD.add(Integer.valueOf(2));
        WebViewUI.this.Qgk.QdC = true;
        if (WebViewUI.this.Qgk.gXT()) {
          WebViewUI.this.gXW();
        }
        AppMethodBeat.o(215030);
      }
      
      public final void gSX()
      {
        AppMethodBeat.i(215052);
        WebViewUI.this.goBack();
        AppMethodBeat.o(215052);
      }
      
      public final void gSY()
      {
        AppMethodBeat.i(215057);
        WebViewUI.this.gYH();
        AppMethodBeat.o(215057);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(215055);
        WebViewUI.this.finish();
        AppMethodBeat.o(215055);
      }
    }
  }
  
  final class d
    implements FontChooserView.a
  {
    private d() {}
    
    public final void jj(int paramInt)
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
        WebViewUI.this.PIQ.any(i);
        try
        {
          if (WebViewUI.this.pGC.gWY())
          {
            MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("WebViewFontUtil", 2);
            localMultiProcessMMKV.putBoolean("webview_key_font_has_set", true);
            localMultiProcessMMKV.putBoolean("webview_key_has_transfer_mp", true);
            localMultiProcessMMKV.apply();
            com.tencent.mm.plugin.webview.k.i.Dx(false);
            WebViewUI.this.pGC.lE(16384, i);
            WebViewUI.this.pGC.lE(16388, i);
          }
          AppMethodBeat.o(80184);
          return;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.WebViewUI", "onCheckedChanged, ex = " + localException.getMessage());
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
    final WeakReference<WebViewUI> qHe;
    
    public e(WebViewUI paramWebViewUI)
    {
      AppMethodBeat.i(80216);
      this.qHe = new WeakReference(paramWebViewUI);
      this.id = paramWebViewUI.PIQ.gSo();
      AppMethodBeat.o(80216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI
 * JD-Core Version:    0.7.0.1
 */