package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.bis;

public final class p
  extends a
  implements k
{
  private bis DSS;
  private f callback;
  private com.tencent.mm.ak.b hZD;
  
  public p(s params)
  {
    AppMethodBeat.i(188464);
    bir localbir = new bir();
    localbir.Scene = params.scene;
    localbir.GWz = params.dmw;
    localbir.GWA = ad.WL(0);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.WebSearch.NetSceneGetSearchResult", "create NetSceneGetSearchResult scene:%s requestKey:%s", new Object[] { Integer.valueOf(params.scene), params.dmw });
    params = new b.a();
    params.funcId = 1003;
    params.uri = "/cgi-bin/mmsearch-bin/getsearchresult";
    params.hQF = localbir;
    params.hQG = new bis();
    this.hZD = params.aDS();
    AppMethodBeat.o(188464);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(188465);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(188465);
    return i;
  }
  
  public final String ePw()
  {
    if (this.DSS != null) {
      return this.DSS.GWB;
    }
    return null;
  }
  
  public final int ePx()
  {
    return 0;
  }
  
  public final int getType()
  {
    return 1003;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(188466);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.WebSearch.NetSceneGetSearchResult", "netId: %s errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.DSS = ((bis)this.hZD.hQE.hQJ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(188466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.p
 * JD-Core Version:    0.7.0.1
 */