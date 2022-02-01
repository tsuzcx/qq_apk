package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.dbbackup.DBRecoveryUI;
import com.tencent.mm.ui.widget.a.e;

final class n$7
  implements DialogInterface.OnClickListener
{
  n$7(n paramn) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(38604);
    n.e(this.afqg).dismiss();
    Object localObject = new Intent(n.a(this.afqg), DBRecoveryUI.class);
    ((Intent)localObject).putExtra("scene", 0);
    paramDialogInterface = n.a(this.afqg);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/conversation/InitHelper$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramDialogInterface, "com/tencent/mm/ui/conversation/InitHelper$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(38604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.n.7
 * JD-Core Version:    0.7.0.1
 */