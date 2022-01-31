package com.tencent.wecall.talkroom.model;

import java.util.Iterator;
import java.util.List;

final class g$14
  implements Runnable
{
  g$14(g paramg, boolean paramBoolean) {}
  
  public final void run()
  {
    synchronized (this.xfh.dhm)
    {
      Iterator localIterator = this.xfh.dhm.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).hE(this.iFZ);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.14
 * JD-Core Version:    0.7.0.1
 */