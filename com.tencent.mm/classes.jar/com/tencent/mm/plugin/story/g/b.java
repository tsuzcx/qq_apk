package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "isWaiting", "", "isWifi", "lastStoryId", "last_selectedColumn", "", "last_selectedRow", "markGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "markStoryId", "onClickTime", "onCreateTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStoryLauncherTime", "preLoadInfo", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "storyIdsState", "", "unReadList", "Ljava/util/ArrayList;", "withCache", "canPlay", "", "user", "storyId", "chatting", "clickScene", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkReport", "checkStayTime", "checkUnRead", "clean", "downloadEnd", "enter", "list", "", "finish", "initID", "markInit", "markResumeTime", "netSpeed", "speed", "onDestroy", "onSelectItem", "group", "selectedRow", "selectedColumn", "onVideoEnd", "onVideoPlay", "onVideoWaiting", "playUser", "preLoadVideo", "galleryItem", "extinfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "preloadWithCache", "report", "IID", "key", "mval", "startDownload", "isAll", "startHttp", "Info", "State", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static boolean Aey;
  private static long Fpo;
  private static long Fpp;
  public static long ID;
  private static ArrayList<String> SqA;
  public static final b Sqn;
  public static long Sqo;
  public static final Map<Long, a> Sqp;
  public static a Sqq;
  public static long Sqr;
  private static long Sqs;
  public static com.tencent.mm.plugin.story.model.d.h Sqt;
  public static boolean Squ;
  public static long Sqv;
  private static long Sqw;
  private static int Sqx;
  private static int Sqy;
  private static boolean Sqz;
  private static boolean isWaiting;
  
  static
  {
    AppMethodBeat.i(119402);
    Sqn = new b();
    ID = 998L;
    Aey = true;
    Map localMap = Collections.synchronizedMap((Map)new HashMap());
    s.s(localMap, "synchronizedMap(HashMap<Long, Info>())");
    Sqp = localMap;
    AppMethodBeat.o(119402);
  }
  
  public static void X(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(119397);
    if (!Sqp.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(119397);
      return;
    }
    a locala = (a)Sqp.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.SqG = Util.nowMilliSecond();
      locala.wFp = paramBoolean;
    }
    AppMethodBeat.o(119397);
  }
  
  public static void anm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      ID = -1L;
      return;
    case 1: 
    case 2: 
      ID = 998L;
      return;
    }
    ID = 1006L;
  }
  
  public static void ann(int paramInt)
  {
    AppMethodBeat.i(119393);
    long l = Util.milliSecondsToNow(Fpo);
    Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "cur speed " + paramInt + " cur: " + l);
    if (l > 5000L)
    {
      if (paramInt < 10)
      {
        q(ID, 82L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 100)
      {
        q(ID, 83L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 200)
      {
        q(ID, 89L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 250)
      {
        q(ID, 84L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 450)
      {
        q(ID, 85L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 900)
      {
        q(ID, 86L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 1350)
      {
        q(ID, 87L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 1800) {
        q(ID, 88L, 1L);
      }
    }
    AppMethodBeat.o(119393);
  }
  
  private static int c(com.tencent.mm.plugin.story.model.d.j paramj)
  {
    AppMethodBeat.i(119395);
    Object localObject = r.Slb;
    localObject = r.a(paramj);
    if (((n)localObject).hzD())
    {
      Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", s.X("z checkCanPlay downloadFinish ", Long.valueOf(paramj.idH)));
      AppMethodBeat.o(119395);
      return 1;
    }
    if (((n)localObject).field_totalSize <= 0)
    {
      AppMethodBeat.o(119395);
      return 0;
    }
    float f = ((n)localObject).field_cacheSize / ((n)localObject).field_totalSize;
    paramj = com.tencent.mm.plugin.story.ui.view.gallery.j.SCD;
    if (f * 100.0F >= com.tencent.mm.plugin.story.ui.view.gallery.j.hAl().SBq)
    {
      Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay cachesize " + ((n)localObject).field_cacheSize + " totalSize: " + ((n)localObject).field_totalSize);
      AppMethodBeat.o(119395);
      return 1;
    }
    AppMethodBeat.o(119395);
    return 0;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(119391);
    Fpp = 0L;
    Sqs = 0L;
    Fpo = 0L;
    Sqz = false;
    Sqx = -1;
    Sqy = -1;
    Sqv = 0L;
    Sqw = 0L;
    Sqp.clear();
    Squ = false;
    Sqt = null;
    isWaiting = false;
    SqA = new ArrayList();
    Sqq = null;
    AppMethodBeat.o(119391);
  }
  
  public static void g(ArrayList<ArrayList<com.tencent.mm.plugin.story.model.d.h>> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119394);
    s.u(paramArrayList, "group");
    if (!hxC())
    {
      AppMethodBeat.o(119394);
      return;
    }
    int j = 0;
    Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", " last_selectedColumn:" + Sqy + ",last_selectedRow:" + Sqx + " selectedRow:" + paramInt1 + ",selectedColumn:" + paramInt2);
    int i;
    if (paramArrayList.size() > 0) {
      if ((((ArrayList)paramArrayList.get(paramInt1)).size() > 0) && (paramInt2 + 1 < ((ArrayList)paramArrayList.get(paramInt1)).size()))
      {
        if (!Sqz) {
          q(ID, 101L, 1L);
        }
        i = 1;
        if (paramInt1 + 1 < paramArrayList.size())
        {
          if (!Sqz) {
            q(ID, 102L, 1L);
          }
          j = 1;
          label170:
          Sqz = true;
        }
      }
    }
    for (;;)
    {
      if ((Sqy != -1) && (Sqx != -1))
      {
        if (isWaiting)
        {
          q(ID, 100L, 1L);
          isWaiting = false;
        }
        if (paramInt1 == Sqx) {
          break label952;
        }
        if (i != 0) {
          q(ID, 105L, 1L);
        }
        q(ID, 106L, 1L);
        i = paramInt1 - Sqx;
        if (i != 1) {
          break label814;
        }
        q(ID, 110L, 1L);
        if (paramArrayList.size() <= 0) {}
      }
      int k;
      for (i = 0;; i = k)
      {
        k = i + 1;
        if ((paramInt1 + i < paramArrayList.size()) && (((ArrayList)paramArrayList.get(paramInt1 + i)).size() > 0))
        {
          com.tencent.mm.plugin.story.model.d.j localj = ((com.tencent.mm.plugin.story.model.d.h)((ArrayList)paramArrayList.get(paramInt1 + i)).get(0)).Smr;
          if ((localj != null) && (localj.username != null) && (SqA != null))
          {
            ArrayList localArrayList = SqA;
            if ((localArrayList == null) || (localArrayList.contains(localj.username) != true)) {
              break label868;
            }
            j = 1;
            label368:
            if (j != 0) {
              if (c(localj) != 1) {}
            }
          }
        }
        switch (i)
        {
        default: 
          switch (i)
          {
          default: 
            if (k < 3) {}
            break;
          }
        case 0: 
        case 1: 
        case 2: 
          for (;;)
          {
            label408:
            label436:
            if ((Sqx >= 0) && (Sqx < paramArrayList.size()) && (Sqy >= 0) && (Sqy < ((ArrayList)paramArrayList.get(Sqx)).size()) && ((Sqy != paramInt2) || (Sqx != paramInt1)))
            {
              long l = ((com.tencent.mm.plugin.story.model.d.h)((ArrayList)paramArrayList.get(Sqx)).get(Sqy)).Smr.idH;
              Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime storyId " + l + " lastStoryId " + Sqo);
              if ((hxC()) && (Sqp.containsKey(Long.valueOf(l))))
              {
                paramArrayList = (a)Sqp.get(Long.valueOf(l));
                if ((paramArrayList != null) && (paramArrayList.SqC <= 0L) && (!paramArrayList.Ris) && (paramArrayList.SqD >= 0L))
                {
                  paramArrayList.SqC = Util.milliSecondsToNow(paramArrayList.SqD);
                  Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime onStayTime " + l + ' ' + paramArrayList.SqC + " hasHttp:" + paramArrayList.SqF + "  isWaiting:" + paramArrayList.isWaiting);
                  if (paramArrayList.SqF)
                  {
                    q(ID, 21L, 1L);
                    q(ID, 20L, paramArrayList.SqC);
                  }
                  if (paramArrayList.isWaiting)
                  {
                    q(ID, 23L, 1L);
                    q(ID, 22L, paramArrayList.SqC);
                  }
                  q(ID, 25L, 1L);
                  q(ID, 24L, paramArrayList.SqC);
                  if (paramArrayList.nxG) {
                    q(ID, 26L, 1L);
                  }
                }
              }
            }
            Sqy = paramInt2;
            Sqx = paramInt1;
            AppMethodBeat.o(119394);
            return;
            label814:
            if (i == 2)
            {
              q(ID, 111L, 1L);
              break;
            }
            if (i == 3)
            {
              q(ID, 112L, 1L);
              break;
            }
            if (i < 4) {
              break;
            }
            q(ID, 113L, 1L);
            break;
            label868:
            j = 0;
            break label368;
            q(ID, 120L, 1L);
            break label408;
            q(ID, 121L, 1L);
            break label408;
            q(ID, 122L, 1L);
            break label408;
            q(ID, 125L, 1L);
            break label436;
            q(ID, 126L, 1L);
            break label436;
            q(ID, 127L, 1L);
            break label436;
            label952:
            if (paramInt2 != Sqy)
            {
              if (j != 0) {
                q(ID, 103L, 1L);
              }
              q(ID, 104L, 1L);
              i = paramInt2 - Sqy;
              if (i == 1) {
                q(ID, 115L, 1L);
              } else if (i == 2) {
                q(ID, 116L, 1L);
              } else if (i == 3) {
                q(ID, 117L, 1L);
              } else if (i >= 4) {
                q(ID, 118L, 1L);
              }
            }
          }
        }
      }
      j = 0;
      break label170;
      i = 0;
      break;
      i = 0;
    }
  }
  
  public static void hxA()
  {
    AppMethodBeat.i(119399);
    Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "makeResumeTime onResumeTime " + Fpp + " onPlayUser " + Sqs);
    Fpp = Util.nowMilliSecond();
    AppMethodBeat.o(119399);
  }
  
  public static void hxB()
  {
    AppMethodBeat.i(119401);
    Fpo = Util.nowMilliSecond();
    AppMethodBeat.o(119401);
  }
  
  public static boolean hxC()
  {
    if (Fpo <= 0L) {}
    while (!Aey) {
      return false;
    }
    return true;
  }
  
  public static void hxz()
  {
    Squ = true;
  }
  
  public static void lk(List<String> paramList)
  {
    AppMethodBeat.i(119392);
    s.u(paramList, "list");
    ArrayList localArrayList = new ArrayList();
    SqA = localArrayList;
    localArrayList.addAll((Collection)paramList);
    AppMethodBeat.o(119392);
  }
  
  public static void q(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(119390);
    if (paramLong1 < 0L)
    {
      AppMethodBeat.o(119390);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.p(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(119390);
  }
  
  public static void r(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(119400);
    s.u(paramString, "user");
    if (!hxC())
    {
      AppMethodBeat.o(119400);
      return;
    }
    if ((Sqv > 0L) && (Sqw <= 0L))
    {
      Sqw = Util.milliSecondsToNow(Sqv);
      q(ID, 130L, 1L);
      q(ID, 131L, Sqw);
    }
    Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser user " + paramString + " storyId " + paramLong + " selectedColumn " + paramInt + " lastStoryId:" + Sqo + " onStoryLauncherTime " + Sqw);
    int j = 0;
    int i = j;
    if (Sqo != paramLong)
    {
      i = j;
      if (Sqo != 0L) {
        i = 1;
      }
    }
    long l = Sqo;
    Sqo = paramLong;
    s.u(paramString, "user");
    Object localObject = SqA;
    if ((localObject != null) && (((ArrayList)localObject).contains(paramString) == true))
    {
      j = 1;
      if (j == 0) {
        break label234;
      }
    }
    label234:
    for (j = 1;; j = 0)
    {
      if (j != 0) {
        break label240;
      }
      AppMethodBeat.o(119400);
      return;
      j = 0;
      break;
    }
    label240:
    if ((Sqp.containsKey(Long.valueOf(l))) && (i != 0))
    {
      localObject = (a)Sqp.get(Long.valueOf(l));
      if (localObject != null) {
        ((a)localObject).Ris = true;
      }
    }
    if (paramInt > 0)
    {
      AppMethodBeat.o(119400);
      return;
    }
    localObject = Sqp;
    a locala = new a(paramString, b.b.SqI);
    locala.SqD = Util.nowMilliSecond();
    ((Map)localObject).put(Long.valueOf(paramLong), locala);
    Sqs = Util.nowMilliSecond();
    Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", s.X("playUser onResumeTime ", Long.valueOf(Sqs)));
    localObject = StoryCore.SjP;
    localObject = StoryCore.b.hvS().bbJ(paramString);
    Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "preLoadCache > 0 then " + paramString + " preload " + Util.getSizeKB(((f)localObject).hzl()));
    q(ID, 2L, 1L);
    if (((f)localObject).hzl() > 0L) {
      q(ID, 3L, 1L);
    }
    if (paramLong == Sqr)
    {
      if (Squ)
      {
        q(ID, 6L, 1L);
        if (((f)localObject).hzl() > 0L)
        {
          if (!Squ) {
            break label552;
          }
          q(ID, 7L, 1L);
        }
      }
      for (;;)
      {
        paramString = Sqt;
        if ((paramString == null) || (c(paramString.Smr) != 1)) {
          break label575;
        }
        if (!Squ) {
          break label565;
        }
        q(ID, 8L, 1L);
        AppMethodBeat.o(119400);
        return;
        q(ID, 9L, 1L);
        break;
        label552:
        q(ID, 10L, 1L);
      }
      label565:
      q(ID, 11L, 1L);
    }
    label575:
    AppMethodBeat.o(119400);
  }
  
  public static void vQ(long paramLong)
  {
    Sqr = paramLong;
  }
  
  public static void vR(long paramLong)
  {
    AppMethodBeat.i(119398);
    if (!Sqp.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(119398);
      return;
    }
    a locala = (a)Sqp.get(Long.valueOf(paramLong));
    if ((locala != null) && (locala.Ris))
    {
      AppMethodBeat.o(119398);
      return;
    }
    if (paramLong == Sqr)
    {
      locala = Sqq;
      if (locala != null)
      {
        if (locala.SqG <= 0L)
        {
          AppMethodBeat.o(119398);
          return;
        }
        paramLong = Util.milliSecondsToNow(locala.SqG);
        Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", s.X("downloadEnd1 ", Long.valueOf(paramLong)));
        if (locala.wFp)
        {
          q(ID, 62L, 1L);
          q(ID, 63L, paramLong);
        }
        q(ID, 60L, 1L);
        q(ID, 61L, paramLong);
        AppMethodBeat.o(119398);
      }
    }
    else
    {
      locala = (a)Sqp.get(Long.valueOf(paramLong));
      if (locala != null)
      {
        if (locala.SqG <= 0L)
        {
          AppMethodBeat.o(119398);
          return;
        }
        paramLong = Util.milliSecondsToNow(locala.SqG);
        Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", s.X("downloadEnd2 ", Long.valueOf(paramLong)));
        if (locala.wFp)
        {
          q(ID, 62L, 1L);
          q(ID, 63L, paramLong);
        }
        q(ID, 60L, 1L);
        q(ID, 61L, paramLong);
      }
    }
    AppMethodBeat.o(119398);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "", "user", "", "state", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "clean", "", "getClean", "()Z", "setClean", "(Z)V", "hasHttp", "getHasHttp", "setHasHttp", "isAll", "setAll", "isEnd", "setEnd", "isWaiting", "setWaiting", "onMarkPlayCall", "", "getOnMarkPlayCall", "()J", "setOnMarkPlayCall", "(J)V", "onMarkPlayingCall", "getOnMarkPlayingCall", "setOnMarkPlayingCall", "onStayTime", "getOnStayTime", "setOnStayTime", "startHttp", "getStartHttp", "setStartHttp", "getState", "()Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "setState", "(Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "getUser", "()Ljava/lang/String;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public boolean Ris;
    private b.b SqB;
    long SqC;
    public long SqD;
    public long SqE;
    public boolean SqF;
    public long SqG;
    private final String hVQ;
    public boolean isWaiting;
    public boolean nxG;
    public boolean wFp;
    
    public a(String paramString, b.b paramb)
    {
      AppMethodBeat.i(119386);
      this.hVQ = paramString;
      this.SqB = paramb;
      AppMethodBeat.o(119386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.b
 * JD-Core Version:    0.7.0.1
 */