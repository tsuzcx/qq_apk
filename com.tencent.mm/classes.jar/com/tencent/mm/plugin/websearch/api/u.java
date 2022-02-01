package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.protocal.protobuf.dir;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;

public final class u
  extends q
  implements m
{
  public dir PxS;
  public diq PxT;
  private i callback;
  private d lKU;
  
  public u(diq paramdiq)
  {
    AppMethodBeat.i(117620);
    this.PxT = paramdiq;
    Object localObject = this.PxT;
    if (ar.isDarkMode()) {}
    for (int i = 1;; i = 0)
    {
      ((diq)localObject).TQc = i;
      paramdiq.TwK = ai.czn();
      paramdiq.TwL = ai.gQO();
      this.PxS = new dir();
      localObject = new d.a();
      ((d.a)localObject).funcId = 1076;
      ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/pardussearch";
      ((d.a)localObject).lBU = paramdiq;
      ((d.a)localObject).lBV = this.PxS;
      this.lKU = ((d.a)localObject).bgN();
      AppMethodBeat.o(117620);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(117621);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(117621);
    return i;
  }
  
  public final dir gQz()
  {
    return this.PxS;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.u
 * JD-Core Version:    0.7.0.1
 */