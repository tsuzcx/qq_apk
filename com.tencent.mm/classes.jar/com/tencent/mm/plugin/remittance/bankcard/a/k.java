package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class k
  extends b
{
  public cxk CiS;
  private i callback;
  private d rr;
  
  public k()
  {
    AppMethodBeat.i(67379);
    d.a locala = new d.a();
    locala.iLN = new cxj();
    locala.iLO = new cxk();
    locala.funcId = 1280;
    locala.uri = "/cgi-bin/mmpay-bin/operation_tsbc";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(67379);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67381);
    Log.i("MicroMsg.NetSceneBankRemitOperation", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.CiS = ((cxk)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBankRemitOperation", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.CiS.dDN), this.CiS.qwn });
    if ((!this.qxx) && (!this.qxy))
    {
      Log.i("MicroMsg.NetSceneBankRemitOperation", "min_poundage: %s, max_amount: %s", new Object[] { Integer.valueOf(this.CiS.MBS), Integer.valueOf(this.CiS.MBT) });
      if (this.CiS.MBS >= 0) {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OeF, Integer.valueOf(this.CiS.MBS));
      }
      if (this.CiS.MBT > 0) {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OeG, Integer.valueOf(this.CiS.MBT));
      }
      if (!Util.isNullOrNil(this.CiS.MBU)) {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OeH, this.CiS.MBU);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67381);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(67380);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67380);
    return i;
  }
  
  public final void e(s params)
  {
    params = (cxk)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
  }
  
  public final int getType()
  {
    return 1280;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.k
 * JD-Core Version:    0.7.0.1
 */