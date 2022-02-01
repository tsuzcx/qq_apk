package com.tencent.mm.plugin.story.h;

import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.ui.view.gallery.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat;", "", "()V", "ID", "", "TAG", "", "canReport", "", "currentUser", "Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "enterFromDoubleClick", "enterWithCache", "hasStartHttp", "hascanPlayCall", "isWaiting", "last_selectedColumn", "", "last_selectedRow", "markStoryId", "noCachecurrentUser", "onCreateTime", "onPlayCostTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStayTime", "onVideoPlay", "unReadList", "", "canPlay", "", "user", "storyId", "chattingDoubleCheck", "chattingDoubleCheckHasCache", "chattingDoubleCheckNoCache", "chattingRight", "chattingRightHasCache", "chattingRightNoCache", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkStayTime", "clean", "enter", "unreadList", "finish", "markInit", "markResumeTime", "onDestroy", "onSelectItem", "group", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "selectedRow", "selectedColumn", "onVideoWaiting", "playUser", "preLoadVideo", "startHttp", "CurrentPlayer", "plugin-story_release"})
public final class c
{
  private static boolean fWW;
  private static boolean isWaiting;
  private static long ymA;
  public static a ymK;
  private static a ymL;
  private static boolean ymM;
  private static long ymN;
  private static boolean ymO;
  public static boolean ymP;
  private static long ymQ;
  private static boolean ymR;
  private static List<String> ymS;
  public static final c ymT;
  private static long ymn;
  private static long ymo;
  private static long ymp;
  private static long ymu;
  private static int ymv;
  private static int ymw;
  private static boolean ymx;
  
  static
  {
    AppMethodBeat.i(119418);
    ymT = new c();
    AppMethodBeat.o(119418);
  }
  
  public static void arJ(String paramString)
  {
    AppMethodBeat.i(119408);
    k.h(paramString, "user");
    ad.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightNoCache ".concat(String.valueOf(paramString)));
    ymM = false;
    ymL = new a(paramString, 1);
    com.tencent.mm.plugin.report.service.h.vKh.m(988L, 15L, 1L);
    AppMethodBeat.o(119408);
  }
  
  public static void arK(String paramString)
  {
    AppMethodBeat.i(119409);
    k.h(paramString, "user");
    ad.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckNoCache ".concat(String.valueOf(paramString)));
    ymM = false;
    ymL = new a(paramString, 2);
    com.tencent.mm.plugin.report.service.h.vKh.m(988L, 16L, 1L);
    AppMethodBeat.o(119409);
  }
  
