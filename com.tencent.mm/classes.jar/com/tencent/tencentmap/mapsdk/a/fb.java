package com.tencent.tencentmap.mapsdk.a;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public final class fb
{
  private ThreadPoolExecutor a = (ThreadPoolExecutor)Executors.newCachedThreadPool(new eo("halley_" + em.c() + "_" + "BusinessTaskPool"));
  
  public static fb a()
  {
    return fb.a.a();
  }
  
  public final ThreadPoolExecutor b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.fb
 * JD-Core Version:    0.7.0.1
 */