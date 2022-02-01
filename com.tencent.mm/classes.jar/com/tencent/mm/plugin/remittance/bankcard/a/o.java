package com.tencent.mm.plugin.remittance.bankcard.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.doq;
import com.tencent.mm.protocal.protobuf.dor;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.j;

public final class o
  extends b
  implements j
{
  public dor CiW;
  private final String TAG;
  private i callback;
  private d rr;
  
  public o(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, int paramInt4, String paramString5, String paramString6, com.tencent.mm.bw.b paramb, int paramInt5)
  {
    AppMethodBeat.i(67391);
    this.TAG = "MicroMsg.NetSceneBankRemitRequestOrder";
    Log.i("MicroMsg.NetSceneBankRemitRequestOrder", "unique_id:%s last_transfer_bill_id:%s unpay_type:%s", new Object[] { Util.nullAsNil(paramString6), Base64.encodeToString(paramb.toByteArray(), 2), Integer.valueOf(paramInt5) });
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new doq();
    ((d.a)localObject).iLO = new dor();
    ((d.a)localObject).funcId = 1380;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/request_tsbc";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (doq)this.rr.iLK.iLR;
    ((doq)localObject).Cjt = paramString1;
    ((doq)localObject).Cju = paramString2;
    ((doq)localObject).dDj = paramString3;
    ((doq)localObject).Cjg = paramInt1;
    ((doq)localObject).MRP = paramInt2;
    ((doq)localObject).MRQ = paramString4;
    ((doq)localObject).MRR = paramInt3;
    ((doq)localObject).MRS = paramInt4;
    ((doq)localObject).KKI = paramString5;
    ((doq)localObject).MBV = paramString6;
    ((doq)localObject).MRT = paramb;
    ((doq)localObject).KYp = paramInt5;
    AppMethodBeat.o(67391);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67393);
    Log.i("MicroMsg.NetSceneBankRemitRequestOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.CiW = ((dor)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBankRemitRequestOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.CiW.dDN), this.CiW.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67393);
  }
  
  public final boolean czQ()
  {
    return false;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67392);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67392);
    return i;
  }
  
  public final void e(s params)
  {
    params = (dor)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
  }
  
  public final boolean eMZ()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.CiW.MRU != null)
    {
      bool1 = bool2;
      if (this.CiW.MRU.cSx == 1) {
        bool1 = false;
      }
    }
    return bool1;
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