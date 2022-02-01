package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;

final class b$3
  implements Runnable
{
  b$3(b paramb, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(116074);
    long l = System.currentTimeMillis();
    SightVideoJNI.freeObj(this.val$id);
    ac.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", new Object[] { Integer.valueOf(this.xDr.hashCode()), Integer.valueOf(this.val$id), Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(116074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.3
 * JD-Core Version:    0.7.0.1
 */