package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.ddm;
import com.tencent.mm.protocal.protobuf.ddn;
import com.tencent.mm.sdk.platformtools.Log;

public final class s
  extends p
  implements m
{
  private h mAY;
  public final c rr;
  
  public s(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78894);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ddm();
    ((c.a)localObject).otF = new ddn();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/payibggetuseropenid";
    ((c.a)localObject).funcId = 1566;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ddm)c.b.b(this.rr.otB);
    ((ddm)localObject).UserName = paramString2;
    ((ddm)localObject).oOI = paramString1;
    AppMethodBeat.o(78894);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(78896);
    Log.i("MicroMsg.NetSceneGetUserOpenId", "doScene");
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78896);
    return i;
  }
  
  public final int getType()
  {
    return 1566;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78895);
    Log.i("MicroMsg.NetSceneGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.s
 * JD-Core Version:    0.7.0.1
 */