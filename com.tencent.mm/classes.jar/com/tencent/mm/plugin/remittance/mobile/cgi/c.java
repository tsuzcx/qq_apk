package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ejv;
import com.tencent.mm.protocal.protobuf.ejw;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends a
{
  public ejw ClR;
  private final String TAG;
  
  public c(String paramString)
  {
    AppMethodBeat.i(67628);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage";
    d.a locala = new d.a();
    locala.iLN = new ejv();
    locala.iLO = new ejw();
    locala.funcId = 1275;
    locala.uri = "/cgi-bin/mmpay-bin/transferphonedelhisrcvr";
    this.rr = locala.aXF();
    ((ejv)this.rr.iLK.iLR).Njh = paramString;
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "do scene NetSceneMobileRemitDeleteRecord rcvr_id:%s ", new Object[] { paramString });
    AppMethodBeat.o(67628);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67629);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ClR = ((ejw)((d)params).iLL.iLR);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ClR.pTZ), this.ClR.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67629);
  }
  
  public final void e(s params)
  {
    params = (ejw)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final int getType()
  {
    return 1275;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.c
 * JD-Core Version:    0.7.0.1
 */