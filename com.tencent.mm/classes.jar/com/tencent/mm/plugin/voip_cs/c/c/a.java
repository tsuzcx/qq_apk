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
import com.tencent.mm.protocal.protobuf.esw;
import com.tencent.mm.protocal.protobuf.esx;
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
    ((d.a)localObject).iLN = new esw();
    ((d.a)localObject).iLO = new esx();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoiphangup";
    ((d.a)localObject).funcId = 880;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (esw)this.rr.iLK.iLR;
    ((esw)localObject).MKg = paramInt1;
    ((esw)localObject).NeG = paramLong1;
    ((esw)localObject).Lta = paramLong2;
    ((esw)localObject).Nqu = paramString;
    ((esw)localObject).KMd = paramInt2;
    ((esw)localObject).MKf = System.currentTimeMillis();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.a
 * JD-Core Version:    0.7.0.1
 */