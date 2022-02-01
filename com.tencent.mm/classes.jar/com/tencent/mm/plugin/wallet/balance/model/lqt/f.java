package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.zl;
import com.tencent.mm.protocal.protobuf.zm;

public final class f
  extends a<zm>
{
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(68403);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new zl();
    ((b.a)localObject).hQG = new zm();
    ((b.a)localObject).funcId = 1386;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/closefundaccount";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDS();
    zl localzl = (zl)((b)localObject).hQD.hQJ;
    localzl.Gro = paramString;
    localzl.uIM = paramInt;
    localzl.CPZ = ae.eFT();
    c((b)localObject);
    AppMethodBeat.o(68403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.f
 * JD-Core Version:    0.7.0.1
 */