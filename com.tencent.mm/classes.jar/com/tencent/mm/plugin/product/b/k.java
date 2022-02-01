package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.dez;
import com.tencent.mm.protocal.protobuf.dfa;
import com.tencent.mm.sdk.platformtools.ac;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private b rr;
  public String vFa;
  
  public k(czk paramczk)
  {
    AppMethodBeat.i(66903);
    b.a locala = new b.a();
    locala.hvt = new dez();
    locala.hvu = new dfa();
    locala.uri = "/cgi-bin/micromsg-bin/submitmallfreeorder";
    locala.funcId = 557;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((dez)this.rr.hvr.hvw).FOr = paramczk;
    AppMethodBeat.o(66903);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(66905);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(66905);
    return i;
  }
  
  public final int getType()
  {
    return 557;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66904);
    paramq = (dfa)((b)paramq).hvs.hvw;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ac.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "resp.PrepareId " + paramq.FOs);
      this.vFa = paramq.FOs;
    }
    ac.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(66904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.k
 * JD-Core Version:    0.7.0.1
 */