package com.tencent.mm.plugin.remittance.bankcard.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cvd;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.j;

public final class o
  extends b
  implements j
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.al.b rr;
  public cve xSc;
  
  public o(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, int paramInt4, String paramString5, String paramString6, com.tencent.mm.bx.b paramb, int paramInt5)
  {
    AppMethodBeat.i(67391);
    this.TAG = "MicroMsg.NetSceneBankRemitRequestOrder";
    ad.i("MicroMsg.NetSceneBankRemitRequestOrder", "unique_id:%s last_transfer_bill_id:%s unpay_type:%s", new Object[] { bt.nullAsNil(paramString6), Base64.encodeToString(paramb.toByteArray(), 2), Integer.valueOf(paramInt5) });
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cvd();
    ((b.a)localObject).hNN = new cve();
    ((b.a)localObject).funcId = 1380;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/request_tsbc";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cvd)this.rr.hNK.hNQ;
    ((cvd)localObject).xSz = paramString1;
    ((cvd)localObject).xSA = paramString2;
    ((cvd)localObject).dkR = paramString3;
    ((cvd)localObject).xSm = paramInt1;
    ((cvd)localObject).Hnf = paramInt2;
    ((cvd)localObject).Hng = paramString4;
    ((cvd)localObject).Hnh = paramInt3;
    ((cvd)localObject).Hni = paramInt4;
    ((cvd)localObject).FyD = paramString5;
    ((cvd)localObject).GZy = paramString6;
    ((cvd)localObject).Hnj = paramb;
    ((cvd)localObject).FLz = paramInt5;
    AppMethodBeat.o(67391);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67393);
    ad.i("MicroMsg.NetSceneBankRemitRequestOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xSc = ((cve)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneBankRemitRequestOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.xSc.dlw), this.xSc.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67393);
  }
  
  public final boolean caH()
  {
    return false;
  }
  
  public final boolean dIH()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.xSc.Hnk != null)
    {
      bool1 = bool2;
      if (this.xSc.Hnk.dDp == 1) {
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
    paramq = (cve)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
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