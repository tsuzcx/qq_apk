package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.smtt.sdk.TbsDownloader;

public final class g
  implements b
{
  public final boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, f.a parama)
  {
    if (parama == null) {
      return TbsDownloader.needDownload(paramContext, paramBoolean1, paramBoolean2, null);
    }
    return TbsDownloader.needDownload(paramContext, paramBoolean1, paramBoolean2, new g.a(parama));
  }
  
  public final boolean in(Context paramContext)
  {
    return TbsDownloader.needSendRequest(paramContext, false);
  }
  
  public final boolean isDownloadForeground()
  {
    return TbsDownloader.isDownloadForeground();
  }
  
  public final boolean isDownloading()
  {
    return TbsDownloader.isDownloading();
  }
  
  public final void startDownload(Context paramContext, boolean paramBoolean)
  {
    TbsDownloader.startDownload(paramContext, paramBoolean);
  }
  
  public final void stopDownload() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.g
 * JD-Core Version:    0.7.0.1
 */