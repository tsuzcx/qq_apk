package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.d.a.a;
import com.tencent.mm.plugin.story.d.a.b;
import com.tencent.mm.plugin.story.f.a.i;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;)V", "isRunning", "", "loadNpCount", "", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "isAll", "errType", "errCode", "limitId", "loadFavStoryFromDB", "", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reloadFp", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class k
  implements com.tencent.mm.al.f, a.a
{
  public static final k.a AQw;
  private static final String TAG = "MicroMsg.StoryFavAlbumPresenter";
  private long AOA;
  private long AOy;
  private long AOz;
  private int AQu;
  final a.b AQv;
  private boolean isRunning;
  private String lEN;
  private boolean oMN;
  
  static
  {
    AppMethodBeat.i(119338);
    AQw = new k.a((byte)0);
    TAG = "MicroMsg.StoryFavAlbumPresenter";
    AppMethodBeat.o(119338);
  }
  
  public k(a.b paramb)
  {
    AppMethodBeat.i(119337);
    this.AQv = paramb;
    this.lEN = "";
    this.AQu = 1;
    AppMethodBeat.o(119337);
  }
  
  public final void AJ(long paramLong)
  {
    AppMethodBeat.i(119331);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
    localObject1 = j.b.ehT();
    String str = this.lEN;
    Object localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
    boolean bool = bt.lQ(j.b.dTJ(), this.lEN);
    localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.eic();
    localObject2 = com.tencent.mm.plugin.story.i.a.ATp;
    this.AOA = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramLong, str, bool, com.tencent.mm.plugin.story.i.a.ekA());
    ad.d(TAG, "localMinId=" + this.AOA + ", respMaxId=" + this.AOy);
    AppMethodBeat.o(119331);
  }
  
  public final void ebV()
  {
    AppMethodBeat.i(119332);
    b localb = g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b(273, (com.tencent.mm.al.f)this);
    localb = g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b(764, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(119332);
  }
  
  public final void ehn()
  {
    AppMethodBeat.i(119333);
    if (!this.isRunning)
    {
      this.AQu -= 1;
      ad.i(TAG, "loadNpData username=" + this.lEN + " maxId=" + this.AOy);
      if (!this.oMN)
      {
        this.isRunning = true;
        Object localObject1 = g.ajB();
        p.g(localObject1, "MMKernel.network()");
        localObject1 = ((b)localObject1).aiU();
        String str = this.lEN;
        long l = this.AOy;
        Object localObject2 = this.lEN;
        j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
        boolean bool = bt.lQ((String)localObject2, j.b.dTJ());
        localObject2 = com.tencent.mm.plugin.story.i.a.ATp;
        ((com.tencent.mm.al.q)localObject1).b((com.tencent.mm.al.n)new i(str, l, bool, "", com.tencent.mm.plugin.story.i.a.ela()));
      }
    }
    AppMethodBeat.o(119333);
  }
  
  public final void eho()
  {
    AppMethodBeat.i(119334);
    if (!this.isRunning)
    {
      this.isRunning = true;
      ad.i(TAG, "loadFpData username=" + this.lEN + " maxId=" + this.AOy);
      Object localObject1 = g.ajB();
      p.g(localObject1, "MMKernel.network()");
      localObject1 = ((b)localObject1).aiU();
      String str = this.lEN;
      Object localObject2 = this.lEN;
      j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
      boolean bool = bt.lQ((String)localObject2, j.b.dTJ());
      localObject2 = com.tencent.mm.plugin.story.i.a.ATp;
      ((com.tencent.mm.al.q)localObject1).b((com.tencent.mm.al.n)new i(str, 0L, bool, "", com.tencent.mm.plugin.story.i.a.ela()));
    }
    AppMethodBeat.o(119334);
  }
  
  public final void ehp()
  {
    AppMethodBeat.i(119335);
    j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.dFL().post((Runnable)new b(this));
    AppMethodBeat.o(119335);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119330);
    p.h(paramString, "userName");
    this.lEN = paramString;
    AJ(this.AOz);
    paramString = g.ajB();
    p.g(paramString, "MMKernel.network()");
    paramString.aiU().a(273, (com.tencent.mm.al.f)this);
    paramString = g.ajB();
    p.g(paramString, "MMKernel.network()");
    paramString.aiU().a(764, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(119330);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(119336);
    int i;
    if ((paramn instanceof i))
    {
      i = ((i)paramn).dnh;
      paramString = com.tencent.mm.plugin.story.i.a.ATp;
      if (i == com.tencent.mm.plugin.story.i.a.ela())
      {
        this.isRunning = false;
        long l = ((i)paramn).ziB;
        paramString = com.tencent.mm.plugin.story.i.a.ATp;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.ekG())
        {
          paramString = com.tencent.mm.plugin.story.i.a.ATp;
          if ((paramInt2 != com.tencent.mm.plugin.story.i.a.ekH()) && ((paramInt1 != 0) || (paramInt2 != 0) || (l != 0L)))
          {
            paramString = com.tencent.mm.plugin.story.i.a.ATp;
            if ((paramInt2 != com.tencent.mm.plugin.story.i.a.ekF()) || (l != 0L)) {
              break label263;
            }
          }
        }
        boolean bool = true;
        this.oMN = bool;
        this.AQv.si(this.oMN);
        this.AOy = ((i)paramn).ziB;
        if (((i)paramn).zhh)
        {
          paramString = com.tencent.mm.plugin.story.f.j.AKb;
          j.b.dFL().post((Runnable)new c(this));
        }
        for (;;)
        {
          ad.d(TAG, "onSceneEnd username=" + this.lEN + " respMaxId=" + this.AOy + ' ' + paramInt1 + ' ' + paramInt2 + " isAll:" + this.oMN + " limitId:" + this.AOy);
          AppMethodBeat.o(119336);
          return;
          label263:
          bool = false;
          break;
          paramString = com.tencent.mm.plugin.story.f.j.AKb;
          j.b.dFL().post((Runnable)new d(this));
        }
      }
    }
    int j;
    if ((paramn instanceof com.tencent.mm.plugin.story.f.a.f))
    {
      paramString = ((com.tencent.mm.plugin.story.f.a.f)paramn).eiG();
      if (paramString != null) {
        if (((paramString instanceof com.tencent.mm.plugin.story.f.a.k)) && (paramInt2 == 0))
        {
          paramn = (Iterable)((com.tencent.mm.plugin.story.f.a.f)paramn).ALm;
          j = 0;
          paramn = paramn.iterator();
          i = 0;
          if (paramn.hasNext())
          {
            Object localObject = paramn.next();
            if (j < 0) {
              d.a.j.gfB();
            }
            int k = ((Number)localObject).intValue();
            ad.i(TAG, "onSceneEnd update story favorite: errType " + paramInt1 + ", errcode " + paramInt2 + ", localId " + k + ", favorite:" + ((com.tencent.mm.plugin.story.f.a.k)paramString).ALz);
            localObject = com.tencent.mm.plugin.story.f.n.AKq;
            n.a.jdMethod_if(k, ((com.tencent.mm.plugin.story.f.a.k)paramString).ALz);
            if (((com.tencent.mm.plugin.story.f.a.k)paramString).ALz != 1) {
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
        this.AQu = 1;
        this.AOz = 0L;
        this.AOA = 0L;
        AJ(this.AOz);
        eho();
        ehp();
        AppMethodBeat.o(119336);
        return;
      }
      ehp();
      AppMethodBeat.o(119336);
      return;
      AppMethodBeat.o(119336);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119327);
      final ArrayList localArrayList = new ArrayList();
      final y.f localf = new y.f();
      Object localObject = com.tencent.mm.plugin.story.f.j.AKb;
      localObject = j.b.ehT();
      String str1 = k.a(this.AQx);
      String str2 = k.a(this.AQx);
      j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
      localf.MLV = com.tencent.mm.plugin.story.i.k.a((com.tencent.mm.plugin.story.i.k)localObject, str1, bt.lQ(str2, j.b.dTJ()), k.b(this.AQx));
      int i;
      if (!((Collection)localf.MLV).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label222;
        }
        k.a(this.AQx, ((com.tencent.mm.plugin.story.i.j)d.a.j.je((List)localf.MLV)).field_storyID);
      }
      for (;;)
      {
        localObject = k.AQw;
        ad.d(k.access$getTAG$cp(), "localCachedMinId=" + k.c(this.AQx) + " infos.size=" + ((List)localf.MLV).size() + " localMinId=" + k.b(this.AQx));
        c.g((d.g.a.a)new d.g.b.q(localf) {});
        AppMethodBeat.o(119327);
        return;
        i = 0;
        break;
        label222:
        localObject = com.tencent.mm.plugin.story.f.j.AKb;
        localObject = j.b.ehT();
        str1 = k.a(this.AQx);
        str2 = k.a(this.AQx);
        localb = com.tencent.mm.plugin.story.f.j.AKb;
        localArrayList.addAll((Collection)((com.tencent.mm.plugin.story.i.k)localObject).ca(str1, bt.lQ(str2, j.b.dTJ())));
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119328);
      this.AQx.AJ(k.c(this.AQx));
      this.AQx.ehp();
      if (k.d(this.AQx) > 0) {
        this.AQx.ehn();
      }
      AppMethodBeat.o(119328);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119329);
      this.AQx.AJ(k.c(this.AQx));
      this.AQx.ehp();
      if (k.d(this.AQx) > 0) {
        this.AQx.ehn();
      }
      AppMethodBeat.o(119329);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.k
 * JD-Core Version:    0.7.0.1
 */