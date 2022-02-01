package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/player/VLogMaterialsInfoCache;", "", "()V", "TAG", "", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/vlog/player/MaterialCacheInfo;", "checkCache", "path", "clearCache", "", "putCache", "width", "", "height", "rotate", "cropLeft", "cropTop", "cropRight", "cropBottom", "updateCache", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final ConcurrentHashMap<String, a> Bgw;
  public static final e Udl;
  
  static
  {
    AppMethodBeat.i(110977);
    Udl = new e();
    Bgw = new ConcurrentHashMap();
    AppMethodBeat.o(110977);
  }
  
  public static a bfl(String paramString)
  {
    AppMethodBeat.i(110975);
    s.u(paramString, "path");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(110975);
      return null;
    }
    paramString = (a)Bgw.get(paramString);
    AppMethodBeat.o(110975);
    return paramString;
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(110976);
    Log.i("MicroMsg.VLogMaterialsInfoCache", "clearCache");
    Bgw.clear();
    AppMethodBeat.o(110976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.e
 * JD-Core Version:    0.7.0.1
 */