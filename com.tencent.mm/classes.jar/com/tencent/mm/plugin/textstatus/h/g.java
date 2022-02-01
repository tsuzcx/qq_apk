package com.tencent.mm.plugin.textstatus.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.textstatus.proto.ad;
import com.tencent.mm.plugin.textstatus.proto.ae;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetIconConfig;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "key", "", "coverAgendaKey", "(JLjava/lang/Long;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetIconConfigReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetIconConfigResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetIconConfigResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetIconConfigResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends p
  implements m
{
  public static final a TmL;
  private final ad TmM;
  public ae TmN;
  private h callback;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(290581);
    TmL = new a((byte)0);
    AppMethodBeat.o(290581);
  }
  
  public g(long paramLong, Long paramLong1)
  {
    AppMethodBeat.i(290572);
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/textstatusgeticonconfig";
    ((c.a)localObject).otE = ((a)new ad());
    ((c.a)localObject).otF = ((a)new ae());
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "commReqRespBuilder.buildInstance()");
    this.oDw = ((c)localObject);
    localObject = c.b.b(this.oDw.otB);
    if (localObject == null)
    {
      paramLong1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetIconConfigReq");
      AppMethodBeat.o(290572);
      throw paramLong1;
    }
    this.TmM = ((ad)localObject);
    this.TmM.key = paramLong;
    localObject = this.TmM;
    if (paramLong1 == null) {}
    for (long l = 0L;; l = paramLong1.longValue())
    {
      ((ad)localObject).Tpz = l;
      Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetIconConfig", "key:" + paramLong + " coverAgendaKey:" + paramLong1);
      AppMethodBeat.o(290572);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(290593);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(290593);
    return i;
  }
  
  public final int getType()
  {
    return 4255;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(290605);
    kotlin.g.b.s.u(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetIconConfig", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.oDw.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetIconConfigResp");
        AppMethodBeat.o(290605);
        throw paramString;
      }
      this.TmN = ((ae)params);
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(290605);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetIconConfig$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.g
 * JD-Core Version:    0.7.0.1
 */