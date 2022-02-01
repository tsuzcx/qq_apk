package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.aj;

public final class o
  extends n
  implements k
{
  public cdg BYe;
  public cdf BYf;
  private g callback;
  private b hEg;
  
  public o(cdf paramcdf)
  {
    AppMethodBeat.i(117620);
    this.BYf = paramcdf;
    Object localObject = this.BYf;
    if (aj.DT()) {}
    for (int i = 1;; i = 0)
    {
      ((cdf)localObject).FrR = i;
      paramcdf.FhT = z.bJn();
      this.BYe = new cdg();
      localObject = new b.a();
      ((b.a)localObject).funcId = 1076;
      ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/pardussearch";
      ((b.a)localObject).hvt = paramcdf;
      ((b.a)localObject).hvu = this.BYe;
      this.hEg = ((b.a)localObject).aAz();
      AppMethodBeat.o(117620);
      return;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(117621);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
    AppMethodBeat.o(117621);
    return i;
  }
  
  public final int getType()
  {
    return 1076;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117622);
    ac.i("MicroMsg.FTS.NetScenePardusSearch", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.o
 * JD-Core Version:    0.7.0.1
 */