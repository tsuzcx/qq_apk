package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.wallet.wecoin.c.c;
import com.tencent.mm.plugin.wallet.wecoin.c.c.e;
import com.tencent.mm.plugin.wallet.wecoin.model.WeCoinRechargeViewModel;
import com.tencent.mm.plugin.wallet.wecoin.model.WeCoinRechargeViewModel.b;
import com.tencent.mm.plugin.wallet.wecoin.model.WeCoinRechargeViewModel.c;
import com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData;
import com.tencent.mm.plugin.wallet.wecoin.model.h.a;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.protocal.protobuf.abq;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "mBalanceView", "Lcom/tencent/mm/plugin/wallet_core/ui/view/WcPayMoneyLoadingView;", "mBannerView", "Landroid/view/View;", "mFaqTv", "Landroid/widget/TextView;", "mMoneyLoadingPb", "Landroid/widget/ProgressBar;", "mNoBalanceTipsTv", "mSwitchDeviceTipsView", "mTotalBalanceLl", "Landroid/widget/LinearLayout;", "mViewModel", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinRechargeViewModel;", "mWeCoinBalanceView", "mWeCoinRechargeButton", "Landroid/widget/Button;", "bindData", "", "getLayoutId", "", "initView", "loadCacheData", "loadData", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "showDeviceSwitchTips", "hasShow", "", "(Ljava/lang/Boolean;)V", "showErrorMsg", "info", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "showGridBottomSheet", "showTutorialDialog", "updateFaqView", "url", "", "updateIncomeBalance", "balance", "Lcom/tencent/mm/plugin/wallet/wecoin/model/UserIncomeDetailData;", "updateMainContentView", "updateRechargeButtonState", "midasInitialized", "updateRightOptionMenu", "updateTopBannerView", "bannerContent", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "updateTotalBalance", "", "(Ljava/lang/Long;)V", "Companion", "plugin-wxpay_release"})
public final class WeCoinRechargeView
  extends MMActivity
{
  public static final WeCoinRechargeView.a HPl;
  private TextView HOY;
  private WeCoinRechargeViewModel HPe;
  private LinearLayout HPf;
  private TextView HPg;
  private View HPh;
  private TextView HPi;
  private Button HPj;
  private TextView HPk;
  private WcPayMoneyLoadingView Hwb;
  private ProgressBar zmU;
  
  static
  {
    AppMethodBeat.i(212901);
    HPl = new WeCoinRechargeView.a((byte)0);
    AppMethodBeat.o(212901);
  }
  
  private final void o(Boolean paramBoolean)
  {
    AppMethodBeat.i(212900);
    Button localButton = this.HPj;
    if (localButton == null) {
      p.btv("mWeCoinRechargeButton");
    }
    localButton.setEnabled(false);
    if (paramBoolean != null)
    {
      if (paramBoolean.booleanValue())
      {
        paramBoolean = this.HPj;
        if (paramBoolean == null) {
          p.btv("mWeCoinRechargeButton");
        }
        paramBoolean.setEnabled(true);
        paramBoolean = this.HPj;
        if (paramBoolean == null) {
          p.btv("mWeCoinRechargeButton");
        }
        paramBoolean.setOnClickListener((View.OnClickListener)new o(this));
      }
      AppMethodBeat.o(212900);
      return;
    }
    AppMethodBeat.o(212900);
  }
  
  public final int getLayoutId()
  {
    return 2131492967;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(212899);
    setContentViewVisibility(0);
    setActionbarColor(getResources().getColor(2131101421));
    Object localObject1 = findViewById(2131310435);
    p.g(localObject1, "findViewById(R.id.wecoin_balance_account_ll)");
    this.HPf = ((LinearLayout)localObject1);
    localObject1 = findViewById(2131310364);
    p.g(localObject1, "findViewById(R.id.we_coin_no_balance_tips_tv)");
    this.HPg = ((TextView)localObject1);
    localObject1 = findViewById(2131310450);
    p.g(localObject1, "findViewById(R.id.wecoin_recharge_banner_ll)");
    this.HPh = ((View)localObject1);
    localObject1 = findViewById(2131310362);
    p.g(localObject1, "findViewById(R.id.we_coin_balance_tv)");
    this.HPi = ((TextView)localObject1);
    localObject1 = findViewById(2131310453);
    p.g(localObject1, "findViewById(R.id.wecoin_switch_device_tips)");
    this.HPk = ((TextView)localObject1);
    localObject1 = com.tencent.mm.wallet_core.ui.f.aqk(0);
    try
    {
      localObject2 = this.HPi;
      if (localObject2 == null) {
        p.btv("mWeCoinBalanceView");
      }
      AppCompatActivity localAppCompatActivity = getContext();
      p.g(localAppCompatActivity, "context");
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
    localObject1 = findViewById(2131310126);
    p.g(localObject1, "findViewById(R.id.wallet_balance_view)");
    this.Hwb = ((WcPayMoneyLoadingView)localObject1);
    localObject1 = findViewById(2131310218);
    p.g(localObject1, "findViewById(R.id.wallet_money_load_pb)");
    this.zmU = ((ProgressBar)localObject1);
    localObject1 = this.Hwb;
    if (localObject1 == null) {
      p.btv("mBalanceView");
    }
    localObject2 = this.zmU;
    if (localObject2 == null) {
      p.btv("mMoneyLoadingPb");
    }
    ((WcPayMoneyLoadingView)localObject1).setLoadingPb((ProgressBar)localObject2);
    localObject1 = this.Hwb;
    if (localObject1 == null) {
      p.btv("mBalanceView");
    }
    ((WcPayMoneyLoadingView)localObject1).setPrefixSymbol(getString(2131768266));
    localObject1 = getLifecycle();
    localObject2 = this.Hwb;
    if (localObject2 == null) {
      p.btv("mBalanceView");
    }
    ((Lifecycle)localObject1).addObserver((LifecycleObserver)localObject2);
    localObject1 = findViewById(2131310439);
    p.g(localObject1, "findViewById(R.id.wecoin_detail_faq_link_tv)");
    this.HOY = ((TextView)localObject1);
    localObject1 = this.HOY;
    if (localObject1 == null) {
      p.btv("mFaqTv");
    }
    com.tencent.mm.ui.ao.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new j(this));
    setMMTitle("");
    localObject1 = findViewById(2131310451);
    p.g(localObject1, "findViewById(R.id.wecoin_recharge_btn)");
    this.HPj = ((Button)localObject1);
    localObject1 = getWindow();
    p.g(localObject1, "window");
    ((Window)localObject1).getDecorView().post((Runnable)new k(this));
    localObject1 = this.Hwb;
    if (localObject1 == null) {
      p.btv("mBalanceView");
    }
    ((WcPayMoneyLoadingView)localObject1).cH("0", false);
    o(Boolean.FALSE);
    AppMethodBeat.o(212899);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(212897);
    if (this.HPe == null) {
      p.btv("mViewModel");
    }
    WeCoinRechargeViewModel.aeH(8);
    super.onBackPressed();
    AppMethodBeat.o(212897);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212895);
    super.onCreate(paramBundle);
    initView();
    paramBundle = ViewModelProviders.of((FragmentActivity)this).get(WeCoinRechargeViewModel.class);
    p.g(paramBundle, "ViewModelProviders.of(th…rgeViewModel::class.java)");
    this.HPe = ((WeCoinRechargeViewModel)paramBundle);
    paramBundle = this.HPe;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HNS).observe((LifecycleOwner)this, (Observer)new b(this));
    paramBundle = this.HPe;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HNv).observe((LifecycleOwner)this, (Observer)new c(this));
    paramBundle = this.HPe;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HMR).observe((LifecycleOwner)this, (Observer)new d(this));
    paramBundle = this.HPe;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HNU).observe((LifecycleOwner)this, (Observer)new e(this));
    paramBundle = this.HPe;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HNT).observe((LifecycleOwner)this, (Observer)new f(this));
    paramBundle = this.HPe;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HMQ).observe((LifecycleOwner)this, (Observer)new g(this));
    paramBundle = this.HPe;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HNx).observe((LifecycleOwner)this, (Observer)new h(this));
    paramBundle = this.HPe;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HNV).observe((LifecycleOwner)this, (Observer)new i(this));
    paramBundle = this.HPe;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    byp localbyp = c.fPL();
    if (localbyp != null)
    {
      Log.i("MicroMsg.WeCoinRechargeViewModel", "load wecoin page info snapshot");
      c.d("MicroMsg.WeCoinRechargeViewModel", (com.tencent.mm.bw.a)localbyp);
      paramBundle.HNv.postValue(new com.tencent.mm.plugin.wallet.wecoin.model.f(localbyp.MdX, localbyp.LWJ));
      paramBundle.HMR.postValue(Long.valueOf(localbyp.LoC));
      paramBundle.HNT.postValue(localbyp.LWL);
      paramBundle.HNU.postValue(localbyp.MdW);
      paramBundle.HNx.postValue(localbyp.LWM);
      paramBundle.HNW = localbyp;
      AppMethodBeat.o(212895);
      return;
    }
    AppMethodBeat.o(212895);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(212898);
    super.onDestroy();
    Object localObject = this.HPe;
    if (localObject == null) {
      p.btv("mViewModel");
    }
    localObject = ((WeCoinRechargeViewModel)localObject).HNW;
    if (localObject != null)
    {
      p.h(localObject, "response");
      Log.d("MicroMsg.WeCoinUtils", "save WecoinPageInfoResponse snapshot");
      d.i((kotlin.g.a.a)new c.e((byp)localObject));
      AppMethodBeat.o(212898);
      return;
    }
    AppMethodBeat.o(212898);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(212896);
    super.onResume();
    Object localObject1 = this.HPe;
    if (localObject1 == null) {
      p.btv("mViewModel");
    }
    Object localObject2 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject2, "MMKernel.storage()");
    localObject2 = ((com.tencent.mm.kernel.e)localObject2).azQ().get(ar.a.OhW, Boolean.FALSE);
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(212896);
      throw ((Throwable)localObject1);
    }
    boolean bool = ((Boolean)localObject2).booleanValue();
    ((WeCoinRechargeViewModel)localObject1).HNV.postValue(Boolean.valueOf(bool));
    localObject2 = this.HPe;
    if (localObject2 == null) {
      p.btv("mViewModel");
    }
    localObject1 = (Context)this;
    p.h(localObject1, "activity");
    localObject2 = new WeCoinRechargeViewModel.c((WeCoinRechargeViewModel)localObject2);
    h.a locala = com.tencent.mm.plugin.wallet.wecoin.model.h.HNL;
    com.tencent.mm.plugin.wallet.wecoin.model.h.fPG().b((Context)localObject1, (com.tencent.mm.plugin.wallet.wecoin.a.e)localObject2);
    localObject1 = this.HPe;
    if (localObject1 == null) {
      p.btv("mViewModel");
    }
    localObject2 = (com.tencent.mm.vending.e.b)this;
    p.h(localObject2, "keeper");
    WeCoinRechargeViewModel.L(1, 0, "");
    new com.tencent.mm.plugin.wallet.wecoin.b.h().aYI().b((com.tencent.mm.vending.c.a)new WeCoinRechargeViewModel.b((WeCoinRechargeViewModel)localObject1)).a((com.tencent.mm.vending.e.b)localObject2);
    AppMethodBeat.o(212896);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V"})
  static final class b<T>
    implements Observer<Boolean>
  {
    b(WeCoinRechargeView paramWeCoinRechargeView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/wallet/wecoin/model/UserIncomeDetailData;", "onChanged"})
  static final class c<T>
    implements Observer<com.tencent.mm.plugin.wallet.wecoin.model.f>
  {
    c(WeCoinRechargeView paramWeCoinRechargeView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Long;)V"})
  static final class d<T>
    implements Observer<Long>
  {
    d(WeCoinRechargeView paramWeCoinRechargeView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onChanged"})
  static final class e<T>
    implements Observer<String>
  {
    e(WeCoinRechargeView paramWeCoinRechargeView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onChanged"})
  static final class f<T>
    implements Observer<String>
  {
    f(WeCoinRechargeView paramWeCoinRechargeView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "onChanged"})
  static final class g<T>
    implements Observer<com.tencent.mm.plugin.wallet.wecoin.model.a>
  {
    g(WeCoinRechargeView paramWeCoinRechargeView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "onChanged"})
  static final class h<T>
    implements Observer<abq>
  {
    h(WeCoinRechargeView paramWeCoinRechargeView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V"})
  static final class i<T>
    implements Observer<Boolean>
  {
    i(WeCoinRechargeView paramWeCoinRechargeView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class j
    implements MenuItem.OnMenuItemClickListener
  {
    j(WeCoinRechargeView paramWeCoinRechargeView) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(212886);
      WeCoinRechargeView.a(this.HPm);
      WeCoinRechargeViewModel.aeH(8);
      this.HPm.finish();
      AppMethodBeat.o(212886);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(WeCoinRechargeView paramWeCoinRechargeView) {}
    
    public final void run()
    {
      AppMethodBeat.i(212887);
      WeCoinRechargeView.b(this.HPm);
      AppMethodBeat.o(212887);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$showTutorialDialog$1$1"})
  static final class l
    implements g.a
  {
    l(com.tencent.mm.ui.widget.a.g paramg, WeCoinRechargeView paramWeCoinRechargeView) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(212888);
      WeCoinRechargeView.a(this.HPm);
      WeCoinRechargeViewModel.aeH(10);
      this.HPn.bMo();
      AppMethodBeat.o(212888);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateFaqView$1$1"})
  static final class m
    implements View.OnClickListener
  {
    m(WeCoinRechargeView paramWeCoinRechargeView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212889);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateFaqView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      WeCoinRechargeView.a(this.HPm);
      WeCoinRechargeViewModel.aeH(5);
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.pFh);
      paramView.putExtra("showShare", false);
      paramView.putExtra(e.p.OzJ, true);
      com.tencent.mm.wallet_core.ui.f.aA((Context)this.HPm.getContext(), paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateFaqView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212889);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateIncomeBalance$1$1"})
  static final class n
    implements View.OnClickListener
  {
    n(WeCoinRechargeView paramWeCoinRechargeView, LinearLayout paramLinearLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212890);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateIncomeBalance$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      WeCoinRechargeView.a(this.HPm);
      WeCoinRechargeViewModel.aeH(7);
      localObject = new Intent((Context)this.HPm.getContext(), WeCoinIncomeDetailView.class);
      ((Intent)localObject).putExtra("wecoin_enter_encash_business_kv_data", (Parcelable)new WecoinEncashKVData(2, "", ""));
      paramView = this.HPm;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateIncomeBalance$$inlined$apply$lambda$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateIncomeBalance$$inlined$apply$lambda$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateIncomeBalance$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212890);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateRechargeButtonState$1$1"})
  static final class o
    implements View.OnClickListener
  {
    o(WeCoinRechargeView paramWeCoinRechargeView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212891);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateRechargeButtonState$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (!c.isFastClick())
      {
        WeCoinRechargeView.a(this.HPm);
        WeCoinRechargeViewModel.aeH(4);
        WeCoinRechargeView.c(this.HPm);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateRechargeButtonState$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212891);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateRightOptionMenu$1$func$1"})
  static final class p
    extends q
    implements kotlin.g.a.a<x>
  {
    p(WeCoinRechargeView paramWeCoinRechargeView, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateRightOptionMenu$1$1"})
  static final class q
    implements MenuItem.OnMenuItemClickListener
  {
    q(kotlin.g.a.a parama, WeCoinRechargeView paramWeCoinRechargeView, String paramString) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(212893);
      WeCoinRechargeView.a(this.HPm);
      WeCoinRechargeViewModel.aeH(1);
      com.tencent.mm.plugin.report.service.h.CyF.a(21658, new Object[] { Integer.valueOf(1) });
      this.qgW.invoke();
      AppMethodBeat.o(212893);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateTopBannerView$1$1"})
  static final class r
    implements View.OnClickListener
  {
    r(abq paramabq, WeCoinRechargeView paramWeCoinRechargeView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212894);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateTopBannerView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      WeCoinRechargeView.a(this.HPm);
      WeCoinRechargeViewModel.aeH(3);
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.HPd.url);
      com.tencent.mm.wallet_core.ui.f.aA((Context)this.HPm, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateTopBannerView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212894);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinRechargeView
 * JD-Core Version:    0.7.0.1
 */