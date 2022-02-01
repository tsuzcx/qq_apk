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
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletLqtSaveFetchFinishProgressUI
  extends WalletBaseUI
{
  private LinearLayout ljn;
  private ImageView vvP;
  private ImageView vvQ;
  private ImageView vvR;
  private TextView vvS;
  private TextView vvT;
  private TextView vvU;
  private TextView vvV;
  private TextView vvW;
  private TextView vvX;
  private cie zLg;
  
  public int getLayoutId()
  {
    return 2131493153;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68960);
    this.vvP = ((ImageView)findViewById(2131297529));
    this.vvQ = ((ImageView)findViewById(2131297530));
    this.vvR = ((ImageView)findViewById(2131297531));
    this.vvP.setImageResource(2131231118);
    this.vvQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.vvQ.setImageResource(2131691098);
    this.vvR.setImageResource(2131231119);
    this.vvS = ((TextView)findViewById(2131297537));
    this.vvT = ((TextView)findViewById(2131297538));
    this.vvU = ((TextView)findViewById(2131297539));
    this.vvS.setText(2131765419);
    this.vvT.setText(this.zLg.EdC);
    this.vvT.setTextColor(getResources().getColor(2131100711));
    this.vvU.setText(2131764993);
    this.vvV = ((TextView)findViewById(2131297526));
    this.vvW = ((TextView)findViewById(2131297527));
    this.vvX = ((TextView)findViewById(2131297528));
    this.vvV.setVisibility(8);
    this.vvW.setText(this.zLg.EdD);
    this.vvW.setVisibility(0);
    this.vvX.setVisibility(8);
    this.ljn = ((LinearLayout)findViewById(2131297520));
    this.ljn.setBackgroundResource(2131231117);
    Object localObject1 = new WalletBalanceFetchResultItemView(this, true);
    ((WalletBalanceFetchResultItemView)localObject1).b(2131765486, e.E(this.zLg.DXY / 100.0F));
    this.ljn.addView((View)localObject1);
    if (!bt.isNullOrNil(this.zLg.szi))
    {
      Object localObject2 = this.zLg.szi;
      localObject1 = localObject2;
      if (!bt.isNullOrNil(this.zLg.uoo)) {
        localObject1 = (String)localObject2 + " " + getString(2131765680) + this.zLg.uoo;
      }
      localObject2 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject2).b(2131765405, (CharSequence)localObject1);
      this.ljn.addView((View)localObject2);
    }
    if (!bt.isNullOrNil(this.zLg.EdE))
    {
      localObject1 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject1).b(2131765401, this.zLg.EdE);
      this.ljn.addView((View)localObject1);
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
    this.zLg = new cie();
    try
    {
      this.zLg.parseFrom(paramBundle);
      paramBundle = this.zLg;
      if (paramBundle != null)
      {
        paramBundle = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", new Object[] { Integer.valueOf(paramBundle.status), paramBundle.EdC, paramBundle.EdD, Integer.valueOf(paramBundle.DXY), paramBundle.szi, paramBundle.uoo, paramBundle.EdE });
        ad.i("MicroMsg.WalletLqtSaveFetchFinishProgressUI", "onCreate, redeemRes: %s", new Object[] { paramBundle });
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
        ad.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishProgressUI", paramBundle, "parse redeemFundRes error!", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressUI
 * JD-Core Version:    0.7.0.1
 */