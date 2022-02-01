package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.cnk;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.wallet_core.c.j;

public final class m
  extends a<cnl>
  implements j
{
  public m(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(68449);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cnk();
    ((b.a)localObject).hNN = new cnl();
    ((b.a)localObject).funcId = 1276;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/purchasefund";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDC();
    cnk localcnk = (cnk)((b)localObject).hNK.hNQ;
    localcnk.HgB = paramString1;
    localcnk.HgC = paramInt1;
    localcnk.uxm = paramInt2;
    localcnk.HgD = paramString2;
    localcnk.Hfb = paramString3;
    localcnk.Cyj = paramInt3;
    localcnk.Cyu = ae.eCl();
    c((b)localObject);
    AppMethodBeat.o(68449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.m
 * JD-Core Version:    0.7.0.1
 */