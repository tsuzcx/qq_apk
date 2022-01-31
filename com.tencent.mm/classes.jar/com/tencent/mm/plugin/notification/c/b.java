package com.tencent.mm.plugin.notification.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class b
{
  int currentIndex;
  public ArrayList<Long> piV;
  
  public b()
  {
    AppMethodBeat.i(23111);
    this.currentIndex = 0;
    this.piV = new ArrayList();
    this.currentIndex = 0;
    AppMethodBeat.o(23111);
  }
  
  public final long bYh()
  {
    AppMethodBeat.i(23113);
    long l2 = -1L;
    long l1 = l2;
    if (this.piV.size() > 0)
    {
      l1 = l2;
      if (this.currentIndex < this.piV.size()) {
        l1 = ((Long)this.piV.get(this.currentIndex)).longValue();
      }
    }
    ab.d("MicroMsg.FailMsglist", "getNextSendMsgId:%d, currentIndex:%d, msgIdList.size:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(this.currentIndex), Integer.valueOf(this.piV.size()) });
    this.currentIndex += 1;
    AppMethodBeat.o(23113);
    return l1;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(23115);
    this.piV.clear();
    this.currentIndex = 0;
    AppMethodBeat.o(23115);
  }
  
  public final boolean contains(long paramLong)
  {
    AppMethodBeat.i(23114);
    boolean bool = this.piV.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(23114);
    return bool;
  }
  
  public final long get(int paramInt)
  {
    AppMethodBeat.i(23116);
    long l = ((Long)this.piV.get(paramInt)).longValue();
    AppMethodBeat.o(23116);
    return l;
  }
  
  public final void kO(long paramLong)
  {
    AppMethodBeat.i(23112);
    ab.d("MicroMsg.FailMsglist", "addMsgId:%d, currentIndex:%d, size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.currentIndex), Integer.valueOf(this.piV.size()) });
    this.piV.add(Long.valueOf(paramLong));
    AppMethodBeat.o(23112);
  }
  
  public final void remove(long paramLong)
  {
    AppMethodBeat.i(23117);
    this.piV.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(23117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.b
 * JD-Core Version:    0.7.0.1
 */