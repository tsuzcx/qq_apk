package com.tencent.mm.plugin.thumbplayer.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader$FileExpiredException;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader$DownloadException;", "code", "", "(I)V", "plugin-thumbplayer_release"})
public final class i$b
  extends i.a
{
  public i$b(int paramInt)
  {
    super("File is expired: code=".concat(String.valueOf(paramInt)));
    AppMethodBeat.i(189991);
    AppMethodBeat.o(189991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.i.b
 * JD-Core Version:    0.7.0.1
 */