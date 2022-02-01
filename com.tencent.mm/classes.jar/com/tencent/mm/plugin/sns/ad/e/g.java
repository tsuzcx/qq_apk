package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bte;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n
  implements k
{
  public f callback;
  public List<btf> mMj;
  private b rr;
  
  public g(List<btf> paramList)
  {
    AppMethodBeat.i(94982);
    Object localObject = new b.a();
    this.mMj = paramList;
    ((b.a)localObject).hQF = new by();
    ((b.a)localObject).hQG = new bz();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/adlog";
    ((b.a)localObject).funcId = 1802;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (by)this.rr.hQD.hQJ;
    bte localbte = new bte();
    localbte.gvo = d.FFC;
    localbte.gvp = d.FFB;
    localbte.gvq = d.FFE;
    localbte.gvr = d.FFF;
    localbte.gvs = ad.fom();
    localbte.GKM = ((int)(System.currentTimeMillis() / 1000L));
    ((by)localObject).FMV = localbte;
    while (i < paramList.size())
    {
      ((by)localObject).FMW.add(paramList.get(i));
      i += 1;
    }
    ae.i("MicroMsg.NetSceneAdLog", "report count: " + ((by)localObject).FMW.size());
    AppMethodBeat.o(94982);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(94983);
    this.callback = paramf;
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
    ae.d("MicroMsg.NetSceneAdLog", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = ((bz)((b)paramq).hQE.hQJ).FMX;
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMP, Integer.valueOf(paramInt1));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.g
 * JD-Core Version:    0.7.0.1
 */