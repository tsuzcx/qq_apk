package com.tencent.mm.plugin.remittance.bankcard.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.hf;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends b
{
  public hg Oca;
  public String Ocb;
  private final String TAG;
  private h callback;
  private c rr;
  
  public a(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67352);
    this.TAG = "MicroMsg.NetSceneBankRemitAppointBank";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new hf();
    ((c.a)localObject).otF = new hg();
    ((c.a)localObject).funcId = 1348;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/appointbank_tsbc";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (hf)c.b.b(this.rr.otB);
    ((hf)localObject).OcL = paramString1;
    ((hf)localObject).YIK = paramString2;
    ((hf)localObject).hAk = paramString3;
    this.Ocb = paramString1;
    Log.i("MicroMsg.NetSceneBankRemitAppointBank", "seqno: %s, timing_id: %s, bankType: %s", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(67352);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67354);
    Log.i("MicroMsg.NetSceneBankRemitAppointBank", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Oca = ((hg)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneBankRemitAppointBank", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.Oca.hAV), this.Oca.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67354);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67353);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67353);
    return i;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(288693);
    params = (hg)c.c.b(((c)params).otC);
    this.agTs = params.hAV;
    this.agTt = params.wYI;
    AppMethodBeat.o(288693);
  }
  
  public final int getType()
  {
    return 1348;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.b.a
 * JD-Core Version:    0.7.0.1
 */