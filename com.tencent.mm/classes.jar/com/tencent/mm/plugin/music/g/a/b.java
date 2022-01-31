package com.tencent.mm.plugin.music.g.a;

import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public final class b
  implements IMediaHTTPService
{
  public final IMediaHTTPConnection makeHTTPConnection()
  {
    Logger.i("MicroMsg.MMMediaHTTPService", "makeHTTPConnection");
    return new a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.g.a.b
 * JD-Core Version:    0.7.0.1
 */