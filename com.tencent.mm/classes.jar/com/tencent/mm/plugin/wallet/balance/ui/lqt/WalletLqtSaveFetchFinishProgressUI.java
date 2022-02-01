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
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

public class WalletLqtSaveFetchFinishProgressUI
  extends WalletBaseUI
{
  private TextView CkA;
  private TextView CkB;
  private TextView CkC;
  private TextView CkD;
  private ImageView Ckv;
  private ImageView Ckw;
  private ImageView Ckx;
  private TextView Cky;
  private TextView Ckz;
  private dlv HAx;
  private LinearLayout ncf;
  
  public int getLayoutId()
  {
    return 2131493199;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68960);
    this.Ckv = ((ImageView)findViewById(2131297755));
    this.Ckw = ((ImageView)findViewById(2131297756));
    this.Ckx = ((ImageView)findViewById(2131297757));
    this.Ckv.setImageResource(2131231154);
    this.Ckw.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.Ckw.setImageResource(2131691400);
    this.Ckx.setImageResource(2131231155);
    this.Cky = ((TextView)findViewById(2131297763));
    this.Ckz = ((TextView)findViewById(2131297764));
    this.CkA = ((TextView)findViewById(2131297765));
    this.Cky.setText(2131767868);
    this.Ckz.setText(this.HAx.MPv);
    this.Ckz.setTextColor(getResources().getColor(2131100904));
    this.CkA.setText(2131767436);
    this.CkB = ((TextView)findViewById(2131297752));
    this.CkC = ((TextView)findViewById(2131297753));
    this.CkD = ((TextView)findViewById(2131297754));
    this.CkB.setVisibility(8);
    this.CkC.setText(this.HAx.MPw);
    this.CkC.setVisibility(0);
    this.CkD.setVisibility(8);
    this.ncf = ((LinearLayout)findViewById(2131297746));
    this.ncf.setBackgroundResource(2131231153);
    Object localObject1 = new WalletBalanceFetchResultItemView(this, true);
    ((WalletBalanceFetchResultItemView)localObject1).b(2131767935, f.D(this.HAx.MJd / 100.0F));
    this.ncf.addView((View)localObject1);
    if (!Util.isNullOrNil(this.HAx.ynT))
    {
      Object localObject2 = this.HAx.ynT;
      localObject1 = localObject2;
      if (!Util.isNullOrNil(this.HAx.AOk)) {
        localObject1 = (String)localObject2 + " " + getString(2131768133) + this.HAx.AOk;
      }
      localObject2 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject2).b(2131767852, (CharSequence)localObject1);
      this.ncf.addView((View)localObject2);
    }
    if (!Util.isNullOrNil(this.HAx.MPx))
    {
      localObject1 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject1).b(2131767848, this.HAx.MPx);
      this.ncf.addView((View)localObject1);
    }
    ((Button)findViewById(2131297749)).setOnClickListener(new WalletLqtSaveFetchFinishProgressUI.2(this));
    findViewById(2131297767).setVisibility(8);
    findViewById(2131297747).setVisibility(8);
    AppMethodBeat.o(68960);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68959);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getByteArrayExtra("key_redeem_res");
    this.HAx = new dlv();
    try
    {
      this.HAx.parseFrom(paramBundle);
      paramBundle = this.HAx;
      if (paramBundle != null)
      {
        paramBundle = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", new Object[] { Integer.valueOf(paramBundle.status), paramBundle.MPv, paramBundle.MPw, Integer.valueOf(paramBundle.MJd), paramBundle.ynT, paramBundle.AOk, paramBundle.MPx });
        Log.i("MicroMsg.WalletLqtSaveFetchFinishProgressUI", "onCreate, redeemRes: %s", new Object[] { paramBundle });
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131101424)));
        paramBundle = getSupportActionBar().getCustomView();
        if (paramBundle != null)
        {
          View localView = paramBundle.findViewById(2131299682);
          if (localView != null) {
            localView.setBackgroundColor(getResources().getColor(2131100585));
          }
          paramBundle = paramBundle.findViewById(16908308);
          if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
            ((TextView)paramBundle).setTextColor(getResources().getColor(2131100904));
          }
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramBundle = getWindow();
          paramBundle.addFlags(-2147483648);
          paramBundle.setStatusBarColor(getResources().getColor(2131101424));
          if (Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
          }
        }
        getContentView().setFitsSystemWindows(true);
        initView();
        showHomeBtn(false);
        enableBackMenu(false);
        setBackBtnVisible(false);
        setMMTitle(2131767854);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressUI
 * JD-Core Version:    0.7.0.1
 */