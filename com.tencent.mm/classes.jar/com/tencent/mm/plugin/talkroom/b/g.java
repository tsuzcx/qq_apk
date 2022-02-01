package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.protocal.protobuf.dnd;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class g
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public g(LinkedList<dnc> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(29567);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dnd();
    ((b.a)localObject).hQG = new dne();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/talkstatreport";
    ((b.a)localObject).funcId = 373;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dnd)this.rr.hQD.hQJ;
    ((dnd)localObject).HUn = paramLinkedList.size();
    ((dnd)localObject).HUo = paramLinkedList;
    ((dnd)localObject).Scene = paramInt;
    AppMethodBeat.o(29567);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(29568);
    ae.d("MicroMsg.NetSceneTalkStatReport", "doScene");
    this.callback = paramf;
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
    ae.d("MicroMsg.NetSceneTalkStatReport", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
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