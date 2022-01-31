package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$3
  implements DialogInterface.OnDismissListener
{
  b$3(b paramb, b.a parama) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(2229);
    this.tmw.onDismiss();
    AppMethodBeat.o(2229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.b.3
 * JD-Core Version:    0.7.0.1
 */