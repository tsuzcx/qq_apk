package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class m$7$1
  implements Runnable
{
  m$7$1(m.7 param7) {}
  
  public final void run()
  {
    AppMethodBeat.i(34601);
    ab.i("MicroMsg.RefreshHelper", "APPHasInitEvent begin");
    com.tencent.mm.g.a.a locala = new com.tencent.mm.g.a.a();
    com.tencent.mm.sdk.b.a.ymk.l(locala);
    AppMethodBeat.o(34601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m.7.1
 * JD-Core Version:    0.7.0.1
 */