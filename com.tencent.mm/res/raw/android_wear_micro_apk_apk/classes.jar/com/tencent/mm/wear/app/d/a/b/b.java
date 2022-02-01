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
  private String agG;
  private BlockingQueue<g> ahr;
  private boolean aht;
  private ByteArrayOutputStream ahu;
  private i ahv;
  
  public b(BlockingQueue<g> paramBlockingQueue, String paramString, i parami)
  {
    this.ahr = paramBlockingQueue;
    this.agG = paramString;
    this.ahu = new ByteArrayOutputStream();
    this.ahv = parami;
  }
  
  public final void nA()
  {
    this.aht = true;
    g localg = new g();
    localg.ahF = true;
    this.ahr.add(localg);
  }
  
  public final void nz()
  {
    this.aht = false;
    g localg = new g();
    localg.ahF = true;
    this.ahr.add(localg);
    try
    {
      this.ahu.close();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public final void run()
  {
    d.c("MicroMsg.AudioDataVoiceToTextSender", "start to run AudioDataVoiceToTextSender", new Object[0]);
    try
    {
      do
      {
        localg = (g)this.ahr.take();
      } while (localg == null);
      if (localg.size > 0) {
        this.ahu.write(localg.data, 0, localg.size);
      }
      if ((this.ahu.size() > 10240) || ((localg.ahF) && (this.ahu.size() > 0)))
      {
        h.mP().a(new c(this, this.ahu.toByteArray(), false, false));
        this.ahu.reset();
        if (!localg.ahF) {}
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
          this.ahu.close();
        } while (!localg.ahF);
        h.mP().a(new c(this, null, true, this.aht));
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