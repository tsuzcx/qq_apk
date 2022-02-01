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
import com.tencent.mm.plugin.webview.model.ax.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
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
  implements f
{
  private static String CFW = "wx_fullscreen";
  public com.tencent.mm.plugin.wepkg.c CEM;
  private boolean CFV;
  private HashMap<String, String> CFX;
  private Drawable CFY;
  private Drawable CFZ;
  private String CGa;
  private Map<Integer, bug> CGb;
  private String CGc;
  private GameMenuImageButton CGd;
  private boolean CGe;
  private boolean CGf;
  private boolean CGg;
  private ViewGroup CGh;
  private boolean CGi;
  private boolean CGj;
  private boolean sWB;
  public GameWebPerformanceInfo sYb;
  private boolean sYc;
  private Object sYd;
  private long sYn;
  public h sYo;
  
  public GameWebViewUI()
  {
    AppMethodBeat.i(80915);
    this.sWB = false;
    this.CFV = false;
    this.CFX = new HashMap();
    this.CGa = null;
    this.CGb = new HashMap();
    this.CGf = false;
    this.sYc = false;
    this.sYd = new Object();
    this.CGi = false;
    this.CGj = false;
    AppMethodBeat.o(80915);
  }
  
  private l eFt()
  {
    AppMethodBeat.i(80918);
    try
    {
      List localList = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.CGr;
      new Bundle().putString("game_hv_menu_appid", this.CGc);
      this.CGb.clear();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        bug localbug = (bug)localIterator.next();
        this.CGb.put(Integer.valueOf(localbug.Fkq), localbug);
      }
      locall = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.c(this, localException);
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.Wepkg.GameWebViewUI", "get cache hv game menu fail! exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(80918);
      return null;
    }
    l locall;
    AppMethodBeat.o(80918);
    return locall;
  }
  
  private void eFu()
  {
    AppMethodBeat.i(80937);
    if (this.CyS != null) {
      this.CyS.setVisibility(0);
    }
    AppMethodBeat.o(80937);
  }
  
  public final void aJ(Bundle paramBundle)
  {
    AppMethodBeat.i(80922);
    super.aJ(paramBundle);
    AppMethodBeat.o(80922);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(80925);
    if (this.CGe) {
      super.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    AppMethodBeat.o(80925);
  }
  
  public final com.tencent.mm.plugin.webview.core.h bMD()
  {
    AppMethodBeat.i(188564);
    com.tencent.mm.plugin.webview.core.h localh = super.bMD();
    if (localh != null) {
      localh.a(new c((byte)0));
    }
    AppMethodBeat.o(188564);
    return localh;
  }
  
  public boolean bMn()
  {
    AppMethodBeat.i(80938);
    getIntent().putExtra("minimize_secene", 2);
    AppMethodBeat.o(80938);
    return true;
  }
  
  public final void bMr()
  {
    AppMethodBeat.i(80919);
    if (this.CAj.Cxy) {
      this.CAj.eDo();
    }
    if ((this.CGd == null) || (!this.CGd.nNH))
    {
      super.bMr();
      AppMethodBeat.o(80919);
      return;
    }
    final com.tencent.mm.plugin.webview.ui.tools.game.menu.d locald = new com.tencent.mm.plugin.webview.ui.tools.game.menu.d(getContext());
    locald.a(new b.c()
    {
      public final void c(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(80900);
        paramAnonymousMenuItem = (bug)GameWebViewUI.l(GameWebViewUI.this).get(Integer.valueOf(paramAnonymousMenuItem.getItemId()));
        if (paramAnonymousMenuItem == null)
        {
          AppMethodBeat.o(80900);
          return;
        }
        switch (GameWebViewUI.8.CGn[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.VS(paramAnonymousMenuItem.Edq).ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(80900);
          return;
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramAnonymousMenuItem.EJo);
          com.tencent.mm.br.d.b(GameWebViewUI.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          AppMethodBeat.o(80900);
          return;
          GameWebViewUI.this.Cfc.eBM().B(new Object[] { GameWebViewUI.this.bLL(), Integer.valueOf(32), Integer.valueOf(1) }).report();
          if (!GameWebViewUI.m(GameWebViewUI.this))
          {
            GameWebViewUI.this.finish();
            AppMethodBeat.o(80900);
            return;
            paramAnonymousMenuItem = GameWebViewUI.this.getIntent().getStringExtra("KPublisherId");
            localObject = GameWebViewUI.this.getIntent().getStringExtra("KAppId");
            String str = GameWebViewUI.this.getIntent().getStringExtra("srcUsername");
            GameWebViewUI.this.Cfc.eBM().B(new Object[] { GameWebViewUI.this.bLL(), Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem, localObject, str }).report();
            GameWebViewUI.n(GameWebViewUI.this);
            AppMethodBeat.o(80900);
            return;
            GameWebViewUI.this.Cfc.eBM().B(new Object[] { GameWebViewUI.this.bLL(), Integer.valueOf(3), Integer.valueOf(1) }).report();
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(157L, 6L, 1L, false);
            GameWebViewUI.o(GameWebViewUI.this);
            AppMethodBeat.o(80900);
            return;
            GameWebViewUI.this.Cfc.eBM().B(new Object[] { GameWebViewUI.this.bLL(), Integer.valueOf(10), Integer.valueOf(1) }).report();
            if (GameWebViewUI.p(GameWebViewUI.this) != null)
            {
              GameWebViewUI.q(GameWebViewUI.this).reload();
              AppMethodBeat.o(80900);
              return;
              GameWebViewUI.this.Cfc.eBM().B(new Object[] { GameWebViewUI.this.bLL(), Integer.valueOf(31), Integer.valueOf(1) }).report();
              GameWebViewUI.r(GameWebViewUI.this);
              AppMethodBeat.o(80900);
              return;
              GameWebViewUI.this.Cfc.eBM().B(new Object[] { GameWebViewUI.this.bLL(), Integer.valueOf(11), Integer.valueOf(1) }).report();
              GameWebViewUI.s(GameWebViewUI.this);
              AppMethodBeat.o(80900);
              return;
              if (GameWebViewUI.this.Cjc != null)
              {
                localObject = GameWebViewUI.this.Cjc;
                int i = paramAnonymousMenuItem.Fkq;
                if (!((com.tencent.mm.plugin.webview.c.f)localObject).Apr)
                {
                  ac.e("MicroMsg.JsApiHandler", "not ready");
                  AppMethodBeat.o(80900);
                  return;
                }
                ac.i("MicroMsg.JsApiHandler", "onCustomGameMenuClicked");
                paramAnonymousMenuItem = new HashMap();
                paramAnonymousMenuItem.put("itemId", Integer.valueOf(i));
                ap.f(new f.70((com.tencent.mm.plugin.webview.c.f)localObject, l.a.b("onCustomGameMenuClicked", paramAnonymousMenuItem, ((com.tencent.mm.plugin.webview.c.f)localObject).Cjz, ((com.tencent.mm.plugin.webview.c.f)localObject).CjA)));
              }
            }
          }
        }
      }
    });
    locald.CGG = new b.b()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(80901);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(480L, 0L, 1L, false);
        l locall = GameWebViewUI.t(GameWebViewUI.this);
        if (locall != null) {
          paramAnonymousl.Hyi.addAll(locall.Hyi);
        }
        AppMethodBeat.o(80901);
      }
    };
    if (this.Czc) {
      locald.lcG = true;
    }
    for (locald.lcH = true; (this.Czg != null) && (this.Czg.isShown()); locald.lcH = false)
    {
      this.Czg.hide();
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80902);
          if ((GameWebViewUI.this.isFinishing()) || (GameWebViewUI.u(GameWebViewUI.this)))
          {
            ac.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
            AppMethodBeat.o(80902);
            return;
          }
          locald.cED();
          AppMethodBeat.o(80902);
        }
      }, 100L);
      AppMethodBeat.o(80919);
      return;
      locald.lcG = false;
    }
    hideVKB();
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80903);
        if ((GameWebViewUI.this.isFinishing()) || (GameWebViewUI.v(GameWebViewUI.this)))
        {
          ac.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
          AppMethodBeat.o(80903);
          return;
        }
        locald.cED();
        AppMethodBeat.o(80903);
      }
    }, 100L);
    AppMethodBeat.o(80919);
  }
  
  public final void bvh()
  {
    AppMethodBeat.i(80923);
    super.bvh();
    this.CGe = true;
    int i;
    if ((this.sWB) || (this.tnv != null) || (this.tnu != 0)) {
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i != 0)
      {
        localObject = com.tencent.mm.plugin.game.commlib.a.cOv();
        if ((localObject == null) || (bs.isNullOrNil(((de)localObject).hiu)) || (bs.isNullOrNil(((de)localObject).tlG))) {}
      }
      try
      {
        if (aj.DT()) {}
        for (this.tnu = Color.parseColor(((de)localObject).tlG);; this.tnu = Color.parseColor(((de)localObject).hiu))
        {
          this.tnv = ((de)localObject).tgj;
          eDR();
          uv(true);
          localObject = getIntent();
          if ((localObject == null) || (!((Intent)localObject).getBooleanExtra("game_check_float", false))) {
            break label420;
          }
          i = ((Intent)localObject).getIntExtra("game_sourceScene", 0);
          this.CGa = ((Intent)localObject).getStringExtra("game_transparent_float_url");
          if (!bs.isNullOrNil(this.CGa)) {
            break label247;
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("game_check_float", true);
          ((Intent)localObject).putExtra("game_sourceScene", i);
          com.tencent.mm.br.d.b(this, "game", ".ui.GameCenterUI", (Intent)localObject);
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
          ac.e("MicroMsg.Wepkg.GameWebViewUI", "parse color: " + localIllegalArgumentException.getMessage());
        }
        try
        {
          label247:
          localObject = new Bundle();
          ((Bundle)localObject).putInt("game_sourceScene", i);
          if (this.kYt != null) {
            this.kYt.k(91, (Bundle)localObject);
          }
          if (this.CEz == null) {
            this.CEz = new a(this, this.Cza, this.CGa);
          }
          localObject = this.CEz;
          String str = this.CGa;
          ((a)localObject).sXV = str;
          ((a)localObject).CEM.cq(str, false);
          if ((((a)localObject).hqK != null) && (((a)localObject).hqK.getParent() == null))
          {
            ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
            ((a)localObject).UK.addView(((a)localObject).hqK, localLayoutParams);
          }
          if ((((a)localObject).hqK != null) && (((a)localObject).CEN != null)) {
            ((a)localObject).hqK.post(new a.3((a)localObject, str));
          }
          this.CGa = null;
          AppMethodBeat.o(80923);
          return;
        }
        catch (RemoteException localRemoteException) {}
        label420:
        AppMethodBeat.o(80923);
      }
    }
  }
  
  public final Map<Integer, Object> cOV()
  {
    AppMethodBeat.i(188565);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(e.a.CFc), eFv());
    localHashMap.put(Integer.valueOf(e.a.CFd), com.tencent.mm.sdk.platformtools.ax.iH(ai.getContext()));
    localHashMap.put(Integer.valueOf(e.a.CFe), String.valueOf(YearClass.get(ai.getContext())));
    String str = bLL();
    try
    {
      localHashMap.put(Integer.valueOf(e.a.CFf), p.encode(bs.nullAsNil(str), "UTF-8"));
      label92:
      localHashMap.put(Integer.valueOf(e.a.CFg), Boolean.valueOf(this.CEM.aEU(str)));
      localHashMap.put(Integer.valueOf(e.a.CFh), Integer.valueOf(0));
      localHashMap.put(Integer.valueOf(e.a.CFi), Integer.valueOf(0));
      localHashMap.put(Integer.valueOf(e.a.CFj), this.CEM.eIM());
      localHashMap.put(Integer.valueOf(e.a.CFk), com.tencent.mm.plugin.wepkg.c.eIN());
      AppMethodBeat.o(188565);
      return localHashMap;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label92;
    }
  }
  
  public final Map<Integer, Object> cOW()
  {
    AppMethodBeat.i(188566);
    HashMap localHashMap = new HashMap();
    h localh = h.aDD(bLL());
    if (localh != null)
    {
      localHashMap.put(Integer.valueOf(e.b.CFn), Long.valueOf(localh.CFF - localh.startTime));
      localHashMap.put(Integer.valueOf(e.b.CFo), Long.valueOf(localh.CFG - localh.startTime));
      localHashMap.put(Integer.valueOf(e.b.CFp), Long.valueOf(localh.CFH - localh.CFG));
      localHashMap.put(Integer.valueOf(e.b.CFq), Long.valueOf(localh.CFJ - localh.CFI));
      localHashMap.put(Integer.valueOf(e.b.CFr), Long.valueOf(localh.CFL - localh.CFK));
      localHashMap.put(Integer.valueOf(e.b.CFz), Long.valueOf(localh.CFM));
    }
    localHashMap.put(Integer.valueOf(e.b.CFA), Integer.valueOf(0));
    AppMethodBeat.o(188566);
    return localHashMap;
  }
  
  public final int eDX()
  {
    AppMethodBeat.i(80921);
    int i = super.eDX();
    AppMethodBeat.o(80921);
    return i;
  }
  
  public final void eDY()
  {
    AppMethodBeat.i(80931);
    super.eDY();
    this.CGc = getIntent().getStringExtra("game_hv_menu_appid");
    if ((this.Czc) && (!bs.isNullOrNil(this.CGc)))
    {
      if (this.Czb != null) {
        this.Czb.setVisibility(8);
      }
      this.CGd.a(this.CyZ, new GameMenuImageButton.a()
      {
        public final void cOZ()
        {
          AppMethodBeat.i(80904);
          GameWebViewUI.this.bMr();
          AppMethodBeat.o(80904);
        }
      });
    }
    AppMethodBeat.o(80931);
  }
  
  public final x eDZ()
  {
    try
    {
      AppMethodBeat.i(80917);
      if (this.CzD == null) {
        this.CzD = new b();
      }
      x localx = this.CzD;
      AppMethodBeat.o(80917);
      return localx;
    }
    finally {}
  }
  
  public final String eFv()
  {
    AppMethodBeat.i(188567);
    String str = (hashCode() & 0x7FFFFFFF) + "_" + (bLL().hashCode() & 0x7FFFFFFF);
    AppMethodBeat.o(188567);
    return str;
  }
  
  public final void ft(String paramString, int paramInt)
  {
    AppMethodBeat.i(80920);
    super.ft(paramString, paramInt);
    AppMethodBeat.o(80920);
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(80929);
    this.sYb.fZa = System.currentTimeMillis();
    int i = super.getLayoutId();
    AppMethodBeat.o(80929);
    return i;
  }
  
  public void initView()
  {
    AppMethodBeat.i(80930);
    super.initView();
    this.CFY = new ColorDrawable(android.support.v4.content.b.n(this, 2131099879));
    this.CFZ = new ColorDrawable(android.support.v4.content.b.n(this, 2131099879));
    this.sYb.fZb = System.currentTimeMillis();
    this.sYo.CFF = System.currentTimeMillis();
    AppMethodBeat.o(80930);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(80933);
    if (this.sYb.fZd == 0L) {
      this.sYb.fZd = System.currentTimeMillis();
    }
    if (this.CEM.eIL())
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
    if (!bs.isNullOrNil(str1))
    {
      str2 = Uri.parse(str1).getQueryParameter("nav_color");
      if (bs.isNullOrNil(str2)) {}
    }
    try
    {
      int i = Color.parseColor("#".concat(String.valueOf(str2)));
      getIntent().putExtra("customize_status_bar_color", i);
      label76:
      ac.i("MicroMsg.Wepkg.GameWebViewUI", "rawUrl rid:%s, pkgId:%s", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.aFA(str1), com.tencent.mm.plugin.wepkg.utils.d.aFy(str1) });
      if (getIntent().getLongExtra("gamecenterui_createtime", 0L) > 0L) {}
      for (this.sYb = GameWebPerformanceInfo.tq(str1);; this.sYb = GameWebPerformanceInfo.tr(str1))
      {
        this.sYb.url = str1;
        this.sYb.fYI = eFv();
        this.sYb.fYS = getIntent().getLongExtra("gamecenterui_createtime", 0L);
        this.sYb.fYT = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        this.sYb.startTime = getIntent().getLongExtra("start_time", this.sYb.fYT);
        this.sYb.fYY = System.currentTimeMillis();
        this.sYb.fYM = 1;
        ac.i("MicroMsg.Wepkg.GameWebViewUI", "onCreate, startTime: %d, gameCenterUICreate: %d, startWebUI: %d,webUICreate: %d", new Object[] { Long.valueOf(this.sYb.startTime), Long.valueOf(this.sYb.fYS), Long.valueOf(this.sYb.fYT), Long.valueOf(this.sYb.fYY) });
        this.sYo = h.aDB(str1);
        this.sYo.startTime = System.currentTimeMillis();
        this.CEM = new com.tencent.mm.plugin.wepkg.c();
        super.onCreate(paramBundle);
        if (this.nKq != null) {
          this.nKq.getSettings().setForceDarkBehavior(1);
        }
        paramBundle = getIntent();
        if ((paramBundle != null) && (paramBundle.getBooleanExtra("disable_progress_bar", false)))
        {
          this.CyR.msE = false;
          eFu();
        }
        if (this.nKq.getIsX5Kernel()) {
          this.nKq.setWebViewClientExtension(new a(this));
        }
        this.CEM.CZv = new com.tencent.mm.plugin.wepkg.event.b()
        {
          public final void cOX()
          {
            AppMethodBeat.i(80897);
            ac.i("MicroMsg.Wepkg.GameWebViewUI", "onReload");
            GameWebViewUI.a(GameWebViewUI.this);
            if (GameWebViewUI.b(GameWebViewUI.this)) {
              GameWebViewUI.c(GameWebViewUI.this);
            }
            AppMethodBeat.o(80897);
          }
          
          public final void cOY()
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
          
          public final void mH(final boolean paramAnonymousBoolean)
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
                    String str = GameWebViewUI.1.this.iuP;
                    if (!GameWebViewUI.i(GameWebViewUI.this)) {
                      bool = true;
                    }
                    localc.cq(str, bool);
                    GameWebViewUI.a(GameWebViewUI.this, GameWebViewUI.1.this.iuP);
                  }
                }
                AppMethodBeat.o(80896);
              }
            });
            AppMethodBeat.o(80899);
          }
        };
        this.CGg = getIntent().getBooleanExtra("open_game_float", false);
        paramBundle = this.CEM;
        if (!this.CGg) {
          bool = true;
        }
        if (paramBundle.cq(str1, bool))
        {
          ac.i("MicroMsg.Wepkg.GameWebViewUI", "current page use wepkg");
          this.CGf = true;
          eFu();
        }
        this.CGd = new GameMenuImageButton(getContext());
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
    this.CEM.uO(this.CGg);
    this.sYb.fZj = System.currentTimeMillis();
    com.tencent.mm.game.report.api.a.fYF.a(this.sYb);
    GameWebPerformanceInfo.ts(bLL());
    e.a(eFv(), this);
    h.aDE(bLL());
    AppMethodBeat.o(80928);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80927);
    super.onPause();
    GameWebPerformanceInfo localGameWebPerformanceInfo = this.sYb;
    localGameWebPerformanceInfo.fZi += System.currentTimeMillis() - this.sYn;
    AppMethodBeat.o(80927);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80926);
    super.onResume();
    if (this.sYb.fYZ == 0L)
    {
      long l = System.currentTimeMillis();
      ac.i("MicroMsg.Wepkg.GameWebViewUI", "onResume: ".concat(String.valueOf(l)));
      this.sYb.fYZ = l;
    }
    this.sYn = System.currentTimeMillis();
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
        this.landscapeMode = getSharedPreferences(ai.eUX(), 4).getBoolean("settings_landscape_mode", false);
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
  
  public final void uv(boolean paramBoolean)
  {
    AppMethodBeat.i(80924);
    super.uv(paramBoolean);
    ux(false);
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
      AppMethodBeat.i(188563);
      if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null))
      {
        AppMethodBeat.o(188563);
        return null;
      }
      if (paramWebResourceRequest.getUrl().toString().startsWith("weixin://game.js"))
      {
        paramWebView = d.uy(GameWebViewUI.j(GameWebViewUI.this).CZo);
        if (paramWebView != null)
        {
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramWebView = new com.tencent.xweb.WebResourceResponse(paramWebView.getMimeType(), paramWebView.getEncoding(), paramWebView.getStatusCode(), paramWebView.getReasonPhrase(), paramWebView.getResponseHeaders(), paramWebView.getData());
            AppMethodBeat.o(188563);
            return paramWebView;
          }
          paramWebView = new com.tencent.xweb.WebResourceResponse(paramWebView.getMimeType(), paramWebView.getEncoding(), paramWebView.getData());
          AppMethodBeat.o(188563);
          return paramWebView;
        }
        AppMethodBeat.o(188563);
        return null;
      }
      paramWebView = GameWebViewUI.j(GameWebViewUI.this).aET(paramWebResourceRequest.getUrl().toString());
      AppMethodBeat.o(188563);
      return paramWebView;
    }
    
    public final com.tencent.mm.plugin.webview.core.e eza()
    {
      AppMethodBeat.i(188561);
      a locala = new a((byte)0);
      AppMethodBeat.o(188561);
      return locala;
    }
    
    public final com.tencent.mm.plugin.webview.core.i ezb()
    {
      AppMethodBeat.i(188562);
      b localb = new b((byte)0);
      AppMethodBeat.o(188562);
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
        AppMethodBeat.i(188558);
        GameWebViewUI.y(GameWebViewUI.this);
        super.a(paramWebView, paramInt, paramString1, paramString2);
        AppMethodBeat.o(188558);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(188557);
        if (GameWebViewUI.w(GameWebViewUI.this).fZf == 0L) {
          GameWebViewUI.w(GameWebViewUI.this).fZf = System.currentTimeMillis();
        }
        if (GameWebViewUI.x(GameWebViewUI.this).CFH == 0L) {
          GameWebViewUI.x(GameWebViewUI.this).CFH = System.currentTimeMillis();
        }
        GameWebViewUI.y(GameWebViewUI.this);
        GameWebViewUI.j(GameWebViewUI.this).p(paramWebView, paramString);
        super.b(paramWebView, paramString);
        AppMethodBeat.o(188557);
      }
      
      public final void m(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(188556);
        if (GameWebViewUI.w(GameWebViewUI.this).fZe == 0L) {
          GameWebViewUI.w(GameWebViewUI.this).fZe = System.currentTimeMillis();
        }
        if (GameWebViewUI.x(GameWebViewUI.this).CFG == 0L) {
          GameWebViewUI.x(GameWebViewUI.this).CFG = System.currentTimeMillis();
        }
        GameWebViewUI.j(GameWebViewUI.this).o(paramWebView, paramString);
        AppMethodBeat.o(188556);
      }
    }
    
    final class b
      extends com.tencent.mm.plugin.webview.core.i
    {
      private b() {}
      
      public final void aAY(String paramString)
      {
        AppMethodBeat.i(188560);
        if (GameWebViewUI.w(GameWebViewUI.this).fZh == 0L) {
          GameWebViewUI.w(GameWebViewUI.this).fZh = System.currentTimeMillis();
        }
        if (GameWebViewUI.x(GameWebViewUI.this).CFJ == 0L) {
          GameWebViewUI.x(GameWebViewUI.this).CFJ = System.currentTimeMillis();
        }
        GameWebViewUI.A(GameWebViewUI.this);
        if (GameWebViewUI.B(GameWebViewUI.this)) {
          GameWebViewUI.c(GameWebViewUI.this);
        }
        AppMethodBeat.o(188560);
      }
      
      public final void bk(int paramInt, String paramString)
      {
        AppMethodBeat.i(188559);
        if (GameWebViewUI.w(GameWebViewUI.this).fZg == 0L) {
          GameWebViewUI.w(GameWebViewUI.this).fZg = System.currentTimeMillis();
        }
        if (GameWebViewUI.x(GameWebViewUI.this).CFI == 0L) {
          GameWebViewUI.x(GameWebViewUI.this).CFI = System.currentTimeMillis();
        }
        AppMethodBeat.o(188559);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI
 * JD-Core Version:    0.7.0.1
 */