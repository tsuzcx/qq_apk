package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dpz;
import com.tencent.mm.protocal.protobuf.dqa;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends a
{
  private final String TAG;
  public dqa ykR;
  
  public c(String paramString)
  {
    AppMethodBeat.i(67628);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage";
    b.a locala = new b.a();
    locala.hQF = new dpz();
    locala.hQG = new dqa();
    locala.funcId = 1275;
    locala.uri = "/cgi-bin/mmpay-bin/transferphonedelhisrcvr";
    this.rr = locala.aDS();
    ((dpz)this.rr.hQD.hQJ).HXb = paramString;
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "do scene NetSceneMobileRemitDeleteRecord rcvr_id:%s ", new Object[] { paramString });
    AppMethodBeat.o(67628);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67629);
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ykR = ((dqa)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ykR.oGt), this.ykR.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67629);
  }
  
  public final void e(q paramq)
  {
    paramq = (dqa)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
  }
  
  public final int getType()
  {
    return 1275;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.c
 * JD-Core Version:    0.7.0.1
 */