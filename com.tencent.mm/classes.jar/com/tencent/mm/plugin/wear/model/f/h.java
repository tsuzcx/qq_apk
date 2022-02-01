package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.drf;
import com.tencent.mm.protocal.protobuf.drg;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends b
{
  private long dEb;
  private String dEc;
  private List<String> dEd;
  private long msgId;
  
  public h(long paramLong1, long paramLong2, String paramString, List<String> paramList)
  {
    this.msgId = paramLong1;
    this.dEb = paramLong2;
    this.dEc = paramString;
    this.dEd = paramList;
  }
  
  public final String getName()
  {
    return "WearLuckyReceiveTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30128);
    drf localdrf = new drf();
    localdrf.EGt = this.dEb;
    localdrf.CCn = this.msgId;
    localdrf.EGu = this.dEc;
    try
    {
      if (this.dEd != null)
      {
        Iterator localIterator = this.dEd.iterator();
        while (localIterator.hasNext())
        {
          String[] arrayOfString = ((String)localIterator.next()).split("=");
          drg localdrg = new drg();
          localdrg.Egc = arrayOfString[0];
          localdrg.mBV = arrayOfString[1];
          if (localdrg.mBV.startsWith("wxid")) {
            localdrg.mBV = v.sh(localdrg.mBV);
          }
          localdrg.EGt = Long.valueOf(arrayOfString[2]).longValue();
          localdrf.EGv.add(localdrg);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (this.dEb > 0L)
      {
        com.tencent.mm.plugin.wear.model.c.a.tb(true);
        AppMethodBeat.o(30128);
        return;
        com.tencent.mm.plugin.wear.model.a.egZ();
        r.a(20015, localException.toByteArray(), true);
      }
      com.tencent.mm.plugin.wear.model.c.a.tb(false);
      AppMethodBeat.o(30128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.h
 * JD-Core Version:    0.7.0.1
 */