package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.proto.o;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetIconConfig;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "key", "", "(J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetIconConfigReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetIconConfigResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetIconConfigResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetIconConfigResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class f
  extends q
  implements m
{
  public static final a MDj;
  private final o MDh;
  public com.tencent.mm.plugin.textstatus.proto.p MDi;
  private i callback;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(232278);
    MDj = new a((byte)0);
    AppMethodBeat.o(232278);
  }
  
  public f(long paramLong)
  {
    AppMethodBeat.i(232277);
    Object localObject = new d.a();
    ((d.a)localObject).vD(getType());
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/textstatusgeticonconfig");
    ((d.a)localObject).c((a)new o());
    ((d.a)localObject).d((a)new com.tencent.mm.plugin.textstatus.proto.p());
    localObject = ((d.a)localObject).bgN();
    kotlin.g.b.p.j(localObject, "commReqRespBuilder.buildInstance()");
    this.lKU = ((d)localObject);
    localObject = this.lKU.bhX();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetIconConfigReq");
      AppMethodBeat.o(232277);
      throw ((Throwable)localObject);
    }
    this.MDh = ((o)localObject);
    this.MDh.key = paramLong;
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetIconConfig", "key:".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(232277);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(232275);
    kotlin.g.b.p.k(paramg, "dispatcher");
    kotlin.g.b.p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(232275);
    return i;
  }
  
  public final int getType()
  {
    return 4255;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(232276);
    kotlin.g.b.p.k(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetIconConfig", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.lKU.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetIconConfigResp");
        AppMethodBeat.o(232276);
        throw paramString;
      }
      this.MDi = ((com.tencent.mm.plugin.textstatus.proto.p)params);
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(232276);
      return;
    }
    AppMethodBeat.o(232276);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetIconConfig$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.f
 * JD-Core Version:    0.7.0.1
 */