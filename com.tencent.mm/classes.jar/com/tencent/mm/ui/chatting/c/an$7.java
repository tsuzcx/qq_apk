package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fa;

final class an$7
  implements DialogInterface.OnClickListener
{
  an$7(an paraman, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(155494);
    this.zII.run();
    paramDialogInterface = new fa();
    paramDialogInterface.csJ.username = this.zIG.caz.getTalkerUserName();
    com.tencent.mm.sdk.b.a.ymk.l(paramDialogInterface);
    AppMethodBeat.o(155494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.an.7
 * JD-Core Version:    0.7.0.1
 */