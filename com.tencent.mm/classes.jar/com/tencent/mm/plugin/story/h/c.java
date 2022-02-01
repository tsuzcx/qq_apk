package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.ui.view.gallery.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat;", "", "()V", "ID", "", "TAG", "", "canReport", "", "currentUser", "Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "enterFromDoubleClick", "enterWithCache", "hasStartHttp", "hascanPlayCall", "isWaiting", "last_selectedColumn", "", "last_selectedRow", "markStoryId", "noCachecurrentUser", "onCreateTime", "onPlayCostTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStayTime", "onVideoPlay", "unReadList", "", "canPlay", "", "user", "storyId", "chattingDoubleCheck", "chattingDoubleCheckHasCache", "chattingDoubleCheckNoCache", "chattingRight", "chattingRightHasCache", "chattingRightNoCache", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkStayTime", "clean", "enter", "unreadList", "finish", "markInit", "markResumeTime", "onDestroy", "onSelectItem", "group", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "selectedRow", "selectedColumn", "onVideoWaiting", "playUser", "preLoadVideo", "startHttp", "CurrentPlayer", "plugin-story_release"})
public final class c
{
  private static long LNC;
  private static long LND;
  private static int LNI;
  private static int LNJ;
  private static boolean LNK;
  private static long LNN;
  public static a LNX;
  private static a LNY;
  private static boolean LNZ;
  private static long LOa;
  private static boolean LOb;
  public static boolean LOc;
  private static long LOd;
  private static boolean LOe;
  private static List<String> LOf;
  public static final c LOg;
  private static boolean isWaiting;
  private static boolean jWq;
  private static long zUI;
  private static long zUJ;
  
  static
  {
    AppMethodBeat.i(119418);
    LOg = new c();
    AppMethodBeat.o(119418);
  }
  
  public static void RH(long paramLong)
  {
    LNC = paramLong;
  }
  
  public static void RJ(long paramLong)
  {
    if (zUI <= 0L) {}
    while ((paramLong == 0L) || (paramLong != LNC) || (LOa > 0L) || (zUJ <= 0L)) {
      return;
    }
    isWaiting = true;
  }
  
