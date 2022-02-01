package com.tencent.mm.plugin.story.f;

import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.b.b;
import com.tencent.mm.plugin.story.model.m;
import com.tencent.mm.plugin.story.model.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "users", "", "", "chatRoom", "groupCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "storyFilterList", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "queryCondition", "", "(Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;Ljava/util/Map;I)V", "TAG", "allUnread", "", "enableVisitor", "expectPos", "galleryState", "isForSns", "isLoadNetScene", "loadingUserQueue", "", "Lcom/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter$UserData;", "kotlin.jvm.PlatformType", "needFilter", "needLoadRemote", "preloadLocalCount", "preloadRemoteCount", "selectedCol", "selectedRow", "storyCommentChangeListener", "Lkotlin/Function4;", "", "userList", "checkLoadMore", "row", "deleteItem", "column", "destroy", "initExpectPosition", "initLoad", "loadMore", "loadNextQueuedUser", "notifyUser", "user", "items", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "onGalleryState", "state", "onMsgListState", "index", "isSelf", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "preloadForUser", "setSelectedCommentRead", "setSelectedRead", "setSelectedVisitRead", "updateUserGalleryItemsFromDb", "UserData", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends f
  implements com.tencent.mm.am.h
{
  private final int Siv;
  private final r<Long, Boolean, String, String, ah> SmW;
  private int SoA;
  private boolean SoB;
  private final c SoX;
  private final Map<String, ArrayList<Long>> SoY;
  private final int SoZ;
  private int Soy;
  private int Soz;
  private final int Spa;
  private final List<a> Spb;
  private boolean Spc;
  private int Spd;
  private boolean Spe;
  private boolean Spf;
  private final boolean Spg;
  private final boolean Sph;
  private final String TAG;
  private final List<a> oxE;
  private final String pJq;
  
  public g(List<String> paramList, String paramString, c paramc, Map<String, ? extends ArrayList<Long>> paramMap, int paramInt)
  {
    AppMethodBeat.i(119242);
    this.pJq = paramString;
    this.SoX = paramc;
    this.SoY = paramMap;
    this.Siv = paramInt;
    this.TAG = "MicroMsg.MultiUserGalleryPresenter";
    this.SoZ = 3;
    this.Spa = 1;
    this.oxE = Collections.synchronizedList((List)new ArrayList());
    this.Spb = Collections.synchronizedList((List)new LinkedList());
    this.Soy = -1;
    this.Soz = -1;
    paramInt = this.Siv;
    paramString = d.SoN;
    this.Spf = com.tencent.mm.ae.d.ee(paramInt, d.hxs());
    paramInt = this.Siv;
    paramString = d.SoN;
    this.Spg = com.tencent.mm.ae.d.ee(paramInt, d.hxq());
    paramInt = this.Siv;
    paramString = d.SoN;
    this.Sph = com.tencent.mm.ae.d.ee(paramInt, d.hxr());
    this.SmW = ((r)new j(this));
    Log.i(this.TAG, "TimeDiff: local: " + System.currentTimeMillis() + ", server: " + cn.bDu());
    Log.i(this.TAG, kotlin.g.b.s.X("chatRoom is ", this.pJq));
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      paramString = (String)paramList.next();
      Log.i(this.TAG, kotlin.g.b.s.X("LogStory: ", paramString));
      this.oxE.add(new a(paramString, new ArrayList()));
    }
    this.SoX.ang(this.oxE.size());
    com.tencent.mm.kernel.h.baD().mCm.a(273, (com.tencent.mm.am.h)this);
    paramList = b.SlF;
    b.g(this.SmW);
    this.SoB = com.tencent.mm.plugin.story.c.a.e.Sjb.huS();
    AppMethodBeat.o(119242);
  }
  
  private final void a(a parama)
  {
    int i = 1;
    AppMethodBeat.i(119240);
    if (this.oxE.indexOf(parama) < 0)
    {
      AppMethodBeat.o(119240);
      return;
    }
    if (parama.state != 0)
    {
      Log.i(this.TAG, "LogStory: preloadForUser already preload");
      AppMethodBeat.o(119240);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Log.i(this.TAG, "LogStory: preloadForUser " + parama + ' ' + this.Spf + ' ' + this.Siv);
    Object localObject1;
    if (this.Sph)
    {
      parama.state = 1;
      int j = cn.getSyncServerTimeSecond();
      localObject1 = com.tencent.mm.plugin.story.model.i.SjL;
      int k = com.tencent.mm.plugin.story.model.i.hvz();
      localObject1 = StoryCore.SjP;
      parama.Spi = Math.max(j - k, (int)(StoryCore.b.hvS().bbJ(parama.username).field_readTime / 1000L));
      localObject1 = f.a.k(parama.username, this.Spg, parama.Spi);
      if (!((Collection)localObject1).isEmpty()) {
        if (i != 0)
        {
          Log.i(this.TAG, kotlin.g.b.s.X("LogStory: preload add sync item and local item, ", Integer.valueOf(((ArrayList)localObject1).size())));
          localArrayList.addAll((Collection)localObject1);
        }
      }
    }
    for (;;)
    {
      a(parama, localArrayList);
      AppMethodBeat.o(119240);
      return;
      i = 0;
      break;
      Object localObject2;
      if (this.Spf)
      {
        parama.state = 2;
        localObject1 = parama.username;
        localObject2 = parama.username;
        StoryCore.b localb = StoryCore.SjP;
        localObject1 = f.a.b((String)localObject1, Util.isEqual((String)localObject2, StoryCore.b.hgg()), (ArrayList)this.SoY.get(parama.username));
        if (!((Collection)localObject1).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label371;
          }
          Log.i(this.TAG, kotlin.g.b.s.X("LogStory: preload add sync item and local item, ", Integer.valueOf(((ArrayList)localObject1).size())));
          localArrayList.addAll((Collection)localObject1);
          break;
        }
      }
      else
      {
        label371:
        localObject1 = StoryCore.SjP;
        if (Util.isEqual(StoryCore.b.hgg(), parama.username))
        {
          parama.state = 1;
          localObject1 = f.a.jdMethod_do(parama.username, this.Spg);
          if (((ArrayList)localObject1).size() > 0)
          {
            Log.i(this.TAG, kotlin.g.b.s.X("LogStory: preload add sync item and local item, ", Integer.valueOf(((ArrayList)localObject1).size())));
            localArrayList.addAll((Collection)localObject1);
          }
        }
        else
        {
          parama.state = 1;
          localObject1 = f.a.dn(parama.username, this.Spg);
          if (localObject1 == null)
          {
            a(parama, localArrayList);
            AppMethodBeat.o(119240);
            return;
          }
          localObject2 = f.a.jdMethod_do(parama.username, this.Spg);
          if (((ArrayList)localObject2).size() > 0)
          {
            Log.i(this.TAG, kotlin.g.b.s.X("LogStory: preload add sync item and local item, ", Integer.valueOf(((ArrayList)localObject2).size())));
            if (((com.tencent.mm.plugin.story.model.d.h)((ArrayList)localObject2).get(0)).idH != ((com.tencent.mm.plugin.story.model.d.h)localObject1).idH) {
              localArrayList.add(localObject1);
            }
            localArrayList.addAll((Collection)localObject2);
          }
          else
          {
            Log.i(this.TAG, "LogStory: preload add sync item");
            localArrayList.add(localObject1);
          }
        }
      }
    }
  }
  
  private final void a(a parama, final ArrayList<com.tencent.mm.plugin.story.model.d.h> paramArrayList)
  {
    boolean bool2 = false;
    AppMethodBeat.i(119239);
    final int j = this.oxE.indexOf(parama);
    boolean bool1;
    if (paramArrayList.isEmpty())
    {
      i = this.Soy;
      if (j <= this.Soy + 1) {
        if (i - 1 <= j)
        {
          i = 1;
          if (i != 0) {
            break label292;
          }
          bool1 = true;
          label61:
          if (((Collection)paramArrayList).isEmpty()) {
            break label298;
          }
        }
      }
    }
    Object localObject;
    label292:
    label298:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (this.SoA == 0)) {
        bool2 = true;
      }
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("notifyUser: selection ");
      List localList = this.oxE;
      kotlin.g.b.s.s(localList, "userList");
      Log.i((String)localObject, kotlin.a.p.ae(localList, j) + ' ' + j + ' ' + this.Soy + ", " + paramArrayList.size() + ' ' + this.SoA + ", result " + bool1 + ' ' + bool2);
      localObject = parama.dvO;
      parama.bH(paramArrayList);
      if (!bool1) {
        break label303;
      }
      Log.i(this.TAG, "remove user from gallery " + j + ' ' + parama);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, j));
      AppMethodBeat.o(119239);
      return;
      i = 0;
      break;
      i = 0;
      break;
      bool1 = false;
      break label61;
    }
    label303:
    if (!bool2)
    {
      AppMethodBeat.o(119239);
      return;
    }
    if ((this.SoA == 0) || (j != this.Soy))
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, j, paramArrayList));
      AppMethodBeat.o(119239);
      return;
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, j, paramArrayList, f.a.M((List)localObject, (List)paramArrayList)));
    AppMethodBeat.o(119239);
  }
  
  private static final void a(final g paramg)
  {
    Object localObject2 = null;
    AppMethodBeat.i(367054);
    kotlin.g.b.s.u(paramg, "this$0");
    int i;
    Object localObject1;
    label106:
    String str;
    StringBuilder localStringBuilder;
    if ((paramg.Soy >= 0) && (paramg.Soy < paramg.oxE.size()) && ((paramg.Soy == paramg.Spd) || (paramg.Spd == -1)))
    {
      i = 1;
      if (i != 0)
      {
        localObject1 = (com.tencent.mm.plugin.story.model.d.h)kotlin.a.p.ae((List)((a)paramg.oxE.get(paramg.Soy)).dvO, paramg.Soz);
        if (localObject1 != null) {
          break label247;
        }
        localObject1 = null;
        str = paramg.TAG;
        localStringBuilder = new StringBuilder("setSelectedRead ").append(paramg.Soz).append(", ");
        if (localObject1 != null) {
          break label257;
        }
      }
    }
    for (;;)
    {
      Log.i(str, localObject2);
      if ((localObject1 != null) && (((com.tencent.mm.plugin.story.model.d.g)localObject1).Smm.size() > 0))
      {
        localObject2 = b.SlF;
        long l = ((com.tencent.mm.plugin.story.model.d.g)localObject1).idH;
        localObject2 = ((com.tencent.mm.plugin.story.model.d.g)localObject1).Smm.getLast();
        kotlin.g.b.s.s(localObject2, "comment.visitorList.last");
        if (b.b(l, (com.tencent.mm.plugin.story.model.b.a)localObject2)) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i((com.tencent.mm.plugin.story.model.d.g)localObject1, paramg));
        }
      }
      paramg.Spd = -1;
      AppMethodBeat.o(367054);
      return;
      i = 0;
      break;
      label247:
      localObject1 = ((com.tencent.mm.plugin.story.model.d.h)localObject1).Sms;
      break label106;
      label257:
      localObject2 = Boolean.valueOf(((com.tencent.mm.plugin.story.model.d.g)localObject1).Smi);
    }
  }
  
  private static final void b(final g paramg)
  {
    Object localObject2 = null;
    AppMethodBeat.i(367059);
    kotlin.g.b.s.u(paramg, "this$0");
    int i;
    Object localObject1;
    label106:
    String str;
    StringBuilder localStringBuilder;
    if ((paramg.Soy >= 0) && (paramg.Soy < paramg.oxE.size()) && ((paramg.Soy == paramg.Spd) || (paramg.Spd == -1)))
    {
      i = 1;
      if (i != 0)
      {
        localObject1 = (com.tencent.mm.plugin.story.model.d.h)kotlin.a.p.ae((List)((a)paramg.oxE.get(paramg.Soy)).dvO, paramg.Soz);
        if (localObject1 != null) {
          break label247;
        }
        localObject1 = null;
        str = paramg.TAG;
        localStringBuilder = new StringBuilder("setSelectedRead ").append(paramg.Soz).append(", ");
        if (localObject1 != null) {
          break label257;
        }
      }
    }
    for (;;)
    {
      Log.i(str, localObject2);
      if ((localObject1 != null) && (((com.tencent.mm.plugin.story.model.d.g)localObject1).PmC.size() > 0))
      {
        localObject2 = b.SlF;
        long l = ((com.tencent.mm.plugin.story.model.d.g)localObject1).idH;
        localObject2 = ((com.tencent.mm.plugin.story.model.d.g)localObject1).PmC.getLast();
        kotlin.g.b.s.s(localObject2, "comment.msgList.last");
        if (b.b(l, (com.tencent.mm.plugin.story.model.b.a)localObject2)) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f((com.tencent.mm.plugin.story.model.d.g)localObject1, paramg));
        }
      }
      paramg.Spd = -1;
      AppMethodBeat.o(367059);
      return;
      i = 0;
      break;
      label247:
      localObject1 = ((com.tencent.mm.plugin.story.model.d.h)localObject1).Sms;
      break label106;
      label257:
      localObject2 = Boolean.valueOf(((com.tencent.mm.plugin.story.model.d.g)localObject1).Smj);
    }
  }
  
  private static final void c(final g paramg)
  {
    Object localObject3 = null;
    AppMethodBeat.i(367064);
    kotlin.g.b.s.u(paramg, "this$0");
    int i;
    Object localObject2;
    Object localObject1;
    if ((paramg.Soy >= 0) && (paramg.Soy < paramg.oxE.size()) && ((paramg.Soy == paramg.Spd) || (paramg.Spd == -1)))
    {
      i = 1;
      if (i != 0)
      {
        localObject2 = (a)paramg.oxE.get(paramg.Soy);
        localObject1 = (com.tencent.mm.plugin.story.model.d.h)kotlin.a.p.ae((List)((a)localObject2).dvO, paramg.Soz);
        if (localObject1 != null) {
          break label264;
        }
        localObject1 = null;
        label110:
        localObject2 = (com.tencent.mm.plugin.story.model.d.h)kotlin.a.p.ae((List)((a)localObject2).dvO, paramg.Soz);
        if (localObject2 != null) {
          break label274;
        }
        localObject2 = null;
        label138:
        String str = paramg.TAG;
        StringBuilder localStringBuilder = new StringBuilder("setSelectedRead ").append(paramg.Soz).append(", ");
        if (localObject1 != null) {
          break label284;
        }
        label174:
        Log.i(str, localObject3);
        if (!paramg.SoB) {
          break label297;
        }
        if ((localObject2 != null) && (((j)localObject2).hzs()))
        {
          ((j)localObject2).ER(false);
          localObject1 = m.Sks;
          m.a.aB(((j)localObject2).field_storyID, ((j)localObject2).field_localFlag);
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(paramg));
        }
      }
    }
    for (;;)
    {
      paramg.Spd = -1;
      AppMethodBeat.o(367064);
      return;
      i = 0;
      break;
      label264:
      localObject1 = ((com.tencent.mm.plugin.story.model.d.h)localObject1).Sms;
      break label110;
      label274:
      localObject2 = ((com.tencent.mm.plugin.story.model.d.h)localObject2).Smo;
      break label138;
      label284:
      localObject3 = Boolean.valueOf(((com.tencent.mm.plugin.story.model.d.g)localObject1).Sly);
      break label174;
      label297:
      if ((localObject2 != null) && (((j)localObject2).hzs()))
      {
        ((j)localObject2).ER(false);
        localObject3 = m.Sks;
        m.a.aB(((j)localObject2).field_storyID, ((j)localObject2).field_localFlag);
      }
      if ((localObject1 != null) && (((com.tencent.mm.plugin.story.model.d.g)localObject1).commentList.size() > 0))
      {
        localObject2 = b.SlF;
        long l = ((com.tencent.mm.plugin.story.model.d.g)localObject1).idH;
        localObject2 = ((com.tencent.mm.plugin.story.model.d.g)localObject1).commentList.getLast();
        kotlin.g.b.s.s(localObject2, "comment.commentList.last");
        if (b.b(l, (com.tencent.mm.plugin.story.model.b.a)localObject2)) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h((com.tencent.mm.plugin.story.model.d.g)localObject1, paramg));
        }
      }
    }
  }
  
  private final void hxk()
  {
    AppMethodBeat.i(119238);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new g..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(119238);
  }
  
  private final void hxl()
  {
    AppMethodBeat.i(119237);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new g..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(119237);
  }
  
  private final void hxt()
  {
    AppMethodBeat.i(119241);
    for (;;)
    {
      if ((this.Spc) || (this.Spb.size() <= 0))
      {
        AppMethodBeat.o(119241);
        return;
      }
      a locala = (a)this.Spb.get(0);
      int i = this.oxE.indexOf(locala);
      if (i >= 0) {
        if (i < this.oxE.size()) {
          i = 1;
        }
      }
      while ((i != 0) && (locala.state != 2))
      {
        locala.state = 2;
        Log.i(this.TAG, kotlin.g.b.s.X("LogStory: loadRemoteForUser ", locala));
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).loadStory(locala.username, this.pJq);
        this.Spc = true;
        AppMethodBeat.o(119241);
        return;
        i = 0;
        continue;
        i = 0;
      }
      this.Spb.remove(0);
    }
  }
  
  public final void M(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(119231);
    if (paramInt1 == 3)
    {
      if (paramBoolean)
      {
        switch (paramInt2)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(119231);
          return;
          StoryCore.b localb = StoryCore.SjP;
          StoryCore.b.gHI().post(new g..ExternalSyntheticLambda1(this));
          AppMethodBeat.o(119231);
          return;
          hxl();
        }
      }
      hxl();
    }
    AppMethodBeat.o(119231);
  }
  
  public final void aWi() {}
  
  public final void anf(int paramInt)
  {
    AppMethodBeat.i(119232);
    this.SoA = paramInt;
    if ((this.SoA == 1) && (!this.SoB)) {
      hxk();
    }
    AppMethodBeat.o(119232);
  }
  
  public final void anj(int paramInt)
  {
    AppMethodBeat.i(119235);
    Object localObject = this.oxE;
    kotlin.g.b.s.s(localObject, "userList");
    localObject = (a)kotlin.a.p.ae((List)localObject, paramInt);
    if (localObject != null) {
      a((a)localObject);
    }
    localObject = this.oxE;
    kotlin.g.b.s.s(localObject, "userList");
    localObject = (a)kotlin.a.p.ae((List)localObject, this.SoZ + paramInt);
    List localList = this.oxE;
    kotlin.g.b.s.s(localList, "userList");
    com.tencent.mm.ae.d.d("MultiUserGalleryPresenter_checkLoadMore", (kotlin.g.a.a)new b((a)localObject, (a)kotlin.a.p.ae(localList, this.Spa + paramInt), this));
    AppMethodBeat.o(119235);
  }
  
  public final void ank(int paramInt)
  {
    this.Spd = paramInt;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(119230);
    com.tencent.mm.kernel.h.baD().mCm.b(273, (com.tencent.mm.am.h)this);
    b localb = b.SlF;
    b.h(this.SmW);
    AppMethodBeat.o(119230);
  }
  
  public final void hxn()
  {
    AppMethodBeat.i(119233);
    int i;
    if (this.oxE.size() <= 3)
    {
      i = this.oxE.size();
      if (i <= 0) {}
    }
    int k;
    for (int j = 0;; j = k)
    {
      k = j + 1;
      Object localObject = this.oxE.get(j);
      kotlin.g.b.s.s(localObject, "userList[i]");
      a((a)localObject);
      if (k >= i)
      {
        if (this.oxE.size() > 0)
        {
          this.Spb.add(this.oxE.get(0));
          hxt();
        }
        AppMethodBeat.o(119233);
        return;
        i = 3;
        break;
      }
    }
  }
  
  public final void ma(int paramInt1, int paramInt2) {}
  
  public final void mb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119234);
    this.Soy = paramInt1;
    this.Soz = paramInt2;
    if (this.SoA == 1) {
      hxk();
    }
    AppMethodBeat.o(119234);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    int j = 1;
    AppMethodBeat.i(119236);
    kotlin.g.b.s.u(paramp, "scene");
    if (this.Spb.size() <= 0)
    {
      AppMethodBeat.o(119236);
      return;
    }
    a locala = (a)this.Spb.get(0);
    int k = this.oxE.indexOf(locala);
    int i;
    if (k >= 0) {
      if (k < this.oxE.size()) {
        i = 1;
      }
    }
    while (i == 0)
    {
      this.Spb.remove(0);
      this.Spc = false;
      hxt();
      AppMethodBeat.o(119236);
      return;
      i = 0;
      continue;
      i = 0;
    }
    Log.i(this.TAG, "LogStory: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString + ", " + k + ' ' + locala);
    if ((paramp instanceof com.tencent.mm.plugin.story.model.a.i))
    {
      if (k < 0) {
        break label402;
      }
      if (k >= this.oxE.size()) {
        break label397;
      }
      paramInt1 = j;
      if ((paramInt1 != 0) && (Util.isEqual(((com.tencent.mm.plugin.story.model.a.i)paramp).userName, locala.username)))
      {
        this.Spb.remove(0);
        this.Spc = false;
        kotlin.g.b.s.s(locala, "user");
        Log.i(this.TAG, "LogStory: updateUserGalleryItemsFromDb " + locala.username + ' ' + this.oxE.indexOf(locala));
        if (!this.Sph) {
          break label407;
        }
        paramString = f.a.k(locala.username, this.Spg, locala.Spi);
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "LogStory: db data " + locala + ' ' + paramString.size());
      a(locala, paramString);
      hxt();
      AppMethodBeat.o(119236);
      return;
      label397:
      paramInt1 = 0;
      break;
      label402:
      paramInt1 = 0;
      break;
      label407:
      if (this.Spf)
      {
        paramString = locala.username;
        paramp = locala.username;
        StoryCore.b localb = StoryCore.SjP;
        paramString = f.a.b(paramString, Util.isEqual(paramp, StoryCore.b.hgg()), (ArrayList)this.SoY.get(locala.username));
      }
      else
      {
        paramString = f.a.jdMethod_do(locala.username, this.Spg);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter$UserData;", "", "username", "", "state", "", "items", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "timestampBound", "(Ljava/lang/String;ILjava/util/ArrayList;I)V", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "getState", "()I", "setState", "(I)V", "getTimestampBound", "setTimestampBound", "getUsername", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    int Spi;
    ArrayList<com.tencent.mm.plugin.story.model.d.h> dvO;
    int state;
    final String username;
    
    private a(String paramString, ArrayList<com.tencent.mm.plugin.story.model.d.h> paramArrayList, int paramInt)
    {
      AppMethodBeat.i(119208);
      this.username = paramString;
      this.state = 0;
      this.dvO = paramArrayList;
      this.Spi = paramInt;
      AppMethodBeat.o(119208);
    }
    
    public final void bH(ArrayList<com.tencent.mm.plugin.story.model.d.h> paramArrayList)
    {
      AppMethodBeat.i(119207);
      kotlin.g.b.s.u(paramArrayList, "<set-?>");
      this.dvO = paramArrayList;
      AppMethodBeat.o(119207);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(119212);
      if (this == paramObject)
      {
        AppMethodBeat.o(119212);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(119212);
        return false;
      }
      paramObject = (a)paramObject;
      if (!kotlin.g.b.s.p(this.username, paramObject.username))
      {
        AppMethodBeat.o(119212);
        return false;
      }
      if (this.state != paramObject.state)
      {
        AppMethodBeat.o(119212);
        return false;
      }
      if (!kotlin.g.b.s.p(this.dvO, paramObject.dvO))
      {
        AppMethodBeat.o(119212);
        return false;
      }
      if (this.Spi != paramObject.Spi)
      {
        AppMethodBeat.o(119212);
        return false;
      }
      AppMethodBeat.o(119212);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(119211);
      int i = this.username.hashCode();
      int j = this.state;
      int k = this.dvO.hashCode();
      int m = this.Spi;
      AppMethodBeat.o(119211);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(119210);
      String str = "UserData(username=" + this.username + ", state=" + this.state + ", items=" + this.dvO + ", timestampBound=" + this.Spi + ')';
      AppMethodBeat.o(119210);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(g.a parama1, g.a parama2, g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(g paramg, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(g paramg, int paramInt, ArrayList<com.tencent.mm.plugin.story.model.d.h> paramArrayList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(g paramg, int paramInt, ArrayList<com.tencent.mm.plugin.story.model.d.h> paramArrayList, androidx.recyclerview.widget.g.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(com.tencent.mm.plugin.story.model.d.g paramg, g paramg1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(com.tencent.mm.plugin.story.model.d.g paramg, g paramg1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(com.tencent.mm.plugin.story.model.d.g paramg, g paramg1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements r<Long, Boolean, String, String, ah>
  {
    j(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g
 * JD-Core Version:    0.7.0.1
 */