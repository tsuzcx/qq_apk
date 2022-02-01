package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dcl;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.oy;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.d.d;

public final class l
  extends n
  implements k, j, d
{
  private g callback;
  public String dcE;
  public boolean hasRetried;
  private b iaa;
  public boolean oJO;
  public oz vAm;
  private oy vAn;
  
  public l(dcl paramdcl, dh paramdh, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67860);
    this.oJO = false;
    this.hasRetried = false;
    b.a locala = new b.a();
    locala.gUU = new oy();
    locala.gUV = new oz();
    locala.funcId = 2682;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fzerocallback";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.iaa = locala.atI();
    this.vAn = ((oy)this.iaa.gUS.gUX);
    this.vAn.CMn = paramdh;
    this.vAn.CMJ = paramdcl;
    this.vAn.CMK = paramString1;
    this.vAn.CNh = paramInt;
    this.vAn.token = paramString2;
    this.dcE = paramString3;
    ad.i("MicroMsg.NetSceneBusiF2fZeroCallback", "NetSceneBusiF2fZeroCallback, token %s AfterPlaceOrderCommReq %s zero_pay_extend: %s", new Object[] { paramString2, a.a(paramdh), paramString1 });
    AppMethodBeat.o(67860);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67861);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
    AppMethodBeat.o(67861);
    return i;
  }
  
  public final boolean getHasRetried()
  {
    return this.hasRetried;
  }
  
  public final int getType()
  {
    return 2682;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67862);
    ad.i("MicroMsg.NetSceneBusiF2fZeroCallback", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.vAm = ((oz)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneBusiF2fZeroCallback", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.vAm.ntx), this.vAm.nty });
    if (this.callback != null) {
      if (this.vAm.CNi != 1) {
        break label134;
      }
    }
    label134:
    for (boolean bool = true;; bool = false)
    {
      this.oJO = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(67862);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.l
 * JD-Core Version:    0.7.0.1
 */