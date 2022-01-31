package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.bd;

public final class b
  extends f
{
  private boolean AfU;
  public String blZ;
  public int resId = 0;
  
  public b(int paramInt)
  {
    super(paramInt);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(105269);
    if ((this.resId != 0) && (this.blZ != null))
    {
      this.Agj = this.resId;
      this.Agi = this.blZ;
      AppMethodBeat.o(105269);
      return;
    }
    parama = this.contact;
    if (!this.AfU)
    {
      g.RM();
      parama = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.username);
      this.contact = parama;
      this.AfU = true;
    }
    if (parama == null)
    {
      this.gpH = "";
      AppMethodBeat.o(105269);
      return;
    }
    this.gpH = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, ((com.tencent.mm.plugin.messenger.a.b)g.E(com.tencent.mm.plugin.messenger.a.b.class)).c(parama), com.tencent.mm.cb.a.ao(paramContext, 2131427809));
    this.username = parama.field_username;
    AppMethodBeat.o(105269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.b
 * JD-Core Version:    0.7.0.1
 */