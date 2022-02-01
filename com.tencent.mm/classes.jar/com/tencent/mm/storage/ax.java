package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;
import java.util.List;

final class ax
{
  protected final long Jfk;
  private aw Jfl;
  
  public ax()
  {
    AppMethodBeat.i(117134);
    this.Jfk = 86400L;
    this.Jfl = new aw();
    Object localObject = new StringBuilder();
    g.ajS();
    localObject = o.bb(g.ajR().cachePath + "checkmsgid.ini", 0, -1);
    if (!bu.cF((byte[])localObject)) {
      try
      {
        this.Jfl.parseFrom((byte[])localObject);
        if (fuX()) {
          fuW();
        }
        AppMethodBeat.o(117134);
        return;
      }
      catch (Exception localException)
      {
        ae.w("MicroMsg.DelSvrIdMgr", "DelSvrIDs parse Error");
        ae.e("MicroMsg.DelSvrIdMgr", "exception:%s", new Object[] { bu.o(localException) });
      }
    }
    AppMethodBeat.o(117134);
  }
  
  private void fuW()
  {
    AppMethodBeat.i(117135);
    ae.i("MicroMsg.DelSvrIdMgr", "summerdel toFile tid[%d] [%d, %d ,%d] stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.Jfl.Jfh.size()), Integer.valueOf(this.Jfl.Jfi.size()), Integer.valueOf(this.Jfl.Jfj.size()), bu.fpN() });
    try
    {
      this.Jfl.Jfg.clear();
      this.Jfl.Jff.clear();
      this.Jfl.Jfe.clear();
      aw localaw = new aw();
      localaw.Jfh.addAll(this.Jfl.Jfh);
      localaw.Jfi.addAll(this.Jfl.Jfi);
      localaw.Jfj.addAll(this.Jfl.Jfj);
      byte[] arrayOfByte = localaw.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      g.ajS();
      o.f(g.ajR().cachePath + "checkmsgid.ini", arrayOfByte, arrayOfByte.length);
      int j = localaw.Jfh.size();
      int k = localaw.Jfi.size();
      int m = localaw.Jfj.size();
      if (arrayOfByte == null) {}
      for (int i = -1;; i = arrayOfByte.length)
      {
        ae.i("MicroMsg.DelSvrIdMgr", "summerdel toFile done [%d, %d, %d] data len[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
        AppMethodBeat.o(117135);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 168L, 1L, false);
      ae.printErrStackTrace("MicroMsg.DelSvrIdMgr", localException, "summerdel ", new Object[0]);
      AppMethodBeat.o(117135);
    }
  }
  
  private boolean fuX()
  {
    AppMethodBeat.i(117140);
    ae.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", new Object[] { Integer.valueOf(this.Jfl.Jfd), Integer.valueOf(this.Jfl.Jfh.size()), Integer.valueOf(this.Jfl.Jfi.size()), Integer.valueOf(this.Jfl.Jfj.size()) });
    int i = (int)(bu.aRi() / 86400L);
    int j = this.Jfl.Jfd;
    this.Jfl.Jfd = i;
    switch (i - j)
    {
    default: 
      this.Jfl.Jfj.clear();
      this.Jfl.Jfi.clear();
      this.Jfl.Jfh.clear();
      AppMethodBeat.o(117140);
      return true;
    case 0: 
      AppMethodBeat.o(117140);
      return false;
    case 1: 
      this.Jfl.Jfj = this.Jfl.Jfi;
      this.Jfl.Jfi = this.Jfl.Jfh;
      this.Jfl.Jfh.clear();
      AppMethodBeat.o(117140);
      return true;
    }
    this.Jfl.Jfj = this.Jfl.Jfh;
    this.Jfl.Jfi.clear();
    this.Jfl.Jfh.clear();
    AppMethodBeat.o(117140);
    return true;
  }
  
  protected final boolean Ee(long paramLong)
  {
    AppMethodBeat.i(117136);
    if (fuX()) {
      fuW();
    }
    if ((this.Jfl.Jfh.contains(Long.valueOf(paramLong))) || (this.Jfl.Jfi.contains(Long.valueOf(paramLong))) || (this.Jfl.Jfj.contains(Long.valueOf(paramLong))))
    {
      AppMethodBeat.o(117136);
      return true;
    }
    AppMethodBeat.o(117136);
    return false;
  }
  
  protected final void F(List<Integer> paramList, List<Long> paramList1)
  {
    AppMethodBeat.i(117139);
    ae.i("MicroMsg.DelSvrIdMgr", "add size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    fuX();
    int j = (int)(bu.aRi() / 86400L);
    int i = 0;
    while (i < paramList.size())
    {
      b(j, ((Integer)paramList.get(i)).intValue(), ((Long)paramList1.get(i)).longValue(), false);
      i += 1;
    }
    fuW();
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
      fuX();
    }
    paramInt -= (int)(paramLong2 / 86400L);
    switch (paramInt)
    {
    default: 
      ae.e("MicroMsg.DelSvrIdMgr", "should not add to thease lists, dayIndex:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      if (paramBoolean) {
        fuW();
      }
      AppMethodBeat.o(117138);
      return;
      this.Jfl.Jfh.add(Long.valueOf(paramLong1));
      continue;
      this.Jfl.Jfi.add(Long.valueOf(paramLong1));
      continue;
      this.Jfl.Jfj.add(Long.valueOf(paramLong1));
    }
  }
  
  protected final void n(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117137);
    b(paramInt, paramLong1, paramLong2, true);
    AppMethodBeat.o(117137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.ax
 * JD-Core Version:    0.7.0.1
 */