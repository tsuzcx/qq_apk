package com.tencent.wecall.talkroom.model;

import java.util.Iterator;
import java.util.List;

final class g$17
  implements Runnable
{
  g$17(g paramg, String paramString, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    synchronized (this.xfh.dhm)
    {
      Iterator localIterator = this.xfh.dhm.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).z(this.iFN, this.xfl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.17
 * JD-Core Version:    0.7.0.1
 */