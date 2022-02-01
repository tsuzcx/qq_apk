package com.tencent.mm.plugin.voip_cs.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.etd;
import com.tencent.mm.protocal.protobuf.ete;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  private i callback;
  public com.tencent.mm.ak.d rr;
  
  public d(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(125431);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new etd();
    ((d.a)localObject).iLO = new ete();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipredirect";
    ((d.a)localObject).funcId = 285;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (etd)this.rr.iLK.iLR;
    ((etd)localObject).NeG = paramLong1;
    ((etd)localObject).Lta = paramLong2;
    ((etd)localObject).MKf = System.currentTimeMillis();
    AppMethodBeat.o(125431);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(125433);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(125433);
    return i;
  }
  
  public final int getType()
  {
    return 285;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125432);
    Log.i("MicroMsg.NetSceneVoipCSRedirect", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.d
 * JD-Core Version:    0.7.0.1
 */