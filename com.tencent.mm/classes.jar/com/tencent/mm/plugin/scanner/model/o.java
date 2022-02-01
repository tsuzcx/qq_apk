package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.clf;
import com.tencent.mm.protocal.protobuf.clg;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/NetSceneScanConfigSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "type", "", "(I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "configType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "getScanConfigType", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-scan_release"})
public final class o
  extends q
  implements m
{
  public static final a CFH;
  int CFG;
  private i callback;
  final d rr;
  
  static
  {
    AppMethodBeat.i(52169);
    CFH = new a((byte)0);
    AppMethodBeat.o(52169);
  }
  
  public o(int paramInt)
  {
    AppMethodBeat.i(52168);
    this.CFG = paramInt;
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new clf());
    ((d.a)localObject).d((a)new clg());
    ((d.a)localObject).MB("/cgi-bin/mmbiz-bin/usrmsg/mmbizscan_confsync");
    ((d.a)localObject).sG(1812);
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    localObject = this.rr.aYJ();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MMBizScanConfSyncReq");
      AppMethodBeat.o(52168);
      throw ((Throwable)localObject);
    }
    ((clf)localObject).type = paramInt;
    Log.i("MicroMsg.NetSceneScanConfigSync", "alvinluo scanConfigSync type: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(52168);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(52167);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(52167);
    return i;
  }
  
  public final int getType()
  {
    return 1812;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52166);
    Log.i("MicroMsg.NetSceneScanConfigSync", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(52166);
      return;
    }
    AppMethodBeat.o(52166);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/NetSceneScanConfigSync$Companion;", "", "()V", "CONFIG_SYNC_TYPE_FOCUS_ENGINE", "", "CONFIG_SYNC_TYPE_GUIDE", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.o
 * JD-Core Version:    0.7.0.1
 */