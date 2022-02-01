package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.protocal.protobuf.czq;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private final b rr;
  
  public k(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, 0);
  }
  
  public k(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(73780);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new czp();
    ((b.a)localObject).hNN = new czq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendfeedback";
    ((b.a)localObject).funcId = 153;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (czp)this.rr.hNK.hNQ;
    ((czp)localObject).Hqo = paramString1;
    ((czp)localObject).hDa = paramString2;
    ((czp)localObject).GNi = paramInt;
    AppMethodBeat.o(73780);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(73781);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(73781);
    return i;
  }
  
  public final int getType()
  {
    return 153;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73782);
    ad.d("MicroMsg.NetSendSceneFeedBack", "onGYNetEnd type:" + paramInt2 + " code:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.k
 * JD-Core Version:    0.7.0.1
 */