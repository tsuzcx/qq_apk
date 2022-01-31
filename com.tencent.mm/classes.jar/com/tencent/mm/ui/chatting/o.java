package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.q.b;

public final class o
{
  public a caz;
  public long[] zyE;
  
  public o(a parama, long[] paramArrayOfLong)
  {
    AppMethodBeat.i(30622);
    this.zyE = null;
    this.caz = parama;
    this.zyE = paramArrayOfLong;
    this.caz.zJz.removeAllOptionMenu();
    this.caz.zJz.addTextOptionMenu(2, this.caz.zJz.getMMResources().getString(2131297676), new o.1(this), null, q.b.zby);
    parama = (h)this.caz.ay(h.class);
    parama.c(new o.2(this, parama));
    AppMethodBeat.o(30622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o
 * JD-Core Version:    0.7.0.1
 */