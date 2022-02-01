package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.clw;
import com.tencent.mm.protocal.protobuf.clx;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class j
  extends n
  implements k
{
  private f callback;
  private b rr;
  public String wLJ;
  public LinkedList<ahk> wLU;
  public LinkedList<az> wLV;
  
  public j(LinkedList<cwy> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(66900);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new clw();
    ((b.a)localObject).hNN = new clx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/presubmitorder";
    ((b.a)localObject).funcId = 554;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (clw)this.rr.hNK.hNQ;
    ((clw)localObject).FOX = paramLinkedList;
    if (paramLinkedList != null) {
      i = paramLinkedList.size();
    }
    ((clw)localObject).wDB = i;
    ((clw)localObject).Hfd = paramInt;
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
    paramArrayOfByte = (clx)((b)paramq).hNL.hNQ;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.FCq == 0))
    {
      ad.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + paramArrayOfByte.Gzp);
      ad.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + paramArrayOfByte.FOY);
      this.wLU = paramArrayOfByte.Hfe;
      this.wLJ = paramArrayOfByte.FOY;
      this.wLV = paramArrayOfByte.Hff;
    }
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramArrayOfByte.FCq != 0)
      {
        paramInt1 = paramArrayOfByte.FCq;
        paramq = paramArrayOfByte.FCr;
      }
    }
    ad.d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(66901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.j
 * JD-Core Version:    0.7.0.1
 */