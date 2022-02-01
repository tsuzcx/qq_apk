package com.tencent.mm.plugin.normsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.r.a;
import com.tencent.mm.protocal.r.b;

public final class a
  extends q
  implements m
{
  private boolean AEJ;
  private int AEK;
  private final String TAG;
  private i callback;
  private final s iMO;
  
  public a(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149008);
    this.AEJ = true;
    this.AEK = 0;
    this.TAG = "NetSceneFPFresh";
    this.AEJ = paramBoolean;
    this.iMO = new r.a(this.AEJ);
    ((r.b)this.iMO.getReqObj()).KzW.Luw = b.cD(paramArrayOfByte);
    AppMethodBeat.o(149008);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(149009);
    this.callback = parami;
    this.AEK += 1;
    int i = dispatch(paramg, this.iMO, this);
    AppMethodBeat.o(149009);
    return i;
  }
  
  public final int getType()
  {
    if (this.AEJ) {
      return 3944;
    }
    return 836;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149010);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params.getRespObj();
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(149010);
      return;
    }
    if (this.AEK < 2)
    {
      if (doScene(dispatcher(), this.callback) < 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(149010);
        return;
      }
      AppMethodBeat.o(149010);
      return;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(149010);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.a
 * JD-Core Version:    0.7.0.1
 */