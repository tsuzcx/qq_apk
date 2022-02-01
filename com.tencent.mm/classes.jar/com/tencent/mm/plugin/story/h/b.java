package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.ui.view.gallery.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "isWaiting", "", "isWifi", "lastStoryId", "last_selectedColumn", "", "last_selectedRow", "markGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "markStoryId", "onClickTime", "onCreateTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStoryLauncherTime", "preLoadInfo", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "storyIdsState", "", "unReadList", "Ljava/util/ArrayList;", "withCache", "canPlay", "", "user", "storyId", "chatting", "clickScene", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkReport", "checkStayTime", "checkUnRead", "clean", "downloadEnd", "enter", "list", "", "finish", "initID", "markInit", "markResumeTime", "netSpeed", "speed", "onDestroy", "onSelectItem", "group", "selectedRow", "selectedColumn", "onVideoEnd", "onVideoPlay", "onVideoWaiting", "playUser", "preLoadVideo", "galleryItem", "extinfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "preloadWithCache", "report", "IID", "key", "mval", "startDownload", "isAll", "startHttp", "Info", "State", "plugin-story_release"})
public final class b
{
  private static boolean isWaiting;
  public static long oJZ;
  public static boolean qbG;
  public static long ymk;
  public static final Map<Long, a> yml;
  public static a ymm;
  public static long ymn;
  private static long ymo;
  private static long ymp;
  public static com.tencent.mm.plugin.story.f.d.h ymq;
  public static boolean ymr;
  public static long yms;
  private static long ymt;
  private static long ymu;
  private static int ymv;
  private static int ymw;
  private static boolean ymx;
  private static ArrayList<String> ymy;
  public static final b ymz;
  
  static
  {
    AppMethodBeat.i(119402);
    ymz = new b();
    oJZ = 998L;
    qbG = true;
    Map localMap = Collections.synchronizedMap((Map)new HashMap());
    k.g(localMap, "Collections.synchronizedMap(HashMap<Long, Info>())");
    yml = localMap;
    AppMethodBeat.o(119402);
  }
  
