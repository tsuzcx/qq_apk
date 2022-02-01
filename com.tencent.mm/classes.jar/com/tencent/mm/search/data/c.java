package com.tencent.mm.search.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/search/data/SimilarEmojiManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/search/data/ISimilarEmojiManager;", "()V", "callback", "timeStart", "", "getSimilarEmojiList", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onCrate", "onDestroy", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-emojisdk_release"})
public final class c
  implements com.tencent.mm.ak.g, a
{
  public static final c.a Gwk;
  private long Gwj;
  private com.tencent.mm.ak.g callback;
  
  static
  {
    AppMethodBeat.i(105825);
    Gwk = new c.a((byte)0);
    AppMethodBeat.o(105825);
  }
  
  public final void a(SimilarEmojiQueryModel paramSimilarEmojiQueryModel, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(105823);
    k.h(paramSimilarEmojiQueryModel, "model");
    k.h(paramg, "callback");
    ac.i("MicroMsg.SimilarEmoji", "do net request:[" + paramSimilarEmojiQueryModel + ']');
    this.callback = paramg;
    paramSimilarEmojiQueryModel = new b(paramSimilarEmojiQueryModel);
    this.Gwj = System.currentTimeMillis();
    paramg = com.tencent.mm.kernel.g.agQ();
    k.g(paramg, "MMKernel.network()");
    paramg.agi().b((n)paramSimilarEmojiQueryModel);
    AppMethodBeat.o(105823);
  }
  
  public final void eWP()
  {
    AppMethodBeat.i(105821);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    k.g(localb, "MMKernel.network()");
    localb.agi().a(3793, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(105821);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(105822);
    this.callback = null;
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    k.g(localb, "MMKernel.network()");
    localb.agi().b(3793, (com.tencent.mm.ak.g)this);
    localb = com.tencent.mm.kernel.g.agQ();
    k.g(localb, "MMKernel.network()");
    localb.agi().cancel(3793);
    AppMethodBeat.o(105822);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(105824);
    Object localObject = com.tencent.mm.search.c.a.Gwx;
    if (com.tencent.mm.search.c.a.At(this.Gwj))
    {
      localObject = com.tencent.mm.search.c.a.Gwx;
      com.tencent.mm.search.c.a.eWW();
      localObject = com.tencent.mm.search.c.a.Gwx;
      com.tencent.mm.search.c.a.Ar(System.currentTimeMillis() - this.Gwj);
    }
    localObject = this.callback;
    if (localObject != null)
    {
      ((com.tencent.mm.ak.g)localObject).onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      AppMethodBeat.o(105824);
      return;
    }
    AppMethodBeat.o(105824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.search.data.c
 * JD-Core Version:    0.7.0.1
 */