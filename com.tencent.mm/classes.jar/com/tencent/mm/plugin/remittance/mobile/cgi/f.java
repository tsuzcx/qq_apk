package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dqj;
import com.tencent.mm.protocal.protobuf.dqk;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
  extends n
  implements k
{
  private final String TAG;
  private com.tencent.mm.ak.f callback;
  private b gRX;
  private dqk ylb;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(67653);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dqj();
    ((b.a)localObject).hQG = new dqk();
    ((b.a)localObject).funcId = 2817;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonepaycheck";
    this.gRX = ((b.a)localObject).aDS();
    localObject = (dqj)this.gRX.hQD.hQJ;
    ((dqj)localObject).dwj = paramString1;
    ((dqj)localObject).ypa = paramString2;
    ((dqj)localObject).yoZ = paramString3;
    ((dqj)localObject).yoT = paramString4;
    ((dqj)localObject).yrf = paramLong;
    ((dqj)localObject).GmU = paramString5;
    ((dqj)localObject).HWW = paramString6;
    ((dqj)localObject).HXn = paramString7;
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitPayCheck reqKey:%s transferId:%s transactionId:%s receiverOpenid:%s fee:%s extendStr:%s rcvrToken:%s placeorderToken:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Long.valueOf(paramLong), paramString5, paramString6, paramString7 });
    AppMethodBeat.o(67653);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(67655);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(67655);
    return i;
  }
  
  public final int getType()
  {
    return 2817;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67654);
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.ylb = ((dqk)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ylb.dmy), this.ylb.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.f
 * JD-Core Version:    0.7.0.1
 */