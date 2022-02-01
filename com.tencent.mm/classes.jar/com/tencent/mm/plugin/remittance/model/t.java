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
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.protocal.protobuf.tk;
import com.tencent.mm.sdk.platformtools.ad;

public final class t
  extends n
  implements k
{
  private g callback;
  private b iaa;
  public tk vAz;
  
  public t(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    AppMethodBeat.i(67877);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new tj();
    ((b.a)localObject).gUV = new tk();
    ((b.a)localObject).funcId = 1779;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferoldpaycheck";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.iaa = ((b.a)localObject).atI();
    localObject = (tj)this.iaa.gUS.gUX;
    ((tj)localObject).dlJ = paramString1;
    ((tj)localObject).vBw = paramString2;
    ((tj)localObject).vBv = paramString3;
    ((tj)localObject).vBp = paramString4;
    ((tj)localObject).vDB = paramLong;
    ((tj)localObject).CUC = paramString5;
    ad.i("MicroMsg.NetSceneRemittancePayCheck", "reqKey: %s, transfer: %s, fee: %s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong) });
    AppMethodBeat.o(67877);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67878);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
    AppMethodBeat.o(67878);
    return i;
  }
  
  public final int getType()
  {
    return 1779;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67879);
    ad.i("MicroMsg.NetSceneRemittancePayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.vAz = ((tk)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneRemittancePayCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.vAz.dcG), this.vAz.nTK });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.t
 * JD-Core Version:    0.7.0.1
 */