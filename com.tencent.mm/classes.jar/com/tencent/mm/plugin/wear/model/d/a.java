package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.czc;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends p
  implements m
{
  private h callback;
  public String hEl;
  public String hEr;
  private c oDw;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(30054);
    this.hEl = paramString1;
    this.hEr = paramString2;
    Object localObject = new c.a();
    ((c.a)localObject).funcId = 1091;
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/register";
    ((c.a)localObject).otE = new czc();
    ((c.a)localObject).otF = new czd();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.oDw = ((c.a)localObject).bEF();
    localObject = (czc)c.b.b(this.oDw.otB);
    ((czc)localObject).YMq = new b(paramString1.getBytes());
    ((czc)localObject).YMs = new b(paramString2.getBytes());
    ((czc)localObject).aaEf = new b("5".getBytes());
    AppMethodBeat.o(30054);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(30055);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
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