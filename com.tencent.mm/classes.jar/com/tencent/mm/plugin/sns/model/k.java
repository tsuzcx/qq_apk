package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.br;
import com.tencent.mm.protocal.protobuf.bs;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  public g callback;
  private b rr;
  private LinkedList<bx> xRk;
  
  public k(LinkedList<bx> paramLinkedList)
  {
    AppMethodBeat.i(95567);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new br();
    ((b.a)localObject).hvu = new bs();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/addatareport";
    ((b.a)localObject).funcId = 1295;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (br)this.rr.hvr.hvw;
    ((br)localObject).DOO = paramLinkedList;
    this.xRk = paramLinkedList;
    ac.i("MicroMsg.NetSceneSnsAdDataReport", "report %d ads", new Object[] { Integer.valueOf(((br)localObject).DOO.size()) });
    AppMethodBeat.o(95567);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(95568);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95568);
    return i;
  }
  
  public final int getType()
  {
    return 1295;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95569);
    ac.d("MicroMsg.NetSceneSnsAdDataReport", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(95569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.k
 * JD-Core Version:    0.7.0.1
 */