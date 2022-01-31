package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
{
  public static void A(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(80542);
    d.a locala = new d.a();
    locala.cwc = paramString1;
    locala.action = 8;
    locala.timeStamp = System.currentTimeMillis();
    locala.vuW = paramString2;
    locala.vuX = paramBoolean;
    a(locala);
    AppMethodBeat.o(80542);
  }
  
  public static void a(d.a parama)
  {
    AppMethodBeat.i(80540);
    com.tencent.mm.modelsns.d locald = new com.tencent.mm.modelsns.d();
    locald.k("expid", parama.vuW + ",");
    locald.k("appid", parama.cwc + ",");
    locald.k("action", parama.action + ",");
    locald.k("timestamp", parama.timeStamp + ",");
    StringBuilder localStringBuilder = new StringBuilder();
    if (parama.vuX) {}
    for (int i = 1;; i = 0)
    {
      locald.k("hasRedPoint", i + ",");
      ab.i("WelabReporter", "report " + locald.Fg());
      h.qsU.e(14206, new Object[] { locald });
      AppMethodBeat.o(80540);
      return;
    }
  }
  
  public static void t(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(80541);
    d.a locala = new d.a();
    locala.cwc = paramString;
    locala.action = paramInt;
    locala.timeStamp = System.currentTimeMillis();
    locala.vuW = a.dhl().ajs(paramString).field_expId;
    locala.vuX = paramBoolean;
    a(locala);
    AppMethodBeat.o(80541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.d
 * JD-Core Version:    0.7.0.1
 */