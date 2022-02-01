package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/C2COriginVideoDownloaderCache;", "", "()V", "downloaderMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/thumbplayer/downloader/CdnVideoResourceDownloader;", "Lkotlin/collections/HashMap;", "clearCache", "", "clearCallback", "getDownloader", "msgId", "putDownloader", "downloader", "removeDownloader", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d aeAp;
  private static final HashMap<Long, com.tencent.mm.plugin.thumbplayer.downloader.d> aeAq;
  
  static
  {
    AppMethodBeat.i(254504);
    aeAp = new d();
    aeAq = new HashMap();
    AppMethodBeat.o(254504);
  }
  
  public static com.tencent.mm.plugin.thumbplayer.downloader.d Ai(long paramLong)
  {
    AppMethodBeat.i(254486);
    com.tencent.mm.plugin.thumbplayer.downloader.d locald = (com.tencent.mm.plugin.thumbplayer.downloader.d)aeAq.get(Long.valueOf(paramLong));
    AppMethodBeat.o(254486);
    return locald;
  }
  
  public static com.tencent.mm.plugin.thumbplayer.downloader.d Aj(long paramLong)
  {
    AppMethodBeat.i(254495);
    com.tencent.mm.plugin.thumbplayer.downloader.d locald = (com.tencent.mm.plugin.thumbplayer.downloader.d)aeAq.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(254495);
    return locald;
  }
  
  public static void a(long paramLong, com.tencent.mm.plugin.thumbplayer.downloader.d paramd)
  {
    AppMethodBeat.i(254491);
    s.u(paramd, "downloader");
    ((Map)aeAq).put(Long.valueOf(paramLong), paramd);
    AppMethodBeat.o(254491);
  }
  
  public static void clearCallback()
  {
    AppMethodBeat.i(254500);
    Object localObject = aeAq.keySet();
    s.s(localObject, "downloaderMap.keys");
    localObject = ((Set)localObject).iterator();
    label110:
    while (((Iterator)localObject).hasNext())
    {
      long l = ((Number)((Iterator)localObject).next()).longValue();
      com.tencent.mm.plugin.thumbplayer.downloader.d locald = (com.tencent.mm.plugin.thumbplayer.downloader.d)aeAq.get(Long.valueOf(l));
      if (locald != null) {
        locald.TCn = null;
      }
      if ((locald != null) && (locald.mhq == true)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label110;
        }
        aeAq.remove(Long.valueOf(l));
        break;
      }
    }
    AppMethodBeat.o(254500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.d
 * JD-Core Version:    0.7.0.1
 */