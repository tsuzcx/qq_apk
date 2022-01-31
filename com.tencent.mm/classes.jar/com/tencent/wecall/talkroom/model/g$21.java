package com.tencent.wecall.talkroom.model;

import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.Iterator;
import java.util.List;

final class g$21
  implements Runnable
{
  g$21(g paramg, int paramInt, MultiTalkGroup paramMultiTalkGroup) {}
  
  public final void run()
  {
    synchronized (this.xfh.dhm)
    {
      Iterator localIterator = this.xfh.dhm.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).a(this.eNZ, this.muc);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.21
 * JD-Core Version:    0.7.0.1
 */