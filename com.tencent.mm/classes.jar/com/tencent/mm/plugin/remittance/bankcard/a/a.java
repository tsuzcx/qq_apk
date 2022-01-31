package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.protocal.protobuf.fj;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends b
{
  private final String TAG;
  private f callback;
  public fj qfJ;
  public String qfK;
  private com.tencent.mm.ai.b rr;
  
  public a(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(44443);
    this.TAG = "MicroMsg.NetSceneBankRemitAppointBank";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new fi();
    ((b.a)localObject).fsY = new fj();
    ((b.a)localObject).funcId = 1348;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/appointbank_tsbc";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (fi)this.rr.fsV.fta;
    ((fi)localObject).qgu = paramString1;
    ((fi)localObject).wrw = paramString2;
    ((fi)localObject).poq = paramString3;
    this.qfK = paramString1;
    ab.i("MicroMsg.NetSceneBankRemitAppointBank", "seqno: %s, timing_id: %s, bankType: %s", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(44443);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(44445);
    ab.i("MicroMsg.NetSceneBankRemitAppointBank", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qfJ = ((fj)((com.tencent.mm.ai.b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneBankRemitAppointBank", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qfJ.cnK), this.qfJ.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(44445);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44444);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44444);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (fj)((com.tencent.mm.ai.b)paramq).fsW.fta;
    this.AXb = paramq.cnK;
    this.AXc = paramq.kNv;
  }
  
  public final int getType()
  {
    return 1348;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.a
 * JD-Core Version:    0.7.0.1
 */