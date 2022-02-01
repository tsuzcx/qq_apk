package com.tencent.mm.plugin.normsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.s.a;
import com.tencent.mm.protocal.s.b;

public final class b
  extends p
  implements m
{
  private boolean MtT;
  private int MtU;
  private final String TAG;
  private h callback;
  private final s ouH;
  
  public b(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149011);
    this.MtT = true;
    this.MtU = 0;
    this.TAG = "NetSceneFPInit";
    this.MtT = paramBoolean;
    this.ouH = new s.a(this.MtT);
    ((s.b)this.ouH.getReqObj()).Yyt.ZxE = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    AppMethodBeat.o(149011);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(149012);
    this.callback = paramh;
    this.MtU += 1;
    int i = dispatch(paramg, this.ouH, this);
    AppMethodBeat.o(149012);
    return i;
  }
  
  public final int getType()
  {
    if (this.MtT) {
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
    if (this.MtU < 2)
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
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b
 * JD-Core Version:    0.7.0.1
 */