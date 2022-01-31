package com.tencent.mm.ui.contact;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;

public final class y
{
  public static void HM(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomClick %d %d", new Object[] { Integer.valueOf(13941), Integer.valueOf(paramInt) });
    h.nFQ.f(13941, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static final void o(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (bk.bl(paramString)) {
      return;
    }
    paramString = String.format("%s,%d,%d,%d,%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(0) });
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[] { paramString });
    h.nFQ.aC(13234, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.y
 * JD-Core Version:    0.7.0.1
 */