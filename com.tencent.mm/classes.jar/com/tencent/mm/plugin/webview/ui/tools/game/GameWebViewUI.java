package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.content.b;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.mm.R.e;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.d.dc;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.x;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GameWebViewUI
  extends GameBaseWebViewUI
{
  private static String rwo = "wx_fullscreen";
  private long kMC;
  private GameWebPerformanceInfo kMv;
  private boolean kOO = false;
  private boolean rwA = false;
  private com.tencent.mm.plugin.wepkg.c rwa;
  private boolean rwn = false;
  private HashMap<String, String> rwp = new HashMap();
  private Drawable rwq;
  private Drawable rwr;
  private String rws = null;
  private Map<Integer, awk> rwt = new HashMap();
  private String rwu;
  private GameMenuImageButton rwv;
  private boolean rww;
  private boolean rwx = false;
  private boolean rwy;
  private boolean rwz = false;
  
  private l cfR()
  {
    try
    {
      List localList = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.rwG;
      new Bundle().putString("game_hv_menu_appid", this.rwu);
      this.rwt.clear();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        awk localawk = (awk)localIterator.next();
        this.rwt.put(Integer.valueOf(localawk.tsZ), localawk);
      }
      locall = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.c(this, localException);
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.Wepkg.GameWebViewUI", "get cache hv game menu fail! exception:%s", new Object[] { localException.getMessage() });
      return null;
    }
    l locall;
    return locall;
  }
  
  private void cfS()
  {
    if (this.rnt != null) {
      this.rnt.setVisibility(0);
    }
  }
  
  private void cfT()
  {
    this.rwz = false;
    this.rwA = false;
    ai.l(new GameWebViewUI.7(this), 100L);
  }
  
  protected final void T(Bundle paramBundle)
  {
    super.T(paramBundle);
  }
  
  protected final boolean Tl(String paramString)
  {
    return this.rwa.UQ(paramString);
  }
  
  public boolean aYK()
  {
    getIntent().putExtra("minimize_secene", 2);
    return true;
  }
  
  public final void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    if (this.rww) {
      super.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
    }
  }
  
  protected final void ahA()
  {
    if (Build.VERSION.SDK_INT > 10)
    {
      if (getForceOrientation() == -1)
      {
        this.uMo = getSharedPreferences(ae.cqR(), 4).getBoolean("settings_landscape_mode", false);
        if (this.uMo)
        {
          setRequestedOrientation(2);
          return;
        }
        setRequestedOrientation(1);
        return;
      }
      setRequestedOrientation(getForceOrientation());
      return;
    }
    super.ahA();
  }
  
  protected final void aoX()
  {
    super.aoX();
    this.rww = true;
    int i;
    if ((this.kOO) || (this.kXY != null) || (this.kXX != 0)) {
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i != 0)
      {
        localObject = com.tencent.mm.plugin.game.commlib.a.aYn();
        if ((localObject == null) || (bk.bl(((dc)localObject).color))) {}
      }
      try
      {
        this.kXX = Color.parseColor(((dc)localObject).color);
        this.kXY = ((dc)localObject).kQS;
        cdQ();
        lj(true);
        localObject = getIntent();
        if ((localObject != null) && (((Intent)localObject).getBooleanExtra("game_check_float", false)))
        {
          i = ((Intent)localObject).getIntExtra("game_sourceScene", 0);
          this.rws = ((Intent)localObject).getStringExtra("game_transparent_float_url");
          if (bk.bl(this.rws))
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("game_check_float", true);
            ((Intent)localObject).putExtra("game_sourceScene", i);
            com.tencent.mm.br.d.b(this, "game", ".ui.GameCenterUI", (Intent)localObject);
          }
        }
        else
        {
          return;
          i = 1;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          y.e("MicroMsg.Wepkg.GameWebViewUI", "parse color: " + localIllegalArgumentException.getMessage());
        }
        try
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("game_sourceScene", i);
          if (this.gGn != null) {
            this.gGn.f(91, (Bundle)localObject);
          }
          if (this.rvQ == null) {
            this.rvQ = new a(this, this.rny);
          }
          localObject = this.rvQ;
          String str = this.rws;
          ((a)localObject).kMs = str;
          ((a)localObject).rwa.bu(str, false);
          if ((((a)localObject).dYF != null) && (((a)localObject).dYF.getParent() == null))
          {
            ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
            ((a)localObject).MY.addView(((a)localObject).dYF, localLayoutParams);
          }
          if ((((a)localObject).dYF != null) && (((a)localObject).rwb != null)) {
            ((a)localObject).dYF.post(new a.3((a)localObject, str));
          }
          this.rws = null;
          return;
        }
        catch (RemoteException localRemoteException) {}
      }
    }
  }
  
  protected final void b(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (this.kMv.dCP == 0L) {
      this.kMv.dCP = System.currentTimeMillis();
    }
    if (this.rwa.cjI())
    {
      super.b(paramString, paramMap, false);
      return;
    }
    super.b(paramString, paramMap, paramBoolean);
  }
  
  protected final WebViewUI.x bo(String paramString, boolean paramBoolean)
  {
    if (this.kMv.dCS == 0L) {
      this.kMv.dCS = System.currentTimeMillis();
    }
    return super.bo(paramString, paramBoolean);
  }
  
  protected final void cS(String paramString, int paramInt)
  {
    super.cS(paramString, paramInt);
  }
  
  protected final int cdV()
  {
    return super.cdV();
  }
  
  protected final void cdW()
  {
    super.cdW();
    this.rwu = getIntent().getStringExtra("game_hv_menu_appid");
    if ((this.rnA) && (!bk.bl(this.rwu)))
    {
      if (this.rnz != null) {
        this.rnz.setVisibility(8);
      }
      this.rwv.a(this.rnx, new GameWebViewUI.6(this));
    }
  }
  
  protected final j cdY()
  {
    try
    {
      if (this.roe == null) {
        this.roe = new GameWebViewUI.b(this);
      }
      j localj = this.roe;
      return localj;
    }
    finally {}
  }
  
  protected final void cej()
  {
    if ((this.rwv == null) || (!this.rwv.rwH))
    {
      super.cej();
      return;
    }
    com.tencent.mm.plugin.webview.ui.tools.game.menu.d locald = new com.tencent.mm.plugin.webview.ui.tools.game.menu.d(this.mController.uMN);
    locald.a(new GameWebViewUI.2(this));
    locald.rwW = new GameWebViewUI.3(this);
    if (this.rnA) {
      locald.rxb = true;
    }
    for (locald.rxc = true; (this.rnD != null) && (this.rnD.isShown()); locald.rxc = false)
    {
      this.rnD.hide();
      ai.l(new GameWebViewUI.4(this, locald), 100L);
      return;
      locald.rxb = false;
    }
    XM();
    ai.l(new GameWebViewUI.5(this, locald), 100L);
  }
  
  protected final void cep()
  {
    if (this.kMv.dCT == 0L) {
      this.kMv.dCT = System.currentTimeMillis();
    }
    this.rwz = true;
    if (this.rwA) {
      cfT();
    }
  }
  
  public void initView()
  {
    this.kMv.dCM = System.currentTimeMillis();
    super.initView();
    this.rwq = new ColorDrawable(b.i(this, R.e.actionbar_bg_color));
    this.rwr = new ColorDrawable(b.i(this, R.e.actionbar_bg_color));
    this.kMv.dCN = System.currentTimeMillis();
  }
  
  protected final void lj(boolean paramBoolean)
  {
    super.lj(paramBoolean);
    lm(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    String str = getIntent().getStringExtra("rawUrl");
    y.i("MicroMsg.Wepkg.GameWebViewUI", "GameWebViewUI oncreate");
    y.i("MicroMsg.Wepkg.GameWebViewUI", "rawUrl rid:%s, pkgId:%s", new Object[] { com.tencent.mm.plugin.wepkg.utils.d.Vs(str), com.tencent.mm.plugin.wepkg.utils.d.Vq(str) });
    this.kMv = GameWebPerformanceInfo.fv(str);
    this.kMv.url = str;
    this.kMv.startTime = getIntent().getLongExtra("start_time", System.currentTimeMillis());
    this.kMv.dCE = getIntent().getLongExtra("gamecenterui_createtime", 0L);
    this.kMv.dCF = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
    this.kMv.dCK = System.currentTimeMillis();
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if ((paramBundle != null) && (paramBundle.getBooleanExtra("disable_progress_bar", false)))
    {
      this.rns.uUI = false;
      cfS();
    }
    this.niQ.setWebViewClient(new GameWebViewUI.c(this, (byte)0));
    if (this.niQ.getIsX5Kernel()) {
      this.niQ.setWebViewClientExtension(new GameWebViewUI.a(this, (byte)0));
    }
    this.rwa = new GameWebViewUI.1(this);
    this.rwy = "game_center_h5_floatlayer".equals(bk.pm(getIntent().getStringExtra("KPublisherId")));
    paramBundle = this.rwa;
    if (!this.rwy) {
      bool = true;
    }
    if (paramBundle.bu(str, bool))
    {
      y.i("MicroMsg.Wepkg.GameWebViewUI", "current page use wepkg");
      this.rwx = true;
      cfS();
    }
    this.rwv = new GameMenuImageButton(this.mController.uMN);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.rwa.lL(this.rwy);
    this.kMv.dCV = System.currentTimeMillis();
    com.tencent.mm.game.report.api.c.dCx.a(GameWebPerformanceInfo.fw(caV()));
  }
  
  public void onPause()
  {
    super.onPause();
    GameWebPerformanceInfo localGameWebPerformanceInfo = this.kMv;
    localGameWebPerformanceInfo.dCU += System.currentTimeMillis() - this.kMC;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.kMv.dCL == 0L) {
      this.kMv.dCL = System.currentTimeMillis();
    }
    this.kMC = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI
 * JD-Core Version:    0.7.0.1
 */