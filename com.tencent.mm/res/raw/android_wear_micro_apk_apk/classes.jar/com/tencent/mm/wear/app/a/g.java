package com.tencent.mm.wear.app.a;

import java.util.concurrent.atomic.AtomicInteger;

public final class g
{
  private static AtomicInteger aen = new AtomicInteger();
  private int aeo = aen.incrementAndGet();
  public int aep;
  public byte[] data;
  
  public final int getSessionId()
  {
    return this.aeo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.a.g
 * JD-Core Version:    0.7.0.1
 */