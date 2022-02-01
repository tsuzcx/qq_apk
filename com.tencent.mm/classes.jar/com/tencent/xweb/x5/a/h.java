package com.tencent.xweb.x5.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;

public final class h
  implements b
{
  public final boolean a(Context paramContext, boolean paramBoolean, g.a parama)
  {
    AppMethodBeat.i(213143);
    if (parama == null)
    {
      paramBoolean = TbsDownloader.needDownload(paramContext, paramBoolean, false, null);
      AppMethodBeat.o(213143);
      return paramBoolean;
    }
    paramBoolean = TbsDownloader.needDownload(paramContext, paramBoolean, false, new a(parama));
    AppMethodBeat.o(213143);
    return paramBoolean;
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
  
  public final boolean oZ(Context paramContext)
  {
    AppMethodBeat.i(154140);
    boolean bool = TbsDownloader.needSendRequest(paramContext, false);
    AppMethodBeat.o(154140);
    return bool;
  }
  
  public final void pa(Context paramContext)
  {
    AppMethodBeat.i(213147);
    TbsDownloader.startDownload(paramContext, false);
    AppMethodBeat.o(213147);
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
    g.a ainF;
    
    public a(g.a parama)
    {
      this.ainF = parama;
    }
    
    public final void onNeedDownloadFinish(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(154139);
      if (this.ainF != null) {
        this.ainF.onNeedDownloadFinish(paramBoolean, paramInt);
      }
      AppMethodBeat.o(154139);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.x5.a.h
 * JD-Core Version:    0.7.0.1
 */