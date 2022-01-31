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
import android.support.v4.content.b;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.d.dd;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.w;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.j;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GameWebViewUI
  extends GameBaseWebViewUI
{
  private static String vng = "wx_fullscreen";
  private boolean njd;
  private long nkH;
  public g nkK;
  public GameWebPerformanceInfo nkv;
  private ViewGroup nkw;
  private boolean nkx;
  private Object nky;
  public com.tencent.mm.plugin.wepkg.c vmq;
  private boolean vnf;
  private HashMap<String, String> vnh;
  private Drawable vni;
  private Drawable vnj;
  private String vnk;
  private Map<Integer, bcz> vnl;
  private String vnm;
  private GameMenuImageButton vnn;
  private boolean vno;
  private boolean vnp;
  private boolean vnq;
  private boolean vnr;
  private boolean vns;
  
  public GameWebViewUI()
  {
    AppMethodBeat.i(8740);
    this.njd = false;
    this.vnf = false;
    this.vnh = new HashMap();
    this.vnk = null;
    this.vnl = new HashMap();
    this.vnp = false;
    this.nkx = false;
    this.nky = new Object();
    this.vnr = false;
    this.vns = false;
    AppMethodBeat.o(8740);
  }
  
  private l dgc()
  {
    AppMethodBeat.i(8743);
    try
    {
      List localList = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.vnz;
      new Bundle().putString("game_hv_menu_appid", this.vnm);
      this.vnl.clear();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        bcz localbcz = (bcz)localIterator.next();
        this.vnl.put(Integer.valueOf(localbcz.xsZ), localbcz);
      }
      locall = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.c(this, localException);
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.Wepkg.GameWebViewUI", "get cache hv game menu fail! exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(8743);
      return null;
    }
    l locall;
    AppMethodBeat.o(8743);
    return locall;
  }
  
  private void dgd()
  {
    AppMethodBeat.i(8762);
    if (this.vee != null) {
      this.vee.setVisibility(0);
    }
    AppMethodBeat.o(8762);
  }
  
  private void dge()
  {
    AppMethodBeat.i(8764);
    this.vnr = false;
    this.vns = false;
    al.p(new GameWebViewUI.7(this), 100L);
    AppMethodBeat.o(8764);
  }
  
  public final void aMf()
  {
    AppMethodBeat.i(8748);
    super.aMf();
    this.vno = true;
    int i;
    if ((this.njd) || (this.nvY != null) || (this.nvX != 0)) {
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i != 0)
      {
        localObject = com.tencent.mm.plugin.game.commlib.a.bFc();
        if ((localObject == null) || (bo.isNullOrNil(((dd)localObject).color))) {}
      }
      try
      {
        this.nvX = Color.parseColor(((dd)localObject).color);
        this.nvY = ((dd)localObject).noW;
        dej();
        or(true);
        localObject = getIntent();
        if ((localObject != null) && (((Intent)localObject).getBooleanExtra("game_check_float", false)))
        {
          i = ((Intent)localObject).getIntExtra("game_sourceScene", 0);
          this.vnk = ((Intent)localObject).getStringExtra("game_transparent_float_url");
          if (bo.isNullOrNil(this.vnk))
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("game_check_float", true);
            ((Intent)localObject).putExtra("game_sourceScene", i);
            com.tencent.mm.bq.d.b(this, "game", ".ui.GameCenterUI", (Intent)localObject);
            AppMethodBeat.o(8748);
            return;
            i = 1;
          }
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          ab.e("MicroMsg.Wepkg.GameWebViewUI", "parse color: " + localIllegalArgumentException.getMessage());
        }
        try
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("game_sourceScene", i);
          if (this.igU != null) {
            this.igU.i(91, (Bundle)localObject);
          }
          if (this.vmg == null) {
            this.vmg = new a(this, this.vek, this.vnk);
          }
          localObject = this.vmg;
          String str = this.vnk;
          ((a)localObject).nkp = str;
          ((a)localObject).vmq.bV(str, false);
          if ((((a)localObject).foJ != null) && (((a)localObject).foJ.getParent() == null))
          {
            ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
            ((a)localObject).MO.addView(((a)localObject).foJ, localLayoutParams);
          }
          if ((((a)localObject).foJ != null) && (((a)localObject).vmr != null)) {
            ((a)localObject).foJ.post(new a.3((a)localObject, str));
          }
          this.vnk = null;
          AppMethodBeat.o(8748);
          return;
        }
        catch (RemoteException localRemoteException) {}
        AppMethodBeat.o(8748);
      }
    }
  }
  
  public final p aYN()
  {
    try
    {
      AppMethodBeat.i(8742);
      if (this.veY == null) {
        this.veY = new GameWebViewUI.b(this);
      }
      p localp = this.veY;
      AppMethodBeat.o(8742);
      return localp;
    }
    finally {}
  }
  
  public boolean aYi()
  {
    AppMethodBeat.i(8763);
    getIntent().putExtra("minimize_secene", 2);
    AppMethodBeat.o(8763);
    return true;
  }
  
  public final void aYo()
  {
    AppMethodBeat.i(8744);
    if (this.vfS.vcJ) {
      this.vfS.ddO();
    }
    if ((this.vnn == null) || (!this.vnn.vnA))
    {
      super.aYo();
      AppMethodBeat.o(8744);
      return;
    }
    com.tencent.mm.plugin.webview.ui.tools.game.menu.d locald = new com.tencent.mm.plugin.webview.ui.tools.game.menu.d(getContext());
    locald.a(new GameWebViewUI.2(this));
    locald.vnP = new GameWebViewUI.3(this);
    if (this.ven) {
      locald.vnU = true;
    }
    for (locald.vnV = true; (this.ves != null) && (this.ves.isShown()); locald.vnV = false)
    {
      this.ves.hide();
      al.p(new GameWebViewUI.4(this, locald), 100L);
      AppMethodBeat.o(8744);
      return;
      locald.vnU = false;
    }
    hideVKB();
    al.p(new GameWebViewUI.5(this, locald), 100L);
    AppMethodBeat.o(8744);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(8750);
    if (this.vno) {
      super.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
    AppMethodBeat.o(8750);
  }
  
  public final boolean aip(String paramString)
  {
    AppMethodBeat.i(8757);
    boolean bool = this.vmq.akk(paramString);
    AppMethodBeat.o(8757);
    return bool;
  }
  
  public final void al(Bundle paramBundle)
  {
    AppMethodBeat.i(8747);
    super.al(paramBundle);
    AppMethodBeat.o(8747);
  }
  
  public final WebViewUI.w ax(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(8760);
    if (this.nkv.eAn == 0L) {
      this.nkv.eAn = System.currentTimeMillis();
    }
    if (this.nkK.vna == 0L) {
      this.nkK.vna = System.currentTimeMillis();
    }
    paramString = super.ax(paramString, paramBoolean);
    AppMethodBeat.o(8760);
    return paramString;
  }
  
  public final void b(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(8758);
    if (this.nkv.eAk == 0L) {
      this.nkv.eAk = System.currentTimeMillis();
    }
    if (this.vmq.dkj())
    {
      super.b(paramString, paramMap, false);
      AppMethodBeat.o(8758);
      return;
    }
    super.b(paramString, paramMap, paramBoolean);
    AppMethodBeat.o(8758);
  }
  
  public final void dS(String paramString, int paramInt)
  {
    AppMethodBeat.i(8745);
    super.dS(paramString, paramInt);
    AppMethodBeat.o(8745);
  }
  
  public final int daT()
  {
    AppMethodBeat.i(8746);
    int i = super.daT();
    AppMethodBeat.o(8746);
    return i;
  }
  
  public final void deo()
  {
    AppMethodBeat.i(8756);
    super.deo();
    this.vnm = getIntent().getStringExtra("game_hv_menu_appid");
    if ((this.ven) && (!bo.isNullOrNil(this.vnm)))
    {
      if (this.vem != null) {
        this.vem.setVisibility(8);
      }
      this.vnn.a(this.vej, new GameWebViewUI.6(this));
    }
    AppMethodBeat.o(8756);
  }
  
  public final void dey()
  {
    AppMethodBeat.i(8761);
    if (this.nkv.eAo == 0L) {
      this.nkv.eAo = System.currentTimeMillis();
    }
    if (this.nkK.vnb == 0L) {
      this.nkK.vnb = System.currentTimeMillis();
    }
    this.vnr = true;
    if (this.vns) {
      dge();
    }
    AppMethodBeat.o(8761);
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(8754);
    this.nkv.eAh = System.currentTimeMillis();
    int i = super.getLayoutId();
    AppMethodBeat.o(8754);
    return i;
  }
  
  public void initView()
  {
    AppMethodBeat.i(8755);
    super.initView();
    this.vni = new ColorDrawable(b.m(this, 2131689646));
    this.vnj = new ColorDrawable(b.m(this, 2131689646));
    this.nkv.eAi = System.currentTimeMillis();
    this.nkK.vmX = System.currentTimeMillis();
    AppMethodBeat.o(8755);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(8741);
    String str1 = getIntent().getStringExtra("rawUrl");
    String str2;
    if (!bo.isNullOrNil(str1))
    {
      str2 = Uri.parse(str1).getQueryParameter("nav_color");
      if (bo.isNullOrNil(str2)) {}
    }
    try
    {
      int i = Color.parseColor("#".concat(String.valueOf(str2)));
      getIntent().putExtra("customize_status_bar_color", i);
      label76:
      ab.i("MicroMsg.Wepkg.GameWebViewUI", "rawUrl rid:%s, pkgId:%s", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.akO(str1), com.tencent.mm.plugin.wepkg.utils.d.akM(str1) });
      if (getIntent().getLongExtra("gamecenterui_createtime", 0L) > 0L) {}
      for (this.nkv = GameWebPerformanceInfo.lN(str1);; this.nkv = GameWebPerformanceInfo.lO(str1))
      {
        this.nkv.url = str1;
        this.nkv.ezP = ((hashCode() & 0x7FFFFFFF) + "_" + (daZ().hashCode() & 0x7FFFFFFF));
        this.nkv.ezZ = getIntent().getLongExtra("gamecenterui_createtime", 0L);
        this.nkv.eAa = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        this.nkv.startTime = getIntent().getLongExtra("start_time", this.nkv.eAa);
        this.nkv.eAf = System.currentTimeMillis();
        this.nkv.ezT = 1;
        ab.i("MicroMsg.Wepkg.GameWebViewUI", "onCreate, startTime: %d, gameCenterUICreate: %d, startWebUI: %d,webUICreate: %d", new Object[] { Long.valueOf(this.nkv.startTime), Long.valueOf(this.nkv.ezZ), Long.valueOf(this.nkv.eAa), Long.valueOf(this.nkv.eAf) });
        this.nkK = g.aiN(str1);
        this.nkK.startTime = System.currentTimeMillis();
        super.onCreate(paramBundle);
        paramBundle = getIntent();
        if ((paramBundle != null) && (paramBundle.getBooleanExtra("disable_progress_bar", false)))
        {
          this.ved.jaH = false;
          dgd();
        }
        this.pOd.setWebViewClient(new GameWebViewUI.c(this, (byte)0));
        if (this.pOd.getIsX5Kernel()) {
          this.pOd.setWebViewClientExtension(new GameWebViewUI.a(this, this));
        }
        this.vmq = new com.tencent.mm.plugin.wepkg.c();
        this.vmq.vEF = new GameWebViewUI.1(this, str1);
        this.vnq = getIntent().getBooleanExtra("open_game_float", false);
        paramBundle = this.vmq;
        if (!this.vnq) {
          bool = true;
        }
        if (paramBundle.bV(str1, bool))
        {
          ab.i("MicroMsg.Wepkg.GameWebViewUI", "current page use wepkg");
          this.vnp = true;
          dgd();
        }
        this.vnn = new GameMenuImageButton(getContext());
        AppMethodBeat.o(8741);
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
    AppMethodBeat.i(8753);
    super.onDestroy();
    this.vmq.oW(this.vnq);
    this.nkv.eAq = System.currentTimeMillis();
    com.tencent.mm.game.report.api.a.ezM.a(this.nkv);
    GameWebPerformanceInfo.lP(daZ());
    e.aiM(this.cJr);
    g.aiP(this.cJr);
    AppMethodBeat.o(8753);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(8752);
    super.onPause();
    GameWebPerformanceInfo localGameWebPerformanceInfo = this.nkv;
    localGameWebPerformanceInfo.eAp += System.currentTimeMillis() - this.nkH;
    AppMethodBeat.o(8752);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(8751);
    super.onResume();
    if (this.nkv.eAg == 0L)
    {
      long l = System.currentTimeMillis();
      ab.i("MicroMsg.Wepkg.GameWebViewUI", "onResume: ".concat(String.valueOf(l)));
      this.nkv.eAg = l;
    }
    this.nkH = System.currentTimeMillis();
    AppMethodBeat.o(8751);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void or(boolean paramBoolean)
  {
    AppMethodBeat.i(8749);
    super.or(paramBoolean);
    ou(false);
    AppMethodBeat.o(8749);
  }
  
  public void setMMOrientation()
  {
    AppMethodBeat.i(8759);
    if (Build.VERSION.SDK_INT > 10)
    {
      if (getForceOrientation() == -1)
      {
        this.landscapeMode = getSharedPreferences(ah.dsP(), 4).getBoolean("settings_landscape_mode", false);
        if (this.landscapeMode)
        {
          setRequestedOrientation(2);
          AppMethodBeat.o(8759);
          return;
        }
        setRequestedOrientation(1);
        AppMethodBeat.o(8759);
        return;
      }
      setRequestedOrientation(getForceOrientation());
      AppMethodBeat.o(8759);
      return;
    }
    super.setMMOrientation();
    AppMethodBeat.o(8759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI
 * JD-Core Version:    0.7.0.1
 */