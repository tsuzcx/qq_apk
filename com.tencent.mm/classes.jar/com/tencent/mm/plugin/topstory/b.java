package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fut;
import com.tencent.mm.protocal.protobuf.fuu;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends p
  implements m
{
  private h callback;
  c rr;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(271621);
    c.a locala = new c.a();
    locala.otE = new fut();
    locala.otF = new fuu();
    locala.uri = "/cgi-bin/mmsearch-bin/usercloserecommend";
    locala.funcId = 4393;
    this.rr = locala.bEF();
    ((fut)c.b.b(this.rr.otB)).action = paramInt;
    AppMethodBeat.o(271621);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(271635);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(271635);
    return i;
  }
  
  public final int getType()
  {
    return 4071;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(271627);
    Log.d("MicroMsg.NetSceneExtFunctionSwitch", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.i("MicroMsg.NetSceneExtFunctionSwitch", "return is 0.now we parse the json and resetList..");
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(271627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.b
 * JD-Core Version:    0.7.0.1
 */