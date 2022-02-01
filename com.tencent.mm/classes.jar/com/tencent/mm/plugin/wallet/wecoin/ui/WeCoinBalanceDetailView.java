package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.g;
import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinBalanceDetailView;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "mArrivalAccountStateDescTv", "Landroid/widget/TextView;", "mArrivalState", "Landroid/widget/ImageView;", "mArrivalStateTitleTv", "mCftHandleStateDescTv", "mCftHandleStateIv", "mCftHandleStateTitleTv", "mContentLayout", "Landroid/widget/LinearLayout;", "mOrders", "Lcom/tencent/mm/plugin/wallet_core/model/Orders;", "mPaymentStateDescTv", "mPaymentStateIv", "mPaymentStateTitleTv", "mWecoinEncashKVData", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "getLayoutId", "", "initView", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "reportKVStatus", "value", "updateData", "Companion", "plugin-wxpay_release"})
public final class WeCoinBalanceDetailView
  extends MMActivity
{
  public static final WeCoinBalanceDetailView.a OGF;
  private Orders Ivh;
  private TextView OGA;
  private TextView OGB;
  private TextView OGC;
  private TextView OGD;
  private WecoinEncashKVData OGE;
  private ImageView OGv;
  private ImageView OGw;
  private ImageView OGx;
  private TextView OGy;
  private TextView OGz;
  private LinearLayout qct;
  
  static
  {
    AppMethodBeat.i(187683);
    OGF = new WeCoinBalanceDetailView.a((byte)0);
    AppMethodBeat.o(187683);
  }
  
  private final void amu(int paramInt)
  {
    AppMethodBeat.i(187680);
    Object localObject1 = this.OGE;
    if (localObject1 != null) {}
    for (int i = ((WecoinEncashKVData)localObject1).OFV;; i = 1)
    {
      localObject1 = this.OGE;
      if (localObject1 != null)
      {
        localObject2 = ((WecoinEncashKVData)localObject1).OEG;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      Object localObject2 = this.OGE;
      if (localObject2 != null)
      {
        String str = ((WecoinEncashKVData)localObject2).rbk;
        localObject2 = str;
        if (str != null) {}
      }
      else
      {
        localObject2 = "";
      }
      h.IzE.a(21655, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(paramInt), localObject2 });
      AppMethodBeat.o(187680);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return a.g.bank_remit_detail_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(187678);
    Object localObject = getIntent().getParcelableExtra("key_orders");
    p.j(localObject, "intent.getParcelableExtr…WalletProcess.KEY_ORDERS)");
    this.Ivh = ((Orders)localObject);
    this.OGE = ((WecoinEncashKVData)getIntent().getParcelableExtra("wecoin_fetch_result_kv_data"));
    localObject = this.Ivh;
    if (localObject == null) {
      p.bGy("mOrders");
    }
    if (localObject == null)
    {
      Log.w("MicroMsg.WeCoinFetchResultUI", "order is null!");
      finish();
      AppMethodBeat.o(187678);
      return;
    }
    localObject = findViewById(a.f.brdu_state_iv_1);
    p.j(localObject, "findViewById(R.id.brdu_state_iv_1)");
    this.OGv = ((ImageView)localObject);
    localObject = findViewById(a.f.brdu_state_iv_2);
    p.j(localObject, "findViewById(R.id.brdu_state_iv_2)");
    this.OGw = ((ImageView)localObject);
    localObject = findViewById(a.f.brdu_state_iv_3);
    p.j(localObject, "findViewById(R.id.brdu_state_iv_3)");
    this.OGx = ((ImageView)localObject);
    localObject = this.OGv;
    if (localObject == null) {
      p.bGy("mPaymentStateIv");
    }
    ((ImageView)localObject).setImageResource(a.e.bank_remit_detail_state_circle_succ);
    localObject = this.OGw;
    if (localObject == null) {
      p.bGy("mCftHandleStateIv");
    }
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localObject = this.OGw;
    if (localObject == null) {
      p.bGy("mCftHandleStateIv");
    }
    ((ImageView)localObject).setImageResource(a.h.remittance_wait);
    localObject = this.OGx;
    if (localObject == null) {
      p.bGy("mArrivalState");
    }
    ((ImageView)localObject).setImageResource(a.e.bank_remit_detail_state_circle_unknown);
    localObject = findViewById(a.f.brdu_state_title_tv_1);
    p.j(localObject, "findViewById(R.id.brdu_state_title_tv_1)");
    this.OGy = ((TextView)localObject);
    localObject = findViewById(a.f.brdu_state_title_tv_2);
    p.j(localObject, "findViewById(R.id.brdu_state_title_tv_2)");
    this.OGz = ((TextView)localObject);
    localObject = findViewById(a.f.brdu_state_title_tv_3);
    p.j(localObject, "findViewById(R.id.brdu_state_title_tv_3)");
    this.OGA = ((TextView)localObject);
    localObject = this.OGy;
    if (localObject == null) {
      p.bGy("mPaymentStateTitleTv");
    }
    ((TextView)localObject).setText(a.i.wallet_balance_launch_fetch_title);
    localObject = this.OGz;
    if (localObject == null) {
      p.bGy("mCftHandleStateTitleTv");
    }
    ((TextView)localObject).setText(a.i.wecoin_balance_fetch_processing_title);
    localObject = this.OGz;
    if (localObject == null) {
      p.bGy("mCftHandleStateTitleTv");
    }
    ((TextView)localObject).setTextColor(getResources().getColor(a.c.normal_text_color));
    localObject = this.OGA;
    if (localObject == null) {
      p.bGy("mArrivalStateTitleTv");
    }
    ((TextView)localObject).setText(a.i.wecoin_balance_fetch_success_title);
    localObject = findViewById(a.f.brdu_state_desc_tv_1);
    p.j(localObject, "findViewById(R.id.brdu_state_desc_tv_1)");
    this.OGB = ((TextView)localObject);
    localObject = findViewById(a.f.brdu_state_desc_tv_2);
    p.j(localObject, "findViewById(R.id.brdu_state_desc_tv_2)");
    this.OGC = ((TextView)localObject);
    localObject = findViewById(a.f.brdu_state_desc_tv_3);
    p.j(localObject, "findViewById(R.id.brdu_state_desc_tv_3)");
    this.OGD = ((TextView)localObject);
    localObject = findViewById(a.f.brdu_content_layout);
    p.j(localObject, "findViewById(R.id.brdu_content_layout)");
    this.qct = ((LinearLayout)localObject);
    localObject = this.OGB;
    if (localObject == null) {
      p.bGy("mPaymentStateDescTv");
    }
    ((TextView)localObject).setVisibility(8);
    setActionbarColor(getResources().getColor(a.c.white));
    hideActionbarLine();
    setMMTitle(a.i.wecoin_fetch_balance_result_title);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    AppMethodBeat.o(187678);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(187675);
    amu(23);
    super.onBackPressed();
    AppMethodBeat.o(187675);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(187674);
    super.onCreate(paramBundle);
    initView();
    paramBundle = this.OGC;
    if (paramBundle == null) {
      p.bGy("mCftHandleStateDescTv");
    }
    Object localObject = this.Ivh;
    if (localObject == null) {
      p.bGy("mOrders");
    }
    paramBundle.setText((CharSequence)((Orders)localObject).OQX);
    paramBundle = this.OGC;
    if (paramBundle == null) {
      p.bGy("mCftHandleStateDescTv");
    }
    paramBundle.setVisibility(0);
    paramBundle = this.OGD;
    if (paramBundle == null) {
      p.bGy("mArrivalAccountStateDescTv");
    }
    paramBundle.setVisibility(8);
    paramBundle = this.qct;
    if (paramBundle == null) {
      p.bGy("mContentLayout");
    }
    paramBundle.setBackgroundResource(a.e.bank_remit_detail_desc_singleline_layout_bg);
    paramBundle = new WalletBalanceFetchResultItemView((Context)this, true);
    localObject = new StringBuilder();
    Orders localOrders = this.Ivh;
    if (localOrders == null) {
      p.bGy("mOrders");
    }
    double d = g.b(localOrders.fwy, "100", 2, RoundingMode.HALF_UP).doubleValue();
    int i = a.i.wallet_balance_result_total_fee_fetch;
    localObject = this.Ivh;
    if (localObject == null) {
      p.bGy("mOrders");
    }
    paramBundle.b(i, (CharSequence)g.d(d, ((Orders)localObject).GHz));
    localObject = this.qct;
    if (localObject == null) {
      p.bGy("mContentLayout");
    }
    ((LinearLayout)localObject).addView((View)paramBundle);
    paramBundle = new WalletBalanceFetchResultItemView((Context)this);
    paramBundle.b(getString(a.i.wecoin_balance_fetch_bankcard_amount), (CharSequence)getString(a.i.wecoin_balance_fetch_revenue_desc), getResources().getColor(a.c.normal_color));
    localObject = this.qct;
    if (localObject == null) {
      p.bGy("mContentLayout");
    }
    ((LinearLayout)localObject).addView((View)paramBundle);
    paramBundle = new WalletBalanceFetchResultItemView((Context)this);
    paramBundle.b(getString(a.i.wecoin_balance_fetch_revenue_title), (CharSequence)getString(a.i.wecoin_balance_fetch_revenue_desc), getResources().getColor(a.c.normal_color));
    localObject = this.qct;
    if (localObject == null) {
      p.bGy("mContentLayout");
    }
    ((LinearLayout)localObject).addView((View)paramBundle);
    paramBundle = new WalletBalanceFetchResultItemView((Context)this);
    paramBundle.b(a.i.wecoin_balance_fetch_bankcard_title, (CharSequence)getString(a.i.wallet_balance_bank_name));
    localObject = this.qct;
    if (localObject == null) {
      p.bGy("mContentLayout");
    }
    ((LinearLayout)localObject).addView((View)paramBundle);
    ((Button)findViewById(a.f.brdu_finish_btn)).setOnClickListener((View.OnClickListener)new c(this));
    paramBundle = findViewById(a.f.brdu_timeline_mask);
    p.j(paramBundle, "findViewById<View>(R.id.brdu_timeline_mask)");
    paramBundle.setVisibility(8);
    paramBundle = findViewById(a.f.brdu_content_mask);
    p.j(paramBundle, "findViewById<View>(R.id.brdu_content_mask)");
    paramBundle.setVisibility(8);
    AppMethodBeat.o(187674);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(WeCoinBalanceDetailView paramWeCoinBalanceDetailView) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(273386);
      WeCoinBalanceDetailView.a(this.OGH, 23);
      this.OGH.finish();
      AppMethodBeat.o(273386);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(WeCoinBalanceDetailView paramWeCoinBalanceDetailView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(186832);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinBalanceDetailView$updateData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      WeCoinBalanceDetailView.a(this.OGH, 22);
      this.OGH.finish();
      a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinBalanceDetailView$updateData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(186832);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinBalanceDetailView
 * JD-Core Version:    0.7.0.1
 */