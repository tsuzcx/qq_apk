package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.clu;
import com.tencent.mm.protocal.protobuf.clv;
import com.tencent.mm.protocal.protobuf.in;

public final class l
  extends a<clv>
{
  public l(int paramInt1, in paramin, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(68448);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new clu();
    ((b.a)localObject).hNN = new clv();
    ((b.a)localObject).funcId = 1324;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/preredeemfund";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDC();
    clu localclu = (clu)((b)localObject).hNK.hNQ;
    localclu.HeX = paramInt1;
    if (paramin != null) {
      localclu.HeY = 1;
    }
    for (localclu.HeZ = paramin;; localclu.HeZ = null)
    {
      localclu.uxm = paramInt2;
      localclu.Hfa = paramInt3;
      localclu.Hfb = paramString;
      localclu.Cyu = ae.eCl();
      c((b)localObject);
      AppMethodBeat.o(68448);
      return;
      localclu.HeY = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.l
 * JD-Core Version:    0.7.0.1
 */