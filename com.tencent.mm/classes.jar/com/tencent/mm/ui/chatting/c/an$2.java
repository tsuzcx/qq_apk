package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tl;

final class an$2
  implements DialogInterface.OnClickListener
{
  an$2(an paraman) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(31749);
    paramDialogInterface = new tl();
    paramDialogInterface.cJT.cJW = true;
    com.tencent.mm.sdk.b.a.ymk.l(paramDialogInterface);
    an.a(this.zIG, this.zIG.caz.getTalkerUserName());
    AppMethodBeat.o(31749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.an.2
 * JD-Core Version:    0.7.0.1
 */