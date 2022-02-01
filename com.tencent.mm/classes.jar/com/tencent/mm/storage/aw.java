package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.List;

final class aw
{
  protected final long IKD;
  private av IKE;
  
  public aw()
  {
    AppMethodBeat.i(117134);
    this.IKD = 86400L;
    this.IKE = new av();
    Object localObject = new StringBuilder();
    g.ajD();
    localObject = i.aY(g.ajC().cachePath + "checkmsgid.ini", 0, -1);
    if (!bt.cC((byte[])localObject)) {
      try
      {
        this.IKE.parseFrom((byte[])localObject);
        if (fqX()) {
          fqW();
        }
        AppMethodBeat.o(117134);
        return;
      }
      catch (Exception localException)
      {
        ad.w("MicroMsg.DelSvrIdMgr", "DelSvrIDs parse Error");
        ad.e("MicroMsg.DelSvrIdMgr", "exception:%s", new Object[] { bt.n(localException) });
      }
    }
    AppMethodBeat.o(117134);
  }
  
  private void fqW()
  {
    AppMethodBeat.i(117135);
    ad.i("MicroMsg.DelSvrIdMgr", "summerdel toFile tid[%d] [%d, %d ,%d] stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.IKE.IKA.size()), Integer.valueOf(this.IKE.IKB.size()), Integer.valueOf(this.IKE.IKC.size()), bt.flS() });
    try
    {
      this.IKE.IKz.clear();
      this.IKE.IKy.clear();
      this.IKE.IKx.clear();
      av localav = new av();
      localav.IKA.addAll(this.IKE.IKA);
      localav.IKB.addAll(this.IKE.IKB);
      localav.IKC.addAll(this.IKE.IKC);
      byte[] arrayOfByte = localav.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      g.ajD();
      i.f(g.ajC().cachePath + "checkmsgid.ini", arrayOfByte, arrayOfByte.length);
      int j = localav.IKA.size();
      int k = localav.IKB.size();
      int m = localav.IKC.size();
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
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 168L, 1L, false);
      ad.printErrStackTrace("MicroMsg.DelSvrIdMgr", localException, "summerdel ", new Object[0]);
      AppMethodBeat.o(117135);
    }
  }
  
  private boolean fqX()
  {
    AppMethodBeat.i(117140);
    ad.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", new Object[] { Integer.valueOf(this.IKE.IKw), Integer.valueOf(this.IKE.IKA.size()), Integer.valueOf(this.IKE.IKB.size()), Integer.valueOf(this.IKE.IKC.size()) });
    int i = (int)(bt.aQJ() / 86400L);
    int j = this.IKE.IKw;
    this.IKE.IKw = i;
    switch (i - j)
    {
    default: 
      this.IKE.IKC.clear();
      this.IKE.IKB.clear();
      this.IKE.IKA.clear();
      AppMethodBeat.o(117140);
      return true;
    case 0: 
      AppMethodBeat.o(117140);
      return false;
    case 1: 
      this.IKE.IKC = this.IKE.IKB;
      this.IKE.IKB = this.IKE.IKA;
      this.IKE.IKA.clear();
      AppMethodBeat.o(117140);
      return true;
    }
    this.IKE.IKC = this.IKE.IKA;
    this.IKE.IKB.clear();
    this.IKE.IKA.clear();
    AppMethodBeat.o(117140);
    return true;
  }
  
  protected final boolean DF(long paramLong)
  {
    AppMethodBeat.i(117136);
    if (fqX()) {
      fqW();
    }
    if ((this.IKE.IKA.contains(Long.valueOf(paramLong))) || (this.IKE.IKB.contains(Long.valueOf(paramLong))) || (this.IKE.IKC.contains(Long.valueOf(paramLong))))
    {
      AppMethodBeat.o(117136);
      return true;
    }
    AppMethodBeat.o(117136);
    return false;
  }
  
  protected final void G(List<Integer> paramList, List<Long> paramList1)
  {
    AppMethodBeat.i(117139);
    ad.i("MicroMsg.DelSvrIdMgr", "add size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    fqX();
    int j = (int)(bt.aQJ() / 86400L);
    int i = 0;
    while (i < paramList.size())
    {
      b(j, ((Integer)paramList.get(i)).intValue(), ((Long)paramList1.get(i)).longValue(), false);
      i += 1;
    }
    fqW();
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
      fqX();
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
        fqW();
      }
      AppMethodBeat.o(117138);
      return;
      this.IKE.IKA.add(Long.valueOf(paramLong1));
      continue;
      this.IKE.IKB.add(Long.valueOf(paramLong1));
      continue;
      this.IKE.IKC.add(Long.valueOf(paramLong1));
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
 * Qualified Name:     com.tencent.mm.storage.aw
 * JD-Core Version:    0.7.0.1
 */