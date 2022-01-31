package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class ar$8
  implements Runnable
{
  ar$8(ar paramar) {}
  
  public final void run()
  {
    if (this.otO.otJ != null)
    {
      y.i("MicroMsg.SnsVideoService", "download video finish cdnmediaId %s", new Object[] { this.otO.otJ.eFo });
      this.otO.otL.remove(this.otO.otJ.eFo);
    }
    this.otO.otJ = null;
    this.otO.bEm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ar.8
 * JD-Core Version:    0.7.0.1
 */