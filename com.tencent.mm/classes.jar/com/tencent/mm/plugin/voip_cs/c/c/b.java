package com.tencent.mm.plugin.voip_cs.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.drg;
import com.tencent.mm.protocal.protobuf.drh;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.ak.b rr;
  
  public b(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(125425);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new drg();
    ((b.a)localObject).hvu = new drh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipheartbeat";
    ((b.a)localObject).funcId = 795;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (drg)this.rr.hvr.hvw;
    ((drg)localObject).FOh = paramLong1;
    ((drg)localObject).Exg = paramLong2;
    ((drg)localObject).FvQ = System.currentTimeMillis();
    AppMethodBeat.o(125425);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(125427);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(125427);
    return i;
  }
  
  public final int getType()
  {
    return 795;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125426);
    ac.i("MicroMsg.NetSceneVoipCSHeartBeat", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.b
 * JD-Core Version:    0.7.0.1
 */