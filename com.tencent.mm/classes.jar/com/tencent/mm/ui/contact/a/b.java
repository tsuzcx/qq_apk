package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.bj;

public final class b
  extends f
{
  private boolean IzF;
  public String bLs;
  public int resId = 0;
  
  public b(int paramInt)
  {
    super(paramInt);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102933);
    if ((this.resId != 0) && (this.bLs != null))
    {
      this.IzY = this.resId;
      this.IzX = this.bLs;
      AppMethodBeat.o(102933);
      return;
    }
    parama = this.contact;
    if (!this.IzF)
    {
      g.agS();
      parama = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.username);
      this.contact = parama;
      this.IzF = true;
    }
    if (parama == null)
    {
      this.iCd = "";
      AppMethodBeat.o(102933);
      return;
    }
    this.iCd = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).b(parama), com.tencent.mm.cc.a.au(paramContext, 2131165517));
    this.username = parama.field_username;
    AppMethodBeat.o(102933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.b
 * JD-Core Version:    0.7.0.1
 */