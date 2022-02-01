package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.app.Dialog;
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
import android.os.Looper;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.luggage.l.e.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.wu;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.k.e.a;
import com.tencent.mm.k.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.webview.WebViewTransHelper;
import com.tencent.mm.plugin.webview.WebViewTransHelper.b;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.c.j;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.d;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.g;
import com.tencent.mm.plugin.webview.core.i.a;
import com.tencent.mm.plugin.webview.jsapi.j.28;
import com.tencent.mm.plugin.webview.jsapi.j.69;
import com.tencent.mm.plugin.webview.k.t;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.plugin.webview.model.as.a;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.model.ba.e;
import com.tencent.mm.plugin.webview.model.ba.g;
import com.tencent.mm.plugin.webview.model.ba.h;
import com.tencent.mm.plugin.webview.model.ba.k;
import com.tencent.mm.plugin.webview.model.ba.m;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.f;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.h;
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
import com.tencent.mm.pluginsdk.model.ad.a;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.protocal.protobuf.ghn;
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
import com.tencent.mm.ui.KeyboardLinearLayout.b;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.MMWebView.b;
import com.tencent.mm.ui.widget.MMWebView.c;
import com.tencent.mm.ui.widget.MMWebView.f;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.a.j.a;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.af;
import com.tencent.xweb.ao;
import com.tencent.xweb.z.a;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.ah;

