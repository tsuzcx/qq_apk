package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bnq;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/NetSceneScanConfigSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "type", "", "(I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "configType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "getScanConfigType", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-scan_release"})
public final class j
  extends n
  implements com.tencent.mm.network.k
{
  public static final a vOE;
  private g callback;
  final b rr;
  int vOD;
  
  static
  {
    AppMethodBeat.i(52169);
    vOE = new a((byte)0);
    AppMethodBeat.o(52169);
  }
  
  public j(int paramInt)
  {
    AppMethodBeat.i(52168);
    this.vOD = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new bnq());
    ((b.a)localObject).d((a)new bnr());
    ((b.a)localObject).wg("/cgi-bin/mmbiz-bin/usrmsg/mmbizscan_confsync");
    ((b.a)localObject).nB(1812);
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nE(0);
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.rr = ((b)localObject);
    localObject = this.rr.auL();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MMBizScanConfSyncReq");
      AppMethodBeat.o(52168);
      throw ((Throwable)localObject);
    }
    ((bnq)localObject).type = paramInt;
    ad.i("MicroMsg.NetSceneScanConfigSync", "alvinluo scanConfigSync type: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(52168);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(52167);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(52167);
    return i;
  }
  
  public final int getType()
  {
    return 1812;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52166);
    ad.i("MicroMsg.NetSceneScanConfigSync", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(52166);
      return;
    }
    AppMethodBeat.o(52166);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/NetSceneScanConfigSync$Companion;", "", "()V", "CONFIG_SYNC_TYPE_FOCUS_ENGINE", "", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.j
 * JD-Core Version:    0.7.0.1
 */