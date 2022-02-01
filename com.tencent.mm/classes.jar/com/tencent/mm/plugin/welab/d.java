package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
{
  public static void a(a parama)
  {
    AppMethodBeat.i(146213);
    com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
    localg.m("expid", parama.EQh + ",");
    localg.m("appid", parama.dwb + ",");
    localg.m("action", parama.action + ",");
    localg.m("timestamp", parama.timeStamp + ",");
    StringBuilder localStringBuilder = new StringBuilder();
    if (parama.EQi) {}
    for (int i = 1;; i = 0)
    {
      localg.m("hasRedPoint", i + ",");
      ae.i("WelabReporter", "report " + localg.RD());
      com.tencent.mm.plugin.report.service.g.yxI.f(14206, new Object[] { localg });
      AppMethodBeat.o(146213);
      return;
    }
  }
  
  public static void g(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146215);
    a locala = new a();
    locala.dwb = paramString1;
    locala.action = paramInt;
    locala.timeStamp = System.currentTimeMillis();
    locala.EQh = paramString2;
    locala.EQi = paramBoolean;
    a(locala);
    AppMethodBeat.o(146215);
  }
  
  public static void v(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146214);
    a locala = new a();
    locala.dwb = paramString;
    locala.action = paramInt;
    locala.timeStamp = System.currentTimeMillis();
    locala.EQh = a.faa().aLj(paramString).field_expId;
    locala.EQi = paramBoolean;
    a(locala);
    AppMethodBeat.o(146214);
  }
  
  public static final class a
  {
    public String EQh;
    public boolean EQi;
    public int action;
    public String dwb;
    public long timeStamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.d
 * JD-Core Version:    0.7.0.1
 */