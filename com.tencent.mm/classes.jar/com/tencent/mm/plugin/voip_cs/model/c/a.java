package com.tencent.mm.plugin.voip_cs.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fzt;
import com.tencent.mm.protocal.protobuf.fzu;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends p
  implements m
{
  private h callback;
  public c rr;
  
  public a(int paramInt1, long paramLong1, long paramLong2, String paramString, int paramInt2)
  {
    AppMethodBeat.i(125422);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fzt();
    ((c.a)localObject).otF = new fzu();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoiphangup";
    ((c.a)localObject).funcId = 880;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fzt)c.b.b(this.rr.otB);
    ((fzt)localObject).abmP = paramInt1;
    ((fzt)localObject).abKe = paramLong1;
    ((fzt)localObject).ZvA = paramLong2;
    ((fzt)localObject).abXB = paramString;
    ((fzt)localObject).YKo = paramInt2;
    ((fzt)localObject).abmO = System.currentTimeMillis();
    AppMethodBeat.o(125422);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(125423);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(125423);
    return i;
  }
  
  public final int getType()
  {
    return 880;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125424);
    Log.i("MicroMsg.NetSceneVoipCSHangUp", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.model.c.a
 * JD-Core Version:    0.7.0.1
 */