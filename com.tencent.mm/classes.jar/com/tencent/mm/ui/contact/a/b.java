package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.bp;

public final class b
  extends f
{
  private boolean KqL;
  public String bVF;
  public int resId = 0;
  
  public b(int paramInt)
  {
    super(paramInt);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102933);
    if ((this.resId != 0) && (this.bVF != null))
    {
      this.Kre = this.resId;
      this.Krd = this.bVF;
      AppMethodBeat.o(102933);
      return;
    }
    parama = this.contact;
    if (!this.KqL)
    {
      g.ajD();
      parama = ((l)g.ab(l.class)).azp().Bf(this.username);
      this.contact = parama;
      this.KqL = true;
    }
    if (parama == null)
    {
      this.iVn = "";
      AppMethodBeat.o(102933);
      return;
    }
    this.iVn = k.b(paramContext, ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).b(parama), com.tencent.mm.cc.a.ax(paramContext, 2131165517));
    this.username = parama.field_username;
    AppMethodBeat.o(102933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.b
 * JD-Core Version:    0.7.0.1
 */