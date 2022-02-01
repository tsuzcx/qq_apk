package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import java.util.List;

final class be
{
  protected final long SECONDS_OF_DAY;
  private bd adiL;
  
  public be()
  {
    AppMethodBeat.i(117134);
    this.SECONDS_OF_DAY = 86400L;
    this.adiL = new bd();
    Object localObject = new StringBuilder();
    h.baF();
    localObject = y.bi(h.baE().cachePath + "checkmsgid.ini", 0, -1);
    if (!Util.isNullOrNil((byte[])localObject)) {
      try
      {
        this.adiL.parseFrom((byte[])localObject);
        if (jaW()) {
          jaV();
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
  
  private void jaV()
  {
    AppMethodBeat.i(117135);
    Log.i("MicroMsg.DelSvrIdMgr", "summerdel toFile tid[%d] [%d, %d ,%d] stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.adiL.adiI.size()), Integer.valueOf(this.adiL.adiJ.size()), Integer.valueOf(this.adiL.adiK.size()), Util.getStack() });
    try
    {
      this.adiL.adiH.clear();
      this.adiL.adiG.clear();
      this.adiL.adiF.clear();
      bd localbd = new bd();
      localbd.adiI.addAll(this.adiL.adiI);
      localbd.adiJ.addAll(this.adiL.adiJ);
      localbd.adiK.addAll(this.adiL.adiK);
      byte[] arrayOfByte = localbd.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      h.baF();
      y.f(h.baE().cachePath + "checkmsgid.ini", arrayOfByte, arrayOfByte.length);
      int j = localbd.adiI.size();
      int k = localbd.adiJ.size();
      int m = localbd.adiK.size();
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
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 168L, 1L, false);
      Log.printErrStackTrace("MicroMsg.DelSvrIdMgr", localException, "summerdel ", new Object[0]);
      AppMethodBeat.o(117135);
    }
  }
  
  private boolean jaW()
  {
    AppMethodBeat.i(117140);
    Log.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", new Object[] { Integer.valueOf(this.adiL.adiE), Integer.valueOf(this.adiL.adiI.size()), Integer.valueOf(this.adiL.adiJ.size()), Integer.valueOf(this.adiL.adiK.size()) });
    int i = (int)(Util.nowSecond() / 86400L);
    int j = this.adiL.adiE;
    this.adiL.adiE = i;
    switch (i - j)
    {
    default: 
      this.adiL.adiK.clear();
      this.adiL.adiJ.clear();
      this.adiL.adiI.clear();
      AppMethodBeat.o(117140);
      return true;
    case 0: 
      AppMethodBeat.o(117140);
      return false;
    case 1: 
      this.adiL.adiK = this.adiL.adiJ;
      this.adiL.adiJ = this.adiL.adiI;
      this.adiL.adiI.clear();
      AppMethodBeat.o(117140);
      return true;
    }
    this.adiL.adiK = this.adiL.adiI;
    this.adiL.adiJ.clear();
    this.adiL.adiI.clear();
    AppMethodBeat.o(117140);
    return true;
  }
  
  protected final void U(List<Integer> paramList, List<Long> paramList1)
  {
    AppMethodBeat.i(117139);
    Log.i("MicroMsg.DelSvrIdMgr", "add size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    jaW();
    int j = (int)(Util.nowSecond() / 86400L);
    int i = 0;
    while (i < paramList.size())
    {
      b(j, ((Integer)paramList.get(i)).intValue(), ((Long)paramList1.get(i)).longValue(), false);
      i += 1;
    }
    jaV();
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
      jaW();
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
        jaV();
      }
      AppMethodBeat.o(117138);
      return;
      this.adiL.adiI.add(Long.valueOf(paramLong1));
      continue;
      this.adiL.adiJ.add(Long.valueOf(paramLong1));
      continue;
      this.adiL.adiK.add(Long.valueOf(paramLong1));
    }
  }
  
  protected final boolean qe(long paramLong)
  {
    AppMethodBeat.i(117136);
    if (jaW()) {
      jaV();
    }
    if ((this.adiL.adiI.contains(Long.valueOf(paramLong))) || (this.adiL.adiJ.contains(Long.valueOf(paramLong))) || (this.adiL.adiK.contains(Long.valueOf(paramLong))))
    {
      AppMethodBeat.o(117136);
      return true;
    }
    AppMethodBeat.o(117136);
    return false;
  }
  
  protected final void x(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117137);
    b(paramInt, paramLong1, paramLong2, true);
    AppMethodBeat.o(117137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.be
 * JD-Core Version:    0.7.0.1
 */