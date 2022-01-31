package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements Runnable
{
  b$2(b paramb, int paramInt) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    SightVideoJNI.freeObj(this.val$id);
    y.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", new Object[] { Integer.valueOf(this.oeY.hashCode()), Integer.valueOf(this.val$id), Long.valueOf(System.currentTimeMillis() - l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.2
 * JD-Core Version:    0.7.0.1
 */