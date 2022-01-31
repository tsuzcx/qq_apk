package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

final class an
{
  protected final long yMI;
  private am yMJ;
  
  public an()
  {
    AppMethodBeat.i(1266);
    this.yMI = 86400L;
    this.yMJ = new am();
    Object localObject = new StringBuilder();
    g.RM();
    localObject = com.tencent.mm.vfs.e.i(g.RL().cachePath + "checkmsgid.ini", 0, -1);
    if (!bo.ce((byte[])localObject)) {
      try
      {
        this.yMJ.parseFrom((byte[])localObject);
        if (dxq()) {
          dxp();
        }
        AppMethodBeat.o(1266);
        return;
      }
      catch (Exception localException)
      {
        ab.w("MicroMsg.DelSvrIdMgr", "DelSvrIDs parse Error");
        ab.e("MicroMsg.DelSvrIdMgr", "exception:%s", new Object[] { bo.l(localException) });
      }
    }
    AppMethodBeat.o(1266);
  }
  
  private void dxp()
  {
    AppMethodBeat.i(1267);
    ab.i("MicroMsg.DelSvrIdMgr", "summerdel toFile tid[%d] [%d, %d ,%d] stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.yMJ.yMF.size()), Integer.valueOf(this.yMJ.yMG.size()), Integer.valueOf(this.yMJ.yMH.size()), bo.dtY() });
    try
    {
      this.yMJ.yME.clear();
      this.yMJ.yMD.clear();
      this.yMJ.yMC.clear();
      am localam = new am();
      localam.yMF.addAll(this.yMJ.yMF);
      localam.yMG.addAll(this.yMJ.yMG);
      localam.yMH.addAll(this.yMJ.yMH);
      byte[] arrayOfByte = localam.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      g.RM();
      com.tencent.mm.vfs.e.b(g.RL().cachePath + "checkmsgid.ini", arrayOfByte, arrayOfByte.length);
      int j = localam.yMF.size();
      int k = localam.yMG.size();
      int m = localam.yMH.size();
      if (arrayOfByte == null) {}
      for (int i = -1;; i = arrayOfByte.length)
      {
        ab.i("MicroMsg.DelSvrIdMgr", "summerdel toFile done [%d, %d, %d] data len[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
        AppMethodBeat.o(1267);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 168L, 1L, false);
      ab.printErrStackTrace("MicroMsg.DelSvrIdMgr", localException, "summerdel ", new Object[0]);
      AppMethodBeat.o(1267);
    }
  }
  
  private boolean dxq()
  {
    AppMethodBeat.i(1272);
    ab.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", new Object[] { Integer.valueOf(this.yMJ.yMB), Integer.valueOf(this.yMJ.yMF.size()), Integer.valueOf(this.yMJ.yMG.size()), Integer.valueOf(this.yMJ.yMH.size()) });
    int i = (int)(bo.aox() / 86400L);
    int j = this.yMJ.yMB;
    this.yMJ.yMB = i;
    switch (i - j)
    {
    default: 
      this.yMJ.yMH.clear();
      this.yMJ.yMG.clear();
      this.yMJ.yMF.clear();
      AppMethodBeat.o(1272);
      return true;
    case 0: 
      AppMethodBeat.o(1272);
      return false;
    case 1: 
      this.yMJ.yMH = this.yMJ.yMG;
      this.yMJ.yMG = this.yMJ.yMF;
      this.yMJ.yMF.clear();
      AppMethodBeat.o(1272);
      return true;
    }
    this.yMJ.yMH = this.yMJ.yMF;
    this.yMJ.yMG.clear();
    this.yMJ.yMF.clear();
    AppMethodBeat.o(1272);
    return true;
  }
  
  protected final void b(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(1270);
    if (paramLong1 == 0L)
    {
      AppMethodBeat.o(1270);
      return;
    }
    if (paramBoolean) {
      dxq();
    }
    paramInt -= (int)(paramLong2 / 86400L);
    switch (paramInt)
    {
    default: 
      ab.e("MicroMsg.DelSvrIdMgr", "should not add to thease lists, dayIndex:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      if (paramBoolean) {
        dxp();
      }
      AppMethodBeat.o(1270);
      return;
      this.yMJ.yMF.add(Long.valueOf(paramLong1));
      continue;
      this.yMJ.yMG.add(Long.valueOf(paramLong1));
      continue;
      this.yMJ.yMH.add(Long.valueOf(paramLong1));
    }
  }
  
  protected final void m(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(1269);
    b(paramInt, paramLong1, paramLong2, true);
    AppMethodBeat.o(1269);
  }
  
  protected final boolean oo(long paramLong)
  {
    AppMethodBeat.i(1268);
    if (dxq()) {
      dxp();
    }
    if ((this.yMJ.yMF.contains(Long.valueOf(paramLong))) || (this.yMJ.yMG.contains(Long.valueOf(paramLong))) || (this.yMJ.yMH.contains(Long.valueOf(paramLong))))
    {
      AppMethodBeat.o(1268);
      return true;
    }
    AppMethodBeat.o(1268);
    return false;
  }
  
  protected final void t(List<Integer> paramList, List<Long> paramList1)
  {
    AppMethodBeat.i(1271);
    ab.i("MicroMsg.DelSvrIdMgr", "add size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    dxq();
    int j = (int)(bo.aox() / 86400L);
    int i = 0;
    while (i < paramList.size())
    {
      b(j, ((Integer)paramList.get(i)).intValue(), ((Long)paramList1.get(i)).longValue(), false);
      i += 1;
    }
    dxp();
    AppMethodBeat.o(1271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.an
 * JD-Core Version:    0.7.0.1
 */