package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.t;
import com.tencent.mm.af.t.a;

final class k$3
  implements DialogInterface.OnClickListener
{
  k$3(t paramt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(30575);
    if (this.zyn != null) {
      this.zyn.a(t.a.fke);
    }
    AppMethodBeat.o(30575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.3
 * JD-Core Version:    0.7.0.1
 */