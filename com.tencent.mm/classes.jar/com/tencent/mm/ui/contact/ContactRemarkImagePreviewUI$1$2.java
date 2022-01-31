package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.ui.base.n.d;
import java.io.File;

final class ContactRemarkImagePreviewUI$1$2
  implements n.d
{
  ContactRemarkImagePreviewUI$1$2(ContactRemarkImagePreviewUI.1 param1) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(33614);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33614);
      return;
      if (!ContactRemarkImagePreviewUI.b(this.AbQ.AbP))
      {
        ContactRemarkImagePreviewUI.a(this.AbQ.AbP, true);
        AppMethodBeat.o(33614);
        return;
      }
      new File(ContactRemarkImagePreviewUI.c(this.AbQ.AbP)).delete();
      ContactRemarkImagePreviewUI.a(this.AbQ.AbP, true);
      AppMethodBeat.o(33614);
      return;
      n.k(ContactRemarkImagePreviewUI.c(this.AbQ.AbP), this.AbQ.AbP);
      AppMethodBeat.o(33614);
      return;
      ContactRemarkImagePreviewUI.d(this.AbQ.AbP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI.1.2
 * JD-Core Version:    0.7.0.1
 */