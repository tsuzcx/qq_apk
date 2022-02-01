package com.tencent.mm.plugin.voip_cs.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.drq;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.sdk.platformtools.ac;

public final class f
  extends n
  implements k
{
  private g callback;
  public b rr;
  
  public f(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(125437);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new drq();
    ((b.a)localObject).hvu = new drr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipsync";
    ((b.a)localObject).funcId = 818;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (drq)this.rr.hvr.hvw;
    ((drq)localObject).FOh = paramLong1;
    ((drq)localObject).Exg = paramLong2;
    ((drq)localObject).FZa = paramInt;
    ((drq)localObject).FvQ = System.currentTimeMillis();
    AppMethodBeat.o(125437);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(125439);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneVoipCSSync", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.f
 * JD-Core Version:    0.7.0.1
 */