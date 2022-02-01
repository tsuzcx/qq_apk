package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ebf;
import com.tencent.mm.protocal.protobuf.ebg;

public final class ab
  extends q
  implements m
{
  private i jQg;
  public final d rr;
  
  public ab(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(241596);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ebf();
    ((d.a)localObject).lBV = new ebg();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize";
    ((d.a)localObject).funcId = 1388;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ebf)d.b.b(this.rr.lBR);
    ((ebf)localObject).appid = paramString1;
    ((ebf)localObject).scope = paramString2;
    ((ebf)localObject).state = paramString3;
    ((ebf)localObject).Uga = paramString6;
    ((ebf)localObject).Ugh = paramString4;
    ((ebf)localObject).Ugi = paramString5;
    AppMethodBeat.o(241596);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78929);
    this.jQg = parami;
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
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ab
 * JD-Core Version:    0.7.0.1
 */