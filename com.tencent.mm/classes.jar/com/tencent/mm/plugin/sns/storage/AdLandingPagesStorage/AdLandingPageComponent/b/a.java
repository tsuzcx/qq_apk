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
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(306815);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new bx();
    ((c.a)localObject).otF = new by();
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/ad_anti_abuse";
    ((c.a)localObject).funcId = 4679;
    this.rr = ((c.a)localObject).bEF();
    localObject = (bx)c.b.b(this.rr.otB);
    ((bx)localObject).rzx = paramString1;
    ((bx)localObject).uxInfo = paramString2;
    ((bx)localObject).enterScene = paramInt;
    ((bx)localObject).adExtInfo = paramString3;
    AppMethodBeat.o(306815);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(306826);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(306826);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(306821);
    int i = this.rr.getType();
    AppMethodBeat.o(306821);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(306832);
    Log.i("NetSceneAdAntiAbuse", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(306832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a
 * JD-Core Version:    0.7.0.1
 */