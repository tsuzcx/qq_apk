package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.ui.base.k.d;

final class VcardContactUI$4
  implements k.d
{
  VcardContactUI$4(VcardContactUI paramVcardContactUI) {}
  
  public final void qz(int paramInt)
  {
    AppMethodBeat.i(52005);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(52005);
      return;
      ch.bDg().f(10238, new Object[] { Integer.valueOf(1) });
      Object localObject = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
      VcardContactUI.a(this.Pdo, (Intent)localObject);
      VcardContactUI localVcardContactUI = this.Pdo;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localVcardContactUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localVcardContactUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localVcardContactUI, "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(52005);
      return;
      ch.bDg().f(10239, new Object[] { Integer.valueOf(1) });
      localObject = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
      ((Intent)localObject).setType("vnd.android.cursor.item/person");
      VcardContactUI.a(this.Pdo, (Intent)localObject);
      localVcardContactUI = this.Pdo;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localVcardContactUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localVcardContactUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localVcardContactUI, "com/tencent/mm/plugin/scanner/ui/VcardContactUI$4", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUI.4
 * JD-Core Version:    0.7.0.1
 */