  public static void RK(long paramLong)
  {
    AppMethodBeat.i(119410);
    if (zUI <= 0L)
    {
      AppMethodBeat.o(119410);
      return;
    }
    LOb = true;
    if (LOa <= 0L) {
      Log.v("MicroMsg.StoryBrowseIDKeyStat", "storyId  " + paramLong + " markStoryId " + LNC + " onPlayCostTime " + LOa + " onResumeTime " + zUJ + "  onPlayUser " + LND);
    }
    if ((paramLong != 0L) && (paramLong == LNC) && (LOa <= 0L) && (zUJ > 0L))
    {
      LOa = Util.milliSecondsToNow(zUJ);
      LOd = Util.nowMilliSecond();
      Log.i("MicroMsg.StoryBrowseIDKeyStat", "canPlay " + LOa);
      isWaiting = false;
      if (LOc) {
        if (LNZ)
        {
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 32L, LOa);
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 33L, 1L);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.IzE.p(988L, 71L, LOa);
        com.tencent.mm.plugin.report.service.h.IzE.p(988L, 70L, 1L);
        if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext())))
        {
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 73L, LOa);
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 72L, 1L);
        }
        if (LOa > 400L) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.IzE.p(988L, 100L, LOa);
        AppMethodBeat.o(119410);
        return;
        com.tencent.mm.plugin.report.service.h.IzE.p(988L, 36L, LOa);
        com.tencent.mm.plugin.report.service.h.IzE.p(988L, 37L, 1L);
        continue;
        if (LNZ)
        {
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 30L, LOa);
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 31L, 1L);
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 34L, LOa);
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 35L, 1L);
        }
      }
      if (LOa <= 800L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.p(988L, 101L, LOa);
        AppMethodBeat.o(119410);
        return;
      }
      if (LOa <= 1600L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.p(988L, 102L, LOa);
        AppMethodBeat.o(119410);
        return;
      }
      if (LOa <= 3200L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.p(988L, 103L, LOa);
        AppMethodBeat.o(119410);
        return;
      }
      if (LOa <= 5000L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.p(988L, 104L, LOa);
        AppMethodBeat.o(119410);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.p(988L, 105L, LOa);
    }
    AppMethodBeat.o(119410);
  }
  
  public static void bdo(String paramString)
  {
    AppMethodBeat.i(119408);
    p.k(paramString, "user");
    Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightNoCache ".concat(String.valueOf(paramString)));
    LNZ = false;
    LNY = new a(paramString, 1);
    com.tencent.mm.plugin.report.service.h.IzE.p(988L, 15L, 1L);
    AppMethodBeat.o(119408);
  }
  
  public static void bdp(String paramString)
  {
    AppMethodBeat.i(119409);
    p.k(paramString, "user");
    Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckNoCache ".concat(String.valueOf(paramString)));
    LNZ = false;
    LNY = new a(paramString, 2);
    com.tencent.mm.plugin.report.service.h.IzE.p(988L, 16L, 1L);
    AppMethodBeat.o(119409);
  }
  
  public static void bx(String paramString, long paramLong)
  {
    AppMethodBeat.i(119416);
    p.k(paramString, "user");
    if (zUI <= 0L)
    {
      AppMethodBeat.o(119416);
      return;
    }
    if (LNC != paramLong)
    {
      LNC = 0L;
      Log.i("MicroMsg.StoryBrowseIDKeyStat", "reset storyId markStoryId: " + LNC + " storyId " + paramLong);
      AppMethodBeat.o(119416);
      return;
    }
    LND = Util.nowMilliSecond();
    Log.v("MicroMsg.StoryBrowseIDKeyStat", "playUser onResumeTime " + LND);
    a locala = LNY;
    if ((locala != null) && (p.h(locala.fPV, paramString)))
    {
      Object localObject = com.tencent.mm.plugin.story.f.j.LGA;
      localObject = j.b.gcx().bcW(paramString);
      Log.i("MicroMsg.StoryBrowseIDKeyStat", "preLoadCache > 0 then " + paramString + " preload " + Util.getSizeKB(((f)localObject).gfU()) + " canPlay: " + LOb);
      if (((f)localObject).gfU() > 0L)
      {
        if (locala.scene != 1) {
          break label260;
        }
        com.tencent.mm.plugin.report.service.h.IzE.p(988L, 21L, 1L);
        if (LOb) {
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 27L, 1L);
        }
      }
    }
    for (;;)
    {
      LNX = null;
      LNY = null;
      AppMethodBeat.o(119416);
      return;
      label260:
      if (locala.scene == 2)
      {
        com.tencent.mm.plugin.report.service.h.IzE.p(988L, 22L, 1L);
        if (LOb) {
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 28L, 1L);
        }
      }
    }
  }
  
  public static void clean()
  {
    AppMethodBeat.i(119404);
    LOc = false;
    jWq = true;
    zUJ = 0L;
    LOb = false;
    LOa = 0L;
    LND = 0L;
    zUI = 0L;
    LNK = false;
    LNI = -1;
    LNJ = -1;
    LNN = 0L;
    LOe = false;
    isWaiting = false;
    LOf = (List)new ArrayList();
    LNX = new a("", 1);
    AppMethodBeat.o(119404);
  }
  
  public static void d(ArrayList<ArrayList<com.tencent.mm.plugin.story.f.d.h>> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119411);
    p.k(paramArrayList, "group");
    if (zUI <= 0L)
    {
      AppMethodBeat.o(119411);
      return;
    }
    Log.v("MicroMsg.StoryBrowseIDKeyStat", " last_selectedColumn:" + LNJ + ",last_selectedRow:" + LNI + " selectedRow:" + paramInt1 + ",selectedColumn:" + paramInt2);
    int i;
    int j;
    if (paramArrayList.size() > 0) {
      if ((((ArrayList)paramArrayList.get(paramInt1)).size() > 0) && (paramInt2 + 1 < ((ArrayList)paramArrayList.get(paramInt1)).size()))
      {
        if (!LNK) {
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 42L, 1L);
        }
        i = 1;
        if (paramInt1 + 1 < paramArrayList.size())
        {
          if (!LNK) {
            com.tencent.mm.plugin.report.service.h.IzE.p(988L, 43L, 1L);
          }
          j = 1;
          label176:
          LNK = true;
        }
      }
    }
    for (;;)
    {
      if ((LNJ != -1) && (LNI != -1))
      {
        if (isWaiting)
        {
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 40L, 1L);
          isWaiting = false;
        }
        if (paramInt1 != LNI)
        {
          if (i != 0) {
            com.tencent.mm.plugin.report.service.h.IzE.p(988L, 46L, 1L);
          }
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 47L, 1L);
          i = paramInt1 - LNI;
          if (i == 1)
          {
            com.tencent.mm.plugin.report.service.h.IzE.p(988L, 90L, 1L);
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
              Object localObject1 = ((com.tencent.mm.plugin.story.f.d.h)((ArrayList)paramArrayList.get(paramInt1 + i)).get(0)).LIV;
              if ((localObject1 != null) && (((com.tencent.mm.plugin.story.f.d.j)localObject1).username != null) && (LOf != null))
              {
                Object localObject2 = LOf;
                if ((localObject2 != null) && (((List)localObject2).contains(((com.tencent.mm.plugin.story.f.d.j)localObject1).username) == true))
                {
                  localObject2 = s.LHA;
                  localObject1 = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
                  if (!((n)localObject1).ggm())
                  {
                    if (((n)localObject1).field_totalSize <= 0) {
                      break label576;
                    }
                    float f = ((n)localObject1).field_cacheSize / ((n)localObject1).field_totalSize;
                    localObject1 = m.MbB;
                    if (f * 100.0F < m.ggS().LZU) {
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
                    com.tencent.mm.plugin.report.service.h.IzE.p(988L, 80L, 1L);
                  }
                  label483:
                  if (i != 0) {
                    break label626;
                  }
                  com.tencent.mm.plugin.report.service.h.IzE.p(988L, 84L, 1L);
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
              com.tencent.mm.plugin.report.service.h.IzE.p(988L, 91L, 1L);
              break;
            }
            if (i == 3)
            {
              com.tencent.mm.plugin.report.service.h.IzE.p(988L, 92L, 1L);
              break;
            }
            if (i < 4) {
              break;
            }
            com.tencent.mm.plugin.report.service.h.IzE.p(988L, 93L, 1L);
            break;
            label576:
            j = 0;
            break label459;
            label582:
            if (i == 1)
            {
              com.tencent.mm.plugin.report.service.h.IzE.p(988L, 81L, 1L);
              break label483;
            }
            if (i != 2) {
              break label483;
            }
            com.tencent.mm.plugin.report.service.h.IzE.p(988L, 82L, 1L);
            break label483;
            label626:
            if (i == 1) {
              com.tencent.mm.plugin.report.service.h.IzE.p(988L, 85L, 1L);
            } else if (i == 2) {
              com.tencent.mm.plugin.report.service.h.IzE.p(988L, 86L, 1L);
            }
          }
        }
        else if (paramInt2 != LNJ)
        {
          if (j != 0) {
            com.tencent.mm.plugin.report.service.h.IzE.p(988L, 44L, 1L);
          }
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 45L, 1L);
          i = paramInt2 - LNJ;
          if (i != 1) {
            break label752;
          }
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 94L, 1L);
        }
      }
      for (;;)
      {
        label734:
        gem();
        LNJ = paramInt2;
        LNI = paramInt1;
        AppMethodBeat.o(119411);
        return;
        label752:
        if (i == 2) {
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 95L, 1L);
        } else if (i == 3) {
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 96L, 1L);
        } else if (i >= 4) {
          com.tencent.mm.plugin.report.service.h.IzE.p(988L, 97L, 1L);
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
  
  public static void geh()
  {
    AppMethodBeat.i(119415);
    Log.v("MicroMsg.StoryBrowseIDKeyStat", "makeResumeTime onResumeTime " + zUJ + " onPlayUser " + LND);
    zUJ = Util.nowMilliSecond();
    AppMethodBeat.o(119415);
  }
  
  public static void gei()
  {
    AppMethodBeat.i(119417);
    zUI = Util.nowMilliSecond();
    AppMethodBeat.o(119417);
  }
  
  public static void gek()
  {
    AppMethodBeat.i(119406);
    Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightHasCache");
    LNZ = true;
    com.tencent.mm.plugin.report.service.h.IzE.p(988L, 11L, 1L);
    AppMethodBeat.o(119406);
  }
  
  public static void gel()
  {
    AppMethodBeat.i(119407);
    Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckHasCache");
    LNZ = true;
    com.tencent.mm.plugin.report.service.h.IzE.p(988L, 12L, 1L);
    AppMethodBeat.o(119407);
  }
  
  private static void gem()
  {
    AppMethodBeat.i(119412);
    Log.v("MicroMsg.StoryBrowseIDKeyStat", "checkStayTime1 onStayTime " + LNN + " hasStartHttp " + LOe + " onPlayCostTime: " + LOa);
    if ((LNN == 0L) && (LOe))
    {
      if (LOa == 0L)
      {
        LNN = Util.milliSecondsToNow(zUJ);
        com.tencent.mm.plugin.report.service.h.IzE.p(988L, 63L, 1L);
        com.tencent.mm.plugin.report.service.h.IzE.p(988L, 62L, LNN);
        AppMethodBeat.o(119412);
        return;
      }
      LNN = Util.milliSecondsToNow(LOd);
      com.tencent.mm.plugin.report.service.h.IzE.p(988L, 61L, 1L);
      com.tencent.mm.plugin.report.service.h.IzE.p(988L, 60L, LNN);
    }
    AppMethodBeat.o(119412);
  }
  
  public static void gen()
  {
    AppMethodBeat.i(119414);
    if (zUI <= 0L)
    {
      AppMethodBeat.o(119414);
      return;
    }
    Log.i("MicroMsg.StoryBrowseIDKeyStat", "startHttp");
    LOe = true;
    AppMethodBeat.o(119414);
  }
  
  public static void ie(List<String> paramList)
  {
    AppMethodBeat.i(119405);
    p.k(paramList, "unreadList");
    LOf = paramList;
    AppMethodBeat.o(119405);
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(119413);
    if (zUI <= 0L)
    {
      AppMethodBeat.o(119413);
      return;
    }
    gem();
    AppMethodBeat.o(119413);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "", "user", "", "scene", "", "(Ljava/lang/String;I)V", "getScene", "()I", "getUser", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a
  {
    final String fPV;
    final int scene;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(119403);
      this.fPV = paramString;
      this.scene = paramInt;
      AppMethodBeat.o(119403);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.c
 * JD-Core Version:    0.7.0.1
 */