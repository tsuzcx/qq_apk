package com.tencent.mm.search.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/search/data/SimilarEmojiManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/search/data/ISimilarEmojiManager;", "()V", "callback", "timeStart", "", "getSimilarEmojiList", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onCrate", "onDestroy", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-emojisdk_release"})
public final class c
  implements f, a
{
  public static final c.a ICp;
  private long ICo;
  private f callback;
  
  static
  {
    AppMethodBeat.i(105825);
    ICp = new c.a((byte)0);
    AppMethodBeat.o(105825);
  }
  
  public final void a(SimilarEmojiQueryModel paramSimilarEmojiQueryModel, f paramf)
  {
    AppMethodBeat.i(105823);
    p.h(paramSimilarEmojiQueryModel, "model");
    p.h(paramf, "callback");
    ae.i("MicroMsg.SimilarEmoji", "do net request:[" + paramSimilarEmojiQueryModel + ']');
    this.callback = paramf;
    paramSimilarEmojiQueryModel = new b(paramSimilarEmojiQueryModel);
    this.ICo = System.currentTimeMillis();
    paramf = g.ajQ();
    p.g(paramf, "MMKernel.network()");
    paramf.ajj().b((n)paramSimilarEmojiQueryModel);
    AppMethodBeat.o(105823);
  }
  
  public final void fqu()
  {
    AppMethodBeat.i(105821);
    com.tencent.mm.kernel.b localb = g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().a(3793, (f)this);
    AppMethodBeat.o(105821);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(105822);
    this.callback = null;
    com.tencent.mm.kernel.b localb = g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().b(3793, (f)this);
    localb = g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().cancel(3793);
    AppMethodBeat.o(105822);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(105824);
    Object localObject = com.tencent.mm.search.c.a.ICC;
    if (com.tencent.mm.search.c.a.DH(this.ICo))
    {
      localObject = com.tencent.mm.search.c.a.ICC;
      com.tencent.mm.search.c.a.fqB();
      localObject = com.tencent.mm.search.c.a.ICC;
      com.tencent.mm.search.c.a.DF(System.currentTimeMillis() - this.ICo);
    }
    localObject = this.callback;
    if (localObject != null)
    {
      ((f)localObject).onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      AppMethodBeat.o(105824);
      return;
    }
    AppMethodBeat.o(105824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.data.c
 * JD-Core Version:    0.7.0.1
 */