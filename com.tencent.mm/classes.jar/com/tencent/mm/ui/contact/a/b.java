package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.bv;

public final class b
  extends g
{
  private boolean Xxx;
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
      this.XxV = this.resId;
      this.XxU = this.nickName;
      AppMethodBeat.o(102933);
      return;
    }
    parama = this.contact;
    if (!this.Xxx)
    {
      h.aHH();
      parama = ((n)h.ae(n.class)).bbL().RG(this.username);
      this.contact = parama;
      this.Xxx = true;
    }
    if (parama == null)
    {
      this.mMY = "";
      AppMethodBeat.o(102933);
      return;
    }
    this.mMY = l.d(paramContext, ((com.tencent.mm.plugin.messenger.a.b)h.ae(com.tencent.mm.plugin.messenger.a.b.class)).b(parama), com.tencent.mm.ci.a.aY(paramContext, a.c.NormalTextSize));
    this.username = parama.field_username;
    AppMethodBeat.o(102933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.b
 * JD-Core Version:    0.7.0.1
 */