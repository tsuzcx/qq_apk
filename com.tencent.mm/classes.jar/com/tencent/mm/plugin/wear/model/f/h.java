package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.een;
import com.tencent.mm.protocal.protobuf.eeo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends b
{
  private long dPq;
  private String dPr;
  private List<String> dPs;
  private long msgId;
  
  public h(long paramLong1, long paramLong2, String paramString, List<String> paramList)
  {
    this.msgId = paramLong1;
    this.dPq = paramLong2;
    this.dPr = paramString;
    this.dPs = paramList;
  }
  
  public final String getName()
  {
    return "WearLuckyReceiveTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30128);
    een localeen = new een();
    localeen.IiS = this.dPq;
    localeen.FSD = this.msgId;
    localeen.IiT = this.dPr;
    try
    {
      if (this.dPs != null)
      {
        Iterator localIterator = this.dPs.iterator();
        while (localIterator.hasNext())
        {
          String[] arrayOfString = ((String)localIterator.next()).split("=");
          eeo localeeo = new eeo();
          localeeo.HGP = arrayOfString[0];
          localeeo.nJO = arrayOfString[1];
          if (localeeo.nJO.startsWith("wxid")) {
            localeeo.nJO = w.zP(localeeo.nJO);
          }
          localeeo.IiS = Long.valueOf(arrayOfString[2]).longValue();
          localeen.IiU.add(localeeo);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (this.dPq > 0L)
      {
        com.tencent.mm.plugin.wear.model.c.a.uU(true);
        AppMethodBeat.o(30128);
        return;
        com.tencent.mm.plugin.wear.model.a.eOh();
        r.a(20015, localException.toByteArray(), true);
      }
      com.tencent.mm.plugin.wear.model.c.a.uU(false);
      AppMethodBeat.o(30128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.h
 * JD-Core Version:    0.7.0.1
 */