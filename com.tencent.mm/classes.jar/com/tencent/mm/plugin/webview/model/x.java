package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bqp;
import com.tencent.mm.protocal.protobuf.bsm;
import com.tencent.mm.protocal.protobuf.bsn;
import com.tencent.mm.protocal.protobuf.bte;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class x
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public x(List<btf> paramList)
  {
    AppMethodBeat.i(78909);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bsm();
    ((b.a)localObject).hQG = new bsn();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/jslog";
    ((b.a)localObject).funcId = 1803;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bsm)this.rr.hQD.hQJ;
    bte localbte = new bte();
    localbte.gvo = d.FFC;
    localbte.gvp = d.FFB;
    localbte.gvq = d.FFE;
    localbte.gvr = d.FFF;
    localbte.gvs = ad.fom();
    localbte.GKM = ((int)(System.currentTimeMillis() / 1000L));
    ((bsm)localObject).FMV = localbte;
    ((bsm)localObject).FMW.addAll(paramList);
    AppMethodBeat.o(78909);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78911);
    this.callback = paramf;
    ae.d("MicroMsg.NetSceneJsLog", "doScene");
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
    ae.i("MicroMsg.NetSceneJsLog", "onGYNetEnd, netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bsn)((b)paramq).hQE.hQJ;
      ae.i("MicroMsg.NetSceneJsLog", "received InvalidLogList: ");
      paramArrayOfByte = new StringBuilder("{ ");
      if (!bu.ht(paramq.Hgk)) {
        break label165;
      }
      paramArrayOfByte.append("{  }");
    }
    for (;;)
    {
      paramArrayOfByte.append(" }");
      ae.i("MicroMsg.NetSceneJsLog", paramArrayOfByte.toString());
      h.a.eTH();
      h.hd(paramq.Hgk);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78910);
      return;
      label165:
      Iterator localIterator = paramq.Hgk.iterator();
      while (localIterator.hasNext())
      {
        bqp localbqp = (bqp)localIterator.next();
        paramArrayOfByte.append(String.format(" { logId(%d), interval(%d) },", new Object[] { Integer.valueOf(localbqp.HdZ), Integer.valueOf(localbqp.Hea) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.x
 * JD-Core Version:    0.7.0.1
 */