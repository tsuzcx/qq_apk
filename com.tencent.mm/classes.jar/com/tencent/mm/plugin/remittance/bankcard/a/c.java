package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.qp;
import com.tencent.mm.protocal.protobuf.qq;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends b
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.ak.b rr;
  public qq yhJ;
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67355);
    this.TAG = "MicroMsg.NetSceneBankRemitBusinessCallback";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new qp();
    ((b.a)localObject).hQG = new qq();
    ((b.a)localObject).funcId = 1340;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busscb_tsbc";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (qp)this.rr.hQD.hQJ;
    ((qp)localObject).GeJ = paramString1;
    ((qp)localObject).yoZ = paramString2;
    AppMethodBeat.o(67355);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67357);
    ae.i("MicroMsg.NetSceneBankRemitBusinessCallback", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yhJ = ((qq)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneBankRemitBusinessCallback", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yhJ.dmy), this.yhJ.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67357);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67356);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67356);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (qq)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
  }
  
  public final int getType()
  {
    return 1340;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.c
 * JD-Core Version:    0.7.0.1
 */