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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletLqtSaveFetchFinishProgressUI
  extends WalletBaseUI
{
  private csl CDH;
  private LinearLayout lPV;
  private ImageView xTB;
  private ImageView xTC;
  private ImageView xTD;
  private TextView xTE;
  private TextView xTF;
  private TextView xTG;
  private TextView xTH;
  private TextView xTI;
  private TextView xTJ;
  
  public int getLayoutId()
  {
    return 2131493153;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68960);
    this.xTB = ((ImageView)findViewById(2131297529));
    this.xTC = ((ImageView)findViewById(2131297530));
    this.xTD = ((ImageView)findViewById(2131297531));
    this.xTB.setImageResource(2131231118);
    this.xTC.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.xTC.setImageResource(2131691098);
    this.xTD.setImageResource(2131231119);
    this.xTE = ((TextView)findViewById(2131297537));
    this.xTF = ((TextView)findViewById(2131297538));
    this.xTG = ((TextView)findViewById(2131297539));
    this.xTE.setText(2131765419);
    this.xTF.setText(this.CDH.HkN);
    this.xTF.setTextColor(getResources().getColor(2131100711));
    this.xTG.setText(2131764993);
    this.xTH = ((TextView)findViewById(2131297526));
    this.xTI = ((TextView)findViewById(2131297527));
    this.xTJ = ((TextView)findViewById(2131297528));
    this.xTH.setVisibility(8);
    this.xTI.setText(this.CDH.HkO);
    this.xTI.setVisibility(0);
    this.xTJ.setVisibility(8);
    this.lPV = ((LinearLayout)findViewById(2131297520));
    this.lPV.setBackgroundResource(2131231117);
    Object localObject1 = new WalletBalanceFetchResultItemView(this, true);
    ((WalletBalanceFetchResultItemView)localObject1).b(2131765486, e.D(this.CDH.HeX / 100.0F));
    this.lPV.addView((View)localObject1);
    if (!bt.isNullOrNil(this.CDH.uJF))
    {
      Object localObject2 = this.CDH.uJF;
      localObject1 = localObject2;
      if (!bt.isNullOrNil(this.CDH.wCE)) {
        localObject1 = (String)localObject2 + " " + getString(2131765680) + this.CDH.wCE;
      }
      localObject2 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject2).b(2131765405, (CharSequence)localObject1);
      this.lPV.addView((View)localObject2);
    }
    if (!bt.isNullOrNil(this.CDH.HkP))
    {
      localObject1 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject1).b(2131765401, this.CDH.HkP);
      this.lPV.addView((View)localObject1);
    }
    ((Button)findViewById(2131297523)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68958);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletLqtSaveFetchFinishProgressUI.this.finish();
        a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    this.CDH = new csl();
    try
    {
      this.CDH.parseFrom(paramBundle);
      paramBundle = this.CDH;
      if (paramBundle != null)
      {
        paramBundle = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", new Object[] { Integer.valueOf(paramBundle.status), paramBundle.HkN, paramBundle.HkO, Integer.valueOf(paramBundle.HeX), paramBundle.uJF, paramBundle.wCE, paramBundle.HkP });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressUI
 * JD-Core Version:    0.7.0.1
 */