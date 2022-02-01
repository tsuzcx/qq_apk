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
import com.tencent.mm.protocal.protobuf.cql;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(306802);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cql();
    ((c.a)localObject).otF = new cqm();
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_qywx_qrcode";
    ((c.a)localObject).funcId = 1022;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cql)c.b.b(this.rr.otB);
    ((cql)localObject).hQv = paramString1;
    ((cql)localObject).QKl = paramString2;
    ((cql)localObject).aawX = paramString3;
    ((cql)localObject).mdG = paramString4;
    ((cql)localObject).aawY = paramString5;
    ((cql)localObject).aawZ = paramString6;
    AppMethodBeat.o(306802);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(306811);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(306811);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(306807);
    int i = this.rr.getType();
    AppMethodBeat.o(306807);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(306816);
    Log.i("NetSceneUpdateQrUrl", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(306816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.l
 * JD-Core Version:    0.7.0.1
 */