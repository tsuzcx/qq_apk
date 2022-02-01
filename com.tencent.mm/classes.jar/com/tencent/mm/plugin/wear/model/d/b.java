package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.br;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ggv;
import com.tencent.mm.protocal.protobuf.ggw;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends p
  implements m
{
  private h callback;
  private c oDw;
  
  public b(String paramString)
  {
    AppMethodBeat.i(30057);
    Object localObject = new c.a();
    ((c.a)localObject).funcId = 976;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/sendyo";
    ((c.a)localObject).otE = new ggv();
    ((c.a)localObject).otF = new ggw();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.oDw = ((c.a)localObject).bEF();
    localObject = (ggv)c.b.b(this.oDw.otB);
    ((ggv)localObject).IMg = paramString;
    ((ggv)localObject).aaVx = ((ggv)localObject).CreateTime;
    ((ggv)localObject).CreateTime = ((int)br.JN(paramString));
    ((ggv)localObject).vhJ = 63;
    ((ggv)localObject).acdh = 1;
    ((ggv)localObject).vgN = 1;
    AppMethodBeat.o(30057);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(30059);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(30059);
    return i;
  }
  
  public final int getType()
  {
    return 976;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30058);
    Log.i("MicroMsg.Wear.NetSceneSendYo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.b
 * JD-Core Version:    0.7.0.1
 */