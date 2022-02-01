package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.f.a.e;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.o.a;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;)V", "localCachedMinId", "", "localMinId", "mIsAll", "", "mMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mNpLoopCount", "", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "assembleRealData", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "infos", "checkStoryPost", "", "isAll", "errCode", "loadDBData", "loadFpData", "loadNpData", "needLoopFetch", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errType", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class a
  implements f, com.tencent.mm.plugin.story.d.a.e
{
  public static final a.a AOD;
  private static final String TAG = "MicroMsg.AlbumPresenter";
  private long AOA;
  private int AOB;
  final com.tencent.mm.plugin.story.d.a.f AOC;
  private final LinkedHashMap<String, ArrayList<h>> AOx;
  private long AOy;
  private long AOz;
  private String lEN;
  private boolean oMN;
  
  static
  {
    AppMethodBeat.i(119154);
    AOD = new a.a((byte)0);
    TAG = "MicroMsg.AlbumPresenter";
    AppMethodBeat.o(119154);
  }
  
  public a(com.tencent.mm.plugin.story.d.a.f paramf)
  {
    AppMethodBeat.i(119153);
    this.AOC = paramf;
    this.lEN = "";
    this.AOx = new LinkedHashMap();
    AppMethodBeat.o(119153);
  }
  
  public final void AJ(long paramLong)
  {
    AppMethodBeat.i(119146);
    Object localObject = com.tencent.mm.plugin.story.f.j.AKb;
    localObject = j.b.ehT();
    j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.eic();
    this.AOA = ((k)localObject).aa(paramLong, o.a.aBM(this.lEN));
    if (this.AOy != 0L) {
      if (this.AOA >= this.AOy) {
        break label116;
      }
    }
    label116:
    for (paramLong = this.AOA;; paramLong = this.AOy)
    {
      this.AOA = paramLong;
      ad.d(TAG, "localMinId=" + this.AOA + ", respMaxId=" + this.AOy);
      AppMethodBeat.o(119146);
      return;
    }
  }
  
  public final void ebV()
  {
    AppMethodBeat.i(119148);
    b localb = g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b(191, (f)this);
    localb = g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b(3926, (f)this);
    localb = g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b(764, (f)this);
    AppMethodBeat.o(119148);
  }
  
  public final void ehn()
  {
    AppMethodBeat.i(119151);
    j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.dFL().post((Runnable)new d(this));
    AppMethodBeat.o(119151);
  }
  
  public final void eho()
  {
    AppMethodBeat.i(119150);
    j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.dFL().post((Runnable)new c(this));
    AppMethodBeat.o(119150);
  }
  
  public final void ehq()
  {
    AppMethodBeat.i(119149);
    j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.dFL().post((Runnable)new b(this));
    AppMethodBeat.o(119149);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119147);
    p.h(paramString, "userName");
    this.lEN = paramString;
    AJ(this.AOz);
    paramString = g.ajB();
    p.g(paramString, "MMKernel.network()");
    paramString.aiU().a(191, (f)this);
    paramString = g.ajB();
    p.g(paramString, "MMKernel.network()");
    paramString.aiU().a(3926, (f)this);
    paramString = g.ajB();
    p.g(paramString, "MMKernel.network()");
    paramString.aiU().a(764, (f)this);
    AppMethodBeat.o(119147);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(119152);
    boolean bool;
    if (((paramn instanceof e)) && (bt.lQ(((e)paramn).userName, this.lEN)))
    {
      paramString = com.tencent.mm.plugin.story.i.a.ATp;
      if (paramInt2 != com.tencent.mm.plugin.story.i.a.ekG())
      {
        paramString = com.tencent.mm.plugin.story.i.a.ATp;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.ekH()) {
          break label188;
        }
      }
      bool = true;
      this.oMN = bool;
      if (this.oMN) {
        this.AOC.ehr();
      }
      if (!((e)paramn).zhh) {
        break label194;
      }
      paramString = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.dFL().post((Runnable)new e(this));
    }
    for (;;)
    {
      this.AOy = ((e)paramn).ziB;
      ad.d(TAG, "onSceneEnd username=" + this.lEN + " respMaxId=" + this.AOy + ' ' + paramInt1 + ' ' + paramInt2);
      AppMethodBeat.o(119152);
      return;
      label188:
      bool = false;
      break;
      label194:
      this.AOB = 0;
      paramString = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.dFL().post((Runnable)new f(this));
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119141);
      ArrayList localArrayList1 = new ArrayList();
      Object localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
      localObject1 = k.a(j.b.ehT(), a.a(this.AOE), a.b(this.AOE));
      if (!((List)localObject1).isEmpty()) {
        a.a(this.AOE, ((com.tencent.mm.plugin.story.i.j)d.a.j.je((List)localObject1)).field_storyID);
      }
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = ((Iterable)localObject1).iterator();
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.story.i.j localj = (com.tencent.mm.plugin.story.i.j)localIterator.next();
        localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
        localObject1 = j.b.ehY();
        Object localObject2 = com.tencent.mm.plugin.story.e.a.AIZ;
        localObject2 = ((i)localObject1).aCk(com.tencent.mm.plugin.story.e.a.a.m(Integer.valueOf(localj.field_createTime)));
        localObject1 = a.AOD;
        String str = a.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("loadDBData rawLocalId=").append((int)localj.systemRowid).append(" rawStoryId=").append(localj.field_storyID).append(" date=");
        if (localObject2 != null)
        {
          localObject1 = ((h)localObject2).elu();
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
          localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
          localj = j.b.ehT().Sx((int)localj.systemRowid);
          localObject1 = localj;
          if (localj == null) {
            localObject1 = new com.tencent.mm.plugin.story.i.j();
          }
          p.h(localObject1, "<set-?>");
          ((h)localObject2).ANZ = ((com.tencent.mm.plugin.story.i.j)localObject1);
          if (localArrayList2.contains(((h)localObject2).elu())) {
            break;
          }
          localArrayList1.add(localObject2);
          localArrayList2.add(((h)localObject2).elu());
          break;
          localObject1 = null;
          break label190;
        }
      }
      localObject1 = a.AOD;
      ad.d(a.access$getTAG$cp(), "localCachedMinId=" + a.c(this.AOE) + " infos.size=" + localArrayList1.size() + " localMinId=" + a.b(this.AOE));
      c.g((d.g.a.a)new d.g.b.q(a.a(this.AOE, (List)localArrayList1)) {});
      AppMethodBeat.o(119141);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119142);
      Object localObject = a.AOD;
      ad.i(a.access$getTAG$cp(), "loadFpData username=" + a.a(this.AOE) + " maxId=" + a.d(this.AOE));
      localObject = g.ajB();
      p.g(localObject, "MMKernel.network()");
      localObject = ((b)localObject).aiU();
      String str1 = a.a(this.AOE);
      long l = a.d(this.AOE);
      String str2 = a.a(this.AOE);
      j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
      ((com.tencent.mm.al.q)localObject).b((n)new e(str1, l, bt.lQ(str2, j.b.dTJ())));
      AppMethodBeat.o(119142);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119143);
      Object localObject = a.AOD;
      ad.i(a.access$getTAG$cp(), "loadNpData username=" + a.a(this.AOE) + " maxId=" + a.d(this.AOE));
      if ((a.e(this.AOE) == 0) && (!a.f(this.AOE)))
      {
        localObject = this.AOE;
        a.a((a)localObject, a.e((a)localObject) + 1);
        localObject = g.ajB();
        p.g(localObject, "MMKernel.network()");
        localObject = ((b)localObject).aiU();
        String str1 = a.a(this.AOE);
        long l = a.d(this.AOE);
        String str2 = a.a(this.AOE);
        j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
        ((com.tencent.mm.al.q)localObject).b((n)new e(str1, l, bt.lQ(str2, j.b.dTJ())));
      }
      AppMethodBeat.o(119143);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119144);
      this.AOE.AJ(a.c(this.AOE));
      this.AOE.ehq();
      AppMethodBeat.o(119144);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119145);
      this.AOE.AJ(a.c(this.AOE));
      this.AOE.ehq();
      AppMethodBeat.o(119145);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.a
 * JD-Core Version:    0.7.0.1
 */