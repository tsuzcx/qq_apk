package com.tencent.mm.plugin.voip_cs.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dxc;
import com.tencent.mm.protocal.protobuf.dxd;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  private f callback;
  public com.tencent.mm.al.b rr;
  
  public c(int paramInt1, String paramString1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString2)
  {
    AppMethodBeat.i(125428);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dxc();
    ((b.a)localObject).hNN = new dxd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipinvite";
    ((b.a)localObject).funcId = 823;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dxc)this.rr.hNK.hNQ;
    ((dxc)localObject).HfX = paramInt1;
    ((dxc)localObject).HJO = paramString1;
    ((dxc)localObject).FYc = paramInt2;
    ((dxc)localObject).HJP = com.tencent.mm.bx.b.cj(paramArrayOfByte1);
    ((dxc)localObject).HJQ = com.tencent.mm.bx.b.cj(paramArrayOfByte2);
    ((dxc)localObject).HfW = System.currentTimeMillis();
    if ((paramString2 != null) && (!paramString2.equals(""))) {
      ((dxc)localObject).HJR = paramString2;
    }
    AppMethodBeat.o(125428);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(125430);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(125430);
    return i;
  }
  
  public final int getType()
  {
    return 823;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125429);
    ad.i("MicroMsg.NetSceneVoipCSInvite", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.c
 * JD-Core Version:    0.7.0.1
 */