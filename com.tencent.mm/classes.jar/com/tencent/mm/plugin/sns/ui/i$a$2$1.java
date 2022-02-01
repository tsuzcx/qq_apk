package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class i$a$2$1
  implements DialogInterface.OnCancelListener
{
  i$a$2$1(i.a.2 param2, com.tencent.mm.plugin.sns.model.q paramq) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(97820);
    g.ajD();
    g.ajB().gAO.a(this.zPE);
    AppMethodBeat.o(97820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.a.2.1
 * JD-Core Version:    0.7.0.1
 */