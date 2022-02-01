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
import com.tencent.mm.protocal.protobuf.dui;
import com.tencent.mm.protocal.protobuf.duj;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public h(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    AppMethodBeat.i(203143);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dui();
    ((d.a)localObject).iLO = new duj();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/send_subscription_msg";
    ((d.a)localObject).funcId = 2810;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dui)this.rr.iLK.iLR;
    ((dui)localObject).MVS = paramString1;
    ((dui)localObject).gTk = paramString2;
    ((dui)localObject).DYn = paramLong;
    ((dui)localObject).LzN = paramString3;
    AppMethodBeat.o(203143);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(203145);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(203145);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(203144);
    int i = this.rr.getType();
    AppMethodBeat.o(203144);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(203146);
    Log.i("NetSceneAdSubscribe", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(203146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.h
 * JD-Core Version:    0.7.0.1
 */