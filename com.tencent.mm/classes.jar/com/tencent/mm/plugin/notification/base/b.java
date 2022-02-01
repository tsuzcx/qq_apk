package com.tencent.mm.plugin.notification.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class b
{
  public ArrayList<Long> Mwu;
  int currentIndex;
  
  public b()
  {
    AppMethodBeat.i(26736);
    this.currentIndex = 0;
    this.Mwu = new ArrayList();
    this.currentIndex = 0;
    AppMethodBeat.o(26736);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(26740);
    this.Mwu.clear();
    this.currentIndex = 0;
    AppMethodBeat.o(26740);
  }
  
  public final boolean contains(long paramLong)
  {
    AppMethodBeat.i(26739);
    boolean bool = this.Mwu.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(26739);
    return bool;
  }
  
  public final long get(int paramInt)
  {
    AppMethodBeat.i(26741);
    long l = ((Long)this.Mwu.get(paramInt)).longValue();
    AppMethodBeat.o(26741);
    return l;
  }
  
  public final long guK()
  {
    AppMethodBeat.i(26738);
    long l2 = -1L;
    long l1 = l2;
    if (this.Mwu.size() > 0)
    {
      l1 = l2;
      if (this.currentIndex < this.Mwu.size()) {
        l1 = ((Long)this.Mwu.get(this.currentIndex)).longValue();
      }
    }
    Log.d("MicroMsg.FailMsglist", "getNextSendMsgId:%d, currentIndex:%d, msgIdList.size:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(this.currentIndex), Integer.valueOf(this.Mwu.size()) });
    this.currentIndex += 1;
    AppMethodBeat.o(26738);
    return l1;
  }
  
  public final void remove(long paramLong)
  {
    AppMethodBeat.i(26742);
    this.Mwu.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(26742);
  }
  
  public final void sZ(long paramLong)
  {
    AppMethodBeat.i(26737);
    Log.d("MicroMsg.FailMsglist", "addMsgId:%d, currentIndex:%d, size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.currentIndex), Integer.valueOf(this.Mwu.size()) });
    this.Mwu.add(Long.valueOf(paramLong));
    AppMethodBeat.o(26737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.base.b
 * JD-Core Version:    0.7.0.1
 */