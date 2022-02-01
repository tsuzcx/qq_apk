package com.tencent.mm.plugin.textstatus.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.textstatus.proto.al;
import com.tencent.mm.plugin.textstatus.proto.am;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetUserPermission;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends p
  implements m
{
  public static final a TmU;
  private com.tencent.mm.am.h callback;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(290510);
    TmU = new a((byte)0);
    AppMethodBeat.o(290510);
  }
  
  public l()
  {
    AppMethodBeat.i(290501);
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/textstatusgetuserpermission";
    ((c.a)localObject).otE = ((a)new al());
    ((c.a)localObject).otF = ((a)new am());
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "commReqRespBuilder.buildInstance()");
    this.oDw = ((c)localObject);
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1629L, 6L, 1L, false);
    AppMethodBeat.o(290501);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(290521);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(290521);
    return i;
  }
  
  public final int getType()
  {
    return 6868;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(290530);
    kotlin.g.b.s.u(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetUserPermission", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.oDw.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetUserPermissionResp");
        AppMethodBeat.o(290530);
        throw paramString;
      }
      params = (am)params;
      Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetUserPermission", kotlin.g.b.s.X("value: ", Long.valueOf(params.TpJ)));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgP, Long.valueOf(params.TpJ));
      if (params.TpJ == 1L) {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1629L, 3L, 1L, false);
      }
    }
    for (;;)
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(290530);
      return;
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1629L, 4L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1629L, 5L, 1L, false);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetUserPermission$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.l
 * JD-Core Version:    0.7.0.1
 */