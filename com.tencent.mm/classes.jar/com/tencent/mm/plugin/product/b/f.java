package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.protocal.protobuf.qp;
import com.tencent.mm.protocal.protobuf.qq;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class f
  extends n
  implements k
{
  private g callback;
  private b rr;
  
  public f(LinkedList<crr> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(66888);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new qp();
    ((b.a)localObject).hvu = new qq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/cancelpreorder";
    ((b.a)localObject).funcId = 555;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (qp)this.rr.hvr.hvw;
    ((qp)localObject).EhQ = paramLinkedList;
    if (paramLinkedList != null) {
      i = paramLinkedList.size();
    }
    ((qp)localObject).vyh = i;
    ((qp)localObject).EhR = paramString;
    ac.d("MicroMsg.NetSceneMallCancelPreOrder", "lockId ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(66888);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(66890);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(66890);
    return i;
  }
  
  public final int getType()
  {
    return 555;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66889);
    paramArrayOfByte = (qq)((b)paramq).hvs.hvw;
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramArrayOfByte.DWU != 0)
      {
        paramInt1 = paramArrayOfByte.DWU;
        paramq = paramArrayOfByte.DWV;
      }
    }
    ac.d("MicroMsg.NetSceneMallCancelPreOrder", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(66889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.f
 * JD-Core Version:    0.7.0.1
 */