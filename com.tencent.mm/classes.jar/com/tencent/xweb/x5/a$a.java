package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
  implements com.tencent.smtt.sdk.DownloadListener
{
  android.webkit.DownloadListener aimQ;
  
  public a$a(android.webkit.DownloadListener paramDownloadListener)
  {
    this.aimQ = paramDownloadListener;
  }
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(153812);
    if (this.aimQ != null) {
      this.aimQ.onDownloadStart(paramString1, paramString2, paramString3, paramString4, paramLong);
    }
    AppMethodBeat.o(153812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.a.a
 * JD-Core Version:    0.7.0.1
 */