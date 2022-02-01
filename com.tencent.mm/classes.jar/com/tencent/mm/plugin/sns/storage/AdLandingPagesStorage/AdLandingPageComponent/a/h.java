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
import com.tencent.mm.protocal.protobuf.eem;
import com.tencent.mm.protocal.protobuf.een;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public h(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    AppMethodBeat.i(245685);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new eem();
    ((d.a)localObject).lBV = new een();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/send_subscription_msg";
    ((d.a)localObject).funcId = 2810;
    this.rr = ((d.a)localObject).bgN();
    localObject = (eem)d.b.b(this.rr.lBR);
    ((eem)localObject).Uin = paramString1;
    ((eem)localObject).jDL = paramString2;
    ((eem)localObject).KlG = paramLong;
    ((eem)localObject).SCm = paramString3;
    AppMethodBeat.o(245685);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(245687);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(245687);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(245686);
    int i = this.rr.getType();
    AppMethodBeat.o(245686);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(245688);
    Log.i("NetSceneAdSubscribe", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(245688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.h
 * JD-Core Version:    0.7.0.1
 */