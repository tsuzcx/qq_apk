package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.f.a.e;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.o.a;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;)V", "localCachedMinId", "", "localMinId", "mIsAll", "", "mMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mNpLoopCount", "", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "assembleRealData", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "infos", "checkStoryPost", "", "isAll", "errCode", "loadDBData", "loadFpData", "loadNpData", "needLoopFetch", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errType", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class a
  implements f, com.tencent.mm.plugin.story.d.a.e
{
  public static final a.a Bge;
  private static final String TAG = "MicroMsg.AlbumPresenter";
  private final LinkedHashMap<String, ArrayList<h>> BfY;
  private long BfZ;
  private long Bga;
  private long Bgb;
  private int Bgc;
  final com.tencent.mm.plugin.story.d.a.f Bgd;
  private String lJm;
  private boolean oTp;
  
  static
  {
    AppMethodBeat.i(119154);
    Bge = new a.a((byte)0);
    TAG = "MicroMsg.AlbumPresenter";
    AppMethodBeat.o(119154);
  }
  
  public a(com.tencent.mm.plugin.story.d.a.f paramf)
  {
    AppMethodBeat.i(119153);
    this.Bgd = paramf;
    this.lJm = "";
    this.BfY = new LinkedHashMap();
    AppMethodBeat.o(119153);
  }
  
  public final void Bh(long paramLong)
  {
    AppMethodBeat.i(119146);
    Object localObject = com.tencent.mm.plugin.story.f.j.BbE;
    localObject = j.b.elB();
    j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.elK();
    this.Bgb = ((k)localObject).aa(paramLong, o.a.aDf(this.lJm));
    if (this.BfZ != 0L) {
      if (this.Bgb >= this.BfZ) {
        break label116;
      }
    }
    label116:
    for (paramLong = this.Bgb;; paramLong = this.BfZ)
    {
      this.Bgb = paramLong;
      ae.d(TAG, "localMinId=" + this.Bgb + ", respMaxId=" + this.BfZ);
      AppMethodBeat.o(119146);
      return;
    }
  }
  
  public final void efC()
  {
    AppMethodBeat.i(119148);
    b localb = g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().b(191, (f)this);
    localb = g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().b(3926, (f)this);
    localb = g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().b(764, (f)this);
    AppMethodBeat.o(119148);
  }
  
  public final void ekV()
  {
    AppMethodBeat.i(119151);
    j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.dJc().post((Runnable)new d(this));
    AppMethodBeat.o(119151);
  }
  
  public final void ekW()
  {
    AppMethodBeat.i(119150);
    j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.dJc().post((Runnable)new c(this));
    AppMethodBeat.o(119150);
  }
  
  public final void ekY()
  {
    AppMethodBeat.i(119149);
    j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.dJc().post((Runnable)new b(this));
    AppMethodBeat.o(119149);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119147);
    p.h(paramString, "userName");
    this.lJm = paramString;
    Bh(this.Bga);
    paramString = g.ajQ();
    p.g(paramString, "MMKernel.network()");
    paramString.ajj().a(191, (f)this);
    paramString = g.ajQ();
    p.g(paramString, "MMKernel.network()");
    paramString.ajj().a(3926, (f)this);
    paramString = g.ajQ();
    p.g(paramString, "MMKernel.network()");
    paramString.ajj().a(764, (f)this);
    AppMethodBeat.o(119147);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(119152);
    boolean bool;
    if (((paramn instanceof e)) && (bu.lX(((e)paramn).userName, this.lJm)))
    {
      paramString = com.tencent.mm.plugin.story.i.a.BkN;
      if (paramInt2 != com.tencent.mm.plugin.story.i.a.eop())
      {
        paramString = com.tencent.mm.plugin.story.i.a.BkN;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.eoq()) {
          break label188;
        }
      }
      bool = true;
      this.oTp = bool;
      if (this.oTp) {
        this.Bgd.ekZ();
      }
      if (!((e)paramn).zxW) {
        break label194;
      }
      paramString = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.dJc().post((Runnable)new e(this));
    }
    for (;;)
    {
      this.BfZ = ((e)paramn).zzQ;
      ae.d(TAG, "onSceneEnd username=" + this.lJm + " respMaxId=" + this.BfZ + ' ' + paramInt1 + ' ' + paramInt2);
      AppMethodBeat.o(119152);
      return;
      label188:
      bool = false;
      break;
      label194:
      this.Bgc = 0;
      paramString = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.dJc().post((Runnable)new f(this));
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119141);
      ArrayList localArrayList1 = new ArrayList();
      Object localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
      localObject1 = k.a(j.b.elB(), a.a(this.Bgf), a.b(this.Bgf));
      if (!((List)localObject1).isEmpty()) {
        a.a(this.Bgf, ((com.tencent.mm.plugin.story.i.j)d.a.j.jn((List)localObject1)).field_storyID);
      }
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = ((Iterable)localObject1).iterator();
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.story.i.j localj = (com.tencent.mm.plugin.story.i.j)localIterator.next();
        localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
        localObject1 = j.b.elG();
        Object localObject2 = com.tencent.mm.plugin.story.e.a.BaC;
        localObject2 = ((i)localObject1).aDD(com.tencent.mm.plugin.story.e.a.a.n(Integer.valueOf(localj.field_createTime)));
        localObject1 = a.Bge;
        String str = a.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("loadDBData rawLocalId=").append((int)localj.systemRowid).append(" rawStoryId=").append(localj.field_storyID).append(" date=");
        if (localObject2 != null)
        {
          localObject1 = ((h)localObject2).epd();
          label190:
          localStringBuilder = localStringBuilder.append((String)localObject1).append(" count=");
          if (localObject2 == null) {
            break label317;
          }
        }
        label317:
        for (localObject1 = Integer.valueOf(((h)localObject2).field_count);; localObject1 = null)
        {
          ae.d(str, localObject1);
          if (localObject2 == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
          localj = j.b.elB().Te((int)localj.systemRowid);
          localObject1 = localj;
          if (localj == null) {
            localObject1 = new com.tencent.mm.plugin.story.i.j();
          }
          p.h(localObject1, "<set-?>");
          ((h)localObject2).BfA = ((com.tencent.mm.plugin.story.i.j)localObject1);
          if (localArrayList2.contains(((h)localObject2).epd())) {
            break;
          }
          localArrayList1.add(localObject2);
          localArrayList2.add(((h)localObject2).epd());
          break;
          localObject1 = null;
          break label190;
        }
      }
      localObject1 = a.Bge;
      ae.d(a.access$getTAG$cp(), "localCachedMinId=" + a.c(this.Bgf) + " infos.size=" + localArrayList1.size() + " localMinId=" + a.b(this.Bgf));
      c.h((d.g.a.a)new d.g.b.q(a.a(this.Bgf, (List)localArrayList1)) {});
      AppMethodBeat.o(119141);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119142);
      Object localObject = a.Bge;
      ae.i(a.access$getTAG$cp(), "loadFpData username=" + a.a(this.Bgf) + " maxId=" + a.d(this.Bgf));
      localObject = g.ajQ();
      p.g(localObject, "MMKernel.network()");
      localObject = ((b)localObject).ajj();
      String str1 = a.a(this.Bgf);
      long l = a.d(this.Bgf);
      String str2 = a.a(this.Bgf);
      j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
      ((com.tencent.mm.ak.q)localObject).b((n)new e(str1, l, bu.lX(str2, j.b.dXj())));
      AppMethodBeat.o(119142);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119143);
      Object localObject = a.Bge;
      ae.i(a.access$getTAG$cp(), "loadNpData username=" + a.a(this.Bgf) + " maxId=" + a.d(this.Bgf));
      if ((a.e(this.Bgf) == 0) && (!a.f(this.Bgf)))
      {
        localObject = this.Bgf;
        a.a((a)localObject, a.e((a)localObject) + 1);
        localObject = g.ajQ();
        p.g(localObject, "MMKernel.network()");
        localObject = ((b)localObject).ajj();
        String str1 = a.a(this.Bgf);
        long l = a.d(this.Bgf);
        String str2 = a.a(this.Bgf);
        j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
        ((com.tencent.mm.ak.q)localObject).b((n)new e(str1, l, bu.lX(str2, j.b.dXj())));
      }
      AppMethodBeat.o(119143);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119144);
      this.Bgf.Bh(a.c(this.Bgf));
      this.Bgf.ekY();
      AppMethodBeat.o(119144);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119145);
      this.Bgf.Bh(a.c(this.Bgf));
      this.Bgf.ekY();
      AppMethodBeat.o(119145);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.a
 * JD-Core Version:    0.7.0.1
 */