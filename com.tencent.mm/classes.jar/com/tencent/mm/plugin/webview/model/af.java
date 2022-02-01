package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.epj;
import com.tencent.mm.protocal.protobuf.epk;
import com.tencent.mm.sdk.platformtools.Log;

public final class af
  extends q
  implements m
{
  private i callback;
  public final d iUB;
  
  public af(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78940);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new epj();
    ((d.a)localObject).iLO = new epk();
    ((d.a)localObject).uri = "/cgi-bin/mmo2o-bin/verifybeaconjspermission";
    ((d.a)localObject).funcId = 1702;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.iUB = ((d.a)localObject).aXF();
    localObject = (epj)this.iUB.iLK.iLR;
    ((epj)localObject).Url = paramString1;
    ((epj)localObject).dNI = paramString2;
    ((epj)localObject).dHx = paramString3;
    AppMethodBeat.o(78940);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78941);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
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