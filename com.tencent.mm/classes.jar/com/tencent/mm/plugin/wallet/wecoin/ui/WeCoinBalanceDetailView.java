package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.f;
import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinBalanceDetailView;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "mArrivalAccountStateDescTv", "Landroid/widget/TextView;", "mArrivalState", "Landroid/widget/ImageView;", "mArrivalStateTitleTv", "mCftHandleStateDescTv", "mCftHandleStateIv", "mCftHandleStateTitleTv", "mContentLayout", "Landroid/widget/LinearLayout;", "mOrders", "Lcom/tencent/mm/plugin/wallet_core/model/Orders;", "mPaymentStateDescTv", "mPaymentStateIv", "mPaymentStateTitleTv", "mWecoinEncashKVData", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "getLayoutId", "", "initView", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "reportKVStatus", "value", "updateData", "Companion", "plugin-wxpay_release"})
public final class WeCoinBalanceDetailView
  extends MMActivity
{
  public static final WeCoinBalanceDetailView.a HOJ;
  private Orders CwO;
  private ImageView HOA;
  private ImageView HOB;
  private TextView HOC;
  private TextView HOD;
  private TextView HOE;
  private TextView HOF;
  private TextView HOG;
  private TextView HOH;
  private WecoinEncashKVData HOI;
  private ImageView HOz;
  private LinearLayout ncf;
  
  static
  {
    AppMethodBeat.i(212796);
    HOJ = new WeCoinBalanceDetailView.a((byte)0);
    AppMethodBeat.o(212796);
  }
  
  private final void aeH(int paramInt)
  {
    AppMethodBeat.i(212795);
    Object localObject1 = this.HOI;
    if (localObject1 != null) {}
    for (int i = ((WecoinEncashKVData)localObject1).HNZ;; i = 1)
    {
      localObject1 = this.HOI;
      if (localObject1 != null)
      {
        localObject2 = ((WecoinEncashKVData)localObject1).HMK;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      Object localObject2 = this.HOI;
      if (localObject2 != null)
      {
        String str = ((WecoinEncashKVData)localObject2).nZz;
        localObject2 = str;
        if (str != null) {}
      }
      else
      {
        localObject2 = "";
      }
      h.CyF.a(21655, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(paramInt), localObject2 });
      AppMethodBeat.o(212795);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return 2131493199;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(212794);
    Object localObject = getIntent().getParcelableExtra("key_orders");
    p.g(localObject, "intent.getParcelableExtr…WalletProcess.KEY_ORDERS)");
    this.CwO = ((Orders)localObject);
    this.HOI = ((WecoinEncashKVData)getIntent().getParcelableExtra("wecoin_fetch_result_kv_data"));
    localObject = this.CwO;
    if (localObject == null) {
      p.btv("mOrders");
    }
    if (localObject == null)
    {
      Log.w("MicroMsg.WeCoinFetchResultUI", "order is null!");
      finish();
      AppMethodBeat.o(212794);
      return;
    }
    localObject = findViewById(2131297755);
    p.g(localObject, "findViewById(R.id.brdu_state_iv_1)");
    this.HOz = ((ImageView)localObject);
    localObject = findViewById(2131297756);
    p.g(localObject, "findViewById(R.id.brdu_state_iv_2)");
    this.HOA = ((ImageView)localObject);
    localObject = findViewById(2131297757);
    p.g(localObject, "findViewById(R.id.brdu_state_iv_3)");
    this.HOB = ((ImageView)localObject);
    localObject = this.HOz;
    if (localObject == null) {
      p.btv("mPaymentStateIv");
    }
    ((ImageView)localObject).setImageResource(2131231154);
    localObject = this.HOA;
    if (localObject == null) {
      p.btv("mCftHandleStateIv");
    }
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localObject = this.HOA;
    if (localObject == null) {
      p.btv("mCftHandleStateIv");
    }
    ((ImageView)localObject).setImageResource(2131691400);
    localObject = this.HOB;
    if (localObject == null) {
      p.btv("mArrivalState");
    }
    ((ImageView)localObject).setImageResource(2131231155);
    localObject = findViewById(2131297763);
    p.g(localObject, "findViewById(R.id.brdu_state_title_tv_1)");
    this.HOC = ((TextView)localObject);
    localObject = findViewById(2131297764);
    p.g(localObject, "findViewById(R.id.brdu_state_title_tv_2)");
    this.HOD = ((TextView)localObject);
    localObject = findViewById(2131297765);
    p.g(localObject, "findViewById(R.id.brdu_state_title_tv_3)");
    this.HOE = ((TextView)localObject);
    localObject = this.HOC;
    if (localObject == null) {
      p.btv("mPaymentStateTitleTv");
    }
    ((TextView)localObject).setText(2131767441);
    localObject = this.HOD;
    if (localObject == null) {
      p.btv("mCftHandleStateTitleTv");
    }
    ((TextView)localObject).setText(2131768680);
    localObject = this.HOD;
    if (localObject == null) {
      p.btv("mCftHandleStateTitleTv");
    }
    ((TextView)localObject).setTextColor(getResources().getColor(2131100904));
    localObject = this.HOE;
    if (localObject == null) {
      p.btv("mArrivalStateTitleTv");
    }
    ((TextView)localObject).setText(2131767436);
    localObject = findViewById(2131297752);
    p.g(localObject, "findViewById(R.id.brdu_state_desc_tv_1)");
    this.HOF = ((TextView)localObject);
    localObject = findViewById(2131297753);
    p.g(localObject, "findViewById(R.id.brdu_state_desc_tv_2)");
    this.HOG = ((TextView)localObject);
    localObject = findViewById(2131297754);
    p.g(localObject, "findViewById(R.id.brdu_state_desc_tv_3)");
    this.HOH = ((TextView)localObject);
    localObject = findViewById(2131297746);
    p.g(localObject, "findViewById(R.id.brdu_content_layout)");
    this.ncf = ((LinearLayout)localObject);
    localObject = this.HOF;
    if (localObject == null) {
      p.btv("mPaymentStateDescTv");
    }
    ((TextView)localObject).setVisibility(8);
    setActionbarColor(getResources().getColor(2131101424));
    hideActionbarLine();
    setMMTitle(2131768686);
    setBackBtn((MenuItem.OnMenuItemClickListener)new WeCoinBalanceDetailView.b(this));
    AppMethodBeat.o(212794);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(212793);
    aeH(23);
    super.onBackPressed();
    AppMethodBeat.o(212793);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212792);
    super.onCreate(paramBundle);
    initView();
    paramBundle = this.HOG;
    if (paramBundle == null) {
      p.btv("mCftHandleStateDescTv");
    }
    Object localObject = this.CwO;
    if (localObject == null) {
      p.btv("mOrders");
    }
    paramBundle.setText((CharSequence)((Orders)localObject).HYX);
    paramBundle = this.HOG;
    if (paramBundle == null) {
      p.btv("mCftHandleStateDescTv");
    }
    paramBundle.setVisibility(0);
    paramBundle = this.HOH;
    if (paramBundle == null) {
      p.btv("mArrivalAccountStateDescTv");
    }
    paramBundle.setVisibility(8);
    paramBundle = this.ncf;
    if (paramBundle == null) {
      p.btv("mContentLayout");
    }
    paramBundle.setBackgroundResource(2131231153);
    paramBundle = new WalletBalanceFetchResultItemView((Context)this, true);
    localObject = new StringBuilder();
    Orders localOrders = this.CwO;
    if (localOrders == null) {
      p.btv("mOrders");
    }
    double d = f.b(localOrders.dDO, "100", 2, RoundingMode.HALF_UP).doubleValue();
    localObject = this.CwO;
    if (localObject == null) {
      p.btv("mOrders");
    }
    paramBundle.b(2131767464, (CharSequence)f.d(d, ((Orders)localObject).AOl));
    localObject = this.ncf;
    if (localObject == null) {
      p.btv("mContentLayout");
    }
    ((LinearLayout)localObject).addView((View)paramBundle);
    paramBundle = new WalletBalanceFetchResultItemView((Context)this);
    paramBundle.b(2131768679, (CharSequence)getString(2131767415));
    localObject = this.ncf;
    if (localObject == null) {
      p.btv("mContentLayout");
    }
    ((LinearLayout)localObject).addView((View)paramBundle);
    paramBundle = new WalletBalanceFetchResultItemView((Context)this);
    paramBundle.b(2131768682, (CharSequence)getString(2131768681));
    localObject = this.ncf;
    if (localObject == null) {
      p.btv("mContentLayout");
    }
    ((LinearLayout)localObject).addView((View)paramBundle);
    ((Button)findViewById(2131297749)).setOnClickListener((View.OnClickListener)new WeCoinBalanceDetailView.c(this));
    paramBundle = findViewById(2131297767);
    p.g(paramBundle, "findViewById<View>(R.id.brdu_timeline_mask)");
    paramBundle.setVisibility(8);
    paramBundle = findViewById(2131297747);
    p.g(paramBundle, "findViewById<View>(R.id.brdu_content_mask)");
    paramBundle.setVisibility(8);
    AppMethodBeat.o(212792);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinBalanceDetailView
 * JD-Core Version:    0.7.0.1
 */