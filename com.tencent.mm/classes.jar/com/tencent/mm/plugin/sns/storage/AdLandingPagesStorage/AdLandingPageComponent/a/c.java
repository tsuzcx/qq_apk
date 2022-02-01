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
import com.tencent.mm.protocal.protobuf.cfu;
import com.tencent.mm.protocal.protobuf.cfv;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196264);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cfu();
    ((d.a)localObject).lBV = new cfv();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_wx_user_name";
    ((d.a)localObject).funcId = 4353;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cfu)d.b.b(this.rr.lBR);
    ((cfu)localObject).jDL = paramString1;
    ((cfu)localObject).Tnc = paramString2;
    AppMethodBeat.o(196264);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(196269);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(196269);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(196268);
    int i = this.rr.getType();
    AppMethodBeat.o(196268);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196266);
    Log.i("NetSceneAdGetBtnPersonalUserName", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(196266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c
 * JD-Core Version:    0.7.0.1
 */