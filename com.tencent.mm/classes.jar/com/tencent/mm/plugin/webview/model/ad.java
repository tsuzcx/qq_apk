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
import com.tencent.mm.protocal.protobuf.fow;
import com.tencent.mm.protocal.protobuf.fox;
import com.tencent.mm.sdk.platformtools.Log;

public final class ad
  extends p
  implements m
{
  private h mAY;
  public final c rr;
  
  public ad(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78934);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fow();
    ((c.a)localObject).otF = new fox();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/transid";
    ((c.a)localObject).funcId = 1142;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fow)c.b.b(this.rr.otB);
    ((fow)localObject).appid = paramString1;
    ((fow)localObject).openid = paramString2;
    AppMethodBeat.o(78934);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(78936);
    Log.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "doScene");
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78936);
    return i;
  }
  
  public final int getType()
  {
    return 1142;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78935);
    Log.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ad
 * JD-Core Version:    0.7.0.1
 */