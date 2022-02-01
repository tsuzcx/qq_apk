package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.br;
import com.tencent.mm.protocal.protobuf.bs;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  public f callback;
  private b rr;
  private LinkedList<bx> zhe;
  
  public k(LinkedList<bx> paramLinkedList)
  {
    AppMethodBeat.i(95567);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new br();
    ((b.a)localObject).hNN = new bs();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/addatareport";
    ((b.a)localObject).funcId = 1295;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (br)this.rr.hNK.hNQ;
    ((br)localObject).FtY = paramLinkedList;
    this.zhe = paramLinkedList;
    ad.i("MicroMsg.NetSceneSnsAdDataReport", "report %d ads", new Object[] { Integer.valueOf(((br)localObject).FtY.size()) });
    AppMethodBeat.o(95567);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(95568);
    this.callback = paramf;
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
    ad.d("MicroMsg.NetSceneSnsAdDataReport", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(95569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.k
 * JD-Core Version:    0.7.0.1
 */