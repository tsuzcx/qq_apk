package com.tencent.mm.plugin.remittance.model;

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
import com.tencent.mm.protocal.protobuf.vq;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.sdk.platformtools.ae;

public final class t
  extends n
  implements k
{
  private f callback;
  private b gRX;
  public vr yod;
  
  public t(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    AppMethodBeat.i(67877);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new vq();
    ((b.a)localObject).hQG = new vr();
    ((b.a)localObject).funcId = 1779;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferoldpaycheck";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gRX = ((b.a)localObject).aDS();
    localObject = (vq)this.gRX.hQD.hQJ;
    ((vq)localObject).dwj = paramString1;
    ((vq)localObject).ypa = paramString2;
    ((vq)localObject).yoZ = paramString3;
    ((vq)localObject).yoT = paramString4;
    ((vq)localObject).yrf = paramLong;
    ((vq)localObject).GmU = paramString5;
    ae.i("MicroMsg.NetSceneRemittancePayCheck", "reqKey: %s, transfer: %s, fee: %s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong) });
    AppMethodBeat.o(67877);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67878);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
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
    ae.i("MicroMsg.NetSceneRemittancePayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.yod = ((vr)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneRemittancePayCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.yod.dmy), this.yod.phe });
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