package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.ui.view.gallery.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "isWaiting", "", "isWifi", "lastStoryId", "last_selectedColumn", "", "last_selectedRow", "markGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "markStoryId", "onClickTime", "onCreateTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStoryLauncherTime", "preLoadInfo", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "storyIdsState", "", "unReadList", "Ljava/util/ArrayList;", "withCache", "canPlay", "", "user", "storyId", "chatting", "clickScene", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkReport", "checkStayTime", "checkUnRead", "clean", "downloadEnd", "enter", "list", "", "finish", "initID", "markInit", "markResumeTime", "netSpeed", "speed", "onDestroy", "onSelectItem", "group", "selectedRow", "selectedColumn", "onVideoEnd", "onVideoPlay", "onVideoWaiting", "playUser", "preLoadVideo", "galleryItem", "extinfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "preloadWithCache", "report", "IID", "key", "mval", "startDownload", "isAll", "startHttp", "Info", "State", "plugin-story_release"})
public final class b
{
  public static final Map<Long, a> LNA;
  public static a LNB;
  public static long LNC;
  private static long LND;
  public static com.tencent.mm.plugin.story.f.d.h LNE;
  public static boolean LNF;
  public static long LNG;
  private static long LNH;
  private static int LNI;
  private static int LNJ;
  private static boolean LNK;
  private static ArrayList<String> LNL;
  public static final b LNM;
  public static long LNz;
  private static boolean isWaiting;
  public static long rJY;
  public static boolean wIk;
  private static long zUI;
  private static long zUJ;
  
  static
  {
    AppMethodBeat.i(119402);
    LNM = new b();
    rJY = 998L;
    wIk = true;
    Map localMap = Collections.synchronizedMap((Map)new HashMap());
    p.j(localMap, "Collections.synchronizedMap(HashMap<Long, Info>())");
    LNA = localMap;
    AppMethodBeat.o(119402);
  }
  
