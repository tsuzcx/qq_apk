package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dot;
import com.tencent.mm.protocal.protobuf.dou;
import com.tencent.mm.sdk.platformtools.ac;

public final class af
  extends n
  implements k
{
  private g callback;
  public final b hEg;
  
  public af(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78940);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dot();
    ((b.a)localObject).hvu = new dou();
    ((b.a)localObject).uri = "/cgi-bin/mmo2o-bin/verifybeaconjspermission";
    ((b.a)localObject).funcId = 1702;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hEg = ((b.a)localObject).aAz();
    localObject = (dot)this.hEg.hvr.hvw;
    ((dot)localObject).Url = paramString1;
    ((dot)localObject).djj = paramString2;
    ((dot)localObject).ddJ = paramString3;
    AppMethodBeat.o(78940);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78941);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
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
    ac.i("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ac.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end ok");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78942);
      return;
      ac.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end not ok");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.af
 * JD-Core Version:    0.7.0.1
 */