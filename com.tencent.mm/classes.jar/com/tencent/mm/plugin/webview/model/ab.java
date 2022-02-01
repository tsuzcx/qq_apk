package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.euw;
import com.tencent.mm.protocal.protobuf.eux;

public final class ab
  extends p
  implements m
{
  private h mAY;
  public final c rr;
  
  public ab(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(298313);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new euw();
    ((c.a)localObject).otF = new eux();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize";
    ((c.a)localObject).funcId = 1388;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (euw)c.b.b(this.rr.otB);
    ((euw)localObject).appid = paramString1;
    ((euw)localObject).scope = paramString2;
    ((euw)localObject).state = paramString3;
    ((euw)localObject).abxw = paramString6;
    ((euw)localObject).abxH = paramString4;
    ((euw)localObject).abxI = paramString5;
    AppMethodBeat.o(298313);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(78929);
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78929);
    return i;
  }
  
  public final int getType()
  {
    return 1388;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78928);
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ab
 * JD-Core Version:    0.7.0.1
 */