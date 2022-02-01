package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dsv;
import com.tencent.mm.protocal.protobuf.dsw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class u
  extends n
  implements k
{
  dsv AGk;
  dsw AGl;
  private g callback;
  private b hdD;
  
  public u(int paramInt)
  {
    AppMethodBeat.i(117635);
    this.AGk = new dsv();
    b.a locala = new b.a();
    locala.funcId = 1948;
    locala.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
    locala.gUU = new dsv();
    locala.gUV = new dsw();
    this.hdD = locala.atI();
    this.AGk = ((dsv)this.hdD.gUS.gUX);
    this.AGk.DLD = aa.Sb(0);
    this.AGk.oXs = ac.ir(aj.getContext());
    this.AGk.nlG = aa.cWN();
    this.AGk.DLE = aa.bCk();
    this.AGk.Scene = paramInt;
    this.AGk.CNp = 0L;
    AppMethodBeat.o(117635);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(117636);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
    AppMethodBeat.o(117636);
    return i;
  }
  
  public final int getType()
  {
    return 1948;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117637);
    ad.i("MicroMsg.WebSearch.NetSceneWebSearchConfig", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(117637);
      return;
    }
    this.AGl = ((dsw)this.hdD.gUT.gUX);
    if (this.AGl != null) {
      ad.v("MicroMsg.WebSearch.NetSceneWebSearchConfig", "return data\n%s", new Object[] { this.AGl.DLy });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.u
 * JD-Core Version:    0.7.0.1
 */