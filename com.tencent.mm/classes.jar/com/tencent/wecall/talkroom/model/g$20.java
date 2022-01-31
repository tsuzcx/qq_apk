package com.tencent.wecall.talkroom.model;

import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.Iterator;
import java.util.List;

final class g$20
  implements Runnable
{
  g$20(g paramg, MultiTalkGroup paramMultiTalkGroup) {}
  
  public final void run()
  {
    synchronized (this.xfh.dhm)
    {
      Iterator localIterator = this.xfh.dhm.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).b(this.muc);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.20
 * JD-Core Version:    0.7.0.1
 */