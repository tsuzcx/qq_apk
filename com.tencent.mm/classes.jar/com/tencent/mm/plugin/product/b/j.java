package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.protocal.protobuf.cmk;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class j
  extends n
  implements k
{
  private g callback;
  private b rr;
  public String uvK;
  public LinkedList<aec> uvV;
  public LinkedList<ax> uvW;
  
  public j(LinkedList<cmk> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(66900);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cbv();
    ((b.a)localObject).gUV = new cbw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/presubmitorder";
    ((b.a)localObject).funcId = 554;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cbv)this.rr.gUS.gUX;
    ((cbv)localObject).CPf = paramLinkedList;
    if (paramLinkedList != null) {
      i = paramLinkedList.size();
    }
    ((cbv)localObject).upl = i;
    ((cbv)localObject).DYe = paramInt;
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
    paramArrayOfByte = (cbw)((b)paramq).gUT.gUX;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.CEu == 0))
    {
      ad.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + paramArrayOfByte.DuP);
      ad.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + paramArrayOfByte.CPg);
      this.uvV = paramArrayOfByte.DYf;
      this.uvK = paramArrayOfByte.CPg;
      this.uvW = paramArrayOfByte.DYg;
    }
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramArrayOfByte.CEu != 0)
      {
        paramInt1 = paramArrayOfByte.CEu;
        paramq = paramArrayOfByte.CEv;
      }
    }
    ad.d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(66901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.j
 * JD-Core Version:    0.7.0.1
 */