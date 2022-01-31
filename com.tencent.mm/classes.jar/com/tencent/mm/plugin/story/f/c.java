package com.tencent.mm.plugin.story.f;

import a.f.a.r;
import a.f.b.z;
import a.v;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.story.model.d.g.a;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.n.a;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/presenter/FavStoryPresenter;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "username", "", "dateList", "", "galleryUserCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;)V", "TAG", "dateGalleryMap", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "dateState", "Lcom/tencent/mm/plugin/story/presenter/GalleryUserState;", "deleteColumnIndex", "", "deleteRowIndex", "galleryState", "isSelf", "", "loadingIndexQueue", "Ljava/util/LinkedList;", "selectedCol", "selectedRow", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "cancelDeleteItem", "row", "column", "deleteItem", "destroy", "initLoad", "notifyDateUpdate", "userIndex", "userGalleryItems", "onGalleryState", "state", "onItemRemovedCallback", "isOk", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onSetFavoriteCallback", "favorite", "selectedDate", "success", "onSetPrivacyCallback", "isPrivacy", "preloadForUser", "setFavorite", "nowFavorite", "replaceInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "setSelectedRead", "plugin-story_release"})
public final class c
  extends g
  implements com.tencent.mm.ai.f
{
  private final String TAG;
  private boolean ctJ;
  private final ArrayList<ArrayList<com.tencent.mm.plugin.story.model.d.g>> sBf;
  private final ArrayList<f> sBg;
  private final LinkedList<Integer> sBh;
  private int sBi;
  private int sBj;
  private int sBk;
  private int sBl;
  private int sBm;
  private final d sBn;
  private final List<String> syn;
  private final r<Long, Boolean, String, String, y> szb;
  private final String username;
  
  public c(String paramString, List<String> paramList, d paramd)
  {
    AppMethodBeat.i(109573);
    this.username = paramString;
    this.syn = paramList;
    this.sBn = paramd;
    this.TAG = "MicroMsg.FavStoryPresenter";
    this.sBf = new ArrayList();
    this.sBg = new ArrayList();
    this.sBh = new LinkedList();
    this.sBi = -1;
    this.sBj = -1;
    this.sBk = -1;
    this.sBl = -1;
    this.szb = ((r)new c.j(this));
    paramString = com.tencent.mm.plugin.story.model.j.svi;
    this.ctJ = bo.isEqual(j.b.coK(), this.username);
    this.sBn.FM(this.syn.size());
    paramString = ((Iterable)this.syn).iterator();
    while (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      ab.i(this.TAG, "LogStory: ".concat(String.valueOf(paramList)));
      this.sBf.add(new ArrayList());
      this.sBg.add(new f(paramList));
    }
    if (this.ctJ)
    {
      paramString = com.tencent.mm.kernel.g.RK();
      a.f.b.j.p(paramString, "MMKernel.network()");
      paramString.Rc().a(764, (com.tencent.mm.ai.f)this);
    }
    paramString = com.tencent.mm.plugin.story.model.b.b.sxN;
    com.tencent.mm.plugin.story.model.b.b.b(this.szb);
    AppMethodBeat.o(109573);
  }
  
  private final void a(boolean paramBoolean1, ArrayList<com.tencent.mm.plugin.story.model.d.g> paramArrayList, boolean paramBoolean2)
  {
    AppMethodBeat.i(151088);
    if ((!paramBoolean1) && (paramArrayList != null))
    {
      int i = this.sBf.indexOf(paramArrayList);
      this.sBf.remove(paramArrayList);
      com.tencent.mm.ab.b.b((a.f.a.a)new c.f(i, this));
    }
    com.tencent.mm.ab.b.b((a.f.a.a)new c.g(this, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(151088);
  }
  
  private final void cCk()
  {
    AppMethodBeat.i(138802);
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.coO().post((Runnable)new i(this));
    AppMethodBeat.o(138802);
  }
  
  private final void i(final int paramInt, List<com.tencent.mm.plugin.story.model.d.g> paramList)
  {
    AppMethodBeat.i(138801);
    if (paramList.isEmpty())
    {
      Collection localCollection = (Collection)this.sBf;
      if (localCollection == null)
      {
        paramList = new v("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(138801);
        throw paramList;
      }
      z.dk(localCollection).remove(paramList);
      com.tencent.mm.ab.b.b((a.f.a.a)new b(this, paramInt));
      AppMethodBeat.o(138801);
      return;
    }
    com.tencent.mm.ab.b.b((a.f.a.a)new c.c(this, paramInt, paramList));
    AppMethodBeat.o(138801);
  }
  
  private final void lW(boolean paramBoolean)
  {
    AppMethodBeat.i(109563);
    com.tencent.mm.ab.b.b((a.f.a.a)new c.d(this, paramBoolean));
    AppMethodBeat.o(109563);
  }
  
  public final void FL(int paramInt)
  {
    AppMethodBeat.i(138803);
    this.sBm = paramInt;
    if (this.sBm == 1) {
      cCk();
    }
    AppMethodBeat.o(138803);
  }
  
  public final void cCl()
  {
    AppMethodBeat.i(109565);
    this.sBi = -1;
    this.sBj = -1;
    n.a locala = com.tencent.mm.plugin.story.model.n.svx;
    n.a.cAW();
    AppMethodBeat.o(109565);
  }
  
  public final void cCm()
  {
    int j = 0;
    AppMethodBeat.i(109567);
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
    Object localObject2 = this.username;
    a.f.b.j.q(localObject2, "username");
    localObject1 = new ArrayList();
    Object localObject3 = com.tencent.mm.plugin.story.model.j.svi;
    localObject3 = j.b.cAB();
    Object localObject4 = com.tencent.mm.plugin.story.model.j.svi;
    localObject3 = ((com.tencent.mm.plugin.story.h.k)localObject3).bD((String)localObject2, bo.isEqual((String)localObject2, j.b.coK())).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (com.tencent.mm.plugin.story.h.j)((Iterator)localObject3).next();
      cic localcic = ((com.tencent.mm.plugin.story.h.j)localObject4).cEY();
      if ((localcic.xSK != null) && (localcic.xSK.wOa.size() != 0))
      {
        g.a locala = com.tencent.mm.plugin.story.model.d.g.syw;
        a.f.b.j.p(localObject4, "story");
        ((ArrayList)localObject1).add(g.a.b((com.tencent.mm.plugin.story.h.j)localObject4));
        ab.i(g.TAG, "getFavGalleryItemsFromDb story username " + (String)localObject2 + ' ' + ((ArrayList)localObject1).size() + ' ' + "content " + ((chl)localcic.xSK.wOa.get(0)).xrS + ' ' + "and " + ((chl)localcic.xSK.wOa.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.h.j)localObject4).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.h.j)localObject4).field_userName);
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
          a.a.j.eaS();
        }
        localObject3 = (com.tencent.mm.plugin.story.model.d.g)localObject3;
        if (i < this.sBf.size()) {
          ((ArrayList)this.sBf.get(i)).add(localObject3);
        }
        i += 1;
      }
      ab.i(this.TAG, "LogStory: preload Db data " + ((ArrayList)localObject1).size());
    }
    for (;;)
    {
      localObject1 = ((Iterable)this.syn).iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        ((Iterator)localObject1).next();
        if (i < 0) {
          a.a.j.eaS();
        }
        localObject2 = this.sBf.get(i);
        a.f.b.j.p(localObject2, "dateGalleryMap[index]");
        i(i, (List)localObject2);
        i += 1;
      }
      ab.i(this.TAG, "LogStory: initLoad no data");
    }
    AppMethodBeat.o(109567);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(109566);
    if (this.ctJ)
    {
      localObject = com.tencent.mm.kernel.g.RK();
      a.f.b.j.p(localObject, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject).Rc().b(764, (com.tencent.mm.ai.f)this);
    }
    Object localObject = com.tencent.mm.plugin.story.model.b.b.sxN;
    com.tencent.mm.plugin.story.model.b.b.c(this.szb);
    AppMethodBeat.o(109566);
  }
  
  public final void gb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109568);
    ab.i(this.TAG, "LogStory: deleteItem ".concat(String.valueOf(paramInt1)));
    if ((paramInt1 >= 0) && (paramInt1 < this.sBf.size()) && (paramInt2 >= 0) && (paramInt2 < ((ArrayList)this.sBf.get(paramInt1)).size()))
    {
      j.b localb = com.tencent.mm.plugin.story.model.j.svi;
      j.b.coO().post((Runnable)new c.a(this, paramInt1, paramInt2));
    }
    AppMethodBeat.o(109568);
  }
  
  public final void gc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109569);
    ab.d(this.TAG, "onSelected row=" + paramInt1 + " column=" + paramInt2);
    this.sBk = paramInt1;
    this.sBl = paramInt2;
    if (this.sBm == 1) {
      cCk();
    }
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.coO().post((Runnable)new c.e(this, paramInt1));
    AppMethodBeat.o(109569);
  }
  
  public final void n(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(109570);
    ab.i(this.TAG, "LogStory: setPrivacy row:" + paramInt1 + " column:" + paramInt2);
    Object localObject1;
    Object localObject2;
    if ((paramInt1 >= 0) && (paramInt1 < this.syn.size()) && (paramInt2 >= 0) && (paramInt2 < ((ArrayList)this.sBf.get(paramInt1)).size()))
    {
      if (paramBoolean) {
        break label251;
      }
      paramBoolean = true;
      localObject1 = ((ArrayList)this.sBf.get(paramInt1)).get(paramInt2);
      a.f.b.j.p(localObject1, "dateGalleryMap[row][column]");
      localObject1 = (com.tencent.mm.plugin.story.model.d.g)localObject1;
      ab.i(this.TAG, "LogStory: setPrivacy storyinfo " + localObject1 + " targetPrivacy:" + paramBoolean);
      localObject2 = com.tencent.mm.plugin.story.model.j.svi;
      localObject1 = j.b.cAB().Gb((int)((com.tencent.mm.plugin.story.model.d.g)localObject1).syt.systemRowid);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.story.g.f.sEx;
        com.tencent.mm.plugin.story.g.f.ma(paramBoolean);
        if (!paramBoolean) {
          break label256;
        }
      }
    }
    label256:
    for (long l = 3L;; l = 4L)
    {
      localObject2 = com.tencent.mm.plugin.story.g.i.sFa;
      com.tencent.mm.plugin.story.g.i.a(l, String.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID), 0L, 0L, 28);
      localObject2 = com.tencent.mm.plugin.story.model.n.svx;
      n.a.b(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID, (int)((com.tencent.mm.plugin.story.h.j)localObject1).systemRowid, paramBoolean, ((com.tencent.mm.plugin.story.h.j)localObject1).cFe());
      AppMethodBeat.o(109570);
      return;
      label251:
      paramBoolean = false;
      break;
    }
  }
  
  public final void o(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(138804);
    ab.i(this.TAG, "LogStory: setFavorite ".concat(String.valueOf(paramInt2)));
    Object localObject1;
    Object localObject2;
    if ((paramInt1 >= 0) && (paramInt1 < this.syn.size()) && (paramInt2 >= 0) && (paramInt2 < ((ArrayList)this.sBf.get(paramInt1)).size()))
    {
      if (paramBoolean) {
        break label290;
      }
      paramBoolean = true;
      localObject1 = ((ArrayList)this.sBf.get(paramInt1)).get(paramInt2);
      a.f.b.j.p(localObject1, "dateGalleryMap[row][column]");
      localObject1 = (com.tencent.mm.plugin.story.model.d.g)localObject1;
      ab.i(this.TAG, "LogStory: setFavorite storyinfo " + localObject1 + " localid " + ((com.tencent.mm.plugin.story.model.d.g)localObject1).syr.cIp + " targetFavorite:" + paramBoolean);
      localObject2 = com.tencent.mm.plugin.story.model.j.svi;
      localObject1 = j.b.cAB().Gb((int)((com.tencent.mm.plugin.story.model.d.g)localObject1).syt.systemRowid);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.story.g.f.sEx;
        com.tencent.mm.plugin.story.g.f.lZ(paramBoolean);
        if (!paramBoolean) {
          break label295;
        }
      }
    }
    label290:
    label295:
    for (long l = 1L;; l = 2L)
    {
      localObject2 = com.tencent.mm.plugin.story.g.i.sFa;
      com.tencent.mm.plugin.story.g.i.a(l, String.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID), 0L, 0L, 28);
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      ((ArrayList)localObject2).add(Long.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID));
      localArrayList.add(Integer.valueOf((int)((com.tencent.mm.plugin.story.h.j)localObject1).systemRowid));
      localObject1 = com.tencent.mm.plugin.story.model.n.svx;
      n.a.a((List)localObject2, (List)localArrayList, paramBoolean);
      AppMethodBeat.o(138804);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(109571);
    a.f.b.j.q(paramm, "scene");
    ab.i(this.TAG, "LogStory: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString);
    if ((paramm instanceof com.tencent.mm.plugin.story.model.a.g))
    {
      com.tencent.mm.plugin.story.model.a.a locala = ((com.tencent.mm.plugin.story.model.a.g)paramm).cBG();
      if (locala != null)
      {
        if ((locala instanceof com.tencent.mm.plugin.story.model.a.m))
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
          for (bool = true;; bool = false)
          {
            lW(bool);
            AppMethodBeat.o(109571);
            return;
          }
        }
        if ((locala instanceof com.tencent.mm.plugin.story.model.a.n))
        {
          ab.i(this.TAG, "onSceneEnd MMSTORY_OBJ_OP_VISIBILITY_TYPE errType:" + paramInt1 + ", errcode:" + paramInt2);
          if (paramInt2 == 0)
          {
            paramString = ((Iterable)((com.tencent.mm.plugin.story.model.a.g)paramm).sxi).iterator();
            while (paramString.hasNext())
            {
              paramInt1 = ((Number)paramString.next()).intValue();
              paramm = com.tencent.mm.plugin.story.model.n.svx;
              n.a.fY(paramInt1, ((com.tencent.mm.plugin.story.model.a.n)locala).sxw);
            }
            if ((((com.tencent.mm.plugin.story.model.a.n)locala).sxw == 1) && (!((com.tencent.mm.plugin.story.model.a.n)locala).sxx)) {}
            for (bool = true;; bool = false)
            {
              com.tencent.mm.ab.b.b((a.f.a.a)new h(this, bool));
              AppMethodBeat.o(109571);
              return;
            }
          }
        }
        else if ((locala instanceof com.tencent.mm.plugin.story.model.a.l))
        {
          if (paramInt2 == 0)
          {
            Iterator localIterator1 = ((Iterable)((com.tencent.mm.plugin.story.model.a.g)paramm).sxi).iterator();
            if (localIterator1.hasNext())
            {
              int j = ((Number)localIterator1.next()).intValue();
              ab.i(this.TAG, "onSceneEnd update story favorite: errType " + paramInt1 + ", errcode " + paramInt2 + ", localId " + j + ", favorite:" + ((com.tencent.mm.plugin.story.model.a.l)locala).sxv);
              paramString = com.tencent.mm.plugin.story.model.n.svx;
              n.a.fZ(j, ((com.tencent.mm.plugin.story.model.a.l)locala).sxv);
              Iterator localIterator2 = ((Iterable)this.sBf).iterator();
              label475:
              label509:
              int i;
              if (localIterator2.hasNext())
              {
                paramm = localIterator2.next();
                Iterator localIterator3 = ((Iterable)paramm).iterator();
                if (localIterator3.hasNext())
                {
                  paramString = localIterator3.next();
                  if ((int)((com.tencent.mm.plugin.story.model.d.g)paramString).syt.systemRowid == j)
                  {
                    i = 1;
                    label546:
                    if (i == 0) {
                      break label601;
                    }
                    label551:
                    if (paramString == null) {
                      break label608;
                    }
                    i = 1;
                    label558:
                    if (i == 0) {
                      break label612;
                    }
                    paramString = paramm;
                    label566:
                    paramString = (ArrayList)paramString;
                    if (((com.tencent.mm.plugin.story.model.a.l)locala).sxv != 1) {
                      break label619;
                    }
                  }
                }
              }
              label601:
              label608:
              label612:
              label619:
              for (bool = true;; bool = false)
              {
                a(bool, paramString, true);
                break;
                i = 0;
                break label546;
                break label509;
                paramString = null;
                break label551;
                i = 0;
                break label558;
                break label475;
                paramString = null;
                break label566;
              }
            }
            AppMethodBeat.o(109571);
            return;
          }
          paramString = com.tencent.mm.plugin.story.h.a.sFV;
          if (paramInt2 == com.tencent.mm.plugin.story.h.a.cEb()) {
            if (((com.tencent.mm.plugin.story.model.a.l)locala).sxv != 1) {
              break label673;
            }
          }
        }
        label673:
        for (final boolean bool = true;; bool = false)
        {
          a(bool, null, false);
          AppMethodBeat.o(109571);
          return;
        }
      }
    }
    AppMethodBeat.o(109571);
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class b
    extends a.f.b.k
    implements a.f.a.a<y>
  {
    b(c paramc, int paramInt)
    {
      super();
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class h
    extends a.f.b.k
    implements a.f.a.a<y>
  {
    h(c paramc, boolean paramBoolean)
    {
      super();
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(151087);
      if ((c.e(this.sBo) >= 0) && (c.e(this.sBo) < c.a(this.sBo).size()) && (c.f(this.sBo) >= 0) && (c.f(this.sBo) < ((ArrayList)c.a(this.sBo).get(c.e(this.sBo))).size()))
      {
        Object localObject1 = ((ArrayList)c.a(this.sBo).get(c.e(this.sBo))).get(c.f(this.sBo));
        a.f.b.j.p(localObject1, "dateGalleryMap[selectedRow][selectedCol]");
        localObject1 = ((com.tencent.mm.plugin.story.model.d.g)localObject1).sys;
        ab.i(c.g(this.sBo), "setSelectedRead " + c.f(this.sBo) + ", " + ((com.tencent.mm.plugin.story.model.d.f)localObject1).sxy);
        if (((com.tencent.mm.plugin.story.model.d.f)localObject1).rPQ.size() > 0)
        {
          Object localObject2 = com.tencent.mm.plugin.story.model.b.b.sxN;
          long l = ((com.tencent.mm.plugin.story.model.d.f)localObject1).cJA;
          localObject2 = ((com.tencent.mm.plugin.story.model.d.f)localObject1).rPQ.getLast();
          a.f.b.j.p(localObject2, "comment.commentList.last");
          if (com.tencent.mm.plugin.story.model.b.b.b(l, (com.tencent.mm.plugin.story.model.b.a)localObject2)) {
            com.tencent.mm.ab.b.b((a.f.a.a)new c.i.1(this, (com.tencent.mm.plugin.story.model.d.f)localObject1));
          }
        }
      }
      AppMethodBeat.o(151087);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c
 * JD-Core Version:    0.7.0.1
 */