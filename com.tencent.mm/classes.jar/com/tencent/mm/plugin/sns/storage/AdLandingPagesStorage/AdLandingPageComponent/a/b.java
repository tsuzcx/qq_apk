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
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.sdk.platformtools.ChannelUtil;

public final class b
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public b(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(97129);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new xb();
    ((d.a)localObject).iLO = new xc();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/channelpkginfo";
    ((d.a)localObject).funcId = 1210;
    this.rr = ((d.a)localObject).aXF();
    localObject = (xb)this.rr.iLK.iLR;
    ((xb)localObject).Lih = paramString2;
    ((xb)localObject).KFI = paramString1;
    ((xb)localObject).Lii = ChannelUtil.isGPVersion();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((xb)localObject).Lij = i;
      AppMethodBeat.o(97129);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(97132);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(97132);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(97131);
    int i = this.rr.getType();
    AppMethodBeat.o(97131);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97130);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b
 * JD-Core Version:    0.7.0.1
 */