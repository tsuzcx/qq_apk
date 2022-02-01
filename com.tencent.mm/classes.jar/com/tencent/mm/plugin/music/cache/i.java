package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.j;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
{
  public static boolean aOO(String paramString)
  {
    AppMethodBeat.i(137206);
    if ((h.aON(paramString)) && (h.jK(paramString) > 0L))
    {
      AppMethodBeat.o(137206);
      return true;
    }
    AppMethodBeat.o(137206);
    return false;
  }
  
  public static boolean aOP(String paramString)
  {
    AppMethodBeat.i(270896);
    j localj = e.aOy(g.aOE(paramString));
    if (localj == null)
    {
      Log.e("MicroMsg.Audio.IndexBitMgr", "isQQAudioCacheValid pMusic is null!'");
      AppMethodBeat.o(270896);
      return false;
    }
    if ((h.aON(paramString)) && (h.jK(paramString) > 0L) && (localj.oPe == 1))
    {
      AppMethodBeat.o(270896);
      return true;
    }
    AppMethodBeat.o(270896);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.i
 * JD-Core Version:    0.7.0.1
 */