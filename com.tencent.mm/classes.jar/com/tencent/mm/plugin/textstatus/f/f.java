package com.tencent.mm.plugin.textstatus.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.g.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetSelfLikeds;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "statusId", "", "context", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfLikedsResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfLikedsResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfLikedsResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class f
  extends q
  implements com.tencent.mm.network.m
{
  public static final a FYZ;
  public n FYY;
  private i callback;
  private final d iUB;
  
  static
  {
    AppMethodBeat.i(216192);
    FYZ = new a((byte)0);
    AppMethodBeat.o(216192);
  }
  
  public f(String paramString, b paramb)
  {
    AppMethodBeat.i(216191);
    Object localObject = new d.a();
    ((d.a)localObject).sG(getType());
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/textstatusgetselflikeds");
    ((d.a)localObject).c((a)new com.tencent.mm.plugin.textstatus.g.m());
    ((d.a)localObject).d((a)new n());
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "commReqRespBuilder.buildInstance()");
    this.iUB = ((d)localObject);
    localObject = this.iUB.aYJ();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetSelfLikedsReq");
      AppMethodBeat.o(216191);
      throw paramString;
    }
    localObject = (com.tencent.mm.plugin.textstatus.g.m)localObject;
    ((com.tencent.mm.plugin.textstatus.g.m)localObject).Gas = paramString;
    ((com.tencent.mm.plugin.textstatus.g.m)localObject).GaF = paramb;
    AppMethodBeat.o(216191);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(216189);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(216189);
    return i;
  }
  
  public final int getType()
  {
    return 6621;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(216190);
    p.h(params, "rr");
    Log.i("MicroMsg.TxtStatus.NetSceneTextStatusGetSelfLikeds", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.iUB.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetSelfLikedsResp");
        AppMethodBeat.o(216190);
        throw paramString;
      }
      this.FYY = ((n)params);
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(216190);
      return;
    }
    AppMethodBeat.o(216190);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetSelfLikeds$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.f
 * JD-Core Version:    0.7.0.1
 */