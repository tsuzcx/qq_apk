package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.ui.view.gallery.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "isWaiting", "", "isWifi", "lastStoryId", "last_selectedColumn", "", "last_selectedRow", "markGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "markStoryId", "onClickTime", "onCreateTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStoryLauncherTime", "preLoadInfo", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "storyIdsState", "", "unReadList", "Ljava/util/ArrayList;", "withCache", "canPlay", "", "user", "storyId", "chatting", "clickScene", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkReport", "checkStayTime", "checkUnRead", "clean", "downloadEnd", "enter", "list", "", "finish", "initID", "markInit", "markResumeTime", "netSpeed", "speed", "onDestroy", "onSelectItem", "group", "selectedRow", "selectedColumn", "onVideoEnd", "onVideoPlay", "onVideoWaiting", "playUser", "preLoadVideo", "galleryItem", "extinfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "preloadWithCache", "report", "IID", "key", "mval", "startDownload", "isAll", "startHttp", "Info", "State", "plugin-story_release"})
public final class b
{
  public static long ARi;
  public static final Map<Long, a> ARj;
  public static a ARk;
  public static long ARl;
  private static long ARm;
  private static long ARn;
  public static h ARo;
  public static boolean ARp;
  public static long ARq;
  private static long ARr;
  private static long ARs;
  private static int ARt;
  private static int ARu;
  private static boolean ARv;
  private static ArrayList<String> ARw;
  public static final b ARx;
  private static boolean isWaiting;
  public static long pQX;
  public static boolean ruo;
  
  static
  {
    AppMethodBeat.i(119402);
    ARx = new b();
    pQX = 998L;
    ruo = true;
    Map localMap = Collections.synchronizedMap((Map)new HashMap());
    p.g(localMap, "Collections.synchronizedMap(HashMap<Long, Info>())");
    ARj = localMap;
    AppMethodBeat.o(119402);
  }
  
  public static void AK(long paramLong)
  {
    ARl = paramLong;
  }
  
