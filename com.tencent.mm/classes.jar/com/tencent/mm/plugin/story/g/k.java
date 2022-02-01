package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.story.d.a.a;
import com.tencent.mm.plugin.story.d.a.b;
import com.tencent.mm.plugin.story.f.a.f;
import com.tencent.mm.plugin.story.f.a.i;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.v.e;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;)V", "isRunning", "", "loadNpCount", "", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "isAll", "errType", "errCode", "limitId", "loadFavStoryFromDB", "", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reloadFp", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class k
  implements com.tencent.mm.al.g, a.a
{
  private static final String TAG = "MicroMsg.StoryFavAlbumPresenter";
  public static final a yly;
  private boolean isRunning;
  private String kGt;
  private boolean nGq;
  private long yjD;
  private long yjE;
  private long yjF;
  private int ylw;
  final a.b ylx;
  
  static
  {
    AppMethodBeat.i(119338);
    yly = new a((byte)0);
    TAG = "MicroMsg.StoryFavAlbumPresenter";
    AppMethodBeat.o(119338);
  }
  
  public k(a.b paramb)
  {
    AppMethodBeat.i(119337);
    this.ylx = paramb;
    this.kGt = "";
    this.ylw = 1;
    AppMethodBeat.o(119337);
  }
  
  public final void dBh()
  {
    AppMethodBeat.i(119332);
    b localb = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.aeS().b(273, (com.tencent.mm.al.g)this);
    localb = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.aeS().b(764, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(119332);
  }
  
  public final void dGx()
  {
    AppMethodBeat.i(119333);
    if (!this.isRunning)
    {
      this.ylw -= 1;
      ad.i(TAG, "loadNpData username=" + this.kGt + " maxId=" + this.yjD);
      if (!this.nGq)
      {
        this.isRunning = true;
        Object localObject1 = com.tencent.mm.kernel.g.afA();
        d.g.b.k.g(localObject1, "MMKernel.network()");
        localObject1 = ((b)localObject1).aeS();
        String str = this.kGt;
        long l = this.yjD;
        Object localObject2 = this.kGt;
        j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
        boolean bool = bt.kU((String)localObject2, j.b.dta());
        localObject2 = com.tencent.mm.plugin.story.i.a.yor;
        ((q)localObject1).b((com.tencent.mm.al.n)new i(str, l, bool, "", com.tencent.mm.plugin.story.i.a.dKk()));
      }
    }
    AppMethodBeat.o(119333);
  }
  
  public final void dGy()
  {
    AppMethodBeat.i(119334);
    if (!this.isRunning)
    {
      this.isRunning = true;
      ad.i(TAG, "loadFpData username=" + this.kGt + " maxId=" + this.yjD);
      Object localObject1 = com.tencent.mm.kernel.g.afA();
      d.g.b.k.g(localObject1, "MMKernel.network()");
      localObject1 = ((b)localObject1).aeS();
      String str = this.kGt;
      Object localObject2 = this.kGt;
      j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
      boolean bool = bt.kU((String)localObject2, j.b.dta());
      localObject2 = com.tencent.mm.plugin.story.i.a.yor;
      ((q)localObject1).b((com.tencent.mm.al.n)new i(str, 0L, bool, "", com.tencent.mm.plugin.story.i.a.dKk()));
    }
    AppMethodBeat.o(119334);
  }
  
  public final void dGz()
  {
    AppMethodBeat.i(119335);
    j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dhI().post((Runnable)new b(this));
    AppMethodBeat.o(119335);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119330);
    d.g.b.k.h(paramString, "userName");
    this.kGt = paramString;
    tI(this.yjE);
    paramString = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(paramString, "MMKernel.network()");
    paramString.aeS().a(273, (com.tencent.mm.al.g)this);
    paramString = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(paramString, "MMKernel.network()");
    paramString.aeS().a(764, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(119330);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(119336);
    int i;
    if ((paramn instanceof i))
    {
      i = ((i)paramn).dep;
      paramString = com.tencent.mm.plugin.story.i.a.yor;
      if (i == com.tencent.mm.plugin.story.i.a.dKk())
      {
        this.isRunning = false;
        long l = ((i)paramn).wGn;
        paramString = com.tencent.mm.plugin.story.i.a.yor;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.dJQ())
        {
          paramString = com.tencent.mm.plugin.story.i.a.yor;
          if ((paramInt2 != com.tencent.mm.plugin.story.i.a.dJR()) && ((paramInt1 != 0) || (paramInt2 != 0) || (l != 0L)))
          {
            paramString = com.tencent.mm.plugin.story.i.a.yor;
            if ((paramInt2 != com.tencent.mm.plugin.story.i.a.dJP()) || (l != 0L)) {
              break label263;
            }
          }
        }
        boolean bool = true;
        this.nGq = bool;
        this.ylx.qE(this.nGq);
        this.yjD = ((i)paramn).wGn;
        if (((i)paramn).wES)
        {
          paramString = com.tencent.mm.plugin.story.f.j.yfh;
          j.b.dhI().post((Runnable)new c(this));
        }
        for (;;)
        {
          ad.d(TAG, "onSceneEnd username=" + this.kGt + " respMaxId=" + this.yjD + ' ' + paramInt1 + ' ' + paramInt2 + " isAll:" + this.nGq + " limitId:" + this.yjD);
          AppMethodBeat.o(119336);
          return;
          label263:
          bool = false;
          break;
          paramString = com.tencent.mm.plugin.story.f.j.yfh;
          j.b.dhI().post((Runnable)new d(this));
        }
      }
    }
    int j;
    if ((paramn instanceof f))
    {
      paramString = ((f)paramn).dHQ();
      if (paramString != null) {
        if (((paramString instanceof com.tencent.mm.plugin.story.f.a.k)) && (paramInt2 == 0))
        {
          paramn = (Iterable)((f)paramn).ygs;
          j = 0;
          paramn = paramn.iterator();
          i = 0;
          if (paramn.hasNext())
          {
            Object localObject = paramn.next();
            if (j < 0) {
              d.a.j.fvx();
            }
            int k = ((Number)localObject).intValue();
            ad.i(TAG, "onSceneEnd update story favorite: errType " + paramInt1 + ", errcode " + paramInt2 + ", localId " + k + ", favorite:" + ((com.tencent.mm.plugin.story.f.a.k)paramString).ygF);
            localObject = com.tencent.mm.plugin.story.f.n.yfw;
            n.a.hF(k, ((com.tencent.mm.plugin.story.f.a.k)paramString).ygF);
            if (((com.tencent.mm.plugin.story.f.a.k)paramString).ygF != 1) {
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
        this.ylw = 1;
        this.yjE = 0L;
        this.yjF = 0L;
        tI(this.yjE);
        dGy();
        dGz();
        AppMethodBeat.o(119336);
        return;
      }
      dGz();
      AppMethodBeat.o(119336);
      return;
      AppMethodBeat.o(119336);
      return;
    }
  }
  
  public final void tI(long paramLong)
  {
    AppMethodBeat.i(119331);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
    localObject1 = j.b.dHd();
    String str = this.kGt;
    Object localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
    boolean bool = bt.kU(j.b.dta(), this.kGt);
    localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dHm();
    localObject2 = com.tencent.mm.plugin.story.i.a.yor;
    this.yjF = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramLong, str, bool, com.tencent.mm.plugin.story.i.a.dJK());
    ad.d(TAG, "localMinId=" + this.yjF + ", respMaxId=" + this.yjD);
    AppMethodBeat.o(119331);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119327);
      final ArrayList localArrayList = new ArrayList();
      final v.e locale = new v.e();
      Object localObject = com.tencent.mm.plugin.story.f.j.yfh;
      localObject = j.b.dHd();
      String str1 = k.a(this.ylz);
      String str2 = k.a(this.ylz);
      j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
      locale.Jhw = com.tencent.mm.plugin.story.i.k.a((com.tencent.mm.plugin.story.i.k)localObject, str1, bt.kU(str2, j.b.dta()), k.b(this.ylz));
      int i;
      if (!((Collection)locale.Jhw).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label222;
        }
        k.a(this.ylz, ((com.tencent.mm.plugin.story.i.j)d.a.j.iA((List)locale.Jhw)).field_storyID);
      }
      for (;;)
      {
        localObject = k.yly;
        ad.d(k.access$getTAG$cp(), "localCachedMinId=" + k.c(this.ylz) + " infos.size=" + ((List)locale.Jhw).size() + " localMinId=" + k.b(this.ylz));
        c.g((d.g.a.a)new d.g.b.l(locale) {});
        AppMethodBeat.o(119327);
        return;
        i = 0;
        break;
        label222:
        localObject = com.tencent.mm.plugin.story.f.j.yfh;
        localObject = j.b.dHd();
        str1 = k.a(this.ylz);
        str2 = k.a(this.ylz);
        localb = com.tencent.mm.plugin.story.f.j.yfh;
        localArrayList.addAll((Collection)((com.tencent.mm.plugin.story.i.k)localObject).bM(str1, bt.kU(str2, j.b.dta())));
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119328);
      this.ylz.tI(k.c(this.ylz));
      this.ylz.dGz();
      if (k.d(this.ylz) > 0) {
        this.ylz.dGx();
      }
      AppMethodBeat.o(119328);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119329);
      this.ylz.tI(k.c(this.ylz));
      this.ylz.dGz();
      if (k.d(this.ylz) > 0) {
        this.ylz.dGx();
      }
      AppMethodBeat.o(119329);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.k
 * JD-Core Version:    0.7.0.1
 */