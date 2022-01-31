package com.tencent.mm.plugin.story.f;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.o.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;)V", "localCachedMinId", "", "localMinId", "mIsAll", "", "mMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mNpLoopCount", "", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "assembleRealData", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "infos", "checkStoryPost", "", "isAll", "errCode", "loadDBData", "loadFpData", "loadNpData", "needLoopFetch", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errType", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class a
  implements com.tencent.mm.ai.f, com.tencent.mm.plugin.story.d.a.e
{
  private static final String TAG = "MicroMsg.AlbumPresenter";
  public static final a.a sAw;
  private String ikj;
  private final LinkedHashMap<String, ArrayList<h>> sAq;
  private long sAr;
  private long sAs;
  private long sAt;
  private int sAu;
  final com.tencent.mm.plugin.story.d.a.f sAv;
  private boolean sek;
  
  static
  {
    AppMethodBeat.i(109516);
    sAw = new a.a((byte)0);
    TAG = "MicroMsg.AlbumPresenter";
    AppMethodBeat.o(109516);
  }
  
  public a(com.tencent.mm.plugin.story.d.a.f paramf)
  {
    AppMethodBeat.i(109515);
    this.sAv = paramf;
    this.ikj = "";
    this.sAq = new LinkedHashMap();
    AppMethodBeat.o(109515);
  }
  
  public final void bOo()
  {
    AppMethodBeat.i(109508);
    b localb = g.RK();
    a.f.b.j.p(localb, "MMKernel.network()");
    localb.Rc().b(191, (com.tencent.mm.ai.f)this);
    localb = g.RK();
    a.f.b.j.p(localb, "MMKernel.network()");
    localb.Rc().b(3926, (com.tencent.mm.ai.f)this);
    localb = g.RK();
    a.f.b.j.p(localb, "MMKernel.network()");
    localb.Rc().b(764, (com.tencent.mm.ai.f)this);
    AppMethodBeat.o(109508);
  }
  
  public final void czH()
  {
    AppMethodBeat.i(109511);
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.coO().post((Runnable)new a.d(this));
    AppMethodBeat.o(109511);
  }
  
  public final void czI()
  {
    AppMethodBeat.i(109510);
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.coO().post((Runnable)new a.c(this));
    AppMethodBeat.o(109510);
  }
  
  public final void czK()
  {
    AppMethodBeat.i(109509);
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.coO().post((Runnable)new a.b(this));
    AppMethodBeat.o(109509);
  }
  
  public final void mB(long paramLong)
  {
    AppMethodBeat.i(109506);
    Object localObject = com.tencent.mm.plugin.story.model.j.svi;
    localObject = j.b.cAB();
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAL();
    this.sAt = ((k)localObject).H(paramLong, o.a.adg(this.ikj));
    if (this.sAr != 0L) {
      if (this.sAt >= this.sAr) {
        break label116;
      }
    }
    label116:
    for (paramLong = this.sAt;; paramLong = this.sAr)
    {
      this.sAt = paramLong;
      ab.d(TAG, "localMinId=" + this.sAt + ", respMaxId=" + this.sAr);
      AppMethodBeat.o(109506);
      return;
    }
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(109507);
    a.f.b.j.q(paramString, "userName");
    this.ikj = paramString;
    mB(this.sAs);
    paramString = g.RK();
    a.f.b.j.p(paramString, "MMKernel.network()");
    paramString.Rc().a(191, (com.tencent.mm.ai.f)this);
    paramString = g.RK();
    a.f.b.j.p(paramString, "MMKernel.network()");
    paramString.Rc().a(3926, (com.tencent.mm.ai.f)this);
    paramString = g.RK();
    a.f.b.j.p(paramString, "MMKernel.network()");
    paramString.Rc().a(764, (com.tencent.mm.ai.f)this);
    AppMethodBeat.o(109507);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(109512);
    boolean bool;
    if (((paramm instanceof com.tencent.mm.plugin.story.model.a.f)) && (bo.isEqual(((com.tencent.mm.plugin.story.model.a.f)paramm).userName, this.ikj)))
    {
      paramString = com.tencent.mm.plugin.story.h.a.sFV;
      if (paramInt2 != com.tencent.mm.plugin.story.h.a.cDX())
      {
        paramString = com.tencent.mm.plugin.story.h.a.sFV;
        if (paramInt2 != com.tencent.mm.plugin.story.h.a.cDY()) {
          break label188;
        }
      }
      bool = true;
      this.sek = bool;
      if (this.sek) {
        this.sAv.czL();
      }
      if (!((com.tencent.mm.plugin.story.model.a.f)paramm).rew) {
        break label194;
      }
      paramString = com.tencent.mm.plugin.story.model.j.svi;
      j.b.coO().post((Runnable)new a.e(this));
    }
    for (;;)
    {
      this.sAr = ((com.tencent.mm.plugin.story.model.a.f)paramm).rfK;
      ab.d(TAG, "onSceneEnd username=" + this.ikj + " respMaxId=" + this.sAr + ' ' + paramInt1 + ' ' + paramInt2);
      AppMethodBeat.o(109512);
      return;
      label188:
      bool = false;
      break;
      label194:
      this.sAu = 0;
      paramString = com.tencent.mm.plugin.story.model.j.svi;
      j.b.coO().post((Runnable)new a.f(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a
 * JD-Core Version:    0.7.0.1
 */