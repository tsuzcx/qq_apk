package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.concurrent.ConcurrentHashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogMaterialsInfoCache;", "", "()V", "TAG", "", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/vlog/player/MaterialCacheInfo;", "checkCache", "path", "clearCache", "", "putCache", "width", "", "height", "rotate", "cropLeft", "cropTop", "cropRight", "cropBottom", "updateCache", "plugin-vlog_release"})
public final class d
{
  private static final ConcurrentHashMap<String, a> yZW;
  public static final d yZX;
  
  static
  {
    AppMethodBeat.i(110977);
    yZX = new d();
    yZW = new ConcurrentHashMap();
    AppMethodBeat.o(110977);
  }
  
  public static a asW(String paramString)
  {
    AppMethodBeat.i(110975);
    k.h(paramString, "path");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(110975);
      return null;
    }
    paramString = (a)yZW.get(paramString);
    AppMethodBeat.o(110975);
    return paramString;
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(110976);
    ad.i("MicroMsg.VLogMaterialsInfoCache", "clearCache");
    yZW.clear();
    AppMethodBeat.o(110976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.d
 * JD-Core Version:    0.7.0.1
 */