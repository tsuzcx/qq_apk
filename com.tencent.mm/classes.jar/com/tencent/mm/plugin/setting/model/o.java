package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.exd;
import com.tencent.mm.protocal.protobuf.exe;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public o(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, 0);
  }
  
  public o(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(73780);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new exd();
    ((c.a)localObject).otF = new exe();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/sendfeedback";
    ((c.a)localObject).funcId = 153;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (exd)c.b.b(this.rr.otB);
    ((exd)localObject).abzg = paramString1;
    ((exd)localObject).nUB = paramString2;
    ((exd)localObject).aaLo = paramInt;
    AppMethodBeat.o(73780);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(73781);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(73781);
    return i;
  }
  
  public final int getType()
  {
    return 153;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73782);
    Log.d("MicroMsg.NetSendSceneFeedBack", "onGYNetEnd type:" + paramInt2 + " code:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.o
 * JD-Core Version:    0.7.0.1
 */