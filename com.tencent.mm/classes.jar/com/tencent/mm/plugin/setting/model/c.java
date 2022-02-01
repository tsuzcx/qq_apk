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
import com.tencent.mm.protocal.protobuf.adr;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.dts;

public final class c
  extends n
  implements k
{
  public final String appId;
  private f callback;
  private final int scene;
  
  public c(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.scene = paramInt;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(73764);
    this.callback = paramf;
    paramf = new b.a();
    adr localadr = new adr();
    localadr.duW = this.appId;
    localadr.dHZ = this.scene;
    paramf.hNM = localadr;
    paramf.uri = "/cgi-bin/mmbiz-bin/deluserauth";
    paramf.hNN = new ads();
    paramf.funcId = getType();
    paramf.hNO = 0;
    paramf.respCmdId = 0;
    int i = dispatch(parame, paramf.aDC(), this);
    AppMethodBeat.o(73764);
    return i;
  }
  
  public final int getType()
  {
    return 1127;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73765);
    paramString = (ads)((b)paramq).hNL.hNQ;
    this.callback.onSceneEnd(paramInt2, paramString.Gcg.dqI, paramString.Gcg.dqJ, this);
    AppMethodBeat.o(73765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.c
 * JD-Core Version:    0.7.0.1
 */