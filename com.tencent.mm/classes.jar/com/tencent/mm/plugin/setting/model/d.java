package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.agd;
import com.tencent.mm.protocal.protobuf.age;
import com.tencent.mm.protocal.protobuf.eoo;

public final class d
  extends q
  implements m
{
  public final String appId;
  private i callback;
  private final int scene;
  
  public d(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.scene = paramInt;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(73764);
    this.callback = parami;
    parami = new d.a();
    agd localagd = new agd();
    localagd.dNI = this.appId;
    localagd.eaQ = this.scene;
    parami.iLN = localagd;
    parami.uri = "/cgi-bin/mmbiz-bin/deluserauth";
    parami.iLO = new age();
    parami.funcId = getType();
    parami.iLP = 0;
    parami.respCmdId = 0;
    int i = dispatch(paramg, parami.aXF(), this);
    AppMethodBeat.o(73764);
    return i;
  }
  
  public final int getType()
  {
    return 1127;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73765);
    paramString = (age)((com.tencent.mm.ak.d)params).iLL.iLR;
    this.callback.onSceneEnd(paramInt2, paramString.Lqs.dIZ, paramString.Lqs.dJa, this);
    AppMethodBeat.o(73765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.d
 * JD-Core Version:    0.7.0.1
 */