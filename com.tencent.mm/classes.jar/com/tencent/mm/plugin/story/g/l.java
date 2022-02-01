package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.story.d.a.c;
import com.tencent.mm.plugin.story.d.a.d;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/presenter/StoryFavSelectPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;)V", "MAX_COUNT", "", "TAG", "", "isRunning", "", "loadNpCount", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "isAll", "errType", "errCode", "limitId", "loadDBData", "", "first", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setFavorite", "storyList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "updateLocalMinId", "lastId", "plugin-story_release"})
public final class l
  implements com.tencent.mm.an.i, a.c
{
  private long LKT;
  private long LKU;
  private long LKV;
  private int LMM;
  final a.d LMS;
  private final int MAX_COUNT;
  private final String TAG;
  private boolean isRunning;
  private String pRV;
  private boolean tDb;
  
  public l(a.d paramd)
  {
    AppMethodBeat.i(119352);
    this.LMS = paramd;
    this.TAG = "MicroMsg.StoryFavSelectPresenter";
    this.pRV = "";
    this.MAX_COUNT = 20;
    AppMethodBeat.o(119352);
  }
  
  private final void RG(long paramLong)
  {
    AppMethodBeat.i(119344);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
    localObject1 = j.b.gcw();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.gcF();
    p.k(this.pRV, "userName");
    localObject2 = com.tencent.mm.plugin.story.i.a.LPG;
    int i = com.tencent.mm.plugin.story.i.a.gfg();
    localObject2 = this.pRV;
    String str = this.pRV;
    j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
    this.LKV = ((k)localObject1).b(paramLong, i, (String)localObject2, Util.isEqual(str, j.b.fOo()));
    if (this.LKT != 0L) {
      if (this.LKV >= this.LKT) {
        break label155;
      }
    }
    label155:
    for (paramLong = this.LKV;; paramLong = this.LKT)
    {
      this.LKV = paramLong;
      Log.d(this.TAG, "localMinId=" + this.LKV + ", respMaxId=" + this.LKT);
      AppMethodBeat.o(119344);
      return;
    }
  }
  
  public final void fWn()
  {
    AppMethodBeat.i(119346);
    c localc = com.tencent.mm.kernel.h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b(273, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(119346);
  }
  
  public final void gbQ()
  {
    AppMethodBeat.i(119348);
    if (!this.isRunning)
    {
      this.LMM -= 1;
      Log.i(this.TAG, "loadNpData username=" + this.pRV + " maxId=" + this.LKT);
      if (!this.tDb)
      {
        this.isRunning = true;
        Object localObject1 = com.tencent.mm.kernel.h.aHF();
        p.j(localObject1, "MMKernel.network()");
        localObject1 = ((c)localObject1).aGY();
        String str = this.pRV;
        long l = this.LKT;
        Object localObject2 = this.pRV;
        j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
        boolean bool = Util.isEqual((String)localObject2, j.b.fOo());
        localObject2 = com.tencent.mm.plugin.story.i.a.LPG;
        ((t)localObject1).b((com.tencent.mm.an.q)new com.tencent.mm.plugin.story.f.a.i(str, l, bool, "", com.tencent.mm.plugin.story.i.a.gfE()));
        AppMethodBeat.o(119348);
      }
    }
    else
    {
      Log.i(this.TAG, "loadNpData is running");
    }
    AppMethodBeat.o(119348);
  }
  
  public final void gbR()
  {
    AppMethodBeat.i(119349);
    if (!this.isRunning)
    {
      this.isRunning = true;
      Log.i(this.TAG, "loadFpData username=" + this.pRV + " maxId=" + this.LKT);
      Object localObject1 = com.tencent.mm.kernel.h.aHF();
      p.j(localObject1, "MMKernel.network()");
      localObject1 = ((c)localObject1).aGY();
      String str = this.pRV;
      Object localObject2 = this.pRV;
      j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
      boolean bool = Util.isEqual((String)localObject2, j.b.fOo());
      localObject2 = com.tencent.mm.plugin.story.i.a.LPG;
      ((t)localObject1).b((com.tencent.mm.an.q)new com.tencent.mm.plugin.story.f.a.i(str, 0L, bool, "", com.tencent.mm.plugin.story.i.a.gfE()));
      AppMethodBeat.o(119349);
      return;
    }
    Log.i(this.TAG, "loadFpData is running");
    AppMethodBeat.o(119349);
  }
  
  public final void hZ(final List<com.tencent.mm.plugin.story.i.j> paramList)
  {
    AppMethodBeat.i(119351);
    p.k(paramList, "storyList");
    j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.fwa().post((Runnable)new d(this, paramList));
    AppMethodBeat.o(119351);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119345);
    p.k(paramString, "userName");
    this.pRV = paramString;
    RG(this.LKU);
    paramString = com.tencent.mm.kernel.h.aHF();
    p.j(paramString, "MMKernel.network()");
    paramString.aGY().a(273, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(119345);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(119350);
    Log.i(this.TAG, "LogStory: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString + ' ' + paramq);
    boolean bool;
    if (((paramq instanceof com.tencent.mm.plugin.story.f.a.i)) && (Util.isEqual(((com.tencent.mm.plugin.story.f.a.i)paramq).userName, this.pRV)))
    {
      int i = ((com.tencent.mm.plugin.story.f.a.i)paramq).source;
      paramString = com.tencent.mm.plugin.story.i.a.LPG;
      if (i == com.tencent.mm.plugin.story.i.a.gfE())
      {
        Log.d(this.TAG, "onSceneEnd username=" + this.pRV + " respMaxId=" + this.LKT + ' ' + paramInt1 + ' ' + paramInt2 + ' ' + ((com.tencent.mm.plugin.story.f.a.i)paramq).JWB);
        this.isRunning = false;
        long l = ((com.tencent.mm.plugin.story.f.a.i)paramq).JWB;
        paramString = com.tencent.mm.plugin.story.i.a.LPG;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.gfl())
        {
          paramString = com.tencent.mm.plugin.story.i.a.LPG;
          if ((paramInt2 != com.tencent.mm.plugin.story.i.a.gfm()) && ((paramInt1 != 0) || (paramInt2 != 0) || (l != 0L)))
          {
            paramString = com.tencent.mm.plugin.story.i.a.LPG;
            if ((paramInt2 != com.tencent.mm.plugin.story.i.a.gfk()) || (l != 0L)) {
              break label408;
            }
          }
        }
        bool = true;
        this.tDb = bool;
        this.LMS.zo(this.tDb);
        this.LKT = ((com.tencent.mm.plugin.story.f.a.i)paramq).JWB;
        if (!((com.tencent.mm.plugin.story.f.a.i)paramq).JVe) {
          break label414;
        }
        paramString = com.tencent.mm.plugin.story.f.j.LGA;
        j.b.fwa().post((Runnable)new b(this));
      }
    }
    for (;;)
    {
      Log.d(this.TAG, "onSceneEnd username=" + this.pRV + " respMaxId=" + this.LKT + ' ' + paramInt1 + ' ' + paramInt2 + " isAll:" + this.tDb + " limitId:" + this.LKT);
      AppMethodBeat.o(119350);
      return;
      label408:
      bool = false;
      break;
      label414:
      paramString = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.fwa().post((Runnable)new c(this));
    }
  }
  
  public final void zp(final boolean paramBoolean)
  {
    AppMethodBeat.i(119347);
    j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.fwa().post((Runnable)new a(this, paramBoolean));
    AppMethodBeat.o(119347);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(l paraml, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(119340);
      Object localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
      Object localObject2 = k.a(j.b.gcw(), l.c(this.LMT));
      if (!((List)localObject2).isEmpty()) {
        l.b(this.LMT, ((com.tencent.mm.plugin.story.i.j)kotlin.a.j.lq((List)localObject2)).field_storyID);
      }
      Log.d(l.d(this.LMT), "localCachedMinId=" + l.a(this.LMT) + " infos.size=" + ((List)localObject2).size() + " localMinId=" + l.c(this.LMT));
      localObject1 = new ArrayList();
      final ArrayList localArrayList = new ArrayList();
      Object localObject3;
      if (paramBoolean)
      {
        localObject3 = com.tencent.mm.plugin.story.f.j.LGA;
        localObject3 = j.b.gcw();
        j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
        localArrayList.addAll((Collection)((k)localObject3).cM(j.b.fOo(), true));
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject2).next();
        if ((((com.tencent.mm.plugin.story.i.j)localObject3).field_storyID != 0L) && (!((com.tencent.mm.plugin.story.i.j)localObject3).ggf())) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      d.uiThread((kotlin.g.a.a)new kotlin.g.b.q((ArrayList)localObject1) {});
      AppMethodBeat.o(119340);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(119341);
      l.a(this.LMT, l.a(this.LMT));
      this.LMT.zp(false);
      if (l.b(this.LMT) > 0) {
        this.LMT.gbQ();
      }
      AppMethodBeat.o(119341);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(119342);
      l.a(this.LMT, l.a(this.LMT));
      this.LMT.zp(false);
      if (l.b(this.LMT) > 0) {
        this.LMT.gbQ();
      }
      AppMethodBeat.o(119342);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(l paraml, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(119343);
      Object localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
      Object localObject3 = j.b.gcw().cM(l.e(this.LMT), true);
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
      Log.i(l.d(this.LMT), "LogStory: setFavorite " + ((ArrayList)localObject2).size() + ' ' + ((ArrayList)localObject1).size());
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
            localObject6 = com.tencent.mm.plugin.story.h.h.LOJ;
            com.tencent.mm.plugin.story.h.h.a(1L, ((com.tencent.mm.plugin.story.i.j)localObject5).toString(), 0L, 0L, 1L);
            continue;
            i = 0;
            break;
          }
        }
        localObject2 = n.LGO;
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
            localObject5 = com.tencent.mm.plugin.story.h.h.LOJ;
            com.tencent.mm.plugin.story.h.h.a(2L, ((com.tencent.mm.plugin.story.i.j)localObject2).toString(), 0L, 0L, 1L);
            continue;
            i = 0;
            break;
          }
        }
        localObject1 = n.LGO;
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