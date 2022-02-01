package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aea;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.protocal.protobuf.dup;

public final class d
  extends n
  implements k
{
  public final String appId;
  private f callback;
  private final int scene;
  
  public d(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.scene = paramInt;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(73764);
    this.callback = paramf;
    paramf = new b.a();
    aea localaea = new aea();
    localaea.dwb = this.appId;
    localaea.dJd = this.scene;
    paramf.hQF = localaea;
    paramf.uri = "/cgi-bin/mmbiz-bin/deluserauth";
    paramf.hQG = new aeb();
    paramf.funcId = getType();
    paramf.hQH = 0;
    paramf.respCmdId = 0;
    int i = dispatch(parame, paramf.aDS(), this);
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
    paramString = (aeb)((b)paramq).hQE.hQJ;
    this.callback.onSceneEnd(paramInt2, paramString.GuN.drN, paramString.GuN.drO, this);
    AppMethodBeat.o(73765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.d
 * JD-Core Version:    0.7.0.1
 */