package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.bs.d;
import com.tencent.mm.co.f;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.xd;
import com.tencent.mm.g.a.xd.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ae;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletBalanceManagerUI
  extends WalletBaseUI
  implements l, n.b
{
  protected int mScene;
  private ProgressBar tvr;
  private c<kb> ujv;
  protected Button zGW;
  protected View zGX;
  protected TextView zGY;
  private ViewGroup zGZ;
  protected TextView zGm;
  private TextView zHa;
  private ImageView zHb;
  private WcPayMoneyLoadingView zHc;
  protected Bankcard zHd;
  private bd zHe;
  private com.tencent.mm.plugin.wallet_core.model.h zHf;
  private com.tencent.mm.plugin.wallet.balance.model.a zHg;
  private ViewGroup zHh;
  private CdnImageView zHi;
  private TextView zHj;
  private CdnImageView zHk;
  private View zHl;
  private TextView zHm;
  
  public WalletBalanceManagerUI()
  {
    AppMethodBeat.i(68663);
    this.ujv = new c() {};
    AppMethodBeat.o(68663);
  }
  
  private void a(final v paramv)
  {
    AppMethodBeat.i(68665);
    if (paramv == null)
    {
      this.zHh.setVisibility(8);
      AppMethodBeat.o(68665);
      return;
    }
    if (!bt.isNullOrNil(paramv.Ahz))
    {
      this.zHi.setUrl(paramv.Ahz);
      this.zHi.setVisibility(0);
      if (bt.isNullOrNil(paramv.AhA)) {
        break label239;
      }
      this.zHk.setUrl(paramv.AhA);
      this.zHk.setVisibility(0);
    }
    for (;;)
    {
      this.zHj.setText(paramv.doh);
      if (!bt.isNullOrNil(paramv.Ahw)) {
        this.zHj.setTextColor(bt.fH(paramv.Ahw, -16777216));
      }
      this.zHj.setTextSize(1, paramv.Ahx);
      if (!bt.isNullOrNil(paramv.wUC))
      {
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(0);
        localGradientDrawable.setColor(bt.fH(paramv.wUC, -1));
        localGradientDrawable.setCornerRadius(com.tencent.mm.cd.a.fromDPToPix(getContext(), 4));
        this.zHh.setBackground(localGradientDrawable);
      }
      this.zHh.setVisibility(0);
      this.zHh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68655);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "click freeze layout");
          com.tencent.mm.wallet_core.ui.e.o(WalletBalanceManagerUI.this.getContext(), paramv.Ahy, true);
          v.atO("");
          WalletBalanceManagerUI.b(WalletBalanceManagerUI.this).setVisibility(8);
          AppMethodBeat.o(68655);
        }
      });
      this.zGZ.setVisibility(8);
      AppMethodBeat.o(68665);
      return;
      this.zHi.setVisibility(8);
      break;
      label239:
      this.zHk.setVisibility(8);
    }
  }
  
  private static boolean azo()
  {
    AppMethodBeat.i(163863);
    if (!ac.eFu().equals("zh_CN"))
    {
      AppMethodBeat.o(163863);
      return true;
    }
    boolean bool = bt.iP(aj.getContext());
    AppMethodBeat.o(163863);
    return bool;
  }
  
  private boolean dZg()
  {
    AppMethodBeat.i(68675);
    com.tencent.mm.plugin.wallet.a.s.dZT();
    if ((com.tencent.mm.plugin.wallet.a.s.dZU().ecN().dZg()) && (this.zHd.AbU > 0.0D))
    {
      AppMethodBeat.o(68675);
      return true;
    }
    AppMethodBeat.o(68675);
    return false;
  }
  
  private void sj(boolean paramBoolean)
  {
    AppMethodBeat.i(68672);
    long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ae.a.Fsw, Long.valueOf(0L))).longValue();
    WcPayMoneyLoadingView localWcPayMoneyLoadingView = this.zHc;
    String str = com.tencent.mm.wallet_core.ui.e.D(com.tencent.mm.wallet_core.ui.e.a(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue());
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localWcPayMoneyLoadingView.bV(str, paramBoolean);
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
        sj(false);
      }
    }
    AppMethodBeat.o(68679);
  }
  
  protected void dZd()
  {
    AppMethodBeat.i(68666);
    com.tencent.mm.plugin.wallet.a.s.dZT();
    if (com.tencent.mm.plugin.wallet.a.s.dZU().zHd == null) {}
    for (boolean bool = true;; bool = false)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 10), bool);
      AppMethodBeat.o(68666);
      return;
    }
  }
  
  protected void dZe()
  {
    AppMethodBeat.i(68668);
    startActivity(WalletBalanceSaveUI.class);
    AppMethodBeat.o(68668);
  }
  
  protected final void dZf()
  {
    AppMethodBeat.i(163864);
    removeAllOptionMenu();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
    Object localObject1;
    if (this.zHd != null)
    {
      com.tencent.mm.plugin.wallet.a.s.dZT();
      com.tencent.mm.plugin.wallet.a.s.dZU();
      if (!bt.isNullOrNil(this.zHd.AbX))
      {
        localObject1 = getString(2131765005);
        if (!bt.isNullOrNil(this.zHd.AbZ))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "entry_word：%s", new Object[] { this.zHd.AbZ });
          localObject1 = this.zHd.AbZ;
        }
        addTextOptionMenu(0, (String)localObject1, new WalletBalanceManagerUI.3(this), r.b.FOK);
      }
    }
    if ((this.zHm == null) || (this.zHl == null) || (isFinishing()) || (isDestroyed()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "accountUpdateServiceTv == null || marginLine == null || WalletBalanceManagerUI.this.isFinishing()|| WalletBalanceManagerUI.this.isDestroyed()：%s，%s", new Object[] { Boolean.valueOf(isFinishing()), Boolean.valueOf(isDestroyed()) });
      AppMethodBeat.o(163864);
      return;
    }
    final a locala = new a((byte)0);
    b localb = new b((byte)0);
    for (;;)
    {
      try
      {
        localObject1 = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ae.a.FrO, null);
        if (bt.isNullOrNil((String)localObject1)) {
          break label641;
        }
        Object localObject2 = new JSONObject((String)localObject1);
        boolean bool1 = ((JSONObject)localObject2).optBoolean("is_exposure", false);
        this.zHm.setVisibility(8);
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
            locala.uaQ = ((JSONObject)localObject1).optInt("type", 0);
            locala.ntj = ((JSONObject)localObject1).optString("url");
            locala.zHs = ((JSONObject)localObject1).optString("mini_username");
            locala.zHt = ((JSONObject)localObject1).optString("mini_pagepath");
          }
          bool2 = bool1;
          if (!bt.isNullOrNil((String)localObject2))
          {
            localObject1 = new JSONObject((String)localObject2);
            localb.doh = ((JSONObject)localObject1).optString("wording");
            localb.color = ((JSONObject)localObject1).optInt("color", -1);
            localb.zHu = ((JSONObject)localObject1).optInt("dark_color", -1);
            bool2 = bool1;
          }
          if (!bool2) {
            break label612;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "show Lqt ServceEntrance");
          com.tencent.mm.wallet_core.ui.e.aby(45);
          if (localb.doh != null) {
            this.zHm.setText(localb.doh);
          }
          if (ai.Eq()) {
            continue;
          }
          if (localb.color != -1) {
            continue;
          }
          this.zHm.setTextColor(getResources().getColor(2131100547));
          this.zHm.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(163862);
              switch (locala.uaQ)
              {
              default: 
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "unknown entrance type");
              }
              for (;;)
              {
                com.tencent.mm.wallet_core.ui.e.aby(46);
                AppMethodBeat.o(163862);
                return;
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("rawUrl", locala.ntj);
                paramAnonymousView.putExtra("showShare", false);
                paramAnonymousView.putExtra("geta8key_username", u.aqG());
                paramAnonymousView.putExtra(e.m.FIC, true);
                com.tencent.mm.wallet_core.ui.e.X(WalletBalanceManagerUI.this.getContext(), paramAnonymousView);
                continue;
                paramAnonymousView = new uj();
                paramAnonymousView.dzH.userName = locala.zHs;
                paramAnonymousView.dzH.dzJ = locala.zHt;
                paramAnonymousView.dzH.scene = 1034;
                paramAnonymousView.dzH.dzK = 0;
                com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
                continue;
                if (locala.ntj.equals("wxpay://lqp/balanceQuotaState"))
                {
                  paramAnonymousView = new Intent();
                  d.b(WalletBalanceManagerUI.this.getContext(), "wallet_ecard", ".ui.WalletECardLogoutUI", paramAnonymousView);
                }
              }
            }
          });
          this.zHm.setVisibility(0);
          if (azo()) {
            continue;
          }
          this.zHl.setVisibility(0);
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
        this.zHm.setTextColor(localb.color);
        continue;
        if (localb.zHu == -1)
        {
          this.zHm.setTextColor(getResources().getColor(2131100547));
          continue;
        }
        this.zHm.setTextColor(localb.zHu);
        continue;
        this.zHl.setVisibility(8);
        AppMethodBeat.o(163864);
        return;
      }
      label612:
      this.zHl.setVisibility(8);
      AppMethodBeat.o(163864);
      return;
      label641:
      boolean bool2 = false;
    }
  }
  
  protected final void gP(boolean paramBoolean)
  {
    AppMethodBeat.i(68673);
    sj(paramBoolean);
    com.tencent.mm.plugin.wallet.a.s.dZT();
    this.zHd = com.tencent.mm.plugin.wallet.a.s.dZU().zHd;
    if (this.zHd != null)
    {
      if (dZg()) {
        this.zGW.setVisibility(0);
      }
    }
    else
    {
      localObject = findViewById(2131301692);
      com.tencent.mm.kernel.g.afC();
      if (((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FpV, Integer.valueOf(-1))).intValue() != 1) {
        break label197;
      }
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (!new ak().ecB()) {
        break label206;
      }
      com.tencent.mm.kernel.g.afC();
      localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkS, getString(2131762205));
      this.zGX.setVisibility(0);
      this.zGY.setTextColor(getResources().getColor(2131101100));
      this.zGY.setText((CharSequence)localObject);
      this.zGX.setOnClickListener(new WalletBalanceManagerUI.15(this));
      AppMethodBeat.o(68673);
      return;
      this.zGW.setVisibility(8);
      break;
      label197:
      ((View)localObject).setVisibility(8);
    }
    label206:
    com.tencent.mm.plugin.wallet.a.s.dZT();
    if (com.tencent.mm.plugin.wallet.a.s.dZU().edm() == 1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      com.tencent.mm.plugin.wallet.a.s.dZT();
      localObject = com.tencent.mm.plugin.wallet.a.s.dZU().edn();
      com.tencent.mm.plugin.wallet.a.s.dZT();
      String str = com.tencent.mm.plugin.wallet.a.s.dZU().edo();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "isShowLqtCell:%s lqtCellTitle:%s lqtCellWording:%s", new Object[] { Boolean.valueOf(paramBoolean), localObject, str });
      if ((!paramBoolean) || ((bt.isNullOrNil((String)localObject)) && (bt.isNullOrNil(str)))) {
        break;
      }
      this.zGX.setVisibility(8);
      AppMethodBeat.o(68673);
      return;
    }
    com.tencent.mm.plugin.wallet.a.s.dZT();
    if (com.tencent.mm.plugin.wallet.a.s.dZU().ecU())
    {
      com.tencent.mm.plugin.wallet.a.s.dZT();
      if (!bt.isNullOrNil(com.tencent.mm.plugin.wallet.a.s.dZU().ecQ()))
      {
        this.zGX.setVisibility(0);
        this.zGX.setOnClickListener(new WalletBalanceManagerUI.16(this));
        localObject = this.zGY;
        com.tencent.mm.plugin.wallet.a.s.dZT();
        ((TextView)localObject).setText(com.tencent.mm.plugin.wallet.a.s.dZU().ecQ());
        AppMethodBeat.o(68673);
        return;
      }
    }
    com.tencent.mm.plugin.wallet.a.s.dZT();
    Object localObject = com.tencent.mm.plugin.wallet.a.s.dZU();
    if ((localObject != null) && (((am)localObject).ecN().ecv()) && (!TextUtils.isEmpty(((am)localObject).ecQ())) && (!TextUtils.isEmpty(((am)localObject).ecR())))
    {
      this.zGX.setVisibility(0);
      this.zGY.setText(((am)localObject).ecQ());
      this.zGX.setOnClickListener(new WalletBalanceManagerUI.2(this, (am)localObject));
      AppMethodBeat.o(68673);
      return;
    }
    this.zGX.setVisibility(8);
    AppMethodBeat.o(68673);
  }
  
  public int getLayoutId()
  {
    return 2131495901;
  }
  
  public final void i(int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(68677);
    if ((paramInt != 12) && (paramInt == 43) && (paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      a((v)paramArrayOfObject[0]);
    }
    AppMethodBeat.o(68677);
  }
  
  public void initView()
  {
    AppMethodBeat.i(68669);
    setMMTitle("");
    this.zHc = ((WcPayMoneyLoadingView)findViewById(2131306666));
    this.tvr = ((ProgressBar)findViewById(2131306757));
    this.zGm = ((TextView)findViewById(2131306652));
    this.zHc.setLoadingPb(this.tvr);
    this.zHc.setPrefixSymbol(getString(2131765813));
    getLifecycle().addObserver(this.zHc);
    ((Button)findViewById(2131302852)).setOnClickListener(new WalletBalanceManagerUI.11(this));
    this.zGW = ((Button)findViewById(2131306653));
    this.zGW.setOnClickListener(new WalletBalanceManagerUI.12(this));
    this.zHl = findViewById(2131306654);
    this.zHm = ((TextView)findViewById(2131306651));
    Object localObject = (TextView)findViewById(2131306655);
    if (!azo())
    {
      ((TextView)localObject).setOnClickListener(new WalletBalanceManagerUI.13(this));
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      ((TextView)findViewById(2131306833)).setText(ah.fkf());
      this.zGZ = ((ViewGroup)findViewById(2131297087));
      this.zHa = ((TextView)findViewById(2131297088));
      this.zHb = ((ImageView)findViewById(2131297086));
      this.zGX = findViewById(2131301403);
      this.zGY = ((TextView)findViewById(2131301404));
      this.zHh = ((ViewGroup)findViewById(2131297099));
      this.zHj = ((TextView)findViewById(2131297097));
      this.zHi = ((CdnImageView)findViewById(2131297098));
      this.zHk = ((CdnImageView)findViewById(2131297096));
      localObject = new xd();
      ((xd)localObject).dCC.scene = "2";
      ((xd)localObject).callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68660);
          if (!bt.isNullOrNil(this.nYZ.dCD.dCE)) {
            com.tencent.mm.wallet_core.ui.e.a(WalletBalanceManagerUI.this.zGm, this.nYZ.dCD.dCE, this.nYZ.dCD.content, this.nYZ.dCD.url);
          }
          AppMethodBeat.o(68660);
        }
      };
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
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
    setBackBtn(new WalletBalanceManagerUI.1(this), 2131689490);
    this.mScene = getIntent().getIntExtra("key_scene_balance_manager", 0);
    paramBundle = ECardInfo.ebJ();
    if (paramBundle != null)
    {
      if (paramBundle.Cta != 1) {
        break label239;
      }
      paramBundle = new Bundle();
      isTransparent();
      com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramBundle, null, 0);
    }
    for (;;)
    {
      addSceneEndListener(621);
      com.tencent.mm.plugin.wallet_core.model.s.ecj();
      ag.a(this);
      initView();
      com.tencent.mm.wallet_core.c.ab.jZ(2, 0);
      com.tencent.mm.plugin.report.service.h.vKh.f(11850, new Object[] { Integer.valueOf(6), Integer.valueOf(0) });
      com.tencent.mm.wallet_core.ui.e.aby(10);
      a(v.aO(bw.K((String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ae.a.Fsu, ""), "sysmsg")));
      AppMethodBeat.o(68664);
      return;
      label239:
      if (paramBundle.Cta == 3)
      {
        paramBundle = ECardInfo.ebK();
        if (paramBundle != null) {
          com.tencent.mm.plugin.wallet_core.ui.o.a(this, paramBundle, 1);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68667);
    removeSceneEndListener(621);
    com.tencent.mm.plugin.wallet_core.model.s.ecj();
    ag.b(this);
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().b(this);
    if (this.zHg != null) {
      this.zHg.cancel();
    }
    this.zHg = null;
    super.onDestroy();
    AppMethodBeat.o(68667);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(68678);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + paramIntent.getIntExtra("from_bind_ui", 0));
    if (paramIntent.getIntExtra("from_bind_ui", 0) == com.tencent.mm.plugin.wallet.balance.a.zDY)
    {
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
      com.tencent.mm.wallet_core.ui.e.aby(15);
    }
    AppMethodBeat.o(68678);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68671);
    super.onPause();
    this.zHc.reset();
    AppMethodBeat.o(68671);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68670);
    gP(true);
    dZd();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "do query balance menu");
    if (this.zHg != null) {
      this.zHg.cancel();
    }
    this.zHg = new com.tencent.mm.plugin.wallet.balance.model.a();
    this.zHg.auK().b(new com.tencent.mm.vending.c.a() {});
    super.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.efN(), null);
    AppMethodBeat.o(68670);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(68676);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (!(paramn instanceof com.tencent.mm.plugin.wallet.bind.a.b)) && ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad)))
    {
      this.zHf = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).zWI;
      if ((this.zHf == null) || (this.zHh.isShown())) {
        break label199;
      }
      if (bt.isNullOrNil(this.zHf.doh)) {
        break label187;
      }
      this.zHa.setText(this.zHf.doh);
      if (!bt.isNullOrNil(this.zHf.gHT))
      {
        this.zHa.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.bW(this.zHf.gHT, true));
        paramString = this.zHb.getDrawable();
        if (paramString != null) {
          paramString.setColorFilter(com.tencent.mm.plugin.wallet_core.utils.g.bW(this.zHf.gHT, false), PorterDuff.Mode.SRC_ATOP);
        }
      }
      this.zGZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(163858);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceManagerUI", "click action entry");
          if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type == 1)
          {
            if (bt.isNullOrNil(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Adf))
            {
              AppMethodBeat.o(163858);
              return;
            }
            if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Adf.startsWith("weixin://wcpay/lqt/detail"))
            {
              ae.parseUrl(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Adf);
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_account_type", 1);
              d.b(WalletBalanceManagerUI.this.getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramAnonymousView);
              AppMethodBeat.o(163858);
              return;
            }
            if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Adf.startsWith("weixin://wcpay/lqt/save"))
            {
              ae.parseUrl(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Adf);
              paramAnonymousView = ae.atr(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Adf);
              final Dialog localDialog = com.tencent.mm.wallet_core.ui.g.c(WalletBalanceManagerUI.this.getContext(), false, null);
              new com.tencent.mm.plugin.wallet.balance.model.lqt.o().auK().b(new com.tencent.mm.vending.c.a() {});
              AppMethodBeat.o(163858);
            }
          }
          else
          {
            if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type == 2)
            {
              com.tencent.mm.wallet_core.ui.e.o(WalletBalanceManagerUI.this.getContext(), WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).odT, true);
              AppMethodBeat.o(163858);
              return;
            }
            if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type == 3)
            {
              com.tencent.mm.wallet_core.ui.e.v(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Adg, WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Adh, 0, 1061);
              AppMethodBeat.o(163858);
              return;
            }
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletBalanceManagerUI", "unknown type: %s", new Object[] { Integer.valueOf(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type) });
          }
          AppMethodBeat.o(163858);
        }
      });
      this.zGZ.setVisibility(0);
    }
    for (;;)
    {
      gP(false);
      dZf();
      AppMethodBeat.o(68676);
      return false;
      label187:
      this.zGZ.setVisibility(8);
      continue;
      label199:
      this.zGZ.setVisibility(8);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    public String ntj;
    public int uaQ;
    public String zHs;
    public String zHt;
  }
  
  static final class b
  {
    public int color;
    public String doh;
    public int zHu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI
 * JD-Core Version:    0.7.0.1
 */