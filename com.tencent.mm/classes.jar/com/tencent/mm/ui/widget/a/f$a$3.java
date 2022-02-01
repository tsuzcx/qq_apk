package com.tencent.mm.ui.widget.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$a$3
  implements DialogInterface.OnClickListener
{
  f$a$3(f.a parama, f.c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(159370);
    if (this.YnB != null) {
      if (paramDialogInterface != null) {
        break label35;
      }
    }
    label35:
    for (paramDialogInterface = null;; paramDialogInterface = ((d)paramDialogInterface).icq())
    {
      this.YnB.g(true, paramDialogInterface);
      AppMethodBeat.o(159370);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.f.a.3
 * JD-Core Version:    0.7.0.1
 */