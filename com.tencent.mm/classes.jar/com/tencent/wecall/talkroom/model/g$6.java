package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.Iterator;
import java.util.List;

final class g$6
  implements Runnable
{
  g$6(g paramg, MultiTalkGroup paramMultiTalkGroup) {}
  
  public final void run()
  {
    AppMethodBeat.i(127953);
    synchronized (this.BBO.callbacks)
    {
      Iterator localIterator = this.BBO.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).p(this.oTQ);
      }
    }
    AppMethodBeat.o(127953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.6
 * JD-Core Version:    0.7.0.1
 */