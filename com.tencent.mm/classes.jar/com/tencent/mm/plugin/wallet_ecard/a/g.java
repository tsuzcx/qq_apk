package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.protocal.protobuf.cji;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class g
  extends r
{
  public cji BOO;
  private com.tencent.mm.ak.g callback;
  private b rr;
  
  public g()
  {
    AppMethodBeat.i(71701);
    b.a locala = new b.a();
    locala.hvt = new cjh();
    locala.hvu = new cji();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qrycancelecarddesc";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((cjh)this.rr.hvr.hvw).Fxh = 1L;
    AppMethodBeat.o(71701);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71702);
    ac.i("MicroMsg.NetSceneQryECardLogout", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.BOO = ((cji)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneQryECardLogout", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.BOO.nWx), this.BOO.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(71702);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(71703);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71703);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cji)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
  }
  
  public final int getType()
  {
    return 2931;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.g
 * JD-Core Version:    0.7.0.1
 */