package com.tencent.mm.plugin.webview.model;

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
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bht;
import com.tencent.mm.protocal.protobuf.bjo;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bkf;
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
  private g callback;
  private final b rr;
  
  public x(List<bkf> paramList)
  {
    AppMethodBeat.i(78909);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bjo();
    ((b.a)localObject).gUV = new bjp();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/jslog";
    ((b.a)localObject).funcId = 1803;
    this.rr = ((b.a)localObject).atI();
    localObject = (bjo)this.rr.gUS.gUX;
    bke localbke = new bke();
    localbke.fVv = d.CpF;
    localbke.fVw = d.CpE;
    localbke.fVx = d.CpH;
    localbke.fVy = d.CpI;
    localbke.fVz = ac.eFu();
    localbke.Dnx = ((int)(System.currentTimeMillis() / 1000L));
    ((bjo)localObject).CwR = localbke;
    ((bjo)localObject).CwS.addAll(paramList);
    AppMethodBeat.o(78909);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78911);
    this.callback = paramg;
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
      paramq = (bjp)((b)paramq).gUT.gUX;
      ad.i("MicroMsg.NetSceneJsLog", "received InvalidLogList: ");
      paramArrayOfByte = new StringBuilder("{ ");
      if (!bt.gL(paramq.DHO)) {
        break label165;
      }
      paramArrayOfByte.append("{  }");
    }
    for (;;)
    {
      paramArrayOfByte.append(" }");
      ad.i("MicroMsg.NetSceneJsLog", paramArrayOfByte.toString());
      h.a.elH();
      h.gw(paramq.DHO);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78910);
      return;
      label165:
      Iterator localIterator = paramq.DHO.iterator();
      while (localIterator.hasNext())
      {
        bht localbht = (bht)localIterator.next();
        paramArrayOfByte.append(String.format(" { logId(%d), interval(%d) },", new Object[] { Integer.valueOf(localbht.DFF), Integer.valueOf(localbht.DFG) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.x
 * JD-Core Version:    0.7.0.1
 */