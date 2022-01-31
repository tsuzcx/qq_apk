package com.tencent.pb.common.c;

public abstract class e<T>
{
  private T mInstance;
  
  public abstract T cOj();
  
  public final T get()
  {
    try
    {
      if (this.mInstance == null) {
        this.mInstance = cOj();
      }
      Object localObject1 = this.mInstance;
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.c.e
 * JD-Core Version:    0.7.0.1
 */