package com.tencent.threadpool.h;

import com.tencent.threadpool.i.k;
import java.util.concurrent.Future;

public abstract interface d
{
  public abstract <V> Future<V> g(k<V> paramk);
  
  public abstract String getName();
  
  public abstract void i(k<?> paramk);
  
  public abstract boolean isShutdown();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.h.d
 * JD-Core Version:    0.7.0.1
 */