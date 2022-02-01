package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.protocal.protobuf.djf;
import com.tencent.mm.sdk.platformtools.ad;

public final class af
  extends n
  implements k
{
  private g callback;
  public final b hdD;
  
  public af(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78940);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dje();
    ((b.a)localObject).gUV = new djf();
    ((b.a)localObject).uri = "/cgi-bin/mmo2o-bin/verifybeaconjspermission";
    ((b.a)localObject).funcId = 1702;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hdD = ((b.a)localObject).atI();
    localObject = (dje)this.hdD.gUS.gUX;
    ((dje)localObject).Url = paramString1;
    ((dje)localObject).dlB = paramString2;
    ((dje)localObject).dgo = paramString3;
    AppMethodBeat.o(78940);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78941);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
    AppMethodBeat.o(78941);
    return i;
  }
  
  public final int getType()
  {
    return 1702;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78942);
    ad.i("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ad.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end ok");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78942);
      return;
      ad.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end not ok");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.af
 * JD-Core Version:    0.7.0.1
 */