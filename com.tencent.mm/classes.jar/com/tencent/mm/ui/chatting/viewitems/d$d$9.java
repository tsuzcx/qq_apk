package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.pluginsdk.model.app.ai;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.d.a;

final class d$d$9
  implements ai
{
  d$d$9(d.d paramd, f paramf, a parama, j.b paramb, String paramString, bi parambi) {}
  
  public final void dZ(boolean paramBoolean)
  {
    AppMethodBeat.i(153924);
    if (this.jMp != null)
    {
      if (paramBoolean)
      {
        d.d.a(this.zRK, this.iaj, this.zwo, this.jMp, this.fkH.field_msgSvrId, 3, this.zRK.getTalkerUserName());
        AppMethodBeat.o(153924);
        return;
      }
      d.d.a(this.zRK, this.iaj, this.zwo, this.jMp, this.fkH.field_msgSvrId, 7, this.zRK.getTalkerUserName());
    }
    AppMethodBeat.o(153924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.d.9
 * JD-Core Version:    0.7.0.1
 */