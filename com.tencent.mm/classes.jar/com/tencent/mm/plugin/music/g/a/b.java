package com.tencent.mm.plugin.music.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public final class b
  implements IMediaHTTPService
{
  public final IMediaHTTPConnection makeHTTPConnection()
  {
    AppMethodBeat.i(137685);
    Logger.i("MicroMsg.MMMediaHTTPService", "makeHTTPConnection");
    a locala = new a();
    AppMethodBeat.o(137685);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.g.a.b
 * JD-Core Version:    0.7.0.1
 */