package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.model.y;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class RemittanceResendMsgUI
  extends WalletBaseUI
{
  public boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof y))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.bC(this, getString(a.i.remittance_resended));
        finish();
        return true;
      }
      h.bC(this, paramString);
      finish();
      return true;
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void j(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramString1 = new y(paramString1, paramString2, paramInt1, paramInt2);
    paramString1.dIA = "RemittanceProcess";
    a(paramString1, true, true);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.contentView.setVisibility(8);
    setTitleVisibility(8);
    paramBundle = getIntent().getStringExtra("transaction_id");
    String str = getIntent().getStringExtra("receiver_name");
    int i = getIntent().getIntExtra("resend_msg_from_flag", 1);
    int j = getIntent().getIntExtra("invalid_time", 0);
    if (!bk.bl(str)) {
      j(paramBundle, str, j, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI
 * JD-Core Version:    0.7.0.1
 */