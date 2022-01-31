package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.b.a.a;

final class h$8
  implements DialogInterface.OnClickListener
{
  h$8(h paramh, int paramInt, a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29319);
    h.a(this.yXo, this.val$id, this.yXu.actionType, this.yXu.id, this.yXu.wjS);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(29319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.h.8
 * JD-Core Version:    0.7.0.1
 */