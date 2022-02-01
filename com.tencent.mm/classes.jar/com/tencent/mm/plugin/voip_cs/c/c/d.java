package com.tencent.mm.plugin.voip_cs.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dxf;
import com.tencent.mm.protocal.protobuf.dxg;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends n
  implements k
{
  private f callback;
  public b rr;
  
  public d(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(125431);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dxf();
    ((b.a)localObject).hNN = new dxg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipredirect";
    ((b.a)localObject).funcId = 285;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dxf)this.rr.hNK.hNQ;
    ((dxf)localObject).HyS = paramLong1;
    ((dxf)localObject).GeJ = paramLong2;
    ((dxf)localObject).HfW = System.currentTimeMillis();
    AppMethodBeat.o(125431);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(125433);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(125433);
    return i;
  }
  
  public final int getType()
  {
    return 285;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125432);
    ad.i("MicroMsg.NetSceneVoipCSRedirect", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.d
 * JD-Core Version:    0.7.0.1
 */