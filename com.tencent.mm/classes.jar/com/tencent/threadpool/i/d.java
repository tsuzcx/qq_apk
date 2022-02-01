package com.tencent.threadpool.i;

import java.util.concurrent.Future;

public abstract interface d<V>
  extends Future<V>
{
  public abstract Thread getThread();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.threadpool.i.d
 * JD-Core Version:    0.7.0.1
 */