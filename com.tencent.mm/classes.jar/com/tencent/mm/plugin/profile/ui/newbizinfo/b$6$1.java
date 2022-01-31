package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.n.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class b$6$1
  implements n.c
{
  b$6$1(b.6 param6) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(153582);
    if (a.je(this.pDp.pDl.contact.field_type))
    {
      if (!this.pDp.pDl.contact.Oa()) {
        break label133;
      }
      if ((!s.aWl()) || (!f.rU(this.pDp.pDl.contact.field_username))) {
        break label122;
      }
      paraml.hx(5, 2131298553);
    }
    for (;;)
    {
      paraml.hx(1, 2131298547);
      if (a.je(this.pDp.pDl.contact.field_type))
      {
        paraml.hx(2, 2131298744);
        paraml.hx(3, 2131298564);
      }
      AppMethodBeat.o(153582);
      return;
      label122:
      paraml.hx(5, 2131301406);
      continue;
      label133:
      if ((s.aWl()) && (f.rU(this.pDp.pDl.contact.field_username))) {
        paraml.hx(4, 2131298549);
      } else {
        paraml.hx(4, 2131298813);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.6.1
 * JD-Core Version:    0.7.0.1
 */