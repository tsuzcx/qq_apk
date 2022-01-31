package com.tencent.mm.storage;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

final class an
{
  private am uAA = new am();
  protected final long uAz = 86400L;
  
  public an()
  {
    Object localObject = new StringBuilder();
    g.DQ();
    localObject = com.tencent.mm.vfs.e.c(g.DP().cachePath + "checkmsgid.ini", 0, -1);
    if (!bk.bE((byte[])localObject)) {}
    try
    {
      this.uAA.aH((byte[])localObject);
      if (cuP()) {
        cuO();
      }
      return;
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.DelSvrIdMgr", "DelSvrIDs parse Error");
      y.e("MicroMsg.DelSvrIdMgr", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  private void cuO()
  {
    y.i("MicroMsg.DelSvrIdMgr", "summerdel toFile tid[%d] [%d, %d ,%d] stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.uAA.uAw.size()), Integer.valueOf(this.uAA.uAx.size()), Integer.valueOf(this.uAA.uAy.size()), bk.csb() });
    try
    {
      this.uAA.uAv.clear();
      this.uAA.uAu.clear();
      this.uAA.uAt.clear();
      am localam = new am();
      localam.uAw.addAll(this.uAA.uAw);
      localam.uAx.addAll(this.uAA.uAx);
      localam.uAy.addAll(this.uAA.uAy);
      byte[] arrayOfByte = localam.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      g.DQ();
      com.tencent.mm.vfs.e.b(g.DP().cachePath + "checkmsgid.ini", arrayOfByte, arrayOfByte.length);
      int j = localam.uAw.size();
      int k = localam.uAx.size();
      int m = localam.uAy.size();
      if (arrayOfByte == null) {}
      for (int i = -1;; i = arrayOfByte.length)
      {
        y.i("MicroMsg.DelSvrIdMgr", "summerdel toFile done [%d, %d, %d] data len[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      f.nEG.a(111L, 168L, 1L, false);
      y.printErrStackTrace("MicroMsg.DelSvrIdMgr", localException, "summerdel ", new Object[0]);
    }
  }
  
  private boolean cuP()
  {
    boolean bool = false;
    y.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", new Object[] { Integer.valueOf(this.uAA.uAs), Integer.valueOf(this.uAA.uAw.size()), Integer.valueOf(this.uAA.uAx.size()), Integer.valueOf(this.uAA.uAy.size()) });
    int i = (int)(bk.UX() / 86400L);
    int j = this.uAA.uAs;
    this.uAA.uAs = i;
    switch (i - j)
    {
    default: 
      this.uAA.uAy.clear();
      this.uAA.uAx.clear();
      this.uAA.uAw.clear();
      bool = true;
    case 0: 
      return bool;
    case 1: 
      this.uAA.uAy = this.uAA.uAx;
      this.uAA.uAx = this.uAA.uAw;
      this.uAA.uAw.clear();
      return true;
    }
    this.uAA.uAy = this.uAA.uAw;
    this.uAA.uAx.clear();
    this.uAA.uAw.clear();
    return true;
  }
  
  protected final void b(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramLong1 == 0L) {
      return;
    }
    if (paramBoolean) {
      cuP();
    }
    paramInt -= (int)(paramLong2 / 86400L);
    switch (paramInt)
    {
    default: 
      y.e("MicroMsg.DelSvrIdMgr", "should not add to thease lists, dayIndex:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    while (paramBoolean)
    {
      cuO();
      return;
      this.uAA.uAw.add(Long.valueOf(paramLong1));
      continue;
      this.uAA.uAx.add(Long.valueOf(paramLong1));
      continue;
      this.uAA.uAy.add(Long.valueOf(paramLong1));
    }
  }
  
  protected final boolean hF(long paramLong)
  {
    if (cuP()) {
      cuO();
    }
    return (this.uAA.uAw.contains(Long.valueOf(paramLong))) || (this.uAA.uAx.contains(Long.valueOf(paramLong))) || (this.uAA.uAy.contains(Long.valueOf(paramLong)));
  }
  
  protected final void k(int paramInt, long paramLong1, long paramLong2)
  {
    b(paramInt, paramLong1, paramLong2, true);
  }
  
  protected final void k(List<Integer> paramList, List<Long> paramList1)
  {
    y.i("MicroMsg.DelSvrIdMgr", "add size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    cuP();
    int j = (int)(bk.UX() / 86400L);
    int i = 0;
    while (i < paramList.size())
    {
      b(j, ((Integer)paramList.get(i)).intValue(), ((Long)paramList1.get(i)).longValue(), false);
      i += 1;
    }
    cuO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.an
 * JD-Core Version:    0.7.0.1
 */