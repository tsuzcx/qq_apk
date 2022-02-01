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
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.wallet.wecoin.b.e;
import com.tencent.mm.plugin.wallet.wecoin.b.g;
import com.tencent.mm.plugin.wallet.wecoin.c.c;
import com.tencent.mm.plugin.wallet.wecoin.c.c.d;
import com.tencent.mm.plugin.wallet.wecoin.model.WeCoinIncomeDetailViewModel;
import com.tencent.mm.plugin.wallet.wecoin.model.WeCoinIncomeDetailViewModel.b;
import com.tencent.mm.plugin.wallet.wecoin.model.WeCoinIncomeDetailViewModel.c;
import com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.protocal.protobuf.abq;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.djt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "mBalanceView", "Lcom/tencent/mm/plugin/wallet_core/ui/view/WcPayMoneyLoadingView;", "mFaqTv", "Landroid/widget/TextView;", "mFetchBtn", "Landroid/widget/Button;", "mIncomeBalanceLL", "Landroid/widget/LinearLayout;", "mMoneyLoadingPb", "Landroid/widget/ProgressBar;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mViewModel", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinIncomeDetailViewModel;", "bindData", "", "getLayoutId", "", "gotoIncomeBalanceView", "initKVData", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "openRealNameAuth", "info", "Lcom/tencent/mm/protocal/protobuf/RealNameAuthInfo;", "showAlertDialog", "showErrorMsg", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "showProgressDialog", "isShow", "", "(Ljava/lang/Boolean;)V", "updateAuthored", "authored", "updateClickButtonEvent", "updateFaqView", "url", "", "updateIncomeBalanceView", "balance", "", "(Ljava/lang/Long;)V", "updateRightOptionMenu", "updateTopBannerView", "bannerContent", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "Companion", "plugin-wxpay_release"})
public final class WeCoinIncomeDetailView
  extends MMActivity
{
  public static final WeCoinIncomeDetailView.a HOZ;
  private LinearLayout HOW;
  private WeCoinIncomeDetailViewModel HOX;
  private TextView HOY;
  private Button HvV;
  private WcPayMoneyLoadingView Hwb;
  private q gxX;
  private ProgressBar zmU;
  
  static
  {
    AppMethodBeat.i(212865);
    HOZ = new WeCoinIncomeDetailView.a((byte)0);
    AppMethodBeat.o(212865);
  }
  
  private final void fPJ()
  {
    AppMethodBeat.i(212864);
    Log.d("MicroMsg.WeCoinIncomeDetailView", "gotoIncomeBalanceView: ");
    Object localObject1 = new Intent((Context)getContext(), WeCoinEncashView.class);
    Object localObject2 = this.HOX;
    if (localObject2 == null) {
      p.btv("mViewModel");
    }
    localObject2 = (Long)((LiveData)((WeCoinIncomeDetailViewModel)localObject2).HNv).getValue();
    if (localObject2 != null) {
      ((Intent)localObject1).putExtra("wecoin_income_balance", ((Number)localObject2).longValue());
    }
    localObject2 = this.HOX;
    if (localObject2 == null) {
      p.btv("mViewModel");
    }
    ((Intent)localObject1).putExtra("wecoin_enter_encash_business_kv_data", (Parcelable)((WeCoinIncomeDetailViewModel)localObject2).HNm);
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "gotoIncomeBalanceView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "gotoIncomeBalanceView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(212864);
  }
  
  private final void l(Long paramLong)
  {
    AppMethodBeat.i(212862);
    if (paramLong != null)
    {
      paramLong = com.tencent.mm.wallet_core.ui.f.formatMoney2f(com.tencent.mm.wallet_core.ui.f.b(String.valueOf(((Number)paramLong).longValue()), "100", 2, RoundingMode.HALF_UP).doubleValue());
      WcPayMoneyLoadingView localWcPayMoneyLoadingView = this.Hwb;
      if (localWcPayMoneyLoadingView == null) {
        p.btv("mBalanceView");
      }
      localWcPayMoneyLoadingView.cH(paramLong, false);
      AppMethodBeat.o(212862);
      return;
    }
    AppMethodBeat.o(212862);
  }
  
  public final int getLayoutId()
  {
    return 2131492966;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(212861);
    setActionbarColor(getResources().getColor(2131101424));
    hideActionbarLine();
    setMMTitle("");
    Object localObject1 = findViewById(2131310126);
    p.g(localObject1, "findViewById(R.id.wallet_balance_view)");
    this.Hwb = ((WcPayMoneyLoadingView)localObject1);
    localObject1 = findViewById(2131310218);
    p.g(localObject1, "findViewById(R.id.wallet_money_load_pb)");
    this.zmU = ((ProgressBar)localObject1);
    localObject1 = findViewById(2131310443);
    p.g(localObject1, "findViewById(R.id.wecoin_income_banner_ll)");
    this.HOW = ((LinearLayout)localObject1);
    localObject1 = this.Hwb;
    if (localObject1 == null) {
      p.btv("mBalanceView");
    }
    Object localObject2 = this.zmU;
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
    localObject1 = findViewById(2131310113);
    p.g(localObject1, "findViewById(R.id.wallet…alance_manager_fetch_btn)");
    this.HvV = ((Button)localObject1);
    localObject1 = findViewById(2131310115);
    p.g(localObject1, "findViewById(R.id.wallet_balance_manager_qanda)");
    this.HOY = ((TextView)localObject1);
    ((WeImageView)findViewById(2131310446)).setOnClickListener((View.OnClickListener)new WeCoinIncomeDetailView.j(this));
    localObject1 = this.HOY;
    if (localObject1 == null) {
      p.btv("mFaqTv");
    }
    ao.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    setBackBtn((MenuItem.OnMenuItemClickListener)new k(this), 2131689492);
    l(Long.valueOf(0L));
    AppMethodBeat.o(212861);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(212863);
    Log.d("MicroMsg.WeCoinIncomeDetailView", "onActivityResult() requestCode:%d resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 2001)
    {
      AppMethodBeat.o(212863);
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
          break label222;
        }
      }
      label222:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label227;
        }
        localObject = this.HOX;
        if (localObject == null) {
          p.btv("mViewModel");
        }
        com.tencent.mm.vending.e.b localb = (com.tencent.mm.vending.e.b)this;
        p.h(paramIntent, "token");
        p.h(localb, "keeper");
        com.tencent.mm.plugin.wallet.wecoin.c.a.a(((WeCoinIncomeDetailViewModel)localObject).qiR, Boolean.TRUE);
        String str = UUID.randomUUID().toString();
        p.g(str, "uuid.toString()");
        ((WeCoinIncomeDetailViewModel)localObject).a(str, 10, 1, 0, "");
        new e(paramIntent, str).aYI().b((com.tencent.mm.vending.c.a)new WeCoinIncomeDetailViewModel.c((WeCoinIncomeDetailViewModel)localObject, str)).a(localb);
        AppMethodBeat.o(212863);
        return;
        paramIntent = null;
        break;
      }
    }
    label227:
    paramIntent = this.HOX;
    if (paramIntent == null) {
      p.btv("mViewModel");
    }
    paramIntent.aeH(19);
    AppMethodBeat.o(212863);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(212860);
    WeCoinIncomeDetailViewModel localWeCoinIncomeDetailViewModel = this.HOX;
    if (localWeCoinIncomeDetailViewModel == null) {
      p.btv("mViewModel");
    }
    localWeCoinIncomeDetailViewModel.aeH(10);
    super.onBackPressed();
    AppMethodBeat.o(212860);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212857);
    super.onCreate(paramBundle);
    initView();
    paramBundle = ViewModelProviders.of((FragmentActivity)this).get(WeCoinIncomeDetailViewModel.class);
    p.g(paramBundle, "ViewModelProviders.of(th…ailViewModel::class.java)");
    this.HOX = ((WeCoinIncomeDetailViewModel)paramBundle);
    paramBundle = this.HOX;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HNt).observe((LifecycleOwner)this, (Observer)new b(this));
    paramBundle = this.HOX;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HNv).observe((LifecycleOwner)this, (Observer)new c(this));
    paramBundle = this.HOX;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HNu).observe((LifecycleOwner)this, (Observer)new d(this));
    paramBundle = this.HOX;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HNw).observe((LifecycleOwner)this, (Observer)new e(this));
    paramBundle = this.HOX;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HMQ).observe((LifecycleOwner)this, (Observer)new f(this));
    paramBundle = this.HOX;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HNy).observe((LifecycleOwner)this, (Observer)new g(this));
    paramBundle = this.HOX;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HNx).observe((LifecycleOwner)this, (Observer)new h(this));
    paramBundle = this.HOX;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.qiR).observe((LifecycleOwner)this, (Observer)new i(this));
    paramBundle = this.HOX;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    Object localObject = (WecoinEncashKVData)getIntent().getParcelableExtra("wecoin_enter_encash_business_kv_data");
    if (localObject != null) {
      paramBundle.HNm = new WecoinEncashKVData(((WecoinEncashKVData)localObject).HNZ, ((WecoinEncashKVData)localObject).HMK, c.fPE());
    }
    paramBundle = this.HOX;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    localObject = c.fPM();
    if (localObject != null)
    {
      paramBundle.HNt.postValue(((bop)localObject).LWK);
      paramBundle.HNu.postValue(((bop)localObject).LWL);
      paramBundle.HNv.postValue(Long.valueOf(((bop)localObject).LWJ));
      paramBundle.HNw.postValue(((bop)localObject).LWN);
      paramBundle.HNx.postValue(((bop)localObject).LWM);
      paramBundle.HNz = ((bop)localObject);
      AppMethodBeat.o(212857);
      return;
    }
    AppMethodBeat.o(212857);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(212859);
    super.onDestroy();
    Object localObject = this.HOX;
    if (localObject == null) {
      p.btv("mViewModel");
    }
    localObject = ((WeCoinIncomeDetailViewModel)localObject).HNz;
    if (localObject != null)
    {
      p.h(localObject, "response");
      Log.d("MicroMsg.WeCoinUtils", "save WecoinIncomePageInfoResponse snapshot");
      d.i((kotlin.g.a.a)new c.d((bop)localObject));
      AppMethodBeat.o(212859);
      return;
    }
    AppMethodBeat.o(212859);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(212858);
    super.onResume();
    WeCoinIncomeDetailViewModel localWeCoinIncomeDetailViewModel = this.HOX;
    if (localWeCoinIncomeDetailViewModel == null) {
      p.btv("mViewModel");
    }
    com.tencent.mm.vending.e.b localb = (com.tencent.mm.vending.e.b)this;
    p.h(localb, "keeper");
    localWeCoinIncomeDetailViewModel.a("", 9, 1, 0, "");
    new g().aYI().b((com.tencent.mm.vending.c.a)new WeCoinIncomeDetailViewModel.b(localWeCoinIncomeDetailViewModel)).a(localb);
    AppMethodBeat.o(212858);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onChanged"})
  static final class b<T>
    implements Observer<String>
  {
    b(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Long;)V"})
  static final class c<T>
    implements Observer<Long>
  {
    c(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onChanged"})
  static final class d<T>
    implements Observer<String>
  {
    d(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/RealNameAuthInfo;", "onChanged"})
  static final class e<T>
    implements Observer<djt>
  {
    e(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "onChanged"})
  static final class f<T>
    implements Observer<com.tencent.mm.plugin.wallet.wecoin.model.a>
  {
    f(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V"})
  static final class g<T>
    implements Observer<Boolean>
  {
    g(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "onChanged"})
  static final class h<T>
    implements Observer<abq>
  {
    h(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V"})
  static final class i<T>
    implements Observer<Boolean>
  {
    i(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(212851);
      WeCoinIncomeDetailView.b(this.HPa).aeH(10);
      this.HPa.finish();
      AppMethodBeat.o(212851);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, djt paramdjt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212853);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateClickButtonEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      WeCoinIncomeDetailView.b(this.HPa).aeH(2);
      paramView = this.HPc;
      if ((paramView != null) && (paramView.status == 1))
      {
        WeCoinIncomeDetailView.b(this.HPa).aeH(11);
        WeCoinIncomeDetailView.a(this.HPa, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateClickButtonEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212853);
        return;
      }
      WeCoinIncomeDetailView.d(this.HPa);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateClickButtonEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212853);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateFaqView$1$1"})
  static final class n
    implements View.OnClickListener
  {
    n(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212854);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateFaqView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      WeCoinIncomeDetailView.b(this.HPa).aeH(7);
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.pFh);
      paramView.putExtra("showShare", false);
      paramView.putExtra(e.p.OzJ, true);
      com.tencent.mm.wallet_core.ui.f.aA((Context)this.HPa.getContext(), paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateFaqView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212854);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateRightOptionMenu$1$1"})
  static final class o
    implements MenuItem.OnMenuItemClickListener
  {
    o(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, String paramString) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(212855);
      WeCoinIncomeDetailView.b(this.HPa).aeH(3);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("rawUrl", this.pFh);
      paramMenuItem.putExtra("showShare", false);
      paramMenuItem.putExtra(e.p.OzJ, true);
      com.tencent.mm.wallet_core.ui.f.aA((Context)this.HPa.getContext(), paramMenuItem);
      AppMethodBeat.o(212855);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateTopBannerView$1$1"})
  static final class p
    implements View.OnClickListener
  {
    p(abq paramabq, WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212856);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateTopBannerView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      WeCoinIncomeDetailView.b(this.HPa).aeH(9);
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.HPd.url);
      com.tencent.mm.wallet_core.ui.f.aA((Context)this.HPa, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateTopBannerView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212856);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinIncomeDetailView
 * JD-Core Version:    0.7.0.1
 */