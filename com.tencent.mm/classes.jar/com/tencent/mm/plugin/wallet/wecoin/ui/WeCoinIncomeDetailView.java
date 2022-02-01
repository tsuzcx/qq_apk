package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.k;
import androidx.lifecycle.r;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.wallet.wecoin.c.c;
import com.tencent.mm.plugin.wallet.wecoin.c.c.d;
import com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData;
import com.tencent.mm.plugin.wallet.wecoin.model.i;
import com.tencent.mm.plugin.wallet.wecoin.model.i.b;
import com.tencent.mm.plugin.wallet.wecoin.model.i.c;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.protocal.protobuf.dti;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.ui.g;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "mActionGroup", "Landroid/view/View;", "mBalanceView", "Lcom/tencent/mm/plugin/wallet_core/ui/view/WcPayMoneyLoadingView;", "mFaqTv", "Landroid/widget/TextView;", "mFetchBtn", "Landroid/widget/Button;", "mIncomeBalanceLL", "Landroid/widget/LinearLayout;", "mLiveSettlementDesc", "mLiveSettlementTv", "mLiveTaskArrow", "Landroid/widget/ImageView;", "mLiveTaskLayout", "mLiveTaskTv", "mMarginLine", "mMoneyLoadingPb", "Landroid/widget/ProgressBar;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mViewModel", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinIncomeDetailViewModel;", "bindData", "", "getLayoutId", "", "gotoIncomeBalanceView", "initKVData", "initLiveSettlement", "initLiveTaskEntrance", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "openRealNameAuth", "info", "Lcom/tencent/mm/protocal/protobuf/RealNameAuthInfo;", "showAlertDialog", "showErrorMsg", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "showProgressDialog", "isShow", "", "(Ljava/lang/Boolean;)V", "updateAuthored", "authored", "updateClickButtonEvent", "updateFaqView", "url", "", "updateIncomeBalanceView", "balance", "", "(Ljava/lang/Long;)V", "updateRightOptionMenu", "updateTopBannerView", "bannerContent", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "Companion", "plugin-wxpay_release"})
public final class WeCoinIncomeDetailView
  extends MMActivity
{
  public static final WeCoinIncomeDetailView.a OHd;
  private ProgressBar ESk;
  private LinearLayout OGT;
  private i OGU;
  private TextView OGV;
  private TextView OGW;
  private View OGX;
  private ImageView OGY;
  private View OGZ;
  private TextView OHa;
  private TextView OHb;
  private View OHc;
  private Button OnI;
  private WcPayMoneyLoadingView OnO;
  private com.tencent.mm.ui.base.s jhZ;
  
  static
  {
    AppMethodBeat.i(273640);
    OHd = new WeCoinIncomeDetailView.a((byte)0);
    AppMethodBeat.o(273640);
  }
  
  private final void gIn()
  {
    AppMethodBeat.i(273639);
    Log.d("MicroMsg.WeCoinIncomeDetailView", "gotoIncomeBalanceView: ");
    Object localObject1 = new Intent((Context)getContext(), WeCoinEncashView.class);
    Object localObject2 = this.OGU;
    if (localObject2 == null) {
      p.bGy("mViewModel");
    }
    localObject2 = (Long)((LiveData)((i)localObject2).OFr).getValue();
    if (localObject2 != null) {
      ((Intent)localObject1).putExtra("wecoin_income_balance", ((Number)localObject2).longValue());
    }
    localObject2 = this.OGU;
    if (localObject2 == null) {
      p.bGy("mViewModel");
    }
    ((Intent)localObject1).putExtra("wecoin_enter_encash_business_kv_data", (Parcelable)((i)localObject2).OFi);
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "gotoIncomeBalanceView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "gotoIncomeBalanceView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(273639);
  }
  
  private final void o(Long paramLong)
  {
    AppMethodBeat.i(273637);
    if (paramLong != null)
    {
      paramLong = g.formatMoney2f(g.b(String.valueOf(((Number)paramLong).longValue()), "100", 2, RoundingMode.HALF_UP).doubleValue());
      WcPayMoneyLoadingView localWcPayMoneyLoadingView = this.OnO;
      if (localWcPayMoneyLoadingView == null) {
        p.bGy("mBalanceView");
      }
      localWcPayMoneyLoadingView.cV(paramLong, false);
      AppMethodBeat.o(273637);
      return;
    }
    AppMethodBeat.o(273637);
  }
  
  public final int getLayoutId()
  {
    return a.g.activity_we_coin_income_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(273636);
    setActionbarColor(getResources().getColor(a.c.white));
    hideActionbarLine();
    setMMTitle("");
    Object localObject1 = findViewById(a.f.wallet_balance_view);
    p.j(localObject1, "findViewById(R.id.wallet_balance_view)");
    this.OnO = ((WcPayMoneyLoadingView)localObject1);
    localObject1 = findViewById(a.f.wallet_money_load_pb);
    p.j(localObject1, "findViewById(R.id.wallet_money_load_pb)");
    this.ESk = ((ProgressBar)localObject1);
    localObject1 = findViewById(a.f.wecoin_income_banner_ll);
    p.j(localObject1, "findViewById(R.id.wecoin_income_banner_ll)");
    this.OGT = ((LinearLayout)localObject1);
    this.OGW = ((TextView)findViewById(a.f.balance_action_tv));
    this.OGX = findViewById(a.f.balance_action_layout);
    this.OGY = ((ImageView)findViewById(a.f.balance_action_iv));
    this.OGZ = findViewById(a.f.wallet_balance_manager_margin_line);
    this.OHb = ((TextView)findViewById(a.f.live_settlement_desc_tv));
    this.OHa = ((TextView)findViewById(a.f.wallet_balance_manager_settlement));
    this.OHc = findViewById(a.f.action_group);
    localObject1 = this.OnO;
    if (localObject1 == null) {
      p.bGy("mBalanceView");
    }
    Object localObject2 = this.ESk;
    if (localObject2 == null) {
      p.bGy("mMoneyLoadingPb");
    }
    ((WcPayMoneyLoadingView)localObject1).setLoadingPb((ProgressBar)localObject2);
    localObject1 = this.OnO;
    if (localObject1 == null) {
      p.bGy("mBalanceView");
    }
    ((WcPayMoneyLoadingView)localObject1).setPrefixSymbol(getString(a.i.wallet_rmb_symbol));
    localObject1 = getLifecycle();
    localObject2 = this.OnO;
    if (localObject2 == null) {
      p.bGy("mBalanceView");
    }
    ((androidx.lifecycle.h)localObject1).a((k)localObject2);
    localObject1 = findViewById(a.f.wallet_balance_manager_fetch_btn);
    p.j(localObject1, "findViewById(R.id.wallet…alance_manager_fetch_btn)");
    this.OnI = ((Button)localObject1);
    localObject1 = findViewById(a.f.wallet_balance_manager_qanda);
    p.j(localObject1, "findViewById(R.id.wallet_balance_manager_qanda)");
    this.OGV = ((TextView)localObject1);
    ((WeImageView)findViewById(a.f.wecoin_income_help_tips)).setOnClickListener((View.OnClickListener)new WeCoinIncomeDetailView.l(this));
    localObject1 = this.OGV;
    if (localObject1 == null) {
      p.bGy("mFaqTv");
    }
    ar.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    localObject1 = this.OHa;
    label593:
    label614:
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((TextView)localObject1).getPaint();
      ar.a((Paint)localObject1, 0.8F);
      setBackBtn((MenuItem.OnMenuItemClickListener)new m(this), a.h.actionbar_icon_dark_back);
      o(Long.valueOf(0L));
      localObject1 = (com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class);
      if ((localObject1 == null) || (((com.tencent.c.a.a.a.b)localObject1).isLiveTaskEnable("Entrance_CoinFetchMoney") != true)) {
        break label864;
      }
      localObject1 = this.OGX;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = this.OGW;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)getContext().getString(a.i.wallet_live_task_tips));
      }
      localObject1 = this.OGX;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new WeCoinIncomeDetailView.k(this));
      }
      localObject1 = this.OGY;
      if (localObject1 != null)
      {
        localObject1 = ((ImageView)localObject1).getDrawable();
        if (localObject1 != null) {
          ((Drawable)localObject1).setColorFilter(getResources().getColor(a.c.Orange), PorterDuff.Mode.SRC_ATOP);
        }
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(22748, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Long.valueOf(cm.bfE()), com.tencent.mm.model.z.bdh() });
      localObject1 = (com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class);
      if (localObject1 == null) {
        break label882;
      }
      localObject2 = ((com.tencent.c.a.a.a.b)localObject1).getLiveSettlementInfo();
      localObject3 = new StringBuilder("settlementEnable:");
      if (localObject2 == null) {
        break label887;
      }
      localObject1 = Boolean.valueOf(((bco)localObject2).enable);
      label637:
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", url:");
      if (localObject2 == null) {
        break label892;
      }
      localObject1 = ((bco)localObject2).jDP;
      label658:
      localObject3 = ((StringBuilder)localObject3).append((String)localObject1).append(", tip:");
      if (localObject2 == null) {
        break label897;
      }
      localObject1 = ((bco)localObject2).SNP;
      label679:
      Log.i("MicroMsg.WeCoinIncomeDetailView", (String)localObject1);
      if ((localObject2 == null) || (((bco)localObject2).enable != true)) {
        break label1016;
      }
      localObject1 = this.OGZ;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = this.OHa;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.OHa;
      if (localObject1 != null) {
        ((TextView)localObject1).setOnClickListener((View.OnClickListener)new WeCoinIncomeDetailView.j(this, (bco)localObject2));
      }
      if (Util.isNullOrNil(((bco)localObject2).SNP)) {
        break label914;
      }
      localObject1 = this.OHc;
      if (localObject1 == null) {
        break label902;
      }
    }
    label897:
    label902:
    for (localObject1 = ((View)localObject1).getLayoutParams();; localObject1 = null)
    {
      localObject3 = localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        localObject3 = null;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject3;
      if (localObject1 != null) {
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = aw.fromDPToPix((Context)getContext(), 48);
      }
      localObject1 = this.OHb;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.OHb;
      if (localObject1 == null) {
        break label907;
      }
      ((TextView)localObject1).setText((CharSequence)((bco)localObject2).SNP);
      AppMethodBeat.o(273636);
      return;
      localObject1 = null;
      break;
      label864:
      localObject1 = this.OGX;
      if (localObject1 == null) {
        break label593;
      }
      ((View)localObject1).setVisibility(8);
      break label593;
      label882:
      localObject2 = null;
      break label614;
      label887:
      localObject1 = null;
      break label637;
      label892:
      localObject1 = null;
      break label658;
      localObject1 = null;
      break label679;
    }
    label907:
    AppMethodBeat.o(273636);
    return;
    label914:
    localObject1 = this.OHc;
    if (localObject1 != null) {}
    for (localObject1 = ((View)localObject1).getLayoutParams();; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        localObject2 = null;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
      if (localObject1 != null) {
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = aw.fromDPToPix((Context)getContext(), 64);
      }
      localObject1 = this.OHb;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = this.OHb;
      if (localObject1 == null) {
        break;
      }
      ((TextView)localObject1).setText((CharSequence)"");
      AppMethodBeat.o(273636);
      return;
    }
    AppMethodBeat.o(273636);
    return;
    label1016:
    localObject1 = this.OHc;
    if (localObject1 != null) {}
    for (localObject1 = ((View)localObject1).getLayoutParams();; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        localObject2 = null;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
      if (localObject1 != null) {
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = aw.fromDPToPix((Context)getContext(), 64);
      }
      localObject1 = this.OGZ;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = this.OHa;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = this.OHb;
      if (localObject1 == null) {
        break;
      }
      ((TextView)localObject1).setVisibility(8);
      AppMethodBeat.o(273636);
      return;
    }
    AppMethodBeat.o(273636);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(273638);
    Log.d("MicroMsg.WeCoinIncomeDetailView", "onActivityResult() requestCode:%d resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 2001)
    {
      AppMethodBeat.o(273638);
      return;
    }
    if (paramInt2 == -1)
    {
      Object localObject;
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("intent_auth_token");
        localObject = (CharSequence)paramIntent;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label223;
        }
      }
      label223:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label228;
        }
        localObject = this.OGU;
        if (localObject == null) {
          p.bGy("mViewModel");
        }
        com.tencent.mm.vending.e.b localb = (com.tencent.mm.vending.e.b)this;
        p.k(paramIntent, "token");
        p.k(localb, "keeper");
        com.tencent.mm.plugin.wallet.wecoin.c.a.a(((i)localObject).tEN, Boolean.TRUE);
        String str = UUID.randomUUID().toString();
        p.j(str, "uuid.toString()");
        ((i)localObject).a(str, 10, 1, 0, "");
        new com.tencent.mm.plugin.wallet.wecoin.b.f(paramIntent, str).bhW().b((com.tencent.mm.vending.c.a)new i.c((i)localObject, str)).a(localb);
        AppMethodBeat.o(273638);
        return;
        paramIntent = null;
        break;
      }
    }
    label228:
    paramIntent = this.OGU;
    if (paramIntent == null) {
      p.bGy("mViewModel");
    }
    paramIntent.amu(19);
    AppMethodBeat.o(273638);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(273633);
    i locali = this.OGU;
    if (locali == null) {
      p.bGy("mViewModel");
    }
    locali.amu(10);
    super.onBackPressed();
    AppMethodBeat.o(273633);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(273630);
    super.onCreate(paramBundle);
    initView();
    paramBundle = androidx.lifecycle.z.a((FragmentActivity)this).i(i.class);
    p.j(paramBundle, "ViewModelProviders.of(th…ailViewModel::class.java)");
    this.OGU = ((i)paramBundle);
    paramBundle = this.OGU;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OFp).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new b(this));
    paramBundle = this.OGU;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OFr).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new c(this));
    paramBundle = this.OGU;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OFq).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new d(this));
    paramBundle = this.OGU;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OFs).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new e(this));
    paramBundle = this.OGU;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OEM).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new f(this));
    paramBundle = this.OGU;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OFu).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new g(this));
    paramBundle = this.OGU;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OFt).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new h(this));
    paramBundle = this.OGU;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.tEN).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new i(this));
    paramBundle = this.OGU;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    Object localObject = (WecoinEncashKVData)getIntent().getParcelableExtra("wecoin_enter_encash_business_kv_data");
    if (localObject != null) {
      paramBundle.OFi = new WecoinEncashKVData(((WecoinEncashKVData)localObject).OFV, ((WecoinEncashKVData)localObject).OEG, c.gIi());
    }
    paramBundle = this.OGU;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    localObject = c.gIs();
    if (localObject != null)
    {
      paramBundle.OFp.L(((bwm)localObject).Tgj);
      paramBundle.OFq.L(((bwm)localObject).Tgk);
      paramBundle.OFr.L(Long.valueOf(((bwm)localObject).Tgi));
      paramBundle.OFs.L(((bwm)localObject).Tgm);
      paramBundle.OFt.L(((bwm)localObject).Tgl);
      paramBundle.OFv = ((bwm)localObject);
      AppMethodBeat.o(273630);
      return;
    }
    AppMethodBeat.o(273630);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(273632);
    super.onDestroy();
    Object localObject = this.OGU;
    if (localObject == null) {
      p.bGy("mViewModel");
    }
    localObject = ((i)localObject).OFv;
    if (localObject != null)
    {
      p.k(localObject, "response");
      Log.d("MicroMsg.WeCoinUtils", "save WecoinIncomePageInfoResponse snapshot");
      d.h((kotlin.g.a.a)new c.d((bwm)localObject));
      AppMethodBeat.o(273632);
      return;
    }
    AppMethodBeat.o(273632);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(273631);
    super.onResume();
    i locali = this.OGU;
    if (locali == null) {
      p.bGy("mViewModel");
    }
    com.tencent.mm.vending.e.b localb = (com.tencent.mm.vending.e.b)this;
    p.k(localb, "keeper");
    locali.a("", 9, 1, 0, "");
    new com.tencent.mm.plugin.wallet.wecoin.b.h().bhW().b((com.tencent.mm.vending.c.a)new i.b(locali)).a(localb);
    AppMethodBeat.o(273631);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"})
  static final class b<T>
    implements androidx.lifecycle.s<String>
  {
    b(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Long;)V"})
  static final class c<T>
    implements androidx.lifecycle.s<Long>
  {
    c(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"})
  static final class d<T>
    implements androidx.lifecycle.s<String>
  {
    d(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/RealNameAuthInfo;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class e<T>
    implements androidx.lifecycle.s<dti>
  {
    e(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class f<T>
    implements androidx.lifecycle.s<com.tencent.mm.plugin.wallet.wecoin.model.a>
  {
    f(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"})
  static final class g<T>
    implements androidx.lifecycle.s<Boolean>
  {
    g(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class h<T>
    implements androidx.lifecycle.s<abx>
  {
    h(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"})
  static final class i<T>
    implements androidx.lifecycle.s<Boolean>
  {
    i(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class m
    implements MenuItem.OnMenuItemClickListener
  {
    m(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(205391);
      WeCoinIncomeDetailView.b(this.OHe).amu(10);
      this.OHe.finish();
      AppMethodBeat.o(205391);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, dti paramdti) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(253346);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateClickButtonEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      WeCoinIncomeDetailView.b(this.OHe).amu(2);
      paramView = this.OHh;
      if ((paramView != null) && (paramView.status == 1))
      {
        WeCoinIncomeDetailView.b(this.OHe).amu(11);
        WeCoinIncomeDetailView.a(this.OHe, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateClickButtonEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(253346);
        return;
      }
      WeCoinIncomeDetailView.d(this.OHe);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateClickButtonEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(253346);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateFaqView$1$1"})
  static final class p
    implements View.OnClickListener
  {
    p(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202697);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateFaqView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      WeCoinIncomeDetailView.b(this.OHe).amu(7);
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.sPR);
      paramView.putExtra("showShare", false);
      paramView.putExtra(f.r.VSX, true);
      g.aJ((Context)this.OHe.getContext(), paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateFaqView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202697);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateRightOptionMenu$1$1"})
  static final class q
    implements MenuItem.OnMenuItemClickListener
  {
    q(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, String paramString) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(208351);
      WeCoinIncomeDetailView.b(this.OHe).amu(3);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("rawUrl", this.sPR);
      paramMenuItem.putExtra("showShare", false);
      paramMenuItem.putExtra(f.r.VSX, true);
      g.aJ((Context)this.OHe.getContext(), paramMenuItem);
      AppMethodBeat.o(208351);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateTopBannerView$1$1"})
  static final class r
    implements View.OnClickListener
  {
    r(abx paramabx, WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(274050);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateTopBannerView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      WeCoinIncomeDetailView.b(this.OHe).amu(9);
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.OHi.url);
      g.aJ((Context)this.OHe, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateTopBannerView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(274050);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinIncomeDetailView
 * JD-Core Version:    0.7.0.1
 */