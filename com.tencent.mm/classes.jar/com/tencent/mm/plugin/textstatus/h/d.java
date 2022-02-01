package com.tencent.mm.plugin.textstatus.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.textstatus.proto.aa;
import com.tencent.mm.plugin.textstatus.proto.ab;
import com.tencent.mm.plugin.textstatus.proto.bl;
import com.tencent.mm.plugin.textstatus.proto.k;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetBrandInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "url", "", "status_signature", "status_signature_ext_info", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusSignatureExtInfo;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusSignatureExtInfo;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetBrandInfoReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetBrandInfoResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetBrandInfoResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetBrandInfoResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "print", "Lcom/tencent/mm/plugin/textstatus/proto/PaySignature;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends p
  implements m
{
  public static final d.a TmG;
  private final aa TmH;
  public ab TmI;
  private h callback;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(290601);
    TmG = new d.a((byte)0);
    AppMethodBeat.o(290601);
  }
  
  public d(String paramString1, String paramString2, bl parambl)
  {
    AppMethodBeat.i(290588);
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/textstatusgetbrandinfo";
    ((c.a)localObject).otE = ((a)new aa());
    ((c.a)localObject).otF = ((a)new ab());
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "commReqRespBuilder.buildInstance()");
    this.oDw = ((c)localObject);
    localObject = c.b.b(this.oDw.otB);
    if (localObject == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetBrandInfoReq");
      AppMethodBeat.o(290588);
      throw paramString1;
    }
    this.TmH = ((aa)localObject);
    this.TmH.url = paramString1;
    this.TmH.Tov = paramString2;
    this.TmH.Tpw = parambl;
    paramString2 = new StringBuilder("url:").append(paramString1).append(" signature:").append(paramString2).append(", extInfo:");
    if (parambl == null)
    {
      paramString1 = localStringBuilder;
      Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetBrandInfo", paramString1);
      AppMethodBeat.o(290588);
      return;
    }
    localStringBuilder = new StringBuilder("pay_sign:[");
    paramString1 = parambl.Tow;
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = "transaction_id:" + paramString1.Oks + " pay_signature:" + paramString1.ToN)
    {
      paramString1 = paramString1 + "] source_id:" + parambl.ToB + " mp_signature:" + parambl.ToC;
      break;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(290618);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(290618);
    return i;
  }
  
  public final int getType()
  {
    return 6889;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(290625);
    kotlin.g.b.s.u(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetBrandInfo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.oDw.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetBrandInfoResp");
        AppMethodBeat.o(290625);
        throw paramString;
      }
      this.TmI = ((ab)params);
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(290625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.d
 * JD-Core Version:    0.7.0.1
 */