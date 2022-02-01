package com.tencent.mm.plugin.mv.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.protocal.protobuf.ars;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMvCgiRetCache;", "", "()V", "CacheTimeoutMs", "", "TAG", "", "enableCache", "", "getEnableCache", "()Z", "setEnableCache", "(Z)V", "finderFeedDetailCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/mv/model/FinderFeedDetailCacheKey;", "Lcom/tencent/mm/plugin/mv/model/FinderFeedDetailCache;", "Lkotlin/collections/HashMap;", "musicPlayer", "com/tencent/mm/plugin/mv/model/MusicMvCgiRetCache$musicPlayer$1", "Lcom/tencent/mm/plugin/mv/model/MusicMvCgiRetCache$musicPlayer$1;", "mvRecommendListCache", "Lcom/tencent/mm/plugin/mv/model/MusicMvRecommendListCacheKey;", "Lcom/tencent/mm/plugin/mv/model/MusicMvRecommendListCache;", "destroy", "", "evictTimeoutCache", "timestamp", "init", "putFinderFeedDetail", "feedId", "nonceId", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "putMvRecommendList", "songInfoBase64", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "tryGetCacheFinderFeedDetail", "tryGetCacheMvRecommendList", "plugin-mv_release"})
public final class h
{
  public static final HashMap<c, b> Aqf;
  public static final HashMap<j, i> Aqg;
  private static final a Aqh;
  public static final h Aqi;
  public static boolean mxg;
  
  static
  {
    AppMethodBeat.i(256801);
    Aqi = new h();
    mxg = true;
    Aqf = new HashMap();
    Aqg = new HashMap();
    Aqh = new a();
    AppMethodBeat.o(256801);
  }
  
  public static ars U(long paramLong, String paramString)
  {
    AppMethodBeat.i(258836);
    p.h(paramString, "nonceId");
    if (!mxg)
    {
      AppMethodBeat.o(258836);
      return null;
    }
    Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheFinderFeedDetail, feedId:" + paramLong + ", nonceId:" + paramString);
    long l = Util.currentTicks();
    paramString = (b)Aqf.get(new c(paramLong, paramString));
    if (paramString != null)
    {
      if (l - paramString.timestamp > 180000L) {
        break label131;
      }
      Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheFinderFeedDetail success from cache");
    }
    for (paramString = paramString.Apk;; paramString = null)
    {
      String str = paramString;
      if (paramString == null)
      {
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheFinderFeedDetail not found");
        str = null;
      }
      AppMethodBeat.o(258836);
      return str;
      label131:
      Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheFinderFeedDetail failed timeout");
      Aqi.Hs(l);
    }
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(256800);
    Aqf.clear();
    Aqg.clear();
    Aqh.dead();
    AppMethodBeat.o(256800);
  }
  
  public static void init()
  {
    AppMethodBeat.i(256799);
    Aqh.alive();
    AppMethodBeat.o(256799);
  }
  
  public final void Hs(long paramLong)
  {
    AppMethodBeat.i(256798);
    Map.Entry localEntry;
    try
    {
      Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "evictTimeoutCache, timestamp:" + paramLong + ", finderFeedDetailCache.size:" + Aqf.size() + ", mvRecommendListCache.size:" + Aqg.size());
      ArrayList localArrayList = new ArrayList();
      synchronized ((Map)Aqf)
      {
        localObject6 = ???.entrySet().iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localEntry = (Map.Entry)((Iterator)localObject6).next();
          if (paramLong - ((b)localEntry.getValue()).timestamp > 180000L) {
            localArrayList.add(localEntry.getKey());
          }
        }
      }
      localObject6 = x.SXb;
    }
    finally
    {
      AppMethodBeat.o(256798);
    }
    ??? = ((Iterable)localObject3).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject4 = (c)((Iterator)???).next();
      Aqf.remove(localObject4);
    }
    Object localObject4 = new ArrayList();
    synchronized ((Map)Aqg)
    {
      localObject6 = ((Map)???).entrySet().iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject6).next();
        if (paramLong - ((i)localEntry.getValue()).timestamp > 180000L) {
          ((ArrayList)localObject4).add(localEntry.getKey());
        }
      }
    }
    Object localObject6 = x.SXb;
    ??? = ((Iterable)localObject5).iterator();
    while (((Iterator)???).hasNext())
    {
      j localj = (j)((Iterator)???).next();
      Aqg.remove(localj);
    }
    Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "finished evictTimeoutCache, finderFeedDetailCache.size:" + Aqf.size() + ", mvRecommendListCache.size:" + Aqg.size());
    ??? = x.SXb;
    AppMethodBeat.o(256798);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/model/MusicMvCgiRetCache$musicPlayer$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-mv_release"})
  public static final class a
    extends IListener<mx>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.h
 * JD-Core Version:    0.7.0.1
 */