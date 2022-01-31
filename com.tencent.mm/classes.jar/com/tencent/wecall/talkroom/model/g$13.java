package com.tencent.wecall.talkroom.model;

import java.util.Iterator;
import java.util.List;

final class g$13
  implements Runnable
{
  g$13(g paramg, String paramString, int paramInt) {}
  
  public final void run()
  {
    synchronized (this.xfh.dhm)
    {
      Iterator localIterator = this.xfh.dhm.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).dY(this.iFN, this.bEg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.13
 * JD-Core Version:    0.7.0.1
 */