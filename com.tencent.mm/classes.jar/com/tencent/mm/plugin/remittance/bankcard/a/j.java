package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.protocal.protobuf.beu;
import com.tencent.mm.sdk.platformtools.ab;

public final class j
  extends b
{
  private final String TAG;
  private f callback;
  public String hKa;
  public String qfK;
  public beu qfS;
  private com.tencent.mm.ai.b rr;
  
  public j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44467);
    this.TAG = "MicroMsg.NetSceneBankRemitModifyExplain";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bet();
    ((b.a)localObject).fsY = new beu();
    ((b.a)localObject).funcId = 1590;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/modifyexplain_tsbc";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bet)this.rr.fsV.fta;
    ((bet)localObject).qgu = paramString1;
    ((bet)localObject).qgx = paramString2;
    this.qfK = paramString1;
    this.hKa = paramString2;
    AppMethodBeat.o(44467);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(44469);
    ab.i("MicroMsg.NetSceneBankRemitModifyExplain", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qfS = ((beu)((com.tencent.mm.ai.b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneBankRemitModifyExplain", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qfS.cnK), this.qfS.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(44469);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44468);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44468);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (beu)((com.tencent.mm.ai.b)paramq).fsW.fta;
    this.AXb = paramq.cnK;
    this.AXc = paramq.kNv;
  }
  
  public final int getType()
  {
    return 1590;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.j
 * JD-Core Version:    0.7.0.1
 */