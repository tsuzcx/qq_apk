package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import java.util.List;

final class bc
{
  private bb Opf;
  protected final long SECONDS_OF_DAY;
  
  public bc()
  {
    AppMethodBeat.i(117134);
    this.SECONDS_OF_DAY = 86400L;
    this.Opf = new bb();
    Object localObject = new StringBuilder();
    g.aAi();
    localObject = s.aW(g.aAh().cachePath + "checkmsgid.ini", 0, -1);
    if (!Util.isNullOrNil((byte[])localObject)) {
      try
      {
        this.Opf.parseFrom((byte[])localObject);
        if (gCE()) {
          gCD();
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
  
  private void gCD()
  {
    AppMethodBeat.i(117135);
    Log.i("MicroMsg.DelSvrIdMgr", "summerdel toFile tid[%d] [%d, %d ,%d] stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.Opf.Opc.size()), Integer.valueOf(this.Opf.Opd.size()), Integer.valueOf(this.Opf.Ope.size()), Util.getStack() });
    try
    {
      this.Opf.Opb.clear();
      this.Opf.Opa.clear();
      this.Opf.OoZ.clear();
      bb localbb = new bb();
      localbb.Opc.addAll(this.Opf.Opc);
      localbb.Opd.addAll(this.Opf.Opd);
      localbb.Ope.addAll(this.Opf.Ope);
      byte[] arrayOfByte = localbb.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      g.aAi();
      s.f(g.aAh().cachePath + "checkmsgid.ini", arrayOfByte, arrayOfByte.length);
      int j = localbb.Opc.size();
      int k = localbb.Opd.size();
      int m = localbb.Ope.size();
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
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(111L, 168L, 1L, false);
      Log.printErrStackTrace("MicroMsg.DelSvrIdMgr", localException, "summerdel ", new Object[0]);
      AppMethodBeat.o(117135);
    }
  }
  
  private boolean gCE()
  {
    AppMethodBeat.i(117140);
    Log.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", new Object[] { Integer.valueOf(this.Opf.OoY), Integer.valueOf(this.Opf.Opc.size()), Integer.valueOf(this.Opf.Opd.size()), Integer.valueOf(this.Opf.Ope.size()) });
    int i = (int)(Util.nowSecond() / 86400L);
    int j = this.Opf.OoY;
    this.Opf.OoY = i;
    switch (i - j)
    {
    default: 
      this.Opf.Ope.clear();
      this.Opf.Opd.clear();
      this.Opf.Opc.clear();
      AppMethodBeat.o(117140);
      return true;
    case 0: 
      AppMethodBeat.o(117140);
      return false;
    case 1: 
      this.Opf.Ope = this.Opf.Opd;
      this.Opf.Opd = this.Opf.Opc;
      this.Opf.Opc.clear();
      AppMethodBeat.o(117140);
      return true;
    }
    this.Opf.Ope = this.Opf.Opc;
    this.Opf.Opd.clear();
    this.Opf.Opc.clear();
    AppMethodBeat.o(117140);
    return true;
  }
  
  protected final void B(List<Integer> paramList, List<Long> paramList1)
  {
    AppMethodBeat.i(117139);
    Log.i("MicroMsg.DelSvrIdMgr", "add size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    gCE();
    int j = (int)(Util.nowSecond() / 86400L);
    int i = 0;
    while (i < paramList.size())
    {
      b(j, ((Integer)paramList.get(i)).intValue(), ((Long)paramList1.get(i)).longValue(), false);
      i += 1;
    }
    gCD();
    AppMethodBeat.o(117139);
  }
  
  protected final boolean Ni(long paramLong)
  {
    AppMethodBeat.i(117136);
    if (gCE()) {
      gCD();
    }
    if ((this.Opf.Opc.contains(Long.valueOf(paramLong))) || (this.Opf.Opd.contains(Long.valueOf(paramLong))) || (this.Opf.Ope.contains(Long.valueOf(paramLong))))
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
      gCE();
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
        gCD();
      }
      AppMethodBeat.o(117138);
      return;
      this.Opf.Opc.add(Long.valueOf(paramLong1));
      continue;
      this.Opf.Opd.add(Long.valueOf(paramLong1));
      continue;
      this.Opf.Ope.add(Long.valueOf(paramLong1));
    }
  }
  
  protected final void r(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117137);
    b(paramInt, paramLong1, paramLong2, true);
    AppMethodBeat.o(117137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bc
 * JD-Core Version:    0.7.0.1
 */