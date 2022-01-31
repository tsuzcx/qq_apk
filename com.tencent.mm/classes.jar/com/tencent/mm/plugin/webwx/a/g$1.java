package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.h.a.oz;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class g$1
  implements bx.a
{
  g$1(g paramg) {}
  
  public final void a(e.a parama)
  {
    String str = (String)bn.s(aa.a(parama.dBs.svH), "sysmsg").get(".sysmsg.pushloginurl.url");
    if (bk.bl(str)) {
      y.e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
    }
    oz localoz = new oz();
    localoz.bYC.bYD = str;
    localoz.bYC.type = 1;
    a.udP.m(localoz);
    parama.dBs.svL = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.g.1
 * JD-Core Version:    0.7.0.1
 */