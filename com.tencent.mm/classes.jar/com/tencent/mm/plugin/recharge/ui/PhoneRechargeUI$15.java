package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.bo;

final class PhoneRechargeUI$15
  implements View.OnClickListener
{
  PhoneRechargeUI$15(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44269);
    if (b.a(this.pWp.getContext(), "android.permission.READ_CONTACTS", 48, null, null))
    {
      paramView = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
      if (bo.k(this.pWp, paramView)) {
        this.pWp.startActivityForResult(paramView, 1);
      }
    }
    AppMethodBeat.o(44269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.15
 * JD-Core Version:    0.7.0.1
 */