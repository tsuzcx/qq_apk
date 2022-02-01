package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class u
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public final boolean dBH;
  private b rr;
  private String uLU;
  
  public u(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(122719);
    this.uLU = "";
    this.dBH = paramBoolean;
    this.uLU = bt.nullAsNil(paramString);
    AppMethodBeat.o(122719);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(122720);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ae();
    ((b.a)localObject).gUV = new af();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/switchpushmail";
    ((b.a)localObject).funcId = 129;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (ae)this.rr.gUS.gUX;
    if (this.dBH) {}
    for (int i = 1;; i = 2)
    {
      ((ae)localObject).uMR = i;
      ((ae)localObject).uMS = this.uLU;
      this.callback = paramg;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(122720);
      return i;
    }
  }
  
  public final int getType()
  {
    return 24;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(122721);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (af)this.rr.gUT.gUX;
      com.tencent.mm.kernel.g.afB().afk().set(17, Integer.valueOf(paramq.uMR));
    }
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(122721);
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.u
 * JD-Core Version:    0.7.0.1
 */