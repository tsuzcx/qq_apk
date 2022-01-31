package com.tencent.ttpic.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

public class VideoThreadPool
{
  private static final int CORE_POOL_SIZE;
  private static final int CPU_COUNT;
  private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 10 + 1;
  private static String TAG = VideoThreadPool.class.getSimpleName();
  private ThreadPoolExecutor DUAL_THREAD_EXECUTOR;
  private final ThreadFactory sThreadFactory = new VideoThreadFactory(10);
  
  static
  {
    int i = Runtime.getRuntime().availableProcessors();
    CPU_COUNT = i;
    CORE_POOL_SIZE = i * 2 + 1;
  }
  
  private VideoThreadPool()
  {
    init();
  }
  
  public static VideoThreadPool getInstance()
  {
    return VideoThreadPool.VideoThreadPoolHolder.access$100();
  }
  
  public ThreadPoolExecutor getDualThreadExecutor()
  {
    try
    {
      ThreadPoolExecutor localThreadPoolExecutor = this.DUAL_THREAD_EXECUTOR;
      return localThreadPoolExecutor;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void init()
  {
    this.DUAL_THREAD_EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 500L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), this.sThreadFactory, new ThreadPoolExecutor.DiscardOldestPolicy());
    this.DUAL_THREAD_EXECUTOR.allowCoreThreadTimeOut(true);
  }
  
  public void shutdown()
  {
    this.DUAL_THREAD_EXECUTOR.shutdownNow();
    try
    {
      while (!this.DUAL_THREAD_EXECUTOR.awaitTermination(500L, TimeUnit.MILLISECONDS)) {
        new StringBuilder("[clear] thread pool active count = ").append(getInstance().getDualThreadExecutor().getActiveCount());
      }
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public void submit(Runnable paramRunnable)
  {
    this.DUAL_THREAD_EXECUTOR.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.thread.VideoThreadPool
 * JD-Core Version:    0.7.0.1
 */