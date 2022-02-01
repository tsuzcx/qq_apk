package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.protocal.protobuf.but;

public final class p
  extends a
  implements m
{
  private v IDt;
  private but IDu;
  private i callback;
  private d iUB;
  
  public p(v paramv)
  {
    AppMethodBeat.i(187823);
    this.IDt = paramv;
    aWX(this.IDt.dPI);
    bus localbus = new bus();
    localbus.Scene = paramv.scene;
    localbus.MaX = paramv.dDL;
    localbus.MaY = ai.aft(0);
    b.i("MicroMsg.WebSearch.NetSceneGetSearchResult", "create NetSceneGetSearchResult scene:%s requestKey:%s", new Object[] { Integer.valueOf(paramv.scene), paramv.dDL });
    paramv = new d.a();
    paramv.funcId = 1003;
    paramv.uri = "/cgi-bin/mmsearch-bin/getsearchresult";
    paramv.iLN = localbus;
    paramv.iLO = new but();
    this.iUB = paramv.aXF();
    AppMethodBeat.o(187823);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(187824);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(187824);
    return i;
  }
  
  public final String fXC()
  {
    if (this.IDu != null) {
      return this.IDu.MaZ;
    }
    return null;
  }
  
  public final int fXD()
  {
    return 0;
  }
  
  public final int getType()
  {
    return 1003;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187825);
    b.i("MicroMsg.WebSearch.NetSceneGetSearchResult", "netId: %s errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.IDu = ((but)this.iUB.iLL.iLR);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(187825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.p
 * JD-Core Version:    0.7.0.1
 */