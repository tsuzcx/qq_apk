package com.tencent.mm.plugin.thumbplayer.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader$TimeoutException;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader$DownloadException;", "code", "", "(I)V", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$c
  extends i.a
{
  public i$c(int paramInt)
  {
    super(s.X("Timeout to transfer: code=", Integer.valueOf(paramInt)));
    AppMethodBeat.i(272143);
    AppMethodBeat.o(272143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.downloader.i.c
 * JD-Core Version:    0.7.0.1
 */