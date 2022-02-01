package com.tencent.mm.search.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/search/data/SimilarEmojiManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/search/data/ISimilarEmojiManager;", "()V", "callback", "timeStart", "", "getSimilarEmojiList", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onCrate", "onDestroy", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-emojisdk_release"})
public final class c
  implements i, a
{
  public static final a NJj;
  private i callback;
  private long hei;
  
  static
  {
    AppMethodBeat.i(105825);
    NJj = new a((byte)0);
    AppMethodBeat.o(105825);
  }
  
  public final void awy()
  {
    AppMethodBeat.i(105821);
    com.tencent.mm.kernel.b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().a(3793, (i)this);
    AppMethodBeat.o(105821);
  }
  
  public final void b(SimilarEmojiQueryModel paramSimilarEmojiQueryModel, i parami)
  {
    AppMethodBeat.i(105823);
    p.h(paramSimilarEmojiQueryModel, "model");
    p.h(parami, "callback");
    Log.i("MicroMsg.SimilarEmoji", "do net request:[" + paramSimilarEmojiQueryModel + ']');
    this.callback = parami;
    paramSimilarEmojiQueryModel = new b(paramSimilarEmojiQueryModel);
    this.hei = System.currentTimeMillis();
    parami = g.aAg();
    p.g(parami, "MMKernel.network()");
    parami.azz().b((q)paramSimilarEmojiQueryModel);
    AppMethodBeat.o(105823);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(105822);
    this.callback = null;
    com.tencent.mm.kernel.b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(3793, (i)this);
    localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().cancel(3793);
    AppMethodBeat.o(105822);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(105824);
    Object localObject = com.tencent.mm.search.c.a.NJv;
    if (com.tencent.mm.search.c.a.MH(this.hei))
    {
      localObject = com.tencent.mm.search.c.a.NJv;
      com.tencent.mm.search.c.a.gxw();
      localObject = com.tencent.mm.search.c.a.NJv;
      com.tencent.mm.search.c.a.MF(System.currentTimeMillis() - this.hei);
    }
    localObject = this.callback;
    if (localObject != null)
    {
      ((i)localObject).onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      AppMethodBeat.o(105824);
      return;
    }
    AppMethodBeat.o(105824);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/search/data/SimilarEmojiManager$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.data.c
 * JD-Core Version:    0.7.0.1
 */