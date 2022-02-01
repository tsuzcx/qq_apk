package com.tencent.mm.plugin.webview.ui.tools.game;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.protobuf.ea;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.core.l;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.j.80;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.model.ba.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.o;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.protocal.protobuf.doh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import com.tencent.xweb.z;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GameWebViewUI
  extends GameBaseWebViewUI
  implements f
{
  private static String XgY = "wx_fullscreen";
  private String Eeu;
  private boolean ItB;
  private GameWebPerformanceInfo IwE;
  private boolean IwF;
  private Object IwG;
  private long IwU;
  private h IwV;
  private com.tencent.mm.plugin.wepkg.f XfF;
  private boolean XgX;
  private HashMap<String, String> XgZ;
  private Drawable Xha;
  private Drawable Xhb;
  private String Xhc;
  private Map<Integer, doh> Xhd;
  private GameMenuImageButton Xhe;
  private boolean Xhf;
  private boolean Xhg;
  private boolean Xhh;
  private ViewGroup Xhi;
  private c Xhj;
  private boolean Xhk;
  private boolean Xhl;
  
  public GameWebViewUI()
  {
    AppMethodBeat.i(80915);
    this.ItB = false;
    this.XgX = false;
    this.XgZ = new HashMap();
    this.Xhc = null;
    this.Xhd = new HashMap();
    this.Xhg = false;
    this.IwF = false;
    this.IwG = new Object();
    this.Xhj = new c((byte)0);
    this.Xhk = false;
    this.Xhl = false;
    AppMethodBeat.o(80915);
  }
  
  private s iAN()
  {
    AppMethodBeat.i(80918);
    try
    {
      List localList = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.Xhv;
      new Bundle().putString("game_hv_menu_appid", this.Eeu);
      this.Xhd.clear();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        doh localdoh = (doh)localIterator.next();
        this.Xhd.put(Integer.valueOf(localdoh.aaVm), localdoh);
      }
      locals = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.e(this, localException);
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Wepkg.GameWebViewUI", "get cache hv game menu fail! exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(80918);
      return null;
    }
    s locals;
    AppMethodBeat.o(80918);
    return locals;
  }
  
  private void iAO()
  {
    AppMethodBeat.i(80937);
    if (this.WWS != null) {
      this.WWS.setVisibility(0);
    }
    AppMethodBeat.o(80937);
  }
  
  public final void IN(boolean paramBoolean)
  {
    AppMethodBeat.i(80924);
    super.IN(paramBoolean);
    IR(false);
    AppMethodBeat.o(80924);
  }
  
  public final void aQ(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(297123);
    super.aQ(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(297123);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(80925);
    if (this.Xhf) {
      super.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    AppMethodBeat.o(80925);
  }
  
  public final void bl(Bundle paramBundle)
  {
    AppMethodBeat.i(80922);
    super.bl(paramBundle);
    AppMethodBeat.o(80922);
  }
  
  public final void cKX()
  {
    AppMethodBeat.i(80923);
    super.cKX();
    this.Xhf = true;
    int i;
    if ((this.ItB) || (this.INP != null) || (this.INO != 0)) {
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i != 0)
      {
        localObject = com.tencent.mm.plugin.game.commlib.a.fDS();
        if ((localObject == null) || (Util.isNullOrNil(((ea)localObject).nRQ)) || (Util.isNullOrNil(((ea)localObject).ILO))) {}
      }
      try
      {
        if (aw.isDarkMode()) {}
        for (this.INO = Color.parseColor(((ea)localObject).ILO);; this.INO = Color.parseColor(((ea)localObject).nRQ))
        {
          this.INP = ((ea)localObject).IFK;
          iyz();
          IN(true);
          localObject = getIntent();
          if ((localObject == null) || (!((Intent)localObject).getBooleanExtra("game_check_float", false))) {
            break label421;
          }
          i = ((Intent)localObject).getIntExtra("game_sourceScene", 0);
          this.Xhc = ((Intent)localObject).getStringExtra("game_transparent_float_url");
          if (!Util.isNullOrNil(this.Xhc)) {
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
          if (this.sLC != null) {
            this.sLC.m(91, (Bundle)localObject);
          }
          if (this.Xft == null) {
            this.Xft = new b(this, this.WWZ, this.Xhc);
          }
          localObject = this.Xft;
          String str = this.Xhc;
          ((b)localObject).Iwy = str;
          ((b)localObject).XfF.q(str, false, false);
          if ((((b)localObject).ooz != null) && (((b)localObject).ooz.getParent() == null))
          {
            ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
            ((b)localObject).bxO.addView(((b)localObject).ooz, localLayoutParams);
          }
          if ((((b)localObject).ooz != null) && (((b)localObject).XfG != null)) {
            ((b)localObject).ooz.post(new b.3((b)localObject, str));
          }
          this.Xhc = null;
          AppMethodBeat.o(80923);
          return;
        }
        catch (RemoteException localRemoteException) {}
        label421:
        AppMethodBeat.o(80923);
      }
    }
  }
  
  public final k dhx()
  {
    AppMethodBeat.i(297111);
    k localk = super.dhx();
    if (localk != null) {
      localk.a(this.Xhj);
    }
    AppMethodBeat.o(297111);
    return localk;
  }
  
  public boolean dhz()
  {
    AppMethodBeat.i(80938);
    getIntent().putExtra("minimize_secene", 2);
    AppMethodBeat.o(80938);
    return true;
  }
  
  public final Map<Integer, Object> fEU()
  {
    AppMethodBeat.i(297198);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(e.a.XfY), iAR());
    localHashMap.put(Integer.valueOf(e.a.XfZ), NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()));
    localHashMap.put(Integer.valueOf(e.a.Xga), String.valueOf(com.c.a.b.aH(MMApplicationContext.getContext())));
    String str = dgY();
    try
    {
      localHashMap.put(Integer.valueOf(e.a.Xgb), com.tencent.mm.compatible.util.r.as(Util.nullAsNil(str), "UTF-8"));
      label92:
      localHashMap.put(Integer.valueOf(e.a.Xgc), Boolean.valueOf(this.XfF.bnW(str)));
      localHashMap.put(Integer.valueOf(e.a.Xgd), Integer.valueOf(0));
      localHashMap.put(Integer.valueOf(e.a.Xge), Integer.valueOf(0));
      localHashMap.put(Integer.valueOf(e.a.Xgf), this.XfF.iEW());
      localHashMap.put(Integer.valueOf(e.a.Xgg), com.tencent.mm.plugin.wepkg.f.iEX());
      AppMethodBeat.o(297198);
      return localHashMap;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label92;
    }
  }
  
  public final Map<Integer, Object> fEV()
  {
    AppMethodBeat.i(297204);
    HashMap localHashMap = new HashMap();
    h localh = h.bmn(dgY());
    if (localh != null)
    {
      localHashMap.put(Integer.valueOf(e.b.Xgj), Long.valueOf(localh.XgG - localh.startTime));
      localHashMap.put(Integer.valueOf(e.b.Xgk), Long.valueOf(localh.XgH - localh.startTime));
      localHashMap.put(Integer.valueOf(e.b.Xgl), Long.valueOf(localh.XgI - localh.XgH));
      localHashMap.put(Integer.valueOf(e.b.Xgm), Long.valueOf(localh.XgK - localh.XgJ));
      localHashMap.put(Integer.valueOf(e.b.Xgn), Long.valueOf(localh.XgM - localh.XgL));
      localHashMap.put(Integer.valueOf(e.b.Xgv), Long.valueOf(localh.XgN));
    }
    localHashMap.put(Integer.valueOf(e.b.Xgw), Integer.valueOf(0));
    AppMethodBeat.o(297204);
    return localHashMap;
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(80929);
    this.IwE.muc = System.currentTimeMillis();
    int i = super.getLayoutId();
    AppMethodBeat.o(80929);
    return i;
  }
  
  public final com.tencent.mm.plugin.wepkg.f getWePkgPlugin()
  {
    return this.XfF;
  }
  
  public final void iAP()
  {
    AppMethodBeat.i(297219);
    this.IwV.XgL = System.currentTimeMillis();
    this.IwE.mtR = 1;
    AppMethodBeat.o(297219);
  }
  
  public final void iAQ()
  {
    AppMethodBeat.i(297223);
    this.IwV.XgM = System.currentTimeMillis();
    AppMethodBeat.o(297223);
  }
  
  public final String iAR()
  {
    AppMethodBeat.i(297230);
    String str = (hashCode() & 0x7FFFFFFF) + "_" + (dgY().hashCode() & 0x7FFFFFFF);
    AppMethodBeat.o(297230);
    return str;
  }
  
  public void initView()
  {
    AppMethodBeat.i(80930);
    super.initView();
    this.Xha = new ColorDrawable(androidx.core.content.a.w(this, c.c.actionbar_bg_color));
    this.Xhb = new ColorDrawable(androidx.core.content.a.w(this, c.c.actionbar_bg_color));
    this.IwE.mud = System.currentTimeMillis();
    this.IwV.XgG = System.currentTimeMillis();
    AppMethodBeat.o(80930);
  }
  
  public final void ixS()
  {
    AppMethodBeat.i(80919);
    if (this.WYi.WVr) {
      this.WYi.ixR();
    }
    if ((this.Xhe == null) || (!this.Xhe.Xhw))
    {
      super.ixS();
      AppMethodBeat.o(80919);
      return;
    }
    final com.tencent.mm.plugin.webview.ui.tools.game.menu.d locald = new com.tencent.mm.plugin.webview.ui.tools.game.menu.d(getContext());
    locald.a(new b.c()
    {
      public final void f(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(80900);
        paramAnonymousMenuItem = (doh)GameWebViewUI.l(GameWebViewUI.this).get(Integer.valueOf(paramAnonymousMenuItem.getItemId()));
        if (paramAnonymousMenuItem == null)
        {
          AppMethodBeat.o(80900);
          return;
        }
        switch (GameWebViewUI.8.Xhp[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.auL(paramAnonymousMenuItem.YVh).ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(80900);
          return;
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramAnonymousMenuItem.aako);
          com.tencent.mm.br.c.b(GameWebViewUI.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          AppMethodBeat.o(80900);
          return;
          GameWebViewUI.this.Wye.ivL().F(new Object[] { GameWebViewUI.this.dgY(), Integer.valueOf(32), Integer.valueOf(1) }).report();
          if (!GameWebViewUI.m(GameWebViewUI.this))
          {
            GameWebViewUI.this.finish();
            AppMethodBeat.o(80900);
            return;
            paramAnonymousMenuItem = GameWebViewUI.this.getIntent().getStringExtra("KPublisherId");
            localObject = GameWebViewUI.this.getIntent().getStringExtra("KAppId");
            String str = GameWebViewUI.this.getIntent().getStringExtra("srcUsername");
            GameWebViewUI.this.Wye.ivL().F(new Object[] { GameWebViewUI.this.dgY(), Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem, localObject, str }).report();
            GameWebViewUI.n(GameWebViewUI.this);
            AppMethodBeat.o(80900);
            return;
            GameWebViewUI.this.Wye.ivL().F(new Object[] { GameWebViewUI.this.dgY(), Integer.valueOf(3), Integer.valueOf(1) }).report();
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(157L, 6L, 1L, false);
            GameWebViewUI.o(GameWebViewUI.this);
            AppMethodBeat.o(80900);
            return;
            GameWebViewUI.this.Wye.ivL().F(new Object[] { GameWebViewUI.this.dgY(), Integer.valueOf(10), Integer.valueOf(1) }).report();
            if (GameWebViewUI.p(GameWebViewUI.this) != null)
            {
              GameWebViewUI.q(GameWebViewUI.this).reload();
              AppMethodBeat.o(80900);
              return;
              GameWebViewUI.this.Wye.ivL().F(new Object[] { GameWebViewUI.this.dgY(), Integer.valueOf(31), Integer.valueOf(1) }).report();
              GameWebViewUI.r(GameWebViewUI.this);
              AppMethodBeat.o(80900);
              return;
              GameWebViewUI.this.Wye.ivL().F(new Object[] { GameWebViewUI.this.dgY(), Integer.valueOf(11), Integer.valueOf(1) }).report();
              GameWebViewUI.s(GameWebViewUI.this);
              AppMethodBeat.o(80900);
              return;
              if (GameWebViewUI.this.WlX != null)
              {
                localObject = GameWebViewUI.this.WlX;
                int i = paramAnonymousMenuItem.aaVm;
                if (!((j)localObject).UcS)
                {
                  Log.e("MicroMsg.JsApiHandler", "not ready");
                  AppMethodBeat.o(80900);
                  return;
                }
                Log.i("MicroMsg.JsApiHandler", "onCustomGameMenuClicked");
                paramAnonymousMenuItem = new HashMap();
                paramAnonymousMenuItem.put("itemId", Integer.valueOf(i));
                MMHandlerThread.postToMainThread(new j.80((j)localObject, p.a.b("onCustomGameMenuClicked", paramAnonymousMenuItem, ((j)localObject).WDI, ((j)localObject).KQY)));
              }
            }
          }
        }
      }
    });
    locald.XhL = new b.b()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(80901);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(480L, 0L, 1L, false);
        s locals = GameWebViewUI.t(GameWebViewUI.this);
        if (locals != null) {
          paramAnonymouss.adRW.addAll(locals.adRW);
        }
        AppMethodBeat.o(80901);
      }
    };
    if (this.WXb) {
      locald.sRy = true;
    }
    for (locald.sRz = true; (this.WXi != null) && (this.WXi.isShown()); locald.sRz = false)
    {
      this.WXi.hide();
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80902);
          if ((GameWebViewUI.this.isFinishing()) || (GameWebViewUI.this.WYa))
          {
            Log.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
            AppMethodBeat.o(80902);
            return;
          }
          locald.dDn();
          AppMethodBeat.o(80902);
        }
      }, 100L);
      AppMethodBeat.o(80919);
      return;
      locald.sRy = false;
    }
    hideVKB();
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80903);
        if ((GameWebViewUI.this.isFinishing()) || (GameWebViewUI.this.WYa))
        {
          Log.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
          AppMethodBeat.o(80903);
          return;
        }
        locald.dDn();
        AppMethodBeat.o(80903);
      }
    }, 100L);
    AppMethodBeat.o(80919);
  }
  
  public final int iyH()
  {
    AppMethodBeat.i(80921);
    int i = super.iyH();
    AppMethodBeat.o(80921);
    return i;
  }
  
  public final void iyI()
  {
    AppMethodBeat.i(80931);
    super.iyI();
    this.Eeu = getIntent().getStringExtra("game_hv_menu_appid");
    if ((this.WXb) && (!Util.isNullOrNil(this.Eeu)))
    {
      if (this.WXa != null) {
        this.WXa.setVisibility(8);
      }
      this.Xhe.a(this.WWY, new GameMenuImageButton.a()
      {
        public final void eEp()
        {
          AppMethodBeat.i(80904);
          GameWebViewUI.this.ixS();
          AppMethodBeat.o(80904);
        }
      });
    }
    AppMethodBeat.o(80931);
  }
  
  public final z iyK()
  {
    try
    {
      AppMethodBeat.i(80917);
      if (this.WXD == null) {
        this.WXD = new b();
      }
      z localz = this.WXD;
      AppMethodBeat.o(80917);
      return localz;
    }
    finally {}
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(80933);
    if (this.IwE.muf == 0L) {
      this.IwE.muf = System.currentTimeMillis();
    }
    if (this.XfF.iEV())
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
    if (((com.tencent.mm.api.r)com.tencent.mm.kernel.h.ax(com.tencent.mm.api.r.class)).aBu())
    {
      str1 = "https://mp.weixin.qq.com/mp/readtemplate?t=appmsg/childmode";
      getIntent().putExtra("rawUrl", "https://mp.weixin.qq.com/mp/readtemplate?t=appmsg/childmode");
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
        Log.i("MicroMsg.Wepkg.GameWebViewUI", "rawUrl rid:%s, pkgId:%s", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.boD(str1), com.tencent.mm.plugin.wepkg.utils.d.boB(str1) });
        if (getIntent().getLongExtra("gamecenterui_createtime", 0L) > 0L)
        {
          this.IwE = GameWebPerformanceInfo.EI(str1);
          this.IwE.url = str1;
          this.IwE.mtK = iAR();
          this.IwE.mtU = getIntent().getLongExtra("gamecenterui_createtime", 0L);
          this.IwE.mtV = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
          this.IwE.startTime = getIntent().getLongExtra("start_time", this.IwE.mtV);
          this.IwE.mua = System.currentTimeMillis();
          this.IwE.mtO = 1;
          Log.i("MicroMsg.Wepkg.GameWebViewUI", "onCreate, startTime: %d, gameCenterUICreate: %d, startWebUI: %d,webUICreate: %d", new Object[] { Long.valueOf(this.IwE.startTime), Long.valueOf(this.IwE.mtU), Long.valueOf(this.IwE.mtV), Long.valueOf(this.IwE.mua) });
          this.IwV = h.bml(str1);
          this.IwV.startTime = System.currentTimeMillis();
          this.XfF = new com.tencent.mm.plugin.wepkg.f();
          super.onCreate(paramBundle);
          if (this.sMP != null) {
            this.sMP.getSettings().setForceDarkBehavior(1);
          }
          paramBundle = getIntent();
          if ((paramBundle != null) && (paramBundle.getBooleanExtra("disable_progress_bar", false)))
          {
            this.WWR.uxP = false;
            iAO();
          }
          if (this.sMP.getIsX5Kernel()) {
            this.sMP.setWebViewClientExtension(new a(this));
          }
          this.XfF.XEA = new com.tencent.mm.plugin.wepkg.event.b()
          {
            public final void fEX()
            {
              AppMethodBeat.i(80897);
              Log.i("MicroMsg.Wepkg.GameWebViewUI", "onReload");
              GameWebViewUI.a(GameWebViewUI.this);
              if (GameWebViewUI.b(GameWebViewUI.this)) {
                GameWebViewUI.c(GameWebViewUI.this);
              }
              AppMethodBeat.o(80897);
            }
            
            public final void fEY()
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
            
            public final void wo(final boolean paramAnonymousBoolean)
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
                      str = GameWebViewUI.1.this.pBq;
                      if (GameWebViewUI.i(GameWebViewUI.this)) {
                        break label125;
                      }
                    }
                  }
                  label125:
                  for (boolean bool = true;; bool = false)
                  {
                    localf.q(str, bool, false);
                    GameWebViewUI.a(GameWebViewUI.this, GameWebViewUI.1.this.pBq);
                    AppMethodBeat.o(80896);
                    return;
                  }
                }
              });
              AppMethodBeat.o(80899);
            }
          };
          this.Xhh = getIntent().getBooleanExtra("open_game_float", false);
          paramBundle = this.XfF;
          if (this.Xhh) {
            break label549;
          }
        }
        label549:
        for (boolean bool = true;; bool = false)
        {
          if (paramBundle.q(str1, bool, false))
          {
            Log.i("MicroMsg.Wepkg.GameWebViewUI", "current page use wepkg");
            this.Xhg = true;
            iAO();
          }
          this.Xhe = new GameMenuImageButton(getContext());
          AppMethodBeat.o(80916);
          return;
          this.IwE = GameWebPerformanceInfo.EJ(str1);
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
    this.Wzl.b(this.Xhj);
    this.Wzl.b(this.Xhj.Xhq);
    super.onDestroy();
    this.XfF.Jk(this.Xhh);
    this.IwE.mul = System.currentTimeMillis();
    com.tencent.mm.game.report.api.a.mtH.a(this.IwE);
    GameWebPerformanceInfo.EK(dgY());
    e.a(iAR(), this);
    h.bmo(dgY());
    AppMethodBeat.o(80928);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80927);
    super.onPause();
    GameWebPerformanceInfo localGameWebPerformanceInfo = this.IwE;
    localGameWebPerformanceInfo.muk += System.currentTimeMillis() - this.IwU;
    AppMethodBeat.o(80927);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80926);
    super.onResume();
    if (this.IwE.mub == 0L)
    {
      long l = System.currentTimeMillis();
      Log.i("MicroMsg.Wepkg.GameWebViewUI", "onResume: ".concat(String.valueOf(l)));
      this.IwE.mub = l;
    }
    this.IwU = System.currentTimeMillis();
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
    extends com.tencent.mm.plugin.webview.ui.tools.c
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
    extends m
  {
    a Xhq;
    
    private c()
    {
      AppMethodBeat.i(297037);
      this.Xhq = new a((byte)0);
      AppMethodBeat.o(297037);
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(297046);
      if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null))
      {
        AppMethodBeat.o(297046);
        return null;
      }
      paramWebView = GameWebViewUI.j(GameWebViewUI.this).a(paramWebView, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest);
      AppMethodBeat.o(297046);
      return paramWebView;
    }
    
    public final l cxU()
    {
      AppMethodBeat.i(297040);
      b localb = new b((byte)0);
      AppMethodBeat.o(297040);
      return localb;
    }
    
    public final com.tencent.mm.plugin.webview.core.h isN()
    {
      return this.Xhq;
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
        AppMethodBeat.i(297075);
        GameWebViewUI.y(GameWebViewUI.this);
        super.a(paramWebView, paramInt, paramString1, paramString2);
        AppMethodBeat.o(297075);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(297072);
        if (GameWebViewUI.u(GameWebViewUI.this).muh == 0L) {
          GameWebViewUI.u(GameWebViewUI.this).muh = System.currentTimeMillis();
        }
        if (GameWebViewUI.v(GameWebViewUI.this).XgI == 0L) {
          GameWebViewUI.v(GameWebViewUI.this).XgI = System.currentTimeMillis();
        }
        GameWebViewUI.y(GameWebViewUI.this);
        GameWebViewUI.j(GameWebViewUI.this).bnV(paramString);
        super.b(paramWebView, paramString);
        AppMethodBeat.o(297072);
      }
      
      public final void h(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(297067);
        if (GameWebViewUI.u(GameWebViewUI.this).mug == 0L) {
          GameWebViewUI.u(GameWebViewUI.this).mug = System.currentTimeMillis();
        }
        if (GameWebViewUI.v(GameWebViewUI.this).XgH == 0L) {
          GameWebViewUI.v(GameWebViewUI.this).XgH = System.currentTimeMillis();
        }
        GameWebViewUI.j(GameWebViewUI.this).bnU(paramString);
        AppMethodBeat.o(297067);
      }
    }
    
    final class b
      extends l
    {
      private b() {}
      
      public final void bjt(String paramString)
      {
        AppMethodBeat.i(297070);
        if (GameWebViewUI.u(GameWebViewUI.this).muj == 0L) {
          GameWebViewUI.u(GameWebViewUI.this).muj = System.currentTimeMillis();
        }
        if (GameWebViewUI.v(GameWebViewUI.this).XgK == 0L) {
          GameWebViewUI.v(GameWebViewUI.this).XgK = System.currentTimeMillis();
        }
        GameWebViewUI.w(GameWebViewUI.this);
        if (GameWebViewUI.x(GameWebViewUI.this)) {
          GameWebViewUI.c(GameWebViewUI.this);
        }
        AppMethodBeat.o(297070);
      }
      
      public final void cb(int paramInt, String paramString)
      {
        AppMethodBeat.i(297066);
        if (GameWebViewUI.u(GameWebViewUI.this).mui == 0L) {
          GameWebViewUI.u(GameWebViewUI.this).mui = System.currentTimeMillis();
        }
        if (GameWebViewUI.v(GameWebViewUI.this).XgJ == 0L) {
          GameWebViewUI.v(GameWebViewUI.this).XgJ = System.currentTimeMillis();
        }
        AppMethodBeat.o(297066);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI
 * JD-Core Version:    0.7.0.1
 */