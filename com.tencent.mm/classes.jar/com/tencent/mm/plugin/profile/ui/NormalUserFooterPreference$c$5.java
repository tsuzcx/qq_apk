package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;

final class NormalUserFooterPreference$c$5
  implements ao.b.a
{
  NormalUserFooterPreference$c$5(NormalUserFooterPreference.c paramc, a parama, String paramString, LinkedList paramLinkedList) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23703);
    aw.aaz();
    paramString = c.YA().arw(NormalUserFooterPreference.a(this.pCn.pCe).field_username);
    if (paramString != null) {}
    for (paramString = bo.bf(paramString.dra, "");; paramString = "")
    {
      this.pxA.amg(paramString);
      this.pxA.c(NormalUserFooterPreference.a(this.pCn.pCe).field_username, this.pxB, this.pxC);
      AppMethodBeat.o(23703);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c.5
 * JD-Core Version:    0.7.0.1
 */