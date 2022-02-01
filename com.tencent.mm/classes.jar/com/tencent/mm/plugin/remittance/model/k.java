package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.protocal.protobuf.ox;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private b iaa;
  public ox vAl;
  
  public k(dh paramdh, String paramString)
  {
    AppMethodBeat.i(67857);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ow();
    ((b.a)localObject).gUV = new ox();
    ((b.a)localObject).funcId = 2702;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2funlockfavor";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.iaa = ((b.a)localObject).atI();
    localObject = (ow)this.iaa.gUS.gUX;
    ((ow)localObject).CMn = paramdh;
    ((ow)localObject).CMF = paramString;
    h.vKh.dB(886, 0);
    ad.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "NetSceneBusiF2fUnlockFavor, f2fId: %s, transId: %s, amount: %s", new Object[] { paramdh.CxW, paramdh.CxX, Integer.valueOf(paramdh.Cya) });
    AppMethodBeat.o(67857);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67858);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
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
    this.vAl = ((ox)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.vAl.ntx), this.vAl.nty });
    h.vKh.dB(886, 1);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.k
 * JD-Core Version:    0.7.0.1
 */