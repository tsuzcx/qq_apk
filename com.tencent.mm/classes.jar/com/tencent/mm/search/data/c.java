package com.tencent.mm.search.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/data/SimilarEmojiManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/search/data/ISimilarEmojiManager;", "()V", "callback", "timeStart", "", "getSimilarEmojiList", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onCrate", "onDestroy", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-emojisdk_release"})
public final class c
  implements i, a
{
  public static final a UWK;
  private i callback;
  private long jPY;
  
  static
  {
    AppMethodBeat.i(105825);
    UWK = new a((byte)0);
    AppMethodBeat.o(105825);
  }
  
  public final void aDP()
  {
    AppMethodBeat.i(105821);
    com.tencent.mm.kernel.c localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().a(3793, (i)this);
    AppMethodBeat.o(105821);
  }
  
  public final void b(SimilarEmojiQueryModel paramSimilarEmojiQueryModel, i parami)
  {
    AppMethodBeat.i(105823);
    p.k(paramSimilarEmojiQueryModel, "model");
    p.k(parami, "callback");
    Log.i("MicroMsg.SimilarEmoji", "do net request:[" + paramSimilarEmojiQueryModel + ']');
    this.callback = parami;
    paramSimilarEmojiQueryModel = new b(paramSimilarEmojiQueryModel);
    this.jPY = System.currentTimeMillis();
    parami = h.aHF();
    p.j(parami, "MMKernel.network()");
    parami.aGY().b((q)paramSimilarEmojiQueryModel);
    AppMethodBeat.o(105823);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(105822);
    this.callback = null;
    com.tencent.mm.kernel.c localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b(3793, (i)this);
    localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().cancel(3793);
    AppMethodBeat.o(105822);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(105824);
    Object localObject = com.tencent.mm.search.c.a.UWW;
    if (com.tencent.mm.search.c.a.Up(this.jPY))
    {
      localObject = com.tencent.mm.search.c.a.UWW;
      com.tencent.mm.search.c.a.htu();
      localObject = com.tencent.mm.search.c.a.UWW;
      com.tencent.mm.search.c.a.Un(System.currentTimeMillis() - this.jPY);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/data/SimilarEmojiManager$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.data.c
 * JD-Core Version:    0.7.0.1
 */