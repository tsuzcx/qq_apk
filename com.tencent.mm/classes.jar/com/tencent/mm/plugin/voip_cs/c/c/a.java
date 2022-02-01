package com.tencent.mm.plugin.voip_cs.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fdh;
import com.tencent.mm.protocal.protobuf.fdi;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public a(int paramInt1, long paramLong1, long paramLong2, String paramString, int paramInt2)
  {
    AppMethodBeat.i(125422);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new fdh();
    ((d.a)localObject).lBV = new fdi();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoiphangup";
    ((d.a)localObject).funcId = 880;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (fdh)d.b.b(this.rr.lBR);
    ((fdh)localObject).TWa = paramInt1;
    ((fdh)localObject).Urf = paramLong1;
    ((fdh)localObject).Svv = paramLong2;
    ((fdh)localObject).UDq = paramString;
    ((fdh)localObject).RNa = paramInt2;
    ((fdh)localObject).TVZ = System.currentTimeMillis();
    AppMethodBeat.o(125422);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(125423);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(125423);
    return i;
  }
  
  public final int getType()
  {
    return 880;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125424);
    Log.i("MicroMsg.NetSceneVoipCSHangUp", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.a
 * JD-Core Version:    0.7.0.1
 */