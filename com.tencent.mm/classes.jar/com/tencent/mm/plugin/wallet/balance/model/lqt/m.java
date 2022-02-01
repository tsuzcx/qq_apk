package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.wallet_core.c.j;

public final class m
  extends c<dgc>
  implements j
{
  public m(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(213846);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dgb();
    ((d.a)localObject).iLO = new dgc();
    ((d.a)localObject).funcId = 1276;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/purchasefund";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    dgb localdgb = (dgb)((d)localObject).iLK.iLR;
    localdgb.Mnl = paramString1;
    localdgb.MKM = paramInt1;
    localdgb.yba = paramInt2;
    localdgb.Mnk = paramString2;
    localdgb.MJh = paramString3;
    localdgb.HuF = paramInt3;
    localdgb.dDj = paramString4;
    localdgb.HWx = paramString5;
    localdgb.MKN = 1;
    localdgb.MKO = 1;
    localdgb.HuS = ag.fNb();
    localdgb.MKO = 1;
    localdgb.MKN = 1;
    c((d)localObject);
    AppMethodBeat.o(213846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.m
 * JD-Core Version:    0.7.0.1
 */