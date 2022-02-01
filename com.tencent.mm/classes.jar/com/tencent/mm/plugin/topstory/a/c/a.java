package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dsi;
import com.tencent.mm.protocal.protobuf.dsj;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private g callback;
  public String dnB;
  private b rr;
  private long yLW;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88477);
    this.yLW = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchwebcomm";
    ((b.a)localObject).gUU = new dsi();
    ((b.a)localObject).gUV = new dsj();
    this.rr = ((b.a)localObject).atI();
    localObject = (dsi)this.rr.gUS.gUX;
    ((dsi)localObject).EGT = paramString2;
    ((dsi)localObject).dnB = paramString1;
    this.dnB = paramString1;
    AppMethodBeat.o(88477);
  }
  
  public final dsj dOc()
  {
    return (dsj)this.rr.gUT.gUX;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(88478);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88478);
    return i;
  }
  
  public final int getType()
  {
    return 2582;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88479);
    ad.i("MicroMsg.TopStory.NetSceneSearchWebComm", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.yLW) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.a
 * JD-Core Version:    0.7.0.1
 */