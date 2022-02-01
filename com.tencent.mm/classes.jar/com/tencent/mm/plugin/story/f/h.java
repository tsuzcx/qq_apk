package com.tencent.mm.plugin.story.f;

import androidx.recyclerview.widget.g.b;
import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.a.i;
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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/presenter/SelfGalleryPresenter;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "username", "", "galleryCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "forSns", "", "justNew", "(Ljava/lang/String;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;ZZ)V", "deleteItemIndex", "", "firstNotify", "getForSns", "()Z", "getGalleryCallback", "()Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "galleryState", "getJustNew", "lastVisitorEnable", "privateItemIndex", "selectedIndex", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "getUsername", "()Ljava/lang/String;", "cancelDeleteItem", "row", "column", "deleteItem", "destroy", "initExpectPosition", "expectPos", "initLoad", "loadMore", "onGalleryState", "state", "onItemRemovedCallback", "isOk", "onMsgListState", "index", "isSelf", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onSetFavoriteCallback", "favorite", "success", "storyId", "onSetPrivacyCallback", "isPrivacy", "pause", "resume", "setFavorite", "nowFavorite", "replaceInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "setSelectedCommentRead", "setSelectedRead", "setSelectedVisitRead", "updateCommentRead", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends f
  implements com.tencent.mm.am.h
{
  private static boolean Spe;
  public static final h.a Spn;
  private static final String TAG;
  private final r<Long, Boolean, String, String, ah> SmW;
  private int SoA;
  final c Spo;
  private final boolean Spp;
  private final boolean Spq;
  private final ArrayList<com.tencent.mm.plugin.story.model.d.h> Spr;
  private int Sps;
  private int Spt;
  private boolean Spu;
  private boolean Spv;
  private int dbk;
  private final String username;
  
  static
  {
    AppMethodBeat.i(119282);
    Spn = new h.a((byte)0);
    TAG = "MicroMsg.SelfGalleryPresenter";
    Spe = true;
    AppMethodBeat.o(119282);
  }
  
  private h(String paramString, c paramc)
  {
    AppMethodBeat.i(119281);
    this.username = paramString;
    this.Spo = paramc;
    this.Spp = false;
    this.Spq = false;
    this.Spr = new ArrayList();
    this.Sps = -1;
    this.Spt = -1;
    this.dbk = -1;
    this.Spu = true;
    this.SmW = ((r)new j(this));
    com.tencent.mm.kernel.h.baD().mCm.a(273, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.a(764, (com.tencent.mm.am.h)this);
    paramString = b.SlF;
    b.g(this.SmW);
    this.Spo.ang(1);
    this.Spv = com.tencent.mm.plugin.story.c.a.e.Sjb.huS();
    AppMethodBeat.o(119281);
  }
  
  private final void EJ(boolean paramBoolean)
  {
    AppMethodBeat.i(119263);
    d.uiThread((kotlin.g.a.a)new c(paramBoolean, this));
    AppMethodBeat.o(119263);
  }
  
  private static final void a(final h paramh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(367046);
    kotlin.g.b.s.u(paramh, "this$0");
    Object localObject1 = (com.tencent.mm.plugin.story.model.d.h)kotlin.a.p.ae((List)paramh.Spr, paramh.dbk);
    String str;
    StringBuilder localStringBuilder;
    if (localObject1 == null)
    {
      localObject1 = null;
      str = TAG;
      localStringBuilder = new StringBuilder("setSelectedRead ").append(paramh.dbk).append(", ");
      if (localObject1 != null) {
        break label170;
      }
    }
    for (;;)
    {
      Log.i(str, localObject2);
      if ((localObject1 != null) && (((g)localObject1).Smm.size() > 0))
      {
        localObject2 = b.SlF;
        long l = ((g)localObject1).idH;
        localObject2 = ((g)localObject1).Smm.getLast();
        kotlin.g.b.s.s(localObject2, "comment.visitorList.last");
        b.b(l, (com.tencent.mm.plugin.story.model.b.a)localObject2);
        d.uiThread((kotlin.g.a.a)new i((g)localObject1, paramh));
      }
      AppMethodBeat.o(367046);
      return;
      localObject1 = ((com.tencent.mm.plugin.story.model.d.h)localObject1).Sms;
      break;
      label170:
      localObject2 = Boolean.valueOf(((g)localObject1).Smi);
    }
  }
  
  private static final void a(com.tencent.mm.plugin.story.model.d.h paramh)
  {
    AppMethodBeat.i(367042);
    kotlin.g.b.s.u(paramh, "$item");
    Log.i(TAG, kotlin.g.b.s.X("LogStory: deleteItem fake ", paramh));
    Object localObject = com.tencent.mm.plugin.story.model.m.Sks;
    m.a.anc(paramh.Smr.icg);
    localObject = com.tencent.mm.plugin.story.model.e.a.SmE;
    com.tencent.mm.plugin.story.model.e.a.aSR(paramh.Smr.taskId);
    localObject = com.tencent.mm.plugin.story.model.e.a.SmE;
    com.tencent.mm.plugin.story.model.e.a.aSS(paramh.Smr.taskId);
    AppMethodBeat.o(367042);
  }
  
  private static final void b(final h paramh)
  {
    Object localObject3 = null;
    AppMethodBeat.i(367052);
    kotlin.g.b.s.u(paramh, "this$0");
    Object localObject1 = (com.tencent.mm.plugin.story.model.d.h)kotlin.a.p.ae((List)paramh.Spr, paramh.dbk);
    Object localObject2;
    label67:
    String str;
    StringBuilder localStringBuilder;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = (com.tencent.mm.plugin.story.model.d.h)kotlin.a.p.ae((List)paramh.Spr, paramh.dbk);
      if (localObject2 != null) {
        break label190;
      }
      localObject2 = null;
      str = TAG;
      localStringBuilder = new StringBuilder("setSelectedRead ").append(paramh.dbk).append(", ");
      if (localObject1 != null) {
        break label200;
      }
    }
    for (;;)
    {
      Log.i(str, localObject3);
      if (!com.tencent.mm.plugin.story.c.a.e.Sjb.huS()) {
        break label212;
      }
      if ((localObject2 == null) || (!((com.tencent.mm.plugin.story.h.j)localObject2).hzs())) {
        break label317;
      }
      ((com.tencent.mm.plugin.story.h.j)localObject2).ER(false);
      localObject1 = com.tencent.mm.plugin.story.model.m.Sks;
      m.a.aB(((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID, ((com.tencent.mm.plugin.story.h.j)localObject2).field_localFlag);
      d.uiThread((kotlin.g.a.a)new g(paramh));
      AppMethodBeat.o(367052);
      return;
      localObject1 = ((com.tencent.mm.plugin.story.model.d.h)localObject1).Sms;
      break;
      label190:
      localObject2 = ((com.tencent.mm.plugin.story.model.d.h)localObject2).Smo;
      break label67;
      label200:
      localObject3 = Boolean.valueOf(((g)localObject1).Sly);
    }
    label212:
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
        d.uiThread((kotlin.g.a.a)new h((g)localObject1, paramh));
      }
    }
    label317:
    AppMethodBeat.o(367052);
  }
  
  private final void b(boolean paramBoolean1, final boolean paramBoolean2, final long paramLong)
  {
    AppMethodBeat.i(119264);
    d.uiThread((kotlin.g.a.a)new d(this, paramLong, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(119264);
  }
  
  private static final void c(final h paramh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(367057);
    kotlin.g.b.s.u(paramh, "this$0");
    Object localObject1 = (com.tencent.mm.plugin.story.model.d.h)kotlin.a.p.ae((List)paramh.Spr, paramh.dbk);
    String str;
    StringBuilder localStringBuilder;
    if (localObject1 == null)
    {
      localObject1 = null;
      str = TAG;
      localStringBuilder = new StringBuilder("setSelectedRead ").append(paramh.dbk).append(", ");
      if (localObject1 != null) {
        break label170;
      }
    }
    for (;;)
    {
      Log.i(str, localObject2);
      if ((localObject1 != null) && (((g)localObject1).PmC.size() > 0))
      {
        localObject2 = b.SlF;
        long l = ((g)localObject1).idH;
        localObject2 = ((g)localObject1).PmC.getLast();
        kotlin.g.b.s.s(localObject2, "comment.msgList.last");
        b.b(l, (com.tencent.mm.plugin.story.model.b.a)localObject2);
        d.uiThread((kotlin.g.a.a)new f((g)localObject1, paramh));
      }
      AppMethodBeat.o(367057);
      return;
      localObject1 = ((com.tencent.mm.plugin.story.model.d.h)localObject1).Sms;
      break;
      label170:
      localObject2 = Boolean.valueOf(((g)localObject1).Smj);
    }
  }
  
  private final void hxk()
  {
    AppMethodBeat.i(119274);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new h..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(119274);
  }
  
  private final void hxl()
  {
    AppMethodBeat.i(119275);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new h..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(119275);
  }
  
  private final void hxu()
  {
    AppMethodBeat.i(119276);
    Object localObject = (Iterable)this.Spr;
    com.tencent.mm.plugin.story.model.d.h localh;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        localh = (com.tencent.mm.plugin.story.model.d.h)((Iterator)localObject).next();
        if (com.tencent.mm.plugin.story.c.a.e.Sjb.huS()) {
          if ((localh.Sms.Smi) || (localh.Sms.Smj))
          {
            bool1 = true;
            label93:
            if (!bool1) {
              break label181;
            }
          }
        }
      }
    }
    boolean bool2;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = this.Spr.isEmpty();
      Log.i(TAG, "LogStory: updateCommentRead " + bool1 + ' ' + bool2);
      if (!bool1) {
        break label188;
      }
      if (this.SoA != 0) {
        break label197;
      }
      localObject = b.SlF;
      b.bc(true, bool2);
      AppMethodBeat.o(119276);
      return;
      bool1 = false;
      break label93;
      bool1 = localh.Sms.Sly;
      break label93;
      label181:
      break;
    }
    label188:
    localObject = b.SlF;
    b.bc(false, bool2);
    label197:
    AppMethodBeat.o(119276);
  }
  
  public final void M(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(119266);
    if (paramInt1 == 3)
    {
      if (paramBoolean)
      {
        switch (paramInt2)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(119266);
          return;
          StoryCore.b localb = StoryCore.SjP;
          StoryCore.b.gHI().post(new h..ExternalSyntheticLambda0(this));
          AppMethodBeat.o(119266);
          return;
          hxl();
        }
      }
      hxl();
    }
    AppMethodBeat.o(119266);
  }
  
  public final void N(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(119272);
    Log.i(TAG, kotlin.g.b.s.X("LogStory: setPrivacy ", Integer.valueOf(paramInt2)));
    Object localObject1;
    Object localObject2;
    if ((paramInt2 >= 0) && (paramInt2 < this.Spr.size()))
    {
      this.Spt = paramInt2;
      if (paramBoolean) {
        break label232;
      }
      paramBoolean = true;
      localObject1 = this.Spr.get(paramInt2);
      kotlin.g.b.s.s(localObject1, "galleryItems[column]");
      localObject1 = (com.tencent.mm.plugin.story.model.d.h)localObject1;
      Log.i(TAG, "LogStory: setPrivacy storyinfo " + localObject1 + " setPrivacyItemIndex " + this.Spt + " localid " + ((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg + " targetPrivacy:" + paramBoolean);
      localObject2 = StoryCore.SjP;
      localObject1 = StoryCore.b.hvR().anv((int)((com.tencent.mm.plugin.story.model.d.h)localObject1).Smo.systemRowid);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.story.g.e.SqW;
        com.tencent.mm.plugin.story.g.e.EN(paramBoolean);
        if (!paramBoolean) {
          break label237;
        }
      }
    }
    label232:
    label237:
    for (long l = 3L;; l = 4L)
    {
      localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.a(l, String.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID), 1L, 0L, 24);
      localObject2 = com.tencent.mm.plugin.story.model.m.Sks;
      m.a.c(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID, (int)((com.tencent.mm.plugin.story.h.j)localObject1).systemRowid, paramBoolean, false);
      AppMethodBeat.o(119272);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  public final void O(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(119273);
    Log.i(TAG, kotlin.g.b.s.X("LogStory: setFavorite ", Integer.valueOf(paramInt2)));
    Object localObject1;
    Object localObject2;
    if ((paramInt2 >= 0) && (paramInt2 < this.Spr.size()))
    {
      if (paramBoolean) {
        break label257;
      }
      paramBoolean = true;
      localObject1 = this.Spr.get(paramInt2);
      kotlin.g.b.s.s(localObject1, "galleryItems[column]");
      localObject1 = (com.tencent.mm.plugin.story.model.d.h)localObject1;
      Log.i(TAG, "LogStory: setFavorite storyinfo " + localObject1 + " localid " + ((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg + " targetFavorite:" + paramBoolean);
      localObject2 = StoryCore.SjP;
      localObject1 = StoryCore.b.hvR().anv((int)((com.tencent.mm.plugin.story.model.d.h)localObject1).Smo.systemRowid);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.story.g.e.SqW;
        com.tencent.mm.plugin.story.g.e.EM(paramBoolean);
        if (!paramBoolean) {
          break label262;
        }
      }
    }
    label257:
    label262:
    for (long l = 1L;; l = 2L)
    {
      localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.a(l, String.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID), 1L, 0L, 24);
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      ((ArrayList)localObject2).add(Long.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID));
      localArrayList.add(Integer.valueOf((int)((com.tencent.mm.plugin.story.h.j)localObject1).systemRowid));
      localObject1 = com.tencent.mm.plugin.story.model.m.Sks;
      m.a.b((List)localObject2, (List)localArrayList, paramBoolean);
      AppMethodBeat.o(119273);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  public final void aWi()
  {
    AppMethodBeat.i(119268);
    if ((Spe) && (this.SoA == 0))
    {
      Spe = false;
      com.tencent.mm.plugin.story.api.e locale = (com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class);
      StoryCore.b localb = StoryCore.SjP;
      locale.loadStory(StoryCore.b.hgg(), null);
    }
    AppMethodBeat.o(119268);
  }
  
  public final void anf(int paramInt)
  {
    AppMethodBeat.i(119265);
    this.SoA = paramInt;
    if (paramInt == 0)
    {
      aWi();
      AppMethodBeat.o(119265);
      return;
    }
    boolean bool = com.tencent.mm.plugin.story.c.a.e.Sjb.huS();
    hxk();
    if (bool)
    {
      b localb = b.SlF;
      b.bc(false, false);
    }
    if (this.Spv != bool)
    {
      this.Spv = bool;
      this.Spo.S(0, (List)this.Spr);
      this.Spo.ani(0);
    }
    AppMethodBeat.o(119265);
  }
  
  public final void ank(int paramInt) {}
  
  public final void destroy()
  {
    AppMethodBeat.i(119279);
    Log.i(TAG, "LogStory: destroy");
    com.tencent.mm.kernel.h.baD().mCm.b(273, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.b(764, (com.tencent.mm.am.h)this);
    b localb = b.SlF;
    b.h(this.SmW);
    AppMethodBeat.o(119279);
  }
  
  public final void hxm()
  {
    AppMethodBeat.i(119270);
    this.Sps = -1;
    m.a locala = com.tencent.mm.plugin.story.model.m.Sks;
    m.a.hwj();
    AppMethodBeat.o(119270);
  }
  
  public final void hxn()
  {
    AppMethodBeat.i(119267);
    Log.i(TAG, "LogStory: initLoad");
    Object localObject2 = (com.tencent.mm.plugin.story.model.d.h)kotlin.a.p.ae((List)this.Spr, 0);
    Object localObject1;
    if (this.Spq)
    {
      Object localObject3 = (Iterable)f.a.jdMethod_do(this.username, this.Spp);
      localObject1 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      int i = 0;
      if (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = ((Iterator)localObject3).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        if (i == 0) {}
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            ((Collection)localObject1).add(localObject4);
          }
          i += 1;
          break;
        }
      }
      localObject1 = (List)localObject1;
      Log.i(TAG, kotlin.g.b.s.X("LogStory: preload Db count ", Integer.valueOf(((List)localObject1).size())));
      localObject3 = (com.tencent.mm.plugin.story.model.d.h)kotlin.a.p.ae((List)localObject1, 0);
      if ((localObject2 == null) || (localObject3 == null) || (((com.tencent.mm.plugin.story.model.d.h)localObject2).idH == ((com.tencent.mm.plugin.story.model.d.h)localObject3).idH)) {
        break label302;
      }
      this.Spr.clear();
      this.Spr.addAll((Collection)localObject1);
      this.Spo.S(0, (List)this.Spr);
      this.Spo.ani(0);
      this.Spo.hxo();
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.story.c.a.e.Sjb.huS())
      {
        if (this.Spu) {
          this.Spu = false;
        }
      }
      else {
        hxu();
      }
      aWi();
      AppMethodBeat.o(119267);
      return;
      localObject1 = (List)f.a.jdMethod_do(this.username, this.Spp);
      break;
      label302:
      localObject2 = f.a.M((List)this.Spr, (List)localObject1);
      this.Spo.S(0, (List)this.Spr);
      this.Spo.hxo();
      ((g.b)localObject2).a((q)new b(this, (List)localObject1));
    }
  }
  
  public final void ma(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119269);
    Log.i(TAG, kotlin.g.b.s.X("LogStory: deleteItem ", Integer.valueOf(paramInt2)));
    Object localObject1;
    Object localObject2;
    if ((paramInt2 >= 0) && (paramInt2 < this.Spr.size()))
    {
      this.Sps = paramInt2;
      localObject1 = this.Spr.get(paramInt2);
      kotlin.g.b.s.s(localObject1, "galleryItems[column]");
      localObject1 = (com.tencent.mm.plugin.story.model.d.h)localObject1;
      Log.i(TAG, "LogStory: deleteItem1 storyinfo " + localObject1 + " deleteItemIndex " + this.Sps + " localid " + ((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg);
      localObject2 = StoryCore.SjP;
      localObject2 = StoryCore.b.hvR().anv(((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg);
      Object localObject3 = StoryCore.SjP;
      StoryCore.b.hvR().bcp(((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg + '_' + ((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.createTime);
      if (localObject2 != null)
      {
        Log.i(TAG, "LogStory: deleteItem2 storyinfo " + localObject1 + " deleteItemIndex " + this.Sps + " localid " + ((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg + ' ' + ((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID);
        if (((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID == 0L) {
          break label326;
        }
        if (this.Sps != -1)
        {
          localObject3 = com.tencent.mm.plugin.story.model.m.Sks;
          m.a.aA(((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID, ((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg);
        }
      }
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.hwL())
      {
        localObject2 = StoryCore.SjP;
        StoryCore.b.gHI().post(new h..ExternalSyntheticLambda3((com.tencent.mm.plugin.story.model.d.h)localObject1));
      }
      AppMethodBeat.o(119269);
      return;
      label326:
      localObject2 = com.tencent.mm.plugin.story.model.m.Sks;
      m.a.anc(((com.tencent.mm.plugin.story.model.d.h)localObject1).Smr.icg);
      EJ(true);
    }
  }
  
  public final void mb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119271);
    this.dbk = paramInt2;
    if (this.SoA == 1) {
      hxk();
    }
    AppMethodBeat.o(119271);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(119280);
    Log.i(TAG, "LogStory: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString);
    if (((paramp instanceof i)) && (Util.isEqual(((i)paramp).userName, this.username)))
    {
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        paramInt1 = ((i)paramp).source;
        paramString = com.tencent.mm.plugin.story.h.a.Sry;
        if (paramInt1 == com.tencent.mm.plugin.story.h.a.hyV())
        {
          Spe = false;
          hxn();
          AppMethodBeat.o(119280);
        }
      }
    }
    else if ((paramp instanceof com.tencent.mm.plugin.story.model.a.f))
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
            AppMethodBeat.o(119280);
            return;
          }
        }
        m.a locala;
        if ((paramString instanceof com.tencent.mm.plugin.story.model.a.m))
        {
          Log.i(TAG, "onSceneEnd MMSTORY_OBJ_OP_VISIBILITY_TYPE errType:" + paramInt1 + ", errcode:" + paramInt2);
          if (paramInt2 == 0)
          {
            paramp = ((Iterable)((com.tencent.mm.plugin.story.model.a.f)paramp).Slm).iterator();
            while (paramp.hasNext())
            {
              paramInt1 = ((Number)paramp.next()).intValue();
              locala = com.tencent.mm.plugin.story.model.m.Sks;
              m.a.lY(paramInt1, ((com.tencent.mm.plugin.story.model.a.m)paramString).Slw);
            }
            d.uiThread((kotlin.g.a.a)new e(this));
            AppMethodBeat.o(119280);
          }
        }
        else if ((paramString instanceof com.tencent.mm.plugin.story.model.a.k))
        {
          if (paramInt2 == 0)
          {
            paramp = ((Iterable)((com.tencent.mm.plugin.story.model.a.f)paramp).Slm).iterator();
            while (paramp.hasNext())
            {
              int i = ((Number)paramp.next()).intValue();
              Log.i(TAG, "onSceneEnd update story favorite: errType " + paramInt1 + ", errcode " + paramInt2 + ", localId " + i + ", favorite:" + ((com.tencent.mm.plugin.story.model.a.k)paramString).favorite);
              locala = com.tencent.mm.plugin.story.model.m.Sks;
              m.a.lZ(i, ((com.tencent.mm.plugin.story.model.a.k)paramString).favorite);
            }
            if (((com.tencent.mm.plugin.story.model.a.k)paramString).favorite == 1) {
              bool1 = true;
            }
            b(bool1, true, paramString.idH);
            AppMethodBeat.o(119280);
            return;
          }
          paramp = com.tencent.mm.plugin.story.h.a.Sry;
          if (paramInt2 == com.tencent.mm.plugin.story.h.a.hyH()) {
            if (((com.tencent.mm.plugin.story.model.a.k)paramString).favorite != 1) {
              break label569;
            }
          }
        }
      }
    }
    label569:
    for (bool1 = bool2;; bool1 = false)
    {
      b(bool1, false, paramString.idH);
      AppMethodBeat.o(119280);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(119278);
    Log.i(TAG, "LogStory: pause");
    AppMethodBeat.o(119278);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(119277);
    Log.i(TAG, "LogStory: resume");
    hxn();
    AppMethodBeat.o(119277);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/presenter/SelfGalleryPresenter$initLoad$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements q
  {
    b(h paramh, List<com.tencent.mm.plugin.story.model.d.h> paramList) {}
    
    public final void aR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119249);
      Log.i(h.access$getTAG$cp(), "onInserted: " + paramInt1 + ' ' + paramInt2);
      h.d(this.Spw).clear();
      h.d(this.Spw).addAll((Collection)this.Spx);
      this.Spw.Spo.S(0, (List)h.d(this.Spw));
      this.Spw.Spo.hxo();
      this.Spw.Spo.ba(0, paramInt1, paramInt2);
      AppMethodBeat.o(119249);
    }
    
    public final void aS(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119250);
      Log.i(h.access$getTAG$cp(), "onRemoved: " + paramInt1 + ' ' + paramInt2);
      h.d(this.Spw).clear();
      h.d(this.Spw).addAll((Collection)this.Spx);
      this.Spw.Spo.S(0, (List)h.d(this.Spw));
      this.Spw.Spo.hxo();
      this.Spw.Spo.bb(0, paramInt1, paramInt2);
      AppMethodBeat.o(119250);
    }
    
    public final void aW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119248);
      Log.i(h.access$getTAG$cp(), "onMoved: " + paramInt1 + ' ' + paramInt2);
      AppMethodBeat.o(119248);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(119247);
      Log.i(h.access$getTAG$cp(), "onChanged: " + paramInt1 + ' ' + paramInt2);
      h.d(this.Spw).clear();
      h.d(this.Spw).addAll((Collection)this.Spx);
      this.Spw.Spo.S(0, (List)h.d(this.Spw));
      this.Spw.Spo.hxo();
      this.Spw.Spo.bc(0, paramInt1, paramInt2);
      AppMethodBeat.o(119247);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(boolean paramBoolean, h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(h paramh, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(g paramg, h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(g paramg, h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(g paramg, h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements r<Long, Boolean, String, String, ah>
  {
    j(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.h
 * JD-Core Version:    0.7.0.1
 */