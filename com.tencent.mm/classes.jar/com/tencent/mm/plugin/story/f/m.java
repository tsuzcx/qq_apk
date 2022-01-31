package com.tencent.mm.plugin.story.f;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.d.a.c;
import com.tencent.mm.plugin.story.d.a.d;
import com.tencent.mm.plugin.story.h.a;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/presenter/StoryFavSelectPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;)V", "MAX_COUNT", "", "TAG", "", "isRunning", "", "loadNpCount", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "isAll", "errType", "errCode", "limitId", "loadDBData", "", "first", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setFavorite", "storyList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "updateLocalMinId", "lastId", "plugin-story_release"})
public final class m
  implements f, a.c
{
  private final int MAX_COUNT;
  final String TAG;
  String ikj;
  private boolean isRunning;
  private long sAr;
  long sAs;
  long sAt;
  final a.d sCF;
  int sCy;
  private boolean sek;
  
  public m(a.d paramd)
  {
    AppMethodBeat.i(151116);
    this.sCF = paramd;
    this.TAG = "MicroMsg.StoryFavSelectPresenter";
    this.ikj = "";
    this.MAX_COUNT = 20;
    AppMethodBeat.o(151116);
  }
  
  public final void bOo()
  {
    AppMethodBeat.i(151110);
    b localb = g.RK();
    a.f.b.j.p(localb, "MMKernel.network()");
    localb.Rc().b(273, (f)this);
    AppMethodBeat.o(151110);
  }
  
  public final void czH()
  {
    AppMethodBeat.i(151112);
    if (!this.isRunning)
    {
      this.sCy -= 1;
      ab.i(this.TAG, "loadNpData username=" + this.ikj + " maxId=" + this.sAr);
      if (!this.sek)
      {
        this.isRunning = true;
        Object localObject1 = g.RK();
        a.f.b.j.p(localObject1, "MMKernel.network()");
        localObject1 = ((b)localObject1).Rc();
        String str = this.ikj;
        long l = this.sAr;
        Object localObject2 = this.ikj;
        j.b localb = com.tencent.mm.plugin.story.model.j.svi;
        boolean bool = bo.isEqual((String)localObject2, j.b.coK());
        localObject2 = a.sFV;
        ((p)localObject1).b((com.tencent.mm.ai.m)new com.tencent.mm.plugin.story.model.a.j(str, l, bool, "", a.cEu()));
        AppMethodBeat.o(151112);
      }
    }
    else
    {
      ab.i(this.TAG, "loadNpData is running");
    }
    AppMethodBeat.o(151112);
  }
  
  public final void czI()
  {
    AppMethodBeat.i(151113);
    if (!this.isRunning)
    {
      this.isRunning = true;
      ab.i(this.TAG, "loadFpData username=" + this.ikj + " maxId=" + this.sAr);
      Object localObject1 = g.RK();
      a.f.b.j.p(localObject1, "MMKernel.network()");
      localObject1 = ((b)localObject1).Rc();
      String str = this.ikj;
      Object localObject2 = this.ikj;
      j.b localb = com.tencent.mm.plugin.story.model.j.svi;
      boolean bool = bo.isEqual((String)localObject2, j.b.coK());
      localObject2 = a.sFV;
      ((p)localObject1).b((com.tencent.mm.ai.m)new com.tencent.mm.plugin.story.model.a.j(str, 0L, bool, "", a.cEu()));
      AppMethodBeat.o(151113);
      return;
    }
    ab.i(this.TAG, "loadFpData is running");
    AppMethodBeat.o(151113);
  }
  
  public final void dB(List<com.tencent.mm.plugin.story.h.j> paramList)
  {
    AppMethodBeat.i(151115);
    a.f.b.j.q(paramList, "storyList");
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.coO().post((Runnable)new m.d(this, paramList));
    AppMethodBeat.o(151115);
  }
  
  public final void lP(boolean paramBoolean)
  {
    AppMethodBeat.i(151111);
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.coO().post((Runnable)new m.a(this, paramBoolean));
    AppMethodBeat.o(151111);
  }
  
  final void mB(long paramLong)
  {
    AppMethodBeat.i(151108);
    Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    localObject1 = j.b.cAB();
    Object localObject2 = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAL();
    a.f.b.j.q(this.ikj, "userName");
    localObject2 = a.sFV;
    int i = a.cDS();
    localObject2 = this.ikj;
    String str = this.ikj;
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    this.sAt = ((k)localObject1).b(paramLong, i, (String)localObject2, bo.isEqual(str, j.b.coK()));
    if (this.sAr != 0L) {
      if (this.sAt >= this.sAr) {
        break label157;
      }
    }
    label157:
    for (paramLong = this.sAt;; paramLong = this.sAr)
    {
      this.sAt = paramLong;
      ab.d(this.TAG, "localMinId=" + this.sAt + ", respMaxId=" + this.sAr);
      AppMethodBeat.o(151108);
      return;
    }
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(151109);
    a.f.b.j.q(paramString, "userName");
    this.ikj = paramString;
    mB(this.sAs);
    paramString = g.RK();
    a.f.b.j.p(paramString, "MMKernel.network()");
    paramString.Rc().a(273, (f)this);
    AppMethodBeat.o(151109);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(151114);
    ab.i(this.TAG, "LogStory: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString + ' ' + paramm);
    boolean bool;
    if (((paramm instanceof com.tencent.mm.plugin.story.model.a.j)) && (bo.isEqual(((com.tencent.mm.plugin.story.model.a.j)paramm).userName, this.ikj)))
    {
      int i = ((com.tencent.mm.plugin.story.model.a.j)paramm).cpt;
      paramString = a.sFV;
      if (i == a.cEu())
      {
        ab.d(this.TAG, "onSceneEnd username=" + this.ikj + " respMaxId=" + this.sAr + ' ' + paramInt1 + ' ' + paramInt2 + ' ' + ((com.tencent.mm.plugin.story.model.a.j)paramm).rfK);
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
              break label408;
            }
          }
        }
        bool = true;
        this.sek = bool;
        this.sCF.lu(this.sek);
        this.sAr = ((com.tencent.mm.plugin.story.model.a.j)paramm).rfK;
        if (!((com.tencent.mm.plugin.story.model.a.j)paramm).rew) {
          break label414;
        }
        paramString = com.tencent.mm.plugin.story.model.j.svi;
        j.b.coO().post((Runnable)new m.b(this));
      }
    }
    for (;;)
    {
      ab.d(this.TAG, "onSceneEnd username=" + this.ikj + " respMaxId=" + this.sAr + ' ' + paramInt1 + ' ' + paramInt2 + " isAll:" + this.sek + " limitId:" + this.sAr);
      AppMethodBeat.o(151114);
      return;
      label408:
      bool = false;
      break;
      label414:
      paramString = com.tencent.mm.plugin.story.model.j.svi;
      j.b.coO().post((Runnable)new m.c(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.m
 * JD-Core Version:    0.7.0.1
 */