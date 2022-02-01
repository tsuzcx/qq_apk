package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpb;
import com.tencent.mm.protocal.protobuf.cpc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class g
  extends r
{
  public cpc DGM;
  private f callback;
  private b rr;
  
  public g()
  {
    AppMethodBeat.i(71701);
    b.a locala = new b.a();
    locala.hQF = new cpb();
    locala.hQG = new cpc();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qrycancelecarddesc";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((cpb)this.rr.hQD.hQJ).HAM = 1L;
    AppMethodBeat.o(71701);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71702);
    ae.i("MicroMsg.NetSceneQryECardLogout", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.DGM = ((cpc)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneQryECardLogout", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.DGM.oGt), this.DGM.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(71702);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(71703);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71703);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cpc)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
  }
  
  public final int getType()
  {
    return 2931;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.g
 * JD-Core Version:    0.7.0.1
 */