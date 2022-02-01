package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dkb;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends a
{
  private final String TAG;
  public dkc wHA;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6)
  {
    AppMethodBeat.i(67651);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dkb();
    ((b.a)localObject).hvu = new dkc();
    ((b.a)localObject).funcId = 1903;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonesuccpage";
    this.rr = ((b.a)localObject).aAz();
    localObject = (dkb)this.rr.hvr.hvw;
    ((dkb)localObject).DKS = paramString1;
    ((dkb)localObject).DQt = paramString2;
    ((dkb)localObject).FSz = paramString3;
    ((dkb)localObject).FSA = paramString4;
    ((dkb)localObject).uiK = paramInt;
    ((dkb)localObject).FSR = paramString5;
    ((dkb)localObject).FSZ = paramString6;
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "do scene NetSceneMobileRemitGetSuccPage out_trade_no:%s trans_id:%s rcvr_openid:%s rcvr_token:%s amount:%s placeorder_token:%s placeorder_ext:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt), paramString5, paramString6 });
    AppMethodBeat.o(67651);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67652);
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wHA = ((dkc)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.wHA.nWx), this.wHA.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67652);
  }
  
  public final void e(q paramq)
  {
    paramq = (dkc)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
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