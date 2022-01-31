package com.tencent.xweb.x5.sdk;

import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;

final class g$a
  implements TbsDownloader.TbsDownloaderCallback
{
  f.a xkW;
  
  public g$a(f.a parama)
  {
    this.xkW = parama;
  }
  
  public final void onNeedDownloadFinish(boolean paramBoolean, int paramInt)
  {
    if (this.xkW != null) {
      this.xkW.onNeedDownloadFinish(paramBoolean, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.g.a
 * JD-Core Version:    0.7.0.1
 */