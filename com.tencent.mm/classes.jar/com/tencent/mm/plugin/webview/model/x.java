package com.tencent.mm.plugin.webview.model;

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
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bpv;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.brt;
import com.tencent.mm.protocal.protobuf.bsk;
import com.tencent.mm.protocal.protobuf.bsl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class x
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public x(List<bsl> paramList)
  {
    AppMethodBeat.i(78909);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new brs();
    ((b.a)localObject).hNN = new brt();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/jslog";
    ((b.a)localObject).funcId = 1803;
    this.rr = ((b.a)localObject).aDC();
    localObject = (brs)this.rr.hNK.hNQ;
    bsk localbsk = new bsk();
    localbsk.gsM = d.Fne;
    localbsk.gsN = d.Fnd;
    localbsk.gsO = d.Fng;
    localbsk.gsP = d.Fnh;
    localbsk.gsQ = ac.fks();
    localbsk.Gro = ((int)(System.currentTimeMillis() / 1000L));
    ((brs)localObject).Fux = localbsk;
    ((brs)localObject).Fuy.addAll(paramList);
    AppMethodBeat.o(78909);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78911);
    this.callback = paramf;
    ad.d("MicroMsg.NetSceneJsLog", "doScene");
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
    ad.i("MicroMsg.NetSceneJsLog", "onGYNetEnd, netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (brt)((b)paramq).hNL.hNQ;
      ad.i("MicroMsg.NetSceneJsLog", "received InvalidLogList: ");
      paramArrayOfByte = new StringBuilder("{ ");
      if (!bt.hj(paramq.GMJ)) {
        break label165;
      }
      paramArrayOfByte.append("{  }");
    }
    for (;;)
    {
      paramArrayOfByte.append(" }");
      ad.i("MicroMsg.NetSceneJsLog", paramArrayOfByte.toString());
      h.a.ePV();
      h.gT(paramq.GMJ);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78910);
      return;
      label165:
      Iterator localIterator = paramq.GMJ.iterator();
      while (localIterator.hasNext())
      {
        bpv localbpv = (bpv)localIterator.next();
        paramArrayOfByte.append(String.format(" { logId(%d), interval(%d) },", new Object[] { Integer.valueOf(localbpv.GKy), Integer.valueOf(localbpv.GKz) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.x
 * JD-Core Version:    0.7.0.1
 */