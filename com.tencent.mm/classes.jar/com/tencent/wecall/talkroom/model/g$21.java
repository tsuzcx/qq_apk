package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.Iterator;
import java.util.List;

final class g$21
  implements Runnable
{
  g$21(g paramg, int paramInt, MultiTalkGroup paramMultiTalkGroup) {}
  
  public final void run()
  {
    AppMethodBeat.i(127968);
    synchronized (this.BBO.callbacks)
    {
      Iterator localIterator = this.BBO.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).a(this.gdN, this.oTQ);
      }
    }
    AppMethodBeat.o(127968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.21
 * JD-Core Version:    0.7.0.1
 */