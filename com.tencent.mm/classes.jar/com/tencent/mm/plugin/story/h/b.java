package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.ui.view.gallery.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "isWaiting", "", "isWifi", "lastStoryId", "last_selectedColumn", "", "last_selectedRow", "markGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "markStoryId", "onClickTime", "onCreateTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStoryLauncherTime", "preLoadInfo", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "storyIdsState", "", "unReadList", "Ljava/util/ArrayList;", "withCache", "canPlay", "", "user", "storyId", "chatting", "clickScene", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkReport", "checkStayTime", "checkUnRead", "clean", "downloadEnd", "enter", "list", "", "finish", "initID", "markInit", "markResumeTime", "netSpeed", "speed", "onDestroy", "onSelectItem", "group", "selectedRow", "selectedColumn", "onVideoEnd", "onVideoPlay", "onVideoWaiting", "playUser", "preLoadVideo", "galleryItem", "extinfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "preloadWithCache", "report", "IID", "key", "mval", "startDownload", "isAll", "startHttp", "Info", "State", "plugin-story_release"})
public final class b
{
  private static boolean isWaiting;
  public static long pnx;
  public static boolean qKm;
  public static long zzJ;
  public static final Map<Long, a> zzK;
  public static a zzL;
  public static long zzM;
  private static long zzN;
  private static long zzO;
  public static com.tencent.mm.plugin.story.f.d.h zzP;
  public static boolean zzQ;
  public static long zzR;
  private static long zzS;
  private static long zzT;
  private static int zzU;
  private static int zzV;
  private static boolean zzW;
  private static ArrayList<String> zzX;
  public static final b zzY;
  
  static
  {
    AppMethodBeat.i(119402);
    zzY = new b();
    pnx = 998L;
    qKm = true;
    Map localMap = Collections.synchronizedMap((Map)new HashMap());
    k.g(localMap, "Collections.synchronizedMap(HashMap<Long, Info>())");
    zzK = localMap;
    AppMethodBeat.o(119402);
  }
  
