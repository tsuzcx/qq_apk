package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.Util;

final class PhoneRechargeUI$15
  implements View.OnClickListener
{
  PhoneRechargeUI$15(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67178);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (com.tencent.mm.pluginsdk.permission.b.a(this.Nyi.getContext(), "android.permission.READ_CONTACTS", 48, null))
    {
      paramView = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
      if (Util.isIntentAvailable(this.Nyi, paramView)) {
        this.Nyi.startActivityForResult(paramView, 1);
      }
    }
    a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.15
 * JD-Core Version:    0.7.0.1
 */