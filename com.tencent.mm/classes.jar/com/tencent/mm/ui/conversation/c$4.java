package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;

final class c$4
  implements bf.a
{
  c$4(PBool paramPBool, ProgressDialog paramProgressDialog, String paramString) {}
  
  public final boolean JS()
  {
    AppMethodBeat.i(34158);
    if ((this.Ahi.value) || (this.efE == null) || (!this.efE.isShowing()))
    {
      AppMethodBeat.o(34158);
      return true;
    }
    AppMethodBeat.o(34158);
    return false;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(34159);
    aw.aaz();
    ad localad = c.YA().arw(this.euc);
    localad.NE();
    if (a.je(localad.field_type)) {
      t.y(localad.field_username, false);
    }
    for (;;)
    {
      aw.aaz();
      c.YF().arF(this.euc);
      b.agX();
      b.sS(this.euc);
      if (this.efE != null) {
        this.efE.dismiss();
      }
      AppMethodBeat.o(34159);
      return;
      aw.aaz();
      c.YA().b(this.euc, localad);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c.4
 * JD-Core Version:    0.7.0.1
 */