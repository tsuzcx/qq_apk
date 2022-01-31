package com.tencent.mm.plugin.story.g;

import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.plugin.story.ui.view.gallery.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat;", "", "()V", "ID", "", "TAG", "", "canReport", "", "currentUser", "Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "enterFromDoubleClick", "enterWithCache", "hasStartHttp", "hascanPlayCall", "isWaiting", "last_selectedColumn", "", "last_selectedRow", "markStoryId", "noCachecurrentUser", "onCreateTime", "onPlayCostTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStayTime", "onVideoPlay", "unReadList", "", "canPlay", "", "user", "storyId", "chattingDoubleCheck", "chattingDoubleCheckHasCache", "chattingDoubleCheckNoCache", "chattingRight", "chattingRightHasCache", "chattingRightNoCache", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkStayTime", "clean", "enter", "unreadList", "finish", "markInit", "markResumeTime", "onDestroy", "onSelectItem", "group", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "selectedRow", "selectedColumn", "onVideoWaiting", "playUser", "preLoadVideo", "startHttp", "CurrentPlayer", "plugin-story_release"})
public final class c
{
  private static boolean eBr;
  private static boolean isWaiting;
  private static long sDF;
  private static long sDG;
  private static long sDH;
  private static long sDM;
  private static int sDN;
  private static int sDO;
  private static boolean sDP;
  private static long sDS;
  public static c.a sEc;
  private static c.a sEd;
  private static boolean sEe;
  private static long sEf;
  private static boolean sEg;
  public static boolean sEh;
  private static long sEi;
  private static boolean sEj;
  private static List<String> sEk;
  public static final c sEl;
  
  static
  {
    AppMethodBeat.i(109796);
    sEl = new c();
    AppMethodBeat.o(109796);
  }
  
  public static void aH(String paramString, long paramLong)
  {
    AppMethodBeat.i(109794);
    a.f.b.j.q(paramString, "user");
    if (sDM <= 0L)
    {
      AppMethodBeat.o(109794);
      return;
    }
    if (sDF != paramLong)
    {
      sDF = 0L;
      ab.i("MicroMsg.StoryBrowseIDKeyStat", "reset storyId markStoryId: " + sDF + " storyId " + paramLong);
      AppMethodBeat.o(109794);
      return;
    }
    sDH = bo.aoy();
    ab.v("MicroMsg.StoryBrowseIDKeyStat", "playUser onResumeTime " + sDH);
    c.a locala = sEd;
    if ((locala != null) && (a.f.b.j.e(locala.cDt, paramString)))
    {
      Object localObject = com.tencent.mm.plugin.story.model.j.svi;
      localObject = j.b.cAC().acU(paramString);
      ab.i("MicroMsg.StoryBrowseIDKeyStat", "preLoadCache > 0 then " + paramString + " preload " + bo.hk(((f)localObject).cES()) + " canPlay: " + sEg);
      if (((f)localObject).cES() > 0L)
      {
        if (locala.scene != 1) {
          break label249;
        }
        h.qsU.j(988L, 21L, 1L);
        if (sEg) {
          h.qsU.j(988L, 27L, 1L);
        }
      }
    }
    for (;;)
    {
      sEc = null;
      sEd = null;
      AppMethodBeat.o(109794);
      return;
      label249:
      if (locala.scene == 2)
      {
        h.qsU.j(988L, 22L, 1L);
        if (sEg) {
          h.qsU.j(988L, 28L, 1L);
        }
      }
    }
  }
  
  public static void ads(String paramString)
  {
    AppMethodBeat.i(109786);
    a.f.b.j.q(paramString, "user");
    ab.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightNoCache ".concat(String.valueOf(paramString)));
    sEe = false;
    sEd = new c.a(paramString, 1);
    h.qsU.j(988L, 15L, 1L);
    AppMethodBeat.o(109786);
  }
  
  public static void adt(String paramString)
  {
    AppMethodBeat.i(109787);
    a.f.b.j.q(paramString, "user");
    ab.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckNoCache ".concat(String.valueOf(paramString)));
    sEe = false;
    sEd = new c.a(paramString, 2);
    h.qsU.j(988L, 16L, 1L);
    AppMethodBeat.o(109787);
  }
  
