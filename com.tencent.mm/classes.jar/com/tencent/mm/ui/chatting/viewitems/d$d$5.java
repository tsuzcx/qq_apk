package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;

final class d$d$5
  implements am
{
  d$d$5(d.d paramd, f paramf, a parama, g.a parama1, String paramString, bi parambi) {}
  
  public final void cW(boolean paramBoolean)
  {
    if ((this.rzw != null) && (this.rzw.ZH()))
    {
      if (paramBoolean) {
        d.d.a(this.vBl, this.gBQ, this.vhu, this.rzw, this.dUy.field_msgSvrId, 3);
      }
    }
    else {
      return;
    }
    d.d.a(this.vBl, this.gBQ, this.vhu, this.rzw, this.dUy.field_msgSvrId, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.d.5
 * JD-Core Version:    0.7.0.1
 */