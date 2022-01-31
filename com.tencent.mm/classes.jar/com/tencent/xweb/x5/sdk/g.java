package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloader;

public final class g
  implements b
{
  public final boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, f.a parama)
  {
    AppMethodBeat.i(85111);
    if (parama == null)
    {
      paramBoolean1 = TbsDownloader.needDownload(paramContext, paramBoolean1, paramBoolean2, null);
      AppMethodBeat.o(85111);
      return paramBoolean1;
    }
    paramBoolean1 = TbsDownloader.needDownload(paramContext, paramBoolean1, paramBoolean2, new g.a(parama));
    AppMethodBeat.o(85111);
    return paramBoolean1;
  }
  
  public final boolean isDownloadForeground()
  {
    AppMethodBeat.i(85115);
    boolean bool = TbsDownloader.isDownloadForeground();
    AppMethodBeat.o(85115);
    return bool;
  }
  
  public final boolean isDownloading()
  {
    AppMethodBeat.i(85114);
    boolean bool = TbsDownloader.isDownloading();
    AppMethodBeat.o(85114);
    return bool;
  }
  
  public final boolean jU(Context paramContext)
  {
    AppMethodBeat.i(85110);
    boolean bool = TbsDownloader.needSendRequest(paramContext, false);
    AppMethodBeat.o(85110);
    return bool;
  }
  
  public final void startDownload(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(85112);
    TbsDownloader.startDownload(paramContext, paramBoolean);
    AppMethodBeat.o(85112);
  }
  
  public final void stopDownload()
  {
    AppMethodBeat.i(85113);
    TbsDownloader.stopDownload();
    AppMethodBeat.o(85113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.g
 * JD-Core Version:    0.7.0.1
 */