  public static void b(ArrayList<ArrayList<com.tencent.mm.plugin.story.model.d.g>> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109789);
    a.f.b.j.q(paramArrayList, "group");
    if (sDM <= 0L)
    {
      AppMethodBeat.o(109789);
      return;
    }
    ab.v("MicroMsg.StoryBrowseIDKeyStat", " last_selectedColumn:" + sDO + ",last_selectedRow:" + sDN + " selectedRow:" + paramInt1 + ",selectedColumn:" + paramInt2);
    int i;
    int j;
    if (paramArrayList.size() > 0) {
      if ((((ArrayList)paramArrayList.get(paramInt1)).size() > 0) && (paramInt2 + 1 < ((ArrayList)paramArrayList.get(paramInt1)).size()))
      {
        if (!sDP) {
          h.qsU.j(988L, 42L, 1L);
        }
        i = 1;
        if (paramInt1 + 1 < paramArrayList.size())
        {
          if (!sDP) {
            h.qsU.j(988L, 43L, 1L);
          }
          j = 1;
          label176:
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
          h.qsU.j(988L, 40L, 1L);
          isWaiting = false;
        }
        if (paramInt1 != sDN)
        {
          if (i != 0) {
            h.qsU.j(988L, 46L, 1L);
          }
          h.qsU.j(988L, 47L, 1L);
          i = paramInt1 - sDN;
          if (i == 1)
          {
            h.qsU.j(988L, 90L, 1L);
            if (paramArrayList.size() <= 0) {
              break label734;
            }
            i = 0;
            label291:
            if (i >= 3) {
              break label734;
            }
            if ((paramInt1 + i < paramArrayList.size()) && (((ArrayList)paramArrayList.get(paramInt1 + i)).size() > 0))
            {
              Object localObject1 = ((com.tencent.mm.plugin.story.model.d.g)((ArrayList)paramArrayList.get(paramInt1 + i)).get(0)).syr;
              if ((localObject1 != null) && (((i)localObject1).username != null) && (sEk != null))
              {
                Object localObject2 = sEk;
                if ((localObject2 != null) && (((List)localObject2).contains(((i)localObject1).username) == true))
                {
                  localObject2 = s.swk;
                  localObject1 = s.a((i)localObject1);
                  if (!((n)localObject1).cFk())
                  {
                    if (((n)localObject1).field_totalSize <= 0) {
                      break label576;
                    }
                    float f = ((n)localObject1).field_cacheSize / ((n)localObject1).field_totalSize;
                    localObject1 = p.sUH;
                    if (f * 100.0F < p.cGg().sTc) {
                      break label576;
                    }
                  }
                  j = 1;
                  label459:
                  if (j == 1)
                  {
                    if (i != 0) {
                      break label582;
                    }
                    h.qsU.j(988L, 80L, 1L);
                  }
                  label483:
                  if (i != 0) {
                    break label626;
                  }
                  h.qsU.j(988L, 84L, 1L);
                }
              }
            }
          }
          for (;;)
          {
            i += 1;
            break label291;
            if (i == 2)
            {
              h.qsU.j(988L, 91L, 1L);
              break;
            }
            if (i == 3)
            {
              h.qsU.j(988L, 92L, 1L);
              break;
            }
            if (i < 4) {
              break;
            }
            h.qsU.j(988L, 93L, 1L);
            break;
            label576:
            j = 0;
            break label459;
            label582:
            if (i == 1)
            {
              h.qsU.j(988L, 81L, 1L);
              break label483;
            }
            if (i != 2) {
              break label483;
            }
            h.qsU.j(988L, 82L, 1L);
            break label483;
            label626:
            if (i == 1) {
              h.qsU.j(988L, 85L, 1L);
            } else if (i == 2) {
              h.qsU.j(988L, 86L, 1L);
            }
          }
        }
        else if (paramInt2 != sDO)
        {
          if (j != 0) {
            h.qsU.j(988L, 44L, 1L);
          }
          h.qsU.j(988L, 45L, 1L);
          i = paramInt2 - sDO;
          if (i != 1) {
            break label752;
          }
          h.qsU.j(988L, 94L, 1L);
        }
      }
      for (;;)
      {
        label734:
        cCF();
        sDO = paramInt2;
        sDN = paramInt1;
        AppMethodBeat.o(109789);
        return;
        label752:
        if (i == 2) {
          h.qsU.j(988L, 95L, 1L);
        } else if (i == 3) {
          h.qsU.j(988L, 96L, 1L);
        } else if (i >= 4) {
          h.qsU.j(988L, 97L, 1L);
        }
      }
      j = 0;
      break label176;
      i = 0;
      break;
      j = 0;
      i = 0;
    }
  }
  
  public static void cCB()
  {
    AppMethodBeat.i(109793);
    ab.v("MicroMsg.StoryBrowseIDKeyStat", "makeResumeTime onResumeTime " + sDG + " onPlayUser " + sDH);
    sDG = bo.aoy();
    AppMethodBeat.o(109793);
  }
  
  public static void cCC()
  {
    AppMethodBeat.i(109795);
    sDM = bo.aoy();
    AppMethodBeat.o(109795);
  }
  
  public static void cCD()
  {
    AppMethodBeat.i(109784);
    ab.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightHasCache");
    sEe = true;
    h.qsU.j(988L, 11L, 1L);
    AppMethodBeat.o(109784);
  }
  
  public static void cCE()
  {
    AppMethodBeat.i(109785);
    ab.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckHasCache");
    sEe = true;
    h.qsU.j(988L, 12L, 1L);
    AppMethodBeat.o(109785);
  }
  
  private static void cCF()
  {
    AppMethodBeat.i(109790);
    ab.v("MicroMsg.StoryBrowseIDKeyStat", "checkStayTime1 onStayTime " + sDS + " hasStartHttp " + sEj + " onPlayCostTime: " + sEf);
    if ((sDS == 0L) && (sEj))
    {
      if (sEf == 0L)
      {
        sDS = bo.hl(sDG);
        h.qsU.j(988L, 63L, 1L);
        h.qsU.j(988L, 62L, sDS);
        AppMethodBeat.o(109790);
        return;
      }
      sDS = bo.hl(sEi);
      h.qsU.j(988L, 61L, 1L);
      h.qsU.j(988L, 60L, sDS);
    }
    AppMethodBeat.o(109790);
  }
  
  public static void cCG()
  {
    AppMethodBeat.i(109792);
    if (sDM <= 0L)
    {
      AppMethodBeat.o(109792);
      return;
    }
    ab.i("MicroMsg.StoryBrowseIDKeyStat", "startHttp");
    sEj = true;
    AppMethodBeat.o(109792);
  }
  
  public static void clean()
  {
    AppMethodBeat.i(109782);
    sEh = false;
    eBr = true;
    sDG = 0L;
    sEg = false;
    sEf = 0L;
    sDH = 0L;
    sDM = 0L;
    sDP = false;
    sDN = -1;
    sDO = -1;
    sDS = 0L;
    sEj = false;
    isWaiting = false;
    sEk = (List)new ArrayList();
    sEc = new c.a("", 1);
    AppMethodBeat.o(109782);
  }
  
  public static void dE(List<String> paramList)
  {
    AppMethodBeat.i(109783);
    a.f.b.j.q(paramList, "unreadList");
    sEk = paramList;
    AppMethodBeat.o(109783);
  }
  
  public static void mG(long paramLong)
  {
    sDF = paramLong;
  }
  
  public static void mI(long paramLong)
  {
    if (sDM <= 0L) {}
    while ((paramLong == 0L) || (paramLong != sDF) || (sEf > 0L) || (sDG <= 0L)) {
      return;
    }
    isWaiting = true;
  }
  
  public static void mJ(long paramLong)
  {
    AppMethodBeat.i(109788);
    if (sDM <= 0L)
    {
      AppMethodBeat.o(109788);
      return;
    }
    sEg = true;
    if (sEf <= 0L) {
      ab.v("MicroMsg.StoryBrowseIDKeyStat", "storyId  " + paramLong + " markStoryId " + sDF + " onPlayCostTime " + sEf + " onResumeTime " + sDG + "  onPlayUser " + sDH);
    }
    if ((paramLong != 0L) && (paramLong == sDF) && (sEf <= 0L) && (sDG > 0L))
    {
      sEf = bo.hl(sDG);
      sEi = bo.aoy();
      ab.i("MicroMsg.StoryBrowseIDKeyStat", "canPlay " + sEf);
      isWaiting = false;
      if (sEh) {
        if (sEe)
        {
          h.qsU.j(988L, 32L, sEf);
          h.qsU.j(988L, 33L, 1L);
        }
      }
      for (;;)
      {
        h.qsU.j(988L, 71L, sEf);
        h.qsU.j(988L, 70L, 1L);
        if ((NetStatusUtil.isWifi(ah.getContext())) || (NetStatusUtil.is4G(ah.getContext())))
        {
          h.qsU.j(988L, 73L, sEf);
          h.qsU.j(988L, 72L, 1L);
        }
        if (sEf > 400L) {
          break;
        }
        h.qsU.j(988L, 100L, sEf);
        AppMethodBeat.o(109788);
        return;
        h.qsU.j(988L, 36L, sEf);
        h.qsU.j(988L, 37L, 1L);
        continue;
        if (sEe)
        {
          h.qsU.j(988L, 30L, sEf);
          h.qsU.j(988L, 31L, 1L);
        }
        else
        {
          h.qsU.j(988L, 34L, sEf);
          h.qsU.j(988L, 35L, 1L);
        }
      }
      if (sEf <= 800L)
      {
        h.qsU.j(988L, 101L, sEf);
        AppMethodBeat.o(109788);
        return;
      }
      if (sEf <= 1600L)
      {
        h.qsU.j(988L, 102L, sEf);
        AppMethodBeat.o(109788);
        return;
      }
      if (sEf <= 3200L)
      {
        h.qsU.j(988L, 103L, sEf);
        AppMethodBeat.o(109788);
        return;
      }
      if (sEf <= 5000L)
      {
        h.qsU.j(988L, 104L, sEf);
        AppMethodBeat.o(109788);
        return;
      }
      h.qsU.j(988L, 105L, sEf);
    }
    AppMethodBeat.o(109788);
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(109791);
    if (sDM <= 0L)
    {
      AppMethodBeat.o(109791);
      return;
    }
    cCF();
    AppMethodBeat.o(109791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.c
 * JD-Core Version:    0.7.0.1
 */