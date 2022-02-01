package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.egc;
import com.tencent.mm.protocal.protobuf.egd;

public final class w
  extends a
  implements k
{
  private s DTs;
  private egc DTt;
  private egd DTu;
  private f callback;
  private com.tencent.mm.ak.b hZD;
  
  public w(s params)
  {
    AppMethodBeat.i(188467);
    this.DTs = params;
    this.DTt = new egc();
    this.DTt.type = 1;
    this.DTt.FXO = params.content;
    this.DTu = new egd();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.WebSearch.NetSceneWebSearchAiScanImageRetrieval", "create NetSceneWebSearchAiScanImageRetrieval scene:%s requestKey:%s", new Object[] { Integer.valueOf(params.scene), params.dmw });
    params = new b.a();
    params.funcId = 1532;
    params.uri = "/cgi-bin/mmbiz-bin/usrmsg/aiscan_image_retrieval";
    params.hQF = this.DTt;
    params.hQG = this.DTu;
    this.hZD = params.aDS();
    AppMethodBeat.o(188467);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(188469);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(188469);
    return i;
  }
  
  public final egd ePG()
  {
    return this.DTu;
  }
  
  public final s ePH()
  {
    return this.DTs;
  }
  
  public final String ePw()
  {
    return this.DTu.FXO;
  }
  
  public final int ePx()
  {
    return 0;
  }
  
  public final int getType()
  {
    return 1532;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(188468);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.WebSearch.NetSceneWebSearchAiScanImageRetrieval", "netId: %s errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      this.DTu = ((egd)this.hZD.hQE.hQJ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(188468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.w
 * JD-Core Version:    0.7.0.1
 */