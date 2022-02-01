package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.eyv;
import com.tencent.mm.protocal.protobuf.eyw;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends b
{
  private long eht;
  private String ehu;
  private List<String> ehv;
  private long msgId;
  
  public h(long paramLong1, long paramLong2, String paramString, List<String> paramList)
  {
    this.msgId = paramLong1;
    this.eht = paramLong2;
    this.ehu = paramString;
    this.ehv = paramList;
  }
  
  public final String getName()
  {
    return "WearLuckyReceiveTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30128);
    eyv localeyv = new eyv();
    localeyv.Nvw = this.eht;
    localeyv.KMm = this.msgId;
    localeyv.Nvx = this.ehu;
    try
    {
      if (this.ehv != null)
      {
        Iterator localIterator = this.ehv.iterator();
        while (localIterator.hasNext())
        {
          String[] arrayOfString = ((String)localIterator.next()).split("=");
          eyw localeyw = new eyw();
          localeyw.MRZ = arrayOfString[0];
          localeyw.oUJ = arrayOfString[1];
          if (localeyw.oUJ.startsWith("wxid")) {
            localeyw.oUJ = aa.getDisplayName(localeyw.oUJ);
          }
          localeyw.Nvw = Long.valueOf(arrayOfString[2]).longValue();
          localeyv.Nvy.add(localeyw);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (this.eht > 0L)
      {
        com.tencent.mm.plugin.wear.model.c.a.yJ(true);
        AppMethodBeat.o(30128);
        return;
        com.tencent.mm.plugin.wear.model.a.fVQ();
        r.a(20015, localException.toByteArray(), true);
      }
      com.tencent.mm.plugin.wear.model.c.a.yJ(false);
      AppMethodBeat.o(30128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.h
 * JD-Core Version:    0.7.0.1
 */