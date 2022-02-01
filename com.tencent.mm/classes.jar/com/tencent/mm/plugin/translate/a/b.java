package com.tencent.mm.plugin.translate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.des;
import com.tencent.mm.protocal.protobuf.det;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.al.b rr;
  public LinkedList<det> yVF;
  
  public b(LinkedList<des> paramLinkedList)
  {
    AppMethodBeat.i(29739);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bbg();
    ((b.a)localObject).gUV = new bbh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/gettranstext";
    ((b.a)localObject).funcId = 631;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bbg)this.rr.gUS.gUX;
    ((bbg)localObject).DyV = paramLinkedList;
    ((bbg)localObject).mAJ = paramLinkedList.size();
    AppMethodBeat.o(29739);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(29740);
    this.callback = paramg;
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
    this.yVF = ((bbh)this.rr.gUT.gUX).DyV;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.b
 * JD-Core Version:    0.7.0.1
 */