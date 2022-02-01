package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dgt;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class k
  extends b
{
  public dgu IfL;
  private i callback;
  private d rr;
  
  public k()
  {
    AppMethodBeat.i(67379);
    d.a locala = new d.a();
    locala.lBU = new dgt();
    locala.lBV = new dgu();
    locala.funcId = 1280;
    locala.uri = "/cgi-bin/mmpay-bin/operation_tsbc";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    AppMethodBeat.o(67379);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67381);
    Log.i("MicroMsg.NetSceneBankRemitOperation", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.IfL = ((dgu)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneBankRemitOperation", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.IfL.fwx), this.IfL.tVo });
    if ((!this.tWx) && (!this.tWy))
    {
      Log.i("MicroMsg.NetSceneBankRemitOperation", "min_poundage: %s, max_amount: %s", new Object[] { Integer.valueOf(this.IfL.TNy), Integer.valueOf(this.IfL.TNz) });
      if (this.IfL.TNy >= 0) {
        h.aHG().aHp().set(ar.a.VsQ, Integer.valueOf(this.IfL.TNy));
      }
      if (this.IfL.TNz > 0) {
        h.aHG().aHp().set(ar.a.VsR, Integer.valueOf(this.IfL.TNz));
      }
      if (!Util.isNullOrNil(this.IfL.TNA)) {
        h.aHG().aHp().set(ar.a.VsS, this.IfL.TNA);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67381);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67380);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67380);
    return i;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(223836);
    params = (dgu)d.c.b(((d)params).lBS);
    this.YVy = params.fwx;
    this.YVz = params.tVo;
    AppMethodBeat.o(223836);
  }
  
  public final int getType()
  {
    return 1280;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.k
 * JD-Core Version:    0.7.0.1
 */