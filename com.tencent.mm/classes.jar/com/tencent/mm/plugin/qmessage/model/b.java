package com.tencent.mm.plugin.qmessage.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cle;
import com.tencent.mm.protocal.protobuf.clf;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends p
  implements m
{
  private h Nil;
  public final c oWn;
  
  public b()
  {
    AppMethodBeat.i(27716);
    c.a locala = new c.a();
    locala.otE = new cle();
    locala.otF = new clf();
    locala.uri = "/cgi-bin/micromsg-bin/getimunreadmsgcount";
    locala.funcId = getType();
    locala.otG = 0;
    locala.respCmdId = 0;
    this.oWn = locala.bEF();
    AppMethodBeat.o(27716);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(27718);
    Log.d("MicroMsg.NetSceneGetImUnreadMsgCount", "get im unread msg count");
    this.Nil = paramh;
    int i = dispatch(paramg, this.oWn, this);
    AppMethodBeat.o(27718);
    return i;
  }
  
  public final int getType()
  {
    return 630;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27717);
    Log.d("MicroMsg.NetSceneGetImUnreadMsgCount", "end get im unread msg count, errType: %d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.Nil.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(27717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.model.b
 * JD-Core Version:    0.7.0.1
 */