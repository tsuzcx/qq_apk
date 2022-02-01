package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bny;
import com.tencent.mm.protocal.protobuf.bnz;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n
  implements k
{
  public com.tencent.mm.ak.g callback;
  public List<bnz> mgF;
  private b rr;
  
  public g(List<bnz> paramList)
  {
    AppMethodBeat.i(94982);
    Object localObject = new b.a();
    this.mgF = paramList;
    ((b.a)localObject).hvt = new by();
    ((b.a)localObject).hvu = new bz();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/adlog";
    ((b.a)localObject).funcId = 1802;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (by)this.rr.hvr.hvw;
    bny localbny = new bny();
    localbny.fZq = d.DHX;
    localbny.fZr = d.DHW;
    localbny.fZs = d.DHZ;
    localbny.fZt = d.DIa;
    localbny.fZu = ab.eUO();
    localbny.EIx = ((int)(System.currentTimeMillis() / 1000L));
    ((by)localObject).DPn = localbny;
    while (i < paramList.size())
    {
      ((by)localObject).DPo.add(paramList.get(i));
      i += 1;
    }
    ac.i("MicroMsg.NetSceneAdLog", "report count: " + ((by)localObject).DPo.size());
    AppMethodBeat.o(94982);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(94983);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(94983);
    return i;
  }
  
  public final int getType()
  {
    return 1802;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94984);
    ac.d("MicroMsg.NetSceneAdLog", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = ((bz)((b)paramq).hvs.hvw).DPp;
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGb, Integer.valueOf(paramInt1));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.g
 * JD-Core Version:    0.7.0.1
 */