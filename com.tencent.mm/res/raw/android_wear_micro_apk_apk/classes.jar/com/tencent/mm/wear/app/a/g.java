package com.tencent.mm.wear.app.a;

import java.util.concurrent.atomic.AtomicInteger;

public final class g
{
  private static AtomicInteger aaM = new AtomicInteger();
  private int aaN = aaM.incrementAndGet();
  public int aaO;
  public byte[] data;
  
  public final int getSessionId()
  {
    return this.aaN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.a.g
 * JD-Core Version:    0.7.0.1
 */