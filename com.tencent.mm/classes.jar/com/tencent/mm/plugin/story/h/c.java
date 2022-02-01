package com.tencent.mm.plugin.story.h;

import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.ui.view.gallery.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat;", "", "()V", "ID", "", "TAG", "", "canReport", "", "currentUser", "Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "enterFromDoubleClick", "enterWithCache", "hasStartHttp", "hascanPlayCall", "isWaiting", "last_selectedColumn", "", "last_selectedRow", "markStoryId", "noCachecurrentUser", "onCreateTime", "onPlayCostTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStayTime", "onVideoPlay", "unReadList", "", "canPlay", "", "user", "storyId", "chattingDoubleCheck", "chattingDoubleCheckHasCache", "chattingDoubleCheckNoCache", "chattingRight", "chattingRightHasCache", "chattingRightNoCache", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkStayTime", "clean", "enter", "unreadList", "finish", "markInit", "markResumeTime", "onDestroy", "onSelectItem", "group", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "selectedRow", "selectedColumn", "onVideoWaiting", "playUser", "preLoadVideo", "startHttp", "CurrentPlayer", "plugin-story_release"})
public final class c
{
  public static c.a ARI;
  private static c.a ARJ;
  private static boolean ARK;
  private static long ARL;
  private static boolean ARM;
  public static boolean ARN;
  private static long ARO;
  private static boolean ARP;
  private static List<String> ARQ;
  public static final c ARR;
  private static long ARl;
  private static long ARm;
  private static long ARn;
  private static long ARs;
  private static int ARt;
  private static int ARu;
  private static boolean ARv;
  private static long ARy;
  private static boolean gvn;
  private static boolean isWaiting;
  
  static
  {
    AppMethodBeat.i(119418);
    ARR = new c();
    AppMethodBeat.o(119418);
  }
  
  public static void AK(long paramLong)
  {
    ARl = paramLong;
  }
  
  public static void AM(long paramLong)
  {
    if (ARs <= 0L) {}
    while ((paramLong == 0L) || (paramLong != ARl) || (ARL > 0L) || (ARm <= 0L)) {
      return;
    }
    isWaiting = true;
  }
  
