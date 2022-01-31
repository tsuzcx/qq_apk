package com.tencent.mm.plugin.recharge.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class PhoneRechargeUI$8
  implements DialogInterface.OnClickListener
{
  PhoneRechargeUI$8(PhoneRechargeUI paramPhoneRechargeUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = PhoneRechargeUI.b(this.nrb, this.val$url);
    y.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramDialogInterface });
    PhoneRechargeUI.c(this.nrb, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.8
 * JD-Core Version:    0.7.0.1
 */