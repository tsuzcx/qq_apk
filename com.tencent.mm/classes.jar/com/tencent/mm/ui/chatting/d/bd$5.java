package com.tencent.mm.ui.chatting.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.ui.chatting.e.a;

final class bd$5
  implements DialogInterface.OnClickListener
{
  bd$5(bd parambd, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(35656);
    this.PuG.run();
    paramDialogInterface = new fo();
    paramDialogInterface.dIN.username = this.PuF.dom.getTalkerUserName();
    EventCenter.instance.publish(paramDialogInterface);
    AppMethodBeat.o(35656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bd.5
 * JD-Core Version:    0.7.0.1
 */