package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.aep;

public final class e
  extends n
  implements k
{
  public boolean BAL;
  private g callback;
  public final b hdD;
  
  public e(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(30178);
    this.BAL = paramBoolean;
    b.a locala = new b.a();
    aeo localaeo = new aeo();
    aep localaep = new aep();
    locala.gUU = localaeo;
    locala.gUV = localaep;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
    locala.funcId = 972;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    localaeo.Dex = paramString1;
    localaeo.DeI = paramString2;
    localaeo.DeK = paramBoolean;
    this.hdD = locala.atI();
    AppMethodBeat.o(30178);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(30179);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.e
 * JD-Core Version:    0.7.0.1
 */