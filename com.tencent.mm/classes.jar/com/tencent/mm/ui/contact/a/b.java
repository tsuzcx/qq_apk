package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.bv;

public final class b
  extends f
{
  private boolean Qaf;
  public String nickName;
  public int resId = 0;
  
  public b(int paramInt)
  {
    super(paramInt);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102933);
    if ((this.resId != 0) && (this.nickName != null))
    {
      this.Qay = this.resId;
      this.Qax = this.nickName;
      AppMethodBeat.o(102933);
      return;
    }
    parama = this.contact;
    if (!this.Qaf)
    {
      g.aAi();
      parama = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.username);
      this.contact = parama;
      this.Qaf = true;
    }
    if (parama == null)
    {
      this.jVL = "";
      AppMethodBeat.o(102933);
      return;
    }
    this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, ((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(parama), com.tencent.mm.cb.a.aG(paramContext, 2131165535));
    this.username = parama.field_username;
    AppMethodBeat.o(102933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.b
 * JD-Core Version:    0.7.0.1
 */