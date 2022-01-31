package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.app.Dialog;
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
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.os.RemoteException;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
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
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings.RenderPriority;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.g.a.wc;
import com.tencent.mm.m.d.a;
import com.tencent.mm.m.d.b;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.webview.f.d.1;
import com.tencent.mm.plugin.webview.model.ah.b;
import com.tencent.mm.plugin.webview.model.ah.c;
import com.tencent.mm.plugin.webview.model.ah.d;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.plugin.webview.model.as.a;
import com.tencent.mm.plugin.webview.model.as.b;
import com.tencent.mm.plugin.webview.model.as.d;
import com.tencent.mm.plugin.webview.model.as.f;
import com.tencent.mm.plugin.webview.model.as.g;
import com.tencent.mm.plugin.webview.model.as.h;
import com.tencent.mm.plugin.webview.model.as.i;
import com.tencent.mm.plugin.webview.model.as.l;
import com.tencent.mm.plugin.webview.model.as.m;
import com.tencent.mm.plugin.webview.model.as.n;
import com.tencent.mm.plugin.webview.model.as.o;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.e.l;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.MMWebView.d;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p.a;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.t;
import com.tencent.xweb.t.a;
import com.tencent.xweb.w;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import junit.framework.Assert;

public class WebViewUI
  extends MMActivity
  implements View.OnCreateContextMenuListener, MMWebView.d
{
  private static final Pattern uRN;
  private static final Pattern uRO;
  private static final Set<String> uWd;
  private static final ArrayList<WebViewUI.z> veU;
  protected static int vfJ;
  private static WebSettings.RenderPriority vfa;
  protected String cGT;
  public volatile String cJr;
  protected int cNH;
  protected String cpW;
  private int fromScene;
  public ak handler;
  private long iHl;
  private String iIg;
  private int iPy;
  public com.tencent.mm.plugin.webview.stub.d igU;
  public k igV;
  private final com.tencent.mm.plugin.webview.modeltools.d ihd;
  protected String iyo;
  protected int jUm;
  protected int jUn;
  private int jZj;
  private ServiceConnection kDI;
  public String kdt;
  public int khm;
  private int networkType;
  protected com.tencent.mm.ui.widget.snackbar.a.b nkf;
  public int nvX;
  public String nvY;
  private long otr;
  public MMWebView pOd;
  protected boolean rNQ;
  protected int screenOrientation;
  public com.tencent.mm.plugin.webview.ui.tools.jsapi.d uQS;
  private d uRx;
  protected com.tencent.mm.plugin.webview.ui.tools.bag.h uRy;
  public as uVh;
  protected com.tencent.mm.plugin.webview.stub.e uWu;
  protected volatile String uXd;
  final com.tencent.mm.plugin.webview.modeltools.a vct;
  public boolean veA;
  private boolean veB;
  private boolean veC;
  protected boolean veD;
  private boolean veE;
  private boolean veF;
  private boolean veG;
  private boolean veH;
  protected boolean veI;
  private boolean veJ;
  protected int veK;
  private String veL;
  private boolean veM;
  protected byte[] veN;
  private boolean veO;
  private boolean veP;
  public boolean veQ;
  private View veR;
  private com.tencent.mm.sdk.platformtools.ap veS;
  private List<com.tencent.mm.plugin.webview.ui.tools.jsapi.b> veT;
  private boolean veV;
  private WebChromeClient.CustomViewCallback veW;
  private View veX;
  protected com.tencent.xweb.p veY;
  private ProgressBar veZ;
  protected boolean vec;
  public MMFalseProgressBar ved;
  public ProgressBar vee;
  public com.tencent.mm.ui.base.p vef;
  private ImageButton veg;
  private ImageButton veh;
  protected View vei;
  protected FrameLayout vej;
  public FrameLayout vek;
  protected MovingImageButton vem;
  protected boolean ven;
  private boolean veo;
  protected com.tencent.mm.bn.a vep;
  private WebViewInputFooter veq;
  protected WebViewSearchContentInputFooter ves;
  private boolean vet;
  private boolean veu;
  public String vev;
  protected boolean vew;
  protected long vex;
  private boolean vey;
  int vez;
  protected boolean vfA;
  private final Map<String, Map<String, String>> vfB;
  protected Map<String, String> vfC;
  private Map vfD;
  private int vfE;
  private String vfF;
  private boolean vfG;
  private final Map<String, String> vfH;
  private final Set<String> vfI;
  public boolean vfK;
  private boolean vfL;
  private boolean vfM;
  protected volatile boolean vfN;
  private com.tencent.mm.plugin.webview.f.d vfO;
  private com.tencent.mm.plugin.webview.model.b vfP;
  protected com.tencent.mm.plugin.webview.modeltools.n vfQ;
  protected i vfR;
  public j vfS;
  protected IUtils vfT;
  private WebViewClipBoardHelper vfU;
  protected com.tencent.mm.plugin.webview.b vfV;
  protected volatile String vfW;
  protected volatile long vfX;
  private o vfY;
  protected com.tencent.mm.plugin.webview.model.ap vfZ;
  protected WebViewUI.l vfb;
  protected WebViewUI.m vfc;
  protected WebViewUI.o vfd;
  protected WebViewUI.q vfe;
  private final com.tencent.mm.sdk.b.c<SendDataToH5FromMiniProgramEvent> vff;
  private boolean vfg;
  private int vfh;
  public com.tencent.mm.plugin.webview.ui.tools.jsapi.f vfi;
  protected boolean vfj;
  protected HashMap<String, Boolean> vfk;
  protected HashMap<String, String> vfl;
  protected HashMap<String, ArrayList<d.b>> vfm;
  protected HashMap<String, Boolean> vfn;
  protected WebViewUI.d vfo;
  protected com.tencent.mm.ui.widget.b.c vfp;
  public View vfq;
  protected String vfr;
  private boolean vfs;
  private volatile boolean vft;
  private final boolean vfu;
  private boolean vfv;
  protected volatile boolean vfw;
  protected volatile boolean vfx;
  private final Set<String> vfy;
  public boolean vfz;
  protected com.tencent.xweb.v vga;
  private com.tencent.mm.sdk.b.c<qo> vgb;
  private boolean vgc;
  protected View vgd;
  private View vge;
  private com.tencent.mm.bn.a.b vgf;
  private boolean vgg;
  public final l vgh;
  private boolean vgi;
  private View.OnLongClickListener vgj;
  String[] vgk;
  protected boolean vgl;
  public View.OnLongClickListener vgm;
  private String vgn;
  protected volatile String vgo;
  protected volatile String vgp;
  private volatile String vgq;
  protected volatile String vgr;
  private long vgs;
  private com.tencent.mm.ui.base.p vgt;
  private ah.d vgu;
  protected ah.b vgv;
  private com.tencent.mm.ui.base.i vgw;
  private long vgx;
  private String[] vgy;
  
  static
  {
    AppMethodBeat.i(8134);
    veU = new ArrayList();
    vfa = WebSettings.RenderPriority.NORMAL;
    vfJ = 0;
    uRN = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    uRO = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    Object localObject1 = new HashSet();
    uWd = (Set)localObject1;
    ((Set)localObject1).add("file:///android_asset/");
    Object localObject2 = com.tencent.mm.compatible.util.e.eQw;
    localObject1 = localObject2;
    if (!bo.isNullOrNil((String)localObject2)) {
      localObject1 = com.tencent.mm.compatible.util.e.eQw.replace("/data/user/0", "/data/data");
    }
    localObject2 = new File(com.tencent.mm.plugin.websearch.api.aa.Jk(0));
    uWd.add("file://" + ((File)localObject2).getAbsolutePath());
    File localFile1 = new File(com.tencent.mm.compatible.util.e.eQz, "fts/res");
    uWd.add("file://" + localFile1.getAbsolutePath());
    File localFile2 = new File((String)localObject1, "wenote/res");
    uWd.add("file://" + localFile2.getAbsolutePath());
    localFile2 = new File(com.tencent.mm.compatible.util.e.eQz, "wenote/res");
    uWd.add("file://" + localFile2.getAbsolutePath());
    localFile2 = new File((String)localObject1, "wxa_fts/res");
    uWd.add("file://" + localFile2.getAbsolutePath());
    ab.i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s, wxapp : %s", new Object[] { ((File)localObject2).getAbsolutePath(), localFile1.getAbsolutePath(), localFile2.getAbsolutePath() });
    localObject1 = new File((String)localObject1, "emoji/res");
    uWd.add("file://" + ((File)localObject1).getAbsolutePath());
    localObject2 = new File(com.tencent.mm.compatible.util.e.eQz, "emoji/res");
    uWd.add("file://" + ((File)localObject2).getAbsolutePath());
    ab.i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { ((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath() });
    localObject1 = new File(com.tencent.mm.plugin.websearch.api.aa.Jk(1));
    uWd.add("file://" + ((File)localObject1).getAbsolutePath());
    localObject2 = new File(com.tencent.mm.compatible.util.e.eQz, "fts_browse/res");
    uWd.add("file://" + ((File)localObject2).getAbsolutePath());
    ab.i("MicroMsg.WebViewUI", "add browse UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { ((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath() });
    localObject1 = uWd.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ab.i("MicroMsg.WebViewUI", "albie: WebViewUI white list path : %s", new Object[] { (String)((Iterator)localObject1).next() });
    }
    AppMethodBeat.o(8134);
  }
  
  public WebViewUI()
  {
    AppMethodBeat.i(7981);
    this.vec = false;
    this.screenOrientation = -1;
    this.ven = false;
    this.veo = false;
    this.cJr = null;
    this.vev = null;
    this.vew = true;
    this.vex = 0L;
    this.vey = false;
    this.cpW = "";
    this.iyo = "";
    this.vez = -1;
    this.veA = false;
    this.rNQ = true;
    this.veB = false;
    this.veC = false;
    this.veD = true;
    this.veE = false;
    this.veF = false;
    this.veG = false;
    this.veH = false;
    this.veI = false;
    this.veJ = true;
    this.veL = null;
    this.veM = false;
    this.veN = new byte[0];
    this.veO = false;
    this.uQS = null;
    this.veP = false;
    this.veQ = false;
    this.veT = new ArrayList();
    this.veV = false;
    this.igV = null;
    this.vfb = new WebViewUI.l(null);
    this.vfc = new WebViewUI.m(this);
    this.vfd = new WebViewUI.o(this);
    this.vfe = new WebViewUI.q(this);
    this.vff = new com.tencent.mm.sdk.b.c() {};
    this.vfg = false;
    this.vfh = 0;
    this.igU = null;
    this.vfj = false;
    this.vfk = new HashMap();
    this.vfl = new HashMap();
    this.vfm = new HashMap();
    this.vfn = new HashMap();
    this.vfp = null;
    this.vfq = null;
    this.vfr = null;
    this.vfs = false;
    this.vft = false;
    this.vfu = true;
    this.vfv = false;
    this.nvX = 0;
    this.nvY = null;
    this.vfw = false;
    this.vfx = false;
    this.vfy = new HashSet();
    this.vfz = false;
    this.vfA = false;
    this.vfB = new ConcurrentHashMap();
    this.vfE = 0;
    this.vfF = "";
    this.vfG = false;
    this.vfH = new HashMap();
    this.vfI = new HashSet();
    this.vfK = false;
    this.vfL = false;
    this.vfM = false;
    this.vfN = false;
    this.uVh = new as();
    this.vfO = new com.tencent.mm.plugin.webview.f.d();
    this.vfP = new com.tencent.mm.plugin.webview.model.b(this.uVh);
    this.vfQ = new com.tencent.mm.plugin.webview.modeltools.n();
    this.vfT = null;
    this.vfZ = new com.tencent.mm.plugin.webview.model.ap(this);
    this.vga = new WebViewUI.11(this);
    this.vgb = new WebViewUI.21(this);
    this.kDI = new WebViewUI.32(this);
    this.vgc = true;
    this.otr = 0L;
    this.jZj = 0;
    this.vgf = new WebViewUI.3(this);
    this.vgg = false;
    this.vgh = new l();
    this.ihd = new com.tencent.mm.plugin.webview.modeltools.d();
    this.vct = new com.tencent.mm.plugin.webview.modeltools.a();
    this.vgj = new WebViewUI.23(this);
    this.vgl = false;
    this.vgm = new WebViewUI.28(this);
    this.vgn = "";
    this.vgo = "";
    this.vgp = null;
    this.vgq = "";
    this.vgr = "";
    this.vgs = 0L;
    this.iHl = 0L;
    this.vgu = new WebViewUI.41(this);
    this.vgv = new WebViewUI.42(this);
    this.vgx = 0L;
    this.vgy = null;
    this.nkf = new com.tencent.mm.ui.widget.snackbar.a.b()
    {
      public final void aVA()
      {
        AppMethodBeat.i(153261);
        try
        {
          WebViewUI.this.igU.favEditTag();
          AppMethodBeat.o(153261);
          return;
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + localException.getMessage());
          AppMethodBeat.o(153261);
        }
      }
    };
    this.khm = -1;
    AppMethodBeat.o(7981);
  }
  
  private void JR(String paramString)
  {
    AppMethodBeat.i(7992);
    if (this.uQS != null)
    {
      this.uQS.aiW(paramString);
      try
      {
        if (paramString.equals("onPause"))
        {
          this.igU.Kk(hashCode());
          AppMethodBeat.o(7992);
          return;
        }
        if (paramString.equals("onResume")) {
          this.igU.Kj(hashCode());
        }
        AppMethodBeat.o(7992);
        return;
      }
      catch (Exception paramString)
      {
        ab.w("MicroMsg.WebViewUI", "onResume, ex = " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(7992);
  }
  
  private void KC(int paramInt)
  {
    AppMethodBeat.i(8089);
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
    if (this.uQS != null) {
      this.uQS.KR(i);
    }
    FontChooserView localFontChooserView = (FontChooserView)this.vei.findViewById(2131829521);
    if (localFontChooserView != null) {
      localFontChooserView.setSliderIndex(i - 1);
    }
    AppMethodBeat.o(8089);
  }
  
  private void Ky(int paramInt)
  {
    AppMethodBeat.i(8015);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("scene_end_type", paramInt);
      localBundle.putInt("scene_end_listener_hash_code", hashCode());
      this.igU.a(5, localBundle, hashCode());
      AppMethodBeat.o(8015);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.WebViewUI", "addSceneEnd, ex = " + localException.getMessage());
      AppMethodBeat.o(8015);
    }
  }
  
  private void Kz(int paramInt)
  {
    AppMethodBeat.i(8016);
    try
    {
      if (this.igU != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("scene_end_type", paramInt);
        localBundle.putInt("scene_end_listener_hash_code", hashCode());
        this.igU.a(6, localBundle, hashCode());
      }
      AppMethodBeat.o(8016);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.WebViewUI", "removeSceneEnd, ex = " + localException.getMessage());
      AppMethodBeat.o(8016);
    }
  }
  
  private void Z(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(8084);
    if (paramBoolean1)
    {
      setMMSubTitle(2131305936);
      if (!this.veE)
      {
        this.veE = true;
        AppMethodBeat.o(8084);
      }
    }
    else
    {
      if (paramBoolean2)
      {
        setMMSubTitle(2131305948);
        AppMethodBeat.o(8084);
        return;
      }
      setMMSubTitle(null);
    }
    AppMethodBeat.o(8084);
  }
  
  private void a(String paramString1, String paramString2, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(8082);
    if (!bo.isNullOrNil(paramString2))
    {
      this.igV.a(paramString2, paramJsapiPermissionWrapper, paramGeneralControlWrapper);
      this.vfy.remove(paramString2);
      this.vfA = false;
      this.kdt = paramString2;
    }
    if (hy(paramString1, paramString2))
    {
      this.igV.a(paramString1, paramJsapiPermissionWrapper, paramGeneralControlWrapper);
      this.vfy.remove(paramString1);
      AppMethodBeat.o(8082);
      return;
    }
    if ((this.igU == null) || (bo.isNullOrNil(paramString1)) || (!aip(paramString1)))
    {
      AppMethodBeat.o(8082);
      return;
    }
    this.igV.a(paramString1, paramJsapiPermissionWrapper, paramGeneralControlWrapper);
    this.vfy.remove(paramString1);
    AppMethodBeat.o(8082);
  }
  
  private static boolean a(com.tencent.mm.plugin.webview.ui.tools.jsapi.b paramb, String paramString)
  {
    AppMethodBeat.i(8041);
    if ((bo.isNullOrNil(paramString)) || (paramb == null))
    {
      AppMethodBeat.o(8041);
      return false;
    }
    boolean bool = paramb.aiz(paramString);
    AppMethodBeat.o(8041);
    return bool;
  }
  
  private static String aiq(String paramString)
  {
    AppMethodBeat.i(8047);
    try
    {
      paramString = Pattern.compile("(?i)^.*filename=\"?([^\"]+)\"?.*$").matcher(paramString);
      if ((paramString.find()) && (paramString.groupCount() == 1))
      {
        paramString = paramString.group(1);
        AppMethodBeat.o(8047);
        return paramString;
      }
      AppMethodBeat.o(8047);
      return null;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.WebViewUI", "getFileNameFromContentDisposition error " + paramString.getMessage());
      AppMethodBeat.o(8047);
    }
    return null;
  }
  
  private boolean aiv(String paramString)
  {
    AppMethodBeat.i(8080);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WebViewUI", "search contact err: null or nill url");
      AppMethodBeat.o(8080);
      return false;
    }
    Ky(106);
    Bundle localBundle = new Bundle();
    localBundle.putString("search_contact_data_url", paramString);
    localBundle.putInt("webview_binder_id", hashCode());
    try
    {
      this.igU.v(106, localBundle);
      AppMethodBeat.o(8080);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.w("MicroMsg.WebViewUI", "startSearchContact, ex = " + paramString.getMessage());
      }
    }
  }
  
  private boolean aiw(String paramString)
  {
    AppMethodBeat.i(8081);
    ab.i("MicroMsg.WebViewUI", "dealCustomScheme, url = ".concat(String.valueOf(paramString)));
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(8081);
      return false;
    }
    try
    {
      if (this.igU.dM(paramString))
      {
        ab.i("MicroMsg.WebViewUI", "dealCustomScheme, url is handled by QrCodeURLHelper, url = ".concat(String.valueOf(paramString)));
        this.igU.dO(paramString, hashCode());
        AppMethodBeat.o(8081);
        return true;
      }
    }
    catch (Exception localException1)
    {
      ab.w("MicroMsg.WebViewUI", "dealCustomScheme, tryHandleEvents, ex = " + localException1.getMessage());
      Uri localUri = Uri.parse(paramString);
      if ((localUri != null) && (!paramString.startsWith("weixin://")) && (!paramString.startsWith("http")))
      {
        if (paramString.startsWith("tel:"))
        {
          paramString = paramString.replace("tel:", "");
          if (!bo.isNullOrNil(paramString)) {}
          try
          {
            this.igU.dQ(paramString, hashCode());
            AppMethodBeat.o(8081);
            return true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              ab.w("MicroMsg.WebViewUI", "showPhoneSpanDialog, ex = %s", new Object[] { paramString.getMessage() });
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
            AppMethodBeat.o(8081);
            return true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              ab.e("MicroMsg.WebViewUI", "start sms app failed:[%s]", new Object[] { paramString.getMessage() });
            }
          }
        }
        if (paramString.startsWith("mailto:"))
        {
          paramString = new Intent("android.intent.action.SENDTO");
          paramString.addFlags(268435456);
          paramString.setData(localUri);
          try
          {
            startActivity(paramString);
            AppMethodBeat.o(8081);
            return true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              ab.e("MicroMsg.WebViewUI", "start mailto app failed:[%s]", new Object[] { paramString.getMessage() });
            }
          }
        }
        try
        {
          if ((this.igV.ddW().whZ & 0x2000) != 0) {}
          for (bool = true;; bool = false)
          {
            ab.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = ".concat(String.valueOf(bool)));
            if ((bool) || (this.igU == null) || (!this.igU.ddb())) {
              break;
            }
            ab.e("MicroMsg.WebViewUI", "dealCustomScheme, not allow outer open url");
            AppMethodBeat.o(8081);
            return true;
          }
          int i = getIntent().getIntExtra("key_download_restrict", 0);
          String str1 = getIntent().getStringExtra("key_function_id");
          if (!bo.isNullOrNil(str1)) {
            com.tencent.mm.plugin.report.service.h.qsU.e(14596, new Object[] { str1, Integer.valueOf(i), Integer.valueOf(1) });
          }
          if (i == 1)
          {
            ab.e("MicroMsg.WebViewUI", "not allow launch app by custom scheme : %s", new Object[] { paramString });
            AppMethodBeat.o(8081);
            return true;
          }
        }
        catch (RemoteException localRemoteException)
        {
          boolean bool;
          ab.printErrStackTrace("MicroMsg.WebViewUI", localRemoteException, "", new Object[0]);
          long l = bo.aox() - this.vgs;
          ab.i("MicroMsg.WebViewUI", "scheme launch interval ; %d", new Object[] { Long.valueOf(l) });
          String str2;
          Object localObject;
          if (l <= 2L)
          {
            str2 = dek();
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
            for (;;)
            {
              ab.i("MicroMsg.WebViewUI", "formate url failed");
            }
            paramString = new Intent("android.intent.action.VIEW", localUri);
            paramString.addFlags(268435456);
            if (!bo.k(this, paramString)) {
              break label769;
            }
            startActivity(paramString);
            AppMethodBeat.o(8081);
            return true;
          }
          com.tencent.mm.plugin.report.service.h.qsU.e(13983, new Object[] { Integer.valueOf(4), localObject, paramString });
          if (getIntent().getBooleanExtra("show_openapp_dialog", true))
          {
            bool = com.tencent.mm.ch.a.post(new WebViewUI.40(this, localUri));
            AppMethodBeat.o(8081);
            return bool;
          }
        }
      }
      label769:
      AppMethodBeat.o(8081);
    }
    return false;
  }
  
  private final boolean aix(String paramString)
  {
    AppMethodBeat.i(8091);
    if (ae.gkH)
    {
      ab.w("MicroMsg.WebViewUI", "skipLoadUrlCheck");
      AppMethodBeat.o(8091);
      return true;
    }
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8091);
      return true;
    }
    if (this.veu)
    {
      ab.i("MicroMsg.WebViewUI", "albie: trust this url(%s)", new Object[] { paramString });
      AppMethodBeat.o(8091);
      return true;
    }
    paramString = paramString.toLowerCase();
    if (paramString.startsWith("file://"))
    {
      Iterator localIterator = uWd.iterator();
      while (localIterator.hasNext()) {
        if (com.tencent.mm.pluginsdk.ui.tools.u.x(paramString, (String)localIterator.next()))
        {
          AppMethodBeat.o(8091);
          return true;
        }
      }
      AppMethodBeat.o(8091);
      return false;
    }
    AppMethodBeat.o(8091);
    return true;
  }
  
  private static void aj(View paramView, int paramInt)
  {
    AppMethodBeat.i(8028);
    if (paramView == null)
    {
      AppMethodBeat.o(8028);
      return;
    }
    paramView.setSystemUiVisibility(paramView.getSystemUiVisibility() | paramInt);
    AppMethodBeat.o(8028);
  }
  
  private boolean ddq()
  {
    boolean bool1 = false;
    AppMethodBeat.i(8046);
    try
    {
      if (this.igU == null)
      {
        ab.w("MicroMsg.WebViewUI", "invoker is null");
        AppMethodBeat.o(8046);
        return false;
      }
      boolean bool2 = this.igU.ddq();
      bool1 = bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.e("MicroMsg.WebViewUI", "unable get config for WebViewDownLoadFile" + localRemoteException.getMessage());
      }
    }
    AppMethodBeat.o(8046);
    return bool1;
  }
  
  private int deB()
  {
    AppMethodBeat.i(8088);
    float f = getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP(), 0).getFloat("current_text_size_scale_key", 1.0F);
    if (f == com.tencent.mm.cb.a.gg(getContext()))
    {
      AppMethodBeat.o(8088);
      return 1;
    }
    if (f == com.tencent.mm.cb.a.gh(getContext()))
    {
      AppMethodBeat.o(8088);
      return 3;
    }
    if ((f == com.tencent.mm.cb.a.gi(getContext())) || (f == com.tencent.mm.cb.a.gj(getContext())) || (f == com.tencent.mm.cb.a.gk(getContext())))
    {
      AppMethodBeat.o(8088);
      return 4;
    }
    AppMethodBeat.o(8088);
    return 2;
  }
  
  private void deC()
  {
    AppMethodBeat.i(8092);
    if ((this.pOd == null) || (this.igU == null))
    {
      ab.i("MicroMsg.WebViewUI", "viewwv is null or invoker is null");
      AppMethodBeat.o(8092);
      return;
    }
    try
    {
      this.pOd.removeJavascriptInterface("searchBoxJavaBridge_");
      if (this.vgy != null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        if (this.igU.ddb()) {
          this.vgy = this.igU.ddc();
        }
        if (this.vgy == null)
        {
          i = 0;
          ab.i("MicroMsg.WebViewUI", "removeConfigJsInterface, to remove list size = %d", new Object[] { Integer.valueOf(i) });
          if ((this.vgy != null) && (this.vgy.length != 0)) {
            break label186;
          }
          AppMethodBeat.o(8092);
          return;
          localException1 = localException1;
          ab.e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", new Object[] { localException1.getMessage() });
        }
      }
      catch (Exception localException2)
      {
        int i;
        for (;;)
        {
          ab.e("MicroMsg.WebViewUI", "getRemoveJsInterfaceList, ex = %s", new Object[] { localException2.getMessage() });
          continue;
          i = this.vgy.length;
        }
        try
        {
          label186:
          String[] arrayOfString = this.vgy;
          int j = arrayOfString.length;
          i = 0;
          while (i < j)
          {
            String str = arrayOfString[i];
            ab.i("MicroMsg.WebViewUI", "removeConfigJsInterface, js interface name = %s", new Object[] { str });
            this.pOd.removeJavascriptInterface(str);
            i += 1;
          }
          AppMethodBeat.o(8092);
          return;
        }
        catch (Exception localException3)
        {
          ab.e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", new Object[] { localException3.getMessage() });
          AppMethodBeat.o(8092);
        }
      }
    }
  }
  
  private boolean deD()
  {
    AppMethodBeat.i(8094);
    int i = getIntent().getIntExtra("key_close_action", 0);
    Object localObject = getIntent().getBundleExtra("key_close_data");
    ab.i("MicroMsg.WebViewUI", "close action %s", new Object[] { Integer.valueOf(i) });
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
            AppMethodBeat.o(8094);
            return false;
          } while (localObject == null);
          str1 = ((Bundle)localObject).getString("close_dialog_title");
          str2 = ((Bundle)localObject).getString("close_dialog_msg");
          str3 = ((Bundle)localObject).getString("close_dialog_ok");
          str4 = ((Bundle)localObject).getString("close_dialog_cancel");
          bool = ((Bundle)localObject).getBoolean("close_dialog_ok_close", true);
        } while (bo.Q(new String[] { str2, str3, str4 }));
        if (bool) {
          com.tencent.mm.ui.base.h.a(this, str1, str2, str3, str4, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(153260);
              WebViewUI.this.vfK = true;
              m.vdm.close();
              WebViewUI.this.finish();
              AppMethodBeat.o(153260);
            }
          }, null);
        }
        for (;;)
        {
          AppMethodBeat.o(8094);
          return true;
          com.tencent.mm.ui.base.h.a(this, str1, str2, str3, str4, false, null, new WebViewUI.48(this));
        }
      } while (localObject == null);
      str1 = ((Bundle)localObject).getString("close_jump_url");
      i = ((Bundle)localObject).getInt("close_jump_url_request_code", 0);
    } while (bo.isNullOrNil(str1));
    localObject = new Intent(this, WebViewUI.class);
    ((Intent)localObject).putExtra("rawUrl", str1);
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("show_bottom", false);
    ((Intent)localObject).putExtra("needRedirect", false);
    ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
    ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
    startActivityForResult((Intent)localObject, i);
    com.tencent.mm.ui.base.b.ih(this);
    AppMethodBeat.o(8094);
    return true;
  }
  
  private void deF()
  {
    AppMethodBeat.i(8096);
    if (this.vfM)
    {
      ab.d("MicroMsg.WebViewUI", "SwipeBackFinish, do not LaunchOuterApp");
      AppMethodBeat.o(8096);
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
      com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", localBundle, com.tencent.mm.pluginsdk.model.app.u.class, null);
    }
    AppMethodBeat.o(8096);
  }
  
  private void def()
  {
    AppMethodBeat.i(7993);
    this.vfO.aX("onTryBindServiceStart", System.currentTimeMillis());
    ab.i("MicroMsg.WebViewUI", "edw tryBindService");
    bindService(new Intent(this, WebViewStubService.class), this.kDI, 1);
    this.vfO.aX("onTryBindServiceEnd", System.currentTimeMillis());
    AppMethodBeat.o(7993);
  }
  
  private int deg()
  {
    AppMethodBeat.i(7999);
    if (this.vfu) {}
    for (int i = 0; (getSupportActionBar() == null) || (!getSupportActionBar().isShowing()); i = this.iPy)
    {
      AppMethodBeat.o(7999);
      return i;
    }
    int j = getActionBarHeight();
    AppMethodBeat.o(7999);
    return i + j;
  }
  
  private View dem()
  {
    AppMethodBeat.i(8011);
    View localView = null;
    try
    {
      i = Resources.getSystem().getIdentifier("action_bar_container", "id", "android");
      if (i > 0) {
        localView = findViewById(i);
      }
      ab.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", new Object[] { Integer.valueOf(i), localView });
      AppMethodBeat.o(8011);
      return localView;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.WebViewUI", "get resId action_bar_container, exp = %s", new Object[] { localException });
        int i = -1;
      }
    }
  }
  
  private void den()
  {
    AppMethodBeat.i(8018);
    try
    {
      this.vgh.release();
      this.pOd.stopLoading();
      this.veQ = false;
      this.pOd.removeAllViews();
      this.pOd.clearView();
      if (this.uQS != null) {
        this.uQS.detach();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        this.pOd.destroy();
        this.pOd = null;
        finish();
        ab.dsI();
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(8018);
        return;
        localException1 = localException1;
        ab.e("MicroMsg.WebViewUI", "forceQuit, ex = " + localException1.getMessage());
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ab.w("MicroMsg.WebViewUI", "forceQuit, viewWV destroy, ex = %s", new Object[] { localException2.getMessage() });
        }
      }
    }
  }
  
  private void dew()
  {
    AppMethodBeat.i(8065);
    if (this.veR != null) {
      this.veR.setVisibility(8);
    }
    if (this.veS != null) {
      this.veS.stopTimer();
    }
    AppMethodBeat.o(8065);
  }
  
  private boolean dex()
  {
    AppMethodBeat.i(8076);
    if (System.currentTimeMillis() - this.vex < 300L)
    {
      AppMethodBeat.o(8076);
      return true;
    }
    AppMethodBeat.o(8076);
    return false;
  }
  
  private static void ew(View paramView)
  {
    AppMethodBeat.i(8029);
    if (paramView == null)
    {
      AppMethodBeat.o(8029);
      return;
    }
    paramView.setSystemUiVisibility(paramView.getSystemUiVisibility() & 0xFFFFE8F9);
    AppMethodBeat.o(8029);
  }
  
  private boolean hy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(8086);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(8086);
      return false;
    }
    if ((com.tencent.mm.plugin.webview.a.uNB.matcher(paramString1).matches()) && (com.tencent.mm.plugin.webview.a.uNB.matcher(paramString2).matches()))
    {
      String str2 = paramString1.replaceFirst("http://", "").replaceFirst("https://", "");
      int i = str2.indexOf('#');
      String str1 = str2;
      if (i > 0) {
        str1 = str2.substring(0, i);
      }
      if ((paramString2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(str1)) && (this.igU != null) && (aip(paramString1)))
      {
        AppMethodBeat.o(8086);
        return true;
      }
    }
    AppMethodBeat.o(8086);
    return false;
  }
  
  private WebViewUI.w k(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(8078);
    if ((this.vfK) || (this.vfL) || (isFinishing()))
    {
      paramString = WebViewUI.w.vhb;
      AppMethodBeat.o(8078);
      return paramString;
    }
    int j = -1;
    int i = j;
    if (this.vex > 0L)
    {
      i = j;
      if (dex()) {
        i = 4;
      }
      this.vex = 0L;
    }
    if (this.vfq != null) {
      this.vfq.setVisibility(8);
    }
    if (this.igV == null)
    {
      ab.e("MicroMsg.WebViewUI", "startGetA8Key fail, after onDestroy");
      paramString = WebViewUI.w.vhb;
      AppMethodBeat.o(8078);
      return paramString;
    }
    if (this.veB)
    {
      ab.i("MicroMsg.WebViewUI", "edw startGetA8Key, nevergeta8key");
      this.igV.a(paramString, null, null);
      paramString = WebViewUI.w.vgZ;
      AppMethodBeat.o(8078);
      return paramString;
    }
    if ((this.igU != null) && (this.vfy.contains(paramString)) && (aip(paramString))) {}
    for (j = 1; ((this.igV.has(paramString)) || (j != 0)) && (!paramBoolean); j = 0)
    {
      ab.i("MicroMsg.WebViewUI", "edw startGetA8Key no need, wvPerm already has value, url = ".concat(String.valueOf(paramString)));
      this.vfg = this.igV.ddV().jy(24);
      paramString = WebViewUI.w.vgZ;
      AppMethodBeat.o(8078);
      return paramString;
    }
    Object localObject = getIntent().getStringExtra("geta8key_username");
    int k = aio((String)localObject);
    if (paramInt == -1) {}
    for (j = this.vfb.agV(paramString);; j = paramInt)
    {
      String str = getIntent().getStringExtra("key_function_id");
      int m = getIntent().getIntExtra("key_wallet_region", 0);
      ab.i("MicroMsg.WebViewUI", "edw startGetA8Key, url = %s, scene = %d, subScene = %d, username = %s, reason = %d, force = %b, functionid = %s, walletRegion = %d", new Object[] { paramString, Integer.valueOf(k), Integer.valueOf(i), localObject, Integer.valueOf(j), Boolean.valueOf(paramBoolean), str, Integer.valueOf(m) });
      if (paramInt != 5) {
        Y(true, false);
      }
      this.vfy.add(paramString);
      if ((i != 4) || (!paramBoolean)) {
        this.igV.a(paramString, null, null);
      }
      this.vfg = this.igV.ddV().jy(24);
      if ((j != 5) && (j != 1)) {
        this.vfA = true;
      }
      this.vfc.deQ();
      Bundle localBundle = new Bundle();
      localBundle.putString("geta8key_data_req_url", paramString);
      localBundle.putString("geta8key_data_username", (String)localObject);
      localBundle.putInt("geta8key_data_scene", k);
      localBundle.putInt("geta8key_data_subscene", i);
      localBundle.putInt("geta8key_data_reason", j);
      if (this.pOd.getIsX5Kernel()) {
        localBundle.putInt("geta8key_data_flag", 1);
      }
      for (;;)
      {
        localBundle.putString("geta8key_data_net_type", as.dcf());
        localBundle.putInt("geta8key_session_id", this.veK);
        if (!bo.isNullOrNil(getIntent().getStringExtra("k_share_url")))
        {
          localBundle.putString("k_share_url", getIntent().getStringExtra("k_share_url"));
          getIntent().putExtra("k_share_url", "");
        }
        localBundle.putInt("key_wallet_region", m);
        localBundle.putString("key_function_id", str);
        localBundle.putInt("webview_binder_id", hashCode());
        localBundle.putByteArray("k_a8key_cookie", this.veN);
        localBundle.putString("geta8key_data_appid", getIntent().getStringExtra("geta8key_open_webview_appid"));
        this.veL = paramString;
        this.veM = false;
        paramBoolean = false;
        try
        {
          boolean bool = this.igU.v(233, localBundle);
          paramBoolean = bool;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.w("MicroMsg.WebViewUI", "startGetA8Key, ex = " + localException.getMessage());
            continue;
            if (!localException.uXg.containsKey(paramString)) {
              localException.uXg.put(paramString, Long.valueOf(bo.aoy()));
            }
          }
        }
        ab.i("MicroMsg.WebViewUI", "startGetA8Key, doScene ret = ".concat(String.valueOf(paramBoolean)));
        localObject = this.uVh.dch();
        paramInt = this.cNH;
        str = this.cGT;
        ((as.m)localObject).cNH = paramInt;
        ((as.m)localObject).uWU = str;
        if (!bo.isNullOrNil(paramString)) {
          break;
        }
        ab.e("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.startGetA8Key failed, url is null");
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(154L, 11L, 1L, false);
        this.vfO.aX("getA8KeyStart", System.currentTimeMillis());
        paramString = WebViewUI.w.vha;
        AppMethodBeat.o(8078);
        return paramString;
        localBundle.putInt("geta8key_data_flag", 0);
      }
    }
  }
  
  private void oq(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.veV = true;
    }
  }
  
  private void ot(boolean paramBoolean)
  {
    AppMethodBeat.i(8069);
    if (this.veh != null) {
      this.veh.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(8069);
  }
  
  protected void Hr(String paramString)
  {
    AppMethodBeat.i(156619);
    k(paramString, true, 8);
    paramString = this.uVh.dco();
    paramString.uWQ = new Object[] { this.cJr, Integer.valueOf(4) };
    paramString.b(this.igU);
    AppMethodBeat.o(156619);
  }
  
  protected void J(Bundle paramBundle) {}
  
  protected final void KA(int paramInt)
  {
    AppMethodBeat.i(8035);
    Drawable localDrawable = getResources().getDrawable(2131230739).mutate();
    localDrawable.setColorFilter(paramInt, PorterDuff.Mode.SRC_IN);
    updateBackBtn(localDrawable);
    AppMethodBeat.o(8035);
  }
  
  protected final void KB(int paramInt)
  {
    AppMethodBeat.i(8064);
    if (paramInt != -3)
    {
      AppMethodBeat.o(8064);
      return;
    }
    if (this.veR == null)
    {
      AppMethodBeat.o(8064);
      return;
    }
    if ((this.igV.ddW().whZ & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = ".concat(String.valueOf(bool)));
      if (!bool) {
        break label236;
      }
      if ((this.veR.getVisibility() != 0) && (!this.ves.isShown())) {
        break;
      }
      AppMethodBeat.o(8064);
      return;
    }
    if (this.veS == null) {
      this.veS = new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper(), new WebViewUI.35(this), false);
    }
    this.veS.ag(4000L, 4000L);
    View localView = this.veR;
    ((ImageView)localView.findViewById(2131825423)).setImageResource(2131231762);
    TextView localTextView = (TextView)localView.findViewById(2131825424);
    localTextView.setTextSize(14.0F);
    localTextView.setText(2131306002);
    ((ImageButton)localView.findViewById(2131825425)).setOnClickListener(new WebViewUI.36(this));
    this.veR.setVisibility(0);
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(13125, daZ());
    label236:
    AppMethodBeat.o(8064);
  }
  
  protected void KD(int paramInt)
  {
    AppMethodBeat.i(8090);
    if ((this.pOd == null) || (this.pOd.getSettings() == null))
    {
      AppMethodBeat.o(8090);
      return;
    }
    ab.i("MicroMsg.WebViewUI", "localSetFontSize, fontSize = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    default: 
      this.pOd.getSettings().a(t.a.BDX);
      AppMethodBeat.o(8090);
      return;
    case 1: 
      this.pOd.getSettings().a(t.a.BDW);
      AppMethodBeat.o(8090);
      return;
    case 3: 
      this.pOd.getSettings().a(t.a.BDY);
      AppMethodBeat.o(8090);
      return;
    }
    this.pOd.getSettings().a(t.a.BDZ);
    AppMethodBeat.o(8090);
  }
  
  protected boolean P(Bundle paramBundle)
  {
    AppMethodBeat.i(8087);
    ab.d("MicroMsg.WebViewUI", "[cpan] process a8 key:%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
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
        ab.i("MicroMsg.WebViewUI", "use intent httpheader info");
        getIntent().putExtra("k_has_http_header", false);
        localObject1 = getIntent().getStringArrayExtra("geta8key_result_http_header_key_list");
        paramBundle = getIntent().getStringArrayExtra("geta8key_result_http_header_value_list");
        getIntent().putStringArrayListExtra("geta8key_result_http_header_key_list", null);
        getIntent().putStringArrayListExtra("geta8key_result_http_header_value_list", null);
      }
    }
    ab.i("MicroMsg.WebViewUI", "processGetA8Key, actionCode = %d, title = %s, fullUrl = %s, content = %s", new Object[] { Integer.valueOf(j), str3, str1, str4 });
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
    this.vfC = ((Map)localObject2);
    if (!bo.isNullOrNil(str1)) {}
    for (paramBundle = str1;; paramBundle = str2)
    {
      as.W(this.pOd.getIsX5Kernel(), bo.nullAsNil(paramBundle).startsWith("https://"));
      this.uVh.dch().bL(str2, true);
      paramBundle = this.uVh.dcj();
      i = this.cNH;
      localObject1 = this.cGT;
      paramBundle.cNH = i;
      paramBundle.uWU = ((String)localObject1);
      if (bo.isNullOrNil(str1)) {
        ab.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
      }
      for (;;)
      {
        switch (j)
        {
        default: 
          ab.i("MicroMsg.WebViewUI", "qrcode-getA8key-not_catch: action code = ".concat(String.valueOf(j)));
          AppMethodBeat.o(8087);
          return false;
          paramBundle.iIg = str1;
          paramBundle.uWT = true;
          if (!paramBundle.uWR.containsKey(str1)) {
            paramBundle.uWR.put(str1, Long.valueOf(bo.aoy()));
          }
          if (!paramBundle.uWS.containsKey(str1)) {
            paramBundle.uWS.put(str1, Long.valueOf(bo.aoy()));
          }
          break;
        }
      }
      ab.i("MicroMsg.WebViewUI", "getA8key-text: ".concat(String.valueOf(str4)));
      if ((str4 == null) || (str4.length() == 0))
      {
        ab.e("MicroMsg.WebViewUI", "getA8key-text fail, invalid content");
        AppMethodBeat.o(8087);
        return false;
      }
      this.pOd.getSettings().setJavaScriptEnabled(false);
      this.pOd.loadData(str4, "text/html", "utf-8");
      AppMethodBeat.o(8087);
      return true;
      ab.i("MicroMsg.WebViewUI", "getA8key-webview: title = " + str3 + ", fullUrl = " + str1);
      if ((str1 == null) || (str1.length() == 0))
      {
        ab.e("MicroMsg.WebViewUI", "getA8key-webview fail, invalid fullUrl");
        AppMethodBeat.o(8087);
        return false;
      }
      if ((str3 != null) && (str3.length() > 0)) {
        setMMTitle(str3);
      }
      if (!aix(str1))
      {
        ab.f("MicroMsg.WebViewUI", "processGetA8Key qrcode, canLoadUrl fail, url = ".concat(String.valueOf(str1)));
        den();
        AppMethodBeat.o(8087);
        return true;
      }
      c(str2, str1, (Map)localObject2);
      AppMethodBeat.o(8087);
      return true;
      ab.i("MicroMsg.WebViewUI", "getA8key-webview_no_notice: title = " + str3 + ", fullUrl = " + str1);
      if ((str1 == null) || (str1.length() == 0))
      {
        ab.e("MicroMsg.WebViewUI", "getA8key-webview_no_notice fail, invalid fullUrl");
        AppMethodBeat.o(8087);
        return false;
      }
      if ((str3 != null) && (str3.length() > 0)) {
        setMMTitle(str3);
      }
      if (!aix(str1))
      {
        ab.f("MicroMsg.WebViewUI", "processGetA8Key qrcode no notice, canLoadUrl fail, url = ".concat(String.valueOf(str1)));
        den();
        AppMethodBeat.o(8087);
        return true;
      }
      c(str2, str1, (Map)localObject2);
      AppMethodBeat.o(8087);
      return true;
      ab.i("MicroMsg.WebViewUI", "getA8key-special_webview: fullUrl = ".concat(String.valueOf(str1)));
      if ((str1 == null) || (str1.length() == 0))
      {
        ab.e("MicroMsg.WebViewUI", "getA8key-special_webview fail, invalid fullUrl");
        AppMethodBeat.o(8087);
        return false;
      }
      if (!aix(str1))
      {
        ab.f("MicroMsg.WebViewUI", "processGetA8Key special, canLoadUrl fail, url = ".concat(String.valueOf(str1)));
        den();
        AppMethodBeat.o(8087);
        return true;
      }
      b(str1, null, false);
      or(false);
      AppMethodBeat.o(8087);
      return true;
      ab.i("MicroMsg.WebViewUI", "getA8key-app: ".concat(String.valueOf(str1)));
      if ((str1 == null) || (str1.length() == 0))
      {
        ab.e("MicroMsg.WebViewUI", "getA8key-app, fullUrl is null");
        AppMethodBeat.o(8087);
        return false;
      }
      boolean bool = aiw(str1);
      AppMethodBeat.o(8087);
      return bool;
      bool = aiv(str1);
      AppMethodBeat.o(8087);
      return bool;
      if (bo.isNullOrNil(str1)) {
        ab.e("MicroMsg.WebViewUI", "doJumpEmotionDetailUrlScene err: null or nill url");
      }
      for (;;)
      {
        AppMethodBeat.o(8087);
        return true;
        paramBundle = this.vfe;
        if (paramBundle.vgW == 0) {
          paramBundle.vgz.Ky(666);
        }
        paramBundle.vgW += 1;
        paramBundle = new Bundle();
        paramBundle.putString("emoji_store_jump_url", str1);
        paramBundle.putInt("webview_binder_id", hashCode());
        try
        {
          this.igU.v(666, paramBundle);
        }
        catch (Exception paramBundle)
        {
          ab.w("MicroMsg.WebViewUI", "startSearchContact, ex = " + paramBundle.getMessage());
        }
      }
    }
  }
  
  protected final void X(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(8027);
    this.ven = paramBoolean1;
    Object localObject;
    if (paramBoolean1)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      if (this.vgd != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.vgd.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
        this.vgd.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.vfu) {
        com.tencent.mm.ui.statusbar.a.E(this.vgd, true);
      }
      for (;;)
      {
        getWindow().addFlags(1024);
        localObject = getWindow().getDecorView();
        ((View)localObject).setOnSystemUiVisibilityChangeListener(new WebViewUI.6(this, (View)localObject));
        aj((View)localObject, 5894);
        if (!paramBoolean2) {
          break;
        }
        this.vem.setOnClickListener(new WebViewUI.7(this));
        this.vem.setVisibility(0);
        AppMethodBeat.o(8027);
        return;
        if (this.vge != null) {
          this.vge.setVisibility(8);
        }
      }
      this.vem.setVisibility(8);
      AppMethodBeat.o(8027);
      return;
    }
    this.vem.setVisibility(8);
    getWindow().clearFlags(1024);
    ew(getWindow().getDecorView());
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().show();
      if (this.vgd != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.vgd.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = deg();
        this.vgd.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    if (this.vfu)
    {
      com.tencent.mm.ui.statusbar.a.E(this.vgd, false);
      AppMethodBeat.o(8027);
      return;
    }
    if (this.vge != null) {
      this.vge.setVisibility(0);
    }
    AppMethodBeat.o(8027);
  }
  
  protected final void Y(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(8070);
    enableOptionMenu(paramBoolean1);
    ab.d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", new Object[] { Boolean.valueOf(paramBoolean1) });
    setProgressBarIndeterminateVisibility(false);
    if (paramBoolean2)
    {
      this.ved.finish();
      this.vfS.ddM();
      AppMethodBeat.o(8070);
      return;
    }
    if ((!this.vfw) && (!this.vfz)) {
      this.ved.start();
    }
    AppMethodBeat.o(8070);
  }
  
  @TargetApi(21)
  protected final void a(ViewGroup paramViewGroup, WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(8000);
    if (this.iPy == paramWindowInsets.getSystemWindowInsetTop())
    {
      AppMethodBeat.o(8000);
      return;
    }
    this.iPy = paramWindowInsets.getSystemWindowInsetTop();
    aYx();
    Object localObject = paramViewGroup;
    if ((paramViewGroup instanceof SwipeBackLayout)) {
      localObject = paramViewGroup.getChildAt(0);
    }
    paramViewGroup = ((View)localObject).findViewById(2131820956);
    if (paramViewGroup != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = paramWindowInsets.getSystemWindowInsetTop();
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramViewGroup.requestLayout();
    }
    if (deh()) {
      dej();
    }
    AppMethodBeat.o(8000);
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2)
  {
    return false;
  }
  
  /* Error */
  protected void aMf()
  {
    // Byte code:
    //   0: sipush 8042
    //   3: invokestatic 324	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 632	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfO	Lcom/tencent/mm/plugin/webview/f/d;
    //   10: ldc_w 2194
    //   13: invokestatic 1489	java/lang/System:currentTimeMillis	()J
    //   16: invokevirtual 1493	com/tencent/mm/plugin/webview/f/d:aX	(Ljava/lang/String;J)V
    //   19: ldc_w 429
    //   22: ldc_w 2196
    //   25: invokestatic 1032	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 2198	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:uRy	Lcom/tencent/mm/plugin/webview/ui/tools/bag/h;
    //   32: new 2200	com/tencent/mm/plugin/webview/ui/tools/bag/p
    //   35: dup
    //   36: aload_0
    //   37: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   40: invokespecial 2202	com/tencent/mm/plugin/webview/ui/tools/bag/p:<init>	(Lcom/tencent/mm/plugin/webview/stub/d;)V
    //   43: invokeinterface 2207 2 0
    //   48: aload_0
    //   49: invokespecial 762	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:deC	()V
    //   52: aload_0
    //   53: getfield 639	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfP	Lcom/tencent/mm/plugin/webview/model/b;
    //   56: astore 6
    //   58: aload_0
    //   59: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   62: astore 7
    //   64: aload 7
    //   66: ldc_w 2209
    //   69: invokeinterface 2212 2 0
    //   74: astore 8
    //   76: ldc_w 2214
    //   79: ldc_w 2216
    //   82: iconst_1
    //   83: anewarray 433	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload 8
    //   90: aastore
    //   91: invokestatic 438	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload 8
    //   96: invokestatic 378	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   99: ifeq +2252 -> 2351
    //   102: ldc_w 2214
    //   105: ldc_w 2218
    //   108: invokestatic 838	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: iconst_0
    //   112: istore_3
    //   113: iload_3
    //   114: ifne +2263 -> 2377
    //   117: ldc_w 2214
    //   120: ldc_w 2220
    //   123: invokestatic 1032	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_0
    //   127: invokevirtual 2223	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aYS	()Z
    //   130: ifeq +21 -> 151
    //   133: aload_0
    //   134: invokevirtual 2226	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aYQ	()Z
    //   137: ifeq +14 -> 151
    //   140: new 2228	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$24
    //   143: dup
    //   144: aload_0
    //   145: invokespecial 2229	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$24:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)V
    //   148: invokestatic 2234	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   151: aload_0
    //   152: getfield 632	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfO	Lcom/tencent/mm/plugin/webview/f/d;
    //   155: ldc_w 2236
    //   158: invokestatic 1489	java/lang/System:currentTimeMillis	()J
    //   161: invokevirtual 1493	com/tencent/mm/plugin/webview/f/d:aX	(Ljava/lang/String;J)V
    //   164: new 820	android/os/Bundle
    //   167: dup
    //   168: invokespecial 821	android/os/Bundle:<init>	()V
    //   171: astore 8
    //   173: aload_0
    //   174: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   177: ldc_w 2238
    //   180: invokevirtual 1377	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   183: astore 7
    //   185: aload 7
    //   187: astore 6
    //   189: aload 7
    //   191: ifnonnull +12 -> 203
    //   194: new 820	android/os/Bundle
    //   197: dup
    //   198: invokespecial 821	android/os/Bundle:<init>	()V
    //   201: astore 6
    //   203: aload 6
    //   205: ldc_w 1130
    //   208: aload_0
    //   209: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   212: ldc_w 1130
    //   215: iconst_0
    //   216: invokevirtual 1134	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   219: invokevirtual 827	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   222: aload 6
    //   224: ldc_w 1136
    //   227: aload_0
    //   228: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   231: ldc_w 1136
    //   234: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   237: invokevirtual 948	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: ldc_w 429
    //   243: ldc_w 2240
    //   246: iconst_2
    //   247: anewarray 433	java/lang/Object
    //   250: dup
    //   251: iconst_0
    //   252: aload 6
    //   254: ldc_w 1130
    //   257: iconst_0
    //   258: invokevirtual 1412	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   261: invokestatic 1150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: aastore
    //   265: dup
    //   266: iconst_1
    //   267: aload 6
    //   269: ldc_w 1136
    //   272: ldc_w 487
    //   275: invokevirtual 2242	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   278: aastore
    //   279: invokestatic 438	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: aload 8
    //   284: ldc_w 2238
    //   287: aload 6
    //   289: invokevirtual 2246	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   292: aload 8
    //   294: ldc_w 2248
    //   297: aload_0
    //   298: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   301: ldc_w 2248
    //   304: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   307: invokevirtual 2252	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   310: aload 8
    //   312: ldc_w 2254
    //   315: aload_0
    //   316: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   319: ldc_w 2254
    //   322: invokevirtual 1377	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   325: invokevirtual 2246	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   328: aload 8
    //   330: ldc_w 2256
    //   333: aload_0
    //   334: getfield 471	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:screenOrientation	I
    //   337: invokevirtual 827	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   340: aload_0
    //   341: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   344: bipush 20
    //   346: aload 8
    //   348: aload_0
    //   349: invokevirtual 779	java/lang/Object:hashCode	()I
    //   352: invokeinterface 833 4 0
    //   357: aload_0
    //   358: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   361: ldc_w 1690
    //   364: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   367: astore 9
    //   369: aload_0
    //   370: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   373: ldc_w 2258
    //   376: iconst_0
    //   377: invokevirtual 1134	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   380: istore_1
    //   381: aload_0
    //   382: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   385: ldc_w 2260
    //   388: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   391: astore 8
    //   393: aload_0
    //   394: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   397: ldc_w 2262
    //   400: lconst_0
    //   401: invokevirtual 2266	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   404: lstore 4
    //   406: aload_0
    //   407: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   410: ldc_w 2268
    //   413: iconst_0
    //   414: invokevirtual 1134	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   417: istore_2
    //   418: aload_0
    //   419: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   422: ldc_w 2270
    //   425: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   428: astore 11
    //   430: aload_0
    //   431: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   434: ldc_w 2272
    //   437: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   440: astore 10
    //   442: aload_0
    //   443: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   446: ldc_w 1463
    //   449: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   452: astore 12
    //   454: aload_0
    //   455: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   458: ldc_w 2274
    //   461: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   464: astore 13
    //   466: aload_0
    //   467: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   470: ldc_w 2276
    //   473: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   476: astore 14
    //   478: aload 6
    //   480: ldc_w 2278
    //   483: invokevirtual 1384	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   486: astore 15
    //   488: aconst_null
    //   489: astore 7
    //   491: aload_0
    //   492: getfield 906	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   495: ifnull +12 -> 507
    //   498: aload_0
    //   499: getfield 906	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   502: invokevirtual 2281	com/tencent/mm/ui/widget/MMWebView:getTitle	()Ljava/lang/String;
    //   505: astore 7
    //   507: aload 7
    //   509: astore 6
    //   511: aload 7
    //   513: invokestatic 378	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   516: ifeq +15 -> 531
    //   519: aload_0
    //   520: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   523: ldc_w 2283
    //   526: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   529: astore 6
    //   531: aload 6
    //   533: astore 7
    //   535: aload 6
    //   537: invokestatic 378	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   540: ifeq +15 -> 555
    //   543: aload_0
    //   544: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   547: ldc_w 2285
    //   550: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   553: astore 7
    //   555: aload_0
    //   556: getfield 627	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:uVh	Lcom/tencent/mm/plugin/webview/model/as;
    //   559: invokevirtual 2289	com/tencent/mm/plugin/webview/model/as:dck	()Lcom/tencent/mm/plugin/webview/model/as$l;
    //   562: astore 6
    //   564: aload 6
    //   566: aload 9
    //   568: putfield 2294	com/tencent/mm/plugin/webview/model/as$l:username	Ljava/lang/String;
    //   571: aload 6
    //   573: iload_1
    //   574: putfield 2297	com/tencent/mm/plugin/webview/model/as$l:uXe	I
    //   577: aload 6
    //   579: aload_0
    //   580: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   583: putfield 2298	com/tencent/mm/plugin/webview/model/as$l:cJr	Ljava/lang/String;
    //   586: aload 6
    //   588: iload_2
    //   589: putfield 2301	com/tencent/mm/plugin/webview/model/as$l:uXa	I
    //   592: aload 6
    //   594: aload_0
    //   595: aload 9
    //   597: invokevirtual 1694	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aio	(Ljava/lang/String;)I
    //   600: putfield 2304	com/tencent/mm/plugin/webview/model/as$l:scene	I
    //   603: aload 6
    //   605: lload 4
    //   607: putfield 2307	com/tencent/mm/plugin/webview/model/as$l:uWZ	J
    //   610: aload 6
    //   612: new 2309	com/tencent/mm/a/p
    //   615: dup
    //   616: lload 4
    //   618: invokespecial 2312	com/tencent/mm/a/p:<init>	(J)V
    //   621: invokevirtual 2313	com/tencent/mm/a/p:toString	()Ljava/lang/String;
    //   624: putfield 2316	com/tencent/mm/plugin/webview/model/as$l:uXb	Ljava/lang/String;
    //   627: aload 6
    //   629: aload 8
    //   631: putfield 2319	com/tencent/mm/plugin/webview/model/as$l:uWX	Ljava/lang/String;
    //   634: aload 6
    //   636: aload 11
    //   638: putfield 2322	com/tencent/mm/plugin/webview/model/as$l:uWY	Ljava/lang/String;
    //   641: aload 6
    //   643: aload 10
    //   645: putfield 2325	com/tencent/mm/plugin/webview/model/as$l:fjC	Ljava/lang/String;
    //   648: aload 6
    //   650: aload 12
    //   652: putfield 2327	com/tencent/mm/plugin/webview/model/as$l:appId	Ljava/lang/String;
    //   655: aload 6
    //   657: aload 13
    //   659: putfield 2330	com/tencent/mm/plugin/webview/model/as$l:uXc	Ljava/lang/String;
    //   662: aload 6
    //   664: aload_0
    //   665: getfield 2332	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:uXd	Ljava/lang/String;
    //   668: putfield 2333	com/tencent/mm/plugin/webview/model/as$l:uXd	Ljava/lang/String;
    //   671: aload 6
    //   673: aload 15
    //   675: putfield 2336	com/tencent/mm/plugin/webview/model/as$l:rHA	Ljava/lang/String;
    //   678: aload 6
    //   680: aload 7
    //   682: ldc_w 487
    //   685: invokestatic 2339	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   688: putfield 2341	com/tencent/mm/plugin/webview/model/as$l:title	Ljava/lang/String;
    //   691: aload 6
    //   693: aload 14
    //   695: putfield 2344	com/tencent/mm/plugin/webview/model/as$l:dHa	Ljava/lang/String;
    //   698: aload_0
    //   699: getfield 627	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:uVh	Lcom/tencent/mm/plugin/webview/model/as;
    //   702: invokevirtual 2348	com/tencent/mm/plugin/webview/model/as:dcl	()Lcom/tencent/mm/plugin/webview/model/as$a;
    //   705: astore 6
    //   707: aload 6
    //   709: aload 10
    //   711: putfield 2351	com/tencent/mm/plugin/webview/model/as$a:fjC	Ljava/lang/String;
    //   714: aload 6
    //   716: aload_0
    //   717: aload 9
    //   719: invokevirtual 1694	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aio	(Ljava/lang/String;)I
    //   722: putfield 2352	com/tencent/mm/plugin/webview/model/as$a:scene	I
    //   725: aload_0
    //   726: getfield 627	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:uVh	Lcom/tencent/mm/plugin/webview/model/as;
    //   729: invokevirtual 2356	com/tencent/mm/plugin/webview/model/as:dcn	()Lcom/tencent/mm/plugin/webview/model/as$c;
    //   732: aload_0
    //   733: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   736: putfield 2359	com/tencent/mm/plugin/webview/model/as$c:cJr	Ljava/lang/String;
    //   739: aload_0
    //   740: invokevirtual 2362	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:deu	()Z
    //   743: ifeq +47 -> 790
    //   746: new 820	android/os/Bundle
    //   749: dup
    //   750: invokespecial 821	android/os/Bundle:<init>	()V
    //   753: astore 6
    //   755: aload 6
    //   757: ldc_w 2260
    //   760: aload_0
    //   761: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   764: ldc_w 2260
    //   767: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   770: invokevirtual 948	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   773: aload_0
    //   774: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   777: bipush 29
    //   779: aload 6
    //   781: aload_0
    //   782: invokevirtual 779	java/lang/Object:hashCode	()I
    //   785: invokeinterface 833 4 0
    //   790: aload 8
    //   792: invokestatic 378	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   795: ifne +14 -> 809
    //   798: aload_0
    //   799: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   802: aload 8
    //   804: invokeinterface 2365 2 0
    //   809: aload_0
    //   810: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   813: ldc_w 2367
    //   816: iconst_m1
    //   817: invokevirtual 1134	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   820: istore_1
    //   821: iload_1
    //   822: iconst_m1
    //   823: if_icmpeq +1695 -> 2518
    //   826: ldc_w 429
    //   829: ldc_w 2369
    //   832: iconst_1
    //   833: anewarray 433	java/lang/Object
    //   836: dup
    //   837: iconst_0
    //   838: iload_1
    //   839: invokestatic 1150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   842: aastore
    //   843: invokestatic 438	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   846: aload_0
    //   847: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   850: invokeinterface 2374 1 0
    //   855: aload_0
    //   856: aload_0
    //   857: invokevirtual 2378	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aYP	()Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   860: putfield 525	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:uQS	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   863: aload_0
    //   864: getfield 525	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:uQS	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   867: astore 7
    //   869: aload_0
    //   870: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   873: ldc_w 1690
    //   876: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   879: astore 8
    //   881: aload_0
    //   882: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   885: ldc_w 2260
    //   888: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   891: invokestatic 378	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   894: ifne +1688 -> 2582
    //   897: new 562	java/util/HashMap
    //   900: dup
    //   901: invokespecial 563	java/util/HashMap:<init>	()V
    //   904: astore 6
    //   906: aload 6
    //   908: ldc_w 2260
    //   911: aload_0
    //   912: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   915: ldc_w 2260
    //   918: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   921: invokeinterface 1987 3 0
    //   926: pop
    //   927: aload 6
    //   929: ldc_w 2380
    //   932: aload_0
    //   933: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   936: ldc_w 2380
    //   939: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   942: invokeinterface 1987 3 0
    //   947: pop
    //   948: aload 6
    //   950: ldc_w 2262
    //   953: aload_0
    //   954: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   957: ldc_w 2262
    //   960: lconst_0
    //   961: invokevirtual 2266	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   964: invokestatic 1170	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   967: invokeinterface 1987 3 0
    //   972: pop
    //   973: aload 6
    //   975: ldc_w 2268
    //   978: aload_0
    //   979: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   982: ldc_w 2268
    //   985: iconst_0
    //   986: invokevirtual 1134	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   989: invokestatic 1150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   992: invokeinterface 1987 3 0
    //   997: pop
    //   998: aload 6
    //   1000: ldc_w 2381
    //   1003: aload_0
    //   1004: aload 8
    //   1006: invokevirtual 1694	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aio	(Ljava/lang/String;)I
    //   1009: invokestatic 1150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1012: invokeinterface 1987 3 0
    //   1017: pop
    //   1018: aload 6
    //   1020: ldc_w 2367
    //   1023: aload_0
    //   1024: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1027: ldc_w 2367
    //   1030: iconst_0
    //   1031: invokevirtual 1134	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1034: invokestatic 1150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1037: invokeinterface 1987 3 0
    //   1042: pop
    //   1043: aload 6
    //   1045: ldc_w 2383
    //   1048: aload_0
    //   1049: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1052: ldc_w 2383
    //   1055: iconst_0
    //   1056: invokevirtual 1134	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1059: invokestatic 1150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1062: invokeinterface 1987 3 0
    //   1067: pop
    //   1068: aload 6
    //   1070: ldc_w 2385
    //   1073: aload_0
    //   1074: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1077: ldc_w 2385
    //   1080: iconst_0
    //   1081: invokevirtual 1134	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1084: invokestatic 1150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1087: invokeinterface 1987 3 0
    //   1092: pop
    //   1093: aload_0
    //   1094: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1097: ldc_w 2387
    //   1100: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1103: invokestatic 378	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   1106: ifne +24 -> 1130
    //   1109: aload 6
    //   1111: ldc_w 2387
    //   1114: aload_0
    //   1115: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1118: ldc_w 2387
    //   1121: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1124: invokeinterface 1987 3 0
    //   1129: pop
    //   1130: aload_0
    //   1131: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1134: ldc_w 2389
    //   1137: iconst_m1
    //   1138: invokevirtual 1134	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1141: istore_1
    //   1142: iload_1
    //   1143: iconst_m1
    //   1144: if_icmpeq +1483 -> 2627
    //   1147: ldc_w 429
    //   1150: ldc_w 2391
    //   1153: iconst_1
    //   1154: anewarray 433	java/lang/Object
    //   1157: dup
    //   1158: iconst_0
    //   1159: iload_1
    //   1160: invokestatic 1150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1163: aastore
    //   1164: invokestatic 438	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1167: aload 6
    //   1169: ldc_w 2389
    //   1172: iload_1
    //   1173: invokestatic 1150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1176: invokeinterface 1987 3 0
    //   1181: pop
    //   1182: aload 7
    //   1184: aload 6
    //   1186: putfield 2394	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:voz	Ljava/util/Map;
    //   1189: aload_0
    //   1190: invokevirtual 2398	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:der	()Lcom/tencent/mm/plugin/websearch/api/ah;
    //   1193: ifnull +14 -> 1207
    //   1196: aload_0
    //   1197: invokevirtual 2398	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:der	()Lcom/tencent/mm/plugin/websearch/api/ah;
    //   1200: aload_0
    //   1201: getfield 525	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:uQS	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   1204: putfield 2404	com/tencent/mm/plugin/websearch/api/ah:uJH	Lcom/tencent/mm/plugin/websearch/api/c;
    //   1207: aload_0
    //   1208: getfield 906	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1211: aload_0
    //   1212: getfield 525	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:uQS	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   1215: ldc_w 2406
    //   1218: invokevirtual 2410	com/tencent/mm/ui/widget/MMWebView:addJavascriptInterface	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1221: aload_0
    //   1222: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1225: aload_0
    //   1226: getfield 525	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:uQS	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   1229: invokeinterface 2411 2 0
    //   1234: pop
    //   1235: aload_0
    //   1236: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1239: new 66	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$s
    //   1242: dup
    //   1243: aload_0
    //   1244: iconst_0
    //   1245: invokespecial 2414	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$s:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1248: invokeinterface 2411 2 0
    //   1253: pop
    //   1254: aload_0
    //   1255: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1258: new 60	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$p
    //   1261: dup
    //   1262: aload_0
    //   1263: iconst_0
    //   1264: invokespecial 2415	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$p:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1267: invokeinterface 2411 2 0
    //   1272: pop
    //   1273: aload_0
    //   1274: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1277: new 30	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$e
    //   1280: dup
    //   1281: aload_0
    //   1282: iconst_0
    //   1283: invokespecial 2416	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$e:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1286: invokeinterface 2411 2 0
    //   1291: pop
    //   1292: aload_0
    //   1293: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1296: new 64	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$r
    //   1299: dup
    //   1300: aload_0
    //   1301: iconst_0
    //   1302: invokespecial 2417	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$r:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1305: invokeinterface 2411 2 0
    //   1310: pop
    //   1311: aload_0
    //   1312: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1315: new 70	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$u
    //   1318: dup
    //   1319: aload_0
    //   1320: iconst_0
    //   1321: invokespecial 2418	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$u:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1324: invokeinterface 2411 2 0
    //   1329: pop
    //   1330: aload_0
    //   1331: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1334: new 22	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$a
    //   1337: dup
    //   1338: aload_0
    //   1339: iconst_0
    //   1340: invokespecial 2419	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$a:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1343: invokeinterface 2411 2 0
    //   1348: pop
    //   1349: aload_0
    //   1350: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1353: new 78	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$y
    //   1356: dup
    //   1357: aload_0
    //   1358: iconst_0
    //   1359: invokespecial 2420	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$y:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1362: invokeinterface 2411 2 0
    //   1367: pop
    //   1368: aload_0
    //   1369: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1372: new 68	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$t
    //   1375: dup
    //   1376: aload_0
    //   1377: iconst_0
    //   1378: invokespecial 2421	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$t:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1381: invokeinterface 2411 2 0
    //   1386: pop
    //   1387: aload_0
    //   1388: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1391: new 45	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$i
    //   1394: dup
    //   1395: aload_0
    //   1396: iconst_0
    //   1397: invokespecial 2422	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$i:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1400: invokeinterface 2411 2 0
    //   1405: pop
    //   1406: aload_0
    //   1407: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1410: new 24	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$b
    //   1413: dup
    //   1414: aload_0
    //   1415: iconst_0
    //   1416: invokespecial 2423	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$b:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1419: invokeinterface 2411 2 0
    //   1424: pop
    //   1425: aload_0
    //   1426: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1429: new 26	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$c
    //   1432: dup
    //   1433: aload_0
    //   1434: iconst_0
    //   1435: invokespecial 2424	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$c:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1438: invokeinterface 2411 2 0
    //   1443: pop
    //   1444: aload_0
    //   1445: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1448: new 2426	com/tencent/mm/plugin/webview/ui/tools/jsapi/e
    //   1451: dup
    //   1452: aload_0
    //   1453: getfield 906	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1456: aload_0
    //   1457: getfield 525	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:uQS	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   1460: invokespecial 2429	com/tencent/mm/plugin/webview/ui/tools/jsapi/e:<init>	(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;)V
    //   1463: invokeinterface 2411 2 0
    //   1468: pop
    //   1469: aload_0
    //   1470: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1473: new 76	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$x
    //   1476: dup
    //   1477: aload_0
    //   1478: iconst_0
    //   1479: invokespecial 2430	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$x:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1482: invokeinterface 2411 2 0
    //   1487: pop
    //   1488: aload_0
    //   1489: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1492: new 72	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$v
    //   1495: dup
    //   1496: aload_0
    //   1497: iconst_0
    //   1498: invokespecial 2431	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$v:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1501: invokeinterface 2411 2 0
    //   1506: pop
    //   1507: aload_0
    //   1508: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1511: new 55	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$n
    //   1514: dup
    //   1515: aload_0
    //   1516: iconst_0
    //   1517: invokespecial 2432	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$n:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1520: invokeinterface 2411 2 0
    //   1525: pop
    //   1526: aload_0
    //   1527: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1530: ldc_w 2434
    //   1533: iconst_0
    //   1534: invokevirtual 1189	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1537: ifeq +22 -> 1559
    //   1540: aload_0
    //   1541: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1544: new 49	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$k
    //   1547: dup
    //   1548: aload_0
    //   1549: iconst_0
    //   1550: invokespecial 2435	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$k:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1553: invokeinterface 2411 2 0
    //   1558: pop
    //   1559: aload_0
    //   1560: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   1563: new 32	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$f
    //   1566: dup
    //   1567: aload_0
    //   1568: iconst_0
    //   1569: invokespecial 2436	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$f:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   1572: invokeinterface 2411 2 0
    //   1577: pop
    //   1578: aload_0
    //   1579: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1582: ldc_w 2438
    //   1585: invokeinterface 2212 2 0
    //   1590: iconst_0
    //   1591: invokestatic 2439	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   1594: istore_1
    //   1595: aload_0
    //   1596: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1599: ldc_w 2441
    //   1602: iconst_0
    //   1603: invokevirtual 1189	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1606: istore_3
    //   1607: ldc_w 429
    //   1610: ldc_w 2443
    //   1613: iconst_2
    //   1614: anewarray 433	java/lang/Object
    //   1617: dup
    //   1618: iconst_0
    //   1619: iload_1
    //   1620: invokestatic 1150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1623: aastore
    //   1624: dup
    //   1625: iconst_1
    //   1626: iload_3
    //   1627: invokestatic 1706	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1630: aastore
    //   1631: invokestatic 438	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1634: iload_1
    //   1635: iconst_1
    //   1636: if_icmpeq +7 -> 1643
    //   1639: iload_3
    //   1640: ifeq +11 -> 1651
    //   1643: aload_0
    //   1644: getfield 686	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vgh	Lcom/tencent/mm/plugin/webview/ui/tools/l;
    //   1647: iconst_1
    //   1648: invokevirtual 2446	com/tencent/mm/plugin/webview/ui/tools/l:op	(Z)V
    //   1651: aload_0
    //   1652: ldc_w 2448
    //   1655: iconst_4
    //   1656: invokevirtual 2449	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1659: ldc_w 2451
    //   1662: iconst_0
    //   1663: invokeinterface 2452 3 0
    //   1668: ifeq +11 -> 1679
    //   1671: aload_0
    //   1672: getfield 686	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vgh	Lcom/tencent/mm/plugin/webview/ui/tools/l;
    //   1675: iconst_1
    //   1676: invokevirtual 2446	com/tencent/mm/plugin/webview/ui/tools/l:op	(Z)V
    //   1679: aload_0
    //   1680: aload_0
    //   1681: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1684: ldc_w 2454
    //   1687: invokeinterface 2212 2 0
    //   1692: iconst_0
    //   1693: invokestatic 2439	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   1696: putfield 556	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfh	I
    //   1699: ldc_w 429
    //   1702: ldc_w 2456
    //   1705: iconst_1
    //   1706: anewarray 433	java/lang/Object
    //   1709: dup
    //   1710: iconst_0
    //   1711: aload_0
    //   1712: getfield 556	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfh	I
    //   1715: invokestatic 1150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1718: aastore
    //   1719: invokestatic 438	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1722: aload_0
    //   1723: getfield 632	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfO	Lcom/tencent/mm/plugin/webview/f/d;
    //   1726: ldc_w 2458
    //   1729: invokestatic 1489	java/lang/System:currentTimeMillis	()J
    //   1732: invokevirtual 1493	com/tencent/mm/plugin/webview/f/d:aX	(Ljava/lang/String;J)V
    //   1735: aload_0
    //   1736: getfield 906	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1739: invokevirtual 1249	com/tencent/mm/ui/widget/MMWebView:getIsX5Kernel	()Z
    //   1742: aload_0
    //   1743: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   1746: invokestatic 945	com/tencent/mm/sdk/platformtools/bo:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   1749: ldc_w 1646
    //   1752: invokevirtual 1056	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1755: invokestatic 1992	com/tencent/mm/plugin/webview/model/as:W	(ZZ)V
    //   1758: aload_0
    //   1759: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1762: ldc_w 2460
    //   1765: invokeinterface 2212 2 0
    //   1770: iconst_0
    //   1771: invokestatic 2439	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   1774: istore_1
    //   1775: aload_0
    //   1776: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1779: ldc_w 2462
    //   1782: invokeinterface 2212 2 0
    //   1787: iconst_0
    //   1788: invokestatic 2439	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   1791: istore_2
    //   1792: ldc_w 429
    //   1795: new 401	java/lang/StringBuilder
    //   1798: dup
    //   1799: ldc_w 2464
    //   1802: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1805: iload_1
    //   1806: invokevirtual 2467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1809: ldc_w 2469
    //   1812: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1815: iload_2
    //   1816: invokevirtual 2467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1819: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1822: invokestatic 1032	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1825: aload_0
    //   1826: getfield 2471	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfV	Lcom/tencent/mm/plugin/webview/b;
    //   1829: astore 6
    //   1831: aload 6
    //   1833: iload_1
    //   1834: putfield 2476	com/tencent/mm/plugin/webview/b:uNL	I
    //   1837: aload 6
    //   1839: iload_2
    //   1840: putfield 2479	com/tencent/mm/plugin/webview/b:uNM	I
    //   1843: aload_0
    //   1844: getfield 906	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1847: invokevirtual 1249	com/tencent/mm/ui/widget/MMWebView:getIsX5Kernel	()Z
    //   1850: ifeq +904 -> 2754
    //   1853: bipush 7
    //   1855: invokestatic 2484	com/tencent/mm/pluginsdk/ui/tools/m:kS	(I)V
    //   1858: getstatic 1145	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   1861: bipush 64
    //   1863: bipush 64
    //   1865: iconst_1
    //   1866: iconst_0
    //   1867: iconst_1
    //   1868: iconst_1
    //   1869: iconst_0
    //   1870: invokevirtual 2487	com/tencent/mm/plugin/report/service/h:a	(IIIIIIZ)V
    //   1873: aload_0
    //   1874: new 2489	com/tencent/mm/plugin/webview/ui/tools/jsapi/f
    //   1877: dup
    //   1878: aload_0
    //   1879: getfield 906	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   1882: aload_0
    //   1883: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1886: aload_0
    //   1887: getfield 525	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:uQS	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   1890: new 2491	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$25
    //   1893: dup
    //   1894: aload_0
    //   1895: invokespecial 2492	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$25:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)V
    //   1898: aload_0
    //   1899: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   1902: ldc_w 2494
    //   1905: iconst_0
    //   1906: invokevirtual 1189	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1909: aload_0
    //   1910: invokevirtual 2223	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aYS	()Z
    //   1913: invokespecial 2497	com/tencent/mm/plugin/webview/ui/tools/jsapi/f:<init>	(Lcom/tencent/xweb/WebView;Lcom/tencent/mm/plugin/webview/stub/d;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/f$a;ZZ)V
    //   1916: putfield 2499	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfi	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/f;
    //   1919: aload_0
    //   1920: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   1923: ldc_w 2501
    //   1926: invokeinterface 2212 2 0
    //   1931: iconst_0
    //   1932: invokestatic 2439	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   1935: istore_1
    //   1936: ldc_w 429
    //   1939: ldc_w 2503
    //   1942: iconst_1
    //   1943: anewarray 433	java/lang/Object
    //   1946: dup
    //   1947: iconst_0
    //   1948: iload_1
    //   1949: invokestatic 1150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1952: aastore
    //   1953: invokestatic 438	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1956: iload_1
    //   1957: ifne +51 -> 2008
    //   1960: aload_0
    //   1961: ldc_w 2448
    //   1964: iconst_4
    //   1965: invokevirtual 2449	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1968: ldc_w 2505
    //   1971: iconst_1
    //   1972: invokeinterface 2452 3 0
    //   1977: ifeq +31 -> 2008
    //   1980: aload_0
    //   1981: invokevirtual 2508	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aYR	()Z
    //   1984: ifeq +24 -> 2008
    //   1987: aload_0
    //   1988: getfield 525	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:uQS	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   1991: invokevirtual 2511	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:dgj	()V
    //   1994: aload_0
    //   1995: getfield 653	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfZ	Lcom/tencent/mm/plugin/webview/model/ap;
    //   1998: aload_0
    //   1999: getfield 525	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:uQS	Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/d;
    //   2002: getfield 2514	com/tencent/mm/plugin/webview/ui/tools/jsapi/d:voC	Ljava/lang/String;
    //   2005: invokevirtual 2517	com/tencent/mm/plugin/webview/model/ap:ahj	(Ljava/lang/String;)V
    //   2008: aload_0
    //   2009: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   2012: ldc_w 2519
    //   2015: iconst_0
    //   2016: invokevirtual 1189	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2019: ifeq +784 -> 2803
    //   2022: aload_0
    //   2023: iconst_0
    //   2024: invokevirtual 2067	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:or	(Z)V
    //   2027: ldc_w 429
    //   2030: ldc_w 2521
    //   2033: iconst_1
    //   2034: anewarray 433	java/lang/Object
    //   2037: dup
    //   2038: iconst_0
    //   2039: invokestatic 1489	java/lang/System:currentTimeMillis	()J
    //   2042: invokestatic 1170	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2045: aastore
    //   2046: invokestatic 1951	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2049: aload_0
    //   2050: aload_0
    //   2051: invokestatic 2527	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   2054: ldc_w 2528
    //   2057: aconst_null
    //   2058: invokevirtual 2532	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   2061: putfield 805	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vei	Landroid/view/View;
    //   2064: aload_0
    //   2065: getfield 805	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vei	Landroid/view/View;
    //   2068: ldc_w 806
    //   2071: invokevirtual 812	android/view/View:findViewById	(I)Landroid/view/View;
    //   2074: checkcast 814	com/tencent/mm/plugin/webview/ui/tools/widget/FontChooserView
    //   2077: astore 6
    //   2079: aload_0
    //   2080: getfield 805	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vei	Landroid/view/View;
    //   2083: ldc_w 2533
    //   2086: invokevirtual 812	android/view/View:findViewById	(I)Landroid/view/View;
    //   2089: astore 7
    //   2091: aload_0
    //   2092: getfield 906	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   2095: invokevirtual 1249	com/tencent/mm/ui/widget/MMWebView:getIsX5Kernel	()Z
    //   2098: ifne +22 -> 2120
    //   2101: aload 7
    //   2103: iconst_0
    //   2104: invokevirtual 1584	android/view/View:setVisibility	(I)V
    //   2107: aload 7
    //   2109: new 2535	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$44
    //   2112: dup
    //   2113: aload_0
    //   2114: invokespecial 2536	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$44:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)V
    //   2117: invokevirtual 2537	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2120: aload 6
    //   2122: new 47	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$j
    //   2125: dup
    //   2126: aload_0
    //   2127: iconst_0
    //   2128: invokespecial 2538	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$j:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;B)V
    //   2131: invokevirtual 2542	com/tencent/mm/plugin/webview/ui/tools/widget/FontChooserView:setOnChangeListener	(Lcom/tencent/mm/plugin/webview/ui/tools/widget/FontChooserView$a;)V
    //   2134: new 2544	android/widget/FrameLayout$LayoutParams
    //   2137: dup
    //   2138: iconst_m1
    //   2139: bipush 254
    //   2141: bipush 80
    //   2143: invokespecial 2547	android/widget/FrameLayout$LayoutParams:<init>	(III)V
    //   2146: astore 6
    //   2148: aload_0
    //   2149: getfield 805	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vei	Landroid/view/View;
    //   2152: aload 6
    //   2154: invokevirtual 2093	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2157: aload_0
    //   2158: getfield 2549	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vej	Landroid/widget/FrameLayout;
    //   2161: aload_0
    //   2162: getfield 805	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vei	Landroid/view/View;
    //   2165: invokevirtual 2554	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   2168: aload_0
    //   2169: getfield 805	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vei	Landroid/view/View;
    //   2172: bipush 8
    //   2174: invokevirtual 1584	android/view/View:setVisibility	(I)V
    //   2177: iconst_2
    //   2178: istore_2
    //   2179: iload_2
    //   2180: istore_1
    //   2181: aload_0
    //   2182: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   2185: invokeinterface 1122 1 0
    //   2190: ifeq +22 -> 2212
    //   2193: aload_0
    //   2194: invokevirtual 2557	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dez	()Z
    //   2197: ifne +10 -> 2207
    //   2200: aload_0
    //   2201: invokevirtual 2560	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:deA	()Z
    //   2204: ifeq +648 -> 2852
    //   2207: aload_0
    //   2208: invokespecial 1656	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:deB	()I
    //   2211: istore_1
    //   2212: iload_1
    //   2213: ifle +10 -> 2223
    //   2216: iload_1
    //   2217: istore_2
    //   2218: iload_1
    //   2219: iconst_4
    //   2220: if_icmple +5 -> 2225
    //   2223: iconst_2
    //   2224: istore_2
    //   2225: aload_0
    //   2226: iload_2
    //   2227: invokespecial 1294	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:KC	(I)V
    //   2230: aload_0
    //   2231: iload_2
    //   2232: invokevirtual 2562	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:KD	(I)V
    //   2235: aload_0
    //   2236: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   2239: aload_0
    //   2240: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   2243: iconst_1
    //   2244: aconst_null
    //   2245: invokeinterface 2565 4 0
    //   2250: pop
    //   2251: aload_0
    //   2252: getfield 531	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veT	Ljava/util/List;
    //   2255: invokeinterface 2566 1 0
    //   2260: astore 6
    //   2262: aload 6
    //   2264: invokeinterface 456 1 0
    //   2269: ifeq +709 -> 2978
    //   2272: aload 6
    //   2274: invokeinterface 462 1 0
    //   2279: checkcast 980	com/tencent/mm/plugin/webview/ui/tools/jsapi/b
    //   2282: astore 7
    //   2284: aload 7
    //   2286: aload_0
    //   2287: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   2290: invokestatic 2568	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:a	(Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/b;Ljava/lang/String;)Z
    //   2293: ifeq -31 -> 2262
    //   2296: aload 7
    //   2298: aload_0
    //   2299: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   2302: invokeinterface 2571 2 0
    //   2307: istore_3
    //   2308: ldc_w 429
    //   2311: new 401	java/lang/StringBuilder
    //   2314: dup
    //   2315: ldc_w 2573
    //   2318: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2321: iload_3
    //   2322: invokevirtual 2576	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2325: ldc_w 2578
    //   2328: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2331: aload_0
    //   2332: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   2335: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2338: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2341: invokestatic 1032	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2344: sipush 8042
    //   2347: invokestatic 465	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2350: return
    //   2351: aload 8
    //   2353: ldc_w 2580
    //   2356: invokevirtual 2583	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2359: istore_3
    //   2360: goto -2247 -> 113
    //   2363: astore 6
    //   2365: ldc_w 2214
    //   2368: ldc_w 2585
    //   2371: invokestatic 838	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2374: goto -2248 -> 126
    //   2377: aload 7
    //   2379: ldc_w 2587
    //   2382: invokeinterface 2212 2 0
    //   2387: astore 8
    //   2389: aload 8
    //   2391: invokestatic 378	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   2394: ifeq +35 -> 2429
    //   2397: ldc_w 2214
    //   2400: ldc_w 2589
    //   2403: invokestatic 838	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2406: goto -2280 -> 126
    //   2409: astore 6
    //   2411: ldc_w 2214
    //   2414: aload 6
    //   2416: ldc_w 487
    //   2419: iconst_0
    //   2420: anewarray 433	java/lang/Object
    //   2423: invokestatic 1159	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2426: goto -2300 -> 126
    //   2429: aload 6
    //   2431: invokevirtual 2593	com/tencent/mm/plugin/webview/model/b:aNS	()Lcom/tencent/mm/sdk/platformtools/al;
    //   2434: new 2595	com/tencent/mm/plugin/webview/model/b$1
    //   2437: dup
    //   2438: aload 6
    //   2440: aload 8
    //   2442: aload 7
    //   2444: invokespecial 2598	com/tencent/mm/plugin/webview/model/b$1:<init>	(Lcom/tencent/mm/plugin/webview/model/b;Ljava/lang/String;Lcom/tencent/mm/plugin/webview/stub/d;)V
    //   2447: invokevirtual 2602	com/tencent/mm/sdk/platformtools/al:ac	(Ljava/lang/Runnable;)I
    //   2450: pop
    //   2451: goto -2325 -> 126
    //   2454: astore 7
    //   2456: ldc_w 429
    //   2459: new 401	java/lang/StringBuilder
    //   2462: dup
    //   2463: ldc_w 2604
    //   2466: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2469: aload 7
    //   2471: invokevirtual 1309	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   2474: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2477: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2480: invokestatic 838	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2483: goto -2126 -> 357
    //   2486: astore 6
    //   2488: ldc_w 429
    //   2491: new 401	java/lang/StringBuilder
    //   2494: dup
    //   2495: ldc_w 2606
    //   2498: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2501: aload 6
    //   2503: invokevirtual 794	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2506: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2509: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2512: invokestatic 838	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2515: goto -1706 -> 809
    //   2518: aload_0
    //   2519: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   2522: invokeinterface 2609 1 0
    //   2527: istore_1
    //   2528: iload_1
    //   2529: iconst_m1
    //   2530: if_icmpeq -1684 -> 846
    //   2533: ldc_w 429
    //   2536: ldc_w 2611
    //   2539: iconst_1
    //   2540: anewarray 433	java/lang/Object
    //   2543: dup
    //   2544: iconst_0
    //   2545: iload_1
    //   2546: invokestatic 1150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2549: aastore
    //   2550: invokestatic 438	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2553: aload_0
    //   2554: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   2557: ldc_w 2367
    //   2560: iload_1
    //   2561: invokevirtual 2614	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2564: pop
    //   2565: goto -1719 -> 846
    //   2568: astore 6
    //   2570: ldc_w 429
    //   2573: ldc_w 2616
    //   2576: invokestatic 838	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2579: goto -1733 -> 846
    //   2582: aload 8
    //   2584: invokestatic 378	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   2587: ifne +28 -> 2615
    //   2590: new 562	java/util/HashMap
    //   2593: dup
    //   2594: invokespecial 563	java/util/HashMap:<init>	()V
    //   2597: astore 6
    //   2599: aload 6
    //   2601: ldc_w 2260
    //   2604: aload 8
    //   2606: invokeinterface 1987 3 0
    //   2611: pop
    //   2612: goto -1664 -> 948
    //   2615: new 562	java/util/HashMap
    //   2618: dup
    //   2619: invokespecial 563	java/util/HashMap:<init>	()V
    //   2622: astore 6
    //   2624: goto -1676 -> 948
    //   2627: iconst_3
    //   2628: istore_1
    //   2629: ldc_w 429
    //   2632: ldc_w 2618
    //   2635: iconst_1
    //   2636: anewarray 433	java/lang/Object
    //   2639: dup
    //   2640: iconst_0
    //   2641: iconst_3
    //   2642: invokestatic 1150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2645: aastore
    //   2646: invokestatic 438	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2649: goto -1482 -> 1167
    //   2652: astore 6
    //   2654: ldc_w 429
    //   2657: new 401	java/lang/StringBuilder
    //   2660: dup
    //   2661: ldc_w 2620
    //   2664: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2667: aload 6
    //   2669: invokevirtual 794	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2672: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2675: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2678: invokestatic 797	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2681: iconst_0
    //   2682: istore_1
    //   2683: goto -1088 -> 1595
    //   2686: astore 6
    //   2688: ldc_w 429
    //   2691: new 401	java/lang/StringBuilder
    //   2694: dup
    //   2695: ldc_w 2622
    //   2698: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2701: aload 6
    //   2703: invokevirtual 794	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2706: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2709: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2712: invokestatic 797	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2715: goto -1016 -> 1699
    //   2718: astore 6
    //   2720: ldc_w 429
    //   2723: new 401	java/lang/StringBuilder
    //   2726: dup
    //   2727: ldc_w 2624
    //   2730: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2733: aload 6
    //   2735: invokevirtual 794	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2738: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2741: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2744: invokestatic 797	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2747: iconst_0
    //   2748: istore_1
    //   2749: iconst_0
    //   2750: istore_2
    //   2751: goto -959 -> 1792
    //   2754: getstatic 1145	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   2757: ldc2_w 2625
    //   2760: lconst_0
    //   2761: lconst_1
    //   2762: iconst_0
    //   2763: invokevirtual 1773	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   2766: goto -893 -> 1873
    //   2769: astore 6
    //   2771: ldc_w 429
    //   2774: new 401	java/lang/StringBuilder
    //   2777: dup
    //   2778: ldc_w 2628
    //   2781: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2784: aload 6
    //   2786: invokevirtual 794	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2789: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2792: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2795: invokestatic 797	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2798: iconst_0
    //   2799: istore_1
    //   2800: goto -864 -> 1936
    //   2803: aload_0
    //   2804: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   2807: ldc_w 1423
    //   2810: iconst_1
    //   2811: invokevirtual 1189	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2814: istore_3
    //   2815: aload_0
    //   2816: iload_3
    //   2817: invokevirtual 2067	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:or	(Z)V
    //   2820: ldc_w 429
    //   2823: ldc_w 2630
    //   2826: iconst_2
    //   2827: anewarray 433	java/lang/Object
    //   2830: dup
    //   2831: iconst_0
    //   2832: invokestatic 1489	java/lang/System:currentTimeMillis	()J
    //   2835: invokestatic 1170	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2838: aastore
    //   2839: dup
    //   2840: iconst_1
    //   2841: iload_3
    //   2842: invokestatic 1706	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2845: aastore
    //   2846: invokestatic 1951	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2849: goto -800 -> 2049
    //   2852: aload_0
    //   2853: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   2856: invokestatic 378	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   2859: ifne +36 -> 2895
    //   2862: getstatic 1636	com/tencent/mm/plugin/webview/a:uNB	Ljava/util/regex/Pattern;
    //   2865: aload_0
    //   2866: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   2869: invokevirtual 990	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   2872: invokevirtual 1639	java/util/regex/Matcher:matches	()Z
    //   2875: ifeq +20 -> 2895
    //   2878: aload_0
    //   2879: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   2882: sipush 16388
    //   2885: iconst_0
    //   2886: invokeinterface 2634 3 0
    //   2891: istore_1
    //   2892: goto -680 -> 2212
    //   2895: aload_0
    //   2896: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   2899: sipush 16384
    //   2902: iconst_0
    //   2903: invokeinterface 2634 3 0
    //   2908: istore_1
    //   2909: goto -697 -> 2212
    //   2912: astore 6
    //   2914: ldc_w 429
    //   2917: new 401	java/lang/StringBuilder
    //   2920: dup
    //   2921: ldc_w 2636
    //   2924: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2927: aload 6
    //   2929: invokevirtual 794	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2932: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2935: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2938: invokestatic 797	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2941: iload_2
    //   2942: istore_1
    //   2943: goto -731 -> 2212
    //   2946: astore 6
    //   2948: ldc_w 429
    //   2951: new 401	java/lang/StringBuilder
    //   2954: dup
    //   2955: ldc_w 2638
    //   2958: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2961: aload 6
    //   2963: invokevirtual 794	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2966: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2969: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2972: invokestatic 797	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2975: goto -724 -> 2251
    //   2978: aload_0
    //   2979: invokevirtual 2641	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ddz	()Z
    //   2982: ifeq +19 -> 3001
    //   2985: ldc_w 429
    //   2988: ldc_w 2643
    //   2991: invokestatic 797	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2994: sipush 8042
    //   2997: invokestatic 465	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3000: return
    //   3001: aload_0
    //   3002: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   3005: ldc_w 2645
    //   3008: invokevirtual 1139	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   3011: astore 7
    //   3013: aload 7
    //   3015: ifnull +223 -> 3238
    //   3018: ldc_w 429
    //   3021: aload 7
    //   3023: invokestatic 1032	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3026: aload 7
    //   3028: astore 6
    //   3030: aload_0
    //   3031: invokevirtual 1128	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   3034: ldc_w 2647
    //   3037: iconst_1
    //   3038: invokevirtual 1189	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   3041: ifeq +16 -> 3057
    //   3044: aload_0
    //   3045: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   3048: aload 7
    //   3050: invokeinterface 2650 2 0
    //   3055: astore 6
    //   3057: aload_0
    //   3058: getfield 906	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   3061: aload_0
    //   3062: getfield 701	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vgj	Landroid/view/View$OnLongClickListener;
    //   3065: invokevirtual 2654	com/tencent/mm/ui/widget/MMWebView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   3068: aload_0
    //   3069: iconst_1
    //   3070: putfield 2656	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vgi	Z
    //   3073: aload_0
    //   3074: getfield 906	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   3077: invokevirtual 1922	com/tencent/mm/ui/widget/MMWebView:getSettings	()Lcom/tencent/xweb/t;
    //   3080: iconst_0
    //   3081: invokevirtual 2659	com/tencent/xweb/t:setUseWideViewPort	(Z)V
    //   3084: aload_0
    //   3085: getfield 906	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   3088: invokevirtual 1922	com/tencent/mm/ui/widget/MMWebView:getSettings	()Lcom/tencent/xweb/t;
    //   3091: iconst_0
    //   3092: invokevirtual 2662	com/tencent/xweb/t:setLoadWithOverviewMode	(Z)V
    //   3095: aload_0
    //   3096: aconst_null
    //   3097: invokespecial 1297	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aix	(Ljava/lang/String;)Z
    //   3100: ifne +73 -> 3173
    //   3103: ldc_w 429
    //   3106: new 401	java/lang/StringBuilder
    //   3109: dup
    //   3110: ldc_w 2664
    //   3113: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3116: aconst_null
    //   3117: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3120: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3123: invokestatic 2046	com/tencent/mm/sdk/platformtools/ab:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   3126: aload_0
    //   3127: invokespecial 1795	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:den	()V
    //   3130: sipush 8042
    //   3133: invokestatic 465	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3136: return
    //   3137: astore 6
    //   3139: ldc_w 429
    //   3142: new 401	java/lang/StringBuilder
    //   3145: dup
    //   3146: ldc_w 2666
    //   3149: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3152: aload 6
    //   3154: invokevirtual 794	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3157: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3160: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3163: invokestatic 797	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   3166: aload 7
    //   3168: astore 6
    //   3170: goto -113 -> 3057
    //   3173: aload_0
    //   3174: getfield 906	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   3177: invokevirtual 1922	com/tencent/mm/ui/widget/MMWebView:getSettings	()Lcom/tencent/xweb/t;
    //   3180: iconst_0
    //   3181: invokevirtual 2025	com/tencent/xweb/t:setJavaScriptEnabled	(Z)V
    //   3184: aload_0
    //   3185: getfield 906	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pOd	Lcom/tencent/mm/ui/widget/MMWebView;
    //   3188: aconst_null
    //   3189: aload 6
    //   3191: ldc_w 2027
    //   3194: ldc_w 2029
    //   3197: aconst_null
    //   3198: invokevirtual 2670	com/tencent/mm/ui/widget/MMWebView:loadDataWithBaseURL	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3201: ldc_w 429
    //   3204: ldc_w 2672
    //   3207: aload 6
    //   3209: invokestatic 1027	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3212: invokevirtual 1030	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   3215: invokestatic 1032	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3218: aload_0
    //   3219: getfield 632	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfO	Lcom/tencent/mm/plugin/webview/f/d;
    //   3222: ldc_w 2674
    //   3225: invokestatic 1489	java/lang/System:currentTimeMillis	()J
    //   3228: invokevirtual 1493	com/tencent/mm/plugin/webview/f/d:aX	(Ljava/lang/String;J)V
    //   3231: sipush 8042
    //   3234: invokestatic 465	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3237: return
    //   3238: aload_0
    //   3239: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3242: invokestatic 378	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   3245: ifeq +8 -> 3253
    //   3248: aload_0
    //   3249: iconst_0
    //   3250: invokevirtual 2677	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:jT	(Z)V
    //   3253: aload_0
    //   3254: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3257: ifnull +13 -> 3270
    //   3260: aload_0
    //   3261: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3264: invokevirtual 1035	java/lang/String:length	()I
    //   3267: ifne +19 -> 3286
    //   3270: ldc_w 429
    //   3273: ldc_w 2679
    //   3276: invokestatic 838	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3279: sipush 8042
    //   3282: invokestatic 465	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3285: return
    //   3286: aload_0
    //   3287: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3290: invokestatic 1051	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   3293: astore 6
    //   3295: aload 6
    //   3297: ifnonnull +19 -> 3316
    //   3300: ldc_w 429
    //   3303: ldc_w 2681
    //   3306: invokestatic 838	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3309: sipush 8042
    //   3312: invokestatic 465	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3315: return
    //   3316: aload 6
    //   3318: invokevirtual 2684	android/net/Uri:getScheme	()Ljava/lang/String;
    //   3321: ifnonnull +197 -> 3518
    //   3324: aload_0
    //   3325: new 401	java/lang/StringBuilder
    //   3328: dup
    //   3329: ldc_w 1641
    //   3332: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3335: aload_0
    //   3336: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3339: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3342: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3345: putfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3348: aload_0
    //   3349: new 51	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$l
    //   3352: dup
    //   3353: aload_0
    //   3354: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3357: invokespecial 536	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$l:<init>	(Ljava/lang/String;)V
    //   3360: putfield 538	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfb	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$l;
    //   3363: aload_0
    //   3364: getfield 558	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igU	Lcom/tencent/mm/plugin/webview/stub/d;
    //   3367: ldc_w 2685
    //   3370: aconst_null
    //   3371: invokeinterface 2688 3 0
    //   3376: astore 6
    //   3378: aload 6
    //   3380: ifnull +43 -> 3423
    //   3383: aload 6
    //   3385: ldc_w 2690
    //   3388: invokevirtual 1384	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3391: ifnull +32 -> 3423
    //   3394: aload_0
    //   3395: aload 6
    //   3397: ldc_w 2690
    //   3400: invokevirtual 1384	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3403: ldc_w 2692
    //   3406: invokevirtual 2695	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3409: putfield 2697	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vgk	[Ljava/lang/String;
    //   3412: aload_0
    //   3413: getfield 538	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfb	Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$l;
    //   3416: aload_0
    //   3417: getfield 2697	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vgk	[Ljava/lang/String;
    //   3420: putfield 2698	com/tencent/mm/plugin/webview/ui/tools/WebViewUI$l:vgk	[Ljava/lang/String;
    //   3423: aload_0
    //   3424: getfield 499	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veB	Z
    //   3427: ifne +17 -> 3444
    //   3430: aload_0
    //   3431: getfield 535	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:igV	Lcom/tencent/mm/plugin/webview/ui/tools/k;
    //   3434: aload_0
    //   3435: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3438: invokevirtual 1678	com/tencent/mm/plugin/webview/ui/tools/k:has	(Ljava/lang/String;)Z
    //   3441: ifeq +290 -> 3731
    //   3444: ldc_w 429
    //   3447: new 401	java/lang/StringBuilder
    //   3450: dup
    //   3451: ldc_w 2700
    //   3454: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3457: aload_0
    //   3458: getfield 499	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:veB	Z
    //   3461: invokevirtual 2576	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3464: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3467: invokestatic 1032	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3470: aload_0
    //   3471: aload_0
    //   3472: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3475: invokespecial 1297	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aix	(Ljava/lang/String;)Z
    //   3478: ifne +195 -> 3673
    //   3481: ldc_w 429
    //   3484: new 401	java/lang/StringBuilder
    //   3487: dup
    //   3488: ldc_w 2702
    //   3491: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3494: aload_0
    //   3495: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3498: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3501: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3504: invokestatic 2046	com/tencent/mm/sdk/platformtools/ab:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   3507: aload_0
    //   3508: invokespecial 1795	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:den	()V
    //   3511: sipush 8042
    //   3514: invokestatic 465	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3517: return
    //   3518: aload 6
    //   3520: invokevirtual 2684	android/net/Uri:getScheme	()Ljava/lang/String;
    //   3523: ldc_w 1058
    //   3526: invokevirtual 1056	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3529: ifne -181 -> 3348
    //   3532: ldc_w 429
    //   3535: new 401	java/lang/StringBuilder
    //   3538: dup
    //   3539: ldc_w 2704
    //   3542: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3545: aload 6
    //   3547: invokevirtual 2684	android/net/Uri:getScheme	()Ljava/lang/String;
    //   3550: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3553: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3556: invokestatic 1032	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3559: aload_0
    //   3560: aload_0
    //   3561: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3564: invokespecial 1297	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aix	(Ljava/lang/String;)Z
    //   3567: ifne +40 -> 3607
    //   3570: ldc_w 429
    //   3573: new 401	java/lang/StringBuilder
    //   3576: dup
    //   3577: ldc_w 2706
    //   3580: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3583: aload_0
    //   3584: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3587: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3590: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3593: invokestatic 2046	com/tencent/mm/sdk/platformtools/ab:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   3596: aload_0
    //   3597: invokespecial 1795	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:den	()V
    //   3600: sipush 8042
    //   3603: invokestatic 465	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3606: return
    //   3607: aload_0
    //   3608: invokevirtual 2223	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aYS	()Z
    //   3611: ifne +20 -> 3631
    //   3614: aload_0
    //   3615: aload_0
    //   3616: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3619: aconst_null
    //   3620: iconst_0
    //   3621: invokevirtual 2064	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Ljava/lang/String;Ljava/util/Map;Z)V
    //   3624: sipush 8042
    //   3627: invokestatic 465	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3630: return
    //   3631: ldc_w 429
    //   3634: ldc_w 2708
    //   3637: invokestatic 1032	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3640: sipush 8042
    //   3643: invokestatic 465	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3646: return
    //   3647: astore 6
    //   3649: ldc_w 429
    //   3652: ldc_w 2710
    //   3655: iconst_1
    //   3656: anewarray 433	java/lang/Object
    //   3659: dup
    //   3660: iconst_0
    //   3661: aload 6
    //   3663: invokevirtual 794	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3666: aastore
    //   3667: invokestatic 1091	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3670: goto -247 -> 3423
    //   3673: aload_0
    //   3674: aload_0
    //   3675: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3678: invokevirtual 974	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aip	(Ljava/lang/String;)Z
    //   3681: ifeq +37 -> 3718
    //   3684: aload_0
    //   3685: iconst_1
    //   3686: putfield 591	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfw	Z
    //   3689: aload_0
    //   3690: getfield 2147	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ved	Lcom/tencent/mm/ui/base/MMFalseProgressBar;
    //   3693: invokevirtual 2150	com/tencent/mm/ui/base/MMFalseProgressBar:finish	()V
    //   3696: aload_0
    //   3697: getfield 2147	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ved	Lcom/tencent/mm/ui/base/MMFalseProgressBar;
    //   3700: bipush 8
    //   3702: invokevirtual 2711	com/tencent/mm/ui/base/MMFalseProgressBar:setVisibility	(I)V
    //   3705: aload_0
    //   3706: aload_0
    //   3707: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3710: aconst_null
    //   3711: iconst_1
    //   3712: invokevirtual 2064	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Ljava/lang/String;Ljava/util/Map;Z)V
    //   3715: goto -497 -> 3218
    //   3718: aload_0
    //   3719: aload_0
    //   3720: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3723: aconst_null
    //   3724: iconst_0
    //   3725: invokevirtual 2064	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Ljava/lang/String;Ljava/util/Map;Z)V
    //   3728: goto -510 -> 3218
    //   3731: aload_0
    //   3732: aload_0
    //   3733: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3736: invokevirtual 974	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aip	(Ljava/lang/String;)Z
    //   3739: ifeq +42 -> 3781
    //   3742: aload_0
    //   3743: aload_0
    //   3744: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3747: aconst_null
    //   3748: iconst_1
    //   3749: invokevirtual 2064	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:b	(Ljava/lang/String;Ljava/util/Map;Z)V
    //   3752: aload_0
    //   3753: aload_0
    //   3754: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3757: putfield 714	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vgp	Ljava/lang/String;
    //   3760: aload_0
    //   3761: iconst_1
    //   3762: putfield 591	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfw	Z
    //   3765: aload_0
    //   3766: getfield 2147	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ved	Lcom/tencent/mm/ui/base/MMFalseProgressBar;
    //   3769: invokevirtual 2150	com/tencent/mm/ui/base/MMFalseProgressBar:finish	()V
    //   3772: aload_0
    //   3773: getfield 2147	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ved	Lcom/tencent/mm/ui/base/MMFalseProgressBar;
    //   3776: bipush 8
    //   3778: invokevirtual 2711	com/tencent/mm/ui/base/MMFalseProgressBar:setVisibility	(I)V
    //   3781: aload_0
    //   3782: getfield 616	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfK	Z
    //   3785: ifne +65 -> 3850
    //   3788: aload_0
    //   3789: getfield 618	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:vfL	Z
    //   3792: ifne +58 -> 3850
    //   3795: aload_0
    //   3796: invokevirtual 1661	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:isFinishing	()Z
    //   3799: ifne +51 -> 3850
    //   3802: ldc_w 429
    //   3805: ldc_w 2713
    //   3808: invokestatic 1032	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3811: aload_0
    //   3812: aload_0
    //   3813: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3816: iconst_0
    //   3817: invokevirtual 2717	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ax	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$w;
    //   3820: pop
    //   3821: ldc_w 429
    //   3824: new 401	java/lang/StringBuilder
    //   3827: dup
    //   3828: ldc_w 2719
    //   3831: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3834: aload_0
    //   3835: getfield 477	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cJr	Ljava/lang/String;
    //   3838: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3841: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3844: invokestatic 1032	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3847: goto -629 -> 3218
    //   3850: sipush 8042
    //   3853: invokestatic 465	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3856: return
    //   3857: astore 6
    //   3859: goto -3069 -> 790
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3862	0	this	WebViewUI
    //   380	2563	1	i	int
    //   417	2525	2	j	int
    //   112	2730	3	bool	boolean
    //   404	213	4	l	long
    //   56	2217	6	localObject1	Object
    //   2363	1	6	localException1	Exception
    //   2409	30	6	localException2	Exception
    //   2486	16	6	localException3	Exception
    //   2568	1	6	localException4	Exception
    //   2597	26	6	localHashMap	HashMap
    //   2652	16	6	localException5	Exception
    //   2686	16	6	localException6	Exception
    //   2718	16	6	localException7	Exception
    //   2769	16	6	localException8	Exception
    //   2912	16	6	localException9	Exception
    //   2946	16	6	localException10	Exception
    //   3028	28	6	localObject2	Object
    //   3137	16	6	localException11	Exception
    //   3168	378	6	localObject3	Object
    //   3647	15	6	localException12	Exception
    //   3857	1	6	localException13	Exception
    //   62	2381	7	localObject4	Object
    //   2454	16	7	localRemoteException	RemoteException
    //   3011	156	7	str1	String
    //   74	2531	8	localObject5	Object
    //   367	351	9	str2	String
    //   440	270	10	str3	String
    //   428	209	11	str4	String
    //   452	199	12	str5	String
    //   464	194	13	str6	String
    //   476	218	14	str7	String
    //   486	188	15	str8	String
    // Exception table:
    //   from	to	target	type
    //   64	111	2363	java/lang/Exception
    //   117	126	2363	java/lang/Exception
    //   2351	2360	2363	java/lang/Exception
    //   2377	2406	2409	java/lang/Exception
    //   2429	2451	2409	java/lang/Exception
    //   340	357	2454	android/os/RemoteException
    //   798	809	2486	java/lang/Exception
    //   809	821	2568	java/lang/Exception
    //   826	846	2568	java/lang/Exception
    //   2518	2528	2568	java/lang/Exception
    //   2533	2565	2568	java/lang/Exception
    //   1578	1595	2652	java/lang/Exception
    //   1679	1699	2686	java/lang/Exception
    //   1758	1792	2718	java/lang/Exception
    //   1919	1936	2769	java/lang/Exception
    //   2181	2207	2912	java/lang/Exception
    //   2207	2212	2912	java/lang/Exception
    //   2852	2892	2912	java/lang/Exception
    //   2895	2909	2912	java/lang/Exception
    //   2235	2251	2946	java/lang/Exception
    //   3044	3057	3137	java/lang/Exception
    //   3363	3378	3647	java/lang/Exception
    //   3383	3423	3647	java/lang/Exception
    //   746	790	3857	java/lang/Exception
  }
  
  protected int aMg()
  {
    AppMethodBeat.i(8001);
    int i = getActionbarColor();
    AppMethodBeat.o(8001);
    return i;
  }
  
  protected boolean aMh()
  {
    return false;
  }
  
  public final void aVC()
  {
    AppMethodBeat.i(8051);
    this.vfS.aVC();
    AppMethodBeat.o(8051);
  }
  
  protected com.tencent.xweb.p aYN()
  {
    try
    {
      AppMethodBeat.i(8033);
      if (this.veY == null) {
        this.veY = new g();
      }
      com.tencent.xweb.p localp = this.veY;
      AppMethodBeat.o(8033);
      return localp;
    }
    finally {}
  }
  
  protected void aYO()
  {
    AppMethodBeat.i(153265);
    com.tencent.mm.plugin.webview.f.d locald = this.vfO;
    locald.startTime = System.currentTimeMillis();
    locald.aX("onCreate", locald.startTime);
    if (this.vfu) {
      fixStatusbar(false);
    }
    AppMethodBeat.o(153265);
  }
  
  protected com.tencent.mm.plugin.webview.ui.tools.jsapi.d aYP()
  {
    AppMethodBeat.i(8050);
    Object localObject = this.pOd;
    k localk = this.igV;
    HashMap localHashMap = new HashMap();
    localHashMap.put("webview_type", "1");
    localHashMap.put("init_url", this.cJr);
    localHashMap.put("init_font_size", "1");
    localHashMap.put("short_url", bo.nullAsNil(getIntent().getStringExtra("shortUrl")));
    localObject = new com.tencent.mm.plugin.webview.ui.tools.jsapi.d((MMWebView)localObject, localk, localHashMap, this.igU, hashCode());
    AppMethodBeat.o(8050);
    return localObject;
  }
  
  protected boolean aYQ()
  {
    return true;
  }
  
  protected boolean aYR()
  {
    return true;
  }
  
  protected boolean aYS()
  {
    return false;
  }
  
  protected void aYT()
  {
    AppMethodBeat.i(8053);
    if (this.pOd != null) {
      this.pOd.reload();
    }
    AppMethodBeat.o(8053);
  }
  
  protected boolean aYU()
  {
    return false;
  }
  
  protected boolean aYb()
  {
    return this.vfz;
  }
  
  protected MMWebView aYh()
  {
    AppMethodBeat.i(8007);
    MMWebView localMMWebView = MMWebView.a.iI(this);
    AppMethodBeat.o(8007);
    return localMMWebView;
  }
  
  protected boolean aYi()
  {
    AppMethodBeat.i(8104);
    if ((getClass().equals(WebViewUI.class)) && (!getIntent().getBooleanExtra("disable_minimize", false))) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WebViewUI", "enableMinimize class:%s enable:%b", new Object[] { getClass(), Boolean.valueOf(bool) });
      AppMethodBeat.o(8104);
      return bool;
    }
  }
  
  protected w aYk()
  {
    AppMethodBeat.i(8032);
    h localh = new h();
    AppMethodBeat.o(8032);
    return localh;
  }
  
  protected void aYm()
  {
    AppMethodBeat.i(138437);
    this.vfO.aX("onUIInitStart", System.currentTimeMillis());
    ab.i("MicroMsg.WebViewUI", "onCreate" + hashCode());
    this.uWu = new n(this);
    this.vfR = new i(this);
    this.vfS = new j(this);
    com.tencent.mm.plugin.webview.f.e.i(daZ(), this);
    aYz();
    this.vgl = true;
    this.veK = getIntent().getIntExtra("geta8key_session_id", (int)System.currentTimeMillis());
    this.veN = getIntent().getByteArrayExtra("geta8key_cookie");
    this.vev = daZ();
    this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
    this.veI = getIntent().getBooleanExtra("from_shortcut", false);
    this.vez = getIntent().getIntExtra(e.l.yVt, -1);
    this.nvY = getIntent().getStringExtra("status_bar_style");
    this.nvX = getIntent().getIntExtra("customize_status_bar_color", 0);
    aYy();
    this.cJr = daZ();
    this.vfz = getIntent().getBooleanExtra("show_native_web_view", false);
    this.veu = getIntent().getBooleanExtra("key_trust_url", false);
    vfJ += 1;
    veU.add(new WebViewUI.z(this));
    if (veU.size() > 1)
    {
      localObject1 = veU;
      localObject1 = (WebViewUI.z)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 2);
      if ((((WebViewUI.z)localObject1).hkv != null) && (((WebViewUI.z)localObject1).hkv.get() != null)) {
        ((WebViewUI)((WebViewUI.z)localObject1).hkv.get()).oq(false);
      }
    }
    ab.i("MicroMsg.WebViewUI", "initView trust:%b, rawUrl = %s ", new Object[] { Boolean.valueOf(this.veu), this.cJr });
    this.cGT = bo.nullAsNil(getIntent().getStringExtra("KPublisherId"));
    this.cNH = aio(getIntent().getStringExtra("geta8key_username"));
    Object localObject1 = this.uVh.dcg();
    int i = this.cNH;
    Object localObject2 = this.cGT;
    ((as.o)localObject1).cNH = i;
    ((as.o)localObject1).uWU = ((String)localObject2);
    this.handler = new ak();
    boolean bool1;
    if (this.uVh != null)
    {
      localObject1 = this.uVh;
      localObject2 = getIntent().getBundleExtra("mm_report_bundle");
      if (localObject2 != null)
      {
        if (((as)localObject1).uWI != null) {
          ((as)localObject1).uWI.mEJ = null;
        }
        ((as)localObject1).uWI = new as.b((as)localObject1, (Bundle)localObject2);
        bool1 = true;
      }
    }
    for (;;)
    {
      this.vey = bool1;
      localObject1 = getIntent().getBundleExtra("close_window_confirm_info");
      if (localObject1 != null) {
        this.vfo = WebViewUI.d.am((Bundle)localObject1);
      }
      getWindow().setFlags(16777216, 16777216);
      getWindow().setFormat(-3);
      this.vfS.ddL();
      u.a.fO(this);
      bool1 = getIntent().getBooleanExtra("usePlugin", true);
      boolean bool2 = getIntent().getBooleanExtra("zoom", true);
      boolean bool3 = getIntent().getBooleanExtra("useJs", true);
      localObject1 = daZ();
      if ((WebView.isX5()) && (com.tencent.mm.plugin.webview.f.e.ajp((String)localObject1)) && (!"true".equals(com.tencent.xweb.a.iW("disable_apk_hook", "tools"))))
      {
        i = 1;
        label658:
        if (i == 0) {
          break label1981;
        }
        this.pOd = MMWebView.a.iH(this);
        com.tencent.xweb.util.f.pf(173L);
        if (this.pOd == null) {
          this.pOd = aYh();
        }
        label691:
        this.pOd.AEe = this;
        localObject1 = this.pOd;
        if ((localObject1 == null) || (((MMWebView)localObject1).getIsX5Kernel()) || (com.tencent.mm.compatible.util.d.fv(19))) {}
      }
      try
      {
        localObject1 = new com.tencent.mm.compatible.loader.c(localObject1, "mSysWebView", null).get();
        ab.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { localObject1 });
        localObject1 = new com.tencent.mm.compatible.loader.c(localObject1, "mProvider", null).get();
        ab.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { localObject1 });
        localObject1 = new com.tencent.mm.compatible.loader.c(localObject1, "mWebViewCore", null).get();
        ab.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { localObject1 });
        localObject1 = new com.tencent.mm.compatible.loader.c(localObject1, "sWebCoreHandler", null).get();
        ab.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { localObject1 });
        localObject1 = new com.tencent.mm.compatible.loader.c(localObject1, "mLooper", null).get();
        ab.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { localObject1 });
        localObject1 = new com.tencent.mm.compatible.loader.c(localObject1, "mThread", null).get();
        ab.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { localObject1 });
        if ((localObject1 instanceof Thread))
        {
          localObject1 = (Thread)localObject1;
          ab.i("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { ((Thread)localObject1).getState() });
          if (((Thread)localObject1).getState() == Thread.State.WAITING) {
            ((Thread)localObject1).interrupt();
          }
        }
        label994:
        this.pOd.getSettings().setJavaScriptEnabled(bool3);
        this.pOd.getSettings().setPluginsEnabled(bool1);
        this.pOd.getSettings().dYx();
        this.pOd.getSettings().setBuiltInZoomControls(bool2);
        this.pOd.getSettings().setUseWideViewPort(true);
        this.pOd.getSettings().setLoadWithOverviewMode(true);
        this.pOd.getSettings().dYs();
        this.pOd.getSettings().dYr();
        this.pOd.getSettings().setGeolocationEnabled(true);
        this.pOd.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.pOd.getSettings().dYz();
        this.pOd.getSettings().dYv();
        this.pOd.getSettings().setAppCachePath(getDir("webviewcache", 0).getAbsolutePath());
        this.pOd.getSettings().dYu();
        this.pOd.getSettings().dYw();
        this.pOd.getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.eQu + "databases/");
        if (!getIntent().getBooleanExtra("vertical_scroll", true))
        {
          this.pOd.setVerticalScrollBarEnabled(false);
          this.pOd.setHorizontalScrollBarEnabled(false);
        }
        com.tencent.xweb.b.dYg().dYh();
        com.tencent.xweb.b.dYg().f(this.pOd);
        localObject1 = (WindowManager)getApplicationContext().getSystemService("window");
      }
      catch (Exception localException4)
      {
        try
        {
          localObject3 = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
          ((Field)localObject3).setAccessible(true);
          localObject2 = ((Field)localObject3).get(null);
          if (localObject2 == null)
          {
            label1304:
            localObject1 = this.vfS;
            if (!(((j)localObject1).ddt() instanceof GameWebViewUI)) {
              break label2051;
            }
            ((j)localObject1).vcL.add(Integer.valueOf(11));
            ((j)localObject1).vcL.add(Integer.valueOf(28));
            label1353:
            this.vfV = new com.tencent.mm.plugin.webview.b();
            if (getIntent().getBooleanExtra("translate_webview", false))
            {
              this.veG = true;
              localObject1 = this.vfV;
              localObject2 = this.pOd;
              localObject3 = this.cJr;
              if ((localObject2 != null) && (!((WebView)localObject2).isSysKernel())) {
                break label2102;
              }
            }
            label1414:
            this.uRy = com.tencent.mm.plugin.webview.ui.tools.bag.o.a(new com.tencent.mm.plugin.webview.ui.tools.bag.q(this, this.pOd), dbc());
            this.uRy.aiF(this.cJr);
            def();
            this.igV = new k((JsapiPermissionWrapper)getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper)getIntent().getParcelableExtra("hardcode_general_ctrl"), new WebViewUI.50(this));
            initView();
            JR("onCreate");
            this.iyo = this.pOd.getSettings().getUserAgentString();
            this.fromScene = getIntent().getIntExtra("from_scence", 0);
            ab.d("MicroMsg.WebViewUI", " onCreate fromScene %d", new Object[] { Integer.valueOf(this.fromScene) });
            this.cpW = com.tencent.mm.model.v.oQ(bo.nullAsNil(hashCode()));
            ab.i("MicroMsg.WebViewUI", " onCreate sessionId %s", new Object[] { this.cpW });
            localObject1 = this.uVh.dcm();
            i = this.cNH;
            localObject2 = this.cGT;
            ((as.h)localObject1).cNH = i;
            ((as.h)localObject1).uWU = ((String)localObject2);
            ((as.h)localObject1).url = this.cJr;
            localObject2 = this.uVh.dcs();
            localObject1 = this.cJr;
            ab.i("MicroMsg.WebviewReporter.DomainReporter", "setRawUrl, value = %s", new Object[] { localObject1 });
          }
        }
        catch (Exception localException4)
        {
          try
          {
            localObject3 = Uri.parse((String)localObject1);
            if ((((Uri)localObject3).getScheme() != null) && (!((Uri)localObject3).getScheme().toLowerCase().startsWith("http"))) {
              ab.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl scheme is not http/https, skip, scheme = %s", new Object[] { ((Uri)localObject3).getScheme() });
            }
          }
          catch (Exception localException4)
          {
            try
            {
              label1737:
              this.vgd = getContentView();
              if (this.vgd != null)
              {
                aYx();
                ((ViewGroup)((ViewGroup)getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new WebViewUI.52(this));
              }
            }
            catch (Exception localException4)
            {
              try
              {
                Object localObject3;
                label1784:
                if (this.vfu) {
                  if (deh()) {
                    dej();
                  }
                }
                for (;;)
                {
                  for (;;)
                  {
                    this.vep = new com.tencent.mm.bn.a(getContext(), this.vgf);
                    this.vfP.aNS().ac(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(7882);
                        com.tencent.mm.cd.f.dvf();
                        com.tencent.mm.cd.b.duW();
                        AppMethodBeat.o(7882);
                      }
                    });
                    this.vfU = new WebViewClipBoardHelper(this);
                    this.vgb.alive();
                    this.vff.alive();
                    if (this.vfY != null)
                    {
                      localObject1 = this.vfY;
                      if (((o)localObject1).vhe != null)
                      {
                        ((o)localObject1).pOn = ((o)localObject1).vhe.pOd;
                        if (!((o)localObject1).vhd) {
                          break label2446;
                        }
                        ab.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle true");
                      }
                    }
                    aj(getWindow().getDecorView(), 256);
                    as.nn(getIntent().getLongExtra("start_activity_time", 0L));
                    this.vfO.aX("onUIInitEnd", System.currentTimeMillis());
                    AppMethodBeat.o(138437);
                    return;
                    bool1 = false;
                    break;
                    bool1 = false;
                    break;
                    i = 0;
                    break label658;
                    label1981:
                    this.pOd = aYh();
                    break label691;
                    localException1 = localException1;
                    ab.e("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { localException1 });
                    break label994;
                    localObject3 = ((Field)localObject3).getType().getDeclaredField("mWindowManager");
                    ((Field)localObject3).setAccessible(true);
                    ((Field)localObject3).set(localObject2, localException1);
                    break label1304;
                    localException2 = localException2;
                    break label1304;
                    label2051:
                    localException2.vcL.add(Integer.valueOf(7));
                    localException2.vcL.add(Integer.valueOf(11));
                    localException2.vcL.add(Integer.valueOf(28));
                    break label1353;
                    label2102:
                    Bundle localBundle = new Bundle();
                    localBundle.putString("destLanguage", com.tencent.mm.sdk.platformtools.aa.dsG());
                    localBundle.putString("url", (String)localObject3);
                    localBundle.putString("translateTips", getString(2131305894));
                    localBundle.putString("translateFinish", getString(2131305891));
                    localBundle.putString("errorWording", getString(2131305890));
                    localException2.uNJ = getString(2131305894);
                    localException2.uNK = getString(2131305895);
                    com.tencent.mm.sdk.b.a.ymk.c(localException2.uNO);
                    try
                    {
                      ((WebView)localObject2).invokeMiscMethod("translateWebSite", localBundle);
                    }
                    catch (Exception localException3)
                    {
                      ab.e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", new Object[] { localException3.getMessage() });
                    }
                  }
                  break label1414;
                  localObject3 = ((Uri)localObject3).getHost();
                  if ((localObject3 == null) || (((String)localObject3).toLowerCase().endsWith(".qq.com")))
                  {
                    ab.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl, host is .qq.com, skip, host = %s", new Object[] { localObject3 });
                    break label1737;
                    localException6 = localException6;
                    ab.e("MicroMsg.WebviewReporter.DomainReporter", "parse rawUrl fail, rawUrl = %s", new Object[] { localException3 });
                    break label1737;
                  }
                  localException6.mzI = true;
                  break label1737;
                  localException4 = localException4;
                  ab.e("MicroMsg.WebViewUI", "fixContentMargin error : %s", new Object[] { localException4.getMessage() });
                  break label1784;
                  if (!com.tencent.mm.compatible.util.d.fv(21)) {
                    break label2429;
                  }
                  ViewGroup localViewGroup = (ViewGroup)((ViewGroup)getWindow().getDecorView()).getChildAt(0);
                  localViewGroup.setOnApplyWindowInsetsListener(new WebViewUI.53(this, localViewGroup));
                }
              }
              catch (Exception localException5)
              {
                for (;;)
                {
                  ab.e("MicroMsg.WebViewUI", "tryToExpandToStatusBar error : %s", new Object[] { localException5.getMessage() });
                  continue;
                  label2429:
                  ((ViewGroup)getWindow().getDecorView()).setFitsSystemWindows(true);
                  continue;
                  label2446:
                  ab.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle false");
                  localException5.deU();
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected void aYo()
  {
    AppMethodBeat.i(8052);
    this.vfS.aYo();
    AppMethodBeat.o(8052);
  }
  
  protected void aYp()
  {
    AppMethodBeat.i(153271);
    this.vfS.aYp();
    AppMethodBeat.o(153271);
  }
  
  protected void aYt()
  {
    AppMethodBeat.i(153269);
    this.vfS.aYt();
    AppMethodBeat.o(153269);
  }
  
  protected void aYx()
  {
    AppMethodBeat.i(7998);
    if (this.vgd != null) {
      if ((!this.ven) && (!this.veo)) {
        break label40;
      }
    }
    label40:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(7998);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.vgd.getLayoutParams();
    i = deg();
    if (i != localMarginLayoutParams.topMargin)
    {
      localMarginLayoutParams.topMargin = i;
      this.vgd.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(7998);
  }
  
  protected void aYy()
  {
    AppMethodBeat.i(153263);
    Object localObject1;
    boolean bool;
    label26:
    Object localObject3;
    if (getIntent() == null)
    {
      localObject1 = "";
      if (getIntent() != null) {
        break label98;
      }
      bool = false;
      ab.i("MicroMsg.WebViewUI", "initCustomActionBarColorIfNeed isNativeStyle is %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label113;
      }
      localObject3 = "white";
      KA(-16777216);
    }
    for (;;)
    {
      try
      {
        int i = Color.parseColor((String)localObject3);
        localObject1 = Integer.valueOf(i);
      }
      catch (Exception localException)
      {
        label98:
        label113:
        Object localObject2 = null;
        continue;
        localObject3 = new Bundle(1);
        ((Bundle)localObject3).putInt("set_navigation_bar_color_color", localObject2.intValue());
        ((Bundle)localObject3).putInt("set_navigation_bar_color_alpha", 255);
        al((Bundle)localObject3);
        if (getIntent().hasExtra("customize_status_bar_color")) {
          continue;
        }
        this.nvX = localObject2.intValue();
        AppMethodBeat.o(153263);
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(153263);
        return;
        localObject1 = getIntent().getStringExtra("custom_action_bar_color");
        break;
        bool = getIntent().getBooleanExtra("open_custom_style_url", false);
        break label26;
        localObject3 = localObject1;
        if (!bo.isNullOrNil((String)localObject1)) {
          continue;
        }
        AppMethodBeat.o(153263);
        return;
      }
    }
  }
  
  protected void aYz()
  {
    AppMethodBeat.i(8009);
    this.vfY = new o(this);
    o localo = this.vfY;
    if (localo.vhe != null) {
      if (!localo.deT()) {
        break label79;
      }
    }
    label79:
    for (localo.vhd = true;; localo.vhd = false)
    {
      ab.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleParams, webViewUI#%s, disableLightActionbarStyle:%b", new Object[] { localo.vhe, Boolean.valueOf(localo.vhd) });
      AppMethodBeat.o(8009);
      return;
    }
  }
  
  protected void aZr()
  {
    AppMethodBeat.i(153270);
    this.vfq.setVisibility(0);
    AppMethodBeat.o(153270);
  }
  
  protected void aZy()
  {
    AppMethodBeat.i(8021);
    this.vex = System.currentTimeMillis();
    this.pOd.goBack();
    this.veL = null;
    if (this.vfj) {
      this.vfj = false;
    }
    m localm = m.vdm;
    ab.v("MicroMsg.WebViewReportUtil", "goBack traceid %s", new Object[] { localm.rpu });
    if (!bo.isNullOrNil(localm.rpu)) {
      localm.kS(5);
    }
    AppMethodBeat.o(8021);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(8062);
    if (!com.tencent.mm.compatible.util.d.fv(21))
    {
      super.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
      AppMethodBeat.o(8062);
      return;
    }
    Drawable localDrawable = android.support.v4.content.b.k(this, paramInt2);
    if (localDrawable == null)
    {
      AppMethodBeat.o(8062);
      return;
    }
    if (dei()) {
      localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
    for (;;)
    {
      addIconOptionMenu(paramInt1, getString(2131296998), localDrawable, paramOnMenuItemClickListener);
      AppMethodBeat.o(8062);
      return;
      if ((this.vfY != null) && (!this.vfY.vhd)) {
        localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      } else {
        localDrawable.clearColorFilter();
      }
    }
  }
  
  public final void ain(String paramString)
  {
    AppMethodBeat.i(8055);
    this.vfS.ain(paramString);
    AppMethodBeat.o(8055);
  }
  
  protected final int aio(String paramString)
  {
    AppMethodBeat.i(8079);
    int j = getIntent().getIntExtra("geta8key_scene", 0);
    int i = j;
    if (j == 0)
    {
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label219;
      }
      if (this.igU != null) {
        break label72;
      }
      i = 1;
    }
    for (;;)
    {
      ab.i("MicroMsg.WebViewUI", "KGetA8KeyScene = %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(8079);
      return i;
      try
      {
        label72:
        if (this.igU.oD(paramString))
        {
          i = 8;
          continue;
        }
        if (!this.igU.nU(paramString)) {
          break label214;
        }
        j = 7;
        Bundle localBundle = new Bundle();
        localBundle.putString("enterprise_biz_username", paramString);
        try
        {
          paramString = this.igU.i(102, localBundle);
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
          ab.e("MicroMsg.WebViewUI", "invoke the check enterprise failed");
          i = j;
        }
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.WebViewUI", "getScene fail, ex = " + paramString.getMessage());
        i = 1;
      }
      continue;
      label214:
      i = 1;
      continue;
      label219:
      i = 0;
    }
  }
  
  protected boolean aip(String paramString)
  {
    AppMethodBeat.i(8043);
    AppMethodBeat.o(8043);
    return false;
  }
  
  public final void air(String paramString)
  {
    AppMethodBeat.i(8066);
    this.uQS.bQ("profile", true);
    this.uQS.aiX(paramString);
    AppMethodBeat.o(8066);
  }
  
  protected void ais(String paramString)
  {
    AppMethodBeat.i(8071);
    if (this.igV.ddW().dqv())
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("fromScene", 100);
      if (this.igU.a(paramString, this.igV.ddV().jy(7), localBundle)) {
        ab.i("MicroMsg.WebViewUI", "shouldOverride, built in url handled, url = ".concat(String.valueOf(paramString)));
      }
      AppMethodBeat.o(8071);
      return;
    }
    ab.w("MicroMsg.WebViewUI", "shouldOverride, allow inner open url, not allow");
    AppMethodBeat.o(8071);
  }
  
  protected boolean ait(String paramString)
  {
    AppMethodBeat.i(8072);
    Iterator localIterator = this.veT.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.webview.ui.tools.jsapi.b localb = (com.tencent.mm.plugin.webview.ui.tools.jsapi.b)localIterator.next();
      if (a(localb, paramString))
      {
        ab.i("MicroMsg.WebViewUI", "url handled, url = ".concat(String.valueOf(paramString)));
        if (this.vgn.equals(paramString))
        {
          ab.i("MicroMsg.WebViewUI", "url " + paramString + " has been handle");
          AppMethodBeat.o(8072);
          return true;
        }
        boolean bool = localb.ait(paramString);
        ab.i("MicroMsg.WebViewUI", "url handled, ret = " + bool + ", url = " + paramString);
        AppMethodBeat.o(8072);
        return true;
      }
    }
    AppMethodBeat.o(8072);
    return false;
  }
  
  public final String aiu(String paramString)
  {
    AppMethodBeat.i(8073);
    String str2 = "";
    Object localObject = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = str2;
      if (this.igU != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("webview_binder_id", hashCode());
        ((Bundle)localObject).putString("rawUrl", paramString);
        paramString = str2;
      }
    }
    try
    {
      localObject = bo.nullAsNil(this.igU.i(76, (Bundle)localObject).getString("appId"));
      paramString = (String)localObject;
      ab.i("MicroMsg.WebViewUI", "stev cachedAppId %s", new Object[] { localObject });
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.w("MicroMsg.WebViewUI", "get cachedAppId error ", new Object[] { localRemoteException.getMessage() });
        String str1 = paramString;
      }
    }
    AppMethodBeat.o(8073);
    return localObject;
  }
  
  protected void ak(Bundle paramBundle) {}
  
  protected void al(Bundle paramBundle)
  {
    AppMethodBeat.i(7983);
    int i;
    if (paramBundle.getBoolean("set_navigation_bar_color_reset", false)) {
      if (this.vfY == null) {
        i = getResources().getColor(2131690692);
      }
    }
    for (int j = 255;; j = paramBundle.getInt("set_navigation_bar_color_alpha"))
    {
      setActionbarColor(i & 0xFFFFFF | j << 24);
      AppMethodBeat.o(7983);
      return;
      i = this.vfY.deZ();
      break;
      i = paramBundle.getInt("set_navigation_bar_color_color");
    }
  }
  
  public final void au(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(8004);
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.sdk.h.b.Mo()))
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
        AppMethodBeat.o(8004);
        return;
        paramInt &= 0xFFFFDFFF;
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      int i = paramInt;
      if (paramBoolean) {
        i = g.Kq(paramInt);
      }
      setStatusBarColor(i);
    }
    AppMethodBeat.o(8004);
  }
  
  protected WebViewUI.w ax(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(8077);
    paramString = k(paramString, paramBoolean, -1);
    AppMethodBeat.o(8077);
    return paramString;
  }
  
  protected void b(com.tencent.mm.plugin.webview.stub.c paramc)
  {
    AppMethodBeat.i(8083);
    ab.i("MicroMsg.WebViewUI", "onSceneEnd, instance hashcode = " + hashCode());
    if (this.pOd == null)
    {
      ab.w("MicroMsg.WebViewUI", "onSceneEnd, viewWV is null, do nothing");
      AppMethodBeat.o(8083);
      return;
    }
    if ((isFinishing()) || (this.igV == null))
    {
      ab.w("MicroMsg.WebViewUI", "onSceneEnd, isFinishing, do nothing");
      AppMethodBeat.o(8083);
      return;
    }
    int j = 0;
    int n = -1;
    int i1 = -1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int k = i1;
    int i = n;
    try
    {
      m = paramc.getType();
      localObject1 = localObject2;
      k = i1;
      i = n;
      j = m;
      n = paramc.dcV();
      localObject1 = localObject2;
      k = i1;
      i = n;
      j = m;
      i1 = paramc.getErrCode();
      localObject1 = localObject2;
      k = i1;
      i = n;
      j = m;
      localObject2 = paramc.getErrMsg();
      localObject1 = localObject2;
      k = i1;
      i = n;
      j = m;
      paramc = paramc.getData();
      i = i1;
      j = n;
    }
    catch (Exception paramc)
    {
      int m;
      for (;;)
      {
        ab.e("MicroMsg.WebViewUI", "onSceneEnd, ex = " + paramc.getMessage());
        paramc = null;
        n = i;
        localObject2 = localObject1;
        m = j;
        i = k;
        j = n;
      }
      if ((m == 233) || (m == 131) || (m == 106) || (m == 673) || (m == 666) || (m == 1254) || (m == 1373)) {
        break label441;
      }
      AppMethodBeat.o(8083);
      return;
      switch (m)
      {
      default: 
        AppMethodBeat.o(8083);
        return;
      case 106: 
        finish();
        AppMethodBeat.o(8083);
        return;
      case 233: 
        localObject2 = ((Bundle)localObject1).getString("geta8key_result_req_url");
        if (this.vfy.contains(localObject2)) {
          break label567;
        }
        ab.w("MicroMsg.WebViewUI", "invalid url: %s, just break.", new Object[] { localObject2 });
        AppMethodBeat.o(8083);
        return;
        this.vfc.deR();
        localJsapiPermissionWrapper = new JsapiPermissionWrapper(((Bundle)localObject1).getByteArray("geta8key_result_jsapi_perm_control_bytes"));
        localGeneralControlWrapper = new GeneralControlWrapper(((Bundle)localObject1).getInt("geta8key_result_general_ctrl_b1"));
        this.vgx = ((Bundle)localObject1).getLong("geta8key_result_deep_link_bit_set", 0L);
        this.vfS.vcH = ((Bundle)localObject1).getString("geta8key_result_menu_wording");
        k = ((Bundle)localObject1).getInt("geta8key_result_reason");
        ab.i("MicroMsg.WebViewUI", "edw geta8key onSceneEnd, req reason = ".concat(String.valueOf(k)));
        if (this.pOd == null) {
          break label679;
        }
        this.pOd.setA8keyReason(k);
        localObject3 = null;
        if (!bo.isEqual((String)localObject2, this.veL)) {
          break label699;
        }
        this.veM = true;
        paramc = localObject3;
        switch (k)
        {
        default: 
          paramc = localObject3;
        case 3: 
        case 4: 
        case 6: 
        case 7: 
          Z(this.igV.agS(paramc).jy(34), this.igV.agS(paramc).jy(75));
          if ((j == 0) && (i == 0))
          {
            paramc = this.vfS;
            paramc.vcL.add(Integer.valueOf(6));
            paramc.vcL.add(Integer.valueOf(1));
            paramc.vcL.add(Integer.valueOf(3));
            paramc.vcL.add(Integer.valueOf(2));
            this.vfS.vcK = true;
            if (this.vfS.kiI) {
              aYo();
            }
          }
          break;
        }
        for (;;)
        {
          this.vfO.aX("getA8KeyEnd", System.currentTimeMillis());
          dey();
          AppMethodBeat.o(8083);
          return;
          if (((j == 0) && (i == 0)) || ((j == 4) && (i == -2005)))
          {
            paramc = ((Bundle)localObject1).getString("geta8key_result_full_url");
            a((String)localObject2, paramc, localJsapiPermissionWrapper, localGeneralControlWrapper);
            P((Bundle)localObject1);
            this.vfg = localJsapiPermissionWrapper.jy(24);
            this.uVh.dcn().uWO = true;
            this.veN = ((Bundle)localObject1).getByteArray("geta8key_result_cookie");
            ab.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", new Object[] { bo.cg(this.veN) });
            break;
          }
          m.vdm.Kx(j);
          if ((this.vfq != null) && (!aip((String)localObject2)))
          {
            aZr();
            Y(true, true);
          }
          this.uVh.dcn().uWO = false;
          this.uVh.dch().bL((String)localObject2, false);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(154L, 12L, 1L, false);
          k = b.Kn(k);
          if (-1 != k) {
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(154L, k, 1L, false);
          }
          J((Bundle)localObject1);
          paramc = localObject3;
          if (!this.veH) {
            break;
          }
          finish();
          paramc = localObject3;
          break;
          if ((j == 0) && (i == 0))
          {
            this.igV.a((String)localObject2, localJsapiPermissionWrapper, localGeneralControlWrapper);
            this.vfy.remove(localObject2);
            if (this.vfG)
            {
              Y(true, true);
              this.vfG = false;
            }
            if (k != 5) {
              this.vfg = localJsapiPermissionWrapper.jy(24);
            }
            this.veN = ((Bundle)localObject1).getByteArray("geta8key_result_cookie");
            ab.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", new Object[] { bo.cg(this.veN) });
            paramc = (com.tencent.mm.plugin.webview.stub.c)localObject2;
            break;
          }
          if ((j == 4) && (i == -2005))
          {
            this.pOd.stopLoading();
            this.veQ = false;
            paramc = ((Bundle)localObject1).getString("geta8key_result_full_url");
            a((String)localObject2, paramc, localJsapiPermissionWrapper, localGeneralControlWrapper);
            P((Bundle)localObject1);
            this.veN = ((Bundle)localObject1).getByteArray("geta8key_result_cookie");
            ab.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", new Object[] { bo.cg(this.veN) });
            break;
          }
          if ((j != 0) && (i == -3300))
          {
            ab.e("MicroMsg.WebViewUI", "onSceneEnd errType:%d, errCode:%d, disable iframe getA8Key", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            this.veO = true;
            paramc = localObject3;
            break;
          }
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(154L, 12L, 1L, false);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(154L, b.Kn(k), 1L, false);
          Y(true, true);
          paramc = localObject3;
          break;
          this.vfS.vcK = false;
        }
      case 673: 
        paramc = this.vfd;
        paramc.vgV -= 1;
        if (paramc.vgV > 0) {
          break label1473;
        }
        paramc.vgz.Kz(673);
        if ((j != 0) || (i != 0)) {
          break label1554;
        }
        if (localObject1 == null) {
          break label1535;
        }
        for (paramc = ((Bundle)localObject1).getString("reading_mode_result_url");; paramc = null)
        {
          ab.i("MicroMsg.WebViewUI", "[cpan] onsceneend url:%s", new Object[] { paramc });
          if (!bo.isNullOrNil(paramc)) {
            break;
          }
          ab.i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
          AppMethodBeat.o(8083);
          return;
        }
        b(paramc, null, false);
        AppMethodBeat.o(8083);
        return;
        ab.i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
        AppMethodBeat.o(8083);
        return;
      }
    }
    if (paramc == null) {}
    for (localObject1 = new Bundle();; localObject1 = paramc)
    {
      k = ((Bundle)localObject1).getInt("scene_end_listener_hash_code");
      ab.i("MicroMsg.WebViewUI", "get hash code = %d, self hash code = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(hashCode()) });
      ab.i("MicroMsg.WebViewUI", "edw onSceneEnd, type = " + m + ", errCode = " + i + ", errType = " + j);
      if (k != hashCode())
      {
        ab.e("MicroMsg.WebViewUI", "hash code not equal");
        AppMethodBeat.o(8083);
        return;
      }
      label441:
      JsapiPermissionWrapper localJsapiPermissionWrapper;
      label567:
      GeneralControlWrapper localGeneralControlWrapper;
      label679:
      Object localObject3;
      label699:
      label1473:
      label1535:
      paramc = this.vfe;
      label1554:
      paramc.vgW -= 1;
      if (paramc.vgW <= 0) {
        paramc.vgz.Kz(666);
      }
      finish();
      AppMethodBeat.o(8083);
      return;
      if ((j == 0) && (i == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        ah.c.a(bool, (String)localObject2, (Bundle)localObject1, this, this.igU, this.vgu, this.vgv, hashCode(), i);
        AppMethodBeat.o(8083);
        return;
      }
      if ((j == 0) && (i == 0)) {}
      for (bool = true;; bool = false)
      {
        ah.c.a(bool, (String)localObject2, (Bundle)localObject1, this, this.vgu, this.vgv);
        break;
      }
    }
  }
  
  protected void b(WebView paramWebView, String paramString) {}
  
  protected void b(String paramString1, String paramString2, Map<String, String> paramMap) {}
  
  protected void b(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(8045);
    if (paramBoolean)
    {
      paramMap = new HashMap(2);
      paramMap.put("Pragma", "no-cache");
      paramMap.put("Cache-Control", "no-cache");
      if (this.pOd != null) {
        this.pOd.loadUrl(paramString, paramMap);
      }
      AppMethodBeat.o(8045);
      return;
    }
    if (this.pOd != null)
    {
      if (paramMap != null)
      {
        this.pOd.loadUrl(paramString, paramMap);
        AppMethodBeat.o(8045);
        return;
      }
      this.pOd.loadUrl(paramString);
    }
    AppMethodBeat.o(8045);
  }
  
  protected final void c(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(8058);
    addIconOptionMenu(0, paramString, paramDrawable, new WebViewUI.27(this, deu(), getIntent().getStringExtra("srcUsername")));
    AppMethodBeat.o(8058);
  }
  
  protected void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(8085);
    String str1 = bo.bf(dek(), this.cJr);
    if (bo.isNullOrNil(str1))
    {
      ab.e("MicroMsg.WebViewUI", "after getA8Key, currentURL is null or nil, wtf");
      b(paramString2, null, false);
      AppMethodBeat.o(8085);
      return;
    }
    if (this.uQS == null)
    {
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        b(paramString2, paramMap, false);
        AppMethodBeat.o(8085);
        return;
      }
      b(paramString2, null, false);
      AppMethodBeat.o(8085);
      return;
    }
    if ((bo.nullAsNil(paramString2).contains("#wechat_redirect")) || (bo.nullAsNil(paramString1).contains("#wechat_redirect")))
    {
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        b(paramString2, paramMap, false);
        AppMethodBeat.o(8085);
        return;
      }
      b(paramString2, null, false);
      AppMethodBeat.o(8085);
      return;
    }
    if (!hy(str1, paramString2))
    {
      String str2 = com.tencent.mm.plugin.webview.d.b.asL(str1);
      String str3 = com.tencent.mm.plugin.webview.d.b.asL(paramString2);
      if ((bo.isNullOrNil(str3)) || (bo.isNullOrNil(str2)) || (!str3.equals(str2)) || (this.igU == null) || (!aip(str1))) {
        break label304;
      }
    }
    label304:
    for (int i = 1; i != 0; i = 0)
    {
      this.vfH.put(str1, paramString2);
      this.vfB.put(str1, paramMap);
      this.vfH.put(paramString1, paramString2);
      this.vfB.put(paramString1, paramMap);
      this.uQS.B(paramString2, paramMap);
      AppMethodBeat.o(8085);
      return;
    }
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      b(paramString2, paramMap, false);
      AppMethodBeat.o(8085);
      return;
    }
    b(paramString2, null, false);
    AppMethodBeat.o(8085);
  }
  
  public final void cnh()
  {
    AppMethodBeat.i(8067);
    this.uQS.bQ("sendAppMessage", true);
    this.uQS.q(this.vfS.ddR());
    this.uVh.ahs("mm_send_friend_count");
    AppMethodBeat.o(8067);
  }
  
  public boolean convertActivityFromTranslucent()
  {
    AppMethodBeat.i(7989);
    boolean bool = getIntent().getBooleanExtra("convertActivityFromTranslucent", true);
    AppMethodBeat.o(7989);
    return bool;
  }
  
  protected void dS(String paramString, int paramInt)
  {
    AppMethodBeat.i(8022);
    if (this.veq == null)
    {
      AppMethodBeat.o(8022);
      return;
    }
    WebViewInputFooter localWebViewInputFooter = this.veq;
    localWebViewInputFooter.setVisibility(0);
    if (localWebViewInputFooter.vtx != null) {
      localWebViewInputFooter.vtx.setVisibility(0);
    }
    if (localWebViewInputFooter.vtw != null)
    {
      localWebViewInputFooter.vtw.setEnabled(true);
      localWebViewInputFooter.vtw.setBackgroundResource(2130839162);
    }
    if (localWebViewInputFooter.vtt != null) {
      localWebViewInputFooter.vtt.setVisibility(0);
    }
    localWebViewInputFooter.vty = false;
    if (localWebViewInputFooter.vtw != null)
    {
      localWebViewInputFooter.vtw.setFocusable(true);
      localWebViewInputFooter.vtw.setFocusableInTouchMode(true);
      localWebViewInputFooter.vtw.requestFocus();
    }
    if (localWebViewInputFooter.cmc != null) {
      localWebViewInputFooter.cmc.showVKB();
    }
    localWebViewInputFooter.state = 0;
    if (!bo.isNullOrNil(paramString)) {
      this.veq.setText(paramString);
    }
    if (paramInt >= 0) {
      this.veq.setMaxCount(paramInt);
    }
    AppMethodBeat.o(8022);
  }
  
  protected int daT()
  {
    AppMethodBeat.i(8023);
    if (this.veq == null)
    {
      AppMethodBeat.o(8023);
      return 0;
    }
    int i = this.veq.dhb();
    AppMethodBeat.o(8023);
    return i;
  }
  
  public final boolean daU()
  {
    AppMethodBeat.i(8093);
    if ((this.vfo != null) && (this.vfo.dbw()) && (!bo.isNullOrNil(this.vfo.deP())) && (!bo.isNullOrNil(this.vfo.dby())) && (!bo.isNullOrNil(this.vfo.dbz())))
    {
      Object localObject = this.vfo.deP();
      String str1 = this.vfo.dby();
      String str2 = this.vfo.dbz();
      ab.i("MicroMsg.WebViewUI", "use js api close window confirm info : %s, %s, %s", new Object[] { localObject, str1, str2 });
      View localView = View.inflate(getContext(), 2130970141, null);
      CheckBox localCheckBox = (CheckBox)localView.findViewById(2131826141);
      localCheckBox.setChecked(false);
      localCheckBox.setVisibility(8);
      TextView localTextView = (TextView)localView.findViewById(2131826140);
      localTextView.setText((CharSequence)localObject);
      localTextView.setTextColor(getResources().getColor(2131690322));
      localObject = (TextView)localView.findViewById(2131826142);
      ((TextView)localObject).setTextColor(getResources().getColor(2131690322));
      ((TextView)localObject).setVisibility(8);
      this.vfp = com.tencent.mm.ui.base.h.a(getContext(), true, "", localView, str1, str2, new WebViewUI.45(this, localCheckBox), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(7877);
          WebViewUI.this.vfp = null;
          AppMethodBeat.o(7877);
        }
      });
      AppMethodBeat.o(8093);
      return true;
    }
    AppMethodBeat.o(8093);
    return false;
  }
  
  public final String daZ()
  {
    Object localObject = null;
    AppMethodBeat.i(8049);
    try
    {
      String str = getIntent().getStringExtra("rawUrl");
      localObject = str;
    }
    catch (Exception localException)
    {
      do
      {
        ab.e("MicroMsg.WebViewUI", "getRawUrl exception:%s", new Object[] { localException.getMessage() });
      } while (!(localException instanceof ClassNotFoundException));
      finish();
      AppMethodBeat.o(8049);
      return null;
    }
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      AppMethodBeat.o(8049);
      return localObject;
    }
    localObject = getIntent().getData();
    if (localObject == null)
    {
      AppMethodBeat.o(8049);
      return "";
    }
    localObject = ((Uri)localObject).toString();
    AppMethodBeat.o(8049);
    return localObject;
  }
  
  protected final boolean dbc()
  {
    AppMethodBeat.i(8103);
    boolean bool1 = getIntent().getBooleanExtra("forceHideShare", false);
    boolean bool2 = getIntent().getBooleanExtra("showShare", true);
    ab.i("MicroMsg.WebViewUI", "forceHideShare:%b showShareBtn:%b enableMinimize:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(aYi()) });
    if ((!bool1) && (bool2) && (aYi()))
    {
      AppMethodBeat.o(8103);
      return true;
    }
    AppMethodBeat.o(8103);
    return false;
  }
  
  protected void ddH()
  {
    AppMethodBeat.i(8025);
    int i = getIntent().getIntExtra("webview_bg_color_rsID", -1);
    if ((i != -1) && (getContentView() != null))
    {
      setBackGroundColorResource(i);
      getContentView().setBackgroundResource(i);
      this.pOd.setBackgroundResource(17170445);
      findViewById(2131823716).setBackgroundResource(17170445);
      AppMethodBeat.o(8025);
      return;
    }
    this.pOd.setBackgroundColor(getResources().getColor(2131689497));
    AppMethodBeat.o(8025);
  }
  
  public final void ddQ()
  {
    AppMethodBeat.i(8054);
    this.vfS.ddQ();
    AppMethodBeat.o(8054);
  }
  
  protected boolean ddz()
  {
    return false;
  }
  
  protected boolean deA()
  {
    return false;
  }
  
  protected void deE()
  {
    AppMethodBeat.i(8095);
    if (deD())
    {
      AppMethodBeat.o(8095);
      return;
    }
    deF();
    if (!daU())
    {
      this.vfK = true;
      m.vdm.close();
      if (this.uRy.KE(20))
      {
        AppMethodBeat.o(8095);
        return;
      }
      finish();
    }
    AppMethodBeat.o(8095);
  }
  
  protected final boolean deG()
  {
    AppMethodBeat.i(8099);
    if (this.khm != -3)
    {
      showVKB();
      AppMethodBeat.o(8099);
      return true;
    }
    AppMethodBeat.o(8099);
    return false;
  }
  
  protected void deH() {}
  
  public final MMWebView deI()
  {
    return this.pOd;
  }
  
  protected final void deJ()
  {
    AppMethodBeat.i(8106);
    overridePendingTransition(2131034229, 2131034228);
    AppMethodBeat.o(8106);
  }
  
  public final com.tencent.mm.plugin.webview.f.d dee()
  {
    return this.vfO;
  }
  
  protected boolean deh()
  {
    return true;
  }
  
  final boolean dei()
  {
    AppMethodBeat.i(8002);
    if ((!bo.isNullOrNil(this.nvY)) && (this.nvY.equals("black")))
    {
      AppMethodBeat.o(8002);
      return true;
    }
    AppMethodBeat.o(8002);
    return false;
  }
  
  protected final void dej()
  {
    AppMethodBeat.i(8003);
    if ((com.tencent.mm.compatible.util.d.fv(21)) && (this.nvX != 0))
    {
      setActionbarColor(this.nvX);
      if (dei())
      {
        setBackBtnColorFilter(-16777216);
        setMMTitleColor(-16777216);
      }
      au(this.nvX, dei());
      AppMethodBeat.o(8003);
      return;
    }
    setStatusBarColor(aMg());
    AppMethodBeat.o(8003);
  }
  
  public final String dek()
  {
    AppMethodBeat.i(8006);
    if (this.handler == null)
    {
      str = this.vgp;
      AppMethodBeat.o(8006);
      return str;
    }
    if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId())
    {
      if (this.pOd == null)
      {
        AppMethodBeat.o(8006);
        return "";
      }
      str = this.pOd.getUrl();
      AppMethodBeat.o(8006);
      return str;
    }
    if (!bo.isNullOrNil(this.vgp))
    {
      str = this.vgp;
      AppMethodBeat.o(8006);
      return str;
    }
    long l = System.currentTimeMillis();
    this.vgp = ((String)new WebViewUI.2(this, "").b(this.handler));
    int i = (int)(System.currentTimeMillis() - l);
    if (i >= 500) {
      ab.w("MicroMsg.WebViewUI", "getCurrentURL cost to much time %d %s", new Object[] { Integer.valueOf(i), bo.dtY() });
    }
    String str = this.vgp;
    AppMethodBeat.o(8006);
    return str;
  }
  
  public final void del()
  {
    AppMethodBeat.i(156881);
    u.a.fO(this);
    AppMethodBeat.o(156881);
  }
  
  protected void deo()
  {
    AppMethodBeat.i(8026);
    if (getIntent() == null)
    {
      AppMethodBeat.o(8026);
      return;
    }
    if (getIntent().hasExtra("show_full_screen")) {
      X(getIntent().getBooleanExtra("show_full_screen", false), true);
    }
    AppMethodBeat.o(8026);
  }
  
  protected int dep()
  {
    AppMethodBeat.i(8034);
    if (aYb())
    {
      AppMethodBeat.o(8034);
      return 0;
    }
    AppMethodBeat.o(8034);
    return 2131230739;
  }
  
  protected boolean deq()
  {
    return true;
  }
  
  protected com.tencent.mm.plugin.websearch.api.ah der()
  {
    return null;
  }
  
  protected void des() {}
  
  protected final LinkedList<d.a> det()
  {
    AppMethodBeat.i(8056);
    if (this.pOd == null)
    {
      ab.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
      AppMethodBeat.o(8056);
      return null;
    }
    Object localObject = this.cJr;
    if (this.pOd != null)
    {
      String str = this.pOd.getUrl();
      if (!bo.isNullOrNil(str))
      {
        localObject = str;
        for (;;)
        {
          if (localObject == null)
          {
            AppMethodBeat.o(8056);
            return null;
          }
          try
          {
            localObject = new URL((String)localObject);
            Pattern localPattern = Pattern.compile(".*(\\.wanggou\\.com|\\.jd\\.com)");
            str = ((URL)localObject).getHost();
            boolean bool = bo.isNullOrNil(str);
            if (bool)
            {
              AppMethodBeat.o(8056);
              return null;
            }
            localObject = str;
            if (!str.startsWith(".")) {
              localObject = ".".concat(String.valueOf(str));
            }
            ab.d("MicroMsg.WebViewUI", "host = %s", new Object[] { localObject });
            if (localPattern.matcher((CharSequence)localObject).matches())
            {
              long l;
              if (this.vfD == null)
              {
                l = System.currentTimeMillis();
                this.vfD = this.igU.ddg();
                if (this.vfD == null) {
                  break label281;
                }
              }
              label281:
              for (bool = true;; bool = false)
              {
                ab.d("MicroMsg.WebViewUI", "[hakon] getConfigListMap %b, cost %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
                if ((this.vfD == null) || (this.vfD.size() <= 0)) {
                  break;
                }
                localObject = com.tencent.mm.m.d.g(this.vfD);
                AppMethodBeat.o(8056);
                return localObject;
              }
            }
          }
          catch (Exception localException)
          {
            ab.d("MicroMsg.WebViewUI", "[hakon] getJDMenuItems, ex = ", new Object[] { localException.getMessage() });
            AppMethodBeat.o(8056);
            return null;
          }
        }
      }
    }
  }
  
  protected final boolean deu()
  {
    AppMethodBeat.i(8057);
    String str1 = getIntent().getStringExtra("srcUsername");
    String str2 = getIntent().getStringExtra("bizofstartfrom");
    if ((str1 != null) && (str2 != null) && ("enterpriseHomeSubBrand".equals(str2)))
    {
      AppMethodBeat.o(8057);
      return true;
    }
    AppMethodBeat.o(8057);
    return false;
  }
  
  protected final int dev()
  {
    AppMethodBeat.i(8063);
    int i = 2130839668;
    if (det() != null) {
      i = 2131231651;
    }
    AppMethodBeat.o(8063);
    return i;
  }
  
  protected void dey()
  {
    AppMethodBeat.i(153268);
    aYt();
    AppMethodBeat.o(153268);
  }
  
  protected boolean dez()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(7988);
    if (this.veC) {
      setResult(-1);
    }
    try
    {
      if (this.igU != null)
      {
        this.igU.Kh(hashCode());
        this.igU.Ki(hashCode());
        this.uWu = null;
      }
      ab.w("MicroMsg.WebViewUI", "invoke onWebViewUIDestroy");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w("MicroMsg.WebViewUI", "onDestroy, remove callback and invoke event on webview destroy, ex = ".concat(String.valueOf(localException)));
      }
    }
    if (this.handler != null) {
      this.handler.removeCallbacksAndMessages(null);
    }
    this.vfL = true;
    super.finish();
    AppMethodBeat.o(7988);
  }
  
  protected final int getActionBarHeight()
  {
    AppMethodBeat.i(7997);
    if (getResources().getDimensionPixelSize(2131427359) > com.tencent.mm.cb.a.fromDPToPix(this, 48))
    {
      i = getResources().getDimensionPixelSize(2131427359);
      AppMethodBeat.o(7997);
      return i;
    }
    if (com.tencent.mm.compatible.util.j.gN(this))
    {
      i = getResources().getDimensionPixelSize(2131427559);
      AppMethodBeat.o(7997);
      return i;
    }
    int i = getResources().getDimensionPixelSize(2131427558);
    AppMethodBeat.o(7997);
    return i;
  }
  
  public int getForceOrientation()
  {
    return this.screenOrientation;
  }
  
  public int getLayoutId()
  {
    return 2130971296;
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(8100);
    super.hideVKB();
    this.khm = -2;
    AppMethodBeat.o(8100);
  }
  
  public void initSwipeBack()
  {
    AppMethodBeat.i(7985);
    super.initSwipeBack();
    if (getSwipeBackLayout() == null)
    {
      AppMethodBeat.o(7985);
      return;
    }
    if (!this.vfu)
    {
      AppMethodBeat.o(7985);
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
      this.vfv = true;
      AppMethodBeat.o(7985);
      return;
      localb.addView(localView1);
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(8031);
    this.veH = getIntent().getBooleanExtra("finishviewifloadfailed", false);
    this.veD = getIntent().getBooleanExtra("is_favorite_item", false);
    this.rNQ = getIntent().getBooleanExtra("isWebwx", true);
    this.veB = getIntent().getBooleanExtra("neverGetA8Key", false);
    this.vft = getIntent().getBooleanExtra("neverBlockLocalRequest", false);
    this.veF = getIntent().getBooleanExtra("KFromLoginHistory", false);
    boolean bool = getIntent().getBooleanExtra("show_feedback", false);
    this.vfr = bo.nullAsNil(getIntent().getStringExtra("sentUsername"));
    if (bool) {
      addTextOptionMenu(1, getString(2131303261), new WebViewUI.8(this));
    }
    this.vee = ((ProgressBar)findViewById(2131824686));
    this.vfq = findViewById(2131823720);
    this.vfq.setOnClickListener(new WebViewUI.9(this));
    Object localObject1;
    Object localObject3;
    label403:
    Object localObject2;
    if (this.rNQ)
    {
      localObject1 = bo.nullAsNil(getIntent().getStringExtra("title"));
      if (((CharSequence)localObject1).length() > 0) {
        this.vec = true;
      }
      setMMTitle((CharSequence)localObject1);
      os(false);
      ot(false);
      if (vfa == WebSettings.RenderPriority.NORMAL)
      {
        ab.i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
        this.pOd.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        vfa = WebSettings.RenderPriority.HIGH;
      }
      localObject3 = this.vgh;
      localObject1 = getContentView();
      ((l)localObject3).vcW = ((LogoWebViewWrapper)((View)localObject1).findViewById(2131823718));
      ((l)localObject3).vcV = ((ImageView)((View)localObject1).findViewById(2131824789));
      ((l)localObject3).vdf = ((View)localObject1).findViewById(2131824788);
      if (((l)localObject3).vdf != null)
      {
        ((l)localObject3).vdg = ((l)localObject3).vdf.findViewById(2131829545);
        ((l)localObject3).vdh = ((TextView)((l)localObject3).vdg.findViewById(2131829546));
      }
      ((l)localObject3).vcX = BackwardSupportUtil.b.b(((l)localObject3).vcW.getContext(), 72.0F);
      if (((l)localObject3).vcV != null) {
        break label1141;
      }
      localObject1 = "null";
      if (((l)localObject3).vcW != null) {
        break label1156;
      }
      localObject2 = "null";
      label415:
      ab.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage.id = %s, logoWrapper.id = %s", new Object[] { localObject1, localObject2 });
      ab.d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", new Object[] { Integer.valueOf(((l)localObject3).vcX) });
      localObject1 = this.vgh;
      localObject2 = this.pOd;
      ((MMWebView)localObject2).setCompetitorView(((l)localObject1).vcW);
      ((MMWebView)localObject2).dOM();
      if (Build.VERSION.SDK_INT <= 10) {
        ((l)localObject1).vcW.getWebViewContainer().setBackgroundColor(((l)localObject1).vcW.getResources().getColor(2131690695));
      }
      localObject3 = ((l)localObject1).vcW;
      ((LogoWebViewWrapper)localObject3).getWebViewContainer();
      if (((LogoWebViewWrapper)localObject3).van != null)
      {
        ((LogoWebViewWrapper)localObject3).egP = ((WebView)localObject2);
        ((LogoWebViewWrapper)localObject3).van.addView(((LogoWebViewWrapper)localObject3).egP);
      }
      if ((!((MMWebView)localObject2).isXWalkKernel()) && (!((MMWebView)localObject2).getIsX5Kernel()) && (!((l)localObject1).noZ)) {
        break label1171;
      }
      ((l)localObject1).vdi = true;
      label578:
      if ((((l)localObject1).vdg != null) && (!((MMWebView)localObject2).getIsX5Kernel()))
      {
        ((ImageView)((l)localObject1).vdg.findViewById(2131829547)).setVisibility(8);
        ((TextView)((l)localObject1).vdg.findViewById(2131829548)).setText("");
      }
      if ((!((l)localObject1).vdi) || (((l)localObject1).vdj)) {
        break label1179;
      }
      ((l)localObject1).op(false);
      ((l)localObject1).deb();
    }
    for (;;)
    {
      ddH();
      this.vej = ((FrameLayout)findViewById(2131823717));
      this.vek = ((FrameLayout)findViewById(2131821084));
      ab.i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.pOd.getIsX5Kernel());
      this.pOd.setWebViewClientExtension(new c(this));
      if (this.pOd.getIsX5Kernel())
      {
        this.pOd.setWebViewCallbackClient(this.vga);
        localObject1 = this.vgh;
        localObject2 = new WebViewUI.10(this);
        if (((l)localObject1).vcW != null) {
          ((l)localObject1).vcW.setMMOverScrollListener((LogoWebViewWrapper.a)localObject2);
        }
      }
      this.veq = ((WebViewInputFooter)findViewById(2131824688));
      if (this.veq != null)
      {
        this.veq.hide();
        this.veq.setOnTextSendListener(new WebViewUI.12(this));
        this.veq.setOnSmileyChosenListener(new WebViewUI.13(this));
        this.veq.setOnSmileyPanelVisibilityChangedListener(new WebViewUI.14(this));
      }
      this.ves = ((WebViewSearchContentInputFooter)findViewById(2131824689));
      if (this.ves != null)
      {
        this.ves.setActionDelegate(new WebViewUI.15(this));
        this.pOd.setFindListener(new WebViewUI.16(this));
      }
      this.vem = ((MovingImageButton)findViewById(2131824690));
      this.veR = findViewById(2131829527);
      if (this.veR != null) {
        this.veR.setVisibility(8);
      }
      this.pOd.setWebChromeClient(aYN());
      this.pOd.setWebViewClient(aYk());
      this.pOd.setDownloadListener(new WebViewUI.17(this));
      this.pOd.requestFocus(130);
      this.pOd.setOnTouchListener(new WebViewUI.18(this));
      localObject1 = com.tencent.mm.pluginsdk.ui.tools.u.bD(this, this.pOd.getSettings().getUserAgentString());
      this.pOd.getSettings().setUserAgentString((String)localObject1);
      this.pOd.dOL();
      this.vfR = new i(this);
      setBackBtn(new WebViewUI.19(this), dep());
      if (deq())
      {
        localObject1 = (WebViewKeyboardLinearLayout)findViewById(2131823716);
        ((WebViewKeyboardLinearLayout)localObject1).setOnkbdStateListener(new WebViewUI.31(this, (WebViewKeyboardLinearLayout)localObject1));
      }
      this.ved = ((MMFalseProgressBar)findViewById(2131823721));
      super.setTitleBarDoubleClickListener(new WebViewUI.20(this));
      AppMethodBeat.o(8031);
      return;
      setMMTitle("");
      break;
      label1141:
      localObject1 = String.valueOf(((l)localObject3).vcV.getId());
      break label403;
      label1156:
      localObject2 = String.valueOf(((l)localObject3).vcW.getId());
      break label415;
      label1171:
      ((l)localObject1).vdi = false;
      break label578;
      label1179:
      ((l)localObject1).op(true);
    }
  }
  
  protected void jT(boolean paramBoolean) {}
  
  protected void l(int paramInt, Bundle paramBundle) {}
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(156882);
    b(paramString, null, false);
    AppMethodBeat.o(156882);
  }
  
  public final void m(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(8074);
    Looper.myQueue().addIdleHandler(new WebViewUI.39(this, paramString, paramLong, paramInt));
    AppMethodBeat.o(8074);
  }
  
  public final void n(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(8075);
    if (at.isConnected(getApplicationContext()))
    {
      if (!at.isWifi(getApplicationContext())) {
        break label101;
      }
      this.networkType = 1;
    }
    String str6;
    for (;;)
    {
      ab.i("MicroMsg.WebViewUI", "get networkType %d", new Object[] { Integer.valueOf(this.networkType) });
      str6 = aiu(this.vgr);
      if (this.fromScene != 0) {
        this.vgq = " ";
      }
      if (this.igV != null) {
        break;
      }
      ab.w("MicroMsg.WebViewUI", "webpageVisitInfoReport wvPerm is null");
      AppMethodBeat.o(8075);
      return;
      label101:
      if (at.is4G(getApplicationContext())) {
        this.networkType = 4;
      } else if (at.is3G(getApplicationContext())) {
        this.networkType = 3;
      } else if (at.is2G(getApplicationContext())) {
        this.networkType = 2;
      }
    }
    localObject1 = this.igV.ddW();
    if (localObject1 != null) {}
    for (boolean bool = ((GeneralControlWrapper)localObject1).dqx();; bool = false)
    {
      ab.d("MicroMsg.WebViewUI", "webpageVisitInfoReport enableReportPageEvent %s", new Object[] { Boolean.valueOf(bool) });
      long l1;
      long l2;
      Object localObject2;
      String str3;
      String str1;
      if ((this.iHl > 0L) && (this.vgs > this.iHl) && (paramLong > this.vgs) && (!TextUtils.isEmpty(str6)) && (bool))
      {
        l1 = this.vgs - this.iHl;
        l2 = paramLong - this.vgs;
        ab.d("MicroMsg.WebViewUI", "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", new Object[] { Integer.valueOf(13376), Long.valueOf(this.iHl), str6, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), this.iyo, this.vgr, this.cpW, Integer.valueOf(paramInt), paramString, Integer.valueOf(this.fromScene), this.vgq });
        localObject2 = "";
        localObject4 = "";
        str3 = "";
        str4 = "";
        str1 = str3;
        localObject1 = localObject4;
      }
      try
      {
        localObject3 = com.tencent.mm.compatible.util.q.encode(bo.nullAsNil(this.iyo), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        localObject4 = com.tencent.mm.compatible.util.q.encode(bo.nullAsNil(this.vgr), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        str3 = com.tencent.mm.compatible.util.q.encode(bo.nullAsNil(paramString), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        String str5 = com.tencent.mm.compatible.util.q.encode(bo.nullAsNil(this.vgq), "UTF-8");
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
          ab.printErrStackTrace("MicroMsg.WebViewUI", localUnsupportedEncodingException, "", new Object[0]);
          String str2 = str4;
          localObject4 = localObject1;
        }
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(13376, new Object[] { Long.valueOf(this.iHl), str6, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), localObject2, localObject4, this.cpW, Integer.valueOf(paramInt), str1, Integer.valueOf(this.fromScene), localObject3 });
      this.fromScene = 0;
      if (paramInt == 1)
      {
        this.vgq = this.vgr;
        this.vgr = paramString;
        this.iHl = paramLong;
      }
      AppMethodBeat.o(8075);
      return;
    }
  }
  
  public boolean needShowIdcError()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(8036);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.ihd.b(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(8036);
      return;
    }
    if (com.tencent.mm.plugin.webview.modeltools.a.d(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(8036);
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
        ab.i("MicroMsg.WebViewUI", "gdpr continue:true");
        AppMethodBeat.o(8036);
        return;
      }
      ab.i("MicroMsg.WebViewUI", "gdpr continue:false");
      paramIntent = new Intent();
      localBundle = new Bundle();
      localBundle.putString("go_next", "gdpr_confirm_logout");
      paramIntent.putExtra("result_data", localBundle);
      this.vfK = true;
      m.vdm.close();
      setResult(-1, paramIntent);
      finish();
    }
    AppMethodBeat.o(8036);
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(8038);
    if (this.pOd != null)
    {
      if (!this.vgi) {
        break label42;
      }
      this.pOd.setOnLongClickListener(this.vgj);
    }
    for (;;)
    {
      super.onCancel();
      AppMethodBeat.o(8038);
      return;
      label42:
      this.pOd.setOnLongClickListener(null);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(8012);
    super.onConfigurationChanged(paramConfiguration);
    if (this.jZj != paramConfiguration.orientation)
    {
      View localView = dem();
      if (localView == null) {}
      for (localView = null; localView == null; localView = (View)localView.getParent())
      {
        AppMethodBeat.o(8012);
        return;
      }
      localView.dispatchConfigurationChanged(paramConfiguration);
      localView.requestLayout();
      this.jZj = paramConfiguration.orientation;
    }
    AppMethodBeat.o(8012);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7996);
    aYO();
    super.onCreate(paramBundle);
    aYm();
    AppMethodBeat.o(7996);
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(7995);
    supportRequestWindowFeature(5);
    supportRequestWindowFeature(9);
    setProgressBarIndeterminateVisibility(false);
    AppMethodBeat.o(7995);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(8017);
    ab.i("MicroMsg.WebViewUI", "onDestroy " + hashCode());
    super.onDestroy();
    com.tencent.mm.plugin.webview.modeltools.c.dcv();
    Object localObject = dek();
    if (localObject != null)
    {
      String str = getSharedPreferences("webview_url_prefs", 4).getString("url", null);
      if ((str != null) && (((String)localObject).equals(str)))
      {
        localObject = getSharedPreferences("webview_url_prefs", 4).edit();
        ((SharedPreferences.Editor)localObject).remove("url");
        ((SharedPreferences.Editor)localObject).apply();
      }
    }
    for (;;)
    {
      this.uRy.dff();
      if (!this.vfL) {}
      try
      {
        if (this.igU != null)
        {
          this.igU.Kh(hashCode());
          this.igU.Ki(hashCode());
        }
        ab.w("MicroMsg.WebViewUI", "invoke onWebViewUIDestroy");
        label175:
        if (this.vep != null) {
          this.vep.disable();
        }
        this.vfK = true;
        vfJ -= 1;
        int j = hashCode();
        i = veU.size() - 1;
        label216:
        if (i >= 0)
        {
          if (((WebViewUI.z)veU.get(i)).id == j) {
            veU.remove(i);
          }
        }
        else
        {
          m("", bo.aox(), 0);
          localObject = this.uVh.dco();
          ((as.i)localObject).uWQ = new Object[] { this.cJr, Integer.valueOf(2) };
          ((as.i)localObject).b(this.igU);
          this.uVh.b(this.igU);
          localObject = this.uVh;
          ((as)localObject).uWy = null;
          ((as)localObject).uWw = null;
          ((as)localObject).uWx = null;
          ((as)localObject).uWv = null;
          ((as)localObject).uWA = null;
          ((as)localObject).uWB = null;
          ((as)localObject).uWC = null;
          ((as)localObject).uWD = null;
          if (((as)localObject).uWI != null)
          {
            ((as)localObject).uWI.mEJ = null;
            ((as)localObject).uWI = null;
          }
          JR("onDestroy");
          this.vfk.clear();
          localObject = this.vfP;
          if ((((com.tencent.mm.plugin.webview.model.b)localObject).uVg != null) && (((com.tencent.mm.plugin.webview.model.b)localObject).uVg.oNc.getLooper() != null)) {
            ((com.tencent.mm.plugin.webview.model.b)localObject).uVg.oNc.getLooper().quit();
          }
          ((com.tencent.mm.plugin.webview.model.b)localObject).uVg = null;
          localObject = this.vfZ;
          ((com.tencent.mm.plugin.webview.model.ap)localObject).uWp.clear();
          ((com.tencent.mm.plugin.webview.model.ap)localObject).uWq.clear();
          ((com.tencent.mm.plugin.webview.model.ap)localObject).uWr.clear();
          ((com.tencent.mm.plugin.webview.model.ap)localObject).uWn.clear();
          ((com.tencent.mm.plugin.webview.model.ap)localObject).uWo.clear();
          if (this.vgw != null)
          {
            this.vgw.dismiss();
            this.vgw = null;
          }
          if (this.vgt != null)
          {
            this.vgt.dismiss();
            this.vgt = null;
          }
          if (this.vef != null)
          {
            this.vef.dismiss();
            this.vef = null;
          }
          if (this.vfp != null)
          {
            this.vfp.dismiss();
            this.vfp = null;
          }
          if (this.veq != null) {
            this.veq.setOnTextSendListener(null);
          }
          if (this.vfc.deS()) {
            Kz(233);
          }
          if (this.vfd.deS()) {
            Kz(673);
          }
          if (this.vfe.deS()) {
            Kz(666);
          }
          this.vfl.clear();
          this.vfS.onDestroy();
          this.vgb.dead();
          this.vff.dead();
          if (com.tencent.xweb.c.jQ(com.tencent.mm.sdk.platformtools.ah.getContext()) != null)
          {
            ab.i("MicroMsg.WebViewUI", "now force sync the cookie between ram and db");
            com.tencent.xweb.c.sync();
          }
          if (!deu()) {}
        }
      }
      catch (Exception localThrowable)
      {
        try
        {
          int i;
          if (this.igU != null)
          {
            localObject = new Bundle();
            ((Bundle)localObject).putString("srcUsername", getIntent().getStringExtra("srcUsername"));
            this.igU.a(30, (Bundle)localObject, hashCode());
          }
          label748:
          ab.v("MicroMsg.WebViewUI", "on destroy isNeedCallbackMMRpt[%b]", new Object[] { Boolean.valueOf(this.vey) });
          if (this.vey) {}
          try
          {
            localObject = getIntent().getBundleExtra("mm_report_bundle");
            if (!bo.isNullOrNil(((Bundle)localObject).getString("mm_event_class"))) {
              if (this.igU != null)
              {
                ((Bundle)localObject).putLong("key_activity_browse_time", getActivityBrowseTimeMs());
                this.igU.i(250, (Bundle)localObject);
              }
            }
          }
          catch (Exception localThrowable)
          {
            try
            {
              if (this.igU != null)
              {
                localObject = new Bundle();
                ((Bundle)localObject).putLong("key_activity_browse_time", getActivityBrowseTimeMs());
                this.igU.i(251, (Bundle)localObject);
              }
            }
            catch (Exception localThrowable)
            {
              try
              {
                if (this.igU != null)
                {
                  localObject = this.igU.i(19, null);
                  if (localObject != null)
                  {
                    bool = ((Bundle)localObject).getBoolean("webview_video_proxy_init");
                    ab.i("MicroMsg.WebViewUI", "onDestroy, has init = %b, webviewHoldingCounter = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(vfJ) });
                    if ((bool) && (vfJ <= 0))
                    {
                      FactoryProxyManager.getPlayManager().deinit();
                      this.igU.i(75, null);
                    }
                  }
                }
                if (this.kDI == null) {}
              }
              catch (Exception localThrowable)
              {
                try
                {
                  unbindService(this.kDI);
                  bool = com.tencent.mm.plugin.webview.modeltools.k.a(this.uQS, this.pOd);
                  if (this.uQS != null) {
                    this.uQS.detach();
                  }
                  this.veT.clear();
                  if (this.uRx != null)
                  {
                    localObject = this.uRx;
                    ab.i("MicroMsg.WebView.MMSslErrorHandler", "detach");
                    ((d)localObject).context = null;
                    ((d)localObject).vaK = null;
                    ((d)localObject).vaL.clear();
                    ((d)localObject).vaM.clear();
                  }
                  if (this.vfi != null) {
                    this.vfi.detach();
                  }
                  this.pOd.removeJavascriptInterface("MicroMsg");
                  this.pOd.removeJavascriptInterface("JsApi");
                  this.pOd.removeJavascriptInterface("__wx");
                }
                catch (Exception localThrowable)
                {
                  try
                  {
                    this.pOd.setWebChromeClient(null);
                    this.pOd.setWebViewClient(null);
                    this.pOd.setOnTouchListener(null);
                    this.pOd.setOnLongClickListener(null);
                    this.pOd.setVisibility(8);
                    this.pOd.removeAllViews();
                    this.pOd.clearView();
                    this.vfQ.dcO();
                    if (this.igV != null)
                    {
                      localObject = this.igV;
                      ab.i("MicroMsg.WebViewPermission", "detach");
                      ((k)localObject).uUM.clear();
                      ((k)localObject).uUM = null;
                      this.igV = null;
                    }
                  }
                  catch (Exception localThrowable)
                  {
                    try
                    {
                      boolean bool;
                      this.vgh.release();
                      if (bool) {}
                    }
                    catch (Exception localThrowable)
                    {
                      try
                      {
                        this.pOd.destroy();
                      }
                      catch (Exception localThrowable)
                      {
                        try
                        {
                          if ((getContentView() instanceof ViewGroup)) {
                            ((ViewGroup)getContentView()).removeAllViews();
                          }
                          localObject = this.vfU;
                        }
                        catch (Throwable localThrowable)
                        {
                          try
                          {
                            for (;;)
                            {
                              ((WebViewClipBoardHelper)localObject).uYo.removePrimaryClipChangedListener((ClipboardManager.OnPrimaryClipChangedListener)localObject);
                              ((WebViewClipBoardHelper)localObject).uYo = null;
                              label1289:
                              localObject = this.vfV;
                              if ((((com.tencent.mm.plugin.webview.b)localObject).tipDialog != null) && (((com.tencent.mm.plugin.webview.b)localObject).tipDialog.isShowing()))
                              {
                                ((com.tencent.mm.plugin.webview.b)localObject).tipDialog.dismiss();
                                ((com.tencent.mm.plugin.webview.b)localObject).tipDialog = null;
                              }
                              com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.webview.b)localObject).uNO);
                              this.pOd = null;
                              if (this.vfT != null)
                              {
                                this.vfT = null;
                                FactoryProxyManager.getPlayManager().setUtilsObject(null);
                              }
                              System.gc();
                              if (this.vej != null)
                              {
                                this.vej.removeAllViews();
                                this.vej = null;
                              }
                              AppMethodBeat.o(8017);
                              return;
                              ab.w("MicroMsg.WebViewUI", "currentURL == null, qbrowser.url may be not accurate");
                              break;
                              localException1 = localException1;
                              ab.w("MicroMsg.WebViewUI", "onDestroy, remove callback and invoke event on webview destroy, ex = ".concat(String.valueOf(localException1)));
                              break label175;
                              i -= 1;
                              break label216;
                              ab.w("MicroMsg.WebViewUI", "webview on destroy callback mm but eventclass is null");
                              continue;
                              localException2 = localException2;
                              ab.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", new Object[] { localException2.toString() });
                              continue;
                              localException3 = localException3;
                              ab.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", new Object[] { localException3.toString() });
                              continue;
                              localException4 = localException4;
                              ab.e("MicroMsg.WebViewUI", "deinit video player failed : %s", new Object[] { localException4.getMessage() });
                              continue;
                              localException5 = localException5;
                              ab.printErrStackTrace("MicroMsg.WebViewUI", localException5, "unbindService", new Object[0]);
                              continue;
                              localException6 = localException6;
                              ab.e("MicroMsg.WebViewUI", "onDestroy, set web infos to null,  ex = %s", new Object[] { localException6.getMessage() });
                              continue;
                              localException7 = localException7;
                              ab.e("MicroMsg.WebViewUI", "onDestroy, remove view,  ex = " + localException7.getMessage());
                              continue;
                              localException8 = localException8;
                              ab.w("MicroMsg.WebViewUI", "onDestroy, viewWV destroy, ex = %s", new Object[] { localException8.getMessage() });
                            }
                            localThrowable = localThrowable;
                            ab.w("MicroMsg.WebViewUI", "onDestroy contentView removeAllViews %s", new Object[] { localThrowable });
                          }
                          catch (Exception localException9)
                          {
                            break label1289;
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
        catch (Exception localException10)
        {
          break label748;
        }
      }
    }
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(8039);
    if (this.pOd != null) {
      this.pOd.setOnLongClickListener(new WebViewUI.22(this));
    }
    super.onDrag();
    AppMethodBeat.o(8039);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(8020);
    ab.i("MicroMsg.WebViewUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.pOd != null) && (this.pOd.hasEnteredFullscreen()))
    {
      this.pOd.leaveFullscreen();
      AppMethodBeat.o(8020);
      return true;
    }
    if ((paramInt == 4) && (this.veX != null) && (this.veW != null) && (this.veY != null)) {
      try
      {
        this.veY.onHideCustomView();
        paramKeyEvent = this.uVh.dco();
        paramKeyEvent.uWQ = new Object[] { this.cJr, Integer.valueOf(1) };
        paramKeyEvent.b(this.igU);
        AppMethodBeat.o(8020);
        return true;
      }
      catch (Exception paramKeyEvent)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.WebViewUI", paramKeyEvent, "onkeydown", new Object[0]);
        }
      }
    }
    if (paramInt == 4)
    {
      if ((this.veq != null) && (this.veq.isShown()))
      {
        this.veq.hide();
        dew();
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(8020);
        return true;
      }
    }
    if (paramInt == 4)
    {
      if ((this.pOd != null) && (this.pOd.canGoBack()) && (this.vew))
      {
        aZy();
        paramKeyEvent = this.uVh.dco();
        paramKeyEvent.uWQ = new Object[] { this.cJr, Integer.valueOf(1) };
        paramKeyEvent.b(this.igU);
        AppMethodBeat.o(8020);
        return true;
      }
      m.vdm.close();
    }
    if ((paramInt == 4) && (deD()) && (daU()))
    {
      AppMethodBeat.o(8020);
      return true;
    }
    if ((paramInt == 4) && (this.uRy.KE(22)))
    {
      AppMethodBeat.o(8020);
      return true;
    }
    if (paramInt == 4) {
      deF();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(8020);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(8019);
    if ((paramInt == 82) && (!this.vgg))
    {
      AppMethodBeat.o(8019);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(8019);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(7987);
    super.onPause();
    com.tencent.mm.modelstat.d.b(4, "WebViewUI_" + aio(bo.nullAsNil(this.vfr)), hashCode());
    com.tencent.mm.modelstat.d.o("WebViewUI_" + aio(bo.nullAsNil(this.vfr)), this.otr, bo.aox());
    Object localObject = this.uVh.dck();
    if (((as.l)localObject).lastResumeTime != -1L) {
      ((as.l)localObject).iHh += bo.av(((as.l)localObject).lastResumeTime) / 1000L;
    }
    localObject = this.uVh.dcl();
    if (((as.a)localObject).lastResumeTime != -1L) {
      ((as.a)localObject).iHh += bo.av(((as.a)localObject).lastResumeTime);
    }
    localObject = m.vdm;
    ab.v("MicroMsg.WebViewReportUtil", "onPause traceid %s", new Object[] { ((m)localObject).rpu });
    if (((m)localObject).fon) {
      ab.i("MicroMsg.WebViewReportUtil", "isFinish is true");
    }
    for (;;)
    {
      try
      {
        if (this.igU != null)
        {
          localObject = this.igU.i(19, null);
          if (localObject != null)
          {
            boolean bool = ((Bundle)localObject).getBoolean("webview_video_proxy_init");
            ab.i("MicroMsg.WebViewUI", "onPause, has init = %b", new Object[] { Boolean.valueOf(bool) });
            if (bool) {
              FactoryProxyManager.getPlayManager().appToBack();
            }
          }
        }
      }
      catch (Exception localException1)
      {
        ab.e("MicroMsg.WebViewUI", "notify app toback failed : %s", new Object[] { localException1.getMessage() });
        continue;
        AppMethodBeat.o(7987);
      }
      dew();
      JR("onPause");
      if (this.veY == null) {
        continue;
      }
      ab.i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
      try
      {
        this.veY.onHideCustomView();
        AppMethodBeat.o(7987);
        return;
      }
      catch (Exception localException2)
      {
        ab.printErrStackTrace("MicroMsg.WebViewUI", localException2, "onPause", new Object[0]);
      }
      if (!bo.isNullOrNil(((m)localObject).rpu)) {
        ((m)localObject).kS(6);
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(7994);
    paramArrayOfString = this.ihd;
    if (paramArrayOfString.uXw == null)
    {
      paramArrayOfString.dcw();
      paramInt = i;
      if (paramInt != 0) {
        AppMethodBeat.o(7994);
      }
    }
    else
    {
      if (119 == paramInt)
      {
        if (paramArrayOfInt[0] != 0) {
          break label92;
        }
        paramArrayOfInt = (Intent)paramArrayOfString.uXw.first;
        paramInt = ((Integer)paramArrayOfString.uXw.second).intValue();
        paramArrayOfString.uXw = null;
        startActivityForResult(paramArrayOfInt, paramInt);
      }
      for (;;)
      {
        paramInt = 1;
        break;
        label92:
        paramArrayOfString.uXw = null;
        paramArrayOfString.b(this, 0, null);
      }
    }
    AppMethodBeat.o(7994);
  }
  
  protected void onReset()
  {
    AppMethodBeat.i(153264);
    this.uQS.detach();
    this.uQS = null;
    ((ViewGroup)this.pOd.getParent()).removeView(this.pOd);
    this.pOd.stopLoading();
    this.pOd.removeAllViews();
    this.pOd.clearView();
    this.pOd.destroy();
    this.pOd = null;
    this.veY = null;
    this.uRy.dff();
    ((ViewGroup)this.vei.getParent()).removeView(this.vei);
    aYO();
    aYm();
    aMf();
    AppMethodBeat.o(153264);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(7986);
    super.onResume();
    if (dek() != null) {
      com.tencent.mm.plugin.webview.f.e.i(dek(), this);
    }
    for (;;)
    {
      this.uVh.dck().lastResumeTime = bo.yB();
      this.uVh.dcl().lastResumeTime = bo.yB();
      Object localObject = m.vdm;
      ab.v("MicroMsg.WebViewReportUtil", "onResume traceid %s", new Object[] { ((m)localObject).rpu });
      if (!bo.isNullOrNil(((m)localObject).rpu)) {
        ((m)localObject).kS(7);
      }
      int i;
      if (!this.vgc)
      {
        int j = hashCode();
        i = veU.size() - 1;
        if (i >= 0)
        {
          if (((WebViewUI.z)veU.get(i)).id == j) {
            veU.remove(i);
          }
        }
        else {
          veU.add(new WebViewUI.z(this));
        }
      }
      else
      {
        this.vgc = false;
        if (this.veV)
        {
          oq(true);
          this.veV = false;
        }
        deo();
        if (this.igU == null) {}
      }
      try
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("screen_orientation", this.screenOrientation);
        this.igU.i(83, (Bundle)localObject);
        if ((getIntent().getBooleanExtra("disable_swipe_back", false)) && (getSwipeBackLayout() != null)) {
          getSwipeBackLayout().setEnableGesture(false);
        }
        JR("onResume");
        try
        {
          if (this.igU != null)
          {
            localObject = this.igU.i(19, null);
            if (localObject != null)
            {
              boolean bool = ((Bundle)localObject).getBoolean("webview_video_proxy_init");
              ab.i("MicroMsg.WebViewUI", "onResume, has init = %b", new Object[] { Boolean.valueOf(bool) });
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
            ab.e("MicroMsg.WebViewUI", "notify app tofront failed : %s", new Object[] { localException2.getMessage() });
          }
        }
        this.otr = bo.aox();
        this.vfP.aNS().ac(new WebViewUI.43(this));
        if (this.vfN) {
          finish();
        }
        AppMethodBeat.o(7986);
        return;
        com.tencent.mm.plugin.webview.f.e.i(daZ(), this);
        continue;
        i -= 1;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          ab.e("MicroMsg.WebViewUI", "ac_set_screen_orientation : " + localException1.getMessage());
        }
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(8013);
    super.onStart();
    ab.i("MicroMsg.WebViewUI", "edw onStart");
    AppMethodBeat.o(8013);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(8014);
    ab.i("MicroMsg.WebViewUI", "edw onStop");
    Y(true, true);
    super.onStop();
    AppMethodBeat.o(8014);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(8037);
    if (this.pOd != null)
    {
      if (!this.vgi) {
        break label46;
      }
      this.pOd.setOnLongClickListener(this.vgj);
    }
    for (;;)
    {
      hideVKB();
      super.onSwipeBack();
      AppMethodBeat.o(8037);
      return;
      label46:
      this.pOd.setOnLongClickListener(null);
    }
  }
  
  public boolean onSwipeBackFinish()
  {
    AppMethodBeat.i(8040);
    this.vfM = true;
    as.i locali = this.uVh.dco();
    if (this.pOd != null) {}
    for (String str = this.pOd.getUrl();; str = this.cJr)
    {
      locali.uWQ = new Object[] { str, Integer.valueOf(15) };
      locali.b(this.igU);
      boolean bool = super.onSwipeBackFinish();
      AppMethodBeat.o(8040);
      return bool;
    }
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(8008);
    ab.v("MicroMsg.WebViewUI", "l=%d t=%d oldl=%d oldt=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if ((this.vfY != null) && (!this.vfY.vhd)) {
      this.vfY.deX();
    }
    AppMethodBeat.o(8008);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(8030);
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.ven)) {
      aj(getWindow().getDecorView(), 5894);
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(8030);
  }
  
  protected void or(boolean paramBoolean)
  {
    AppMethodBeat.i(8059);
    this.vgg = paramBoolean;
    if (this.pOd == null)
    {
      ab.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
      AppMethodBeat.o(8059);
      return;
    }
    enableOptionMenu(paramBoolean);
    showOptionMenu(paramBoolean);
    boolean bool1 = getIntent().getBooleanExtra("show_feedback", false);
    if (bool1) {
      showOptionMenu(bool1);
    }
    int i = dev();
    if (det() != null) {
      i = 2131231651;
    }
    bool1 = getIntent().getBooleanExtra("KRightBtn", false);
    boolean bool2 = getIntent().getBooleanExtra("KShowFixToolsBtn", false);
    ab.i("MicroMsg.WebViewUI", "banRightBtn:%b, showFixToolsBtn:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (!bool1)
    {
      if (bool2) {
        addIconOptionMenu(1, 2131231338, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(153241);
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.setClassName(WebViewUI.this, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
            paramAnonymousMenuItem.putExtra("entry_fix_tools", 1);
            WebViewUI.this.startActivity(paramAnonymousMenuItem);
            AppMethodBeat.o(153241);
            return true;
          }
        });
      }
      addIconOptionMenu(0, i, new WebViewUI.30(this), this.vgm);
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ou(paramBoolean);
      AppMethodBeat.o(8059);
      return;
    }
  }
  
  protected final void os(boolean paramBoolean)
  {
    AppMethodBeat.i(8068);
    if (findViewById(2131823722) == null)
    {
      AppMethodBeat.o(8068);
      return;
    }
    boolean bool;
    if (findViewById(2131823722).getVisibility() == 0)
    {
      bool = true;
      if (bool != paramBoolean)
      {
        localObject = getContext();
        if (!paramBoolean) {
          break label105;
        }
      }
    }
    label105:
    for (int i = 2131034125;; i = 2131034126)
    {
      localObject = AnimationUtils.loadAnimation((Context)localObject, i);
      findViewById(2131823722).startAnimation((Animation)localObject);
      if (paramBoolean) {
        break label112;
      }
      findViewById(2131823722).setVisibility(8);
      AppMethodBeat.o(8068);
      return;
      bool = false;
      break;
    }
    label112:
    findViewById(2131823722).setVisibility(0);
    this.veg = ((ImageButton)findViewById(2131823723));
    Object localObject = this.veg;
    if ((this.pOd != null) && (this.pOd.canGoBack())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((ImageButton)localObject).setEnabled(paramBoolean);
      this.veg.setOnClickListener(new WebViewUI.37(this));
      this.veh = ((ImageButton)findViewById(2131823724));
      this.veh.setOnClickListener(new WebViewUI.38(this));
      AppMethodBeat.o(8068);
      return;
    }
  }
  
  public final void ou(boolean paramBoolean)
  {
    AppMethodBeat.i(8098);
    String str = this.pOd.getUrl();
    if (paramBoolean)
    {
      showOptionMenu(0, false);
      this.vfn.put(str, Boolean.TRUE);
      AppMethodBeat.o(8098);
      return;
    }
    showOptionMenu(0, true);
    if (this.vfn.containsKey(str)) {
      this.vfn.remove(str);
    }
    AppMethodBeat.o(8098);
  }
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(7984);
    super.setActionbarColor(paramInt);
    if (this.vfu) {
      setStatusBarColor(paramInt);
    }
    AppMethodBeat.o(7984);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    AppMethodBeat.i(8102);
    super.setBackBtn(paramOnMenuItemClickListener, paramInt);
    if ((com.tencent.mm.compatible.util.d.fv(21)) && (dei())) {
      setBackBtnColorFilter(-16777216);
    }
    AppMethodBeat.o(8102);
  }
  
  public void setMMOrientation()
  {
    AppMethodBeat.i(8010);
    if (Build.VERSION.SDK_INT > 10)
    {
      if (getForceOrientation() == -1)
      {
        this.landscapeMode = getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP(), 4).getBoolean("settings_landscape_mode", false);
        if (this.landscapeMode)
        {
          setRequestedOrientation(-1);
          AppMethodBeat.o(8010);
          return;
        }
        setRequestedOrientation(1);
        AppMethodBeat.o(8010);
        return;
      }
      setRequestedOrientation(getForceOrientation());
      AppMethodBeat.o(8010);
      return;
    }
    super.setMMOrientation();
    AppMethodBeat.o(8010);
  }
  
  public void setMMTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(7991);
    super.setMMTitle(paramCharSequence);
    AppMethodBeat.o(7991);
  }
  
  public void setMMTitle(String paramString)
  {
    AppMethodBeat.i(7990);
    super.setMMTitle(paramString);
    AppMethodBeat.o(7990);
  }
  
  @TargetApi(21)
  public final void setStatusBarColor(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(8005);
    Object localObject;
    if (this.vfu)
    {
      localObject = getContentView();
      if (!aj.Ow(paramInt)) {
        bool = true;
      }
      com.tencent.mm.ui.statusbar.a.d((View)localObject, paramInt, bool);
      AppMethodBeat.o(8005);
      return;
    }
    if ((this.iPy <= 0) || (com.tencent.mm.compatible.util.d.fw(21)))
    {
      AppMethodBeat.o(8005);
      return;
    }
    getWindow().setStatusBarColor(0);
    if (this.vge == null)
    {
      this.vge = new View(this);
      localObject = new ViewGroup.LayoutParams(-1, this.iPy);
      ((ViewGroup)findViewById(16908290)).addView(this.vge, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.vge.setBackgroundColor(paramInt);
      AppMethodBeat.o(8005);
      return;
      localObject = this.vge.getLayoutParams();
      if (((ViewGroup.LayoutParams)localObject).height != this.iPy)
      {
        ((ViewGroup.LayoutParams)localObject).height = this.iPy;
        this.vge.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void showOptionMenu(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(8061);
    if (getIntent().getBooleanExtra("hide_option_menu", false))
    {
      super.showOptionMenu(paramInt, false);
      AppMethodBeat.o(8061);
      return;
    }
    super.showOptionMenu(paramInt, paramBoolean);
    AppMethodBeat.o(8061);
  }
  
  public void showOptionMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(8060);
    if (getIntent().getBooleanExtra("hide_option_menu", false))
    {
      super.showOptionMenu(false);
      AppMethodBeat.o(8060);
      return;
    }
    super.showOptionMenu(paramBoolean);
    AppMethodBeat.o(8060);
  }
  
  public void showVKB()
  {
    AppMethodBeat.i(8101);
    super.showVKB();
    if (this.khm == -3)
    {
      this.khm = -2;
      AppMethodBeat.o(8101);
      return;
    }
    this.khm = -3;
    AppMethodBeat.o(8101);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(8105);
    if (bo.isEqual(paramIntent.getType(), "application/vnd.android.package-archive"))
    {
      com.tencent.mm.pluginsdk.model.app.q.a(com.tencent.mm.sdk.platformtools.ah.getContext(), paramIntent.getData(), null);
      AppMethodBeat.o(8105);
      return;
    }
    super.startActivity(paramIntent);
    AppMethodBeat.o(8105);
  }
  
  protected void w(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(8097);
    ab.i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
    AppMethodBeat.o(8097);
  }
  
  final class f
    implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b
  {
    private f() {}
    
    public final boolean ait(String paramString)
    {
      boolean bool = true;
      AppMethodBeat.i(7900);
      int i = WebViewUI.this.aio(bo.nullAsNil(WebViewUI.this.vfr));
      if (com.tencent.mm.pluginsdk.e.aW(paramString, WebViewUI.T(WebViewUI.this))) {}
      for (;;)
      {
        try
        {
          Object localObject;
          if ("weixin://dl/shopping".equals(paramString))
          {
            localObject = WebViewUI.this.igU.ddf();
            if (!bo.isNullOrNil((String)localObject)) {
              WebViewUI.this.loadUrl((String)localObject);
            }
            localObject = new ArrayList();
            ((List)localObject).add(paramString);
            ((List)localObject).add("1");
            ((List)localObject).add(String.valueOf(i));
            ((List)localObject).add(bo.nullAsNil(WebViewUI.this.vfr));
            ((List)localObject).add(bo.nullAsNil(WebViewUI.this.cJr));
            WebViewUI.this.igU.k(11405, (List)localObject);
            AppMethodBeat.o(7900);
            return bool;
          }
          if ("weixin://dl/faq".equals(paramString))
          {
            int j = WebViewUI.this.igU.ddh();
            int k = WebViewUI.this.igU.ddi();
            localObject = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131303468, new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
            WebViewUI.this.loadUrl((String)localObject);
            continue;
          }
        }
        catch (Exception paramString)
        {
          ab.e("MicroMsg.WebViewUI", "kv report fail, ex = %s", new Object[] { paramString.getMessage() });
          continue;
          if ("weixin://dl/posts".equals(paramString))
          {
            WebViewUI.this.igU.ddj();
            continue;
          }
          if ("weixin://dl/moments".equals(paramString))
          {
            WebViewUI.this.igU.ddk();
            continue;
          }
          if (paramString.startsWith("weixin://dl/feedback"))
          {
            WebViewUI.this.igU.ahX(paramString);
            continue;
          }
          if ("weixin://dl/scan".equals(paramString))
          {
            com.tencent.mm.bq.d.c(WebViewUI.this, "scanner", ".ui.SingleTopScanUI", new Intent());
            continue;
          }
          com.tencent.mm.pluginsdk.e.akZ(paramString);
          continue;
        }
        bool = false;
      }
    }
    
    public final boolean aiz(String paramString)
    {
      AppMethodBeat.i(7899);
      if (bo.isNullOrNil(paramString))
      {
        AppMethodBeat.o(7899);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.u.x(paramString, "weixin://");
      AppMethodBeat.o(7899);
      return bool;
    }
  }
  
  public class g
    extends com.tencent.xweb.p
  {
    private Dialog dialog;
    public volatile boolean ezJ;
    private final List<String> vgK;
    
    protected g()
    {
      AppMethodBeat.i(7912);
      this.ezJ = false;
      this.vgK = new LinkedList();
      this.dialog = null;
      AppMethodBeat.o(7912);
    }
    
    public void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(7913);
      if (paramInt < 100)
      {
        WebViewUI.b(WebViewUI.this, false);
        AppMethodBeat.o(7913);
        return;
      }
      if (paramInt >= 100) {
        WebViewUI.b(WebViewUI.this, true);
      }
      AppMethodBeat.o(7913);
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, p.a parama)
    {
      AppMethodBeat.i(7920);
      if ((parama.getMode() == 0) || (parama.getMode() == 1))
      {
        if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
        {
          ab.i("MicroMsg.WebViewUI", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
          AppMethodBeat.o(7920);
          return true;
        }
        String str2 = parama.getAcceptTypes()[0];
        String str1 = "*";
        paramWebView = str1;
        if (parama.isCaptureEnabled())
        {
          if (!"image/*".equalsIgnoreCase(str2)) {
            break label120;
          }
          paramWebView = "camera";
        }
        for (;;)
        {
          WebViewUI.t(WebViewUI.this).a(WebViewUI.this, WebViewUI.this.igV, null, paramValueCallback, str2, paramWebView);
          AppMethodBeat.o(7920);
          return true;
          label120:
          paramWebView = str1;
          if ("video/*".equalsIgnoreCase(str2)) {
            paramWebView = "camcorder";
          }
        }
      }
      AppMethodBeat.o(7920);
      return false;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, final com.tencent.xweb.j paramj)
    {
      AppMethodBeat.i(7923);
      ab.d("MicroMsg.WebViewUI", "onJsAlert");
      final PBool localPBool = new PBool();
      localPBool.value = false;
      if ((WebViewUI.this.isFinishing()) || (WebViewUI.this.activityHasDestroyed()))
      {
        ab.d("MicroMsg.WebViewUI", "onJsAlert finish");
        paramj.cancel();
        AppMethodBeat.o(7923);
        return true;
      }
      WebViewUI.u(WebViewUI.this);
      if (WebViewUI.v(WebViewUI.this) > 2) {}
      for (com.tencent.mm.ui.widget.b.c localc = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131306013), WebViewUI.this.getString(2131297018), new WebViewUI.g.10(this, paramString1, paramj), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(7911);
              localPBool.value = true;
              paramj.confirm();
              AppMethodBeat.o(7911);
            }
          }, 2131690214); localc != null; localc = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131297018), new WebViewUI.g.2(this, localPBool, paramj)))
      {
        localc.setOnDismissListener(new WebViewUI.g.3(this, localPBool, paramj));
        localc.setCanceledOnTouchOutside(false);
        localc.rD(false);
        AppMethodBeat.o(7923);
        return true;
      }
      boolean bool = super.a(paramWebView, paramString1, paramString2, paramj);
      AppMethodBeat.o(7923);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, com.tencent.xweb.i parami)
    {
      AppMethodBeat.i(7922);
      boolean bool = super.a(paramWebView, paramString1, paramString2, paramString3, parami);
      AppMethodBeat.o(7922);
      return bool;
    }
    
    public final boolean b(WebView paramWebView, String paramString1, String paramString2, com.tencent.xweb.j paramj)
    {
      AppMethodBeat.i(7921);
      ab.d("MicroMsg.WebViewUI", "onJsConfirm");
      PBool localPBool = new PBool();
      localPBool.value = false;
      if ((WebViewUI.this.isFinishing()) || (WebViewUI.this.activityHasDestroyed()))
      {
        ab.d("MicroMsg.WebViewUI", "onJsConfirm finish");
        paramj.cancel();
        AppMethodBeat.o(7921);
        return true;
      }
      WebViewUI.u(WebViewUI.this);
      if (WebViewUI.v(WebViewUI.this) > 2) {}
      for (this.dialog = com.tencent.mm.ui.base.h.a(WebViewUI.this, paramString2, "", WebViewUI.this.getString(2131306013), WebViewUI.this.getString(2131297018), new WebViewUI.g.5(this, paramString1, paramj), new WebViewUI.g.6(this, localPBool, paramj), 2131689794); this.dialog != null; this.dialog = com.tencent.mm.ui.base.h.a(WebViewUI.this.getContext(), false, paramString2, "", WebViewUI.this.getString(2131297018), WebViewUI.this.getString(2131296888), new WebViewUI.g.7(this, localPBool, paramj), new WebViewUI.g.8(this, paramj)))
      {
        this.dialog.setOnDismissListener(new WebViewUI.g.9(this, localPBool, paramj));
        this.dialog.setCancelable(false);
        this.dialog.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(7921);
        return true;
      }
      boolean bool = super.b(paramWebView, paramString1, paramString2, paramj);
      AppMethodBeat.o(7921);
      return bool;
    }
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(7914);
      ab.i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", new Object[] { paramString, WebViewUI.this.vgp });
      super.d(paramWebView, paramString);
      if (WebViewUI.this.vec)
      {
        ab.i("MicroMsg.WebViewUI", "fixed title, ignore received title: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(7914);
        return;
      }
      if (paramString == null)
      {
        ab.e("MicroMsg.WebViewUI", "null title");
        AppMethodBeat.o(7914);
        return;
      }
      if (!WebViewUI.this.rNQ)
      {
        AppMethodBeat.o(7914);
        return;
      }
      if ((!bo.nullAsNil(WebViewUI.this.vgp).equals(paramString)) && (!com.tencent.mm.plugin.webview.luggage.c.b.Fl(paramString))) {
        WebViewUI.this.setMMTitle(paramString);
      }
      AppMethodBeat.o(7914);
    }
    
    public final View getVideoLoadingProgressView()
    {
      AppMethodBeat.i(7917);
      if (WebViewUI.s(WebViewUI.this) == null)
      {
        WebViewUI.a(WebViewUI.this, new ProgressBar(WebViewUI.this));
        WebViewUI.s(WebViewUI.this).setIndeterminate(true);
      }
      ProgressBar localProgressBar = WebViewUI.s(WebViewUI.this);
      AppMethodBeat.o(7917);
      return localProgressBar;
    }
    
    public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(7918);
      ab.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[] { paramString });
      if (!com.tencent.mm.pluginsdk.permission.b.o(WebViewUI.this, "android.permission.ACCESS_COARSE_LOCATION")) {
        com.tencent.mm.pluginsdk.permission.b.b(WebViewUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64);
      }
      com.tencent.mm.ui.base.h.a(WebViewUI.this, false, WebViewUI.this.getString(2131306020, new Object[] { paramString }), WebViewUI.this.getString(2131306021), WebViewUI.this.getString(2131297018), WebViewUI.this.getString(2131296888), new WebViewUI.g.1(this, paramCallback, paramString), new WebViewUI.g.4(this, paramCallback, paramString));
      AppMethodBeat.o(7918);
    }
    
    public final void onHideCustomView()
    {
      AppMethodBeat.i(7916);
      ab.i("MicroMsg.WebViewUI", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
      WebViewUI.this.getContext().getWindow().clearFlags(128);
      if (WebViewUI.p(WebViewUI.this) == null)
      {
        AppMethodBeat.o(7916);
        return;
      }
      try
      {
        WebViewUI.this.os(false);
        if (!WebViewUI.this.pOd.isXWalkKernel())
        {
          WebViewUI.this.pOd.setVisibility(0);
          WebViewUI.this.setTitleVisibility(0);
        }
        for (;;)
        {
          if (WebViewUI.this.vek != null) {
            WebViewUI.this.vek.removeView(WebViewUI.p(WebViewUI.this));
          }
          WebViewUI.a(WebViewUI.this, null);
          if (WebViewUI.r(WebViewUI.this) != null) {
            WebViewUI.r(WebViewUI.this).onCustomViewHidden();
          }
          AppMethodBeat.o(7916);
          return;
          WebViewUI.this.fullScreenNoTitleBar(false);
          WebViewUI.this.setStatusBarColor(WebViewUI.this.getResources().getColor(2131690521));
          if (WebViewUI.this.vgd != null)
          {
            ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)WebViewUI.this.vgd.getLayoutParams();
            int i = WebViewUI.q(WebViewUI.this);
            if (i != localMarginLayoutParams.topMargin)
            {
              localMarginLayoutParams.topMargin = i;
              WebViewUI.this.vgd.setLayoutParams(localMarginLayoutParams);
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.WebViewUI", "onHideCustomView error " + localException.getMessage());
        AppMethodBeat.o(7916);
      }
    }
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(7915);
      ab.i("MicroMsg.WebViewUI", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
      try
      {
        WebViewUI.this.getContext().getWindow().addFlags(128);
        if (WebViewUI.p(WebViewUI.this) != null)
        {
          paramCustomViewCallback.onCustomViewHidden();
          AppMethodBeat.o(7915);
          return;
        }
        WebViewUI.this.os(false);
        WebViewUI.a(WebViewUI.this, paramView);
        WebViewUI.a(WebViewUI.this, paramCustomViewCallback);
        if (!WebViewUI.this.pOd.isXWalkKernel())
        {
          WebViewUI.this.pOd.setVisibility(8);
          WebViewUI.this.vek.addView(paramView);
          WebViewUI.this.setTitleVisibility(4);
          AppMethodBeat.o(7915);
          return;
        }
      }
      catch (Exception paramView)
      {
        ab.e("MicroMsg.WebViewUI", "onShowCustomView error " + paramView.getMessage());
        AppMethodBeat.o(7915);
        return;
      }
      WebViewUI.this.vek.addView(paramView, 0);
      WebViewUI.this.fullScreenNoTitleBar(true);
      WebViewUI.this.setStatusBarColor(0);
      if (WebViewUI.this.vgd != null)
      {
        paramView = (ViewGroup.MarginLayoutParams)WebViewUI.this.vgd.getLayoutParams();
        paramView.topMargin = 0;
        WebViewUI.this.vgd.setLayoutParams(paramView);
      }
      AppMethodBeat.o(7915);
    }
    
    public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      AppMethodBeat.i(7919);
      WebViewUI.t(WebViewUI.this).a(WebViewUI.this, WebViewUI.this.igV, paramValueCallback, null, paramString1, paramString2);
      AppMethodBeat.o(7919);
    }
  }
  
  public class h
    extends w
  {
    protected h() {}
    
    public static String aiA(String paramString)
    {
      AppMethodBeat.i(7938);
      StringBuilder localStringBuilder = new StringBuilder();
      try
      {
        paramString = InetAddress.getAllByName(paramString);
        if ((paramString != null) && (paramString.length > 0))
        {
          int i = 0;
          while (i < paramString.length)
          {
            localStringBuilder.append(paramString[i].getHostAddress());
            localStringBuilder.append(";");
            i += 1;
          }
        }
        paramString = localStringBuilder.toString();
      }
      catch (UnknownHostException paramString)
      {
        ab.printErrStackTrace("MicroMsg.WebViewUI", paramString, "dnsIps", new Object[0]);
        AppMethodBeat.o(7938);
        return null;
      }
      AppMethodBeat.o(7938);
      return paramString;
    }
    
    private boolean aiB(String paramString)
    {
      AppMethodBeat.i(7943);
      if (!WebViewUI.c(WebViewUI.this, paramString))
      {
        ab.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
        WebViewUI.k(WebViewUI.this);
        AppMethodBeat.o(7943);
        return true;
      }
      AppMethodBeat.o(7943);
      return false;
    }
    
    private s aiC(String paramString)
    {
      AppMethodBeat.i(7944);
      com.tencent.mm.plugin.webview.model.ap localap = WebViewUI.this.vfZ;
      if (!WebViewUI.O(WebViewUI.this)) {}
      for (boolean bool = true;; bool = false)
      {
        paramString = localap.a(paramString, bool, WebViewUI.this.igU);
        if (paramString == null) {
          break;
        }
        AppMethodBeat.o(7944);
        return paramString;
      }
      AppMethodBeat.o(7944);
      return null;
    }
    
    private boolean j(WebView paramWebView, final String paramString)
    {
      AppMethodBeat.i(138039);
      ab.i("MicroMsg.WebViewUI", "edw opt, shouldOverride url = ".concat(String.valueOf(paramString)));
      WebViewUI.this.veQ = true;
      if (!WebViewUI.c(WebViewUI.this, paramString))
      {
        ab.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
        WebViewUI.k(WebViewUI.this);
        AppMethodBeat.o(138039);
        return true;
      }
      if (com.tencent.mm.pluginsdk.ui.tools.u.x(paramString, "about:blank"))
      {
        ab.e("MicroMsg.WebViewUI", "shouldOverride, url is about:blank");
        AppMethodBeat.o(138039);
        return true;
      }
      if (DownloadChecker.a(paramString, WebViewUI.this.cGT, paramWebView))
      {
        ab.i("MicroMsg.WebViewUI", "use the downloader to download");
        AppMethodBeat.o(138039);
        return true;
      }
      for (;;)
      {
        try
        {
          if ((paramString.startsWith("weixin://jump/")) || (paramString.startsWith("weixin://scanqrcode/")))
          {
            WebViewUI.this.ais(paramString);
            AppMethodBeat.o(138039);
            return true;
          }
          if ((paramString.startsWith("weixin://dl/business")) && (com.tencent.mm.pluginsdk.e.l(Uri.parse(paramString))))
          {
            paramWebView = Uri.parse(WebViewUI.this.cJr).getHost();
            Intent localIntent = new Intent("android.intent.action.VIEW");
            localIntent.addCategory("android.intent.category.BROWSABLE");
            localIntent.setData(Uri.parse(paramString + "&domain=" + paramWebView));
            i = WebViewUI.this.getIntent().getIntExtra("pay_channel", -1);
            if (i != -1)
            {
              ab.i("MicroMsg.WebViewUI", "%s do deeplink, bypass pay channel: %s", new Object[] { paramString, Integer.valueOf(i) });
              localIntent.putExtra("pay_channel", i);
            }
            localIntent.putExtra("translate_link_scene", 13);
            WebViewUI.this.startActivity(localIntent);
            AppMethodBeat.o(138039);
            return true;
          }
          if ((!paramString.startsWith("weixinpreinject://iframe")) || (WebViewUI.this.vfi == null)) {
            continue;
          }
          ab.i("MicroMsg.WebViewUI", "preInjectJsBridge,accept preinject_Iframe and continue preinjectjsbridge");
        }
        catch (Exception paramWebView)
        {
          ab.w("MicroMsg.WebViewUI", "shouldOverride, jumpToActivity, ex = " + paramWebView.getMessage());
          if (WebViewUI.this.igV != null) {
            continue;
          }
          ab.e("MicroMsg.WebViewUI", "wvPerm is null, maybe has detach");
          AppMethodBeat.o(138039);
          return true;
        }
        if (paramString.equals(WebViewUI.x(WebViewUI.this)))
        {
          WebViewUI.e(WebViewUI.this, "");
          AppMethodBeat.o(138039);
          return true;
          if ((paramString.startsWith("weixin://dl/login/common_view")) || (paramString.startsWith("weixin://dl/login/phone_view")))
          {
            if (((WebViewUI.this.cJr.startsWith("https://support.weixin.qq.com/security")) || (paramString.startsWith("https://support.wechat.com/security"))) && (WebViewUI.w(WebViewUI.this)))
            {
              com.tencent.mm.pluginsdk.e.bs(WebViewUI.this.getContext(), paramString);
              WebViewUI.this.finish();
              AppMethodBeat.o(138039);
              return true;
            }
          }
          else if (!paramString.startsWith("weixin://webview/initReady/"))
          {
            bool = paramString.startsWith("weixin://webview/preInjectJSBridge/");
            if (!bool) {
              break;
            }
          }
          else
          {
            AppMethodBeat.o(138039);
            return true;
          }
        }
      }
      if (WebViewUI.this.ait(paramString))
      {
        AppMethodBeat.o(138039);
        return true;
      }
      if (paramString.startsWith("weixin://"))
      {
        ab.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[] { paramString });
        AppMethodBeat.o(138039);
        return true;
      }
      int i = WebViewUI.this.vfb.agV(paramString);
      if (((i == 0) || (i == 2) || (i == 8)) && (!WebViewUI.y(WebViewUI.this)))
      {
        ab.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = ".concat(String.valueOf(i)));
        if (WebViewUI.this.aip(paramString))
        {
          WebViewUI.this.pOd.stopLoading();
          WebViewUI.this.pOd.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(7926);
              WebViewUI.this.b(paramString, null, true);
              AppMethodBeat.o(7926);
            }
          });
        }
        while (paramString.equals(WebViewUI.d(WebViewUI.this)))
        {
          ab.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
          bool = aia(paramString);
          AppMethodBeat.o(138039);
          return bool;
          if ((!paramString.equals(WebViewUI.d(WebViewUI.this))) || (!WebViewUI.z(WebViewUI.this)) || (paramString.equals(WebViewUI.this.dek()))) {
            WebViewUI.this.pOd.stopLoading();
          } else {
            ab.w("MicroMsg.WebViewUI", "shouldOverride, lastGetA8KeyUrl=%s, url=%s, loadUrl=%s", new Object[] { WebViewUI.d(WebViewUI.this), paramString, WebViewUI.this.dek() });
          }
        }
        WebViewUI.a(WebViewUI.this, paramString, true, i);
        AppMethodBeat.o(138039);
        return true;
      }
      boolean bool = aia(paramString);
      AppMethodBeat.o(138039);
      return bool;
    }
    
    public s a(WebView paramWebView, r paramr)
    {
      AppMethodBeat.i(7941);
      if ((paramr == null) || (paramr.getUrl() == null) || (bo.isNullOrNil(paramr.getUrl().toString())))
      {
        paramWebView = super.a(paramWebView, paramr);
        AppMethodBeat.o(7941);
        return paramWebView;
      }
      ab.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[] { paramr.getUrl(), paramr.getMethod(), Boolean.valueOf(paramr.isForMainFrame()) });
      if (aiB(paramr.getUrl().toString()))
      {
        AppMethodBeat.o(7941);
        return null;
      }
      paramWebView = aiC(paramr.getUrl().toString());
      AppMethodBeat.o(7941);
      return paramWebView;
    }
    
    public s a(WebView paramWebView, r paramr, Bundle paramBundle)
    {
      AppMethodBeat.i(7942);
      if ((paramr == null) || (paramr.getUrl() == null) || (bo.isNullOrNil(paramr.getUrl().toString())))
      {
        paramWebView = super.a(paramWebView, paramr);
        AppMethodBeat.o(7942);
        return paramWebView;
      }
      ab.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[] { paramr.getUrl(), paramr.getMethod(), Boolean.valueOf(paramr.isForMainFrame()) });
      if (aiB(paramr.getUrl().toString()))
      {
        AppMethodBeat.o(7942);
        return null;
      }
      if (com.tencent.mm.cn.d.iN(WebViewUI.this)) {}
      try
      {
        int i = paramBundle.getInt("resourceType");
        if (((i == 1) || (i == 7)) && (!WebViewUI.N(WebViewUI.this)))
        {
          ab.i("MicroMsg.WebViewUI", "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
          WebViewUI.a(WebViewUI.this, paramr.getUrl().toString(), false, 5);
        }
      }
      catch (Exception paramWebView)
      {
        for (;;)
        {
          ab.w("MicroMsg.WebViewUI", "get resource type failed Exception ; %s", new Object[] { paramWebView.getMessage() });
        }
      }
      catch (Throwable paramWebView)
      {
        for (;;)
        {
          ab.w("MicroMsg.WebViewUI", "get resource type failed Throwable ; %s", new Object[] { paramWebView.getMessage() });
        }
      }
      paramWebView = aiC(paramr.getUrl().toString());
      AppMethodBeat.o(7942);
      return paramWebView;
    }
    
    public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(7937);
      com.tencent.xweb.util.f.si(false);
      ab.e("MicroMsg.WebViewUI", "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1, Boolean.valueOf(at.isConnected(WebViewUI.this)) });
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(155L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(155L, b.Kl(paramInt), 1L, false);
      com.tencent.mm.plugin.topstory.a.h.dA(WebViewUI.this.cGT, 1);
      com.tencent.mm.plugin.topstory.a.h.dA(WebViewUI.this.cGT, b.Kl(paramInt));
      com.tencent.mm.plugin.topstory.a.h.c(WebViewUI.this.cGT, WebViewUI.this.cJr, b.Kl(paramInt), WebViewUI.this.uVh.dcl().eaj);
      super.a(paramWebView, paramInt, paramString1, paramString2);
      m.vdm.Kx(paramInt);
      WebViewUI.this.uVh.dct().errCode = paramInt;
      WebViewUI.this.vfS.vcK = false;
      if (WebViewUI.M(WebViewUI.this)) {
        WebViewUI.this.finish();
      }
      try
      {
        if (new URL(paramString2).getHost().equals("mp.weixin.qq.com")) {
          com.tencent.mm.sdk.g.d.ysm.b(new WebViewUI.h.2(this, paramString2, paramInt), "WebViewUI.CheckDNS");
        }
        AppMethodBeat.o(7937);
        return;
      }
      catch (MalformedURLException paramWebView)
      {
        ab.printErrStackTrace("MicroMsg.WebViewUI", paramWebView, "check mp url", new Object[0]);
        AppMethodBeat.o(7937);
      }
    }
    
    public final void a(WebView paramWebView, com.tencent.xweb.m paramm, SslError paramSslError)
    {
      AppMethodBeat.i(7936);
      com.tencent.xweb.util.f.si(true);
      if (paramWebView.getUrl() == null)
      {
        paramWebView = WebViewUI.this.vgp;
        if ((paramWebView == null) || (!paramWebView.startsWith(((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).aWn()))) {
          break label203;
        }
        paramWebView = WebViewUI.this.daZ();
      }
      label203:
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(155L, 1L, 1L, false);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(155L, 30L, 1L, false);
        com.tencent.mm.plugin.topstory.a.h.dA(WebViewUI.this.cGT, 1);
        com.tencent.mm.plugin.topstory.a.h.dA(WebViewUI.this.cGT, 30);
        com.tencent.mm.plugin.topstory.a.h.c(WebViewUI.this.cGT, WebViewUI.this.cJr, 30, WebViewUI.this.uVh.dcl().eaj);
        if (WebViewUI.L(WebViewUI.this) == null) {
          WebViewUI.a(WebViewUI.this, new d(WebViewUI.this, WebViewUI.this.pOd));
        }
        WebViewUI.L(WebViewUI.this).a(paramWebView, paramm, paramSslError);
        AppMethodBeat.o(7936);
        return;
        paramWebView = paramWebView.getUrl();
        break;
      }
    }
    
    public void a(WebView paramWebView, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(7933);
      ab.i("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url = %s, isReload = %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      super.a(paramWebView, paramString, paramBoolean);
      if (com.tencent.mm.pluginsdk.ui.tools.u.x(paramString, "about:blank"))
      {
        ab.e("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url is about:blank");
        AppMethodBeat.o(7933);
        return;
      }
      paramWebView = paramWebView.getUrl();
      if (WebViewUI.y(WebViewUI.this)) {
        WebViewUI.this.ax(paramWebView, false);
      }
      if ((WebViewUI.A(WebViewUI.this)) && ((WebViewUI.this.uXd == null) || (bo.isEqual(paramWebView, WebViewUI.this.uXd)))) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        if ((paramBoolean) || ((WebViewUI.this.igV != null) && (!WebViewUI.this.igV.has(paramWebView)) && (!bo.isEqual(paramWebView, WebViewUI.d(WebViewUI.this)))))
        {
          ab.i("MicroMsg.WebViewUI", "doUpdateVisitedHistory start geta8key, url = %s, isPushStateBack=%b", new Object[] { paramWebView, Boolean.valueOf(paramBoolean) });
          if (!bo.isNullOrNil(paramWebView)) {
            WebViewUI.this.ax(paramWebView, paramBoolean);
          }
          WebViewUI.this.Y(true, false);
          WebViewUI.c(WebViewUI.this, true);
        }
        WebViewUI.this.vgh.ddX();
        WebViewUI.this.vgp = paramString;
        WebViewUI.this.uRy.aiF(paramString);
        AppMethodBeat.o(7933);
        return;
      }
    }
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(7932);
      boolean bool = j(paramWebView, paramString);
      if (bool) {
        WebViewUI.this.veQ = false;
      }
      AppMethodBeat.o(7932);
      return bool;
    }
    
    public boolean aia(String paramString)
    {
      AppMethodBeat.i(7931);
      ab.i("MicroMsg.WebViewUI", "edw mmShouldOverride");
      if ((paramString.startsWith("weixinping://iframe")) || (paramString.startsWith("weixinpreinject://iframe")))
      {
        AppMethodBeat.o(7931);
        return true;
      }
      if (WebViewUI.d(WebViewUI.this, paramString))
      {
        ab.i("MicroMsg.WebViewUI", "custom scheme url deal success, url = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(7931);
        return true;
      }
      WebViewUI.this.vgp = paramString;
      AppMethodBeat.o(7931);
      return false;
    }
    
    public void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(7935);
      super.b(paramWebView, paramString);
      WebViewUI.this.veQ = false;
      WebViewUI.B(WebViewUI.this).aX("onPageFinished", System.currentTimeMillis());
      WebViewUI.G(WebViewUI.this);
      com.tencent.mm.plugin.webview.model.a.c(WebViewUI.this.pOd);
      WebViewUI.this.uRy.aiF(paramString);
      if (!WebViewUI.H(WebViewUI.this))
      {
        WebViewUI.I(WebViewUI.this);
        WebViewUI.this.uVh.dcn().loadFinished = true;
      }
      ab.i("MicroMsg.WebViewUI", "edw onPageFinished opt, url = %s", new Object[] { paramString });
      Object localObject1 = WebViewUI.this.uVh.dcs();
      if ((!((as.d)localObject1).mzI) || (((as.d)localObject1).uWP)) {}
      Object localObject3;
      for (;;)
      {
        localObject1 = m.vdm;
        ab.v("MicroMsg.WebViewReportUtil", "onPageFinished traceid %s", new Object[] { ((m)localObject1).rpu });
        if (!bo.isNullOrNil(((m)localObject1).rpu)) {
          ((m)localObject1).kS(2);
        }
        if (WebViewUI.this.pOd != null) {
          break;
        }
        ab.w("MicroMsg.WebViewUI", "onPageFinished, webview has been destroyed, skip");
        AppMethodBeat.o(7935);
        return;
        try
        {
          localObject3 = Uri.parse(paramString);
          if (paramString.startsWith("http")) {
            break label261;
          }
          ab.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", new Object[] { paramString });
        }
        continue;
        label261:
        localObject3 = ((Uri)localObject3).getHost();
        if ((localObject3 != null) && (((String)localObject3).equalsIgnoreCase("v.html5.qq.com")))
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(283L, 0L, 1L, true);
          localException.uWP = true;
          ab.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", new Object[] { paramString });
        }
      }
      WebViewUI.this.vfQ.xB(paramString);
      Object localObject2 = WebViewUI.this.pOd.getTitle();
      ab.i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", new Object[] { WebViewUI.this.getMMTitle(), localObject2, Boolean.valueOf(WebViewUI.this.vec), Boolean.valueOf(WebViewUI.this.rNQ), WebViewUI.this.vgp });
      if ((WebViewUI.this.pOd.getIsX5Kernel()) && (!bo.isNullOrNil((String)localObject2)) && (((String)localObject2).length() > 0) && (!((String)localObject2).equals(WebViewUI.this.getMMTitle())) && (!((String)localObject2).startsWith("http")) && ((WebViewUI.this.vgp == null) || (!WebViewUI.this.vgp.equals(localObject2))) && (!WebViewUI.this.vec) && (WebViewUI.this.rNQ))
      {
        ab.d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
        WebViewUI.this.setMMTitle((String)localObject2);
      }
      WebViewUI.this.vgh.setCurrentURL(WebViewUI.this.dek());
      boolean bool = WebViewUI.this.getIntent().getBooleanExtra("shouldForceViewPort", false);
      ab.d("MicroMsg.WebViewUI", "hy: shouldForceViewPort: ".concat(String.valueOf(bool)));
      if (bool) {
        paramWebView.evaluateJavascript(WebViewUI.this.getIntent().getStringExtra("view_port_code"), null);
      }
      WebViewUI.J(WebViewUI.this);
      if (!WebViewUI.c(WebViewUI.this, paramString))
      {
        ab.f("MicroMsg.WebViewUI", "onPageFinished, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
        WebViewUI.k(WebViewUI.this);
        AppMethodBeat.o(7935);
        return;
      }
      WebViewUI.this.setProgressBarIndeterminateVisibility(false);
      WebViewUI.this.ved.finish();
      WebViewUI.e(WebViewUI.this, "");
      if (paramString.equals("file:///android_asset/jsapi/wxjs.js"))
      {
        ab.i("MicroMsg.WebViewUI", "onPageFinished, js is finished loaded");
        AppMethodBeat.o(7935);
        return;
      }
      ab.i("MicroMsg.WebViewUI", "onPageFinished, inject url" + WebViewUI.K(WebViewUI.this));
      if (WebViewUI.this.vfi != null)
      {
        WebViewUI.this.vfi.vpb = WebViewUI.this.getIntent().getBooleanExtra("inject_city_service_js", false);
        WebViewUI.this.vfi.vpc = WebViewUI.this.getIntent().getStringExtra("city_service_ext_info");
        WebViewUI.this.vfi.uG();
      }
      if ((WebViewUI.this.igV != null) && (WebViewUI.this.igV.agS(paramString) != null)) {
        WebViewUI.a(WebViewUI.this, WebViewUI.this.igV.agS(paramString).jy(34), WebViewUI.this.igV.agS(paramString).jy(75));
      }
      WebViewUI.this.os(WebViewUI.deM());
      localObject2 = WebViewUI.this.uVh.dci();
      label921:
      com.tencent.mm.plugin.webview.stub.d locald;
      int i;
      long l1;
      if (bo.isNullOrNil(paramString))
      {
        ab.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        localObject2 = WebViewUI.this.uVh.dcj();
        if (!bo.isNullOrNil(paramString)) {
          break label1459;
        }
        ab.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
        localObject3 = WebViewUI.this.uVh.dcm();
        locald = WebViewUI.this.igU;
        if ((locald != null) && (!((as.h)localObject3).bCp))
        {
          ((as.h)localObject3).bCp = true;
          i = as.aDS();
          l1 = bo.aoy() - ((as.h)localObject3).startTime;
          if ((l1 >= 0L) && (l1 <= 180000L)) {
            break label1514;
          }
        }
        if (!WebViewUI.this.vfk.containsKey(paramString)) {
          WebViewUI.this.vfk.put(paramString, Boolean.valueOf(WebViewUI.this.isOptionMenuShow(0)));
        }
        localObject3 = (Bundle)WebViewUI.this.getIntent().getParcelableExtra("jsapiargs");
        if (localObject3 != null)
        {
          localObject2 = ((Bundle)localObject3).getParcelable("KSnsAdTag");
          if ((localObject2 != null) && ((localObject2 instanceof SnsAdClick)))
          {
            localObject3 = ((Bundle)localObject3).getString("KAnsUxInfo", "");
            WebViewUI.this.uVh.dct().pzR = ((SnsAdClick)localObject2);
            WebViewUI.this.uVh.dct().L(new String[] { paramString, "1", System.currentTimeMillis(), localObject3 });
            WebViewUI.this.uVh.dct().b(WebViewUI.this.igU);
          }
        }
        WebViewUI.this.or(((Boolean)WebViewUI.this.vfk.get(paramString)).booleanValue());
        localObject2 = (Boolean)WebViewUI.this.vfn.get(paramString);
        if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
          break label1735;
        }
        WebViewUI.this.showOptionMenu(0, true);
      }
      for (;;)
      {
        if ((WebViewUI.this.veD) && (bo.isNullOrNil(WebViewUI.this.vgo))) {
          WebViewUI.this.vgo = WebViewUI.this.vgp;
        }
        WebViewUI.a(WebViewUI.this, bo.aox());
        com.tencent.mm.sdk.b.a.ymk.l(new wc());
        WebViewUI.this.b(paramWebView, paramString);
        if ((WebViewUI.F(WebViewUI.this) != null) && (!WebViewUI.F(WebViewUI.this).vhd))
        {
          paramWebView = WebViewUI.F(WebViewUI.this);
          ab.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", new Object[] { paramString });
          paramWebView.iIg = paramString;
        }
        paramWebView = WebViewUI.B(WebViewUI.this);
        paramString = WebViewUI.this.pOd;
        if (paramString != null) {
          paramString.evaluateJavascript("JSON.stringify({timing:((window.performance && window.performance.timing) ? window.performance.timing : null)});", new d.1(paramWebView));
        }
        AppMethodBeat.o(7935);
        return;
        if (!((as.n)localObject2).uXh.containsKey(paramString)) {
          break;
        }
        l1 = ((Long)((as.n)localObject2).uXh.get(paramString)).longValue();
        long l2 = bo.aoy();
        ((as.n)localObject2).uXh.put(paramString, Long.valueOf(l2 - l1));
        break;
        label1459:
        if (!((as.f)localObject2).uWS.containsKey(paramString)) {
          break label921;
        }
        l1 = ((Long)((as.f)localObject2).uWS.get(paramString)).longValue();
        l2 = bo.aoy();
        ((as.f)localObject2).uWS.put(paramString, Long.valueOf(l2 - l1));
        break label921;
        label1514:
        String str = ((as.h)localObject3).uWU;
        if (((as.h)localObject3).url == null) {}
        for (localObject2 = ((as.h)localObject3).url;; localObject2 = ((as.h)localObject3).url.replace(",", "!"))
        {
          as.b(locald, str, new Object[] { Integer.valueOf(4), Long.valueOf(l1), Integer.valueOf(i), localObject2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(as.access$000()), Integer.valueOf(as.access$100()), Integer.valueOf(((as.h)localObject3).cNH), ((as.h)localObject3).uWU });
          ab.i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { ((as.h)localObject3).url, Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(as.access$000()), Integer.valueOf(as.access$100()), Integer.valueOf(((as.h)localObject3).cNH), ((as.h)localObject3).uWU });
          break;
        }
        label1735:
        WebViewUI.this.showOptionMenu(0, false);
      }
    }
    
    public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(7934);
      super.b(paramWebView, paramString, paramBitmap);
      WebViewUI.this.veQ = true;
      WebViewUI.B(WebViewUI.this).aX("onPageStarted", System.currentTimeMillis());
      com.tencent.mm.plugin.webview.model.a.c(WebViewUI.this.pOd);
      com.tencent.mm.plugin.webview.f.e.i(paramString, WebViewUI.this.getContext());
      ab.i("MicroMsg.WebViewUI", "edw onPageStarted opt, url = ".concat(String.valueOf(paramString)));
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(155L, 0L, 1L, false);
      if (!WebViewUI.this.vgl) {
        WebViewUI.this.vfS.ddO();
      }
      com.tencent.mm.plugin.topstory.a.h.dA(WebViewUI.this.cGT, 0);
      if (WebViewUI.this.aYS())
      {
        if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(paramWebView.getUrl()))) {
          break label435;
        }
        ab.i("MicroMsg.WebViewUI", "onPageStarted call with same url when preload");
        WebViewUI.this.des();
        if (WebViewUI.this.vfi != null) {
          WebViewUI.this.vfi.vlr = false;
        }
        WebViewUI.this.deH();
      }
      for (;;)
      {
        if ((com.tencent.mm.sdk.a.b.dsf()) && ("http://www.dktest-mmcrash.com/".equals(paramString))) {
          Assert.assertTrue("test errlog in tools " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
        }
        WebViewUI.this.uXd = WebViewUI.this.vgp;
        long l = bo.aox();
        WebViewUI.this.m(paramString, l, 1);
        WebViewUI.this.uVh.dck().uXd = WebViewUI.this.uXd;
        WebViewUI.this.vgp = paramString;
        paramWebView = m.vdm;
        ab.v("MicroMsg.WebViewReportUtil", "onPageStarted url %s, currUrl %s, traceid %s", new Object[] { paramString, paramWebView.vdn, paramWebView.rpu });
        paramBitmap = paramWebView.vdn;
        paramWebView.vdn = paramString;
        if (!bo.isNullOrNil(paramWebView.rpu)) {
          paramWebView.i(1, paramBitmap, 0);
        }
        ab.d("MicroMsg.WebViewUI", "onPageStarted preUrl : %s, curUrl : %s.", new Object[] { WebViewUI.this.uXd, WebViewUI.this.vgp });
        if (WebViewUI.c(WebViewUI.this, paramString)) {
          break;
        }
        ab.f("MicroMsg.WebViewUI", "onPageStarted, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
        WebViewUI.k(WebViewUI.this);
        AppMethodBeat.o(7934);
        return;
        label435:
        ab.v("MicroMsg.WebViewUI", "onPageStarted call when preload url %s, webview.url %s", new Object[] { paramString, paramWebView.getUrl() });
      }
      WebViewUI.this.vgh.ddX();
      WebViewUI.this.vgh.setCurrentURL(paramString);
      if (WebViewUI.this.ait(paramString))
      {
        WebViewUI.e(WebViewUI.this, paramString);
        AppMethodBeat.o(7934);
        return;
      }
      if (WebViewUI.this.vfi != null) {
        WebViewUI.this.vfi.dgb();
      }
      WebViewUI.this.setProgressBarIndeterminateVisibility(false);
      if ((!WebViewUI.this.aip(paramString)) && (!WebViewUI.this.vfx))
      {
        WebViewUI.this.vfw = false;
        if (!WebViewUI.this.vfz) {
          WebViewUI.this.ved.start();
        }
        WebViewUI.this.vfS.ail(paramString);
        paramWebView = WebViewUI.this.ax(paramString, false);
        if (WebViewUI.w.vgZ.equals(paramWebView))
        {
          WebViewUI.this.vfQ.xB(paramString);
          if (!WebViewUI.this.vgl) {
            WebViewUI.this.vfS.vcK = true;
          }
        }
        WebViewUI.this.Y(true, false);
        WebViewUI.c(WebViewUI.this, false);
        paramWebView = WebViewUI.this.uVh.dci();
        int i = WebViewUI.this.cNH;
        paramBitmap = WebViewUI.this.cGT;
        paramWebView.cNH = i;
        paramWebView.uWU = paramBitmap;
        if (!bo.isNullOrNil(paramString)) {
          break label1018;
        }
        ab.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
      }
      for (;;)
      {
        paramBitmap = (Bundle)WebViewUI.this.getIntent().getParcelableExtra("jsapiargs");
        if (paramBitmap != null)
        {
          paramWebView = paramBitmap.getParcelable("KSnsAdTag");
          if ((paramWebView != null) && ((paramWebView instanceof SnsAdClick)))
          {
            paramBitmap = paramBitmap.getString("KAnsUxInfo", "");
            WebViewUI.this.uVh.dct().pzR = ((SnsAdClick)paramWebView);
            WebViewUI.this.uVh.dct().L(new String[] { paramString, "0", System.currentTimeMillis(), paramBitmap });
            WebViewUI.this.uVh.dct().b(WebViewUI.this.igU);
          }
        }
        WebViewUI.E(WebViewUI.this);
        if ((WebViewUI.F(WebViewUI.this) != null) && (!WebViewUI.F(WebViewUI.this).vhd))
        {
          paramWebView = WebViewUI.F(WebViewUI.this);
          ab.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageStart, url:%s", new Object[] { paramString });
          paramWebView.iIg = paramString;
          paramWebView.deU();
        }
        AppMethodBeat.o(7934);
        return;
        WebViewUI.this.vfw = true;
        WebViewUI.this.ved.finish();
        WebViewUI.this.pOd.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
        if (WebViewUI.this.uQS == null) {
          break;
        }
        WebViewUI.this.uQS.B((String)WebViewUI.C(WebViewUI.this).get(paramString), (Map)WebViewUI.D(WebViewUI.this).get(paramString));
        break;
        label1018:
        if (!paramWebView.uXh.containsKey(paramString)) {
          paramWebView.uXh.put(paramString, Long.valueOf(bo.aoy()));
        }
      }
    }
    
    public final boolean b(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(154612);
      ab.e("MicroMsg.WebViewUI", "edw interceptLoadError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1, Boolean.valueOf(at.isConnected(WebViewUI.this)) });
      boolean bool = WebViewUI.this.a(paramWebView, paramString1, paramString2);
      AppMethodBeat.o(154612);
      return bool;
    }
    
    public s c(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(7940);
      ab.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s", new Object[] { paramString });
      if (aiB(paramString))
      {
        AppMethodBeat.o(7940);
        return null;
      }
      paramWebView = aiC(paramString);
      AppMethodBeat.o(7940);
      return paramWebView;
    }
    
    public final void h(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(7939);
      ab.i("MicroMsg.WebViewUI", "edw onLoadResource opt, url = ".concat(String.valueOf(paramString)));
      if (!WebViewUI.c(WebViewUI.this, paramString))
      {
        ab.f("MicroMsg.WebViewUI", "onLoadResource, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
        super.h(paramWebView, paramString);
        WebViewUI.k(WebViewUI.this);
        AppMethodBeat.o(7939);
        return;
      }
      as.f localf = WebViewUI.this.uVh.dcj();
      if (bo.isNullOrNil(paramString)) {
        ab.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
      }
      for (;;)
      {
        super.h(paramWebView, paramString);
        AppMethodBeat.o(7939);
        return;
        if ((!bo.isNullOrNil(localf.iIg)) && (!paramString.equals(localf.iIg)) && (localf.uWT))
        {
          if (localf.uWR.containsKey(localf.iIg))
          {
            long l1 = ((Long)localf.uWR.get(localf.iIg)).longValue();
            long l2 = bo.aoy();
            localf.uWR.put(localf.iIg, Long.valueOf(l2 - l1));
          }
          localf.uWT = false;
        }
      }
    }
  }
  
  final class n
    implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b
  {
    private n() {}
    
    public final boolean ait(String paramString)
    {
      AppMethodBeat.i(7959);
      if (!bo.isNullOrNil(paramString))
      {
        paramString = paramString.substring(17);
        ab.i("MicroMsg.WebViewUI", "[oneliang]get html content :".concat(String.valueOf(paramString)));
        WebViewUI.this.ain(paramString);
      }
      AppMethodBeat.o(7959);
      return false;
    }
    
    public final boolean aiz(String paramString)
    {
      AppMethodBeat.i(7958);
      if (bo.isNullOrNil(paramString))
      {
        AppMethodBeat.o(7958);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.u.x(paramString, "weixin://gethtml/");
      AppMethodBeat.o(7958);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI
 * JD-Core Version:    0.7.0.1
 */