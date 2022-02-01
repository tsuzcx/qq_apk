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
import com.tencent.mm.protocal.protobuf.clu;
import com.tencent.mm.protocal.protobuf.clv;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public e(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(97137);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new clu();
    ((c.a)localObject).otF = new clv();
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_landpage_smartphone";
    ((c.a)localObject).funcId = 2605;
    this.rr = ((c.a)localObject).bEF();
    localObject = (clu)c.b.b(this.rr.otB);
    ((clu)localObject).Bee = paramLong;
    ((clu)localObject).aatK = paramInt1;
    ((clu)localObject).mdH = paramString1;
    ((clu)localObject).mdG = paramString2;
    ((clu)localObject).oeO = paramInt2;
    AppMethodBeat.o(97137);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(97140);
    this.callback = paramh;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.e
 * JD-Core Version:    0.7.0.1
 */