package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.wallet.wecoin.a.e;
import com.tencent.mm.plugin.wallet.wecoin.b.i;
import com.tencent.mm.plugin.wallet.wecoin.c.c;
import com.tencent.mm.plugin.wallet.wecoin.c.c.e;
import com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData;
import com.tencent.mm.plugin.wallet.wecoin.model.k.a;
import com.tencent.mm.plugin.wallet.wecoin.model.l.b;
import com.tencent.mm.plugin.wallet.wecoin.model.l.c;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.cgj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "mBalanceView", "Lcom/tencent/mm/plugin/wallet_core/ui/view/WcPayMoneyLoadingView;", "mBannerView", "Landroid/view/View;", "mFaqLinearLayout", "Landroid/widget/LinearLayout;", "mFaqTv", "Landroid/widget/TextView;", "mMoneyLoadingPb", "Landroid/widget/ProgressBar;", "mNoBalanceTipsTv", "mSwitchDeviceTipsView", "mTotalBalanceLl", "mTutorialClickLl", "mTutorialClickTv", "mViewModel", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinRechargeViewModel;", "mWeCoinBalanceView", "mWeCoinRechargeButton", "Landroid/widget/Button;", "bindData", "", "getLayoutId", "", "initView", "loadCacheData", "loadData", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "showDeviceSwitchTips", "hasShow", "", "(Ljava/lang/Boolean;)V", "showErrorMsg", "info", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "showGridBottomSheet", "showTutorialDialog", "updateFaqView", "url", "", "updateIncomeBalance", "balance", "Lcom/tencent/mm/plugin/wallet/wecoin/model/UserIncomeDetailData;", "updateMainContentView", "updateRechargeButtonState", "midasInitialized", "updateRightOptionMenu", "updateTopBannerView", "bannerContent", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "updateTotalBalance", "", "(Ljava/lang/Long;)V", "Companion", "plugin-wxpay_release"})
public final class WeCoinRechargeView
  extends MMActivity
{
  public static final WeCoinRechargeView.a OHt;
  private ProgressBar ESk;
  private TextView OGV;
  private com.tencent.mm.plugin.wallet.wecoin.model.l OHj;
  private LinearLayout OHk;
  private TextView OHl;
  private View OHm;
  private LinearLayout OHn;
  private LinearLayout OHo;
  private TextView OHp;
  private TextView OHq;
  private Button OHr;
  private TextView OHs;
  private WcPayMoneyLoadingView OnO;
  
  static
  {
    AppMethodBeat.i(202627);
    OHt = new WeCoinRechargeView.a((byte)0);
    AppMethodBeat.o(202627);
  }
  
  private final void v(Boolean paramBoolean)
  {
    AppMethodBeat.i(202625);
    Button localButton = this.OHr;
    if (localButton == null) {
      p.bGy("mWeCoinRechargeButton");
    }
    localButton.setEnabled(false);
    if (paramBoolean != null)
    {
      if (paramBoolean.booleanValue())
      {
        paramBoolean = this.OHr;
        if (paramBoolean == null) {
          p.bGy("mWeCoinRechargeButton");
        }
        paramBoolean.setEnabled(true);
        paramBoolean = this.OHr;
        if (paramBoolean == null) {
          p.bGy("mWeCoinRechargeButton");
        }
        paramBoolean.setOnClickListener((View.OnClickListener)new p(this));
      }
      AppMethodBeat.o(202625);
      return;
    }
    AppMethodBeat.o(202625);
  }
  
  public final int getLayoutId()
  {
    return a.g.activity_we_coin_recharge_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(202621);
    setContentViewVisibility(0);
    setActionbarColor(getResources().getColor(a.c.UN_Brand_BG_100));
    Object localObject1 = findViewById(a.f.wecoin_balance_account_ll);
    p.j(localObject1, "findViewById(R.id.wecoin_balance_account_ll)");
    this.OHk = ((LinearLayout)localObject1);
    localObject1 = findViewById(a.f.we_coin_no_balance_tips_tv);
    p.j(localObject1, "findViewById(R.id.we_coin_no_balance_tips_tv)");
    this.OHl = ((TextView)localObject1);
    localObject1 = findViewById(a.f.wecoin_recharge_banner_ll);
    p.j(localObject1, "findViewById(R.id.wecoin_recharge_banner_ll)");
    this.OHm = ((View)localObject1);
    localObject1 = findViewById(a.f.we_coin_balance_tv);
    p.j(localObject1, "findViewById(R.id.we_coin_balance_tv)");
    this.OHq = ((TextView)localObject1);
    localObject1 = findViewById(a.f.wecoin_switch_device_tips);
    p.j(localObject1, "findViewById(R.id.wecoin_switch_device_tips)");
    this.OHs = ((TextView)localObject1);
    localObject1 = com.tencent.mm.wallet_core.ui.g.azI(0);
    try
    {
      localObject2 = this.OHq;
      if (localObject2 == null) {
        p.bGy("mWeCoinBalanceView");
      }
      AppCompatActivity localAppCompatActivity = getContext();
      p.j(localAppCompatActivity, "context");
      ((TextView)localObject2).setTypeface(Typeface.createFromAsset(localAppCompatActivity.getAssets(), (String)localObject1));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        Log.e("MicroMsg.WeCoinRechargeView", "setTypeface() Exception:%s", new Object[] { localException.getMessage() });
      }
    }
    localObject1 = findViewById(a.f.wallet_balance_view);
    p.j(localObject1, "findViewById(R.id.wallet_balance_view)");
    this.OnO = ((WcPayMoneyLoadingView)localObject1);
    localObject1 = findViewById(a.f.wallet_money_load_pb);
    p.j(localObject1, "findViewById(R.id.wallet_money_load_pb)");
    this.ESk = ((ProgressBar)localObject1);
    localObject1 = this.OnO;
    if (localObject1 == null) {
      p.bGy("mBalanceView");
    }
    localObject2 = this.ESk;
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
    ((androidx.lifecycle.h)localObject1).a((androidx.lifecycle.k)localObject2);
    localObject1 = findViewById(a.f.wecoin_detail_faq_link_ll);
    p.j(localObject1, "findViewById(R.id.wecoin_detail_faq_link_ll)");
    this.OHn = ((LinearLayout)localObject1);
    localObject1 = findViewById(a.f.wecoin_detail_faq_link_tv);
    p.j(localObject1, "findViewById(R.id.wecoin_detail_faq_link_tv)");
    this.OGV = ((TextView)localObject1);
    localObject1 = this.OGV;
    if (localObject1 == null) {
      p.bGy("mFaqTv");
    }
    ar.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    localObject1 = findViewById(a.f.wecoin_detail_known_tutorial_LL);
    p.j(localObject1, "findViewById(R.id.wecoin_detail_known_tutorial_LL)");
    this.OHo = ((LinearLayout)localObject1);
    localObject1 = findViewById(a.f.wecoin_detail_known_tutorial_tv);
    p.j(localObject1, "findViewById(R.id.wecoin_detail_known_tutorial_tv)");
    this.OHp = ((TextView)localObject1);
    localObject1 = this.OHo;
    if (localObject1 == null) {
      p.bGy("mTutorialClickLl");
    }
    ((LinearLayout)localObject1).setOnClickListener((View.OnClickListener)new j(this));
    localObject1 = this.OHp;
    if (localObject1 == null) {
      p.bGy("mTutorialClickTv");
    }
    ar.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new k(this));
    setMMTitle("");
    localObject1 = findViewById(a.f.wecoin_recharge_btn);
    p.j(localObject1, "findViewById(R.id.wecoin_recharge_btn)");
    this.OHr = ((Button)localObject1);
    localObject1 = getWindow();
    p.j(localObject1, "window");
    ((Window)localObject1).getDecorView().post((Runnable)new l(this));
    localObject1 = this.OnO;
    if (localObject1 == null) {
      p.bGy("mBalanceView");
    }
    ((WcPayMoneyLoadingView)localObject1).cV("0", false);
    v(Boolean.FALSE);
    AppMethodBeat.o(202621);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(202610);
    if (this.OHj == null) {
      p.bGy("mViewModel");
    }
    com.tencent.mm.plugin.wallet.wecoin.model.l.amu(8);
    super.onBackPressed();
    AppMethodBeat.o(202610);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202604);
    super.onCreate(paramBundle);
    initView();
    paramBundle = z.a((FragmentActivity)this).i(com.tencent.mm.plugin.wallet.wecoin.model.l.class);
    p.j(paramBundle, "ViewModelProviders.of(th…rgeViewModel::class.java)");
    this.OHj = ((com.tencent.mm.plugin.wallet.wecoin.model.l)paramBundle);
    paramBundle = this.OHj;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OFO).a((androidx.lifecycle.l)this, (s)new b(this));
    paramBundle = this.OHj;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OFr).a((androidx.lifecycle.l)this, (s)new c(this));
    paramBundle = this.OHj;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OEN).a((androidx.lifecycle.l)this, (s)new d(this));
    paramBundle = this.OHj;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OFQ).a((androidx.lifecycle.l)this, (s)new e(this));
    paramBundle = this.OHj;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OFP).a((androidx.lifecycle.l)this, (s)new f(this));
    paramBundle = this.OHj;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OEM).a((androidx.lifecycle.l)this, (s)new g(this));
    paramBundle = this.OHj;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OFt).a((androidx.lifecycle.l)this, (s)new h(this));
    paramBundle = this.OHj;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OFR).a((androidx.lifecycle.l)this, (s)new i(this));
    paramBundle = this.OHj;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    cgj localcgj = c.gIr();
    if (localcgj != null)
    {
      Log.i("MicroMsg.WeCoinRechargeViewModel", "load wecoin page info snapshot");
      c.d("MicroMsg.WeCoinRechargeViewModel", (com.tencent.mm.cd.a)localcgj);
      paramBundle.OFr.L(new com.tencent.mm.plugin.wallet.wecoin.model.g(localcgj.Tnx, localcgj.Tgi));
      paramBundle.OEN.L(Long.valueOf(localcgj.SpY));
      paramBundle.OFP.L(localcgj.Tgk);
      paramBundle.OFQ.L(localcgj.Tnw);
      paramBundle.OFt.L(localcgj.Tgl);
      paramBundle.OFS = localcgj;
      AppMethodBeat.o(202604);
      return;
    }
    AppMethodBeat.o(202604);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202614);
    super.onDestroy();
    Object localObject = this.OHj;
    if (localObject == null) {
      p.bGy("mViewModel");
    }
    localObject = ((com.tencent.mm.plugin.wallet.wecoin.model.l)localObject).OFS;
    if (localObject != null)
    {
      p.k(localObject, "response");
      Log.d("MicroMsg.WeCoinUtils", "save WecoinPageInfoResponse snapshot");
      d.h((kotlin.g.a.a)new c.e((cgj)localObject));
      AppMethodBeat.o(202614);
      return;
    }
    AppMethodBeat.o(202614);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(202609);
    super.onResume();
    Object localObject1 = this.OHj;
    if (localObject1 == null) {
      p.bGy("mViewModel");
    }
    Object localObject2 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject2, "MMKernel.storage()");
    localObject2 = ((com.tencent.mm.kernel.f)localObject2).aHp().get(ar.a.Vwm, Boolean.FALSE);
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(202609);
      throw ((Throwable)localObject1);
    }
    boolean bool = ((Boolean)localObject2).booleanValue();
    ((com.tencent.mm.plugin.wallet.wecoin.model.l)localObject1).OFR.L(Boolean.valueOf(bool));
    localObject2 = this.OHj;
    if (localObject2 == null) {
      p.bGy("mViewModel");
    }
    localObject1 = (Context)this;
    p.k(localObject1, "activity");
    localObject2 = new l.c((com.tencent.mm.plugin.wallet.wecoin.model.l)localObject2);
    k.a locala = com.tencent.mm.plugin.wallet.wecoin.model.k.OFH;
    com.tencent.mm.plugin.wallet.wecoin.model.k.gIk().b((Context)localObject1, (e)localObject2);
    localObject1 = this.OHj;
    if (localObject1 == null) {
      p.bGy("mViewModel");
    }
    localObject2 = (com.tencent.mm.vending.e.b)this;
    p.k(localObject2, "keeper");
    com.tencent.mm.plugin.wallet.wecoin.model.l.K(1, 0, "");
    new i().bhW().b((com.tencent.mm.vending.c.a)new l.b((com.tencent.mm.plugin.wallet.wecoin.model.l)localObject1)).a((com.tencent.mm.vending.e.b)localObject2);
    AppMethodBeat.o(202609);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"})
  static final class b<T>
    implements s<Boolean>
  {
    b(WeCoinRechargeView paramWeCoinRechargeView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/wallet/wecoin/model/UserIncomeDetailData;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class c<T>
    implements s<com.tencent.mm.plugin.wallet.wecoin.model.g>
  {
    c(WeCoinRechargeView paramWeCoinRechargeView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Long;)V"})
  static final class d<T>
    implements s<Long>
  {
    d(WeCoinRechargeView paramWeCoinRechargeView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"})
  static final class e<T>
    implements s<String>
  {
    e(WeCoinRechargeView paramWeCoinRechargeView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"})
  static final class f<T>
    implements s<String>
  {
    f(WeCoinRechargeView paramWeCoinRechargeView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class g<T>
    implements s<com.tencent.mm.plugin.wallet.wecoin.model.a>
  {
    g(WeCoinRechargeView paramWeCoinRechargeView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class h<T>
    implements s<abx>
  {
    h(WeCoinRechargeView paramWeCoinRechargeView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"})
  static final class i<T>
    implements s<Boolean>
  {
    i(WeCoinRechargeView paramWeCoinRechargeView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(WeCoinRechargeView paramWeCoinRechargeView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(270474);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      WeCoinRechargeView.a(this.OHu, Boolean.FALSE);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(270474);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(WeCoinRechargeView paramWeCoinRechargeView) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(271612);
      WeCoinRechargeView.a(this.OHu);
      com.tencent.mm.plugin.wallet.wecoin.model.l.amu(8);
      this.OHu.finish();
      AppMethodBeat.o(271612);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(WeCoinRechargeView paramWeCoinRechargeView) {}
    
    public final void run()
    {
      AppMethodBeat.i(228983);
      WeCoinRechargeView.b(this.OHu);
      AppMethodBeat.o(228983);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$showTutorialDialog$1$1"})
  static final class m
    implements g.a
  {
    m(com.tencent.mm.ui.widget.a.g paramg, WeCoinRechargeView paramWeCoinRechargeView) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(276985);
      WeCoinRechargeView.a(this.OHu);
      com.tencent.mm.plugin.wallet.wecoin.model.l.amu(10);
      this.OHv.bYF();
      AppMethodBeat.o(276985);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateFaqView$1$1"})
  static final class n
    implements View.OnClickListener
  {
    n(WeCoinRechargeView paramWeCoinRechargeView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(219638);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateFaqView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      WeCoinRechargeView.a(this.OHu);
      com.tencent.mm.plugin.wallet.wecoin.model.l.amu(5);
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.sPR);
      paramView.putExtra("showShare", false);
      paramView.putExtra(f.r.VSX, true);
      com.tencent.mm.wallet_core.ui.g.aJ((Context)this.OHu.getContext(), paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateFaqView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(219638);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateIncomeBalance$1$1"})
  static final class o
    implements View.OnClickListener
  {
    o(WeCoinRechargeView paramWeCoinRechargeView, LinearLayout paramLinearLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(214792);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateIncomeBalance$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      WeCoinRechargeView.a(this.OHu);
      com.tencent.mm.plugin.wallet.wecoin.model.l.amu(7);
      localObject = new Intent((Context)this.OHu.getContext(), WeCoinIncomeDetailView.class);
      ((Intent)localObject).putExtra("wecoin_enter_encash_business_kv_data", (Parcelable)new WecoinEncashKVData(2, "", ""));
      paramView = this.OHu;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateIncomeBalance$$inlined$apply$lambda$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateIncomeBalance$$inlined$apply$lambda$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateIncomeBalance$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(214792);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateRechargeButtonState$1$1"})
  static final class p
    implements View.OnClickListener
  {
    p(WeCoinRechargeView paramWeCoinRechargeView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(277678);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateRechargeButtonState$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (!c.isFastClick())
      {
        WeCoinRechargeView.a(this.OHu);
        com.tencent.mm.plugin.wallet.wecoin.model.l.amu(4);
        WeCoinRechargeView.c(this.OHu);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateRechargeButtonState$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277678);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateRightOptionMenu$1$func$1"})
  static final class q
    extends q
    implements kotlin.g.a.a<x>
  {
    q(WeCoinRechargeView paramWeCoinRechargeView, String paramString)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateRightOptionMenu$1$1"})
  static final class r
    implements MenuItem.OnMenuItemClickListener
  {
    r(kotlin.g.a.a parama, WeCoinRechargeView paramWeCoinRechargeView, String paramString) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(267746);
      WeCoinRechargeView.a(this.OHu);
      com.tencent.mm.plugin.wallet.wecoin.model.l.amu(1);
      com.tencent.mm.plugin.report.service.h.IzE.a(21658, new Object[] { Integer.valueOf(1) });
      this.tCS.invoke();
      AppMethodBeat.o(267746);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateTopBannerView$1$1"})
  static final class s
    implements View.OnClickListener
  {
    s(abx paramabx, WeCoinRechargeView paramWeCoinRechargeView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(274532);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateTopBannerView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      WeCoinRechargeView.a(this.OHu);
      com.tencent.mm.plugin.wallet.wecoin.model.l.amu(3);
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.OHi.url);
      com.tencent.mm.wallet_core.ui.g.aJ((Context)this.OHu, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateTopBannerView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(274532);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinRechargeView
 * JD-Core Version:    0.7.0.1
 */