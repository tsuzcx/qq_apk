package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.welab.d.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  public static void E(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146214);
    a locala = new a();
    locala.appid = paramString;
    locala.action = paramInt;
    locala.timeStamp = System.currentTimeMillis();
    paramString = b.iDA().bnn(paramString);
    if (paramString != null) {}
    for (paramString = paramString.field_expId;; paramString = "")
    {
      locala.XyE = paramString;
      locala.XyF = paramBoolean;
      a(locala);
      AppMethodBeat.o(146214);
      return;
    }
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(146213);
    n localn = new n();
    localn.s("expid", parama.XyE + ",");
    localn.s("appid", parama.appid + ",");
    localn.s("action", parama.action + ",");
    localn.s("timestamp", parama.timeStamp + ",");
    StringBuilder localStringBuilder = new StringBuilder();
    if (parama.XyF) {}
    for (int i = 1;; i = 0)
    {
      localn.s("hasRedPoint", i + ",");
      Log.i("WelabReporter", "report " + localn.aIF());
      h.OAn.b(14206, new Object[] { localn });
      AppMethodBeat.o(146213);
      return;
    }
  }
  
  public static void c(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146215);
    a locala = new a();
    locala.appid = paramString1;
    locala.action = paramInt;
    locala.timeStamp = System.currentTimeMillis();
    locala.XyE = paramString2;
    locala.XyF = paramBoolean;
    a(locala);
    AppMethodBeat.o(146215);
  }
  
  public static final class a
  {
    public String XyE;
    public boolean XyF;
    public int action;
    public String appid;
    public long timeStamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e
 * JD-Core Version:    0.7.0.1
 */