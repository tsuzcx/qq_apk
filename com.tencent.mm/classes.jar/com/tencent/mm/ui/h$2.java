package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;

final class h$2
  implements DialogInterface.OnClickListener
{
  h$2(Runnable paramRunnable, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(287816);
    this.qsZ.run();
    if (ar.hIH())
    {
      paramDialogInterface = new Intent();
      c.f(this.val$context, ".ui.EmptyActivity", paramDialogInterface);
    }
    AppMethodBeat.o(287816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.h.2
 * JD-Core Version:    0.7.0.1
 */