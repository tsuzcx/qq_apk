package com.tencent.mm.plugin.traceroute.b;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public final class c
  extends ThreadPoolExecutor
{
  public c()
  {
    super(10, 20, 3000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(200), new ThreadPoolExecutor.CallerRunsPolicy());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.b.c
 * JD-Core Version:    0.7.0.1
 */