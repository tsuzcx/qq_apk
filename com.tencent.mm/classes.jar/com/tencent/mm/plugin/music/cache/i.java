package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.j;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
{
  public static boolean aRW(String paramString)
  {
    AppMethodBeat.i(137206);
    if ((h.aRV(paramString)) && (h.ij(paramString) > 0L))
    {
      AppMethodBeat.o(137206);
      return true;
    }
    AppMethodBeat.o(137206);
    return false;
  }
  
  public static boolean aRX(String paramString)
  {
    AppMethodBeat.i(257403);
    j localj = e.aRG(g.aRM(paramString));
    if (localj == null)
    {
      Log.e("MicroMsg.Audio.IndexBitMgr", "isQQAudioCacheValid pMusic is null!'");
      AppMethodBeat.o(257403);
      return false;
    }
    if ((h.aRV(paramString)) && (h.ij(paramString) > 0L) && (localj.lWb == 1))
    {
      AppMethodBeat.o(257403);
      return true;
    }
    AppMethodBeat.o(257403);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.i
 * JD-Core Version:    0.7.0.1
 */