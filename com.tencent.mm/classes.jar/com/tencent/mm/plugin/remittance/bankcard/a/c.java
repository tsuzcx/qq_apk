package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.my;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends b
{
  private final String TAG;
  private f callback;
  public mz qfL;
  private com.tencent.mm.ai.b rr;
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44446);
    this.TAG = "MicroMsg.NetSceneBankRemitBusinessCallback";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new my();
    ((b.a)localObject).fsY = new mz();
    ((b.a)localObject).funcId = 1340;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busscb_tsbc";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (my)this.rr.fsV.fta;
    ((my)localObject).wBQ = paramString1;
    ((my)localObject).qkt = paramString2;
    AppMethodBeat.o(44446);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(44448);
    ab.i("MicroMsg.NetSceneBankRemitBusinessCallback", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qfL = ((mz)((com.tencent.mm.ai.b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneBankRemitBusinessCallback", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qfL.cnK), this.qfL.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(44448);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44447);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44447);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (mz)((com.tencent.mm.ai.b)paramq).fsW.fta;
    this.AXb = paramq.cnK;
    this.AXc = paramq.kNv;
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