package com.tencent.pb.common.c;

public abstract class d<T>
{
  private T mInstance;
  
  public final T get()
  {
    try
    {
      if (this.mInstance == null) {
        this.mInstance = gtQ();
      }
      Object localObject1 = this.mInstance;
      return localObject1;
    }
    finally {}
  }
  
  protected abstract T gtQ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.c.d
 * JD-Core Version:    0.7.0.1
 */