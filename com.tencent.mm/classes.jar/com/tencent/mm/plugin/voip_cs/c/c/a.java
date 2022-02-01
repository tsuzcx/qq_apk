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
import com.tencent.mm.protocal.protobuf.dre;
import com.tencent.mm.protocal.protobuf.drf;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends n
  implements k
{
  private g callback;
  public b rr;
  
  public a(int paramInt1, long paramLong1, long paramLong2, String paramString, int paramInt2)
  {
    AppMethodBeat.i(125422);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dre();
    ((b.a)localObject).hvu = new drf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoiphangup";
    ((b.a)localObject).funcId = 880;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dre)this.rr.hvr.hvw;
    ((dre)localObject).FvR = paramInt1;
    ((dre)localObject).FOh = paramLong1;
    ((dre)localObject).Exg = paramLong2;
    ((dre)localObject).FYS = paramString;
    ((dre)localObject).DUB = paramInt2;
    ((dre)localObject).FvQ = System.currentTimeMillis();
    AppMethodBeat.o(125422);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(125423);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(125423);
    return i;
  }
  
  public final int getType()
  {
    return 880;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125424);
    ac.i("MicroMsg.NetSceneVoipCSHangUp", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.a
 * JD-Core Version:    0.7.0.1
 */