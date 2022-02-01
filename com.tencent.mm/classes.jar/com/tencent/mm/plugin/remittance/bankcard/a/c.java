package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends b
{
  private final String TAG;
  private g callback;
  private com.tencent.mm.ak.b rr;
  public pj wEj;
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67355);
    this.TAG = "MicroMsg.NetSceneBankRemitBusinessCallback";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new pi();
    ((b.a)localObject).hvu = new pj();
    ((b.a)localObject).funcId = 1340;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busscb_tsbc";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (pi)this.rr.hvr.hvw;
    ((pi)localObject).EfL = paramString1;
    ((pi)localObject).wLA = paramString2;
    AppMethodBeat.o(67355);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67357);
    ac.i("MicroMsg.NetSceneBankRemitBusinessCallback", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wEj = ((pj)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBankRemitBusinessCallback", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wEj.dae), this.wEj.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67357);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67356);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67356);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (pj)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 1340;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.c
 * JD-Core Version:    0.7.0.1
 */