package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/CameraScanCombineActionReporter;", "", "()V", "report", "", "enterScene", "", "actionType", "actionResult", "", "tabEnterTs", "", "tabSession", "scanSession", "detectSession", "itemSource", "itemType", "cardType", "cardTitle", "preloadType", "enterSession", "errorCode", "ActionType", "CardType", "ErrorCode", "ItemSource", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c ORj;
  
  static
  {
    AppMethodBeat.i(314389);
    ORj = new c();
    AppMethodBeat.o(314389);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, int paramInt3, int paramInt4, int paramInt5, String paramString5, String paramString6, int paramInt6)
  {
    AppMethodBeat.i(314383);
    s.u(paramString1, "actionResult");
    s.u(paramString2, "tabSession");
    s.u(paramString3, "scanSession");
    s.u(paramString4, "detectSession");
    s.u(paramString5, "cardTitle");
    s.u(paramString6, "enterSession");
    h.OAn.b(24121, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Long.valueOf(paramLong), paramString2, paramString3, paramString4, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), paramString5, Integer.valueOf(0), paramString6, Integer.valueOf(paramInt6) });
    AppMethodBeat.o(314383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.c
 * JD-Core Version:    0.7.0.1
 */