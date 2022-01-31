package com.tencent.wecall.talkroom.model;

import java.util.Iterator;
import java.util.List;

final class g$4
  implements Runnable
{
  g$4(g paramg, int paramInt, Object paramObject) {}
  
  public final void run()
  {
    synchronized (this.xfh.dhm)
    {
      Iterator localIterator = this.xfh.dhm.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).i(this.bEg, this.oUZ);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.4
 * JD-Core Version:    0.7.0.1
 */