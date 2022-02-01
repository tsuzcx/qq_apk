package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/player/VLogMaterialsInfoCache;", "", "()V", "TAG", "", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/vlog/player/MaterialCacheInfo;", "checkCache", "path", "clearCache", "", "putCache", "width", "", "height", "rotate", "cropLeft", "cropTop", "cropRight", "cropBottom", "updateCache", "plugin-vlog_release"})
public final class e
{
  public static final e GBH;
  private static final ConcurrentHashMap<String, a> tVA;
  
  static
  {
    AppMethodBeat.i(110977);
    GBH = new e();
    tVA = new ConcurrentHashMap();
    AppMethodBeat.o(110977);
  }
  
  public static a aUf(String paramString)
  {
    AppMethodBeat.i(110975);
    p.h(paramString, "path");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(110975);
      return null;
    }
    paramString = (a)tVA.get(paramString);
    AppMethodBeat.o(110975);
    return paramString;
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(110976);
    Log.i("MicroMsg.VLogMaterialsInfoCache", "clearCache");
    tVA.clear();
    AppMethodBeat.o(110976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.e
 * JD-Core Version:    0.7.0.1
 */