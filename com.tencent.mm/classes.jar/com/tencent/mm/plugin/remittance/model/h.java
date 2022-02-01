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
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.oq;
import com.tencent.mm.protocal.protobuf.or;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends n
  implements k
{
  private g callback;
  private b iaa;
  public or vAg;
  
  public h(dh paramdh, String paramString)
  {
    AppMethodBeat.i(67846);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new oq();
    ((b.a)localObject).gUV = new or();
    ((b.a)localObject).funcId = 1241;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2fpaycheck";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.iaa = ((b.a)localObject).atI();
    localObject = (oq)this.iaa.gUS.gUX;
    ((oq)localObject).CMn = paramdh;
    ((oq)localObject).CMo = paramString;
    ad.i("MicroMsg.NetSceneBusiF2fPayCheck", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s req: %s", new Object[] { paramdh.CxW, paramdh.CxX, Integer.valueOf(paramdh.Cya), a.a(paramdh) });
    AppMethodBeat.o(67846);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67847);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
    AppMethodBeat.o(67847);
    return i;
  }
  
  public final int getType()
  {
    return 1241;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67848);
    ad.i("MicroMsg.NetSceneBusiF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.vAg = ((or)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneBusiF2fPayCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.vAg.ntx), this.vAg.nty });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.h
 * JD-Core Version:    0.7.0.1
 */