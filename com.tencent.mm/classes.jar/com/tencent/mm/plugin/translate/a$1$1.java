package com.tencent.mm.plugin.translate;

import com.tencent.mm.h.a.se;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

final class a$1$1
  implements av.a
{
  a$1$1(a.1 param1, int paramInt, c.c paramc) {}
  
  public final boolean JS()
  {
    y.d("MicroMsg.SubCoreTranslate", "finish translated, id: %s", new Object[] { this.pKy.id });
    if (this.bEg != 0) {
      y.e("MicroMsg.SubCoreTranslate", "translate error");
    }
    do
    {
      return true;
      if (this.pKy.ret != 0)
      {
        y.e("MicroMsg.SubCoreTranslate", "translate ret not ok : %s", new Object[] { Integer.valueOf(this.pKy.ret) });
        return true;
      }
      if (bk.bl(this.pKy.cbR))
      {
        y.e("MicroMsg.SubCoreTranslate", "translate return null");
        return true;
      }
    } while ((this.pKy.type != 0) && (this.pKy.type != 1));
    y.d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
    c.c localc = this.pKy;
    au.Hx();
    bi localbi = c.Fy().fd(bk.ZS(localc.id));
    localbi.ef(bk.pl(localc.cbR));
    localbi.field_transBrandWording = bk.pl(bk.pm(localc.cad));
    localbi.cQw = true;
    localbi.cQQ = localc.cQQ;
    localbi.cyX = true;
    if (localc.pKH == 1) {
      if (localbi.cvw()) {
        localbi.ff(localbi.czq | 0x400);
      }
    }
    for (;;)
    {
      ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(localbi.field_msgId, localbi);
      return true;
      if (localbi.cvw()) {
        localbi.ff(localbi.czq & 0xFFFFFBFF);
      }
    }
  }
  
  public final boolean JT()
  {
    if (this.bEg != 0) {}
    for (int i = this.bEg;; i = this.pKy.ret)
    {
      se localse = new se();
      localse.cbQ.ret = i;
      localse.cbQ.cbK = this.pKy.cbK;
      localse.cbQ.id = this.pKy.id;
      localse.cbQ.cbR = this.pKy.cbR;
      localse.cbQ.type = this.pKy.type;
      localse.cbQ.aWf = this.pKy.aWf;
      localse.cbQ.cad = this.pKy.cad;
      a.udP.m(localse);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.1.1
 * JD-Core Version:    0.7.0.1
 */