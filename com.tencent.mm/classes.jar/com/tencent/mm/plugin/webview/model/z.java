package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgo;
import com.tencent.mm.protocal.protobuf.bgp;
import java.util.LinkedList;

public final class z
  extends m
  implements k
{
  private f eGj;
  public final b rr;
  public Object tag;
  
  public z(String paramString, int paramInt, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(6634);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bgo();
    ((b.a)localObject).fsY = new bgp();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_authorize_confirm";
    ((b.a)localObject).funcId = 1373;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bgo)this.rr.fsV.fta;
    ((bgo)localObject).xvQ = paramString;
    ((bgo)localObject).xvR = paramInt;
    ((bgo)localObject).xvS = paramLinkedList;
    AppMethodBeat.o(6634);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6636);
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6636);
    return i;
  }
  
  public final int getType()
  {
    return 1373;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6635);
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.z
 * JD-Core Version:    0.7.0.1
 */