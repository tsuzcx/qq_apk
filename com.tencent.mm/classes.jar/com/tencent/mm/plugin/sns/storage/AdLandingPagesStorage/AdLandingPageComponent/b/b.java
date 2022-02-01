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
import com.tencent.mm.protocal.protobuf.yz;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.platformtools.ChannelUtil;

public final class b
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public b(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(97129);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new yz();
    ((c.a)localObject).otF = new za();
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/channelpkginfo";
    ((c.a)localObject).funcId = 1210;
    this.rr = ((c.a)localObject).bEF();
    localObject = (yz)c.b.b(this.rr.otB);
    ((yz)localObject).ZhB = paramString2;
    ((yz)localObject).YEb = paramString1;
    ((yz)localObject).ZhC = ChannelUtil.isGPVersion();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((yz)localObject).ZhD = i;
      AppMethodBeat.o(97129);
      return;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(97132);
    this.callback = paramh;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.b
 * JD-Core Version:    0.7.0.1
 */