package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cg;
import com.tencent.mm.ui.base.h.d;

final class VcardContactUI$4
  implements h.d
{
  VcardContactUI$4(VcardContactUI paramVcardContactUI) {}
  
  public final void qy(int paramInt)
  {
    AppMethodBeat.i(52005);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(52005);
      return;
      cg.bfp().e(10238, new Object[] { Integer.valueOf(1) });
      Object localObject = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
      VcardContactUI.a(this.IUw, (Intent)localObject);
      VcardContactUI localVcardContactUI = this.IUw;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localVcardContactUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localVcardContactUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localVcardContactUI, "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(52005);
      return;
      cg.bfp().e(10239, new Object[] { Integer.valueOf(1) });
      localObject = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
      ((Intent)localObject).setType("vnd.android.cursor.item/person");
      VcardContactUI.a(this.IUw, (Intent)localObject);
      localVcardContactUI = this.IUw;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localVcardContactUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localVcardContactUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localVcardContactUI, "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUI.4
 * JD-Core Version:    0.7.0.1
 */