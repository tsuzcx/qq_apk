package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.egf;
import com.tencent.mm.protocal.protobuf.egg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class x
  extends n
  implements k
{
  egf DTv;
  egg DTw;
  private f callback;
  private b hZD;
  
  public x(int paramInt)
  {
    AppMethodBeat.i(117635);
    this.DTv = new egf();
    b.a locala = new b.a();
    locala.funcId = 1948;
    locala.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
    locala.hQF = new egf();
    locala.hQG = new egg();
    this.hZD = locala.aDS();
    this.DTv = ((egf)this.hZD.hQD.hQJ);
    this.DTv.GWA = ad.WL(0);
    this.DTv.qkN = com.tencent.mm.sdk.platformtools.ad.iR(ak.getContext());
    this.DTv.oxI = ad.UD();
    this.DTv.HkU = ad.bOD();
    this.DTv.Scene = paramInt;
    this.DTv.GeP = 0L;
    AppMethodBeat.o(117635);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(117636);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(117636);
    return i;
  }
  
  public final int getType()
  {
    return 1948;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117637);
    ae.i("MicroMsg.WebSearch.NetSceneWebSearchConfig", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(117637);
      return;
    }
    this.DTw = ((egg)this.hZD.hQE.hQJ);
    if (this.DTw != null) {
      ae.v("MicroMsg.WebSearch.NetSceneWebSearchConfig", "return data\n%s", new Object[] { this.DTw.GWB });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.x
 * JD-Core Version:    0.7.0.1
 */