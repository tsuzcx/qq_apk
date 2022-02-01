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
import com.tencent.mm.protocal.protobuf.fvy;
import com.tencent.mm.protocal.protobuf.fvz;
import com.tencent.mm.sdk.platformtools.Log;

public final class af
  extends p
  implements m
{
  private h callback;
  public final c oDw;
  
  public af(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78940);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fvy();
    ((c.a)localObject).otF = new fvz();
    ((c.a)localObject).uri = "/cgi-bin/mmo2o-bin/verifybeaconjspermission";
    ((c.a)localObject).funcId = 1702;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.oDw = ((c.a)localObject).bEF();
    localObject = (fvy)c.b.b(this.oDw.otB);
    ((fvy)localObject).Url = paramString1;
    ((fvy)localObject).appid = paramString2;
    ((fvy)localObject).hFb = paramString3;
    AppMethodBeat.o(78940);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(78941);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(78941);
    return i;
  }
  
  public final int getType()
  {
    return 1702;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78942);
    Log.i("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end ok");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78942);
      return;
      Log.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end not ok");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.af
 * JD-Core Version:    0.7.0.1
 */