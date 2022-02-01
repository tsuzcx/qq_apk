package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.wh;
import com.tencent.mm.protocal.protobuf.wi;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
  extends b
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.ak.b rr;
  public wi yhK;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(67358);
    this.TAG = "MicroMsg.NetSceneBankRemitCheckBankBind";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new wh();
    ((b.a)localObject).hQG = new wi();
    ((b.a)localObject).funcId = 1349;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkbankbind_tsbc";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (wh)this.rr.hQD.hQJ;
    ((wh)localObject).Goc = paramString1;
    ((wh)localObject).God = paramString2;
    ((wh)localObject).uVs = paramString3;
    ((wh)localObject).dlT = paramString4;
    AppMethodBeat.o(67358);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67360);
    ae.i("MicroMsg.NetSceneBankRemitCheckBankBind", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yhK = ((wi)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneBankRemitCheckBankBind", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yhK.dmy), this.yhK.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67360);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67359);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67359);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (wi)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
  }
  
  public final int getType()
  {
    return 1349;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.d
 * JD-Core Version:    0.7.0.1
 */