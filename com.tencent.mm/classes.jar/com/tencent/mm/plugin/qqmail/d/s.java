package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class s
  extends n
  implements k
{
  private f callback;
  private final boolean dMW;
  private b rr;
  private String xrP;
  
  public s(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(122719);
    this.xrP = "";
    this.dMW = paramBoolean;
    this.xrP = bu.nullAsNil(paramString);
    AppMethodBeat.o(122719);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(122720);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ad();
    ((b.a)localObject).hQG = new ae();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/switchpushmail";
    ((b.a)localObject).funcId = 129;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ad)this.rr.hQD.hQJ;
    if (this.dMW) {}
    for (int i = 1;; i = 2)
    {
      ((ad)localObject).xsz = i;
      ((ad)localObject).xsA = this.xrP;
      this.callback = paramf;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(122720);
      return i;
    }
  }
  
  public final int getType()
  {
    return 129;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(122721);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ae)this.rr.hQE.hQJ;
      g.ajR().ajA().set(17, Integer.valueOf(paramq.xsz));
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
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.s
 * JD-Core Version:    0.7.0.1
 */