package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.sdk.platformtools.ae;

public final class j
  extends b
{
  private final String TAG;
  private f callback;
  public String iWF;
  private com.tencent.mm.ak.b rr;
  public String yhI;
  public cbo yhQ;
  
  public j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67376);
    this.TAG = "MicroMsg.NetSceneBankRemitModifyExplain";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cbn();
    ((b.a)localObject).hQG = new cbo();
    ((b.a)localObject).funcId = 1590;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyexplain_tsbc";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cbn)this.rr.hQD.hQJ;
    ((cbn)localObject).yis = paramString1;
    ((cbn)localObject).yiv = paramString2;
    this.yhI = paramString1;
    this.iWF = paramString2;
    AppMethodBeat.o(67376);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67378);
    ae.i("MicroMsg.NetSceneBankRemitModifyExplain", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yhQ = ((cbo)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneBankRemitModifyExplain", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yhQ.dmy), this.yhQ.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67378);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67377);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67377);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cbo)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
  }
  
  public final int getType()
  {
    return 1590;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.j
 * JD-Core Version:    0.7.0.1
 */