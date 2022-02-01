package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwt;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.v;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/NetSceneScanConfigSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "type", "", "(I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "configType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "getScanConfigType", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-scan_release"})
public final class l
  extends n
  implements k
{
  public static final a ymT;
  private f callback;
  final b rr;
  int ymS;
  
  static
  {
    AppMethodBeat.i(52169);
    ymT = new a((byte)0);
    AppMethodBeat.o(52169);
  }
  
  public l(int paramInt)
  {
    AppMethodBeat.i(52168);
    this.ymS = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new bwt());
    ((b.a)localObject).d((a)new bwu());
    ((b.a)localObject).Dl("/cgi-bin/mmbiz-bin/usrmsg/mmbizscan_confsync");
    ((b.a)localObject).oP(1812);
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((b)localObject);
    localObject = this.rr.aEE();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MMBizScanConfSyncReq");
      AppMethodBeat.o(52168);
      throw ((Throwable)localObject);
    }
    ((bwt)localObject).type = paramInt;
    ad.i("MicroMsg.NetSceneScanConfigSync", "alvinluo scanConfigSync type: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(52168);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(52167);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/NetSceneScanConfigSync$Companion;", "", "()V", "CONFIG_SYNC_TYPE_FOCUS_ENGINE", "", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.l
 * JD-Core Version:    0.7.0.1
 */