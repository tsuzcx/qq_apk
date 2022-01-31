package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.protocal.protobuf.bhs;
import com.tencent.mm.protocal.protobuf.crf;
import java.util.LinkedList;

public final class a
  extends m
  implements k
{
  private f callback;
  private b rr;
  
  public a(LinkedList<crf> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(25247);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bhr();
    ((b.a)localObject).fsY = new bhs();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/opvoicereminder";
    ((b.a)localObject).funcId = 331;
    ((b.a)localObject).reqCmdId = 150;
    ((b.a)localObject).respCmdId = 1000000150;
    this.rr = ((b.a)localObject).ado();
    localObject = (bhr)this.rr.fsV.fta;
    ((bhr)localObject).OpCode = 1;
    ((bhr)localObject).xwK = paramLinkedList;
    ((bhr)localObject).xwJ = paramInt;
    AppMethodBeat.o(25247);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25248);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25248);
    return i;
  }
  
  public final int getType()
  {
    return 331;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25249);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(25249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.a
 * JD-Core Version:    0.7.0.1
 */