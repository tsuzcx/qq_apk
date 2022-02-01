package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.eeu;
import com.tencent.mm.protocal.protobuf.eev;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends q
  implements m
{
  public String AZw;
  private i callback;
  private d rr;
  
  public k(dyy paramdyy)
  {
    AppMethodBeat.i(66903);
    d.a locala = new d.a();
    locala.iLN = new eeu();
    locala.iLO = new eev();
    locala.uri = "/cgi-bin/micromsg-bin/submitmallfreeorder";
    locala.funcId = 557;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((eeu)this.rr.iLK.iLR).NeQ = paramdyy;
    AppMethodBeat.o(66903);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(66905);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66905);
    return i;
  }
  
  public final int getType()
  {
    return 557;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66904);
    params = (eev)((d)params).iLL.iLR;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "resp.PrepareId " + params.NeR);
      this.AZw = params.NeR;
    }
    Log.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(66904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.k
 * JD-Core Version:    0.7.0.1
 */