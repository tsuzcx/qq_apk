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
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.clj;
import com.tencent.mm.sdk.platformtools.ab;

public final class ae
  extends m
  implements k
{
  private f eGj;
  public final b rr;
  
  public ae(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6650);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cli();
    ((b.a)localObject).fsY = new clj();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/transid";
    ((b.a)localObject).funcId = 1142;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cli)this.rr.fsV.fta;
    ((cli)localObject).cwc = paramString1;
    ((cli)localObject).wys = paramString2;
    AppMethodBeat.o(6650);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6652);
    ab.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "doScene");
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6652);
    return i;
  }
  
  public final int getType()
  {
    return 1142;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6651);
    ab.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ae
 * JD-Core Version:    0.7.0.1
 */