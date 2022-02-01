package com.tencent.mm.search.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cmw;
import com.tencent.mm.protocal.protobuf.cmx;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/search/data/NetSceneGetSimilarEmoji;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getSimilarList", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-emojisdk_release"})
public final class b
  extends n
  implements com.tencent.mm.network.k
{
  public static final b.a Gwi;
  private g gfX;
  public final com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(105820);
    Gwi = new b.a((byte)0);
    AppMethodBeat.o(105820);
  }
  
  public b(SimilarEmojiQueryModel paramSimilarEmojiQueryModel)
  {
    AppMethodBeat.i(105819);
    Object localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).c((a)new cmw());
    ((com.tencent.mm.ak.b.a)localObject).d((a)new cmx());
    ((com.tencent.mm.ak.b.a)localObject).Am("/cgi-bin/micromsg-bin/mmrecommendpanelemoji");
    ((com.tencent.mm.ak.b.a)localObject).op(3793);
    ((com.tencent.mm.ak.b.a)localObject).or(0);
    ((com.tencent.mm.ak.b.a)localObject).os(0);
    localObject = ((com.tencent.mm.ak.b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.b)localObject);
    localObject = this.rr.aBC();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((cmw)localObject).Eel = paramSimilarEmojiQueryModel.emojiMD5;
    localObject = this.rr.aBC();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((cmw)localObject).FAh = paramSimilarEmojiQueryModel.Gwl;
    localObject = this.rr.aBC();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((cmw)localObject).DSu = String.valueOf(paramSimilarEmojiQueryModel.timestamp);
    localObject = this.rr.aBC();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((cmw)localObject).EQz = paramSimilarEmojiQueryModel.Gwm;
    localObject = this.rr.aBC();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((cmw)localObject).Scene = paramSimilarEmojiQueryModel.scene;
    AppMethodBeat.o(105819);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(105817);
    this.gfX = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
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
    paramq = this.gfX;
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