package com.tencent.mm.plugin.voip_cs.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eta;
import com.tencent.mm.protocal.protobuf.etb;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public c(int paramInt1, String paramString1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString2)
  {
    AppMethodBeat.i(125428);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new eta();
    ((d.a)localObject).iLO = new etb();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipinvite";
    ((d.a)localObject).funcId = 823;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (eta)this.rr.iLK.iLR;
    ((eta)localObject).MKg = paramInt1;
    ((eta)localObject).Nqu = paramString1;
    ((eta)localObject).Llx = paramInt2;
    ((eta)localObject).Nqv = b.cD(paramArrayOfByte1);
    ((eta)localObject).Nqw = b.cD(paramArrayOfByte2);
    ((eta)localObject).MKf = System.currentTimeMillis();
    if ((paramString2 != null) && (!paramString2.equals(""))) {
      ((eta)localObject).Nqx = paramString2;
    }
    AppMethodBeat.o(125428);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(125430);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(125430);
    return i;
  }
  
  public final int getType()
  {
    return 823;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125429);
    Log.i("MicroMsg.NetSceneVoipCSInvite", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.c
 * JD-Core Version:    0.7.0.1
 */