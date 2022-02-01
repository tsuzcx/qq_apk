package com.tencent.mm.plugin.topstory.ui.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;

final class b$10
  implements DialogInterface.OnClickListener
{
  b$10(b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125940);
    e.ywz.f(17080, new Object[] { Integer.valueOf(44), Integer.valueOf(1) });
    AppMethodBeat.o(125940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.10
 * JD-Core Version:    0.7.0.1
 */