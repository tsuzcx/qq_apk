package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fpm;
import com.tencent.mm.protocal.protobuf.fpn;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends a
{
  public fpn Ofv;
  private final String TAG;
  
  public c(String paramString)
  {
    AppMethodBeat.i(67628);
    this.TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage";
    c.a locala = new c.a();
    locala.otE = new fpm();
    locala.otF = new fpn();
    locala.funcId = 1275;
    locala.uri = "/cgi-bin/mmpay-bin/transferphonedelhisrcvr";
    this.rr = locala.bEF();
    ((fpm)c.b.b(this.rr.otB)).abPu = paramString;
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "do scene NetSceneMobileRemitDeleteRecord rcvr_id:%s ", new Object[] { paramString });
    AppMethodBeat.o(67628);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67629);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Ofv = ((fpn)c.c.b(((com.tencent.mm.am.c)params).otC));
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Ofv.wuz), this.Ofv.wuA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67629);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(288857);
    params = (fpn)c.c.b(((com.tencent.mm.am.c)params).otC);
    this.agTs = params.wuz;
    this.agTt = params.wuA;
    AppMethodBeat.o(288857);
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