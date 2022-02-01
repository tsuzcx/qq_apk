package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bp;
import com.tencent.mm.protocal.protobuf.bq;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(203128);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bp();
    ((d.a)localObject).iLO = new bq();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/ad_anti_abuse";
    ((d.a)localObject).funcId = 4679;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bp)this.rr.iLK.iLR;
    ((bp)localObject).lAN = paramString1;
    ((bp)localObject).uxInfo = paramString2;
    ((bp)localObject).enterScene = paramInt;
    ((bp)localObject).adExtInfo = paramString3;
    AppMethodBeat.o(203128);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(203130);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(203130);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(203129);
    int i = this.rr.getType();
    AppMethodBeat.o(203129);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(203131);
    Log.i("NetSceneAdAntiAbuse", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(203131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a
 * JD-Core Version:    0.7.0.1
 */