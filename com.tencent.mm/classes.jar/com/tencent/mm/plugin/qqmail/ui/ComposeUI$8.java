package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ComposeUI$8
  implements DialogInterface.OnClickListener
{
  ComposeUI$8(ComposeUI paramComposeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(218026);
    paramDialogInterface = this.xuI;
    Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(218026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.8
 * JD-Core Version:    0.7.0.1
 */