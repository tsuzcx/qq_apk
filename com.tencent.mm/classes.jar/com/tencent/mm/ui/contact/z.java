package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class z
{
  public static void Qv(int paramInt)
  {
    AppMethodBeat.i(105264);
    ab.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomClick %d %d", new Object[] { Integer.valueOf(13941), Integer.valueOf(paramInt) });
    h.qsU.e(13941, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(105264);
  }
  
  public static final void r(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(105263);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(105263);
      return;
    }
    paramString = String.format("%s,%d,%d,%d,%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(0) });
    ab.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[] { paramString });
    h.qsU.kvStat(13234, paramString);
    AppMethodBeat.o(105263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.z
 * JD-Core Version:    0.7.0.1
 */