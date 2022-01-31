package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.f.b.c;
import com.tencent.mm.sdk.platformtools.y;

final class l$a
  implements Runnable
{
  private c lqC = null;
  private b lqn = null;
  
  public l$a(l paraml, b paramb, c paramc)
  {
    this.lqn = paramb;
    this.lqC = paramc;
  }
  
  public final void run()
  {
    if (this.lqn != null)
    {
      this.lqn.bPF();
      this.lqn.bPC();
      this.lqn = null;
    }
    y.i("MicroMsg.Voip.VoipDeviceHandler", "do stopRecord");
    if (this.lqC != null)
    {
      this.lqC.uh();
      this.lqC = null;
      y.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l.a
 * JD-Core Version:    0.7.0.1
 */