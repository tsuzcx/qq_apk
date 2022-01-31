package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.plugin.story.ui.view.gallery.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "isWaiting", "", "isWifi", "lastStoryId", "last_selectedColumn", "", "last_selectedRow", "markGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "markStoryId", "onClickTime", "onCreateTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStoryLauncherTime", "preLoadInfo", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "storyIdsState", "", "unReadList", "Ljava/util/ArrayList;", "withCache", "canPlay", "", "user", "storyId", "chatting", "clickScene", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkReport", "checkStayTime", "checkUnRead", "clean", "downloadEnd", "enter", "list", "", "finish", "initID", "markInit", "markResumeTime", "netSpeed", "speed", "onDestroy", "onSelectItem", "group", "selectedRow", "selectedColumn", "onVideoEnd", "onVideoPlay", "onVideoWaiting", "playUser", "preLoadVideo", "galleryItem", "extinfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "preloadWithCache", "report", "IID", "key", "mval", "startDownload", "isAll", "startHttp", "Info", "State", "plugin-story_release"})
public final class b
{
  private static boolean isWaiting;
  public static long ltw;
  public static boolean muY;
  public static long sDC;
  public static final Map<Long, b.a> sDD;
  public static b.a sDE;
  public static long sDF;
  private static long sDG;
  private static long sDH;
  public static com.tencent.mm.plugin.story.model.d.g sDI;
  public static boolean sDJ;
  public static long sDK;
  private static long sDL;
  private static long sDM;
  private static int sDN;
  private static int sDO;
  private static boolean sDP;
  private static ArrayList<String> sDQ;
  public static final b sDR;
  
  static
  {
    AppMethodBeat.i(109780);
    sDR = new b();
    ltw = 998L;
    muY = true;
    Map localMap = Collections.synchronizedMap((Map)new HashMap());
    a.f.b.j.p(localMap, "Collections.synchronizedMap(HashMap<Long, Info>())");
    sDD = localMap;
    AppMethodBeat.o(109780);
  }
  
