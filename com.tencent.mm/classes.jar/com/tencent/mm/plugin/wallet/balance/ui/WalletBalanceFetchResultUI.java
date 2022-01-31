package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WalletBalanceFetchResultUI
  extends WalletBaseUI
{
  private LinearLayout llG;
  private Orders nEh;
  private ImageView nwp;
  private ImageView nwq;
  private ImageView nwr;
  private TextView nws;
  private TextView nwt;
  private TextView nwu;
  private TextView nwv;
  private TextView nww;
  private TextView nwx;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.bank_remit_detail_ui;
  }
  
  protected final void initView()
  {
    this.nwp = ((ImageView)findViewById(a.f.brdu_state_iv_1));
    this.nwq = ((ImageView)findViewById(a.f.brdu_state_iv_2));
    this.nwr = ((ImageView)findViewById(a.f.brdu_state_iv_3));
    this.nwp.setImageResource(a.e.bank_remit_detail_state_circle_succ);
    this.nwq.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.nwq.setImageResource(a.h.remittance_wait);
    this.nwr.setImageResource(a.e.bank_remit_detail_state_circle_unknown);
    this.nws = ((TextView)findViewById(a.f.brdu_state_title_tv_1));
    this.nwt = ((TextView)findViewById(a.f.brdu_state_title_tv_2));
    this.nwu = ((TextView)findViewById(a.f.brdu_state_title_tv_3));
    this.nws.setText(a.i.wallet_balance_launch_fetch_title);
    this.nwt.setText(a.i.wallet_balance_fetch_waiting_title);
    this.nwt.setTextColor(getResources().getColor(a.c.normal_text_color));
    this.nwu.setText(a.i.wallet_balance_fetch_success_title);
    this.nwv = ((TextView)findViewById(a.f.brdu_state_desc_tv_1));
    this.nww = ((TextView)findViewById(a.f.brdu_state_desc_tv_2));
    this.nwx = ((TextView)findViewById(a.f.brdu_state_desc_tv_3));
    this.nwv.setVisibility(8);
    Object localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    this.nww.setText(getString(a.i.wallet_balance_fetch_expect_arrive_time, new Object[] { ((SimpleDateFormat)localObject1).format(new Date(this.nEh.qwH)) }));
    this.nww.setVisibility(0);
    this.nwx.setVisibility(8);
    this.llG = ((LinearLayout)findViewById(a.f.brdu_content_layout));
    this.llG.setBackgroundResource(a.e.bank_remit_detail_desc_singleline_layout_bg);
    localObject1 = new WalletBalanceFetchResultItemView(this, true);
    ((WalletBalanceFetchResultItemView)localObject1).b(a.i.wallet_balance_result_total_fee_fetch, e.d(this.nEh.nCq, this.nEh.mOZ));
    this.llG.addView((View)localObject1);
    if (this.nEh.nyC > 0.0D)
    {
      localObject1 = new WalletBalanceFetchResultItemView(this, true);
      ((WalletBalanceFetchResultItemView)localObject1).b(a.i.wallet_balance_result_charge_fee, e.d(this.nEh.nyC, this.nEh.mOZ));
      this.llG.addView((View)localObject1);
    }
    Object localObject2;
    if ((this.nEh.qwN != null) && (this.nEh.qwN.size() > 0))
    {
      localObject2 = (Orders.Commodity)this.nEh.qwN.get(0);
      localObject1 = ((Orders.Commodity)localObject2).mOX;
      if (bk.bl(((Orders.Commodity)localObject2).qxg)) {
        break label574;
      }
      localObject1 = (String)localObject1 + " " + getString(a.i.wallet_pay_bankcard_tail) + ((Orders.Commodity)localObject2).qxg;
    }
    label574:
    for (;;)
    {
      localObject2 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject2).b(a.i.wallet_balance_fetch_bankcard_title, (CharSequence)localObject1);
      this.llG.addView((View)localObject2);
      ((Button)findViewById(a.f.brdu_finish_btn)).setOnClickListener(new WalletBalanceFetchResultUI.2(this));
      findViewById(a.f.brdu_timeline_mask).setVisibility(8);
      findViewById(a.f.brdu_content_mask).setVisibility(8);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.white)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      View localView = paramBundle.findViewById(a.f.divider);
      if (localView != null) {
        localView.setBackgroundColor(getResources().getColor(a.c.half_alpha_white));
      }
      paramBundle = paramBundle.findViewById(16908308);
      if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
        ((TextView)paramBundle).setTextColor(getResources().getColor(a.c.black));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(a.c.white));
      if (Build.VERSION.SDK_INT >= 23) {
        getWindow().getDecorView().setSystemUiVisibility(8192);
      }
    }
    this.mController.contentView.setFitsSystemWindows(true);
    this.nEh = ((Orders)this.BX.getParcelable("key_orders"));
    if (this.nEh == null)
    {
      y.w("MicroMsg.WalletBalanceFetchResultUI", "order is null!");
      finish();
    }
    initView();
    showHomeBtn(false);
    enableBackMenu(false);
    setMMTitle((String)cNk().vy(0));
    setBackBtn(new WalletBalanceFetchResultUI.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI
 * JD-Core Version:    0.7.0.1
 */