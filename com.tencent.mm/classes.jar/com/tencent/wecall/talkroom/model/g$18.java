package com.tencent.wecall.talkroom.model;

import java.util.Iterator;
import java.util.List;

final class g$18
  implements Runnable
{
  g$18(g paramg) {}
  
  public final void run()
  {
    synchronized (this.xfh.dhm)
    {
      Iterator localIterator = this.xfh.dhm.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).cRK();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.18
 * JD-Core Version:    0.7.0.1
 */