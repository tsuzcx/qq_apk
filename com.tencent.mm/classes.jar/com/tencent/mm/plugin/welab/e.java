package com.tencent.mm.plugin.welab;

import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  public static void a(e.a parama)
  {
    d locald = new d();
    locald.j("expid", parama.rEu + ",");
    locald.j("appid", parama.bOL + ",");
    locald.j("action", parama.action + ",");
    locald.j("timestamp", parama.timeStamp + ",");
    StringBuilder localStringBuilder = new StringBuilder();
    if (parama.rEv) {}
    for (int i = 1;; i = 0)
    {
      locald.j("hasRedPoint", i + ",");
      y.i("WelabReporter", "report " + locald.uJ());
      h.nFQ.f(14206, new Object[] { locald });
      return;
    }
  }
  
  public static void q(String paramString, int paramInt, boolean paramBoolean)
  {
    e.a locala = new e.a();
    locala.bOL = paramString;
    locala.action = paramInt;
    locala.timeStamp = System.currentTimeMillis();
    locala.rEu = b.chc().Uf(paramString).field_expId;
    locala.rEv = paramBoolean;
    a(locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e
 * JD-Core Version:    0.7.0.1
 */