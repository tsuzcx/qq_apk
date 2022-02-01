package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cck;
import com.tencent.mm.protocal.protobuf.ccl;

public final class p
  extends a
  implements m
{
  private v PxJ;
  private ccl PxK;
  private i callback;
  private d lKU;
  
  public p(v paramv)
  {
    AppMethodBeat.i(211184);
    this.PxJ = paramv;
    biI(this.PxJ.fIY);
    cck localcck = new cck();
    localcck.CPw = paramv.scene;
    localcck.Tku = paramv.fwv;
    localcck.Tkv = ai.anh(0);
    b.i("MicroMsg.WebSearch.NetSceneGetSearchResult", "create NetSceneGetSearchResult scene:%s requestKey:%s", new Object[] { Integer.valueOf(paramv.scene), paramv.fwv });
    paramv = new d.a();
    paramv.funcId = 1003;
    paramv.uri = "/cgi-bin/mmsearch-bin/getsearchresult";
    paramv.lBU = localcck;
    paramv.lBV = new ccl();
    this.lKU = paramv.bgN();
    AppMethodBeat.o(211184);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(211186);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(211186);
    return i;
  }
  
  public final String gQp()
  {
    if (this.PxK != null) {
      return this.PxK.Tkw;
    }
    return null;
  }
  
  public final int gQq()
  {
    return 0;
  }
  
  public final int getType()
  {
    return 1003;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(211188);
    b.i("MicroMsg.WebSearch.NetSceneGetSearchResult", "netId: %s errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.PxK = ((ccl)d.c.b(this.lKU.lBS));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(211188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.p
 * JD-Core Version:    0.7.0.1
 */