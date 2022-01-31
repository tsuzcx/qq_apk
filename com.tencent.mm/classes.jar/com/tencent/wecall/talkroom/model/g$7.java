package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.Iterator;
import java.util.List;

final class g$7
  implements Runnable
{
  g$7(g paramg, MultiTalkGroup paramMultiTalkGroup) {}
  
  public final void run()
  {
    AppMethodBeat.i(127954);
    synchronized (this.BBO.callbacks)
    {
      Iterator localIterator = this.BBO.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).q(this.oTQ);
      }
    }
    AppMethodBeat.o(127954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.7
 * JD-Core Version:    0.7.0.1
 */