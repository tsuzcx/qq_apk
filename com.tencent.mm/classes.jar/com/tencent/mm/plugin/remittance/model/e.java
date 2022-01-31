package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.protocal.protobuf.qu;
import com.tencent.mm.protocal.protobuf.qv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class e
  extends p
{
  private final String TAG;
  public qv qiX;
  
  public e(String paramString)
  {
    AppMethodBeat.i(44727);
    this.TAG = "MicroMsg.NetSceneBeforeTransfer";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new qu();
    ((b.a)localObject).fsY = new qv();
    ((b.a)localObject).funcId = 2783;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/beforetransfer";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (qu)this.rr.fsV.fta;
    ((qu)localObject).wpt = paramString;
    if (!g.dpN()) {
      ((qu)localObject).wIZ = g.dpO();
    }
    ab.d("MicroMsg.NetSceneBeforeTransfer", "rcver name: %s", new Object[] { paramString });
    AppMethodBeat.o(44727);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(44728);
    ab.i("MicroMsg.NetSceneBeforeTransfer", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qiX = ((qv)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneBeforeTransfer", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.qiX.cnK), this.qiX.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(44728);
  }
  
  public final void e(q paramq)
  {
    paramq = (qv)((b)paramq).fsW.fta;
    this.AXb = paramq.cnK;
    this.AXc = paramq.kNv;
  }
  
  public final int getType()
  {
    return 2783;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.e
 * JD-Core Version:    0.7.0.1
 */