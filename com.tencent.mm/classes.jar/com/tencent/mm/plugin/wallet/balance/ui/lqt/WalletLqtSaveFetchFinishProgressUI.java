package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.protocal.protobuf.bsv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletLqtSaveFetchFinishProgressUI
  extends WalletBaseUI
{
  private LinearLayout iCt;
  private ImageView qhr;
  private ImageView qhs;
  private ImageView qht;
  private TextView qhu;
  private TextView qhv;
  private TextView qhw;
  private TextView qhx;
  private TextView qhy;
  private TextView qhz;
  private bsv tRl;
  
  public int getLayoutId()
  {
    return 2130968821;
  }
  
  public void initView()
  {
    AppMethodBeat.i(45637);
    this.qhr = ((ImageView)findViewById(2131821685));
    this.qhs = ((ImageView)findViewById(2131821689));
    this.qht = ((ImageView)findViewById(2131821693));
    this.qhr.setImageResource(2130837847);
    this.qhs.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.qhs.setImageResource(2131231926);
    this.qht.setImageResource(2130837848);
    this.qhu = ((TextView)findViewById(2131821686));
    this.qhv = ((TextView)findViewById(2131821690));
    this.qhw = ((TextView)findViewById(2131821694));
    this.qhu.setText(2131305217);
    this.qhv.setText(this.tRl.xGt);
    this.qhv.setTextColor(getResources().getColor(2131690322));
    this.qhw.setText(2131304810);
    this.qhx = ((TextView)findViewById(2131821687));
    this.qhy = ((TextView)findViewById(2131821691));
    this.qhz = ((TextView)findViewById(2131821695));
    this.qhx.setVisibility(8);
    this.qhy.setText(this.tRl.xGu);
    this.qhy.setVisibility(0);
    this.qhz.setVisibility(8);
    this.iCt = ((LinearLayout)findViewById(2131821698));
    this.iCt.setBackgroundResource(2130837846);
    Object localObject1 = new WalletBalanceFetchResultItemView(this, true);
    ((WalletBalanceFetchResultItemView)localObject1).b(2131305276, e.F(this.tRl.xBA / 100.0F));
    this.iCt.addView((View)localObject1);
    if (!bo.isNullOrNil(this.tRl.nLq))
    {
      Object localObject2 = this.tRl.nLq;
      localObject1 = localObject2;
      if (!bo.isNullOrNil(this.tRl.ppo)) {
        localObject1 = (String)localObject2 + " " + getString(2131305466) + this.tRl.ppo;
      }
      localObject2 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject2).b(2131305205, (CharSequence)localObject1);
      this.iCt.addView((View)localObject2);
    }
    if (!bo.isNullOrNil(this.tRl.xGv))
    {
      localObject1 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject1).b(2131305201, this.tRl.xGv);
      this.iCt.addView((View)localObject1);
    }
    ((Button)findViewById(2131821701)).setOnClickListener(new WalletLqtSaveFetchFinishProgressUI.2(this));
    findViewById(2131821696).setVisibility(8);
    findViewById(2131821699).setVisibility(8);
    AppMethodBeat.o(45637);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45636);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getByteArrayExtra("key_redeem_res");
    this.tRl = new bsv();
    try
    {
      this.tRl.parseFrom(paramBundle);
      paramBundle = this.tRl;
      if (paramBundle != null)
      {
        paramBundle = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", new Object[] { Integer.valueOf(paramBundle.status), paramBundle.xGt, paramBundle.xGu, Integer.valueOf(paramBundle.xBA), paramBundle.nLq, paramBundle.ppo, paramBundle.xGv });
        ab.i("MicroMsg.WalletLqtSaveFetchFinishProgressUI", "onCreate, redeemRes: %s", new Object[] { paramBundle });
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131690709)));
        paramBundle = getSupportActionBar().getCustomView();
        if (paramBundle != null)
        {
          View localView = paramBundle.findViewById(2131821148);
          if (localView != null) {
            localView.setBackgroundColor(getResources().getColor(2131690161));
          }
          paramBundle = paramBundle.findViewById(16908308);
          if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
            ((TextView)paramBundle).setTextColor(getResources().getColor(2131689763));
          }
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramBundle = getWindow();
          paramBundle.addFlags(-2147483648);
          paramBundle.setStatusBarColor(getResources().getColor(2131690709));
          if (Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
          }
        }
        getContentView().setFitsSystemWindows(true);
        initView();
        showHomeBtn(false);
        enableBackMenu(false);
        setBackBtnVisible(false);
        setMMTitle(2131305206);
        setBackBtn(new WalletLqtSaveFetchFinishProgressUI.1(this));
        AppMethodBeat.o(45636);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishProgressUI", paramBundle, "parse redeemFundRes error!", new Object[0]);
        finish();
        continue;
        paramBundle = "";
      }
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressUI
 * JD-Core Version:    0.7.0.1
 */