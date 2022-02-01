package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
{
  public static void a(a parama)
  {
    AppMethodBeat.i(146213);
    m localm = new m();
    localm.n("expid", parama.JFU + ",");
    localm.n("appid", parama.dNI + ",");
    localm.n("action", parama.action + ",");
    localm.n("timestamp", parama.timeStamp + ",");
    StringBuilder localStringBuilder = new StringBuilder();
    if (parama.JFV) {}
    for (int i = 1;; i = 0)
    {
      localm.n("hasRedPoint", i + ",");
      Log.i("WelabReporter", "report " + localm.abW());
      h.CyF.a(14206, new Object[] { localm });
      AppMethodBeat.o(146213);
      return;
    }
  }
  
  public static void f(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146215);
    a locala = new a();
    locala.dNI = paramString1;
    locala.action = paramInt;
    locala.timeStamp = System.currentTimeMillis();
    locala.JFU = paramString2;
    locala.JFV = paramBoolean;
    a(locala);
    AppMethodBeat.o(146215);
  }
  
  public static void y(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146214);
    a locala = new a();
    locala.dNI = paramString;
    locala.action = paramInt;
    locala.timeStamp = System.currentTimeMillis();
    locala.JFU = a.gjg().bbz(paramString).field_expId;
    locala.JFV = paramBoolean;
    a(locala);
    AppMethodBeat.o(146214);
  }
  
  public static final class a
  {
    public String JFU;
    public boolean JFV;
    public int action;
    public String dNI;
    public long timeStamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.d
 * JD-Core Version:    0.7.0.1
 */