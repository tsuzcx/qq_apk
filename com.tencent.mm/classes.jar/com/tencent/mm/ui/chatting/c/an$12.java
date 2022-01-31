package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tl;

final class an$12
  implements DialogInterface.OnClickListener
{
  an$12(an paraman) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(31758);
    paramDialogInterface = new tl();
    paramDialogInterface.cJT.cJW = true;
    com.tencent.mm.sdk.b.a.ymk.l(paramDialogInterface);
    an.a(this.zIG, this.zIG.caz.getTalkerUserName());
    AppMethodBeat.o(31758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.an.12
 * JD-Core Version:    0.7.0.1
 */