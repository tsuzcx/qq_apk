package com.tencent.mm.plugin.story.f;

import a.f.b.z;
import a.v;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.model.a.e;
import com.tencent.mm.plugin.story.model.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/presenter/SelfHistoryGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "username", "", "dateList", "", "galleryUserCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "storyFilterList", "", "Ljava/util/ArrayList;", "", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;Ljava/util/Map;)V", "TAG", "dateGalleryMap", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "dateState", "Lcom/tencent/mm/plugin/story/presenter/GalleryUserState;", "deleteColumnIndex", "", "deleteRowIndex", "isLoadNetScene", "", "loadingIndexQueue", "Ljava/util/LinkedList;", "needFilter", "preloadLocalCount", "preloadRemoteCount", "selectedCol", "selectedRow", "cancelDeleteItem", "", "row", "column", "checkLoadMore", "deleteItem", "destroy", "getStoryCountByDate", "date", "initExpectPosition", "expectPos", "initLoad", "loadMore", "loadNextQueuedUser", "loadStoryByDate", "notifyDateUpdate", "userGalleryItems", "onGalleryState", "state", "onItemRemovedCallback", "isOk", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onSetFavoriteCallback", "favorite", "success", "onSetPrivacyCallback", "isPrivacy", "pause", "preloadForDate", "dateIndex", "resume", "setFavorite", "nowFavorite", "replaceInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "setSelectedRead", "updateUserGalleryItemsFromDb", "plugin-story_release"})
public final class j
  extends g
  implements com.tencent.mm.ai.f
{
  private final String TAG;
  private final int sBL;
  private final int sBM;
  private boolean sBO;
  private boolean sBR;
  private final Map<String, ArrayList<Long>> sBU;
  private final ArrayList<ArrayList<com.tencent.mm.plugin.story.model.d.g>> sBf;
  private final ArrayList<f> sBg;
  private final LinkedList<Integer> sBh;
  private int sBi;
  private int sBj;
  private int sBk;
  private int sBl;
  private final d sBn;
  private final List<String> syn;
  private final String username;
  
  public j(String paramString, List<String> paramList, d paramd, Map<String, ? extends ArrayList<Long>> paramMap)
  {
    AppMethodBeat.i(151094);
    this.username = paramString;
    this.syn = paramList;
    this.sBn = paramd;
    this.sBU = paramMap;
    this.TAG = "MicroMsg.SelfHistoryGalleryPresenter";
    this.sBL = 3;
    this.sBM = 1;
    this.sBf = new ArrayList();
    this.sBg = new ArrayList();
    this.sBh = new LinkedList();
    this.sBi = -1;
    this.sBj = -1;
    this.sBk = -1;
    this.sBl = -1;
    if (!this.sBU.isEmpty()) {}
    for (;;)
    {
      this.sBR = bool;
      this.sBn.FM(this.syn.size());
      paramString = ((Iterable)this.syn).iterator();
      while (paramString.hasNext())
      {
        paramList = (String)paramString.next();
        ab.i(this.TAG, "LogStory: ".concat(String.valueOf(paramList)));
        this.sBf.add(new ArrayList());
        this.sBg.add(new f(paramList));
      }
      bool = false;
    }
    paramString = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(paramString, "network()");
    paramString.Rc().a(764, (com.tencent.mm.ai.f)this);
    paramString = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(paramString, "network()");
    paramString.Rc().a(529, (com.tencent.mm.ai.f)this);
    AppMethodBeat.o(151094);
  }
  
  private final void O(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(151093);
    com.tencent.mm.ab.b.b((a.f.a.a)new g(this, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(151093);
  }
  
  private final void cCo()
  {
    AppMethodBeat.i(109661);
    for (;;)
    {
      if ((this.sBO) || (this.sBh.size() <= 0))
      {
        AppMethodBeat.o(109661);
        return;
      }
      Object localObject = this.sBh.get(0);
      a.f.b.j.p(localObject, "loadingIndexQueue[0]");
      int i = ((Number)localObject).intValue();
      localObject = (String)this.syn.get(i);
      ab.i(this.TAG, "LogStory: loadRemoteForDate ".concat(String.valueOf(localObject)));
      if (((f)this.sBg.get(i)).sBG != 2)
      {
        localObject = new e(this.username, (String)localObject);
        com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.RK();
        a.f.b.j.p(localb, "MMKernel.network()");
        localb.Rc().b((com.tencent.mm.ai.m)localObject);
        this.sBO = true;
        AppMethodBeat.o(109661);
        return;
      }
      this.sBh.remove(0);
    }
  }
  
  private final void lW(final boolean paramBoolean)
  {
    AppMethodBeat.i(109650);
    com.tencent.mm.ab.b.b((a.f.a.a)new e(this, paramBoolean));
    AppMethodBeat.o(109650);
  }
  
  private final void s(String paramString, List<com.tencent.mm.plugin.story.model.d.g> paramList)
  {
    AppMethodBeat.i(109651);
    int i = this.syn.indexOf(paramString);
    if (paramList.isEmpty())
    {
      paramString = (Collection)this.sBf;
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(109651);
        throw paramString;
      }
      z.dk(paramString).remove(paramList);
      com.tencent.mm.ab.b.b((a.f.a.a)new j.c(this, i));
      AppMethodBeat.o(109651);
      return;
    }
    com.tencent.mm.ab.b.b((a.f.a.a)new j.d(this, i, paramList));
    AppMethodBeat.o(109651);
  }
  
  public final void FL(int paramInt) {}
  
  public final void FP(int paramInt)
  {
    AppMethodBeat.i(109658);
    com.tencent.mm.plugin.story.model.j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    com.tencent.mm.plugin.story.model.j.b.coO().post((Runnable)new j.a(this, paramInt));
    AppMethodBeat.o(109658);
  }
  
  public final void FQ(int paramInt) {}
  
  public final void cCl()
  {
    AppMethodBeat.i(109652);
    this.sBi = -1;
    this.sBj = -1;
    n.a locala = com.tencent.mm.plugin.story.model.n.svx;
    n.a.cAW();
    AppMethodBeat.o(109652);
  }
  
  public final void cCm()
  {
    AppMethodBeat.i(109654);
    Object localObject1 = ((Iterable)this.syn).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      ((Iterator)localObject1).next();
      if (i < 0) {
        a.a.j.eaS();
      }
      ((f)this.sBg.get(i)).sBG = 1;
      i += 1;
    }
    localObject1 = ((Iterable)this.syn).iterator();
    i = 0;
    Object localObject3;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        a.a.j.eaS();
      }
      localObject3 = (String)this.syn.get(i);
      localObject2 = this.sBf.get(i);
      a.f.b.j.p(localObject2, "dateGalleryMap[dateIndex]");
      localObject2 = (ArrayList)localObject2;
      Object localObject4 = this.sBg.get(i);
      a.f.b.j.p(localObject4, "dateState[dateIndex]");
      localObject4 = (f)localObject4;
      if (this.sBR)
      {
        Object localObject6 = (Iterable)g.a.gO(this.username, (String)localObject3);
        localObject5 = (Collection)new ArrayList();
        localObject6 = ((Iterable)localObject6).iterator();
        label302:
        while (((Iterator)localObject6).hasNext())
        {
          Object localObject7 = ((Iterator)localObject6).next();
          com.tencent.mm.plugin.story.model.d.g localg = (com.tencent.mm.plugin.story.model.d.g)localObject7;
          ArrayList localArrayList = (ArrayList)this.sBU.get(localObject3);
          if (localArrayList != null) {}
          for (boolean bool = localArrayList.contains(Long.valueOf(localg.cJA));; bool = true)
          {
            if (!bool) {
              break label302;
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
            break label560;
          }
          ((ArrayList)localObject2).addAll((Collection)localObject3);
          ((f)localObject4).sBG = 2;
          ab.i(this.TAG, "LogStory: preload Db with filter data " + ((List)localObject3).size());
          i = j;
          break;
        }
      }
      Object localObject5 = com.tencent.mm.plugin.story.model.j.svi;
      localObject5 = com.tencent.mm.plugin.story.model.j.b.cAH().adE((String)localObject3);
      if (localObject5 != null)
      {
        i = ((h)localObject5).field_count;
        label413:
        ab.i(this.TAG, "LogStory: preloadForDate " + (String)localObject3 + " historyCount " + i);
        localObject3 = g.a.gO(this.username, (String)localObject3);
        if (((ArrayList)localObject3).size() <= 0) {
          break label540;
        }
        ((ArrayList)localObject2).addAll((Collection)localObject3);
        if (((ArrayList)localObject3).size() != i) {
          break label531;
        }
      }
      label531:
      for (((f)localObject4).sBG = 2;; ((f)localObject4).sBG = 1)
      {
        ab.i(this.TAG, "LogStory: preload Db data " + ((ArrayList)localObject3).size());
        i = j;
        break;
        i = 0;
        break label413;
      }
      label540:
      if (i != 0)
      {
        ((f)localObject4).sBG = 1;
        ab.i(this.TAG, "LogStory: initLoad Sync data");
      }
      label560:
      i = j;
    }
    if (this.syn.size() > 0)
    {
      this.sBh.add(Integer.valueOf(0));
      cCo();
    }
    localObject1 = (Iterable)this.syn;
    i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ((Iterator)localObject1).next();
      if (i < 0) {
        a.a.j.eaS();
      }
      localObject2 = (String)this.syn.get(i);
      localObject3 = this.sBf.get(i);
      a.f.b.j.p(localObject3, "dateGalleryMap[index]");
      s((String)localObject2, (List)localObject3);
      i += 1;
    }
    AppMethodBeat.o(109654);
  }
  
  public final void ccL() {}
  
  public final void destroy()
  {
    AppMethodBeat.i(109653);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(localb, "network()");
    localb.Rc().b(529, (com.tencent.mm.ai.f)this);
    localb = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(localb, "network()");
    localb.Rc().b(764, (com.tencent.mm.ai.f)this);
    AppMethodBeat.o(109653);
  }
  
  public final void gb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109655);
    ab.i(this.TAG, "LogStory: deleteItem ".concat(String.valueOf(paramInt1)));
    if ((paramInt1 >= 0) && (paramInt1 < this.syn.size()) && (paramInt2 >= 0) && (paramInt2 < ((ArrayList)this.sBf.get(paramInt1)).size()))
    {
      com.tencent.mm.plugin.story.model.j.b localb = com.tencent.mm.plugin.story.model.j.svi;
      com.tencent.mm.plugin.story.model.j.b.coO().post((Runnable)new j.b(this, paramInt1, paramInt2));
    }
    AppMethodBeat.o(109655);
  }
  
  public final void gc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109656);
    this.sBk = paramInt1;
    this.sBl = paramInt2;
    ab.d(this.TAG, "onSelected row=" + paramInt1 + " column=" + paramInt2);
    com.tencent.mm.plugin.story.model.j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    com.tencent.mm.plugin.story.model.j.b.coO().post((Runnable)new j.f(this, paramInt1));
    AppMethodBeat.o(109656);
  }
  
  public final void n(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(109657);
    ab.i(this.TAG, "LogStory: setPrivacy row:" + paramInt1 + " column:" + paramInt2);
    if ((paramInt1 >= 0) && (paramInt1 < this.syn.size()) && (paramInt2 >= 0) && (paramInt2 < ((ArrayList)this.sBf.get(paramInt1)).size()))
    {
      Object localObject1;
      Object localObject2;
      if (!paramBoolean)
      {
        paramBoolean = true;
        localObject1 = ((ArrayList)this.sBf.get(paramInt1)).get(paramInt2);
        a.f.b.j.p(localObject1, "dateGalleryMap[row][column]");
        localObject1 = (com.tencent.mm.plugin.story.model.d.g)localObject1;
        ab.i(this.TAG, "LogStory: setPrivacy storyinfo " + localObject1 + " targetPrivacy:" + paramBoolean);
        localObject2 = com.tencent.mm.plugin.story.model.j.svi;
        localObject1 = com.tencent.mm.plugin.story.model.j.b.cAB().Gb((int)((com.tencent.mm.plugin.story.model.d.g)localObject1).syt.systemRowid);
        if (localObject1 == null) {
          break label266;
        }
        localObject2 = com.tencent.mm.plugin.story.g.f.sEx;
        com.tencent.mm.plugin.story.g.f.ma(paramBoolean);
        if (!paramBoolean) {
          break label258;
        }
      }
      label258:
      for (long l = 3L;; l = 4L)
      {
        localObject2 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.a(l, String.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID), 2L, 0L, 16);
        localObject2 = com.tencent.mm.plugin.story.model.n.svx;
        n.a.b(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID, (int)((com.tencent.mm.plugin.story.h.j)localObject1).systemRowid, paramBoolean, ((com.tencent.mm.plugin.story.h.j)localObject1).cFe());
        AppMethodBeat.o(109657);
        return;
        paramBoolean = false;
        break;
      }
    }
    label266:
    AppMethodBeat.o(109657);
  }
  
  public final void o(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(138816);
    ab.i(this.TAG, "LogStory: setFavorite ".concat(String.valueOf(paramInt2)));
    Object localObject1;
    Object localObject2;
    if ((paramInt1 >= 0) && (paramInt1 < this.syn.size()) && (paramInt2 >= 0) && (paramInt2 < ((ArrayList)this.sBf.get(paramInt1)).size()))
    {
      if (paramBoolean) {
        break label292;
      }
      paramBoolean = true;
      localObject1 = ((ArrayList)this.sBf.get(paramInt1)).get(paramInt2);
      a.f.b.j.p(localObject1, "dateGalleryMap[row][column]");
      localObject1 = (com.tencent.mm.plugin.story.model.d.g)localObject1;
      ab.i(this.TAG, "LogStory: setFavorite storyinfo " + localObject1 + " localid " + ((com.tencent.mm.plugin.story.model.d.g)localObject1).syr.cIp + " targetFavorite:" + paramBoolean);
      localObject2 = com.tencent.mm.plugin.story.model.j.svi;
      localObject1 = com.tencent.mm.plugin.story.model.j.b.cAB().Gb((int)((com.tencent.mm.plugin.story.model.d.g)localObject1).syt.systemRowid);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.story.g.f.sEx;
        com.tencent.mm.plugin.story.g.f.lZ(paramBoolean);
        if (!paramBoolean) {
          break label297;
        }
      }
    }
    label292:
    label297:
    for (long l = 1L;; l = 2L)
    {
      localObject2 = com.tencent.mm.plugin.story.g.i.sFa;
      com.tencent.mm.plugin.story.g.i.a(l, String.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID), 2L, 0L, 16);
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      ((ArrayList)localObject2).add(Long.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID));
      localArrayList.add(Integer.valueOf((int)((com.tencent.mm.plugin.story.h.j)localObject1).systemRowid));
      localObject1 = com.tencent.mm.plugin.story.model.n.svx;
      n.a.a((List)localObject2, (List)localArrayList, paramBoolean);
      AppMethodBeat.o(138816);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    boolean bool1 = false;
    boolean bool3 = true;
    boolean bool2 = true;
    AppMethodBeat.i(109659);
    a.f.b.j.q(paramm, "scene");
    ab.i(this.TAG, "LogStory: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString);
    Object localObject;
    if (((paramm instanceof e)) && (bo.isEqual(((e)paramm).userName, this.username)))
    {
      paramString = (Integer)this.sBh.poll();
      if (paramString != null)
      {
        paramInt1 = ((Number)paramString).intValue();
        paramInt2 = this.syn.size();
        if (paramInt1 < 0)
        {
          AppMethodBeat.o(109659);
          return;
        }
        if (paramInt2 > paramInt1)
        {
          ab.d(this.TAG, paramInt1 + ' ' + (String)this.syn.get(paramInt1));
          this.sBO = false;
          ((f)this.sBg.get(paramInt1)).sBG = 2;
          ab.i(this.TAG, "LogStory: updateUserGalleryItemsFromDb ".concat(String.valueOf(paramInt1)));
          paramString = (String)this.syn.get(paramInt1);
          paramm = this.sBf.get(paramInt1);
          a.f.b.j.p(paramm, "dateGalleryMap[dateIndex]");
          paramm = (ArrayList)paramm;
          localObject = g.a.gO(this.username, paramString);
          paramm.clear();
          paramm.addAll((Collection)localObject);
          ab.i(this.TAG, "LogStory: db data " + paramString + ' ' + paramm.size());
          s(paramString, (List)paramm);
          cCo();
        }
        AppMethodBeat.o(109659);
        return;
      }
      AppMethodBeat.o(109659);
      return;
    }
    if ((paramm instanceof com.tencent.mm.plugin.story.model.a.g))
    {
      paramString = ((com.tencent.mm.plugin.story.model.a.g)paramm).cBG();
      if (paramString != null)
      {
        if ((paramString instanceof com.tencent.mm.plugin.story.model.a.m))
        {
          if (paramInt2 == 0)
          {
            paramString = ((Iterable)((com.tencent.mm.plugin.story.model.a.g)paramm).sxi).iterator();
            while (paramString.hasNext())
            {
              paramInt1 = ((Number)paramString.next()).intValue();
              paramm = com.tencent.mm.plugin.story.model.n.svx;
              n.a.FH(paramInt1);
            }
          }
          if (paramInt2 == 0) {}
          for (bool1 = true;; bool1 = false)
          {
            lW(bool1);
            AppMethodBeat.o(109659);
            return;
          }
        }
        if ((paramString instanceof com.tencent.mm.plugin.story.model.a.n))
        {
          ab.i(this.TAG, "onSceneEnd MMSTORY_OBJ_OP_VISIBILITY_TYPE errType:" + paramInt1 + ", errcode:" + paramInt2);
          if (paramInt2 == 0)
          {
            paramm = ((Iterable)((com.tencent.mm.plugin.story.model.a.g)paramm).sxi).iterator();
            while (paramm.hasNext())
            {
              paramInt1 = ((Number)paramm.next()).intValue();
              localObject = com.tencent.mm.plugin.story.model.n.svx;
              n.a.fY(paramInt1, ((com.tencent.mm.plugin.story.model.a.n)paramString).sxw);
            }
            if ((((com.tencent.mm.plugin.story.model.a.n)paramString).sxw == 1) && (!((com.tencent.mm.plugin.story.model.a.n)paramString).sxx)) {}
            for (bool1 = bool2;; bool1 = false)
            {
              com.tencent.mm.ab.b.b((a.f.a.a)new j.h(this, bool1));
              AppMethodBeat.o(109659);
              return;
            }
          }
        }
        else if ((paramString instanceof com.tencent.mm.plugin.story.model.a.l))
        {
          if (paramInt2 == 0)
          {
            paramm = ((Iterable)((com.tencent.mm.plugin.story.model.a.g)paramm).sxi).iterator();
            while (paramm.hasNext())
            {
              int i = ((Number)paramm.next()).intValue();
              ab.i(this.TAG, "onSceneEnd update story favorite: errType " + paramInt1 + ", errcode " + paramInt2 + ", localId " + i + ", favorite:" + ((com.tencent.mm.plugin.story.model.a.l)paramString).sxv);
              localObject = com.tencent.mm.plugin.story.model.n.svx;
              n.a.fZ(i, ((com.tencent.mm.plugin.story.model.a.l)paramString).sxv);
            }
            if (((com.tencent.mm.plugin.story.model.a.l)paramString).sxv == 1) {
              bool1 = true;
            }
            O(bool1, true);
            AppMethodBeat.o(109659);
            return;
          }
          paramm = com.tencent.mm.plugin.story.h.a.sFV;
          if (paramInt2 == com.tencent.mm.plugin.story.h.a.cEb()) {
            if (((com.tencent.mm.plugin.story.model.a.l)paramString).sxv != 1) {
              break label821;
            }
          }
        }
        label821:
        for (bool1 = bool3;; bool1 = false)
        {
          O(bool1, false);
          AppMethodBeat.o(109659);
          return;
        }
      }
    }
    AppMethodBeat.o(109659);
  }
  
  public final void pause() {}
  
  public final void resume() {}
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class e
    extends a.f.b.k
    implements a.f.a.a<y>
  {
    e(j paramj, boolean paramBoolean)
    {
      super();
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class g
    extends a.f.b.k
    implements a.f.a.a<y>
  {
    g(j paramj, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.j
 * JD-Core Version:    0.7.0.1
 */