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
import com.tencent.mm.protocal.protobuf.apo;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends p
  implements m
{
  private h callback;
  c rr;
  
  public f(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(298536);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new apo();
    ((c.a)localObject).otF = new app();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/extfunctionswitch";
    ((c.a)localObject).funcId = 4071;
    this.rr = ((c.a)localObject).bEF();
    localObject = (apo)c.b.b(this.rr.otB);
    ((apo)localObject).IJG = paramInt1;
    ((apo)localObject).YIq = paramInt2;
    Log.i("MicroMsg.NetSceneExtFunctionSwitch", "control2 = " + paramBoolean + "， WhichExtFunctionSwitch = " + paramLong1 + "， ExtFunctionSwitchValue = " + paramLong2);
    if (paramBoolean)
    {
      ((apo)localObject).ZwP = paramLong1;
      ((apo)localObject).ZwQ = paramLong2;
      AppMethodBeat.o(298536);
      return;
    }
    ((apo)localObject).ZwN = paramLong1;
    ((apo)localObject).ZwO = paramLong2;
    AppMethodBeat.o(298536);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(298548);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(298548);
    return i;
  }
  
  public final int getType()
  {
    return 4071;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(298539);
    Log.d("MicroMsg.NetSceneExtFunctionSwitch", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.i("MicroMsg.NetSceneExtFunctionSwitch", "return is 0.now we parse the json and resetList..");
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(298539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.f
 * JD-Core Version:    0.7.0.1
 */