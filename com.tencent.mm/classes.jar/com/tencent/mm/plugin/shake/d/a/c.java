package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ceh;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public c(int paramInt, String paramString)
  {
    AppMethodBeat.i(28277);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ceh();
    ((b.a)localObject).hNN = new cei();
    ((b.a)localObject).uri = "/cgi-bin/mmoctv/optvhist";
    ((b.a)localObject).funcId = 1740;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ceh)this.rr.hNK.hNQ;
    ((ceh)localObject).gsV = paramInt;
    ((ceh)localObject).GYn = paramString;
    AppMethodBeat.o(28277);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(28279);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(28279);
    return i;
  }
  
  public final int getType()
  {
    return 1740;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28278);
    ad.i("MicroMsg.NetSceneOpTvHist", "onGYNetEnd [%d,%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.c
 * JD-Core Version:    0.7.0.1
 */