package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.ui.view.gallery.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "isWaiting", "", "isWifi", "lastStoryId", "last_selectedColumn", "", "last_selectedRow", "markGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "markStoryId", "onClickTime", "onCreateTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStoryLauncherTime", "preLoadInfo", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "storyIdsState", "", "unReadList", "Ljava/util/ArrayList;", "withCache", "canPlay", "", "user", "storyId", "chatting", "clickScene", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkReport", "checkStayTime", "checkUnRead", "clean", "downloadEnd", "enter", "list", "", "finish", "initID", "markInit", "markResumeTime", "netSpeed", "speed", "onDestroy", "onSelectItem", "group", "selectedRow", "selectedColumn", "onVideoEnd", "onVideoPlay", "onVideoWaiting", "playUser", "preLoadVideo", "galleryItem", "extinfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "preloadWithCache", "report", "IID", "key", "mval", "startDownload", "isAll", "startHttp", "Info", "State", "plugin-story_release"})
public final class b
{
  public static long BiG;
  public static final Map<Long, a> BiH;
  public static a BiI;
  public static long BiJ;
  private static long BiK;
  private static long BiL;
  public static h BiM;
  public static boolean BiN;
  public static long BiO;
  private static long BiP;
  private static long BiQ;
  private static int BiR;
  private static int BiS;
  private static boolean BiT;
  private static ArrayList<String> BiU;
  public static final b BiV;
  private static boolean isWaiting;
  public static long pXC;
  public static boolean rCA;
  
  static
  {
    AppMethodBeat.i(119402);
    BiV = new b();
    pXC = 998L;
    rCA = true;
    Map localMap = Collections.synchronizedMap((Map)new HashMap());
    p.g(localMap, "Collections.synchronizedMap(HashMap<Long, Info>())");
    BiH = localMap;
    AppMethodBeat.o(119402);
  }
  
  public static void Bi(long paramLong)
  {
    BiJ = paramLong;
  }
  
