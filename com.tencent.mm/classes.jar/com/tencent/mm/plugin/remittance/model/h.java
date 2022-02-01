package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.protocal.protobuf.yt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r;

public final class h
  extends r
{
  public yt Oil;
  private final String TAG;
  
  public h(String paramString1, String paramString2)
  {
    AppMethodBeat.i(288816);
    this.TAG = "MicroMsg.NetSceneBeforeTransfer";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ys();
    ((c.a)localObject).otF = new yt();
    ((c.a)localObject).funcId = 2783;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/beforetransfer";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ys)c.b.b(this.rr.otB);
    ((ys)localObject).nQU = paramString1;
    if (!e.iOV()) {
      ((ys)localObject).Zhn = e.iOW();
    }
    ((ys)localObject).Zho = paramString2;
    Log.d("MicroMsg.NetSceneBeforeTransfer", "rcver name: %s", new Object[] { paramString1 });
    AppMethodBeat.o(288816);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67839);
    Log.i("MicroMsg.NetSceneBeforeTransfer", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Oil = ((yt)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneBeforeTransfer", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Oil.hAV), this.Oil.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67839);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(288823);
    params = (yt)c.c.b(((c)params).otC);
    this.agTs = params.hAV;
    this.agTt = params.wYI;
    AppMethodBeat.o(288823);
  }
  
  public final int getType()
  {
    return 2783;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.h
 * JD-Core Version:    0.7.0.1
 */