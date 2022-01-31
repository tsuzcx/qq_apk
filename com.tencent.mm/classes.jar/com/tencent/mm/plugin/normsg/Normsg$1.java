package com.tencent.mm.plugin.normsg;

final class Normsg$1
  implements Runnable
{
  Normsg$1(boolean[] paramArrayOfBoolean) {}
  
  public final void run()
  {
    synchronized (this.mGy)
    {
      System.loadLibrary("stlport_shared");
      System.loadLibrary("wechatxlog");
      System.loadLibrary("wechatnormsg");
      this.mGy[0] = true;
      this.mGy.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.Normsg.1
 * JD-Core Version:    0.7.0.1
 */