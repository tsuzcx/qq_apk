package com.tencent.mm.search.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.crz;
import com.tencent.mm.protocal.protobuf.csa;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/search/data/NetSceneGetSimilarEmoji;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getSimilarList", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-emojisdk_release"})
public final class b
  extends n
  implements k
{
  public static final b.a Iic;
  private f gzH;
  public final com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(105820);
    Iic = new b.a((byte)0);
    AppMethodBeat.o(105820);
  }
  
  public b(SimilarEmojiQueryModel paramSimilarEmojiQueryModel)
  {
    AppMethodBeat.i(105819);
    Object localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).c((a)new crz());
    ((com.tencent.mm.al.b.a)localObject).d((a)new csa());
    ((com.tencent.mm.al.b.a)localObject).Dl("/cgi-bin/micromsg-bin/mmrecommendpanelemoji");
    ((com.tencent.mm.al.b.a)localObject).oP(3793);
    ((com.tencent.mm.al.b.a)localObject).oR(0);
    ((com.tencent.mm.al.b.a)localObject).oS(0);
    localObject = ((com.tencent.mm.al.b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.al.b)localObject);
    localObject = this.rr.aEE();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((crz)localObject).FKK = paramSimilarEmojiQueryModel.emojiMD5;
    localObject = this.rr.aEE();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((crz)localObject).Hkv = paramSimilarEmojiQueryModel.Iif;
    localObject = this.rr.aEE();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((crz)localObject).FxN = String.valueOf(paramSimilarEmojiQueryModel.timestamp);
    localObject = this.rr.aEE();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((crz)localObject).GzQ = paramSimilarEmojiQueryModel.Iig;
    localObject = this.rr.aEE();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((crz)localObject).Scene = paramSimilarEmojiQueryModel.scene;
    AppMethodBeat.o(105819);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(105817);
    this.gzH = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(105817);
    return i;
  }
  
  public final int getType()
  {
    return 3793;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105818);
    paramq = this.gzH;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(105818);
      return;
    }
    AppMethodBeat.o(105818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.search.data.b
 * JD-Core Version:    0.7.0.1
 */