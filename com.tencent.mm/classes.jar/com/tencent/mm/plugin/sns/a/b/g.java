package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n
  implements k
{
  public com.tencent.mm.al.g callback;
  public List<bkf> lEL;
  private b rr;
  
  public g(List<bkf> paramList)
  {
    AppMethodBeat.i(94982);
    Object localObject = new b.a();
    this.lEL = paramList;
    ((b.a)localObject).gUU = new bw();
    ((b.a)localObject).gUV = new bx();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/adlog";
    ((b.a)localObject).funcId = 1802;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bw)this.rr.gUS.gUX;
    bke localbke = new bke();
    localbke.fVv = d.CpF;
    localbke.fVw = d.CpE;
    localbke.fVx = d.CpH;
    localbke.fVy = d.CpI;
    localbke.fVz = ac.eFu();
    localbke.Dnx = ((int)(System.currentTimeMillis() / 1000L));
    ((bw)localObject).CwR = localbke;
    while (i < paramList.size())
    {
      ((bw)localObject).CwS.add(paramList.get(i));
      i += 1;
    }
    ad.i("MicroMsg.NetSceneAdLog", "report count: " + ((bw)localObject).CwS.size());
    AppMethodBeat.o(94982);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
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
    ad.d("MicroMsg.NetSceneAdLog", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = ((bx)((b)paramq).gUT.gUX).CwT;
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fim, Integer.valueOf(paramInt1));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.g
 * JD-Core Version:    0.7.0.1
 */