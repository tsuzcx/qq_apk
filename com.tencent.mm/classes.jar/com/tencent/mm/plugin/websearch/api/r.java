package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cix;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.al;

public final class r
  extends n
  implements k
{
  public ciy DSU;
  public cix DSV;
  private f callback;
  private b hZD;
  
  public r(cix paramcix)
  {
    AppMethodBeat.i(117620);
    this.DSV = paramcix;
    Object localObject = this.DSV;
    if (al.isDarkMode()) {}
    for (int i = 1;; i = 0)
    {
      ((cix)localObject).Hvv = i;
      paramcix.HkU = ad.bOD();
      this.DSU = new ciy();
      localObject = new b.a();
      ((b.a)localObject).funcId = 1076;
      ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/pardussearch";
      ((b.a)localObject).hQF = paramcix;
      ((b.a)localObject).hQG = this.DSU;
      this.hZD = ((b.a)localObject).aDS();
      AppMethodBeat.o(117620);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(117621);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(117621);
    return i;
  }
  
  public final ciy ePE()
  {
    return this.DSU;
  }
  
  public final int getType()
  {
    return 1076;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117622);
    ae.i("MicroMsg.FTS.NetScenePardusSearch", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.r
 * JD-Core Version:    0.7.0.1
 */