  public static void bk(String paramString, long paramLong)
  {
    AppMethodBeat.i(119416);
    k.h(paramString, "user");
    if (ymu <= 0L)
    {
      AppMethodBeat.o(119416);
      return;
    }
    if (ymn != paramLong)
    {
      ymn = 0L;
      ad.i("MicroMsg.StoryBrowseIDKeyStat", "reset storyId markStoryId: " + ymn + " storyId " + paramLong);
      AppMethodBeat.o(119416);
      return;
    }
    ymp = bt.eGO();
    ad.v("MicroMsg.StoryBrowseIDKeyStat", "playUser onResumeTime " + ymp);
    a locala = ymL;
    if ((locala != null) && (k.g(locala.dtV, paramString)))
    {
      Object localObject = com.tencent.mm.plugin.story.f.j.yfh;
      localObject = j.b.dHe().arp(paramString);
      ad.i("MicroMsg.StoryBrowseIDKeyStat", "preLoadCache > 0 then " + paramString + " preload " + bt.mK(((f)localObject).dKz()) + " canPlay: " + ymO);
      if (((f)localObject).dKz() > 0L)
      {
        if (locala.scene != 1) {
          break label249;
        }
        com.tencent.mm.plugin.report.service.h.vKh.m(988L, 21L, 1L);
        if (ymO) {
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 27L, 1L);
        }
      }
    }
    for (;;)
    {
      ymK = null;
      ymL = null;
      AppMethodBeat.o(119416);
      return;
      label249:
      if (locala.scene == 2)
      {
        com.tencent.mm.plugin.report.service.h.vKh.m(988L, 22L, 1L);
        if (ymO) {
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 28L, 1L);
        }
      }
    }
  }
  
  public static void c(ArrayList<ArrayList<com.tencent.mm.plugin.story.f.d.h>> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119411);
    k.h(paramArrayList, "group");
    if (ymu <= 0L)
    {
      AppMethodBeat.o(119411);
      return;
    }
    ad.v("MicroMsg.StoryBrowseIDKeyStat", " last_selectedColumn:" + ymw + ",last_selectedRow:" + ymv + " selectedRow:" + paramInt1 + ",selectedColumn:" + paramInt2);
    int i;
    int j;
    if (paramArrayList.size() > 0) {
      if ((((ArrayList)paramArrayList.get(paramInt1)).size() > 0) && (paramInt2 + 1 < ((ArrayList)paramArrayList.get(paramInt1)).size()))
      {
        if (!ymx) {
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 42L, 1L);
        }
        i = 1;
        if (paramInt1 + 1 < paramArrayList.size())
        {
          if (!ymx) {
            com.tencent.mm.plugin.report.service.h.vKh.m(988L, 43L, 1L);
          }
          j = 1;
          label176:
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
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 40L, 1L);
          isWaiting = false;
        }
        if (paramInt1 != ymv)
        {
          if (i != 0) {
            com.tencent.mm.plugin.report.service.h.vKh.m(988L, 46L, 1L);
          }
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 47L, 1L);
          i = paramInt1 - ymv;
          if (i == 1)
          {
            com.tencent.mm.plugin.report.service.h.vKh.m(988L, 90L, 1L);
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
              Object localObject1 = ((com.tencent.mm.plugin.story.f.d.h)((ArrayList)paramArrayList.get(paramInt1 + i)).get(0)).yhF;
              if ((localObject1 != null) && (((com.tencent.mm.plugin.story.f.d.j)localObject1).username != null) && (ymS != null))
              {
                Object localObject2 = ymS;
                if ((localObject2 != null) && (((List)localObject2).contains(((com.tencent.mm.plugin.story.f.d.j)localObject1).username) == true))
                {
                  localObject2 = s.ygj;
                  localObject1 = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
                  if (!((n)localObject1).dKR())
                  {
                    if (((n)localObject1).field_totalSize <= 0) {
                      break label576;
                    }
                    float f = ((n)localObject1).field_cacheSize / ((n)localObject1).field_totalSize;
                    localObject1 = m.yAD;
                    if (f * 100.0F < m.dLx().yyW) {
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
                    com.tencent.mm.plugin.report.service.h.vKh.m(988L, 80L, 1L);
                  }
                  label483:
                  if (i != 0) {
                    break label626;
                  }
                  com.tencent.mm.plugin.report.service.h.vKh.m(988L, 84L, 1L);
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
              com.tencent.mm.plugin.report.service.h.vKh.m(988L, 91L, 1L);
              break;
            }
            if (i == 3)
            {
              com.tencent.mm.plugin.report.service.h.vKh.m(988L, 92L, 1L);
              break;
            }
            if (i < 4) {
              break;
            }
            com.tencent.mm.plugin.report.service.h.vKh.m(988L, 93L, 1L);
            break;
            label576:
            j = 0;
            break label459;
            label582:
            if (i == 1)
            {
              com.tencent.mm.plugin.report.service.h.vKh.m(988L, 81L, 1L);
              break label483;
            }
            if (i != 2) {
              break label483;
            }
            com.tencent.mm.plugin.report.service.h.vKh.m(988L, 82L, 1L);
            break label483;
            label626:
            if (i == 1) {
              com.tencent.mm.plugin.report.service.h.vKh.m(988L, 85L, 1L);
            } else if (i == 2) {
              com.tencent.mm.plugin.report.service.h.vKh.m(988L, 86L, 1L);
            }
          }
        }
        else if (paramInt2 != ymw)
        {
          if (j != 0) {
            com.tencent.mm.plugin.report.service.h.vKh.m(988L, 44L, 1L);
          }
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 45L, 1L);
          i = paramInt2 - ymw;
          if (i != 1) {
            break label752;
          }
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 94L, 1L);
        }
      }
      for (;;)
      {
        label734:
        dIS();
        ymw = paramInt2;
        ymv = paramInt1;
        AppMethodBeat.o(119411);
        return;
        label752:
        if (i == 2) {
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 95L, 1L);
        } else if (i == 3) {
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 96L, 1L);
        } else if (i >= 4) {
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 97L, 1L);
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
  
  public static void clean()
  {
    AppMethodBeat.i(119404);
    ymP = false;
    fWW = true;
    ymo = 0L;
    ymO = false;
    ymN = 0L;
    ymp = 0L;
    ymu = 0L;
    ymx = false;
    ymv = -1;
    ymw = -1;
    ymA = 0L;
    ymR = false;
    isWaiting = false;
    ymS = (List)new ArrayList();
    ymK = new a("", 1);
    AppMethodBeat.o(119404);
  }
  
  public static void dIO()
  {
    AppMethodBeat.i(119415);
    ad.v("MicroMsg.StoryBrowseIDKeyStat", "makeResumeTime onResumeTime " + ymo + " onPlayUser " + ymp);
    ymo = bt.eGO();
    AppMethodBeat.o(119415);
  }
  
  public static void dIP()
  {
    AppMethodBeat.i(119417);
    ymu = bt.eGO();
    AppMethodBeat.o(119417);
  }
  
  public static void dIQ()
  {
    AppMethodBeat.i(119406);
    ad.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightHasCache");
    ymM = true;
    com.tencent.mm.plugin.report.service.h.vKh.m(988L, 11L, 1L);
    AppMethodBeat.o(119406);
  }
  
  public static void dIR()
  {
    AppMethodBeat.i(119407);
    ad.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckHasCache");
    ymM = true;
    com.tencent.mm.plugin.report.service.h.vKh.m(988L, 12L, 1L);
    AppMethodBeat.o(119407);
  }
  
  private static void dIS()
  {
    AppMethodBeat.i(119412);
    ad.v("MicroMsg.StoryBrowseIDKeyStat", "checkStayTime1 onStayTime " + ymA + " hasStartHttp " + ymR + " onPlayCostTime: " + ymN);
    if ((ymA == 0L) && (ymR))
    {
      if (ymN == 0L)
      {
        ymA = bt.vM(ymo);
        com.tencent.mm.plugin.report.service.h.vKh.m(988L, 63L, 1L);
        com.tencent.mm.plugin.report.service.h.vKh.m(988L, 62L, ymA);
        AppMethodBeat.o(119412);
        return;
      }
      ymA = bt.vM(ymQ);
      com.tencent.mm.plugin.report.service.h.vKh.m(988L, 61L, 1L);
      com.tencent.mm.plugin.report.service.h.vKh.m(988L, 60L, ymA);
    }
    AppMethodBeat.o(119412);
  }
  
  public static void dIT()
  {
    AppMethodBeat.i(119414);
    if (ymu <= 0L)
    {
      AppMethodBeat.o(119414);
      return;
    }
    ad.i("MicroMsg.StoryBrowseIDKeyStat", "startHttp");
    ymR = true;
    AppMethodBeat.o(119414);
  }
  
  public static void fW(List<String> paramList)
  {
    AppMethodBeat.i(119405);
    k.h(paramList, "unreadList");
    ymS = paramList;
    AppMethodBeat.o(119405);
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(119413);
    if (ymu <= 0L)
    {
      AppMethodBeat.o(119413);
      return;
    }
    dIS();
    AppMethodBeat.o(119413);
  }
  
  public static void tJ(long paramLong)
  {
    ymn = paramLong;
  }
  
  public static void tL(long paramLong)
  {
    if (ymu <= 0L) {}
    while ((paramLong == 0L) || (paramLong != ymn) || (ymN > 0L) || (ymo <= 0L)) {
      return;
    }
    isWaiting = true;
  }
  
  public static void tM(long paramLong)
  {
    AppMethodBeat.i(119410);
    if (ymu <= 0L)
    {
      AppMethodBeat.o(119410);
      return;
    }
    ymO = true;
    if (ymN <= 0L) {
      ad.v("MicroMsg.StoryBrowseIDKeyStat", "storyId  " + paramLong + " markStoryId " + ymn + " onPlayCostTime " + ymN + " onResumeTime " + ymo + "  onPlayUser " + ymp);
    }
    if ((paramLong != 0L) && (paramLong == ymn) && (ymN <= 0L) && (ymo > 0L))
    {
      ymN = bt.vM(ymo);
      ymQ = bt.eGO();
      ad.i("MicroMsg.StoryBrowseIDKeyStat", "canPlay " + ymN);
      isWaiting = false;
      if (ymP) {
        if (ymM)
        {
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 32L, ymN);
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 33L, 1L);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.vKh.m(988L, 71L, ymN);
        com.tencent.mm.plugin.report.service.h.vKh.m(988L, 70L, 1L);
        if ((NetStatusUtil.isWifi(aj.getContext())) || (NetStatusUtil.is4G(aj.getContext())))
        {
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 73L, ymN);
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 72L, 1L);
        }
        if (ymN > 400L) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.vKh.m(988L, 100L, ymN);
        AppMethodBeat.o(119410);
        return;
        com.tencent.mm.plugin.report.service.h.vKh.m(988L, 36L, ymN);
        com.tencent.mm.plugin.report.service.h.vKh.m(988L, 37L, 1L);
        continue;
        if (ymM)
        {
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 30L, ymN);
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 31L, 1L);
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 34L, ymN);
          com.tencent.mm.plugin.report.service.h.vKh.m(988L, 35L, 1L);
        }
      }
      if (ymN <= 800L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.m(988L, 101L, ymN);
        AppMethodBeat.o(119410);
        return;
      }
      if (ymN <= 1600L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.m(988L, 102L, ymN);
        AppMethodBeat.o(119410);
        return;
      }
      if (ymN <= 3200L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.m(988L, 103L, ymN);
        AppMethodBeat.o(119410);
        return;
      }
      if (ymN <= 5000L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.m(988L, 104L, ymN);
        AppMethodBeat.o(119410);
        return;
      }
      com.tencent.mm.plugin.report.service.h.vKh.m(988L, 105L, ymN);
    }
    AppMethodBeat.o(119410);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "", "user", "", "scene", "", "(Ljava/lang/String;I)V", "getScene", "()I", "getUser", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a
  {
    final String dtV;
    final int scene;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(119403);
      this.dtV = paramString;
      this.scene = paramInt;
      AppMethodBeat.o(119403);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.c
 * JD-Core Version:    0.7.0.1
 */