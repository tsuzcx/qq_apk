package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dym;
import com.tencent.mm.protocal.protobuf.dyn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class t
  extends n
  implements k
{
  dym BYC;
  dyn BYD;
  private g callback;
  private b hEg;
  
  public t(int paramInt)
  {
    AppMethodBeat.i(117635);
    this.BYC = new dym();
    b.a locala = new b.a();
    locala.funcId = 1948;
    locala.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
    locala.hvt = new dym();
    locala.hvu = new dyn();
    this.hEg = locala.aAz();
    this.BYC = ((dym)this.hEg.hvr.hvw);
    this.BYC.FhS = z.Ul(0);
    this.BYC.pAD = ab.iC(ai.getContext());
    this.BYC.nOG = z.dkv();
    this.BYC.FhT = z.bJn();
    this.BYC.Scene = paramInt;
    this.BYC.EfR = 0L;
    AppMethodBeat.o(117635);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(117636);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
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
    ac.i("MicroMsg.WebSearch.NetSceneWebSearchConfig", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(117637);
      return;
    }
    this.BYD = ((dyn)this.hEg.hvs.hvw);
    if (this.BYD != null) {
      ac.v("MicroMsg.WebSearch.NetSceneWebSearchConfig", "return data\n%s", new Object[] { this.BYD.FhN });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.t
 * JD-Core Version:    0.7.0.1
 */