package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.story.d.a.c;
import com.tencent.mm.plugin.story.d.a.d;
import com.tencent.mm.plugin.story.f.a.i;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/presenter/StoryFavSelectPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;)V", "MAX_COUNT", "", "TAG", "", "isRunning", "", "loadNpCount", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "isAll", "errType", "errCode", "limitId", "loadDBData", "", "first", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setFavorite", "storyList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "updateLocalMinId", "lastId", "plugin-story_release"})
public final class l
  implements com.tencent.mm.al.g, a.c
{
  final String TAG;
  private boolean isRunning;
  String kGt;
  private final int llh;
  private boolean nGq;
  private long yjD;
  long yjE;
  long yjF;
  final a.d ylD;
  int ylw;
  
  public l(a.d paramd)
  {
    AppMethodBeat.i(119352);
    this.ylD = paramd;
    this.TAG = "MicroMsg.StoryFavSelectPresenter";
    this.kGt = "";
    this.llh = 20;
    AppMethodBeat.o(119352);
  }
  
  public final void dBh()
  {
    AppMethodBeat.i(119346);
    b localb = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.aeS().b(273, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(119346);
  }
  
  public final void dGx()
  {
    AppMethodBeat.i(119348);
    if (!this.isRunning)
    {
      this.ylw -= 1;
      ad.i(this.TAG, "loadNpData username=" + this.kGt + " maxId=" + this.yjD);
      if (!this.nGq)
      {
        this.isRunning = true;
        Object localObject1 = com.tencent.mm.kernel.g.afA();
        d.g.b.k.g(localObject1, "MMKernel.network()");
        localObject1 = ((b)localObject1).aeS();
        String str = this.kGt;
        long l = this.yjD;
        Object localObject2 = this.kGt;
        j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
        boolean bool = bt.kU((String)localObject2, j.b.dta());
        localObject2 = com.tencent.mm.plugin.story.i.a.yor;
        ((q)localObject1).b((com.tencent.mm.al.n)new i(str, l, bool, "", com.tencent.mm.plugin.story.i.a.dKj()));
        AppMethodBeat.o(119348);
      }
    }
    else
    {
      ad.i(this.TAG, "loadNpData is running");
    }
    AppMethodBeat.o(119348);
  }
  
  public final void dGy()
  {
    AppMethodBeat.i(119349);
    if (!this.isRunning)
    {
      this.isRunning = true;
      ad.i(this.TAG, "loadFpData username=" + this.kGt + " maxId=" + this.yjD);
      Object localObject1 = com.tencent.mm.kernel.g.afA();
      d.g.b.k.g(localObject1, "MMKernel.network()");
      localObject1 = ((b)localObject1).aeS();
      String str = this.kGt;
      Object localObject2 = this.kGt;
      j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
      boolean bool = bt.kU((String)localObject2, j.b.dta());
      localObject2 = com.tencent.mm.plugin.story.i.a.yor;
      ((q)localObject1).b((com.tencent.mm.al.n)new i(str, 0L, bool, "", com.tencent.mm.plugin.story.i.a.dKj()));
      AppMethodBeat.o(119349);
      return;
    }
    ad.i(this.TAG, "loadFpData is running");
    AppMethodBeat.o(119349);
  }
  
  public final void fS(final List<com.tencent.mm.plugin.story.i.j> paramList)
  {
    AppMethodBeat.i(119351);
    d.g.b.k.h(paramList, "storyList");
    j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dhI().post((Runnable)new d(this, paramList));
    AppMethodBeat.o(119351);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119345);
    d.g.b.k.h(paramString, "userName");
    this.kGt = paramString;
    tI(this.yjE);
    paramString = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(paramString, "MMKernel.network()");
    paramString.aeS().a(273, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(119345);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(119350);
    ad.i(this.TAG, "LogStory: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString + ' ' + paramn);
    boolean bool;
    if (((paramn instanceof i)) && (bt.kU(((i)paramn).userName, this.kGt)))
    {
      int i = ((i)paramn).dep;
      paramString = com.tencent.mm.plugin.story.i.a.yor;
      if (i == com.tencent.mm.plugin.story.i.a.dKj())
      {
        ad.d(this.TAG, "onSceneEnd username=" + this.kGt + " respMaxId=" + this.yjD + ' ' + paramInt1 + ' ' + paramInt2 + ' ' + ((i)paramn).wGn);
        this.isRunning = false;
        long l = ((i)paramn).wGn;
        paramString = com.tencent.mm.plugin.story.i.a.yor;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.dJQ())
        {
          paramString = com.tencent.mm.plugin.story.i.a.yor;
          if ((paramInt2 != com.tencent.mm.plugin.story.i.a.dJR()) && ((paramInt1 != 0) || (paramInt2 != 0) || (l != 0L)))
          {
            paramString = com.tencent.mm.plugin.story.i.a.yor;
            if ((paramInt2 != com.tencent.mm.plugin.story.i.a.dJP()) || (l != 0L)) {
              break label405;
            }
          }
        }
        bool = true;
        this.nGq = bool;
        this.ylD.qE(this.nGq);
        this.yjD = ((i)paramn).wGn;
        if (!((i)paramn).wES) {
          break label411;
        }
        paramString = com.tencent.mm.plugin.story.f.j.yfh;
        j.b.dhI().post((Runnable)new b(this));
      }
    }
    for (;;)
    {
      ad.d(this.TAG, "onSceneEnd username=" + this.kGt + " respMaxId=" + this.yjD + ' ' + paramInt1 + ' ' + paramInt2 + " isAll:" + this.nGq + " limitId:" + this.yjD);
      AppMethodBeat.o(119350);
      return;
      label405:
      bool = false;
      break;
      label411:
      paramString = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dhI().post((Runnable)new c(this));
    }
  }
  
  public final void qF(final boolean paramBoolean)
  {
    AppMethodBeat.i(119347);
    j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dhI().post((Runnable)new a(this, paramBoolean));
    AppMethodBeat.o(119347);
  }
  
  final void tI(long paramLong)
  {
    AppMethodBeat.i(119344);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
    localObject1 = j.b.dHd();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dHm();
    d.g.b.k.h(this.kGt, "userName");
    localObject2 = com.tencent.mm.plugin.story.i.a.yor;
    int i = com.tencent.mm.plugin.story.i.a.dJL();
    localObject2 = this.kGt;
    String str = this.kGt;
    j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
    this.yjF = ((com.tencent.mm.plugin.story.i.k)localObject1).b(paramLong, i, (String)localObject2, bt.kU(str, j.b.dta()));
    if (this.yjD != 0L) {
      if (this.yjF >= this.yjD) {
        break label159;
      }
    }
    label159:
    for (paramLong = this.yjF;; paramLong = this.yjD)
    {
      this.yjF = paramLong;
      ad.d(this.TAG, "localMinId=" + this.yjF + ", respMaxId=" + this.yjD);
      AppMethodBeat.o(119344);
      return;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(l paraml, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(119340);
      Object localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
      Object localObject2 = com.tencent.mm.plugin.story.i.k.a(j.b.dHd(), this.ylE.yjF);
      if (!((List)localObject2).isEmpty()) {
        this.ylE.yjE = ((com.tencent.mm.plugin.story.i.j)d.a.j.iA((List)localObject2)).field_storyID;
      }
      ad.d(this.ylE.TAG, "localCachedMinId=" + this.ylE.yjE + " infos.size=" + ((List)localObject2).size() + " localMinId=" + this.ylE.yjF);
      localObject1 = new ArrayList();
      final ArrayList localArrayList = new ArrayList();
      Object localObject3;
      if (paramBoolean)
      {
        localObject3 = com.tencent.mm.plugin.story.f.j.yfh;
        localObject3 = j.b.dHd();
        j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
        localArrayList.addAll((Collection)((com.tencent.mm.plugin.story.i.k)localObject3).bO(j.b.dta(), true));
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject2).next();
        if ((((com.tencent.mm.plugin.story.i.j)localObject3).field_storyID != 0L) && (!((com.tencent.mm.plugin.story.i.j)localObject3).dKK())) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      c.g((d.g.a.a)new d.g.b.l((ArrayList)localObject1) {});
      AppMethodBeat.o(119340);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(119341);
      this.ylE.tI(this.ylE.yjE);
      this.ylE.qF(false);
      if (this.ylE.ylw > 0) {
        this.ylE.dGx();
      }
      AppMethodBeat.o(119341);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(119342);
      this.ylE.tI(this.ylE.yjE);
      this.ylE.qF(false);
      if (this.ylE.ylw > 0) {
        this.ylE.dGx();
      }
      AppMethodBeat.o(119342);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(l paraml, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(119343);
      Object localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
      Object localObject3 = j.b.dHd().bO(this.ylE.kGt, true);
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
      ad.i(this.ylE.TAG, "LogStory: setFavorite " + ((ArrayList)localObject2).size() + ' ' + ((ArrayList)localObject1).size());
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
            localObject6 = h.ynv;
            h.a(1L, ((com.tencent.mm.plugin.story.i.j)localObject5).toString(), 0L, 0L, 1L);
            continue;
            i = 0;
            break;
          }
        }
        localObject2 = com.tencent.mm.plugin.story.f.n.yfw;
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
            localObject5 = h.ynv;
            h.a(2L, ((com.tencent.mm.plugin.story.i.j)localObject2).toString(), 0L, 0L, 1L);
            continue;
            i = 0;
            break;
          }
        }
        localObject1 = com.tencent.mm.plugin.story.f.n.yfw;
        n.a.b((List)localObject3, (List)localObject4, false);
      }
      AppMethodBeat.o(119343);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.l
 * JD-Core Version:    0.7.0.1
 */