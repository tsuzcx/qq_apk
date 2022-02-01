package com.tencent.mm.plugin.voip_cs.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dlr;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  private g callback;
  public com.tencent.mm.al.b rr;
  
  public c(int paramInt1, String paramString1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString2)
  {
    AppMethodBeat.i(125428);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dlr();
    ((b.a)localObject).gUV = new dls();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipinvite";
    ((b.a)localObject).funcId = 823;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (dlr)this.rr.gUS.gUX;
    ((dlr)localObject).DYV = paramInt1;
    ((dlr)localObject).EBF = paramString1;
    ((dlr)localObject).CYi = paramInt2;
    ((dlr)localObject).EBG = com.tencent.mm.bx.b.cd(paramArrayOfByte1);
    ((dlr)localObject).EBH = com.tencent.mm.bx.b.cd(paramArrayOfByte2);
    ((dlr)localObject).DYU = System.currentTimeMillis();
    if ((paramString2 != null) && (!paramString2.equals(""))) {
      ((dlr)localObject).EBI = paramString2;
    }
    AppMethodBeat.o(125428);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(125430);
    this.callback = paramg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.c
 * JD-Core Version:    0.7.0.1
 */