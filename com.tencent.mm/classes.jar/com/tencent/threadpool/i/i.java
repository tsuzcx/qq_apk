package com.tencent.threadpool.i;

public abstract class i
  implements f<Runnable>, Runnable
{
  protected abstract void bXC();
  
  public final void run()
  {
    bXD();
    try
    {
      bXC();
      return;
    }
    finally
    {
      dG(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.threadpool.i.i
 * JD-Core Version:    0.7.0.1
 */