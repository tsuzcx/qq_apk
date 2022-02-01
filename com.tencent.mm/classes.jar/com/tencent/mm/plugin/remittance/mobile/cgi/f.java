package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.djy;
import com.tencent.mm.sdk.platformtools.ac;

public final class f
  extends n
  implements k
{
  private final String TAG;
  private g callback;
  private b gvE;
  private djy wHB;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(67653);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new djx();
    ((b.a)localObject).hvu = new djy();
    ((b.a)localObject).funcId = 2817;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonepaycheck";
    this.gvE = ((b.a)localObject).aAz();
    localObject = (djx)this.gvE.hvr.hvw;
    ((djx)localObject).djr = paramString1;
    ((djx)localObject).wLB = paramString2;
    ((djx)localObject).wLA = paramString3;
    ((djx)localObject).wLu = paramString4;
    ((djx)localObject).wNG = paramLong;
    ((djx)localObject).Enm = paramString5;
    ((djx)localObject).FSA = paramString6;
    ((djx)localObject).FSR = paramString7;
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitPayCheck reqKey:%s transferId:%s transactionId:%s receiverOpenid:%s fee:%s extendStr:%s rcvrToken:%s placeorderToken:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Long.valueOf(paramLong), paramString5, paramString6, paramString7 });
    AppMethodBeat.o(67653);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67655);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
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
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.wHB = ((djy)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.wHB.dae), this.wHB.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.f
 * JD-Core Version:    0.7.0.1
 */