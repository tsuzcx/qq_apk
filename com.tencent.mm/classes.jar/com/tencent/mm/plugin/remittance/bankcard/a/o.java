package com.tencent.mm.plugin.remittance.bankcard.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.protocal.protobuf.dym;
import com.tencent.mm.protocal.protobuf.dyn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.j;

public final class o
  extends b
  implements j
{
  public dyn IfP;
  private final String TAG;
  private i callback;
  private d rr;
  
  public o(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, int paramInt4, String paramString5, String paramString6, com.tencent.mm.cd.b paramb, int paramInt5)
  {
    AppMethodBeat.i(67391);
    this.TAG = "MicroMsg.NetSceneBankRemitRequestOrder";
    Log.i("MicroMsg.NetSceneBankRemitRequestOrder", "unique_id:%s last_transfer_bill_id:%s unpay_type:%s", new Object[] { Util.nullAsNil(paramString6), Base64.encodeToString(paramb.toByteArray(), 2), Integer.valueOf(paramInt5) });
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dym();
    ((d.a)localObject).lBV = new dyn();
    ((d.a)localObject).funcId = 1380;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/request_tsbc";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dym)d.b.b(this.rr.lBR);
    ((dym)localObject).Igm = paramString1;
    ((dym)localObject).Ign = paramString2;
    ((dym)localObject).fvP = paramString3;
    ((dym)localObject).IfZ = paramInt1;
    ((dym)localObject).UdW = paramInt2;
    ((dym)localObject).UdX = paramString4;
    ((dym)localObject).UdY = paramInt3;
    ((dym)localObject).UdZ = paramInt4;
    ((dym)localObject).RLA = paramString5;
    ((dym)localObject).TNB = paramString6;
    ((dym)localObject).Uea = paramb;
    ((dym)localObject).RZy = paramInt5;
    AppMethodBeat.o(67391);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67393);
    Log.i("MicroMsg.NetSceneBankRemitRequestOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.IfP = ((dyn)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneBankRemitRequestOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.IfP.fwx), this.IfP.tVo });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67393);
  }
  
  public final boolean cOq()
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
  
  public final void f(s params)
  {
    AppMethodBeat.i(272474);
    params = (dyn)d.c.b(((d)params).lBS);
    this.YVy = params.fwx;
    this.YVz = params.tVo;
    AppMethodBeat.o(272474);
  }
  
  public final boolean fzO()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.IfP.Ueb != null)
    {
      bool1 = bool2;
      if (this.IfP.Ueb.cUP == 1) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.o
 * JD-Core Version:    0.7.0.1
 */