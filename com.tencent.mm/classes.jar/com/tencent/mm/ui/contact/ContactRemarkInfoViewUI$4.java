package com.tencent.mm.ui.contact;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.c.a;

final class ContactRemarkInfoViewUI$4
  implements c.a
{
  ContactRemarkInfoViewUI$4(ContactRemarkInfoViewUI paramContactRemarkInfoViewUI) {}
  
  public final void db(boolean paramBoolean)
  {
    AppMethodBeat.i(33691);
    ContactRemarkInfoViewUI.f(this.AcA).post(new ContactRemarkInfoViewUI.4.1(this, paramBoolean));
    AppMethodBeat.o(33691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoViewUI.4
 * JD-Core Version:    0.7.0.1
 */