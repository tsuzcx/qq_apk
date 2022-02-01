package com.tencent.mm.plugin.story.h;

import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.ui.view.gallery.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat;", "", "()V", "ID", "", "TAG", "", "canReport", "", "currentUser", "Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "enterFromDoubleClick", "enterWithCache", "hasStartHttp", "hascanPlayCall", "isWaiting", "last_selectedColumn", "", "last_selectedRow", "markStoryId", "noCachecurrentUser", "onCreateTime", "onPlayCostTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStayTime", "onVideoPlay", "unReadList", "", "canPlay", "", "user", "storyId", "chattingDoubleCheck", "chattingDoubleCheckHasCache", "chattingDoubleCheckNoCache", "chattingRight", "chattingRightHasCache", "chattingRightNoCache", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkStayTime", "clean", "enter", "unreadList", "finish", "markInit", "markResumeTime", "onDestroy", "onSelectItem", "group", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "selectedRow", "selectedColumn", "onVideoWaiting", "playUser", "preLoadVideo", "startHttp", "CurrentPlayer", "plugin-story_release"})
public final class c
{
  private static long FtA;
  private static long FtB;
  private static long FtG;
  private static int FtH;
  private static int FtI;
  private static boolean FtJ;
  private static long FtM;
  public static a FtW;
  private static a FtX;
  private static boolean FtY;
  private static long FtZ;
  private static long Ftz;
  private static boolean Fua;
  public static boolean Fub;
  private static long Fuc;
  private static boolean Fud;
  private static List<String> Fue;
  public static final c Fuf;
  private static boolean hkH;
  private static boolean isWaiting;
  
  static
  {
    AppMethodBeat.i(119418);
    Fuf = new c();
    AppMethodBeat.o(119418);
  }
  
  public static void Kn(long paramLong)
  {
    Ftz = paramLong;
  }
  
  public static void Kp(long paramLong)
  {
    if (FtG <= 0L) {}
    while ((paramLong == 0L) || (paramLong != Ftz) || (FtZ > 0L) || (FtA <= 0L)) {
      return;
    }
    isWaiting = true;
  }
  
