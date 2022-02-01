package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eko;
import com.tencent.mm.protocal.protobuf.ekp;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public d(String paramString)
  {
    AppMethodBeat.i(97133);
    c.a locala = new c.a();
    locala.otE = new eko();
    locala.otF = new ekp();
    locala.uri = "/cgi-bin/mmoc-bin/adplayinfo/query_ad_redpkt_state";
    locala.funcId = 2944;
    this.rr = locala.bEF();
    ((eko)c.b.b(this.rr.otB)).abpA = paramString;
    AppMethodBeat.o(97133);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(97136);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(97136);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(97135);
    int i = this.rr.getType();
    AppMethodBeat.o(97135);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97134);
    Log.i("NetSceneAdGetHbCoverState", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.d
 * JD-Core Version:    0.7.0.1
 */