package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cw;
import com.tencent.mm.protocal.protobuf.cx;

public final class i
  extends p
  implements m
{
  private h mAY;
  public final c rr;
  
  public i(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78865);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cw();
    ((c.a)localObject).otF = new cx();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
    ((c.a)localObject).funcId = 2500;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cw)c.b.b(this.rr.otB);
    ((cw)localObject).appid = paramString1;
    ((cw)localObject).nickname = paramString2;
    ((cw)localObject).fileid = paramString3;
    ((cw)localObject).YFe = 1;
    AppMethodBeat.o(78865);
  }
  
  public i(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78864);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cw();
    ((c.a)localObject).otF = new cx();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
    ((c.a)localObject).funcId = 2500;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cw)c.b.b(this.rr.otB);
    ((cw)localObject).appid = paramString1;
    ((cw)localObject).nickname = paramString2;
    ((cw)localObject).YFd = new b(paramArrayOfByte);
    ((cw)localObject).YFe = 0;
    AppMethodBeat.o(78864);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(78867);
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78867);
    return i;
  }
  
  public final int getType()
  {
    return 2500;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78866);
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.i
 * JD-Core Version:    0.7.0.1
 */