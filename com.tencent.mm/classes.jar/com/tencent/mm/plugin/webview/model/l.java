package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.sdk.platformtools.ab;

public final class l
  extends m
  implements k
{
  private f callback;
  public final b lFp;
  
  public l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6595);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aga();
    ((b.a)localObject).fsY = new agb();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/getappticket";
    ((b.a)localObject).funcId = 1097;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.lFp = ((b.a)localObject).ado();
    localObject = (aga)this.lFp.fsV.fta;
    ((aga)localObject).cwc = paramString1;
    ((aga)localObject).signature = paramString2;
    AppMethodBeat.o(6595);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6596);
    this.callback = paramf;
    int i = dispatch(parame, this.lFp, this);
    AppMethodBeat.o(6596);
    return i;
  }
  
  public final int getType()
  {
    return 1097;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6597);
    ab.i("MicroMsg.NetSceneGetAppTicket", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.l
 * JD-Core Version:    0.7.0.1
 */