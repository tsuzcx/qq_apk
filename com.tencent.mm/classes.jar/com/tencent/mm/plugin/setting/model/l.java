package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.protocal.protobuf.dak;
import com.tencent.mm.sdk.platformtools.ae;

public final class l
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public l(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, 0);
  }
  
  public l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(73780);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new daj();
    ((b.a)localObject).hQG = new dak();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendfeedback";
    ((b.a)localObject).funcId = 153;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (daj)this.rr.hQD.hQJ;
    ((daj)localObject).HJQ = paramString1;
    ((daj)localObject).hFS = paramString2;
    ((daj)localObject).HgI = paramInt;
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
    ae.d("MicroMsg.NetSendSceneFeedBack", "onGYNetEnd type:" + paramInt2 + " code:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l
 * JD-Core Version:    0.7.0.1
 */