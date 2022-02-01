package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  private i Bqf;
  public final d jof;
  
  public c()
  {
    AppMethodBeat.i(27716);
    d.a locala = new d.a();
    locala.iLN = new bom();
    locala.iLO = new bon();
    locala.uri = "/cgi-bin/micromsg-bin/getimunreadmsgcount";
    locala.funcId = getType();
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.jof = locala.aXF();
    AppMethodBeat.o(27716);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(27718);
    Log.d("MicroMsg.NetSceneGetImUnreadMsgCount", "get im unread msg count");
    this.Bqf = parami;
    int i = dispatch(paramg, this.jof, this);
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
    this.Bqf.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(27717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.c
 * JD-Core Version:    0.7.0.1
 */