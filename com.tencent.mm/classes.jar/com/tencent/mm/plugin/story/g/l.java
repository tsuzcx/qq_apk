package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.d.a.c;
import com.tencent.mm.plugin.story.d.a.d;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.h.h;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/presenter/StoryFavSelectPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;)V", "MAX_COUNT", "", "TAG", "", "isRunning", "", "loadNpCount", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "isAll", "errType", "errCode", "limitId", "loadDBData", "", "first", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setFavorite", "storyList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "updateLocalMinId", "lastId", "plugin-story_release"})
public final class l
  implements com.tencent.mm.ak.i, a.c
{
  private long FqQ;
  long FqR;
  long FqS;
  int FsJ;
  final a.d FsP;
  private final int MAX_COUNT;
  final String TAG;
  private boolean isRunning;
  String mRa;
  private boolean qhf;
  
  public l(a.d paramd)
  {
    AppMethodBeat.i(119352);
    this.FsP = paramd;
    this.TAG = "MicroMsg.StoryFavSelectPresenter";
    this.mRa = "";
    this.MAX_COUNT = 20;
    AppMethodBeat.o(119352);
  }
  
  final void Km(long paramLong)
  {
    AppMethodBeat.i(119344);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject1 = j.b.foc();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.fol();
    p.h(this.mRa, "userName");
    localObject2 = com.tencent.mm.plugin.story.i.a.FvD;
    int i = com.tencent.mm.plugin.story.i.a.fqK();
    localObject2 = this.mRa;
    String str = this.mRa;
    j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
    this.FqS = ((k)localObject1).c(paramLong, i, (String)localObject2, Util.isEqual(str, j.b.fau()));
    if (this.FqQ != 0L) {
      if (this.FqS >= this.FqQ) {
        break label155;
      }
    }
    label155:
    for (paramLong = this.FqS;; paramLong = this.FqQ)
    {
      this.FqS = paramLong;
      Log.d(this.TAG, "localMinId=" + this.FqS + ", respMaxId=" + this.FqQ);
      AppMethodBeat.o(119344);
      return;
    }
  }
  
  public final void fib()
  {
    AppMethodBeat.i(119346);
    b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(273, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(119346);
  }
  
  public final void fnw()
  {
    AppMethodBeat.i(119348);
    if (!this.isRunning)
    {
      this.FsJ -= 1;
      Log.i(this.TAG, "loadNpData username=" + this.mRa + " maxId=" + this.FqQ);
      if (!this.qhf)
      {
        this.isRunning = true;
        Object localObject1 = g.aAg();
        p.g(localObject1, "MMKernel.network()");
        localObject1 = ((b)localObject1).azz();
        String str = this.mRa;
        long l = this.FqQ;
        Object localObject2 = this.mRa;
        j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
        boolean bool = Util.isEqual((String)localObject2, j.b.fau());
        localObject2 = com.tencent.mm.plugin.story.i.a.FvD;
        ((t)localObject1).b((com.tencent.mm.ak.q)new com.tencent.mm.plugin.story.f.a.i(str, l, bool, "", com.tencent.mm.plugin.story.i.a.fri()));
        AppMethodBeat.o(119348);
      }
    }
    else
    {
      Log.i(this.TAG, "loadNpData is running");
    }
    AppMethodBeat.o(119348);
  }
  
  public final void fnx()
  {
    AppMethodBeat.i(119349);
    if (!this.isRunning)
    {
      this.isRunning = true;
      Log.i(this.TAG, "loadFpData username=" + this.mRa + " maxId=" + this.FqQ);
      Object localObject1 = g.aAg();
      p.g(localObject1, "MMKernel.network()");
      localObject1 = ((b)localObject1).azz();
      String str = this.mRa;
      Object localObject2 = this.mRa;
      j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
      boolean bool = Util.isEqual((String)localObject2, j.b.fau());
      localObject2 = com.tencent.mm.plugin.story.i.a.FvD;
      ((t)localObject1).b((com.tencent.mm.ak.q)new com.tencent.mm.plugin.story.f.a.i(str, 0L, bool, "", com.tencent.mm.plugin.story.i.a.fri()));
      AppMethodBeat.o(119349);
      return;
    }
    Log.i(this.TAG, "loadFpData is running");
    AppMethodBeat.o(119349);
  }
  
  public final void hq(final List<com.tencent.mm.plugin.story.i.j> paramList)
  {
    AppMethodBeat.i(119351);
    p.h(paramList, "storyList");
    j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.eJP().post((Runnable)new d(this, paramList));
    AppMethodBeat.o(119351);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119345);
    p.h(paramString, "userName");
    this.mRa = paramString;
    Km(this.FqR);
    paramString = g.aAg();
    p.g(paramString, "MMKernel.network()");
    paramString.azz().a(273, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(119345);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(119350);
    Log.i(this.TAG, "LogStory: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString + ' ' + paramq);
    boolean bool;
    if (((paramq instanceof com.tencent.mm.plugin.story.f.a.i)) && (Util.isEqual(((com.tencent.mm.plugin.story.f.a.i)paramq).userName, this.mRa)))
    {
      int i = ((com.tencent.mm.plugin.story.f.a.i)paramq).source;
      paramString = com.tencent.mm.plugin.story.i.a.FvD;
      if (i == com.tencent.mm.plugin.story.i.a.fri())
      {
        Log.d(this.TAG, "onSceneEnd username=" + this.mRa + " respMaxId=" + this.FqQ + ' ' + paramInt1 + ' ' + paramInt2 + ' ' + ((com.tencent.mm.plugin.story.f.a.i)paramq).DJB);
        this.isRunning = false;
        long l = ((com.tencent.mm.plugin.story.f.a.i)paramq).DJB;
        paramString = com.tencent.mm.plugin.story.i.a.FvD;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.fqP())
        {
          paramString = com.tencent.mm.plugin.story.i.a.FvD;
          if ((paramInt2 != com.tencent.mm.plugin.story.i.a.fqQ()) && ((paramInt1 != 0) || (paramInt2 != 0) || (l != 0L)))
          {
            paramString = com.tencent.mm.plugin.story.i.a.FvD;
            if ((paramInt2 != com.tencent.mm.plugin.story.i.a.fqO()) || (l != 0L)) {
              break label408;
            }
          }
        }
        bool = true;
        this.qhf = bool;
        this.FsP.vK(this.qhf);
        this.FqQ = ((com.tencent.mm.plugin.story.f.a.i)paramq).DJB;
        if (!((com.tencent.mm.plugin.story.f.a.i)paramq).DIe) {
          break label414;
        }
        paramString = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.eJP().post((Runnable)new b(this));
      }
    }
    for (;;)
    {
      Log.d(this.TAG, "onSceneEnd username=" + this.mRa + " respMaxId=" + this.FqQ + ' ' + paramInt1 + ' ' + paramInt2 + " isAll:" + this.qhf + " limitId:" + this.FqQ);
      AppMethodBeat.o(119350);
      return;
      label408:
      bool = false;
      break;
      label414:
      paramString = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.eJP().post((Runnable)new c(this));
    }
  }
  
  public final void vL(final boolean paramBoolean)
  {
    AppMethodBeat.i(119347);
    j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.eJP().post((Runnable)new a(this, paramBoolean));
    AppMethodBeat.o(119347);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(l paraml, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(119340);
      Object localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
      Object localObject2 = k.a(j.b.foc(), this.FsQ.FqS);
      if (!((List)localObject2).isEmpty()) {
        this.FsQ.FqR = ((com.tencent.mm.plugin.story.i.j)kotlin.a.j.ku((List)localObject2)).field_storyID;
      }
      Log.d(this.FsQ.TAG, "localCachedMinId=" + this.FsQ.FqR + " infos.size=" + ((List)localObject2).size() + " localMinId=" + this.FsQ.FqS);
      localObject1 = new ArrayList();
      final ArrayList localArrayList = new ArrayList();
      Object localObject3;
      if (paramBoolean)
      {
        localObject3 = com.tencent.mm.plugin.story.f.j.Fmy;
        localObject3 = j.b.foc();
        j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
        localArrayList.addAll((Collection)((k)localObject3).cy(j.b.fau(), true));
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject2).next();
        if ((((com.tencent.mm.plugin.story.i.j)localObject3).field_storyID != 0L) && (!((com.tencent.mm.plugin.story.i.j)localObject3).frJ())) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      d.h((kotlin.g.a.a)new kotlin.g.b.q((ArrayList)localObject1) {});
      AppMethodBeat.o(119340);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(119341);
      this.FsQ.Km(this.FsQ.FqR);
      this.FsQ.vL(false);
      if (this.FsQ.FsJ > 0) {
        this.FsQ.fnw();
      }
      AppMethodBeat.o(119341);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(119342);
      this.FsQ.Km(this.FsQ.FqR);
      this.FsQ.vL(false);
      if (this.FsQ.FsJ > 0) {
        this.FsQ.fnw();
      }
      AppMethodBeat.o(119342);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(l paraml, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(119343);
      Object localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
      Object localObject3 = j.b.foc().cy(this.FsQ.mRa, true);
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
      Log.i(this.FsQ.TAG, "LogStory: setFavorite " + ((ArrayList)localObject2).size() + ' ' + ((ArrayList)localObject1).size());
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
            localObject6 = h.FuH;
            h.a(1L, ((com.tencent.mm.plugin.story.i.j)localObject5).toString(), 0L, 0L, 1L);
            continue;
            i = 0;
            break;
          }
        }
        localObject2 = n.FmM;
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
            localObject5 = h.FuH;
            h.a(2L, ((com.tencent.mm.plugin.story.i.j)localObject2).toString(), 0L, 0L, 1L);
            continue;
            i = 0;
            break;
          }
        }
        localObject1 = n.FmM;
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