  public static void AN(long paramLong)
  {
    AppMethodBeat.i(119410);
    if (ARs <= 0L)
    {
      AppMethodBeat.o(119410);
      return;
    }
    ARM = true;
    if (ARL <= 0L) {
      ad.v("MicroMsg.StoryBrowseIDKeyStat", "storyId  " + paramLong + " markStoryId " + ARl + " onPlayCostTime " + ARL + " onResumeTime " + ARm + "  onPlayUser " + ARn);
    }
    if ((paramLong != 0L) && (paramLong == ARl) && (ARL <= 0L) && (ARm > 0L))
    {
      ARL = bt.Df(ARm);
      ARO = bt.flT();
      ad.i("MicroMsg.StoryBrowseIDKeyStat", "canPlay " + ARL);
      isWaiting = false;
      if (ARN) {
        if (ARK)
        {
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 32L, ARL);
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 33L, 1L);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yhR.n(988L, 71L, ARL);
        com.tencent.mm.plugin.report.service.g.yhR.n(988L, 70L, 1L);
        if ((NetStatusUtil.isWifi(aj.getContext())) || (NetStatusUtil.is4G(aj.getContext())))
        {
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 73L, ARL);
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 72L, 1L);
        }
        if (ARL > 400L) {
          break;
        }
        com.tencent.mm.plugin.report.service.g.yhR.n(988L, 100L, ARL);
        AppMethodBeat.o(119410);
        return;
        com.tencent.mm.plugin.report.service.g.yhR.n(988L, 36L, ARL);
        com.tencent.mm.plugin.report.service.g.yhR.n(988L, 37L, 1L);
        continue;
        if (ARK)
        {
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 30L, ARL);
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 31L, 1L);
        }
        else
        {
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 34L, ARL);
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 35L, 1L);
        }
      }
      if (ARL <= 800L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.n(988L, 101L, ARL);
        AppMethodBeat.o(119410);
        return;
      }
      if (ARL <= 1600L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.n(988L, 102L, ARL);
        AppMethodBeat.o(119410);
        return;
      }
      if (ARL <= 3200L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.n(988L, 103L, ARL);
        AppMethodBeat.o(119410);
        return;
      }
      if (ARL <= 5000L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.n(988L, 104L, ARL);
        AppMethodBeat.o(119410);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yhR.n(988L, 105L, ARL);
    }
    AppMethodBeat.o(119410);
  }
  
  public static void aBW(String paramString)
  {
    AppMethodBeat.i(119408);
    p.h(paramString, "user");
    ad.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightNoCache ".concat(String.valueOf(paramString)));
    ARK = false;
    ARJ = new c.a(paramString, 1);
    com.tencent.mm.plugin.report.service.g.yhR.n(988L, 15L, 1L);
    AppMethodBeat.o(119408);
  }
  
  public static void aBX(String paramString)
  {
    AppMethodBeat.i(119409);
    p.h(paramString, "user");
    ad.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckNoCache ".concat(String.valueOf(paramString)));
    ARK = false;
    ARJ = new c.a(paramString, 2);
    com.tencent.mm.plugin.report.service.g.yhR.n(988L, 16L, 1L);
    AppMethodBeat.o(119409);
  }
  
  public static void bp(String paramString, long paramLong)
  {
    AppMethodBeat.i(119416);
    p.h(paramString, "user");
    if (ARs <= 0L)
    {
      AppMethodBeat.o(119416);
      return;
    }
    if (ARl != paramLong)
    {
      ARl = 0L;
      ad.i("MicroMsg.StoryBrowseIDKeyStat", "reset storyId markStoryId: " + ARl + " storyId " + paramLong);
      AppMethodBeat.o(119416);
      return;
    }
    ARn = bt.flT();
    ad.v("MicroMsg.StoryBrowseIDKeyStat", "playUser onResumeTime " + ARn);
    c.a locala = ARJ;
    if ((locala != null) && (p.i(locala.dDy, paramString)))
    {
      Object localObject = com.tencent.mm.plugin.story.f.j.AKb;
      localObject = j.b.ehU().aBD(paramString);
      ad.i("MicroMsg.StoryBrowseIDKeyStat", "preLoadCache > 0 then " + paramString + " preload " + bt.sy(((f)localObject).elp()) + " canPlay: " + ARM);
      if (((f)localObject).elp() > 0L)
      {
        if (locala.scene != 1) {
          break label260;
        }
        com.tencent.mm.plugin.report.service.g.yhR.n(988L, 21L, 1L);
        if (ARM) {
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 27L, 1L);
        }
      }
    }
    for (;;)
    {
      ARI = null;
      ARJ = null;
      AppMethodBeat.o(119416);
      return;
      label260:
      if (locala.scene == 2)
      {
        com.tencent.mm.plugin.report.service.g.yhR.n(988L, 22L, 1L);
        if (ARM) {
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 28L, 1L);
        }
      }
    }
  }
  
  public static void clean()
  {
    AppMethodBeat.i(119404);
    ARN = false;
    gvn = true;
    ARm = 0L;
    ARM = false;
    ARL = 0L;
    ARn = 0L;
    ARs = 0L;
    ARv = false;
    ARt = -1;
    ARu = -1;
    ARy = 0L;
    ARP = false;
    isWaiting = false;
    ARQ = (List)new ArrayList();
    ARI = new c.a("", 1);
    AppMethodBeat.o(119404);
  }
  
  public static void d(ArrayList<ArrayList<h>> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119411);
    p.h(paramArrayList, "group");
    if (ARs <= 0L)
    {
      AppMethodBeat.o(119411);
      return;
    }
    ad.v("MicroMsg.StoryBrowseIDKeyStat", " last_selectedColumn:" + ARu + ",last_selectedRow:" + ARt + " selectedRow:" + paramInt1 + ",selectedColumn:" + paramInt2);
    int i;
    int j;
    if (paramArrayList.size() > 0) {
      if ((((ArrayList)paramArrayList.get(paramInt1)).size() > 0) && (paramInt2 + 1 < ((ArrayList)paramArrayList.get(paramInt1)).size()))
      {
        if (!ARv) {
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 42L, 1L);
        }
        i = 1;
        if (paramInt1 + 1 < paramArrayList.size())
        {
          if (!ARv) {
            com.tencent.mm.plugin.report.service.g.yhR.n(988L, 43L, 1L);
          }
          j = 1;
          label176:
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
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 40L, 1L);
          isWaiting = false;
        }
        if (paramInt1 != ARt)
        {
          if (i != 0) {
            com.tencent.mm.plugin.report.service.g.yhR.n(988L, 46L, 1L);
          }
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 47L, 1L);
          i = paramInt1 - ARt;
          if (i == 1)
          {
            com.tencent.mm.plugin.report.service.g.yhR.n(988L, 90L, 1L);
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
              Object localObject1 = ((h)((ArrayList)paramArrayList.get(paramInt1 + i)).get(0)).AMA;
              if ((localObject1 != null) && (((com.tencent.mm.plugin.story.f.d.j)localObject1).username != null) && (ARQ != null))
              {
                Object localObject2 = ARQ;
                if ((localObject2 != null) && (((List)localObject2).contains(((com.tencent.mm.plugin.story.f.d.j)localObject1).username) == true))
                {
                  localObject2 = s.ALd;
                  localObject1 = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
                  if (!((n)localObject1).elH())
                  {
                    if (((n)localObject1).field_totalSize <= 0) {
                      break label576;
                    }
                    float f = ((n)localObject1).field_cacheSize / ((n)localObject1).field_totalSize;
                    localObject1 = m.Bfs;
                    if (f * 100.0F < m.emm().BdL) {
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
                    com.tencent.mm.plugin.report.service.g.yhR.n(988L, 80L, 1L);
                  }
                  label483:
                  if (i != 0) {
                    break label626;
                  }
                  com.tencent.mm.plugin.report.service.g.yhR.n(988L, 84L, 1L);
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
              com.tencent.mm.plugin.report.service.g.yhR.n(988L, 91L, 1L);
              break;
            }
            if (i == 3)
            {
              com.tencent.mm.plugin.report.service.g.yhR.n(988L, 92L, 1L);
              break;
            }
            if (i < 4) {
              break;
            }
            com.tencent.mm.plugin.report.service.g.yhR.n(988L, 93L, 1L);
            break;
            label576:
            j = 0;
            break label459;
            label582:
            if (i == 1)
            {
              com.tencent.mm.plugin.report.service.g.yhR.n(988L, 81L, 1L);
              break label483;
            }
            if (i != 2) {
              break label483;
            }
            com.tencent.mm.plugin.report.service.g.yhR.n(988L, 82L, 1L);
            break label483;
            label626:
            if (i == 1) {
              com.tencent.mm.plugin.report.service.g.yhR.n(988L, 85L, 1L);
            } else if (i == 2) {
              com.tencent.mm.plugin.report.service.g.yhR.n(988L, 86L, 1L);
            }
          }
        }
        else if (paramInt2 != ARu)
        {
          if (j != 0) {
            com.tencent.mm.plugin.report.service.g.yhR.n(988L, 44L, 1L);
          }
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 45L, 1L);
          i = paramInt2 - ARu;
          if (i != 1) {
            break label752;
          }
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 94L, 1L);
        }
      }
      for (;;)
      {
        label734:
        ejI();
        ARu = paramInt2;
        ARt = paramInt1;
        AppMethodBeat.o(119411);
        return;
        label752:
        if (i == 2) {
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 95L, 1L);
        } else if (i == 3) {
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 96L, 1L);
        } else if (i >= 4) {
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 97L, 1L);
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
  
  public static void ejE()
  {
    AppMethodBeat.i(119415);
    ad.v("MicroMsg.StoryBrowseIDKeyStat", "makeResumeTime onResumeTime " + ARm + " onPlayUser " + ARn);
    ARm = bt.flT();
    AppMethodBeat.o(119415);
  }
  
  public static void ejF()
  {
    AppMethodBeat.i(119417);
    ARs = bt.flT();
    AppMethodBeat.o(119417);
  }
  
  public static void ejG()
  {
    AppMethodBeat.i(119406);
    ad.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightHasCache");
    ARK = true;
    com.tencent.mm.plugin.report.service.g.yhR.n(988L, 11L, 1L);
    AppMethodBeat.o(119406);
  }
  
  public static void ejH()
  {
    AppMethodBeat.i(119407);
    ad.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckHasCache");
    ARK = true;
    com.tencent.mm.plugin.report.service.g.yhR.n(988L, 12L, 1L);
    AppMethodBeat.o(119407);
  }
  
  private static void ejI()
  {
    AppMethodBeat.i(119412);
    ad.v("MicroMsg.StoryBrowseIDKeyStat", "checkStayTime1 onStayTime " + ARy + " hasStartHttp " + ARP + " onPlayCostTime: " + ARL);
    if ((ARy == 0L) && (ARP))
    {
      if (ARL == 0L)
      {
        ARy = bt.Df(ARm);
        com.tencent.mm.plugin.report.service.g.yhR.n(988L, 63L, 1L);
        com.tencent.mm.plugin.report.service.g.yhR.n(988L, 62L, ARy);
        AppMethodBeat.o(119412);
        return;
      }
      ARy = bt.Df(ARO);
      com.tencent.mm.plugin.report.service.g.yhR.n(988L, 61L, 1L);
      com.tencent.mm.plugin.report.service.g.yhR.n(988L, 60L, ARy);
    }
    AppMethodBeat.o(119412);
  }
  
  public static void ejJ()
  {
    AppMethodBeat.i(119414);
    if (ARs <= 0L)
    {
      AppMethodBeat.o(119414);
      return;
    }
    ad.i("MicroMsg.StoryBrowseIDKeyStat", "startHttp");
    ARP = true;
    AppMethodBeat.o(119414);
  }
  
  public static void gp(List<String> paramList)
  {
    AppMethodBeat.i(119405);
    p.h(paramList, "unreadList");
    ARQ = paramList;
    AppMethodBeat.o(119405);
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(119413);
    if (ARs <= 0L)
    {
      AppMethodBeat.o(119413);
      return;
    }
    ejI();
    AppMethodBeat.o(119413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.c
 * JD-Core Version:    0.7.0.1
 */