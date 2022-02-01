package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
{
  public static void a(a parama)
  {
    AppMethodBeat.i(146213);
    com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
    localg.m("expid", parama.ExL + ",");
    localg.m("appid", parama.duW + ",");
    localg.m("action", parama.action + ",");
    localg.m("timestamp", parama.timeStamp + ",");
    StringBuilder localStringBuilder = new StringBuilder();
    if (parama.ExM) {}
    for (int i = 1;; i = 0)
    {
      localg.m("hasRedPoint", i + ",");
      ad.i("WelabReporter", "report " + localg.RE());
      com.tencent.mm.plugin.report.service.g.yhR.f(14206, new Object[] { localg });
      AppMethodBeat.o(146213);
      return;
    }
  }
  
  public static void g(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146215);
    a locala = new a();
    locala.duW = paramString1;
    locala.action = paramInt;
    locala.timeStamp = System.currentTimeMillis();
    locala.ExL = paramString2;
    locala.ExM = paramBoolean;
    a(locala);
    AppMethodBeat.o(146215);
  }
  
  public static void v(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146214);
    a locala = new a();
    locala.duW = paramString;
    locala.action = paramInt;
    locala.timeStamp = System.currentTimeMillis();
    locala.ExL = a.eWo().aJN(paramString).field_expId;
    locala.ExM = paramBoolean;
    a(locala);
    AppMethodBeat.o(146214);
  }
  
  public static final class a
  {
    public String ExL;
    public boolean ExM;
    public int action;
    public String duW;
    public long timeStamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.d
 * JD-Core Version:    0.7.0.1
 */