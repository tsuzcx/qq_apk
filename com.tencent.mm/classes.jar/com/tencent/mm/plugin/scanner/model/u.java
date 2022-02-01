package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.dla;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/NetSceneScanConfigSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "type", "", "(I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "configType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "getScanConfigType", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends p
  implements m
{
  public static final a ORO;
  int ORP;
  private h callback;
  final c rr;
  
  static
  {
    AppMethodBeat.i(52169);
    ORO = new a((byte)0);
    AppMethodBeat.o(52169);
  }
  
  public u(int paramInt)
  {
    AppMethodBeat.i(52168);
    this.ORP = paramInt;
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new dla());
    ((c.a)localObject).otF = ((a)new dlb());
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizscan_confsync";
    ((c.a)localObject).funcId = 1812;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.rr = ((c)localObject);
    localObject = c.b.b(this.rr.otB);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MMBizScanConfSyncReq");
      AppMethodBeat.o(52168);
      throw ((Throwable)localObject);
    }
    ((dla)localObject).type = paramInt;
    Log.i("MicroMsg.NetSceneScanConfigSync", "alvinluo scanConfigSync type: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(52168);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(52167);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(52167);
    return i;
  }
  
  public final int getType()
  {
    return 1812;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52166);
    Log.i("MicroMsg.NetSceneScanConfigSync", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(52166);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/NetSceneScanConfigSync$Companion;", "", "()V", "CONFIG_SYNC_TYPE_FOCUS_ENGINE", "", "CONFIG_SYNC_TYPE_PHASH", "CONFIG_SYNC_TYPE_SCAN_CODE_PRODUCT_MERGE", "CONFIG_SYNC_TYPE_SCAN_GOODS_GUIDE", "TAG", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.u
 * JD-Core Version:    0.7.0.1
 */