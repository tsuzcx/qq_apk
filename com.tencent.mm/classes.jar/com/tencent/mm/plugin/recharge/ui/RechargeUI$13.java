package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;

final class RechargeUI$13
  implements View.OnClickListener
{
  RechargeUI$13(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    if (RechargeUI.e(this.nrE).nqd)
    {
      RechargeUI.e(this.nrE).setInput(null);
      return;
    }
    paramView = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
    this.nrE.startActivityForResult(paramView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.13
 * JD-Core Version:    0.7.0.1
 */