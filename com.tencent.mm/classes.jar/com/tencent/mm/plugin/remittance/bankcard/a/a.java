package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ga;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends b
{
  private final String TAG;
  private g callback;
  private com.tencent.mm.al.b rr;
  public gb vuc;
  public String vud;
  
  public a(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67352);
    this.TAG = "MicroMsg.NetSceneBankRemitAppointBank";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ga();
    ((b.a)localObject).gUV = new gb();
    ((b.a)localObject).funcId = 1348;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/appointbank_tsbc";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (ga)this.rr.gUS.gUX;
    ((ga)localObject).vuN = paramString1;
    ((ga)localObject).CAK = paramString2;
    ((ga)localObject).dca = paramString3;
    this.vud = paramString1;
    ad.i("MicroMsg.NetSceneBankRemitAppointBank", "seqno: %s, timing_id: %s, bankType: %s", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(67352);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67354);
    ad.i("MicroMsg.NetSceneBankRemitAppointBank", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.vuc = ((gb)((com.tencent.mm.al.b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneBankRemitAppointBank", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.vuc.dcG), this.vuc.nTK });
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
    paramq = (gb)((com.tencent.mm.al.b)paramq).gUT.gUX;
    this.IdO = paramq.dcG;
    this.IdP = paramq.nTK;
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