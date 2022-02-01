package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.cug;
import com.tencent.mm.sdk.platformtools.ac;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private final b rr;
  
  public k(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, 0);
  }
  
  public k(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(73780);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cuf();
    ((b.a)localObject).hvu = new cug();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendfeedback";
    ((b.a)localObject).funcId = 153;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cuf)this.rr.hvr.hvw;
    ((cuf)localObject).FFP = paramString1;
    ((cuf)localObject).hkR = paramString2;
    ((cuf)localObject).FdF = paramInt;
    AppMethodBeat.o(73780);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(73781);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSendSceneFeedBack", "onGYNetEnd type:" + paramInt2 + " code:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.k
 * JD-Core Version:    0.7.0.1
 */