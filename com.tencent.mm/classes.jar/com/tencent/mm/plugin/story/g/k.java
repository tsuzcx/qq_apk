package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.story.d.a.a;
import com.tencent.mm.plugin.story.d.a.b;
import com.tencent.mm.plugin.story.f.a.f;
import com.tencent.mm.plugin.story.f.a.i;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.v.f;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;)V", "isRunning", "", "loadNpCount", "", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "isAll", "errType", "errCode", "limitId", "loadFavStoryFromDB", "", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reloadFp", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class k
  implements com.tencent.mm.ak.g, a.a
{
  private static final String TAG = "MicroMsg.StoryFavAlbumPresenter";
  public static final k.a zyx;
  private boolean isRunning;
  private String lhM;
  private boolean ojr;
  private long zwC;
  private long zwD;
  private long zwE;
  private int zyv;
  final a.b zyw;
  
  static
  {
    AppMethodBeat.i(119338);
    zyx = new k.a((byte)0);
    TAG = "MicroMsg.StoryFavAlbumPresenter";
    AppMethodBeat.o(119338);
  }
  
  public k(a.b paramb)
  {
    AppMethodBeat.i(119337);
    this.zyw = paramb;
    this.lhM = "";
    this.zyv = 1;
    AppMethodBeat.o(119337);
  }
  
  public final void dPE()
  {
    AppMethodBeat.i(119332);
    b localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().b(273, (com.tencent.mm.ak.g)this);
    localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().b(764, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(119332);
  }
  
  public final void dUY()
  {
    AppMethodBeat.i(119333);
    if (!this.isRunning)
    {
      this.zyv -= 1;
      ac.i(TAG, "loadNpData username=" + this.lhM + " maxId=" + this.zwC);
      if (!this.ojr)
      {
        this.isRunning = true;
        Object localObject1 = com.tencent.mm.kernel.g.agQ();
        d.g.b.k.g(localObject1, "MMKernel.network()");
        localObject1 = ((b)localObject1).agi();
        String str = this.lhM;
        long l = this.zwC;
        Object localObject2 = this.lhM;
        j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
        boolean bool = bs.lr((String)localObject2, j.b.dHx());
        localObject2 = com.tencent.mm.plugin.story.i.a.zBQ;
        ((q)localObject1).b((com.tencent.mm.ak.n)new i(str, l, bool, "", com.tencent.mm.plugin.story.i.a.dYL()));
      }
    }
    AppMethodBeat.o(119333);
  }
  
  public final void dUZ()
  {
    AppMethodBeat.i(119334);
    if (!this.isRunning)
    {
      this.isRunning = true;
      ac.i(TAG, "loadFpData username=" + this.lhM + " maxId=" + this.zwC);
      Object localObject1 = com.tencent.mm.kernel.g.agQ();
      d.g.b.k.g(localObject1, "MMKernel.network()");
      localObject1 = ((b)localObject1).agi();
      String str = this.lhM;
      Object localObject2 = this.lhM;
      j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
      boolean bool = bs.lr((String)localObject2, j.b.dHx());
      localObject2 = com.tencent.mm.plugin.story.i.a.zBQ;
      ((q)localObject1).b((com.tencent.mm.ak.n)new i(str, 0L, bool, "", com.tencent.mm.plugin.story.i.a.dYL()));
    }
    AppMethodBeat.o(119334);
  }
  
  public final void dVa()
  {
    AppMethodBeat.i(119335);
    j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dvq().post((Runnable)new b(this));
    AppMethodBeat.o(119335);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119330);
    d.g.b.k.h(paramString, "userName");
    this.lhM = paramString;
    yl(this.zwD);
    paramString = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(paramString, "MMKernel.network()");
    paramString.agi().a(273, (com.tencent.mm.ak.g)this);
    paramString = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(paramString, "MMKernel.network()");
    paramString.agi().a(764, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(119330);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(119336);
    int i;
    if ((paramn instanceof i))
    {
      i = ((i)paramn).dbL;
      paramString = com.tencent.mm.plugin.story.i.a.zBQ;
      if (i == com.tencent.mm.plugin.story.i.a.dYL())
      {
        this.isRunning = false;
        long l = ((i)paramn).xSH;
        paramString = com.tencent.mm.plugin.story.i.a.zBQ;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.dYr())
        {
          paramString = com.tencent.mm.plugin.story.i.a.zBQ;
          if ((paramInt2 != com.tencent.mm.plugin.story.i.a.dYs()) && ((paramInt1 != 0) || (paramInt2 != 0) || (l != 0L)))
          {
            paramString = com.tencent.mm.plugin.story.i.a.zBQ;
            if ((paramInt2 != com.tencent.mm.plugin.story.i.a.dYq()) || (l != 0L)) {
              break label263;
            }
          }
        }
        boolean bool = true;
        this.ojr = bool;
        this.zyw.rC(this.ojr);
        this.zwC = ((i)paramn).xSH;
        if (((i)paramn).xRn)
        {
          paramString = com.tencent.mm.plugin.story.f.j.zsh;
          j.b.dvq().post((Runnable)new c(this));
        }
        for (;;)
        {
          ac.d(TAG, "onSceneEnd username=" + this.lhM + " respMaxId=" + this.zwC + ' ' + paramInt1 + ' ' + paramInt2 + " isAll:" + this.ojr + " limitId:" + this.zwC);
          AppMethodBeat.o(119336);
          return;
          label263:
          bool = false;
          break;
          paramString = com.tencent.mm.plugin.story.f.j.zsh;
          j.b.dvq().post((Runnable)new d(this));
        }
      }
    }
    int j;
    if ((paramn instanceof f))
    {
      paramString = ((f)paramn).dWr();
      if (paramString != null) {
        if (((paramString instanceof com.tencent.mm.plugin.story.f.a.k)) && (paramInt2 == 0))
        {
          paramn = (Iterable)((f)paramn).zts;
          j = 0;
          paramn = paramn.iterator();
          i = 0;
          if (paramn.hasNext())
          {
            Object localObject = paramn.next();
            if (j < 0) {
              d.a.j.fOc();
            }
            int k = ((Number)localObject).intValue();
            ac.i(TAG, "onSceneEnd update story favorite: errType " + paramInt1 + ", errcode " + paramInt2 + ", localId " + k + ", favorite:" + ((com.tencent.mm.plugin.story.f.a.k)paramString).ztF);
            localObject = com.tencent.mm.plugin.story.f.n.zsw;
            n.a.hO(k, ((com.tencent.mm.plugin.story.f.a.k)paramString).ztF);
            if (((com.tencent.mm.plugin.story.f.a.k)paramString).ztF != 1) {
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
        this.zyv = 1;
        this.zwD = 0L;
        this.zwE = 0L;
        yl(this.zwD);
        dUZ();
        dVa();
        AppMethodBeat.o(119336);
        return;
      }
      dVa();
      AppMethodBeat.o(119336);
      return;
      AppMethodBeat.o(119336);
      return;
    }
  }
  
  public final void yl(long paramLong)
  {
    AppMethodBeat.i(119331);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
    localObject1 = j.b.dVE();
    String str = this.lhM;
    Object localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
    boolean bool = bs.lr(j.b.dHx(), this.lhM);
    localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dVN();
    localObject2 = com.tencent.mm.plugin.story.i.a.zBQ;
    this.zwE = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramLong, str, bool, com.tencent.mm.plugin.story.i.a.dYl());
    ac.d(TAG, "localMinId=" + this.zwE + ", respMaxId=" + this.zwC);
    AppMethodBeat.o(119331);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119327);
      final ArrayList localArrayList = new ArrayList();
      final v.f localf = new v.f();
      Object localObject = com.tencent.mm.plugin.story.f.j.zsh;
      localObject = j.b.dVE();
      String str1 = k.a(this.zyy);
      String str2 = k.a(this.zyy);
      j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
      localf.KUQ = com.tencent.mm.plugin.story.i.k.a((com.tencent.mm.plugin.story.i.k)localObject, str1, bs.lr(str2, j.b.dHx()), k.b(this.zyy));
      int i;
      if (!((Collection)localf.KUQ).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label222;
        }
        k.a(this.zyy, ((com.tencent.mm.plugin.story.i.j)d.a.j.iQ((List)localf.KUQ)).field_storyID);
      }
      for (;;)
      {
        localObject = k.zyx;
        ac.d(k.access$getTAG$cp(), "localCachedMinId=" + k.c(this.zyy) + " infos.size=" + ((List)localf.KUQ).size() + " localMinId=" + k.b(this.zyy));
        c.g((d.g.a.a)new d.g.b.l(localf) {});
        AppMethodBeat.o(119327);
        return;
        i = 0;
        break;
        label222:
        localObject = com.tencent.mm.plugin.story.f.j.zsh;
        localObject = j.b.dVE();
        str1 = k.a(this.zyy);
        str2 = k.a(this.zyy);
        localb = com.tencent.mm.plugin.story.f.j.zsh;
        localArrayList.addAll((Collection)((com.tencent.mm.plugin.story.i.k)localObject).bT(str1, bs.lr(str2, j.b.dHx())));
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119328);
      this.zyy.yl(k.c(this.zyy));
      this.zyy.dVa();
      if (k.d(this.zyy) > 0) {
        this.zyy.dUY();
      }
      AppMethodBeat.o(119328);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119329);
      this.zyy.yl(k.c(this.zyy));
      this.zyy.dVa();
      if (k.d(this.zyy) > 0) {
        this.zyy.dUY();
      }
      AppMethodBeat.o(119329);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.k
 * JD-Core Version:    0.7.0.1
 */