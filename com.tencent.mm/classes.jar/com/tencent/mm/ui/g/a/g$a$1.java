package com.tencent.mm.ui.g.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$a$1
  implements DialogInterface.OnDismissListener
{
  g$a$1(g.a parama) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(80332);
    if ((this.Aoo.Aon) && (this.Aoo.Aom != null))
    {
      g.a(this.Aoo.Aom).onCancel();
      this.Aoo.Aom.dismiss();
    }
    AppMethodBeat.o(80332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.g.a.g.a.1
 * JD-Core Version:    0.7.0.1
 */