package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.eel;
import com.tencent.mm.protocal.protobuf.eem;

public final class w
  extends a
  implements k
{
  private s DBv;
  private eel DBw;
  private eem DBx;
  private f callback;
  private com.tencent.mm.al.b hWL;
  
  public w(s params)
  {
    AppMethodBeat.i(217637);
    this.DBv = params;
    this.DBw = new eel();
    this.DBw.type = 1;
    this.DBw.FFt = params.content;
    this.DBx = new eem();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.WebSearch.NetSceneWebSearchAiScanImageRetrieval", "create NetSceneWebSearchAiScanImageRetrieval scene:%s requestKey:%s", new Object[] { Integer.valueOf(params.scene), params.dlu });
    params = new b.a();
    params.funcId = 1532;
    params.uri = "/cgi-bin/mmbiz-bin/usrmsg/aiscan_image_retrieval";
    params.hNM = this.DBw;
    params.hNN = this.DBx;
    this.hWL = params.aDC();
    AppMethodBeat.o(217637);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(217639);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(217639);
    return i;
  }
  
  public final String eLN()
  {
    return this.DBx.FFt;
  }
  
  public final int eLO()
  {
    return 0;
  }
  
  public final eem eLX()
  {
    return this.DBx;
  }
  
  public final s eLY()
  {
    return this.DBv;
  }
  
  public final int getType()
  {
    return 1532;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(217638);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.WebSearch.NetSceneWebSearchAiScanImageRetrieval", "netId: %s errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      this.DBx = ((eem)this.hWL.hNL.hNQ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(217638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.w
 * JD-Core Version:    0.7.0.1
 */