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
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(265685);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bn();
    ((d.a)localObject).lBV = new bo();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/ad_anti_abuse";
    ((d.a)localObject).funcId = 4679;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bn)d.b.b(this.rr.lBR);
    ((bn)localObject).owd = paramString1;
    ((bn)localObject).uxInfo = paramString2;
    ((bn)localObject).enterScene = paramInt;
    ((bn)localObject).adExtInfo = paramString3;
    AppMethodBeat.o(265685);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(265687);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(265687);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(265686);
    int i = this.rr.getType();
    AppMethodBeat.o(265686);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(265688);
    Log.i("NetSceneAdAntiAbuse", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(265688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a
 * JD-Core Version:    0.7.0.1
 */