package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.r;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.ui.b.a;
import com.tencent.mm.plugin.wallet.wecoin.a.d.a;
import com.tencent.mm.plugin.wallet.wecoin.b.j;
import com.tencent.mm.plugin.wallet.wecoin.c.c;
import com.tencent.mm.plugin.wallet.wecoin.model.e;
import com.tencent.mm.plugin.wallet.wecoin.model.f.c;
import com.tencent.mm.plugin.wallet.wecoin.model.f.d;
import com.tencent.mm.protocal.protobuf.cgl;
import com.tencent.mm.protocal.protobuf.fls;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.ui.f.a;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog;", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "context", "Landroidx/fragment/app/FragmentActivity;", "params", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;)V", "getContext", "()Landroidx/fragment/app/FragmentActivity;", "mBottomSheet", "Lcom/tencent/mm/plugin/wallet/ui/CommonBottomSheet;", "mCancelListener", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog$OnCancelListener;", "mCustomView", "Landroid/view/View;", "mFirstAdapter", "Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter;", "mHeaderView", "mIsItemClicked", "", "mMenuClickListener", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IBtnClickListener;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mSecondAdapter", "mViewModel", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogViewModel;", "getParams", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "showDarkAlways", "bindData", "", "createExitAnimation", "Landroid/animation/Animator;", "dialogView", "handleInterceptWinInfo", "info", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeInterceptWinInfo;", "handleItemClicked", "Lcom/tencent/mm/protocal/protobuf/WecoinPriceInfo;", "initCustomView", "initHeaderView", "initKVData", "initView", "Landroid/content/Context;", "isLandscape", "loadData", "removeObserver", "setAnimationOut", "setDialogCancelListener", "listener", "setMenuClickListener", "shakeIt", "showErrorMsg", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "tryHide", "updateAgreementLinkText", "url", "", "updateCheckBox", "status", "", "(Ljava/lang/Integer;)V", "updatePriceItem", "priceInfo", "", "updateTitleBalance", "balance", "", "(Ljava/lang/Long;)V", "Companion", "RecycleViewAdapter", "plugin-wxpay_release"})
public final class a
  implements com.tencent.mm.plugin.wallet.wecoin.a.d
{
  public static final a.a OGg;
  private final boolean OEF;
  private com.tencent.mm.plugin.wallet.ui.b OFX;
  private final com.tencent.mm.plugin.wallet.wecoin.model.f OFY;
  private b OFZ;
  private b OGa;
  private boolean OGb;
  private d.a OGc;
  private com.tencent.mm.plugin.wallet.wecoin.a.a OGd;
  final FragmentActivity OGe;
  final e OGf;
  private com.tencent.mm.ui.base.s jhZ;
  private View mL;
  private View nX;
  
  static
  {
    AppMethodBeat.i(275674);
    OGg = new a.a((byte)0);
    AppMethodBeat.o(275674);
  }
  
  public a(FragmentActivity paramFragmentActivity, e parame)
  {
    AppMethodBeat.i(275673);
    this.OGe = paramFragmentActivity;
    this.OGf = parame;
    this.OEF = this.OGf.OEF;
    paramFragmentActivity = z.a(this.OGe).i(com.tencent.mm.plugin.wallet.wecoin.model.f.class);
    p.j(paramFragmentActivity, "ViewModelProviders.of(co…logViewModel::class.java)");
    this.OFY = ((com.tencent.mm.plugin.wallet.wecoin.model.f)paramFragmentActivity);
    Object localObject = this.OFY;
    paramFragmentActivity = this.OGf;
    p.k(paramFragmentActivity, "params");
    ((com.tencent.mm.plugin.wallet.wecoin.model.f)localObject).OEW = paramFragmentActivity;
    int i;
    switch (paramFragmentActivity.mScene)
    {
    default: 
      i = -1;
      ((com.tencent.mm.plugin.wallet.wecoin.model.f)localObject).EGw = i;
      ((com.tencent.mm.plugin.wallet.wecoin.model.f)localObject).OEV = ((com.tencent.mm.plugin.wallet.wecoin.model.f)localObject).gIi();
      switch (paramFragmentActivity.mScene)
      {
      default: 
        label172:
        paramFragmentActivity = "";
        label175:
        ((com.tencent.mm.plugin.wallet.wecoin.model.f)localObject).OEU = paramFragmentActivity;
        ((LiveData)this.OFY.OEN).c((androidx.lifecycle.l)this.OGe);
        ((LiveData)this.OFY.tEN).c((androidx.lifecycle.l)this.OGe);
        ((LiveData)this.OFY.OEK).c((androidx.lifecycle.l)this.OGe);
        ((LiveData)this.OFY.OEL).c((androidx.lifecycle.l)this.OGe);
        ((LiveData)this.OFY.OEM).c((androidx.lifecycle.l)this.OGe);
        ((LiveData)this.OFY.OEO).c((androidx.lifecycle.l)this.OGe);
        ((LiveData)this.OFY.OEJ).c((androidx.lifecycle.l)this.OGe);
        paramFragmentActivity = (Context)this.OGe;
        switch (this.OGf.mScene)
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
      this.OFX = paramFragmentActivity;
      paramFragmentActivity = this.OFX;
      if (paramFragmentActivity == null) {
        p.bGy("mBottomSheet");
      }
      paramFragmentActivity.Ca(this.OEF);
      if ((this.OGf.mScene == 1) && (!isLandscape()))
      {
        paramFragmentActivity = this.OFX;
        if (paramFragmentActivity == null) {
          p.bGy("mBottomSheet");
        }
        paramFragmentActivity.gIb();
      }
      paramFragmentActivity = this.OFX;
      if (paramFragmentActivity == null) {
        p.bGy("mBottomSheet");
      }
      paramFragmentActivity.a((b.a)new a.l(this));
      paramFragmentActivity = this.OFX;
      if (paramFragmentActivity == null) {
        p.bGy("mBottomSheet");
      }
      paramFragmentActivity.b((DialogInterface.OnCancelListener)new m(this));
      paramFragmentActivity = View.inflate((Context)this.OGe, com.tencent.mm.plugin.wxpay.a.g.buy_goods_half_dialog_title, null);
      p.j(paramFragmentActivity, "View.inflate(context, R.…_half_dialog_title, null)");
      this.mL = paramFragmentActivity;
      paramFragmentActivity = this.mL;
      if (paramFragmentActivity == null) {
        p.bGy("mHeaderView");
      }
      paramFragmentActivity = paramFragmentActivity.findViewById(com.tencent.mm.plugin.wxpay.a.f.by_goods_half_dialog_title_tv);
      p.j(paramFragmentActivity, "mHeaderView.findViewById…ods_half_dialog_title_tv)");
      paramFragmentActivity = (TextView)paramFragmentActivity;
      parame = this.mL;
      if (parame == null) {
        p.bGy("mHeaderView");
      }
      parame = parame.findViewById(com.tencent.mm.plugin.wxpay.a.f.wecoin_header_back_icon_iv);
      p.j(parame, "mHeaderView.findViewById…coin_header_back_icon_iv)");
      parame = (WeImageView)parame;
      ar.a((Paint)paramFragmentActivity.getPaint(), 0.8F);
      c.p(paramFragmentActivity, 15);
      if ((this.OGf.mScene == 0) || (this.OGf.mScene == 2)) {
        parame.setImageResource(com.tencent.mm.plugin.wxpay.a.h.icons_outlined_close);
      }
      if (this.OEF)
      {
        paramFragmentActivity.setTextColor(this.OGe.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.BW_100_Alpha_0_8));
        parame.setIconColor(this.OGe.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.BW_100_Alpha_0_8));
      }
      paramFragmentActivity = this.OFX;
      if (paramFragmentActivity == null) {
        p.bGy("mBottomSheet");
      }
      localObject = this.mL;
      if (localObject == null) {
        p.bGy("mHeaderView");
      }
      paramFragmentActivity.setHeaderView((View)localObject);
      parame.setOnClickListener((View.OnClickListener)new k(this));
      paramFragmentActivity = new i((Context)this.OGe, 0);
      paramFragmentActivity.t(this.OGe.getResources().getDrawable(com.tencent.mm.plugin.wxpay.a.e.wecoin_recharge_recycler_hor_divider, null));
      parame = View.inflate((Context)this.OGe, com.tencent.mm.plugin.wxpay.a.g.buy_goods_half_dialog_custom_view, null);
      p.j(parame, "View.inflate(context, R.…dialog_custom_view, null)");
      this.nX = parame;
      parame = this.nX;
      if (parame == null) {
        p.bGy("mCustomView");
      }
      parame = parame.findViewById(com.tencent.mm.plugin.wxpay.a.f.bottom_sheet_menu_reccycleview);
      p.j(parame, "mCustomView.findViewById…_sheet_menu_reccycleview)");
      parame = (RecyclerView)parame;
      localObject = new BuyGoodsBottomDialog.initCustomView.layoutManager.1(this);
      ((BuyGoodsBottomDialog.initCustomView.layoutManager.1)localObject).setOrientation(0);
      parame.setLayoutManager((RecyclerView.LayoutManager)localObject);
      parame.b((RecyclerView.h)paramFragmentActivity);
      this.OFZ = new b();
      localObject = this.OFZ;
      if (localObject == null) {
        p.bGy("mFirstAdapter");
      }
      parame.setAdapter((RecyclerView.a)localObject);
      parame = new BuyGoodsBottomDialog.initCustomView.secondLayoutManager.1(this);
      parame.setOrientation(0);
      localObject = this.nX;
      if (localObject == null) {
        p.bGy("mCustomView");
      }
      localObject = ((View)localObject).findViewById(com.tencent.mm.plugin.wxpay.a.f.bottom_sheet_second_reccycleview);
      p.j(localObject, "mCustomView.findViewById…heet_second_reccycleview)");
      localObject = (RecyclerView)localObject;
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)parame);
      ((RecyclerView)localObject).b((RecyclerView.h)paramFragmentActivity);
      this.OGa = new b();
      paramFragmentActivity = this.OGa;
      if (paramFragmentActivity == null) {
        p.bGy("mSecondAdapter");
      }
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)paramFragmentActivity);
      paramFragmentActivity = this.OFX;
      if (paramFragmentActivity == null) {
        p.bGy("mBottomSheet");
      }
      parame = this.nX;
      if (parame == null) {
        p.bGy("mCustomView");
      }
      paramFragmentActivity.setCustomView(parame);
      n(Boolean.TRUE);
      ((LiveData)this.OFY.OEK).a((androidx.lifecycle.l)this.OGe, (androidx.lifecycle.s)new c(this));
      ((LiveData)this.OFY.OEL).a((androidx.lifecycle.l)this.OGe, (androidx.lifecycle.s)new d(this));
      ((LiveData)this.OFY.OEM).a((androidx.lifecycle.l)this.OGe, (androidx.lifecycle.s)new e(this));
      ((LiveData)this.OFY.OEN).a((androidx.lifecycle.l)this.OGe, (androidx.lifecycle.s)new f(this));
      ((LiveData)this.OFY.tEN).a((androidx.lifecycle.l)this.OGe, (androidx.lifecycle.s)new g(this));
      ((LiveData)this.OFY.OEO).a((androidx.lifecycle.l)this.OGe, (androidx.lifecycle.s)new h(this));
      ((LiveData)this.OFY.OEJ).a((androidx.lifecycle.l)this.OGe, (androidx.lifecycle.s)new i(this));
      paramFragmentActivity = this.OFY;
      Log.i("MicroMsg.RechargeProductsDialogViewModel", "getCacheData, isCacheDataLoaded: %s", new Object[] { Boolean.valueOf(paramFragmentActivity.OET) });
      if (!paramFragmentActivity.OET)
      {
        paramFragmentActivity.OET = true;
        paramFragmentActivity.OEP = c.gIt();
        parame = paramFragmentActivity.OEP;
        if (parame != null)
        {
          paramFragmentActivity.OEJ.L(parame.Tny);
          paramFragmentActivity.OEK.L(parame.Tnz);
          paramFragmentActivity.OEL.L(Integer.valueOf(parame.TnA));
          paramFragmentActivity.OES = parame.TnB;
        }
        long l = c.gIq();
        if (l > 0L) {
          paramFragmentActivity.OEN.L(Long.valueOf(l));
        }
      }
      paramFragmentActivity = this.OFY;
      paramFragmentActivity.e(8, 1, 0, "");
      paramFragmentActivity.OER = new j();
      parame = paramFragmentActivity.OER;
      if (parame != null)
      {
        parame = parame.bhW();
        if (parame != null) {
          parame.b((com.tencent.mm.vending.c.a)new f.d(paramFragmentActivity));
        }
      }
      paramFragmentActivity = this.OFY;
      new com.tencent.mm.plugin.wallet.wecoin.b.g().bhW().b((com.tencent.mm.vending.c.a)new f.c(paramFragmentActivity));
      AppMethodBeat.o(275673);
      return;
      i = 2;
      break;
      i = 1;
      break;
      parame = ((com.tencent.mm.plugin.wallet.wecoin.model.f)localObject).OEV;
      paramFragmentActivity = parame;
      if (parame != null) {
        break label175;
      }
      p.bGy("mSessionid");
      paramFragmentActivity = parame;
      break label175;
      parame = paramFragmentActivity.OEG;
      paramFragmentActivity = parame;
      if (parame != null) {
        break label175;
      }
      break label172;
      paramFragmentActivity = new com.tencent.mm.plugin.wallet.ui.b(paramFragmentActivity, 0, 3);
      continue;
      paramFragmentActivity = new com.tencent.mm.plugin.wallet.ui.b(paramFragmentActivity);
    }
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(275664);
    Resources localResources = this.OGe.getResources();
    p.j(localResources, "context.resources");
    if (localResources.getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(275664);
      return true;
    }
    AppMethodBeat.o(275664);
    return false;
  }
  
  private final void n(Boolean paramBoolean)
  {
    AppMethodBeat.i(275662);
    Log.d("MicroMsg.BuyGoodsBottomDialog", "showProgressDialog: ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean == null)
    {
      AppMethodBeat.o(275662);
      return;
    }
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = com.tencent.mm.ui.base.s.a((Context)this.OGe, (CharSequence)this.OGe.getString(com.tencent.mm.plugin.wxpay.a.i.loading_tips), true, 3, (DialogInterface.OnCancelListener)new a.o(this));; paramBoolean = null)
    {
      this.jhZ = paramBoolean;
      AppMethodBeat.o(275662);
      return;
      paramBoolean = this.jhZ;
      if (paramBoolean != null) {
        paramBoolean.dismiss();
      }
    }
  }
  
  public final void a(d.a parama)
  {
    this.OGc = parama;
  }
  
  public final void b(com.tencent.mm.plugin.wallet.wecoin.a.a parama)
  {
    this.OGd = parama;
  }
  
  public final void bYF()
  {
    AppMethodBeat.i(275665);
    com.tencent.mm.plugin.wallet.ui.b localb = this.OFX;
    if (localb == null) {
      p.bGy("mBottomSheet");
    }
    localb.bYF();
    AppMethodBeat.o(275665);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$ViewHolder;", "Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog;", "(Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog;)V", "mItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "getMItemClickListener", "()Landroid/widget/AdapterView$OnItemClickListener;", "setMItemClickListener", "(Landroid/widget/AdapterView$OnItemClickListener;)V", "mViewWidth", "", "mmMenu", "Lcom/tencent/mm/ui/base/MMMenu;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setMenu", "menu", "setOnItemClickListener", "listener", "ViewHolder", "plugin-wxpay_release"})
  public final class b
    extends RecyclerView.a<a>
  {
    o OEf;
    private int aIj;
    AdapterView.OnItemClickListener tp;
    
    public final int getItemCount()
    {
      AppMethodBeat.i(270014);
      o localo = this.OEf;
      if (localo != null)
      {
        int i = localo.size();
        AppMethodBeat.o(270014);
        return i;
      }
      AppMethodBeat.o(270014);
      return 0;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter;Landroid/view/View;)V", "balanceCountTV", "Landroid/widget/TextView;", "getBalanceCountTV", "()Landroid/widget/TextView;", "setBalanceCountTV", "(Landroid/widget/TextView;)V", "rootView", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "totalBalanceTV", "getTotalBalanceTV", "setTotalBalanceTV", "onClick", "", "v", "plugin-wxpay_release"})
    public final class a
      extends RecyclerView.v
      implements View.OnClickListener
    {
      TextView OGi;
      TextView OGj;
      private View oFW;
      
      public a()
      {
        super();
        AppMethodBeat.i(274426);
        ((View)localObject).setOnClickListener((View.OnClickListener)this);
        View localView = ((View)localObject).findViewById(com.tencent.mm.plugin.wxpay.a.f.recharge_product_balance_count_tv);
        p.j(localView, "itemView.findViewById(R.…product_balance_count_tv)");
        this.OGi = ((TextView)localView);
        ar.a((Paint)this.OGi.getPaint(), 0.8F);
        c.p(this.OGi, 24);
        localView = ((View)localObject).findViewById(com.tencent.mm.plugin.wxpay.a.f.recharge_product_total_balance_tv);
        p.j(localView, "itemView.findViewById(R.…product_total_balance_tv)");
        this.OGj = ((TextView)localView);
        c.p(this.OGj, 14);
        Object localObject = ((View)localObject).findViewById(com.tencent.mm.plugin.wxpay.a.f.root);
        p.j(localObject, "itemView.findViewById(R.id.root)");
        this.oFW = ((View)localObject);
        if ((a.a(a.b.this.OGh)) || (ar.isDarkMode())) {
          this.oFW.setBackground(a.b.this.OGh.OGe.getResources().getDrawable(com.tencent.mm.plugin.wxpay.a.e.wecoin_product_bar_dark_bg, null));
        }
        AppMethodBeat.o(274426);
      }
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(274425);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        p.k(paramView, "v");
        localObject = a.b.this.tp;
        if (localObject != null) {
          ((AdapterView.OnItemClickListener)localObject).onItemClick(null, paramView, getPosition(), getPosition());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(274425);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$onBindViewHolder$1$func$1"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(a.b paramb, int paramInt, a.b.a parama)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"})
  static final class c<T>
    implements androidx.lifecycle.s<String>
  {
    c(a parama) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"})
  static final class d<T>
    implements androidx.lifecycle.s<Integer>
  {
    d(a parama) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class e<T>
    implements androidx.lifecycle.s<com.tencent.mm.plugin.wallet.wecoin.model.a>
  {
    e(a parama) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Long;)V"})
  static final class f<T>
    implements androidx.lifecycle.s<Long>
  {
    f(a parama) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"})
  static final class g<T>
    implements androidx.lifecycle.s<Boolean>
  {
    g(a parama) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeInterceptWinInfo;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class h<T>
    implements androidx.lifecycle.s<com.tencent.mm.plugin.wallet.wecoin.model.d>
  {
    h(a parama) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "Lcom/tencent/mm/protocal/protobuf/WecoinPriceInfo;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class i<T>
    implements androidx.lifecycle.s<List<? extends fls>>
  {
    i(a parama) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200211);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$initHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.d(this.OGh).gIj();
      paramView = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.wmq;
      com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a.reportGiftOnReturn();
      if ((this.OGh.OGf.mScene == 1) && (!a.f(this.OGh)))
      {
        a.g(this.OGh);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$initHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(200211);
        return;
      }
      a.h(this.OGh).bYF();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$initHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(200211);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class m
    implements DialogInterface.OnCancelListener
  {
    m(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(189796);
      Log.d("MicroMsg.BuyGoodsBottomDialog", "setCancelCallback");
      paramDialogInterface = a.e(this.OGh);
      if (paramDialogInterface != null)
      {
        paramDialogInterface.dBG();
        AppMethodBeat.o(189796);
        return;
      }
      AppMethodBeat.o(189796);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$setAnimationOut$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-wxpay_release"})
  public static final class n
    extends AnimatorListenerAdapter
  {
    n(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(191224);
      p.k(paramAnimator, "animation");
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(191224);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(191228);
      p.k(paramAnimator, "animation");
      paramAnimator = a.h(this.OGh).oFW;
      p.j(paramAnimator, "mBottomSheet.rootView");
      paramAnimator = paramAnimator.getParent();
      if (paramAnimator == null)
      {
        paramAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(191228);
        throw paramAnimator;
      }
      ((ViewGroup)paramAnimator).setVisibility(8);
      this.OGp.post((Runnable)new a(this));
      AppMethodBeat.o(191228);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.n paramn) {}
      
      public final void run()
      {
        AppMethodBeat.i(266881);
        a.h(this.OGq.OGh).bYF();
        AppMethodBeat.o(266881);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements f.a
  {
    p(a parama, String paramString) {}
    
    public final void bwz()
    {
      AppMethodBeat.i(265942);
      a.d(this.OGh).amu(8);
      com.tencent.mm.wallet_core.ui.g.p((Context)this.OGh.OGe, this.piM, true);
      AppMethodBeat.o(265942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.a
 * JD-Core Version:    0.7.0.1
 */