package com.tencent.mm.plugin.story.f;

import a.f.a.r;
import a.y;
import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/presenter/SelfGalleryPresenter;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "username", "", "galleryCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;)V", "deleteItemIndex", "", "getGalleryCallback", "()Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "galleryState", "privateItemIndex", "selectedIndex", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "", "getUsername", "()Ljava/lang/String;", "cancelDeleteItem", "row", "column", "deleteItem", "destroy", "initExpectPosition", "expectPos", "initLoad", "loadMore", "onGalleryState", "state", "onItemRemovedCallback", "isOk", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onSetFavoriteCallback", "favorite", "success", "storyId", "onSetPrivacyCallback", "isPrivacy", "pause", "resume", "setFavorite", "nowFavorite", "replaceInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "setSelectedRead", "updateCommentRead", "Companion", "plugin-story_release"})
public final class i
  extends g
  implements com.tencent.mm.ai.f
{
  private static final String TAG = "MicroMsg.SelfGalleryPresenter";
  private static boolean sBQ;
  public static final i.a sCg;
  private int aRn;
  private int sBm;
  private final ArrayList<com.tencent.mm.plugin.story.model.d.g> sCc;
  private int sCd;
  private int sCe;
  final d sCf;
  private final r<Long, Boolean, String, String, y> szb;
  private final String username;
  
  static
  {
    AppMethodBeat.i(109639);
    sCg = new i.a((byte)0);
    TAG = "MicroMsg.SelfGalleryPresenter";
    sBQ = true;
    AppMethodBeat.o(109639);
  }
  
  public i(String paramString, d paramd)
  {
    AppMethodBeat.i(109638);
    this.username = paramString;
    this.sCf = paramd;
    this.sCc = new ArrayList();
    this.sCd = -1;
    this.sCe = -1;
    this.aRn = -1;
    this.szb = ((r)new h(this));
    paramString = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(paramString, "MMKernel.network()");
    paramString.Rc().a(273, (com.tencent.mm.ai.f)this);
    paramString = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(paramString, "MMKernel.network()");
    paramString.Rc().a(764, (com.tencent.mm.ai.f)this);
    paramString = com.tencent.mm.plugin.story.model.b.b.sxN;
    com.tencent.mm.plugin.story.model.b.b.b(this.szb);
    this.sCf.FM(1);
    AppMethodBeat.o(109638);
  }
  
  private final void a(boolean paramBoolean1, final boolean paramBoolean2, final long paramLong)
  {
    AppMethodBeat.i(155303);
    com.tencent.mm.ab.b.b((a.f.a.a)new e(this, paramLong, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(155303);
  }
  
  private final void cCk()
  {
    AppMethodBeat.i(109632);
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.coO().post((Runnable)new g(this));
    AppMethodBeat.o(109632);
  }
  
  private final void cCp()
  {
    AppMethodBeat.i(109633);
    Object localObject = (Iterable)this.sCc;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((com.tencent.mm.plugin.story.model.d.g)((Iterator)localObject).next()).sys.sxy);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = this.sCc.isEmpty();
      ab.i(TAG, "LogStory: updateCommentRead " + bool1 + ' ' + bool2);
      localObject = com.tencent.mm.plugin.story.model.b.b.sxN;
      com.tencent.mm.plugin.story.model.b.b.M(bool1, bool2);
      AppMethodBeat.o(109633);
      return;
    }
  }
  
  private final void lW(boolean paramBoolean)
  {
    AppMethodBeat.i(109623);
    com.tencent.mm.ab.b.b((a.f.a.a)new i.d(this, paramBoolean));
    AppMethodBeat.o(109623);
  }
  
  public final void FL(int paramInt)
  {
    AppMethodBeat.i(109624);
    this.sBm = paramInt;
    if (paramInt == 0)
    {
      ccL();
      AppMethodBeat.o(109624);
      return;
    }
    cCk();
    AppMethodBeat.o(109624);
  }
  
  public final void FQ(int paramInt) {}
  
  public final void cCl()
  {
    AppMethodBeat.i(109628);
    this.sCd = -1;
    n.a locala = com.tencent.mm.plugin.story.model.n.svx;
    n.a.cAW();
    AppMethodBeat.o(109628);
  }
  
  public final void cCm()
  {
    AppMethodBeat.i(109625);
    ab.i(TAG, "LogStory: initLoad");
    Object localObject = (com.tencent.mm.plugin.story.model.d.g)a.a.j.w((List)this.sCc, 0);
    ArrayList localArrayList = g.a.bA(this.username, false);
    ab.i(TAG, "LogStory: preload Db count " + localArrayList.size());
    com.tencent.mm.plugin.story.model.d.g localg = (com.tencent.mm.plugin.story.model.d.g)a.a.j.w((List)localArrayList, 0);
    if ((localObject != null) && (localg != null) && (((com.tencent.mm.plugin.story.model.d.g)localObject).cJA != localg.cJA))
    {
      this.sCc.clear();
      this.sCc.addAll((Collection)localArrayList);
      this.sCf.j(0, (List)this.sCc);
      this.sCf.FO(0);
      this.sCf.cCn();
    }
    for (;;)
    {
      cCp();
      ccL();
      AppMethodBeat.o(109625);
      return;
      localObject = g.a.o((List)this.sCc, (List)localArrayList);
      this.sCf.j(0, (List)this.sCc);
      this.sCf.cCn();
      ((c.b)localObject).a((android.support.v7.h.d)new i.c(this, localArrayList));
    }
  }
  
  public final void ccL()
  {
    AppMethodBeat.i(109626);
    if ((sBQ) && (this.sBm == 0))
    {
      sBQ = false;
      e locale = (e)com.tencent.mm.kernel.g.G(e.class);
      j.b localb = com.tencent.mm.plugin.story.model.j.svi;
      locale.loadStory(j.b.coK(), null);
    }
    AppMethodBeat.o(109626);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(109636);
    ab.i(TAG, "LogStory: destroy");
    Object localObject = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).Rc().b(273, (com.tencent.mm.ai.f)this);
    localObject = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).Rc().b(764, (com.tencent.mm.ai.f)this);
    localObject = com.tencent.mm.plugin.story.model.b.b.sxN;
    com.tencent.mm.plugin.story.model.b.b.c(this.szb);
    AppMethodBeat.o(109636);
  }
  
  public final void gb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109627);
    ab.i(TAG, "LogStory: deleteItem ".concat(String.valueOf(paramInt2)));
    Object localObject1;
    Object localObject2;
    if ((paramInt2 >= 0) && (paramInt2 < this.sCc.size()))
    {
      this.sCd = paramInt2;
      localObject1 = this.sCc.get(paramInt2);
      a.f.b.j.p(localObject1, "galleryItems[column]");
      localObject1 = (com.tencent.mm.plugin.story.model.d.g)localObject1;
      ab.i(TAG, "LogStory: deleteItem1 storyinfo " + localObject1 + " deleteItemIndex " + this.sCd + " localid " + ((com.tencent.mm.plugin.story.model.d.g)localObject1).syr.cIp);
      localObject2 = com.tencent.mm.plugin.story.model.j.svi;
      localObject2 = j.b.cAB().Gb(((com.tencent.mm.plugin.story.model.d.g)localObject1).syr.cIp);
      Object localObject3 = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAB().adF(((com.tencent.mm.plugin.story.model.d.g)localObject1).syr.cIp + '_' + ((com.tencent.mm.plugin.story.model.d.g)localObject1).syr.fDT);
      if (localObject2 != null)
      {
        ab.i(TAG, "LogStory: deleteItem2 storyinfo " + localObject1 + " deleteItemIndex " + this.sCd + " localid " + ((com.tencent.mm.plugin.story.model.d.g)localObject1).syr.cIp + ' ' + ((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID);
        if (((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID == 0L) {
          break label329;
        }
        if (this.sCd != -1)
        {
          localObject3 = com.tencent.mm.plugin.story.model.n.svx;
          n.a.G(((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID, ((com.tencent.mm.plugin.story.model.d.g)localObject1).syr.cIp);
        }
      }
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.story.model.d.g)localObject1).syr.cBM())
      {
        localObject2 = com.tencent.mm.plugin.story.model.j.svi;
        j.b.coO().post((Runnable)new i.b((com.tencent.mm.plugin.story.model.d.g)localObject1));
      }
      AppMethodBeat.o(109627);
      return;
      label329:
      localObject2 = com.tencent.mm.plugin.story.model.n.svx;
      n.a.FH(((com.tencent.mm.plugin.story.model.d.g)localObject1).syr.cIp);
      lW(true);
    }
  }
  
  public final void gc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109629);
    this.aRn = paramInt2;
    if (this.sBm == 1) {
      cCk();
    }
    AppMethodBeat.o(109629);
  }
  
  public final void n(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(109630);
    ab.i(TAG, "LogStory: setPrivacy ".concat(String.valueOf(paramInt2)));
    if ((paramInt2 >= 0) && (paramInt2 < this.sCc.size()))
    {
      this.sCe = paramInt2;
      Object localObject1;
      Object localObject2;
      if (!paramBoolean)
      {
        paramBoolean = true;
        localObject1 = this.sCc.get(paramInt2);
        a.f.b.j.p(localObject1, "galleryItems[column]");
        localObject1 = (com.tencent.mm.plugin.story.model.d.g)localObject1;
        ab.i(TAG, "LogStory: setPrivacy storyinfo " + localObject1 + " setPrivacyItemIndex " + this.sCe + " localid " + ((com.tencent.mm.plugin.story.model.d.g)localObject1).syr.cIp + " targetPrivacy:" + paramBoolean);
        localObject2 = com.tencent.mm.plugin.story.model.j.svi;
        localObject1 = j.b.cAB().Gb((int)((com.tencent.mm.plugin.story.model.d.g)localObject1).syt.systemRowid);
        if (localObject1 == null) {
          break label245;
        }
        localObject2 = com.tencent.mm.plugin.story.g.f.sEx;
        com.tencent.mm.plugin.story.g.f.ma(paramBoolean);
        if (!paramBoolean) {
          break label237;
        }
      }
      label237:
      for (long l = 3L;; l = 4L)
      {
        localObject2 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.a(l, String.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID), 1L, 0L, 24);
        localObject2 = com.tencent.mm.plugin.story.model.n.svx;
        n.a.b(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID, (int)((com.tencent.mm.plugin.story.h.j)localObject1).systemRowid, paramBoolean, false);
        AppMethodBeat.o(109630);
        return;
        paramBoolean = false;
        break;
      }
    }
    label245:
    AppMethodBeat.o(109630);
  }
  
  public final void o(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(138815);
    ab.i(TAG, "LogStory: setFavorite ".concat(String.valueOf(paramInt2)));
    if ((paramInt2 >= 0) && (paramInt2 < this.sCc.size()))
    {
      Object localObject1;
      Object localObject2;
      if (!paramBoolean)
      {
        paramBoolean = true;
        localObject1 = this.sCc.get(paramInt2);
        a.f.b.j.p(localObject1, "galleryItems[column]");
        localObject1 = (com.tencent.mm.plugin.story.model.d.g)localObject1;
        ab.i(TAG, "LogStory: setFavorite storyinfo " + localObject1 + " localid " + ((com.tencent.mm.plugin.story.model.d.g)localObject1).syr.cIp + " targetFavorite:" + paramBoolean);
        localObject2 = com.tencent.mm.plugin.story.model.j.svi;
        localObject1 = j.b.cAB().Gb((int)((com.tencent.mm.plugin.story.model.d.g)localObject1).syt.systemRowid);
        if (localObject1 == null) {
          break label270;
        }
        localObject2 = com.tencent.mm.plugin.story.g.f.sEx;
        com.tencent.mm.plugin.story.g.f.lZ(paramBoolean);
        if (!paramBoolean) {
          break label262;
        }
      }
      label262:
      for (long l = 1L;; l = 2L)
      {
        localObject2 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.a(l, String.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID), 1L, 0L, 24);
        localObject2 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        ((ArrayList)localObject2).add(Long.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID));
        localArrayList.add(Integer.valueOf((int)((com.tencent.mm.plugin.story.h.j)localObject1).systemRowid));
        localObject1 = com.tencent.mm.plugin.story.model.n.svx;
        n.a.a((List)localObject2, (List)localArrayList, paramBoolean);
        AppMethodBeat.o(138815);
        return;
        paramBoolean = false;
        break;
      }
    }
    label270:
    AppMethodBeat.o(138815);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(109637);
    ab.i(TAG, "LogStory: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString);
    if (((paramm instanceof com.tencent.mm.plugin.story.model.a.j)) && (bo.isEqual(((com.tencent.mm.plugin.story.model.a.j)paramm).userName, this.username)))
    {
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        paramInt1 = ((com.tencent.mm.plugin.story.model.a.j)paramm).cpt;
        paramString = com.tencent.mm.plugin.story.h.a.sFV;
        if (paramInt1 == com.tencent.mm.plugin.story.h.a.cEt())
        {
          sBQ = false;
          cCm();
          AppMethodBeat.o(109637);
        }
      }
    }
    else if ((paramm instanceof com.tencent.mm.plugin.story.model.a.g))
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
            AppMethodBeat.o(109637);
            return;
          }
        }
        n.a locala;
        if ((paramString instanceof com.tencent.mm.plugin.story.model.a.n))
        {
          ab.i(TAG, "onSceneEnd MMSTORY_OBJ_OP_VISIBILITY_TYPE errType:" + paramInt1 + ", errcode:" + paramInt2);
          if (paramInt2 == 0)
          {
            paramm = ((Iterable)((com.tencent.mm.plugin.story.model.a.g)paramm).sxi).iterator();
            while (paramm.hasNext())
            {
              paramInt1 = ((Number)paramm.next()).intValue();
              locala = com.tencent.mm.plugin.story.model.n.svx;
              n.a.fY(paramInt1, ((com.tencent.mm.plugin.story.model.a.n)paramString).sxw);
            }
            com.tencent.mm.ab.b.b((a.f.a.a)new f(this));
            AppMethodBeat.o(109637);
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
              ab.i(TAG, "onSceneEnd update story favorite: errType " + paramInt1 + ", errcode " + paramInt2 + ", localId " + i + ", favorite:" + ((com.tencent.mm.plugin.story.model.a.l)paramString).sxv);
              locala = com.tencent.mm.plugin.story.model.n.svx;
              n.a.fZ(i, ((com.tencent.mm.plugin.story.model.a.l)paramString).sxv);
            }
            if (((com.tencent.mm.plugin.story.model.a.l)paramString).sxv == 1) {
              bool1 = true;
            }
            a(bool1, true, paramString.cJA);
            AppMethodBeat.o(109637);
            return;
          }
          paramm = com.tencent.mm.plugin.story.h.a.sFV;
          if (paramInt2 == com.tencent.mm.plugin.story.h.a.cEb()) {
            if (((com.tencent.mm.plugin.story.model.a.l)paramString).sxv != 1) {
              break label569;
            }
          }
        }
        label569:
        for (bool1 = bool2;; bool1 = false)
        {
          a(bool1, false, paramString.cJA);
          AppMethodBeat.o(109637);
          return;
        }
      }
    }
    AppMethodBeat.o(109637);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(109635);
    ab.i(TAG, "LogStory: pause");
    AppMethodBeat.o(109635);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(109634);
    ab.i(TAG, "LogStory: resume");
    AppMethodBeat.o(109634);
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class e
    extends a.f.b.k
    implements a.f.a.a<y>
  {
    e(i parami, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class f
    extends a.f.b.k
    implements a.f.a.a<y>
  {
    f(i parami)
    {
      super();
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(i parami) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(151090);
      Object localObject1 = (com.tencent.mm.plugin.story.model.d.g)a.a.j.w((List)i.a(this.sCh), i.f(this.sCh));
      if (localObject1 != null) {}
      for (localObject1 = ((com.tencent.mm.plugin.story.model.d.g)localObject1).sys;; localObject1 = null)
      {
        String str = i.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("setSelectedRead ").append(i.f(this.sCh)).append(", ");
        if (localObject1 != null) {
          localObject2 = Boolean.valueOf(((com.tencent.mm.plugin.story.model.d.f)localObject1).sxy);
        }
        ab.i(str, localObject2);
        if ((localObject1 != null) && (((com.tencent.mm.plugin.story.model.d.f)localObject1).rPQ.size() > 0))
        {
          localObject2 = com.tencent.mm.plugin.story.model.b.b.sxN;
          long l = ((com.tencent.mm.plugin.story.model.d.f)localObject1).cJA;
          localObject2 = ((com.tencent.mm.plugin.story.model.d.f)localObject1).rPQ.getLast();
          a.f.b.j.p(localObject2, "comment.commentList.last");
          if (com.tencent.mm.plugin.story.model.b.b.b(l, (com.tencent.mm.plugin.story.model.b.a)localObject2)) {
            com.tencent.mm.ab.b.b((a.f.a.a)new i.g.1(this, (com.tencent.mm.plugin.story.model.d.f)localObject1));
          }
        }
        AppMethodBeat.o(151090);
        return;
      }
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner", "invoke"})
  static final class h
    extends a.f.b.k
    implements r<Long, Boolean, String, String, y>
  {
    h(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.i
 * JD-Core Version:    0.7.0.1
 */