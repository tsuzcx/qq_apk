package com.tencent.mm.plugin.qmessage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.qmessage.a.b;

final class a$2
  implements DialogInterface.OnCancelListener
{
  a$2(a parama, b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(24097);
    aw.Rc().a(this.pHX);
    AppMethodBeat.o(24097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.a.2
 * JD-Core Version:    0.7.0.1
 */