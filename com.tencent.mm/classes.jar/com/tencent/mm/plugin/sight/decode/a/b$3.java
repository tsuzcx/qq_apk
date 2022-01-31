package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b$3
  implements Runnable
{
  public b$3(b paramb, double paramDouble) {}
  
  public final void run()
  {
    y.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", new Object[] { Double.valueOf(this.oeZ), bk.csb().toString() });
    b.a(this.oeY, this.oeZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.3
 * JD-Core Version:    0.7.0.1
 */