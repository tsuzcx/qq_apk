package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cfd;
import com.tencent.mm.protocal.protobuf.cfe;
import com.tencent.mm.protocal.protobuf.dyc;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public a(LinkedList<dyc> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(28926);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cfd();
    ((b.a)localObject).hQG = new cfe();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/opvoicereminder";
    ((b.a)localObject).funcId = 331;
    ((b.a)localObject).hQH = 150;
    ((b.a)localObject).respCmdId = 1000000150;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cfd)this.rr.hQD.hQJ;
    ((cfd)localObject).OpCode = 1;
    ((cfd)localObject).HrQ = paramLinkedList;
    ((cfd)localObject).HrP = paramInt;
    AppMethodBeat.o(28926);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(28927);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(28927);
    return i;
  }
  
  public final int getType()
  {
    return 331;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28928);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.a
 * JD-Core Version:    0.7.0.1
 */