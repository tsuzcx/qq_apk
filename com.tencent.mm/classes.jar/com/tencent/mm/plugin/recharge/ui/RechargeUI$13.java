package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RechargeUI$13
  implements View.OnClickListener
{
  RechargeUI$13(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44319);
    if (RechargeUI.e(this.pWS).pVr)
    {
      RechargeUI.e(this.pWS).setInput(null);
      AppMethodBeat.o(44319);
      return;
    }
    paramView = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
    this.pWS.startActivityForResult(paramView, 1);
    AppMethodBeat.o(44319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.13
 * JD-Core Version:    0.7.0.1
 */