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
import com.tencent.mm.protocal.protobuf.eti;
import com.tencent.mm.protocal.protobuf.etj;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public f(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(125437);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new eti();
    ((d.a)localObject).iLO = new etj();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipsync";
    ((d.a)localObject).funcId = 818;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (eti)this.rr.iLK.iLR;
    ((eti)localObject).NeG = paramLong1;
    ((eti)localObject).Lta = paramLong2;
    ((eti)localObject).NqC = paramInt;
    ((eti)localObject).MKf = System.currentTimeMillis();
    AppMethodBeat.o(125437);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(125439);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(125439);
    return i;
  }
  
  public final int getType()
  {
    return 818;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125438);
    Log.i("MicroMsg.NetSceneVoipCSSync", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.f
 * JD-Core Version:    0.7.0.1
 */