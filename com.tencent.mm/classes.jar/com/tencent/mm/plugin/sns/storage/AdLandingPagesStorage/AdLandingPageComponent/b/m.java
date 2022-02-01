package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fsn;
import com.tencent.mm.protocal.protobuf.fso;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends p
  implements com.tencent.mm.network.m
{
  private h callback;
  private c rr;
  
  public m(String paramString, int paramInt)
  {
    AppMethodBeat.i(306805);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fsn();
    ((c.a)localObject).otF = new fso();
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/update_shared_uxinfo";
    ((c.a)localObject).funcId = 2883;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fsn)c.b.b(this.rr.otB);
    ((fsn)localObject).abRd = paramString;
    ((fsn)localObject).enterScene = paramInt;
    AppMethodBeat.o(306805);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(97161);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(97161);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(97160);
    int i = this.rr.getType();
    AppMethodBeat.o(97160);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97159);
    Log.i("NetSceneUpdateUxInfo", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.m
 * JD-Core Version:    0.7.0.1
 */