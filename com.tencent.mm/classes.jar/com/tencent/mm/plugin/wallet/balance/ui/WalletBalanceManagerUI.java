package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.app.Dialog;
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
import com.tencent.mm.ak.a.a;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.g.a.yo.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletBalanceManagerUI
  extends WalletBaseUI
  implements l, n.b
{
  protected Button CQZ;
  protected TextView CQn;
  protected View CRa;
  protected TextView CRb;
  private ViewGroup CRc;
  private TextView CRd;
  private ImageView CRe;
  private WcPayMoneyLoadingView CRf;
  protected Bankcard CRg;
  private bf CRh;
  private com.tencent.mm.plugin.wallet_core.model.h CRi;
  private com.tencent.mm.plugin.wallet.balance.model.a CRj;
  private ViewGroup CRk;
  private CdnImageView CRl;
  private TextView CRm;
  private CdnImageView CRn;
  private View CRo;
  private TextView CRp;
  protected int mScene;
  private ProgressBar vSO;
  private c<kt> wNu;
  
  public WalletBalanceManagerUI()
  {
    AppMethodBeat.i(68663);
    this.wNu = new c() {};
    AppMethodBeat.o(68663);
  }
  
  private void a(final w paramw)
  {
    AppMethodBeat.i(68665);
    if (paramw == null)
    {
      this.CRk.setVisibility(8);
      AppMethodBeat.o(68665);
      return;
    }
    label82:
    GradientDrawable localGradientDrawable;
    if (!bu.isNullOrNil(paramw.DrR))
    {
      this.CRl.setUrl(paramw.DrR);
      this.CRl.setVisibility(0);
      if (bu.isNullOrNil(paramw.DrS)) {
        break label257;
      }
      this.CRn.setUrl(paramw.DrS);
      this.CRn.setVisibility(0);
      this.CRm.setText(paramw.dyI);
      if (!bu.isNullOrNil(paramw.DrO))
      {
        if (!com.tencent.mm.ui.al.isDarkMode()) {
          break label269;
        }
        this.CRm.setTextColor(com.tencent.mm.ui.al.gE(bu.gs(paramw.DrO, -16777216)));
      }
      label128:
      this.CRm.setTextSize(1, paramw.DrP);
      if (!bu.isNullOrNil(paramw.zOW))
      {
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(0);
        if (!com.tencent.mm.ui.al.isDarkMode()) {
          break label288;
        }
        localGradientDrawable.setColor(com.tencent.mm.ui.al.gE(bu.gs(paramw.zOW, -1)));
      }
    }
    for (;;)
    {
      localGradientDrawable.setCornerRadius(com.tencent.mm.cb.a.fromDPToPix(getContext(), 4));
      this.CRk.setBackground(localGradientDrawable);
      this.CRk.setVisibility(0);
      this.CRk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68655);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletBalanceManagerUI", "click freeze layout");
          com.tencent.mm.wallet_core.ui.f.o(WalletBalanceManagerUI.this.getContext(), paramw.DrQ, true);
          w.aFI("");
          WalletBalanceManagerUI.b(WalletBalanceManagerUI.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68655);
        }
      });
      this.CRc.setVisibility(8);
      AppMethodBeat.o(68665);
      return;
      this.CRl.setVisibility(8);
      break;
      label257:
      this.CRn.setVisibility(8);
      break label82;
      label269:
      this.CRm.setTextColor(bu.gs(paramw.DrO, -16777216));
      break label128;
      label288:
      localGradientDrawable.setColor(bu.gs(paramw.zOW, -1));
    }
  }
  
  private static boolean aJG()
  {
    AppMethodBeat.i(163863);
    if (!com.tencent.mm.sdk.platformtools.ad.fom().equals("zh_CN"))
    {
      AppMethodBeat.o(163863);
      return true;
    }
    boolean bool = bu.jq(ak.getContext());
    AppMethodBeat.o(163863);
    return bool;
  }
  
  private boolean eGi()
  {
    AppMethodBeat.i(68675);
    s.eGW();
    if ((s.eGX().eJP().eGi()) && (this.CRg.Dmj > 0.0D))
    {
      AppMethodBeat.o(68675);
      return true;
    }
    AppMethodBeat.o(68675);
    return false;
  }
  
  private void ub(boolean paramBoolean)
  {
    AppMethodBeat.i(68672);
    long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(am.a.IXh, Long.valueOf(0L))).longValue();
    WcPayMoneyLoadingView localWcPayMoneyLoadingView = this.CRf;
    String str = com.tencent.mm.wallet_core.ui.f.C(com.tencent.mm.wallet_core.ui.f.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue());
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localWcPayMoneyLoadingView.co(str, paramBoolean);
      AppMethodBeat.o(68672);
      return;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(68679);
    if ((paramn == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletBalanceManagerUI", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        ub(false);
      }
    }
    AppMethodBeat.o(68679);
  }
  
  protected void eGf()
  {
    AppMethodBeat.i(68666);
    s.eGW();
    if (s.eGX().CRg == null) {}
    for (boolean bool = true;; bool = false)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 10), bool);
      AppMethodBeat.o(68666);
      return;
    }
  }
  
  protected void eGg()
  {
    AppMethodBeat.i(68668);
    startActivity(WalletBalanceSaveUI.class);
    AppMethodBeat.o(68668);
  }
  
  protected final void eGh()
  {
    AppMethodBeat.i(163864);
    removeAllOptionMenu();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
    Object localObject1;
    if (this.CRg != null)
    {
      s.eGW();
      s.eGX();
      if (!bu.isNullOrNil(this.CRg.Dmm))
      {
        localObject1 = getString(2131765005);
        if (!bu.isNullOrNil(this.CRg.Dmo))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletBalanceManagerUI", "entry_word：%s", new Object[] { this.CRg.Dmo });
          localObject1 = this.CRg.Dmo;
        }
        addTextOptionMenu(0, (String)localObject1, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(68648);
            paramAnonymousMenuItem = new Intent();
            if (!bu.isNullOrNil(WalletBalanceManagerUI.this.CRg.Dmn))
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletBalanceManagerUI", "carson: entry_url: %s", new Object[] { WalletBalanceManagerUI.this.CRg.Dmn });
              paramAnonymousMenuItem.putExtra("rawUrl", WalletBalanceManagerUI.this.CRg.Dmn);
            }
            for (;;)
            {
              paramAnonymousMenuItem.putExtra("showShare", false);
              paramAnonymousMenuItem.putExtra("geta8key_username", v.aAC());
              paramAnonymousMenuItem.putExtra("KPublisherId", "pay_blance_list");
              paramAnonymousMenuItem.putExtra("geta8key_scene", 33);
              paramAnonymousMenuItem.putExtra(e.m.JpI, true);
              com.tencent.mm.wallet_core.ui.f.an(WalletBalanceManagerUI.this.getContext(), paramAnonymousMenuItem);
              com.tencent.mm.wallet_core.ui.f.aha(16);
              com.tencent.mm.plugin.report.service.g.yxI.f(16503, new Object[] { Integer.valueOf(1), "balanceBill" });
              AppMethodBeat.o(68648);
              return true;
              paramAnonymousMenuItem.putExtra("rawUrl", WalletBalanceManagerUI.this.CRg.Dmm);
            }
          }
        }, s.b.JwJ);
      }
    }
    if ((this.CRp == null) || (this.CRo == null) || (isFinishing()) || (isDestroyed()))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletBalanceManagerUI", "accountUpdateServiceTv == null || marginLine == null || WalletBalanceManagerUI.this.isFinishing()|| WalletBalanceManagerUI.this.isDestroyed()：%s，%s", new Object[] { Boolean.valueOf(isFinishing()), Boolean.valueOf(isDestroyed()) });
      AppMethodBeat.o(163864);
      return;
    }
    final a locala = new a((byte)0);
    b localb = new b((byte)0);
    for (;;)
    {
      try
      {
        localObject1 = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(am.a.IWy, null);
        if (bu.isNullOrNil((String)localObject1)) {
          break label642;
        }
        Object localObject2 = new JSONObject((String)localObject1);
        boolean bool1 = ((JSONObject)localObject2).optBoolean("is_exposure", false);
        this.CRp.setVisibility(8);
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          localObject1 = ((JSONObject)localObject2).optString("jump_info");
          localObject2 = ((JSONObject)localObject2).optString("wording_item");
          if (!bu.isNullOrNil((String)localObject1))
          {
            localObject1 = new JSONObject((String)localObject1);
            locala.uIW = ((JSONObject)localObject1).optInt("type", 0);
            locala.oGf = ((JSONObject)localObject1).optString("url");
            locala.CRv = ((JSONObject)localObject1).optString("mini_username");
            locala.CRw = ((JSONObject)localObject1).optString("mini_pagepath");
          }
          bool2 = bool1;
          if (!bu.isNullOrNil((String)localObject2))
          {
            localObject1 = new JSONObject((String)localObject2);
            localb.dyI = ((JSONObject)localObject1).optString("wording");
            localb.color = ((JSONObject)localObject1).optInt("color", -1);
            localb.CRx = ((JSONObject)localObject1).optInt("dark_color", -1);
            bool2 = bool1;
          }
          if (!bool2) {
            break label613;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletBalanceManagerUI", "show Lqt ServceEntrance");
          com.tencent.mm.wallet_core.ui.f.aha(45);
          if (localb.dyI != null) {
            this.CRp.setText(localb.dyI);
          }
          if (com.tencent.mm.ui.al.isDarkMode()) {
            continue;
          }
          if (localb.color != -1) {
            continue;
          }
          this.CRp.setTextColor(getResources().getColor(2131100547));
          this.CRp.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(163862);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              switch (locala.uIW)
              {
              default: 
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletBalanceManagerUI", "unknown entrance type");
              }
              for (;;)
              {
                com.tencent.mm.wallet_core.ui.f.aha(46);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(163862);
                return;
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("rawUrl", locala.oGf);
                paramAnonymousView.putExtra("showShare", false);
                paramAnonymousView.putExtra("geta8key_username", v.aAC());
                paramAnonymousView.putExtra(e.m.JpI, true);
                com.tencent.mm.wallet_core.ui.f.an(WalletBalanceManagerUI.this.getContext(), paramAnonymousView);
                continue;
                paramAnonymousView = new vq();
                paramAnonymousView.dKT.userName = locala.CRv;
                paramAnonymousView.dKT.dKV = locala.CRw;
                paramAnonymousView.dKT.scene = 1034;
                paramAnonymousView.dKT.dKW = 0;
                com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
                continue;
                if (locala.oGf.equals("wxpay://lqp/balanceQuotaState"))
                {
                  paramAnonymousView = new Intent();
                  d.b(WalletBalanceManagerUI.this.getContext(), "wallet_ecard", ".ui.WalletECardLogoutUI", paramAnonymousView);
                }
              }
            }
          });
          this.CRp.setVisibility(0);
          if (aJG()) {
            continue;
          }
          this.CRo.setVisibility(0);
          AppMethodBeat.o(163864);
          return;
        }
        catch (JSONException localJSONException2)
        {
          continue;
        }
        localJSONException1 = localJSONException1;
        bool1 = false;
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.WalletBalanceManagerUI", localJSONException1, "", new Object[0]);
        bool2 = bool1;
        continue;
        this.CRp.setTextColor(localb.color);
        continue;
        if (localb.CRx == -1)
        {
          this.CRp.setTextColor(getResources().getColor(2131100547));
          continue;
        }
        this.CRp.setTextColor(localb.CRx);
        continue;
        this.CRo.setVisibility(8);
        AppMethodBeat.o(163864);
        return;
      }
      label613:
      this.CRo.setVisibility(8);
      AppMethodBeat.o(163864);
      return;
      label642:
      boolean bool2 = false;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495901;
  }
  
  protected final void hr(boolean paramBoolean)
  {
    AppMethodBeat.i(68673);
    ub(paramBoolean);
    s.eGW();
    this.CRg = s.eGX().CRg;
    if (this.CRg != null)
    {
      if (eGi()) {
        this.CQZ.setVisibility(0);
      }
    }
    else
    {
      localObject = findViewById(2131301692);
      com.tencent.mm.kernel.g.ajS();
      if (((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUB, Integer.valueOf(-1))).intValue() != 1) {
        break label197;
      }
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (!new com.tencent.mm.plugin.wallet_core.model.al().eJD()) {
        break label206;
      }
      com.tencent.mm.kernel.g.ajS();
      localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPx, getString(2131762205));
      this.CRa.setVisibility(0);
      this.CRb.setTextColor(getResources().getColor(2131101100));
      this.CRb.setText((CharSequence)localObject);
      this.CRa.setOnClickListener(new WalletBalanceManagerUI.15(this));
      AppMethodBeat.o(68673);
      return;
      this.CQZ.setVisibility(8);
      break;
      label197:
      ((View)localObject).setVisibility(8);
    }
    label206:
    s.eGW();
    if (s.eGX().eKo() == 1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      s.eGW();
      localObject = s.eGX().eKp();
      s.eGW();
      String str = s.eGX().eKq();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletBalanceManagerUI", "isShowLqtCell:%s lqtCellTitle:%s lqtCellWording:%s", new Object[] { Boolean.valueOf(paramBoolean), localObject, str });
      if ((!paramBoolean) || ((bu.isNullOrNil((String)localObject)) && (bu.isNullOrNil(str)))) {
        break;
      }
      this.CRa.setVisibility(8);
      AppMethodBeat.o(68673);
      return;
    }
    s.eGW();
    if (s.eGX().eJW())
    {
      s.eGW();
      if (!bu.isNullOrNil(s.eGX().eJS()))
      {
        this.CRa.setVisibility(0);
        this.CRa.setOnClickListener(new WalletBalanceManagerUI.16(this));
        localObject = this.CRb;
        s.eGW();
        ((TextView)localObject).setText(s.eGX().eJS());
        AppMethodBeat.o(68673);
        return;
      }
    }
    s.eGW();
    Object localObject = s.eGX();
    if ((localObject != null) && (((an)localObject).eJP().eJy()) && (!TextUtils.isEmpty(((an)localObject).eJS())) && (!TextUtils.isEmpty(((an)localObject).eJT())))
    {
      this.CRa.setVisibility(0);
      this.CRb.setText(((an)localObject).eJS());
      this.CRa.setOnClickListener(new WalletBalanceManagerUI.2(this, (an)localObject));
      AppMethodBeat.o(68673);
      return;
    }
    this.CRa.setVisibility(8);
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
    this.CRf = ((WcPayMoneyLoadingView)findViewById(2131306666));
    this.vSO = ((ProgressBar)findViewById(2131306757));
    this.CQn = ((TextView)findViewById(2131306652));
    this.CRf.setLoadingPb(this.vSO);
    this.CRf.setPrefixSymbol(getString(2131765813));
    getLifecycle().addObserver(this.CRf);
    ((Button)findViewById(2131302852)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68657);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletBalanceManagerUI.this.eGg();
        com.tencent.mm.wallet_core.ui.f.aha(14);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68657);
      }
    });
    this.CQZ = ((Button)findViewById(2131306653));
    this.CQZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68658);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        s.eGW();
        paramAnonymousView = s.eGX().eKd();
        if ((paramAnonymousView == null) || (paramAnonymousView.size() == 0))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is empty, do bind card to fetch");
          WalletBalanceManagerUI.d(WalletBalanceManagerUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68658);
          return;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is valid, to do fetch");
          com.tencent.mm.wallet_core.a.a(WalletBalanceManagerUI.this, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
          com.tencent.mm.wallet_core.ui.f.aha(15);
        }
      }
    });
    this.CRo = findViewById(2131306654);
    this.CRp = ((TextView)findViewById(2131306651));
    Object localObject = (TextView)findViewById(2131306655);
    if (!aJG())
    {
      ((TextView)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68659);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", "https://kf.qq.com/touch/scene_product.html?scene_id=kf4");
          paramAnonymousView.putExtra("showShare", false);
          paramAnonymousView.putExtra("geta8key_username", v.aAC());
          paramAnonymousView.putExtra(e.m.JpI, true);
          com.tencent.mm.wallet_core.ui.f.an(WalletBalanceManagerUI.this.getContext(), paramAnonymousView);
          com.tencent.mm.wallet_core.ui.f.aha(17);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68659);
        }
      });
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      ((TextView)findViewById(2131306833)).setText(com.tencent.mm.wallet_core.c.ah.fWb());
      this.CRc = ((ViewGroup)findViewById(2131297087));
      this.CRd = ((TextView)findViewById(2131297088));
      this.CRe = ((ImageView)findViewById(2131297086));
      this.CRa = findViewById(2131301403);
      this.CRb = ((TextView)findViewById(2131301404));
      this.CRk = ((ViewGroup)findViewById(2131297099));
      this.CRm = ((TextView)findViewById(2131297097));
      this.CRl = ((CdnImageView)findViewById(2131297098));
      this.CRn = ((CdnImageView)findViewById(2131297096));
      localObject = new yo();
      ((yo)localObject).dNR.scene = "2";
      ((yo)localObject).callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68660);
          if (!bu.isNullOrNil(this.pmv.dNS.dNT)) {
            com.tencent.mm.wallet_core.ui.f.a(WalletBalanceManagerUI.this.CQn, this.pmv.dNS.dNT, this.pmv.dNS.content, this.pmv.dNS.url);
          }
          AppMethodBeat.o(68660);
        }
      };
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
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
    paramBundle = ECardInfo.eIM();
    if (paramBundle != null)
    {
      if (paramBundle.FIU != 1) {
        break label240;
      }
      paramBundle = new Bundle();
      isTransparent();
      com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramBundle, null, 0);
    }
    for (;;)
    {
      addSceneEndListener(621);
      t.eJm();
      com.tencent.mm.plugin.wallet_core.model.ah.a(this);
      initView();
      ab.kI(2, 0);
      com.tencent.mm.plugin.report.service.g.yxI.f(11850, new Object[] { Integer.valueOf(6), Integer.valueOf(0) });
      com.tencent.mm.wallet_core.ui.f.aha(10);
      a(w.bb(bx.M((String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(am.a.IXf, ""), "sysmsg")));
      AppMethodBeat.o(68664);
      return;
      label240:
      if (paramBundle.FIU == 3)
      {
        paramBundle = ECardInfo.eIN();
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
    t.eJm();
    com.tencent.mm.plugin.wallet_core.model.ah.b(this);
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().b(this);
    if (this.CRj != null) {
      this.CRj.cancel();
    }
    this.CRj = null;
    super.onDestroy();
    AppMethodBeat.o(68667);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(68678);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + paramIntent.getIntExtra("from_bind_ui", 0));
    if (paramIntent.getIntExtra("from_bind_ui", 0) == com.tencent.mm.plugin.wallet.balance.a.CNY)
    {
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
      com.tencent.mm.wallet_core.ui.f.aha(15);
    }
    AppMethodBeat.o(68678);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68671);
    super.onPause();
    this.CRf.reset();
    AppMethodBeat.o(68671);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68670);
    hr(true);
    eGf();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletBalanceManagerUI", "do query balance menu");
    if (this.CRj != null) {
      this.CRj.cancel();
    }
    this.CRj = new com.tencent.mm.plugin.wallet.balance.model.a();
    this.CRj.aET().b(new com.tencent.mm.vending.c.a() {});
    super.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.eMV(), null);
    AppMethodBeat.o(68670);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(68676);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (!(paramn instanceof com.tencent.mm.plugin.wallet.bind.a.b)) && ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad)))
    {
      this.CRi = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).DgV;
      if ((this.CRi == null) || (this.CRk.isShown())) {
        break label199;
      }
      if (bu.isNullOrNil(this.CRi.dyI)) {
        break label187;
      }
      this.CRd.setText(this.CRi.dyI);
      if (!bu.isNullOrNil(this.CRi.hDr))
      {
        this.CRd.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cp(this.CRi.hDr, true));
        paramString = this.CRe.getDrawable();
        if (paramString != null) {
          paramString.setColorFilter(com.tencent.mm.plugin.wallet_core.utils.g.cp(this.CRi.hDr, false), PorterDuff.Mode.SRC_ATOP);
        }
      }
      this.CRc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(163858);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletBalanceManagerUI", "click action entry");
          if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type == 1)
          {
            if (bu.isNullOrNil(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Dnu))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(163858);
              return;
            }
            if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Dnu.startsWith("weixin://wcpay/lqt/detail"))
            {
              com.tencent.mm.plugin.wallet.balance.model.lqt.ae.parseUrl(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Dnu);
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_account_type", 1);
              d.b(WalletBalanceManagerUI.this.getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramAnonymousView);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(163858);
            return;
            if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Dnu.startsWith("weixin://wcpay/lqt/save"))
            {
              com.tencent.mm.plugin.wallet.balance.model.lqt.ae.parseUrl(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Dnu);
              paramAnonymousView = com.tencent.mm.plugin.wallet.balance.model.lqt.ae.aFk(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Dnu);
              localObject = com.tencent.mm.wallet_core.ui.h.c(WalletBalanceManagerUI.this.getContext(), false, null);
              new com.tencent.mm.plugin.wallet.balance.model.lqt.o().aET().b(new com.tencent.mm.vending.c.a() {});
              continue;
              if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type == 2) {
                com.tencent.mm.wallet_core.ui.f.o(WalletBalanceManagerUI.this.getContext(), WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).prB, true);
              } else if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type == 3) {
                com.tencent.mm.wallet_core.ui.f.u(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Dnv, WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Dnw, 0, 1061);
              } else {
                com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.WalletBalanceManagerUI", "unknown type: %s", new Object[] { Integer.valueOf(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type) });
              }
            }
          }
        }
      });
      this.CRc.setVisibility(0);
    }
    for (;;)
    {
      hr(false);
      eGh();
      AppMethodBeat.o(68676);
      return false;
      label187:
      this.CRc.setVisibility(8);
      continue;
      label199:
      this.CRc.setVisibility(8);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    public String CRv;
    public String CRw;
    public String oGf;
    public int uIW;
  }
  
  static final class b
  {
    public int CRx;
    public int color;
    public String dyI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI
 * JD-Core Version:    0.7.0.1
 */