package com.tencent.xweb.x5.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;

final class g$a
  implements TbsDownloader.TbsDownloaderCallback
{
  f.a BIC;
  
  public g$a(f.a parama)
  {
    this.BIC = parama;
  }
  
  public final void onNeedDownloadFinish(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(85109);
    if (this.BIC != null) {
      this.BIC.onNeedDownloadFinish(paramBoolean, paramInt);
    }
    AppMethodBeat.o(85109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.g.a
 * JD-Core Version:    0.7.0.1
 */