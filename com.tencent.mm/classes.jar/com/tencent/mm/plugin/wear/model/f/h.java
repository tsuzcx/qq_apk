package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.dww;
import com.tencent.mm.protocal.protobuf.dwx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends b
{
  private long dBN;
  private String dBO;
  private List<String> dBP;
  private long msgId;
  
  public h(long paramLong1, long paramLong2, String paramString, List<String> paramList)
  {
    this.msgId = paramLong1;
    this.dBN = paramLong2;
    this.dBO = paramString;
    this.dBP = paramList;
  }
  
  public final String getName()
  {
    return "WearLuckyReceiveTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30128);
    dww localdww = new dww();
    localdww.GdF = this.dBN;
    localdww.DUK = this.msgId;
    localdww.GdG = this.dBO;
    try
    {
      if (this.dBP != null)
      {
        Iterator localIterator = this.dBP.iterator();
        while (localIterator.hasNext())
        {
          String[] arrayOfString = ((String)localIterator.next()).split("=");
          dwx localdwx = new dwx();
          localdwx.FDc = arrayOfString[0];
          localdwx.ndW = arrayOfString[1];
          if (localdwx.ndW.startsWith("wxid")) {
            localdwx.ndW = v.wk(localdwx.ndW);
          }
          localdwx.GdF = Long.valueOf(arrayOfString[2]).longValue();
          localdww.GdH.add(localdwx);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (this.dBN > 0L)
      {
        com.tencent.mm.plugin.wear.model.c.a.uc(true);
        AppMethodBeat.o(30128);
        return;
        com.tencent.mm.plugin.wear.model.a.ewt();
        r.a(20015, localException.toByteArray(), true);
      }
      com.tencent.mm.plugin.wear.model.c.a.uc(false);
      AppMethodBeat.o(30128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.h
 * JD-Core Version:    0.7.0.1
 */