package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.protocal.protobuf.xy;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends b
{
  public xy IfE;
  private final String TAG;
  private i callback;
  private com.tencent.mm.an.d rr;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(67358);
    this.TAG = "MicroMsg.NetSceneBankRemitCheckBankBind";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new xx();
    ((d.a)localObject).lBV = new xy();
    ((d.a)localObject).funcId = 1349;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/checkbankbind_tsbc";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (xx)d.b.b(this.rr.lBR);
    ((xx)localObject).Skg = paramString1;
    ((xx)localObject).Skh = paramString2;
    ((xx)localObject).DNV = paramString3;
    ((xx)localObject).fvP = paramString4;
    AppMethodBeat.o(67358);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67360);
    Log.i("MicroMsg.NetSceneBankRemitCheckBankBind", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.IfE = ((xy)d.c.b(((com.tencent.mm.an.d)params).lBS));
    Log.i("MicroMsg.NetSceneBankRemitCheckBankBind", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.IfE.fwx), this.IfE.tVo });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67360);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67359);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67359);
    return i;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(267795);
    params = (xy)d.c.b(((com.tencent.mm.an.d)params).lBS);
    this.YVy = params.fwx;
    this.YVz = params.tVo;
    AppMethodBeat.o(267795);
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