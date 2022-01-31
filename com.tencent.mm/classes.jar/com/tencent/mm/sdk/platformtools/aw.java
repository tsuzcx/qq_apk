package com.tencent.mm.sdk.platformtools;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class aw
{
  private static final ConcurrentLinkedQueue<Runnable> uhC = new ConcurrentLinkedQueue();
  private static ExecutorService uhD = null;
  
  public static void U(Runnable paramRunnable)
  {
    uhC.add(paramRunnable);
  }
  
  public static void V(Runnable paramRunnable)
  {
    uhC.remove(paramRunnable);
  }
  
  public static ExecutorService cry()
  {
    try
    {
      if (uhD == null) {
        uhD = Executors.newSingleThreadExecutor();
      }
      ExecutorService localExecutorService = uhD;
      return localExecutorService;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.aw
 * JD-Core Version:    0.7.0.1
 */