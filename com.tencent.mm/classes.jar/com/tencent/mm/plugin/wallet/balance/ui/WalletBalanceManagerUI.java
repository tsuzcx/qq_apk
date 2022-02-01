package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.g.a.yi.b;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.awu;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletBalanceManagerUI
  extends WalletBaseUI
  implements l, n.b
{
  protected TextView CyI;
  private WcPayMoneyLoadingView CzA;
  protected Bankcard CzB;
  private bf CzC;
  private h CzD;
  private com.tencent.mm.plugin.wallet.balance.model.a CzE;
  private ViewGroup CzF;
  private CdnImageView CzG;
  private TextView CzH;
  private CdnImageView CzI;
  private View CzJ;
  private TextView CzK;
  protected Button Czu;
  protected View Czv;
  protected TextView Czw;
  private ViewGroup Czx;
  private TextView Czy;
  private ImageView Czz;
  protected int mScene;
  private ProgressBar vGK;
  private c<ks> wxJ;
  
  public WalletBalanceManagerUI()
  {
    AppMethodBeat.i(68663);
    this.wxJ = new WalletBalanceManagerUI.7(this);
    AppMethodBeat.o(68663);
  }
  
  private void a(final w paramw)
  {
    AppMethodBeat.i(68665);
    if (paramw == null)
    {
      this.CzF.setVisibility(8);
      AppMethodBeat.o(68665);
      return;
    }
    label82:
    GradientDrawable localGradientDrawable;
    if (!bt.isNullOrNil(paramw.Dam))
    {
      this.CzG.setUrl(paramw.Dam);
      this.CzG.setVisibility(0);
      if (bt.isNullOrNil(paramw.Dan)) {
        break label257;
      }
      this.CzI.setUrl(paramw.Dan);
      this.CzI.setVisibility(0);
      this.CzH.setText(paramw.dxD);
      if (!bt.isNullOrNil(paramw.Daj))
      {
        if (!com.tencent.mm.ui.al.isDarkMode()) {
          break label269;
        }
        this.CzH.setTextColor(com.tencent.mm.ui.al.gD(bt.gj(paramw.Daj, -16777216)));
      }
      label128:
      this.CzH.setTextSize(1, paramw.Dak);
      if (!bt.isNullOrNil(paramw.zxx))
      {
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(0);
        if (!com.tencent.mm.ui.al.isDarkMode()) {
          break label288;
        }
        localGradientDrawable.setColor(com.tencent.mm.ui.al.gD(bt.gj(paramw.zxx, -1)));
      }
    }
    for (;;)
    {
      localGradientDrawable.setCornerRadius(com.tencent.mm.cc.a.fromDPToPix(getContext(), 4));
      this.CzF.setBackground(localGradientDrawable);
      this.CzF.setVisibility(0);
      this.CzF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68655);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "click freeze layout");
          com.tencent.mm.wallet_core.ui.e.n(WalletBalanceManagerUI.this.getContext(), paramw.Dal, true);
          w.aEo("");
          WalletBalanceManagerUI.b(WalletBalanceManagerUI.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68655);
        }
      });
      this.Czx.setVisibility(8);
      AppMethodBeat.o(68665);
      return;
      this.CzG.setVisibility(8);
      break;
      label257:
      this.CzI.setVisibility(8);
      break label82;
      label269:
      this.CzH.setTextColor(bt.gj(paramw.Daj, -16777216));
      break label128;
      label288:
      localGradientDrawable.setColor(bt.gj(paramw.zxx, -1));
    }
  }
  
  private static boolean aJo()
  {
    AppMethodBeat.i(163863);
    if (!ac.fks().equals("zh_CN"))
    {
      AppMethodBeat.o(163863);
      return true;
    }
    boolean bool = bt.jk(aj.getContext());
    AppMethodBeat.o(163863);
    return bool;
  }
  
  private boolean eCB()
  {
    AppMethodBeat.i(68675);
    s.eDp();
    if ((s.eDq().eGi().eCB()) && (this.CzB.CUD > 0.0D))
    {
      AppMethodBeat.o(68675);
      return true;
    }
    AppMethodBeat.o(68675);
    return false;
  }
  
  private void tU(boolean paramBoolean)
  {
    AppMethodBeat.i(68672);
    long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(al.a.ICH, Long.valueOf(0L))).longValue();
    WcPayMoneyLoadingView localWcPayMoneyLoadingView = this.CzA;
    String str = com.tencent.mm.wallet_core.ui.e.C(com.tencent.mm.wallet_core.ui.e.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue());
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localWcPayMoneyLoadingView.ck(str, paramBoolean);
      AppMethodBeat.o(68672);
      return;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(68679);
    if ((paramn == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        tU(false);
      }
    }
    AppMethodBeat.o(68679);
  }
  
  protected final void eCA()
  {
    AppMethodBeat.i(163864);
    removeAllOptionMenu();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
    Object localObject1;
    if (this.CzB != null)
    {
      s.eDp();
      s.eDq();
      if (!bt.isNullOrNil(this.CzB.CUG))
      {
        localObject1 = getString(2131765005);
        if (!bt.isNullOrNil(this.CzB.CUI))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "entry_word：%s", new Object[] { this.CzB.CUI });
          localObject1 = this.CzB.CUI;
        }
        addTextOptionMenu(0, (String)localObject1, new WalletBalanceManagerUI.3(this), s.b.Jcb);
      }
    }
    if ((this.CzK == null) || (this.CzJ == null) || (isFinishing()) || (isDestroyed()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "accountUpdateServiceTv == null || marginLine == null || WalletBalanceManagerUI.this.isFinishing()|| WalletBalanceManagerUI.this.isDestroyed()：%s，%s", new Object[] { Boolean.valueOf(isFinishing()), Boolean.valueOf(isDestroyed()) });
      AppMethodBeat.o(163864);
      return;
    }
    WalletBalanceManagerUI.a locala = new WalletBalanceManagerUI.a((byte)0);
    b localb = new b((byte)0);
    for (;;)
    {
      try
      {
        localObject1 = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(al.a.IBZ, null);
        if (bt.isNullOrNil((String)localObject1)) {
          break label641;
        }
        Object localObject2 = new JSONObject((String)localObject1);
        boolean bool1 = ((JSONObject)localObject2).optBoolean("is_exposure", false);
        this.CzK.setVisibility(8);
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          localObject1 = ((JSONObject)localObject2).optString("jump_info");
          localObject2 = ((JSONObject)localObject2).optString("wording_item");
          if (!bt.isNullOrNil((String)localObject1))
          {
            localObject1 = new JSONObject((String)localObject1);
            locala.uxt = ((JSONObject)localObject1).optInt("type", 0);
            locala.ozD = ((JSONObject)localObject1).optString("url");
            locala.CzQ = ((JSONObject)localObject1).optString("mini_username");
            locala.CzR = ((JSONObject)localObject1).optString("mini_pagepath");
          }
          bool2 = bool1;
          if (!bt.isNullOrNil((String)localObject2))
          {
            localObject1 = new JSONObject((String)localObject2);
            localb.dxD = ((JSONObject)localObject1).optString("wording");
            localb.color = ((JSONObject)localObject1).optInt("color", -1);
            localb.CzS = ((JSONObject)localObject1).optInt("dark_color", -1);
            bool2 = bool1;
          }
          if (!bool2) {
            break label612;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "show Lqt ServceEntrance");
          com.tencent.mm.wallet_core.ui.e.agr(45);
          if (localb.dxD != null) {
            this.CzK.setText(localb.dxD);
          }
          if (com.tencent.mm.ui.al.isDarkMode()) {
            continue;
          }
          if (localb.color != -1) {
            continue;
          }
          this.CzK.setTextColor(getResources().getColor(2131100547));
          this.CzK.setOnClickListener(new WalletBalanceManagerUI.8(this, locala));
          this.CzK.setVisibility(0);
          if (aJo()) {
            continue;
          }
          this.CzJ.setVisibility(0);
          AppMethodBeat.o(163864);
          return;
        }
        catch (JSONException localJSONException2)
        {
          continue;
        }
        localJSONException1 = localJSONException1;
        bool1 = false;
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WalletBalanceManagerUI", localJSONException1, "", new Object[0]);
        bool2 = bool1;
        continue;
        this.CzK.setTextColor(localb.color);
        continue;
        if (localb.CzS == -1)
        {
          this.CzK.setTextColor(getResources().getColor(2131100547));
          continue;
        }
        this.CzK.setTextColor(localb.CzS);
        continue;
        this.CzJ.setVisibility(8);
        AppMethodBeat.o(163864);
        return;
      }
      label612:
      this.CzJ.setVisibility(8);
      AppMethodBeat.o(163864);
      return;
      label641:
      boolean bool2 = false;
    }
  }
  
  protected void eCy()
  {
    AppMethodBeat.i(68666);
    s.eDp();
    if (s.eDq().CzB == null) {}
    for (boolean bool = true;; bool = false)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 10), bool);
      AppMethodBeat.o(68666);
      return;
    }
  }
  
  protected void eCz()
  {
    AppMethodBeat.i(68668);
    startActivity(WalletBalanceSaveUI.class);
    AppMethodBeat.o(68668);
  }
  
  public int getLayoutId()
  {
    return 2131495901;
  }
  
  protected final void hq(boolean paramBoolean)
  {
    AppMethodBeat.i(68673);
    tU(paramBoolean);
    s.eDp();
    this.CzB = s.eDq().CzB;
    if (this.CzB != null)
    {
      if (eCB()) {
        this.Czu.setVisibility(0);
      }
    }
    else
    {
      localObject = findViewById(2131301692);
      com.tencent.mm.kernel.g.ajD();
      if (((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAc, Integer.valueOf(-1))).intValue() != 1) {
        break label197;
      }
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (!new com.tencent.mm.plugin.wallet_core.model.al().eFW()) {
        break label206;
      }
      com.tencent.mm.kernel.g.ajD();
      localObject = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IuZ, getString(2131762205));
      this.Czv.setVisibility(0);
      this.Czw.setTextColor(getResources().getColor(2131101100));
      this.Czw.setText((CharSequence)localObject);
      this.Czv.setOnClickListener(new WalletBalanceManagerUI.15(this));
      AppMethodBeat.o(68673);
      return;
      this.Czu.setVisibility(8);
      break;
      label197:
      ((View)localObject).setVisibility(8);
    }
    label206:
    s.eDp();
    if (s.eDq().eGH() == 1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      s.eDp();
      localObject = s.eDq().eGI();
      s.eDp();
      String str = s.eDq().eGJ();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "isShowLqtCell:%s lqtCellTitle:%s lqtCellWording:%s", new Object[] { Boolean.valueOf(paramBoolean), localObject, str });
      if ((!paramBoolean) || ((bt.isNullOrNil((String)localObject)) && (bt.isNullOrNil(str)))) {
        break;
      }
      this.Czv.setVisibility(8);
      AppMethodBeat.o(68673);
      return;
    }
    s.eDp();
    if (s.eDq().eGp())
    {
      s.eDp();
      if (!bt.isNullOrNil(s.eDq().eGl()))
      {
        this.Czv.setVisibility(0);
        this.Czv.setOnClickListener(new WalletBalanceManagerUI.16(this));
        localObject = this.Czw;
        s.eDp();
        ((TextView)localObject).setText(s.eDq().eGl());
        AppMethodBeat.o(68673);
        return;
      }
    }
    s.eDp();
    Object localObject = s.eDq();
    if ((localObject != null) && (((an)localObject).eGi().eFR()) && (!TextUtils.isEmpty(((an)localObject).eGl())) && (!TextUtils.isEmpty(((an)localObject).eGm())))
    {
      this.Czv.setVisibility(0);
      this.Czw.setText(((an)localObject).eGl());
      this.Czv.setOnClickListener(new WalletBalanceManagerUI.2(this, (an)localObject));
      AppMethodBeat.o(68673);
      return;
    }
    this.Czv.setVisibility(8);
    AppMethodBeat.o(68673);
  }
  
  public final void i(int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(68677);
    if ((paramInt != 12) && (paramInt == 43) && (paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      a((w)paramArrayOfObject[0]);
    }
    AppMethodBeat.o(68677);
  }
  
  public void initView()
  {
    AppMethodBeat.i(68669);
    setMMTitle("");
    this.CzA = ((WcPayMoneyLoadingView)findViewById(2131306666));
    this.vGK = ((ProgressBar)findViewById(2131306757));
    this.CyI = ((TextView)findViewById(2131306652));
    this.CzA.setLoadingPb(this.vGK);
    this.CzA.setPrefixSymbol(getString(2131765813));
    getLifecycle().addObserver(this.CzA);
    ((Button)findViewById(2131302852)).setOnClickListener(new WalletBalanceManagerUI.11(this));
    this.Czu = ((Button)findViewById(2131306653));
    this.Czu.setOnClickListener(new WalletBalanceManagerUI.12(this));
    this.CzJ = findViewById(2131306654);
    this.CzK = ((TextView)findViewById(2131306651));
    Object localObject = (TextView)findViewById(2131306655);
    if (!aJo())
    {
      ((TextView)localObject).setOnClickListener(new WalletBalanceManagerUI.13(this));
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      ((TextView)findViewById(2131306833)).setText(com.tencent.mm.wallet_core.c.ah.fRF());
      this.Czx = ((ViewGroup)findViewById(2131297087));
      this.Czy = ((TextView)findViewById(2131297088));
      this.Czz = ((ImageView)findViewById(2131297086));
      this.Czv = findViewById(2131301403);
      this.Czw = ((TextView)findViewById(2131301404));
      this.CzF = ((ViewGroup)findViewById(2131297099));
      this.CzH = ((TextView)findViewById(2131297097));
      this.CzG = ((CdnImageView)findViewById(2131297098));
      this.CzI = ((CdnImageView)findViewById(2131297096));
      localObject = new yi();
      ((yi)localObject).dMB.scene = "2";
      ((yi)localObject).callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68660);
          if (!bt.isNullOrNil(this.pfP.dMC.dMD)) {
            com.tencent.mm.wallet_core.ui.e.a(WalletBalanceManagerUI.this.CyI, this.pfP.dMC.dMD, this.pfP.dMC.content, this.pfP.dMC.url);
          }
          AppMethodBeat.o(68660);
        }
      };
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(68669);
      return;
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68664);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().a(this);
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(68645);
        if (WalletBalanceManagerUI.a(WalletBalanceManagerUI.this))
        {
          WalletBalanceManagerUI.this.hideVKB();
          WalletBalanceManagerUI.this.showDialog(1000);
        }
        for (;;)
        {
          AppMethodBeat.o(68645);
          return true;
          WalletBalanceManagerUI.this.finish();
        }
      }
    }, 2131689490);
    this.mScene = getIntent().getIntExtra("key_scene_balance_manager", 0);
    paramBundle = ECardInfo.eFf();
    if (paramBundle != null)
    {
      if (paramBundle.Fqw != 1) {
        break label239;
      }
      paramBundle = new Bundle();
      isTransparent();
      com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramBundle, null, 0);
    }
    for (;;)
    {
      addSceneEndListener(621);
      t.eFF();
      com.tencent.mm.plugin.wallet_core.model.ah.a(this);
      initView();
      ab.kB(2, 0);
      com.tencent.mm.plugin.report.service.g.yhR.f(11850, new Object[] { Integer.valueOf(6), Integer.valueOf(0) });
      com.tencent.mm.wallet_core.ui.e.agr(10);
      a(w.aV(bw.M((String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(al.a.ICF, ""), "sysmsg")));
      AppMethodBeat.o(68664);
      return;
      label239:
      if (paramBundle.Fqw == 3)
      {
        paramBundle = ECardInfo.eFg();
        if (paramBundle != null) {
          o.a(this, paramBundle, 1);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68667);
    removeSceneEndListener(621);
    t.eFF();
    com.tencent.mm.plugin.wallet_core.model.ah.b(this);
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().b(this);
    if (this.CzE != null) {
      this.CzE.cancel();
    }
    this.CzE = null;
    super.onDestroy();
    AppMethodBeat.o(68667);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(68678);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + paramIntent.getIntExtra("from_bind_ui", 0));
    if (paramIntent.getIntExtra("from_bind_ui", 0) == com.tencent.mm.plugin.wallet.balance.a.Cwt)
    {
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
      com.tencent.mm.wallet_core.ui.e.agr(15);
    }
    AppMethodBeat.o(68678);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68671);
    super.onPause();
    this.CzA.reset();
    AppMethodBeat.o(68671);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68670);
    hq(true);
    eCy();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "do query balance menu");
    if (this.CzE != null) {
      this.CzE.cancel();
    }
    this.CzE = new com.tencent.mm.plugin.wallet.balance.model.a();
    this.CzE.aED().b(new com.tencent.mm.vending.c.a() {});
    super.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.eJn(), null);
    AppMethodBeat.o(68670);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(68676);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (!(paramn instanceof com.tencent.mm.plugin.wallet.bind.a.b)) && ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad)))
    {
      this.CzD = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).CPr;
      if ((this.CzD == null) || (this.CzF.isShown())) {
        break label199;
      }
      if (bt.isNullOrNil(this.CzD.dxD)) {
        break label187;
      }
      this.Czy.setText(this.CzD.dxD);
      if (!bt.isNullOrNil(this.CzD.hAD))
      {
        this.Czy.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cl(this.CzD.hAD, true));
        paramString = this.Czz.getDrawable();
        if (paramString != null) {
          paramString.setColorFilter(com.tencent.mm.plugin.wallet_core.utils.g.cl(this.CzD.hAD, false), PorterDuff.Mode.SRC_ATOP);
        }
      }
      this.Czx.setOnClickListener(new WalletBalanceManagerUI.4(this));
      this.Czx.setVisibility(0);
    }
    for (;;)
    {
      hq(false);
      eCA();
      AppMethodBeat.o(68676);
      return false;
      label187:
      this.Czx.setVisibility(8);
      continue;
      label199:
      this.Czx.setVisibility(8);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class b
  {
    public int CzS;
    public int color;
    public String dxD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI
 * JD-Core Version:    0.7.0.1
 */