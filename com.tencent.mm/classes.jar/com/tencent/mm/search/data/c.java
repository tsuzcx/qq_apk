package com.tencent.mm.search.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/data/SimilarEmojiManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/search/data/ISimilarEmojiManager;", "()V", "callback", "timeStart", "", "getSimilarEmojiList", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onCrate", "onDestroy", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-emojisdk_release"})
public final class c
  implements com.tencent.mm.al.g, a
{
  public static final a EYY;
  private long EYX;
  private com.tencent.mm.al.g callback;
  
  static
  {
    AppMethodBeat.i(105825);
    EYY = new a((byte)0);
    AppMethodBeat.o(105825);
  }
  
  public final void a(SimilarEmojiQueryModel paramSimilarEmojiQueryModel, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(105823);
    k.h(paramSimilarEmojiQueryModel, "model");
    k.h(paramg, "callback");
    ad.i("MicroMsg.SimilarEmoji", "do net request:[" + paramSimilarEmojiQueryModel + ']');
    this.callback = paramg;
    paramSimilarEmojiQueryModel = new b(paramSimilarEmojiQueryModel);
    this.EYX = System.currentTimeMillis();
    paramg = com.tencent.mm.kernel.g.afA();
    k.g(paramg, "MMKernel.network()");
    paramg.aeS().b((n)paramSimilarEmojiQueryModel);
    AppMethodBeat.o(105823);
  }
  
  public final void eHu()
  {
    AppMethodBeat.i(105821);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().a(3793, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(105821);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(105822);
    this.callback = null;
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().b(3793, (com.tencent.mm.al.g)this);
    localb = com.tencent.mm.kernel.g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().cancel(3793);
    AppMethodBeat.o(105822);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(105824);
    Object localObject = com.tencent.mm.search.b.a.EZj;
    if (com.tencent.mm.search.b.a.vQ(this.EYX))
    {
      localObject = com.tencent.mm.search.b.a.EZj;
      com.tencent.mm.search.b.a.eHB();
      localObject = com.tencent.mm.search.b.a.EZj;
      com.tencent.mm.search.b.a.vO(System.currentTimeMillis() - this.EYX);
    }
    localObject = this.callback;
    if (localObject != null)
    {
      ((com.tencent.mm.al.g)localObject).onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      AppMethodBeat.o(105824);
      return;
    }
    AppMethodBeat.o(105824);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/data/SimilarEmojiManager$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.data.c
 * JD-Core Version:    0.7.0.1
 */