package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.ecw;
import com.tencent.mm.protocal.protobuf.ecx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends b
{
  private long dOa;
  private String dOb;
  private List<String> dOc;
  private long msgId;
  
  public h(long paramLong1, long paramLong2, String paramString, List<String> paramList)
  {
    this.msgId = paramLong1;
    this.dOa = paramLong2;
    this.dOb = paramString;
    this.dOc = paramList;
  }
  
  public final String getName()
  {
    return "WearLuckyReceiveTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30128);
    ecw localecw = new ecw();
    localecw.HOL = this.dOa;
    localecw.FAf = this.msgId;
    localecw.HOM = this.dOb;
    try
    {
      if (this.dOc != null)
      {
        Iterator localIterator = this.dOc.iterator();
        while (localIterator.hasNext())
        {
          String[] arrayOfString = ((String)localIterator.next()).split("=");
          ecx localecx = new ecx();
          localecx.Hnp = arrayOfString[0];
          localecx.nEt = arrayOfString[1];
          if (localecx.nEt.startsWith("wxid")) {
            localecx.nEt = v.zf(localecx.nEt);
          }
          localecx.HOL = Long.valueOf(arrayOfString[2]).longValue();
          localecw.HON.add(localecx);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (this.dOa > 0L)
      {
        com.tencent.mm.plugin.wear.model.c.a.uM(true);
        AppMethodBeat.o(30128);
        return;
        com.tencent.mm.plugin.wear.model.a.eKz();
        r.a(20015, localException.toByteArray(), true);
      }
      com.tencent.mm.plugin.wear.model.c.a.uM(false);
      AppMethodBeat.o(30128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.h
 * JD-Core Version:    0.7.0.1
 */