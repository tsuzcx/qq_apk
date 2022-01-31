package com.tencent.mm.plugin.translate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

final class a$1$1
  implements az.a
{
  a$1$1(a.1 param1, int paramInt, c.c paramc) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(26048);
    ab.d("MicroMsg.SubCoreTranslate", "finish translated, id: %s", new Object[] { this.toL.id });
    if (this.val$errCode != 0)
    {
      ab.e("MicroMsg.SubCoreTranslate", "translate error");
      AppMethodBeat.o(26048);
      return true;
    }
    if (this.toL.ret != 0)
    {
      ab.e("MicroMsg.SubCoreTranslate", "translate ret not ok : %s", new Object[] { Integer.valueOf(this.toL.ret) });
      AppMethodBeat.o(26048);
      return true;
    }
    if (bo.isNullOrNil(this.toL.cKw))
    {
      ab.e("MicroMsg.SubCoreTranslate", "translate return null");
      AppMethodBeat.o(26048);
      return true;
    }
    bi localbi;
    if ((this.toL.type == 0) || (this.toL.type == 1))
    {
      ab.d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
      c.c localc = this.toL;
      aw.aaz();
      localbi = c.YC().kB(bo.apW(localc.id));
      localbi.km(bo.wC(localc.cKw));
      localbi.field_transBrandWording = bo.wC(bo.nullAsNil(localc.cID));
      localbi.dGI = true;
      localbi.dHc = localc.dHc;
      localbi.dmY = true;
      if (localc.cKx != 1) {
        break label273;
      }
      if (localbi.dya()) {
        localbi.hr(localbi.dnr | 0x400);
      }
    }
    for (;;)
    {
      ((j)g.E(j.class)).bPQ().a(localbi.field_msgId, localbi);
      AppMethodBeat.o(26048);
      return true;
      label273:
      if (localbi.dya()) {
        localbi.hr(localbi.dnr & 0xFFFFFBFF);
      }
    }
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(26047);
    if (this.val$errCode != 0) {}
    for (int i = this.val$errCode;; i = this.toL.ret)
    {
      tw localtw = new tw();
      localtw.cKv.ret = i;
      localtw.cKv.cKn = this.toL.cKn;
      localtw.cKv.id = this.toL.id;
      localtw.cKv.cKw = this.toL.cKw;
      localtw.cKv.type = this.toL.type;
      localtw.cKv.source = this.toL.source;
      localtw.cKv.cID = this.toL.cID;
      localtw.cKv.cKp = this.toL.dHc;
      localtw.cKv.cKx = this.toL.cKx;
      a.ymk.l(localtw);
      AppMethodBeat.o(26047);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.1.1
 * JD-Core Version:    0.7.0.1
 */