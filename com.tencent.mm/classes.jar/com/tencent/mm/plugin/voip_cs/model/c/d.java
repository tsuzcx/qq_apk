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
import com.tencent.mm.protocal.protobuf.gaa;
import com.tencent.mm.protocal.protobuf.gab;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends p
  implements m
{
  private h callback;
  public c rr;
  
  public d(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(125431);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new gaa();
    ((c.a)localObject).otF = new gab();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipredirect";
    ((c.a)localObject).funcId = 285;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (gaa)c.b.b(this.rr.otB);
    ((gaa)localObject).abKe = paramLong1;
    ((gaa)localObject).ZvA = paramLong2;
    ((gaa)localObject).abmO = System.currentTimeMillis();
    AppMethodBeat.o(125431);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(125433);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(125433);
    return i;
  }
  
  public final int getType()
  {
    return 285;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125432);
    Log.i("MicroMsg.NetSceneVoipCSRedirect", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.model.c.d
 * JD-Core Version:    0.7.0.1
 */