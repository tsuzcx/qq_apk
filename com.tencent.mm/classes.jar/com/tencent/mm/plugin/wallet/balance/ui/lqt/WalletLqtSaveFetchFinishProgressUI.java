package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.eoj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;

public class WalletLqtSaveFetchFinishProgressUI
  extends WalletBaseUI
{
  private ImageView OdR;
  private ImageView OdS;
  private ImageView OdT;
  private TextView OdU;
  private TextView OdV;
  private TextView OdW;
  private TextView OdX;
  private TextView OdY;
  private TextView OdZ;
  private eoj Vhu;
  private LinearLayout thn;
  
  public int getLayoutId()
  {
    return a.g.bank_remit_detail_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68960);
    this.OdR = ((ImageView)findViewById(a.f.brdu_state_iv_1));
    this.OdS = ((ImageView)findViewById(a.f.brdu_state_iv_2));
    this.OdT = ((ImageView)findViewById(a.f.brdu_state_iv_3));
    this.OdR.setImageResource(a.e.bank_remit_detail_state_circle_succ);
    this.OdS.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.OdS.setImageResource(a.h.remittance_wait);
    this.OdT.setImageResource(a.e.bank_remit_detail_state_circle_unknown);
    this.OdU = ((TextView)findViewById(a.f.brdu_state_title_tv_1));
    this.OdV = ((TextView)findViewById(a.f.brdu_state_title_tv_2));
    this.OdW = ((TextView)findViewById(a.f.brdu_state_title_tv_3));
    this.OdU.setText(a.i.wallet_lqt_launch_fetch_title);
    this.OdV.setText(this.Vhu.absH);
    this.OdV.setTextColor(getResources().getColor(a.c.normal_text_color));
    this.OdW.setText(a.i.wallet_balance_fetch_success_title);
    this.OdX = ((TextView)findViewById(a.f.brdu_state_desc_tv_1));
    this.OdY = ((TextView)findViewById(a.f.brdu_state_desc_tv_2));
    this.OdZ = ((TextView)findViewById(a.f.brdu_state_desc_tv_3));
    this.OdX.setVisibility(8);
    this.OdY.setText(this.Vhu.absI);
    this.OdY.setVisibility(0);
    this.OdZ.setVisibility(8);
    this.thn = ((LinearLayout)findViewById(a.f.brdu_content_layout));
    this.thn.setBackgroundResource(a.e.bank_remit_detail_desc_singleline_layout_bg);
    Object localObject1 = new WalletBalanceFetchResultItemView(this, true);
    ((WalletBalanceFetchResultItemView)localObject1).b(a.i.wallet_lqt_result_total_fee_fetch, i.X(this.Vhu.ablD / 100.0F));
    this.thn.addView((View)localObject1);
    if (!Util.isNullOrNil(this.Vhu.JFk))
    {
      Object localObject2 = this.Vhu.JFk;
      localObject1 = localObject2;
      if (!Util.isNullOrNil(this.Vhu.MEp)) {
        localObject1 = (String)localObject2 + " " + getString(a.i.wallet_pay_bankcard_tail) + this.Vhu.MEp;
      }
      localObject2 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject2).b(a.i.wallet_lqt_fetch_progress_account, (CharSequence)localObject1);
      this.thn.addView((View)localObject2);
    }
    if (!Util.isNullOrNil(this.Vhu.absJ))
    {
      localObject1 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject1).b(a.i.wallet_lqt_fetch_failed_wording_mark, this.Vhu.absJ);
      this.thn.addView((View)localObject1);
    }
    ((Button)findViewById(a.f.brdu_finish_btn)).setOnClickListener(new WalletLqtSaveFetchFinishProgressUI.2(this));
    findViewById(a.f.brdu_timeline_mask).setVisibility(8);
    findViewById(a.f.brdu_content_mask).setVisibility(8);
    AppMethodBeat.o(68960);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68959);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getByteArrayExtra("key_redeem_res");
    this.Vhu = new eoj();
    try
    {
      this.Vhu.parseFrom(paramBundle);
      paramBundle = this.Vhu;
      if (paramBundle != null)
      {
        paramBundle = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", new Object[] { Integer.valueOf(paramBundle.status), paramBundle.absH, paramBundle.absI, Integer.valueOf(paramBundle.ablD), paramBundle.JFk, paramBundle.MEp, paramBundle.absJ });
        Log.i("MicroMsg.WalletLqtSaveFetchFinishProgressUI", "onCreate, redeemRes: %s", new Object[] { paramBundle });
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
            ((TextView)paramBundle).setTextColor(getResources().getColor(a.c.normal_text_color));
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
        getContentView().setFitsSystemWindows(true);
        initView();
        showHomeBtn(false);
        enableBackMenu(false);
        setBackBtnVisible(false);
        setMMTitle(a.i.wallet_lqt_fetch_progress_title);
        setBackBtn(new WalletLqtSaveFetchFinishProgressUI.1(this));
        AppMethodBeat.o(68959);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishProgressUI", paramBundle, "parse redeemFundRes error!", new Object[0]);
        finish();
        continue;
        paramBundle = "";
      }
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressUI
 * JD-Core Version:    0.7.0.1
 */