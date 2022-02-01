package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public c(int paramInt, String paramString)
  {
    AppMethodBeat.i(28277);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cvi();
    ((d.a)localObject).iLO = new cvj();
    ((d.a)localObject).uri = "/cgi-bin/mmoctv/optvhist";
    ((d.a)localObject).funcId = 1740;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cvi)this.rr.iLK.iLR;
    ((cvi)localObject).him = paramInt;
    ((cvi)localObject).MAK = paramString;
    AppMethodBeat.o(28277);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(28279);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(28279);
    return i;
  }
  
  public final int getType()
  {
    return 1740;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28278);
    Log.i("MicroMsg.NetSceneOpTvHist", "onGYNetEnd [%d,%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.c
 * JD-Core Version:    0.7.0.1
 */