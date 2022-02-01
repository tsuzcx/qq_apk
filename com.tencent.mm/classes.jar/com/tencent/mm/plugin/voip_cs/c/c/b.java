package com.tencent.mm.plugin.voip_cs.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.protocal.protobuf.esz;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public b(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(125425);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new esy();
    ((d.a)localObject).iLO = new esz();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipheartbeat";
    ((d.a)localObject).funcId = 795;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (esy)this.rr.iLK.iLR;
    ((esy)localObject).NeG = paramLong1;
    ((esy)localObject).Lta = paramLong2;
    ((esy)localObject).MKf = System.currentTimeMillis();
    AppMethodBeat.o(125425);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(125427);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(125427);
    return i;
  }
  
  public final int getType()
  {
    return 795;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125426);
    Log.i("MicroMsg.NetSceneVoipCSHeartBeat", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.b
 * JD-Core Version:    0.7.0.1
 */