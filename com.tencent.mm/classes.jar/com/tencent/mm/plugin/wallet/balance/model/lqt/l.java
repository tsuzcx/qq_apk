package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.protocal.protobuf.ig;

public final class l
  extends c<cgw>
{
  public l(int paramInt1, ig paramig, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(68448);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cgv();
    ((b.a)localObject).hvu = new cgw();
    ((b.a)localObject).funcId = 1324;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/preredeemfund";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aAz();
    cgv localcgv = (cgv)((b)localObject).hvr.hvw;
    localcgv.FuS = paramInt1;
    if (paramig != null) {
      localcgv.FuT = 1;
    }
    for (localcgv.FuU = paramig;; localcgv.FuU = null)
    {
      localcgv.ErG = paramInt2;
      localcgv.FuV = paramInt3;
      localcgv.FuW = paramString;
      localcgv.AYl = ae.eon();
      this.rr = ((b)localObject);
      AppMethodBeat.o(68448);
      return;
      localcgv.FuT = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.l
 * JD-Core Version:    0.7.0.1
 */