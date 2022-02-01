package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.f;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.d.a.c;
import com.tencent.mm.plugin.story.d.a.d;
import com.tencent.mm.plugin.story.f.a.i;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/presenter/StoryFavSelectPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;)V", "MAX_COUNT", "", "TAG", "", "isRunning", "", "loadNpCount", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "isAll", "errType", "errCode", "limitId", "loadDBData", "", "first", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setFavorite", "storyList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "updateLocalMinId", "lastId", "plugin-story_release"})
public final class l
  implements f, a.c
{
  long AOA;
  private long AOy;
  long AOz;
  final a.d AQB;
  int AQu;
  private final int MAX_COUNT;
  final String TAG;
  private boolean isRunning;
  String lEN;
  private boolean oMN;
  
  public l(a.d paramd)
  {
    AppMethodBeat.i(119352);
    this.AQB = paramd;
    this.TAG = "MicroMsg.StoryFavSelectPresenter";
    this.lEN = "";
    this.MAX_COUNT = 20;
    AppMethodBeat.o(119352);
  }
  
  final void AJ(long paramLong)
  {
    AppMethodBeat.i(119344);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
    localObject1 = j.b.ehT();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.eic();
    p.h(this.lEN, "userName");
    localObject2 = com.tencent.mm.plugin.story.i.a.ATp;
    int i = com.tencent.mm.plugin.story.i.a.ekB();
    localObject2 = this.lEN;
    String str = this.lEN;
    j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
    this.AOA = ((k)localObject1).c(paramLong, i, (String)localObject2, bt.lQ(str, j.b.dTJ()));
    if (this.AOy != 0L) {
      if (this.AOA >= this.AOy) {
        break label155;
      }
    }
    label155:
    for (paramLong = this.AOA;; paramLong = this.AOy)
    {
      this.AOA = paramLong;
      ad.d(this.TAG, "localMinId=" + this.AOA + ", respMaxId=" + this.AOy);
      AppMethodBeat.o(119344);
      return;
    }
  }
  
  public final void ebV()
  {
    AppMethodBeat.i(119346);
    b localb = g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b(273, (f)this);
    AppMethodBeat.o(119346);
  }
  
  public final void ehn()
  {
    AppMethodBeat.i(119348);
    if (!this.isRunning)
    {
      this.AQu -= 1;
      ad.i(this.TAG, "loadNpData username=" + this.lEN + " maxId=" + this.AOy);
      if (!this.oMN)
      {
        this.isRunning = true;
        Object localObject1 = g.ajB();
        p.g(localObject1, "MMKernel.network()");
        localObject1 = ((b)localObject1).aiU();
        String str = this.lEN;
        long l = this.AOy;
        Object localObject2 = this.lEN;
        j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
        boolean bool = bt.lQ((String)localObject2, j.b.dTJ());
        localObject2 = com.tencent.mm.plugin.story.i.a.ATp;
        ((com.tencent.mm.al.q)localObject1).b((com.tencent.mm.al.n)new i(str, l, bool, "", com.tencent.mm.plugin.story.i.a.ekZ()));
        AppMethodBeat.o(119348);
      }
    }
    else
    {
      ad.i(this.TAG, "loadNpData is running");
    }
    AppMethodBeat.o(119348);
  }
  
  public final void eho()
  {
    AppMethodBeat.i(119349);
    if (!this.isRunning)
    {
      this.isRunning = true;
      ad.i(this.TAG, "loadFpData username=" + this.lEN + " maxId=" + this.AOy);
      Object localObject1 = g.ajB();
      p.g(localObject1, "MMKernel.network()");
      localObject1 = ((b)localObject1).aiU();
      String str = this.lEN;
      Object localObject2 = this.lEN;
      j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
      boolean bool = bt.lQ((String)localObject2, j.b.dTJ());
      localObject2 = com.tencent.mm.plugin.story.i.a.ATp;
      ((com.tencent.mm.al.q)localObject1).b((com.tencent.mm.al.n)new i(str, 0L, bool, "", com.tencent.mm.plugin.story.i.a.ekZ()));
      AppMethodBeat.o(119349);
      return;
    }
    ad.i(this.TAG, "loadFpData is running");
    AppMethodBeat.o(119349);
  }
  
  public final void gl(final List<com.tencent.mm.plugin.story.i.j> paramList)
  {
    AppMethodBeat.i(119351);
    p.h(paramList, "storyList");
    j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.dFL().post((Runnable)new d(this, paramList));
    AppMethodBeat.o(119351);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119345);
    p.h(paramString, "userName");
    this.lEN = paramString;
    AJ(this.AOz);
    paramString = g.ajB();
    p.g(paramString, "MMKernel.network()");
    paramString.aiU().a(273, (f)this);
    AppMethodBeat.o(119345);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(119350);
    ad.i(this.TAG, "LogStory: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString + ' ' + paramn);
    boolean bool;
    if (((paramn instanceof i)) && (bt.lQ(((i)paramn).userName, this.lEN)))
    {
      int i = ((i)paramn).dnh;
      paramString = com.tencent.mm.plugin.story.i.a.ATp;
      if (i == com.tencent.mm.plugin.story.i.a.ekZ())
      {
        ad.d(this.TAG, "onSceneEnd username=" + this.lEN + " respMaxId=" + this.AOy + ' ' + paramInt1 + ' ' + paramInt2 + ' ' + ((i)paramn).ziB);
        this.isRunning = false;
        long l = ((i)paramn).ziB;
        paramString = com.tencent.mm.plugin.story.i.a.ATp;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.ekG())
        {
          paramString = com.tencent.mm.plugin.story.i.a.ATp;
          if ((paramInt2 != com.tencent.mm.plugin.story.i.a.ekH()) && ((paramInt1 != 0) || (paramInt2 != 0) || (l != 0L)))
          {
            paramString = com.tencent.mm.plugin.story.i.a.ATp;
            if ((paramInt2 != com.tencent.mm.plugin.story.i.a.ekF()) || (l != 0L)) {
              break label408;
            }
          }
        }
        bool = true;
        this.oMN = bool;
        this.AQB.si(this.oMN);
        this.AOy = ((i)paramn).ziB;
        if (!((i)paramn).zhh) {
          break label414;
        }
        paramString = com.tencent.mm.plugin.story.f.j.AKb;
        j.b.dFL().post((Runnable)new b(this));
      }
    }
    for (;;)
    {
      ad.d(this.TAG, "onSceneEnd username=" + this.lEN + " respMaxId=" + this.AOy + ' ' + paramInt1 + ' ' + paramInt2 + " isAll:" + this.oMN + " limitId:" + this.AOy);
      AppMethodBeat.o(119350);
      return;
      label408:
      bool = false;
      break;
      label414:
      paramString = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.dFL().post((Runnable)new c(this));
    }
  }
  
  public final void sj(final boolean paramBoolean)
  {
    AppMethodBeat.i(119347);
    j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.dFL().post((Runnable)new a(this, paramBoolean));
    AppMethodBeat.o(119347);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(l paraml, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(119340);
      Object localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
      Object localObject2 = k.a(j.b.ehT(), this.AQC.AOA);
      if (!((List)localObject2).isEmpty()) {
        this.AQC.AOz = ((com.tencent.mm.plugin.story.i.j)d.a.j.je((List)localObject2)).field_storyID;
      }
      ad.d(this.AQC.TAG, "localCachedMinId=" + this.AQC.AOz + " infos.size=" + ((List)localObject2).size() + " localMinId=" + this.AQC.AOA);
      localObject1 = new ArrayList();
      final ArrayList localArrayList = new ArrayList();
      Object localObject3;
      if (paramBoolean)
      {
        localObject3 = com.tencent.mm.plugin.story.f.j.AKb;
        localObject3 = j.b.ehT();
        j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
        localArrayList.addAll((Collection)((k)localObject3).cc(j.b.dTJ(), true));
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject2).next();
        if ((((com.tencent.mm.plugin.story.i.j)localObject3).field_storyID != 0L) && (!((com.tencent.mm.plugin.story.i.j)localObject3).elA())) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      c.g((d.g.a.a)new d.g.b.q((ArrayList)localObject1) {});
      AppMethodBeat.o(119340);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(119341);
      this.AQC.AJ(this.AQC.AOz);
      this.AQC.sj(false);
      if (this.AQC.AQu > 0) {
        this.AQC.ehn();
      }
      AppMethodBeat.o(119341);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(119342);
      this.AQC.AJ(this.AQC.AOz);
      this.AQC.sj(false);
      if (this.AQC.AQu > 0) {
        this.AQC.ehn();
      }
      AppMethodBeat.o(119342);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(l paraml, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(119343);
      Object localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
      Object localObject3 = j.b.ehT().cc(this.AQC.lEN, true);
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
      ad.i(this.AQC.TAG, "LogStory: setFavorite " + ((ArrayList)localObject2).size() + ' ' + ((ArrayList)localObject1).size());
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
            localObject6 = h.ASt;
            h.a(1L, ((com.tencent.mm.plugin.story.i.j)localObject5).toString(), 0L, 0L, 1L);
            continue;
            i = 0;
            break;
          }
        }
        localObject2 = com.tencent.mm.plugin.story.f.n.AKq;
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
            localObject5 = h.ASt;
            h.a(2L, ((com.tencent.mm.plugin.story.i.j)localObject2).toString(), 0L, 0L, 1L);
            continue;
            i = 0;
            break;
          }
        }
        localObject1 = com.tencent.mm.plugin.story.f.n.AKq;
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