package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.xr;
import com.tencent.mm.protocal.protobuf.xs;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends b
{
  public xs CiL;
  private final String TAG;
  private i callback;
  private com.tencent.mm.ak.d rr;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(67358);
    this.TAG = "MicroMsg.NetSceneBankRemitCheckBankBind";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new xr();
    ((d.a)localObject).iLO = new xs();
    ((d.a)localObject).funcId = 1349;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/checkbankbind_tsbc";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (xr)this.rr.iLK.iLR;
    ((xr)localObject).LiP = paramString1;
    ((xr)localObject).LiQ = paramString2;
    ((xr)localObject).ynT = paramString3;
    ((xr)localObject).dDj = paramString4;
    AppMethodBeat.o(67358);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67360);
    Log.i("MicroMsg.NetSceneBankRemitCheckBankBind", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.CiL = ((xs)((com.tencent.mm.ak.d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBankRemitCheckBankBind", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.CiL.dDN), this.CiL.qwn });
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
  
  public final void e(s params)
  {
    params = (xs)((com.tencent.mm.ak.d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
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