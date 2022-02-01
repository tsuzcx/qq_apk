package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class ac
{
  public static void aeY(int paramInt)
  {
    AppMethodBeat.i(102928);
    ae.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomClick %d %d", new Object[] { Integer.valueOf(13941), Integer.valueOf(paramInt) });
    g.yxI.f(13941, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(102928);
  }
  
  public static final void u(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(102927);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102927);
      return;
    }
    paramString = String.format("%s,%d,%d,%d,%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(0) });
    ae.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[] { paramString });
    g.yxI.kvStat(13234, paramString);
    AppMethodBeat.o(102927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ac
 * JD-Core Version:    0.7.0.1
 */