  public static void F(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(119397);
    if (!zzK.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(119397);
      return;
    }
    a locala = (a)zzK.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.zAd = bs.eWj();
      locala.ohk = paramBoolean;
      AppMethodBeat.o(119397);
      return;
    }
    AppMethodBeat.o(119397);
  }
  
  public static void QF(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      pnx = 998L;
      return;
    }
    if (paramInt == 3)
    {
      pnx = 1006L;
      return;
    }
    pnx = -1L;
  }
  
  public static void QG(int paramInt)
  {
    AppMethodBeat.i(119393);
    long l = bs.Ap(zzT);
    ac.i("MicroMsg.StoryBrowseDetailIDKeyStat", "cur speed " + paramInt + " cur: " + l);
    if (l > 5000L)
    {
      if (paramInt < 10)
      {
        e(pnx, 82L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 100)
      {
        e(pnx, 83L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 200)
      {
        e(pnx, 89L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 250)
      {
        e(pnx, 84L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 450)
      {
        e(pnx, 85L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 900)
      {
        e(pnx, 86L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 1350)
      {
        e(pnx, 87L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 1800) {
        e(pnx, 88L, 1L);
      }
    }
    AppMethodBeat.o(119393);
  }
  
  public static boolean aGX()
  {
    if (zzT <= 0L) {}
    while (!qKm) {
      return false;
    }
    return true;
  }
  
  private static int c(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(119395);
    Object localObject = s.ztj;
    localObject = s.a(paramj);
    if (((n)localObject).dZs())
    {
      ac.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay downloadFinish " + paramj.dyg);
      AppMethodBeat.o(119395);
      return 1;
    }
    if (((n)localObject).field_totalSize <= 0)
    {
      AppMethodBeat.o(119395);
      return 0;
    }
    float f = ((n)localObject).field_cacheSize / ((n)localObject).field_totalSize;
    paramj = m.zNR;
    if (f * 100.0F >= m.dZX().zMk)
    {
      ac.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay cachesize " + ((n)localObject).field_cacheSize + " totalSize: " + ((n)localObject).field_totalSize);
      AppMethodBeat.o(119395);
      return 1;
    }
    AppMethodBeat.o(119395);
    return 0;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(119391);
    zzN = 0L;
    zzO = 0L;
    zzT = 0L;
    zzW = false;
    zzU = -1;
    zzV = -1;
    zzR = 0L;
    zzS = 0L;
    zzK.clear();
    zzQ = false;
    zzP = null;
    isWaiting = false;
    zzX = new ArrayList();
    zzL = null;
    AppMethodBeat.o(119391);
  }
  
  public static void d(ArrayList<ArrayList<com.tencent.mm.plugin.story.f.d.h>> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119394);
    k.h(paramArrayList, "group");
    if (!aGX())
    {
      AppMethodBeat.o(119394);
      return;
    }
    ac.v("MicroMsg.StoryBrowseDetailIDKeyStat", " last_selectedColumn:" + zzV + ",last_selectedRow:" + zzU + " selectedRow:" + paramInt1 + ",selectedColumn:" + paramInt2);
    int i;
    int j;
    if (paramArrayList.size() > 0) {
      if ((((ArrayList)paramArrayList.get(paramInt1)).size() > 0) && (paramInt2 + 1 < ((ArrayList)paramArrayList.get(paramInt1)).size()))
      {
        if (!zzW) {
          e(pnx, 101L, 1L);
        }
        i = 1;
        if (paramInt1 + 1 < paramArrayList.size())
        {
          if (!zzW) {
            e(pnx, 102L, 1L);
          }
          j = 1;
          label167:
          zzW = true;
        }
      }
    }
    for (;;)
    {
      if ((zzV != -1) && (zzU != -1))
      {
        if (isWaiting)
        {
          e(pnx, 100L, 1L);
          isWaiting = false;
        }
        if (paramInt1 != zzU)
        {
          if (i != 0) {
            e(pnx, 105L, 1L);
          }
          e(pnx, 106L, 1L);
          i = paramInt1 - zzU;
          if (i == 1)
          {
            e(pnx, 110L, 1L);
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
              com.tencent.mm.plugin.story.f.d.j localj = ((com.tencent.mm.plugin.story.f.d.h)((ArrayList)paramArrayList.get(paramInt1 + i)).get(0)).zuF;
              if ((localj != null) && (localj.username != null) && (zzX != null))
              {
                ArrayList localArrayList = zzX;
                if ((localArrayList != null) && (localArrayList.contains(localj.username) == true))
                {
                  if (c(localj) == 1)
                  {
                    if (i != 0) {
                      break label460;
                    }
                    e(pnx, 120L, 1L);
                  }
                  label385:
                  if (i != 0) {
                    break label496;
                  }
                  e(pnx, 125L, 1L);
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
              e(pnx, 111L, 1L);
              break;
            }
            if (i == 3)
            {
              e(pnx, 112L, 1L);
              break;
            }
            if (i < 4) {
              break;
            }
            e(pnx, 113L, 1L);
            break;
            label460:
            if (i == 1)
            {
              e(pnx, 121L, 1L);
              break label385;
            }
            if (i != 2) {
              break label385;
            }
            e(pnx, 122L, 1L);
            break label385;
            label496:
            if (i == 1) {
              e(pnx, 126L, 1L);
            } else if (i == 2) {
              e(pnx, 127L, 1L);
            }
          }
        }
        else if (paramInt2 != zzV)
        {
          if (j != 0) {
            e(pnx, 103L, 1L);
          }
          e(pnx, 104L, 1L);
          i = paramInt2 - zzV;
          if (i != 1) {
            break label957;
          }
          e(pnx, 115L, 1L);
        }
      }
      for (;;)
      {
        label585:
        if ((zzU >= 0) && (zzU < paramArrayList.size()) && (zzV >= 0) && (zzV < ((ArrayList)paramArrayList.get(zzU)).size()) && ((zzV != paramInt2) || (zzU != paramInt1)))
        {
          long l = ((com.tencent.mm.plugin.story.f.d.h)((ArrayList)paramArrayList.get(zzU)).get(zzV)).zuF.dyg;
          ac.v("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime storyId " + l + " lastStoryId " + zzJ);
          if ((aGX()) && (zzK.containsKey(Long.valueOf(l))))
          {
            paramArrayList = (a)zzK.get(Long.valueOf(l));
            if ((paramArrayList != null) && (paramArrayList.zzZ <= 0L) && (!paramArrayList.yDL) && (paramArrayList.zAa >= 0L))
            {
              paramArrayList.zzZ = bs.Ap(paramArrayList.zAa);
              ac.i("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime onStayTime " + l + ' ' + paramArrayList.zzZ + " hasHttp:" + paramArrayList.zAc + "  isWaiting:" + paramArrayList.isWaiting);
              if (paramArrayList.zAc)
              {
                e(pnx, 21L, 1L);
                e(pnx, 20L, paramArrayList.zzZ);
              }
              if (paramArrayList.isWaiting)
              {
                e(pnx, 23L, 1L);
                e(pnx, 22L, paramArrayList.zzZ);
              }
              e(pnx, 25L, 1L);
              e(pnx, 24L, paramArrayList.zzZ);
              if (paramArrayList.gNN) {
                e(pnx, 26L, 1L);
              }
            }
          }
        }
        zzV = paramInt2;
        zzU = paramInt1;
        AppMethodBeat.o(119394);
        return;
        label957:
        if (i == 2) {
          e(pnx, 116L, 1L);
        } else if (i == 3) {
          e(pnx, 117L, 1L);
        } else if (i >= 4) {
          e(pnx, 118L, 1L);
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
  
  public static void dXo()
  {
    zzQ = true;
  }
  
  public static void dXp()
  {
    AppMethodBeat.i(119399);
    ac.v("MicroMsg.StoryBrowseDetailIDKeyStat", "makeResumeTime onResumeTime " + zzN + " onPlayUser " + zzO);
    zzN = bs.eWj();
    AppMethodBeat.o(119399);
  }
  
  public static void dXq()
  {
    AppMethodBeat.i(119401);
    zzT = bs.eWj();
    AppMethodBeat.o(119401);
  }
  
  public static void e(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(119390);
    if (paramLong1 < 0L)
    {
      AppMethodBeat.o(119390);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.n(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(119390);
  }
  
  public static void ge(List<String> paramList)
  {
    AppMethodBeat.i(119392);
    k.h(paramList, "list");
    ArrayList localArrayList = new ArrayList();
    zzX = localArrayList;
    localArrayList.addAll((Collection)paramList);
    AppMethodBeat.o(119392);
  }
  
  public static void l(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(119400);
    k.h(paramString, "user");
    if (!aGX())
    {
      AppMethodBeat.o(119400);
      return;
    }
    if ((zzR > 0L) && (zzS <= 0L))
    {
      zzS = bs.Ap(zzR);
      e(pnx, 130L, 1L);
      e(pnx, 131L, zzS);
    }
    ac.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser user " + paramString + " storyId " + paramLong + " selectedColumn " + paramInt + " lastStoryId:" + zzJ + " onStoryLauncherTime " + zzS);
    int j = 0;
    int i = j;
    if (zzJ != paramLong)
    {
      i = j;
      if (zzJ != 0L) {
        i = 1;
      }
    }
    long l = zzJ;
    zzJ = paramLong;
    k.h(paramString, "user");
    Object localObject = zzX;
    if ((localObject != null) && (((ArrayList)localObject).contains(paramString) == true)) {}
    for (j = 1; j == 0; j = 0)
    {
      AppMethodBeat.o(119400);
      return;
    }
    if ((zzK.containsKey(Long.valueOf(l))) && (i != 0))
    {
      localObject = (a)zzK.get(Long.valueOf(l));
      if (localObject != null) {
        ((a)localObject).yDL = true;
      }
    }
    if (paramInt > 0)
    {
      AppMethodBeat.o(119400);
      return;
    }
    localObject = zzK;
    a locala = new a(paramString, b.b.zAg);
    locala.zAa = bs.eWj();
    ((Map)localObject).put(Long.valueOf(paramLong), locala);
    zzO = bs.eWj();
    ac.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser onResumeTime " + zzO);
    localObject = com.tencent.mm.plugin.story.f.j.zsh;
    localObject = j.b.dVF().awy(paramString);
    ac.i("MicroMsg.StoryBrowseDetailIDKeyStat", "preLoadCache > 0 then " + paramString + " preload " + bs.qz(((f)localObject).dZa()));
    e(pnx, 2L, 1L);
    if (((f)localObject).dZa() > 0L) {
      e(pnx, 3L, 1L);
    }
    if (paramLong == zzM)
    {
      if (zzQ)
      {
        e(pnx, 6L, 1L);
        if (((f)localObject).dZa() > 0L)
        {
          if (!zzQ) {
            break label545;
          }
          e(pnx, 7L, 1L);
        }
      }
      for (;;)
      {
        paramString = zzP;
        if (paramString == null) {
          break label575;
        }
        if (c(paramString.zuF) != 1) {
          break label568;
        }
        if (!zzQ) {
          break label558;
        }
        e(pnx, 8L, 1L);
        AppMethodBeat.o(119400);
        return;
        e(pnx, 9L, 1L);
        break;
        label545:
        e(pnx, 10L, 1L);
      }
      label558:
      e(pnx, 11L, 1L);
      label568:
      AppMethodBeat.o(119400);
      return;
    }
    label575:
    AppMethodBeat.o(119400);
  }
  
  public static void ym(long paramLong)
  {
    zzM = paramLong;
  }
  
  public static void yn(long paramLong)
  {
    AppMethodBeat.i(119398);
    if (!zzK.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(119398);
      return;
    }
    a locala = (a)zzK.get(Long.valueOf(paramLong));
    if ((locala != null) && (locala.yDL))
    {
      AppMethodBeat.o(119398);
      return;
    }
    if (paramLong == zzM)
    {
      locala = zzL;
      if (locala != null)
      {
        if (locala.zAd <= 0L)
        {
          AppMethodBeat.o(119398);
          return;
        }
        paramLong = bs.Ap(locala.zAd);
        ac.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd1 ".concat(String.valueOf(paramLong)));
        if (locala.ohk)
        {
          e(pnx, 62L, 1L);
          e(pnx, 63L, paramLong);
        }
        e(pnx, 60L, 1L);
        e(pnx, 61L, paramLong);
        AppMethodBeat.o(119398);
        return;
      }
      AppMethodBeat.o(119398);
      return;
    }
    locala = (a)zzK.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      if (locala.zAd <= 0L)
      {
        AppMethodBeat.o(119398);
        return;
      }
      paramLong = bs.Ap(locala.zAd);
      ac.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd2 ".concat(String.valueOf(paramLong)));
      if (locala.ohk)
      {
        e(pnx, 62L, 1L);
        e(pnx, 63L, paramLong);
      }
      e(pnx, 60L, 1L);
      e(pnx, 61L, paramLong);
      AppMethodBeat.o(119398);
      return;
    }
    AppMethodBeat.o(119398);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "", "user", "", "state", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "clean", "", "getClean", "()Z", "setClean", "(Z)V", "hasHttp", "getHasHttp", "setHasHttp", "isAll", "setAll", "isEnd", "setEnd", "isWaiting", "setWaiting", "onMarkPlayCall", "", "getOnMarkPlayCall", "()J", "setOnMarkPlayCall", "(J)V", "onMarkPlayingCall", "getOnMarkPlayingCall", "setOnMarkPlayingCall", "onStayTime", "getOnStayTime", "setOnStayTime", "startHttp", "getStartHttp", "setStartHttp", "getState", "()Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "setState", "(Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "getUser", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a
  {
    private final String drG;
    public boolean gNN;
    public boolean isWaiting;
    public boolean ohk;
    public boolean yDL;
    public long zAa;
    public long zAb;
    public boolean zAc;
    public long zAd;
    private b.b zAe;
    long zzZ;
    
    public a(String paramString, b.b paramb)
    {
      AppMethodBeat.i(119386);
      this.drG = paramString;
      this.zAe = paramb;
      AppMethodBeat.o(119386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.b
 * JD-Core Version:    0.7.0.1
 */