package com.tencent.mm.ui.contact;

import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class ContactRemarkInfoViewUI$4$1
  implements Runnable
{
  ContactRemarkInfoViewUI$4$1(ContactRemarkInfoViewUI.4 param4, boolean paramBoolean) {}
  
  public final void run()
  {
    if (!this.dpq)
    {
      h.bC(this.vKZ.vKY, this.vKZ.vKY.getString(R.l.app_err_system_busy_tip));
      return;
    }
    ContactRemarkInfoViewUI.e(this.vKZ.vKY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoViewUI.4.1
 * JD-Core Version:    0.7.0.1
 */