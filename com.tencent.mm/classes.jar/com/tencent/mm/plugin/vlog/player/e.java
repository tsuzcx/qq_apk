package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/player/VLogMaterialsInfoCache;", "", "()V", "TAG", "", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/vlog/player/MaterialCacheInfo;", "checkCache", "path", "clearCache", "", "putCache", "width", "", "height", "rotate", "cropLeft", "cropTop", "cropRight", "cropBottom", "updateCache", "plugin-vlog_release"})
public final class e
{
  public static final e BZU;
  private static final ConcurrentHashMap<String, a> slo;
  
  static
  {
    AppMethodBeat.i(110977);
    BZU = new e();
    slo = new ConcurrentHashMap();
    AppMethodBeat.o(110977);
  }
  
  public static a aEL(String paramString)
  {
    AppMethodBeat.i(110975);
    p.h(paramString, "path");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(110975);
      return null;
    }
    paramString = (a)slo.get(paramString);
    AppMethodBeat.o(110975);
    return paramString;
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(110976);
    ae.i("MicroMsg.VLogMaterialsInfoCache", "clearCache");
    slo.clear();
    AppMethodBeat.o(110976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.e
 * JD-Core Version:    0.7.0.1
 */