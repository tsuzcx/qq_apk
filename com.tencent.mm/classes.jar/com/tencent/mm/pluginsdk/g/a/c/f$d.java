package com.tencent.mm.pluginsdk.g.a.c;

import android.os.Process;

public abstract class f$d<Req extends f.b>
  implements Runnable
{
  private final Req vOi;
  
  protected f$d(Req paramReq)
  {
    this.vOi = paramReq;
  }
  
  protected Req avY()
  {
    return this.vOi;
  }
  
  public void run()
  {
    if (Process.getThreadPriority(Process.myTid()) != 10) {
      Process.setThreadPriority(10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.f.d
 * JD-Core Version:    0.7.0.1
 */