  public static void Kq(long paramLong)
  {
    AppMethodBeat.i(119410);
    if (FtG <= 0L)
    {
      AppMethodBeat.o(119410);
      return;
    }
    Fua = true;
    if (FtZ <= 0L) {
      Log.v("MicroMsg.StoryBrowseIDKeyStat", "storyId  " + paramLong + " markStoryId " + Ftz + " onPlayCostTime " + FtZ + " onResumeTime " + FtA + "  onPlayUser " + FtB);
    }
    if ((paramLong != 0L) && (paramLong == Ftz) && (FtZ <= 0L) && (FtA > 0L))
    {
      FtZ = Util.milliSecondsToNow(FtA);
      Fuc = Util.nowMilliSecond();
      Log.i("MicroMsg.StoryBrowseIDKeyStat", "canPlay " + FtZ);
      isWaiting = false;
      if (Fub) {
        if (FtY)
        {
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 32L, FtZ);
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 33L, 1L);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.CyF.n(988L, 71L, FtZ);
        com.tencent.mm.plugin.report.service.h.CyF.n(988L, 70L, 1L);
        if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext())))
        {
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 73L, FtZ);
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 72L, 1L);
        }
        if (FtZ > 400L) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.CyF.n(988L, 100L, FtZ);
        AppMethodBeat.o(119410);
        return;
        com.tencent.mm.plugin.report.service.h.CyF.n(988L, 36L, FtZ);
        com.tencent.mm.plugin.report.service.h.CyF.n(988L, 37L, 1L);
        continue;
        if (FtY)
        {
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 30L, FtZ);
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 31L, 1L);
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 34L, FtZ);
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 35L, 1L);
        }
      }
      if (FtZ <= 800L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.n(988L, 101L, FtZ);
        AppMethodBeat.o(119410);
        return;
      }
      if (FtZ <= 1600L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.n(988L, 102L, FtZ);
        AppMethodBeat.o(119410);
        return;
      }
      if (FtZ <= 3200L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.n(988L, 103L, FtZ);
        AppMethodBeat.o(119410);
        return;
      }
      if (FtZ <= 5000L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.n(988L, 104L, FtZ);
        AppMethodBeat.o(119410);
        return;
      }
      com.tencent.mm.plugin.report.service.h.CyF.n(988L, 105L, FtZ);
    }
    AppMethodBeat.o(119410);
  }
  
  public static void aSk(String paramString)
  {
    AppMethodBeat.i(119408);
    p.h(paramString, "user");
    Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightNoCache ".concat(String.valueOf(paramString)));
    FtY = false;
    FtX = new a(paramString, 1);
    com.tencent.mm.plugin.report.service.h.CyF.n(988L, 15L, 1L);
    AppMethodBeat.o(119408);
  }
  
  public static void aSl(String paramString)
  {
    AppMethodBeat.i(119409);
    p.h(paramString, "user");
    Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckNoCache ".concat(String.valueOf(paramString)));
    FtY = false;
    FtX = new a(paramString, 2);
    com.tencent.mm.plugin.report.service.h.CyF.n(988L, 16L, 1L);
    AppMethodBeat.o(119409);
  }
  
  public static void bs(String paramString, long paramLong)
  {
    AppMethodBeat.i(119416);
    p.h(paramString, "user");
    if (FtG <= 0L)
    {
      AppMethodBeat.o(119416);
      return;
    }
    if (Ftz != paramLong)
    {
      Ftz = 0L;
      Log.i("MicroMsg.StoryBrowseIDKeyStat", "reset storyId markStoryId: " + Ftz + " storyId " + paramLong);
      AppMethodBeat.o(119416);
      return;
    }
    FtB = Util.nowMilliSecond();
    Log.v("MicroMsg.StoryBrowseIDKeyStat", "playUser onResumeTime " + FtB);
    a locala = FtX;
    if ((locala != null) && (p.j(locala.dWq, paramString)))
    {
      Object localObject = com.tencent.mm.plugin.story.f.j.Fmy;
      localObject = j.b.fod().aRS(paramString);
      Log.i("MicroMsg.StoryBrowseIDKeyStat", "preLoadCache > 0 then " + paramString + " preload " + Util.getSizeKB(((f)localObject).fry()) + " canPlay: " + Fua);
      if (((f)localObject).fry() > 0L)
      {
        if (locala.scene != 1) {
          break label260;
        }
        com.tencent.mm.plugin.report.service.h.CyF.n(988L, 21L, 1L);
        if (Fua) {
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 27L, 1L);
        }
      }
    }
    for (;;)
    {
      FtW = null;
      FtX = null;
      AppMethodBeat.o(119416);
      return;
      label260:
      if (locala.scene == 2)
      {
        com.tencent.mm.plugin.report.service.h.CyF.n(988L, 22L, 1L);
        if (Fua) {
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 28L, 1L);
        }
      }
    }
  }
  
  public static void clean()
  {
    AppMethodBeat.i(119404);
    Fub = false;
    hkH = true;
    FtA = 0L;
    Fua = false;
    FtZ = 0L;
    FtB = 0L;
    FtG = 0L;
    FtJ = false;
    FtH = -1;
    FtI = -1;
    FtM = 0L;
    Fud = false;
    isWaiting = false;
    Fue = (List)new ArrayList();
    FtW = new a("", 1);
    AppMethodBeat.o(119404);
  }
  
  public static void d(ArrayList<ArrayList<com.tencent.mm.plugin.story.f.d.h>> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119411);
    p.h(paramArrayList, "group");
    if (FtG <= 0L)
    {
      AppMethodBeat.o(119411);
      return;
    }
    Log.v("MicroMsg.StoryBrowseIDKeyStat", " last_selectedColumn:" + FtI + ",last_selectedRow:" + FtH + " selectedRow:" + paramInt1 + ",selectedColumn:" + paramInt2);
    int i;
    int j;
    if (paramArrayList.size() > 0) {
      if ((((ArrayList)paramArrayList.get(paramInt1)).size() > 0) && (paramInt2 + 1 < ((ArrayList)paramArrayList.get(paramInt1)).size()))
      {
        if (!FtJ) {
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 42L, 1L);
        }
        i = 1;
        if (paramInt1 + 1 < paramArrayList.size())
        {
          if (!FtJ) {
            com.tencent.mm.plugin.report.service.h.CyF.n(988L, 43L, 1L);
          }
          j = 1;
          label176:
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
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 40L, 1L);
          isWaiting = false;
        }
        if (paramInt1 != FtH)
        {
          if (i != 0) {
            com.tencent.mm.plugin.report.service.h.CyF.n(988L, 46L, 1L);
          }
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 47L, 1L);
          i = paramInt1 - FtH;
          if (i == 1)
          {
            com.tencent.mm.plugin.report.service.h.CyF.n(988L, 90L, 1L);
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
              Object localObject1 = ((com.tencent.mm.plugin.story.f.d.h)((ArrayList)paramArrayList.get(paramInt1 + i)).get(0)).FoT;
              if ((localObject1 != null) && (((com.tencent.mm.plugin.story.f.d.j)localObject1).username != null) && (Fue != null))
              {
                Object localObject2 = Fue;
                if ((localObject2 != null) && (((List)localObject2).contains(((com.tencent.mm.plugin.story.f.d.j)localObject1).username) == true))
                {
                  localObject2 = s.Fny;
                  localObject1 = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
                  if (!((n)localObject1).frQ())
                  {
                    if (((n)localObject1).field_totalSize <= 0) {
                      break label576;
                    }
                    float f = ((n)localObject1).field_cacheSize / ((n)localObject1).field_totalSize;
                    localObject1 = m.FHB;
                    if (f * 100.0F < m.fsu().FFU) {
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
                    com.tencent.mm.plugin.report.service.h.CyF.n(988L, 80L, 1L);
                  }
                  label483:
                  if (i != 0) {
                    break label626;
                  }
                  com.tencent.mm.plugin.report.service.h.CyF.n(988L, 84L, 1L);
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
              com.tencent.mm.plugin.report.service.h.CyF.n(988L, 91L, 1L);
              break;
            }
            if (i == 3)
            {
              com.tencent.mm.plugin.report.service.h.CyF.n(988L, 92L, 1L);
              break;
            }
            if (i < 4) {
              break;
            }
            com.tencent.mm.plugin.report.service.h.CyF.n(988L, 93L, 1L);
            break;
            label576:
            j = 0;
            break label459;
            label582:
            if (i == 1)
            {
              com.tencent.mm.plugin.report.service.h.CyF.n(988L, 81L, 1L);
              break label483;
            }
            if (i != 2) {
              break label483;
            }
            com.tencent.mm.plugin.report.service.h.CyF.n(988L, 82L, 1L);
            break label483;
            label626:
            if (i == 1) {
              com.tencent.mm.plugin.report.service.h.CyF.n(988L, 85L, 1L);
            } else if (i == 2) {
              com.tencent.mm.plugin.report.service.h.CyF.n(988L, 86L, 1L);
            }
          }
        }
        else if (paramInt2 != FtI)
        {
          if (j != 0) {
            com.tencent.mm.plugin.report.service.h.CyF.n(988L, 44L, 1L);
          }
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 45L, 1L);
          i = paramInt2 - FtI;
          if (i != 1) {
            break label752;
          }
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 94L, 1L);
        }
      }
      for (;;)
      {
        label734:
        fpR();
        FtI = paramInt2;
        FtH = paramInt1;
        AppMethodBeat.o(119411);
        return;
        label752:
        if (i == 2) {
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 95L, 1L);
        } else if (i == 3) {
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 96L, 1L);
        } else if (i >= 4) {
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 97L, 1L);
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
  
  public static void fpN()
  {
    AppMethodBeat.i(119415);
    Log.v("MicroMsg.StoryBrowseIDKeyStat", "makeResumeTime onResumeTime " + FtA + " onPlayUser " + FtB);
    FtA = Util.nowMilliSecond();
    AppMethodBeat.o(119415);
  }
  
  public static void fpO()
  {
    AppMethodBeat.i(119417);
    FtG = Util.nowMilliSecond();
    AppMethodBeat.o(119417);
  }
  
  public static void fpP()
  {
    AppMethodBeat.i(119406);
    Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightHasCache");
    FtY = true;
    com.tencent.mm.plugin.report.service.h.CyF.n(988L, 11L, 1L);
    AppMethodBeat.o(119406);
  }
  
  public static void fpQ()
  {
    AppMethodBeat.i(119407);
    Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckHasCache");
    FtY = true;
    com.tencent.mm.plugin.report.service.h.CyF.n(988L, 12L, 1L);
    AppMethodBeat.o(119407);
  }
  
  private static void fpR()
  {
    AppMethodBeat.i(119412);
    Log.v("MicroMsg.StoryBrowseIDKeyStat", "checkStayTime1 onStayTime " + FtM + " hasStartHttp " + Fud + " onPlayCostTime: " + FtZ);
    if ((FtM == 0L) && (Fud))
    {
      if (FtZ == 0L)
      {
        FtM = Util.milliSecondsToNow(FtA);
        com.tencent.mm.plugin.report.service.h.CyF.n(988L, 63L, 1L);
        com.tencent.mm.plugin.report.service.h.CyF.n(988L, 62L, FtM);
        AppMethodBeat.o(119412);
        return;
      }
      FtM = Util.milliSecondsToNow(Fuc);
      com.tencent.mm.plugin.report.service.h.CyF.n(988L, 61L, 1L);
      com.tencent.mm.plugin.report.service.h.CyF.n(988L, 60L, FtM);
    }
    AppMethodBeat.o(119412);
  }
  
  public static void fpS()
  {
    AppMethodBeat.i(119414);
    if (FtG <= 0L)
    {
      AppMethodBeat.o(119414);
      return;
    }
    Log.i("MicroMsg.StoryBrowseIDKeyStat", "startHttp");
    Fud = true;
    AppMethodBeat.o(119414);
  }
  
  public static void hv(List<String> paramList)
  {
    AppMethodBeat.i(119405);
    p.h(paramList, "unreadList");
    Fue = paramList;
    AppMethodBeat.o(119405);
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(119413);
    if (FtG <= 0L)
    {
      AppMethodBeat.o(119413);
      return;
    }
    fpR();
    AppMethodBeat.o(119413);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "", "user", "", "scene", "", "(Ljava/lang/String;I)V", "getScene", "()I", "getUser", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a
  {
    final String dWq;
    final int scene;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(119403);
      this.dWq = paramString;
      this.scene = paramInt;
      AppMethodBeat.o(119403);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.c
 * JD-Core Version:    0.7.0.1
 */