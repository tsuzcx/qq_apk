package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;

public class WalletLqtSaveFetchFinishUI
  extends WalletBaseUI
{
  private Button mqX;
  private TextView qis;
  private WalletTextView qit;
  private TextView qiu;
  private TextView qiv;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    return false;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_lqt_save_fetch_finish_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.qis = ((TextView)findViewById(a.f.succ_wording_tv));
    this.qit = ((WalletTextView)findViewById(a.f.amount_tv));
    this.mqX = ((Button)findViewById(a.f.finish_button));
    this.qiu = ((TextView)findViewById(a.f.profile_wording_tv));
    this.qiv = ((TextView)findViewById(a.f.upgrade_wording_tv));
    int i = getIntent().getIntExtra("key_mode", 1);
    double d = getIntent().getDoubleExtra("key_amount", 0.0D);
    paramBundle = getIntent().getStringExtra("profile_date_wording");
    String str = getIntent().getStringExtra("profile_upgrade_wording");
    if (i == 1)
    {
      this.qis.setText(getString(a.i.wallet_lqt_save_succ_wording));
      setMMTitle(getString(a.i.wallet_lqt_save_succ_wording));
    }
    for (;;)
    {
      this.qit.setText(e.A(d));
      this.mqX.setOnClickListener(new WalletLqtSaveFetchFinishUI.1(this));
      if (!bk.bl(paramBundle))
      {
        this.qiu.setText(paramBundle);
        this.qiu.setVisibility(0);
      }
      if (!bk.bl(str))
      {
        this.qiv.setText(j.d(this, str, (int)this.qiv.getTextSize()));
        this.qiv.setClickable(true);
        this.qiv.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
        this.qiv.setVisibility(0);
      }
      return;
      if (i == 2)
      {
        this.qis.setText(getString(a.i.wallet_lqt_fetch_succ_wording));
        setMMTitle(getString(a.i.wallet_lqt_fetch_succ_wording));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishUI
 * JD-Core Version:    0.7.0.1
 */