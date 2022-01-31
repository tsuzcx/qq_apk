package com.tencent.tencentmap.mapsdk.a;

import com.qq.sim.Millis100TimeProvider;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class cc<K, V>
{
  ReentrantReadWriteLock a = new ReentrantReadWriteLock();
  final ExecutorService b = Executors.newFixedThreadPool(2, new ca("TimeoutCacheWorker"));
  cf<K, V> c = new cf();
  private ConcurrentHashMap<K, ce<K, V>> d = null;
  private volatile ScheduledExecutorService e;
  
  public cc(int paramInt)
  {
    this.d = new ConcurrentHashMap(paramInt);
    this.e = Executors.newScheduledThreadPool(1, new ca("TimeoutCacheChecker"));
    this.e.scheduleWithFixedDelay(new cc.1(this), 500L, 500L, TimeUnit.MILLISECONDS);
  }
  
  private ce<K, V> b(ce<K, V> paramce)
  {
    this.a.writeLock().lock();
    try
    {
      ce localce = (ce)this.d.put(paramce.a, paramce);
      this.c.b(paramce);
      if (localce != null) {
        this.c.a(localce);
      }
      return localce;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  public int a()
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.d.entrySet().iterator();
        j = i;
        int k = i;
        if (localIterator.hasNext())
        {
          j = i;
          ce localce = (ce)((Map.Entry)localIterator.next()).getValue();
          j = i;
          long l = Millis100TimeProvider.INSTANCE.currentTimeMillis() - localce.e;
          j = i;
          if (l >= localce.f)
          {
            j = i;
            a(localce);
            j = i;
            this.b.submit(new cc.2(this, localce, l));
            i += 1;
          }
        }
        else
        {
          return k;
        }
      }
      catch (Exception localException)
      {
        System.err.print("cleanTimeoutItem error" + localException);
        k = j;
      }
    }
  }
  
  V a(ce<K, V> paramce)
  {
    this.a.writeLock().lock();
    try
    {
      if ((ce)this.d.get(paramce.a) == paramce)
      {
        this.d.remove(paramce.a);
        this.c.a(paramce);
        paramce = paramce.b;
        return paramce;
      }
      return null;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  public V a(K paramK, V paramV, cd<K, V> paramcd, long paramLong)
  {
    paramK = b(new ce(paramK, paramV, paramcd, Millis100TimeProvider.INSTANCE.currentTimeMillis(), paramLong));
    if (paramK != null) {
      return paramK.b;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cc
 * JD-Core Version:    0.7.0.1
 */