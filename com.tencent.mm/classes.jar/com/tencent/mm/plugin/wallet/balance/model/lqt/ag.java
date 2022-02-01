package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cgo;
import com.tencent.mm.protocal.protobuf.cgp;

public final class ag
  extends n
  implements k
{
  private cgo CQb;
  public cgp CQc;
  private f callback;
  private b gRX;
  
  public ag(String paramString1, String paramString2)
  {
    AppMethodBeat.i(68553);
    b.a locala = new b.a();
    locala.hQF = new cgo();
    locala.hQG = new cgp();
    locala.funcId = 2996;
    locala.uri = "/cgi-bin/mmpay-bin/openlqbaccount";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.gRX = locala.aDS();
    this.CQb = ((cgo)this.gRX.hQD.hQJ);
    this.CQb.FVJ = paramString1;
    this.CQb.Gbn = paramString2;
    this.CQb.CPZ = ae.eFT();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneOpenLqbAccount", "NetSceneOpenLqbAccount, eCardType: %s, extraData: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(68553);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(68554);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.CQc = ((cgp)((b)paramq).hQE.hQJ);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.CQc.oGt), this.CQc.oGu });
    if (this.CQc.oGt == 0) {
      ae.aFj(this.CQc.CPZ);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(68555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ag
 * JD-Core Version:    0.7.0.1
 */