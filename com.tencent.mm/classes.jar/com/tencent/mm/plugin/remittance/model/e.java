package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class e
  extends r
{
  private final String TAG;
  public ti vzY;
  
  public e(String paramString)
  {
    AppMethodBeat.i(67838);
    this.TAG = "MicroMsg.NetSceneBeforeTransfer";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new th();
    ((b.a)localObject).gUV = new ti();
    ((b.a)localObject).funcId = 2783;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/beforetransfer";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (th)this.rr.gUS.gUX;
    ((th)localObject).iaw = paramString;
    if (!com.tencent.mm.pluginsdk.wallet.e.eBc()) {
      ((th)localObject).CUX = com.tencent.mm.pluginsdk.wallet.e.eBd();
    }
    ad.d("MicroMsg.NetSceneBeforeTransfer", "rcver name: %s", new Object[] { paramString });
    AppMethodBeat.o(67838);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67839);
    ad.i("MicroMsg.NetSceneBeforeTransfer", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.vzY = ((ti)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneBeforeTransfer", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.vzY.dcG), this.vzY.nTK });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67839);
  }
  
  public final void e(q paramq)
  {
    paramq = (ti)((b)paramq).gUT.gUX;
    this.IdO = paramq.dcG;
    this.IdP = paramq.nTK;
  }
  
  public final int getType()
  {
    return 2783;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.e
 * JD-Core Version:    0.7.0.1
 */