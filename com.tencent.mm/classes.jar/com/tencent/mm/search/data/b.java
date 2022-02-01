package com.tencent.mm.search.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cht;
import com.tencent.mm.protocal.protobuf.chu;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/data/NetSceneGetSimilarEmoji;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getSimilarList", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-emojisdk_release"})
public final class b
  extends n
  implements com.tencent.mm.network.k
{
  public static final a EYW;
  private g gbr;
  public final com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(105820);
    EYW = new a((byte)0);
    AppMethodBeat.o(105820);
  }
  
  public b(SimilarEmojiQueryModel paramSimilarEmojiQueryModel)
  {
    AppMethodBeat.i(105819);
    Object localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).c((a)new cht());
    ((com.tencent.mm.al.b.a)localObject).d((a)new chu());
    ((com.tencent.mm.al.b.a)localObject).wg("/cgi-bin/micromsg-bin/mmrecommendpanelemoji");
    ((com.tencent.mm.al.b.a)localObject).nB(3793);
    ((com.tencent.mm.al.b.a)localObject).nD(0);
    ((com.tencent.mm.al.b.a)localObject).nE(0);
    localObject = ((com.tencent.mm.al.b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.al.b)localObject);
    localObject = this.rr.auL();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((cht)localObject).CLI = paramSimilarEmojiQueryModel.emojiMD5;
    localObject = this.rr.auL();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((cht)localObject).Edl = paramSimilarEmojiQueryModel.EYZ;
    localObject = this.rr.auL();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((cht)localObject).CzY = String.valueOf(paramSimilarEmojiQueryModel.timestamp);
    localObject = this.rr.auL();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((cht)localObject).Dvq = paramSimilarEmojiQueryModel.EZa;
    localObject = this.rr.auL();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((cht)localObject).Scene = paramSimilarEmojiQueryModel.scene;
    AppMethodBeat.o(105819);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(105817);
    this.gbr = paramg;
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
    paramq = this.gbr;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(105818);
      return;
    }
    AppMethodBeat.o(105818);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/data/NetSceneGetSimilarEmoji$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.data.b
 * JD-Core Version:    0.7.0.1
 */