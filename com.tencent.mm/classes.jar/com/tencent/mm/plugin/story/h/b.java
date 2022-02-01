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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "isWaiting", "", "isWifi", "lastStoryId", "last_selectedColumn", "", "last_selectedRow", "markGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "markStoryId", "onClickTime", "onCreateTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStoryLauncherTime", "preLoadInfo", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "storyIdsState", "", "unReadList", "Ljava/util/ArrayList;", "withCache", "canPlay", "", "user", "storyId", "chatting", "clickScene", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkReport", "checkStayTime", "checkUnRead", "clean", "downloadEnd", "enter", "list", "", "finish", "initID", "markInit", "markResumeTime", "netSpeed", "speed", "onDestroy", "onSelectItem", "group", "selectedRow", "selectedColumn", "onVideoEnd", "onVideoPlay", "onVideoWaiting", "playUser", "preLoadVideo", "galleryItem", "extinfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "preloadWithCache", "report", "IID", "key", "mval", "startDownload", "isAll", "startHttp", "Info", "State", "plugin-story_release"})
public final class b
{
  private static long FtA;
  private static long FtB;
  public static com.tencent.mm.plugin.story.f.d.h FtC;
  public static boolean FtD;
  public static long FtE;
  private static long FtF;
  private static long FtG;
  private static int FtH;
  private static int FtI;
  private static boolean FtJ;
  private static ArrayList<String> FtK;
  public static final b FtL;
  public static long Ftw;
  public static final Map<Long, a> Ftx;
  public static a Fty;
  public static long Ftz;
  private static boolean isWaiting;
  public static long oIi;
  public static boolean tcf;
  
  static
  {
    AppMethodBeat.i(119402);
    FtL = new b();
    oIi = 998L;
    tcf = true;
    Map localMap = Collections.synchronizedMap((Map)new HashMap());
    p.g(localMap, "Collections.synchronizedMap(HashMap<Long, Info>())");
    Ftx = localMap;
    AppMethodBeat.o(119402);
  }
  
  public static void Kn(long paramLong)
  {
    Ftz = paramLong;
  }
  
