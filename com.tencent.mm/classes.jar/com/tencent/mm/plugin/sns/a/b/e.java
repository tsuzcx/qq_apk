package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ayw;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.protocal.protobuf.bq;
import com.tencent.mm.protocal.protobuf.br;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends m
  implements k
{
  public f callback;
  public List<ayx> iQp;
  private b rr;
  
  public e(List<ayx> paramList)
  {
    AppMethodBeat.i(35708);
    Object localObject = new b.a();
    this.iQp = paramList;
    ((b.a)localObject).fsX = new bq();
    ((b.a)localObject).fsY = new br();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/adlog";
    ((b.a)localObject).funcId = 1802;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bq)this.rr.fsV.fta;
    ayw localayw = new ayw();
    localayw.wAb = d.whC;
    localayw.wAc = d.whB;
    localayw.wAd = d.whE;
    localayw.wAe = d.whF;
    localayw.wAf = aa.dsG();
    localayw.wWT = ((int)(System.currentTimeMillis() / 1000L));
    ((bq)localObject).woj = localayw;
    while (i < paramList.size())
    {
      ((bq)localObject).wok.add(paramList.get(i));
      i += 1;
    }
    ab.i("MicroMsg.NetSceneAdLog", "report count: " + ((bq)localObject).wok.size());
    AppMethodBeat.o(35708);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(35709);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(35709);
    return i;
  }
  
  public final int getType()
  {
    return 1802;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(35710);
    ab.d("MicroMsg.NetSceneAdLog", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = ((br)((b)paramq).fsW.fta).wol;
      g.RM();
      g.RL().Ru().set(ac.a.yzR, Integer.valueOf(paramInt1));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(35710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.e
 * JD-Core Version:    0.7.0.1
 */