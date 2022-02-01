package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.b;

final class ae$6
  implements DialogInterface.OnCancelListener
{
  ae$6(Activity paramActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(249581);
    h.OAn.idkeyStat(405L, 39L, 1L, true);
    if (this.pYM != null)
    {
      this.hkm.finish();
      paramDialogInterface = this.hkm;
      Object localObject = this.pYM;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/MMErrorProcessor$8", "onCancel", "(Landroid/content/DialogInterface;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramDialogInterface, "com/tencent/mm/ui/MMErrorProcessor$8", "onCancel", "(Landroid/content/DialogInterface;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      b.aR(this.hkm, this.pYM);
    }
    AppMethodBeat.o(249581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ae.6
 * JD-Core Version:    0.7.0.1
 */