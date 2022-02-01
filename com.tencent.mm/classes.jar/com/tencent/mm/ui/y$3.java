package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.ui.base.b;

final class y$3
  implements DialogInterface.OnClickListener
{
  y$3(Intent paramIntent, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33439);
    if (this.Jxb != null)
    {
      this.iQK.finish();
      paramDialogInterface = this.iQK;
      Object localObject = this.Jxb;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/MMErrorProcessor$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/ui/MMErrorProcessor$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      b.am(this.iQK, this.Jxb);
      t.cX(this.iQK);
    }
    AppMethodBeat.o(33439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.y.3
 * JD-Core Version:    0.7.0.1
 */