package com.tencent.xweb.xwalk;

import android.content.Context;
import android.webkit.DownloadListener;
import org.xwalk.core.XWalkDownloadListener;

public final class e$e
  extends XWalkDownloadListener
{
  DownloadListener xki;
  
  public e$e(Context paramContext, DownloadListener paramDownloadListener)
  {
    super(paramContext);
    this.xki = paramDownloadListener;
  }
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (this.xki != null) {
      this.xki.onDownloadStart(paramString1, paramString2, paramString3, paramString4, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.e.e
 * JD-Core Version:    0.7.0.1
 */