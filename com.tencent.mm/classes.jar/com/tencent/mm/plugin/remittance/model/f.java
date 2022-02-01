package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.al.b iaa;
  public ol vzZ;
  
  public f(String paramString1, String paramString2, String paramString3, int paramInt, com.tencent.mm.bx.b paramb, String paramString4)
  {
    AppMethodBeat.i(67840);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ok();
    ((b.a)localObject).gUV = new ol();
    ((b.a)localObject).funcId = 1680;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2factqry";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.iaa = ((b.a)localObject).atI();
    localObject = (ok)this.iaa.gUS.gUX;
    ((ok)localObject).vBp = paramString3;
    ((ok)localObject).CxW = paramString1;
    ((ok)localObject).CxX = paramString2;
    ((ok)localObject).Cya = paramInt;
    ((ok)localObject).CMb = paramb;
    ((ok)localObject).CxY = paramString4;
    ad.i("MicroMsg.NetSceneBusiF2fActQry", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(67840);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67841);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
    AppMethodBeat.o(67841);
    return i;
  }
  
  public final int getType()
  {
    return 1680;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67842);
    ad.i("MicroMsg.NetSceneBusiF2fActQry", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.vzZ = ((ol)((com.tencent.mm.al.b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneBusiF2fActQry", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.vzZ.ntx), this.vzZ.nty });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.f
 * JD-Core Version:    0.7.0.1
 */