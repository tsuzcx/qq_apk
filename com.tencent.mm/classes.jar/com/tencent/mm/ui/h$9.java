package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.b.a.a;

final class h$9
  implements DialogInterface.OnClickListener
{
  h$9(h paramh, int paramInt, a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29320);
    h.a(this.yXo, this.val$id, this.yXv.actionType, this.yXv.id, this.yXv.wjS);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(29320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.h.9
 * JD-Core Version:    0.7.0.1
 */