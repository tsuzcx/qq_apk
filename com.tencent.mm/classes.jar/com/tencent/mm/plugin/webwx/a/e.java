package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aax;
import com.tencent.mm.protocal.protobuf.aay;

public final class e
  extends m
  implements k
{
  private f callback;
  public final b fBd;
  public boolean vuh;
  
  public e(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(26503);
    this.vuh = paramBoolean;
    b.a locala = new b.a();
    aax localaax = new aax();
    aay localaay = new aay();
    locala.fsX = localaax;
    locala.fsY = localaay;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
    locala.funcId = 972;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    localaax.wRk = paramString1;
    localaax.wRv = paramString2;
    localaax.wRx = paramBoolean;
    this.fBd = locala.ado();
    AppMethodBeat.o(26503);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(26504);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(26504);
    return i;
  }
  
  public final int getType()
  {
    return 972;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26505);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.e
 * JD-Core Version:    0.7.0.1
 */