  public static void M(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(119397);
    if (!LNA.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(119397);
      return;
    }
    a locala = (a)LNA.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.LNR = Util.nowMilliSecond();
      locala.tAQ = paramBoolean;
      AppMethodBeat.o(119397);
      return;
    }
    AppMethodBeat.o(119397);
  }
  
  public static void RH(long paramLong)
  {
    LNC = paramLong;
  }
  
  public static void RI(long paramLong)
  {
    AppMethodBeat.i(119398);
    if (!LNA.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(119398);
      return;
    }
    a locala = (a)LNA.get(Long.valueOf(paramLong));
    if ((locala != null) && (locala.KIR))
    {
      AppMethodBeat.o(119398);
      return;
    }
    if (paramLong == LNC)
    {
      locala = LNB;
      if (locala != null)
      {
        if (locala.LNR <= 0L)
        {
          AppMethodBeat.o(119398);
          return;
        }
        paramLong = Util.milliSecondsToNow(locala.LNR);
        Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd1 ".concat(String.valueOf(paramLong)));
        if (locala.tAQ)
        {
          f(rJY, 62L, 1L);
          f(rJY, 63L, paramLong);
        }
        f(rJY, 60L, 1L);
        f(rJY, 61L, paramLong);
        AppMethodBeat.o(119398);
        return;
      }
      AppMethodBeat.o(119398);
      return;
    }
    locala = (a)LNA.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      if (locala.LNR <= 0L)
      {
        AppMethodBeat.o(119398);
        return;
      }
      paramLong = Util.milliSecondsToNow(locala.LNR);
      Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd2 ".concat(String.valueOf(paramLong)));
      if (locala.tAQ)
      {
        f(rJY, 62L, 1L);
        f(rJY, 63L, paramLong);
      }
      f(rJY, 60L, 1L);
      f(rJY, 61L, paramLong);
      AppMethodBeat.o(119398);
      return;
    }
    AppMethodBeat.o(119398);
  }
  
  public static void aim(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      rJY = 998L;
      return;
    }
    if (paramInt == 3)
    {
      rJY = 1006L;
      return;
    }
    rJY = -1L;
  }
  
  public static void ain(int paramInt)
  {
    AppMethodBeat.i(119393);
    long l = Util.milliSecondsToNow(zUI);
    Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "cur speed " + paramInt + " cur: " + l);
    if (l > 5000L)
    {
      if (paramInt < 10)
      {
        f(rJY, 82L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 100)
      {
        f(rJY, 83L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 200)
      {
        f(rJY, 89L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 250)
      {
        f(rJY, 84L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 450)
      {
        f(rJY, 85L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 900)
      {
        f(rJY, 86L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 1350)
      {
        f(rJY, 87L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 1800) {
        f(rJY, 88L, 1L);
      }
    }
    AppMethodBeat.o(119393);
  }
  
  private static int c(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(119395);
    Object localObject = s.LHA;
    localObject = s.a(paramj);
    if (((n)localObject).ggm())
    {
      Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay downloadFinish " + paramj.fXG);
      AppMethodBeat.o(119395);
      return 1;
    }
    if (((n)localObject).field_totalSize <= 0)
    {
      AppMethodBeat.o(119395);
      return 0;
    }
    float f = ((n)localObject).field_cacheSize / ((n)localObject).field_totalSize;
    paramj = m.MbB;
    if (f * 100.0F >= m.ggS().LZU)
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
    zUJ = 0L;
    LND = 0L;
    zUI = 0L;
    LNK = false;
    LNI = -1;
    LNJ = -1;
    LNG = 0L;
    LNH = 0L;
    LNA.clear();
    LNF = false;
    LNE = null;
    isWaiting = false;
    LNL = new ArrayList();
    LNB = null;
    AppMethodBeat.o(119391);
  }
  
  public static void d(ArrayList<ArrayList<com.tencent.mm.plugin.story.f.d.h>> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119394);
    p.k(paramArrayList, "group");
    if (!gej())
    {
      AppMethodBeat.o(119394);
      return;
    }
    Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", " last_selectedColumn:" + LNJ + ",last_selectedRow:" + LNI + " selectedRow:" + paramInt1 + ",selectedColumn:" + paramInt2);
    int i;
    int j;
    if (paramArrayList.size() > 0) {
      if ((((ArrayList)paramArrayList.get(paramInt1)).size() > 0) && (paramInt2 + 1 < ((ArrayList)paramArrayList.get(paramInt1)).size()))
      {
        if (!LNK) {
          f(rJY, 101L, 1L);
        }
        i = 1;
        if (paramInt1 + 1 < paramArrayList.size())
        {
          if (!LNK) {
            f(rJY, 102L, 1L);
          }
          j = 1;
          label167:
          LNK = true;
        }
      }
    }
    for (;;)
    {
      if ((LNJ != -1) && (LNI != -1))
      {
        if (isWaiting)
        {
          f(rJY, 100L, 1L);
          isWaiting = false;
        }
        if (paramInt1 != LNI)
        {
          if (i != 0) {
            f(rJY, 105L, 1L);
          }
          f(rJY, 106L, 1L);
          i = paramInt1 - LNI;
          if (i == 1)
          {
            f(rJY, 110L, 1L);
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
              com.tencent.mm.plugin.story.f.d.j localj = ((com.tencent.mm.plugin.story.f.d.h)((ArrayList)paramArrayList.get(paramInt1 + i)).get(0)).LIV;
              if ((localj != null) && (localj.username != null) && (LNL != null))
              {
                ArrayList localArrayList = LNL;
                if ((localArrayList != null) && (localArrayList.contains(localj.username) == true))
                {
                  if (c(localj) == 1)
                  {
                    if (i != 0) {
                      break label460;
                    }
                    f(rJY, 120L, 1L);
                  }
                  label385:
                  if (i != 0) {
                    break label496;
                  }
                  f(rJY, 125L, 1L);
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
              f(rJY, 111L, 1L);
              break;
            }
            if (i == 3)
            {
              f(rJY, 112L, 1L);
              break;
            }
            if (i < 4) {
              break;
            }
            f(rJY, 113L, 1L);
            break;
            label460:
            if (i == 1)
            {
              f(rJY, 121L, 1L);
              break label385;
            }
            if (i != 2) {
              break label385;
            }
            f(rJY, 122L, 1L);
            break label385;
            label496:
            if (i == 1) {
              f(rJY, 126L, 1L);
            } else if (i == 2) {
              f(rJY, 127L, 1L);
            }
          }
        }
        else if (paramInt2 != LNJ)
        {
          if (j != 0) {
            f(rJY, 103L, 1L);
          }
          f(rJY, 104L, 1L);
          i = paramInt2 - LNJ;
          if (i != 1) {
            break label957;
          }
          f(rJY, 115L, 1L);
        }
      }
      for (;;)
      {
        label585:
        if ((LNI >= 0) && (LNI < paramArrayList.size()) && (LNJ >= 0) && (LNJ < ((ArrayList)paramArrayList.get(LNI)).size()) && ((LNJ != paramInt2) || (LNI != paramInt1)))
        {
          long l = ((com.tencent.mm.plugin.story.f.d.h)((ArrayList)paramArrayList.get(LNI)).get(LNJ)).LIV.fXG;
          Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime storyId " + l + " lastStoryId " + LNz);
          if ((gej()) && (LNA.containsKey(Long.valueOf(l))))
          {
            paramArrayList = (a)LNA.get(Long.valueOf(l));
            if ((paramArrayList != null) && (paramArrayList.LNN <= 0L) && (!paramArrayList.KIR) && (paramArrayList.LNO >= 0L))
            {
              paramArrayList.LNN = Util.milliSecondsToNow(paramArrayList.LNO);
              Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime onStayTime " + l + ' ' + paramArrayList.LNN + " hasHttp:" + paramArrayList.LNQ + "  isWaiting:" + paramArrayList.isWaiting);
              if (paramArrayList.LNQ)
              {
                f(rJY, 21L, 1L);
                f(rJY, 20L, paramArrayList.LNN);
              }
              if (paramArrayList.isWaiting)
              {
                f(rJY, 23L, 1L);
                f(rJY, 22L, paramArrayList.LNN);
              }
              f(rJY, 25L, 1L);
              f(rJY, 24L, paramArrayList.LNN);
              if (paramArrayList.kSa) {
                f(rJY, 26L, 1L);
              }
            }
          }
        }
        LNJ = paramInt2;
        LNI = paramInt1;
        AppMethodBeat.o(119394);
        return;
        label957:
        if (i == 2) {
          f(rJY, 116L, 1L);
        } else if (i == 3) {
          f(rJY, 117L, 1L);
        } else if (i >= 4) {
          f(rJY, 118L, 1L);
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
  
  public static void f(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(119390);
    if (paramLong1 < 0L)
    {
      AppMethodBeat.o(119390);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.p(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(119390);
  }
  
  public static void geg()
  {
    LNF = true;
  }
  
  public static void geh()
  {
    AppMethodBeat.i(119399);
    Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "makeResumeTime onResumeTime " + zUJ + " onPlayUser " + LND);
    zUJ = Util.nowMilliSecond();
    AppMethodBeat.o(119399);
  }
  
  public static void gei()
  {
    AppMethodBeat.i(119401);
    zUI = Util.nowMilliSecond();
    AppMethodBeat.o(119401);
  }
  
  public static boolean gej()
  {
    if (zUI <= 0L) {}
    while (!wIk) {
      return false;
    }
    return true;
  }
  
  public static void ie(List<String> paramList)
  {
    AppMethodBeat.i(119392);
    p.k(paramList, "list");
    ArrayList localArrayList = new ArrayList();
    LNL = localArrayList;
    localArrayList.addAll((Collection)paramList);
    AppMethodBeat.o(119392);
  }
  
  public static void o(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(119400);
    p.k(paramString, "user");
    if (!gej())
    {
      AppMethodBeat.o(119400);
      return;
    }
    if ((LNG > 0L) && (LNH <= 0L))
    {
      LNH = Util.milliSecondsToNow(LNG);
      f(rJY, 130L, 1L);
      f(rJY, 131L, LNH);
    }
    Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser user " + paramString + " storyId " + paramLong + " selectedColumn " + paramInt + " lastStoryId:" + LNz + " onStoryLauncherTime " + LNH);
    int j = 0;
    int i = j;
    if (LNz != paramLong)
    {
      i = j;
      if (LNz != 0L) {
        i = 1;
      }
    }
    long l = LNz;
    LNz = paramLong;
    p.k(paramString, "user");
    Object localObject = LNL;
    if ((localObject != null) && (((ArrayList)localObject).contains(paramString) == true)) {}
    for (j = 1; j == 0; j = 0)
    {
      AppMethodBeat.o(119400);
      return;
    }
    if ((LNA.containsKey(Long.valueOf(l))) && (i != 0))
    {
      localObject = (a)LNA.get(Long.valueOf(l));
      if (localObject != null) {
        ((a)localObject).KIR = true;
      }
    }
    if (paramInt > 0)
    {
      AppMethodBeat.o(119400);
      return;
    }
    localObject = LNA;
    a locala = new a(paramString, b.b.LNU);
    locala.LNO = Util.nowMilliSecond();
    ((Map)localObject).put(Long.valueOf(paramLong), locala);
    LND = Util.nowMilliSecond();
    Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser onResumeTime " + LND);
    localObject = com.tencent.mm.plugin.story.f.j.LGA;
    localObject = j.b.gcx().bcW(paramString);
    Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "preLoadCache > 0 then " + paramString + " preload " + Util.getSizeKB(((f)localObject).gfU()));
    f(rJY, 2L, 1L);
    if (((f)localObject).gfU() > 0L) {
      f(rJY, 3L, 1L);
    }
    if (paramLong == LNC)
    {
      if (LNF)
      {
        f(rJY, 6L, 1L);
        if (((f)localObject).gfU() > 0L)
        {
          if (!LNF) {
            break label545;
          }
          f(rJY, 7L, 1L);
        }
      }
      for (;;)
      {
        paramString = LNE;
        if (paramString == null) {
          break label575;
        }
        if (c(paramString.LIV) != 1) {
          break label568;
        }
        if (!LNF) {
          break label558;
        }
        f(rJY, 8L, 1L);
        AppMethodBeat.o(119400);
        return;
        f(rJY, 9L, 1L);
        break;
        label545:
        f(rJY, 10L, 1L);
      }
      label558:
      f(rJY, 11L, 1L);
      label568:
      AppMethodBeat.o(119400);
      return;
    }
    label575:
    AppMethodBeat.o(119400);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "", "user", "", "state", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "clean", "", "getClean", "()Z", "setClean", "(Z)V", "hasHttp", "getHasHttp", "setHasHttp", "isAll", "setAll", "isEnd", "setEnd", "isWaiting", "setWaiting", "onMarkPlayCall", "", "getOnMarkPlayCall", "()J", "setOnMarkPlayCall", "(J)V", "onMarkPlayingCall", "getOnMarkPlayingCall", "setOnMarkPlayingCall", "onStayTime", "getOnStayTime", "setOnStayTime", "startHttp", "getStartHttp", "setStartHttp", "getState", "()Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "setState", "(Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "getUser", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a
  {
    public boolean KIR;
    long LNN;
    public long LNO;
    public long LNP;
    public boolean LNQ;
    public long LNR;
    private b.b LNS;
    private final String fPV;
    public boolean isWaiting;
    public boolean kSa;
    public boolean tAQ;
    
    public a(String paramString, b.b paramb)
    {
      AppMethodBeat.i(119386);
      this.fPV = paramString;
      this.LNS = paramb;
      AppMethodBeat.o(119386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.b
 * JD-Core Version:    0.7.0.1
 */