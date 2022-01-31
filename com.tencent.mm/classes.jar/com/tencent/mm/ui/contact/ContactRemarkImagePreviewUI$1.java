package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.io.File;

final class ContactRemarkImagePreviewUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ContactRemarkImagePreviewUI$1(ContactRemarkImagePreviewUI paramContactRemarkImagePreviewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new com.tencent.mm.ui.widget.a.d(this.vKp, 1, false);
    paramMenuItem.phH = new n.c()
    {
      public final void a(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        if (!ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.1.this.vKp)) {
          paramAnonymousl.e(0, ContactRemarkImagePreviewUI.1.this.vKp.getString(R.l.app_delete));
        }
        paramAnonymousl.e(1, ContactRemarkImagePreviewUI.1.this.vKp.getString(R.l.save_to_local));
        if (com.tencent.mm.br.d.SP("favorite")) {
          paramAnonymousl.e(2, ContactRemarkImagePreviewUI.1.this.vKp.getString(R.l.plugin_favorite_opt));
        }
      }
    };
    paramMenuItem.phI = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          return;
        case 0: 
          if (!ContactRemarkImagePreviewUI.b(ContactRemarkImagePreviewUI.1.this.vKp))
          {
            ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.1.this.vKp, true);
            return;
          }
          new File(ContactRemarkImagePreviewUI.c(ContactRemarkImagePreviewUI.1.this.vKp)).delete();
          ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.1.this.vKp, true);
          return;
        case 1: 
          com.tencent.mm.pluginsdk.ui.tools.l.i(ContactRemarkImagePreviewUI.c(ContactRemarkImagePreviewUI.1.this.vKp), ContactRemarkImagePreviewUI.1.this.vKp);
          return;
        }
        ContactRemarkImagePreviewUI.d(ContactRemarkImagePreviewUI.1.this.vKp);
      }
    };
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI.1
 * JD-Core Version:    0.7.0.1
 */