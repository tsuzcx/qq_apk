package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletWXCreditOpenNotifyUI
  extends WalletBaseUI
{
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_wxcredit_open_notify_ui;
  }
  
  protected final void initView()
  {
    int i = 0;
    setMMTitle(a.i.wallet_wxcredit_open_notify_title);
    showHomeBtn(false);
    enableBackMenu(false);
    addTextOptionMenu(0, getString(a.i.app_finish), new WalletWXCreditOpenNotifyUI.1(this));
    ((TextView)findViewById(a.f.wallet_wxcredit_amount)).setText(com.tencent.mm.wallet_core.ui.e.B(this.BX.getDouble("key_total_amount")));
    Button localButton = (Button)findViewById(a.f.next_btn);
    localButton.setOnClickListener(new WalletWXCreditOpenNotifyUI.2(this));
    if (this.BX.getBoolean("key_can_upgrade_amount", true)) {}
    for (;;)
    {
      localButton.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g.DQ();
    g.DP().Dz().o(196658, Boolean.valueOf(false));
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenNotifyUI
 * JD-Core Version:    0.7.0.1
 */