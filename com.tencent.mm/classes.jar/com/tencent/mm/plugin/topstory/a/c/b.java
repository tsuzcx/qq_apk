package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.dnp;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.protocal.protobuf.eej;
import com.tencent.mm.protocal.protobuf.eek;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  private f callback;
  public dnp dLe;
  private com.tencent.mm.al.b rr;
  private long soX;
  
  public b(dnp paramdnp, int paramInt, String paramString)
  {
    AppMethodBeat.i(91005);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStory Home channelId:%s, %s %s %s", new Object[] { Integer.valueOf(paramdnp.cSc), Integer.valueOf(paramInt), paramdnp.qXu, paramdnp.sessionId });
    this.soX = System.currentTimeMillis();
    this.dLe = paramdnp;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject).hNM = new eej();
    ((b.a)localObject).hNN = new eek();
    this.rr = ((b.a)localObject).aDC();
    localObject = (eej)this.rr.hNK.hNQ;
    ((eej)localObject).FMu = paramdnp.offset;
    ((eej)localObject).GDa = com.tencent.mm.plugin.websearch.api.ad.We(1);
    ((eej)localObject).Gsr = paramdnp.dld;
    ((eej)localObject).GRt = com.tencent.mm.plugin.websearch.api.ad.bNG();
    ((eej)localObject).Scene = paramdnp.scene;
    ((eej)localObject).FMt = paramdnp.keN;
    ((eej)localObject).HOp.addAll(paramdnp.DBj);
    ((eej)localObject).HAv = paramdnp.cSc;
    ((eej)localObject).HPE = paramInt;
    ((eej)localObject).HPF = paramdnp.HBF;
    if (((eej)localObject).HAv == 110)
    {
      paramString = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eok();
      if (paramString != null) {
        ((eej)localObject).HjQ = paramString.msgId;
      }
    }
    for (;;)
    {
      ((eej)localObject).HPC = paramdnp.DBr;
      ((eej)localObject).HPD = paramdnp.HBE;
      paramdnp = new aag();
      paramdnp.key = "client_system_version";
      paramdnp.FZe = Build.VERSION.SDK_INT;
      ((eej)localObject).HOp.add(paramdnp);
      paramdnp = new aag();
      paramdnp.key = "netType";
      paramdnp.FZf = com.tencent.mm.plugin.websearch.api.ad.Ux();
      ((eej)localObject).HOp.add(paramdnp);
      paramdnp = new aag();
      paramdnp.key = "client_request_time";
      paramdnp.FZf = String.valueOf(System.currentTimeMillis());
      ((eej)localObject).HOp.add(paramdnp);
      paramdnp = ((eej)localObject).HOp.iterator();
      while (paramdnp.hasNext())
      {
        paramString = (aag)paramdnp.next();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.NetSceneTopStory", "key: %s unit_value %s text_value %s", new Object[] { paramString.key, Long.valueOf(paramString.FZe), paramString.FZf });
      }
      if (((eej)localObject).HAv == 100) {
        ((eej)localObject).HjQ = paramString;
      } else {
        ((eej)localObject).HjQ = "";
      }
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.NetSceneTopStory", "request params offset %d h5Version %d CheckDocListSize: %d", new Object[] { Integer.valueOf(((eej)localObject).FMu), Integer.valueOf(((eej)localObject).GDa), Integer.valueOf(((eej)localObject).HPD.size()) });
    AppMethodBeat.o(91005);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(91006);
    am.iR(this.dLe.scene, 2);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(91006);
    return i;
  }
  
  public final eek eoU()
  {
    return (eek)this.rr.hNL.hNQ;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91007);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.soX) });
    if (paramInt3 == -1) {
      am.iR(this.dLe.scene, 4);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(91007);
      return;
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        am.iR(this.dLe.scene, 8);
      } else {
        am.iR(this.dLe.scene, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.b
 * JD-Core Version:    0.7.0.1
 */