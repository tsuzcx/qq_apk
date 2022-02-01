package com.tencent.threadpool;

import com.tencent.threadpool.i.d;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public abstract interface i
{
  public abstract b a(String paramString, int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue);
  
  public abstract d<?> a(Runnable paramRunnable, long paramLong1, long paramLong2);
  
  public abstract d<?> a(Runnable paramRunnable, long paramLong, String paramString);
  
  public abstract <T> d<T> a(Callable<T> paramCallable, String paramString);
  
  public abstract d<?> b(Runnable paramRunnable, long paramLong1, long paramLong2);
  
  public abstract d<?> b(Runnable paramRunnable, long paramLong, String paramString);
  
  public abstract boolean bFQ(String paramString);
  
  public abstract b bFR(String paramString);
  
  public abstract d<?> bk(Runnable paramRunnable);
  
  public abstract d<?> bl(Runnable paramRunnable);
  
  public abstract d<?> bm(Runnable paramRunnable);
  
  public abstract d<?> bn(Runnable paramRunnable);
  
  public abstract d<?> bo(Runnable paramRunnable);
  
  public abstract d<?> bp(Runnable paramRunnable);
  
  public abstract <T> d<T> e(Callable<T> paramCallable);
  
  public abstract <T> d<T> f(Callable<T> paramCallable);
  
  public abstract d<?> g(Runnable paramRunnable, String paramString);
  
  public abstract <T> d<T> g(Callable<T> paramCallable);
  
  public abstract d<?> h(Runnable paramRunnable, String paramString);
  
  public abstract <T> d<T> h(Callable<T> paramCallable);
  
  public abstract d<?> i(Runnable paramRunnable, String paramString);
  
  public abstract boolean isShutdown();
  
  public abstract d<?> j(Runnable paramRunnable, String paramString);
  
  public abstract boolean jYV();
  
  public abstract a jYW();
  
  public abstract d<?> o(Runnable paramRunnable, long paramLong);
  
  public abstract d<?> p(Runnable paramRunnable, long paramLong);
  
  public abstract d<?> q(Runnable paramRunnable, long paramLong);
  
  public abstract d<?> r(Runnable paramRunnable, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.i
 * JD-Core Version:    0.7.0.1
 */