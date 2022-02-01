package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.adk;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.wallet_core.model.z;

public final class f
  extends z<adl>
{
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(68403);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new adk();
    ((c.a)localObject).otF = new adl();
    ((c.a)localObject).funcId = 1386;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/closefundaccount";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    adk localadk = (adk)c.b.b(((c)localObject).otB);
    localadk.ZlW = paramString;
    localadk.JaC = paramInt;
    localadk.Vbl = ai.ieD();
    c((c)localObject);
    AppMethodBeat.o(68403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.f
 * JD-Core Version:    0.7.0.1
 */