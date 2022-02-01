package com.tencent.mm.plugin.voip_cs.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fzx;
import com.tencent.mm.protocal.protobuf.fzy;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends p
  implements m
{
  private h callback;
  public com.tencent.mm.am.c rr;
  
  public c(int paramInt1, String paramString1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString2)
  {
    AppMethodBeat.i(125428);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fzx();
    ((c.a)localObject).otF = new fzy();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipinvite";
    ((c.a)localObject).funcId = 823;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fzx)c.b.b(this.rr.otB);
    ((fzx)localObject).abmP = paramInt1;
    ((fzx)localObject).abXB = paramString1;
    ((fzx)localObject).ZkT = paramInt2;
    ((fzx)localObject).abXC = b.cX(paramArrayOfByte1);
    ((fzx)localObject).abXD = b.cX(paramArrayOfByte2);
    ((fzx)localObject).abmO = System.currentTimeMillis();
    if ((paramString2 != null) && (!paramString2.equals(""))) {
      ((fzx)localObject).abXE = paramString2;
    }
    AppMethodBeat.o(125428);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(125430);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(125430);
    return i;
  }
  
  public final int getType()
  {
    return 823;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125429);
    Log.i("MicroMsg.NetSceneVoipCSInvite", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.model.c.c
 * JD-Core Version:    0.7.0.1
 */