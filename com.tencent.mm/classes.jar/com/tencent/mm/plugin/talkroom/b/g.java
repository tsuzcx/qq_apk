package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dgs;
import com.tencent.mm.protocal.protobuf.dgt;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private final b rr;
  
  public g(LinkedList<dgs> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(29567);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dgt();
    ((b.a)localObject).hvu = new dgu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/talkstatreport";
    ((b.a)localObject).funcId = 373;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dgt)this.rr.hvr.hvw;
    ((dgt)localObject).FPV = paramLinkedList.size();
    ((dgt)localObject).FPW = paramLinkedList;
    ((dgt)localObject).Scene = paramInt;
    AppMethodBeat.o(29567);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(29568);
    ac.d("MicroMsg.NetSceneTalkStatReport", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29568);
    return i;
  }
  
  public final int getType()
  {
    return 373;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29569);
    ac.d("MicroMsg.NetSceneTalkStatReport", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29569);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.g
 * JD-Core Version:    0.7.0.1
 */