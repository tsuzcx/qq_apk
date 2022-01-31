package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ContactRemarkInfoModUI$16
  implements MenuItem.OnMenuItemClickListener
{
  ContactRemarkInfoModUI$16(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(153958);
    ContactRemarkInfoModUI.p(this.Acv);
    this.Acv.hideVKB();
    AppMethodBeat.o(153958);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.16
 * JD-Core Version:    0.7.0.1
 */