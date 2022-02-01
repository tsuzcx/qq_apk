package com.tencent.mm.plugin.textstatus.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.k;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetSelfinfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class g
  extends q
  implements m
{
  public static final g.a FZa;
  private i callback;
  private final com.tencent.mm.ak.d iUB;
  
  static
  {
    AppMethodBeat.i(216196);
    FZa = new g.a((byte)0);
    AppMethodBeat.o(216196);
  }
  
  public g()
  {
    AppMethodBeat.i(216195);
    Object localObject = new d.a();
    ((d.a)localObject).sG(getType());
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/textstatusgetselfinfo");
    ((d.a)localObject).c((com.tencent.mm.bw.a)new k());
    ((d.a)localObject).d((com.tencent.mm.bw.a)new com.tencent.mm.plugin.textstatus.g.l());
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "commReqRespBuilder.buildInstance()");
    this.iUB = ((com.tencent.mm.ak.d)localObject);
    AppMethodBeat.o(216195);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(216193);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (m)this);
    AppMethodBeat.o(216193);
    return i;
  }
  
  public final int getType()
  {
    return 5215;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(216194);
    p.h(params, "rr");
    Log.i("MicroMsg.TxtStatus.NetSceneTextStatusGetSelfinfo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.iUB.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetSelfInfoResp");
        AppMethodBeat.o(216194);
        throw paramString;
      }
      params = (com.tencent.mm.plugin.textstatus.g.l)params;
      paramArrayOfByte = f.FXJ;
      paramArrayOfByte = f.fvM();
      String str = com.tencent.mm.plugin.auth.a.a.ceA();
      p.g(str, "Account.username()");
      paramArrayOfByte = paramArrayOfByte.aTl(str);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte.field_LikeCount = params.GaJ;
        params = f.FXJ;
        f.fvM().a(paramArrayOfByte, new String[] { null });
      }
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(216194);
      return;
    }
    AppMethodBeat.o(216194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.g
 * JD-Core Version:    0.7.0.1
 */