package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.welab.d.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  public static void C(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146214);
    a locala = new a();
    locala.appid = paramString;
    locala.action = paramInt;
    locala.timeStamp = System.currentTimeMillis();
    locala.QFg = b.hcS().bnz(paramString).field_expId;
    locala.QFh = paramBoolean;
    a(locala);
    AppMethodBeat.o(146214);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(146213);
    n localn = new n();
    localn.m("expid", parama.QFg + ",");
    localn.m("appid", parama.appid + ",");
    localn.m("action", parama.action + ",");
    localn.m("timestamp", parama.timeStamp + ",");
    StringBuilder localStringBuilder = new StringBuilder();
    if (parama.QFh) {}
    for (int i = 1;; i = 0)
    {
      localn.m("hasRedPoint", i + ",");
      Log.i("WelabReporter", "report " + localn.agI());
      h.IzE.a(14206, new Object[] { localn });
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
    locala.QFg = paramString2;
    locala.QFh = paramBoolean;
    a(locala);
    AppMethodBeat.o(146215);
  }
  
  public static final class a
  {
    public String QFg;
    public boolean QFh;
    public int action;
    public String appid;
    public long timeStamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e
 * JD-Core Version:    0.7.0.1
 */