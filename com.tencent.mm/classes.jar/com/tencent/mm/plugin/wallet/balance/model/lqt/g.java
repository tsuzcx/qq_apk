package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.cin;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends b<cio>
{
  public g(long paramLong, int paramInt)
  {
    AppMethodBeat.i(316168);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cin();
    ((c.a)localObject).otF = new cio();
    ((c.a)localObject).funcId = 5075;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/getdistributepreview";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    cin localcin = (cin)c.b.b(((c)localObject).otB);
    localcin.ihV = paramLong;
    localcin.scene = paramInt;
    localcin.Vbl = ai.ieD();
    c((c)localObject);
    Log.i("MicroMsg.CgiLqtGetDistributePreview", "init amount: %s, scene: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(316168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.g
 * JD-Core Version:    0.7.0.1
 */