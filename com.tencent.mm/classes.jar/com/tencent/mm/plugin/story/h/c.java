package com.tencent.mm.plugin.story.h;

import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.ui.view.gallery.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat;", "", "()V", "ID", "", "TAG", "", "canReport", "", "currentUser", "Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "enterFromDoubleClick", "enterWithCache", "hasStartHttp", "hascanPlayCall", "isWaiting", "last_selectedColumn", "", "last_selectedRow", "markStoryId", "noCachecurrentUser", "onCreateTime", "onPlayCostTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStayTime", "onVideoPlay", "unReadList", "", "canPlay", "", "user", "storyId", "chattingDoubleCheck", "chattingDoubleCheckHasCache", "chattingDoubleCheckNoCache", "chattingRight", "chattingRightHasCache", "chattingRightNoCache", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkStayTime", "clean", "enter", "unreadList", "finish", "markInit", "markResumeTime", "onDestroy", "onSelectItem", "group", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "selectedRow", "selectedColumn", "onVideoWaiting", "playUser", "preLoadVideo", "startHttp", "CurrentPlayer", "plugin-story_release"})
public final class c
{
  private static boolean gbD;
  private static boolean isWaiting;
  public static c.a zAj;
  private static c.a zAk;
  private static boolean zAl;
  private static long zAm;
  private static boolean zAn;
  public static boolean zAo;
  private static long zAp;
  private static boolean zAq;
  private static List<String> zAr;
  public static final c zAs;
  private static long zzM;
  private static long zzN;
  private static long zzO;
  private static long zzT;
  private static int zzU;
  private static int zzV;
  private static boolean zzW;
  private static long zzZ;
  
  static
  {
    AppMethodBeat.i(119418);
    zAs = new c();
    AppMethodBeat.o(119418);
  }
  
  public static void awS(String paramString)
  {
    AppMethodBeat.i(119408);
    k.h(paramString, "user");
    ac.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightNoCache ".concat(String.valueOf(paramString)));
    zAl = false;
    zAk = new c.a(paramString, 1);
    com.tencent.mm.plugin.report.service.h.wUl.n(988L, 15L, 1L);
    AppMethodBeat.o(119408);
  }
  
  public static void awT(String paramString)
  {
    AppMethodBeat.i(119409);
    k.h(paramString, "user");
    ac.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckNoCache ".concat(String.valueOf(paramString)));
    zAl = false;
    zAk = new c.a(paramString, 2);
    com.tencent.mm.plugin.report.service.h.wUl.n(988L, 16L, 1L);
    AppMethodBeat.o(119409);
  }
  