  public static void Bj(long paramLong)
  {
    AppMethodBeat.i(119398);
    if (!BiH.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(119398);
      return;
    }
    a locala = (a)BiH.get(Long.valueOf(paramLong));
    if ((locala != null) && (locala.Amo))
    {
      AppMethodBeat.o(119398);
      return;
    }
    if (paramLong == BiJ)
    {
      locala = BiI;
      if (locala != null)
      {
        if (locala.Bja <= 0L)
        {
          AppMethodBeat.o(119398);
          return;
        }
        paramLong = bu.DD(locala.Bja);
        ae.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd1 ".concat(String.valueOf(paramLong)));
        if (locala.oRf)
        {
          e(pXC, 62L, 1L);
          e(pXC, 63L, paramLong);
        }
        e(pXC, 60L, 1L);
        e(pXC, 61L, paramLong);
        AppMethodBeat.o(119398);
        return;
      }
      AppMethodBeat.o(119398);
      return;
    }
    locala = (a)BiH.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      if (locala.Bja <= 0L)
      {
        AppMethodBeat.o(119398);
        return;
      }
      paramLong = bu.DD(locala.Bja);
      ae.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd2 ".concat(String.valueOf(paramLong)));
      if (locala.oRf)
      {
        e(pXC, 62L, 1L);
        e(pXC, 63L, paramLong);
      }
      e(pXC, 60L, 1L);
      e(pXC, 61L, paramLong);
      AppMethodBeat.o(119398);
      return;
    }
    AppMethodBeat.o(119398);
  }
  
  public static void H(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(119397);
    if (!BiH.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(119397);
      return;
    }
    a locala = (a)BiH.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.Bja = bu.fpO();
      locala.oRf = paramBoolean;
      AppMethodBeat.o(119397);
      return;
    }
    AppMethodBeat.o(119397);
  }
  
  public static void SV(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      pXC = 998L;
      return;
    }
    if (paramInt == 3)
    {
      pXC = 1006L;
      return;
    }
    pXC = -1L;
  }
  
  public static void SW(int paramInt)
  {
    AppMethodBeat.i(119393);
    long l = bu.DD(BiQ);
    ae.i("MicroMsg.StoryBrowseDetailIDKeyStat", "cur speed " + paramInt + " cur: " + l);
    if (l > 5000L)
    {
      if (paramInt < 10)
      {
        e(pXC, 82L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 100)
      {
        e(pXC, 83L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 200)
      {
        e(pXC, 89L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 250)
      {
        e(pXC, 84L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 450)
      {
        e(pXC, 85L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 900)
      {
        e(pXC, 86L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 1350)
      {
        e(pXC, 87L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 1800) {
        e(pXC, 88L, 1L);
      }
    }
    AppMethodBeat.o(119393);
  }
  
  public static boolean aKB()
  {
    if (BiQ <= 0L) {}
    while (!rCA) {
      return false;
    }
    return true;
  }
  
  private static int c(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(119395);
    Object localObject = s.BcG;
    localObject = s.a(paramj);
    if (((n)localObject).epq())
    {
      ae.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay downloadFinish " + paramj.dLI);
      AppMethodBeat.o(119395);
      return 1;
    }
    if (((n)localObject).field_totalSize <= 0)
    {
      AppMethodBeat.o(119395);
      return 0;
    }
    float f = ((n)localObject).field_cacheSize / ((n)localObject).field_totalSize;
    paramj = m.BwQ;
    if (f * 100.0F >= m.epV().Bvj)
    {
      ae.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay cachesize " + ((n)localObject).field_cacheSize + " totalSize: " + ((n)localObject).field_totalSize);
      AppMethodBeat.o(119395);
      return 1;
    }
    AppMethodBeat.o(119395);
    return 0;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(119391);
    BiK = 0L;
    BiL = 0L;
    BiQ = 0L;
    BiT = false;
    BiR = -1;
    BiS = -1;
    BiO = 0L;
    BiP = 0L;
    BiH.clear();
    BiN = false;
    BiM = null;
    isWaiting = false;
    BiU = new ArrayList();
    BiI = null;
    AppMethodBeat.o(119391);
  }
  
  public static void d(ArrayList<ArrayList<h>> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119394);
    p.h(paramArrayList, "group");
    if (!aKB())
    {
      AppMethodBeat.o(119394);
      return;
    }
    ae.v("MicroMsg.StoryBrowseDetailIDKeyStat", " last_selectedColumn:" + BiS + ",last_selectedRow:" + BiR + " selectedRow:" + paramInt1 + ",selectedColumn:" + paramInt2);
    int i;
    int j;
    if (paramArrayList.size() > 0) {
      if ((((ArrayList)paramArrayList.get(paramInt1)).size() > 0) && (paramInt2 + 1 < ((ArrayList)paramArrayList.get(paramInt1)).size()))
      {
        if (!BiT) {
          e(pXC, 101L, 1L);
        }
        i = 1;
        if (paramInt1 + 1 < paramArrayList.size())
        {
          if (!BiT) {
            e(pXC, 102L, 1L);
          }
          j = 1;
          label167:
          BiT = true;
        }
      }
    }
    for (;;)
    {
      if ((BiS != -1) && (BiR != -1))
      {
        if (isWaiting)
        {
          e(pXC, 100L, 1L);
          isWaiting = false;
        }
        if (paramInt1 != BiR)
        {
          if (i != 0) {
            e(pXC, 105L, 1L);
          }
          e(pXC, 106L, 1L);
          i = paramInt1 - BiR;
          if (i == 1)
          {
            e(pXC, 110L, 1L);
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
              com.tencent.mm.plugin.story.f.d.j localj = ((h)((ArrayList)paramArrayList.get(paramInt1 + i)).get(0)).Bec;
              if ((localj != null) && (localj.username != null) && (BiU != null))
              {
                ArrayList localArrayList = BiU;
                if ((localArrayList != null) && (localArrayList.contains(localj.username) == true))
                {
                  if (c(localj) == 1)
                  {
                    if (i != 0) {
                      break label460;
                    }
                    e(pXC, 120L, 1L);
                  }
                  label385:
                  if (i != 0) {
                    break label496;
                  }
                  e(pXC, 125L, 1L);
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
              e(pXC, 111L, 1L);
              break;
            }
            if (i == 3)
            {
              e(pXC, 112L, 1L);
              break;
            }
            if (i < 4) {
              break;
            }
            e(pXC, 113L, 1L);
            break;
            label460:
            if (i == 1)
            {
              e(pXC, 121L, 1L);
              break label385;
            }
            if (i != 2) {
              break label385;
            }
            e(pXC, 122L, 1L);
            break label385;
            label496:
            if (i == 1) {
              e(pXC, 126L, 1L);
            } else if (i == 2) {
              e(pXC, 127L, 1L);
            }
          }
        }
        else if (paramInt2 != BiS)
        {
          if (j != 0) {
            e(pXC, 103L, 1L);
          }
          e(pXC, 104L, 1L);
          i = paramInt2 - BiS;
          if (i != 1) {
            break label957;
          }
          e(pXC, 115L, 1L);
        }
      }
      for (;;)
      {
        label585:
        if ((BiR >= 0) && (BiR < paramArrayList.size()) && (BiS >= 0) && (BiS < ((ArrayList)paramArrayList.get(BiR)).size()) && ((BiS != paramInt2) || (BiR != paramInt1)))
        {
          long l = ((h)((ArrayList)paramArrayList.get(BiR)).get(BiS)).Bec.dLI;
          ae.v("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime storyId " + l + " lastStoryId " + BiG);
          if ((aKB()) && (BiH.containsKey(Long.valueOf(l))))
          {
            paramArrayList = (a)BiH.get(Long.valueOf(l));
            if ((paramArrayList != null) && (paramArrayList.BiW <= 0L) && (!paramArrayList.Amo) && (paramArrayList.BiX >= 0L))
            {
              paramArrayList.BiW = bu.DD(paramArrayList.BiX);
              ae.i("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime onStayTime " + l + ' ' + paramArrayList.BiW + " hasHttp:" + paramArrayList.BiZ + "  isWaiting:" + paramArrayList.isWaiting);
              if (paramArrayList.BiZ)
              {
                e(pXC, 21L, 1L);
                e(pXC, 20L, paramArrayList.BiW);
              }
              if (paramArrayList.isWaiting)
              {
                e(pXC, 23L, 1L);
                e(pXC, 22L, paramArrayList.BiW);
              }
              e(pXC, 25L, 1L);
              e(pXC, 24L, paramArrayList.BiW);
              if (paramArrayList.hkx) {
                e(pXC, 26L, 1L);
              }
            }
          }
        }
        BiS = paramInt2;
        BiR = paramInt1;
        AppMethodBeat.o(119394);
        return;
        label957:
        if (i == 2) {
          e(pXC, 116L, 1L);
        } else if (i == 3) {
          e(pXC, 117L, 1L);
        } else if (i >= 4) {
          e(pXC, 118L, 1L);
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
    com.tencent.mm.plugin.report.service.g.yxI.n(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(119390);
  }
  
  public static void enm()
  {
    BiN = true;
  }
  
  public static void enn()
  {
    AppMethodBeat.i(119399);
    ae.v("MicroMsg.StoryBrowseDetailIDKeyStat", "makeResumeTime onResumeTime " + BiK + " onPlayUser " + BiL);
    BiK = bu.fpO();
    AppMethodBeat.o(119399);
  }
  
  public static void eno()
  {
    AppMethodBeat.i(119401);
    BiQ = bu.fpO();
    AppMethodBeat.o(119401);
  }
  
  public static void gy(List<String> paramList)
  {
    AppMethodBeat.i(119392);
    p.h(paramList, "list");
    ArrayList localArrayList = new ArrayList();
    BiU = localArrayList;
    localArrayList.addAll((Collection)paramList);
    AppMethodBeat.o(119392);
  }
  
  public static void n(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(119400);
    p.h(paramString, "user");
    if (!aKB())
    {
      AppMethodBeat.o(119400);
      return;
    }
    if ((BiO > 0L) && (BiP <= 0L))
    {
      BiP = bu.DD(BiO);
      e(pXC, 130L, 1L);
      e(pXC, 131L, BiP);
    }
    ae.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser user " + paramString + " storyId " + paramLong + " selectedColumn " + paramInt + " lastStoryId:" + BiG + " onStoryLauncherTime " + BiP);
    int j = 0;
    int i = j;
    if (BiG != paramLong)
    {
      i = j;
      if (BiG != 0L) {
        i = 1;
      }
    }
    long l = BiG;
    BiG = paramLong;
    p.h(paramString, "user");
    Object localObject = BiU;
    if ((localObject != null) && (((ArrayList)localObject).contains(paramString) == true)) {}
    for (j = 1; j == 0; j = 0)
    {
      AppMethodBeat.o(119400);
      return;
    }
    if ((BiH.containsKey(Long.valueOf(l))) && (i != 0))
    {
      localObject = (a)BiH.get(Long.valueOf(l));
      if (localObject != null) {
        ((a)localObject).Amo = true;
      }
    }
    if (paramInt > 0)
    {
      AppMethodBeat.o(119400);
      return;
    }
    localObject = BiH;
    a locala = new a(paramString, b.b.Bjd);
    locala.BiX = bu.fpO();
    ((Map)localObject).put(Long.valueOf(paramLong), locala);
    BiL = bu.fpO();
    ae.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser onResumeTime " + BiL);
    localObject = com.tencent.mm.plugin.story.f.j.BbE;
    localObject = j.b.elC().aCW(paramString);
    ae.i("MicroMsg.StoryBrowseDetailIDKeyStat", "preLoadCache > 0 then " + paramString + " preload " + bu.sL(((f)localObject).eoY()));
    e(pXC, 2L, 1L);
    if (((f)localObject).eoY() > 0L) {
      e(pXC, 3L, 1L);
    }
    if (paramLong == BiJ)
    {
      if (BiN)
      {
        e(pXC, 6L, 1L);
        if (((f)localObject).eoY() > 0L)
        {
          if (!BiN) {
            break label545;
          }
          e(pXC, 7L, 1L);
        }
      }
      for (;;)
      {
        paramString = BiM;
        if (paramString == null) {
          break label575;
        }
        if (c(paramString.Bec) != 1) {
          break label568;
        }
        if (!BiN) {
          break label558;
        }
        e(pXC, 8L, 1L);
        AppMethodBeat.o(119400);
        return;
        e(pXC, 9L, 1L);
        break;
        label545:
        e(pXC, 10L, 1L);
      }
      label558:
      e(pXC, 11L, 1L);
      label568:
      AppMethodBeat.o(119400);
      return;
    }
    label575:
    AppMethodBeat.o(119400);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "", "user", "", "state", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "clean", "", "getClean", "()Z", "setClean", "(Z)V", "hasHttp", "getHasHttp", "setHasHttp", "isAll", "setAll", "isEnd", "setEnd", "isWaiting", "setWaiting", "onMarkPlayCall", "", "getOnMarkPlayCall", "()J", "setOnMarkPlayCall", "(J)V", "onMarkPlayingCall", "getOnMarkPlayingCall", "setOnMarkPlayingCall", "onStayTime", "getOnStayTime", "setOnStayTime", "startHttp", "getStartHttp", "setStartHttp", "getState", "()Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "setState", "(Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "getUser", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a
  {
    public boolean Amo;
    long BiW;
    public long BiX;
    public long BiY;
    public boolean BiZ;
    public long Bja;
    private b.b Bjb;
    private final String dED;
    public boolean hkx;
    public boolean isWaiting;
    public boolean oRf;
    
    public a(String paramString, b.b paramb)
    {
      AppMethodBeat.i(119386);
      this.dED = paramString;
      this.Bjb = paramb;
      AppMethodBeat.o(119386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.b
 * JD-Core Version:    0.7.0.1
 */