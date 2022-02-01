package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
{
  public static void a(a parama)
  {
    AppMethodBeat.i(146213);
    f localf = new f();
    localf.o("expid", parama.BBF + ",");
    localf.o("appid", parama.dlB + ",");
    localf.o("action", parama.action + ",");
    localf.o("timestamp", parama.timeStamp + ",");
    StringBuilder localStringBuilder = new StringBuilder();
    if (parama.BBG) {}
    for (int i = 1;; i = 0)
    {
      localf.o("hasRedPoint", i + ",");
      ad.i("WelabReporter", "report " + localf.PW());
      h.vKh.f(14206, new Object[] { localf });
      AppMethodBeat.o(146213);
      return;
    }
  }
  
  public static void g(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146215);
    a locala = new a();
    locala.dlB = paramString1;
    locala.action = paramInt;
    locala.timeStamp = System.currentTimeMillis();
    locala.BBF = paramString2;
    locala.BBG = paramBoolean;
    a(locala);
    AppMethodBeat.o(146215);
  }
  
  public static void v(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146214);
    a locala = new a();
    locala.dlB = paramString;
    locala.action = paramInt;
    locala.timeStamp = System.currentTimeMillis();
    locala.BBF = a.esb().ayW(paramString).field_expId;
    locala.BBG = paramBoolean;
    a(locala);
    AppMethodBeat.o(146214);
  }
  
  public static final class a
  {
    public String BBF;
    public boolean BBG;
    public int action;
    public String dlB;
    public long timeStamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.d
 * JD-Core Version:    0.7.0.1
 */