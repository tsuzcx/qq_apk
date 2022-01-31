package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.y;

final class b$c
  implements Runnable
{
  int ofg;
  b.b ofh;
  volatile boolean stop = false;
  
  public b$c(b paramb)
  {
    y.i("MicroMsg.SightPlayController", "make sure drawJob alive");
  }
  
  public final void run()
  {
    if (this.stop)
    {
      y.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[] { Integer.valueOf(this.oeY.hashCode()), Integer.valueOf(hashCode()) });
      return;
    }
    this.oeY.G(b.B(this.oeY));
    if (b.r(this.oeY) == 0L)
    {
      o.g(this.ofh, 0L);
      return;
    }
    long l = this.oeY.oes - (System.currentTimeMillis() - b.r(this.oeY));
    if (l > 0L)
    {
      o.g(this.ofh, l);
      return;
    }
    o.g(this.ofh, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.c
 * JD-Core Version:    0.7.0.1
 */