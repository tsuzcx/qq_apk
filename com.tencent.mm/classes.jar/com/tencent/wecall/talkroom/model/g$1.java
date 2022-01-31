package com.tencent.wecall.talkroom.model;

import java.util.Iterator;
import java.util.List;

final class g$1
  implements Runnable
{
  g$1(g paramg, int paramInt) {}
  
  public final void run()
  {
    synchronized (this.xfh.dhm)
    {
      Iterator localIterator = this.xfh.dhm.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).uo(this.xfg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.1
 * JD-Core Version:    0.7.0.1
 */