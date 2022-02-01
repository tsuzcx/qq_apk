package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.bt;

final class PhoneRechargeUI$16
  implements View.OnClickListener
{
  PhoneRechargeUI$16(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67178);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (com.tencent.mm.pluginsdk.permission.b.a(this.xoG.getContext(), "android.permission.READ_CONTACTS", 48, null, null))
    {
      paramView = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
      if (bt.aj(this.xoG, paramView)) {
        this.xoG.startActivityForResult(paramView, 1);
      }
    }
    a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.16
 * JD-Core Version:    0.7.0.1
 */