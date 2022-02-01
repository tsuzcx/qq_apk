package com.tencent.mm.plugin.notification.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;

public final class b
{
  int currentIndex;
  public ArrayList<Long> vqw;
  
  public b()
  {
    AppMethodBeat.i(26736);
    this.currentIndex = 0;
    this.vqw = new ArrayList();
    this.currentIndex = 0;
    AppMethodBeat.o(26736);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(26740);
    this.vqw.clear();
    this.currentIndex = 0;
    AppMethodBeat.o(26740);
  }
  
  public final boolean contains(long paramLong)
  {
    AppMethodBeat.i(26739);
    boolean bool = this.vqw.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(26739);
    return bool;
  }
  
  public final long dlB()
  {
    AppMethodBeat.i(26738);
    long l2 = -1L;
    long l1 = l2;
    if (this.vqw.size() > 0)
    {
      l1 = l2;
      if (this.currentIndex < this.vqw.size()) {
        l1 = ((Long)this.vqw.get(this.currentIndex)).longValue();
      }
    }
    ac.d("MicroMsg.FailMsglist", "getNextSendMsgId:%d, currentIndex:%d, msgIdList.size:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(this.currentIndex), Integer.valueOf(this.vqw.size()) });
    this.currentIndex += 1;
    AppMethodBeat.o(26738);
    return l1;
  }
  
  public final long get(int paramInt)
  {
    AppMethodBeat.i(26741);
    long l = ((Long)this.vqw.get(paramInt)).longValue();
    AppMethodBeat.o(26741);
    return l;
  }
  
  public final void remove(long paramLong)
  {
    AppMethodBeat.i(26742);
    this.vqw.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(26742);
  }
  
  public final void wh(long paramLong)
  {
    AppMethodBeat.i(26737);
    ac.d("MicroMsg.FailMsglist", "addMsgId:%d, currentIndex:%d, size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.currentIndex), Integer.valueOf(this.vqw.size()) });
    this.vqw.add(Long.valueOf(paramLong));
    AppMethodBeat.o(26737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.b
 * JD-Core Version:    0.7.0.1
 */