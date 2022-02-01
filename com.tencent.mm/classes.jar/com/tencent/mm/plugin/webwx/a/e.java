package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ail;
import com.tencent.mm.protocal.protobuf.aim;

public final class e
  extends n
  implements k
{
  public boolean EPp;
  private f callback;
  public final b hZD;
  
  public e(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(30178);
    this.EPp = paramBoolean;
    b.a locala = new b.a();
    ail localail = new ail();
    aim localaim = new aim();
    locala.hQF = localail;
    locala.hQG = localaim;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
    locala.funcId = 972;
    locala.hQH = 0;
    locala.respCmdId = 0;
    localail.GxR = paramString1;
    localail.Gyc = paramString2;
    localail.Gye = paramBoolean;
    this.hZD = locala.aDS();
    AppMethodBeat.o(30178);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(30179);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
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