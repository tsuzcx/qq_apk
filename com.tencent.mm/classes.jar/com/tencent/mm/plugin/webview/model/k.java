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
import com.tencent.mm.protocal.protobuf.cl;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends q
  implements m
{
  private i heq;
  public final d rr;
  public String tjJ;
  
  public k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78870);
    this.tjJ = paramString3;
    paramString3 = new d.a();
    paramString3.iLN = new cl();
    paramString3.iLO = new cm();
    paramString3.uri = "/cgi-bin/mmbiz-bin/oauth_addavatarheadimg";
    paramString3.funcId = 2667;
    paramString3.iLP = 2667;
    paramString3.respCmdId = 0;
    this.rr = paramString3.aXF();
    paramString3 = (cl)this.rr.iLK.iLR;
    paramString3.KGG = paramString1;
    paramString3.dNI = paramString2;
    AppMethodBeat.o(78870);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78871);
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78871);
    return i;
  }
  
  public final int getType()
  {
    return 2667;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78872);
    Log.i("MicroMsg.NetSceneCreateAvatar", "NetSceneCreateAvatar:  netId = %d, errType = %d,errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.heq != null) {
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(78872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.k
 * JD-Core Version:    0.7.0.1
 */