package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.dqo;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends a
{
  private final String TAG;
  public dqo yla;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6)
  {
    AppMethodBeat.i(67651);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dqn();
    ((b.a)localObject).hQG = new dqo();
    ((b.a)localObject).funcId = 1903;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferphonesuccpage";
    this.rr = ((b.a)localObject).aDS();
    localObject = (dqn)this.rr.hQD.hQJ;
    ((dqn)localObject).FIw = paramString1;
    ((dqn)localObject).FOg = paramString2;
    ((dqn)localObject).HWV = paramString3;
    ((dqn)localObject).HWW = paramString4;
    ((dqn)localObject).vxx = paramInt;
    ((dqn)localObject).HXn = paramString5;
    ((dqn)localObject).HXv = paramString6;
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "do scene NetSceneMobileRemitGetSuccPage out_trade_no:%s trans_id:%s rcvr_openid:%s rcvr_token:%s amount:%s placeorder_token:%s placeorder_ext:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt), paramString5, paramString6 });
    AppMethodBeat.o(67651);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67652);
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yla = ((dqo)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.yla.oGt), this.yla.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67652);
  }
  
  public final void e(q paramq)
  {
    paramq = (dqo)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
  }
  
  public final int getType()
  {
    return 1903;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.e
 * JD-Core Version:    0.7.0.1
 */