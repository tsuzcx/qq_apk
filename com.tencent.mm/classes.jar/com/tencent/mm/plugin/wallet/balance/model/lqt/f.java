package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.protocal.protobuf.zj;

public final class f
  extends a<zj>
{
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(68403);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new zi();
    ((b.a)localObject).hNN = new zj();
    ((b.a)localObject).funcId = 1386;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/closefundaccount";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDC();
    zi localzi = (zi)((b)localObject).hNK.hNQ;
    localzi.FYP = paramString;
    localzi.uxm = paramInt;
    localzi.Cyu = ae.eCl();
    c((b)localObject);
    AppMethodBeat.o(68403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.f
 * JD-Core Version:    0.7.0.1
 */