package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.bt;

final class PhoneRechargeUI$16
  implements View.OnClickListener
{
  PhoneRechargeUI$16(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67178);
    if (b.a(this.uYi.getContext(), "android.permission.READ_CONTACTS", 48, null, null))
    {
      paramView = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
      if (bt.T(this.uYi, paramView)) {
        this.uYi.startActivityForResult(paramView, 1);
      }
    }
    AppMethodBeat.o(67178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.16
 * JD-Core Version:    0.7.0.1
 */