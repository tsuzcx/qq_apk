package com.tencent.mm.search.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.csu;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/search/data/NetSceneGetSimilarEmoji;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getSimilarList", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-emojisdk_release"})
public final class b
  extends n
  implements k
{
  public static final b.a ICn;
  private f gCo;
  public final com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(105820);
    ICn = new b.a((byte)0);
    AppMethodBeat.o(105820);
  }
  
  public b(SimilarEmojiQueryModel paramSimilarEmojiQueryModel)
  {
    AppMethodBeat.i(105819);
    Object localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).c((a)new cst());
    ((com.tencent.mm.ak.b.a)localObject).d((a)new csu());
    ((com.tencent.mm.ak.b.a)localObject).DN("/cgi-bin/micromsg-bin/mmrecommendpanelemoji");
    ((com.tencent.mm.ak.b.a)localObject).oS(3793);
    ((com.tencent.mm.ak.b.a)localObject).oU(0);
    ((com.tencent.mm.ak.b.a)localObject).oV(0);
    localObject = ((com.tencent.mm.ak.b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.b)localObject);
    localObject = this.rr.aEU();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((cst)localObject).Gdj = paramSimilarEmojiQueryModel.emojiMD5;
    localObject = this.rr.aEU();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((cst)localObject).HDV = paramSimilarEmojiQueryModel.ICq;
    localObject = this.rr.aEU();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((cst)localObject).FQl = String.valueOf(paramSimilarEmojiQueryModel.timestamp);
    localObject = this.rr.aEU();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((cst)localObject).GTq = paramSimilarEmojiQueryModel.ICr;
    localObject = this.rr.aEU();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((cst)localObject).Scene = paramSimilarEmojiQueryModel.scene;
    AppMethodBeat.o(105819);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(105817);
    this.gCo = paramf;
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
    paramq = this.gCo;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(105818);
      return;
    }
    AppMethodBeat.o(105818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.data.b
 * JD-Core Version:    0.7.0.1
 */