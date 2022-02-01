package com.tencent.mm.plugin.story.h;

import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.ui.view.gallery.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat;", "", "()V", "ID", "", "TAG", "", "canReport", "", "currentUser", "Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "enterFromDoubleClick", "enterWithCache", "hasStartHttp", "hascanPlayCall", "isWaiting", "last_selectedColumn", "", "last_selectedRow", "markStoryId", "noCachecurrentUser", "onCreateTime", "onPlayCostTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStayTime", "onVideoPlay", "unReadList", "", "canPlay", "", "user", "storyId", "chattingDoubleCheck", "chattingDoubleCheckHasCache", "chattingDoubleCheckNoCache", "chattingRight", "chattingRightHasCache", "chattingRightNoCache", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkStayTime", "clean", "enter", "unreadList", "finish", "markInit", "markResumeTime", "onDestroy", "onSelectItem", "group", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "selectedRow", "selectedColumn", "onVideoWaiting", "playUser", "preLoadVideo", "startHttp", "CurrentPlayer", "plugin-story_release"})
public final class c
{
  private static long BiJ;
  private static long BiK;
  private static long BiL;
  private static long BiQ;
  private static int BiR;
  private static int BiS;
  private static boolean BiT;
  private static long BiW;
  public static a Bjg;
  private static a Bjh;
  private static boolean Bji;
  private static long Bjj;
  private static boolean Bjk;
  public static boolean Bjl;
  private static long Bjm;
  private static boolean Bjn;
  private static List<String> Bjo;
  public static final c Bjp;
  private static boolean gxU;
  private static boolean isWaiting;
  
  static
  {
    AppMethodBeat.i(119418);
    Bjp = new c();
    AppMethodBeat.o(119418);
  }
  
  public static void Bi(long paramLong)
  {
    BiJ = paramLong;
  }
  
  public static void Bk(long paramLong)
  {
    if (BiQ <= 0L) {}
    while ((paramLong == 0L) || (paramLong != BiJ) || (Bjj > 0L) || (BiK <= 0L)) {
      return;
    }
    isWaiting = true;
  }
  
