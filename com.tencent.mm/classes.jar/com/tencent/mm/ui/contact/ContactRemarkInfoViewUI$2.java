package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;

final class ContactRemarkInfoViewUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ContactRemarkInfoViewUI$2(ContactRemarkInfoViewUI paramContactRemarkInfoViewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(33688);
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.AcA.getContext(), ContactRemarkInfoModUI.class);
    paramMenuItem.putExtra("Contact_Scene", ContactRemarkInfoViewUI.c(this.AcA));
    paramMenuItem.putExtra("Contact_User", ContactRemarkInfoViewUI.d(this.AcA).field_username);
    this.AcA.startActivity(paramMenuItem);
    AppMethodBeat.o(33688);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoViewUI.2
 * JD-Core Version:    0.7.0.1
 */