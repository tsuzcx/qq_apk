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
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class j
  extends n
  implements k
{
  private g callback;
  private b rr;
  public String vED;
  public LinkedList<afb> vEO;
  public LinkedList<az> vEP;
  
  public j(LinkedList<crr> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(66900);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cgx();
    ((b.a)localObject).hvu = new cgy();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/presubmitorder";
    ((b.a)localObject).funcId = 554;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cgx)this.rr.hvr.hvw;
    ((cgx)localObject).EhQ = paramLinkedList;
    if (paramLinkedList != null) {
      i = paramLinkedList.size();
    }
    ((cgx)localObject).vyh = i;
    ((cgx)localObject).FuY = paramInt;
    AppMethodBeat.o(66900);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(66902);
    this.callback = paramg;
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
    paramArrayOfByte = (cgy)((b)paramq).hvs.hvw;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.DWU == 0))
    {
      ac.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + paramArrayOfByte.EPY);
      ac.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + paramArrayOfByte.EhR);
      this.vEO = paramArrayOfByte.FuZ;
      this.vED = paramArrayOfByte.EhR;
      this.vEP = paramArrayOfByte.Fva;
    }
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
    ac.d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(66901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.j
 * JD-Core Version:    0.7.0.1
 */