  public static void A(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(109775);
    if (!sDD.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(109775);
      return;
    }
    b.a locala = (b.a)sDD.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.sDW = bo.aoy();
      locala.kyS = paramBoolean;
      AppMethodBeat.o(109775);
      return;
    }
    AppMethodBeat.o(109775);
  }
  
  public static void FS(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      ltw = 998L;
      return;
    }
    if (paramInt == 3)
    {
      ltw = 1006L;
      return;
    }
    ltw = -1L;
  }
  
  public static void FT(int paramInt)
  {
    AppMethodBeat.i(109771);
    long l = bo.hl(sDM);
    ab.i("MicroMsg.StoryBrowseDetailIDKeyStat", "cur speed " + paramInt + " cur: " + l);
    if (l > 5000L)
    {
      if (paramInt < 10)
      {
        k(ltw, 82L, 1L);
        AppMethodBeat.o(109771);
        return;
      }
      if (paramInt < 100)
      {
        k(ltw, 83L, 1L);
        AppMethodBeat.o(109771);
        return;
      }
      if (paramInt < 200)
      {
        k(ltw, 89L, 1L);
        AppMethodBeat.o(109771);
        return;
      }
      if (paramInt < 250)
      {
        k(ltw, 84L, 1L);
        AppMethodBeat.o(109771);
        return;
      }
      if (paramInt < 450)
      {
        k(ltw, 85L, 1L);
        AppMethodBeat.o(109771);
        return;
      }
      if (paramInt < 900)
      {
        k(ltw, 86L, 1L);
        AppMethodBeat.o(109771);
        return;
      }
      if (paramInt < 1350)
      {
        k(ltw, 87L, 1L);
        AppMethodBeat.o(109771);
        return;
      }
      if (paramInt < 1800) {
        k(ltw, 88L, 1L);
      }
    }
    AppMethodBeat.o(109771);
  }
  
  public static boolean aiY()
  {
    if (sDM <= 0L) {}
    while (!muY) {
      return false;
    }
    return true;
  }
  
  private static int b(i parami)
  {
    AppMethodBeat.i(109773);
    Object localObject = s.swk;
    localObject = s.a(parami);
    if (((n)localObject).cFk())
    {
      ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay downloadFinish " + parami.cJA);
      AppMethodBeat.o(109773);
      return 1;
    }
    if (((n)localObject).field_totalSize <= 0)
    {
      AppMethodBeat.o(109773);
      return 0;
    }
    float f = ((n)localObject).field_cacheSize / ((n)localObject).field_totalSize;
    parami = p.sUH;
    if (f * 100.0F >= p.cGg().sTc)
    {
      ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay cachesize " + ((n)localObject).field_cacheSize + " totalSize: " + ((n)localObject).field_totalSize);
      AppMethodBeat.o(109773);
      return 1;
    }
    AppMethodBeat.o(109773);
    return 0;
  }
  
  public static void b(ArrayList<ArrayList<com.tencent.mm.plugin.story.model.d.g>> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109772);
    a.f.b.j.q(paramArrayList, "group");
    if (!aiY())
    {
      AppMethodBeat.o(109772);
      return;
    }
    ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", " last_selectedColumn:" + sDO + ",last_selectedRow:" + sDN + " selectedRow:" + paramInt1 + ",selectedColumn:" + paramInt2);
    int i;
    int j;
    if (paramArrayList.size() > 0) {
      if ((((ArrayList)paramArrayList.get(paramInt1)).size() > 0) && (paramInt2 + 1 < ((ArrayList)paramArrayList.get(paramInt1)).size()))
      {
        if (!sDP) {
          k(ltw, 101L, 1L);
        }
        i = 1;
        if (paramInt1 + 1 < paramArrayList.size())
        {
          if (!sDP) {
            k(ltw, 102L, 1L);
          }
          j = 1;
          label167:
          sDP = true;
        }
      }
    }
    for (;;)
    {
      if ((sDO != -1) && (sDN != -1))
      {
        if (isWaiting)
        {
          k(ltw, 100L, 1L);
          isWaiting = false;
        }
        if (paramInt1 != sDN)
        {
          if (i != 0) {
            k(ltw, 105L, 1L);
          }
          k(ltw, 106L, 1L);
          i = paramInt1 - sDN;
          if (i == 1)
          {
            k(ltw, 110L, 1L);
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
              i locali = ((com.tencent.mm.plugin.story.model.d.g)((ArrayList)paramArrayList.get(paramInt1 + i)).get(0)).syr;
              if ((locali != null) && (locali.username != null) && (sDQ != null))
              {
                ArrayList localArrayList = sDQ;
                if ((localArrayList != null) && (localArrayList.contains(locali.username) == true))
                {
                  if (b(locali) == 1)
                  {
                    if (i != 0) {
                      break label460;
                    }
                    k(ltw, 120L, 1L);
                  }
                  label385:
                  if (i != 0) {
                    break label496;
                  }
                  k(ltw, 125L, 1L);
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
              k(ltw, 111L, 1L);
              break;
            }
            if (i == 3)
            {
              k(ltw, 112L, 1L);
              break;
            }
            if (i < 4) {
              break;
            }
            k(ltw, 113L, 1L);
            break;
            label460:
            if (i == 1)
            {
              k(ltw, 121L, 1L);
              break label385;
            }
            if (i != 2) {
              break label385;
            }
            k(ltw, 122L, 1L);
            break label385;
            label496:
            if (i == 1) {
              k(ltw, 126L, 1L);
            } else if (i == 2) {
              k(ltw, 127L, 1L);
            }
          }
        }
        else if (paramInt2 != sDO)
        {
          if (j != 0) {
            k(ltw, 103L, 1L);
          }
          k(ltw, 104L, 1L);
          i = paramInt2 - sDO;
          if (i != 1) {
            break label957;
          }
          k(ltw, 115L, 1L);
        }
      }
      for (;;)
      {
        label585:
        if ((sDN >= 0) && (sDN < paramArrayList.size()) && (sDO >= 0) && (sDO < ((ArrayList)paramArrayList.get(sDN)).size()) && ((sDO != paramInt2) || (sDN != paramInt1)))
        {
          long l = ((com.tencent.mm.plugin.story.model.d.g)((ArrayList)paramArrayList.get(sDN)).get(sDO)).syr.cJA;
          ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime storyId " + l + " lastStoryId " + sDC);
          if ((aiY()) && (sDD.containsKey(Long.valueOf(l))))
          {
            paramArrayList = (b.a)sDD.get(Long.valueOf(l));
            if ((paramArrayList != null) && (paramArrayList.sDS <= 0L) && (!paramArrayList.rKr) && (paramArrayList.sDT >= 0L))
            {
              paramArrayList.sDS = bo.hl(paramArrayList.sDT);
              ab.i("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime onStayTime " + l + ' ' + paramArrayList.sDS + " hasHttp:" + paramArrayList.sDV + "  isWaiting:" + paramArrayList.isWaiting);
              if (paramArrayList.sDV)
              {
                k(ltw, 21L, 1L);
                k(ltw, 20L, paramArrayList.sDS);
              }
              if (paramArrayList.isWaiting)
              {
                k(ltw, 23L, 1L);
                k(ltw, 22L, paramArrayList.sDS);
              }
              k(ltw, 25L, 1L);
              k(ltw, 24L, paramArrayList.sDS);
              if (paramArrayList.eRq) {
                k(ltw, 26L, 1L);
              }
            }
          }
        }
        sDO = paramInt2;
        sDN = paramInt1;
        AppMethodBeat.o(109772);
        return;
        label957:
        if (i == 2) {
          k(ltw, 116L, 1L);
        } else if (i == 3) {
          k(ltw, 117L, 1L);
        } else if (i >= 4) {
          k(ltw, 118L, 1L);
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
  
  public static void cCA()
  {
    sDJ = true;
  }
  
  public static void cCB()
  {
    AppMethodBeat.i(109777);
    ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", "makeResumeTime onResumeTime " + sDG + " onPlayUser " + sDH);
    sDG = bo.aoy();
    AppMethodBeat.o(109777);
  }
  
  public static void cCC()
  {
    AppMethodBeat.i(109779);
    sDM = bo.aoy();
    AppMethodBeat.o(109779);
  }
  
  public static void clean()
  {
    AppMethodBeat.i(109769);
    sDG = 0L;
    sDH = 0L;
    sDM = 0L;
    sDP = false;
    sDN = -1;
    sDO = -1;
    sDK = 0L;
    sDL = 0L;
    sDD.clear();
    sDJ = false;
    sDI = null;
    isWaiting = false;
    sDQ = new ArrayList();
    sDE = null;
    AppMethodBeat.o(109769);
  }
  
  public static void dE(List<String> paramList)
  {
    AppMethodBeat.i(109770);
    a.f.b.j.q(paramList, "list");
    ArrayList localArrayList = new ArrayList();
    sDQ = localArrayList;
    localArrayList.addAll((Collection)paramList);
    AppMethodBeat.o(109770);
  }
  
  public static void k(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(109768);
    if (paramLong1 < 0L)
    {
      AppMethodBeat.o(109768);
      return;
    }
    h.qsU.j(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(109768);
  }
  
  public static void k(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(109778);
    a.f.b.j.q(paramString, "user");
    if (!aiY())
    {
      AppMethodBeat.o(109778);
      return;
    }
    if ((sDK > 0L) && (sDL <= 0L))
    {
      sDL = bo.hl(sDK);
      k(ltw, 130L, 1L);
      k(ltw, 131L, sDL);
    }
    ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser user " + paramString + " storyId " + paramLong + " selectedColumn " + paramInt + " lastStoryId:" + sDC + " onStoryLauncherTime " + sDL);
    int j = 0;
    int i = j;
    if (sDC != paramLong)
    {
      i = j;
      if (sDC != 0L) {
        i = 1;
      }
    }
    long l = sDC;
    sDC = paramLong;
    a.f.b.j.q(paramString, "user");
    Object localObject = sDQ;
    if ((localObject != null) && (((ArrayList)localObject).contains(paramString) == true)) {}
    for (j = 1; j == 0; j = 0)
    {
      AppMethodBeat.o(109778);
      return;
    }
    if ((sDD.containsKey(Long.valueOf(l))) && (i != 0))
    {
      localObject = (b.a)sDD.get(Long.valueOf(l));
      if (localObject != null) {
        ((b.a)localObject).rKr = true;
      }
    }
    if (paramInt > 0)
    {
      AppMethodBeat.o(109778);
      return;
    }
    localObject = sDD;
    b.a locala = new b.a(paramString, b.b.sDZ);
    locala.sDT = bo.aoy();
    ((Map)localObject).put(Long.valueOf(paramLong), locala);
    sDH = bo.aoy();
    ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser onResumeTime " + sDH);
    localObject = com.tencent.mm.plugin.story.model.j.svi;
    localObject = j.b.cAC().acU(paramString);
    ab.i("MicroMsg.StoryBrowseDetailIDKeyStat", "preLoadCache > 0 then " + paramString + " preload " + bo.hk(((f)localObject).cES()));
    k(ltw, 2L, 1L);
    if (((f)localObject).cES() > 0L) {
      k(ltw, 3L, 1L);
    }
    if (paramLong == sDF)
    {
      if (sDJ)
      {
        k(ltw, 6L, 1L);
        if (((f)localObject).cES() > 0L)
        {
          if (!sDJ) {
            break label545;
          }
          k(ltw, 7L, 1L);
        }
      }
      for (;;)
      {
        paramString = sDI;
        if (paramString == null) {
          break label575;
        }
        if (b(paramString.syr) != 1) {
          break label568;
        }
        if (!sDJ) {
          break label558;
        }
        k(ltw, 8L, 1L);
        AppMethodBeat.o(109778);
        return;
        k(ltw, 9L, 1L);
        break;
        label545:
        k(ltw, 10L, 1L);
      }
      label558:
      k(ltw, 11L, 1L);
      label568:
      AppMethodBeat.o(109778);
      return;
    }
    label575:
    AppMethodBeat.o(109778);
  }
  
  public static void mG(long paramLong)
  {
    sDF = paramLong;
  }
  
  public static void mH(long paramLong)
  {
    AppMethodBeat.i(109776);
    if (!sDD.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(109776);
      return;
    }
    b.a locala = (b.a)sDD.get(Long.valueOf(paramLong));
    if ((locala != null) && (locala.rKr))
    {
      AppMethodBeat.o(109776);
      return;
    }
    if (paramLong == sDF)
    {
      locala = sDE;
      if (locala != null)
      {
        if (locala.sDW <= 0L)
        {
          AppMethodBeat.o(109776);
          return;
        }
        paramLong = bo.hl(locala.sDW);
        ab.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd1 ".concat(String.valueOf(paramLong)));
        if (locala.kyS)
        {
          k(ltw, 62L, 1L);
          k(ltw, 63L, paramLong);
        }
        k(ltw, 60L, 1L);
        k(ltw, 61L, paramLong);
        AppMethodBeat.o(109776);
        return;
      }
      AppMethodBeat.o(109776);
      return;
    }
    locala = (b.a)sDD.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      if (locala.sDW <= 0L)
      {
        AppMethodBeat.o(109776);
        return;
      }
      paramLong = bo.hl(locala.sDW);
      ab.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd2 ".concat(String.valueOf(paramLong)));
      if (locala.kyS)
      {
        k(ltw, 62L, 1L);
        k(ltw, 63L, paramLong);
      }
      k(ltw, 60L, 1L);
      k(ltw, 61L, paramLong);
      AppMethodBeat.o(109776);
      return;
    }
    AppMethodBeat.o(109776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.b
 * JD-Core Version:    0.7.0.1
 */