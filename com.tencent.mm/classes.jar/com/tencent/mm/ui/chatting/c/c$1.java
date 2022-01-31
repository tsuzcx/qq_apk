package com.tencent.mm.ui.chatting.c;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.chatting.d.a;

final class c$1
  implements c.a
{
  c$1(c paramc) {}
  
  public final boolean dHL()
  {
    AppMethodBeat.i(31195);
    if (c.a(this.zEm) == null)
    {
      i.a(this.zEm.caz.zJz, 2131822442);
      c.a(this.zEm, (RelativeLayout)this.zEm.caz.findViewById(2131822793));
      c.a(this.zEm, (TextView)this.zEm.caz.findViewById(2131822794));
      c.b(this.zEm).setText(2131298114);
    }
    c.a(this.zEm).setVisibility(0);
    a.dJI().postDelayed(new c.1.1(this), 5000L);
    AppMethodBeat.o(31195);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.1
 * JD-Core Version:    0.7.0.1
 */