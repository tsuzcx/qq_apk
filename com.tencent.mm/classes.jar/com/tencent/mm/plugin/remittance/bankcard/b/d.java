package com.tencent.mm.plugin.remittance.bankcard.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends b
{
  public zv Ocd;
  private final String TAG;
  private h callback;
  private c rr;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(67358);
    this.TAG = "MicroMsg.NetSceneBankRemitCheckBankBind";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new zu();
    ((c.a)localObject).otF = new zv();
    ((c.a)localObject).funcId = 1349;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/checkbankbind_tsbc";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (zu)c.b.b(this.rr.otB);
    ((zu)localObject).Zip = paramString1;
    ((zu)localObject).Ziq = paramString2;
    ((zu)localObject).JFk = paramString3;
    ((zu)localObject).hAk = paramString4;
    AppMethodBeat.o(67358);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67360);
    Log.i("MicroMsg.NetSceneBankRemitCheckBankBind", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Ocd = ((zv)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneBankRemitCheckBankBind", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.Ocd.hAV), this.Ocd.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67360);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67359);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67359);
    return i;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(288698);
    params = (zv)c.c.b(((c)params).otC);
    this.agTs = params.hAV;
    this.agTt = params.wYI;
    AppMethodBeat.o(288698);
  }
  
  public final int getType()
  {
    return 1349;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.b.d
 * JD-Core Version:    0.7.0.1
 */