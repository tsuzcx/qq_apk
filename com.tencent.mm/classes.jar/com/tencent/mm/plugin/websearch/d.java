package com.tencent.mm.plugin.websearch;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.protocal.c.bk;
import com.tencent.mm.protocal.c.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class d
  implements n
{
  private int qTr;
  
  public final void Bk(int paramInt)
  {
    this.qTr = paramInt;
  }
  
  public final void aR(int paramInt, String paramString)
  {
    asw localasw = new asw();
    localasw.tou = paramInt;
    localasw.toC = ((int)(System.currentTimeMillis() / 1000L));
    localasw.hPS = 1;
    localasw.tov = new com.tencent.mm.bv.b(paramString.getBytes());
    paramString = new b.a();
    paramString.ecH = new bk();
    paramString.ecI = new bl();
    paramString.uri = "/cgi-bin/mmux-bin/adlog";
    paramString.ecG = 1802;
    paramString = paramString.Kt();
    bk localbk = (bk)paramString.ecE.ecN;
    asv localasv = new asv();
    localasv.sEc = com.tencent.mm.protocal.d.soV;
    localasv.sEd = com.tencent.mm.protocal.d.soU;
    localasv.sEe = com.tencent.mm.protocal.d.soX;
    localasv.sEf = com.tencent.mm.protocal.d.soY;
    localasv.sEg = x.cqJ();
    localasv.toB = ((int)(System.currentTimeMillis() / 1000L));
    localbk.svd = localasv;
    localbk.sve.add(localasw);
    w.a(paramString, new w.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.b paramAnonymousb, m paramAnonymousm)
      {
        y.d("WebSearchService", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
          h.nFQ.a(457L, 1L, 1L, false);
        }
        return 0;
      }
    });
  }
  
  public final int bZi()
  {
    return this.qTr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.d
 * JD-Core Version:    0.7.0.1
 */