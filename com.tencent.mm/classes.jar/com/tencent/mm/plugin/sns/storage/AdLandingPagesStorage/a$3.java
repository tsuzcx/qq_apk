package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.api.a.a;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class a$3
  implements a.b
{
  public a$3(a parama) {}
  
  public final void a(a.a parama, long paramLong)
  {
    AppMethodBeat.i(96292);
    Log.d("MicroMsg.AdDownloadApkMgr", "downloadId=" + paramLong + ", result=" + parama);
    AppMethodBeat.o(96292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.3
 * JD-Core Version:    0.7.0.1
 */