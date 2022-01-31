package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.y;

final class l$3
  implements Runnable
{
  l$3(l paraml) {}
  
  public final void run()
  {
    try
    {
      l.q(this.pQR);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.Voip.VoipDeviceHandler", "start record error: %s", new Object[] { localException.getMessage() });
      this.pQR.iEy = 1;
      this.pQR.pNq.zW(this.pQR.iEy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l.3
 * JD-Core Version:    0.7.0.1
 */