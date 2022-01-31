package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.bf;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends m
  implements k
{
  private f callback;
  private com.tencent.mm.ai.b fBd;
  
  public b(String paramString)
  {
    AppMethodBeat.i(26375);
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 976;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendyo";
    ((b.a)localObject).fsX = new cxw();
    ((b.a)localObject).fsY = new cxx();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fBd = ((b.a)localObject).ado();
    localObject = (cxw)this.fBd.fsV.fta;
    ((cxw)localObject).nul = paramString;
    ((cxw)localObject).xtf = ((cxw)localObject).CreateTime;
    ((cxw)localObject).CreateTime = ((int)bf.py(paramString));
    ((cxw)localObject).jKs = 63;
    ((cxw)localObject).yfb = 1;
    ((cxw)localObject).jJu = 1;
    AppMethodBeat.o(26375);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26377);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(26377);
    return i;
  }
  
  public final int getType()
  {
    return 976;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26376);
    ab.i("MicroMsg.Wear.NetSceneSendYo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.b
 * JD-Core Version:    0.7.0.1
 */