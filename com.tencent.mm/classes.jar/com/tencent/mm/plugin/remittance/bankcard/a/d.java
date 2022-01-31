package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends b
{
  private final String TAG;
  private f callback;
  public rh qfM;
  private com.tencent.mm.ai.b rr;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(44449);
    this.TAG = "MicroMsg.NetSceneBankRemitCheckBankBind";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new rg();
    ((b.a)localObject).fsY = new rh();
    ((b.a)localObject).funcId = 1349;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkbankbind_tsbc";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (rg)this.rr.fsV.fta;
    ((rg)localObject).wJx = paramString1;
    ((rg)localObject).wJy = paramString2;
    ((rg)localObject).nLq = paramString3;
    ((rg)localObject).poq = paramString4;
    AppMethodBeat.o(44449);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(44451);
    ab.i("MicroMsg.NetSceneBankRemitCheckBankBind", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qfM = ((rh)((com.tencent.mm.ai.b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneBankRemitCheckBankBind", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qfM.cnK), this.qfM.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(44451);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44450);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44450);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (rh)((com.tencent.mm.ai.b)paramq).fsW.fta;
    this.AXb = paramq.cnK;
    this.AXc = paramq.kNv;
  }
  
  public final int getType()
  {
    return 1349;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.d
 * JD-Core Version:    0.7.0.1
 */