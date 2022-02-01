package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
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
import com.tencent.mm.an.q;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.aba;
import com.tencent.mm.f.a.ma;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wallet_core.ui.p;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletBalanceManagerUI
  extends WalletBaseUI
  implements l, MStorageEx.IOnStorageChange
{
  private static final String EuI;
  private ProgressBar ESk;
  private IListener<ma> GCj;
  protected TextView OmT;
  protected Button OnI;
  protected View OnJ;
  protected TextView OnK;
  private ViewGroup OnL;
  private TextView OnM;
  private ImageView OnN;
  private WcPayMoneyLoadingView OnO;
  protected Bankcard OnP;
  private bh OnQ;
  private com.tencent.mm.plugin.wallet_core.model.h OnR;
  private com.tencent.mm.plugin.wallet.balance.model.a OnS;
  private ViewGroup OnT;
  private CdnImageView OnU;
  private TextView OnV;
  private CdnImageView OnW;
  private View OnX;
  private TextView OnY;
  protected int mScene;
  
  static
  {
    AppMethodBeat.i(270594);
    EuI = "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/scene_product.html?scene_id=kf4";
    AppMethodBeat.o(270594);
  }
  
  public WalletBalanceManagerUI()
  {
    AppMethodBeat.i(68663);
    this.GCj = new WalletBalanceManagerUI.7(this);
    AppMethodBeat.o(68663);
  }
  
  private void BF(boolean paramBoolean)
  {
    AppMethodBeat.i(68672);
    long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.VtM, Long.valueOf(0L))).longValue();
    WcPayMoneyLoadingView localWcPayMoneyLoadingView = this.OnO;
    String str = g.formatMoney2f(g.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue());
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localWcPayMoneyLoadingView.cV(str, paramBoolean);
      AppMethodBeat.o(68672);
      return;
    }
  }
  
  private void a(final x paramx)
  {
    AppMethodBeat.i(68665);
    if (paramx == null)
    {
      this.OnT.setVisibility(8);
      AppMethodBeat.o(68665);
      return;
    }
    label82:
    GradientDrawable localGradientDrawable;
    if (!Util.isNullOrNil(paramx.OTo))
    {
      this.OnU.setUrl(paramx.OTo);
      this.OnU.setVisibility(0);
      if (Util.isNullOrNil(paramx.OTp)) {
        break label257;
      }
      this.OnW.setUrl(paramx.OTp);
      this.OnW.setVisibility(0);
      this.OnV.setText(paramx.wording);
      if (!Util.isNullOrNil(paramx.OTl))
      {
        if (!ar.isDarkMode()) {
          break label269;
        }
        this.OnV.setTextColor(ar.iV(Util.getHex(paramx.OTl, -16777216)));
      }
      label128:
      this.OnV.setTextSize(1, paramx.OTm);
      if (!Util.isNullOrNil(paramx.bgColor))
      {
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(0);
        if (!ar.isDarkMode()) {
          break label288;
        }
        localGradientDrawable.setColor(ar.iV(Util.getHex(paramx.bgColor, -1)));
      }
    }
    for (;;)
    {
      localGradientDrawable.setCornerRadius(com.tencent.mm.ci.a.fromDPToPix(getContext(), 4));
      this.OnT.setBackground(localGradientDrawable);
      this.OnT.setVisibility(0);
      this.OnT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68655);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.WalletBalanceManagerUI", "click freeze layout");
          g.o(WalletBalanceManagerUI.this.getContext(), paramx.OTn, true);
          x.bgQ("");
          WalletBalanceManagerUI.b(WalletBalanceManagerUI.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68655);
        }
      });
      this.OnL.setVisibility(8);
      AppMethodBeat.o(68665);
      return;
      this.OnU.setVisibility(8);
      break;
      label257:
      this.OnW.setVisibility(8);
      break label82;
      label269:
      this.OnV.setTextColor(Util.getHex(paramx.OTl, -16777216));
      break label128;
      label288:
      localGradientDrawable.setColor(Util.getHex(paramx.bgColor, -1));
    }
  }
  
  private static boolean gFU()
  {
    AppMethodBeat.i(68675);
    s.gGL();
    boolean bool = s.gGM().gJY().gFU();
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
  
  protected void gFR()
  {
    AppMethodBeat.i(68666);
    s.gGL();
    if (s.gGM().OnP == null) {}
    for (boolean bool = true;; bool = false)
    {
      doSceneProgress(new ae(null, 10), bool);
      AppMethodBeat.o(68666);
      return;
    }
  }
  
  protected void gFS()
  {
    AppMethodBeat.i(68668);
    startActivity(WalletBalanceSaveUI.class);
    AppMethodBeat.o(68668);
  }
  
  protected final void gFT()
  {
    AppMethodBeat.i(163864);
    removeAllOptionMenu();
    Log.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
    Object localObject1;
    if (this.OnP != null)
    {
      s.gGL();
      s.gGM();
      if (!Util.isNullOrNil(this.OnP.ONG))
      {
        localObject1 = getString(a.i.wallet_balance_manager_option_detail);
        if (!Util.isNullOrNil(this.OnP.ONI))
        {
          Log.i("MicroMsg.WalletBalanceManagerUI", "entry_word：%s", new Object[] { this.OnP.ONI });
          localObject1 = this.OnP.ONI;
        }
        addTextOptionMenu(0, (String)localObject1, new WalletBalanceManagerUI.3(this), w.b.Wax);
      }
    }
    if ((this.OnY == null) || (this.OnX == null) || (isFinishing()) || (isDestroyed()))
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
        localObject1 = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.Vtb, null);
        if (Util.isNullOrNil((String)localObject1)) {
          break label648;
        }
        Object localObject2 = new JSONObject((String)localObject1);
        boolean bool1 = ((JSONObject)localObject2).optBoolean("is_exposure", false);
        this.OnY.setVisibility(8);
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
            locala.Ooe = ((JSONObject)localObject1).optString("mini_username");
            locala.Oof = ((JSONObject)localObject1).optString("mini_pagepath");
          }
          bool2 = bool1;
          if (!Util.isNullOrNil((String)localObject2))
          {
            localObject1 = new JSONObject((String)localObject2);
            localb.wording = ((JSONObject)localObject1).optString("wording");
            localb.color = ((JSONObject)localObject1).optInt("color", -1);
            localb.Oog = ((JSONObject)localObject1).optInt("dark_color", -1);
            bool2 = bool1;
          }
          if (!bool2) {
            break label619;
          }
          Log.i("MicroMsg.WalletBalanceManagerUI", "show Lqt ServceEntrance");
          g.azK(45);
          if (localb.wording != null) {
            this.OnY.setText(localb.wording);
          }
          if (ar.isDarkMode()) {
            continue;
          }
          if (localb.color != -1) {
            continue;
          }
          this.OnY.setTextColor(getResources().getColor(a.c.link_color));
          this.OnY.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(163862);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              switch (locala.jump_type)
              {
              default: 
                Log.i("MicroMsg.WalletBalanceManagerUI", "unknown entrance type");
              }
              for (;;)
              {
                g.azK(46);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(163862);
                return;
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("rawUrl", locala.jump_url);
                paramAnonymousView.putExtra("showShare", false);
                paramAnonymousView.putExtra("geta8key_username", z.bcZ());
                paramAnonymousView.putExtra(f.r.VSX, true);
                g.aJ(WalletBalanceManagerUI.this.getContext(), paramAnonymousView);
                continue;
                paramAnonymousView = new xw();
                paramAnonymousView.fWN.userName = locala.Ooe;
                paramAnonymousView.fWN.fWP = locala.Oof;
                paramAnonymousView.fWN.scene = 1034;
                paramAnonymousView.fWN.fWQ = 0;
                EventCenter.instance.publish(paramAnonymousView);
                continue;
                if (locala.jump_url.equals("wxpay://lqp/balanceQuotaState"))
                {
                  paramAnonymousView = new Intent();
                  c.b(WalletBalanceManagerUI.this.getContext(), "wallet_ecard", ".ui.WalletECardLogoutUI", paramAnonymousView);
                }
              }
            }
          });
          this.OnY.setVisibility(0);
          g.N(this.OnY);
          if (isOverseasUser()) {
            continue;
          }
          this.OnX.setVisibility(0);
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
        this.OnY.setTextColor(localb.color);
        continue;
        if (localb.Oog == -1)
        {
          this.OnY.setTextColor(getResources().getColor(a.c.link_color));
          continue;
        }
        this.OnY.setTextColor(localb.Oog);
        continue;
        this.OnX.setVisibility(8);
        AppMethodBeat.o(163864);
        return;
      }
      label619:
      this.OnX.setVisibility(8);
      AppMethodBeat.o(163864);
      return;
      label648:
      boolean bool2 = false;
    }
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_balance_manager_ui;
  }
  
  public final void i(int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(68677);
    if ((paramInt != 12) && (paramInt == 43) && (paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      a((x)paramArrayOfObject[0]);
    }
    AppMethodBeat.o(68677);
  }
  
  public void initView()
  {
    AppMethodBeat.i(68669);
    setMMTitle("");
    this.OnO = ((WcPayMoneyLoadingView)findViewById(a.f.wallet_balance_view));
    this.ESk = ((ProgressBar)findViewById(a.f.wallet_money_load_pb));
    this.OmT = ((TextView)findViewById(a.f.wallet_balance_manager_banner));
    this.OnO.setLoadingPb(this.ESk);
    this.OnO.setPrefixSymbol(getString(a.i.wallet_rmb_symbol));
    getLifecycle().a(this.OnO);
    ((Button)findViewById(a.f.next_btn)).setOnClickListener(new WalletBalanceManagerUI.11(this));
    this.OnI = ((Button)findViewById(a.f.wallet_balance_manager_fetch_btn));
    this.OnI.setOnClickListener(new WalletBalanceManagerUI.12(this));
    this.OnX = findViewById(a.f.wallet_balance_manager_margin_line);
    this.OnY = ((TextView)findViewById(a.f.wallet_balance_manager_account_update_service));
    Object localObject = (TextView)findViewById(a.f.wallet_balance_manager_qanda);
    if (!isOverseasUser())
    {
      ((TextView)localObject).setOnClickListener(new WalletBalanceManagerUI.13(this));
      ((TextView)localObject).setVisibility(0);
      g.N((TextView)localObject);
    }
    for (;;)
    {
      ((TextView)findViewById(a.f.wallet_support_info)).setText(ah.ija());
      this.OnL = ((ViewGroup)findViewById(a.f.balance_action_layout));
      this.OnM = ((TextView)findViewById(a.f.balance_action_tv));
      this.OnN = ((ImageView)findViewById(a.f.balance_action_iv));
      this.OnJ = findViewById(a.f.licaitong_layout);
      this.OnK = ((TextView)findViewById(a.f.licaitong_tips));
      this.OnT = ((ViewGroup)findViewById(a.f.balance_freeze_layout));
      this.OnV = ((TextView)findViewById(a.f.balance_freeze_desc_tv));
      this.OnU = ((CdnImageView)findViewById(a.f.balance_freeze_icon_iv));
      this.OnW = ((CdnImageView)findViewById(a.f.balance_freeze_arrow_iv));
      localObject = new aba();
      ((aba)localObject).gac.scene = "2";
      ((aba)localObject).callback = new WalletBalanceManagerUI.14(this, (aba)localObject);
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(68669);
      return;
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  protected final void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(68673);
    BF(paramBoolean);
    s.gGL();
    this.OnP = s.gGM().OnP;
    if (this.OnP != null)
    {
      if (!gFU()) {
        break label226;
      }
      this.OnI.setVisibility(0);
      if (((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.VtM, Long.valueOf(0L))).longValue() <= 0L) {
        this.OnI.setEnabled(false);
      }
    }
    Object localObject = findViewById(a.f.lqt_red_dot);
    com.tencent.mm.kernel.h.aHH();
    if (((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VqW, Integer.valueOf(-1))).intValue() == 1) {
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (!new am().gJM()) {
        break label247;
      }
      com.tencent.mm.kernel.h.aHH();
      localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vly, getString(a.i.realname_mgr_title));
      this.OnJ.setVisibility(0);
      this.OnK.setTextColor(getResources().getColor(a.c.wallet_balance_manager_realname_tip));
      this.OnK.setText((CharSequence)localObject);
      this.OnJ.setOnClickListener(new WalletBalanceManagerUI.15(this));
      AppMethodBeat.o(68673);
      return;
      label226:
      this.OnI.setVisibility(8);
      break;
      ((View)localObject).setVisibility(8);
    }
    label247:
    s.gGL();
    if (s.gGM().gKy() == 1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      s.gGL();
      localObject = s.gGM().gKz();
      s.gGL();
      String str = s.gGM().gKA();
      Log.i("MicroMsg.WalletBalanceManagerUI", "isShowLqtCell:%s lqtCellTitle:%s lqtCellWording:%s", new Object[] { Boolean.valueOf(paramBoolean), localObject, str });
      if ((!paramBoolean) || ((Util.isNullOrNil((String)localObject)) && (Util.isNullOrNil(str)))) {
        break;
      }
      this.OnJ.setVisibility(8);
      AppMethodBeat.o(68673);
      return;
    }
    s.gGL();
    if (s.gGM().gKf())
    {
      s.gGL();
      if (!Util.isNullOrNil(s.gGM().gKb()))
      {
        this.OnJ.setVisibility(0);
        this.OnJ.setOnClickListener(new WalletBalanceManagerUI.16(this));
        localObject = this.OnK;
        s.gGL();
        ((TextView)localObject).setText(s.gGM().gKb());
        AppMethodBeat.o(68673);
        return;
      }
    }
    s.gGL();
    localObject = s.gGM();
    if ((localObject != null) && (((com.tencent.mm.plugin.wallet_core.model.ao)localObject).gJY().gJH()) && (!TextUtils.isEmpty(((com.tencent.mm.plugin.wallet_core.model.ao)localObject).gKb())) && (!TextUtils.isEmpty(((com.tencent.mm.plugin.wallet_core.model.ao)localObject).gKc())))
    {
      this.OnJ.setVisibility(0);
      this.OnK.setText(((com.tencent.mm.plugin.wallet_core.model.ao)localObject).gKb());
      this.OnJ.setOnClickListener(new WalletBalanceManagerUI.2(this, (com.tencent.mm.plugin.wallet_core.model.ao)localObject));
      AppMethodBeat.o(68673);
      return;
    }
    this.OnJ.setVisibility(8);
    AppMethodBeat.o(68673);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68664);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().add(this);
    setActionbarColor(getResources().getColor(a.c.white));
    hideActionbarLine();
    ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
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
    paramBundle = ECardInfo.gIV();
    if (paramBundle != null)
    {
      if (paramBundle.REc != 1) {
        break label239;
      }
      paramBundle = new Bundle();
      isTransparent();
      com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramBundle, null, 0);
    }
    for (;;)
    {
      addSceneEndListener(621);
      u.gJv();
      ai.a(this);
      initView();
      ab.ny(2, 0);
      com.tencent.mm.plugin.report.service.h.IzE.a(11850, new Object[] { Integer.valueOf(6), Integer.valueOf(0) });
      g.azK(10);
      a(x.aU(XmlParser.parseXml((String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.VtK, ""), "sysmsg", null)));
      AppMethodBeat.o(68664);
      return;
      label239:
      if (paramBundle.REc == 3)
      {
        paramBundle = ECardInfo.gIW();
        if (paramBundle != null) {
          p.a(this, paramBundle, 1);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68667);
    removeSceneEndListener(621);
    u.gJv();
    ai.b(this);
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().remove(this);
    if (this.OnS != null) {
      this.OnS.cancel();
    }
    this.OnS = null;
    super.onDestroy();
    AppMethodBeat.o(68667);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(68678);
    Log.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + paramIntent.getIntExtra("from_bind_ui", 0));
    if (paramIntent.getIntExtra("from_bind_ui", 0) == com.tencent.mm.plugin.wallet.balance.a.OkA)
    {
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
      g.azK(15);
    }
    AppMethodBeat.o(68678);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(68679);
    if ((paramMStorageEx == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      Log.i("MicroMsg.WalletBalanceManagerUI", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        BF(false);
      }
    }
    AppMethodBeat.o(68679);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68671);
    super.onPause();
    this.OnO.reset();
    AppMethodBeat.o(68671);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68670);
    jq(true);
    gFR();
    Log.i("MicroMsg.WalletBalanceManagerUI", "do query balance menu");
    if (this.OnS != null) {
      this.OnS.cancel();
    }
    this.OnS = new com.tencent.mm.plugin.wallet.balance.model.a();
    this.OnS.bhW().b(new WalletBalanceManagerUI.10(this));
    super.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.gNk(), null);
    AppMethodBeat.o(68670);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(68676);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (!(paramq instanceof com.tencent.mm.plugin.wallet.bind.a.b)) && ((paramq instanceof ae)))
    {
      this.OnR = ((ae)paramq).OIx;
      if ((this.OnR == null) || (this.OnT.isShown())) {
        break label191;
      }
      if (Util.isNullOrNil(this.OnR.wording)) {
        break label179;
      }
      this.OnM.setText(this.OnR.wording);
      if (!Util.isNullOrNil(this.OnR.lmL))
      {
        this.OnM.setTextColor(Color.parseColor(this.OnR.lmL));
        this.OnN.getDrawable().setColorFilter(Color.parseColor(this.OnR.lmL), PorterDuff.Mode.SRC_ATOP);
      }
      this.OnL.setOnClickListener(new WalletBalanceManagerUI.4(this));
      this.OnL.setVisibility(0);
    }
    for (;;)
    {
      jq(false);
      gFT();
      AppMethodBeat.o(68676);
      return false;
      label179:
      this.OnL.setVisibility(8);
      continue;
      label191:
      this.OnL.setVisibility(8);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    public String Ooe;
    public String Oof;
    public int jump_type;
    public String jump_url;
  }
  
  static final class b
  {
    public int Oog;
    public int color;
    public String wording;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI
 * JD-Core Version:    0.7.0.1
 */