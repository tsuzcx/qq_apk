package com.tencent.mm.plugin.normsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.s.a;
import com.tencent.mm.protocal.s.b;

public final class b
  extends q
  implements m
{
  private boolean GxN;
  private int GxO;
  private final String TAG;
  private i callback;
  private final s lCW;
  
  public b(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149011);
    this.GxN = true;
    this.GxO = 0;
    this.TAG = "NetSceneFPInit";
    this.GxN = paramBoolean;
    this.lCW = new s.a(this.GxN);
    ((s.b)this.lCW.getReqObj()).RBQ.SwU = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    AppMethodBeat.o(149011);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(149012);
    this.callback = parami;
    this.GxO += 1;
    int i = dispatch(paramg, this.lCW, this);
    AppMethodBeat.o(149012);
    return i;
  }
  
  public final int getType()
  {
    if (this.GxN) {
      return 3789;
    }
    return 3644;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149013);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params.getRespObj();
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(149013);
      return;
    }
    if (this.GxO < 2)
    {
      if (doScene(dispatcher(), this.callback) < 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(149013);
        return;
      }
      AppMethodBeat.o(149013);
      return;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(149013);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b
 * JD-Core Version:    0.7.0.1
 */