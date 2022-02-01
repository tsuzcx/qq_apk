package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.np;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MusicMvCgiRetCache;", "", "()V", "CacheTimeoutMs", "", "TAG", "", "enableCache", "", "getEnableCache", "()Z", "setEnableCache", "(Z)V", "finderFeedDetailCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/mv/model/FinderFeedDetailCacheKey;", "Lcom/tencent/mm/plugin/mv/model/FinderFeedDetailCache;", "Lkotlin/collections/HashMap;", "musicPlayer", "com/tencent/mm/plugin/mv/model/MusicMvCgiRetCache$musicPlayer$1", "Lcom/tencent/mm/plugin/mv/model/MusicMvCgiRetCache$musicPlayer$1;", "mvRecommendListCache", "Lcom/tencent/mm/plugin/mv/model/MusicMvRecommendListCacheKey;", "Lcom/tencent/mm/plugin/mv/model/MusicMvRecommendListCache;", "destroy", "", "evictTimeoutCache", "timestamp", "init", "putFinderFeedDetail", "feedId", "nonceId", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "putMvRecommendList", "songInfoBase64", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "tryGetCacheFinderFeedDetail", "tryGetCacheMvRecommendList", "plugin-mv_release"})
public final class i
{
  public static final HashMap<d, c> GbT;
  public static final HashMap<k, j> GbU;
  private static final a GbV;
  public static final i GbW;
  public static boolean pvA;
  
  static
  {
    AppMethodBeat.i(229743);
    GbW = new i();
    pvA = true;
    GbT = new HashMap();
    GbU = new HashMap();
    GbV = new a();
    AppMethodBeat.o(229743);
  }
  
  public static att I(long paramLong, String paramString)
  {
    AppMethodBeat.i(229730);
    p.k(paramString, "nonceId");
    if (!pvA)
    {
      AppMethodBeat.o(229730);
      return null;
    }
    Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheFinderFeedDetail, feedId:" + paramLong + ", nonceId:" + paramString);
    long l = Util.currentTicks();
    paramString = (c)GbT.get(new d(paramLong, paramString));
    if (paramString != null)
    {
      if (l - paramString.timestamp > 180000L) {
        break label131;
      }
      Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheFinderFeedDetail success from cache");
    }
    for (paramString = paramString.GaS;; paramString = null)
    {
      String str = paramString;
      if (paramString == null)
      {
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheFinderFeedDetail not found");
        str = null;
      }
      AppMethodBeat.o(229730);
      return str;
      label131:
      Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheFinderFeedDetail failed timeout");
      GbW.OI(l);
    }
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(229740);
    GbT.clear();
    GbU.clear();
    GbV.dead();
    AppMethodBeat.o(229740);
  }
  
  public static void init()
  {
    AppMethodBeat.i(229738);
    GbV.alive();
    AppMethodBeat.o(229738);
  }
  
  public final void OI(long paramLong)
  {
    AppMethodBeat.i(229735);
    Map.Entry localEntry;
    try
    {
      Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "evictTimeoutCache, timestamp:" + paramLong + ", finderFeedDetailCache.size:" + GbT.size() + ", mvRecommendListCache.size:" + GbU.size());
      ArrayList localArrayList = new ArrayList();
      synchronized ((Map)GbT)
      {
        localObject6 = ???.entrySet().iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localEntry = (Map.Entry)((Iterator)localObject6).next();
          if (paramLong - ((c)localEntry.getValue()).timestamp > 180000L) {
            localArrayList.add(localEntry.getKey());
          }
        }
      }
      localObject6 = x.aazN;
    }
    finally
    {
      AppMethodBeat.o(229735);
    }
    ??? = ((Iterable)localObject3).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject4 = (d)((Iterator)???).next();
      GbT.remove(localObject4);
    }
    Object localObject4 = new ArrayList();
    synchronized ((Map)GbU)
    {
      localObject6 = ((Map)???).entrySet().iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject6).next();
        if (paramLong - ((j)localEntry.getValue()).timestamp > 180000L) {
          ((ArrayList)localObject4).add(localEntry.getKey());
        }
      }
    }
    Object localObject6 = x.aazN;
    ??? = ((Iterable)localObject5).iterator();
    while (((Iterator)???).hasNext())
    {
      k localk = (k)((Iterator)???).next();
      GbU.remove(localk);
    }
    Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "finished evictTimeoutCache, finderFeedDetailCache.size:" + GbT.size() + ", mvRecommendListCache.size:" + GbU.size());
    ??? = x.aazN;
    AppMethodBeat.o(229735);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/model/MusicMvCgiRetCache$musicPlayer$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-mv_release"})
  public static final class a
    extends IListener<np>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.i
 * JD-Core Version:    0.7.0.1
 */