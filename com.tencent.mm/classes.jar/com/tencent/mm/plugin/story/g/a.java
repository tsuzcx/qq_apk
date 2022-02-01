package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.story.f.a.e;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.o.a;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;)V", "localCachedMinId", "", "localMinId", "mIsAll", "", "mMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mNpLoopCount", "", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "assembleRealData", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "infos", "checkStoryPost", "", "isAll", "errCode", "loadDBData", "loadFpData", "loadNpData", "needLoopFetch", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errType", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class a
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.story.d.a.e
{
  private static final String TAG = "MicroMsg.AlbumPresenter";
  public static final a.a zwH;
  private String lhM;
  private boolean ojr;
  private final LinkedHashMap<String, ArrayList<h>> zwB;
  private long zwC;
  private long zwD;
  private long zwE;
  private int zwF;
  final com.tencent.mm.plugin.story.d.a.f zwG;
  
  static
  {
    AppMethodBeat.i(119154);
    zwH = new a.a((byte)0);
    TAG = "MicroMsg.AlbumPresenter";
    AppMethodBeat.o(119154);
  }
  
  public a(com.tencent.mm.plugin.story.d.a.f paramf)
  {
    AppMethodBeat.i(119153);
    this.zwG = paramf;
    this.lhM = "";
    this.zwB = new LinkedHashMap();
    AppMethodBeat.o(119153);
  }
  
  public final void dPE()
  {
    AppMethodBeat.i(119148);
    b localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().b(191, (com.tencent.mm.ak.g)this);
    localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().b(3926, (com.tencent.mm.ak.g)this);
    localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().b(764, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(119148);
  }
  
  public final void dUY()
  {
    AppMethodBeat.i(119151);
    j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dvq().post((Runnable)new d(this));
    AppMethodBeat.o(119151);
  }
  
  public final void dUZ()
  {
    AppMethodBeat.i(119150);
    j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dvq().post((Runnable)new c(this));
    AppMethodBeat.o(119150);
  }
  
  public final void dVb()
  {
    AppMethodBeat.i(119149);
    j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dvq().post((Runnable)new b(this));
    AppMethodBeat.o(119149);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119147);
    d.g.b.k.h(paramString, "userName");
    this.lhM = paramString;
    yl(this.zwD);
    paramString = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(paramString, "MMKernel.network()");
    paramString.agi().a(191, (com.tencent.mm.ak.g)this);
    paramString = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(paramString, "MMKernel.network()");
    paramString.agi().a(3926, (com.tencent.mm.ak.g)this);
    paramString = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(paramString, "MMKernel.network()");
    paramString.agi().a(764, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(119147);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(119152);
    boolean bool;
    if (((paramn instanceof e)) && (bs.lr(((e)paramn).userName, this.lhM)))
    {
      paramString = com.tencent.mm.plugin.story.i.a.zBQ;
      if (paramInt2 != com.tencent.mm.plugin.story.i.a.dYr())
      {
        paramString = com.tencent.mm.plugin.story.i.a.zBQ;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.dYs()) {
          break label188;
        }
      }
      bool = true;
      this.ojr = bool;
      if (this.ojr) {
        this.zwG.dVc();
      }
      if (!((e)paramn).xRn) {
        break label194;
      }
      paramString = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dvq().post((Runnable)new e(this));
    }
    for (;;)
    {
      this.zwC = ((e)paramn).xSH;
      ac.d(TAG, "onSceneEnd username=" + this.lhM + " respMaxId=" + this.zwC + ' ' + paramInt1 + ' ' + paramInt2);
      AppMethodBeat.o(119152);
      return;
      label188:
      bool = false;
      break;
      label194:
      this.zwF = 0;
      paramString = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dvq().post((Runnable)new f(this));
    }
  }
  
  public final void yl(long paramLong)
  {
    AppMethodBeat.i(119146);
    Object localObject = com.tencent.mm.plugin.story.f.j.zsh;
    localObject = j.b.dVE();
    j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dVN();
    this.zwE = ((com.tencent.mm.plugin.story.i.k)localObject).V(paramLong, o.a.awH(this.lhM));
    if (this.zwC != 0L) {
      if (this.zwE >= this.zwC) {
        break label116;
      }
    }
    label116:
    for (paramLong = this.zwE;; paramLong = this.zwC)
    {
      this.zwE = paramLong;
      ac.d(TAG, "localMinId=" + this.zwE + ", respMaxId=" + this.zwC);
      AppMethodBeat.o(119146);
      return;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119141);
      ArrayList localArrayList1 = new ArrayList();
      Object localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
      localObject1 = com.tencent.mm.plugin.story.i.k.a(j.b.dVE(), a.a(this.zwI), a.b(this.zwI));
      if (!((List)localObject1).isEmpty()) {
        a.a(this.zwI, ((com.tencent.mm.plugin.story.i.j)d.a.j.iQ((List)localObject1)).field_storyID);
      }
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = ((Iterable)localObject1).iterator();
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.story.i.j localj = (com.tencent.mm.plugin.story.i.j)localIterator.next();
        localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
        localObject1 = j.b.dVJ();
        Object localObject2 = com.tencent.mm.plugin.story.e.a.zrf;
        localObject2 = ((i)localObject1).axg(com.tencent.mm.plugin.story.e.a.a.l(Integer.valueOf(localj.field_createTime)));
        localObject1 = a.zwH;
        String str = a.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("loadDBData rawLocalId=").append((int)localj.systemRowid).append(" rawStoryId=").append(localj.field_storyID).append(" date=");
        if (localObject2 != null)
        {
          localObject1 = ((h)localObject2).dZf();
          label190:
          localStringBuilder = localStringBuilder.append((String)localObject1).append(" count=");
          if (localObject2 == null) {
            break label317;
          }
        }
        label317:
        for (localObject1 = Integer.valueOf(((h)localObject2).field_count);; localObject1 = null)
        {
          ac.d(str, localObject1);
          if (localObject2 == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
          localj = j.b.dVE().QO((int)localj.systemRowid);
          localObject1 = localj;
          if (localj == null) {
            localObject1 = new com.tencent.mm.plugin.story.i.j();
          }
          d.g.b.k.h(localObject1, "<set-?>");
          ((h)localObject2).zwd = ((com.tencent.mm.plugin.story.i.j)localObject1);
          if (localArrayList2.contains(((h)localObject2).dZf())) {
            break;
          }
          localArrayList1.add(localObject2);
          localArrayList2.add(((h)localObject2).dZf());
          break;
          localObject1 = null;
          break label190;
        }
      }
      localObject1 = a.zwH;
      ac.d(a.access$getTAG$cp(), "localCachedMinId=" + a.c(this.zwI) + " infos.size=" + localArrayList1.size() + " localMinId=" + a.b(this.zwI));
      c.g((d.g.a.a)new d.g.b.l(a.a(this.zwI, (List)localArrayList1)) {});
      AppMethodBeat.o(119141);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119142);
      Object localObject = a.zwH;
      ac.i(a.access$getTAG$cp(), "loadFpData username=" + a.a(this.zwI) + " maxId=" + a.d(this.zwI));
      localObject = com.tencent.mm.kernel.g.agQ();
      d.g.b.k.g(localObject, "MMKernel.network()");
      localObject = ((b)localObject).agi();
      String str1 = a.a(this.zwI);
      long l = a.d(this.zwI);
      String str2 = a.a(this.zwI);
      j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
      ((q)localObject).b((n)new e(str1, l, bs.lr(str2, j.b.dHx())));
      AppMethodBeat.o(119142);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119143);
      Object localObject = a.zwH;
      ac.i(a.access$getTAG$cp(), "loadNpData username=" + a.a(this.zwI) + " maxId=" + a.d(this.zwI));
      if ((a.e(this.zwI) == 0) && (!a.f(this.zwI)))
      {
        localObject = this.zwI;
        a.a((a)localObject, a.e((a)localObject) + 1);
        localObject = com.tencent.mm.kernel.g.agQ();
        d.g.b.k.g(localObject, "MMKernel.network()");
        localObject = ((b)localObject).agi();
        String str1 = a.a(this.zwI);
        long l = a.d(this.zwI);
        String str2 = a.a(this.zwI);
        j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
        ((q)localObject).b((n)new e(str1, l, bs.lr(str2, j.b.dHx())));
      }
      AppMethodBeat.o(119143);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119144);
      this.zwI.yl(a.c(this.zwI));
      this.zwI.dVb();
      AppMethodBeat.o(119144);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119145);
      this.zwI.yl(a.c(this.zwI));
      this.zwI.dVb();
      AppMethodBeat.o(119145);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.a
 * JD-Core Version:    0.7.0.1
 */