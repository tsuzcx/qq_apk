package com.tencent.mm.pluginsdk.g.a.c;

import android.os.Process;

public abstract class f$d<Req extends f.b>
  implements Runnable
{
  private final Req rXr;
  
  public f$d(Req paramReq)
  {
    this.rXr = paramReq;
  }
  
  public Req aci()
  {
    return this.rXr;
  }
  
  public void run()
  {
    if (Process.getThreadPriority(Process.myTid()) != 10) {
      Process.setThreadPriority(10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.f.d
 * JD-Core Version:    0.7.0.1
 */