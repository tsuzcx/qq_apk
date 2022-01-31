package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;

final class bd$9$2
  implements DialogInterface.OnCancelListener
{
  bd$9$2(bd.9 param9, ba paramba) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(39871);
    ao.a.flI.pl(this.scM.scg);
    AppMethodBeat.o(39871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd.9.2
 * JD-Core Version:    0.7.0.1
 */