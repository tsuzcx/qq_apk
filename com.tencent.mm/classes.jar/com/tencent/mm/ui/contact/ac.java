package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bs;

public final class ac
{
  public static void abS(int paramInt)
  {
    AppMethodBeat.i(102928);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomClick %d %d", new Object[] { Integer.valueOf(13941), Integer.valueOf(paramInt) });
    h.wUl.f(13941, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(102928);
  }
  
  public static final void u(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(102927);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102927);
      return;
    }
    paramString = String.format("%s,%d,%d,%d,%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(0) });
    com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[] { paramString });
    h.wUl.kvStat(13234, paramString);
    AppMethodBeat.o(102927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ac
 * JD-Core Version:    0.7.0.1
 */