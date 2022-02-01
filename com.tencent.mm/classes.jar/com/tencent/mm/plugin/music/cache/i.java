package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.j;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
{
  public static boolean aHH(String paramString)
  {
    AppMethodBeat.i(137206);
    if ((h.aHG(paramString)) && (h.hv(paramString) > 0L))
    {
      AppMethodBeat.o(137206);
      return true;
    }
    AppMethodBeat.o(137206);
    return false;
  }
  
  public static boolean aHI(String paramString)
  {
    AppMethodBeat.i(198178);
    j localj = e.aHs(g.aHy(paramString));
    if (localj == null)
    {
      Log.e("MicroMsg.Audio.IndexBitMgr", "isQQAudioCacheValid pMusic is null!'");
      AppMethodBeat.o(198178);
      return false;
    }
    if ((h.aHG(paramString)) && (h.hv(paramString) > 0L) && (localj.jfB == 1))
    {
      AppMethodBeat.o(198178);
      return true;
    }
    AppMethodBeat.o(198178);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.i
 * JD-Core Version:    0.7.0.1
 */