package com.tencent.mm.plugin.profile.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ezt;
import com.tencent.mm.protocal.protobuf.ezu;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends p
  implements m
{
  private h callback;
  public com.tencent.mm.am.c rr;
  
  public c(String paramString, int paramInt)
  {
    AppMethodBeat.i(26907);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ezt();
    ((c.a)localObject).otF = new ezu();
    ((c.a)localObject).uri = "/cgi-bin/mmocbiz-bin/setbrandflag";
    ((c.a)localObject).funcId = 1363;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ezt)c.b.b(this.rr.otB);
    ((ezt)localObject).YRQ = paramString;
    ((ezt)localObject).abAB = paramInt;
    ((ezt)localObject).abAC = 4;
    AppMethodBeat.o(26907);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(26909);
    this.callback = paramh;
    Log.i("MicroMsg.brandservice.NetSceneSetBrandFlag", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(26909);
    return i;
  }
  
  public final int getType()
  {
    return 1363;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26908);
    Log.d("MicroMsg.brandservice.NetSceneSetBrandFlag", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(26908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.c
 * JD-Core Version:    0.7.0.1
 */