package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.abz;
import com.tencent.mm.autogen.a.abz.a;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;

final class aq$1
  implements Runnable
{
  aq$1(aq paramaq, SubscribeMsgRequestResult paramSubscribeMsgRequestResult) {}
  
  public final void run()
  {
    AppMethodBeat.i(249251);
    abz localabz = new abz();
    localabz.ify.hzi = aq.a(this.adJX);
    abz.a locala = localabz.ify;
    if (!this.adJW.phG) {}
    for (int i = 1;; i = 2)
    {
      locala.action = i;
      localabz.ify.option = 1;
      localabz.publish();
      AppMethodBeat.o(249251);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.aq.1
 * JD-Core Version:    0.7.0.1
 */