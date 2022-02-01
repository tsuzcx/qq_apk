package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ekf;
import com.tencent.mm.protocal.protobuf.ekg;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends q
  implements m
{
  private ekg Cmb;
  private final String TAG;
  private i callback;
  private d hJu;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(67653);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ekf();
    ((d.a)localObject).iLO = new ekg();
    ((d.a)localObject).funcId = 2817;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonepaycheck";
    this.hJu = ((d.a)localObject).aXF();
    localObject = (ekf)this.hJu.iLK.iLR;
    ((ekf)localObject).dNQ = paramString1;
    ((ekf)localObject).CpQ = paramString2;
    ((ekf)localObject).CpP = paramString3;
    ((ekf)localObject).CpJ = paramString4;
    ((ekf)localObject).CrW = paramLong;
    ((ekf)localObject).Lhy = paramString5;
    ((ekf)localObject).Njc = paramString6;
    ((ekf)localObject).Njt = paramString7;
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitPayCheck reqKey:%s transferId:%s transactionId:%s receiverOpenid:%s fee:%s extendStr:%s rcvrToken:%s placeorderToken:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Long.valueOf(paramLong), paramString5, paramString6, paramString7 });
    AppMethodBeat.o(67653);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67655);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(67655);
    return i;
  }
  
  public final int getType()
  {
    return 2817;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67654);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Cmb = ((ekg)((d)params).iLL.iLR);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Cmb.dDN), this.Cmb.qwn });
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