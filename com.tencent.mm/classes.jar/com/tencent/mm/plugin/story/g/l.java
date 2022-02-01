package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.story.d.a.c;
import com.tencent.mm.plugin.story.d.a.d;
import com.tencent.mm.plugin.story.f.a.i;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/presenter/StoryFavSelectPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;)V", "MAX_COUNT", "", "TAG", "", "isRunning", "", "loadNpCount", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "isAll", "errType", "errCode", "limitId", "loadDBData", "", "first", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setFavorite", "storyList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "updateLocalMinId", "lastId", "plugin-story_release"})
public final class l
  implements com.tencent.mm.ak.g, a.c
{
  private final int MAX_COUNT;
  final String TAG;
  private boolean isRunning;
  String lhM;
  private boolean ojr;
  private long zwC;
  long zwD;
  long zwE;
  final a.d zyC;
  int zyv;
  
  public l(a.d paramd)
  {
    AppMethodBeat.i(119352);
    this.zyC = paramd;
    this.TAG = "MicroMsg.StoryFavSelectPresenter";
    this.lhM = "";
    this.MAX_COUNT = 20;
    AppMethodBeat.o(119352);
  }
  
  public final void dPE()
  {
    AppMethodBeat.i(119346);
    b localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().b(273, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(119346);
  }
  
  public final void dUY()
  {
    AppMethodBeat.i(119348);
    if (!this.isRunning)
    {
      this.zyv -= 1;
      ac.i(this.TAG, "loadNpData username=" + this.lhM + " maxId=" + this.zwC);
      if (!this.ojr)
      {
        this.isRunning = true;
        Object localObject1 = com.tencent.mm.kernel.g.agQ();
        d.g.b.k.g(localObject1, "MMKernel.network()");
        localObject1 = ((b)localObject1).agi();
        String str = this.lhM;
        long l = this.zwC;
        Object localObject2 = this.lhM;
        j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
        boolean bool = bs.lr((String)localObject2, j.b.dHx());
        localObject2 = com.tencent.mm.plugin.story.i.a.zBQ;
        ((q)localObject1).b((com.tencent.mm.ak.n)new i(str, l, bool, "", com.tencent.mm.plugin.story.i.a.dYK()));
        AppMethodBeat.o(119348);
      }
    }
    else
    {
      ac.i(this.TAG, "loadNpData is running");
    }
    AppMethodBeat.o(119348);
  }
  
  public final void dUZ()
  {
    AppMethodBeat.i(119349);
    if (!this.isRunning)
    {
      this.isRunning = true;
      ac.i(this.TAG, "loadFpData username=" + this.lhM + " maxId=" + this.zwC);
      Object localObject1 = com.tencent.mm.kernel.g.agQ();
      d.g.b.k.g(localObject1, "MMKernel.network()");
      localObject1 = ((b)localObject1).agi();
      String str = this.lhM;
      Object localObject2 = this.lhM;
      j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
      boolean bool = bs.lr((String)localObject2, j.b.dHx());
      localObject2 = com.tencent.mm.plugin.story.i.a.zBQ;
      ((q)localObject1).b((com.tencent.mm.ak.n)new i(str, 0L, bool, "", com.tencent.mm.plugin.story.i.a.dYK()));
      AppMethodBeat.o(119349);
      return;
    }
    ac.i(this.TAG, "loadFpData is running");
    AppMethodBeat.o(119349);
  }
  
  public final void ga(final List<com.tencent.mm.plugin.story.i.j> paramList)
  {
    AppMethodBeat.i(119351);
    d.g.b.k.h(paramList, "storyList");
    j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dvq().post((Runnable)new d(this, paramList));
    AppMethodBeat.o(119351);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119345);
    d.g.b.k.h(paramString, "userName");
    this.lhM = paramString;
    yl(this.zwD);
    paramString = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(paramString, "MMKernel.network()");
    paramString.agi().a(273, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(119345);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(119350);
    ac.i(this.TAG, "LogStory: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString + ' ' + paramn);
    boolean bool;
    if (((paramn instanceof i)) && (bs.lr(((i)paramn).userName, this.lhM)))
    {
      int i = ((i)paramn).dbL;
      paramString = com.tencent.mm.plugin.story.i.a.zBQ;
      if (i == com.tencent.mm.plugin.story.i.a.dYK())
      {
        ac.d(this.TAG, "onSceneEnd username=" + this.lhM + " respMaxId=" + this.zwC + ' ' + paramInt1 + ' ' + paramInt2 + ' ' + ((i)paramn).xSH);
        this.isRunning = false;
        long l = ((i)paramn).xSH;
        paramString = com.tencent.mm.plugin.story.i.a.zBQ;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.dYr())
        {
          paramString = com.tencent.mm.plugin.story.i.a.zBQ;
          if ((paramInt2 != com.tencent.mm.plugin.story.i.a.dYs()) && ((paramInt1 != 0) || (paramInt2 != 0) || (l != 0L)))
          {
            paramString = com.tencent.mm.plugin.story.i.a.zBQ;
            if ((paramInt2 != com.tencent.mm.plugin.story.i.a.dYq()) || (l != 0L)) {
              break label405;
            }
          }
        }
        bool = true;
        this.ojr = bool;
        this.zyC.rC(this.ojr);
        this.zwC = ((i)paramn).xSH;
        if (!((i)paramn).xRn) {
          break label411;
        }
        paramString = com.tencent.mm.plugin.story.f.j.zsh;
        j.b.dvq().post((Runnable)new b(this));
      }
    }
    for (;;)
    {
      ac.d(this.TAG, "onSceneEnd username=" + this.lhM + " respMaxId=" + this.zwC + ' ' + paramInt1 + ' ' + paramInt2 + " isAll:" + this.ojr + " limitId:" + this.zwC);
      AppMethodBeat.o(119350);
      return;
      label405:
      bool = false;
      break;
      label411:
      paramString = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dvq().post((Runnable)new c(this));
    }
  }
  
  public final void rD(final boolean paramBoolean)
  {
    AppMethodBeat.i(119347);
    j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dvq().post((Runnable)new a(this, paramBoolean));
    AppMethodBeat.o(119347);
  }
  
  final void yl(long paramLong)
  {
    AppMethodBeat.i(119344);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
    localObject1 = j.b.dVE();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dVN();
    d.g.b.k.h(this.lhM, "userName");
    localObject2 = com.tencent.mm.plugin.story.i.a.zBQ;
    int i = com.tencent.mm.plugin.story.i.a.dYm();
    localObject2 = this.lhM;
    String str = this.lhM;
    j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
    this.zwE = ((com.tencent.mm.plugin.story.i.k)localObject1).c(paramLong, i, (String)localObject2, bs.lr(str, j.b.dHx()));
    if (this.zwC != 0L) {
      if (this.zwE >= this.zwC) {
        break label159;
      }
    }
    label159:
    for (paramLong = this.zwE;; paramLong = this.zwC)
    {
      this.zwE = paramLong;
      ac.d(this.TAG, "localMinId=" + this.zwE + ", respMaxId=" + this.zwC);
      AppMethodBeat.o(119344);
      return;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(l paraml, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(119340);
      Object localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
      Object localObject2 = com.tencent.mm.plugin.story.i.k.a(j.b.dVE(), this.zyD.zwE);
      if (!((List)localObject2).isEmpty()) {
        this.zyD.zwD = ((com.tencent.mm.plugin.story.i.j)d.a.j.iQ((List)localObject2)).field_storyID;
      }
      ac.d(this.zyD.TAG, "localCachedMinId=" + this.zyD.zwD + " infos.size=" + ((List)localObject2).size() + " localMinId=" + this.zyD.zwE);
      localObject1 = new ArrayList();
      final ArrayList localArrayList = new ArrayList();
      Object localObject3;
      if (paramBoolean)
      {
        localObject3 = com.tencent.mm.plugin.story.f.j.zsh;
        localObject3 = j.b.dVE();
        j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
        localArrayList.addAll((Collection)((com.tencent.mm.plugin.story.i.k)localObject3).bV(j.b.dHx(), true));
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject2).next();
        if ((((com.tencent.mm.plugin.story.i.j)localObject3).field_storyID != 0L) && (!((com.tencent.mm.plugin.story.i.j)localObject3).dZl())) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      c.g((d.g.a.a)new d.g.b.l((ArrayList)localObject1) {});
      AppMethodBeat.o(119340);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(119341);
      this.zyD.yl(this.zyD.zwD);
      this.zyD.rD(false);
      if (this.zyD.zyv > 0) {
        this.zyD.dUY();
      }
      AppMethodBeat.o(119341);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(119342);
      this.zyD.yl(this.zyD.zwD);
      this.zyD.rD(false);
      if (this.zyD.zyv > 0) {
        this.zyD.dUY();
      }
      AppMethodBeat.o(119342);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(l paraml, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(119343);
      Object localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
      Object localObject3 = j.b.dVE().bV(this.zyD.lhM, true);
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
      ac.i(this.zyD.TAG, "LogStory: setFavorite " + ((ArrayList)localObject2).size() + ' ' + ((ArrayList)localObject1).size());
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
            localObject6 = h.zAU;
            h.a(1L, ((com.tencent.mm.plugin.story.i.j)localObject5).toString(), 0L, 0L, 1L);
            continue;
            i = 0;
            break;
          }
        }
        localObject2 = com.tencent.mm.plugin.story.f.n.zsw;
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
            localObject5 = h.zAU;
            h.a(2L, ((com.tencent.mm.plugin.story.i.j)localObject2).toString(), 0L, 0L, 1L);
            continue;
            i = 0;
            break;
          }
        }
        localObject1 = com.tencent.mm.plugin.story.f.n.zsw;
        n.a.b((List)localObject3, (List)localObject4, false);
      }
      AppMethodBeat.o(119343);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.l
 * JD-Core Version:    0.7.0.1
 */