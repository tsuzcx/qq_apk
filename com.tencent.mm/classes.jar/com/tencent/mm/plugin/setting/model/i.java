package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.dts;

public final class i
  extends n
  implements k
{
  private f callback;
  private final String duW;
  private final int scene;
  public final String yCR;
  public final int yCS;
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.duW = paramString1;
    this.yCR = paramString2;
    this.yCS = paramInt1;
    this.scene = paramInt2;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(73777);
    this.callback = paramf;
    paramf = new b.a();
    can localcan = new can();
    localcan.duW = this.duW;
    localcan.GVb = this.yCR;
    localcan.GVc = this.yCS;
    paramf.hNM = localcan;
    paramf.uri = "/cgi-bin/mmbiz-bin/moduserauth";
    paramf.hNN = new cao();
    paramf.funcId = getType();
    paramf.hNO = 0;
    paramf.respCmdId = 0;
    int i = dispatch(parame, paramf.aDC(), this);
    AppMethodBeat.o(73777);
    return i;
  }
  
  public final int getType()
  {
    return 1144;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73776);
    paramString = (cao)((b)paramq).hNL.hNQ;
    this.callback.onSceneEnd(paramInt2, paramString.Gcg.dqI, paramString.Gcg.dqJ, this);
    AppMethodBeat.o(73776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.i
 * JD-Core Version:    0.7.0.1
 */