package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afn;
import com.tencent.mm.protocal.protobuf.afo;

public final class e
  extends n
  implements k
{
  public boolean CSS;
  private g callback;
  public final b hEg;
  
  public e(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(30178);
    this.CSS = paramBoolean;
    b.a locala = new b.a();
    afn localafn = new afn();
    afo localafo = new afo();
    locala.hvt = localafn;
    locala.hvu = localafo;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
    locala.funcId = 972;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    localafn.ExD = paramString1;
    localafn.ExO = paramString2;
    localafn.ExQ = paramBoolean;
    this.hEg = locala.aAz();
    AppMethodBeat.o(30178);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(30179);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
    AppMethodBeat.o(30179);
    return i;
  }
  
  public final int getType()
  {
    return 972;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30180);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.e
 * JD-Core Version:    0.7.0.1
 */