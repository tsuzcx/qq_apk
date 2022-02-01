package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.protocal.protobuf.qi;
import com.tencent.mm.protocal.protobuf.qj;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private b gPp;
  public qj xXX;
  
  public k(dk paramdk, String paramString)
  {
    AppMethodBeat.i(67857);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new qi();
    ((b.a)localObject).hNN = new qj();
    ((b.a)localObject).funcId = 2702;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2funlockfavor";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gPp = ((b.a)localObject).aDC();
    localObject = (qi)this.gPp.hNK.hNQ;
    ((qi)localObject).FLo = paramdk;
    ((qi)localObject).FLG = paramString;
    g.yhR.dD(886, 0);
    ad.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "NetSceneBusiF2fUnlockFavor, f2fId: %s, transId: %s, amount: %s", new Object[] { paramdk.FvH, paramdk.FvI, Integer.valueOf(paramdk.FvL) });
    AppMethodBeat.o(67857);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67858);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(67858);
    return i;
  }
  
  public final int getType()
  {
    return 2702;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67859);
    ad.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.xXX = ((qj)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.xXX.ozR), this.xXX.ozS });
    g.yhR.dD(886, 1);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.k
 * JD-Core Version:    0.7.0.1
 */