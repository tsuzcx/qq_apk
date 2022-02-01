package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.a.l;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.model.d.h.a;
import com.tencent.mm.plugin.story.model.m.a;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.an;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/presenter/FavStoryPresenter;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "username", "", "dateList", "", "galleryUserCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "queryCondition", "", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;I)V", "TAG", "dateGalleryMap", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "dateState", "Lcom/tencent/mm/plugin/story/presenter/GalleryUserState;", "deleteColumnIndex", "deleteRowIndex", "enableVisitor", "", "galleryState", "isSelf", "loadingIndexQueue", "Ljava/util/LinkedList;", "selectedCol", "selectedRow", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "cancelDeleteItem", "row", "column", "deleteItem", "destroy", "initLoad", "notifyDateUpdate", "userIndex", "userGalleryItems", "onGalleryState", "state", "onItemRemovedCallback", "isOk", "onMsgListState", "index", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onSetFavoriteCallback", "favorite", "selectedDate", "success", "onSetPrivacyCallback", "isPrivacy", "preloadForUser", "setFavorite", "nowFavorite", "replaceInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "setSelectedCommentRead", "setSelectedRead", "setSelectedVisitRead", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends f
  implements com.tencent.mm.am.h
{
  private final int Siv;
  private final r<Long, Boolean, String, String, ah> SmW;
  private final List<String> Sme;
  private int SoA;
  private boolean SoB;
  private final c Sos;
  private final ArrayList<ArrayList<com.tencent.mm.plugin.story.model.d.h>> Sot;
  private final ArrayList<e> Sou;
  private final LinkedList<Integer> Sov;
  private int Sow;
  private int Sox;
  private int Soy;
  private int Soz;
  private final String TAG;
  private boolean hHq;
  private final String username;
  
  private b(String paramString, List<String> paramList, c paramc, int paramInt)
  {
    AppMethodBeat.i(119189);
    this.username = paramString;
    this.Sme = paramList;
    this.Sos = paramc;
    this.Siv = paramInt;
    this.TAG = "MicroMsg.FavStoryPresenter";
    this.Sot = new ArrayList();
    this.Sou = new ArrayList();
    this.Sov = new LinkedList();
    this.Sow = -1;
    this.Sox = -1;
    this.Soy = -1;
    this.Soz = -1;
    this.SmW = ((r)new k(this));
    paramString = StoryCore.SjP;
    this.hHq = Util.isEqual(StoryCore.b.hgg(), this.username);
    this.Sos.ang(this.Sme.size());
    paramString = ((Iterable)this.Sme).iterator();
    while (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      Log.i(this.TAG, kotlin.g.b.s.X("LogStory: ", paramList));
      this.Sot.add(new ArrayList());
      this.Sou.add(new e(paramList));
    }
    if (this.hHq) {
      com.tencent.mm.kernel.h.baD().mCm.a(764, (com.tencent.mm.am.h)this);
    }
    paramString = com.tencent.mm.plugin.story.model.b.b.SlF;
    com.tencent.mm.plugin.story.model.b.b.g(this.SmW);
    this.SoB = com.tencent.mm.plugin.story.c.a.e.Sjb.huS();
    AppMethodBeat.o(119189);
  }
  
  private final void EJ(boolean paramBoolean)
  {
    AppMethodBeat.i(119174);
    d.uiThread((kotlin.g.a.a)new c(paramBoolean, this));
    AppMethodBeat.o(119174);
  }
  
  private final void R(final int paramInt, final List<com.tencent.mm.plugin.story.model.d.h> paramList)
  {
    AppMethodBeat.i(119176);
    if (paramList.isEmpty())
    {
      Collection localCollection = (Collection)this.Sot;
      if (localCollection == null)
      {
        paramList = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(119176);
        throw paramList;
      }
      an.hA(localCollection).remove(paramList);
      d.uiThread((kotlin.g.a.a)new a(this, paramInt));
      AppMethodBeat.o(119176);
      return;
    }
    d.uiThread((kotlin.g.a.a)new b(this, paramInt, paramList));
    AppMethodBeat.o(119176);
  }
  
  private static final void a(final b paramb)
  {
    AppMethodBeat.i(367084);
    kotlin.g.b.s.u(paramb, "this$0");
    if ((paramb.Soy >= 0) && (paramb.Soy < paramb.Sot.size()) && (paramb.Soz >= 0) && (paramb.Soz < ((ArrayList)paramb.Sot.get(paramb.Soy)).size()))
    {
      Object localObject1 = ((ArrayList)paramb.Sot.get(paramb.Soy)).get(paramb.Soz);
      kotlin.g.b.s.s(localObject1, "dateGalleryMap[selectedRow][selectedCol]");
      localObject1 = ((com.tencent.mm.plugin.story.model.d.h)localObject1).Sms;
      Log.i(paramb.TAG, "setSelectedRead " + paramb.Soz + ", " + ((g)localObject1).Smi);
      if (((g)localObject1).Smm.size() > 0)
      {
        Object localObject2 = com.tencent.mm.plugin.story.model.b.b.SlF;
        long l = ((g)localObject1).idH;
        localObject2 = ((g)localObject1).Smm.getLast();
        kotlin.g.b.s.s(localObject2, "comment.visitorList.last");
        if (com.tencent.mm.plugin.story.model.b.b.b(l, (com.tencent.mm.plugin.story.model.b.a)localObject2)) {
          d.uiThread((kotlin.g.a.a)new j((g)localObject1, paramb));
        }
      }
    }
    AppMethodBeat.o(367084);
  }
  
  private static final void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(367114);
    kotlin.g.b.s.u(paramb, "this$0");
    if (((e)paramb.Sou.get(paramInt)).SoT != 2) {
      paramb.Sov.add(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(367114);
  }
  
  private static final void a(b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(367110);
    kotlin.g.b.s.u(paramb, "this$0");
    paramb.Sow = paramInt1;
    paramb.Sox = paramInt2;
    Object localObject1 = ((ArrayList)paramb.Sot.get(paramInt1)).get(paramInt2);
    kotlin.g.b.s.s(localObject1, "dateGalleryMap[row][column]");
    localObject1 = (com.tencent.mm.plugin.story.model.d.h)localObject1;
    Object localObject2 = StoryCore.SjP;
    localObject2 = StoryCore.b.hvR().anv(((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg);
    Object localObject3 = StoryCore.SjP;
    StoryCore.b.hvR().bcp(((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg + '_' + ((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.createTime);
    if (localObject2 != null)
    {
      Log.i(paramb.TAG, "LogStory: deleteItem2 storyinfo " + localObject1 + " deleteItemRow " + paramb.Sow + " deleteItemCol " + paramb.Sox + " localid " + ((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg + ' ' + ((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID);
      if (((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID == 0L) {
        break label285;
      }
      if ((paramb.Sow != -1) && (paramb.Sox != -1))
      {
        localObject3 = com.tencent.mm.plugin.story.model.m.Sks;
        m.a.aA(((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID, ((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg);
      }
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.hwL())
      {
        localObject2 = StoryCore.SjP;
        StoryCore.b.gHI().post(new b..ExternalSyntheticLambda5(paramb, (com.tencent.mm.plugin.story.model.d.h)localObject1));
      }
      AppMethodBeat.o(367110);
      return;
      label285:
      localObject2 = com.tencent.mm.plugin.story.model.m.Sks;
      m.a.anc(((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg);
      paramb.EJ(true);
    }
  }
  
  private static final void a(b paramb, com.tencent.mm.plugin.story.model.d.h paramh)
  {
    AppMethodBeat.i(367097);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramh, "$item");
    Log.i(paramb.TAG, kotlin.g.b.s.X("LogStory: deleteItem fake ", paramh));
    paramb = com.tencent.mm.plugin.story.model.m.Sks;
    m.a.anc(paramh.Smr.icg);
    paramb = com.tencent.mm.plugin.story.model.e.a.SmE;
    com.tencent.mm.plugin.story.model.e.a.aSR(paramh.Smr.taskId);
    paramb = com.tencent.mm.plugin.story.model.e.a.SmE;
    com.tencent.mm.plugin.story.model.e.a.aSS(paramh.Smr.taskId);
    AppMethodBeat.o(367097);
  }
  
  private final void a(final boolean paramBoolean1, ArrayList<com.tencent.mm.plugin.story.model.d.h> paramArrayList, final boolean paramBoolean2)
  {
    AppMethodBeat.i(119175);
    if ((!paramBoolean1) && (paramArrayList != null))
    {
      final int i = this.Sot.indexOf(paramArrayList);
      this.Sot.remove(paramArrayList);
      d.uiThread((kotlin.g.a.a)new d(this, i));
    }
    d.uiThread((kotlin.g.a.a)new e(this, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(119175);
  }
  
  private static final void b(final b paramb)
  {
    AppMethodBeat.i(367092);
    kotlin.g.b.s.u(paramb, "this$0");
    if ((paramb.Soy >= 0) && (paramb.Soy < paramb.Sot.size()) && (paramb.Soz >= 0) && (paramb.Soz < ((ArrayList)paramb.Sot.get(paramb.Soy)).size()))
    {
      Object localObject1 = ((ArrayList)paramb.Sot.get(paramb.Soy)).get(paramb.Soz);
      kotlin.g.b.s.s(localObject1, "dateGalleryMap[selectedRow][selectedCol]");
      Object localObject2 = (com.tencent.mm.plugin.story.model.d.h)localObject1;
      localObject1 = ((com.tencent.mm.plugin.story.model.d.h)localObject2).Sms;
      localObject2 = ((com.tencent.mm.plugin.story.model.d.h)localObject2).Smo;
      Log.i(paramb.TAG, "setSelectedRead " + paramb.Soz + ", " + ((g)localObject1).Sly);
      if (paramb.SoB)
      {
        if ((localObject2 != null) && (((com.tencent.mm.plugin.story.h.j)localObject2).hzs()))
        {
          ((com.tencent.mm.plugin.story.h.j)localObject2).ER(false);
          localObject1 = com.tencent.mm.plugin.story.model.m.Sks;
          m.a.aB(((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID, ((com.tencent.mm.plugin.story.h.j)localObject2).field_localFlag);
          d.uiThread((kotlin.g.a.a)new h(paramb));
          AppMethodBeat.o(367092);
        }
      }
      else
      {
        if ((localObject2 != null) && (((com.tencent.mm.plugin.story.h.j)localObject2).hzs()))
        {
          ((com.tencent.mm.plugin.story.h.j)localObject2).ER(false);
          m.a locala = com.tencent.mm.plugin.story.model.m.Sks;
          m.a.aB(((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID, ((com.tencent.mm.plugin.story.h.j)localObject2).field_localFlag);
        }
        if (((g)localObject1).commentList.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.story.model.b.b.SlF;
          long l = ((g)localObject1).idH;
          localObject2 = ((g)localObject1).commentList.getLast();
          kotlin.g.b.s.s(localObject2, "comment.commentList.last");
          if (com.tencent.mm.plugin.story.model.b.b.b(l, (com.tencent.mm.plugin.story.model.b.a)localObject2)) {
            d.uiThread((kotlin.g.a.a)new i((g)localObject1, paramb));
          }
        }
      }
    }
    AppMethodBeat.o(367092);
  }
  
  private static final void c(final b paramb)
  {
    AppMethodBeat.i(367093);
    kotlin.g.b.s.u(paramb, "this$0");
    if ((paramb.Soy >= 0) && (paramb.Soy < paramb.Sot.size()) && (paramb.Soz >= 0) && (paramb.Soz < ((ArrayList)paramb.Sot.get(paramb.Soy)).size()))
    {
      Object localObject1 = ((ArrayList)paramb.Sot.get(paramb.Soy)).get(paramb.Soz);
      kotlin.g.b.s.s(localObject1, "dateGalleryMap[selectedRow][selectedCol]");
      localObject1 = ((com.tencent.mm.plugin.story.model.d.h)localObject1).Sms;
      Log.i(paramb.TAG, "setSelectedRead " + paramb.Soz + ", " + ((g)localObject1).Smj);
      if (((g)localObject1).PmC.size() > 0)
      {
        Object localObject2 = com.tencent.mm.plugin.story.model.b.b.SlF;
        long l = ((g)localObject1).idH;
        localObject2 = ((g)localObject1).PmC.getLast();
        kotlin.g.b.s.s(localObject2, "comment.msgList.last");
        if (com.tencent.mm.plugin.story.model.b.b.b(l, (com.tencent.mm.plugin.story.model.b.a)localObject2)) {
          d.uiThread((kotlin.g.a.a)new g((g)localObject1, paramb));
        }
      }
    }
    AppMethodBeat.o(367093);
  }
  
  private final void hxk()
  {
    AppMethodBeat.i(119177);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new b..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(119177);
  }
  
  private final void hxl()
  {
    AppMethodBeat.i(119178);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new b..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(119178);
  }
  
  public final void M(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(119183);
    if (paramInt1 == 3)
    {
      if (paramBoolean)
      {
        switch (paramInt2)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(119183);
          return;
          StoryCore.b localb = StoryCore.SjP;
          StoryCore.b.gHI().post(new b..ExternalSyntheticLambda1(this));
          AppMethodBeat.o(119183);
          return;
          hxl();
        }
      }
      hxl();
    }
    AppMethodBeat.o(119183);
  }
  
  public final void N(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(119186);
    Log.i(this.TAG, "LogStory: setPrivacy row:" + paramInt1 + " column:" + paramInt2);
    Object localObject1;
    Object localObject2;
    if ((paramInt1 >= 0) && (paramInt1 < this.Sme.size()) && (paramInt2 >= 0) && (paramInt2 < ((ArrayList)this.Sot.get(paramInt1)).size()))
    {
      if (paramBoolean) {
        break label251;
      }
      paramBoolean = true;
      localObject1 = ((ArrayList)this.Sot.get(paramInt1)).get(paramInt2);
      kotlin.g.b.s.s(localObject1, "dateGalleryMap[row][column]");
      localObject1 = (com.tencent.mm.plugin.story.model.d.h)localObject1;
      Log.i(this.TAG, "LogStory: setPrivacy storyinfo " + localObject1 + " targetPrivacy:" + paramBoolean);
      localObject2 = StoryCore.SjP;
      localObject1 = StoryCore.b.hvR().anv((int)((com.tencent.mm.plugin.story.model.d.h)localObject1).Smo.systemRowid);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.story.g.e.SqW;
        com.tencent.mm.plugin.story.g.e.EN(paramBoolean);
        if (!paramBoolean) {
          break label256;
        }
      }
    }
    label256:
    for (long l = 3L;; l = 4L)
    {
      localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.a(l, String.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID), 0L, 0L, 28);
      localObject2 = com.tencent.mm.plugin.story.model.m.Sks;
      m.a.c(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID, (int)((com.tencent.mm.plugin.story.h.j)localObject1).systemRowid, paramBoolean, ((com.tencent.mm.plugin.story.h.j)localObject1).hzy());
      AppMethodBeat.o(119186);
      return;
      label251:
      paramBoolean = false;
      break;
    }
  }
  
  public final void O(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(119188);
    Log.i(this.TAG, kotlin.g.b.s.X("LogStory: setFavorite ", Integer.valueOf(paramInt2)));
    Object localObject1;
    Object localObject2;
    if ((paramInt1 >= 0) && (paramInt1 < this.Sme.size()) && (paramInt2 >= 0) && (paramInt2 < ((ArrayList)this.Sot.get(paramInt1)).size()))
    {
      if (paramBoolean) {
        break label290;
      }
      paramBoolean = true;
      localObject1 = ((ArrayList)this.Sot.get(paramInt1)).get(paramInt2);
      kotlin.g.b.s.s(localObject1, "dateGalleryMap[row][column]");
      localObject1 = (com.tencent.mm.plugin.story.model.d.h)localObject1;
      Log.i(this.TAG, "LogStory: setFavorite storyinfo " + localObject1 + " localid " + ((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg + " targetFavorite:" + paramBoolean);
      localObject2 = StoryCore.SjP;
      localObject1 = StoryCore.b.hvR().anv((int)((com.tencent.mm.plugin.story.model.d.h)localObject1).Smo.systemRowid);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.story.g.e.SqW;
        com.tencent.mm.plugin.story.g.e.EM(paramBoolean);
        if (!paramBoolean) {
          break label295;
        }
      }
    }
    label290:
    label295:
    for (long l = 1L;; l = 2L)
    {
      localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.a(l, String.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID), 0L, 0L, 28);
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      ((ArrayList)localObject2).add(Long.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID));
      localArrayList.add(Integer.valueOf((int)((com.tencent.mm.plugin.story.h.j)localObject1).systemRowid));
      localObject1 = com.tencent.mm.plugin.story.model.m.Sks;
      m.a.b((List)localObject2, (List)localArrayList, paramBoolean);
      AppMethodBeat.o(119188);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  public final void anf(int paramInt)
  {
    AppMethodBeat.i(119184);
    this.SoA = paramInt;
    if ((this.SoA == 1) && (!this.SoB)) {
      hxk();
    }
    AppMethodBeat.o(119184);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(119180);
    if (this.hHq) {
      com.tencent.mm.kernel.h.baD().mCm.b(764, (com.tencent.mm.am.h)this);
    }
    com.tencent.mm.plugin.story.model.b.b localb = com.tencent.mm.plugin.story.model.b.b.SlF;
    com.tencent.mm.plugin.story.model.b.b.h(this.SmW);
    AppMethodBeat.o(119180);
  }
  
  public final void hxm()
  {
    AppMethodBeat.i(119179);
    this.Sow = -1;
    this.Sox = -1;
    m.a locala = com.tencent.mm.plugin.story.model.m.Sks;
    m.a.hwj();
    AppMethodBeat.o(119179);
  }
  
  public final void hxn()
  {
    int j = 0;
    AppMethodBeat.i(119181);
    Object localObject1 = ((Iterable)this.Sme).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      ((e)this.Sou.get(i)).SoT = 1;
      i += 1;
    }
    Object localObject2 = this.username;
    kotlin.g.b.s.u(localObject2, "username");
    localObject1 = new ArrayList();
    Object localObject3 = StoryCore.SjP;
    localObject3 = StoryCore.b.hvR();
    Object localObject4 = StoryCore.SjP;
    localObject3 = ((com.tencent.mm.plugin.story.h.k)localObject3).ds((String)localObject2, Util.isEqual((String)localObject2, StoryCore.b.hgg())).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (com.tencent.mm.plugin.story.h.j)((Iterator)localObject3).next();
      fjj localfjj = ((com.tencent.mm.plugin.story.h.j)localObject4).hzt();
      if ((localfjj.abJZ != null) && (localfjj.abJZ.Zpr.size() != 0))
      {
        h.a locala = com.tencent.mm.plugin.story.model.d.h.Smn;
        kotlin.g.b.s.s(localObject4, "story");
        ((ArrayList)localObject1).add(h.a.b((com.tencent.mm.plugin.story.h.j)localObject4));
        Log.i(f.access$getTAG$cp(), "getFavGalleryItemsFromDb story username " + (String)localObject2 + ' ' + ((ArrayList)localObject1).size() + " content " + ((fis)localfjj.abJZ.Zpr.get(0)).aaTl + " and " + ((fis)localfjj.abJZ.Zpr.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.h.j)localObject4).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.h.j)localObject4).field_userName);
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      localObject2 = ((Iterable)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        localObject3 = (com.tencent.mm.plugin.story.model.d.h)localObject3;
        if (i < this.Sot.size()) {
          ((ArrayList)this.Sot.get(i)).add(localObject3);
        }
        i += 1;
      }
      Log.i(this.TAG, kotlin.g.b.s.X("LogStory: preload Db data ", Integer.valueOf(((ArrayList)localObject1).size())));
    }
    for (;;)
    {
      localObject1 = ((Iterable)this.Sme).iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        ((Iterator)localObject1).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        if (this.Sot.size() > i)
        {
          localObject2 = this.Sot.get(i);
          kotlin.g.b.s.s(localObject2, "dateGalleryMap[index]");
          R(i, (List)localObject2);
        }
        i += 1;
      }
      Log.i(this.TAG, "LogStory: initLoad no data");
    }
    AppMethodBeat.o(119181);
  }
  
  public final void ma(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119182);
    Log.i(this.TAG, kotlin.g.b.s.X("LogStory: deleteItem ", Integer.valueOf(paramInt1)));
    if ((paramInt1 >= 0) && (paramInt1 < this.Sot.size()) && (paramInt2 >= 0) && (paramInt2 < ((ArrayList)this.Sot.get(paramInt1)).size()))
    {
      StoryCore.b localb = StoryCore.SjP;
      StoryCore.b.gHI().post(new b..ExternalSyntheticLambda4(this, paramInt1, paramInt2));
    }
    AppMethodBeat.o(119182);
  }
  
  public final void mb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119185);
    Log.d(this.TAG, "onSelected row=" + paramInt1 + " column=" + paramInt2);
    this.Soy = paramInt1;
    this.Soz = paramInt2;
    if (this.SoA == 1) {
      hxk();
    }
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new b..ExternalSyntheticLambda3(this, paramInt1));
    AppMethodBeat.o(119185);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(119187);
    kotlin.g.b.s.u(paramp, "scene");
    Log.i(this.TAG, "LogStory: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString);
    if ((paramp instanceof com.tencent.mm.plugin.story.model.a.f))
    {
      com.tencent.mm.plugin.story.model.a.a locala = ((com.tencent.mm.plugin.story.model.a.f)paramp).hwE();
      if (locala != null)
      {
        if ((locala instanceof l))
        {
          if (paramInt2 == 0)
          {
            paramString = ((Iterable)((com.tencent.mm.plugin.story.model.a.f)paramp).Slm).iterator();
            while (paramString.hasNext())
            {
              paramInt1 = ((Number)paramString.next()).intValue();
              paramp = com.tencent.mm.plugin.story.model.m.Sks;
              m.a.anc(paramInt1);
            }
          }
          if (paramInt2 == 0) {}
          for (bool = true;; bool = false)
          {
            EJ(bool);
            AppMethodBeat.o(119187);
            return;
          }
        }
        if ((locala instanceof com.tencent.mm.plugin.story.model.a.m))
        {
          Log.i(this.TAG, "onSceneEnd MMSTORY_OBJ_OP_VISIBILITY_TYPE errType:" + paramInt1 + ", errcode:" + paramInt2);
          if (paramInt2 == 0)
          {
            paramString = ((Iterable)((com.tencent.mm.plugin.story.model.a.f)paramp).Slm).iterator();
            while (paramString.hasNext())
            {
              paramInt1 = ((Number)paramString.next()).intValue();
              paramp = com.tencent.mm.plugin.story.model.m.Sks;
              m.a.lY(paramInt1, ((com.tencent.mm.plugin.story.model.a.m)locala).Slw);
            }
            if ((((com.tencent.mm.plugin.story.model.a.m)locala).Slw == 1) && (!((com.tencent.mm.plugin.story.model.a.m)locala).Slx)) {}
            for (bool = true;; bool = false)
            {
              d.uiThread((kotlin.g.a.a)new f(this, bool));
              AppMethodBeat.o(119187);
              return;
            }
          }
        }
        else if ((locala instanceof com.tencent.mm.plugin.story.model.a.k))
        {
          if (paramInt2 == 0)
          {
            Iterator localIterator1 = ((Iterable)((com.tencent.mm.plugin.story.model.a.f)paramp).Slm).iterator();
            if (localIterator1.hasNext())
            {
              int j = ((Number)localIterator1.next()).intValue();
              Log.i(this.TAG, "onSceneEnd update story favorite: errType " + paramInt1 + ", errcode " + paramInt2 + ", localId " + j + ", favorite:" + ((com.tencent.mm.plugin.story.model.a.k)locala).favorite);
              paramString = com.tencent.mm.plugin.story.model.m.Sks;
              m.a.lZ(j, ((com.tencent.mm.plugin.story.model.a.k)locala).favorite);
              Iterator localIterator2 = ((Iterable)this.Sot).iterator();
              label476:
              label510:
              int i;
              if (localIterator2.hasNext())
              {
                paramp = localIterator2.next();
                Iterator localIterator3 = ((Iterable)paramp).iterator();
                if (localIterator3.hasNext())
                {
                  paramString = localIterator3.next();
                  if ((int)((com.tencent.mm.plugin.story.model.d.h)paramString).Smo.systemRowid == j)
                  {
                    i = 1;
                    label547:
                    if (i == 0) {
                      break label602;
                    }
                    label552:
                    if (paramString == null) {
                      break label609;
                    }
                    i = 1;
                    label559:
                    if (i == 0) {
                      break label613;
                    }
                    paramString = paramp;
                    label567:
                    paramString = (ArrayList)paramString;
                    if (((com.tencent.mm.plugin.story.model.a.k)locala).favorite != 1) {
                      break label620;
                    }
                  }
                }
              }
              label602:
              label609:
              label613:
              label620:
              for (bool = true;; bool = false)
              {
                a(bool, paramString, true);
                break;
                i = 0;
                break label547;
                break label510;
                paramString = null;
                break label552;
                i = 0;
                break label559;
                break label476;
                paramString = null;
                break label567;
              }
            }
            AppMethodBeat.o(119187);
            return;
          }
          paramString = com.tencent.mm.plugin.story.h.a.Sry;
          if (paramInt2 == com.tencent.mm.plugin.story.h.a.hyH()) {
            if (((com.tencent.mm.plugin.story.model.a.k)locala).favorite != 1) {
              break label674;
            }
          }
        }
      }
    }
    label674:
    for (final boolean bool = true;; bool = false)
    {
      a(bool, null, false);
      AppMethodBeat.o(119187);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(b paramb, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(b paramb, int paramInt, List<com.tencent.mm.plugin.story.model.d.h> paramList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(boolean paramBoolean, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(b paramb, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(b paramb, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(b paramb, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(g paramg, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(g paramg, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(g paramg, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements r<Long, Boolean, String, String, ah>
  {
    k(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b
 * JD-Core Version:    0.7.0.1
 */