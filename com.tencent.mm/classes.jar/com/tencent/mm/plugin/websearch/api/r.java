package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dsi;
import com.tencent.mm.protocal.protobuf.dsj;
import com.tencent.mm.sdk.platformtools.ad;

public final class r
  extends n
  implements k
{
  private g callback;
  public String dnB;
  public int dtt;
  public b rr;
  private long yLW;
  
  public r(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(117624);
    this.dtt = paramInt;
    this.yLW = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchwebquery";
    ((b.a)localObject).gUU = new dsi();
    ((b.a)localObject).gUV = new dsj();
    this.rr = ((b.a)localObject).atI();
    localObject = (dsi)this.rr.gUS.gUX;
    ((dsi)localObject).EGT = paramString2;
    ((dsi)localObject).dnB = paramString1;
    this.dnB = paramString1;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117626);
    ad.i("MicroMsg.WebSearch.NetSceneSearchWebQuery", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.yLW) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.r
 * JD-Core Version:    0.7.0.1
 */