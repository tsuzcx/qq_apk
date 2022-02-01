package com.tencent.mm.plugin.remittance.bankcard.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ckr;
import com.tencent.mm.protocal.protobuf.cks;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.j;

public final class o
  extends b
  implements j
{
  private final String TAG;
  private g callback;
  private com.tencent.mm.al.b rr;
  public cks vuq;
  
  public o(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, int paramInt4, String paramString5, String paramString6, com.tencent.mm.bx.b paramb, int paramInt5)
  {
    AppMethodBeat.i(67391);
    this.TAG = "MicroMsg.NetSceneBankRemitRequestOrder";
    ad.i("MicroMsg.NetSceneBankRemitRequestOrder", "unique_id:%s last_transfer_bill_id:%s unpay_type:%s", new Object[] { bt.nullAsNil(paramString6), Base64.encodeToString(paramb.toByteArray(), 2), Integer.valueOf(paramInt5) });
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ckr();
    ((b.a)localObject).gUV = new cks();
    ((b.a)localObject).funcId = 1380;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/request_tsbc";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (ckr)this.rr.gUS.gUX;
    ((ckr)localObject).vuN = paramString1;
    ((ckr)localObject).vuO = paramString2;
    ((ckr)localObject).dca = paramString3;
    ((ckr)localObject).vuA = paramInt1;
    ((ckr)localObject).EfS = paramInt2;
    ((ckr)localObject).EfT = paramString4;
    ((ckr)localObject).EfU = paramInt3;
    ((ckr)localObject).EfV = paramInt4;
    ((ckr)localObject).CAM = paramString5;
    ((ckr)localObject).DTs = paramString6;
    ((ckr)localObject).EfW = paramb;
    ((ckr)localObject).CMy = paramInt5;
    AppMethodBeat.o(67391);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67393);
    ad.i("MicroMsg.NetSceneBankRemitRequestOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.vuq = ((cks)((com.tencent.mm.al.b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneBankRemitRequestOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.vuq.dcG), this.vuq.nTK });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67393);
  }
  
  public final boolean bOO()
  {
    return false;
  }
  
  public final boolean djo()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.vuq.EfX != null)
    {
      bool1 = bool2;
      if (this.vuq.EfX.dtM == 1) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67392);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67392);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cks)((com.tencent.mm.al.b)paramq).gUT.gUX;
    this.IdO = paramq.dcG;
    this.IdP = paramq.nTK;
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