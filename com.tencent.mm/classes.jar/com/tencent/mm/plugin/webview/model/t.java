package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aql;
import com.tencent.mm.protocal.c.ash;
import com.tencent.mm.protocal.c.asi;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class t
  extends m
  implements k
{
  private final b dmK;
  private com.tencent.mm.ah.f dmL;
  
  public t(List<asw> paramList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ash();
    ((b.a)localObject).ecI = new asi();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/jslog";
    ((b.a)localObject).ecG = 1803;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ash)this.dmK.ecE.ecN;
    asv localasv = new asv();
    localasv.sEc = d.soV;
    localasv.sEd = d.soU;
    localasv.sEe = d.soX;
    localasv.sEf = d.soY;
    localasv.sEg = x.cqJ();
    localasv.toB = ((int)(System.currentTimeMillis() / 1000L));
    ((ash)localObject).svd = localasv;
    ((ash)localObject).sve.addAll(paramList);
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    y.d("MicroMsg.NetSceneJsLog", "doScene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneJsLog", "onGYNetEnd, netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (asi)((b)paramq).ecF.ecN;
      y.i("MicroMsg.NetSceneJsLog", "received InvalidLogList: ");
      paramArrayOfByte = new StringBuilder("{ ");
      if (!bk.dk(paramq.tok)) {
        break label155;
      }
      paramArrayOfByte.append("{  }");
    }
    for (;;)
    {
      paramArrayOfByte.append(" }");
      y.i("MicroMsg.NetSceneJsLog", paramArrayOfByte.toString());
      f.a.cbG();
      f.db(paramq.tok);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      label155:
      Iterator localIterator = paramq.tok.iterator();
      while (localIterator.hasNext())
      {
        aql localaql = (aql)localIterator.next();
        paramArrayOfByte.append(String.format(" { logId(%d), interval(%d) },", new Object[] { Integer.valueOf(localaql.tms), Integer.valueOf(localaql.tmt) }));
      }
    }
  }
  
  public final int getType()
  {
    return 1803;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.t
 * JD-Core Version:    0.7.0.1
 */