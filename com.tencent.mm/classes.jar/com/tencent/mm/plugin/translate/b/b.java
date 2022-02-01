package com.tencent.mm.plugin.translate.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.protocal.protobuf.fqj;
import com.tencent.mm.protocal.protobuf.fqk;
import java.util.LinkedList;

public final class b
  extends p
  implements m
{
  public LinkedList<fqk> TSJ;
  private h callback;
  private final c rr;
  
  public b(LinkedList<fqj> paramLinkedList)
  {
    AppMethodBeat.i(29739);
    this.callback = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ctv();
    ((c.a)localObject).otF = new ctw();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/gettranstext";
    ((c.a)localObject).funcId = 631;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ctv)c.b.b(this.rr.otB);
    ((ctv)localObject).aazx = paramLinkedList;
    ((ctv)localObject).vgM = paramLinkedList.size();
    AppMethodBeat.o(29739);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(29740);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(29740);
    return i;
  }
  
  public final int getType()
  {
    return 631;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29741);
    c.b.b(this.rr.otB);
    this.TSJ = ((ctw)c.c.b(this.rr.otC)).aazx;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.b.b
 * JD-Core Version:    0.7.0.1
 */