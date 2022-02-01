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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

public class WalletLqtSaveFetchFinishProgressUI
  extends WalletBaseUI
{
  private ctf CVn;
  private LinearLayout lUw;
  private TextView yjA;
  private TextView yjB;
  private TextView yjC;
  private ImageView yju;
  private ImageView yjv;
  private ImageView yjw;
  private TextView yjx;
  private TextView yjy;
  private TextView yjz;
  
  public int getLayoutId()
  {
    return 2131493153;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68960);
    this.yju = ((ImageView)findViewById(2131297529));
    this.yjv = ((ImageView)findViewById(2131297530));
    this.yjw = ((ImageView)findViewById(2131297531));
    this.yju.setImageResource(2131231118);
    this.yjv.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.yjv.setImageResource(2131691098);
    this.yjw.setImageResource(2131231119);
    this.yjx = ((TextView)findViewById(2131297537));
    this.yjy = ((TextView)findViewById(2131297538));
    this.yjz = ((TextView)findViewById(2131297539));
    this.yjx.setText(2131765419);
    this.yjy.setText(this.CVn.HEn);
    this.yjy.setTextColor(getResources().getColor(2131100711));
    this.yjz.setText(2131764993);
    this.yjA = ((TextView)findViewById(2131297526));
    this.yjB = ((TextView)findViewById(2131297527));
    this.yjC = ((TextView)findViewById(2131297528));
    this.yjA.setVisibility(8);
    this.yjB.setText(this.CVn.HEo);
    this.yjB.setVisibility(0);
    this.yjC.setVisibility(8);
    this.lUw = ((LinearLayout)findViewById(2131297520));
    this.lUw.setBackgroundResource(2131231117);
    Object localObject1 = new WalletBalanceFetchResultItemView(this, true);
    ((WalletBalanceFetchResultItemView)localObject1).b(2131765486, f.D(this.CVn.Hyx / 100.0F));
    this.lUw.addView((View)localObject1);
    if (!bu.isNullOrNil(this.CVn.uVs))
    {
      Object localObject2 = this.CVn.uVs;
      localObject1 = localObject2;
      if (!bu.isNullOrNil(this.CVn.wSp)) {
        localObject1 = (String)localObject2 + " " + getString(2131765680) + this.CVn.wSp;
      }
      localObject2 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject2).b(2131765405, (CharSequence)localObject1);
      this.lUw.addView((View)localObject2);
    }
    if (!bu.isNullOrNil(this.CVn.HEp))
    {
      localObject1 = new WalletBalanceFetchResultItemView(this);
      ((WalletBalanceFetchResultItemView)localObject1).b(2131765401, this.CVn.HEp);
      this.lUw.addView((View)localObject1);
    }
    ((Button)findViewById(2131297523)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68958);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    this.CVn = new ctf();
    try
    {
      this.CVn.parseFrom(paramBundle);
      paramBundle = this.CVn;
      if (paramBundle != null)
      {
        paramBundle = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", new Object[] { Integer.valueOf(paramBundle.status), paramBundle.HEn, paramBundle.HEo, Integer.valueOf(paramBundle.Hyx), paramBundle.uVs, paramBundle.wSp, paramBundle.HEp });
        ae.i("MicroMsg.WalletLqtSaveFetchFinishProgressUI", "onCreate, redeemRes: %s", new Object[] { paramBundle });
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
        ae.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishProgressUI", paramBundle, "parse redeemFundRes error!", new Object[0]);
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