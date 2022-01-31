package com.tencent.mm.plugin.recordvideo.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(150530);
    ab.i("MicroMsg.MMRecordUI", "connected!!!");
    AppMethodBeat.o(150530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.a.b.1
 * JD-Core Version:    0.7.0.1
 */