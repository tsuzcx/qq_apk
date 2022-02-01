package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ww;
import com.tencent.mm.protocal.protobuf.wx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class e
  extends r
{
  public wx Cos;
  private final String TAG;
  
  public e(String paramString)
  {
    AppMethodBeat.i(67838);
    this.TAG = "MicroMsg.NetSceneBeforeTransfer";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ww();
    ((d.a)localObject).iLO = new wx();
    ((d.a)localObject).funcId = 2783;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/beforetransfer";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ww)this.rr.iLK.iLR;
    ((ww)localObject).jTz = paramString;
    if (!com.tencent.mm.pluginsdk.wallet.e.gsQ()) {
      ((ww)localObject).LhT = com.tencent.mm.pluginsdk.wallet.e.gsR();
    }
    Log.d("MicroMsg.NetSceneBeforeTransfer", "rcver name: %s", new Object[] { paramString });
    AppMethodBeat.o(67838);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67839);
    Log.i("MicroMsg.NetSceneBeforeTransfer", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Cos = ((wx)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBeforeTransfer", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Cos.dDN), this.Cos.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67839);
  }
  
  public final void e(s params)
  {
    params = (wx)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
  }
  
  public final int getType()
  {
    return 2783;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.e
 * JD-Core Version:    0.7.0.1
 */