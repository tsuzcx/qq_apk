package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.f.a.e;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.o.a;
import com.tencent.mm.plugin.story.i.h;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;)V", "localCachedMinId", "", "localMinId", "mIsAll", "", "mMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mNpLoopCount", "", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "assembleRealData", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "infos", "checkStoryPost", "", "isAll", "errCode", "loadDBData", "loadFpData", "loadNpData", "needLoopFetch", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errType", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class a
  implements com.tencent.mm.ak.i, com.tencent.mm.plugin.story.d.a.e
{
  public static final a FqV;
  private static final String TAG = "MicroMsg.AlbumPresenter";
  private final LinkedHashMap<String, ArrayList<h>> FqP;
  private long FqQ;
  private long FqR;
  private long FqS;
  private int FqT;
  final com.tencent.mm.plugin.story.d.a.f FqU;
  private String mRa;
  private boolean qhf;
  
  static
  {
    AppMethodBeat.i(119154);
    FqV = new a((byte)0);
    TAG = "MicroMsg.AlbumPresenter";
    AppMethodBeat.o(119154);
  }
  
  public a(com.tencent.mm.plugin.story.d.a.f paramf)
  {
    AppMethodBeat.i(119153);
    this.FqU = paramf;
    this.mRa = "";
    this.FqP = new LinkedHashMap();
    AppMethodBeat.o(119153);
  }
  
  public final void Km(long paramLong)
  {
    AppMethodBeat.i(119146);
    Object localObject = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject = j.b.foc();
    j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.fol();
    this.FqS = ((k)localObject).ab(paramLong, o.a.aSa(this.mRa));
    if (this.FqQ != 0L) {
      if (this.FqS >= this.FqQ) {
        break label116;
      }
    }
    label116:
    for (paramLong = this.FqS;; paramLong = this.FqQ)
    {
      this.FqS = paramLong;
      Log.d(TAG, "localMinId=" + this.FqS + ", respMaxId=" + this.FqQ);
      AppMethodBeat.o(119146);
      return;
    }
  }
  
  public final void fib()
  {
    AppMethodBeat.i(119148);
    b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(191, (com.tencent.mm.ak.i)this);
    localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(3926, (com.tencent.mm.ak.i)this);
    localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(764, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(119148);
  }
  
  public final void fnw()
  {
    AppMethodBeat.i(119151);
    j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.eJP().post((Runnable)new d(this));
    AppMethodBeat.o(119151);
  }
  
  public final void fnx()
  {
    AppMethodBeat.i(119150);
    j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.eJP().post((Runnable)new c(this));
    AppMethodBeat.o(119150);
  }
  
  public final void fnz()
  {
    AppMethodBeat.i(119149);
    j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.eJP().post((Runnable)new b(this));
    AppMethodBeat.o(119149);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119147);
    p.h(paramString, "userName");
    this.mRa = paramString;
    Km(this.FqR);
    paramString = g.aAg();
    p.g(paramString, "MMKernel.network()");
    paramString.azz().a(191, (com.tencent.mm.ak.i)this);
    paramString = g.aAg();
    p.g(paramString, "MMKernel.network()");
    paramString.azz().a(3926, (com.tencent.mm.ak.i)this);
    paramString = g.aAg();
    p.g(paramString, "MMKernel.network()");
    paramString.azz().a(764, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(119147);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(119152);
    boolean bool;
    if (((paramq instanceof e)) && (Util.isEqual(((e)paramq).userName, this.mRa)))
    {
      paramString = com.tencent.mm.plugin.story.i.a.FvD;
      if (paramInt2 != com.tencent.mm.plugin.story.i.a.fqP())
      {
        paramString = com.tencent.mm.plugin.story.i.a.FvD;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.fqQ()) {
          break label188;
        }
      }
      bool = true;
      this.qhf = bool;
      if (this.qhf) {
        this.FqU.fnA();
      }
      if (!((e)paramq).DIe) {
        break label194;
      }
      paramString = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.eJP().post((Runnable)new e(this));
    }
    for (;;)
    {
      this.FqQ = ((e)paramq).DJB;
      Log.d(TAG, "onSceneEnd username=" + this.mRa + " respMaxId=" + this.FqQ + ' ' + paramInt1 + ' ' + paramInt2);
      AppMethodBeat.o(119152);
      return;
      label188:
      bool = false;
      break;
      label194:
      this.FqT = 0;
      paramString = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.eJP().post((Runnable)new f(this));
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119141);
      ArrayList localArrayList1 = new ArrayList();
      Object localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
      localObject1 = k.a(j.b.foc(), a.a(this.FqW), a.b(this.FqW));
      if (!((List)localObject1).isEmpty()) {
        a.a(this.FqW, ((com.tencent.mm.plugin.story.i.j)kotlin.a.j.ku((List)localObject1)).field_storyID);
      }
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = ((Iterable)localObject1).iterator();
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.story.i.j localj = (com.tencent.mm.plugin.story.i.j)localIterator.next();
        localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
        localObject1 = j.b.foh();
        Object localObject2 = com.tencent.mm.plugin.story.e.a.Flw;
        localObject2 = ((com.tencent.mm.plugin.story.i.i)localObject1).aSy(com.tencent.mm.plugin.story.e.a.a.n(Integer.valueOf(localj.field_createTime)));
        localObject1 = a.FqV;
        String str = a.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("loadDBData rawLocalId=").append((int)localj.systemRowid).append(" rawStoryId=").append(localj.field_storyID).append(" date=");
        if (localObject2 != null)
        {
          localObject1 = ((h)localObject2).frD();
          label190:
          localStringBuilder = localStringBuilder.append((String)localObject1).append(" count=");
          if (localObject2 == null) {
            break label317;
          }
        }
        label317:
        for (localObject1 = Integer.valueOf(((h)localObject2).field_count);; localObject1 = null)
        {
          Log.d(str, localObject1);
          if (localObject2 == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
          localj = j.b.foc().aba((int)localj.systemRowid);
          localObject1 = localj;
          if (localj == null) {
            localObject1 = new com.tencent.mm.plugin.story.i.j();
          }
          p.h(localObject1, "<set-?>");
          ((h)localObject2).Fqr = ((com.tencent.mm.plugin.story.i.j)localObject1);
          if (localArrayList2.contains(((h)localObject2).frD())) {
            break;
          }
          localArrayList1.add(localObject2);
          localArrayList2.add(((h)localObject2).frD());
          break;
          localObject1 = null;
          break label190;
        }
      }
      localObject1 = a.FqV;
      Log.d(a.access$getTAG$cp(), "localCachedMinId=" + a.c(this.FqW) + " infos.size=" + localArrayList1.size() + " localMinId=" + a.b(this.FqW));
      d.h((kotlin.g.a.a)new kotlin.g.b.q(a.a(this.FqW, (List)localArrayList1)) {});
      AppMethodBeat.o(119141);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119142);
      Object localObject = a.FqV;
      Log.i(a.access$getTAG$cp(), "loadFpData username=" + a.a(this.FqW) + " maxId=" + a.d(this.FqW));
      localObject = g.aAg();
      p.g(localObject, "MMKernel.network()");
      localObject = ((b)localObject).azz();
      String str1 = a.a(this.FqW);
      long l = a.d(this.FqW);
      String str2 = a.a(this.FqW);
      j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
      ((t)localObject).b((com.tencent.mm.ak.q)new e(str1, l, Util.isEqual(str2, j.b.fau())));
      AppMethodBeat.o(119142);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119143);
      Object localObject = a.FqV;
      Log.i(a.access$getTAG$cp(), "loadNpData username=" + a.a(this.FqW) + " maxId=" + a.d(this.FqW));
      if ((a.e(this.FqW) == 0) && (!a.f(this.FqW)))
      {
        localObject = this.FqW;
        a.a((a)localObject, a.e((a)localObject) + 1);
        localObject = g.aAg();
        p.g(localObject, "MMKernel.network()");
        localObject = ((b)localObject).azz();
        String str1 = a.a(this.FqW);
        long l = a.d(this.FqW);
        String str2 = a.a(this.FqW);
        j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
        ((t)localObject).b((com.tencent.mm.ak.q)new e(str1, l, Util.isEqual(str2, j.b.fau())));
      }
      AppMethodBeat.o(119143);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119144);
      this.FqW.Km(a.c(this.FqW));
      this.FqW.fnz();
      AppMethodBeat.o(119144);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(119145);
      this.FqW.Km(a.c(this.FqW));
      this.FqW.fnz();
      AppMethodBeat.o(119145);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.a
 * JD-Core Version:    0.7.0.1
 */