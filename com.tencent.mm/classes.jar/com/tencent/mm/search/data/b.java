package com.tencent.mm.search.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.dld;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/search/data/NetSceneGetSimilarEmoji;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getSimilarList", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-emojisdk_release"})
public final class b
  extends q
  implements m
{
  public static final a NJi;
  private i heq;
  public final d rr;
  
  static
  {
    AppMethodBeat.i(105820);
    NJi = new a((byte)0);
    AppMethodBeat.o(105820);
  }
  
  public b(SimilarEmojiQueryModel paramSimilarEmojiQueryModel)
  {
    AppMethodBeat.i(105819);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new dlc());
    ((d.a)localObject).d((a)new dld());
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/mmrecommendpanelemoji");
    ((d.a)localObject).sG(3793);
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    localObject = this.rr.aYJ();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((dlc)localObject).KXA = paramSimilarEmojiQueryModel.emojiMD5;
    localObject = this.rr.aYJ();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((dlc)localObject).MOZ = paramSimilarEmojiQueryModel.NJk;
    localObject = this.rr.aYJ();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((dlc)localObject).SessionId = String.valueOf(paramSimilarEmojiQueryModel.timestamp);
    localObject = this.rr.aYJ();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((dlc)localObject).LXC = paramSimilarEmojiQueryModel.NJl;
    localObject = this.rr.aYJ();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(105819);
      throw paramSimilarEmojiQueryModel;
    }
    ((dlc)localObject).Scene = paramSimilarEmojiQueryModel.scene;
    AppMethodBeat.o(105819);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(105817);
    this.heq = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(105817);
    return i;
  }
  
  public final int getType()
  {
    return 3793;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105818);
    params = this.heq;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(105818);
      return;
    }
    AppMethodBeat.o(105818);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/search/data/NetSceneGetSimilarEmoji$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.data.b
 * JD-Core Version:    0.7.0.1
 */