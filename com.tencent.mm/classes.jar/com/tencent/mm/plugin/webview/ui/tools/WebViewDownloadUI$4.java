package com.tencent.mm.plugin.webview.ui.tools;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ab;

final class WebViewDownloadUI$4
  implements m
{
  WebViewDownloadUI$4(WebViewDownloadUI paramWebViewDownloadUI) {}
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(7599);
    ab.i("MicroMsg.WebViewDownloadUI", "onTaskFailed id=%d, errCode=%d, hasChangeUrl=%b", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Toast.makeText(this.vcl.getContext(), this.vcl.getString(2131305851), 1).show();
    this.vcl.finish();
    AppMethodBeat.o(7599);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(7598);
    ab.i("MicroMsg.WebViewDownloadUI", "onTaskFinished id=%d, savedFilePath=%s, hasChangeUrl=%b", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean) });
    Toast.makeText(this.vcl.getContext(), this.vcl.getString(2131305854), 1).show();
    this.vcl.finish();
    AppMethodBeat.o(7598);
  }
  
  public final void hx(long paramLong) {}
  
  public final void hy(long paramLong) {}
  
  public final void i(long paramLong, String paramString)
  {
    AppMethodBeat.i(7602);
    ab.i("MicroMsg.WebViewDownloadUI", "onTaskResumed id=%d, savedFilePath=%s", new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(7602);
  }
  
  public final void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(7601);
    ab.i("MicroMsg.WebViewDownloadUI", "onTaskPaused id=%d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(7601);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(7600);
    ab.i("MicroMsg.WebViewDownloadUI", "onTaskRemoved id=%d", new Object[] { Long.valueOf(paramLong) });
    this.vcl.finish();
    AppMethodBeat.o(7600);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(7597);
    ab.i("MicroMsg.WebViewDownloadUI", "onTaskStarted id=%d, savedFilePath=%s", new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(7597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI.4
 * JD-Core Version:    0.7.0.1
 */