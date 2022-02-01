package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletLqtSaveFetchFinishProgressUI
  extends WalletBaseUI
{
  private cni Bdt;
  private LinearLayout lJf;
  private ImageView wFU;
  private ImageView wFV;
  private ImageView wFW;
  private TextView wFX;
  private TextView wFY;
  private TextView wFZ;
  private TextView wGa;
  private TextView wGb;
  private TextView wGc;
  
  public int getLayoutId()
  {
    return 2131493153;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68960);
    this.wFU = ((ImageView)findViewById(2131297529));
    this.wFV = ((ImageView)findViewById(2131297530));
    this.wFW = ((ImageView)findViewById(2131297531));
    this.wFU.setImageResource(2131231118);
    this.wFV.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.wFV.setImageResource(2131691098);
    this.wFW.setImageResource(2131231119);
    this.wFX = ((TextView)findViewById(2131297537));
    this.wFY = ((TextView)findViewById(2131297538));
    this.wFZ = ((TextView)findViewById(2131297539));
    this.wFX.setText(2131765419);
    this.wFY.setText(this.Bdt.FAz);
    this.wFY.setTextColor(getResources().getColor(2131100711));
    this.wFZ.setText(2131764993);
    this.wGa = ((TextView)findViewById(2131297526));
    this.wGb = ((TextView)findViewById(2131297527));
    this.wGc = ((TextView)findViewById(2131297528));
    this.wGa.setVisibility(8);
    this.wGb.setText(this.Bdt.FAA);
    this.wGb.setVisibility(0);
    this.wGc.setVisibility(8);
    this.lJf = ((LinearLayout)findViewById(2131297520));
    this.lJf.setBackgroundResource(2131231117);
    Object localObject1 = new WalletBalanceFetchResultItemView(this, true);
    ((WalletBalanceFetchResultItemView)localObject1).b(2131765486, e.D(this.Bdt.FuS / 100.0F));
    this.lJf.addView((View)localObject1);
    if (!bs.isNullOrNil(this.Bdt.tGS))
    {
      Object localObject2 = this.Bdt.tGS;
      localObject1 = localObject2;
      if (!bs.isNullOrNil(this.Bdt.vxk)) {
        localObject1 = (String)localObject2 + " " + getString(2131765680) + this.Bdt.vxk;
      }
      localObject2 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject2).b(2131765405, (CharSequence)localObject1);
      this.lJf.addView((View)localObject2);
    }
    if (!bs.isNullOrNil(this.Bdt.FAB))
    {
      localObject1 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject1).b(2131765401, this.Bdt.FAB);
      this.lJf.addView((View)localObject1);
    }
    ((Button)findViewById(2131297523)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68958);
        WalletLqtSaveFetchFinishProgressUI.this.finish();
        AppMethodBeat.o(68958);
      }
    });
    findViewById(2131297541).setVisibility(8);
    findViewById(2131297521).setVisibility(8);
    AppMethodBeat.o(68960);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68959);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getByteArrayExtra("key_redeem_res");
    this.Bdt = new cni();
    try
    {
      this.Bdt.parseFrom(paramBundle);
      paramBundle = this.Bdt;
      if (paramBundle != null)
      {
        paramBundle = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", new Object[] { Integer.valueOf(paramBundle.status), paramBundle.FAz, paramBundle.FAA, Integer.valueOf(paramBundle.FuS), paramBundle.tGS, paramBundle.vxk, paramBundle.FAB });
        ac.i("MicroMsg.WalletLqtSaveFetchFinishProgressUI", "onCreate, redeemRes: %s", new Object[] { paramBundle });
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131101179)));
        paramBundle = getSupportActionBar().getCustomView();
        if (paramBundle != null)
        {
          View localView = paramBundle.findViewById(2131299154);
          if (localView != null) {
            localView.setBackgroundColor(getResources().getColor(2131100483));
          }
          paramBundle = paramBundle.findViewById(16908308);
          if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
            ((TextView)paramBundle).setTextColor(getResources().getColor(2131100711));
          }
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramBundle = getWindow();
          paramBundle.addFlags(-2147483648);
          paramBundle.setStatusBarColor(getResources().getColor(2131101179));
          if (Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
          }
        }
        getContentView().setFitsSystemWindows(true);
        initView();
        showHomeBtn(false);
        enableBackMenu(false);
        setBackBtnVisible(false);
        setMMTitle(2131765406);
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
        ac.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishProgressUI", paramBundle, "parse redeemFundRes error!", new Object[0]);
        finish();
        continue;
        paramBundle = "";
      }
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressUI
 * JD-Core Version:    0.7.0.1
 */