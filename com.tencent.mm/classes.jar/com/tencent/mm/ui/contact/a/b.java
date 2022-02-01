package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.bx;

public final class b
  extends g
{
  private boolean afjG;
  public String nickName;
  private int resId = 0;
  
  public b(int paramInt)
  {
    super(paramInt);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102933);
    if ((this.resId != 0) && (this.nickName != null))
    {
      this.afkc = this.resId;
      this.afkb = this.nickName;
      AppMethodBeat.o(102933);
      return;
    }
    parama = this.contact;
    if (!this.afjG)
    {
      h.baF();
      parama = ((n)h.ax(n.class)).bzA().JE(this.username);
      this.contact = parama;
      this.afjG = true;
    }
    if (parama == null)
    {
      this.pJG = "";
      AppMethodBeat.o(102933);
      return;
    }
    this.pJG = p.d(paramContext, ((com.tencent.mm.plugin.messenger.a.b)h.ax(com.tencent.mm.plugin.messenger.a.b.class)).b(parama), com.tencent.mm.cd.a.br(paramContext, a.c.NormalTextSize));
    this.username = parama.field_username;
    AppMethodBeat.o(102933);
  }
  
  public final void eg(int paramInt, String paramString)
  {
    this.resId = paramInt;
    this.nickName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.b
 * JD-Core Version:    0.7.0.1
 */