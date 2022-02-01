package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.bq;

public final class b
  extends f
{
  private boolean KNf;
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
      this.KNy = this.resId;
      this.KNx = this.bVF;
      AppMethodBeat.o(102933);
      return;
    }
    parama = this.contact;
    if (!this.KNf)
    {
      g.ajS();
      parama = ((l)g.ab(l.class)).azF().BH(this.username);
      this.contact = parama;
      this.KNf = true;
    }
    if (parama == null)
    {
      this.iYg = "";
      AppMethodBeat.o(102933);
      return;
    }
    this.iYg = k.b(paramContext, ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).b(parama), com.tencent.mm.cb.a.ax(paramContext, 2131165517));
    this.username = parama.field_username;
    AppMethodBeat.o(102933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.b
 * JD-Core Version:    0.7.0.1
 */