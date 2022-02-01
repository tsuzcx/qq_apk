package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.egg;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.protocal.protobuf.jl;
import com.tencent.mm.wallet_core.model.z;

public final class m
  extends z<egh>
{
  public m(int paramInt1, jl paramjl, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(68448);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new egg();
    ((c.a)localObject).otF = new egh();
    ((c.a)localObject).funcId = 1324;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/preredeemfund";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    egg localegg = (egg)c.b.b(((c)localObject).otB);
    localegg.ablD = paramInt1;
    if (paramjl != null) {
      localegg.ablE = 1;
    }
    for (localegg.ablF = paramjl;; localegg.ablF = null)
    {
      localegg.JaC = paramInt2;
      localegg.ablG = paramInt3;
      localegg.ablH = paramString;
      localegg.Vbl = ai.ieD();
      c((c)localObject);
      AppMethodBeat.o(68448);
      return;
      localegg.ablE = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.m
 * JD-Core Version:    0.7.0.1
 */