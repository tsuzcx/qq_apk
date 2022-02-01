package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.List;

final class ap
{
  protected final long Fyp;
  private ao Fyq;
  
  public ap()
  {
    AppMethodBeat.i(117134);
    this.Fyp = 86400L;
    this.Fyq = new ao();
    Object localObject = new StringBuilder();
    g.afC();
    localObject = i.aR(g.afB().cachePath + "checkmsgid.ini", 0, -1);
    if (!bt.cw((byte[])localObject)) {
      try
      {
        this.Fyq.parseFrom((byte[])localObject);
        if (eLs()) {
          eLr();
        }
        AppMethodBeat.o(117134);
        return;
      }
      catch (Exception localException)
      {
        ad.w("MicroMsg.DelSvrIdMgr", "DelSvrIDs parse Error");
        ad.e("MicroMsg.DelSvrIdMgr", "exception:%s", new Object[] { bt.m(localException) });
      }
    }
    AppMethodBeat.o(117134);
  }
  
  private void eLr()
  {
    AppMethodBeat.i(117135);
    ad.i("MicroMsg.DelSvrIdMgr", "summerdel toFile tid[%d] [%d, %d ,%d] stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.Fyq.Fym.size()), Integer.valueOf(this.Fyq.Fyn.size()), Integer.valueOf(this.Fyq.Fyo.size()), bt.eGN() });
    try
    {
      this.Fyq.Fyl.clear();
      this.Fyq.Fyk.clear();
      this.Fyq.Fyj.clear();
      ao localao = new ao();
      localao.Fym.addAll(this.Fyq.Fym);
      localao.Fyn.addAll(this.Fyq.Fyn);
      localao.Fyo.addAll(this.Fyq.Fyo);
      byte[] arrayOfByte = localao.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      g.afC();
      i.f(g.afB().cachePath + "checkmsgid.ini", arrayOfByte, arrayOfByte.length);
      int j = localao.Fym.size();
      int k = localao.Fyn.size();
      int m = localao.Fyo.size();
      if (arrayOfByte == null) {}
      for (int i = -1;; i = arrayOfByte.length)
      {
        ad.i("MicroMsg.DelSvrIdMgr", "summerdel toFile done [%d, %d, %d] data len[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
        AppMethodBeat.o(117135);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 168L, 1L, false);
      ad.printErrStackTrace("MicroMsg.DelSvrIdMgr", localException, "summerdel ", new Object[0]);
      AppMethodBeat.o(117135);
    }
  }
  
  private boolean eLs()
  {
    AppMethodBeat.i(117140);
    ad.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", new Object[] { Integer.valueOf(this.Fyq.Fyi), Integer.valueOf(this.Fyq.Fym.size()), Integer.valueOf(this.Fyq.Fyn.size()), Integer.valueOf(this.Fyq.Fyo.size()) });
    int i = (int)(bt.aGK() / 86400L);
    int j = this.Fyq.Fyi;
    this.Fyq.Fyi = i;
    switch (i - j)
    {
    default: 
      this.Fyq.Fyo.clear();
      this.Fyq.Fyn.clear();
      this.Fyq.Fym.clear();
      AppMethodBeat.o(117140);
      return true;
    case 0: 
      AppMethodBeat.o(117140);
      return false;
    case 1: 
      this.Fyq.Fyo = this.Fyq.Fyn;
      this.Fyq.Fyn = this.Fyq.Fym;
      this.Fyq.Fym.clear();
      AppMethodBeat.o(117140);
      return true;
    }
    this.Fyq.Fyo = this.Fyq.Fym;
    this.Fyq.Fyn.clear();
    this.Fyq.Fym.clear();
    AppMethodBeat.o(117140);
    return true;
  }
  
  protected final void E(List<Integer> paramList, List<Long> paramList1)
  {
    AppMethodBeat.i(117139);
    ad.i("MicroMsg.DelSvrIdMgr", "add size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    eLs();
    int j = (int)(bt.aGK() / 86400L);
    int i = 0;
    while (i < paramList.size())
    {
      b(j, ((Integer)paramList.get(i)).intValue(), ((Long)paramList1.get(i)).longValue(), false);
      i += 1;
    }
    eLr();
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
      eLs();
    }
    paramInt -= (int)(paramLong2 / 86400L);
    switch (paramInt)
    {
    default: 
      ad.e("MicroMsg.DelSvrIdMgr", "should not add to thease lists, dayIndex:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      if (paramBoolean) {
        eLr();
      }
      AppMethodBeat.o(117138);
      return;
      this.Fyq.Fym.add(Long.valueOf(paramLong1));
      continue;
      this.Fyq.Fyn.add(Long.valueOf(paramLong1));
      continue;
      this.Fyq.Fyo.add(Long.valueOf(paramLong1));
    }
  }
  
  protected final void m(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117137);
    b(paramInt, paramLong1, paramLong2, true);
    AppMethodBeat.o(117137);
  }
  
  protected final boolean wm(long paramLong)
  {
    AppMethodBeat.i(117136);
    if (eLs()) {
      eLr();
    }
    if ((this.Fyq.Fym.contains(Long.valueOf(paramLong))) || (this.Fyq.Fyn.contains(Long.valueOf(paramLong))) || (this.Fyq.Fyo.contains(Long.valueOf(paramLong))))
    {
      AppMethodBeat.o(117136);
      return true;
    }
    AppMethodBeat.o(117136);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.ap
 * JD-Core Version:    0.7.0.1
 */