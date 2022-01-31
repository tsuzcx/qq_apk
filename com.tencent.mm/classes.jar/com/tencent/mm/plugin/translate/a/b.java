package com.tencent.mm.plugin.translate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.protocal.protobuf.aqs;
import com.tencent.mm.protocal.protobuf.cls;
import com.tencent.mm.protocal.protobuf.clt;
import java.util.LinkedList;

public final class b
  extends m
  implements k
{
  private f callback;
  private final com.tencent.mm.ai.b rr;
  public LinkedList<clt> toP;
  
  public b(LinkedList<cls> paramLinkedList)
  {
    AppMethodBeat.i(26058);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aqr();
    ((b.a)localObject).fsY = new aqs();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/gettranstext";
    ((b.a)localObject).funcId = 631;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (aqr)this.rr.fsV.fta;
    ((aqr)localObject).xfZ = paramLinkedList;
    ((aqr)localObject).jJt = paramLinkedList.size();
    AppMethodBeat.o(26058);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26059);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(26059);
    return i;
  }
  
  public final int getType()
  {
    return 631;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26060);
    this.toP = ((aqs)this.rr.fsW.fta).xfZ;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.b
 * JD-Core Version:    0.7.0.1
 */