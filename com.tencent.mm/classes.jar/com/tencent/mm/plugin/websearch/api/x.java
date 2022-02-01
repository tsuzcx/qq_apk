package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.eeo;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;

public final class x
  extends n
  implements k
{
  eeo DBy;
  eep DBz;
  private f callback;
  private b hWL;
  
  public x(int paramInt)
  {
    AppMethodBeat.i(117635);
    this.DBy = new eeo();
    b.a locala = new b.a();
    locala.funcId = 1948;
    locala.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
    locala.hNM = new eeo();
    locala.hNN = new eep();
    this.hWL = locala.aDC();
    this.DBy = ((eeo)this.hWL.hNK.hNQ);
    this.DBy.GDa = ad.We(0);
    this.DBy.qei = ac.iM(aj.getContext());
    this.DBy.orm = ad.Ux();
    this.DBy.GRt = ad.bNG();
    this.DBy.Scene = paramInt;
    this.DBy.FMq = 0L;
    AppMethodBeat.o(117635);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(117636);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.NetSceneWebSearchConfig", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(117637);
      return;
    }
    this.DBz = ((eep)this.hWL.hNL.hNQ);
    if (this.DBz != null) {
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.NetSceneWebSearchConfig", "return data\n%s", new Object[] { this.DBz.GDb });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.x
 * JD-Core Version:    0.7.0.1
 */