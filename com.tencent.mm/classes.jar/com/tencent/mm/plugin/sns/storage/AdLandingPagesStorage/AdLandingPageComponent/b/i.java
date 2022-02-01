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
import com.tencent.mm.protocal.protobuf.eyd;
import com.tencent.mm.protocal.protobuf.eye;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public i(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    AppMethodBeat.i(306813);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eyd();
    ((c.a)localObject).otF = new eye();
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/send_subscription_msg";
    ((c.a)localObject).funcId = 2810;
    this.rr = ((c.a)localObject).bEF();
    localObject = (eyd)c.b.b(this.rr.otB);
    ((eyd)localObject).abzC = paramString1;
    ((eyd)localObject).mdG = paramString2;
    ((eyd)localObject).Bee = paramLong;
    ((eyd)localObject).ZDe = paramString3;
    AppMethodBeat.o(306813);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(306825);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(306825);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(306818);
    int i = this.rr.getType();
    AppMethodBeat.o(306818);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(306829);
    Log.i("NetSceneAdSubscribe", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(306829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.i
 * JD-Core Version:    0.7.0.1
 */