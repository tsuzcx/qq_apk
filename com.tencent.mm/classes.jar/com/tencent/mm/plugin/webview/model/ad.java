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
import com.tencent.mm.protocal.protobuf.ejj;
import com.tencent.mm.protocal.protobuf.ejk;
import com.tencent.mm.sdk.platformtools.Log;

public final class ad
  extends q
  implements m
{
  private i heq;
  public final d rr;
  
  public ad(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78934);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ejj();
    ((d.a)localObject).iLO = new ejk();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/transid";
    ((d.a)localObject).funcId = 1142;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ejj)this.rr.iLK.iLR;
    ((ejj)localObject).dNI = paramString1;
    ((ejj)localObject).openid = paramString2;
    AppMethodBeat.o(78934);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78936);
    Log.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "doScene");
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78936);
    return i;
  }
  
  public final int getType()
  {
    return 1142;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78935);
    Log.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ad
 * JD-Core Version:    0.7.0.1
 */