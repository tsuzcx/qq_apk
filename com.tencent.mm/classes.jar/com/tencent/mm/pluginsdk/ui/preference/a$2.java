package com.tencent.mm.pluginsdk.ui.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.model.p;

final class a$2
  implements DialogInterface.OnCancelListener
{
  a$2(a parama, p paramp) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(31813);
    bg.azz().a(this.BiD);
    AppMethodBeat.o(31813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.a.2
 * JD-Core Version:    0.7.0.1
 */