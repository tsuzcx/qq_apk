package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.ui.b.a;
import com.tencent.mm.plugin.wallet.wecoin.a.d.a;
import com.tencent.mm.plugin.wallet.wecoin.b.i;
import com.tencent.mm.plugin.wallet.wecoin.b.k;
import com.tencent.mm.plugin.wallet.wecoin.c.c;
import com.tencent.mm.plugin.wallet.wecoin.model.RechargeProductsDialogViewModel;
import com.tencent.mm.plugin.wallet.wecoin.model.RechargeProductsDialogViewModel.c;
import com.tencent.mm.plugin.wallet.wecoin.model.RechargeProductsDialogViewModel.d;
import com.tencent.mm.protocal.protobuf.byr;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.protocal.protobuf.faz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.ui.e.a;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog;", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "context", "Landroid/support/v4/app/FragmentActivity;", "params", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "(Landroid/support/v4/app/FragmentActivity;Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;)V", "getContext", "()Landroid/support/v4/app/FragmentActivity;", "mBottomSheet", "Lcom/tencent/mm/plugin/wallet/ui/CommonBottomSheet;", "mCancelListener", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog$OnCancelListener;", "mCustomView", "Landroid/view/View;", "mFirstAdapter", "Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter;", "mHeaderView", "mIsItemClicked", "", "mMenuClickListener", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IBtnClickListener;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mSecondAdapter", "mViewModel", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogViewModel;", "getParams", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "showDarkAlways", "bindData", "", "createExitAnimation", "Landroid/animation/Animator;", "dialogView", "handleInterceptWinInfo", "info", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeInterceptWinInfo;", "handleItemClicked", "Lcom/tencent/mm/protocal/protobuf/WecoinPriceInfo;", "initCustomView", "initHeaderView", "initKVData", "initView", "Landroid/content/Context;", "isLandscape", "loadData", "removeObserver", "setAnimationOut", "setDialogCancelListener", "listener", "setMenuClickListener", "shakeIt", "showErrorMsg", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "tryHide", "updateAgreementLinkText", "url", "", "updateCheckBox", "status", "", "(Ljava/lang/Integer;)V", "updatePriceItem", "priceInfo", "", "updateTitleBalance", "balance", "", "(Ljava/lang/Long;)V", "Companion", "RecycleViewAdapter", "plugin-wxpay_release"})
public final class a
  implements com.tencent.mm.plugin.wallet.wecoin.a.d
{
  public static final a.a HOk;
  private final boolean HMJ;
  private com.tencent.mm.plugin.wallet.ui.b HOb;
  private final RechargeProductsDialogViewModel HOc;
  private b HOd;
  private b HOe;
  private boolean HOf;
  private d.a HOg;
  private com.tencent.mm.plugin.wallet.wecoin.a.a HOh;
  final FragmentActivity HOi;
  final com.tencent.mm.plugin.wallet.wecoin.model.e HOj;
  private View agA;
  private View ahJ;
  private com.tencent.mm.ui.base.q gxX;
  
  static
  {
    AppMethodBeat.i(212777);
    HOk = new a.a((byte)0);
    AppMethodBeat.o(212777);
  }
  
  public a(FragmentActivity paramFragmentActivity, com.tencent.mm.plugin.wallet.wecoin.model.e parame)
  {
    AppMethodBeat.i(212776);
    this.HOi = paramFragmentActivity;
    this.HOj = parame;
    this.HMJ = this.HOj.HMJ;
    paramFragmentActivity = ViewModelProviders.of(this.HOi).get(RechargeProductsDialogViewModel.class);
    p.g(paramFragmentActivity, "ViewModelProviders.of(co…logViewModel::class.java)");
    this.HOc = ((RechargeProductsDialogViewModel)paramFragmentActivity);
    Object localObject = this.HOc;
    paramFragmentActivity = this.HOj;
    p.h(paramFragmentActivity, "params");
    ((RechargeProductsDialogViewModel)localObject).HNa = paramFragmentActivity;
    int i;
    switch (paramFragmentActivity.mScene)
    {
    default: 
      i = -1;
      ((RechargeProductsDialogViewModel)localObject).zbZ = i;
      ((RechargeProductsDialogViewModel)localObject).HMZ = ((RechargeProductsDialogViewModel)localObject).fPE();
      switch (paramFragmentActivity.mScene)
      {
      default: 
        label172:
        paramFragmentActivity = "";
        label175:
        ((RechargeProductsDialogViewModel)localObject).HMY = paramFragmentActivity;
        ((LiveData)this.HOc.HMR).removeObservers((LifecycleOwner)this.HOi);
        ((LiveData)this.HOc.qiR).removeObservers((LifecycleOwner)this.HOi);
        ((LiveData)this.HOc.HMO).removeObservers((LifecycleOwner)this.HOi);
        ((LiveData)this.HOc.HMP).removeObservers((LifecycleOwner)this.HOi);
        ((LiveData)this.HOc.HMQ).removeObservers((LifecycleOwner)this.HOi);
        ((LiveData)this.HOc.HMS).removeObservers((LifecycleOwner)this.HOi);
        ((LiveData)this.HOc.HMN).removeObservers((LifecycleOwner)this.HOi);
        paramFragmentActivity = (Context)this.HOi;
        switch (this.HOj.mScene)
        {
        default: 
          paramFragmentActivity = new com.tencent.mm.plugin.wallet.ui.b(paramFragmentActivity, 0, 3);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      this.HOb = paramFragmentActivity;
      paramFragmentActivity = this.HOb;
      if (paramFragmentActivity == null) {
        p.btv("mBottomSheet");
      }
      paramFragmentActivity.yf(this.HMJ);
      if ((this.HOj.mScene == 1) && (!isLandscape()))
      {
        paramFragmentActivity = this.HOb;
        if (paramFragmentActivity == null) {
          p.btv("mBottomSheet");
        }
        paramFragmentActivity.fPy();
      }
      paramFragmentActivity = this.HOb;
      if (paramFragmentActivity == null) {
        p.btv("mBottomSheet");
      }
      paramFragmentActivity.a((b.a)new l(this));
      paramFragmentActivity = this.HOb;
      if (paramFragmentActivity == null) {
        p.btv("mBottomSheet");
      }
      paramFragmentActivity.b((DialogInterface.OnCancelListener)new m(this));
      paramFragmentActivity = View.inflate((Context)this.HOi, 2131493328, null);
      p.g(paramFragmentActivity, "View.inflate(context, R.…_half_dialog_title, null)");
      this.agA = paramFragmentActivity;
      paramFragmentActivity = this.agA;
      if (paramFragmentActivity == null) {
        p.btv("mHeaderView");
      }
      paramFragmentActivity = paramFragmentActivity.findViewById(2131297942);
      p.g(paramFragmentActivity, "mHeaderView.findViewById…ods_half_dialog_title_tv)");
      paramFragmentActivity = (TextView)paramFragmentActivity;
      parame = this.agA;
      if (parame == null) {
        p.btv("mHeaderView");
      }
      parame = parame.findViewById(2131310440);
      p.g(parame, "mHeaderView.findViewById…coin_header_back_icon_iv)");
      parame = (WeImageView)parame;
      com.tencent.mm.ui.ao.a((Paint)paramFragmentActivity.getPaint(), 0.8F);
      c.o(paramFragmentActivity, 15);
      if ((this.HOj.mScene == 0) || (this.HOj.mScene == 2)) {
        parame.setImageResource(2131690761);
      }
      if (this.HMJ)
      {
        paramFragmentActivity.setTextColor(this.HOi.getResources().getColor(2131099679));
        parame.setIconColor(this.HOi.getResources().getColor(2131099679));
      }
      paramFragmentActivity = this.HOb;
      if (paramFragmentActivity == null) {
        p.btv("mBottomSheet");
      }
      localObject = this.agA;
      if (localObject == null) {
        p.btv("mHeaderView");
      }
      paramFragmentActivity.setHeaderView((View)localObject);
      parame.setOnClickListener((View.OnClickListener)new k(this));
      paramFragmentActivity = new w((Context)this.HOi, 0);
      paramFragmentActivity.setDrawable(this.HOi.getResources().getDrawable(2131235734, null));
      parame = View.inflate((Context)this.HOi, 2131493327, null);
      p.g(parame, "View.inflate(context, R.…dialog_custom_view, null)");
      this.ahJ = parame;
      parame = this.ahJ;
      if (parame == null) {
        p.btv("mCustomView");
      }
      parame = parame.findViewById(2131297699);
      p.g(parame, "mCustomView.findViewById…_sheet_menu_reccycleview)");
      parame = (RecyclerView)parame;
      localObject = new BuyGoodsBottomDialog.initCustomView.layoutManager.1(this);
      ((BuyGoodsBottomDialog.initCustomView.layoutManager.1)localObject).setOrientation(0);
      parame.setLayoutManager((RecyclerView.LayoutManager)localObject);
      parame.b((RecyclerView.h)paramFragmentActivity);
      this.HOd = new b();
      localObject = this.HOd;
      if (localObject == null) {
        p.btv("mFirstAdapter");
      }
      parame.setAdapter((RecyclerView.a)localObject);
      parame = new BuyGoodsBottomDialog.initCustomView.secondLayoutManager.1(this);
      parame.setOrientation(0);
      localObject = this.ahJ;
      if (localObject == null) {
        p.btv("mCustomView");
      }
      localObject = ((View)localObject).findViewById(2131297700);
      p.g(localObject, "mCustomView.findViewById…heet_second_reccycleview)");
      localObject = (RecyclerView)localObject;
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)parame);
      ((RecyclerView)localObject).b((RecyclerView.h)paramFragmentActivity);
      this.HOe = new b();
      paramFragmentActivity = this.HOe;
      if (paramFragmentActivity == null) {
        p.btv("mSecondAdapter");
      }
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)paramFragmentActivity);
      paramFragmentActivity = this.HOb;
      if (paramFragmentActivity == null) {
        p.btv("mBottomSheet");
      }
      parame = this.ahJ;
      if (parame == null) {
        p.btv("mCustomView");
      }
      paramFragmentActivity.setCustomView(parame);
      j(Boolean.TRUE);
      ((LiveData)this.HOc.HMO).observe((LifecycleOwner)this.HOi, (Observer)new c(this));
      ((LiveData)this.HOc.HMP).observe((LifecycleOwner)this.HOi, (Observer)new d(this));
      ((LiveData)this.HOc.HMQ).observe((LifecycleOwner)this.HOi, (Observer)new e(this));
      ((LiveData)this.HOc.HMR).observe((LifecycleOwner)this.HOi, (Observer)new f(this));
      ((LiveData)this.HOc.qiR).observe((LifecycleOwner)this.HOi, (Observer)new g(this));
      ((LiveData)this.HOc.HMS).observe((LifecycleOwner)this.HOi, (Observer)new h(this));
      ((LiveData)this.HOc.HMN).observe((LifecycleOwner)this.HOi, (Observer)new i(this));
      paramFragmentActivity = this.HOc;
      Log.i("MicroMsg.RechargeProductsDialogViewModel", "getCacheData, isCacheDataLoaded: %s", new Object[] { Boolean.valueOf(paramFragmentActivity.HMX) });
      if (paramFragmentActivity.HMX) {
        break label1524;
      }
      paramFragmentActivity.HMX = true;
      paramFragmentActivity.HMT = c.fPN();
      parame = paramFragmentActivity.HMT;
      if (parame != null)
      {
        paramFragmentActivity.HMN.postValue(parame.MdY);
        paramFragmentActivity.HMO.postValue(parame.MdZ);
        paramFragmentActivity.HMP.postValue(Integer.valueOf(parame.Mea));
        paramFragmentActivity.HMW = parame.Meb;
      }
      parame = g.aAh();
      p.g(parame, "MMKernel.storage()");
      parame = parame.azQ().get(ar.a.OhY, Long.valueOf(0L));
      if (parame != null) {
        break label1496;
      }
      paramFragmentActivity = new t("null cannot be cast to non-null type kotlin.Long");
      AppMethodBeat.o(212776);
      throw paramFragmentActivity;
      i = 2;
      break;
      i = 1;
      break;
      parame = ((RechargeProductsDialogViewModel)localObject).HMZ;
      paramFragmentActivity = parame;
      if (parame != null) {
        break label175;
      }
      p.btv("mSessionid");
      paramFragmentActivity = parame;
      break label175;
      parame = paramFragmentActivity.HMK;
      paramFragmentActivity = parame;
      if (parame != null) {
        break label175;
      }
      break label172;
      paramFragmentActivity = new com.tencent.mm.plugin.wallet.ui.b(paramFragmentActivity, 0, 3);
      continue;
      paramFragmentActivity = new com.tencent.mm.plugin.wallet.ui.b(paramFragmentActivity);
    }
    label1496:
    long l = ((Long)parame).longValue();
    if (l > 0L) {
      paramFragmentActivity.HMR.postValue(Long.valueOf(l));
    }
    label1524:
    paramFragmentActivity = this.HOc;
    paramFragmentActivity.f(8, 1, 0, "");
    paramFragmentActivity.HMV = new i();
    parame = paramFragmentActivity.HMV;
    if (parame != null)
    {
      parame = parame.aYI();
      if (parame != null) {
        parame.b((com.tencent.mm.vending.c.a)new RechargeProductsDialogViewModel.d(paramFragmentActivity));
      }
    }
    paramFragmentActivity = this.HOc;
    new com.tencent.mm.plugin.wallet.wecoin.b.f().aYI().b((com.tencent.mm.vending.c.a)new RechargeProductsDialogViewModel.c(paramFragmentActivity));
    AppMethodBeat.o(212776);
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(212774);
    Resources localResources = this.HOi.getResources();
    p.g(localResources, "context.resources");
    if (localResources.getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(212774);
      return true;
    }
    AppMethodBeat.o(212774);
    return false;
  }
  
  private final void j(Boolean paramBoolean)
  {
    AppMethodBeat.i(212773);
    Log.d("MicroMsg.BuyGoodsBottomDialog", "showProgressDialog: ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean == null)
    {
      AppMethodBeat.o(212773);
      return;
    }
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = com.tencent.mm.ui.base.q.a((Context)this.HOi, (CharSequence)this.HOi.getString(2131762446), true, 3, (DialogInterface.OnCancelListener)new o(this));; paramBoolean = null)
    {
      this.gxX = paramBoolean;
      AppMethodBeat.o(212773);
      return;
      paramBoolean = this.gxX;
      if (paramBoolean != null) {
        paramBoolean.dismiss();
      }
    }
  }
  
  public final void a(d.a parama)
  {
    this.HOg = parama;
  }
  
  public final void b(com.tencent.mm.plugin.wallet.wecoin.a.a parama)
  {
    this.HOh = parama;
  }
  
  public final void bMo()
  {
    AppMethodBeat.i(212775);
    com.tencent.mm.plugin.wallet.ui.b localb = this.HOb;
    if (localb == null) {
      p.btv("mBottomSheet");
    }
    localb.bMo();
    AppMethodBeat.o(212775);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$ViewHolder;", "Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog;", "(Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog;)V", "mItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "getMItemClickListener", "()Landroid/widget/AdapterView$OnItemClickListener;", "setMItemClickListener", "(Landroid/widget/AdapterView$OnItemClickListener;)V", "mViewWidth", "", "mmMenu", "Lcom/tencent/mm/ui/base/MMMenu;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setMenu", "menu", "setOnItemClickListener", "listener", "ViewHolder", "plugin-wxpay_release"})
  public final class b
    extends RecyclerView.a<a>
  {
    m HMj;
    private int aYN;
    AdapterView.OnItemClickListener ars;
    
    public final int getItemCount()
    {
      AppMethodBeat.i(212753);
      m localm = this.HMj;
      if (localm != null)
      {
        int i = localm.size();
        AppMethodBeat.o(212753);
        return i;
      }
      AppMethodBeat.o(212753);
      return 0;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter;Landroid/view/View;)V", "balanceCountTV", "Landroid/widget/TextView;", "getBalanceCountTV", "()Landroid/widget/TextView;", "setBalanceCountTV", "(Landroid/widget/TextView;)V", "rootView", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "totalBalanceTV", "getTotalBalanceTV", "setTotalBalanceTV", "onClick", "", "v", "plugin-wxpay_release"})
    public final class a
      extends RecyclerView.v
      implements View.OnClickListener
    {
      TextView HOm;
      TextView HOn;
      private View lJI;
      
      public a()
      {
        super();
        AppMethodBeat.i(212748);
        ((View)localObject).setOnClickListener((View.OnClickListener)this);
        View localView = ((View)localObject).findViewById(2131306650);
        p.g(localView, "itemView.findViewById(R.…product_balance_count_tv)");
        this.HOm = ((TextView)localView);
        com.tencent.mm.ui.ao.a((Paint)this.HOm.getPaint(), 0.8F);
        c.o(this.HOm, 24);
        localView = ((View)localObject).findViewById(2131306652);
        p.g(localView, "itemView.findViewById(R.…product_total_balance_tv)");
        this.HOn = ((TextView)localView);
        c.o(this.HOn, 14);
        Object localObject = ((View)localObject).findViewById(2131307157);
        p.g(localObject, "itemView.findViewById(R.id.root)");
        this.lJI = ((View)localObject);
        if ((a.a(a.b.this.HOl)) || (com.tencent.mm.ui.ao.isDarkMode())) {
          this.lJI.setBackground(a.b.this.HOl.HOi.getResources().getDrawable(2131235731, null));
        }
        AppMethodBeat.o(212748);
      }
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(212747);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        p.h(paramView, "v");
        localObject = a.b.this.ars;
        if (localObject != null) {
          ((AdapterView.OnItemClickListener)localObject).onItemClick(null, paramView, getPosition(), getPosition());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212747);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$onBindViewHolder$1$func$1"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      b(a.b paramb, int paramInt, a.b.a parama)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onChanged"})
  static final class c<T>
    implements Observer<String>
  {
    c(a parama) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Integer;)V"})
  static final class d<T>
    implements Observer<Integer>
  {
    d(a parama) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "onChanged"})
  static final class e<T>
    implements Observer<com.tencent.mm.plugin.wallet.wecoin.model.a>
  {
    e(a parama) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Long;)V"})
  static final class f<T>
    implements Observer<Long>
  {
    f(a parama) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V"})
  static final class g<T>
    implements Observer<Boolean>
  {
    g(a parama) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeInterceptWinInfo;", "onChanged"})
  static final class h<T>
    implements Observer<com.tencent.mm.plugin.wallet.wecoin.model.d>
  {
    h(a parama) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "Lcom/tencent/mm/protocal/protobuf/WecoinPriceInfo;", "onChanged"})
  static final class i<T>
    implements Observer<List<? extends faz>>
  {
    i(a parama) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$handleInterceptWinInfo$1$clickListener$1", "Lcom/tencent/mm/plugin/wallet/wecoin/model/InterceptWinClickListener;", "onClick", "", "item", "Lcom/tencent/mm/protocal/protobuf/PopUpJumpInfo;", "plugin-wxpay_release"})
  public static final class j
    implements com.tencent.mm.plugin.wallet.wecoin.model.b
  {
    j(String paramString, dep paramdep, a parama, com.tencent.mm.plugin.wallet.wecoin.model.d paramd) {}
    
    public final void a(ddc paramddc)
    {
      AppMethodBeat.i(212761);
      if (paramddc != null)
      {
        if (paramddc.action == 3)
        {
          paramddc = (CharSequence)this.HOq;
          if ((paramddc != null) && (paramddc.length() != 0)) {
            break label80;
          }
        }
        label80:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            a.d(this.HOl).a((Activity)this.HOl.HOi, this.HOr, "release", this.HOq);
          }
          AppMethodBeat.o(212761);
          return;
        }
      }
      AppMethodBeat.o(212761);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212762);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$initHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      a.d(this.HOl).fPF();
      paramView = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
      com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a.reportGiftOnReturn();
      if ((this.HOl.HOj.mScene == 1) && (!a.f(this.HOl)))
      {
        a.g(this.HOl);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$initHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212762);
        return;
      }
      a.h(this.HOl).bMo();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$initHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212762);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class l
    implements b.a
  {
    l(a parama) {}
    
    public final void fPA()
    {
      AppMethodBeat.i(212763);
      if (!a.c(this.HOl))
      {
        a.d(this.HOl).aeH(2);
        Object localObject = a.d(this.HOl).HNa;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.wallet.wecoin.model.e)localObject).HML;
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.wallet.wecoin.a.e)localObject).p(3, -3, "");
            AppMethodBeat.o(212763);
            return;
          }
        }
      }
      AppMethodBeat.o(212763);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class m
    implements DialogInterface.OnCancelListener
  {
    m(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(212764);
      Log.d("MicroMsg.BuyGoodsBottomDialog", "setCancelCallback");
      paramDialogInterface = a.e(this.HOl);
      if (paramDialogInterface != null)
      {
        paramDialogInterface.dhl();
        AppMethodBeat.o(212764);
        return;
      }
      AppMethodBeat.o(212764);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$setAnimationOut$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-wxpay_release"})
  public static final class n
    extends AnimatorListenerAdapter
  {
    n(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(212766);
      p.h(paramAnimator, "animation");
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(212766);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(212767);
      p.h(paramAnimator, "animation");
      paramAnimator = a.h(this.HOl).lJI;
      p.g(paramAnimator, "mBottomSheet.rootView");
      paramAnimator = paramAnimator.getParent();
      if (paramAnimator == null)
      {
        paramAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(212767);
        throw paramAnimator;
      }
      ((ViewGroup)paramAnimator).setVisibility(8);
      this.HOt.post((Runnable)new a(this));
      AppMethodBeat.o(212767);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.n paramn) {}
      
      public final void run()
      {
        AppMethodBeat.i(212765);
        a.h(this.HOu.HOl).bMo();
        AppMethodBeat.o(212765);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class o
    implements DialogInterface.OnCancelListener
  {
    o(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(212768);
      if ((!this.HOl.HOi.isFinishing()) && (!this.HOl.HOi.isDestroyed()))
      {
        paramDialogInterface = a.d(this.HOl);
        Log.i("MicroMsg.RechargeProductsDialogViewModel", "cancelPrepareRecharge, mPrepareCgi: " + paramDialogInterface.HMU);
        Object localObject = paramDialogInterface.HMU;
        if (localObject != null) {
          ((k)localObject).cancel();
        }
        paramDialogInterface.f(3, 2, 0, "");
        paramDialogInterface = a.d(this.HOl);
        Log.i("MicroMsg.RechargeProductsDialogViewModel", "cancelGetPriceListRequest, mGetPriceListCgi: " + paramDialogInterface.HMV);
        localObject = paramDialogInterface.HMV;
        if (localObject != null) {
          ((i)localObject).cancel();
        }
        paramDialogInterface.f(8, 2, 0, "");
        this.HOl.HOi.finish();
      }
      paramDialogInterface = a.i(this.HOl);
      if (paramDialogInterface != null)
      {
        if (paramDialogInterface.isShowing())
        {
          paramDialogInterface.dismiss();
          a.j(this.HOl);
        }
        AppMethodBeat.o(212768);
        return;
      }
      AppMethodBeat.o(212768);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements e.a
  {
    p(a parama, String paramString) {}
    
    public final void bmr()
    {
      AppMethodBeat.i(212769);
      a.d(this.HOl).aeH(8);
      com.tencent.mm.wallet_core.ui.f.p((Context)this.HOl.HOi, this.mkH, true);
      AppMethodBeat.o(212769);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$updateCheckBox$1$1"})
  static final class q
    implements View.OnClickListener
  {
    q(CheckBox paramCheckBox, a parama, Integer paramInteger) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212770);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$updateCheckBox$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.HOv;
      p.g(paramView, "agreementCheckBox");
      if (paramView.isChecked())
      {
        paramView = this.HOv;
        p.g(paramView, "agreementCheckBox");
        paramView.setChecked(false);
        a.d(this.HOl).aeH(4);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$updateCheckBox$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212770);
        return;
      }
      paramView = this.HOv;
      p.g(paramView, "agreementCheckBox");
      paramView.setChecked(true);
      a.d(this.HOl).aeH(3);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$updateCheckBox$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212770);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.a
 * JD-Core Version:    0.7.0.1
 */