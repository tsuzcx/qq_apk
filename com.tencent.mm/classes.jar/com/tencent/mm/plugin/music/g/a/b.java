package com.tencent.mm.plugin.music.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
  implements IMediaHTTPService
{
  private final Map<String, String> LOx;
  
  public b()
  {
    AppMethodBeat.i(270833);
    this.LOx = new ConcurrentHashMap();
    AppMethodBeat.o(270833);
  }
  
  public final void kA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(270835);
    Logger.d("MicroMsg.MMMediaHTTPService", "setReferrer, originUrl: " + paramString1 + ", referrer: " + paramString2);
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    this.LOx.put(paramString1, str);
    AppMethodBeat.o(270835);
  }
  
  public final IMediaHTTPConnection makeHTTPConnection()
  {
    AppMethodBeat.i(137437);
    Logger.i("MicroMsg.MMMediaHTTPService", "makeHTTPConnection");
    a locala = new a(Collections.unmodifiableMap(this.LOx));
    AppMethodBeat.o(137437);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.g.a.b
 * JD-Core Version:    0.7.0.1
 */