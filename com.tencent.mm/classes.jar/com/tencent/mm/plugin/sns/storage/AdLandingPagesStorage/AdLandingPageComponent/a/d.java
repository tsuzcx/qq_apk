package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.protocal.protobuf.dic;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  private i callback;
  private com.tencent.mm.ak.d rr;
  
  public d(String paramString)
  {
    AppMethodBeat.i(97133);
    d.a locala = new d.a();
    locala.iLN = new dib();
    locala.iLO = new dic();
    locala.uri = "/cgi-bin/mmoc-bin/adplayinfo/query_ad_redpkt_state";
    locala.funcId = 2944;
    this.rr = locala.aXF();
    ((dib)this.rr.iLK.iLR).MMJ = paramString;
    AppMethodBeat.o(97133);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(97136);
    this.callback = parami;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d
 * JD-Core Version:    0.7.0.1
 */