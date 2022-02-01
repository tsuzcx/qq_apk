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
import com.tencent.mm.plugin.game.protobuf.dv;
import com.tencent.mm.plugin.webview.core.f;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.d.h.79;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.model.az.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x;
import com.tencent.xweb.z;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GameWebViewUI
  extends GameBaseWebViewUI
  implements e
{
  private static String Jrn = "wx_fullscreen";
  public com.tencent.mm.plugin.wepkg.e JpX;
  private boolean JrA;
  private boolean JrB;
  private boolean Jrm;
  private HashMap<String, String> Jro;
  private Drawable Jrp;
  private Drawable Jrq;
  private String Jrr;
  private Map<Integer, coq> Jrs;
  private String Jrt;
  private GameMenuImageButton Jru;
  private boolean Jrv;
  private boolean Jrw;
  private boolean Jrx;
  private ViewGroup Jry;
  private c Jrz;
  private boolean xvW;
  private long xyL;
  public g xyM;
  public GameWebPerformanceInfo xyv;
  private boolean xyw;
  private Object xyx;
  
  public GameWebViewUI()
  {
    AppMethodBeat.i(80915);
    this.xvW = false;
    this.Jrm = false;
    this.Jro = new HashMap();
    this.Jrr = null;
    this.Jrs = new HashMap();
    this.Jrw = false;
    this.xyw = false;
    this.xyx = new Object();
    this.Jrz = new c((byte)0);
    this.JrA = false;
    this.JrB = false;
    AppMethodBeat.o(80915);
  }
  
  private m ghh()
  {
    AppMethodBeat.i(80918);
    try
    {
      List localList = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.JrL;
      new Bundle().putString("game_hv_menu_appid", this.Jrt);
      this.Jrs.clear();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        coq localcoq = (coq)localIterator.next();
        this.Jrs.put(Integer.valueOf(localcoq.MuO), localcoq);
      }
      localm = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.c(this, localException);
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Wepkg.GameWebViewUI", "get cache hv game menu fail! exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(80918);
      return null;
    }
    m localm;
    AppMethodBeat.o(80918);
    return localm;
  }
  
  private void ghi()
  {
    AppMethodBeat.i(80937);
    if (this.JhW != null) {
      this.JhW.setVisibility(0);
    }
    AppMethodBeat.o(80937);
  }
  
  public final void aG(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211325);
    super.aG(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(211325);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(80925);
    if (this.Jrv) {
      super.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    AppMethodBeat.o(80925);
  }
  
  public final void bXg()
  {
    AppMethodBeat.i(80923);
    super.bXg();
    this.Jrv = true;
    int i;
    if ((this.xvW) || (this.xPq != null) || (this.xPp != 0)) {
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i != 0)
      {
        localObject = com.tencent.mm.plugin.game.commlib.a.dSU();
        if ((localObject == null) || (Util.isNullOrNil(((dv)localObject).ixw)) || (Util.isNullOrNil(((dv)localObject).xNo))) {}
      }
      try
      {
        if (ao.isDarkMode()) {}
        for (this.xPp = Color.parseColor(((dv)localObject).xNo);; this.xPp = Color.parseColor(((dv)localObject).ixw))
        {
          this.xPq = ((dv)localObject).xHA;
          gfs();
          zj(true);
          localObject = getIntent();
          if ((localObject == null) || (!((Intent)localObject).getBooleanExtra("game_check_float", false))) {
            break label421;
          }
          i = ((Intent)localObject).getIntExtra("game_sourceScene", 0);
          this.Jrr = ((Intent)localObject).getStringExtra("game_transparent_float_url");
          if (!Util.isNullOrNil(this.Jrr)) {
            break label247;
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("game_check_float", true);
          ((Intent)localObject).putExtra("game_sourceScene", i);
          com.tencent.mm.br.c.b(this, "game", ".ui.GameCenterUI", (Intent)localObject);
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
          if (this.mHh != null) {
            this.mHh.j(91, (Bundle)localObject);
          }
          if (this.JpK == null) {
            this.JpK = new a(this, this.Jie, this.Jrr);
          }
          localObject = this.JpK;
          String str = this.Jrr;
          ((a)localObject).xyo = str;
          ((a)localObject).JpX.m(str, false, false);
          if ((((a)localObject).iGY != null) && (((a)localObject).iGY.getParent() == null))
          {
            ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
            ((a)localObject).WN.addView(((a)localObject).iGY, localLayoutParams);
          }
          if ((((a)localObject).iGY != null) && (((a)localObject).JpY != null)) {
            ((a)localObject).iGY.post(new a.3((a)localObject, str));
          }
          this.Jrr = null;
          AppMethodBeat.o(80923);
          return;
        }
        catch (RemoteException localRemoteException) {}
        label421:
        AppMethodBeat.o(80923);
      }
    }
  }
  
  public final void bb(Bundle paramBundle)
  {
    AppMethodBeat.i(80922);
    super.bb(paramBundle);
    AppMethodBeat.o(80922);
  }
  
  public final void cpD()
  {
    AppMethodBeat.i(80919);
    if (this.Jjm.Jgr) {
      this.Jjm.geN();
    }
    if ((this.Jru == null) || (!this.Jru.pKn))
    {
      super.cpD();
      AppMethodBeat.o(80919);
      return;
    }
    final com.tencent.mm.plugin.webview.ui.tools.game.menu.d locald = new com.tencent.mm.plugin.webview.ui.tools.game.menu.d(getContext());
    locald.a(new b.c()
    {
      public final void c(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(80900);
        paramAnonymousMenuItem = (coq)GameWebViewUI.l(GameWebViewUI.this).get(Integer.valueOf(paramAnonymousMenuItem.getItemId()));
        if (paramAnonymousMenuItem == null)
        {
          AppMethodBeat.o(80900);
          return;
        }
        switch (GameWebViewUI.8.JrF[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.agZ(paramAnonymousMenuItem.KWb).ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(80900);
          return;
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramAnonymousMenuItem.LPS);
          com.tencent.mm.br.c.b(GameWebViewUI.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          AppMethodBeat.o(80900);
          return;
          GameWebViewUI.this.IMs.gdh().C(new Object[] { GameWebViewUI.this.coX(), Integer.valueOf(32), Integer.valueOf(1) }).report();
          if (!GameWebViewUI.m(GameWebViewUI.this))
          {
            GameWebViewUI.this.finish();
            AppMethodBeat.o(80900);
            return;
            paramAnonymousMenuItem = GameWebViewUI.this.getIntent().getStringExtra("KPublisherId");
            localObject = GameWebViewUI.this.getIntent().getStringExtra("KAppId");
            String str = GameWebViewUI.this.getIntent().getStringExtra("srcUsername");
            GameWebViewUI.this.IMs.gdh().C(new Object[] { GameWebViewUI.this.coX(), Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem, localObject, str }).report();
            GameWebViewUI.n(GameWebViewUI.this);
            AppMethodBeat.o(80900);
            return;
            GameWebViewUI.this.IMs.gdh().C(new Object[] { GameWebViewUI.this.coX(), Integer.valueOf(3), Integer.valueOf(1) }).report();
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(157L, 6L, 1L, false);
            GameWebViewUI.o(GameWebViewUI.this);
            AppMethodBeat.o(80900);
            return;
            GameWebViewUI.this.IMs.gdh().C(new Object[] { GameWebViewUI.this.coX(), Integer.valueOf(10), Integer.valueOf(1) }).report();
            if (GameWebViewUI.p(GameWebViewUI.this) != null)
            {
              GameWebViewUI.q(GameWebViewUI.this).reload();
              AppMethodBeat.o(80900);
              return;
              GameWebViewUI.this.IMs.gdh().C(new Object[] { GameWebViewUI.this.coX(), Integer.valueOf(31), Integer.valueOf(1) }).report();
              GameWebViewUI.r(GameWebViewUI.this);
              AppMethodBeat.o(80900);
              return;
              GameWebViewUI.this.IMs.gdh().C(new Object[] { GameWebViewUI.this.coX(), Integer.valueOf(11), Integer.valueOf(1) }).report();
              GameWebViewUI.s(GameWebViewUI.this);
              AppMethodBeat.o(80900);
              return;
              if (GameWebViewUI.this.IBw != null)
              {
                localObject = GameWebViewUI.this.IBw;
                int i = paramAnonymousMenuItem.MuO;
                if (!((com.tencent.mm.plugin.webview.d.h)localObject).GBl)
                {
                  Log.e("MicroMsg.JsApiHandler", "not ready");
                  AppMethodBeat.o(80900);
                  return;
                }
                Log.i("MicroMsg.JsApiHandler", "onCustomGameMenuClicked");
                paramAnonymousMenuItem = new HashMap();
                paramAnonymousMenuItem.put("itemId", Integer.valueOf(i));
                MMHandlerThread.postToMainThread(new h.79((com.tencent.mm.plugin.webview.d.h)localObject, n.a.b("onCustomGameMenuClicked", paramAnonymousMenuItem, ((com.tencent.mm.plugin.webview.d.h)localObject).IRj, ((com.tencent.mm.plugin.webview.d.h)localObject).zpY)));
              }
            }
          }
        }
      }
    });
    locald.Jsa = new b.b()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(80901);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(480L, 0L, 1L, false);
        m localm = GameWebViewUI.t(GameWebViewUI.this);
        if (localm != null) {
          paramAnonymousm.ORD.addAll(localm.ORD);
        }
        AppMethodBeat.o(80901);
      }
    };
    if (this.Jig) {
      locald.mLN = true;
    }
    for (locald.mLO = true; (this.Jik != null) && (this.Jik.isShown()); locald.mLO = false)
    {
      this.Jik.hide();
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
          locald.dGm();
          AppMethodBeat.o(80902);
        }
      }, 100L);
      AppMethodBeat.o(80919);
      return;
      locald.mLN = false;
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
        locald.dGm();
        AppMethodBeat.o(80903);
      }
    }, 100L);
    AppMethodBeat.o(80919);
  }
  
  public final i cpO()
  {
    AppMethodBeat.i(211324);
    i locali = super.cpO();
    if (locali != null) {
      locali.a(this.Jrz);
    }
    AppMethodBeat.o(211324);
    return locali;
  }
  
  public boolean cpz()
  {
    AppMethodBeat.i(80938);
    getIntent().putExtra("minimize_secene", 2);
    AppMethodBeat.o(80938);
    return true;
  }
  
  public final Map<Integer, Object> dTR()
  {
    AppMethodBeat.i(211326);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(d.a.Jqn), ghj());
    localHashMap.put(Integer.valueOf(d.a.Jqo), NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()));
    localHashMap.put(Integer.valueOf(d.a.Jqp), String.valueOf(YearClass.get(MMApplicationContext.getContext())));
    String str = coX();
    try
    {
      localHashMap.put(Integer.valueOf(d.a.Jqq), com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(str), "UTF-8"));
      label92:
      localHashMap.put(Integer.valueOf(d.a.Jqr), Boolean.valueOf(this.JpX.bci(str)));
      localHashMap.put(Integer.valueOf(d.a.Jqs), Integer.valueOf(0));
      localHashMap.put(Integer.valueOf(d.a.Jqt), Integer.valueOf(0));
      localHashMap.put(Integer.valueOf(d.a.Jqu), this.JpX.gkx());
      localHashMap.put(Integer.valueOf(d.a.Jqv), com.tencent.mm.plugin.wepkg.e.gky());
      AppMethodBeat.o(211326);
      return localHashMap;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label92;
    }
  }
  
  public final Map<Integer, Object> dTS()
  {
    AppMethodBeat.i(211327);
    HashMap localHashMap = new HashMap();
    g localg = g.baL(coX());
    if (localg != null)
    {
      localHashMap.put(Integer.valueOf(d.b.Jqy), Long.valueOf(localg.JqV - localg.startTime));
      localHashMap.put(Integer.valueOf(d.b.Jqz), Long.valueOf(localg.JqW - localg.startTime));
      localHashMap.put(Integer.valueOf(d.b.JqA), Long.valueOf(localg.JqX - localg.JqW));
      localHashMap.put(Integer.valueOf(d.b.JqB), Long.valueOf(localg.JqZ - localg.JqY));
      localHashMap.put(Integer.valueOf(d.b.JqC), Long.valueOf(localg.Jrb - localg.Jra));
      localHashMap.put(Integer.valueOf(d.b.JqK), Long.valueOf(localg.Jrc));
    }
    localHashMap.put(Integer.valueOf(d.b.JqL), Integer.valueOf(0));
    AppMethodBeat.o(211327);
    return localHashMap;
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(80929);
    this.xyv.hhM = System.currentTimeMillis();
    int i = super.getLayoutId();
    AppMethodBeat.o(80929);
    return i;
  }
  
  public final void gfA()
  {
    AppMethodBeat.i(80931);
    super.gfA();
    this.Jrt = getIntent().getStringExtra("game_hv_menu_appid");
    if ((this.Jig) && (!Util.isNullOrNil(this.Jrt)))
    {
      if (this.Jif != null) {
        this.Jif.setVisibility(8);
      }
      this.Jru.a(this.Jid, new GameMenuImageButton.a()
      {
        public final void dlk()
        {
          AppMethodBeat.i(80904);
          GameWebViewUI.this.cpD();
          AppMethodBeat.o(80904);
        }
      });
    }
    AppMethodBeat.o(80931);
  }
  
  public final x gfC()
  {
    try
    {
      AppMethodBeat.i(80917);
      if (this.JiG == null) {
        this.JiG = new b();
      }
      x localx = this.JiG;
      AppMethodBeat.o(80917);
      return localx;
    }
    finally {}
  }
  
  public final int gfz()
  {
    AppMethodBeat.i(80921);
    int i = super.gfz();
    AppMethodBeat.o(80921);
    return i;
  }
  
  public final String ghj()
  {
    AppMethodBeat.i(211328);
    String str = (hashCode() & 0x7FFFFFFF) + "_" + (coX().hashCode() & 0x7FFFFFFF);
    AppMethodBeat.o(211328);
    return str;
  }
  
  public void initView()
  {
    AppMethodBeat.i(80930);
    super.initView();
    this.Jrp = new ColorDrawable(android.support.v4.content.b.n(this, 2131099897));
    this.Jrq = new ColorDrawable(android.support.v4.content.b.n(this, 2131099897));
    this.xyv.hhN = System.currentTimeMillis();
    this.xyM.JqV = System.currentTimeMillis();
    AppMethodBeat.o(80930);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(80933);
    if (this.xyv.hhP == 0L) {
      this.xyv.hhP = System.currentTimeMillis();
    }
    if (this.JpX.gkw())
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
    if (((com.tencent.mm.api.q)com.tencent.mm.kernel.g.af(com.tencent.mm.api.q.class)).Vt())
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
        Log.i("MicroMsg.Wepkg.GameWebViewUI", "rawUrl rid:%s, pkgId:%s", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.bcQ(str1), com.tencent.mm.plugin.wepkg.utils.d.bcO(str1) });
        if (getIntent().getLongExtra("gamecenterui_createtime", 0L) > 0L)
        {
          this.xyv = GameWebPerformanceInfo.Fd(str1);
          this.xyv.url = str1;
          this.xyv.hhu = ghj();
          this.xyv.hhE = getIntent().getLongExtra("gamecenterui_createtime", 0L);
          this.xyv.hhF = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
          this.xyv.startTime = getIntent().getLongExtra("start_time", this.xyv.hhF);
          this.xyv.hhK = System.currentTimeMillis();
          this.xyv.hhy = 1;
          Log.i("MicroMsg.Wepkg.GameWebViewUI", "onCreate, startTime: %d, gameCenterUICreate: %d, startWebUI: %d,webUICreate: %d", new Object[] { Long.valueOf(this.xyv.startTime), Long.valueOf(this.xyv.hhE), Long.valueOf(this.xyv.hhF), Long.valueOf(this.xyv.hhK) });
          this.xyM = g.baJ(str1);
          this.xyM.startTime = System.currentTimeMillis();
          this.JpX = new com.tencent.mm.plugin.wepkg.e();
          super.onCreate(paramBundle);
          if (this.pGj != null) {
            this.pGj.getSettings().setForceDarkBehavior(1);
          }
          paramBundle = getIntent();
          if ((paramBundle != null) && (paramBundle.getBooleanExtra("disable_progress_bar", false)))
          {
            this.JhV.olx = false;
            ghi();
          }
          if (this.pGj.getIsX5Kernel()) {
            this.pGj.setWebViewClientExtension(new a(this));
          }
          this.JpX.JLI = new com.tencent.mm.plugin.wepkg.event.b()
          {
            public final void dTT()
            {
              AppMethodBeat.i(80897);
              Log.i("MicroMsg.Wepkg.GameWebViewUI", "onReload");
              GameWebViewUI.a(GameWebViewUI.this);
              if (GameWebViewUI.b(GameWebViewUI.this)) {
                GameWebViewUI.c(GameWebViewUI.this);
              }
              AppMethodBeat.o(80897);
            }
            
            public final void dTU()
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
            
            public final void pL(final boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(80899);
              GameWebViewUI.k(GameWebViewUI.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(80896);
                  com.tencent.mm.plugin.wepkg.e locale;
                  String str;
                  if (GameWebViewUI.d(GameWebViewUI.this))
                  {
                    GameWebViewUI.a(GameWebViewUI.this, false);
                    GameWebViewUI.g(GameWebViewUI.this);
                    if (paramAnonymousBoolean)
                    {
                      GameWebViewUI.h(GameWebViewUI.this).stopLoading();
                      locale = GameWebViewUI.j(GameWebViewUI.this);
                      str = GameWebViewUI.1.this.jNG;
                      if (GameWebViewUI.i(GameWebViewUI.this)) {
                        break label125;
                      }
                    }
                  }
                  label125:
                  for (boolean bool = true;; bool = false)
                  {
                    locale.m(str, bool, false);
                    GameWebViewUI.a(GameWebViewUI.this, GameWebViewUI.1.this.jNG);
                    AppMethodBeat.o(80896);
                    return;
                  }
                }
              });
              AppMethodBeat.o(80899);
            }
          };
          this.Jrx = getIntent().getBooleanExtra("open_game_float", false);
          paramBundle = this.JpX;
          if (this.Jrx) {
            break label549;
          }
        }
        label549:
        for (boolean bool = true;; bool = false)
        {
          if (paramBundle.m(str1, bool, false))
          {
            Log.i("MicroMsg.Wepkg.GameWebViewUI", "current page use wepkg");
            this.Jrw = true;
            ghi();
          }
          this.Jru = new GameMenuImageButton(getContext());
          AppMethodBeat.o(80916);
          return;
          this.xyv = GameWebPerformanceInfo.Fe(str1);
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
    this.IMH.b(this.Jrz);
    this.IMH.b(this.Jrz.JrG);
    super.onDestroy();
    this.JpX.zE(this.Jrx);
    this.xyv.hhV = System.currentTimeMillis();
    com.tencent.mm.game.report.api.a.hhr.a(this.xyv);
    GameWebPerformanceInfo.Ff(coX());
    d.a(ghj(), this);
    g.baM(coX());
    AppMethodBeat.o(80928);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80927);
    super.onPause();
    GameWebPerformanceInfo localGameWebPerformanceInfo = this.xyv;
    localGameWebPerformanceInfo.hhU += System.currentTimeMillis() - this.xyL;
    AppMethodBeat.o(80927);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80926);
    super.onResume();
    if (this.xyv.hhL == 0L)
    {
      long l = System.currentTimeMillis();
      Log.i("MicroMsg.Wepkg.GameWebViewUI", "onResume: ".concat(String.valueOf(l)));
      this.xyv.hhL = l;
    }
    this.xyL = System.currentTimeMillis();
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
  
  public final void zj(boolean paramBoolean)
  {
    AppMethodBeat.i(80924);
    super.zj(paramBoolean);
    zl(false);
    AppMethodBeat.o(80924);
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
    extends k
  {
    a JrG;
    
    private c()
    {
      AppMethodBeat.i(211321);
      this.JrG = new a((byte)0);
      AppMethodBeat.o(211321);
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(211323);
      if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null))
      {
        AppMethodBeat.o(211323);
        return null;
      }
      paramWebView = GameWebViewUI.j(GameWebViewUI.this).p(paramWebView, paramWebResourceRequest.getUrl().toString());
      AppMethodBeat.o(211323);
      return paramWebView;
    }
    
    public final f gai()
    {
      return this.JrG;
    }
    
    public final com.tencent.mm.plugin.webview.core.j gaj()
    {
      AppMethodBeat.i(211322);
      b localb = new b((byte)0);
      AppMethodBeat.o(211322);
      return localb;
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
        AppMethodBeat.i(211318);
        GameWebViewUI.A(GameWebViewUI.this);
        super.a(paramWebView, paramInt, paramString1, paramString2);
        AppMethodBeat.o(211318);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(211317);
        if (GameWebViewUI.w(GameWebViewUI.this).hhR == 0L) {
          GameWebViewUI.w(GameWebViewUI.this).hhR = System.currentTimeMillis();
        }
        if (GameWebViewUI.x(GameWebViewUI.this).JqX == 0L) {
          GameWebViewUI.x(GameWebViewUI.this).JqX = System.currentTimeMillis();
        }
        GameWebViewUI.A(GameWebViewUI.this);
        GameWebViewUI.j(GameWebViewUI.this).bch(paramString);
        super.b(paramWebView, paramString);
        AppMethodBeat.o(211317);
      }
      
      public final void i(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(211316);
        if (GameWebViewUI.w(GameWebViewUI.this).hhQ == 0L) {
          GameWebViewUI.w(GameWebViewUI.this).hhQ = System.currentTimeMillis();
        }
        if (GameWebViewUI.x(GameWebViewUI.this).JqW == 0L) {
          GameWebViewUI.x(GameWebViewUI.this).JqW = System.currentTimeMillis();
        }
        GameWebViewUI.j(GameWebViewUI.this).bcg(paramString);
        AppMethodBeat.o(211316);
      }
    }
    
    final class b
      extends com.tencent.mm.plugin.webview.core.j
    {
      private b() {}
      
      public final void aXN(String paramString)
      {
        AppMethodBeat.i(211320);
        if (GameWebViewUI.w(GameWebViewUI.this).hhT == 0L) {
          GameWebViewUI.w(GameWebViewUI.this).hhT = System.currentTimeMillis();
        }
        if (GameWebViewUI.x(GameWebViewUI.this).JqZ == 0L) {
          GameWebViewUI.x(GameWebViewUI.this).JqZ = System.currentTimeMillis();
        }
        GameWebViewUI.y(GameWebViewUI.this);
        if (GameWebViewUI.z(GameWebViewUI.this)) {
          GameWebViewUI.c(GameWebViewUI.this);
        }
        AppMethodBeat.o(211320);
      }
      
      public final void by(int paramInt, String paramString)
      {
        AppMethodBeat.i(211319);
        if (GameWebViewUI.w(GameWebViewUI.this).hhS == 0L) {
          GameWebViewUI.w(GameWebViewUI.this).hhS = System.currentTimeMillis();
        }
        if (GameWebViewUI.x(GameWebViewUI.this).JqY == 0L) {
          GameWebViewUI.x(GameWebViewUI.this).JqY = System.currentTimeMillis();
        }
        AppMethodBeat.o(211319);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI
 * JD-Core Version:    0.7.0.1
 */