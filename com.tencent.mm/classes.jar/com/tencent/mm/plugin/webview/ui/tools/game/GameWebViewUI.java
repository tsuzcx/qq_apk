package com.tencent.mm.plugin.webview.ui.tools.game;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.widget.ProgressBar;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.protobuf.dw;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.d.h.79;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.model.ba.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import com.tencent.xweb.x;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GameWebViewUI
  extends GameBaseWebViewUI
  implements f
{
  private static String QoK = "wx_fullscreen";
  private GameWebPerformanceInfo CCD;
  private boolean CCE;
  private Object CCF;
  private long CCT;
  private h CCU;
  private boolean CzQ;
  private com.tencent.mm.plugin.wepkg.f Qnr;
  private boolean QoJ;
  private HashMap<String, String> QoL;
  private Drawable QoM;
  private Drawable QoN;
  private String QoO;
  private Map<Integer, cxc> QoP;
  private GameMenuImageButton QoQ;
  private boolean QoR;
  private boolean QoS;
  private boolean QoT;
  private ViewGroup QoU;
  private c QoV;
  private boolean QoW;
  private boolean QoX;
  private String zgz;
  
  public GameWebViewUI()
  {
    AppMethodBeat.i(80915);
    this.CzQ = false;
    this.QoJ = false;
    this.QoL = new HashMap();
    this.QoO = null;
    this.QoP = new HashMap();
    this.QoS = false;
    this.CCE = false;
    this.CCF = new Object();
    this.QoV = new c((byte)0);
    this.QoW = false;
    this.QoX = false;
    AppMethodBeat.o(80915);
  }
  
  private o haA()
  {
    AppMethodBeat.i(80918);
    try
    {
      List localList = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.Qph;
      new Bundle().putString("game_hv_menu_appid", this.zgz);
      this.QoP.clear();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        cxc localcxc = (cxc)localIterator.next();
        this.QoP.put(Integer.valueOf(localcxc.TFF), localcxc);
      }
      localo = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.c(this, localException);
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Wepkg.GameWebViewUI", "get cache hv game menu fail! exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(80918);
      return null;
    }
    o localo;
    AppMethodBeat.o(80918);
    return localo;
  }
  
  private void haB()
  {
    AppMethodBeat.i(80937);
    if (this.QeU != null) {
      this.QeU.setVisibility(0);
    }
    AppMethodBeat.o(80937);
  }
  
  public final void Df(boolean paramBoolean)
  {
    AppMethodBeat.i(80924);
    super.Df(paramBoolean);
    Dj(false);
    AppMethodBeat.o(80924);
  }
  
  public final void aI(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263549);
    super.aI(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(263549);
  }
  
  public final void aX(Bundle paramBundle)
  {
    AppMethodBeat.i(80922);
    super.aX(paramBundle);
    AppMethodBeat.o(80922);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(80925);
    if (this.QoR) {
      super.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    AppMethodBeat.o(80925);
  }
  
  public final i cDV()
  {
    AppMethodBeat.i(263547);
    i locali = super.cDV();
    if (locali != null) {
      locali.a(this.QoV);
    }
    AppMethodBeat.o(263547);
    return locali;
  }
  
  public boolean cDX()
  {
    AppMethodBeat.i(80938);
    getIntent().putExtra("minimize_secene", 2);
    AppMethodBeat.o(80938);
    return true;
  }
  
  public final void cjK()
  {
    AppMethodBeat.i(80923);
    super.cjK();
    this.QoR = true;
    int i;
    if ((this.CzQ) || (this.CTz != null) || (this.CTy != 0)) {
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i != 0)
      {
        localObject = com.tencent.mm.plugin.game.commlib.a.ewc();
        if ((localObject == null) || (Util.isNullOrNil(((dw)localObject).lmL)) || (Util.isNullOrNil(((dw)localObject).CRy))) {}
      }
      try
      {
        if (ar.isDarkMode()) {}
        for (this.CTy = Color.parseColor(((dw)localObject).CRy);; this.CTy = Color.parseColor(((dw)localObject).lmL))
        {
          this.CTz = ((dw)localObject).CLD;
          gYD();
          Df(true);
          localObject = getIntent();
          if ((localObject == null) || (!((Intent)localObject).getBooleanExtra("game_check_float", false))) {
            break label421;
          }
          i = ((Intent)localObject).getIntExtra("game_sourceScene", 0);
          this.QoO = ((Intent)localObject).getStringExtra("game_transparent_float_url");
          if (!Util.isNullOrNil(this.QoO)) {
            break label247;
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("game_check_float", true);
          ((Intent)localObject).putExtra("game_sourceScene", i);
          com.tencent.mm.by.c.b(this, "game", ".ui.GameCenterUI", (Intent)localObject);
          AppMethodBeat.o(80923);
          return;
          i = 1;
          break;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          Log.e("MicroMsg.Wepkg.GameWebViewUI", "parse color: " + localIllegalArgumentException.getMessage());
        }
        try
        {
          label247:
          localObject = new Bundle();
          ((Bundle)localObject).putInt("game_sourceScene", i);
          if (this.pGC != null) {
            this.pGC.l(91, (Bundle)localObject);
          }
          if (this.Qnf == null) {
            this.Qnf = new b(this, this.Qfc, this.QoO);
          }
          localObject = this.Qnf;
          String str = this.QoO;
          ((b)localObject).CCx = str;
          ((b)localObject).Qnr.m(str, false, false);
          if ((((b)localObject).lxa != null) && (((b)localObject).lxa.getParent() == null))
          {
            ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
            ((b)localObject).Rx.addView(((b)localObject).lxa, localLayoutParams);
          }
          if ((((b)localObject).lxa != null) && (((b)localObject).Qns != null)) {
            ((b)localObject).lxa.post(new b.3((b)localObject, str));
          }
          this.QoO = null;
          AppMethodBeat.o(80923);
          return;
        }
        catch (RemoteException localRemoteException) {}
        label421:
        AppMethodBeat.o(80923);
      }
    }
  }
  
  public final Map<Integer, Object> ewY()
  {
    AppMethodBeat.i(263554);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(e.a.QnK), haE());
    localHashMap.put(Integer.valueOf(e.a.QnL), NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()));
    localHashMap.put(Integer.valueOf(e.a.QnM), String.valueOf(YearClass.get(MMApplicationContext.getContext())));
    String str = cDu();
    try
    {
      localHashMap.put(Integer.valueOf(e.a.QnN), com.tencent.mm.compatible.util.q.an(Util.nullAsNil(str), "UTF-8"));
      label92:
      localHashMap.put(Integer.valueOf(e.a.QnO), Boolean.valueOf(this.Qnr.boi(str)));
      localHashMap.put(Integer.valueOf(e.a.QnP), Integer.valueOf(0));
      localHashMap.put(Integer.valueOf(e.a.QnQ), Integer.valueOf(0));
      localHashMap.put(Integer.valueOf(e.a.QnR), this.Qnr.heo());
      localHashMap.put(Integer.valueOf(e.a.QnS), com.tencent.mm.plugin.wepkg.f.hep());
      AppMethodBeat.o(263554);
      return localHashMap;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label92;
    }
  }
  
  public final Map<Integer, Object> ewZ()
  {
    AppMethodBeat.i(263555);
    HashMap localHashMap = new HashMap();
    h localh = h.bmJ(cDu());
    if (localh != null)
    {
      localHashMap.put(Integer.valueOf(e.b.QnV), Long.valueOf(localh.Qos - localh.startTime));
      localHashMap.put(Integer.valueOf(e.b.QnW), Long.valueOf(localh.Qot - localh.startTime));
      localHashMap.put(Integer.valueOf(e.b.QnX), Long.valueOf(localh.Qou - localh.Qot));
      localHashMap.put(Integer.valueOf(e.b.QnY), Long.valueOf(localh.Qow - localh.Qov));
      localHashMap.put(Integer.valueOf(e.b.QnZ), Long.valueOf(localh.Qoy - localh.Qox));
      localHashMap.put(Integer.valueOf(e.b.Qoh), Long.valueOf(localh.Qoz));
    }
    localHashMap.put(Integer.valueOf(e.b.Qoi), Integer.valueOf(0));
    AppMethodBeat.o(263555);
    return localHashMap;
  }
  
  public final void gXW()
  {
    AppMethodBeat.i(80919);
    if (this.Qgk.QdB) {
      this.Qgk.gXV();
    }
    if ((this.QoQ == null) || (!this.QoQ.Qpi))
    {
      super.gXW();
      AppMethodBeat.o(80919);
      return;
    }
    final com.tencent.mm.plugin.webview.ui.tools.game.menu.d locald = new com.tencent.mm.plugin.webview.ui.tools.game.menu.d(getContext());
    locald.a(new b.c()
    {
      public final void d(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(80900);
        paramAnonymousMenuItem = (cxc)GameWebViewUI.l(GameWebViewUI.this).get(Integer.valueOf(paramAnonymousMenuItem.getItemId()));
        if (paramAnonymousMenuItem == null)
        {
          AppMethodBeat.o(80900);
          return;
        }
        switch (GameWebViewUI.8.Qpb[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.aoQ(paramAnonymousMenuItem.RXp).ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(80900);
          return;
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramAnonymousMenuItem.SYm);
          com.tencent.mm.by.c.b(GameWebViewUI.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          AppMethodBeat.o(80900);
          return;
          GameWebViewUI.this.PIx.gWe().C(new Object[] { GameWebViewUI.this.cDu(), Integer.valueOf(32), Integer.valueOf(1) }).report();
          if (!GameWebViewUI.m(GameWebViewUI.this))
          {
            GameWebViewUI.this.finish();
            AppMethodBeat.o(80900);
            return;
            paramAnonymousMenuItem = GameWebViewUI.this.getIntent().getStringExtra("KPublisherId");
            localObject = GameWebViewUI.this.getIntent().getStringExtra("KAppId");
            String str = GameWebViewUI.this.getIntent().getStringExtra("srcUsername");
            GameWebViewUI.this.PIx.gWe().C(new Object[] { GameWebViewUI.this.cDu(), Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem, localObject, str }).report();
            GameWebViewUI.n(GameWebViewUI.this);
            AppMethodBeat.o(80900);
            return;
            GameWebViewUI.this.PIx.gWe().C(new Object[] { GameWebViewUI.this.cDu(), Integer.valueOf(3), Integer.valueOf(1) }).report();
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(157L, 6L, 1L, false);
            GameWebViewUI.o(GameWebViewUI.this);
            AppMethodBeat.o(80900);
            return;
            GameWebViewUI.this.PIx.gWe().C(new Object[] { GameWebViewUI.this.cDu(), Integer.valueOf(10), Integer.valueOf(1) }).report();
            if (GameWebViewUI.p(GameWebViewUI.this) != null)
            {
              GameWebViewUI.q(GameWebViewUI.this).reload();
              AppMethodBeat.o(80900);
              return;
              GameWebViewUI.this.PIx.gWe().C(new Object[] { GameWebViewUI.this.cDu(), Integer.valueOf(31), Integer.valueOf(1) }).report();
              GameWebViewUI.r(GameWebViewUI.this);
              AppMethodBeat.o(80900);
              return;
              GameWebViewUI.this.PIx.gWe().C(new Object[] { GameWebViewUI.this.cDu(), Integer.valueOf(11), Integer.valueOf(1) }).report();
              GameWebViewUI.s(GameWebViewUI.this);
              AppMethodBeat.o(80900);
              return;
              if (GameWebViewUI.this.PvJ != null)
              {
                localObject = GameWebViewUI.this.PvJ;
                int i = paramAnonymousMenuItem.TFF;
                if (!((com.tencent.mm.plugin.webview.d.h)localObject).NoX)
                {
                  Log.e("MicroMsg.JsApiHandler", "not ready");
                  AppMethodBeat.o(80900);
                  return;
                }
                Log.i("MicroMsg.JsApiHandler", "onCustomGameMenuClicked");
                paramAnonymousMenuItem = new HashMap();
                paramAnonymousMenuItem.put("itemId", Integer.valueOf(i));
                MMHandlerThread.postToMainThread(new h.79((com.tencent.mm.plugin.webview.d.h)localObject, n.a.b("onCustomGameMenuClicked", paramAnonymousMenuItem, ((com.tencent.mm.plugin.webview.d.h)localObject).PNx, ((com.tencent.mm.plugin.webview.d.h)localObject).EVx)));
              }
            }
          }
        }
      }
    });
    locald.Qpx = new b.b()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(80901);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(480L, 0L, 1L, false);
        o localo = GameWebViewUI.t(GameWebViewUI.this);
        if (localo != null) {
          paramAnonymouso.WkP.addAll(localo.WkP);
        }
        AppMethodBeat.o(80901);
      }
    };
    if (this.Qfe) {
      locald.pMF = true;
    }
    for (locald.pMG = true; (this.Qfj != null) && (this.Qfj.isShown()); locald.pMG = false)
    {
      this.Qfj.hide();
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80902);
          if ((GameWebViewUI.this.isFinishing()) || (GameWebViewUI.u(GameWebViewUI.this)))
          {
            Log.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
            AppMethodBeat.o(80902);
            return;
          }
          locald.eik();
          AppMethodBeat.o(80902);
        }
      }, 100L);
      AppMethodBeat.o(80919);
      return;
      locald.pMF = false;
    }
    hideVKB();
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80903);
        if ((GameWebViewUI.this.isFinishing()) || (GameWebViewUI.v(GameWebViewUI.this)))
        {
          Log.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
          AppMethodBeat.o(80903);
          return;
        }
        locald.eik();
        AppMethodBeat.o(80903);
      }
    }, 100L);
    AppMethodBeat.o(80919);
  }
  
  public final int gYK()
  {
    AppMethodBeat.i(80921);
    int i = super.gYK();
    AppMethodBeat.o(80921);
    return i;
  }
  
  public final void gYL()
  {
    AppMethodBeat.i(80931);
    super.gYL();
    this.zgz = getIntent().getStringExtra("game_hv_menu_appid");
    if ((this.Qfe) && (!Util.isNullOrNil(this.zgz)))
    {
      if (this.Qfd != null) {
        this.Qfd.setVisibility(8);
      }
      this.QoQ.a(this.Qfb, new GameMenuImageButton.a()
      {
        public final void dLs()
        {
          AppMethodBeat.i(80904);
          GameWebViewUI.this.gXW();
          AppMethodBeat.o(80904);
        }
      });
    }
    AppMethodBeat.o(80931);
  }
  
  public final x gYN()
  {
    try
    {
      AppMethodBeat.i(80917);
      if (this.QfF == null) {
        this.QfF = new b();
      }
      x localx = this.QfF;
      AppMethodBeat.o(80917);
      return localx;
    }
    finally {}
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(80929);
    this.CCD.jTK = System.currentTimeMillis();
    int i = super.getLayoutId();
    AppMethodBeat.o(80929);
    return i;
  }
  
  public final com.tencent.mm.plugin.wepkg.f getWePkgPlugin()
  {
    return this.Qnr;
  }
  
  public final void haC()
  {
    AppMethodBeat.i(263556);
    this.CCU.Qox = System.currentTimeMillis();
    this.CCD.jTz = 1;
    AppMethodBeat.o(263556);
  }
  
  public final void haD()
  {
    AppMethodBeat.i(263557);
    this.CCU.Qoy = System.currentTimeMillis();
    AppMethodBeat.o(263557);
  }
  
  public final String haE()
  {
    AppMethodBeat.i(263558);
    String str = (hashCode() & 0x7FFFFFFF) + "_" + (cDu().hashCode() & 0x7FFFFFFF);
    AppMethodBeat.o(263558);
    return str;
  }
  
  public void initView()
  {
    AppMethodBeat.i(80930);
    super.initView();
    this.QoM = new ColorDrawable(androidx.core.content.a.w(this, c.c.actionbar_bg_color));
    this.QoN = new ColorDrawable(androidx.core.content.a.w(this, c.c.actionbar_bg_color));
    this.CCD.jTL = System.currentTimeMillis();
    this.CCU.Qos = System.currentTimeMillis();
    AppMethodBeat.o(80930);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(80933);
    if (this.CCD.jTN == 0L) {
      this.CCD.jTN = System.currentTimeMillis();
    }
    if (this.Qnr.hen())
    {
      super.loadUrl(paramString, paramMap, false);
      AppMethodBeat.o(80933);
      return;
    }
    super.loadUrl(paramString, paramMap, paramBoolean);
    AppMethodBeat.o(80933);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80916);
    final String str1 = getIntent().getStringExtra("rawUrl");
    if (((com.tencent.mm.api.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.api.q.class)).ZM())
    {
      str1 = "http://mp.weixin.qq.com/mp/readtemplate?t=appmsg/childmode";
      getIntent().putExtra("rawUrl", "http://mp.weixin.qq.com/mp/readtemplate?t=appmsg/childmode");
    }
    for (;;)
    {
      String str2;
      if (!Util.isNullOrNil(str1))
      {
        str2 = Uri.parse(str1).getQueryParameter("nav_color");
        if (Util.isNullOrNil(str2)) {}
      }
      try
      {
        int i = Color.parseColor("#".concat(String.valueOf(str2)));
        getIntent().putExtra("customize_status_bar_color", i);
        label110:
        Log.i("MicroMsg.Wepkg.GameWebViewUI", "rawUrl rid:%s, pkgId:%s", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.boP(str1), com.tencent.mm.plugin.wepkg.utils.d.boN(str1) });
        if (getIntent().getLongExtra("gamecenterui_createtime", 0L) > 0L)
        {
          this.CCD = GameWebPerformanceInfo.LZ(str1);
          this.CCD.url = str1;
          this.CCD.jTs = haE();
          this.CCD.jTC = getIntent().getLongExtra("gamecenterui_createtime", 0L);
          this.CCD.jTD = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
          this.CCD.startTime = getIntent().getLongExtra("start_time", this.CCD.jTD);
          this.CCD.jTI = System.currentTimeMillis();
          this.CCD.jTw = 1;
          Log.i("MicroMsg.Wepkg.GameWebViewUI", "onCreate, startTime: %d, gameCenterUICreate: %d, startWebUI: %d,webUICreate: %d", new Object[] { Long.valueOf(this.CCD.startTime), Long.valueOf(this.CCD.jTC), Long.valueOf(this.CCD.jTD), Long.valueOf(this.CCD.jTI) });
          this.CCU = h.bmH(str1);
          this.CCU.startTime = System.currentTimeMillis();
          this.Qnr = new com.tencent.mm.plugin.wepkg.f();
          super.onCreate(paramBundle);
          if (this.pHS != null) {
            this.pHS.getSettings().setForceDarkBehavior(1);
          }
          paramBundle = getIntent();
          if ((paramBundle != null) && (paramBundle.getBooleanExtra("disable_progress_bar", false)))
          {
            this.QeT.rnU = false;
            haB();
          }
          if (this.pHS.getIsX5Kernel()) {
            this.pHS.setWebViewClientExtension(new a(this));
          }
          this.Qnr.QLb = new com.tencent.mm.plugin.wepkg.event.b()
          {
            public final void exa()
            {
              AppMethodBeat.i(80897);
              Log.i("MicroMsg.Wepkg.GameWebViewUI", "onReload");
              GameWebViewUI.a(GameWebViewUI.this);
              if (GameWebViewUI.b(GameWebViewUI.this)) {
                GameWebViewUI.c(GameWebViewUI.this);
              }
              AppMethodBeat.o(80897);
            }
            
            public final void exb()
            {
              AppMethodBeat.i(80898);
              if (!GameWebViewUI.d(GameWebViewUI.this))
              {
                GameWebViewUI.a(GameWebViewUI.this, true);
                GameWebViewUI.f(GameWebViewUI.this).postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(80895);
                    if (GameWebViewUI.d(GameWebViewUI.this)) {
                      GameWebViewUI.e(GameWebViewUI.this);
                    }
                    AppMethodBeat.o(80895);
                  }
                }, 1000L);
              }
              AppMethodBeat.o(80898);
            }
            
            public final void si(final boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(80899);
              GameWebViewUI.k(GameWebViewUI.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80896);
                  com.tencent.mm.plugin.wepkg.f localf;
                  String str;
                  if (GameWebViewUI.d(GameWebViewUI.this))
                  {
                    GameWebViewUI.a(GameWebViewUI.this, false);
                    GameWebViewUI.g(GameWebViewUI.this);
                    if (paramAnonymousBoolean)
                    {
                      GameWebViewUI.h(GameWebViewUI.this).stopLoading();
                      localf = GameWebViewUI.j(GameWebViewUI.this);
                      str = GameWebViewUI.1.this.mEO;
                      if (GameWebViewUI.i(GameWebViewUI.this)) {
                        break label125;
                      }
                    }
                  }
                  label125:
                  for (boolean bool = true;; bool = false)
                  {
                    localf.m(str, bool, false);
                    GameWebViewUI.a(GameWebViewUI.this, GameWebViewUI.1.this.mEO);
                    AppMethodBeat.o(80896);
                    return;
                  }
                }
              });
              AppMethodBeat.o(80899);
            }
          };
          this.QoT = getIntent().getBooleanExtra("open_game_float", false);
          paramBundle = this.Qnr;
          if (this.QoT) {
            break label549;
          }
        }
        label549:
        for (boolean bool = true;; bool = false)
        {
          if (paramBundle.m(str1, bool, false))
          {
            Log.i("MicroMsg.Wepkg.GameWebViewUI", "current page use wepkg");
            this.QoS = true;
            haB();
          }
          this.QoQ = new GameMenuImageButton(getContext());
          AppMethodBeat.o(80916);
          return;
          this.CCD = GameWebPerformanceInfo.Ma(str1);
          break;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        break label110;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80928);
    this.PIQ.b(this.QoV);
    this.PIQ.b(this.QoV.Qpc);
    super.onDestroy();
    this.Qnr.DD(this.QoT);
    this.CCD.jTT = System.currentTimeMillis();
    com.tencent.mm.game.report.api.a.jTp.a(this.CCD);
    GameWebPerformanceInfo.Mb(cDu());
    e.a(haE(), this);
    h.bmK(cDu());
    AppMethodBeat.o(80928);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80927);
    super.onPause();
    GameWebPerformanceInfo localGameWebPerformanceInfo = this.CCD;
    localGameWebPerformanceInfo.jTS += System.currentTimeMillis() - this.CCT;
    AppMethodBeat.o(80927);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80926);
    super.onResume();
    if (this.CCD.jTJ == 0L)
    {
      long l = System.currentTimeMillis();
      Log.i("MicroMsg.Wepkg.GameWebViewUI", "onResume: ".concat(String.valueOf(l)));
      this.CCD.jTJ = l;
    }
    this.CCT = System.currentTimeMillis();
    AppMethodBeat.o(80926);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setMMOrientation()
  {
    AppMethodBeat.i(80934);
    if (Build.VERSION.SDK_INT > 10)
    {
      if (getForceOrientation() == -1)
      {
        this.landscapeMode = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 4).getBoolean("settings_landscape_mode", false);
        if (this.landscapeMode)
        {
          setRequestedOrientation(2);
          AppMethodBeat.o(80934);
          return;
        }
        setRequestedOrientation(1);
        AppMethodBeat.o(80934);
        return;
      }
      setRequestedOrientation(getForceOrientation());
      AppMethodBeat.o(80934);
      return;
    }
    super.setMMOrientation();
    AppMethodBeat.o(80934);
  }
  
  final class a
    extends com.tencent.mm.plugin.webview.ui.tools.b
  {
    public a(WebViewUI paramWebViewUI)
    {
      super();
    }
    
    public final Object onMiscCallBack(String paramString, Bundle paramBundle)
    {
      AppMethodBeat.i(80907);
      Object localObject = GameWebViewUI.j(GameWebViewUI.this).onMiscCallBack(paramString, paramBundle);
      if (localObject != null)
      {
        AppMethodBeat.o(80907);
        return localObject;
      }
      paramString = super.onMiscCallBack(paramString, paramBundle);
      AppMethodBeat.o(80907);
      return paramString;
    }
  }
  
  protected final class b
    extends WebViewUI.b
  {
    protected b()
    {
      super();
    }
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(80908);
      if (GameWebViewUI.j(GameWebViewUI.this) != null) {
        GameWebViewUI.j(GameWebViewUI.this).a(paramConsoleMessage);
      }
      boolean bool = super.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(80908);
      return bool;
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.webview.core.k
  {
    a Qpc;
    
    private c()
    {
      AppMethodBeat.i(230016);
      this.Qpc = new a((byte)0);
      AppMethodBeat.o(230016);
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(230022);
      if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null))
      {
        AppMethodBeat.o(230022);
        return null;
      }
      paramWebView = GameWebViewUI.j(GameWebViewUI.this).a(paramWebView, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest);
      AppMethodBeat.o(230022);
      return paramWebView;
    }
    
    public final j bXJ()
    {
      AppMethodBeat.i(230019);
      b localb = new b((byte)0);
      AppMethodBeat.o(230019);
      return localb;
    }
    
    public final com.tencent.mm.plugin.webview.core.f gTb()
    {
      return this.Qpc;
    }
    
    final class a
      extends GameBaseWebViewUI.a
    {
      private a()
      {
        super();
      }
      
      public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
      {
        AppMethodBeat.i(267856);
        GameWebViewUI.A(GameWebViewUI.this);
        super.a(paramWebView, paramInt, paramString1, paramString2);
        AppMethodBeat.o(267856);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(267855);
        if (GameWebViewUI.w(GameWebViewUI.this).jTP == 0L) {
          GameWebViewUI.w(GameWebViewUI.this).jTP = System.currentTimeMillis();
        }
        if (GameWebViewUI.x(GameWebViewUI.this).Qou == 0L) {
          GameWebViewUI.x(GameWebViewUI.this).Qou = System.currentTimeMillis();
        }
        GameWebViewUI.A(GameWebViewUI.this);
        GameWebViewUI.j(GameWebViewUI.this).boh(paramString);
        super.b(paramWebView, paramString);
        AppMethodBeat.o(267855);
      }
      
      public final void h(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(267854);
        if (GameWebViewUI.w(GameWebViewUI.this).jTO == 0L) {
          GameWebViewUI.w(GameWebViewUI.this).jTO = System.currentTimeMillis();
        }
        if (GameWebViewUI.x(GameWebViewUI.this).Qot == 0L) {
          GameWebViewUI.x(GameWebViewUI.this).Qot = System.currentTimeMillis();
        }
        GameWebViewUI.j(GameWebViewUI.this).bog(paramString);
        AppMethodBeat.o(267854);
      }
    }
    
    final class b
      extends j
    {
      private b() {}
      
      public final void bjH(String paramString)
      {
        AppMethodBeat.i(226813);
        if (GameWebViewUI.w(GameWebViewUI.this).jTR == 0L) {
          GameWebViewUI.w(GameWebViewUI.this).jTR = System.currentTimeMillis();
        }
        if (GameWebViewUI.x(GameWebViewUI.this).Qow == 0L) {
          GameWebViewUI.x(GameWebViewUI.this).Qow = System.currentTimeMillis();
        }
        GameWebViewUI.y(GameWebViewUI.this);
        if (GameWebViewUI.z(GameWebViewUI.this)) {
          GameWebViewUI.c(GameWebViewUI.this);
        }
        AppMethodBeat.o(226813);
      }
      
      public final void bv(int paramInt, String paramString)
      {
        AppMethodBeat.i(226811);
        if (GameWebViewUI.w(GameWebViewUI.this).jTQ == 0L) {
          GameWebViewUI.w(GameWebViewUI.this).jTQ = System.currentTimeMillis();
        }
        if (GameWebViewUI.x(GameWebViewUI.this).Qov == 0L) {
          GameWebViewUI.x(GameWebViewUI.this).Qov = System.currentTimeMillis();
        }
        AppMethodBeat.o(226811);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI
 * JD-Core Version:    0.7.0.1
 */