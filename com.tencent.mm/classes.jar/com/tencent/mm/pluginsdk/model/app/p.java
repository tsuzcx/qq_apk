package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/app/AppPackageCallReportUtil;", "", "()V", "report", "", "pkg", "", "scene", "", "Scene", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  public static final p XSE;
  
  static
  {
    AppMethodBeat.i(244896);
    XSE = new p();
    AppMethodBeat.o(244896);
  }
  
  public static final void dh(String paramString, int paramInt)
  {
    AppMethodBeat.i(244893);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(244893);
      return;
    }
    h.OAn.b(23961, new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(244893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.p
 * JD-Core Version:    0.7.0.1
 */