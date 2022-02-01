package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ekj;
import com.tencent.mm.protocal.protobuf.ekk;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends a
{
  public ekk Cma;
  private final String TAG;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6)
  {
    AppMethodBeat.i(67651);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ekj();
    ((d.a)localObject).iLO = new ekk();
    ((d.a)localObject).funcId = 1903;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonesuccpage";
    this.rr = ((d.a)localObject).aXF();
    localObject = (ekj)this.rr.iLK.iLR;
    ((ekj)localObject).KBM = paramString1;
    ((ekj)localObject).KHN = paramString2;
    ((ekj)localObject).Njb = paramString3;
    ((ekj)localObject).Njc = paramString4;
    ((ekj)localObject).yRL = paramInt;
    ((ekj)localObject).Njt = paramString5;
    ((ekj)localObject).NjB = paramString6;
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "do scene NetSceneMobileRemitGetSuccPage out_trade_no:%s trans_id:%s rcvr_openid:%s rcvr_token:%s amount:%s placeorder_token:%s placeorder_ext:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt), paramString5, paramString6 });
    AppMethodBeat.o(67651);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67652);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Cma = ((ekk)((d)params).iLL.iLR);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Cma.pTZ), this.Cma.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67652);
  }
  
  public final void e(s params)
  {
    params = (ekk)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final int getType()
  {
    return 1903;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.e
 * JD-Core Version:    0.7.0.1
 */