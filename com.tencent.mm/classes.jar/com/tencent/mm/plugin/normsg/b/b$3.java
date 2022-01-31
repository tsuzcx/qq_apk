package com.tencent.mm.plugin.normsg.b;

final class b$3
  implements Runnable
{
  b$3(b paramb, Throwable paramThrowable, boolean[] paramArrayOfBoolean) {}
  
  public final void run()
  {
    b.b(this.mHC, this.mHD);
    synchronized (this.mHB)
    {
      this.mHB[0] = true;
      this.mHB.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.3
 * JD-Core Version:    0.7.0.1
 */