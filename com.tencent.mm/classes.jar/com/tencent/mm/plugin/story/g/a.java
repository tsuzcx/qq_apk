package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.story.f.a.e;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.o.a;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;)V", "localCachedMinId", "", "localMinId", "mIsAll", "", "mMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mNpLoopCount", "", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "assembleRealData", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "infos", "checkStoryPost", "", "isAll", "errCode", "loadDBData", "loadFpData", "loadNpData", "needLoopFetch", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errType", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class a
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.story.d.a.e
{
  public static final a LKY;
  private static final String TAG = "MicroMsg.AlbumPresenter";
  private final LinkedHashMap<String, ArrayList<com.tencent.mm.plugin.story.i.h>> LKS;
  private long LKT;
  private long LKU;
  private long LKV;
  private int LKW;
  final com.tencent.mm.plugin.story.d.a.f LKX;
  private String pRV;
  private boolean tDb;
  
  static
  {
    AppMethodBeat.i(119154);
    LKY = new a((byte)0);
    TAG = "MicroMsg.AlbumPresenter";
    AppMethodBeat.o(119154);
  }
  
  public a(com.tencent.mm.plugin.story.d.a.f paramf)
  {
    AppMethodBeat.i(119153);
    this.LKX = paramf;
    this.pRV = "";
    this.LKS = new LinkedHashMap();
    AppMethodBeat.o(119153);
  }
  
  public final void RG(long paramLong)
  {
    AppMethodBeat.i(119146);
    Object localObject = com.tencent.mm.plugin.story.f.j.LGA;
    localObject = j.b.gcw();
    j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.gcF();
    this.LKV = ((k)localObject).ak(paramLong, o.a.bde(this.pRV));
    if (this.LKT != 0L) {
      if (this.LKV >= this.LKT) {
        break label116;
      }
    }
    label116:
    for (paramLong = this.LKV;; paramLong = this.LKT)
    {
      this.LKV = paramLong;
      Log.d(TAG, "localMinId=" + this.LKV + ", respMaxId=" + this.LKT);
      AppMethodBeat.o(119146);
      return;
    }
  }
  
  public final void fWn()
  {
    AppMethodBeat.i(119148);
    c localc = com.tencent.mm.kernel.h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b(191, (com.tencent.mm.an.i)this);
    localc = com.tencent.mm.kernel.h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b(3926, (com.tencent.mm.an.i)this);
    localc = com.tencent.mm.kernel.h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b(764, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(119148);
  }
  
  public final void gbQ()
  {
    AppMethodBeat.i(119151);
    j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.fwa().post((Runnable)new d(this));
    AppMethodBeat.o(119151);
  }
  
  public final void gbR()
  {
    AppMethodBeat.i(119150);
    j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.fwa().post((Runnable)new c(this));
    AppMethodBeat.o(119150);
  }
  
  public final void gbT()
  {
    AppMethodBeat.i(119149);
    j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.fwa().post((Runnable)new b(this));
    AppMethodBeat.o(119149);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119147);
    p.k(paramString, "userName");
    this.pRV = paramString;
    RG(this.LKU);
    paramString = com.tencent.mm.kernel.h.aHF();
    p.j(paramString, "MMKernel.network()");
    paramString.aGY().a(191, (com.tencent.mm.an.i)this);
    paramString = com.tencent.mm.kernel.h.aHF();
    p.j(paramString, "MMKernel.network()");
    paramString.aGY().a(3926, (com.tencent.mm.an.i)this);
    paramString = com.tencent.mm.kernel.h.aHF();
    p.j(paramString, "MMKernel.network()");
    paramString.aGY().a(764, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(119147);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(119152);
    boolean bool;
    if (((paramq instanceof e)) && (Util.isEqual(((e)paramq).userName, this.pRV)))
    {
      paramString = com.tencent.mm.plugin.story.i.a.LPG;
      if (paramInt2 != com.tencent.mm.plugin.story.i.a.gfl())
      {
        paramString = com.tencent.mm.plugin.story.i.a.LPG;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.gfm()) {
          break label188;
        }
      }
      bool = true;
      this.tDb = bool;
      if (this.tDb) {
        this.LKX.gbU();
      }
      if (!((e)paramq).JVe) {
        break label194;
      }
      paramString = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.fwa().post((Runnable)new e(this));
    }
    for (;;)
    {
      this.LKT = ((e)paramq).JWB;
      Log.d(TAG, "onSceneEnd username=" + this.pRV + " respMaxId=" + this.LKT + ' ' + paramInt1 + ' ' + paramInt2);
      AppMethodBeat.o(119152);
      return;
      label188:
      bool = false;
      break;
      label194:
      this.LKW = 0;
      paramString = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.fwa().post((Runnable)new f(this));
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119141);
      ArrayList localArrayList1 = new ArrayList();
      Object localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
      localObject1 = k.a(j.b.gcw(), a.a(this.LKZ), a.b(this.LKZ));
      if (!((List)localObject1).isEmpty()) {
        a.a(this.LKZ, ((com.tencent.mm.plugin.story.i.j)kotlin.a.j.lq((List)localObject1)).field_storyID);
      }
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = ((Iterable)localObject1).iterator();
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.story.i.j localj = (com.tencent.mm.plugin.story.i.j)localIterator.next();
        localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
        localObject1 = j.b.gcB();
        Object localObject2 = com.tencent.mm.plugin.story.e.a.LFy;
        localObject2 = ((com.tencent.mm.plugin.story.i.i)localObject1).bdC(com.tencent.mm.plugin.story.e.a.a.v(Integer.valueOf(localj.field_createTime)));
        localObject1 = a.LKY;
        String str = a.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("loadDBData rawLocalId=").append((int)localj.systemRowid).append(" rawStoryId=").append(localj.field_storyID).append(" date=");
        if (localObject2 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.story.i.h)localObject2).gfZ();
          label190:
          localStringBuilder = localStringBuilder.append((String)localObject1).append(" count=");
          if (localObject2 == null) {
            break label317;
          }
        }
        label317:
        for (localObject1 = Integer.valueOf(((com.tencent.mm.plugin.story.i.h)localObject2).field_count);; localObject1 = null)
        {
          Log.d(str, localObject1);
          if (localObject2 == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
          localj = j.b.gcw().aiv((int)localj.systemRowid);
          localObject1 = localj;
          if (localj == null) {
            localObject1 = new com.tencent.mm.plugin.story.i.j();
          }
          p.k(localObject1, "<set-?>");
          ((com.tencent.mm.plugin.story.i.h)localObject2).LKu = ((com.tencent.mm.plugin.story.i.j)localObject1);
          if (localArrayList2.contains(((com.tencent.mm.plugin.story.i.h)localObject2).gfZ())) {
            break;
          }
          localArrayList1.add(localObject2);
          localArrayList2.add(((com.tencent.mm.plugin.story.i.h)localObject2).gfZ());
          break;
          localObject1 = null;
          break label190;
        }
      }
      localObject1 = a.LKY;
      Log.d(a.access$getTAG$cp(), "localCachedMinId=" + a.c(this.LKZ) + " infos.size=" + localArrayList1.size() + " localMinId=" + a.b(this.LKZ));
      d.uiThread((kotlin.g.a.a)new kotlin.g.b.q(a.a(this.LKZ, (List)localArrayList1)) {});
      AppMethodBeat.o(119141);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119142);
      Object localObject = a.LKY;
      Log.i(a.access$getTAG$cp(), "loadFpData username=" + a.a(this.LKZ) + " maxId=" + a.d(this.LKZ));
      localObject = com.tencent.mm.kernel.h.aHF();
      p.j(localObject, "MMKernel.network()");
      localObject = ((c)localObject).aGY();
      String str1 = a.a(this.LKZ);
      long l = a.d(this.LKZ);
      String str2 = a.a(this.LKZ);
      j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
      ((t)localObject).b((com.tencent.mm.an.q)new e(str1, l, Util.isEqual(str2, j.b.fOo())));
      AppMethodBeat.o(119142);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119143);
      Object localObject = a.LKY;
      Log.i(a.access$getTAG$cp(), "loadNpData username=" + a.a(this.LKZ) + " maxId=" + a.d(this.LKZ));
      if ((a.e(this.LKZ) == 0) && (!a.f(this.LKZ)))
      {
        localObject = this.LKZ;
        a.a((a)localObject, a.e((a)localObject) + 1);
        localObject = com.tencent.mm.kernel.h.aHF();
        p.j(localObject, "MMKernel.network()");
        localObject = ((c)localObject).aGY();
        String str1 = a.a(this.LKZ);
        long l = a.d(this.LKZ);
        String str2 = a.a(this.LKZ);
        j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
        ((t)localObject).b((com.tencent.mm.an.q)new e(str1, l, Util.isEqual(str2, j.b.fOo())));
      }
      AppMethodBeat.o(119143);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119144);
      this.LKZ.RG(a.c(this.LKZ));
      this.LKZ.gbT();
      AppMethodBeat.o(119144);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119145);
      this.LKZ.RG(a.c(this.LKZ));
      this.LKZ.gbT();
      AppMethodBeat.o(119145);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.a
 * JD-Core Version:    0.7.0.1
 */