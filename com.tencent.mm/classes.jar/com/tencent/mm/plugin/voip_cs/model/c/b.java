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
import com.tencent.mm.protocal.protobuf.fzv;
import com.tencent.mm.protocal.protobuf.fzw;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public b(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(125425);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fzv();
    ((c.a)localObject).otF = new fzw();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipheartbeat";
    ((c.a)localObject).funcId = 795;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fzv)c.b.b(this.rr.otB);
    ((fzv)localObject).abKe = paramLong1;
    ((fzv)localObject).ZvA = paramLong2;
    ((fzv)localObject).abmO = System.currentTimeMillis();
    AppMethodBeat.o(125425);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(125427);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(125427);
    return i;
  }
  
  public final int getType()
  {
    return 795;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125426);
    Log.i("MicroMsg.NetSceneVoipCSHeartBeat", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.model.c.b
 * JD-Core Version:    0.7.0.1
 */