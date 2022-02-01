package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends n
  implements k
{
  public final b hWC;
  private g vSS;
  
  public c()
  {
    AppMethodBeat.i(27716);
    b.a locala = new b.a();
    locala.hvt = new ayg();
    locala.hvu = new ayh();
    locala.uri = "/cgi-bin/micromsg-bin/getimunreadmsgcount";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.hWC = locala.aAz();
    AppMethodBeat.o(27716);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(27718);
    ac.d("MicroMsg.NetSceneGetImUnreadMsgCount", "get im unread msg count");
    this.vSS = paramg;
    int i = dispatch(parame, this.hWC, this);
    AppMethodBeat.o(27718);
    return i;
  }
  
  public final int getType()
  {
    return 630;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27717);
    ac.d("MicroMsg.NetSceneGetImUnreadMsgCount", "end get im unread msg count, errType: %d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.vSS.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(27717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.c
 * JD-Core Version:    0.7.0.1
 */