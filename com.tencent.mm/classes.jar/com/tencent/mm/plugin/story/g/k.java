package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.d.a.a;
import com.tencent.mm.plugin.story.d.a.b;
import com.tencent.mm.plugin.story.f.a.i;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;)V", "isRunning", "", "loadNpCount", "", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "isAll", "errType", "errCode", "limitId", "loadFavStoryFromDB", "", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reloadFp", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class k
  implements com.tencent.mm.ak.f, a.a
{
  public static final k.a BhU;
  private static final String TAG = "MicroMsg.StoryFavAlbumPresenter";
  private long BfZ;
  private long Bga;
  private long Bgb;
  private int BhS;
  final a.b BhT;
  private boolean isRunning;
  private String lJm;
  private boolean oTp;
  
  static
  {
    AppMethodBeat.i(119338);
    BhU = new k.a((byte)0);
    TAG = "MicroMsg.StoryFavAlbumPresenter";
    AppMethodBeat.o(119338);
  }
  
  public k(a.b paramb)
  {
    AppMethodBeat.i(119337);
    this.BhT = paramb;
    this.lJm = "";
    this.BhS = 1;
    AppMethodBeat.o(119337);
  }
  
  public final void Bh(long paramLong)
  {
    AppMethodBeat.i(119331);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
    localObject1 = j.b.elB();
    String str = this.lJm;
    Object localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
    boolean bool = bu.lX(j.b.dXj(), this.lJm);
    localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.elK();
    localObject2 = com.tencent.mm.plugin.story.i.a.BkN;
    this.Bgb = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramLong, str, bool, com.tencent.mm.plugin.story.i.a.eoj());
    ae.d(TAG, "localMinId=" + this.Bgb + ", respMaxId=" + this.BfZ);
    AppMethodBeat.o(119331);
  }
  
  public final void efC()
  {
    AppMethodBeat.i(119332);
    b localb = g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().b(273, (com.tencent.mm.ak.f)this);
    localb = g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().b(764, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(119332);
  }
  
  public final void ekV()
  {
    AppMethodBeat.i(119333);
    if (!this.isRunning)
    {
      this.BhS -= 1;
      ae.i(TAG, "loadNpData username=" + this.lJm + " maxId=" + this.BfZ);
      if (!this.oTp)
      {
        this.isRunning = true;
        Object localObject1 = g.ajQ();
        p.g(localObject1, "MMKernel.network()");
        localObject1 = ((b)localObject1).ajj();
        String str = this.lJm;
        long l = this.BfZ;
        Object localObject2 = this.lJm;
        j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
        boolean bool = bu.lX((String)localObject2, j.b.dXj());
        localObject2 = com.tencent.mm.plugin.story.i.a.BkN;
        ((com.tencent.mm.ak.q)localObject1).b((com.tencent.mm.ak.n)new i(str, l, bool, "", com.tencent.mm.plugin.story.i.a.eoJ()));
      }
    }
    AppMethodBeat.o(119333);
  }
  
  public final void ekW()
  {
    AppMethodBeat.i(119334);
    if (!this.isRunning)
    {
      this.isRunning = true;
      ae.i(TAG, "loadFpData username=" + this.lJm + " maxId=" + this.BfZ);
      Object localObject1 = g.ajQ();
      p.g(localObject1, "MMKernel.network()");
      localObject1 = ((b)localObject1).ajj();
      String str = this.lJm;
      Object localObject2 = this.lJm;
      j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
      boolean bool = bu.lX((String)localObject2, j.b.dXj());
      localObject2 = com.tencent.mm.plugin.story.i.a.BkN;
      ((com.tencent.mm.ak.q)localObject1).b((com.tencent.mm.ak.n)new i(str, 0L, bool, "", com.tencent.mm.plugin.story.i.a.eoJ()));
    }
    AppMethodBeat.o(119334);
  }
  
  public final void ekX()
  {
    AppMethodBeat.i(119335);
    j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.dJc().post((Runnable)new b(this));
    AppMethodBeat.o(119335);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119330);
    p.h(paramString, "userName");
    this.lJm = paramString;
    Bh(this.Bga);
    paramString = g.ajQ();
    p.g(paramString, "MMKernel.network()");
    paramString.ajj().a(273, (com.tencent.mm.ak.f)this);
    paramString = g.ajQ();
    p.g(paramString, "MMKernel.network()");
    paramString.ajj().a(764, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(119330);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(119336);
    int i;
    if ((paramn instanceof i))
    {
      i = ((i)paramn).doj;
      paramString = com.tencent.mm.plugin.story.i.a.BkN;
      if (i == com.tencent.mm.plugin.story.i.a.eoJ())
      {
        this.isRunning = false;
        long l = ((i)paramn).zzQ;
        paramString = com.tencent.mm.plugin.story.i.a.BkN;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.eop())
        {
          paramString = com.tencent.mm.plugin.story.i.a.BkN;
          if ((paramInt2 != com.tencent.mm.plugin.story.i.a.eoq()) && ((paramInt1 != 0) || (paramInt2 != 0) || (l != 0L)))
          {
            paramString = com.tencent.mm.plugin.story.i.a.BkN;
            if ((paramInt2 != com.tencent.mm.plugin.story.i.a.eoo()) || (l != 0L)) {
              break label263;
            }
          }
        }
        boolean bool = true;
        this.oTp = bool;
        this.BhT.sp(this.oTp);
        this.BfZ = ((i)paramn).zzQ;
        if (((i)paramn).zxW)
        {
          paramString = com.tencent.mm.plugin.story.f.j.BbE;
          j.b.dJc().post((Runnable)new c(this));
        }
        for (;;)
        {
          ae.d(TAG, "onSceneEnd username=" + this.lJm + " respMaxId=" + this.BfZ + ' ' + paramInt1 + ' ' + paramInt2 + " isAll:" + this.oTp + " limitId:" + this.BfZ);
          AppMethodBeat.o(119336);
          return;
          label263:
          bool = false;
          break;
          paramString = com.tencent.mm.plugin.story.f.j.BbE;
          j.b.dJc().post((Runnable)new d(this));
        }
      }
    }
    int j;
    if ((paramn instanceof com.tencent.mm.plugin.story.f.a.f))
    {
      paramString = ((com.tencent.mm.plugin.story.f.a.f)paramn).emo();
      if (paramString != null) {
        if (((paramString instanceof com.tencent.mm.plugin.story.f.a.k)) && (paramInt2 == 0))
        {
          paramn = (Iterable)((com.tencent.mm.plugin.story.f.a.f)paramn).BcP;
          j = 0;
          paramn = paramn.iterator();
          i = 0;
          if (paramn.hasNext())
          {
            Object localObject = paramn.next();
            if (j < 0) {
              d.a.j.gkd();
            }
            int k = ((Number)localObject).intValue();
            ae.i(TAG, "onSceneEnd update story favorite: errType " + paramInt1 + ", errcode " + paramInt2 + ", localId " + k + ", favorite:" + ((com.tencent.mm.plugin.story.f.a.k)paramString).Bdc);
            localObject = com.tencent.mm.plugin.story.f.n.BbT;
            n.a.ii(k, ((com.tencent.mm.plugin.story.f.a.k)paramString).Bdc);
            if (((com.tencent.mm.plugin.story.f.a.k)paramString).Bdc != 1) {
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
        this.BhS = 1;
        this.Bga = 0L;
        this.Bgb = 0L;
        Bh(this.Bga);
        ekW();
        ekX();
        AppMethodBeat.o(119336);
        return;
      }
      ekX();
      AppMethodBeat.o(119336);
      return;
      AppMethodBeat.o(119336);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119327);
      final ArrayList localArrayList = new ArrayList();
      final y.f localf = new y.f();
      Object localObject = com.tencent.mm.plugin.story.f.j.BbE;
      localObject = j.b.elB();
      String str1 = k.a(this.BhV);
      String str2 = k.a(this.BhV);
      j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
      localf.NiY = com.tencent.mm.plugin.story.i.k.a((com.tencent.mm.plugin.story.i.k)localObject, str1, bu.lX(str2, j.b.dXj()), k.b(this.BhV));
      int i;
      if (!((Collection)localf.NiY).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label222;
        }
        k.a(this.BhV, ((com.tencent.mm.plugin.story.i.j)d.a.j.jn((List)localf.NiY)).field_storyID);
      }
      for (;;)
      {
        localObject = k.BhU;
        ae.d(k.access$getTAG$cp(), "localCachedMinId=" + k.c(this.BhV) + " infos.size=" + ((List)localf.NiY).size() + " localMinId=" + k.b(this.BhV));
        c.h((d.g.a.a)new d.g.b.q(localf) {});
        AppMethodBeat.o(119327);
        return;
        i = 0;
        break;
        label222:
        localObject = com.tencent.mm.plugin.story.f.j.BbE;
        localObject = j.b.elB();
        str1 = k.a(this.BhV);
        str2 = k.a(this.BhV);
        localb = com.tencent.mm.plugin.story.f.j.BbE;
        localArrayList.addAll((Collection)((com.tencent.mm.plugin.story.i.k)localObject).ce(str1, bu.lX(str2, j.b.dXj())));
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119328);
      this.BhV.Bh(k.c(this.BhV));
      this.BhV.ekX();
      if (k.d(this.BhV) > 0) {
        this.BhV.ekV();
      }
      AppMethodBeat.o(119328);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119329);
      this.BhV.Bh(k.c(this.BhV));
      this.BhV.ekX();
      if (k.d(this.BhV) > 0) {
        this.BhV.ekV();
      }
      AppMethodBeat.o(119329);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.k
 * JD-Core Version:    0.7.0.1
 */