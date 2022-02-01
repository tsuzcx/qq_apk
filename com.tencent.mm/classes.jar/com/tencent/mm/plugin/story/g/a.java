package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.story.f.a.e;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.o.a;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;)V", "localCachedMinId", "", "localMinId", "mIsAll", "", "mMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mNpLoopCount", "", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "assembleRealData", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "infos", "checkStoryPost", "", "isAll", "errCode", "loadDBData", "loadFpData", "loadNpData", "needLoopFetch", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errType", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class a
  implements com.tencent.mm.al.g, com.tencent.mm.plugin.story.d.a.e
{
  private static final String TAG = "MicroMsg.AlbumPresenter";
  public static final a yjI;
  private String kGt;
  private boolean nGq;
  private final LinkedHashMap<String, ArrayList<h>> yjC;
  private long yjD;
  private long yjE;
  private long yjF;
  private int yjG;
  final com.tencent.mm.plugin.story.d.a.f yjH;
  
  static
  {
    AppMethodBeat.i(119154);
    yjI = new a((byte)0);
    TAG = "MicroMsg.AlbumPresenter";
    AppMethodBeat.o(119154);
  }
  
  public a(com.tencent.mm.plugin.story.d.a.f paramf)
  {
    AppMethodBeat.i(119153);
    this.yjH = paramf;
    this.kGt = "";
    this.yjC = new LinkedHashMap();
    AppMethodBeat.o(119153);
  }
  
  public final void dBh()
  {
    AppMethodBeat.i(119148);
    b localb = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.aeS().b(191, (com.tencent.mm.al.g)this);
    localb = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.aeS().b(3926, (com.tencent.mm.al.g)this);
    localb = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.aeS().b(764, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(119148);
  }
  
  public final void dGA()
  {
    AppMethodBeat.i(119149);
    j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dhI().post((Runnable)new b(this));
    AppMethodBeat.o(119149);
  }
  
  public final void dGx()
  {
    AppMethodBeat.i(119151);
    j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dhI().post((Runnable)new d(this));
    AppMethodBeat.o(119151);
  }
  
  public final void dGy()
  {
    AppMethodBeat.i(119150);
    j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dhI().post((Runnable)new c(this));
    AppMethodBeat.o(119150);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119147);
    d.g.b.k.h(paramString, "userName");
    this.kGt = paramString;
    tI(this.yjE);
    paramString = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(paramString, "MMKernel.network()");
    paramString.aeS().a(191, (com.tencent.mm.al.g)this);
    paramString = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(paramString, "MMKernel.network()");
    paramString.aeS().a(3926, (com.tencent.mm.al.g)this);
    paramString = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(paramString, "MMKernel.network()");
    paramString.aeS().a(764, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(119147);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(119152);
    boolean bool;
    if (((paramn instanceof e)) && (bt.kU(((e)paramn).userName, this.kGt)))
    {
      paramString = com.tencent.mm.plugin.story.i.a.yor;
      if (paramInt2 != com.tencent.mm.plugin.story.i.a.dJQ())
      {
        paramString = com.tencent.mm.plugin.story.i.a.yor;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.dJR()) {
          break label188;
        }
      }
      bool = true;
      this.nGq = bool;
      if (this.nGq) {
        this.yjH.dGB();
      }
      if (!((e)paramn).wES) {
        break label194;
      }
      paramString = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dhI().post((Runnable)new e(this));
    }
    for (;;)
    {
      this.yjD = ((e)paramn).wGn;
      ad.d(TAG, "onSceneEnd username=" + this.kGt + " respMaxId=" + this.yjD + ' ' + paramInt1 + ' ' + paramInt2);
      AppMethodBeat.o(119152);
      return;
      label188:
      bool = false;
      break;
      label194:
      this.yjG = 0;
      paramString = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dhI().post((Runnable)new f(this));
    }
  }
  
  public final void tI(long paramLong)
  {
    AppMethodBeat.i(119146);
    Object localObject = com.tencent.mm.plugin.story.f.j.yfh;
    localObject = j.b.dHd();
    j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dHm();
    this.yjF = ((com.tencent.mm.plugin.story.i.k)localObject).S(paramLong, o.a.ary(this.kGt));
    if (this.yjD != 0L) {
      if (this.yjF >= this.yjD) {
        break label116;
      }
    }
    label116:
    for (paramLong = this.yjF;; paramLong = this.yjD)
    {
      this.yjF = paramLong;
      ad.d(TAG, "localMinId=" + this.yjF + ", respMaxId=" + this.yjD);
      AppMethodBeat.o(119146);
      return;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119141);
      ArrayList localArrayList1 = new ArrayList();
      Object localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
      localObject1 = com.tencent.mm.plugin.story.i.k.a(j.b.dHd(), a.a(this.yjJ), a.b(this.yjJ));
      if (!((List)localObject1).isEmpty()) {
        a.a(this.yjJ, ((com.tencent.mm.plugin.story.i.j)d.a.j.iA((List)localObject1)).field_storyID);
      }
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = ((Iterable)localObject1).iterator();
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.story.i.j localj = (com.tencent.mm.plugin.story.i.j)localIterator.next();
        localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
        localObject1 = j.b.dHi();
        Object localObject2 = com.tencent.mm.plugin.story.e.a.yef;
        localObject2 = ((i)localObject1).arX(com.tencent.mm.plugin.story.e.a.a.k(Integer.valueOf(localj.field_createTime)));
        localObject1 = a.yjI;
        String str = a.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("loadDBData rawLocalId=").append((int)localj.systemRowid).append(" rawStoryId=").append(localj.field_storyID).append(" date=");
        if (localObject2 != null)
        {
          localObject1 = ((h)localObject2).dKE();
          label190:
          localStringBuilder = localStringBuilder.append((String)localObject1).append(" count=");
          if (localObject2 == null) {
            break label317;
          }
        }
        label317:
        for (localObject1 = Integer.valueOf(((h)localObject2).field_count);; localObject1 = null)
        {
          ad.d(str, localObject1);
          if (localObject2 == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
          localj = j.b.dHd().OI((int)localj.systemRowid);
          localObject1 = localj;
          if (localj == null) {
            localObject1 = new com.tencent.mm.plugin.story.i.j();
          }
          d.g.b.k.h(localObject1, "<set-?>");
          ((h)localObject2).yje = ((com.tencent.mm.plugin.story.i.j)localObject1);
          if (localArrayList2.contains(((h)localObject2).dKE())) {
            break;
          }
          localArrayList1.add(localObject2);
          localArrayList2.add(((h)localObject2).dKE());
          break;
          localObject1 = null;
          break label190;
        }
      }
      localObject1 = a.yjI;
      ad.d(a.access$getTAG$cp(), "localCachedMinId=" + a.c(this.yjJ) + " infos.size=" + localArrayList1.size() + " localMinId=" + a.b(this.yjJ));
      c.g((d.g.a.a)new d.g.b.l(a.a(this.yjJ, (List)localArrayList1)) {});
      AppMethodBeat.o(119141);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119142);
      Object localObject = a.yjI;
      ad.i(a.access$getTAG$cp(), "loadFpData username=" + a.a(this.yjJ) + " maxId=" + a.d(this.yjJ));
      localObject = com.tencent.mm.kernel.g.afA();
      d.g.b.k.g(localObject, "MMKernel.network()");
      localObject = ((b)localObject).aeS();
      String str1 = a.a(this.yjJ);
      long l = a.d(this.yjJ);
      String str2 = a.a(this.yjJ);
      j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
      ((q)localObject).b((n)new e(str1, l, bt.kU(str2, j.b.dta())));
      AppMethodBeat.o(119142);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119143);
      Object localObject = a.yjI;
      ad.i(a.access$getTAG$cp(), "loadNpData username=" + a.a(this.yjJ) + " maxId=" + a.d(this.yjJ));
      if ((a.e(this.yjJ) == 0) && (!a.f(this.yjJ)))
      {
        localObject = this.yjJ;
        a.a((a)localObject, a.e((a)localObject) + 1);
        localObject = com.tencent.mm.kernel.g.afA();
        d.g.b.k.g(localObject, "MMKernel.network()");
        localObject = ((b)localObject).aeS();
        String str1 = a.a(this.yjJ);
        long l = a.d(this.yjJ);
        String str2 = a.a(this.yjJ);
        j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
        ((q)localObject).b((n)new e(str1, l, bt.kU(str2, j.b.dta())));
      }
      AppMethodBeat.o(119143);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119144);
      this.yjJ.tI(a.c(this.yjJ));
      this.yjJ.dGA();
      AppMethodBeat.o(119144);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119145);
      this.yjJ.tI(a.c(this.yjJ));
      this.yjJ.dGA();
      AppMethodBeat.o(119145);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.a
 * JD-Core Version:    0.7.0.1
 */