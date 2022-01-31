package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.LinkedBlockingQueue;

public final class l$b
  implements Runnable
{
  private l.c muI;
  
  public l$b(l paraml, l.c paramc)
  {
    this.muI = paramc;
  }
  
  public final void run()
  {
    if (this.muI != null)
    {
      y.d("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "draw user %s threadId %d", new Object[] { this.muI.username, Long.valueOf(Thread.currentThread().getId()) });
      if (this.muH.mtQ != null) {
        this.muH.mtQ.a(this.muI.username, this.muI.muJ, this.muI.muL, this.muI.muM, OpenGlRender.FLAG_Angle90);
      }
    }
    try
    {
      this.muH.muA.put(this.muI);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.l.b
 * JD-Core Version:    0.7.0.1
 */