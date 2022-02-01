package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.h.c.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;

final class n$6
  implements c.a
{
  n$6(cc paramcc, long paramLong, String paramString) {}
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
  {
    AppMethodBeat.i(244873);
    if (Util.isNullOrNil(paramString4))
    {
      this.oiL.setStatus(5);
      bh.bCz();
      c.bzD().a(this.oiL.field_msgId, this.oiL);
      paramString2 = new cc();
      paramString2.setCreateTime(br.JN(paramString2.field_talker));
      paramString2.BS(paramString2.field_talker);
      paramString2.setContent(paramString1);
      paramString2.setType(10000);
      paramString2.setStatus(6);
      paramString2.pI(0);
      bh.bCz();
      c.bzD().ba(paramString2);
      AppMethodBeat.o(244873);
      return;
    }
    as.iIL();
    paramLong = this.hkO;
    paramString1 = this.rma;
    this.oiL.getType();
    ar.a.j(paramLong, paramString1, paramString4);
    AppMethodBeat.o(244873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.n.6
 * JD-Core Version:    0.7.0.1
 */