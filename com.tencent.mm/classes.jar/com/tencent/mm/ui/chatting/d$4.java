package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class d$4
  implements Runnable
{
  d$4(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(30408);
    this.zwH.lastShakeTime = bo.yB();
    AppMethodBeat.o(30408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.4
 * JD-Core Version:    0.7.0.1
 */