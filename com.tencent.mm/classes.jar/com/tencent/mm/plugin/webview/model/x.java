package com.tencent.mm.plugin.webview.model;

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
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bll;
import com.tencent.mm.protocal.protobuf.bni;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.protocal.protobuf.bny;
import com.tencent.mm.protocal.protobuf.bnz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class x
  extends n
  implements k
{
  private g callback;
  private final b rr;
  
  public x(List<bnz> paramList)
  {
    AppMethodBeat.i(78909);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bni();
    ((b.a)localObject).hvu = new bnj();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/jslog";
    ((b.a)localObject).funcId = 1803;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bni)this.rr.hvr.hvw;
    bny localbny = new bny();
    localbny.fZq = d.DHX;
    localbny.fZr = d.DHW;
    localbny.fZs = d.DHZ;
    localbny.fZt = d.DIa;
    localbny.fZu = ab.eUO();
    localbny.EIx = ((int)(System.currentTimeMillis() / 1000L));
    ((bni)localObject).DPn = localbny;
    ((bni)localObject).DPo.addAll(paramList);
    AppMethodBeat.o(78909);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78911);
    this.callback = paramg;
    ac.d("MicroMsg.NetSceneJsLog", "doScene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78911);
    return i;
  }
  
  public final int getType()
  {
    return 1803;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78910);
    ac.i("MicroMsg.NetSceneJsLog", "onGYNetEnd, netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bnj)((b)paramq).hvs.hvw;
      ac.i("MicroMsg.NetSceneJsLog", "received InvalidLogList: ");
      paramArrayOfByte = new StringBuilder("{ ");
      if (!bs.gY(paramq.Fdj)) {
        break label165;
      }
      paramArrayOfByte.append("{  }");
    }
    for (;;)
    {
      paramArrayOfByte.append(" }");
      ac.i("MicroMsg.NetSceneJsLog", paramArrayOfByte.toString());
      h.a.eBd();
      h.gH(paramq.Fdj);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78910);
      return;
      label165:
      Iterator localIterator = paramq.Fdj.iterator();
      while (localIterator.hasNext())
      {
        bll localbll = (bll)localIterator.next();
        paramArrayOfByte.append(String.format(" { logId(%d), interval(%d) },", new Object[] { Integer.valueOf(localbll.FaZ), Integer.valueOf(localbll.Fba) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.x
 * JD-Core Version:    0.7.0.1
 */