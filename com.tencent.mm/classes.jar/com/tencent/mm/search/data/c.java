package com.tencent.mm.search.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/search/data/SimilarEmojiManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/search/data/ISimilarEmojiManager;", "()V", "callback", "timeStart", "", "getSimilarEmojiList", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onCrate", "onDestroy", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-emojisdk_release"})
public final class c
  implements f, a
{
  public static final c.a Iie;
  private long Iid;
  private f callback;
  
  static
  {
    AppMethodBeat.i(105825);
    Iie = new c.a((byte)0);
    AppMethodBeat.o(105825);
  }
  
  public final void a(SimilarEmojiQueryModel paramSimilarEmojiQueryModel, f paramf)
  {
    AppMethodBeat.i(105823);
    p.h(paramSimilarEmojiQueryModel, "model");
    p.h(paramf, "callback");
    ad.i("MicroMsg.SimilarEmoji", "do net request:[" + paramSimilarEmojiQueryModel + ']');
    this.callback = paramf;
    paramSimilarEmojiQueryModel = new b(paramSimilarEmojiQueryModel);
    this.Iid = System.currentTimeMillis();
    paramf = g.ajB();
    p.g(paramf, "MMKernel.network()");
    paramf.aiU().b((n)paramSimilarEmojiQueryModel);
    AppMethodBeat.o(105823);
  }
  
  public final void fmz()
  {
    AppMethodBeat.i(105821);
    com.tencent.mm.kernel.b localb = g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().a(3793, (f)this);
    AppMethodBeat.o(105821);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(105822);
    this.callback = null;
    com.tencent.mm.kernel.b localb = g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b(3793, (f)this);
    localb = g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().cancel(3793);
    AppMethodBeat.o(105822);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(105824);
    Object localObject = com.tencent.mm.search.c.a.Iir;
    if (com.tencent.mm.search.c.a.Dj(this.Iid))
    {
      localObject = com.tencent.mm.search.c.a.Iir;
      com.tencent.mm.search.c.a.fmG();
      localObject = com.tencent.mm.search.c.a.Iir;
      com.tencent.mm.search.c.a.Dh(System.currentTimeMillis() - this.Iid);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.search.data.c
 * JD-Core Version:    0.7.0.1
 */