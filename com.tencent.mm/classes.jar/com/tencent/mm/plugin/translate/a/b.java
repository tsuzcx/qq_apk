package com.tencent.mm.plugin.translate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjy;
import com.tencent.mm.protocal.protobuf.bjz;
import com.tencent.mm.protocal.protobuf.dqv;
import com.tencent.mm.protocal.protobuf.dqw;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  public LinkedList<dqw> BSE;
  private f callback;
  private final com.tencent.mm.ak.b rr;
  
  public b(LinkedList<dqv> paramLinkedList)
  {
    AppMethodBeat.i(29739);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bjy();
    ((b.a)localObject).hQG = new bjz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/gettranstext";
    ((b.a)localObject).funcId = 631;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bjy)this.rr.hQD.hQJ;
    ((bjy)localObject).GXr = paramLinkedList;
    ((bjy)localObject).nIC = paramLinkedList.size();
    AppMethodBeat.o(29739);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(29740);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29740);
    return i;
  }
  
  public final int getType()
  {
    return 631;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29741);
    this.BSE = ((bjz)this.rr.hQE.hQJ).GXr;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.b
 * JD-Core Version:    0.7.0.1
 */