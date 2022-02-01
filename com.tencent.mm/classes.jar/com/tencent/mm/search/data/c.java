package com.tencent.mm.search.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/search/data/SimilarEmojiManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/search/data/ISimilarEmojiManager;", "()V", "callback", "timeStart", "", "getSimilarEmojiList", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onCrate", "onDestroy", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements com.tencent.mm.am.h, a
{
  public static final c.a acrV;
  private long acrW;
  private com.tencent.mm.am.h callback;
  
  static
  {
    AppMethodBeat.i(105825);
    acrV = new c.a((byte)0);
    AppMethodBeat.o(105825);
  }
  
  public final void a(SimilarEmojiQueryModel paramSimilarEmojiQueryModel, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(105823);
    kotlin.g.b.s.u(paramSimilarEmojiQueryModel, "model");
    kotlin.g.b.s.u(paramh, "callback");
    Log.i("MicroMsg.SimilarEmoji", "do net request:[" + paramSimilarEmojiQueryModel + ']');
    this.callback = paramh;
    paramSimilarEmojiQueryModel = new b(paramSimilarEmojiQueryModel);
    this.acrW = System.currentTimeMillis();
    com.tencent.mm.kernel.h.baD().mCm.a((p)paramSimilarEmojiQueryModel, 0);
    AppMethodBeat.o(105823);
  }
  
  public final void iTu()
  {
    AppMethodBeat.i(105821);
    com.tencent.mm.kernel.h.baD().mCm.a(3793, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(105821);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(105822);
    this.callback = null;
    com.tencent.mm.kernel.h.baD().mCm.b(3793, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.cancel(3793);
    AppMethodBeat.o(105822);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(105824);
    Object localObject = com.tencent.mm.search.c.a.acsi;
    if (com.tencent.mm.search.c.a.yB(this.acrW))
    {
      localObject = com.tencent.mm.search.c.a.acsi;
      com.tencent.mm.search.c.a.iTB();
      localObject = com.tencent.mm.search.c.a.acsi;
      com.tencent.mm.search.c.a.yz(System.currentTimeMillis() - this.acrW);
    }
    localObject = this.callback;
    if (localObject != null) {
      ((com.tencent.mm.am.h)localObject).onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    }
    AppMethodBeat.o(105824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.data.c
 * JD-Core Version:    0.7.0.1
 */