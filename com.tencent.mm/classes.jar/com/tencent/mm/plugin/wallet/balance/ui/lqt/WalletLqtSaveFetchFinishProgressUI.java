package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.dvn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;

public class WalletLqtSaveFetchFinishProgressUI
  extends WalletBaseUI
{
  private ImageView Iho;
  private ImageView Ihp;
  private ImageView Ihq;
  private TextView Ihr;
  private TextView Ihs;
  private TextView Iht;
  private TextView Ihu;
  private TextView Ihv;
  private TextView Ihw;
  private dvn Osn;
  private LinearLayout qct;
  
  public int getLayoutId()
  {
    return a.g.bank_remit_detail_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68960);
    this.Iho = ((ImageView)findViewById(a.f.brdu_state_iv_1));
    this.Ihp = ((ImageView)findViewById(a.f.brdu_state_iv_2));
    this.Ihq = ((ImageView)findViewById(a.f.brdu_state_iv_3));
    this.Iho.setImageResource(a.e.bank_remit_detail_state_circle_succ);
    this.Ihp.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.Ihp.setImageResource(a.h.remittance_wait);
    this.Ihq.setImageResource(a.e.bank_remit_detail_state_circle_unknown);
    this.Ihr = ((TextView)findViewById(a.f.brdu_state_title_tv_1));
    this.Ihs = ((TextView)findViewById(a.f.brdu_state_title_tv_2));
    this.Iht = ((TextView)findViewById(a.f.brdu_state_title_tv_3));
    this.Ihr.setText(a.i.wallet_lqt_launch_fetch_title);
    this.Ihs.setText(this.Osn.Ubz);
    this.Ihs.setTextColor(getResources().getColor(a.c.normal_text_color));
    this.Iht.setText(a.i.wallet_balance_fetch_success_title);
    this.Ihu = ((TextView)findViewById(a.f.brdu_state_desc_tv_1));
    this.Ihv = ((TextView)findViewById(a.f.brdu_state_desc_tv_2));
    this.Ihw = ((TextView)findViewById(a.f.brdu_state_desc_tv_3));
    this.Ihu.setVisibility(8);
    this.Ihv.setText(this.Osn.UbA);
    this.Ihv.setVisibility(0);
    this.Ihw.setVisibility(8);
    this.qct = ((LinearLayout)findViewById(a.f.brdu_content_layout));
    this.qct.setBackgroundResource(a.e.bank_remit_detail_desc_singleline_layout_bg);
    Object localObject1 = new WalletBalanceFetchResultItemView(this, true);
    ((WalletBalanceFetchResultItemView)localObject1).b(a.i.wallet_lqt_result_total_fee_fetch, g.F(this.Osn.TUS / 100.0F));
    this.qct.addView((View)localObject1);
    if (!Util.isNullOrNil(this.Osn.DNV))
    {
      Object localObject2 = this.Osn.DNV;
      localObject1 = localObject2;
      if (!Util.isNullOrNil(this.Osn.GHy)) {
        localObject1 = (String)localObject2 + " " + getString(a.i.wallet_pay_bankcard_tail) + this.Osn.GHy;
      }
      localObject2 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject2).b(a.i.wallet_lqt_fetch_progress_account, (CharSequence)localObject1);
      this.qct.addView((View)localObject2);
    }
    if (!Util.isNullOrNil(this.Osn.UbB))
    {
      localObject1 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject1).b(a.i.wallet_lqt_fetch_failed_wording_mark, this.Osn.UbB);
      this.qct.addView((View)localObject1);
    }
    ((Button)findViewById(a.f.brdu_finish_btn)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68958);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletLqtSaveFetchFinishProgressUI.this.finish();
        a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68958);
      }
    });
    findViewById(a.f.brdu_timeline_mask).setVisibility(8);
    findViewById(a.f.brdu_content_mask).setVisibility(8);
    AppMethodBeat.o(68960);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68959);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getByteArrayExtra("key_redeem_res");
    this.Osn = new dvn();
    try
    {
      this.Osn.parseFrom(paramBundle);
      paramBundle = this.Osn;
      if (paramBundle != null)
      {
        paramBundle = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", new Object[] { Integer.valueOf(paramBundle.status), paramBundle.Ubz, paramBundle.UbA, Integer.valueOf(paramBundle.TUS), paramBundle.DNV, paramBundle.GHy, paramBundle.UbB });
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
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(68957);
            WalletLqtSaveFetchFinishProgressUI.this.finish();
            AppMethodBeat.o(68957);
            return false;
          }
        });
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressUI
 * JD-Core Version:    0.7.0.1
 */