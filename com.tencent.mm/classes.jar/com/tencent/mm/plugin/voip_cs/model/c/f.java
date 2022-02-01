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
import com.tencent.mm.protocal.protobuf.gaf;
import com.tencent.mm.protocal.protobuf.gag;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends p
  implements m
{
  private h callback;
  public c rr;
  
  public f(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(125437);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new gaf();
    ((c.a)localObject).otF = new gag();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipsync";
    ((c.a)localObject).funcId = 818;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (gaf)c.b.b(this.rr.otB);
    ((gaf)localObject).abKe = paramLong1;
    ((gaf)localObject).ZvA = paramLong2;
    ((gaf)localObject).abXJ = paramInt;
    ((gaf)localObject).abmO = System.currentTimeMillis();
    AppMethodBeat.o(125437);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(125439);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(125439);
    return i;
  }
  
  public final int getType()
  {
    return 818;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125438);
    Log.i("MicroMsg.NetSceneVoipCSSync", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.model.c.f
 * JD-Core Version:    0.7.0.1
 */