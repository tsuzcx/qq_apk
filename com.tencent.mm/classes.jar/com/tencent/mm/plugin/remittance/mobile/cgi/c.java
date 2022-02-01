package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.djn;
import com.tencent.mm.protocal.protobuf.djo;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends a
{
  private final String TAG;
  public djo wHr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(67628);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage";
    b.a locala = new b.a();
    locala.hvt = new djn();
    locala.hvu = new djo();
    locala.funcId = 1275;
    locala.uri = "/cgi-bin/mmpay-bin/transferphonedelhisrcvr";
    this.rr = locala.aAz();
    ((djn)this.rr.hvr.hvw).FSF = paramString;
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "do scene NetSceneMobileRemitDeleteRecord rcvr_id:%s ", new Object[] { paramString });
    AppMethodBeat.o(67628);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67629);
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wHr = ((djo)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.wHr.nWx), this.wHr.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67629);
  }
  
  public final void e(q paramq)
  {
    paramq = (djo)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 1275;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.c
 * JD-Core Version:    0.7.0.1
 */