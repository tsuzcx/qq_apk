package com.tencent.mm.plugin.music.model.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.protocal.protobuf.dsn;
import com.tencent.mm.protocal.protobuf.dsp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/model/cache/MusicLiveLinkCacheHelper;", "", "()V", "TAG", "", "URL_MAX_VALID_TIME", "", "cacheSaveCallBack", "Lcom/tencent/mm/plugin/music/model/cache/MusicLiveLinkCacheHelper$CacheSaveCallBack;", "playMid2JoinTicket", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "", "playUrl2TempAudioType", "playUrl2TempUrlCache", "playUrl2TimeCache", "", "getAudioType", "mid", "(Ljava/lang/String;)Ljava/lang/Integer;", "getJoinTicket", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getPlayUrl", "removeCacheSaveCallBack", "", "saveMid2urlMap", "map", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetLinkRespInfo;", "saveTempPlayUrl", "url", "audioType", "joinTicket", "setCacheSaveCallBack", "shouldGetMusicLiveLink", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "CacheSaveCallBack", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b LMO;
  private static final LruCache<String, String> LMP;
  private static final LruCache<String, Long> LMQ;
  private static final LruCache<String, Integer> LMR;
  private static final LruCache<String, Boolean> LMS;
  private static a LMT;
  
  static
  {
    AppMethodBeat.i(271238);
    LMO = new b();
    LMP = new LruCache(20);
    LMQ = new LruCache(20);
    LMR = new LruCache(20);
    LMS = new LruCache(20);
    AppMethodBeat.o(271238);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(271205);
    s.u(parama, "cacheSaveCallBack");
    LMT = parama;
    AppMethodBeat.o(271205);
  }
  
  public static Integer aOZ(String paramString)
  {
    AppMethodBeat.i(271218);
    paramString = (Integer)LMR.get(paramString);
    AppMethodBeat.o(271218);
    return paramString;
  }
  
  public static Boolean aPa(String paramString)
  {
    AppMethodBeat.i(271224);
    paramString = (Boolean)LMS.get(paramString);
    AppMethodBeat.o(271224);
    return paramString;
  }
  
  public static String ajV(String paramString)
  {
    AppMethodBeat.i(271221);
    if (paramString == null)
    {
      AppMethodBeat.o(271221);
      return null;
    }
    paramString = (String)LMP.get(paramString);
    AppMethodBeat.o(271221);
    return paramString;
  }
  
  public static void bG(LinkedList<dsp> paramLinkedList)
  {
    AppMethodBeat.i(271230);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(271230);
      return;
    }
    Log.i("MicroMsg.Music.MusicLiveLinkCacheHelper", s.X("saveMid2urlMap, map size:", Integer.valueOf(paramLinkedList.size())));
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      paramLinkedList = (dsp)localIterator.next();
      if (paramLinkedList.ret == 0)
      {
        label77:
        String str1;
        String str2;
        int i;
        boolean bool;
        if (paramLinkedList.aaYh == null)
        {
          paramLinkedList = null;
          if (paramLinkedList == null) {
            Log.e("MicroMsg.Music.MusicLiveLinkCacheHelper", "linkInfo.info is null");
          }
        }
        else
        {
          str1 = paramLinkedList.aaYh.oOZ;
          s.s(str1, "linkInfo.info.mid");
          str2 = paramLinkedList.url;
          s.s(str2, "linkInfo.url");
          i = paramLinkedList.aaYi;
          bool = paramLinkedList.aaYj;
          Log.i("MicroMsg.Music.MusicLiveLinkCacheHelper", "saveTempPlayUrl, mid:" + str1 + ", url:" + str2);
          if ((!TextUtils.isEmpty((CharSequence)str1)) && (!TextUtils.isEmpty((CharSequence)str2))) {
            break label191;
          }
        }
        for (;;)
        {
          paramLinkedList = ah.aiuX;
          break label77;
          break;
          label191:
          LMP.put(str1, str2);
          LMR.put(str1, Integer.valueOf(i));
          LMS.put(str1, Boolean.valueOf(bool));
          LMQ.put(str1, Long.valueOf(System.currentTimeMillis()));
          paramLinkedList = LMT;
          if (paramLinkedList != null) {
            paramLinkedList.goi();
          }
        }
      }
      else
      {
        Log.e("MicroMsg.Music.MusicLiveLinkCacheHelper", "errCode:" + paramLinkedList.ret + ", errMsg:" + paramLinkedList.hNw);
      }
    }
    AppMethodBeat.o(271230);
  }
  
  public static boolean c(a parama)
  {
    AppMethodBeat.i(271234);
    if (parama == null)
    {
      Log.e("MicroMsg.Music.MusicLiveLinkCacheHelper", "music is null.");
      AppMethodBeat.o(271234);
      return false;
    }
    if (Util.isNullOrNil(parama.field_mid))
    {
      Log.i("MicroMsg.Music.MusicLiveLinkCacheHelper", "no mid, no need to get new link");
      AppMethodBeat.o(271234);
      return false;
    }
    AppMethodBeat.o(271234);
    return true;
  }
  
  public static void goh()
  {
    LMT = null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/model/cache/MusicLiveLinkCacheHelper$CacheSaveCallBack;", "", "onCallBack", "", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void goi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.b
 * JD-Core Version:    0.7.0.1
 */