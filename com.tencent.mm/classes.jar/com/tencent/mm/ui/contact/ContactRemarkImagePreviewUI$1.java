package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class ContactRemarkImagePreviewUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ContactRemarkImagePreviewUI$1(ContactRemarkImagePreviewUI paramContactRemarkImagePreviewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(33615);
    paramMenuItem = new com.tencent.mm.ui.widget.b.d(this.AbP, 1, false);
    paramMenuItem.sao = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(33613);
        paramAnonymousl.e(0, ContactRemarkImagePreviewUI.1.this.AbP.getString(2131302871));
        if (com.tencent.mm.bq.d.ahR("favorite")) {
          paramAnonymousl.e(1, ContactRemarkImagePreviewUI.1.this.AbP.getString(2131302102));
        }
        if (!ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.1.this.AbP)) {
          paramAnonymousl.e(2, ContactRemarkImagePreviewUI.1.this.AbP.getString(2131296901));
        }
        AppMethodBeat.o(33613);
      }
    };
    paramMenuItem.sap = new ContactRemarkImagePreviewUI.1.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(33615);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI.1
 * JD-Core Version:    0.7.0.1
 */