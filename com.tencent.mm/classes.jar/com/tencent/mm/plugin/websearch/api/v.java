package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eba;
import com.tencent.mm.protocal.protobuf.ebb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;

public final class v
  extends p
  implements m
{
  public ebb WnZ;
  public eba Woa;
  private h callback;
  private c oDw;
  
  public v(eba parameba)
  {
    AppMethodBeat.i(117620);
    this.Woa = parameba;
    Object localObject = this.Woa;
    if (aw.isDarkMode()) {}
    for (int i = 1;; i = 0)
    {
      ((eba)localObject).abgz = i;
      parameba.aaLr = aj.dch();
      parameba.aaLs = aj.iqa();
      this.WnZ = new ebb();
      localObject = new c.a();
      ((c.a)localObject).funcId = 1076;
      ((c.a)localObject).uri = "/cgi-bin/mmsearch-bin/pardussearch";
      ((c.a)localObject).otE = parameba;
      ((c.a)localObject).otF = this.WnZ;
      this.oDw = ((c.a)localObject).bEF();
      AppMethodBeat.o(117620);
      return;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(117621);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(117621);
    return i;
  }
  
  public final int getType()
  {
    return 1076;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117622);
    Log.i("MicroMsg.FTS.NetScenePardusSearch", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.v
 * JD-Core Version:    0.7.0.1
 */