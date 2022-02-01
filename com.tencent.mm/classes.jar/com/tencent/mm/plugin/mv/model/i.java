package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.dsr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MusicMvCgiRetCache;", "", "()V", "CacheTimeoutMs", "", "TAG", "", "enableCache", "", "getEnableCache", "()Z", "setEnableCache", "(Z)V", "finderFeedDetailCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/mv/model/FinderFeedDetailCacheKey;", "Lcom/tencent/mm/plugin/mv/model/FinderFeedDetailCache;", "Lkotlin/collections/HashMap;", "musicPlayer", "com/tencent/mm/plugin/mv/model/MusicMvCgiRetCache$musicPlayer$1", "Lcom/tencent/mm/plugin/mv/model/MusicMvCgiRetCache$musicPlayer$1;", "mvRecommendListCache", "Lcom/tencent/mm/plugin/mv/model/MusicMvRecommendListCacheKey;", "Lcom/tencent/mm/plugin/mv/model/MusicMvRecommendListCache;", "destroy", "", "evictTimeoutCache", "timestamp", "init", "putFinderFeedDetail", "feedId", "nonceId", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "putMvRecommendList", "songInfoBase64", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "tryGetCacheFinderFeedDetail", "tryGetCacheMvRecommendList", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i LXD;
  public static final HashMap<d, c> LXE;
  public static final HashMap<k, j> LXF;
  private static final MusicMvCgiRetCache.musicPlayer.1 LXG;
  public static boolean sAG;
  
  static
  {
    AppMethodBeat.i(286148);
    LXD = new i();
    sAG = true;
    LXE = new HashMap();
    LXF = new HashMap();
    LXG = new MusicMvCgiRetCache.musicPlayer.1(f.hfK);
    AppMethodBeat.o(286148);
  }
  
  public static ayl W(long paramLong, String paramString)
  {
    AppMethodBeat.i(286067);
    s.u(paramString, "nonceId");
    if (!sAG)
    {
      AppMethodBeat.o(286067);
      return null;
    }
    Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheFinderFeedDetail, feedId:" + paramLong + ", nonceId:" + paramString);
    long l = Util.currentTicks();
    paramString = (c)LXE.get(new d(paramLong, paramString));
    if (paramString == null) {
      paramString = null;
    }
    while (paramString == null)
    {
      Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheFinderFeedDetail not found");
      AppMethodBeat.o(286067);
      return null;
      if (l - paramString.timestamp <= 180000L)
      {
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheFinderFeedDetail success from cache");
        paramString = paramString.LWS;
      }
      else
      {
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheFinderFeedDetail failed timeout");
        LXD.sG(l);
        paramString = null;
      }
    }
    AppMethodBeat.o(286067);
    return paramString;
  }
  
  public static dsr aPy(String paramString)
  {
    AppMethodBeat.i(286087);
    s.u(paramString, "songInfoBase64");
    if (!sAG)
    {
      AppMethodBeat.o(286087);
      return null;
    }
    Log.i("MicroMsg.Mv.MusicMvCgiRetCache", s.X("tryGetCacheMvRecommendList, songInfoBase64:", Integer.valueOf(paramString.hashCode())));
    long l = Util.currentTicks();
    paramString = (j)LXF.get(new k(paramString));
    if (paramString == null) {
      paramString = null;
    }
    while (paramString == null)
    {
      Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheMvRecommendList not found");
      AppMethodBeat.o(286087);
      return null;
      if (l - paramString.timestamp <= 180000L)
      {
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheMvRecommendList success from cache");
        paramString = paramString.LXH;
      }
      else
      {
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheMvRecommendList failed timeout");
        LXD.sG(l);
        paramString = null;
      }
    }
    AppMethodBeat.o(286087);
    return paramString;
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(286112);
    LXE.clear();
    LXF.clear();
    LXG.dead();
    AppMethodBeat.o(286112);
  }
  
  public static void init()
  {
    AppMethodBeat.i(286101);
    LXG.alive();
    AppMethodBeat.o(286101);
  }
  
  public final void sG(long paramLong)
  {
    AppMethodBeat.i(286161);
    Map.Entry localEntry;
    try
    {
      Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "evictTimeoutCache, timestamp:" + paramLong + ", finderFeedDetailCache.size:" + LXE.size() + ", mvRecommendListCache.size:" + LXF.size());
      ArrayList localArrayList = new ArrayList();
      synchronized ((Map)LXE)
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
      localObject6 = ah.aiuX;
    }
    finally
    {
      AppMethodBeat.o(286161);
    }
    ??? = ((Iterable)localObject3).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject4 = (d)((Iterator)???).next();
      LXE.remove(localObject4);
    }
    Object localObject4 = new ArrayList();
    synchronized ((Map)LXF)
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
    Object localObject6 = ah.aiuX;
    ??? = ((Iterable)localObject5).iterator();
    while (((Iterator)???).hasNext())
    {
      k localk = (k)((Iterator)???).next();
      LXF.remove(localk);
    }
    Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "finished evictTimeoutCache, finderFeedDetailCache.size:" + LXE.size() + ", mvRecommendListCache.size:" + LXF.size());
    ??? = ah.aiuX;
    AppMethodBeat.o(286161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.i
 * JD-Core Version:    0.7.0.1
 */