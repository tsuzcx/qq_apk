package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.proto.u;
import com.tencent.mm.plugin.textstatus.proto.v;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetSelfLikeds;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "statusId", "", "context", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfLikedsResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfLikedsResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfLikedsResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class h
  extends q
  implements m
{
  public static final a MDn;
  public v MDm;
  private i callback;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(238601);
    MDn = new a((byte)0);
    AppMethodBeat.o(238601);
  }
  
  public h(String paramString, b paramb)
  {
    AppMethodBeat.i(238598);
    Object localObject = new d.a();
    ((d.a)localObject).vD(getType());
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/textstatusgetselflikeds");
    ((d.a)localObject).c((a)new u());
    ((d.a)localObject).d((a)new v());
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "commReqRespBuilder.buildInstance()");
    this.lKU = ((d)localObject);
    localObject = this.lKU.bhX();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetSelfLikedsReq");
      AppMethodBeat.o(238598);
      throw paramString;
    }
    localObject = (u)localObject;
    ((u)localObject).MEN = paramString;
    ((u)localObject).MFp = paramb;
    AppMethodBeat.o(238598);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(238591);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(238591);
    return i;
  }
  
  public final int getType()
  {
    return 6621;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(238595);
    p.k(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetSelfLikeds", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.lKU.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetSelfLikedsResp");
        AppMethodBeat.o(238595);
        throw paramString;
      }
      this.MDm = ((v)params);
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(238595);
      return;
    }
    AppMethodBeat.o(238595);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetSelfLikeds$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.h
 * JD-Core Version:    0.7.0.1
 */