package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
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
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bjw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletLqtSaveFetchFinishProgressUI
  extends WalletBaseUI
{
  private LinearLayout llG;
  private ImageView nwp;
  private ImageView nwq;
  private ImageView nwr;
  private TextView nws;
  private TextView nwt;
  private TextView nwu;
  private TextView nwv;
  private TextView nww;
  private TextView nwx;
  private bjw qiq;
  
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
    this.nws.setText(a.i.wallet_lqt_launch_fetch_title);
    this.nwt.setText(this.qiq.tDF);
    this.nwt.setTextColor(getResources().getColor(a.c.normal_text_color));
    this.nwu.setText(a.i.wallet_balance_fetch_success_title);
    this.nwv = ((TextView)findViewById(a.f.brdu_state_desc_tv_1));
    this.nww = ((TextView)findViewById(a.f.brdu_state_desc_tv_2));
    this.nwx = ((TextView)findViewById(a.f.brdu_state_desc_tv_3));
    this.nwv.setVisibility(8);
    this.nww.setText(this.qiq.tDG);
    this.nww.setVisibility(0);
    this.nwx.setVisibility(8);
    this.llG = ((LinearLayout)findViewById(a.f.brdu_content_layout));
    this.llG.setBackgroundResource(a.e.bank_remit_detail_desc_singleline_layout_bg);
    Object localObject1 = new WalletBalanceFetchResultItemView(this, true);
    ((WalletBalanceFetchResultItemView)localObject1).b(a.i.wallet_lqt_result_total_fee_fetch, e.B(this.qiq.tzY / 100.0F));
    this.llG.addView((View)localObject1);
    if (!bk.bl(this.qiq.lnT))
    {
      Object localObject2 = this.qiq.lnT;
      localObject1 = localObject2;
      if (!bk.bl(this.qiq.mOY)) {
        localObject1 = (String)localObject2 + " " + getString(a.i.wallet_pay_bankcard_tail) + this.qiq.mOY;
      }
      localObject2 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject2).b(a.i.wallet_lqt_fetch_progress_account, (CharSequence)localObject1);
      this.llG.addView((View)localObject2);
    }
    if (!bk.bl(this.qiq.tDH))
    {
      localObject1 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject1).b(a.i.wallet_lqt_fetch_failed_wording_mark, this.qiq.tDH);
      this.llG.addView((View)localObject1);
    }
    ((Button)findViewById(a.f.brdu_finish_btn)).setOnClickListener(new WalletLqtSaveFetchFinishProgressUI.2(this));
    findViewById(a.f.brdu_timeline_mask).setVisibility(8);
    findViewById(a.f.brdu_content_mask).setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getByteArrayExtra("key_redeem_res");
    this.qiq = new bjw();
    try
    {
      this.qiq.aH(paramBundle);
      paramBundle = this.qiq;
      if (paramBundle != null)
      {
        paramBundle = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", new Object[] { Integer.valueOf(paramBundle.status), paramBundle.tDF, paramBundle.tDG, Integer.valueOf(paramBundle.tzY), paramBundle.lnT, paramBundle.mOY, paramBundle.tDH });
        y.i("MicroMsg.WalletLqtSaveFetchFinishProgressUI", "onCreate, redeemRes: %s", new Object[] { paramBundle });
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
        initView();
        showHomeBtn(false);
        enableBackMenu(false);
        mT(false);
        setMMTitle(a.i.wallet_lqt_fetch_progress_title);
        setBackBtn(new WalletLqtSaveFetchFinishProgressUI.1(this));
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishProgressUI", paramBundle, "parse redeemFundRes error!", new Object[0]);
        finish();
        continue;
        paramBundle = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressUI
 * JD-Core Version:    0.7.0.1
 */