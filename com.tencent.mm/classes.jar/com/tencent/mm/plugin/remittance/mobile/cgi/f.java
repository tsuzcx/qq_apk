package com.tencent.mm.plugin.remittance.mobile.cgi;

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
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.protocal.protobuf.dej;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends n
  implements k
{
  private final String TAG;
  private g callback;
  private b iaa;
  private dej vxw;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(67653);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dei();
    ((b.a)localObject).gUV = new dej();
    ((b.a)localObject).funcId = 2817;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonepaycheck";
    this.iaa = ((b.a)localObject).atI();
    localObject = (dei)this.iaa.gUS.gUX;
    ((dei)localObject).dlJ = paramString1;
    ((dei)localObject).vBw = paramString2;
    ((dei)localObject).vBv = paramString3;
    ((dei)localObject).vBp = paramString4;
    ((dei)localObject).vDB = paramLong;
    ((dei)localObject).CUC = paramString5;
    ((dei)localObject).Evx = paramString6;
    ((dei)localObject).EvO = paramString7;
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitPayCheck reqKey:%s transferId:%s transactionId:%s receiverOpenid:%s fee:%s extendStr:%s rcvrToken:%s placeorderToken:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Long.valueOf(paramLong), paramString5, paramString6, paramString7 });
    AppMethodBeat.o(67653);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67655);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
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
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.vxw = ((dej)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.vxw.dcG), this.vxw.nTK });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.f
 * JD-Core Version:    0.7.0.1
 */