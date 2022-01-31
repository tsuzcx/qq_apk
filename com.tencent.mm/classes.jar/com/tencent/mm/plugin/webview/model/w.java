package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.awo;
import com.tencent.mm.protocal.protobuf.ayi;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.ayw;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private final b rr;
  
  public w(List<ayx> paramList)
  {
    AppMethodBeat.i(6625);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ayi();
    ((b.a)localObject).fsY = new ayj();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/jslog";
    ((b.a)localObject).funcId = 1803;
    this.rr = ((b.a)localObject).ado();
    localObject = (ayi)this.rr.fsV.fta;
    ayw localayw = new ayw();
    localayw.wAb = d.whC;
    localayw.wAc = d.whB;
    localayw.wAd = d.whE;
    localayw.wAe = d.whF;
    localayw.wAf = aa.dsG();
    localayw.wWT = ((int)(System.currentTimeMillis() / 1000L));
    ((ayi)localObject).woj = localayw;
    ((ayi)localObject).wok.addAll(paramList);
    AppMethodBeat.o(6625);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(6627);
    this.callback = paramf;
    ab.d("MicroMsg.NetSceneJsLog", "doScene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6627);
    return i;
  }
  
  public final int getType()
  {
    return 1803;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6626);
    ab.i("MicroMsg.NetSceneJsLog", "onGYNetEnd, netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ayj)((b)paramq).fsW.fta;
      ab.i("MicroMsg.NetSceneJsLog", "received InvalidLogList: ");
      paramArrayOfByte = new StringBuilder("{ ");
      if (!bo.es(paramq.xof)) {
        break label167;
      }
      paramArrayOfByte.append("{  }");
    }
    for (;;)
    {
      paramArrayOfByte.append(" }");
      ab.i("MicroMsg.NetSceneJsLog", paramArrayOfByte.toString());
      f.a.dbJ();
      f.ef(paramq.xof);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(6626);
      return;
      label167:
      Iterator localIterator = paramq.xof.iterator();
      while (localIterator.hasNext())
      {
        awo localawo = (awo)localIterator.next();
        paramArrayOfByte.append(String.format(" { logId(%d), interval(%d) },", new Object[] { Integer.valueOf(localawo.xme), Integer.valueOf(localawo.xmf) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.w
 * JD-Core Version:    0.7.0.1
 */