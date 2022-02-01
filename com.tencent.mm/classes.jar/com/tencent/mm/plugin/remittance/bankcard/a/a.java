package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.gl;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends b
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.ak.b rr;
  public gm yhH;
  public String yhI;
  
  public a(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67352);
    this.TAG = "MicroMsg.NetSceneBankRemitAppointBank";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new gl();
    ((b.a)localObject).hQG = new gm();
    ((b.a)localObject).funcId = 1348;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/appointbank_tsbc";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (gl)this.rr.hQD.hQJ;
    ((gl)localObject).yis = paramString1;
    ((gl)localObject).FQZ = paramString2;
    ((gl)localObject).dlT = paramString3;
    this.yhI = paramString1;
    ae.i("MicroMsg.NetSceneBankRemitAppointBank", "seqno: %s, timing_id: %s, bankType: %s", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(67352);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67354);
    ae.i("MicroMsg.NetSceneBankRemitAppointBank", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yhH = ((gm)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneBankRemitAppointBank", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yhH.dmy), this.yhH.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67354);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67353);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67353);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (gm)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
  }
  
  public final int getType()
  {
    return 1348;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.a
 * JD-Core Version:    0.7.0.1
 */