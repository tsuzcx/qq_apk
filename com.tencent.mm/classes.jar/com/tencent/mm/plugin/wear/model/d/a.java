package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  public String fzB;
  public String fzF;
  private d lKU;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(30054);
    this.fzB = paramString1;
    this.fzF = paramString2;
    Object localObject = new d.a();
    ((d.a)localObject).funcId = 1091;
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/register";
    ((d.a)localObject).lBU = new ciz();
    ((d.a)localObject).lBV = new cja();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.lKU = ((d.a)localObject).bgN();
    localObject = (ciz)d.b.b(this.lKU.lBR);
    ((ciz)localObject).RPd = new b(paramString1.getBytes());
    ((ciz)localObject).RPf = new b(paramString2.getBytes());
    ((ciz)localObject).Tqd = new b("5".getBytes());
    AppMethodBeat.o(30054);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(30055);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
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