  public static void Bl(long paramLong)
  {
    AppMethodBeat.i(119410);
    if (BiQ <= 0L)
    {
      AppMethodBeat.o(119410);
      return;
    }
    Bjk = true;
    if (Bjj <= 0L) {
      ae.v("MicroMsg.StoryBrowseIDKeyStat", "storyId  " + paramLong + " markStoryId " + BiJ + " onPlayCostTime " + Bjj + " onResumeTime " + BiK + "  onPlayUser " + BiL);
    }
    if ((paramLong != 0L) && (paramLong == BiJ) && (Bjj <= 0L) && (BiK > 0L))
    {
      Bjj = bu.DD(BiK);
      Bjm = bu.fpO();
      ae.i("MicroMsg.StoryBrowseIDKeyStat", "canPlay " + Bjj);
      isWaiting = false;
      if (Bjl) {
        if (Bji)
        {
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 32L, Bjj);
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 33L, 1L);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yxI.n(988L, 71L, Bjj);
        com.tencent.mm.plugin.report.service.g.yxI.n(988L, 70L, 1L);
        if ((NetStatusUtil.isWifi(ak.getContext())) || (NetStatusUtil.is4G(ak.getContext())))
        {
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 73L, Bjj);
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 72L, 1L);
        }
        if (Bjj > 400L) {
          break;
        }
        com.tencent.mm.plugin.report.service.g.yxI.n(988L, 100L, Bjj);
        AppMethodBeat.o(119410);
        return;
        com.tencent.mm.plugin.report.service.g.yxI.n(988L, 36L, Bjj);
        com.tencent.mm.plugin.report.service.g.yxI.n(988L, 37L, 1L);
        continue;
        if (Bji)
        {
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 30L, Bjj);
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 31L, 1L);
        }
        else
        {
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 34L, Bjj);
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 35L, 1L);
        }
      }
      if (Bjj <= 800L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.n(988L, 101L, Bjj);
        AppMethodBeat.o(119410);
        return;
      }
      if (Bjj <= 1600L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.n(988L, 102L, Bjj);
        AppMethodBeat.o(119410);
        return;
      }
      if (Bjj <= 3200L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.n(988L, 103L, Bjj);
        AppMethodBeat.o(119410);
        return;
      }
      if (Bjj <= 5000L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.n(988L, 104L, Bjj);
        AppMethodBeat.o(119410);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.n(988L, 105L, Bjj);
    }
    AppMethodBeat.o(119410);
  }
  
  public static void aDp(String paramString)
  {
    AppMethodBeat.i(119408);
    p.h(paramString, "user");
    ae.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightNoCache ".concat(String.valueOf(paramString)));
    Bji = false;
    Bjh = new a(paramString, 1);
    com.tencent.mm.plugin.report.service.g.yxI.n(988L, 15L, 1L);
    AppMethodBeat.o(119408);
  }
  
  public static void aDq(String paramString)
  {
    AppMethodBeat.i(119409);
    p.h(paramString, "user");
    ae.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckNoCache ".concat(String.valueOf(paramString)));
    Bji = false;
    Bjh = new a(paramString, 2);
    com.tencent.mm.plugin.report.service.g.yxI.n(988L, 16L, 1L);
    AppMethodBeat.o(119409);
  }
  
  public static void bq(String paramString, long paramLong)
  {
    AppMethodBeat.i(119416);
    p.h(paramString, "user");
    if (BiQ <= 0L)
    {
      AppMethodBeat.o(119416);
      return;
    }
    if (BiJ != paramLong)
    {
      BiJ = 0L;
      ae.i("MicroMsg.StoryBrowseIDKeyStat", "reset storyId markStoryId: " + BiJ + " storyId " + paramLong);
      AppMethodBeat.o(119416);
      return;
    }
    BiL = bu.fpO();
    ae.v("MicroMsg.StoryBrowseIDKeyStat", "playUser onResumeTime " + BiL);
    a locala = Bjh;
    if ((locala != null) && (p.i(locala.dED, paramString)))
    {
      Object localObject = com.tencent.mm.plugin.story.f.j.BbE;
      localObject = j.b.elC().aCW(paramString);
      ae.i("MicroMsg.StoryBrowseIDKeyStat", "preLoadCache > 0 then " + paramString + " preload " + bu.sL(((f)localObject).eoY()) + " canPlay: " + Bjk);
      if (((f)localObject).eoY() > 0L)
      {
        if (locala.scene != 1) {
          break label260;
        }
        com.tencent.mm.plugin.report.service.g.yxI.n(988L, 21L, 1L);
        if (Bjk) {
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 27L, 1L);
        }
      }
    }
    for (;;)
    {
      Bjg = null;
      Bjh = null;
      AppMethodBeat.o(119416);
      return;
      label260:
      if (locala.scene == 2)
      {
        com.tencent.mm.plugin.report.service.g.yxI.n(988L, 22L, 1L);
        if (Bjk) {
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 28L, 1L);
        }
      }
    }
  }
  
  public static void clean()
  {
    AppMethodBeat.i(119404);
    Bjl = false;
    gxU = true;
    BiK = 0L;
    Bjk = false;
    Bjj = 0L;
    BiL = 0L;
    BiQ = 0L;
    BiT = false;
    BiR = -1;
    BiS = -1;
    BiW = 0L;
    Bjn = false;
    isWaiting = false;
    Bjo = (List)new ArrayList();
    Bjg = new a("", 1);
    AppMethodBeat.o(119404);
  }
  
  public static void d(ArrayList<ArrayList<h>> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119411);
    p.h(paramArrayList, "group");
    if (BiQ <= 0L)
    {
      AppMethodBeat.o(119411);
      return;
    }
    ae.v("MicroMsg.StoryBrowseIDKeyStat", " last_selectedColumn:" + BiS + ",last_selectedRow:" + BiR + " selectedRow:" + paramInt1 + ",selectedColumn:" + paramInt2);
    int i;
    int j;
    if (paramArrayList.size() > 0) {
      if ((((ArrayList)paramArrayList.get(paramInt1)).size() > 0) && (paramInt2 + 1 < ((ArrayList)paramArrayList.get(paramInt1)).size()))
      {
        if (!BiT) {
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 42L, 1L);
        }
        i = 1;
        if (paramInt1 + 1 < paramArrayList.size())
        {
          if (!BiT) {
            com.tencent.mm.plugin.report.service.g.yxI.n(988L, 43L, 1L);
          }
          j = 1;
          label176:
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
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 40L, 1L);
          isWaiting = false;
        }
        if (paramInt1 != BiR)
        {
          if (i != 0) {
            com.tencent.mm.plugin.report.service.g.yxI.n(988L, 46L, 1L);
          }
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 47L, 1L);
          i = paramInt1 - BiR;
          if (i == 1)
          {
            com.tencent.mm.plugin.report.service.g.yxI.n(988L, 90L, 1L);
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
              Object localObject1 = ((h)((ArrayList)paramArrayList.get(paramInt1 + i)).get(0)).Bec;
              if ((localObject1 != null) && (((com.tencent.mm.plugin.story.f.d.j)localObject1).username != null) && (Bjo != null))
              {
                Object localObject2 = Bjo;
                if ((localObject2 != null) && (((List)localObject2).contains(((com.tencent.mm.plugin.story.f.d.j)localObject1).username) == true))
                {
                  localObject2 = s.BcG;
                  localObject1 = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
                  if (!((n)localObject1).epq())
                  {
                    if (((n)localObject1).field_totalSize <= 0) {
                      break label576;
                    }
                    float f = ((n)localObject1).field_cacheSize / ((n)localObject1).field_totalSize;
                    localObject1 = m.BwQ;
                    if (f * 100.0F < m.epV().Bvj) {
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
                    com.tencent.mm.plugin.report.service.g.yxI.n(988L, 80L, 1L);
                  }
                  label483:
                  if (i != 0) {
                    break label626;
                  }
                  com.tencent.mm.plugin.report.service.g.yxI.n(988L, 84L, 1L);
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
              com.tencent.mm.plugin.report.service.g.yxI.n(988L, 91L, 1L);
              break;
            }
            if (i == 3)
            {
              com.tencent.mm.plugin.report.service.g.yxI.n(988L, 92L, 1L);
              break;
            }
            if (i < 4) {
              break;
            }
            com.tencent.mm.plugin.report.service.g.yxI.n(988L, 93L, 1L);
            break;
            label576:
            j = 0;
            break label459;
            label582:
            if (i == 1)
            {
              com.tencent.mm.plugin.report.service.g.yxI.n(988L, 81L, 1L);
              break label483;
            }
            if (i != 2) {
              break label483;
            }
            com.tencent.mm.plugin.report.service.g.yxI.n(988L, 82L, 1L);
            break label483;
            label626:
            if (i == 1) {
              com.tencent.mm.plugin.report.service.g.yxI.n(988L, 85L, 1L);
            } else if (i == 2) {
              com.tencent.mm.plugin.report.service.g.yxI.n(988L, 86L, 1L);
            }
          }
        }
        else if (paramInt2 != BiS)
        {
          if (j != 0) {
            com.tencent.mm.plugin.report.service.g.yxI.n(988L, 44L, 1L);
          }
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 45L, 1L);
          i = paramInt2 - BiS;
          if (i != 1) {
            break label752;
          }
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 94L, 1L);
        }
      }
      for (;;)
      {
        label734:
        enr();
        BiS = paramInt2;
        BiR = paramInt1;
        AppMethodBeat.o(119411);
        return;
        label752:
        if (i == 2) {
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 95L, 1L);
        } else if (i == 3) {
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 96L, 1L);
        } else if (i >= 4) {
          com.tencent.mm.plugin.report.service.g.yxI.n(988L, 97L, 1L);
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
  
  public static void enn()
  {
    AppMethodBeat.i(119415);
    ae.v("MicroMsg.StoryBrowseIDKeyStat", "makeResumeTime onResumeTime " + BiK + " onPlayUser " + BiL);
    BiK = bu.fpO();
    AppMethodBeat.o(119415);
  }
  
  public static void eno()
  {
    AppMethodBeat.i(119417);
    BiQ = bu.fpO();
    AppMethodBeat.o(119417);
  }
  
  public static void enp()
  {
    AppMethodBeat.i(119406);
    ae.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightHasCache");
    Bji = true;
    com.tencent.mm.plugin.report.service.g.yxI.n(988L, 11L, 1L);
    AppMethodBeat.o(119406);
  }
  
  public static void enq()
  {
    AppMethodBeat.i(119407);
    ae.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckHasCache");
    Bji = true;
    com.tencent.mm.plugin.report.service.g.yxI.n(988L, 12L, 1L);
    AppMethodBeat.o(119407);
  }
  
  private static void enr()
  {
    AppMethodBeat.i(119412);
    ae.v("MicroMsg.StoryBrowseIDKeyStat", "checkStayTime1 onStayTime " + BiW + " hasStartHttp " + Bjn + " onPlayCostTime: " + Bjj);
    if ((BiW == 0L) && (Bjn))
    {
      if (Bjj == 0L)
      {
        BiW = bu.DD(BiK);
        com.tencent.mm.plugin.report.service.g.yxI.n(988L, 63L, 1L);
        com.tencent.mm.plugin.report.service.g.yxI.n(988L, 62L, BiW);
        AppMethodBeat.o(119412);
        return;
      }
      BiW = bu.DD(Bjm);
      com.tencent.mm.plugin.report.service.g.yxI.n(988L, 61L, 1L);
      com.tencent.mm.plugin.report.service.g.yxI.n(988L, 60L, BiW);
    }
    AppMethodBeat.o(119412);
  }
  
  public static void ens()
  {
    AppMethodBeat.i(119414);
    if (BiQ <= 0L)
    {
      AppMethodBeat.o(119414);
      return;
    }
    ae.i("MicroMsg.StoryBrowseIDKeyStat", "startHttp");
    Bjn = true;
    AppMethodBeat.o(119414);
  }
  
  public static void gy(List<String> paramList)
  {
    AppMethodBeat.i(119405);
    p.h(paramList, "unreadList");
    Bjo = paramList;
    AppMethodBeat.o(119405);
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(119413);
    if (BiQ <= 0L)
    {
      AppMethodBeat.o(119413);
      return;
    }
    enr();
    AppMethodBeat.o(119413);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "", "user", "", "scene", "", "(Ljava/lang/String;I)V", "getScene", "()I", "getUser", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a
  {
    final String dED;
    final int scene;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(119403);
      this.dED = paramString;
      this.scene = paramInt;
      AppMethodBeat.o(119403);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.c
 * JD-Core Version:    0.7.0.1
 */