  public static void Ko(long paramLong)
  {
    AppMethodBeat.i(119398);
    if (!Ftx.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(119398);
      return;
    }
    a locala = (a)Ftx.get(Long.valueOf(paramLong));
    if ((locala != null) && (locala.Eva))
    {
      AppMethodBeat.o(119398);
      return;
    }
    if (paramLong == Ftz)
    {
      locala = Fty;
      if (locala != null)
      {
        if (locala.FtQ <= 0L)
        {
          AppMethodBeat.o(119398);
          return;
        }
        paramLong = Util.milliSecondsToNow(locala.FtQ);
        Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd1 ".concat(String.valueOf(paramLong)));
        if (locala.qeT)
        {
          e(oIi, 62L, 1L);
          e(oIi, 63L, paramLong);
        }
        e(oIi, 60L, 1L);
        e(oIi, 61L, paramLong);
        AppMethodBeat.o(119398);
        return;
      }
      AppMethodBeat.o(119398);
      return;
    }
    locala = (a)Ftx.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      if (locala.FtQ <= 0L)
      {
        AppMethodBeat.o(119398);
        return;
      }
      paramLong = Util.milliSecondsToNow(locala.FtQ);
      Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd2 ".concat(String.valueOf(paramLong)));
      if (locala.qeT)
      {
        e(oIi, 62L, 1L);
        e(oIi, 63L, paramLong);
      }
      e(oIi, 60L, 1L);
      e(oIi, 61L, paramLong);
      AppMethodBeat.o(119398);
      return;
    }
    AppMethodBeat.o(119398);
  }
  
  public static void M(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(119397);
    if (!Ftx.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(119397);
      return;
    }
    a locala = (a)Ftx.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.FtQ = Util.nowMilliSecond();
      locala.qeT = paramBoolean;
      AppMethodBeat.o(119397);
      return;
    }
    AppMethodBeat.o(119397);
  }
  
  public static void aaR(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      oIi = 998L;
      return;
    }
    if (paramInt == 3)
    {
      oIi = 1006L;
      return;
    }
    oIi = -1L;
  }
  
  public static void aaS(int paramInt)
  {
    AppMethodBeat.i(119393);
    long l = Util.milliSecondsToNow(FtG);
    Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "cur speed " + paramInt + " cur: " + l);
    if (l > 5000L)
    {
      if (paramInt < 10)
      {
        e(oIi, 82L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 100)
      {
        e(oIi, 83L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 200)
      {
        e(oIi, 89L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 250)
      {
        e(oIi, 84L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 450)
      {
        e(oIi, 85L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 900)
      {
        e(oIi, 86L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 1350)
      {
        e(oIi, 87L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 1800) {
        e(oIi, 88L, 1L);
      }
    }
    AppMethodBeat.o(119393);
  }
  
  public static boolean beE()
  {
    if (FtG <= 0L) {}
    while (!tcf) {
      return false;
    }
    return true;
  }
  
  private static int c(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(119395);
    Object localObject = s.Fny;
    localObject = s.a(paramj);
    if (((n)localObject).frQ())
    {
      Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay downloadFinish " + paramj.edx);
      AppMethodBeat.o(119395);
      return 1;
    }
    if (((n)localObject).field_totalSize <= 0)
    {
      AppMethodBeat.o(119395);
      return 0;
    }
    float f = ((n)localObject).field_cacheSize / ((n)localObject).field_totalSize;
    paramj = m.FHB;
    if (f * 100.0F >= m.fsu().FFU)
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
    FtA = 0L;
    FtB = 0L;
    FtG = 0L;
    FtJ = false;
    FtH = -1;
    FtI = -1;
    FtE = 0L;
    FtF = 0L;
    Ftx.clear();
    FtD = false;
    FtC = null;
    isWaiting = false;
    FtK = new ArrayList();
    Fty = null;
    AppMethodBeat.o(119391);
  }
  
  public static void d(ArrayList<ArrayList<com.tencent.mm.plugin.story.f.d.h>> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119394);
    p.h(paramArrayList, "group");
    if (!beE())
    {
      AppMethodBeat.o(119394);
      return;
    }
    Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", " last_selectedColumn:" + FtI + ",last_selectedRow:" + FtH + " selectedRow:" + paramInt1 + ",selectedColumn:" + paramInt2);
    int i;
    int j;
    if (paramArrayList.size() > 0) {
      if ((((ArrayList)paramArrayList.get(paramInt1)).size() > 0) && (paramInt2 + 1 < ((ArrayList)paramArrayList.get(paramInt1)).size()))
      {
        if (!FtJ) {
          e(oIi, 101L, 1L);
        }
        i = 1;
        if (paramInt1 + 1 < paramArrayList.size())
        {
          if (!FtJ) {
            e(oIi, 102L, 1L);
          }
          j = 1;
          label167:
          FtJ = true;
        }
      }
    }
    for (;;)
    {
      if ((FtI != -1) && (FtH != -1))
      {
        if (isWaiting)
        {
          e(oIi, 100L, 1L);
          isWaiting = false;
        }
        if (paramInt1 != FtH)
        {
          if (i != 0) {
            e(oIi, 105L, 1L);
          }
          e(oIi, 106L, 1L);
          i = paramInt1 - FtH;
          if (i == 1)
          {
            e(oIi, 110L, 1L);
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
              com.tencent.mm.plugin.story.f.d.j localj = ((com.tencent.mm.plugin.story.f.d.h)((ArrayList)paramArrayList.get(paramInt1 + i)).get(0)).FoT;
              if ((localj != null) && (localj.username != null) && (FtK != null))
              {
                ArrayList localArrayList = FtK;
                if ((localArrayList != null) && (localArrayList.contains(localj.username) == true))
                {
                  if (c(localj) == 1)
                  {
                    if (i != 0) {
                      break label460;
                    }
                    e(oIi, 120L, 1L);
                  }
                  label385:
                  if (i != 0) {
                    break label496;
                  }
                  e(oIi, 125L, 1L);
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
              e(oIi, 111L, 1L);
              break;
            }
            if (i == 3)
            {
              e(oIi, 112L, 1L);
              break;
            }
            if (i < 4) {
              break;
            }
            e(oIi, 113L, 1L);
            break;
            label460:
            if (i == 1)
            {
              e(oIi, 121L, 1L);
              break label385;
            }
            if (i != 2) {
              break label385;
            }
            e(oIi, 122L, 1L);
            break label385;
            label496:
            if (i == 1) {
              e(oIi, 126L, 1L);
            } else if (i == 2) {
              e(oIi, 127L, 1L);
            }
          }
        }
        else if (paramInt2 != FtI)
        {
          if (j != 0) {
            e(oIi, 103L, 1L);
          }
          e(oIi, 104L, 1L);
          i = paramInt2 - FtI;
          if (i != 1) {
            break label957;
          }
          e(oIi, 115L, 1L);
        }
      }
      for (;;)
      {
        label585:
        if ((FtH >= 0) && (FtH < paramArrayList.size()) && (FtI >= 0) && (FtI < ((ArrayList)paramArrayList.get(FtH)).size()) && ((FtI != paramInt2) || (FtH != paramInt1)))
        {
          long l = ((com.tencent.mm.plugin.story.f.d.h)((ArrayList)paramArrayList.get(FtH)).get(FtI)).FoT.edx;
          Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime storyId " + l + " lastStoryId " + Ftw);
          if ((beE()) && (Ftx.containsKey(Long.valueOf(l))))
          {
            paramArrayList = (a)Ftx.get(Long.valueOf(l));
            if ((paramArrayList != null) && (paramArrayList.FtM <= 0L) && (!paramArrayList.Eva) && (paramArrayList.FtN >= 0L))
            {
              paramArrayList.FtM = Util.milliSecondsToNow(paramArrayList.FtN);
              Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime onStayTime " + l + ' ' + paramArrayList.FtM + " hasHttp:" + paramArrayList.FtP + "  isWaiting:" + paramArrayList.isWaiting);
              if (paramArrayList.FtP)
              {
                e(oIi, 21L, 1L);
                e(oIi, 20L, paramArrayList.FtM);
              }
              if (paramArrayList.isWaiting)
              {
                e(oIi, 23L, 1L);
                e(oIi, 22L, paramArrayList.FtM);
              }
              e(oIi, 25L, 1L);
              e(oIi, 24L, paramArrayList.FtM);
              if (paramArrayList.idt) {
                e(oIi, 26L, 1L);
              }
            }
          }
        }
        FtI = paramInt2;
        FtH = paramInt1;
        AppMethodBeat.o(119394);
        return;
        label957:
        if (i == 2) {
          e(oIi, 116L, 1L);
        } else if (i == 3) {
          e(oIi, 117L, 1L);
        } else if (i >= 4) {
          e(oIi, 118L, 1L);
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
  
  public static void e(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(119390);
    if (paramLong1 < 0L)
    {
      AppMethodBeat.o(119390);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.n(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(119390);
  }
  
  public static void fpM()
  {
    FtD = true;
  }
  
  public static void fpN()
  {
    AppMethodBeat.i(119399);
    Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "makeResumeTime onResumeTime " + FtA + " onPlayUser " + FtB);
    FtA = Util.nowMilliSecond();
    AppMethodBeat.o(119399);
  }
  
  public static void fpO()
  {
    AppMethodBeat.i(119401);
    FtG = Util.nowMilliSecond();
    AppMethodBeat.o(119401);
  }
  
  public static void hv(List<String> paramList)
  {
    AppMethodBeat.i(119392);
    p.h(paramList, "list");
    ArrayList localArrayList = new ArrayList();
    FtK = localArrayList;
    localArrayList.addAll((Collection)paramList);
    AppMethodBeat.o(119392);
  }
  
  public static void n(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(119400);
    p.h(paramString, "user");
    if (!beE())
    {
      AppMethodBeat.o(119400);
      return;
    }
    if ((FtE > 0L) && (FtF <= 0L))
    {
      FtF = Util.milliSecondsToNow(FtE);
      e(oIi, 130L, 1L);
      e(oIi, 131L, FtF);
    }
    Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser user " + paramString + " storyId " + paramLong + " selectedColumn " + paramInt + " lastStoryId:" + Ftw + " onStoryLauncherTime " + FtF);
    int j = 0;
    int i = j;
    if (Ftw != paramLong)
    {
      i = j;
      if (Ftw != 0L) {
        i = 1;
      }
    }
    long l = Ftw;
    Ftw = paramLong;
    p.h(paramString, "user");
    Object localObject = FtK;
    if ((localObject != null) && (((ArrayList)localObject).contains(paramString) == true)) {}
    for (j = 1; j == 0; j = 0)
    {
      AppMethodBeat.o(119400);
      return;
    }
    if ((Ftx.containsKey(Long.valueOf(l))) && (i != 0))
    {
      localObject = (a)Ftx.get(Long.valueOf(l));
      if (localObject != null) {
        ((a)localObject).Eva = true;
      }
    }
    if (paramInt > 0)
    {
      AppMethodBeat.o(119400);
      return;
    }
    localObject = Ftx;
    a locala = new a(paramString, b.b.FtT);
    locala.FtN = Util.nowMilliSecond();
    ((Map)localObject).put(Long.valueOf(paramLong), locala);
    FtB = Util.nowMilliSecond();
    Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser onResumeTime " + FtB);
    localObject = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject = j.b.fod().aRS(paramString);
    Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "preLoadCache > 0 then " + paramString + " preload " + Util.getSizeKB(((f)localObject).fry()));
    e(oIi, 2L, 1L);
    if (((f)localObject).fry() > 0L) {
      e(oIi, 3L, 1L);
    }
    if (paramLong == Ftz)
    {
      if (FtD)
      {
        e(oIi, 6L, 1L);
        if (((f)localObject).fry() > 0L)
        {
          if (!FtD) {
            break label545;
          }
          e(oIi, 7L, 1L);
        }
      }
      for (;;)
      {
        paramString = FtC;
        if (paramString == null) {
          break label575;
        }
        if (c(paramString.FoT) != 1) {
          break label568;
        }
        if (!FtD) {
          break label558;
        }
        e(oIi, 8L, 1L);
        AppMethodBeat.o(119400);
        return;
        e(oIi, 9L, 1L);
        break;
        label545:
        e(oIi, 10L, 1L);
      }
      label558:
      e(oIi, 11L, 1L);
      label568:
      AppMethodBeat.o(119400);
      return;
    }
    label575:
    AppMethodBeat.o(119400);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "", "user", "", "state", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "clean", "", "getClean", "()Z", "setClean", "(Z)V", "hasHttp", "getHasHttp", "setHasHttp", "isAll", "setAll", "isEnd", "setEnd", "isWaiting", "setWaiting", "onMarkPlayCall", "", "getOnMarkPlayCall", "()J", "setOnMarkPlayCall", "(J)V", "onMarkPlayingCall", "getOnMarkPlayingCall", "setOnMarkPlayingCall", "onStayTime", "getOnStayTime", "setOnStayTime", "startHttp", "getStartHttp", "setStartHttp", "getState", "()Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "setState", "(Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "getUser", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a
  {
    public boolean Eva;
    long FtM;
    public long FtN;
    public long FtO;
    public boolean FtP;
    public long FtQ;
    private b.b FtR;
    private final String dWq;
    public boolean idt;
    public boolean isWaiting;
    public boolean qeT;
    
    public a(String paramString, b.b paramb)
    {
      AppMethodBeat.i(119386);
      this.dWq = paramString;
      this.FtR = paramb;
      AppMethodBeat.o(119386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.b
 * JD-Core Version:    0.7.0.1
 */