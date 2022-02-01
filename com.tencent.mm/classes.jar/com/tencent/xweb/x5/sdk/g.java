package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;

public final class g
  implements b
{
  public final boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, f.a parama)
  {
    AppMethodBeat.i(154141);
    if (parama == null)
    {
      paramBoolean1 = TbsDownloader.needDownload(paramContext, paramBoolean1, paramBoolean2, null);
      AppMethodBeat.o(154141);
      return paramBoolean1;
    }
    paramBoolean1 = TbsDownloader.needDownload(paramContext, paramBoolean1, paramBoolean2, new a(parama));
    AppMethodBeat.o(154141);
    return paramBoolean1;
  }
  
  public final boolean isDownloadForeground()
  {
    AppMethodBeat.i(154145);
    boolean bool = TbsDownloader.isDownloadForeground();
    AppMethodBeat.o(154145);
    return bool;
  }
  
  public final boolean isDownloading()
  {
    AppMethodBeat.i(154144);
    boolean bool = TbsDownloader.isDownloading();
    AppMethodBeat.o(154144);
    return bool;
  }
  
  public final boolean lE(Context paramContext)
  {
    AppMethodBeat.i(154140);
    boolean bool = TbsDownloader.needSendRequest(paramContext, false);
    AppMethodBeat.o(154140);
    return bool;
  }
  
  public final void startDownload(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(154142);
    TbsDownloader.startDownload(paramContext, paramBoolean);
    AppMethodBeat.o(154142);
  }
  
  public final void stopDownload()
  {
    AppMethodBeat.i(154143);
    TbsDownloader.stopDownload();
    AppMethodBeat.o(154143);
  }
  
  static final class a
    implements TbsDownloader.TbsDownloaderCallback
  {
    f.a SFK;
    
    public a(f.a parama)
    {
      this.SFK = parama;
    }
    
    public final void onNeedDownloadFinish(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(154139);
      if (this.SFK != null) {
        this.SFK.onNeedDownloadFinish(paramBoolean, paramInt);
      }
      AppMethodBeat.o(154139);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.g
 * JD-Core Version:    0.7.0.1
 */