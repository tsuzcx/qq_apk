package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cyo;
import com.tencent.mm.protocal.protobuf.cyp;

public final class ab
  extends n
  implements k
{
  private f gCo;
  public final b rr;
  
  public ab(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(198117);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cyo();
    ((b.a)localObject).hQG = new cyp();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize";
    ((b.a)localObject).funcId = 1388;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cyo)this.rr.hQD.hQJ;
    ((cyo)localObject).dwb = paramString1;
    ((cyo)localObject).scope = paramString2;
    ((cyo)localObject).state = paramString3;
    ((cyo)localObject).HIF = paramString6;
    ((cyo)localObject).HIL = paramString4;
    ((cyo)localObject).HIM = paramString5;
    AppMethodBeat.o(198117);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78929);
    this.gCo = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78929);
    return i;
  }
  
  public final int getType()
  {
    return 1388;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78928);
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ab
 * JD-Core Version:    0.7.0.1
 */