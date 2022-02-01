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
import com.tencent.mm.protocal.protobuf.cbc;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public k(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(269442);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cbc();
    ((d.a)localObject).lBV = new cbd();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_qywx_qrcode";
    ((d.a)localObject).funcId = 1022;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cbc)d.b.b(this.rr.lBR);
    ((cbc)localObject).fKO = paramString1;
    ((cbc)localObject).Kmh = paramString2;
    ((cbc)localObject).Tju = paramString3;
    ((cbc)localObject).jDL = paramString4;
    ((cbc)localObject).Tjv = paramString5;
    ((cbc)localObject).Tjw = paramString6;
    AppMethodBeat.o(269442);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(269444);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(269444);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(269443);
    int i = this.rr.getType();
    AppMethodBeat.o(269443);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(269445);
    Log.i("NetSceneUpdateQrUrl", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(269445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.k
 * JD-Core Version:    0.7.0.1
 */