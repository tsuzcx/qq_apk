package com.tencent.mm.plugin.remittance.bankcard.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.buz;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.dc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.i;

public final class o
  extends b
  implements i
{
  private final String TAG;
  private f callback;
  public bva qfX;
  private com.tencent.mm.ai.b rr;
  
  public o(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, int paramInt4, String paramString5, String paramString6, com.tencent.mm.bv.b paramb, int paramInt5)
  {
    AppMethodBeat.i(44482);
    this.TAG = "MicroMsg.NetSceneBankRemitRequestOrder";
    ab.i("MicroMsg.NetSceneBankRemitRequestOrder", "unique_id:%s last_transfer_bill_id:%s unpay_type:%s", new Object[] { bo.nullAsNil(paramString6), Base64.encodeToString(paramb.toByteArray(), 2), Integer.valueOf(paramInt5) });
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new buz();
    ((b.a)localObject).fsY = new bva();
    ((b.a)localObject).funcId = 1380;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/request_tsbc";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (buz)this.rr.fsV.fta;
    ((buz)localObject).qgu = paramString1;
    ((buz)localObject).qgv = paramString2;
    ((buz)localObject).poq = paramString3;
    ((buz)localObject).qgh = paramInt1;
    ((buz)localObject).xID = paramInt2;
    ((buz)localObject).xIE = paramString4;
    ((buz)localObject).xIF = paramInt3;
    ((buz)localObject).xIG = paramInt4;
    ((buz)localObject).wry = paramString5;
    ((buz)localObject).xxV = paramString6;
    ((buz)localObject).xIH = paramb;
    ((buz)localObject).wBk = paramInt5;
    AppMethodBeat.o(44482);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(44484);
    ab.i("MicroMsg.NetSceneBankRemitRequestOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qfX = ((bva)((com.tencent.mm.ai.b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneBankRemitRequestOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qfX.cnK), this.qfX.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(44484);
  }
  
  public final boolean bhS()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.qfX.xII != null)
    {
      bool1 = bool2;
      if (this.qfX.xII.bsY == 1) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44483);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44483);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (bva)((com.tencent.mm.ai.b)paramq).fsW.fta;
    this.AXb = paramq.cnK;
    this.AXc = paramq.kNv;
  }
  
  public final int getType()
  {
    return 1380;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.o
 * JD-Core Version:    0.7.0.1
 */