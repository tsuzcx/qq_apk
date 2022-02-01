package com.tencent.mm.plugin.remittance.bankcard.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cvx;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.j;

public final class o
  extends b
  implements j
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.ak.b rr;
  public cvy yhV;
  
  public o(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, int paramInt4, String paramString5, String paramString6, com.tencent.mm.bw.b paramb, int paramInt5)
  {
    AppMethodBeat.i(67391);
    this.TAG = "MicroMsg.NetSceneBankRemitRequestOrder";
    ae.i("MicroMsg.NetSceneBankRemitRequestOrder", "unique_id:%s last_transfer_bill_id:%s unpay_type:%s", new Object[] { bu.nullAsNil(paramString6), Base64.encodeToString(paramb.toByteArray(), 2), Integer.valueOf(paramInt5) });
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cvx();
    ((b.a)localObject).hQG = new cvy();
    ((b.a)localObject).funcId = 1380;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/request_tsbc";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cvx)this.rr.hQD.hQJ;
    ((cvx)localObject).yis = paramString1;
    ((cvx)localObject).yit = paramString2;
    ((cvx)localObject).dlT = paramString3;
    ((cvx)localObject).yif = paramInt1;
    ((cvx)localObject).HGF = paramInt2;
    ((cvx)localObject).HGG = paramString4;
    ((cvx)localObject).HGH = paramInt3;
    ((cvx)localObject).HGI = paramInt4;
    ((cvx)localObject).FRb = paramString5;
    ((cvx)localObject).HsZ = paramString6;
    ((cvx)localObject).HGJ = paramb;
    ((cvx)localObject).GdY = paramInt5;
    AppMethodBeat.o(67391);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67393);
    ae.i("MicroMsg.NetSceneBankRemitRequestOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yhV = ((cvy)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneBankRemitRequestOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yhV.dmy), this.yhV.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67393);
  }
  
  public final boolean cbW()
  {
    return false;
  }
  
  public final boolean dLY()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.yhV.HGK != null)
    {
      bool1 = bool2;
      if (this.yhV.HGK.dEu == 1) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67392);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67392);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cvy)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
  }
  
  public final int getType()
  {
    return 1380;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.o
 * JD-Core Version:    0.7.0.1
 */