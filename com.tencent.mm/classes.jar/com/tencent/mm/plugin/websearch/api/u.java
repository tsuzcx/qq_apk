package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cze;
import com.tencent.mm.protocal.protobuf.czf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;

public final class u
  extends q
  implements m
{
  public czf IDC;
  public cze IDD;
  private i callback;
  private d iUB;
  
  public u(cze paramcze)
  {
    AppMethodBeat.i(117620);
    this.IDD = paramcze;
    Object localObject = this.IDD;
    if (ao.isDarkMode()) {}
    for (int i = 1;; i = 0)
    {
      ((cze)localObject).MEt = i;
      paramcze.MlQ = ai.clJ();
      paramcze.MlR = ai.fYd();
      this.IDC = new czf();
      localObject = new d.a();
      ((d.a)localObject).funcId = 1076;
      ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/pardussearch";
      ((d.a)localObject).iLN = paramcze;
      ((d.a)localObject).iLO = this.IDC;
      this.iUB = ((d.a)localObject).aXF();
      AppMethodBeat.o(117620);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(117621);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(117621);
    return i;
  }
  
  public final czf fXO()
  {
    return this.IDC;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.u
 * JD-Core Version:    0.7.0.1
 */