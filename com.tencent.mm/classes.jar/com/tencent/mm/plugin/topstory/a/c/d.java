package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvd;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public d(String paramString)
  {
    AppMethodBeat.i(88480);
    c.a locala = new c.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmsearch-bin/getuserattrbyopenid";
    locala.otE = new cvc();
    locala.otF = new cvd();
    this.rr = locala.bEF();
    ((cvc)c.b.b(this.rr.otB)).openid = paramString;
    AppMethodBeat.o(88480);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(88481);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(88481);
    return i;
  }
  
  public final int getType()
  {
    return 2830;
  }
  
  public final cvd hMS()
  {
    AppMethodBeat.i(271655);
    cvd localcvd = (cvd)c.c.b(this.rr.otC);
    AppMethodBeat.o(271655);
    return localcvd;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88482);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryGetUsername", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.d
 * JD-Core Version:    0.7.0.1
 */