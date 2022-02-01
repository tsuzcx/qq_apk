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
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.d.de;
import com.tencent.mm.plugin.webview.c.f.70;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.model.ax.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebView;
import com.tencent.xweb.w;
import com.tencent.xweb.y;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GameWebViewUI
  extends GameBaseWebViewUI
  implements f
{
  private static String BnP = "wx_fullscreen";
  public com.tencent.mm.plugin.wepkg.c BmF;
  private boolean BnO;
  private HashMap<String, String> BnQ;
  private Drawable BnR;
  private Drawable BnS;
  private String BnT;
  private Map<Integer, bpp> BnU;
  private String BnV;
  private GameMenuImageButton BnW;
  private boolean BnX;
  private boolean BnY;
  private boolean BnZ;
  private ViewGroup Boa;
  private boolean Bob;
  private boolean Boc;
  private boolean rOL;
  public GameWebPerformanceInfo rQk;
  private boolean rQl;
  private Object rQm;
  private long rQw;
  public h rQx;
  
  public GameWebViewUI()
  {
    AppMethodBeat.i(80915);
    this.rOL = false;
    this.BnO = false;
    this.BnQ = new HashMap();
    this.BnT = null;
    this.BnU = new HashMap();
    this.BnY = false;
    this.rQl = false;
    this.rQm = new Object();
    this.Bob = false;
    this.Boc = false;
    AppMethodBeat.o(80915);
  }
  
  private l epZ()
  {
    AppMethodBeat.i(80918);
    try
    {
      List localList = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.Bok;
      new Bundle().putString("game_hv_menu_appid", this.BnV);
      this.BnU.clear();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        bpp localbpp = (bpp)localIterator.next();
        this.BnU.put(Integer.valueOf(localbpp.DNZ), localbpp);
      }
      locall = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.c(this, localException);
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.Wepkg.GameWebViewUI", "get cache hv game menu fail! exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(80918);
      return null;
    }
    l locall;
    AppMethodBeat.o(80918);
    return locall;
  }
  
  private void eqa()
  {
    AppMethodBeat.i(80937);
    if (this.BgF != null) {
      this.BgF.setVisibility(0);
    }
    AppMethodBeat.o(80937);
  }
  
  public final void aE(Bundle paramBundle)
  {
    AppMethodBeat.i(80922);
    super.aE(paramBundle);
    AppMethodBeat.o(80922);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(80925);
    if (this.BnX) {
      super.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    AppMethodBeat.o(80925);
  }
  
  public boolean bEZ()
  {
    AppMethodBeat.i(80938);
    getIntent().putExtra("minimize_secene", 2);
    AppMethodBeat.o(80938);
    return true;
  }
  
  public final void bFd()
  {
    AppMethodBeat.i(80919);
    if (this.BhW.Bfm) {
      this.BhW.enV();
    }
    if ((this.BnW == null) || (!this.BnW.nkH))
    {
      super.bFd();
      AppMethodBeat.o(80919);
      return;
    }
    final com.tencent.mm.plugin.webview.ui.tools.game.menu.d locald = new com.tencent.mm.plugin.webview.ui.tools.game.menu.d(getContext());
    locald.a(new b.c()
    {
      public final void c(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(80900);
        paramAnonymousMenuItem = (bpp)GameWebViewUI.l(GameWebViewUI.this).get(Integer.valueOf(paramAnonymousMenuItem.getItemId()));
        if (paramAnonymousMenuItem == null)
        {
          AppMethodBeat.o(80900);
          return;
        }
        switch (GameWebViewUI.8.Bog[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.TK(paramAnonymousMenuItem.CKO).ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(80900);
          return;
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramAnonymousMenuItem.Doo);
          com.tencent.mm.bs.d.b(GameWebViewUI.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          AppMethodBeat.o(80900);
          return;
          GameWebViewUI.this.AMJ.emr().z(new Object[] { GameWebViewUI.this.bEx(), Integer.valueOf(32), Integer.valueOf(1) }).report();
          if (!GameWebViewUI.m(GameWebViewUI.this))
          {
            GameWebViewUI.this.finish();
            AppMethodBeat.o(80900);
            return;
            paramAnonymousMenuItem = GameWebViewUI.this.getIntent().getStringExtra("KPublisherId");
            localObject = GameWebViewUI.this.getIntent().getStringExtra("KAppId");
            String str = GameWebViewUI.this.getIntent().getStringExtra("srcUsername");
            GameWebViewUI.this.AMJ.emr().z(new Object[] { GameWebViewUI.this.bEx(), Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem, localObject, str }).report();
            GameWebViewUI.b(GameWebViewUI.this, GameWebViewUI.n(GameWebViewUI.this).emS().eBQ());
            GameWebViewUI.o(GameWebViewUI.this);
            AppMethodBeat.o(80900);
            return;
            GameWebViewUI.this.AMJ.emr().z(new Object[] { GameWebViewUI.this.bEx(), Integer.valueOf(3), Integer.valueOf(1) }).report();
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(157L, 6L, 1L, false);
            GameWebViewUI.c(GameWebViewUI.this, GameWebViewUI.p(GameWebViewUI.this).emS().eBQ());
            GameWebViewUI.q(GameWebViewUI.this);
            AppMethodBeat.o(80900);
            return;
            GameWebViewUI.this.AMJ.emr().z(new Object[] { GameWebViewUI.this.bEx(), Integer.valueOf(10), Integer.valueOf(1) }).report();
            if (GameWebViewUI.r(GameWebViewUI.this) != null)
            {
              GameWebViewUI.s(GameWebViewUI.this).reload();
              AppMethodBeat.o(80900);
              return;
              GameWebViewUI.this.AMJ.emr().z(new Object[] { GameWebViewUI.this.bEx(), Integer.valueOf(31), Integer.valueOf(1) }).report();
              GameWebViewUI.t(GameWebViewUI.this);
              AppMethodBeat.o(80900);
              return;
              GameWebViewUI.this.AMJ.emr().z(new Object[] { GameWebViewUI.this.bEx(), Integer.valueOf(11), Integer.valueOf(1) }).report();
              GameWebViewUI.u(GameWebViewUI.this);
              AppMethodBeat.o(80900);
              return;
              if (GameWebViewUI.this.AQP != null)
              {
                localObject = GameWebViewUI.this.AQP;
                int i = paramAnonymousMenuItem.DNZ;
                if (!((com.tencent.mm.plugin.webview.c.f)localObject).yZR)
                {
                  ad.e("MicroMsg.JsApiHandler", "not ready");
                  AppMethodBeat.o(80900);
                  return;
                }
                ad.i("MicroMsg.JsApiHandler", "onCustomGameMenuClicked");
                paramAnonymousMenuItem = new HashMap();
                paramAnonymousMenuItem.put("itemId", Integer.valueOf(i));
                aq.f(new f.70((com.tencent.mm.plugin.webview.c.f)localObject, l.a.b("onCustomGameMenuClicked", paramAnonymousMenuItem, ((com.tencent.mm.plugin.webview.c.f)localObject).ARm, ((com.tencent.mm.plugin.webview.c.f)localObject).ARn)));
              }
            }
          }
        }
      }
    });
    locald.Boz = new b.b()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(80901);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(480L, 0L, 1L, false);
        l locall = GameWebViewUI.v(GameWebViewUI.this);
        if (locall != null) {
          paramAnonymousl.FYt.addAll(locall.FYt);
        }
        AppMethodBeat.o(80901);
      }
    };
    if (this.BgP) {
      locald.kBo = true;
    }
    for (locald.kBp = true; (this.BgT != null) && (this.BgT.isShown()); locald.kBp = false)
    {
      this.BgT.hide();
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80902);
          if ((GameWebViewUI.this.isFinishing()) || (GameWebViewUI.w(GameWebViewUI.this)))
          {
            ad.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
            AppMethodBeat.o(80902);
            return;
          }
          locald.csG();
          AppMethodBeat.o(80902);
        }
      }, 100L);
      AppMethodBeat.o(80919);
      return;
      locald.kBo = false;
    }
    hideVKB();
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80903);
        if ((GameWebViewUI.this.isFinishing()) || (GameWebViewUI.x(GameWebViewUI.this)))
        {
          ad.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
          AppMethodBeat.o(80903);
          return;
        }
        locald.csG();
        AppMethodBeat.o(80903);
      }
    }, 100L);
    AppMethodBeat.o(80919);
  }
  
  public final com.tencent.mm.plugin.webview.core.h bFq()
  {
    AppMethodBeat.i(188120);
    com.tencent.mm.plugin.webview.core.h localh = super.bFq();
    if (localh != null) {
      localh.a(new c((byte)0));
    }
    AppMethodBeat.o(188120);
    return localh;
  }
  
  public final void bol()
  {
    AppMethodBeat.i(80923);
    super.bol();
    this.BnX = true;
    int i;
    if ((this.rOL) || (this.sfC != null) || (this.sfB != 0)) {
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i != 0)
      {
        localObject = com.tencent.mm.plugin.game.commlib.a.cBm();
        if ((localObject == null) || (bt.isNullOrNil(((de)localObject).gHT)) || (bt.isNullOrNil(((de)localObject).sdM))) {}
      }
      try
      {
        if (ai.Eq()) {}
        for (this.sfB = Color.parseColor(((de)localObject).sdM);; this.sfB = Color.parseColor(((de)localObject).gHT))
        {
          this.sfC = ((de)localObject).rYr;
          eow();
          tt(true);
          localObject = getIntent();
          if ((localObject == null) || (!((Intent)localObject).getBooleanExtra("game_check_float", false))) {
            break label420;
          }
          i = ((Intent)localObject).getIntExtra("game_sourceScene", 0);
          this.BnT = ((Intent)localObject).getStringExtra("game_transparent_float_url");
          if (!bt.isNullOrNil(this.BnT)) {
            break label247;
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("game_check_float", true);
          ((Intent)localObject).putExtra("game_sourceScene", i);
          com.tencent.mm.bs.d.b(this, "game", ".ui.GameCenterUI", (Intent)localObject);
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
          ad.e("MicroMsg.Wepkg.GameWebViewUI", "parse color: " + localIllegalArgumentException.getMessage());
        }
        try
        {
          label247:
          localObject = new Bundle();
          ((Bundle)localObject).putInt("game_sourceScene", i);
          if (this.kxf != null) {
            this.kxf.j(91, (Bundle)localObject);
          }
          if (this.Bms == null) {
            this.Bms = new a(this, this.BgN, this.BnT);
          }
          localObject = this.Bms;
          String str = this.BnT;
          ((a)localObject).rQe = str;
          ((a)localObject).BmF.ck(str, false);
          if ((((a)localObject).gQk != null) && (((a)localObject).gQk.getParent() == null))
          {
            ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
            ((a)localObject).TP.addView(((a)localObject).gQk, localLayoutParams);
          }
          if ((((a)localObject).gQk != null) && (((a)localObject).BmG != null)) {
            ((a)localObject).gQk.post(new a.3((a)localObject, str));
          }
          this.BnT = null;
          AppMethodBeat.o(80923);
          return;
        }
        catch (RemoteException localRemoteException) {}
        label420:
        AppMethodBeat.o(80923);
      }
    }
  }
  
  public final Map<Integer, Object> cBK()
  {
    AppMethodBeat.i(188121);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(e.a.BmV), eqb());
    localHashMap.put(Integer.valueOf(e.a.BmW), ay.iw(aj.getContext()));
    localHashMap.put(Integer.valueOf(e.a.BmX), String.valueOf(YearClass.get(aj.getContext())));
    String str = bEx();
    try
    {
      localHashMap.put(Integer.valueOf(e.a.BmY), p.encode(bt.nullAsNil(str), "UTF-8"));
      label92:
      localHashMap.put(Integer.valueOf(e.a.BmZ), Boolean.valueOf(this.BmF.azD(str)));
      localHashMap.put(Integer.valueOf(e.a.Bna), Integer.valueOf(0));
      localHashMap.put(Integer.valueOf(e.a.Bnb), Integer.valueOf(0));
      localHashMap.put(Integer.valueOf(e.a.Bnc), this.BmF.ett());
      localHashMap.put(Integer.valueOf(e.a.Bnd), com.tencent.mm.plugin.wepkg.c.etu());
      AppMethodBeat.o(188121);
      return localHashMap;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label92;
    }
  }
  
  public final Map<Integer, Object> cBL()
  {
    AppMethodBeat.i(188122);
    HashMap localHashMap = new HashMap();
    h localh = h.aym(bEx());
    if (localh != null)
    {
      localHashMap.put(Integer.valueOf(e.b.Bng), Long.valueOf(localh.Bny - localh.startTime));
      localHashMap.put(Integer.valueOf(e.b.Bnh), Long.valueOf(localh.Bnz - localh.startTime));
      localHashMap.put(Integer.valueOf(e.b.Bni), Long.valueOf(localh.BnA - localh.Bnz));
      localHashMap.put(Integer.valueOf(e.b.Bnj), Long.valueOf(localh.BnC - localh.BnB));
      localHashMap.put(Integer.valueOf(e.b.Bnk), Long.valueOf(localh.BnE - localh.BnD));
      localHashMap.put(Integer.valueOf(e.b.Bns), Long.valueOf(localh.BnF));
    }
    localHashMap.put(Integer.valueOf(e.b.Bnt), Integer.valueOf(0));
    AppMethodBeat.o(188122);
    return localHashMap;
  }
  
  public final int eoC()
  {
    AppMethodBeat.i(80921);
    int i = super.eoC();
    AppMethodBeat.o(80921);
    return i;
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(80931);
    super.eoD();
    this.BnV = getIntent().getStringExtra("game_hv_menu_appid");
    if ((this.BgP) && (!bt.isNullOrNil(this.BnV)))
    {
      if (this.BgO != null) {
        this.BgO.setVisibility(8);
      }
      this.BnW.a(this.BgM, new GameMenuImageButton.a()
      {
        public final void cBO()
        {
          AppMethodBeat.i(80904);
          GameWebViewUI.this.bFd();
          AppMethodBeat.o(80904);
        }
      });
    }
    AppMethodBeat.o(80931);
  }
  
  public final w eoE()
  {
    try
    {
      AppMethodBeat.i(80917);
      if (this.Bhq == null) {
        this.Bhq = new b();
      }
      w localw = this.Bhq;
      AppMethodBeat.o(80917);
      return localw;
    }
    finally {}
  }
  
  public final String eqb()
  {
    AppMethodBeat.i(188123);
    String str = (hashCode() & 0x7FFFFFFF) + "_" + (bEx().hashCode() & 0x7FFFFFFF);
    AppMethodBeat.o(188123);
    return str;
  }
  
  public final void fl(String paramString, int paramInt)
  {
    AppMethodBeat.i(80920);
    super.fl(paramString, paramInt);
    AppMethodBeat.o(80920);
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(80929);
    this.rQk.fVf = System.currentTimeMillis();
    int i = super.getLayoutId();
    AppMethodBeat.o(80929);
    return i;
  }
  
  public void initView()
  {
    AppMethodBeat.i(80930);
    super.initView();
    this.BnR = new ColorDrawable(android.support.v4.content.b.n(this, 2131099879));
    this.BnS = new ColorDrawable(android.support.v4.content.b.n(this, 2131099879));
    this.rQk.fVg = System.currentTimeMillis();
    this.rQx.Bny = System.currentTimeMillis();
    AppMethodBeat.o(80930);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(80933);
    if (this.rQk.fVi == 0L) {
      this.rQk.fVi = System.currentTimeMillis();
    }
    if (this.BmF.ets())
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
    boolean bool = false;
    AppMethodBeat.i(80916);
    final String str1 = getIntent().getStringExtra("rawUrl");
    String str2;
    if (!bt.isNullOrNil(str1))
    {
      str2 = Uri.parse(str1).getQueryParameter("nav_color");
      if (bt.isNullOrNil(str2)) {}
    }
    try
    {
      int i = Color.parseColor("#".concat(String.valueOf(str2)));
      getIntent().putExtra("customize_status_bar_color", i);
      label76:
      ad.i("MicroMsg.Wepkg.GameWebViewUI", "rawUrl rid:%s, pkgId:%s", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.aAi(str1), com.tencent.mm.plugin.wepkg.utils.d.aAg(str1) });
      if (getIntent().getLongExtra("gamecenterui_createtime", 0L) > 0L) {}
      for (this.rQk = GameWebPerformanceInfo.qd(str1);; this.rQk = GameWebPerformanceInfo.qe(str1))
      {
        this.rQk.url = str1;
        this.rQk.fUN = eqb();
        this.rQk.fUX = getIntent().getLongExtra("gamecenterui_createtime", 0L);
        this.rQk.fUY = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        this.rQk.startTime = getIntent().getLongExtra("start_time", this.rQk.fUY);
        this.rQk.fVd = System.currentTimeMillis();
        this.rQk.fUR = 1;
        ad.i("MicroMsg.Wepkg.GameWebViewUI", "onCreate, startTime: %d, gameCenterUICreate: %d, startWebUI: %d,webUICreate: %d", new Object[] { Long.valueOf(this.rQk.startTime), Long.valueOf(this.rQk.fUX), Long.valueOf(this.rQk.fUY), Long.valueOf(this.rQk.fVd) });
        this.rQx = h.ayk(str1);
        this.rQx.startTime = System.currentTimeMillis();
        this.BmF = new com.tencent.mm.plugin.wepkg.c();
        super.onCreate(paramBundle);
        if (this.nhy != null) {
          this.nhy.getSettings().setForceDarkBehavior(1);
        }
        paramBundle = getIntent();
        if ((paramBundle != null) && (paramBundle.getBooleanExtra("disable_progress_bar", false)))
        {
          this.BgE.lQB = false;
          eqa();
        }
        if (this.nhy.getIsX5Kernel()) {
          this.nhy.setWebViewClientExtension(new a(this));
        }
        this.BmF.BHn = new com.tencent.mm.plugin.wepkg.event.b()
        {
          public final void cBM()
          {
            AppMethodBeat.i(80897);
            ad.i("MicroMsg.Wepkg.GameWebViewUI", "onReload");
            GameWebViewUI.a(GameWebViewUI.this);
            if (GameWebViewUI.b(GameWebViewUI.this)) {
              GameWebViewUI.c(GameWebViewUI.this);
            }
            AppMethodBeat.o(80897);
          }
          
          public final void cBN()
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
          
          public final void lO(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(80899);
            GameWebViewUI.k(GameWebViewUI.this).post(new Runnable()
            {
              public final void run()
              {
                boolean bool = false;
                AppMethodBeat.i(80896);
                if (GameWebViewUI.d(GameWebViewUI.this))
                {
                  GameWebViewUI.a(GameWebViewUI.this, false);
                  GameWebViewUI.g(GameWebViewUI.this);
                  if (paramAnonymousBoolean)
                  {
                    GameWebViewUI.h(GameWebViewUI.this).stopLoading();
                    com.tencent.mm.plugin.wepkg.c localc = GameWebViewUI.j(GameWebViewUI.this);
                    String str = GameWebViewUI.1.this.hUL;
                    if (!GameWebViewUI.i(GameWebViewUI.this)) {
                      bool = true;
                    }
                    localc.ck(str, bool);
                    GameWebViewUI.a(GameWebViewUI.this, GameWebViewUI.1.this.hUL);
                  }
                }
                AppMethodBeat.o(80896);
              }
            });
            AppMethodBeat.o(80899);
          }
        };
        this.BnZ = getIntent().getBooleanExtra("open_game_float", false);
        paramBundle = this.BmF;
        if (!this.BnZ) {
          bool = true;
        }
        if (paramBundle.ck(str1, bool))
        {
          ad.i("MicroMsg.Wepkg.GameWebViewUI", "current page use wepkg");
          this.BnY = true;
          eqa();
        }
        this.BnW = new GameMenuImageButton(getContext());
        AppMethodBeat.o(80916);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label76;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80928);
    super.onDestroy();
    this.BmF.tM(this.BnZ);
    this.rQk.fVo = System.currentTimeMillis();
    com.tencent.mm.game.report.api.a.fUK.a(this.rQk);
    GameWebPerformanceInfo.qf(bEx());
    e.a(eqb(), this);
    h.ayn(bEx());
    AppMethodBeat.o(80928);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80927);
    super.onPause();
    GameWebPerformanceInfo localGameWebPerformanceInfo = this.rQk;
    localGameWebPerformanceInfo.fVn += System.currentTimeMillis() - this.rQw;
    AppMethodBeat.o(80927);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80926);
    super.onResume();
    if (this.rQk.fVe == 0L)
    {
      long l = System.currentTimeMillis();
      ad.i("MicroMsg.Wepkg.GameWebViewUI", "onResume: ".concat(String.valueOf(l)));
      this.rQk.fVe = l;
    }
    this.rQw = System.currentTimeMillis();
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
        this.landscapeMode = getSharedPreferences(aj.eFD(), 4).getBoolean("settings_landscape_mode", false);
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
  
  public final void tt(boolean paramBoolean)
  {
    AppMethodBeat.i(80924);
    super.tt(paramBoolean);
    tv(false);
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
    extends j
  {
    private c() {}
    
    public final com.tencent.xweb.WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(188119);
      if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null))
      {
        AppMethodBeat.o(188119);
        return null;
      }
      if (paramWebResourceRequest.getUrl().toString().startsWith("weixin://game.js"))
      {
        paramWebView = d.tw(GameWebViewUI.j(GameWebViewUI.this).BHg);
        if (paramWebView != null)
        {
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramWebView = new com.tencent.xweb.WebResourceResponse(paramWebView.getMimeType(), paramWebView.getEncoding(), paramWebView.getStatusCode(), paramWebView.getReasonPhrase(), paramWebView.getResponseHeaders(), paramWebView.getData());
            AppMethodBeat.o(188119);
            return paramWebView;
          }
          paramWebView = new com.tencent.xweb.WebResourceResponse(paramWebView.getMimeType(), paramWebView.getEncoding(), paramWebView.getData());
          AppMethodBeat.o(188119);
          return paramWebView;
        }
        AppMethodBeat.o(188119);
        return null;
      }
      paramWebView = GameWebViewUI.j(GameWebViewUI.this).azC(paramWebResourceRequest.getUrl().toString());
      AppMethodBeat.o(188119);
      return paramWebView;
    }
    
    public final com.tencent.mm.plugin.webview.core.e ejF()
    {
      AppMethodBeat.i(188117);
      a locala = new a((byte)0);
      AppMethodBeat.o(188117);
      return locala;
    }
    
    public final com.tencent.mm.plugin.webview.core.i ejG()
    {
      AppMethodBeat.i(188118);
      b localb = new b((byte)0);
      AppMethodBeat.o(188118);
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
        AppMethodBeat.i(188114);
        GameWebViewUI.C(GameWebViewUI.this);
        super.a(paramWebView, paramInt, paramString1, paramString2);
        AppMethodBeat.o(188114);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(188113);
        if (GameWebViewUI.y(GameWebViewUI.this).fVk == 0L) {
          GameWebViewUI.y(GameWebViewUI.this).fVk = System.currentTimeMillis();
        }
        if (GameWebViewUI.z(GameWebViewUI.this).BnA == 0L) {
          GameWebViewUI.z(GameWebViewUI.this).BnA = System.currentTimeMillis();
        }
        GameWebViewUI.C(GameWebViewUI.this);
        GameWebViewUI.j(GameWebViewUI.this).p(paramWebView, paramString);
        super.b(paramWebView, paramString);
        AppMethodBeat.o(188113);
      }
      
      public final void m(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(188112);
        if (GameWebViewUI.y(GameWebViewUI.this).fVj == 0L) {
          GameWebViewUI.y(GameWebViewUI.this).fVj = System.currentTimeMillis();
        }
        if (GameWebViewUI.z(GameWebViewUI.this).Bnz == 0L) {
          GameWebViewUI.z(GameWebViewUI.this).Bnz = System.currentTimeMillis();
        }
        GameWebViewUI.j(GameWebViewUI.this).o(paramWebView, paramString);
        AppMethodBeat.o(188112);
      }
    }
    
    final class b
      extends com.tencent.mm.plugin.webview.core.i
    {
      private b() {}
      
      public final void avG(String paramString)
      {
        AppMethodBeat.i(188116);
        if (GameWebViewUI.y(GameWebViewUI.this).fVm == 0L) {
          GameWebViewUI.y(GameWebViewUI.this).fVm = System.currentTimeMillis();
        }
        if (GameWebViewUI.z(GameWebViewUI.this).BnC == 0L) {
          GameWebViewUI.z(GameWebViewUI.this).BnC = System.currentTimeMillis();
        }
        GameWebViewUI.A(GameWebViewUI.this);
        if (GameWebViewUI.B(GameWebViewUI.this)) {
          GameWebViewUI.c(GameWebViewUI.this);
        }
        AppMethodBeat.o(188116);
      }
      
      public final void bf(int paramInt, String paramString)
      {
        AppMethodBeat.i(188115);
        if (GameWebViewUI.y(GameWebViewUI.this).fVl == 0L) {
          GameWebViewUI.y(GameWebViewUI.this).fVl = System.currentTimeMillis();
        }
        if (GameWebViewUI.z(GameWebViewUI.this).BnB == 0L) {
          GameWebViewUI.z(GameWebViewUI.this).BnB = System.currentTimeMillis();
        }
        AppMethodBeat.o(188115);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI
 * JD-Core Version:    0.7.0.1
 */