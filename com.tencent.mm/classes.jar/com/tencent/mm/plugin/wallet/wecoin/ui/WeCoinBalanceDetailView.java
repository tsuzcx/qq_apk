package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.i;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinBalanceDetailView;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "mArrivalAccountStateDescTv", "Landroid/widget/TextView;", "mArrivalState", "Landroid/widget/ImageView;", "mArrivalStateTitleTv", "mCftHandleStateDescTv", "mCftHandleStateIv", "mCftHandleStateTitleTv", "mContentLayout", "Landroid/widget/LinearLayout;", "mOrders", "Lcom/tencent/mm/plugin/wallet_core/model/Orders;", "mPaymentStateDescTv", "mPaymentStateIv", "mPaymentStateTitleTv", "mWecoinEncashKVData", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "getLayoutId", "", "initView", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "reportKVStatus", "value", "updateData", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WeCoinBalanceDetailView
  extends MMActivity
{
  public static final WeCoinBalanceDetailView.a VvT;
  private Orders OsJ;
  private ImageView VvU;
  private ImageView VvV;
  private ImageView VvW;
  private TextView VvX;
  private TextView VvY;
  private TextView VvZ;
  private TextView Vwa;
  private TextView Vwb;
  private TextView Vwc;
  private WecoinEncashKVData Vwd;
  private LinearLayout thn;
  
  static
  {
    AppMethodBeat.i(316075);
    VvT = new WeCoinBalanceDetailView.a((byte)0);
    AppMethodBeat.o(316075);
  }
  
  private static final void a(WeCoinBalanceDetailView paramWeCoinBalanceDetailView, View paramView)
  {
    AppMethodBeat.i(316073);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramWeCoinBalanceDetailView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinBalanceDetailView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramWeCoinBalanceDetailView, "this$0");
    paramWeCoinBalanceDetailView.asf(22);
    paramWeCoinBalanceDetailView.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinBalanceDetailView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316073);
  }
  
  private static final boolean a(WeCoinBalanceDetailView paramWeCoinBalanceDetailView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(316069);
    s.u(paramWeCoinBalanceDetailView, "this$0");
    paramWeCoinBalanceDetailView.asf(23);
    paramWeCoinBalanceDetailView.finish();
    AppMethodBeat.o(316069);
    return false;
  }
  
  private final void asf(int paramInt)
  {
    AppMethodBeat.i(316064);
    Object localObject1 = this.Vwd;
    int i;
    label28:
    Object localObject2;
    if (localObject1 == null)
    {
      i = 1;
      localObject1 = this.Vwd;
      if (localObject1 != null) {
        break label93;
      }
      localObject1 = "";
      localObject2 = this.Vwd;
      if (localObject2 != null) {
        break label113;
      }
      localObject2 = "";
    }
    for (;;)
    {
      h.OAn.b(21655, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(paramInt), localObject2 });
      AppMethodBeat.o(316064);
      return;
      i = ((WecoinEncashKVData)localObject1).Vvz;
      break;
      label93:
      localObject2 = ((WecoinEncashKVData)localObject1).Vua;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label28;
      }
      localObject1 = "";
      break label28;
      label113:
      String str = ((WecoinEncashKVData)localObject2).ugZ;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
    }
  }
  
  public final int getLayoutId()
  {
    return a.g.bank_remit_detail_ui;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(316098);
    Object localObject1 = getIntent().getParcelableExtra("key_orders");
    s.checkNotNull(localObject1);
    s.s(localObject1, "intent.getParcelableExtr…lletProcess.KEY_ORDERS)!!");
    this.OsJ = ((Orders)localObject1);
    this.Vwd = ((WecoinEncashKVData)getIntent().getParcelableExtra("wecoin_fetch_result_kv_data"));
    if (this.OsJ == null) {
      s.bIx("mOrders");
    }
    localObject1 = findViewById(a.f.brdu_state_iv_1);
    s.s(localObject1, "findViewById(R.id.brdu_state_iv_1)");
    this.VvU = ((ImageView)localObject1);
    localObject1 = findViewById(a.f.brdu_state_iv_2);
    s.s(localObject1, "findViewById(R.id.brdu_state_iv_2)");
    this.VvV = ((ImageView)localObject1);
    localObject1 = findViewById(a.f.brdu_state_iv_3);
    s.s(localObject1, "findViewById(R.id.brdu_state_iv_3)");
    this.VvW = ((ImageView)localObject1);
    Object localObject3 = this.VvU;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mPaymentStateIv");
      localObject1 = null;
    }
    ((ImageView)localObject1).setImageResource(a.e.bank_remit_detail_state_circle_succ);
    localObject3 = this.VvV;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mCftHandleStateIv");
      localObject1 = null;
    }
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localObject3 = this.VvV;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mCftHandleStateIv");
      localObject1 = null;
    }
    ((ImageView)localObject1).setImageResource(a.h.remittance_wait);
    localObject3 = this.VvW;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mArrivalState");
      localObject1 = null;
    }
    ((ImageView)localObject1).setImageResource(a.e.bank_remit_detail_state_circle_unknown);
    localObject1 = findViewById(a.f.brdu_state_title_tv_1);
    s.s(localObject1, "findViewById(R.id.brdu_state_title_tv_1)");
    this.VvX = ((TextView)localObject1);
    localObject1 = findViewById(a.f.brdu_state_title_tv_2);
    s.s(localObject1, "findViewById(R.id.brdu_state_title_tv_2)");
    this.VvY = ((TextView)localObject1);
    localObject1 = findViewById(a.f.brdu_state_title_tv_3);
    s.s(localObject1, "findViewById(R.id.brdu_state_title_tv_3)");
    this.VvZ = ((TextView)localObject1);
    localObject3 = this.VvX;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mPaymentStateTitleTv");
      localObject1 = null;
    }
    ((TextView)localObject1).setText(a.i.wallet_balance_launch_fetch_title);
    localObject3 = this.VvY;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mCftHandleStateTitleTv");
      localObject1 = null;
    }
    ((TextView)localObject1).setText(a.i.wecoin_balance_fetch_processing_title);
    localObject3 = this.VvY;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mCftHandleStateTitleTv");
      localObject1 = null;
    }
    ((TextView)localObject1).setTextColor(getResources().getColor(a.c.normal_text_color));
    localObject3 = this.VvZ;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mArrivalStateTitleTv");
      localObject1 = null;
    }
    ((TextView)localObject1).setText(a.i.wecoin_balance_fetch_success_title);
    localObject1 = findViewById(a.f.brdu_state_desc_tv_1);
    s.s(localObject1, "findViewById(R.id.brdu_state_desc_tv_1)");
    this.Vwa = ((TextView)localObject1);
    localObject1 = findViewById(a.f.brdu_state_desc_tv_2);
    s.s(localObject1, "findViewById(R.id.brdu_state_desc_tv_2)");
    this.Vwb = ((TextView)localObject1);
    localObject1 = findViewById(a.f.brdu_state_desc_tv_3);
    s.s(localObject1, "findViewById(R.id.brdu_state_desc_tv_3)");
    this.Vwc = ((TextView)localObject1);
    localObject1 = findViewById(a.f.brdu_content_layout);
    s.s(localObject1, "findViewById(R.id.brdu_content_layout)");
    this.thn = ((LinearLayout)localObject1);
    localObject1 = this.Vwa;
    if (localObject1 == null)
    {
      s.bIx("mPaymentStateDescTv");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((TextView)localObject1).setVisibility(8);
      setActionbarColor(getResources().getColor(a.c.white));
      hideActionbarLine();
      setMMTitle(a.i.wecoin_fetch_balance_result_title);
      setBackBtn(new WeCoinBalanceDetailView..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(316098);
      return;
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(316091);
    asf(23);
    super.onBackPressed();
    AppMethodBeat.o(316091);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Iterator localIterator = null;
    AppMethodBeat.i(316088);
    super.onCreate(paramBundle);
    initView();
    paramBundle = this.Vwb;
    if (paramBundle == null)
    {
      s.bIx("mCftHandleStateDescTv");
      paramBundle = null;
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = this.OsJ;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mOrders");
        localObject1 = null;
      }
      paramBundle.setText((CharSequence)((Orders)localObject1).VGR);
      localObject1 = this.Vwb;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mCftHandleStateDescTv");
        paramBundle = null;
      }
      paramBundle.setVisibility(0);
      localObject1 = this.Vwc;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mArrivalAccountStateDescTv");
        paramBundle = null;
      }
      paramBundle.setVisibility(8);
      localObject1 = this.thn;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mContentLayout");
        paramBundle = null;
      }
      paramBundle.setBackgroundResource(a.e.bank_remit_detail_desc_singleline_layout_bg);
      paramBundle = (com.tencent.mm.bx.a)new anu();
      localObject1 = getIntent().getByteArrayExtra("WECOIN_ENCASH_RESULT_PAGE_INFO");
      try
      {
        paramBundle.parseFrom((byte[])localObject1);
        localObject1 = (anu)paramBundle;
        if (localObject1 == null)
        {
          paramBundle = null;
          if ((paramBundle == null) || (((anu)localObject1).Zvu.size() <= 0)) {
            break label341;
          }
          localIterator = ((anu)localObject1).Zvu.iterator();
          while (localIterator.hasNext())
          {
            paramBundle = (ant)localIterator.next();
            localObject2 = new WalletBalanceFetchResultItemView((Context)this, true);
            ((WalletBalanceFetchResultItemView)localObject2).a(paramBundle.title, (CharSequence)paramBundle.desc);
            localObject1 = this.thn;
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              s.bIx("mContentLayout");
              paramBundle = null;
            }
            paramBundle.addView((View)localObject2);
          }
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
          paramBundle = null;
          continue;
          paramBundle = ((anu)localObject1).Zvu;
        }
        label341:
        localObject2 = new WalletBalanceFetchResultItemView((Context)this, true);
        localObject1 = this.OsJ;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          s.bIx("mOrders");
          paramBundle = null;
        }
        double d = i.b(s.X("", Double.valueOf(paramBundle.hAW)), "100", 2, RoundingMode.HALF_UP).doubleValue();
        int i = a.i.wallet_balance_result_total_fee_fetch;
        localObject1 = this.OsJ;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          s.bIx("mOrders");
          paramBundle = null;
        }
        ((WalletBalanceFetchResultItemView)localObject2).b(i, (CharSequence)i.e(d, paramBundle.MEq));
        paramBundle = this.thn;
        if (paramBundle != null) {
          break label724;
        }
      }
    }
    s.bIx("mContentLayout");
    paramBundle = null;
    paramBundle.addView((View)localObject2);
    Object localObject1 = new WalletBalanceFetchResultItemView((Context)this);
    ((WalletBalanceFetchResultItemView)localObject1).b(getString(a.i.wecoin_balance_fetch_bankcard_amount), (CharSequence)getString(a.i.wecoin_balance_fetch_revenue_desc), getResources().getColor(a.c.normal_color));
    paramBundle = this.thn;
    if (paramBundle == null)
    {
      s.bIx("mContentLayout");
      paramBundle = null;
      label534:
      paramBundle.addView((View)localObject1);
      localObject1 = new WalletBalanceFetchResultItemView((Context)this);
      ((WalletBalanceFetchResultItemView)localObject1).b(getString(a.i.wecoin_balance_fetch_revenue_title), (CharSequence)getString(a.i.wecoin_balance_fetch_revenue_desc), getResources().getColor(a.c.normal_color));
      paramBundle = this.thn;
      if (paramBundle != null) {
        break label730;
      }
      s.bIx("mContentLayout");
      paramBundle = null;
      label605:
      paramBundle.addView((View)localObject1);
      localObject1 = new WalletBalanceFetchResultItemView((Context)this);
      ((WalletBalanceFetchResultItemView)localObject1).b(a.i.wecoin_balance_fetch_bankcard_title, (CharSequence)getString(a.i.wallet_balance_bank_name));
      paramBundle = this.thn;
      if (paramBundle != null) {
        break label733;
      }
      s.bIx("mContentLayout");
      paramBundle = localIterator;
    }
    label724:
    label730:
    label733:
    for (;;)
    {
      paramBundle.addView((View)localObject1);
      ((Button)findViewById(a.f.brdu_finish_btn)).setOnClickListener(new WeCoinBalanceDetailView..ExternalSyntheticLambda1(this));
      findViewById(a.f.brdu_timeline_mask).setVisibility(8);
      findViewById(a.f.brdu_content_mask).setVisibility(8);
      AppMethodBeat.o(316088);
      return;
      break;
      break label534;
      break label605;
    }
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