@com.tencent.mm.ui.widget.pulldown.c(0)
public class WebViewUI
  extends MMSecDataActivity
  implements View.OnCreateContextMenuListener, e.e, com.tencent.mm.plugin.webview.core.d, com.tencent.mm.plugin.webview.g.a.a, com.tencent.mm.plugin.webview.j.a, com.tencent.mm.plugin.webview.ui.tools.video.samelayer.e, ScreenShotUtil.ScreenShotCallback, MMWebView.f
{
  private static final Pattern WGv;
  private static final Pattern WGw;
  private static final ArrayList<e> WXA;
  private static WebSettings.RenderPriority WXF;
  protected static int WXZ;
  private static Boolean WYz;
  private long Bti;
  public int INO;
  public String INP;
  private View Inv;
  private com.tencent.mm.ui.statusbar.c.a Inw;
  protected com.tencent.mm.ui.widget.snackbar.a.b IvJ;
  protected boolean PhI;
  public com.tencent.mm.ui.base.w Psj;
  protected MultiCodeMaskView RnL;
  public com.tencent.mm.plugin.webview.stub.f WFb;
  public AccessibilityManager.AccessibilityStateChangeListener WGt;
  protected af WRh;
  private View WUx;
  protected boolean WWP;
  private boolean WWQ;
  public MMFalseProgressBar WWR;
  public ProgressBar WWS;
  private n WWT;
  private ImageButton WWU;
  private ImageButton WWV;
  protected View WWW;
  protected WebViewKeyboardLinearLayout WWX;
  protected FrameLayout WWY;
  public FrameLayout WWZ;
  private boolean WXB;
  private WebChromeClient.CustomViewCallback WXC;
  protected com.tencent.xweb.z WXD;
  private ProgressBar WXE;
  protected boolean WXG;
  private final IListener<SendDataToH5FromMiniProgramEvent> WXH;
  private boolean WXI;
  protected boolean WXJ;
  protected HashMap<String, Boolean> WXK;
  protected HashMap<String, String> WXL;
  protected HashMap<String, ArrayList<e.b>> WXM;
  protected HashMap<String, Boolean> WXN;
  protected a WXO;
  protected com.tencent.mm.ui.widget.a.e WXP;
  protected View WXQ;
  protected String WXR;
  private boolean WXS;
  private boolean WXT;
  protected volatile boolean WXU;
  protected boolean WXV;
  private Map WXW;
  private int WXX;
  public int WXY;
  protected MovingImageButton WXa;
  protected boolean WXb;
  private boolean WXc;
  public boolean WXd;
  protected com.tencent.mm.bj.a WXe;
  public com.tencent.mm.plugin.webview.j.b WXf;
  private WebViewRedesignInputFooter WXg;
  private View WXh;
  protected WebViewSearchContentInputFooter WXi;
  private boolean WXj;
  private boolean WXk;
  public String WXl;
  protected boolean WXm;
  protected boolean WXn;
  protected long WXo;
  private boolean WXp;
  private int WXq;
  private int WXr;
  private boolean WXs;
  protected boolean WXt;
  private boolean WXu;
  protected boolean WXv;
  protected int WXw;
  protected byte[] WXx;
  private View WXy;
  private MTimerHandler WXz;
  protected View WYA;
  private com.tencent.mm.bj.a.b WYB;
  private boolean WYC;
  public final p WYD;
  final com.tencent.mm.plugin.webview.modeltools.a WYE;
  public final com.tencent.mm.plugin.webview.ui.tools.media.d WYF;
  private boolean WYG;
  private View.OnLongClickListener WYH;
  protected boolean WYI;
  private View.OnLongClickListener WYJ;
  protected View.OnLongClickListener WYK;
  String WYL;
  protected volatile String WYM;
  private WebChromeClient.CustomViewCallback WYN;
  boolean WYO;
  int WYP;
  protected c WYQ;
  public int WYR;
  private MMWebView.b WYS;
  public boolean WYa;
  private boolean WYb;
  private boolean WYc;
  protected boolean WYd;
  protected volatile boolean WYe;
  public com.tencent.mm.plugin.webview.k.r WYf;
  private com.tencent.mm.plugin.webview.model.b WYg;
  protected WebViewLongClickHelper WYh;
  public o WYi;
  private u WYj;
  protected IUtils WYk;
  protected com.tencent.mm.plugin.webview.q WYl;
  protected volatile String WYm;
  protected volatile long WYn;
  protected HandOffURL WYo;
  public m WYp;
  com.tencent.mm.plugin.webview.ui.tools.floatball.b WYq;
  public com.tencent.mm.plugin.webview.ui.tools.multitask.a WYr;
  private boolean WYs;
  private IListener<wu> WYt;
  private com.tencent.mm.plugin.webview.ui.tools.widget.q WYu;
  private boolean WYv;
  private MPVideoPlayFullScreenView WYw;
  int WYx;
  private boolean WYy;
  public com.tencent.mm.plugin.webview.jsapi.j WlX;
  public ba Wye;
  public WebViewUIStyleHelper Wyi;
  public com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h Wyj;
  public com.tencent.mm.plugin.webview.core.k Wzl;
  protected int Wzx;
  public AccessibilityManager bYO;
  private View dyK;
  private MMHandler handler;
  public String iag;
  private ActionBar mActionBar;
  public com.tencent.mm.ui.base.w psR;
  public com.tencent.mm.plugin.webview.stub.e sLC;
  protected com.tencent.mm.plugin.webview.e.g sLD;
  private final com.tencent.mm.plugin.webview.modeltools.d sLM;
  public MMWebView sMP;
  public String sMq;
  protected String sessionId;
  private int vPB;
  protected int x_down;
  protected int y_down;
  
  static
  {
    AppMethodBeat.i(80400);
    WXA = new ArrayList();
    WXF = WebSettings.RenderPriority.NORMAL;
    WXZ = 0;
    WYz = null;
    WGv = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    WGw = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    AppMethodBeat.o(80400);
  }
  
  public WebViewUI()
  {
    AppMethodBeat.i(80217);
    this.WWP = false;
    this.WWQ = false;
    this.Wzx = -1;
    this.WXb = false;
    this.WXc = false;
    this.WXd = false;
    this.WXf = new com.tencent.mm.plugin.webview.j.b();
    this.WXl = null;
    this.WXm = true;
    this.WXn = false;
    this.WXo = 0L;
    this.WXp = false;
    this.sessionId = "";
    this.WXr = -1;
    this.PhI = true;
    this.WXs = false;
    this.WXt = true;
    this.WXu = false;
    this.WXv = false;
    this.WXx = new byte[0];
    this.WlX = null;
    this.WXB = false;
    this.sLD = null;
    this.WXG = false;
    this.Wyj = new com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h(this);
    this.WXH = new IListener(com.tencent.mm.app.f.hfK) {};
    this.WXI = false;
    this.sLC = null;
    this.Wzl = null;
    this.WXJ = false;
    this.WXK = new HashMap();
    this.WXL = new HashMap();
    this.WXM = new HashMap();
    this.WXN = new HashMap();
    this.WXP = null;
    this.WXQ = null;
    this.WXR = null;
    this.WXS = false;
    this.WXT = false;
    this.INO = 0;
    this.INP = null;
    this.WXU = false;
    this.WXV = false;
    this.WXX = 0;
    this.WXY = ((int)(System.currentTimeMillis() / 1000L));
    this.WYa = false;
    this.WYb = false;
    this.WYc = false;
    this.WYd = false;
    this.WYe = false;
    this.Wye = new ba();
    this.WYf = new com.tencent.mm.plugin.webview.k.r();
    this.WYk = null;
    this.WYs = false;
    this.WRh = new af()
    {
      public final void Bv(int paramAnonymousInt) {}
      
      public final void computeScroll(View paramAnonymousView)
      {
        AppMethodBeat.i(296338);
        if (WebViewUI.this.sMP == null)
        {
          AppMethodBeat.o(296338);
          return;
        }
        if (MMWebView.isX5()) {
          WebViewUI.this.sMP.jEW();
        }
        AppMethodBeat.o(296338);
      }
      
      public final boolean dispatchTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(296347);
        if (WebViewUI.this.sMP == null)
        {
          AppMethodBeat.o(296347);
          return false;
        }
        if (MMWebView.isX5())
        {
          boolean bool = WebViewUI.this.sMP.ay(paramAnonymousMotionEvent);
          AppMethodBeat.o(296347);
          return bool;
        }
        AppMethodBeat.o(296347);
        return false;
      }
      
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(296351);
        if (WebViewUI.this.sMP == null)
        {
          AppMethodBeat.o(296351);
          return false;
        }
        if (MMWebView.isX5())
        {
          boolean bool = WebViewUI.this.sMP.az(paramAnonymousMotionEvent);
          AppMethodBeat.o(296351);
          return bool;
        }
        AppMethodBeat.o(296351);
        return false;
      }
      
      public final void onOverScrolled(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, View paramAnonymousView)
      {
        AppMethodBeat.i(296342);
        if (WebViewUI.this.sMP == null)
        {
          AppMethodBeat.o(296342);
          return;
        }
        if (MMWebView.isX5())
        {
          WebViewUI.this.sMP.i(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
          if ((paramAnonymousBoolean2) && (WebViewUI.this.Wye != null)) {
            WebViewUI.this.Wye.O("mm_scroll_bottom", Boolean.TRUE);
          }
        }
        AppMethodBeat.o(296342);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(80056);
        if (WebViewUI.this.sMP == null)
        {
          AppMethodBeat.o(80056);
          return;
        }
        if (MMWebView.isX5())
        {
          WebViewUI.this.sMP.ag(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
          WebViewUI.this.onWebViewScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        }
        AppMethodBeat.o(80056);
      }
      
      public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(296328);
        if (WebViewUI.this.sMP == null)
        {
          AppMethodBeat.o(296328);
          return false;
        }
        if (MMWebView.isX5())
        {
          boolean bool = WebViewUI.this.sMP.ax(paramAnonymousMotionEvent);
          AppMethodBeat.o(296328);
          return bool;
        }
        AppMethodBeat.o(296328);
        return false;
      }
      
      public final boolean overScrollBy(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean, View paramAnonymousView)
      {
        AppMethodBeat.i(296332);
        if (WebViewUI.this.sMP == null)
        {
          AppMethodBeat.o(296332);
          return false;
        }
        if ((WebViewUI.b(WebViewUI.this) != null) && (WebViewUI.b(WebViewUI.this).S(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt5))) {}
        for (boolean bool = true;; bool = false)
        {
          WebViewUI.this.sMP.setHorizontalScrollPage(bool);
          if (!MMWebView.isX5()) {
            break;
          }
          paramAnonymousView = WebViewUI.this.Wye.ivH();
          if (paramAnonymousInt4 > paramAnonymousView.WMd) {
            paramAnonymousView.WMd = paramAnonymousInt4;
          }
          paramAnonymousView.uiX = paramAnonymousInt6;
          paramAnonymousBoolean = WebViewUI.this.sMP.b(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
          AppMethodBeat.o(296332);
          return paramAnonymousBoolean;
        }
        AppMethodBeat.o(296332);
        return true;
      }
    };
    this.WYt = new IListener(com.tencent.mm.app.f.hfK)
    {
      private boolean izk()
      {
        AppMethodBeat.i(80075);
        if (WebViewUI.this.sLC == null)
        {
          Log.e("MicroMsg.WebViewUI", "Cli Event, invoker is null");
          AppMethodBeat.o(80075);
          return false;
        }
        if ((WebViewUI.this.WYm == null) || (WebViewUI.this.WYm.length() == 0))
        {
          Log.e("MicroMsg.WebViewUI", "Cli Event, tid is null");
          AppMethodBeat.o(80075);
          return false;
        }
        try
        {
          long l = System.currentTimeMillis();
          Log.i("MicroMsg.WebViewUI", "Cli Event, tid = %s, stime = %d, etime = %d", new Object[] { WebViewUI.this.WYm, Long.valueOf(WebViewUI.this.WYn), Long.valueOf(l) });
          Bundle localBundle = new Bundle();
          localBundle.putString("service_click_tid", new String(WebViewUI.this.WYm));
          localBundle.putLong("service_click_stime", WebViewUI.this.WYn);
          localBundle.putLong("service_click_etime", l);
          WebViewUI.this.sLC.C(2836, localBundle);
          WebViewUI.this.WYm = null;
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
    this.WYv = false;
    this.WYx = 0;
    this.WYy = true;
    this.Bti = 0L;
    this.vPB = 0;
    this.WYB = new com.tencent.mm.bj.a.b()
    {
      public final void onFourOrientationsChange(com.tencent.mm.bj.a.a paramAnonymousa1, com.tencent.mm.bj.a.a paramAnonymousa2)
      {
        AppMethodBeat.i(296080);
        Log.i("MicroMsg.WebViewUI", "OrientationListener lastOrientation:" + paramAnonymousa1.name() + "; newOrientation:" + paramAnonymousa2.name());
        WebViewUI.this.Wzx = 4;
        WebViewUI.this.setMMOrientation();
        if (WebViewUI.this.WXe != null) {
          WebViewUI.this.WXe.disable();
        }
        AppMethodBeat.o(296080);
      }
    };
    this.WYC = false;
    this.WYD = new p();
    this.sLM = new com.tencent.mm.plugin.webview.modeltools.d();
    this.WYE = new com.tencent.mm.plugin.webview.modeltools.a();
    this.WYF = new com.tencent.mm.plugin.webview.ui.tools.media.d();
    this.WYH = new View.OnLongClickListener()
    {
      private boolean izl()
      {
        boolean bool2 = true;
        AppMethodBeat.i(296392);
        Object localObject = null;
        try
        {
          WebView.b localb = WebViewUI.this.sMP.getHitTestResult();
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
          AppMethodBeat.o(296392);
          return false;
        }
        try
        {
          bool1 = WebViewUI.this.sLC.iI(localObject.mExtra);
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
          WebViewUI.this.sLC.ib(localObject.mExtra, WebViewUI.this.Wzl.irL());
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
        AppMethodBeat.o(296392);
        return bool1;
      }
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(296395);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$32", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        if (WebViewUI.this.getIntent().getBooleanExtra("show_long_click_popup_menu", true))
        {
          boolean bool = izl();
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$32", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(296395);
          return bool;
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$32", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(296395);
        return true;
      }
    };
    this.WYI = false;
    this.WYK = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80083);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$36", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        if ((WebViewUI.g(WebViewUI.this) != null) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())))
        {
          boolean bool = WebViewUI.g(WebViewUI.this).onLongClick(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$36", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(80083);
          return bool;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$36", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(80083);
        return false;
      }
    };
    this.WYL = "";
    this.WYM = "";
    this.WYO = true;
    this.WYP = 0;
    this.WYQ = new c();
    this.IvJ = new com.tencent.mm.ui.widget.snackbar.a.b()
    {
      public final void onMessageClick()
      {
        AppMethodBeat.i(296217);
        try
        {
          WebViewUI.this.sLC.favEditTag();
          AppMethodBeat.o(296217);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + localException.getMessage());
          AppMethodBeat.o(296217);
        }
      }
    };
    this.WYR = -1;
    this.WYS = null;
    AppMethodBeat.o(80217);
  }
  
  private void IB(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.WXB = true;
    }
  }
  
  private void IO(boolean paramBoolean)
  {
    AppMethodBeat.i(296388);
    this.Wzl.irG();
    ba.xM(5L);
    if ((this.WWT != null) && (this.WWT.ixB())) {
      if (!paramBoolean) {
        break label64;
      }
    }
    label64:
    for (int i = 6;; i = 3)
    {
      ba.e.dh(fqa(), i);
      ba.xM(6L);
      AppMethodBeat.o(296388);
      return;
    }
  }
  
  private void a(JsapiPermissionWrapper paramJsapiPermissionWrapper)
  {
    AppMethodBeat.i(296389);
    if (paramJsapiPermissionWrapper != null)
    {
      if (paramJsapiPermissionWrapper.sk(34))
      {
        setMMSubTitle(c.i.wechat_authenticate_safely);
        AppMethodBeat.o(296389);
        return;
      }
      if (paramJsapiPermissionWrapper.sk(75))
      {
        setMMSubTitle(c.i.wechat_wx_safe_login);
        AppMethodBeat.o(296389);
        return;
      }
      setMMSubTitle(null);
    }
    AppMethodBeat.o(296389);
  }
  
  private static void bd(View paramView, int paramInt)
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
  
  private void bjV(String paramString)
  {
    AppMethodBeat.i(80241);
    if (this.WlX != null)
    {
      this.WlX.iF(paramString, null);
      try
      {
        if (paramString.equals("onPause"))
        {
          if (this.sLC != null) {
            this.sLC.auh(this.Wzl.irL());
          }
          this.WlX.setActive(false);
          AppMethodBeat.o(80241);
          return;
        }
        if (paramString.equals("onResume"))
        {
          if (this.sLC != null) {
            this.sLC.aug(this.Wzl.irL());
          }
          this.WlX.setActive(true);
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
  
  private void blM(String paramString)
  {
    AppMethodBeat.i(80239);
    if ((this.WYq != null) && (!Util.isNullOrNil(paramString)) && (!com.tencent.mm.plugin.webview.ui.tools.floatball.b.isMpUrl(dgY()))) {
      this.WYq.ahU(paramString);
    }
    if ((this.WYr != null) && (!Util.isNullOrNil(paramString)) && (!com.tencent.mm.plugin.webview.ui.tools.multitask.a.isMpUrl(dgY()))) {
      this.WYr.updateTitle(paramString);
    }
    AppMethodBeat.o(80239);
  }
  
  private void blN(String paramString)
  {
    AppMethodBeat.i(80240);
    if ((this.WYo != null) && (!Util.isNullOrNil(paramString)) && ((this.WYq != null) || (this.WYr != null)) && (!((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).isMpUrl(dgY())) && (!this.WYo.getTitle().equals(paramString)))
    {
      this.WYo.setTitle(paramString);
      if (iul()) {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).e(this.WYo);
      }
    }
    AppMethodBeat.o(80240);
  }
  
  private void blO(String paramString)
  {
    AppMethodBeat.i(296341);
    if ((Util.isNullOrNil(paramString)) || (paramString.startsWith("data:text/html;charset=utf-8")))
    {
      AppMethodBeat.o(296341);
      return;
    }
    if (this.Wzl != null) {}
    for (String str = this.Wzl.bLY();; str = "")
    {
      str = Util.nullAsNil(str);
      if (this.WYq != null) {
        this.WYq.fz("handoff#shareUrl", str);
      }
      if (this.WYr != null) {
        this.WYr.WHP.acdA = str;
      }
      if (!str.isEmpty()) {
        paramString = str;
      }
      if ((this.WYo != null) && (!Util.isNullOrNil(paramString)) && (!this.WYo.getUrl().equals(paramString)))
      {
        this.WYo.setUrl(paramString);
        if (iul()) {
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).e(this.WYo);
        }
      }
      AppMethodBeat.o(296341);
      return;
    }
  }
  
  private static String blP(String paramString)
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
    if (paramDialog != null)
    {
      if (paramDialog.isShowing()) {
        paramDialog.dismiss();
      }
      paramDialog.setCancelMessage(null);
      paramDialog.setDismissMessage(null);
    }
    AppMethodBeat.o(80270);
  }
  
  private boolean ixy()
  {
    AppMethodBeat.i(296361);
    if ((this.WYp != null) && (this.WYp.ixy()))
    {
      AppMethodBeat.o(296361);
      return true;
    }
    AppMethodBeat.o(296361);
    return false;
  }
  
  private View iyC()
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
  
  private Boolean iyE()
  {
    AppMethodBeat.i(296379);
    if (this.WXd)
    {
      Log.i("MicroMsg.WebViewUI", "hold on swipe back");
      this.WXd = false;
      if (this.WlX != null)
      {
        this.WlX.itE();
        localBoolean = Boolean.TRUE;
        AppMethodBeat.o(296379);
        return localBoolean;
      }
    }
    Boolean localBoolean = Boolean.FALSE;
    AppMethodBeat.o(296379);
    return localBoolean;
  }
  
  private boolean iyO()
  {
    AppMethodBeat.i(296383);
    boolean bool1 = getIntent().getBooleanExtra("forceHideShare", false);
    boolean bool2 = getIntent().getBooleanExtra("showShare", true);
    Log.i("MicroMsg.WebViewUI", "forceHideShare:%b: showShareBtn:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((!bool1) && (bool2))
    {
      AppMethodBeat.o(296383);
      return true;
    }
    AppMethodBeat.o(296383);
    return false;
  }
  
  private void iyU()
  {
    AppMethodBeat.i(80316);
    if (this.WXy != null) {
      this.WXy.setVisibility(8);
    }
    if (this.WXz != null) {
      this.WXz.stopTimer();
    }
    AppMethodBeat.o(80316);
  }
  
  private com.tencent.mm.plugin.webview.model.b iyh()
  {
    AppMethodBeat.i(296310);
    if (this.WYg == null) {
      this.WYg = new com.tencent.mm.plugin.webview.model.b(this.Wye);
    }
    com.tencent.mm.plugin.webview.model.b localb = this.WYg;
    AppMethodBeat.o(296310);
    return localb;
  }
  
  public static boolean iyl()
  {
    AppMethodBeat.i(296315);
    if (com.tencent.mm.kernel.h.baz()) {
      com.tencent.mm.kernel.h.baC();
    }
    for (String str = com.tencent.mm.kernel.b.aZs(); Util.isNullOrNil(str); str = "MMWebViewTransShouldPullHalfScreenNotice")
    {
      Log.e("MicroMsg.WebViewUI", "kvName is null");
      AppMethodBeat.o(296315);
      return true;
    }
    boolean bool = MultiProcessMMKV.getSingleMMKV(str).decodeBool("MMWebViewTransHasPullBefore", false);
    Log.i("MicroMsg.WebViewUI", "show trans notice before: %s", new Object[] { Boolean.toString(bool) });
    AppMethodBeat.o(296315);
    return bool;
  }
  
  private com.tencent.mm.plugin.webview.ui.tools.widget.q iyn()
  {
    AppMethodBeat.i(80223);
    if (this.WYu == null)
    {
      this.WYu = new com.tencent.mm.plugin.webview.ui.tools.widget.q(this, new com.tencent.mm.ui.z(getContext(), c.j.CommentPanel));
      this.WYu.setVisibility(8);
      localObject = (ViewParent)getWindow().getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        ((ViewGroup)localObject).addView(this.WYu, new FrameLayout.LayoutParams(-1, -1));
        this.WYu.iCs();
        int i = getIntent().getIntExtra(f.s.adwW, -1);
        int j = getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
        int k = getIntent().getIntExtra(f.s.adwT, -1);
        localObject = this.WYu;
        String str1 = dgY();
        String str2 = getTitle().toString();
        ((com.tencent.mm.plugin.webview.ui.tools.widget.q)localObject).scene = j;
        ((com.tencent.mm.plugin.webview.ui.tools.widget.q)localObject).AcJ = k;
        ((com.tencent.mm.plugin.webview.ui.tools.widget.q)localObject).nQm = i;
        ((com.tencent.mm.plugin.webview.ui.tools.widget.q)localObject).XlS = 0;
        ((com.tencent.mm.plugin.webview.ui.tools.widget.q)localObject).url = str1;
        ((com.tencent.mm.plugin.webview.ui.tools.widget.q)localObject).title = str2;
      }
    }
    Object localObject = this.WYu;
    AppMethodBeat.o(80223);
    return localObject;
  }
  
  private static boolean iyr()
  {
    AppMethodBeat.i(80248);
    if (WYz == null) {}
    try
    {
      if (Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_webview_force_dark_disable", "0", false, true), 1) > 0) {
        Log.i("MicroMsg.WebViewUI", "disableForceDark on!!");
      }
      for (WYz = Boolean.TRUE;; WYz = Boolean.FALSE)
      {
        boolean bool = WYz.booleanValue();
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
        WYz = Boolean.FALSE;
      }
    }
  }
  
  private boolean iyt()
  {
    return (this.WXb) || (this.WXc);
  }
  
  private int iyu()
  {
    AppMethodBeat.i(80252);
    if (ixy())
    {
      AppMethodBeat.o(80252);
      return 0;
    }
    int i = com.tencent.mm.ui.statusbar.a.cg(this);
    if ((this.mActionBar == null) || (!this.mActionBar.isShowing()))
    {
      AppMethodBeat.o(80252);
      return i;
    }
    int j = getActionBarHeight();
    AppMethodBeat.o(80252);
    return i + j;
  }
  
  private boolean iyv()
  {
    return (this.WYp != null) && (this.WYp.WUp.WUk);
  }
  
  private boolean iyy()
  {
    AppMethodBeat.i(80255);
    if ((!Util.isNullOrNil(this.INP)) && (this.INP.equals("black")))
    {
      AppMethodBeat.o(80255);
      return true;
    }
    AppMethodBeat.o(80255);
    return false;
  }
  
  private boolean izb()
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
          com.tencent.mm.ui.base.k.a(this, str1, str2, str3, str4, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(296203);
              WebViewUI.this.WYa = true;
              r.WWq.close();
              ba.e.dh(WebViewUI.this.fqa(), 1);
              WebViewUI.this.finish();
              AppMethodBeat.o(296203);
            }
          }, null);
        }
        for (;;)
        {
          AppMethodBeat.o(80355);
          return true;
          com.tencent.mm.ui.base.k.a(this, str1, str2, str3, str4, false, null, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(296206);
              WebViewUI.this.WYa = true;
              r.WWq.close();
              ba.e.dh(WebViewUI.this.fqa(), 1);
              WebViewUI.this.finish();
              AppMethodBeat.o(296206);
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
    ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    startActivityForResult((Intent)localObject, i);
    com.tencent.mm.ui.base.b.ng(this);
    AppMethodBeat.o(80355);
    return true;
  }
  
  private void izd()
  {
    AppMethodBeat.i(80357);
    if (this.WYc)
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
      com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, localBundle, com.tencent.mm.pluginsdk.model.app.z.class, null);
    }
    AppMethodBeat.o(80357);
  }
  
  public static boolean izg()
  {
    return false;
  }
  
  private static void kB(View paramView)
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
    AppMethodBeat.i(296368);
    if (this.sLC != null) {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("screen_orientation", this.Wzx);
        this.sLC.m(83, localBundle);
        AppMethodBeat.o(296368);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.WebViewUI", "ac_set_screen_orientation : " + localException.getMessage());
      }
    }
    AppMethodBeat.o(296368);
  }
  
  protected void Ae(boolean paramBoolean) {}
  
  protected void E(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80358);
    Log.i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
    AppMethodBeat.o(80358);
  }
  
  public final void IL(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(80319);
    if (this.WWT != null) {
      this.WWT.IL(paramBoolean);
    }
    ImageButton localImageButton;
    if ((this.sMP != null) && (this.WUx != null))
    {
      localImageButton = this.WWU;
      if ((this.sMP == null) || (!this.sMP.canGoBack())) {
        break label102;
      }
      paramBoolean = true;
      localImageButton.setEnabled(paramBoolean);
      localImageButton = this.WWV;
      if ((this.sMP == null) || (!this.sMP.canGoForward())) {
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
  
  protected void IN(boolean paramBoolean)
  {
    AppMethodBeat.i(80310);
    this.WYC = paramBoolean;
    if (this.sMP == null)
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
    int i = iyT();
    if (iyS() != null) {
      i = c.h.mm_title_btn_jd;
    }
    paramBoolean = getIntent().getBooleanExtra("KRightBtn", false);
    boolean bool = getIntent().getBooleanExtra("KShowFixToolsBtn", false);
    Log.i("MicroMsg.WebViewUI", "banRightBtn:%b, showFixToolsBtn:%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    int j;
    if ((!bool) && (aw.jlc()) && ((aw.jkS()) || (aj.aAy(getTaskId()))))
    {
      if (!aw.aAj(getTaskId())) {
        break label262;
      }
      j = c.h.icons_outlined_merge;
      if (!aw.aAj(getTaskId())) {
        break label269;
      }
    }
    label262:
    label269:
    for (int k = c.i.close_split_screen;; k = c.i.split_screen)
    {
      addIconOptionMenu(2, k, j, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(80084);
          com.tencent.mm.ui.ag.a(WebViewUI.this.getTaskId(), null);
          AppMethodBeat.o(80084);
          return true;
        }
      });
      if (!paramBoolean)
      {
        if (bool) {
          addIconOptionMenu(1, c.i.app_fix_util, c.h.fix_tools_entry, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(80085);
              Object localObject = new Intent();
              ((Intent)localObject).setClassName(WebViewUI.this, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
              ((Intent)localObject).putExtra("entry_fix_tools", 1);
              paramAnonymousMenuItem = WebViewUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$38", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(80085);
              return true;
            }
          });
        }
        addIconOptionMenu(0, c.i.app_more, i, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(296413);
            if (WebViewUI.this.sLD.blh(WebViewUI.this.fqa())) {
              WebViewUI.this.Wye.ivK().H(new Object[] { WebViewUI.this.dgY(), Integer.valueOf(6) }).report();
            }
            for (;;)
            {
              WebViewUI.this.ixS();
              AppMethodBeat.o(296413);
              return true;
              WebViewUI.this.Wye.ivK().H(new Object[] { WebViewUI.this.dgY(), Integer.valueOf(5) }).report();
            }
          }
        }, this.WYK);
      }
      AppMethodBeat.o(80310);
      return;
      j = c.h.icons_outlined_sperated;
      break;
    }
  }
  
  protected final void IP(boolean paramBoolean)
  {
    AppMethodBeat.i(297042);
    enableOptionMenu(true);
    Log.d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", new Object[] { Boolean.TRUE });
    setProgressBarIndeterminateVisibility(false);
    if (paramBoolean)
    {
      this.WYi.ixQ();
      AppMethodBeat.o(297042);
      return;
    }
    if ((!this.WXU) && (!this.WXV)) {
      this.Wzl.dhh();
    }
    AppMethodBeat.o(297042);
  }
  
  public final void IQ(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(297054);
    Log.d("MicroMsg.WebViewUI", "setAccessibilityFocusable %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!com.tencent.mm.ui.a.a.a.jlv().jls())
    {
      AppMethodBeat.o(297054);
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
      this.WYO = isOptionMenuShow(0);
      if (localObject1 == null) {
        break label212;
      }
      i = ((View)localObject1).getVisibility();
      this.WYP = i;
      showOptionMenu(0, false);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(4);
      }
      if (this.WYD != null)
      {
        localObject1 = this.WYD;
        Object localObject2;
        if (((p)localObject1).WWg != null)
        {
          localObject2 = com.tencent.mm.plugin.bizui.a.a.vtB;
          localObject2 = ((p)localObject1).WWg;
          if (paramBoolean) {
            break label243;
          }
          bool1 = true;
          label140:
          com.tencent.mm.plugin.bizui.a.a.o((View)localObject2, bool1);
        }
        if ((((p)localObject1).WWh != null) && (!Util.isNullOrNil(((p)localObject1).WWh.getText())))
        {
          localObject2 = com.tencent.mm.plugin.bizui.a.a.vtB;
          localObject1 = ((p)localObject1).WWg;
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
      com.tencent.mm.plugin.bizui.a.a.o((View)localObject1, paramBoolean);
      AppMethodBeat.o(297054);
      return;
      localObject1 = this.mActionBar.getCustomView();
      break;
      i = 0;
      break label79;
      showOptionMenu(0, this.WYO);
      if (localObject1 == null) {
        break label101;
      }
      ((View)localObject1).setVisibility(this.WYP);
      break label101;
      bool1 = false;
      break label140;
    }
  }
  
  public final void IR(boolean paramBoolean)
  {
    AppMethodBeat.i(80359);
    if (this.sMP == null)
    {
      AppMethodBeat.o(80359);
      return;
    }
    String str = this.sMP.getUrl();
    if (paramBoolean)
    {
      showOptionMenu(0, false);
      this.WXN.put(str, Boolean.TRUE);
      AppMethodBeat.o(80359);
      return;
    }
    showOptionMenu(0, true);
    if (this.WXN.containsKey(str)) {
      this.WXN.remove(str);
    }
    AppMethodBeat.o(80359);
  }
  
  public final void a(long paramLong, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(297011);
    int i = iyR();
    boolean bool = false;
    WebViewUIStyleHelper.a locala = iyA();
    if (locala != null) {
      bool = locala.WOJ;
    }
    Log.i("MicroMsg.WebViewUI", "isCurrentMPPageDisableMenuHeader  disableMenuHeader:".concat(String.valueOf(bool)));
    this.WYi.a(paramLong, paramArrayList, paramBoolean, bool, i);
    AppMethodBeat.o(297011);
  }
  
  public final void a(com.tencent.mm.plugin.webview.ui.tools.video.c paramc)
  {
    AppMethodBeat.i(296675);
    this.Wyj.a(paramc);
    AppMethodBeat.o(296675);
  }
  
  protected final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(296902);
    if (this.WXg == null)
    {
      AppMethodBeat.o(296902);
      return;
    }
    this.WXg.cs(paramMap);
    if (paramString1 != null) {
      this.WXg.setText(paramString1);
    }
    if (paramString2 != null) {
      this.WXg.setPlaceholder(paramString2);
    }
    if (paramInt1 > 0)
    {
      this.WXg.setMaxCount(paramInt1);
      this.WXg.setShowRemindWordCount(paramInt2);
    }
    AppMethodBeat.o(296902);
  }
  
  protected final void aNr()
  {
    AppMethodBeat.i(80342);
    this.WYi.aNr();
    AppMethodBeat.o(80342);
  }
  
  protected void aQ(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(296900);
    a(null, paramString, paramInt1, paramInt2, new HashMap());
    AppMethodBeat.o(296900);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(80313);
    if (!com.tencent.mm.compatible.util.d.rb(21))
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
    if (iyy()) {
      localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
    for (;;)
    {
      addIconOptionMenu(paramInt1, getString(c.i.app_more), localDrawable, paramOnMenuItemClickListener);
      AppMethodBeat.o(80313);
      return;
      if ((this.Wyi != null) && (!this.Wyi.WZj)) {
        localDrawable.setColorFilter(getResources().getColor(c.c.FG_0), PorterDuff.Mode.SRC_ATOP);
      } else {
        localDrawable.clearColorFilter();
      }
    }
  }
  
  protected void atq(int paramInt)
  {
    AppMethodBeat.i(80351);
    this.Wzl.atq(paramInt);
    AppMethodBeat.o(80351);
  }
  
  public final void auv(int paramInt)
  {
    AppMethodBeat.i(296909);
    this.WYD.aut(paramInt);
    AppMethodBeat.o(296909);
  }
  
  protected final void auw(int paramInt)
  {
    AppMethodBeat.i(80288);
    Drawable localDrawable = getResources().getDrawable(iyL()).mutate();
    localDrawable.setColorFilter(paramInt, PorterDuff.Mode.SRC_IN);
    updateBackBtn(localDrawable);
    AppMethodBeat.o(80288);
  }
  
  protected final void aux(int paramInt)
  {
    AppMethodBeat.i(80315);
    if (paramInt != -3)
    {
      AppMethodBeat.o(80315);
      return;
    }
    if (this.WXy == null)
    {
      AppMethodBeat.o(80315);
      return;
    }
    if ((this.sLD.iwp().YxC & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = ".concat(String.valueOf(bool)));
      if (!bool) {
        break label233;
      }
      if ((this.WXy.getVisibility() != 0) && (!this.WXi.isShown())) {
        break;
      }
      AppMethodBeat.o(80315);
      return;
    }
    if (this.WXz == null) {
      this.WXz = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(296172);
          WebViewUI.k(WebViewUI.this);
          AppMethodBeat.o(296172);
          return false;
        }
      }, false);
    }
    this.WXz.startTimer(4000L);
    View localView = this.WXy;
    ((ImageView)localView.findViewById(c.f.listen_model_notify_imageview)).setImageResource(c.h.net_warn_icon);
    TextView localTextView = (TextView)localView.findViewById(c.f.listen_model_notify_text);
    localTextView.setTextSize(14.0F);
    localTextView.setText(c.i.wv_alert_input_tips);
    ((ImageButton)localView.findViewById(c.f.listen_model_notify_btn)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80092);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WebViewUI.k(WebViewUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(80092);
      }
    });
    this.WXy.setVisibility(0);
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(13125, dgY());
    label233:
    AppMethodBeat.o(80315);
  }
  
  public final void auy(int paramInt)
  {
    AppMethodBeat.i(297035);
    this.WlX.dG("sendAppMessage", true);
    this.WlX.c(this.WYi.ixV(), paramInt);
    this.Wye.bkF("mm_send_friend_count");
    AppMethodBeat.o(297035);
  }
  
  protected final int avS(String paramString)
  {
    AppMethodBeat.i(80336);
    int i = this.Wzl.avS(paramString);
    AppMethodBeat.o(80336);
    return i;
  }
  
  public final void b(com.tencent.mm.plugin.webview.ui.tools.video.c paramc)
  {
    AppMethodBeat.i(296680);
    this.Wyj.b(paramc);
    AppMethodBeat.o(296680);
  }
  
  protected void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(80367);
    paramWebView = this.Wye;
    Intent localIntent = getIntent();
    String str2 = dgY();
    int i = localIntent.getIntExtra("geta8key_scene", 0);
    int j = localIntent.getIntExtra("bizEnterId", paramWebView.WNa);
    int k = localIntent.getIntExtra("webview_scene_type", 1);
    String str3 = localIntent.getStringExtra("webview_scene_note");
    String str1 = localIntent.getStringExtra("srcUsername");
    paramWebView = str1;
    if (Util.isNullOrNil(str1)) {
      paramWebView = localIntent.getStringExtra("geta8key_username");
    }
    str1 = localIntent.getStringExtra("KAppId");
    com.tencent.mm.plugin.report.service.h.OAn.b(18452, new Object[] { Integer.valueOf(j), Integer.valueOf(i), com.tencent.mm.pluginsdk.ui.tools.aa.aUC(str2), com.tencent.mm.pluginsdk.ui.tools.aa.aUC(paramString), Integer.valueOf(k), str3, str1, paramWebView });
    iyX();
    AppMethodBeat.o(80367);
  }
  
  protected final void b(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(80309);
    addIconOptionMenu(0, paramString, paramDrawable, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(80082);
        if (!this.WYV) {
          WebViewUI.this.ixS();
        }
        for (;;)
        {
          AppMethodBeat.o(80082);
          return true;
          WebViewUI.this.blQ(this.lzH);
        }
      }
    });
    AppMethodBeat.o(80309);
  }
  
  protected void bA(Bundle paramBundle) {}
  
  protected final void bB(Bundle paramBundle)
  {
    AppMethodBeat.i(296606);
    if (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).isMpUrl(dgY())) {
      paramBundle.putInt("_DATA_CENTER_ITEM_SHOW_TYPE", this.WXr);
    }
    AppMethodBeat.o(296606);
  }
  
  protected final void bD(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(80280);
    this.WXb = paramBoolean1;
    Object localObject;
    if (paramBoolean1)
    {
      if (this.mActionBar != null) {
        this.mActionBar.hide();
      }
      if (this.WYA != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.WYA.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
        this.WYA.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      com.tencent.mm.ui.statusbar.a.ad(this.WYA, true);
      getWindow().addFlags(1024);
      localObject = getWindow().getDecorView();
      ((View)localObject).setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
      {
        public final void onSystemUiVisibilityChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(296311);
          if (((paramAnonymousInt & 0x4) == 0) && (WebViewUI.this.WXb)) {
            WebViewUI.kC(this.tMm);
          }
          AppMethodBeat.o(296311);
        }
      });
      bd((View)localObject, 5894);
      if (paramBoolean2)
      {
        this.WXa.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80050);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            WebViewUI.this.ixS();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80050);
          }
        });
        this.WXa.setVisibility(0);
        AppMethodBeat.o(80280);
        return;
      }
      this.WXa.setVisibility(8);
      AppMethodBeat.o(80280);
      return;
    }
    this.WXa.setVisibility(8);
    getWindow().clearFlags(1024);
    kB(getWindow().getDecorView());
    if (this.mActionBar != null)
    {
      this.mActionBar.show();
      if (this.WYA != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.WYA.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = iyu();
        this.WYA.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    com.tencent.mm.ui.statusbar.a.ad(this.WYA, false);
    AppMethodBeat.o(80280);
  }
  
  public final void bc(View paramView, int paramInt)
  {
    AppMethodBeat.i(296669);
    com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h localh = this.Wyj;
    Object localObject = paramView;
    if (paramView == null) {
      localObject = this.sMP;
    }
    localh.bc((View)localObject, paramInt);
    AppMethodBeat.o(296669);
  }
  
  public final String bjg(String paramString)
  {
    AppMethodBeat.i(297045);
    paramString = this.Wzl.bjg(paramString);
    AppMethodBeat.o(297045);
    return paramString;
  }
  
  public final void bjj(String paramString)
  {
    AppMethodBeat.i(297049);
    Log.i("MicroMsg.WebViewUI", "getTransText");
    this.Wyi.WZm.getContentFromWebpage(paramString);
    AppMethodBeat.o(297049);
  }
  
  public void bl(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(80220);
    int i;
    int j;
    if (paramBundle.getBoolean("set_navigation_bar_color_reset", false)) {
      if (this.Wyi == null)
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
      i = this.Wyi.izv();
      break;
      j = paramBundle.getInt("set_navigation_bar_color_color");
      i = paramBundle.getInt("set_navigation_bar_color_alpha");
      bool = paramBundle.getBoolean("set_navigation_bar_color_titleAlphaAdjustment");
    }
  }
  
  public final void blJ(String paramString)
  {
    AppMethodBeat.i(80306);
    this.WYi.blJ(paramString);
    AppMethodBeat.o(80306);
  }
  
  public final void blQ(String paramString)
  {
    AppMethodBeat.i(80317);
    this.WlX.dG("profile", true);
    this.WlX.bjK(paramString);
    AppMethodBeat.o(80317);
  }
  
  public final void bs(Bundle paramBundle)
  {
    AppMethodBeat.i(80231);
    this.WYx = paramBundle.getInt("state", 0);
    AppMethodBeat.o(80231);
  }
  
  public final void bt(Bundle paramBundle)
  {
    AppMethodBeat.i(80227);
    if (paramBundle != null)
    {
      this.WYv = "black".equals(paramBundle.getString("style"));
      iyn().setCommentTopicId(paramBundle.getLong("commentTopicId"));
    }
    iyn().bmS(fqa());
    iyn().Jc(false);
    AppMethodBeat.o(80227);
  }
  
  public final void bu(Bundle paramBundle)
  {
    AppMethodBeat.i(80229);
    if (paramBundle != null)
    {
      this.WYv = "black".equals(paramBundle.getString("style"));
      iyn().Jc(true);
    }
    AppMethodBeat.o(80229);
  }
  
  public final void bv(Bundle paramBundle)
  {
    AppMethodBeat.i(80230);
    this.psR = com.tencent.mm.plugin.webview.k.e.a(paramBundle, getContext(), this.psR);
    AppMethodBeat.o(80230);
  }
  
  public final void bw(Bundle paramBundle)
  {
    AppMethodBeat.i(175797);
    if (paramBundle != null) {
      iyn().setCommentTopicId(paramBundle.getLong("commentTopicId"));
    }
    iyn().bmS(fqa());
    com.tencent.mm.plugin.webview.ui.tools.widget.q localq = iyn();
    String str = paramBundle.getString("reply_content");
    int i = paramBundle.getInt("personal_comment_id");
    kotlin.g.b.s.u(str, "replyContent");
    localq.BI(2);
    localq.Je(false);
    if ((!Util.isNullOrNil(str)) && (i != 0) && (localq.iCx()))
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.q.a(localq, str, i);
      localq.Jd(false);
      AppMethodBeat.o(175797);
      return;
    }
    localq.Jc(false);
    AppMethodBeat.o(175797);
  }
  
  public final void c(com.tencent.luggage.xweb_ext.extendplugin.a.a parama)
  {
    AppMethodBeat.i(296685);
    this.Wyj.c(parama);
    AppMethodBeat.o(296685);
  }
  
  protected final boolean cHN()
  {
    return this.WXb;
  }
  
  public void cKX()
  {
    int k = 2;
    int m = 1;
    AppMethodBeat.i(80295);
    if ((this.WYb) || (this.WYa) || (isFinishing()))
    {
      Log.e("MicroMsg.WebViewUI", "edw postBinded finished");
      AppMethodBeat.o(80295);
      return;
    }
    Object localObject1 = iyP();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.webview.jsapi.k)localObject1).WEs = this.Wzl.getJsapi();
    }
    this.sLC = this.Wzl.irJ();
    try
    {
      this.sLC.a(this.WFb, this.Wzl.irL());
      Log.i("MicroMsg.WebViewUI", "edw postBinded");
      this.WYq = new com.tencent.mm.plugin.webview.ui.tools.floatball.b(new com.tencent.mm.plugin.ball.a.e(this), this);
      localObject1 = getIntent().getStringExtra("float_ball_key");
      if (!Util.isNullOrNil((String)localObject1))
      {
        this.WYq.J(2, (String)localObject1);
        this.WYq.ahU(dgY());
        this.WYq.fz("rawUrl", dgY());
        this.WYq.bjY(dgY());
        localObject1 = new com.tencent.mm.plugin.multitask.a.b(this);
        this.WYr = new com.tencent.mm.plugin.webview.ui.tools.multitask.a((com.tencent.mm.plugin.multitask.a.a)localObject1, this);
        localObject3 = getIntent().getStringExtra("float_ball_key");
        if (Util.isNullOrNil((String)localObject3)) {
          break label1245;
        }
        this.WYr.J(2, (String)localObject3);
        this.WYr.setRawUrl(dgY());
        if (com.tencent.mm.plugin.webview.ui.tools.multitask.a.iBJ())
        {
          localObject1 = ((com.tencent.mm.plugin.multitask.a.b)localObject1).LBt;
          if (localObject1 != null) {
            break label1277;
          }
          localObject1 = null;
          this.WYS = ((MMWebView.b)localObject1);
        }
        if (this.WYq != null) {
          this.WYq.coi();
        }
        if (this.WYr != null) {
          this.WYr.coi();
        }
        if (this.WYo == null) {
          break label1287;
        }
        i = 1;
        if (this.WYo == null) {
          this.WYo = new HandOffURL(dgY(), dgY(), "");
        }
        if ((!aw.isMultiTaskMode()) || (this.WYr == null)) {
          break label1292;
        }
        localObject1 = this.WYr.LCE;
        if (localObject1 != null)
        {
          localObject3 = ((MultiTaskInfo)localObject1).gkh().title;
          if (!Util.isNullOrNil((String)localObject3)) {
            this.WYo.setTitle((String)localObject3);
          }
          this.WYo.setIcon(Util.nullAsNil(((MultiTaskInfo)localObject1).gkh().aaXP));
        }
        if (iul())
        {
          if (i == 0) {
            break label1355;
          }
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).e(this.WYo);
          Log.i("MicroMsg.WebViewUI", "[Handoff] onPostBinded, exist:true, call upsert " + this.WYo.toString());
        }
        blO(dgY());
        localObject1 = iyh();
        localObject3 = this.sLC;
      }
    }
    catch (RemoteException localException4)
    {
      try
      {
        str = ((com.tencent.mm.plugin.webview.stub.e)localObject3).blr("DNSAdvanceOpen");
        Log.i("MicroMsg.DNSPreGetOptimize", "switch open value : %s", new Object[] { str });
        if (Util.isNullOrNil(str))
        {
          Log.e("MicroMsg.DNSPreGetOptimize", "get switch value is null or nil");
          bool = false;
          if (bool) {
            break label1432;
          }
          Log.i("MicroMsg.DNSPreGetOptimize", "server closed the switch");
          if (iyQ()) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(296397);
                if (WebViewUI.this.sMP != null) {
                  WebViewUI.this.sMP.getCurWebviewClient().b(WebViewUI.this.sMP, WebViewUI.this.sMP.getUrl());
                }
                AppMethodBeat.o(296397);
              }
            });
          }
          localObject1 = this.Wzl.getTitle();
          blM((String)localObject1);
          blN((String)localObject1);
        }
      }
      catch (Exception localException4)
      {
        try
        {
          localObject1 = iyA();
          if ((localObject1 != null) && (this.WYo != null))
          {
            this.WYo.setTitle(Util.nullAsNil(((WebViewUIStyleHelper.a)localObject1).title));
            this.WYo.setIcon(Util.nullAsNil(((WebViewUIStyleHelper.a)localObject1).WZF));
            this.WYo.setNickname(Util.nullAsNil(((WebViewUIStyleHelper.a)localObject1).WZE));
            if (iul()) {
              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).e(this.WYo);
            }
          }
        }
        catch (Exception localException4)
        {
          try
          {
            i = Util.getInt(this.sLC.blr("WebviewDisableX5Logo"), 0);
            bool = getIntent().getBooleanExtra("disable_bounce_scroll", false);
            Log.i("MicroMsg.WebViewUI", "getting flag of x5 logo state, disableX5Logo = %d, disableBounceScroll = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
            if ((i == 1) || (bool)) {
              this.WYD.IJ(true);
            }
            if (getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_disable_over_scroll", false)) {
              this.WYD.IJ(true);
            }
            this.WYf.cf("onJSAPIEnd", System.currentTimeMillis());
            if ((this.sMP != null) && (this.sMP.getIsX5Kernel()))
            {
              bool = true;
              ba.bC(bool, Util.nullAsNil(dgY()).startsWith("https://"));
            }
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                j = Util.getInt(this.sLC.blr("XwebBatchTranslateMaxByteLength"), 0);
                i = Util.getInt(this.sLC.blr("XwebBatchTranslateMaxCnt"), 0);
                Log.i("MicroMsg.WebViewUI", "getting flag of XwebBatchTranslate para BatchTranslateMaxByteLength  = " + j + " BatchTranslateCnt = " + i);
                localObject1 = this.WYl;
                ((com.tencent.mm.plugin.webview.q)localObject1).WvU = j;
                ((com.tencent.mm.plugin.webview.q)localObject1).WvV = i;
                if (getIntent().getBooleanExtra("translate_webview", false))
                {
                  localObject1 = this.WYl;
                  localObject3 = this.sMP;
                  str = dgY();
                  if ((localObject3 != null) && (!((WebView)localObject3).isSysKernel())) {
                    break;
                  }
                }
                IN(iyO());
                this.WWW = LayoutInflater.from(this).inflate(c.g.web_view_font_chooser, null);
                localObject1 = (FontChooserView)this.WWW.findViewById(c.f.font_chooser_view);
                localObject3 = this.WWW.findViewById(c.f.font_chooser_close);
                if ((this.sMP == null) || (!this.sMP.getIsX5Kernel())) {
                  break label1744;
                }
                i = m;
                if (i == 0)
                {
                  ((View)localObject3).setVisibility(0);
                  ((View)localObject3).setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(296202);
                      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                      localb.cH(paramAnonymousView);
                      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$47", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                      paramAnonymousView = AnimationUtils.loadAnimation(WebViewUI.this, com.tencent.mm.plugin.webview.c.a.font_fade_out);
                      paramAnonymousView.setAnimationListener(new Animation.AnimationListener()
                      {
                        public final void onAnimationEnd(Animation paramAnonymous2Animation)
                        {
                          AppMethodBeat.i(296201);
                          WebViewUI.this.WWW.setVisibility(8);
                          AppMethodBeat.o(296201);
                        }
                        
                        public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                        
                        public final void onAnimationStart(Animation paramAnonymous2Animation) {}
                      });
                      WebViewUI.this.WWW.startAnimation(paramAnonymousView);
                      WebViewUI.this.WWW.setVisibility(8);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$47", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(296202);
                    }
                  });
                }
                ((FontChooserView)localObject1).setOnChangeListener(new d((byte)0));
                localObject3 = new FrameLayout.LayoutParams(-1, -2, 80);
                this.WWW.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                this.WWY.addView(this.WWW);
                this.WWW.setVisibility(8);
                try
                {
                  if (!this.sLC.iwU()) {
                    break label1797;
                  }
                  if ((!iyZ()) && (!iza())) {
                    break label1749;
                  }
                  i = com.tencent.mm.plugin.webview.k.m.lg(getContext());
                }
                catch (Exception localException7)
                {
                  for (;;)
                  {
                    label1245:
                    label1277:
                    Object localObject2;
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
                    break label1802;
                  }
                  j = k;
                }
                ((FontChooserView)localObject1).setSliderIndex(j - 1);
                this.Wzl.att(j);
                atq(j);
                AppMethodBeat.o(80295);
                return;
                localRemoteException = localRemoteException;
                Log.printErrStackTrace("MicroMsg.WebViewUI", localRemoteException, "addCallbacker", new Object[0]);
                continue;
                this.WYq.J(2, com.tencent.mm.plugin.ball.f.b.ahX(dgY()));
                continue;
                this.WYr.J(2, com.tencent.mm.plugin.multitask.g.aNM(((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiC(dgY())));
                continue;
                localObject2 = localRemoteException.LFl;
                continue;
                i = 0;
                continue;
                if (this.WYq != null)
                {
                  localObject2 = this.WYq.cYj();
                  if (localObject2 != null)
                  {
                    localObject3 = ((BallInfo)localObject2).name;
                    if (!Util.isNullOrNil((String)localObject3)) {
                      this.WYo.setTitle((String)localObject3);
                    }
                    this.WYo.setIcon(Util.nullAsNil(((BallInfo)localObject2).icon));
                    continue;
                    ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).a(this.WYo);
                    Log.i("MicroMsg.WebViewUI", "[Handoff] onPostBinded, exist:false, call onWebViewCreate " + this.WYo.toString());
                    continue;
                    bool = str.equalsIgnoreCase("1");
                    continue;
                    localException1 = localException1;
                    Log.e("MicroMsg.DNSPreGetOptimize", "get dns pre get switch failed");
                    continue;
                    try
                    {
                      localObject3 = ((com.tencent.mm.plugin.webview.stub.e)localObject3).blr("DNSAdvanceRelateDomain");
                      if (!Util.isNullOrNil((String)localObject3)) {
                        break label1484;
                      }
                      Log.e("MicroMsg.DNSPreGetOptimize", "domain list is null, just return");
                    }
                    catch (Exception localException2)
                    {
                      Log.printErrStackTrace("MicroMsg.DNSPreGetOptimize", localException2, "", new Object[0]);
                    }
                    continue;
                    com.tencent.mm.plugin.webview.a.a.au(new com.tencent.mm.plugin.webview.model.b.1(localException2, (String)localObject3));
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
                Object localObject3;
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
                localException5.WvS = getString(c.i.webview_menu_tranlate_tips);
                localException5.WvT = getString(c.i.webview_menu_tranlate_tips_brand);
                localException5.WvX.alive();
                try
                {
                  ((WebView)localObject3).invokeMiscMethod("translateWebSite", localBundle);
                }
                catch (Exception localException6)
                {
                  Log.e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", new Object[] { localException6.getMessage() });
                }
                continue;
                label1744:
                i = 0;
                continue;
                label1749:
                i = com.tencent.mm.plugin.webview.k.m.a(getContext(), this.sLC, dgY());
              }
            }
          }
        }
      }
    }
  }
  
  protected int cKY()
  {
    AppMethodBeat.i(80254);
    int i = getActionbarColor();
    AppMethodBeat.o(80254);
    return i;
  }
  
  protected boolean cKZ()
  {
    return false;
  }
  
  public final void cZR()
  {
    AppMethodBeat.i(80302);
    this.WYi.cZR();
    AppMethodBeat.o(80302);
  }
  
  public final void cn(int paramInt, boolean paramBoolean)
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
        i = f.auk(paramInt);
      }
      setStatusBarColor(i);
    }
    AppMethodBeat.o(80257);
  }
  
  public boolean convertActivityFromTranslucent()
  {
    AppMethodBeat.i(80236);
    Intent localIntent = getIntent();
    i.a locala = com.tencent.mm.plugin.webview.core.i.Wya;
    if (!((Boolean)com.tencent.mm.plugin.webview.core.i.isn().getValue()).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      bool = localIntent.getBooleanExtra("convertActivityFromTranslucent", bool);
      AppMethodBeat.o(80236);
      return bool;
    }
  }
  
  public final void d(com.tencent.luggage.xweb_ext.extendplugin.a.a parama)
  {
    AppMethodBeat.i(296687);
    this.Wyj.d(parama);
    AppMethodBeat.o(296687);
  }
  
  public final void d(final Callable<Void> paramCallable)
  {
    AppMethodBeat.i(296576);
    if (com.tencent.mm.kernel.h.baz()) {
      com.tencent.mm.kernel.h.baC();
    }
    for (Object localObject = com.tencent.mm.kernel.b.aZs(); Util.isNullOrNil((String)localObject); localObject = "MMWebViewTransShouldPullHalfScreenNotice")
    {
      Log.e("MicroMsg.WebViewUI", "kvName is null");
      AppMethodBeat.o(296576);
      return;
    }
    MultiProcessMMKV.getSingleMMKV((String)localObject).encode("MMWebViewTransHasPullBefore", true);
    localObject = new com.tencent.mm.ui.widget.a.j(getContext(), 2, 2);
    ((com.tencent.mm.ui.widget.a.j)localObject).bh(getResources().getString(c.i.webview_menu_tranlate_security_title));
    ((com.tencent.mm.ui.widget.a.j)localObject).au(getResources().getString(c.i.app_i_known));
    ((com.tencent.mm.ui.widget.a.j)localObject).aFe(1);
    TextView localTextView = new TextView(getContext());
    localTextView.setTextColor(getResources().getColor(c.c.FG_0));
    localTextView.setText(getResources().getString(c.i.webview_menu_tranlate_security_tips));
    ((com.tencent.mm.ui.widget.a.j)localObject).agfR = new j.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(296412);
        try
        {
          Log.i("MicroMsg.WebViewUI", "notice button clicked!");
          paramCallable.call();
          this.xpj.cyW();
          AppMethodBeat.o(296412);
          return;
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(296412);
        }
      }
    };
    Log.i("MicroMsg.WebViewUI", "show trans notice");
    ((com.tencent.mm.ui.widget.a.j)localObject).setCustomView(localTextView);
    ((com.tencent.mm.ui.widget.a.j)localObject).dDn();
    AppMethodBeat.o(296576);
  }
  
  public final String dgY()
  {
    AppMethodBeat.i(80300);
    try
    {
      String str = BaseWebViewController.bK(getIntent());
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
  
  protected void dhv()
  {
    AppMethodBeat.i(80247);
    Log.i("MicroMsg.WebViewUI", "onCreate" + hashCode());
    this.WFb = new s(this);
    this.WYh = new WebViewLongClickHelper(this);
    this.WYI = true;
    this.WXw = getIntent().getIntExtra("geta8key_session_id", com.tencent.mm.modelsimple.n.bMd());
    this.WXx = getIntent().getByteArrayExtra("geta8key_cookie");
    this.Wzx = getIntent().getIntExtra("screen_orientation", -1);
    this.WXv = getIntent().getBooleanExtra("from_shortcut", false);
    this.WXr = getIntent().getIntExtra(f.s.adwW, -1);
    Log.i("MicroMsg.WebViewUI", "onCreate  itemShowType:" + this.WXr);
    this.INP = getIntent().getStringExtra("status_bar_style");
    this.INO = getIntent().getIntExtra("customize_status_bar_color", 0);
    this.WXV = getIntent().getBooleanExtra("show_native_web_view", false);
    this.mActionBar = getSupportActionBar();
    this.Inv = findViewById(c.f.action_bar_container);
    if ((this.Inv == null) || (!com.tencent.mm.ui.statusbar.c.afCQ)) {}
    for (;;)
    {
      this.WYp = new m(this);
      Object localObject1;
      label297:
      boolean bool;
      label445:
      label764:
      int i;
      label554:
      label842:
      label860:
      Object localObject2;
      label659:
      label671:
      label803:
      int j;
      if (ixy())
      {
        localObject1 = this.WYp;
        if (((m)localObject1).WUp.WGM)
        {
          ((m)localObject1).WUm.setActionbarColor(com.tencent.mm.cd.a.w((Context)((m)localObject1).WUm, c.c.transparent));
          this.Wyj.Xou = true;
          localObject1 = dgY();
          t.bna((String)localObject1);
          this.WXl = ((String)localObject1);
          this.WXV = getIntent().getBooleanExtra("show_native_web_view", false);
          this.WXk = getIntent().getBooleanExtra("key_trust_url", false);
          WXZ += 1;
          Log.i("MicroMsg.WebViewUI", "initView trust:%b, rawUrl = %s ", new Object[] { Boolean.valueOf(this.WXk), localObject1 });
          this.iag = Util.nullAsNil(getIntent().getStringExtra("KPublisherId"));
          this.handler = new MMHandler();
          if ((this.Wye == null) || (!this.Wye.bo(getIntent().getBundleExtra("mm_report_bundle")))) {
            break label2268;
          }
          bool = true;
          this.WXp = bool;
          localObject1 = getIntent().getBundleExtra("close_window_confirm_info");
          if (localObject1 != null) {
            this.WXO = a.bC((Bundle)localObject1);
          }
          getWindow().setFlags(16777216, 16777216);
          getWindow().setFormat(-3);
          ad.a.lq(this);
          this.WYf.cf("onWebViewCreateStart", System.currentTimeMillis());
          if (!t.bnb(dgY())) {
            break label2273;
          }
          this.sMP = MMWebView.a.nK(this);
          com.tencent.xweb.util.l.Br(173L);
          if (this.sMP == null) {
            this.sMP = dhw();
          }
          WebViewLongClickHelper.d(this.sMP);
          this.WYf.cf("onWebViewCreateEnd", System.currentTimeMillis());
          this.sMP.afUt = this;
          this.WYl = new com.tencent.mm.plugin.webview.q();
          initView();
          this.Wzl = dhx();
          if (this.Wzl.Wyi == null) {
            break label2296;
          }
          this.Wyi = this.Wzl.Wyi;
          localObject1 = this.Wyi;
          ((WebViewUIStyleHelper)localObject1).WUm = this;
          if (((WebViewUIStyleHelper)localObject1).WZl != null) {
            break label2284;
          }
          ((WebViewUIStyleHelper)localObject1).WZl = new l(this);
          ((WebViewUIStyleHelper)localObject1).onCreate();
          this.Wyi.izn();
          this.WlX = this.Wzl.getJsapi();
          this.sLD = this.Wzl.sLD;
          if (com.tencent.mm.plugin.webview.ui.tools.floatball.d.izQ()) {
            getIntent().putExtra("webviewCurrentProcess", MMApplicationContext.getProcessName());
          }
          if (this.WlX != null) {
            this.WlX.Iz(false);
          }
          if (this.Wzl.Wyh == null) {
            break label2329;
          }
          this.WYi = this.Wzl.Wyh;
          this.WYi.WOf = new WeakReference(this);
          if (this.Wzl.Wyj == null) {
            break label2473;
          }
          this.Wyj.bm(MMApplicationContext.getContext());
          this.Wyj = this.Wzl.Wyj;
          this.Wyj.bm(this);
          this.Wzl.Wym = this;
          if (!this.WXJ) {
            break label2487;
          }
          this.Wzl.irT();
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(80114);
              WebViewUI.this.Wzl.a(WebViewUI.this.WYQ);
              WebViewUI.d(WebViewUI.this);
              AppMethodBeat.o(80114);
            }
          });
          localObject1 = this.Wzl.Wwm;
          if (!ixy()) {
            break label2501;
          }
          i = 1;
          ((com.tencent.mm.plugin.webview.jsapi.b.b)localObject1).WFk = i;
          this.bYO = ((AccessibilityManager)MMApplicationContext.getContext().getSystemService("accessibility"));
          this.WGt = new AccessibilityManager.AccessibilityStateChangeListener()
          {
            public final void onAccessibilityStateChanged(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(296154);
              if ((WebViewUI.this.sLD != null) && (WebViewUI.this.sLD.iwo() != null) && (WebViewUI.this.sLD.iwo().sk(413)))
              {
                HashMap localHashMap = new HashMap();
                localHashMap.put("isAccessibilityMode", Boolean.valueOf(paramAnonymousBoolean));
                WebViewUI.this.Wzl.getJsapi().Z("onAccessibilityStateChange", localHashMap);
              }
              AppMethodBeat.o(296154);
            }
          };
          this.bYO.addAccessibilityStateChangeListener(this.WGt);
          if (this.Wye != this.Wzl.Wye)
          {
            this.Wye = this.Wzl.Wye;
            this.Wye.bo(getIntent().getBundleExtra("mm_report_bundle"));
          }
          localObject1 = this.Wye.ivC();
          i = this.Wzl.cxN();
          localObject2 = this.iag;
          ((ba.m)localObject1).iiA = i;
          ((ba.m)localObject1).WNh = ((String)localObject2);
          WXA.add(new e(this));
          if (WXA.size() > 1)
          {
            localObject1 = WXA;
            localObject1 = (e)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 2);
            if ((((e)localObject1).tLO != null) && (((e)localObject1).tLO.get() != null)) {
              ((WebViewUI)((e)localObject1).tLO.get()).IB(false);
            }
          }
          bjV("onCreate");
          j = getIntent().getIntExtra("from_scence", 0);
          this.WXq = getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
          localObject1 = this.WYf;
          i = this.WXq;
          if (i == -1) {
            break label2506;
          }
          ((com.tencent.mm.plugin.webview.k.r)localObject1).WXq = i;
          Log.d("MicroMsg.WebViewUI", " onCreate fromScene %d", new Object[] { Integer.valueOf(j) });
          this.sessionId = com.tencent.mm.model.ad.Jo(String.valueOf(this.Wzl.irL()));
          Log.i("MicroMsg.WebViewUI", " onCreate sessionId %s", new Object[] { this.sessionId });
          localObject1 = this.Wye.ivI();
          i = this.Wzl.cxN();
          localObject2 = this.iag;
          ((ba.g)localObject1).iiA = i;
          ((ba.g)localObject1).WNh = ((String)localObject2);
          ((ba.g)localObject1).url = dgY();
          localObject2 = this.Wye.ivO();
          localObject1 = dgY();
          Log.i("MicroMsg.WebviewReporter.DomainReporter", "setRawUrl, value = %s", new Object[] { localObject1 });
        }
      }
      try
      {
        localObject3 = Uri.parse((String)localObject1);
        if ((((Uri)localObject3).getScheme() != null) && (!((Uri)localObject3).getScheme().toLowerCase().startsWith("http")))
        {
          Log.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl scheme is not http/https, skip, scheme = %s", new Object[] { ((Uri)localObject3).getScheme() });
          localObject1 = this.Wye.ivQ();
          localObject2 = getIntent();
          kotlin.g.b.s.u(localObject2, "intent");
        }
      }
      catch (Exception localException3)
      {
        try
        {
          localObject2 = ((Intent)localObject2).getBundleExtra("jsapiargs");
          if (localObject2 != null)
          {
            localObject3 = ((Bundle)localObject2).getByteArray("key_webview_secret_msg_info");
            if (localObject3 != null)
            {
              localObject2 = new ghn();
              ((ghn)localObject2).parseFrom((byte[])localObject3);
              localObject3 = ah.aiuX;
              ((as)localObject1).WMq = ((ghn)localObject2);
            }
          }
          localObject1 = this.Wye.ivQ();
          localObject2 = ((as)localObject1).WMq;
          if (localObject2 != null) {
            ((ghn)localObject2).opType = 2;
          }
          as.a.a(((as)localObject1).WMq);
        }
        catch (Exception localException3)
        {
          try
          {
            this.WYA = getContentView();
            if (this.WYA != null)
            {
              iys();
              ((ViewGroup)((ViewGroup)getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
              {
                public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
                {
                  AppMethodBeat.i(296087);
                  WebViewUI.this.iys();
                  AppMethodBeat.o(296087);
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
                if ((ixy()) && (iyw())) {
                  iyz();
                }
                this.WXe = new com.tencent.mm.bj.a(getContext(), this.WYB);
                com.tencent.mm.plugin.webview.a.a.au(new WebViewUI.51(this));
                this.WYj = new u(this);
                localObject1 = this.WYj;
                Log.i("MicroMsg.WebViewVideoFullScreenHelper", "alive");
                ((u)localObject1).izA();
                localObject2 = ((u)localObject1).iwO();
                if (localObject2 != null) {
                  ((WebViewUI)localObject2).a(((u)localObject1).WZI);
                }
                this.WYt.alive();
                this.WXH.alive();
                if (this.Wyi != null)
                {
                  localObject1 = this.Wyi;
                  if (((WebViewUIStyleHelper)localObject1).WUm != null)
                  {
                    ((WebViewUIStyleHelper)localObject1).sML = ((WebViewUIStyleHelper)localObject1).WUm.fqa();
                    ((WebViewUIStyleHelper)localObject1).webView = ((WebViewUIStyleHelper)localObject1).WUm.sMP;
                    ((WebViewUIStyleHelper)localObject1).WZm = new WebViewTransHelper((WebViewUIStyleHelper)localObject1);
                    Log.i("MicroMsg.WebViewUIStyleHelper", "init transHelper");
                    if (((WebViewUIStyleHelper)localObject1).WZm.irx())
                    {
                      ((WebViewUIStyleHelper)localObject1).WUm.getLifecycle().addObserver(((WebViewUIStyleHelper)localObject1).WZm);
                      localObject2 = new WebViewTransHelper.b(new WeakReference(((WebViewUIStyleHelper)localObject1).WZm));
                      ((WebViewUIStyleHelper)localObject1).WUm.Wzl.a((com.tencent.mm.plugin.webview.core.h)localObject2);
                      localObject2 = ((WebViewUIStyleHelper)localObject1).WUm.Wzl.Wyl;
                      if ((localObject2 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.webview.j)localObject2).WuO))) {
                        break label2705;
                      }
                      ((WebViewUIStyleHelper)localObject1).WZm.biV(Util.getRandomString(32));
                      if ((localObject2 != null) && (((com.tencent.mm.plugin.webview.j)localObject2).WuP != com.tencent.mm.plugin.webview.n.Wvq))
                      {
                        ((WebViewUIStyleHelper)localObject1).WZm.WvE.setValue(((com.tencent.mm.plugin.webview.j)localObject2).WuP);
                        ((WebViewUIStyleHelper)localObject1).webView.reload();
                      }
                    }
                    if (!((WebViewUIStyleHelper)localObject1).WZj) {
                      break label2721;
                    }
                    Log.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle true");
                  }
                }
                if (!iyv()) {
                  break label2738;
                }
                bd(getWindow().getDecorView(), 4866);
                getWindow().addFlags(1024);
                ba.xL(getIntent().getLongExtra("start_activity_time", 0L));
                this.WYs = getIntent().getBooleanExtra(f.s.adxf, false);
                if (((this.WYs) || (iyr())) && (this.sMP != null)) {
                  this.sMP.getSettings().setForceDarkBehavior(1);
                }
                localObject1 = getIntent().getStringExtra("key_first_tips");
                localObject2 = getIntent().getStringExtra("key_first_tips_title");
                if (!Util.isNullOrNil((String)localObject1)) {
                  com.tencent.mm.ui.base.k.a(getContext(), (String)localObject1, (String)localObject2, getString(c.i.app_i_known), false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
                  });
                }
                AppMethodBeat.o(80247);
                return;
                localObject1 = com.tencent.mm.ui.statusbar.c.ch(this);
                localObject2 = new com.tencent.mm.ui.statusbar.c.a()
                {
                  public final void onStatusBarHeightChange(int paramAnonymousInt)
                  {
                    AppMethodBeat.i(296209);
                    WebViewUI.c(WebViewUI.this).setPadding(0, paramAnonymousInt, 0, 0);
                    AppMethodBeat.o(296209);
                  }
                };
                this.Inw = ((com.tencent.mm.ui.statusbar.c.a)localObject2);
                ((com.tencent.mm.ui.statusbar.c)localObject1).a((com.tencent.mm.ui.statusbar.c.a)localObject2);
                getWindow().getDecorView().requestApplyInsets();
                com.tencent.mm.ui.statusbar.d.g(getWindow());
                break;
                ((m)localObject1).WUm.setActionbarColor(com.tencent.mm.cd.a.w((Context)((m)localObject1).WUm, c.c.white_transparent_color));
                break label297;
                if (getIntent() == null)
                {
                  localObject1 = "";
                  label2063:
                  if (getIntent() != null) {
                    break label2219;
                  }
                  bool = false;
                  label2072:
                  Log.i("MicroMsg.WebViewUI", "initCustomActionBarColorIfNeed isNativeStyle is %b", new Object[] { Boolean.valueOf(bool) });
                  if (!bool) {
                    break label2249;
                  }
                  if (!aw.isDarkMode()) {
                    break label2234;
                  }
                  localObject1 = "black";
                  auw(c.c.BG_2);
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
                    label2219:
                    label2234:
                    label2249:
                    localo = null;
                    continue;
                  }
                  if (localObject1 == null) {
                    break;
                  }
                  localObject2 = new Bundle(1);
                  ((Bundle)localObject2).putInt("set_navigation_bar_color_color", ((Integer)localObject1).intValue());
                  ((Bundle)localObject2).putInt("set_navigation_bar_color_alpha", 255);
                  bl((Bundle)localObject2);
                  this.WYp.WUq = true;
                  if (getIntent().hasExtra("customize_status_bar_color")) {
                    break;
                  }
                  this.INO = ((Integer)localObject1).intValue();
                  break;
                  localObject1 = getIntent().getStringExtra("custom_action_bar_color");
                  break label2063;
                  bool = getIntent().getBooleanExtra("open_custom_style_url", false);
                  break label2072;
                  localObject1 = "white";
                  auw(-16777216);
                  continue;
                  if (Util.isNullOrNil((String)localObject1)) {
                    break;
                  }
                }
                label2268:
                bool = false;
                break label445;
                label2273:
                this.sMP = dhw();
                break label554;
                label2284:
                localo.WZl.WUm = this;
                break label659;
                label2296:
                this.Wyi = new WebViewUIStyleHelper(this);
                this.Wzl.Wyi = this.Wyi;
                this.Wyi.izn();
                break label671;
                label2329:
                this.WYi = new o(this);
                this.WYi.WVq = iyv();
                this.Wzl.Wyh = this.WYi;
                this.WYi.ixO();
                o localo = this.WYi;
                if ((localo.iwO() instanceof GameWebViewUI))
                {
                  localo.WVt.add(Integer.valueOf(11));
                  localo.WVt.add(Integer.valueOf(28));
                  break label764;
                }
                localo.WVt.add(Integer.valueOf(7));
                localo.WVt.add(Integer.valueOf(11));
                localo.WVt.add(Integer.valueOf(28));
                break label764;
                label2473:
                this.Wzl.Wyj = this.Wyj;
                break label803;
                label2487:
                this.Wzl.bJ(getIntent());
                break label842;
                label2501:
                i = 0;
                break label860;
                switch (j)
                {
                default: 
                  label2506:
                  i = 999;
                }
                for (;;)
                {
                  localo.WXq = i;
                  break;
                  i = 1;
                  continue;
                  i = 2;
                }
                Object localObject3 = ((Uri)localObject3).getHost();
                if ((localObject3 == null) || (((String)localObject3).toLowerCase().endsWith(".qq.com")))
                {
                  Log.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl, host is .qq.com, skip, host = %s", new Object[] { localObject3 });
                  continue;
                  localException5 = localException5;
                  Log.e("MicroMsg.WebviewReporter.DomainReporter", "parse rawUrl fail, rawUrl = %s", new Object[] { localo });
                }
                else
                {
                  localException5.Akx = true;
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
                label2705:
                localException4.WZm.biV(localException5.WuO);
                continue;
                label2721:
                Log.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle false");
                localException4.izp();
                continue;
                label2738:
                bd(getWindow().getDecorView(), 256);
              }
            }
          }
        }
      }
    }
  }
  
  protected MMWebView dhw()
  {
    AppMethodBeat.i(80260);
    if (com.tencent.mm.plugin.webview.ui.tools.floatball.d.izQ())
    {
      localObject1 = getIntent().getStringExtra("float_ball_key");
      if (!Util.isNullOrNil((String)localObject1))
      {
        Object localObject2 = com.tencent.mm.plugin.webview.ui.tools.floatball.d.XbW;
        localObject2 = com.tencent.mm.plugin.webview.ui.tools.floatball.d.bmc((String)localObject1);
        if (localObject2 != null)
        {
          localObject2 = ((BaseWebViewController)localObject2).sMP;
          if ((localObject2 != null) && (!((MMWebView)localObject2).mDestroyed))
          {
            Log.i("MicroMsg.WebViewUI", "createWebView from cache floatBallKey=%s", new Object[] { localObject1 });
            if (((MMWebView)localObject2).getParent() != null)
            {
              ((ViewGroup)((MMWebView)localObject2).getParent()).removeView((View)localObject2);
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1553L, 21L, 1L, false);
              Log.w("MicroMsg.WebViewUI", "createWebView wv has parent");
            }
            ((MMWebView)localObject2).bm(this);
            ((MMWebView)localObject2).onShow();
            AppMethodBeat.o(80260);
            return localObject2;
          }
        }
      }
      localObject1 = MMWebView.a.nL(new MutableContextWrapper(this));
      AppMethodBeat.o(80260);
      return localObject1;
    }
    Object localObject1 = MMWebView.a.nL(this);
    AppMethodBeat.o(80260);
    return localObject1;
  }
  
  protected com.tencent.mm.plugin.webview.core.k dhx()
  {
    AppMethodBeat.i(296758);
    if (com.tencent.mm.plugin.webview.ui.tools.floatball.d.izQ())
    {
      localObject1 = getIntent().getStringExtra("float_ball_key");
      if (!Util.isNullOrNil((String)localObject1))
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1553L, 1L, 1L, false);
        localObject2 = com.tencent.mm.plugin.webview.ui.tools.floatball.d.XbW;
        localObject2 = com.tencent.mm.plugin.webview.ui.tools.floatball.d.bmc((String)localObject1);
        if ((localObject2 != null) && (((BaseWebViewController)localObject2).sMP != null) && (!((BaseWebViewController)localObject2).sMP.mDestroyed))
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1553L, 2L, 1L, false);
          this.WXJ = true;
          Log.i("MicroMsg.WebViewUI", "createWebViewController from cache floatBallKey=%s", new Object[] { localObject1 });
          AppMethodBeat.o(296758);
          return localObject2;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1553L, 3L, 1L, false);
      }
    }
    Object localObject1 = this.sMP;
    Object localObject2 = this.Wye;
    BaseWebViewController.g localg = new BaseWebViewController.g(getIntent());
    boolean bool2 = getIntent().getBooleanExtra("key_trust_url", false);
    boolean bool3 = ize();
    if ((!iyZ()) && (!iza())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = new com.tencent.mm.plugin.webview.core.k((MMWebView)localObject1, (ba)localObject2, new BaseWebViewController.d(localg, bool2, bool3, bool1, getIntent().getBooleanExtra("neverGetA8Key", false), false));
      if (!this.WXJ) {
        ((com.tencent.mm.plugin.webview.core.k)localObject1).a(this.WYQ);
      }
      ((com.tencent.mm.plugin.webview.core.k)localObject1).init();
      AppMethodBeat.o(296758);
      return localObject1;
    }
  }
  
  public boolean dhy()
  {
    return false;
  }
  
  protected boolean dhz()
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
  
  public final void eAw()
  {
    AppMethodBeat.i(297032);
    if (this.WWX != null)
    {
      hideVKB();
      this.WWX.onKeyBoardStateChange(-2);
    }
    AppMethodBeat.o(297032);
  }
  
  public void finish()
  {
    int i = 1;
    AppMethodBeat.i(80235);
    Log.i("MicroMsg.WebViewUI", "Call finish");
    hideVKB();
    if (this.WXs) {
      setResult(-1);
    }
    if (this.handler != null) {
      this.handler.removeCallbacksAndMessages(null);
    }
    this.WYb = true;
    if ((com.tencent.mm.plugin.webview.ui.tools.floatball.d.izQ()) && (this.sLC != null) && (this.WYr != null) && (this.WYr.gjV())) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.Wzl != null)
      {
        com.tencent.mm.plugin.webview.core.k localk = this.Wzl;
        localk.Ir(bool);
        localk.WwE = true;
      }
      super.finish();
      if ((this.WYr != null) && (this.WYr.gjZ())) {}
      for (;;)
      {
        if ((aw.jlc()) && (i == 0)) {
          overridePendingTransition(0, MMFragmentActivity.a.adFu);
        }
        if (getIntent().getBooleanExtra("KPopUpTransition", false)) {
          overridePendingTransition(com.tencent.mm.plugin.webview.c.a.anim_not_change, com.tencent.mm.plugin.webview.c.a.push_down_out);
        }
        if (this.WYq != null) {
          this.WYq.finish();
        }
        AppMethodBeat.o(80235);
        return;
        i = 0;
      }
    }
  }
  
  public final String fqa()
  {
    AppMethodBeat.i(80259);
    if ((this.Wzl == null) || (Util.isNullOrNil(this.Wzl.getCurrentUrl())))
    {
      str = dgY();
      AppMethodBeat.o(80259);
      return str;
    }
    String str = this.Wzl.getCurrentUrl();
    AppMethodBeat.o(80259);
    return str;
  }
  
  public final int getActionBarHeight()
  {
    AppMethodBeat.i(80250);
    if (getResources().getDimensionPixelSize(c.d.wechat_abc_action_bar_default_height) > com.tencent.mm.cd.a.fromDPToPix(this, 48))
    {
      i = getResources().getDimensionPixelSize(c.d.wechat_abc_action_bar_default_height);
      AppMethodBeat.o(80250);
      return i;
    }
    if (com.tencent.mm.compatible.util.j.isPortOrientation(this))
    {
      i = getResources().getDimensionPixelSize(c.d.DefaultActionbarHeightPort);
      AppMethodBeat.o(80250);
      return i;
    }
    int i = getResources().getDimensionPixelSize(c.d.DefaultActionbarHeightLand);
    AppMethodBeat.o(80250);
    return i;
  }
  
  public int getActionBarHeightFromTheme()
  {
    AppMethodBeat.i(296810);
    int i = getActionBarHeight();
    AppMethodBeat.o(296810);
    return i;
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(296851);
    if (this.Wyj.cuZ())
    {
      i = getRequestedOrientation();
      AppMethodBeat.o(296851);
      return i;
    }
    int i = this.Wzx;
    AppMethodBeat.o(296851);
    return i;
  }
  
  public final MMHandler getHandler()
  {
    return this.handler;
  }
  
  public int getLayoutId()
  {
    return c.g.webview;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(296835);
    String str = this.Wzl.sMP.getSettings().getUserAgentString();
    AppMethodBeat.o(296835);
    return str;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    AppMethodBeat.i(296659);
    if (this.Wzl != null)
    {
      com.tencent.luggage.xweb_ext.extendplugin.b.c localc = this.Wzl.getWebViewPluginClientProxy();
      AppMethodBeat.o(296659);
      return localc;
    }
    AppMethodBeat.o(296659);
    return null;
  }
  
  protected void goBack()
  {
    AppMethodBeat.i(296732);
    if (this.sMP == null)
    {
      AppMethodBeat.o(296732);
      return;
    }
    if (Util.isNullOrNil(fqa()))
    {
      com.tencent.mm.plugin.webview.core.p localp = com.tencent.mm.plugin.webview.core.p.WzF;
      if (!com.tencent.mm.plugin.webview.core.p.isS()) {}
    }
    for (int i = 1; (this.WXS) && (i == 0); i = 0)
    {
      AppMethodBeat.o(296732);
      return;
    }
    if (this.sMP.canGoBack())
    {
      iyF();
      AppMethodBeat.o(296732);
      return;
    }
    r.WWq.close();
    finish();
    AppMethodBeat.o(296732);
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(80361);
    super.hideVKB();
    this.WXG = true;
    this.WYR = -2;
    AppMethodBeat.o(80361);
  }
  
  public void initActivityCloseAnimation()
  {
    AppMethodBeat.i(296726);
    if ((this.WYr != null) && (this.WYr.gjZ())) {}
    for (int i = 1; (aw.jlc()) && (i == 0); i = 0)
    {
      overridePendingTransition(0, MMFragmentActivity.a.adFu);
      AppMethodBeat.o(296726);
      return;
    }
    super.initActivityCloseAnimation();
    AppMethodBeat.o(296726);
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
    this.WXT = true;
    AppMethodBeat.o(80222);
  }
  
  public void initView()
  {
    AppMethodBeat.i(80284);
    this.WWX = ((WebViewKeyboardLinearLayout)findViewById(c.f.webview_keyboard_ll));
    this.WWY = ((FrameLayout)findViewById(c.f.root_container));
    this.WXu = getIntent().getBooleanExtra("finishviewifloadfailed", false);
    this.WXt = getIntent().getBooleanExtra("is_favorite_item", false);
    this.PhI = getIntent().getBooleanExtra("isWebwx", true);
    boolean bool = getIntent().getBooleanExtra("show_feedback", false);
    this.WXR = Util.nullAsNil(getIntent().getStringExtra("sentUsername"));
    if (bool) {
      addTextOptionMenu(1, getString(c.i.settings_feedbackui_title), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(296307);
          try
          {
            paramAnonymousMenuItem = WebViewUI.this.sLC.blw(null);
            WebViewUI.this.loadUrl(paramAnonymousMenuItem);
            AppMethodBeat.o(296307);
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
    this.WWS = ((ProgressBar)findViewById(c.f.create_progress_bar));
    if ((ixy()) && (this.WYp.WUp.WGM)) {
      this.WWS.setIndeterminateDrawable(getResources().getDrawable(c.e.progress_white_medium_holo));
    }
    this.WXQ = findViewById(c.f.refresh_mask);
    this.WXQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(296336);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WebViewUI.this.irV();
        WebViewUI.this.iyY();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(296336);
      }
    });
    if (this.PhI)
    {
      localObject1 = Util.nullAsNil(getIntent().getStringExtra("title"));
      if (((CharSequence)localObject1).length() > 0) {
        this.WWP = true;
      }
      this.WWQ = getIntent().getBooleanExtra("key_show_web_page_title", false);
      setMMTitle((CharSequence)localObject1);
    }
    for (;;)
    {
      this.WUx = findViewById(c.f.web_navigator);
      if (this.WUx != null)
      {
        this.WWT = new n(this.WUx, this.WWX, this.sMP);
        this.WUx.setVisibility(8);
        this.WWU = ((ImageButton)findViewById(c.f.web_back));
        this.WWU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80093);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if ((WebViewUI.this.sMP != null) && (WebViewUI.this.sMP.canGoBack())) {
              WebViewUI.this.iyF();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80093);
          }
        });
        this.WWV = ((ImageButton)findViewById(c.f.web_forward));
        this.WWV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(296205);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if ((WebViewUI.this.sMP != null) && (WebViewUI.this.sMP.canGoForward())) {
              WebViewUI.this.sMP.goForward();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(296205);
          }
        });
      }
      if (this.sMP != null) {
        break;
      }
      Log.i("MicroMsg.WebViewUI", "initView viewWV is null");
      finish();
      AppMethodBeat.o(80284);
      return;
      setMMTitle("");
    }
    if (WXF == WebSettings.RenderPriority.NORMAL)
    {
      Log.i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
      this.sMP.getSettings().a(WebSettings.RenderPriority.HIGH);
      WXF = WebSettings.RenderPriority.HIGH;
    }
    Object localObject3 = this.WYD;
    Object localObject1 = getContentView();
    ((p)localObject3).WVW = ((LogoWebViewWrapper)((View)localObject1).findViewById(c.f.logo_web_view_wrapper));
    ((p)localObject3).WVV = ((ImageView)((View)localObject1).findViewById(c.f.webview_logo_refresh_iv));
    ((p)localObject3).WWe = ((View)localObject1).findViewById(c.f.webview_logo_container);
    if (((p)localObject3).WWe != null)
    {
      ((p)localObject3).WWf = ((p)localObject3).WWe.findViewById(c.f.x5_logo);
      ((p)localObject3).WWg = ((TextView)((p)localObject3).WWf.findViewById(c.f.x5_logo_url));
      ((p)localObject3).WWh = ((TextView)((p)localObject3).WWf.findViewById(c.f.info_txt));
    }
    ((p)localObject3).WVX = BackwardSupportUtil.BitmapFactory.fromDPToPix(((p)localObject3).WVW.getContext(), 72.0F);
    Object localObject2;
    if (((p)localObject3).WVV == null)
    {
      localObject1 = "null";
      if (((p)localObject3).WVW != null) {
        break label1332;
      }
      localObject2 = "null";
      label604:
      Log.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage.id = %s, logoWrapper.id = %s", new Object[] { localObject1, localObject2 });
      Log.d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", new Object[] { Integer.valueOf(((p)localObject3).WVX) });
      localObject1 = this.WYD;
      localObject2 = this.sMP;
      ((MMWebView)localObject2).setCompetitorView(((p)localObject1).WVW);
      ((MMWebView)localObject2).jEV();
      if (Build.VERSION.SDK_INT <= 10) {
        ((p)localObject1).WVW.getWebViewContainer().setBackgroundColor(((p)localObject1).WVW.getResources().getColor(c.c.webview_logo_bg_color));
      }
      localObject3 = ((p)localObject1).WVW;
      ((LogoWebViewWrapper)localObject3).getWebViewContainer();
      if (((LogoWebViewWrapper)localObject3).WSl != null)
      {
        ((LogoWebViewWrapper)localObject3).lKd = ((WebView)localObject2);
        ((LogoWebViewWrapper)localObject3).WSl.addView(((LogoWebViewWrapper)localObject3).lKd);
      }
      if ((!((MMWebView)localObject2).isXWalkKernel()) && (!((MMWebView)localObject2).getIsX5Kernel())) {
        break label1347;
      }
      ((p)localObject1).WWi = true;
      label760:
      if ((((p)localObject1).WWf != null) && (!((MMWebView)localObject2).getIsX5Kernel()))
      {
        ((ImageView)((p)localObject1).WWf.findViewById(c.f.x5_logo_img)).setVisibility(8);
        ((p)localObject1).WWh.setText("");
      }
      if ((!((p)localObject1).WWi) || (((p)localObject1).WWj)) {
        break label1355;
      }
      ((p)localObject1).IJ(false);
      ((p)localObject1).iyc();
    }
    for (;;)
    {
      ixx();
      this.WWZ = ((FrameLayout)findViewById(c.f.container));
      Log.i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.sMP.getIsX5Kernel());
      this.sMP.setWebViewClientExtension(new c(this));
      this.sMP.setWebViewCallbackClient(this.WRh);
      if (this.sMP.getIsX5Kernel())
      {
        localObject1 = this.WYD;
        localObject2 = new LogoWebViewWrapper.a()
        {
          public final void ixl()
          {
            AppMethodBeat.i(296316);
            if (WebViewUI.this.sMP.getIsX5Kernel()) {
              WebViewUI.this.Wye.ivK().H(new Object[] { WebViewUI.this.dgY(), Integer.valueOf(10) }).report();
            }
            AppMethodBeat.o(296316);
          }
        };
        if (((p)localObject1).WVW != null) {
          ((p)localObject1).WVW.setMMOverScrollListener((LogoWebViewWrapper.a)localObject2);
        }
      }
      this.WXh = findViewById(c.f.webview_input_shadow);
      this.WXg = ((WebViewRedesignInputFooter)findViewById(c.f.webview_input_footer));
      if (this.WXg != null)
      {
        this.WXg.setInputShadowView(this.WXh);
        this.WXg.hide();
        this.WXg.setOnTextSendListener(new WebViewRedesignInputFooter.b()
        {
          public final void blS(String paramAnonymousString)
          {
            AppMethodBeat.i(296322);
            WebViewUI.a(WebViewUI.this, paramAnonymousString);
            AppMethodBeat.o(296322);
          }
          
          public final void blT(String paramAnonymousString)
          {
            AppMethodBeat.i(296326);
            WebViewUI.b(WebViewUI.this, paramAnonymousString);
            AppMethodBeat.o(296326);
          }
        });
        this.WXg.setOnSmileyChosenListener(new WebViewRedesignInputFooter.a()
        {
          public final boolean eZ(String paramAnonymousString)
          {
            AppMethodBeat.i(296319);
            com.tencent.mm.plugin.webview.jsapi.j localj;
            if (WebViewUI.this.WlX != null)
            {
              localj = WebViewUI.this.WlX;
              if (localj.UcS) {
                break label44;
              }
              Log.e("MicroMsg.JsApiHandler", "not ready");
            }
            for (;;)
            {
              AppMethodBeat.o(296319);
              return true;
              label44:
              HashMap localHashMap = new HashMap();
              localHashMap.put("smiley", paramAnonymousString);
              MMHandlerThread.postToMainThread(new j.28(localj, com.tencent.mm.plugin.webview.jsapi.p.a.b("onGetSmiley", localHashMap, localj.WDI, localj.KQY)));
            }
          }
        });
        this.WXg.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b()
        {
          public final void iut()
          {
            AppMethodBeat.i(296330);
            WebViewUI.a(WebViewUI.this, 0);
            AppMethodBeat.o(296330);
          }
          
          public final void iuu()
          {
            AppMethodBeat.i(296335);
            WebViewKeyboardLinearLayout localWebViewKeyboardLinearLayout = WebViewUI.this.WWX;
            if ((localWebViewKeyboardLinearLayout != null) && (localWebViewKeyboardLinearLayout.getKeyBoardHeight() > 0)) {
              WebViewUI.a(WebViewUI.this, localWebViewKeyboardLinearLayout.getKeyBoardHeight());
            }
            AppMethodBeat.o(296335);
          }
        });
      }
      this.WXi = ((WebViewSearchContentInputFooter)findViewById(c.f.search_content_input_footer));
      if (this.WXi != null)
      {
        this.WXi.setActionDelegate(new WebViewSearchContentInputFooter.a()
        {
          public final void a(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
          {
            AppMethodBeat.i(296343);
            if (paramAnonymousWebViewSearchContentInputFooter.getVisibility() == 0) {
              b(paramAnonymousWebViewSearchContentInputFooter);
            }
            AppMethodBeat.o(296343);
          }
          
          public final void b(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
          {
            AppMethodBeat.i(296352);
            WebViewUI.this.sMP.clearMatches();
            paramAnonymousWebViewSearchContentInputFooter.reset();
            WebViewUI.this.WXi.S(0, 0, true);
            WebViewUI.a(WebViewUI.this, false);
            WebViewUI.this.sMP.findAllAsync(paramAnonymousWebViewSearchContentInputFooter.getSearchContent());
            AppMethodBeat.o(296352);
          }
          
          public final boolean c(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(296354);
            if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0)) {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(480L, 6L, 1L, false);
            }
            AppMethodBeat.o(296354);
            return false;
          }
          
          public final void iuv()
          {
            AppMethodBeat.i(296340);
            WebViewUI.b(WebViewUI.this, 0);
            WebViewUI.this.sMP.clearMatches();
            WebViewUI.this.WXi.iCA();
            AppMethodBeat.o(296340);
          }
          
          public final void iuw()
          {
            AppMethodBeat.i(296345);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(480L, 5L, 1L, false);
            WebViewUI.this.sMP.findNext(false);
            AppMethodBeat.o(296345);
          }
          
          public final void iux()
          {
            AppMethodBeat.i(296348);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(480L, 4L, 1L, false);
            WebViewUI.this.sMP.findNext(true);
            AppMethodBeat.o(296348);
          }
        });
        this.sMP.setFindListener(new WebView.FindListener()
        {
          public final void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(296374);
            if ((paramAnonymousBoolean) && (!WebViewUI.e(WebViewUI.this)) && (!Util.isNullOrNil(WebViewUI.this.WXi.getSearchContent())))
            {
              if (paramAnonymousInt2 != 0) {
                break label81;
              }
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(480L, 3L, 1L, false);
            }
            for (;;)
            {
              WebViewUI.a(WebViewUI.this, true);
              WebViewUI.this.WXi.S(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
              AppMethodBeat.o(296374);
              return;
              label81:
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(480L, 2L, 1L, false);
            }
          }
        });
      }
      this.WXa = ((MovingImageButton)findViewById(c.f.full_screen_menu));
      this.WXy = findViewById(c.f.webview_input_alert_toast);
      if (this.WXy != null) {
        this.WXy.setVisibility(8);
      }
      this.sMP.setWebChromeClient(iyK());
      this.sMP.setDownloadListener(new DownloadListener()
      {
        public final void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
        {
          AppMethodBeat.i(296390);
          Log.i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + paramAnonymousString1 + ", mimetype = " + paramAnonymousString4 + ", userAgent = " + paramAnonymousString2 + ", contentDisposition = " + paramAnonymousString3);
          int i = WebViewUI.this.getIntent().getIntExtra("key_download_restrict", 0);
          String str = WebViewUI.this.getIntent().getStringExtra("key_function_id");
          if (!Util.isNullOrNil(str)) {
            com.tencent.mm.plugin.report.service.h.OAn.b(14596, new Object[] { str, Integer.valueOf(i), Integer.valueOf(0) });
          }
          if (i == 1)
          {
            Log.e("MicroMsg.WebViewUI", "not allow download file : %s", new Object[] { paramAnonymousString1 });
            AppMethodBeat.o(296390);
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
              f.a(WebViewUI.this.sLC, 11154, new Object[] { paramAnonymousString1 });
            }
          }
          if (WebViewUI.this.sLD == null)
          {
            Log.e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
            AppMethodBeat.o(296390);
            return;
          }
          int j = 0;
          if (paramAnonymousString4 != null)
          {
            boolean bool1 = WebViewUI.izj();
            Log.i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", new Object[] { Boolean.valueOf(bool1) });
            str = WebViewUI.blR(paramAnonymousString3);
            if ((str == null) || (!Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", str))) {
              break label486;
            }
            i = 1;
            boolean bool2 = com.tencent.mm.plugin.webview.core.a.WxU.contains(paramAnonymousString4.toLowerCase());
            if ((!bool1) || ((i == 0) && (!bool2))) {
              break label492;
            }
          }
          label486:
          label492:
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
              f.a(WebViewUI.this.sLC, 18111, new Object[] { WebViewUI.this.fqa(), paramAnonymousString1, paramAnonymousString4, paramAnonymousString3, paramAnonymousString2, Long.valueOf(paramAnonymousLong) });
            }
            if ((j != 0) || (WebViewUI.this.sLD.iwo().sk(24)) || (WebViewUI.f(WebViewUI.this))) {
              break label498;
            }
            Log.e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
            com.tencent.mm.ui.base.aa.showTextToast(WebViewUI.this, WebViewUI.this.getString(c.i.webview_download_failed_toast));
            AppMethodBeat.o(296390);
            return;
            i = 0;
            break;
          }
          label498:
          if ((k != 0) && (((com.tencent.mm.api.r)com.tencent.mm.kernel.h.ax(com.tencent.mm.api.r.class)).aBu()))
          {
            Log.w("MicroMsg.WebViewUI", "onDownloadStart isTeenMode and can not download apk");
            ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(WebViewUI.this);
            AppMethodBeat.o(296390);
            return;
          }
          paramAnonymousString2 = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString1));
          paramAnonymousString2.addFlags(268435456);
          try
          {
            paramAnonymousString1 = WebViewUI.this;
            paramAnonymousString2 = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousString2);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString1, paramAnonymousString2.aYi(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$27", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString1.startActivity((Intent)paramAnonymousString2.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString1, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$27", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(296390);
            return;
          }
          catch (Exception paramAnonymousString1)
          {
            Log.e("MicroMsg.WebViewUI", "startActivity fail, e = " + paramAnonymousString1.getMessage());
            AppMethodBeat.o(296390);
          }
        }
      });
      this.sMP.requestFocus(130);
      this.sMP.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(296387);
          if (WebViewUI.this.Wzl != null) {
            WebViewUI.this.Wzl.It(true);
          }
          if ((WebViewUI.this.WWW != null) && (WebViewUI.this.WWW.getVisibility() == 0))
          {
            Animation localAnimation = AnimationUtils.loadAnimation(WebViewUI.this, com.tencent.mm.plugin.webview.c.a.font_fade_out);
            localAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(296432);
                WebViewUI.this.WWW.setVisibility(8);
                AppMethodBeat.o(296432);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationStart(Animation paramAnonymous2Animation) {}
            });
            WebViewUI.this.WWW.startAnimation(localAnimation);
            WebViewUI.this.WWW.setVisibility(8);
          }
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          while (WebViewUI.this.sMP == null)
          {
            AppMethodBeat.o(296387);
            return false;
            if (!paramAnonymousView.hasFocus()) {
              paramAnonymousView.requestFocus();
            }
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              WebViewUI.this.x_down = ((int)paramAnonymousMotionEvent.getX());
              WebViewUI.this.y_down = ((int)paramAnonymousMotionEvent.getY());
            }
          }
          if ((paramAnonymousMotionEvent.getAction() == 0) || (paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 261) || (paramAnonymousMotionEvent.getAction() == 517))
          {
            if (paramAnonymousMotionEvent.getPointerCount() <= 1) {
              break label269;
            }
            WebViewUI.this.sMP.getSettings().setBuiltInZoomControls(true);
            WebViewUI.this.sMP.getSettings().setSupportZoom(true);
          }
          for (;;)
          {
            AppMethodBeat.o(296387);
            return false;
            label269:
            WebViewUI.this.sMP.getSettings().setBuiltInZoomControls(false);
            WebViewUI.this.sMP.getSettings().setSupportZoom(false);
          }
        }
      });
      this.sMP.jEU();
      this.WYh.fqh();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(296386);
          if (WebViewUI.this.getIntent().getBooleanExtra("hide_close_btn", false))
          {
            AppMethodBeat.o(296386);
            return true;
          }
          WebViewUI.this.hideVKB();
          WebViewUI.this.izc();
          Log.i("MicroMsg.WebViewUI", "on back btn press");
          AppMethodBeat.o(296386);
          return true;
        }
      }, iyL());
      if (iyM()) {
        this.WWX.setOnkbdStateListener(new KeyboardLinearLayout.b()
        {
          public final void onKeyBoardStateChange(int paramAnonymousInt)
          {
            AppMethodBeat.i(296177);
            Log.i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = ".concat(String.valueOf(paramAnonymousInt)));
            WebViewUI.a(WebViewUI.this, WebViewUI.this.WWX, paramAnonymousInt);
            Object localObject1;
            Object localObject2;
            if (paramAnonymousInt == -3)
            {
              WebViewUI.this.Wye.ivG().WMH = 1;
              int i = WebViewUI.this.WWX.getKeyBoardHeight();
              if (i > 0)
              {
                WebViewUI.b(WebViewUI.this, i);
                WebViewUI.a(WebViewUI.this, i);
              }
              if (WebViewUI.h(WebViewUI.this))
              {
                localObject1 = WebViewUI.i(WebViewUI.this);
                if (((WebViewRedesignInputFooter)localObject1).XrS) {
                  ((WebViewRedesignInputFooter)localObject1).setVisibility(8);
                }
                ((WebViewRedesignInputFooter)localObject1).state = 0;
                ((WebViewRedesignInputFooter)localObject1).wi(false);
              }
              localObject2 = WebViewUI.this.Wyj;
              localObject1 = WebViewUI.this;
              kotlin.g.b.s.u(localObject1, "activity");
              localObject2 = ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h)localObject2).Xow;
              if (localObject2 != null)
              {
                if (((com.tencent.mm.plugin.webview.ui.tools.video.b)localObject2).cuZ()) {
                  com.tencent.threadpool.h.ahAA.bk(new com.tencent.mm.plugin.webview.ui.tools.video.b.1((com.tencent.mm.plugin.webview.ui.tools.video.b)localObject2, (Activity)localObject1));
                }
                localObject1 = ah.aiuX;
              }
            }
            do
            {
              WebViewUI.this.aux(paramAnonymousInt);
              WebViewUI.this.WYR = paramAnonymousInt;
              AppMethodBeat.o(296177);
              return;
              WebViewUI.b(WebViewUI.this, 0);
              WebViewUI.a(WebViewUI.this, 0);
              localObject2 = WebViewUI.this.Wyj;
              localObject1 = WebViewUI.this;
              localObject2 = ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h)localObject2).Xow;
            } while (localObject2 == null);
            if ((!((com.tencent.mm.plugin.webview.ui.tools.video.b)localObject2).cuZ()) || (!((com.tencent.mm.plugin.webview.ui.tools.video.b)localObject2).Xop)) {}
            for (;;)
            {
              localObject1 = ah.aiuX;
              break;
              com.tencent.threadpool.h.ahAA.bk(new b.2((com.tencent.mm.plugin.webview.ui.tools.video.b)localObject2, (Activity)localObject1));
            }
          }
        });
      }
      this.WWR = ((MMFalseProgressBar)findViewById(c.f.web_falseprogress));
      this.RnL = new MultiCodeMaskView(this);
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      this.RnL.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.RnL.setVisibility(8);
      ((ViewGroup)getWindow().getDecorView()).addView(this.RnL);
      super.setTitleBarDoubleClickListener(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(296385);
          WebViewUI.this.iyN();
          AppMethodBeat.o(296385);
        }
      });
      AppMethodBeat.o(80284);
      return;
      localObject1 = String.valueOf(((p)localObject3).WVV.getId());
      break;
      label1332:
      localObject2 = String.valueOf(((p)localObject3).WVW.getId());
      break label604;
      label1347:
      ((p)localObject1).WWi = false;
      break label760;
      label1355:
      ((p)localObject1).IJ(true);
    }
  }
  
  public final int irL()
  {
    AppMethodBeat.i(369852);
    int i = this.Wzl.irL();
    AppMethodBeat.o(369852);
    return i;
  }
  
  protected final void irV()
  {
    AppMethodBeat.i(297099);
    if ((this.WYa) || (this.WYb) || (isFinishing()))
    {
      AppMethodBeat.o(297099);
      return;
    }
    if (this.Wzl != null) {
      this.Wzl.irV();
    }
    if (this.WXQ != null) {
      this.WXQ.setVisibility(8);
    }
    this.Wye.ivK().H(new Object[] { dgY(), Integer.valueOf(4) }).report();
    AppMethodBeat.o(297099);
  }
  
  public boolean isSupportNavigationSwipeBack()
  {
    AppMethodBeat.i(296885);
    if (getIntent().getBooleanExtra("hide_close_btn", false))
    {
      Log.w("MicroMsg.WebViewUI", "Close and return are not allowed");
      AppMethodBeat.o(296885);
      return false;
    }
    boolean bool = super.isSupportNavigationSwipeBack();
    AppMethodBeat.o(296885);
    return bool;
  }
  
  public final com.tencent.mm.plugin.webview.stub.f isi()
  {
    return this.WFb;
  }
  
  public final BaseWebViewController isj()
  {
    return this.Wzl;
  }
  
  public final int isk()
  {
    AppMethodBeat.i(296553);
    int i = getIntent().getIntExtra("lastGetA8KeyRequestId", 0);
    AppMethodBeat.o(296553);
    return i;
  }
  
  public final com.tencent.mm.plugin.webview.jsapi.b.a itx()
  {
    AppMethodBeat.i(297052);
    if (this.WlX != null)
    {
      locala = this.WlX.itx();
      AppMethodBeat.o(297052);
      return locala;
    }
    com.tencent.mm.plugin.webview.jsapi.b.a locala = new com.tencent.mm.plugin.webview.jsapi.b.a();
    AppMethodBeat.o(297052);
    return locala;
  }
  
  public final boolean iue()
  {
    AppMethodBeat.i(80354);
    if ((this.WXO != null) && (this.WXO.iuN()) && (!Util.isNullOrNil(this.WXO.izm())) && (!Util.isNullOrNil(this.WXO.iuP())) && (!Util.isNullOrNil(this.WXO.iuQ())))
    {
      Object localObject = this.WXO.izm();
      String str1 = this.WXO.iuP();
      String str2 = this.WXO.iuQ();
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
      this.WXP = com.tencent.mm.ui.base.k.a(getContext(), true, "", localView, str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(296210);
          if ((localCheckBox != null) && (localCheckBox.isChecked())) {}
          try
          {
            if (WebViewUI.this.sLC.iwU()) {
              WebViewUI.this.sLC.np(327792, 1);
            }
            WebViewUI.this.WYa = true;
            WebViewUI.this.WXP = null;
            r.WWq.close();
            ba.e.dh(WebViewUI.this.fqa(), 1);
            if ((WebViewUI.x(WebViewUI.this) != null) && (WebViewUI.x(WebViewUI.this).zX(1)))
            {
              AppMethodBeat.o(296210);
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
            AppMethodBeat.o(296210);
          }
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          WebViewUI.this.WXP = null;
        }
      });
      AppMethodBeat.o(80354);
      return true;
    }
    AppMethodBeat.o(80354);
    return false;
  }
  
  public final boolean iul()
  {
    AppMethodBeat.i(80364);
    boolean bool = getIntent().getBooleanExtra("KRightBtn", false);
    Log.i("MicroMsg.WebViewUI", "enableMinimize:%b, banRightBtn %b", new Object[] { Boolean.valueOf(dhz()), Boolean.valueOf(bool) });
    if ((!bool) && (iyO()) && (dhz()))
    {
      AppMethodBeat.o(80364);
      return true;
    }
    AppMethodBeat.o(80364);
    return false;
  }
  
  public final void iwD()
  {
    AppMethodBeat.i(80228);
    if (this.WYu != null)
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.q localq = this.WYu;
      localq.hide();
      localq.Xqr.setText((CharSequence)"");
    }
    AppMethodBeat.o(80228);
  }
  
  public final boolean iwL()
  {
    boolean bool = true;
    AppMethodBeat.i(296690);
    i.a locala = com.tencent.mm.plugin.webview.core.i.Wya;
    if (com.tencent.mm.plugin.webview.core.j.cTb().getInt("openSnapOauth", 1) == 1) {}
    for (;;)
    {
      Log.i("WebViewCommand", kotlin.g.b.s.X("openSnapOauth = ", Boolean.valueOf(bool)));
      AppMethodBeat.o(296690);
      return bool;
      bool = false;
    }
  }
  
  public final void iwM()
  {
    AppMethodBeat.i(296700);
    com.tencent.mm.plugin.webview.j.b localb = this.WXf;
    kotlin.g.b.s.u(this, "context");
    if (!localb.WQY)
    {
      Log.i("MicroMsg.WebViewSnapshotHelper", "exitSnapshotMode not in snap shot mode now");
      AppMethodBeat.o(296700);
      return;
    }
    Log.i("MicroMsg.WebViewSnapshotHelper", "exitSnapshotMode");
    localb.WQY = false;
    getController().setMMTitleVisibility(0);
    Object localObject = this.sMP;
    if (localObject != null) {
      ((MMWebView)localObject).setVisibility(0);
    }
    localObject = localb.pzj;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(8);
    }
    localb.iwP();
    AppMethodBeat.o(296700);
  }
  
  public final boolean iwN()
  {
    return this.WXf.WQY;
  }
  
  public final JsapiPermissionWrapper iwo()
  {
    AppMethodBeat.i(296541);
    if (this.WXf.WQY)
    {
      localJsapiPermissionWrapper = this.WXf.iwo();
      AppMethodBeat.o(296541);
      return localJsapiPermissionWrapper;
    }
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.Wzl.sLD.iwo();
    AppMethodBeat.o(296541);
    return localJsapiPermissionWrapper;
  }
  
  public void ixS()
  {
    AppMethodBeat.i(80303);
    this.WYi.ixS();
    AppMethodBeat.o(80303);
  }
  
  public final void ixU()
  {
    AppMethodBeat.i(80305);
    this.WYi.ixU();
    AppMethodBeat.o(80305);
  }
  
  protected void ixx()
  {
    AppMethodBeat.i(80278);
    int i = getIntent().getIntExtra("webview_bg_color_rsID", -1);
    if ((i != -1) && (getContentView() != null))
    {
      setBackGroundColorResource(i);
      getContentView().setBackgroundResource(i);
      this.sMP.setBackgroundColor(0);
      this.WWX.setBackgroundResource(17170445);
      this.WWY.setBackgroundResource(17170445);
      this.WYD.aut(0);
    }
    for (;;)
    {
      if (ixy())
      {
        this.WYD.iyd();
        this.WYD.iyb();
      }
      AppMethodBeat.o(80278);
      return;
      if (getIntent().getBooleanExtra(f.s.adxf, false)) {
        this.sMP.setBackgroundColor(getResources().getColor(c.c.White));
      } else {
        this.sMP.setBackgroundColor(getResources().getColor(c.c.white));
      }
    }
  }
  
  public final WebViewUIStyleHelper.a iyA()
  {
    AppMethodBeat.i(296831);
    if (this.Wyi == null)
    {
      AppMethodBeat.o(296831);
      return null;
    }
    WebViewUIStyleHelper.a locala = WebViewUIStyleHelper.blV(fqa());
    AppMethodBeat.o(296831);
    return locala;
  }
  
  public final String iyB()
  {
    return this.Wzl.Wyu;
  }
  
  public final void iyD()
  {
    AppMethodBeat.i(80272);
    Log.i("MicroMsg.WebViewUI", "forceQuit");
    try
    {
      this.WYD.release();
      this.sMP.stopLoading();
      this.sMP.removeAllViews();
      this.sMP.clearView();
      if (this.WlX != null) {
        this.WlX.detach();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        this.sMP.destroy();
        finish();
        Log.appenderFlush();
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI", "forceQuit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)locala.sb(0)).intValue());
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
  
  protected void iyF()
  {
    AppMethodBeat.i(80275);
    this.WXo = System.currentTimeMillis();
    this.sMP.goBack();
    r localr = r.WWq;
    Log.v("MicroMsg.WebViewReportUtil", "goBack traceid %s", new Object[] { localr.traceid });
    if (!Util.isNullOrNil(localr.traceid)) {
      localr.rG(5);
    }
    AppMethodBeat.o(80275);
  }
  
  protected final void iyG()
  {
    AppMethodBeat.i(296904);
    if (this.WXg == null)
    {
      AppMethodBeat.o(296904);
      return;
    }
    this.WXg.hide();
    AppMethodBeat.o(296904);
  }
  
  protected int iyH()
  {
    AppMethodBeat.i(80277);
    if (this.WXg == null)
    {
      AppMethodBeat.o(80277);
      return 0;
    }
    WebViewRedesignInputFooter localWebViewRedesignInputFooter = this.WXg;
    localWebViewRedesignInputFooter.setVisibility(0);
    if (localWebViewRedesignInputFooter.FPs != null) {
      localWebViewRedesignInputFooter.FPs.setVisibility(8);
    }
    localWebViewRedesignInputFooter.XrS = true;
    localWebViewRedesignInputFooter.state = 1;
    int i = localWebViewRedesignInputFooter.iyH();
    AppMethodBeat.o(80277);
    return i;
  }
  
  protected void iyI()
  {
    AppMethodBeat.i(80279);
    if (getIntent() == null)
    {
      AppMethodBeat.o(80279);
      return;
    }
    if (getIntent().hasExtra("show_full_screen")) {
      bD(getIntent().getBooleanExtra("show_full_screen", false), true);
    }
    AppMethodBeat.o(80279);
  }
  
  public final boolean iyJ()
  {
    AppMethodBeat.i(296921);
    if ((this.WXb) || (this.Wyj.cuZ()) || ((this.WYw != null) && (this.WYw.cuZ())))
    {
      AppMethodBeat.o(296921);
      return true;
    }
    AppMethodBeat.o(296921);
    return false;
  }
  
  protected com.tencent.xweb.z iyK()
  {
    try
    {
      AppMethodBeat.i(80286);
      if (this.WXD == null) {
        this.WXD = new MMWebView.c(new b());
      }
      com.tencent.xweb.z localz = this.WXD;
      AppMethodBeat.o(80286);
      return localz;
    }
    finally {}
  }
  
  protected int iyL()
  {
    AppMethodBeat.i(80287);
    if (this.WXV)
    {
      i = c.h.actionbar_icon_dark_back;
      AppMethodBeat.o(80287);
      return i;
    }
    int i = c.h.actionbar_icon_dark_close;
    AppMethodBeat.o(80287);
    return i;
  }
  
  protected boolean iyM()
  {
    return true;
  }
  
  public final void iyN()
  {
    AppMethodBeat.i(175800);
    View localView = this.sMP.getView();
    localView.scrollTo(localView.getScrollX(), 0);
    this.Wye.ivK().H(new Object[] { dgY(), Integer.valueOf(7) }).report();
    AppMethodBeat.o(175800);
  }
  
  protected com.tencent.mm.plugin.webview.jsapi.k iyP()
  {
    return null;
  }
  
  protected boolean iyQ()
  {
    return false;
  }
  
  public final int iyR()
  {
    AppMethodBeat.i(297014);
    int i = -1;
    WebViewUIStyleHelper.a locala = iyA();
    if (locala != null) {
      i = locala.nQm;
    }
    Log.i("MicroMsg.WebViewUI", "getCurrentMPPageItemShowType  itemShowType:".concat(String.valueOf(i)));
    AppMethodBeat.o(297014);
    return i;
  }
  
  protected final LinkedList<e.a> iyS()
  {
    AppMethodBeat.i(80307);
    if (this.sMP == null)
    {
      Log.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
      AppMethodBeat.o(80307);
      return null;
    }
    Object localObject = dgY();
    if (this.sMP != null)
    {
      String str = this.sMP.getUrl();
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
              if (this.WXW == null)
              {
                l = System.currentTimeMillis();
                this.WXW = this.sLC.iwZ();
                if (this.WXW == null) {
                  break label281;
                }
              }
              label281:
              for (bool = true;; bool = false)
              {
                Log.d("MicroMsg.WebViewUI", "[hakon] getConfigListMap %b, cost %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
                if ((this.WXW == null) || (this.WXW.size() <= 0)) {
                  break;
                }
                localObject = com.tencent.mm.k.e.r(this.WXW);
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
  
  protected final int iyT()
  {
    AppMethodBeat.i(80314);
    int i = c.h.icons_outlined_more;
    if (iyS() != null) {
      i = c.h.mm_title_btn_jd;
    }
    AppMethodBeat.o(80314);
    return i;
  }
  
  protected boolean iyV()
  {
    AppMethodBeat.i(80320);
    if (this.WXn)
    {
      AppMethodBeat.o(80320);
      return true;
    }
    if ((this.sMP != null) && ((this.sMP.canGoBack()) || (this.sMP.canGoForward())) && (this.WWT != null))
    {
      Object localObject1 = this.WWT;
      Object localObject2;
      if (((n)localObject1).WUD == null)
      {
        localObject2 = MultiProcessMMKV.getMMKV("WebViewUIShowBottom");
        kotlin.g.b.s.checkNotNull(localObject2);
        if (((MultiProcessMMKV)localObject2).decodeInt("WebViewUIShowBottomNav", 0) != 1) {
          break label131;
        }
        ((n)localObject1).WUD = Boolean.TRUE;
      }
      for (;;)
      {
        localObject1 = ((n)localObject1).WUD;
        kotlin.g.b.s.checkNotNull(localObject1);
        if (!((Boolean)localObject1).booleanValue()) {
          break;
        }
        this.WXm = false;
        this.WXn = true;
        AppMethodBeat.o(80320);
        return true;
        label131:
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yML, 0) == 1) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label183;
          }
          Log.i(n.TAG, "needShowBottomNavigator not open");
          ((n)localObject1).WUD = Boolean.FALSE;
          break;
        }
        label183:
        ((n)localObject1).WUD = Boolean.valueOf(((n)localObject1).ixB());
        Log.i(n.TAG, "needShowBottomNavigator deviceShowBottomNav %b", new Object[] { ((n)localObject1).WUD });
        localObject2 = ((n)localObject1).WUD;
        kotlin.g.b.s.checkNotNull(localObject2);
        if (((Boolean)localObject2).booleanValue())
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(18210, new Object[] { Integer.valueOf(1) });
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1160L, 0L, 1L, false);
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1160L, 2L, 1L, false);
        }
      }
    }
    AppMethodBeat.o(80320);
    return false;
  }
  
  protected final void iyW()
  {
    AppMethodBeat.i(80344);
    this.WXQ.setVisibility(0);
    iyX();
    AppMethodBeat.o(80344);
  }
  
  protected final void iyX()
  {
    AppMethodBeat.i(297060);
    if ((this.WWS != null) && (this.WWS.getVisibility() == 0)) {
      this.WWS.setVisibility(8);
    }
    AppMethodBeat.o(297060);
  }
  
  protected final void iyY()
  {
    AppMethodBeat.i(297063);
    if ((this.WWS != null) && (ixy()))
    {
      this.WWS.setVisibility(0);
      this.WXU = true;
    }
    AppMethodBeat.o(297063);
  }
  
  protected boolean iyZ()
  {
    return false;
  }
  
  protected final boolean iyf()
  {
    return this.Wzl.Wxq;
  }
  
  protected final Map<String, String> iyg()
  {
    return this.Wzl.WwI;
  }
  
  public final HandOffURL iyi()
  {
    return this.WYo;
  }
  
  public final com.tencent.mm.plugin.webview.ui.tools.multitask.a iyj()
  {
    return this.WYr;
  }
  
  protected final ar iyk()
  {
    return this.Wzl.Wyr;
  }
  
  protected final k iym()
  {
    AppMethodBeat.i(296613);
    k localk = new k(this);
    AppMethodBeat.o(296613);
    return localk;
  }
  
  public final MPVideoPlayFullScreenView iyo()
  {
    AppMethodBeat.i(80224);
    if (this.WYw == null)
    {
      this.WYw = new MPVideoPlayFullScreenView(this, null);
      this.WYw.setVisibility(8);
      localObject = (ViewParent)getWindow().getDecorView();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).addView(this.WYw, new FrameLayout.LayoutParams(-1, -1));
      }
    }
    Object localObject = this.WYw;
    AppMethodBeat.o(80224);
    return localObject;
  }
  
  public final boolean iyp()
  {
    AppMethodBeat.i(296663);
    boolean bool = this.Wyj.iyp();
    AppMethodBeat.o(296663);
    return bool;
  }
  
  public final boolean iyq()
  {
    AppMethodBeat.i(296694);
    if ((this.sLD != null) && (this.sLD.iwp() != null))
    {
      if ((this.sLD.iwp().YxC & 0x10000) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.GeneralControlWrapper", "allowMsgTail, ret = ".concat(String.valueOf(bool)));
        if (!bool) {
          break;
        }
        AppMethodBeat.o(296694);
        return true;
      }
    }
    AppMethodBeat.o(296694);
    return false;
  }
  
  public final void iys()
  {
    AppMethodBeat.i(80251);
    if ((this.WYA == null) || (iyt()))
    {
      AppMethodBeat.o(80251);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.WYA.getLayoutParams();
    int i = iyu();
    if (i != localMarginLayoutParams.topMargin)
    {
      localMarginLayoutParams.topMargin = i;
      this.WYA.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(80251);
  }
  
  protected boolean iyw()
  {
    return true;
  }
  
  protected final int iyx()
  {
    AppMethodBeat.i(296824);
    if ((com.tencent.mm.compatible.util.d.rb(21)) && (iyy()))
    {
      AppMethodBeat.o(296824);
      return -16777216;
    }
    if (aw.isDarkMode())
    {
      AppMethodBeat.o(296824);
      return -1;
    }
    AppMethodBeat.o(296824);
    return -16777216;
  }
  
  protected final void iyz()
  {
    AppMethodBeat.i(80256);
    if ((com.tencent.mm.compatible.util.d.rb(21)) && (this.INO != 0))
    {
      setActionbarColor(this.INO);
      AppMethodBeat.o(80256);
      return;
    }
    setStatusBarColor(cKY());
    AppMethodBeat.o(80256);
  }
  
  protected boolean iza()
  {
    return false;
  }
  
  protected void izc()
  {
    AppMethodBeat.i(80356);
    if (izb())
    {
      AppMethodBeat.o(80356);
      return;
    }
    izd();
    if (!iue())
    {
      this.WYa = true;
      r.WWq.close();
      if (!this.WYc) {
        ba.e.dh(fqa(), 1);
      }
      if ((this.WYr != null) && (this.WYr.zX(1)))
      {
        AppMethodBeat.o(80356);
        return;
      }
      finish();
    }
    AppMethodBeat.o(80356);
  }
  
  protected boolean ize()
  {
    return true;
  }
  
  protected final boolean izf()
  {
    AppMethodBeat.i(80360);
    if (this.WYR != -3)
    {
      showVKB();
      AppMethodBeat.o(80360);
      return true;
    }
    AppMethodBeat.o(80360);
    return false;
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
    if (this.Wzl != null) {
      this.Wzl.loadUrl(paramString, paramMap, paramBoolean);
    }
    AppMethodBeat.o(80297);
  }
  
  public boolean moveTaskToBack(boolean paramBoolean)
  {
    AppMethodBeat.i(296733);
    paramBoolean = super.moveTaskToBack(paramBoolean);
    initActivityCloseAnimation();
    AppMethodBeat.o(296733);
    return paramBoolean;
  }
  
  public boolean needShowIdcError()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(80289);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.luggage.l.e.bt(this).onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.sLM.d(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(80289);
      return;
    }
    if (this.WYE.d(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(80289);
      return;
    }
    if (this.WYF.d(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(80289);
      return;
    }
    if (paramInt1 == 206)
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
      this.WYa = true;
      r.WWq.close();
      ba.e.dh(fqa(), 1);
      setResult(-1, paramIntent);
      finish();
    }
    AppMethodBeat.o(80289);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(297114);
    if ((this.RnL != null) && (this.RnL.getVisibility() == 0))
    {
      long l = 0L;
      if (this.WYh != null) {
        l = this.WYh.GYk.longValue();
      }
      this.RnL.P(l, false);
      AppMethodBeat.o(297114);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(297114);
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(80291);
    if (this.sMP != null)
    {
      if (!this.WYG) {
        break label42;
      }
      this.sMP.setOnLongClickListener(this.WYH);
    }
    for (;;)
    {
      super.onCancel();
      AppMethodBeat.o(80291);
      return;
      label42:
      this.WYh.fqh();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(80265);
    super.onConfigurationChanged(paramConfiguration);
    if (this.vPB != paramConfiguration.orientation)
    {
      View localView = iyC();
      if (localView == null) {}
      for (localView = null; localView == null; localView = (View)localView.getParent())
      {
        AppMethodBeat.o(80265);
        return;
      }
      localView.dispatchConfigurationChanged(paramConfiguration);
      localView.requestLayout();
      this.vPB = paramConfiguration.orientation;
    }
    AppMethodBeat.o(80265);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80244);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zqX, true)) {
      AccessibilityUtil.smartDisableAccessibility();
    }
    com.tencent.mm.plugin.webview.k.r localr = this.WYf;
    localr.createTime = System.currentTimeMillis();
    localr.cf("onCreate", localr.createTime);
    this.WYf.XtF = getIntent().getLongExtra("startTime", 0L);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.WYf.cf("onUIInitStart", System.currentTimeMillis());
    dhv();
    this.WYf.cf("onUIInitEnd", System.currentTimeMillis());
    paramBundle = getIntent();
    if (aw.jlc()) {
      overridePendingTransition(MMFragmentActivity.a.adFr, 0);
    }
    if ((paramBundle.hasExtra("nextAnimIn")) || (paramBundle.hasExtra("currentAnimOut"))) {
      overridePendingTransition(paramBundle.getIntExtra("nextAnimIn", com.tencent.mm.plugin.webview.c.a.slide_right_in), paramBundle.getIntExtra("currentAnimOut", com.tencent.mm.plugin.webview.c.a.slide_left_out));
    }
    if (paramBundle.getBooleanExtra("KPopUpTransition", false)) {
      overridePendingTransition(com.tencent.mm.plugin.webview.c.a.push_up_in, com.tencent.mm.plugin.webview.c.a.anim_not_change);
    }
    ba.xM(0L);
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
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: ldc_w 4596
    //   3: invokestatic 393	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 764
    //   9: ldc_w 4598
    //   12: iconst_1
    //   13: anewarray 1151	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_0
    //   19: getfield 508	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
    //   22: invokevirtual 879	com/tencent/mm/plugin/webview/core/k:irL	()I
    //   25: invokestatic 1255	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: aastore
    //   29: invokestatic 1154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: invokestatic 2968	com/tencent/mm/plugin/webview/ui/tools/floatball/d:izQ	()Z
    //   35: ifeq +2283 -> 2318
    //   38: aload_0
    //   39: getfield 934	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYr	Lcom/tencent/mm/plugin/webview/ui/tools/multitask/a;
    //   42: ifnull +2276 -> 2318
    //   45: aload_0
    //   46: getfield 934	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYr	Lcom/tencent/mm/plugin/webview/ui/tools/multitask/a;
    //   49: invokevirtual 3540	com/tencent/mm/plugin/webview/ui/tools/multitask/a:gjV	()Z
    //   52: ifeq +2266 -> 2318
    //   55: aload_0
    //   56: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   59: ifnull +2259 -> 2318
    //   62: aload_0
    //   63: invokevirtual 1865	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:iyR	()I
    //   66: bipush 16
    //   68: if_icmpne +251 -> 319
    //   71: ldc_w 764
    //   74: ldc_w 4600
    //   77: invokestatic 911	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload_0
    //   81: getfield 1796	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYi	Lcom/tencent/mm/plugin/webview/ui/tools/o;
    //   84: invokevirtual 4603	com/tencent/mm/plugin/webview/ui/tools/o:ixN	()V
    //   87: aload_0
    //   88: getfield 1103	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wyi	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;
    //   91: getfield 2198	com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper:WZm	Lcom/tencent/mm/plugin/webview/WebViewTransHelper;
    //   94: ifnull +90 -> 184
    //   97: aload_0
    //   98: getfield 1103	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wyi	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;
    //   101: getfield 2198	com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper:WZm	Lcom/tencent/mm/plugin/webview/WebViewTransHelper;
    //   104: getfield 4606	com/tencent/mm/plugin/webview/WebViewTransHelper:WvI	Ljava/lang/String;
    //   107: invokestatic 921	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   110: ifne +74 -> 184
    //   113: new 3259	com/tencent/mm/plugin/webview/j
    //   116: dup
    //   117: invokespecial 4607	com/tencent/mm/plugin/webview/j:<init>	()V
    //   120: astore 7
    //   122: aload 7
    //   124: aload_0
    //   125: getfield 1103	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wyi	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;
    //   128: getfield 2198	com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper:WZm	Lcom/tencent/mm/plugin/webview/WebViewTransHelper;
    //   131: getfield 4606	com/tencent/mm/plugin/webview/WebViewTransHelper:WvI	Ljava/lang/String;
    //   134: putfield 3262	com/tencent/mm/plugin/webview/j:WuO	Ljava/lang/String;
    //   137: aload_0
    //   138: getfield 1103	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wyi	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;
    //   141: getfield 2198	com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper:WZm	Lcom/tencent/mm/plugin/webview/WebViewTransHelper;
    //   144: getfield 3281	com/tencent/mm/plugin/webview/WebViewTransHelper:WvE	Landroidx/lifecycle/x;
    //   147: invokevirtual 4608	androidx/lifecycle/x:getValue	()Ljava/lang/Object;
    //   150: checkcast 3274	com/tencent/mm/plugin/webview/n
    //   153: astore 8
    //   155: aload 8
    //   157: ifnull +18 -> 175
    //   160: aload 8
    //   162: ldc_w 4610
    //   165: invokestatic 2290	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   168: aload 7
    //   170: aload 8
    //   172: putfield 3272	com/tencent/mm/plugin/webview/j:WuP	Lcom/tencent/mm/plugin/webview/n;
    //   175: aload_0
    //   176: getfield 508	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
    //   179: aload 7
    //   181: putfield 3257	com/tencent/mm/plugin/webview/core/k:Wyl	Lcom/tencent/mm/plugin/webview/j;
    //   184: iconst_1
    //   185: istore_1
    //   186: aload_0
    //   187: invokespecial 4612	com/tencent/mm/plugin/secdata/ui/MMSecDataActivity:onDestroy	()V
    //   190: getstatic 4617	com/tencent/mm/plugin/webview/modeltools/c:WNp	Ljava/util/ArrayList;
    //   193: ifnull +443 -> 636
    //   196: getstatic 4617	com/tencent/mm/plugin/webview/modeltools/c:WNp	Ljava/util/ArrayList;
    //   199: invokevirtual 3068	java/util/ArrayList:size	()I
    //   202: istore_2
    //   203: ldc_w 4619
    //   206: ldc_w 4621
    //   209: iconst_1
    //   210: anewarray 1151	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: iload_2
    //   216: invokestatic 1255	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: aastore
    //   220: invokestatic 1154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: getstatic 4617	com/tencent/mm/plugin/webview/modeltools/c:WNp	Ljava/util/ArrayList;
    //   226: invokestatic 4624	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   229: ifne +602 -> 831
    //   232: getstatic 4617	com/tencent/mm/plugin/webview/modeltools/c:WNp	Ljava/util/ArrayList;
    //   235: invokestatic 4624	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   238: ifne +550 -> 788
    //   241: getstatic 4617	com/tencent/mm/plugin/webview/modeltools/c:WNp	Ljava/util/ArrayList;
    //   244: invokeinterface 4627 1 0
    //   249: astore 9
    //   251: aload 9
    //   253: invokeinterface 1126 1 0
    //   258: ifeq +512 -> 770
    //   261: aload 9
    //   263: invokeinterface 1130 1 0
    //   268: checkcast 872	java/lang/String
    //   271: astore 10
    //   273: ldc_w 4619
    //   276: ldc_w 4629
    //   279: iconst_1
    //   280: anewarray 1151	java/lang/Object
    //   283: dup
    //   284: iconst_0
    //   285: aload 10
    //   287: aastore
    //   288: invokestatic 1154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   291: aload 10
    //   293: invokestatic 4634	com/tencent/xweb/ao:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   296: astore 7
    //   298: aload 7
    //   300: invokestatic 921	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   303: ifeq +338 -> 641
    //   306: aconst_null
    //   307: astore 7
    //   309: aload 10
    //   311: aload 7
    //   313: invokestatic 4638	com/tencent/mm/plugin/webview/modeltools/c:O	(Ljava/lang/String;Ljava/util/List;)V
    //   316: goto -65 -> 251
    //   319: aload_0
    //   320: getfield 934	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYr	Lcom/tencent/mm/plugin/webview/ui/tools/multitask/a;
    //   323: getfield 2386	com/tencent/mm/plugin/multitask/b/a:LCE	Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;
    //   326: astore 7
    //   328: aload 7
    //   330: ifnull +14 -> 344
    //   333: aload 7
    //   335: getfield 4641	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:field_id	Ljava/lang/String;
    //   338: invokestatic 921	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   341: ifeq +29 -> 370
    //   344: ldc_w 764
    //   347: ldc_w 4643
    //   350: invokestatic 911	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   353: getstatic 2069	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   356: ldc2_w 3457
    //   359: ldc2_w 4644
    //   362: lconst_1
    //   363: iconst_0
    //   364: invokevirtual 3464	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   367: goto -287 -> 80
    //   370: aload 7
    //   372: getfield 4641	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:field_id	Ljava/lang/String;
    //   375: astore 7
    //   377: ldc_w 764
    //   380: ldc_w 4647
    //   383: iconst_1
    //   384: anewarray 1151	java/lang/Object
    //   387: dup
    //   388: iconst_0
    //   389: aload 7
    //   391: aastore
    //   392: invokestatic 1154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   395: aload_0
    //   396: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   399: ifnull +178 -> 577
    //   402: aload_0
    //   403: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   406: invokevirtual 3453	com/tencent/mm/ui/widget/MMWebView:getParent	()Landroid/view/ViewParent;
    //   409: ifnull +168 -> 577
    //   412: aload_0
    //   413: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   416: invokevirtual 4650	com/tencent/mm/ui/widget/MMWebView:getActivityContextIfHas	()Landroid/content/Context;
    //   419: aload_0
    //   420: if_acmpne +157 -> 577
    //   423: aload_0
    //   424: getfield 491	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wyj	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/h;
    //   427: invokevirtual 3601	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:cuZ	()Z
    //   430: ifeq +12 -> 442
    //   433: aload_0
    //   434: getfield 491	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wyj	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/h;
    //   437: iconst_1
    //   438: invokevirtual 4653	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:IY	(Z)Z
    //   441: pop
    //   442: aload_0
    //   443: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   446: invokevirtual 4656	com/tencent/mm/ui/widget/MMWebView:onHide	()V
    //   449: aload_0
    //   450: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   453: invokevirtual 3453	com/tencent/mm/ui/widget/MMWebView:getParent	()Landroid/view/ViewParent;
    //   456: checkcast 1389	android/view/ViewGroup
    //   459: aload_0
    //   460: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   463: invokevirtual 3456	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   466: aload_0
    //   467: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   470: invokestatic 2996	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   473: invokevirtual 3467	com/tencent/mm/ui/widget/MMWebView:bm	(Landroid/content/Context;)V
    //   476: aload_0
    //   477: getfield 478	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
    //   480: ifnull +11 -> 491
    //   483: aload_0
    //   484: getfield 478	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
    //   487: iconst_1
    //   488: invokevirtual 2978	com/tencent/mm/plugin/webview/jsapi/j:Iz	(Z)V
    //   491: aload_0
    //   492: getfield 508	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
    //   495: getfield 1093	com/tencent/mm/plugin/webview/core/k:Wyk	Lcom/tencent/mm/plugin/webview/ui/tools/floatball/c;
    //   498: astore 8
    //   500: aload_0
    //   501: invokevirtual 4659	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getMMTitle	()Ljava/lang/CharSequence;
    //   504: ifnull +44 -> 548
    //   507: aload_0
    //   508: invokevirtual 4100	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getController	()Lcom/tencent/mm/ui/y;
    //   511: astore 9
    //   513: aload 9
    //   515: getfield 4662	com/tencent/mm/ui/y:adDZ	Landroid/widget/TextView;
    //   518: ifnull +113 -> 631
    //   521: aload 9
    //   523: getfield 4662	com/tencent/mm/ui/y:adDZ	Landroid/widget/TextView;
    //   526: invokevirtual 4663	android/widget/TextView:getVisibility	()I
    //   529: istore_1
    //   530: iload_1
    //   531: ifne +17 -> 548
    //   534: aload 8
    //   536: aload_0
    //   537: invokevirtual 4659	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getMMTitle	()Ljava/lang/CharSequence;
    //   540: invokeinterface 1421 1 0
    //   545: putfield 1098	com/tencent/mm/plugin/webview/ui/tools/floatball/c:title	Ljava/lang/String;
    //   548: getstatic 3439	com/tencent/mm/plugin/webview/ui/tools/floatball/d:XbW	Lcom/tencent/mm/plugin/webview/ui/tools/floatball/d;
    //   551: astore 8
    //   553: aload 7
    //   555: aload_0
    //   556: getfield 508	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
    //   559: invokestatic 4666	com/tencent/mm/plugin/webview/ui/tools/floatball/d:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/core/k;)V
    //   562: getstatic 2069	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   565: ldc2_w 3457
    //   568: lconst_0
    //   569: lconst_1
    //   570: iconst_0
    //   571: invokevirtual 3464	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   574: goto -494 -> 80
    //   577: getstatic 2069	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   580: ldc2_w 3457
    //   583: ldc2_w 4667
    //   586: lconst_1
    //   587: iconst_0
    //   588: invokevirtual 3464	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   591: aload_0
    //   592: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   595: ifnonnull +30 -> 625
    //   598: iconst_1
    //   599: istore 4
    //   601: ldc_w 764
    //   604: ldc_w 4670
    //   607: iconst_1
    //   608: anewarray 1151	java/lang/Object
    //   611: dup
    //   612: iconst_0
    //   613: iload 4
    //   615: invokestatic 1293	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   618: aastore
    //   619: invokestatic 4227	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   622: goto -146 -> 476
    //   625: iconst_0
    //   626: istore 4
    //   628: goto -27 -> 601
    //   631: iconst_0
    //   632: istore_1
    //   633: goto -103 -> 530
    //   636: iconst_0
    //   637: istore_2
    //   638: goto -435 -> 203
    //   641: aload 7
    //   643: ldc_w 4672
    //   646: invokevirtual 4676	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   649: astore 7
    //   651: aload 7
    //   653: arraylength
    //   654: istore_3
    //   655: iconst_0
    //   656: istore_2
    //   657: iload_2
    //   658: iload_3
    //   659: if_icmpge +21 -> 680
    //   662: aload 7
    //   664: iload_2
    //   665: aload 7
    //   667: iload_2
    //   668: aaload
    //   669: invokevirtual 4679	java/lang/String:trim	()Ljava/lang/String;
    //   672: aastore
    //   673: iload_2
    //   674: iconst_1
    //   675: iadd
    //   676: istore_2
    //   677: goto -20 -> 657
    //   680: new 1117	java/util/LinkedList
    //   683: dup
    //   684: invokespecial 4680	java/util/LinkedList:<init>	()V
    //   687: astore 8
    //   689: aload 7
    //   691: arraylength
    //   692: istore_3
    //   693: iconst_0
    //   694: istore_2
    //   695: iload_2
    //   696: iload_3
    //   697: if_icmpge +53 -> 750
    //   700: aload 7
    //   702: iload_2
    //   703: aaload
    //   704: astore 11
    //   706: aload 11
    //   708: invokestatic 921	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   711: ifne +32 -> 743
    //   714: aload 11
    //   716: ldc_w 4682
    //   719: invokevirtual 4685	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   722: ifeq +21 -> 743
    //   725: aload 8
    //   727: aload 11
    //   729: ldc_w 4682
    //   732: invokevirtual 4676	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   735: iconst_0
    //   736: aaload
    //   737: invokeinterface 4686 2 0
    //   742: pop
    //   743: iload_2
    //   744: iconst_1
    //   745: iadd
    //   746: istore_2
    //   747: goto -52 -> 695
    //   750: aload 8
    //   752: astore 7
    //   754: aload 8
    //   756: invokeinterface 4687 1 0
    //   761: ifeq -452 -> 309
    //   764: aconst_null
    //   765: astore 7
    //   767: goto -458 -> 309
    //   770: invokestatic 2996	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   773: invokestatic 4690	com/tencent/xweb/ao:oQ	(Landroid/content/Context;)V
    //   776: invokestatic 4693	com/tencent/xweb/ao:kgo	()V
    //   779: ldc_w 4619
    //   782: ldc_w 4695
    //   785: invokestatic 771	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   788: getstatic 4617	com/tencent/mm/plugin/webview/modeltools/c:WNp	Ljava/util/ArrayList;
    //   791: invokevirtual 4696	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   794: astore 7
    //   796: aload 7
    //   798: invokeinterface 1126 1 0
    //   803: ifeq +22 -> 825
    //   806: aload 7
    //   808: invokeinterface 1130 1 0
    //   813: checkcast 872	java/lang/String
    //   816: invokestatic 4699	com/tencent/mm/plugin/webview/modeltools/c:bkL	(Ljava/lang/String;)Ljava/lang/String;
    //   819: invokestatic 4702	com/tencent/xweb/ao:deleteOrigin	(Ljava/lang/String;)V
    //   822: goto -26 -> 796
    //   825: getstatic 4617	com/tencent/mm/plugin/webview/modeltools/c:WNp	Ljava/util/ArrayList;
    //   828: invokevirtual 4705	java/util/ArrayList:clear	()V
    //   831: aload_0
    //   832: invokevirtual 678	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:fqa	()Ljava/lang/String;
    //   835: astore 7
    //   837: aload 7
    //   839: ifnull +1337 -> 2176
    //   842: invokestatic 4708	com/tencent/mm/plugin/webview/k/t:iCY	()Ljava/lang/String;
    //   845: astore 8
    //   847: aload 8
    //   849: ifnull +16 -> 865
    //   852: aload 7
    //   854: aload 8
    //   856: invokevirtual 876	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   859: ifeq +6 -> 865
    //   862: invokestatic 4711	com/tencent/mm/plugin/webview/k/t:iCZ	()V
    //   865: aload_0
    //   866: getfield 915	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYq	Lcom/tencent/mm/plugin/webview/ui/tools/floatball/b;
    //   869: ifnull +10 -> 879
    //   872: aload_0
    //   873: getfield 915	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYq	Lcom/tencent/mm/plugin/webview/ui/tools/floatball/b;
    //   876: invokevirtual 4712	com/tencent/mm/plugin/webview/ui/tools/floatball/b:onDestroy	()V
    //   879: aload_0
    //   880: getfield 699	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXg	Lcom/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter;
    //   883: ifnull +74 -> 957
    //   886: aload_0
    //   887: getfield 699	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXg	Lcom/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter;
    //   890: astore 7
    //   892: aload 7
    //   894: invokevirtual 4715	com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter:iCB	()V
    //   897: aload 7
    //   899: getfield 4718	com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter:XrQ	Lcom/tencent/mm/ui/widget/MMEditText;
    //   902: ifnull +24 -> 926
    //   905: aload 7
    //   907: getfield 4722	com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   910: ifnull +16 -> 926
    //   913: aload 7
    //   915: getfield 4722	com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   918: aload 7
    //   920: getfield 4718	com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter:XrQ	Lcom/tencent/mm/ui/widget/MMEditText;
    //   923: invokevirtual 4726	com/tencent/mm/ui/MMActivity:hideVKB	(Landroid/view/View;)V
    //   926: aload 7
    //   928: aconst_null
    //   929: putfield 4718	com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter:XrQ	Lcom/tencent/mm/ui/widget/MMEditText;
    //   932: aload 7
    //   934: getfield 743	com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter:XrM	Lcom/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewSmileyPanel;
    //   937: invokevirtual 4727	com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewSmileyPanel:onDestroy	()V
    //   940: aload 7
    //   942: invokevirtual 4728	com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter:removeAllViews	()V
    //   945: aload 7
    //   947: aconst_null
    //   948: putfield 4722	com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   951: aload 7
    //   953: aconst_null
    //   954: putfield 4732	com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter:XrW	Lcom/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$b;
    //   957: aload_0
    //   958: getfield 944	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYo	Lcom/tencent/mm/plugin/handoff/model/HandOffURL;
    //   961: ifnull +17 -> 978
    //   964: ldc_w 764
    //   967: ldc_w 4734
    //   970: invokestatic 771	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   973: aload_0
    //   974: aconst_null
    //   975: putfield 944	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYo	Lcom/tencent/mm/plugin/handoff/model/HandOffURL;
    //   978: aload_0
    //   979: getfield 2815	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYh	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper;
    //   982: ifnull +50 -> 1032
    //   985: aload_0
    //   986: getfield 2815	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYh	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper;
    //   989: astore 7
    //   991: aload 7
    //   993: getfield 4738	com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper:rAP	Lcom/tencent/mm/plugin/scanner/ScanCodeSheetItemLogic;
    //   996: ifnull +14 -> 1010
    //   999: aload 7
    //   1001: getfield 4738	com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper:rAP	Lcom/tencent/mm/plugin/scanner/ScanCodeSheetItemLogic;
    //   1004: invokestatic 2996	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1007: putfield 4744	com/tencent/mm/plugin/scanner/ScanCodeSheetItemLogic:mContext	Landroid/content/Context;
    //   1010: aload 7
    //   1012: getfield 4748	com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper:rAK	Lcom/tencent/mm/ui/widget/a/f;
    //   1015: ifnull +17 -> 1032
    //   1018: aload 7
    //   1020: getfield 4748	com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper:rAK	Lcom/tencent/mm/ui/widget/a/f;
    //   1023: invokevirtual 4753	com/tencent/mm/ui/widget/a/f:jHK	()V
    //   1026: aload 7
    //   1028: aconst_null
    //   1029: putfield 4748	com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper:rAK	Lcom/tencent/mm/ui/widget/a/f;
    //   1032: aload_0
    //   1033: getfield 3196	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXe	Lcom/tencent/mm/bj/a;
    //   1036: ifnull +10 -> 1046
    //   1039: aload_0
    //   1040: getfield 3196	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXe	Lcom/tencent/mm/bj/a;
    //   1043: invokevirtual 4756	com/tencent/mm/bj/a:disable	()V
    //   1046: aload_0
    //   1047: iconst_1
    //   1048: putfield 553	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYa	Z
    //   1051: getstatic 409	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXZ	I
    //   1054: iconst_1
    //   1055: isub
    //   1056: putstatic 409	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXZ	I
    //   1059: aload_0
    //   1060: getfield 508	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
    //   1063: invokevirtual 879	com/tencent/mm/plugin/webview/core/k:irL	()I
    //   1066: istore_3
    //   1067: getstatic 400	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXA	Ljava/util/ArrayList;
    //   1070: invokevirtual 3068	java/util/ArrayList:size	()I
    //   1073: iconst_1
    //   1074: isub
    //   1075: istore_2
    //   1076: iload_2
    //   1077: iflt +28 -> 1105
    //   1080: getstatic 400	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXA	Ljava/util/ArrayList;
    //   1083: iload_2
    //   1084: invokevirtual 3071	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1087: checkcast 162	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$e
    //   1090: getfield 4757	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$e:id	I
    //   1093: iload_3
    //   1094: if_icmpne +1094 -> 2188
    //   1097: getstatic 400	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXA	Ljava/util/ArrayList;
    //   1100: iload_2
    //   1101: invokevirtual 4759	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   1104: pop
    //   1105: aload_0
    //   1106: getfield 3041	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WGt	Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;
    //   1109: ifnull +15 -> 1124
    //   1112: aload_0
    //   1113: getfield 3038	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bYO	Landroid/view/accessibility/AccessibilityManager;
    //   1116: aload_0
    //   1117: getfield 3041	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WGt	Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;
    //   1120: invokevirtual 4762	android/view/accessibility/AccessibilityManager:removeAccessibilityStateChangeListener	(Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;)Z
    //   1123: pop
    //   1124: aload_0
    //   1125: getfield 508	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
    //   1128: getfield 4766	com/tencent/mm/plugin/webview/core/BaseWebViewController:Wwk	Lcom/tencent/mm/plugin/webview/h/g;
    //   1131: astore 7
    //   1133: invokestatic 547	java/lang/System:currentTimeMillis	()J
    //   1136: lstore 5
    //   1138: aload 7
    //   1140: getfield 4771	com/tencent/mm/plugin/webview/h/g:WQT	Ljava/util/ArrayList;
    //   1143: invokevirtual 3068	java/util/ArrayList:size	()I
    //   1146: ifle +40 -> 1186
    //   1149: aload 7
    //   1151: getfield 4771	com/tencent/mm/plugin/webview/h/g:WQT	Ljava/util/ArrayList;
    //   1154: checkcast 4626	java/util/List
    //   1157: invokestatic 4777	kotlin/a/p:oM	(Ljava/util/List;)Ljava/lang/Object;
    //   1160: checkcast 4779	com/tencent/mm/plugin/webview/h/g$a
    //   1163: lload 5
    //   1165: aload 7
    //   1167: getfield 4771	com/tencent/mm/plugin/webview/h/g:WQT	Ljava/util/ArrayList;
    //   1170: checkcast 4626	java/util/List
    //   1173: invokestatic 4777	kotlin/a/p:oM	(Ljava/util/List;)Ljava/lang/Object;
    //   1176: checkcast 4779	com/tencent/mm/plugin/webview/h/g$a
    //   1179: getfield 4782	com/tencent/mm/plugin/webview/h/g$a:zVt	J
    //   1182: lsub
    //   1183: putfield 4785	com/tencent/mm/plugin/webview/h/g$a:hTS	J
    //   1186: aload_0
    //   1187: getfield 566	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
    //   1190: invokevirtual 4786	com/tencent/mm/plugin/webview/model/ba:report	()V
    //   1193: aload_0
    //   1194: getfield 566	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
    //   1197: astore 7
    //   1199: aload 7
    //   1201: aconst_null
    //   1202: putfield 4790	com/tencent/mm/plugin/webview/model/ba:WML	Lcom/tencent/mm/plugin/webview/model/ay;
    //   1205: aload 7
    //   1207: aconst_null
    //   1208: putfield 4794	com/tencent/mm/plugin/webview/model/ba:WMJ	Lcom/tencent/mm/plugin/webview/model/ba$k;
    //   1211: aload 7
    //   1213: aconst_null
    //   1214: putfield 4798	com/tencent/mm/plugin/webview/model/ba:WMK	Lcom/tencent/mm/plugin/webview/model/ba$l;
    //   1217: aload 7
    //   1219: aconst_null
    //   1220: putfield 4802	com/tencent/mm/plugin/webview/model/ba:WMI	Lcom/tencent/mm/plugin/webview/model/ba$m;
    //   1223: aload 7
    //   1225: aconst_null
    //   1226: putfield 4806	com/tencent/mm/plugin/webview/model/ba:WMN	Lcom/tencent/mm/plugin/webview/model/ba$g;
    //   1229: aload 7
    //   1231: aconst_null
    //   1232: putfield 4810	com/tencent/mm/plugin/webview/model/ba:WMO	Lcom/tencent/mm/plugin/webview/model/ba$b;
    //   1235: aload 7
    //   1237: aconst_null
    //   1238: putfield 4814	com/tencent/mm/plugin/webview/model/ba:WMP	Lcom/tencent/mm/plugin/webview/model/ba$h;
    //   1241: aload 7
    //   1243: aconst_null
    //   1244: putfield 4818	com/tencent/mm/plugin/webview/model/ba:WMQ	Lcom/tencent/mm/plugin/webview/model/ba$d;
    //   1247: aload 7
    //   1249: getfield 4822	com/tencent/mm/plugin/webview/model/ba:WMV	Lcom/tencent/mm/plugin/webview/model/ba$a;
    //   1252: ifnull +18 -> 1270
    //   1255: aload 7
    //   1257: getfield 4822	com/tencent/mm/plugin/webview/model/ba:WMV	Lcom/tencent/mm/plugin/webview/model/ba$a;
    //   1260: aconst_null
    //   1261: putfield 4827	com/tencent/mm/plugin/webview/model/ba$a:hPH	Landroid/os/Bundle;
    //   1264: aload 7
    //   1266: aconst_null
    //   1267: putfield 4822	com/tencent/mm/plugin/webview/model/ba:WMV	Lcom/tencent/mm/plugin/webview/model/ba$a;
    //   1270: aload_0
    //   1271: ldc_w 4828
    //   1274: invokespecial 3080	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bjV	(Ljava/lang/String;)V
    //   1277: aload_0
    //   1278: getfield 515	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXK	Ljava/util/HashMap;
    //   1281: ifnull +10 -> 1291
    //   1284: aload_0
    //   1285: getfield 515	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXK	Ljava/util/HashMap;
    //   1288: invokevirtual 4829	java/util/HashMap:clear	()V
    //   1291: aload_0
    //   1292: invokespecial 2406	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:iyh	()Lcom/tencent/mm/plugin/webview/model/b;
    //   1295: pop
    //   1296: aload_0
    //   1297: getfield 523	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXP	Lcom/tencent/mm/ui/widget/a/e;
    //   1300: invokestatic 4831	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:d	(Landroid/app/Dialog;)V
    //   1303: aload_0
    //   1304: getfield 4273	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXD	Lcom/tencent/xweb/z;
    //   1307: ifnull +26 -> 1333
    //   1310: aload_0
    //   1311: getfield 4273	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXD	Lcom/tencent/xweb/z;
    //   1314: instanceof 131
    //   1317: ifeq +16 -> 1333
    //   1320: aload_0
    //   1321: getfield 4273	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXD	Lcom/tencent/xweb/z;
    //   1324: checkcast 131	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$b
    //   1327: getfield 4834	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$b:qkG	Lcom/tencent/mm/ui/widget/a/e;
    //   1330: invokestatic 4831	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:d	(Landroid/app/Dialog;)V
    //   1333: aload_0
    //   1334: getfield 699	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXg	Lcom/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter;
    //   1337: ifnull +11 -> 1348
    //   1340: aload_0
    //   1341: getfield 699	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXg	Lcom/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter;
    //   1344: aconst_null
    //   1345: invokevirtual 3867	com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter:setOnTextSendListener	(Lcom/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$b;)V
    //   1348: aload_0
    //   1349: getfield 668	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WWT	Lcom/tencent/mm/plugin/webview/ui/tools/n;
    //   1352: ifnull +40 -> 1392
    //   1355: aload_0
    //   1356: getfield 668	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WWT	Lcom/tencent/mm/plugin/webview/ui/tools/n;
    //   1359: getfield 4835	com/tencent/mm/plugin/webview/ui/tools/n:WUx	Landroid/view/View;
    //   1362: astore 7
    //   1364: aload 7
    //   1366: ifnull +26 -> 1392
    //   1369: aload 7
    //   1371: invokevirtual 4839	android/view/View:getAnimation	()Landroid/view/animation/Animation;
    //   1374: astore 8
    //   1376: aload 8
    //   1378: ifnull +9 -> 1387
    //   1381: aload 8
    //   1383: aconst_null
    //   1384: invokevirtual 4845	android/view/animation/Animation:setAnimationListener	(Landroid/view/animation/Animation$AnimationListener;)V
    //   1387: aload 7
    //   1389: invokevirtual 4848	android/view/View:clearAnimation	()V
    //   1392: aload_0
    //   1393: getfield 3948	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:RnL	Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView;
    //   1396: ifnull +10 -> 1406
    //   1399: aload_0
    //   1400: getfield 3948	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:RnL	Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView;
    //   1403: invokevirtual 4851	com/tencent/mm/plugin/scanner/MultiCodeMaskView:gPk	()V
    //   1406: aload_0
    //   1407: getfield 517	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXL	Ljava/util/HashMap;
    //   1410: ifnull +10 -> 1420
    //   1413: aload_0
    //   1414: getfield 517	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXL	Ljava/util/HashMap;
    //   1417: invokevirtual 4829	java/util/HashMap:clear	()V
    //   1420: aload_0
    //   1421: getfield 583	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYt	Lcom/tencent/mm/sdk/event/IListener;
    //   1424: invokevirtual 4854	com/tencent/mm/sdk/event/IListener:dead	()V
    //   1427: aload_0
    //   1428: getfield 502	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXH	Lcom/tencent/mm/sdk/event/IListener;
    //   1431: invokevirtual 4854	com/tencent/mm/sdk/event/IListener:dead	()V
    //   1434: aload_0
    //   1435: getfield 3204	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYj	Lcom/tencent/mm/plugin/webview/ui/tools/u;
    //   1438: ifnull +57 -> 1495
    //   1441: aload_0
    //   1442: getfield 3204	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYj	Lcom/tencent/mm/plugin/webview/ui/tools/u;
    //   1445: astore 7
    //   1447: ldc_w 3206
    //   1450: ldc_w 4855
    //   1453: invokestatic 771	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1456: aload 7
    //   1458: invokevirtual 3214	com/tencent/mm/plugin/webview/ui/tools/u:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   1461: astore 8
    //   1463: aload 8
    //   1465: ifnull +13 -> 1478
    //   1468: aload 8
    //   1470: aload 7
    //   1472: getfield 3218	com/tencent/mm/plugin/webview/ui/tools/u:WZI	Lcom/tencent/mm/plugin/webview/ui/tools/video/c;
    //   1475: invokevirtual 4856	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Lcom/tencent/mm/plugin/webview/ui/tools/video/c;)V
    //   1478: aload 7
    //   1480: getfield 4859	com/tencent/mm/plugin/webview/ui/tools/u:WZH	Lcom/tencent/mm/bj/a;
    //   1483: astore 7
    //   1485: aload 7
    //   1487: ifnull +8 -> 1495
    //   1490: aload 7
    //   1492: invokevirtual 4756	com/tencent/mm/bj/a:disable	()V
    //   1495: getstatic 3012	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   1498: new 114	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$5
    //   1501: dup
    //   1502: aload_0
    //   1503: invokespecial 4860	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$5:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)V
    //   1506: invokeinterface 4862 2 0
    //   1511: pop
    //   1512: ldc_w 764
    //   1515: ldc_w 4864
    //   1518: iconst_1
    //   1519: anewarray 1151	java/lang/Object
    //   1522: dup
    //   1523: iconst_0
    //   1524: aload_0
    //   1525: getfield 458	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXp	Z
    //   1528: invokestatic 1293	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1531: aastore
    //   1532: invokestatic 4239	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1535: aload_0
    //   1536: getfield 458	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXp	Z
    //   1539: ifeq +63 -> 1602
    //   1542: aload_0
    //   1543: invokevirtual 1278	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1546: ldc_w 2886
    //   1549: invokevirtual 1507	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1552: astore 7
    //   1554: aload 7
    //   1556: ldc_w 4866
    //   1559: invokevirtual 1516	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1562: invokestatic 921	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1565: ifne +630 -> 2195
    //   1568: aload_0
    //   1569: getfield 506	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sLC	Lcom/tencent/mm/plugin/webview/stub/e;
    //   1572: ifnull +30 -> 1602
    //   1575: aload 7
    //   1577: ldc_w 4868
    //   1580: aload_0
    //   1581: invokevirtual 4871	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getActivityBrowseTimeMs	()J
    //   1584: invokevirtual 4874	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1587: aload_0
    //   1588: getfield 506	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sLC	Lcom/tencent/mm/plugin/webview/stub/e;
    //   1591: sipush 250
    //   1594: aload 7
    //   1596: invokeinterface 1675 3 0
    //   1601: pop
    //   1602: aload_0
    //   1603: getfield 506	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sLC	Lcom/tencent/mm/plugin/webview/stub/e;
    //   1606: ifnull +39 -> 1645
    //   1609: new 1513	android/os/Bundle
    //   1612: dup
    //   1613: invokespecial 1601	android/os/Bundle:<init>	()V
    //   1616: astore 7
    //   1618: aload 7
    //   1620: ldc_w 4868
    //   1623: aload_0
    //   1624: invokevirtual 4871	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getActivityBrowseTimeMs	()J
    //   1627: invokevirtual 4874	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1630: aload_0
    //   1631: getfield 506	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sLC	Lcom/tencent/mm/plugin/webview/stub/e;
    //   1634: sipush 251
    //   1637: aload 7
    //   1639: invokeinterface 1675 3 0
    //   1644: pop
    //   1645: aload_0
    //   1646: getfield 506	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sLC	Lcom/tencent/mm/plugin/webview/stub/e;
    //   1649: ifnull +94 -> 1743
    //   1652: aload_0
    //   1653: getfield 506	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sLC	Lcom/tencent/mm/plugin/webview/stub/e;
    //   1656: bipush 19
    //   1658: aconst_null
    //   1659: invokeinterface 1675 3 0
    //   1664: astore 7
    //   1666: aload 7
    //   1668: ifnull +75 -> 1743
    //   1671: aload 7
    //   1673: ldc_w 4876
    //   1676: invokevirtual 2231	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   1679: istore 4
    //   1681: ldc_w 764
    //   1684: ldc_w 4878
    //   1687: iconst_2
    //   1688: anewarray 1151	java/lang/Object
    //   1691: dup
    //   1692: iconst_0
    //   1693: iload 4
    //   1695: invokestatic 1293	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1698: aastore
    //   1699: dup
    //   1700: iconst_1
    //   1701: getstatic 409	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXZ	I
    //   1704: invokestatic 1255	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1707: aastore
    //   1708: invokestatic 1154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1711: iload 4
    //   1713: ifeq +30 -> 1743
    //   1716: getstatic 409	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXZ	I
    //   1719: ifgt +24 -> 1743
    //   1722: invokestatic 4884	com/tencent/qqvideo/proxy/api/FactoryProxyManager:getPlayManager	()Lcom/tencent/qqvideo/proxy/api/IPlayManager;
    //   1725: invokeinterface 4889 1 0
    //   1730: aload_0
    //   1731: getfield 506	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sLC	Lcom/tencent/mm/plugin/webview/stub/e;
    //   1734: bipush 75
    //   1736: aconst_null
    //   1737: invokeinterface 1675 3 0
    //   1742: pop
    //   1743: aload_0
    //   1744: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1747: ifnull +77 -> 1824
    //   1750: aload_0
    //   1751: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1754: aconst_null
    //   1755: putfield 2940	com/tencent/mm/ui/widget/MMWebView:afUt	Lcom/tencent/mm/ui/widget/MMWebView$f;
    //   1758: aload_0
    //   1759: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1762: aconst_null
    //   1763: invokevirtual 3785	com/tencent/mm/ui/widget/MMWebView:setCompetitorView	(Landroid/view/ViewGroup;)V
    //   1766: aload_0
    //   1767: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1770: aconst_null
    //   1771: invokevirtual 3917	com/tencent/mm/ui/widget/MMWebView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1774: aload_0
    //   1775: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1778: aconst_null
    //   1779: invokevirtual 3846	com/tencent/mm/ui/widget/MMWebView:setWebViewCallbackClient	(Lcom/tencent/xweb/af;)V
    //   1782: aload_0
    //   1783: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1786: invokestatic 2996	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1789: invokevirtual 3467	com/tencent/mm/ui/widget/MMWebView:bm	(Landroid/content/Context;)V
    //   1792: aload_0
    //   1793: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1796: aconst_null
    //   1797: invokevirtual 3909	com/tencent/mm/ui/widget/MMWebView:setDownloadListener	(Landroid/webkit/DownloadListener;)V
    //   1800: aload_0
    //   1801: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1804: aconst_null
    //   1805: invokevirtual 3890	com/tencent/mm/ui/widget/MMWebView:setFindListener	(Landroid/webkit/WebView$FindListener;)V
    //   1808: aload_0
    //   1809: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1812: aconst_null
    //   1813: invokevirtual 3904	com/tencent/mm/ui/widget/MMWebView:setWebChromeClient	(Lcom/tencent/xweb/z;)V
    //   1816: aload_0
    //   1817: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1820: aconst_null
    //   1821: invokevirtual 4521	com/tencent/mm/ui/widget/MMWebView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1824: aload_0
    //   1825: getfield 448	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXf	Lcom/tencent/mm/plugin/webview/j/b;
    //   1828: invokevirtual 4114	com/tencent/mm/plugin/webview/j/b:iwP	()V
    //   1831: iload_1
    //   1832: ifne +453 -> 2285
    //   1835: aload_0
    //   1836: getfield 508	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
    //   1839: invokevirtual 4892	com/tencent/mm/plugin/webview/core/k:isC	()V
    //   1842: aload_0
    //   1843: getfield 482	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sLD	Lcom/tencent/mm/plugin/webview/e/g;
    //   1846: ifnull +47 -> 1893
    //   1849: aload_0
    //   1850: getfield 482	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sLD	Lcom/tencent/mm/plugin/webview/e/g;
    //   1853: astore 7
    //   1855: ldc_w 4894
    //   1858: ldc_w 4895
    //   1861: invokestatic 771	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1864: aload 7
    //   1866: getfield 4898	com/tencent/mm/plugin/webview/e/g:WPq	Ljava/util/Map;
    //   1869: ifnull +19 -> 1888
    //   1872: aload 7
    //   1874: getfield 4898	com/tencent/mm/plugin/webview/e/g:WPq	Ljava/util/Map;
    //   1877: invokeinterface 4899 1 0
    //   1882: aload 7
    //   1884: aconst_null
    //   1885: putfield 4898	com/tencent/mm/plugin/webview/e/g:WPq	Ljava/util/Map;
    //   1888: aload_0
    //   1889: aconst_null
    //   1890: putfield 482	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sLD	Lcom/tencent/mm/plugin/webview/e/g;
    //   1893: aload_0
    //   1894: aconst_null
    //   1895: putfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1898: aload_0
    //   1899: getfield 508	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
    //   1902: astore 7
    //   1904: aload 7
    //   1906: getfield 2993	com/tencent/mm/plugin/webview/core/k:Wyj	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/h;
    //   1909: astore 8
    //   1911: aload 8
    //   1913: ifnull +23 -> 1936
    //   1916: invokestatic 2996	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1919: astore 9
    //   1921: aload 9
    //   1923: ldc_w 4901
    //   1926: invokestatic 4903	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1929: aload 8
    //   1931: aload 9
    //   1933: invokevirtual 2999	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:bm	(Landroid/content/Context;)V
    //   1936: aload 7
    //   1938: invokevirtual 4907	com/tencent/mm/plugin/webview/core/k:isv	()Lcom/tencent/mm/plugin/webview/ui/tools/d;
    //   1941: invokestatic 2996	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1944: putfield 4911	com/tencent/mm/plugin/webview/ui/tools/d:context	Landroid/content/Context;
    //   1947: aload 7
    //   1949: getfield 4915	com/tencent/mm/plugin/webview/core/k:WyA	Lcom/tencent/mm/plugin/webview/model/ag$c;
    //   1952: invokeinterface 4920 1 0
    //   1957: aload 7
    //   1959: getfield 4923	com/tencent/mm/plugin/webview/core/k:Wyw	Z
    //   1962: ifne +20 -> 1982
    //   1965: aload 7
    //   1967: invokevirtual 4926	com/tencent/mm/plugin/webview/core/k:iss	()Ljava/lang/String;
    //   1970: ldc_w 4928
    //   1973: invokestatic 911	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1976: ldc2_w 4929
    //   1979: invokestatic 666	com/tencent/mm/plugin/webview/model/ba:xM	(J)V
    //   1982: invokestatic 4933	com/tencent/mm/plugin/webview/model/ah:destroy	()V
    //   1985: aload_0
    //   1986: getfield 508	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
    //   1989: invokevirtual 4937	com/tencent/mm/plugin/webview/core/k:isw	()Lcom/tencent/mm/plugin/webview/modeltools/o;
    //   1992: invokevirtual 4942	com/tencent/mm/plugin/webview/modeltools/o:iwk	()V
    //   1995: aload_0
    //   1996: getfield 508	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
    //   1999: aconst_null
    //   2000: putfield 3003	com/tencent/mm/plugin/webview/core/k:Wym	Lcom/tencent/mm/plugin/webview/j/a;
    //   2003: aload_0
    //   2004: getfield 603	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYD	Lcom/tencent/mm/plugin/webview/ui/tools/p;
    //   2007: invokevirtual 4165	com/tencent/mm/plugin/webview/ui/tools/p:release	()V
    //   2010: aload_0
    //   2011: invokevirtual 3172	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getContentView	()Landroid/view/View;
    //   2014: instanceof 1389
    //   2017: ifeq +13 -> 2030
    //   2020: aload_0
    //   2021: invokevirtual 3172	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getContentView	()Landroid/view/View;
    //   2024: checkcast 1389	android/view/ViewGroup
    //   2027: invokevirtual 4943	android/view/ViewGroup:removeAllViews	()V
    //   2030: aload_0
    //   2031: getfield 2488	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYl	Lcom/tencent/mm/plugin/webview/q;
    //   2034: astore 7
    //   2036: aload 7
    //   2038: getfield 4946	com/tencent/mm/plugin/webview/q:tipDialog	Lcom/tencent/mm/ui/base/w;
    //   2041: ifnull +28 -> 2069
    //   2044: aload 7
    //   2046: getfield 4946	com/tencent/mm/plugin/webview/q:tipDialog	Lcom/tencent/mm/ui/base/w;
    //   2049: invokevirtual 4949	com/tencent/mm/ui/base/w:isShowing	()Z
    //   2052: ifeq +17 -> 2069
    //   2055: aload 7
    //   2057: getfield 4946	com/tencent/mm/plugin/webview/q:tipDialog	Lcom/tencent/mm/ui/base/w;
    //   2060: invokevirtual 4950	com/tencent/mm/ui/base/w:dismiss	()V
    //   2063: aload 7
    //   2065: aconst_null
    //   2066: putfield 4946	com/tencent/mm/plugin/webview/q:tipDialog	Lcom/tencent/mm/ui/base/w;
    //   2069: aload 7
    //   2071: getfield 2670	com/tencent/mm/plugin/webview/q:WvX	Lcom/tencent/mm/sdk/event/IListener;
    //   2074: invokevirtual 4854	com/tencent/mm/sdk/event/IListener:dead	()V
    //   2077: aload_0
    //   2078: getfield 1103	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wyi	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;
    //   2081: astore 7
    //   2083: aload 7
    //   2085: getfield 4953	com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper:Ixi	Lcom/tencent/mm/sdk/event/IListener;
    //   2088: ifnull +17 -> 2105
    //   2091: aload 7
    //   2093: getfield 4953	com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper:Ixi	Lcom/tencent/mm/sdk/event/IListener;
    //   2096: invokevirtual 4854	com/tencent/mm/sdk/event/IListener:dead	()V
    //   2099: aload 7
    //   2101: aconst_null
    //   2102: putfield 4953	com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper:Ixi	Lcom/tencent/mm/sdk/event/IListener;
    //   2105: aload 7
    //   2107: aconst_null
    //   2108: putfield 2950	com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper:WUm	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2111: aload 7
    //   2113: getfield 2954	com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper:WZl	Lcom/tencent/mm/plugin/webview/ui/tools/l;
    //   2116: aconst_null
    //   2117: putfield 3380	com/tencent/mm/plugin/webview/ui/tools/l:WUm	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   2120: aload_0
    //   2121: getfield 508	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
    //   2124: aload_0
    //   2125: getfield 637	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYQ	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$c;
    //   2128: invokevirtual 4955	com/tencent/mm/plugin/webview/core/k:b	(Lcom/tencent/mm/plugin/webview/core/m;)V
    //   2131: aload_0
    //   2132: getfield 508	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
    //   2135: aload_0
    //   2136: getfield 637	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYQ	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$c;
    //   2139: getfield 4959	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$c:WZg	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$c$a;
    //   2142: invokevirtual 4961	com/tencent/mm/plugin/webview/core/k:b	(Lcom/tencent/mm/plugin/webview/core/h;)V
    //   2145: aload_0
    //   2146: getfield 573	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYk	Lcom/tencent/qqvideo/proxy/api/IUtils;
    //   2149: ifnull +17 -> 2166
    //   2152: aload_0
    //   2153: aconst_null
    //   2154: putfield 573	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYk	Lcom/tencent/qqvideo/proxy/api/IUtils;
    //   2157: invokestatic 4884	com/tencent/qqvideo/proxy/api/FactoryProxyManager:getPlayManager	()Lcom/tencent/qqvideo/proxy/api/IPlayManager;
    //   2160: aconst_null
    //   2161: invokeinterface 4965 2 0
    //   2166: invokestatic 4968	java/lang/System:gc	()V
    //   2169: ldc_w 4596
    //   2172: invokestatic 428	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2175: return
    //   2176: ldc_w 764
    //   2179: ldc_w 4970
    //   2182: invokestatic 911	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2185: goto -1320 -> 865
    //   2188: iload_2
    //   2189: iconst_1
    //   2190: isub
    //   2191: istore_2
    //   2192: goto -1116 -> 1076
    //   2195: ldc_w 764
    //   2198: ldc_w 4972
    //   2201: invokestatic 911	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2204: goto -602 -> 1602
    //   2207: astore 7
    //   2209: ldc_w 764
    //   2212: ldc_w 4974
    //   2215: iconst_1
    //   2216: anewarray 1151	java/lang/Object
    //   2219: dup
    //   2220: iconst_0
    //   2221: aload 7
    //   2223: invokevirtual 4975	java/lang/Exception:toString	()Ljava/lang/String;
    //   2226: aastore
    //   2227: invokestatic 1259	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2230: goto -628 -> 1602
    //   2233: astore 7
    //   2235: ldc_w 764
    //   2238: ldc_w 4974
    //   2241: iconst_1
    //   2242: anewarray 1151	java/lang/Object
    //   2245: dup
    //   2246: iconst_0
    //   2247: aload 7
    //   2249: invokevirtual 4975	java/lang/Exception:toString	()Ljava/lang/String;
    //   2252: aastore
    //   2253: invokestatic 1259	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2256: goto -611 -> 1645
    //   2259: astore 7
    //   2261: ldc_w 764
    //   2264: ldc_w 4977
    //   2267: iconst_1
    //   2268: anewarray 1151	java/lang/Object
    //   2271: dup
    //   2272: iconst_0
    //   2273: aload 7
    //   2275: invokevirtual 901	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2278: aastore
    //   2279: invokestatic 1259	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2282: goto -539 -> 1743
    //   2285: aload_0
    //   2286: getfield 491	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wyj	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/h;
    //   2289: invokevirtual 4980	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:iBR	()V
    //   2292: goto -394 -> 1898
    //   2295: astore 7
    //   2297: ldc_w 764
    //   2300: ldc_w 4982
    //   2303: iconst_1
    //   2304: anewarray 1151	java/lang/Object
    //   2307: dup
    //   2308: iconst_0
    //   2309: aload 7
    //   2311: aastore
    //   2312: invokestatic 4227	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2315: goto -285 -> 2030
    //   2318: iconst_0
    //   2319: istore_1
    //   2320: goto -2134 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2323	0	this	WebViewUI
    //   185	2135	1	i	int
    //   202	1990	2	j	int
    //   654	441	3	k	int
    //   599	1113	4	bool	boolean
    //   1136	28	5	l	long
    //   120	1992	7	localObject1	Object
    //   2207	15	7	localException1	Exception
    //   2233	15	7	localException2	Exception
    //   2259	15	7	localException3	Exception
    //   2295	15	7	localObject2	Object
    //   153	1777	8	localObject3	Object
    //   249	1683	9	localObject4	Object
    //   271	39	10	str1	String
    //   704	24	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   1542	1602	2207	java/lang/Exception
    //   2195	2204	2207	java/lang/Exception
    //   1602	1645	2233	java/lang/Exception
    //   1645	1666	2259	java/lang/Exception
    //   1671	1711	2259	java/lang/Exception
    //   1716	1743	2259	java/lang/Exception
    //   2003	2030	2295	finally
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(80292);
    if (this.sMP != null) {
      this.sMP.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(80077);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$31", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$31", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(80077);
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
      if ((this.sMP != null) && (this.sMP.hasEnteredFullscreen()))
      {
        this.sMP.leaveFullscreen();
        AppMethodBeat.o(80274);
        return true;
      }
      if (this.Wyj.IY(false))
      {
        AppMethodBeat.o(80274);
        return true;
      }
    }
    if ((paramInt == 4) && (this.dyK != null) && (this.WXC != null) && (this.WXD != null)) {
      try
      {
        this.WXD.onHideCustomView();
        ba.e.dh(fqa(), 7);
        IO(false);
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
      if ((this.WXg != null) && (this.WXg.isShown()))
      {
        this.WXg.hide();
        iyU();
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(80274);
        return true;
      }
    }
    if (paramInt == 4)
    {
      if ((this.sMP != null) && (this.sMP.canGoBack()) && (this.WXm))
      {
        iyF();
        ba.e.dh(fqa(), 7);
        IO(false);
        AppMethodBeat.o(80274);
        return true;
      }
      r.WWq.close();
      ba.e.dh(fqa(), 8);
      IO(true);
    }
    if (getIntent().getBooleanExtra("hide_close_btn", false))
    {
      Log.w("MicroMsg.WebViewUI", "Close and return are not allowed");
      AppMethodBeat.o(80274);
      return true;
    }
    if ((paramInt == 4) && (izb()) && (iue()))
    {
      AppMethodBeat.o(80274);
      return true;
    }
    if ((paramInt == 4) && (this.WYr != null))
    {
      if (iyE().booleanValue())
      {
        AppMethodBeat.o(80274);
        return true;
      }
      if (this.WYr.zX(2))
      {
        AppMethodBeat.o(80274);
        return true;
      }
    }
    if ((paramInt == 4) && (this.WYu != null) && (this.WYu.cvt()))
    {
      this.WYu.hide();
      AppMethodBeat.o(80274);
      return true;
    }
    if (paramInt == 4)
    {
      if (iyE().booleanValue())
      {
        AppMethodBeat.o(80274);
        return true;
      }
      izd();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(80274);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(80273);
    if ((paramInt == 82) && (!this.WYC))
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
    if (this.WYq != null) {
      this.WYq.bhW();
    }
    if (this.WYr != null) {
      this.WYr.bhW();
    }
    com.tencent.mm.modelstat.d.d(4, "WebViewUI_" + avS(Util.nullAsNil(this.WXR)), this.Wzl.irL());
    com.tencent.mm.modelstat.d.n("WebViewUI_" + avS(Util.nullAsNil(this.WXR)), this.Bti, Util.nowSecond());
    Object localObject = this.Wye.ivG();
    if (((ay)localObject).qvl != -1L) {
      ((ay)localObject).hTS += Util.ticksToNow(((ay)localObject).qvl) / 1000L;
    }
    localObject = this.Wye.ivH();
    if (((ak)localObject).qvl != -1L) {
      ((ak)localObject).hTS += Util.ticksToNow(((ak)localObject).qvl);
    }
    localObject = r.WWq;
    Log.v("MicroMsg.WebViewReportUtil", "onPause traceid %s", new Object[] { ((r)localObject).traceid });
    if (((r)localObject).ooe) {
      Log.i("MicroMsg.WebViewReportUtil", "isFinish is true");
    }
    try
    {
      if (this.sLC != null)
      {
        localObject = this.sLC.m(19, null);
        if (localObject != null)
        {
          boolean bool = ((Bundle)localObject).getBoolean("webview_video_proxy_init");
          Log.i("MicroMsg.WebViewUI", "onPause, has init = %b", new Object[] { Boolean.valueOf(bool) });
          if (bool) {
            FactoryProxyManager.getPlayManager().appToBack();
          }
        }
      }
      iyU();
      ScreenShotUtil.setScreenShotCallback(MMApplicationContext.getContext(), null);
      bjV("onPause");
      if (this.WXD != null) {
        Log.i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.WXD.onHideCustomView();
          this.Wyj.onPause();
          this.Wyi.izs();
          if (this.sMP != null) {
            this.sMP.onPause();
          }
          AppMethodBeat.o(80234);
          return;
          if (!Util.isNullOrNil(((r)localObject).traceid)) {
            ((r)localObject).rG(6);
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
    com.tencent.luggage.l.e.bt(this).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    paramArrayOfString = this.sLM;
    if (paramArrayOfString.WNu == null)
    {
      paramArrayOfString.ivR();
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
          break label180;
        }
        paramArrayOfInt = (Intent)paramArrayOfString.WNu.first;
        paramInt = ((Integer)paramArrayOfString.WNu.second).intValue();
        paramArrayOfString.WNu = null;
        com.tencent.mm.hellhoundlib.a.a.a(this, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramArrayOfInt).aYi(), "com/tencent/mm/plugin/webview/modeltools/FileChooserHelper", "onRequestPermissionsResult", "(Landroid/app/Activity;I[Ljava/lang/String;[I)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      }
      for (;;)
      {
        paramInt = 1;
        break;
        label180:
        paramArrayOfString.WNu = null;
        paramArrayOfString.c(this, 0, null);
      }
    }
    AppMethodBeat.o(80242);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80233);
    super.onResume();
    if (this.WYq != null) {
      this.WYq.coi();
    }
    if (this.WYr != null) {
      this.WYr.coi();
    }
    if (fqa() != null) {
      t.bna(fqa());
    }
    for (;;)
    {
      this.Wye.ivG().qvl = Util.currentTicks();
      this.Wye.ivH().qvl = Util.currentTicks();
      Object localObject1 = r.WWq;
      Log.v("MicroMsg.WebViewReportUtil", "onResume traceid %s", new Object[] { ((r)localObject1).traceid });
      if (!Util.isNullOrNil(((r)localObject1).traceid)) {
        ((r)localObject1).rG(7);
      }
      int i;
      if (!this.WYy)
      {
        int j = this.Wzl.irL();
        i = WXA.size() - 1;
        if (i >= 0)
        {
          if (((e)WXA.get(i)).id == j) {
            WXA.remove(i);
          }
        }
        else {
          WXA.add(new e(this));
        }
      }
      else
      {
        this.WYy = false;
        if (this.WXB)
        {
          IB(true);
          this.WXB = false;
        }
        iyI();
        updateOrientation();
        if ((getIntent().getBooleanExtra("disable_swipe_back", false)) && (getSwipeBackLayout() != null)) {
          getSwipeBackLayout().setEnableGesture(false);
        }
      }
      try
      {
        ScreenShotUtil.setScreenShotCallback(MMApplicationContext.getContext(), this);
        bjV("onResume");
        try
        {
          if (this.sLC != null)
          {
            localObject1 = this.sLC.m(19, null);
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
            if (WebViewUIStyleHelper.bF((Bundle)localObject2))
            {
              localObject2 = ((Bundle)localObject2).getString("key_brand_user_name");
              ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbE();
              localException2.aiO((String)localObject2);
            }
          }
        }
        this.Bti = Util.nowSecond();
        com.tencent.mm.plugin.webview.a.a.au(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(296223);
            com.tencent.mm.modelstat.d.d(3, "WebViewUI_" + WebViewUI.this.avS(Util.nullAsNil(WebViewUI.this.WXR)), WebViewUI.this.Wzl.irL());
            AppMethodBeat.o(296223);
          }
        });
        if (this.WYe) {
          finish();
        }
        if ((this.WWX != null) && (this.WWX.WUW))
        {
          hideVKB();
          this.WWX.onKeyBoardStateChange(-2);
        }
        this.Wyj.onResume();
        localObject1 = this.Wyi;
        if (WebViewUIStyleHelper.fEm())
        {
          localObject2 = (Bundle)WebViewUIStyleHelper.GYh.get(WebViewUIStyleHelper.aiC(((WebViewUIStyleHelper)localObject1).sML));
          if ((localObject2 != null) && (((WebViewUIStyleHelper)localObject1).WUm != null)) {}
        }
        else
        {
          if (this.sMP != null) {
            this.sMP.onResume();
          }
          AppMethodBeat.o(80233);
          return;
          t.bna(dgY());
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
    AppMethodBeat.i(296653);
    if ((this.WlX != null) && (this.sMP != null))
    {
      Object localObject1 = this.WlX;
      this.sMP.getUrl();
      Object localObject2 = getIntent();
      if ((this.sLD.iwp().YxC & 0x100000) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.GeneralControlWrapper", "allowOnScreenShot, ret = ".concat(String.valueOf(bool)));
        if (!((com.tencent.mm.plugin.webview.jsapi.j)localObject1).UcS) {
          break label388;
        }
        Log.i("MicroMsg.JsApiHandler", "onScreenShot hasPermission: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramString = com.tencent.mm.plugin.webview.jsapi.p.a.b("onScreenShot", new HashMap(), ((com.tencent.mm.plugin.webview.jsapi.j)localObject1).WDI, ((com.tencent.mm.plugin.webview.jsapi.j)localObject1).KQY);
          ((com.tencent.mm.plugin.webview.jsapi.j)localObject1).WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
        }
        paramString = ((com.tencent.mm.plugin.webview.jsapi.j)localObject1).bjJ(((com.tencent.mm.plugin.webview.jsapi.j)localObject1).getCurrentUrl());
        if (localObject2 == null) {
          break label388;
        }
        try
        {
          localObject1 = ((com.tencent.mm.plugin.webview.jsapi.j)localObject1).getCurrentUrl();
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
              com.tencent.mm.plugin.report.service.h.OAn.b(19213, new Object[] { Integer.valueOf(i), Integer.valueOf(6), localObject2, paramString, str, localObject3, localObject1 });
            }
          }
          AppMethodBeat.o(296653);
          return;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "alvinluo reportAdOnScreenShot exception", new Object[0]);
        }
      }
    }
    label388:
    AppMethodBeat.o(296653);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(80266);
    super.onStart();
    if ((this.WYo != null) && (iul()))
    {
      Log.i("MicroMsg.WebViewUI", "[Handoff] onStart, call onWebViewCreate " + this.WYo.toString());
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).a(this.WYo);
    }
    Log.i("MicroMsg.WebViewUI", "edw onStart");
    AppMethodBeat.o(80266);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(80267);
    Log.i("MicroMsg.WebViewUI", "edw onStop");
    if ((this.WYo != null) && (iul()))
    {
      Log.i("MicroMsg.WebViewUI", "[Handoff] onStop, call onWebViewDestroy " + this.WYo.toString());
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).b(this.WYo);
    }
    this.WWR.finish();
    IP(true);
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
    this.WYc = true;
    ba.e.dh(fqa(), 2);
    boolean bool = super.onSwipeBackFinish();
    AppMethodBeat.o(80293);
    return bool;
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(80261);
    Object localObject;
    if ((this.Wyi != null) && (!this.Wyi.WZj))
    {
      localObject = this.Wyi;
      if (((WebViewUIStyleHelper)localObject).WUm != null)
      {
        if (Util.isNullOrNil(((WebViewUIStyleHelper)localObject).sML)) {
          ((WebViewUIStyleHelper)localObject).sML = Util.nullAsNil(((WebViewUIStyleHelper)localObject).WUm.fqa());
        }
        ((WebViewUIStyleHelper)localObject).WZm.WvF.setValue(Integer.valueOf(paramInt2));
        ((WebViewUIStyleHelper)localObject).izt();
      }
    }
    long l;
    if (this.WWT != null)
    {
      localObject = this.WWT;
      if (((n)localObject).WUC)
      {
        l = System.currentTimeMillis();
        if (((n)localObject).WUz == 0L)
        {
          ((n)localObject).WUz = l;
          ((n)localObject).WUA = paramInt2;
        }
        if ((Math.abs(l - ((n)localObject).WUz) > 200L) && (Math.abs(paramInt2 - ((n)localObject).WUA) > ((n)localObject).WUB))
        {
          if ((paramInt2 - ((n)localObject).WUA <= 0) || (((n)localObject).WUx.getVisibility() != 0)) {
            break label215;
          }
          ((n)localObject).ixA();
        }
      }
    }
    for (;;)
    {
      ((n)localObject).WUz = l;
      ((n)localObject).WUA = paramInt2;
      AppMethodBeat.o(80261);
      return;
      label215:
      if ((paramInt2 - ((n)localObject).WUA < 0) && (((n)localObject).WUx.getVisibility() != 0)) {
        ((n)localObject).ixz();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(80283);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.WlX != null) {
      this.WlX.bB(paramBoolean, false);
    }
    if ((paramBoolean) && (iyJ())) {
      bd(getWindow().getDecorView(), 5894);
    }
    if ((paramBoolean) && (iyv())) {
      bd(getWindow().getDecorView(), 4866);
    }
    AppMethodBeat.o(80283);
  }
  
  public final void ot(String paramString1, String paramString2)
  {
    AppMethodBeat.i(296695);
    this.WXf.a(this, paramString1, paramString2);
    AppMethodBeat.o(296695);
  }
  
  protected void q(int paramInt, Bundle paramBundle) {}
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(80221);
    super.setActionbarColor(paramInt);
    if ((Build.VERSION.SDK_INT >= 21) && (this.Inv != null))
    {
      this.Inv.setBackgroundColor(getWindow().getStatusBarColor());
      com.tencent.mm.ui.statusbar.d.g(getWindow());
    }
    AppMethodBeat.o(80221);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    AppMethodBeat.i(80363);
    super.setBackBtn(paramOnMenuItemClickListener, paramInt);
    if ((com.tencent.mm.compatible.util.d.rb(21)) && (iyy())) {
      setBackBtnColorFilter(c.c.BW_0);
    }
    if (getIntent().getBooleanExtra("hide_close_btn", false)) {
      setBackBtnVisible(false);
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
    blM(paramCharSequence.toString());
    blN(paramCharSequence.toString());
    AppMethodBeat.o(80238);
  }
  
  public void setMMTitle(String paramString)
  {
    AppMethodBeat.i(80237);
    super.setMMTitle(paramString);
    blM(paramString);
    blN(paramString);
    AppMethodBeat.o(80237);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(296857);
    this.Wzx = paramInt;
    updateOrientation();
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(296857);
  }
  
  public final void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(80258);
    View localView = getContentView();
    if (!bb.aAF(paramInt)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.ui.statusbar.a.h(localView, paramInt, bool);
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
    if (this.WYR == -3)
    {
      this.WYR = -2;
      AppMethodBeat.o(80362);
      return;
    }
    this.WYR = -3;
    AppMethodBeat.o(80362);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(80369);
    if (Util.isEqual(paramIntent.getType(), "application/vnd.android.package-archive"))
    {
      v.f(MMApplicationContext.getContext(), paramIntent.getData());
      AppMethodBeat.o(80369);
      return;
    }
    super.startActivity(paramIntent);
    AppMethodBeat.o(80369);
  }
  
  protected static final class a
  {
    private String WIa;
    private String WIb;
    private String WIc;
    private String WId;
    private String WIe;
    private String WIf;
    private String WZb;
    private String lang;
    
    private a(Bundle paramBundle)
    {
      AppMethodBeat.i(80123);
      this.WZb = paramBundle.getString("close_window_confirm_dialog_switch");
      this.WIa = paramBundle.getString("close_window_confirm_dialog_title_cn");
      this.WIb = paramBundle.getString("close_window_confirm_dialog_title_eng");
      this.WIc = paramBundle.getString("close_window_confirm_dialog_ok_cn");
      this.WId = paramBundle.getString("close_window_confirm_dialog_ok_eng");
      this.WIe = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
      this.WIf = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
      this.lang = paramBundle.getString("application_language");
      AppMethodBeat.o(80123);
    }
    
    public static a bC(Bundle paramBundle)
    {
      AppMethodBeat.i(80124);
      paramBundle = new a(paramBundle);
      AppMethodBeat.o(80124);
      return paramBundle;
    }
    
    public final boolean iuN()
    {
      AppMethodBeat.i(80125);
      if (Util.isNullOrNil(this.WZb))
      {
        AppMethodBeat.o(80125);
        return false;
      }
      boolean bool = this.WZb.equals("true");
      AppMethodBeat.o(80125);
      return bool;
    }
    
    public final String iuP()
    {
      AppMethodBeat.i(80127);
      if ("zh_CN".equals(this.lang))
      {
        str = this.WIc;
        AppMethodBeat.o(80127);
        return str;
      }
      String str = this.WId;
      AppMethodBeat.o(80127);
      return str;
    }
    
    public final String iuQ()
    {
      AppMethodBeat.i(80128);
      if ("zh_CN".equals(this.lang))
      {
        str = this.WIe;
        AppMethodBeat.o(80128);
        return str;
      }
      String str = this.WIf;
      AppMethodBeat.o(80128);
      return str;
    }
    
    public final String izm()
    {
      AppMethodBeat.i(80126);
      if ("zh_CN".equals(this.lang))
      {
        str = this.WIa;
        AppMethodBeat.o(80126);
        return str;
      }
      String str = this.WIb;
      AppMethodBeat.o(80126);
      return str;
    }
  }
  
  public class b
    extends com.tencent.xweb.z
  {
    private com.tencent.mm.plugin.webview.modeltools.j WZc;
    public volatile boolean mtE;
    com.tencent.mm.ui.widget.a.e qkG;
    
    protected b()
    {
      AppMethodBeat.i(80144);
      this.mtE = false;
      this.WZc = new com.tencent.mm.plugin.webview.modeltools.j();
      this.qkG = null;
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
      WebViewUI.this.IQ(true);
      com.tencent.mm.plugin.ball.f.f.d(true, true, false);
      if (WebViewUI.this.itx().WFi)
      {
        MPVideoPlayFullScreenView localMPVideoPlayFullScreenView = WebViewUI.this.iyo();
        Context localContext = localMPVideoPlayFullScreenView.getContext();
        if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).sMP != null)) {
          localMPVideoPlayFullScreenView.XlP = ((WebViewUI)localContext).sMP.setVideoJsCallback((com.tencent.xweb.x)new MPVideoPlayFullScreenView.f(localMPVideoPlayFullScreenView));
        }
        if (localMPVideoPlayFullScreenView.XlP != null) {}
        for (int i = 1; i != 0; i = 0)
        {
          WebViewUI.a(WebViewUI.this, paramCustomViewCallback);
          Log.i("MicroMsg.WebViewUI", "onEnterFullscreen view");
          if (paramView.getParent() == null) {
            WebViewUI.this.iyo().kD(paramView);
          }
          AppMethodBeat.o(80145);
          return true;
        }
      }
      if (WebViewUI.this.itx().WFi) {
        WebViewUI.this.itx().IE(false);
      }
      boolean bool = super.a(paramView, paramCustomViewCallback);
      AppMethodBeat.o(80145);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, z.a parama)
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
          WebViewUI.r(WebViewUI.this).a(WebViewUI.this, WebViewUI.this.sLD, null, paramValueCallback, str2, paramWebView);
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
      Log.i("MicroMsg.WebViewUI", "onJsAlert");
      final PBool localPBool = new PBool();
      localPBool.value = false;
      if ((WebViewUI.this.isFinishing()) || (WebViewUI.this.activityHasDestroyed()))
      {
        Log.d("MicroMsg.WebViewUI", "onJsAlert finish");
        paramJsResult.cancel();
        AppMethodBeat.o(80158);
        return true;
      }
      WebViewUI.s(WebViewUI.this);
      if (WebViewUI.t(WebViewUI.this) > 2) {}
      for (this.qkG = com.tencent.mm.ui.base.k.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(c.i.wv_close_webview), WebViewUI.this.getString(c.i.app_ok), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80140);
              Log.i("MicroMsg.WebViewUI", "onJsAlert, onClose");
              com.tencent.mm.plugin.report.service.h.OAn.b(11683, new Object[] { paramString1, Integer.valueOf(1), Integer.valueOf(WebViewUI.t(WebViewUI.this)) });
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
              AppMethodBeat.i(296636);
              Log.i("MicroMsg.WebViewUI", "onJsAlert, onConfirm");
              localPBool.value = true;
              paramJsResult.confirm();
              AppMethodBeat.o(296636);
            }
          }, c.c.link_color); this.qkG != null; this.qkG = com.tencent.mm.ui.base.k.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(c.i.app_ok), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80142);
              Log.i("MicroMsg.WebViewUI", "onJsAlert, onConfirm");
              localPBool.value = true;
              paramJsResult.confirm();
              AppMethodBeat.o(80142);
            }
          }))
      {
        this.qkG.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(296483);
            Log.i("MicroMsg.WebViewUI", "onJsAlert, onDismiss");
            if (!localPBool.value) {
              paramJsResult.cancel();
            }
            AppMethodBeat.o(296483);
          }
        });
        this.qkG.setCanceledOnTouchOutside(false);
        this.qkG.Nz(false);
        AppMethodBeat.o(80158);
        return true;
      }
      boolean bool = super.a(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(80158);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, com.tencent.xweb.q paramq)
    {
      AppMethodBeat.i(80157);
      boolean bool = super.a(paramWebView, paramString1, paramString2, paramString3, paramq);
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
      WebViewUI.s(WebViewUI.this);
      if (WebViewUI.t(WebViewUI.this) > 2) {}
      for (this.qkG = com.tencent.mm.ui.base.k.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(c.i.wv_close_webview), WebViewUI.this.getString(c.i.app_ok), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80133);
              com.tencent.mm.plugin.report.service.h.OAn.b(11683, new Object[] { paramString1, Integer.valueOf(1), Integer.valueOf(WebViewUI.t(WebViewUI.this)) });
              paramJsResult.cancel();
              if (paramAnonymousDialogInterface != null) {
                paramAnonymousDialogInterface.dismiss();
              }
              Log.i("MicroMsg.WebViewUI", "onJsConfirm cancel and finish %d", new Object[] { Integer.valueOf(WebViewUI.t(WebViewUI.this)) });
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
              Log.i("MicroMsg.WebViewUI", "onJsConfirm confirm %d", new Object[] { Integer.valueOf(WebViewUI.t(WebViewUI.this)) });
              AppMethodBeat.o(80136);
            }
          }, c.c.btn_green_color_normal); this.qkG != null; this.qkG = com.tencent.mm.ui.base.k.a(WebViewUI.this.getContext(), false, paramString2, "", WebViewUI.this.getString(c.i.app_ok), WebViewUI.this.getString(c.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80137);
              localPBool.value = true;
              paramJsResult.confirm();
              Log.i("MicroMsg.WebViewUI", "onJsConfirm confirm %d", new Object[] { Integer.valueOf(WebViewUI.t(WebViewUI.this)) });
              AppMethodBeat.o(80137);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80138);
              paramJsResult.cancel();
              Log.i("MicroMsg.WebViewUI", "onJsConfirm cancel %d", new Object[] { Integer.valueOf(WebViewUI.t(WebViewUI.this)) });
              AppMethodBeat.o(80138);
            }
          }))
      {
        this.qkG.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(296642);
            Log.i("MicroMsg.WebViewUI", "onJsConfirm, onDismiss %d, %b", new Object[] { Integer.valueOf(WebViewUI.t(WebViewUI.this)), Boolean.valueOf(localPBool.value) });
            if (!localPBool.value) {
              paramJsResult.cancel();
            }
            AppMethodBeat.o(296642);
          }
        });
        this.qkG.setCancelable(false);
        this.qkG.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(80156);
        return true;
      }
      boolean bool = super.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(80156);
      return bool;
    }
    
    public final boolean cxL()
    {
      AppMethodBeat.i(80146);
      WebViewUI.this.IQ(false);
      com.tencent.mm.plugin.ball.f.f.d(false, true, false);
      boolean bool = super.cxL();
      AppMethodBeat.o(80146);
      return bool;
    }
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80149);
      Log.i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", new Object[] { paramString, WebViewUI.this.Wzl.Www });
      super.d(paramWebView, paramString);
      if ((WebViewUI.this.WWP) && (!WebViewUI.m(WebViewUI.this)))
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
      if (!WebViewUI.this.PhI)
      {
        AppMethodBeat.o(80149);
        return;
      }
      if ((!Util.nullAsNil(WebViewUI.this.Wzl.Www).equals(paramString)) && (!com.tencent.mm.plugin.webview.luggage.c.c.agu(paramString)) && (!paramString.startsWith("about:blank"))) {
        WebViewUI.this.setMMTitle(paramString);
      }
      AppMethodBeat.o(80149);
    }
    
    public final View getVideoLoadingProgressView()
    {
      AppMethodBeat.i(80152);
      if (WebViewUI.q(WebViewUI.this) == null)
      {
        WebViewUI.a(WebViewUI.this, new ProgressBar(WebViewUI.this));
        WebViewUI.q(WebViewUI.this).setIndeterminate(true);
      }
      ProgressBar localProgressBar = WebViewUI.q(WebViewUI.this);
      AppMethodBeat.o(80152);
      return localProgressBar;
    }
    
    public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(296482);
      com.tencent.luggage.sdk.h.f.a(paramConsoleMessage, "MicroMsg.WebViewUI");
      boolean bool = super.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(296482);
      return bool;
    }
    
    public final void onExitFullscreenVideo(Bitmap paramBitmap)
    {
      AppMethodBeat.i(80147);
      MPVideoPlayFullScreenView localMPVideoPlayFullScreenView;
      if ((WebViewUI.this.WlX != null) && (WebViewUI.this.itx().WFi) && (WebViewUI.this.iyo().getVisibility() == 0))
      {
        if (WebViewUI.l(WebViewUI.this) != null) {
          WebViewUI.l(WebViewUI.this).onCustomViewHidden();
        }
        WebViewUI.this.itx().IE(false);
        localMPVideoPlayFullScreenView = WebViewUI.this.iyo();
        if (!localMPVideoPlayFullScreenView.SHh) {
          break label131;
        }
        Log.i(localMPVideoPlayFullScreenView.TAG, "isRunningExitAnimation");
      }
      for (;;)
      {
        if (WebViewUI.this.Wyi != null) {
          WebViewUI.this.Wyi.izw();
        }
        AppMethodBeat.o(80147);
        return;
        label131:
        if (localMPVideoPlayFullScreenView.nQs != null) {
          break;
        }
        Log.i(localMPVideoPlayFullScreenView.TAG, "runExitAnimation mpShareVideoInfo is null, just exit");
        localMPVideoPlayFullScreenView.exit();
      }
      localMPVideoPlayFullScreenView.iBw();
      Object localObject;
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        localObject = new ImageView(localMPVideoPlayFullScreenView.getContext());
        ViewGroup localViewGroup = localMPVideoPlayFullScreenView.XlI;
        if (localViewGroup != null) {
          localViewGroup.addView((View)localObject, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        }
        ((ImageView)localObject).setImageBitmap(paramBitmap);
      }
      Log.i(localMPVideoPlayFullScreenView.TAG, "runExitAnimation");
      localMPVideoPlayFullScreenView.iBz();
      int i = localMPVideoPlayFullScreenView.XlF.getWidth();
      int j = localMPVideoPlayFullScreenView.XlF.getHeight();
      paramBitmap = localMPVideoPlayFullScreenView.wAY;
      if (paramBitmap != null) {
        paramBitmap.oC(i, j);
      }
      paramBitmap = localMPVideoPlayFullScreenView.wAY;
      int k;
      if (paramBitmap != null)
      {
        localObject = localMPVideoPlayFullScreenView.nQs;
        kotlin.g.b.s.checkNotNull(localObject);
        i = ((com.tencent.mm.message.y)localObject).nVm;
        localObject = localMPVideoPlayFullScreenView.nQs;
        kotlin.g.b.s.checkNotNull(localObject);
        k = ((com.tencent.mm.message.y)localObject).nVn;
        localObject = localMPVideoPlayFullScreenView.nQs;
        kotlin.g.b.s.checkNotNull(localObject);
        int m = ((com.tencent.mm.message.y)localObject).nVo;
        localObject = localMPVideoPlayFullScreenView.nQs;
        kotlin.g.b.s.checkNotNull(localObject);
        paramBitmap.af(i, k, m, ((com.tencent.mm.message.y)localObject).nVp);
      }
      if (localMPVideoPlayFullScreenView.Roh == 1.0D) {}
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          paramBitmap = localMPVideoPlayFullScreenView.wAY;
          if (paramBitmap != null) {
            paramBitmap.afIg = (1.0F / localMPVideoPlayFullScreenView.Roh);
          }
          if ((localMPVideoPlayFullScreenView.Roi != 0) || (localMPVideoPlayFullScreenView.Roj != 0))
          {
            i = (int)(localMPVideoPlayFullScreenView.XlF.getWidth() / 2 * (1.0F - localMPVideoPlayFullScreenView.Roh));
            k = localMPVideoPlayFullScreenView.Roi;
            j = (int)(localMPVideoPlayFullScreenView.XlF.getHeight() / 2 + localMPVideoPlayFullScreenView.Roj - j / 2 * localMPVideoPlayFullScreenView.Roh);
            paramBitmap = localMPVideoPlayFullScreenView.wAY;
            if (paramBitmap != null) {
              paramBitmap.oE(i + k, j);
            }
          }
        }
        paramBitmap = localMPVideoPlayFullScreenView.XlF.getLayoutParams();
        localObject = localMPVideoPlayFullScreenView.wAY;
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.ui.tools.f)localObject).a((View)localMPVideoPlayFullScreenView.XlI, localMPVideoPlayFullScreenView.XlF, (f.c)new MPVideoPlayFullScreenView.h(localMPVideoPlayFullScreenView, paramBitmap), null);
        break;
      }
    }
    
    public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(80153);
      this.WZc.a(WebViewUI.this, WebViewUI.this.fqa(), WebViewUI.this.dgY(), WebViewUI.this.Wzl.cxN(), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), paramString, paramCallback);
      AppMethodBeat.o(80153);
    }
    
    public final void onHideCustomView()
    {
      AppMethodBeat.i(80151);
      Log.i("MicroMsg.WebViewUI", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
      WebViewUI.this.getContext().getWindow().clearFlags(128);
      if (WebViewUI.n(WebViewUI.this) == null)
      {
        AppMethodBeat.o(80151);
        return;
      }
      try
      {
        WebViewUI.this.IL(WebViewUI.this.iyV());
        if (!WebViewUI.this.sMP.isXWalkKernel())
        {
          WebViewUI.this.sMP.setVisibility(0);
          WebViewUI.this.setTitleVisibility(0);
        }
        for (;;)
        {
          if (WebViewUI.this.WWZ != null) {
            WebViewUI.this.WWZ.removeView(WebViewUI.n(WebViewUI.this));
          }
          WebViewUI.a(WebViewUI.this, null);
          if (WebViewUI.p(WebViewUI.this) != null) {
            WebViewUI.p(WebViewUI.this).onCustomViewHidden();
          }
          WebViewUI.this.IQ(false);
          AppMethodBeat.o(80151);
          return;
          WebViewUI.this.fullScreenNoTitleBar(false);
          WebViewUI.this.setStatusBarColor(WebViewUI.this.getResources().getColor(c.c.status_bar_color));
          if (WebViewUI.this.WYA != null)
          {
            ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)WebViewUI.this.WYA.getLayoutParams();
            int i = WebViewUI.o(WebViewUI.this);
            if (i != localMarginLayoutParams.topMargin)
            {
              localMarginLayoutParams.topMargin = i;
              WebViewUI.this.WYA.setLayoutParams(localMarginLayoutParams);
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
      AppMethodBeat.i(296479);
      this.WZc.a(paramPermissionRequest, WebViewUI.this, WebViewUI.this.fqa());
      AppMethodBeat.o(296479);
    }
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(80150);
      Log.i("MicroMsg.WebViewUI", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
      try
      {
        WebViewUI.this.getContext().getWindow().addFlags(128);
        if (WebViewUI.n(WebViewUI.this) != null)
        {
          paramCustomViewCallback.onCustomViewHidden();
          AppMethodBeat.o(80150);
          return;
        }
        WebViewUI.this.IL(false);
        WebViewUI.a(WebViewUI.this, paramView);
        WebViewUI.b(WebViewUI.this, paramCustomViewCallback);
        if (!WebViewUI.this.sMP.isXWalkKernel())
        {
          WebViewUI.this.sMP.setVisibility(8);
          WebViewUI.this.WWZ.addView(paramView);
          WebViewUI.this.setTitleVisibility(4);
        }
        for (;;)
        {
          WebViewUI.this.IQ(true);
          AppMethodBeat.o(80150);
          return;
          WebViewUI.this.WWZ.addView(paramView, 0);
          WebViewUI.this.fullScreenNoTitleBar(true);
          WebViewUI.this.setStatusBarColor(0);
          if (WebViewUI.this.WYA != null)
          {
            paramView = (ViewGroup.MarginLayoutParams)WebViewUI.this.WYA.getLayoutParams();
            paramView.topMargin = 0;
            WebViewUI.this.WYA.setLayoutParams(paramView);
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
      WebViewUI.r(WebViewUI.this).a(WebViewUI.this, WebViewUI.this.sLD, paramValueCallback, null, paramString1, paramString2);
      AppMethodBeat.o(80154);
    }
  }
  
  protected final class c
    extends com.tencent.mm.plugin.webview.core.m
  {
    a WZg;
    private b WZh;
    
    public c()
    {
      AppMethodBeat.i(296425);
      this.WZg = new a((byte)0);
      this.WZh = new b((byte)0);
      AppMethodBeat.o(296425);
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2)
    {
      AppMethodBeat.i(296427);
      paramWebView = WebViewUI.this;
      if (paramWebView.getIntent().getBooleanExtra("hide_close_btn", false))
      {
        Log.w("MicroMsg.WebViewUI", "page load error. reallow close and return");
        paramWebView.setBackBtnVisible(true);
        paramWebView.getIntent().putExtra("hide_close_btn", false);
      }
      AppMethodBeat.o(296427);
      return false;
    }
    
    public final com.tencent.mm.plugin.webview.core.l cxU()
    {
      return this.WZh;
    }
    
    public final int getScreenOrientation()
    {
      return WebViewUI.this.Wzx;
    }
    
    public final boolean isM()
    {
      AppMethodBeat.i(296431);
      if ((WebViewUI.this.WYa) || (WebViewUI.u(WebViewUI.this)) || (WebViewUI.this.isFinishing()))
      {
        AppMethodBeat.o(296431);
        return true;
      }
      AppMethodBeat.o(296431);
      return false;
    }
    
    public final com.tencent.mm.plugin.webview.core.h isN()
    {
      return this.WZg;
    }
    
    final class a
      extends com.tencent.mm.plugin.webview.core.h
    {
      private a() {}
      
      public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
      {
        WebViewUI.this.WYi.WVs = false;
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(296090);
        if ((WebViewUI.w(WebViewUI.this) != null) && (NetStatusUtil.isConnected(MMApplicationContext.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8")))
        {
          WebViewUI.w(WebViewUI.this).fz("rawUrl", paramString);
          WebViewUI.w(WebViewUI.this).bjY(paramString);
        }
        if ((WebViewUI.x(WebViewUI.this) != null) && (NetStatusUtil.isConnected(MMApplicationContext.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8"))) {
          WebViewUI.x(WebViewUI.this).setRawUrl(paramString);
        }
        WebViewUI.e(WebViewUI.this, paramString);
        if (!WebViewUI.y(WebViewUI.this))
        {
          WebViewUI.z(WebViewUI.this);
          WebViewUI.this.Wye.ivJ().loadFinished = true;
        }
        Object localObject = WebViewUI.this.sMP.getTitle();
        Log.i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", new Object[] { WebViewUI.this.getMMTitle(), localObject, Boolean.valueOf(WebViewUI.this.WWP), Boolean.valueOf(WebViewUI.this.PhI), WebViewUI.this.Wzl.Www });
        if ((WebViewUI.c.this.controller.sMP.getIsX5Kernel()) && (!Util.isNullOrNil((String)localObject)) && (((String)localObject).length() > 0) && (!((String)localObject).equals(WebViewUI.this.getMMTitle())) && (!((String)localObject).startsWith("http")) && ((WebViewUI.this.Wzl.Www == null) || (!WebViewUI.this.Wzl.Www.equals(localObject))) && (!WebViewUI.this.WWP) && (WebViewUI.this.PhI))
        {
          Log.d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
          WebViewUI.this.setMMTitle((String)localObject);
        }
        WebViewUI.this.WYD.blL(WebViewUI.this.fqa());
        WebViewUI.this.setProgressBarIndeterminateVisibility(false);
        WebViewUI.this.WWR.finish();
        if ((WebViewUI.this.Wyi != null) && (!WebViewUI.this.Wyi.WZj))
        {
          localObject = WebViewUI.this.Wyi;
          Log.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", new Object[] { paramString });
          ((WebViewUIStyleHelper)localObject).sML = paramString;
        }
        if (!Util.isEqual(paramString, WebViewUI.this.WYL))
        {
          Log.i("MicroMsg.WebViewUI", "onPageFinished  checkWeixinReady:".concat(String.valueOf(paramString)));
          WebViewUI.f(WebViewUI.this, paramString);
        }
        for (;;)
        {
          WebViewUI.this.b(paramWebView, paramString);
          AppMethodBeat.o(296090);
          return;
          Log.i("MicroMsg.WebViewUI", "onPageFinished no need checkWeixinReady again:".concat(String.valueOf(paramString)));
        }
      }
      
      public final void b(WebView paramWebView, String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(296099);
        WebViewUI.this.WYD.iya();
        if ((WebViewUI.w(WebViewUI.this) != null) && (NetStatusUtil.isConnected(MMApplicationContext.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8")))
        {
          WebViewUI.w(WebViewUI.this).fz("rawUrl", paramString);
          WebViewUI.w(WebViewUI.this).bjY(paramString);
        }
        if ((WebViewUI.x(WebViewUI.this) != null) && (NetStatusUtil.isConnected(MMApplicationContext.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8"))) {
          WebViewUI.x(WebViewUI.this).setRawUrl(paramString);
        }
        WebViewUI.e(WebViewUI.this, paramString);
        WebViewUI.this.IL(WebViewUI.this.iyV());
        AppMethodBeat.o(296099);
      }
      
      public final void e(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(296107);
        super.e(paramWebView, paramString);
        paramWebView = WebViewUI.this.Wyi;
        Log.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageCommitVisible, url:%s", new Object[] { paramString });
        ((com.tencent.mm.plugin.wxpayreport.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpayreport.a.a.class)).onWebViewPageFinished(paramString, paramWebView.WUm);
        paramWebView.sML = paramString;
        WebViewUI.f(WebViewUI.this, paramString);
        AppMethodBeat.o(296107);
      }
      
      public final void h(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(296082);
        if (!WebViewUI.this.WYI) {
          WebViewUI.this.WYi.ixR();
        }
        WebViewUI.this.WYD.iya();
        WebViewUI.this.WYD.blL(paramString);
        WebViewUI.this.setProgressBarIndeterminateVisibility(false);
        WebViewUI.this.WYi.h(paramString, WebViewUI.this.getIntent());
        WebViewUI.this.IP(false);
        if ((WebViewUI.this.Wyi != null) && (!WebViewUI.this.Wyi.WZj))
        {
          paramWebView = WebViewUI.this.Wyi;
          Log.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageStart, url:%s", new Object[] { paramString });
          paramWebView.sML = paramString;
          paramWebView.izp();
          paramWebView.izw();
        }
        WebViewUI.v(WebViewUI.this);
        WebViewUI.this.WXd = false;
        AppMethodBeat.o(296082);
      }
    }
    
    final class b
      extends com.tencent.mm.plugin.webview.core.l
    {
      private b() {}
      
      public final void Is(boolean paramBoolean)
      {
        AppMethodBeat.i(296148);
        if ((paramBoolean) && (WebViewUI.this.sMP != null))
        {
          WebViewUI.this.sMP.setOnLongClickListener(WebViewUI.A(WebViewUI.this));
          WebViewUI.B(WebViewUI.this);
        }
        AppMethodBeat.o(296148);
      }
      
      public final void a(int paramInt, String paramString, cdf paramcdf)
      {
        AppMethodBeat.i(296131);
        WebViewUI.this.sMq = paramcdf.aanm;
        WebViewUI.b(WebViewUI.this, WebViewUI.this.sLD.iwo().sk(24));
        WebViewUI.this.Wye.ivJ().WNc = true;
        WebViewUI.this.WXx = com.tencent.mm.platformtools.w.a(paramcdf.aanh);
        Log.d("MicroMsg.WebViewUI", "onPermissionUpdate, getA8Key = %s", new Object[] { Util.encodeHexString(WebViewUI.this.WXx) });
        AppMethodBeat.o(296131);
      }
      
      public final void a(String paramString, cdf paramcdf)
      {
        AppMethodBeat.i(296127);
        if (!Util.isNullOrNil(paramcdf.hAP)) {
          WebViewUI.this.setMMTitle(paramcdf.hAP);
        }
        if (paramcdf.aamK == 6) {
          WebViewUI.this.IN(false);
        }
        AppMethodBeat.o(296127);
      }
      
      public final void atp(int paramInt)
      {
        AppMethodBeat.i(296149);
        if (WebViewUI.this.WWW != null)
        {
          FontChooserView localFontChooserView = (FontChooserView)WebViewUI.this.WWW.findViewById(c.f.font_chooser_view);
          if (localFontChooserView != null) {
            localFontChooserView.setSliderIndex(paramInt - 1);
          }
        }
        AppMethodBeat.o(296149);
      }
      
      public final void b(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
      {
        paramInt3 = 1;
        AppMethodBeat.i(296155);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(154L, 12L, 1L, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(154L, com.tencent.mm.plugin.webview.h.a.atT(paramInt1), 1L, false);
        WebViewUI.this.IP(true);
        WebViewUI.this.WYi.WVs = false;
        switch (paramInt1)
        {
        case 1: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        default: 
          AppMethodBeat.o(296155);
          return;
        }
        r.WWq.auu(paramInt2);
        if (WebViewUI.this.WXQ != null)
        {
          paramString2 = this.controller;
          if (paramString2.atn(paramString2.WwW)) {
            break label247;
          }
        }
        label247:
        for (paramInt1 = paramInt3;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            WebViewUI.this.iyW();
          }
          WebViewUI.this.Wye.ivJ().WNc = false;
          WebViewUI.this.Wye.ivD().dH(paramString1, false);
          if (!WebViewUI.C(WebViewUI.this)) {
            break;
          }
          WebViewUI.this.finish();
          break;
        }
      }
      
      public final void b(String paramString, cdf paramcdf)
      {
        WebViewUI.this.WYi.WVo = paramcdf.aamN;
      }
      
      public final void bjt(String paramString)
      {
        AppMethodBeat.i(296123);
        WebViewUI.this.WYi.ixY();
        AppMethodBeat.o(296123);
      }
      
      public final void bju(String paramString)
      {
        AppMethodBeat.i(296145);
        WebViewUI.this.blJ(paramString);
        AppMethodBeat.o(296145);
      }
      
      public final void cb(int paramInt, String paramString)
      {
        AppMethodBeat.i(296117);
        super.cb(paramInt, paramString);
        if (paramInt != 5) {
          WebViewUI.this.IP(false);
        }
        AppMethodBeat.o(296117);
      }
      
      public final void cxT()
      {
        AppMethodBeat.i(296133);
        WebViewUI.this.IP(true);
        AppMethodBeat.o(296133);
      }
      
      public final void cxV()
      {
        AppMethodBeat.i(296158);
        super.cxV();
        WebViewUI.this.iyY();
        if ((!WebViewUI.this.WXU) && (!WebViewUI.this.WXV)) {
          WebViewUI.this.WWR.start();
        }
        AppMethodBeat.o(296158);
      }
      
      public final void cxW()
      {
        AppMethodBeat.i(296159);
        super.cxW();
        WebViewUI.this.WWR.finish();
        WebViewUI.this.iyX();
        AppMethodBeat.o(296159);
      }
      
      public final void cxX()
      {
        AppMethodBeat.i(296135);
        if (WebViewUI.this.WYd)
        {
          Log.e("MicroMsg.WebViewUI", "edw postBinded hasDoPostBind");
          AppMethodBeat.o(296135);
          return;
        }
        WebViewUI.this.WYd = true;
        WebViewUI.this.cKX();
        AppMethodBeat.o(296135);
      }
      
      public final void isG()
      {
        AppMethodBeat.i(296121);
        Log.i("MicroMsg.WebViewUI", "WebView-Trace onAuthSucc: url %s", new Object[] { WebViewUI.this.sMq });
        WebViewUI.a(WebViewUI.this, this.controller.sLD.iwo());
        if (!WebViewUI.this.WYI) {
          WebViewUI.this.WYi.WVs = true;
        }
        o localo = WebViewUI.this.WYi;
        localo.WVt.add(Integer.valueOf(6));
        localo.WVt.add(Integer.valueOf(1));
        localo.WVt.add(Integer.valueOf(3));
        localo.WVt.add(Integer.valueOf(2));
        WebViewUI.this.WYi.WVs = true;
        if (WebViewUI.this.WYi.ixP()) {
          WebViewUI.this.ixS();
        }
        AppMethodBeat.o(296121);
      }
      
      public final void isH()
      {
        AppMethodBeat.i(296137);
        WebViewUI.this.goBack();
        AppMethodBeat.o(296137);
      }
      
      public final void isI()
      {
        AppMethodBeat.i(296143);
        WebViewUI.this.iyD();
        AppMethodBeat.o(296143);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(296141);
        WebViewUI.this.finish();
        AppMethodBeat.o(296141);
      }
    }
  }
  
  final class d
    implements FontChooserView.a
  {
    private d() {}
    
    public final void mL(int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(80184);
      switch (paramInt)
      {
      case 1: 
      default: 
        i = 2;
      }
      for (;;)
      {
        WebViewUI.this.Wzl.att(i);
        try
        {
          if (WebViewUI.this.sLC.iwU())
          {
            MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("WebViewFontUtil", 2);
            localMultiProcessMMKV.putBoolean("webview_key_font_has_set", true);
            localMultiProcessMMKV.putBoolean("webview_key_has_transfer_mp", true);
            localMultiProcessMMKV.apply();
            com.tencent.mm.plugin.webview.k.m.Jf(false);
            WebViewUI.this.sLC.np(16384, i);
            WebViewUI.this.sLC.np(16388, i);
          }
          AppMethodBeat.o(80184);
          return;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.WebViewUI", "onCheckedChanged, ex = " + localException.getMessage());
          AppMethodBeat.o(80184);
        }
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
    final WeakReference<WebViewUI> tLO;
    
    public e(WebViewUI paramWebViewUI)
    {
      AppMethodBeat.i(80216);
      this.tLO = new WeakReference(paramWebViewUI);
      this.id = paramWebViewUI.Wzl.irL();
      AppMethodBeat.o(80216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI
 * JD-Core Version:    0.7.0.1
 */