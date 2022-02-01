package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.a.acx;
import com.tencent.mm.autogen.a.ng;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.br.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpayreport.a.c.a;
import com.tencent.mm.plugin.wxpayreport.j.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bm;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.protocal.protobuf.eme;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.y.b;
import com.tencent.mm.wallet_core.model.ab;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.k;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletBalanceManagerUI
  extends WalletBaseUI
  implements com.tencent.mm.plugin.wallet_core.model.l, MStorageEx.IOnStorageChange
{
  private ProgressBar KML;
  private IListener<ng> Myr;
  protected TextView Vbz;
  protected TextView VcA;
  private ViewGroup VcB;
  private TextView VcC;
  private ImageView VcD;
  private WcPayMoneyLoadingView VcE;
  protected Bankcard VcF;
  private bm VcG;
  private com.tencent.mm.plugin.wallet_core.model.h VcH;
  private com.tencent.mm.plugin.wallet.balance.model.a VcI;
  private ViewGroup VcJ;
  private CdnImageView VcK;
  private TextView VcL;
  private CdnImageView VcM;
  private View VcN;
  private TextView VcO;
  protected Button Vcy;
  protected View Vcz;
  protected int mScene;
  private WcPayBannerView pLM;
  private Button uSO;
  
  public WalletBalanceManagerUI()
  {
    AppMethodBeat.i(68663);
    this.Myr = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(68663);
  }
  
  private void Hk(boolean paramBoolean)
  {
    AppMethodBeat.i(68672);
    long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.acVr, Long.valueOf(0L))).longValue();
    WcPayMoneyLoadingView localWcPayMoneyLoadingView = this.VcE;
    String str = i.formatMoney2f(i.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue());
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localWcPayMoneyLoadingView.dD(str, paramBoolean);
      AppMethodBeat.o(68672);
      return;
    }
  }
  
  private void a(final x paramx)
  {
    AppMethodBeat.i(68665);
    if (paramx == null)
    {
      this.VcJ.setVisibility(8);
      AppMethodBeat.o(68665);
      return;
    }
    label82:
    GradientDrawable localGradientDrawable;
    if (!Util.isNullOrNil(paramx.VJv))
    {
      this.VcK.setUrl(paramx.VJv);
      this.VcK.setVisibility(0);
      if (Util.isNullOrNil(paramx.VJw)) {
        break label258;
      }
      this.VcM.setUrl(paramx.VJw);
      this.VcM.setVisibility(0);
      this.VcL.setText(paramx.wording);
      if (!Util.isNullOrNil(paramx.VJs))
      {
        if (!aw.isDarkMode()) {
          break label270;
        }
        this.VcL.setTextColor(aw.mx(Util.getHex(paramx.VJs, -16777216)));
      }
      label129:
      this.VcL.setTextSize(1, paramx.VJt);
      if (!Util.isNullOrNil(paramx.bgColor))
      {
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(0);
        if (!aw.isDarkMode()) {
          break label290;
        }
        localGradientDrawable.setColor(aw.mx(Util.getHex(paramx.bgColor, -1)));
      }
    }
    for (;;)
    {
      localGradientDrawable.setCornerRadius(com.tencent.mm.cd.a.fromDPToPix(getContext(), 4));
      this.VcJ.setBackground(localGradientDrawable);
      this.VcJ.setVisibility(0);
      this.VcJ.setOnClickListener(new k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(316363);
          Log.i("MicroMsg.WalletBalanceManagerUI", "click freeze layout");
          i.o(WalletBalanceManagerUI.this.getContext(), paramx.VJu, true);
          x.bgy("");
          WalletBalanceManagerUI.b(WalletBalanceManagerUI.this).setVisibility(8);
          AppMethodBeat.o(316363);
        }
      });
      this.VcB.setVisibility(8);
      AppMethodBeat.o(68665);
      return;
      this.VcK.setVisibility(8);
      break;
      label258:
      this.VcM.setVisibility(8);
      break label82;
      label270:
      this.VcL.setTextColor(Util.getHex(paramx.VJs, -16777216));
      break label129;
      label290:
      localGradientDrawable.setColor(Util.getHex(paramx.bgColor, -1));
    }
  }
  
  private static boolean ieT()
  {
    AppMethodBeat.i(68675);
    com.tencent.mm.plugin.wallet.model.p.ifO();
    boolean bool = com.tencent.mm.plugin.wallet.model.p.ifP().ijp().ieT();
    AppMethodBeat.o(68675);
    return bool;
  }
  
  private static boolean isOverseasUser()
  {
    AppMethodBeat.i(163863);
    if (!LocaleUtil.getApplicationLanguage().equals("zh_CN"))
    {
      AppMethodBeat.o(163863);
      return true;
    }
    boolean bool = Util.isOverseasUser(MMApplicationContext.getContext());
    AppMethodBeat.o(163863);
    return bool;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_balance_manager_ui;
  }
  
  protected void ieQ()
  {
    AppMethodBeat.i(68666);
    com.tencent.mm.plugin.wallet.model.p.ifO();
    if (com.tencent.mm.plugin.wallet.model.p.ifP().VcF == null) {}
    for (boolean bool = true;; bool = false)
    {
      doSceneProgress(new ae(null, 10), bool);
      AppMethodBeat.o(68666);
      return;
    }
  }
  
  protected void ieR()
  {
    AppMethodBeat.i(68668);
    startActivity(WalletBalanceSaveUI.class);
    AppMethodBeat.o(68668);
  }
  
  protected final void ieS()
  {
    AppMethodBeat.i(163864);
    removeAllOptionMenu();
    Log.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
    Object localObject1;
    if (this.VcF != null)
    {
      com.tencent.mm.plugin.wallet.model.p.ifO();
      com.tencent.mm.plugin.wallet.model.p.ifP();
      if (!Util.isNullOrNil(this.VcF.VDr))
      {
        localObject1 = getString(a.i.wallet_balance_manager_option_detail);
        if (!Util.isNullOrNil(this.VcF.VDt))
        {
          Log.i("MicroMsg.WalletBalanceManagerUI", "entry_word：%s", new Object[] { this.VcF.VDt });
          localObject1 = this.VcF.VDt;
        }
        addTextOptionMenu(0, (String)localObject1, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(316358);
            paramAnonymousMenuItem = new Intent();
            if (!Util.isNullOrNil(WalletBalanceManagerUI.this.VcF.VDs))
            {
              Log.i("MicroMsg.WalletBalanceManagerUI", "carson: entry_url: %s", new Object[] { WalletBalanceManagerUI.this.VcF.VDs });
              paramAnonymousMenuItem.putExtra("rawUrl", WalletBalanceManagerUI.this.VcF.VDs);
            }
            for (;;)
            {
              paramAnonymousMenuItem.putExtra("showShare", false);
              paramAnonymousMenuItem.putExtra("geta8key_username", z.bAM());
              paramAnonymousMenuItem.putExtra("KPublisherId", "pay_blance_list");
              paramAnonymousMenuItem.putExtra("geta8key_scene", 33);
              paramAnonymousMenuItem.putExtra(f.s.adxf, true);
              i.aS(WalletBalanceManagerUI.this.getContext(), paramAnonymousMenuItem);
              i.aGA(16);
              com.tencent.mm.plugin.report.service.h.OAn.b(16503, new Object[] { Integer.valueOf(1), "balanceBill" });
              AppMethodBeat.o(316358);
              return true;
              paramAnonymousMenuItem.putExtra("rawUrl", WalletBalanceManagerUI.this.VcF.VDr);
            }
          }
        }, y.b.adES);
      }
    }
    if ((this.VcO == null) || (this.VcN == null) || (isFinishing()) || (isDestroyed()))
    {
      Log.i("MicroMsg.WalletBalanceManagerUI", "accountUpdateServiceTv == null || marginLine == null || WalletBalanceManagerUI.this.isFinishing()|| WalletBalanceManagerUI.this.isDestroyed()：%s，%s", new Object[] { Boolean.valueOf(isFinishing()), Boolean.valueOf(isDestroyed()) });
      AppMethodBeat.o(163864);
      return;
    }
    final a locala = new a((byte)0);
    b localb = new b((byte)0);
    for (;;)
    {
      try
      {
        localObject1 = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.acUG, null);
        if (Util.isNullOrNil((String)localObject1)) {
          break label648;
        }
        Object localObject2 = new JSONObject((String)localObject1);
        boolean bool1 = ((JSONObject)localObject2).optBoolean("is_exposure", false);
        this.VcO.setVisibility(8);
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          localObject1 = ((JSONObject)localObject2).optString("jump_info");
          localObject2 = ((JSONObject)localObject2).optString("wording_item");
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject1 = new JSONObject((String)localObject1);
            locala.jump_type = ((JSONObject)localObject1).optInt("type", 0);
            locala.jump_url = ((JSONObject)localObject1).optString("url");
            locala.VcU = ((JSONObject)localObject1).optString("mini_username");
            locala.VcV = ((JSONObject)localObject1).optString("mini_pagepath");
          }
          bool2 = bool1;
          if (!Util.isNullOrNil((String)localObject2))
          {
            localObject1 = new JSONObject((String)localObject2);
            localb.wording = ((JSONObject)localObject1).optString("wording");
            localb.color = ((JSONObject)localObject1).optInt("color", -1);
            localb.VcW = ((JSONObject)localObject1).optInt("dark_color", -1);
            bool2 = bool1;
          }
          if (!bool2) {
            break label619;
          }
          Log.i("MicroMsg.WalletBalanceManagerUI", "show Lqt ServceEntrance");
          i.aGA(45);
          if (localb.wording != null) {
            this.VcO.setText(localb.wording);
          }
          if (aw.isDarkMode()) {
            continue;
          }
          if (localb.color != -1) {
            continue;
          }
          this.VcO.setTextColor(getResources().getColor(a.c.link_color));
          this.VcO.setOnClickListener(new k()
          {
            public final void dr(View paramAnonymousView)
            {
              AppMethodBeat.i(316556);
              switch (locala.jump_type)
              {
              default: 
                Log.i("MicroMsg.WalletBalanceManagerUI", "unknown entrance type");
              }
              for (;;)
              {
                i.aGA(46);
                AppMethodBeat.o(316556);
                return;
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("rawUrl", locala.jump_url);
                paramAnonymousView.putExtra("showShare", false);
                paramAnonymousView.putExtra("geta8key_username", z.bAM());
                paramAnonymousView.putExtra(f.s.adxf, true);
                i.aS(WalletBalanceManagerUI.this.getContext(), paramAnonymousView);
                continue;
                paramAnonymousView = new zp();
                paramAnonymousView.icM.userName = locala.VcU;
                paramAnonymousView.icM.icO = locala.VcV;
                paramAnonymousView.icM.scene = 1034;
                paramAnonymousView.icM.icP = 0;
                paramAnonymousView.publish();
                continue;
                if (locala.jump_url.equals("wxpay://lqp/balanceQuotaState"))
                {
                  paramAnonymousView = new Intent();
                  c.b(WalletBalanceManagerUI.this.getContext(), "wallet_ecard", ".ui.WalletECardLogoutUI", paramAnonymousView);
                }
              }
            }
          });
          this.VcO.setVisibility(0);
          i.Q(this.VcO);
          if (isOverseasUser()) {
            continue;
          }
          this.VcN.setVisibility(0);
          AppMethodBeat.o(163864);
          return;
        }
        catch (JSONException localJSONException2)
        {
          continue;
        }
        localJSONException1 = localJSONException1;
        bool1 = false;
        Log.printErrStackTrace("MicroMsg.WalletBalanceManagerUI", localJSONException1, "", new Object[0]);
        bool2 = bool1;
        continue;
        this.VcO.setTextColor(localb.color);
        continue;
        if (localb.VcW == -1)
        {
          this.VcO.setTextColor(getResources().getColor(a.c.link_color));
          continue;
        }
        this.VcO.setTextColor(localb.VcW);
        continue;
        this.VcN.setVisibility(8);
        AppMethodBeat.o(163864);
        return;
      }
      label619:
      this.VcN.setVisibility(8);
      AppMethodBeat.o(163864);
      return;
      label648:
      boolean bool2 = false;
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(68669);
    setMMTitle("");
    this.VcE = ((WcPayMoneyLoadingView)findViewById(a.f.wallet_balance_view));
    this.KML = ((ProgressBar)findViewById(a.f.wallet_money_load_pb));
    this.Vbz = ((TextView)findViewById(a.f.wallet_balance_manager_banner));
    this.VcE.setLoadingPb(this.KML);
    this.VcE.setPrefixSymbol(getString(a.i.wallet_rmb_symbol));
    getLifecycle().addObserver(this.VcE);
    this.uSO = ((Button)findViewById(a.f.next_btn));
    this.uSO.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(316357);
        WalletBalanceManagerUI.this.ieR();
        i.aGA(14);
        AppMethodBeat.o(316357);
      }
    });
    this.Vcy = ((Button)findViewById(a.f.wallet_balance_manager_fetch_btn));
    this.Vcy.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(316291);
        com.tencent.mm.plugin.wallet.model.p.ifO();
        paramAnonymousView = com.tencent.mm.plugin.wallet.model.p.ifP().ijD();
        if ((paramAnonymousView == null) || (paramAnonymousView.size() == 0))
        {
          Log.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is empty, do bind card to fetch");
          WalletBalanceManagerUI.d(WalletBalanceManagerUI.this);
          AppMethodBeat.o(316291);
          return;
        }
        Log.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is valid, to do fetch");
        com.tencent.mm.wallet_core.a.a(WalletBalanceManagerUI.this, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
        i.aGA(15);
        AppMethodBeat.o(316291);
      }
    });
    this.VcN = findViewById(a.f.wallet_balance_manager_margin_line);
    this.VcO = ((TextView)findViewById(a.f.wallet_balance_manager_account_update_service));
    Object localObject = (TextView)findViewById(a.f.wallet_balance_manager_qanda);
    if (!isOverseasUser())
    {
      ((TextView)localObject).setOnClickListener(new k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(316287);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", "https://payapp.weixin.qq.com/kfweb/helpcenter/dispatch?scene_code=CommIssueChange");
          paramAnonymousView.putExtra("showShare", false);
          paramAnonymousView.putExtra("geta8key_username", z.bAM());
          paramAnonymousView.putExtra(f.s.adxf, true);
          i.aS(WalletBalanceManagerUI.this.getContext(), paramAnonymousView);
          i.aGA(17);
          AppMethodBeat.o(316287);
        }
      });
      ((TextView)localObject).setVisibility(0);
      i.Q((TextView)localObject);
    }
    for (;;)
    {
      ((TextView)findViewById(a.f.wallet_support_info)).setText(com.tencent.mm.wallet_core.model.ai.jOW());
      this.VcB = ((ViewGroup)findViewById(a.f.balance_action_layout));
      this.VcC = ((TextView)findViewById(a.f.balance_action_tv));
      this.VcD = ((ImageView)findViewById(a.f.balance_action_iv));
      this.Vcz = findViewById(a.f.licaitong_layout);
      this.VcA = ((TextView)findViewById(a.f.licaitong_tips));
      this.VcJ = ((ViewGroup)findViewById(a.f.balance_freeze_layout));
      this.VcL = ((TextView)findViewById(a.f.balance_freeze_desc_tv));
      this.VcK = ((CdnImageView)findViewById(a.f.balance_freeze_icon_iv));
      this.VcM = ((CdnImageView)findViewById(a.f.balance_freeze_arrow_iv));
      this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
      this.pLM.jPz();
      localObject = new acx();
      ((acx)localObject).igk.scene = "2";
      ((acx)localObject).callback = new WalletBalanceManagerUI..ExternalSyntheticLambda0(this, (acx)localObject);
      ((acx)localObject).publish();
      AppMethodBeat.o(68669);
      return;
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  public final void j(int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(68677);
    if ((paramInt != 12) && (paramInt == 43) && (paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      a((x)paramArrayOfObject[0]);
    }
    AppMethodBeat.o(68677);
  }
  
  protected final void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(68673);
    Hk(paramBoolean);
    com.tencent.mm.plugin.wallet.model.p.ifO();
    this.VcF = com.tencent.mm.plugin.wallet.model.p.ifP().VcF;
    if (this.VcF != null)
    {
      if (!ieT()) {
        break label226;
      }
      this.Vcy.setVisibility(0);
      if (((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.acVr, Long.valueOf(0L))).longValue() <= 0L) {
        this.Vcy.setEnabled(false);
      }
    }
    Object localObject = findViewById(a.f.lqt_red_dot);
    com.tencent.mm.kernel.h.baF();
    if (((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acSy, Integer.valueOf(-1))).intValue() == 1) {
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (!new ak().ijb()) {
        break label247;
      }
      com.tencent.mm.kernel.h.baF();
      localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMS, getString(a.i.realname_mgr_title));
      this.Vcz.setVisibility(0);
      this.VcA.setTextColor(getResources().getColor(a.c.wallet_balance_manager_realname_tip));
      this.VcA.setText((CharSequence)localObject);
      this.Vcz.setOnClickListener(new WalletBalanceManagerUI.12(this));
      AppMethodBeat.o(68673);
      return;
      label226:
      this.Vcy.setVisibility(8);
      break;
      ((View)localObject).setVisibility(8);
    }
    label247:
    com.tencent.mm.plugin.wallet.model.p.ifO();
    if (com.tencent.mm.plugin.wallet.model.p.ifP().ijQ() == 1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      com.tencent.mm.plugin.wallet.model.p.ifO();
      localObject = com.tencent.mm.plugin.wallet.model.p.ifP().ijR();
      com.tencent.mm.plugin.wallet.model.p.ifO();
      String str = com.tencent.mm.plugin.wallet.model.p.ifP().ijS();
      Log.i("MicroMsg.WalletBalanceManagerUI", "isShowLqtCell:%s lqtCellTitle:%s lqtCellWording:%s", new Object[] { Boolean.valueOf(paramBoolean), localObject, str });
      if ((!paramBoolean) || ((Util.isNullOrNil((String)localObject)) && (Util.isNullOrNil(str)))) {
        break;
      }
      this.Vcz.setVisibility(8);
      AppMethodBeat.o(68673);
      return;
    }
    com.tencent.mm.plugin.wallet.model.p.ifO();
    if (com.tencent.mm.plugin.wallet.model.p.ifP().ijw())
    {
      com.tencent.mm.plugin.wallet.model.p.ifO();
      if (!Util.isNullOrNil(com.tencent.mm.plugin.wallet.model.p.ifP().ijs()))
      {
        this.Vcz.setVisibility(0);
        this.Vcz.setOnClickListener(new WalletBalanceManagerUI.13(this));
        localObject = this.VcA;
        com.tencent.mm.plugin.wallet.model.p.ifO();
        ((TextView)localObject).setText(com.tencent.mm.plugin.wallet.model.p.ifP().ijs());
        AppMethodBeat.o(68673);
        return;
      }
    }
    com.tencent.mm.plugin.wallet.model.p.ifO();
    localObject = com.tencent.mm.plugin.wallet.model.p.ifP();
    if ((localObject != null) && (((am)localObject).ijp().iiV()) && (!TextUtils.isEmpty(((am)localObject).ijs())) && (!TextUtils.isEmpty(((am)localObject).ijt())))
    {
      this.Vcz.setVisibility(0);
      this.VcA.setText(((am)localObject).ijs());
      this.Vcz.setOnClickListener(new WalletBalanceManagerUI.15(this, (am)localObject));
      AppMethodBeat.o(68673);
      return;
    }
    this.Vcz.setVisibility(8);
    AppMethodBeat.o(68673);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68664);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().add(this);
    setActionbarColor(getResources().getColor(a.c.white));
    hideActionbarLine();
    ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
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
    }, a.h.actionbar_icon_dark_back);
    this.mScene = getIntent().getIntExtra("key_scene_balance_manager", 0);
    paramBundle = ECardInfo.iij();
    if (paramBundle != null)
    {
      if (paramBundle.YAF != 1) {
        break label239;
      }
      paramBundle = new Bundle();
      isTransparent();
      com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramBundle, null, 0);
    }
    for (;;)
    {
      addSceneEndListener(621);
      u.iiJ();
      ag.a(this);
      initView();
      ac.pu(2, 0);
      com.tencent.mm.plugin.report.service.h.OAn.b(11850, new Object[] { Integer.valueOf(6), Integer.valueOf(0) });
      i.aGA(10);
      a(x.bl(XmlParser.parseXml((String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.acVp, ""), "sysmsg", null)));
      AppMethodBeat.o(68664);
      return;
      label239:
      if (paramBundle.YAF == 3)
      {
        paramBundle = ECardInfo.iik();
        if (paramBundle != null) {
          com.tencent.mm.plugin.wallet_core.ui.q.a(this, paramBundle, 1);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68667);
    removeSceneEndListener(621);
    u.iiJ();
    ag.b(this);
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().remove(this);
    if (this.VcI != null) {
      this.VcI.cancel();
    }
    this.VcI = null;
    super.onDestroy();
    AppMethodBeat.o(68667);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(68678);
    Log.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + paramIntent.getIntExtra("from_bind_ui", 0));
    if (paramIntent.getIntExtra("from_bind_ui", 0) == com.tencent.mm.plugin.wallet.balance.a.UZd)
    {
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
      i.aGA(15);
    }
    AppMethodBeat.o(68678);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(68679);
    if ((paramMStorageEx == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      Log.i("MicroMsg.WalletBalanceManagerUI", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        Hk(false);
      }
    }
    AppMethodBeat.o(68679);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68671);
    super.onPause();
    this.VcE.reset();
    AppMethodBeat.o(68671);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68670);
    Object localObject = new com.tencent.mm.plugin.wxpayreport.a.b(true, true, 300L, this.Vcy, 0, c.a.XJI.toString(), this, false, 0, 0);
    com.tencent.mm.plugin.wxpayreport.a.b localb = new com.tencent.mm.plugin.wxpayreport.a.b(true, true, 300L, this.uSO, 0, c.a.XJH.toString(), this, false, 0, 0);
    ((com.tencent.mm.wallet_core.ui.h)component(com.tencent.mm.wallet_core.ui.h.class)).addLifecycleReportEvent(j.b.XJc, (com.tencent.mm.plugin.wxpayreport.a.b)localObject);
    ((com.tencent.mm.wallet_core.ui.h)component(com.tencent.mm.wallet_core.ui.h.class)).addLifecycleReportEvent(j.b.XJc, localb);
    kD(true);
    ieQ();
    Log.i("MicroMsg.WalletBalanceManagerUI", "do query balance menu");
    if (this.VcI != null) {
      this.VcI.cancel();
    }
    this.VcI = new com.tencent.mm.plugin.wallet.balance.model.a();
    this.VcI.bFJ().b(new com.tencent.mm.vending.c.a() {});
    super.onResume();
    localObject = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class);
    ((com.tencent.mm.plugin.walletlock.a.b)localObject).a(this, ((com.tencent.mm.plugin.walletlock.a.b)localObject).imz(), null);
    AppMethodBeat.o(68670);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(68676);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (!(paramp instanceof com.tencent.mm.plugin.wallet.bind.a.b)) && ((paramp instanceof ae)))
    {
      this.VcH = ((ae)paramp).Vyj;
      if ((this.VcH == null) || (this.VcJ.isShown())) {
        break label138;
      }
      if (Util.isNullOrNil(this.VcH.wording)) {
        break label126;
      }
      this.VcC.setText(this.VcH.wording);
      this.VcB.setOnClickListener(new k()
      {
        public final void dr(final View paramAnonymousView)
        {
          AppMethodBeat.i(316359);
          Log.i("MicroMsg.WalletBalanceManagerUI", "click action entry");
          if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type == 1)
          {
            if (Util.isNullOrNil(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).VEG))
            {
              AppMethodBeat.o(316359);
              return;
            }
            if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).VEG.startsWith("weixin://wcpay/lqt/detail"))
            {
              com.tencent.mm.plugin.wallet.balance.model.lqt.ai.bfV(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).VEG);
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_account_type", 1);
              c.b(WalletBalanceManagerUI.this.getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramAnonymousView);
              AppMethodBeat.o(316359);
              return;
            }
            if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).VEG.startsWith("weixin://wcpay/lqt/save"))
            {
              com.tencent.mm.plugin.wallet.balance.model.lqt.ai.bfV(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).VEG);
              paramAnonymousView = com.tencent.mm.plugin.wallet.balance.model.lqt.ai.bfW(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).VEG);
              final Dialog localDialog = com.tencent.mm.wallet_core.ui.l.c(WalletBalanceManagerUI.this.getContext(), false, null);
              new com.tencent.mm.plugin.wallet.balance.model.lqt.p().bFJ().b(new com.tencent.mm.vending.c.a() {});
              AppMethodBeat.o(316359);
            }
          }
          else
          {
            if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type == 2)
            {
              i.o(WalletBalanceManagerUI.this.getContext(), WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).xmo, true);
              AppMethodBeat.o(316359);
              return;
            }
            if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type == 3)
            {
              i.y(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).VEH, WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).VEI, 0, 1061);
              AppMethodBeat.o(316359);
              return;
            }
            Log.w("MicroMsg.WalletBalanceManagerUI", "unknown type: %s", new Object[] { Integer.valueOf(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type) });
          }
          AppMethodBeat.o(316359);
        }
      });
      this.VcB.setVisibility(0);
    }
    for (;;)
    {
      kD(false);
      ieS();
      AppMethodBeat.o(68676);
      return false;
      label126:
      this.VcB.setVisibility(8);
      continue;
      label138:
      this.VcB.setVisibility(8);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(316393);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.wallet.a.a.class);
    AppMethodBeat.o(316393);
  }
  
  static final class a
  {
    public String VcU;
    public String VcV;
    public int jump_type;
    public String jump_url;
  }
  
  static final class b
  {
    public int VcW;
    public int color;
    public String wording;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI
 * JD-Core Version:    0.7.0.1
 */