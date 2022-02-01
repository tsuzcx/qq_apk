package com.tencent.mm.plugin.translate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.cdw;
import com.tencent.mm.protocal.protobuf.euw;
import com.tencent.mm.protocal.protobuf.eux;
import java.util.LinkedList;

public final class b
  extends q
  implements m
{
  public LinkedList<eux> NfW;
  private i callback;
  private final d rr;
  
  public b(LinkedList<euw> paramLinkedList)
  {
    AppMethodBeat.i(29739);
    this.callback = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cdv();
    ((d.a)localObject).lBV = new cdw();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/gettranstext";
    ((d.a)localObject).funcId = 631;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cdv)d.b.b(this.rr.lBR);
    ((cdv)localObject).TlE = paramLinkedList;
    ((cdv)localObject).rVw = paramLinkedList.size();
    AppMethodBeat.o(29739);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(29740);
    this.callback = parami;
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
    d.b.b(this.rr.lBR);
    this.NfW = ((cdw)d.c.b(this.rr.lBS)).TlE;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.b
 * JD-Core Version:    0.7.0.1
 */