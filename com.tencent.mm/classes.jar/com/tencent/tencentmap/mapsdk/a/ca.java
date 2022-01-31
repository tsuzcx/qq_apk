package com.tencent.tencentmap.mapsdk.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ca
  implements ThreadFactory
{
  private String a;
  private AtomicInteger b;
  
  public ca(String paramString)
  {
    this.a = paramString;
    this.b = new AtomicInteger(1);
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, this.a + "_" + this.b.getAndIncrement());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ca
 * JD-Core Version:    0.7.0.1
 */