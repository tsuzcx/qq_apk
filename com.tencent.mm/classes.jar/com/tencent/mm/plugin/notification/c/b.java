package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class b
{
  int currentIndex = 0;
  public ArrayList<Long> mIG = new ArrayList();
  
  public final long bpB()
  {
    long l2 = -1L;
    long l1 = l2;
    if (this.mIG.size() > 0)
    {
      l1 = l2;
      if (this.currentIndex < this.mIG.size()) {
        l1 = ((Long)this.mIG.get(this.currentIndex)).longValue();
      }
    }
    y.d("MicroMsg.FailMsglist", "getNextSendMsgId:%d, currentIndex:%d, msgIdList.size:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(this.currentIndex), Integer.valueOf(this.mIG.size()) });
    this.currentIndex += 1;
    return l1;
  }
  
  public final void clear()
  {
    this.mIG.clear();
    this.currentIndex = 0;
  }
  
  public final boolean contains(long paramLong)
  {
    return this.mIG.contains(Long.valueOf(paramLong));
  }
  
  public final void fq(long paramLong)
  {
    y.d("MicroMsg.FailMsglist", "addMsgId:%d, currentIndex:%d, size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.currentIndex), Integer.valueOf(this.mIG.size()) });
    this.mIG.add(Long.valueOf(paramLong));
  }
  
  public final long get(int paramInt)
  {
    return ((Long)this.mIG.get(paramInt)).longValue();
  }
  
  public final void remove(long paramLong)
  {
    this.mIG.remove(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.b
 * JD-Core Version:    0.7.0.1
 */