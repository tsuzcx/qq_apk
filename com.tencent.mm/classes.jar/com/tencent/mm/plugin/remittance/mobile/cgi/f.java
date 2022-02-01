package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dpm;
import com.tencent.mm.protocal.protobuf.dpn;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends n
  implements k
{
  private final String TAG;
  private com.tencent.mm.al.f callback;
  private b gPp;
  private dpn xVi;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(67653);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dpm();
    ((b.a)localObject).hNN = new dpn();
    ((b.a)localObject).funcId = 2817;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonepaycheck";
    this.gPp = ((b.a)localObject).aDC();
    localObject = (dpm)this.gPp.hNK.hNQ;
    ((dpm)localObject).dve = paramString1;
    ((dpm)localObject).xZi = paramString2;
    ((dpm)localObject).xZh = paramString3;
    ((dpm)localObject).xZb = paramString4;
    ((dpm)localObject).ybo = paramLong;
    ((dpm)localObject).FUv = paramString5;
    ((dpm)localObject).HDj = paramString6;
    ((dpm)localObject).HDA = paramString7;
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitPayCheck reqKey:%s transferId:%s transactionId:%s receiverOpenid:%s fee:%s extendStr:%s rcvrToken:%s placeorderToken:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Long.valueOf(paramLong), paramString5, paramString6, paramString7 });
    AppMethodBeat.o(67653);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(67655);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
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
    this.xVi = ((dpn)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.xVi.dlw), this.xVi.paA });
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