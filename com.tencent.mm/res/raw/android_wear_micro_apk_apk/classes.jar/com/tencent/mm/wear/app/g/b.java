package com.tencent.mm.wear.app.g;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public final class b
{
  private c amo = new c(this, (byte)0);
  private BlockingQueue<a> amp = new LinkedBlockingDeque();
  
  public b()
  {
    Thread localThread = new Thread(this.amo);
    localThread.setPriority(1);
    localThread.start();
  }
  
  public final void a(a parama)
  {
    this.amp.add(parama);
  }
  
  protected final void finalize()
  {
    this.amo.stop();
    super.finalize();
  }
  
  public final void finish()
  {
    this.amo.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.g.b
 * JD-Core Version:    0.7.0.1
 */