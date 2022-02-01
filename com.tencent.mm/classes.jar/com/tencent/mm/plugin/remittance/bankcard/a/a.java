package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ge;
import com.tencent.mm.protocal.protobuf.gf;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends b
{
  private final String TAG;
  private g callback;
  private com.tencent.mm.ak.b rr;
  public gf wEh;
  public String wEi;
  
  public a(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67352);
    this.TAG = "MicroMsg.NetSceneBankRemitAppointBank";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ge();
    ((b.a)localObject).hvu = new gf();
    ((b.a)localObject).funcId = 1348;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/appointbank_tsbc";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (ge)this.rr.hvr.hvw;
    ((ge)localObject).wES = paramString1;
    ((ge)localObject).DTi = paramString2;
    ((ge)localObject).cZz = paramString3;
    this.wEi = paramString1;
    ac.i("MicroMsg.NetSceneBankRemitAppointBank", "seqno: %s, timing_id: %s, bankType: %s", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(67352);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67354);
    ac.i("MicroMsg.NetSceneBankRemitAppointBank", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wEh = ((gf)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBankRemitAppointBank", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wEh.dae), this.wEh.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67354);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67353);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67353);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (gf)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 1348;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.a
 * JD-Core Version:    0.7.0.1
 */