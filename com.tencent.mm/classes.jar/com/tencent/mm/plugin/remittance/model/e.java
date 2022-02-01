package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.tr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class e
  extends r
{
  private final String TAG;
  public ts wKd;
  
  public e(String paramString)
  {
    AppMethodBeat.i(67838);
    this.TAG = "MicroMsg.NetSceneBeforeTransfer";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new tr();
    ((b.a)localObject).hvu = new ts();
    ((b.a)localObject).funcId = 2783;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/beforetransfer";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (tr)this.rr.hvr.hvw;
    ((tr)localObject).iAz = paramString;
    if (!com.tencent.mm.pluginsdk.wallet.e.eQw()) {
      ((tr)localObject).EnH = com.tencent.mm.pluginsdk.wallet.e.eQx();
    }
    ac.d("MicroMsg.NetSceneBeforeTransfer", "rcver name: %s", new Object[] { paramString });
    AppMethodBeat.o(67838);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67839);
    ac.i("MicroMsg.NetSceneBeforeTransfer", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wKd = ((ts)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBeforeTransfer", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.wKd.dae), this.wKd.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67839);
  }
  
  public final void e(q paramq)
  {
    paramq = (ts)((b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 2783;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.e
 * JD-Core Version:    0.7.0.1
 */