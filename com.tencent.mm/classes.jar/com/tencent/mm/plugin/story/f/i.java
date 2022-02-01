package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.a.l;
import com.tencent.mm.plugin.story.model.b.b;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.model.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/presenter/SelfHistoryGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "username", "", "dates", "", "galleryUserCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "storyFilterList", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "queryCondition", "", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;Ljava/util/Map;I)V", "TAG", "dateGalleryMap", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "dateList", "dateState", "Lcom/tencent/mm/plugin/story/presenter/GalleryUserState;", "deleteColumnIndex", "deleteRowIndex", "enableVisit", "", "isLoadNetScene", "loadingIndexQueue", "Ljava/util/LinkedList;", "needFilter", "preloadLocalCount", "preloadRemoteCount", "selectedCol", "selectedRow", "storyCommentChangeListener", "Lkotlin/Function4;", "", "cancelDeleteItem", "row", "column", "checkLoadMore", "deleteItem", "destroy", "getStoryCountByDate", "date", "initExpectPosition", "expectPos", "initLoad", "loadMore", "loadNextQueuedUser", "loadStoryByDate", "notifyDateUpdate", "userGalleryItems", "onGalleryState", "state", "onItemRemovedCallback", "isOk", "onMsgListState", "index", "isSelf", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onSetFavoriteCallback", "favorite", "success", "onSetPrivacyCallback", "isPrivacy", "pause", "preloadForDate", "dateIndex", "resume", "setFavorite", "nowFavorite", "replaceInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "setSelectedCommentRead", "setSelectedRead", "setSelectedVisitRead", "updateUserGalleryItemsFromDb", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends f
  implements com.tencent.mm.am.h
{
  private boolean Rrq;
  private final int Siv;
  private final r<Long, Boolean, String, String, ah> SmW;
  private final Map<String, ArrayList<Long>> SoY;
  private final int SoZ;
  private final c Sos;
  private final ArrayList<ArrayList<com.tencent.mm.plugin.story.model.d.h>> Sot;
  private final ArrayList<e> Sou;
  private final LinkedList<String> Sov;
  private int Sow;
  private int Sox;
  private int Soy;
  private int Soz;
  private ArrayList<String> SpA;
  private final int Spa;
  private boolean Spc;
  private boolean Spf;
  private final List<String> Spz;
  private final String TAG;
  private final String username;
  
  public i(String paramString, List<String> paramList, c paramc, Map<String, ? extends ArrayList<Long>> paramMap, int paramInt)
  {
    AppMethodBeat.i(119317);
    this.username = paramString;
    this.Spz = paramList;
    this.Sos = paramc;
    this.SoY = paramMap;
    this.Siv = paramInt;
    this.TAG = "MicroMsg.SelfHistoryGalleryPresenter";
    this.SoZ = 3;
    this.Spa = 1;
    this.Sot = new ArrayList();
    this.Sou = new ArrayList();
    this.Sov = new LinkedList();
    this.Sow = -1;
    this.Sox = -1;
    this.Soy = -1;
    this.Soz = -1;
    paramInt = this.Siv;
    paramString = d.SoN;
    this.Spf = com.tencent.mm.ae.d.ee(paramInt, d.hxs());
    this.SpA = new ArrayList();
    this.SmW = ((r)new j(this));
    this.SpA.addAll((Collection)this.Spz);
    this.Sos.ang(this.SpA.size());
    paramString = ((Iterable)this.SpA).iterator();
    while (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      Log.i(this.TAG, kotlin.g.b.s.X("LogStory: ", paramList));
      this.Sot.add(new ArrayList());
      this.Sou.add(new e(paramList));
    }
    paramString = b.SlF;
    b.g(this.SmW);
    com.tencent.mm.kernel.h.baD().mCm.a(764, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.a(529, (com.tencent.mm.am.h)this);
    this.Rrq = com.tencent.mm.plugin.story.c.a.e.Sjb.huS();
    AppMethodBeat.o(119317);
  }
  
  private final void EJ(boolean paramBoolean)
  {
    AppMethodBeat.i(119302);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(paramBoolean, this));
    AppMethodBeat.o(119302);
  }
  
  private final void M(String paramString, final List<com.tencent.mm.plugin.story.model.d.h> paramList)
  {
    AppMethodBeat.i(119304);
    final int i = this.SpA.indexOf(paramString);
    if (paramList.isEmpty())
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, i));
      AppMethodBeat.o(119304);
      return;
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, i, paramList));
    AppMethodBeat.o(119304);
  }
  
  private static final void a(final i parami)
  {
    Object localObject3 = null;
    AppMethodBeat.i(367048);
    kotlin.g.b.s.u(parami, "this$0");
    Object localObject1;
    Object localObject2;
    label109:
    String str;
    StringBuilder localStringBuilder;
    if ((parami.Soy >= 0) && (parami.Soy < parami.Sot.size()))
    {
      localObject1 = parami.Sot.get(parami.Soy);
      kotlin.g.b.s.s(localObject1, "dateGalleryMap[selectedRow]");
      localObject2 = (ArrayList)localObject1;
      localObject1 = (com.tencent.mm.plugin.story.model.d.h)kotlin.a.p.ae((List)localObject2, parami.Soz);
      if (localObject1 != null) {
        break label236;
      }
      localObject1 = null;
      localObject2 = (com.tencent.mm.plugin.story.model.d.h)kotlin.a.p.ae((List)localObject2, parami.Soz);
      if (localObject2 != null) {
        break label244;
      }
      localObject2 = null;
      str = parami.TAG;
      localStringBuilder = new StringBuilder("setSelectedRead ").append(parami.Soz).append(", ");
      if (localObject1 != null) {
        break label254;
      }
    }
    for (;;)
    {
      Log.i(str, localObject3);
      if ((localObject1 != null) && (((g)localObject1).Smm.size() > 0))
      {
        localObject3 = b.SlF;
        long l = ((g)localObject1).idH;
        localObject3 = ((g)localObject1).Smm.getLast();
        kotlin.g.b.s.s(localObject3, "comment.visitorList.last");
        if (b.b(l, (com.tencent.mm.plugin.story.model.b.a)localObject3)) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i((com.tencent.mm.plugin.story.h.j)localObject2, (g)localObject1, parami));
        }
      }
      AppMethodBeat.o(367048);
      return;
      label236:
      localObject1 = ((com.tencent.mm.plugin.story.model.d.h)localObject1).Sms;
      break;
      label244:
      localObject2 = ((com.tencent.mm.plugin.story.model.d.h)localObject2).Smo;
      break label109;
      label254:
      localObject3 = Boolean.valueOf(((g)localObject1).Smi);
    }
  }
  
  private static final void a(i parami, int paramInt)
  {
    AppMethodBeat.i(367071);
    kotlin.g.b.s.u(parami, "this$0");
    if (((e)parami.Sou.get(paramInt)).SoT != 2) {
      parami.Sov.add(parami.SpA.get(paramInt));
    }
    paramInt += 1;
    if (paramInt < parami.SpA.size())
    {
      parami.Sov.add(parami.SpA.get(paramInt));
      parami.hxt();
    }
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new i..ExternalSyntheticLambda1(parami));
    AppMethodBeat.o(367071);
  }
  
  private static final void a(i parami, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(367067);
    kotlin.g.b.s.u(parami, "this$0");
    parami.Sow = paramInt1;
    parami.Sox = paramInt2;
    Object localObject1 = ((ArrayList)parami.Sot.get(paramInt1)).get(paramInt2);
    kotlin.g.b.s.s(localObject1, "dateGalleryMap[row][column]");
    localObject1 = (com.tencent.mm.plugin.story.model.d.h)localObject1;
    Object localObject2 = StoryCore.SjP;
    localObject2 = StoryCore.b.hvR().anv(((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg);
    Object localObject3 = StoryCore.SjP;
    StoryCore.b.hvR().bcp(((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg + '_' + ((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.createTime);
    if (localObject2 != null)
    {
      Log.i(parami.TAG, "LogStory: deleteItem2 storyinfo " + localObject1 + " deleteItemRow " + parami.Sow + " deleteItemCol " + parami.Sox + " localid " + ((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg + ' ' + ((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID);
      if (((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID == 0L) {
        break label285;
      }
      if ((parami.Sow != -1) && (parami.Sox != -1))
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
        StoryCore.b.gHI().post(new i..ExternalSyntheticLambda6(parami, (com.tencent.mm.plugin.story.model.d.h)localObject1));
      }
      AppMethodBeat.o(367067);
      return;
      label285:
      localObject2 = com.tencent.mm.plugin.story.model.m.Sks;
      m.a.anc(((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg);
      parami.EJ(true);
    }
  }
  
  private static final void a(i parami, com.tencent.mm.plugin.story.model.d.h paramh)
  {
    AppMethodBeat.i(367062);
    kotlin.g.b.s.u(parami, "this$0");
    kotlin.g.b.s.u(paramh, "$item");
    Log.i(parami.TAG, kotlin.g.b.s.X("LogStory: deleteItem fake ", paramh));
    parami = com.tencent.mm.plugin.story.model.m.Sks;
    m.a.anc(paramh.Smr.icg);
    parami = com.tencent.mm.plugin.story.model.e.a.SmE;
    com.tencent.mm.plugin.story.model.e.a.aSR(paramh.Smr.taskId);
    parami = com.tencent.mm.plugin.story.model.e.a.SmE;
    com.tencent.mm.plugin.story.model.e.a.aSS(paramh.Smr.taskId);
    AppMethodBeat.o(367062);
  }
  
  private static final void b(final i parami)
  {
    Object localObject3 = null;
    AppMethodBeat.i(367053);
    kotlin.g.b.s.u(parami, "this$0");
    if ((parami.Soy >= 0) && (parami.Soy < parami.Sot.size()))
    {
      Object localObject1 = parami.Sot.get(parami.Soy);
      kotlin.g.b.s.s(localObject1, "dateGalleryMap[selectedRow]");
      Object localObject2 = (ArrayList)localObject1;
      localObject1 = (com.tencent.mm.plugin.story.model.d.h)kotlin.a.p.ae((List)localObject2, parami.Soz);
      label109:
      String str;
      StringBuilder localStringBuilder;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = (com.tencent.mm.plugin.story.model.d.h)kotlin.a.p.ae((List)localObject2, parami.Soz);
        if (localObject2 != null) {
          break label231;
        }
        localObject2 = null;
        str = parami.TAG;
        localStringBuilder = new StringBuilder("setSelectedRead ").append(parami.Soz).append(", ");
        if (localObject1 != null) {
          break label241;
        }
      }
      for (;;)
      {
        Log.i(str, localObject3);
        if (!parami.Rrq) {
          break label253;
        }
        if ((localObject2 == null) || (!((com.tencent.mm.plugin.story.h.j)localObject2).hzs())) {
          break label358;
        }
        ((com.tencent.mm.plugin.story.h.j)localObject2).ER(false);
        localObject1 = com.tencent.mm.plugin.story.model.m.Sks;
        m.a.aB(((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID, ((com.tencent.mm.plugin.story.h.j)localObject2).field_localFlag);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(parami));
        AppMethodBeat.o(367053);
        return;
        localObject1 = ((com.tencent.mm.plugin.story.model.d.h)localObject1).Sms;
        break;
        label231:
        localObject2 = ((com.tencent.mm.plugin.story.model.d.h)localObject2).Smo;
        break label109;
        label241:
        localObject3 = Boolean.valueOf(((g)localObject1).Sly);
      }
      label253:
      if ((localObject2 != null) && (((com.tencent.mm.plugin.story.h.j)localObject2).hzs()))
      {
        ((com.tencent.mm.plugin.story.h.j)localObject2).ER(false);
        localObject3 = com.tencent.mm.plugin.story.model.m.Sks;
        m.a.aB(((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID, ((com.tencent.mm.plugin.story.h.j)localObject2).field_localFlag);
      }
      if ((localObject1 != null) && (((g)localObject1).commentList.size() > 0))
      {
        localObject2 = b.SlF;
        long l = ((g)localObject1).idH;
        localObject2 = ((g)localObject1).commentList.getLast();
        kotlin.g.b.s.s(localObject2, "comment.commentList.last");
        if (b.b(l, (com.tencent.mm.plugin.story.model.b.a)localObject2)) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h((g)localObject1, parami));
        }
      }
    }
    label358:
    AppMethodBeat.o(367053);
  }
  
  private static final void b(i parami, int paramInt)
  {
    AppMethodBeat.i(367076);
    kotlin.g.b.s.u(parami, "this$0");
    if (((e)parami.Sou.get(paramInt)).SoT != 2) {
      parami.Sov.add(parami.SpA.get(paramInt));
    }
    paramInt += 1;
    if (paramInt < parami.SpA.size())
    {
      parami.Sov.add(parami.SpA.get(paramInt));
      parami.hxt();
    }
    AppMethodBeat.o(367076);
  }
  
  private final void be(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(119303);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(119303);
  }
  
  private static final void c(final i parami)
  {
    Object localObject3 = null;
    AppMethodBeat.i(367058);
    kotlin.g.b.s.u(parami, "this$0");
    Object localObject1;
    Object localObject2;
    label109:
    String str;
    StringBuilder localStringBuilder;
    if ((parami.Soy >= 0) && (parami.Soy < parami.Sot.size()))
    {
      localObject1 = parami.Sot.get(parami.Soy);
      kotlin.g.b.s.s(localObject1, "dateGalleryMap[selectedRow]");
      localObject2 = (ArrayList)localObject1;
      localObject1 = (com.tencent.mm.plugin.story.model.d.h)kotlin.a.p.ae((List)localObject2, parami.Soz);
      if (localObject1 != null) {
        break label236;
      }
      localObject1 = null;
      localObject2 = (com.tencent.mm.plugin.story.model.d.h)kotlin.a.p.ae((List)localObject2, parami.Soz);
      if (localObject2 != null) {
        break label244;
      }
      localObject2 = null;
      str = parami.TAG;
      localStringBuilder = new StringBuilder("setSelectedRead ").append(parami.Soz).append(", ");
      if (localObject1 != null) {
        break label254;
      }
    }
    for (;;)
    {
      Log.i(str, localObject3);
      if ((localObject1 != null) && (((g)localObject1).PmC.size() > 0))
      {
        localObject3 = b.SlF;
        long l = ((g)localObject1).idH;
        localObject3 = ((g)localObject1).PmC.getLast();
        kotlin.g.b.s.s(localObject3, "comment.msgList.last");
        if (b.b(l, (com.tencent.mm.plugin.story.model.b.a)localObject3)) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f((com.tencent.mm.plugin.story.h.j)localObject2, (g)localObject1, parami));
        }
      }
      AppMethodBeat.o(367058);
      return;
      label236:
      localObject1 = ((com.tencent.mm.plugin.story.model.d.h)localObject1).Sms;
      break;
      label244:
      localObject2 = ((com.tencent.mm.plugin.story.model.d.h)localObject2).Smo;
      break label109;
      label254:
      localObject3 = Boolean.valueOf(((g)localObject1).Smj);
    }
  }
  
  private final void hxl()
  {
    AppMethodBeat.i(119305);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new i..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(119305);
  }
  
  private final void hxt()
  {
    AppMethodBeat.i(119316);
    for (;;)
    {
      if ((this.Spc) || (this.Sov.size() <= 0))
      {
        AppMethodBeat.o(119316);
        return;
      }
      Object localObject = this.Sov.get(0);
      kotlin.g.b.s.s(localObject, "loadingIndexQueue[0]");
      localObject = (String)localObject;
      int j = this.SpA.indexOf(localObject);
      int i;
      if (j >= 0) {
        if (j < this.Sou.size()) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label175;
        }
        Log.i(this.TAG, kotlin.g.b.s.X("LogStory: loadRemoteForDate ", localObject));
        if (((e)this.Sou.get(j)).SoT == 2) {
          break;
        }
        localObject = new com.tencent.mm.plugin.story.model.a.d(this.username, (String)localObject);
        com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject, 0);
        this.Spc = true;
        AppMethodBeat.o(119316);
        return;
        i = 0;
        continue;
        i = 0;
      }
      this.Sov.remove(0);
    }
    label175:
    AppMethodBeat.o(119316);
  }
  
  public final void M(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(119310);
    if (paramInt1 == 3)
    {
      if (paramBoolean)
      {
        switch (paramInt2)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(119310);
          return;
          StoryCore.b localb = StoryCore.SjP;
          StoryCore.b.gHI().post(new i..ExternalSyntheticLambda2(this));
          AppMethodBeat.o(119310);
          return;
          hxl();
        }
      }
      hxl();
    }
    AppMethodBeat.o(119310);
  }
  
  public final void N(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(119312);
    Log.i(this.TAG, "LogStory: setPrivacy row:" + paramInt1 + " column:" + paramInt2);
    Object localObject1;
    Object localObject2;
    if ((paramInt1 >= 0) && (paramInt1 < this.SpA.size()) && (paramInt2 >= 0) && (paramInt2 < ((ArrayList)this.Sot.get(paramInt1)).size()))
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
      com.tencent.mm.plugin.story.g.h.a(l, String.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID), 2L, 0L, 16);
      localObject2 = com.tencent.mm.plugin.story.model.m.Sks;
      m.a.c(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID, (int)((com.tencent.mm.plugin.story.h.j)localObject1).systemRowid, paramBoolean, ((com.tencent.mm.plugin.story.h.j)localObject1).hzy());
      AppMethodBeat.o(119312);
      return;
      label251:
      paramBoolean = false;
      break;
    }
  }
  
  public final void O(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(119315);
    Log.i(this.TAG, kotlin.g.b.s.X("LogStory: setFavorite ", Integer.valueOf(paramInt2)));
    Object localObject1;
    Object localObject2;
    if ((paramInt1 >= 0) && (paramInt1 < this.SpA.size()) && (paramInt2 >= 0) && (paramInt2 < ((ArrayList)this.Sot.get(paramInt1)).size()))
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
      com.tencent.mm.plugin.story.g.h.a(l, String.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID), 2L, 0L, 16);
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      ((ArrayList)localObject2).add(Long.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID));
      localArrayList.add(Integer.valueOf((int)((com.tencent.mm.plugin.story.h.j)localObject1).systemRowid));
      localObject1 = com.tencent.mm.plugin.story.model.m.Sks;
      m.a.b((List)localObject2, (List)localArrayList, paramBoolean);
      AppMethodBeat.o(119315);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  public final void aWi() {}
  
  public final void anf(int paramInt) {}
  
  public final void anj(int paramInt)
  {
    AppMethodBeat.i(119313);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new i..ExternalSyntheticLambda3(this, paramInt));
    AppMethodBeat.o(119313);
  }
  
  public final void ank(int paramInt) {}
  
  public final void destroy()
  {
    AppMethodBeat.i(119307);
    b localb = b.SlF;
    b.h(this.SmW);
    com.tencent.mm.kernel.h.baD().mCm.b(529, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.b(764, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(119307);
  }
  
  public final void hxm()
  {
    AppMethodBeat.i(119306);
    this.Sow = -1;
    this.Sox = -1;
    m.a locala = com.tencent.mm.plugin.story.model.m.Sks;
    m.a.hwj();
    AppMethodBeat.o(119306);
  }
  
  public final void hxn()
  {
    AppMethodBeat.i(119308);
    Object localObject1 = ((Iterable)this.SpA).iterator();
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
    localObject1 = ((Iterable)this.SpA).iterator();
    i = 0;
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject2 = this.SpA.get(i);
      kotlin.g.b.s.s(localObject2, "dateList[dateIndex]");
      localObject3 = (String)localObject2;
      localObject2 = this.Sot.get(i);
      kotlin.g.b.s.s(localObject2, "dateGalleryMap[dateIndex]");
      localObject2 = (ArrayList)localObject2;
      Object localObject4 = this.Sou.get(i);
      kotlin.g.b.s.s(localObject4, "dateState[dateIndex]");
      localObject4 = (e)localObject4;
      if (this.Spf)
      {
        Object localObject6 = (Iterable)f.a.nf(this.username, (String)localObject3);
        localObject5 = (Collection)new ArrayList();
        localObject6 = ((Iterable)localObject6).iterator();
        label312:
        while (((Iterator)localObject6).hasNext())
        {
          Object localObject7 = ((Iterator)localObject6).next();
          com.tencent.mm.plugin.story.model.d.h localh = (com.tencent.mm.plugin.story.model.d.h)localObject7;
          ArrayList localArrayList = (ArrayList)this.SoY.get(localObject3);
          if (localArrayList == null) {}
          for (boolean bool = true;; bool = localArrayList.contains(Long.valueOf(localh.idH)))
          {
            if (!bool) {
              break label312;
            }
            ((Collection)localObject5).add(localObject7);
            break;
          }
        }
        localObject3 = (List)localObject5;
        if (!((Collection)localObject3).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label556;
          }
          ((ArrayList)localObject2).addAll((Collection)localObject3);
          ((e)localObject4).SoT = 2;
          Log.i(this.TAG, kotlin.g.b.s.X("LogStory: preload Db with filter data ", Integer.valueOf(((List)localObject3).size())));
          i = j;
          break;
        }
      }
      Object localObject5 = StoryCore.SjP;
      localObject5 = StoryCore.b.hvW().bco((String)localObject3);
      if (localObject5 == null)
      {
        i = 0;
        label412:
        Log.i(this.TAG, "LogStory: preloadForDate " + (String)localObject3 + " historyCount " + i);
        localObject3 = f.a.nf(this.username, (String)localObject3);
        if (((ArrayList)localObject3).size() <= 0) {
          break label536;
        }
        ((ArrayList)localObject2).addAll((Collection)localObject3);
        if (((ArrayList)localObject3).size() != i) {
          break label527;
        }
      }
      label527:
      for (((e)localObject4).SoT = 2;; ((e)localObject4).SoT = 1)
      {
        Log.i(this.TAG, kotlin.g.b.s.X("LogStory: preload Db data ", Integer.valueOf(((ArrayList)localObject3).size())));
        i = j;
        break;
        i = ((com.tencent.mm.plugin.story.h.h)localObject5).field_count;
        break label412;
      }
      label536:
      if (i != 0)
      {
        ((e)localObject4).SoT = 1;
        Log.i(this.TAG, "LogStory: initLoad Sync data");
      }
      label556:
      i = j;
    }
    if (this.SpA.size() > 0)
    {
      this.Sov.add(kotlin.a.p.oK((List)this.SpA));
      hxt();
    }
    localObject1 = (Iterable)this.SpA;
    i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject2 = this.SpA.get(i);
      kotlin.g.b.s.s(localObject2, "dateList[index]");
      localObject2 = (String)localObject2;
      localObject3 = this.Sot.get(i);
      kotlin.g.b.s.s(localObject3, "dateGalleryMap[index]");
      M((String)localObject2, (List)localObject3);
      i += 1;
    }
    AppMethodBeat.o(119308);
  }
  
  public final void ma(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119309);
    Log.i(this.TAG, kotlin.g.b.s.X("LogStory: deleteItem ", Integer.valueOf(paramInt1)));
    if ((paramInt1 >= 0) && (paramInt1 < this.SpA.size()) && (paramInt2 >= 0) && (paramInt2 < ((ArrayList)this.Sot.get(paramInt1)).size()))
    {
      StoryCore.b localb = StoryCore.SjP;
      StoryCore.b.gHI().post(new i..ExternalSyntheticLambda5(this, paramInt1, paramInt2));
    }
    AppMethodBeat.o(119309);
  }
  
  public final void mb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119311);
    this.Soy = paramInt1;
    this.Soz = paramInt2;
    Log.d(this.TAG, "onSelected row=" + paramInt1 + " column=" + paramInt2);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new i..ExternalSyntheticLambda4(this, paramInt1));
    AppMethodBeat.o(119311);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    final boolean bool1 = false;
    boolean bool2 = true;
    boolean bool3 = true;
    int i = 1;
    AppMethodBeat.i(119314);
    kotlin.g.b.s.u(paramp, "scene");
    Log.i(this.TAG, "LogStory: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString);
    if (((paramp instanceof com.tencent.mm.plugin.story.model.a.d)) && (Util.isEqual(((com.tencent.mm.plugin.story.model.a.d)paramp).userName, this.username)))
    {
      paramString = (String)this.Sov.poll();
      paramInt2 = this.SpA.indexOf(paramString);
      if (paramInt2 >= 0) {
        if (paramInt2 < this.Sou.size()) {
          paramInt1 = i;
        }
      }
    }
    while (paramInt1 != 0)
    {
      this.Spc = false;
      ((e)this.Sou.get(paramInt2)).SoT = 2;
      Log.i(this.TAG, kotlin.g.b.s.X("LogStory: updateUserGalleryItemsFromDb ", Integer.valueOf(paramInt2)));
      paramString = this.SpA.get(paramInt2);
      kotlin.g.b.s.s(paramString, "dateList[dateIndex]");
      paramString = (String)paramString;
      paramp = this.Sot.get(paramInt2);
      kotlin.g.b.s.s(paramp, "dateGalleryMap[dateIndex]");
      paramp = (ArrayList)paramp;
      Object localObject = f.a.nf(this.username, paramString);
      paramp.clear();
      paramp.addAll((Collection)localObject);
      Log.i(this.TAG, "LogStory: db data " + paramString + ' ' + paramp.size());
      M(paramString, (List)paramp);
      hxt();
      AppMethodBeat.o(119314);
      return;
      paramInt1 = 0;
      continue;
      paramInt1 = 0;
      continue;
      if ((paramp instanceof com.tencent.mm.plugin.story.model.a.f))
      {
        paramString = ((com.tencent.mm.plugin.story.model.a.f)paramp).hwE();
        if (paramString != null)
        {
          if ((paramString instanceof l))
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
            for (bool1 = true;; bool1 = false)
            {
              EJ(bool1);
              AppMethodBeat.o(119314);
              return;
            }
          }
          if ((paramString instanceof com.tencent.mm.plugin.story.model.a.m))
          {
            Log.i(this.TAG, "onSceneEnd MMSTORY_OBJ_OP_VISIBILITY_TYPE errType:" + paramInt1 + ", errcode:" + paramInt2);
            if (paramInt2 == 0)
            {
              paramp = ((Iterable)((com.tencent.mm.plugin.story.model.a.f)paramp).Slm).iterator();
              while (paramp.hasNext())
              {
                paramInt1 = ((Number)paramp.next()).intValue();
                localObject = com.tencent.mm.plugin.story.model.m.Sks;
                m.a.lY(paramInt1, ((com.tencent.mm.plugin.story.model.a.m)paramString).Slw);
              }
              if ((((com.tencent.mm.plugin.story.model.a.m)paramString).Slw == 1) && (!((com.tencent.mm.plugin.story.model.a.m)paramString).Slx)) {}
              for (bool1 = bool2;; bool1 = false)
              {
                com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, bool1));
                AppMethodBeat.o(119314);
                return;
              }
            }
          }
          else if ((paramString instanceof com.tencent.mm.plugin.story.model.a.k))
          {
            if (paramInt2 == 0)
            {
              paramp = ((Iterable)((com.tencent.mm.plugin.story.model.a.f)paramp).Slm).iterator();
              while (paramp.hasNext())
              {
                i = ((Number)paramp.next()).intValue();
                Log.i(this.TAG, "onSceneEnd update story favorite: errType " + paramInt1 + ", errcode " + paramInt2 + ", localId " + i + ", favorite:" + ((com.tencent.mm.plugin.story.model.a.k)paramString).favorite);
                localObject = com.tencent.mm.plugin.story.model.m.Sks;
                m.a.lZ(i, ((com.tencent.mm.plugin.story.model.a.k)paramString).favorite);
              }
              if (((com.tencent.mm.plugin.story.model.a.k)paramString).favorite == 1) {
                bool1 = true;
              }
              be(bool1, true);
              AppMethodBeat.o(119314);
              return;
            }
            paramp = com.tencent.mm.plugin.story.h.a.Sry;
            if (paramInt2 == com.tencent.mm.plugin.story.h.a.hyH()) {
              if (((com.tencent.mm.plugin.story.model.a.k)paramString).favorite != 1) {
                break label786;
              }
            }
          }
        }
      }
    }
    label786:
    for (bool1 = bool3;; bool1 = false)
    {
      be(bool1, false);
      AppMethodBeat.o(119314);
      return;
    }
  }
  
  public final void pause() {}
  
  public final void resume() {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(i parami, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(i parami, int paramInt, List<com.tencent.mm.plugin.story.model.d.h> paramList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(boolean paramBoolean, i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(i parami, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(i parami, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(com.tencent.mm.plugin.story.h.j paramj, g paramg, i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(g paramg, i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(com.tencent.mm.plugin.story.h.j paramj, g paramg, i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements r<Long, Boolean, String, String, ah>
  {
    j(i parami)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(boolean paramBoolean, i parami, int paramInt1, int paramInt2, ArrayList<com.tencent.mm.plugin.story.model.d.h> paramArrayList, com.tencent.mm.plugin.story.model.d.h paramh)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.i
 * JD-Core Version:    0.7.0.1
 */