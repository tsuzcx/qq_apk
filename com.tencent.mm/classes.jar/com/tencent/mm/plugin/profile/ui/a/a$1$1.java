package com.tencent.mm.plugin.profile.ui.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;

final class a$1$1
  implements DialogInterface.OnCancelListener
{
  a$1$1(a.1 param1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(23795);
    aw.Rc().a(this.pDc.pDb.pCZ);
    this.pDc.pDb.mOt = null;
    AppMethodBeat.o(23795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a.a.1.1
 * JD-Core Version:    0.7.0.1
 */