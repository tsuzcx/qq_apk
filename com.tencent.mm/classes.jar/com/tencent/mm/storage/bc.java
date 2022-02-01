package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import java.util.List;

final class bc
{
  protected final long SECONDS_OF_DAY;
  private bb VEY;
  
  public bc()
  {
    AppMethodBeat.i(117134);
    this.SECONDS_OF_DAY = 86400L;
    this.VEY = new bb();
    Object localObject = new StringBuilder();
    h.aHH();
    localObject = u.aY(h.aHG().cachePath + "checkmsgid.ini", 0, -1);
    if (!Util.isNullOrNil((byte[])localObject)) {
      try
      {
        this.VEY.parseFrom((byte[])localObject);
        if (hyQ()) {
          hyP();
        }
        AppMethodBeat.o(117134);
        return;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.DelSvrIdMgr", "DelSvrIDs parse Error");
        Log.e("MicroMsg.DelSvrIdMgr", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      }
    }
    AppMethodBeat.o(117134);
  }
  
  private void hyP()
  {
    AppMethodBeat.i(117135);
    Log.i("MicroMsg.DelSvrIdMgr", "summerdel toFile tid[%d] [%d, %d ,%d] stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.VEY.VEV.size()), Integer.valueOf(this.VEY.VEW.size()), Integer.valueOf(this.VEY.VEX.size()), Util.getStack() });
    try
    {
      this.VEY.VEU.clear();
      this.VEY.VET.clear();
      this.VEY.VES.clear();
      bb localbb = new bb();
      localbb.VEV.addAll(this.VEY.VEV);
      localbb.VEW.addAll(this.VEY.VEW);
      localbb.VEX.addAll(this.VEY.VEX);
      byte[] arrayOfByte = localbb.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      h.aHH();
      u.f(h.aHG().cachePath + "checkmsgid.ini", arrayOfByte, arrayOfByte.length);
      int j = localbb.VEV.size();
      int k = localbb.VEW.size();
      int m = localbb.VEX.size();
      if (arrayOfByte == null) {}
      for (int i = -1;; i = arrayOfByte.length)
      {
        Log.i("MicroMsg.DelSvrIdMgr", "summerdel toFile done [%d, %d, %d] data len[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
        AppMethodBeat.o(117135);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 168L, 1L, false);
      Log.printErrStackTrace("MicroMsg.DelSvrIdMgr", localException, "summerdel ", new Object[0]);
      AppMethodBeat.o(117135);
    }
  }
  
  private boolean hyQ()
  {
    AppMethodBeat.i(117140);
    Log.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", new Object[] { Integer.valueOf(this.VEY.VER), Integer.valueOf(this.VEY.VEV.size()), Integer.valueOf(this.VEY.VEW.size()), Integer.valueOf(this.VEY.VEX.size()) });
    int i = (int)(Util.nowSecond() / 86400L);
    int j = this.VEY.VER;
    this.VEY.VER = i;
    switch (i - j)
    {
    default: 
      this.VEY.VEX.clear();
      this.VEY.VEW.clear();
      this.VEY.VEV.clear();
      AppMethodBeat.o(117140);
      return true;
    case 0: 
      AppMethodBeat.o(117140);
      return false;
    case 1: 
      this.VEY.VEX = this.VEY.VEW;
      this.VEY.VEW = this.VEY.VEV;
      this.VEY.VEV.clear();
      AppMethodBeat.o(117140);
      return true;
    }
    this.VEY.VEX = this.VEY.VEV;
    this.VEY.VEW.clear();
    this.VEY.VEV.clear();
    AppMethodBeat.o(117140);
    return true;
  }
  
  protected final void H(List<Integer> paramList, List<Long> paramList1)
  {
    AppMethodBeat.i(117139);
    Log.i("MicroMsg.DelSvrIdMgr", "add size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    hyQ();
    int j = (int)(Util.nowSecond() / 86400L);
    int i = 0;
    while (i < paramList.size())
    {
      b(j, ((Integer)paramList.get(i)).intValue(), ((Long)paramList1.get(i)).longValue(), false);
      i += 1;
    }
    hyP();
    AppMethodBeat.o(117139);
  }
  
  protected final boolean UU(long paramLong)
  {
    AppMethodBeat.i(117136);
    if (hyQ()) {
      hyP();
    }
    if ((this.VEY.VEV.contains(Long.valueOf(paramLong))) || (this.VEY.VEW.contains(Long.valueOf(paramLong))) || (this.VEY.VEX.contains(Long.valueOf(paramLong))))
    {
      AppMethodBeat.o(117136);
      return true;
    }
    AppMethodBeat.o(117136);
    return false;
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
      hyQ();
    }
    paramInt -= (int)(paramLong2 / 86400L);
    switch (paramInt)
    {
    default: 
      Log.e("MicroMsg.DelSvrIdMgr", "should not add to thease lists, dayIndex:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      if (paramBoolean) {
        hyP();
      }
      AppMethodBeat.o(117138);
      return;
      this.VEY.VEV.add(Long.valueOf(paramLong1));
      continue;
      this.VEY.VEW.add(Long.valueOf(paramLong1));
      continue;
      this.VEY.VEX.add(Long.valueOf(paramLong1));
    }
  }
  
  protected final void y(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117137);
    b(paramInt, paramLong1, paramLong2, true);
    AppMethodBeat.o(117137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.bc
 * JD-Core Version:    0.7.0.1
 */