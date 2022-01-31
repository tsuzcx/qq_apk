package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class t
  extends m
  implements k
{
  public final boolean cKK;
  private f callback;
  private String pJB;
  private b rr;
  
  public t(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(67985);
    this.pJB = "";
    this.cKK = paramBoolean;
    this.pJB = bo.nullAsNil(paramString);
    AppMethodBeat.o(67985);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(67986);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ad();
    ((b.a)localObject).fsY = new ae();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/switchpushmail";
    ((b.a)localObject).funcId = 129;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (ad)this.rr.fsV.fta;
    if (this.cKK) {}
    for (int i = 1;; i = 2)
    {
      ((ad)localObject).pKC = i;
      ((ad)localObject).pKD = this.pJB;
      this.callback = paramf;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(67986);
      return i;
    }
  }
  
  public final int getType()
  {
    return 24;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67987);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ae)this.rr.fsW.fta;
      g.RL().Ru().set(17, Integer.valueOf(paramq.pKC));
    }
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(67987);
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.t
 * JD-Core Version:    0.7.0.1
 */