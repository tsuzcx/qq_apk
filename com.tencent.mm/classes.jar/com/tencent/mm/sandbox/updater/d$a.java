package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class d$a
  implements com.tencent.xweb.x5.sdk.h
{
  private d$a(d paramd) {}
  
  public final void onDownloadFinish(int paramInt)
  {
    AppMethodBeat.i(28881);
    ab.i("MicroMsg.MyTbsListener", "onDownloadFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
    m.gK(5, paramInt);
    if (paramInt != 110)
    {
      if (paramInt != 100) {
        break label107;
      }
      com.tencent.mm.plugin.report.service.h.qsU.a(64, 64, 4, 3, 1, 1, false);
    }
    for (;;)
    {
      Object localObject = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
      if (localObject != null)
      {
        ab.i("MicroMsg.MyTbsListener", "tbs has download finished, save to sharedpreference");
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("tbs_download_finished", true);
        ((SharedPreferences.Editor)localObject).apply();
      }
      AppMethodBeat.o(28881);
      return;
      label107:
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(64L, 3L, 1L, false);
    }
  }
  
  public final void onDownloadProgress(int paramInt) {}
  
  public final void onInstallFinish(int paramInt)
  {
    AppMethodBeat.i(28882);
    ab.i("MicroMsg.MyTbsListener", "onInstallFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
    m.gK(6, paramInt);
    if ((paramInt == 200) || (paramInt == 220))
    {
      com.tencent.mm.plugin.report.service.h.qsU.a(64, 64, 7, 6, 1, 1, false);
      d.b(this.yla);
      AppMethodBeat.o(28882);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(64L, 6L, 1L, false);
    AppMethodBeat.o(28882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.d.a
 * JD-Core Version:    0.7.0.1
 */