package com.tencent.mm.plugin.voip_cs.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dxk;
import com.tencent.mm.protocal.protobuf.dxl;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  public b rr;
  
  public f(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(125437);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dxk();
    ((b.a)localObject).hNN = new dxl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipsync";
    ((b.a)localObject).funcId = 818;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dxk)this.rr.hNK.hNQ;
    ((dxk)localObject).HyS = paramLong1;
    ((dxk)localObject).GeJ = paramLong2;
    ((dxk)localObject).HJW = paramInt;
    ((dxk)localObject).HfW = System.currentTimeMillis();
    AppMethodBeat.o(125437);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(125439);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(125439);
    return i;
  }
  
  public final int getType()
  {
    return 818;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125438);
    ad.i("MicroMsg.NetSceneVoipCSSync", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.f
 * JD-Core Version:    0.7.0.1
 */