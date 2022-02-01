package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat;", "", "()V", "ID", "", "TAG", "", "canReport", "", "currentUser", "Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "enterFromDoubleClick", "enterWithCache", "hasStartHttp", "hascanPlayCall", "isWaiting", "last_selectedColumn", "", "last_selectedRow", "markStoryId", "noCachecurrentUser", "onCreateTime", "onPlayCostTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStayTime", "onVideoPlay", "unReadList", "", "canPlay", "", "user", "storyId", "chattingDoubleCheck", "chattingDoubleCheckHasCache", "chattingDoubleCheckNoCache", "chattingRight", "chattingRightHasCache", "chattingRightNoCache", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkStayTime", "clean", "enter", "unreadList", "finish", "markInit", "markResumeTime", "onDestroy", "onSelectItem", "group", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "selectedRow", "selectedColumn", "onVideoWaiting", "playUser", "preLoadVideo", "startHttp", "CurrentPlayer", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static long Fpo;
  private static long Fpp;
  private static long SqC;
  public static final c SqL;
  public static a SqM;
  private static a SqN;
  private static boolean SqO;
  private static long SqP;
  private static boolean SqQ;
  public static boolean SqR;
  private static long SqS;
  private static boolean SqT;
  private static List<String> SqU;
  private static long Sqr;
  private static long Sqs;
  private static int Sqx;
  private static int Sqy;
  private static boolean Sqz;
  private static boolean isWaiting;
  private static boolean mwk;
  
  static
  {
    AppMethodBeat.i(119418);
    SqL = new c();
    AppMethodBeat.o(119418);
  }
  
  public static void bJ(String paramString, long paramLong)
  {
    AppMethodBeat.i(119416);
    s.u(paramString, "user");
    if (Fpo <= 0L)
    {
      AppMethodBeat.o(119416);
      return;
    }
    if (Sqr != paramLong)
    {
      Sqr = 0L;
      Log.i("MicroMsg.StoryBrowseIDKeyStat", "reset storyId markStoryId: " + Sqr + " storyId " + paramLong);
      AppMethodBeat.o(119416);
      return;
    }
    Sqs = Util.nowMilliSecond();
    Log.v("MicroMsg.StoryBrowseIDKeyStat", s.X("playUser onResumeTime ", Long.valueOf(Sqs)));
    a locala = SqN;
    if ((locala != null) && (s.p(locala.hVQ, paramString)))
    {
      Object localObject = StoryCore.SjP;
      localObject = StoryCore.b.hvS().bbJ(paramString);
      Log.i("MicroMsg.StoryBrowseIDKeyStat", "preLoadCache > 0 then " + paramString + " preload " + Util.getSizeKB(((f)localObject).hzl()) + " canPlay: " + SqQ);
      if (((f)localObject).hzl() > 0L)
      {
        if (locala.scene != 1) {
          break label242;
        }
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 21L, 1L);
        if (SqQ) {
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 27L, 1L);
        }
      }
    }
    for (;;)
    {
      SqM = null;
      SqN = null;
      AppMethodBeat.o(119416);
      return;
      label242:
      if (locala.scene == 2)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 22L, 1L);
        if (SqQ) {
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 28L, 1L);
        }
      }
    }
  }
  
  public static void bcb(String paramString)
  {
    AppMethodBeat.i(119408);
    s.u(paramString, "user");
    Log.i("MicroMsg.StoryBrowseIDKeyStat", s.X("chattingRightNoCache ", paramString));
    SqO = false;
    SqN = new a(paramString, 1);
    com.tencent.mm.plugin.report.service.h.OAn.p(988L, 15L, 1L);
    AppMethodBeat.o(119408);
  }
  
  public static void bcc(String paramString)
  {
    AppMethodBeat.i(119409);
    s.u(paramString, "user");
    Log.i("MicroMsg.StoryBrowseIDKeyStat", s.X("chattingDoubleCheckNoCache ", paramString));
    SqO = false;
    SqN = new a(paramString, 2);
    com.tencent.mm.plugin.report.service.h.OAn.p(988L, 16L, 1L);
    AppMethodBeat.o(119409);
  }
  
  public static void clean()
  {
    AppMethodBeat.i(119404);
    SqR = false;
    mwk = true;
    Fpp = 0L;
    SqQ = false;
    SqP = 0L;
    Sqs = 0L;
    Fpo = 0L;
    Sqz = false;
    Sqx = -1;
    Sqy = -1;
    SqC = 0L;
    SqT = false;
    isWaiting = false;
    SqU = (List)new ArrayList();
    SqM = new a("", 1);
    AppMethodBeat.o(119404);
  }
  
  public static void g(ArrayList<ArrayList<com.tencent.mm.plugin.story.model.d.h>> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119411);
    s.u(paramArrayList, "group");
    if (Fpo <= 0L)
    {
      AppMethodBeat.o(119411);
      return;
    }
    Log.v("MicroMsg.StoryBrowseIDKeyStat", " last_selectedColumn:" + Sqy + ",last_selectedRow:" + Sqx + " selectedRow:" + paramInt1 + ",selectedColumn:" + paramInt2);
    int i;
    int j;
    if (paramArrayList.size() > 0) {
      if ((((ArrayList)paramArrayList.get(paramInt1)).size() > 0) && (paramInt2 + 1 < ((ArrayList)paramArrayList.get(paramInt1)).size()))
      {
        if (!Sqz) {
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 42L, 1L);
        }
        i = 1;
        if (paramInt1 + 1 < paramArrayList.size())
        {
          if (!Sqz) {
            com.tencent.mm.plugin.report.service.h.OAn.p(988L, 43L, 1L);
          }
          j = 1;
          label176:
          Sqz = true;
        }
      }
    }
    for (;;)
    {
      if ((Sqy != -1) && (Sqx != -1))
      {
        if (isWaiting)
        {
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 40L, 1L);
          isWaiting = false;
        }
        if (paramInt1 == Sqx) {
          break label726;
        }
        if (i != 0) {
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 46L, 1L);
        }
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 47L, 1L);
        i = paramInt1 - Sqx;
        if (i != 1) {
          break label552;
        }
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 90L, 1L);
        if (paramArrayList.size() <= 0) {}
      }
      int k;
      for (i = 0;; i = k)
      {
        k = i + 1;
        if ((paramInt1 + i < paramArrayList.size()) && (((ArrayList)paramArrayList.get(paramInt1 + i)).size() > 0))
        {
          Object localObject1 = ((com.tencent.mm.plugin.story.model.d.h)((ArrayList)paramArrayList.get(paramInt1 + i)).get(0)).Smr;
          if ((localObject1 != null) && (((com.tencent.mm.plugin.story.model.d.j)localObject1).username != null) && (SqU != null))
          {
            Object localObject2 = SqU;
            if ((localObject2 == null) || (((List)localObject2).contains(((com.tencent.mm.plugin.story.model.d.j)localObject1).username) != true)) {
              break label618;
            }
            j = 1;
            label396:
            if (j != 0)
            {
              localObject2 = r.Slb;
              localObject1 = r.a((com.tencent.mm.plugin.story.model.d.j)localObject1);
              if (!((n)localObject1).hzD())
              {
                if (((n)localObject1).field_totalSize <= 0) {
                  break label624;
                }
                float f = ((n)localObject1).field_cacheSize / ((n)localObject1).field_totalSize;
                localObject1 = com.tencent.mm.plugin.story.ui.view.gallery.j.SCD;
                if (f * 100.0F < com.tencent.mm.plugin.story.ui.view.gallery.j.hAl().SBq) {
                  break label624;
                }
              }
              j = 1;
              label467:
              if (j != 1) {}
            }
          }
        }
        switch (i)
        {
        default: 
          label528:
          switch (i)
          {
          default: 
            label500:
            if (k < 3) {
              continue;
            }
          }
          break;
        }
        for (;;)
        {
          hxF();
          Sqy = paramInt2;
          Sqx = paramInt1;
          AppMethodBeat.o(119411);
          return;
          label552:
          if (i == 2)
          {
            com.tencent.mm.plugin.report.service.h.OAn.p(988L, 91L, 1L);
            break;
          }
          if (i == 3)
          {
            com.tencent.mm.plugin.report.service.h.OAn.p(988L, 92L, 1L);
            break;
          }
          if (i < 4) {
            break;
          }
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 93L, 1L);
          break;
          label618:
          j = 0;
          break label396;
          label624:
          j = 0;
          break label467;
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 80L, 1L);
          break label500;
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 81L, 1L);
          break label500;
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 82L, 1L);
          break label500;
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 84L, 1L);
          break label528;
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 85L, 1L);
          break label528;
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 86L, 1L);
          break label528;
          label726:
          if (paramInt2 != Sqy)
          {
            if (j != 0) {
              com.tencent.mm.plugin.report.service.h.OAn.p(988L, 44L, 1L);
            }
            com.tencent.mm.plugin.report.service.h.OAn.p(988L, 45L, 1L);
            i = paramInt2 - Sqy;
            if (i == 1) {
              com.tencent.mm.plugin.report.service.h.OAn.p(988L, 94L, 1L);
            } else if (i == 2) {
              com.tencent.mm.plugin.report.service.h.OAn.p(988L, 95L, 1L);
            } else if (i == 3) {
              com.tencent.mm.plugin.report.service.h.OAn.p(988L, 96L, 1L);
            } else if (i >= 4) {
              com.tencent.mm.plugin.report.service.h.OAn.p(988L, 97L, 1L);
            }
          }
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
  
  public static void hxA()
  {
    AppMethodBeat.i(119415);
    Log.v("MicroMsg.StoryBrowseIDKeyStat", "makeResumeTime onResumeTime " + Fpp + " onPlayUser " + Sqs);
    Fpp = Util.nowMilliSecond();
    AppMethodBeat.o(119415);
  }
  
  public static void hxB()
  {
    AppMethodBeat.i(119417);
    Fpo = Util.nowMilliSecond();
    AppMethodBeat.o(119417);
  }
  
  public static void hxD()
  {
    AppMethodBeat.i(119406);
    Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightHasCache");
    SqO = true;
    com.tencent.mm.plugin.report.service.h.OAn.p(988L, 11L, 1L);
    AppMethodBeat.o(119406);
  }
  
  public static void hxE()
  {
    AppMethodBeat.i(119407);
    Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckHasCache");
    SqO = true;
    com.tencent.mm.plugin.report.service.h.OAn.p(988L, 12L, 1L);
    AppMethodBeat.o(119407);
  }
  
  private static void hxF()
  {
    AppMethodBeat.i(119412);
    Log.v("MicroMsg.StoryBrowseIDKeyStat", "checkStayTime1 onStayTime " + SqC + " hasStartHttp " + SqT + " onPlayCostTime: " + SqP);
    if ((SqC == 0L) && (SqT))
    {
      if (SqP == 0L)
      {
        SqC = Util.milliSecondsToNow(Fpp);
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 63L, 1L);
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 62L, SqC);
        AppMethodBeat.o(119412);
        return;
      }
      SqC = Util.milliSecondsToNow(SqS);
      com.tencent.mm.plugin.report.service.h.OAn.p(988L, 61L, 1L);
      com.tencent.mm.plugin.report.service.h.OAn.p(988L, 60L, SqC);
    }
    AppMethodBeat.o(119412);
  }
  
  public static void hxG()
  {
    AppMethodBeat.i(119414);
    if (Fpo <= 0L)
    {
      AppMethodBeat.o(119414);
      return;
    }
    Log.i("MicroMsg.StoryBrowseIDKeyStat", "startHttp");
    SqT = true;
    AppMethodBeat.o(119414);
  }
  
  public static void lk(List<String> paramList)
  {
    AppMethodBeat.i(119405);
    s.u(paramList, "unreadList");
    SqU = paramList;
    AppMethodBeat.o(119405);
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(119413);
    if (Fpo <= 0L)
    {
      AppMethodBeat.o(119413);
      return;
    }
    hxF();
    AppMethodBeat.o(119413);
  }
  
  public static void vQ(long paramLong)
  {
    Sqr = paramLong;
  }
  
  public static void vS(long paramLong)
  {
    if (Fpo <= 0L) {}
    while ((paramLong == 0L) || (paramLong != Sqr) || (SqP > 0L) || (Fpp <= 0L)) {
      return;
    }
    isWaiting = true;
  }
  
  public static void vT(long paramLong)
  {
    AppMethodBeat.i(119410);
    if (Fpo <= 0L)
    {
      AppMethodBeat.o(119410);
      return;
    }
    SqQ = true;
    if (SqP <= 0L) {
      Log.v("MicroMsg.StoryBrowseIDKeyStat", "storyId  " + paramLong + " markStoryId " + Sqr + " onPlayCostTime " + SqP + " onResumeTime " + Fpp + "  onPlayUser " + Sqs);
    }
    if ((paramLong != 0L) && (paramLong == Sqr) && (SqP <= 0L) && (Fpp > 0L))
    {
      SqP = Util.milliSecondsToNow(Fpp);
      SqS = Util.nowMilliSecond();
      Log.i("MicroMsg.StoryBrowseIDKeyStat", s.X("canPlay ", Long.valueOf(SqP)));
      isWaiting = false;
      if (SqR) {
        if (SqO)
        {
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 32L, SqP);
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 33L, 1L);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 71L, SqP);
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 70L, 1L);
        if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext())))
        {
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 73L, SqP);
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 72L, 1L);
        }
        if (SqP > 400L) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 100L, SqP);
        AppMethodBeat.o(119410);
        return;
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 36L, SqP);
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 37L, 1L);
        continue;
        if (SqO)
        {
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 30L, SqP);
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 31L, 1L);
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 34L, SqP);
          com.tencent.mm.plugin.report.service.h.OAn.p(988L, 35L, 1L);
        }
      }
      if (SqP <= 800L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 101L, SqP);
        AppMethodBeat.o(119410);
        return;
      }
      if (SqP <= 1600L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 102L, SqP);
        AppMethodBeat.o(119410);
        return;
      }
      if (SqP <= 3200L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 103L, SqP);
        AppMethodBeat.o(119410);
        return;
      }
      if (SqP <= 5000L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 104L, SqP);
        AppMethodBeat.o(119410);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.p(988L, 105L, SqP);
    }
    AppMethodBeat.o(119410);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "", "user", "", "scene", "", "(Ljava/lang/String;I)V", "getScene", "()I", "getUser", "()Ljava/lang/String;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final String hVQ;
    final int scene;
    
    public a(String paramString, int paramInt)
    {
      AppMethodBeat.i(119403);
      this.hVQ = paramString;
      this.scene = paramInt;
      AppMethodBeat.o(119403);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.c
 * JD-Core Version:    0.7.0.1
 */