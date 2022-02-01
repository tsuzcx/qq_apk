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
import com.tencent.mm.ak.c.a;
import com.tencent.mm.br.d;
import com.tencent.mm.cn.f;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.xo;
import com.tencent.mm.g.a.xo.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.asw;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ah;
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
  protected TextView AYz;
  protected Button AZi;
  protected View AZj;
  protected TextView AZk;
  private ViewGroup AZl;
  private TextView AZm;
  private ImageView AZn;
  private WcPayMoneyLoadingView AZo;
  protected Bankcard AZp;
  private bf AZq;
  private com.tencent.mm.plugin.wallet_core.model.h AZr;
  private com.tencent.mm.plugin.wallet.balance.model.a AZs;
  private ViewGroup AZt;
  private CdnImageView AZu;
  private TextView AZv;
  private CdnImageView AZw;
  private View AZx;
  private TextView AZy;
  protected int mScene;
  private ProgressBar uDK;
  private c<kj> vsr;
  
  public WalletBalanceManagerUI()
  {
    AppMethodBeat.i(68663);
    this.vsr = new c() {};
    AppMethodBeat.o(68663);
  }
  
  private void a(final v paramv)
  {
    AppMethodBeat.i(68665);
    if (paramv == null)
    {
      this.AZt.setVisibility(8);
      AppMethodBeat.o(68665);
      return;
    }
    label82:
    GradientDrawable localGradientDrawable;
    if (!bs.isNullOrNil(paramv.BzT))
    {
      this.AZu.setUrl(paramv.BzT);
      this.AZu.setVisibility(0);
      if (bs.isNullOrNil(paramv.BzU)) {
        break label257;
      }
      this.AZw.setUrl(paramv.BzU);
      this.AZw.setVisibility(0);
      this.AZv.setText(paramv.dlQ);
      if (!bs.isNullOrNil(paramv.BzQ))
      {
        if (!aj.DT()) {
          break label269;
        }
        this.AZv.setTextColor(aj.gy(bs.fM(paramv.BzQ, -16777216)));
      }
      label128:
      this.AZv.setTextSize(1, paramv.BzR);
      if (!bs.isNullOrNil(paramv.yhq))
      {
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(0);
        if (!aj.DT()) {
          break label288;
        }
        localGradientDrawable.setColor(aj.gy(bs.fM(paramv.yhq, -1)));
      }
    }
    for (;;)
    {
      localGradientDrawable.setCornerRadius(com.tencent.mm.cc.a.fromDPToPix(getContext(), 4));
      this.AZt.setBackground(localGradientDrawable);
      this.AZt.setVisibility(0);
      this.AZt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68655);
          ac.i("MicroMsg.WalletBalanceManagerUI", "click freeze layout");
          com.tencent.mm.wallet_core.ui.e.n(WalletBalanceManagerUI.this.getContext(), paramv.BzS, true);
          v.azg("");
          WalletBalanceManagerUI.b(WalletBalanceManagerUI.this).setVisibility(8);
          AppMethodBeat.o(68655);
        }
      });
      this.AZl.setVisibility(8);
      AppMethodBeat.o(68665);
      return;
      this.AZu.setVisibility(8);
      break;
      label257:
      this.AZw.setVisibility(8);
      break label82;
      label269:
      this.AZv.setTextColor(bs.fM(paramv.BzQ, -16777216));
      break label128;
      label288:
      localGradientDrawable.setColor(bs.fM(paramv.yhq, -1));
    }
  }
  
  private static boolean aGf()
  {
    AppMethodBeat.i(163863);
    if (!com.tencent.mm.sdk.platformtools.ab.eUO().equals("zh_CN"))
    {
      AppMethodBeat.o(163863);
      return true;
    }
    boolean bool = bs.ja(ai.getContext());
    AppMethodBeat.o(163863);
    return bool;
  }
  
  private boolean eoC()
  {
    AppMethodBeat.i(68675);
    com.tencent.mm.plugin.wallet.a.s.epp();
    if ((com.tencent.mm.plugin.wallet.a.s.epq().esi().eoC()) && (this.AZp.Buo > 0.0D))
    {
      AppMethodBeat.o(68675);
      return true;
    }
    AppMethodBeat.o(68675);
    return false;
  }
  
  private void tk(boolean paramBoolean)
  {
    AppMethodBeat.i(68672);
    long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ah.a.GQn, Long.valueOf(0L))).longValue();
    WcPayMoneyLoadingView localWcPayMoneyLoadingView = this.AZo;
    String str = com.tencent.mm.wallet_core.ui.e.C(com.tencent.mm.wallet_core.ui.e.a(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue());
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localWcPayMoneyLoadingView.cc(str, paramBoolean);
      AppMethodBeat.o(68672);
      return;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(68679);
    if ((paramn == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      ac.i("MicroMsg.WalletBalanceManagerUI", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        tk(false);
      }
    }
    AppMethodBeat.o(68679);
  }
  
  protected void eoA()
  {
    AppMethodBeat.i(68668);
    startActivity(WalletBalanceSaveUI.class);
    AppMethodBeat.o(68668);
  }
  
  protected final void eoB()
  {
    AppMethodBeat.i(163864);
    removeAllOptionMenu();
    ac.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
    Object localObject1;
    if (this.AZp != null)
    {
      com.tencent.mm.plugin.wallet.a.s.epp();
      com.tencent.mm.plugin.wallet.a.s.epq();
      if (!bs.isNullOrNil(this.AZp.Bur))
      {
        localObject1 = getString(2131765005);
        if (!bs.isNullOrNil(this.AZp.But))
        {
          ac.i("MicroMsg.WalletBalanceManagerUI", "entry_word：%s", new Object[] { this.AZp.But });
          localObject1 = this.AZp.But;
        }
        addTextOptionMenu(0, (String)localObject1, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(68648);
            paramAnonymousMenuItem = new Intent();
            if (!bs.isNullOrNil(WalletBalanceManagerUI.this.AZp.Bus))
            {
              ac.i("MicroMsg.WalletBalanceManagerUI", "carson: entry_url: %s", new Object[] { WalletBalanceManagerUI.this.AZp.Bus });
              paramAnonymousMenuItem.putExtra("rawUrl", WalletBalanceManagerUI.this.AZp.Bus);
            }
            for (;;)
            {
              paramAnonymousMenuItem.putExtra("showShare", false);
              paramAnonymousMenuItem.putExtra("geta8key_username", u.axw());
              paramAnonymousMenuItem.putExtra("KPublisherId", "pay_blance_list");
              paramAnonymousMenuItem.putExtra("geta8key_scene", 33);
              paramAnonymousMenuItem.putExtra(e.m.HhK, true);
              com.tencent.mm.wallet_core.ui.e.al(WalletBalanceManagerUI.this.getContext(), paramAnonymousMenuItem);
              com.tencent.mm.wallet_core.ui.e.adR(16);
              com.tencent.mm.plugin.report.service.h.wUl.f(16503, new Object[] { Integer.valueOf(1), "balanceBill" });
              AppMethodBeat.o(68648);
              return true;
              paramAnonymousMenuItem.putExtra("rawUrl", WalletBalanceManagerUI.this.AZp.Bur);
            }
          }
        }, s.b.Hov);
      }
    }
    if ((this.AZy == null) || (this.AZx == null) || (isFinishing()) || (isDestroyed()))
    {
      ac.i("MicroMsg.WalletBalanceManagerUI", "accountUpdateServiceTv == null || marginLine == null || WalletBalanceManagerUI.this.isFinishing()|| WalletBalanceManagerUI.this.isDestroyed()：%s，%s", new Object[] { Boolean.valueOf(isFinishing()), Boolean.valueOf(isDestroyed()) });
      AppMethodBeat.o(163864);
      return;
    }
    final a locala = new a((byte)0);
    b localb = new b((byte)0);
    for (;;)
    {
      try
      {
        localObject1 = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ah.a.GPE, null);
        if (bs.isNullOrNil((String)localObject1)) {
          break label641;
        }
        Object localObject2 = new JSONObject((String)localObject1);
        boolean bool1 = ((JSONObject)localObject2).optBoolean("is_exposure", false);
        this.AZy.setVisibility(8);
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          localObject1 = ((JSONObject)localObject2).optString("jump_info");
          localObject2 = ((JSONObject)localObject2).optString("wording_item");
          if (!bs.isNullOrNil((String)localObject1))
          {
            localObject1 = new JSONObject((String)localObject1);
            locala.vjP = ((JSONObject)localObject1).optInt("type", 0);
            locala.nWj = ((JSONObject)localObject1).optString("url");
            locala.AZE = ((JSONObject)localObject1).optString("mini_username");
            locala.AZF = ((JSONObject)localObject1).optString("mini_pagepath");
          }
          bool2 = bool1;
          if (!bs.isNullOrNil((String)localObject2))
          {
            localObject1 = new JSONObject((String)localObject2);
            localb.dlQ = ((JSONObject)localObject1).optString("wording");
            localb.color = ((JSONObject)localObject1).optInt("color", -1);
            localb.AZG = ((JSONObject)localObject1).optInt("dark_color", -1);
            bool2 = bool1;
          }
          if (!bool2) {
            break label612;
          }
          ac.i("MicroMsg.WalletBalanceManagerUI", "show Lqt ServceEntrance");
          com.tencent.mm.wallet_core.ui.e.adR(45);
          if (localb.dlQ != null) {
            this.AZy.setText(localb.dlQ);
          }
          if (aj.DT()) {
            continue;
          }
          if (localb.color != -1) {
            continue;
          }
          this.AZy.setTextColor(getResources().getColor(2131100547));
          this.AZy.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(163862);
              switch (locala.vjP)
              {
              default: 
                ac.i("MicroMsg.WalletBalanceManagerUI", "unknown entrance type");
              }
              for (;;)
              {
                com.tencent.mm.wallet_core.ui.e.adR(46);
                AppMethodBeat.o(163862);
                return;
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("rawUrl", locala.nWj);
                paramAnonymousView.putExtra("showShare", false);
                paramAnonymousView.putExtra("geta8key_username", u.axw());
                paramAnonymousView.putExtra(e.m.HhK, true);
                com.tencent.mm.wallet_core.ui.e.al(WalletBalanceManagerUI.this.getContext(), paramAnonymousView);
                continue;
                paramAnonymousView = new ut();
                paramAnonymousView.dxt.userName = locala.AZE;
                paramAnonymousView.dxt.dxv = locala.AZF;
                paramAnonymousView.dxt.scene = 1034;
                paramAnonymousView.dxt.dxw = 0;
                com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
                continue;
                if (locala.nWj.equals("wxpay://lqp/balanceQuotaState"))
                {
                  paramAnonymousView = new Intent();
                  d.b(WalletBalanceManagerUI.this.getContext(), "wallet_ecard", ".ui.WalletECardLogoutUI", paramAnonymousView);
                }
              }
            }
          });
          this.AZy.setVisibility(0);
          if (aGf()) {
            continue;
          }
          this.AZx.setVisibility(0);
          AppMethodBeat.o(163864);
          return;
        }
        catch (JSONException localJSONException2)
        {
          continue;
        }
        localJSONException1 = localJSONException1;
        bool1 = false;
        ac.printErrStackTrace("MicroMsg.WalletBalanceManagerUI", localJSONException1, "", new Object[0]);
        bool2 = bool1;
        continue;
        this.AZy.setTextColor(localb.color);
        continue;
        if (localb.AZG == -1)
        {
          this.AZy.setTextColor(getResources().getColor(2131100547));
          continue;
        }
        this.AZy.setTextColor(localb.AZG);
        continue;
        this.AZx.setVisibility(8);
        AppMethodBeat.o(163864);
        return;
      }
      label612:
      this.AZx.setVisibility(8);
      AppMethodBeat.o(163864);
      return;
      label641:
      boolean bool2 = false;
    }
  }
  
  protected void eoz()
  {
    AppMethodBeat.i(68666);
    com.tencent.mm.plugin.wallet.a.s.epp();
    if (com.tencent.mm.plugin.wallet.a.s.epq().AZp == null) {}
    for (boolean bool = true;; bool = false)
    {
      doSceneProgress(new ad(null, 10), bool);
      AppMethodBeat.o(68666);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495901;
  }
  
  protected final void hj(boolean paramBoolean)
  {
    AppMethodBeat.i(68673);
    tk(paramBoolean);
    com.tencent.mm.plugin.wallet.a.s.epp();
    this.AZp = com.tencent.mm.plugin.wallet.a.s.epq().AZp;
    if (this.AZp != null)
    {
      if (eoC()) {
        this.AZi.setVisibility(0);
      }
    }
    else
    {
      localObject = findViewById(2131301692);
      com.tencent.mm.kernel.g.agS();
      if (((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GNL, Integer.valueOf(-1))).intValue() != 1) {
        break label197;
      }
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (!new ak().erW()) {
        break label206;
      }
      com.tencent.mm.kernel.g.agS();
      localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIH, getString(2131762205));
      this.AZj.setVisibility(0);
      this.AZk.setTextColor(getResources().getColor(2131101100));
      this.AZk.setText((CharSequence)localObject);
      this.AZj.setOnClickListener(new WalletBalanceManagerUI.15(this));
      AppMethodBeat.o(68673);
      return;
      this.AZi.setVisibility(8);
      break;
      label197:
      ((View)localObject).setVisibility(8);
    }
    label206:
    com.tencent.mm.plugin.wallet.a.s.epp();
    if (com.tencent.mm.plugin.wallet.a.s.epq().esH() == 1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      com.tencent.mm.plugin.wallet.a.s.epp();
      localObject = com.tencent.mm.plugin.wallet.a.s.epq().esI();
      com.tencent.mm.plugin.wallet.a.s.epp();
      String str = com.tencent.mm.plugin.wallet.a.s.epq().esJ();
      ac.i("MicroMsg.WalletBalanceManagerUI", "isShowLqtCell:%s lqtCellTitle:%s lqtCellWording:%s", new Object[] { Boolean.valueOf(paramBoolean), localObject, str });
      if ((!paramBoolean) || ((bs.isNullOrNil((String)localObject)) && (bs.isNullOrNil(str)))) {
        break;
      }
      this.AZj.setVisibility(8);
      AppMethodBeat.o(68673);
      return;
    }
    com.tencent.mm.plugin.wallet.a.s.epp();
    if (com.tencent.mm.plugin.wallet.a.s.epq().esp())
    {
      com.tencent.mm.plugin.wallet.a.s.epp();
      if (!bs.isNullOrNil(com.tencent.mm.plugin.wallet.a.s.epq().esl()))
      {
        this.AZj.setVisibility(0);
        this.AZj.setOnClickListener(new WalletBalanceManagerUI.16(this));
        localObject = this.AZk;
        com.tencent.mm.plugin.wallet.a.s.epp();
        ((TextView)localObject).setText(com.tencent.mm.plugin.wallet.a.s.epq().esl());
        AppMethodBeat.o(68673);
        return;
      }
    }
    com.tencent.mm.plugin.wallet.a.s.epp();
    Object localObject = com.tencent.mm.plugin.wallet.a.s.epq();
    if ((localObject != null) && (((am)localObject).esi().erR()) && (!TextUtils.isEmpty(((am)localObject).esl())) && (!TextUtils.isEmpty(((am)localObject).esm())))
    {
      this.AZj.setVisibility(0);
      this.AZk.setText(((am)localObject).esl());
      this.AZj.setOnClickListener(new WalletBalanceManagerUI.2(this, (am)localObject));
      AppMethodBeat.o(68673);
      return;
    }
    this.AZj.setVisibility(8);
    AppMethodBeat.o(68673);
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
    this.AZo = ((WcPayMoneyLoadingView)findViewById(2131306666));
    this.uDK = ((ProgressBar)findViewById(2131306757));
    this.AYz = ((TextView)findViewById(2131306652));
    this.AZo.setLoadingPb(this.uDK);
    this.AZo.setPrefixSymbol(getString(2131765813));
    getLifecycle().addObserver(this.AZo);
    ((Button)findViewById(2131302852)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68657);
        WalletBalanceManagerUI.this.eoA();
        com.tencent.mm.wallet_core.ui.e.adR(14);
        AppMethodBeat.o(68657);
      }
    });
    this.AZi = ((Button)findViewById(2131306653));
    this.AZi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68658);
        com.tencent.mm.plugin.wallet.a.s.epp();
        paramAnonymousView = com.tencent.mm.plugin.wallet.a.s.epq().esw();
        if ((paramAnonymousView == null) || (paramAnonymousView.size() == 0))
        {
          ac.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is empty, do bind card to fetch");
          WalletBalanceManagerUI.d(WalletBalanceManagerUI.this);
          AppMethodBeat.o(68658);
          return;
        }
        ac.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is valid, to do fetch");
        com.tencent.mm.wallet_core.a.a(WalletBalanceManagerUI.this, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
        com.tencent.mm.wallet_core.ui.e.adR(15);
        AppMethodBeat.o(68658);
      }
    });
    this.AZx = findViewById(2131306654);
    this.AZy = ((TextView)findViewById(2131306651));
    Object localObject = (TextView)findViewById(2131306655);
    if (!aGf())
    {
      ((TextView)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68659);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", "https://kf.qq.com/touch/scene_product.html?scene_id=kf4");
          paramAnonymousView.putExtra("showShare", false);
          paramAnonymousView.putExtra("geta8key_username", u.axw());
          paramAnonymousView.putExtra(e.m.HhK, true);
          com.tencent.mm.wallet_core.ui.e.al(WalletBalanceManagerUI.this.getContext(), paramAnonymousView);
          com.tencent.mm.wallet_core.ui.e.adR(17);
          AppMethodBeat.o(68659);
        }
      });
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      ((TextView)findViewById(2131306833)).setText(ah.fAv());
      this.AZl = ((ViewGroup)findViewById(2131297087));
      this.AZm = ((TextView)findViewById(2131297088));
      this.AZn = ((ImageView)findViewById(2131297086));
      this.AZj = findViewById(2131301403);
      this.AZk = ((TextView)findViewById(2131301404));
      this.AZt = ((ViewGroup)findViewById(2131297099));
      this.AZv = ((TextView)findViewById(2131297097));
      this.AZu = ((CdnImageView)findViewById(2131297098));
      this.AZw = ((CdnImageView)findViewById(2131297096));
      localObject = new xo();
      ((xo)localObject).dAo.scene = "2";
      ((xo)localObject).callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68660);
          if (!bs.isNullOrNil(this.oCu.dAp.dAq)) {
            com.tencent.mm.wallet_core.ui.e.a(WalletBalanceManagerUI.this.AYz, this.oCu.dAp.dAq, this.oCu.dAp.content, this.oCu.dAp.url);
          }
          AppMethodBeat.o(68660);
        }
      };
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
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
    paramBundle = ECardInfo.erf();
    if (paramBundle != null)
    {
      if (paramBundle.DLr != 1) {
        break label239;
      }
      paramBundle = new Bundle();
      isTransparent();
      com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramBundle, null, 0);
    }
    for (;;)
    {
      addSceneEndListener(621);
      com.tencent.mm.plugin.wallet_core.model.s.erF();
      ag.a(this);
      initView();
      com.tencent.mm.wallet_core.c.ab.km(2, 0);
      com.tencent.mm.plugin.report.service.h.wUl.f(11850, new Object[] { Integer.valueOf(6), Integer.valueOf(0) });
      com.tencent.mm.wallet_core.ui.e.adR(10);
      a(v.aS(bv.L((String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ah.a.GQl, ""), "sysmsg")));
      AppMethodBeat.o(68664);
      return;
      label239:
      if (paramBundle.DLr == 3)
      {
        paramBundle = ECardInfo.erg();
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
    com.tencent.mm.plugin.wallet_core.model.s.erF();
    ag.b(this);
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().b(this);
    if (this.AZs != null) {
      this.AZs.cancel();
    }
    this.AZs = null;
    super.onDestroy();
    AppMethodBeat.o(68667);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(68678);
    ac.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + paramIntent.getIntExtra("from_bind_ui", 0));
    if (paramIntent.getIntExtra("from_bind_ui", 0) == com.tencent.mm.plugin.wallet.balance.a.AWl)
    {
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
      com.tencent.mm.wallet_core.ui.e.adR(15);
    }
    AppMethodBeat.o(68678);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68671);
    super.onPause();
    this.AZo.reset();
    AppMethodBeat.o(68671);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68670);
    hj(true);
    eoz();
    ac.i("MicroMsg.WalletBalanceManagerUI", "do query balance menu");
    if (this.AZs != null) {
      this.AZs.cancel();
    }
    this.AZs = new com.tencent.mm.plugin.wallet.balance.model.a();
    this.AZs.aBB().b(new com.tencent.mm.vending.c.a() {});
    super.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.evh(), null);
    AppMethodBeat.o(68670);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(68676);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (!(paramn instanceof com.tencent.mm.plugin.wallet.bind.a.b)) && ((paramn instanceof ad)))
    {
      this.AZr = ((ad)paramn).Bpc;
      if ((this.AZr == null) || (this.AZt.isShown())) {
        break label199;
      }
      if (bs.isNullOrNil(this.AZr.dlQ)) {
        break label187;
      }
      this.AZm.setText(this.AZr.dlQ);
      if (!bs.isNullOrNil(this.AZr.hiu))
      {
        this.AZm.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cd(this.AZr.hiu, true));
        paramString = this.AZn.getDrawable();
        if (paramString != null) {
          paramString.setColorFilter(com.tencent.mm.plugin.wallet_core.utils.g.cd(this.AZr.hiu, false), PorterDuff.Mode.SRC_ATOP);
        }
      }
      this.AZl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(163858);
          ac.i("MicroMsg.WalletBalanceManagerUI", "click action entry");
          if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type == 1)
          {
            if (bs.isNullOrNil(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Bvz))
            {
              AppMethodBeat.o(163858);
              return;
            }
            if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Bvz.startsWith("weixin://wcpay/lqt/detail"))
            {
              com.tencent.mm.plugin.wallet.balance.model.lqt.ae.parseUrl(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Bvz);
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_account_type", 1);
              d.b(WalletBalanceManagerUI.this.getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramAnonymousView);
              AppMethodBeat.o(163858);
              return;
            }
            if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Bvz.startsWith("weixin://wcpay/lqt/save"))
            {
              com.tencent.mm.plugin.wallet.balance.model.lqt.ae.parseUrl(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Bvz);
              paramAnonymousView = com.tencent.mm.plugin.wallet.balance.model.lqt.ae.ayJ(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).Bvz);
              final Dialog localDialog = com.tencent.mm.wallet_core.ui.g.c(WalletBalanceManagerUI.this.getContext(), false, null);
              new com.tencent.mm.plugin.wallet.balance.model.lqt.o().aBB().b(new com.tencent.mm.vending.c.a() {});
              AppMethodBeat.o(163858);
            }
          }
          else
          {
            if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type == 2)
            {
              com.tencent.mm.wallet_core.ui.e.n(WalletBalanceManagerUI.this.getContext(), WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).oHs, true);
              AppMethodBeat.o(163858);
              return;
            }
            if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type == 3)
            {
              com.tencent.mm.wallet_core.ui.e.v(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).BvA, WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).BvB, 0, 1061);
              AppMethodBeat.o(163858);
              return;
            }
            ac.w("MicroMsg.WalletBalanceManagerUI", "unknown type: %s", new Object[] { Integer.valueOf(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type) });
          }
          AppMethodBeat.o(163858);
        }
      });
      this.AZl.setVisibility(0);
    }
    for (;;)
    {
      hj(false);
      eoB();
      AppMethodBeat.o(68676);
      return false;
      label187:
      this.AZl.setVisibility(8);
      continue;
      label199:
      this.AZl.setVisibility(8);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    public String AZE;
    public String AZF;
    public String nWj;
    public int vjP;
  }
  
  static final class b
  {
    public int AZG;
    public int color;
    public String dlQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI
 * JD-Core Version:    0.7.0.1
 */