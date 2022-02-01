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
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.d.dm;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.f.72;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.model.ay.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.l;
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
  private static String EjI = "wx_fullscreen";
  public com.tencent.mm.plugin.wepkg.d Eiw;
  private boolean EjH;
  private HashMap<String, String> EjJ;
  private Drawable EjK;
  private Drawable EjL;
  private String EjM;
  private Map<Integer, byv> EjN;
  private String EjO;
  private GameMenuImageButton EjP;
  private boolean EjQ;
  private boolean EjR;
  private boolean EjS;
  private ViewGroup EjT;
  private boolean EjU;
  private boolean EjV;
  private boolean tTj;
  public g tVA;
  public GameWebPerformanceInfo tVm;
  private boolean tVn;
  private Object tVo;
  private long tVz;
  
  public GameWebViewUI()
  {
    AppMethodBeat.i(80915);
    this.tTj = false;
    this.EjH = false;
    this.EjJ = new HashMap();
    this.EjM = null;
    this.EjN = new HashMap();
    this.EjR = false;
    this.tVn = false;
    this.tVo = new Object();
    this.EjU = false;
    this.EjV = false;
    AppMethodBeat.o(80915);
  }
  
  private l eUp()
  {
    AppMethodBeat.i(80918);
    try
    {
      List localList = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.Ekd;
      new Bundle().putString("game_hv_menu_appid", this.EjO);
      this.EjN.clear();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        byv localbyv = (byv)localIterator.next();
        this.EjN.put(Integer.valueOf(localbyv.GTY), localbyv);
      }
      locall = c.c(this, localException);
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
  
  private void eUq()
  {
    AppMethodBeat.i(80937);
    if (this.EcB != null) {
      this.EcB.setVisibility(0);
    }
    AppMethodBeat.o(80937);
  }
  
  public final void aO(Bundle paramBundle)
  {
    AppMethodBeat.i(80922);
    super.aO(paramBundle);
    AppMethodBeat.o(80922);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(80925);
    if (this.EjQ) {
      super.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    AppMethodBeat.o(80925);
  }
  
  public boolean bQO()
  {
    AppMethodBeat.i(80938);
    getIntent().putExtra("minimize_secene", 2);
    AppMethodBeat.o(80938);
    return true;
  }
  
  public final void bQS()
  {
    AppMethodBeat.i(80919);
    if (this.EdR.Ebg) {
      this.EdR.eSg();
    }
    if ((this.EjP == null) || (!this.EjP.oqn))
    {
      super.bQS();
      AppMethodBeat.o(80919);
      return;
    }
    final com.tencent.mm.plugin.webview.ui.tools.game.menu.d locald = new com.tencent.mm.plugin.webview.ui.tools.game.menu.d(getContext());
    locald.a(new b.c()
    {
      public final void c(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(80900);
        paramAnonymousMenuItem = (byv)GameWebViewUI.l(GameWebViewUI.this).get(Integer.valueOf(paramAnonymousMenuItem.getItemId()));
        if (paramAnonymousMenuItem == null)
        {
          AppMethodBeat.o(80900);
          return;
        }
        switch (GameWebViewUI.8.EjZ[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.XJ(paramAnonymousMenuItem.FJz).ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(80900);
          return;
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramAnonymousMenuItem.Gsq);
          com.tencent.mm.bs.d.b(GameWebViewUI.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          AppMethodBeat.o(80900);
          return;
          GameWebViewUI.this.DIg.eQG().C(new Object[] { GameWebViewUI.this.bQm(), Integer.valueOf(32), Integer.valueOf(1) }).report();
          if (!GameWebViewUI.m(GameWebViewUI.this))
          {
            GameWebViewUI.this.finish();
            AppMethodBeat.o(80900);
            return;
            paramAnonymousMenuItem = GameWebViewUI.this.getIntent().getStringExtra("KPublisherId");
            localObject = GameWebViewUI.this.getIntent().getStringExtra("KAppId");
            String str = GameWebViewUI.this.getIntent().getStringExtra("srcUsername");
            GameWebViewUI.this.DIg.eQG().C(new Object[] { GameWebViewUI.this.bQm(), Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem, localObject, str }).report();
            GameWebViewUI.n(GameWebViewUI.this);
            AppMethodBeat.o(80900);
            return;
            GameWebViewUI.this.DIg.eQG().C(new Object[] { GameWebViewUI.this.bQm(), Integer.valueOf(3), Integer.valueOf(1) }).report();
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(157L, 6L, 1L, false);
            GameWebViewUI.o(GameWebViewUI.this);
            AppMethodBeat.o(80900);
            return;
            GameWebViewUI.this.DIg.eQG().C(new Object[] { GameWebViewUI.this.bQm(), Integer.valueOf(10), Integer.valueOf(1) }).report();
            if (GameWebViewUI.p(GameWebViewUI.this) != null)
            {
              GameWebViewUI.q(GameWebViewUI.this).reload();
              AppMethodBeat.o(80900);
              return;
              GameWebViewUI.this.DIg.eQG().C(new Object[] { GameWebViewUI.this.bQm(), Integer.valueOf(31), Integer.valueOf(1) }).report();
              GameWebViewUI.r(GameWebViewUI.this);
              AppMethodBeat.o(80900);
              return;
              GameWebViewUI.this.DIg.eQG().C(new Object[] { GameWebViewUI.this.bQm(), Integer.valueOf(11), Integer.valueOf(1) }).report();
              GameWebViewUI.s(GameWebViewUI.this);
              AppMethodBeat.o(80900);
              return;
              if (GameWebViewUI.this.DzP != null)
              {
                localObject = GameWebViewUI.this.DzP;
                int i = paramAnonymousMenuItem.GTY;
                if (!((f)localObject).BHY)
                {
                  ad.e("MicroMsg.JsApiHandler", "not ready");
                  AppMethodBeat.o(80900);
                  return;
                }
                ad.i("MicroMsg.JsApiHandler", "onCustomGameMenuClicked");
                paramAnonymousMenuItem = new HashMap();
                paramAnonymousMenuItem.put("itemId", Integer.valueOf(i));
                aq.f(new f.72((f)localObject, l.a.b("onCustomGameMenuClicked", paramAnonymousMenuItem, ((f)localObject).DMD, ((f)localObject).vJP)));
              }
            }
          }
        }
      }
    });
    locald.Eks = new b.b()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(80901);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(480L, 0L, 1L, false);
        l locall = GameWebViewUI.t(GameWebViewUI.this);
        if (locall != null) {
          paramAnonymousl.JlY.addAll(locall.JlY);
        }
        AppMethodBeat.o(80901);
      }
    };
    if (this.EcL) {
      locald.lzG = true;
    }
    for (locald.lzH = true; (this.EcP != null) && (this.EcP.isShown()); locald.lzH = false)
    {
      this.EcP.hide();
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80902);
          if ((GameWebViewUI.this.isFinishing()) || (GameWebViewUI.u(GameWebViewUI.this)))
          {
            ad.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
            AppMethodBeat.o(80902);
            return;
          }
          locald.cMW();
          AppMethodBeat.o(80902);
        }
      }, 100L);
      AppMethodBeat.o(80919);
      return;
      locald.lzG = false;
    }
    hideVKB();
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80903);
        if ((GameWebViewUI.this.isFinishing()) || (GameWebViewUI.v(GameWebViewUI.this)))
        {
          ad.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
          AppMethodBeat.o(80903);
          return;
        }
        locald.cMW();
        AppMethodBeat.o(80903);
      }
    }, 100L);
    AppMethodBeat.o(80919);
  }
  
  public final h bRd()
  {
    AppMethodBeat.i(208234);
    h localh = super.bRd();
    if (localh != null) {
      localh.a(new c((byte)0));
    }
    AppMethodBeat.o(208234);
    return localh;
  }
  
  public final void bzn()
  {
    AppMethodBeat.i(80923);
    super.bzn();
    this.EjQ = true;
    int i;
    if ((this.tTj) || (this.ulT != null) || (this.ulS != 0)) {
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i != 0)
      {
        localObject = com.tencent.mm.plugin.game.commlib.a.cWQ();
        if ((localObject == null) || (bt.isNullOrNil(((dm)localObject).hAD)) || (bt.isNullOrNil(((dm)localObject).ujP))) {}
      }
      try
      {
        if (al.isDarkMode()) {}
        for (this.ulS = Color.parseColor(((dm)localObject).ujP);; this.ulS = Color.parseColor(((dm)localObject).hAD))
        {
          this.ulT = ((dm)localObject).udZ;
          eSJ();
          vg(true);
          localObject = getIntent();
          if ((localObject == null) || (!((Intent)localObject).getBooleanExtra("game_check_float", false))) {
            break label421;
          }
          i = ((Intent)localObject).getIntExtra("game_sourceScene", 0);
          this.EjM = ((Intent)localObject).getStringExtra("game_transparent_float_url");
          if (!bt.isNullOrNil(this.EjM)) {
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
          if (this.lvv != null) {
            this.lvv.k(91, (Bundle)localObject);
          }
          if (this.Eij == null) {
            this.Eij = new a(this, this.EcJ, this.EjM);
          }
          localObject = this.Eij;
          String str = this.EjM;
          ((a)localObject).tVg = str;
          ((a)localObject).Eiw.k(str, false, false);
          if ((((a)localObject).hJc != null) && (((a)localObject).hJc.getParent() == null))
          {
            ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
            ((a)localObject).WA.addView(((a)localObject).hJc, localLayoutParams);
          }
          if ((((a)localObject).hJc != null) && (((a)localObject).Eix != null)) {
            ((a)localObject).hJc.post(new a.3((a)localObject, str));
          }
          this.EjM = null;
          AppMethodBeat.o(80923);
          return;
        }
        catch (RemoteException localRemoteException) {}
        label421:
        AppMethodBeat.o(80923);
      }
    }
  }
  
  public final Map<Integer, Object> cXy()
  {
    AppMethodBeat.i(208235);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(d.a.EiM), eUr());
    localHashMap.put(Integer.valueOf(d.a.EiN), com.tencent.mm.sdk.platformtools.ay.iR(aj.getContext()));
    localHashMap.put(Integer.valueOf(d.a.EiO), String.valueOf(YearClass.get(aj.getContext())));
    String str = bQm();
    try
    {
      localHashMap.put(Integer.valueOf(d.a.EiP), q.encode(bt.nullAsNil(str), "UTF-8"));
      label92:
      localHashMap.put(Integer.valueOf(d.a.EiQ), Boolean.valueOf(this.Eiw.aKu(str)));
      localHashMap.put(Integer.valueOf(d.a.EiR), Integer.valueOf(0));
      localHashMap.put(Integer.valueOf(d.a.EiS), Integer.valueOf(0));
      localHashMap.put(Integer.valueOf(d.a.EiT), this.Eiw.eXF());
      localHashMap.put(Integer.valueOf(d.a.EiU), com.tencent.mm.plugin.wepkg.d.eXG());
      AppMethodBeat.o(208235);
      return localHashMap;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label92;
    }
  }
  
  public final Map<Integer, Object> cXz()
  {
    AppMethodBeat.i(208236);
    HashMap localHashMap = new HashMap();
    g localg = g.aJe(bQm());
    if (localg != null)
    {
      localHashMap.put(Integer.valueOf(d.b.EiX), Long.valueOf(localg.Ejq - localg.startTime));
      localHashMap.put(Integer.valueOf(d.b.EiY), Long.valueOf(localg.Ejr - localg.startTime));
      localHashMap.put(Integer.valueOf(d.b.EiZ), Long.valueOf(localg.Ejs - localg.Ejr));
      localHashMap.put(Integer.valueOf(d.b.Eja), Long.valueOf(localg.Eju - localg.Ejt));
      localHashMap.put(Integer.valueOf(d.b.Ejb), Long.valueOf(localg.Ejw - localg.Ejv));
      localHashMap.put(Integer.valueOf(d.b.Ejj), Long.valueOf(localg.Ejx));
    }
    localHashMap.put(Integer.valueOf(d.b.Ejk), Integer.valueOf(0));
    AppMethodBeat.o(208236);
    return localHashMap;
  }
  
  public final int eSP()
  {
    AppMethodBeat.i(80921);
    int i = super.eSP();
    AppMethodBeat.o(80921);
    return i;
  }
  
  public final void eSQ()
  {
    AppMethodBeat.i(80931);
    super.eSQ();
    this.EjO = getIntent().getStringExtra("game_hv_menu_appid");
    if ((this.EcL) && (!bt.isNullOrNil(this.EjO)))
    {
      if (this.EcK != null) {
        this.EcK.setVisibility(8);
      }
      this.EjP.a(this.EcI, new GameMenuImageButton.a()
      {
        public final void cXC()
        {
          AppMethodBeat.i(80904);
          GameWebViewUI.this.bQS();
          AppMethodBeat.o(80904);
        }
      });
    }
    AppMethodBeat.o(80931);
  }
  
  public final x eSR()
  {
    try
    {
      AppMethodBeat.i(80917);
      if (this.Edl == null) {
        this.Edl = new b();
      }
      x localx = this.Edl;
      AppMethodBeat.o(80917);
      return localx;
    }
    finally {}
  }
  
  public final String eUr()
  {
    AppMethodBeat.i(208237);
    String str = (hashCode() & 0x7FFFFFFF) + "_" + (bQm().hashCode() & 0x7FFFFFFF);
    AppMethodBeat.o(208237);
    return str;
  }
  
  public final void fQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(80920);
    super.fQ(paramString, paramInt);
    AppMethodBeat.o(80920);
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(80929);
    this.tVm.gsw = System.currentTimeMillis();
    int i = super.getLayoutId();
    AppMethodBeat.o(80929);
    return i;
  }
  
  public void initView()
  {
    AppMethodBeat.i(80930);
    super.initView();
    this.EjK = new ColorDrawable(android.support.v4.content.b.n(this, 2131099879));
    this.EjL = new ColorDrawable(android.support.v4.content.b.n(this, 2131099879));
    this.tVm.gsx = System.currentTimeMillis();
    this.tVA.Ejq = System.currentTimeMillis();
    AppMethodBeat.o(80930);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(80933);
    if (this.tVm.gsz == 0L) {
      this.tVm.gsz = System.currentTimeMillis();
    }
    if (this.Eiw.eXE())
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
      label74:
      ad.i("MicroMsg.Wepkg.GameWebViewUI", "rawUrl rid:%s, pkgId:%s", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.aLa(str1), com.tencent.mm.plugin.wepkg.utils.d.aKY(str1) });
      if (getIntent().getLongExtra("gamecenterui_createtime", 0L) > 0L)
      {
        this.tVm = GameWebPerformanceInfo.wg(str1);
        this.tVm.url = str1;
        this.tVm.gse = eUr();
        this.tVm.gso = getIntent().getLongExtra("gamecenterui_createtime", 0L);
        this.tVm.gsp = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        this.tVm.startTime = getIntent().getLongExtra("start_time", this.tVm.gsp);
        this.tVm.gsu = System.currentTimeMillis();
        this.tVm.gsi = 1;
        ad.i("MicroMsg.Wepkg.GameWebViewUI", "onCreate, startTime: %d, gameCenterUICreate: %d, startWebUI: %d,webUICreate: %d", new Object[] { Long.valueOf(this.tVm.startTime), Long.valueOf(this.tVm.gso), Long.valueOf(this.tVm.gsp), Long.valueOf(this.tVm.gsu) });
        this.tVA = g.aJc(str1);
        this.tVA.startTime = System.currentTimeMillis();
        this.Eiw = new com.tencent.mm.plugin.wepkg.d();
        super.onCreate(paramBundle);
        if (this.omW != null) {
          this.omW.getSettings().setForceDarkBehavior(1);
        }
        paramBundle = getIntent();
        if ((paramBundle != null) && (paramBundle.getBooleanExtra("disable_progress_bar", false)))
        {
          this.EcA.mTk = false;
          eUq();
        }
        if (this.omW.getIsX5Kernel()) {
          this.omW.setWebViewClientExtension(new a(this));
        }
        this.Eiw.EDt = new com.tencent.mm.plugin.wepkg.event.b()
        {
          public final void cXA()
          {
            AppMethodBeat.i(80897);
            ad.i("MicroMsg.Wepkg.GameWebViewUI", "onReload");
            GameWebViewUI.a(GameWebViewUI.this);
            if (GameWebViewUI.b(GameWebViewUI.this)) {
              GameWebViewUI.c(GameWebViewUI.this);
            }
            AppMethodBeat.o(80897);
          }
          
          public final void cXB()
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
          
          public final void nb(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(80899);
            GameWebViewUI.k(GameWebViewUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80896);
                com.tencent.mm.plugin.wepkg.d locald;
                String str;
                if (GameWebViewUI.d(GameWebViewUI.this))
                {
                  GameWebViewUI.a(GameWebViewUI.this, false);
                  GameWebViewUI.g(GameWebViewUI.this);
                  if (paramAnonymousBoolean)
                  {
                    GameWebViewUI.h(GameWebViewUI.this).stopLoading();
                    locald = GameWebViewUI.j(GameWebViewUI.this);
                    str = GameWebViewUI.1.this.iNS;
                    if (GameWebViewUI.i(GameWebViewUI.this)) {
                      break label125;
                    }
                  }
                }
                label125:
                for (boolean bool = true;; bool = false)
                {
                  locald.k(str, bool, false);
                  GameWebViewUI.a(GameWebViewUI.this, GameWebViewUI.1.this.iNS);
                  AppMethodBeat.o(80896);
                  return;
                }
              }
            });
            AppMethodBeat.o(80899);
          }
        };
        this.EjS = getIntent().getBooleanExtra("open_game_float", false);
        paramBundle = this.Eiw;
        if (this.EjS) {
          break label513;
        }
      }
      label513:
      for (boolean bool = true;; bool = false)
      {
        if (paramBundle.k(str1, bool, false))
        {
          ad.i("MicroMsg.Wepkg.GameWebViewUI", "current page use wepkg");
          this.EjR = true;
          eUq();
        }
        this.EjP = new GameMenuImageButton(getContext());
        AppMethodBeat.o(80916);
        return;
        this.tVm = GameWebPerformanceInfo.wh(str1);
        break;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label74;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80928);
    super.onDestroy();
    this.Eiw.vz(this.EjS);
    this.tVm.gsF = System.currentTimeMillis();
    com.tencent.mm.game.report.api.a.gsb.a(this.tVm);
    GameWebPerformanceInfo.wi(bQm());
    d.a(eUr(), this);
    g.aJf(bQm());
    AppMethodBeat.o(80928);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80927);
    super.onPause();
    GameWebPerformanceInfo localGameWebPerformanceInfo = this.tVm;
    localGameWebPerformanceInfo.gsE += System.currentTimeMillis() - this.tVz;
    AppMethodBeat.o(80927);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80926);
    super.onResume();
    if (this.tVm.gsv == 0L)
    {
      long l = System.currentTimeMillis();
      ad.i("MicroMsg.Wepkg.GameWebViewUI", "onResume: ".concat(String.valueOf(l)));
      this.tVm.gsv = l;
    }
    this.tVz = System.currentTimeMillis();
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
        this.landscapeMode = getSharedPreferences(aj.fkC(), 4).getBoolean("settings_landscape_mode", false);
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
  
  public final void vg(boolean paramBoolean)
  {
    AppMethodBeat.i(80924);
    super.vg(paramBoolean);
    vi(false);
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
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(208233);
      if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null))
      {
        AppMethodBeat.o(208233);
        return null;
      }
      paramWebView = GameWebViewUI.j(GameWebViewUI.this).o(paramWebView, paramWebResourceRequest.getUrl().toString());
      AppMethodBeat.o(208233);
      return paramWebView;
    }
    
    public final com.tencent.mm.plugin.webview.core.e eNP()
    {
      AppMethodBeat.i(208231);
      a locala = new a((byte)0);
      AppMethodBeat.o(208231);
      return locala;
    }
    
    public final com.tencent.mm.plugin.webview.core.i eNQ()
    {
      AppMethodBeat.i(208232);
      b localb = new b((byte)0);
      AppMethodBeat.o(208232);
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
        AppMethodBeat.i(208228);
        GameWebViewUI.A(GameWebViewUI.this);
        super.a(paramWebView, paramInt, paramString1, paramString2);
        AppMethodBeat.o(208228);
      }
      
      public final void aGk(String paramString)
      {
        AppMethodBeat.i(208226);
        if (GameWebViewUI.w(GameWebViewUI.this).gsA == 0L) {
          GameWebViewUI.w(GameWebViewUI.this).gsA = System.currentTimeMillis();
        }
        if (GameWebViewUI.x(GameWebViewUI.this).Ejr == 0L) {
          GameWebViewUI.x(GameWebViewUI.this).Ejr = System.currentTimeMillis();
        }
        GameWebViewUI.j(GameWebViewUI.this).aKt(paramString);
        AppMethodBeat.o(208226);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(208227);
        if (GameWebViewUI.w(GameWebViewUI.this).gsB == 0L) {
          GameWebViewUI.w(GameWebViewUI.this).gsB = System.currentTimeMillis();
        }
        if (GameWebViewUI.x(GameWebViewUI.this).Ejs == 0L) {
          GameWebViewUI.x(GameWebViewUI.this).Ejs = System.currentTimeMillis();
        }
        GameWebViewUI.A(GameWebViewUI.this);
        GameWebViewUI.j(GameWebViewUI.this).n(paramWebView, paramString);
        super.b(paramWebView, paramString);
        AppMethodBeat.o(208227);
      }
    }
    
    final class b
      extends com.tencent.mm.plugin.webview.core.i
    {
      private b() {}
      
      public final void aGt(String paramString)
      {
        AppMethodBeat.i(208230);
        if (GameWebViewUI.w(GameWebViewUI.this).gsD == 0L) {
          GameWebViewUI.w(GameWebViewUI.this).gsD = System.currentTimeMillis();
        }
        if (GameWebViewUI.x(GameWebViewUI.this).Eju == 0L) {
          GameWebViewUI.x(GameWebViewUI.this).Eju = System.currentTimeMillis();
        }
        GameWebViewUI.y(GameWebViewUI.this);
        if (GameWebViewUI.z(GameWebViewUI.this)) {
          GameWebViewUI.c(GameWebViewUI.this);
        }
        AppMethodBeat.o(208230);
      }
      
      public final void bn(int paramInt, String paramString)
      {
        AppMethodBeat.i(208229);
        if (GameWebViewUI.w(GameWebViewUI.this).gsC == 0L) {
          GameWebViewUI.w(GameWebViewUI.this).gsC = System.currentTimeMillis();
        }
        if (GameWebViewUI.x(GameWebViewUI.this).Ejt == 0L) {
          GameWebViewUI.x(GameWebViewUI.this).Ejt = System.currentTimeMillis();
        }
        AppMethodBeat.o(208229);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI
 * JD-Core Version:    0.7.0.1
 */