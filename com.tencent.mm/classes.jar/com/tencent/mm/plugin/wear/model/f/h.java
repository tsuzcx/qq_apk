package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.cxb;
import com.tencent.mm.protocal.protobuf.cxc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends b
{
  private long cNd;
  private String cNe;
  private List<String> cNf;
  private long cpO;
  
  public h(long paramLong1, long paramLong2, String paramString, List<String> paramList)
  {
    this.cpO = paramLong1;
    this.cNd = paramLong2;
    this.cNe = paramString;
    this.cNf = paramList;
  }
  
  public final String getName()
  {
    return "WearLuckyReceiveTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(26446);
    cxb localcxb = new cxb();
    localcxb.yeJ = this.cNd;
    localcxb.wsz = this.cpO;
    localcxb.yeK = this.cNe;
    try
    {
      if (this.cNf != null)
      {
        Iterator localIterator = this.cNf.iterator();
        while (localIterator.hasNext())
        {
          String[] arrayOfString = ((String)localIterator.next()).split("=");
          cxc localcxc = new cxc();
          localcxc.xlH = arrayOfString[0];
          localcxc.jKG = arrayOfString[1];
          if (localcxc.jKG.startsWith("wxid")) {
            localcxc.jKG = s.nE(localcxc.jKG);
          }
          localcxc.yeJ = Long.valueOf(arrayOfString[2]).longValue();
          localcxb.yeL.add(localcxc);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (this.cNd > 0L)
      {
        com.tencent.mm.plugin.wear.model.c.a.og(true);
        AppMethodBeat.o(26446);
        return;
        com.tencent.mm.plugin.wear.model.a.cYy();
        r.a(20015, localException.toByteArray(), true);
      }
      com.tencent.mm.plugin.wear.model.c.a.og(false);
      AppMethodBeat.o(26446);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.h
 * JD-Core Version:    0.7.0.1
 */