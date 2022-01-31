package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

final class g$1
  implements bz.a
{
  g$1(g paramg) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(26508);
    String str = (String)br.F(aa.a(parama.eyJ.woR), "sysmsg").get(".sysmsg.pushloginurl.url");
    if (bo.isNullOrNil(str)) {
      ab.e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
    }
    qb localqb = new qb();
    localqb.cGD.cGE = str;
    localqb.cGD.type = 1;
    a.ymk.l(localqb);
    parama.eyJ.woV = null;
    AppMethodBeat.o(26508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.g.1
 * JD-Core Version:    0.7.0.1
 */