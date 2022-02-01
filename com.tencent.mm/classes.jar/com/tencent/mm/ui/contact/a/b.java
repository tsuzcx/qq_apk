package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.bg;

public final class b
  extends f
{
  private boolean GZn;
  public String bNK;
  public int resId = 0;
  
  public b(int paramInt)
  {
    super(paramInt);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102933);
    if ((this.resId != 0) && (this.bNK != null))
    {
      this.GZG = this.resId;
      this.GZF = this.bNK;
      AppMethodBeat.o(102933);
      return;
    }
    parama = this.contact;
    if (!this.GZn)
    {
      g.afC();
      parama = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.username);
      this.contact = parama;
      this.GZn = true;
    }
    if (parama == null)
    {
      this.ibW = "";
      AppMethodBeat.o(102933);
      return;
    }
    this.ibW = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).b(parama), com.tencent.mm.cd.a.ao(paramContext, 2131165517));
    this.username = parama.field_username;
    AppMethodBeat.o(102933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.b
 * JD-Core Version:    0.7.0.1
 */