package com.tencent.mm.plugin.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;

final class a$14
  implements ao.b.a
{
  a$14(a parama, ad paramad, com.tencent.mm.pluginsdk.ui.applet.a parama1, String paramString, LinkedList paramLinkedList) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23219);
    aw.aaz();
    paramString = c.YA().arw(this.ejm.field_username);
    if (paramString != null) {}
    for (paramString = bo.bf(paramString.dra, "");; paramString = "")
    {
      this.pxA.amg(paramString);
      this.pxA.c(this.ejm.field_username, this.pxB, this.pxC);
      AppMethodBeat.o(23219);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.14
 * JD-Core Version:    0.7.0.1
 */