package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends m
  implements k
{
  public final b fTs;
  private f pHL;
  
  public c()
  {
    AppMethodBeat.i(24076);
    b.a locala = new b.a();
    locala.fsX = new alk();
    locala.fsY = new all();
    locala.uri = "/cgi-bin/micromsg-bin/getimunreadmsgcount";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.fTs = locala.ado();
    AppMethodBeat.o(24076);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(24078);
    ab.d("MicroMsg.NetSceneGetImUnreadMsgCount", "get im unread msg count");
    this.pHL = paramf;
    int i = dispatch(parame, this.fTs, this);
    AppMethodBeat.o(24078);
    return i;
  }
  
  public final int getType()
  {
    return 630;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24077);
    ab.d("MicroMsg.NetSceneGetImUnreadMsgCount", "end get im unread msg count, errType: %d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.pHL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(24077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.c
 * JD-Core Version:    0.7.0.1
 */