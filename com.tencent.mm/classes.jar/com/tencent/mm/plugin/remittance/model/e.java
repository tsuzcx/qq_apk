package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vm;
import com.tencent.mm.protocal.protobuf.vn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class e
  extends r
{
  private final String TAG;
  public vn xXK;
  
  public e(String paramString)
  {
    AppMethodBeat.i(67838);
    this.TAG = "MicroMsg.NetSceneBeforeTransfer";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new vm();
    ((b.a)localObject).hNN = new vn();
    ((b.a)localObject).funcId = 2783;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/beforetransfer";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (vm)this.rr.hNK.hNQ;
    ((vm)localObject).iTJ = paramString;
    if (!com.tencent.mm.pluginsdk.wallet.e.ffA()) {
      ((vm)localObject).FUQ = com.tencent.mm.pluginsdk.wallet.e.ffB();
    }
    ad.d("MicroMsg.NetSceneBeforeTransfer", "rcver name: %s", new Object[] { paramString });
    AppMethodBeat.o(67838);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67839);
    ad.i("MicroMsg.NetSceneBeforeTransfer", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xXK = ((vn)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneBeforeTransfer", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.xXK.dlw), this.xXK.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67839);
  }
  
  public final void e(q paramq)
  {
    paramq = (vn)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
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