  public static void F(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(119397);
    if (!yml.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(119397);
      return;
    }
    a locala = (a)yml.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.ymE = bt.eGO();
      locala.nEj = paramBoolean;
      AppMethodBeat.o(119397);
      return;
    }
    AppMethodBeat.o(119397);
  }
  
  public static void OA(int paramInt)
  {
    AppMethodBeat.i(119393);
    long l = bt.vM(ymu);
    ad.i("MicroMsg.StoryBrowseDetailIDKeyStat", "cur speed " + paramInt + " cur: " + l);
    if (l > 5000L)
    {
      if (paramInt < 10)
      {
        n(oJZ, 82L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 100)
      {
        n(oJZ, 83L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 200)
      {
        n(oJZ, 89L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 250)
      {
        n(oJZ, 84L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 450)
      {
        n(oJZ, 85L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 900)
      {
        n(oJZ, 86L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 1350)
      {
        n(oJZ, 87L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 1800) {
        n(oJZ, 88L, 1L);
      }
    }
    AppMethodBeat.o(119393);
  }
  
  public static void Oz(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      oJZ = 998L;
      return;
    }
    if (paramInt == 3)
    {
      oJZ = 1006L;
      return;
    }
    oJZ = -1L;
  }
  
  public static boolean aAh()
  {
    if (ymu <= 0L) {}
    while (!qbG) {
      return false;
    }
    return true;
  }
  
  private static int c(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(119395);
    Object localObject = s.ygj;
    localObject = s.a(paramj);
    if (((n)localObject).dKR())
    {
      ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay downloadFinish " + paramj.dAu);
      AppMethodBeat.o(119395);
      return 1;
    }
    if (((n)localObject).field_totalSize <= 0)
    {
      AppMethodBeat.o(119395);
      return 0;
    }
    float f = ((n)localObject).field_cacheSize / ((n)localObject).field_totalSize;
    paramj = m.yAD;
    if (f * 100.0F >= m.dLx().yyW)
    {
      ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay cachesize " + ((n)localObject).field_cacheSize + " totalSize: " + ((n)localObject).field_totalSize);
      AppMethodBeat.o(119395);
      return 1;
    }
    AppMethodBeat.o(119395);
    return 0;
  }
  
  public static void c(ArrayList<ArrayList<com.tencent.mm.plugin.story.f.d.h>> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119394);
    k.h(paramArrayList, "group");
    if (!aAh())
    {
      AppMethodBeat.o(119394);
      return;
    }
    ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", " last_selectedColumn:" + ymw + ",last_selectedRow:" + ymv + " selectedRow:" + paramInt1 + ",selectedColumn:" + paramInt2);
    int i;
    int j;
    if (paramArrayList.size() > 0) {
      if ((((ArrayList)paramArrayList.get(paramInt1)).size() > 0) && (paramInt2 + 1 < ((ArrayList)paramArrayList.get(paramInt1)).size()))
      {
        if (!ymx) {
          n(oJZ, 101L, 1L);
        }
        i = 1;
        if (paramInt1 + 1 < paramArrayList.size())
        {
          if (!ymx) {
            n(oJZ, 102L, 1L);
          }
          j = 1;
          label167:
          ymx = true;
        }
      }
    }
    for (;;)
    {
      if ((ymw != -1) && (ymv != -1))
      {
        if (isWaiting)
        {
          n(oJZ, 100L, 1L);
          isWaiting = false;
        }
        if (paramInt1 != ymv)
        {
          if (i != 0) {
            n(oJZ, 105L, 1L);
          }
          n(oJZ, 106L, 1L);
          i = paramInt1 - ymv;
          if (i == 1)
          {
            n(oJZ, 110L, 1L);
            if (paramArrayList.size() <= 0) {
              break label585;
            }
            i = 0;
            label266:
            if (i >= 3) {
              break label585;
            }
            if ((paramInt1 + i < paramArrayList.size()) && (((ArrayList)paramArrayList.get(paramInt1 + i)).size() > 0))
            {
              com.tencent.mm.plugin.story.f.d.j localj = ((com.tencent.mm.plugin.story.f.d.h)((ArrayList)paramArrayList.get(paramInt1 + i)).get(0)).yhF;
              if ((localj != null) && (localj.username != null) && (ymy != null))
              {
                ArrayList localArrayList = ymy;
                if ((localArrayList != null) && (localArrayList.contains(localj.username) == true))
                {
                  if (c(localj) == 1)
                  {
                    if (i != 0) {
                      break label460;
                    }
                    n(oJZ, 120L, 1L);
                  }
                  label385:
                  if (i != 0) {
                    break label496;
                  }
                  n(oJZ, 125L, 1L);
                }
              }
            }
          }
          for (;;)
          {
            i += 1;
            break label266;
            if (i == 2)
            {
              n(oJZ, 111L, 1L);
              break;
            }
            if (i == 3)
            {
              n(oJZ, 112L, 1L);
              break;
            }
            if (i < 4) {
              break;
            }
            n(oJZ, 113L, 1L);
            break;
            label460:
            if (i == 1)
            {
              n(oJZ, 121L, 1L);
              break label385;
            }
            if (i != 2) {
              break label385;
            }
            n(oJZ, 122L, 1L);
            break label385;
            label496:
            if (i == 1) {
              n(oJZ, 126L, 1L);
            } else if (i == 2) {
              n(oJZ, 127L, 1L);
            }
          }
        }
        else if (paramInt2 != ymw)
        {
          if (j != 0) {
            n(oJZ, 103L, 1L);
          }
          n(oJZ, 104L, 1L);
          i = paramInt2 - ymw;
          if (i != 1) {
            break label957;
          }
          n(oJZ, 115L, 1L);
        }
      }
      for (;;)
      {
        label585:
        if ((ymv >= 0) && (ymv < paramArrayList.size()) && (ymw >= 0) && (ymw < ((ArrayList)paramArrayList.get(ymv)).size()) && ((ymw != paramInt2) || (ymv != paramInt1)))
        {
          long l = ((com.tencent.mm.plugin.story.f.d.h)((ArrayList)paramArrayList.get(ymv)).get(ymw)).yhF.dAu;
          ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime storyId " + l + " lastStoryId " + ymk);
          if ((aAh()) && (yml.containsKey(Long.valueOf(l))))
          {
            paramArrayList = (a)yml.get(Long.valueOf(l));
            if ((paramArrayList != null) && (paramArrayList.ymA <= 0L) && (!paramArrayList.xqV) && (paramArrayList.ymB >= 0L))
            {
              paramArrayList.ymA = bt.vM(paramArrayList.ymB);
              ad.i("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime onStayTime " + l + ' ' + paramArrayList.ymA + " hasHttp:" + paramArrayList.ymD + "  isWaiting:" + paramArrayList.isWaiting);
              if (paramArrayList.ymD)
              {
                n(oJZ, 21L, 1L);
                n(oJZ, 20L, paramArrayList.ymA);
              }
              if (paramArrayList.isWaiting)
              {
                n(oJZ, 23L, 1L);
                n(oJZ, 22L, paramArrayList.ymA);
              }
              n(oJZ, 25L, 1L);
              n(oJZ, 24L, paramArrayList.ymA);
              if (paramArrayList.gna) {
                n(oJZ, 26L, 1L);
              }
            }
          }
        }
        ymw = paramInt2;
        ymv = paramInt1;
        AppMethodBeat.o(119394);
        return;
        label957:
        if (i == 2) {
          n(oJZ, 116L, 1L);
        } else if (i == 3) {
          n(oJZ, 117L, 1L);
        } else if (i >= 4) {
          n(oJZ, 118L, 1L);
        }
      }
      j = 0;
      break label167;
      i = 0;
      break;
      j = 0;
      i = 0;
    }
  }
  
  public static void clean()
  {
    AppMethodBeat.i(119391);
    ymo = 0L;
    ymp = 0L;
    ymu = 0L;
    ymx = false;
    ymv = -1;
    ymw = -1;
    yms = 0L;
    ymt = 0L;
    yml.clear();
    ymr = false;
    ymq = null;
    isWaiting = false;
    ymy = new ArrayList();
    ymm = null;
    AppMethodBeat.o(119391);
  }
  
  public static void dIN()
  {
    ymr = true;
  }
  
  public static void dIO()
  {
    AppMethodBeat.i(119399);
    ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", "makeResumeTime onResumeTime " + ymo + " onPlayUser " + ymp);
    ymo = bt.eGO();
    AppMethodBeat.o(119399);
  }
  
  public static void dIP()
  {
    AppMethodBeat.i(119401);
    ymu = bt.eGO();
    AppMethodBeat.o(119401);
  }
  
  public static void fW(List<String> paramList)
  {
    AppMethodBeat.i(119392);
    k.h(paramList, "list");
    ArrayList localArrayList = new ArrayList();
    ymy = localArrayList;
    localArrayList.addAll((Collection)paramList);
    AppMethodBeat.o(119392);
  }
  
  public static void l(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(119400);
    k.h(paramString, "user");
    if (!aAh())
    {
      AppMethodBeat.o(119400);
      return;
    }
    if ((yms > 0L) && (ymt <= 0L))
    {
      ymt = bt.vM(yms);
      n(oJZ, 130L, 1L);
      n(oJZ, 131L, ymt);
    }
    ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser user " + paramString + " storyId " + paramLong + " selectedColumn " + paramInt + " lastStoryId:" + ymk + " onStoryLauncherTime " + ymt);
    int j = 0;
    int i = j;
    if (ymk != paramLong)
    {
      i = j;
      if (ymk != 0L) {
        i = 1;
      }
    }
    long l = ymk;
    ymk = paramLong;
    k.h(paramString, "user");
    Object localObject = ymy;
    if ((localObject != null) && (((ArrayList)localObject).contains(paramString) == true)) {}
    for (j = 1; j == 0; j = 0)
    {
      AppMethodBeat.o(119400);
      return;
    }
    if ((yml.containsKey(Long.valueOf(l))) && (i != 0))
    {
      localObject = (a)yml.get(Long.valueOf(l));
      if (localObject != null) {
        ((a)localObject).xqV = true;
      }
    }
    if (paramInt > 0)
    {
      AppMethodBeat.o(119400);
      return;
    }
    localObject = yml;
    a locala = new a(paramString, b.b.ymH);
    locala.ymB = bt.eGO();
    ((Map)localObject).put(Long.valueOf(paramLong), locala);
    ymp = bt.eGO();
    ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser onResumeTime " + ymp);
    localObject = com.tencent.mm.plugin.story.f.j.yfh;
    localObject = j.b.dHe().arp(paramString);
    ad.i("MicroMsg.StoryBrowseDetailIDKeyStat", "preLoadCache > 0 then " + paramString + " preload " + bt.mK(((f)localObject).dKz()));
    n(oJZ, 2L, 1L);
    if (((f)localObject).dKz() > 0L) {
      n(oJZ, 3L, 1L);
    }
    if (paramLong == ymn)
    {
      if (ymr)
      {
        n(oJZ, 6L, 1L);
        if (((f)localObject).dKz() > 0L)
        {
          if (!ymr) {
            break label545;
          }
          n(oJZ, 7L, 1L);
        }
      }
      for (;;)
      {
        paramString = ymq;
        if (paramString == null) {
          break label575;
        }
        if (c(paramString.yhF) != 1) {
          break label568;
        }
        if (!ymr) {
          break label558;
        }
        n(oJZ, 8L, 1L);
        AppMethodBeat.o(119400);
        return;
        n(oJZ, 9L, 1L);
        break;
        label545:
        n(oJZ, 10L, 1L);
      }
      label558:
      n(oJZ, 11L, 1L);
      label568:
      AppMethodBeat.o(119400);
      return;
    }
    label575:
    AppMethodBeat.o(119400);
  }
  
  public static void n(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(119390);
    if (paramLong1 < 0L)
    {
      AppMethodBeat.o(119390);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.m(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(119390);
  }
  
  public static void tJ(long paramLong)
  {
    ymn = paramLong;
  }
  
  public static void tK(long paramLong)
  {
    AppMethodBeat.i(119398);
    if (!yml.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(119398);
      return;
    }
    a locala = (a)yml.get(Long.valueOf(paramLong));
    if ((locala != null) && (locala.xqV))
    {
      AppMethodBeat.o(119398);
      return;
    }
    if (paramLong == ymn)
    {
      locala = ymm;
      if (locala != null)
      {
        if (locala.ymE <= 0L)
        {
          AppMethodBeat.o(119398);
          return;
        }
        paramLong = bt.vM(locala.ymE);
        ad.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd1 ".concat(String.valueOf(paramLong)));
        if (locala.nEj)
        {
          n(oJZ, 62L, 1L);
          n(oJZ, 63L, paramLong);
        }
        n(oJZ, 60L, 1L);
        n(oJZ, 61L, paramLong);
        AppMethodBeat.o(119398);
        return;
      }
      AppMethodBeat.o(119398);
      return;
    }
    locala = (a)yml.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      if (locala.ymE <= 0L)
      {
        AppMethodBeat.o(119398);
        return;
      }
      paramLong = bt.vM(locala.ymE);
      ad.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd2 ".concat(String.valueOf(paramLong)));
      if (locala.nEj)
      {
        n(oJZ, 62L, 1L);
        n(oJZ, 63L, paramLong);
      }
      n(oJZ, 60L, 1L);
      n(oJZ, 61L, paramLong);
      AppMethodBeat.o(119398);
      return;
    }
    AppMethodBeat.o(119398);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "", "user", "", "state", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "clean", "", "getClean", "()Z", "setClean", "(Z)V", "hasHttp", "getHasHttp", "setHasHttp", "isAll", "setAll", "isEnd", "setEnd", "isWaiting", "setWaiting", "onMarkPlayCall", "", "getOnMarkPlayCall", "()J", "setOnMarkPlayCall", "(J)V", "onMarkPlayingCall", "getOnMarkPlayingCall", "setOnMarkPlayingCall", "onStayTime", "getOnStayTime", "setOnStayTime", "startHttp", "getStartHttp", "setStartHttp", "getState", "()Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "setState", "(Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "getUser", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a
  {
    private final String dtV;
    public boolean gna;
    public boolean isWaiting;
    public boolean nEj;
    public boolean xqV;
    long ymA;
    public long ymB;
    public long ymC;
    public boolean ymD;
    public long ymE;
    private b.b ymF;
    
    public a(String paramString, b.b paramb)
    {
      AppMethodBeat.i(119386);
      this.dtV = paramString;
      this.ymF = paramb;
      AppMethodBeat.o(119386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.b
 * JD-Core Version:    0.7.0.1
 */