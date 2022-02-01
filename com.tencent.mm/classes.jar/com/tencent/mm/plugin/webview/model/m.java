package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bii;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  public final d hhm;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78876);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bih();
    ((d.a)localObject).iLO = new bii();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/getappticket";
    ((d.a)localObject).funcId = 1097;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hhm = ((d.a)localObject).aXF();
    localObject = (bih)this.hhm.iLK.iLR;
    ((bih)localObject).dNI = paramString1;
    ((bih)localObject).signature = paramString2;
    AppMethodBeat.o(78876);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78877);
    this.callback = parami;
    int i = dispatch(paramg, this.hhm, this);
    AppMethodBeat.o(78877);
    return i;
  }
  
  public final int getType()
  {
    return 1097;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78878);
    Log.i("MicroMsg.NetSceneGetAppTicket", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.m
 * JD-Core Version:    0.7.0.1
 */