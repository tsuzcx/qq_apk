package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ctx;
import com.tencent.mm.protocal.protobuf.cty;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends p
  implements m
{
  private h callback;
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(73770);
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new ctx();
    paramh.otF = new cty();
    paramh.uri = "/cgi-bin/micromsg-bin/gettrustedfriends";
    paramh.funcId = 869;
    paramh.otG = 0;
    paramh.respCmdId = 0;
    int i = dispatch(paramg, paramh.bEF(), this);
    AppMethodBeat.o(73770);
    return i;
  }
  
  public final int getType()
  {
    return 869;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73769);
    updateDispatchIdNew(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.j
 * JD-Core Version:    0.7.0.1
 */