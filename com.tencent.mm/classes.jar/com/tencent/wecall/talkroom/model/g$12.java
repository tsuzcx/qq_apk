package com.tencent.wecall.talkroom.model;

import java.util.Iterator;
import java.util.List;

final class g$12
  implements Runnable
{
  g$12(g paramg) {}
  
  public final void run()
  {
    synchronized (this.xfh.dhm)
    {
      Iterator localIterator = this.xfh.dhm.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).cRJ();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.12
 * JD-Core Version:    0.7.0.1
 */