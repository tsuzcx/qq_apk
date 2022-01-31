package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;

public final class d
  extends f
{
  public CharSequence AfY;
  public boolean AfZ;
  private d.a Aga;
  public ad contact;
  
  public d(int paramInt, ad paramad)
  {
    super(paramInt);
    AppMethodBeat.i(105277);
    this.Aga = new d.a(this);
    this.contact = paramad;
    if (paramad.dqC == 1) {}
    for (;;)
    {
      this.AfZ = bool;
      AppMethodBeat.o(105277);
      return;
      bool = false;
    }
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    boolean bool = true;
    AppMethodBeat.i(105278);
    super.a(paramContext, parama);
    if (this.contact.dqC == 1) {}
    for (;;)
    {
      this.AfZ = bool;
      this.AfY = ((c)g.E(c.class)).YJ().oV(this.contact.field_username).nE(this.contact.field_username);
      AppMethodBeat.o(105278);
      return;
      bool = false;
    }
  }
  
  public final a.b aoY()
  {
    return this.Aga;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.d
 * JD-Core Version:    0.7.0.1
 */