package com.tencent.mm.plugin.subapp.modelvoiceremind;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dwt;
import com.tencent.mm.protocal.protobuf.dwu;
import com.tencent.mm.protocal.protobuf.fzg;
import java.util.LinkedList;

public final class a
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public a(LinkedList<fzg> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(28926);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dwt();
    ((c.a)localObject).otF = new dwu();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/opvoicereminder";
    ((c.a)localObject).funcId = 331;
    ((c.a)localObject).otG = 150;
    ((c.a)localObject).respCmdId = 1000000150;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dwt)c.b.b(this.rr.otB);
    ((dwt)localObject).YIq = 1;
    ((dwt)localObject).abcE = paramLinkedList;
    ((dwt)localObject).abcD = paramInt;
    AppMethodBeat.o(28926);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(28927);
    this.callback = paramh;
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
 * Qualified Name:     com.tencent.mm.plugin.subapp.modelvoiceremind.a
 * JD-Core Version:    0.7.0.1
 */