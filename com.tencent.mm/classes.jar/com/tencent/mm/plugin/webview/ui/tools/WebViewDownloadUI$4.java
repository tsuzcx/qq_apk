package com.tencent.mm.plugin.webview.ui.tools;

import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WebViewDownloadUI$4
  implements k
{
  WebViewDownloadUI$4(WebViewDownloadUI paramWebViewDownloadUI) {}
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    y.i("MicroMsg.WebViewDownloadUI", "onTaskFailed id=%d, errCode=%d, hasChangeUrl=%b", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Toast.makeText(this.rmD.mController.uMN, this.rmD.getString(R.l.webview_download_ui_download_failed), 1).show();
    this.rmD.finish();
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.WebViewDownloadUI", "onTaskFinished id=%d, savedFilePath=%s, hasChangeUrl=%b", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean) });
    Toast.makeText(this.rmD.mController.uMN, this.rmD.getString(R.l.webview_download_ui_downloaded_suc), 1).show();
    this.rmD.finish();
  }
  
  public final void cy(long paramLong) {}
  
  public final void cz(long paramLong) {}
  
  public final void k(long paramLong, String paramString)
  {
    y.i("MicroMsg.WebViewDownloadUI", "onTaskResumed id=%d, savedFilePath=%s", new Object[] { Long.valueOf(paramLong), paramString });
  }
  
  public final void onTaskPaused(long paramLong)
  {
    y.i("MicroMsg.WebViewDownloadUI", "onTaskPaused id=%d", new Object[] { Long.valueOf(paramLong) });
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    y.i("MicroMsg.WebViewDownloadUI", "onTaskRemoved id=%d", new Object[] { Long.valueOf(paramLong) });
    this.rmD.finish();
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    y.i("MicroMsg.WebViewDownloadUI", "onTaskStarted id=%d, savedFilePath=%s", new Object[] { Long.valueOf(paramLong), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI.4
 * JD-Core Version:    0.7.0.1
 */