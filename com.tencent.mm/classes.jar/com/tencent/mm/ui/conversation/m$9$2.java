package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.sdk.b.a;

final class m$9$2
  implements DialogInterface.OnClickListener
{
  m$9$2(m.9 param9) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(34605);
    paramDialogInterface = new lm();
    a.ymk.l(paramDialogInterface);
    AppMethodBeat.o(34605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m.9.2
 * JD-Core Version:    0.7.0.1
 */