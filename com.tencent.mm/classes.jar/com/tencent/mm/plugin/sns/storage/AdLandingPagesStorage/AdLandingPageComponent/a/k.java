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
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public k(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(203147);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new btk();
    ((d.a)localObject).iLO = new btl();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_qywx_qrcode";
    ((d.a)localObject).funcId = 1022;
    this.rr = ((d.a)localObject).aXF();
    localObject = (btk)this.rr.iLK.iLR;
    ((btk)localObject).dRy = paramString1;
    ((btk)localObject).DYM = paramString2;
    ((btk)localObject).Mab = paramString3;
    ((btk)localObject).gTk = paramString4;
    ((btk)localObject).Mac = paramString5;
    ((btk)localObject).Mad = paramString6;
    AppMethodBeat.o(203147);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(203149);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(203149);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(203148);
    int i = this.rr.getType();
    AppMethodBeat.o(203148);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(203150);
    Log.i("NetSceneUpdateQrUrl", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(203150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.k
 * JD-Core Version:    0.7.0.1
 */