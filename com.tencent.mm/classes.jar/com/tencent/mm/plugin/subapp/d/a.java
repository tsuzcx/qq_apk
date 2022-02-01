package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.protocal.protobuf.fcu;
import java.util.LinkedList;

public final class a
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public a(LinkedList<fcu> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(28926);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new deu();
    ((d.a)localObject).lBV = new dev();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/opvoicereminder";
    ((d.a)localObject).funcId = 331;
    ((d.a)localObject).lBW = 150;
    ((d.a)localObject).respCmdId = 1000000150;
    this.rr = ((d.a)localObject).bgN();
    localObject = (deu)d.b.b(this.rr.lBR);
    ((deu)localObject).RLe = 1;
    ((deu)localObject).TMv = paramLinkedList;
    ((deu)localObject).TMu = paramInt;
    AppMethodBeat.o(28926);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(28927);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(28927);
    return i;
  }
  
  public final int getType()
  {
    return 331;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
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