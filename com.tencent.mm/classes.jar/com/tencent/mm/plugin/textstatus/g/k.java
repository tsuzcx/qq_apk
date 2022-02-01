package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.proto.y;
import com.tencent.mm.plugin.textstatus.proto.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetUserPermission;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class k
  extends q
  implements m
{
  public static final a MDs;
  private i callback;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(233188);
    MDs = new a((byte)0);
    AppMethodBeat.o(233188);
  }
  
  public k()
  {
    AppMethodBeat.i(233186);
    Object localObject = new d.a();
    ((d.a)localObject).vD(getType());
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/textstatusgetuserpermission");
    ((d.a)localObject).c((a)new y());
    ((d.a)localObject).d((a)new z());
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "commReqRespBuilder.buildInstance()");
    this.lKU = ((d)localObject);
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1629L, 6L, 1L, false);
    AppMethodBeat.o(233186);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(233183);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(233183);
    return i;
  }
  
  public final int getType()
  {
    return 6868;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(233185);
    p.k(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetUserPermission", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.lKU.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetUserPermissionResp");
        AppMethodBeat.o(233185);
        throw paramString;
      }
      params = (z)params;
      Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetUserPermission", "value: " + params.MFy);
      paramArrayOfByte = h.aHG();
      p.j(paramArrayOfByte, "MMKernel.storage()");
      paramArrayOfByte.aHp().set(ar.a.VDO, Long.valueOf(params.MFy));
      if (params.MFy == 1L) {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1629L, 3L, 1L, false);
      }
    }
    for (;;)
    {
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(233185);
      return;
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1629L, 4L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1629L, 5L, 1L, false);
    }
    AppMethodBeat.o(233185);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetUserPermission$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.k
 * JD-Core Version:    0.7.0.1
 */