package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cay;
import com.tencent.mm.protocal.protobuf.caz;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  public String dGL;
  public String dGP;
  private d iUB;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(30054);
    this.dGL = paramString1;
    this.dGP = paramString2;
    Object localObject = new d.a();
    ((d.a)localObject).funcId = 1091;
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/register";
    ((d.a)localObject).iLN = new cay();
    ((d.a)localObject).iLO = new caz();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.iUB = ((d.a)localObject).aXF();
    localObject = (cay)this.iUB.iLK.iLR;
    ((cay)localObject).KOi = new b(paramString1.getBytes());
    ((cay)localObject).KOk = new b(paramString2.getBytes());
    ((cay)localObject).Mgr = new b("5".getBytes());
    AppMethodBeat.o(30054);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(30055);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(30055);
    return i;
  }
  
  public final int getType()
  {
    return 1091;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30056);
    Log.i("MicroMsg.Wear.NetSceneBizDeviceAuth", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.a
 * JD-Core Version:    0.7.0.1
 */