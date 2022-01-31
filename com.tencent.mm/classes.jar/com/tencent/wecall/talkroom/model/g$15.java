package com.tencent.wecall.talkroom.model;

import java.util.Iterator;
import java.util.List;

final class g$15
  implements Runnable
{
  g$15(g paramg, int paramInt) {}
  
  public final void run()
  {
    synchronized (this.xfh.dhm)
    {
      Iterator localIterator = this.xfh.dhm.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).Kx(this.xfk);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.15
 * JD-Core Version:    0.7.0.1
 */