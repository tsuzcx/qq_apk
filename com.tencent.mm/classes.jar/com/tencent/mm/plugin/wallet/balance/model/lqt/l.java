package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.protocal.protobuf.in;

public final class l
  extends a<cmp>
{
  public l(int paramInt1, in paramin, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(68448);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cmo();
    ((b.a)localObject).hQG = new cmp();
    ((b.a)localObject).funcId = 1324;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/preredeemfund";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDS();
    cmo localcmo = (cmo)((b)localObject).hQD.hQJ;
    localcmo.Hyx = paramInt1;
    if (paramin != null) {
      localcmo.Hyy = 1;
    }
    for (localcmo.Hyz = paramin;; localcmo.Hyz = null)
    {
      localcmo.uIM = paramInt2;
      localcmo.HyA = paramInt3;
      localcmo.HyB = paramString;
      localcmo.CPZ = ae.eFT();
      c((b)localObject);
      AppMethodBeat.o(68448);
      return;
      localcmo.Hyy = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.l
 * JD-Core Version:    0.7.0.1
 */