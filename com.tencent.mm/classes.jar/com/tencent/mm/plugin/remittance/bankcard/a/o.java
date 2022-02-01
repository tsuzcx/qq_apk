package com.tencent.mm.plugin.remittance.bankcard.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpy;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.j;

public final class o
  extends b
  implements j
{
  private final String TAG;
  private g callback;
  private com.tencent.mm.ak.b rr;
  public cpz wEv;
  
  public o(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, int paramInt4, String paramString5, String paramString6, com.tencent.mm.bw.b paramb, int paramInt5)
  {
    AppMethodBeat.i(67391);
    this.TAG = "MicroMsg.NetSceneBankRemitRequestOrder";
    ac.i("MicroMsg.NetSceneBankRemitRequestOrder", "unique_id:%s last_transfer_bill_id:%s unpay_type:%s", new Object[] { bs.nullAsNil(paramString6), Base64.encodeToString(paramb.toByteArray(), 2), Integer.valueOf(paramInt5) });
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cpy();
    ((b.a)localObject).hvu = new cpz();
    ((b.a)localObject).funcId = 1380;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/request_tsbc";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cpy)this.rr.hvr.hvw;
    ((cpy)localObject).wES = paramString1;
    ((cpy)localObject).wET = paramString2;
    ((cpy)localObject).cZz = paramString3;
    ((cpy)localObject).wEF = paramInt1;
    ((cpy)localObject).FCS = paramInt2;
    ((cpy)localObject).FCT = paramString4;
    ((cpy)localObject).FCU = paramInt3;
    ((cpy)localObject).FCV = paramInt4;
    ((cpy)localObject).DTk = paramString5;
    ((cpy)localObject).FpO = paramString6;
    ((cpy)localObject).FCW = paramb;
    ((cpy)localObject).Efa = paramInt5;
    AppMethodBeat.o(67391);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67393);
    ac.i("MicroMsg.NetSceneBankRemitRequestOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wEv = ((cpz)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBankRemitRequestOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wEv.dae), this.wEv.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67393);
  }
  
  public final boolean bWe()
  {
    return false;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67392);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67392);
    return i;
  }
  
  public final boolean dxp()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.wEv.FCX != null)
    {
      bool1 = bool2;
      if (this.wEv.FCX.drx == 1) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public final void e(q paramq)
  {
    paramq = (cpz)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 1380;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.o
 * JD-Core Version:    0.7.0.1
 */