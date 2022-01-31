package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;

final class PhoneRechargeUI$15
  implements View.OnClickListener
{
  PhoneRechargeUI$15(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    if (this.nrb.getPackageManager().checkPermission("android.permission.READ_CONTACTS", ae.getPackageName()) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramView = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
      if (bk.i(this.nrb, paramView)) {
        this.nrb.startActivityForResult(paramView, 1);
      }
      return;
    }
    h.b(this.nrb, this.nrb.getString(a.i.wallet_recharge_no_permission), "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.15
 * JD-Core Version:    0.7.0.1
 */