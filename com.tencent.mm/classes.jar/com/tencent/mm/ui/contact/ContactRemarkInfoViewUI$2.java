package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class ContactRemarkInfoViewUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ContactRemarkInfoViewUI$2(ContactRemarkInfoViewUI paramContactRemarkInfoViewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.vKY.mController.uMN, ContactRemarkInfoModUI.class);
    paramMenuItem.putExtra("Contact_Scene", ContactRemarkInfoViewUI.c(this.vKY));
    paramMenuItem.putExtra("Contact_User", ContactRemarkInfoViewUI.d(this.vKY).field_username);
    this.vKY.startActivity(paramMenuItem);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoViewUI.2
 * JD-Core Version:    0.7.0.1
 */