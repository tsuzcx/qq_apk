package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.gy;
import com.tencent.mm.protocal.protobuf.gz;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends b
{
  public gz CiI;
  public String CiJ;
  private final String TAG;
  private i callback;
  private d rr;
  
  public a(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67352);
    this.TAG = "MicroMsg.NetSceneBankRemitAppointBank";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new gy();
    ((d.a)localObject).iLO = new gz();
    ((d.a)localObject).funcId = 1348;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/appointbank_tsbc";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (gy)this.rr.iLK.iLR;
    ((gy)localObject).Cjt = paramString1;
    ((gy)localObject).KKG = paramString2;
    ((gy)localObject).dDj = paramString3;
    this.CiJ = paramString1;
    Log.i("MicroMsg.NetSceneBankRemitAppointBank", "seqno: %s, timing_id: %s, bankType: %s", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(67352);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67354);
    Log.i("MicroMsg.NetSceneBankRemitAppointBank", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.CiI = ((gz)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBankRemitAppointBank", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.CiI.dDN), this.CiI.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67354);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67353);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67353);
    return i;
  }
  
  public final void e(s params)
  {
    params = (gz)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
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