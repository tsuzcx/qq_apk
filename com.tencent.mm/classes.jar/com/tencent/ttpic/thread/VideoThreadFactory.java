package com.tencent.ttpic.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoThreadFactory
  implements ThreadFactory
{
  private final AtomicInteger mCount = new AtomicInteger(1);
  private final int priority;
  
  public VideoThreadFactory(int paramInt)
  {
    this.priority = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable, "Video AsyncTask #" + this.mCount.getAndIncrement());
    paramRunnable.setPriority(this.priority);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.thread.VideoThreadFactory
 * JD-Core Version:    0.7.0.1
 */