package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;

final class ContactRemarkInfoModUI$15
  implements View.OnClickListener
{
  ContactRemarkInfoModUI$15(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33644);
    if ((ah.isNullOrNil(ContactRemarkInfoModUI.l(this.Acv))) || (ContactRemarkInfoModUI.o(this.Acv)))
    {
      ContactRemarkInfoModUI.a(this.Acv, false);
      ContactRemarkInfoModUI.j(this.Acv);
    }
    AppMethodBeat.o(33644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.15
 * JD-Core Version:    0.7.0.1
 */