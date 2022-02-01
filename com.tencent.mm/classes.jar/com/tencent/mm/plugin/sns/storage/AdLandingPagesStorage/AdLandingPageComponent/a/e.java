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
import com.tencent.mm.protocal.protobuf.bwr;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public e(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(97137);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bwr();
    ((d.a)localObject).lBV = new bws();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_landpage_smartphone";
    ((d.a)localObject).funcId = 2605;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bwr)d.b.b(this.rr.lBR);
    ((bwr)localObject).KlG = paramLong;
    ((bwr)localObject).Tgu = paramInt1;
    ((bwr)localObject).jDM = paramString1;
    ((bwr)localObject).jDL = paramString2;
    ((bwr)localObject).KlE = paramInt2;
    AppMethodBeat.o(97137);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(97140);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(97140);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(97139);
    int i = this.rr.getType();
    AppMethodBeat.o(97139);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97138);
    Log.i("NetSceneAdGetSmartPhoneNumber", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.e
 * JD-Core Version:    0.7.0.1
 */