package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.xa;
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class g
  extends r
{
  public xb Ilu;
  private final String TAG;
  
  public g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(229015);
    this.TAG = "MicroMsg.NetSceneBeforeTransfer";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new xa();
    ((d.a)localObject).lBV = new xb();
    ((d.a)localObject).funcId = 2783;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/beforetransfer";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (xa)d.b.b(this.rr.lBR);
    ((xa)localObject).llO = paramString1;
    if (!e.hod()) {
      ((xa)localObject).Sjh = e.hoe();
    }
    ((xa)localObject).Sji = paramString2;
    Log.d("MicroMsg.NetSceneBeforeTransfer", "rcver name: %s", new Object[] { paramString1 });
    AppMethodBeat.o(229015);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67839);
    Log.i("MicroMsg.NetSceneBeforeTransfer", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Ilu = ((xb)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneBeforeTransfer", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Ilu.fwx), this.Ilu.tVo });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67839);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(229023);
    params = (xb)d.c.b(((d)params).lBS);
    this.YVy = params.fwx;
    this.YVz = params.tVo;
    AppMethodBeat.o(229023);
  }
  
  public final int getType()
  {
    return 2783;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.g
 * JD-Core Version:    0.7.0.1
 */