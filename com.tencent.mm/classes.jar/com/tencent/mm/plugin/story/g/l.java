package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.d.a.c;
import com.tencent.mm.plugin.story.d.a.d;
import com.tencent.mm.plugin.story.f.a.i;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/presenter/StoryFavSelectPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;)V", "MAX_COUNT", "", "TAG", "", "isRunning", "", "loadNpCount", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "isAll", "errType", "errCode", "limitId", "loadDBData", "", "first", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setFavorite", "storyList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "updateLocalMinId", "lastId", "plugin-story_release"})
public final class l
  implements f, a.c
{
  private long BfZ;
  long Bga;
  long Bgb;
  int BhS;
  final a.d BhZ;
  private final int MAX_COUNT;
  final String TAG;
  private boolean isRunning;
  String lJm;
  private boolean oTp;
  
  public l(a.d paramd)
  {
    AppMethodBeat.i(119352);
    this.BhZ = paramd;
    this.TAG = "MicroMsg.StoryFavSelectPresenter";
    this.lJm = "";
    this.MAX_COUNT = 20;
    AppMethodBeat.o(119352);
  }
  
  final void Bh(long paramLong)
  {
    AppMethodBeat.i(119344);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
    localObject1 = j.b.elB();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.elK();
    p.h(this.lJm, "userName");
    localObject2 = com.tencent.mm.plugin.story.i.a.BkN;
    int i = com.tencent.mm.plugin.story.i.a.eok();
    localObject2 = this.lJm;
    String str = this.lJm;
    j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
    this.Bgb = ((k)localObject1).c(paramLong, i, (String)localObject2, bu.lX(str, j.b.dXj()));
    if (this.BfZ != 0L) {
      if (this.Bgb >= this.BfZ) {
        break label155;
      }
    }
    label155:
    for (paramLong = this.Bgb;; paramLong = this.BfZ)
    {
      this.Bgb = paramLong;
      ae.d(this.TAG, "localMinId=" + this.Bgb + ", respMaxId=" + this.BfZ);
      AppMethodBeat.o(119344);
      return;
    }
  }
  
  public final void efC()
  {
    AppMethodBeat.i(119346);
    b localb = g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().b(273, (f)this);
    AppMethodBeat.o(119346);
  }
  
  public final void ekV()
  {
    AppMethodBeat.i(119348);
    if (!this.isRunning)
    {
      this.BhS -= 1;
      ae.i(this.TAG, "loadNpData username=" + this.lJm + " maxId=" + this.BfZ);
      if (!this.oTp)
      {
        this.isRunning = true;
        Object localObject1 = g.ajQ();
        p.g(localObject1, "MMKernel.network()");
        localObject1 = ((b)localObject1).ajj();
        String str = this.lJm;
        long l = this.BfZ;
        Object localObject2 = this.lJm;
        j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
        boolean bool = bu.lX((String)localObject2, j.b.dXj());
        localObject2 = com.tencent.mm.plugin.story.i.a.BkN;
        ((com.tencent.mm.ak.q)localObject1).b((com.tencent.mm.ak.n)new i(str, l, bool, "", com.tencent.mm.plugin.story.i.a.eoI()));
        AppMethodBeat.o(119348);
      }
    }
    else
    {
      ae.i(this.TAG, "loadNpData is running");
    }
    AppMethodBeat.o(119348);
  }
  
  public final void ekW()
  {
    AppMethodBeat.i(119349);
    if (!this.isRunning)
    {
      this.isRunning = true;
      ae.i(this.TAG, "loadFpData username=" + this.lJm + " maxId=" + this.BfZ);
      Object localObject1 = g.ajQ();
      p.g(localObject1, "MMKernel.network()");
      localObject1 = ((b)localObject1).ajj();
      String str = this.lJm;
      Object localObject2 = this.lJm;
      j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
      boolean bool = bu.lX((String)localObject2, j.b.dXj());
      localObject2 = com.tencent.mm.plugin.story.i.a.BkN;
      ((com.tencent.mm.ak.q)localObject1).b((com.tencent.mm.ak.n)new i(str, 0L, bool, "", com.tencent.mm.plugin.story.i.a.eoI()));
      AppMethodBeat.o(119349);
      return;
    }
    ae.i(this.TAG, "loadFpData is running");
    AppMethodBeat.o(119349);
  }
  
  public final void gu(final List<com.tencent.mm.plugin.story.i.j> paramList)
  {
    AppMethodBeat.i(119351);
    p.h(paramList, "storyList");
    j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.dJc().post((Runnable)new d(this, paramList));
    AppMethodBeat.o(119351);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119345);
    p.h(paramString, "userName");
    this.lJm = paramString;
    Bh(this.Bga);
    paramString = g.ajQ();
    p.g(paramString, "MMKernel.network()");
    paramString.ajj().a(273, (f)this);
    AppMethodBeat.o(119345);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(119350);
    ae.i(this.TAG, "LogStory: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString + ' ' + paramn);
    boolean bool;
    if (((paramn instanceof i)) && (bu.lX(((i)paramn).userName, this.lJm)))
    {
      int i = ((i)paramn).doj;
      paramString = com.tencent.mm.plugin.story.i.a.BkN;
      if (i == com.tencent.mm.plugin.story.i.a.eoI())
      {
        ae.d(this.TAG, "onSceneEnd username=" + this.lJm + " respMaxId=" + this.BfZ + ' ' + paramInt1 + ' ' + paramInt2 + ' ' + ((i)paramn).zzQ);
        this.isRunning = false;
        long l = ((i)paramn).zzQ;
        paramString = com.tencent.mm.plugin.story.i.a.BkN;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.eop())
        {
          paramString = com.tencent.mm.plugin.story.i.a.BkN;
          if ((paramInt2 != com.tencent.mm.plugin.story.i.a.eoq()) && ((paramInt1 != 0) || (paramInt2 != 0) || (l != 0L)))
          {
            paramString = com.tencent.mm.plugin.story.i.a.BkN;
            if ((paramInt2 != com.tencent.mm.plugin.story.i.a.eoo()) || (l != 0L)) {
              break label408;
            }
          }
        }
        bool = true;
        this.oTp = bool;
        this.BhZ.sp(this.oTp);
        this.BfZ = ((i)paramn).zzQ;
        if (!((i)paramn).zxW) {
          break label414;
        }
        paramString = com.tencent.mm.plugin.story.f.j.BbE;
        j.b.dJc().post((Runnable)new b(this));
      }
    }
    for (;;)
    {
      ae.d(this.TAG, "onSceneEnd username=" + this.lJm + " respMaxId=" + this.BfZ + ' ' + paramInt1 + ' ' + paramInt2 + " isAll:" + this.oTp + " limitId:" + this.BfZ);
      AppMethodBeat.o(119350);
      return;
      label408:
      bool = false;
      break;
      label414:
      paramString = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.dJc().post((Runnable)new c(this));
    }
  }
  
  public final void sq(final boolean paramBoolean)
  {
    AppMethodBeat.i(119347);
    j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.dJc().post((Runnable)new a(this, paramBoolean));
    AppMethodBeat.o(119347);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(l paraml, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(119340);
      Object localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
      Object localObject2 = k.a(j.b.elB(), this.Bia.Bgb);
      if (!((List)localObject2).isEmpty()) {
        this.Bia.Bga = ((com.tencent.mm.plugin.story.i.j)d.a.j.jn((List)localObject2)).field_storyID;
      }
      ae.d(this.Bia.TAG, "localCachedMinId=" + this.Bia.Bga + " infos.size=" + ((List)localObject2).size() + " localMinId=" + this.Bia.Bgb);
      localObject1 = new ArrayList();
      final ArrayList localArrayList = new ArrayList();
      Object localObject3;
      if (paramBoolean)
      {
        localObject3 = com.tencent.mm.plugin.story.f.j.BbE;
        localObject3 = j.b.elB();
        j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
        localArrayList.addAll((Collection)((k)localObject3).cg(j.b.dXj(), true));
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject2).next();
        if ((((com.tencent.mm.plugin.story.i.j)localObject3).field_storyID != 0L) && (!((com.tencent.mm.plugin.story.i.j)localObject3).epj())) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      c.h((d.g.a.a)new d.g.b.q((ArrayList)localObject1) {});
      AppMethodBeat.o(119340);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(119341);
      this.Bia.Bh(this.Bia.Bga);
      this.Bia.sq(false);
      if (this.Bia.BhS > 0) {
        this.Bia.ekV();
      }
      AppMethodBeat.o(119341);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(119342);
      this.Bia.Bh(this.Bia.Bga);
      this.Bia.sq(false);
      if (this.Bia.BhS > 0) {
        this.Bia.ekV();
      }
      AppMethodBeat.o(119342);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(l paraml, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(119343);
      Object localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
      Object localObject3 = j.b.elB().cg(this.Bia.lJm, true);
      Object localObject2 = new ArrayList();
      localObject1 = new ArrayList();
      Object localObject4 = ((Iterable)paramList).iterator();
      Object localObject5;
      Object localObject6;
      label106:
      int i;
      label140:
      label163:
      label168:
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject4).next();
        localObject6 = (Iterable)localObject3;
        if (!((Collection)localObject6).isEmpty())
        {
          localObject6 = ((Iterable)localObject6).iterator();
          if (((Iterator)localObject6).hasNext()) {
            if (((com.tencent.mm.plugin.story.i.j)((Iterator)localObject6).next()).field_storyID == ((com.tencent.mm.plugin.story.i.j)localObject5).field_storyID)
            {
              i = 1;
              if (i == 0) {
                break label163;
              }
            }
          }
        }
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label168;
          }
          ((ArrayList)localObject2).add(localObject5);
          break;
          i = 0;
          break label140;
          break label106;
        }
      }
      localObject3 = ((Iterable)localObject3).iterator();
      label277:
      label300:
      label305:
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject3).next();
        localObject5 = (Iterable)paramList;
        if ((!(localObject5 instanceof Collection)) || (!((Collection)localObject5).isEmpty()))
        {
          localObject5 = ((Iterable)localObject5).iterator();
          label243:
          if (((Iterator)localObject5).hasNext()) {
            if (((com.tencent.mm.plugin.story.i.j)((Iterator)localObject5).next()).field_storyID == ((com.tencent.mm.plugin.story.i.j)localObject4).field_storyID)
            {
              i = 1;
              if (i == 0) {
                break label300;
              }
            }
          }
        }
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label305;
          }
          ((ArrayList)localObject1).add(localObject4);
          break;
          i = 0;
          break label277;
          break label243;
        }
      }
      ae.i(this.Bia.TAG, "LogStory: setFavorite " + ((ArrayList)localObject2).size() + ' ' + ((ArrayList)localObject1).size());
      localObject3 = new ArrayList();
      localObject4 = new ArrayList();
      if (!((Collection)localObject2).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject5 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject2).next();
            ((ArrayList)localObject3).add(Long.valueOf(((com.tencent.mm.plugin.story.i.j)localObject5).field_storyID));
            ((ArrayList)localObject4).add(Integer.valueOf((int)((com.tencent.mm.plugin.story.i.j)localObject5).systemRowid));
            localObject6 = h.BjR;
            h.a(1L, ((com.tencent.mm.plugin.story.i.j)localObject5).toString(), 0L, 0L, 1L);
            continue;
            i = 0;
            break;
          }
        }
        localObject2 = com.tencent.mm.plugin.story.f.n.BbT;
        n.a.b((List)localObject3, (List)localObject4, true);
      }
      ((ArrayList)localObject3).clear();
      ((ArrayList)localObject4).clear();
      if (!((Collection)localObject1).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject1).next();
            ((ArrayList)localObject3).add(Long.valueOf(((com.tencent.mm.plugin.story.i.j)localObject2).field_storyID));
            ((ArrayList)localObject4).add(Integer.valueOf((int)((com.tencent.mm.plugin.story.i.j)localObject2).systemRowid));
            localObject5 = h.BjR;
            h.a(2L, ((com.tencent.mm.plugin.story.i.j)localObject2).toString(), 0L, 0L, 1L);
            continue;
            i = 0;
            break;
          }
        }
        localObject1 = com.tencent.mm.plugin.story.f.n.BbT;
        n.a.b((List)localObject3, (List)localObject4, false);
      }
      AppMethodBeat.o(119343);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.l
 * JD-Core Version:    0.7.0.1
 */