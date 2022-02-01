package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.u;

final class i$10
  implements DialogInterface.OnCancelListener
{
  i$10(i parami, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(33154);
    bg.azz().a(this.OCo);
    AppMethodBeat.o(33154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.i.10
 * JD-Core Version:    0.7.0.1
 */