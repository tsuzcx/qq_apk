package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bck;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  public final b ipX;
  private f xac;
  
  public c()
  {
    AppMethodBeat.i(27716);
    b.a locala = new b.a();
    locala.hNM = new bck();
    locala.hNN = new bcl();
    locala.uri = "/cgi-bin/micromsg-bin/getimunreadmsgcount";
    locala.funcId = getType();
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.ipX = locala.aDC();
    AppMethodBeat.o(27716);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(27718);
    ad.d("MicroMsg.NetSceneGetImUnreadMsgCount", "get im unread msg count");
    this.xac = paramf;
    int i = dispatch(parame, this.ipX, this);
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
    ad.d("MicroMsg.NetSceneGetImUnreadMsgCount", "end get im unread msg count, errType: %d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.xac.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(27717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.c
 * JD-Core Version:    0.7.0.1
 */