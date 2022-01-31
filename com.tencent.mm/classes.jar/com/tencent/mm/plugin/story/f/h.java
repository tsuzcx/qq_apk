package com.tencent.mm.plugin.story.f;

import a.f.a.a;
import a.f.a.r;
import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "users", "", "", "chatRoom", "groupCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "isForSns", "", "storyFilterList", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;ZLjava/util/Map;)V", "TAG", "expectPos", "", "galleryState", "isLoadNetScene", "loadingUserQueue", "", "Lcom/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter$UserData;", "kotlin.jvm.PlatformType", "needFilter", "needLoadRemote", "preloadLocalCount", "preloadRemoteCount", "selectedCol", "selectedRow", "storyCommentChangeListener", "Lkotlin/Function4;", "", "userList", "checkLoadMore", "row", "deleteItem", "column", "destroy", "initExpectPosition", "initLoad", "loadMore", "loadNextQueuedUser", "notifyUser", "user", "items", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "onGalleryState", "state", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "preloadForUser", "setSelectedRead", "updateUserGalleryItemsFromDb", "UserData", "plugin-story_release"})
public final class h
  extends g
  implements f
{
  private final String TAG;
  private final List<h.a> fxt;
  private final String grA;
  private final int sBL;
  private final int sBM;
  private final List<h.a> sBN;
  private boolean sBO;
  private int sBP;
  private boolean sBQ;
  private boolean sBR;
  private final d sBS;
  private final boolean sBT;
  private final Map<String, ArrayList<Long>> sBU;
  private int sBk;
  private int sBl;
  private int sBm;
  private final r<Long, Boolean, String, String, y> szb;
  
  public h(List<String> paramList, String paramString, d paramd, boolean paramBoolean, Map<String, ? extends ArrayList<Long>> paramMap)
  {
    AppMethodBeat.i(138813);
    this.grA = paramString;
    this.sBS = paramd;
    this.sBT = paramBoolean;
    this.sBU = paramMap;
    this.TAG = "MicroMsg.MultiUserGalleryPresenter";
    this.sBL = 3;
    this.sBM = 1;
    this.fxt = Collections.synchronizedList((List)new ArrayList());
    this.sBN = Collections.synchronizedList((List)new LinkedList());
    this.sBk = -1;
    this.sBl = -1;
    if (!this.sBU.isEmpty()) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.sBR = paramBoolean;
      this.szb = ((r)new h.g(this));
      ab.i(this.TAG, "TimeDiff: local: " + System.currentTimeMillis() + ", server: " + cb.abp());
      ab.i(this.TAG, "chatRoom is " + this.grA);
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        paramString = (String)paramList.next();
        ab.i(this.TAG, "LogStory: ".concat(String.valueOf(paramString)));
        this.fxt.add(new h.a(paramString, new ArrayList()));
      }
    }
    this.sBS.FM(this.fxt.size());
    paramList = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(paramList, "network()");
    paramList.Rc().a(273, (f)this);
    paramList = com.tencent.mm.plugin.story.model.b.b.sxN;
    com.tencent.mm.plugin.story.model.b.b.b(this.szb);
    AppMethodBeat.o(138813);
  }
  
  private final void a(h.a parama)
  {
    AppMethodBeat.i(109608);
    if (this.fxt.indexOf(parama) < 0)
    {
      AppMethodBeat.o(109608);
      return;
    }
    if (parama.state != 0)
    {
      ab.i(this.TAG, "LogStory: preloadForUser already preload");
      AppMethodBeat.o(109608);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    int i;
    if (this.sBR)
    {
      parama.state = 2;
      localObject1 = parama.username;
      localObject2 = parama.username;
      j.b localb = com.tencent.mm.plugin.story.model.j.svi;
      localObject1 = g.a.b((String)localObject1, bo.isEqual((String)localObject2, j.b.coK()), (ArrayList)this.sBU.get(parama.username));
      if (!((Collection)localObject1).isEmpty())
      {
        i = 1;
        if (i != 0)
        {
          ab.i(this.TAG, "LogStory: preload add sync item and local item, " + ((ArrayList)localObject1).size());
          localArrayList.addAll((Collection)localObject1);
        }
      }
    }
    for (;;)
    {
      a(parama, localArrayList);
      AppMethodBeat.o(109608);
      return;
      i = 0;
      break;
      parama.state = 1;
      ab.i(this.TAG, "LogStory: preloadForUser ".concat(String.valueOf(parama)));
      localObject1 = g.a.bz(parama.username, this.sBT);
      if (localObject1 == null)
      {
        a(parama, localArrayList);
        AppMethodBeat.o(109608);
        return;
      }
      localObject2 = g.a.bA(parama.username, this.sBT);
      if (((ArrayList)localObject2).size() > 0)
      {
        ab.i(this.TAG, "LogStory: preload add sync item and local item, " + ((ArrayList)localObject2).size());
        if (((com.tencent.mm.plugin.story.model.d.g)((ArrayList)localObject2).get(0)).cJA != ((com.tencent.mm.plugin.story.model.d.g)localObject1).cJA) {
          localArrayList.add(localObject1);
        }
        localArrayList.addAll((Collection)localObject2);
      }
      else
      {
        ab.i(this.TAG, "LogStory: preload add sync item");
        localArrayList.add(localObject1);
      }
    }
  }
  
  private final void a(h.a parama, ArrayList<com.tencent.mm.plugin.story.model.d.g> paramArrayList)
  {
    boolean bool2 = false;
    AppMethodBeat.i(109607);
    final int j = this.fxt.indexOf(parama);
    boolean bool1;
    if (paramArrayList.isEmpty())
    {
      i = this.sBk;
      int k = this.sBk;
      if ((i - 1 > j) || (k + 1 < j))
      {
        bool1 = true;
        if (((Collection)paramArrayList).isEmpty()) {
          break label289;
        }
      }
    }
    Object localObject;
    label289:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (this.sBm == 0)) {
        bool2 = true;
      }
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("notifyUser: selection ");
      List localList = this.fxt;
      a.f.b.j.p(localList, "userList");
      ab.i((String)localObject, (h.a)a.a.j.w(localList, j) + ' ' + j + ' ' + this.sBk + ", " + paramArrayList.size() + ' ' + this.sBm + ", result " + bool1 + ' ' + bool2);
      localObject = parama.cBy;
      parama.V(paramArrayList);
      if (!bool1) {
        break label294;
      }
      ab.i(this.TAG, "remove user from gallery " + j + ' ' + parama);
      com.tencent.mm.ab.b.b((a)new c(this, j));
      AppMethodBeat.o(109607);
      return;
      bool1 = false;
      break;
    }
    label294:
    if (!bool2)
    {
      AppMethodBeat.o(109607);
      return;
    }
    if ((this.sBm == 0) || (j != this.sBk))
    {
      com.tencent.mm.ab.b.b((a)new h.d(this, j, paramArrayList));
      AppMethodBeat.o(109607);
      return;
    }
    com.tencent.mm.ab.b.b((a)new h.e(this, j, paramArrayList, g.a.o((List)localObject, (List)paramArrayList)));
    AppMethodBeat.o(109607);
  }
  
  private final void cCk()
  {
    AppMethodBeat.i(138812);
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.coO().post((Runnable)new h.f(this));
    AppMethodBeat.o(138812);
  }
  
  private final void cCo()
  {
    AppMethodBeat.i(109609);
    if ((this.sBO) || (this.sBN.size() <= 0))
    {
      AppMethodBeat.o(109609);
      return;
    }
    h.a locala = (h.a)this.sBN.get(0);
    int i = this.fxt.indexOf(locala);
    int j = this.fxt.size();
    if (i < 0) {}
    while ((j <= i) || (locala.state == 2))
    {
      this.sBN.remove(0);
      break;
    }
    locala.state = 2;
    ab.i(this.TAG, "LogStory: loadRemoteForUser ".concat(String.valueOf(locala)));
    ((e)com.tencent.mm.kernel.g.G(e.class)).loadStory(locala.username, this.grA);
    this.sBO = true;
    AppMethodBeat.o(109609);
  }
  
  public final void FL(int paramInt)
  {
    AppMethodBeat.i(109603);
    this.sBm = paramInt;
    if (this.sBm == 1) {
      cCk();
    }
    AppMethodBeat.o(109603);
  }
  
  public final void FP(int paramInt)
  {
    AppMethodBeat.i(109605);
    Object localObject = this.fxt;
    a.f.b.j.p(localObject, "userList");
    localObject = (h.a)a.a.j.w((List)localObject, paramInt);
    if (localObject != null) {
      a((h.a)localObject);
    }
    localObject = this.fxt;
    a.f.b.j.p(localObject, "userList");
    localObject = (h.a)a.a.j.w((List)localObject, this.sBL + paramInt);
    List localList = this.fxt;
    a.f.b.j.p(localList, "userList");
    com.tencent.mm.ab.b.a("MultiUserGalleryPresenter_checkLoadMore", (a)new h.b(this, (h.a)localObject, (h.a)a.a.j.w(localList, this.sBM + paramInt)));
    AppMethodBeat.o(109605);
  }
  
  public final void FQ(int paramInt)
  {
    this.sBP = paramInt;
  }
  
  public final void cCm()
  {
    AppMethodBeat.i(109604);
    if (this.fxt.size() <= 3) {}
    for (int i = this.fxt.size();; i = 3)
    {
      int j = 0;
      while (j < i)
      {
        Object localObject = this.fxt.get(j);
        a.f.b.j.p(localObject, "userList[i]");
        a((h.a)localObject);
        j += 1;
      }
    }
    if (this.fxt.size() > 0)
    {
      this.sBN.add(this.fxt.get(0));
      cCo();
    }
    AppMethodBeat.o(109604);
  }
  
  public final void ccL() {}
  
  public final void destroy()
  {
    AppMethodBeat.i(109602);
    Object localObject = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(localObject, "network()");
    ((com.tencent.mm.kernel.b)localObject).Rc().b(273, (f)this);
    localObject = com.tencent.mm.plugin.story.model.b.b.sxN;
    com.tencent.mm.plugin.story.model.b.b.c(this.szb);
    AppMethodBeat.o(109602);
  }
  
  public final void gb(int paramInt1, int paramInt2) {}
  
  public final void gc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138811);
    this.sBk = paramInt1;
    this.sBl = paramInt2;
    if (this.sBm == 1) {
      cCk();
    }
    AppMethodBeat.o(138811);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(109606);
    a.f.b.j.q(paramm, "scene");
    if (this.sBN.size() <= 0)
    {
      AppMethodBeat.o(109606);
      return;
    }
    h.a locala = (h.a)this.sBN.get(0);
    int i = this.fxt.indexOf(locala);
    int j = this.fxt.size();
    if ((i < 0) || (j <= i))
    {
      this.sBN.remove(0);
      this.sBO = false;
      cCo();
      AppMethodBeat.o(109606);
      return;
    }
    ab.i(this.TAG, "LogStory: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString + ", " + i + ' ' + locala);
    if ((paramm instanceof com.tencent.mm.plugin.story.model.a.j))
    {
      paramInt1 = this.fxt.size();
      if (i < 0)
      {
        AppMethodBeat.o(109606);
        return;
      }
      if ((paramInt1 > i) && (bo.isEqual(((com.tencent.mm.plugin.story.model.a.j)paramm).userName, locala.username)))
      {
        this.sBN.remove(0);
        this.sBO = false;
        a.f.b.j.p(locala, "user");
        ab.i(this.TAG, "LogStory: updateUserGalleryItemsFromDb " + locala.username + ' ' + this.fxt.indexOf(locala));
        paramString = g.a.bA(locala.username, this.sBT);
        ab.i(this.TAG, "LogStory: db data " + locala + ' ' + paramString.size());
        a(locala, paramString);
        cCo();
      }
    }
    AppMethodBeat.o(109606);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class c
    extends k
    implements a<y>
  {
    c(h paramh, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.h
 * JD-Core Version:    0.7.0.1
 */