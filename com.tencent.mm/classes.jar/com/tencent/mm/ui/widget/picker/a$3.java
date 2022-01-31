package com.tencent.mm.ui.widget.picker;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$3
  implements DialogInterface.OnCancelListener
{
  a$3(a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(112810);
    a.a(this.AIR, false, 0, 0, 0);
    this.AIR.hide();
    AppMethodBeat.o(112810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.3
 * JD-Core Version:    0.7.0.1
 */