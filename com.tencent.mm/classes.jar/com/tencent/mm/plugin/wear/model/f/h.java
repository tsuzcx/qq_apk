package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.gga;
import com.tencent.mm.protocal.protobuf.ggb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends b
{
  private long ihV;
  private String ihW;
  private List<String> ihX;
  private long msgId;
  
  public h(long paramLong1, long paramLong2, String paramString, List<String> paramList)
  {
    this.msgId = paramLong1;
    this.ihV = paramLong2;
    this.ihW = paramString;
    this.ihX = paramList;
  }
  
  public final String getName()
  {
    return "WearLuckyReceiveTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30128);
    gga localgga = new gga();
    localgga.accP = this.ihV;
    localgga.YKx = this.msgId;
    localgga.accQ = this.ihW;
    try
    {
      if (this.ihX != null)
      {
        Iterator localIterator = this.ihX.iterator();
        while (localIterator.hasNext())
        {
          String[] arrayOfString = ((String)localIterator.next()).split("=");
          ggb localggb = new ggb();
          localggb.abvu = arrayOfString[0];
          localggb.vhX = arrayOfString[1];
          if (localggb.vhX.startsWith("wxid")) {
            localggb.vhX = aa.getDisplayName(localggb.vhX);
          }
          localggb.accP = Long.valueOf(arrayOfString[2]).longValue();
          localgga.accR.add(localggb);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (this.ihV > 0L)
      {
        com.tencent.mm.plugin.wear.model.c.a.Ij(true);
        AppMethodBeat.o(30128);
        return;
        com.tencent.mm.plugin.wear.model.a.inM();
        r.a(20015, localException.toByteArray(), true);
      }
      com.tencent.mm.plugin.wear.model.c.a.Ij(false);
      AppMethodBeat.o(30128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.h
 * JD-Core Version:    0.7.0.1
 */