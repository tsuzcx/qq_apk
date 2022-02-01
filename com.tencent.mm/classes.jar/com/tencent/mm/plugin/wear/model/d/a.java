package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfo;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  public String cLR;
  private g callback;
  public String dfF;
  private com.tencent.mm.al.b hdD;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(30054);
    this.cLR = paramString1;
    this.dfF = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 1091;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/register";
    ((b.a)localObject).gUU = new bfo();
    ((b.a)localObject).gUV = new bfp();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hdD = ((b.a)localObject).atI();
    localObject = (bfo)this.hdD.gUS.gUX;
    ((bfo)localObject).CEi = new com.tencent.mm.bx.b(paramString1.getBytes());
    ((bfo)localObject).CEk = new com.tencent.mm.bx.b(paramString2.getBytes());
    ((bfo)localObject).DCW = new com.tencent.mm.bx.b("5".getBytes());
    AppMethodBeat.o(30054);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(30055);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
    AppMethodBeat.o(30055);
    return i;
  }
  
  public final int getType()
  {
    return 1091;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30056);
    ad.i("MicroMsg.Wear.NetSceneBizDeviceAuth", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.a
 * JD-Core Version:    0.7.0.1
 */