package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ewu;
import com.tencent.mm.protocal.protobuf.ewv;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public l(String paramString, int paramInt)
  {
    AppMethodBeat.i(213168);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ewu();
    ((d.a)localObject).lBV = new ewv();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/update_shared_uxinfo";
    ((d.a)localObject).funcId = 2883;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ewu)d.b.b(this.rr.lBR);
    ((ewu)localObject).Uxw = paramString;
    ((ewu)localObject).enterScene = paramInt;
    AppMethodBeat.o(213168);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(97161);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(97161);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(97160);
    int i = this.rr.getType();
    AppMethodBeat.o(97160);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97159);
    Log.i("NetSceneUpdateUxInfo", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.l
 * JD-Core Version:    0.7.0.1
 */