package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.bs;

public final class u
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public final boolean dzv;
  private b rr;
  private String vUK;
  
  public u(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(122719);
    this.vUK = "";
    this.dzv = paramBoolean;
    this.vUK = bs.nullAsNil(paramString);
    AppMethodBeat.o(122719);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(122720);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ae();
    ((b.a)localObject).hvu = new af();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/switchpushmail";
    ((b.a)localObject).funcId = 129;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (ae)this.rr.hvr.hvw;
    if (this.dzv) {}
    for (int i = 1;; i = 2)
    {
      ((ae)localObject).vVH = i;
      ((ae)localObject).vVI = this.vUK;
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
      paramq = (af)this.rr.hvs.hvw;
      com.tencent.mm.kernel.g.agR().agA().set(17, Integer.valueOf(paramq.vVH));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.u
 * JD-Core Version:    0.7.0.1
 */