package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.fjm;
import com.tencent.mm.protocal.protobuf.fjn;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends b
{
  private long gbJ;
  private String gbK;
  private List<String> gbL;
  private long msgId;
  
  public h(long paramLong1, long paramLong2, String paramString, List<String> paramList)
  {
    this.msgId = paramLong1;
    this.gbJ = paramLong2;
    this.gbK = paramString;
    this.gbL = paramList;
  }
  
  protected final void gOA()
  {
    AppMethodBeat.i(30128);
    fjm localfjm = new fjm();
    localfjm.UIH = this.gbJ;
    localfjm.RNj = this.msgId;
    localfjm.UII = this.gbK;
    try
    {
      if (this.gbL != null)
      {
        Iterator localIterator = this.gbL.iterator();
        while (localIterator.hasNext())
        {
          String[] arrayOfString = ((String)localIterator.next()).split("=");
          fjn localfjn = new fjn();
          localfjn.Ueg = arrayOfString[0];
          localfjn.rWI = arrayOfString[1];
          if (localfjn.rWI.startsWith("wxid")) {
            localfjn.rWI = aa.PJ(localfjn.rWI);
          }
          localfjn.UIH = Long.valueOf(arrayOfString[2]).longValue();
          localfjm.UIJ.add(localfjn);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (this.gbJ > 0L)
      {
        com.tencent.mm.plugin.wear.model.c.a.CE(true);
        AppMethodBeat.o(30128);
        return;
        com.tencent.mm.plugin.wear.model.a.gOx();
        r.a(20015, localException.toByteArray(), true);
      }
      com.tencent.mm.plugin.wear.model.c.a.CE(false);
      AppMethodBeat.o(30128);
    }
  }
  
  public final String getName()
  {
    return "WearLuckyReceiveTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.h
 * JD-Core Version:    0.7.0.1
 */