package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ac
{
  public static void anJ(int paramInt)
  {
    AppMethodBeat.i(102928);
    Log.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomClick %d %d", new Object[] { Integer.valueOf(13941), Integer.valueOf(paramInt) });
    h.CyF.a(13941, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(102928);
  }
  
  public static final void u(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(102927);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102927);
      return;
    }
    paramString = String.format("%s,%d,%d,%d,%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(0) });
    Log.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[] { paramString });
    h.CyF.kvStat(13234, paramString);
    AppMethodBeat.o(102927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ac
 * JD-Core Version:    0.7.0.1
 */