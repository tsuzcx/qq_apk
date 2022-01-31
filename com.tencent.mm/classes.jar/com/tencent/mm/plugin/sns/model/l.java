package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.protocal.protobuf.bp;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class l
  extends m
  implements k
{
  public f callback;
  private LinkedList<bp> rer;
  private b rr;
  
  public l(LinkedList<bp> paramLinkedList)
  {
    AppMethodBeat.i(36242);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bj();
    ((b.a)localObject).fsY = new bk();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/addatareport";
    ((b.a)localObject).funcId = 1295;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bj)this.rr.fsV.fta;
    ((bj)localObject).wnQ = paramLinkedList;
    this.rer = paramLinkedList;
    ab.i("MicroMsg.NetSceneSnsAdDataReport", "report %d ads", new Object[] { Integer.valueOf(((bj)localObject).wnQ.size()) });
    AppMethodBeat.o(36242);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(36243);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(36243);
    return i;
  }
  
  public final int getType()
  {
    return 1295;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36244);
    ab.d("MicroMsg.NetSceneSnsAdDataReport", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(36244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.l
 * JD-Core Version:    0.7.0.1
 */