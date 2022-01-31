package com.tencent.ttpic.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoThreadFactory
  implements ThreadFactory
{
  private final AtomicInteger mCount;
  private final int priority;
  
  public VideoThreadFactory(int paramInt)
  {
    AppMethodBeat.i(83789);
    this.mCount = new AtomicInteger(1);
    this.priority = paramInt;
    AppMethodBeat.o(83789);
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(83790);
    paramRunnable = new Thread(paramRunnable, "Video AsyncTask #" + this.mCount.getAndIncrement());
    paramRunnable.setPriority(this.priority);
    AppMethodBeat.o(83790);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.thread.VideoThreadFactory
 * JD-Core Version:    0.7.0.1
 */