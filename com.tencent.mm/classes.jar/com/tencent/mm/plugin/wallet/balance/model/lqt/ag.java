package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cfu;
import com.tencent.mm.protocal.protobuf.cfv;
import com.tencent.mm.sdk.platformtools.ad;

public final class ag
  extends n
  implements k
{
  private cfu Cyw;
  public cfv Cyx;
  private f callback;
  private b gPp;
  
  public ag(String paramString1, String paramString2)
  {
    AppMethodBeat.i(68553);
    b.a locala = new b.a();
    locala.hNM = new cfu();
    locala.hNN = new cfv();
    locala.funcId = 2996;
    locala.uri = "/cgi-bin/mmpay-bin/openlqbaccount";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.gPp = locala.aDC();
    this.Cyw = ((cfu)this.gPp.hNK.hNQ);
    this.Cyw.FDo = paramString1;
    this.Cyw.FIQ = paramString2;
    this.Cyw.Cyu = ae.eCl();
    ad.i("MicroMsg.NetSceneOpenLqbAccount", "NetSceneOpenLqbAccount, eCardType: %s, extraData: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(68553);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(68554);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
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
    ad.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.Cyx = ((cfv)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.Cyx.ozR), this.Cyx.ozS });
    if (this.Cyx.ozR == 0) {
      ae.aDQ(this.Cyx.Cyu);
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