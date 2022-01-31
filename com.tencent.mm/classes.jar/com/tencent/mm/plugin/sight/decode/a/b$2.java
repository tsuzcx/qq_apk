package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;

final class b$2
  implements Runnable
{
  b$2(b paramb, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(70227);
    long l = System.currentTimeMillis();
    SightVideoJNI.freeObj(this.val$id);
    ab.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", new Object[] { Integer.valueOf(this.qTn.hashCode()), Integer.valueOf(this.val$id), Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(70227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.2
 * JD-Core Version:    0.7.0.1
 */