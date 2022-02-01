package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.sdk.platformtools.ac;

public final class ag
  extends n
  implements k
{
  private cbd AYn;
  public cbe AYo;
  private g callback;
  private b gvE;
  
  public ag(String paramString1, String paramString2)
  {
    AppMethodBeat.i(68553);
    b.a locala = new b.a();
    locala.hvt = new cbd();
    locala.hvu = new cbe();
    locala.funcId = 2996;
    locala.uri = "/cgi-bin/mmpay-bin/openlqbaccount";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gvE = locala.aAz();
    this.AYn = ((cbd)this.gvE.hvr.hvw);
    this.AYn.DXS = paramString1;
    this.AYn.Fps = paramString2;
    this.AYn.AYl = ae.eon();
    ac.i("MicroMsg.NetSceneOpenLqbAccount", "NetSceneOpenLqbAccount, eCardType: %s, extraData: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(68553);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(68554);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(68554);
    return i;
  }
  
  public final int getType()
  {
    return 2996;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(68555);
    ac.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.AYo = ((cbe)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.AYo.nWx), this.AYo.nWy });
    if (this.AYo.nWx == 0) {
      ae.ayI(this.AYo.AYl);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(68555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ag
 * JD-Core Version:    0.7.0.1
 */