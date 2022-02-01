package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.aeu;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.ak.b rr;
  private int sceneType;
  
  public b(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    AppMethodBeat.i(29554);
    this.sceneType = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new aet();
    ((b.a)localObject).hvu = new aeu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/exittalkroom";
    ((b.a)localObject).funcId = 333;
    ((b.a)localObject).reqCmdId = 148;
    ((b.a)localObject).respCmdId = 1000000148;
    this.rr = ((b.a)localObject).aAz();
    localObject = (aet)this.rr.hvr.hvw;
    ((aet)localObject).Exe = paramString;
    ((aet)localObject).Exf = paramInt1;
    ((aet)localObject).Exg = paramLong;
    ((aet)localObject).Scene = paramInt2;
    AppMethodBeat.o(29554);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(29555);
    ac.d("MicroMsg.NetSceneExitTalkRoom", "doScene %d", new Object[] { Integer.valueOf(this.sceneType) });
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29555);
    return i;
  }
  
  public final int getType()
  {
    return 333;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29556);
    ac.d("MicroMsg.NetSceneExitTalkRoom", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29556);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.b
 * JD-Core Version:    0.7.0.1
 */