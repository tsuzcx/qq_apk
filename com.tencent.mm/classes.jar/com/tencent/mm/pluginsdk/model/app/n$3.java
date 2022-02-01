package com.tencent.mm.pluginsdk.model.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.vb;
import com.tencent.mm.storage.cc;

final class n$3
  implements DialogInterface.OnClickListener
{
  n$3(cc paramcc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(244870);
    paramDialogInterface = new vb();
    paramDialogInterface.hYQ.hzO = this.oiL;
    paramDialogInterface.publish();
    AppMethodBeat.o(244870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.n.3
 * JD-Core Version:    0.7.0.1
 */