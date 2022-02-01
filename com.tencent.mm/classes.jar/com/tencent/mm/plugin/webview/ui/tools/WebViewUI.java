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
import android.os.Looper;
import android.os.Parcelable;
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
import com.tencent.mm.ag.y;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.ad;
import com.tencent.mm.n.e.a;
import com.tencent.mm.n.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.c;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.f;
import com.tencent.mm.plugin.webview.core.g.a;
import com.tencent.mm.plugin.webview.d.h.27;
import com.tencent.mm.plugin.webview.d.h.68;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.ak.a;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.model.ax.a;
import com.tencent.mm.plugin.webview.model.ax.b;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.model.az.b;
import com.tencent.mm.plugin.webview.model.az.e;
import com.tencent.mm.plugin.webview.model.az.f;
import com.tencent.mm.plugin.webview.model.az.g;
import com.tencent.mm.plugin.webview.model.az.j;
import com.tencent.mm.plugin.webview.model.az.k;
import com.tencent.mm.plugin.webview.model.az.l;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.i;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView.q;
import com.tencent.mm.plugin.webview.ui.tools.video.b.2;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.MPSmileyFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.b;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.cru;
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
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.u;
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
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebViewUI
  extends MMSecDataActivity
  implements View.OnCreateContextMenuListener, com.tencent.mm.plugin.webview.core.b, com.tencent.mm.plugin.webview.h.a.b, com.tencent.mm.plugin.webview.ui.tools.video.samelayer.e, ScreenShotUtil.ScreenShotCallback, MMWebView.e
{
  private static final Pattern ITJ;
  private static final Pattern ITK;
  private static final ArrayList<e> JiD;
  private static WebSettings.RenderPriority JiI;
  private static Boolean JjD;
  protected static int Jjc;
  protected boolean CSQ;
  public com.tencent.mm.plugin.webview.d.h IBw;
  public o ILE;
  public com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h ILF;
  protected com.tencent.mm.plugin.webview.core.i IMH;
  public az IMs;
  protected com.tencent.mm.plugin.webview.stub.f ISw;
  private View JfG;
  final com.tencent.mm.plugin.webview.modeltools.a JfY;
  protected boolean JhT;
  private boolean JhU;
  protected MMFalseProgressBar JhV;
  public ProgressBar JhW;
  public q JhX;
  private h JhY;
  private ImageButton JhZ;
  private boolean JiA;
  private View JiB;
  private MTimerHandler JiC;
  private boolean JiE;
  private WebChromeClient.CustomViewCallback JiF;
  protected com.tencent.xweb.x JiG;
  private ProgressBar JiH;
  private final IListener<SendDataToH5FromMiniProgramEvent> JiJ;
  private boolean JiK;
  protected boolean JiL;
  protected HashMap<String, Boolean> JiM;
  protected HashMap<String, String> JiN;
  protected HashMap<String, ArrayList<e.b>> JiO;
  protected HashMap<String, Boolean> JiP;
  protected a JiQ;
  protected com.tencent.mm.ui.widget.a.d JiR;
  protected View JiS;
  protected String JiT;
  private boolean JiU;
  private final boolean JiV;
  private boolean JiW;
  protected volatile boolean JiX;
  protected boolean JiY;
  private Map JiZ;
  private ImageButton Jia;
  protected View Jib;
  protected WebViewKeyboardLinearLayout Jic;
  protected FrameLayout Jid;
  public FrameLayout Jie;
  protected MovingImageButton Jif;
  protected boolean Jig;
  private boolean Jih;
  protected com.tencent.mm.bo.a Jii;
  private WebViewRedesignInputFooter Jij;
  protected WebViewSearchContentInputFooter Jik;
  private boolean Jil;
  private boolean Jim;
  public String Jin;
  protected boolean Jio;
  protected boolean Jip;
  protected long Jiq;
  private boolean Jir;
  private int Jis;
  int Jit;
  private boolean Jiu;
  protected boolean Jiv;
  private boolean Jiw;
  protected boolean Jix;
  protected int Jiy;
  protected byte[] Jiz;
  private MPVideoPlayFullScreenView JjA;
  int JjB;
  private boolean JjC;
  protected View JjE;
  private View JjF;
  private com.tencent.mm.bo.a.b JjG;
  private boolean JjH;
  public final k JjI;
  public final com.tencent.mm.plugin.webview.ui.tools.media.e JjJ;
  private boolean JjK;
  private View.OnLongClickListener JjL;
  protected boolean JjM;
  private View.OnLongClickListener JjN;
  protected View.OnLongClickListener JjO;
  private String JjP;
  protected volatile String JjQ;
  private WebChromeClient.CustomViewCallback JjR;
  protected c JjS;
  public int JjT;
  private int Jja;
  public int Jjb;
  public boolean Jjd;
  private boolean Jje;
  private boolean Jjf;
  protected boolean Jjg;
  protected volatile boolean Jjh;
  private com.tencent.mm.plugin.webview.k.j Jji;
  private com.tencent.mm.plugin.webview.model.b Jjj;
  protected com.tencent.mm.plugin.webview.modeltools.n Jjk;
  protected i Jjl;
  public j Jjm;
  protected IUtils Jjn;
  private WebViewClipBoardHelper Jjo;
  protected com.tencent.mm.plugin.webview.c Jjp;
  protected volatile String Jjq;
  protected volatile long Jjr;
  protected HandOffURL Jjs;
  com.tencent.mm.plugin.webview.ui.tools.floatball.b Jjt;
  com.tencent.mm.plugin.webview.ui.tools.multitask.a Jju;
  private boolean Jjv;
  protected ab Jjw;
  private IListener<ub> Jjx;
  private com.tencent.mm.plugin.webview.ui.tools.widget.n Jjy;
  private boolean Jjz;
  public String eam;
  private q gut;
  public MMHandler handler;
  public com.tencent.mm.plugin.webview.stub.e mHh;
  protected com.tencent.mm.plugin.webview.f.g mHi;
  private final com.tencent.mm.plugin.webview.modeltools.d mHr;
  private int mStatusBarHeight;
  public String pFJ;
  public MMWebView pGj;
  protected int ppd;
  protected int ppe;
  private int pzw;
  protected int screenOrientation;
  protected String sessionId;
  private View vk;
  public int xPp;
  public String xPq;
  protected com.tencent.mm.ui.widget.snackbar.a.b xxK;
  private long zdW;
  
  static
  {
    AppMethodBeat.i(80400);
    JiD = new ArrayList();
    JiI = WebSettings.RenderPriority.NORMAL;
    Jjc = 0;
    JjD = null;
    ITJ = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    ITK = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    AppMethodBeat.o(80400);
  }
  
  public WebViewUI()
  {
    AppMethodBeat.i(80217);
    this.JhT = false;
    this.JhU = false;
    this.screenOrientation = -1;
    this.Jig = false;
    this.Jih = false;
    this.Jin = null;
    this.Jio = true;
    this.Jip = false;
    this.Jiq = 0L;
    this.Jir = false;
    this.sessionId = "";
    this.Jit = -1;
    this.CSQ = true;
    this.Jiu = false;
    this.Jiv = true;
    this.Jiw = false;
    this.Jix = false;
    this.Jiz = new byte[0];
    this.IBw = null;
    this.JiA = false;
    this.JiE = false;
    this.mHi = null;
    this.ILF = new com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h(this);
    this.JiJ = new IListener() {};
    this.JiK = false;
    this.mHh = null;
    this.IMH = null;
    this.JiL = false;
    this.JiM = new HashMap();
    this.JiN = new HashMap();
    this.JiO = new HashMap();
    this.JiP = new HashMap();
    this.JiR = null;
    this.JiS = null;
    this.JiT = null;
    this.JiU = false;
    this.JiV = true;
    this.JiW = false;
    this.xPp = 0;
    this.xPq = null;
    this.JiX = false;
    this.JiY = false;
    this.Jja = 0;
    this.Jjb = ((int)(System.currentTimeMillis() / 1000L));
    this.Jjd = false;
    this.Jje = false;
    this.Jjf = false;
    this.Jjg = false;
    this.Jjh = false;
    this.IMs = new az();
    this.Jji = new com.tencent.mm.plugin.webview.k.j();
    this.Jjk = new com.tencent.mm.plugin.webview.modeltools.n();
    this.Jjn = null;
    this.Jjv = false;
    this.Jjw = new ab()
    {
      public final boolean B(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80052);
        if (WebViewUI.this.pGj == null)
        {
          AppMethodBeat.o(80052);
          return false;
        }
        boolean bool = WebViewUI.this.pGj.am(paramAnonymousMotionEvent);
        AppMethodBeat.o(80052);
        return bool;
      }
      
      public final boolean C(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80057);
        if (WebViewUI.this.pGj == null)
        {
          AppMethodBeat.o(80057);
          return false;
        }
        boolean bool = WebViewUI.this.pGj.an(paramAnonymousMotionEvent);
        AppMethodBeat.o(80057);
        return bool;
      }
      
      public final boolean D(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80058);
        if (WebViewUI.this.pGj == null)
        {
          AppMethodBeat.o(80058);
          return false;
        }
        boolean bool = WebViewUI.this.pGj.ao(paramAnonymousMotionEvent);
        AppMethodBeat.o(80058);
        return bool;
      }
      
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(80053);
        if (WebViewUI.this.pGj == null)
        {
          AppMethodBeat.o(80053);
          return false;
        }
        ak localak = WebViewUI.this.IMs.gdd();
        if (paramAnonymousInt4 > localak.IZc) {
          localak.IZc = paramAnonymousInt4;
        }
        localak.EOU = paramAnonymousInt6;
        paramAnonymousBoolean = WebViewUI.this.pGj.c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
        AppMethodBeat.o(80053);
        return paramAnonymousBoolean;
      }
      
      public final void bLv()
      {
        AppMethodBeat.i(80054);
        if (WebViewUI.this.pGj == null)
        {
          AppMethodBeat.o(80054);
          return;
        }
        WebViewUI.this.pGj.gYY();
        AppMethodBeat.o(80054);
      }
      
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(80055);
        if (WebViewUI.this.pGj == null)
        {
          AppMethodBeat.o(80055);
          return;
        }
        WebViewUI.this.pGj.h(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
        if ((paramAnonymousBoolean2) && (WebViewUI.this.IMs != null)) {
          WebViewUI.this.IMs.D("mm_scroll_bottom", Boolean.TRUE);
        }
        AppMethodBeat.o(80055);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(80056);
        if (WebViewUI.this.pGj == null)
        {
          AppMethodBeat.o(80056);
          return;
        }
        WebViewUI.this.pGj.R(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        WebViewUI.this.onWebViewScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(80056);
      }
    };
    this.Jjx = new IListener()
    {
      private boolean gga()
      {
        AppMethodBeat.i(80075);
        if (WebViewUI.this.mHh == null)
        {
          Log.e("MicroMsg.WebViewUI", "Cli Event, invoker is null");
          AppMethodBeat.o(80075);
          return false;
        }
        if ((WebViewUI.this.Jjq == null) || (WebViewUI.this.Jjq.length() == 0))
        {
          Log.e("MicroMsg.WebViewUI", "Cli Event, tid is null");
          AppMethodBeat.o(80075);
          return false;
        }
        try
        {
          long l = System.currentTimeMillis();
          Log.i("MicroMsg.WebViewUI", "Cli Event, tid = %s, stime = %d, etime = %d", new Object[] { WebViewUI.this.Jjq, Long.valueOf(WebViewUI.this.Jjr), Long.valueOf(l) });
          Bundle localBundle = new Bundle();
          localBundle.putString("service_click_tid", new String(WebViewUI.this.Jjq));
          localBundle.putLong("service_click_stime", WebViewUI.this.Jjr);
          localBundle.putLong("service_click_etime", l);
          WebViewUI.this.mHh.x(2836, localBundle);
          WebViewUI.this.Jjq = null;
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
    this.Jjz = false;
    this.JjB = 0;
    this.JjC = true;
    this.zdW = 0L;
    this.pzw = 0;
    this.JjG = new com.tencent.mm.bo.a.b()
    {
      public final void a(com.tencent.mm.bo.a.a paramAnonymousa1, com.tencent.mm.bo.a.a paramAnonymousa2)
      {
        AppMethodBeat.i(211110);
        Log.i("MicroMsg.WebViewUI", "OrientationListener lastOrientation:" + paramAnonymousa1.name() + "; newOrientation:" + paramAnonymousa2.name());
        WebViewUI.this.screenOrientation = 4;
        WebViewUI.this.setMMOrientation();
        if (WebViewUI.this.Jii != null) {
          WebViewUI.this.Jii.disable();
        }
        AppMethodBeat.o(211110);
      }
    };
    this.JjH = false;
    this.JjI = new k();
    this.mHr = new com.tencent.mm.plugin.webview.modeltools.d();
    this.JfY = new com.tencent.mm.plugin.webview.modeltools.a();
    this.JjJ = new com.tencent.mm.plugin.webview.ui.tools.media.e();
    this.JjL = new View.OnLongClickListener()
    {
      private boolean ggb()
      {
        boolean bool2 = true;
        AppMethodBeat.i(80078);
        Object localObject = null;
        try
        {
          WebView.b localb = WebViewUI.this.pGj.getHitTestResult();
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
          bool1 = WebViewUI.this.mHh.gw(localObject.mExtra);
          if (!bool1) {}
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            label137:
            boolean bool1 = true;
            Log.w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + localException2.getMessage());
          }
        }
        try
        {
          WebViewUI.this.mHh.gt(localObject.mExtra, WebViewUI.this.fZu());
          if (bool1) {
            break label181;
          }
          WebViewUI.c(WebViewUI.this, localObject.mExtra);
          bool1 = bool2;
        }
        catch (Exception localException3)
        {
          break label148;
          break label137;
        }
        AppMethodBeat.o(80078);
        return bool1;
      }
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80077);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$31", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        if (WebViewUI.this.getIntent().getBooleanExtra("show_long_click_popup_menu", true))
        {
          boolean bool = ggb();
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$31", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(80077);
          return bool;
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$31", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(80077);
        return true;
      }
    };
    this.JjM = false;
    this.JjO = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(211116);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$35", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        if ((WebViewUI.f(WebViewUI.this) != null) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())))
        {
          boolean bool = WebViewUI.f(WebViewUI.this).onLongClick(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$35", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(211116);
          return bool;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$35", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(211116);
        return false;
      }
    };
    this.JjQ = "";
    this.JjS = new c();
    this.xxK = new com.tencent.mm.ui.widget.snackbar.a.b()
    {
      public final void bDZ()
      {
        AppMethodBeat.i(211127);
        try
        {
          WebViewUI.this.mHh.favEditTag();
          AppMethodBeat.o(211127);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + localException.getMessage());
          AppMethodBeat.o(211127);
        }
      }
    };
    this.JjT = -1;
    AppMethodBeat.o(80217);
  }
  
  private void a(JsapiPermissionWrapper paramJsapiPermissionWrapper)
  {
    AppMethodBeat.i(211183);
    if (paramJsapiPermissionWrapper != null)
    {
      if (paramJsapiPermissionWrapper.pP(34))
      {
        setMMSubTitle(2131768658);
        AppMethodBeat.o(211183);
        return;
      }
      if (paramJsapiPermissionWrapper.pP(75))
      {
        setMMSubTitle(2131768671);
        AppMethodBeat.o(211183);
        return;
      }
      setMMSubTitle(null);
    }
    AppMethodBeat.o(211183);
  }
  
  private static void aC(View paramView, int paramInt)
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
  
  private void aYq(String paramString)
  {
    AppMethodBeat.i(80241);
    if (this.IBw != null)
    {
      this.IBw.aYe(paramString);
      try
      {
        if (paramString.equals("onPause"))
        {
          this.mHh.agA(this.IMH.fZu());
          AppMethodBeat.o(80241);
          return;
        }
        if (paramString.equals("onResume")) {
          this.mHh.agz(this.IMH.fZu());
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
  
  private void bao(String paramString)
  {
    AppMethodBeat.i(80239);
    if ((this.Jjt != null) && (!Util.isNullOrNil(paramString)) && (!com.tencent.mm.plugin.webview.ui.tools.floatball.b.isMpUrl(coX()))) {
      this.Jjt.agT(paramString);
    }
    if ((this.Jju != null) && (!Util.isNullOrNil(paramString)) && (!com.tencent.mm.plugin.webview.ui.tools.multitask.a.isMpUrl(coX()))) {
      this.Jju.aCM(paramString);
    }
    AppMethodBeat.o(80239);
  }
  
  private void bap(String paramString)
  {
    AppMethodBeat.i(80240);
    if ((this.Jjs != null) && (!Util.isNullOrNil(paramString)) && ((this.Jjt != null) || (this.Jju != null)) && (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(coX())) && (!this.Jjs.getTitle().equals(paramString)))
    {
      this.Jjs.setTitle(paramString);
      if (gbH()) {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Jjs);
      }
    }
    AppMethodBeat.o(80240);
  }
  
  private void baq(String paramString)
  {
    AppMethodBeat.i(211165);
    if ((Util.isNullOrNil(paramString)) || (paramString.startsWith("data:text/html;charset=utf-8")))
    {
      AppMethodBeat.o(211165);
      return;
    }
    if (this.IMH != null) {}
    for (String str = this.IMH.beU();; str = "")
    {
      str = Util.nullAsNil(str);
      if (this.Jjt != null) {
        this.Jjt.eU("handoff#shareUrl", str);
      }
      if (this.Jju != null) {
        this.Jju.IVb.Nwh = str;
      }
      if (!str.isEmpty()) {
        paramString = str;
      }
      if ((this.Jjs != null) && (!Util.isNullOrNil(paramString)) && (!this.Jjs.getUrl().equals(paramString)))
      {
        this.Jjs.setUrl(paramString);
        if (gbH()) {
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Jjs);
        }
      }
      AppMethodBeat.o(211165);
      return;
    }
  }
  
  private static String bar(String paramString)
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
  
  private static void ge(View paramView)
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
  
  private boolean gek()
  {
    boolean bool1 = false;
    AppMethodBeat.i(80298);
    try
    {
      if (this.mHh == null)
      {
        Log.w("MicroMsg.WebViewUI", "invoker is null");
        AppMethodBeat.o(80298);
        return false;
      }
      boolean bool2 = this.mHh.gek();
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
  
  private void gfM()
  {
    AppMethodBeat.i(80316);
    if (this.JiB != null) {
      this.JiB.setVisibility(8);
    }
    if (this.JiC != null) {
      this.JiC.stopTimer();
    }
    AppMethodBeat.o(80316);
  }
  
  private boolean gfQ()
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
              AppMethodBeat.i(211124);
              WebViewUI.this.Jjd = true;
              l.Jhd.close();
              WebViewUI.this.finish();
              AppMethodBeat.o(211124);
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
              AppMethodBeat.i(211125);
              WebViewUI.this.Jjd = true;
              l.Jhd.close();
              WebViewUI.this.finish();
              AppMethodBeat.o(211125);
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
    ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
    ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
    startActivityForResult((Intent)localObject, i);
    com.tencent.mm.ui.base.b.ke(this);
    AppMethodBeat.o(80355);
    return true;
  }
  
  private void gfS()
  {
    AppMethodBeat.i(80357);
    if (this.Jjf)
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
      com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, localBundle, com.tencent.mm.pluginsdk.model.app.v.class, null);
    }
    AppMethodBeat.o(80357);
  }
  
  private com.tencent.mm.plugin.webview.model.b gfd()
  {
    AppMethodBeat.i(211153);
    if (this.Jjj == null) {
      this.Jjj = new com.tencent.mm.plugin.webview.model.b(this.IMs);
    }
    com.tencent.mm.plugin.webview.model.b localb = this.Jjj;
    AppMethodBeat.o(211153);
    return localb;
  }
  
  private static boolean gfm()
  {
    AppMethodBeat.i(80248);
    if (JjD == null) {}
    try
    {
      if (Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_webview_force_dark_disable", "0", false, true), 1) > 0) {
        Log.i("MicroMsg.WebViewUI", "disableForceDark on!!");
      }
      for (JjD = Boolean.TRUE;; JjD = Boolean.FALSE)
      {
        boolean bool = JjD.booleanValue();
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
        JjD = Boolean.FALSE;
      }
    }
  }
  
  private boolean gfo()
  {
    return (this.Jig) || (this.Jih);
  }
  
  private int gfp()
  {
    AppMethodBeat.i(80252);
    if (this.JiV) {}
    for (int i = 0; (getSupportActionBar() == null) || (!getSupportActionBar().isShowing()); i = this.mStatusBarHeight)
    {
      AppMethodBeat.o(80252);
      return i;
    }
    int j = getActionBarHeight();
    AppMethodBeat.o(80252);
    return i + j;
  }
  
  private View gfw()
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
  
  private void updateOrientation()
  {
    AppMethodBeat.i(211173);
    if (this.mHh != null) {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("screen_orientation", this.screenOrientation);
        this.mHh.j(83, localBundle);
        AppMethodBeat.o(211173);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.WebViewUI", "ac_set_screen_orientation : " + localException.getMessage());
      }
    }
    AppMethodBeat.o(211173);
  }
  
  private void yY(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.JiE = true;
    }
  }
  
  public final void Mf(long paramLong)
  {
    AppMethodBeat.i(211176);
    this.Jjm.Mf(paramLong);
    AppMethodBeat.o(211176);
  }
  
  protected void X(Bundle paramBundle)
  {
    AppMethodBeat.i(211186);
    this.Jjm.geS();
    AppMethodBeat.o(211186);
  }
  
  @TargetApi(21)
  protected final void a(ViewGroup paramViewGroup, WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(80253);
    if (this.mStatusBarHeight == paramWindowInsets.getSystemWindowInsetTop())
    {
      AppMethodBeat.o(80253);
      return;
    }
    this.mStatusBarHeight = paramWindowInsets.getSystemWindowInsetTop();
    gfn();
    Object localObject = paramViewGroup;
    if ((paramViewGroup instanceof SwipeBackLayout)) {
      localObject = paramViewGroup.getChildAt(0);
    }
    paramViewGroup = ((View)localObject).findViewById(2131296366);
    if (paramViewGroup != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = paramWindowInsets.getSystemWindowInsetTop();
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramViewGroup.requestLayout();
    }
    if (gfq()) {
      gfs();
    }
    AppMethodBeat.o(80253);
  }
  
  public final void a(com.tencent.mm.plugin.webview.ui.tools.video.c paramc)
  {
    AppMethodBeat.i(211158);
    this.ILF.a(paramc);
    AppMethodBeat.o(211158);
  }
  
  public final void a(q paramq)
  {
    this.gut = paramq;
  }
  
  public final void aB(View paramView, int paramInt)
  {
    AppMethodBeat.i(211157);
    com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h localh = this.ILF;
    Object localObject = paramView;
    if (paramView == null) {
      localObject = this.pGj;
    }
    localh.aB((View)localObject, paramInt);
    AppMethodBeat.o(211157);
  }
  
  protected void aG(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211174);
    if (this.Jij == null)
    {
      AppMethodBeat.o(211174);
      return;
    }
    WebViewRedesignInputFooter localWebViewRedesignInputFooter = this.Jij;
    localWebViewRedesignInputFooter.setVisibility(0);
    if (localWebViewRedesignInputFooter.JAP != null) {
      localWebViewRedesignInputFooter.JAP.setVisibility(0);
    }
    if (localWebViewRedesignInputFooter.JAO != null)
    {
      localWebViewRedesignInputFooter.JAO.setEnabled(true);
      localWebViewRedesignInputFooter.JAO.setBackgroundResource(2131235708);
    }
    if (localWebViewRedesignInputFooter.JAL != null) {
      localWebViewRedesignInputFooter.JAL.setVisibility(0);
    }
    localWebViewRedesignInputFooter.JAQ = false;
    if (localWebViewRedesignInputFooter.JAO != null)
    {
      localWebViewRedesignInputFooter.JAO.setFocusable(true);
      localWebViewRedesignInputFooter.JAO.setFocusableInTouchMode(true);
      localWebViewRedesignInputFooter.JAO.requestFocus();
    }
    if (localWebViewRedesignInputFooter.gte != null) {
      localWebViewRedesignInputFooter.gte.showVKB();
    }
    localWebViewRedesignInputFooter.state = 0;
    if (!Util.isNullOrNil(paramString)) {
      this.Jij.setText(paramString);
    }
    if (paramInt1 >= 0)
    {
      this.Jij.setMaxCount(paramInt1);
      this.Jij.setShowRemindWordCount(paramInt2);
    }
    AppMethodBeat.o(211174);
  }
  
  public final void aS(Bundle paramBundle)
  {
    AppMethodBeat.i(80231);
    this.JjB = paramBundle.getInt("state", 0);
    AppMethodBeat.o(80231);
  }
  
  public final void aT(Bundle paramBundle)
  {
    AppMethodBeat.i(80227);
    if (paramBundle != null)
    {
      this.Jjz = "black".equals(paramBundle.getString("style"));
      gfh().setCommentTopicId(paramBundle.getLong("commentTopicId"));
    }
    gfh().bbn(this.IMH.getCurrentUrl());
    gfh().zw(false);
    AppMethodBeat.o(80227);
  }
  
  public final void aU(Bundle paramBundle)
  {
    AppMethodBeat.i(80229);
    if (paramBundle != null)
    {
      this.Jjz = "black".equals(paramBundle.getString("style"));
      gfh().zw(true);
    }
    AppMethodBeat.o(80229);
  }
  
  public final void aV(Bundle paramBundle)
  {
    AppMethodBeat.i(80230);
    this.gut = com.tencent.mm.plugin.webview.ui.tools.widget.p.a(paramBundle, getContext(), this.gut);
    AppMethodBeat.o(80230);
  }
  
  protected final void aV(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(80280);
    this.Jig = paramBoolean1;
    Object localObject;
    if (paramBoolean1)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      if (this.JjE != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.JjE.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
        this.JjE.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.JiV) {
        com.tencent.mm.ui.statusbar.a.T(this.JjE, true);
      }
      for (;;)
      {
        getWindow().addFlags(1024);
        localObject = getWindow().getDecorView();
        ((View)localObject).setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
        {
          public final void onSystemUiVisibilityChange(int paramAnonymousInt)
          {
            AppMethodBeat.i(80047);
            if (((paramAnonymousInt & 0x4) == 0) && (WebViewUI.this.Jig)) {
              WebViewUI.gf(this.nFs);
            }
            AppMethodBeat.o(80047);
          }
        });
        aC((View)localObject, 5894);
        if (!paramBoolean2) {
          break;
        }
        this.Jif.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80048);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            WebViewUI.this.cpD();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80048);
          }
        });
        this.Jif.setVisibility(0);
        AppMethodBeat.o(80280);
        return;
        if (this.JjF != null) {
          this.JjF.setVisibility(8);
        }
      }
      this.Jif.setVisibility(8);
      AppMethodBeat.o(80280);
      return;
    }
    this.Jif.setVisibility(8);
    getWindow().clearFlags(1024);
    ge(getWindow().getDecorView());
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().show();
      if (this.JjE != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.JjE.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = gfp();
        this.JjE.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    if (this.JiV)
    {
      com.tencent.mm.ui.statusbar.a.T(this.JjE, false);
      AppMethodBeat.o(80280);
      return;
    }
    if (this.JjF != null) {
      this.JjF.setVisibility(0);
    }
    AppMethodBeat.o(80280);
  }
  
  public final void aW(Bundle paramBundle)
  {
    AppMethodBeat.i(175797);
    if (paramBundle != null) {
      gfh().setCommentTopicId(paramBundle.getLong("commentTopicId"));
    }
    gfh().bbn(this.IMH.getCurrentUrl());
    com.tencent.mm.plugin.webview.ui.tools.widget.n localn = gfh();
    String str = paramBundle.getString("reply_content");
    int i = paramBundle.getInt("personal_comment_id");
    kotlin.g.b.p.h(str, "replyContent");
    localn.xV(2);
    localn.zy(false);
    if ((!Util.isNullOrNil(str)) && (i != 0) && (localn.giC()))
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n.a(localn, str, i);
      localn.zx(false);
      AppMethodBeat.o(175797);
      return;
    }
    localn.zw(false);
    AppMethodBeat.o(175797);
  }
  
  public final String aXD(String paramString)
  {
    AppMethodBeat.i(211181);
    paramString = this.IMH.aXD(paramString);
    AppMethodBeat.o(211181);
    return paramString;
  }
  
  protected final int aXI(String paramString)
  {
    AppMethodBeat.i(80336);
    int i = this.IMH.aXI(paramString);
    AppMethodBeat.o(80336);
    return i;
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(80313);
    if (!com.tencent.mm.compatible.util.d.oD(21))
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
    if (gfr()) {
      localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
    for (;;)
    {
      addIconOptionMenu(paramInt1, getString(2131755899), localDrawable, paramOnMenuItemClickListener);
      AppMethodBeat.o(80313);
      return;
      if ((this.ILE != null) && (!this.ILE.Jkf)) {
        localDrawable.setColorFilter(getResources().getColor(2131099746), PorterDuff.Mode.SRC_ATOP);
      } else {
        localDrawable.clearColorFilter();
      }
    }
  }
  
  protected final void agM(int paramInt)
  {
    AppMethodBeat.i(80288);
    Drawable localDrawable = getResources().getDrawable(gfD()).mutate();
    localDrawable.setColorFilter(paramInt, PorterDuff.Mode.SRC_IN);
    updateBackBtn(localDrawable);
    AppMethodBeat.o(80288);
  }
  
  protected final void agN(int paramInt)
  {
    AppMethodBeat.i(80315);
    if (paramInt != -3)
    {
      AppMethodBeat.o(80315);
      return;
    }
    if (this.JiB == null)
    {
      AppMethodBeat.o(80315);
      return;
    }
    if ((this.mHi.gdI().Kzi & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = ".concat(String.valueOf(bool)));
      if (!bool) {
        break label233;
      }
      if ((this.JiB.getVisibility() != 0) && (!this.Jik.isShown())) {
        break;
      }
      AppMethodBeat.o(80315);
      return;
    }
    if (this.JiC == null) {
      this.JiC = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(211120);
          WebViewUI.j(WebViewUI.this);
          AppMethodBeat.o(211120);
          return false;
        }
      }, false);
    }
    this.JiC.startTimer(4000L);
    View localView = this.JiB;
    ((ImageView)localView.findViewById(2131303239)).setImageResource(2131691226);
    TextView localTextView = (TextView)localView.findViewById(2131303240);
    localTextView.setTextSize(14.0F);
    localTextView.setText(2131768761);
    ((ImageButton)localView.findViewById(2131303238)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(211121);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WebViewUI.j(WebViewUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(211121);
      }
    });
    this.JiB.setVisibility(0);
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(13125, coX());
    label233:
    AppMethodBeat.o(80315);
  }
  
  public final void agO(int paramInt)
  {
    AppMethodBeat.i(211179);
    this.IBw.cL("sendAppMessage", true);
    this.IBw.c(this.Jjm.geQ(), paramInt);
    this.IMs.aZc("mm_send_friend_count");
    AppMethodBeat.o(211179);
  }
  
  protected void agP(int paramInt)
  {
    AppMethodBeat.i(80351);
    if ((this.pGj == null) || (this.pGj.getSettings() == null))
    {
      AppMethodBeat.o(80351);
      return;
    }
    Log.i("MicroMsg.WebViewUI", "localSetFontSize, fontSize = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      this.pGj.getSettings().setTextZoom(100);
      AppMethodBeat.o(80351);
      return;
    case 1: 
      this.pGj.getSettings().setTextZoom(80);
      AppMethodBeat.o(80351);
      return;
    case 2: 
      this.pGj.getSettings().setTextZoom(100);
      AppMethodBeat.o(80351);
      return;
    case 3: 
      this.pGj.getSettings().setTextZoom(110);
      AppMethodBeat.o(80351);
      return;
    case 4: 
      this.pGj.getSettings().setTextZoom(112);
      AppMethodBeat.o(80351);
      return;
    case 5: 
      this.pGj.getSettings().setTextZoom(112);
      AppMethodBeat.o(80351);
      return;
    case 6: 
      this.pGj.getSettings().setTextZoom(140);
      AppMethodBeat.o(80351);
      return;
    case 7: 
      this.pGj.getSettings().setTextZoom(155);
      AppMethodBeat.o(80351);
      return;
    }
    this.pGj.getSettings().setTextZoom(165);
    AppMethodBeat.o(80351);
  }
  
  protected void ani()
  {
    AppMethodBeat.i(80342);
    this.Jjm.ani();
    AppMethodBeat.o(80342);
  }
  
  public final void b(com.tencent.mm.plugin.webview.ui.tools.video.c paramc)
  {
    AppMethodBeat.i(211159);
    this.ILF.b(paramc);
    AppMethodBeat.o(211159);
  }
  
  protected void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(80367);
    paramWebView = this.IMs;
    Intent localIntent = getIntent();
    String str2 = coX();
    int i = localIntent.getIntExtra("geta8key_scene", 0);
    int j = localIntent.getIntExtra("bizEnterId", paramWebView.Jac);
    int k = localIntent.getIntExtra("webview_scene_type", 1);
    String str3 = localIntent.getStringExtra("webview_scene_note");
    String str1 = localIntent.getStringExtra("srcUsername");
    paramWebView = str1;
    if (Util.isNullOrNil(str1)) {
      paramWebView = localIntent.getStringExtra("geta8key_username");
    }
    str1 = localIntent.getStringExtra("KAppId");
    com.tencent.mm.plugin.report.service.h.CyF.a(18452, new Object[] { Integer.valueOf(j), Integer.valueOf(i), com.tencent.mm.pluginsdk.ui.tools.z.bfG(str2), com.tencent.mm.pluginsdk.ui.tools.z.bfG(paramString), Integer.valueOf(k), str3, str1, paramWebView });
    AppMethodBeat.o(80367);
  }
  
  protected final void b(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(80309);
    addIconOptionMenu(0, paramString, paramDrawable, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(211115);
        if (!this.JjW) {
          WebViewUI.this.cpD();
        }
        for (;;)
        {
          AppMethodBeat.o(211115);
          return true;
          WebViewUI.this.bas(this.gtz);
        }
      }
    });
    AppMethodBeat.o(80309);
  }
  
  public final int bLC()
  {
    AppMethodBeat.i(80335);
    int i = this.IMH.bLC();
    AppMethodBeat.o(80335);
    return i;
  }
  
  public void bXg()
  {
    int k = 2;
    int m = 1;
    AppMethodBeat.i(80295);
    if ((this.Jje) || (this.Jjd) || (isFinishing()))
    {
      Log.e("MicroMsg.WebViewUI", "edw postBinded finished");
      AppMethodBeat.o(80295);
      return;
    }
    Object localObject1 = gfG();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.webview.d.i)localObject1).IRQ = this.IMH.getJsapi();
    }
    this.mHh = this.IMH.fZs();
    try
    {
      this.mHh.a(this.ISw, this.IMH.fZu());
      Log.i("MicroMsg.WebViewUI", "edw postBinded");
      this.Jjt = new com.tencent.mm.plugin.webview.ui.tools.floatball.b(new com.tencent.mm.plugin.ball.a.e(this), this);
      localObject1 = getIntent().getStringExtra("float_ball_key");
      if (!Util.isNullOrNil((String)localObject1))
      {
        this.Jjt.G(2, (String)localObject1);
        this.Jjt.agT(coX());
        this.Jjt.eU("rawUrl", coX());
        this.Jjt.aYt(coX());
        this.Jju = new com.tencent.mm.plugin.webview.ui.tools.multitask.a(new com.tencent.mm.plugin.multitask.a.b(this), this);
        localObject1 = getIntent().getStringExtra("float_ball_key");
        if (Util.isNullOrNil((String)localObject1)) {
          break label1247;
        }
        this.Jju.G(2, (String)localObject1);
        this.Jju.setRawUrl(coX());
        if (this.Jjt != null) {
          this.Jjt.bCA();
        }
        if (this.Jju != null) {
          this.Jju.bCA();
        }
        if (this.Jjs == null) {
          break label1279;
        }
        i = 1;
        if (this.Jjs == null) {
          this.Jjs = new HandOffURL(coX(), coX(), "");
        }
        if ((!ao.isMultiTaskMode()) || (this.Jju == null)) {
          break label1284;
        }
        localObject1 = this.Jju.Abp;
        if (localObject1 != null)
        {
          localObject2 = ((MultiTaskInfo)localObject1).erh().title;
          if (!Util.isNullOrNil((String)localObject2)) {
            this.Jjs.setTitle((String)localObject2);
          }
          this.Jjs.setIcon(Util.nullAsNil(((MultiTaskInfo)localObject1).erh().MwR));
        }
        if (gbH())
        {
          if (i == 0) {
            break label1347;
          }
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Jjs);
          Log.i("MicroMsg.WebViewUI", "[Handoff] onPostBinded, exist:true, call upsert " + this.Jjs.toString());
        }
        baq(coX());
        localObject1 = gfd();
        localObject2 = this.mHh;
      }
    }
    catch (RemoteException localException4)
    {
      try
      {
        str = ((com.tencent.mm.plugin.webview.stub.e)localObject2).aZV("DNSAdvanceOpen");
        Log.i("MicroMsg.DNSPreGetOptimize", "switch open value : %s", new Object[] { str });
        if (Util.isNullOrNil(str))
        {
          Log.e("MicroMsg.DNSPreGetOptimize", "get switch value is null or nil");
          bool = false;
          if (bool) {
            break label1424;
          }
          Log.i("MicroMsg.DNSPreGetOptimize", "server closed the switch");
          if (gfH()) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80079);
                if (WebViewUI.this.pGj != null) {
                  WebViewUI.this.pGj.getCurWebviewClient().b(WebViewUI.this.pGj, WebViewUI.this.pGj.getUrl());
                }
                AppMethodBeat.o(80079);
              }
            });
          }
          localObject1 = this.IMH.getTitle();
          bao((String)localObject1);
          bap((String)localObject1);
        }
      }
      catch (Exception localException4)
      {
        try
        {
          localObject1 = gft();
          if ((localObject1 != null) && (this.Jjs != null))
          {
            this.Jjs.setTitle(Util.nullAsNil(((o.a)localObject1).title));
            this.Jjs.setIcon(Util.nullAsNil(((o.a)localObject1).Jko));
            this.Jjs.setNickname(Util.nullAsNil(((o.a)localObject1).Jkn));
            if (gbH()) {
              ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Jjs);
            }
          }
        }
        catch (Exception localException4)
        {
          try
          {
            i = Util.getInt(this.mHh.aZV("WebviewDisableX5Logo"), 0);
            bool = getIntent().getBooleanExtra("disable_bounce_scroll", false);
            Log.i("MicroMsg.WebViewUI", "getting flag of x5 logo state, disableX5Logo = %d, disableBounceScroll = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
            if ((i == 1) || (bool)) {
              this.JjI.zh(true);
            }
            if (getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_disable_over_scroll", false)) {
              this.JjI.zh(true);
            }
            this.Jji.bN("onJSAPIEnd", System.currentTimeMillis());
            if ((this.pGj != null) && (this.pGj.getIsX5Kernel()))
            {
              bool = true;
              az.aU(bool, Util.nullAsNil(coX()).startsWith("https://"));
            }
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                j = Util.getInt(this.mHh.aZV("XwebBatchTranslateMaxByteLength"), 0);
                i = Util.getInt(this.mHh.aZV("XwebBatchTranslateMaxCnt"), 0);
                Log.i("MicroMsg.WebViewUI", "getting flag of XwebBatchTranslate para BatchTranslateMaxByteLength  = " + j + " BatchTranslateCnt = " + i);
                localObject1 = this.Jjp;
                ((com.tencent.mm.plugin.webview.c)localObject1).IJA = j;
                ((com.tencent.mm.plugin.webview.c)localObject1).IJB = i;
                if (getIntent().getBooleanExtra("translate_webview", false))
                {
                  localObject1 = this.Jjp;
                  localObject2 = this.pGj;
                  str = coX();
                  if ((localObject2 != null) && (!((WebView)localObject2).isSysKernel())) {
                    break;
                  }
                }
                if (!getIntent().getBooleanExtra("forceHideShare", false)) {
                  break label1740;
                }
                zj(false);
                Log.d("MicroMsg.WebViewUI", "[hakon] postBinded :%d: force hide", new Object[] { Long.valueOf(System.currentTimeMillis()) });
                this.Jib = LayoutInflater.from(this).inflate(2131497055, null);
                localObject1 = (FontChooserView)this.Jib.findViewById(2131301659);
                localObject2 = this.Jib.findViewById(2131301658);
                if ((this.pGj == null) || (!this.pGj.getIsX5Kernel())) {
                  break label1792;
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
                      localb.bm(paramAnonymousView);
                      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                      paramAnonymousView = AnimationUtils.loadAnimation(WebViewUI.this, 2130772072);
                      paramAnonymousView.setAnimationListener(new Animation.AnimationListener()
                      {
                        public final void onAnimationEnd(Animation paramAnonymous2Animation)
                        {
                          AppMethodBeat.i(211122);
                          WebViewUI.this.Jib.setVisibility(8);
                          AppMethodBeat.o(211122);
                        }
                        
                        public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                        
                        public final void onAnimationStart(Animation paramAnonymous2Animation) {}
                      });
                      WebViewUI.this.Jib.startAnimation(paramAnonymousView);
                      WebViewUI.this.Jib.setVisibility(8);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(80093);
                    }
                  });
                }
                ((FontChooserView)localObject1).setOnChangeListener(new d((byte)0));
                localObject2 = new FrameLayout.LayoutParams(-1, -2, 80);
                this.Jib.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                this.Jid.addView(this.Jib);
                this.Jib.setVisibility(8);
                try
                {
                  if (!this.mHh.gdW()) {
                    break label1845;
                  }
                  if ((!gfO()) && (!gfP())) {
                    break label1797;
                  }
                  i = com.tencent.mm.plugin.webview.k.f.id(getContext());
                }
                catch (Exception localException7)
                {
                  for (;;)
                  {
                    BallInfo localBallInfo;
                    Bundle localBundle;
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
                    break label1850;
                  }
                  j = k;
                }
                ((FontChooserView)localObject1).setSliderIndex(j - 1);
                this.IMH.afK(j);
                agP(j);
                AppMethodBeat.o(80295);
                return;
                localRemoteException = localRemoteException;
                Log.printErrStackTrace("MicroMsg.WebViewUI", localRemoteException, "addCallbacker", new Object[0]);
                continue;
                this.Jjt.G(2, com.tencent.mm.plugin.ball.f.b.bxa(coX()));
                continue;
                label1247:
                this.Jju.G(2, com.tencent.mm.plugin.multitask.g.aGG(((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahz(coX())));
                continue;
                label1279:
                i = 0;
                continue;
                label1284:
                if (this.Jjt != null)
                {
                  localBallInfo = this.Jjt.cim();
                  if (localBallInfo != null)
                  {
                    localObject2 = localBallInfo.name;
                    if (!Util.isNullOrNil((String)localObject2)) {
                      this.Jjs.setTitle((String)localObject2);
                    }
                    this.Jjs.setIcon(Util.nullAsNil(localBallInfo.icon));
                    continue;
                    label1347:
                    ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).a(this.Jjs);
                    Log.i("MicroMsg.WebViewUI", "[Handoff] onPostBinded, exist:false, call onWebViewCreate " + this.Jjs.toString());
                    continue;
                    bool = str.equalsIgnoreCase("1");
                    continue;
                    localException1 = localException1;
                    Log.e("MicroMsg.DNSPreGetOptimize", "get dns pre get switch failed");
                    continue;
                    try
                    {
                      label1424:
                      localObject2 = ((com.tencent.mm.plugin.webview.stub.e)localObject2).aZV("DNSAdvanceRelateDomain");
                      if (!Util.isNullOrNil((String)localObject2)) {
                        break label1476;
                      }
                      Log.e("MicroMsg.DNSPreGetOptimize", "domain list is null, just return");
                    }
                    catch (Exception localException2)
                    {
                      Log.printErrStackTrace("MicroMsg.DNSPreGetOptimize", localException2, "", new Object[0]);
                    }
                    continue;
                    label1476:
                    com.tencent.mm.plugin.webview.a.a.aj(new com.tencent.mm.plugin.webview.model.b.1(localException2, (String)localObject2));
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
              bool = false;
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
                localBundle.putString("translateTips", getString(2131768601));
                localBundle.putString("translateFinish", getString(2131768598));
                localBundle.putString("errorWording", getString(2131768597));
                localException5.IJy = getString(2131768601);
                localException5.IJz = getString(2131768602);
                EventCenter.instance.addListener(localException5.IJD);
                try
                {
                  ((WebView)localObject2).invokeMiscMethod("translateWebSite", localBundle);
                }
                catch (Exception localException6)
                {
                  Log.e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", new Object[] { localException6.getMessage() });
                }
                continue;
                label1740:
                boolean bool = getIntent().getBooleanExtra("showShare", true);
                zj(bool);
                Log.d("MicroMsg.WebViewUI", "[cpan] postBinded :%d: show:%b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(bool) });
                continue;
                label1792:
                i = 0;
                continue;
                label1797:
                i = com.tencent.mm.plugin.webview.k.f.a(getContext(), this.mHh, coX());
              }
            }
          }
        }
      }
    }
  }
  
  protected int bXh()
  {
    AppMethodBeat.i(80254);
    int i = getActionbarColor();
    AppMethodBeat.o(80254);
    return i;
  }
  
  protected boolean bXi()
  {
    return false;
  }
  
  protected void ba(Bundle paramBundle) {}
  
  public final void ban(String paramString)
  {
    AppMethodBeat.i(80306);
    this.Jjm.ban(paramString);
    AppMethodBeat.o(80306);
  }
  
  public final void bas(String paramString)
  {
    AppMethodBeat.i(80317);
    this.IBw.cL("profile", true);
    this.IBw.aYf(paramString);
    AppMethodBeat.o(80317);
  }
  
  protected void bb(Bundle paramBundle)
  {
    AppMethodBeat.i(80220);
    int i;
    if (paramBundle.getBoolean("set_navigation_bar_color_reset", false)) {
      if (this.ILE == null) {
        i = getResources().getColor(2131101404);
      }
    }
    for (int j = 255;; j = paramBundle.getInt("set_navigation_bar_color_alpha"))
    {
      setActionbarColor(i & 0xFFFFFF | j << 24);
      AppMethodBeat.o(80220);
      return;
      i = this.ILE.ggj();
      break;
      i = paramBundle.getInt("set_navigation_bar_color_color");
    }
  }
  
  public final void bt(int paramInt, boolean paramBoolean)
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
        i = e.agC(paramInt);
      }
      setStatusBarColor(i);
    }
    AppMethodBeat.o(80257);
  }
  
  public final void c(com.tencent.luggage.xweb_ext.extendplugin.a.a parama)
  {
    AppMethodBeat.i(211160);
    this.ILF.c(parama);
    AppMethodBeat.o(211160);
  }
  
  public final void cjP()
  {
    AppMethodBeat.i(80302);
    this.Jjm.cjP();
    AppMethodBeat.o(80302);
  }
  
  public final String coX()
  {
    AppMethodBeat.i(80300);
    try
    {
      String str = BaseWebViewController.bj(getIntent());
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
  
  public boolean convertActivityFromTranslucent()
  {
    AppMethodBeat.i(80236);
    Intent localIntent = getIntent();
    Object localObject = com.tencent.mm.plugin.webview.core.g.ILB;
    localObject = com.tencent.mm.plugin.webview.core.g.gWQ();
    g.a locala = com.tencent.mm.plugin.webview.core.g.ILB;
    if (!((Boolean)((kotlin.f)localObject).getValue()).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      bool = localIntent.getBooleanExtra("convertActivityFromTranslucent", bool);
      AppMethodBeat.o(80236);
      return bool;
    }
  }
  
  protected void cpA()
  {
    AppMethodBeat.i(80247);
    Log.i("MicroMsg.WebViewUI", "onCreate" + hashCode());
    this.ISw = new m(this);
    this.Jjl = new i(this);
    this.JjM = true;
    this.Jiy = getIntent().getIntExtra("geta8key_session_id", (int)System.currentTimeMillis());
    this.Jiz = getIntent().getByteArrayExtra("geta8key_cookie");
    com.tencent.mm.plugin.webview.k.k.j(coX(), this);
    this.Jin = coX();
    this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
    this.Jix = getIntent().getBooleanExtra("from_shortcut", false);
    this.Jit = getIntent().getIntExtra(e.p.OzA, -1);
    this.xPq = getIntent().getStringExtra("status_bar_style");
    this.xPp = getIntent().getIntExtra("customize_status_bar_color", 0);
    this.JiY = getIntent().getBooleanExtra("show_native_web_view", false);
    Object localObject1;
    if (getIntent() == null) {
      localObject1 = "";
    }
    for (;;)
    {
      boolean bool;
      if (getIntent() == null)
      {
        bool = false;
        label219:
        Log.i("MicroMsg.WebViewUI", "initCustomActionBarColorIfNeed isNativeStyle is %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label1612;
        }
        if (!ao.isDarkMode()) {
          break label1597;
        }
        localObject1 = "black";
        agM(2131099650);
      }
      try
      {
        label261:
        i = Color.parseColor((String)localObject1);
        localObject1 = Integer.valueOf(i);
        label273:
        if (localObject1 != null)
        {
          localObject3 = new Bundle(1);
          ((Bundle)localObject3).putInt("set_navigation_bar_color_color", ((Integer)localObject1).intValue());
          ((Bundle)localObject3).putInt("set_navigation_bar_color_alpha", 255);
          bb((Bundle)localObject3);
          if (!getIntent().hasExtra("customize_status_bar_color")) {
            this.xPp = ((Integer)localObject1).intValue();
          }
        }
        label340:
        this.JiY = getIntent().getBooleanExtra("show_native_web_view", false);
        this.Jim = getIntent().getBooleanExtra("key_trust_url", false);
        Jjc += 1;
        Log.i("MicroMsg.WebViewUI", "initView trust:%b, rawUrl = %s ", new Object[] { Boolean.valueOf(this.Jim), coX() });
        this.eam = Util.nullAsNil(getIntent().getStringExtra("KPublisherId"));
        this.handler = new MMHandler();
        if ((this.IMs != null) && (this.IMs.aO(getIntent().getBundleExtra("mm_report_bundle"))))
        {
          bool = true;
          label465:
          this.Jir = bool;
          localObject1 = getIntent().getBundleExtra("close_window_confirm_info");
          if (localObject1 != null) {
            this.JiQ = a.bc((Bundle)localObject1);
          }
          getWindow().setFlags(16777216, 16777216);
          getWindow().setFormat(-3);
          com.tencent.mm.pluginsdk.model.x.a.iq(this);
          this.Jji.bN("onWebViewCreateStart", System.currentTimeMillis());
          if (!com.tencent.mm.plugin.webview.k.k.bbp(coX())) {
            break label1636;
          }
          this.pGj = MMWebView.a.kK(this);
          com.tencent.xweb.util.h.OQ(173L);
          if (this.pGj == null) {
            this.pGj = cpy();
          }
          label574:
          i.f(this.pGj);
          this.Jji.bN("onWebViewCreateEnd", System.currentTimeMillis());
          this.pGj.QDX = this;
          this.Jjp = new com.tencent.mm.plugin.webview.c();
          initView();
          this.IMH = cpO();
          if (this.IMH.ILE == null) {
            break label1647;
          }
          this.ILE = this.IMH.ILE;
          this.ILE.Jkg = this;
          label654:
          this.IBw = this.IMH.getJsapi();
          this.mHi = this.IMH.mHi;
          if (com.tencent.mm.plugin.webview.ui.tools.floatball.d.ggy()) {
            getIntent().putExtra("webviewCurrentProcess", MMApplicationContext.getProcessName());
          }
          if (this.IBw != null) {
            this.IBw.yW(false);
          }
          if (this.IMH.ILD == null) {
            break label1731;
          }
          this.Jjm = this.IMH.ILD;
          this.Jjm.Jbp = new WeakReference(this);
          label747:
          if (this.IMH.ILF == null) {
            break label1864;
          }
          this.ILF = this.IMH.ILF;
          localObject1 = this.ILF;
          kotlin.g.b.p.h(this, "ct");
          ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h)localObject1).context = this;
          localObject1 = ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h)localObject1).JxV;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.webview.ui.tools.video.b)localObject1).mContext = this;
          }
          label805:
          if (!this.JiL) {
            break label1878;
          }
          this.IMH.fZC();
          com.tencent.f.h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(211126);
              WebViewUI.this.IMH.a(WebViewUI.this.JjS);
              WebViewUI.a(WebViewUI.this);
              AppMethodBeat.o(211126);
            }
          });
          label836:
          if (this.IMs != this.IMH.IMs)
          {
            this.IMs = this.IMH.IMs;
            this.IMs.aO(getIntent().getBundleExtra("mm_report_bundle"));
          }
          localObject1 = this.IMs.gcY();
          i = this.IMH.bLC();
          localObject3 = this.eam;
          ((az.l)localObject1).ehX = i;
          ((az.l)localObject1).Jak = ((String)localObject3);
          JiD.add(new e(this));
          if (JiD.size() > 1)
          {
            localObject1 = JiD;
            localObject1 = (e)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 2);
            if ((((e)localObject1).nhy != null) && (((e)localObject1).nhy.get() != null)) {
              ((WebViewUI)((e)localObject1).nhy.get()).yY(false);
            }
          }
          aYq("onCreate");
          j = getIntent().getIntExtra("from_scence", 0);
          this.Jis = getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
          localObject1 = this.Jji;
          i = this.Jis;
          if (i == -1) {
            break label1892;
          }
          ((com.tencent.mm.plugin.webview.k.j)localObject1).Jis = i;
          Log.d("MicroMsg.WebViewUI", " onCreate fromScene %d", new Object[] { Integer.valueOf(j) });
          this.sessionId = ad.JX(String.valueOf(this.IMH.fZu()));
          Log.i("MicroMsg.WebViewUI", " onCreate sessionId %s", new Object[] { this.sessionId });
          localObject1 = this.IMs.gde();
          i = this.IMH.bLC();
          localObject3 = this.eam;
          ((az.f)localObject1).ehX = i;
          ((az.f)localObject1).Jak = ((String)localObject3);
          ((az.f)localObject1).url = coX();
          localObject3 = this.IMs.gdk();
          localObject1 = coX();
          Log.i("MicroMsg.WebviewReporter.DomainReporter", "setRawUrl, value = %s", new Object[] { localObject1 });
        }
      }
      catch (Exception localException2)
      {
        try
        {
          localObject4 = Uri.parse((String)localObject1);
          if ((((Uri)localObject4).getScheme() != null) && (!((Uri)localObject4).getScheme().toLowerCase().startsWith("http"))) {
            Log.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl scheme is not http/https, skip, scheme = %s", new Object[] { ((Uri)localObject4).getScheme() });
          }
        }
        catch (Exception localException2)
        {
          try
          {
            label1240:
            this.JjE = getContentView();
            if (this.JjE != null)
            {
              gfn();
              ((ViewGroup)((ViewGroup)getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
              {
                public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
                {
                  AppMethodBeat.i(80115);
                  WebViewUI.this.gfn();
                  AppMethodBeat.o(80115);
                }
              });
            }
          }
          catch (Exception localException2)
          {
            try
            {
              int i;
              Object localObject3;
              int j;
              Object localObject4;
              label1287:
              if (this.JiV) {
                if (gfq()) {
                  gfs();
                }
              }
              for (;;)
              {
                this.Jii = new com.tencent.mm.bo.a(getContext(), this.JjG);
                com.tencent.mm.plugin.webview.a.a.aj(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(211128);
                    com.tencent.mm.ce.f.gxT();
                    com.tencent.mm.ce.b.gxI();
                    AppMethodBeat.o(211128);
                  }
                });
                this.Jjo = new WebViewClipBoardHelper(this);
                this.Jjx.alive();
                this.JiJ.alive();
                if (this.ILE != null)
                {
                  localObject1 = this.ILE;
                  if (((o)localObject1).Jkg != null)
                  {
                    ((o)localObject1).nKc = ((o)localObject1).Jkg.fZM();
                    ((o)localObject1).webView = ((o)localObject1).Jkg.pGj;
                    if (!((o)localObject1).Jkf) {
                      break label2132;
                    }
                    Log.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle true");
                  }
                }
                aC(getWindow().getDecorView(), 256);
                az.Md(getIntent().getLongExtra("start_activity_time", 0L));
                this.Jjv = getIntent().getBooleanExtra(e.p.OzJ, false);
                if (((this.Jjv) || (gfm())) && (this.pGj != null)) {
                  this.pGj.getSettings().setForceDarkBehavior(1);
                }
                localObject1 = getIntent().getStringExtra("key_first_tips");
                localObject3 = getIntent().getStringExtra("key_first_tips_title");
                if (!Util.isNullOrNil((String)localObject1)) {
                  com.tencent.mm.ui.base.h.a(getContext(), (String)localObject1, (String)localObject3, getString(2131755874), false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
                  });
                }
                AppMethodBeat.o(80247);
                return;
                localObject1 = getIntent().getStringExtra("custom_action_bar_color");
                break;
                bool = getIntent().getBooleanExtra("open_custom_style_url", false);
                break label219;
                label1597:
                localObject1 = "white";
                agM(-16777216);
                break label261;
                label1612:
                if (Util.isNullOrNil((String)localObject1)) {
                  break label340;
                }
                break label261;
                localException1 = localException1;
                Object localObject2 = null;
                break label273;
                bool = false;
                break label465;
                label1636:
                this.pGj = cpy();
                break label574;
                label1647:
                this.ILE = new o(this);
                localObject2 = this.ILE;
                if (((o)localObject2).Jkg == null) {
                  break label654;
                }
                if (((o)localObject2).ggd()) {}
                for (((o)localObject2).Jkf = true;; ((o)localObject2).Jkf = false)
                {
                  Log.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleParams, webViewUI#%s, disableLightActionbarStyle:%b", new Object[] { ((o)localObject2).Jkg, Boolean.valueOf(((o)localObject2).Jkf) });
                  break;
                }
                label1731:
                this.Jjm = new j(this);
                this.IMH.ILD = this.Jjm;
                this.Jjm.geK();
                localObject2 = this.Jjm;
                if ((((j)localObject2).geo() instanceof GameWebViewUI))
                {
                  ((j)localObject2).Jgt.add(Integer.valueOf(11));
                  ((j)localObject2).Jgt.add(Integer.valueOf(28));
                  break label747;
                }
                ((j)localObject2).Jgt.add(Integer.valueOf(7));
                ((j)localObject2).Jgt.add(Integer.valueOf(11));
                ((j)localObject2).Jgt.add(Integer.valueOf(28));
                break label747;
                label1864:
                this.IMH.ILF = this.ILF;
                break label805;
                label1878:
                this.IMH.aB(getIntent());
                break label836;
                switch (j)
                {
                default: 
                  label1892:
                  i = 999;
                }
                for (;;)
                {
                  ((com.tencent.mm.plugin.webview.k.j)localObject2).Jis = i;
                  break;
                  i = 1;
                  continue;
                  i = 2;
                }
                localObject4 = ((Uri)localObject4).getHost();
                if ((localObject4 == null) || (((String)localObject4).toLowerCase().endsWith(".qq.com")))
                {
                  Log.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl, host is .qq.com, skip, host = %s", new Object[] { localObject4 });
                  break label1240;
                  localException4 = localException4;
                  Log.e("MicroMsg.WebviewReporter.DomainReporter", "parse rawUrl fail, rawUrl = %s", new Object[] { localObject2 });
                  break label1240;
                }
                localException4.thE = true;
                break label1240;
                localException2 = localException2;
                Log.e("MicroMsg.WebViewUI", "fixContentMargin error : %s", new Object[] { localException2.getMessage() });
                break label1287;
                if (!com.tencent.mm.compatible.util.d.oD(21)) {
                  break label2115;
                }
                final ViewGroup localViewGroup = (ViewGroup)((ViewGroup)getWindow().getDecorView()).getChildAt(0);
                localViewGroup.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
                {
                  public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
                  {
                    AppMethodBeat.i(80116);
                    WebViewUI.this.a(localViewGroup, paramAnonymousWindowInsets);
                    WebViewUI.b(WebViewUI.this);
                    paramAnonymousView = paramAnonymousWindowInsets.consumeSystemWindowInsets();
                    AppMethodBeat.o(80116);
                    return paramAnonymousView;
                  }
                });
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                Log.e("MicroMsg.WebViewUI", "tryToExpandToStatusBar error : %s", new Object[] { localException3.getMessage() });
                continue;
                label2115:
                ((ViewGroup)getWindow().getDecorView()).setFitsSystemWindows(true);
                continue;
                label2132:
                Log.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle false");
                localException3.gge();
              }
            }
          }
        }
      }
    }
  }
  
  protected boolean cpC()
  {
    AppMethodBeat.i(80320);
    if (this.Jip)
    {
      AppMethodBeat.o(80320);
      return true;
    }
    if ((this.pGj != null) && ((this.pGj.canGoBack()) || (this.pGj.canGoForward())) && (this.JhY != null))
    {
      Object localObject1 = this.JhY;
      boolean bool;
      if (((h)localObject1).JfD != null)
      {
        localObject1 = ((h)localObject1).JfD;
        if (localObject1 == null) {
          kotlin.g.b.p.hyc();
        }
        bool = ((Boolean)localObject1).booleanValue();
      }
      while (bool)
      {
        this.Jio = false;
        this.Jip = true;
        AppMethodBeat.o(80320);
        return true;
        Object localObject2 = MultiProcessMMKV.getMMKV("WebViewUIShowBottom");
        if (localObject2 == null) {
          kotlin.g.b.p.hyc();
        }
        if (((MultiProcessMMKV)localObject2).decodeInt("WebViewUIShowBottomNav", 0) == 1)
        {
          ((h)localObject1).JfD = Boolean.TRUE;
          localObject1 = ((h)localObject1).JfD;
          if (localObject1 == null) {
            kotlin.g.b.p.hyc();
          }
          bool = ((Boolean)localObject1).booleanValue();
        }
        else
        {
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rSF, 0) == 1) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label231;
            }
            Log.i(h.TAG, "needShowBottomNavigator not open");
            ((h)localObject1).JfD = Boolean.FALSE;
            localObject1 = ((h)localObject1).JfD;
            if (localObject1 == null) {
              kotlin.g.b.p.hyc();
            }
            bool = ((Boolean)localObject1).booleanValue();
            break;
          }
          label231:
          localObject2 = MMApplicationContext.getContext();
          kotlin.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
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
              localObject2 = MMApplicationContext.getContext();
              kotlin.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
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
                localObject2 = MMApplicationContext.getContext();
                kotlin.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
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
                  localObject2 = MMApplicationContext.getContext();
                  kotlin.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
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
            ((h)localObject1).JfD = Boolean.valueOf(bool);
            Log.i(h.TAG, "needShowBottomNavigator deviceShowBottomNav %b", new Object[] { ((h)localObject1).JfD });
            localObject2 = ((h)localObject1).JfD;
            if (localObject2 == null) {
              kotlin.g.b.p.hyc();
            }
            if (!((Boolean)localObject2).booleanValue()) {
              break label796;
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(18210, new Object[] { Integer.valueOf(1) });
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1160L, 0L, 1L, false);
          }
          for (;;)
          {
            localObject1 = ((h)localObject1).JfD;
            if (localObject1 == null) {
              kotlin.g.b.p.hyc();
            }
            bool = ((Boolean)localObject1).booleanValue();
            break;
            i = 0;
            break label261;
            label501:
            localObject2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
            bool = h.a.eB((Context)localObject2);
            Log.i(h.TAG, "miui hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
            break label267;
            label543:
            i = 0;
            break label301;
            label548:
            localObject2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
            bool = h.a.hW((Context)localObject2);
            Log.i(h.TAG, "huawei hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
            break label307;
            label590:
            i = 0;
            break label342;
            label595:
            localObject2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
            bool = h.a.hW((Context)localObject2);
            Log.i(h.TAG, "oppo hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
            break label348;
            label637:
            i = 0;
            break label382;
            label642:
            localObject2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
            if (Settings.Secure.getInt(((Context)localObject2).getContentResolver(), "navigation_gesture_mode", 0) == 1) {}
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label719;
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(18210, new Object[] { Integer.valueOf(0) });
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1160L, 1L, 1L, false);
              bool = false;
              break;
            }
            label719:
            localObject2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
            if (!h.a.eB((Context)localObject2))
            {
              localObject2 = MMApplicationContext.getContext();
              kotlin.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
              if (!h.a.hW((Context)localObject2)) {
                break label786;
              }
            }
            label786:
            for (bool = true;; bool = false)
            {
              Log.i(h.TAG, "vivo hasNavigationBar %b", new Object[] { Boolean.valueOf(bool) });
              break;
            }
            label791:
            bool = false;
            break label394;
            label796:
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1160L, 2L, 1L, false);
          }
        }
      }
    }
    AppMethodBeat.o(80320);
    return false;
  }
  
  public void cpD()
  {
    AppMethodBeat.i(80303);
    this.Jjm.cpD();
    AppMethodBeat.o(80303);
  }
  
  protected void cpE()
  {
    AppMethodBeat.i(80341);
    this.Jjm.cpE();
    AppMethodBeat.o(80341);
  }
  
  public boolean cpI()
  {
    return false;
  }
  
  protected com.tencent.mm.plugin.webview.core.i cpO()
  {
    AppMethodBeat.i(211167);
    if (com.tencent.mm.plugin.webview.ui.tools.floatball.d.ggy())
    {
      localObject1 = getIntent().getStringExtra("float_ball_key");
      if (!Util.isNullOrNil((String)localObject1))
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1553L, 1L, 1L, false);
        localObject2 = com.tencent.mm.plugin.webview.ui.tools.floatball.d.JmQ;
        localObject2 = com.tencent.mm.plugin.webview.ui.tools.floatball.d.baD((String)localObject1);
        if ((localObject2 != null) && (((BaseWebViewController)localObject2).pGj != null) && (!((BaseWebViewController)localObject2).pGj.mDestroyed))
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1553L, 2L, 1L, false);
          this.JiL = true;
          Log.i("MicroMsg.WebViewUI", "createWebViewController from cache floatBallKey=%s", new Object[] { localObject1 });
          AppMethodBeat.o(211167);
          return localObject2;
        }
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1553L, 3L, 1L, false);
      }
    }
    Object localObject1 = this.pGj;
    Object localObject2 = this.IMs;
    BaseWebViewController.f localf = new BaseWebViewController.f(getIntent());
    boolean bool2 = getIntent().getBooleanExtra("key_trust_url", false);
    boolean bool3 = gfT();
    if ((!gfO()) && (!gfP())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = new com.tencent.mm.plugin.webview.core.i((MMWebView)localObject1, (az)localObject2, new BaseWebViewController.c(localf, bool2, bool3, bool1, getIntent().getBooleanExtra("neverGetA8Key", false)), (byte)0);
      ((com.tencent.mm.plugin.webview.core.i)localObject1).a(this.JjS);
      ((com.tencent.mm.plugin.webview.core.i)localObject1).init();
      AppMethodBeat.o(211167);
      return localObject1;
    }
  }
  
  public boolean cpP()
  {
    return false;
  }
  
  protected MMWebView cpy()
  {
    AppMethodBeat.i(80260);
    if (com.tencent.mm.plugin.webview.ui.tools.floatball.d.ggy())
    {
      localObject1 = getIntent().getStringExtra("float_ball_key");
      if (!Util.isNullOrNil((String)localObject1))
      {
        Object localObject2 = com.tencent.mm.plugin.webview.ui.tools.floatball.d.JmQ;
        localObject2 = com.tencent.mm.plugin.webview.ui.tools.floatball.d.baD((String)localObject1);
        if (localObject2 != null)
        {
          localObject2 = ((BaseWebViewController)localObject2).pGj;
          if ((localObject2 != null) && (!((MMWebView)localObject2).mDestroyed))
          {
            Log.i("MicroMsg.WebViewUI", "createWebView from cache floatBallKey=%s", new Object[] { localObject1 });
            if (((MMWebView)localObject2).getParent() != null)
            {
              ((ViewGroup)((MMWebView)localObject2).getParent()).removeView((View)localObject2);
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1553L, 21L, 1L, false);
              Log.w("MicroMsg.WebViewUI", "createWebView wv has parent");
            }
            ((MMWebView)localObject2).aG(this);
            ((MMWebView)localObject2).onShow();
            AppMethodBeat.o(80260);
            return localObject2;
          }
        }
      }
      localObject1 = MMWebView.a.kL(new MutableContextWrapper(this));
      AppMethodBeat.o(80260);
      return localObject1;
    }
    Object localObject1 = MMWebView.a.kL(this);
    AppMethodBeat.o(80260);
    return localObject1;
  }
  
  protected boolean cpz()
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
  
  protected void cqh()
  {
    AppMethodBeat.i(80246);
    if (this.JiV) {
      fixStatusbar(false);
    }
    AppMethodBeat.o(80246);
  }
  
  public void cqk()
  {
    AppMethodBeat.i(80226);
    this.Jjy.giy();
    int i = getIntent().getIntExtra(e.p.OzA, -1);
    getIntent().getIntExtra(e.p.Ozv, 0);
    int j = getIntent().getIntExtra(e.p.Ozw, -1);
    int k = getIntent().getIntExtra(e.p.Ozx, -1);
    this.Jjy.a(j, k, i, 0, coX(), getTitle().toString());
    AppMethodBeat.o(80226);
  }
  
  public final void d(com.tencent.luggage.xweb_ext.extendplugin.a.a parama)
  {
    AppMethodBeat.i(211161);
    this.ILF.d(parama);
    AppMethodBeat.o(211161);
  }
  
  public final String ePp()
  {
    return this.IMH.IJP;
  }
  
  public final void fTu()
  {
    AppMethodBeat.i(211178);
    if (this.Jic != null)
    {
      hideVKB();
      this.Jic.Ns(-2);
    }
    AppMethodBeat.o(211178);
  }
  
  public final String fZM()
  {
    AppMethodBeat.i(258621);
    String str = this.IMH.getCurrentUrl();
    AppMethodBeat.o(258621);
    return str;
  }
  
  protected final boolean fZV()
  {
    AppMethodBeat.i(80308);
    boolean bool = this.IMH.fZV();
    AppMethodBeat.o(80308);
    return bool;
  }
  
  public final int fZu()
  {
    AppMethodBeat.i(258620);
    int i = this.IMH.fZu();
    AppMethodBeat.o(258620);
    return i;
  }
  
  public void finish()
  {
    int i = 1;
    AppMethodBeat.i(80235);
    if (this.Jiu) {
      setResult(-1);
    }
    if (this.handler != null) {
      this.handler.removeCallbacksAndMessages(null);
    }
    this.Jje = true;
    if ((com.tencent.mm.plugin.webview.ui.tools.floatball.d.ggy()) && (this.mHh != null) && (this.Jju != null) && (this.Jju.eqW())) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.IMH != null)
      {
        com.tencent.mm.plugin.webview.core.i locali = this.IMH;
        locali.yR(bool);
        locali.IJT = true;
      }
      if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.d.c.class) != null) {
        ((com.tencent.mm.plugin.appbrand.d.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.d.c.class)).bzB();
      }
      super.finish();
      if ((this.Jju != null) && (this.Jju.eqZ())) {}
      for (;;)
      {
        if ((ao.gJN()) && (i == 0)) {
          overridePendingTransition(0, MMFragmentActivity.a.OHE);
        }
        AppMethodBeat.o(80235);
        return;
        i = 0;
      }
    }
  }
  
  public final com.tencent.mm.plugin.webview.d.b.a gaW()
  {
    AppMethodBeat.i(211182);
    if (this.IBw != null)
    {
      locala = this.IBw.gaW();
      AppMethodBeat.o(211182);
      return locala;
    }
    com.tencent.mm.plugin.webview.d.b.a locala = new com.tencent.mm.plugin.webview.d.b.a();
    AppMethodBeat.o(211182);
    return locala;
  }
  
  public final boolean gbB()
  {
    AppMethodBeat.i(80354);
    if ((this.JiQ != null) && (this.JiQ.gci()) && (!Util.isNullOrNil(this.JiQ.ggc())) && (!Util.isNullOrNil(this.JiQ.gck())) && (!Util.isNullOrNil(this.JiQ.gcl())))
    {
      Object localObject = this.JiQ.ggc();
      String str1 = this.JiQ.gck();
      String str2 = this.JiQ.gcl();
      Log.i("MicroMsg.WebViewUI", "use js api close window confirm info : %s, %s, %s", new Object[] { localObject, str1, str2 });
      View localView = View.inflate(getContext(), 2131495497, null);
      final CheckBox localCheckBox = (CheckBox)localView.findViewById(2131304698);
      localCheckBox.setChecked(false);
      localCheckBox.setVisibility(8);
      TextView localTextView = (TextView)localView.findViewById(2131304700);
      localTextView.setText((CharSequence)localObject);
      localTextView.setTextColor(getResources().getColor(2131100904));
      localObject = (TextView)localView.findViewById(2131304699);
      ((TextView)localObject).setTextColor(getResources().getColor(2131100904));
      ((TextView)localObject).setVisibility(8);
      this.JiR = com.tencent.mm.ui.base.h.a(getContext(), true, "", localView, str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(211123);
          if ((localCheckBox != null) && (localCheckBox.isChecked())) {}
          try
          {
            if (WebViewUI.this.mHh.gdW()) {
              WebViewUI.this.mHh.km(327792, 1);
            }
            WebViewUI.this.Jjd = true;
            WebViewUI.this.JiR = null;
            l.Jhd.close();
            if ((WebViewUI.x(WebViewUI.this) != null) && (WebViewUI.x(WebViewUI.this).wu(1)))
            {
              AppMethodBeat.o(211123);
              return;
            }
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            for (;;)
            {
              Log.e("MicroMsg.WebViewUI", "tryShowCloseWindowConfirmInfo, ex = " + paramAnonymousDialogInterface.getMessage());
            }
            if ((WebViewUI.w(WebViewUI.this) != null) && (WebViewUI.w(WebViewUI.this).wu(1)))
            {
              AppMethodBeat.o(211123);
              return;
            }
            WebViewUI.this.finish();
            AppMethodBeat.o(211123);
          }
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          WebViewUI.this.JiR = null;
        }
      });
      AppMethodBeat.o(80354);
      return true;
    }
    AppMethodBeat.o(80354);
    return false;
  }
  
  public final boolean gbH()
  {
    AppMethodBeat.i(80364);
    boolean bool1 = getIntent().getBooleanExtra("forceHideShare", false);
    boolean bool2 = getIntent().getBooleanExtra("showShare", true);
    boolean bool3 = getIntent().getBooleanExtra("KRightBtn", false);
    Log.i("MicroMsg.WebViewUI", "forceHideShare:%b showShareBtn:%b enableMinimize:%b, banRightBtn %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(cpz()), Boolean.valueOf(bool3) });
    if ((!bool3) && (!bool1) && (bool2) && (cpz()))
    {
      AppMethodBeat.o(80364);
      return true;
    }
    AppMethodBeat.o(80364);
    return false;
  }
  
  public final void gdM()
  {
    AppMethodBeat.i(80228);
    if (this.Jjy != null)
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n localn = this.Jjy;
      localn.hide();
      localn.Jzk.setText((CharSequence)"");
    }
    AppMethodBeat.o(80228);
  }
  
  protected void geA()
  {
    AppMethodBeat.i(80278);
    int i = getIntent().getIntExtra("webview_bg_color_rsID", -1);
    if ((i != -1) && (getContentView() != null))
    {
      setBackGroundColorResource(i);
      getContentView().setBackgroundResource(i);
      this.pGj.setBackgroundResource(17170445);
      this.Jic.setBackgroundResource(17170445);
      this.Jid.setBackgroundResource(17170445);
      AppMethodBeat.o(80278);
      return;
    }
    if (getIntent().getBooleanExtra(e.p.OzJ, false))
    {
      this.pGj.setBackgroundColor(getResources().getColor(2131099844));
      AppMethodBeat.o(80278);
      return;
    }
    this.pGj.setBackgroundColor(getResources().getColor(2131101424));
    AppMethodBeat.o(80278);
  }
  
  public final void geP()
  {
    AppMethodBeat.i(80305);
    this.Jjm.geP();
    AppMethodBeat.o(80305);
  }
  
  public final int geT()
  {
    AppMethodBeat.i(211185);
    int i = this.Jjm.geT();
    AppMethodBeat.o(211185);
    return i;
  }
  
  protected final int getActionBarHeight()
  {
    AppMethodBeat.i(80250);
    if (getResources().getDimensionPixelSize(2131167159) > com.tencent.mm.cb.a.fromDPToPix(this, 48))
    {
      i = getResources().getDimensionPixelSize(2131167159);
      AppMethodBeat.o(80250);
      return i;
    }
    if (com.tencent.mm.compatible.util.i.isPortOrientation(this))
    {
      i = getResources().getDimensionPixelSize(2131165256);
      AppMethodBeat.o(80250);
      return i;
    }
    int i = getResources().getDimensionPixelSize(2131165255);
    AppMethodBeat.o(80250);
    return i;
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(211171);
    if (this.ILF.bJb())
    {
      i = getRequestedOrientation();
      AppMethodBeat.o(211171);
      return i;
    }
    int i = this.screenOrientation;
    AppMethodBeat.o(211171);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131497063;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(211170);
    String str = this.IMH.pGj.getSettings().getUserAgentString();
    AppMethodBeat.o(211170);
    return str;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    AppMethodBeat.i(211155);
    if (this.IMH != null)
    {
      com.tencent.luggage.xweb_ext.extendplugin.b.c localc = this.IMH.getWebViewPluginClientProxy();
      AppMethodBeat.o(211155);
      return localc;
    }
    AppMethodBeat.o(211155);
    return null;
  }
  
  protected void gfA()
  {
    AppMethodBeat.i(80279);
    if (getIntent() == null)
    {
      AppMethodBeat.o(80279);
      return;
    }
    if (getIntent().hasExtra("show_full_screen")) {
      aV(getIntent().getBooleanExtra("show_full_screen", false), true);
    }
    AppMethodBeat.o(80279);
  }
  
  public final boolean gfB()
  {
    AppMethodBeat.i(211175);
    if ((this.Jig) || (this.ILF.bJb()) || ((this.JjA != null) && (this.JjA.bJb())))
    {
      AppMethodBeat.o(211175);
      return true;
    }
    AppMethodBeat.o(211175);
    return false;
  }
  
  protected com.tencent.xweb.x gfC()
  {
    try
    {
      AppMethodBeat.i(80286);
      if (this.JiG == null) {
        this.JiG = new MMWebView.b(new b());
      }
      com.tencent.xweb.x localx = this.JiG;
      AppMethodBeat.o(80286);
      return localx;
    }
    finally {}
  }
  
  protected int gfD()
  {
    AppMethodBeat.i(80287);
    if (this.JiY)
    {
      AppMethodBeat.o(80287);
      return 2131689492;
    }
    AppMethodBeat.o(80287);
    return 2131689494;
  }
  
  protected boolean gfE()
  {
    return true;
  }
  
  public final void gfF()
  {
    AppMethodBeat.i(175800);
    View localView = this.pGj.getView();
    localView.scrollTo(localView.getScrollX(), 0);
    this.IMs.gdg().D(new Object[] { coX(), Integer.valueOf(7) }).report();
    AppMethodBeat.o(175800);
  }
  
  protected com.tencent.mm.plugin.webview.d.i gfG()
  {
    return null;
  }
  
  protected boolean gfH()
  {
    return false;
  }
  
  protected final void gfI()
  {
    AppMethodBeat.i(80304);
    if (this.ILF.bJb()) {
      this.ILF.zs(false);
    }
    if (this.IMH != null) {
      this.IMH.reload();
    }
    AppMethodBeat.o(80304);
  }
  
  protected final void gfJ()
  {
    AppMethodBeat.i(211177);
    if (this.IMH != null) {
      if (com.tencent.mm.plugin.webview.d.l.gbo()) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.webview.d.l.za(bool);
      this.IMH.reload();
      AppMethodBeat.o(211177);
      return;
    }
  }
  
  protected final LinkedList<e.a> gfK()
  {
    AppMethodBeat.i(80307);
    if (this.pGj == null)
    {
      Log.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
      AppMethodBeat.o(80307);
      return null;
    }
    Object localObject = coX();
    if (this.pGj != null)
    {
      String str = this.pGj.getUrl();
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
              if (this.JiZ == null)
              {
                l = System.currentTimeMillis();
                this.JiZ = this.mHh.geb();
                if (this.JiZ == null) {
                  break label281;
                }
              }
              label281:
              for (bool = true;; bool = false)
              {
                Log.d("MicroMsg.WebViewUI", "[hakon] getConfigListMap %b, cost %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
                if ((this.JiZ == null) || (this.JiZ.size() <= 0)) {
                  break;
                }
                localObject = com.tencent.mm.n.e.s(this.JiZ);
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
  
  protected final int gfL()
  {
    AppMethodBeat.i(80314);
    int i = 2131690843;
    if (gfK() != null) {
      i = 2131691095;
    }
    AppMethodBeat.o(80314);
    return i;
  }
  
  protected final void gfN()
  {
    AppMethodBeat.i(80344);
    this.JiS.setVisibility(0);
    AppMethodBeat.o(80344);
  }
  
  protected boolean gfO()
  {
    return false;
  }
  
  protected boolean gfP()
  {
    return false;
  }
  
  public void gfR()
  {
    AppMethodBeat.i(80356);
    if (gfQ())
    {
      AppMethodBeat.o(80356);
      return;
    }
    gfS();
    if (!gbB())
    {
      this.Jjd = true;
      l.Jhd.close();
      if ((this.Jju != null) && (this.Jju.wu(1)))
      {
        AppMethodBeat.o(80356);
        return;
      }
      if ((this.Jjt != null) && (this.Jjt.wu(1)))
      {
        AppMethodBeat.o(80356);
        return;
      }
      finish();
    }
    AppMethodBeat.o(80356);
  }
  
  protected boolean gfT()
  {
    return true;
  }
  
  protected final boolean gfU()
  {
    AppMethodBeat.i(80360);
    if (this.JjT != -3)
    {
      showVKB();
      AppMethodBeat.o(80360);
      return true;
    }
    AppMethodBeat.o(80360);
    return false;
  }
  
  protected final void gfV()
  {
    AppMethodBeat.i(211184);
    if ((this.Jjd) || (this.Jje) || (isFinishing()))
    {
      AppMethodBeat.o(211184);
      return;
    }
    if (this.IMH != null)
    {
      com.tencent.mm.plugin.webview.core.i locali = this.IMH;
      locali.k(locali.coX(), true, 8);
    }
    if (this.JiS != null) {
      this.JiS.setVisibility(8);
    }
    this.IMs.gdg().D(new Object[] { coX(), Integer.valueOf(4) }).report();
    AppMethodBeat.o(211184);
  }
  
  public final MMWebView gfW()
  {
    return this.pGj;
  }
  
  public final void gfX()
  {
    AppMethodBeat.i(211187);
    if (this.IMH != null)
    {
      Iterator localIterator = ((Iterable)this.IMH.ICu).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.webview.core.k)localIterator.next()).gag();
      }
    }
    AppMethodBeat.o(211187);
  }
  
  protected final boolean gfa()
  {
    return this.IMH.IKF;
  }
  
  protected final Map<String, String> gfb()
  {
    return this.IMH.IJX;
  }
  
  public final com.tencent.mm.plugin.webview.k.j gfc()
  {
    return this.Jji;
  }
  
  public final HandOffURL gfe()
  {
    return this.Jjs;
  }
  
  public final com.tencent.mm.plugin.webview.ui.tools.multitask.a gff()
  {
    return this.Jju;
  }
  
  protected final com.tencent.mm.plugin.webview.model.ar gfg()
  {
    return this.IMH.ILL;
  }
  
  protected final com.tencent.mm.plugin.webview.ui.tools.widget.n gfh()
  {
    AppMethodBeat.i(80223);
    if (this.Jjy == null)
    {
      this.Jjy = new com.tencent.mm.plugin.webview.ui.tools.widget.n(this, new u(getContext(), 2131820851));
      this.Jjy.setVisibility(8);
      localObject = (ViewParent)getWindow().getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        ((ViewGroup)localObject).addView(this.Jjy, new FrameLayout.LayoutParams(-1, -1));
        cqk();
      }
    }
    Object localObject = this.Jjy;
    AppMethodBeat.o(80223);
    return localObject;
  }
  
  public final MPVideoPlayFullScreenView gfi()
  {
    AppMethodBeat.i(80224);
    if (this.JjA == null)
    {
      this.JjA = new MPVideoPlayFullScreenView(this, null);
      this.JjA.setVisibility(8);
      localObject = (ViewParent)getWindow().getDecorView();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).addView(this.JjA, new FrameLayout.LayoutParams(-1, -1));
      }
    }
    Object localObject = this.JjA;
    AppMethodBeat.o(80224);
    return localObject;
  }
  
  protected final void gfj()
  {
    AppMethodBeat.i(80225);
    if (this.Jjy != null)
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.n localn = this.Jjy;
      if (localn.getSayFooter() != null)
      {
        localObject = localn.getSayFooter();
        if (((MPSmileyFooter)localObject).rum != null)
        {
          ((MPSmileyFooter)localObject).rum.goC();
          ((MPSmileyFooter)localObject).rum.destroy();
        }
      }
      Object localObject = com.tencent.mm.plugin.webview.ui.tools.widget.p.JAu;
      com.tencent.mm.plugin.webview.ui.tools.widget.p.b(localn.JzA.gut);
    }
    AppMethodBeat.o(80225);
  }
  
  public final q gfk()
  {
    return this.gut;
  }
  
  public final boolean gfl()
  {
    AppMethodBeat.i(211156);
    boolean bool = this.ILF.gfl();
    AppMethodBeat.o(211156);
    return bool;
  }
  
  protected final void gfn()
  {
    AppMethodBeat.i(80251);
    if ((this.JjE == null) || (gfo()))
    {
      AppMethodBeat.o(80251);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.JjE.getLayoutParams();
    int i = gfp();
    if (i != localMarginLayoutParams.topMargin)
    {
      localMarginLayoutParams.topMargin = i;
      this.JjE.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(80251);
  }
  
  protected boolean gfq()
  {
    return true;
  }
  
  final boolean gfr()
  {
    AppMethodBeat.i(80255);
    if ((!Util.isNullOrNil(this.xPq)) && (this.xPq.equals("black")))
    {
      AppMethodBeat.o(80255);
      return true;
    }
    AppMethodBeat.o(80255);
    return false;
  }
  
  protected final void gfs()
  {
    AppMethodBeat.i(80256);
    if ((com.tencent.mm.compatible.util.d.oD(21)) && (this.xPp != 0))
    {
      setActionbarColor(this.xPp);
      AppMethodBeat.o(80256);
      return;
    }
    setStatusBarColor(bXh());
    AppMethodBeat.o(80256);
  }
  
  public final o.a gft()
  {
    AppMethodBeat.i(211169);
    if (this.ILE == null)
    {
      AppMethodBeat.o(211169);
      return null;
    }
    o.a locala = o.baw(this.IMH.getCurrentUrl());
    AppMethodBeat.o(211169);
    return locala;
  }
  
  public final String gfu()
  {
    return this.IMH.IJM;
  }
  
  public final String gfv()
  {
    return this.IMH.ILO;
  }
  
  public final void gfx()
  {
    AppMethodBeat.i(80272);
    Log.i("MicroMsg.WebViewUI", "forceQuit");
    try
    {
      this.JjI.release();
      this.pGj.stopLoading();
      this.pGj.removeAllViews();
      this.pGj.clearView();
      if (this.IBw != null) {
        this.IBw.detach();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        this.pGj.destroy();
        finish();
        Log.appenderFlush();
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI", "forceQuit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI", "forceQuit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
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
  
  protected void gfy()
  {
    AppMethodBeat.i(80275);
    this.Jiq = System.currentTimeMillis();
    this.pGj.goBack();
    l locall = l.Jhd;
    Log.v("MicroMsg.WebViewReportUtil", "goBack traceid %s", new Object[] { locall.traceid });
    if (!Util.isNullOrNil(locall.traceid)) {
      locall.pl(5);
    }
    AppMethodBeat.o(80275);
  }
  
  protected int gfz()
  {
    AppMethodBeat.i(80277);
    if (this.Jij == null)
    {
      AppMethodBeat.o(80277);
      return 0;
    }
    WebViewRedesignInputFooter localWebViewRedesignInputFooter = this.Jij;
    localWebViewRedesignInputFooter.setVisibility(0);
    if (localWebViewRedesignInputFooter.JAP != null) {
      localWebViewRedesignInputFooter.JAP.setVisibility(8);
    }
    localWebViewRedesignInputFooter.JAQ = true;
    localWebViewRedesignInputFooter.state = 1;
    int i = localWebViewRedesignInputFooter.gfz();
    AppMethodBeat.o(80277);
    return i;
  }
  
  protected void goBack()
  {
    AppMethodBeat.i(211163);
    if (this.pGj == null)
    {
      AppMethodBeat.o(211163);
      return;
    }
    if (this.JiU)
    {
      AppMethodBeat.o(211163);
      return;
    }
    if (this.pGj.canGoBack())
    {
      gfy();
      AppMethodBeat.o(211163);
      return;
    }
    l.Jhd.close();
    finish();
    AppMethodBeat.o(211163);
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(80361);
    super.hideVKB();
    this.JjT = -2;
    AppMethodBeat.o(80361);
  }
  
  public void initActivityCloseAnimation()
  {
    AppMethodBeat.i(211162);
    if ((this.Jju != null) && (this.Jju.eqZ())) {}
    for (int i = 1; (ao.gJN()) && (i == 0); i = 0)
    {
      overridePendingTransition(0, MMFragmentActivity.a.OHE);
      AppMethodBeat.o(211162);
      return;
    }
    super.initActivityCloseAnimation();
    AppMethodBeat.o(211162);
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
    if (!this.JiV)
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
      this.JiW = true;
      AppMethodBeat.o(80222);
      return;
      localb.addView(localView1);
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(80284);
    this.Jic = ((WebViewKeyboardLinearLayout)findViewById(2131310394));
    this.Jid = ((FrameLayout)findViewById(2131307160));
    this.Jiw = getIntent().getBooleanExtra("finishviewifloadfailed", false);
    this.Jiv = getIntent().getBooleanExtra("is_favorite_item", false);
    this.CSQ = getIntent().getBooleanExtra("isWebwx", true);
    boolean bool = getIntent().getBooleanExtra("show_feedback", false);
    this.JiT = Util.nullAsNil(getIntent().getStringExtra("sentUsername"));
    if (bool) {
      addTextOptionMenu(1, getString(2131765399), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(80049);
          try
          {
            paramAnonymousMenuItem = WebViewUI.this.mHh.baa(null);
            WebViewUI.this.loadUrl(paramAnonymousMenuItem);
            AppMethodBeat.o(80049);
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
    this.JhW = ((ProgressBar)findViewById(2131299324));
    this.JiS = findViewById(2131306778);
    this.JiS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(80050);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WebViewUI.this.gfV();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(80050);
      }
    });
    if (this.CSQ)
    {
      localObject1 = Util.nullAsNil(getIntent().getStringExtra("title"));
      if (((CharSequence)localObject1).length() > 0) {
        this.JhT = true;
      }
      this.JhU = getIntent().getBooleanExtra("key_show_web_page_title", false);
      setMMTitle((CharSequence)localObject1);
    }
    for (;;)
    {
      this.JfG = findViewById(2131310372);
      if (this.JfG != null)
      {
        this.JhY = new h(this.JfG, this.Jic, this.pGj);
        this.JfG.setVisibility(8);
        this.JhZ = ((ImageButton)findViewById(2131310368));
        this.JhZ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80091);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if ((WebViewUI.this.pGj != null) && (WebViewUI.this.pGj.canGoBack())) {
              WebViewUI.this.gfy();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80091);
          }
        });
        this.Jia = ((ImageButton)findViewById(2131310371));
        this.Jia.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80092);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if ((WebViewUI.this.pGj != null) && (WebViewUI.this.pGj.canGoForward())) {
              WebViewUI.this.pGj.goForward();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80092);
          }
        });
      }
      if (this.pGj != null) {
        break;
      }
      Log.i("MicroMsg.WebViewUI", "initView viewWV is null");
      finish();
      AppMethodBeat.o(80284);
      return;
      setMMTitle("");
    }
    if (JiI == WebSettings.RenderPriority.NORMAL)
    {
      Log.i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
      this.pGj.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
      JiI = WebSettings.RenderPriority.HIGH;
    }
    Object localObject3 = this.JjI;
    Object localObject1 = getContentView();
    ((k)localObject3).JgO = ((LogoWebViewWrapper)((View)localObject1).findViewById(2131303819));
    ((k)localObject3).JgN = ((ImageView)((View)localObject1).findViewById(2131310396));
    ((k)localObject3).JgW = ((View)localObject1).findViewById(2131310395);
    if (((k)localObject3).JgW != null)
    {
      ((k)localObject3).JgX = ((k)localObject3).JgW.findViewById(2131310657);
      ((k)localObject3).JgY = ((TextView)((k)localObject3).JgX.findViewById(2131310659));
    }
    ((k)localObject3).JgP = BackwardSupportUtil.BitmapFactory.fromDPToPix(((k)localObject3).JgO.getContext(), 72.0F);
    Object localObject2;
    if (((k)localObject3).JgN == null)
    {
      localObject1 = "null";
      if (((k)localObject3).JgO != null) {
        break label1212;
      }
      localObject2 = "null";
      label548:
      Log.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage.id = %s, logoWrapper.id = %s", new Object[] { localObject1, localObject2 });
      Log.d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", new Object[] { Integer.valueOf(((k)localObject3).JgP) });
      localObject1 = this.JjI;
      localObject2 = this.pGj;
      ((MMWebView)localObject2).setCompetitorView(((k)localObject1).JgO);
      ((MMWebView)localObject2).gYX();
      if (Build.VERSION.SDK_INT <= 10) {
        ((k)localObject1).JgO.getWebViewContainer().setBackgroundColor(((k)localObject1).JgO.getResources().getColor(2131101408));
      }
      localObject3 = ((k)localObject1).JgO;
      ((LogoWebViewWrapper)localObject3).getWebViewContainer();
      if (((LogoWebViewWrapper)localObject3).Jea != null)
      {
        ((LogoWebViewWrapper)localObject3).gxL = ((WebView)localObject2);
        ((LogoWebViewWrapper)localObject3).Jea.addView(((LogoWebViewWrapper)localObject3).gxL);
      }
      if ((!((MMWebView)localObject2).isXWalkKernel()) && (!((MMWebView)localObject2).getIsX5Kernel())) {
        break label1227;
      }
      ((k)localObject1).JgZ = true;
      label704:
      if ((((k)localObject1).JgX != null) && (!((MMWebView)localObject2).getIsX5Kernel()))
      {
        ((ImageView)((k)localObject1).JgX.findViewById(2131310658)).setVisibility(8);
        ((TextView)((k)localObject1).JgX.findViewById(2131302658)).setText("");
      }
      if ((!((k)localObject1).JgZ) || (((k)localObject1).Jha)) {
        break label1235;
      }
      ((k)localObject1).zh(false);
      ((k)localObject1).geX();
    }
    for (;;)
    {
      geA();
      this.Jie = ((FrameLayout)findViewById(2131299174));
      Log.i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.pGj.getIsX5Kernel());
      this.pGj.setWebViewClientExtension(new b(this));
      if (this.pGj.getIsX5Kernel())
      {
        this.pGj.setWebViewCallbackClient(this.Jjw);
        localObject1 = this.JjI;
        localObject2 = new LogoWebViewWrapper.a()
        {
          public final void geq()
          {
            AppMethodBeat.i(80051);
            if (WebViewUI.this.pGj.getIsX5Kernel()) {
              WebViewUI.this.IMs.gdg().D(new Object[] { WebViewUI.this.coX(), Integer.valueOf(10) }).report();
            }
            AppMethodBeat.o(80051);
          }
        };
        if (((k)localObject1).JgO != null) {
          ((k)localObject1).JgO.setMMOverScrollListener((LogoWebViewWrapper.a)localObject2);
        }
      }
      this.Jij = ((WebViewRedesignInputFooter)findViewById(2131310389));
      if (this.Jij != null)
      {
        this.Jij.hide();
        this.Jij.setOnTextSendListener(new WebViewRedesignInputFooter.b()
        {
          public final void bau(String paramAnonymousString)
          {
            AppMethodBeat.i(80059);
            WebViewUI.a(WebViewUI.this, paramAnonymousString);
            AppMethodBeat.o(80059);
          }
          
          public final void bav(String paramAnonymousString)
          {
            AppMethodBeat.i(211112);
            WebViewUI.b(WebViewUI.this, paramAnonymousString);
            AppMethodBeat.o(211112);
          }
        });
        this.Jij.setOnSmileyChosenListener(new WebViewRedesignInputFooter.a()
        {
          public final boolean afZ(String paramAnonymousString)
          {
            AppMethodBeat.i(80060);
            com.tencent.mm.plugin.webview.d.h localh;
            if (WebViewUI.this.IBw != null)
            {
              localh = WebViewUI.this.IBw;
              if (localh.GBl) {
                break label44;
              }
              Log.e("MicroMsg.JsApiHandler", "not ready");
            }
            for (;;)
            {
              AppMethodBeat.o(80060);
              return true;
              label44:
              HashMap localHashMap = new HashMap();
              localHashMap.put("smiley", paramAnonymousString);
              MMHandlerThread.postToMainThread(new h.27(localh, n.a.b("onGetSmiley", localHashMap, localh.IRj, localh.zpY)));
            }
          }
        });
        this.Jij.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b()
        {
          public final void gbP()
          {
            AppMethodBeat.i(80061);
            WebViewUI.a(WebViewUI.this, 0);
            AppMethodBeat.o(80061);
          }
          
          public final void gbQ()
          {
            AppMethodBeat.i(80062);
            WebViewKeyboardLinearLayout localWebViewKeyboardLinearLayout = WebViewUI.this.Jic;
            if ((localWebViewKeyboardLinearLayout != null) && (localWebViewKeyboardLinearLayout.getKeyBoardHeight() > 0)) {
              WebViewUI.a(WebViewUI.this, localWebViewKeyboardLinearLayout.getKeyBoardHeight());
            }
            AppMethodBeat.o(80062);
          }
        });
      }
      this.Jik = ((WebViewSearchContentInputFooter)findViewById(2131307373));
      if (this.Jik != null)
      {
        this.Jik.setActionDelegate(new WebViewSearchContentInputFooter.a()
        {
          public final void a(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
          {
            AppMethodBeat.i(80064);
            if (paramAnonymousWebViewSearchContentInputFooter.getVisibility() == 0) {
              b(paramAnonymousWebViewSearchContentInputFooter);
            }
            AppMethodBeat.o(80064);
          }
          
          public final void b(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
          {
            AppMethodBeat.i(80067);
            WebViewUI.this.pGj.clearMatches();
            paramAnonymousWebViewSearchContentInputFooter.reset();
            WebViewUI.this.Jik.H(0, 0, true);
            WebViewUI.a(WebViewUI.this, false);
            WebViewUI.this.pGj.findAllAsync(paramAnonymousWebViewSearchContentInputFooter.getSearchContent());
            AppMethodBeat.o(80067);
          }
          
          public final boolean c(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(80068);
            if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0)) {
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(480L, 6L, 1L, false);
            }
            AppMethodBeat.o(80068);
            return false;
          }
          
          public final void gbR()
          {
            AppMethodBeat.i(80063);
            WebViewUI.b(WebViewUI.this, 0);
            WebViewUI.this.pGj.clearMatches();
            WebViewUI.this.Jik.giD();
            AppMethodBeat.o(80063);
          }
          
          public final void gbS()
          {
            AppMethodBeat.i(80065);
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(480L, 5L, 1L, false);
            WebViewUI.this.pGj.findNext(false);
            AppMethodBeat.o(80065);
          }
          
          public final void gbT()
          {
            AppMethodBeat.i(80066);
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(480L, 4L, 1L, false);
            WebViewUI.this.pGj.findNext(true);
            AppMethodBeat.o(80066);
          }
        });
        this.pGj.setFindListener(new WebView.FindListener()
        {
          public final void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(80069);
            if ((paramAnonymousBoolean) && (!WebViewUI.c(WebViewUI.this)) && (!Util.isNullOrNil(WebViewUI.this.Jik.getSearchContent())))
            {
              if (paramAnonymousInt2 != 0) {
                break label81;
              }
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(480L, 3L, 1L, false);
            }
            for (;;)
            {
              WebViewUI.a(WebViewUI.this, true);
              WebViewUI.this.Jik.H(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
              AppMethodBeat.o(80069);
              return;
              label81:
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(480L, 2L, 1L, false);
            }
          }
        });
      }
      this.Jif = ((MovingImageButton)findViewById(2131301834));
      this.JiB = findViewById(2131310386);
      if (this.JiB != null) {
        this.JiB.setVisibility(8);
      }
      this.pGj.setWebChromeClient(gfC());
      this.pGj.setDownloadListener(new DownloadListener()
      {
        public final void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
        {
          AppMethodBeat.i(80070);
          Log.i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + paramAnonymousString1 + ", mimetype = " + paramAnonymousString4 + ", userAgent = " + paramAnonymousString2 + ", contentDisposition = " + paramAnonymousString3);
          int i = WebViewUI.this.getIntent().getIntExtra("key_download_restrict", 0);
          String str = WebViewUI.this.getIntent().getStringExtra("key_function_id");
          if (!Util.isNullOrNil(str)) {
            com.tencent.mm.plugin.report.service.h.CyF.a(14596, new Object[] { str, Integer.valueOf(i), Integer.valueOf(0) });
          }
          if (i == 1)
          {
            Log.e("MicroMsg.WebViewUI", "not allow download file : %s", new Object[] { paramAnonymousString1 });
            AppMethodBeat.o(80070);
            return;
          }
          if ((paramAnonymousString4 != null) && (paramAnonymousString4.equalsIgnoreCase("application/vnd.android.package-archive")))
          {
            Log.v("MicroMsg.WebViewUI", "edw onDownloadStart, report download url: %s", new Object[] { paramAnonymousString1 });
            e.a(WebViewUI.this.mHh, 11154, new Object[] { paramAnonymousString1 });
          }
          if (WebViewUI.this.mHi == null)
          {
            Log.e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
            AppMethodBeat.o(80070);
            return;
          }
          int j = 0;
          if (paramAnonymousString4 != null)
          {
            boolean bool1 = WebViewUI.d(WebViewUI.this);
            Log.i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", new Object[] { Boolean.valueOf(bool1) });
            str = WebViewUI.bat(paramAnonymousString3);
            if ((str == null) || (!Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", str))) {
              break label459;
            }
            i = 1;
            boolean bool2 = com.tencent.mm.plugin.webview.core.a.ILq.contains(paramAnonymousString4.toLowerCase());
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
                  Log.i("MicroMsg.WebViewUI", "onDownloadStart is apk");
                }
              }
              e.a(WebViewUI.this.mHh, 18111, new Object[] { WebViewUI.this.fZM(), paramAnonymousString1, paramAnonymousString4, paramAnonymousString3, paramAnonymousString2, Long.valueOf(paramAnonymousLong) });
            }
            if ((j != 0) || (WebViewUI.this.mHi.gdH().pP(24)) || (WebViewUI.e(WebViewUI.this))) {
              break label471;
            }
            Log.e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
            AppMethodBeat.o(80070);
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
            paramAnonymousString2 = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousString2);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString1, paramAnonymousString2.axQ(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$25", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString1.startActivity((Intent)paramAnonymousString2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString1, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$25", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(80070);
            return;
          }
          catch (Exception paramAnonymousString1)
          {
            Log.e("MicroMsg.WebViewUI", "startActivity fail, e = " + paramAnonymousString1.getMessage());
            AppMethodBeat.o(80070);
          }
        }
      });
      this.pGj.requestFocus(130);
      this.pGj.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(80072);
          if ((WebViewUI.this.Jib != null) && (WebViewUI.this.Jib.getVisibility() == 0))
          {
            Animation localAnimation = AnimationUtils.loadAnimation(WebViewUI.this, 2130772072);
            localAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(80071);
                WebViewUI.this.Jib.setVisibility(8);
                AppMethodBeat.o(80071);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationStart(Animation paramAnonymous2Animation) {}
            });
            WebViewUI.this.Jib.startAnimation(localAnimation);
            WebViewUI.this.Jib.setVisibility(8);
          }
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          while (WebViewUI.this.pGj == null)
          {
            AppMethodBeat.o(80072);
            return false;
            if (!paramAnonymousView.hasFocus()) {
              paramAnonymousView.requestFocus();
            }
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              WebViewUI.this.ppd = ((int)paramAnonymousMotionEvent.getRawX());
              WebViewUI.this.ppe = ((int)paramAnonymousMotionEvent.getRawY());
            }
          }
          if ((paramAnonymousMotionEvent.getAction() == 0) || (paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 261) || (paramAnonymousMotionEvent.getAction() == 517))
          {
            if (paramAnonymousMotionEvent.getPointerCount() <= 1) {
              break label249;
            }
            WebViewUI.this.pGj.getSettings().setBuiltInZoomControls(true);
            WebViewUI.this.pGj.getSettings().setSupportZoom(true);
          }
          for (;;)
          {
            AppMethodBeat.o(80072);
            return false;
            label249:
            WebViewUI.this.pGj.getSettings().setBuiltInZoomControls(false);
            WebViewUI.this.pGj.getSettings().setSupportZoom(false);
          }
        }
      });
      this.pGj.gYW();
      this.Jjl = new i(this);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(80073);
          WebViewUI.this.hideVKB();
          WebViewUI.this.gfR();
          Log.i("MicroMsg.WebViewUI", "on back btn press");
          AppMethodBeat.o(80073);
          return true;
        }
      }, gfD());
      if (gfE()) {
        this.Jic.setOnkbdStateListener(new KeyboardLinearLayout.a()
        {
          public final void Ns(int paramAnonymousInt)
          {
            AppMethodBeat.i(211118);
            Log.i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = ".concat(String.valueOf(paramAnonymousInt)));
            WebViewUI.a(WebViewUI.this, WebViewUI.this.Jic, paramAnonymousInt);
            Object localObject1;
            Object localObject2;
            if (paramAnonymousInt == -3)
            {
              WebViewUI.this.IMs.gdc().IZI = 1;
              int i = WebViewUI.this.Jic.getKeyBoardHeight();
              if (i > 0)
              {
                WebViewUI.b(WebViewUI.this, i);
                WebViewUI.a(WebViewUI.this, i);
              }
              if (WebViewUI.g(WebViewUI.this))
              {
                localObject1 = WebViewUI.h(WebViewUI.this);
                if (((WebViewRedesignInputFooter)localObject1).JAQ) {
                  ((WebViewRedesignInputFooter)localObject1).setVisibility(8);
                }
                ((WebViewRedesignInputFooter)localObject1).state = 0;
                ((WebViewRedesignInputFooter)localObject1).cbM();
              }
              localObject2 = WebViewUI.this.ILF;
              localObject1 = WebViewUI.this;
              kotlin.g.b.p.h(localObject1, "activity");
              localObject2 = ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h)localObject2).JxV;
              if (localObject2 != null)
              {
                if (((com.tencent.mm.plugin.webview.ui.tools.video.b)localObject2).bJb()) {
                  com.tencent.f.h.RTc.aV(new com.tencent.mm.plugin.webview.ui.tools.video.b.1((com.tencent.mm.plugin.webview.ui.tools.video.b)localObject2, (Activity)localObject1));
                }
                localObject1 = kotlin.x.SXb;
              }
            }
            do
            {
              WebViewUI.this.agN(paramAnonymousInt);
              WebViewUI.this.JjT = paramAnonymousInt;
              AppMethodBeat.o(211118);
              return;
              if ((WebViewUI.h(WebViewUI.this) != null) && (WebViewUI.h(WebViewUI.this).isShown()))
              {
                WebViewUI.h(WebViewUI.this).hide();
                WebViewUI.h(WebViewUI.this).clearText();
              }
              WebViewUI.b(WebViewUI.this, 0);
              WebViewUI.a(WebViewUI.this, 0);
              localObject2 = WebViewUI.this.ILF;
              localObject1 = WebViewUI.this;
              localObject2 = ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h)localObject2).JxV;
            } while (localObject2 == null);
            if ((!((com.tencent.mm.plugin.webview.ui.tools.video.b)localObject2).bJb()) || (!((com.tencent.mm.plugin.webview.ui.tools.video.b)localObject2).JxQ)) {}
            for (;;)
            {
              localObject1 = kotlin.x.SXb;
              break;
              com.tencent.f.h.RTc.aV(new b.2((com.tencent.mm.plugin.webview.ui.tools.video.b)localObject2, (Activity)localObject1));
            }
          }
        });
      }
      this.JhV = ((MMFalseProgressBar)findViewById(2131310370));
      super.setTitleBarDoubleClickListener(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80074);
          WebViewUI.this.gfF();
          AppMethodBeat.o(80074);
        }
      });
      AppMethodBeat.o(80284);
      return;
      localObject1 = String.valueOf(((k)localObject3).JgN.getId());
      break;
      label1212:
      localObject2 = String.valueOf(((k)localObject3).JgO.getId());
      break label548;
      label1227:
      ((k)localObject1).JgZ = false;
      break label704;
      label1235:
      ((k)localObject1).zh(true);
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
    if (this.IMH != null) {
      this.IMH.loadUrl(paramString, paramMap, paramBoolean);
    }
    AppMethodBeat.o(80297);
  }
  
  protected void m(int paramInt, Bundle paramBundle) {}
  
  public boolean moveTaskToBack(boolean paramBoolean)
  {
    AppMethodBeat.i(211164);
    paramBoolean = super.moveTaskToBack(paramBoolean);
    initActivityCloseAnimation();
    AppMethodBeat.o(211164);
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
    if (this.mHr.d(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(80289);
      return;
    }
    if (this.JfY.d(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(80289);
      return;
    }
    if (this.JjJ.d(this, paramInt1, paramInt2, paramIntent))
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
      this.Jjd = true;
      l.Jhd.close();
      setResult(-1, paramIntent);
      finish();
    }
    AppMethodBeat.o(80289);
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(80291);
    if (this.pGj != null)
    {
      if (!this.JjK) {
        break label42;
      }
      this.pGj.setOnLongClickListener(this.JjL);
    }
    for (;;)
    {
      super.onCancel();
      AppMethodBeat.o(80291);
      return;
      label42:
      this.pGj.setOnLongClickListener(null);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(80265);
    super.onConfigurationChanged(paramConfiguration);
    if (this.pzw != paramConfiguration.orientation)
    {
      View localView = gfw();
      if (localView == null) {}
      for (localView = null; localView == null; localView = (View)localView.getParent())
      {
        AppMethodBeat.o(80265);
        return;
      }
      localView.dispatchConfigurationChanged(paramConfiguration);
      localView.requestLayout();
      this.pzw = paramConfiguration.orientation;
    }
    AppMethodBeat.o(80265);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80244);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.snf, true)) {
      AccessibilityUtil.smartDisableAccessibility();
    }
    com.tencent.mm.plugin.webview.k.j localj = this.Jji;
    localj.createTime = System.currentTimeMillis();
    localj.bN("onCreate", localj.createTime);
    this.Jji.JBP = getIntent().getLongExtra("startTime", 0L);
    cqh();
    super.onCreate(paramBundle);
    this.Jji.bN("onUIInitStart", System.currentTimeMillis());
    cpA();
    this.Jji.bN("onUIInitEnd", System.currentTimeMillis());
    paramBundle = getIntent();
    if (ao.gJN()) {
      overridePendingTransition(MMFragmentActivity.a.OHB, 0);
    }
    if ((paramBundle.hasExtra("nextAnimIn")) || (paramBundle.hasExtra("currentAnimOut"))) {
      overridePendingTransition(paramBundle.getIntExtra("nextAnimIn", 2130772169), paramBundle.getIntExtra("currentAnimOut", 2130772166));
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
    Log.i("MicroMsg.WebViewUI", "WebViewUI onDestroy now: %s", new Object[] { Integer.valueOf(this.IMH.fZu()) });
    Object localObject1;
    if ((com.tencent.mm.plugin.webview.ui.tools.floatball.d.ggy()) && (this.Jju != null) && (this.Jju.eqW()))
    {
      localObject1 = this.Jju.Abp;
      if ((localObject1 == null) || (Util.isNullOrNil(((MultiTaskInfo)localObject1).field_id)))
      {
        Log.w("MicroMsg.WebViewUI", "saveMultiTaskInfo taskInfo invalid");
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1553L, 26L, 1L, false);
      }
    }
    for (int i = 1;; i = 0)
    {
      super.onDestroy();
      com.tencent.mm.plugin.webview.modeltools.c.gdm();
      localObject1 = this.IMH.getCurrentUrl();
      Object localObject2;
      label151:
      int j;
      label230:
      Object localObject3;
      az.k localk;
      label322:
      long l;
      String str;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.webview.k.k.ie(this);
        if ((localObject2 != null) && (((String)localObject1).equals(localObject2))) {
          com.tencent.mm.plugin.webview.k.k.jdMethod_if(this);
        }
        if (this.Jjt != null) {
          this.Jjt.onDestroy();
        }
        if (this.Jjs != null)
        {
          Log.i("MicroMsg.WebViewUI", "onDestroy, invalidate mHandOffURL");
          this.Jjs = null;
        }
        if (this.Jii != null) {
          this.Jii.disable();
        }
        this.Jjd = true;
        Jjc -= 1;
        int k = this.IMH.fZu();
        j = JiD.size() - 1;
        if (j >= 0)
        {
          if (((e)JiD.get(j)).id != k) {
            break label986;
          }
          JiD.remove(j);
        }
        this.IMs.gdg().D(new Object[] { coX(), Integer.valueOf(2) }).report();
        localObject3 = this.IMs;
        localk = ((az)localObject3).gda();
        j = az.bHy();
        Iterator localIterator = localk.Jan.entrySet().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (Map.Entry)localIterator.next();
          localObject2 = (String)((Map.Entry)localObject1).getKey();
          l = ((Long)((Map.Entry)localObject1).getValue()).longValue();
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(32L, 0L, 1L, true);
        } while ((l < 0L) || (l > 180000L));
        str = localk.Jak;
        if (localObject2 != null) {
          break label993;
        }
      }
      boolean bool;
      label969:
      label986:
      label993:
      for (localObject1 = localObject2;; localObject1 = ((String)localObject2).replace(",", "!"))
      {
        az.r(str, new Object[] { Integer.valueOf(3), Long.valueOf(l), Integer.valueOf(j), localObject1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(az.access$000()), Integer.valueOf(az.access$100()), Integer.valueOf(localk.ehX), localk.Jak });
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(160L, 0L, 1L, false);
        if (-1 != com.tencent.mm.plugin.webview.i.a.Me(l)) {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(160L, com.tencent.mm.plugin.webview.i.a.Me(l), 1L, false);
        }
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(32L, 3L, 1L, true);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(32L, 7L, l, true);
        if (az.access$100() == 1)
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(32L, 16L, 1L, true);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(32L, 17L, l, true);
        }
        Log.i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { localObject2, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(az.access$000()), Integer.valueOf(az.access$100()), Integer.valueOf(localk.ehX), localk.Jak });
        break label322;
        localObject1 = ((MultiTaskInfo)localObject1).field_id;
        Log.i("MicroMsg.WebViewUI", "saveMultiTaskInfo to cache multiTaskId=%s", new Object[] { localObject1 });
        if ((this.pGj != null) && (this.pGj.getParent() != null) && (this.pGj.getActivityContextIfHas() == this))
        {
          if (this.ILF.bJb()) {
            this.ILF.zs(true);
          }
          this.pGj.onHide();
          ((ViewGroup)this.pGj.getParent()).removeView(this.pGj);
          this.IMH.b(this.JjS);
          this.IMH.b(this.JjS.Jkd);
          if (this.IBw != null) {
            this.IBw.yW(true);
          }
          localObject2 = this.IMH.ILG;
          if (getMMTitle() != null)
          {
            localObject3 = getController();
            if (((t)localObject3).OGj == null) {
              break label969;
            }
          }
        }
        for (i = ((t)localObject3).OGj.getVisibility();; i = 0)
        {
          if (i == 0) {
            ((com.tencent.mm.plugin.webview.ui.tools.floatball.c)localObject2).title = getMMTitle().toString();
          }
          localObject2 = com.tencent.mm.plugin.webview.ui.tools.floatball.d.JmQ;
          com.tencent.mm.plugin.webview.ui.tools.floatball.d.a((String)localObject1, this.IMH);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1553L, 0L, 1L, false);
          break;
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1553L, 20L, 1L, false);
          if (this.pGj == null) {}
          for (bool = true;; bool = false)
          {
            Log.w("MicroMsg.WebViewUI", "saveMultiTaskInfo wv has no parent, %b", new Object[] { Boolean.valueOf(bool) });
            break;
          }
        }
        Log.w("MicroMsg.WebViewUI", "currentURL == null, qbrowser.url may be not accurate");
        break label151;
        j -= 1;
        break label230;
      }
      localObject1 = ((az)localObject3).gdc();
      if (!Util.isNullOrNil(((ax)localObject1).IZB)) {
        Log.d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", new Object[] { ((ax)localObject1).IZB });
      }
      try
      {
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)IPCVoid.hnE, ax.a.IZJ.getClass(), (com.tencent.mm.ipcinvoker.d)new ax.b((ax)localObject1));
        localObject1 = ((az)localObject3).gdd();
        if (!Util.isNullOrNil(((ak)localObject1).iAh))
        {
          localObject2 = ((ak)localObject1).iAh;
          if (localObject2 == null) {
            kotlin.g.b.p.hyc();
          }
          if (kotlin.n.n.J((String)localObject2, "wrd", false)) {}
        }
        else
        {
          ((az)localObject3).gcZ().report();
          ((az)localObject3).gdb().report();
          localObject1 = ((az)localObject3).gdf();
          j = az.bHy();
          if (!((az.b)localObject1).Jae) {
            break label2219;
          }
          if (!((az.b)localObject1).loadFinished) {
            break label2174;
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(11575, new Object[] { ((az.b)localObject1).edo, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(j) });
          localObject1 = this.IMs;
          ((az)localObject1).IZO = null;
          ((az)localObject1).IZM = null;
          ((az)localObject1).IZN = null;
          ((az)localObject1).IZL = null;
          ((az)localObject1).IZQ = null;
          ((az)localObject1).IZR = null;
          ((az)localObject1).IZS = null;
          ((az)localObject1).IZT = null;
          if (((az)localObject1).IZY != null)
          {
            ((az)localObject1).IZY.dQL = null;
            ((az)localObject1).IZY = null;
          }
          aYq("onDestroy");
          if (this.JiM != null) {
            this.JiM.clear();
          }
          gfd();
          c(this.JiR);
          if ((this.JiG != null) && ((this.JiG instanceof b))) {
            c(((b)this.JiG).kvo);
          }
          if (this.Jij != null) {
            this.Jij.setOnTextSendListener(null);
          }
          if (this.JhY != null)
          {
            localObject1 = this.JhY.JfG;
            if (localObject1 != null)
            {
              localObject2 = ((View)localObject1).getAnimation();
              if (localObject2 != null) {
                ((Animation)localObject2).setAnimationListener(null);
              }
              ((View)localObject1).clearAnimation();
            }
          }
          if (this.JiN != null) {
            this.JiN.clear();
          }
          this.Jjx.dead();
          this.JiJ.dead();
          if (com.tencent.xweb.d.lA(MMApplicationContext.getContext()) != null) {
            Log.i("MicroMsg.WebViewUI", "now force sync the cookie between ram and db");
          }
        }
      }
      catch (RemoteException localThrowable)
      {
        try
        {
          com.tencent.xweb.d.sync();
          Log.v("MicroMsg.WebViewUI", "on destroy isNeedCallbackMMRpt[%b]", new Object[] { Boolean.valueOf(this.Jir) });
          if (!this.Jir) {}
        }
        catch (Exception localThrowable)
        {
          try
          {
            localObject1 = getIntent().getBundleExtra("mm_report_bundle");
            if (!Util.isNullOrNil(((Bundle)localObject1).getString("mm_event_class"))) {
              if (this.mHh != null)
              {
                ((Bundle)localObject1).putLong("key_activity_browse_time", getActivityBrowseTimeMs());
                this.mHh.j(250, (Bundle)localObject1);
              }
            }
          }
          catch (Exception localThrowable)
          {
            try
            {
              if (this.mHh != null)
              {
                localObject1 = new Bundle();
                ((Bundle)localObject1).putLong("key_activity_browse_time", getActivityBrowseTimeMs());
                this.mHh.j(251, (Bundle)localObject1);
              }
            }
            catch (Exception localThrowable)
            {
              try
              {
                if (this.mHh != null)
                {
                  localObject1 = this.mHh.j(19, null);
                  if (localObject1 != null)
                  {
                    bool = ((Bundle)localObject1).getBoolean("webview_video_proxy_init");
                    Log.i("MicroMsg.WebViewUI", "onDestroy, has init = %b, webviewHoldingCounter = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(Jjc) });
                    if ((bool) && (Jjc <= 0))
                    {
                      FactoryProxyManager.getPlayManager().deinit();
                      this.mHh.j(75, null);
                    }
                  }
                }
                if (this.pGj != null) {
                  this.pGj.QDX = null;
                }
                if (i == 0)
                {
                  this.IMH.fZZ();
                  if (this.mHi != null)
                  {
                    localObject1 = this.mHi;
                    Log.i("MicroMsg.WebViewPermission", "detach");
                    ((com.tencent.mm.plugin.webview.f.g)localObject1).Jce.clear();
                    ((com.tencent.mm.plugin.webview.f.g)localObject1).Jce = null;
                    this.mHi = null;
                  }
                  this.pGj = null;
                }
                this.Jjk.gdG();
              }
              catch (Exception localThrowable)
              {
                try
                {
                  this.JjI.release();
                  if ((getContentView() instanceof ViewGroup)) {
                    ((ViewGroup)getContentView()).removeAllViews();
                  }
                  localObject1 = this.Jjo;
                }
                catch (Throwable localThrowable)
                {
                  try
                  {
                    for (;;)
                    {
                      ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).removePrimaryClipChangedListener((ClipboardManager.OnPrimaryClipChangedListener)localObject1);
                      label1819:
                      localObject1 = this.Jjp;
                      if ((((com.tencent.mm.plugin.webview.c)localObject1).tipDialog != null) && (((com.tencent.mm.plugin.webview.c)localObject1).tipDialog.isShowing()))
                      {
                        ((com.tencent.mm.plugin.webview.c)localObject1).tipDialog.dismiss();
                        ((com.tencent.mm.plugin.webview.c)localObject1).tipDialog = null;
                      }
                      EventCenter.instance.removeListener(((com.tencent.mm.plugin.webview.c)localObject1).IJD);
                      if (this.Jjn != null)
                      {
                        this.Jjn = null;
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
                      ((StringBuffer)localObject2).append(localRemoteException.iAh);
                      ((StringBuffer)localObject2).append("&staytime=");
                      ((StringBuffer)localObject2).append(localRemoteException.dUy);
                      ((StringBuffer)localObject2).append("&allstaytime=");
                      ((StringBuffer)localObject2).append(System.currentTimeMillis() - localRemoteException.enterTime);
                      ((StringBuffer)localObject2).append("&maxscrolly=");
                      ((StringBuffer)localObject2).append(localRemoteException.IZc);
                      ((StringBuffer)localObject2).append("&totalscrolly=");
                      ((StringBuffer)localObject2).append(localRemoteException.EOU);
                      ((StringBuffer)localObject2).append("&scene=");
                      ((StringBuffer)localObject2).append(localRemoteException.scene);
                      ((StringBuffer)localObject2).append("&entertime=");
                      ((StringBuffer)localObject2).append(localRemoteException.enterTime);
                      ((StringBuffer)localObject2).append("&screenheight=");
                      ((StringBuffer)localObject2).append(com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()));
                      Bundle localBundle = new Bundle();
                      localBundle.putString("reportString", ((StringBuffer)localObject2).toString());
                      try
                      {
                        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localBundle, ak.a.IZd.getClass(), null);
                      }
                      catch (Exception localException1)
                      {
                        Log.printErrStackTrace("MicroMsg.WebviewReporter", (Throwable)localException1, "TopStory report", new Object[0]);
                      }
                      continue;
                      label2174:
                      com.tencent.mm.plugin.report.service.h.CyF.a(11575, new Object[] { localException1.edo, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(j) });
                      continue;
                      label2219:
                      com.tencent.mm.plugin.report.service.h.CyF.a(11575, new Object[] { localException1.edo, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(j) });
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
                    }
                    localThrowable = localThrowable;
                    Log.w("MicroMsg.WebViewUI", "onDestroy contentView removeAllViews %s", new Object[] { localThrowable });
                  }
                  catch (Exception localException6)
                  {
                    break label1819;
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
    if (this.pGj != null) {
      this.pGj.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(211113);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$30", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$30", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(211113);
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
      if ((this.pGj != null) && (this.pGj.hasEnteredFullscreen()))
      {
        this.pGj.leaveFullscreen();
        AppMethodBeat.o(80274);
        return true;
      }
      if (this.ILF.zs(false))
      {
        AppMethodBeat.o(80274);
        return true;
      }
    }
    if ((paramInt == 4) && (this.vk != null) && (this.JiF != null) && (this.JiG != null)) {
      try
      {
        this.JiG.onHideCustomView();
        this.IMs.gdg().D(new Object[] { coX(), Integer.valueOf(1) }).report();
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
      if ((this.Jij != null) && (this.Jij.isShown()))
      {
        this.Jij.hide();
        gfM();
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(80274);
        return true;
      }
    }
    if (paramInt == 4)
    {
      if ((this.pGj != null) && (this.pGj.canGoBack()) && (this.Jio))
      {
        gfy();
        this.IMs.gdg().D(new Object[] { coX(), Integer.valueOf(1) }).report();
        AppMethodBeat.o(80274);
        return true;
      }
      l.Jhd.close();
    }
    if ((paramInt == 4) && (gfQ()) && (gbB()))
    {
      AppMethodBeat.o(80274);
      return true;
    }
    if ((paramInt == 4) && (this.Jjt != null) && (this.Jjt.wu(2)))
    {
      AppMethodBeat.o(80274);
      return true;
    }
    if ((paramInt == 4) && (this.Jju != null) && (this.Jju.wu(2)))
    {
      AppMethodBeat.o(80274);
      return true;
    }
    if ((paramInt == 4) && (this.Jjy != null) && (this.Jjy.bJw()))
    {
      this.Jjy.hide();
      AppMethodBeat.o(80274);
      return true;
    }
    if (paramInt == 4) {
      gfS();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(80274);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(80273);
    if ((paramInt == 82) && (!this.JjH))
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
    if (this.Jjt != null) {
      this.Jjt.aGj();
    }
    if (this.Jju != null) {
      this.Jju.aGj();
    }
    com.tencent.mm.modelstat.d.d(4, "WebViewUI_" + aXI(Util.nullAsNil(this.JiT)), this.IMH.fZu());
    com.tencent.mm.modelstat.d.m("WebViewUI_" + aXI(Util.nullAsNil(this.JiT)), this.zdW, Util.nowSecond());
    Object localObject = this.IMs.gdc();
    if (((ax)localObject).lastResumeTime != -1L) {
      ((ax)localObject).dUy += Util.ticksToNow(((ax)localObject).lastResumeTime) / 1000L;
    }
    localObject = this.IMs.gdd();
    if (((ak)localObject).lastResumeTime != -1L) {
      ((ak)localObject).dUy += Util.ticksToNow(((ak)localObject).lastResumeTime);
    }
    localObject = l.Jhd;
    Log.v("MicroMsg.WebViewReportUtil", "onPause traceid %s", new Object[] { ((l)localObject).traceid });
    if (((l)localObject).iGD) {
      Log.i("MicroMsg.WebViewReportUtil", "isFinish is true");
    }
    try
    {
      if (this.mHh != null)
      {
        localObject = this.mHh.j(19, null);
        if (localObject != null)
        {
          boolean bool = ((Bundle)localObject).getBoolean("webview_video_proxy_init");
          Log.i("MicroMsg.WebViewUI", "onPause, has init = %b", new Object[] { Boolean.valueOf(bool) });
          if (bool) {
            FactoryProxyManager.getPlayManager().appToBack();
          }
        }
      }
      gfM();
      ScreenShotUtil.setScreenShotCallback(this, null);
      aYq("onPause");
      if (this.JiG != null) {
        Log.i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.JiG.onHideCustomView();
          this.ILF.onPause();
          if (this.pGj != null) {
            this.pGj.onPause();
          }
          AppMethodBeat.o(80234);
          return;
          if (!Util.isNullOrNil(((l)localObject).traceid)) {
            ((l)localObject).pl(6);
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
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    paramArrayOfString = this.mHr;
    if (paramArrayOfString.Jay == null)
    {
      paramArrayOfString.gdn();
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
        paramArrayOfInt = (Intent)paramArrayOfString.Jay.first;
        paramInt = ((Integer)paramArrayOfString.Jay.second).intValue();
        paramArrayOfString.Jay = null;
        startActivityForResult(paramArrayOfInt, paramInt);
      }
      for (;;)
      {
        paramInt = 1;
        break;
        label99:
        paramArrayOfString.Jay = null;
        paramArrayOfString.b(this, 0, null);
      }
    }
    AppMethodBeat.o(80242);
  }
  
  protected void onReset()
  {
    AppMethodBeat.i(80245);
    this.IBw.detach();
    this.IBw = null;
    ((ViewGroup)this.pGj.getParent()).removeView(this.pGj);
    this.pGj.stopLoading();
    this.pGj.removeAllViews();
    this.pGj.clearView();
    this.pGj.destroy();
    this.pGj = null;
    this.JiG = null;
    ((ViewGroup)this.Jib.getParent()).removeView(this.Jib);
    if (this.ILE != null)
    {
      o localo = this.ILE;
      if (localo.Jkh != null)
      {
        LinearLayout localLinearLayout = (LinearLayout)localo.Jkg.getController().mActionBar.getCustomView();
        if (localLinearLayout != null) {
          localLinearLayout.removeView(localo.Jkh);
        }
      }
    }
    if (this.IMH != null) {
      this.IMH.onDestroy();
    }
    this.ILF.onDestroy();
    this.Jjg = false;
    cqh();
    cpA();
    AppMethodBeat.o(80245);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80233);
    super.onResume();
    if (this.Jjt != null) {
      this.Jjt.bCA();
    }
    if (this.Jju != null) {
      this.Jju.bCA();
    }
    if (this.IMH.getCurrentUrl() != null) {
      com.tencent.mm.plugin.webview.k.k.j(this.IMH.getCurrentUrl(), this);
    }
    for (;;)
    {
      this.IMs.gdc().lastResumeTime = Util.currentTicks();
      this.IMs.gdd().lastResumeTime = Util.currentTicks();
      Object localObject = l.Jhd;
      Log.v("MicroMsg.WebViewReportUtil", "onResume traceid %s", new Object[] { ((l)localObject).traceid });
      if (!Util.isNullOrNil(((l)localObject).traceid)) {
        ((l)localObject).pl(7);
      }
      int i;
      if (!this.JjC)
      {
        int j = this.IMH.fZu();
        i = JiD.size() - 1;
        if (i >= 0)
        {
          if (((e)JiD.get(i)).id == j) {
            JiD.remove(i);
          }
        }
        else {
          JiD.add(new e(this));
        }
      }
      else
      {
        this.JjC = false;
        if (this.JiE)
        {
          yY(true);
          this.JiE = false;
        }
        gfA();
        updateOrientation();
        if ((getIntent().getBooleanExtra("disable_swipe_back", false)) && (getSwipeBackLayout() != null)) {
          getSwipeBackLayout().setEnableGesture(false);
        }
      }
      try
      {
        ScreenShotUtil.setScreenShotCallback(this, this);
        aYq("onResume");
        try
        {
          if (this.mHh != null)
          {
            localObject = this.mHh.j(19, null);
            if (localObject != null)
            {
              boolean bool = ((Bundle)localObject).getBoolean("webview_video_proxy_init");
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
            Log.e("MicroMsg.WebViewUI", "notify app tofront failed : %s", new Object[] { localException2.getMessage() });
          }
        }
        this.zdW = Util.nowSecond();
        com.tencent.mm.plugin.webview.a.a.aj(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80087);
            com.tencent.mm.modelstat.d.d(3, "WebViewUI_" + WebViewUI.this.aXI(Util.nullAsNil(WebViewUI.this.JiT)), WebViewUI.this.fZu());
            AppMethodBeat.o(80087);
          }
        });
        if (this.Jjh) {
          finish();
        }
        if ((this.Jic != null) && (this.Jic.Jgc))
        {
          hideVKB();
          this.Jic.Ns(-2);
        }
        this.ILF.onResume();
        if (this.pGj != null) {
          this.pGj.onResume();
        }
        AppMethodBeat.o(80233);
        return;
        com.tencent.mm.plugin.webview.k.k.j(coX(), this);
        continue;
        i -= 1;
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
    AppMethodBeat.i(211154);
    if ((this.IBw != null) && (this.pGj != null))
    {
      Object localObject1 = this.IBw;
      this.pGj.getUrl();
      Object localObject2 = getIntent();
      if ((this.mHi.gdI().Kzi & 0x100000) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.GeneralControlWrapper", "allowOnScreenShot, ret = ".concat(String.valueOf(bool)));
        if (!((com.tencent.mm.plugin.webview.d.h)localObject1).GBl) {
          break label388;
        }
        Log.i("MicroMsg.JsApiHandler", "onScreenShot hasPermission: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramString = n.a.b("onScreenShot", new HashMap(), ((com.tencent.mm.plugin.webview.d.h)localObject1).IRj, ((com.tencent.mm.plugin.webview.d.h)localObject1).zpY);
          ((com.tencent.mm.plugin.webview.d.h)localObject1).IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
        }
        paramString = ((com.tencent.mm.plugin.webview.d.h)localObject1).aXZ(((com.tencent.mm.plugin.webview.d.h)localObject1).getCurrentUrl());
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
              com.tencent.mm.plugin.report.service.h.CyF.a(19213, new Object[] { Integer.valueOf(i), Integer.valueOf(6), localObject2, paramString, str, localObject3, localObject1 });
            }
          }
          AppMethodBeat.o(211154);
          return;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "alvinluo reportAdOnScreenShot exception", new Object[0]);
        }
      }
    }
    label388:
    AppMethodBeat.o(211154);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(80266);
    super.onStart();
    if ((this.Jjs != null) && (gbH()))
    {
      Log.i("MicroMsg.WebViewUI", "[Handoff] onStart, call onWebViewCreate " + this.Jjs.toString());
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).a(this.Jjs);
    }
    Log.i("MicroMsg.WebViewUI", "edw onStart");
    AppMethodBeat.o(80266);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(80267);
    Log.i("MicroMsg.WebViewUI", "edw onStop");
    if ((this.Jjs != null) && (gbH()))
    {
      Log.i("MicroMsg.WebViewUI", "[Handoff] onStop, call onWebViewDestroy " + this.Jjs.toString());
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).b(this.Jjs);
    }
    this.JhV.finish();
    zk(true);
    super.onStop();
    AppMethodBeat.o(80267);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(80290);
    if (this.pGj != null)
    {
      if (!this.JjK) {
        break label46;
      }
      this.pGj.setOnLongClickListener(this.JjL);
    }
    for (;;)
    {
      hideVKB();
      super.onSwipeBack();
      AppMethodBeat.o(80290);
      return;
      label46:
      this.pGj.setOnLongClickListener(null);
    }
  }
  
  public boolean onSwipeBackFinish()
  {
    AppMethodBeat.i(80293);
    this.Jjf = true;
    az.g localg = this.IMs.gdg();
    if (this.pGj != null) {}
    for (String str = this.pGj.getUrl();; str = coX())
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
    if ((this.ILE != null) && (!this.ILE.Jkf))
    {
      localObject = this.ILE;
      if (Util.isNullOrNil(((o)localObject).nKc)) {
        ((o)localObject).nKc = Util.nullAsNil(((o)localObject).Jkg.IMH.getCurrentUrl());
      }
      ((o)localObject).ggh();
    }
    long l;
    if (this.JhY != null)
    {
      localObject = this.JhY;
      if (((h)localObject).JfC)
      {
        l = System.currentTimeMillis();
        if (((h)localObject).Jfz == 0L)
        {
          ((h)localObject).Jfz = l;
          ((h)localObject).JfA = paramInt2;
        }
        if ((Math.abs(l - ((h)localObject).Jfz) > 200L) && (Math.abs(paramInt2 - ((h)localObject).JfA) > ((h)localObject).JfB))
        {
          if ((paramInt2 - ((h)localObject).JfA <= 0) || (((h)localObject).JfG.getVisibility() != 0)) {
            break label195;
          }
          ((h)localObject).geC();
        }
      }
    }
    for (;;)
    {
      ((h)localObject).Jfz = l;
      ((h)localObject).JfA = paramInt2;
      AppMethodBeat.o(80261);
      return;
      label195:
      if ((paramInt2 - ((h)localObject).JfA < 0) && (((h)localObject).JfG.getVisibility() != 0)) {
        ((h)localObject).geB();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(80283);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.IBw != null) {
      this.IBw.onWindowFocusChanged(paramBoolean);
    }
    if ((paramBoolean) && (gfB())) {
      aC(getWindow().getDecorView(), 5894);
    }
    AppMethodBeat.o(80283);
  }
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(80221);
    super.setActionbarColor(paramInt);
    if (this.JiV) {
      setStatusBarColor(paramInt);
    }
    AppMethodBeat.o(80221);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    AppMethodBeat.i(80363);
    super.setBackBtn(paramOnMenuItemClickListener, paramInt);
    if ((com.tencent.mm.compatible.util.d.oD(21)) && (gfr())) {
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
    bao(paramCharSequence.toString());
    bap(paramCharSequence.toString());
    AppMethodBeat.o(80238);
  }
  
  public void setMMTitle(String paramString)
  {
    AppMethodBeat.i(80237);
    super.setMMTitle(paramString);
    bao(paramString);
    bap(paramString);
    AppMethodBeat.o(80237);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(211172);
    this.screenOrientation = paramInt;
    updateOrientation();
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(211172);
  }
  
  @TargetApi(21)
  public final void setStatusBarColor(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(80258);
    Object localObject;
    if (this.JiV)
    {
      localObject = getContentView();
      if (!com.tencent.mm.ui.ar.aln(paramInt)) {
        bool = true;
      }
      com.tencent.mm.ui.statusbar.a.e((View)localObject, paramInt, bool);
      AppMethodBeat.o(80258);
      return;
    }
    if ((this.mStatusBarHeight <= 0) || (com.tencent.mm.compatible.util.d.oE(21)))
    {
      AppMethodBeat.o(80258);
      return;
    }
    getWindow().setStatusBarColor(0);
    if (this.JjF == null)
    {
      this.JjF = new View(this);
      localObject = new ViewGroup.LayoutParams(-1, this.mStatusBarHeight);
      ((ViewGroup)findViewById(16908290)).addView(this.JjF, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.JjF.setBackgroundColor(paramInt);
      AppMethodBeat.o(80258);
      return;
      localObject = this.JjF.getLayoutParams();
      if (((ViewGroup.LayoutParams)localObject).height != this.mStatusBarHeight)
      {
        ((ViewGroup.LayoutParams)localObject).height = this.mStatusBarHeight;
        this.JjF.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
    if (this.JjT == -3)
    {
      this.JjT = -2;
      AppMethodBeat.o(80362);
      return;
    }
    this.JjT = -3;
    AppMethodBeat.o(80362);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(80369);
    if (Util.isEqual(paramIntent.getType(), "application/vnd.android.package-archive"))
    {
      r.l(MMApplicationContext.getContext(), paramIntent.getData());
      AppMethodBeat.o(80369);
      return;
    }
    super.startActivity(paramIntent);
    AppMethodBeat.o(80369);
  }
  
  protected void su(boolean paramBoolean) {}
  
  protected void z(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80358);
    Log.i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
    AppMethodBeat.o(80358);
  }
  
  public final void zi(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(80319);
    if (this.JhY != null) {
      this.JhY.zi(paramBoolean);
    }
    ImageButton localImageButton;
    if ((this.pGj != null) && (this.JfG != null))
    {
      localImageButton = this.JhZ;
      if ((this.pGj == null) || (!this.pGj.canGoBack())) {
        break label102;
      }
      paramBoolean = true;
      localImageButton.setEnabled(paramBoolean);
      localImageButton = this.Jia;
      if ((this.pGj == null) || (!this.pGj.canGoForward())) {
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
  
  protected void zj(boolean paramBoolean)
  {
    AppMethodBeat.i(80310);
    this.JjH = paramBoolean;
    if (this.pGj == null)
    {
      Log.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
      AppMethodBeat.o(80310);
      return;
    }
    enableOptionMenu(paramBoolean);
    showOptionMenu(paramBoolean);
    boolean bool1 = getIntent().getBooleanExtra("show_feedback", false);
    if (bool1) {
      showOptionMenu(bool1);
    }
    int i = gfL();
    if (gfK() != null) {
      i = 2131691095;
    }
    bool1 = getIntent().getBooleanExtra("KRightBtn", false);
    boolean bool2 = getIntent().getBooleanExtra("KShowFixToolsBtn", false);
    Log.i("MicroMsg.WebViewUI", "banRightBtn:%b, showFixToolsBtn:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (!bool1)
    {
      if (bool2) {
        addIconOptionMenu(1, 2131690297, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(211117);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(WebViewUI.this, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
            ((Intent)localObject).putExtra("entry_fix_tools", 1);
            paramAnonymousMenuItem = WebViewUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$36", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$36", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(211117);
            return true;
          }
        });
      }
      addIconOptionMenu(0, i, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(80084);
          if (WebViewUI.this.mHi.aZK(WebViewUI.this.fZM())) {
            WebViewUI.this.IMs.gdg().D(new Object[] { WebViewUI.this.coX(), Integer.valueOf(6) }).report();
          }
          for (;;)
          {
            WebViewUI.this.cpD();
            AppMethodBeat.o(80084);
            return true;
            WebViewUI.this.IMs.gdg().D(new Object[] { WebViewUI.this.coX(), Integer.valueOf(5) }).report();
          }
        }
      }, this.JjO);
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      zl(paramBoolean);
      AppMethodBeat.o(80310);
      return;
    }
  }
  
  protected final void zk(boolean paramBoolean)
  {
    AppMethodBeat.i(211180);
    enableOptionMenu(true);
    Log.d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", new Object[] { Boolean.TRUE });
    setProgressBarIndeterminateVisibility(false);
    if (paramBoolean)
    {
      this.Jjm.geM();
      AppMethodBeat.o(211180);
      return;
    }
    if ((!this.JiX) && (!this.JiY)) {
      this.IMH.cph();
    }
    AppMethodBeat.o(211180);
  }
  
  public final void zl(boolean paramBoolean)
  {
    AppMethodBeat.i(80359);
    if (this.pGj == null)
    {
      AppMethodBeat.o(80359);
      return;
    }
    String str = this.pGj.getUrl();
    if (paramBoolean)
    {
      showOptionMenu(0, false);
      this.JiP.put(str, Boolean.TRUE);
      AppMethodBeat.o(80359);
      return;
    }
    showOptionMenu(0, true);
    if (this.JiP.containsKey(str)) {
      this.JiP.remove(str);
    }
    AppMethodBeat.o(80359);
  }
  
  protected static final class a
  {
    private String IVn;
    private String IVo;
    private String IVp;
    private String IVq;
    private String IVr;
    private String IVs;
    private String JjZ;
    private String lang;
    
    private a(Bundle paramBundle)
    {
      AppMethodBeat.i(80123);
      this.JjZ = paramBundle.getString("close_window_confirm_dialog_switch");
      this.IVn = paramBundle.getString("close_window_confirm_dialog_title_cn");
      this.IVo = paramBundle.getString("close_window_confirm_dialog_title_eng");
      this.IVp = paramBundle.getString("close_window_confirm_dialog_ok_cn");
      this.IVq = paramBundle.getString("close_window_confirm_dialog_ok_eng");
      this.IVr = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
      this.IVs = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
      this.lang = paramBundle.getString("application_language");
      AppMethodBeat.o(80123);
    }
    
    public static a bc(Bundle paramBundle)
    {
      AppMethodBeat.i(80124);
      paramBundle = new a(paramBundle);
      AppMethodBeat.o(80124);
      return paramBundle;
    }
    
    public final boolean gci()
    {
      AppMethodBeat.i(80125);
      if (Util.isNullOrNil(this.JjZ))
      {
        AppMethodBeat.o(80125);
        return false;
      }
      boolean bool = this.JjZ.equals("true");
      AppMethodBeat.o(80125);
      return bool;
    }
    
    public final String gck()
    {
      AppMethodBeat.i(80127);
      if ("zh_CN".equals(this.lang))
      {
        str = this.IVp;
        AppMethodBeat.o(80127);
        return str;
      }
      String str = this.IVq;
      AppMethodBeat.o(80127);
      return str;
    }
    
    public final String gcl()
    {
      AppMethodBeat.i(80128);
      if ("zh_CN".equals(this.lang))
      {
        str = this.IVr;
        AppMethodBeat.o(80128);
        return str;
      }
      String str = this.IVs;
      AppMethodBeat.o(80128);
      return str;
    }
    
    public final String ggc()
    {
      AppMethodBeat.i(80126);
      if ("zh_CN".equals(this.lang))
      {
        str = this.IVn;
        AppMethodBeat.o(80126);
        return str;
      }
      String str = this.IVo;
      AppMethodBeat.o(80126);
      return str;
    }
  }
  
  public class b
    extends com.tencent.xweb.x
  {
    public volatile boolean hho;
    com.tencent.mm.ui.widget.a.d kvo;
    
    protected b()
    {
      AppMethodBeat.i(80144);
      this.hho = false;
      this.kvo = null;
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
      com.tencent.mm.plugin.ball.f.f.e(true, true, false);
      if (WebViewUI.this.gaW().ISC)
      {
        MPVideoPlayFullScreenView localMPVideoPlayFullScreenView = WebViewUI.this.gfi();
        Context localContext = localMPVideoPlayFullScreenView.getContext();
        if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).pGj != null)) {
          localMPVideoPlayFullScreenView.JvR = ((WebViewUI)localContext).pGj.setVideoJsCallback((com.tencent.xweb.v)new MPVideoPlayFullScreenView.i(localMPVideoPlayFullScreenView));
        }
        if (localMPVideoPlayFullScreenView.JvR != null) {}
        for (int i = 1; i != 0; i = 0)
        {
          WebViewUI.a(WebViewUI.this, paramCustomViewCallback);
          Log.i("MicroMsg.WebViewUI", "onEnterFullscreen view");
          if (paramView.getParent() == null) {
            WebViewUI.this.gfi().gg(paramView);
          }
          AppMethodBeat.o(80145);
          return true;
        }
      }
      if (WebViewUI.this.gaW().ISC) {
        WebViewUI.this.gaW().zb(false);
      }
      boolean bool = super.a(paramView, paramCustomViewCallback);
      AppMethodBeat.o(80145);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, com.tencent.xweb.x.a parama)
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
          WebViewUI.q(WebViewUI.this).a(WebViewUI.this, WebViewUI.this.mHi, null, paramValueCallback, str2, paramWebView);
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
      WebViewUI.r(WebViewUI.this);
      if (WebViewUI.s(WebViewUI.this) > 2) {}
      for (this.kvo = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131768772), WebViewUI.this.getString(2131755921), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80142);
              com.tencent.mm.plugin.report.service.h.CyF.a(11683, new Object[] { paramString1, Integer.valueOf(1), Integer.valueOf(WebViewUI.s(WebViewUI.this)) });
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
          }, 2131100685); this.kvo != null; this.kvo = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131755921), new DialogInterface.OnClickListener()
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
        this.kvo.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(80135);
            Log.d("MicroMsg.WebViewUI", "onJsAlert, onDismiss");
            if (!localPBool.value) {
              paramJsResult.cancel();
            }
            AppMethodBeat.o(80135);
          }
        });
        this.kvo.setCanceledOnTouchOutside(false);
        this.kvo.Dh(false);
        AppMethodBeat.o(80158);
        return true;
      }
      boolean bool = super.a(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(80158);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, com.tencent.xweb.o paramo)
    {
      AppMethodBeat.i(80157);
      boolean bool = super.a(paramWebView, paramString1, paramString2, paramString3, paramo);
      AppMethodBeat.o(80157);
      return bool;
    }
    
    public final boolean b(WebView paramWebView, final String paramString1, String paramString2, final JsResult paramJsResult)
    {
      AppMethodBeat.i(80156);
      Log.d("MicroMsg.WebViewUI", "onJsConfirm");
      final PBool localPBool = new PBool();
      localPBool.value = false;
      if ((WebViewUI.this.isFinishing()) || (WebViewUI.this.activityHasDestroyed()))
      {
        Log.d("MicroMsg.WebViewUI", "onJsConfirm finish");
        paramJsResult.cancel();
        AppMethodBeat.o(80156);
        return true;
      }
      WebViewUI.r(WebViewUI.this);
      if (WebViewUI.s(WebViewUI.this) > 2) {}
      for (this.kvo = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131768772), WebViewUI.this.getString(2131755921), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(80137);
              com.tencent.mm.plugin.report.service.h.CyF.a(11683, new Object[] { paramString1, Integer.valueOf(1), Integer.valueOf(WebViewUI.s(WebViewUI.this)) });
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
          }, 2131100081); this.kvo != null; this.kvo = com.tencent.mm.ui.base.h.a(WebViewUI.this.getContext(), false, paramString2, "", WebViewUI.this.getString(2131755921), WebViewUI.this.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
        this.kvo.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(80141);
            Log.d("MicroMsg.WebViewUI", "onJsConfirm, onDismiss");
            if (!localPBool.value) {
              paramJsResult.cancel();
            }
            AppMethodBeat.o(80141);
          }
        });
        this.kvo.setCancelable(false);
        this.kvo.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(80156);
        return true;
      }
      boolean bool = super.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(80156);
      return bool;
    }
    
    public final boolean bLA()
    {
      AppMethodBeat.i(80146);
      com.tencent.mm.plugin.ball.f.f.e(false, true, false);
      boolean bool = super.bLA();
      AppMethodBeat.o(80146);
      return bool;
    }
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80149);
      Log.i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", new Object[] { paramString, WebViewUI.this.gfu() });
      super.d(paramWebView, paramString);
      if ((WebViewUI.this.JhT) && (!WebViewUI.l(WebViewUI.this)))
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
      if (!WebViewUI.this.CSQ)
      {
        AppMethodBeat.o(80149);
        return;
      }
      if ((!Util.nullAsNil(WebViewUI.this.gfu()).equals(paramString)) && (!com.tencent.mm.plugin.webview.luggage.c.b.afC(paramString)) && (!paramString.startsWith("about:blank"))) {
        WebViewUI.this.setMMTitle(paramString);
      }
      AppMethodBeat.o(80149);
    }
    
    public final View getVideoLoadingProgressView()
    {
      AppMethodBeat.i(80152);
      if (WebViewUI.p(WebViewUI.this) == null)
      {
        WebViewUI.a(WebViewUI.this, new ProgressBar(WebViewUI.this));
        WebViewUI.p(WebViewUI.this).setIndeterminate(true);
      }
      ProgressBar localProgressBar = WebViewUI.p(WebViewUI.this);
      AppMethodBeat.o(80152);
      return localProgressBar;
    }
    
    public final void onExitFullscreenVideo(Bitmap paramBitmap)
    {
      AppMethodBeat.i(80147);
      if ((WebViewUI.this.IBw != null) && (WebViewUI.this.gaW().ISC) && (WebViewUI.this.gfi().getVisibility() == 0))
      {
        if (WebViewUI.k(WebViewUI.this) != null) {
          WebViewUI.k(WebViewUI.this).onCustomViewHidden();
        }
        WebViewUI.this.gaW().zb(false);
        MPVideoPlayFullScreenView localMPVideoPlayFullScreenView = WebViewUI.this.gfi();
        if (localMPVideoPlayFullScreenView.FLK)
        {
          Log.i(localMPVideoPlayFullScreenView.TAG, "isRunningExitAnimation");
          AppMethodBeat.o(80147);
          return;
        }
        localMPVideoPlayFullScreenView.ghL();
        if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
        {
          localObject = new ImageView(localMPVideoPlayFullScreenView.getContext());
          ViewGroup localViewGroup = localMPVideoPlayFullScreenView.JvK;
          if (localViewGroup != null) {
            localViewGroup.addView((View)localObject, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
          }
          ((ImageView)localObject).setImageBitmap(paramBitmap);
        }
        Log.i(localMPVideoPlayFullScreenView.TAG, "runExitAnimation");
        localMPVideoPlayFullScreenView.ghM();
        int j = localMPVideoPlayFullScreenView.JvH.getWidth();
        int i = localMPVideoPlayFullScreenView.JvH.getHeight();
        paramBitmap = localMPVideoPlayFullScreenView.qaE;
        if (paramBitmap != null) {
          paramBitmap.ls(j, i);
        }
        paramBitmap = localMPVideoPlayFullScreenView.qaE;
        int k;
        if (paramBitmap != null)
        {
          localObject = localMPVideoPlayFullScreenView.iwi;
          if (localObject == null) {
            kotlin.g.b.p.hyc();
          }
          j = ((y)localObject).iAL;
          localObject = localMPVideoPlayFullScreenView.iwi;
          if (localObject == null) {
            kotlin.g.b.p.hyc();
          }
          k = ((y)localObject).iAM;
          localObject = localMPVideoPlayFullScreenView.iwi;
          if (localObject == null) {
            kotlin.g.b.p.hyc();
          }
          int m = ((y)localObject).iAN;
          localObject = localMPVideoPlayFullScreenView.iwi;
          if (localObject == null) {
            kotlin.g.b.p.hyc();
          }
          paramBitmap.Q(j, k, m, ((y)localObject).iAO);
        }
        if (localMPVideoPlayFullScreenView.EAC != 1.0D)
        {
          paramBitmap = localMPVideoPlayFullScreenView.qaE;
          if (paramBitmap != null) {
            paramBitmap.QtG = (1.0F / localMPVideoPlayFullScreenView.EAC);
          }
          if ((localMPVideoPlayFullScreenView.EAD != 0) || (localMPVideoPlayFullScreenView.EAE != 0))
          {
            j = (int)(localMPVideoPlayFullScreenView.JvH.getWidth() / 2 * (1.0F - localMPVideoPlayFullScreenView.EAC));
            k = localMPVideoPlayFullScreenView.EAD;
            i = (int)(localMPVideoPlayFullScreenView.JvH.getHeight() / 2 + localMPVideoPlayFullScreenView.EAE - i / 2 * localMPVideoPlayFullScreenView.EAC);
            paramBitmap = localMPVideoPlayFullScreenView.qaE;
            if (paramBitmap != null) {
              paramBitmap.lu(j + k, i);
            }
          }
        }
        paramBitmap = localMPVideoPlayFullScreenView.JvH.getLayoutParams();
        Object localObject = localMPVideoPlayFullScreenView.qaE;
        if (localObject != null)
        {
          ((com.tencent.mm.ui.tools.e)localObject).a((View)localMPVideoPlayFullScreenView.JvK, localMPVideoPlayFullScreenView.JvH, (e.c)new MPVideoPlayFullScreenView.q(localMPVideoPlayFullScreenView, paramBitmap), null);
          AppMethodBeat.o(80147);
          return;
        }
      }
      AppMethodBeat.o(80147);
    }
    
    public final void onGeolocationPermissionsShowPrompt(final String paramString, final GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(80153);
      Log.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[] { paramString });
      if (!com.tencent.mm.pluginsdk.permission.b.n(WebViewUI.this, "android.permission.ACCESS_FINE_LOCATION")) {
        com.tencent.mm.pluginsdk.permission.b.b(WebViewUI.this, "android.permission.ACCESS_FINE_LOCATION", 64);
      }
      com.tencent.mm.ui.base.h.a(WebViewUI.this, false, WebViewUI.this.getString(2131768779, new Object[] { paramString }), WebViewUI.this.getString(2131768780), WebViewUI.this.getString(2131755921), WebViewUI.this.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(80133);
          Log.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt ok");
          paramCallback.invoke(paramString, true, true);
          e.a(WebViewUI.this.mHh, 14340, new Object[] { WebViewUI.this.coX(), WebViewUI.this.fZM(), Integer.valueOf(WebViewUI.this.bLC()), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(az.bHy()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(80133);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(80136);
          Log.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt cancel");
          paramCallback.invoke(paramString, false, false);
          e.a(WebViewUI.this.mHh, 14340, new Object[] { WebViewUI.this.coX(), WebViewUI.this.fZM(), Integer.valueOf(WebViewUI.this.bLC()), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(az.bHy()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(80136);
        }
      });
      AppMethodBeat.o(80153);
    }
    
    public final void onHideCustomView()
    {
      AppMethodBeat.i(80151);
      Log.i("MicroMsg.WebViewUI", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
      WebViewUI.this.getContext().getWindow().clearFlags(128);
      if (WebViewUI.m(WebViewUI.this) == null)
      {
        AppMethodBeat.o(80151);
        return;
      }
      try
      {
        WebViewUI.this.zi(WebViewUI.this.cpC());
        if (!WebViewUI.this.pGj.isXWalkKernel())
        {
          WebViewUI.this.pGj.setVisibility(0);
          WebViewUI.this.setTitleVisibility(0);
        }
        for (;;)
        {
          if (WebViewUI.this.Jie != null) {
            WebViewUI.this.Jie.removeView(WebViewUI.m(WebViewUI.this));
          }
          WebViewUI.a(WebViewUI.this, null);
          if (WebViewUI.o(WebViewUI.this) != null) {
            WebViewUI.o(WebViewUI.this).onCustomViewHidden();
          }
          AppMethodBeat.o(80151);
          return;
          WebViewUI.this.fullScreenNoTitleBar(false);
          WebViewUI.this.setStatusBarColor(WebViewUI.this.getResources().getColor(2131101171));
          if (WebViewUI.this.JjE != null)
          {
            ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)WebViewUI.this.JjE.getLayoutParams();
            int i = WebViewUI.n(WebViewUI.this);
            if (i != localMarginLayoutParams.topMargin)
            {
              localMarginLayoutParams.topMargin = i;
              WebViewUI.this.JjE.setLayoutParams(localMarginLayoutParams);
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
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(80150);
      Log.i("MicroMsg.WebViewUI", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
      try
      {
        WebViewUI.this.getContext().getWindow().addFlags(128);
        if (WebViewUI.m(WebViewUI.this) != null)
        {
          paramCustomViewCallback.onCustomViewHidden();
          AppMethodBeat.o(80150);
          return;
        }
        WebViewUI.this.zi(false);
        WebViewUI.a(WebViewUI.this, paramView);
        WebViewUI.b(WebViewUI.this, paramCustomViewCallback);
        if (!WebViewUI.this.pGj.isXWalkKernel())
        {
          WebViewUI.this.pGj.setVisibility(8);
          WebViewUI.this.Jie.addView(paramView);
          WebViewUI.this.setTitleVisibility(4);
          AppMethodBeat.o(80150);
          return;
        }
      }
      catch (Exception paramView)
      {
        Log.e("MicroMsg.WebViewUI", "onShowCustomView error " + paramView.getMessage());
        AppMethodBeat.o(80150);
        return;
      }
      WebViewUI.this.Jie.addView(paramView, 0);
      WebViewUI.this.fullScreenNoTitleBar(true);
      WebViewUI.this.setStatusBarColor(0);
      if (WebViewUI.this.JjE != null)
      {
        paramView = (ViewGroup.MarginLayoutParams)WebViewUI.this.JjE.getLayoutParams();
        paramView.topMargin = 0;
        WebViewUI.this.JjE.setLayoutParams(paramView);
      }
      AppMethodBeat.o(80150);
    }
    
    public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      AppMethodBeat.i(80154);
      WebViewUI.q(WebViewUI.this).a(WebViewUI.this, WebViewUI.this.mHi, paramValueCallback, null, paramString1, paramString2);
      AppMethodBeat.o(80154);
    }
  }
  
  protected final class c
    extends com.tencent.mm.plugin.webview.core.k
  {
    a Jkd;
    
    public c()
    {
      AppMethodBeat.i(211149);
      this.Jkd = new a((byte)0);
      AppMethodBeat.o(211149);
    }
    
    public final boolean c(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(211150);
      Log.e("MicroMsg.WebViewUI", "edw interceptLoadError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1, Boolean.valueOf(NetStatusUtil.isConnected(WebViewUI.this)) });
      AppMethodBeat.o(211150);
      return false;
    }
    
    public final boolean gah()
    {
      AppMethodBeat.i(211151);
      if ((WebViewUI.this.Jjd) || (WebViewUI.t(WebViewUI.this)) || (WebViewUI.this.isFinishing()))
      {
        AppMethodBeat.o(211151);
        return true;
      }
      AppMethodBeat.o(211151);
      return false;
    }
    
    public final com.tencent.mm.plugin.webview.core.f gai()
    {
      return this.Jkd;
    }
    
    public final com.tencent.mm.plugin.webview.core.j gaj()
    {
      AppMethodBeat.i(211152);
      b localb = new b((byte)0);
      AppMethodBeat.o(211152);
      return localb;
    }
    
    public final int getScreenOrientation()
    {
      return WebViewUI.this.screenOrientation;
    }
    
    final class a
      extends com.tencent.mm.plugin.webview.core.f
    {
      private a() {}
      
      public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
      {
        WebViewUI.this.Jjm.Jgs = false;
      }
      
      public final void aXF(String paramString)
      {
        AppMethodBeat.i(211131);
        WebViewUI.this.JjI.geU();
        if ((WebViewUI.w(WebViewUI.this) != null) && (NetStatusUtil.isNetworkConnected(WebViewUI.this.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8")))
        {
          WebViewUI.w(WebViewUI.this).eU("rawUrl", paramString);
          WebViewUI.w(WebViewUI.this).aYt(paramString);
        }
        if ((WebViewUI.x(WebViewUI.this) != null) && (NetStatusUtil.isNetworkConnected(WebViewUI.this.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8"))) {
          WebViewUI.x(WebViewUI.this).setRawUrl(paramString);
        }
        WebViewUI.e(WebViewUI.this, paramString);
        WebViewUI.this.zi(WebViewUI.this.cpC());
        AppMethodBeat.o(211131);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(211130);
        WebViewUI.v(WebViewUI.this);
        if ((WebViewUI.w(WebViewUI.this) != null) && (NetStatusUtil.isNetworkConnected(WebViewUI.this.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8")))
        {
          WebViewUI.w(WebViewUI.this).eU("rawUrl", paramString);
          WebViewUI.w(WebViewUI.this).aYt(paramString);
        }
        if ((WebViewUI.x(WebViewUI.this) != null) && (NetStatusUtil.isNetworkConnected(WebViewUI.this.getContext())) && (paramString != null) && (!paramString.startsWith("data:text/html;charset=utf-8"))) {
          WebViewUI.x(WebViewUI.this).setRawUrl(paramString);
        }
        WebViewUI.e(WebViewUI.this, paramString);
        if (!WebViewUI.y(WebViewUI.this))
        {
          WebViewUI.z(WebViewUI.this);
          WebViewUI.this.IMs.gdf().loadFinished = true;
        }
        Object localObject = WebViewUI.this.pGj.getTitle();
        Log.i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", new Object[] { WebViewUI.this.getMMTitle(), localObject, Boolean.valueOf(WebViewUI.this.JhT), Boolean.valueOf(WebViewUI.this.CSQ), WebViewUI.this.gfu() });
        if ((WebViewUI.c.this.controller.pGj.getIsX5Kernel()) && (!Util.isNullOrNil((String)localObject)) && (((String)localObject).length() > 0) && (!((String)localObject).equals(WebViewUI.this.getMMTitle())) && (!((String)localObject).startsWith("http")) && ((WebViewUI.this.gfu() == null) || (!WebViewUI.this.gfu().equals(localObject))) && (!WebViewUI.this.JhT) && (WebViewUI.this.CSQ))
        {
          Log.d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
          WebViewUI.this.setMMTitle((String)localObject);
        }
        WebViewUI.this.JjI.setCurrentURL(WebViewUI.this.fZM());
        WebViewUI.this.setProgressBarIndeterminateVisibility(false);
        WebViewUI.this.JhV.finish();
        if ((WebViewUI.this.ILE != null) && (!WebViewUI.this.ILE.Jkf))
        {
          localObject = WebViewUI.this.ILE;
          Log.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", new Object[] { paramString });
          ((o)localObject).nKc = paramString;
        }
        WebViewUI.f(WebViewUI.this, paramString);
        WebViewUI.this.b(paramWebView, paramString);
        AppMethodBeat.o(211130);
      }
      
      public final void e(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(211132);
        super.e(paramWebView, paramString);
        paramWebView = WebViewUI.this.ILE;
        Log.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", new Object[] { paramString });
        paramWebView.nKc = paramString;
        AppMethodBeat.o(211132);
      }
      
      public final void i(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(211129);
        if (!WebViewUI.this.JjM) {
          WebViewUI.this.Jjm.geN();
        }
        WebViewUI.this.JjI.geU();
        WebViewUI.this.JjI.setCurrentURL(paramString);
        WebViewUI.this.setProgressBarIndeterminateVisibility(false);
        WebViewUI.this.Jjm.g(paramString, WebViewUI.this.getIntent());
        WebViewUI.this.zk(false);
        if ((WebViewUI.this.ILE != null) && (!WebViewUI.this.ILE.Jkf))
        {
          paramWebView = WebViewUI.this.ILE;
          Log.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageStart, url:%s", new Object[] { paramString });
          paramWebView.nKc = paramString;
          paramWebView.gge();
          paramWebView.ggk();
        }
        WebViewUI.u(WebViewUI.this);
        AppMethodBeat.o(211129);
      }
    }
    
    final class b
      extends com.tencent.mm.plugin.webview.core.j
    {
      private b() {}
      
      public final void a(String paramString, bhj parambhj)
      {
        AppMethodBeat.i(211136);
        if (!Util.isNullOrNil(parambhj.Title)) {
          WebViewUI.this.setMMTitle(parambhj.Title);
        }
        if (parambhj.KCD == 6) {
          WebViewUI.this.zj(false);
        }
        AppMethodBeat.o(211136);
      }
      
      public final void aXN(String paramString)
      {
        AppMethodBeat.i(211135);
        WebViewUI.this.cpE();
        AppMethodBeat.o(211135);
      }
      
      public final void aXO(String paramString)
      {
        AppMethodBeat.i(211143);
        WebViewUI.this.ban(paramString);
        AppMethodBeat.o(211143);
      }
      
      public final void afL(int paramInt)
      {
        AppMethodBeat.i(211145);
        if (WebViewUI.this.Jib != null)
        {
          FontChooserView localFontChooserView = (FontChooserView)WebViewUI.this.Jib.findViewById(2131301659);
          if (localFontChooserView != null) {
            localFontChooserView.setSliderIndex(paramInt - 1);
          }
        }
        AppMethodBeat.o(211145);
      }
      
      public final void b(String paramString, bhj parambhj)
      {
        WebViewUI.this.Jjm.Jgp = parambhj.LRl;
      }
      
      public final void by(int paramInt, String paramString)
      {
        AppMethodBeat.i(211133);
        super.by(paramInt, paramString);
        if (paramInt != 5) {
          WebViewUI.this.zk(false);
        }
        AppMethodBeat.o(211133);
      }
      
      public final void c(String paramString, bhj parambhj)
      {
        AppMethodBeat.i(211137);
        WebViewUI.this.pFJ = parambhj.LRH;
        WebViewUI.b(WebViewUI.this, WebViewUI.this.mHi.gdH().pP(24));
        WebViewUI.this.IMs.gdf().Jae = true;
        WebViewUI.this.Jiz = com.tencent.mm.platformtools.z.a(parambhj.LRE);
        Log.d("MicroMsg.WebViewUI", "onPermissionUpdate, getA8Key = %s", new Object[] { Util.encodeHexString(WebViewUI.this.Jiz) });
        AppMethodBeat.o(211137);
      }
      
      public final void cpR()
      {
        AppMethodBeat.i(211138);
        WebViewUI.this.zk(true);
        AppMethodBeat.o(211138);
      }
      
      public final void d(int paramInt1, String paramString1, int paramInt2, String paramString2)
      {
        AppMethodBeat.i(211146);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(154L, 12L, 1L, false);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(154L, com.tencent.mm.plugin.webview.i.a.agm(paramInt1), 1L, false);
        WebViewUI.this.zk(true);
        WebViewUI.this.Jjm.Jgs = false;
        switch (paramInt1)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(211146);
          return;
          l.Jhd.agL(paramInt2);
          if ((WebViewUI.this.JiS != null) && (this.controller.fZI())) {
            WebViewUI.this.gfN();
          }
          WebViewUI.this.IMs.gdf().Jae = false;
          WebViewUI.this.IMs.gcZ().cM(paramString1, false);
          if (WebViewUI.C(WebViewUI.this)) {
            WebViewUI.this.finish();
          }
        }
      }
      
      public final void ePr()
      {
        AppMethodBeat.i(211139);
        if (WebViewUI.this.Jjg)
        {
          Log.e("MicroMsg.WebViewUI", "edw postBinded hasDoPostBind");
          AppMethodBeat.o(211139);
          return;
        }
        WebViewUI.this.Jjg = true;
        WebViewUI.this.bXg();
        AppMethodBeat.o(211139);
      }
      
      public final void gab()
      {
        AppMethodBeat.i(211134);
        Log.i("MicroMsg.WebViewUI", "WebView-Trace onAuthSucc: url %s", new Object[] { WebViewUI.this.pFJ });
        WebViewUI.a(WebViewUI.this, this.controller.mHi.gdH());
        if (!WebViewUI.this.JjM) {
          WebViewUI.this.Jjm.Jgs = true;
        }
        j localj = WebViewUI.this.Jjm;
        localj.Jgt.add(Integer.valueOf(6));
        localj.Jgt.add(Integer.valueOf(1));
        localj.Jgt.add(Integer.valueOf(3));
        localj.Jgt.add(Integer.valueOf(2));
        WebViewUI.this.Jjm.Jgs = true;
        if (WebViewUI.this.Jjm.geL()) {
          WebViewUI.this.cpD();
        }
        AppMethodBeat.o(211134);
      }
      
      public final void gac()
      {
        AppMethodBeat.i(211140);
        WebViewUI.this.goBack();
        AppMethodBeat.o(211140);
      }
      
      public final void gad()
      {
        AppMethodBeat.i(211142);
        WebViewUI.this.gfx();
        AppMethodBeat.o(211142);
      }
      
      public final void gae()
      {
        AppMethodBeat.i(211147);
        super.gae();
        if ((!WebViewUI.this.JiX) && (!WebViewUI.this.JiY)) {
          WebViewUI.this.JhV.start();
        }
        AppMethodBeat.o(211147);
      }
      
      public final void gaf()
      {
        AppMethodBeat.i(211148);
        super.gaf();
        WebViewUI.this.JhV.finish();
        AppMethodBeat.o(211148);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(211141);
        WebViewUI.this.finish();
        AppMethodBeat.o(211141);
      }
      
      public final void yS(boolean paramBoolean)
      {
        AppMethodBeat.i(211144);
        if ((paramBoolean) && (WebViewUI.this.pGj != null))
        {
          WebViewUI.this.pGj.setOnLongClickListener(WebViewUI.A(WebViewUI.this));
          WebViewUI.B(WebViewUI.this);
        }
        AppMethodBeat.o(211144);
      }
    }
  }
  
  final class d
    implements FontChooserView.a
  {
    private d() {}
    
    public final void ig(int paramInt)
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
        WebViewUI.this.IMH.afK(i);
        try
        {
          if (WebViewUI.this.mHh.gdW())
          {
            MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("WebViewFontUtil", 2);
            localMultiProcessMMKV.putBoolean("webview_key_font_has_set", true);
            localMultiProcessMMKV.putBoolean("webview_key_has_transfer_mp", true);
            localMultiProcessMMKV.apply();
            com.tencent.mm.plugin.webview.k.f.zz(false);
            WebViewUI.this.mHh.km(16384, i);
            WebViewUI.this.mHh.km(16388, i);
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
    final WeakReference<WebViewUI> nhy;
    
    public e(WebViewUI paramWebViewUI)
    {
      AppMethodBeat.i(80216);
      this.nhy = new WeakReference(paramWebViewUI);
      this.id = paramWebViewUI.fZu();
      AppMethodBeat.o(80216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI
 * JD-Core Version:    0.7.0.1
 */