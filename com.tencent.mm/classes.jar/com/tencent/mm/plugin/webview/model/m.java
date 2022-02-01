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
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.sdk.platformtools.ac;

public final class m
  extends n
  implements k
{
  private g callback;
  public final b fYA;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78876);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new asj();
    ((b.a)localObject).hvu = new ask();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/getappticket";
    ((b.a)localObject).funcId = 1097;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fYA = ((b.a)localObject).aAz();
    localObject = (asj)this.fYA.hvr.hvw;
    ((asj)localObject).djj = paramString1;
    ((asj)localObject).signature = paramString2;
    AppMethodBeat.o(78876);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78877);
    this.callback = paramg;
    int i = dispatch(parame, this.fYA, this);
    AppMethodBeat.o(78877);
    return i;
  }
  
  public final int getType()
  {
    return 1097;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78878);
    ac.i("MicroMsg.NetSceneGetAppTicket", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.m
 * JD-Core Version:    0.7.0.1
 */