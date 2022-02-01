package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.b;

final class y$1
  implements DialogInterface.OnCancelListener
{
  y$1(Activity paramActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(33437);
    g.yhR.idkeyStat(405L, 39L, 1L, true);
    if (this.Jcr != null)
    {
      this.iNQ.finish();
      paramDialogInterface = this.iNQ;
      Object localObject = this.Jcr;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/MMErrorProcessor$10", "onCancel", "(Landroid/content/DialogInterface;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/ui/MMErrorProcessor$10", "onCancel", "(Landroid/content/DialogInterface;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      b.am(this.iNQ, this.Jcr);
    }
    AppMethodBeat.o(33437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.y.1
 * JD-Core Version:    0.7.0.1
 */