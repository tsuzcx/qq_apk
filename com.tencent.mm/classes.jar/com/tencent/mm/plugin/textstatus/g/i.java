package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetSelfinfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class i
  extends q
  implements m
{
  public static final i.a MDo;
  private com.tencent.mm.an.i callback;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(238676);
    MDo = new i.a((byte)0);
    AppMethodBeat.o(238676);
  }
  
  public i()
  {
    AppMethodBeat.i(238675);
    Object localObject = new d.a();
    ((d.a)localObject).vD(getType());
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/textstatusgetselfinfo");
    ((d.a)localObject).c((com.tencent.mm.cd.a)new com.tencent.mm.plugin.textstatus.proto.s());
    ((d.a)localObject).d((com.tencent.mm.cd.a)new com.tencent.mm.plugin.textstatus.proto.t());
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "commReqRespBuilder.buildInstance()");
    this.lKU = ((d)localObject);
    AppMethodBeat.o(238675);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(238671);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.lKU, (m)this);
    AppMethodBeat.o(238671);
    return i;
  }
  
  public final int getType()
  {
    return 5215;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(238673);
    p.k(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetSelfinfo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.lKU.bhY();
      if (params == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetSelfInfoResp");
        AppMethodBeat.o(238673);
        throw paramString;
      }
      params = (com.tencent.mm.plugin.textstatus.proto.t)params;
      paramArrayOfByte = com.tencent.mm.plugin.textstatus.b.f.MAm;
      paramArrayOfByte = com.tencent.mm.plugin.textstatus.b.f.gly();
      String str = com.tencent.mm.plugin.auth.a.a.crN();
      p.j(str, "Account.username()");
      paramArrayOfByte = paramArrayOfByte.bey(str);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte.field_LikeCount = params.MFs;
        params = com.tencent.mm.plugin.textstatus.b.f.MAm;
        com.tencent.mm.plugin.textstatus.b.f.gly().a(paramArrayOfByte, new String[0]);
      }
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(238673);
      return;
    }
    AppMethodBeat.o(238673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.i
 * JD-Core Version:    0.7.0.1
 */