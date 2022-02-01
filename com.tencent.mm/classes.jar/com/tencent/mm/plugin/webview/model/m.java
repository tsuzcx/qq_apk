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
import com.tencent.mm.protocal.protobuf.awx;
import com.tencent.mm.protocal.protobuf.awy;
import com.tencent.mm.sdk.platformtools.ae;

public final class m
  extends n
  implements k
{
  private f callback;
  public final b gux;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78876);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new awx();
    ((b.a)localObject).hQG = new awy();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/getappticket";
    ((b.a)localObject).funcId = 1097;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gux = ((b.a)localObject).aDS();
    localObject = (awx)this.gux.hQD.hQJ;
    ((awx)localObject).dwb = paramString1;
    ((awx)localObject).signature = paramString2;
    AppMethodBeat.o(78876);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78877);
    this.callback = paramf;
    int i = dispatch(parame, this.gux, this);
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
    ae.i("MicroMsg.NetSceneGetAppTicket", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.m
 * JD-Core Version:    0.7.0.1
 */