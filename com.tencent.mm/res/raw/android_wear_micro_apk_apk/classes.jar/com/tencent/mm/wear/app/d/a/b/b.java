package com.tencent.mm.wear.app.d.a.b;

import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.a.i;
import com.tencent.mm.wear.app.b.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public final class b
  extends Thread
{
  private BlockingQueue<g> adP;
  private boolean adR;
  private ByteArrayOutputStream adS;
  private i adT;
  private String adf;
  
  public b(BlockingQueue<g> paramBlockingQueue, String paramString, i parami)
  {
    this.adP = paramBlockingQueue;
    this.adf = paramString;
    this.adS = new ByteArrayOutputStream();
    this.adT = parami;
  }
  
  public final void mN()
  {
    this.adR = false;
    g localg = new g();
    localg.aed = true;
    this.adP.add(localg);
    try
    {
      this.adS.close();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public final void mO()
  {
    this.adR = true;
    g localg = new g();
    localg.aed = true;
    this.adP.add(localg);
  }
  
  public final void run()
  {
    d.c("MicroMsg.AudioDataVoiceToTextSender", "start to run AudioDataVoiceToTextSender", new Object[0]);
    try
    {
      do
      {
        localg = (g)this.adP.take();
      } while (localg == null);
      if (localg.size > 0) {
        this.adS.write(localg.data, 0, localg.size);
      }
      if ((this.adS.size() > 10240) || ((localg.aed) && (this.adS.size() > 0)))
      {
        h.mc().a(new c(this, this.adS.toByteArray(), false, false));
        this.adS.reset();
        if (!localg.aed) {}
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      try
      {
        g localg;
        label125:
        do
        {
          this.adS.close();
        } while (!localg.aed);
        h.mc().a(new c(this, null, true, this.adR));
        d.c("MicroMsg.AudioDataVoiceToTextSender", "stop to run AudioDataVoiceToTextSender", new Object[0]);
        return;
        localInterruptedException = localInterruptedException;
        Object localObject = null;
      }
      catch (IOException localIOException)
      {
        break label125;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.b.b
 * JD-Core Version:    0.7.0.1
 */