package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.dxz;
import com.tencent.mm.protocal.protobuf.dya;
import com.tencent.mm.sdk.platformtools.ac;

public final class q
  extends n
  implements k
{
  private g callback;
  public String dlj;
  public int drc;
  public b rr;
  private long rxC;
  
  public q(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(117624);
    this.drc = paramInt;
    this.rxC = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchwebquery";
    ((b.a)localObject).hvt = new dxz();
    ((b.a)localObject).hvu = new dya();
    this.rr = ((b.a)localObject).aAz();
    localObject = (dxz)this.rr.hvr.hvw;
    ((dxz)localObject).Gef = paramString2;
    ((dxz)localObject).dlj = paramString1;
    this.dlj = paramString1;
    AppMethodBeat.o(117624);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(117625);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(117625);
    return i;
  }
  
  public final int getType()
  {
    return 2975;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117626);
    ac.i("MicroMsg.WebSearch.NetSceneSearchWebQuery", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.rxC) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.q
 * JD-Core Version:    0.7.0.1
 */