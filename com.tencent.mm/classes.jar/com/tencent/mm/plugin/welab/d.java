package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
{
  public static void a(a parama)
  {
    AppMethodBeat.i(146213);
    f localf = new f();
    localf.n("expid", parama.CTL + ",");
    localf.n("appid", parama.djj + ",");
    localf.n("action", parama.action + ",");
    localf.n("timestamp", parama.timeStamp + ",");
    StringBuilder localStringBuilder = new StringBuilder();
    if (parama.CTM) {}
    for (int i = 1;; i = 0)
    {
      localf.n("hasRedPoint", i + ",");
      ac.i("WelabReporter", "report " + localf.PS());
      h.wUl.f(14206, new Object[] { localf });
      AppMethodBeat.o(146213);
      return;
    }
  }
  
  public static void g(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146215);
    a locala = new a();
    locala.djj = paramString1;
    locala.action = paramInt;
    locala.timeStamp = System.currentTimeMillis();
    locala.CTL = paramString2;
    locala.CTM = paramBoolean;
    a(locala);
    AppMethodBeat.o(146215);
  }
  
  public static void v(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146214);
    a locala = new a();
    locala.djj = paramString;
    locala.action = paramInt;
    locala.timeStamp = System.currentTimeMillis();
    locala.CTL = a.eHv().aEn(paramString).field_expId;
    locala.CTM = paramBoolean;
    a(locala);
    AppMethodBeat.o(146214);
  }
  
  public static final class a
  {
    public String CTL;
    public boolean CTM;
    public int action;
    public String djj;
    public long timeStamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.d
 * JD-Core Version:    0.7.0.1
 */