package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public d(String paramString)
  {
    AppMethodBeat.i(88480);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmsearch-bin/getuserattrbyopenid";
    locala.hNM = new bke();
    locala.hNN = new bkf();
    this.rr = locala.aDC();
    ((bke)this.rr.hNK.hNQ).FxE = paramString;
    AppMethodBeat.o(88480);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(88481);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88481);
    return i;
  }
  
  public final bkf eoW()
  {
    return (bkf)this.rr.hNL.hNQ;
  }
  
  public final int getType()
  {
    return 2830;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88482);
    ad.i("MicroMsg.TopStory.NetSceneTopStoryGetUsername", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.d
 * JD-Core Version:    0.7.0.1
 */