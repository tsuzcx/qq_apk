package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahu;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.cmq;
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.protocal.protobuf.cxs;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class j
  extends n
  implements k
{
  private f callback;
  private b rr;
  public LinkedList<ahu> xbI;
  public LinkedList<az> xbJ;
  public String xbx;
  
  public j(LinkedList<cxs> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(66900);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cmq();
    ((b.a)localObject).hQG = new cmr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/presubmitorder";
    ((b.a)localObject).funcId = 554;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cmq)this.rr.hQD.hQJ;
    ((cmq)localObject).Ghw = paramLinkedList;
    if (paramLinkedList != null) {
      i = paramLinkedList.size();
    }
    ((cmq)localObject).wTm = i;
    ((cmq)localObject).HyD = paramInt;
    AppMethodBeat.o(66900);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(66902);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(66902);
    return i;
  }
  
  public final int getType()
  {
    return 554;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66901);
    paramArrayOfByte = (cmr)((b)paramq).hQE.hQJ;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.FUL == 0))
    {
      ae.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + paramArrayOfByte.GSP);
      ae.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + paramArrayOfByte.Ghx);
      this.xbI = paramArrayOfByte.HyE;
      this.xbx = paramArrayOfByte.Ghx;
      this.xbJ = paramArrayOfByte.HyF;
    }
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramArrayOfByte.FUL != 0)
      {
        paramInt1 = paramArrayOfByte.FUL;
        paramq = paramArrayOfByte.FUM;
      }
    }
    ae.d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(66901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.j
 * JD-Core Version:    0.7.0.1
 */