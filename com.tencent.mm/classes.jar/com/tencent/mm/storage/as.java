package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.List;

final class as
{
  protected final long GXp;
  private ar GXq;
  
  public as()
  {
    AppMethodBeat.i(117134);
    this.GXp = 86400L;
    this.GXq = new ar();
    Object localObject = new StringBuilder();
    g.agS();
    localObject = i.aU(g.agR().cachePath + "checkmsgid.ini", 0, -1);
    if (!bs.cv((byte[])localObject)) {
      try
      {
        this.GXq.parseFrom((byte[])localObject);
        if (faU()) {
          faT();
        }
        AppMethodBeat.o(117134);
        return;
      }
      catch (Exception localException)
      {
        ac.w("MicroMsg.DelSvrIdMgr", "DelSvrIDs parse Error");
        ac.e("MicroMsg.DelSvrIdMgr", "exception:%s", new Object[] { bs.m(localException) });
      }
    }
    AppMethodBeat.o(117134);
  }
  
  private void faT()
  {
    AppMethodBeat.i(117135);
    ac.i("MicroMsg.DelSvrIdMgr", "summerdel toFile tid[%d] [%d, %d ,%d] stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.GXq.GXm.size()), Integer.valueOf(this.GXq.GXn.size()), Integer.valueOf(this.GXq.GXo.size()), bs.eWi() });
    try
    {
      this.GXq.GXl.clear();
      this.GXq.GXk.clear();
      this.GXq.GXj.clear();
      ar localar = new ar();
      localar.GXm.addAll(this.GXq.GXm);
      localar.GXn.addAll(this.GXq.GXn);
      localar.GXo.addAll(this.GXq.GXo);
      byte[] arrayOfByte = localar.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      g.agS();
      i.f(g.agR().cachePath + "checkmsgid.ini", arrayOfByte, arrayOfByte.length);
      int j = localar.GXm.size();
      int k = localar.GXn.size();
      int m = localar.GXo.size();
      if (arrayOfByte == null) {}
      for (int i = -1;; i = arrayOfByte.length)
      {
        ac.i("MicroMsg.DelSvrIdMgr", "summerdel toFile done [%d, %d, %d] data len[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
        AppMethodBeat.o(117135);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 168L, 1L, false);
      ac.printErrStackTrace("MicroMsg.DelSvrIdMgr", localException, "summerdel ", new Object[0]);
      AppMethodBeat.o(117135);
    }
  }
  
  private boolean faU()
  {
    AppMethodBeat.i(117140);
    ac.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", new Object[] { Integer.valueOf(this.GXq.GXi), Integer.valueOf(this.GXq.GXm.size()), Integer.valueOf(this.GXq.GXn.size()), Integer.valueOf(this.GXq.GXo.size()) });
    int i = (int)(bs.aNx() / 86400L);
    int j = this.GXq.GXi;
    this.GXq.GXi = i;
    switch (i - j)
    {
    default: 
      this.GXq.GXo.clear();
      this.GXq.GXn.clear();
      this.GXq.GXm.clear();
      AppMethodBeat.o(117140);
      return true;
    case 0: 
      AppMethodBeat.o(117140);
      return false;
    case 1: 
      this.GXq.GXo = this.GXq.GXn;
      this.GXq.GXn = this.GXq.GXm;
      this.GXq.GXm.clear();
      AppMethodBeat.o(117140);
      return true;
    }
    this.GXq.GXo = this.GXq.GXm;
    this.GXq.GXn.clear();
    this.GXq.GXm.clear();
    AppMethodBeat.o(117140);
    return true;
  }
  
  protected final boolean AP(long paramLong)
  {
    AppMethodBeat.i(117136);
    if (faU()) {
      faT();
    }
    if ((this.GXq.GXm.contains(Long.valueOf(paramLong))) || (this.GXq.GXn.contains(Long.valueOf(paramLong))) || (this.GXq.GXo.contains(Long.valueOf(paramLong))))
    {
      AppMethodBeat.o(117136);
      return true;
    }
    AppMethodBeat.o(117136);
    return false;
  }
  
  protected final void E(List<Integer> paramList, List<Long> paramList1)
  {
    AppMethodBeat.i(117139);
    ac.i("MicroMsg.DelSvrIdMgr", "add size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    faU();
    int j = (int)(bs.aNx() / 86400L);
    int i = 0;
    while (i < paramList.size())
    {
      b(j, ((Integer)paramList.get(i)).intValue(), ((Long)paramList1.get(i)).longValue(), false);
      i += 1;
    }
    faT();
    AppMethodBeat.o(117139);
  }
  
  protected final void b(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(117138);
    if (paramLong1 == 0L)
    {
      AppMethodBeat.o(117138);
      return;
    }
    if (paramBoolean) {
      faU();
    }
    paramInt -= (int)(paramLong2 / 86400L);
    switch (paramInt)
    {
    default: 
      ac.e("MicroMsg.DelSvrIdMgr", "should not add to thease lists, dayIndex:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      if (paramBoolean) {
        faT();
      }
      AppMethodBeat.o(117138);
      return;
      this.GXq.GXm.add(Long.valueOf(paramLong1));
      continue;
      this.GXq.GXn.add(Long.valueOf(paramLong1));
      continue;
      this.GXq.GXo.add(Long.valueOf(paramLong1));
    }
  }
  
  protected final void m(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117137);
    b(paramInt, paramLong1, paramLong2, true);
    AppMethodBeat.o(117137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.as
 * JD-Core Version:    0.7.0.1
 */