  public static void AL(long paramLong)
  {
    AppMethodBeat.i(119398);
    if (!ARj.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(119398);
      return;
    }
    a locala = (a)ARj.get(Long.valueOf(paramLong));
    if ((locala != null) && (locala.zVg))
    {
      AppMethodBeat.o(119398);
      return;
    }
    if (paramLong == ARl)
    {
      locala = ARk;
      if (locala != null)
      {
        if (locala.ARC <= 0L)
        {
          AppMethodBeat.o(119398);
          return;
        }
        paramLong = bt.Df(locala.ARC);
        ad.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd1 ".concat(String.valueOf(paramLong)));
        if (locala.oKD)
        {
          e(pQX, 62L, 1L);
          e(pQX, 63L, paramLong);
        }
        e(pQX, 60L, 1L);
        e(pQX, 61L, paramLong);
        AppMethodBeat.o(119398);
        return;
      }
      AppMethodBeat.o(119398);
      return;
    }
    locala = (a)ARj.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      if (locala.ARC <= 0L)
      {
        AppMethodBeat.o(119398);
        return;
      }
      paramLong = bt.Df(locala.ARC);
      ad.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd2 ".concat(String.valueOf(paramLong)));
      if (locala.oKD)
      {
        e(pQX, 62L, 1L);
        e(pQX, 63L, paramLong);
      }
      e(pQX, 60L, 1L);
      e(pQX, 61L, paramLong);
      AppMethodBeat.o(119398);
      return;
    }
    AppMethodBeat.o(119398);
  }
  
  public static void F(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(119397);
    if (!ARj.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(119397);
      return;
    }
    a locala = (a)ARj.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.ARC = bt.flT();
      locala.oKD = paramBoolean;
      AppMethodBeat.o(119397);
      return;
    }
    AppMethodBeat.o(119397);
  }
  
  public static void So(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      pQX = 998L;
      return;
    }
    if (paramInt == 3)
    {
      pQX = 1006L;
      return;
    }
    pQX = -1L;
  }
  
  public static void Sp(int paramInt)
  {
    AppMethodBeat.i(119393);
    long l = bt.Df(ARs);
    ad.i("MicroMsg.StoryBrowseDetailIDKeyStat", "cur speed " + paramInt + " cur: " + l);
    if (l > 5000L)
    {
      if (paramInt < 10)
      {
        e(pQX, 82L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 100)
      {
        e(pQX, 83L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 200)
      {
        e(pQX, 89L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 250)
      {
        e(pQX, 84L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 450)
      {
        e(pQX, 85L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 900)
      {
        e(pQX, 86L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 1350)
      {
        e(pQX, 87L, 1L);
        AppMethodBeat.o(119393);
        return;
      }
      if (paramInt < 1800) {
        e(pQX, 88L, 1L);
      }
    }
    AppMethodBeat.o(119393);
  }
  
  public static boolean aKi()
  {
    if (ARs <= 0L) {}
    while (!ruo) {
      return false;
    }
    return true;
  }
  
  private static int c(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(119395);
    Object localObject = s.ALd;
    localObject = s.a(paramj);
    if (((n)localObject).elH())
    {
      ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay downloadFinish " + paramj.dKt);
      AppMethodBeat.o(119395);
      return 1;
    }
    if (((n)localObject).field_totalSize <= 0)
    {
      AppMethodBeat.o(119395);
      return 0;
    }
    float f = ((n)localObject).field_cacheSize / ((n)localObject).field_totalSize;
    paramj = m.Bfs;
    if (f * 100.0F >= m.emm().BdL)
    {
      ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay cachesize " + ((n)localObject).field_cacheSize + " totalSize: " + ((n)localObject).field_totalSize);
      AppMethodBeat.o(119395);
      return 1;
    }
    AppMethodBeat.o(119395);
    return 0;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(119391);
    ARm = 0L;
    ARn = 0L;
    ARs = 0L;
    ARv = false;
    ARt = -1;
    ARu = -1;
    ARq = 0L;
    ARr = 0L;
    ARj.clear();
    ARp = false;
    ARo = null;
    isWaiting = false;
    ARw = new ArrayList();
    ARk = null;
    AppMethodBeat.o(119391);
  }
  
  public static void d(ArrayList<ArrayList<h>> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119394);
    p.h(paramArrayList, "group");
    if (!aKi())
    {
      AppMethodBeat.o(119394);
      return;
    }
    ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", " last_selectedColumn:" + ARu + ",last_selectedRow:" + ARt + " selectedRow:" + paramInt1 + ",selectedColumn:" + paramInt2);
    int i;
    int j;
    if (paramArrayList.size() > 0) {
      if ((((ArrayList)paramArrayList.get(paramInt1)).size() > 0) && (paramInt2 + 1 < ((ArrayList)paramArrayList.get(paramInt1)).size()))
      {
        if (!ARv) {
          e(pQX, 101L, 1L);
        }
        i = 1;
        if (paramInt1 + 1 < paramArrayList.size())
        {
          if (!ARv) {
            e(pQX, 102L, 1L);
          }
          j = 1;
          label167:
          ARv = true;
        }
      }
    }
    for (;;)
    {
      if ((ARu != -1) && (ARt != -1))
      {
        if (isWaiting)
        {
          e(pQX, 100L, 1L);
          isWaiting = false;
        }
        if (paramInt1 != ARt)
        {
          if (i != 0) {
            e(pQX, 105L, 1L);
          }
          e(pQX, 106L, 1L);
          i = paramInt1 - ARt;
          if (i == 1)
          {
            e(pQX, 110L, 1L);
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
              com.tencent.mm.plugin.story.f.d.j localj = ((h)((ArrayList)paramArrayList.get(paramInt1 + i)).get(0)).AMA;
              if ((localj != null) && (localj.username != null) && (ARw != null))
              {
                ArrayList localArrayList = ARw;
                if ((localArrayList != null) && (localArrayList.contains(localj.username) == true))
                {
                  if (c(localj) == 1)
                  {
                    if (i != 0) {
                      break label460;
                    }
                    e(pQX, 120L, 1L);
                  }
                  label385:
                  if (i != 0) {
                    break label496;
                  }
                  e(pQX, 125L, 1L);
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
              e(pQX, 111L, 1L);
              break;
            }
            if (i == 3)
            {
              e(pQX, 112L, 1L);
              break;
            }
            if (i < 4) {
              break;
            }
            e(pQX, 113L, 1L);
            break;
            label460:
            if (i == 1)
            {
              e(pQX, 121L, 1L);
              break label385;
            }
            if (i != 2) {
              break label385;
            }
            e(pQX, 122L, 1L);
            break label385;
            label496:
            if (i == 1) {
              e(pQX, 126L, 1L);
            } else if (i == 2) {
              e(pQX, 127L, 1L);
            }
          }
        }
        else if (paramInt2 != ARu)
        {
          if (j != 0) {
            e(pQX, 103L, 1L);
          }
          e(pQX, 104L, 1L);
          i = paramInt2 - ARu;
          if (i != 1) {
            break label957;
          }
          e(pQX, 115L, 1L);
        }
      }
      for (;;)
      {
        label585:
        if ((ARt >= 0) && (ARt < paramArrayList.size()) && (ARu >= 0) && (ARu < ((ArrayList)paramArrayList.get(ARt)).size()) && ((ARu != paramInt2) || (ARt != paramInt1)))
        {
          long l = ((h)((ArrayList)paramArrayList.get(ARt)).get(ARu)).AMA.dKt;
          ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime storyId " + l + " lastStoryId " + ARi);
          if ((aKi()) && (ARj.containsKey(Long.valueOf(l))))
          {
            paramArrayList = (a)ARj.get(Long.valueOf(l));
            if ((paramArrayList != null) && (paramArrayList.ARy <= 0L) && (!paramArrayList.zVg) && (paramArrayList.ARz >= 0L))
            {
              paramArrayList.ARy = bt.Df(paramArrayList.ARz);
              ad.i("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime onStayTime " + l + ' ' + paramArrayList.ARy + " hasHttp:" + paramArrayList.ARB + "  isWaiting:" + paramArrayList.isWaiting);
              if (paramArrayList.ARB)
              {
                e(pQX, 21L, 1L);
                e(pQX, 20L, paramArrayList.ARy);
              }
              if (paramArrayList.isWaiting)
              {
                e(pQX, 23L, 1L);
                e(pQX, 22L, paramArrayList.ARy);
              }
              e(pQX, 25L, 1L);
              e(pQX, 24L, paramArrayList.ARy);
              if (paramArrayList.hhJ) {
                e(pQX, 26L, 1L);
              }
            }
          }
        }
        ARu = paramInt2;
        ARt = paramInt1;
        AppMethodBeat.o(119394);
        return;
        label957:
        if (i == 2) {
          e(pQX, 116L, 1L);
        } else if (i == 3) {
          e(pQX, 117L, 1L);
        } else if (i >= 4) {
          e(pQX, 118L, 1L);
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
    com.tencent.mm.plugin.report.service.g.yhR.n(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(119390);
  }
  
  public static void ejD()
  {
    ARp = true;
  }
  
  public static void ejE()
  {
    AppMethodBeat.i(119399);
    ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", "makeResumeTime onResumeTime " + ARm + " onPlayUser " + ARn);
    ARm = bt.flT();
    AppMethodBeat.o(119399);
  }
  
  public static void ejF()
  {
    AppMethodBeat.i(119401);
    ARs = bt.flT();
    AppMethodBeat.o(119401);
  }
  
  public static void gp(List<String> paramList)
  {
    AppMethodBeat.i(119392);
    p.h(paramList, "list");
    ArrayList localArrayList = new ArrayList();
    ARw = localArrayList;
    localArrayList.addAll((Collection)paramList);
    AppMethodBeat.o(119392);
  }
  
  public static void n(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(119400);
    p.h(paramString, "user");
    if (!aKi())
    {
      AppMethodBeat.o(119400);
      return;
    }
    if ((ARq > 0L) && (ARr <= 0L))
    {
      ARr = bt.Df(ARq);
      e(pQX, 130L, 1L);
      e(pQX, 131L, ARr);
    }
    ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser user " + paramString + " storyId " + paramLong + " selectedColumn " + paramInt + " lastStoryId:" + ARi + " onStoryLauncherTime " + ARr);
    int j = 0;
    int i = j;
    if (ARi != paramLong)
    {
      i = j;
      if (ARi != 0L) {
        i = 1;
      }
    }
    long l = ARi;
    ARi = paramLong;
    p.h(paramString, "user");
    Object localObject = ARw;
    if ((localObject != null) && (((ArrayList)localObject).contains(paramString) == true)) {}
    for (j = 1; j == 0; j = 0)
    {
      AppMethodBeat.o(119400);
      return;
    }
    if ((ARj.containsKey(Long.valueOf(l))) && (i != 0))
    {
      localObject = (a)ARj.get(Long.valueOf(l));
      if (localObject != null) {
        ((a)localObject).zVg = true;
      }
    }
    if (paramInt > 0)
    {
      AppMethodBeat.o(119400);
      return;
    }
    localObject = ARj;
    a locala = new a(paramString, b.b.ARF);
    locala.ARz = bt.flT();
    ((Map)localObject).put(Long.valueOf(paramLong), locala);
    ARn = bt.flT();
    ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser onResumeTime " + ARn);
    localObject = com.tencent.mm.plugin.story.f.j.AKb;
    localObject = j.b.ehU().aBD(paramString);
    ad.i("MicroMsg.StoryBrowseDetailIDKeyStat", "preLoadCache > 0 then " + paramString + " preload " + bt.sy(((f)localObject).elp()));
    e(pQX, 2L, 1L);
    if (((f)localObject).elp() > 0L) {
      e(pQX, 3L, 1L);
    }
    if (paramLong == ARl)
    {
      if (ARp)
      {
        e(pQX, 6L, 1L);
        if (((f)localObject).elp() > 0L)
        {
          if (!ARp) {
            break label545;
          }
          e(pQX, 7L, 1L);
        }
      }
      for (;;)
      {
        paramString = ARo;
        if (paramString == null) {
          break label575;
        }
        if (c(paramString.AMA) != 1) {
          break label568;
        }
        if (!ARp) {
          break label558;
        }
        e(pQX, 8L, 1L);
        AppMethodBeat.o(119400);
        return;
        e(pQX, 9L, 1L);
        break;
        label545:
        e(pQX, 10L, 1L);
      }
      label558:
      e(pQX, 11L, 1L);
      label568:
      AppMethodBeat.o(119400);
      return;
    }
    label575:
    AppMethodBeat.o(119400);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "", "user", "", "state", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "clean", "", "getClean", "()Z", "setClean", "(Z)V", "hasHttp", "getHasHttp", "setHasHttp", "isAll", "setAll", "isEnd", "setEnd", "isWaiting", "setWaiting", "onMarkPlayCall", "", "getOnMarkPlayCall", "()J", "setOnMarkPlayCall", "(J)V", "onMarkPlayingCall", "getOnMarkPlayingCall", "setOnMarkPlayingCall", "onStayTime", "getOnStayTime", "setOnStayTime", "startHttp", "getStartHttp", "setStartHttp", "getState", "()Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "setState", "(Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "getUser", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a
  {
    public long ARA;
    public boolean ARB;
    public long ARC;
    private b.b ARD;
    long ARy;
    public long ARz;
    private final String dDy;
    public boolean hhJ;
    public boolean isWaiting;
    public boolean oKD;
    public boolean zVg;
    
    public a(String paramString, b.b paramb)
    {
      AppMethodBeat.i(119386);
      this.dDy = paramString;
      this.ARD = paramb;
      AppMethodBeat.o(119386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.b
 * JD-Core Version:    0.7.0.1
 */