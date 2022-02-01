package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.cec;
import com.tencent.mm.protocal.protobuf.ced;
import com.tencent.mm.sdk.platformtools.Log;

public final class s
  extends q
  implements m
{
  private i heq;
  public final d rr;
  
  public s(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78894);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cec();
    ((d.a)localObject).iLO = new ced();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/payibggetuseropenid";
    ((d.a)localObject).funcId = 1566;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cec)this.rr.iLK.iLR;
    ((cec)localObject).UserName = paramString2;
    ((cec)localObject).jfi = paramString1;
    AppMethodBeat.o(78894);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78896);
    Log.i("MicroMsg.NetSceneGetUserOpenId", "doScene");
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78896);
    return i;
  }
  
  public final int getType()
  {
    return 1566;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78895);
    Log.i("MicroMsg.NetSceneGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.s
 * JD-Core Version:    0.7.0.1
 */