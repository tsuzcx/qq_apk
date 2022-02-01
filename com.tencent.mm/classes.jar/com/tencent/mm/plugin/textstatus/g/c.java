package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetBrandInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "url", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetBrandInfoReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetBrandInfoResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetBrandInfoResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetBrandInfoResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class c
  extends q
  implements com.tencent.mm.network.m
{
  public static final a MDe;
  private final com.tencent.mm.plugin.textstatus.proto.l MDc;
  public com.tencent.mm.plugin.textstatus.proto.m MDd;
  private i callback;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(233442);
    MDe = new a((byte)0);
    AppMethodBeat.o(233442);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(233441);
    Object localObject = new d.a();
    ((d.a)localObject).vD(getType());
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/textstatusgetbrandinfo");
    ((d.a)localObject).c((a)new com.tencent.mm.plugin.textstatus.proto.l());
    ((d.a)localObject).d((a)new com.tencent.mm.plugin.textstatus.proto.m());
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "commReqRespBuilder.buildInstance()");
    this.lKU = ((d)localObject);
    localObject = this.lKU.bhX();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetBrandInfoReq");
      AppMethodBeat.o(233441);
      throw paramString;
    }
    this.MDc = ((com.tencent.mm.plugin.textstatus.proto.l)localObject);
    this.MDc.url = paramString;
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetBrandInfo", "url:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(233441);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(233437);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(233437);
    return i;
  }
  
  public final int getType()
  {
    return 6889;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(233439);
    p.k(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetBrandInfo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.lKU.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetBrandInfoResp");
        AppMethodBeat.o(233439);
        throw paramString;
      }
      this.MDd = ((com.tencent.mm.plugin.textstatus.proto.m)params);
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(233439);
      return;
    }
    AppMethodBeat.o(233439);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetBrandInfo$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.c
 * JD-Core Version:    0.7.0.1
 */