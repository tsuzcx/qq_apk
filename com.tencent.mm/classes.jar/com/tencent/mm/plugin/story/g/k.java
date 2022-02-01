package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.story.d.a.a;
import com.tencent.mm.plugin.story.d.a.b;
import com.tencent.mm.plugin.story.f.a.f;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;)V", "isRunning", "", "loadNpCount", "", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "isAll", "errType", "errCode", "limitId", "loadFavStoryFromDB", "", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reloadFp", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class k
  implements com.tencent.mm.an.i, a.a
{
  public static final a LMO;
  private static final String TAG = "MicroMsg.StoryFavAlbumPresenter";
  private long LKT;
  private long LKU;
  private long LKV;
  private int LMM;
  final a.b LMN;
  private boolean isRunning;
  private String pRV;
  private boolean tDb;
  
  static
  {
    AppMethodBeat.i(119338);
    LMO = new a((byte)0);
    TAG = "MicroMsg.StoryFavAlbumPresenter";
    AppMethodBeat.o(119338);
  }
  
  public k(a.b paramb)
  {
    AppMethodBeat.i(119337);
    this.LMN = paramb;
    this.pRV = "";
    this.LMM = 1;
    AppMethodBeat.o(119337);
  }
  
  public final void RG(long paramLong)
  {
    AppMethodBeat.i(119331);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
    localObject1 = j.b.gcw();
    String str = this.pRV;
    Object localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
    boolean bool = Util.isEqual(j.b.fOo(), this.pRV);
    localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.gcF();
    localObject2 = com.tencent.mm.plugin.story.i.a.LPG;
    this.LKV = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramLong, str, bool, com.tencent.mm.plugin.story.i.a.gff());
    Log.d(TAG, "localMinId=" + this.LKV + ", respMaxId=" + this.LKT);
    AppMethodBeat.o(119331);
  }
  
  public final void fWn()
  {
    AppMethodBeat.i(119332);
    c localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b(273, (com.tencent.mm.an.i)this);
    localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b(764, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(119332);
  }
  
  public final void gbQ()
  {
    AppMethodBeat.i(119333);
    if (!this.isRunning)
    {
      this.LMM -= 1;
      Log.i(TAG, "loadNpData username=" + this.pRV + " maxId=" + this.LKT);
      if (!this.tDb)
      {
        this.isRunning = true;
        Object localObject1 = h.aHF();
        p.j(localObject1, "MMKernel.network()");
        localObject1 = ((c)localObject1).aGY();
        String str = this.pRV;
        long l = this.LKT;
        Object localObject2 = this.pRV;
        j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
        boolean bool = Util.isEqual((String)localObject2, j.b.fOo());
        localObject2 = com.tencent.mm.plugin.story.i.a.LPG;
        ((t)localObject1).b((com.tencent.mm.an.q)new com.tencent.mm.plugin.story.f.a.i(str, l, bool, "", com.tencent.mm.plugin.story.i.a.gfF()));
      }
    }
    AppMethodBeat.o(119333);
  }
  
  public final void gbR()
  {
    AppMethodBeat.i(119334);
    if (!this.isRunning)
    {
      this.isRunning = true;
      Log.i(TAG, "loadFpData username=" + this.pRV + " maxId=" + this.LKT);
      Object localObject1 = h.aHF();
      p.j(localObject1, "MMKernel.network()");
      localObject1 = ((c)localObject1).aGY();
      String str = this.pRV;
      Object localObject2 = this.pRV;
      j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
      boolean bool = Util.isEqual((String)localObject2, j.b.fOo());
      localObject2 = com.tencent.mm.plugin.story.i.a.LPG;
      ((t)localObject1).b((com.tencent.mm.an.q)new com.tencent.mm.plugin.story.f.a.i(str, 0L, bool, "", com.tencent.mm.plugin.story.i.a.gfF()));
    }
    AppMethodBeat.o(119334);
  }
  
  public final void gbS()
  {
    AppMethodBeat.i(119335);
    j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.fwa().post((Runnable)new b(this));
    AppMethodBeat.o(119335);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119330);
    p.k(paramString, "userName");
    this.pRV = paramString;
    RG(this.LKU);
    paramString = h.aHF();
    p.j(paramString, "MMKernel.network()");
    paramString.aGY().a(273, (com.tencent.mm.an.i)this);
    paramString = h.aHF();
    p.j(paramString, "MMKernel.network()");
    paramString.aGY().a(764, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(119330);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(119336);
    int i;
    if ((paramq instanceof com.tencent.mm.plugin.story.f.a.i))
    {
      i = ((com.tencent.mm.plugin.story.f.a.i)paramq).source;
      paramString = com.tencent.mm.plugin.story.i.a.LPG;
      if (i == com.tencent.mm.plugin.story.i.a.gfF())
      {
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
              break label263;
            }
          }
        }
        boolean bool = true;
        this.tDb = bool;
        this.LMN.zo(this.tDb);
        this.LKT = ((com.tencent.mm.plugin.story.f.a.i)paramq).JWB;
        if (((com.tencent.mm.plugin.story.f.a.i)paramq).JVe)
        {
          paramString = com.tencent.mm.plugin.story.f.j.LGA;
          j.b.fwa().post((Runnable)new c(this));
        }
        for (;;)
        {
          Log.d(TAG, "onSceneEnd username=" + this.pRV + " respMaxId=" + this.LKT + ' ' + paramInt1 + ' ' + paramInt2 + " isAll:" + this.tDb + " limitId:" + this.LKT);
          AppMethodBeat.o(119336);
          return;
          label263:
          bool = false;
          break;
          paramString = com.tencent.mm.plugin.story.f.j.LGA;
          j.b.fwa().post((Runnable)new d(this));
        }
      }
    }
    int j;
    if ((paramq instanceof f))
    {
      paramString = ((f)paramq).gdk();
      if (paramString != null) {
        if (((paramString instanceof com.tencent.mm.plugin.story.f.a.k)) && (paramInt2 == 0))
        {
          paramq = (Iterable)((f)paramq).LHJ;
          j = 0;
          paramq = paramq.iterator();
          i = 0;
          if (paramq.hasNext())
          {
            Object localObject = paramq.next();
            if (j < 0) {
              kotlin.a.j.iBO();
            }
            int k = ((Number)localObject).intValue();
            Log.i(TAG, "onSceneEnd update story favorite: errType " + paramInt1 + ", errcode " + paramInt2 + ", localId " + k + ", favorite:" + ((com.tencent.mm.plugin.story.f.a.k)paramString).favorite);
            localObject = n.LGO;
            n.a.kn(k, ((com.tencent.mm.plugin.story.f.a.k)paramString).favorite);
            if (((com.tencent.mm.plugin.story.f.a.k)paramString).favorite != 1) {
              break label552;
            }
            i = 1;
          }
        }
      }
    }
    label552:
    for (;;)
    {
      j += 1;
      break;
      if (i != 0)
      {
        this.LMM = 1;
        this.LKU = 0L;
        this.LKV = 0L;
        RG(this.LKU);
        gbR();
        gbS();
        AppMethodBeat.o(119336);
        return;
      }
      gbS();
      AppMethodBeat.o(119336);
      return;
      AppMethodBeat.o(119336);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119327);
      final ArrayList localArrayList = new ArrayList();
      final aa.f localf = new aa.f();
      Object localObject = com.tencent.mm.plugin.story.f.j.LGA;
      localObject = j.b.gcw();
      String str1 = k.a(this.LMP);
      String str2 = k.a(this.LMP);
      j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
      localf.aaBC = com.tencent.mm.plugin.story.i.k.a((com.tencent.mm.plugin.story.i.k)localObject, str1, Util.isEqual(str2, j.b.fOo()), k.b(this.LMP));
      int i;
      if (!((Collection)localf.aaBC).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label222;
        }
        k.a(this.LMP, ((com.tencent.mm.plugin.story.i.j)kotlin.a.j.lq((List)localf.aaBC)).field_storyID);
      }
      for (;;)
      {
        localObject = k.LMO;
        Log.d(k.access$getTAG$cp(), "localCachedMinId=" + k.c(this.LMP) + " infos.size=" + ((List)localf.aaBC).size() + " localMinId=" + k.b(this.LMP));
        d.uiThread((kotlin.g.a.a)new kotlin.g.b.q(localf) {});
        AppMethodBeat.o(119327);
        return;
        i = 0;
        break;
        label222:
        localObject = com.tencent.mm.plugin.story.f.j.LGA;
        localObject = j.b.gcw();
        str1 = k.a(this.LMP);
        str2 = k.a(this.LMP);
        localb = com.tencent.mm.plugin.story.f.j.LGA;
        localArrayList.addAll((Collection)((com.tencent.mm.plugin.story.i.k)localObject).cK(str1, Util.isEqual(str2, j.b.fOo())));
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119328);
      this.LMP.RG(k.c(this.LMP));
      this.LMP.gbS();
      if (k.d(this.LMP) > 0) {
        this.LMP.gbQ();
      }
      AppMethodBeat.o(119328);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119329);
      this.LMP.RG(k.c(this.LMP));
      this.LMP.gbS();
      if (k.d(this.LMP) > 0) {
        this.LMP.gbQ();
      }
      AppMethodBeat.o(119329);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.k
 * JD-Core Version:    0.7.0.1
 */