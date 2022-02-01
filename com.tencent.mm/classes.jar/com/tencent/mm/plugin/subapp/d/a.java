package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.bvb;
import com.tencent.mm.protocal.protobuf.dla;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  private g callback;
  private b rr;
  
  public a(LinkedList<dla> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(28926);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bva();
    ((b.a)localObject).gUV = new bvb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/opvoicereminder";
    ((b.a)localObject).funcId = 331;
    ((b.a)localObject).reqCmdId = 150;
    ((b.a)localObject).respCmdId = 1000000150;
    this.rr = ((b.a)localObject).atI();
    localObject = (bva)this.rr.gUS.gUX;
    ((bva)localObject).OpCode = 1;
    ((bva)localObject).DSh = paramLinkedList;
    ((bva)localObject).DSg = paramInt;
    AppMethodBeat.o(28926);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(28927);
    this.callback = paramg;
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