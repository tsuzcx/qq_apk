package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb, b.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33531);
    switch (b.3.AaR[this.AaP.ordinal()])
    {
    default: 
      ab.e("MicroMsg.ChatroomContactEntranceView", "[cpan] unknow type for click. type:%s", new Object[] { this.AaP });
      AppMethodBeat.o(33531);
      return;
    case 1: 
      paramView = new Intent();
      paramView.setClassName(b.a(this.AaQ), "com.tencent.mm.ui.contact.ChatroomContactUI");
      b.a(this.AaQ).startActivity(paramView);
      AppMethodBeat.o(33531);
      return;
    case 2: 
      paramView = new Intent();
      d.b(b.a(this.AaQ), "label", ".ui.ContactLabelManagerUI", paramView);
      AppMethodBeat.o(33531);
      return;
    }
    paramView = new Intent();
    d.b(b.a(this.AaQ), "ipcall", ".ui.IPCallAddressUI", paramView);
    AppMethodBeat.o(33531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.b.1
 * JD-Core Version:    0.7.0.1
 */