package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class d$a
  implements com.tencent.xweb.x5.sdk.h
{
  private d$a(d paramd) {}
  
  public final void onDownloadFinish(int paramInt)
  {
    y.i("MicroMsg.MyTbsListener", "onDownloadFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
    k.eZ(5, paramInt);
    if (paramInt != 110)
    {
      if (paramInt != 100) {
        break label95;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(64, 64, 4, 3, 1, 1, false);
    }
    for (;;)
    {
      Object localObject = ae.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
      if (localObject != null)
      {
        y.i("MicroMsg.MyTbsListener", "tbs has download finished, save to sharedpreference");
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("tbs_download_finished", true);
        ((SharedPreferences.Editor)localObject).apply();
      }
      return;
      label95:
      com.tencent.mm.plugin.report.service.h.nFQ.a(64L, 3L, 1L, false);
    }
  }
  
  public final void onDownloadProgress(int paramInt) {}
  
  public final void onInstallFinish(int paramInt)
  {
    y.i("MicroMsg.MyTbsListener", "onInstallFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
    k.eZ(6, paramInt);
    if ((paramInt == 200) || (paramInt == 220))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(64, 64, 7, 6, 1, 1, false);
      d.b(this.ucL);
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(64L, 6L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.d.a
 * JD-Core Version:    0.7.0.1
 */