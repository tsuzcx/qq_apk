package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.edz;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.sdk.platformtools.ad;

public final class t
  extends n
  implements k
{
  private f callback;
  public int dCT;
  public String dwW;
  public b rr;
  private long soX;
  
  public t(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(117624);
    this.dCT = paramInt;
    this.soX = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchwebquery";
    ((b.a)localObject).hNM = new edz();
    ((b.a)localObject).hNN = new eea();
    this.rr = ((b.a)localObject).aDC();
    localObject = (edz)this.rr.hNK.hNQ;
    ((edz)localObject).HPl = paramString2;
    ((edz)localObject).dwW = paramString1;
    this.dwW = paramString1;
    AppMethodBeat.o(117624);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(117625);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(117625);
    return i;
  }
  
  public final int getType()
  {
    return 2975;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117626);
    ad.i("MicroMsg.WebSearch.NetSceneSearchWebQuery", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.soX) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.t
 * JD-Core Version:    0.7.0.1
 */