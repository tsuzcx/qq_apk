package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView.FindListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.bl.a.a;
import com.tencent.mm.h.a.pj;
import com.tencent.mm.m.d.a;
import com.tencent.mm.m.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.ac.b;
import com.tencent.mm.plugin.webview.model.ac.c;
import com.tencent.mm.plugin.webview.model.ac.c.2;
import com.tencent.mm.plugin.webview.model.ac.c.3;
import com.tencent.mm.plugin.webview.model.ac.c.4;
import com.tencent.mm.plugin.webview.model.ac.c.5;
import com.tencent.mm.plugin.webview.model.ac.d;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.an.a;
import com.tencent.mm.plugin.webview.model.an.b;
import com.tencent.mm.plugin.webview.model.an.f;
import com.tencent.mm.plugin.webview.model.an.h;
import com.tencent.mm.plugin.webview.model.an.k;
import com.tencent.mm.plugin.webview.model.an.l;
import com.tencent.mm.plugin.webview.modelcache.o.a;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.plugin.webview.modeltools.l;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.18;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.7;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.8;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b;
import com.tencent.mm.pluginsdk.model.v.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.MMWebView.d;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.xweb.WebView.b;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebViewUI
  extends MMActivity
  implements View.OnCreateContextMenuListener, MMWebView.d
{
  private static final Pattern rbX;
  private static final Pattern rbY;
  private static final Set<String> rfP;
  private static int roX;
  private static final ArrayList<WebViewUI.ab> roa = new ArrayList();
  private static WebSettings.RenderPriority rog = WebSettings.RenderPriority.NORMAL;
  private static IUtils rpc;
  private String bIB = "";
  protected String bYM;
  public volatile String caS = null;
  private int cfb;
  private int fromScene;
  protected com.tencent.mm.bl.a gAS;
  private com.tencent.mm.bl.a.b gAT = new com.tencent.mm.bl.a.b()
  {
    public final void a(a.a paramAnonymousa1, a.a paramAnonymousa2)
    {
      y.i("MicroMsg.WebViewUI", "OrientationListener lastOrientation:" + paramAnonymousa1.name() + "; newOrientation:" + paramAnonymousa2.name());
      WebViewUI.this.screenOrientation = 4;
      WebViewUI.this.ahA();
      if (WebViewUI.this.gAS != null) {
        WebViewUI.this.gAS.disable();
      }
    }
  };
  public com.tencent.mm.plugin.webview.stub.d gGn = null;
  public f gGo = null;
  com.tencent.mm.ui.tools.j gGp;
  String gGq;
  int gGr;
  int gGs;
  com.tencent.mm.plugin.webview.modeltools.h gGt;
  WebView.b gGu;
  WebView.b gGv;
  private final com.tencent.mm.plugin.webview.modeltools.d gGw = new com.tencent.mm.plugin.webview.modeltools.d();
  private h.c gGz = new WebViewUI.28(this);
  private String gVe = "";
  private long gYW = 0L;
  private String gZO;
  public com.tencent.mm.sdk.platformtools.ah handler;
  private int heA;
  private int height;
  private ServiceConnection iAC = new WebViewUI.34(this);
  private long iaq = 0L;
  private int idy;
  private int idz;
  protected com.tencent.mm.ui.widget.snackbar.a.b kNz = new WebViewUI.68(this);
  protected View kXV;
  private View kXW;
  public int kXX = 0;
  public String kXY = null;
  public String kpt;
  private int networkType;
  public MMWebView niQ;
  private boolean oVw = true;
  protected com.tencent.mm.plugin.webview.ui.tools.bag.h rbN;
  public com.tencent.mm.plugin.webview.ui.tools.jsapi.d rbk = null;
  public an rfg = new an();
  private volatile String rgP;
  public com.tencent.mm.plugin.webview.stub.e rgh;
  protected boolean rls = true;
  private final com.tencent.mm.plugin.webview.modeltools.a rmM = new com.tencent.mm.plugin.webview.modeltools.a();
  public boolean rnA = false;
  private boolean rnB = false;
  private WebViewInputFooter rnC;
  public WebViewSearchContentInputFooter rnD;
  private boolean rnE;
  private boolean rnF;
  public String rnG = null;
  public boolean rnH = true;
  private boolean rnI = false;
  public boolean rnJ = false;
  private boolean rnK = false;
  private boolean rnL = false;
  private boolean rnM = true;
  private boolean rnN = false;
  private boolean rnO = false;
  private boolean rnP = false;
  private boolean rnQ = false;
  private boolean rnR = true;
  private int rnS;
  private String rnT = null;
  private byte[] rnU = new byte[0];
  private boolean rnV = false;
  private boolean rnW = false;
  View rnX;
  am rnY;
  private List<com.tencent.mm.plugin.webview.ui.tools.jsapi.b> rnZ = new ArrayList();
  protected boolean rnr = false;
  public MMFalseProgressBar rns;
  public ProgressBar rnt;
  private ImageButton rnu;
  private ImageButton rnv;
  private View rnw;
  public FrameLayout rnx;
  public FrameLayout rny;
  public MovingImageButton rnz;
  private HashMap<String, Boolean> roA = new HashMap();
  private HashMap<String, Integer> roB = new HashMap();
  private WebViewUI.d roC;
  private com.tencent.mm.ui.widget.a.c roD = null;
  private View roE;
  protected View roF = null;
  private String roG = null;
  private boolean roH = false;
  private volatile boolean roI = false;
  private final boolean roJ = true;
  private boolean roK = false;
  private volatile boolean roL = false;
  private final Set<String> roM = new HashSet();
  public boolean roN = false;
  private boolean roO = false;
  private final Map<String, Map<String, String>> roP = new ConcurrentHashMap();
  private Map<String, String> roQ;
  private Map roR;
  private int roS = 0;
  private String roT = "";
  private boolean roU = false;
  private final Map<String, String> roV = new HashMap();
  private final Set<String> roW = new HashSet();
  public boolean roY = false;
  private boolean roZ = false;
  private boolean rob = false;
  private WebChromeClient.CustomViewCallback roc;
  private View rod;
  public com.tencent.xweb.j roe;
  private ProgressBar rof;
  public WebViewUI.m roh = new WebViewUI.m(null);
  protected n roi = new n();
  protected WebViewUI.p roj = new WebViewUI.p(this);
  protected WebViewUI.r rok = new WebViewUI.r(this);
  private final com.tencent.mm.sdk.b.c<SendDataToH5FromMiniProgramEvent> rol = new com.tencent.mm.sdk.b.c() {};
  private boolean rom = false;
  private ab<String, Bitmap> ron = new ab(12);
  private HashMap<String, String> roo = new HashMap();
  private b rop;
  private int roq = 0;
  public com.tencent.mm.plugin.webview.ui.tools.jsapi.f ror;
  protected volatile boolean ros = false;
  private boolean rot = false;
  private String rou = "";
  private String rov;
  private HashMap<String, Boolean> rox = new HashMap();
  private HashMap<String, String> roy = new HashMap();
  private HashMap<String, ArrayList<d.b>> roz = new HashMap();
  private com.tencent.mm.ui.base.p rpA;
  private ac.d rpB = new WebViewUI.60(this);
  private ac.b rpC = new WebViewUI.61(this);
  private com.tencent.mm.ui.base.i rpD;
  private long rpE = 0L;
  private String[] rpF = null;
  public int rpG = -1;
  private com.tencent.mm.plugin.webview.model.b rpa = new com.tencent.mm.plugin.webview.model.b(this.rfg);
  private l rpb = new l();
  private WebViewClipBoardHelper rpd;
  private volatile String rpe;
  private volatile long rpf;
  private i rpg;
  private ak rph = new ak();
  protected com.tencent.xweb.o rpi = new WebViewUI.12(this);
  private com.tencent.mm.sdk.b.c<pj> rpj = new WebViewUI.23(this);
  private boolean rpk = true;
  private int rpl = 0;
  private boolean rpm = false;
  public final g rpn = new g();
  private boolean rpo;
  private View.OnLongClickListener rpp = new WebViewUI.25(this);
  String[] rpq;
  private Map<String, SparseBooleanArray> rpr = new HashMap();
  private Map<String, Integer> rps = new HashMap();
  public View.OnLongClickListener rpt = new WebViewUI.42(this);
  private String rpu = "";
  private volatile String rpv = "";
  private volatile String rpw = null;
  private volatile String rpx = "";
  private volatile String rpy = "";
  private long rpz = 0L;
  public int screenOrientation = -1;
  private int width;
  
  static
  {
    roX = 0;
    rpc = null;
    rbX = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    rbY = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    Object localObject1 = new HashSet();
    rfP = (Set)localObject1;
    ((Set)localObject1).add("file:///android_asset/");
    Object localObject2 = com.tencent.mm.compatible.util.e.dOQ;
    localObject1 = localObject2;
    if (!bk.bl((String)localObject2)) {
      localObject1 = com.tencent.mm.compatible.util.e.dOQ.replace("/data/user/0", "/data/data");
    }
    localObject2 = new File(aa.Bw(0));
    rfP.add("file://" + ((File)localObject2).getAbsolutePath());
    File localFile1 = new File(com.tencent.mm.compatible.util.e.bkH, "fts/res");
    rfP.add("file://" + localFile1.getAbsolutePath());
    File localFile2 = new File((String)localObject1, "wenote/res");
    rfP.add("file://" + localFile2.getAbsolutePath());
    localFile2 = new File(com.tencent.mm.compatible.util.e.bkH, "wenote/res");
    rfP.add("file://" + localFile2.getAbsolutePath());
    localFile2 = new File((String)localObject1, "wxa_fts/res");
    rfP.add("file://" + localFile2.getAbsolutePath());
    y.i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s, wxapp : %s", new Object[] { ((File)localObject2).getAbsolutePath(), localFile1.getAbsolutePath(), localFile2.getAbsolutePath() });
    localObject1 = new File((String)localObject1, "emoji/res");
    rfP.add("file://" + ((File)localObject1).getAbsolutePath());
    localObject2 = new File(com.tencent.mm.compatible.util.e.bkH, "emoji/res");
    rfP.add("file://" + ((File)localObject2).getAbsolutePath());
    y.i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { ((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath() });
    localObject1 = new File(aa.Bw(1));
    rfP.add("file://" + ((File)localObject1).getAbsolutePath());
    localObject2 = new File(com.tencent.mm.compatible.util.e.bkH, "fts_browse/res");
    rfP.add("file://" + ((File)localObject2).getAbsolutePath());
    y.i("MicroMsg.WebViewUI", "add browse UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { ((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath() });
    localObject1 = rfP.iterator();
    while (((Iterator)localObject1).hasNext()) {
      y.i("MicroMsg.WebViewUI", "albie: WebViewUI white list path : %s", new Object[] { (String)((Iterator)localObject1).next() });
    }
  }
  
  private void CE(int paramInt)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("scene_end_type", paramInt);
      localBundle.putInt("scene_end_listener_hash_code", hashCode());
      this.gGn.a(5, localBundle, hashCode());
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WebViewUI", "addSceneEnd, ex = " + localException.getMessage());
    }
  }
  
  private void CF(int paramInt)
  {
    try
    {
      if (this.gGn != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("scene_end_type", paramInt);
        localBundle.putInt("scene_end_listener_hash_code", hashCode());
        this.gGn.a(6, localBundle, hashCode());
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WebViewUI", "removeSceneEnd, ex = " + localException.getMessage());
    }
  }
  
  private void CI(int paramInt)
  {
    String str2 = Tr(this.rpy);
    if ((TextUtils.isEmpty(this.rpy)) || (TextUtils.isEmpty(str2)))
    {
      y.i("MicroMsg.WebViewUI", "stev appId is null or empty");
      return;
    }
    y.i("MicroMsg.WebViewUI", "stev appId %s", new Object[] { str2 });
    long l = bk.UX();
    y.d("MicroMsg.WebViewUI", "stev report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13377), Long.valueOf(l), str2, this.rpy, this.bIB, Integer.valueOf(3), Integer.valueOf(paramInt) });
    Object localObject = "";
    try
    {
      str1 = com.tencent.mm.compatible.util.q.encode(this.rpy, "UTF-8");
      localObject = str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str1;
        int i;
        y.printErrStackTrace("MicroMsg.WebViewUI", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
    i = Ts(getIntent().getStringExtra("geta8key_username"));
    str1 = "";
    if ((i == 7) || (i == 56)) {
      str1 = getIntent().getStringExtra("geta8key_username");
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(13377, new Object[] { Long.valueOf(l), str2, localObject, this.bIB, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(0), str1 });
  }
  
  private void CJ(int paramInt)
  {
    int i;
    if (paramInt > 0)
    {
      i = paramInt;
      if (paramInt <= 4) {}
    }
    else
    {
      i = 2;
    }
    Object localObject1;
    if (this.rbk != null)
    {
      localObject1 = this.rbk;
      if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).ready) {
        break label67;
      }
      y.e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
    }
    for (;;)
    {
      localObject1 = (FontChooserView)this.rnw.findViewById(R.h.font_chooser_view);
      if (localObject1 != null) {
        ((FontChooserView)localObject1).setSliderIndex(i - 1);
      }
      return;
      label67:
      Object localObject2 = new HashMap();
      ((Map)localObject2).put("fontSize", String.valueOf(i));
      localObject2 = i.a.a("menu:setfont", (Map)localObject2, ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).rxI, ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).rxJ);
      ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).rxB.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject2 + ")", null);
    }
  }
  
  private void CK(int paramInt)
  {
    if ((this.niQ == null) || (this.niQ.getSettings() == null)) {
      return;
    }
    y.i("MicroMsg.WebViewUI", "localSetFontSize, fontSize = " + paramInt);
    switch (paramInt)
    {
    case 2: 
    default: 
      this.niQ.getSettings().a(com.tencent.xweb.n.a.xgY);
      return;
    case 1: 
      this.niQ.getSettings().a(com.tencent.xweb.n.a.xgX);
      return;
    case 3: 
      this.niQ.getSettings().a(com.tencent.xweb.n.a.xgZ);
      return;
    }
    this.niQ.getSettings().a(com.tencent.xweb.n.a.xha);
  }
  
  private void N(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.rnA = paramBoolean1;
    Object localObject;
    if (paramBoolean1)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      if (this.kXV != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.kXV.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
        this.kXV.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.roJ) {
        com.tencent.mm.ui.statusbar.a.w(this.kXV, true);
      }
    }
    do
    {
      for (;;)
      {
        getWindow().addFlags(1024);
        localObject = getWindow().getDecorView();
        ((View)localObject).setOnSystemUiVisibilityChangeListener(new WebViewUI.6(this, (View)localObject));
        dq((View)localObject);
        if (!paramBoolean2) {
          break;
        }
        this.rnz.setOnClickListener(new WebViewUI.7(this));
        this.rnz.setVisibility(0);
        return;
        if (this.kXW != null) {
          this.kXW.setVisibility(8);
        }
      }
      this.rnz.setVisibility(8);
      return;
      this.rnz.setVisibility(8);
      getWindow().clearFlags(1024);
      localObject = getWindow().getDecorView();
      if (localObject != null) {
        ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() & 0xFFFFE8F9);
      }
      if (getSupportActionBar() != null)
      {
        getSupportActionBar().show();
        if (this.kXV != null)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.kXV.getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = cdO();
          this.kXV.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if (this.roJ)
      {
        com.tencent.mm.ui.statusbar.a.w(this.kXV, false);
        return;
      }
    } while (this.kXW == null);
    this.kXW.setVisibility(0);
  }
  
  private void P(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      setMMSubTitle(R.l.wechat_authenticate_safely);
      if (!this.rnN) {
        this.rnN = true;
      }
      return;
    }
    if (paramBoolean2)
    {
      setMMSubTitle(R.l.wechat_wx_safe_login);
      return;
    }
    setMMSubTitle(null);
  }
  
  private void Tj(String paramString)
  {
    if (this.niQ != null) {}
    try
    {
      com.tencent.xweb.WebView.class.getMethod(paramString, new Class[0]).invoke(this.niQ, new Object[0]);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      y.e("MicroMsg.WebViewUI", "No such method: " + paramString + ", " + localNoSuchMethodException.toString());
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      y.e("MicroMsg.WebViewUI", "Illegal Access: " + paramString + ", " + localIllegalAccessException.toString());
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      y.e("MicroMsg.WebViewUI", "Invocation Target Exception: " + paramString + ", " + localInvocationTargetException.toString());
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WebViewUI", "Exception : " + paramString + ", " + localException.toString());
    }
  }
  
  private void Tk(String paramString)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences("webview_url_prefs", 4).edit();
    localEditor.putString("url", paramString);
    localEditor.apply();
  }
  
  private static String Tm(String paramString)
  {
    Object localObject = null;
    try
    {
      Matcher localMatcher = Pattern.compile("(?i)^.*filename=\"?([^\"]+)\"?.*$").matcher(paramString);
      paramString = localObject;
      if (localMatcher.find())
      {
        paramString = localObject;
        if (localMatcher.groupCount() == 1) {
          paramString = localMatcher.group(1);
        }
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.WebViewUI", "getFileNameFromContentDisposition error " + paramString.getMessage());
    }
    return null;
  }
  
  private void To(String paramString)
  {
    this.rbk.bp("sendAppMessage", false);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.d locald = this.rbk;
    if (!locald.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onSendToEnterprise fail, not ready");
      return;
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("scene", "enterprise");
    localObject = i.a.a("menu:share:appmessage", (Map)localObject, locald.rxI, locald.rxJ);
    locald.rxB.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    try
    {
      locald.gGn.I("connector_local_send", paramString, locald.rjN);
      locald.gGn.I("scene", "enterprise", locald.rjN);
      return;
    }
    catch (Exception paramString)
    {
      y.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramString.getMessage());
    }
  }
  
  private int Ts(String paramString)
  {
    int j = getIntent().getIntExtra("geta8key_scene", 0);
    int i = j;
    if (j == 0)
    {
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label207;
      }
      if (this.gGn != null) {
        break label60;
      }
      i = 1;
    }
    for (;;)
    {
      y.i("MicroMsg.WebViewUI", "KGetA8KeyScene = %s", new Object[] { Integer.valueOf(i) });
      return i;
      try
      {
        label60:
        if (this.gGn.hU(paramString))
        {
          i = 8;
          continue;
        }
        if (!this.gGn.hl(paramString)) {
          break label202;
        }
        j = 7;
        Bundle localBundle = new Bundle();
        localBundle.putString("enterprise_biz_username", paramString);
        try
        {
          paramString = this.gGn.f(102, localBundle);
          i = j;
          if (paramString == null) {
            continue;
          }
          boolean bool = paramString.getBoolean("is_enterprise_username");
          i = j;
          if (!bool) {
            continue;
          }
          i = 51;
        }
        catch (RemoteException paramString)
        {
          y.e("MicroMsg.WebViewUI", "invoke the check enterprise failed");
          i = j;
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.WebViewUI", "getScene fail, ex = " + paramString.getMessage());
        i = 1;
      }
      continue;
      label202:
      i = 1;
      continue;
      label207:
      i = 0;
    }
  }
  
  private boolean Tt(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.WebViewUI", "search contact err: null or nill url");
      return false;
    }
    CE(106);
    Bundle localBundle = new Bundle();
    localBundle.putString("search_contact_data_url", paramString);
    localBundle.putInt("webview_binder_id", hashCode());
    try
    {
      this.gGn.r(106, localBundle);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.w("MicroMsg.WebViewUI", "startSearchContact, ex = " + paramString.getMessage());
      }
    }
  }
  
  private boolean Tu(String paramString)
  {
    y.i("MicroMsg.WebViewUI", "dealCustomScheme, url = " + paramString);
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    Uri localUri;
    try
    {
      if (this.gGn.cz(paramString))
      {
        y.i("MicroMsg.WebViewUI", "dealCustomScheme, url is handled by QrCodeURLHelper, url = " + paramString);
        this.gGn.cP(paramString, hashCode());
        return true;
      }
    }
    catch (Exception localException1)
    {
      y.w("MicroMsg.WebViewUI", "dealCustomScheme, tryHandleEvents, ex = " + localException1.getMessage());
      localUri = Uri.parse(paramString);
      if (localUri == null) {
        break label656;
      }
    }
    if ((!paramString.startsWith("weixin://")) && (!paramString.startsWith("http")))
    {
      if (paramString.startsWith("tel:"))
      {
        paramString = paramString.replace("tel:", "");
        if (!bk.bl(paramString)) {}
        try
        {
          this.gGn.cR(paramString, hashCode());
          return true;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            y.w("MicroMsg.WebViewUI", "showPhoneSpanDialog, ex = %s", new Object[] { paramString.getMessage() });
          }
        }
      }
      if ((paramString.startsWith("sms:")) || (paramString.startsWith("smsto:")))
      {
        paramString = new Intent("android.intent.action.SENDTO", localUri);
        paramString.addFlags(268435456);
        try
        {
          startActivity(paramString);
          return true;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            y.e("MicroMsg.WebViewUI", "start sms app failed:[%s]", new Object[] { paramString.getMessage() });
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        if ((this.gGo.cdJ().spl & 0x2000) == 0) {
          break label658;
        }
        bool = true;
        y.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = " + bool);
        if ((!bool) && (this.gGn != null) && (this.gGn.cdg()))
        {
          y.e("MicroMsg.WebViewUI", "dealCustomScheme, not allow outer open url");
          return true;
        }
        int i = getIntent().getIntExtra("key_download_restrict", 0);
        String str1 = getIntent().getStringExtra("key_function_id");
        if (!bk.bl(str1)) {
          com.tencent.mm.plugin.report.service.h.nFQ.f(14596, new Object[] { str1, Integer.valueOf(i), Integer.valueOf(1) });
        }
        if (i == 1)
        {
          y.e("MicroMsg.WebViewUI", "not allow launch app by custom scheme : %s", new Object[] { paramString });
          return true;
        }
      }
      catch (RemoteException localRemoteException)
      {
        y.printErrStackTrace("MicroMsg.WebViewUI", localRemoteException, "", new Object[0]);
        long l = bk.UX() - this.rpz;
        y.i("MicroMsg.WebViewUI", "scheme launch interval ; %d", new Object[] { Long.valueOf(l) });
        String str2;
        Object localObject;
        if (l <= 2L)
        {
          str2 = cdR();
          localObject = str2;
        }
        try
        {
          str2 = com.tencent.mm.compatible.util.q.encode(str2, "UTF-8");
          localObject = str2;
          String str3 = com.tencent.mm.compatible.util.q.encode(paramString, "UTF-8");
          paramString = str3;
          localObject = str2;
        }
        catch (Exception localException2)
        {
          y.i("MicroMsg.WebViewUI", "formate url failed");
          continue;
          paramString = new Intent("android.intent.action.VIEW", localUri);
          paramString.addFlags(268435456);
          if (!bk.i(this, paramString)) {
            break label656;
          }
          startActivity(paramString);
          return true;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(13983, new Object[] { Integer.valueOf(4), localObject, paramString });
        if (getIntent().getBooleanExtra("show_openapp_dialog", true)) {
          return com.tencent.mm.cg.a.post(new WebViewUI.59(this, localUri));
        }
      }
      label656:
      return false;
      label658:
      boolean bool = false;
    }
  }
  
  private final boolean Tv(String paramString)
  {
    if (com.tencent.mm.platformtools.ae.eSM)
    {
      y.w("MicroMsg.WebViewUI", "skipLoadUrlCheck");
      return true;
    }
    if (bk.bl(paramString)) {
      return true;
    }
    if (this.rnF)
    {
      y.i("MicroMsg.WebViewUI", "albie: trust this url(%s)", new Object[] { paramString });
      return true;
    }
    paramString = paramString.toLowerCase();
    if (paramString.startsWith("file://"))
    {
      Iterator localIterator = rfP.iterator();
      while (localIterator.hasNext()) {
        if (com.tencent.mm.pluginsdk.ui.tools.s.n(paramString, (String)localIterator.next())) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  private void a(ContextMenu paramContextMenu, WebView.b paramb)
  {
    if ((!a(paramContextMenu, paramb.mExtra)) && (this.gGo.cdJ().coW()) && (cbj()))
    {
      this.gGv = paramb;
      this.gGt = new com.tencent.mm.plugin.webview.modeltools.h();
      this.gGt.a(this.niQ, this.gGz);
    }
  }
  
  private void a(String paramString1, String paramString2, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    if (!bk.bl(paramString2))
    {
      this.gGo.a(paramString2, paramJsapiPermissionWrapper, paramGeneralControlWrapper);
      this.roM.remove(paramString2);
      this.roO = false;
      this.kpt = paramString2;
    }
    if (fB(paramString1, paramString2))
    {
      this.gGo.a(paramString1, paramJsapiPermissionWrapper, paramGeneralControlWrapper);
      this.roM.remove(paramString1);
    }
    while ((this.gGn == null) || (bk.bl(paramString1)) || (!Tl(paramString1))) {
      return;
    }
    this.gGo.a(paramString1, paramJsapiPermissionWrapper, paramGeneralControlWrapper);
    this.roM.remove(paramString1);
  }
  
  private boolean a(ContextMenu paramContextMenu, final String paramString)
  {
    boolean bool2 = false;
    for (;;)
    {
      boolean bool1;
      try
      {
        bool1 = this.gGn.isSDCardAvailable();
        if (!bool1)
        {
          bool1 = true;
          return bool1;
        }
      }
      catch (Exception localException1)
      {
        y.e("MicroMsg.WebViewUI", "onCreateContextMenu fail, ex = " + localException1.getMessage());
        bool1 = false;
        continue;
        paramContextMenu.setHeaderTitle(R.l.wv_image);
      }
      try
      {
        bool1 = this.gGn.cdg();
        boolean bool3 = this.gGo.cdJ().coY();
        boolean bool4 = this.gGo.cdJ().coZ();
        y.i("MicroMsg.WebViewUI", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
        if ((bool1) && (bool3)) {
          paramContextMenu.add(0, 0, 0, getString(R.l.readerapp_alert_retransmit)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              try
              {
                boolean bool = WebViewUI.this.gGn.isSDCardAvailable();
                com.tencent.mm.pluginsdk.ui.tools.s.a(WebViewUI.this, paramString, com.tencent.xweb.b.cSe().getCookie(paramString), bool, new WebViewUI.29.1(this));
                return true;
              }
              catch (Exception paramAnonymousMenuItem)
              {
                for (;;)
                {
                  y.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + paramAnonymousMenuItem.getMessage());
                }
              }
            }
          });
        }
        paramContextMenu.add(0, 0, 0, getString(R.l.save_to_local)).setOnMenuItemClickListener(new WebViewUI.30(this, paramString));
        if ((bool1) && (bool4)) {
          paramContextMenu.add(0, 0, 0, getString(R.l.plugin_favorite_opt)).setOnMenuItemClickListener(new WebViewUI.31(this, paramString));
        }
        bool1 = bool2;
        if (this.gGq == null) {
          continue;
        }
        String str3 = this.gGq;
        if (!com.tencent.mm.plugin.scanner.a.wM(this.gGr)) {
          if (com.tencent.mm.plugin.scanner.a.aD(this.gGr, this.gGq))
          {
            String str1 = this.mController.uMN.getString(R.l.recog_wxcode_of_image_file);
            if (!bk.bl(str1)) {
              paramContextMenu.add(0, 0, 0, str1).setOnMenuItemClickListener(new WebViewUI.32(this, str3, paramString));
            }
            this.gGq = null;
            return true;
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          y.e("MicroMsg.WebViewUI", "get has setuin failed : %s", new Object[] { localException2.getMessage() });
          bool1 = false;
          continue;
          String str2;
          if (com.tencent.mm.plugin.scanner.a.wL(this.gGr)) {
            str2 = this.mController.uMN.getString(R.l.recog_barcode_of_image_file);
          } else {
            str2 = this.mController.uMN.getString(R.l.recog_qbar_of_image_file);
          }
        }
      }
    }
  }
  
  private static boolean a(com.tencent.mm.plugin.webview.ui.tools.jsapi.b paramb, String paramString)
  {
    if ((bk.bl(paramString)) || (paramb == null)) {
      return false;
    }
    return paramb.Ty(paramString);
  }
  
  protected static boolean a(JsapiPermissionWrapper paramJsapiPermissionWrapper, int paramInt)
  {
    if (paramJsapiPermissionWrapper == null) {}
    do
    {
      return false;
      paramInt = paramJsapiPermissionWrapper.ED(paramInt);
    } while ((paramInt != 1) && (paramInt != 10));
    return true;
  }
  
  private void b(ContextMenu paramContextMenu, WebView.b paramb)
  {
    if ((!a(paramContextMenu, paramb.mExtra)) && (this.gGo.cdJ().coW()) && (cbj()))
    {
      this.gGu = paramb;
      this.gGt = new com.tencent.mm.plugin.webview.modeltools.h();
      this.gGt.a(this.niQ, this.gGz);
    }
  }
  
  protected static boolean b(JsapiPermissionWrapper paramJsapiPermissionWrapper, int paramInt)
  {
    if (paramJsapiPermissionWrapper == null) {}
    while (paramJsapiPermissionWrapper.ED(paramInt) != 10) {
      return false;
    }
    return true;
  }
  
  private boolean caZ()
  {
    boolean bool1 = getIntent().getBooleanExtra("forceHideShare", false);
    boolean bool2 = getIntent().getBooleanExtra("showShare", true);
    y.i("MicroMsg.WebViewUI", "forceHideShare:%b showShareBtn:%b enableMinimize:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(aYK()) });
    return (!bool1) && (bool2) && (aYK());
  }
  
  private boolean cbj()
  {
    try
    {
      if (this.gGn == null)
      {
        y.w("MicroMsg.WebViewUI", "invoker is null");
        return false;
      }
      boolean bool = this.gGn.cdr();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      y.e("MicroMsg.WebViewUI", "unable get config for Scan QRCode" + localRemoteException.getMessage());
    }
    return false;
  }
  
  private void cdN()
  {
    y.i("MicroMsg.WebViewUI", "edw tryBindService");
    bindService(new Intent(this, WebViewStubService.class), this.iAC, 1);
  }
  
  private int cdO()
  {
    if (this.roJ) {}
    for (int i = 0; (getSupportActionBar() == null) || (!getSupportActionBar().isShowing()); i = this.heA) {
      return i;
    }
    return i + getActionBarHeight();
  }
  
  private View cdS()
  {
    View localView = null;
    if (com.tencent.mm.compatible.util.d.gF(11)) {}
    for (;;)
    {
      try
      {
        i = Resources.getSystem().getIdentifier("action_bar_container", "id", "android");
        if (i > 0) {
          localView = findViewById(i);
        }
        y.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", new Object[] { Integer.valueOf(i), localView });
        return localView;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.WebViewUI", "get resId action_bar_container, exp = %s", new Object[] { localException });
      }
      int i = -1;
    }
  }
  
  private void cdT()
  {
    try
    {
      this.rpn.release();
      this.niQ.stopLoading();
      this.niQ.removeAllViews();
      this.niQ.clearView();
      if (this.rbk != null) {
        this.rbk.detach();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        this.niQ.destroy();
        this.niQ = null;
        finish();
        y.cqL();
        Process.killProcess(Process.myPid());
        return;
        localException1 = localException1;
        y.e("MicroMsg.WebViewUI", "forceQuit, ex = " + localException1.getMessage());
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          y.w("MicroMsg.WebViewUI", "forceQuit, viewWV destroy, ex = %s", new Object[] { localException2.getMessage() });
        }
      }
    }
  }
  
  private boolean cdv()
  {
    try
    {
      if (this.gGn == null)
      {
        y.w("MicroMsg.WebViewUI", "invoker is null");
        return false;
      }
      boolean bool = this.gGn.cdv();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      y.e("MicroMsg.WebViewUI", "unable get config for WebViewDownLoadFile" + localRemoteException.getMessage());
    }
    return false;
  }
  
  private boolean ceh()
  {
    try
    {
      boolean bool = this.gGn.SP("favorite");
      return bool;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.WebViewUI", localException, "", new Object[0]);
    }
    return false;
  }
  
  private LinkedList<d.a> cek()
  {
    if (this.niQ == null) {
      y.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
    }
    for (;;)
    {
      return null;
      Object localObject = this.caS;
      if (this.niQ != null)
      {
        String str = this.niQ.getUrl();
        if (!bk.bl(str))
        {
          localObject = str;
          if (localObject == null) {
            continue;
          }
          try
          {
            localObject = new URL((String)localObject);
            Pattern localPattern = Pattern.compile(".*(\\.wanggou\\.com|\\.jd\\.com)");
            str = ((URL)localObject).getHost();
            if (bk.bl(str)) {
              continue;
            }
            localObject = str;
            if (!str.startsWith(".")) {
              localObject = "." + str;
            }
            y.d("MicroMsg.WebViewUI", "host = %s", new Object[] { localObject });
            if (!localPattern.matcher((CharSequence)localObject).matches()) {
              continue;
            }
            long l;
            if (this.roR == null)
            {
              l = System.currentTimeMillis();
              this.roR = this.gGn.cdl();
              if (this.roR == null) {
                break label252;
              }
            }
            label252:
            for (boolean bool = true;; bool = false)
            {
              y.d("MicroMsg.WebViewUI", "[hakon] getConfigListMap %b, cost %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
              if ((this.roR == null) || (this.roR.size() <= 0)) {
                break;
              }
              localObject = com.tencent.mm.m.d.f(this.roR);
              return localObject;
            }
          }
          catch (Exception localException)
          {
            y.d("MicroMsg.WebViewUI", "[hakon] getJDMenuItems, ex = ", new Object[] { localException.getMessage() });
            return null;
          }
        }
      }
    }
  }
  
  private void cem()
  {
    if (this.rnX != null) {
      this.rnX.setVisibility(8);
    }
    if (this.rnY != null) {
      this.rnY.stopTimer();
    }
  }
  
  private int cet()
  {
    float f = this.mController.uMN.getSharedPreferences(com.tencent.mm.sdk.platformtools.ae.cqR(), 0).getFloat("current_text_size_scale_key", 1.0F);
    if (f == 0.875F) {
      return 1;
    }
    if (f == 1.125F) {
      return 3;
    }
    if ((f == 1.25F) || (f == 1.375F) || (f == 1.625F)) {
      return 4;
    }
    return 2;
  }
  
  @TargetApi(11)
  private void ceu()
  {
    if (com.tencent.mm.compatible.util.d.gG(11)) {
      y.i("MicroMsg.WebViewUI", "removeConfigJsInterface, api level too low");
    }
    for (;;)
    {
      return;
      if ((this.niQ == null) || (this.gGn == null))
      {
        y.i("MicroMsg.WebViewUI", "viewwv is null or invoker is null");
        return;
      }
      try
      {
        this.niQ.removeJavascriptInterface("searchBoxJavaBridge_");
        if (this.rpF != null) {}
      }
      catch (Exception localException2)
      {
        try
        {
          if (this.gGn.cdg()) {
            this.rpF = this.gGn.cdh();
          }
          if (this.rpF == null)
          {
            i = 0;
            y.i("MicroMsg.WebViewUI", "removeConfigJsInterface, to remove list size = %d", new Object[] { Integer.valueOf(i) });
            if ((this.rpF == null) || (this.rpF.length == 0)) {
              continue;
            }
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            try
            {
              String[] arrayOfString = this.rpF;
              int j = arrayOfString.length;
              i = 0;
              if (i >= j) {
                break;
              }
              String str = arrayOfString[i];
              y.i("MicroMsg.WebViewUI", "removeConfigJsInterface, js interface name = %s", new Object[] { str });
              this.niQ.removeJavascriptInterface(str);
              i += 1;
              continue;
              localException1 = localException1;
              y.e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", new Object[] { localException1.getMessage() });
            }
            catch (Exception localException3)
            {
              int i;
              y.e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", new Object[] { localException3.getMessage() });
            }
            localException2 = localException2;
            y.e("MicroMsg.WebViewUI", "getRemoveJsInterfaceList, ex = %s", new Object[] { localException2.getMessage() });
            continue;
            i = this.rpF.length;
          }
        }
      }
    }
  }
  
  private boolean cev()
  {
    int i = getIntent().getIntExtra("key_close_action", 0);
    Object localObject = getIntent().getBundleExtra("key_close_data");
    y.i("MicroMsg.WebViewUI", "close action %s", new Object[] { Integer.valueOf(i) });
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
            return false;
          } while (localObject == null);
          str1 = ((Bundle)localObject).getString("close_dialog_title");
          str2 = ((Bundle)localObject).getString("close_dialog_msg");
          str3 = ((Bundle)localObject).getString("close_dialog_ok");
          str4 = ((Bundle)localObject).getString("close_dialog_cancel");
          bool = ((Bundle)localObject).getBoolean("close_dialog_ok_close", true);
        } while (bk.H(new String[] { str2, str3, str4 }));
        if (bool) {
          com.tencent.mm.ui.base.h.a(this, str1, str2, str3, str4, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              WebViewUI.this.roY = true;
              h.rnm.close();
              WebViewUI.this.finish();
            }
          }, null);
        }
        for (;;)
        {
          return true;
          com.tencent.mm.ui.base.h.a(this, str1, str2, str3, str4, false, null, new WebViewUI.67(this));
        }
      } while (localObject == null);
      str1 = ((Bundle)localObject).getString("close_jump_url");
      i = ((Bundle)localObject).getInt("close_jump_url_request_code", 0);
    } while (bk.bl(str1));
    localObject = new Intent(this, WebViewUI.class);
    ((Intent)localObject).putExtra("rawUrl", str1);
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("show_bottom", false);
    ((Intent)localObject).putExtra("needRedirect", false);
    ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
    ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
    startActivityForResult((Intent)localObject, i);
    com.tencent.mm.ui.base.b.gL(this);
    return true;
  }
  
  private void cex()
  {
    Object localObject = getIntent();
    boolean bool = ((Intent)localObject).getBooleanExtra("webview_invoke_launch_app_when_back", false);
    String str = ((Intent)localObject).getStringExtra("KAppId");
    localObject = ((Intent)localObject).getStringExtra("webview_invoke_launch_app_ext_info_when_back");
    if ((bool) && (str != null) && (str.length() > 0) && (localObject != null) && (((String)localObject).length() > 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("appId", str);
      localBundle.putString("extInfo", (String)localObject);
      com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", localBundle, com.tencent.mm.pluginsdk.model.app.u.class, null);
    }
  }
  
  protected static void cez() {}
  
  private void dd(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (this.ron.get(str2) != null) {
          y.i("MicroMsg.WebViewUI", "find %s icon from cache ok", new Object[] { str2 });
        }
        for (;;)
        {
          if (!this.roo.containsKey(str2)) {
            break label203;
          }
          y.i("MicroMsg.WebViewUI", "find %s nick from cache ok", new Object[] { str2 });
          break;
          y.w("MicroMsg.WebViewUI", "not found %s icon from cache, try to load", new Object[] { str2 });
          try
          {
            paramList = this.gGn.SL(str2);
            if (!bk.bl(paramList))
            {
              paramList = e.Td(paramList);
              if (paramList != null)
              {
                y.i("MicroMsg.WebViewUI", "load ok, and cache it");
                this.ron.put(str2, paramList);
              }
            }
          }
          catch (Exception paramList)
          {
            y.w("MicroMsg.WebViewUI", "getheadimg, ex = " + paramList.getMessage());
          }
        }
        label203:
        y.w("MicroMsg.WebViewUI", "not found %s nick from cache, try to load", new Object[] { str2 });
        paramList = null;
        try
        {
          String str1 = this.gGn.gV(str2);
          paramList = str1;
          y.i("MicroMsg.WebViewUI", "load nick ok");
          paramList = str1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.w("MicroMsg.WebViewUI", "onAttach, ex = " + localException.getMessage());
          }
        }
        this.roo.put(str2, paramList);
      }
    }
  }
  
  private static void dq(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setSystemUiVisibility(paramView.getSystemUiVisibility() | 0x1706);
  }
  
  private boolean fB(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return false;
    }
    if ((com.tencent.mm.plugin.webview.a.qYo.matcher(paramString1).matches()) && (com.tencent.mm.plugin.webview.a.qYo.matcher(paramString2).matches()))
    {
      String str2 = paramString1.replaceFirst("http://", "").replaceFirst("https://", "");
      int i = str2.indexOf('#');
      String str1 = str2;
      if (i > 0) {
        str1 = str2.substring(0, i);
      }
      if ((paramString2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(str1)) && (this.gGn != null) && (Tl(paramString1))) {
        return true;
      }
    }
    return false;
  }
  
  private WebViewUI.x i(String paramString, boolean paramBoolean, int paramInt)
  {
    if ((this.roY) || (this.roZ) || (isFinishing())) {
      return WebViewUI.x.rqW;
    }
    if (this.roF != null) {
      this.roF.setVisibility(8);
    }
    if (this.gGo == null)
    {
      y.e("MicroMsg.WebViewUI", "startGetA8Key fail, after onDestroy");
      return WebViewUI.x.rqW;
    }
    if (this.rnK)
    {
      y.i("MicroMsg.WebViewUI", "edw startGetA8Key, nevergeta8key");
      this.gGo.a(paramString, null, null);
      return WebViewUI.x.rqU;
    }
    if ((this.gGn != null) && (this.roM.contains(paramString)) && (Tl(paramString))) {}
    for (int i = 1; ((this.gGo.has(paramString)) || (i != 0)) && (!paramBoolean); i = 0)
    {
      y.i("MicroMsg.WebViewUI", "edw startGetA8Key no need, wvPerm already has value, url = " + paramString);
      this.rom = this.gGo.cdI().hi(24);
      return WebViewUI.x.rqU;
    }
    Object localObject = getIntent().getStringExtra("geta8key_username");
    int j = Ts((String)localObject);
    if (paramInt == -1) {}
    for (i = this.roh.TB(paramString);; i = paramInt)
    {
      String str = getIntent().getStringExtra("key_function_id");
      int k = getIntent().getIntExtra("key_wallet_region", 0);
      y.i("MicroMsg.WebViewUI", "edw startGetA8Key, url = %s, scene = %d, username = %s, reason = %d, force = %b, functionid = %s, walletRegion = %d", new Object[] { paramString, Integer.valueOf(j), localObject, Integer.valueOf(i), Boolean.valueOf(paramBoolean), str, Integer.valueOf(k) });
      if (paramInt != 5) {
        O(false, false);
      }
      y.i("MicroMsg.WebViewUI", "edw startGetA8Key, begin, set a default permission");
      this.roM.add(paramString);
      this.gGo.a(paramString, null, null);
      this.rom = this.gGo.cdI().hi(24);
      this.roO = true;
      this.roi.ceL();
      Bundle localBundle = new Bundle();
      localBundle.putString("geta8key_data_req_url", paramString);
      localBundle.putString("geta8key_data_username", (String)localObject);
      localBundle.putInt("geta8key_data_scene", j);
      localBundle.putInt("geta8key_data_reason", i);
      if (this.niQ.getIsX5Kernel()) {
        localBundle.putInt("geta8key_data_flag", 1);
      }
      for (;;)
      {
        localBundle.putString("geta8key_data_net_type", an.ccc());
        localBundle.putInt("geta8key_session_id", this.rnS);
        if (!bk.bl(getIntent().getStringExtra("k_share_url")))
        {
          localBundle.putString("k_share_url", getIntent().getStringExtra("k_share_url"));
          getIntent().putExtra("k_share_url", "");
        }
        localBundle.putInt("key_wallet_region", k);
        localBundle.putString("key_function_id", str);
        localBundle.putInt("webview_binder_id", hashCode());
        localBundle.putByteArray("k_a8key_cookie", this.rnU);
        localBundle.putString("geta8key_data_appid", getIntent().getStringExtra("geta8key_open_webview_appid"));
        this.rnT = paramString;
        paramBoolean = false;
        try
        {
          boolean bool = this.gGn.r(233, localBundle);
          paramBoolean = bool;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.w("MicroMsg.WebViewUI", "startGetA8Key, ex = " + localException.getMessage());
            continue;
            if (!localException.rgS.containsKey(paramString)) {
              localException.rgS.put(paramString, Long.valueOf(bk.UY()));
            }
          }
        }
        y.i("MicroMsg.WebViewUI", "startGetA8Key, doScene ret = " + paramBoolean);
        localObject = this.rfg.cce();
        paramInt = this.cfb;
        str = this.bYM;
        ((an.l)localObject).cfb = paramInt;
        ((an.l)localObject).rgH = str;
        if (!bk.bl(paramString)) {
          break;
        }
        y.e("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.startGetA8Key failed, url is null");
        com.tencent.mm.plugin.report.service.h.nFQ.a(154L, 11L, 1L, false);
        return WebViewUI.x.rqV;
        localBundle.putInt("geta8key_data_flag", 0);
      }
    }
  }
  
  private void li(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.rob = true;
    }
  }
  
  private void lk(boolean paramBoolean)
  {
    if (findViewById(R.h.web_navigator) == null) {
      return;
    }
    boolean bool;
    if (findViewById(R.h.web_navigator).getVisibility() == 0)
    {
      bool = true;
      if (bool != paramBoolean)
      {
        localObject = this.mController.uMN;
        if (!paramBoolean) {
          break label90;
        }
      }
    }
    label90:
    for (int i = R.a.alpha_in;; i = R.a.alpha_out)
    {
      localObject = AnimationUtils.loadAnimation((Context)localObject, i);
      findViewById(R.h.web_navigator).startAnimation((Animation)localObject);
      if (paramBoolean) {
        break label97;
      }
      findViewById(R.h.web_navigator).setVisibility(8);
      return;
      bool = false;
      break;
    }
    label97:
    findViewById(R.h.web_navigator).setVisibility(0);
    this.rnu = ((ImageButton)findViewById(R.h.web_back));
    Object localObject = this.rnu;
    if ((this.niQ != null) && (this.niQ.canGoBack())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((ImageButton)localObject).setEnabled(paramBoolean);
      this.rnu.setOnClickListener(new WebViewUI.57(this));
      this.rnv = ((ImageButton)findViewById(R.h.web_refresh));
      this.rnv.setOnClickListener(new WebViewUI.58(this));
      return;
    }
  }
  
  private void ll(boolean paramBoolean)
  {
    if (this.rnv != null) {
      this.rnv.setEnabled(paramBoolean);
    }
  }
  
  private void zU(String paramString)
  {
    com.tencent.mm.plugin.webview.ui.tools.jsapi.d locald;
    if (this.rbk != null)
    {
      locald = this.rbk;
      if (locald.ready) {
        break label52;
      }
      y.e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready");
    }
    try
    {
      if (paramString.equals("onPause")) {
        this.gGn.Cq(hashCode());
      }
      label52:
      label180:
      while (!paramString.equals("onResume"))
      {
        Object localObject;
        for (;;)
        {
          return;
          y.i("MicroMsg.JsApiHandler", "onActivityStateChanged, state = " + paramString);
          localObject = new HashMap();
          ((Map)localObject).put("state", paramString);
          localObject = i.a.a("activity:state_change", (Map)localObject, locald.rxI, locald.rxJ);
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            break label180;
          }
          try
          {
            locald.rxB.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
          }
          catch (Exception localException)
          {
            y.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { localException.getMessage() });
          }
        }
        break;
        ai.d(new d.8(localException, (String)localObject));
        break;
      }
      this.gGn.Cp(hashCode());
      return;
    }
    catch (Exception paramString)
    {
      y.w("MicroMsg.WebViewUI", "onResume, ex = " + paramString.getMessage());
    }
  }
  
  protected final void CG(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(R.k.actionbar_icon_dark_close).mutate();
    localDrawable.setColorFilter(paramInt, PorterDuff.Mode.SRC_IN);
    com.tencent.mm.ui.s locals = this.mController;
    if ((locals.mActionBar != null) && (locals.uMV != null) && (localDrawable != null))
    {
      locals.uMV.setImageDrawable(localDrawable);
      localDrawable.invalidateSelf();
    }
  }
  
  protected final boolean CH(int paramInt)
  {
    SparseBooleanArray localSparseBooleanArray = (SparseBooleanArray)this.rpr.get(this.niQ.getUrl());
    return (localSparseBooleanArray == null) || (!localSparseBooleanArray.get(paramInt, false));
  }
  
  protected final void O(boolean paramBoolean1, boolean paramBoolean2)
  {
    enableOptionMenu(paramBoolean1);
    y.d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", new Object[] { Boolean.valueOf(paramBoolean1) });
    setProgressBarIndeterminateVisibility(false);
    if (paramBoolean2) {
      this.rns.finish();
    }
    while ((this.roL) || (this.roN)) {
      return;
    }
    this.rns.start();
  }
  
  public void S(Bundle paramBundle) {}
  
  public void T(Bundle paramBundle)
  {
    int i;
    if (paramBundle.getBoolean("set_navigation_bar_color_reset", false)) {
      if (this.rpg == null) {
        i = getResources().getColor(R.e.webview_actionbar_color);
      }
    }
    for (int j = 255;; j = paramBundle.getInt("set_navigation_bar_color_alpha"))
    {
      ta(i & 0xFFFFFF | j << 24);
      return;
      i = this.rpg.ceR();
      break;
      i = paramBundle.getInt("set_navigation_bar_color_color");
    }
  }
  
  public void Ti(String paramString)
  {
    y.i("MicroMsg.WebViewUI", "[notifyPageInfo]pageInfo:%s", new Object[] { paramString });
  }
  
  public boolean Tl(String paramString)
  {
    hashCode();
    return com.tencent.mm.plugin.webview.modelcache.o.Sv(paramString);
  }
  
  public final void Tn(String paramString)
  {
    SparseBooleanArray localSparseBooleanArray2 = (SparseBooleanArray)this.rpr.get(paramString);
    SparseBooleanArray localSparseBooleanArray1 = localSparseBooleanArray2;
    if (localSparseBooleanArray2 == null)
    {
      localSparseBooleanArray1 = new SparseBooleanArray();
      this.rpr.put(paramString, localSparseBooleanArray1);
    }
    if (localSparseBooleanArray1 != null) {
      localSparseBooleanArray1.put(34, true);
    }
  }
  
  public void Tp(String paramString)
  {
    if (this.gGo.cdJ().coV())
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("fromScene", 100);
      if (this.gGn.a(paramString, this.gGo.cdI().hi(7), localBundle)) {
        y.i("MicroMsg.WebViewUI", "shouldOverride, built in url handled, url = " + paramString);
      }
      return;
    }
    y.w("MicroMsg.WebViewUI", "shouldOverride, allow inner open url, not allow");
  }
  
  public boolean Tq(String paramString)
  {
    Iterator localIterator = this.rnZ.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.webview.ui.tools.jsapi.b localb = (com.tencent.mm.plugin.webview.ui.tools.jsapi.b)localIterator.next();
      if (a(localb, paramString))
      {
        y.i("MicroMsg.WebViewUI", "url handled, url = " + paramString);
        if (this.rpu.equals(paramString))
        {
          y.i("MicroMsg.WebViewUI", "url " + paramString + " has been handle");
          return true;
        }
        boolean bool = localb.Tq(paramString);
        y.i("MicroMsg.WebViewUI", "url handled, ret = " + bool + ", url = " + paramString);
        return true;
      }
    }
    return false;
  }
  
  public final String Tr(String paramString)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject2 = localObject1;
      if (this.gGn != null)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("webview_binder_id", hashCode());
        ((Bundle)localObject2).putString("rawUrl", paramString);
      }
    }
    try
    {
      localObject2 = bk.pm(this.gGn.f(76, (Bundle)localObject2).getString("appId"));
      localObject1 = localObject2;
      y.i("MicroMsg.WebViewUI", "stev cachedAppId %s", new Object[] { localObject2 });
      return localObject2;
    }
    catch (RemoteException paramString)
    {
      y.w("MicroMsg.WebViewUI", "get cachedAppId error ", new Object[] { paramString.getMessage() });
    }
    return localObject1;
  }
  
  public boolean U(Bundle paramBundle)
  {
    y.d("MicroMsg.WebViewUI", "[cpan] process a8 key:%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    int j = paramBundle.getInt("geta8key_result_action_code");
    String str3 = paramBundle.getString("geta8key_result_title");
    String str1 = paramBundle.getString("geta8key_result_full_url");
    String str4 = paramBundle.getString("geta8key_result_content");
    String str2 = paramBundle.getString("geta8key_result_req_url");
    Object localObject2 = paramBundle.getStringArray("geta8key_result_http_header_key_list");
    String[] arrayOfString = paramBundle.getStringArray("geta8key_result_http_header_value_list");
    Object localObject1 = localObject2;
    paramBundle = arrayOfString;
    if (getIntent().getBooleanExtra("k_has_http_header", false)) {
      if ((localObject2 != null) && (localObject2.length != 0) && (arrayOfString != null))
      {
        localObject1 = localObject2;
        paramBundle = arrayOfString;
        if (arrayOfString.length != 0) {}
      }
      else
      {
        y.i("MicroMsg.WebViewUI", "use intent httpheader info");
        getIntent().putExtra("k_has_http_header", false);
        localObject1 = getIntent().getStringArrayExtra("geta8key_result_http_header_key_list");
        paramBundle = getIntent().getStringArrayExtra("geta8key_result_http_header_value_list");
        getIntent().putStringArrayListExtra("geta8key_result_http_header_key_list", null);
        getIntent().putStringArrayListExtra("geta8key_result_http_header_value_list", null);
      }
    }
    y.i("MicroMsg.WebViewUI", "processGetA8Key, actionCode = %d, title = %s, fullUrl = %s, content = %s", new Object[] { Integer.valueOf(j), str3, str1, str4 });
    localObject2 = new HashMap();
    int i;
    if ((localObject1 != null) && (paramBundle != null) && (localObject1.length > 0) && (paramBundle.length > 0) && (localObject1.length == paramBundle.length))
    {
      i = 0;
      while (i < localObject1.length)
      {
        ((Map)localObject2).put(localObject1[i], paramBundle[i]);
        i += 1;
      }
    }
    this.roQ = ((Map)localObject2);
    if (!bk.bl(str1)) {}
    for (paramBundle = str1;; paramBundle = str2)
    {
      an.M(this.niQ.getIsX5Kernel(), bk.pm(paramBundle).startsWith("https://"));
      this.rfg.cce().bm(str2, true);
      paramBundle = this.rfg.ccg();
      i = this.cfb;
      localObject1 = this.bYM;
      paramBundle.cfb = i;
      paramBundle.rgH = ((String)localObject1);
      if (bk.bl(str1)) {
        y.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
      }
      for (;;)
      {
        switch (j)
        {
        default: 
          y.i("MicroMsg.WebViewUI", "qrcode-getA8key-not_catch: action code = " + j);
          return false;
          paramBundle.gZO = str1;
          paramBundle.rgG = true;
          if (!paramBundle.rgE.containsKey(str1)) {
            paramBundle.rgE.put(str1, Long.valueOf(bk.UY()));
          }
          if (!paramBundle.rgF.containsKey(str1)) {
            paramBundle.rgF.put(str1, Long.valueOf(bk.UY()));
          }
          break;
        }
      }
      y.i("MicroMsg.WebViewUI", "getA8key-text: " + str4);
      if ((str4 == null) || (str4.length() == 0))
      {
        y.e("MicroMsg.WebViewUI", "getA8key-text fail, invalid content");
        return false;
      }
      this.niQ.getSettings().setJavaScriptEnabled(false);
      this.niQ.loadData(str4, "text/html", "utf-8");
      return true;
      y.i("MicroMsg.WebViewUI", "getA8key-webview: title = " + str3 + ", fullUrl = " + str1);
      if ((str1 == null) || (str1.length() == 0))
      {
        y.e("MicroMsg.WebViewUI", "getA8key-webview fail, invalid fullUrl");
        return false;
      }
      if ((str3 != null) && (str3.length() > 0)) {
        setMMTitle(str3);
      }
      if (!Tv(str1))
      {
        y.f("MicroMsg.WebViewUI", "processGetA8Key qrcode, canLoadUrl fail, url = " + str1);
        cdT();
        return true;
      }
      h(str2, str1, (Map)localObject2);
      return true;
      y.i("MicroMsg.WebViewUI", "getA8key-webview_no_notice: title = " + str3 + ", fullUrl = " + str1);
      if ((str1 == null) || (str1.length() == 0))
      {
        y.e("MicroMsg.WebViewUI", "getA8key-webview_no_notice fail, invalid fullUrl");
        return false;
      }
      if ((str3 != null) && (str3.length() > 0)) {
        setMMTitle(str3);
      }
      if (!Tv(str1))
      {
        y.f("MicroMsg.WebViewUI", "processGetA8Key qrcode no notice, canLoadUrl fail, url = " + str1);
        cdT();
        return true;
      }
      h(str2, str1, (Map)localObject2);
      return true;
      y.i("MicroMsg.WebViewUI", "getA8key-special_webview: fullUrl = " + str1);
      if ((str1 == null) || (str1.length() == 0))
      {
        y.e("MicroMsg.WebViewUI", "getA8key-special_webview fail, invalid fullUrl");
        return false;
      }
      if (!Tv(str1))
      {
        y.f("MicroMsg.WebViewUI", "processGetA8Key special, canLoadUrl fail, url = " + str1);
        cdT();
        return true;
      }
      b(str1, null, false);
      lj(false);
      return true;
      y.i("MicroMsg.WebViewUI", "getA8key-app: " + str1);
      if ((str1 == null) || (str1.length() == 0))
      {
        y.e("MicroMsg.WebViewUI", "getA8key-app, fullUrl is null");
        return false;
      }
      return Tu(str1);
      return Tt(str1);
      if (bk.bl(str1)) {
        y.e("MicroMsg.WebViewUI", "doJumpEmotionDetailUrlScene err: null or nill url");
      }
      for (;;)
      {
        return true;
        paramBundle = this.rok;
        if (paramBundle.rqR == 0) {
          paramBundle.rpH.CE(666);
        }
        paramBundle.rqR += 1;
        paramBundle = new Bundle();
        paramBundle.putString("emoji_store_jump_url", str1);
        paramBundle.putInt("webview_binder_id", hashCode());
        try
        {
          this.gGn.r(666, paramBundle);
        }
        catch (Exception paramBundle)
        {
          y.w("MicroMsg.WebViewUI", "startSearchContact, ex = " + paramBundle.getMessage());
        }
      }
    }
  }
  
  public final boolean Wt()
  {
    an.h localh = this.rfg.ccl();
    if (this.niQ != null) {}
    for (String str = this.niQ.getUrl();; str = this.caS)
    {
      localh.rgD = new Object[] { str, Integer.valueOf(15) };
      localh.c(this.gGn);
      return super.Wt();
    }
  }
  
  public final void XM()
  {
    super.XM();
    this.rpG = -2;
  }
  
  @TargetApi(21)
  protected final void a(ViewGroup paramViewGroup, WindowInsets paramWindowInsets)
  {
    if (this.heA == paramWindowInsets.getSystemWindowInsetTop()) {}
    do
    {
      return;
      this.heA = paramWindowInsets.getSystemWindowInsetTop();
      bac();
      Object localObject = paramViewGroup;
      if ((paramViewGroup instanceof SwipeBackLayout)) {
        localObject = paramViewGroup.getChildAt(0);
      }
      int i = R.h.action_bar_container;
      if (i > 0)
      {
        paramViewGroup = ((View)localObject).findViewById(i);
        if (paramViewGroup != null)
        {
          localObject = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = paramWindowInsets.getSystemWindowInsetTop();
          paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramViewGroup.requestLayout();
        }
      }
    } while (!cdP());
    cdQ();
  }
  
  public boolean aYK()
  {
    if ((getClass().equals(WebViewUI.class)) && (!getIntent().getBooleanExtra("disable_minimize", false))) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.WebViewUI", "enableMinimize class:%s enable:%b", new Object[] { getClass(), Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    if (!com.tencent.mm.compatible.util.d.gF(21)) {
      super.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = android.support.v4.content.b.g(this, paramInt2);
    } while (localDrawable == null);
    if (bad()) {
      localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
    for (;;)
    {
      a(paramInt1, getString(R.l.app_more), localDrawable, paramOnMenuItemClickListener);
      return;
      if ((this.rpg != null) && (!this.rpg.rqY)) {
        localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      } else {
        localDrawable.clearColorFilter();
      }
    }
  }
  
  public final void af(int paramInt, boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.sdk.g.b.zL()))
    {
      setStatusBarColor(paramInt);
      localWindow = getWindow();
      paramInt = localWindow.getDecorView().getSystemUiVisibility();
      if (paramBoolean)
      {
        paramInt |= 0x2000;
        localWindow.getDecorView().setSystemUiVisibility(paramInt);
      }
    }
    while (Build.VERSION.SDK_INT < 21) {
      for (;;)
      {
        Window localWindow;
        return;
        paramInt &= 0xFFFFDFFF;
      }
    }
    int i = paramInt;
    if (paramBoolean) {
      i = e.Cx(paramInt);
    }
    setStatusBarColor(i);
  }
  
  public void ahA()
  {
    if (Build.VERSION.SDK_INT > 10)
    {
      if (this.screenOrientation == -1)
      {
        this.uMo = getSharedPreferences(com.tencent.mm.sdk.platformtools.ae.cqR(), 4).getBoolean("settings_landscape_mode", false);
        if (this.uMo)
        {
          setRequestedOrientation(-1);
          return;
        }
        setRequestedOrientation(1);
        return;
      }
      setRequestedOrientation(this.screenOrientation);
      return;
    }
    super.ahA();
  }
  
  /* Error */
  public void aoX()
  {
    // Byte code:
    //   0: ldc_w 462
    //   3: ldc_w 3167
    //   6: invokestatic 833	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 3169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rbN	Lcom/tencent/mm/plugin/webview/ui/tools/bag/h;
    //   13: new 3171	com/tencent/mm/plugin/webview/ui/tools/bag/p
    //   16: dup
    //   17: aload_0
    //   18: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   21: invokespecial 3173	com/tencent/mm/plugin/webview/ui/tools/bag/p:<init>	(Lcom/tencent/mm/plugin/webview/stub/d;)V
    //   24: invokeinterface 3178 2 0
    //   29: aload_0
    //   30: invokespecial 1874	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ceu	()V
    //   33: aload_0
    //   34: getfield 666	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rpa	Lcom/tencent/mm/plugin/webview/model/b;
    //   37: astore 6
    //   39: aload_0
    //   40: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   43: astore 7
    //   45: aload 7
    //   47: ldc_w 3180
    //   50: invokeinterface 3183 2 0
    //   55: astore 8
    //   57: ldc_w 3185
    //   60: ldc_w 3187
    //   63: iconst_1
    //   64: anewarray 466	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload 8
    //   71: aastore
    //   72: invokestatic 472	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload 8
    //   77: invokestatic 411	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   80: ifeq +2135 -> 2215
    //   83: ldc_w 3185
    //   86: ldc_w 3189
    //   89: invokestatic 813	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: iconst_0
    //   93: istore_3
    //   94: iload_3
    //   95: ifne +2146 -> 2241
    //   98: ldc_w 3185
    //   101: ldc_w 3191
    //   104: invokestatic 833	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: invokevirtual 3194	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cef	()Z
    //   111: ifeq +21 -> 132
    //   114: aload_0
    //   115: invokevirtual 3197	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cee	()Z
    //   118: ifeq +14 -> 132
    //   121: new 3199	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$26
    //   124: dup
    //   125: aload_0
    //   126: invokespecial 3200	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$26:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)V
    //   129: invokestatic 2020	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   132: new 786	android/os/Bundle
    //   135: dup
    //   136: invokespecial 787	android/os/Bundle:<init>	()V
    //   139: astore 8
    //   141: aload_0
    //   142: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   145: ldc_w 3202
    //   148: invokevirtual 2324	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   151: astore 7
    //   153: aload 7
    //   155: astore 6
    //   157: aload 7
    //   159: ifnonnull +12 -> 171
    //   162: new 786	android/os/Bundle
    //   165: dup
    //   166: invokespecial 787	android/os/Bundle:<init>	()V
    //   169: astore 6
    //   171: aload 6
    //   173: ldc_w 1438
    //   176: aload_0
    //   177: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   180: ldc_w 1438
    //   183: iconst_0
    //   184: invokevirtual 1316	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   187: invokevirtual 793	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   190: aload 6
    //   192: ldc_w 1440
    //   195: aload_0
    //   196: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   199: ldc_w 1440
    //   202: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   205: invokevirtual 1328	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: ldc_w 462
    //   211: ldc_w 3204
    //   214: iconst_2
    //   215: anewarray 466	java/lang/Object
    //   218: dup
    //   219: iconst_0
    //   220: aload 6
    //   222: ldc_w 1438
    //   225: iconst_0
    //   226: invokevirtual 2355	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   229: invokestatic 847	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: aastore
    //   233: dup
    //   234: iconst_1
    //   235: aload 6
    //   237: ldc_w 1440
    //   240: ldc_w 518
    //   243: invokevirtual 3206	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   246: aastore
    //   247: invokestatic 472	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: aload 8
    //   252: ldc_w 3202
    //   255: aload 6
    //   257: invokevirtual 3210	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   260: aload 8
    //   262: ldc_w 3212
    //   265: aload_0
    //   266: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   269: ldc_w 3212
    //   272: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   275: invokevirtual 3216	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   278: aload 8
    //   280: ldc_w 3218
    //   283: aload_0
    //   284: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   287: ldc_w 3218
    //   290: invokevirtual 2324	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   293: invokevirtual 3210	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   296: aload 8
    //   298: ldc_w 3220
    //   301: aload_0
    //   302: getfield 504	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:screenOrientation	I
    //   305: invokevirtual 793	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   308: aload_0
    //   309: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   312: bipush 20
    //   314: aload 8
    //   316: aload_0
    //   317: invokevirtual 799	java/lang/Object:hashCode	()I
    //   320: invokeinterface 805 4 0
    //   325: aload_0
    //   326: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   329: ldc_w 869
    //   332: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   335: astore 9
    //   337: aload_0
    //   338: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   341: ldc_w 3222
    //   344: iconst_0
    //   345: invokevirtual 1316	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   348: istore_1
    //   349: aload_0
    //   350: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   353: ldc_w 3224
    //   356: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   359: astore 8
    //   361: aload_0
    //   362: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   365: ldc_w 3226
    //   368: lconst_0
    //   369: invokevirtual 3230	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   372: lstore 4
    //   374: aload_0
    //   375: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   378: ldc_w 3232
    //   381: iconst_0
    //   382: invokevirtual 1316	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   385: istore_2
    //   386: aload_0
    //   387: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   390: ldc_w 3234
    //   393: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   396: astore 11
    //   398: aload_0
    //   399: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   402: ldc_w 3236
    //   405: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   408: astore 10
    //   410: aload_0
    //   411: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   414: ldc_w 2389
    //   417: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   420: astore 12
    //   422: aload_0
    //   423: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   426: ldc_w 3238
    //   429: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   432: astore 13
    //   434: aload_0
    //   435: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   438: ldc_w 3240
    //   441: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   444: astore 14
    //   446: aload 6
    //   448: ldc_w 3242
    //   451: invokevirtual 2330	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   454: astore 15
    //   456: aconst_null
    //   457: astore 7
    //   459: aload_0
    //   460: getfield 959	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:niQ	Lcom/tencent/mm/ui/widget/MMWebView;
    //   463: ifnull +12 -> 475
    //   466: aload_0
    //   467: getfield 959	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:niQ	Lcom/tencent/mm/ui/widget/MMWebView;
    //   470: invokevirtual 3245	com/tencent/mm/ui/widget/MMWebView:getTitle	()Ljava/lang/String;
    //   473: astore 7
    //   475: aload 7
    //   477: astore 6
    //   479: aload 7
    //   481: invokestatic 411	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   484: ifeq +15 -> 499
    //   487: aload_0
    //   488: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   491: ldc_w 3247
    //   494: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   497: astore 6
    //   499: aload 6
    //   501: astore 7
    //   503: aload 6
    //   505: invokestatic 411	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   508: ifeq +15 -> 523
    //   511: aload_0
    //   512: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   515: ldc_w 3249
    //   518: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   521: astore 7
    //   523: aload_0
    //   524: getfield 659	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rfg	Lcom/tencent/mm/plugin/webview/model/an;
    //   527: invokevirtual 3253	com/tencent/mm/plugin/webview/model/an:cch	()Lcom/tencent/mm/plugin/webview/model/an$k;
    //   530: astore 6
    //   532: aload 6
    //   534: aload 9
    //   536: putfield 3258	com/tencent/mm/plugin/webview/model/an$k:username	Ljava/lang/String;
    //   539: aload 6
    //   541: iload_1
    //   542: putfield 3261	com/tencent/mm/plugin/webview/model/an$k:rgQ	I
    //   545: aload 6
    //   547: aload_0
    //   548: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   551: putfield 3262	com/tencent/mm/plugin/webview/model/an$k:caS	Ljava/lang/String;
    //   554: aload 6
    //   556: iload_2
    //   557: putfield 3265	com/tencent/mm/plugin/webview/model/an$k:rgM	I
    //   560: aload 6
    //   562: aload_0
    //   563: aload 9
    //   565: invokespecial 878	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Ts	(Ljava/lang/String;)I
    //   568: putfield 3267	com/tencent/mm/plugin/webview/model/an$k:scene	I
    //   571: aload 6
    //   573: lload 4
    //   575: putfield 3270	com/tencent/mm/plugin/webview/model/an$k:rgL	J
    //   578: aload 6
    //   580: new 3272	com/tencent/mm/a/o
    //   583: dup
    //   584: lload 4
    //   586: invokespecial 3275	com/tencent/mm/a/o:<init>	(J)V
    //   589: invokevirtual 3276	com/tencent/mm/a/o:toString	()Ljava/lang/String;
    //   592: putfield 3279	com/tencent/mm/plugin/webview/model/an$k:rgN	Ljava/lang/String;
    //   595: aload 6
    //   597: aload 8
    //   599: putfield 3282	com/tencent/mm/plugin/webview/model/an$k:rgJ	Ljava/lang/String;
    //   602: aload 6
    //   604: aload 11
    //   606: putfield 3285	com/tencent/mm/plugin/webview/model/an$k:rgK	Ljava/lang/String;
    //   609: aload 6
    //   611: aload 10
    //   613: putfield 3288	com/tencent/mm/plugin/webview/model/an$k:pDx	Ljava/lang/String;
    //   616: aload 6
    //   618: aload 12
    //   620: putfield 3290	com/tencent/mm/plugin/webview/model/an$k:appId	Ljava/lang/String;
    //   623: aload 6
    //   625: aload 13
    //   627: putfield 3293	com/tencent/mm/plugin/webview/model/an$k:rgO	Ljava/lang/String;
    //   630: aload 6
    //   632: aload_0
    //   633: getfield 2626	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rgP	Ljava/lang/String;
    //   636: putfield 3294	com/tencent/mm/plugin/webview/model/an$k:rgP	Ljava/lang/String;
    //   639: aload 6
    //   641: aload 15
    //   643: putfield 3297	com/tencent/mm/plugin/webview/model/an$k:oPO	Ljava/lang/String;
    //   646: aload 6
    //   648: aload 7
    //   650: ldc_w 518
    //   653: invokestatic 3299	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   656: putfield 3301	com/tencent/mm/plugin/webview/model/an$k:title	Ljava/lang/String;
    //   659: aload 6
    //   661: aload 14
    //   663: putfield 3304	com/tencent/mm/plugin/webview/model/an$k:cQO	Ljava/lang/String;
    //   666: aload_0
    //   667: getfield 659	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rfg	Lcom/tencent/mm/plugin/webview/model/an;
    //   670: invokevirtual 3308	com/tencent/mm/plugin/webview/model/an:cci	()Lcom/tencent/mm/plugin/webview/model/an$a;
    //   673: astore 6
    //   675: aload 6
    //   677: aload 10
    //   679: putfield 3311	com/tencent/mm/plugin/webview/model/an$a:pDx	Ljava/lang/String;
    //   682: aload 6
    //   684: aload_0
    //   685: aload 9
    //   687: invokespecial 878	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Ts	(Ljava/lang/String;)I
    //   690: putfield 3312	com/tencent/mm/plugin/webview/model/an$a:scene	I
    //   693: aload_0
    //   694: getfield 659	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rfg	Lcom/tencent/mm/plugin/webview/model/an;
    //   697: invokevirtual 3316	com/tencent/mm/plugin/webview/model/an:cck	()Lcom/tencent/mm/plugin/webview/model/an$c;
    //   700: aload_0
    //   701: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   704: putfield 3319	com/tencent/mm/plugin/webview/model/an$c:caS	Ljava/lang/String;
    //   707: aload_0
    //   708: invokevirtual 3322	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cel	()Z
    //   711: ifeq +47 -> 758
    //   714: new 786	android/os/Bundle
    //   717: dup
    //   718: invokespecial 787	android/os/Bundle:<init>	()V
    //   721: astore 6
    //   723: aload 6
    //   725: ldc_w 3224
    //   728: aload_0
    //   729: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   732: ldc_w 3224
    //   735: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   738: invokevirtual 1328	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   741: aload_0
    //   742: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   745: bipush 29
    //   747: aload 6
    //   749: aload_0
    //   750: invokevirtual 799	java/lang/Object:hashCode	()I
    //   753: invokeinterface 805 4 0
    //   758: aload 8
    //   760: invokestatic 411	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   763: ifne +14 -> 777
    //   766: aload_0
    //   767: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   770: aload 8
    //   772: invokeinterface 3325 2 0
    //   777: aload_0
    //   778: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   781: ldc_w 3327
    //   784: iconst_m1
    //   785: invokevirtual 1316	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   788: istore_1
    //   789: iload_1
    //   790: iconst_m1
    //   791: if_icmpeq +1591 -> 2382
    //   794: ldc_w 462
    //   797: ldc_w 3329
    //   800: iconst_1
    //   801: anewarray 466	java/lang/Object
    //   804: dup
    //   805: iconst_0
    //   806: iload_1
    //   807: invokestatic 847	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   810: aastore
    //   811: invokestatic 472	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   814: aload_0
    //   815: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   818: invokeinterface 3332 1 0
    //   823: aload_0
    //   824: aload_0
    //   825: invokevirtual 3336	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cec	()Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   828: putfield 550	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rbk	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   831: aload_0
    //   832: getfield 550	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rbk	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   835: astore 7
    //   837: aload_0
    //   838: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   841: ldc_w 869
    //   844: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   847: astore 8
    //   849: aload_0
    //   850: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   853: ldc_w 3224
    //   856: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   859: invokestatic 411	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   862: ifne +1584 -> 2446
    //   865: new 586	java/util/HashMap
    //   868: dup
    //   869: invokespecial 587	java/util/HashMap:<init>	()V
    //   872: astore 6
    //   874: aload 6
    //   876: ldc_w 3224
    //   879: aload_0
    //   880: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   883: ldc_w 3224
    //   886: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   889: invokeinterface 930 3 0
    //   894: pop
    //   895: aload 6
    //   897: ldc_w 3338
    //   900: aload_0
    //   901: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   904: ldc_w 3338
    //   907: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   910: invokeinterface 930 3 0
    //   915: pop
    //   916: aload 6
    //   918: ldc_w 3226
    //   921: aload_0
    //   922: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   925: ldc_w 3226
    //   928: lconst_0
    //   929: invokevirtual 3230	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   932: invokestatic 852	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   935: invokeinterface 930 3 0
    //   940: pop
    //   941: aload 6
    //   943: ldc_w 3232
    //   946: aload_0
    //   947: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   950: ldc_w 3232
    //   953: iconst_0
    //   954: invokevirtual 1316	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   957: invokestatic 847	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   960: invokeinterface 930 3 0
    //   965: pop
    //   966: aload 6
    //   968: ldc_w 1290
    //   971: aload_0
    //   972: aload 8
    //   974: invokespecial 878	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Ts	(Ljava/lang/String;)I
    //   977: invokestatic 847	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   980: invokeinterface 930 3 0
    //   985: pop
    //   986: aload 6
    //   988: ldc_w 3327
    //   991: aload_0
    //   992: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   995: ldc_w 3327
    //   998: iconst_0
    //   999: invokevirtual 1316	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1002: invokestatic 847	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1005: invokeinterface 930 3 0
    //   1010: pop
    //   1011: aload 6
    //   1013: ldc_w 3340
    //   1016: aload_0
    //   1017: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1020: ldc_w 3340
    //   1023: iconst_0
    //   1024: invokevirtual 1316	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1027: invokestatic 847	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1030: invokeinterface 930 3 0
    //   1035: pop
    //   1036: aload 6
    //   1038: ldc_w 3342
    //   1041: aload_0
    //   1042: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1045: ldc_w 3342
    //   1048: iconst_0
    //   1049: invokevirtual 1316	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1052: invokestatic 847	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1055: invokeinterface 930 3 0
    //   1060: pop
    //   1061: aload_0
    //   1062: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1065: ldc_w 3344
    //   1068: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1071: invokestatic 411	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   1074: ifne +24 -> 1098
    //   1077: aload 6
    //   1079: ldc_w 3344
    //   1082: aload_0
    //   1083: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1086: ldc_w 3344
    //   1089: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1092: invokeinterface 930 3 0
    //   1097: pop
    //   1098: aload_0
    //   1099: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1102: ldc_w 3346
    //   1105: iconst_m1
    //   1106: invokevirtual 1316	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1109: istore_1
    //   1110: iload_1
    //   1111: iconst_m1
    //   1112: if_icmpeq +1379 -> 2491
    //   1115: ldc_w 462
    //   1118: ldc_w 3348
    //   1121: iconst_1
    //   1122: anewarray 466	java/lang/Object
    //   1125: dup
    //   1126: iconst_0
    //   1127: iload_1
    //   1128: invokestatic 847	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1131: aastore
    //   1132: invokestatic 472	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1135: aload 6
    //   1137: ldc_w 3346
    //   1140: iload_1
    //   1141: invokestatic 847	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1144: invokeinterface 930 3 0
    //   1149: pop
    //   1150: aload 7
    //   1152: aload 6
    //   1154: putfield 3351	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rxG	Ljava/util/Map;
    //   1157: aload_0
    //   1158: invokevirtual 3355	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ced	()Lcom/tencent/mm/plugin/websearch/api/ah;
    //   1161: ifnull +14 -> 1175
    //   1164: aload_0
    //   1165: invokevirtual 3355	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ced	()Lcom/tencent/mm/plugin/websearch/api/ah;
    //   1168: aload_0
    //   1169: getfield 550	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rbk	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   1172: putfield 3361	com/tencent/mm/plugin/websearch/api/ah:qUw	Lcom/tencent/mm/plugin/websearch/api/c;
    //   1175: aload_0
    //   1176: getfield 959	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:niQ	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1179: aload_0
    //   1180: getfield 550	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rbk	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   1183: ldc_w 3363
    //   1186: invokevirtual 3367	com/tencent/mm/ui/widget/MMWebView:addJavascriptInterface	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1189: aload_0
    //   1190: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1193: aload_0
    //   1194: getfield 550	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rbk	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   1197: invokeinterface 3368 2 0
    //   1202: pop
    //   1203: aload_0
    //   1204: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1207: new 94	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$t
    //   1210: dup
    //   1211: aload_0
    //   1212: iconst_0
    //   1213: invokespecial 3371	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$t:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1216: invokeinterface 3368 2 0
    //   1221: pop
    //   1222: aload_0
    //   1223: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1226: new 87	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$q
    //   1229: dup
    //   1230: aload_0
    //   1231: iconst_0
    //   1232: invokespecial 3372	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$q:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1235: invokeinterface 3368 2 0
    //   1240: pop
    //   1241: aload_0
    //   1242: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1245: new 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$e
    //   1248: dup
    //   1249: aload_0
    //   1250: iconst_0
    //   1251: invokespecial 3373	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$e:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1254: invokeinterface 3368 2 0
    //   1259: pop
    //   1260: aload_0
    //   1261: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1264: new 92	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$s
    //   1267: dup
    //   1268: aload_0
    //   1269: iconst_0
    //   1270: invokespecial 3374	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$s:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1273: invokeinterface 3368 2 0
    //   1278: pop
    //   1279: aload_0
    //   1280: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1283: new 98	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$v
    //   1286: dup
    //   1287: aload_0
    //   1288: iconst_0
    //   1289: invokespecial 3375	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$v:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1292: invokeinterface 3368 2 0
    //   1297: pop
    //   1298: aload_0
    //   1299: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1302: new 36	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$a
    //   1305: dup
    //   1306: aload_0
    //   1307: iconst_0
    //   1308: invokespecial 3376	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$a:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1311: invokeinterface 3368 2 0
    //   1316: pop
    //   1317: aload_0
    //   1318: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1321: new 38	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$aa
    //   1324: dup
    //   1325: aload_0
    //   1326: iconst_0
    //   1327: invokespecial 3377	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$aa:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1330: invokeinterface 3368 2 0
    //   1335: pop
    //   1336: aload_0
    //   1337: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1340: new 96	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$u
    //   1343: dup
    //   1344: aload_0
    //   1345: iconst_0
    //   1346: invokespecial 3378	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$u:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1349: invokeinterface 3368 2 0
    //   1354: pop
    //   1355: aload_0
    //   1356: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1359: new 72	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$j
    //   1362: dup
    //   1363: aload_0
    //   1364: iconst_0
    //   1365: invokespecial 3379	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$j:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1368: invokeinterface 3368 2 0
    //   1373: pop
    //   1374: aload_0
    //   1375: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1378: new 54	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$b
    //   1381: dup
    //   1382: aload_0
    //   1383: iconst_0
    //   1384: invokespecial 3380	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$b:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1387: invokeinterface 3368 2 0
    //   1392: pop
    //   1393: aload_0
    //   1394: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1397: new 56	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$c
    //   1400: dup
    //   1401: aload_0
    //   1402: iconst_0
    //   1403: invokespecial 3381	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$c:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1406: invokeinterface 3368 2 0
    //   1411: pop
    //   1412: aload_0
    //   1413: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1416: new 3383	com/tencent/mm/plugin/webview/ui/tools/jsapi/e
    //   1419: dup
    //   1420: aload_0
    //   1421: getfield 959	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:niQ	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1424: aload_0
    //   1425: getfield 550	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rbk	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   1428: invokespecial 3386	com/tencent/mm/plugin/webview/ui/tools/jsapi/e:<init>	(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;)V
    //   1431: invokeinterface 3368 2 0
    //   1436: pop
    //   1437: aload_0
    //   1438: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1441: new 106	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$z
    //   1444: dup
    //   1445: aload_0
    //   1446: iconst_0
    //   1447: invokespecial 3387	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$z:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1450: invokeinterface 3368 2 0
    //   1455: pop
    //   1456: aload_0
    //   1457: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1460: new 100	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$w
    //   1463: dup
    //   1464: aload_0
    //   1465: iconst_0
    //   1466: invokespecial 3388	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$w:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1469: invokeinterface 3368 2 0
    //   1474: pop
    //   1475: aload_0
    //   1476: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1479: new 83	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$o
    //   1482: dup
    //   1483: aload_0
    //   1484: iconst_0
    //   1485: invokespecial 3389	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$o:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1488: invokeinterface 3368 2 0
    //   1493: pop
    //   1494: aload_0
    //   1495: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1498: ldc_w 3391
    //   1501: iconst_0
    //   1502: invokevirtual 1455	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1505: ifeq +22 -> 1527
    //   1508: aload_0
    //   1509: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1512: new 76	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$l
    //   1515: dup
    //   1516: aload_0
    //   1517: iconst_0
    //   1518: invokespecial 3392	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$l:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1521: invokeinterface 3368 2 0
    //   1526: pop
    //   1527: aload_0
    //   1528: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   1531: new 62	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$f
    //   1534: dup
    //   1535: aload_0
    //   1536: iconst_0
    //   1537: invokespecial 3393	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$f:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1540: invokeinterface 3368 2 0
    //   1545: pop
    //   1546: aload_0
    //   1547: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1550: ldc_w 3395
    //   1553: invokeinterface 3183 2 0
    //   1558: iconst_0
    //   1559: invokestatic 3396	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   1562: istore_1
    //   1563: aload_0
    //   1564: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1567: ldc_w 3398
    //   1570: iconst_0
    //   1571: invokevirtual 1455	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1574: istore_3
    //   1575: ldc_w 462
    //   1578: ldc_w 3400
    //   1581: iconst_2
    //   1582: anewarray 466	java/lang/Object
    //   1585: dup
    //   1586: iconst_0
    //   1587: iload_1
    //   1588: invokestatic 847	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1591: aastore
    //   1592: dup
    //   1593: iconst_1
    //   1594: iload_3
    //   1595: invokestatic 1783	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1598: aastore
    //   1599: invokestatic 472	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1602: iload_1
    //   1603: iconst_1
    //   1604: if_icmpeq +7 -> 1611
    //   1607: iload_3
    //   1608: ifeq +11 -> 1619
    //   1611: aload_0
    //   1612: getfield 707	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rpn	Lcom/tencent/mm/plugin/webview/ui/tools/g;
    //   1615: iconst_1
    //   1616: invokevirtual 3401	com/tencent/mm/plugin/webview/ui/tools/g:lh	(Z)V
    //   1619: aload_0
    //   1620: ldc_w 3403
    //   1623: iconst_4
    //   1624: invokevirtual 1242	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1627: ldc_w 3405
    //   1630: iconst_0
    //   1631: invokeinterface 3156 3 0
    //   1636: ifeq +11 -> 1647
    //   1639: aload_0
    //   1640: getfield 707	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rpn	Lcom/tencent/mm/plugin/webview/ui/tools/g;
    //   1643: iconst_1
    //   1644: invokevirtual 3401	com/tencent/mm/plugin/webview/ui/tools/g:lh	(Z)V
    //   1647: aload_0
    //   1648: aload_0
    //   1649: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1652: ldc_w 3407
    //   1655: invokeinterface 3183 2 0
    //   1660: iconst_0
    //   1661: invokestatic 3396	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   1664: putfield 591	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:roq	I
    //   1667: ldc_w 462
    //   1670: ldc_w 3409
    //   1673: iconst_1
    //   1674: anewarray 466	java/lang/Object
    //   1677: dup
    //   1678: iconst_0
    //   1679: aload_0
    //   1680: getfield 591	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:roq	I
    //   1683: invokestatic 847	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1686: aastore
    //   1687: invokestatic 472	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1690: aload_0
    //   1691: getfield 959	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:niQ	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1694: invokevirtual 1690	com/tencent/mm/ui/widget/MMWebView:getIsX5Kernel	()Z
    //   1697: aload_0
    //   1698: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   1701: invokestatic 2106	com/tencent/mm/sdk/platformtools/bk:pm	(Ljava/lang/String;)Ljava/lang/String;
    //   1704: ldc_w 1513
    //   1707: invokevirtual 1379	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1710: invokestatic 2987	com/tencent/mm/plugin/webview/model/an:M	(ZZ)V
    //   1713: aload_0
    //   1714: getfield 959	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:niQ	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1717: invokevirtual 1690	com/tencent/mm/ui/widget/MMWebView:getIsX5Kernel	()Z
    //   1720: ifeq +862 -> 2582
    //   1723: bipush 7
    //   1725: invokestatic 3414	com/tencent/mm/pluginsdk/ui/tools/k:if	(I)V
    //   1728: getstatic 884	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   1731: bipush 64
    //   1733: bipush 64
    //   1735: iconst_1
    //   1736: iconst_0
    //   1737: iconst_1
    //   1738: iconst_1
    //   1739: iconst_0
    //   1740: invokevirtual 3417	com/tencent/mm/plugin/report/service/h:a	(IIIIIIZ)V
    //   1743: aload_0
    //   1744: new 3419	com/tencent/mm/plugin/webview/ui/tools/jsapi/f
    //   1747: dup
    //   1748: aload_0
    //   1749: getfield 959	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:niQ	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1752: aload_0
    //   1753: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1756: aload_0
    //   1757: getfield 550	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rbk	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   1760: new 16	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$27
    //   1763: dup
    //   1764: aload_0
    //   1765: invokespecial 3420	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$27:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)V
    //   1768: aload_0
    //   1769: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1772: ldc_w 3422
    //   1775: iconst_0
    //   1776: invokevirtual 1455	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1779: aload_0
    //   1780: invokevirtual 3194	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cef	()Z
    //   1783: invokespecial 3425	com/tencent/mm/plugin/webview/ui/tools/jsapi/f:<init>	(Lcom/tencent/xweb/WebView;Lcom/tencent/mm/plugin/webview/stub/d;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/f$a;ZZ)V
    //   1786: putfield 3427	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ror	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/f;
    //   1789: aload_0
    //   1790: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1793: ldc_w 3429
    //   1796: invokeinterface 3183 2 0
    //   1801: iconst_0
    //   1802: invokestatic 3396	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   1805: istore_1
    //   1806: ldc_w 462
    //   1809: ldc_w 3431
    //   1812: iconst_1
    //   1813: anewarray 466	java/lang/Object
    //   1816: dup
    //   1817: iconst_0
    //   1818: iload_1
    //   1819: invokestatic 847	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1822: aastore
    //   1823: invokestatic 472	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1826: iload_1
    //   1827: ifne +51 -> 1878
    //   1830: aload_0
    //   1831: ldc_w 3403
    //   1834: iconst_4
    //   1835: invokevirtual 1242	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1838: ldc_w 3433
    //   1841: iconst_1
    //   1842: invokeinterface 3156 3 0
    //   1847: ifeq +31 -> 1878
    //   1850: aload_0
    //   1851: invokevirtual 3436	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cey	()Z
    //   1854: ifeq +24 -> 1878
    //   1857: aload_0
    //   1858: getfield 550	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rbk	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   1861: invokevirtual 3439	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:cfX	()V
    //   1864: aload_0
    //   1865: getfield 676	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rph	Lcom/tencent/mm/plugin/webview/model/ak;
    //   1868: aload_0
    //   1869: getfield 550	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rbk	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   1872: getfield 938	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rxJ	Ljava/lang/String;
    //   1875: putfield 3442	com/tencent/mm/plugin/webview/model/ak:rgf	Ljava/lang/String;
    //   1878: aload_0
    //   1879: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1882: ldc_w 2112
    //   1885: iconst_0
    //   1886: invokevirtual 1455	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1889: ifeq +742 -> 2631
    //   1892: aload_0
    //   1893: iconst_0
    //   1894: invokevirtual 3056	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:lj	(Z)V
    //   1897: ldc_w 462
    //   1900: ldc_w 3444
    //   1903: iconst_1
    //   1904: anewarray 466	java/lang/Object
    //   1907: dup
    //   1908: iconst_0
    //   1909: invokestatic 2245	java/lang/System:currentTimeMillis	()J
    //   1912: invokestatic 852	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1915: aastore
    //   1916: invokestatic 855	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1919: aload_0
    //   1920: aload_0
    //   1921: invokestatic 3450	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   1924: getstatic 3455	com/tencent/mm/R$i:web_view_font_chooser	I
    //   1927: aconst_null
    //   1928: invokevirtual 3459	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1931: putfield 904	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnw	Landroid/view/View;
    //   1934: aload_0
    //   1935: getfield 904	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnw	Landroid/view/View;
    //   1938: getstatic 909	com/tencent/mm/R$h:font_chooser_view	I
    //   1941: invokevirtual 915	android/view/View:findViewById	(I)Landroid/view/View;
    //   1944: checkcast 917	com/tencent/mm/plugin/webview/ui/tools/widget/FontChooserView
    //   1947: astore 6
    //   1949: aload_0
    //   1950: getfield 904	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnw	Landroid/view/View;
    //   1953: getstatic 3462	com/tencent/mm/R$h:font_chooser_close	I
    //   1956: invokevirtual 915	android/view/View:findViewById	(I)Landroid/view/View;
    //   1959: astore 7
    //   1961: aload_0
    //   1962: getfield 959	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:niQ	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1965: invokevirtual 1690	com/tencent/mm/ui/widget/MMWebView:getIsX5Kernel	()Z
    //   1968: ifne +22 -> 1990
    //   1971: aload 7
    //   1973: iconst_0
    //   1974: invokevirtual 1111	android/view/View:setVisibility	(I)V
    //   1977: aload 7
    //   1979: new 3464	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$62
    //   1982: dup
    //   1983: aload_0
    //   1984: invokespecial 3465	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$62:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)V
    //   1987: invokevirtual 3466	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1990: aload 6
    //   1992: new 74	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$k
    //   1995: dup
    //   1996: aload_0
    //   1997: iconst_0
    //   1998: invokespecial 3467	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$k:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   2001: invokevirtual 3471	com/tencent/mm/plugin/webview/ui/tools/widget/FontChooserView:setOnChangeListener	(Lcom/tencent/mm/plugin/webview/ui/tools/widget/FontChooserView$a;)V
    //   2004: new 3473	android/widget/FrameLayout$LayoutParams
    //   2007: dup
    //   2008: iconst_m1
    //   2009: bipush 254
    //   2011: bipush 80
    //   2013: invokespecial 3476	android/widget/FrameLayout$LayoutParams:<init>	(III)V
    //   2016: astore 6
    //   2018: aload_0
    //   2019: getfield 904	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnw	Landroid/view/View;
    //   2022: aload 6
    //   2024: invokevirtual 1063	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2027: aload_0
    //   2028: getfield 3478	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rny	Landroid/widget/FrameLayout;
    //   2031: aload_0
    //   2032: getfield 904	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnw	Landroid/view/View;
    //   2035: invokevirtual 3483	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   2038: aload_0
    //   2039: getfield 904	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnw	Landroid/view/View;
    //   2042: bipush 8
    //   2044: invokevirtual 1111	android/view/View:setVisibility	(I)V
    //   2047: iconst_2
    //   2048: istore_2
    //   2049: iload_2
    //   2050: istore_1
    //   2051: aload_0
    //   2052: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   2055: invokeinterface 1434 1 0
    //   2060: ifeq +22 -> 2082
    //   2063: aload_0
    //   2064: invokevirtual 3486	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cer	()Z
    //   2067: ifne +10 -> 2077
    //   2070: aload_0
    //   2071: invokevirtual 3489	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ces	()Z
    //   2074: ifeq +606 -> 2680
    //   2077: aload_0
    //   2078: invokespecial 1033	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cet	()I
    //   2081: istore_1
    //   2082: iload_1
    //   2083: ifle +10 -> 2093
    //   2086: iload_1
    //   2087: istore_2
    //   2088: iload_1
    //   2089: iconst_4
    //   2090: if_icmple +5 -> 2095
    //   2093: iconst_2
    //   2094: istore_2
    //   2095: aload_0
    //   2096: iload_2
    //   2097: invokespecial 2481	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CJ	(I)V
    //   2100: aload_0
    //   2101: iload_2
    //   2102: invokespecial 1630	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CK	(I)V
    //   2105: aload_0
    //   2106: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   2109: aload_0
    //   2110: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   2113: iconst_1
    //   2114: aconst_null
    //   2115: invokeinterface 2928 4 0
    //   2120: pop
    //   2121: aload_0
    //   2122: getfield 554	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnZ	Ljava/util/List;
    //   2125: invokeinterface 2437 1 0
    //   2130: astore 6
    //   2132: aload 6
    //   2134: invokeinterface 490 1 0
    //   2139: ifeq +667 -> 2806
    //   2142: aload 6
    //   2144: invokeinterface 496 1 0
    //   2149: checkcast 1847	com/tencent/mm/plugin/webview/ui/tools/jsapi/b
    //   2152: astore 7
    //   2154: aload 7
    //   2156: aload_0
    //   2157: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   2160: invokestatic 2935	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/b;Ljava/lang/String;)Z
    //   2163: ifeq -31 -> 2132
    //   2166: aload 7
    //   2168: aload_0
    //   2169: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   2172: invokeinterface 2943 2 0
    //   2177: istore_3
    //   2178: ldc_w 462
    //   2181: new 434	java/lang/StringBuilder
    //   2184: dup
    //   2185: ldc_w 3491
    //   2188: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2191: iload_3
    //   2192: invokevirtual 1429	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2195: ldc_w 2947
    //   2198: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2201: aload_0
    //   2202: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   2205: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2208: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2211: invokestatic 833	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2214: return
    //   2215: aload 8
    //   2217: ldc_w 3493
    //   2220: invokevirtual 3496	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2223: istore_3
    //   2224: goto -2130 -> 94
    //   2227: astore 6
    //   2229: ldc_w 3185
    //   2232: ldc_w 3498
    //   2235: invokestatic 813	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2238: goto -2131 -> 107
    //   2241: aload 7
    //   2243: ldc_w 3500
    //   2246: invokeinterface 3183 2 0
    //   2251: astore 8
    //   2253: aload 8
    //   2255: invokestatic 411	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   2258: ifeq +35 -> 2293
    //   2261: ldc_w 3185
    //   2264: ldc_w 3502
    //   2267: invokestatic 813	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2270: goto -2163 -> 107
    //   2273: astore 6
    //   2275: ldc_w 3185
    //   2278: aload 6
    //   2280: ldc_w 518
    //   2283: iconst_0
    //   2284: anewarray 466	java/lang/Object
    //   2287: invokestatic 892	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2290: goto -2183 -> 107
    //   2293: aload 6
    //   2295: invokevirtual 3506	com/tencent/mm/plugin/webview/model/b:DS	()Lcom/tencent/mm/sdk/platformtools/ai;
    //   2298: new 3508	com/tencent/mm/plugin/webview/model/b$1
    //   2301: dup
    //   2302: aload 6
    //   2304: aload 8
    //   2306: aload 7
    //   2308: invokespecial 3511	com/tencent/mm/plugin/webview/model/b$1:<init>	(Lcom/tencent/mm/plugin/webview/model/b;Ljava/lang/String;Lcom/tencent/mm/plugin/webview/stub/d;)V
    //   2311: invokevirtual 3514	com/tencent/mm/sdk/platformtools/ai:O	(Ljava/lang/Runnable;)I
    //   2314: pop
    //   2315: goto -2208 -> 107
    //   2318: astore 7
    //   2320: ldc_w 462
    //   2323: new 434	java/lang/StringBuilder
    //   2326: dup
    //   2327: ldc_w 3516
    //   2330: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2333: aload 7
    //   2335: invokevirtual 2127	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   2338: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2341: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2344: invokestatic 813	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2347: goto -2022 -> 325
    //   2350: astore 6
    //   2352: ldc_w 462
    //   2355: new 434	java/lang/StringBuilder
    //   2358: dup
    //   2359: ldc_w 3518
    //   2362: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2365: aload 6
    //   2367: invokevirtual 810	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2370: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2373: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2376: invokestatic 813	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2379: goto -1602 -> 777
    //   2382: aload_0
    //   2383: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   2386: invokeinterface 3521 1 0
    //   2391: istore_1
    //   2392: iload_1
    //   2393: iconst_m1
    //   2394: if_icmpeq -1580 -> 814
    //   2397: ldc_w 462
    //   2400: ldc_w 3523
    //   2403: iconst_1
    //   2404: anewarray 466	java/lang/Object
    //   2407: dup
    //   2408: iconst_0
    //   2409: iload_1
    //   2410: invokestatic 847	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2413: aastore
    //   2414: invokestatic 472	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2417: aload_0
    //   2418: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   2421: ldc_w 3327
    //   2424: iload_1
    //   2425: invokevirtual 3526	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2428: pop
    //   2429: goto -1615 -> 814
    //   2432: astore 6
    //   2434: ldc_w 462
    //   2437: ldc_w 3528
    //   2440: invokestatic 813	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2443: goto -1629 -> 814
    //   2446: aload 8
    //   2448: invokestatic 411	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   2451: ifne +28 -> 2479
    //   2454: new 586	java/util/HashMap
    //   2457: dup
    //   2458: invokespecial 587	java/util/HashMap:<init>	()V
    //   2461: astore 6
    //   2463: aload 6
    //   2465: ldc_w 3224
    //   2468: aload 8
    //   2470: invokeinterface 930 3 0
    //   2475: pop
    //   2476: goto -1560 -> 916
    //   2479: new 586	java/util/HashMap
    //   2482: dup
    //   2483: invokespecial 587	java/util/HashMap:<init>	()V
    //   2486: astore 6
    //   2488: goto -1572 -> 916
    //   2491: iconst_3
    //   2492: istore_1
    //   2493: ldc_w 462
    //   2496: ldc_w 3530
    //   2499: iconst_1
    //   2500: anewarray 466	java/lang/Object
    //   2503: dup
    //   2504: iconst_0
    //   2505: iconst_3
    //   2506: invokestatic 847	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2509: aastore
    //   2510: invokestatic 472	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2513: goto -1378 -> 1135
    //   2516: astore 6
    //   2518: ldc_w 462
    //   2521: new 434	java/lang/StringBuilder
    //   2524: dup
    //   2525: ldc_w 3532
    //   2528: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2531: aload 6
    //   2533: invokevirtual 810	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2536: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2539: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2542: invokestatic 1308	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2545: iconst_0
    //   2546: istore_1
    //   2547: goto -984 -> 1563
    //   2550: astore 6
    //   2552: ldc_w 462
    //   2555: new 434	java/lang/StringBuilder
    //   2558: dup
    //   2559: ldc_w 3534
    //   2562: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2565: aload 6
    //   2567: invokevirtual 810	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2570: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2573: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2576: invokestatic 1308	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2579: goto -912 -> 1667
    //   2582: getstatic 884	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   2585: ldc2_w 3535
    //   2588: lconst_0
    //   2589: lconst_1
    //   2590: iconst_0
    //   2591: invokevirtual 2613	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   2594: goto -851 -> 1743
    //   2597: astore 6
    //   2599: ldc_w 462
    //   2602: new 434	java/lang/StringBuilder
    //   2605: dup
    //   2606: ldc_w 3538
    //   2609: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2612: aload 6
    //   2614: invokevirtual 810	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2617: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2620: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2623: invokestatic 1308	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2626: iconst_0
    //   2627: istore_1
    //   2628: goto -822 -> 1806
    //   2631: aload_0
    //   2632: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   2635: ldc_w 2114
    //   2638: iconst_1
    //   2639: invokevirtual 1455	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2642: istore_3
    //   2643: aload_0
    //   2644: iload_3
    //   2645: invokevirtual 3056	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:lj	(Z)V
    //   2648: ldc_w 462
    //   2651: ldc_w 3540
    //   2654: iconst_2
    //   2655: anewarray 466	java/lang/Object
    //   2658: dup
    //   2659: iconst_0
    //   2660: invokestatic 2245	java/lang/System:currentTimeMillis	()J
    //   2663: invokestatic 852	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2666: aastore
    //   2667: dup
    //   2668: iconst_1
    //   2669: iload_3
    //   2670: invokestatic 1783	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2673: aastore
    //   2674: invokestatic 855	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2677: goto -758 -> 1919
    //   2680: aload_0
    //   2681: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   2684: invokestatic 411	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   2687: ifne +36 -> 2723
    //   2690: getstatic 2496	com/tencent/mm/plugin/webview/a:qYo	Ljava/util/regex/Pattern;
    //   2693: aload_0
    //   2694: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   2697: invokevirtual 1266	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   2700: invokevirtual 2238	java/util/regex/Matcher:matches	()Z
    //   2703: ifeq +20 -> 2723
    //   2706: aload_0
    //   2707: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   2710: sipush 16388
    //   2713: iconst_0
    //   2714: invokeinterface 3544 3 0
    //   2719: istore_1
    //   2720: goto -638 -> 2082
    //   2723: aload_0
    //   2724: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   2727: sipush 16384
    //   2730: iconst_0
    //   2731: invokeinterface 3544 3 0
    //   2736: istore_1
    //   2737: goto -655 -> 2082
    //   2740: astore 6
    //   2742: ldc_w 462
    //   2745: new 434	java/lang/StringBuilder
    //   2748: dup
    //   2749: ldc_w 3546
    //   2752: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2755: aload 6
    //   2757: invokevirtual 810	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2760: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2763: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2766: invokestatic 1308	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2769: iload_2
    //   2770: istore_1
    //   2771: goto -689 -> 2082
    //   2774: astore 6
    //   2776: ldc_w 462
    //   2779: new 434	java/lang/StringBuilder
    //   2782: dup
    //   2783: ldc_w 3548
    //   2786: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2789: aload 6
    //   2791: invokevirtual 810	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2794: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2797: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2800: invokestatic 1308	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2803: goto -682 -> 2121
    //   2806: aload_0
    //   2807: invokevirtual 3551	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cdz	()Z
    //   2810: ifeq +13 -> 2823
    //   2813: ldc_w 462
    //   2816: ldc_w 3553
    //   2819: invokestatic 1308	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2822: return
    //   2823: aload_0
    //   2824: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   2827: ldc_w 3555
    //   2830: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2833: astore 7
    //   2835: aload 7
    //   2837: ifnull +205 -> 3042
    //   2840: ldc_w 462
    //   2843: aload 7
    //   2845: invokestatic 833	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2848: aload 7
    //   2850: astore 6
    //   2852: aload_0
    //   2853: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   2856: ldc_w 3557
    //   2859: iconst_1
    //   2860: invokevirtual 1455	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2863: ifeq +16 -> 2879
    //   2866: aload_0
    //   2867: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   2870: aload 7
    //   2872: invokeinterface 3560 2 0
    //   2877: astore 6
    //   2879: aload_0
    //   2880: getfield 959	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:niQ	Lcom/tencent/mm/ui/widget/MMWebView;
    //   2883: aload_0
    //   2884: getfield 722	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rpp	Landroid/view/View$OnLongClickListener;
    //   2887: invokevirtual 3564	com/tencent/mm/ui/widget/MMWebView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   2890: aload_0
    //   2891: iconst_1
    //   2892: putfield 3566	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rpo	Z
    //   2895: aload_0
    //   2896: getfield 959	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:niQ	Lcom/tencent/mm/ui/widget/MMWebView;
    //   2899: invokevirtual 963	com/tencent/mm/ui/widget/MMWebView:getSettings	()Lcom/tencent/xweb/n;
    //   2902: iconst_0
    //   2903: invokevirtual 3569	com/tencent/xweb/n:setUseWideViewPort	(Z)V
    //   2906: aload_0
    //   2907: getfield 959	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:niQ	Lcom/tencent/mm/ui/widget/MMWebView;
    //   2910: invokevirtual 963	com/tencent/mm/ui/widget/MMWebView:getSettings	()Lcom/tencent/xweb/n;
    //   2913: iconst_0
    //   2914: invokevirtual 3572	com/tencent/xweb/n:setLoadWithOverviewMode	(Z)V
    //   2917: aload_0
    //   2918: aconst_null
    //   2919: invokespecial 2509	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Tv	(Ljava/lang/String;)Z
    //   2922: ifne +67 -> 2989
    //   2925: ldc_w 462
    //   2928: new 434	java/lang/StringBuilder
    //   2931: dup
    //   2932: ldc_w 3574
    //   2935: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2938: aconst_null
    //   2939: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2942: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2945: invokestatic 3038	com/tencent/mm/sdk/platformtools/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   2948: aload_0
    //   2949: invokespecial 1133	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cdT	()V
    //   2952: return
    //   2953: astore 6
    //   2955: ldc_w 462
    //   2958: new 434	java/lang/StringBuilder
    //   2961: dup
    //   2962: ldc_w 3576
    //   2965: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2968: aload 6
    //   2970: invokevirtual 810	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2973: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2976: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2979: invokestatic 1308	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2982: aload 7
    //   2984: astore 6
    //   2986: goto -107 -> 2879
    //   2989: aload_0
    //   2990: getfield 959	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:niQ	Lcom/tencent/mm/ui/widget/MMWebView;
    //   2993: invokevirtual 963	com/tencent/mm/ui/widget/MMWebView:getSettings	()Lcom/tencent/xweb/n;
    //   2996: iconst_0
    //   2997: invokevirtual 3019	com/tencent/xweb/n:setJavaScriptEnabled	(Z)V
    //   3000: aload_0
    //   3001: getfield 959	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:niQ	Lcom/tencent/mm/ui/widget/MMWebView;
    //   3004: aconst_null
    //   3005: aload 6
    //   3007: ldc_w 3021
    //   3010: ldc_w 1903
    //   3013: aconst_null
    //   3014: invokevirtual 3580	com/tencent/mm/ui/widget/MMWebView:loadDataWithBaseURL	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3017: ldc_w 462
    //   3020: new 434	java/lang/StringBuilder
    //   3023: dup
    //   3024: ldc_w 3582
    //   3027: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3030: aload 6
    //   3032: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3035: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3038: invokestatic 833	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3041: return
    //   3042: aload_0
    //   3043: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3046: invokestatic 411	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   3049: ifeq +8 -> 3057
    //   3052: aload_0
    //   3053: iconst_0
    //   3054: invokevirtual 3585	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:hX	(Z)V
    //   3057: aload_0
    //   3058: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3061: ifnull +13 -> 3074
    //   3064: aload_0
    //   3065: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3068: invokevirtual 1158	java/lang/String:length	()I
    //   3071: ifne +13 -> 3084
    //   3074: ldc_w 462
    //   3077: ldc_w 3587
    //   3080: invokestatic 813	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3083: return
    //   3084: aload_0
    //   3085: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3088: invokestatic 1374	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   3091: astore 6
    //   3093: aload 6
    //   3095: ifnonnull +13 -> 3108
    //   3098: ldc_w 462
    //   3101: ldc_w 3589
    //   3104: invokestatic 813	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3107: return
    //   3108: aload 6
    //   3110: invokevirtual 3592	android/net/Uri:getScheme	()Ljava/lang/String;
    //   3113: ifnonnull +191 -> 3304
    //   3116: aload_0
    //   3117: new 434	java/lang/StringBuilder
    //   3120: dup
    //   3121: ldc_w 1511
    //   3124: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3127: aload_0
    //   3128: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3131: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3134: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3137: putfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3140: aload_0
    //   3141: new 78	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$m
    //   3144: dup
    //   3145: aload_0
    //   3146: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3149: invokespecial 559	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$m:<init>	(Ljava/lang/String;)V
    //   3152: putfield 561	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:roh	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$m;
    //   3155: aload_0
    //   3156: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   3159: ldc_w 3593
    //   3162: aconst_null
    //   3163: invokeinterface 1331 3 0
    //   3168: astore 6
    //   3170: aload 6
    //   3172: ifnull +43 -> 3215
    //   3175: aload 6
    //   3177: ldc_w 3595
    //   3180: invokevirtual 2330	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3183: ifnull +32 -> 3215
    //   3186: aload_0
    //   3187: aload 6
    //   3189: ldc_w 3595
    //   3192: invokevirtual 2330	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3195: ldc_w 3597
    //   3198: invokevirtual 3600	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3201: putfield 3602	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rpq	[Ljava/lang/String;
    //   3204: aload_0
    //   3205: getfield 561	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:roh	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$m;
    //   3208: aload_0
    //   3209: getfield 3602	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rpq	[Ljava/lang/String;
    //   3212: putfield 3603	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$m:rpq	[Ljava/lang/String;
    //   3215: aload_0
    //   3216: getfield 528	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnK	Z
    //   3219: ifne +17 -> 3236
    //   3222: aload_0
    //   3223: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGo	Lcom/tencent/mm/plugin/webview/ui/tools/f;
    //   3226: aload_0
    //   3227: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3230: invokevirtual 2534	com/tencent/mm/plugin/webview/ui/tools/f:has	(Ljava/lang/String;)Z
    //   3233: ifeq +262 -> 3495
    //   3236: ldc_w 462
    //   3239: new 434	java/lang/StringBuilder
    //   3242: dup
    //   3243: ldc_w 3605
    //   3246: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3249: aload_0
    //   3250: getfield 528	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rnK	Z
    //   3253: invokevirtual 1429	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3256: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3259: invokestatic 833	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3262: aload_0
    //   3263: aload_0
    //   3264: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3267: invokespecial 2509	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Tv	(Ljava/lang/String;)Z
    //   3270: ifne +171 -> 3441
    //   3273: ldc_w 462
    //   3276: new 434	java/lang/StringBuilder
    //   3279: dup
    //   3280: ldc_w 3607
    //   3283: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3286: aload_0
    //   3287: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3290: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3293: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3296: invokestatic 3038	com/tencent/mm/sdk/platformtools/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   3299: aload_0
    //   3300: invokespecial 1133	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cdT	()V
    //   3303: return
    //   3304: aload 6
    //   3306: invokevirtual 3592	android/net/Uri:getScheme	()Ljava/lang/String;
    //   3309: ldc_w 1381
    //   3312: invokevirtual 1379	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3315: ifne -175 -> 3140
    //   3318: ldc_w 462
    //   3321: new 434	java/lang/StringBuilder
    //   3324: dup
    //   3325: ldc_w 3609
    //   3328: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3331: aload 6
    //   3333: invokevirtual 3592	android/net/Uri:getScheme	()Ljava/lang/String;
    //   3336: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3339: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3342: invokestatic 833	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3345: aload_0
    //   3346: aload_0
    //   3347: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3350: invokespecial 2509	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Tv	(Ljava/lang/String;)Z
    //   3353: ifne +34 -> 3387
    //   3356: ldc_w 462
    //   3359: new 434	java/lang/StringBuilder
    //   3362: dup
    //   3363: ldc_w 3611
    //   3366: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3369: aload_0
    //   3370: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3373: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3376: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3379: invokestatic 3038	com/tencent/mm/sdk/platformtools/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   3382: aload_0
    //   3383: invokespecial 1133	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cdT	()V
    //   3386: return
    //   3387: aload_0
    //   3388: invokevirtual 3194	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cef	()Z
    //   3391: ifne +14 -> 3405
    //   3394: aload_0
    //   3395: aload_0
    //   3396: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3399: aconst_null
    //   3400: iconst_0
    //   3401: invokevirtual 1646	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Ljava/lang/String;Ljava/util/Map;Z)V
    //   3404: return
    //   3405: ldc_w 462
    //   3408: ldc_w 3613
    //   3411: invokestatic 833	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3414: return
    //   3415: astore 6
    //   3417: ldc_w 462
    //   3420: ldc_w 3615
    //   3423: iconst_1
    //   3424: anewarray 466	java/lang/Object
    //   3427: dup
    //   3428: iconst_0
    //   3429: aload 6
    //   3431: invokevirtual 810	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3434: aastore
    //   3435: invokestatic 1411	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3438: goto -223 -> 3215
    //   3441: aload_0
    //   3442: aload_0
    //   3443: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3446: invokevirtual 1756	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Tl	(Ljava/lang/String;)Z
    //   3449: ifeq +35 -> 3484
    //   3452: aload_0
    //   3453: iconst_1
    //   3454: putfield 629	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:roL	Z
    //   3457: aload_0
    //   3458: getfield 2875	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rns	Lcom/tencent/mm/ui/base/MMFalseProgressBar;
    //   3461: invokevirtual 2878	com/tencent/mm/ui/base/MMFalseProgressBar:finish	()V
    //   3464: aload_0
    //   3465: getfield 2875	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rns	Lcom/tencent/mm/ui/base/MMFalseProgressBar;
    //   3468: bipush 8
    //   3470: invokevirtual 3616	com/tencent/mm/ui/base/MMFalseProgressBar:setVisibility	(I)V
    //   3473: aload_0
    //   3474: aload_0
    //   3475: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3478: aconst_null
    //   3479: iconst_1
    //   3480: invokevirtual 1646	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Ljava/lang/String;Ljava/util/Map;Z)V
    //   3483: return
    //   3484: aload_0
    //   3485: aload_0
    //   3486: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3489: aconst_null
    //   3490: iconst_0
    //   3491: invokevirtual 1646	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Ljava/lang/String;Ljava/util/Map;Z)V
    //   3494: return
    //   3495: aload_0
    //   3496: aload_0
    //   3497: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3500: invokevirtual 1756	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Tl	(Ljava/lang/String;)Z
    //   3503: ifeq +42 -> 3545
    //   3506: aload_0
    //   3507: aload_0
    //   3508: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3511: aconst_null
    //   3512: iconst_1
    //   3513: invokevirtual 1646	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Ljava/lang/String;Ljava/util/Map;Z)V
    //   3516: aload_0
    //   3517: aload_0
    //   3518: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3521: putfield 742	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rpw	Ljava/lang/String;
    //   3524: aload_0
    //   3525: iconst_1
    //   3526: putfield 629	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:roL	Z
    //   3529: aload_0
    //   3530: getfield 2875	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rns	Lcom/tencent/mm/ui/base/MMFalseProgressBar;
    //   3533: invokevirtual 2878	com/tencent/mm/ui/base/MMFalseProgressBar:finish	()V
    //   3536: aload_0
    //   3537: getfield 2875	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rns	Lcom/tencent/mm/ui/base/MMFalseProgressBar;
    //   3540: bipush 8
    //   3542: invokevirtual 3616	com/tencent/mm/ui/base/MMFalseProgressBar:setVisibility	(I)V
    //   3545: aload_0
    //   3546: getfield 652	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:roY	Z
    //   3549: ifne -1335 -> 2214
    //   3552: aload_0
    //   3553: getfield 654	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:roZ	Z
    //   3556: ifne -1342 -> 2214
    //   3559: aload_0
    //   3560: invokevirtual 1505	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:isFinishing	()Z
    //   3563: ifne -1349 -> 2214
    //   3566: ldc_w 462
    //   3569: ldc_w 3618
    //   3572: invokestatic 833	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3575: aload_0
    //   3576: aload_0
    //   3577: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3580: iconst_0
    //   3581: invokevirtual 3622	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bo	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$x;
    //   3584: pop
    //   3585: ldc_w 462
    //   3588: new 434	java/lang/StringBuilder
    //   3591: dup
    //   3592: ldc_w 3624
    //   3595: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3598: aload_0
    //   3599: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   3602: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3605: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3608: invokestatic 833	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3611: return
    //   3612: astore 6
    //   3614: goto -2856 -> 758
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3617	0	this	WebViewUI
    //   348	2423	1	i	int
    //   385	2385	2	j	int
    //   93	2577	3	bool	boolean
    //   372	213	4	l	long
    //   37	2106	6	localObject1	Object
    //   2227	1	6	localException1	Exception
    //   2273	30	6	localException2	Exception
    //   2350	16	6	localException3	Exception
    //   2432	1	6	localException4	Exception
    //   2461	26	6	localHashMap	HashMap
    //   2516	16	6	localException5	Exception
    //   2550	16	6	localException6	Exception
    //   2597	16	6	localException7	Exception
    //   2740	16	6	localException8	Exception
    //   2774	16	6	localException9	Exception
    //   2850	28	6	localObject2	Object
    //   2953	16	6	localException10	Exception
    //   2984	348	6	localObject3	Object
    //   3415	15	6	localException11	Exception
    //   3612	1	6	localException12	Exception
    //   43	2264	7	localObject4	Object
    //   2318	16	7	localRemoteException	RemoteException
    //   2833	150	7	str1	String
    //   55	2414	8	localObject5	Object
    //   335	351	9	str2	String
    //   408	270	10	str3	String
    //   396	209	11	str4	String
    //   420	199	12	str5	String
    //   432	194	13	str6	String
    //   444	218	14	str7	String
    //   454	188	15	str8	String
    // Exception table:
    //   from	to	target	type
    //   45	92	2227	java/lang/Exception
    //   98	107	2227	java/lang/Exception
    //   2215	2224	2227	java/lang/Exception
    //   2241	2270	2273	java/lang/Exception
    //   2293	2315	2273	java/lang/Exception
    //   308	325	2318	android/os/RemoteException
    //   766	777	2350	java/lang/Exception
    //   777	789	2432	java/lang/Exception
    //   794	814	2432	java/lang/Exception
    //   2382	2392	2432	java/lang/Exception
    //   2397	2429	2432	java/lang/Exception
    //   1546	1563	2516	java/lang/Exception
    //   1647	1667	2550	java/lang/Exception
    //   1789	1806	2597	java/lang/Exception
    //   2051	2077	2740	java/lang/Exception
    //   2077	2082	2740	java/lang/Exception
    //   2680	2720	2740	java/lang/Exception
    //   2723	2737	2740	java/lang/Exception
    //   2105	2121	2774	java/lang/Exception
    //   2866	2879	2953	java/lang/Exception
    //   3155	3170	3415	java/lang/Exception
    //   3175	3215	3415	java/lang/Exception
    //   714	758	3612	java/lang/Exception
  }
  
  public int aoY()
  {
    return this.mController.czv();
  }
  
  public boolean aoZ()
  {
    return false;
  }
  
  protected void b(com.tencent.mm.plugin.webview.stub.c paramc)
  {
    y.i("MicroMsg.WebViewUI", "onSceneEnd, instance hashcode = " + hashCode());
    if (this.niQ == null) {
      y.w("MicroMsg.WebViewUI", "onSceneEnd, viewWV is null, do nothing");
    }
    int k;
    Object localObject2;
    label290:
    do
    {
      return;
      if ((isFinishing()) || (this.gGo == null))
      {
        y.w("MicroMsg.WebViewUI", "onSceneEnd, isFinishing, do nothing");
        return;
      }
      k = -1;
      int m = -1;
      localObject2 = null;
      localObject1 = null;
      for (;;)
      {
        try
        {
          i = paramc.getType();
          localObject1 = localObject2;
          j = m;
          int n;
          y.e("MicroMsg.WebViewUI", "onSceneEnd, ex = " + paramc.getMessage());
        }
        catch (Exception paramc)
        {
          try
          {
            n = paramc.ccZ();
            localObject1 = localObject2;
            j = m;
            k = n;
            m = paramc.cda();
            localObject1 = localObject2;
            j = m;
            k = n;
            localObject2 = paramc.Lg();
            localObject1 = localObject2;
            j = m;
            k = n;
            paramc = paramc.getData();
            k = n;
            j = m;
            localObject1 = paramc;
            if (paramc == null) {
              localObject1 = new Bundle();
            }
            m = ((Bundle)localObject1).getInt("scene_end_listener_hash_code");
            y.i("MicroMsg.WebViewUI", "get hash code = %d, self hash code = %d", new Object[] { Integer.valueOf(m), Integer.valueOf(hashCode()) });
            y.i("MicroMsg.WebViewUI", "edw onSceneEnd, type = " + i + ", errCode = " + j + ", errType = " + k);
            if (m == hashCode()) {
              break;
            }
            y.e("MicroMsg.WebViewUI", "hash code not equal");
            return;
          }
          catch (Exception paramc)
          {
            int i;
            int j;
            Object localObject3;
            Object localObject4;
            boolean bool1;
            boolean bool2;
            break label290;
          }
          paramc = paramc;
          i = 0;
          j = m;
        }
        paramc = null;
        localObject2 = localObject1;
      }
    } while ((i != 233) && (i != 131) && (i != 106) && (i != 673) && (i != 666) && (i != 1254) && (i != 1373));
    switch (i)
    {
    default: 
      return;
    case 106: 
      finish();
      return;
    case 233: 
      this.roi.ceM();
      localObject3 = new JsapiPermissionWrapper(((Bundle)localObject1).getByteArray("geta8key_result_jsapi_perm_control_bytes"));
      localObject4 = new GeneralControlWrapper(((Bundle)localObject1).getInt("geta8key_result_general_ctrl_b1"));
      this.rpE = ((Bundle)localObject1).getLong("geta8key_result_deep_link_bit_set", 0L);
      this.rov = ((Bundle)localObject1).getString("geta8key_result_menu_wording");
      i = ((Bundle)localObject1).getInt("geta8key_result_reason");
      y.i("MicroMsg.WebViewUI", "edw geta8key onSceneEnd, req reason = " + i);
      localObject2 = null;
      paramc = (com.tencent.mm.plugin.webview.stub.c)localObject2;
      switch (i)
      {
      default: 
        paramc = (com.tencent.mm.plugin.webview.stub.c)localObject2;
      }
      for (;;)
      {
        P(this.gGo.RP(paramc).hi(34), this.gGo.RP(paramc).hi(75));
        cep();
        return;
        if (((k == 0) && (j == 0)) || ((k == 4) && (j == -2005)))
        {
          paramc = ((Bundle)localObject1).getString("geta8key_result_full_url");
          a(((Bundle)localObject1).getString("geta8key_result_req_url"), paramc, (JsapiPermissionWrapper)localObject3, (GeneralControlWrapper)localObject4);
          U((Bundle)localObject1);
          this.rom = ((JsapiPermissionWrapper)localObject3).hi(24);
          this.rfg.cck().rgB = true;
          this.rnU = ((Bundle)localObject1).getByteArray("geta8key_result_cookie");
          y.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", new Object[] { bk.bG(this.rnU) });
        }
        else
        {
          h.rnm.CD(k);
          paramc = ((Bundle)localObject1).getString("geta8key_result_req_url");
          if ((this.roF != null) && (!Tl(paramc)))
          {
            this.roF.setVisibility(0);
            O(true, true);
          }
          this.rfg.cck().rgB = false;
          this.rfg.cce().bm(paramc, false);
          com.tencent.mm.plugin.report.service.h.nFQ.a(154L, 12L, 1L, false);
          i = a.Ct(i);
          if (-1 != i) {
            com.tencent.mm.plugin.report.service.h.nFQ.a(154L, i, 1L, false);
          }
          ceq();
          paramc = (com.tencent.mm.plugin.webview.stub.c)localObject2;
          if (this.rnP)
          {
            finish();
            paramc = (com.tencent.mm.plugin.webview.stub.c)localObject2;
            continue;
            if ((k == 0) && (j == 0))
            {
              paramc = ((Bundle)localObject1).getString("geta8key_result_req_url");
              this.gGo.a(paramc, (JsapiPermissionWrapper)localObject3, (GeneralControlWrapper)localObject4);
              this.roM.remove(paramc);
              if (this.roU)
              {
                O(true, true);
                this.roU = false;
              }
              if (i != 5) {
                this.rom = ((JsapiPermissionWrapper)localObject3).hi(24);
              }
              this.rnU = ((Bundle)localObject1).getByteArray("geta8key_result_cookie");
              y.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", new Object[] { bk.bG(this.rnU) });
            }
            else if ((k == 4) && (j == -2005))
            {
              this.niQ.stopLoading();
              paramc = ((Bundle)localObject1).getString("geta8key_result_full_url");
              a(((Bundle)localObject1).getString("geta8key_result_req_url"), paramc, (JsapiPermissionWrapper)localObject3, (GeneralControlWrapper)localObject4);
              U((Bundle)localObject1);
              this.rnU = ((Bundle)localObject1).getByteArray("geta8key_result_cookie");
              y.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", new Object[] { bk.bG(this.rnU) });
            }
            else if ((k != 0) && (j == -3300))
            {
              y.e("MicroMsg.WebViewUI", "onSceneEnd errType:%d, errCode:%d, disable iframe getA8Key", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
              this.rnV = true;
              paramc = (com.tencent.mm.plugin.webview.stub.c)localObject2;
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.nFQ.a(154L, 12L, 1L, false);
              com.tencent.mm.plugin.report.service.h.nFQ.a(154L, a.Ct(i), 1L, false);
              O(true, true);
              paramc = (com.tencent.mm.plugin.webview.stub.c)localObject2;
            }
          }
        }
      }
    case 673: 
      paramc = this.roj;
      paramc.rqQ -= 1;
      if (paramc.rqQ <= 0) {
        paramc.rpH.CF(673);
      }
      if ((k == 0) && (j == 0))
      {
        if (localObject1 != null) {}
        for (paramc = ((Bundle)localObject1).getString("reading_mode_result_url");; paramc = null)
        {
          y.i("MicroMsg.WebViewUI", "[cpan] onsceneend url:%s", new Object[] { paramc });
          if (!bk.bl(paramc)) {
            break;
          }
          y.i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
          return;
        }
        b(paramc, null, false);
        return;
      }
      y.i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
      return;
    case 666: 
      paramc = this.rok;
      paramc.rqR -= 1;
      if (paramc.rqR <= 0) {
        paramc.rpH.CF(666);
      }
      finish();
      return;
    case 1254: 
      if ((k == 0) && (j == 0)) {}
      for (bool1 = true;; bool1 = false)
      {
        localObject3 = this.gGn;
        paramc = this.rpB;
        localObject4 = this.rpC;
        i = hashCode();
        y.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b", new Object[] { Boolean.valueOf(bool1) });
        paramc.aIJ();
        ((ac.b)localObject4).remove(1254);
        if (bool1) {
          break;
        }
        com.tencent.mm.ui.base.h.a(this, (String)localObject2, com.tencent.mm.sdk.platformtools.ae.getContext().getString(R.l.wechat_auth_failed), new ac.c.2(paramc));
        return;
      }
      if (localObject1 == null)
      {
        y.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd_Tools resp null");
        return;
      }
      bool1 = ((Bundle)localObject1).getBoolean("is_recent_has_auth");
      bool2 = ((Bundle)localObject1).getBoolean("is_silence_auth");
      localObject2 = ac.c.Sd(((Bundle)localObject1).getString("oauth_url"));
      y.i("MicroMsg.OauthAuthorizeLogic", "parse appID:%s", new Object[] { localObject2 });
      if ((bool1) || (bool2))
      {
        localObject1 = ((Bundle)localObject1).getString("redirect_url");
        if (bk.bl((String)localObject1))
        {
          y.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd redirect null");
          return;
        }
        y.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd isRecentHasAuth:%b isSilenceAuth:%b redirectUrl:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject1 });
        com.tencent.mm.model.gdpr.c.a(this, com.tencent.mm.model.gdpr.a.dYv, (String)localObject2, new ac.c.3(paramc, (String)localObject1));
        return;
      }
      paramc = new ac.c.4(this, (String)localObject2, paramc, (Bundle)localObject1, (com.tencent.mm.plugin.webview.stub.d)localObject3, (ac.b)localObject4, i);
      if (((this instanceof WebViewUI)) && (((WebViewUI)this).isFinishing()))
      {
        y.i("MicroMsg.OauthAuthorizeLogic", "showWebAuthorizeDialog isFinishing");
        return;
      }
      localObject2 = ac.V((ArrayList)((Bundle)localObject1).getSerializable("scope_list"));
      localObject3 = ((Bundle)localObject1).getString("appname");
      localObject1 = ((Bundle)localObject1).getString("appicon_url");
      new com.tencent.mm.plugin.webview.ui.tools.widget.n(this).a((LinkedList)localObject2, (String)localObject3, (String)localObject1, getString(R.l.wechat_login_title), paramc);
      return;
    }
    if ((k == 0) && (j == 0)) {}
    for (bool1 = true;; bool1 = false)
    {
      paramc = this.rpB;
      localObject3 = this.rpC;
      y.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd suc: %b", new Object[] { Boolean.valueOf(bool1) });
      ((ac.b)localObject3).remove(1373);
      if (bool1) {
        break;
      }
      com.tencent.mm.ui.base.h.a(this, (String)localObject2, com.tencent.mm.sdk.platformtools.ae.getContext().getString(R.l.wechat_auth_failed), new ac.c.5(paramc));
      return;
    }
    if (localObject1 == null)
    {
      y.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd resp null");
      return;
    }
    Object localObject1 = ((Bundle)localObject1).getString("redirect_url");
    if (bk.bl((String)localObject1))
    {
      y.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirect null");
      return;
    }
    paramc.Se((String)localObject1);
    y.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", new Object[] { localObject1 });
  }
  
  protected final void b(String paramString, Drawable paramDrawable)
  {
    a(0, paramString, paramDrawable, new WebViewUI.41(this, cel(), getIntent().getStringExtra("srcUsername")));
  }
  
  public void b(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramMap = new HashMap(2);
      paramMap.put("Pragma", "no-cache");
      paramMap.put("Cache-Control", "no-cache");
      if (this.niQ != null) {
        this.niQ.loadUrl(paramString, paramMap);
      }
    }
    while (this.niQ == null) {
      return;
    }
    if (paramMap != null)
    {
      this.niQ.loadUrl(paramString, paramMap);
      return;
    }
    this.niQ.loadUrl(paramString);
  }
  
  public final void bBI()
  {
    this.rbk.bp("sendAppMessage", true);
    this.rbk.cgc();
    this.rfg.St("mm_send_friend_count");
  }
  
  public MMWebView bZI()
  {
    return MMWebView.a.cO(this);
  }
  
  protected final void bac()
  {
    int i;
    if (this.kXV != null)
    {
      if ((!this.rnA) && (!this.rnB)) {
        break label28;
      }
      i = 1;
      if (i == 0) {
        break label33;
      }
    }
    label28:
    label33:
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    do
    {
      return;
      i = 0;
      break;
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.kXV.getLayoutParams();
      i = cdO();
    } while (i == localMarginLayoutParams.topMargin);
    localMarginLayoutParams.topMargin = i;
    this.kXV.setLayoutParams(localMarginLayoutParams);
  }
  
  final boolean bad()
  {
    return (!bk.bl(this.kXY)) && (this.kXY.equals("black"));
  }
  
  public WebViewUI.x bo(String paramString, boolean paramBoolean)
  {
    return i(paramString, paramBoolean, -1);
  }
  
  public void cS(String paramString, int paramInt)
  {
    if (this.rnC == null) {}
    do
    {
      return;
      WebViewInputFooter localWebViewInputFooter = this.rnC;
      localWebViewInputFooter.setVisibility(0);
      if (localWebViewInputFooter.rDl != null) {
        localWebViewInputFooter.rDl.setVisibility(0);
      }
      if (localWebViewInputFooter.rDk != null)
      {
        localWebViewInputFooter.rDk.setEnabled(true);
        localWebViewInputFooter.rDk.setBackgroundResource(R.g.input_bar_bg_active);
      }
      if (localWebViewInputFooter.rDh != null) {
        localWebViewInputFooter.rDh.setVisibility(0);
      }
      localWebViewInputFooter.rDm = false;
      if (localWebViewInputFooter.rDk != null)
      {
        localWebViewInputFooter.rDk.setFocusable(true);
        localWebViewInputFooter.rDk.setFocusableInTouchMode(true);
        localWebViewInputFooter.rDk.requestFocus();
      }
      if (localWebViewInputFooter.bER != null) {
        localWebViewInputFooter.bER.showVKB();
      }
      localWebViewInputFooter.state = 0;
      if (!bk.bl(paramString)) {
        this.rnC.setText(paramString);
      }
    } while (paramInt < 0);
    this.rnC.setMaxCount(paramInt);
  }
  
  public final boolean caS()
  {
    if (this.roC != null)
    {
      Object localObject1 = this.roC;
      if (bk.bl(((WebViewUI.d)localObject1).rqF)) {}
      for (boolean bool = false; (bool) && (!bk.bl(this.roC.ceK())) && (!bk.bl(this.roC.cbt())) && (!bk.bl(this.roC.cbu())); bool = ((WebViewUI.d)localObject1).rqF.equals("true"))
      {
        Object localObject2 = this.roC.ceK();
        localObject1 = this.roC.cbt();
        String str = this.roC.cbu();
        y.i("MicroMsg.WebViewUI", "use js api close window confirm info : %s, %s, %s", new Object[] { localObject2, localObject1, str });
        View localView = View.inflate(this.mController.uMN, R.i.mm_alert_checkbox, null);
        CheckBox localCheckBox = (CheckBox)localView.findViewById(R.h.mm_alert_dialog_cb);
        localCheckBox.setChecked(false);
        localCheckBox.setVisibility(8);
        TextView localTextView = (TextView)localView.findViewById(R.h.mm_alert_dialog_info);
        localTextView.setText((CharSequence)localObject2);
        localTextView.setTextColor(getResources().getColor(R.e.normal_text_color));
        localObject2 = (TextView)localView.findViewById(R.h.mm_alert_dialog_cb_txt);
        ((TextView)localObject2).setTextColor(getResources().getColor(R.e.normal_text_color));
        ((TextView)localObject2).setVisibility(8);
        this.roD = com.tencent.mm.ui.base.h.a(this.mController.uMN, true, "", localView, (String)localObject1, str, new WebViewUI.63(this, localCheckBox), new WebViewUI.65(this));
        return true;
      }
    }
    return false;
  }
  
  public final String caV()
  {
    Object localObject = null;
    try
    {
      String str = getIntent().getStringExtra("rawUrl");
      localObject = str;
    }
    catch (Exception localException)
    {
      do
      {
        y.e("MicroMsg.WebViewUI", "getRawUrl exception:%s", new Object[] { localException.getMessage() });
      } while (!(localException instanceof ClassNotFoundException));
      finish();
      return null;
    }
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      return localObject;
    }
    localObject = getIntent().getData();
    if (localObject == null) {
      return "";
    }
    return ((Uri)localObject).toString();
  }
  
  protected void cdH()
  {
    int i = getIntent().getIntExtra("webview_bg_color_rsID", -1);
    if ((i != -1) && (this.mController.contentView != null))
    {
      setBackGroundColorResource(i);
      this.mController.contentView.setBackgroundResource(i);
      this.niQ.setBackgroundResource(17170445);
      findViewById(R.h.webview_keyboard_ll).setBackgroundResource(17170445);
      return;
    }
    this.niQ.setBackgroundColor(getResources().getColor(R.e.BW_95));
  }
  
  public boolean cdP()
  {
    return true;
  }
  
  public final void cdQ()
  {
    if ((com.tencent.mm.compatible.util.d.gF(21)) && (this.kXX != 0))
    {
      ta(this.kXX);
      if (bad())
      {
        czn();
        oX(-16777216);
      }
      af(this.kXX, bad());
      return;
    }
    setStatusBarColor(aoY());
  }
  
  public final String cdR()
  {
    if (this.handler == null) {
      return this.rpw;
    }
    if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId())
    {
      if (this.niQ == null) {
        return "";
      }
      return this.niQ.getUrl();
    }
    if (!bk.bl(this.rpw)) {
      return this.rpw;
    }
    this.rpw = ((String)new WebViewUI.2(this, "").b(this.handler));
    return this.rpw;
  }
  
  public void cdU()
  {
    this.niQ.goBack();
    this.rnT = null;
    if (this.rot) {
      this.rot = false;
    }
    h localh = h.rnm;
    y.v("MicroMsg.WebViewReportUtil", "goBack traceid %s", new Object[] { localh.oAk });
    if (!bk.bl(localh.oAk)) {
      localh.jdMethod_if(5);
    }
  }
  
  public int cdV()
  {
    if (this.rnC == null) {
      return 0;
    }
    return this.rnC.cgU();
  }
  
  public void cdW()
  {
    if (getIntent() == null) {}
    while (!getIntent().hasExtra("show_full_screen")) {
      return;
    }
    N(getIntent().getBooleanExtra("show_full_screen", false), true);
  }
  
  public com.tencent.xweb.p cdX()
  {
    return new WebViewUI.i(this);
  }
  
  public com.tencent.xweb.j cdY()
  {
    try
    {
      if (this.roe == null) {
        this.roe = new WebViewUI.h(this);
      }
      com.tencent.xweb.j localj = this.roe;
      return localj;
    }
    finally {}
  }
  
  public int cdZ()
  {
    if (cea()) {
      return 0;
    }
    return R.k.actionbar_icon_dark_close;
  }
  
  public boolean cdz()
  {
    return false;
  }
  
  public final boolean ceA()
  {
    if (this.rpG != -3)
    {
      showVKB();
      return true;
    }
    return false;
  }
  
  public void ceB() {}
  
  public boolean cea()
  {
    return this.roN;
  }
  
  public boolean ceb()
  {
    return true;
  }
  
  public com.tencent.mm.plugin.webview.ui.tools.jsapi.d cec()
  {
    MMWebView localMMWebView = this.niQ;
    f localf = this.gGo;
    HashMap localHashMap = new HashMap();
    localHashMap.put("webview_type", "1");
    localHashMap.put("init_url", this.caS);
    localHashMap.put("init_font_size", "1");
    localHashMap.put("short_url", bk.pm(getIntent().getStringExtra("shortUrl")));
    return new com.tencent.mm.plugin.webview.ui.tools.jsapi.d(localMMWebView, localf, localHashMap, this.gGn, hashCode());
  }
  
  public com.tencent.mm.plugin.websearch.api.ah ced()
  {
    return null;
  }
  
  public boolean cee()
  {
    return true;
  }
  
  public boolean cef()
  {
    return false;
  }
  
  public void ceg() {}
  
  public final void cei()
  {
    String str1 = Tr(this.rpw);
    String str2 = getIntent().getStringExtra("shortcut_user_name");
    if ((bk.bl(str1)) || (bk.bl(str2)))
    {
      y.e("MicroMsg.WebViewUI", "addShortcut, appid or username is null");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("KAppId", str1);
    localBundle.putString("shortcut_user_name", str2);
    localBundle.putInt("webviewui_binder_id", hashCode());
    try
    {
      this.gGn.f(80, localBundle);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WebViewUI", "addShortcut, e = " + localException.getMessage());
    }
  }
  
  public void cej()
  {
    Object localObject1 = this.niQ.getUrl();
    boolean bool;
    label44:
    Object localObject3;
    com.tencent.mm.ui.widget.a.d locald;
    label75:
    Object localObject4;
    if (this.roz.containsKey(localObject1))
    {
      localObject1 = (ArrayList)this.roz.get(localObject1);
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
        break label315;
      }
      bool = true;
      localObject3 = Boolean.valueOf(bool);
      if (!((Boolean)localObject3).booleanValue()) {
        break label320;
      }
      locald = new com.tencent.mm.ui.widget.a.d(this.mController.uMN, 1, false);
      locald.wdr = new WebViewUI.35(this);
      locald.wds = new n.b()
      {
        public final void a(TextView paramAnonymousTextView, MenuItem paramAnonymousMenuItem)
        {
          paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
          String str;
          if (paramAnonymousTextView != null)
          {
            str = (String)WebViewUI.R(WebViewUI.this).get(paramAnonymousMenuItem);
            if (bk.bl(str)) {
              WebViewUI.d(paramAnonymousTextView, paramAnonymousMenuItem);
            }
          }
          else
          {
            return;
          }
          paramAnonymousTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.a(WebViewUI.this.mController.uMN, str, paramAnonymousTextView.getTextSize()));
        }
      };
      locald.phI = new WebViewUI.37(this);
      locald.phH = new WebViewUI.38(this, (Boolean)localObject3, (ArrayList)localObject1);
      if (this.niQ == null) {
        break label340;
      }
      localObject1 = this.niQ.getUrl();
      label141:
      if (!bk.bl((String)localObject1))
      {
        localObject4 = Uri.parse((String)localObject1).getHost();
        localObject3 = getString(R.l.webview_logo_url, new Object[] { localObject4 });
        if ((bk.bl((String)localObject4)) || (!com.tencent.mm.sdk.a.b.cqk())) {
          break label346;
        }
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      label315:
      label320:
      label340:
      try
      {
        if (this.gGn.f(98, null) != null) {
          localObject1 = (String)localObject3 + "_NewBridge";
        }
        if (!bk.bl(this.rov)) {
          break label352;
        }
        if (!bk.bl((String)localObject4)) {
          locald.h((CharSequence)localObject1, 1);
        }
        if (!this.rnA) {
          break label418;
        }
        locald.rxb = true;
        locald.rxc = true;
        if ((this.rnD == null) || (!this.rnD.isShown())) {
          break label431;
        }
        this.rnD.hide();
        ai.l(new WebViewUI.39(this, locald), 100L);
        return;
      }
      catch (Exception localException) {}
      localObject1 = null;
      break;
      bool = false;
      break label44;
      locald = new com.tencent.mm.ui.widget.a.d(this.mController.uMN, 0, true);
      break label75;
      localObject1 = null;
      break label141;
      label346:
      Object localObject2 = localObject3;
      continue;
      label352:
      localObject3 = LayoutInflater.from(this).inflate(R.i.mm_webview_ui_bottom_sheet_title_text, null);
      localObject4 = (TextView)((View)localObject3).findViewById(R.h.title_text);
      TextView localTextView = (TextView)((View)localObject3).findViewById(R.h.desc_text);
      locald.ej((View)localObject3);
      ((TextView)localObject4).setText(localObject2);
      localTextView.setText(bk.pm(this.rov));
      continue;
      label418:
      locald.rxb = false;
      locald.rxc = false;
    }
    label431:
    XM();
    ai.l(new WebViewUI.40(this, locald), 100L);
  }
  
  protected final boolean cel()
  {
    String str1 = getIntent().getStringExtra("srcUsername");
    String str2 = getIntent().getStringExtra("bizofstartfrom");
    return (str1 != null) && (str2 != null) && ("enterpriseHomeSubBrand".equals(str2));
  }
  
  public final void cen()
  {
    Object localObject1 = getIntent().getStringExtra("geta8key_username");
    getIntent().putExtra("k_username", (String)localObject1);
    getIntent().putExtra("k_expose_url", this.niQ.getUrl());
    getIntent().putExtra("showShare", false);
    Object localObject3 = this.niQ.getUrl();
    localObject1 = null;
    if (!bk.bl((String)localObject3)) {
      localObject1 = Uri.parse((String)localObject3).getHost();
    }
    if ((!bk.bl((String)localObject1)) && (((String)localObject1).startsWith("mp.weixin.qq.com"))) {}
    for (;;)
    {
      try
      {
        localObject1 = String.format("https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect", new Object[] { com.tencent.mm.compatible.util.q.encode(this.niQ.getUrl(), "utf-8") });
        if (localObject1 == null) {
          break label463;
        }
        String str2 = Tr(this.niQ.getUrl());
        boolean bool = this.gGo.cdJ().coX();
        y.d("MicroMsg.WebViewUI", "doExpose enableReportPageEvent %s", new Object[] { Boolean.valueOf(bool) });
        long l;
        if ((!TextUtils.isEmpty(str2)) && (bool) && (!TextUtils.isEmpty(this.niQ.getUrl())))
        {
          l = bk.UX();
          y.d("MicroMsg.WebViewUI", "report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13377), Long.valueOf(l), str2, this.niQ.getUrl(), this.bIB, Integer.valueOf(4), Integer.valueOf(1) });
          localObject3 = "";
        }
        try
        {
          String str1 = com.tencent.mm.compatible.util.q.encode(this.niQ.getUrl(), "UTF-8");
          localObject3 = str1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          Object localObject2;
          y.printErrStackTrace("MicroMsg.WebViewUI", localUnsupportedEncodingException2, "", new Object[0]);
          continue;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(13377, new Object[] { Long.valueOf(l), str2, localObject3, this.bIB, Integer.valueOf(4), Integer.valueOf(1) });
        localObject3 = localObject1;
        if (bk.bl((String)localObject1)) {
          localObject3 = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(34) });
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", (String)localObject3);
        ((Intent)localObject1).putExtra("showShare", false);
        com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        y.e("MicroMsg.WebViewUI", localUnsupportedEncodingException1.getMessage());
        localObject2 = localObject3;
        continue;
      }
      getIntent().putExtra("k_expose_current_url", cdR());
      label463:
      localObject2 = null;
    }
  }
  
  /* Error */
  public final void ceo()
  {
    // Byte code:
    //   0: new 786	android/os/Bundle
    //   3: dup
    //   4: invokespecial 787	android/os/Bundle:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc_w 4244
    //   12: aload_0
    //   13: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   16: ldc_w 4244
    //   19: ldc2_w 4245
    //   22: invokevirtual 3230	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   25: invokevirtual 4250	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   28: aload_2
    //   29: ldc_w 4252
    //   32: aload_0
    //   33: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   36: ldc_w 4252
    //   39: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   42: invokevirtual 1328	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_2
    //   46: ldc_w 4254
    //   49: aload_0
    //   50: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   53: ldc_w 4254
    //   56: iconst_0
    //   57: invokevirtual 1316	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   60: invokevirtual 793	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   63: aload_2
    //   64: ldc_w 4256
    //   67: aload_0
    //   68: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   71: ldc_w 4256
    //   74: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokevirtual 1328	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload_2
    //   81: ldc_w 3232
    //   84: aload_0
    //   85: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   88: ldc_w 3232
    //   91: iconst_0
    //   92: invokevirtual 1316	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   95: invokevirtual 793	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   98: aload_2
    //   99: ldc_w 2357
    //   102: aload_0
    //   103: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   106: invokevirtual 1328	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   113: invokestatic 411	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   116: ifne +204 -> 320
    //   119: aload_0
    //   120: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   123: ldc_w 4258
    //   126: invokevirtual 4261	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   129: ifeq +191 -> 320
    //   132: aload_0
    //   133: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   136: iconst_0
    //   137: aload_0
    //   138: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   141: invokevirtual 1158	java/lang/String:length	()I
    //   144: iconst_3
    //   145: isub
    //   146: invokevirtual 1501	java/lang/String:substring	(II)Ljava/lang/String;
    //   149: astore_3
    //   150: aload_0
    //   151: getfield 746	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rpy	Ljava/lang/String;
    //   154: invokestatic 411	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   157: ifne +35 -> 192
    //   160: aload_0
    //   161: getfield 746	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rpy	Ljava/lang/String;
    //   164: aload_3
    //   165: invokevirtual 1379	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   168: ifne +24 -> 192
    //   171: aload_2
    //   172: ldc_w 2357
    //   175: aload_0
    //   176: getfield 746	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rpy	Ljava/lang/String;
    //   179: invokevirtual 1328	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_2
    //   183: ldc_w 4244
    //   186: ldc2_w 4245
    //   189: invokevirtual 4250	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   192: aload_0
    //   193: invokevirtual 867	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   196: astore_3
    //   197: aload_3
    //   198: ifnull +60 -> 258
    //   201: aload_2
    //   202: ldc_w 4263
    //   205: aload_3
    //   206: ldc_w 4263
    //   209: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   212: invokevirtual 1328	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload_2
    //   216: ldc_w 4265
    //   219: aload_3
    //   220: ldc_w 4265
    //   223: iconst_0
    //   224: invokevirtual 1316	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   227: invokevirtual 793	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   230: aload_2
    //   231: ldc_w 4267
    //   234: aload_3
    //   235: ldc_w 4267
    //   238: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   241: invokevirtual 1328	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload_2
    //   245: ldc_w 4269
    //   248: aload_3
    //   249: ldc_w 4269
    //   252: invokevirtual 874	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   255: invokevirtual 1328	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_0
    //   259: getfield 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   262: aload_2
    //   263: invokeinterface 4272 2 0
    //   268: astore_2
    //   269: aload_2
    //   270: invokeinterface 4277 1 0
    //   275: ifeq +324 -> 599
    //   278: aload_0
    //   279: getfield 550	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rbk	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   282: ldc_w 1282
    //   285: iconst_0
    //   286: invokevirtual 1286	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:bp	(Ljava/lang/String;Z)V
    //   289: aload_0
    //   290: getfield 550	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rbk	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   293: astore_2
    //   294: aload_2
    //   295: getfield 898	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:ready	Z
    //   298: ifne +70 -> 368
    //   301: ldc_w 900
    //   304: ldc_w 4279
    //   307: invokestatic 813	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: ldc_w 462
    //   313: ldc_w 4281
    //   316: invokestatic 833	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: return
    //   320: aload_0
    //   321: getfield 746	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rpy	Ljava/lang/String;
    //   324: invokestatic 411	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   327: ifne -135 -> 192
    //   330: aload_0
    //   331: getfield 746	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rpy	Ljava/lang/String;
    //   334: aload_0
    //   335: getfield 510	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:caS	Ljava/lang/String;
    //   338: invokevirtual 1379	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   341: ifne -149 -> 192
    //   344: aload_2
    //   345: ldc_w 2357
    //   348: aload_0
    //   349: getfield 746	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:rpy	Ljava/lang/String;
    //   352: invokevirtual 1328	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: aload_2
    //   356: ldc_w 4244
    //   359: ldc2_w 4245
    //   362: invokevirtual 4250	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   365: goto -173 -> 192
    //   368: aload_2
    //   369: iconst_1
    //   370: invokevirtual 1920	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:CV	(I)Landroid/os/Bundle;
    //   373: astore_3
    //   374: aload_3
    //   375: ifnull +106 -> 481
    //   378: aload_3
    //   379: ldc_w 1922
    //   382: iconst_0
    //   383: invokevirtual 1924	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   386: istore_1
    //   387: iload_1
    //   388: ifeq +93 -> 481
    //   391: aload_2
    //   392: getfield 1296	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   395: ldc_w 1290
    //   398: ldc_w 2218
    //   401: aload_2
    //   402: getfield 1301	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rjN	I
    //   405: invokeinterface 1304 4 0
    //   410: aload_2
    //   411: aload_3
    //   412: ldc_w 1282
    //   415: invokevirtual 1928	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:g	(Landroid/os/Bundle;Ljava/lang/String;)V
    //   418: goto -108 -> 310
    //   421: astore_2
    //   422: ldc_w 462
    //   425: new 434	java/lang/StringBuilder
    //   428: dup
    //   429: ldc_w 4283
    //   432: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   435: aload_2
    //   436: invokevirtual 810	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   439: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 813	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   448: return
    //   449: astore 4
    //   451: ldc_w 900
    //   454: new 434	java/lang/StringBuilder
    //   457: dup
    //   458: ldc_w 1306
    //   461: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   464: aload 4
    //   466: invokevirtual 810	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   469: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 1308	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   478: goto -68 -> 410
    //   481: new 586	java/util/HashMap
    //   484: dup
    //   485: invokespecial 587	java/util/HashMap:<init>	()V
    //   488: astore_3
    //   489: aload_3
    //   490: ldc_w 1290
    //   493: ldc_w 2218
    //   496: invokevirtual 1293	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   499: pop
    //   500: ldc_w 1295
    //   503: aload_3
    //   504: aload_2
    //   505: getfield 935	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rxI	Z
    //   508: aload_2
    //   509: getfield 938	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rxJ	Ljava/lang/String;
    //   512: invokestatic 943	com/tencent/mm/plugin/webview/ui/tools/jsapi/i$a:a	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
    //   515: astore_3
    //   516: aload_2
    //   517: getfield 946	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rxB	Lcom/tencent/mm/ui/widget/MMWebView;
    //   520: new 434	java/lang/StringBuilder
    //   523: dup
    //   524: ldc_w 948
    //   527: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   530: aload_3
    //   531: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: ldc_w 950
    //   537: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: aconst_null
    //   544: invokevirtual 956	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
    //   547: aload_2
    //   548: getfield 1296	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:gGn	Lcom/tencent/mm/plugin/webview/stub/d;
    //   551: ldc_w 1290
    //   554: ldc_w 2218
    //   557: aload_2
    //   558: getfield 1301	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:rjN	I
    //   561: invokeinterface 1304 4 0
    //   566: goto -256 -> 310
    //   569: astore_2
    //   570: ldc_w 900
    //   573: new 434	java/lang/StringBuilder
    //   576: dup
    //   577: ldc_w 1306
    //   580: invokespecial 437	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   583: aload_2
    //   584: invokevirtual 810	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   587: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 1308	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   596: goto -286 -> 310
    //   599: aload_2
    //   600: invokeinterface 4286 1 0
    //   605: aload_0
    //   606: aload_0
    //   607: getfield 769	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:kNz	Lcom/tencent/mm/ui/widget/snackbar/a$b;
    //   610: invokestatic 2489	com/tencent/mm/plugin/fav/ui/c:a	(ILandroid/app/Activity;Lcom/tencent/mm/ui/widget/snackbar/a$b;)V
    //   613: aload_2
    //   614: invokeinterface 4286 1 0
    //   619: ifne +9 -> 628
    //   622: aload_0
    //   623: iconst_1
    //   624: invokespecial 4288	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CI	(I)V
    //   627: return
    //   628: aload_0
    //   629: iconst_2
    //   630: invokespecial 4288	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:CI	(I)V
    //   633: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	634	0	this	WebViewUI
    //   386	2	1	bool	boolean
    //   7	404	2	localObject1	Object
    //   421	137	2	localException1	Exception
    //   569	45	2	localException2	Exception
    //   149	382	3	localObject2	Object
    //   449	16	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   258	310	421	java/lang/Exception
    //   310	319	421	java/lang/Exception
    //   368	374	421	java/lang/Exception
    //   378	387	421	java/lang/Exception
    //   410	418	421	java/lang/Exception
    //   451	478	421	java/lang/Exception
    //   481	547	421	java/lang/Exception
    //   570	596	421	java/lang/Exception
    //   599	627	421	java/lang/Exception
    //   628	633	421	java/lang/Exception
    //   391	410	449	java/lang/Exception
    //   547	566	569	java/lang/Exception
  }
  
  public void cep() {}
  
  public void ceq() {}
  
  public boolean cer()
  {
    return false;
  }
  
  public boolean ces()
  {
    return false;
  }
  
  public void cew()
  {
    if (cev()) {}
    do
    {
      do
      {
        return;
        cex();
      } while (caS());
      this.roY = true;
      h.rnm.close();
    } while (this.rbN.CL(20));
    finish();
  }
  
  public boolean cey()
  {
    return true;
  }
  
  protected boolean convertActivityFromTranslucent()
  {
    return getIntent().getBooleanExtra("convertActivityFromTranslucent", true);
  }
  
  public void finish()
  {
    if (this.rnL) {
      setResult(-1);
    }
    try
    {
      if (this.gGn != null)
      {
        this.gGn.Co(hashCode());
        this.gGn.Ch(hashCode());
        this.rgh = null;
      }
      y.w("MicroMsg.WebViewUI", "invoke onWebViewUIDestroy");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.w("MicroMsg.WebViewUI", "onDestroy, remove callback and invoke event on webview destroy, ex = " + localException);
      }
    }
    this.handler.removeCallbacksAndMessages(null);
    this.roZ = true;
    super.finish();
  }
  
  public void g(String paramString1, String paramString2, Map<String, String> paramMap) {}
  
  public final int getActionBarHeight()
  {
    if (getResources().getDimensionPixelSize(R.f.wechat_abc_action_bar_default_height) > com.tencent.mm.cb.a.fromDPToPix(this, 48)) {
      return getResources().getDimensionPixelSize(R.f.wechat_abc_action_bar_default_height);
    }
    if (com.tencent.mm.compatible.util.j.fA(this)) {
      return getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
    }
    return getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);
  }
  
  public final int getForceOrientation()
  {
    return this.screenOrientation;
  }
  
  public int getLayoutId()
  {
    return R.i.webview;
  }
  
  public void h(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    String str1 = bk.aM(cdR(), this.caS);
    if (bk.bl(str1))
    {
      y.e("MicroMsg.WebViewUI", "after getA8Key, currentURL is null or nil, wtf");
      b(paramString2, null, false);
      return;
    }
    if (this.rbk == null)
    {
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        b(paramString2, paramMap, false);
        return;
      }
      b(paramString2, null, false);
      return;
    }
    if ((bk.pm(paramString2).contains("#wechat_redirect")) || (bk.pm(paramString1).contains("#wechat_redirect")))
    {
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        b(paramString2, paramMap, false);
        return;
      }
      b(paramString2, null, false);
      return;
    }
    if (!fB(str1, paramString2))
    {
      String str2 = com.tencent.mm.plugin.webview.modelcache.p.SA(str1);
      String str3 = com.tencent.mm.plugin.webview.modelcache.p.SA(paramString2);
      if ((bk.bl(str3)) || (bk.bl(str2)) || (!str3.equals(str2)) || (this.gGn == null) || (!Tl(str1))) {
        break label262;
      }
    }
    label262:
    for (int i = 1; i != 0; i = 0)
    {
      this.roV.put(str1, paramString2);
      this.roP.put(str1, paramMap);
      this.roV.put(paramString1, paramString2);
      this.roP.put(paramString1, paramMap);
      this.rbk.s(paramString2, paramMap);
      return;
    }
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      b(paramString2, paramMap, false);
      return;
    }
    b(paramString2, null, false);
  }
  
  public void hX(boolean paramBoolean) {}
  
  public void i(int paramInt, Bundle paramBundle) {}
  
  public final void i(String paramString, long paramLong, int paramInt)
  {
    String str6 = Tr(this.rpy);
    if (this.fromScene != 0) {
      this.rpx = " ";
    }
    localObject1 = this.gGo.cdJ();
    if (localObject1 != null) {}
    for (boolean bool = ((GeneralControlWrapper)localObject1).coX();; bool = false)
    {
      y.d("MicroMsg.WebViewUI", "webpageVisitInfoReport enableReportPageEvent %s", new Object[] { Boolean.valueOf(bool) });
      long l1;
      long l2;
      Object localObject2;
      String str3;
      String str1;
      if ((this.gYW > 0L) && (this.rpz > this.gYW) && (paramLong > this.rpz) && (!TextUtils.isEmpty(str6)) && (bool))
      {
        l1 = this.rpz - this.gYW;
        l2 = paramLong - this.rpz;
        y.d("MicroMsg.WebViewUI", "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", new Object[] { Integer.valueOf(13376), Long.valueOf(this.gYW), str6, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), this.gVe, this.rpy, this.bIB, Integer.valueOf(paramInt), paramString, Integer.valueOf(this.fromScene), this.rpx });
        localObject2 = "";
        localObject4 = "";
        str3 = "";
        str4 = "";
        str1 = str3;
        localObject1 = localObject4;
      }
      try
      {
        localObject3 = com.tencent.mm.compatible.util.q.encode(bk.pm(this.gVe), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        localObject4 = com.tencent.mm.compatible.util.q.encode(bk.pm(this.rpy), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        str3 = com.tencent.mm.compatible.util.q.encode(bk.pm(paramString), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        String str5 = com.tencent.mm.compatible.util.q.encode(bk.pm(this.rpx), "UTF-8");
        localObject1 = str5;
        localObject2 = localObject3;
        str1 = str3;
        localObject3 = localObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject3;
          y.printErrStackTrace("MicroMsg.WebViewUI", localUnsupportedEncodingException, "", new Object[0]);
          String str2 = str4;
          localObject4 = localObject1;
        }
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(13376, new Object[] { Long.valueOf(this.gYW), str6, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), localObject2, localObject4, this.bIB, Integer.valueOf(paramInt), str1, Integer.valueOf(this.fromScene), localObject3 });
      this.fromScene = 0;
      if (paramInt == 1)
      {
        this.rpx = this.rpy;
        this.rpy = paramString;
        this.gYW = paramLong;
      }
      return;
    }
  }
  
  protected void initSwipeBack()
  {
    super.initSwipeBack();
    if (getSwipeBackLayout() == null) {}
    while (!this.roJ) {
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
      this.roK = true;
      return;
      localb.addView(localView1);
    }
  }
  
  public void initView()
  {
    boolean bool1 = getIntent().getBooleanExtra("vertical_scroll", true);
    this.rnP = getIntent().getBooleanExtra("finishviewifloadfailed", false);
    this.rnM = getIntent().getBooleanExtra("is_favorite_item", false);
    this.oVw = getIntent().getBooleanExtra("isWebwx", true);
    this.rnK = getIntent().getBooleanExtra("neverGetA8Key", false);
    this.roI = getIntent().getBooleanExtra("neverBlockLocalRequest", false);
    this.rnO = getIntent().getBooleanExtra("KFromLoginHistory", false);
    this.roE = LayoutInflater.from(this.mController.uMN).inflate(R.i.sub_menu_prompt_view, null);
    boolean bool2 = getIntent().getBooleanExtra("show_feedback", false);
    this.roG = bk.pm(getIntent().getStringExtra("sentUsername"));
    if (bool2) {
      addTextOptionMenu(1, getString(R.l.settings_feedbackui_title), new WebViewUI.8(this));
    }
    this.rnt = ((ProgressBar)findViewById(R.h.create_progress_bar));
    this.roF = findViewById(R.h.refresh_mask);
    this.roF.setOnClickListener(new WebViewUI.9(this));
    Object localObject1;
    Object localObject3;
    label433:
    Object localObject2;
    if (this.oVw)
    {
      localObject1 = bk.pm(getIntent().getStringExtra("title"));
      if (((CharSequence)localObject1).length() > 0) {
        this.rnr = true;
      }
      super.N((CharSequence)localObject1);
      lk(false);
      ll(false);
      if (rog == WebSettings.RenderPriority.NORMAL)
      {
        y.i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
        this.niQ.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        rog = WebSettings.RenderPriority.HIGH;
      }
      localObject3 = this.rpn;
      localObject1 = this.mController.contentView;
      ((g)localObject3).rmX = ((LogoWebViewWrapper)((View)localObject1).findViewById(R.h.logo_web_view_wrapper));
      ((g)localObject3).rmW = ((ImageView)((View)localObject1).findViewById(R.h.webview_logo_refresh_iv));
      ((g)localObject3).rng = ((View)localObject1).findViewById(R.h.webview_logo_container);
      if (((g)localObject3).rng != null)
      {
        ((g)localObject3).rnh = ((g)localObject3).rng.findViewById(R.h.x5_logo);
        ((g)localObject3).rni = ((TextView)((g)localObject3).rnh.findViewById(R.h.x5_logo_url));
      }
      ((g)localObject3).rmY = BackwardSupportUtil.b.b(((g)localObject3).rmX.getContext(), 72.0F);
      if (((g)localObject3).rmW != null) {
        break label1226;
      }
      localObject1 = "null";
      if (((g)localObject3).rmX != null) {
        break label1241;
      }
      localObject2 = "null";
      label446:
      y.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage.id = %s, logoWrapper.id = %s", new Object[] { localObject1, localObject2 });
      y.d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", new Object[] { Integer.valueOf(((g)localObject3).rmY) });
      localObject1 = this.rpn;
      localObject2 = this.niQ;
      ((MMWebView)localObject2).setCompetitorView(((g)localObject1).rmX);
      ((MMWebView)localObject2).cJT();
      if (Build.VERSION.SDK_INT <= 10) {
        ((g)localObject1).rmX.getWebViewContainer().setBackgroundColor(((g)localObject1).rmX.getResources().getColor(R.e.webview_logo_bg_color));
      }
      localObject3 = ((g)localObject1).rmX;
      ((LogoWebViewWrapper)localObject3).getWebViewContainer();
      if (((LogoWebViewWrapper)localObject3).rkM != null)
      {
        ((LogoWebViewWrapper)localObject3).dpt = ((com.tencent.xweb.WebView)localObject2);
        ((LogoWebViewWrapper)localObject3).rkM.addView(((LogoWebViewWrapper)localObject3).dpt);
      }
      if ((!((MMWebView)localObject2).isXWalkKernel()) && (!((MMWebView)localObject2).getIsX5Kernel())) {
        break label1257;
      }
      ((g)localObject1).rnj = true;
      label609:
      if ((((g)localObject1).rnh != null) && (!((MMWebView)localObject2).getIsX5Kernel()))
      {
        ((ImageView)((g)localObject1).rnh.findViewById(R.h.x5_logo_img)).setVisibility(8);
        ((TextView)((g)localObject1).rnh.findViewById(R.h.info_txt)).setText("");
      }
      if ((!((g)localObject1).rnj) || (((g)localObject1).rnk)) {
        break label1265;
      }
      ((g)localObject1).lh(false);
      if (((g)localObject1).rnh != null) {
        ((g)localObject1).rnh.setVisibility(0);
      }
    }
    for (;;)
    {
      cdH();
      this.rnx = ((FrameLayout)findViewById(R.h.root_container));
      this.rny = ((FrameLayout)findViewById(R.h.container));
      y.i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.niQ.getIsX5Kernel());
      this.niQ.setWebViewClientExtension(new WebViewUI.g(this));
      if (this.niQ.getIsX5Kernel())
      {
        this.niQ.setWebViewCallbackClient(this.rpi);
        localObject1 = this.rpn;
        localObject2 = new WebViewUI.10(this);
        if (((g)localObject1).rmX != null) {
          ((g)localObject1).rmX.setMMOverScrollListener((LogoWebViewWrapper.a)localObject2);
        }
      }
      this.rnC = ((WebViewInputFooter)findViewById(R.h.webview_input_footer));
      if (this.rnC != null)
      {
        this.rnC.hide();
        this.rnC.setOnTextSendListener(new WebViewUI.11(this));
        this.rnC.setOnSmileyChosenListener(new WebViewUI.13(this));
        this.rnC.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b()
        {
          public final void cbe()
          {
            WebViewUI.b(WebViewUI.this, 0);
          }
          
          public final void cbf()
          {
            WebViewKeyboardLinearLayout localWebViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout)WebViewUI.this.findViewById(R.h.webview_keyboard_ll);
            if ((localWebViewKeyboardLinearLayout != null) && (localWebViewKeyboardLinearLayout.getKeyBoardHeight() > 0)) {
              WebViewUI.b(WebViewUI.this, localWebViewKeyboardLinearLayout.getKeyBoardHeight());
            }
          }
        });
      }
      this.rnD = ((WebViewSearchContentInputFooter)findViewById(R.h.search_content_input_footer));
      if (this.rnD != null)
      {
        this.rnD.setActionDelegate(new WebViewUI.15(this));
        this.niQ.setFindListener(new WebView.FindListener()
        {
          public final void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
          {
            if ((paramAnonymousBoolean) && (!WebViewUI.G(WebViewUI.this)) && (!bk.bl(WebViewUI.this.rnD.getSearchContent())))
            {
              if (paramAnonymousInt2 != 0) {
                break label71;
              }
              com.tencent.mm.plugin.report.service.h.nFQ.a(480L, 3L, 1L, false);
            }
            for (;;)
            {
              WebViewUI.c(WebViewUI.this, true);
              WebViewUI.this.rnD.q(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
              return;
              label71:
              com.tencent.mm.plugin.report.service.h.nFQ.a(480L, 2L, 1L, false);
            }
          }
        });
      }
      this.rnz = ((MovingImageButton)findViewById(R.h.full_screen_menu));
      this.rnX = findViewById(R.h.webview_input_alert_toast);
      if (this.rnX != null) {
        this.rnX.setVisibility(8);
      }
      if (!bool1) {
        this.niQ.setVerticalScrollBarEnabled(false);
      }
      this.niQ.setWebChromeClient(cdY());
      this.niQ.setWebViewClient(cdX());
      this.niQ.setDownloadListener(new WebViewUI.17(this));
      this.niQ.requestFocus(130);
      this.niQ.setOnTouchListener(new WebViewUI.18(this));
      localObject1 = com.tencent.mm.pluginsdk.ui.tools.s.aX(this, this.niQ.getSettings().getUserAgentString());
      this.niQ.getSettings().setUserAgentString((String)localObject1);
      this.niQ.cJS();
      this.gGp = new com.tencent.mm.ui.tools.j(this.mController.uMN);
      this.gGp.a(this.niQ, this, null);
      this.gGp.d(new WebViewUI.19(this));
      setBackBtn(new WebViewUI.20(this), cdZ());
      if (ceb())
      {
        localObject1 = (WebViewKeyboardLinearLayout)findViewById(R.h.webview_keyboard_ll);
        ((WebViewKeyboardLinearLayout)localObject1).setOnkbdStateListener(new WebViewUI.46(this, (WebViewKeyboardLinearLayout)localObject1));
      }
      this.rns = ((MMFalseProgressBar)findViewById(R.h.web_falseprogress));
      super.setTitleBarDoubleClickListener(new WebViewUI.21(this));
      return;
      setMMTitle("");
      break;
      label1226:
      localObject1 = String.valueOf(((g)localObject3).rmW.getId());
      break label433;
      label1241:
      localObject2 = String.valueOf(((g)localObject3).rmX.getId());
      break label446;
      label1257:
      ((g)localObject1).rnj = false;
      break label609;
      label1265:
      ((g)localObject1).lh(true);
    }
  }
  
  public void lj(boolean paramBoolean)
  {
    this.rpm = paramBoolean;
    if (this.niQ == null)
    {
      y.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
      return;
    }
    enableOptionMenu(paramBoolean);
    showOptionMenu(paramBoolean);
    boolean bool1 = getIntent().getBooleanExtra("show_feedback", false);
    if (bool1) {
      showOptionMenu(bool1);
    }
    int i = R.g.mm_title_btn_menu;
    if (cek() != null) {
      i = R.k.mm_title_btn_jd;
    }
    getIntent().getStringExtra("srcUsername");
    cel();
    bool1 = getIntent().getBooleanExtra("KRightBtn", false);
    boolean bool2 = getIntent().getBooleanExtra("KShowFixToolsBtn", false);
    y.i("MicroMsg.WebViewUI", "banRightBtn:%b, showFixToolsBtn:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (!bool1)
    {
      if (bool2) {
        addIconOptionMenu(1, R.k.fix_tools_entry, new WebViewUI.43(this));
      }
      WebViewUI.44 local44 = new WebViewUI.44(this);
      View.OnLongClickListener localOnLongClickListener = this.rpt;
      this.mController.addIconOptionMenu(0, i, local44, localOnLongClickListener);
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      lm(paramBoolean);
      return;
    }
  }
  
  public final void lm(boolean paramBoolean)
  {
    String str = this.niQ.getUrl();
    if (paramBoolean)
    {
      showOptionMenu(0, false);
      this.roA.put(str, Boolean.valueOf(true));
    }
    do
    {
      return;
      showOptionMenu(0, true);
    } while (!this.roA.containsKey(str));
    this.roA.remove(str);
  }
  
  public final boolean needShowIdcError()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.gGw.b(this, paramInt1, paramInt2, paramIntent)) {}
    while ((com.tencent.mm.plugin.webview.modeltools.a.c(this, paramInt1, paramInt2, paramIntent)) || (paramInt1 != 777)) {
      return;
    }
    Bundle localBundle = null;
    if (paramIntent != null) {
      localBundle = paramIntent.getBundleExtra("result_data");
    }
    if ((localBundle != null) && (localBundle.getString("go_next", "").equals("gdpr_confirm_continue")))
    {
      y.i("MicroMsg.WebViewUI", "gdpr continue:true");
      return;
    }
    y.i("MicroMsg.WebViewUI", "gdpr continue:false");
    paramIntent = new Intent();
    localBundle = new Bundle();
    localBundle.putString("go_next", "gdpr_confirm_logout");
    paramIntent.putExtra("result_data", localBundle);
    this.roY = true;
    h.rnm.close();
    setResult(-1, paramIntent);
    finish();
  }
  
  public void onCancel()
  {
    if (this.niQ != null)
    {
      if (!this.rpo) {
        break label30;
      }
      this.niQ.setOnLongClickListener(this.rpp);
    }
    for (;;)
    {
      super.onCancel();
      return;
      label30:
      this.niQ.setOnLongClickListener(null);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.rpl != paramConfiguration.orientation)
    {
      localView = cdS();
      if (localView != null) {
        break label32;
      }
    }
    label32:
    for (View localView = null; localView == null; localView = (View)localView.getParent()) {
      return;
    }
    localView.dispatchConfigurationChanged(paramConfiguration);
    localView.requestLayout();
    this.rpl = paramConfiguration.orientation;
  }
  
  @TargetApi(11)
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.WebViewUI", "onCreate" + hashCode());
    this.rgh = new WebViewUI.ac(this);
    Tk(caV());
    this.rpg = new i(this);
    paramBundle = this.rpg;
    int i;
    if (paramBundle.rqZ != null)
    {
      if (!paramBundle.rqZ.aoZ()) {
        break label2452;
      }
      i = 1;
    }
    for (;;)
    {
      label96:
      label236:
      boolean bool1;
      if (i != 0)
      {
        paramBundle.rqY = true;
        y.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleParams, webViewUI#%s, disableLightActionbarStyle:%b", new Object[] { paramBundle.rqZ, Boolean.valueOf(paramBundle.rqY) });
        this.rnS = getIntent().getIntExtra("geta8key_session_id", (int)System.currentTimeMillis());
        this.rnU = getIntent().getByteArrayExtra("geta8key_cookie");
        this.rnG = caV();
        this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
        this.rnQ = getIntent().getBooleanExtra("from_shortcut", false);
        this.kXY = getIntent().getStringExtra("status_bar_style");
        this.kXX = getIntent().getIntExtra("customize_status_bar_color", 0);
        if (getIntent() != null) {
          break label2626;
        }
        paramBundle = "";
        if (getIntent() != null) {
          break label2640;
        }
        bool1 = false;
        label245:
        y.i("MicroMsg.WebViewUI", "initCustomActionBarColorIfNeed isNativeStyle is %b", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break label2655;
        }
        paramBundle = "white";
        CG(-16777216);
      }
      try
      {
        label280:
        i = Color.parseColor(paramBundle);
        paramBundle = Integer.valueOf(i);
        label290:
        if (paramBundle != null)
        {
          localObject1 = new Bundle(1);
          ((Bundle)localObject1).putInt("set_navigation_bar_color_color", paramBundle.intValue());
          ((Bundle)localObject1).putInt("set_navigation_bar_color_alpha", 255);
          T((Bundle)localObject1);
          if (!getIntent().hasExtra("customize_status_bar_color")) {
            this.kXX = paramBundle.intValue();
          }
        }
        label354:
        this.caS = caV();
        this.roN = getIntent().getBooleanExtra("show_native_web_view", false);
        this.rnF = getIntent().getBooleanExtra("key_trust_url", false);
        y.i("MicroMsg.WebViewUI", "albie: trustUrl : %b.", new Object[] { Boolean.valueOf(this.rnF) });
        roX += 1;
        roa.add(new WebViewUI.ab(this));
        if (roa.size() > 1)
        {
          paramBundle = (WebViewUI.ab)roa.get(roa.size() - 2);
          if ((paramBundle.fOk != null) && (paramBundle.fOk.get() != null)) {
            ((WebViewUI)paramBundle.fOk.get()).li(false);
          }
        }
        y.i("MicroMsg.WebViewUI", "initView , rawUrl = %s ", new Object[] { this.caS });
        this.bYM = bk.pm(getIntent().getStringExtra("KPublisherId"));
        this.cfb = Ts(getIntent().getStringExtra("geta8key_username"));
        paramBundle = this.rfg.ccd();
        i = this.cfb;
        localObject1 = this.bYM;
        paramBundle.cfb = i;
        paramBundle.rgH = ((String)localObject1);
        this.handler = new com.tencent.mm.sdk.platformtools.ah();
        if (this.rfg != null)
        {
          paramBundle = this.rfg;
          localObject1 = getIntent().getBundleExtra("mm_report_bundle");
          if (localObject1 != null)
          {
            if (paramBundle.rgv != null) {
              paramBundle.rgv.kke = null;
            }
            paramBundle.rgv = new an.b(paramBundle, (Bundle)localObject1);
            bool1 = true;
            label653:
            this.rnI = bool1;
            paramBundle = getIntent().getBundleExtra("close_window_confirm_info");
            if (paramBundle != null) {
              this.roC = WebViewUI.d.V(paramBundle);
            }
            if (Build.VERSION.SDK_INT >= 11) {
              getWindow().setFlags(16777216, 16777216);
            }
            getWindow().setFormat(-3);
            this.rps.clear();
            this.rps.put("menuItem:share:brand", Integer.valueOf(0));
            this.rps.put("menuItem:share:appMessage", Integer.valueOf(1));
            this.rps.put("menuItem:share:dataMessage", Integer.valueOf(23));
            this.rps.put("menuItem:share:timeline", Integer.valueOf(2));
            this.rps.put("menuItem:favorite", Integer.valueOf(3));
            this.rps.put("menuItem:profile", Integer.valueOf(5));
            this.rps.put("menuItem:addContact", Integer.valueOf(5));
            this.rps.put("menuItem:copyUrl", Integer.valueOf(6));
            this.rps.put("menuItem:openWithSafari", Integer.valueOf(7));
            this.rps.put("menuItem:share:email", Integer.valueOf(8));
            this.rps.put("menuItem:delete", Integer.valueOf(9));
            this.rps.put("menuItem:exposeArticle", Integer.valueOf(10));
            this.rps.put("menuItem:setFont", Integer.valueOf(11));
            this.rps.put("menuItem:editTag", Integer.valueOf(12));
            this.rps.put("menuItem:readMode", Integer.valueOf(14));
            this.rps.put("menuItem:originPage", Integer.valueOf(14));
            this.rps.put("menuItem:share:qq", Integer.valueOf(20));
            this.rps.put("menuItem:share:weiboApp", Integer.valueOf(21));
            this.rps.put("menuItem:share:QZone", Integer.valueOf(22));
            this.rps.put("menuItem:share:Facebook", Integer.valueOf(33));
            this.rps.put("menuItem:share:enterprise", Integer.valueOf(24));
            this.rps.put("menuItem:refresh", Integer.valueOf(28));
            this.rps.put("menuItem:share:wework", Integer.valueOf(25));
            this.rps.put("menuItem:share:weread", Integer.valueOf(26));
            this.rps.put("menuItem:addShortcut", Integer.valueOf(29));
            this.rps.put("menuItem:search", Integer.valueOf(31));
            this.rps.put("menuItem:readArticle", Integer.valueOf(34));
            this.rps.put("menuItem:minimize", Integer.valueOf(35));
            this.rps.put("menuItem:cancelMinimize", Integer.valueOf(36));
            long l = System.currentTimeMillis();
            v.a.eO(this);
            y.d("MicroMsg.WebViewUI", "initWebView, check Tbs time consumed = %d(ms)", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
            bool1 = getIntent().getBooleanExtra("usePlugin", true);
            bool2 = getIntent().getBooleanExtra("zoom", true);
            bool3 = getIntent().getBooleanExtra("useJs", true);
            this.niQ = bZI();
            this.niQ.wku = this;
            if ((this.niQ == null) || (this.niQ.getIsX5Kernel()) || (com.tencent.mm.compatible.util.d.gF(19))) {}
          }
        }
      }
      catch (Exception paramBundle)
      {
        try
        {
          boolean bool2;
          boolean bool3;
          paramBundle = new com.tencent.mm.compatible.loader.c(this.niQ, "mSysWebView", null).get();
          y.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { paramBundle });
          paramBundle = new com.tencent.mm.compatible.loader.c(paramBundle, "mProvider", null).get();
          y.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { paramBundle });
          paramBundle = new com.tencent.mm.compatible.loader.c(paramBundle, "mWebViewCore", null).get();
          y.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { paramBundle });
          paramBundle = new com.tencent.mm.compatible.loader.c(paramBundle, "sWebCoreHandler", null).get();
          y.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { paramBundle });
          paramBundle = new com.tencent.mm.compatible.loader.c(paramBundle, "mLooper", null).get();
          y.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { paramBundle });
          paramBundle = new com.tencent.mm.compatible.loader.c(paramBundle, "mThread", null).get();
          y.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { paramBundle });
          if ((paramBundle instanceof Thread))
          {
            paramBundle = (Thread)paramBundle;
            y.i("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { paramBundle.getState() });
            if (paramBundle.getState() == Thread.State.WAITING) {
              paramBundle.interrupt();
            }
          }
          label1596:
          this.niQ.getSettings().setJavaScriptEnabled(bool3);
          this.niQ.getSettings().setPluginsEnabled(bool1);
          this.niQ.getSettings().cSs();
          this.niQ.getSettings().setBuiltInZoomControls(bool2);
          this.niQ.getSettings().setUseWideViewPort(true);
          this.niQ.getSettings().setLoadWithOverviewMode(true);
          this.niQ.getSettings().cSn();
          this.niQ.getSettings().cSm();
          this.niQ.getSettings().setGeolocationEnabled(true);
          this.niQ.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
          this.niQ.getSettings().cSu();
          this.niQ.getSettings().cSq();
          this.niQ.getSettings().setAppCachePath(getDir("webviewcache", 0).getAbsolutePath());
          this.niQ.getSettings().cSp();
          this.niQ.getSettings().cSr();
          this.niQ.getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.dOO + "databases/");
          com.tencent.xweb.b.cSe().cSf();
          com.tencent.xweb.b.cSe().c(this.niQ);
          paramBundle = (WindowManager)getApplicationContext().getSystemService("window");
        }
        catch (Exception paramBundle)
        {
          try
          {
            localObject2 = com.tencent.xweb.WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
            ((Field)localObject2).setAccessible(true);
            localObject1 = ((Field)localObject2).get(null);
            if (localObject1 == null)
            {
              label1876:
              this.rbN = com.tencent.mm.plugin.webview.ui.tools.bag.o.a(new com.tencent.mm.plugin.webview.ui.tools.bag.q(this, this.niQ), caZ());
              this.rbN.TD(this.caS);
              cdN();
              this.gGo = new f((JsapiPermissionWrapper)getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper)getIntent().getParcelableExtra("hardcode_general_ctrl"), new WebViewUI.45(this));
              initView();
              zU("onCreate");
              this.gVe = this.niQ.getSettings().getUserAgentString();
              this.fromScene = getIntent().getIntExtra("from_scence", 0);
              y.d("MicroMsg.WebViewUI", " onCreate fromScene %d", new Object[] { Integer.valueOf(this.fromScene) });
              this.bIB = com.tencent.mm.model.u.ij(bk.pm(hashCode()));
              y.i("MicroMsg.WebViewUI", " onCreate sessionId %s", new Object[] { this.bIB });
              if (aq.isConnected(getApplicationContext()))
              {
                if (!aq.isWifi(getApplicationContext())) {
                  break label2736;
                }
                this.networkType = 1;
                label2096:
                y.i("MicroMsg.WebViewUI", "get networkType %d", new Object[] { Integer.valueOf(this.networkType) });
              }
              this.width = getResources().getDisplayMetrics().widthPixels;
              this.height = getResources().getDisplayMetrics().heightPixels;
              paramBundle = this.rfg.ccj();
              i = this.cfb;
              localObject1 = this.bYM;
              paramBundle.cfb = i;
              paramBundle.rgH = ((String)localObject1);
              paramBundle.url = this.caS;
              localObject1 = this.rfg.ccp();
              paramBundle = this.caS;
              y.i("MicroMsg.WebviewReporter.DomainReporter", "setRawUrl, value = %s", new Object[] { paramBundle });
            }
          }
          catch (Exception paramBundle)
          {
            try
            {
              localObject2 = Uri.parse(paramBundle);
              if ((((Uri)localObject2).getScheme() != null) && (!((Uri)localObject2).getScheme().toLowerCase().startsWith("http"))) {
                y.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl scheme is not http/https, skip, scheme = %s", new Object[] { ((Uri)localObject2).getScheme() });
              }
            }
            catch (Exception paramBundle)
            {
              try
              {
                label2268:
                this.kXV = this.mController.contentView;
                if (this.kXV != null)
                {
                  bac();
                  ((ViewGroup)((ViewGroup)getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
                  {
                    public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
                    {
                      WebViewUI.this.bac();
                    }
                  });
                }
              }
              catch (Exception paramBundle)
              {
                try
                {
                  Object localObject1;
                  Object localObject2;
                  label2318:
                  if (this.roJ) {
                    if (cdP()) {
                      cdQ();
                    }
                  }
                  for (;;)
                  {
                    this.gAS = new com.tencent.mm.bl.a(this.mController.uMN, this.gAT);
                    this.rpa.DS().O(new WebViewUI.56(this));
                    this.rpd = new WebViewClipBoardHelper(this);
                    this.rpj.cqo();
                    this.rol.cqo();
                    if (this.rpg != null)
                    {
                      paramBundle = this.rpg;
                      if (paramBundle.rqZ != null)
                      {
                        paramBundle.nja = paramBundle.rqZ.niQ;
                        if (!paramBundle.rqY) {
                          break label2975;
                        }
                        y.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle true");
                      }
                    }
                    return;
                    label2452:
                    localObject1 = paramBundle.rqZ.getIntent();
                    if (localObject1 != null)
                    {
                      if (((Intent)localObject1).getBooleanExtra("disable_light_actionbar_style", false))
                      {
                        y.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, KDisableLightActionbarStyle is true");
                        i = 1;
                        break;
                      }
                      localObject2 = ((Intent)localObject1).getStringExtra("status_bar_style");
                      if ((!bk.bl((String)localObject2)) && (((String)localObject2).equals("black")))
                      {
                        y.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KStatusBarStyle");
                        i = 1;
                        break;
                      }
                      if (((Intent)localObject1).getIntExtra("customize_status_bar_color", 0) != 0)
                      {
                        y.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KCustomizeStatusBarColor");
                        i = 1;
                        break;
                      }
                      if (((Intent)localObject1).getBooleanExtra("open_custom_style_url", false))
                      {
                        y.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KOpenCustomStyleUrl");
                        i = 1;
                        break;
                      }
                      if (((Intent)localObject1).getBooleanExtra("show_full_screen", false))
                      {
                        y.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, webview is fullscreen");
                        i = 1;
                        break;
                      }
                    }
                    i = 0;
                    break;
                    paramBundle.rqY = false;
                    break label96;
                    label2626:
                    paramBundle = getIntent().getStringExtra("custom_action_bar_color");
                    break label236;
                    label2640:
                    bool1 = getIntent().getBooleanExtra("open_custom_style_url", false);
                    break label245;
                    label2655:
                    if (bk.bl(paramBundle)) {
                      break label354;
                    }
                    break label280;
                    paramBundle = paramBundle;
                    paramBundle = null;
                    break label290;
                    bool1 = false;
                    break label653;
                    bool1 = false;
                    break label653;
                    paramBundle = paramBundle;
                    y.e("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { paramBundle });
                    break label1596;
                    localObject2 = ((Field)localObject2).getType().getDeclaredField("mWindowManager");
                    ((Field)localObject2).setAccessible(true);
                    ((Field)localObject2).set(localObject1, paramBundle);
                    break label1876;
                    paramBundle = paramBundle;
                    break label1876;
                    label2736:
                    if (aq.is4G(getApplicationContext()))
                    {
                      this.networkType = 4;
                      break label2096;
                    }
                    if (aq.is3G(getApplicationContext()))
                    {
                      this.networkType = 3;
                      break label2096;
                    }
                    if (!aq.is2G(getApplicationContext())) {
                      break label2096;
                    }
                    this.networkType = 2;
                    break label2096;
                    localObject2 = ((Uri)localObject2).getHost();
                    if ((localObject2 == null) || (((String)localObject2).toLowerCase().endsWith(".qq.com")))
                    {
                      y.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl, host is .qq.com, skip, host = %s", new Object[] { localObject2 });
                      break label2268;
                      localException = localException;
                      y.e("MicroMsg.WebviewReporter.DomainReporter", "parse rawUrl fail, rawUrl = %s", new Object[] { paramBundle });
                      break label2268;
                    }
                    localException.keZ = true;
                    break label2268;
                    paramBundle = paramBundle;
                    y.e("MicroMsg.WebViewUI", "fixContentMargin error : %s", new Object[] { paramBundle.getMessage() });
                    break label2318;
                    if (!com.tencent.mm.compatible.util.d.gF(21)) {
                      break label2958;
                    }
                    paramBundle = (ViewGroup)((ViewGroup)getWindow().getDecorView()).getChildAt(0);
                    paramBundle.setOnApplyWindowInsetsListener(new WebViewUI.70(this, paramBundle));
                  }
                }
                catch (Exception paramBundle)
                {
                  for (;;)
                  {
                    y.e("MicroMsg.WebViewUI", "tryToExpandToStatusBar error : %s", new Object[] { paramBundle.getMessage() });
                    continue;
                    label2958:
                    ((ViewGroup)getWindow().getDecorView()).setFitsSystemWindows(true);
                  }
                  label2975:
                  y.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle false");
                  paramBundle.ceO();
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    supportRequestWindowFeature(5);
    supportRequestWindowFeature(9);
    setProgressBarIndeterminateVisibility(false);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    try
    {
      if ((paramView instanceof android.webkit.WebView))
      {
        paramView = this.niQ.getHitTestResult();
        if (paramView == null) {
          return;
        }
        if ((paramView.mType != 5) && (paramView.mType != 8)) {
          return;
        }
        b(paramContextMenu, paramView);
        return;
      }
    }
    catch (Exception paramContextMenu)
    {
      y.e("MicroMsg.WebViewUI", "onCreateContextMenu exp %s", new Object[] { paramContextMenu.getMessage() });
      return;
    }
    if ((paramView instanceof MMWebView))
    {
      paramView = ((MMWebView)paramView).getHitTestResult();
      if ((paramView != null) && ((paramView.mType == 5) || (paramView.mType == 8))) {
        a(paramContextMenu, paramView);
      }
    }
  }
  
  @TargetApi(11)
  public void onDestroy()
  {
    y.i("MicroMsg.WebViewUI", "onDestroy " + hashCode());
    super.onDestroy();
    Object localObject1 = cdR();
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = getSharedPreferences("webview_url_prefs", 4).getString("url", null);
      if ((localObject3 != null) && (((String)localObject1).equals(localObject3)))
      {
        localObject1 = getSharedPreferences("webview_url_prefs", 4).edit();
        ((SharedPreferences.Editor)localObject1).remove("url");
        ((SharedPreferences.Editor)localObject1).apply();
      }
    }
    for (;;)
    {
      this.rbN.ceY();
      if (!this.roZ) {}
      try
      {
        if (this.gGn != null)
        {
          this.gGn.Co(hashCode());
          this.gGn.Ch(hashCode());
        }
        y.w("MicroMsg.WebViewUI", "invoke onWebViewUIDestroy");
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          int j;
          int i;
          y.w("MicroMsg.WebViewUI", "onDestroy, remove callback and invoke event on webview destroy, ex = " + localException1);
          continue;
          i -= 1;
        }
        this.rpr.clear();
        localObject2 = this.rpa;
        if ((((com.tencent.mm.plugin.webview.model.b)localObject2).rff == null) || (((com.tencent.mm.plugin.webview.model.b)localObject2).rff.mnU.getLooper() == null)) {
          break label563;
        }
        ((com.tencent.mm.plugin.webview.model.b)localObject2).rff.mnU.getLooper().quit();
        ((com.tencent.mm.plugin.webview.model.b)localObject2).rff = null;
        localObject2 = this.rph;
        ((ak)localObject2).rgc.clear();
        ((ak)localObject2).rgd.clear();
        ((ak)localObject2).rge.clear();
        ((ak)localObject2).rga.clear();
        ((ak)localObject2).rgb.clear();
        if (this.rpD == null) {
          break label640;
        }
        this.rpD.dismiss();
        this.rpD = null;
        if (this.rpA == null) {
          break label659;
        }
        this.rpA.dismiss();
        this.rpA = null;
        if (!this.roi.ceN()) {
          break label676;
        }
        CF(233);
        if (!this.roj.ceN()) {
          break label693;
        }
        CF(673);
        if (!this.rok.ceN()) {
          break label710;
        }
        CF(666);
        this.roy.clear();
        this.roB.clear();
        this.rpj.dead();
        this.rol.dead();
        if (com.tencent.xweb.c.il(com.tencent.mm.sdk.platformtools.ae.getContext()) == null) {
          break label759;
        }
        y.i("MicroMsg.WebViewUI", "now force sync the cookie between ram and db");
        com.tencent.xweb.c.sync();
        if (!cel()) {
          break label817;
        }
      }
      if (this.gAS != null) {
        this.gAS.disable();
      }
      this.roY = true;
      roX -= 1;
      j = hashCode();
      i = roa.size() - 1;
      if (i >= 0)
      {
        if (((WebViewUI.ab)roa.get(i)).id != j) {
          break;
        }
        roa.remove(i);
      }
      i("", bk.UX(), 0);
      localObject1 = o.a.ccx();
      i = hashCode();
      ((com.tencent.mm.plugin.webview.modelcache.o)localObject1).rht.put(i, Boolean.valueOf(false));
      localObject1 = this.rfg.ccl();
      ((an.h)localObject1).rgD = new Object[] { this.caS, Integer.valueOf(2) };
      ((an.h)localObject1).c(this.gGn);
      this.rfg.c(this.gGn);
      localObject1 = this.rfg;
      ((an)localObject1).rgl = null;
      ((an)localObject1).rgj = null;
      ((an)localObject1).rgk = null;
      ((an)localObject1).rgi = null;
      ((an)localObject1).rgn = null;
      ((an)localObject1).rgo = null;
      ((an)localObject1).rgp = null;
      ((an)localObject1).rgq = null;
      if (((an)localObject1).rgv != null)
      {
        ((an)localObject1).rgv.kke = null;
        ((an)localObject1).rgv = null;
      }
      zU("onDestroy");
      this.rox.clear();
      localObject1 = this.rpr.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (SparseBooleanArray)((Iterator)localObject1).next();
        if (localObject3 != null) {
          ((SparseBooleanArray)localObject3).clear();
        }
      }
      y.w("MicroMsg.WebViewUI", "currentURL == null, qbrowser.url may be not accurate");
    }
    try
    {
      Object localObject2;
      label563:
      label693:
      label710:
      label759:
      if (this.gGn != null)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("srcUsername", getIntent().getStringExtra("srcUsername"));
        this.gGn.a(30, (Bundle)localObject2, hashCode());
      }
      label640:
      label659:
      label676:
      label817:
      y.v("MicroMsg.WebViewUI", "on destroy isNeedCallbackMMRpt[%b]", new Object[] { Boolean.valueOf(this.rnI) });
      if (this.rnI) {}
      try
      {
        localObject2 = getIntent().getBundleExtra("mm_report_bundle");
        if (!bk.bl(((Bundle)localObject2).getString("mm_event_class"))) {
          if (this.gGn != null)
          {
            ((Bundle)localObject2).putLong("key_activity_browse_time", czu());
            this.gGn.f(250, (Bundle)localObject2);
          }
        }
      }
      catch (Exception localException8)
      {
        try
        {
          if (this.gGn != null)
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putLong("key_activity_browse_time", czu());
            this.gGn.f(251, (Bundle)localObject2);
          }
        }
        catch (Exception localException8)
        {
          try
          {
            if (this.gGn != null)
            {
              localObject2 = this.gGn.f(19, null);
              if (localObject2 != null)
              {
                boolean bool = ((Bundle)localObject2).getBoolean("webview_video_proxy_init");
                y.i("MicroMsg.WebViewUI", "onDestroy, has init = %b, webviewHoldingCounter = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(roX) });
                if ((bool) && (roX <= 0))
                {
                  FactoryProxyManager.getPlayManager().deinit();
                  this.gGn.f(75, null);
                }
              }
            }
            if (this.iAC == null) {}
          }
          catch (Exception localException8)
          {
            try
            {
              unbindService(this.iAC);
              if (this.rbk != null) {
                this.rbk.detach();
              }
              this.rnZ.clear();
              if (this.rop != null)
              {
                localObject2 = this.rop;
                y.i("MicroMsg.WebView.MMSslErrorHandler", "detach");
                ((b)localObject2).context = null;
                ((b)localObject2).rlh = null;
                ((b)localObject2).rli.clear();
                ((b)localObject2).rlj.clear();
              }
              if (this.ror != null) {
                this.ror.detach();
              }
              if (Build.VERSION.SDK_INT >= 11)
              {
                this.niQ.removeJavascriptInterface("MicroMsg");
                this.niQ.removeJavascriptInterface("JsApi");
              }
            }
            catch (Exception localException8)
            {
              try
              {
                this.niQ.setWebChromeClient(null);
                this.niQ.setWebViewClient(null);
                this.niQ.setOnTouchListener(null);
                this.niQ.setOnLongClickListener(null);
                this.niQ.setVisibility(8);
                this.niQ.removeAllViews();
                this.niQ.clearView();
                this.rpb.ccT();
                if (this.gGo != null)
                {
                  localObject2 = this.gGo;
                  y.i("MicroMsg.WebViewPermission", "detach");
                  ((f)localObject2).reE.clear();
                  ((f)localObject2).reE = null;
                  this.gGo = null;
                }
              }
              catch (Exception localException8)
              {
                try
                {
                  this.rpn.release();
                }
                catch (Exception localException8)
                {
                  try
                  {
                    this.niQ.destroy();
                    localObject2 = this.rpd;
                  }
                  catch (Exception localException8)
                  {
                    try
                    {
                      for (;;)
                      {
                        ((WebViewClipBoardHelper)localObject2).riO.removePrimaryClipChangedListener((ClipboardManager.OnPrimaryClipChangedListener)localObject2);
                        ((WebViewClipBoardHelper)localObject2).riO = null;
                        label1320:
                        this.niQ = null;
                        System.gc();
                        return;
                        y.w("MicroMsg.WebViewUI", "webview on destroy callback mm but eventclass is null");
                        continue;
                        localException2 = localException2;
                        y.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", new Object[] { localException2.toString() });
                        continue;
                        localException3 = localException3;
                        y.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", new Object[] { localException3.toString() });
                        continue;
                        localException4 = localException4;
                        y.e("MicroMsg.WebViewUI", "deinit video player failed : %s", new Object[] { localException4.getMessage() });
                        continue;
                        localException5 = localException5;
                        y.printErrStackTrace("MicroMsg.WebViewUI", localException5, "unbindService", new Object[0]);
                        continue;
                        localException6 = localException6;
                        y.e("MicroMsg.WebViewUI", "onDestroy, set web infos to null,  ex = %s", new Object[] { localException6.getMessage() });
                        continue;
                        localException7 = localException7;
                        y.e("MicroMsg.WebViewUI", "onDestroy, remove view,  ex = " + localException7.getMessage());
                      }
                      localException8 = localException8;
                      y.w("MicroMsg.WebViewUI", "onDestroy, viewWV destroy, ex = %s", new Object[] { localException8.getMessage() });
                    }
                    catch (Exception localException9)
                    {
                      break label1320;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    catch (Exception localException10)
    {
      break label817;
    }
  }
  
  public void onDrag()
  {
    if (this.niQ != null) {
      this.niQ.setOnLongClickListener(new WebViewUI.24(this));
    }
    super.onDrag();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.niQ.hasEnteredFullscreen())) {
      this.niQ.leaveFullscreen();
    }
    label220:
    label225:
    label231:
    do
    {
      for (;;)
      {
        return true;
        if ((paramInt == 4) && (this.rod != null) && (this.roc != null) && (this.roe != null)) {
          try
          {
            this.roe.onHideCustomView();
            paramKeyEvent = this.rfg.ccl();
            paramKeyEvent.rgD = new Object[] { this.caS, Integer.valueOf(1) };
            paramKeyEvent.c(this.gGn);
            return true;
          }
          catch (Exception paramKeyEvent)
          {
            for (;;)
            {
              y.printErrStackTrace("MicroMsg.WebViewUI", paramKeyEvent, "onkeydown", new Object[0]);
            }
          }
        }
        if (paramInt == 4)
        {
          if ((this.rnC == null) || (!this.rnC.isShown())) {
            break label220;
          }
          this.rnC.hide();
          cem();
        }
        for (int i = 1; i == 0; i = 0)
        {
          if (paramInt != 4) {
            break label231;
          }
          if ((!this.niQ.canGoBack()) || (!this.rnH)) {
            break label225;
          }
          cdU();
          paramKeyEvent = this.rfg.ccl();
          paramKeyEvent.rgD = new Object[] { this.caS, Integer.valueOf(1) };
          paramKeyEvent.c(this.gGn);
          return true;
        }
      }
      h.rnm.close();
    } while (((paramInt == 4) && (cev()) && (caS())) || ((paramInt == 4) && (this.rbN.CL(22))));
    if (paramInt == 4) {
      cex();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) && (!this.rpm)) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.modelstat.d.b(4, "WebViewUI_" + Ts(bk.pm(this.roG)), hashCode());
    com.tencent.mm.modelstat.d.h("WebViewUI_" + Ts(bk.pm(this.roG)), this.iaq, bk.UX());
    Object localObject = this.rfg.cch();
    if (((an.k)localObject).rgz != -1L) {
      ((an.k)localObject).gYS += bk.cp(((an.k)localObject).rgz) / 1000L;
    }
    localObject = this.rfg.cci();
    if (((an.a)localObject).rgz != -1L) {
      ((an.a)localObject).gYS += bk.cp(((an.a)localObject).rgz);
    }
    localObject = h.rnm;
    y.v("MicroMsg.WebViewReportUtil", "onPause traceid %s", new Object[] { ((h)localObject).oAk });
    if (((h)localObject).dYj) {
      y.i("MicroMsg.WebViewReportUtil", "isFinish is true");
    }
    for (;;)
    {
      try
      {
        if (this.gGn != null)
        {
          localObject = this.gGn.f(19, null);
          if (localObject != null)
          {
            boolean bool = ((Bundle)localObject).getBoolean("webview_video_proxy_init");
            y.i("MicroMsg.WebViewUI", "onPause, has init = %b", new Object[] { Boolean.valueOf(bool) });
            if (bool) {
              FactoryProxyManager.getPlayManager().appToBack();
            }
          }
        }
      }
      catch (Exception localException1)
      {
        y.e("MicroMsg.WebViewUI", "notify app toback failed : %s", new Object[] { localException1.getMessage() });
        continue;
      }
      cem();
      Tj("onPause");
      zU("onPause");
      if (this.roe != null) {
        y.i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
      }
      try
      {
        this.roe.onHideCustomView();
        return;
      }
      catch (Exception localException2)
      {
        y.printErrStackTrace("MicroMsg.WebViewUI", localException2, "onPause", new Object[0]);
      }
      if (!bk.bl(((h)localObject).oAk)) {
        ((h)localObject).jdMethod_if(6);
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 0;
    paramArrayOfString = this.gGw;
    if (paramArrayOfString.rhW == null)
    {
      paramArrayOfString.ccE();
      paramInt = i;
      if (paramInt != 0) {}
      return;
    }
    if (119 == paramInt)
    {
      if (paramArrayOfInt[0] != 0) {
        break label80;
      }
      paramArrayOfInt = (Intent)paramArrayOfString.rhW.first;
      paramInt = ((Integer)paramArrayOfString.rhW.second).intValue();
      paramArrayOfString.rhW = null;
      startActivityForResult(paramArrayOfInt, paramInt);
    }
    for (;;)
    {
      paramInt = 1;
      break;
      label80:
      paramArrayOfString.rhW = null;
      paramArrayOfString.a(this, 0, null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (cdR() != null) {
      Tk(cdR());
    }
    for (;;)
    {
      this.rfg.cch().rgz = bk.UZ();
      this.rfg.cci().rgz = bk.UZ();
      Object localObject = h.rnm;
      y.v("MicroMsg.WebViewReportUtil", "onResume traceid %s", new Object[] { ((h)localObject).oAk });
      if (!bk.bl(((h)localObject).oAk)) {
        ((h)localObject).jdMethod_if(7);
      }
      int i;
      if (!this.rpk)
      {
        int j = hashCode();
        i = roa.size() - 1;
        if (i >= 0)
        {
          if (((WebViewUI.ab)roa.get(i)).id == j) {
            roa.remove(i);
          }
        }
        else {
          roa.add(new WebViewUI.ab(this));
        }
      }
      else
      {
        this.rpk = false;
        if (this.rob)
        {
          li(true);
          this.rob = false;
        }
        cdW();
        if (this.gGn == null) {}
      }
      try
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("screen_orientation", this.screenOrientation);
        this.gGn.f(83, (Bundle)localObject);
        if ((getIntent().getBooleanExtra("disable_swipe_back", false)) && (getSwipeBackLayout() != null)) {
          getSwipeBackLayout().setEnableGesture(false);
        }
        Tj("onResume");
        zU("onResume");
        try
        {
          if (this.gGn != null)
          {
            localObject = this.gGn.f(19, null);
            if (localObject != null)
            {
              boolean bool = ((Bundle)localObject).getBoolean("webview_video_proxy_init");
              y.i("MicroMsg.WebViewUI", "onResume, has init = %b", new Object[] { Boolean.valueOf(bool) });
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
            y.e("MicroMsg.WebViewUI", "notify app tofront failed : %s", new Object[] { localException2.getMessage() });
          }
        }
        this.iaq = bk.UX();
        com.tencent.mm.modelstat.d.b(3, "WebViewUI_" + Ts(bk.pm(this.roG)), hashCode());
        return;
        Tk(caV());
        continue;
        i -= 1;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          y.e("MicroMsg.WebViewUI", "ac_set_screen_orientation : " + localException1.getMessage());
        }
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    y.i("MicroMsg.WebViewUI", "edw onStart");
  }
  
  public void onStop()
  {
    y.i("MicroMsg.WebViewUI", "edw onStop");
    O(true, true);
    super.onStop();
  }
  
  public void onSwipeBack()
  {
    if (this.niQ != null)
    {
      if (!this.rpo) {
        break label34;
      }
      this.niQ.setOnLongClickListener(this.rpp);
    }
    for (;;)
    {
      XM();
      super.onSwipeBack();
      return;
      label34:
      this.niQ.setOnLongClickListener(null);
    }
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.v("MicroMsg.WebViewUI", "l=%d t=%d oldl=%d oldt=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if ((this.rpg != null) && (!this.rpg.rqY)) {
      this.rpg.ceP();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.rnA)) {
      dq(getWindow().getDecorView());
    }
  }
  
  public void s(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
  }
  
  public final void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    super.setBackBtn(paramOnMenuItemClickListener, paramInt);
    if ((com.tencent.mm.compatible.util.d.gF(21)) && (bad())) {
      czn();
    }
  }
  
  public void setMMTitle(String paramString)
  {
    super.setMMTitle(paramString);
  }
  
  @TargetApi(21)
  public final void setStatusBarColor(int paramInt)
  {
    if (this.roJ) {
      com.tencent.mm.ui.statusbar.a.d(this.kXV, paramInt, com.tencent.mm.ui.statusbar.d.c(getWindow()));
    }
    while ((this.heA <= 0) || (com.tencent.mm.compatible.util.d.gG(21))) {
      return;
    }
    getWindow().setStatusBarColor(0);
    ViewGroup.LayoutParams localLayoutParams;
    if (this.kXW == null)
    {
      this.kXW = new View(this);
      localLayoutParams = new ViewGroup.LayoutParams(-1, this.heA);
      ((ViewGroup)findViewById(16908290)).addView(this.kXW, localLayoutParams);
    }
    for (;;)
    {
      this.kXW.setBackgroundColor(paramInt);
      return;
      localLayoutParams = this.kXW.getLayoutParams();
      if (localLayoutParams.height != this.heA)
      {
        localLayoutParams.height = this.heA;
        this.kXW.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public final void showVKB()
  {
    super.showVKB();
    if (this.rpG == -3)
    {
      this.rpG = -2;
      return;
    }
    this.rpG = -3;
  }
  
  public final void ta(int paramInt)
  {
    super.ta(paramInt);
    if ((Build.VERSION.SDK_INT >= 21) && (getWindow() != null)) {
      com.tencent.mm.ui.statusbar.a.d(this.kXV, getWindow().getStatusBarColor(), com.tencent.mm.ui.statusbar.d.c(getWindow()));
    }
  }
  
  protected final class n
  {
    private int rqP = 0;
    
    protected n() {}
    
    public final void ceL()
    {
      y.d("MicroMsg.WebViewUI", "addGetA8KeySceneEndListener, before inc count=%d", new Object[] { Integer.valueOf(this.rqP) });
      if (this.rqP == 0) {
        WebViewUI.g(WebViewUI.this, 233);
      }
      this.rqP += 1;
    }
    
    public final void ceM()
    {
      y.d("MicroMsg.WebViewUI", "removeGetA8KeySceneEndListener, before dec count=%d", new Object[] { Integer.valueOf(this.rqP) });
      this.rqP -= 1;
      if (this.rqP <= 0) {
        WebViewUI.h(WebViewUI.this, 233);
      }
    }
    
    public final boolean ceN()
    {
      y.d("MicroMsg.WebViewUI", "GetA8KeySceneEndController.hasAddListener count=%d", new Object[] { Integer.valueOf(this.rqP) });
      return this.rqP > 0;
    }
  }
  
  private final class q
    implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b
  {
    private q() {}
    
    public final boolean Tq(String paramString)
    {
      paramString = paramString.substring(17);
      if ((paramString == null) || (paramString.length() == 0)) {
        y.e("MicroMsg.WebViewUI", "handleUrl fail, username is null");
      }
      while ((WebViewUI.this.gGo == null) || (WebViewUI.this.gGo.cdI() == null) || (!WebViewUI.this.gGo.cdI().hi(2))) {
        return true;
      }
      WebViewUI.this.rbk.TN(paramString);
      return true;
    }
    
    public final boolean Ty(String paramString)
    {
      if (bk.bl(paramString)) {
        return false;
      }
      return com.tencent.mm.pluginsdk.ui.tools.s.n(paramString, "weixin://profile/");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI
 * JD-Core Version:    0.7.0.1
 */