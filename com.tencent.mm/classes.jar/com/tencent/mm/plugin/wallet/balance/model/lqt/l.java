package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.ia;

public final class l
  extends c<cbu>
{
  public l(int paramInt1, ia paramia, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(68448);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cbt();
    ((b.a)localObject).gUV = new cbu();
    ((b.a)localObject).funcId = 1324;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/preredeemfund";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).atI();
    cbt localcbt = (cbt)((b)localObject).gUS.gUX;
    localcbt.DXY = paramInt1;
    if (paramia != null) {
      localcbt.DXZ = 1;
    }
    for (localcbt.DYa = paramia;; localcbt.DYa = null)
    {
      localcbt.CYU = paramInt2;
      localcbt.DYb = paramInt3;
      localcbt.DYc = paramString;
      localcbt.zFY = ae.dYR();
      this.rr = ((b)localObject);
      AppMethodBeat.o(68448);
      return;
      localcbt.DXZ = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.l
 * JD-Core Version:    0.7.0.1
 */