  public static void bm(String paramString, long paramLong)
  {
    AppMethodBeat.i(119416);
    k.h(paramString, "user");
    if (zzT <= 0L)
    {
      AppMethodBeat.o(119416);
      return;
    }
    if (zzM != paramLong)
    {
      zzM = 0L;
      ac.i("MicroMsg.StoryBrowseIDKeyStat", "reset storyId markStoryId: " + zzM + " storyId " + paramLong);
      AppMethodBeat.o(119416);
      return;
    }
    zzO = bs.eWj();
    ac.v("MicroMsg.StoryBrowseIDKeyStat", "playUser onResumeTime " + zzO);
    c.a locala = zAk;
    if ((locala != null) && (k.g(locala.drG, paramString)))
    {
      Object localObject = com.tencent.mm.plugin.story.f.j.zsh;
      localObject = j.b.dVF().awy(paramString);
      ac.i("MicroMsg.StoryBrowseIDKeyStat", "preLoadCache > 0 then " + paramString + " preload " + bs.qz(((f)localObject).dZa()) + " canPlay: " + zAn);
      if (((f)localObject).dZa() > 0L)
      {
        if (locala.scene != 1) {
          break label249;
        }
        com.tencent.mm.plugin.report.service.h.wUl.n(988L, 21L, 1L);
        if (zAn) {
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 27L, 1L);
        }
      }
    }
    for (;;)
    {
      zAj = null;
      zAk = null;
      AppMethodBeat.o(119416);
      return;
      label249:
      if (locala.scene == 2)
      {
        com.tencent.mm.plugin.report.service.h.wUl.n(988L, 22L, 1L);
        if (zAn) {
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 28L, 1L);
        }
      }
    }
  }
  
  public static void clean()
  {
    AppMethodBeat.i(119404);
    zAo = false;
    gbD = true;
    zzN = 0L;
    zAn = false;
    zAm = 0L;
    zzO = 0L;
    zzT = 0L;
    zzW = false;
    zzU = -1;
    zzV = -1;
    zzZ = 0L;
    zAq = false;
    isWaiting = false;
    zAr = (List)new ArrayList();
    zAj = new c.a("", 1);
    AppMethodBeat.o(119404);
  }
  
  public static void d(ArrayList<ArrayList<com.tencent.mm.plugin.story.f.d.h>> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119411);
    k.h(paramArrayList, "group");
    if (zzT <= 0L)
    {
      AppMethodBeat.o(119411);
      return;
    }
    ac.v("MicroMsg.StoryBrowseIDKeyStat", " last_selectedColumn:" + zzV + ",last_selectedRow:" + zzU + " selectedRow:" + paramInt1 + ",selectedColumn:" + paramInt2);
    int i;
    int j;
    if (paramArrayList.size() > 0) {
      if ((((ArrayList)paramArrayList.get(paramInt1)).size() > 0) && (paramInt2 + 1 < ((ArrayList)paramArrayList.get(paramInt1)).size()))
      {
        if (!zzW) {
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 42L, 1L);
        }
        i = 1;
        if (paramInt1 + 1 < paramArrayList.size())
        {
          if (!zzW) {
            com.tencent.mm.plugin.report.service.h.wUl.n(988L, 43L, 1L);
          }
          j = 1;
          label176:
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
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 40L, 1L);
          isWaiting = false;
        }
        if (paramInt1 != zzU)
        {
          if (i != 0) {
            com.tencent.mm.plugin.report.service.h.wUl.n(988L, 46L, 1L);
          }
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 47L, 1L);
          i = paramInt1 - zzU;
          if (i == 1)
          {
            com.tencent.mm.plugin.report.service.h.wUl.n(988L, 90L, 1L);
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
              Object localObject1 = ((com.tencent.mm.plugin.story.f.d.h)((ArrayList)paramArrayList.get(paramInt1 + i)).get(0)).zuF;
              if ((localObject1 != null) && (((com.tencent.mm.plugin.story.f.d.j)localObject1).username != null) && (zAr != null))
              {
                Object localObject2 = zAr;
                if ((localObject2 != null) && (((List)localObject2).contains(((com.tencent.mm.plugin.story.f.d.j)localObject1).username) == true))
                {
                  localObject2 = s.ztj;
                  localObject1 = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
                  if (!((n)localObject1).dZs())
                  {
                    if (((n)localObject1).field_totalSize <= 0) {
                      break label576;
                    }
                    float f = ((n)localObject1).field_cacheSize / ((n)localObject1).field_totalSize;
                    localObject1 = m.zNR;
                    if (f * 100.0F < m.dZX().zMk) {
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
                    com.tencent.mm.plugin.report.service.h.wUl.n(988L, 80L, 1L);
                  }
                  label483:
                  if (i != 0) {
                    break label626;
                  }
                  com.tencent.mm.plugin.report.service.h.wUl.n(988L, 84L, 1L);
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
              com.tencent.mm.plugin.report.service.h.wUl.n(988L, 91L, 1L);
              break;
            }
            if (i == 3)
            {
              com.tencent.mm.plugin.report.service.h.wUl.n(988L, 92L, 1L);
              break;
            }
            if (i < 4) {
              break;
            }
            com.tencent.mm.plugin.report.service.h.wUl.n(988L, 93L, 1L);
            break;
            label576:
            j = 0;
            break label459;
            label582:
            if (i == 1)
            {
              com.tencent.mm.plugin.report.service.h.wUl.n(988L, 81L, 1L);
              break label483;
            }
            if (i != 2) {
              break label483;
            }
            com.tencent.mm.plugin.report.service.h.wUl.n(988L, 82L, 1L);
            break label483;
            label626:
            if (i == 1) {
              com.tencent.mm.plugin.report.service.h.wUl.n(988L, 85L, 1L);
            } else if (i == 2) {
              com.tencent.mm.plugin.report.service.h.wUl.n(988L, 86L, 1L);
            }
          }
        }
        else if (paramInt2 != zzV)
        {
          if (j != 0) {
            com.tencent.mm.plugin.report.service.h.wUl.n(988L, 44L, 1L);
          }
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 45L, 1L);
          i = paramInt2 - zzV;
          if (i != 1) {
            break label752;
          }
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 94L, 1L);
        }
      }
      for (;;)
      {
        label734:
        dXt();
        zzV = paramInt2;
        zzU = paramInt1;
        AppMethodBeat.o(119411);
        return;
        label752:
        if (i == 2) {
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 95L, 1L);
        } else if (i == 3) {
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 96L, 1L);
        } else if (i >= 4) {
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 97L, 1L);
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
  
  public static void dXp()
  {
    AppMethodBeat.i(119415);
    ac.v("MicroMsg.StoryBrowseIDKeyStat", "makeResumeTime onResumeTime " + zzN + " onPlayUser " + zzO);
    zzN = bs.eWj();
    AppMethodBeat.o(119415);
  }
  
  public static void dXq()
  {
    AppMethodBeat.i(119417);
    zzT = bs.eWj();
    AppMethodBeat.o(119417);
  }
  
  public static void dXr()
  {
    AppMethodBeat.i(119406);
    ac.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightHasCache");
    zAl = true;
    com.tencent.mm.plugin.report.service.h.wUl.n(988L, 11L, 1L);
    AppMethodBeat.o(119406);
  }
  
  public static void dXs()
  {
    AppMethodBeat.i(119407);
    ac.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckHasCache");
    zAl = true;
    com.tencent.mm.plugin.report.service.h.wUl.n(988L, 12L, 1L);
    AppMethodBeat.o(119407);
  }
  
  private static void dXt()
  {
    AppMethodBeat.i(119412);
    ac.v("MicroMsg.StoryBrowseIDKeyStat", "checkStayTime1 onStayTime " + zzZ + " hasStartHttp " + zAq + " onPlayCostTime: " + zAm);
    if ((zzZ == 0L) && (zAq))
    {
      if (zAm == 0L)
      {
        zzZ = bs.Ap(zzN);
        com.tencent.mm.plugin.report.service.h.wUl.n(988L, 63L, 1L);
        com.tencent.mm.plugin.report.service.h.wUl.n(988L, 62L, zzZ);
        AppMethodBeat.o(119412);
        return;
      }
      zzZ = bs.Ap(zAp);
      com.tencent.mm.plugin.report.service.h.wUl.n(988L, 61L, 1L);
      com.tencent.mm.plugin.report.service.h.wUl.n(988L, 60L, zzZ);
    }
    AppMethodBeat.o(119412);
  }
  
  public static void dXu()
  {
    AppMethodBeat.i(119414);
    if (zzT <= 0L)
    {
      AppMethodBeat.o(119414);
      return;
    }
    ac.i("MicroMsg.StoryBrowseIDKeyStat", "startHttp");
    zAq = true;
    AppMethodBeat.o(119414);
  }
  
  public static void ge(List<String> paramList)
  {
    AppMethodBeat.i(119405);
    k.h(paramList, "unreadList");
    zAr = paramList;
    AppMethodBeat.o(119405);
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(119413);
    if (zzT <= 0L)
    {
      AppMethodBeat.o(119413);
      return;
    }
    dXt();
    AppMethodBeat.o(119413);
  }
  
  public static void ym(long paramLong)
  {
    zzM = paramLong;
  }
  
  public static void yo(long paramLong)
  {
    if (zzT <= 0L) {}
    while ((paramLong == 0L) || (paramLong != zzM) || (zAm > 0L) || (zzN <= 0L)) {
      return;
    }
    isWaiting = true;
  }
  
  public static void yp(long paramLong)
  {
    AppMethodBeat.i(119410);
    if (zzT <= 0L)
    {
      AppMethodBeat.o(119410);
      return;
    }
    zAn = true;
    if (zAm <= 0L) {
      ac.v("MicroMsg.StoryBrowseIDKeyStat", "storyId  " + paramLong + " markStoryId " + zzM + " onPlayCostTime " + zAm + " onResumeTime " + zzN + "  onPlayUser " + zzO);
    }
    if ((paramLong != 0L) && (paramLong == zzM) && (zAm <= 0L) && (zzN > 0L))
    {
      zAm = bs.Ap(zzN);
      zAp = bs.eWj();
      ac.i("MicroMsg.StoryBrowseIDKeyStat", "canPlay " + zAm);
      isWaiting = false;
      if (zAo) {
        if (zAl)
        {
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 32L, zAm);
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 33L, 1L);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.wUl.n(988L, 71L, zAm);
        com.tencent.mm.plugin.report.service.h.wUl.n(988L, 70L, 1L);
        if ((NetStatusUtil.isWifi(ai.getContext())) || (NetStatusUtil.is4G(ai.getContext())))
        {
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 73L, zAm);
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 72L, 1L);
        }
        if (zAm > 400L) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.wUl.n(988L, 100L, zAm);
        AppMethodBeat.o(119410);
        return;
        com.tencent.mm.plugin.report.service.h.wUl.n(988L, 36L, zAm);
        com.tencent.mm.plugin.report.service.h.wUl.n(988L, 37L, 1L);
        continue;
        if (zAl)
        {
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 30L, zAm);
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 31L, 1L);
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 34L, zAm);
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 35L, 1L);
        }
      }
      if (zAm <= 800L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.n(988L, 101L, zAm);
        AppMethodBeat.o(119410);
        return;
      }
      if (zAm <= 1600L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.n(988L, 102L, zAm);
        AppMethodBeat.o(119410);
        return;
      }
      if (zAm <= 3200L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.n(988L, 103L, zAm);
        AppMethodBeat.o(119410);
        return;
      }
      if (zAm <= 5000L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.n(988L, 104L, zAm);
        AppMethodBeat.o(119410);
        return;
      }
      com.tencent.mm.plugin.report.service.h.wUl.n(988L, 105L, zAm);
    }
    AppMethodBeat.o(119410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.c
 * JD-Core Version:    0.7.0.1
 */