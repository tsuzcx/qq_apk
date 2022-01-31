package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.story.d.a.a;
import com.tencent.mm.plugin.story.d.a.b;
import com.tencent.mm.plugin.story.h.a;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.plugin.story.model.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;)V", "isRunning", "", "loadNpCount", "", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "isAll", "errType", "errCode", "limitId", "loadFavStoryFromDB", "", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reloadFp", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class l
  implements f, a.a
{
  private static final String TAG = "MicroMsg.StoryFavAlbumPresenter";
  public static final l.a sCA;
  private String ikj;
  private boolean isRunning;
  private long sAr;
  private long sAs;
  private long sAt;
  private int sCy;
  final a.b sCz;
  private boolean sek;
  
  static
  {
    AppMethodBeat.i(138829);
    sCA = new l.a((byte)0);
    TAG = "MicroMsg.StoryFavAlbumPresenter";
    AppMethodBeat.o(138829);
  }
  
  public l(a.b paramb)
  {
    AppMethodBeat.i(138828);
    this.sCz = paramb;
    this.ikj = "";
    this.sCy = 1;
    AppMethodBeat.o(138828);
  }
  
  public final void bOo()
  {
    AppMethodBeat.i(138823);
    b localb = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(localb, "MMKernel.network()");
    localb.Rc().b(273, (f)this);
    localb = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(localb, "MMKernel.network()");
    localb.Rc().b(764, (f)this);
    AppMethodBeat.o(138823);
  }
  
  public final void czH()
  {
    AppMethodBeat.i(138824);
    if (!this.isRunning)
    {
      this.sCy -= 1;
      ab.i(TAG, "loadNpData username=" + this.ikj + " maxId=" + this.sAr);
      if (!this.sek)
      {
        this.isRunning = true;
        Object localObject1 = com.tencent.mm.kernel.g.RK();
        a.f.b.j.p(localObject1, "MMKernel.network()");
        localObject1 = ((b)localObject1).Rc();
        String str = this.ikj;
        long l = this.sAr;
        Object localObject2 = this.ikj;
        j.b localb = com.tencent.mm.plugin.story.model.j.svi;
        boolean bool = bo.isEqual((String)localObject2, j.b.coK());
        localObject2 = a.sFV;
        ((p)localObject1).b((m)new com.tencent.mm.plugin.story.model.a.j(str, l, bool, "", a.cEv()));
      }
    }
    AppMethodBeat.o(138824);
  }
  
  public final void czI()
  {
    AppMethodBeat.i(138825);
    if (!this.isRunning)
    {
      this.isRunning = true;
      ab.i(TAG, "loadFpData username=" + this.ikj + " maxId=" + this.sAr);
      Object localObject1 = com.tencent.mm.kernel.g.RK();
      a.f.b.j.p(localObject1, "MMKernel.network()");
      localObject1 = ((b)localObject1).Rc();
      String str = this.ikj;
      Object localObject2 = this.ikj;
      j.b localb = com.tencent.mm.plugin.story.model.j.svi;
      boolean bool = bo.isEqual((String)localObject2, j.b.coK());
      localObject2 = a.sFV;
      ((p)localObject1).b((m)new com.tencent.mm.plugin.story.model.a.j(str, 0L, bool, "", a.cEv()));
    }
    AppMethodBeat.o(138825);
  }
  
  public final void czJ()
  {
    AppMethodBeat.i(138826);
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.coO().post((Runnable)new l.b(this));
    AppMethodBeat.o(138826);
  }
  
  public final void mB(long paramLong)
  {
    AppMethodBeat.i(138822);
    Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    localObject1 = j.b.cAB();
    String str = this.ikj;
    Object localObject2 = com.tencent.mm.plugin.story.model.j.svi;
    boolean bool = bo.isEqual(j.b.coK(), this.ikj);
    localObject2 = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAL();
    localObject2 = a.sFV;
    this.sAt = ((k)localObject1).a(paramLong, str, bool, a.cDR());
    ab.d(TAG, "localMinId=" + this.sAt + ", respMaxId=" + this.sAr);
    AppMethodBeat.o(138822);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(138821);
    a.f.b.j.q(paramString, "userName");
    this.ikj = paramString;
    mB(this.sAs);
    paramString = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(paramString, "MMKernel.network()");
    paramString.Rc().a(273, (f)this);
    paramString = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(paramString, "MMKernel.network()");
    paramString.Rc().a(764, (f)this);
    AppMethodBeat.o(138821);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(138827);
    int i;
    if ((paramm instanceof com.tencent.mm.plugin.story.model.a.j))
    {
      i = ((com.tencent.mm.plugin.story.model.a.j)paramm).cpt;
      paramString = a.sFV;
      if (i == a.cEv())
      {
        this.isRunning = false;
        long l = ((com.tencent.mm.plugin.story.model.a.j)paramm).rfK;
        paramString = a.sFV;
        if (paramInt2 != a.cDX())
        {
          paramString = a.sFV;
          if ((paramInt2 != a.cDY()) && ((paramInt1 != 0) || (paramInt2 != 0) || (l != 0L)))
          {
            paramString = a.sFV;
            if ((paramInt2 != a.cDW()) || (l != 0L)) {
              break label263;
            }
          }
        }
        boolean bool = true;
        this.sek = bool;
        this.sCz.lu(this.sek);
        this.sAr = ((com.tencent.mm.plugin.story.model.a.j)paramm).rfK;
        if (((com.tencent.mm.plugin.story.model.a.j)paramm).rew)
        {
          paramString = com.tencent.mm.plugin.story.model.j.svi;
          j.b.coO().post((Runnable)new l.c(this));
        }
        for (;;)
        {
          ab.d(TAG, "onSceneEnd username=" + this.ikj + " respMaxId=" + this.sAr + ' ' + paramInt1 + ' ' + paramInt2 + " isAll:" + this.sek + " limitId:" + this.sAr);
          AppMethodBeat.o(138827);
          return;
          label263:
          bool = false;
          break;
          paramString = com.tencent.mm.plugin.story.model.j.svi;
          j.b.coO().post((Runnable)new l.d(this));
        }
      }
    }
    int j;
    if ((paramm instanceof com.tencent.mm.plugin.story.model.a.g))
    {
      paramString = ((com.tencent.mm.plugin.story.model.a.g)paramm).cBG();
      if (paramString != null) {
        if (((paramString instanceof com.tencent.mm.plugin.story.model.a.l)) && (paramInt2 == 0))
        {
          paramm = (Iterable)((com.tencent.mm.plugin.story.model.a.g)paramm).sxi;
          j = 0;
          paramm = paramm.iterator();
          i = 0;
          if (paramm.hasNext())
          {
            Object localObject = paramm.next();
            if (j < 0) {
              a.a.j.eaS();
            }
            int k = ((Number)localObject).intValue();
            ab.i(TAG, "onSceneEnd update story favorite: errType " + paramInt1 + ", errcode " + paramInt2 + ", localId " + k + ", favorite:" + ((com.tencent.mm.plugin.story.model.a.l)paramString).sxv);
            localObject = n.svx;
            n.a.fZ(k, ((com.tencent.mm.plugin.story.model.a.l)paramString).sxv);
            if (((com.tencent.mm.plugin.story.model.a.l)paramString).sxv != 1) {
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
        this.sCy = 1;
        this.sAs = 0L;
        this.sAt = 0L;
        mB(this.sAs);
        czI();
        czJ();
        AppMethodBeat.o(138827);
        return;
      }
      czJ();
      AppMethodBeat.o(138827);
      return;
      AppMethodBeat.o(138827);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.l
 * JD-Core Version:    0.7.0.1
 */